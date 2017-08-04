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

package com.actelion.research.orbit.imageAnalysis.modules.mihc;

import com.actelion.research.orbit.imageAnalysis.dal.localImage.NDPISReaderOrbit;
import com.actelion.research.orbit.imageAnalysis.dal.localImage.NDPIUtils;
import loci.formats.FormatException;
import loci.formats.gui.BufferedImageReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class MIHCTest {
    private static final Logger logger = LoggerFactory.getLogger(MIHCTest.class);

    public static void main(String[] args) throws IOException, FormatException {
        String fn = "D:\\pic\\Hamamatsu\\fl8\\6188205.ndpis";
        int tx = 10;
        int ty = 10;
        NDPISReaderOrbit reader = new NDPISReaderOrbit();
        reader.setFlattenedResolutions(false);
        BufferedImageReader bir = new BufferedImageReader(reader);
        MIHCConfig conf = new MIHCConfig();
        reader.setId(fn);
        double[] gains = NDPIUtils.getExposureTimesGain(reader);
        logger.info("gains: "+ Arrays.toString(gains));
        reader.close();
        MultiplexImageReader mir = new MultiplexImageReader(bir,conf.channelNames6, conf.filterNewXeon6, conf.normGain6, gains);
        mir.setId(fn);
        System.out.println("image dimensions: "+reader.getSizeX()+","+reader.getSizeY());

        for (int c=0; c<reader.getSizeC(); c++) {
            long startt = System.currentTimeMillis();
            BufferedImage img = mir.openImage(c, 10000, 30000, 2000, 2000);
            long usedt = System.currentTimeMillis()-startt;
            System.out.println("used time for channel "+c+": "+usedt);
        }
        BufferedImage img = mir.openImage(2, 10000, 30000, 2000, 2000);
        ImageIO.write(img,"png",new File("d:/test.png"));
        reader.close();
    }
}
