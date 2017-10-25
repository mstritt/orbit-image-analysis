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

import com.actelion.research.orbit.beans.MinMaxPerChan;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.dal.localImage.ImageUtils;

import javax.imageio.ImageIO;
import javax.media.jai.PlanarImage;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.rmi.RemoteException;

public class NDPIImageNative extends AbstractOrbitImage {

    private ImageUtils imageUtils = null;
    private NDPICachingOrbitImageServerPyramid server = null;
    private final int NUM_TILE_TRIES = 5;


    public NDPIImageNative(String filename, int level) throws Exception {
        super(filename, level, false);
        logger.trace("loading NDPI image using native ndpi library: "+filename+" ["+level+"]");
        BufferedImage bi = new BufferedImage(getTileWidth(), getTileHeight(), BufferedImage.TYPE_3BYTE_BGR);
        PlanarImage image = PlanarImage.wrapRenderedImage(bi);
        if (image.getSampleModel() != null && (!image.getSampleModel().equals(sampleModel))) {
            this.sampleModel = image.getSampleModel();
        }
        if (level >= getNumLevels())
            throw new OrbitImageServletException("level " + level + " >= numLevels (" + getNumLevels() + ")");
    }

    private ImageUtils getImageUtils() {
        if (imageUtils == null) {
            imageUtils = new ImageUtils();
        }
        return imageUtils;
    }

    public synchronized NDPIOrbitImageServerPyramid getServer() {
        if (server ==null) {
            server =new NDPICachingOrbitImageServerPyramid(1000);
        }
        return server;
    }

    @Override
    public String readInfoString(String filename) throws OrbitImageServletException {
        try {
            System.out.println("file: "+this.filename);
            String info = getServer().getInfo(this.filename, level);
            return info;
        } catch (RemoteException e) {
            throw new OrbitImageServletException(e.getMessage() + "\nCause:" + e.getCause());
        }
    }


    @Override
    public MinMaxPerChan getMinMaxAnalysis() {
        return null;
    }

    @Override
    public boolean is16bit() {
        return false;
    }

    @Override
    public Raster getTile(int tileX, int tileY) {
        return getTileData(tileX, tileY, false);
    }


    @Override
    public Raster getTileData(int tileX, int tileY, boolean analysis) {
        try {
            byte[] data = null;
            int i = 0;
            while (data == null && i < NUM_TILE_TRIES) {
                i++;
                try {
                    data = getServer().getTile(filename, level, tileX, tileY);
                } catch (Exception eio) {
                    logger.debug("error loading tile, retrying... (" + i + ")");
                    data = null;
                    long ms = GRIDMODE ? 5000 : 200;
                    Thread.sleep(ms);
                }
            }
            if (GRIDMODE && data == null)
                throw new RuntimeException("error loading tile (even after " + NUM_TILE_TRIES + " tries)");
            //SeekableStream in = new ByteArraySeekableStream(data);
            //BufferedImage bi = ImageIO.read(in);
            BufferedImage bi = new BufferedImage(getTileWidth(), getTileHeight(), BufferedImage.TYPE_3BYTE_BGR);
           // BufferedImage bi = new BufferedImage(getTileWidth(), getTileHeight(), BufferedImage.TYPE_INT_RGB);
            getImageUtils().createImage(data, bi);
            PlanarImage image = PlanarImage.wrapRenderedImage(bi);

            if (image.getColorModel().getNumComponents() != 1) {
                if (image.getSampleModel() != null && (!image.getSampleModel().equals(sampleModel))) {
                    this.sampleModel = image.getSampleModel();
                }
            } else {
                originalWasGrayScale = true;
            }

            Raster r = image.getData().createTranslatedChild(PlanarImage.tileXToX(tileX, image.getTileGridXOffset(), tileWidth), PlanarImage.tileYToY(tileY, image.getTileGridYOffset(), tileHeight));

            return r;

        } catch (Exception e) {
            return null;
        }


    }

    @Override
    public BufferedImage getOverviewImage() {
        try {
            byte[] overview = getServer().getOverviewImage(filename);
            if (overview != null) {
                ByteArrayInputStream inputStream = new ByteArrayInputStream(overview);
                return ImageIO.read(inputStream);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // set path to ndp.read lib via e.g. -Djna.library.path=/u00/.../OrbitNDPI/libNDPread2.so
    public static void main(String[] args) throws Exception {
        NDPIImageNative img = new NDPIImageNative("D:\\pic\\Hamamatsu\\test\\test1.ndpi",5);
        System.out.println(img.readInfoString("D:\\pic\\Hamamatsu\\test\\test.ndpi"));
        WritableRaster raster = (WritableRaster) img.getTileData(1,0,true).createTranslatedChild(0,0);
        BufferedImage bi = new BufferedImage(img.getColorModel(),raster,false,null);
        ImageIO.write(bi,"png",new File("d:/test.png"));
        img.close();
    }
}