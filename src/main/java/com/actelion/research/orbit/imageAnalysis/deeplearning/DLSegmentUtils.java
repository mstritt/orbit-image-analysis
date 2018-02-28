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

import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitHelper;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitImagePlanar;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImageIOrbitImage;
import com.actelion.research.orbit.imageAnalysis.utils.PolygonMetrics;
import ij.ImagePlus;
import imageJ.BinaryOrbit;
import imageJ.Colour_Deconvolution;
import imageJ.ThresholderOrbit;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import javax.imageio.ImageIO;
import javax.media.jai.PlanarImage;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DLSegmentUtils {

    public static int SEGMENTWIDTH = 512;
    public static int SEGMENTHEIGHT = 512;
    public static String path = "d:/NoBackup/glomeruli/seg";
    public static boolean deconvolution = true;
    public static String deconvolution_name = "H DAB";
    public static int deconvolution_channel = 1;


    public static SegmentationResult segmentTile(int tileX, int tileY, OrbitTiledImageIOrbitImage orbitImage, DLSegment2 segment, Session s, OrbitModel segModel, boolean writeImg) throws Exception {
        Raster tileRaster = orbitImage.getTile(tileX, tileY);
        //BufferedImage ori = new BufferedImage(orbitImage.getColorModel(), (WritableRaster) tileRaster.createTranslatedChild(0,0), false, null);
        //ImageIO.write(ori, "jpeg", new File(path + File.separator +"tile" + tileX + "x" + tileY + "_ori1.jpg"));

        BufferedImage maskOriginal = maskRaster(tileRaster,orbitImage, segment, s, writeImg);

        int factor = 2;
        maskOriginal = getShiftedMask(orbitImage, segment, s, segModel, tileRaster, maskOriginal, factor, 0, 512);
        maskOriginal = getShiftedMask(orbitImage, segment, s, segModel, tileRaster, maskOriginal, factor, 0, -512);
        maskOriginal = getShiftedMask(orbitImage, segment, s, segModel, tileRaster, maskOriginal, factor, 512, 0);
        maskOriginal = getShiftedMask(orbitImage, segment, s, segModel, tileRaster, maskOriginal, factor, -512, 0);

        //ImageIO.write(maskOriginal, "jpeg", new File(path + File.separator +"tile" + tileX + "x" + tileY + "_seg1.jpg"));
        SegmentationResult segmentationResult = getSegmentationResult(segModel, maskOriginal);
        return segmentationResult;
    }

    public static BufferedImage getShiftedMask(OrbitTiledImageIOrbitImage orbitImage, DLSegment2 segment, Session s, OrbitModel segModel, Raster tileRaster, BufferedImage maskOriginal, int factor, int dx, int dy) throws Exception {
        Rectangle rect = tileRaster.getBounds();
        rect.translate(dx,dy);
        Raster shiftraster = orbitImage.getData(rect);
        BufferedImage mask2 = maskRaster(shiftraster, orbitImage, segment, s, false);
        maskOriginal = combineMasks(maskOriginal,mask2,dx/factor,dy/factor);
        return maskOriginal;
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

    public static SegmentationResult segmentRaster(Raster inputTileRaster, OrbitTiledImageIOrbitImage orbitImage, DLSegment2 segment, Session s, OrbitModel segModel, boolean writeImg) throws Exception {
        BufferedImage segmented = maskRaster(inputTileRaster,orbitImage, segment, s, writeImg);
        return getSegmentationResult(segModel, segmented);
    }

    public static BufferedImage maskRaster(Raster inputTileRaster, OrbitTiledImageIOrbitImage orbitImage, DLSegment2 segment, Session s, boolean writeImg) throws Exception {
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
            ImageIO.write(ori, "jpeg", new File(path + File.separator +"tile" + tx + "x" + ty + ".jpg"));
        }

        Tensor<Float> inputTensor = DLSegment2.convertBufferedImageToTensor(ori);
        long startt = System.currentTimeMillis();
        BufferedImage segmented = segment.segmentInput(inputTensor, s, Color.black, Color.white);
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


    public static void main(String[] args) {
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

        shapes = DLSegmentUtils.filterShapes(shapes);
        System.out.println("size: "+shapes.size());
        for (Shape shape: shapes) {
            PolygonExt poly = (PolygonExt) shape;
            System.out.println(poly.listPoints());
        }

    }

}
