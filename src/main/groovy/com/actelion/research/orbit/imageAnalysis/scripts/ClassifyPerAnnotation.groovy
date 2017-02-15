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
import com.actelion.research.orbit.beans.RawAnnotation
import com.actelion.research.orbit.beans.RawDataFile
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig
import com.actelion.research.orbit.imageAnalysis.models.ImageAnnotation
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel
import com.actelion.research.orbit.imageAnalysis.utils.ClassificationResult
import com.actelion.research.orbit.imageAnalysis.utils.OrbitHelper
import com.actelion.research.orbit.imageAnalysis.utils.OrbitLogAppender
import groovyx.gpars.GParsPool


/**
 * Iterates over all annotations and outputs classification results per image x annotation.
 */
def model = OrbitModel.LoadFromOrbit(2248470) // replace model id
def searchStr = "ELB123-123 SR"  // replace search string

OrbitLogAppender.GUI_APPENDER = false   // no GUI (error) popups
//DALConfig.getImageProvider().authenticateUser("root", "omero"); // optional: otherwise the scaleout user defined in OrbitOmero.conf is used
images = OrbitHelper.searchImages(searchStr)
StringBuilder sb = new StringBuilder("Image\tAnnotation")
model.classShapes.each {      // append header
    sb.append("\t"+it.name)
}
sb.append("\n")
GParsPool.withPool {
    images.eachParallel { // attention: images will be computed in parallel, thus the output order is shuffled
        RawDataFile rdf = it
        StringBuilder sbImage = new StringBuilder()
        DALConfig.getImageProvider().LoadRawAnnotationsByRawDataFile(rdf.rawDataFileId, RawAnnotation.ANNOTATION_TYPE_IMAGE).each {
            ImageAnnotation anno = new ImageAnnotation(it)
            ClassificationResult res = OrbitHelper.Classify(rdf, model, null, 1, anno.getFirstShape())
            String s = rdf.fileName + "\t" + anno.description
            res.normalizeRatio().each {
                s += "\t" + it.value
            }
            s += "\n"
            sbImage.append(s)
            print s
        }
        sb.append(sbImage.toString())
    }
}
println "\n\n\nResult:\n"
println sb.toString()
println "done"