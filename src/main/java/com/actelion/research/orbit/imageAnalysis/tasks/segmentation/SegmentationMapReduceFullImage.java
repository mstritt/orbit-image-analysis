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
import com.actelion.research.mapReduceGeneric.executors.MapReduceExecutorLocalMultiCore;
import com.actelion.research.mapReduceGeneric.utils.Helpers;
import com.actelion.research.mapReduceGeneric.utils.KeyValue;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.dal.IModelAwareImageProvider;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.ImageTile;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.models.SegmentationResult;
import com.actelion.research.orbit.imageAnalysis.utils.ScaleoutMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class SegmentationMapReduceFullImage implements IMapReduce<String, Integer, SegmentationResult> {

    private OrbitModel model = null;
    private final transient static Logger logger = LoggerFactory.getLogger(SegmentationMapReduceFullImage.class);


    @Override
    public List<KeyValue<Integer, SegmentationResult>> map(String element) {
        long startTime = System.currentTimeMillis();
        if (ScaleoutMode.SCALEOUTMODE.get()) DALConfig.getImageProvider().authenticateUserScaleout();
        List<KeyValue<Integer, SegmentationResult>> ratio = new ArrayList<KeyValue<Integer, SegmentationResult>>();
        ImageTile imageTiles = new ImageTile(element);
        try {
            OrbitModel localModel = this.model;
            if (localModel==null) {
                localModel = imageTiles.loadModel();
            }
            if (DALConfig.getImageProvider() instanceof IModelAwareImageProvider) {
                ((IModelAwareImageProvider) DALConfig.getImageProvider()).setOrbitModel(localModel);
            }
            List<Point> tiles = new ArrayList<>();
            tiles.add(new Point(-1,-1));
            List<RawDataFile> rdfList = Collections.singletonList(DALConfig.getImageProvider().LoadRawDataFile(imageTiles.getRawDataFileId()));
            boolean useScaleout = false;  
            SegmentationWorkerMapReduce sw = new SegmentationWorkerMapReduce(model, rdfList, useScaleout);
            ((MapReduceExecutorLocalMultiCore)sw.getExecutor()).setMaxThreads(10);
            sw.run();  // perform the classification

            Map<Integer,SegmentationResult> res = sw.getSegmentationResultMap();
            for (Integer key: res.keySet()) {
                ratio.add(new KeyValue<>(key,res.get(key))); // TODO: reduce?
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Segmentation error: " + e.getMessage() + " / cause: " + e.getCause());
        } finally {
            try {
                DALConfig.getImageProvider().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long usedt = System.currentTimeMillis() - startTime;
        logger.info("mapper: used time for element "+element+": "+(usedt/(1000*60d))+"m");
        return ratio;
    }

    @Override
    public SegmentationResult reduce(Integer key, List<SegmentationResult> valueList) {
        OrbitModel localModel = null;
        int objCount = 0;
        int secCount = 0;
        for (SegmentationResult cnt : valueList) {
            objCount += cnt.getObjectCount();
            secCount += cnt.getSecondaryObjectCount();
            if (localModel == null) localModel = cnt.getModel();
        }
        return new SegmentationResult(objCount, secCount, localModel);
    }


    @Override
    public Collection<String> parseParams(String s) {
        return Helpers.parseParamsString(s);
    }

    @Override
    public String serializeParam(String element) {
        return element;
    }

    public OrbitModel getModel() {
        return model;
    }

    public void setModel(OrbitModel model) {
        this.model = model;
    }


}
