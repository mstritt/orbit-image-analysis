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

package com.actelion.research.orbit.imageAnalysis.tasks.histogram;

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
import com.actelion.research.orbit.imageAnalysis.utils.OrbitHelper;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.imageAnalysis.utils.ResultEnhancer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class HistogramWorkerMapReduce extends OrbitWorker implements ITaskResultProducer<Histogram[]> {


    private static final Logger logger = LoggerFactory.getLogger(HistogramWorkerMapReduce.class);
    private IMapReduceExecutor<String, Integer, Histogram[]> executor;
    private List<RawDataFile> rdfList;
    private OrbitModel model;
    private String taskDetail = "";
    private boolean useScaleout = false;

    public HistogramWorkerMapReduce() {
        // for result producer
    }

    public HistogramWorkerMapReduce(OrbitModel model, List<RawDataFile> rdfList, boolean useScaleout) {
        this.useScaleout = useScaleout;
        this.rdfList = rdfList;
        if (model != null) {
            this.model = new OrbitModel(model); // clone model
            this.model.getClassShapesToRestore().clear(); // no needed anymore
        }
        if (useScaleout) {
            executor = DALConfig.getScaleOut().createMapReduceExecutor(new HistogramMapReduce());
            ProgressUpdateThread updateThread = new ProgressUpdateThread(executor, this);
            updateThread.start();
        } else {
            this.executor = new MapReduceExecutorLocalMultiCore<String, Integer, Histogram[]>() {
                @Override
                protected void setProgress(double progress) {
                    super.setProgress(progress);
                    HistogramWorkerMapReduce.this.setProgress((int) progress);
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
            List<String> imageTiles = OrbitHelper.EncodeImageTiles(modelNew, tileChunkSize, model.getMipLayer(), rdfList);
            HistogramMapReduce mrHistogram = new HistogramMapReduce();
            mrHistogram.setModel(new OrbitModel(model));
            Map<Integer, Histogram[]> histogramMap = null;
            try {
                histogramMap = executor.execute(imageTiles, mrHistogram);
            } catch (Exception e) {
                logger.error("Histogram error: ", e);
            }
            taskResult = produceTaskResult(histogramMap, true);
        } catch (Exception e) {
            logger.error("Histogram interrupted", e);
        }
    }

    @Override
    public TaskResult produceTaskResult(Map<Integer, Histogram[]> histogramMap, boolean computeROIAreas) throws Exception {
        Map<Integer, List<KeyValue<String, Object>>> map = new HashMap<Integer, List<KeyValue<String, Object>>>(histogramMap.size());
        OrbitModel resModel = null;
        final String[] chanNames = new String[]{"red", "green", "blue"};
        for (Integer rdfId : histogramMap.keySet()) {
            Histogram[] histograms = histogramMap.get(rdfId);
            List<KeyValue<String, Object>> kvList = new ArrayList<KeyValue<String, Object>>();
            for (int i = 0; i < histograms.length; i++) {
                Histogram histogram = histograms[i];
                String histoName = "gray";
                if (histograms.length > 1 && histograms.length < 4) {
                    histoName = chanNames[i];
                } else if (histograms.length > 3) {
                    histoName = "c" + i + "_";
                }
                for (int bin = 0; bin < histogram.getBins().length; bin++) {
                    KeyValue<String, Object> kv = new KeyValue<String, Object>(histoName + bin, histogram.getBins()[bin]);
                    kvList.add(kv);
                }
            }
            map.put(rdfId, kvList);
            //if (resModel==null) resModel = histograms.getModel();
        }
        map = ResultEnhancer.enhanceResults(map);
        if (computeROIAreas)
            logger.info("Warning: computeROIAreas is requested, but not supported by HistogramWorkerMapReduce.");
        //if (computeROIAreas) map = ResultEnhancer.enhanceROIArea(resModel,map);
        String res = ResultEnhancer.toString(map);
        logger.info("result:\n" + res);
        return new TaskResult("Histogram" + taskDetail, res);
    }


    @Override
    public double getProgressD() {
        return executor.getProgress();
    }

}
