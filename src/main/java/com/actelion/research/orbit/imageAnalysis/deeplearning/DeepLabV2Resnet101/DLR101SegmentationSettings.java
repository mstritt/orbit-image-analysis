package com.actelion.research.orbit.imageAnalysis.deeplearning.DeepLabV2Resnet101;

import com.actelion.research.orbit.imageAnalysis.deeplearning.AbstractSegmentationSettings;

public class DLR101SegmentationSettings extends AbstractSegmentationSettings {

    public DLR101SegmentationSettings(String modelName, int imageWidth, int imageHeight, float tileScaleFactor, String annotationPrefix, boolean segmentationRefinement) {
        this(modelName, imageWidth, imageHeight,
                tileScaleFactor, tileScaleFactor,
                annotationPrefix, 120d,
                segmentationRefinement);
    }

    public DLR101SegmentationSettings(String modelName, int imageWidth, int imageHeight,
                                      float tileScaleFactorX, float tileScaleFactorY,
                                      String annotationPrefix, double detectionToleranceScale,
                                      boolean segmentationRefinement) {
        super(modelName, imageWidth, imageHeight,
                tileScaleFactorX, tileScaleFactorY,
                annotationPrefix, segmentationRefinement,
                detectionToleranceScale);
    }

    @Override
    public String getClassName(int classNum) {
        return "DLR101";
    }

}
