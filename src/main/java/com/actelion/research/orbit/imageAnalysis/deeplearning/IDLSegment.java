package com.actelion.research.orbit.imageAnalysis.deeplearning;

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNDetections;
import com.actelion.research.orbit.imageAnalysis.models.*;

import java.awt.*;
import java.util.List;
import java.util.Map;

public interface IDLSegment<T> {

    Map<Integer, List<Shape>> generateSegmentationAnnotations(int[] images, OrbitModel segModel, OrbitModel modelContainingExclusionModel, boolean storeAnnotations, Point tile);

    Map<Integer, java.util.List<Shape>> generateSegmentationAnnotations(int[] images, OrbitModel segModel, OrbitModel modelContainingExclusionModel, boolean storeAnnotations);

    Map<Integer, List<Shape>> generateSegmentationAnnotations(List<RawDataFile> rdfList, OrbitModel segModel, OrbitModel modelContainingExclusionModel, boolean storeAnnotations, Point tile);

    void storeShape(Shape shape, String name, Color color, int rdfId, String user) throws Exception;

    void storeShapes(List<Shape> shapes, String basename, int rdfId, String user) throws Exception;

    void storeShapes(T detections, AbstractSegmentationSettings<T> settings, int rdfId, String user) throws Exception;

    T processDetections(SegmentationResult segRes, Point tileOffset);

}
