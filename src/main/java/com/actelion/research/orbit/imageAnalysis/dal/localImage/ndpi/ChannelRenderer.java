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

package com.actelion.research.orbit.imageAnalysis.dal.localImage.ndpi;

import com.actelion.research.orbit.utils.ChannelToHue;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import loci.formats.gui.AWTImageTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public abstract class ChannelRenderer {

    private static final Logger logger = LoggerFactory.getLogger(ChannelRenderer.class);
    protected String filename; // just for cache-key
    protected int level; // just for cache-key
    protected int width;
    protected int height;
    protected int tileWidth;
    protected int tileHeight;
    protected boolean isRGB;
    protected int sizeC;
    protected String[] channelNames;
    protected boolean is16bit;
    protected ColorModel colorModel;
    protected FilenameSeries minMaxKey;
    protected int series = 0;
    protected int zpos = 0;
    private AtomicLong hueUpdateTime = new AtomicLong(0);

    protected static final Map<FilenameSeries,MinMaxPerChan> minMaxCache = new ConcurrentHashMap<>();
    private float[] channelContributions = null;
    private float[] hueMap;
    private boolean useCache = true;
    public static final Cache<ROIDef, BufferedImage> tileCache = CacheBuilder.
            newBuilder().
            maximumSize(100). // 100 tiles  - should be enough to fill a screen
            expireAfterWrite(10, TimeUnit.MINUTES).
            build();

    /**
     * call init() afterwards
     */
    public ChannelRenderer() {

    }

    public void init(String filename, int level, int width, int height, int tileWidth, int tileHeight, boolean isRGB, int sizeC, String[] channelNames, boolean is16bit, ColorModel colorModel, float[] channelContributions, boolean useCache) {
        this.filename = filename;
        this.level = level;
        this.width = width;
        this.height = height;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.isRGB = isRGB;
        this.sizeC = sizeC;
        this.channelNames = channelNames;
        this.is16bit = is16bit;
        this.colorModel = colorModel;
        this.channelContributions = channelContributions;
        this.useCache = useCache;
        this.minMaxKey = new FilenameSeries(filename,series);
        hueMap = getHues();
    }


    public ChannelRenderer(String filename, int level, int width, int height, int tileWidth, int tileHeight, boolean isRGB, int sizeC, String[] channelNames, boolean is16bit, ColorModel colorModel, float[] channelContributions, boolean useCache) {
        this.filename = filename;
        this.level = level;
        this.width = width;
        this.height = height;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.isRGB = isRGB;
        this.sizeC = sizeC;
        this.channelNames = channelNames;
        this.is16bit = is16bit;
        this.colorModel = colorModel;
        this.channelContributions = channelContributions;
        this.useCache = useCache;
        this.minMaxKey = new FilenameSeries(filename,series);
        hueMap = getHues();
    }

    protected abstract WritableRaster getTileData(int c, int tileX, int tileY);
    protected abstract int getBandUsed(int c);

    private int getIndex(int c) {
        return series * zpos + c;
    }


    private BufferedImage raster2bufferedImage(WritableRaster wr) {
        BufferedImage bi = new BufferedImage(colorModel,wr.createWritableTranslatedChild(0,0),colorModel.isAlphaPremultiplied(),null);
        return bi;
    }


    public BufferedImage getPlane(int tileX, int tileY, final float[] channelContributions, boolean analysis,final float[] analysisHues) throws Exception {
        if (analysis && analysisHues!=null) {
            hueMap = analysisHues;
        } else {
            if (ChannelToHue.lastUpdate.get() > hueUpdateTime.get()) {
                hueMap = getHues();
            }
        }
        int x = tileWidth * tileX;
        int y = tileHeight * tileY;
        int w = (int) Math.min(tileWidth, width - x);
        int h = (int) Math.min(tileHeight, height - y);

        if (channelNames==null || channelNames.length<=1) {   // brightfield or just one grayscale channel
            WritableRaster wr = getTileData(0,tileX,tileY);
            BufferedImage bi = raster2bufferedImage(wr);
            if (bi!=null && bi.getType()==BufferedImage.TYPE_INT_RGB) return bi;
            else {
                if (is16bit) {   // TODO: set in init
                    int minIntens = minMaxCache.get(minMaxKey).getMin()[0];
                    int maxIntens = minMaxCache.get(minMaxKey).getMax()[0];
                    bi = AWTImageTools.autoscale(bi,minIntens,maxIntens);
                }
                BufferedImage biRGB = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
                biRGB.getGraphics().drawImage(bi, 0, 0, null);
                return biRGB;
            }
        }
        else {   // fluo -> merge channels
            BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            WritableRaster raster = bi.getRaster();
            int col;
            int[] pix = new int[3];
            for (int c = 0; c < sizeC; c++) {
                if (isChannelActive(c,channelContributions,analysis)) {
                    int index = getIndex(c);
                    ROIDef roiDef = new ROIDef(filename,level, index,x,y,w,h);
                    BufferedImage bit = useCache? ChannelRenderer.tileCache.getIfPresent(roiDef): null;
                    if (logger.isTraceEnabled())
                        logger.trace("CacheRenderer cache hit: "+(bit!=null)+" for tile "+tileX+"/"+tileY+" channel:"+c + " level:"+level);
                    if (bit==null) {
                        WritableRaster wr = getTileData(c,tileX,tileY);
                        bit = raster2bufferedImage(wr);;
                        if (useCache) ChannelRenderer.tileCache.put(roiDef,bit);
                    }
                    //bit = AWTImageTools.autoscale(bit,minMaxCache.get(key).getMin()[c] , minMaxCache.get(key).getMax()[c]);
                    Object pixels = AWTImageTools.getPixels(bit, 0, 0, 1, 1);
                    int minIntens = 0;
                    int maxIntens = 256;
                    if (is16bit) {
                        minIntens = minMaxCache.get(minMaxKey).getMin()[c];
                        maxIntens = minMaxCache.get(minMaxKey).getMax()[c];
                    }
                    for (int iy = 0; iy < h; iy++) {
                        for (int ix = 0; ix < w; ix++) {
                            int s = 0;
                            if (getBandUsed(c) >= 0) {   // single band read (should be the case for ndpi fluo files
                                int intens = bit.getRaster().getSample(ix, iy, getBandUsed(c));
                                if (is16bit) {
                                    intens = autoscale(intens, pixels, minIntens, maxIntens);
                                }
                                s += intens;
                            } else {    // multi band read -> aggregate
                                for (int b = 0; b < bit.getSampleModel().getNumBands(); b++) {
                                    int intens = bit.getRaster().getSample(ix, iy, b);
                                    if (is16bit) {
                                        intens = autoscale(intens, pixels, minIntens, maxIntens);
                                    }
                                    s += intens;
                                }
                            }

                            if (channelContributions!=null) {
                                s *= channelContributions[c];
                            }
                            int intens = s <= 255 ? s : 255;
                            pix = raster.getPixel(ix, iy, pix);

                            col = Color.HSBtoRGB(hueMap[c], 1f, intens / 255f);
                            pix[0] += (col >> 16) & 0xFF;    // red
                            pix[1] += (col >> 8) & 0xFF;  // green
                            pix[2] += col & 0xFF;    // blue
                            if (pix[0] > 255) pix[0] = 255;
                            if (pix[1] > 255) pix[1] = 255;
                            if (pix[2] > 255) pix[2] = 255;

                            raster.setPixel(ix, iy, pix);
                        }
                    }
                } // channelActive?
            }  // channels
            return bi;
        }  // fluo
    }



    /**
     *  see AWTImageTools.autoscale()
     */
    private int autoscale(int s, Object pixels, int min, int max) {
        int out;
        if (pixels instanceof byte[][]) return s;
        else if (pixels instanceof short[][]) {

            if (s < 0) s += 32767;
            int diff = max - min;
            float dist = (float) (s - min) / diff;

            if (s >= max) out = 255;
            else if (s <= min) out = 0;
            else out = (int) (dist * 256);

            return out;
        } else if (pixels instanceof int[][]) {

            if (s >= max) out = 255;
            else if (s <= min) out = 0;
            else {
                int diff = max - min;
                float dist = (s - min) / diff;
                out = (int) (dist * 256);
            }

            return out;
        } else if (pixels instanceof float[][]) {

            if (s >= max) out = 255;
            else if (s <= min) out = 0;
            else {
                int diff = max - min;
                float dist = (s - min) / diff;
                out = (int) (dist * 256);
            }

            return out;
        } else if (pixels instanceof double[][]) {

            if (s >= max) out = 255;
            else if (s <= min) out = 0;
            else {
                int diff = max - min;
                float dist = (float) (s - min) / diff;
                out = (int) (dist * 256);
            }

            return out;
        }
        return s;
    }

    public String[] getChannelNames() {
        return channelNames;
    }

    public void setChannelNames(String[] channelNames) {
        this.channelNames = channelNames;
    }

    public float[] getChannelContributions() {
        return channelContributions;
    }

    public void setChannelContributions(float[] contributions) {
        if (contributions==null) {
            channelContributions = null;
            return;
        }
        if (channelContributions==null) {
            channelContributions = new float[contributions.length];
        }
        System.arraycopy(contributions,0,channelContributions, 0, contributions.length);
    }

    public float[] getHues() {
        if (channelNames==null) return null;
        float[] hues = new float[channelNames.length];
        for (int c=0; c<channelNames.length; c++) {
            hues[c] = ChannelToHue.getHue(channelNames[c].toLowerCase());
        }
        hueUpdateTime.set(ChannelToHue.lastUpdate.get());
        return hues;
    }

    public void setHues(float[] hues) {
        // not implemented
    }

    public int getLevel() {
        return level;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getTileWidth() {
        return tileWidth;
    }

    public int getTileHeight() {
        return tileHeight;
    }

    protected boolean isChannelActive(final int c, final float[] channelContributions, final boolean analysis) {
        final float[] cc = (analysis||channelContributions!=null)?channelContributions:this.channelContributions;
        if (cc==null) return true;  // if nothing is set we assume all channels should be active
        if (cc.length <= c) {
            throw new IllegalArgumentException("channelContributions length is "+cc.length+" but requested channel is "+c);
        }
        return Math.abs(cc[c])>0.00001f;
    }

    public class FilenameSeries {
        String filename;
        int series;

        public FilenameSeries(String filename, int series) {
            this.filename = filename;
            this.series = series;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public int getSeries() {
            return series;
        }

        public void setSeries(int series) {
            this.series = series;
        }


        public float[] getHues() {
            if (channelNames==null) return null;
            float[] hues = new float[channelNames.length];
            for (int c=0; c<channelNames.length; c++) {
                hues[c] = ChannelToHue.getHue(channelNames[c].toLowerCase());
            }
            hueUpdateTime.set(ChannelToHue.lastUpdate.get());
            return hues;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            FilenameSeries that = (FilenameSeries) o;

            if (series != that.series) return false;
            return filename != null ? filename.equals(that.filename) : that.filename == null;
        }

        @Override
        public int hashCode() {
            int result = filename != null ? filename.hashCode() : 0;
            result = 31 * result + series;
            return result;
        }
    }

    public static class MinMaxPerChan {
        private int[] min;
        private int[] max;

        public MinMaxPerChan(int[] min, int[] max) {
            this.min = min;
            this.max = max;
        }

        public int[] getMin() {
            return min;
        }

        public void setMin(int[] min) {
            this.min = min;
        }

        public int[] getMax() {
            return max;
        }

        public void setMax(int[] max) {
            this.max = max;
        }
    }


    private class ROIDef {
        String filename;
        int level,index,x,y,w,h;

        public ROIDef(String filename, int level, int index, int x, int y, int w, int h) {
            this.filename = filename;
            this.level = level;
            this.index = index;
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }

        @Override
        public String toString() {
            return "ROIDef{" +
                    "filename='" + filename + '\'' +
                    ", level=" + level +
                    ", index=" + index +
                    ", x=" + x +
                    ", y=" + y +
                    ", w=" + w +
                    ", h=" + h +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ROIDef roiDef = (ROIDef) o;

            if (level != roiDef.level) return false;
            if (index != roiDef.index) return false;
            if (x != roiDef.x) return false;
            if (y != roiDef.y) return false;
            if (w != roiDef.w) return false;
            if (h != roiDef.h) return false;
            return filename != null ? filename.equals(roiDef.filename) : roiDef.filename == null;
        }

        @Override
        public int hashCode() {
            int result = filename != null ? filename.hashCode() : 0;
            result = 31 * result + level;
            result = 31 * result + index;
            result = 31 * result + x;
            result = 31 * result + y;
            result = 31 * result + w;
            result = 31 * result + h;
            return result;
        }
    }




}
