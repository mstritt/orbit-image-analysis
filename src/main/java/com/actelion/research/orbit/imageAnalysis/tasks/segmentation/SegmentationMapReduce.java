/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
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
import com.actelion.research.mapReduceGeneric.utils.Helpers;
import com.actelion.research.mapReduceGeneric.utils.KeyValue;
import com.actelion.research.orbit.dal.IModelAwareImageProvider;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.ImageTile;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.models.SegmentationResult;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitHelper;
import com.actelion.research.orbit.imageAnalysis.utils.ScaleoutMode;
import org.jaitools.tiledimage.DiskMemImageOrbit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SegmentationMapReduce implements IMapReduce<String, Integer, SegmentationResult> {

    private OrbitModel model = null;

    @Override
    public List<KeyValue<Integer, SegmentationResult>> map(String element) {
        if (ScaleoutMode.SCALEOUTMODE.get()) DALConfig.getImageProvider().authenticateUserScaleout();
        List<KeyValue<Integer, SegmentationResult>> counts = new ArrayList<KeyValue<Integer, SegmentationResult>>();
        ImageTile imageTiles = new ImageTile(element);
        try {
            OrbitModel localModel = model;
            if (localModel == null) {
                localModel = imageTiles.loadModel();
            }
            if (DALConfig.getImageProvider() instanceof IModelAwareImageProvider) {
                ((IModelAwareImageProvider) DALConfig.getImageProvider()).setOrbitModel(localModel);
            }
            SegmentationResult segmentatioResult = OrbitHelper.Segmentation(imageTiles.getRawDataFileId(), localModel, imageTiles.getTileList(), 1);
            segmentatioResult.setModel(localModel);
            counts.add(new KeyValue<Integer, SegmentationResult>(imageTiles.getRawDataFileId(), segmentatioResult));
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
        return counts;
    }

    @Override
    public SegmentationResult reduce(Integer key, List<SegmentationResult> valueList) {
        OrbitModel localModel = null;
        int objCount = 0;
        int secCount = 0;
        for (SegmentationResult cnt : valueList) {
            objCount += cnt.getObjectCount();
            secCount = cnt.getSecondaryObjectCount();
            if (localModel == null) localModel = cnt.getModel();
        }
        DiskMemImageOrbit.getCommonTileCache().flush();
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
