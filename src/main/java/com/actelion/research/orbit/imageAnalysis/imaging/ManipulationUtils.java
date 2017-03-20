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

package com.actelion.research.orbit.imageAnalysis.imaging;

import ij.ImagePlus;
import ij.process.ImageProcessor;

import javax.media.jai.BorderExtender;
import javax.media.jai.ImageLayout;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

public class ManipulationUtils {

    public static byte clamp(int x) {
        if (x > 255) return (byte) 255;
        else if (x < 0) return 0;
        else return (byte) x;
    }

    /**
     * Defines RenderingHints for JAI create operations (otherwise JAI will use defaultTileSize tiling)
     *
     * @param image
     * @return
     */
    public static RenderingHints getRenderingHints(PlanarImage image) {
        ImageLayout layout = new ImageLayout(image.getMinX(), image.getMinY(), image.getWidth(), image.getHeight(), image.getTileGridXOffset(), image.getTileGridYOffset(), image.getTileWidth(), image.getTileHeight(), image.getSampleModel(), image.getColorModel());
        RenderingHints renderingHints = new RenderingHints(JAI.KEY_IMAGE_LAYOUT, layout);
        return renderingHints;
    }

    public static ImagePlus toImagePlus(PlanarImage source, Rectangle roi, BorderExtender border) {
        if (roi == null) roi = source.getBounds();
        Raster r = source.getExtendedData(roi, border);
        int numBands = source.getNumBands();
        BufferedImage bi = new BufferedImage(roi.width, roi.height, numBands == 1 ? BufferedImage.TYPE_BYTE_GRAY : BufferedImage.TYPE_INT_RGB);
        bi.setData(r);
        ImagePlus ip = new ImagePlus("IJManipulation", bi);
        return ip;
    }

    public static PlanarImage toPlanarImage(ImageProcessor ip) {
        return PlanarImage.wrapRenderedImage(ip.getBufferedImage());
    }

}
