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

import com.actelion.research.mapReduceGeneric.IMapReduce;
import com.actelion.research.mapReduceGeneric.utils.Helpers;
import com.actelion.research.mapReduceGeneric.utils.KeyValue;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.models.ImageTile;
import com.actelion.research.orbit.imageAnalysis.tasks.ExclusionMapGen;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.imageAnalysis.utils.ScaleoutMode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ROIAreaMapReduce implements IMapReduce<String, Integer, Double> {

    private OrbitModel model = null;


    @Override
    public List<KeyValue<Integer, Double>> map(String element) {
        try {
            if (ScaleoutMode.SCALEOUTMODE.get()) DALConfig.getImageProvider().authenticateUserScaleout();
            ImageTile imageTile = new ImageTile(element);
            OrbitModel localModel = model;
            if (localModel == null) localModel = imageTile.loadModel();
            RawDataFile rdf = DALConfig.getImageProvider().LoadRawDataFile(imageTile.getRawDataFileId());
            RecognitionFrame rf = new RecognitionFrame(rdf, false);
            rf.loadImageScale(rdf.getRawDataFileId());
            rf.loadAnnotationROI(rdf.getRawDataFileId(), localModel.getAnnotationGroup());
            ExclusionMapGen exMapGen = null;
            if (localModel != null) {
                if (localModel.getExclusionModel() != null) {
                    exMapGen = ExclusionMapGen.constructExclusionMap(rdf, rf, localModel);
                    exMapGen.setNumThreads(1);
                    exMapGen.setDoNormalize(false);
                    exMapGen.generateMap();
                }
            }
            double roiArea = OrbitUtils.getROISize(rf, exMapGen);
            List<KeyValue<Integer, Double>> res = new ArrayList<KeyValue<Integer, Double>>(1);
            res.add(new KeyValue<Integer, Double>(rdf.getRawDataFileId(), roiArea));
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                if (ScaleoutMode.SCALEOUTMODE.get()) DALConfig.getImageProvider().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Double reduce(Integer key, List<Double> valueList) {
        return valueList.get(0); // should be only one value per image and key
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
