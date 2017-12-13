/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.actelion.research.orbit.imageAnalysis.tasks;

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.features.ObjectFeatureBuilderTiled;
import com.actelion.research.orbit.imageAnalysis.imaging.IJUtils;
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.segmenter.SegmentedImage;
import com.actelion.research.orbit.imageAnalysis.segmenter.SegmenterFacade;
import com.actelion.research.orbit.imageAnalysis.utils.*;
import com.actelion.research.orbit.utils.StdStats;
import com.freedomotic.util.SerialClone.SerialClone;
import ij.ImagePlus;
import ij.plugin.filter.EDM;
import ij.process.AutoThresholder;
import ij.process.BinaryProcessor;
import ij.process.ByteProcessor;
import imageJ.RankFiltersOrbit;
import imageJ.graphcut.Graph_Cut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.media.jai.PlanarImage;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.util.*;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Object segmentation based on a foreground/background image.
 */
public class ObjectSegmentationWorker extends OrbitWorker {
    private int minSegmentationSize = 10;
    private final static Logger logger = LoggerFactory.getLogger(ObjectSegmentationWorker.class);
    private RecognitionFrame rf = null;
    private int objectCount = 0;
    private List<Point> tiles = null;
    private OrbitModel model = null; // only used for feature(names) builder. Internally the segmentationModel (and secondary) are used for convenience.
    private OrbitModel segmentationModel = null; // the (primary) segmentation model, in GUI mode the model from OrbitImageAnalysis.getInstance() will be taken
    private OrbitModel secondarySegmentationModel = null;  // used for segmentation inside a segmentation
    private ExclusionMapGen exclusionMap = null;
    private boolean doWatershed = true;
    private List<ClassShape> oldClassShapes = null;
    private int numErode = 0;
    private int numDilate = 0;
    private int numRemoveOutliers = 0;
    private double graphCutSmoothness = 0d;
    private boolean dilateBeforeErode = true;
    private boolean doErode = false;
    private boolean doDilate = false;
    private boolean doRepaint = true;
    private boolean dontClassify = false;
    private double plasmaScale = 1d;
    private SegmentationResult segmentationResult = new SegmentationResult();
    private boolean mergeTileSegments = false;
    private boolean filterTileEdgeShapes = false;
    private int mergeMinDistance = 4; // min distance to merge large objects across tiles
    private int heatmapFeature = -1; // >-1 means generate heatmap for feature nr features-heatmapFeature
    private int numThreads = Runtime.getRuntime().availableProcessors();
    private RecognitionFrame originalFrame = null;
    private boolean cytoplasmaSegmentation = false;
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
    public ObjectSegmentationWorker(RawDataFile rdf, RecognitionFrame rf, List<SwingWorker<Void, Void>> dependencyList, List<ClassShape> classShapeToSet, List<Point> tiles) {
        this.rf = rf;
        this.rdf = rdf;
        if (classShapeToSet != null) {
            if (rf.getClassShapes() != null)
                oldClassShapes = SerialClone.clone(rf.getClassShapes()); // remember original classShales workaround (dirty fix...). Must be cloned because rf.setClassShapes will clear() and addAll() (next line).
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

    /**
     * Features are always computed for 3 channels (r,g,b), but in future for grayscale images it might be computer for only 1 channel.
     *
     * @return
     */
    public static int getSampleNumberForFeatures() {
        return 3;
    }

    private TiledImageWriter makeClassImage(RecognitionFrame rf, Shape roi) {
        TiledImageWriter ci = rf.getClassImage();
        if (roi != null) {
            BufferedImage bi = rf.getClassImage().getImage().getAsBufferedImage(roi.getBounds(), rf.getClassImage().getImage().getColorModel());
            ci = new TiledImageWriter(bi);
        }
        return ci;
    }

    private RecognitionFrame makeROIImage(RecognitionFrame rf, Shape roi) {
        TiledImagePainter ci = rf.bimg;
        if (roi != null) {
            Rectangle roiBounds = roi.getBounds();
            if (logger.isTraceEnabled() && (roiBounds.getWidth() == 0 || roiBounds.getHeight() == 0)) {
                logger.trace("Warning: ROI bounds with width=0 or height=0. Skipping tile.");
                //return null; // instead an error message will be thrown in getAsBufferedImage
            }
            BufferedImage bi = rf.bimg.getModifiedImage(this.segmentationModel.getFeatureDescription()).getAsBufferedImage(roiBounds, rf.bimg.getImage().getColorModel());    // here it is a 'rendered' image, e.g. only with active fluo channels
//            BufferedImage bi = rf.bimg.getImage().getAsBufferedImage(roiBounds, rf.bimg.getImage().getColorModel());    // here it is a 'rendered' image, e.g. only with active fluo channels

            ci = new TiledImagePainter(PlanarImage.wrapRenderedImage(bi), "roi");
            ci.getImage().setUseCache(false);
        }
        RecognitionFrame rf2 = new RecognitionFrame(ci);
        rf2.setClassShapes(rf.getClassShapes());
        rf2.initializeClassColors();
        ci.getImage().setUseCache(false);
        return rf2;
    }


    private long getSize(Shape roi) {
        long size = (long) rf.bimg.getWidth() * rf.bimg.getHeight();
        if (roi != null) {
            if (roi instanceof IScaleableShape)
                roi = ((IScaleableShape) roi).getScaledInstance(100d, new Point(0, 0));
            if (roi.getBounds() != null)
                size = (long) roi.getBounds().getWidth() * (long) roi.getBounds().getHeight();
        }
        return size;
    }

    @Override
    protected void doWork() throws OrbitImageServletException {
        try {

            if (withGUI && !ScaleoutMode.SCALEOUTMODE.get() && numThreads > 1)
                numThreads--; // in GUI mode reserve one thread for GUI

            // generate exclusion map
            if (exclusionMap != null /*&& (exclusionMap.useForSegmentation())*/) {
                if (!exclusionMap.isGenerated()) {
                    exclusionMap.generateMap();
                }
            }

            // required for object segmentation with manual file load!
            if (!dontClassify && segmentationModel == null && (!ScaleoutMode.SCALEOUTMODE.get())) {
                OrbitModel modelLoad = OrbitImageAnalysis.getInstance().getModel();
                setModel(modelLoad); // will overwrite minSegmentationSize
            }
            IScaleableShape oldROI = rf.getROI();
            IScaleableShape fullROITest = rf.getROI();
            if (fullROITest != null && (fullROITest instanceof IScaleableShape)) {
                fullROITest = (IScaleableShape) fullROITest.getScaledInstance(100d, new Point(0, 0));
            }
            final IScaleableShape fullROI = fullROITest;

            if (tiles == null && getSize(rf.getROI()) > 1500 * 1500L) {
                // tile list
                Point[] tileIndices = rf.bimg.getImage().getTileIndices(fullROI == null ? null : fullROI.getBounds());
                if (tileIndices!=null && tileIndices.length>0) {
                    tiles = Arrays.asList(tileIndices);
                }
            }

            if (tiles == null || tiles.size() == 0) {
                tiles = new ArrayList<Point>(1);
                tiles.add(new Point(-1, -1));
            }


            if (logger.isTraceEnabled()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Object segmentation for tiles: ");
                for (Point t : tiles) {
                    sb.append(t.x + "," + t.y + "; ");
                }
                logger.trace(sb.toString());
            }
            final AtomicInteger allObjectCount = new AtomicInteger(0);
            final AtomicInteger allObjectCountSecondary = new AtomicInteger(0);
            final AtomicInteger currentTileNum = new AtomicInteger(0);

            final ExecutorService executor = Executors.newFixedThreadPool(numThreads);
            List<Callable<SegmentationResult>> tileTaskList = new ArrayList<Callable<SegmentationResult>>();

            // if watershed is disable switch to 'large object detection' (e.g. vessel detection) mode
            if (segmentationModel != null && segmentationModel.getFeatureDescription().isDeactivateWatershed()) {
                setDoWatershed(false);
                setMergeTileSegments(true);
                setDoDilate(true);
                setNumDilate(1);
                setDoErode(false);
                setDilateBeforeErode(true);
            } else {
                // normal configuration > featureConfig version 2
                if (segmentationModel != null) {
                    setDoWatershed(!segmentationModel.getFeatureDescription().isDisableWatershed());
                    setMergeTileSegments(segmentationModel.getFeatureDescription().isCombineObjectsCrossTiles());
                    setNumDilate(segmentationModel.getFeatureDescription().getNumDilate());
                    if (numDilate == 0) numDilate = 1; // always dilate at least once  // TODO
                    setNumErode(segmentationModel.getFeatureDescription().getNumErode());
                    setDilateBeforeErode(segmentationModel.getFeatureDescription().isDilateBeforeErode());
                    setNumRemoveOutliers(segmentationModel.getFeatureDescription().getRemoveOutliers());
                    setDoDilate(numDilate > 0);
                    setDoErode(numErode > 0);
                    setGraphCutSmoothness(segmentationModel.getFeatureDescription().getGraphCut());
                }
            }
            if (segmentationModel != null) {
                setFilterTileEdgeShapes(segmentationModel.getFeatureDescription().isFilterTileEdgeShapes());
            }
            final int numSamples = rf.bimg.getImage().getNumBands();

            for (final Point currentTile : tiles) {
                tileTaskList.add(new Callable<SegmentationResult>() {
                    public SegmentationResult call() throws Exception {
                        if (isCancelled()) return null;

                        if (currentTile.x != -1 && fullROI != null) {
                            Rectangle tileRect = rf.bimg.getImage().getTileRect(currentTile.x, currentTile.y);
                            //if (!fullROI.intersects(tileRect)/*|| fullROI.getBounds()==null*/|| fullROI.getBounds().getWidth()==0||fullROI.getBounds().getHeight()==0) {           // || fullROI.getBounds()==null added 18.06.2015
                            if (!fullROI.intersects(tileRect) || (fullROI.getBounds() != null && (fullROI.getBounds().getWidth() == 0 || fullROI.getBounds().getHeight() == 0))) {         // upd 14.12.2015: roi.getBounds() can be null, e.g. ShapeAnnotations with only exclusions
                                currentTileNum.incrementAndGet();
                                setProgress((int) (((double) currentTileNum.get() / (double) tiles.size()) * 100d));
                                return null;
                            }
                        }

                        Shape roi = null;

                        List<Shape> segments = new ArrayList<Shape>();
                        logger.trace("tile: " + currentTile.x + "," + currentTile.y);
                        currentTileNum.incrementAndGet();
                        if (currentTile.x != -1) { // -1 means dummy tile
                            // override ROI with current tile
                            roi = rf.bimg.getImage().getTileRect(currentTile.x, currentTile.y);
                            logger.trace("using tileROI: " + roi);
                            RectangleExt re = new RectangleExt(roi.getBounds().x, roi.getBounds().y, roi.getBounds().width, roi.getBounds().height);
                            re.setScale(100d);

                            // exclusionMap check
                            //really only useForSegmentation? -> Upd 30.08.2012 Manuel: no, we do the exclusion check all the time
                            if (exclusionMap != null /*&& !exclusionMap.useForSegmentation()*/) {
                                Rectangle tr = rf.bimg.getImage().getTileRect(currentTile.x, currentTile.y);
                                long cnt = 0;
                                long hit = 0;
                                for (int x = tr.x; x < tr.getMaxX(); x += 2)
                                    for (int y = tr.y; y < tr.getMaxY(); y += 2) {
                                        cnt++;
                                        //if (!exclusionMap.isExcluded(x, y)) {
                                        if (OrbitUtils.isInROI(x, y, fullROI, exclusionMap)) {
                                            hit++;
                                        }
                                    }
                                double pExl = (double) hit / (double) cnt;

                                logger.trace("hits: " + hit);
                                if (pExl < 0.05d) {  // if less that 5% foreground in the tile, excluse it completely for better performance. However, small objects might be discarded!
                                    logger.trace("object segmentation tile excluded " + pExl);
                                    return null; // too much excluded, so skip tile
                                } else
                                    logger.trace("ns included " + pExl);
                            }
                        } else {
                            roi = fullROI;
                            logger.trace("using fullROI");
                        }
                        if (getSize(roi) > 5000 * 5000L) {
                            logger.error("object segmentation can only be applied for smaller regions (max 5000x5000). Please try to select a smaller ROI and apply this method again.");
                            return null;
                        }

                        if (roi != null && (roi.getBounds().getWidth() == 0 || roi.getBounds().getHeight() == 0)) {
                            logger.warn("roi size is 0, this will cause an error");
                            // should we return null or new SegmentationResult here??? (so far not, because it should never happen...)
                        }

                        BufferedImage sourceImage = null;
                        TiledImageWriter classImage = null;
                        if (!dontClassify && segmentationModel != null) {
                            RecognitionFrame rf2 = makeROIImage(rf, roi);
                            sourceImage = rf2.bimg.getImage().getAsBufferedImage();
                            ClassificationWorker rw = new ClassificationWorker(rdf, rf2, segmentationModel, true, null, null);
                            rw.setNumClassificationThreads(1); // runs already in a multithreaded container
                            rw.doWork();
                            classImage = rf2.getClassImage();
                            if (logger.isTraceEnabled())
                                logger.trace("created classImage for current tile (roi=" + roi + "); classImage=" + classImage.getImage());
                        } else {
                            classImage = makeClassImage(rf, roi);
                            if (logger.isTraceEnabled())
                                logger.trace("reusing classImage for current tile; classImage=" + classImage.getImage());
                        }
                        if (sourceImage==null && segmentationModel!=null && segmentationModel.getFeatureDescription().isMumfordShahSegmentation()) {
                            RecognitionFrame rf2 = makeROIImage(rf, roi);
                            sourceImage = rf2.bimg.getImage().getAsBufferedImage();
                        }

                        logger.trace("start object segmentation");
                        TiledImageWriter originalClassImage = classImage; // needed later for objectFeatures (intensities) because classImage will be reduced to a two-class image by the watershed process


                        // apply ImagePlus modifications, if any
                        classImage = applyImagePlusModifications(classImage);
                        // for cytoplasmaSegmentation only two classes are allowed. The applyImagePlusMod performs a voronoi diagram, so the original class image is modified, thus originalClassImage must be set again (but only with two classes (foreground/background)!
                        if (isCytoplasmaSegmentation())
                            originalClassImage = classImage;

                        logger.trace("start segmentation");
                        int oldObjectCount = segments.size();
                        int roffsX = 0;
                        int roffsY = 0;
                        if (roi != null && roi.getBounds() != null) {
                            roffsX = roi.getBounds().x;
                            roffsY = roi.getBounds().y;
                            if (roffsX < 0) roffsX = 0;    // handle out-of-image ROIs
                            if (roffsY < 0) roffsY = 0;    // handle out-of-image ROIs
                        }

                        boolean mumfordShahSegmentation = segmentationModel!=null && segmentationModel.getFeatureDescription().isMumfordShahSegmentation();

                        // here the actual segmentation per tile happens
                        List<Shape> tileSegmentations;
                        if (mumfordShahSegmentation) tileSegmentations = getObjectSegmentationsTileMumfordShah(classImage, originalClassImage, sourceImage, fullROI, roffsX, roffsY);
                        else tileSegmentations = getObjectSegmentationsTile(classImage, originalClassImage, fullROI, roffsX, roffsY);
                        
                        segments.addAll(tileSegmentations);
                        logger.trace("end segmentation: #objects: " + segments.size());
                        objectCount = segments.size() - oldObjectCount; // minus the old
                        // objectCount
                        allObjectCount.addAndGet(objectCount);

                        logger.debug("counted " + objectCount + " objects in tile " + currentTile.x + "," + currentTile.y + " / overall: " + allObjectCount);

                        setProgress((int) (((double) currentTileNum.get() / (double) tiles.size()) * 100d));
                        //if ((!ScaleoutMode.SCALEOUTMODE.get()) && doRepaint) rf.repaint();
                        logger.trace("end object segmentation for current tile");


                        // object features
                        List<double[]> features = new ArrayList<double[]>();
                        if (segmentationModel != null && segmentationModel.getFeatureDescription().getFeatureClasses() != null && segmentationModel.getFeatureDescription().getFeatureClasses().length > 0) {
                            ObjectFeatureBuilderTiled cfb = new ObjectFeatureBuilderTiled(segmentationModel);
                            cfb.setClasses(segmentationModel.getFeatureDescription().getFeatureClasses());
                            features = cfb.buildFeatures(segments, Double.NaN, rf, originalClassImage, getSampleNumberForFeatures(), roffsX, roffsY);
                            if (logger.isTraceEnabled() && segmentationModel != null && segmentationModel.getFeatureDescription() != null) {
                                logger.trace("used feature classes: " + Arrays.toString(segmentationModel.getFeatureDescription().getFeatureClasses()));
                            }
                        }

                        int secondaryObjectCount = 0;
                        List<Shape> secondaryShapes = null;

                        // second level seg start
                        SecondLevelSegmentation secondLevelSegmentation = new SecondLevelSegmentation(segments, features, secondaryObjectCount, secondaryShapes, allObjectCountSecondary, numSamples).invoke();
                        secondaryObjectCount = secondLevelSegmentation.getSecondaryObjectCount();
                        secondaryShapes = secondLevelSegmentation.getSecondaryShapes();
                        // second level seg end


                        SegmentationResult segmentationResult = new SegmentationResult(segments.size(), secondaryObjectCount, segments, features);
                        segmentationResult.setSecondaryShapeList(secondaryShapes);
                        return segmentationResult;
                    }
                });
            } // tiles


            List<Future<SegmentationResult>> tileSegments = executor.invokeAll(tileTaskList);
            String[] featureNames = new ObjectFeatureBuilderTiled(segmentationModel).getFeatureNames(numSamples);
            SegmentationResult allSegmentsAndFeatures = new SegmentationResult(0, 0, Arrays.asList(featureNames), new ArrayList<Shape>(), new ArrayList<double[]>());
            int allSecondaryCount = 0;
            for (Future<SegmentationResult> flist : tileSegments) {
                if (flist != null && !flist.isCancelled() && flist.isDone()) {
                    SegmentationResult segmentationResult = flist.get();
                    if (segmentationResult != null) {
                        allSecondaryCount += segmentationResult.getSecondaryObjectCount();
                        if (segmentationResult.getShapeList() != null)
                            allSegmentsAndFeatures.getShapeList().addAll(segmentationResult.getShapeList());
                        if (segmentationResult.getFeatureList() != null)
                            allSegmentsAndFeatures.getFeatureList().addAll(segmentationResult.getFeatureList());

                        if (segmentationResult.getSecondaryShapeList() != null) {
                            if (allSegmentsAndFeatures.getSecondaryShapeList() == null)
                                allSegmentsAndFeatures.setSecondaryShapeList(new ArrayList<Shape>());
                            allSegmentsAndFeatures.getSecondaryShapeList().addAll(segmentationResult.getSecondaryShapeList());
                        }
                    }
                }
            }
            allSegmentsAndFeatures.setSecondaryObjectCount(allSecondaryCount);

            if (filterTileEdgeShapes) {
                allSegmentsAndFeatures = filterEdgeSegments(allSegmentsAndFeatures);
            }

            // now join tile-overlapping segments (if activated)
            if (mergeTileSegments) {
                allSegmentsAndFeatures = joinTileSegments(allSegmentsAndFeatures,false);
            }

            if (allSegmentsAndFeatures.getShapeList() != null) {
                allSegmentsAndFeatures.setObjectCount(allSegmentsAndFeatures.getShapeList().size());
                allObjectCount.set(allSegmentsAndFeatures.getShapeList().size());
            }

            // set dummy classImage, otherwise no objectSegmentations would be rendered
            if (rf.getClassImage() == null)
                rf.setClassImage(new TiledImageWriter(1, 1, 1, 1));
            rf.setObjectSegmentationList(allSegmentsAndFeatures.getShapeList());
            rf.setSecondaryObjectSegmentationList(allSegmentsAndFeatures.getSecondaryShapeList());

            // center/centroid lists start     - can be activated to see the centers
    /*
    List<Point> centerList = new ArrayList<Point>(allSegmentsAndFeatures.getFeatureList().size());
	List<Point> centroidList = new ArrayList<Point>(allSegmentsAndFeatures.getFeatureList().size());
	for (double[] features: allSegmentsAndFeatures.getFeatureList()) {
		Point center = new Point((int)features[features.length-5],(int)features[features.length-4]);
		Point centroid = new Point((int)features[features.length-3],(int)features[features.length-2]);
		centerList.add(center);
		centroidList.add(centroid);
		System.out.println("features: "+Arrays.toString(features));
		System.out.println("center: "+center);
		System.out.println("centroid: "+centroid);
	}
	rf.setCenterList(centerList);
	rf.setCentroidList(centroidList);
	// center/centroid lists end
    */

            setSegmentationResult(allSegmentsAndFeatures);
            executor.shutdownNow();

            rf.setROI(oldROI);
            if (oldClassShapes != null) {
                rf.setClassShapes(oldClassShapes);
                logger.debug("ClassShape Workaround: Old classShapes set.");
            }
            logger.info("counted " + allObjectCount + " objects");
            logger.info("secondary object count: " + allObjectCountSecondary);

            // if an originalFrame is set, write back the scaled segmentation shapes
            // (this is for segmenting on a lower resolution image, not the original full res image)
            if (originalFrame != null && originalFrame != rf) {
                if (rf.getObjectSegmentationList() != null) {
                    double originalCurrentFrameRatioInverse = this.originalFrame.bimg.getImage().getWidth() / (double) rf.bimg.getImage().getWidth();
                    if (originalFrame.getObjectSegmentationList() == null)
                        originalFrame.setObjectSegmentationList(new ArrayList<Shape>(rf.getObjectSegmentationList().size()));
                    if (originalFrame.getSecondaryObjectSegmentationList() == null)
                        originalFrame.setSecondaryObjectSegmentationList(new ArrayList<Shape>(rf.getSecondaryObjectSegmentationList() != null ? rf.getSecondaryObjectSegmentationList().size() : 0));
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


            setProgress(100);

            if (allSegmentsAndFeatures.getFeatureList().size() > 0) {

                // set heatmap features?
                if (heatmapFeature > -1) {
                    List<Color> heatmap = buildHeatmapFeatures(allSegmentsAndFeatures.getFeatureList(), heatmapFeature);
                    rf.setObjectSegmentationColors(heatmap);
                } else rf.setObjectSegmentationColors(null);

                ObjectFeatureBuilderTiled cfb = new ObjectFeatureBuilderTiled(model);
                String featureStr = cfb.getResultString(allSegmentsAndFeatures.getFeatureList(), numSamples, false, "\t");
                taskResult = new TaskResult("Object Features (" + allObjectCount + " objects)", featureStr);
            } else {
                String secondary = "";
                if (secondarySegmentationModel != null) {
                    secondary = "\nSecondary Object Count: " + allObjectCountSecondary + "\n";
                }
                taskResult = new TaskResult("Object Count", "Number of objects: " + allObjectCount + secondary + "\n\nHint: Set feature classes (F3->'classes for retrieving features') to retrieve features (e.g. intensities) per object.");
            }


        } catch (Exception e) {
            logger.error("A problem in the segmentation process occured", e);
            e.printStackTrace();
        }
        rf.setObjectClassificationList(null);
        if (rf.isVisible()) {
            rf.repaint();
        }
    }


    private TiledImageWriter applyImagePlusModifications(TiledImageWriter classImage) {
        //if (true||doWatershed||doDilate||doErode||numRemoveOutliers>0||graphCutSmoothness>0d) {
        if (true) {      // always used to make the image really binary. Otherwise a third class might be used as foreground instead of background.
            // at least one imageJ filter should be applied
            Color fg = rf.getClassShapes().get(1).getColor();
            Color bg = rf.getClassShapes().get(0).getColor();
            ImagePlus ip = IJUtils.toBinaryImagePlus(classImage.getImage(), fg);
            ip.getProcessor().setAutoThreshold(AutoThresholder.Method.Default, true);
            ip.setProcessor(ip.getProcessor().convertToByte(false));
            BinaryProcessor bp = new BinaryProcessor((ByteProcessor) ip.getProcessor());
            bp.setAutoThreshold(AutoThresholder.Method.Default, true);
            bp.autoThreshold();
            bp.setBinaryThreshold();
            ip.setProcessor(bp);
            ip.getProcessor().autoThreshold();

            if ((segmentationModel == null) || (!segmentationModel.getFeatureDescription().isDeactivateWatershed())) {  // not large object detection (for this, a special dilate and erode will be used (see below))

                if (numRemoveOutliers > 0) {
                    ip.setProcessor(ip.getProcessor().convertToFloat());
                    RankFiltersOrbit outliers = new RankFiltersOrbit();
                    ip = outliers.doRemoveOutliers(ip, numRemoveOutliers);
                    BinaryProcessor bp1 = new BinaryProcessor((ByteProcessor) (ip.getProcessor().convertToByte(false)));
                    bp1.setAutoThreshold(AutoThresholder.Method.Default, true);
                    bp1.autoThreshold();
                    ip.setProcessor(bp1);
                }

                if (dilateBeforeErode) {
                    // Attention: ImageJ interprets dilate(/erode) as dilating(/eroding) the dark. As we have white foreground here dilate/erode are switched.
                    if (doDilate) {
                        for (int i = 0; i < numDilate; i++)
                            ip.getProcessor().erode();
                    }
                    if (doErode) {
                        for (int i = 0; i < numErode; i++)
                            ip.getProcessor().dilate();
                    }
                } else {
                    if (doErode) {
                        for (int i = 0; i < numErode; i++)
                            ip.getProcessor().dilate();
                    }
                    if (doDilate) {
                        for (int i = 0; i < numDilate; i++)
                            ip.getProcessor().erode();
                    }
                }

                if (graphCutSmoothness > 0d) {
                    ip.getProcessor().invert();
                    Graph_Cut gc = new Graph_Cut();
                    ip = gc.processSingleChannelImage(ip, null, Graph_Cut.DATA_INIT, (float) graphCutSmoothness, Graph_Cut.EDGE_INIT);
                }

                if (doWatershed) {
                    logger.trace("start watershed");
                    EDM edm = new EDM();
                    edm.toWatershed(ip.getProcessor()); // watershed needs black (0) as background and white as foreground
                    logger.trace("end watershed");


                }

                if (isCytoplasmaSegmentation()) {
                    logger.trace("start voronoi");
                    //ImageProcessor bpi = ip.getProcessor();
                    //bpi.setBinaryThreshold();
                    //bpi.threshold(0);
                    BinaryProcessor bp2 = new BinaryProcessor((ByteProcessor) ip.getProcessor());
                    bp2.invert();

                    EDM edm = new EDM();
                    edm.setup("voronoi", ip);
                    edm.run(bp2);

                    bp2.threshold(0);
                    bp2.invert();

                    for (int i = 0; i < 1; i++) {
                        bp2.dilate();
                    }
                    ip.setProcessor(bp2.convertToRGB());
                    logger.trace("end voronoi");

                }

            }

            PlanarImage cImg = IJUtils.toPlanarImage(ip, classImage.getImage(), fg, bg);
            TiledImageWriter tiw = new TiledImageWriter(cImg);
            classImage = tiw;
            cImg = null;
        }

        return classImage;
    }


    /**
     * To be called for each tile. ClassImage is the classImage of one classified tile.
     * OffsX and offsY is the offset of the current tile.
     */
    public List<Shape> getObjectSegmentationsTile(final TiledImageWriter classImage, final TiledImageWriter originalClassImage, Shape fullROI, int offsX, int offsY) {
        logger.trace("getObjectSegmentations (minSegmentation=" + minSegmentationSize + ")");
        if (classImage == null) return new ArrayList<Shape>(0);
        short[][] smap = new short[classImage.getWidth()][classImage.getHeight()];

        // init
        final int b = 1; // border cutoff -otherwise "border-objects" will be detected
        for (int x = b; x < classImage.getImage().getWidth() - b; x++) {
            for (int y = b; y < classImage.getImage().getHeight() - b; y++) {
                byte c = rf.getClass(x, y, classImage);
                if (c > 0 && (exclusionMap == null || !exclusionMap.isExcluded(x + offsX, y + offsY))) {  // not background, not assigned
                    smap[x][y] = 1; // 1
                } else {
                    smap[x][y] = 0; // 0
                }
            } //y
        } // x


        // erode and dilate
        final int erodeNum = doErode ? numErode : 0;
        final int dilateNum = doDilate ? numDilate : 0;
        if (segmentationModel != null && segmentationModel.getFeatureDescription().isDeactivateWatershed()) {
            if (dilateBeforeErode) {
                if (doDilate) {
                    for (int i = 0; i < dilateNum; i++) smap = dilate(smap);
                }
                if (doErode) {
                    for (int i = 0; i < erodeNum; i++) smap = erode(smap);
                }
            } else {
                if (doErode) {
                    for (int i = 0; i < erodeNum; i++) smap = erode(smap);
                }
                if (doDilate) {
                    for (int i = 0; i < dilateNum; i++) smap = dilate(smap);
                }
            }
        } else {
            if (mergeTileSegments) {    // merging only works after at least one dilate step
                smap = dilate(smap);
            } else {
                if (isCytoplasmaSegmentation()) {
                    smap = dilate(smap);
                }
            }
        }

        // debug
        /*
        int red = Color.RED.getRGB();
        int green = Color.GREEN.getRGB();
        BufferedImage bi = new BufferedImage(smap[0].length,smap.length,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        for (int x=0; x<smap[0].length; x++)
            for (int y=0; y<smap.length; y++) {
                if (smap[x][y]>0)
                     bi.setRGB(x,y,red);
                else bi.setRGB(x,y,green);
            }
        try {
            ImageIO.write(bi,"png",new File("d:/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        // end debug

        // find objects
        // PointSorter pointSorter = new PointSorter();
        List<List<Point>> pListList = new ArrayList<List<Point>>();
        for (int x = 0; x < classImage.getWidth(); x++) {
            for (int y = 0; y < classImage.getHeight(); y++) {
                if ((smap[x][y] > 0) && (smap[x][y] != Short.MAX_VALUE) && (exclusionMap == null || !exclusionMap.isExcluded(x + offsX, y + offsY))) {
                    if (adjoinsClass(x, y, smap)) {  // is object border
                        List<Point> pList = new ArrayList<Point>();
                        addRightHandPoints(x, y, smap, pList, offsX, offsY);
                        //  pList = pointSorter.sortPoints(pList);
                        pListList.add(pList);
                        // the next iteration will be the next object
                    }
                }
            }
        }

        // transform to polygons; discards polygons with length>maxSegmentationLength or openDistance > maxOpenDistance (FeatureDescription)
        boolean skipPoly = false;
        List<Shape> shapeList = new ArrayList<Shape>(pListList.size());
        for (List<Point> pList : pListList) {
            if (pList == null || pList.size() == 0) continue;
            Shape s = new PolygonExt();
            int roiOffsX = offsX;
            int roiOffsY = offsY;
            skipPoly = false;
            if (segmentationModel != null && pList.size() > segmentationModel.getFeatureDescription().getMaxSegmentationLength())
                continue;
            if (segmentationModel != null && pList.get(0).distance(pList.get(pList.size() - 1)) > segmentationModel.getFeatureDescription().getMaxOpenDistance())
                continue;
            for (Point p : pList) {
                if ((exclusionMap == null || !exclusionMap.isExcluded(p.x + roiOffsX, p.y + roiOffsY))) {
                    ((Polygon) s).addPoint(p.x + roiOffsX, p.y + roiOffsY); // add points and adjust roi offset
                } else {
                    skipPoly = true;
                    break;
                }
            }

            if (skipPoly) continue;

            // here polygons might be filtered

            int adjust = Math.min(0, dilateNum - erodeNum);
            if ((s.getBounds().width - (adjust * 2) >= minSegmentationSize) && (s.getBounds().height - (adjust * 2) >= minSegmentationSize)) // at least one site > MIN_SEGMENT_SIZE
            {
                if ((fullROI == null) || fullROI.contains(s.getBounds().getCenterX(), s.getBounds().getCenterY())) {
                    if (!shapeInNegativeChannel(s) && !inverseShape(s, offsX, offsY, originalClassImage)) {
                        shapeList.add(s);
                    }
                }
            }
        }

        smap = null;


        //shapeList = filterShapes(shapeList);      // optional: filter shapes

        // scale
        if (plasmaScale != 1) {
            logger.trace("scaling object shape by factor " + plasmaScale);
            List<Shape> scaledShapes = new ArrayList<Shape>(shapeList.size());
            PolygonMetrics pm = new PolygonMetrics(null);
            for (Shape shape : shapeList) {
                PolygonExt pe = (PolygonExt) shape;
                pm.setPolygon(pe);
                pe = pe.scale(100d * plasmaScale, pm.getCenter());
                scaledShapes.add(pe);
            }
            shapeList = scaledShapes;
        }

        return shapeList;
    }


    /**
     * Mumford-Shah segmentation.
     * To be called for each tile. ClassImage is the classImage of one classified tile.
     * OffsX and offsY is the offset of the current tile.
     */
    public List<Shape> getObjectSegmentationsTileMumfordShah(final TiledImageWriter classImage, final TiledImageWriter originalClassImage, final BufferedImage sourceImage,  Shape fullROI, int offsX, int offsY) {
        logger.trace("mumford-shah segmentation");
        if (classImage == null) return new ArrayList<Shape>(0);
        BufferedImage mask = new BufferedImage(classImage.getImage().getWidth(), classImage.getImage().getHeight(), BufferedImage.TYPE_BYTE_BINARY);

        // init
        final int b = 1; // border cutoff -otherwise "border-objects" will be detected
        for (int x = b; x < classImage.getImage().getWidth() - b; x++) {
            for (int y = b; y < classImage.getImage().getHeight() - b; y++) {
                byte c = rf.getClass(x, y, classImage);
                if (c > 0 && (exclusionMap == null || !exclusionMap.isExcluded(x + offsX, y + offsY))) {  // not background, not assigned
                    mask.setRGB(x, y, Color.WHITE.getRGB());
                } else {
                    mask.setRGB(x, y, Color.BLACK.getRGB());
                }
            } //y
        } // x


//        BufferedImage sourceOri = originalClassImage.getImage().getAsBufferedImage();
//        BufferedImage source = new BufferedImage(sourceOri.getWidth(),sourceOri.getHeight(),BufferedImage.TYPE_INT_RGB);
//        source.getGraphics().drawImage(sourceOri,0,0,null);
//        source.getGraphics().dispose();
        logger.trace("mumford-shah pre-processing finished");

        int alpha = 5;
        int cellSize = 18;
        if (segmentationModel!=null) {
            alpha = segmentationModel.getFeatureDescription().getMumfordShahAlpha();
            cellSize = segmentationModel.getFeatureDescription().getMumfordShahCellSize();
        }

        logger.trace("mumford-shah alpha: "+alpha+" cellSize: "+cellSize);

        List<Polygon> polyList = new ArrayList<>();
        int maxMFSTileSize = 512;
        if (sourceImage.getWidth()<maxMFSTileSize && sourceImage.getHeight()<maxMFSTileSize) {
            // small tile - segment on full tile
            SegmentedImage segmentedImage = SegmenterFacade.detectCells(sourceImage, mask, alpha, cellSize);
            if (segmentedImage!=null && segmentedImage.getPolygons()!=null && segmentedImage.getPolygons().size()>0) {
                polyList.addAll(segmentedImage.getPolygons());
            }
        } else {
            // big tile - segment on tileparts
            PlanarImage piSource = PlanarImage.wrapRenderedImage(sourceImage);
            PlanarImage piMask = PlanarImage.wrapRenderedImage(mask);
            ImageTiler sourceTiler = new ImageTiler(piSource,maxMFSTileSize,maxMFSTileSize);
            Iterator<BufferedImage> imageTiles = sourceTiler.iterator();
            Iterator<BufferedImage> maskTiles = new ImageTiler(piMask,maxMFSTileSize,maxMFSTileSize).iterator();
            Point[] tileIdx = sourceTiler.getTileIndices();
            int idx=0;
            while (imageTiles.hasNext()) {
                SegmentedImage segmentedImage = SegmenterFacade.detectCells(imageTiles.next(), maskTiles.next(), alpha, cellSize);
                if (segmentedImage!=null && segmentedImage.getPolygons()!=null && segmentedImage.getPolygons().size()>0) {
                    List<Polygon> segmentedList = segmentedImage.getPolygons();
                    // remove tile border objects
                    segmentedList = filterEdgePolygons(segmentedList,maxMFSTileSize,maxMFSTileSize);
                    translatePolygons(segmentedList, sourceTiler.getTiledImage().tileXToX(tileIdx[idx].x), sourceTiler.getTiledImage().tileYToY(tileIdx[idx].y));
                    polyList.addAll(segmentedList);
                }
                idx++;
            }
           
        }

        if (polyList.size()==0) {
            logger.debug("no segmentations");
            return new ArrayList<>(0);
        } else {
            logger.debug("# segmented objects (mumford-shah): " + polyList.size());
        }

        List<List<Point>> pListList = new ArrayList<>(polyList.size());
        for (int i=0; i<polyList.size(); i++) {
            Polygon poly = polyList.get(i);
            List<Point> pList = new ArrayList<>(poly.npoints);
            for (int p=0; p<poly.npoints; p++) {
                pList.add(new Point(poly.xpoints[p],poly.ypoints[p]));
            }
            pListList.add(pList);
        }
        logger.trace("points conversion end");


        // transform to polygons; discards polygons with length>maxSegmentationLength or openDistance > maxOpenDistance (FeatureDescription)
        boolean skipPoly = false;
        List<Shape> shapeList = new ArrayList<Shape>(pListList.size());
        for (List<Point> pList : pListList) {
            if (pList == null || pList.size() == 0) continue;
            Shape s = new PolygonExt();
            int roiOffsX = offsX;
            int roiOffsY = offsY;
            skipPoly = false;
            if (segmentationModel != null && pList.size() > segmentationModel.getFeatureDescription().getMaxSegmentationLength())
                continue;
            if (segmentationModel != null && pList.get(0).distance(pList.get(pList.size() - 1)) > segmentationModel.getFeatureDescription().getMaxOpenDistance())
                continue;
            for (Point p : pList) {
                if ((exclusionMap == null || !exclusionMap.isExcluded(p.x + roiOffsX, p.y + roiOffsY))) {
                    ((Polygon) s).addPoint(p.x + roiOffsX, p.y + roiOffsY); // add points and adjust roi offset
                } else {
                    skipPoly = true;
                    break;
                }
            }

            if (skipPoly) continue;

            // here polygons might be filtered

            int dilateNum = 0;
            int erodeNum = 0;
            int adjust = Math.min(0, dilateNum - erodeNum);
            if ((s.getBounds().width - (adjust * 2) >= minSegmentationSize) && (s.getBounds().height - (adjust * 2) >= minSegmentationSize)) // at least one site > MIN_SEGMENT_SIZE
            {
                if ((fullROI == null) || fullROI.contains(s.getBounds().getCenterX(), s.getBounds().getCenterY())) {
                    if (!shapeInNegativeChannel(s) && !inverseShape(s, offsX, offsY, originalClassImage)) {
                        shapeList.add(s);
                    }
                }
            }
        }


        // scale
        if (plasmaScale != 1) {
            logger.trace("scaling object shape by factor " + plasmaScale);
            List<Shape> scaledShapes = new ArrayList<Shape>(shapeList.size());
            PolygonMetrics pm = new PolygonMetrics(null);
            for (Shape shape : shapeList) {
                PolygonExt pe = (PolygonExt) shape;
                pm.setPolygon(pe);
                pe = pe.scale(100d * plasmaScale, pm.getCenter());
                scaledShapes.add(pe);
            }
            shapeList = scaledShapes;
        }

        return shapeList;
    }

    private void translatePolygons(List<Polygon> polyList, int tx, int ty) {
         for  (Polygon p: polyList) {
             for (int i=0; i<p.npoints; i++) {
                 p.xpoints[i] += tx;
                 p.ypoints[i] += ty;
             }
         }
    }


    /**
     * Filters shapes by circularity>0.7, but could be more general in future.
     * Currently not used.
     */
    private List<Shape> filterShapes(List<Shape> shapeList) {
        List<Shape> filtered = new ArrayList<Shape>(shapeList.size());
        for (Shape s : shapeList) {
            if (s instanceof PolygonExt) {
                PolygonExt p = (PolygonExt) s;
                PolygonMetrics metrics = new PolygonMetrics(p);
                double area = metrics.getArea();
                double perimeter = metrics.getPerimeter();
                double circularity = metrics.getCircularity(area, perimeter);

                if (circularity > 0.70d) {

                    Point2D center = metrics.getCenter();
                    if (numNeighbours(center, shapeList, 45, 7) >= 7)
                        filtered.add(s);
                }

            }

        }

        return filtered;
    }


    private int numNeighbours(final Point2D center, final List<Shape> shapeList, final double dist, int stopAt) {
        int cnt = 0;
        for (Shape s : shapeList) {
            if (s instanceof PolygonExt) {
                PolygonExt p = (PolygonExt) s;
                PolygonMetrics metrics = new PolygonMetrics(p);
                Point2D center2 = metrics.getCenter();
                if (center.distance(center2) <= dist) cnt++;
                if (cnt > stopAt) break;
            }
        }
        return cnt - 1; // substract the polygon itself
    }


    /**
     * Removes tile-border shapes
     */
    public SegmentationResult filterEdgeSegments(SegmentationResult segResult) {
        if (segResult == null || segResult.getShapeList() == null || segResult.getShapeList().size() == 0)
            return segResult;

        if (rf == null) throw new IllegalStateException("recognition frame not set (is null)");
        List<Shape> filteredSegments = new ArrayList<Shape>(segResult.getShapeList().size());
        List<double[]> featureList = new ArrayList<>(segResult.getFeatureList().size());

        int dist = 2;
        int maxEdgeCnt = 6;

        for (int i=0; i<segResult.getShapeList().size(); i++) {
            Shape shape = segResult.getShapeList().get(i);
            if (shape instanceof PolygonExt) {
                PolygonExt poly = (PolygonExt) shape;
                int cntBorder = 0;
                int tileWidth = rf.bimg.getImage().getTileWidth();
                int tileHeight = rf.bimg.getImage().getTileHeight();
                for (int p=0; p<poly.npoints; p++) {
                   if ((poly.xpoints[p] % tileWidth <= dist) || (poly.ypoints[p] % tileHeight <= dist)) cntBorder++;
                   if ((poly.xpoints[p] % tileWidth >= tileWidth-dist) || (poly.ypoints[p] % tileHeight >= tileHeight - dist)) cntBorder++;
                  
                }
                if (cntBorder<maxEdgeCnt) {
                    filteredSegments.add(shape);
                    if (segResult.getFeatureList().size()>i)
                        featureList.add(segResult.getFeatureList().get(i));
                }
            }  else {
                filteredSegments.add(shape);
                if (segResult.getFeatureList().size()>i)
                    featureList.add(segResult.getFeatureList().get(i));
            }
        }

        segResult.setShapeList(filteredSegments);
        segResult.setFeatureList(featureList);
        segResult.setObjectCount(filteredSegments.size());
        return segResult;
    }


    /**
     * Removes tile-border polygons
     */
    public List<Polygon> filterEdgePolygons(List<Polygon> polygonList, int tileWidth, int tileHeight) {
        if (polygonList == null || polygonList.size() == 0)
            return polygonList;

        List<Polygon> filteredPologons = new ArrayList<>(polygonList.size());
        int dist = 2;
        int maxEdgeCnt = 2;

        for (int i=0; i<polygonList.size(); i++) {
            Polygon poly = polygonList.get(i);
            int cntBorder = 0;
            for (int p=0; p<poly.npoints; p++) {
                if ((poly.xpoints[p] % tileWidth <= dist) || (poly.ypoints[p] % tileHeight <= dist)) cntBorder++;
                if ((poly.xpoints[p] % tileWidth >= tileWidth-dist) || (poly.ypoints[p] % tileHeight >= tileHeight - dist)) cntBorder++;
            }
            if (cntBorder<maxEdgeCnt) {
                filteredPologons.add(poly);
            }
        }
        return filteredPologons;
    }

    /**
     * Merge shapes and sort points in shapes.
     * This version loops as long changes are made. Sorting of points in shapes at the end.
     *
     * @param segResult
     * @return
     */
    public SegmentationResult joinTileSegments(SegmentationResult segResult, boolean onlyCrossTiles) {
        // is called!!!
        if (segResult == null || segResult.getShapeList() == null || segResult.getShapeList().size() < 2)
            return segResult;
        boolean change = true;
        while (change) {
            int numSegments = segResult.getShapeList().size();
            logger.debug("merging, numSegments=" + numSegments);
            segResult = joinTileSegmentsStep(segResult,onlyCrossTiles);
            change = segResult.getShapeList().size() != numSegments;
        }
        logger.debug("merging, final segments before sorting=" + segResult.getShapeList().size());
        // segResult.setShapeList(sortPointsInPolys(segResult.getShapeList()));
        logger.debug("merging, final segments after sorting=" + segResult.getShapeList().size() + " / #features:" + ((segResult.getFeatureList() == null) ? "null" : segResult.getFeatureList().size()));
        return segResult;
    }

    public SegmentationResult joinTileSegmentsStep(SegmentationResult segResult, boolean onlyCrossTiles) {
        if (segResult == null || segResult.getShapeList() == null || segResult.getShapeList().size() < 2)
            return segResult;
        List<Shape> mergedSegments = new ArrayList<Shape>(segResult.getShapeList().size());
        List<double[]> mergedFeatures = null;
        if (segResult.getFeatureList() != null) mergedFeatures = new ArrayList<double[]>();
        HashSet<Integer> mergedIdx = new HashSet<Integer>();
        Point[] nearest = new Point[2];
        for (int i = 0; i < segResult.getShapeList().size() - 1; i++) {
            Shape s1 = segResult.getShapeList().get(i);
            if (s1 instanceof PolygonExt) {
                if (mergedIdx.contains(i)) continue;
                PolygonExt poly1 = (PolygonExt) s1;
                    for (int j = i + 1; j < segResult.getShapeList().size(); j++) {
                        if (mergedIdx.contains(j)) continue;
                        Shape s2 = segResult.getShapeList().get(j);
                        if (s2 instanceof PolygonExt) {
                            PolygonExt poly2 = (PolygonExt) s2;
                                if (!onlyCrossTiles || onDifferentTiles(poly1, poly2)) {
                                    Rectangle r1 = s1.getBounds();
                                    r1.grow(mergeMinDistance, mergeMinDistance);
                                    if (r1.intersects(s2.getBounds())) {
                                        nearest = nearestPoints(poly1, poly2, nearest);
                                        if (nearest[0].distance(nearest[1]) < mergeMinDistance) { // really merge
                                            PolygonExt merged = mergePolysSorted(poly1, poly2);
                                            mergedSegments.add(merged);
                                            if (mergedFeatures != null && segResult.getFeatureList() != null && segResult.getFeatureList().size() > i && segResult.getFeatureList().size() > j) {
                                                mergedFeatures.add(mergeFeatures(segResult.getFeatureList().get(i), segResult.getFeatureList().get(j), merged));
                                            }
                                            mergedIdx.add(i);
                                            mergedIdx.add(j);
                                        }
                                    }
                                }
                        }
                    }
            }
        }

        // all all others
        for (int i = 0; i < segResult.getShapeList().size(); i++) {
            if (!mergedIdx.contains(i)) {
                mergedSegments.add(segResult.getShapeList().get(i));
                if (mergedFeatures != null && segResult.getFeatureList() != null && segResult.getFeatureList().size() > i)
                    mergedFeatures.add(segResult.getFeatureList().get(i));
            }
        }
        segResult.setShapeList(mergedSegments);
        segResult.setFeatureList(mergedFeatures);
        return segResult;
    }

    @Deprecated
    private boolean checkMaxOpenDist(PolygonExt merged) {
        if (merged.npoints>1) {
            for (int i = 1; i < merged.npoints; i++) {
                double dist = Point.distance(merged.xpoints[i-1],merged.ypoints[i-1],merged.xpoints[i],merged.ypoints[i]);
                if (dist>500) {
                    System.out.println("dist: "+dist);
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if first points in polygons are on different tiles (using the recognition frame).
     */
    public boolean onDifferentTiles(PolygonExt p1, PolygonExt p2) {
        if (rf == null) throw new IllegalStateException("recognition frame not set (is null)");
        // check scale? (or not)
        if (p1.npoints==0 && p2.npoints==0) return false;
        if (p1.npoints==0 || p2.npoints==0) return true;
        int tx1 = rf.bimg.getImage().XToTileX(p1.xpoints[0]);
        int tx2 = rf.bimg.getImage().XToTileX(p2.xpoints[0]);
        if (tx1 != tx2) return true;
        int ty1 = rf.bimg.getImage().YToTileY(p1.ypoints[0]);
        int ty2 = rf.bimg.getImage().YToTileY(p2.ypoints[0]);
        if (ty1 != ty2) return true;
        return false;
    }
        
    /*
    private List<Shape> sortPointsInPolys(List<Shape> segments) {
        if (segments == null || segments.size() == 0) return segments;
    //    PointSorter pSorter = new PointSorter();
        List<Shape> sortedShapes = new ArrayList<Shape>(segments.size());
        for (Shape s : segments) {
            if (s instanceof PolygonExt) {
                PolygonExt poly = (PolygonExt) s;
                // transform to pointlist
                List<Point2D> pList = new ArrayList<Point2D>(poly.npoints);
                for (int i = 0; i < poly.npoints; i++) {
                    pList.add(new Point2D.Float ( poly.xpoints[i], poly.ypoints[i]));
                }
       //         pList = pSorter.sortPoints(pList);     // TODO
                pList = simpleSort(pList);

                // build new ploygonExt based on polygonList
                PolygonExt newPoly = new PolygonExt();
                newPoly.setClosed(poly.isClosed());
                newPoly.setInverse(poly.isInverse());
                newPoly.setOnlyPoints(poly.isOnlyPoints());
                newPoly.setScale(poly.getScale());
                for (Point2D p : pList) {
                    newPoly.addPoint((int)p.getX(), (int)p.getY());
                }
                sortedShapes.add(newPoly);
            } else {
                sortedShapes.add(s);
            }
        }
        return sortedShapes;
    }

    private List<Point2D> simpleSort(List<Point2D> pList) {
        HashSet<Point2D> pHash = new HashSet<>(pList.size());
        List<Point2D> sList = new ArrayList<>(pList.size());

        // first: remove duplicate points
        for (Point2D p: pList) {
            if (!pHash.contains(p)) {
                sList.add(p);
                pHash.add(p);
            }
        }
        // now sort them. Assumption: points in 1 pixel distance



        return sList;
    }
    */


    private double[] mergeFeatures(double[] f1, double[] f2, Polygon mergedPoly) {
        if (f1 == null || f2 == null) return f1;

        // features are: intens, shape, classNum

        // shape features will be recomputed
        ObjectFeatureBuilderTiled cfb = new ObjectFeatureBuilderTiled(segmentationModel);
        List<Double> shapeFeatures = cfb.getFeatureShapeDescriptors(mergedPoly);

        // intensity features will be aggregated
        double[] m = new double[f1.length - shapeFeatures.size() - 1]; //-1 is classNum
        for (int i = 0; i < f1.length - shapeFeatures.size() - 1; i++) {
            // mean,max,min,sd for each sample
            if ((i + 1) % 4 == 1 || (i + 1) % 4 == 0) m[i] = (f1[i] + f2[i]) / 2d; // mean and sd
            else if ((i + 1) % 4 == 2) m[i] = Math.max(f1[i], f2[i]); // max
            else if ((i + 1) % 4 == 3) m[i] = Math.min(f1[i], f2[i]); // min
        }

        // copy intensFeatures and shapeFeatures
        double[] feats = new double[m.length + shapeFeatures.size() + 1];
        System.arraycopy(m, 0, feats, 0, m.length);
        for (int i = 0; i < shapeFeatures.size(); i++) {
            feats[i + m.length] = shapeFeatures.get(i);
        }
        feats[feats.length - 1] = f1[f1.length - 1]; // use class from first featureset

        //System.out.println("fe: ["+feats.length+"]: " +Arrays.toString(feats));

        return feats;
    }

    /*
    private Polygon mergePolysSorted(Polygon p1, Polygon p2) {
        List<Point> pList = new ArrayList<Point>(p1.npoints + p2.npoints);
        for (int i = 0; i < p1.npoints; i++) {
            pList.add(new Point(p1.xpoints[i], p1.ypoints[i]));
        }
        for (int i = 0; i < p2.npoints; i++) {
            pList.add(new Point(p2.xpoints[i], p2.ypoints[i]));
        }
        //PointSorter pSorter = new PointSorter();
        //pList = pSorter.sortPoints(pList);

        PolygonExt newP = new PolygonExt();
        if (p1 instanceof PolygonExt) {
            newP.setClosed(((PolygonExt) p1).isClosed());
            newP.setOnlyPoints(((PolygonExt) p1).isOnlyPoints());
        }
        for (Point p : pList) {
            newP.addPoint(p.x, p.y);
        }

        return newP;
    }
    */

    private PolygonExt mergePolysSorted(Polygon p1, Polygon p2) {
        int[] closestIdx = nearestPointsIndex(p1, p2);
        List<Point> pList = new ArrayList<Point>(p1.npoints + p2.npoints);
        // add points from p1 until closest point
        for (int i = 0; i <= closestIdx[0]; i++) {
            pList.add(new Point(p1.xpoints[i], p1.ypoints[i]));
        }
        // p2 from closest point till end
        for (int i = closestIdx[1]; i < p2.npoints; i++) {
            pList.add(new Point(p2.xpoints[i], p2.ypoints[i]));
        }
        // p2 from start till closest point (incl to close 2nd poly)
        for (int i = 0; i <= closestIdx[1]; i++) {
            pList.add(new Point(p2.xpoints[i], p2.ypoints[i]));
        }
        // remaining points of p1
        for (int i = closestIdx[0] + 1; i < p1.npoints; i++) {
            pList.add(new Point(p1.xpoints[i], p1.ypoints[i]));
        }

        // remove duplicate followup points
        ArrayList<Point> finalList = new ArrayList<>(pList.size());
        finalList.add(pList.get(0));
        for (int i = 1; i < pList.size(); i++) {
            Point last = pList.get(i - 1);
            Point curr = pList.get(i);
            if (curr.x != last.x || curr.y != last.y) {
                finalList.add(curr);
            }
        }


        // reconstruct polygon
        PolygonExt newP = new PolygonExt();
        if (p1 instanceof PolygonExt) {
            newP.setClosed(((PolygonExt) p1).isClosed());
            newP.setOnlyPoints(((PolygonExt) p1).isOnlyPoints());
        }
        for (Point p : finalList) {
            newP.addPoint(p.x, p.y);
        }

        return newP;
    }

    /**
     * Returns the two closest points (it returns two points, from each polygon one).
     * preAlloc can be a pre-allocated Point[2] array. If not null, it will be used.
     */
    private Point[] nearestPoints(Polygon poly1, Polygon poly2, Point[] preAlloc) {
        Point[] res = preAlloc;
        if (res == null) res = new Point[2];
        double minDist = Double.MAX_VALUE;
        double dist = minDist;
        for (int i = 0; i < poly1.npoints; i++) {
            Point p1 = new Point(poly1.xpoints[i], poly1.ypoints[i]);
            for (int j = 0; j < poly2.npoints; j++) {
                Point p2 = new Point(poly2.xpoints[j], poly2.ypoints[j]);
                dist = p1.distance(p2);
                if (dist < minDist) {
                    res[0] = p1;
                    res[1] = p2;
                    minDist = dist;
                }
            }
        }
        return res;
    }

    /**
     * @param poly1
     * @param poly2
     * @return two indexs of the closest points
     */
    private int[] nearestPointsIndex(Polygon poly1, Polygon poly2) {
        int[] res = new int[2];
        double minDist = Double.MAX_VALUE;
        double dist = minDist;
        for (int i = 0; i < poly1.npoints; i++) {
            Point p1 = new Point(poly1.xpoints[i], poly1.ypoints[i]);
            for (int j = 0; j < poly2.npoints; j++) {
                Point p2 = new Point(poly2.xpoints[j], poly2.ypoints[j]);
                dist = p1.distance(p2);
                if (dist < minDist) {
                    res[0] = i;
                    res[1] = j;
                    minDist = dist;
                }
            }
        }
        return res;
    }


    private List<Color> buildHeatmapFeatures(List<double[]> features, int heatMapFeatureIdx) {
        int idx = features.get(0).length - heatmapFeature;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double d;
        for (int i = 0; i < features.size(); i++) {
            d = features.get(i)[idx];
            if (d > max) max = d;
            if (d < min) min = d;
        }
        List<Color> colors = new ArrayList<Color>(features.size());
        double val;
        for (int i = 0; i < features.size(); i++) {
            d = features.get(i)[idx];
            val = (d - min) / (max - min);
            Color color1 = Color.white;
            Color color2 = Color.red;
            int red = (int) (color2.getRed() * val + color1.getRed() * (1 - val));
            int green = (int) (color2.getGreen() * val + color1.getGreen() * (1 - val));
            int blue = (int) (color2.getBlue() * val + color1.getBlue() * (1 - val));
            colors.add(new Color(red, green, blue));
        }
        return colors;
    }

    private boolean inverseShape(Shape s, int offsX, int offsY, TiledImageWriter originalClassImage) {
        //if (true) return false;
        Rectangle bb = s.getBounds();
        int in = 0;
        int out = 0;
        Raster raster = originalClassImage.getImage().getData();
        for (int y = (int) bb.getMinY(); y <= (int) bb.getMaxY(); y++) {
            for (int x = (int) bb.getMinX(); x < (int) bb.getMaxX(); x++) {
                if (s.contains(x, y)) {
                    if (rf.getClass(x - offsX, y - offsY, originalClassImage, raster) > 0) in++;
                    else out++;
                }
            }
        }
        double ratio = (double) in / (in + (double) out);
        return ratio < 0.25d; // ratio will be mostly 1 or 0
    }

    private boolean shapeInNegativeChannel(Shape s) {
        //return false;
        //if (rf.getNegativeChannel()==null) return false;
        if (exclusionMap == null || (!exclusionMap.useForSegmentation())) return false;
        Rectangle bb = s.getBounds();
        int cnt = 0;
        int hit = 0;
        for (int x = bb.x; x < bb.getMaxX(); x++)
            for (int y = bb.y; y < bb.getMaxY(); y++) {
                //if (s.contains(x,y) && rf.getNegativeChannel().getClass(x, y) > 0) {
                if (s.contains(x, y)) {
                    cnt++;
                    if (exclusionMap.isExcluded(x, y))
                        hit++;
                }

            }
        double ratio = 0d;
        if (cnt > 0) ratio = hit / (double) cnt;
        //System.out.println("hit:"+hit+" cnt:"+cnt+" ratio:"+ratio);
        // 0.75
        return ratio > 0.75d;
    }


    /**
     * applies "right-hand" rule and adds adjoined points to pListArr.<br>
     * The buffer buf will be modified!!!
     */
    public void addRightHandPoints(int xStart, int yStart, final short[][] buf, final List<Point> pList, int offsX, int offsY) {

        final int width = buf.length;
        final int height = buf[0].length;
        final Stack<Point> stack = new Stack<Point>();
        int x;
        int y;
        stack.push(new Point(xStart, yStart));
        while (!stack.isEmpty()) {
            Point p = stack.pop();
            x = p.x;
            y = p.y;
            if ((buf[x][y] > 0) && (buf[x][y] != Short.MAX_VALUE) && (exclusionMap == null || !exclusionMap.isExcluded(x + offsX, y + offsY))) {
                if (adjoinsClass(x, y, buf)) {
                    pList.add(new Point(x, y));
                }

                if (x == 0 && y == 0 && (buf[x][y] == buf[x + 1][y])) {
                    stack.push(new Point(x + 1, y));
                } // upper left corner
                if (x > 0 && (x < width - 1) && y == 0 && (buf[x][y] == buf[x + 1][y])) {
                    stack.push(new Point(x + 1, y));
                } // upper border
                if ((x == width - 1) && y == 0 && (buf[x][y] == buf[x][y + 1])) {
                    stack.push(new Point(x, y + 1));
                } // upper right corner
                if ((x == width - 1) && y > 0 && (y < height - 1) && (buf[x][y] == buf[x][y + 1])) {
                    stack.push(new Point(x, y + 1));
                } // right border
                if ((x == width - 1) && (y == height - 1) && (buf[x][y] == buf[x - 1][y])) {
                    stack.push(new Point(x - 1, y));
                } // lower right corner
                if (x > 0 && (x < width - 1) && (y == height - 1) && (buf[x][y] == buf[x - 1][y])) {
                    stack.push(new Point(x - 1, y));
                } // lower border
                if (x == 0 && (y == height - 1) && (buf[x][y] == buf[x][y - 1])) {
                    stack.push(new Point(x, y - 1));
                } // lower left corner
                if (x == 0 && y > 0 && (y < height - 1) && (buf[x][y] == buf[x][y - 1])) {
                    stack.push(new Point(x, y - 1));
                } // left border

                // non-border regions

                if ((x < width - 1) && (y > 0) && (buf[x + 1][y - 1] == buf[x][y]) && (adjoinsClass(x + 1, y - 1, buf))) {
                    stack.push(new Point(x + 1, y - 1));
                } // north-east
                if ((x < width - 1) && (buf[x + 1][y] == buf[x][y]) && (adjoinsClass(x + 1, y, buf))) {
                    stack.push(new Point(x + 1, y));
                } // east
                if ((x < width - 1) && (y < height - 1) && (buf[x + 1][y + 1] == buf[x][y]) && (adjoinsClass(x + 1, y + 1, buf))) {
                    stack.push(new Point(x + 1, y + 1));
                } // south-east
                if ((y < height - 1) && (buf[x][y + 1] == buf[x][y]) && (adjoinsClass(x, y + 1, buf))) {
                    stack.push(new Point(x, y + 1));
                } // south
                if ((y < height - 1) && (x > 0) && (buf[x - 1][y + 1] == buf[x][y]) && (adjoinsClass(x - 1, y + 1, buf))) {
                    stack.push(new Point(x - 1, y + 1));
                } // south-west
                if ((x > 0) && (buf[x - 1][y] == buf[x][y]) && (adjoinsClass(x - 1, y, buf))) {
                    stack.push(new Point(x - 1, y));
                } // west
                if ((y > 0) && (x > 0) && (buf[x - 1][y - 1] == buf[x][y]) && (adjoinsClass(x - 1, y - 1, buf))) {
                    stack.push(new Point(x - 1, y - 1));
                } // north-west
                if ((y > 0) && (buf[x][y - 1] == buf[x][y]) && (adjoinsClass(x, y - 1, buf))) {
                    stack.push(new Point(x, y - 1));
                } // north
                buf[x][y] = Short.MAX_VALUE;
                // use visitedList? (no)
            } // col
        } // stack not empty
    }


    /**
     * tests if x,y is adjoined given buf. In this version Short.MAX_VALUE is ignored (so it can be a marked color)
     *
     * @param x
     * @param y
     * @return
     */
    private boolean adjoinsClass(final int x, final int y, final short[][] smap) {
        if ((x > 0) && (y >= 0) && (x < smap.length) && (y < smap[0].length) && (smap[x - 1][y] != smap[x][y]) && (smap[x - 1][y] != Short.MAX_VALUE))
            return true; //west
        if ((x >= 0) && (y >= 0) && (x + 1 < smap.length) && (y < smap[0].length) && (smap[x + 1][y] != smap[x][y]) && (smap[x + 1][y] != Short.MAX_VALUE))
            return true; //east
        if ((x >= 0) && (y >= 0) && (x < smap.length) && (y + 1 < smap[0].length) && (smap[x][y + 1] != smap[x][y]) && (smap[x][y + 1] != Short.MAX_VALUE))
            return true; //north
        return (y > 0) && (x >= 0) && (x < smap.length) && (y < smap[0].length) && (smap[x][y - 1] != smap[x][y]) && (smap[x][y - 1] != Short.MAX_VALUE);
    }


    public RecognitionFrame getRf() {
        return rf;
    }


    public void setRf(RecognitionFrame rf) {
        this.rf = rf;
    }


    private short[][] erode(final short[][] buf) {
        final short cf = 0;
        final short[][] res = new short[buf.length][buf[0].length];
        for (int x = 0; x < buf.length; x++)
            for (int y = 0; y < buf[x].length; y++) {
                res[x][y] = buf[x][y];
                if (x > 0 && buf[x - 1][y] == cf) res[x][y] = cf;
                else if (x < buf.length - 1 && buf[x + 1][y] == cf) res[x][y] = cf;
                else if (y > 0 && buf[x][y - 1] == cf) res[x][y] = cf;
                else if (y < buf[x].length - 1 && buf[x][y + 1] == cf) res[x][y] = cf;
            }
        return res;
    }

    private short[][] dilate(final short[][] buf) {
        final short cf = 1;
        final short[][] res = new short[buf.length][buf[0].length];
        for (int x = 0; x < buf.length; x++)
            for (int y = 0; y < buf[x].length; y++) {
                res[x][y] = buf[x][y];
                if (x > 0 && buf[x - 1][y] == cf) res[x][y] = cf;
                else if (x < buf.length - 1 && buf[x + 1][y] == cf) res[x][y] = cf;
                else if (y > 0 && buf[x][y - 1] == cf) res[x][y] = cf;
                else if (y < buf[x].length - 1 && buf[x][y + 1] == cf) res[x][y] = cf;

//				else
//				if (x>0 && y>0 && buf[x-1][y-1]==cf) res[x][y] = cf; else
//				if (x<buf.length-1 && y>0 && buf[x+1][y-1]==cf) res[x][y] = cf; else
//				if (y>0 && x<buf.length-1 && buf[x+1][y-1]==cf) res[x][y] = cf; else
//				if (y<buf[x].length-1 && x<buf.length-1 && buf[x+1][y+1]==cf) res[x][y] = cf;

                if (x == 0 || y == 0 || x == buf.length - 1 || y == buf[x].length - 1)
                    res[x][y] = 0;   // border pixel is always background (needed to 'close' objects)
            }
        return res;
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
            setPlasmaScale(model.getSegmentationModel().getFeatureDescription().getSegmentationScale());
            this.cytoplasmaSegmentation = model.getSegmentationModel().getFeatureDescription().isCytoplasmaSegmentation();
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

    public int getNumThreads() {
        return numThreads;
    }

    public void setNumThreads(int numThreads) {
        this.numThreads = numThreads;
    }

    public ExclusionMapGen getExclusionMap() {
        return exclusionMap;
    }

    public void setExclusionMap(ExclusionMapGen exclusionMap) {
        this.exclusionMap = exclusionMap;
    }

    public List<Point> getTiles() {
        return tiles;
    }

    public void setTiles(List<Point> tiles) {
        this.tiles = tiles;
    }

    public boolean isDoWatershed() {
        return doWatershed;
    }

    public void setDoWatershed(boolean doWatershed) {
        this.doWatershed = doWatershed;
    }

    public boolean isDoErode() {
        return doErode;
    }

    public void setDoErode(boolean doErode) {
        this.doErode = doErode;
    }

    public boolean isDoDilate() {
        return doDilate;
    }

    public void setDoDilate(boolean doDilate) {
        this.doDilate = doDilate;
    }

    public int getNumErode() {
        return numErode;
    }

    public void setNumErode(int numErode) {
        this.numErode = numErode;
    }

    public int getNumDilate() {
        return numDilate;
    }

    public void setNumDilate(int numDilate) {
        this.numDilate = numDilate;
    }

    public boolean isDoRepaint() {
        return doRepaint;
    }

    public void setDoRepaint(boolean doRepaint) {
        this.doRepaint = doRepaint;
    }

    public boolean isDontClassify() {
        return dontClassify;
    }

    public void setDontClassify(boolean dontClassify) {
        this.dontClassify = dontClassify;
    }

    public double getPlasmaScale() {
        return plasmaScale;
    }

    public void setPlasmaScale(double plasmaScale) {
        this.plasmaScale = plasmaScale;
    }

    public boolean isMergeTileSegments() {
        return mergeTileSegments;
    }

    public void setMergeTileSegments(boolean mergeTileSegments) {
        this.mergeTileSegments = mergeTileSegments;
    }

    public boolean isFilterTileEdgeShapes() {
        return filterTileEdgeShapes;
    }

    public void setFilterTileEdgeShapes(boolean filterTileEdgeShapes) {
        this.filterTileEdgeShapes = filterTileEdgeShapes;
    }

    public int getMergeMinDistance() {
        return mergeMinDistance;
    }

    public void setMergeMinDistance(int mergeMinDistance) {
        this.mergeMinDistance = mergeMinDistance;
    }

    public int getHeatmapFeature() {
        return heatmapFeature;
    }

    public void setHeatmapFeature(int heatmapFeature) {
        this.heatmapFeature = heatmapFeature;
    }

    public SegmentationResult getSegmentationResult() {
        return segmentationResult;
    }

    public void setSegmentationResult(SegmentationResult segmentationResult) {
        this.segmentationResult = segmentationResult;
    }

    public int getNumRemoveOutliers() {
        return numRemoveOutliers;
    }

    public void setNumRemoveOutliers(int numRemoveOutliers) {
        this.numRemoveOutliers = numRemoveOutliers;
    }

    public boolean isDilateBeforeErode() {
        return dilateBeforeErode;
    }

    public void setDilateBeforeErode(boolean dilateBeforeErode) {
        this.dilateBeforeErode = dilateBeforeErode;
    }

    public double getGraphCutSmoothness() {
        return graphCutSmoothness;
    }

    public void setGraphCutSmoothness(double graphCutSmoothness) {
        this.graphCutSmoothness = graphCutSmoothness;
    }

    public RecognitionFrame getOriginalFrame() {
        return originalFrame;
    }

    public void setOriginalFrame(RecognitionFrame originalFrame) {
        this.originalFrame = originalFrame;
    }

    public boolean isCytoplasmaSegmentation() {
        return cytoplasmaSegmentation;
    }

    public void setCytoplasmaSegmentation(boolean cytoplasmaSegmentation) {
        this.cytoplasmaSegmentation = cytoplasmaSegmentation;
    }


    private class SecondLevelSegmentation {
        private List<Shape> segments;
        private List<double[]> features;
        private int secondaryObjectCount;
        private List<Shape> secondaryShapes;
        private AtomicInteger allObjectCountSecondary;
        private int numSamples = 3;

        public SecondLevelSegmentation(List<Shape> segments, List<double[]> features, int secondaryObjectCount, List<Shape> secondaryShapes, AtomicInteger allObjectCountSecondary, int numSamples) {
            this.segments = segments;
            this.features = features;
            this.secondaryObjectCount = secondaryObjectCount;
            this.secondaryShapes = secondaryShapes;
            this.allObjectCountSecondary = allObjectCountSecondary;
            this.numSamples = numSamples;
        }

        public int getSecondaryObjectCount() {
            return secondaryObjectCount;
        }

        public List<Shape> getSecondaryShapes() {
            return secondaryShapes;
        }

        public SecondLevelSegmentation invoke() {
            if (secondarySegmentationModel != null) {
                secondaryShapes = new ArrayList<Shape>();
                // We use a copy of the secondary segmentation model and set the model itself as (primary) segmentation model so that we can use the ObjectSegmentationWorker recursively.
                OrbitModel secModel = new OrbitModel(secondarySegmentationModel);
                secModel.setSegmentationModel(secModel);

                boolean primaryFeaturesAvailable = features.size() > 0;
                IScaleableShape primaryROI = rf.getROI();
                for (int i = 0; i < segments.size(); i++) {
                    Shape primaryShape = segments.get(i);
                    if (primaryShape instanceof IScaleableShape) {
                        Rectangle primaryBounds = primaryShape.getBounds();
                        if (primaryBounds.getWidth() >= minSegmentationSize && primaryBounds.getHeight() >= minSegmentationSize) {  // size filter to avoid ROIs with size 0
                            rf.setROI((IScaleableShape) primaryShape);
                            ObjectSegmentationWorker segWorker = new ObjectSegmentationWorker(rdf, rf, null, secModel.getClassShapes(), tiles);
                            segWorker.setModel(secModel);
                            segWorker.setExclusionMap(null);
                            segWorker.setNumThreads(1);  // nested segmentation
                            segWorker.run();
                            SegmentationResult secondarySegmentationResult = segWorker.getSegmentationResult();

                            // only accept if secondary is completely inside primary object
                            if (secondarySegmentationResult != null && secondarySegmentationResult.getShapeList() != null) {
                                ListIterator<Shape> shapeIter = secondarySegmentationResult.getShapeList().listIterator();
                                ListIterator<double[]> featureIter = null;
                                if (secondarySegmentationResult.getFeatureList() != null)
                                    featureIter = secondarySegmentationResult.getFeatureList().listIterator();
                                while (shapeIter.hasNext()) {
                                    Shape second = shapeIter.next();
                                    boolean canFeatureRemove = false;
                                    if (featureIter != null && featureIter.hasNext()) {
                                        featureIter.next();
                                        canFeatureRemove = true;
                                    }

                                    if ((primaryShape instanceof PolygonExt) && (second instanceof PolygonExt)) {
                                        if (!((PolygonExt) primaryShape).contains((PolygonExt) second)) {
                                            shapeIter.remove();
                                            if (canFeatureRemove) featureIter.remove();
                                            secondarySegmentationResult.setObjectCount(secondarySegmentationResult.getObjectCount() - 1);
                                        }
                                    }

                                }
                            }


                            // extend features
                            boolean secFeatsAvailable = false;
                            double[] secondaryFeatures = null;
                            double[] areas = null;
                            if (secondarySegmentationResult.getFeatureList() != null)
                                if (secondarySegmentationResult.getFeatureList().size() > 0)
                                    secondaryFeatures = secondarySegmentationResult.getFeatureList().get(0);
                                else
                                    secondaryFeatures = new ObjectFeatureBuilderTiled(model).makeDefaultFeatures(numSamples);
                            if (secModel.getFeatureDescription().getFeatureClasses() != null && secModel.getFeatureDescription().getFeatureClasses().length > 0) {
                                secFeatsAvailable = true;
                                areas = new double[secondarySegmentationResult.getFeatureList().size()];
                                for (int j = 0; j < secondarySegmentationResult.getFeatureList().size(); j++) {
                                    areas[j] = secondarySegmentationResult.getFeatureList().get(j)[secondaryFeatures.length - ObjectFeatureBuilderTiled.FeatureAreaNumReverse];
                                }
                            }
                            final int numSecondaryFeatures = secFeatsAvailable ? 3 : 1;
                            final int end = ObjectFeatureBuilderTiled.SkipTailForClassification + 1;
                            if (primaryFeaturesAvailable) {
                                double[] vals = features.get(i);
                                final double[] valsExt = new double[vals.length + numSecondaryFeatures];
                                for (int j = 0; j < vals.length - end; j++) {
                                    valsExt[j] = vals[j];
                                }
                                valsExt[vals.length - end] = secondarySegmentationResult.getObjectCount();
                                if (secFeatsAvailable) {
                                    valsExt[(vals.length - end) + 1] = StdStats.mean(areas);
                                    valsExt[(vals.length - end) + 2] = StdStats.stddev(areas, valsExt[(vals.length - end) + 1]);      // TODO: check offset positions (why +1 ???)
                                }
                                for (int j = vals.length - end; j < vals.length; j++) {
                                    valsExt[j + numSecondaryFeatures] = vals[j];
                                }
                                features.set(i, valsExt);
                            }

                            secondaryObjectCount += secondarySegmentationResult.getObjectCount();
                            if (isWithGUI() && !ScaleoutMode.SCALEOUTMODE.get())    // only for display
                                secondaryShapes.addAll(secondarySegmentationResult.getShapeList());
                        } // size check
                    } // else bad luck...
                }
                rf.setROI(primaryROI);

            }
            allObjectCountSecondary.addAndGet(secondaryObjectCount);   // ok ???
            return this;
        }
    }
}
