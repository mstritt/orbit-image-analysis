package com.actelion.research.orbit.imageAnalysis.deeplearning.DeepLabV2Resnet101;

import com.actelion.research.orbit.imageAnalysis.deeplearning.AbstractSegmentationSettings;

public class DLR101SegmentationSettings extends AbstractSegmentationSettings<DLR101SegmentationSettings> {

    public DLR101SegmentationSettings(int imageWidth, int imageHeight, float tileScaleFactor, String annotationPrefix, boolean segmentationRefinement) {
        this(imageWidth, imageHeight, tileScaleFactor, tileScaleFactor, annotationPrefix, segmentationRefinement);
    }

    public DLR101SegmentationSettings(int imageWidth, int imageHeight, float tileScaleFactorX, float tileScaleFactorY, String annotationPrefix, boolean segmentationRefinement) {
        super(imageWidth, imageHeight, tileScaleFactorX, tileScaleFactorY, annotationPrefix, segmentationRefinement);
    }

    @Override
    public String getClassName(int classNum) {
        return "DLR101";
    }
}
