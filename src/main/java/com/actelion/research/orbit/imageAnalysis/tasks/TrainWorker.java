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

import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.components.ImageFrame;
import com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis;
import com.actelion.research.orbit.imageAnalysis.features.TissueFeatures;
import com.actelion.research.orbit.imageAnalysis.models.ClassifierWrapper;
import com.actelion.research.orbit.imageAnalysis.models.FeatureDescription;
import com.actelion.research.orbit.imageAnalysis.models.IScaleableShape;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.imageAnalysis.utils.ScaleoutMode;
import com.actelion.research.orbit.imageAnalysis.utils.TiledImagePainter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.clusterers.Clusterer;
import weka.clusterers.DensityBasedClusterer;
import weka.clusterers.EM;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

import javax.media.jai.PlanarImage;
import javax.swing.*;
import java.awt.*;
import java.awt.image.Raster;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Trains a model for tissue classificaiton or clustering.
 */
public class TrainWorker extends OrbitWorker {

    public static final int MAXINST = 40000;   // max training instances (pixels)
    public static int MAX_CLUSTERING_EXAMPLES = 10000;
    private Logger logger = LoggerFactory.getLogger(TrainWorker.class);
    private ClassifierWrapper classifier = null;
    private Instances trainSet = null;
    private List<ImageFrame> iFrames = null;
    private Random rand = new Random();
    private boolean paused = false;
    private boolean dontRun = false;
    private boolean performClustering = false;
    private OrbitModel segmentationModel = null;
    private OrbitModel modelToBuild = null;


    /**
     * Trains a classifier based on the features of the classShapes of the iFrames. The classifier and structure in
     * modelToBuild will be set.
     *
     * @param iFrames
     * @param firstRun
     * @param modelToBuild cannot be null!
     */
    public TrainWorker(List<ImageFrame> iFrames, boolean firstRun, boolean performClustering, OrbitModel modelToBuild) {
        if ((iFrames == null) || (iFrames.size() < 1)) {
            logger.error("Error: iFrames cannot be null and size must be >= 1");
            throw new IllegalArgumentException("Error: iFrames cannot be null and size must be >= 1");
        }
        if (modelToBuild == null) {
            logger.error("model cannot be null");
            throw new IllegalArgumentException("model cannot be null");
        }
        this.iFrames = iFrames;
        this.performClustering = performClustering;
        this.modelToBuild = modelToBuild;
    }

    /**
     * Only set classifier and trainSet. No training will be done in the doWork() method.
     */
    public TrainWorker(OrbitModel model) {
        this.classifier = model.getClassifier();
        this.trainSet = model.getStructure();
        if (classifier != null && trainSet != null) {
            dontRun = true; // perform a dummy run to set the state to done
            this.run();
        }
    }

    @Override
    protected void doWork() throws OrbitImageServletException {
        if (dontRun) {
            dontRun = false;
            return;
        }

        if (performClustering) {
            createClusterer();
        } else {
            trainClassifier();
        }


        logger.info("training done.");
        //logger.trace("Trained Classifier: "+modelToBuild.getClassifier());
        timeEst = 0L;
        setProgress(100);
    }


    private void trainClassifier() throws OrbitImageServletException {
        logger.debug("start trainClassifier");
        if (modelToBuild != null && modelToBuild.getClassifier() != null)
            modelToBuild.getClassifier().setBuild(false);
        trainSet = null;
        List<double[]> trainData = new ArrayList<double[]>();
        int mipLayer = -1; // used for checking if all iFrames (with trainData) have the same mapLayer (otherwise the model cannot be trained)
        for (ImageFrame iFrame : iFrames) {
            if (logger.isTraceEnabled())
                logger.trace(iFrame.getTitle() + ": #ClassShapes: " + iFrame.recognitionFrame.getClassShapes().size());
            for (int i = 0; i < iFrame.recognitionFrame.getClassShapes().size(); i++) {
                //  checkPaused();
                if (iFrame.recognitionFrame.getClassShapes().get(i).getShapeList().size() > 0) {  // set and check mip level only for iFrames with shapes (training data)
                    if (mipLayer < 0) {
                        mipLayer = iFrame.getMipLayer();
                        logger.trace("iFrame candidate mipLayer {} from iFrame with width {}", mipLayer, iFrame.recognitionFrame.bimg.getWidth());
                    } else {
                        if (mipLayer != iFrame.getMipLayer()) {
                            logger.error("Model cannot be trained on different image layers. Please use only training data of the same image layer.");
                            return;
                        }
                    }
                }
                List<Shape> shapes = iFrame.recognitionFrame.getClassShapes().get(i).getShapeList();
                trainData.addAll(getFeatures(shapes, i + 1, iFrame.recognitionFrame.bimg)); // classes 1.0, 2.0, ...
            }
        }
        logger.trace("train levelNum: {}", mipLayer);

        if (trainData.size() == 0) {
            logger.error("trainset is empty, classifier cannot be trained.");
            trainSet = null;
            return;
        }
        if (isCancelled()) {
            logger.debug("canceled");
            cleanUp();
            return;
        }
        timeEst = 1000 * 10L;
        setProgress(10);

        logger.debug("trainData contains " + trainData.size() + " samples");


        // limit training instances
        if (trainData.size() > MAXINST) {
            Collections.shuffle(trainData, rand);
            trainData = trainData.subList(0, MAXINST);
            logger.debug("trainSet shirked to " + trainData.size() + " instances");
        }


        Attribute classAttr = null;
        // create the first time a new trainSet. All further trainings will append new instances.
        if (trainSet == null) {
            // build traindata header
            double[] firstRow = trainData.get(0);
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
        for (double[] vals : trainData) {
            double classV = classAttr.indexOfValue(Double.toString(vals[vals.length - 1]));
            vals[vals.length - 1] = classV;
            //Instance inst = new Instance(1.0d, vals);
            Instance inst = new DenseInstance(1.0d, vals);
            trainSet.add(inst);
        }
        trainSet = trainSet.resample(rand);
        logger.debug("trainSet contains " + trainSet.numInstances() + " instances");


        // building classifier
        if (isCancelled()) {
            cleanUp();
            return;
        }
        checkPaused();
        timeEst = 1000 * 5L;
        setProgress(20);
        logger.info("Start training classifier... ");
        Classifier c;
            /*
            // experiments with deep learning... do not use in production.
		  if (AparUtils.DEEPORBIT) {
			  FeatureDescription fd = modelToBuild!=null? modelToBuild.getFeatureDescription(): new FeatureDescription();
			  TissueFeatures tissueFeaturre = AparUtils.createTissueFeatures(fd, null);
			  int numOutNeurons = modelToBuild.getClassShapes().size();
			  int numInNeurons = tissueFeaturre.prepareDoubleArray().length-1;
			  logger.debug("numNeuronsIn:"+numInNeurons+"  numNeuronsOut:"+numOutNeurons);
			  MultiLayerPerceptron neuralNet = new MultiLayerPerceptron(numInNeurons,100, numOutNeurons);
			  for (int a=0; a<numOutNeurons; a++) {
				  neuralNet.getOutputNeurons()[a].setLabel("class"+a);
			  }
			  neuralNet.connectInputsToOutputs();

			  MomentumBackpropagation mb = new MomentumBackpropagation();
			  mb.setLearningRate(0.2d);
			  mb.setMomentum(0.7d);
			  //mb.setMaxIterations(20);
			  mb.setMaxError(0.12);
			  neuralNet.setLearningRule(mb);
			  c = new WekaNeurophClassifier(neuralNet);

		  } else {
			  c = new weka.classifiers.functions.SMO();
		  }
            */
        c = new weka.classifiers.functions.SMO();

        //weka.classifiers.functions.LibSVM c = new weka.classifiers.functions.LibSVM();
        //Classifier c = new weka.classifiers.trees.J48();
        classifier = new ClassifierWrapper(c);
        //classifier = new weka.classifiers.bayes.BayesNet();
        //classifier = new weka.classifiers.functions.MultilayerPerceptron();
        //((weka.classifiers.functions.SMO)classifier).setKernel(new weka.classifiers.functions.supportVector.RBFKernel());
        try {

            classifier.buildClassifier(trainSet);
            classifier.setBuild(true);
            modelToBuild.setClassifier(classifier);
            modelToBuild.setStructure(trainSet.stringFreeStructure());
            modelToBuild.setCellClassification(false);
            modelToBuild.setMipLayer(mipLayer);
            modelToBuild.getFeatureDescription().setHueMap(OrbitUtils.getMergedHueMap());
            logger.debug("training done");

            // evaluation
            StringBuilder cnamesInfo = new StringBuilder("Evaluation for model with classes: ");
            for (int i = 0; i < modelToBuild.getClassShapes().size(); i++) {
                cnamesInfo.append(modelToBuild.getClassShapes().get(i).getName());
                if (i < modelToBuild.getClassShapes().size() - 1) cnamesInfo.append(", ");
            }
            logger.info(cnamesInfo.toString());
            Evaluation evaluation = new Evaluation(trainSet);
            evaluation.evaluateModel(classifier.getClassifier(), trainSet);
            logger.info(evaluation.toSummaryString());
            if (evaluation.pctCorrect() < OrbitUtils.ACCURACY_WARNING) {
                final String w = "Warning: The model classifies the training shapes only with an accuracy of " + evaluation.pctCorrect() + "%.\nThat means that the drawn class shapes are not diverse enough.\nYou might want to remove some class shapes and mark some more representative regions.\nHowever, you can still use this model if you want (check the classification).";
                logger.warn(w);
                if (withGUI && !ScaleoutMode.SCALEOUTMODE.get()) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            JOptionPane.showMessageDialog(null, w, "Warning: Low accuracy", JOptionPane.WARNING_MESSAGE);
                        }
                    });
                }
            }

        } catch (Exception e) {
            classifier = null;
            logger.error("error training classifier", e);
        }
        //	logger.trace(classifier.toString());

    }


    /**
     * returns features given the shapeList and the classValue. The last value in the double array is
     * always the class value (e.g. return[return.length-1] == classValue).<br>
     * This version of getFeatures includes the maxDist feature parameter.
     *
     * @param shapeList
     * @param classValue
     * @return
     * @throws OrbitImageServletException
     */
    private List<double[]> getFeatures(List<Shape> shapeList, double classValue, TiledImagePainter bimg) throws OrbitImageServletException {
        TissueFeatures tissueFeatures = OrbitUtils.createTissueFeatures(OrbitImageAnalysis.getInstance().getModel().getFeatureDescription(), bimg);
        int windowSize = OrbitImageAnalysis.getInstance().getModel().getFeatureDescription().getWindowSize();
        FeatureDescription featureDescription = OrbitImageAnalysis.getInstance().getModel().getFeatureDescription();
        List<double[]> featList = new ArrayList<double[]>();
        if (shapeList == null || shapeList.size() == 0) return featList;

        for (Shape p : shapeList) {
            Raster readRaster = null;
            Shape sp = ((IScaleableShape) p).getScaledInstance(100d, new Point(0, 0));
            Rectangle bb = sp.getBounds();
            if (bb.getWidth() * bb.getHeight() < 1024L * 1024 * 20) {
                // max 20*3=60MB memory per virtual tile, otherwise we read pixelwise and hope for good real tile caching
                readRaster = bimg.getData(new Rectangle(bb.x - windowSize, bb.y - windowSize, bb.width + (windowSize * 2 + 1), bb.height + (windowSize * 2 + 1)), featureDescription);
                readRaster = OrbitUtils.getModifiedRaster(readRaster, featureDescription, bimg.getImage().getColorModel(), bimg.getImage().getLevel() );
            }
            for (int x = bb.x; x < bb.x + bb.width; x++)
                for (int y = bb.y; y < bb.y + bb.height; y++) {
                    if (sp.contains(x, y) && (x >= windowSize) && (y >= windowSize)
                            && (x < bimg.getWidth() - windowSize - 1) && (y < bimg.getHeight() - windowSize - 1))  // bound checking!
                    {
                        double[] feats = tissueFeatures.buildFeatures(readRaster, x, y, classValue);
                        featList.add(feats);

                    } // contains
                } // xy
        } // shape

        return featList;
    }


    private void createClusterer() {
        int MAX_TILES_CLUSTERING = 50;
        if (iFrames == null || iFrames.size() < 1) {
            logger.error("cannot build clusterer, no open image frames.");
            return;
        }
        if (modelToBuild != null && modelToBuild.getClassifier() != null)
            modelToBuild.getClassifier().setBuild(false);

        int windowSize = modelToBuild.getFeatureDescription().getWindowSize();

        List<double[]> trainData = new ArrayList<double[]>();

        for (ImageFrame iFrame : iFrames) {
            PlanarImage image = iFrame.recognitionFrame.bimg.getImage();
            TissueFeatures tissueFeatures = new TissueFeatures(modelToBuild.getFeatureDescription(), iFrame.recognitionFrame.bimg);
            Point[] tileArr = image.getTileIndices(null);
            if (tileArr.length > MAX_TILES_CLUSTERING) {
                logger.trace("number of tiles for clustering: " + tileArr.length);
                List<Point> pList = new ArrayList<Point>(tileArr.length);
                for (Point p : tileArr) pList.add(p);
                Collections.shuffle(pList);
                pList = pList.subList(0, MAX_TILES_CLUSTERING);
                tileArr = pList.toArray(new Point[0]);
                logger.trace("number of tiles after tile limit: " + tileArr.length);
            }


            for (Point tileNum : tileArr) {
                Raster r = image.getTile(tileNum.x, tileNum.y);
                for (int x = image.tileXToX(tileNum.x); x < Math.min(image.tileXToX(tileNum.x) + image.getTileWidth(), image.getWidth()); x++) {
                    for (int y = image.tileYToY(tileNum.y); y < Math.min(image.tileYToY(tileNum.y) + image.getTileHeight(), image.getHeight()); y++) {
                        if ((x < r.getMinX() + windowSize) || (y < r.getMinY() + windowSize) || (x > r.getMinX() + r.getWidth() - windowSize - 1) || (y > r.getMinY() + r.getHeight() - windowSize - 1))
                            continue;

                        double[] feats = null;
                        try {
                            feats = tissueFeatures.buildFeatures(r, x, y, Double.NaN);
                        } catch (Throwable t) {
                            System.out.println(t.getMessage());
                            t.printStackTrace();
                        }
                        trainData.add(feats);

                    } // y
                    checkPaused();
                    if (isCancelled()) {
                        cleanUp();
                        return;
                    }
                } // x

            } // tileNum
        } // iFrames


        timeEst = 1000 * 60L;
        setProgress(20);


        // trainData -> instances
        checkPaused();
        if (isCancelled()) {
            cleanUp();
            return;
        }
        trainSet = null;
        Attribute classAttr = null;
        // create the first time a new trainSet. All further trainings will append new instances.
        if (trainSet == null) {
            // build traindata header
            double[] firstRow = trainData.get(0);
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

        timeEst = 1000 * 45L;
        setProgress(25);

        // add instances
        checkPaused();
        if (isCancelled()) {
            cleanUp();
            return;
        }
        for (double[] vals : trainData) {
            double classV = Double.NaN;
            vals[vals.length - 1] = classV;
            Instance inst = new DenseInstance(1.0d, vals);
            trainSet.add(inst);
        }
        trainSet = trainSet.resample(rand);
        trainSet.setClassIndex(-1);
        Instances ts = new Instances(trainSet, 0);
        ts.addAll(trainSet.subList(0, Math.min(MAX_CLUSTERING_EXAMPLES, trainSet.size() - 1)));
        trainSet = null;
        trainSet = ts;
        logger.debug("trainSet contains " + trainSet.numInstances() + " instances, class Attribute: " + trainSet.classIndex());
        logger.info("start building clusterer...");

        timeEst = 1000 * 40L;
        setProgress(30);

        // build clusterer
        checkPaused();
        if (isCancelled()) {
            cleanUp();
            return;
        }
        // Clusterer clusterer = new weka.clusterers.SimpleKMeans();
        //Clusterer clusterer = new MakeDensityBasedClusterer(new SimpleKMeans());
        Clusterer clusterer = new EM();
        try {
            //((weka.clusterers.SimpleKMeans)clusterer).setNumClusters(iFrames.get(0).recognitionFrame.getClassShapes().size());
            // ((MakeDensityBasedClusterer)clusterer).setNumClusters(iFrames.get(0).recognitionFrame.getClassShapes().size());
            ((EM) clusterer).setNumClusters(iFrames.get(0).recognitionFrame.getClassShapes().size());
            clusterer.buildClusterer(trainSet);
        } catch (Exception e) {
            logger.error("cannot build clusterer or cannot set number of clusters (classShapes not correctly initialized?)");
            e.printStackTrace();
        }
        logger.info("done. (clusterer is densityBasedClusterer: " + (clusterer instanceof DensityBasedClusterer) + ")");

        // sort class labels according to priors


        classifier = new ClassifierWrapper(clusterer);
        classifier.setBuild(true);
        this.trainSet = trainSet.stringFreeStructure();
        modelToBuild.setClassifier(classifier);
        modelToBuild.setStructure(trainSet.stringFreeStructure());
    }


    private void checkPaused() {
        while (paused) {
            try {
                Thread.sleep(100);
            } catch (Exception ex) {
            }
        }
    }

    private void cleanUp() {
        trainSet = null;
        classifier = null;
        setProgress(0);
    }


    /**
     * pauses the task. Use resume to continue.
     */
    public void pause() {
        paused = true;
    }

    /**
     * resumes the task.
     */
    public void resume() {
        paused = false;
    }


    public ClassifierWrapper getClassifier() {
        return classifier;
    }


    public Instances getDatastructure() {
        if (trainSet != null)
            return trainSet.stringFreeStructure();
        else return null;
    }

    public OrbitModel getSegmentationModel() {
        return segmentationModel;
    }

    public void setSegmentationModel(OrbitModel segmentationModel) {
        this.segmentationModel = segmentationModel;
    }


}
