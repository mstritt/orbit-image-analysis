/*
 * Orbit, a versatile image analysis software for biological image-based quantification.
 * Copyright (C) 2009 - 2020 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

import com.actelion.research.orbit.imageAnalysis.components.ImageFrame
import com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis
import com.actelion.research.orbit.imageAnalysis.imaging.TileSizeWrapper
import com.actelion.research.orbit.imageAnalysis.models.FeatureDescription
import com.actelion.research.orbit.imageAnalysis.utils.OrbitImagePlanar
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImageIOrbitImage
import com.actelion.research.orbit.imageAnalysis.utils.TiledImagePainter
import javax.imageio.ImageIO;

import java.awt.Rectangle
import java.awt.Graphics2D
import java.awt.image.BufferedImage
import java.awt.image.ColorModel
import javax.media.jai.PlanarImage


final OrbitImageAnalysis OIA = OrbitImageAnalysis.getInstance();
final ImageFrame iFrame = OIA.getIFrame();

TileSizeWrapper tileSizeWrapper = new TileSizeWrapper(
        new OrbitImagePlanar(iFrame.getRecognitionFrame().bimg.getImage(), ""),
        512,
        512);

OrbitTiledImageIOrbitImage orbitImage = new OrbitTiledImageIOrbitImage(tileSizeWrapper);
ColorModel cm2 = orbitImage.getColorModel()

TiledImagePainter mipMap = iFrame.getRecognitionFrame().bimg.getMipMaps()[4]
println mipMap.getHeight()
println mipMap.getWidth()
//final ColorModel colorModel_RGB = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB).getColorModel();

ColorModel cm = iFrame.getRecognitionFrame().getColorModel()
cm.createCompatibleWritableRaster(1,2)
java.awt.Rectangle rect = new Rectangle(mipMap.getWidth(),mipMap.getHeight())
FeatureDescription fd = new FeatureDescription()
BufferedImage bim = new BufferedImage(cm2, mipMap.getData(rect, fd).createCompatibleWritableRaster(), false, null)
Graphics2D g2d = bim.createGraphics()
PlanarImage pim = mipMap.getModifiedImage(fd)

g2d.drawImage(pim.getAsBufferedImage(),0,0, null);
g2d.dispose();

ImageIO.write(bim, "tiff", new File("D:/tmp/test.tiff"))
println "done"


//TiffWriter tiffWriter = new TiffWriter()
//tiffWriter.