/*
 * Orbit, a versatile image analysis software for biological image-based quantification.
 * Copyright (C) 2009 - 2020 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.actelion.research.orbit.imageAnalysis.deeplearning;

import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.*;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.models.PolygonExt;
import com.actelion.research.orbit.imageAnalysis.models.RectangleExt;
import com.actelion.research.orbit.imageAnalysis.models.SegmentationResult;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitHelper;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitImagePlanar;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import javax.media.jai.PlanarImage;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DLHelpers {

    public static final float[] MEAN_PIXEL = new float[]{170.20611747f, 172.00450216f, 177.19215462f};
    private static final Random random = new Random();

    private static byte[] readAllBytesOrExit(Path path) {
        try {
            return Files.readAllBytes(path);
        } catch (IOException e) {
            System.err.println("Failed to read [" + path + "]: " + e.getMessage());
            System.exit(1);
        }
        return null;
    }

    public static Session buildSession(Path filePath) {
        byte[] graphDef = readAllBytesOrExit(filePath);
        return buildSessionBytes(graphDef);
    }

    public static Session buildSession(String fileName) {
        return buildSession(Paths.get(fileName));
    }

    public static Session buildSession(URL modelUrl) {
        byte[] graphDef = OrbitUtils.getContentBytes(modelUrl);
        return buildSessionBytes(graphDef);
    }

    public static Session buildSessionBytes(byte[] graphDef) {
        // TODO: Check whether a GPU is available, and fail gracefully if using a GPU build with no GPU...
        Graph g = new Graph();
        g.importGraphDef(graphDef);
        return new Session(g);
    }

    public static SegmentationResult getSegmentationResult(OrbitModel segModel, BufferedImage segmented) throws OrbitImageServletException {
        IOrbitImage segimg = new OrbitImagePlanar(PlanarImage.wrapRenderedImage(segmented), "segmented");
        RecognitionFrame rfSeg = new RecognitionFrame(segimg, "segmented");
        List<Point> tl = new ArrayList<>();
        tl.add(new Point(-1, -1));
        return OrbitHelper.Segmentation(rfSeg, 0, segModel, tl, 1, false);
    }

    public static Tensor<Float> convertBufferedImageToTensor(BufferedImage image, int targetWidth, int targetHeight) {
        {
            // also make it an RGB image
            image = resize(image, targetWidth, targetHeight);
        }
        int width = image.getWidth();
        int height = image.getHeight();
        Raster r = image.getRaster();
        int[] rgb = new int[3];

        float[][][][] rgbArray = new float[1][height][width][3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                rgb = r.getPixel(j,i,rgb);
                rgbArray[0][i][j][0] = rgb[0] - MEAN_PIXEL[0];
                rgbArray[0][i][j][1] = rgb[1] - MEAN_PIXEL[1];
                rgbArray[0][i][j][2] = rgb[2] - MEAN_PIXEL[2];
            }
        }
        return Tensor.create(rgbArray, Float.class);
    }

    // TODO: Remove dependency on MaskRCNNSettings...
    /**
     * Take an image, detection and settings and return an image with the bounding box drawn onto it.
     * @param image Input image.
     * @param contours List of contours.
     * @param detectionClasses List of classes for each detection.
     * @param segmentationSettings Segmentation Settings.
     * @param drawBoundingBox Whether or not to draw the bounding box on the image.
     * @param drawContour Whether or not to draw the contour on the image.
     * @return The rendered image with the detections added.
     */
    public static BufferedImage detectionToImage(BufferedImage image,
                                                 List<RectangleExt> boundingBox,
                                                 List<PolygonExt> contours,
                                                 List<Integer> detectionClasses,
                                                 MaskRCNNSegmentationSettings segmentationSettings,
                                                 boolean drawBoundingBox,
                                                 boolean drawContour) {

        BufferedImage outImg = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        Graphics2D g = outImg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g.drawImage(image,0,0,null);
        int numObjects = boundingBox.size();
        for (int i=0; i<numObjects; i++) {
            int maskClass = detectionClasses.get(i);
            RectangleExt rect = boundingBox.get(i);
            PolygonExt poly = contours.get(i);

            int x = rect.x;
            int y = rect.y;
            int width = rect.width;
            int height = rect.height;
            if (drawBoundingBox) {
                g.setStroke(new BasicStroke(2));
                g.setColor(segmentationSettings.getAnnotationColor(maskClass));
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
        int type = BufferedImage.TYPE_INT_RGB;
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

    /**
     * Shrink an image from the input size to the size used for training the Deep Learning model.
     * @param bi The image to shrink.
     * @param settings The settings containing the size to shrink to.
     * @return The shrunk image.
     */
    public static BufferedImage shrink(BufferedImage bi, AbstractSegmentationSettings<?> settings) {
        BufferedImage bi2 = new BufferedImage(settings.getImageWidth(), settings.getImageHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) bi2.getGraphics();
        g.drawImage(bi,0,0,settings.getImageWidth(),settings.getImageHeight(),null);
        g.dispose();
        return bi2;
    }

}
