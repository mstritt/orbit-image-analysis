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

package com.actelion.research.orbit.imageAnalysis.dal;

import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.utils.RawUtilsCommon;
import io.scif.*;
import io.scif.config.SCIFIOConfig;
import io.scif.gui.AWTImageTools;
import net.imagej.axis.Axes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.media.jai.PlanarImage;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class OrbitImageScifio implements IOrbitImage {

    private static final Logger logger = LoggerFactory.getLogger(OrbitImageScifio.class);
    final int maxThumbWidth = 300;
    final protected ThreadLocal<SCIFIO> scifio;
    final protected ThreadLocal<Reader> reader;
  //  final Metadata meta;
  //  final ImageMetadata iMeta;
    private String filename;
    private int xAxis;
    private int yAxis;
    private int channelAxis;
    private long optimalTileWidth;
    private long optimalTileHeight;
    private long tilesWide;
    private long tilesHigh;
    private int numLevels;
    private int level;
    private int planeIndex = 0;
    private boolean signed = true;
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
    private int planarAxisCount;
   // private long[] axesLengthsPlanar;


    public OrbitImageScifio(final String filename, int level) throws IOException, FormatException {
        this.filename = filename+"["+level+"]";
        this.level = level;

        scifio = new ThreadLocal<SCIFIO>() {
            @Override
            protected SCIFIO initialValue() {
                return new SCIFIO();
            }
        };

//        Format format = scifio.get().format().getFormatFromClass(JPEG2000Format.class);
//        System.out.println("enabled: "+format.isEnabled());
//        Checker checker = format.createChecker();
//        System.out.println("isFormat: "+ checker.isFormat(filename, new SCIFIOConfig().checkerSetOpen(true)));

        final SCIFIOConfig config = new SCIFIOConfig();
        config.checkerSetOpen(true);

        reader = new ThreadLocal<Reader>() {
            @Override
            protected Reader initialValue() {
                try {
                    return scifio.get().initializer().initializeReader(filename,config);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
        Metadata meta = reader.get().getMetadata();

        numLevels =  reader.get().getImageCount();
        boolean levelOk;
        do {
            levelOk = true;
            if (this.level >= numLevels) { // or just > ?
                close();
                throw new OrbitImageServletException("image pyramid level " + this.level + " does not exist for image " + filename);
            }

            ImageMetadata iMeta = meta.get(this.level);

            xAxis = iMeta.getAxisIndex(Axes.X);
            yAxis = iMeta.getAxisIndex(Axes.Y);
            channelAxis = iMeta.getAxisIndex(Axes.CHANNEL);
            width = iMeta.getAxisLength(Axes.X);
            height = iMeta.getAxisLength(Axes.Y);

//      long optimalTileWidth2 = reader.get().getOptimalTileWidth(level);
//      long optimalTileHeight2 = reader.get().getOptimalTileHeight(level);
            long optimalTileWidth2 = 512;
            long optimalTileHeight2 = 512;
            String ending = RawUtilsCommon.getExtension(filename, true);
            if (ending.equals("png") || ending.equals("jpg") || ending.equals("jpeg") || ending.equals("gif") || ending.equals("bmp")
                    || ((width * height) <= (2048L * 2048L))) {
                optimalTileWidth2 = width;
                optimalTileHeight2 = height;
            }
            optimalTileWidth = optimalTileWidth2;
            optimalTileHeight = optimalTileHeight2;

            tilesWide =
                    (long) Math.ceil((double) width /
                            optimalTileWidth);
            tilesHigh =
                    (long) Math.ceil((double) height /
                            optimalTileHeight);

//            planarAxisCount = iMeta.getPlanarAxisCount();
//            axesLengthsPlanar = iMeta.getAxesLengthsPlanar();

            planarAxisCount = iMeta.getAxesLengths().length;

            //numBandsOriginal = iMeta.;
            if (channelAxis<0) numBandsOriginal = 1;
            else numBandsOriginal = (int) iMeta.getAxisLength(channelAxis);

            originalBitsPerSample = iMeta.getBitsPerPixel();
            interleaved = iMeta.getInterleavedAxisCount() > 0;
            try {
                BufferedImage img = getPlane(0, 0);
                colorModel = img.getColorModel();
                sampleModel = img.getSampleModel();
                numBands = sampleModel.getNumBands();
                //originalWasGrayScale = extents[channelAxis]==1;
                originalWasGrayScale = false;
                tileGridXOffset = img.getTileGridXOffset();
                tileGridYOffset = img.getTileGridYOffset();
                minX = img.getMinX();
                minY = img.getMinY();
            } catch (Exception e) {
                if (this.level<numLevels-1) {
                    this.level++;
                    levelOk=false;
                    logger.debug("error loading level "+this.level+" trying next level");
                }  else {
                    e.printStackTrace();
                    throw new OrbitImageServletException("error loading level " + this.level + " (and not more alternative levels available). File: "+filename);
                }
            }

        } while (!levelOk);

        System.out.println(filename+" loaded: "+width+"x"+height);
    }


    private BufferedImage getBufferedImage(Plane p, int planeWidth, int planeHeight) {
        BufferedImage bi;
        if (numBandsOriginal==1)
            bi = AWTImageTools.makeImage(p.getBytes(),planeWidth,planeHeight,signed);
        else {
            bi = AWTImageTools.makeRGBImage(p.getBytes(),numBandsOriginal,planeWidth,planeHeight,interleaved);
        }
     //   BufferedImage bi2 = new BufferedImage(planeWidth,planeHeight,BufferedImage.TYPE_INT_RGB);
      //  bi2.getGraphics().drawImage(bi,0,0,null);
        return bi;
    }

    @Override
    public String readInfoString(String filename) throws OrbitImageServletException {
        return "";
    }

    @Override
    public Raster getTileData(int tileX, int tileY) {
        try {
           BufferedImage img = getPlane(tileX, tileY);

           // ensure tiles have always full tileWifth and tileHeight (even at borders)
           if (img.getWidth()!=getTileWidth() || img.getHeight()!=getTileHeight())
           {
               BufferedImage bi = new BufferedImage(getTileWidth(), getTileHeight(), img.getType());
               //BufferedImage bi = new BufferedImage(getTileWidth(), getTileHeight(), BufferedImage.TYPE_INT_RGB);
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
        long[] offsets = new long[planarAxisCount];
        long[] extents = new long[planarAxisCount];
        //long[] extents = new long[axesLengthsPlanar.length];
        if (channelAxis>-1)
            extents[channelAxis] = numBandsOriginal;

        offsets[xAxis] = tileX * optimalTileWidth;
        offsets[yAxis] = tileY * optimalTileHeight;
        //offsets[channelAxis] = 0;

        // We also need to check the lengths of our tile, to see
        // if they would run outside the image - due to the plane
        // not being perfectly divisible by the tile dimensions.
        extents[xAxis] = Math.min(optimalTileWidth, width - offsets[xAxis]);
        extents[yAxis] = Math.min(optimalTileHeight, height - offsets[yAxis]);

        // Finally we open the current plane, using an openPlane signature
        // that allows us to specify a sub-region of the current plane.
        Plane plane = reader.get().openPlane(level, planeIndex, offsets, extents);
        return getBufferedImage(plane, (int) extents[xAxis], (int) extents[yAxis]);
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
        return (int)optimalTileWidth;
    }

    @Override
    public int getTileHeight() {
        return (int)optimalTileHeight;
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
        return colorModel;
    }

    @Override
    public SampleModel getSampleModel() {
        return sampleModel;
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
         if (reader!=null) {
             try {
                 reader.get().close();
             } catch (Exception e) {}
         }
         if (scifio.get()!=null) {
             try {
                 scifio.get().context().dispose();
             } catch (Exception e) {
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
         int thumbLevel = numLevels;
         long thumbW=1;
         long thumbH=1;
         boolean thumbInterleaved = interleaved; // but might change per layer!
         Metadata meta = reader.get().getMetadata();
         for (int lev=numLevels-1; lev>=0; lev--) {
             ImageMetadata iMeta = meta.get(lev);
             thumbLevel = lev;
             thumbW = iMeta.getAxisLength(Axes.X);
             thumbH = iMeta.getAxisLength(Axes.Y);
             thumbInterleaved = iMeta.getInterleavedAxisCount()>0;
             double diff = Math.abs((thumbW/(double)thumbH) - (width/(double)height));
             //System.out.println("lev: "+lev+"  diff: "+diff+"  isThumb: "+iMeta.isThumbnail());
             if (diff<0.001) break;
         }
        try {
            logger.trace("thumbnail level: "+thumbLevel+" size:"+thumbW+"x"+thumbH);
            Plane p = reader.get().openPlane(thumbLevel,0);
           // BufferedImage  thumb = getBufferedImage(p,(int)thumbW,(int)thumbH);
            BufferedImage thumb = AWTImageTools.makeRGBImage(p.getBytes(),numBandsOriginal,(int)thumbW,(int)thumbH,thumbInterleaved);
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

    public static void main(String[] args) throws Exception {
        //final String testImage = "C:\\temp\\495.svs";
       // final String testImage = "C:\\temp\\brain.ndpi";
      //  final String testImage = "D:\\pic\\Hamamatsu\\4x higher.ndpis";
        //final String testImage = "D:\\pic\\fibers.jpg";
       // final String testImage = "D:\\r08c17-2044837823.jp2";
        final String testImage = "D:\\pic\\Hamamatsu\\multitiff.tif";
      //  final String testImage = "D:\\pic\\mri\\MRI examples x Manuel\\Training Day2\\Dicoms\\Training_Day2_Rat1006_Brain\\30\\1\\0024.dcm";

      // final String testImage = "D:\\TetraTest.bmp";

        OrbitImageScifio oi = new OrbitImageScifio(testImage,0);
        //OrbitTiledImage2 img = new OrbitTiledImageIOrbitImage(oi);
        BufferedImage bi = new BufferedImage(oi.getColorModel(),  (WritableRaster) oi.getTileData(0,0) , oi.getColorModel().isAlphaPremultiplied(), null);
      //  BufferedImage bi = new BufferedImage(img.getColorModel(),  (WritableRaster) img.getTile(1,1) , img.getColorModel().isAlphaPremultiplied(), null);

        //BufferedImage bi = oi.getThumbnail();

        System.out.println("img: "+bi);
        ImageIO.write(bi,"png",new File("d:/test.png"));
        oi.close();
    }
}
