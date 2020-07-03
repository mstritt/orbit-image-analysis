package com.actelion.research.orbit.imageAnalysis.deeplearning;

import com.actelion.research.orbit.imageAnalysis.models.PolygonExt;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractDetections<T> {
    protected List<T> detections = null;

    protected AbstractDetections() {

    }

    public List<PolygonExt> getContours() {
        return this.detections
                .stream()
                .filter(e -> e instanceof AbstractDetection)
                .map(e -> ((AbstractDetection) e).contour)
                .collect(Collectors.toList());
    }

    public List<Shape> getContourShapes() {
        return this.detections
                .stream()
                .filter(e -> e instanceof AbstractDetection)
                .map(e -> (Shape) ((AbstractDetection) e).contour)
                .collect(Collectors.toList());
    }

    public List<Integer> getDetectionClasses() {
        return this.detections
                .stream()
                .filter(e -> e instanceof AbstractDetection)
                .map(e -> ((AbstractDetection) e).detectionClass)
                .collect(Collectors.toList());
    }

    public List<Float> getProbabilities() {
        return this.detections
                .stream()
                .filter(e -> e instanceof AbstractDetection)
                .map(e -> ((AbstractDetection) e).classProbability)
                .collect(Collectors.toList());
    }

    public List<Point> getTileOffset() {
        return this.detections
                .stream()
                .filter(e -> e instanceof AbstractDetection)
                .map(e -> ((AbstractDetection) e).tileOffset)
                .collect(Collectors.toList());
    }

    public T getDetection(int i) {
        // TODO: e.g. contours may not always be defined.
        return detections.get(i);
    }

    public abstract List<T> getDetections();

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
