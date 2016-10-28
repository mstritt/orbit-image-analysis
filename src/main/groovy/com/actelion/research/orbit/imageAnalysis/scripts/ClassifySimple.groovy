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
import com.actelion.research.orbit.beans.RawDataFile
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel
import com.actelion.research.orbit.imageAnalysis.utils.ClassificationResult
import com.actelion.research.orbit.imageAnalysis.utils.OrbitHelper

/**
 * Simple classification. Load image, apply model (local, single threaded).
 * Replace image id and model id.
 *
 * Simple classification using the OrbitHelper.Classify method.
 *
 */
RawDataFile rdf = DALConfig.imageProvider.LoadRawDataFile(7683);
OrbitModel model = OrbitModel.LoadFromOrbit(2231929);

// classify the image
ClassificationResult res = OrbitHelper.Classify(rdf.rawDataFileId,model);

// and output the results
String resStr = rdf.fileName;
List<KeyValue<String, Double>> norm = res.normalizeRatio();
(0..model.getClassShapes().size()-1).each {
    resStr += "\t" + norm.get(it).value;
}
println resStr;
DALConfig.getImageProvider().close();  // only close if not executed within Orbit