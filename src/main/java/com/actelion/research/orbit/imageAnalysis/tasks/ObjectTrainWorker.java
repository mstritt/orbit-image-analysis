/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2016 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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

import com.actelion.research.orbit.imageAnalysis.components.ImageFrame;
import com.actelion.research.orbit.imageAnalysis.features.ObjectFeatureBuilderTiled;
import com.actelion.research.orbit.imageAnalysis.models.ClassifierWrapper;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.imageAnalysis.utils.ScaleoutMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import weka.classifiers.Evaluation;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Trains model for object classification.
 */
public class ObjectTrainWorker extends OrbitWorker {

    private Logger logger = LoggerFactory.getLogger(ObjectTrainWorker.class);
    private ClassifierWrapper classifier = null;
    private Instances trainSet = null;
    private List<ImageFrame> iFrames = null;
    private boolean paused = false;
    private boolean dontRun = false;
    private OrbitModel modelToBuild = null;

    public ObjectTrainWorker(List<ImageFrame> iFrames, OrbitModel modelToBuild) {
        if ((iFrames == null) || (iFrames.size() < 1))
            throw new IllegalArgumentException("Error: iFrames cannot be null and size must be >= 1");
        this.iFrames = iFrames;
        this.modelToBuild = modelToBuild;
    }


    @Override
    protected void doWork() {
        if (dontRun) {
            dontRun = false;
            return;
        }
        trainSet = null;
        if (modelToBuild != null && modelToBuild.getClassifier() != null)
            modelToBuild.getClassifier().setBuild(false);
        List<double[]> trainData = new ArrayList<double[]>();
        int mipLayer = -1; // used for checking if all iFrames (with trainData) have the same mapLayer (otherwise the model cannot be trained)
        for (ImageFrame iFrame : iFrames) {
            int sampleSize = Math.min(3, iFrame.recognitionFrame.bimg.getImage().getSampleModel().getNumBands()); // was always 1 before! (max 3 because alpha should be ignored)
            for (int i = 0; i < iFrame.recognitionFrame.getClassShapes().size(); i++) {
                checkPaused();
                List<Shape> shapes = iFrame.recognitionFrame.getClassShapes().get(i).getShapeList();
                if (shapes != null && shapes.size() > 0) {
                    if (mipLayer < 0) {
                        mipLayer = iFrame.getMipLayer();
                        logger.trace("iFrame candidate mipLayer {} from iFrame with width {}", mipLayer, iFrame.recognitionFrame.bimg.getWidth());
                    } else {
                        if (mipLayer != iFrame.getMipLayer()) {
                            logger.error("Cell classifier cannot be trained on different image layers. Please use only training data of the same image layer.");
                            return;
                        }
                    }
                    if (mipLayer != modelToBuild.getMipLayer()) {
                        // only same layer as segmentation allowed. Otherwise the cell features must be scaled, too (which is not yet the case).
                        logger.error("Cell classifier must be trained on same layer as segmentation");
                        return;
                    }
                }
                trainData.addAll(new ObjectFeatureBuilderTiled(null).buildFeatures(shapes, i + 1, iFrame.recognitionFrame, iFrame.recognitionFrame.getClassImage(), sampleSize, 0, 0)); // classes 1.0, 2.0, ...
            }
        }
        logger.trace("train levelNum: {}", mipLayer);
        if (trainData.size() == 0) {
            logger.error("trainset is empty, classifier cannot be trained.");
            trainSet = null;
            return;
        }
        if (isCancelled()) {
            cleanUp();
            return;
        }
        timeEst = 1000 * 10L;
        setProgress(10);

        logger.debug("trainData contains " + trainData.size() + " samples");

        Attribute classAttr = null;
        // create the first time a new trainSet. All further trainings will append new instances.
        if (trainSet == null) {
            // build traindata header
            double[] firstRowAll = trainData.get(0);
            double[] firstRow = Arrays.copyOfRange(firstRowAll, 0, firstRowAll.length - ObjectFeatureBuilderTiled.SkipTailForClassification);
            ArrayList<Attribute> attrInfo = new ArrayList<Attribute>(firstRow.length);
            for (int a = 0; a < firstRow.length - 1; a++) {
                Attribute attr = new Attribute("a" + a);
                // if (a<firstRow.length-2) attr.setWeight(0.1d); else attr.setWeight(1.0d);
                attrInfo.add(attr);
            }
            List<String> classValues = new ArrayList<String>(iFrames.get(0).recognitionFrame.getClassShapes().size());
            for (int i = 0; i < iFrames.get(0).recognitionFrame.getClassShapes().size(); i++) {
                classValues.add((i + 1) + ".0"); // "1.0", "2.0", ...
            }
            classAttr = new Attribute("class", classValues);
            attrInfo.add(classAttr);

            trainSet = new Instances("trainSet pattern classes", attrInfo, trainData.size());
            trainSet.setClassIndex(firstRow.length - 1);
        } else classAttr = trainSet.attribute("class");

        // add instances
        for (double[] valsAll : trainData) {
            // skip some non relevant attributes like centerX/Y
            double[] vals = Arrays.copyOfRange(valsAll, 0, valsAll.length - ObjectFeatureBuilderTiled.SkipTailForClassification);
            vals[vals.length - 1] = valsAll[valsAll.length - 1]; // class value

            double classV = classAttr.indexOfValue(Double.toString(vals[vals.length - 1]));
            vals[vals.length - 1] = classV;
            Instance inst = new DenseInstance(1.0d, vals);
            trainSet.add(inst);
        }
        // trainSet = trainSet.resample(rand);
        logger.debug("trainSet contains " + trainSet.numInstances() + " instances");

        if (logger.isTraceEnabled()) logger.trace(trainSet.toString());

        // building classifier
        if (isCancelled()) {
            cleanUp();
            return;
        }
        checkPaused();
        timeEst = 1000 * 5L;
        setProgress(20);
        logger.info("Start training classifier... ");
        classifier = new ClassifierWrapper(new weka.classifiers.functions.SMO());
        try {
            classifier.buildClassifier(trainSet);
            classifier.setBuild(true);
            modelToBuild.setClassifier(classifier);
            modelToBuild.setStructure(trainSet.stringFreeStructure());
            modelToBuild.setCellClassification(true);
            modelToBuild.setMipLayer(mipLayer);
            setProgress(85);

            // evaluation
            StringBuilder cnamesInfo = new StringBuilder("Evaluation for object classification model with classes: ");
            for (int i = 0; i < modelToBuild.getClassShapes().size(); i++) {
                cnamesInfo.append(modelToBuild.getClassShapes().get(i).getName());
                if (i < modelToBuild.getClassShapes().size() - 1) cnamesInfo.append(", ");
            }
            logger.info(cnamesInfo.toString());
            Evaluation evaluation = new Evaluation(trainSet);
            evaluation.evaluateModel(classifier.getClassifier(), trainSet);
            logger.info(evaluation.toSummaryString());
            if (evaluation.pctCorrect() < OrbitUtils.ACCURACY_WARNING) {
                String w = "Warning: The model classifies the training objects only with an accuracy of " + evaluation.pctCorrect() + "%.\nThat means that the marked objects are not diverse enough.\nYou might want to remove some marked objects and mark some more representative ones.\nHowever, you can still use this model if you want (check the object classification).";
                logger.warn(w);
                if (withGUI && !ScaleoutMode.SCALEOUTMODE.get()) {
                    JOptionPane.showMessageDialog(null, w, "Warning: Low accuracy", JOptionPane.WARNING_MESSAGE);
                }
            }

        } catch (Exception e) {
            classifier = null;
            logger.error("error training classifier: ", e);
        }
        logger.info("training done.");
        timeEst = 0L;
        setProgress(100);

    }


    private void checkPaused() {
        while (paused) {
            try {
                //this.wait();
                Thread.sleep(200);
            } catch (Exception ex) {
            }
        }
    }

    private void cleanUp() {
        trainSet = null;
        classifier = null;
        setProgress(0);
    }


    public ClassifierWrapper getClassifier() {
        return classifier;
    }


    public Instances getDatastructure() {
        if (trainSet != null)
            return trainSet.stringFreeStructure();
        else return null;
    }

}
