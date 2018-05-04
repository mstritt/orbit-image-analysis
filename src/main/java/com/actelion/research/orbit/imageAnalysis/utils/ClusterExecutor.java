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

package com.actelion.research.orbit.imageAnalysis.utils;

import com.actelion.research.mapReduceGeneric.executors.IMapReduceExecutor;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.dal.MapReduceExecutor.MapReduceExecutorSparkProxy;
import com.actelion.research.orbit.imageAnalysis.models.ImageTile;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.tasks.classification.ClassificationMapReduceFullImage;
import com.actelion.research.orbit.utils.RawUtilsCommon;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ClusterExecutor {

    /**
     * Class ratios: [KIM-1_MACI_1561 -.tif]
     * Background: 0.132977
     * Celltype 1: 0.223709
     * Celltype 2: 0.643314
     */
    public static void main(String[] args) throws Exception {
      //  int modelId = 2324299;  // lung
        int modelId = 2325813;  
        OrbitModel model = OrbitModel.LoadFromOrbit(modelId);
//        model.getClassShapesToRestore().clear();
        //int[] ids = new int[]{6708260,6708261,6708162,6708265,6708267,6708163};
        //int[] ids = new int[]{6708162};
        //int rdfId = 6708162;

        List<RawDataFile> rdfList = DALConfig.getImageProvider().LoadRawDataFilesSearchFast("ELB0041-0957",100, Arrays.asList(RawUtilsCommon.fileTypesImage));
      //  List<RawDataFile> rdfList = DALConfig.getImageProvider().LoadRawDataFilesSearchFast("ELB0041-0955",1000, Arrays.asList(RawUtilsCommon.fileTypesImage));
        System.out.println("#images: "+rdfList.size());

//        String modelNew = DALConfig.getScaleOut().getRemoteContextStore().generateUniqueFilename("orbit", OrbitUtils.MODEL_ENDING);
//        DALConfig.getScaleOut().getRemoteContextStore().copyToRemote(model.getAsByteArray(), OrbitUtils.remoteNameSpace, modelNew);
        String modelNew = String.valueOf(modelId);
        List<Point> tiles = new ArrayList<>();
        tiles.add(new Point(-1,-1));
        List<String> elements = new ArrayList<>();
//        for (int rdfId: ids) {
//            String experiment = new ImageTile(rdfId, tiles, modelNew).toString();
//            elements.add(experiment);
//        }
        for (RawDataFile rdf: rdfList) {
            String experiment = new ImageTile(rdf.getRawDataFileId(), tiles, modelNew).toString();
            elements.add(experiment);
        }
        ClassificationMapReduceFullImage mrClassification = new ClassificationMapReduceFullImage();
        mrClassification.setModel(new OrbitModel(model));
        IMapReduceExecutor<String, Integer, ClassificationResult> executor = new MapReduceExecutorSparkProxy<>();
        //IMapReduceExecutor<String, Integer, ClassificationResult> executor = new MapReduceExecutorLocalMultiCore<>();
        Map<Integer, ClassificationResult> classificationResultMap = executor.execute(elements, mrClassification);
        System.out.println("submitted");
    }

}
