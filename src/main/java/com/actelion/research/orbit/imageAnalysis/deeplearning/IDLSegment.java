package com.actelion.research.orbit.imageAnalysis.deeplearning;

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.deeplearning.playground.maskRCNN.AbstractSegmentationSettings;
import com.actelion.research.orbit.imageAnalysis.deeplearning.playground.maskRCNN.MaskRCNNDetections;
import com.actelion.research.orbit.imageAnalysis.models.CellDetectionAnnotation;
import com.actelion.research.orbit.imageAnalysis.models.ClassShape;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.models.SpotAnnotation;
import org.tensorflow.Session;

import java.awt.*;
import java.util.List;
import java.util.Map;

public interface IDLSegment {

    Map<Integer, java.util.List<Shape>> generateSegmentationAnnotations(int[] images, OrbitModel segModel, OrbitModel modelContainingExclusionModel, boolean storeAnnotations);

    Map<Integer, List<Shape>> generateSegmentationAnnotations(List<RawDataFile> rdfList, OrbitModel segModel, OrbitModel modelContainingExclusionModel, boolean storeAnnotations);

    void storeShape(Shape shape, String name, Color color, int rdfId, String user) throws Exception;

    void storeShapes(List<Shape> shapes, String basename, int rdfId, String user) throws Exception;

    void storeShapes(MaskRCNNDetections detections, String basename, AbstractSegmentationSettings settings, int rdfId, String user) throws Exception;
}
