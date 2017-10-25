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

import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.dal.IOrbitImageMultiChannel;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;

import javax.media.jai.PlanarImage;
import java.awt.image.*;
import java.io.IOException;
import java.util.Arrays;

public abstract class AbstractChannelRendererOrbitImage extends ChannelRenderer implements IOrbitImageMultiChannel {
    private IOrbitImage[] orbitImage;
    private SampleModel sampleModel = null;
    final static private ColorModel colorModel_3BYTE_BGR = new BufferedImage(1,1,BufferedImage.TYPE_3BYTE_BGR).getColorModel();
    final static private ColorModel colorModel_RGB = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB).getColorModel();
    final static protected boolean isRGB = true;
    final static protected int numBands = 3;

    /**
     * call init() afterwards
     */
    public AbstractChannelRendererOrbitImage() {
        super();
    }

    public void init(String filename, int level, IOrbitImage[] orbitImage, String[] channelNames, float[] channelContributions, boolean useCache) {
        super.init(filename, level, orbitImage[0].getWidth(), orbitImage[0].getHeight(), orbitImage[0].getTileWidth(), orbitImage[0].getTileHeight(), isRGB, orbitImage.length, channelNames, orbitImage[0].is16bit(), colorModel_RGB, channelContributions, useCache);
        this.orbitImage = orbitImage;
    }


    public AbstractChannelRendererOrbitImage(String filename, int level, IOrbitImage[] orbitImage, String[] channelNames, float[] channelContributions, boolean useCache) {
        super(filename, level, orbitImage[0].getWidth(), orbitImage[0].getHeight(), orbitImage[0].getTileWidth(), orbitImage[0].getTileHeight(), isRGB, orbitImage.length, channelNames, orbitImage[0].is16bit(), colorModel_RGB, channelContributions, useCache);
        this.orbitImage = orbitImage;
    }

    private WritableRaster getWritableRaster(final int tileX, final int tileY, final WritableRaster wr, final ColorModel colorModelIn) {
        WritableRaster wr2 = (WritableRaster) wr.createTranslatedChild(0,0);
        BufferedImage bi1 = new BufferedImage(colorModelIn,wr2,false,null);
        BufferedImage bi = new BufferedImage(wr2.getWidth(),wr2.getHeight(),BufferedImage.TYPE_INT_RGB);
        bi.getGraphics().drawImage(bi1,0,0,null);
        bi.getGraphics().dispose();
        // ensure tiles have always full tileWifth and tileHeight (even at borders)
        if (bi.getWidth()!=getTileWidth() || bi.getHeight()!=getTileHeight())
        {
            BufferedImage bi2 = new BufferedImage(getTileWidth(), getTileHeight(), BufferedImage.TYPE_INT_RGB);   // must be RGB
            bi2.getGraphics().drawImage(bi, 0, 0, null);
            bi = bi2;
        }
        return (WritableRaster) bi.getRaster().createTranslatedChild(PlanarImage.tileXToX(tileX, 0, tileWidth), PlanarImage.tileYToY(tileY, 0, tileHeight));
    }

    @Override
    protected WritableRaster getTileData(int c, int tileX, int tileY) {
        WritableRaster wr = (WritableRaster) orbitImage[c].getTileData(tileX,tileY,false);
        return getWritableRaster(tileX, tileY, wr, colorModel_3BYTE_BGR);
    }

    @Override
    public Raster getTileData(int tileX, int tileY, float[] channelContributions, boolean analysis, float[] analysisHues) {
        try {
            WritableRaster wr = getPlane(tileX,tileY,channelContributions,analysis,analysisHues).getRaster();  
            return getWritableRaster(tileX,tileY,wr, colorModel_RGB);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ColorModel getColorModel() {
        return colorModel_RGB;
    }

    @Override
    public String readInfoString(String filename) throws OrbitImageServletException {
        return "";
    }

    @Override
    public Raster getTileData(int tileX, int tileY, boolean analysis) {
        return getTileData(tileX,tileY,null,analysis,null);
    }

    @Override
    public com.actelion.research.orbit.beans.MinMaxPerChan getMinMaxAnalysis() {
        int[] min = new int[orbitImage.length];
        int[] max = new int[orbitImage.length];
        Arrays.fill(max,255);
        return new com.actelion.research.orbit.beans.MinMaxPerChan(min,max); // TODO
    }

    @Override
    public boolean is16bit() {
        return super.is16bit;
    }

    @Override
    public BufferedImage getOverviewImage() {
        return orbitImage[0].getOverviewImage(); // TODO
    }

    @Override
    public String getFilename() {
        return this.filename;
    }

    @Override
    public int getTileGridXOffset() {
        return orbitImage[0].getTileGridXOffset();
    }

    @Override
    public int getTileGridYOffset() {
        return orbitImage[0].getTileGridYOffset();
    }

    @Override
    public int getMinX() {
        return orbitImage[0].getMinX();
    }

    @Override
    public int getMinY() {
        return orbitImage[0].getMinY();
    }

    @Override
    public int getNumBands() {
        return numBands;
    }

    @Override
    public synchronized SampleModel getSampleModel() {
        if (sampleModel==null) {
            sampleModel = colorModel_RGB.createCompatibleSampleModel(tileWidth,tileHeight);
        }
        return sampleModel;
    }

    @Override
    public float[] getHues() {
        return super.getHues();
    }

    @Override
    public void setHues(float[] hues) {
        super.setHues(hues);
    }

    @Override
    public int getOriginalBitsPerSample() {
        return orbitImage[0].getOriginalBitsPerSample();
    }

    @Override
    public boolean getOriginalWasGrayScale() {
        return orbitImage[0].getOriginalWasGrayScale();
    }

    @Override
    public void close() throws IOException {
        for (IOrbitImage image: orbitImage) {
            image.close();
        }
    }
}
