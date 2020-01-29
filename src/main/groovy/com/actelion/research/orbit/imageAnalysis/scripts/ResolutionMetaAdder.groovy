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

import com.actelion.research.orbit.beans.RawMeta
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig
import com.actelion.research.orbit.utils.RawMetaFactoryFile
import com.actelion.research.orbit.utils.RawUtilsCommon


int imageId = 211
double microMeterPerPixel = 0.46
String userId = "root"

RawMetaFactoryFile rmff = new RawMetaFactoryFile(imageId,new Date(),userId)
RawMeta rawMeta = rmff.createMetaDouble(RawUtilsCommon.STR_META_IMAGE_SCALE,microMeterPerPixel)
DALConfig.imageProvider.InsertRawMeta(rawMeta)
println("Image scale meta entry written for imageId "+imageId+". Please reload the image to see the scalebar.")