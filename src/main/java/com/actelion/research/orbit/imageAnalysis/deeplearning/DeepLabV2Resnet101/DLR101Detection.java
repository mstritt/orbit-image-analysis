package com.actelion.research.orbit.imageAnalysis.deeplearning.DeepLabV2Resnet101;

import com.actelion.research.orbit.imageAnalysis.deeplearning.AbstractDetection;
import com.actelion.research.orbit.imageAnalysis.models.PolygonExt;
import com.actelion.research.orbit.imageAnalysis.models.RectangleExt;

import java.awt.*;

public class DLR101Detection extends AbstractDetection {

    DLR101Detection(PolygonExt contour, Float classProbability, Integer detectionClass, Point tileOffset) {
        super(contour, classProbability, detectionClass, tileOffset);
    }

}
