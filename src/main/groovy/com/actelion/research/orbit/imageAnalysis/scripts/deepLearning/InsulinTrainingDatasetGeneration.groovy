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

/**
 * Load an image, iterate over tiles, access pixel data and compute mean intensities.
 * Here we check if a tile is in ROI-  if not, we skip the complete tile.
 * Tile check is fuzzy (just checks corners and center of the tile).
 * For a more accurate check modify the isTileInROI method...
 * Change image id!
 */

import com.actelion.research.orbit.beans.RawAnnotation
import com.actelion.research.orbit.beans.RawDataFile
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig
import com.actelion.research.orbit.imageAnalysis.imaging.TileSizeWrapper
import com.actelion.research.orbit.imageAnalysis.models.ImageAnnotation
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel
import com.actelion.research.orbit.imageAnalysis.models.PolygonExt
import com.actelion.research.orbit.imageAnalysis.models.ShapeAnnotationList
import com.actelion.research.orbit.imageAnalysis.tasks.ExclusionMapGen
import com.actelion.research.orbit.imageAnalysis.utils.OrbitImagePlanar
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImageIOrbitImage
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils

import javax.imageio.ImageIO
import java.awt.Point
import java.awt.image.BufferedImage
import java.awt.image.Raster
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

RawDataFile rdf = DALConfig.imageProvider.LoadRawDataFile(12885943);
RecognitionFrame recognitionFrame = new RecognitionFrame(rdf);
recognitionFrame.loadAnnotationROI(rdf.rawDataFileId,0);

// Insulin-Excl-Model: 2427791
rawAnnotationList = DALConfig.imageProvider.LoadRawAnnotationsByRawDataFile(rdf.rawDataFileId)
ShapeAnnotationList annoShapesRoi = new ShapeAnnotationList(rawAnnotationList,0,null)

exclModel = OrbitModel.LoadFromOrbit(2427791)
ExclusionMapGen exMapGen = ExclusionMapGen.constructExclusionMap(rdf,recognitionFrame,exclModel);
exMapGen.generateMap();

println("Starting analysis")

// TODO: Reset the output directory? Or at least stop execution if already contains data (UUIDs will change so
//  you'll get duplicates.

// File to write out the 'answers' to.
File outFile = new File("/home/fullejo1/test/stage1_test.csv")

List<String> dataLines = new ArrayList<>()

TileSizeWrapper tileSizeWrapper = new TileSizeWrapper(new OrbitImagePlanar(recognitionFrame.bimg.image, ""), 512, 512)
OrbitTiledImageIOrbitImage orbitImage = new OrbitTiledImageIOrbitImage(tileSizeWrapper)

recognitionFrame.bimg.image.getTileIndices(null).each {
    Point tileIdx = it
    // Look at all tiles in the image where the exclusion mask shows some tissue...
    if (OrbitUtils.isTileInROI((int)tileIdx.x,(int)tileIdx.y,recognitionFrame.bimg.image, annoShapesRoi,exMapGen)) {   // fuzzy! (but fast)
        Raster r = recognitionFrame.bimg.image.getTile((int) tileIdx.x, (int) tileIdx.y);

        BufferedImage bim = new BufferedImage(recognitionFrame.bimg.image.getColorModel(),
                r.createCompatibleWritableRaster(),
                recognitionFrame.bimg.image.getColorModel().isAlphaPremultiplied(),
                null)

        // Generate a UUID to write the image
        String tileUuid = UUID.randomUUID().toString()

        // Data for output file
        // ImageId,EncodedPixels,Height,Width,Usage
        // EncodedPixels is run length encoded.
        // Usage can be padded.
        dataLines.add({ tileUuid.toString() } as String)
        x = (int) it.getX() * 512
        y = (int) it.getY() * 512

        int minX = orbitImage.tileXToX((int) it.x)

        for(RawAnnotation raw : rawAnnotationList) {
            ImageAnnotation anno = new ImageAnnotation(raw)
            shape = anno.getShape().getShapeList()
            //println(shape.toString())
            poly = shape.get(0)
            if(anno.getSubType() == ImageAnnotation.SUBTYPE_ROI) {
                for (int i=0; i<512; i++ ) {
                    for (int j=0; j<512; j++) {
                        if (poly.contains(i+x,j+y)) {
                            println("Inside annotation! "+String.valueOf(i+x)+String.valueOf(j+y))
                        }
                    }
                }
            }

//            for (PolygonExt poly : shape) {
//                println(poly.listPoints())
//                poly.
//            }
        }

        annoShapesRoi
        // This is needed to write out the image correctly?
        bim.setData(r.getParent())


        Path outDir = Paths.get(String.format("/home/fullejo1/test/%s", tileUuid))
        Files.createDirectories(outDir)
        String outImage = String.format("%s/%s.png", outDir.toString(), tileUuid)
        ImageIO.write(bim,"png", new File(outImage))
    }
}

//println(dataLines.toString())

DALConfig.getImageProvider().close();  // only close if not executed within Orbit