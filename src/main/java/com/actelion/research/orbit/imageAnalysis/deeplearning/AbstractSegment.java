package com.actelion.research.orbit.imageAnalysis.deeplearning;

import com.actelion.research.orbit.beans.RawAnnotation;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNDetection;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNDetections;
import com.actelion.research.orbit.imageAnalysis.imaging.TileSizeWrapper;
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.tasks.ExclusionMapGen;
import com.actelion.research.orbit.imageAnalysis.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

public abstract class AbstractSegment<T extends AbstractSegmentationSettings<T>> implements IDLSegment<T> {

    protected static Logger logger = LoggerFactory.getLogger(AbstractSegment.class);
    public final T segmentationSettings;

    protected AbstractSegment(T segmentationSettings) {
        this.segmentationSettings = segmentationSettings;
    }

//    protected abstract T me();
//
//    public T baz() {
//        return me();
//    }

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

    /**
     * Create annotations that can optionally be written to Orbit DB.
     * @param rdfList List of images (RDFs) to be processed.
     * @param segModel Segmentation model?
     * @param modelContainingExclusionModel An exclusion model, used to focus on only the area of interest (e.g.
     *                                      ignore artifacts, blank area) and (probably) speed up the calculation
     *                                      by ignoring uninteresting areas.
     * @param storeAnnotations Should the annotations be stored back to the Orbit DB?
     * @return Map with RdfId as key and annotations as List<Shape> (segmentationsPerImage).
     */
    public Map<Integer, List<Shape>> generateSegmentationAnnotations(List<RawDataFile> rdfList, OrbitModel segModel, AbstractSegmentationSettings<T> segmentationSettings, OrbitModel modelContainingExclusionModel, boolean storeAnnotations, Point tileOnly) {
        // TODO: roiGenerator - analagous to exMapGen - returns list of ROIs.
        Map<Integer, List<Shape>> segmentationsPerImage = new HashMap<>();
        // Loop over images.
        for (RawDataFile rdf : rdfList) {
            long startt = System.currentTimeMillis();
            OrbitTiledImage2.resetTileCache();
            int rdfId = rdf.getRawDataFileId();
            logger.info("rdfid: " + rdfId);
            List<Shape> segmentationShapes = new ArrayList<>();

            // Get annotations already existing for the image.
            List<RawAnnotation> annotations = null;
            try {
                annotations = DALConfig.getImageProvider().LoadRawAnnotationsByRawDataFile(rdfId, RawAnnotation.ANNOTATION_TYPE_IMAGE);
            } catch (Exception e) {
                logger.error("Could not read Raw Annotations.");
                logger.error(e.getLocalizedMessage());
            }

            // TODO: Consider union case, and also separate Rois.
            // Extract the different types of annotation.
            List<ImageAnnotation> rois = new ArrayList<>();
            List<Shape> exclusions = new ArrayList<>();
            List<Shape> inclusions = new ArrayList<>();
            for (RawAnnotation annotation : Objects.requireNonNull(annotations)) {
                ImageAnnotation ia = null;
                try {
                    ia = new ImageAnnotation(annotation);
                } catch (IOException | ClassNotFoundException e) {
                    logger.error(e.getLocalizedMessage());
                }
                if (Objects.requireNonNull(ia).getSubType() == ImageAnnotation.SUBTYPE_ROI) rois.add(ia);
                else if (ia.getSubType() == ImageAnnotation.SUBTYPE_EXCLUSION) exclusions.add(ia.getFirstShape());
                //TODO: Add inclusions. Can be used by a standard method?
                //    public ShapeAnnotationList(List<RawAnnotation> annotations, int annotationGroup, Rectangle outerBounds) {
                // loadRoi ???
            }

            // Retrieve the actual image.
            RecognitionFrame rf = null;
            try {
                rf = new RecognitionFrame(rdf);
            } catch (OrbitImageServletException e) {
                logger.error(e.getLocalizedMessage());
            }

            TileSizeWrapper tileSizeWrapper = new TileSizeWrapper(
                    new OrbitImagePlanar(Objects.requireNonNull(rf).bimg.getImage(), ""),
                    segmentationSettings.getTrainingImageTileWidth(),
                    segmentationSettings.getTrainingImageTileHeight());

            OrbitTiledImageIOrbitImage orbitImage = new OrbitTiledImageIOrbitImage(tileSizeWrapper);

            // Apply the Exclusion map.
            ExclusionMapGen exclusionMapGen = null;
            // TODO: Re-enable when JAI issue is fixed.
//            if (modelContainingExclusionModel != null && modelContainingExclusionModel.getExclusionModel() != null) {
//                exclusionMapGen = ExclusionMapGen.constructExclusionMap(rdf, rf, modelContainingExclusionModel);
//                if (exclusionMapGen != null) {
//                    try {
//                        exclusionMapGen.generateMap();
//                    } catch (OrbitImageServletException e) {
//                        logger.error(e.getLocalizedMessage());
//                    }
//                }
//            }

            // For existing ROI annotations (from Orbit DB) define a roiDef and add it to a list of all roiDefs.
            List<Shape> roiDefList = new ArrayList<>();
            for (ImageAnnotation roiAnnotation : rois) {
                IScaleableShape roiShape = (IScaleableShape) roiAnnotation.getFirstShape();
                roiShape = (IScaleableShape) roiShape.getScaledInstance(100d, new Point(0, 0));
                ShapeAnnotationList roiDef = new ShapeAnnotationList(inclusions, exclusions, roiShape, roiShape.getBounds());
                roiDefList.add(roiDef);
            }
            if (roiDefList.size() == 0) {   // no ROI annotations, so create one around the whole image
                roiDefList.add(new RectangleExt(0, 0, rf.bimg.getWidth(), rf.bimg.getHeight()));
            }

            // Process all roiDefs.
            for (Shape roiDef : roiDefList) {
                Point[] tiles = orbitImage.getTileIndices(roiDef.getBounds());
                int tileNr = 0;
                // Process all tiles from the image.
                for (Point tile : tiles) {
                    tileNr++;
                    logger.info("tile " + tileNr + " of " + tiles.length);
                    logger.info("tileX: "+tile.x+" tileY: "+tile.y);
                    // Test if the tile is in the ROI, and not exclusively part of the exclusion map.
                    // if (!(tile.x==15 && tile.y==12)) continue;   // for testing: just on one tile
                    if (tileOnly != null) {
                        if (!(tile.x==tileOnly.x && tile.y==tileOnly.y)) continue;
                    }
                    if (OrbitUtils.isTileInROI(tile.x, tile.y, orbitImage, roiDef, exclusionMapGen)) {
                        // Calculate Tile Offset for translating annotations.
                        MaskRCNNDetections detections = segmentationImplementation(segModel, orbitImage, tile);

                        logger.info("shapes before filtering: " + detections.getDetections().size());
                        // TODO: Re-enable
                        //segmentationShapes = DLSegment.filterShapes(segmentationShapes);
                        logger.info("shapes after filtering: " + detections.getDetections().size());
                        if (storeAnnotations && detections.getDetections().size() > 0) {
                            logger.info("storing annotations in DB");
                            try {
                                // TODO: Fix this.
                                // If running in GUI mode force user to login, else use a hardcoded user.
                                if (!ScaleoutMode.SCALEOUTMODE.get()) {
                                    OrbitImageAnalysis.getInstance().forceLogin();
                                    this.storeShapes(detections, segmentationSettings, rdfId, "AutomatedAnnotation");
                                } else {
                                    this.storeShapes(detections, segmentationSettings, rdfId, "AutomatedAnnotation");
                                }
                            } catch (Exception e) {
                                logger.error(e.getLocalizedMessage());
                            }
                        }
                        segmentationsPerImage.put(rdfId, detections.getContourShapes());
                        long usedt = System.currentTimeMillis() - startt;
                        logger.info("used time(h) for image: " + (usedt / 60000) / 60);
                    }
                }
            }
        }
        return segmentationsPerImage;
    }

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

    public void storeShapes(MaskRCNNDetections detections, AbstractSegmentationSettings<T> settings,
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
