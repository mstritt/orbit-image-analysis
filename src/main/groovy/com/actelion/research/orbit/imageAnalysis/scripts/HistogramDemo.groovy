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



import com.actelion.research.orbit.imageAnalysis.dal.DALConfig
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel
import com.actelion.research.orbit.imageAnalysis.tasks.histogram.HistogramWorkerMapReduce
import com.actelion.research.orbit.imageAnalysis.utils.OrbitLogAppender
/**
 * Perform a histogram calculation on an image set using an Orbit model.
 * Replace model id, image id, username and password.
 *
 * MapReduce version, option to use scale-out infrastructure. Processes a list of images, saves results to a file.
 */
OrbitLogAppender.GUI_APPENDER = false;   // no GUI (error) popups
DALConfig.getImageProvider().authenticateUser("root", "omero");   // authenticate to image server
model = OrbitModel.LoadFromOrbit(2246761); // the model to load
rdfList = DALConfig.imageProvider.LoadRawDataFilesSearchFast("3096-a-5", 1000, null);   // search for images with "3096-a-5" and in filename, all filetypes (null)
useScaleout = false;  // set to true to use scaleout (e.g. Spark)
HistogramWorkerMapReduce cw = new HistogramWorkerMapReduce(model, rdfList, useScaleout); // initialize the helper class with model, imagelist and scaleout-mode
cw.run();  // perform the classification
println cw.getTaskResult(); // output the result
new File("/home/result.txt").text = cw.getTaskResult().toString();  // save result as file
DALConfig.getImageProvider().close(); // close image provider connection

