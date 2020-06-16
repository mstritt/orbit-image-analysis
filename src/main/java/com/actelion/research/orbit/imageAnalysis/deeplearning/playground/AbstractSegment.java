package com.actelion.research.orbit.imageAnalysis.deeplearning.playground;

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.deeplearning.IDLSegment;
import com.actelion.research.orbit.imageAnalysis.deeplearning.playground.maskRCNN.AbstractSegmentationSettings;
import com.actelion.research.orbit.imageAnalysis.deeplearning.playground.maskRCNN.MaskRCNNDetections;
import com.actelion.research.orbit.imageAnalysis.models.*;

import java.awt.*;
import java.util.List;
import java.util.Map;

public abstract class AbstractSegment implements IDLSegment {

    public abstract Map<Integer, List<Shape>> generateSegmentationAnnotations(int[] images, OrbitModel segModel, OrbitModel modelContainingExclusionModel, boolean storeAnnotations);

    public abstract Map<Integer, List<Shape>> generateSegmentationAnnotations(List<RawDataFile> rdfList, OrbitModel segModel, OrbitModel modelContainingExclusionModel, boolean storeAnnotations);


    @Override
    public void storeShape(Shape shape, String name, Color color, int rdfId, String user) throws Exception {
        ClassShape classShape = new ClassShape(name, color, ClassShape.SHAPETYPE_POLYGONEXT);
        classShape.getShapeList().add(shape);
        SpotAnnotation spot = new MaskRCNNAnnotation(name, classShape);
        spot.setRawDataFileId(rdfId);
        spot.setUserId(user);
        DALConfig.getImageProvider().InsertRawAnnotation(spot);
    }

    @Override
    public void storeShapes(List<Shape> shapes, String basename, int rdfId, String user) throws Exception {
        int total = 0;
        for (Shape shape: shapes) {
            total++;
            storeShape(shape,basename+"_"+total,Color.GREEN, rdfId,user);
        }
    }

    @Override
    public void storeShapes(MaskRCNNDetections detections, String basename, AbstractSegmentationSettings settings, int rdfId, String user) throws Exception {
        for (MaskRCNNDetections.Detection detection: detections.getDetections()) {
            int maskClass = detection.getMaskClass();
            System.out.println("Storing annotation...");
            storeShape(detection.getContourShape(), basename+settings.getClassName(maskClass), settings.getAnnotationColor(maskClass), rdfId, user);
        }
    }

}
