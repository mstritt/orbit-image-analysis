package com.actelion.research.orbit.imageAnalysis.deeplearning.DeepLabV2Resnet101;

import com.actelion.research.orbit.imageAnalysis.deeplearning.AbstractSegmentationSettings;

public class DLR101SegmentationSettings extends AbstractSegmentationSettings {

    public DLR101SegmentationSettings(int imageWidth, int imageHeight, float tileScaleFactor, String annotationPrefix) {
        this(imageWidth, imageHeight, tileScaleFactor, tileScaleFactor, annotationPrefix);
    }

    public DLR101SegmentationSettings(int imageWidth, int imageHeight, float tileScaleFactorX, float tileScaleFactorY, String annotationPrefix) {
        super(imageWidth, imageHeight, tileScaleFactorX, tileScaleFactorY, annotationPrefix);
    }

    @Override
    public String getClassName(int classNum) {
        return "Glomeruli";
    }
}
