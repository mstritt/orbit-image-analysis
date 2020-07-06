package com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN;

import com.actelion.research.orbit.imageAnalysis.deeplearning.AbstractDetection;
import com.actelion.research.orbit.imageAnalysis.models.PolygonExt;
import com.actelion.research.orbit.imageAnalysis.models.RectangleExt;

import java.awt.*;

public class MaskRCNNDetection extends AbstractDetection {

    final RectangleExt boundingBox;

    MaskRCNNDetection(PolygonExt contour, RectangleExt boundingBox, Float classProbability, Integer detectionClass, Point tileOffset) {
        super(contour, classProbability, detectionClass, tileOffset);
        this.boundingBox = boundingBox;
    }

    public RectangleExt getBoundingBox() {
        return boundingBox;
    }

}
