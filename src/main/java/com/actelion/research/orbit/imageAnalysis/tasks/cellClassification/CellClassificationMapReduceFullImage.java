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
import com.actelion.research.mapReduceGeneric.executors.MapReduceExecutorLocalMultiCore;
import com.actelion.research.mapReduceGeneric.utils.Helpers;
import com.actelion.research.mapReduceGeneric.utils.KeyValue;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.dal.IModelAwareImageProvider;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.ImageTile;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.utils.ClassificationResult;
import com.actelion.research.orbit.imageAnalysis.utils.ScaleoutMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class CellClassificationMapReduceFullImage implements IMapReduce<String, Integer, ClassificationResult> {

    private OrbitModel model = null;
    private final transient static Logger logger = LoggerFactory.getLogger(CellClassificationMapReduceFullImage.class);


    @Override
    public List<KeyValue<Integer, ClassificationResult>> map(String element) {
        long startTime = System.currentTimeMillis();
        if (ScaleoutMode.SCALEOUTMODE.get()) DALConfig.getImageProvider().authenticateUserScaleout();
        List<KeyValue<Integer, ClassificationResult>> ratio = new ArrayList<KeyValue<Integer, ClassificationResult>>();
        ImageTile imageTiles = new ImageTile(element);
        try {
            //OrbitModel localModel = OrbitModel.LoadFromOrbit(2322530);
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
            CellClassificationWorkerMapReduce cw = new CellClassificationWorkerMapReduce(model, rdfList, useScaleout);
            ((MapReduceExecutorLocalMultiCore)cw.getExecutor()).setMaxThreads(10);
            cw.run();  // perform the classification

            Map<Integer,ClassificationResult> res = cw.getClassificationResultMap();
            for (Integer key: res.keySet()) {
                ratio.add(new KeyValue<>(key,res.get(key))); // TODO: reduce?
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("CellClassificationMapReduce error: " + e.getMessage() + " / cause: " + e.getCause());
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
    public ClassificationResult reduce(Integer key, List<ClassificationResult> valueList) {

        Map<String, Long> map = new HashMap<String, Long>();
        Map<String, Long> mapExcl = new HashMap<String, Long>();

        for (ClassificationResult cr : valueList) {
            Map<String, Long> subMap = cr.getRatio();
            if (subMap != null) {
                for (String name : subMap.keySet()) {
                    if (!map.containsKey(name)) {
                        map.put(name, subMap.get(name));
                    } else {
                        map.put(name, map.get(name) + subMap.get(name));
                    }
                }
            }

            if (cr.getExclusionRatio() != null) {
                Map<String, Long> subMapExcp = cr.getExclusionRatio();
                for (String name : subMapExcp.keySet()) {
                    if (!mapExcl.containsKey(name)) {
                        mapExcl.put(name, subMapExcp.get(name));
                    } else {
                        mapExcl.put(name, mapExcl.get(name) + subMapExcp.get(name));
                    }
                }
            }
        }

        OrbitModel model = null;
        if (valueList.size() > 0) {
            model = valueList.get(0).getModel();
        }
        ClassificationResult result = new ClassificationResult(map, mapExcl, model);
        return result;
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
