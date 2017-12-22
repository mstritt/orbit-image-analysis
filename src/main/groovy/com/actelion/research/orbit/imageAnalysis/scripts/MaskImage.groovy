/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
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
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig
import com.actelion.research.orbit.imageAnalysis.mask.IOrbitMask
import com.actelion.research.orbit.imageAnalysis.mask.OrbitMaskClassificationModel
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils

import javax.imageio.ImageIO
import java.awt.*
import java.awt.image.Raster
import java.awt.image.WritableRaster

RawDataFile rdf = DALConfig.imageProvider.LoadRawDataFile(1814829); // 7683
RecognitionFrame recognitionFrame = new RecognitionFrame(rdf);

OrbitModel maskModel = OrbitModel.LoadFromFile("d:/orbitModels/test.omo")
//IOrbitMask mask = new OrbitMaskThreshold(50,150)
IOrbitMask mask = new OrbitMaskClassificationModel(maskModel, 1)
//List<Shape> shapeList = new ArrayList<>()
//Arc2DExt arc = new Arc2DExt(300,300,200,200,0,360,Arc2D.PIE)
//shapeList.add(arc)
//IOrbitMask mask = new OrbitMaskSegmentation(shapeList)

recognitionFrame.constructClassificationImage()
mask.initialize(recognitionFrame.bimg)

final Color classColor = Color.green;
final int[] col = [classColor.red,classColor.green,classColor.blue, 255];

recognitionFrame.tiles.each  {
    Point tileIdx = it;
    Raster r = recognitionFrame.getTile((int)tileIdx.x,(int)tileIdx.y);
    WritableRaster classRaster = recognitionFrame.getWritableClassificationTile((int)tileIdx.x,(int)tileIdx.y);
    for (int y=r.minY; y<r.minY + r.height; y++)
        for (int x=r.minX; x<r.minX + r.width; x++) {
            if (OrbitUtils.isInROI(x,y,recognitionFrame.getROI(),null)) {
               // println "tile ${tileIdx.x}x${tileIdx.y} : $x,$y"
                if (mask.isIncluded(x, y, r)) {
                    classRaster.setPixel(x, y, col);
                }
            }
        }
    recognitionFrame.releaseWritableClassificationTile((int)tileIdx.x,(int)tileIdx.y);
}
ImageIO.write(recognitionFrame.classImage.image.getAsBufferedImage(),"jpeg",new File("d:/test.jpg"))
println "Masking done!"
//iFrame.opacitySlider.setEnabled(true)
