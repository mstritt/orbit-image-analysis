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
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AnnotationClassificationTask extends OrbitWorker implements PropertyChangeListener {

    private final static Logger logger = LoggerFactory.getLogger(AnnotationClassificationTask.class);
    private RecognitionFrame rf = null;
    private OrbitModel model = null;
    private List<ImageAnnotation> annotations = null;
    private double pixelFuzzyness = 0;
    private double tileFuzzyness = 0;
    private boolean withGui = true;
    private int numWorker = 0;
    private AtomicInteger iWorker = new AtomicInteger(0);
    private RawDataFile rdf = null;

    public AnnotationClassificationTask(RawDataFile rdf, RecognitionFrame rf, OrbitModel model, List<ImageAnnotation> annotations) {
        this.annotations = annotations;
        this.rf = rf;
        this.model = model;
        this.annotations = annotations;
        this.rdf = rdf;
    }

    @Override
    protected void doWork() throws Exception {

        if ((model.getClassifier() == null) || (!(model.getClassifier().isBuild()))) {
            logger.error("Model not trained.\nPlease mark some class regions and click on train first.");
            return;
        }

        String sep = "\t";
        StringBuilder sb = new StringBuilder("Spotname"+sep);
        numWorker = annotations.size();
        iWorker.set(0);
        // header
        for (int i = 0; i < rf.getRatio().length; i++) {
            sb.append(model.getClassShapes().get(i).getName());
            if (i < rf.getRatio().length - 1) sb.append(sep);
        }
        sb.append("\n");
        // data
        for (ImageAnnotation anno : annotations) {
            iWorker.addAndGet(1);
            if (anno.getShape().getShapeList().size() > 0) {
                IScaleableShape poly = (IScaleableShape) anno.getShape().getShapeList().get(0);
                if ((!(poly instanceof PolygonExt)) || (((PolygonExt) poly).npoints > 1)) {

                    ExclusionMapGen exMap = ExclusionMapGen.constructExclusionMap(rdf, rf, model);
                    ClassificationWorker worker = new ClassificationWorker(rdf, rf, model, true, exMap, null);
                    worker.setRoi(poly.getScaledInstance(100d, new Point(0, 0)));
                    worker.setPixelFuzzyness(pixelFuzzyness);
                    worker.setTileFuzzyness(tileFuzzyness);
                    worker.setWithGUI(false);
                    worker.addPropertyChangeListener(this);
                    worker.run();
                    OrbitUtils.waitForWorker(worker); // TODO: use execution scheduler
                    sb.append(createResultStr(anno, rf, sep) + "\n");
                }
            }
            int prog = (int) (((double) iWorker.get() / annotations.size()) * 100d);
            logger.trace("progress: " + prog);
            setProgress(prog);
        }

        if (withGui) {
            taskResult = new TaskResult("Annotation Classification Result", sb.toString());
        }
        logger.debug("task finished with result:\n" + taskResult);

    }


    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("progress") && (evt.getSource() instanceof ClassificationWorker)) {
            int progress = (Integer) evt.getNewValue();
            // TODO: set fine grained progress
        }

    }


    private String createResultStr(ImageAnnotation anno, RecognitionFrame rf, String separator) {
        StringBuilder sb = new StringBuilder(anno.getDescription()+separator);
        for (int i = 0; i < rf.getRatio().length; i++) {
            double r = rf.getRatio()[i];
            sb.append(String.format("%1$.6f", r));
            if (i < rf.getRatio().length - 1) sb.append(separator);
        }
        return sb.toString();
    }

}
