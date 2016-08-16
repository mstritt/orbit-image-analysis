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

package com.actelion.research.orbit.imageAnalysis.tasks.segmentation;

import com.actelion.research.mapReduceGeneric.executors.IMapReduceExecutor;
import com.actelion.research.mapReduceGeneric.executors.MapReduceExecutorLocalMultiCore;
import com.actelion.research.mapReduceGeneric.utils.KeyValue;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.ImageTile;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.models.SegmentationResult;
import com.actelion.research.orbit.imageAnalysis.models.TaskResult;
import com.actelion.research.orbit.imageAnalysis.tasks.ITaskResultProducer;
import com.actelion.research.orbit.imageAnalysis.tasks.OrbitWorker;
import com.actelion.research.orbit.imageAnalysis.tasks.ProgressUpdateThread;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitHelper;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.imageAnalysis.utils.ResultEnhancer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class SegmentationWorkerMapReduce extends OrbitWorker implements ITaskResultProducer<SegmentationResult> {

    private static final Logger logger = LoggerFactory.getLogger(SegmentationWorkerMapReduce.class);
    private IMapReduceExecutor<String, Integer, SegmentationResult> executor;


    private List<RawDataFile> rdfList;
    private OrbitModel model;
    private String taskDetail = "";
    private boolean useScaleout = false;

    public SegmentationWorkerMapReduce() {
        // for result producer
    }

    public SegmentationWorkerMapReduce(final OrbitModel model, final List<RawDataFile> rdfList, boolean useScaleout) {
        this.useScaleout = useScaleout;
        this.rdfList = rdfList;
        if (model != null) {
            this.model = new OrbitModel(model); // clone model
            this.model.getClassShapesToRestore().clear(); // no needed anymore
        }
        if (useScaleout) {
            executor = DALConfig.getScaleOut().createMapReduceExecutor(new SegmentationMapReduce());
            ProgressUpdateThread updateThread = new ProgressUpdateThread(executor, this);
            updateThread.start();
        } else {
            executor = new MapReduceExecutorLocalMultiCore<String, Integer, SegmentationResult>() {
                @Override
                protected void setProgress(double progress) {
                    super.setProgress(progress);
                    SegmentationWorkerMapReduce.this.setProgress((int) progress);
                }
            };
        }
    }

    @Override
    protected void doWork() throws Exception {
        taskDetail = " [" + new Date().toString() + "]";
        //ELB0226-0143-OD130043-M2843-CD4 CD3 -.tif = 9536;
        String modelNew = DALConfig.getScaleOut().getRemoteContextStore().generateUniqueFilename("orbit", OrbitUtils.MODEL_ENDING);
        if (useScaleout) {
            DALConfig.getScaleOut().getRemoteContextStore().copyToRemote(model.getAsByteArray(), OrbitUtils.remoteNameSpace, modelNew);
        } else {
            ImageTile.modelCache.put(modelNew, model); // for local execution we just keep it in memory
        }
        int chunkSize = -1;
        if ((model.getClassifier() != null && model.getClassifier().isBuild()))
            chunkSize = DALConfig.getScaleOut().getParallelism();
        List<String> imageTiles = OrbitHelper.EncodeImageTiles(modelNew, chunkSize, model.getMipLayer(), rdfList);
        SegmentationMapReduce mrCellCount = new SegmentationMapReduce();
        mrCellCount.setModel(new OrbitModel(model));
        Map<Integer, SegmentationResult> counts = null;
        try {
            counts = executor.execute(imageTiles, mrCellCount);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Segmentation error", e);
        }
        taskResult = produceTaskResult(counts, true);
    }

    public TaskResult produceTaskResult(Map<Integer, SegmentationResult> counts, boolean computeROIAreas) throws Exception {
        OrbitModel localModel = null;
        if (counts != null && counts.values() != null && counts.values().size() > 0) {
            localModel = counts.values().iterator().next().getModel();
        }
        //Map<Integer,List<KeyValue<String,Object>>> map = ResultEnhancer.convertToNamedMeasurement(counts, "Segmentation");

        Map<Integer, List<KeyValue<String, Object>>> map = new HashMap<Integer, List<KeyValue<String, Object>>>(counts.size());
        for (Integer rdfId : counts.keySet()) {
            SegmentationResult segRes = counts.get(rdfId);
            List<KeyValue<String, Object>> vals = new ArrayList<KeyValue<String, Object>>(2);
            vals.add(new KeyValue<String, Object>("Primary Object Count", segRes.getObjectCount()));
            vals.add(new KeyValue<String, Object>("Secondary Object Count", segRes.getSecondaryObjectCount())); // TODO: only if secondary model available
            map.put(rdfId, vals);
        }

        map = ResultEnhancer.enhanceResults(map);
        if (computeROIAreas)
            map = ResultEnhancer.enhanceROIArea(localModel, map);
        String res = ResultEnhancer.toString(map);
        logger.info("result:\n" + res);
        return new TaskResult("Cell Counts" + taskDetail, res);
    }

    @Override
    public double getProgressD() {
        return executor.getProgress();
    }


}
