package com.actelion.research.orbit.imageAnalysis.deeplearning.DeepLabV2Resnet101;

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.deeplearning.AbstractSegment;
import com.actelion.research.orbit.imageAnalysis.deeplearning.DLHelpers;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNDetections;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.models.SegmentationResult;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImageIOrbitImage;
import org.tensorflow.Session;

import java.awt.*;
import java.io.File;
import java.util.List;
import java.util.Map;

public class DLR101Segment extends AbstractSegment {

    private final Session s;

    public DLR101Segment(File maskRCNNModelPB, DLR101SegmentationSettings settings) {
        super(settings);
        this.s = DLHelpers.buildSession(maskRCNNModelPB.getAbsolutePath());
    }


    @Override
    public Map<Integer, List<Shape>> generateSegmentationAnnotations(List<RawDataFile> rdfList, OrbitModel segModel, OrbitModel modelContainingExclusionModel, boolean storeAnnotations, Point tile) {
        return null;
    }

    @Override
    public MaskRCNNDetections segmentationImplementation(OrbitModel segModel, OrbitTiledImageIOrbitImage orbitImage, Point tile) {
        return null;
    }

    @Override
    public MaskRCNNDetections processDetections(SegmentationResult segRes, Point tileOffset) {
        return null;
    }
}
