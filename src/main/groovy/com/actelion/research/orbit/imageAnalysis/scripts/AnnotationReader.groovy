import com.actelion.research.orbit.beans.RawAnnotation
import com.actelion.research.orbit.beans.RawDataFile
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig
import com.actelion.research.orbit.imageAnalysis.models.*

import java.awt.Point

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

// This script reads all annotations from an image and outputs the points. Can be used to convert the annotations to s.th. else, e.g. Omero annotations.

// instead of loading a RDF by id you can use the current selected image from the UI
//final OrbitImageAnalysis OIA = OrbitImageAnalysis.getInstance(); // get the current (running) Orbit instance
//final ImageFrame iFrame = OIA.getIFrame();  // get selected image
//RawDataFile rdf = iFrame.rdf;

// alternatively, you can load an image by id
//DALConfig.getImageProvider().authenticateUser("root", "omero"); // optional: otherwise the scaleout user defined in OrbitOmero.conf is used
RawDataFile rdf = DALConfig.imageProvider.LoadRawDataFile(7683);

if (rdf==null) throw new Exception("Image not found!");
List<RawAnnotation> annotations =  DALConfig.getImageProvider().LoadRawAnnotationsByRawDataFile(rdf.rawDataFileId,RawAnnotation.ANNOTATION_TYPE_IMAGE);
annotations.each {
    RawAnnotation ra = it;
    ImageAnnotation anno = new ImageAnnotation(ra);
    // now get the shape at 100%
    IScaleableShape shape = ((IScaleableShape)anno.firstShape).getScaledInstance(100d, new Point(0,0));
    // shape is of type PolygonExt, RectangleExt, or Arc2DExt
    switch (shape) {
        case {it instanceof PolygonExt}:
            println "polygon annotation: ";
            PolygonExt poly = shape;    // PolygonExt extends a standard AWT Polygon
            for (int i = 0; i < poly.npoints; i++) {
                print poly.xpoints[i] + "," + poly.ypoints[i]+"; ";
            }
            println "";
            break;
        case {it instanceof RectangleExt}: // RectangleExt extends a standard AWT Rectangle
            println "rectangle annotation: ";
            RectangleExt rect = shape;
            println rect.minX+","+rect.minY+","+rect.maxX+","+rect.maxY;
            break;
        case {it instanceof Arc2DExt}:   // ArcExt extends a standard AWT  Arc2DFixed.Double
            println "arc annotation: ";
            Arc2DExt arc = shape;
            println arc.centerX+","+arc.centerY
            break;
    }
}