/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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

import com.actelion.research.mapReduceGeneric.IMapReduce;
import com.actelion.research.mapReduceGeneric.utils.Helpers;
import com.actelion.research.mapReduceGeneric.utils.KeyValue;
import com.actelion.research.orbit.dal.IModelAwareImageProvider;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.ImageTile;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.models.SegmentationResult;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitHelper;
import com.actelion.research.orbit.imageAnalysis.utils.ScaleoutMode;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CellFeaturesMapReduce implements IMapReduce<String, Integer, KeyValue<OrbitModel, SegmentationResult>> {

    private OrbitModel model = null;


    @Override
    public List<KeyValue<Integer, KeyValue<OrbitModel, SegmentationResult>>> map(String element) {
        if (ScaleoutMode.SCALEOUTMODE.get()) DALConfig.getImageProvider().authenticateUserScaleout();
        List<KeyValue<Integer, KeyValue<OrbitModel, SegmentationResult>>> results = new ArrayList<KeyValue<Integer, KeyValue<OrbitModel, SegmentationResult>>>();
        ImageTile imageTiles = new ImageTile(element);
        try {
            OrbitModel localModel = model;
            if (localModel == null) {
                localModel = imageTiles.loadModel();
            }
            if (DALConfig.getImageProvider() instanceof IModelAwareImageProvider) {
                ((IModelAwareImageProvider) DALConfig.getImageProvider()).setOrbitModel(localModel);
            }
            SegmentationResult res = OrbitHelper.Segmentation(imageTiles.getRawDataFileId(), localModel, imageTiles.getTileList(), 1);
            results.add(new KeyValue<Integer, KeyValue<OrbitModel, SegmentationResult>>(imageTiles.getRawDataFileId(), new KeyValue<OrbitModel, SegmentationResult>(localModel, res)));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("MapReduceCellCount error: " + e.getMessage());
        } finally {
            try {
                if (ScaleoutMode.SCALEOUTMODE.get()) DALConfig.getImageProvider().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return results;
    }

    @Override
    public KeyValue<OrbitModel, SegmentationResult> reduce(Integer key, List<KeyValue<OrbitModel, SegmentationResult>> valueList) {
        OrbitModel localModel = null;
        SegmentationResult results = new SegmentationResult(0, 0, new ArrayList<String>(), new ArrayList<Shape>(), new ArrayList<double[]>());
        if (valueList != null && valueList.size() > 0) {
            results.setHeader(valueList.get(0).getValue().getHeader());
            for (KeyValue<OrbitModel, SegmentationResult> res : valueList) {
                results.setObjectCount(results.getObjectCount() + res.getValue().getObjectCount());
                results.setSecondaryObjectCount(results.getSecondaryObjectCount() + res.getValue().getSecondaryObjectCount());
                results.getFeatureList().addAll(res.getValue().getFeatureList());
                results.getShapeList().addAll(res.getValue().getShapeList());
                if (localModel == null) localModel = res.getKey();
            }
        }
        return new KeyValue<OrbitModel, SegmentationResult>(localModel, results);
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
