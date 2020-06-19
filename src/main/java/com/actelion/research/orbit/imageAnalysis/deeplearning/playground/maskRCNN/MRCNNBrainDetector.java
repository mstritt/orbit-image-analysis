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

import com.actelion.research.orbit.imageAnalysis.models.PolygonExt;
import com.actelion.research.orbit.imageAnalysis.models.RectangleExt;
import com.actelion.research.orbit.imageAnalysis.utils.MarchingSquares;
import ij.ImagePlus;
import ij.plugin.filter.GaussianBlur;
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
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MRCNNBrainDetector implements Closeable {

    private static final Logger logger = LoggerFactory.getLogger(MRCNNBrainDetector.class);
    private static final String MODEL_FN = "D:\\dl\\models\\finalbrainDetect2.pb";
    private static final String INPUT_IMAGE = "d:/dl/images/detect/train2/10743897.jpg";
    private static final String OUTPUT_IMAGE = "D:/dl/images/detect/out4/10743897-roi.png";

    public static final int MAX_DETECTIONS = 1;
    public static final int size = 1024;

    private Graph g;
    private Session s;

    public MRCNNBrainDetector() throws IOException {
        byte[] graphDef = Files.readAllBytes(Paths.get(MODEL_FN));
        g = loadGraph(graphDef);
        s = createSession(g);
    }

    public void close() {
        s.close();
        g.close();
    }

    public static void main(String[] args) throws IOException {
        Date startDate = new Date();
        MRCNNBrainDetector maskRCNN = new MRCNNBrainDetector();
        byte[] graphDef = Files.readAllBytes(Paths.get(MODEL_FN));
        try (Graph g = maskRCNN.loadGraph(graphDef);
             Session s = maskRCNN.createSession(g)) {
            BufferedImage originalImage = ImageIO.read(new File(INPUT_IMAGE));
            long startt = System.currentTimeMillis();
            Tensor<Float> input = DLHelpers.convertBufferedImageToTensor(originalImage,512,512);
            if (input != null) {
                RawDetections rawDetections = DLHelpers.executeInceptionGraph(s, input, 512, 512, MAX_DETECTIONS,28,28);
                MaskRCNNDetections detections = maskRCNN.processDetections(512,512,rawDetections);

                BufferedImage bigger = ImageIO.read(new File(INPUT_IMAGE.replaceAll(".jpg", "_ori.jpg")));
                double scaleW = bigger.getWidth()/(double)originalImage.getWidth();
                double scaleH = bigger.getHeight()/(double)originalImage.getHeight();
                Rectangle bb = detections.getContours().get(0).getBounds();
                Rectangle bbScaled = new Rectangle((int) (bb.x * scaleW), (int) (bb.y * scaleH), (int) (bb.width * scaleW), (int) (bb.height * scaleH));
                bigger = bigger.getSubimage(bbScaled.x,bbScaled.y,(int)bbScaled.getWidth(),(int)bbScaled.getHeight());
                BufferedImage bigger512 = DLHelpers.resize(bigger,512,512);
                ImageIO.write(bigger512, "png", new File(OUTPUT_IMAGE));

                FileWriter fw = new FileWriter(OUTPUT_IMAGE.replaceAll(".png","_meta.txt"));
                fw.write(bb.x+";"+bb.y+";"+(int)(bb.x+bb.getWidth())+";"+(int)(bb.y+bb.getHeight()));
                fw.close();

                //BufferedImage outputImage = maskRCNN.augmentDetections(originalImage, detections);
                //ImageIO.write(outputImage, "png", new File(OUTPUT_IMAGE));
            }
            long used = System.currentTimeMillis()-startt;
            System.out.println("time used: "+used/1000d);
        }

        long elapsedTimeInSec = (new Date().getTime() - startDate.getTime()) / 1000;
        System.out.println(String.format("Ended in %ds .", elapsedTimeInSec));
    }

    public List<DetectorResult> detectBrains(final BufferedImage smallImage, BufferedImage image512) throws IOException {
        List<DetectorResult> resList = new ArrayList<>();
        Tensor<Float> input = DLHelpers.convertBufferedImageToTensor(image512,512,512);
        if (input != null) {
            RawDetections rawDetections = DLHelpers.executeInceptionGraph(s, input, 512, 512, MAX_DETECTIONS,28,28);
            MaskRCNNDetections detections = processDetections(512,512,rawDetections);
            double scaleW = smallImage.getWidth()/(double)image512.getWidth();
            double scaleH = smallImage.getHeight()/(double)image512.getHeight();
            Rectangle bb = detections.getContours().get(0).getBounds();
            int pad = 20;
            bb = new Rectangle(bb.x-pad,bb.y-pad, bb.width+pad*2, bb.height+pad*2);
            Rectangle bbScaled = new Rectangle((int) (bb.x * scaleW), (int) (bb.y * scaleH), (int) (bb.width * scaleW), (int) (bb.height * scaleH));
            bbScaled = new Rectangle(smallImage.getMinX(),smallImage.getMinY(),smallImage.getWidth(),smallImage.getHeight()).intersection(bbScaled);
            BufferedImage roiImage = smallImage.getSubimage(bbScaled.x,bbScaled.y,(int)bbScaled.getWidth(),(int)bbScaled.getHeight());
        //    roiImage = DLHelpers.resize(roiImage,DLHelpers.DESIRED_SIZE,DLHelpers.DESIRED_SIZE);
            roiImage = DLHelpers.resize(roiImage,size,size);
            DetectorResult result = new DetectorResult(roiImage,bb.x,bb.y,bb.x+bb.width, bb.y+bb.height);
            resList.add(result);
        }
        return resList;
    }

    public MaskRCNNDetections processDetections(int imgWidth, int imgHeight, RawDetections rawDetections) {
        MaskRCNNDetections detections = new MaskRCNNDetections();

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
                BufferedImage roiScaled = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
                Graphics2D roiG = roiScaled.createGraphics();
                roiG.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                roiG.drawImage(roi,0,0,width,height,null);
                roiG.dispose();

                // blur
                ImagePlus ip = new ImagePlus("img",roiScaled);
                GaussianBlur blur = new GaussianBlur();
                blur.setNPasses(1);
                blur.blurGaussian(ip.getProcessor(),8,8,0.02d);
                roiScaled = ip.getProcessor().getBufferedImage();

                // draw contour
                int pad = 10;
                int[] argb = new int[4];
                Raster raster = roiScaled.getRaster();
                float[][] area = new float[roiScaled.getWidth()+pad*2][roiScaled.getHeight()+pad*2];
                for (int x1=0; x1<roiScaled.getWidth(); x1++) {
                    for (int y1=0; y1<roiScaled.getHeight(); y1++) {
                        argb = raster.getPixel(x1,y1,argb);
                        long sum = argb[1]+argb[2]+argb[3];
                        area[x1+pad][y1+pad] = sum>50L? 1:0 /*sum / (double)(3*256)*/;
                    }
                }
                // fill holes
                //area = dilate(area);
                //area = erode(area);

                try {
                    int fg = Color.white.getRGB();
                    int bg = Color.blue.getRGB();
                    BufferedImage bi = new BufferedImage(roiScaled.getWidth(),roiScaled.getHeight(),BufferedImage.TYPE_INT_RGB);
                    for (int x1=0; x1<roiScaled.getWidth(); x1++) {
                        for (int y1 = 0; y1 < roiScaled.getHeight(); y1++) {
                              bi.setRGB(x1,y1,area[x1][y1]>0?fg:bg);
                        }
                    }
                    ImageIO.write(bi,"png", new File("D:\\NoBackup\\brains\\detect\\out2\\10743897-1-roi-mask.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                final ArrayList<Point2D> contour = new ArrayList<>();
                if (MarchingSquares.calculateContour(contour, area, 1, 0.5f)) {
                    int[] xpoints = new int[contour.size()];
                    int[] ypoints = new int[contour.size()];
                    for (int j=0; j<contour.size(); j++) {
                        xpoints[j] = (int)(x + ((contour.get(j).getX()-pad) * 1f));
                        ypoints[j] = (int)(y + ((contour.get(j).getY()-pad) * 1f));
                    }
                    PolygonExt polygon = new PolygonExt(new Polygon(xpoints,ypoints, xpoints.length));
                    detections.addDetection(polygon,boundingBox,probability);
                }


            }
        }
        return detections;
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

    public class DetectorResult {
        public int x1,y1,x2,y2;
        public BufferedImage roiImage;

        public DetectorResult(BufferedImage roiImage, int x1, int y1, int x2, int y2) {
            this.roiImage = roiImage;
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

}
