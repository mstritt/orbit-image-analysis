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

package com.actelion.research.orbit.imageAnalysis.imaging;

import com.actelion.research.orbit.imageAnalysis.utils.TiledImageWriter;
import ij.ImagePlus;

import javax.media.jai.PlanarImage;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class IJUtils {

    /**
     * Creats a binary ImagePlus based on a planar image. If a pixel is fg it is set to white, otherwise to black.
     *
     * @param image
     * @param fg
     * @return
     */
    public static ImagePlus toBinaryImagePlus(PlanarImage image, Color fg) {
        if (image == null || (image.getWidth() * image.getHeight() > 6000 * 6000L))
            throw new IllegalArgumentException("this implementation can only handle images where width*height<=6000*6000. (And image cannot be null)");
        int width = image.getWidth();
        int height = image.getHeight();
        Raster raster = image.getData();
        int[] arr = new int[4];

        // set background to black and foreground to white for imageJ watershed
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        int b = 0;
        for (int y = b; y < height - b; y++) {
            for (int x = b; x < width - b; x++) {
                arr = raster.getPixel(x, y, arr);
                if (arr[0] == fg.getRed() && arr[1] == fg.getGreen() && arr[2] == fg.getBlue()) {
                    bi.setRGB(x, y, Color.WHITE.getRGB());
                } else {
                    bi.setRGB(x, y, Color.BLACK.getRGB());
                }

            }
        }
        ImagePlus ip = new ImagePlus("watershed", bi);
        return ip;
    }


    /**
     * Creats a planar image based on an ImagePlus. The originalImage is just used for dimensions and tileSize (could be replaced by its int values).
     *
     * @param ip
     * @param originalImage
     * @param fg
     * @param bg
     * @return
     */
    public static PlanarImage toPlanarImage(ImagePlus ip, PlanarImage originalImage, Color fg, Color bg) {
        TiledImageWriter imageWriter = new TiledImageWriter(originalImage.getWidth(), originalImage.getHeight(), originalImage.getTileWidth(), originalImage.getTileHeight());

        // resImg
        Point[] tileArr = imageWriter.getImage().getTileIndices(null);
        int[] p = new int[4];
        int[] bgArr = new int[]{bg.getRed(), bg.getGreen(), bg.getBlue(), 255};
        int[] fgArr = new int[]{fg.getRed(), fg.getGreen(), fg.getBlue(), 255};
        for (Point tileNum : tileArr) {
            WritableRaster writeRaster = imageWriter.getImage().getWritableTile(tileNum.x, tileNum.y);
            for (int x = imageWriter.getImage().tileXToX(tileNum.x); x < Math.min(imageWriter.getImage().tileXToX(tileNum.x) + imageWriter.getImage().getTileWidth(), imageWriter.getImage().getWidth()); x++)
                for (int y = imageWriter.getImage().tileYToY(tileNum.y); y < Math.min(imageWriter.getImage().tileYToY(tileNum.y) + imageWriter.getImage().getTileHeight(), imageWriter.getImage().getHeight()); y++) {
                    p = ip.getPixel(x, y);
                    if (p[0] != 0) p = fgArr;
                    else p = bgArr;
                    writeRaster.setPixel(x, y, p);  // since it is not a gray-scale image, we just use the red channel
                } // x,y
            imageWriter.getImage().releaseWritableTile(tileNum.x, tileNum.y);
        } // tileNum

        return imageWriter.getImage();
    }


}
