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

import com.actelion.research.orbit.beans.RawDataFile
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel
import com.actelion.research.orbit.imageAnalysis.models.SegmentationResult
import com.actelion.research.orbit.imageAnalysis.utils.OrbitHelper

import java.awt.Shape

/**
 * Simple segmentation. Load image, apply model (local, single threaded).
 * Replace image id and model id.
 *
 * Simple segmentation using the OrbitHelper.Segmentation method.
 *
 */
DALConfig.getImageProvider().authenticateUser("root","password")
try {
    RawDataFile rdf = DALConfig.imageProvider.LoadRawDataFile(1)
    OrbitModel model = OrbitModel.LoadFromFile("d:/orbitModels/test.omo")

// classify the image
    SegmentationResult res = OrbitHelper.Segmentation(rdf.rawDataFileId, model, null, 1)

// and output the segmented objects (can be cast to polygons)
    for (Shape shape : res.shapeList) {
        println(shape)
    }
} finally {
    DALConfig.getImageProvider().close()  // only close if not executed within Orbit
}