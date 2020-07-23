package com.actelion.research.orbit.imageAnalysis.deeplearning;

import com.actelion.research.orbit.imageAnalysis.models.PolygonExt;
import com.actelion.research.orbit.imageAnalysis.models.RectangleExt;
import com.actelion.research.orbit.imageAnalysis.models.SegmentationResult;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractDetections<T extends AbstractDetection> {
    protected List<T> detections;

    protected SegmentationResult segmentationResult;

    /**
     * Default constructor for the abstract class.
     */
    protected AbstractDetections() {
        detections = new ArrayList<>();
    }

    /**
     * Get the segmentation result.
     * @return Result from segmentation.
     */
    public SegmentationResult getSegmentationResult() {
        return segmentationResult;
    }

    /**
     * Assign a segmentation result from an Orbit Model that has been applied to the detections
     * in the object.
     * @param segmentationResult Result from segmentation.
     */
    public void setSegmentationResult(SegmentationResult segmentationResult) {
        this.segmentationResult = segmentationResult;
    }

    /**
     * List of contour PolygonExts for the detections.
     * @return List of contour PolygonExts for the detections.
     */
    public List<PolygonExt> getContours() {
        return this.detections
                .stream()
                .map(e -> e.contour)
                .collect(Collectors.toList());
    }

    /**
     * List of contour shapes for the detections.
     * @return List of contour shapes for the detections.
     */
    public List<Shape> getContourShapes() {
        return this.detections
                .stream()
                .map(e -> (Shape) e.contour)
                .collect(Collectors.toList());
    }

    /**
     * List of class IDs for the detections.
     * @return List of class IDs for the detections.
     */
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

    /**
     * Get a specific detection.
     * @param i Index of detection.
     * @return The detection.
     */
    public T getDetection(int i) {
        // TODO: e.g. contours may not always be defined.
        return detections.get(i);
    }

    /**
     * Get the list of detections.
     * @return List of detections.
     */
    public List<T> getDetections() {
        return this.detections
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public int getNumDetections() {
        return Math.toIntExact(this.detections
                .stream()
                .filter(Objects::nonNull)
                .count());
    }

    /**
     * Remove detection by index.
     * @param i index of detection to remove.
     */
    public void removeDetection(int i) {
        detections.remove(i);
        // TODO: Update the segmentation model result?
    }

    public abstract void addDetection(PolygonExt contour, RectangleExt boundingBox, Float classProbability, Integer maskClass, Point tileOffset);

    public void addDetection(List<? extends AbstractDetection> detections) {
        this.detections.addAll((Collection<? extends T>) detections);
    }

    /**
     * String representation of detections object.
     * @return String
     */
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
