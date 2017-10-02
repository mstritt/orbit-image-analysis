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

import com.actelion.research.orbit.beans.MinMaxPerChan;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImage2;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImageIOrbitImage;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.Weigher;
import sun.awt.image.ByteInterleavedRaster;

import javax.imageio.ImageIO;
import javax.media.jai.PlanarImage;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TileSizeWrapper implements IOrbitImage {

    protected int tileWidth;
    protected int tileHeight;
    protected SampleModel sampleModel;
    protected ColorModel colorModel;
    protected IOrbitImage image;
    //private PlanarImage pi;
    public Cache<TileDef,Raster> tileCache = CacheBuilder.
            newBuilder().
                    expireAfterWrite(7, TimeUnit.MINUTES).
                    maximumWeight(1024L*1024L*320).
                    weigher(new Weigher<TileDef, Raster>() {
                        @Override
                        public int weigh(TileDef key, Raster raster) {
                            return raster.getWidth()*raster.getHeight() * 3 * 4;
                        }
                    }).
                    build();

    public TileSizeWrapper(final IOrbitImage image, int tileWidth, int tileHeight) {
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.image = image;

//        BufferedImage bi = new BufferedImage(tileWidth,tileHeight,BufferedImage.TYPE_INT_RGB);
//        this.colorModel = bi.getColorModel();
//        this.sampleModel = bi.getSampleModel();

        //this.sampleModel = image.getSampleModel().createCompatibleSampleModel(tileWidth,tileHeight);
        this.sampleModel = new PlanarImage() {
            {
                colorModel = image.getColorModel();
                sampleModel = image.getSampleModel();
                width = image.getWidth();
                height = image.getHeight();
                tileWidth = image.getTileWidth();
                tileHeight = image.getTileHeight();
            }

            @Override
            public Raster getTile(int tileX, int tileY) {
                TileDef key = new TileDef(tileX,tileY,false);
                //Raster raster = null;
                Raster raster = tileCache.getIfPresent(key);
                if (raster==null) {
                    raster = image.getTileData(tileX,tileY,false);
                    tileCache.put(key,raster);
                }
                return raster;
            }

            @Override
            public int getTileWidth() {
                return image.getTileWidth();
            }

            @Override
            public int getTileHeight() {
                return image.getTileHeight();
            }

        }.getSampleModel().createCompatibleSampleModel(tileWidth,tileHeight);
//        BufferedImage bi2 = new BufferedImage(512,512,BufferedImage.TYPE_INT_RGB);
//        this.sampleModel = bi2.getSampleModel();
//        this.colorModel = bi2.getColorModel();


    }
    @Override
    public Raster getTileData(int tileX, int tileY, final boolean analysis) {
        PlanarImage pi = new PlanarImage() {
            {
                colorModel = image.getColorModel();
                sampleModel = image.getSampleModel();
                width = image.getWidth();
                height = image.getHeight();
                tileWidth = image.getTileWidth();
                tileHeight = image.getTileHeight();
            }

            @Override
            public Raster getTile(int tileX, int tileY) {
                TileDef key = new TileDef(tileX,tileY,analysis);
               // Raster raster = null;
                Raster raster = tileCache.getIfPresent(key);
                if (raster==null) {
                    raster = image.getTileData(tileX,tileY,analysis);
                    tileCache.put(key,raster);
                }
                return raster;
            }

            @Override
            public int getTileWidth() {
                return image.getTileWidth();
            }

            @Override
            public int getTileHeight() {
                return image.getTileHeight();
            }

        };
        int minTX = tileX * tileWidth;
        int minTY = tileY * tileHeight;
        Rectangle rect = new Rectangle(minTX,minTY,tileWidth,tileHeight);
        Raster r = pi.getData(rect);

        BufferedImage bi = new BufferedImage(pi.getColorModel(),((WritableRaster) r.createTranslatedChild(0,0)),false,null);
        BufferedImage bi2 = new BufferedImage(512,512,bi.getType());
        bi2.getGraphics().drawImage(bi,0,0,null);
        bi2.getGraphics().dispose();
        r = bi2.getRaster();
        r =  r.createTranslatedChild(PlanarImage.tileXToX(tileX, getTileGridXOffset(), getTileWidth()), PlanarImage.tileYToY(tileY, getTileGridYOffset(), getTileHeight()));
        return r;
    }

    @Override
    public String readInfoString(String filename) throws OrbitImageServletException {
        //return image.readInfoString(filename);
        return "";
    }

    @Override
    public MinMaxPerChan getMinMaxAnalysis() {
        return image.getMinMaxAnalysis();
    }

    @Override
    public boolean is16bit() {
        return image.is16bit();
    }

    @Override
    public BufferedImage getOverviewImage() {
        return image.getOverviewImage();
    }

    @Override
    public String getFilename() {
        return image.getFilename();
    }

    @Override
    public int getWidth() {
        return image.getWidth();
    }

    @Override
    public int getHeight() {
        return image.getHeight();
    }

    @Override
    public int getTileWidth() {
        return this.tileWidth;
    }

    @Override
    public int getTileHeight() {
        return this.tileHeight;
    }

    @Override
    public int getTileGridXOffset() {
       return image.getTileGridXOffset();
    }

    @Override
    public int getTileGridYOffset() {
       return image.getTileGridYOffset();
    }

    @Override
    public int getMinX() {
        return image.getMinX();
    }

    @Override
    public int getMinY() {
        return image.getMinY();
    }

    @Override
    public int getNumBands() {
        return image.getNumBands();
    }

    @Override
    public ColorModel getColorModel() {
        return image.getColorModel();
    }

    @Override
    public SampleModel getSampleModel() {
        //return image.getSampleModel().createCompatibleSampleModel(tileWidth,tileHeight);
         return this.sampleModel;
        
    }

    @Override
    public int getOriginalBitsPerSample() {
        return image.getOriginalBitsPerSample();
    }

    @Override
    public boolean getOriginalWasGrayScale() {
        return image.getOriginalWasGrayScale();
    }

    @Override
    public void close() throws IOException {
        image.close();
    }


    protected class TileDef {
        int tileX;
        int tileY;
        boolean analysis;

        public TileDef(int tileX, int tileY, boolean analysis) {
            this.tileX = tileX;
            this.tileY = tileY;
            this.analysis = analysis;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TileDef tileDef = (TileDef) o;

            if (tileX != tileDef.tileX) return false;
            if (tileY != tileDef.tileY) return false;
            return analysis == tileDef.analysis;
        }

        @Override
        public int hashCode() {
            int result = tileX;
            result = 31 * result + tileY;
            result = 31 * result + (analysis ? 1 : 0);
            return result;
        }
    }
    public static void main(String[] args) throws Exception {
        String testImage = "D:\\pic\\Hamamatsu\\bloodsmear.ndpi";

        RawDataFile rdf = DALConfig.getImageProvider().LoadRawDataFile(6184134);
        IOrbitImage oi = DALConfig.getImageProvider().createOrbitImage(rdf,0);

        //try (OrbitImageBioformats oi = new OrbitImageBioformats(testImage,2,0,null))
        {
            System.out.println("tileSize before: " + oi.getTileWidth() + " x " + oi.getTileHeight());

            TileSizeWrapper tw = new TileSizeWrapper(oi, 512, 512);
            OrbitTiledImage2 oit2 = new OrbitTiledImageIOrbitImage(tw,0);
            System.out.println("tileSize after: " + oit2.getTileWidth() + " x " + oit2.getTileHeight());

            for (int tx=20; tx<23; tx++)
                for (int ty=20; ty<23; ty++) {
                    WritableRaster raster = (WritableRaster)oit2.getTile(tx, ty);   //59,10
                    System.out.println("tx x ty: "+tx+" x "+ty+"  "+ "wxh: " + raster.getWidth() + " x " + raster.getHeight()+" scanlinestride: "+((ByteInterleavedRaster)raster).getScanlineStride()+"  oit2: "+((PixelInterleavedSampleModel)oit2.getSampleModel()).getScanlineStride());
                    raster = (WritableRaster) raster.createTranslatedChild(0, 0);
                    BufferedImage bi = new BufferedImage(oit2.getColorModel(), raster, false, null);
                    ImageIO.write(bi, "png", new File("d:/NoBackup/a/tile"+ tx+"x"+ty+".png"));
                }

        }

        oi.close();


    }
}
