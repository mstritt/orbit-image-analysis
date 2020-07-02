package com.actelion.research.orbit.imageAnalysis.deeplearning;

import com.actelion.research.orbit.imageAnalysis.models.PolygonExt;

import java.awt.*;

public abstract class AbstractDetection {
    final PolygonExt contour;
    final Float classProbability;
    final Integer detectionClass;
    final Point tileOffset;

    protected AbstractDetection(PolygonExt contour, Float classProbability, Integer detectionClass, Point tileOffset) {
        this.contour = contour;
        this.classProbability = classProbability;
        this.detectionClass = detectionClass;
        this.tileOffset = tileOffset;
    }

    public PolygonExt getContour() {
        return contour;
    }

    public Shape getContourShape() { return contour; }

    public Float getClassProbability() {
        return classProbability;
    }

    public Integer getDetectionClass() {
        return detectionClass;
    }

    public Point getTileOffset() { return tileOffset; }

}
