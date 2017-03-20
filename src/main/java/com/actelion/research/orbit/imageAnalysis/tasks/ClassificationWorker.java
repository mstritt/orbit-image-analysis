/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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

import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.utils.ScaleoutMode;
import com.actelion.research.orbit.imageAnalysis.utils.TiledImageWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import weka.core.Instances;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;

/**
 * Tissue classification or clustering worker
 */
public class ClassificationWorker extends OrbitWorker implements PropertyChangeListener {

    private Logger logger = LoggerFactory.getLogger(ClassificationWorker.class);
    private int numClassificationThreads = Runtime.getRuntime().availableProcessors();
    private List<Callable<Long[]>> taskList = null;
    private List<Callable<Double[]>> minRemTaskList = null;
    private final Map<Object, Double> threadProgress = new ConcurrentHashMap<Object, Double>();
    private ClassifierWrapper classifier = null;
    private Instances dataset = null;
    private RecognitionFrame rf = null;
    protected ExecutorService executor = null;
    private HashMap<Integer, Byte> colorClassLookup = null;
    private boolean writeClassificationImage = true;
    private Shape roi = null;
    private boolean calculateRatio = true; // per default the ratio will be computed, but it can be deactivated due to performance (e.g. in cell classification batch mode)
    private ExclusionMapGen exclusionMapGen = null;
    private Random rand = new Random();
    private double tileFuzzyness = 0.0d;
    private double pixelFuzzyness = 0.0d;
    private OrbitModel model = null;
    private List<Point> tiles = null;
    //private boolean minAreaRemoval = false;
    private boolean doNormalize = true;
    private RecognitionFrame originalFrame = null;


    /**
     * Special constructor with a trainWorker that may not be finished. The constructor will wait until the
     * training is done and then take the (trained) classifier and the datastructure.
     *
     * @param rf
     * @param dependencyList
     */
    public ClassificationWorker(RecognitionFrame rf, OrbitModel model, boolean writeClassificationImage, ExclusionMapGen exclusionMapGen, List<SwingWorker<Void, Void>> dependencyList) {
        this.model = model;
        this.rf = rf;
        if (model.getFixedCircularROI() > 0) {
            roi = new Arc2DExt();
            ((Arc2DExt) roi).setArcByCenter((rf.bimg.getWidth() / 2d) + model.getFixedROIOffsetX(), (rf.bimg.getHeight() / 2d) + model.getFixedROIOffsetY(), model.getFixedCircularROI(), 0, 360, Arc2DExt.CHORD);
        }
        if (rf.getROI() != null) roi = rf.getROI().getScaledInstance(100d, new Point(0, 0));
        if (model.getClassifier() != null) {
            try {
                this.classifier = ClassifierWrapper.makeCopy(model.getClassifier());
            } catch (Exception e) {
                logger.error("error: ", e);
                e.printStackTrace();
            }
        }
        this.dataset = model.getStructure();
        this.dependencyList = dependencyList;
        this.writeClassificationImage = writeClassificationImage;
        this.exclusionMapGen = exclusionMapGen;
        logger.trace("ROI: " + this.roi);
    }


    @Override
    protected void doWork() throws OrbitImageServletException {
        if (withGUI && !ScaleoutMode.SCALEOUTMODE.get() && numClassificationThreads > 1)
            numClassificationThreads--; // in GUI mode reserve one thread for GUI


        try {
            if (logger.isTraceEnabled() && model.getFeatureDescription() != null)
                logger.trace("windowsize: " + model.getFeatureDescription().getWindowSize());
            if (classifier == null) {
                logger.error("classifier is null, so classification cannot be done.");
                return;
            }
//            if (model != null && model.getFeatureDescription() != null) {
//                this.minAreaRemoval = model.getFeatureDescription().isMinAreaClassification();
//                logger.trace("minAreaRemovel: " + this.minAreaRemoval);
//            }


            threadProgress.clear();

            // (re)build colorClassLookup
            colorClassLookup = new HashMap<Integer, Byte>(rf.getClassShapes().size());
            for (byte i = 0; i < rf.getClassShapes().size(); i++) {
                ClassShape cs = rf.getClassShapes().get(i);
                colorClassLookup.put(cs.getColor().getRGB(), i);
            }

            // exclusion map

            if (exclusionMapGen != null && (!exclusionMapGen.useForSegmentation())) {
                if (!exclusionMapGen.isGenerated()) {
                    exclusionMapGen.generateMap();
                }
                logger.debug("exclusionMap set");
            } else logger.debug("exclusionMap not set: " + exclusionMapGen);


            double[] ratio = rf.getRatio();
            for (int i = 0; i < ratio.length; i++) ratio[i] = 0.0d;
            rf.setRatio(ratio);
            rf.setClassImage(new TiledImageWriter(rf.bimg.getWidth(), rf.bimg.getHeight(), rf.bimg.getTileWidth(), rf.bimg.getTileHeight()));

            executor = Executors.newFixedThreadPool(numClassificationThreads);
            //ExecutorService executor = Executors.newSingleThreadExecutor();
            taskList = new ArrayList<Callable<Long[]>>();

            // build tasklists. Each task gets a set of tiles.
            if (logger.isDebugEnabled())
                logger.debug("image contains " + rf.bimg.getImage().getTileIndices(null).length + " tiles, this task handles " + (tiles != null ? tiles.size() : "all") + " tiles");


            List<List<Point>> tileList = new ArrayList<List<Point>>(numClassificationThreads);
            for (int i = 0; i < numClassificationThreads; i++) {
                tileList.add(new ArrayList<Point>());
            }
            int minTX = 0;
            int maxTX = 0;
            int minTY = 0;
            int maxTY = 0;
            for (int tx = rf.getClassImage().getImage().getMinTileX(); tx <= rf.getClassImage().getImage().getMaxTileX(); tx++)
                for (int ty = rf.getClassImage().getImage().getMinTileY(); ty <= rf.getClassImage().getImage().getMaxTileY(); ty++) {
                    if (roi != null) { // ROI check
                        Rectangle tileRec = rf.getClassImage().getImage().getTileRect(tx, ty);
                        if (!(roi.intersects(tileRec) || roi.contains(tileRec))) continue;
                    }

                    if ((tileFuzzyness > 0) && (rand.nextDouble() < tileFuzzyness)) continue;

                    Point tileNum = new Point(tx, ty);
                    if ((tiles != null) && (!tiles.contains(tileNum))) continue;
                    int taskNum = ((rf.getClassImage().getImage().getMaxTileX() - 1) * ty + tx) % numClassificationThreads;
                    if (taskNum < 0)
                        taskNum = 0; // necessary because if images is not tiled getMaxTileX/Y returns 0, so taskNum would be -1
                    tileList.get(taskNum).add(tileNum);
                    if (tileNum.x < minTX) minTX = tileNum.x;
                    if (tileNum.x > maxTX) maxTX = tileNum.x;
                    if (tileNum.y < minTY) minTY = tileNum.y;
                    if (tileNum.y > maxTY) maxTY = tileNum.y;
                }

//	for (List<Point> subList: tileList) {
//		if (subList!=null && subList.size()>0) {
//			Collections.sort(subList,new TileSorter(minTX,maxTX,minTY,maxTY));
//		}
//	}

            boolean taskFound = false;
            for (int i = 0; i < numClassificationThreads; i++) {
                try {
                    if (tileList.get(i).size() > 0) {
                        taskFound = true;
                        ClassificationTaskTiled classificationTask = new ClassificationTaskTiled(ClassifierWrapper.makeCopy(classifier), dataset, model.getFeatureDescription(),/*rf.getClassShapes()*/model.getClassShapes(), roi, rf.bimg, rf.getClassImage(), tileList.get(i), writeClassificationImage);
                        classificationTask.setPixelFuzzyness(pixelFuzzyness);
                        if (exclusionMapGen != null) classificationTask.setExclusionMapGen(exclusionMapGen);
                        classificationTask.addPropertyChangeListener(this);
                        taskList.add(classificationTask);
                    }
                } catch (Exception e) {
                    logger.error("error: ", e);
                    e.printStackTrace();
                }
            }
            if (!taskFound) {
                // this will result in ratio 0,...,0 !!!
                logger.info("no task found (all tiles outside ROI)");
                return; // nothing todo, e.g. all tiles outside ROI
            }


            try {
                logger.debug("start classifying image (" + numClassificationThreads + " threads)... ");
                List<Future<Long[]>> ratioSteps = null;
                startTime = System.currentTimeMillis();
                boolean classificationOk = true;
                try {
                    ratioSteps = executor.invokeAll(taskList);
                } catch (InterruptedException ex) {
                    classificationOk = false;
                    for (Callable<Long[]> task : taskList) {
                        if (task instanceof ClassificationTaskTiled) {
                            ((ClassificationTaskTiled) task).cancel();
                        }
                    }
                    executor.shutdownNow();
                    logger.debug("cancel classification worker");
                }
                logger.debug("classification done.");


                ratio = new double[rf.getClassShapes().size()];
                // new ratio calculation based on futures
                boolean check = true;
                if (taskList == null || ratioSteps == null) check = false;
                else check = ratioSteps.size() == taskList.size();
                if (ratioSteps != null && ratioSteps.size() > 0 && check) {
                    // problem: the ratioSteps.get(0).get() throws java.util.concurrent.ExecutionException: com.actelion.research.orbit.exceptions.OrbitImageServletException: error loading image data
                    //ratio = new double[ratioSteps.get(0).get().length]; // to ensure length fits
                    // workaround: loop through all ratioSteps and find the first correctly finished one (the others might be null or stopped due to e.g. exclusion map)
                    for (Future<Long[]> future : ratioSteps) {
                        if (future != null && future.isDone() && !future.isCancelled()) {
                            ratio = new double[future.get().length];
                            break; // should break at first future in most cases...
                        }
                    }
                    //int cnt=0;
                    for (Future<Long[]> future : ratioSteps) {
                        if (future.isDone()) {
                            for (int i = 0; i < future.get().length; i++) {
                                ratio[i] += future.get()[i];
                            }
                            //cnt++;
                        }
                    }

                    if (doNormalize) {
                        double sum = 0;
                        for (int i = 0; i < ratio.length; i++) {
                            sum += ratio[i];
                        }
                        if (sum > 0)
                            for (int i = 0; i < ratio.length; i++) {
                                ratio[i] /= sum;
                            }
                    }

                } else {
                    logger.info("Classification has been canceled, no class ratio can be computed. DebugInfo: ratioSteps=" + ratioSteps + " check=" + check + " taskList=" + taskList);
                }
                rf.setRatio(ratio);


            } catch (Exception e) {
                if (e instanceof OrbitImageServletException) {
                    throw new OrbitImageServletException("error executing classification task: " + e.getMessage());
                }
                logger.error("error: ", e);
                e.printStackTrace();
                if (ScaleoutMode.SCALEOUTMODE.get())
                    throw new RuntimeException("error executing classification task: " + e.getMessage());
            } finally {
                try {
                    if (executor != null) {
                        executor.shutdownNow();
                    }
                } catch (Exception e) {
                }
            }

            if (withGUI) {
                taskResult = new TaskResult("Classification Result", createResultStr());
                rf.repaint();
            }

            executor.shutdownNow();

            if (this.originalFrame != null) {
                float scaleInverse = 1f / ((float) rf.bimg.getImage().getWidth() / (float) originalFrame.bimg.getImage().getWidth());
                logger.trace("restoring original recognitionFrame with classImageScale: " + scaleInverse);
                this.originalFrame.setClassImageScale(scaleInverse);
                this.originalFrame.setClassImage(rf.getClassImage());
                this.originalFrame.setRatio(rf.getRatio());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * pauses all tasks in the tasklist. Use resume to continue.
     */
    @SuppressWarnings("unchecked")
    public void pause() {
        for (Callable task : taskList) {
            if (task instanceof ClassificationTaskTiled) {
                ((ClassificationTaskTiled) task).pause();
            }
        }
    }

    /**
     * resumes all tasks in the tasklist.
     */
    @SuppressWarnings("unchecked")
    public void resume() {
        for (Callable task : taskList) {
            if (task instanceof ClassificationTaskTiled) {
                ((ClassificationTaskTiled) task).resume();
            }
        }
    }

    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(ClassificationTaskTiled.CLASSIFICATION_PROGRESS)) {
            double progress = 0d;
            synchronized (threadProgress) {
                if (threadProgress == null) return;
                threadProgress.put(evt.getSource(), (Double) evt.getNewValue());
                for (Object obj : threadProgress.keySet()) {
                    progress += threadProgress.get(obj);
                }
            }
            int num = 0;
            if ((taskList != null) && (taskList.size() > 0)) num += taskList.size();
            if ((minRemTaskList != null) && (minRemTaskList.size() > 0)) num += minRemTaskList.size();
            if (num > 0)
                progress /= num;
            progressD = progress;
            setProgress((int) progress);
        }

    }


    private String createResultStr() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\nClass ratios: [" + rf.getPicName() + "]\n");
        for (int i = 0; i < rf.getRatio().length; i++) {
            double r = rf.getRatio()[i];
            sb.append(model.getClassShapes().get(i).getName() + ": ");   // otherwise for cell classification the original classes are nto available anymore
            //sb.append(rf.getClassShapes().get(i).getName()+": ");
            sb.append(String.format("%1$.6f", r));
            if (i < rf.getRatio().length - 1) sb.append("\n");
        }
        return sb.toString();
    }


    public boolean isCalculateRatio() {
        return calculateRatio;
    }

    public void setCalculateRatio(boolean calculateRatio) {
        this.calculateRatio = calculateRatio;
    }

    public ExclusionMapGen getExclusionMapGen() {
        return exclusionMapGen;
    }

    public void setExclusionMapGen(ExclusionMapGen exclusionMapGen) {
        this.exclusionMapGen = exclusionMapGen;
    }

    public double getTileFuzzyness() {
        return tileFuzzyness;
    }

    public double getPixelFuzzyness() {
        return pixelFuzzyness;
    }

    public void setTileFuzzyness(double tileFuzzyness) {
        this.tileFuzzyness = tileFuzzyness;
    }

    public void setPixelFuzzyness(double pixelFuzzyness) {
        this.pixelFuzzyness = pixelFuzzyness;
    }


    public Shape getRoi() {
        return roi;
    }


    public void setRoi(Shape roi) {
        this.roi = roi;
    }

    public List<Point> getTiles() {
        return tiles;
    }

    public void setTiles(List<Point> tiles) {
        this.tiles = tiles;
    }


    public boolean isDoNormalize() {
        return doNormalize;
    }


    public void setDoNormalize(boolean doNormalize) {
        this.doNormalize = doNormalize;
    }


    public int getNumClassificationThreads() {
        return numClassificationThreads;
    }


    public void setNumClassificationThreads(int numClassificationThreads) {
        this.numClassificationThreads = numClassificationThreads;
    }

    public RecognitionFrame getOriginalFrame() {
        return originalFrame;
    }

    public void setOriginalFrame(RecognitionFrame originalFrame) {
        this.originalFrame = originalFrame;
    }
}
