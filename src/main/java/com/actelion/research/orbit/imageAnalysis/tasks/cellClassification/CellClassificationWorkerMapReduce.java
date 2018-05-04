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

package com.actelion.research.orbit.imageAnalysis.tasks.cellClassification;

import com.actelion.research.mapReduceGeneric.IMapReduce;
import com.actelion.research.mapReduceGeneric.executors.IMapReduceExecutor;
import com.actelion.research.mapReduceGeneric.executors.MapReduceExecutorLocalMultiCore;
import com.actelion.research.mapReduceGeneric.utils.KeyValue;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.ClassShape;
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

import java.awt.*;
import java.util.*;
import java.util.List;

public class CellClassificationWorkerMapReduce extends OrbitWorker implements ITaskResultProducer<ClassificationResult> {

    private static final Logger logger = LoggerFactory.getLogger(CellClassificationWorkerMapReduce.class);
    private IMapReduceExecutor<String, Integer, ClassificationResult> executor;
    private List<RawDataFile> rdfList;
    private OrbitModel model;
    private boolean onlyTilesinROI = false;
    private boolean skipNonExplicitROIImages = false;
    private String taskDetail = "";
    private boolean useScaleout = false;
    private Map<Integer, ClassificationResult> classificationResultMap;

    public CellClassificationWorkerMapReduce() {
        // for result producer
    }

    public CellClassificationWorkerMapReduce(OrbitModel model, List<RawDataFile> rdfList, boolean useScaleout) {
        this.useScaleout = useScaleout;
        this.rdfList = rdfList;
        if (model != null) {
            this.model = new OrbitModel(model); // clone model
            this.model.getClassShapesToRestore().clear(); // no needed anymore
        }
        if (useScaleout) {
            this.executor = DALConfig.getScaleOut().createMapReduceExecutor(new CellClassificationMapReduce());
            ProgressUpdateThread updateThread = new ProgressUpdateThread(executor, this);
            updateThread.start();


        } else {
            this.executor = new MapReduceExecutorLocalMultiCore<String, Integer, ClassificationResult>() {
                @Override
                protected void setProgress(double progress) {
                    super.setProgress(progress);
                    CellClassificationWorkerMapReduce.this.setProgress((int) progress);
                }
            };
        }
    }

    @Override
    protected void doWork() throws Exception {
        try {
            taskDetail = " [" + new Date().toString() + "]";
            int tileChunkSize = -1;
            if ((model.getClassifier() != null && model.getClassifier().isBuild()) || (model.getSegmentationModel() != null))
                tileChunkSize = DALConfig.getScaleOut().getParallelism();
            String modelNew = OrbitUtils.generateUniqueFilename("orbit", OrbitUtils.MODEL_ENDING);
            if (useScaleout) {
                try {
                    modelNew = DALConfig.getScaleOut().getRemoteContextStore().generateUniqueFilename("orbit", OrbitUtils.MODEL_ENDING);
                    DALConfig.getScaleOut().getRemoteContextStore().copyToRemote(model.getAsByteArray(), OrbitUtils.remoteNameSpace, modelNew);
                } catch (Exception es) {
                    ImageTile.modelCache.put(modelNew, model);
                    logger.error("cannot write model to remote context store, writing to local cache instead. Reason: ", es);
                }
            } else {
                ImageTile.modelCache.put(modelNew, model); // for local execution we just keep it in memory
            }
            if (!onlyTilesinROI) onlyTilesinROI = !useScaleout;
            logger.debug("onlyTilesInROI: "+onlyTilesinROI+"  skipNonExplicitROIImages: "+skipNonExplicitROIImages);
            List<String> imageTiles;
            IMapReduce mapReduce;
            if (useScaleout) {
                List<Point> tiles = new ArrayList<>();
                tiles.add(new Point(-1,-1));
                imageTiles = new ArrayList<>();
                for (RawDataFile rdf: rdfList) {
                    String experiment = new ImageTile(rdf.getRawDataFileId(), tiles, modelNew).toString();
                    imageTiles.add(experiment);
                }
                mapReduce = new CellClassificationMapReduceFullImage();
                ((CellClassificationMapReduceFullImage)mapReduce).setModel(new OrbitModel(model));
            } else {
                imageTiles = OrbitHelper.EncodeImageTiles(modelNew, model, tileChunkSize, model.getMipLayer(), onlyTilesinROI, skipNonExplicitROIImages, rdfList.toArray(new RawDataFile[0]));
                mapReduce = new CellClassificationMapReduce();
                ((CellClassificationMapReduce) mapReduce).setModel(new OrbitModel(model));
            }
            Map<Integer, ClassificationResult> classificationResultMap = new HashMap<Integer, ClassificationResult>();
            try {
                classificationResultMap = executor.execute(imageTiles, mapReduce);
                this.classificationResultMap = classificationResultMap;
            } catch (Exception e) {
                logger.error("Error executing cell classification task", e);
            }
            taskResult = produceTaskResult(classificationResultMap, true);
        } catch (Exception e) {
            logger.error("Cell Classification error", e);
        }
    }

    public TaskResult produceTaskResult(Map<Integer, ClassificationResult> classificationResultMap, boolean computeROIAreas) throws Exception {
        if (classificationResultMap==null) {  // e.g. results can only be retrieved via 'retrieve existing results' panel
            return new TaskResult("Cell Classification" + taskDetail, "Batch submitted, results can be retrieved via Batch -> Retrieve Existing Results.");
        }
        OrbitModel resModel = null;
        //Map<Integer,List<KeyValue<String,Object>>> map = ResultEnhancer.convertToNamedMeasurement(classificationResult, "Classification");
        Map<Integer, List<KeyValue<String, Object>>> map = new HashMap<Integer, List<KeyValue<String, Object>>>(classificationResultMap.size());
        for (Integer rdfId : classificationResultMap.keySet()) {
            ClassificationResult classificationResult = classificationResultMap.get(rdfId);
            List<KeyValue<String, Object>> kvl = new ArrayList<KeyValue<String, Object>>();
            kvl.addAll(longToObjKV(classificationResult.getRatio(), classificationResult.getModel()));
            map.put(rdfId, kvl);
            if (resModel == null) resModel = classificationResult.getModel();
        }
        map = ResultEnhancer.enhanceResults(map);
        if (computeROIAreas)
            map = ResultEnhancer.enhanceROIArea(resModel, map);
        String res = ResultEnhancer.toString(map);
        logger.info("result:\n" + res);
        return new TaskResult("Cell Classification" + taskDetail, res, resModel);
    }


    private List<KeyValue<String, Object>> longToObjKV(Map<String, Long> classCountMap, OrbitModel model) {
        List<KeyValue<String, Object>> valList = new ArrayList<KeyValue<String, Object>>(classCountMap != null ? classCountMap.keySet().size() : 0);
        if (classCountMap != null) {
            for (ClassShape classShape : model.getClassShapes()) {
                String className = classShape.getName();
                long cnt = 0l;
                if (classCountMap.containsKey(className)) {
                    cnt = classCountMap.get(className);
                }
                valList.add(new KeyValue<String, Object>(className, cnt));
            }
        }
        return valList;
    }

    public IMapReduceExecutor<String, Integer, ClassificationResult> getExecutor() {
        return executor;
    }

    public Map<Integer, ClassificationResult> getClassificationResultMap() {
        return classificationResultMap;
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

    @Override
    public double getProgressD() {
        return executor.getProgress();
    }


}
