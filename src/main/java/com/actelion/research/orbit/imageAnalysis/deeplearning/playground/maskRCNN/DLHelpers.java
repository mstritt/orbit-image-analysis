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
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.nio.FloatBuffer;
import java.util.List;
import java.util.Random;


public class DLHelpers {

   // public static final int[] RPN_ANCHOR_SCALES = new int[]{8 , 16, 32, 64, 128};
    public static final float[] MEAN_PIXEL = new float[]{123.7f, 116.8f, 103.9f};
    private static Random random = new Random();
    // anchors 1,65472,4
    public static transient Tensor<Float> anchors = null;


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


    public static BufferedImage augmentDetections(BufferedImage image, Detections detections) {
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

    public static synchronized Tensor<Float> getAnchors(int img_size) {
        if (anchors==null) {
            float[] fArr = MaskRCNNAnchors.GenerateAnchors(img_size);
            anchors = Tensor.create(new long[]{1,fArr.length/4,4}, FloatBuffer.wrap(fArr));
        }
        return anchors;
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
}
