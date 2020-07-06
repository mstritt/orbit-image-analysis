package com.actelion.research.orbit.imageAnalysis.deeplearning;

import com.actelion.research.orbit.imageAnalysis.models.PolygonExt;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class AbstractDetections<T extends AbstractDetection> {
    protected List<T> detections;

    protected AbstractDetections() {
        detections = new ArrayList<>();
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

    public List<Point> getTileOffset() {
        return this.detections
                .stream()
                .map(e -> e.tileOffset)
                .collect(Collectors.toList());
    }

    public T getDetection(int i) {
        // TODO: e.g. contours may not always be defined.
        return detections.get(i);
    }

    public List<T> getDetections() {
        return this.detections
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public String toString() {

        return "Detections Object Details: " +
                "\n" +
                "Contours: " +
                getContours().toString() +
                "\n" +
                "Detection Classes: " +
                getDetectionClasses().toString() +
                "\n";
    }

}
