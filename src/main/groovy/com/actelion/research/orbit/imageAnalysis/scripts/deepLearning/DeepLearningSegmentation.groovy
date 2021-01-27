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

/**
 * Uses a Tensorflow deep learning model to segment objects and optionally stores them as spot annotations in
 * the database.
 * A segmentation model is needed which simply detects white objects on black background.
 *
 * Use Tools -> Rare Object Detection, then click in 'load' to load the stored object annotations.
 * Can be used to e.g. perform a classification inside objects, area measurement of objects or manual classification of objects
 * (see help in rare object detection module).
 */
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig
import com.actelion.research.orbit.imageAnalysis.deeplearning.DLSegment
import com.actelion.research.orbit.imageAnalysis.deeplearning.DLSession
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel
import org.tensorflow.TensorFlow
import org.intel.openvino.*

import java.awt.Shape

//int[] images = DALConfig.getImageProvider().LoadRawDataFilesSearchFast("ELB0123-0332",1000, OrbitUtils.fileTypeImages).collect {it.rawDataFileId}
int[] images = [88] // either orbitIDs or load via query
storeAnnotations = true // store segmentation annotations in DB ?

// load the segmentation model, either via file, or url (useful if you want to run it on a server / cluster)
// DLSession s = DLSegment.buildSession("models/20180202_glomeruli_detection_noquant.pb")
DLSession s = DLSegment.buildSession("models/20180202_glomeruli_detection_noquant.xml")
//Session s = segment.buildSession(new URL("http://myserver/20180202_glomeruli_detection_noquant.pb"))

// segmentation model, white objects an black background. You can use the dlsegmentsplit.omo in the resources/testmodels folder.
OrbitModel segModel = OrbitModel.LoadFromInputStream(this.getClass().getResourceAsStream("/resource/testmodels/dlsegmentsplit.omo"))
// exclusion model (to define a ROI by model): a model that contains an exclusion model, can be null
OrbitModel modelContainingExclusionModel = null;
println "using Tensorflow "+TensorFlow.version()
Map<Integer,List<Shape>> segmentationsPerImage = DLSegment.generateSegmentationAnnotations(images, s, segModel, modelContainingExclusionModel, storeAnnotations)

// output number of found objects per image
segmentationsPerImage.keySet().each {
    println "Image $it: number of objects segmented: ${segmentationsPerImage.get(it).size()}"
}

s.close()
DALConfig.imageProvider.close()
