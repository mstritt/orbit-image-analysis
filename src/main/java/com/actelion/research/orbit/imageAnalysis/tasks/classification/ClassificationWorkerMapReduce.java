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

package com.actelion.research.orbit.imageAnalysis.tasks.classification;

import com.actelion.research.mapReduceGeneric.executors.IMapReduceExecutor;
import com.actelion.research.mapReduceGeneric.executors.MapReduceExecutorLocalMultiCore;
import com.actelion.research.mapReduceGeneric.utils.KeyValue;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.ImageTile;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.models.TaskResult;
import com.actelion.research.orbit.imageAnalysis.tasks.ITaskResultProducer;
import com.actelion.research.orbit.imageAnalysis.tasks.OrbitWorker;
import com.actelion.research.orbit.imageAnalysis.tasks.ProgressUpdateThread;
import com.actelion.research.orbit.imageAnalysis.utils.ClassificationResult;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitHelper;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.imageAnalysis.utils.ResultEnhancer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class ClassificationWorkerMapReduce extends OrbitWorker implements ITaskResultProducer<ClassificationResult> {


    private static final Logger logger = LoggerFactory.getLogger(ClassificationWorkerMapReduce.class);
    private IMapReduceExecutor<String, Integer, ClassificationResult> executor;
    private List<RawDataFile> rdfList;
    private OrbitModel model;
    private String taskDetail = "";
    private boolean onlyTilesinROI = false;
    private boolean skipNonExplicitROIImages = false;
    private boolean useScaleout = false;

    public ClassificationWorkerMapReduce() {
        // for result producer
    }

    public ClassificationWorkerMapReduce(OrbitModel model, List<RawDataFile> rdfList, boolean useScaleout) {
        this.useScaleout = useScaleout;
        this.rdfList = rdfList;
        if (model != null) {
            this.model = new OrbitModel(model); // clone model
            this.model.getClassShapesToRestore().clear(); // no needed anymore
        }
        if (useScaleout) {
            executor = DALConfig.getScaleOut().createMapReduceExecutor(new ClassificationMapReduce());
            ProgressUpdateThread updateThread = new ProgressUpdateThread(executor, this);
            updateThread.start();

        } else {
            executor = new MapReduceExecutorLocalMultiCore<String, Integer, ClassificationResult>() {
                @Override
                protected void setProgress(double progress) {
                    super.setProgress(progress);
                    ClassificationWorkerMapReduce.this.setProgress((int) progress);
                }
            };
        }
    }

    @Override
    protected void doWork() throws Exception {
        try {
            taskDetail = " [" + new Date().toString() + "]";
            int tileChunkSize = -1;
            if ((model.getClassifier() != null && model.getClassifier().isBuild()))
                tileChunkSize = DALConfig.getScaleOut().getParallelism();   // 150
            String modelNew = DALConfig.getScaleOut().getRemoteContextStore().generateUniqueFilename("orbit", OrbitUtils.MODEL_ENDING);
            if (useScaleout) {
                DALConfig.getScaleOut().getRemoteContextStore().copyToRemote(model.getAsByteArray(), OrbitUtils.remoteNameSpace, modelNew);
            } else {
                ImageTile.modelCache.put(modelNew, model); // for local execution we just keep it in memory
            }
            List<String> imageTiles = OrbitHelper.EncodeImageTiles(modelNew, model, tileChunkSize, model.getMipLayer(), onlyTilesinROI, skipNonExplicitROIImages, rdfList.toArray(new RawDataFile[0]));
            logger.debug("#tile jobs: "+imageTiles.size());
            ClassificationMapReduce mrClassification = new ClassificationMapReduce();
            mrClassification.setModel(new OrbitModel(model));
            Map<Integer, ClassificationResult> classificationResultMap = null;
            try {
                classificationResultMap = executor.execute(imageTiles, mrClassification);
            } catch (Exception e) {
                logger.error("Error executing classification task: ", e);
            }
            taskResult = produceTaskResult(classificationResultMap, true);
        } catch (Exception e) {
            logger.error("Classification interrupted", e);
        }
    }

    @Override
    public TaskResult produceTaskResult(Map<Integer, ClassificationResult> classificationResultMap, boolean computeROIAreas) throws Exception {
        Map<Integer, List<KeyValue<String, Object>>> map = new HashMap<Integer, List<KeyValue<String, Object>>>(classificationResultMap.size());
        OrbitModel resModel = null;
        for (Integer rdfId : classificationResultMap.keySet()) {
            ClassificationResult classificationResult = classificationResultMap.get(rdfId);
            List<KeyValue<String, Object>> kvl = new ArrayList<KeyValue<String, Object>>();
            kvl.addAll(dblToObjKV(classificationResult.normalizeRatio()));
            kvl.addAll(dblToObjKV(classificationResult.normalizeRatioExclusion()));
            map.put(rdfId, kvl);
            if (resModel == null) resModel = classificationResult.getModel();
        }
        map = ResultEnhancer.enhanceResults(map);
        if (computeROIAreas)
            map = ResultEnhancer.enhanceROIArea(resModel, map);
        String res = ResultEnhancer.toString(map);
        //logger.info("result:\n" + res);
        return new TaskResult("Classification" + taskDetail, res);
    }

    private List<KeyValue<String, Object>> dblToObjKV(List<KeyValue<String, Double>> dblList) {
        List<KeyValue<String, Object>> valList = new ArrayList<KeyValue<String, Object>>(dblList != null ? dblList.size() : 0);
        if (dblList != null) {
            for (KeyValue<String, Double> kv : dblList) {
                valList.add(new KeyValue<String, Object>(kv.getKey(), kv.getValue()));
            }
        }
        return valList;
    }

    @Override
    public double getProgressD() {
        return executor.getProgress();
    }


    public boolean isOnlyTilesinROI() {
        return onlyTilesinROI;
    }

    public void setOnlyTilesinROI(boolean onlyTilesinROI) {
        this.onlyTilesinROI = onlyTilesinROI;
    }

    public boolean isSkipNonExplicitROIImages() {
        return skipNonExplicitROIImages;
    }

    public void setSkipNonExplicitROIImages(boolean skipNonExplicitROIImages) {
        this.skipNonExplicitROIImages = skipNonExplicitROIImages;
    }

    public IMapReduceExecutor<String, Integer, ClassificationResult> getExecutor() {
        return executor;
    }
}
