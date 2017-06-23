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

import com.actelion.research.orbit.beans.MinMaxPerChan;
import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import loci.formats.FormatException;
import loci.formats.gui.AWTImageTools;
import loci.formats.tiff.IFD;
import loci.formats.tiff.IFDList;
import loci.formats.tiff.TiffParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.media.jai.PlanarImage;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.io.File;
import java.io.IOException;

/**
 * Tiff image implementation, faster then via Bioformats.
 * In addition in handles the special tiff-pyramid format with several files: img.tif for fullr esolution, img.1.tiff for first layer (half resolution), .2.tiff for second layer and so on.
 */
public class OrbitImageTiff implements IOrbitImage {

    private static final Logger logger = LoggerFactory.getLogger(OrbitImageTiff.class);
    final int maxThumbWidth = 300;
    private String filename;
    private String originalFilename;
    private int tileWidth;
    private int tileHeight;
    private int numLevels;
    private int level;
    private ColorModel colorModel;
    private SampleModel sampleModel;
    private int numBands;
    private int numBandsOriginal;
    private int originalBitsPerSample;
    private boolean originalWasGrayScale;
    private int tileGridXOffset;
    private int tileGridYOffset;
    private int minX;
    private int minY;
    private long width;
    private long height;
    private ThreadLocal<TiffParser> tp;
    private IFD ifd;
    private ThreadLocal<byte[]> buffer;
    private boolean multiFileTiff = false;

    protected boolean signed = true;
    protected boolean interleaved = false;


    public OrbitImageTiff(final String filename, final int level) throws IOException, FormatException {
        this.filename = filename+"["+level+"]";
        this.level = level;
        String fn = null;

        // detect numLevels for multiFileTiff
        //if (level==0)
        {
            int n=0;
            String mipFileName;
            do {
                if (n>0) multiFileTiff = true;
                n++;
                mipFileName = filename.split("\\.")[0] + "." + n + "." + filename.split("\\.")[1];
            } while (new File(mipFileName).exists());
            numLevels = n;
        }

        logger.debug("numLevel: "+numLevels+" multiFileTiff: "+multiFileTiff);

        // open correct file for multiFileTiff
        if (multiFileTiff && level>0) {
            String mipFileName = filename.split("\\.")[0] + "." + level + "." + filename.split("\\.")[1];
            if (mipFileName != null) {
                logger.trace("trying pyramid file: " + mipFileName);
                File testFile = new File(mipFileName);
                if (testFile.exists()) {
                    fn = mipFileName;
                }
            }
        }

        final String fileToOpen = fn!=null? fn:filename;
        logger.trace("file to open: "+fileToOpen);
        this.originalFilename = fileToOpen;

        tp = new ThreadLocal<TiffParser>() {
            @Override
            protected TiffParser initialValue() {
                try {
                    return new TiffParser(fileToOpen);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
        if (tp.get()==null) throw new OrbitImageServletException("Tiffparser error, cannot open tiff file "+filename);

        if (!tp.get().isValidHeader()) {
            throw new OrbitImageServletException("not a valid tiff image ("+filename+")");
        }
        IFDList ifdList = tp.get().getIFDs();

        if (!multiFileTiff) this.numLevels =  ifdList.size();

        // check special .1, .2, ... files for levels


        if (fn==null && level>=numLevels) throw new OrbitImageServletException("Level "+level+" not available for image "+filename);

        ifd = ifdList.get(multiFileTiff? 0: level);

        this.width = ifd.getImageWidth();
        this.height = ifd.getImageLength();
        this.tileWidth = (int) ifd.getTileWidth();
        this.tileHeight = (int) ifd.getTileLength();

        this.numBands = ifd.getSamplesPerPixel();
        this.numBandsOriginal = ifd.getSamplesPerPixel();
        this.originalBitsPerSample = ifd.getBitsPerSample()[0];
        this.originalWasGrayScale = numBands==1;
        this.tileGridXOffset = 0;
        this.tileGridYOffset = 0;
        this.minX = 0;
        this.minY = 0;

//        if (this.originalBitsPerSample>=16) {
//            throw new FormatException("Cannot handle tiff files with >= 16 bits per sample");
//        }

        final int samples = numBands;
        buffer = new ThreadLocal<byte[]>() {
            @Override
            protected byte[] initialValue() {
                return new byte[tileWidth*tileHeight*samples];
            }
        };
    }

    @Override
    public String readInfoString(String filename) throws OrbitImageServletException {
        return "";
    }

    /**
     * Analysis is ignored here - works only for 8bit images
     */
    @Override
    public Raster getTileData(int tileX, int tileY, boolean analysis) {
        try {
            byte[] buf = buffer.get();
            byte[] data = tp.get().getTile(ifd,buf,tileY,tileX);
            BufferedImage image =getBufferedImage(data,tileWidth,tileHeight);

            // ensure tiles have always full tileWifth and tileHeight (even at borders)
            if (image.getWidth()!=getTileWidth() || image.getHeight()!=getTileHeight())
            {
                BufferedImage bi = new BufferedImage(getTileWidth(), getTileHeight(), BufferedImage.TYPE_INT_RGB);   // must be RGB
                bi.getGraphics().drawImage(image, 0, 0, null);
                image = bi;
            }

            Raster r = image.getData().createTranslatedChild(PlanarImage.tileXToX(tileX, image.getTileGridXOffset(), tileWidth), PlanarImage.tileYToY(tileY, image.getTileGridYOffset(), tileHeight));
            return r;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
    public BufferedImage getOverviewImage() {
        return null;
    }

    private BufferedImage getBufferedImage(final byte[] data, int planeWidth, int planeHeight) {
        BufferedImage bi;
        if (numBandsOriginal==1)
            bi = AWTImageTools.makeImage(data,planeWidth,planeHeight,signed);
        else {
            // for bitsPerSample>=16 this will downscale, but unfortunately via cutoff... in future Bioformats TiffReader should be user (but cannot handle resolutions currently (5.3.4))
            bi = AWTImageTools.makeRGBImage(data,numBandsOriginal,planeWidth,planeHeight,interleaved);
        }

        if (colorModel==null || sampleModel==null) {
            colorModel = bi.getColorModel();
            sampleModel = colorModel.createCompatibleSampleModel(tileWidth, tileHeight);
        }

        return bi;
    }


    @Override
    public String getFilename() {
        return filename;
    }

    @Override
    public int getTileWidth() {
        return tileWidth;
    }

    @Override
    public int getTileHeight() {
        return tileHeight;
    }

    public int getNumLevels() {
        return numLevels;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public ColorModel getColorModel() {
        if (colorModel==null) getTileData(0,0,false);    // initialize first time
        return colorModel;
    }

    @Override
    public SampleModel getSampleModel() {
        if (sampleModel==null) getTileData(0,0,false);   // initialize first time
        return sampleModel;
    }

    @Override
    public int getNumBands() {
        return numBands;
    }

    public int getNumBandsOriginal() {
        return numBandsOriginal;
    }

    @Override
    public int getOriginalBitsPerSample() {
        return originalBitsPerSample;
    }

    @Override
    public boolean getOriginalWasGrayScale() {
        return originalWasGrayScale;
    }

    @Override
    public int getTileGridXOffset() {
        return tileGridXOffset;
    }

    @Override
    public int getTileGridYOffset() {
        return tileGridYOffset;
    }

    @Override
    public int getMinX() {
        return minX;
    }

    @Override
    public int getMinY() {
        return minY;
    }

    @Override
    public int getWidth() {
        return (int) width;
    }

    @Override
    public int getHeight() {
        return (int) height;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public boolean isMultiFileTiff() {
        return multiFileTiff;
    }

    @Override
    public void close() throws IOException {

    }

    public IFD getIfd() {
        return ifd;
    }

    public BufferedImage getThumbnail() {
        int thumbLevel = numLevels;
        int thumbW=1;
        int thumbH=1;
        try {
            OrbitImageTiff imgLevel = null;
            for (int lev=numLevels-1; lev>=0; lev--) {
                 imgLevel = new OrbitImageTiff(originalFilename,lev);
                 thumbLevel = lev;
                 thumbW = (int) imgLevel.getIfd().getImageWidth();
                 thumbH = (int) imgLevel.getIfd().getImageLength();
                 double diff = Math.abs((thumbW/(double)thumbH) - (width/(double)height));
                 if (thumbW>maxThumbWidth && diff<0.001) break;
             }
            logger.trace("thumbnail level: "+thumbLevel+" size:"+thumbW+"x"+thumbH+ " (img: "+imgLevel.originalFilename+")");
            TiffParser tpThumb = imgLevel.getTp().get();
            byte[] buf = tpThumb.getSamples(imgLevel.getIfd(),new byte[thumbW*thumbH*numBands]);
            BufferedImage thumb = AWTImageTools.makeRGBImage(buf,numBandsOriginal,thumbW,thumbH,interleaved);
            if (thumbW>maxThumbWidth) {
                int h = (int)(maxThumbWidth * (thumbH/(double)thumbW));
                BufferedImage img = new BufferedImage(maxThumbWidth,h, BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = (Graphics2D) img.getGraphics();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2d.drawImage(thumb,0,0,maxThumbWidth,h, null);
                thumb = img;
            }
            return thumb;
        } catch (FormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ThreadLocal<TiffParser> getTp() {
        return tp;
    }

    @Override
    public String toString() {
        return "OrbitImageTiff{" +
                "filename='" + filename + '\'' +
                ", actualFilename=" + originalFilename +
                ", width=" + width +
                ", height=" + height +
                ", tileWidth=" + tileWidth +
                ", tileHeight=" + tileHeight +
                ", multiFileTiff=" + multiFileTiff +
                ", level=" + level +
                ", numLevels=" + numLevels +
                ", numBands=" + numBands +
                ", numBandsOriginal=" + numBandsOriginal +
                ", originalBitsPerSample=" + originalBitsPerSample +
                ", originalWasGrayScale=" + originalWasGrayScale +
                ", tileGridXOffset=" + tileGridXOffset +
                ", tileGridYOffset=" + tileGridYOffset +
                ", minX=" + minX +
                ", minY=" + minY +
                ", colorModel=" + colorModel +
                '}';
    }


}
