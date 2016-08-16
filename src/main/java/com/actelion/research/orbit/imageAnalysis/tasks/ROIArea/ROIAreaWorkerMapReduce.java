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

package com.actelion.research.orbit.imageAnalysis.tasks.ROIArea;

import com.actelion.research.mapReduceGeneric.executors.IMapReduceExecutor;
import com.actelion.research.mapReduceGeneric.executors.MapReduceExecutorLocalMultiCore;
import com.actelion.research.mapReduceGeneric.utils.KeyValue;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.models.ImageTile;
import com.actelion.research.orbit.imageAnalysis.models.TaskResult;
import com.actelion.research.orbit.imageAnalysis.tasks.ITaskResultProducer;
import com.actelion.research.orbit.imageAnalysis.tasks.OrbitWorker;
import com.actelion.research.orbit.imageAnalysis.tasks.ProgressUpdateThread;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitHelper;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.imageAnalysis.utils.ResultEnhancer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ROIAreaWorkerMapReduce extends OrbitWorker implements ITaskResultProducer<Double> {

    private static final Logger logger = LoggerFactory.getLogger(ROIAreaWorkerMapReduce.class);
    private IMapReduceExecutor<String, Integer, Double> executor;
    private List<RawDataFile> rdfList;
    private OrbitModel model;
    private boolean useScaleout = false;

    public ROIAreaWorkerMapReduce() {
        // for result producer
    }

    public ROIAreaWorkerMapReduce(final OrbitModel model, final List<RawDataFile> rdfList, boolean useScaleout) {
        this.useScaleout = useScaleout;
        this.rdfList = rdfList;
        if (model != null) {
            this.model = new OrbitModel(model); // clone model
            this.model.getClassShapesToRestore().clear(); // no needed anymore
        }
        if (useScaleout) {
            executor = DALConfig.getScaleOut().createMapReduceExecutor(new ROIAreaMapReduce());
            ProgressUpdateThread updateThread = new ProgressUpdateThread(executor, this);
            updateThread.start();
        } else {
            this.executor = new MapReduceExecutorLocalMultiCore<String, Integer, Double>() {
                @Override
                protected void setProgress(double progress) {
                    super.setProgress(progress);
                    ROIAreaWorkerMapReduce.this.setProgress((int) progress);
                }
            };
        }
    }

    @Override
    protected void doWork() throws Exception {
        String modelNew = DALConfig.getScaleOut().getRemoteContextStore().generateUniqueFilename("orbit", OrbitUtils.MODEL_ENDING);
        if (useScaleout) {
            DALConfig.getScaleOut().getRemoteContextStore().copyToRemote(model.getAsByteArray(), OrbitUtils.remoteNameSpace, modelNew);
        } else {
            ImageTile.modelCache.put(modelNew, model); // for local execution we just keep it in memory
        }
        List<String> imageTiles = OrbitHelper.EncodeImageTiles(modelNew, -1, model.getMipLayer(), rdfList);
        ROIAreaMapReduce mr = new ROIAreaMapReduce();
        mr.setModel(new OrbitModel(model));
        Map<Integer, Double> areas = null;
        try {
            areas = executor.execute(imageTiles, mr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ROIArea error: ", e);
        }
        taskResult = produceTaskResult(areas, true);
    }

    public TaskResult produceTaskResult(Map<Integer, Double> areas, boolean computeROIAreas) throws Exception {
        Map<Integer, List<KeyValue<String, Object>>> map = new HashMap<Integer, List<KeyValue<String, Object>>>(areas.size());
        for (Integer rdfId : areas.keySet()) {
            List<KeyValue<String, Object>> valList = new ArrayList<KeyValue<String, Object>>(1);
            RawDataFile rdf = DALConfig.getImageProvider().LoadRawDataFile(rdfId);
            OrbitUtils.ScaleAndUnit scaleAndUnit = OrbitUtils.getImageScaleAndUnit(rdf);
            double area = areas.get(rdfId);
            String unit = scaleAndUnit.getUnitSquare();
            if (scaleAndUnit.getUnit().equals(OrbitUtils.muMeterUnicode)) {
                unit = "mm" + (char) 178;
                area /= 1000000d;
            }
            valList.add(new KeyValue<String, Object>("ROIArea[" + unit + "]", area));
            map.put(rdfId, valList);
        }

        map = ResultEnhancer.enhanceResults(map);
        String res = ResultEnhancer.toString(map);
        logger.info("result:\n" + res);
        return new TaskResult("ROI Areas", res);
    }

    @Override
    public double getProgressD() {
        return executor.getProgress();
    }


}
