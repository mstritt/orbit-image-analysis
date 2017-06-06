import com.actelion.research.orbit.beans.RawAnnotation
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig
import com.actelion.research.orbit.imageAnalysis.models.ImageAnnotation
import com.actelion.research.orbit.imageAnalysis.models.PolygonExt

import java.awt.Color

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

// this example stores an Orbit ROI

String user = "omero";
String pw = "password";

DALConfig.getImageProvider().authenticateUser(user,pw);

// create a dummy polygon ROI
PolygonExt polygon = new PolygonExt();
polygon.addPoint(10,10);
polygon.addPoint(20,10);
polygon.addPoint(20,20);
polygon.setClosed(true);

ImageAnnotation annotation = new ImageAnnotation("ROI",polygon,ImageAnnotation.SUBTYPE_ROI, Color.magenta);
// you might add further shapes like SUBTYPE_EXCLUSION to exclude parts inside a ROI or SUBTYPE_INCLUSION to include a part in an exclusion
// or just use SUBTYPE_NORMAL to add an informative annotation which does not influence the ROI at all

RawAnnotation rawAnnotation = new RawAnnotation();
rawAnnotation.setData(annotation.getData());
rawAnnotation.setDescription(annotation.getDescription());
rawAnnotation.setUserId(user);
rawAnnotation.setModifyDate(new Date());

// store in DB
DALConfig.getImageProvider().InsertRawAnnotation(rawAnnotation);
// insert further annotations...
DALConfig.getImageProvider().close();

