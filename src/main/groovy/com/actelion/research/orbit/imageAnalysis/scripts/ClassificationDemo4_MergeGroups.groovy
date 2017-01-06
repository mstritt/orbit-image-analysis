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






import com.actelion.research.mapReduceGeneric.utils.KeyValue
import com.actelion.research.orbit.beans.RawAnnotation
import com.actelion.research.orbit.beans.RawDataFile
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig
import com.actelion.research.orbit.imageAnalysis.models.IScaleableShape
import com.actelion.research.orbit.imageAnalysis.models.ImageAnnotation
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel
import com.actelion.research.orbit.imageAnalysis.models.ShapeAnnotationList
import com.actelion.research.orbit.imageAnalysis.utils.ClassificationResult
import com.actelion.research.orbit.imageAnalysis.utils.OrbitHelper
import com.actelion.research.orbit.imageAnalysis.utils.OrbitLogAppender
import com.actelion.research.orbit.imageAnalysis.utils.ScaleoutMode
import groovyx.gpars.GParsPool

import java.awt.*
import java.util.List
/**
 * Perform image classifications with ROI-Group combinations. E.g. you can merge ROI group 1 and 2 together.
 * Group 2 will be set as group 1 then, so the model should be configured to use group 1.
 * Replace model id, image search, fromGroup, toGroup, and optional: authentificate with username and password if needed.
 *
 * Does not use map-reduce, instead the helper classify method is called directly (multi-threaded).
 * Might be useful to some special things, e.g. classify inside segmented objects, ...
 */
OrbitLogAppender.GUI_APPENDER = false;   // no GUI (error) popups
//DALConfig.getImageProvider().authenticateUser("root", "omero"); // optional: otherwise the scaleout user defined in OrbitOmero.conf is used
ScaleoutMode.SCALEOUTMODE.set(false);

toGroup = 1;       // modify me!
fromGroup = [2,3];     // modify me!
OrbitModel model = OrbitModel.LoadFromOrbit(2246436); // the model to load  - to be replaced
rdfList = OrbitHelper.searchImages("3096-a-5.jpg");  // search string - to be replaced

StringBuilder sb = new StringBuilder();
GParsPool.withPool {
    rdfList.eachParallel {    // process each image parallel
        println "image: " + it
        RawDataFile rdf = it;
        IScaleableShape roi = loadAnnotationROI(rdf.rawDataFileId,toGroup,false);
        ClassificationResult res = OrbitHelper.Classify(it, model, Collections.singletonList(new Point(-1, -1)), -1, roi);
        String resStr = it.fileName;
        List<KeyValue<String, Double>> norm = res.normalizeRatio();
        (0..model.getClassShapes().size()-1).each {
            resStr += "\t" + norm.get(it).value;
        }
        sb.append(resStr + "\n"); // append the result
    }
}
println sb.toString(); // output the result
DALConfig.getImageProvider().close(); // close image provider connection


IScaleableShape loadAnnotationROI(int rdfId, int annotationGroup, boolean otherGroupROIAsExclusion) throws Exception {
    List<RawAnnotation> annotationsOri = DALConfig.getImageProvider().LoadRawAnnotationsByRawDataFile(rdfId, RawAnnotation.ANNOTATION_TYPE_IMAGE);
    List<RawAnnotation> annotations = new ArrayList<>();
    for (RawAnnotation ra: annotationsOri) {
        ImageAnnotation ia = new ImageAnnotation(ra);
        fromGroup.each {
            if (ia.getGroup()==it) ia.setGroup(toGroup);
        }
        annotations.add(ia);
    }

    if (annotations != null && annotations.size() > 0) {
        IScaleableShape roi = new ShapeAnnotationList(annotations, annotationGroup, null, otherGroupROIAsExclusion);
        return roi;      // bounds can be null - this is explicitely allowed!
    } else return null;
}