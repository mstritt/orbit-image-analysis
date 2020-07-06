package com.actelion.research.orbit.imageAnalysis.deeplearning;

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImageIOrbitImage;

import java.awt.*;
import java.util.List;
import java.util.Map;

public interface IDLSegment<T, U> {

    Map<Integer, List<Shape>> generateSegmentationAnnotations(int[] images,
                                                              OrbitModel orbitSegModel,
                                                              OrbitModel modelContainingExclusionModel,
                                                              Point tileOnly,
                                                              boolean storeAnnotations);

    Map<Integer, List<Shape>> generateSegmentationAnnotations(int[] images,
                                                              OrbitModel orbitSegModel,
                                                              OrbitModel modelContainingExclusionModel,
                                                              boolean storeAnnotations);

    Map<Integer, List<Shape>> generateSegmentationAnnotations(int[] images,
                                                              U segmentationSettings,
                                                              OrbitModel orbitSegModel,
                                                              OrbitModel modelContainingExclusionModel,
                                                              Point tileOnly,
                                                              boolean storeAnnotations);

    Map<Integer, List<Shape>> generateSegmentationAnnotations(List<RawDataFile> rdfList,
                                                              U segmentationSettings,
                                                              OrbitModel orbitSegModel,
                                                              OrbitModel modelContainingExclusionModel,
                                                              Point tile,
                                                              boolean storeAnnotations);

    T segmentationImplementation(OrbitModel segModel, OrbitTiledImageIOrbitImage orbitImage, Point tile);

    void storeShape(Shape shape, String name, Color color, int rdfId, String user) throws Exception;

    void storeShapes(List<Shape> shapes, String basename, int rdfId, String user) throws Exception;

    void storeShapes(T detections, U settings, int rdfId, String user) throws Exception;

    T processDetections(SegmentationResult segRes, Point tileOffset);

}
