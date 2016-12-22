/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2016 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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

import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImage2;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImageIOrbitImage;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import edu.emory.mathcs.backport.java.util.Collections;
import loci.common.services.ServiceFactory;
import loci.formats.FormatException;
import loci.formats.IFormatReader;
import loci.formats.ImageReader;
import loci.formats.MinMaxCalculator;
import loci.formats.gui.AWTImageTools;
import loci.formats.gui.BufferedImageReader;
import loci.formats.meta.IMetadata;
import loci.formats.services.OMEXMLService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.media.jai.PlanarImage;
import java.awt.*;
import java.awt.image.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OrbitImageBioformats implements IOrbitImage {

    private static final Logger logger = LoggerFactory.getLogger(OrbitImageBioformats.class);
    final int maxThumbWidth = 300;
    final protected ThreadLocal<BufferedImageReader> reader;
    final List<BufferedImageReader> allReaders = Collections.synchronizedList(new ArrayList<BufferedImageReader>());
    private String filename;
    private String originalFilename;
    private int optimalTileWidth;
    private int optimalTileHeight;
    private int numLevels;
    private int level;
    private boolean interleaved;
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
    private boolean is16bit = false;
    protected static final Map<String,MinMaxPerChan> minMaxCache = new ConcurrentHashMap<>();
    private List<String> channelNames;
    protected static final ColorModel rgbColorModel = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB).getColorModel();
    public static int exclicitSeries = 0;

    private static final float HueAlexa594 = 0f / 360f;
    private static final float HueCy3 = 40f / 360f;
    private static final float HueCy5 = 0f / 360f;  // 60
    private static final float HueEGFP = 141f / 360f;
    private static final float HueDAPI = 202f / 360f;
    private static final float HueFITC = 108f / 360f;
    private static final float HueTRITC = 22f / 360f;



    public OrbitImageBioformats(final String filename, final int level) throws IOException, FormatException {
        this.originalFilename = filename;
        this.filename = filename+"["+level+"]"+" ["+exclicitSeries+"]";    // level/series here is important because filename is part of key for hashing!
        this.level = level;

        logger.info("bioformats image: "+this.filename);

        reader = new ThreadLocal<BufferedImageReader>() {
            @Override
            protected BufferedImageReader initialValue() {
                try {
                    logger.debug("init bioformats: "+filename+" ["+level+"]"+" ["+exclicitSeries+"]");
                    ImageReader r = new ImageReader();
                    //r.setAllowOpenFiles(false);
                    r.setFlattenedResolutions(false);
                    ServiceFactory factory = new ServiceFactory();
                    OMEXMLService service = factory.getInstance(OMEXMLService.class);
                    IMetadata meta = service.createOMEXMLMetadata();
                    r.setMetadataStore(meta);

                    r.setId(filename);


                    int series = 0;
                    if (!filename.toLowerCase().endsWith("vsi")) {
                        String[] file2series = r.getSeriesUsedFiles();
                        if (file2series != null && file2series.length > 0) {
                            for (int i = 0; i < file2series.length; i++) {
                                String fn = file2series[i];
                                if (fn.equals(r.getCurrentFile())) {
                                    series = i;
                                    logger.debug("selected series: " + series);
                                }
                            }
                            r.setSeries(series);
                        }
                    }

                    // explicit series
                    // com.actelion.research.orbit.imageAnalysis.dal.localImage.OrbitImageBioformats.exclicitSeries=0
                    if (exclicitSeries >0) r.setSeries(exclicitSeries);

                    r.setResolution(level);
                    BufferedImageReader bir;
                    if (doMergeChannels(r)) {
                        // fluo images

                        if (channelNames==null) {
                            channelNames = new ArrayList<>(r.getSizeC());
                            for (int c=0; c<r.getSizeC(); c++) {
                               // System.out.println("c="+c+" idx="+idx);
                                String name = meta.getChannelName(r.getSeries(),c);
                                if (name==null) name = "Channel"+c;
                                System.out.println("channel name "+c+": "+name);
                                channelNames.add(name);
                            }
                        }

                        is16bit = r.getBitsPerPixel()>=16;
                        logger.debug("is16bit: "+is16bit);

                        synchronized (minMaxCache) {
                            if (is16bit && !minMaxCache.containsKey((originalFilename)))
                            {
                                MinMaxCalculator minMax = new MinMaxCalculator(r);
                                minMax.setResolution(minMax.getResolutionCount() - 1);
                                int[] nos = minMax.getZCTCoords(0);
                                int z = nos[0], t = nos[2];
                                for (int ic=0; ic<minMax.getSizeC(); ic++) {
                                    int idx = minMax.getIndex(z, ic, t);
                                    minMax.openBytes(idx); // needed to make min,max available
                                }

                                int[] min = new int[r.getSizeC()];
                                int[] max = new int[r.getSizeC()];
                                for (int c = 0; c < minMax.getSizeC(); c++) {
                                    Double tmin = minMax.getChannelKnownMinimum(c);
                                    Double tmax = minMax.getChannelKnownMaximum(c);
                                    min[c] = (int) tmin.doubleValue();
                                    max[c] = (int) tmax.doubleValue();
                                    logger.info("minIntens: "+min[c]+" maxIntens: "+max[c]+" channel: "+c);
                                }
                                minMaxCache.put(originalFilename,new MinMaxPerChan(min,max));

                                minMax.setResolution(level);

                                bir = BufferedImageReader.makeBufferedImageReader(minMax);
                            } else bir = BufferedImageReader.makeBufferedImageReader(r);
                        }

                    } else {
                        // brightfield
                        bir = BufferedImageReader.makeBufferedImageReader(r);
                    }
                    synchronized (allReaders) {
                        allReaders.add(bir); // remember for closing
                    }
                    return bir;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };

        numLevels =  reader.get().getResolutionCount();
        //numLevels = getRealResolutionCount(reader.get());

        logger.debug("actual level: "+this.level+" / numLevels: "+numLevels);
        boolean levelOk;
        do {
            levelOk = true;
            if (this.level >= numLevels) {
                close();
                throw new OrbitImageServletException("image pyramid level " + this.level + " does not exist for image " + filename);
            }

            width = reader.get().getSizeX();
            height = reader.get().getSizeY();
            numBandsOriginal = reader.get().getSizeC();

//            int optimalTileWidth2 = OrbitUtils.TILE_SIZE_DEFAULT;
//            int optimalTileHeight2 = OrbitUtils.TILE_SIZE_DEFAULT;
//            String ending = RawUtilsCommon.getExtension(filename, true);
//            if (ending.equals("png") || ending.equals("jpg") || ending.equals("jpeg") || ending.equals("gif") || ending.equals("bmp")
//                    || ((width * height) <= (2048L * 2048L))) {
//                optimalTileWidth2 = (int) width;
//                optimalTileHeight2 = (int) height;
//            }
//            optimalTileWidth = optimalTileWidth2;
//            optimalTileHeight = optimalTileHeight2;


            BufferedImageReader bir = reader.get();
            if (bir.getResolution()!=this.level) bir.setResolution(this.level);
            optimalTileWidth = bir.getOptimalTileWidth();
            optimalTileHeight = bir.getOptimalTileHeight();
            if (optimalTileWidth< OrbitUtils.TILE_SIZE_DEFAULT && width>=OrbitUtils.TILE_SIZE_DEFAULT) optimalTileWidth = OrbitUtils.TILE_SIZE_DEFAULT;
            if (optimalTileHeight< OrbitUtils.TILE_SIZE_DEFAULT && height>=OrbitUtils.TILE_SIZE_DEFAULT) optimalTileHeight = OrbitUtils.TILE_SIZE_DEFAULT;


            logger.debug("optimal tile size: "+optimalTileWidth+" x "+optimalTileHeight);


            originalBitsPerSample = bir.getBitsPerPixel();
            interleaved = bir.isInterleaved();
            try {
                BufferedImage img = getPlane(0, 0);
                colorModel = img.getColorModel();
                sampleModel = img.getSampleModel();
                numBands = sampleModel.getNumBands();
                originalWasGrayScale = numBands==1;
                tileGridXOffset = img.getTileGridXOffset();
                tileGridYOffset = img.getTileGridYOffset();
                minX = img.getMinX();
                minY = img.getMinY();
            } catch (Exception e) {
                if (this.level<numLevels-1) {
                    this.level++;
                    synchronized (allReaders) {
                        for (IFormatReader r : allReaders) {
                            r.setResolution(this.level);
                        }
                    }
                    levelOk=false;
                    logger.debug("error loading level "+this.level+" trying next level");
                }  else {
                    e.printStackTrace();
                    throw new OrbitImageServletException("error loading level " + this.level + " (and not more alternative levels available). File: "+filename);
                }
            }

        } while (!levelOk);

        logger.info(filename+" loaded ["+width+" x "+height+"]");
    }

    private int getIndex(IFormatReader r, int channel) {
        int[] nos = r.getZCTCoords(0);
        int z = nos[0], t = nos[2];
        return r.getIndex(z,channel,t);
    }

    private boolean doMergeChannels(IFormatReader r) {
        int c = r.getSizeC();
       // return c > 1;
        return c > 1 && !r.isRGB();
       // return c > 1 && c <= 4 && !r.isRGB();
    }

    @Deprecated
    private int getRealResolutionCount(IFormatReader imageReader) throws IOException, FormatException {
        ImageReader ir = new ImageReader();
        ir.setFlattenedResolutions(false);
        ir.setId(imageReader.getCurrentFile());
        ir.setSeries(imageReader.getSeries());
        int numRes = 1;
        for (int lev=imageReader.getResolutionCount()-1; lev>=0; lev--) {
            numRes = lev;
            ir.setResolution(lev);
            int thumbW = ir.getSizeX();
            int thumbH = ir.getSizeY();
            double diff = Math.abs((thumbW/(double)thumbH) - (imageReader.getSizeX()/(double)imageReader.getSizeY()));
            System.out.println("diff: "+diff);
            if (diff<0.001) break;
        }
        ir.close();
        return numRes;
    }


    @Override
    public String readInfoString(String filename) throws OrbitImageServletException {
        return "";
    }

    @Override
    public Raster getTileData(int tileX, int tileY) {
        try {
           BufferedImage img = getPlane(tileX, tileY);
           // ensure tiles have always full tileWidth and tileHeight (even at borders)
           if (img.getWidth()!=getTileWidth() || img.getHeight()!=getTileHeight())
           {
               BufferedImage bi = new BufferedImage(getTileWidth(), getTileHeight(), img.getType());
               bi.getGraphics().drawImage(img, 0, 0, null);
               img = bi;
           }

          // set correct bounds
          Raster r = img.getData().createTranslatedChild(PlanarImage.tileXToX(tileX, img.getTileGridXOffset(), getTileWidth()), PlanarImage.tileYToY(tileY, img.getTileGridYOffset(), getTileHeight()));
          return r;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected BufferedImage getPlane(int tileX, int tileY) throws Exception {
        int x = optimalTileWidth * tileX;
        int y = optimalTileHeight * tileY;
        int w = (int) Math.min(optimalTileWidth, width - x);
        int h = (int) Math.min(optimalTileHeight, height - y);
        BufferedImageReader bir = reader.get();
        if (bir.getResolution()!=this.level) bir.setResolution(this.level);

        if (!doMergeChannels(bir)) {   // brightfield
            return bir.openImage(0,x,y,w,h);
        }
        else {   // fluo -> merge channels
            BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            WritableRaster raster = bi.getRaster();
            int no = 0;
            int sizeC = reader.get().getSizeC();
            int[] nos = reader.get().getZCTCoords(no);
            int z = nos[0], t = nos[2];
            int col;
            int[] pix = new int[3];
            for (int c = 0; c < sizeC; c++) {
                BufferedImage bit = reader.get().openImage(reader.get().getIndex(z, c, t), x, y, w, h);
                //bit = AWTImageTools.autoscale(bit,minMaxCache.get(originalFilename).getMin()[c] , minMaxCache.get(originalFilename).getMax()[c]);
                Object pixels = AWTImageTools.getPixels(bit, 0, 0, 1, 1);
                int minIntens = 0;
                int maxIntens = 256;
                if (is16bit) {
                    minIntens = minMaxCache.get(originalFilename).getMin()[c];
                    maxIntens = minMaxCache.get(originalFilename).getMax()[c];
                }
                for (int iy = 0; iy < h; iy++) {
                    for (int ix = 0; ix < w; ix++) {
                        int s = 0;
                        for (int b = 0; b < bit.getSampleModel().getNumBands(); b++) {
                            int intens = bit.getRaster().getSample(ix, iy, 0);
                            if (is16bit) {
                                intens = autoscale(intens, pixels, minIntens, maxIntens);
                            }
                            s += intens;
                        }
                        int intens = s <= 255 ? s : 255;
                        float hue = getHue(c);
                        pix = raster.getPixel(ix, iy, pix);

                        col = Color.HSBtoRGB(hue, 1f, intens / 255f);
                        pix[0] += (col >> 16) & 0xFF;    // red
                        pix[1] += (col >> 8) & 0xFF;  // green
                        pix[2] += col & 0xFF;    // blue
                        if (pix[0] > 255) pix[0] = 255;
                        if (pix[1] > 255) pix[1] = 255;
                        if (pix[2] > 255) pix[2] = 255;

                        raster.setPixel(ix, iy, pix);
                    }
                }
            }  // channels
            return bi;
        }  // fluo
    }

    private float getHue(int c) {
        float hue;
        switch (channelNames.get(c).toLowerCase()) {
            case "alexa fluor 594": {
                hue = HueAlexa594;
                break;
            }
            case "cy3": {
                hue = HueCy3;
                break;
            }
            case "cy5": {
                hue = HueCy5;
                break;
            }
            case "egfp": {
                hue = HueEGFP;
                break;
            }
            case "dapi": {
                hue = HueDAPI;
                break;
            }
            case "fitc": {
                hue = HueFITC;
                break;
            }
            case "tritc": {
                hue = HueTRITC;
                break;
            }
            case "channel0": {
                hue = HueDAPI;
                break;
            }
            case "channel1": {
                hue = HueFITC;
                break;
            }
            case "channel2": {
                hue = HueTRITC;
                break;
            }
            case "channel3": {
                hue = HueCy5;
                break;
            }
            default: {
                hue = HueDAPI;
                break;
            }
        }
        return hue;
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



    @Override
    public String getFilename() {
        return filename;
    }

    @Override
    public int getWidth() {
        return (int) width;
    }

    @Override
    public int getHeight() {
        return (int) height;
    }

    @Override
    public int getTileWidth() {
        return optimalTileWidth;
    }

    @Override
    public int getTileHeight() {
        return optimalTileHeight;
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
    public int getNumBands() {
        return numBands;
    }

    @Override
    public ColorModel getColorModel() {
        return rgbColorModel;
    }

    @Override
    public SampleModel getSampleModel() {
        return rgbColorModel.createCompatibleSampleModel(optimalTileWidth,optimalTileHeight);
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
    public void close() throws IOException {
        synchronized (allReaders) {
            for (IFormatReader r: allReaders) {
                try {
                    r.close();
                } catch (Exception e) {
                }
            }
        }
    }




    public int getNumLevels() {
        return numLevels;
    }

    public int getLevel() {
        return level;
    }


    public BufferedImage getThumbnail() {
         long thumbW=1;
         long thumbH=1;

        try {
            ImageReader ir = new ImageReader();
            ir.setFlattenedResolutions(false);
            ir.setId(reader.get().getCurrentFile());
            ir.setSeries(reader.get().getSeries());

            for (int lev=numLevels-1; lev>=0; lev--) {
                ir.setResolution(lev);
                thumbW = ir.getSizeX();
                thumbH = ir.getSizeY();
                double diff = Math.abs((thumbW/(double)thumbH) - (width/(double)height));
                logger.trace("thumb lev: "+lev+"  diff: "+diff+"  WxH: "+thumbW+"x"+thumbH);
                if (diff<0.001) break;
            }

            BufferedImageReader bir = BufferedImageReader.makeBufferedImageReader(ir);
            BufferedImage thumb = bir.openImage(0);
            bir.close();

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
        } catch (IOException e) {
            e.printStackTrace();
        } catch (loci.formats.FormatException e) {
            e.printStackTrace();
        }
        return null;
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

    public static void main(String[] args) throws Exception {
        //final String testImage = "D:\\pic\\testimg.jp2";
        //final String testImage = "D:\\pic\\czi\\20160211_FL_3ch_10x_1z_2sc_onl_jpegxr.czi";
        //final String testImage = "D:\\pic\\czi\\FL_5CH_2scenes_5z_online-jpegXR.czi";
        //final String testImage = "D:\\pic\\czi\\BF-20x-1z-1sc-off-jpegXR.czi";
        final String testImage = "D:\\pic\\Hamamatsu\\FL\\rgb.ndpis";
        //final String testImage = "D:\\pic\\vsi\\04_12_15_Slide1_Image_01.vsi";

        OrbitImageBioformats oi = new OrbitImageBioformats(testImage,0);
        System.out.println("wxh: "+oi.getWidth()+"x"+oi.getHeight());
        BufferedImage bi = new BufferedImage(oi.getColorModel(),  (WritableRaster) oi.getTileData(0,0) , oi.getColorModel().isAlphaPremultiplied(), null);
        System.out.println("img: "+bi);

        OrbitTiledImage2 oti = new OrbitTiledImageIOrbitImage(oi);
        oti.getTile(0,0);

        oi.close();
    }
}
