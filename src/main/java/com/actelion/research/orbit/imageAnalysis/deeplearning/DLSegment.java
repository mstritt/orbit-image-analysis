/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2018 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.actelion.research.orbit.imageAnalysis.deeplearning;

import com.actelion.research.orbit.beans.RawAnnotation;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.imaging.TileSizeWrapper;
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.tasks.ExclusionMapGen;
import com.actelion.research.orbit.imageAnalysis.utils.*;
import ij.ImagePlus;
import imageJ.BinaryOrbit;
import imageJ.Colour_Deconvolution;
import imageJ.ThresholderOrbit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import javax.imageio.ImageIO;
import javax.media.jai.PlanarImage;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

/**
 * Deep Learning segmentation helper methods.
 */
public class DLSegment {

    private static final Logger logger = LoggerFactory.getLogger(DLSegment.class);
    public static int SEGMENTWIDTH = 512;
    public static int SEGMENTHEIGHT = 512;
    public static String debugImagePath = "d:/temp";
    public static boolean deconvolution = false;
    public static String deconvolution_name = "H DAB";
    public static int deconvolution_channel = 1;
    private static final int DESIRED_TILE_SIZE = 512;
    public static boolean SEGMENTATION_REFINEMENT = true;
    public static int segmentNr = 0;

    public static Map<Integer,List<Shape>> generateSegmentationAnnotations(int[] images, Session s, OrbitModel segModel,  OrbitModel modelContainingExclusionModel, boolean storeAnnotations) throws Exception {
        List<RawDataFile> rdfList = new ArrayList<>(images.length);
        for (int i=0; i<images.length; i++) {
            rdfList.add(DALConfig.getImageProvider().LoadRawDataFile(images[i]));
        }
        return generateSegmentationAnnotations(rdfList,s,segModel,modelContainingExclusionModel,storeAnnotations);
    }


    public static Map<Integer,List<Shape>> generateSegmentationAnnotations(List<RawDataFile> rdfList, Session s, OrbitModel segModel, OrbitModel modelContainingExclusionModel, boolean storeAnnotations) throws Exception {
        Map<Integer,List<Shape>> segmentationsPerImage = new HashMap<>();
        for (RawDataFile rdf: rdfList) {
            long startt = System.currentTimeMillis();
            OrbitTiledImage2.resetTileCache();
            int rdfId = rdf.getRawDataFileId();
            logger.info("rdfid: " + rdfId);
            List<Shape> segmentationShapes = new ArrayList<>();
            List<RawAnnotation> annotations = DALConfig.getImageProvider().LoadRawAnnotationsByRawDataFile(rdfId, RawAnnotation.ANNOTATION_TYPE_IMAGE);
            List<ImageAnnotation> rois = new ArrayList<>();
            List<Shape> exclusions = new ArrayList<>();
            List<Shape> inclusions = new ArrayList<>();
            for (RawAnnotation annotation: annotations) {
                ImageAnnotation ia = new ImageAnnotation(annotation);
                if (ia.getSubType() == ImageAnnotation.SUBTYPE_ROI) rois.add(ia);
                else if (ia.getSubType() == ImageAnnotation.SUBTYPE_EXCLUSION) exclusions.add(ia.getFirstShape());
            }
            RecognitionFrame rf = new RecognitionFrame(rdf);
            TileSizeWrapper tileSizeWrapper = new TileSizeWrapper(new OrbitImagePlanar(rf.bimg.getImage(), ""), 1024, 1024);
            OrbitTiledImageIOrbitImage orbitImage = new OrbitTiledImageIOrbitImage(tileSizeWrapper);
            ExclusionMapGen exclusionMapGen = null;
            if (modelContainingExclusionModel!=null && modelContainingExclusionModel.getExclusionModel()!=null) {
                exclusionMapGen = ExclusionMapGen.constructExclusionMap(rdf,rf,modelContainingExclusionModel);
                if (exclusionMapGen!=null) {
                    exclusionMapGen.generateMap();
                }
            }

            List<Shape> roiDefList = new ArrayList<>();
            for (ImageAnnotation roiAnnotation: rois) {
                IScaleableShape roiShape = (IScaleableShape)roiAnnotation.getFirstShape();
                roiShape = (IScaleableShape)roiShape.getScaledInstance(100d, new Point(0, 0));
                ShapeAnnotationList roiDef = new ShapeAnnotationList(inclusions, exclusions, roiShape, roiShape.getBounds());
                roiDefList.add(roiDef);
            }
            if (roiDefList.size()==0) {   // no ROI annotations, so create one around the whole image
                 roiDefList.add(new RectangleExt(0,0,rf.bimg.getWidth(),rf.bimg.getHeight()));
            }

            for (Shape roiDef: roiDefList) {
                Point[] tiles = orbitImage.getTileIndices(roiDef.getBounds());
                int tileNr=0;
                for (Point tile: tiles) {
                    tileNr++;
                    logger.trace("tile "+tileNr+" of "+tiles.length);
                   // if (!(tile.x==15 && tile.y==12)) continue;   // for testing: just on one tile
                    if (OrbitUtils.isTileInROI(tile.x, tile.y, orbitImage, roiDef, exclusionMapGen)) {
                        // source image
                        SegmentationResult segRes = DLSegment.segmentTile(tile.x, tile.y, orbitImage, s, segModel, false);
                        int minX = orbitImage.tileXToX(tile.x);
                        int minY = orbitImage.tileYToY(tile.y);
                        logger.info("ObjectCount: "+segRes.getObjectCount()+" for tile "+tile.x+" x "+tile.y);
                        if (SEGMENTATION_REFINEMENT) {
                            for (Shape segShape: segRes.getShapeList()) {
                                PolygonExt scaleShape = (PolygonExt) segShape;
                                PolygonMetrics polyMetrics = new PolygonMetrics(scaleShape);
                                scaleShape = scaleShape.scale(200d, polyMetrics.getCenter());
                                scaleShape.translate(minX, minY);
                                Point2D center = polyMetrics.getCenter();
                                scaleShape.translate((int) center.getX(), (int) center.getY());
                                PolygonMetrics pm2 = new PolygonMetrics(scaleShape);
                                center = pm2.getCenter();

                                //segmentationShapes.add(scaleShape);     // enable?

                                // re-segment
                                int startx = (int) (center.getX() - 512);
                                int starty = (int) (center.getY() - 512);
                                if (startx < 0) startx = 0;
                                if (starty < 0) starty = 0;
                                if (startx + 1024 >= orbitImage.getWidth()) startx = orbitImage.getWidth() - 1025;
                                if (starty + 1024 >= orbitImage.getHeight()) starty = orbitImage.getHeight() - 1025;
                                Rectangle rect = new Rectangle(startx, starty, 1024, 1024);
                                Raster rasterCenter = orbitImage.getData(rect);
                                SegmentationResult segCenter = DLSegment.segmentRaster(rasterCenter, orbitImage, s, segModel, false);
                                if (segCenter.getObjectCount() > 0) {
                                    // find center shape
                                    Point centerP = new Point(256, 256);
                                    Shape centerShape = segCenter.getShapeList().get(0);
                                    double dist = 1024;
                                    for (Shape shape2 : segCenter.getShapeList()) {
                                        PolygonMetrics pm = new PolygonMetrics((Polygon) shape2);
                                        double d = pm.getCenter().distance(centerP);
                                        if (d < dist) {
                                            centerShape = shape2;
                                            dist = d;
                                        }
                                    }
                                    PolygonExt scaleShape2 = (PolygonExt) centerShape;
                                    PolygonMetrics polyMetrics2 = new PolygonMetrics(scaleShape2);
                                    scaleShape2 = scaleShape2.scale(200d, polyMetrics2.getCenter());
                                    scaleShape2.translate(startx, starty);
                                    Point2D center2 = polyMetrics2.getCenter();
                                    scaleShape2.translate((int) center2.getX(), (int) center2.getY());

                                    PolygonMetrics pm = new PolygonMetrics(scaleShape2);
                                    Point2D centerScaled = pm.getCenter();
                                    if (OrbitUtils.isInROI((int)centerScaled.getX(),(int)centerScaled.getY(),roiDef,exclusionMapGen)) {
                                        segmentationShapes.add(scaleShape2);
                                    }
                                }
                            }
                        }

                    }
                }
            }

            logger.info("shapes before filtering: " + segmentationShapes.size());
            segmentationShapes = DLSegment.filterShapes(segmentationShapes);
            logger.info("shapes after filtering: " + segmentationShapes.size());
            if (storeAnnotations) {
                logger.info("storing annotations in DB");
                DLSegment.storeShapes(segmentationShapes, "Objects", rdfId, "orbit");
            }
            segmentationsPerImage.put(rdfId,segmentationShapes);
            long usedt = System.currentTimeMillis() - startt;
            logger.info("used time(h) for image: " + (usedt / 60000) / 60);
        }
        return segmentationsPerImage;
    }




    public static SegmentationResult segmentTile(int tileX, int tileY, OrbitTiledImageIOrbitImage orbitImage, Session s, OrbitModel segModel, boolean writeImg) throws Exception {
        Raster tileRaster = orbitImage.getTile(tileX, tileY);
        //BufferedImage ori = new BufferedImage(orbitImage.getColorModel(), (WritableRaster) tileRaster.createTranslatedChild(0,0), false, null);
        //ImageIO.write(ori, "jpeg", new File(path + File.separator +"tile" + tileX + "x" + tileY + "_ori1.jpg"));

        BufferedImage maskOriginal = maskRaster(tileRaster,orbitImage, s, writeImg);

        int factor = 2;
        maskOriginal = getShiftedMask(orbitImage, s, tileRaster, maskOriginal, factor, 0, 512, false);
        maskOriginal = getShiftedMask(orbitImage, s, tileRaster, maskOriginal, factor, 0, -512, false);
        maskOriginal = getShiftedMask(orbitImage, s, tileRaster, maskOriginal, factor, 512, 0, false);
        maskOriginal = getShiftedMask(orbitImage, s, tileRaster, maskOriginal, factor, -512, 0, false);
       // maskOriginal = getShiftedMask(orbitImage, s, tileRaster, maskOriginal, factor, 0, 0, true);

        //ImageIO.write(maskOriginal, "jpeg", new File(path + File.separator +"tile" + tileX + "x" + tileY + "_seg1.jpg"));
        SegmentationResult segmentationResult = getSegmentationResult(segModel, maskOriginal);
        return segmentationResult;
    }

    private static BufferedImage getShiftedMask(OrbitTiledImageIOrbitImage orbitImage,Session s, Raster tileRaster, BufferedImage maskOriginal, int factor, int dx, int dy, boolean flip) throws Exception {
        Rectangle rect = tileRaster.getBounds();
        rect.translate(dx,dy);
        if (!orbitImage.getBounds().contains(rect)) {
            return maskOriginal;
        }
        try {
            Raster shiftraster = orbitImage.getData(rect);
            if (flip) {
                shiftraster = flipRaster(shiftraster);
            }
            BufferedImage mask2 = maskRaster(shiftraster, orbitImage, s, false);
            if (flip) {
                mask2 = flipImage(mask2);
            }
            maskOriginal = combineMasks(maskOriginal, mask2, dx / factor, dy / factor);
        } catch (Exception e) {
            logger.warn("Could not shift raster, returning original image (rect="+rect+" img.bounds="+orbitImage.getBounds()+")", e);
        }
        return maskOriginal;
    }


    private static BufferedImage flipImage(BufferedImage bi) {
        return new BufferedImage(bi.getColorModel(),(WritableRaster) flipRaster(bi.getData()),false,null);
    }

    private static Raster flipRaster(Raster r) {
        int w = r.getWidth();
        int h = r.getHeight();
        WritableRaster rf = r.createCompatibleWritableRaster(r.getMinX(),r.getMinY(), w,h);
        int[] p = new int[w*3];
        for (int y=r.getMinY(); y<r.getMinY()+h; y++) {
            p = r.getPixels(r.getMinX(),y,w,1,p);
            rf.setPixels(r.getMinX(),r.getMinY()+h-(y-r.getMinY())-1,w,1,p);
        }
        return rf;
    }

    private static BufferedImage combineMasks(BufferedImage m1, BufferedImage m2, int dx, int dy) {
        BufferedImage combined = new BufferedImage(m1.getWidth(),m1.getHeight(),m1.getType());
        combined.getGraphics().drawImage(m1,0,0,null);
        int fg = Color.white.getRGB();
        Raster r2 = m2.getRaster();
        int minx = -dx<0?0:-dx;
        int miny = -dy<0?0:-dy;
        int maxx = m2.getWidth()-dx<m2.getWidth()?m2.getWidth()-dx:m2.getWidth();
        int maxy = m2.getHeight()-dy<m2.getHeight()?m2.getHeight()-dy:m2.getHeight();
        
        for (int x=minx; x<maxx; x++)
            for (int y=miny; y<maxy; y++) {
                if (r2.getSample(x,y,0)>0) {
                    combined.setRGB(x+dx,y+dy,fg);
                }
            }
        return combined;
    }

    public static SegmentationResult segmentRaster(Raster inputTileRaster, OrbitTiledImageIOrbitImage orbitImage, Session s, OrbitModel segModel, boolean writeImg) throws Exception {
        BufferedImage segmented = maskRaster(inputTileRaster,orbitImage, s, writeImg);
        return getSegmentationResult(segModel, segmented);
    }

    public static BufferedImage maskRaster(Raster inputTileRaster, OrbitTiledImageIOrbitImage orbitImage, Session s, boolean writeImg) throws Exception {
        WritableRaster tileRaster = (WritableRaster) inputTileRaster.createTranslatedChild(0, 0);
        BufferedImage ori = new BufferedImage(orbitImage.getColorModel(), tileRaster, false, null);
        ori = shrink(ori);

        // color-deconvolution
        if (deconvolution) {
            ori = Colour_Deconvolution.getProcessedImage(ori, deconvolution_name, deconvolution_channel - 1, ori);
        }

        int tx = orbitImage.XToTileX(inputTileRaster.getMinX());
        int ty = orbitImage.YToTileY(inputTileRaster.getMinY());
        if (writeImg) {
            ImageIO.write(ori, "jpeg", new File(debugImagePath + File.separator +"tile" + tx + "x" + ty + ".jpg"));
        }

        Tensor<Float> inputTensor = DLSegment.convertBufferedImageToTensor(ori);
        long startt = System.currentTimeMillis();
        BufferedImage segmented = DLSegment.segmentInput(inputTensor, s, Color.black, Color.white);
        long usedt = System.currentTimeMillis()-startt;
        System.out.println("segment time (s): "+usedt/1000d);

        if (false) {
            ImagePlus ip = new ImagePlus("img", segmented);
            ip.getProcessor().setBinaryThreshold();
            ThresholderOrbit thresh = new ThresholderOrbit();
            thresh.applyThreshold(ip);
            BinaryOrbit binaryOrbit = new BinaryOrbit();
            binaryOrbit.setup("close", ip);
            binaryOrbit.run(ip.getProcessor().convertToByte(false));
            binaryOrbit.setup("fill Holes", ip);
            binaryOrbit.run(ip.getProcessor().convertToByte(false));
            ip.getProcessor().invert();
            ip = new ImagePlus("img", ip.getProcessor().convertToRGB());
            segmented = ip.getBufferedImage();
        }

        //ImageIO.write(segmented, "jpeg", new File(path + File.separator +"tile" + tx + "x" + ty + "_seg.jpg"));

       return segmented;
    }

    public static SegmentationResult getSegmentationResult(OrbitModel segModel, BufferedImage segmented) throws Exception {
        IOrbitImage segimg = new OrbitImagePlanar(PlanarImage.wrapRenderedImage(segmented), "segmented");
        RecognitionFrame rfSeg = new RecognitionFrame(segimg, "segmented");
        List<Point> tl = new ArrayList<>();
        tl.add(new Point(-1, -1));
        SegmentationResult segRes = OrbitHelper.Segmentation(rfSeg, 0, segModel, tl, 1, false);
        return segRes;
    }

    public static BufferedImage shrink(BufferedImage bi) {
        BufferedImage bi2 = new BufferedImage(SEGMENTWIDTH, SEGMENTHEIGHT,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) bi2.getGraphics();
        g.drawImage(bi,0,0,SEGMENTWIDTH,SEGMENTHEIGHT,null);
        g.dispose();
        return bi2;
    }


    public static void storeShape(Shape shape, String name, int rdfId, String user) throws Exception {
        ClassShape classShape = new ClassShape(name, Color.green, ClassShape.SHAPETYPE_POLYGONEXT);
        classShape.getShapeList().add(shape);
        SpotAnnotation spot = new CellDetectionAnnotation(name, classShape);
        spot.setRawDataFileId(rdfId);
        spot.setUserId(user);
        DALConfig.getImageProvider().InsertRawAnnotation(spot);
    }

    public static void storeShapes(List<Shape> shapes, String basename, int rdfId, String user) throws Exception {
        int total = 0;
        for (Shape shape: shapes) {
            total++;
            storeShape(shape,basename+"_"+total,rdfId,user);
        }
    }

    public static List<Shape> filterShapes(List<Shape> shapes) {
        List<Shape> filtered = new ArrayList<>(shapes.size());
        HashSet<Integer> duplicates = new HashSet<>();
        for (int i = 0; i < shapes.size(); i++) {
            if (!duplicates.contains(i)) {
                Shape s1 = shapes.get(i);
                for (int j = 0; j < shapes.size(); j++) {
                    if (i!=j) {
                        Shape s2 = shapes.get(j);
                        if (s1 instanceof PolygonExt) {
                            PolygonExt p1o = (PolygonExt) s1;
                            //PolygonExt p2o = (PolygonExt) s2;
                            PolygonExt p1 = (PolygonExt) s1;
                            PolygonExt p2 = (PolygonExt) s2;
                            PolygonMetrics pm1 = new PolygonMetrics(p1);
                            p1 = p1.scale(120d, pm1.getCenter());
                            if (p1.contains(p2)) {
                                int dup = j;
                                PolygonMetrics pm2 = new PolygonMetrics(p2);
                                p2 = p2.scale(120d, pm2.getCenter());
                                if (p2.contains(p1o)) {
                                    // take bigger one
                                    if (pm2.getArea()>pm1.getArea()) {
                                        dup = i;
                                    }
                                }       
                                duplicates.add(dup);
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < shapes.size(); i++) {
            Shape s = shapes.get(i);
            if (!duplicates.contains(i)) {
                filtered.add(s);
            }
        }

        return filtered;
    }


    /**
     * TF helper methods
     */


    private static BufferedImage decodeLabels(long[] mask, Color bg, Color fg) {
//		int[][] label_colours = {
//				new int[] { 0, 0, 0 },
//				new int[] { 255, 255, 255 } //Glomeruli
//				};
        int[][] label_mask = convert1DVectorTo2D(mask, DESIRED_TILE_SIZE, DESIRED_TILE_SIZE);
        BufferedImage image = new BufferedImage(DESIRED_TILE_SIZE, DESIRED_TILE_SIZE, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < image.getWidth(); y++) {
            for (int x = 0; x < image.getHeight(); x++) {
//				Color color = new Color(label_colours[label_mask[y][x]][0],
//						label_colours[label_mask[y][x]][1],
//						label_colours[label_mask[y][x]][2]);
                Color color = label_mask[y][x]==0? bg : fg;
                image.setRGB(x, y, color.getRGB());
            }
        }
        return image;
    }

    public static int[][] convert1DVectorTo2D(long[] values, int rows, int cols) {
        int[][] array = new int[rows][cols];
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < cols; i++) {
                array[j][i] = (int) values[j * cols + i];
            }
        }
        return array;
    }

    public static Tensor<Float> convertBufferedImageToTensor(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[] data = new int[width * height];
        image.getRGB(0, 0, width, height, data, 0, width);
        float[][][][] rgbArray = new float[1][height][width][3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color color = new Color(data[i * width + j]);
                rgbArray[0][i][j][0] = color.getRed();
                rgbArray[0][i][j][1] = color.getGreen();
                rgbArray[0][i][j][2] = color.getBlue();
            }
        }
        return Tensor.create(rgbArray, Float.class);
    }


    private static long[] executeInceptionGraph(byte[] graphDef, Tensor<Float> input) {
        try (Graph g = new Graph()) {
            g.importGraphDef(graphDef);
            try (Session s = new Session(g);
                 Tensor<Long> result = s
                         .runner()
                         .feed("image_batch", input)
                         .fetch("predictions")
                         .run().get(0).expect(Long.class)) {
                return result.copyTo(new long[result.numElements()]);
            }
        }
    }

    public static Session buildSession(String fileName) {
        byte[] graphDef = readAllBytesOrExit(Paths.get(fileName));
        return buildSessionBytes(graphDef);
    }

    public static Session buildSession(URL modelUrl) {
        byte[] graphDef = OrbitUtils.getContentBytes(modelUrl);
        return buildSessionBytes(graphDef);
    }

    public static Session buildSessionBytes(byte[] graphDef) {
        Graph g = new Graph();
        g.importGraphDef(graphDef);
        Session s = new Session(g);
        return s;
    }


    public static BufferedImage segmentInput(final Tensor<Float> inputTensor, Session s, Color bg, Color fg) {
        Tensor<Long> outputTensor = s
                .runner()
                .feed("image_batch", inputTensor)
                .fetch("predictions")
                .run().get(0).expect(Long.class);

        long[] mask = outputTensor.copyTo(new long[outputTensor.numElements()]);
//        for (long l : mask) {
//            if (l > 0) {
//                System.out.println(l);
//            }
//
//        }
        BufferedImage bufferedImage = decodeLabels(mask,bg,fg);
        return bufferedImage;
    }

    private static byte[] readAllBytesOrExit(Path path) {
        try {
            return Files.readAllBytes(path);
        } catch (IOException e) {
            System.err.println("Failed to read [" + path + "]: " + e.getMessage());
            System.exit(1);
        }
        return null;
    }



    /**
     * Demo main methods for testing
     */

//    private static final String DEMO_MODEL_NAME = "D:\\data\\glomeruli\\20180202_glomeruli_detection_noquant.pb";
//    private static final String INPUT_IMAGE = "D:\\data\\glomeruli\\input5c.jpg";
    private static final String DEMO_MODEL_NAME = "D:/deeplearning/glomeruli/20180202_glomeruli_detection_noquant.pb";
    private static final String INPUT_IMAGE = "D:/deeplearning/glomeruli/test2.png";
    private static final String DEMO_OUTPUT_IMAGE = INPUT_IMAGE.replaceAll(".png","_seg.jpg");

    public static void main(String[] args) throws IOException {
        Session s = DLSegment.buildSession(DEMO_MODEL_NAME);

        BufferedImage sourceImage = ImageIO.read(new File(INPUT_IMAGE));
        BufferedImage bi1 = new BufferedImage(1024,1024,BufferedImage.TYPE_INT_RGB);
        bi1.getGraphics().drawImage(sourceImage,0,0,null);
//        bi1.getGraphics().drawImage(sourceImage,512,0,null);
//        bi1.getGraphics().drawImage(sourceImage,0,512,null);
//        bi1.getGraphics().drawImage(sourceImage,512,512,null);
        BufferedImage bi2 = new BufferedImage(512,512,BufferedImage.TYPE_INT_RGB);
        bi2.getGraphics().drawImage(bi1,0,0,512,512,null);
        sourceImage = bi2;

        Tensor<Float> inputTensor = convertBufferedImageToTensor(sourceImage);
        BufferedImage bufferedImage =  DLSegment.segmentInput(inputTensor,s, Color.black, Color.green);
        s.close();

        BufferedImage bi3 = new BufferedImage(512,512,BufferedImage.TYPE_INT_RGB);
        bi3.getGraphics().drawImage(bufferedImage,0,0,1024,1024,null);

        ImageIO.write(bi3, "jpg", new File(DEMO_OUTPUT_IMAGE));
    }


    public static void main2(String[] args) throws IOException {
        DLSegment segment = new DLSegment();
        Session s = DLSegment.buildSession(DEMO_MODEL_NAME);
        //byte[] image = readAllBytesOrExit(Paths.get(INPUT_IMAGE));
        BufferedImage inputImage = ImageIO.read(new File(INPUT_IMAGE));
        Tensor<Float> inputTensor = convertBufferedImageToTensor(inputImage);
        BufferedImage bufferedImage =  DLSegment.segmentInput(inputTensor,s, Color.black, Color.green);
        s.close();
        ImageIO.write(bufferedImage, "jpg", new File(DEMO_OUTPUT_IMAGE));
    }



    public static void main4(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        PolygonExt p = new PolygonExt();
        p.addPoint(0,0);
        p.addPoint(10,0);
        p.addPoint(10,10);
        p.addPoint(0,0);

        PolygonExt p3 = new PolygonExt();
        p3.addPoint(0,0);
        p3.addPoint(11,0);
        p3.addPoint(11,11);
        p3.addPoint(0,0);


        PolygonExt p1 = new PolygonExt();
        p1.addPoint(3,3);
        p1.addPoint(7,0);
        p1.addPoint(7,7);
        p1.addPoint(3,3);

        PolygonExt p2 = new PolygonExt();
        p2.addPoint(30,30);
        p2.addPoint(70,30);
        p2.addPoint(70,70);
        p2.addPoint(30,30);


        shapes.add(p);
        shapes.add(p1);
        shapes.add(p2);
        shapes.add(p3);

        shapes = DLSegment.filterShapes(shapes);
        System.out.println("size: "+shapes.size());
        for (Shape shape: shapes) {
            PolygonExt poly = (PolygonExt) shape;
            System.out.println(poly.listPoints());
        }

    }

}
