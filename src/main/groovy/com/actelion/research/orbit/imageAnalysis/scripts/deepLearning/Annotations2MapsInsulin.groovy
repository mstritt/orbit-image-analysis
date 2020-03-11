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
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel
import com.actelion.research.orbit.imageAnalysis.models.ShapeAnnotationList
import com.actelion.research.orbit.imageAnalysis.tasks.ExclusionMapGen
import com.actelion.research.orbit.imageAnalysis.utils.OrbitImagePlanar
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImageIOrbitImage
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils
import com.actelion.research.orbit.utils.RawUtils

import javax.imageio.ImageIO
import java.awt.*
import java.awt.image.BufferedImage
import java.awt.image.Raster
import java.util.List
long total = 0

rdfRemote = DALConfig.getImageProvider().LoadRawDataFilesSearchFast("ELB0666-0002", 1000, [RawUtils.DATA_TYPE_IMAGE_NDPI]);
//images = []
//for (RawDataFile rdf : rdfRemote) {
//    images.add(rdf.getRawDataFileId())
//}
//println(images)

// All images from ELB0666-0002
images = [12885921, 12885920, 12885922, 12885923, 12885924,
          12885925, 12885928, 12885929, 12885930, 12885932,
          12885933, 12885936, 12885937, 12885938, 12885939,
          12885943, 12885944, 12885945, 12885946, 12885947,
          12885951, 12885952, 12885953, 12885954, 12885955,
          12885962, 12885963, 12885964, 12885965, 12885966,
          12885968, 12885972, 12885973, 12885974, 12885975,
          12885979, 12885980, 12885981, 12885982, 12885983,
          12885984, 12885985, 12885986, 12885987, 12885988,
          12885989, 12885990, 12885992, 12885993, 12885994,
          12885997, 12885998, 12885999, 12886000, 12886001,
          12886002, 12886003, 12886006, 12886007, 12886008,
          12886009, 12886010, 12886011, 12886012, 12886013,
          12886014, 12886015, 12886016, 12886017, 12886018,
          12886019, 12886020, 12886021, 12886022, 12886023,
          12886024, 12886028, 12886029, 12886032, 12886033,
          12886037, 12886039, 12886040]

// Remove these images (no annotations)
images.remove(images.indexOf(12885936))
images.remove(images.indexOf(12885981))

// this breaks the RMI server?
images.remove(images.indexOf(12886019))

train = images[0..49]
val = images[50..59]
test = images[60..79]

//images = [          // orbitIds to export
//                    12885943
//]

//rdfid: 12886019
//11:33:06.495 ERROR c.a.r.o.i.c.RecognitionFrame:559 - Error loading image. Probably the Orbit image server down or not accessible.
//Error Details:
//java.lang.NullPointerException: null
//at com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImageIOrbitImage.<init>(OrbitTiledImageIOrbitImage.java:42)
//at com.actelion.research.orbit.imageAnalysis.utils.TiledImagePainter.loadImage(TiledImagePainter.java:182)

imageWidth = 512
imageHeight = 512
tileWidth = 2048
tileHeight = 2048

def basedir = "/home/fullejo1/test/a2m/images"+imageWidth

colorDeconv = "H DAB FastRed"     // if deconvolution is needed
colorDeconvChannel = 0  // 0=disable, 1=first channel, 2=second channel, 3=comp

exclModel = OrbitModel.LoadFromOrbit(2427791)

def BufferedImage shrink(BufferedImage bi) {
    BufferedImage bi2 = new BufferedImage(imageWidth,imageHeight,BufferedImage.TYPE_INT_RGB)
    Graphics2D g = bi2.getGraphics()
    g.drawImage(bi,0,0,imageWidth,imageHeight,null)
    g.dispose()
    return bi2
}

File classFile = new File(basedir+"/classes.csv")
classFile.write("ImageId, EncodedPixels, Class, Annotation ID, Width, Height\n")

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
        if (ia.subType == ImageAnnotation.SUBTYPE_NORMAL) {
            //inclusions.add(ia.getFirstShape())
            rois.add(ia)
        }
        else if (ia.subType == ImageAnnotation.SUBTYPE_NORMAL) objects.add(ia)
        else if (ia.subType == ImageAnnotation.SUBTYPE_EXCLUSION) exclusions.add(ia.getFirstShape())
    }
    total += objects.size()
    RecognitionFrame rf = new RecognitionFrame(rdf)
    ExclusionMapGen exMapGen = ExclusionMapGen.constructExclusionMap(rdf,rf,exclModel);
    exMapGen.generateMap();
    println "ROIs: ${rois.size()}"
    println "objects: ${objects.size()}"
    String path = ""
    String dataset = ""
    if (train.contains(it)) {
        dataset = "train"
        path = basedir + File.separator + "train" + File.separator + rdfId
    } else if (val.contains(it)) {
        dataset = "validate"
        path = basedir + File.separator + "validate" + File.separator + rdfId
    } else if (test.contains(it)) {
        dataset = "test"
        path = basedir + File.separator + "test" + File.separator + rdfId
    }
    new File(path).mkdirs()
//    new File(path+File.separator+"images").mkdirs()
//    new File(path+File.separator+"masks").mkdirs()
    TileSizeWrapper tileSizeWrapper = new TileSizeWrapper(new OrbitImagePlanar(rf.bimg.image, ""), tileWidth, tileHeight)
    OrbitTiledImageIOrbitImage orbitImage = new OrbitTiledImageIOrbitImage(tileSizeWrapper)
    rois.each {
        ImageAnnotation ia = it
        IScaleableShape shape = it.getFirstShape()
        shape = shape.getScaledInstance(100d, new Point(0, 0))
        ShapeAnnotationList shapeList = new ShapeAnnotationList(inclusions,exclusions,shape,shape.bounds)
        Point[] tiles = orbitImage.getTileIndices(null)
        tiles.each {
            // TODO: Needed to add a random check in the method, since we really want to ask is ROI in Tile...
            if (OrbitUtils.isTileInROI((int) it.x, (int) it.y, orbitImage, shapeList, exMapGen)) {
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

                classFile.append(rdfId + "_tile" + tileX + "x" + tileY + ", RLE" + ", " + ia.description + ", " + ia.rawAnnotationId + ", " + dataset + ", " + imageWidth + ", " + imageHeight + "\n")
                println(rdfId + "_tile" + tileX + "x" + tileY + ", RLE" + ", " + ia.description + ", " + ia.rawAnnotationId + ", " + dataset + ", " + imageWidth + ", " + imageHeight)
                String imageId = rdfId + "_tile" + (int) it.x + "x" + (int) it.y
                File imageOutDir = new File(path + File.separator + imageId + File.separator + "images")
                imageOutDir.mkdirs()
                ImageIO.write(shrink(ori), "jpeg", new File(imageOutDir.toString() + File.separator + imageId + ".jpg"))

                // segmentation map
                IScaleableShape roiTranslated = shape.clone()
                roiTranslated.translate(-minX,-minY)
                BufferedImage seg = new BufferedImage(ori.width, ori.height, BufferedImage.TYPE_INT_RGB)
                Graphics2D g2d = (Graphics2D) seg.getGraphics()
                g2d.setColor(Color.blue)
                g2d.fill(roiTranslated)

                g2d.setColor(Color.white)
//                objects.each {
//                    IScaleableShape object = ((IScaleableShape) it.firstShape).getScaledInstance(100d, new Point(0, 0))
//
//                    Rectangle bounds = object.bounds
//                    Rectangle tileRect = orbitImage.getTileRect(tileX, tileY)
//                    if (bounds.intersects(tileRect.bounds) || tileRect.bounds.contains(bounds)) {
//                        object.translate(-minX, -minY)
//                        g2d.fill(object)
//                    }
//                }
                g2d.dispose()
                String maskId = imageId + "_" + ia.rawAnnotationId
                File maskOutDir = new File(path + File.separator + imageId + File.separator + "masks")
                maskOutDir.mkdirs()
                ImageIO.write(shrink(seg), "png", new File(maskOutDir.toString() + File.separator + maskId + "_seg.png"))

            }
            // TODO: This is in the wrong place at the moment, and it needs to make sure that only a limited
            //  amount of data is output...
//            else {
//                // Choose a tile that is not in the exclusion map, but doesn't contain any annotations.
//                if (OrbitUtils.isTileInROI((int) it.x, (int) it.y, orbitImage, null, exMapGen)) {
//                    int tileX = it.x
//                    int tileY = it.y
//                    // with deconvolution
//                    Raster tileRaster = orbitImage.getTile((int) it.x, (int) it.y, 100, 100, 0, 0, 0, 0, 0, null, null, null, null, true, true, true, colorDeconvChannel, colorDeconv, null, true, null)
//                    // or without deconvolution
//                    // Raster tileRaster = orbitImage.getTile((int) it.x, (int) it.y)
//                    int minX = orbitImage.tileXToX((int) it.x)
//                    int minY = orbitImage.tileYToY((int) it.y)
//                    tileRaster = tileRaster.createTranslatedChild(0, 0)
//                    BufferedImage ori = new BufferedImage(orbitImage.colorModel, tileRaster, false, null)
//                    ImageIO.write(shrink(ori), "jpeg", new File(path + File.separator + rdfId + "_negative_tile" + (int) it.x + "x" + (int) it.y + ".jpg"))
//                }
//            }
        }
    }
    println "---"
}
println "total: $total"
DALConfig.imageProvider.close()
