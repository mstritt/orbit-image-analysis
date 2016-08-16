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

package com.actelion.research.orbit.imageAnalysis.scripts

import com.actelion.research.orbit.beans.RawDataFile
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel
import com.actelion.research.orbit.imageAnalysis.models.TaskResult
import com.actelion.research.orbit.imageAnalysis.tasks.classification.ClassificationWorkerMapReduce
import com.actelion.research.orbit.imageAnalysis.utils.OrbitHelper

/**
 * Classification results per ROI group. For each group a result file will be written.
 */
def modelId = 2226975; // the model to load
def search = "test" // search string
def groups = (1..4)
def outFolder = "/home/out"

List<RawDataFile> rdfList = OrbitHelper.searchImages(search);
println "#images: " + rdfList.size() + " images: " + rdfList
groups.each {
    int group = it;
    println "group: " + group
    OrbitModel model = OrbitModel.LoadFromOrbit(modelId);
    model.setAnnotationGroup(group);
    ClassificationWorkerMapReduce worker = new ClassificationWorkerMapReduce(model, rdfList, false);
    worker.setOnlyTilesinROI(true);
    worker.run();
    TaskResult res = worker.getTaskResult();
    println res;
    new File(outFolder + "/group" + group + ".txt").text = res.toString();
}