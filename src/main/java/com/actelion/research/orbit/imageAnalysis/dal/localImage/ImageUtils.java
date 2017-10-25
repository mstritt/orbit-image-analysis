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

package com.actelion.research.orbit.imageAnalysis.dal.localImage;

import org.libjpegturbo.turbojpeg.TJ;
import org.libjpegturbo.turbojpeg.TJDecompressor;
import org.scijava.nativelib.NativeLibraryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class ImageUtils {

    private static final Logger logger = LoggerFactory.getLogger(ImageUtils.class);
    private static final String NATIVE_LIB_CLASS = "org.scijava.nativelib.NativeLibraryUtil";
    private static boolean libraryLoaded = false;
    public static AtomicBoolean useTJ = new AtomicBoolean(true);

    public ImageUtils() {
            if (!libraryLoaded) {
                NativeLibraryUtil.loadNativeLibrary(TJ.class, "turbojpeg");
                libraryLoaded = true;
                logger.info("native turbojpeg lib successfully loaded");
            }
    }

    /**
     * Decompresses jpeg data as a BufferedImage using turbojpeg with imageIO as fallback.
     * BufferedImage must be initialized with correct width and height.
     */
    public void createImage(byte[] data, BufferedImage bi) throws Exception {
        if (useTJ.get()) {
            try {
                int pixelType = TJ.PF_RGB;
                //int pixelSize = TJ.getPixelSize(pixelType);
                TJDecompressor decoder = new TJDecompressor(data);
                decoder.decompress(bi, pixelType);
                decoder.close();
            } catch (UnsatisfiedLinkError e) {
                useTJ.set(false);
                logger.info("TurboJPEG not working, using ImageIO as fallback");
            }
        }

        if (!useTJ.get()) {
            ByteArrayInputStream in = new ByteArrayInputStream(data);
            BufferedImage temp = ImageIO.read(in);
            in.close();
            bi.setData(temp.getData());
        }

    }

}
