package com.actelion.research.orbit.imageAnalysis.deeplearning.DeepLabV2Resnet101;

import com.actelion.research.orbit.imageAnalysis.deeplearning.AbstractSegmentationSettings;

import java.io.Serializable;
import java.net.URL;

public class DLR101SegmentationSettings extends AbstractSegmentationSettings<DLR101SegmentationSettings> implements Serializable, Cloneable {

    public DLR101SegmentationSettings(String modelDisplayName, String modelName, String remoteModelURL, String modelPath, int imageWidth, int imageHeight, float tileScaleFactor, String annotationPrefix, boolean segmentationRefinement) {
        this(modelDisplayName, modelName, remoteModelURL, modelPath, imageWidth, imageHeight,
                tileScaleFactor, tileScaleFactor,
                annotationPrefix, 120d,
                segmentationRefinement);
    }

    public DLR101SegmentationSettings(String modelDisplayName, String modelName, String remoteModelURL, String modelPath, int imageWidth, int imageHeight,
                                      float tileScaleFactorX, float tileScaleFactorY,
                                      String annotationPrefix, double detectionToleranceScale,
                                      boolean segmentationRefinement) {
        super(modelDisplayName, modelName, remoteModelURL, modelPath, imageWidth, imageHeight,
                tileScaleFactorX, tileScaleFactorY,
                annotationPrefix, segmentationRefinement,
                detectionToleranceScale);
    }

    @Override
    public String getClassName(int classNum) {
        return "DLR101";
    }

}
