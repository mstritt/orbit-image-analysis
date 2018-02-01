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

package com.actelion.research.orbit.imageAnalysis.dal.localImage;

import loci.formats.FormatException;
import loci.formats.in.NDPIReader;
import loci.formats.tiff.IFD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;

public class NDPIUtils {

    private static final Logger logger = LoggerFactory.getLogger(NDPIUtils.class);
    private final static int TAG_NDPI_ExposureRatio = 65435; // slong
    private final static int TAG_NDPI_GainMultiplierRed = 65436;  // slong
    private final static int TAG_NDPI_GainMultiplierGreen = 65437;  // slong
    private final static int TAG_NDPI_GainMultiplierBlue = 65438;  // slong

    public static double[] getExposureTimesGain(NDPISReaderOrbit r) {
        double[] gains = new double[r.getSizeC()];
        for (int c=0; c<r.getSizeC(); c++) {
            gains[c] = getExposureTimesGain(r.getReaders()[c]);
        }
        return gains;
    }


    protected static double getExposureTimesGain(NDPIReader r) {
        IFD ifd = r.getIFDs().get(0);
        Long exposure = (Long) ifd.getIFDValue(TAG_NDPI_ExposureRatio);
        Long gainRed = (Long) ifd.getIFDValue(TAG_NDPI_GainMultiplierRed);
        Long gainGreen = (Long) ifd.getIFDValue(TAG_NDPI_GainMultiplierGreen);
        Long gainBlue = (Long) ifd.getIFDValue(TAG_NDPI_GainMultiplierBlue);
        if (logger.isTraceEnabled())
        {
            logger.trace(r.getCurrentFile() + ": exposure=" + exposure + " gainRed=" + gainRed + " gainGreen=" + gainGreen + " gainBlue=" + gainBlue);
        }

        long gR = gainRed!=null? gainRed : 1;
        long gG = gainGreen!=null? gainGreen : 1;
        long gB = gainBlue!=null ? gainBlue : 1;
        long exp = exposure!=null ? exposure : 1;

        long maxG = gR;
        if (gB>maxG) maxG = gB;
        if (gG>maxG) maxG = gG;

        double expTimesGain = exp * maxG;
        return expTimesGain;
    }

    public static void main(String[] args) throws IOException, FormatException {
        NDPISReaderOrbit r = new NDPISReaderOrbit();
        r.setId("D:\\pic\\Hamamatsu\\Scan_Manuel\\Staining-DAPI-Cy5.5-FITC-scan all channels fix.ndpis");
        System.out.println(Arrays.toString(getExposureTimesGain(r)));
        r.close();
    }

}
