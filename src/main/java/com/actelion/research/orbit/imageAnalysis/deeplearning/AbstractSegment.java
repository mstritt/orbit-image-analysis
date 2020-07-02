package com.actelion.research.orbit.imageAnalysis.deeplearning;

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNDetection;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNDetections;
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImageIOrbitImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractSegment implements IDLSegment {

    protected static Logger logger = LoggerFactory.getLogger(AbstractSegment.class);

    /**
     * Convenience method to call the generic generateSegmentationAnnotations() method.
     * @param images list of rdfIds for images to be segmented.
     * @param segModel Segmentation Model?
     * @param modelContainingExclusionModel An exclusion model, used to focus on only the area of interest (e.g.
     *                                      ignore artifacts, blank area) and (probably) speed up the calculation
     *                                      by ignoring uninteresting areas.
     * @param storeAnnotations Should the annotations be stored back to the Orbit DB?
     * @param tile The tile coordinates for processing a specific image tile only.
     * @return Map with RdfId as key and annotations as List<Shape> (segmentationsPerImage).
     */
    public Map<Integer, List<Shape>> generateSegmentationAnnotations(int[] images, OrbitModel segModel, OrbitModel modelContainingExclusionModel, boolean storeAnnotations, Point tile) {
        List<RawDataFile> rdfList = new ArrayList<>(images.length);
        try {
            for (int image : images) {
                rdfList.add(DALConfig.getImageProvider().LoadRawDataFile(image));
            }
        } catch (Exception ex) {
            logger.error("Could not read Raw Data File");
            logger.error(ex.getLocalizedMessage());
        }
        return generateSegmentationAnnotations(rdfList,segModel,modelContainingExclusionModel,storeAnnotations, tile);
    }

    /**
     * Convenience method to call the generic generateSegmentationAnnotations() method.
     * @param images list of rdfIds for images to be segmented.
     * @param segModel Segmentation Model?
     * @param modelContainingExclusionModel An exclusion model, used to focus on only the area of interest (e.g.
     *                                      ignore artifacts, blank area) and (probably) speed up the calculation
     *                                      by ignoring uninteresting areas.
     * @param storeAnnotations Should the annotations be stored back to the Orbit DB?
     * @return Map with RdfId as key and annotations as List<Shape> (segmentationsPerImage).
     */
    public Map<Integer, List<Shape>> generateSegmentationAnnotations(int[] images, OrbitModel segModel, OrbitModel modelContainingExclusionModel, boolean storeAnnotations) {
        return generateSegmentationAnnotations(images,segModel,modelContainingExclusionModel,storeAnnotations, null);
    }

    public abstract Map<Integer, List<Shape>> generateSegmentationAnnotations(List<RawDataFile> rdfList, OrbitModel segModel, OrbitModel modelContainingExclusionModel, boolean storeAnnotations, Point tile);

    public abstract MaskRCNNDetections segmentationImplementation(OrbitModel segModel, OrbitTiledImageIOrbitImage orbitImage, Point tile);


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
        for (MaskRCNNDetection detection: detections.getDetections()) {
            int maskClass = detection.getDetectionClass();

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
