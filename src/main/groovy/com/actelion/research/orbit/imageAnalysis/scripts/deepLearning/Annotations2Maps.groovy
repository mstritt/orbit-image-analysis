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
 * For e.g. training a deep learning model based on annotations.
 * Exports tile maps with inside annotations white, outside annotations but still in ROI blue, black our of roi color coding.
 * Virtual 1024x1024 tiles on full res are used, then scaled to 512x512 tiles to work better with deep learning frameworks.
 */

import com.actelion.research.orbit.beans.RawAnnotation
import com.actelion.research.orbit.beans.RawDataFile
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig
import com.actelion.research.orbit.imageAnalysis.imaging.TileSizeWrapper
import com.actelion.research.orbit.imageAnalysis.models.IScaleableShape
import com.actelion.research.orbit.imageAnalysis.models.ImageAnnotation
import com.actelion.research.orbit.imageAnalysis.models.ShapeAnnotationList
import com.actelion.research.orbit.imageAnalysis.utils.OrbitImagePlanar
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImageIOrbitImage
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils

import javax.imageio.ImageIO
import java.awt.*
import java.awt.image.BufferedImage
import java.awt.image.Raster
import java.util.List
def basedir = "d:/export"
long total = 0

images = [          // orbitIds to export
    6533664,
    6533666
]

colorDeconv = "H DAB FastRed"     // if deconvolution is needed
colorDeconvChannel = 1  // 0=disable, 1=first channel, 2=second channel, 3=comp


def BufferedImage shrink(BufferedImage bi) {
    BufferedImage bi2 = new BufferedImage(512,512,BufferedImage.TYPE_INT_RGB)
    Graphics2D g = bi2.getGraphics()
    g.drawImage(bi,0,0,512,512,null)
    g.dispose()
    return bi2
}

images.each {
    int rdfId = it
    println "rdfid: " + rdfId
    RawDataFile rdf = DALConfig.imageProvider.LoadRawDataFile(rdfId)
    List<RawAnnotation> annotations = DALConfig.imageProvider.LoadRawAnnotationsByRawDataFile(rdfId, RawAnnotation.ANNOTATION_TYPE_IMAGE)
    List<ImageAnnotation> objects = new ArrayList<>(annotations.size())
    List<ImageAnnotation> rois = new ArrayList<>()
    List<Shape> exclusions = new ArrayList<>()
    List<Shape> inclusions = new ArrayList<>()
    annotations.each {
        ImageAnnotation ia = new ImageAnnotation(it)
        if (ia.subType == ImageAnnotation.SUBTYPE_ROI) rois.add(ia)
        else if (ia.subType == ImageAnnotation.SUBTYPE_NORMAL) objects.add(ia)
        else if (ia.subType == ImageAnnotation.SUBTYPE_EXCLUSION) exclusions.add(ia.getFirstShape())
    }
    total += objects.size()
    RecognitionFrame rf = new RecognitionFrame(rdf)
    println "ROIs: ${rois.size()}"
    println "objects: ${objects.size()}"
    String path = basedir + File.separator + rdfId
    new File(path).mkdirs()
    TileSizeWrapper tileSizeWrapper = new TileSizeWrapper(new OrbitImagePlanar(rf.bimg.image, ""), 1024, 1024)
    OrbitTiledImageIOrbitImage orbitImage = new OrbitTiledImageIOrbitImage(tileSizeWrapper)
    rois.each {
        ImageAnnotation ia = it
        IScaleableShape shape = it.getFirstShape()
        shape = shape.getScaledInstance(100d, new Point(0, 0))
        ShapeAnnotationList shapeList = new ShapeAnnotationList(inclusions,exclusions,shape,shape.bounds)
        Point[] tiles = orbitImage.getTileIndices(shape.bounds)
        tiles.each { 
            if (OrbitUtils.isTileInROI((int) it.x, (int) it.y, orbitImage, shapeList, null)) {
                // source image
                int tileX = it.x
                int tileY = it.y
                // with deconvolution
                Raster tileRaster = orbitImage.getTile((int) it.x, (int) it.y, 100, 100, 0, 0, 0, 0, 0, null, null, null, null, true, true, true, colorDeconvChannel, colorDeconv, null, true, null)
                // or without deconvolution
                // Raster tileRaster = orbitImage.getTile((int) it.x, (int) it.y)
                int minX = orbitImage.tileXToX((int) it.x)
                int minY = orbitImage.tileYToY((int) it.y)
                tileRaster = tileRaster.createTranslatedChild(0, 0)
                BufferedImage ori = new BufferedImage(orbitImage.colorModel, tileRaster, false, null)
                ImageIO.write(shrink(ori), "jpeg", new File(path + File.separator + rdfId + "_tile" + (int) it.x + "x" + (int) it.y + ".jpg"))

                // segmentation map
                IScaleableShape roiTranslated = shape.clone()
                roiTranslated.translate(-minX,-minY)
                BufferedImage seg = new BufferedImage(ori.width, ori.height, BufferedImage.TYPE_INT_RGB)
                Graphics2D g2d = (Graphics2D) seg.getGraphics()
                g2d.setColor(Color.blue)
                g2d.fill(roiTranslated)

                g2d.setColor(Color.white)
                objects.each {
                    IScaleableShape object = ((IScaleableShape) it.firstShape).getScaledInstance(100d, new Point(0, 0))
                    Rectangle bounds = object.bounds
                    Rectangle tileRect = orbitImage.getTileRect(tileX, tileY)
                    if (bounds.intersects(tileRect.bounds) || tileRect.bounds.contains(bounds)) {
                        object.translate(-minX, -minY)
                        g2d.fill(object)
                    }
                }

                g2d.dispose()
                ImageIO.write(shrink(seg), "png", new File(path + File.separator + rdfId + "_tile" + (int) it.x + "x" + (int) it.y + "_seg.png"))

            }
        }
    }
    println "---"
}
println "total: $total"
DALConfig.imageProvider.close()
