package com.actelion.research.orbit.imageAnalysis.deeplearning;

import com.actelion.research.orbit.imageAnalysis.models.PolygonExt;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractDetections {
    protected List<AbstractDetection> detections = null;

    protected AbstractDetections() {

    }

    public List<PolygonExt> getContours() {
        return this.detections
                .stream()
                .map(e -> e.contour)
                .collect(Collectors.toList());
    }

    public List<Shape> getContourShapes() {
        return this.detections
                .stream()
                .map(e -> (Shape) e.contour)
                .collect(Collectors.toList());
    }

    public List<Integer> getDetectionClasses() {
        return this.detections
                .stream()
                .map(e -> e.detectionClass)
                .collect(Collectors.toList());
    }

    public List<Float> getProbabilities() {
        return this.detections
                .stream()
                .map(e -> e.classProbability)
                .collect(Collectors.toList());
    }

    public List<Point> getTileOffset() {
        return this.detections
                .stream()
                .map(e -> e.tileOffset)
                .collect(Collectors.toList());
    }

    public AbstractDetection getDetection(int i) {
        // TODO: e.g. contours may not always be defined.
        return detections.get(i);
    }

    public abstract List<? extends AbstractDetection> getDetections();

    public String toString() {

        return "Detections Object Details: " +
                "\n" +
                "Contours: " +
                getContours().toString() +
                "\n" +
                "Probabilities: " +
                getProbabilities().toString() +
                "\n" +
                "Detection Classes: " +
                getDetectionClasses().toString() +
                "\n";
    }

}
