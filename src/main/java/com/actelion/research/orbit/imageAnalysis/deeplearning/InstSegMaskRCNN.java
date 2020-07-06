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

package com.actelion.research.orbit.imageAnalysis.deeplearning;

import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNAnchors;
import com.actelion.research.orbit.imageAnalysis.models.PolygonExt;
import com.actelion.research.orbit.imageAnalysis.models.RectangleExt;
import com.actelion.research.orbit.imageAnalysis.utils.MarchingSquares;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlow;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InstSegMaskRCNN {

    private static final Logger logger = LoggerFactory.getLogger(InstSegMaskRCNN.class);
    private static final String MODEL_DIR = "C:\\git\\python\\DSB_2018_DEEPRETINA\\logs\\final";
    private static final String MODEL_NAME = "deepretina_final.pb";
    //    private static final String INPUT_IMAGE = "D:\\NoBackup\\databowl2018\\stage1_test\\da6c593410340b19bb212b9f6d274f95b08c0fc8f2570cd66bc5ed42c560acab\\images\\da6c593410340b19bb212b9f6d274f95b08c0fc8f2570cd66bc5ed42c560acab.png";
    private static final String INPUT_IMAGE = "D:\\NoBackup\\databowl2018\\in\\sample512\\images\\sample512.png";
    private static final String OUTPUT_IMAGE = "D:\\NoBackup\\databowl2018\\out\\out.jpg";

    private static final int DESIRED_SIZE = 512;
    private static final int[] RPN_ANCHOR_SCALES = new int[]{8 , 16, 32, 64, 128};
    private static final float[] MEAN_PIXEL = new float[]{123.7f, 116.8f, 103.9f};

    // anchors 1,65472,4
    private static transient Tensor<Float> anchors = null;
    private Random random = new Random();

    public static void main2(String[] args) throws IOException {
        Date startDate = new Date();
        final InstSegMaskRCNN maskRCNN = new InstSegMaskRCNN();
        final byte[] graphDef = Files.readAllBytes(Paths.get(MODEL_DIR, MODEL_NAME));
        final Graph g = maskRCNN.loadGraph(graphDef);
        final Session s = maskRCNN.createSession(g);
        try {
            BufferedImage originalImage = ImageIO.read(new File(INPUT_IMAGE));
            long startt = System.currentTimeMillis();
            List<Callable<BufferedImage>> tasks = new ArrayList<>();
            for (int i=0; i<100; i++) {
                tasks.add(new Callable<BufferedImage>() {
                    @Override
                    public BufferedImage call() throws Exception {
                        Tensor<Float> input = maskRCNN.convertBufferedImageToTensor(originalImage);
                        if (input != null) {
                            RawDetections rawDetections = maskRCNN.executeInceptionGraph(s, input);
                            input.close();
                            Detections detections = maskRCNN.processDetections(512,512,rawDetections);
                            BufferedImage outputImage = maskRCNN.augmentDetections(originalImage, detections);
                            //  ImageIO.write(outputImage, "jpg", new File(OUTPUT_IMAGE));
                            return outputImage;
                        }
                        return null;
                    }
                });
            }
            ExecutorService executor = Executors.newFixedThreadPool(1);
            try {
                executor.invokeAll(tasks);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                executor.shutdownNow();
            }

            long used = System.currentTimeMillis()-startt;
            System.out.println("time used: "+used/1000d);
        } finally {
            s.close();
            g.close();
        }

        long elapsedTimeInSec = (new Date().getTime() - startDate.getTime()) / 1000;
        System.out.println(String.format("Ended in %ds .", elapsedTimeInSec));
    }

    public static void main(String[] args) throws IOException {
        Date startDate = new Date();
        InstSegMaskRCNN maskRCNN = new InstSegMaskRCNN();
        byte[] graphDef = Files.readAllBytes(Paths.get(MODEL_DIR, MODEL_NAME));
        try (Graph g = maskRCNN.loadGraph(graphDef);
             Session s = maskRCNN.createSession(g)) {
            BufferedImage originalImage = ImageIO.read(new File(INPUT_IMAGE));
            long startt = System.currentTimeMillis();
            for (int i=0; i<100; i++) {
                Tensor<Float> input = maskRCNN.convertBufferedImageToTensor(originalImage);
                if (input != null) {
                    RawDetections rawDetections = maskRCNN.executeInceptionGraph(s, input);
                    Detections detections = maskRCNN.processDetections(512,512,rawDetections);
                    BufferedImage outputImage = maskRCNN.augmentDetections(originalImage, detections);
                    ImageIO.write(outputImage, "jpg", new File(OUTPUT_IMAGE));
                }
            }
            long used = System.currentTimeMillis()-startt;
            System.out.println("time used: "+used/1000d);
        }

        long elapsedTimeInSec = (new Date().getTime() - startDate.getTime()) / 1000;
        System.out.println(String.format("Ended in %ds .", elapsedTimeInSec));
    }

    public Detections processDetections(int imgWidth, int imgHeight, RawDetections rawDetections) {
        Detections detections = new Detections();
        detections.setBoundingBoxes(new ArrayList<>());
        detections.setContours(new ArrayList<>());
        detections.setProbabilities(new ArrayList<>());
        float[][] objects = rawDetections.objectBB[0]; // only one image      y1,x1,y2,x2,class_id,probability (ordered desc)
        for (int i=0; i<objects.length; i++) {
            float[] bb = objects[i];  // y1,x1,y2,x2,class_id,probability
            if (bb[5]>0.1 && ((bb[3]-bb[1])*(bb[2]-bb[0])>1E-5))  {    // probability > 0.8 and area > 1E-5
                float probability = bb[5];
                int x = (int)(bb[1] * imgWidth);
                int y = (int)(bb[0] * imgHeight);
                int width = (int)((bb[3]-bb[1])*imgWidth);
                int height = (int)((bb[2]-bb[0])*imgHeight);
                RectangleExt boundingBox = new RectangleExt(x,y,width,height);

                // masks    [1][512][28][28][2]
                float[][][] mask = rawDetections.masks[0][i];
                int rw = mask[0].length;
                int rh = mask.length;
                float scaleW = (float)width / (float)rw;
                float scaleH = (float)height / (float)rh;
                BufferedImage roi = new BufferedImage(rw,rh,BufferedImage.TYPE_INT_ARGB);
                for (int xr=0; xr<rw; xr++) {
                    for (int yr=0; yr<rh; yr++) {
                        //if (mask[yr][xr][1]>0.5f)
                        if (mask[yr][xr][0]<mask[yr][xr][1])
                        //if (mask[yr][xr][0]<mask[yr][xr][1] && mask[yr][xr][1]>0.5f)
                        {
                            roi.setRGB(xr,yr,Color.MAGENTA.getRGB());
                        }
                    }
                }
                // scale mask to bb size
                BufferedImage roiScaled = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
                Graphics2D roiG = roiScaled.createGraphics();
                roiG.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                roiG.drawImage(roi,0,0,width,height,null);

                // draw contour
                int pad = 10;
                int[] argb = new int[4];
                Raster raster = roiScaled.getRaster();
                float[][] area = new float[roiScaled.getWidth()+pad*2][roiScaled.getHeight()+pad*2];
                for (int x1=0; x1<roiScaled.getWidth(); x1++) {
                    for (int y1=0; y1<roiScaled.getHeight(); y1++) {
                        argb = raster.getPixel(x1,y1,argb);
                        long sum = argb[1]+argb[2]+argb[3];
                        area[x1+pad][y1+pad] = sum>0l? 1:0 /*sum / (double)(3*256)*/;
                    }
                }
                // fill holes
                area = dilate(area);
                area = erode(area);

                final ArrayList<Point2D> contour = new ArrayList<>();
                if (MarchingSquares.calculateContour(contour, area, 1, 0.5f)) {
                    int[] xpoints = new int[contour.size()];
                    int[] ypoints = new int[contour.size()];
                    for (int j=0; j<contour.size(); j++) {
                        xpoints[j] = (int)(x + ((contour.get(j).getX()-pad) * 1f));
                        ypoints[j] = (int)(y + ((contour.get(j).getY()-pad) * 1f));
                    }
                    PolygonExt polygon = new PolygonExt(new Polygon(xpoints,ypoints, xpoints.length));
                    detections.getProbabilities().add(probability);
                    detections.getBoundingBoxes().add(boundingBox);
                    detections.getContours().add(polygon);
                }
                roiG.dispose();

            }
        }
        return detections;
    }

    private BufferedImage augmentDetections(BufferedImage image, Detections detections) {
        boolean drawBoundingBox = false;
        boolean drawContour = true;
        BufferedImage outImg = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        Graphics2D g = outImg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g.drawImage(image,0,0,null);
        int numObjects = detections.boundingBoxes.size();
        for (int i=0; i<numObjects; i++) {
            float probability = detections.getProbabilities().get(i);
            RectangleExt rect = detections.getBoundingBoxes().get(i);
            PolygonExt poly = detections.getContours().get(i);

            int x = rect.x;
            int y = rect.y;
            int width = rect.width;
            int height = rect.height;
            if (drawBoundingBox) {
                g.setStroke(new BasicStroke(2));
                g.setColor(Color.yellow);
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

    private float[][] dilate(final float[][] buf) {
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

    private float[][] erode(final float[][] buf) {
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

    private synchronized Tensor<Float> getAnchors() {
        if (anchors==null) {
            float[] fArr = MaskRCNNAnchors.GenerateAnchors(DESIRED_SIZE);
            anchors = Tensor.create(new long[]{1,fArr.length/4,4}, FloatBuffer.wrap(fArr));
        }
        return anchors;
    }

    public Tensor<Float> convertBufferedImageToTensor(BufferedImage image) {
        //if (image.getWidth()!=DESIRED_SIZE || image.getHeight()!=DESIRED_SIZE)
        {
            // also make it an RGB image
            image = resize(image,DESIRED_SIZE, DESIRED_SIZE);
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

    public BufferedImage resize(BufferedImage img, int width, int height) {
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

    private int roundP2(int x) {
        return (int) Math.pow(2, Math.ceil(Math.log(x)/Math.log(2)));
    }

    public Graph loadGraph(byte[] graphDef) {
        logger.info("TF version "+TensorFlow.version());
        Graph g = new Graph();
        g.importGraphDef(graphDef);
        return g;
    }

    public Session createSession(Graph g) {
        // output all node names
        //            Iterator<Operation> ops = g.operations();
        //            while (ops.hasNext()) {
        //                Operation op = ops.next();
        //                System.out.println(op.name());
        //            }
        //            System.out.println("finished");
        Session s = new Session(g);
        logger.trace("TF session created");
        return s;
    }

    public RawDetections executeInceptionGraph(Session s, Tensor<Float> input) {
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
                512,512,3,
                512,512,3,
                0,0,512,512,
                1,
                0,0
        });
        final Tensor<Float> meta_data = Tensor.create(new long[]{1,14},metas);

        List<Tensor<?>> res = s
                .runner()
                .feed("input_image", input)
                .feed("input_image_meta", meta_data)
                .feed("input_anchors", getAnchors())  // dtype float and shape [?,?,4]
                .fetch("mrcnn_detection/Reshape_1")   // mrcnn_mask/Reshape_1   mrcnn_detection/Reshape_1    mrcnn_bbox/Reshape     mrcnn_class/Reshape_1
                .fetch("mrcnn_mask/Reshape_1")
                .run();

        float[][][] res_detection = new float[1][512][6];   // mrcnn_detection/Reshape_1   -> y1,x1,y2,x2,class_id,probability (ordered desc)
        float[][][][][] res_mask = new float[1][512][28][28][2];   // mrcnn_mask/Reshape_1
        Tensor<Float> mrcnn_detection = res.get(0).expect(Float.class);
        Tensor<Float> mrcnn_mask = res.get(1).expect(Float.class);
        mrcnn_detection.copyTo(res_detection);
        mrcnn_mask.copyTo(res_mask);

        RawDetections rawDetections = new RawDetections();
        rawDetections.objectBB = res_detection;
        rawDetections.masks = res_mask;
        return rawDetections;
    }


    public class RawDetections {
        float[][][] objectBB; // y1,x1,y2,x2,class_id,probability (ordered desc)
        float[][][][][] masks;  // float[1][512][28][28][2] max 512 instances, for each a 28x28 mask x probability foreground/background
    }

    public class Detections {
        private List<PolygonExt> contours;
        private List<RectangleExt> boundingBoxes;
        private List<Float> probabilities;

        public List<PolygonExt> getContours() {
            return contours;
        }

        public void setContours(List<PolygonExt> contours) {
            this.contours = contours;
        }

        public List<RectangleExt> getBoundingBoxes() {
            return boundingBoxes;
        }

        public void setBoundingBoxes(List<RectangleExt> boundingBoxes) {
            this.boundingBoxes = boundingBoxes;
        }

        public List<Float> getProbabilities() {
            return probabilities;
        }

        public void setProbabilities(List<Float> probabilities) {
            this.probabilities = probabilities;
        }
    }

}