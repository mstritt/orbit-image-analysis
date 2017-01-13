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
 * Run an IMageJ macro on each tile of the image in the valid ROI.
 */
import com.actelion.research.orbit.beans.RawDataFile
import com.actelion.research.orbit.imageAnalysis.components.ImageFrame
import com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils
import ij.IJ
import ij.ImagePlus
import ij.WindowManager

import java.awt.*
import java.awt.image.BufferedImage
import java.awt.image.DataBuffer
import java.awt.image.Raster
import java.awt.image.WritableRaster


final OrbitImageAnalysis OIA = OrbitImageAnalysis.getInstance(); // get the current (running) Orbit instance
ImageFrame iFrame = OIA.getIFrame();
RecognitionFrame recognitionFrame = iFrame.recognitionFrame;
RawDataFile rdf = iFrame.rdf;
recognitionFrame.loadAnnotationROI(rdf.rawDataFileId,0);

recognitionFrame.bimg.image.getTileIndices(null).each {
    Point tileIdx = it;
    if (OrbitUtils.isTileInROI((int)tileIdx.x,(int)tileIdx.y,recognitionFrame.bimg.image,null,null)) {   // fuzzy! (but fast)
        Raster r = recognitionFrame.bimg.image.getTile((int) tileIdx.x, (int) tileIdx.y);
        BufferedImage bi = createBufferedImage(r,recognitionFrame);
        ImagePlus ip = new ImagePlus("tile",bi);
        WindowManager.setTempCurrentImage(ip);
        String output = IJ.runMacro(
                "getRawStatistics(count, mean, min, max, std); " +
                "return 'mean intensity: '+mean");
        // or: IJ.runMacroFile("macro.txt")
        // print statements will go to orbit.out.log in your home directory
        print output;
    }
}

DALConfig.getImageProvider().close();  // only close if not executed within Orbit


/**
 * Can be replaced with recognitionFrame.createBufferedImage since Orbit >= 2.44
 */
public BufferedImage createBufferedImage(final Raster r, RecognitionFrame rf) {
    WritableRaster writableRaster = r.createCompatibleWritableRaster(r.getWidth(),r.getHeight());
    writableRaster.setDataElements(0, 0, r.createTranslatedChild(0,0));
    DataBuffer dataBuffer = writableRaster.getDataBuffer();
    WritableRaster wr = Raster.createWritableRaster(rf.bimg.image.getColorModel().createCompatibleSampleModel(writableRaster.getWidth(),writableRaster.getHeight()),
            dataBuffer, new Point(0, 0));
    BufferedImage bi = new BufferedImage(rf.bimg.image.getColorModel(),
            wr,
            rf.bimg.image.getColorModel().isAlphaPremultiplied(),
            null);
    return bi;
}