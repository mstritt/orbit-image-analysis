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

package com.actelion.research.orbit.imageAnalysis.tasks.cellFeatures;

import com.actelion.research.mapReduceGeneric.executors.IMapReduceExecutor;
import com.actelion.research.mapReduceGeneric.executors.MapReduceExecutorLocalMultiCore;
import com.actelion.research.mapReduceGeneric.utils.KeyValue;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.features.ObjectFeatureBuilderTiled;
import com.actelion.research.orbit.imageAnalysis.models.ImageTile;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.models.SegmentationResult;
import com.actelion.research.orbit.imageAnalysis.models.TaskResult;
import com.actelion.research.orbit.imageAnalysis.tasks.ITaskResultProducer;
import com.actelion.research.orbit.imageAnalysis.tasks.OrbitWorker;
import com.actelion.research.orbit.imageAnalysis.tasks.ProgressUpdateThread;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitHelper;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import org.jaitools.tiledimage.DiskMemImageOrbit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class CellFeaturesWorkerMapReduce extends OrbitWorker implements ITaskResultProducer<KeyValue<OrbitModel, SegmentationResult>> {

    private static final Logger logger = LoggerFactory.getLogger(CellFeaturesWorkerMapReduce.class);
    private IMapReduceExecutor<String, Integer, KeyValue<OrbitModel, SegmentationResult>> executor;


    private List<RawDataFile> rdfList;
    private OrbitModel model;
    private String taskDetail = "";
    private boolean useScaleout = false;

    public CellFeaturesWorkerMapReduce() {
        // for result producer
    }

    public CellFeaturesWorkerMapReduce(final OrbitModel model, final List<RawDataFile> rdfList, boolean useScaleout) {
        this.useScaleout = useScaleout;
        this.rdfList = rdfList;
        if (model != null) {
            this.model = new OrbitModel(model); // clone model
            this.model.getClassShapesToRestore().clear(); // no needed anymore
        }
        if (useScaleout) {
            executor = DALConfig.getScaleOut().createMapReduceExecutor(new CellFeaturesMapReduce());
            ProgressUpdateThread updateThread = new ProgressUpdateThread(executor, this);
            updateThread.start();
        } else {
            executor = new MapReduceExecutorLocalMultiCore<String, Integer, KeyValue<OrbitModel, SegmentationResult>>() {
                @Override
                protected void setProgress(double progress) {
                    super.setProgress(progress);
                    CellFeaturesWorkerMapReduce.this.setProgress((int) progress);
                }
            };
        }
    }

    @Override
    protected void doWork() throws Exception {
        try {
            taskDetail = " [" + new Date().toString() + "]";
            String modelNew = DALConfig.getScaleOut().getRemoteContextStore().generateUniqueFilename("orbit", OrbitUtils.MODEL_ENDING);
            if (useScaleout) {
                try {
                    DALConfig.getScaleOut().getRemoteContextStore().copyToRemote(model.getAsByteArray(), OrbitUtils.remoteNameSpace, modelNew);
                } catch (Exception es) {
                    ImageTile.modelCache.put(modelNew, model);
                    logger.error("cannot write model to remote context store, writing to local cache instead. Reason: ", es);
                }
            } else {
                ImageTile.modelCache.put(modelNew, model); // for local execution we just keep it in memory
            }
            //boolean longRunningJob = model.getSecondarySegmentationModel() != null || (model.getSegmentationModel() != null && model.getSegmentationModel().getFeatureDescription().isCytoplasmaSegmentation());
            //int chunkSize = longRunningJob ? 10 : 150;
            int chunkSize = -1;
            if ((model.getClassifier() != null && model.getClassifier().isBuild()))
                chunkSize = DALConfig.getScaleOut().getParallelism();
            List<String> imageTiles = OrbitHelper.EncodeImageTiles(modelNew, chunkSize, model.getMipLayer(), rdfList);      // chunksize: 15:150
            CellFeaturesMapReduce cellFeaturesMapReduce = new CellFeaturesMapReduce();
            cellFeaturesMapReduce.setModel(new OrbitModel(model));
            Map<Integer, KeyValue<OrbitModel, SegmentationResult>> results = null;
            try {
                results = executor.execute(imageTiles, cellFeaturesMapReduce);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("Cell Features error", e);
            }
            taskResult = produceTaskResult(results, true);
            DiskMemImageOrbit.getCommonTileCache().flush();
        } catch (Exception e) {
            logger.error("Cell Segmentation (Features) error:", e);
        }
    }

    public TaskResult produceTaskResult(Map<Integer, KeyValue<OrbitModel, SegmentationResult>> results, boolean computeROIAreas) throws Exception {
        OrbitModel localModel = null;
        if (results != null && results.values() != null && results.values().size() > 0) {
            localModel = results.values().iterator().next().getKey();
        }

        String[] featureNames = new ObjectFeatureBuilderTiled(results.get(results.keySet().iterator().next()).getKey()).getFeatureNames(3);
        final String delimiter = "\t";
        final String decimalSeparator = ".";
        boolean includingClass = false;
        StringBuilder sb = new StringBuilder();
        sb.append("Image" + delimiter);
        for (int i = 0; i < featureNames.length; i++) {
            sb.append(featureNames[i]);
            if (i < featureNames.length - 1) sb.append(delimiter);
        }
        if (includingClass) sb.append(delimiter + "class");
        sb.append("\n");

        for (Integer rdfId : results.keySet()) {
            RawDataFile rdf = DALConfig.getImageProvider().LoadRawDataFile(rdfId);
            SegmentationResult sr = results.get(rdfId).getValue();
            List<double[]> features = sr.getFeatureList();
            for (int i = 0; i < features.size(); i++) {
                sb.append("\"" + rdf.getFileName() + "\"" + delimiter);
                for (int j = 0; j < features.get(i).length - 1; j++) {
                    String val = Double.isNaN(features.get(i)[j]) ? "" : (features.get(i)[j] + "");
                    sb.append(val.replaceAll("\\.", decimalSeparator));
                    if (j < features.get(i).length - 2) sb.append(delimiter);
                }
                if (includingClass) {
                    sb.append(delimiter + features.get(i)[features.get(i).length - 1]);
                }
                sb.append("\n");
            }
        }

        String res = sb.toString();
        logger.info("result:\n" + res);
        return new TaskResult("Cell Features" + taskDetail, res);
    }

    @Override
    public double getProgressD() {
        return executor.getProgress();
    }


}
