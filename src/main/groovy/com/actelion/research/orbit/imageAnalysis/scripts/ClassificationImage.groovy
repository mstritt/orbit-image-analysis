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



import com.actelion.research.orbit.beans.RawDataFile
import com.actelion.research.orbit.imageAnalysis.components.ImageFrame
import com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils
import com.actelion.research.orbit.imageAnalysis.utils.TiledImageWriter

import java.awt.Color
import java.awt.Point
import java.awt.image.Raster
import java.awt.image.WritableRaster

/**
 * Mark all pixel with red channel < threshold. After running the script, drag the class image slider (bottom of the image)
 * to the right to see the classification map.
 *
 */

final OrbitImageAnalysis OIA = OrbitImageAnalysis.getInstance(); // get the current (running) Orbit instance
final ImageFrame iFrame = OIA.getIFrame();
final int threshold = 200;

RecognitionFrame recognitionFrame = iFrame.recognitionFrame;
RawDataFile rdf = iFrame.rdf;
recognitionFrame.loadAnnotationROI(rdf.rawDataFileId,0);

recognitionFrame.setClassImage(
        new TiledImageWriter(recognitionFrame.bimg.getWidth(), recognitionFrame.bimg.getHeight(),
        recognitionFrame.bimg.getTileWidth(), recognitionFrame.bimg.getTileHeight()));

final Color classColor = Color.green;
final int[] col = [classColor.red,classColor.green,classColor.blue, 255];

recognitionFrame.bimg.image.getTileIndices(null).each  {
    Point tileIdx = it;
    Raster r = recognitionFrame.bimg.image.getTile((int)tileIdx.x,(int)tileIdx.y);
    WritableRaster classRaster = recognitionFrame.classImage.image.getWritableTile((int)tileIdx.x,(int)tileIdx.y);
    for (int y=0; y<r.getHeight(); y++)
        for (int x=0; x<r.getWidth(); x++) {
            if (OrbitUtils.isInROI(x,y,recognitionFrame.getROI(),null)) {
                if (r.getSample(x, y, 0) < threshold) {
                    classRaster.setPixel(x, y, col);
                }
            }
        }
    recognitionFrame.classImage.image.releaseWritableTile((int)tileIdx.x,(int)tileIdx.y);
}
println "Threshold classification done!"
iFrame.opacitySlider.setEnabled(true)
