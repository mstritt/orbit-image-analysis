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
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.features.ObjectFeatureBuilderTiled;
import com.actelion.research.orbit.imageAnalysis.models.IScaleableShape;
import com.actelion.research.orbit.imageAnalysis.models.ImageAnnotation;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.models.TaskResult;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AnnotationFeaturesTask extends OrbitWorker implements PropertyChangeListener {

    private final static Logger logger = LoggerFactory.getLogger(AnnotationFeaturesTask.class);
    private RecognitionFrame rf = null;
    private OrbitModel model = null;
    private List<ImageAnnotation> annotations = null;
    private double pixelFuzzyness = 0;
    private double tileFuzzyness = 0;
    private boolean withGui = true;
    private AtomicInteger iWorker = new AtomicInteger(0);
    private final String sep = "\t";
    private RawDataFile rdf = null;

    public AnnotationFeaturesTask(RawDataFile rdf, RecognitionFrame rf, OrbitModel model, List<ImageAnnotation> annotations) {
        this.rdf = rdf;
        this.rf = rf;
        this.model = model;
        this.annotations = annotations;
    }

    @Override
    protected void doWork() throws Exception {

//		if ((model.getClassifier()==null) || (!(model.getClassifier().isBuild()))) {
//			 logger.error("Model not trained.\nPlease mark some class regions and click on train first.");
//			  return;
//		 } 
//		if (model.getFeatureDescription().getFeatureClasses()==null || model.getFeatureDescription().getFeatureClasses().length==0) {
//			logger.error("Please select one or several features classes first (F3 -> set classes for features).");
//			return;
//		}

        final ObjectFeatureBuilderTiled cfb = new ObjectFeatureBuilderTiled(model);
        StringBuilder sb = new StringBuilder();
        sb.append("ImageName" + sep);
        sb.append("AnnotationName" + sep);
        String[] featureNames = cfb.getFeatureNames(3);
        for (int i = 0; i < featureNames.length; i++) {
            sb.append(featureNames[i]);
            if (i < featureNames.length - 1) sb.append(sep);
        }
        sb.append("\n");
        iWorker.set(0);
        for (ImageAnnotation anno : annotations) {
            iWorker.addAndGet(1);
            if (anno.getShape().getShapeList().size() > 0) {
                Shape shape = ((IScaleableShape) anno.getShape().getShapeList().get(0)).getScaledInstance(100, new Point(0, 0));
                // classification
                if (model != null && model.getClassifier() != null && model.getClassifier().isBuild()) {
                    ExclusionMapGen exMap = ExclusionMapGen.constructExclusionMap(rdf, rf, model);
                    ClassificationWorker worker = new ClassificationWorker(rf, model, true, exMap, null);
                    worker.setRoi(shape);
                    worker.setPixelFuzzyness(pixelFuzzyness);
                    worker.setTileFuzzyness(tileFuzzyness);
                    worker.setWithGUI(false);
                    worker.addPropertyChangeListener(this);
                    worker.run();
                    OrbitUtils.waitForWorker(worker); // TODO: use execution scheduler
                }

                // features
                rf.initializeClassColors();
                if (model != null && model.getFeatureDescription().getFeatureClasses() != null && model.getFeatureDescription().getFeatureClasses().length > 0) {
                    cfb.setClasses(model.getFeatureDescription().getFeatureClasses());
                }
                double[] features = cfb.buildFeatures(shape, Double.NaN, rf, rf.getClassImage(), 3, 0, 0);
                sb.append("\"" + rf.getPicName() + "\"" + sep);
                sb.append("\"" + anno.getDescription().trim() + "\"" + sep);
                sb.append(cfb.getResultString(features, false, sep));
                sb.append("\n");
            }
            int prog = (int) (((double) iWorker.get() / annotations.size()) * 100d);
            logger.trace("progress: " + prog);
            setProgress(prog);
        }

        if (withGui) {
            taskResult = new TaskResult("Annotation Features Result", sb.toString());
        }
        logger.debug("task finished with result:\n" + taskResult);

    }

    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("progress") && (evt.getSource() instanceof ClassificationWorker)) {
            int progress = (Integer) evt.getNewValue();
            // TODO: set fine grained progress
        }

    }

}
