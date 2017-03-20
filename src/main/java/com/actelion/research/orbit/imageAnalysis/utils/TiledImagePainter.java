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

package com.actelion.research.orbit.imageAnalysis.utils;

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.dal.IOrbitImageMultiChannel;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.imaging.ManipulationUtils;
import com.actelion.research.orbit.imageAnalysis.imaging.MedianFilter;
import com.actelion.research.orbit.imageAnalysis.models.FeatureDescription;
import com.actelion.research.orbit.utils.RawUtilsCommon;
import com.sun.media.jai.codec.PNGDecodeParam;
import imageJ.Colour_Deconvolution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.media.jai.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.awt.image.renderable.ParameterBlock;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.*;

/**
 * Problem with some old fluorescence TIFFs:
 * Some strange tiffs (e.g. RDFid 1874912) are in RGB (instead of YcBcR)  photometric interpretation and have 8,8,1 bit samples.
 * This works with ImageIO, but not with JAI. Thus, with Orbit OIS (RMI) service it works but via the servlet (here JAI is used on client side) not.
 * The current workaround is to just use RMI for these images. However, the best way would be to convert all images on server-side via imagemagick to YcBcR encoding.
 * For all newer merged (NDPIS) fluo images (>1.12.2012) this should not happen.
 */
public class TiledImagePainter implements Closeable {

    public static final int CHANNEL_RED = 0;
    public static final int CHANNEL_GREEN = 1;
    public static final int CHANNEL_BLUE = 2;
    public static final int CHANNEL_OVERLAY = 3;
    private final static Logger logger = LoggerFactory.getLogger(TiledImagePainter.class);
    transient protected OrbitTiledImage2 image;
    transient protected PlanarImage origImage;
    private String imageName = "";
    private int width = 0, height = 0;
    private int tileGridXOffset = 0, tileGridYOffset = 0;
    // private TileCache tileCache = null;
    private Object sourceImage = null;
    private TiledImagePainter[] mipMaps = null;
    private boolean generateMipMaps = true;
    private OrbitTiledImage2 redChannel = null;
    private OrbitTiledImage2 greenChannel = null;
    private OrbitTiledImage2 blueChannel = null;
    private OrbitTiledImage2 overlayChannel = null;
    private int redChannelRdfId = 0;
    private int greenChannelRdfId = 0;
    private int blueChannelRdfId = 0;
    private int overlayChannelRdfId = 0;

    private double gamma = 100d;
    private double brightness = 0d;
    private double contrast = 100d;
    private int blur = 0;
    private double redAdjust = 0d;
    private double greenAdjust = 0d;
    private double blueAdjust = 0d;
    private boolean redActive = true;
    private boolean greenActive = true;
    private boolean blueActive = true;

    private int deconvChannel = 0; // 0 is disabled, 1 to 3 for channel (-1 for index)
    private String deconvName = Colour_Deconvolution.DECONV_NONE;
    private OrbitUtils.ImageAdjustments imageAdjustments = null;
    final private OrbitUtils.ImageAdjustCachedParams cachedParams = new OrbitUtils.ImageAdjustCachedParams();


//    public final static ExecutorService executorService = Executors.newCachedThreadPool();
//    public final static ExecutorService executorService = Executors.newFixedThreadPool(1);
    public final static ExecutorService executorService = Executors.newFixedThreadPool(Math.min(4,Runtime.getRuntime().availableProcessors()), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        }
    });

    // private ContrastColor contrastColor = new ContrastColor();
    //private GaussianBlur gaussianBlur = new GaussianBlur();
    // private MedianFilter medianFilter = new MedianFilter();

    private BufferedImage bi;
    private WritableRaster wr;
    private DataBuffer dataBuffer;
    private Raster tile;
    private GraphicsConfiguration graphicsConfiguration;

    public TiledImagePainter() {
    }

    public TiledImagePainter(boolean generateMipMaps) {
        this.generateMipMaps = generateMipMaps;
    }

    public TiledImagePainter(PlanarImage inputImage, String name) {
        this.generateMipMaps = false;
        try {
            setImage(inputImage);
        } catch (OrbitImageServletException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Cannot set image: " + inputImage);
        }
    }


    public void loadImage(Object inputStrOrURL) throws Exception {
        loadImage(inputStrOrURL, 0);
    }


    public void loadImage(Object inputStrOrURL, int imagePyramidNum) throws Exception {
        loadImage(inputStrOrURL, imagePyramidNum, false);
    }

    public synchronized void loadImage(Object inputStrOrURL, int imagePyramidNum, boolean loadRemote) throws Exception {

        if (inputStrOrURL instanceof RawDataFile) {
            origImage = new OrbitTiledImageIOrbitImage(DALConfig.getImageProvider().createOrbitImage(((RawDataFile) inputStrOrURL), imagePyramidNum));
            imageName = ((RawDataFile) inputStrOrURL).getFileName();
            imageAdjustments = OrbitUtils.getAndParseImageAdjustments(((RawDataFile) inputStrOrURL).getRawDataFileId());
        } else if (inputStrOrURL instanceof URL) {
            PNGDecodeParam param = null;
            if (String.valueOf(inputStrOrURL).toLowerCase().endsWith("png")) {
                param = new PNGDecodeParam();
                param.setSuppressAlpha(true);   // we don't support alpha channels here
            }
            origImage = JAI.create("url", inputStrOrURL, param);
            imageName = inputStrOrURL.toString();
        } else if (inputStrOrURL instanceof RenderedImage) {
            origImage = PlanarImage.wrapRenderedImage((RenderedImage) inputStrOrURL);
        } else {
            if (!loadRemote) {

                origImage = TiffConverter.loadFromFile((String) inputStrOrURL); // load from local filesystem
            } else {
                throw new Exception("Image loading method not supported");
                //origImage = accessRemote((String)inputStrOrURL);
                //imageName = (String)inputStrOrURL;
            }
        }


        if (origImage == null) return;
        this.sourceImage = inputStrOrURL;
        setImage(origImage);
        // is a previewImage available? use full size of preview image if possible (last parameter)
        if ((imagePyramidNum == 0) && generateMipMaps && ((origImage.getWidth() > 5000) || (origImage.getHeight() > 5000))) {
            loadMipMaps(inputStrOrURL);
        }

        origImage = null;
    }


    public void loadImageSpecial(RawDataFile rdf, int level) throws OrbitImageServletException, SQLException {
        int num = level;
        if (num < 1000)
            num++;   // +1 because orbit file system starts with 1 and not 0 (id, id.1, id.2, ...)  - but not for special layers like slide overview or label (>=1000)
        origImage = null;
        try {
            switch (level) {
                case RawUtilsCommon.LEVEL_LABEL: {
                    origImage = new OrbitTiledImagePlanarImage(PlanarImage.wrapRenderedImage(DALConfig.getImageProvider().getLabelImage(rdf)));
                    break;
                }
                case RawUtilsCommon.LEVEL_OVERVIEW: {
                    origImage = new OrbitTiledImagePlanarImage(PlanarImage.wrapRenderedImage(DALConfig.getImageProvider().getOverviewImage(rdf)));
                    break;
                }
                default: {
                    origImage = new OrbitTiledImageIOrbitImage(DALConfig.getImageProvider().createOrbitImage(rdf, level));
                    break;
                }
            }
            if (origImage == null) return; // not available
            if (level == RawUtilsCommon.LEVEL_LABEL) {
                float centerX = (float) origImage.getWidth() / 2;
                float centerY = (float) origImage.getHeight() / 2;
                ParameterBlock pb = new ParameterBlock();
                pb.addSource(origImage);
                pb.add(centerX);
                pb.add(centerY);
                pb.add(new Float(Math.toRadians(90)));
                pb.add(new javax.media.jai.InterpolationBicubic(10));
                origImage = JAI.create("rotate", pb);
            }

            setImage(origImage);
            imageName = rdf.toString();
            imageAdjustments = OrbitUtils.getAndParseImageAdjustments(rdf.getRawDataFileId());
        } catch (Exception e) {
            logger.error("Special layer not available for this image.");
        }
    }

    /**
     * @param inputStrOrURL can be RawDataFile or String (url is not allowed here)
     * @throws OrbitImageServletException
     */
    public void loadMipMaps(Object inputStrOrURL) throws Exception {
        if (inputStrOrURL instanceof URL) {
            logger.error("loadMipMaps for input type URL not supported.");
            return;
        }
        // so inputStrorURL can be of type RawDataFile or String

        double level0ratio = (double)image.getWidth()/image.getHeight();
        boolean oldMipPyramid = false;
        if (inputStrOrURL instanceof RawDataFile) {
            oldMipPyramid = ((RawDataFile) inputStrOrURL).getModifyDate().getTime() < 1411075560000L;   // before 9/18/14 5:26 PM  the pyramid limit was width < 2000
        }
        logger.trace("old pyramid limit: " + oldMipPyramid);


        List<TiledImagePainter> mipList = new ArrayList<TiledImagePainter>();
        int mipNum = 1;
        while (mipNum > 0) {
            String mipFileName = null;
            if (inputStrOrURL instanceof RawDataFile) {
                //mipFileName = PathResolver.getFilenameOnServerFullMipMap((((RawDataFile)inputStrOrURL)),mipNum);
                PlanarImage pi;
                try {
                    pi = new OrbitTiledImageIOrbitImage(DALConfig.getImageProvider().createOrbitImage((RawDataFile) inputStrOrURL, mipNum));
                } catch (Throwable ex1) {
                    if (logger.isTraceEnabled())
                        logger.trace("Error getting width from remote image.");
                    mipNum = -1;
                    break;
                }
                // TODO: better query meta data ("mipmapNumber") for number of mipmaps
                if (pi != null) {  // mipMap at level i exists
                    int mipWidth = 0;
                    try {
                        mipWidth = pi.getWidth();
                    } catch (Throwable ex) {
                        mipWidth = 0;
                        if (logger.isTraceEnabled())
                            logger.trace("Error getting width from remote image.");
                        mipNum = -1;
                        break;
                    }
                    pi = null;
                    if (mipWidth > 0) {
                        //logger.debug("building painter "+mipFileName);
                        TiledImagePainter mipPainter = new TiledImagePainter(false);
                        mipPainter.loadImage(inputStrOrURL, mipNum, true);
                        double mipRatio = (double)mipPainter.getWidth()/mipPainter.getHeight();
                        if (Math.abs(level0ratio-mipRatio)<0.01d) {
                            if (logger.isTraceEnabled())
                                logger.trace("mipmap loaded " + mipPainter.getWidth() + "x" + mipPainter.getHeight() + " mipNum:" + mipNum);
                            mipList.add(mipPainter);
                            // load further mipMaps ?
                            if (oldMipPyramid) {
                                if (mipPainter.getWidth() > 2000)
                                    mipNum++;
                                else mipNum = -1;
                            } else {
                                if ((long) mipPainter.getWidth() * mipPainter.getHeight() > RawUtilsCommon.MIN_SIZE_FOR_IMAGE_PYRAMID) // according RawUploader (line ~764) criteria
                                    mipNum++;
                                else mipNum = -1;
                            }
//                            if (((long) mipPainter.getWidth() * mipPainter.getHeight()) > (1024L*1024L))
//                                   mipNum++;
//                             else mipNum = -1;
                        }
                    }
                } else {
                    mipNum = -1;
                    break;
                }

            } else if (inputStrOrURL instanceof URL) {
                // should not happen
            } else if (inputStrOrURL instanceof String) {
                mipFileName = ((String) inputStrOrURL).split("\\.")[0] + "." + mipNum + "." + ((String) inputStrOrURL).split("\\.")[1];
                if (mipFileName == null) break;
                logger.trace("trying string mip: " + mipFileName);
                File testFile = new File(mipFileName);
                if (!testFile.exists()) {
                    mipNum = -1;
                    break;
                }
                //logger.trace("building painter");
                TiledImagePainter mipPainter = new TiledImagePainter(false);
                mipPainter.loadImage(mipFileName, mipNum, false);
                double mipRatio = (double)mipPainter.getWidth()/mipPainter.getHeight();
                if (Math.abs(level0ratio-mipRatio)<0.01d) {
                    if (logger.isTraceEnabled())
                        logger.trace("mipmap loaded " + mipPainter.getWidth() + "x" + mipPainter.getHeight());
                    mipList.add(mipPainter);

                    // load further mipMaps ?
                    if (oldMipPyramid) {
                        if (mipPainter.getWidth() > 2000)
                            mipNum++;
                        else mipNum = -1;
                    } else {
                        if ((long) mipPainter.getWidth() * mipPainter.getHeight() > RawUtilsCommon.MIN_SIZE_FOR_IMAGE_PYRAMID) // according RawUploader (line ~764) criteria
                            mipNum++;
                        else mipNum = -1;
                    }
                }
            }
        } // while i>0

        if (mipList != null && mipList.size() > 0) {
            mipMaps = new TiledImagePainter[mipList.size()];
            for (int i = 0; i < mipList.size(); i++) {
                mipMaps[i] = mipList.get(i);
            }
            mipList = null;
        }
    }


    /**
     * Returns image data of the modified image (e.g. for classification)
     */
    public Raster getData(Rectangle region, FeatureDescription fd) throws OrbitImageServletException {
        Raster r = null;
        try {
            PlanarImage pi = getModifiedImage(fd);
            r = pi.getExtendedData(region, BorderExtender.createInstance(BorderExtender.BORDER_COPY));
        } catch (Exception e) {
            e.printStackTrace();
            r = null;
            logger.error("Error loading image.\nOrbit will now retry to load the image several times.");
        }
        if (r == null) {
            throw new OrbitImageServletException("error loading image data");
        }

        return r;
    }

    private IOrbitImageMultiChannel getMultiChannelImage() {
            OrbitTiledImage2 img = this.image;
            if (img instanceof OrbitTiledImageIOrbitImage) {
                IOrbitImage oi = ((OrbitTiledImageIOrbitImage) img).getOrbitImage();
                if (oi instanceof IOrbitImageMultiChannel) {
                    final IOrbitImageMultiChannel oim = (IOrbitImageMultiChannel) oi;
                    return oim;
                }
            }
        return null;
    }



    public int getType() {
        if (getImage().getColorModel() == null) return BufferedImage.TYPE_INT_RGB; // but should be TYPE_3BYTE_BGR!
        if (getImage().getColorModel().hasAlpha()) return BufferedImage.TYPE_INT_ARGB;
        else return BufferedImage.TYPE_INT_RGB;
    }

    /**
     * Returns the PlanarImage with all modifications (e.g. median filter) applied. Used for classification.
     *
     * @return
     */
    public PlanarImage getModifiedImage(FeatureDescription featureDescription) {
        PlanarImage pi = image;

        if (pi instanceof OrbitTiledImage2) {
            // fluo channels for classification
            IOrbitImageMultiChannel multiChannelImage = getMultiChannelImage(); // might return null
            if (multiChannelImage!=null && featureDescription.getActiveFluoChannels()!=null && featureDescription.getActiveFluoChannels().length>0 && multiChannelImage.getChannelNames()!=null && multiChannelImage.getChannelNames().length>0) {
                HashSet<String> activeChannelLookup = new HashSet<>(Arrays.asList(featureDescription.getActiveFluoChannels()));
                float[] channelContributions = new float[multiChannelImage.getChannelNames().length];
                for (int c=0; c<channelContributions.length; c++) {
                    String channelName = OrbitUtils.cleanChannelName(multiChannelImage.getChannelNames()[c]);
                    channelContributions[c] = activeChannelLookup.contains(channelName)? 1f : 0f;
                }
                ((OrbitTiledImage2) pi).setChannelContributionsClassification(channelContributions);
            }
        }

        if (featureDescription.getNumBlur() > 0) {
            MedianFilter medianFilter = new MedianFilter();
            medianFilter.setParameter(pi, featureDescription.getNumBlur());
            pi = medianFilter.process();
        }


        if (featureDescription.isUseImageAdjustments() && imageAdjustments != null) {
            logger.trace("image adjustments available, will be used for modified image");

            if (Math.abs(imageAdjustments.getBrightness()) > 0.01d) {
                pi = OrbitTiledImage2.adjustBrightness(pi, imageAdjustments.getBrightness());
            }
            if (imageAdjustments.getGamma() != 100) {
                pi = OrbitTiledImage2.adjustGamma(pi, imageAdjustments.getGamma(), cachedParams, this);
            }
            if ((imageAdjustments.getRed() != 0) || (imageAdjustments.getBlue() != 0) || (imageAdjustments.getGreen() != 0) || imageAdjustments.getContrast() != 100) {
                pi = OrbitTiledImage2.adjustContrast(pi, imageAdjustments.getRed(), imageAdjustments.getGreen(), imageAdjustments.getBlue(), (float) imageAdjustments.getContrast() / 100f, imageAdjustments.getBrightness(), cachedParams, this);
            }
        }

        return pi;
    }


    private OrbitTiledImage2 setOrWrapImage(PlanarImage img) {
        if (img instanceof OrbitTiledImage2) {
            return (OrbitTiledImage2) img;
        } else {
            // wrap PlanarImage
            try {
                return new OrbitTiledImagePlanarImage(img);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public OrbitTiledImage2 getImage() {
        //return getModifiedImage(OrbitImageAnalysis.getInstance().getModel().getFeatureDescription());
        return image;
    }


    protected void setImage(PlanarImage img) throws OrbitImageServletException {
        origImage = img;
        image = setOrWrapImage(img);

        //sampleModel = image.getSampleModel();
        //colorModel = image.getColorModel();
        width = image.getWidth();
        height = image.getHeight();
        tileGridXOffset = image.getTileGridXOffset();
        tileGridYOffset = image.getTileGridYOffset();
    }

	 
	 /*
     protected RenderedOp makeTiledImageObs(PlanarImage img) {
		  ImageLayout tileLayout = new ImageLayout(img);
	      tileLayout.setTileWidth(tileWidth);
	      tileLayout.setTileHeight(tileHeight);
	      RenderingHints tileHints = new RenderingHints(JAI.KEY_IMAGE_LAYOUT, tileLayout);
	      ParameterBlock pb = new ParameterBlock();
	      pb.addSource(img);
	      return JAI.create("format", pb, tileHints);
	   }
	 */

    @SuppressWarnings("unused")
    private String getTileInfo(PlanarImage img) {
        StringBuilder sb = new StringBuilder();
        //sb.append("imageName = "+imageName+"\n");
        sb.append("imageWidth = " + img.getWidth() + "\n");
        sb.append("imageHeight = " + img.getHeight() + "\n");
        sb.append("tileWidth = " + img.getTileWidth() + "\n");
        sb.append("tileHeight = " + img.getTileHeight() + "\n");
        sb.append("maxTileIndexX = " + (img.getMinTileX() + img.getNumXTiles() - 1) + "\n");
        sb.append("maxTileIndexY = " + (img.getMinTileY() + img.getNumYTiles() - 1) + "\n");
        sb.append("maxTileCordX = " + img.getMaxX() + "\n");
        sb.append("maxTileCordY = " + img.getMaxY() + "\n");
        sb.append("minTileIndexX = " + img.getMinTileX() + "\n");
        sb.append("minTileIndexY = " + img.getMinTileY() + "\n");
        sb.append("minTileCordX = " + img.getMinX() + "\n");
        sb.append("minTileCordY = " + img.getMinY() + "\n");
        sb.append("tileGridXOffset = " + img.getTileGridXOffset() + "\n");
        sb.append("tileGridYOffset = " + img.getTileGridYOffset() + "\n");
        // sb.append("tileCache: " + tileCache.getMemoryCapacity() / (1024 * 1024) + " MB");
        return sb.toString();
    }

    /**
     * Remove it when the new multi threaded drawImage version works fine!
     * <p>
     * Draws the image to graphics. It automatically chooses the best MIP if available unless mipNum is > -1.
     *
     * @param graphics
     * @param _vpOffsX
     * @param _vpOffsY
     * @param _vpWidth
     * @param _vpHeight
     * @param scale     0..100
     * @param mipNum    set to -1 for automatic MIP selection
     */
    @Deprecated
    public synchronized void drawImageSingleThread(Graphics2D graphics, double _vpOffsX, double _vpOffsY, double _vpWidth, double _vpHeight, double scale, int mipNum) {
        if (getImage() == null) return;
        double sc = scale / 100d;

        // if mipMaps are loaded, find the one with the best resolution (according to scale-size-ratio)
        if (generateMipMaps) {
            TiledImagePainter mip = null;
            if (mipMaps != null && sc < 0.9f) {
                for (int i = mipMaps.length - 1; i >= 0; i--) {
                    if (mipMaps[i] != null) {
                        if ((mipNum > -1 && mipNum == i) || (sc < (double) mipMaps[i].getWidth() / this.getWidth())) {
                            // System.out.println("scale:"+sc+" mipNr:"+i+" mipMapWidth:"+mipMaps[i].getWidth()+"  ratioMipMap:"+(double)mipMaps[i].getWidth()/this.getWidth());
                            mip = mipMaps[i];
                            break;
                        }
                    }
                }
            }

			  
			  /*
              if ((sc<0.0625f/2f) && (mipMaps[4]!=null)) mip = mipMaps[4];
			  else if ((sc<0.0625f) && (mipMaps[3]!=null)) mip = mipMaps[3];
			  else if ((sc<0.125f) && (mipMaps[2]!=null)) mip = mipMaps[2];
			  else if ((sc<0.25f) && (mipMaps[1]!=null)) mip = mipMaps[1];
			  else if ((sc<0.5f) && (mipMaps[0]!=null)) mip = mipMaps[0];
			*/


            if (mip != null) {
                double mipScaleX = getImage().getWidth() / (double) mip.getWidth();
                double mipScaleY = getImage().getHeight() / (double) mip.getHeight();
                AffineTransform oldTrans = graphics.getTransform(); // push transformation
                graphics.scale(mipScaleX, mipScaleY);
                mip.drawImage(graphics, (_vpOffsX / mipScaleX), (_vpOffsY / mipScaleY), (_vpWidth / mipScaleX), (_vpHeight / mipScaleY), scale, -1);
                graphics.setTransform(oldTrans); // restore transformation
                return;
            }

        }


        //  System.out.println("mipmap1");
        double vpWidth = _vpWidth / sc;
        double vpHeight = _vpHeight / sc;
        double vpOffsX = _vpOffsX / sc;
        double vpOffsY = _vpOffsY / sc;

        int topIndex = Math.max(PlanarImage.YToTileY((int) vpOffsY, 0, getImage().getTileHeight()), getImage().getMinTileY());
        int bottomIndex = Math.min(PlanarImage.YToTileY((int) (vpOffsY + vpHeight), 0, getImage().getTileHeight()), getImage().getMaxTileY());
        int leftIndex = Math.max(PlanarImage.XToTileX((int) vpOffsX, 0, getImage().getTileWidth()), getImage().getMinTileX());
        int rightIndex = Math.min(PlanarImage.XToTileX((int) (vpOffsX + vpWidth), 0, getImage().getTileWidth()), getImage().getMaxTileX());

        // bandmerge op
        OrbitTiledImage2 imageMerged = getImage();
        float[] channelContributions = null;
        if (imageMerged instanceof OrbitTiledImageIOrbitImage) {
            IOrbitImage oi =  ((OrbitTiledImageIOrbitImage) imageMerged).getOrbitImage();
            if (oi instanceof IOrbitImageMultiChannel) {
                channelContributions = ((IOrbitImageMultiChannel) oi).getChannelContributions();
            }
        }

        for (int tj = topIndex; tj <= bottomIndex; tj++) {
            for (int ti = leftIndex; ti <= rightIndex; ti++) {
                tile = null;
                try {
                    tile = imageMerged.getTile(ti, tj, gamma, contrast, brightness, blur, redAdjust, greenAdjust, blueAdjust, redChannel, greenChannel, blueChannel, overlayChannel, redActive, greenActive, blueActive, deconvChannel, deconvName, channelContributions);
                } catch (Exception e) {
                    // tile not available (e.g. thread stopped), so do nothing
                }
                if (tile == null) return; // but return here
                dataBuffer = tile.getDataBuffer();


                wr = Raster.createWritableRaster(/*sampleModel*/ imageMerged.getSampleModel(),
                        dataBuffer, new Point(0, 0));
                // bi = new BufferedImage(/*colorModel*/imageMerged.getColorModel(),wr,imageMerged.getColorModel().isAlphaPremultiplied(),null);
                GraphicsConfiguration graphicConfig = graphics.getDeviceConfiguration();
                if (graphicConfig != null) {
                    bi = graphics.getDeviceConfiguration().createCompatibleImage(imageMerged.getSampleModel().getWidth(), imageMerged.getSampleModel().getHeight(), imageMerged.getColorModel().getTransparency());
                    bi.setData(wr);
                } else {
                    bi = new BufferedImage(imageMerged.getColorModel(), wr, imageMerged.getColorModel().isAlphaPremultiplied(), null);
                }

                if (bi == null) continue;


                // bound check
                if ((getImage().tileYToY(tj) + bi.getHeight() > getImage().getHeight())) {
                    bi = bi.getSubimage(0, 0, bi.getWidth(), bi.getHeight() - (getImage().tileYToY(tj) + bi.getHeight() - getImage().getHeight()));
                }
                if ((getImage().tileXToX(ti) + bi.getWidth() > getImage().getWidth())) {
                    bi = bi.getSubimage(0, 0, bi.getWidth() - (getImage().tileXToX(ti) + bi.getWidth() - getImage().getWidth()), bi.getHeight());
                }

                int xInTile = getImage().tileXToX(ti);
                int yInTile = getImage().tileYToY(tj);
                AffineTransform tx = AffineTransform.getTranslateInstance(xInTile, yInTile);
                //System.out.println("bi: "+bi.getWidth()+"x"+bi.getHeight()+" inTile: "+xInTile+"/"+yInTile);
                try {
                    graphics.drawRenderedImage(bi, tx);
                } catch (Throwable t) {
                    logger.trace("1.5 bug drawRenderedImage");  // happens with JRE 1.5, but everything seems to work fine anyway?
                }
            }
        }

		  /*
          // schedule tiles
		  int topIndexP = Math.max(PlanarImage.YToTileY(vpOffsY, 0, tileHeight), displayImage.getMinTileY());
		  int bottomIndexP = Math.min(PlanarImage.YToTileY(vpOffsY+vpHeight, 0, tileHeight), displayImage.getMaxTileY());
		  int leftIndexP = Math.max(PlanarImage.XToTileX(vpOffsX+vpWidth+1, 0, tileWidth), displayImage.getMinTileX());
		  int rightIndexP = Math.min(PlanarImage.XToTileX(vpOffsX+vpWidth+5, 0, tileWidth), displayImage.getMaxTileX());
		  ArrayList<Point> prefetchList = new ArrayList<Point>();
		  for(int tj = topIndexP; tj <= bottomIndexP; tj++) {
	          for(int ti = leftIndexP; ti <= rightIndexP; ti++) {
	        	  prefetchList.add(new Point(ti,tj));
	          }
	      }
		  displayImage.prefetchTiles(prefetchList.toArray(new Point[0]));
		  */


    }


    private synchronized GraphicsConfiguration getGraphicsConfig() {
        if (graphicsConfiguration==null) {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            if (!ge.isHeadlessInstance()) {
                GraphicsDevice[] gs = ge.getScreenDevices();
                if (gs != null && gs.length > 1) {
                    graphicsConfiguration = gs[0].getDefaultConfiguration();
                }
            }
        }
        return graphicsConfiguration;
    }

    public void drawImage(final Graphics2D graphics, double _vpOffsX, double _vpOffsY, double _vpWidth, double _vpHeight, double scale, int mipNum) {
        if (getImage() == null) return;
        double sc = scale / 100d;

        // if mipMaps are loaded, find the one with the best resolution (according to scale-size-ratio)
        if (generateMipMaps) {
            TiledImagePainter mip = null;
            if (mipMaps != null && sc < 0.9f) {
                for (int i = mipMaps.length - 1; i >= 0; i--) {
                    if (mipMaps[i] != null) {
                        if ((mipNum > -1 && mipNum == i) || (sc < (double) mipMaps[i].getWidth() / this.getWidth())) {
                            // System.out.println("scale:"+sc+" mipNr:"+i+" mipMapWidth:"+mipMaps[i].getWidth()+"  ratioMipMap:"+(double)mipMaps[i].getWidth()/this.getWidth());
                            mip = mipMaps[i];
                            break;
                        }
                    }
                }
            }

            if (mip != null) {
                double mipScaleX = getImage().getWidth() / (double) mip.getWidth();
                double mipScaleY = getImage().getHeight() / (double) mip.getHeight();
                AffineTransform oldTrans = graphics.getTransform(); // push transformation
                graphics.scale(mipScaleX, mipScaleY);
                mip.drawImage(graphics, (_vpOffsX / mipScaleX), (_vpOffsY / mipScaleY), (_vpWidth / mipScaleX), (_vpHeight / mipScaleY), scale, -1);
                graphics.setTransform(oldTrans); // restore transformation
                return;
            }

        }


        //  System.out.println("mipmap1");
        double vpWidth = _vpWidth / sc;
        double vpHeight = _vpHeight / sc;
        double vpOffsX = _vpOffsX / sc;
        double vpOffsY = _vpOffsY / sc;

        int topIndex = Math.max(PlanarImage.YToTileY((int) vpOffsY, 0, getImage().getTileHeight()), getImage().getMinTileY());
        int bottomIndex = Math.min(PlanarImage.YToTileY((int) (vpOffsY + vpHeight), 0, getImage().getTileHeight()), getImage().getMaxTileY());
        int leftIndex = Math.max(PlanarImage.XToTileX((int) vpOffsX, 0, getImage().getTileWidth()), getImage().getMinTileX());
        int rightIndex = Math.min(PlanarImage.XToTileX((int) (vpOffsX + vpWidth), 0, getImage().getTileWidth()), getImage().getMaxTileX());

        // bandmerge op
        final OrbitTiledImage2 imageMerged = getImage();
        float[] channelContributionsTemp = null;
        if (imageMerged instanceof OrbitTiledImageIOrbitImage) {
            IOrbitImage oi =  ((OrbitTiledImageIOrbitImage) imageMerged).getOrbitImage();
            if (oi instanceof IOrbitImageMultiChannel) {
                channelContributionsTemp = ((IOrbitImageMultiChannel) oi).getChannelContributions();
            }
        }
        final float[] channelContributions = channelContributionsTemp;
        final List<Callable<Void>> taskList = new ArrayList<Callable<Void>>();
        for (int tji = topIndex; tji <= bottomIndex; tji++) {
            for (int tii = leftIndex; tii <= rightIndex; tii++) {
                final int tj = tji;
                final int ti = tii;
                final Callable<Void> renderTile = new Callable<Void>() {
                    @Override
                    public Void call() {
                        BufferedImage bi;
                        WritableRaster wr;
                        DataBuffer dataBuffer;
                        Raster tile;

                        tile = null;
                        try {
                            tile = imageMerged.getTile(ti, tj, gamma, contrast, brightness, blur, redAdjust, greenAdjust, blueAdjust, redChannel, greenChannel, blueChannel, overlayChannel, redActive, greenActive, blueActive, deconvChannel, deconvName, channelContributions);
                        } catch (Exception e) {
                            // tile not available (e.g. thread stopped), so do nothing
                            return null; // s.th. went wrong (e.g. no network), so nothing to render
                        }
                        if (tile == null) return null; // but return here
                        dataBuffer = tile.getDataBuffer();


                        wr = Raster.createWritableRaster(/*sampleModel*/ imageMerged.getSampleModel(),
                                dataBuffer, new Point(0, 0));
                        //BufferedImage bim = new BufferedImage(imageMerged.getColorModel(),wr,imageMerged.getColorModel().isAlphaPremultiplied(),null);
                        GraphicsConfiguration graphicConfig = getGraphicsConfig();
                        if (graphicConfig != null) {
                            bi = graphicConfig.createCompatibleImage(imageMerged.getSampleModel().getWidth(), imageMerged.getSampleModel().getHeight(), imageMerged.getColorModel().getTransparency());
                            bi.setData(wr);
                        } else {
                            bi = new BufferedImage(imageMerged.getColorModel(), wr, imageMerged.getColorModel().isAlphaPremultiplied(), null);
                        }


                        if (bi == null) return null;
                        // bound check
                        if ((getImage().tileYToY(tj) + bi.getHeight() > getImage().getHeight())) {
                            bi = bi.getSubimage(0, 0, bi.getWidth(), bi.getHeight() - (getImage().tileYToY(tj) + bi.getHeight() - getImage().getHeight()));
                        }
                        if ((getImage().tileXToX(ti) + bi.getWidth() > getImage().getWidth())) {
                            bi = bi.getSubimage(0, 0, bi.getWidth() - (getImage().tileXToX(ti) + bi.getWidth() - getImage().getWidth()), bi.getHeight());
                        }

                        int xInTile = getImage().tileXToX(ti);
                        int yInTile = getImage().tileYToY(tj);
                        AffineTransform tx = AffineTransform.getTranslateInstance(xInTile, yInTile);
                        synchronized (graphics)
                        {
                            graphics.drawRenderedImage(bi, tx);
                        }
                        return null;
                    }
                };
                taskList.add(renderTile);
            }

            try {
                TiledImagePainter.executorService.invokeAll(taskList, 5, TimeUnit.SECONDS);
            } catch (Exception e) {
                logger.warn("ORBITERR00320: error rendering tile", e);
            }


        }

    }


    private PlanarImage gammaCorrection(PlanarImage source, double gammaValue) {
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(source);   // The source image
        pb.add(null);        // The region of the image to scan
        pb.add(100);         // The horizontal sampling rate
        pb.add(100);         // The vertical sampling rate
        RenderedOp op = JAI.create("extrema", pb);
        double[][] extrema = (double[][]) op.getProperty("extrema");
        double minValue = Math.min(Math.min(extrema[0][0], extrema[1][0]), extrema[2][0]);
        double maxValue = Math.max(Math.max(extrema[0][1], extrema[1][1]), extrema[2][1]);

        // TODO: gamma per channel?
        byte[] lut = new byte[256];
        double scale = 255.0 / (maxValue - minValue);
        double gammaPower = 1.0 / gammaValue;
        for (int i = (int) minValue; i < (int) maxValue; i++) {
            if (gammaValue == 1.0f) {
                lut[i] = (byte) ((i - minValue) * scale);
            } else {
                lut[i] = (byte) ((Math.pow(i / 255.0, gammaPower) * 255.0 - minValue) * scale);
            }
        }
        for (int i = 0; i < minValue; i++) {
            lut[i] = 0;
        }
        for (int i = (int) maxValue; i < 256; i++) {
            lut[i] = (byte) 255;
        }
        LookupTableJAI lookup = new LookupTableJAI(lut);
        pb = new ParameterBlock();
        pb.addSource(source);
        pb.add(lookup);
        return JAI.create("lookup", pb, ManipulationUtils.getRenderingHints(getImage()));
    }


    @SuppressWarnings("unused")
    private BufferedImage getTileAsBufferedImage(int tileX, int tileY) {
        Raster tile = getImage().getTile(tileX, tileY);
        DataBuffer dataBuffer = tile.getDataBuffer();
        WritableRaster wr = Raster.createWritableRaster(/*sampleModel*/getImage().getSampleModel(),
                dataBuffer, new Point(0, 0));
        BufferedImage bi = new BufferedImage(/*colorModel*/getImage().getColorModel(),
                wr,
                getImage().getColorModel().isAlphaPremultiplied(),
                null);
        return bi;
    }


    public BufferedImage getPreviewImage(int sizeX, int sizeY) {
        if ((mipMaps != null) && (mipMaps.length > 0) && (mipMaps[mipMaps.length - 1] != null)) {
            BufferedImage image = new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_INT_RGB);
            if (mipMaps[mipMaps.length - 1].getWidth() == 0) {
                logger.error("Error mipmap width=0");
                return null;
            }
            //System.out.println("length: "+mipMaps.length+" last dims: "+mipMaps[mipMaps.length-1].getImage().getWidth());
            image.getGraphics().drawImage(mipMaps[mipMaps.length - 1].getImage().getAsBufferedImage(), 0, 0, sizeX, sizeY, null);
            return image;
        } else {
            Object source = null;
//			Object source = sourceImage;
//			if (sourceImage instanceof RawDataFile) {
//				source = DALConfig.getImageProvider().getRawDataFileUrl((RawDataFile) sourceImage);
//			}
            return TiffConverter.getDownsampledImage(getImage(), source, sizeX, sizeY, this.getType(), false, 1);
        }
    }


    public int getTileWidth() {
        return getImage().getTileWidth();
    }


    public int getTileHeight() {
        return getImage().getTileHeight();
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public int getTileGridXOffset() {
        return tileGridXOffset;
    }

    public int getTileGridYOffset() {
        return tileGridYOffset;
    }

    public void setTileGridXOffset(int tileGridXOffset) {
        this.tileGridXOffset = tileGridXOffset;
    }

    public void setTileGridYOffset(int tileGridYOffset) {
        this.tileGridYOffset = tileGridYOffset;
    }

//    public TileCache getTileCache() {
//        return tileCache;
//    }
//
//
//    public void setTileCache(TileCache tileCache) {
//        this.tileCache = tileCache;
//    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }


    public void setMipMaps(TiledImagePainter[] mipMaps) {
        this.mipMaps = mipMaps;
    }

    public TiledImagePainter[] getMipMaps() {
        return mipMaps;
    }

    public boolean isGenerateMipMaps() {
        return generateMipMaps;
    }

    public void setGenerateMipMaps(boolean generateMipMaps) {
        this.generateMipMaps = generateMipMaps;
    }

    public boolean hasMipMaps() {
        return (mipMaps != null && mipMaps.length > 0);
    }

    public void setChannel(PlanarImage channel, int chanNr) {
        switch (chanNr) {
            case CHANNEL_RED: {
                setRedChannel(channel);
                break;
            }
            case CHANNEL_GREEN: {
                setGreenChannel(channel);
                break;
            }
            case CHANNEL_BLUE: {
                setBlueChannel(channel);
                break;
            }
            case CHANNEL_OVERLAY: {
                setOverlayChannel(channel);
                break;
            }
        }
    }

    public PlanarImage getChannel(int chanNr) {
        switch (chanNr) {
            case CHANNEL_RED: {
                return getRedChannel();
            }
            case CHANNEL_GREEN: {
                return getGreenChannel();
            }
            case CHANNEL_BLUE: {
                return getBlueChannel();
            }
            case CHANNEL_OVERLAY: {
                return getOverlayChannel();
            }
            default:
                return null;
        }
    }

    public void setChannelRdfId(int rdfId, int chanNr) {
        switch (chanNr) {
            case CHANNEL_RED: {
                setRedChannelRdfId(rdfId);
                break;
            }
            case CHANNEL_GREEN: {
                setGreenChannelRdfId(rdfId);
                break;
            }
            case CHANNEL_BLUE: {
                setBlueChannelRdfId(rdfId);
                break;
            }
            case CHANNEL_OVERLAY: {
                setOverlayChannelRdfId(rdfId);
                break;
            }
        }
    }

    public int getChannelRdfId(int chanNr) {
        switch (chanNr) {
            case CHANNEL_RED: {
                return getRedChannelRdfId();
            }
            case CHANNEL_GREEN: {
                return getGreenChannelRdfId();
            }
            case CHANNEL_BLUE: {
                return getBlueChannelRdfId();
            }
            case CHANNEL_OVERLAY: {
                return getOverlayChannelRdfId();
            }
            default:
                return 0;
        }
    }

    public int getRedChannelRdfId() {
        return redChannelRdfId;
    }

    public void setRedChannelRdfId(int redChannelRdfId) {
        this.redChannelRdfId = redChannelRdfId;
    }

    public int getGreenChannelRdfId() {
        return greenChannelRdfId;
    }

    public void setGreenChannelRdfId(int greenChannelRdfId) {
        this.greenChannelRdfId = greenChannelRdfId;
    }

    public int getBlueChannelRdfId() {
        return blueChannelRdfId;
    }

    public void setBlueChannelRdfId(int blueChannelRdfId) {
        this.blueChannelRdfId = blueChannelRdfId;
    }

    public OrbitTiledImage2 getRedChannel() {
        return redChannel;
    }

    public void setRedChannel(PlanarImage redChannel) {
        //this.redChannel = redChannel;
        this.redChannel = setOrWrapImage(redChannel);
    }

    public OrbitTiledImage2 getGreenChannel() {
        return greenChannel;
    }

    public void setGreenChannel(PlanarImage greenChannel) {
        //this.greenChannel = greenChannel;
        this.greenChannel = setOrWrapImage(greenChannel);
    }

    public OrbitTiledImage2 getBlueChannel() {
        return blueChannel;
    }

    public void setBlueChannel(PlanarImage blueChannel) {
        //this.blueChannel = blueChannel;
        this.blueChannel = setOrWrapImage(blueChannel);
    }

    public OrbitTiledImage2 getOverlayChannel() {
        return overlayChannel;
    }

    public void setOverlayChannel(PlanarImage overlayChannel) {
        //this.overlayChannel = overlayChannel;
        this.overlayChannel = setOrWrapImage(overlayChannel);
    }

    public int getOverlayChannelRdfId() {
        return overlayChannelRdfId;
    }

    public void setOverlayChannelRdfId(int overlayChannelRdfId) {
        this.overlayChannelRdfId = overlayChannelRdfId;
    }

    public double getBrightness() {
        return brightness;
    }

    /**
     * Sets the brightness and for all embedded mipmaps, too.
     *
     * @param brightness
     */
    public void setBrightness(double brightness) {
        if (imageAdjustments == null) imageAdjustments = new OrbitUtils.ImageAdjustments();
        imageAdjustments.setBrightness((int) brightness);
        this.brightness = brightness;
        // and also for all embedded mipMaps
        if (mipMaps != null) {
            for (TiledImagePainter tip : mipMaps) {
                tip.setBrightness(brightness);
            }
        }
    }

    public double getContrast() {
        return contrast;
    }

    public void setContrast(double contrast) {
        if (imageAdjustments == null) imageAdjustments = new OrbitUtils.ImageAdjustments();
        imageAdjustments.setContrast((int) contrast);
        this.contrast = contrast;
        if (mipMaps != null) {
            for (TiledImagePainter tip : mipMaps) {
                tip.setContrast(contrast);
            }
        }
    }

    public int getBlur() {
        return blur;
    }

    public void setBlur(int blur) {
        this.blur = blur;
    }

    public double getRedAdjust() {
        return redAdjust;
    }

    public void setRedAdjust(double redAdjust) {
        if (imageAdjustments == null) imageAdjustments = new OrbitUtils.ImageAdjustments();
        imageAdjustments.setRed((int) redAdjust);
        this.redAdjust = redAdjust;
        if (mipMaps != null) {
            for (TiledImagePainter tip : mipMaps) {
                tip.setRedAdjust(redAdjust);
            }
        }
    }

    public double getGreenAdjust() {
        return greenAdjust;
    }

    public void setGreenAdjust(double greenAdjust) {
        if (imageAdjustments == null) imageAdjustments = new OrbitUtils.ImageAdjustments();
        imageAdjustments.setGreen((int) greenAdjust);
        this.greenAdjust = greenAdjust;
        if (mipMaps != null) {
            for (TiledImagePainter tip : mipMaps) {
                tip.setGreenAdjust(greenAdjust);
            }
        }
    }

    public double getBlueAdjust() {
        return blueAdjust;
    }

    public void setBlueAdjust(double blueAdjust) {
        if (imageAdjustments == null) imageAdjustments = new OrbitUtils.ImageAdjustments();
        imageAdjustments.setBlue((int) blueAdjust);
        this.blueAdjust = blueAdjust;
        // and also for all embedded mipMaps
        if (mipMaps != null) {
            for (TiledImagePainter tip : mipMaps) {
                tip.setBlueAdjust(blueAdjust);
            }
        }
    }

    public double getGamma() {
        return gamma;
    }

    public void setGamma(double gamma) {
        if (imageAdjustments == null) imageAdjustments = new OrbitUtils.ImageAdjustments();
        imageAdjustments.setGamma((int) gamma);
        this.gamma = gamma;
        if (mipMaps != null) {
            for (TiledImagePainter tip : mipMaps) {
                tip.setGamma(gamma);
            }
        }
    }

    public boolean isRedActive() {
        return redActive;
    }

    public void setRedActive(boolean redActive) {
        this.redActive = redActive;
        if (mipMaps != null) {
            for (TiledImagePainter tip : mipMaps) {
                tip.setRedActive(redActive);
            }
        }
    }

    public boolean isGreenActive() {
        return greenActive;
    }

    public void setGreenActive(boolean greenActive) {
        this.greenActive = greenActive;
        if (mipMaps != null) {
            for (TiledImagePainter tip : mipMaps) {
                tip.setGreenActive(greenActive);
            }
        }
    }

    public boolean isBlueActive() {
        return blueActive;
    }

    public void setBlueActive(boolean blueActive) {
        this.blueActive = blueActive;
        if (mipMaps != null) {
            for (TiledImagePainter tip : mipMaps) {
                tip.setBlueActive(blueActive);
            }
        }
    }

    public int getDeconvChannel() {
        return deconvChannel;
    }

    public void setDeconvChannel(int deconvChannel) {
        if (imageAdjustments == null) imageAdjustments = new OrbitUtils.ImageAdjustments();
        imageAdjustments.setDeconvChannel(deconvChannel);
        this.deconvChannel = deconvChannel;
        if (mipMaps != null) {
            for (TiledImagePainter tip : mipMaps) {
                tip.setDeconvChannel(deconvChannel);
            }
        }
    }

    public String getDeconvName() {
        return deconvName;
    }

    public void setDeconvName(String deconvName) {
        if (imageAdjustments == null) imageAdjustments = new OrbitUtils.ImageAdjustments();
        imageAdjustments.setDeconvName(deconvName);
        this.deconvName = deconvName;
        if (mipMaps != null) {
            for (TiledImagePainter tip : mipMaps) {
                tip.setDeconvName(deconvName);
            }
        }
    }

    /**
     * Sets the channelContributions in the image and all images of mip layers if the image is a IOrbitImageMultiChannel (otherwise it does nothing).
     * @param channelContributions
     */
    public void setChannelContributions(final float[] channelContributions) {
        if (image !=null && image instanceof OrbitTiledImageIOrbitImage) {
            IOrbitImage oi = ((OrbitTiledImageIOrbitImage) image).getOrbitImage();
            if (oi instanceof IOrbitImageMultiChannel) {
                final IOrbitImageMultiChannel oim = (IOrbitImageMultiChannel) oi;
                oim.setChannelContributions(channelContributions);
            }
        }
        if (mipMaps != null) {
            for (TiledImagePainter tip : mipMaps) {
                tip.setChannelContributions(channelContributions);
            }
        }
    }

    public OrbitUtils.ImageAdjustments getImageAdjustments() {
        return imageAdjustments;
    }

    public void setImageAdjustments(OrbitUtils.ImageAdjustments imageAdjustments) {
        this.imageAdjustments = imageAdjustments;
        /*
		if (mipMaps!=null) {
			for (TiledImagePainter tip : mipMaps) {
				tip.setImageAdjustments(imageAdjustments);
			}
		}
		*/
    }

    @Override
    public void close() throws IOException {
        if (image!=null) image.close();
        if (mipMaps!=null) {
            for (TiledImagePainter tip: mipMaps) {
                tip.close();
            }
        }
    }

    /**
     * Stops the rendering thread. Call at the end of an Orbit application!
     */
    /*
    public static void shutDown() {
        if (executorService!=null) {
            try {
                executorService.shutdown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    */
}
