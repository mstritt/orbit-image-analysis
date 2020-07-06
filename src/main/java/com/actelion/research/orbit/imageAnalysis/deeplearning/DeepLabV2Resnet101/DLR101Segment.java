package com.actelion.research.orbit.imageAnalysis.deeplearning.DeepLabV2Resnet101;

import com.actelion.research.orbit.imageAnalysis.deeplearning.AbstractSegment;
import com.actelion.research.orbit.imageAnalysis.deeplearning.DLHelpers;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.models.SegmentationResult;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImageIOrbitImage;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;

public class DLR101Segment extends AbstractSegment<DLR101Detections, DLR101SegmentationSettings> {

    private final Session s;

    public DLR101Segment(File modelPB, DLR101SegmentationSettings settings) {
        super(settings);
        this.s = DLHelpers.buildSession(modelPB.getAbsolutePath());
    }

    @Override
    public DLR101Detections segmentationImplementation(OrbitModel segModel, OrbitTiledImageIOrbitImage orbitImage, Point tile) {
        return null;
    }

    @Override
    public void storeShapes(DLR101Detections detections, DLR101SegmentationSettings settings, int rdfId, String user) throws Exception {

    }

    @Override
    public DLR101Detections processDetections(SegmentationResult segRes, Point tileOffset) {
        return null;
    }

    public DLR101Detections getDLR101RawDetections(final Tensor<Long> inputTensor) {

        Tensor<Long> res = s
                         .runner()
                         .feed("image_batch", inputTensor)
                         .fetch("predictions")
                         .run().get(0).expect(Long.class);

        DLR101Detections detections = new DLR101Detections();

        detections.setRawDetections(res.copyTo(new long[res.numElements()]));

        return detections;
    }

    public static Tensor<Long> convertBufferedImageToTensor(BufferedImage image, int targetWidth, int targetHeight) {
        //if (image.getWidth()!=DESIRED_SIZE || image.getHeight()!=DESIRED_SIZE)
        {
            // also make it an RGB image
            image = DLHelpers.resize(image, targetWidth, targetHeight);
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
                rgbArray[0][i][j][0] = rgb[0] - 170f;
                rgbArray[0][i][j][1] = rgb[1] - 170f;
                rgbArray[0][i][j][2] = rgb[2] - 170f;
            }
        }
        return Tensor.create(rgbArray, Long.class);
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

    public BufferedImage decodeLabels(long[] mask, Color bg, Color fg) {
//		int[][] label_colours = {
//				new int[] { 0, 0, 0 },
//				new int[] { 255, 255, 255 } //Glomeruli
//				};
        int[][] label_mask = convert1DVectorTo2D(mask, segmentationSettings.getImageWidth(), segmentationSettings.getImageHeight());
        BufferedImage image = new BufferedImage(segmentationSettings.getImageWidth(), segmentationSettings.getImageHeight(), BufferedImage.TYPE_INT_RGB);
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
}