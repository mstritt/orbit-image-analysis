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

package com.actelion.research.orbit.imageAnalysis.utils;

import com.sun.media.jai.codec.JPEGEncodeParam;
import org.jaitools.tiledimage.DiskMemImageOrbit;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.TiledImage;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class ClassImageRenderer {

    private static int width = 10000;
    private static int height = 8000;
    private static int tileWidth = 512;
    private static int tileHeight = 512;

    public TiledImage generateTestImage(int width, int height) {
        DiskMemImageOrbit.getCommonTileCache().setMemoryCapacity(OrbitUtils.DISK_IMAGE_CACHE);
        JAI.getDefaultInstance().getTileCache().setMemoryCapacity(OrbitUtils.PLANAR_IMAGE_CACHE);
        int xOffs = 0;
        int yOffs = 0;
        ColorModel colorModel = new ComponentColorModel(
                ColorSpace.getInstance(ColorSpace.CS_sRGB),
                new int[]{8, 8, 8, 8}, true, false,
                Transparency.TRANSLUCENT,
                DataBuffer.TYPE_BYTE);
        SampleModel sampleModel = colorModel.createCompatibleSampleModel(tileWidth, tileHeight);
        DiskMemImageOrbit image = new DiskMemImageOrbit(xOffs, yOffs, width, height, 0, 0, sampleModel, colorModel);
        image.setUseCommonCache(true);
        int tiMaxX = image.XToTileX(width - 1);
        int tiMaxY = image.YToTileY(height - 1);

        int x;
        int y;
        int g = 0;
        for (int tx = 0; tx < tiMaxX; tx++) {
            for (int ty = 0; ty < tiMaxY; ty++) {
                WritableRaster tile = image.getWritableTile(tx, ty);
                for (int rx = tile.getMinX(); rx < tile.getMinX() + tile.getWidth(); rx++) {
                    for (int ry = tile.getMinY(); ry < tile.getMinY() + tile.getHeight(); ry++) {
                        x = rx;
                        y = ry;
                        tile.setSample(x, y, 0, (int) ((x / (float) width) * 255f) - g);
                        tile.setSample(x, y, 1, g);
                        tile.setSample(x, y, 2, (int) ((y / (float) height) * 255));
                        tile.setSample(x, y, 3, 255);

                    }
                }
                image.releaseWritableTile(tx, ty);
            }
        }

        return image;
    }

    /**
     * Downsamples classImage to specified size. If pixel value is black (0,0,0) it uses the pixel value of altImage instead if altImage is not null and white (255,255,255) otherwise.
     *
     * @param classImage
     * @param altImage
     * @param width
     * @param height
     * @return
     */
    public BufferedImage downsample(TiledImage classImage, OrbitTiledImage2 altImage, int width, int height) {
//		if (altImage!=null && (altImage.getWidth()!=classImage.getWidth() || altImage.getHeight()!=classImage.getHeight())) {
//			throw new IllegalArgumentException("Classification image and alternative image have different dimensions");
//		}
        double scaleX = classImage.getWidth() / (double) width;
        double scaleY = classImage.getHeight() / (double) height;
        double scaleXAlt = altImage.getWidth() / (double) width;
        double scaleYAlt = altImage.getHeight() / (double) height;

        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        WritableRaster r = bi.getRaster();
        int ix;
        int iy;
        int tileX;
        int tileY;
        Raster t;
        int ixAlt;
        int iyAlt;
        int tileXAlt;
        int tileYAlt;
        Raster tAlt;
        int c0;
        int c1;
        int c2;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                ix = (int) (x * scaleX);
                iy = (int) (y * scaleY);
                tileX = classImage.XToTileX(ix);
                tileY = classImage.YToTileY(iy);
                t = classImage.getTile(tileX, tileY);
                c0 = t.getSample(ix, iy, 0);
                c1 = t.getSample(ix, iy, 1);
                c2 = t.getSample(ix, iy, 2);
                if (c0 == 0 && c1 == 0 && c2 == 0) {    // not yet assigned, so use altImage or white (instead of black) for better printing
                    if (altImage != null) {
                        ixAlt = (int) (x * scaleXAlt);
                        iyAlt = (int) (y * scaleYAlt);
                        tileXAlt = altImage.XToTileX(ixAlt);
                        tileYAlt = altImage.YToTileY(iyAlt);
                        tAlt = altImage.getTile(tileXAlt, tileYAlt);
                        c0 = tAlt.getSample(ixAlt, iyAlt, 0);
                        c1 = tAlt.getSample(ixAlt, iyAlt, 1);
                        c2 = tAlt.getSample(ixAlt, iyAlt, 2);
                    } else {
                        c0 = 255;
                        c1 = 255;
                        c2 = 255;
                    }
                }
                r.setSample(x, y, 0, c0);
                r.setSample(x, y, 1, c1);
                r.setSample(x, y, 2, c2);
            }
        }
        return bi;
    }

    public void saveToDisk(TiledImage ti, String fn) throws IOException {
        BufferedImage buffImg = new BufferedImage(ti.getWidth(), ti.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g2d = buffImg.getGraphics();
        g2d.drawImage(ti.getAsBufferedImage(), 0, 0, null);
        buffImg.flush();

        JPEGEncodeParam jpgParam = new JPEGEncodeParam();
        jpgParam.setQuality(0.85f);
        JAI.create("filestore", buffImg, fn, "JPEG", jpgParam);
    }

    public void saveToDisk(BufferedImage bi, String fn) throws IOException {
//		JPEGEncodeParam jpgParam = new JPEGEncodeParam();
//		jpgParam.setQuality(0.85f);
//		JAI.create("filestore", bi, fn, "JPEG", jpgParam);
        ImageIO.write(bi, "JPEG", new File(fn));
    }

    public static void main(String[] args) throws IOException {
        ClassImageRenderer renderer = new ClassImageRenderer();
        TiledImage ti = renderer.generateTestImage(width, height);
        BufferedImage bi = renderer.downsample(ti, null, 800, 600);
        renderer.saveToDisk(bi, "d:/test.jpg");
    }

}
