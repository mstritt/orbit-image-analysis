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



import com.actelion.research.mapReduceGeneric.utils.KeyValue
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel
import com.actelion.research.orbit.imageAnalysis.utils.ClassificationResult
import com.actelion.research.orbit.imageAnalysis.utils.OrbitHelper
import com.actelion.research.orbit.imageAnalysis.utils.OrbitLogAppender
import com.actelion.research.orbit.imageAnalysis.utils.ScaleoutMode
import groovyx.gpars.GParsPool
/**
 * Perform image classifications using an Orbit model. Images are processed multithreaded.
 * Replace model id, image search, optional: authentificate with username and password if needed.
 *
 * Does not use map-reduce, instead the helper classify method is called directly (multi-threaded).
 * Might be useful to some special things, e.g. classify inside segmented objects, ...
 */
OrbitLogAppender.GUI_APPENDER = false;   // no GUI (error) popups
DALConfig.getImageProvider().authenticateUser("root", "omero"); // optional: otherwise the scaleout user defined in OrbitOmero.conf is used
ScaleoutMode.SCALEOUTMODE.set(false);
OrbitModel model = OrbitModel.LoadFromOrbit(2229122); // the model to load  - to be replaced
rdfList = OrbitHelper.searchImages("ELB2525-0049 MT");  // search string - to be replaced
StringBuilder sb = new StringBuilder();
GParsPool.withPool {
    rdfList.eachParallel {    // process each image parallel
        println "image: " + it
        ClassificationResult res = OrbitHelper.Classify(it.rawDataFileId, model);
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

