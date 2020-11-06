/*
 * Orbit, a versatile image analysis software for biological image-based quantification.
 * Copyright (C) 2009 - 2020 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.actelion.research.orbit.imageAnalysis.tasks;

import com.actelion.research.orbit.beans.RawAnnotation;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.deeplearning.*;
import com.actelion.research.orbit.imageAnalysis.deeplearning.DeepLabV2Resnet101.DLR101Detections;
import com.actelion.research.orbit.imageAnalysis.deeplearning.DeepLabV2Resnet101.DLR101Segment;
import com.actelion.research.orbit.imageAnalysis.deeplearning.DeepLabV2Resnet101.DLR101SegmentationSettings;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNDetection;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNDetections;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNSegment;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNSegmentationSettings;
import com.actelion.research.orbit.imageAnalysis.imaging.TileSizeWrapper;
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.utils.*;

import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Object segmentation based on a foreground/background image.
 */
public class DLSegmentationWorker extends OrbitWorker {
    private int minSegmentationSize = 10;
    private final static Logger logger = LoggerFactory.getLogger(DLSegmentationWorker.class);
    private RecognitionFrame rf = null;
    private List<Point> tiles = null;
    private OrbitModel model = null; // only used for feature(names) builder. Internally the segmentationModel (and secondary) are used for convenience.
    private OrbitModel segmentationModel = null; // the (primary) segmentation model, in GUI mode the model from OrbitImageAnalysis.getInstance() will be taken
    private OrbitModel secondarySegmentationModel = null;  // used for segmentation inside a segmentation
    private ExclusionMapGen exclusionMapGen = null;
    private List<ClassShape> oldClassShapes = null;
    List<Shape> roiDefList = null;

    private final SegmentationResult segmentationResult = new SegmentationResult();
    private final RecognitionFrame originalFrame = null;

    private int numThreads = Runtime.getRuntime().availableProcessors();

    private RawDataFile rdf;


    /**
     * roi is taken from rf
     * tiles can be null
     *
     * @param rf
     * @param dependencyList
     * @param classShapeToSet
     * @param tiles:          a list of tiles on which the segmentation should be performed. If it is null, all tiles will be used.
     */
    public DLSegmentationWorker(RawDataFile rdf, RecognitionFrame rf, List<SwingWorker<Void, Void>> dependencyList, List<ClassShape> classShapeToSet, List<Point> tiles) {
        this.rf = rf;
        this.rdf = rdf;

        if (classShapeToSet != null) {
            // TODO: Tidy up this...
            if (rf.getClassShapes() != null)
                this.oldClassShapes =  SerializationUtils.clone(new ArrayList<>(rf.getClassShapes())); // remember original classShapes workaround (dirty fix...). Must be cloned because rf.setClassShapes will clear() and addAll() (next line).
            this.rf.setClassShapes(classShapeToSet);
            logger.debug("old classShapes saved");
        } else {
            logger.warn("classShapes must not be null. Please set the classShapes to the classShapes of the segmentation model!");
        }
        this.dependencyList = dependencyList;
        // set minSegmentationSize for now - but setModel will overwrite!!!
        if (rf != null)
            this.minSegmentationSize = rf.getFeatureDescription().getMinSegmentationSize();
        this.tiles = tiles;
        if (rf != null)
            this.rf.initializeClassColors();
    }

    @Override
    protected void doWork() {
        try {

            if (withGUI && !ScaleoutMode.SCALEOUTMODE.get() && numThreads > 1)
                numThreads--; // in GUI mode reserve one thread for GUI

            IScaleableShape oldROI = rf.getROI();

            // init maskrcnn segmentation
            assert segmentationModel != null;
//<D extends AbstractDetections<? extends AbstractDetection>,S extends AbstractSegmentationSettings<?>>
            AbstractSegmentationSettings<?> dlSegmentSettings = segmentationModel.getFeatureDescription().getDLSegment();
//            AbstractSegment<? extends AbstractDetections<? extends AbstractDetection>,
//                    ? extends AbstractSegmentationSettings<?>> dLSegmentationModel = null;
            AbstractSegment dLSegmentationModel = null;

            String modelType = dlSegmentSettings.getModelDisplayName();
            // Decide which DL model to apply...
            switch (modelType) {
                case "Nuclei":
                case "Pancreas Islets (Identify only)":
                case "Pancreas Islets (Identify and Classify)":
                    dLSegmentationModel = new MaskRCNNSegment((MaskRCNNSegmentationSettings) dlSegmentSettings);
                    break;
                case "Glomeruli":
                    dLSegmentationModel = new DLR101Segment((DLR101SegmentationSettings) dlSegmentSettings);
                    break;
                case "Corpus Callosum":
                    // TODO: This needs implementing...
                    break;
                case "Brain":
                    dLSegmentationModel = new MaskRCNNSegment((MaskRCNNSegmentationSettings) dlSegmentSettings);
                    break;
                default:
                    throw new NoSuchFieldException("No model for: " + dlSegmentSettings.getModelDisplayName());

            }
            setProgress(1);

            long startTimeImage = System.currentTimeMillis();
            OrbitTiledImage2.resetTileCache();

            roiDefList = getROIShapes();

            // DL Segmentation requires varying image sizes (to match those used for the training.
            TileSizeWrapper tileSizeWrapper = new TileSizeWrapper(
                    new OrbitImagePlanar(Objects.requireNonNull(rf).bimg.getImage(), ""),
                    dlSegmentSettings.getTrainingImageTileWidth(),
                    dlSegmentSettings.getTrainingImageTileHeight());

            OrbitTiledImageIOrbitImage orbitImage = new OrbitTiledImageIOrbitImage(tileSizeWrapper);

            // Generate exclusion map
            if ((exclusionMapGen != null) && (!exclusionMapGen.isGenerated())) exclusionMapGen.generateMap();

            // Load the segmentation model (for post-processing DL seg).
            OrbitModel segModel = OrbitModel.LoadFromInputStream(
                    this.getClass().getResourceAsStream("/resource/testmodels/dlsegmentsplit.omo"));


            final AtomicInteger currentTileNum = new AtomicInteger(0);
            final AtomicInteger totalNumTiles = new AtomicInteger(0);
            final AtomicInteger allObjectCount = new AtomicInteger(0);


            final ExecutorService executor = Executors.newFixedThreadPool(numThreads);
            List<Callable<AbstractDetections<?>>> tileTaskList = new ArrayList<>();
            List<Future<AbstractDetections<?>>> tileSegments;

            // Process all roiDefs.
            for (Shape roiDef : roiDefList) {
                tiles = Arrays.asList(orbitImage.getTileIndices(roiDef.getBounds()));
                totalNumTiles.addAndGet(tiles.size());
                // Process all tiles from the image.
                for (Point tile : tiles) {
                    setProgress(getProgress());
                    AbstractSegment<? extends AbstractDetections<? extends AbstractDetection>, ? extends AbstractSegmentationSettings<?>> finalDLSegmentationModel = dLSegmentationModel;

                    tileTaskList.add(() -> {
                        AbstractDetections<?> detections;

                        if (isCancelled()) return null;
                        // TODO: This is sub-optimal for (potentially) long running jobs. Since only new (as yet
                        //  unprocessed) jobs get cancelled.

                        currentTileNum.incrementAndGet();
                        long startTimeTile = System.currentTimeMillis();
                        logger.info("tile " + currentTileNum.get() + " of " + totalNumTiles.get());
                        logger.info("tileX: " + tile.x + " tileY: " + tile.y);

                        // Test if the tile is in the ROI, and not exclusively part of the exclusion map.
                        if (OrbitUtils.isTileInROISlow(tile.x, tile.y, orbitImage, roiDef, exclusionMapGen)) {

                            detections = finalDLSegmentationModel.segmentationImplementation(segModel,
                                    orbitImage, tile, exclusionMapGen, roiDef);

//                            filterRoiDetections(roiDef, detections);

                            allObjectCount.addAndGet(detections.getNumDetections());

                            long usedTimeTile = System.currentTimeMillis() - startTimeTile;
                            long usedTimeImage = System.currentTimeMillis() - startTimeImage;
                            setProgress((int) (0.9*((double) currentTileNum.get() / (double) totalNumTiles.get()) * 100d));

                            logger.info("Time(s) for tile: " + (usedTimeTile / 1000));
                            logger.info("Current time(min) for image: " + (usedTimeImage / 60000));
                            logger.info("tileX: " + tile.x + " tileY: " + tile.y + " tile in ROI");
                        } else {
                            // If the tile isn't in the ROI, do nothing...
                            logger.info("tileX: " + tile.x + " tileY: " + tile.y + " not in ROI.");
                            return null;
                        }

                        return detections;
                    });
                } // tiles
            } // roidef

            logger.info("Tiles to process: "+ tileTaskList.size());

            setProgress(10);

            // Run the DL segmentation tasks.
            tileSegments = executor.invokeAll(tileTaskList);

            AbstractDetections<? extends AbstractDetection> allDetections = null;
            switch (modelType) {
                case "Nuclei":
                case "Pancreas Islets (Identify only)":
                case "Pancreas Islets (Identify and Classify)":
                    allDetections = getMaskRCNNDetections(tileSegments);
                    break;
                case "Brain":
                    break;
                case "Glomeruli":
                    allDetections = getDLR101Detections(tileSegments);
                    break;
                case "Corpus Callosum":
                    // TODO: This needs implementing...
                    break;
                default:
                    throw new NoSuchFieldException("No model for: " + dlSegmentSettings.getModelDisplayName());
            }


            executor.shutdownNow();

            filterRoiDetections(roiDefList, Objects.requireNonNull(allDetections));

            //rf.setROI(oldROI);
            if (oldClassShapes != null) {
                rf.setClassShapes(oldClassShapes);
                logger.debug("ClassShape Workaround: Old classShapes set.");
            }

            // set dummy classImage, otherwise no objectSegmentations would be rendered
            if (rf.getClassImage() == null)
                rf.setClassImage(new TiledImageWriter(1, 1, 1, 1));
            rf.setObjectSegmentationList(Objects.requireNonNull(allDetections).getContourShapes());
//            rf.setSecondaryObjectSegmentationList(allSegmentsAndFeatures.getSecondaryShapeList());

            // If the 'store annotations' flag is set, then write the annotations, otherwise display them
            // in the original frame (if it exists).
            if (rf.getFeatureDescription().isDeepLearningStoreAnnotations()) {
                if (!ScaleoutMode.SCALEOUTMODE.get()) {
//                    OrbitImageAnalysis.getInstance().forceLogin();
                    dLSegmentationModel.storeShapes(allDetections, dlSegmentSettings, this.rdf.getRawDataFileId(), OrbitImageAnalysis.loginUser);
                } else {
                    dLSegmentationModel.storeShapes(allDetections, dlSegmentSettings, this.rdf.getRawDataFileId(), "AutomatedAnnotation");
                }
            } else {
                // if an originalFrame is set, write back the scaled segmentation shapes
                // (this is for segmenting on a lower resolution image, not the original full res image)
                if (originalFrame != null && originalFrame != rf) {
                    if (rf.getObjectSegmentationList() != null) {
                        double originalCurrentFrameRatioInverse = this.originalFrame.bimg.getImage().getWidth() / (double) rf.bimg.getImage().getWidth();
                        if (originalFrame.getObjectSegmentationList() == null)
                            originalFrame.setObjectSegmentationList(new ArrayList<>(rf.getObjectSegmentationList().size()));
                        if (originalFrame.getSecondaryObjectSegmentationList() == null)
                            originalFrame.setSecondaryObjectSegmentationList(new ArrayList<>(rf.getSecondaryObjectSegmentationList() != null ? rf.getSecondaryObjectSegmentationList().size() : 0));
                        originalFrame.getObjectSegmentationList().clear();
                        originalFrame.getSecondaryObjectSegmentationList().clear();
                        for (Shape shape : rf.getObjectSegmentationList()) {
                            originalFrame.getObjectSegmentationList().add(((IScaleableShape) shape).getScaledInstance(originalCurrentFrameRatioInverse * 100d, new Point(0, 0)));
                        }
                        if (rf.getSecondaryObjectSegmentationList() != null) {
                            for (Shape shape : rf.getSecondaryObjectSegmentationList()) {
                                originalFrame.getSecondaryObjectSegmentationList().add(((IScaleableShape) shape).getScaledInstance(originalCurrentFrameRatioInverse * 100d, new Point(0, 0)));
                            }
                        }
                    }
                    this.originalFrame.setClassShapes(oldClassShapes);
                    this.originalFrame.setClassImage(rf.getClassImage());
                }
            }


            setProgress(100);

            // TODO: Generate a result string to output the object features.
            StringBuilder detectionStr = new StringBuilder("Detection Class\tClass Probability\n");
            switch (modelType) {
                case "Nuclei":
                case "Pancreas Islets (Identify only)":
                case "Pancreas Islets (Identify and Classify)":
                    MaskRCNNDetections allMaskRCNNDetections = (MaskRCNNDetections) allDetections;

                    for (MaskRCNNDetection detection : allMaskRCNNDetections.getDetections()) {
                        detectionStr.append(detection.getDetectionClass()).append("\t");
                        detectionStr.append(detection.getClassProbability()).append("\t");
                        detectionStr.append("\n");
                    }
                    break;
                case "Brain":
                    break;
                case "Glomeruli":
//                    allDetections = getDLR101Detections(tileSegments);
                    break;
                case "Corpus Callosum":
                    // TODO: This needs implementing...
                    break;
                default:
                    throw new NoSuchFieldException("No model for: " + dlSegmentSettings.getModelDisplayName());
            }

            taskResult = new TaskResult("Segmented objects (" + allDetections.getNumDetections() + " objects)", detectionStr.toString());

            if (rf.isVisible()) {
                rf.repaint();
            }

        } catch (InterruptedException | ExecutionException e) {
            logger.error("A problem occurred during the segmentation process.\n" +
                    "See the logs for further information.", e);
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private AbstractDetections<?> filterRoiDetections(List<Shape> roiDefList, AbstractDetections<?> detections) {
        logger.info("shapes before filtering (all in tile): " + detections.getDetections().size());
//        List<Integer> retain = new ArrayList<>();
        List<AbstractDetection> retainD = new ArrayList<>();
        List<AbstractDetection> dropD = new ArrayList<>();
        List<?> detectionsList = detections.getDetections();

        for (Shape roiDef : roiDefList) {
            for (Object detection: detectionsList) {
                if (detection instanceof AbstractDetection) {
                    AbstractDetection detection1 = (AbstractDetection) detection;

                    Shape contour = detection1.getContourShape();
                    int x = (int) contour.getBounds().getCenterX();
                    int y = (int) contour.getBounds().getCenterY();
                    if (OrbitUtils.isInROI(x, y, roiDef, exclusionMapGen)) {
                        // If the detection isn't in the ROI, then remove it.
    //                    detections.removeDetection(i);
    //                    retain.add(i);
                        retainD.add(detection1);
                    } else {
                        dropD.add(detection1);
                    }
                }
            }
        }
        dropD.removeAll(retainD);
        detections.removeDetections(dropD);
        logger.info("shapes after filtering (only in ROI): " + detections.getNumDetections());

        return detections;
//        for (AbstractDetection detection : detections.getDetections()) {
//        }
//        for (AbstractDetection detection : retainD) {
//            if (!detections.getDetections().contains(detection)) {
//                detections.removeDetection(detection);
//            }
//        }
        //        for (int i=0; i<detections.getNumDetections(); i++) {
//            if (!retain.contains(i)) {
//                detections.removeDetection();
//            }
//        }
    }

    private AbstractDetections<? extends AbstractDetection> getMaskRCNNDetections(List<Future<AbstractDetections<?>>> tileSegments) throws InterruptedException, ExecutionException {
        AbstractDetections<? extends AbstractDetection> allDetections;
        allDetections = new MaskRCNNDetections();
        for (Future<AbstractDetections<?>> flist : tileSegments) {
            if (flist != null && !flist.isCancelled() && flist.isDone()) {
                MaskRCNNDetections detections = (MaskRCNNDetections) flist.get();
                if (detections != null) {
                    allDetections.addDetection(detections.getDetections());
                }

                //allDetections.addDetection(flist.get().getDetections());
            }
        }
        return allDetections;
    }

    private AbstractDetections<? extends AbstractDetection> getDLR101Detections(List<Future<AbstractDetections<?>>> tileSegments) throws InterruptedException, ExecutionException {
        AbstractDetections<? extends AbstractDetection> allDetections;
        allDetections = new MaskRCNNDetections();
        for (Future<AbstractDetections<?>> flist : tileSegments) {
            if (flist != null && !flist.isCancelled() && flist.isDone()) {
                DLR101Detections detections = (DLR101Detections) flist.get();
                if (detections != null) {
                    allDetections.addDetection(detections.getDetections());
                }

                allDetections.addDetection(flist.get().getDetections());
            }
        }
        return allDetections;
    }

    /**
     * Currently we use a custom implementation to define the ROIs in an efficient manner, but we
     * may want to reconsider using the rf.getROI() method as used in the ObjectSegmentationWorker.
     * Extract the different types of annotation.
     * @return For existing ROI annotations (from Orbit DB) define a roiDef and add it to a list of all roiDefs.
     */
    private List<Shape> getROIShapes() {
        int rdfId = rdf.getRawDataFileId();
        logger.info("rdfid: " + rdfId);

        // Get annotations already existing for the image.
        List<RawAnnotation> annotations = null;
        try {
            annotations = DALConfig.getImageProvider().LoadRawAnnotationsByRawDataFile(rdfId, RawAnnotation.ANNOTATION_TYPE_IMAGE);
        } catch (Exception e) {
            logger.error("Could not read Raw Annotations.");
            logger.error(e.getLocalizedMessage());
        }

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
            else if (ia.getSubType() == ImageAnnotation.SUBTYPE_INCLUSION) inclusions.add(ia.getFirstShape());
        }

        // For existing ROI annotations (from Orbit DB) define a roiDef and add it to a list of all roiDefs.
        List<Shape> roiDefList = new ArrayList<>();
        for (ImageAnnotation roiAnnotation : rois) {
            IScaleableShape roiShape = (IScaleableShape) roiAnnotation.getFirstShape();
            roiShape = (IScaleableShape) roiShape.getScaledInstance(100d, new Point(0, 0));
            ShapeAnnotationList roiDefinition = new ShapeAnnotationList(inclusions, exclusions, roiShape, roiShape.getBounds());
            roiDefList.add(roiDefinition);
        }
        if (roiDefList.size() == 0) {   // no ROI annotations, so create one around the whole image
            roiDefList.add(new RectangleExt(0, 0, rf.bimg.getWidth(), rf.bimg.getHeight()));
            logger.info("No ROI defined, so using entire image for detections.");
        }
        return roiDefList;
    }


    public RecognitionFrame getRf() {
        return rf;
    }


    public void setRf(RecognitionFrame rf) {
        this.rf = rf;
    }


    /**
     * The model with included segmentationModel, in GUI mode the model from OrbitImageAnalysis.getInstance() will be taken.
     *
     * @param model
     */
    public void setModel(OrbitModel model) {
        this.model = model;
        if (model != null) {
            if (model.getSegmentationModel() == null)
                throw new IllegalArgumentException("model does not contain a segmentation model");
            this.segmentationModel = model.getSegmentationModel();
            this.secondarySegmentationModel = model.getSecondarySegmentationModel();
            this.minSegmentationSize = model.getSegmentationModel().getFeatureDescription().getMinSegmentationSize();

            rf.setClassShapes(model.getSegmentationModel().getClassShapes());
            OrbitUtils.setMultiChannelFeatures(rf.bimg.getImage(),model.getSegmentationModel().getFeatureDescription());
            rf.initializeClassColors();
        } else {
            this.segmentationModel = null;
        }
    }

    public OrbitModel getModel() {
        return model;
    }

    public void setExclusionMap(ExclusionMapGen exclusionMapGen) {
        this.exclusionMapGen = exclusionMapGen;
    }

    public List<Point> getTiles() {
        return tiles;
    }

    public void setTiles(List<Point> tiles) {
        this.tiles = tiles;
    }

    public SegmentationResult getSegmentationResult() {
        return segmentationResult;
    }


}
