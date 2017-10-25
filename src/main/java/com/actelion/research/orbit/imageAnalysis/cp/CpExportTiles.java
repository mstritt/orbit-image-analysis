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

package com.actelion.research.orbit.imageAnalysis.cp;

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.IScaleableShape;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.models.RectangleExt;
import com.actelion.research.orbit.imageAnalysis.tasks.ExclusionMapGen;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImage2;
import com.actelion.research.orbit.utils.RawUtilsCommon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class CpExportTiles {

    private boolean multiBatch = true;
    final static boolean skipIfNoROI = false;
    final static int ANNOTATION_GROUP = 0;
    final static int numBatch = Runtime.getRuntime().availableProcessors();

    private final static Logger logger = LoggerFactory.getLogger(CpExportTiles.class);


    public void downloadTiles(String searchStr, String outDirName, String exclModelFile) throws Exception {
        List<RawDataFile> rdfList = DALConfig.getImageProvider().LoadRawDataFilesSearchFast(searchStr, 1000, Arrays.asList(RawUtilsCommon.fileTypesImage));
        OrbitModel exclModel = null;
        if (exclModelFile != null) {
            exclModel = OrbitModel.LoadFromFile(exclModelFile);
            //exclModel.setExclusionModel(exclModel); // exclMapGen will read the embedded exlcusion model
            logger.info("exclusion model loaded: " + exclModelFile);
        }
        downloadTiles(rdfList, outDirName, exclModel);
    }

    public void downloadTiles(final List<RawDataFile> rdfList, String outDirName, final OrbitModel exclModel) throws Exception {

        new File(outDirName).mkdirs();

        RecognitionFrame rf;
        int cnt = 0;
        int allCnt = 0;
        // TODO: multithreaded
        for (RawDataFile rdf : rdfList) {
            //if (rdf.getFileName().toLowerCase().contains("secab")) continue; // skip secAB files

            System.out.println("image: " + rdf.getFileName() + " [" + (allCnt + 1) + "/" + rdfList.size() + "]");
            rf = new RecognitionFrame(rdf, false);

            // build ROI
            rf.loadAnnotationROI(rdf.getRawDataFileId(), ANNOTATION_GROUP);
            IScaleableShape roi = rf.getROI();
            if (roi != null) {
                logger.trace("roi size: " + roi.getBounds());
            } else {
                logger.debug("!ROI not found for image " + rdf.getFileName());
                if (!skipIfNoROI) {
                    Rectangle re = rf.bimg.getImage().getBounds();
                    roi = new RectangleExt(re.x, re.y, re.width, re.height);
                } else {
                    continue;
                }
            }


            // build exclusion map
            ExclusionMapGen exclMap = null;
            if (exclModel != null) {
                exclMap = ExclusionMapGen.constructExclusionMap(rdf, rf, exclModel, roi); // roi is not used
                if (exclMap != null) {
                    exclMap.generateMap();
                    logger.debug("exclMap created");
                }
            }


            OrbitTiledImage2 img = rf.bimg.getImage();
            Point[] tiles = img.getTileIndices(roi.getBounds());
            for (Point tileInd : tiles) {
                Rectangle tileRect = img.getTileRect(tileInd.x, tileInd.y);
                if (!roi.contains(tileRect) && !roi.intersects(tileRect)) continue; // tile not in ROI, so skip!
                if (exclMap != null && exclMap.isExcluded(tileRect, 0.05d)) {
                    System.out.println("tile " + tileInd + " excluded");
                    continue;
                } else {
                    System.out.println("tile " + tileInd + " included");
                }
                Raster tile = img.getTile(tileInd.x, tileInd.y);
                BufferedImage bi = createImage(tile, null, img.getSampleModel(), img.getColorModel());
                String fn = rdf.getFileName();
                String ext = RawUtilsCommon.getExtension(fn);
                //fn = fn.replaceFirst("\\."+ext," \\$tile"+tileInd.x+"x"+tileInd.y+".jpg");
                fn = rdf.getRawDataFileId() + "$tile" + tileInd.x + "x" + tileInd.y + ".jpg";
                String outDirBatch = outDirName;
                if (multiBatch) {
                    int batch = cnt % numBatch;
                    outDirBatch = outDirName + File.separator + batch;
                    File dir = new File(outDirBatch);
                    if (!dir.exists()) {
                        dir.mkdirs();
                    }
                }
                ImageIO.write(bi, "JPEG", new File(outDirBatch + File.separator + fn));
                cnt++;
            }

            //	if (true) return;

            allCnt++;
        } // rdf

        System.out.println("done. Tiles written to " + outDirName);

    }


    private BufferedImage createImage(Raster r, BufferedImage bi, SampleModel sampleModel, ColorModel colorModel) {
        if (bi != null) return bi;
        try {
            DataBuffer dataBuffer = r.getDataBuffer();
            WritableRaster wr = Raster.createWritableRaster(sampleModel, dataBuffer, new Point(0, 0));
            BufferedImage bb = new BufferedImage(colorModel, wr, colorModel.isAlphaPremultiplied(), null);
            return bb;
        } catch (Throwable t) {
            t.printStackTrace();
            return null;
        }
    }

    public boolean isMultiBatch() {
        return multiBatch;
    }

    public void setMultiBatch(boolean multiBatch) {
        this.multiBatch = multiBatch;
    }
}
