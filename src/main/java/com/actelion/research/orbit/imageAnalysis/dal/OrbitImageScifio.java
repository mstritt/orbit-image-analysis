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
import io.scif.gui.AWTImageTools;
import net.imagej.axis.Axes;
import org.scijava.Context;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import static ucar.nc2.util.net.EasyX509TrustManager.logger;

public class OrbitImageScifio implements IOrbitImage {

    final int maxThumbWidth = 300;
    final protected SCIFIO scifio;
    final protected ThreadLocal<Reader> reader;
  //  final Metadata meta;
  //  final ImageMetadata iMeta;
    final String filename;
    final int xAxis;
    final int yAxis;
    final int channelAxis;
    final long optimalTileWidth;
    final long optimalTileHeight;
    final long tilesWide;
    final long tilesHigh;
    final int numLevels;
    final int level;
    final int planeIndex = 0;
    final boolean signed = true;
    final boolean interleaved;
    final ColorModel colorModel;
    final SampleModel sampleModel;
    final int numBands;
    final int numBandsOriginal;
    final int originalBitsPerSample;
    final boolean originalWasGrayScale;
    final int tileGridXOffset;
    final int tileGridYOffset;
    final int minX;
    final int minY;
    final long width;
    final long height;
    final int planarAxisCount;
    final long[] axesLengthsPlanar;


    public OrbitImageScifio(final String filename, final int level, final Context context) throws IOException, FormatException {
        this.filename = filename+"["+level+"]";
        this.level = level!=5?level:6;
        if (context==null) scifio = new SCIFIO();
        else scifio = new SCIFIO(context);
        reader = new ThreadLocal<Reader>() {
            @Override
            protected Reader initialValue() {
                try {
                    return scifio.initializer().initializeReader(filename);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
        Metadata meta = reader.get().getMetadata();

        numLevels =  reader.get().getImageCount();
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
        String ending = RawUtilsCommon.getExtension(filename,true);
        System.out.println("ending: "+ending);
        if (ending.equals("png")||ending.equals("jpg")||ending.equals("jpeg")||ending.equals("gif")||ending.equals("bmp")
            ||((width*height)<=(2048L*2048L))) {
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

        planarAxisCount = iMeta.getPlanarAxisCount();
        axesLengthsPlanar = iMeta.getAxesLengthsPlanar();

      //  numBandsOriginal = (int) extents[channelAxis];
        numBandsOriginal = 3;
        originalBitsPerSample = iMeta.getBitsPerPixel();
        interleaved = iMeta.getInterleavedAxisCount()>0;

        BufferedImage img = getPlane(0,0);
        colorModel = img.getColorModel();
        sampleModel = img.getSampleModel();
        numBands = sampleModel.getNumBands();
        //originalWasGrayScale = extents[channelAxis]==1;
        originalWasGrayScale = false;
        tileGridXOffset = img.getTileGridXOffset();
        tileGridYOffset = img.getTileGridYOffset();
        minX = img.getMinX();
        minY = img.getMinY();

        System.out.println(filename+" loaded: "+width+"x"+height);
    }


    private BufferedImage getBufferedImage(Plane p, int planeWidth, int planeHeight) {
        if (numBandsOriginal==1)
            return AWTImageTools.makeImage(p.getBytes(),planeWidth,planeHeight,signed);
        else {
            BufferedImage bi = AWTImageTools.makeRGBImage(p.getBytes(),numBandsOriginal,planeWidth,planeHeight,interleaved);
            //BufferedImage bi2 = gc[0].createCompatibleImage(planeWidth,planeHeight);
            //bi2.getGraphics().drawImage(bi,0,0,null);
            return bi;
        }
    }

    @Override
    public String readInfoString(String filename) throws OrbitImageServletException {
        return "";
    }

    @Override
    public Raster getTileData(int tileX, int tileY) {
        try {
            BufferedImage img = getPlane(tileX, tileY);
          //  BufferedImage bi = new BufferedImage(img.getWidth(),img.getHeight(),BufferedImage.TYPE_INT_RGB);
          //  bi.getGraphics().drawImage(img,0,0,null);
            return img.getRaster();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected BufferedImage getPlane(int tileX, int tileY) throws FormatException, IOException {
        long[] offsets = new long[planarAxisCount];
        long[] extents = new long[axesLengthsPlanar.length];
        //System.arraycopy(axesLengthsPlanar,0,extents,0,axesLengthsPlanar.length);
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
        try {
            Plane plane = reader.get().openPlane(level, planeIndex, offsets, extents);
            return getBufferedImage(plane, (int) extents[xAxis], (int) extents[yAxis]);
        } catch (NullPointerException no) {
            System.out.println("offsets: "+offsets);
            no.printStackTrace();
            return null;
        }
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
//         if (scifio!=null) {
//             try {
//                 scifio.getContext().dispose();
//             } catch (Exception e) {
//             }
//         }
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
         boolean thumbIOnterleaved = interleaved; // but might change per layer!
         Metadata meta = reader.get().getMetadata();
         for (int lev=numLevels-1; lev>=0; lev--) {
             ImageMetadata iMeta = meta.get(lev);
             thumbLevel = lev;
             thumbW = iMeta.getAxisLength(Axes.X);
             thumbH = iMeta.getAxisLength(Axes.Y);
             thumbIOnterleaved = iMeta.getInterleavedAxisCount()>0;
             double diff = Math.abs((thumbW/(double)thumbH) - (width/(double)height));
             //System.out.println("lev: "+lev+"  diff: "+diff+"  isThumb: "+iMeta.isThumbnail());
             if (diff<0.001) break;
         }
        try {
            logger.trace("thumbnail level: "+thumbLevel+" size:"+thumbW+"x"+thumbH);
            Plane p = reader.get().openPlane(thumbLevel,0);
           // BufferedImage  thumb = getBufferedImage(p,(int)thumbW,(int)thumbH);
            BufferedImage thumb = AWTImageTools.makeRGBImage(p.getBytes(),numBandsOriginal,(int)thumbW,(int)thumbH,thumbIOnterleaved);
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
        final String testImage = "C:\\temp\\brain.ndpi";
        //final String testImage = "D:\\pic\\fibers.jpg";
        OrbitImageScifio oi = new OrbitImageScifio(testImage,5, null);
        //OrbitTiledImage2 img = new OrbitTiledImageIOrbitImage(oi);
        BufferedImage bi = new BufferedImage(oi.getColorModel(),  (WritableRaster) oi.getTileData(0,0) , oi.getColorModel().isAlphaPremultiplied(), null);
      //  BufferedImage bi = new BufferedImage(img.getColorModel(),  (WritableRaster) img.getTile(1,1) , img.getColorModel().isAlphaPremultiplied(), null);

        //BufferedImage bi = oi.getThumbnail();

        System.out.println("img: "+bi);
        ImageIO.write(bi,"jpeg",new File("d:/test.jpg"));
        oi.close();
    }
}
