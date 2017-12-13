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

import com.actelion.research.orbit.imageAnalysis.features.TissueFeatures;
import com.actelion.research.orbit.imageAnalysis.mask.IOrbitMask;
import com.actelion.research.orbit.imageAnalysis.mask.OrbitMaskClassificationModel;
import com.actelion.research.orbit.imageAnalysis.models.ClassShape;
import com.actelion.research.orbit.imageAnalysis.models.ClassifierWrapper;
import com.actelion.research.orbit.imageAnalysis.models.FeatureDescription;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.tasks.histogram.Histogram;
import com.actelion.research.orbit.imageAnalysis.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

import javax.media.jai.PlanarImage;
import javax.media.jai.TiledImage;
import java.awt.*;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.beans.PropertyChangeEvent;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Callable that substitutes the classifyImage function of RecognitionFrame.<br>
 * Like ClassificationTask, but can handle set of tiles.<br>
 * Fires CLASSIFICATION_PROGRESS [0..100] propertyChangeEvents.
 * <p>
 * Normalization is done in RecognitionWorker, this task outputs only sums.
 */
public class ClassificationTaskTiled extends PropertyChangeEmitter implements Callable<Long[]> {

    public final static String CLASSIFICATION_PROGRESS = "classificationProgress";
    private final static Logger logger = LoggerFactory.getLogger(ClassificationTaskTiled.class);
    private ClassifierWrapper classifier = null;
    private Instances dataSet = null;
    private List<Point> tileList = null;
    private double progress = 0d;
    private FeatureDescription featureDescription = null;
    private int windowSize = 4;
    private List<ClassShape> classShapes = null;
    private TiledImagePainter bimg = null;
    private TiledImageWriter classImage = null;
    private boolean canceled = false;
    private boolean paused = false;
    private boolean writeClassificationImage = true;
    private Shape ROI = null;
    private ExclusionMapGen exclusionMapGen = null;
    private Random rand = new Random();
    private double pixelFuzzyness = 0d;
    private boolean executed = false;
    private Histogram[] histograms = null; // histograms per channel
    private IOrbitMask mask = null;
    private TiledImagePainter maskImage = null;

    public ClassificationTaskTiled(final OrbitModel model, final Shape ROI, final TiledImagePainter bimg, final TiledImagePainter maskImage, final TiledImageWriter classImage, final List<Point> tileList, final boolean writeClassificationImage) {
        this(model.getClassifier(), model.getStructure(), model.getFeatureDescription(), model.getClassShapes(), ROI, model.getMask(), maskImage, bimg, classImage, tileList, writeClassificationImage);
    }

    /**
     * @param classifier               (has to be build before)
     * @param dataSet
     * @param classShapes
     * @param ROI                      (can be null)
     * @param bimg
     * @param classImage
     * @param tileList
     * @param writeClassificationImage
     */
    public ClassificationTaskTiled(final ClassifierWrapper classifier, final Instances dataSet, final FeatureDescription featureDescription, final List<ClassShape> classShapes, final Shape ROI, final IOrbitMask mask, final TiledImagePainter maskImage, final TiledImagePainter bimg, final TiledImageWriter classImage, final List<Point> tileList, final boolean writeClassificationImage) {
        this.classifier = classifier;
        this.dataSet = dataSet;
        this.tileList = tileList;
        this.featureDescription = featureDescription;
        this.windowSize = featureDescription.getWindowSize();
        this.classShapes = classShapes;
        this.ROI = ROI;
        this.mask = mask;
        this.bimg = bimg;
        this.classImage = classImage;
        this.writeClassificationImage = writeClassificationImage;
        if (writeClassificationImage && (classImage == null))
            throw new IllegalArgumentException("writeClassificationImage is true but classImage is null, please either deactivate writeClassificationImage or provide a classImage (e.g. TilesImage).");
        this.maskImage = maskImage;
        if (this.mask!=null) {
            this.mask.initialize(maskImage);
        }
    }

    public Long[] call() throws Exception {
        if (executed) throw new RuntimeException("only one execution allowed"); // only one execution!
        executed = true;
        Long[] ratio = new Long[classShapes.size()];
        for (int i = 0; i < ratio.length; i++) ratio[i] = new Long(0);
        Color c;
        Instance inst = null;
        TissueFeatures tissueFeatures = OrbitUtils.createTissueFeatures(featureDescription, bimg);
        double[] feats = new double[(windowSize * 2 + 1) * (windowSize * 2 + 1) * 3 + 1]; // +1 for contextclassification???

        TiledImage classImg = null;
        if (writeClassificationImage) classImg = classImage.getImage();
        PlanarImage image = bimg.getImage();
        int numDone = 0;
        double oldProgress = 0d;
        if ((tileList == null) || (tileList.size() == 0)) {
            logger.trace("Warning: tileList.size()==0 (e.g. too many threads, but not problem)"); // happens if to many threads, but no problem
            firePropertyChangeEvent(new PropertyChangeEvent(this, CLASSIFICATION_PROGRESS, new Double(0), new Double(100)));
            return ratio;
        }
        if (tileList.size() == 1 && tileList.get(0).x == -1 && tileList.get(0).y == -1) {
            tileList = Arrays.asList(image.getTileIndices(null));
        }

        HashSet<Integer> featureClassSet = null;
        if (featureDescription.getFeatureClasses() != null && featureDescription.getFeatureClasses().length > 0) {
            featureClassSet = new HashSet<Integer>(featureDescription.getFeatureClasses().length);
            for (int i = 0; i < featureDescription.getFeatureClasses().length; i++) {
                featureClassSet.add(featureDescription.getFeatureClasses()[i]);
            }
        }
        //System.out.println("tileList: "+tileList);
        for (Point tileNum : tileList) {
            //logger.trace("before getting raster "+tileNum.x+"/"+tileNum.y);
            long startTime = System.currentTimeMillis();
          

            // check if tile is in ROI (if not, don't load image data) -> too fuzzy
//            if (!OrbitUtils.isTileInROI(tileNum.x,tileNum.y,bimg.getImage(),ROI,exclusionMapGen)) {
//                continue;
//            }

            Raster readRaster = OrbitUtils.getRasterForClassification(bimg, featureDescription, windowSize, tileNum.x, tileNum.y);
            Raster maskRaster = readRaster;
            if (maskImage!=null && mask instanceof OrbitMaskClassificationModel) {
               maskRaster = OrbitUtils.getRasterForClassification(maskImage, ((OrbitMaskClassificationModel) mask).getModel().getFeatureDescription(), ((OrbitMaskClassificationModel) mask).getModel().getFeatureDescription().getWindowSize(), tileNum.x, tileNum.y);
            }

            WritableRaster writeRaster = null;
            if (writeClassificationImage) {
                try {
                    writeRaster = classImg.getWritableTile(tileNum.x, tileNum.y);
                } catch (Throwable ex) {
                    writeRaster = null;
                    logger.error("error getting writable tile: " + ex.getMessage()); // batch mode error: unable to create new native thread
                }
            }

            int samples = featureDescription.getSampleSize();
            int[] rgb = null;
            if (histograms != null) {
                if (histograms.length != samples)
                    throw new IllegalArgumentException("Histogram size must match sample size. Histogram.length=" + histograms.length + " but samplesize=" + samples);
                rgb = new int[samples];
            }
            final boolean doHistogram = (histograms != null && featureClassSet != null);
            int minX = image.tileXToX(tileNum.x);
            int maxX = image.tileXToX(tileNum.x) + image.getTileWidth();
            int minY = image.tileYToY(tileNum.y);
            int maxY = image.tileYToY(tileNum.y) + image.getTileHeight();

// disable the ROI bound check because out of bounds of a roi does not imply an exclusion from calculation. E.g. the bounds of a ShapeAnnotationList ROI with only inclusion annotations is the union of the inclusion annotations,
// but pixels outside this ROI should be included as well unless they are not excluded e.g. by an exclusion annotation

//            if (ROI != null) {
//                Rectangle bb = ROI.getBounds();
//                if (bb != null) {    
//                    if (bb.getMinX() > minX) minX = (int) bb.getMinX();
//                    if (bb.getMinY() > minY) minY = (int) bb.getMinY();
//                    if (bb.getMaxX() < maxX) maxX = (int) bb.getMaxX();
//                    if (bb.getMaxY() < maxY) maxY = (int) bb.getMaxY();
//                }
//            }

            for (int x = minX; x < maxX; x++)
                for (int y = minY; y < maxY; y++) {
                    if (canceled) continue;

                    if (OrbitUtils.TILEMODE) {
                        if (!((x > readRaster.getMinX() + windowSize) && (y > readRaster.getMinY() + windowSize) && (x < readRaster.getMinX() + readRaster.getWidth() - windowSize) && (y < readRaster.getMinY() + readRaster.getHeight() - windowSize)))
                            continue;
                    }

                    if (OrbitUtils.isInROI(x, y, ROI, exclusionMapGen)) {
                        if ((pixelFuzzyness > 0) && (rand.nextDouble() < pixelFuzzyness)) continue;
                        if (mask!=null && !mask.isIncluded(x,y,maskRaster)) continue;

                        feats = tissueFeatures.buildFeatures(readRaster, x, y, Double.NaN);

                        inst = new DenseInstance(1.0d, feats);
                        inst.setDataset(dataSet);
                        try {
                            double classVal;
                            classVal = classifier.classifyInstance(inst);
                            if (classVal > ratio.length - 1)
                                logger.warn("classVal > image ratios (class numbers and rations don't match anymore!) ratioLength: " + ratio.length + " classVal: " + classVal);
                            ratio[(int) classVal]++;
                            if (doHistogram) {
                                if (featureClassSet.contains((int) classVal)) {
                                    rgb = readRaster.getPixel(x, y, rgb);
                                    for (int i = 0; i < rgb.length; i++) {
                                        histograms[i].inc(rgb[i]);
                                    }
                                }
                            }
                            if (writeClassificationImage) {
                                c = classShapes.get((byte) classVal).getColor();
                                writeRaster.setPixel(x, y, new int[]{c.getRed(), c.getGreen(), c.getBlue(), 255});
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            logger.error("error classifying image", e);
                        }
                    } // ROI check

                } // x,y


            if (writeClassificationImage) {
                classImg.releaseWritableTile(tileNum.x, tileNum.y);
                //DiskMemImage.getCommonTileCache().flush(); // really needed? -> NO!
            }
            if (canceled) break;

            numDone++;
            progress = (numDone / (double) tileList.size()) * 100d;
            firePropertyChangeEvent(new PropertyChangeEvent(this, CLASSIFICATION_PROGRESS, oldProgress, progress));
            oldProgress = progress;

            // pause
            while (paused) {
                try {
                    //this.wait();
                    Thread.sleep(200);
                } catch (Exception ex) {
                }
            }

            if (ScaleoutMode.SCALEOUTMODE.get()) {
                long minTime = OrbitUtils.SLEEP_TILE;
                long usedTime = System.currentTimeMillis() - startTime;
                if (usedTime<minTime) {
                    logger.debug("sleeping "+(minTime-usedTime)+" ms");
                    Thread.sleep(minTime-usedTime);
                }
            }

        } // tileNum

        return ratio;
    }



    public double getProgress() {
        return progress;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public void cancel() {
        setCanceled(true);
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public void pause() {
        setPaused(true);
    }

    public void resume() {
        setPaused(false);
    }

    public boolean isWriteClassificationImage() {
        return writeClassificationImage;
    }

    public ExclusionMapGen getExclusionMapGen() {
        return exclusionMapGen;
    }

    public void setExclusionMapGen(ExclusionMapGen exclusionMapGen) {
        this.exclusionMapGen = exclusionMapGen;
    }

    public double getPixelFuzzyness() {
        return pixelFuzzyness;
    }

    public void setPixelFuzzyness(double pixelFuzzyness) {
        this.pixelFuzzyness = pixelFuzzyness;
    }

    public Histogram[] getHistograms() {
        return histograms;
    }

    public void setHistograms(Histogram[] histograms) {
        this.histograms = histograms;
    }
}
