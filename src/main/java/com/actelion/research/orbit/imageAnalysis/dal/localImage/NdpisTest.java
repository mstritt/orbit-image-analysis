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

package com.actelion.research.orbit.imageAnalysis.dal.localImage;

import loci.common.services.ServiceFactory;
import loci.formats.FormatTools;
import loci.formats.gui.BufferedImageReader;
import loci.formats.meta.IMetadata;
import loci.formats.services.OMEXMLService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class NdpisTest {

    public static void main(String[] args) throws Exception {
        //final String filename = "D:\\pic\\czi\\FL_5CH_2scenes_5z_online-jpegXR.czi";
        String filename = "D:\\pic\\Hamamatsu\\fl5\\CD68-Cy3.5_SMA-Cy5.5_Gal3-Fluorescein_Saline60_ELB0246-0376 - 2016-11-09 10.09.14.ndpis";
        //filename = "D:\\pic\\Hamamatsu\\brain.ndpi";
        int level = 4;
        NDPISReaderOrbit r = new NDPISReaderOrbit();
        //ImageReader r = new ImageReader();
        // r.setAllowOpenFiles(true);
        r.setFlattenedResolutions(false);

        ServiceFactory factory = new ServiceFactory();
        OMEXMLService service = factory.getInstance(OMEXMLService.class);
        IMetadata meta = service.createOMEXMLMetadata();
        r.setMetadataStore(meta);

        r.setId(filename);

     
        r.setResolution(level);

        System.out.println("size: "+r.getSizeX()+" x "+r.getSizeY());
        System.out.println("resolution count: "+r.getResolutionCount());
        System.out.println("bitsPerPixel: "+r.getBitsPerPixel());
        System.out.println("pixelType: "+r.getPixelType());
        System.out.println("isRGB: "+r.isRGB());
        System.out.println("rgbChannels: "+r.getRGBChannelCount());
        System.out.println("bpp: "+FormatTools.getBytesPerPixel(r.getPixelType()));
        System.out.println("effSizeC: "+r.getEffectiveSizeC());
        System.out.println("sizeC: "+r.getSizeC());

        BufferedImageReader bir = new BufferedImageReader(r);

        int numChan = bir.getSizeC();

        for (int c=0; c<r.getSizeC(); c++) {

            String channelName = meta.getChannelName(r.getSeries(),c);
            System.out.println("channel "+c+" name: "+channelName);

            //BufferedImage bi = bir.openImage(bir.getIndex(0,c,0),15000,20000,1024,1024);
            BufferedImage bi = bir.openImage(bir.getIndex(0,c,0),0,0,1024,1024);
            //bi = AWTImageTools.autoscale(bi,0 , 4000);
            ImageIO.write(bi,"jpeg",new File("d:/test+"+c+".jpg"));
        }

        bir.close();

    }

}
