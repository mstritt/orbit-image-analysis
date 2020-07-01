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

import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNDetections;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNRawDetections;
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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;

@Deprecated
public class MRCNNCorpusCallosum implements Closeable {

    private static final Logger logger = LoggerFactory.getLogger(MRCNNCorpusCallosum.class);
    private static final String MODEL_FN = "D:/deeplearning/corpus_callosum/finalbrain15-56b.pb";
    
    private static final String INPUT_IMAGE = "D:\\tmp\\test-roi.png";
    private static final String OUTPUT_IMAGE = "D:\\tmp\\test-roi-seg.png";

    public static final int MAX_DETECTIONS = 1;
//    public static int maskWidth = 28;
//    public static int maskHeight = 28;
    public static int maskWidth = 56;
    public static int maskHeight = 56;
    public static int size = 512;

    
    
    private Graph g;
    private Session s;

    public MRCNNCorpusCallosum() throws IOException {
        byte[] graphDef = Files.readAllBytes(Paths.get(MODEL_FN));
        g = loadGraph(graphDef);
        logger.info("TF model loaded: "+MODEL_FN);
        s = createSession(g);
    }

    public void close() {
        s.close();
        g.close();
    }

    public static void main(String[] args) throws IOException {
        Date startDate = new Date();
        MRCNNCorpusCallosum maskRCNN = new MRCNNCorpusCallosum();
        byte[] graphDef = Files.readAllBytes(Paths.get(MODEL_FN));
        try (Graph g = maskRCNN.loadGraph(graphDef);
             Session s = maskRCNN.createSession(g)) {
            BufferedImage originalImage = ImageIO.read(new File(INPUT_IMAGE));
            long startt = System.currentTimeMillis();
            Tensor<Float> input = DLHelpers.convertBufferedImageToTensor(originalImage, size, size);
            if (input != null) {
                MaskRCNNRawDetections rawDetections = DLHelpers.executeInceptionGraph(s, input, size, size, MAX_DETECTIONS, maskWidth, maskHeight);
                MaskRCNNDetections detections = maskRCNN.processDetections(size,size,rawDetections);
                BufferedImage outputImage = DLHelpers.augmentDetections(originalImage, detections);
                ImageIO.write(outputImage, "png", new File(OUTPUT_IMAGE));
            }
            long used = System.currentTimeMillis()-startt;
            System.out.println("time used: "+used/1000d);
        }

        long elapsedTimeInSec = (new Date().getTime() - startDate.getTime()) / 1000;
        System.out.println(String.format("Ended in %ds .", elapsedTimeInSec));
    }

    public MaskRCNNDetections detectCorpusCallosum(BufferedImage image512) {
        Tensor<Float> input = DLHelpers.convertBufferedImageToTensor(image512, size, size);
        if (input != null) {
            MaskRCNNRawDetections rawDetections = DLHelpers.executeInceptionGraph(s, input, size, size, MAX_DETECTIONS, maskWidth, maskHeight);
            MaskRCNNDetections detections = processDetections(size,size,rawDetections);
            //BufferedImage outputImage = DLHelpers.augmentDetections(image512, detections);
            //ImageIO.write(outputImage, "jpeg", new File("d:/test-seg.jpg"));
            return detections;
        }
        return null;
    }

    public MaskRCNNDetections processDetections(int imgWidth, int imgHeight, MaskRCNNRawDetections rawDetections) {
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
                        if (mask[yr][xr][1]>0.45f)
                       // if (mask[yr][xr][0]<mask[yr][xr][1])
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
                        long sum = argb[1]+argb[2]+argb[0];
                        
                        area[x1+pad][y1+pad] = sum>180L? 1:0 /*sum / (double)(3*256)*/;
                    }
                }
                // fill holes
                //area = dilate(area);
                //area = erode(area);

//                try {
//                    int fg = Color.white.getRGB();
//                    int bg = Color.blue.getRGB();
//                    BufferedImage bi = new BufferedImage(roiScaled.getWidth(),roiScaled.getHeight(),BufferedImage.TYPE_INT_RGB);
//                    for (int x1=0; x1<roiScaled.getWidth(); x1++) {
//                        for (int y1 = 0; y1 < roiScaled.getHeight(); y1++) {
//                              bi.setRGB(x1,y1,area[x1][y1]>0?fg:bg);
//                        }
//                    }
//                    ImageIO.write(bi,"png", new File("D:\\NoBackup\\brains\\detect\\out2\\10743897-1-roi-mask.png"));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

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
//                    Iterator<Operation> ops = g.operations();
//                    while (ops.hasNext()) {
//                        Operation op = ops.next();
//                        System.out.println(op.name());
//                    }
//                    System.out.println("finished");
        Session s = new Session(g);
        logger.trace("TF session created");
        return s;
    }


}
