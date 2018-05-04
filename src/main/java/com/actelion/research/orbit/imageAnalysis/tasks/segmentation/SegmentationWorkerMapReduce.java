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

package com.actelion.research.orbit.imageAnalysis.tasks.segmentation;

import com.actelion.research.mapReduceGeneric.IMapReduce;
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

import java.awt.*;
import java.util.*;
import java.util.List;

public class SegmentationWorkerMapReduce extends OrbitWorker implements ITaskResultProducer<SegmentationResult> {

    private static final Logger logger = LoggerFactory.getLogger(SegmentationWorkerMapReduce.class);
    private IMapReduceExecutor<String, Integer, SegmentationResult> executor;


    private List<RawDataFile> rdfList;
    private OrbitModel model;
    private String taskDetail = "";
    private boolean onlyTilesinROI = false;
    private boolean skipNonExplicitROIImages = false;
    private boolean useScaleout = false;
    private Map<Integer, SegmentationResult> segmentationResultMap;

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
        int chunkSize = -1;
        if ((model.getClassifier() != null && model.getClassifier().isBuild()))
            chunkSize = DALConfig.getScaleOut().getParallelism();
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
            mapReduce = new SegmentationMapReduceFullImage();
            ((SegmentationMapReduceFullImage)mapReduce).setModel(new OrbitModel(model));
        }  else {
            // local execution
            imageTiles = OrbitHelper.EncodeImageTiles(modelNew, model, chunkSize, model.getMipLayer(), onlyTilesinROI, skipNonExplicitROIImages, rdfList.toArray(new RawDataFile[0]));
            mapReduce = new SegmentationMapReduce();
            ((SegmentationMapReduce)mapReduce).setModel(new OrbitModel(model));
        }
        Map<Integer, SegmentationResult> counts = null;
        try {
            counts = executor.execute(imageTiles, mapReduce);
            this.segmentationResultMap = counts;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Segmentation error", e);
        }
        taskResult = produceTaskResult(counts, true);
    }

    public TaskResult produceTaskResult(Map<Integer, SegmentationResult> counts, boolean computeROIAreas) throws Exception {
        if (counts==null) {  // e.g. results can only be retrieved via 'retrieve existing results' panel
            return new TaskResult("Object Counts" + taskDetail, "Batch submitted, results can be retrieved via Batch -> Retrieve Existing Results.");
        }
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
        return new TaskResult("Object Counts" + taskDetail, res, localModel);
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

    public Map<Integer, SegmentationResult> getSegmentationResultMap() {
        return segmentationResultMap;
    }

    public IMapReduceExecutor<String, Integer, SegmentationResult> getExecutor() {
        return executor;
    }

//    public static void main(String[] args) throws Exception {
//        SegmentationWorkerMapReduce worker = new SegmentationWorkerMapReduce(OrbitModel.LoadFromFile("d:/orbitModels/test.omo"),Collections.singletonList(DALConfig.getImageProvider().LoadRawDataFile(4017567)),false);
//        worker.run();
//    }

}
