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

import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.imaging.GBlur;
import com.actelion.research.orbit.imageAnalysis.imaging.ManipulationUtils;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.Weigher;
import imageJ.Colour_Deconvolution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.media.jai.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.*;
import java.awt.image.renderable.ParameterBlock;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;


@SuppressWarnings("unchecked")
public abstract class OrbitTiledImage2 extends PlanarImage implements RenderedImage, Closeable {
    public final static int PHOTOMETRIC_YCbCr = 6;
    public final static int PHOTOMETRIC_RGB = 2;
    protected final static Logger logger = LoggerFactory.getLogger(OrbitTiledImage2.class);
    protected int numBands = 0;
    protected String filename = "";
    public static Cache<PointAndName, Raster> tileCache = null;
    private static final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
    private static final boolean doCacheLock = true;
    private boolean useCache = true; //!ScaleoutMode.SCALEOUTMODE.get();
    protected int photometric = PHOTOMETRIC_YCbCr;
    //protected static final ColorModel rgbColorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.TYPE_YCbCr), new int[]{8,8,8}, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
    protected static final ColorModel rgbColorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB), new int[]{8, 8, 8}, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
    protected static final ColorModel grayColorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_GRAY), new int[]{8}, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
    protected boolean initialized = false; // sampleModel and colorModel initialized (don't use cache the first time, even if the image has been loaded before!)
    private OrbitUtils.ImageAdjustCachedParams cachedParams = new OrbitUtils.ImageAdjustCachedParams();
    private PlanarImage nullImage = null;
    protected boolean originalWasGrayScale = false;
    protected int originalBitsPerSample = 8;
    protected int rawDataFileId = -1; // not known
    protected TiledImagePainter tiledImagePainterStats = null; // optional: can be set for computing extreme stats based on low res image
    private static LookupTableJAI defaultLookuptable = null;
    private float[] channelContributionsClassification = null; // (fluo)channel contributions (currently only 1 or 0) used for classification
    protected int level = 0; // used for caching identifier
    protected float[] analysisHues = null;

    protected abstract String readInfoString(String filename) throws Exception;

    protected abstract Raster getTileData(int tileX, int tileY, float[] channelContributions, boolean analysis, float[] analysisHues);


    private static void initCache() {
        logger.info("(re-)creating tile cache");
        long mem = ScaleoutMode.SCALEOUTMODE.get() ? 512L*512L*3*4*200 : Runtime.getRuntime().maxMemory()/2;
      //  long mem = (512L*512L*3*4*200);
        tileCache = CacheBuilder.
                newBuilder().
                //recordStats().
                expireAfterWrite(7, TimeUnit.MINUTES).
                maximumWeight(mem).
                weigher(new Weigher<PointAndName, Raster>() {
                    @Override
                    public int weigh(PointAndName key, Raster raster) {
                        return raster.getWidth()*raster.getHeight() * 3 * 4;
                    }
                }).
                build();
    }

    public OrbitTiledImage2() {
        logCacheStats();
    }

    public OrbitTiledImage2(String filename) throws Exception {
        logCacheStats();

        this.filename = filename.replaceAll("/data/orbit", "");

        // try to parse rdfId for special files which are names like /path/to/server/rdfId.tif
        try {
            int idx1 = this.filename.lastIndexOf("/") + 1;
            int idx2 = this.filename.indexOf(".");
            String rdfIdStr = this.filename.substring(idx1, idx2);
            rawDataFileId = Integer.parseInt(rdfIdStr);
        } catch (Exception e) {
            rawDataFileId = -1;
        }

        readInfo(this.filename);

        try { // must try-catch because this fails for TiledImageWriter
            getTile(0, 0); // the first getTile() call initializes the sampleModel (which is used in e.g. PlanarImage.getExtendedData() )
        } catch (Exception ex) {
            if (!(this instanceof OrbitTiledImagePlanarImage))
                throw new OrbitImageServletException("Error reading image tile data");
        }
    }

    public synchronized static void resetTileCache() {
        if (OrbitTiledImage2.tileCache!=null) {
            OrbitTiledImage2.tileCache.invalidateAll();
        }
        OrbitTiledImage2.tileCache = null;
        System.gc();
    }

    private static void logCacheStats() {
        if (logger.isTraceEnabled()) {
            if (OrbitTiledImage2.tileCache != null) {
                //logger.trace("cachesize: " + OrbitTiledImage2.tileCache.size() + " stats: " + OrbitTiledImage2.tileCache.stats().toString());
                logger.trace("cachesize: " + OrbitTiledImage2.tileCache.size());
            }
        }
    }

    /**
     * used for classification / analysis
     */
    @Override
    public Raster getTile(int tileX, int tileY) {
        return getTile(tileX, tileY, 100, 100, 0, 0, 0, 0, 0, null, null, null, null, true, true, true, 0, Colour_Deconvolution.DECONV_NONE,channelContributionsClassification, true, analysisHues);
    }

    /**
     * used for viewing / rendering
     */
    public Raster getTile(int tileX, int tileY, double gamma, double contrast, double brightness, int blur, double redAdjust, double greenAdjust, double blueAdjust, OrbitTiledImage2 redChannel, OrbitTiledImage2 greenChannel, OrbitTiledImage2 blueChannel, OrbitTiledImage2 overlayChannel, boolean redActive, boolean greenActive, boolean blueActive, int deconvChannel, String deconvName, final float[] channelContributions) {
        return getTile(tileX, tileY, gamma, contrast, brightness, blur, redAdjust, greenAdjust, blueAdjust, redChannel, greenChannel, blueChannel, overlayChannel, redActive, greenActive, blueActive, deconvChannel, deconvName, channelContributions, false, null);
    }

     public Raster getTile(int tileX, int tileY, double gamma, double contrast, double brightness, int blur, double redAdjust, double greenAdjust, double blueAdjust, OrbitTiledImage2 redChannel, OrbitTiledImage2 greenChannel, OrbitTiledImage2 blueChannel, OrbitTiledImage2 overlayChannel, boolean redActive, boolean greenActive, boolean blueActive, int deconvChannel, String deconvName, final float[] channelContributions, boolean analysis,  final float[] analysisHues) {
        float[] channelContributionsCloned = channelContributions==null? null: Arrays.copyOf(channelContributions, channelContributions.length);
        PointAndName tileP = new PointAndName(tileX, tileY, filename, level, gamma, contrast, brightness, blur, redAdjust, greenAdjust, blueAdjust, redChannel, greenChannel, blueChannel, overlayChannel, redActive, greenActive, blueActive, deconvChannel, deconvName, channelContributionsCloned, analysis, analysisHues);
        if (doCacheLock) OrbitTiledImage2.cacheLock.readLock().lock();
        try {
            if (useCache && OrbitTiledImage2.tileCache != null) {
                Raster cachedRaster = OrbitTiledImage2.tileCache.getIfPresent(tileP);
                if (initialized && cachedRaster != null) {
                   // logger.trace("cache hit");
                    return cachedRaster;
                } 
            }
        } finally {
            if (doCacheLock) OrbitTiledImage2.cacheLock.readLock().unlock();
        }

        // not in cache
         //logger.trace("cache miss");

        Raster tile = getTileData(tileX, tileY, channelContributionsCloned, analysis, analysisHues);

        if (tile==null) {
            logger.warn("error reading tile "+tileX+" x "+tileY+" channelContributions: "+Arrays.toString(channelContributions));
        }

        if (tile.getNumBands() == 1) {
            BufferedImage bi = createImage(tile, null, grayColorModel.createCompatibleSampleModel(this.getWidth(), this.getHeight()), grayColorModel);
            PlanarImage pi = PlanarImage.wrapRenderedImage(bi);
            ParameterBlock pb = new ParameterBlock();
            pb.addSource(pi); // r
            pb.addSource(pi); // g
            pb.addSource(pi); // b
            pi = JAI.create("bandmerge", pb);
            tile = pi.getData();
        }

        BufferedImage bi = null;

        // color deconvolution
        if (deconvChannel > 0) {
            bi = createImage(tile, bi, getSampleModel(), getColorModel());
            bi = Colour_Deconvolution.getProcessedImage(bi, deconvName, deconvChannel - 1, bi);
        }

        if (redChannel != null || greenChannel != null || blueChannel != null) {
            bi = createImage(tile, bi, getSampleModel(), getColorModel());
            bi = mergeChannels(redChannel, greenChannel, blueChannel, tileX, tileY, redActive, greenActive, blueActive).getAsBufferedImage();
            bi = correctSamplemodel(PlanarImage.wrapRenderedImage(bi)).getAsBufferedImage();
        }

        if (overlayChannel != null) {
            bi = createImage(tile, bi, getSampleModel(), getColorModel());
            bi = mergeOverlay(PlanarImage.wrapRenderedImage(bi), overlayChannel, tileX, tileY).getAsBufferedImage();
        }

        if (blur > 0) {
            bi = createImage(tile, bi, getSampleModel(), getColorModel());
            bi = GBlur.adjustBlur(PlanarImage.wrapRenderedImage(bi), blur).getAsBufferedImage();
        }

        if (Math.abs(brightness) > 0.01d) {
            bi = createImage(tile, bi, getSampleModel(), getColorModel());
            bi = adjustBrightness(PlanarImage.wrapRenderedImage(bi), brightness).getAsBufferedImage();
        }

        if (gamma != 100) {
            bi = createImage(tile, bi, getSampleModel(), getColorModel());
            bi = adjustGamma(PlanarImage.wrapRenderedImage(bi), gamma, cachedParams, tiledImagePainterStats).getAsBufferedImage();
        }


        if ((redAdjust != 0) || (greenAdjust != 0) || (blueAdjust != 0) || contrast != 100) {
            bi = createImage(tile, bi, getSampleModel(), getColorModel());
            bi = adjustContrast(PlanarImage.wrapRenderedImage(bi), redAdjust, greenAdjust, blueAdjust, (float) contrast / 100f, brightness, cachedParams, tiledImagePainterStats).getAsBufferedImage();
        }

        if (((redActive == false) && (redChannel == null)) || ((greenActive == false) && (greenChannel == null)) || ((blueActive == false) && (blueChannel == null))) {
            bi = createImage(tile, bi, getSampleModel(), getColorModel());
            bi = activeChannels(PlanarImage.wrapRenderedImage(bi), redActive, greenActive, blueActive).getAsBufferedImage();
        }

         final boolean normalizeHistogram = false;
         if (normalizeHistogram) {
            bi = createImage(tile, bi, getSampleModel(), getColorModel());
            bi = normalizeHistogram(bi);
        }


        if (bi != null) {
            tile = bi.getData();
        }

        // cache write lock will be set in initCache

        // re-init cache disabled. Too many problems due to different tile sizes (e.g. overview vs normal)
        //  -> only init once...
        if (doCacheLock) OrbitTiledImage2.cacheLock.writeLock().lock();
        try {
            if (useCache && (OrbitTiledImage2.tileCache == null)) {
                initCache();
            }
        } finally {
            if (doCacheLock) OrbitTiledImage2.cacheLock.writeLock().unlock();
        }

        // the put is a "read" method because the cache is not rebuild (and put/get is threadsafe)
        if (doCacheLock) OrbitTiledImage2.cacheLock.readLock().lock();
        try {
            if (useCache && OrbitTiledImage2.tileCache != null) {
                OrbitTiledImage2.tileCache.put(tileP, tile);
            }
        } finally {
            if (doCacheLock) OrbitTiledImage2.cacheLock.readLock().unlock();
        }
        initialized = true;
        return tile;
    }

  
    public static BufferedImage createImage(Raster r, BufferedImage bi, SampleModel sampleModel, ColorModel colorModel) {
        if (bi != null) return bi;
        try {
            DataBuffer dataBuffer = r.getDataBuffer();
            WritableRaster wr = Raster.createWritableRaster(sampleModel, dataBuffer, new Point(0, 0));
            BufferedImage bb = new BufferedImage(colorModel, wr, colorModel.isAlphaPremultiplied(), null);
            return bb;
        } catch (Throwable t) {
            t.printStackTrace();
            return null;
        }


    }


    private PlanarImage mergeOverlay(PlanarImage source, OrbitTiledImage2 overlayChannel2, int tileX, int tileY) {

        PlanarImage overlayChannel = PlanarImage.wrapRenderedImage(createImage(overlayChannel2.getTile(tileX, tileY), null, overlayChannel2.getSampleModel(), overlayChannel2.getColorModel()));
        PlanarImage overlayFixed = PlanarImage.wrapRenderedImage(createImage(overlayChannel2.getTile(tileX, tileY), null, overlayChannel2.getSampleModel(), overlayChannel2.getColorModel()));

        if (overlayFixed.getSampleModel().getNumBands() > 1)
            overlayFixed = convertColorToGray(overlayFixed);

        if (source.getSampleModel().getNumBands() > 1) {
            ParameterBlock pb = new ParameterBlock();
            pb.addSource(overlayFixed); // r
            pb.addSource(overlayFixed); // g
            pb.addSource(overlayFixed); // b
            overlayFixed = JAI.create("bandmerge", pb);
        }


        ParameterBlock pb = new ParameterBlock();
        pb.addSource(source);
        pb.addSource(overlayFixed);
        pb.add(overlayChannel);
        pb.add(overlayChannel);
        pb.add(false);
        pb.add(javax.media.jai.operator.CompositeDescriptor.NO_DESTINATION_ALPHA);
        return JAI.create("Composite", pb);
    }

    private PlanarImage activeChannels(PlanarImage source, boolean redActive, boolean greenActive, boolean blueActive) {
        final double[][] matrix = {
                {redActive ? 1D : 0D, 0D, 0D, 0d},
                {0D, greenActive ? 1D : 0D, 0D, 0d},
                {0D, 0D, blueActive ? 1D : 0D, 0d}
        };
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(source);
        pb.add(matrix);
        return JAI.create("bandcombine", pb, null);
    }


    private PlanarImage convertColorModel(PlanarImage pi) {
        int numComponents = pi.getColorModel().getNumComponents();
        boolean isGrey = numComponents == 1;
        ColorModel colorModel = rgbColorModel;
        if (isGrey) colorModel = grayColorModel;
        try {
            ParameterBlock pb = new ParameterBlock();
            pb.addSource(pi).add(colorModel);
            RenderedOp dst = JAI.create("ColorConvert", pb);
            return dst.getRendering();
        } catch (IllegalArgumentException ex) {
            logger.info("Error: Cannot convert color model. Original color model: " + pi.getColorModel());
            return null;
        }

    }

    private PlanarImage mergeChannels(final OrbitTiledImage2 redChannel, final OrbitTiledImage2 greenChannel, final PlanarImage blueChannel, int tileX, int tileY, boolean redActive, boolean greenActive, boolean blueActive) {

        PlanarImage red = redChannel == null ? null : PlanarImage.wrapRenderedImage(createImage(redChannel.getTile(tileX, tileY), null, redChannel.getSampleModel(), redChannel.getColorModel()));
        PlanarImage green = greenChannel == null ? null : PlanarImage.wrapRenderedImage(createImage(greenChannel.getTile(tileX, tileY), null, greenChannel.getSampleModel(), greenChannel.getColorModel()));
        PlanarImage blue = blueChannel == null ? null : PlanarImage.wrapRenderedImage(createImage(blueChannel.getTile(tileX, tileY), null, blueChannel.getSampleModel(), blueChannel.getColorModel()));

        PlanarImage nullImage = null;
        if (red != null) nullImage = getNullImage(red);
        else if (green != null) nullImage = getNullImage(green);
        else if (blue != null) nullImage = getNullImage(blue);

        red = red == null ? nullImage : red;
        green = green == null ? nullImage : green;
        blue = blue == null ? nullImage : blue;

        red = redActive ? red : nullImage;
        green = greenActive ? green : nullImage;
        blue = blueActive ? blue : nullImage;

        if (red.getSampleModel().getNumBands() > 1)
            red = convertColorToGray(red, 1, 0, 0);
        if (green.getSampleModel().getNumBands() > 1)
            green = convertColorToGray(green, 0, 1, 0);
        if (blue.getSampleModel().getNumBands() > 1)
            blue = convertColorToGray(blue, 0, 0, 1);


        try {

            ParameterBlock pb = new ParameterBlock();
            if (originalWasGrayScale) {  // bgr fix
                pb.addSource(blue); // b
                pb.addSource(green); // g
                pb.addSource(red); // r
            } else { // rgb
                pb.addSource(red); // r
                pb.addSource(green); // g
                pb.addSource(blue); // b
            }
            PlanarImage merged = JAI.create("bandmerge", pb);

            return merged;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }


    }

    private RenderedOp convertColorToGray(PlanarImage src, double r, double g, double b) {
        final double[][] matrix = {
                {r, g, b, 0d} // .114D, 0.587D, 0.299D
        };
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(src);
        pb.add(matrix);
        return JAI.create("bandcombine", pb, /*ManipulationUtils.getRenderingHints(image)*/null);
    }

    private RenderedOp convertColorToGray(PlanarImage src) {
        final double[][] matrix = {
                //  { 0.114D, 0.587D, 0.299D, 0d } // .114D, 0.587D, 0.299D
                {0.333D, 0.333D, 0.333D, 0d} // .114D, 0.587D, 0.299D
        };
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(src);
        pb.add(matrix);
        return JAI.create("bandcombine", pb, /*ManipulationUtils.getRenderingHints(image)*/null);
    }


    private PlanarImage getNullImage(PlanarImage img) {
        if (nullImage == null) {
            nullImage = new TiledImage(img.getMinX(), img.getMinY(), img.getWidth(), img.getHeight(), img.getTileGridXOffset(), img.getTileGridYOffset(), img.getSampleModel(), img.getColorModel());
        }
        return nullImage;
    }

    /**
     * make sure that a PixelInterleavedSampleModel is returned
     */
    private static PlanarImage makeCompatibleSamplemodel(PlanarImage source, PlanarImage result) {

        // really needed??? - what if singlepixelpackedsamplemodel ?

        if (!(source.getSampleModel() instanceof PixelInterleavedSampleModel)) {
            logger.debug("makeCompatibleSamplemodel");
            BufferedImage img = new BufferedImage(result.getWidth(), result.getHeight(), BufferedImage.TYPE_INT_RGB);
            img.createGraphics().drawImage(result.getAsBufferedImage(), 0, 0, null);
            result = PlanarImage.wrapRenderedImage(img);
        }
        return result;
    }



    public static PlanarImage adjustBrightness(PlanarImage src, final double b) {
        final double[][] matrixRGB = {
                {1d, 0D, 0D, b},
                {0D, 1d, 0D, b},
                {0, 0D, 1d, b}

        };


        final double[][] matrixGrey = {
                {1d, b}
        };

        double[][] matrix;
        if (src.getSampleModel().getNumBands() > 1)
            matrix = matrixRGB;
        else matrix = matrixGrey;


        ParameterBlock pb = new ParameterBlock();
        pb.addSource(src);
        pb.add(matrix);
        return JAI.create("bandcombine", pb);
    }


    /**
     * Gamma correction.
     * imageForStats should be a low resolution image for computing the extrema - or null, then the smallest layer will be loaded automatically.
     *
     * @param source
     * @param gammaValueOrig [100..350 -> will be converted to 1..3,5]
     * @return
     */
    public static PlanarImage adjustGamma(final PlanarImage source, double gammaValueOrig, final OrbitUtils.ImageAdjustCachedParams cachedParams, final TiledImagePainter tipForStats) {
        ParameterBlock pb;
        synchronized (cachedParams) {
            if (!cachedParams.isGammaExtremaSet()) {
                PlanarImage statImg = loadImageForStats(source, tipForStats);  // will take lowres image if image pyramid is available

                final int numScan = 200;
                int skipW = Math.max(1, source.getWidth() / numScan);
                int skipH = Math.max(1, source.getHeight() / numScan);
                //	System.out.println("gamma extreme calc "+skipW+" / "+skipH);

                pb = new ParameterBlock();
                pb.addSource(statImg);   // The source image
                pb.add(null);        // The region of the image to scan
                pb.add(skipW);         // The horizontal sampling rate
                pb.add(skipH);         // The vertical sampling rate
                RenderedOp op = JAI.create("extrema", pb);
                double[][] extrema = (double[][]) op.getProperty("extrema"); // [0][r,g,b] minimum, [1][r,g,b] maximum
                cachedParams.setGammaMin(Math.min(Math.min(extrema[0][0], extrema[0][1]), extrema[0][2]));
                cachedParams.setGammaMax(Math.max(Math.max(extrema[1][0], extrema[1][1]), extrema[1][2]));
                cachedParams.setGammaExtremaSet(true);
            }
        }

        double minValue = cachedParams.getGammaMin();
        double maxValue = cachedParams.getGammaMax();
        //double gammaValue = (gammaValueOrig+1d)*1.75d; // scale 0-3.5
        double gammaValue = gammaValueOrig / 100d; // scale 0-3.5

        // get min and max value from ndpi meta data?

        // gamma per channel?
        byte[] lut = new byte[256];
        double scale = 255.0 / (maxValue - minValue);
        double gammaPower = 1.0 / gammaValue;
        for (int i = (int) minValue; i < (int) maxValue; i++) {
            if (gammaValue == 1.0f) {
                lut[i] = (byte) ((i - minValue) * scale);
            } else {
                double val = (Math.pow(i / 255.0d, gammaPower) * 255.0d - minValue) * scale;
                if (val < 0) val = 0;
                if (val > 255) val = 255;
                lut[i] = (byte) val;

            }
        }
        for (int i = 0; i < minValue; i++) {
            lut[i] = 0;
        }
        for (int i = (int) maxValue; i < 256; i++) {
            lut[i] = (byte) 255;
        }


        LookupTableJAI lookup = new LookupTableJAI(lut);
        PlanarImage result = JAI.create("lookup", source, lookup);
        result = makeCompatibleSamplemodel(source, result);
        return result;
    }


    public static PlanarImage adjustContrast(PlanarImage src, double red, double green, double blue, double contrast, double brightness, OrbitUtils.ImageAdjustCachedParams cachedParams, TiledImagePainter tipForStats) {

        if (!cachedParams.isContrastAverageSet()) {

            PlanarImage statImg = loadImageForStats(src, tipForStats);

            final int numScan = 200;
            int skipW = Math.max(1, src.getWidth() / numScan);
            int skipH = Math.max(1, src.getHeight() / numScan);

            ParameterBlock mpb = new ParameterBlock();
            mpb.addSource(statImg); // The source image
            mpb.add(null); // null ROI means whole image
            mpb.add(skipW); // 1 check every pixel horizontally
            mpb.add(skipH); // 1 check every pixel vertically

            // Perform the mean operation on the source image
            PlanarImage meanImage = JAI.create("mean", mpb, null);
            // Retrieve the mean pixel value
            double[] mean = (double[]) meanImage.getProperty("mean");
            // Average the mean of all bands
            double sum = 0.0D;
            for (int i = 0; i < mean.length; i++) {
                sum += mean[i];
            }
            cachedParams.setContrastAverage(sum / (double) mean.length);
            cachedParams.setContrastAverageSet(true);
        }
        double average = cachedParams.getContrastAverage();

        // Create the lookup table based on the average mean
        byte[][] lut = new byte[3][256];
        for (int i = 0; i < 256; i++) {
            lut[0][i] = ManipulationUtils.clamp((int) ((average + (i - average) * contrast) + red + brightness));
            lut[1][i] = ManipulationUtils.clamp((int) ((average + (i - average) * contrast) + green + brightness));
            lut[2][i] = ManipulationUtils.clamp((int) ((average + (i - average) * contrast) + blue + brightness));
        }


        LookupTableJAI lookup = new LookupTableJAI(lut);
        PlanarImage result = JAI.create("lookup", src, lookup);
        result = makeCompatibleSamplemodel(src, result);
        return result;

    }

    public static BufferedImage normalizeHistogram(BufferedImage bi) {
        // TODO replace lut
        final int[] lut = new int[]{8, 9, 9, 9, 9, 10, 11, 11, 11, 12, 12, 15, 16, 16, 16, 17, 42, 60, 68, 72, 75, 79, 85, 91, 93, 96, 99, 103, 108, 112, 113, 114, 118, 119, 120, 125, 126, 129, 131, 131, 134, 137, 138, 139, 140, 141, 142, 144, 145, 146, 147, 148, 149, 151, 153, 154, 154, 155, 155, 155, 157, 158, 160, 161, 161, 162, 163, 163, 164, 165, 166, 166, 168, 170, 171, 171, 171, 171, 173, 174, 175, 175, 177, 177, 177, 178, 178, 180, 180, 181, 183, 183, 184, 185, 186, 186, 186, 187, 187, 189, 189, 190, 190, 193, 193, 193, 194, 194, 195, 196, 196, 196, 197, 198, 198, 199, 199, 199, 200, 202, 202, 202, 202, 202, 203, 204, 204, 204, 205, 205, 206, 206, 206, 207, 207, 208, 208, 208, 208, 209, 209, 209, 209, 209, 211, 211, 211, 211, 212, 212, 212, 213, 213, 213, 213, 214, 214, 214, 214, 214, 214, 215, 215, 215, 215, 215, 215, 216, 216, 216, 216, 216, 216, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218};
        BufferedImage normBi = HistogramMatcher.matchHisto(bi,lut);
        bi.getGraphics().drawImage(normBi, 0, 0, null);
        return bi;
    }


    /**
     * Corrects the sample model, e.g. after channel merge.
     * @param src
     * @return
     */
    public static PlanarImage correctSamplemodel(PlanarImage src) {
        PlanarImage result = JAI.create("lookup", src, getDefaultLookuptable());
        result = makeCompatibleSamplemodel(src, result);
        return result;
    }

    private static synchronized LookupTableJAI getDefaultLookuptable() {
        if (defaultLookuptable==null) {
            byte[][] lut = new byte[3][256];
            for (int i = 0; i < 256; i++) {
                lut[0][i] = ManipulationUtils.clamp(i);
                lut[1][i] = ManipulationUtils.clamp(i);
                lut[2][i] = ManipulationUtils.clamp(i);
            }
            defaultLookuptable = new LookupTableJAI(lut);
        }
        return defaultLookuptable;
    }

    private static PlanarImage loadImageForStats(PlanarImage source, TiledImagePainter tip) {
        PlanarImage res = source;
        if (tip != null && tip.hasMipMaps()) {
            res = tip.getMipMaps()[tip.getMipMaps().length - 1].getImage();
            //res = tip.getImage();
            logger.trace("stat image loaded via tiledImagePainterStats");
        }
        return res;
    }


    protected synchronized boolean readInfo(String filename) throws Exception {
        String sb = readInfoString(filename);
        if (logger.isDebugEnabled()) {
            String[] split = filename.split("\\.");
            if (split != null && split.length == 2)
                logger.debug("info: " + sb);
        }
        if (sb == null) return false;
        if (sb.length() > 0) {
            minX = 0;
            minY = 0;
            String[] kv = sb.toString().split(",");
            if (kv != null && kv.length > 0) {
                for (String s : kv) {
                    String[] sa = s.split("=");
                    if (sa != null && sa.length == 2) {
                        String key = sa[0];
                        String val = sa[1];
                        try {
                            if (key.equalsIgnoreCase("width")) {
                                this.width = Integer.parseInt(val);
                            } else if (key.equalsIgnoreCase("height")) {
                                this.height = Integer.parseInt(val);
                            } else if (key.equalsIgnoreCase("numBands")) {
                                this.numBands = Integer.parseInt(val);
                            } else if (key.equalsIgnoreCase("minX")) {
                                this.minX = Integer.parseInt(val);
                            } else if (key.equalsIgnoreCase("minY")) {
                                this.minY = Integer.parseInt(val);
                            } else if (key.equalsIgnoreCase("tileGridXOffset")) {
                                this.tileGridXOffset = Integer.parseInt(val);
                            } else if (key.equalsIgnoreCase("tileGridYOffset")) {
                                this.tileGridYOffset = Integer.parseInt(val);
                            } else if (key.equalsIgnoreCase("tileWidth")) {
                                this.tileWidth = Integer.parseInt(val);
                            } else if (key.equalsIgnoreCase("tileHeight")) {
                                this.tileHeight = Integer.parseInt(val);
                            } else if (key.equalsIgnoreCase("photometric")) {
                                this.photometric = Integer.parseInt(val);
                            } else if (key.equalsIgnoreCase("bitsPerSample")) {
                                this.originalBitsPerSample = Integer.parseInt(val);
                            }

                        } catch (Exception e) {
                            logger.error("error setting property: " + key + "", e);
                        }
                    }
                }

                // tileWidth and tileHeight now based on AparUtils.TILE_SIZE
                //this.tileWidth = AparUtils.TILE_SIZE;
                //this.tileHeight = AparUtils.TILE_SIZE;

                numBands = 3; // always RGB!!!
                if (numBands == 1) this.colorModel = grayColorModel;
                else {
                    this.colorModel = rgbColorModel;
                }
                this.sampleModel = colorModel.createCompatibleSampleModel(tileWidth, tileHeight);
            }
        }

        return true;
    }


    public int getSample(int x, int y, int b) {
        int tileX = this.XToTileX(x);
        int tileY = this.YToTileY(y);
        Raster t = this.getTile(tileX, tileY);
        return t.getSample(x, y, b);
    }


    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        String s = "filename=" + filename + "; level="+level+"; width=" + width + "; height=" + height + "; numBands=" + numBands + "; tileWidth=" + tileWidth + "; tileHeight=" + tileHeight + "; maxTileX=" + getMaxTileX() + "; maxTileY=" + getMaxTileY() + "; colorModel=" + colorModel.getColorSpace().getType() + "; sampleModel=" + sampleModel + "; OriginalBitePerSample=" + originalBitsPerSample;
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrbitTiledImage2 that = (OrbitTiledImage2) o;

        if (level != that.level) return false;
        return filename != null ? filename.equals(that.filename) : that.filename == null;
    }

    @Override
    public int hashCode() {
        int result = filename != null ? filename.hashCode() : 0;
        result = 31 * result + level;
        return result;
    }

    public boolean isUseCache() {
        return useCache;
    }

    public void setUseCache(boolean useCache) {
        this.useCache = useCache;
    }

    public void close() throws IOException {

    }

    public float[] getChannelContributionsClassification() {
        return channelContributionsClassification;
    }

    public void setChannelContributionsClassification(float[] channelContributionsClassification) {
        this.channelContributionsClassification = channelContributionsClassification;
    }

    public TiledImagePainter getTiledImagePainterStats() {
        return tiledImagePainterStats;
    }

    public void setTiledImagePainterStats(TiledImagePainter tiledImagePainterStats) {
        this.tiledImagePainterStats = tiledImagePainterStats;
    }

    public float[] getAnalysisHues() {
        return analysisHues;
    }

    public void setAnalysisHues(float[] analysisHues) {
        this.analysisHues = analysisHues;
    }
}
