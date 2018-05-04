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

import com.actelion.research.mapReduceGeneric.IMapReduce;
import com.actelion.research.mapReduceGeneric.executors.IMapReduceExecutor;
import com.actelion.research.orbit.imageAnalysis.dal.MapReduceExecutor.MapReduceExecutorSparkProxy;
import com.actelion.research.orbit.imageAnalysis.tasks.MRTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClusterExecutorTest {

    /**
     * Class ratios: [KIM-1_MACI_1561 -.tif]
     * Background: 0.132977
     * Celltype 1: 0.223709
     * Celltype 2: 0.643314
     */
    public static void main(String[] args) throws Exception {
        IMapReduce<String,Integer,String> mr = new MRTest();
        IMapReduceExecutor<String, Integer, String> executor = new MapReduceExecutorSparkProxy<>();
       // IMapReduceExecutor<String, Integer, Integer> executor = new MapReduceExecutorLocalMultiCore<>();
        List<String> elements = new ArrayList<>();
        elements.add("t1");
        Map<Integer, String> classificationResultMap = executor.execute(elements, mr);
        System.out.println("submitted");
    }

}
