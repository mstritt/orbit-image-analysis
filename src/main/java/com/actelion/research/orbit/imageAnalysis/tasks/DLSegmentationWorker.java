/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2018 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
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
import com.actelion.research.orbit.imageAnalysis.deeplearning.*;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNSegment;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNSegmentationSettings;
import com.actelion.research.orbit.imageAnalysis.features.ObjectFeatureBuilderTiled;
import com.actelion.research.orbit.imageAnalysis.imaging.IJUtils;
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.segmenter.SegmentedImage;
import com.actelion.research.orbit.imageAnalysis.segmenter.SegmenterFacade;
import com.actelion.research.orbit.imageAnalysis.utils.*;
import com.actelion.research.orbit.utils.StdStats;
import ij.ImagePlus;
import ij.plugin.filter.EDM;
import ij.process.AutoThresholder;
import ij.process.BinaryProcessor;
import ij.process.ByteProcessor;
import imageJ.RankFiltersOrbit;
import imageJ.graphcut.Graph_Cut;
import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import javax.media.jai.PlanarImage;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.util.List;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Object segmentation based on a foreground/background image.
 */
public class DLSegmentationWorker extends OrbitWorker {
    private int minSegmentationSize = 10;
    private final static Logger logger = LoggerFactory.getLogger(DLSegmentationWorker.class);
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
    public DLSegmentationWorker(RawDataFile rdf, RecognitionFrame rf, List<SwingWorker<Void, Void>> dependencyList, List<ClassShape> classShapeToSet, List<Point> tiles) {
        this.rf = rf;
        this.rdf = rdf;
        if (classShapeToSet != null) {
            if (rf.getClassShapes() != null)
                oldClassShapes =  SerializationUtils.clone(new ArrayList<>(rf.getClassShapes())); // remember original classShapes workaround (dirty fix...). Must be cloned because rf.setClassShapes will clear() and addAll() (next line).
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

            // init maskrcnn segmentation
            assert segmentationModel != null;

            AbstractSegmentationSettings<?> dlSegmentSettings = segmentationModel.getFeatureDescription().getDLSegment();
            AbstractSegment<? extends AbstractDetections<? extends AbstractDetection>,
                    ? extends AbstractSegmentationSettings<?>> dLSegmentationModel = null;

            // Decide which DL model to apply...
            switch(dlSegmentSettings.getModelName()) {
                case "Nuclei":
                    dLSegmentationModel = new MaskRCNNSegment((MaskRCNNSegmentationSettings) dlSegmentSettings);

                    System.out.println(Arrays.toString(((MaskRCNNSegment) dLSegmentationModel).getSegmentationSettings().getMeanPixel()));
                case "Pancreas Islets":
                    break;
                case "Glomeruli":
                    break;
                case "Corpus Callosum":
                    break;
                case "Brain":
                    break;
                default:
                    throw new NoSuchFieldException("No model for: " + dlSegmentSettings.getModelName());

            }


            List<Future<SegmentationResult>> tileSegments;

            for (final Point currentTile : tiles) {
                // TODO: Is this really inefficient?
                MaskRCNNSegment finalDLSegmentationModel = (MaskRCNNSegment) dLSegmentationModel;
                tileTaskList.add(() -> {
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

                    Shape roi;

                    List<Shape> segments = new ArrayList<>();
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

                    if (sourceImage == null && segmentationModel != null && (segmentationModel.getFeatureDescription().isMumfordShahSegmentation() || segmentationModel.getFeatureDescription().isDeepLearningSegmentation())) {
                        RecognitionFrame rf2 = makeROIImage(rf, roi);
                        sourceImage = rf2.bimg.getImage().getAsBufferedImage();
                    }

                    logger.trace("start object segmentation");
                    TiledImageWriter originalClassImage = classImage; // needed later for objectFeatures (intensities) because classImage will be reduced to a two-class image by the watershed process

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

                    // here the actual segmentation per tile happens
                    List<Shape> tileSegmentations;

                    OrbitModel segModel = OrbitModel.LoadFromInputStream(
                            this.getClass().getResourceAsStream("/resource/testmodels/dlsegmentsplit.omo"));

                    // TODO: Make this work on variable size 'virtual' tiles.
                    tileSegmentations = Objects.requireNonNull(finalDLSegmentationModel).generateSegmentationAnnotations(rdf,
                            (MaskRCNNSegmentationSettings) dlSegmentSettings,
                            segModel,
                            null,
                            new Point(0,0),
                            false);

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
                    if (segmentationModel != null
                            && segmentationModel.getFeatureDescription().getFeatureClasses() != null
                            && segmentationModel.getFeatureDescription().getFeatureClasses().length > 0) {
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
                });
            } // tiles

            tileSegments = executor.invokeAll(tileTaskList);

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

            if (allSegmentsAndFeatures.getShapeList() != null) {
                allSegmentsAndFeatures.setObjectCount(allSegmentsAndFeatures.getShapeList().size());
                allObjectCount.set(allSegmentsAndFeatures.getShapeList().size());
            }

            // set dummy classImage, otherwise no objectSegmentations would be rendered
            if (rf.getClassImage() == null)
                rf.setClassImage(new TiledImageWriter(1, 1, 1, 1));
            rf.setObjectSegmentationList(allSegmentsAndFeatures.getShapeList());
            rf.setSecondaryObjectSegmentationList(allSegmentsAndFeatures.getSecondaryShapeList());

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


        } catch (Exception e) {
            logger.error("A problem in the segmentation process occured", e);
            e.printStackTrace();
        }
        rf.setObjectClassificationList(null);
        if (rf.isVisible()) {
            rf.repaint();
        }
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
                            DLSegmentationWorker segWorker = new DLSegmentationWorker(rdf, rf, null, secModel.getClassShapes(), tiles);
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
