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

package com.actelion.research.orbit.imageAnalysis.tasks.histogram;

import com.actelion.research.mapReduceGeneric.IMapReduce;
import com.actelion.research.mapReduceGeneric.utils.Helpers;
import com.actelion.research.mapReduceGeneric.utils.KeyValue;
import com.actelion.research.orbit.dal.IModelAwareImageProvider;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.ImageTile;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitHelper;
import com.actelion.research.orbit.imageAnalysis.utils.ScaleoutMode;
import org.jaitools.tiledimage.DiskMemImageOrbit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HistogramMapReduce implements IMapReduce<String, Integer, Histogram[]> {

    private OrbitModel model = null;
    private final static Logger logger = LoggerFactory.getLogger(HistogramMapReduce.class);


    @Override
    public List<KeyValue<Integer, Histogram[]>> map(String element) {
        if (ScaleoutMode.SCALEOUTMODE.get()) DALConfig.getImageProvider().authenticateUserScaleout();
        List<KeyValue<Integer, Histogram[]>> histoList = new ArrayList<KeyValue<Integer, Histogram[]>>();
        ImageTile imageTiles = new ImageTile(element);
        try {
            OrbitModel localModel = model;
            if (localModel == null) {
                localModel = imageTiles.loadModel();
            }
            if (DALConfig.getImageProvider() instanceof IModelAwareImageProvider) {
                ((IModelAwareImageProvider) DALConfig.getImageProvider()).setOrbitModel(localModel);
            }
            Histogram[] results = OrbitHelper.Histogram(imageTiles.getRawDataFileId(), localModel, imageTiles.getTileList(), 1);
            histoList.add(new KeyValue<Integer, Histogram[]>(imageTiles.getRawDataFileId(), results));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("HistogramMapReduce error: " + e.getMessage());
        } finally {
            try {
                if (ScaleoutMode.SCALEOUTMODE.get()) DALConfig.getImageProvider().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return histoList;
    }

    @Override
    public Histogram[] reduce(Integer key, List<Histogram[]> valueList) {
        if (valueList != null && valueList.size() > 0) {
            Histogram[] histogramReduced = new Histogram[valueList.get(0).length];
            for (int i = 0; i < histogramReduced.length; i++) {
                histogramReduced[i] = new Histogram(valueList.get(0)[0].getModel());
            }

            for (Histogram[] histo : valueList) {
                for (int c = 0; c < histo.length; c++) {
                    histogramReduced[c].add(histo[c]);
                }
            }
            DiskMemImageOrbit.getCommonTileCache().flush();
            return histogramReduced;
        } else return new Histogram[0];
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
