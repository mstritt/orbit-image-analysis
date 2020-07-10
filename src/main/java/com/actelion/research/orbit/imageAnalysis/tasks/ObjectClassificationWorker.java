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

import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.features.ObjectFeatureBuilderTiled;
import com.actelion.research.orbit.imageAnalysis.models.ClassShape;
import com.actelion.research.orbit.imageAnalysis.models.ClassifierWrapper;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.models.TaskResult;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Classifies already segmented objects.
 */
public class ObjectClassificationWorker extends OrbitWorker implements PropertyChangeListener {

    private Logger logger = LoggerFactory.getLogger(ObjectClassificationWorker.class);
    private ClassifierWrapper classifier = null;
    private Instances dataset = null;
    private RecognitionFrame rf = null;
    private HashMap<Integer, Integer> classCount = null;
    private List<Point> tileList = null;
    private boolean generateTaskResult = true;
    private OrbitModel model;
    private List<ClassShape> oldClassShapes = null;
    private RecognitionFrame originalFrame = null;


    public ObjectClassificationWorker(final RecognitionFrame rf, final OrbitModel model, final List<ClassShape> classShapesToSet) {
        this(rf, model, classShapesToSet, null);
    }

    /**
     * special constructor with a trainWorker that may not be finished. The constructor will wait until the
     * training is done and then take the (trained) classifier and the datastructure.
     *
     * @param rf
     */
    public ObjectClassificationWorker(final RecognitionFrame rf, final OrbitModel model, final List<ClassShape> classShapesToSet, final List<Point> tileList) {
        this.rf = rf;
        OrbitUtils.setMultiChannelFeatures(rf.bimg.getImage(),model.getFeatureDescription());
        if (classShapesToSet != null) {
            oldClassShapes = SerializationUtils.clone((ArrayList) rf.getClassShapes()); // remember original classShales workaround (dirty fix...). Must be cloned because rf.setClassShapes will clear() and addAll() (next line).
            this.rf.setClassShapes(classShapesToSet);
        }
        this.model = new OrbitModel(model);
        this.classifier = this.model.getClassifier();
        this.dataset = this.model.getStructure();
        this.tileList = tileList;
    }


    @Override
    protected void doWork() {
        try {
            if (rf.getObjectSegmentationList() == null) {
                logger.error("objectSegmentation is null. Please create a objectSegmentationList first.");
                return;
            }

            if (rf.getClassImage() == null) {
                logger.error("classImage is null. Please do a tissue classification first.");
                return;
            }

            if (classifier == null) {
                logger.error("classifier is null, so classification cannot be done.");
                return;
            }

            classCount = new HashMap<Integer, Integer>();
            for (int idx = 0; idx < model.getClassShapes().size(); idx++) {
                classCount.put(idx, 0);
            }


            int[] classificationList = new int[rf.getObjectSegmentationList().size()];
            Instance inst;
            int i = 0;
            Rectangle bounds;
            boolean inTileList = true;
            logger.trace("starting the classification of " + rf.getObjectSegmentationList().size() + " cells");
            //logger.trace("classifier: "+classifier);
            //logger.trace("dataSet: "+dataset);
            List<Rectangle> tileBounds = null;
            if (tileList != null && tileList.size() > 0) {
                tileBounds = new ArrayList<Rectangle>(tileList.size());
                for (Point tile : tileList) {
                    if (tile.x != -1 && tile.y != -1) {   // all tiles marker
                        tileBounds.add(rf.bimg.getImage().getTileRect(tile.x, tile.y));
                    }
                }
            }

            for (Shape shape : rf.getObjectSegmentationList()) {
                if (shape.getBounds().width * shape.getBounds().height < 5) {  // at least 2x2 pixel
                    if (logger.isTraceEnabled())
                        logger.trace("skipping shape: " + shape.getBounds());
                    classificationList[i] = -1;
                    i++;
                    continue;
                }
                int sampleSize = Math.min(3, rf.bimg.getImage().getSampleModel().getNumBands()); // was always 1 before! (max 3 because alpha should be ignored)
                double[] featsAll = new ObjectFeatureBuilderTiled(model).buildFeatures(shape, Double.NaN, rf, rf.getClassImage(), sampleSize, 0, 0);
                double[] feats = Arrays.copyOfRange(featsAll, 0, featsAll.length - ObjectFeatureBuilderTiled.SkipTailForClassification);  // skip some non relevant attributes like centerX/Y
                inst = new DenseInstance(1.0d, feats);
                inst.setDataset(dataset);

                double classVal = Double.NaN;
                try {
                    classVal = classifier.classifyInstance(inst);
                } catch (Exception e) {
                    e.printStackTrace();
                    classificationList[i] = -1;
                    logger.error("The classifier is not a cell classification classifier.");
                    return;
                }
                if (classVal != Double.NaN) {
                    //if (logger.isTraceEnabled()) logger.trace("Obj "+i+": Class "+classVal);
                    classificationList[i] = (int) classVal;
                    if (!classCount.containsKey((int) classVal)) classCount.put((int) classVal, 0);
                    classCount.put((int) classVal, classCount.get((int) classVal) + 1);
                } else {
                    classificationList[i] = -1;
                    logger.trace("Class is null");
                }
                i++;
            }  // shape
            rf.setObjectClassificationList(classificationList); // not save!

            if (originalFrame != null) {
                if (rf.getObjectClassificationList() != null) {
                    this.originalFrame.setObjectClassificationList(rf.getObjectClassificationList().clone());
                }
                this.originalFrame.setClassShapes(oldClassShapes);
                this.originalFrame.setClassImage(rf.getClassImage());
            }

            if (oldClassShapes != null) {
                rf.setClassShapes(oldClassShapes);
                logger.debug("ClassShape Workaround: Old classShapes set.");
            }

            if (generateTaskResult) {
                StringBuilder sb = new StringBuilder("Finished classifying " + i + " objects.\n");
                sb.append("Class Frequencies:\n");
                for (int c = 0; c < rf.getClassShapes().size(); c++) {
                    if (classCount.containsKey(c)) {
                        int cnt = classCount.get(c);
                        String cName = rf.getClassShapes().get(c).getName();
                        sb.append(cName + ": " + cnt + "\n");
                    } else {
                        int cnt = 0;
                        String cName = rf.getClassShapes().get(c).getName();
                        sb.append(cName + ": " + cnt + "\n");
                    }
                }
                taskResult = new TaskResult("Cell Classification Result", sb.toString());
                logger.debug(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void propertyChange(PropertyChangeEvent evt) {

    }

    public HashMap<Integer, Integer> getClassCount() {
        return classCount;
    }

    public boolean isGenerateTaskResult() {
        return generateTaskResult;
    }

    public void setGenerateTaskResult(boolean generateTaskResult) {
        this.generateTaskResult = generateTaskResult;
    }


    public void setOriginalFrame(RecognitionFrame originalFrame) {
        this.originalFrame = originalFrame;
    }

    public RecognitionFrame getOriginalFrame() {
        return originalFrame;
    }
}
