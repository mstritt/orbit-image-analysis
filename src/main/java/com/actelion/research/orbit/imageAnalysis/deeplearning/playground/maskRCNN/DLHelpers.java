/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2020 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
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

package com.actelion.research.orbit.imageAnalysis.deeplearning.playground.maskRCNN;

import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.deeplearning.DLSegment;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.models.PolygonExt;
import com.actelion.research.orbit.imageAnalysis.models.RectangleExt;
import com.actelion.research.orbit.imageAnalysis.models.SegmentationResult;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitHelper;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitImagePlanar;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImageIOrbitImage;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
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
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.FloatBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

import static com.actelion.research.orbit.imageAnalysis.deeplearning.DLSegment.*;


public class DLHelpers {
    private static final Logger logger = LoggerFactory.getLogger(DLHelpers.class);

   // public static final int[] RPN_ANCHOR_SCALES = new int[]{8 , 16, 32, 64, 128};
    public static final float[] MEAN_PIXEL = new float[]{170.20611747f, 172.00450216f, 177.19215462f}; //{123.7f, 116.8f, 103.9f};
    private static Random random = new Random();
    // anchors 1,65472,4
    public static transient Tensor<Float> anchors = null;

    public static synchronized Tensor<Float> getAnchors(int img_size) {
        if (anchors==null) {
            float[] fArr = MaskRCNNAnchors.GenerateAnchors(img_size);
            anchors = Tensor.create(new long[]{1,fArr.length/4,4}, FloatBuffer.wrap(fArr));
        }
        return anchors;
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

    public static RawDetections executeInceptionGraph(final Session s, final Tensor<Float> input, final int inputWidth, final int inputHeight, final int maxDetections, final int maskWidth, final int maskHeight) {
        // image metas
        //  meta = np.array(
        //        [image_id] +                  # size=1
        //        list(original_image_shape) +  # size=3
        //        list(image_shape) +           # size=3
        //        list(window) +                # size=4 (y1, x1, y2, x2) in image cooredinates
        //        [scale[0]] +                     # size=1 NO LONGER, I dont have time to correct this properly so take only the first element
        //        list(active_class_ids)        # size=num_classes
        //    )
        final FloatBuffer metas = FloatBuffer.wrap(new float[]{
                0,
                inputWidth,inputHeight,3,
                inputWidth,inputHeight,3,
                0,0,inputWidth,inputHeight,
                1,
                0,0
        });
        final Tensor<Float> meta_data = Tensor.create(new long[]{1,14},metas);

        List<Tensor<?>> res = s
                .runner()
                .feed("input_image", input)
                .feed("input_image_meta", meta_data)
                .feed("input_anchors", getAnchors(inputWidth))  // dtype float and shape [?,?,4]
                .fetch("mrcnn_detection/Reshape_1")   // mrcnn_mask/Reshape_1   mrcnn_detection/Reshape_1    mrcnn_bbox/Reshape     mrcnn_class/Reshape_1
                .fetch("mrcnn_mask/Reshape_1")
                .run();

        float[][][] res_detection = new float[1][maxDetections][6];   // mrcnn_detection/Reshape_1   -> y1,x1,y2,x2,class_id,probability (ordered desc)
        float[][][][][] res_mask = new float[1][maxDetections][maskHeight][maskWidth][2];   // mrcnn_mask/Reshape_1
        Tensor<Float> mrcnn_detection = res.get(0).expect(Float.class);
        Tensor<Float> mrcnn_mask = res.get(1).expect(Float.class);
        mrcnn_detection.copyTo(res_detection);
        mrcnn_mask.copyTo(res_mask);

        RawDetections rawDetections = new RawDetections();
        rawDetections.objectBB = res_detection;
        rawDetections.masks = res_mask;
        return rawDetections;
    }

    public static SegmentationResult segmentRaster(Raster inputTileRaster, OrbitTiledImageIOrbitImage orbitImage, Session s, OrbitModel segModel, boolean writeImg, MaskRCNNSegmentationSettings segmentationSettings) throws Exception {
        BufferedImage segmented = maskRaster(inputTileRaster,orbitImage, s, writeImg, segmentationSettings);
        return getSegmentationResult(segModel, segmented);
    }


    public static SegmentationResult segmentTile(int tileX, int tileY, OrbitTiledImageIOrbitImage orbitImage, Session s, OrbitModel segModel, boolean writeImg, MaskRCNNSegmentationSettings segmentationSettings) throws Exception {
        // Read the tile.
        Raster tileRaster = orbitImage.getTile(tileX, tileY);
        BufferedImage maskOriginal = maskRaster(tileRaster,orbitImage, s, writeImg, segmentationSettings);

        maskOriginal = getShiftedMask(orbitImage, s, tileRaster, maskOriginal, 0, 512, segmentationSettings);
        maskOriginal = getShiftedMask(orbitImage, s, tileRaster, maskOriginal, 0, -512, segmentationSettings);
        maskOriginal = getShiftedMask(orbitImage, s, tileRaster, maskOriginal, 512, 0, segmentationSettings);
        maskOriginal = getShiftedMask(orbitImage, s, tileRaster, maskOriginal, -512, 0, segmentationSettings);
        // maskOriginal = getShiftedMask(orbitImage, s, tileRaster, maskOriginal, factor, 0, 0, true);

        //ImageIO.write(maskOriginal, "jpeg", new File(path + File.separator +"tile" + tileX + "x" + tileY + "_seg1.jpg"));
        SegmentationResult segmentationResult = getSegmentationResult(segModel, maskOriginal);
        return segmentationResult;
    }

    public static SegmentationResult getSegmentationResult(OrbitModel segModel, BufferedImage segmented) throws OrbitImageServletException {
        IOrbitImage segimg = new OrbitImagePlanar(PlanarImage.wrapRenderedImage(segmented), "segmented");
        RecognitionFrame rfSeg = new RecognitionFrame(segimg, "segmented");
        List<Point> tl = new ArrayList<>();
        tl.add(new Point(-1, -1));
        SegmentationResult segRes = OrbitHelper.Segmentation(rfSeg, 0, segModel, tl, 1, false);
        return segRes;
    }

    public static Tensor<Float> convertBufferedImageToTensor(BufferedImage image, int targetWidth, int targetHeight) {
        //if (image.getWidth()!=DESIRED_SIZE || image.getHeight()!=DESIRED_SIZE)
        {
            // also make it an RGB image
            image = resize(image, targetWidth, targetHeight);
            // image = resize(image,image.getWidth(), image.getHeight());
        }
        int width = image.getWidth();
        int height = image.getHeight();
        Raster r = image.getRaster();
        int[] rgb = new int[3];
        //int[] data = new int[width * height];
        //image.getRGB(0, 0, width, height, data, 0, width);
        float[][][][] rgbArray = new float[1][height][width][3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                //Color color = new Color(data[i * width + j]);
//                rgbArray[0][i][j][0] = color.getRed() - MEAN_PIXEL[0];
//                rgbArray[0][i][j][1] = color.getGreen() - MEAN_PIXEL[1];
//                rgbArray[0][i][j][2] = color.getBlue() - MEAN_PIXEL[2];
                rgb = r.getPixel(j,i,rgb);
                rgbArray[0][i][j][0] = rgb[0] - MEAN_PIXEL[0];
                rgbArray[0][i][j][1] = rgb[1] - MEAN_PIXEL[1];
                rgbArray[0][i][j][2] = rgb[2] - MEAN_PIXEL[2];
            }
        }
        return Tensor.create(rgbArray, Float.class);
    }

    /**
     * See MaskRCNNSegment implementation.
     * @param image
     * @param detections
     * @return
     */
    @Deprecated
    public static BufferedImage augmentDetections(BufferedImage image, MaskRCNNDetections detections) {
        AtomicReference<HashMap<Integer, Color>> maskClassColours = new AtomicReference<>(new HashMap<>());

        // Add keys and values (Country, City)
        maskClassColours.get().put(1, Color.BLACK);
        maskClassColours.get().put(2, Color.RED);
        maskClassColours.get().put(3, Color.GREEN);
        maskClassColours.get().put(4, Color.BLUE);
        maskClassColours.get().put(5, Color.YELLOW);

        boolean drawBoundingBox = false;
        boolean drawContour = true;
        BufferedImage outImg = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        Graphics2D g = outImg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g.drawImage(image,0,0,null);
        int numObjects = detections.getBoundingBoxes().size();
        for (int i=0; i<numObjects; i++) {
            float probability = detections.getProbabilities().get(i);
            int maskClass = detections.getMaskClasses().get(i);
            RectangleExt rect = detections.getBoundingBoxes().get(i);
            PolygonExt poly = detections.getContours().get(i);

            int x = rect.x;
            int y = rect.y;
            int width = rect.width;
            int height = rect.height;
            if (drawBoundingBox) {
                g.setStroke(new BasicStroke(2));
                g.setColor(maskClassColours.get().get(maskClass));
                g.drawRect(x, y, width, height);
            }

            // draw contour
            if (drawContour) {
                g.setStroke(new BasicStroke(2));
                Color color = Color.getHSBColor(random.nextFloat(),1f,1f);
                g.setColor(color);
                g.drawPolygon(poly);
            }
        }

        g.dispose();
        return outImg;
    }




    public static BufferedImage resize(BufferedImage img, int width, int height) {
        //int type = img.getType()>0?img.getType():BufferedImage.TYPE_INT_RGB;
        int type = BufferedImage.TYPE_INT_RGB;
        //BufferedImage resizedImage = new BufferedImage(roundP2(width), roundP2(height), type);
        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img, 0, 0, width, height, null);
        g.dispose();
        return resizedImage;
    }


    public static float[][] dilate(final float[][] buf) {
        final float cf = 1;
        final float[][] res = new float[buf.length][buf[0].length];
        for (int x = 0; x < buf.length; x++)
            for (int y = 0; y < buf[x].length; y++) {
                res[x][y] = buf[x][y];
                if (x > 0 && buf[x - 1][y] == cf) res[x][y] = cf;
                else if (x < buf.length - 1 && buf[x + 1][y] == cf) res[x][y] = cf;
                else if (y > 0 && buf[x][y - 1] == cf) res[x][y] = cf;
                else if (y < buf[x].length - 1 && buf[x][y + 1] == cf) res[x][y] = cf;

//				else
//				if (x>0 && y>0 && buf[x-1][y-1]==cf) res[x][y] = cf; else
//				if (x<buf.length-1 && y>0 && buf[x+1][y-1]==cf) res[x][y] = cf; else
//				if (y>0 && x<buf.length-1 && buf[x+1][y-1]==cf) res[x][y] = cf; else
//				if (y<buf[x].length-1 && x<buf.length-1 && buf[x+1][y+1]==cf) res[x][y] = cf;

                if (x == 0 || y == 0 || x == buf.length - 1 || y == buf[x].length - 1)
                    res[x][y] = 0;   // border pixel is always background (needed to 'close' objects)
            }
        return res;
    }

    public static float[][] erode(final float[][] buf) {
        final float cf = 0;
        final float[][] res = new float[buf.length][buf[0].length];
        for (int x = 0; x < buf.length; x++)
            for (int y = 0; y < buf[x].length; y++) {
                res[x][y] = buf[x][y];
                if (x > 0 && buf[x - 1][y] == cf) res[x][y] = cf;
                else if (x < buf.length - 1 && buf[x + 1][y] == cf) res[x][y] = cf;
                else if (y > 0 && buf[x][y - 1] == cf) res[x][y] = cf;
                else if (y < buf[x].length - 1 && buf[x][y + 1] == cf) res[x][y] = cf;
            }
        return res;
    }


    static BufferedImage flipImage(BufferedImage bi) {
        return new BufferedImage(bi.getColorModel(),(WritableRaster) flipRaster(bi.getData()),false,null);
    }

    static Raster flipRaster(Raster r) {
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

    protected static BufferedImage getShiftedMask(OrbitTiledImageIOrbitImage orbitImage, Session s, Raster tileRaster, BufferedImage maskOriginal, int dx, int dy, MaskRCNNSegmentationSettings segmentationSettings) {
        Rectangle rect = tileRaster.getBounds();
        rect.translate(dx,dy);
        if (!orbitImage.getBounds().contains(rect)) {
            return maskOriginal;
        }
        try {
            Raster shiftraster = orbitImage.getData(rect);
            if (segmentationSettings.getAugmentationSettings().getFlip()) {
                shiftraster = flipRaster(shiftraster);
            }
            BufferedImage mask2 = maskRaster(shiftraster, orbitImage, s, false, segmentationSettings);
            if (segmentationSettings.getAugmentationSettings().getFlip()) {
                mask2 = flipImage(mask2);
            }
            maskOriginal = combineMasks(maskOriginal, mask2, dx / segmentationSettings.getAugmentationSettings().getScaleFactor(), dy / segmentationSettings.getAugmentationSettings().getScaleFactor());
        } catch (Exception e) {
            logger.warn("Could not shift raster, returning original image (rect="+rect+" img.bounds="+orbitImage.getBounds()+")", e);
        }
        return maskOriginal;
    }

    static BufferedImage combineMasks(BufferedImage m1, BufferedImage m2, int dx, int dy) {
        BufferedImage combined = new BufferedImage(m1.getWidth(),m1.getHeight(),m1.getType());
        combined.getGraphics().drawImage(m1,0,0,null);
        int fg = Color.white.getRGB();
        Raster r2 = m2.getRaster();
        int minX = Math.max(-dx, 0);
        int minY = Math.max(-dy, 0);
        int maxX = Math.min(m2.getWidth() - dx, m2.getWidth());
        int maxY = Math.min(m2.getHeight() - dy, m2.getHeight());

        for (int x=minX; x<maxX; x++)
            for (int y=minY; y<maxY; y++) {
                if (r2.getSample(x,y,0)>0) {
                    combined.setRGB(x+dx,y+dy,fg);
                }
            }
        return combined;
    }

    /**
     * Shrink an image from the input size to the size used for training the Deep Learning model.
     * @param bi The image to shrink.
     * @param settings The settings containing the size to shrink to.
     * @return The shrunk image.
     */
    public static BufferedImage shrink(BufferedImage bi,AbstractSegmentationSettings settings) {
        BufferedImage bi2 = new BufferedImage(settings.getImageWidth(), settings.getImageHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) bi2.getGraphics();
        g.drawImage(bi,0,0,settings.getImageWidth(),settings.getImageHeight(),null);
        g.dispose();
        return bi2;
    }

    /**
     *
     * @param inputTileRaster
     * @param orbitImage
     * @param s
     * @param writeImg
     * @param segmentationSettings
     * @return
     */
    public static BufferedImage maskRaster(Raster inputTileRaster, OrbitTiledImageIOrbitImage orbitImage, Session s, boolean writeImg, MaskRCNNSegmentationSettings segmentationSettings) {
        WritableRaster tileRaster = (WritableRaster) inputTileRaster.createTranslatedChild(0, 0);
        BufferedImage ori = new BufferedImage(orbitImage.getColorModel(), tileRaster, false, null);
        ori = shrink(ori, segmentationSettings);

        // color-deconvolution
        if (segmentationSettings.getDeconvolution()) {
            ori = Colour_Deconvolution.getProcessedImage(ori, segmentationSettings.getDeconvolutionName(), segmentationSettings.getDeconvolutionChannel() - 1, ori);
        }

        int tx = orbitImage.XToTileX(inputTileRaster.getMinX());
        int ty = orbitImage.YToTileY(inputTileRaster.getMinY());
        // TODO: Move this to a test.
        if (writeImg) {
            try {
                ImageIO.write(ori, "jpeg", new File(debugImagePath + File.separator + "tile" + tx + "x" + ty + ".jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Tensor<Float> inputTensor = convertBufferedImageToTensor(ori, segmentationSettings.getImageWidth(), segmentationSettings.getImageHeight());
        long startt = System.currentTimeMillis();
        BufferedImage segmented = segmentInput(inputTensor, s, Color.black, Color.white);

        long usedt = System.currentTimeMillis()-startt;
        System.out.println("segment time (s): "+usedt/1000d);

//        if (false) {
//            ImagePlus ip = new ImagePlus("img", segmented);
//            ip.getProcessor().setBinaryThreshold();
//            ThresholderOrbit thresh = new ThresholderOrbit();
//            thresh.applyThreshold(ip);
//            BinaryOrbit binaryOrbit = new BinaryOrbit();
//            binaryOrbit.setup("close", ip);
//            binaryOrbit.run(ip.getProcessor().convertToByte(false));
//            binaryOrbit.setup("fill Holes", ip);
//            binaryOrbit.run(ip.getProcessor().convertToByte(false));
//            ip.getProcessor().invert();
//            ip = new ImagePlus("img", ip.getProcessor().convertToRGB());
//            segmented = ip.getBufferedImage();
//        }

        //ImageIO.write(segmented, "jpeg", new File(path + File.separator +"tile" + tx + "x" + ty + "_seg.jpg"));

        return segmented;
    }
}
