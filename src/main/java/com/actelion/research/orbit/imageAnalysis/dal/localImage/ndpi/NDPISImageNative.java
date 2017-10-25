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

package com.actelion.research.orbit.imageAnalysis.dal.localImage.ndpi;

import loci.common.DataTools;
import loci.common.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;

public class NDPISImageNative extends AbstractChannelRendererOrbitImage {

    private static final Logger logger = LoggerFactory.getLogger(NDPISImageNative.class);
    private String[] ndpiFiles;
    private NDPIImageNative[] readers;
    private String[] channelNames;
    private int[] wavelength;
    private int[] bandUsed;

    public NDPISImageNative(String filename, int level) throws Exception {       // , IOrbitImage[] orbitImage, String[] channelNames, float[] channelContributions, boolean useCache
        super();
        Location parent = new Location(filename).getAbsoluteFile().getParentFile();
        String[] lines = DataTools.readFile(filename).split("\r\n");
        for (String line : lines) {
            int eq = line.indexOf('=');
            if (eq < 0) {
                continue;
            }
            String key = line.substring(0, eq).trim();
            String value = line.substring(eq + 1).trim();

            if (key.equals("NoImages")) {
                ndpiFiles = new String[Integer.parseInt(value)];
                readers = new NDPIImageNative[ndpiFiles.length];
                channelNames = new String[ndpiFiles.length];
                wavelength = new int[ndpiFiles.length];
                bandUsed = new int[ndpiFiles.length];
            }
            else if (key.startsWith("Image")) {
                int index = Integer.parseInt(key.replaceAll("Image", ""));
                ndpiFiles[index] = new Location(parent, value).getAbsolutePath();
                readers[index] = new NDPIImageNative(ndpiFiles[index],level);
                NDPIOrbitImageServerPyramid.ImageData imageData = readers[index].getServer().getImageData(ndpiFiles[index],true,true);
                channelNames[index] = imageData.meta.channelNames.get(0);
                wavelength[index] = imageData.meta.wavelength;
                bandUsed[index] = 0;
                if (380 < wavelength[index] && wavelength[index] <= 490) bandUsed[index] = 2;
                else if (490 < wavelength[index] && wavelength[index] <= 580) bandUsed[index] = 1;
                else if (580 < wavelength[index] && wavelength[index] <= 780) bandUsed[index] = 0;
                logger.trace("reader "+index+": "+channelNames[index]+" wl: "+wavelength[index]+" bandUsed: "+bandUsed[index]);
            }
        }

        float[] channelContributions = null;
        boolean useCache = true;

        init(filename,level,readers,channelNames,channelContributions,useCache);
    }

 

    @Override
    protected int getBandUsed(int c) {
        return bandUsed[c];
    }

    public static void main(String[] args) throws Exception {
        NDPISImageNative img = new NDPISImageNative("D:\\pic\\Hamamatsu\\fl5ome\\test3.ndpis",0);
        System.out.println("info: "+img.readInfoString("D:\\pic\\Hamamatsu\\fl5ome\\test3.ndpis")+" width x height: "+img.getWidth()+" x "+img.getHeight());
        WritableRaster raster = (WritableRaster) img.getTileData(0,0,true).createTranslatedChild(0,0);
        BufferedImage bi = new BufferedImage(img.getColorModel(),raster,false,null);
        ImageIO.write(bi,"png",new File("d:/test.png"));
        img.close();
    }

}
