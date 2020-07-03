package com.actelion.research.orbit.imageAnalysis.deeplearning.DeepLabV2Resnet101;

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.deeplearning.AbstractSegment;
import com.actelion.research.orbit.imageAnalysis.deeplearning.AbstractSegmentationSettings;
import com.actelion.research.orbit.imageAnalysis.deeplearning.DLHelpers;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.models.SegmentationResult;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImageIOrbitImage;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.Map;

public class DLR101Segment extends AbstractSegment<DLR101Detections, DLR101SegmentationSettings> {

    private final Session s;

    public DLR101Segment(File modelPB, DLR101SegmentationSettings settings) {
        super(settings);
        this.s = DLHelpers.buildSession(modelPB.getAbsolutePath());
    }

    @Override
    public Map<Integer, List<Shape>> generateSegmentationAnnotations(List<RawDataFile> rdfList, OrbitModel segModel, OrbitModel modelContainingExclusionModel, boolean storeAnnotations, Point tile) {
        return null;
    }

    @Override
    public void storeShapes(DLR101Detections detections, AbstractSegmentationSettings<DLR101Detections> settings, int rdfId, String user) throws Exception {

    }

    @Override
    public DLR101Detections segmentationImplementation(OrbitModel segModel, OrbitTiledImageIOrbitImage orbitImage, Point tile) {
        return null;
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