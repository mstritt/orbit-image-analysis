package com.actelion.research.orbit.imageAnalysis.deeplearning;

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNDetections;
import com.actelion.research.orbit.imageAnalysis.models.*;

import java.awt.*;
import java.util.List;
import java.util.Map;

public abstract class AbstractSegment implements IDLSegment {

    public abstract Map<Integer, List<Shape>> generateSegmentationAnnotations(int[] images, OrbitModel segModel, OrbitModel modelContainingExclusionModel, boolean storeAnnotations, Point tile);

    public abstract Map<Integer, List<Shape>> generateSegmentationAnnotations(int[] images, OrbitModel segModel, OrbitModel modelContainingExclusionModel, boolean storeAnnotations);

    public abstract Map<Integer, List<Shape>> generateSegmentationAnnotations(List<RawDataFile> rdfList, OrbitModel segModel, OrbitModel modelContainingExclusionModel, boolean storeAnnotations, Point tile);

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
    public void storeShapes(MaskRCNNDetections detections, AbstractSegmentationSettings settings,
                            int rdfId, String user) throws Exception {
        //TODO: The translation parts should be moved out of this to the detections methods.
        int i=1;
        for (MaskRCNNDetections.Detection detection: detections.getDetections()) {
            int maskClass = detection.getMaskClass();

            PolygonExt shape = (PolygonExt) detection.getContourShape();

            storeShape(shape,
                    settings.getAnnotationPrefix()+"_"+settings.getClassName(maskClass),
                    settings.getAnnotationColor(maskClass), rdfId, user);
            i++;
        }
    }

    @Override
    public abstract MaskRCNNDetections processDetections(SegmentationResult segRes, Point tileOffset);
}
