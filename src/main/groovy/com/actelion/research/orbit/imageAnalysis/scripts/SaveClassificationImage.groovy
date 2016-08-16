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

import com.actelion.research.orbit.imageAnalysis.components.ImageFrame
import com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis
import com.actelion.research.orbit.imageAnalysis.utils.ClassImageRenderer
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImage2
import com.actelion.research.orbit.imageAnalysis.utils.TiledImagePainter

import javax.media.jai.TiledImage
import java.awt.image.BufferedImage

/**
 * Saves a downscaled classification image to disk. Similar to "Tools->Save classification image" functionality.
 */
int width = 2000;
def fn = "d:/test.jpg";

final OrbitImageAnalysis OIA = OrbitImageAnalysis.getInstance();
final ImageFrame iFrame = OIA.getIFrame();
final TiledImage classImg = iFrame.getRecognitionFrame().getClassImage().getImage();
OrbitTiledImage2 mainImgTmp = iFrame.getRecognitionFrame().bimg.getImage();
for (TiledImagePainter tip: iFrame.getRecognitionFrame().bimg.getMipMaps()) {
    // find a good resolution size
    if (tip.getWidth()>width)
        mainImgTmp = tip.getImage();
}
final OrbitTiledImage2 mainImg = mainImgTmp;
ClassImageRenderer renderer = new ClassImageRenderer();
int height = (int) (classImg.getHeight() * (width / (double) classImg.getWidth()));
println("start saving classification image to disk");
BufferedImage bi = renderer.downsample(classImg, mainImg, width, height);
renderer.saveToDisk(bi, fn);
println("done");

