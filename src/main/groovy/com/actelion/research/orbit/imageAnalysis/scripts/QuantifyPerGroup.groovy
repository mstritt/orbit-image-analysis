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





import com.actelion.research.orbit.beans.RawDataFile
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel
import com.actelion.research.orbit.imageAnalysis.tasks.classification.ClassificationWorkerMapReduce
import com.actelion.research.orbit.imageAnalysis.utils.OrbitHelper
/**
 * Advanced script. Perform a classification using map-reduce (optional via scaleout-infrastructure) over a list of images and annotation groups.
 * (The idea is that you can have several ROIs and process them using different groups.)
 */
final int modelId = 2226854; // model to load;
String search = "test";   // replace it
def groups=(1..4); // 4 annotation ground, change it to the number of groups you have

final boolean scaleout = false; // can be used in scaleoutmode, too!
final List<RawDataFile> missing = new ArrayList<>();
final List<RawDataFile> rdfList = OrbitHelper.searchImages(search).findAll {    // we skip all images with no ROI annotation defined
    rf = new RecognitionFrame(it);
    rf.loadAnnotationROI(it.rawDataFileId,0);
    if (rf.getROI()==null) {
        println "skipping, no ROI in image "+it.toStringDetail()
        missing.add(it);
    };
    return rf.getROI()!=null;
}

println "skipped images due to missing ROI annotation:"
missing.each {
    println it;
}


println "number of remaining files: "+rdfList.size();
groups.each {
    final int group = it;
    println "deploying group: "+group;
    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                OrbitModel model = OrbitModel.LoadFromOrbit(modelId);
                model.setAnnotationGroup(group);
                ClassificationWorkerMapReduce cw = new ClassificationWorkerMapReduce(model, rdfList, scaleout);
                // SegmentationWorkerMapReduce cw = new SegmentationWorkerMapReduce(model,rdfList,scaleout);
                //CellClassificationWorkerMapReduce cw = new CellClassificationWorkerMapReduce(model,rdfList,scaleout);
                cw.setOnlyTilesinROI(true);
                cw.setSkipNonExplicitROIImages(true);
                cw.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
    thread.start();
}


