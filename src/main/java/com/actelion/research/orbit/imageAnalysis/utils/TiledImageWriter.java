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

package com.actelion.research.orbit.imageAnalysis.utils;

import org.jaitools.tiledimage.DiskMemImageOrbit;

import javax.media.jai.PlanarImage;
import javax.media.jai.TiledImage;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;


public class TiledImageWriter {

    protected transient TiledImage image;
    public static int IMAGE_RGBA = 0;
    public static int IMAGE_RGB = 1;
    protected int tileWidth = OrbitUtils.TILE_SIZE, tileHeight = OrbitUtils.TILE_SIZE;
    transient protected SampleModel sampleModel;
    protected ColorModel colorModel;
    private String imageName = "";
    private int width = 0, height = 0;
    private Raster r;  // just for getPixel
    private final static int maxRenderingTime = 1000; // ms
    public final static AtomicLong timeOut = new AtomicLong(0L);
    private final AtomicBoolean painting = new AtomicBoolean(false);
    private long lastRepaint = 0;
    private RenderPos lastRenderPos = new RenderPos(0, 0, 0, 0, 0, 0);

    public TiledImageWriter(int width, int height, int tileWidth, int tileHeight) {
        this(width, height, TiledImageWriter.IMAGE_RGBA, tileWidth, tileHeight);
    }

    public TiledImageWriter(int width, int height, int imageType, int tileWidth, int tileHeight) {
        /*
         DiskMemImage.getCommonTileCache().setMemoryCapacity(AparUtils.DISK_IMAGE_CACHE);
		 DiskMemImage.getCommonTileCache().setAutoFlushMemoryEnabled(AparUtils.DISK_IMAGE_AUTO_FLUSH);
		 DiskMemImage.getCommonTileCache().setAutoFlushMemoryInterval(AparUtils.DISK_IMAGE_AUTO_FLUSH_TIME);
		 DiskMemImage.getCommonTileCache().flush();
		*/

        this.width = width;
        this.height = height;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;

        if (imageType == TiledImageWriter.IMAGE_RGBA) {
            colorModel = new ComponentColorModel(
                    ColorSpace.getInstance(ColorSpace.CS_sRGB),
                    new int[]{8, 8, 8, 8}, true, false,
                    Transparency.TRANSLUCENT,
                    DataBuffer.TYPE_BYTE);
        } else {
            colorModel = new ComponentColorModel(
                    ColorSpace.getInstance(ColorSpace.CS_sRGB),
                    new int[]{8, 8, 8}, false, false,
                    Transparency.OPAQUE,
                    DataBuffer.TYPE_BYTE);
        }


        //BufferedImage imgCol = new BufferedImage(2, 2, BufferedImage.TYPE_INT_ARGB);
        //colorModel = imgCol.getColorModel();
        sampleModel = colorModel.createCompatibleSampleModel(tileWidth, tileHeight);

        DiskMemImageOrbit dmi = new DiskMemImageOrbit(0, 0, width, height, 0, 0, sampleModel, colorModel);
        dmi.setUseCommonCache(true);
        setImage(dmi);

        // System.out.println("TiledImageWriter Info: ");
        // System.out.println(getTileInfo(image));
    }

    public TiledImageWriter(PlanarImage inputImage) {
        this(inputImage, 0, 0);
    }

    public TiledImageWriter(PlanarImage inputImage, int xOffs, int yOffs) {
        this.width = inputImage.getWidth();
        this.height = inputImage.getHeight();
        this.tileWidth = inputImage.getTileWidth();
        this.tileHeight = inputImage.getTileHeight();
        colorModel = new ComponentColorModel(
                ColorSpace.getInstance(ColorSpace.CS_sRGB),
                new int[]{8, 8, 8, 8}, true, false,
                Transparency.TRANSLUCENT,
                DataBuffer.TYPE_BYTE);
        sampleModel = colorModel.createCompatibleSampleModel(tileWidth, tileHeight);
        image = new DiskMemImageOrbit(xOffs, yOffs, width, height, 0, 0, sampleModel, colorModel);
        ((DiskMemImageOrbit) image).setUseCommonCache(true);

        TiledImagePainter painter = new TiledImagePainter(inputImage, "");
        Graphics2D g2d = image.createGraphics();
        try { // 03.05.2010 Manuel (exception with JRE 1.5, with JRE 1.6 fine)
            painter.drawImage(g2d, xOffs, yOffs, width, height, 100d, -1);
        } catch (Throwable e) {
            //System.out.println("TiledImageWriter Error",e);
            //e.printStackTrace();
        }
    }

    public TiledImageWriter(PlanarImage inputImage, SampleModel sampleModel, ColorModel colorModel, int xOffs, int yOffs) {
        this.width = inputImage.getWidth();
        this.height = inputImage.getHeight();
        this.tileWidth = inputImage.getTileWidth();
        this.tileHeight = inputImage.getTileHeight();
        image = new DiskMemImageOrbit(xOffs, yOffs, width, height, 0, 0, sampleModel, colorModel);
        ((DiskMemImageOrbit) image).setUseCommonCache(true);

        TiledImagePainter painter = new TiledImagePainter(inputImage, "");
        Graphics2D g2d = image.createGraphics();
        try { // 03.05.2010 Manuel (exception with JRE 1.5, with JRE 1.6 fine)
            painter.drawImage(g2d, xOffs, yOffs, width, height, 100d, -1);
        } catch (Throwable e) {
            //System.out.println("TiledImageWriter Error",e);
            //e.printStackTrace();
        }
    }

    public TiledImageWriter(BufferedImage inputImage) {
        this.width = inputImage.getWidth();
        this.height = inputImage.getHeight();
        colorModel = new ComponentColorModel(
                ColorSpace.getInstance(ColorSpace.CS_sRGB),
                new int[]{8, 8, 8, 8}, true, false,
                Transparency.TRANSLUCENT,
                DataBuffer.TYPE_BYTE);
        sampleModel = colorModel.createCompatibleSampleModel(tileWidth, tileHeight);
        // image = new DiskMemImage(0,0,width,height,0,0,sampleModel,colorModel);
        //image = new TiledImage(0,0,width,height,0,0,sampleModel,colorModel);
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        //Graphics2D g2d = image.createGraphics();
        Graphics2D g2d = bi.createGraphics();
        // try {
        // 03.05.2010 Manuel: DiskMemImage (exception with JRE 1.5, with JRE 1.6 fine)
        // 13.02.2012 Manuel: Therefore use bufferedImage / tiledImage for small inputImages (bufferedImage) which also works with java 1.5
        g2d.drawImage(inputImage, 0, 0, null);
//		 } catch (Throwable e) {
//			 System.out.println("TiledImageWriter Error",e);
//			 e.printStackTrace();
//		 }
        image = new TiledImage(bi, false);
        bi = null;
    }

    public void setPixel(int x, int y, int[] RGBA) {
        int tx = TiledImage.XToTileX(x, 0, tileWidth);
        int ty = TiledImage.YToTileY(y, 0, tileHeight);
        WritableRaster writeRaster = getImage().getWritableTile(tx, ty);
        if (writeRaster != null) {
            writeRaster.setPixel(x, y, RGBA);
        }
        getImage().releaseWritableTile(tx, ty);
    }

    public WritableRaster getRaster() {
        return null;
    }


    private Raster getRaster(int x, int y) {
        int xt = PlanarImage.XToTileX(x, 0, tileWidth);
        int yt = PlanarImage.YToTileY(y, 0, tileHeight);
        Raster raster = getImage().getTile(xt, yt);
        return raster;
    }

    /**
     * Returns the RGB value as int in sRGB colorspace from the image at position x,y. <br>
     * The needed tiles will be loaded.<br>
     * No border checking will be done due to performance.
     *
     * @param x
     * @param y
     * @return
     */
    public int getPixel(int x, int y) {
        r = getImage().getTile(getImage().XToTileX(x), getImage().YToTileY(y));
        //	 System.out.println("rgba: "+image.getSample(x, y, 0)+" "+image.getSample(x, y, 1)+" "+image.getSample(x, y, 2)+" "+image.getSample(x, y, 3));

        return ((255 & 0xFF) << 24) |
                ((r.getSample(x, y, 0) & 0xFF) << 16) |
                ((r.getSample(x, y, 1) & 0xFF) << 8) |
                ((r.getSample(x, y, 2) & 0xFF) << 0);

		 
		 
		 /*
         return new Color(image.getSample(x, y, 0),  // red
				 		  image.getSample(x, y, 1),  // green
				 		  image.getSample(x, y, 2))  // blue
		 			.getRGB();
		 */
        //colorModel.getRGB(pixel);
    }

    /**
     * Returns the RGB value as int in sRGB colorspace from the image at position x,y. <br>
     * The needed tile is given by parameter r.<br>
     * No border checking will be done due to performance.
     *
     * @param x
     * @param y
     * @return
     */
    public int getPixel(int x, int y, Raster r) {
        return ((255 & 0xFF) << 24) |
                ((r.getSample(x, y, 0) & 0xFF) << 16) |
                ((r.getSample(x, y, 1) & 0xFF) << 8) |
                ((r.getSample(x, y, 2) & 0xFF) << 0);
    }


    public double[] getPixels(int x, int y, int windowSize, double[] preInitArr) {
        double[] feats = preInitArr;
        if (feats == null) feats = new double[(windowSize * 2 + 1) * (windowSize * 2 + 1) * 3 + 1];

        int idx = 0;
        // window
        for (int px = x - windowSize; px <= x + windowSize; px++)
            for (int py = y - windowSize; py <= y + windowSize; py++) {
                if (px < 0) px = 0;
                if (px >= width - 1) px = width - 1;
                if (py < 0) py = 0;
                if (py >= height - 1) py = height - 1;

                double[] col = getRaster(px, py).getPixel(px, py, new double[3]);
                feats[idx] = col[0];
                idx++;
                feats[idx] = col[1];
                idx++;
                feats[idx] = col[2];
                idx++;
            }
        return feats;
    }

    public int getType() {
        if (colorModel == null) return BufferedImage.TYPE_INT_RGB;
        if (colorModel.hasAlpha()) return BufferedImage.TYPE_INT_ARGB;
        else return BufferedImage.TYPE_INT_RGB;
    }

	 
	 /*
	 protected RenderedOp makeTiledImage(TiledImage img) {
	      ImageLayout tileLayout = new ImageLayout(img);
	      tileLayout.setTileWidth(tileWidth);
	      tileLayout.setTileHeight(tileHeight);
	      tileLayout.setSampleModel(sampleModel);
	      tileLayout.setColorModel(colorModel);
	      RenderingHints tileHints = new RenderingHints(JAI.KEY_IMAGE_LAYOUT, tileLayout);
	      ParameterBlock pb = new ParameterBlock();
	      pb.addSource(img);
	      return JAI.create("format", pb, tileHints);
	   }
	 */

    @SuppressWarnings("unused")
    private String getTileInfo(DiskMemImageOrbit img) {
        StringBuilder sb = new StringBuilder();
        sb.append("imageName = " + imageName + "\n");
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
        sb.append("tileCache: " + DiskMemImageOrbit.getCommonTileCache().getMemoryCapacity() / (1024 * 1024) + " MB");
        return sb.toString();
    }


    /**
     * ROIBB defines the boundingbox of the ROI. Only tiles inside this bb will be rendered.
     *
     * @param graphics
     * @param _vpOffsX
     * @param _vpOffsY
     * @param _vpWidth
     * @param _vpHeight
     * @param scale
     * @param opacity
     */
    public void drawImage(final Graphics2D graphics, final int _vpOffsX, final int _vpOffsY, final int _vpWidth, final int _vpHeight, final double scale, final float opacity) {
        drawImageSingleThread(graphics, _vpOffsX, _vpOffsY, _vpWidth, _vpHeight, scale, opacity);
        //drawImageMultiThread(graphics,_vpOffsX,_vpOffsY,_vpWidth,_vpHeight,scale, opacity);
    }

    /**
     * ROIBB defines the boundingbox of the ROI. Only tiles inside this bb will be rendered.  Multi threaded version.
     * @param graphics
     * @param _vpOffsX
     * @param _vpOffsY
     * @param _vpWidth
     * @param _vpHeight
     * @param scale
     * @param opacity
     */
        /*
	  public void drawImageMultiThread(final Graphics2D graphics, final int _vpOffsX, final int _vpOffsY, final int _vpWidth, final int _vpHeight, final double scale, final float opacity) {
		  if (getImage()==null) return;
		  double sc = scale/100d;

		  int vpWidth = (int)(_vpWidth / sc);
		  int vpHeight = (int)(_vpHeight / sc);
		  int vpOffsX = (int)(_vpOffsX / sc);
		  int vpOffsY = (int)(_vpOffsY / sc);

		  int topIndex = Math.max(TiledImage.YToTileY(vpOffsY, 0, tileHeight), getImage().getMinTileY());
		  int bottomIndex = Math.min(TiledImage.YToTileY(vpOffsY+vpHeight, 0, tileHeight), getImage().getMaxTileY());
		  int leftIndex = Math.max(TiledImage.XToTileX(vpOffsX, 0, tileWidth), getImage().getMinTileX());
		  int rightIndex = Math.min(TiledImage.XToTileX(vpOffsX+vpWidth, 0, tileWidth), getImage().getMaxTileX());

		  final long start = System.currentTimeMillis();

		  final List<Point> tileInd = new ArrayList<>((bottomIndex-topIndex)*(rightIndex-leftIndex));
		  for(int tj = topIndex; tj <= bottomIndex; tj++) {
			  for(int ti = leftIndex; ti <= rightIndex; ti++) {
				   tileInd.add(new Point(ti,tj));
			  }
		  }

		  Collections.sort(tileInd, new TileSorter(leftIndex,rightIndex,topIndex,bottomIndex));  // render from middle to outside

		  final List<Callable<Void>> taskList= new ArrayList<Callable<Void>>();
		  timeOut.set(System.currentTimeMillis());

			for (Point tileP: tileInd) {

				  final int ti = tileP.x;
				  final int tj = tileP.y;

				final long startTime = System.currentTimeMillis();
				final Callable<Void> renderTile = new Callable<Void>() {
					 @Override
					 public Void call() throws Exception {
						 long usedTime = System.currentTimeMillis()-start;
						 if (usedTime>200L) return null;

//						 if (timeOut.get()>startTime) {
//							 System.out.println("canceled");
//							 return null;
//						 }

						 Raster tile = getImage().getTile(ti, tj);
						 DataBuffer dataBuffer = tile.getDataBuffer();
						 WritableRaster wr = Raster.createWritableRaster(sampleModel,
								 dataBuffer, new Point(0, 0));
						 BufferedImage bi;
						 GraphicsConfiguration graphicConfig = graphics.getDeviceConfiguration();
						 if (graphicConfig != null) {
							 bi = graphics.getDeviceConfiguration().createCompatibleImage(sampleModel.getWidth(), sampleModel.getHeight(), colorModel.getTransparency());
							 bi.setData(wr);
						 } else {
							 bi = new BufferedImage(colorModel, wr, colorModel.isAlphaPremultiplied(), null);
						 }

						 // if(bi == null) continue;

						 // bound check
						 if ((getImage().tileYToY(tj) + bi.getHeight() > getImage().getHeight())) {
							 bi = bi.getSubimage(0, 0, bi.getWidth(), bi.getHeight() - (getImage().tileYToY(tj) + bi.getHeight() - getImage().getHeight()));
						 }
						 if ((getImage().tileXToX(ti) + bi.getWidth() > getImage().getWidth())) {
							 bi = bi.getSubimage(0, 0, bi.getWidth() - (getImage().tileXToX(ti) + bi.getWidth() - getImage().getWidth()), bi.getHeight());
						 }


						 float[] scales = {1f, 1f, 1f, opacity};
						 float[] offsets = new float[4];
						 RescaleOp rop = new RescaleOp(scales, offsets, null);
						 int xInTile = (int) (getImage().tileXToX(ti));
						 int yInTile = (int) (getImage().tileYToY(tj));
						 ((Graphics2D) graphics).drawImage(bi, rop, xInTile, yInTile);
						 return null;
					 }
				 };
				 taskList.add(renderTile);

	          }

		  try {
			  //TiledImageWriter.executorService.invokeAll (taskList, maxRenderingTime, TimeUnit.MILLISECONDS);
			 ExecutorService executorService = Executors.newCachedThreadPool();
			  executorService.invokeAll (taskList);
			  executorService.shutdownNow();
		  } catch (Exception e) {
			  logger.warn("error rendering classification tile", e);
		  }

	 }
	 */


    /**
     * ROIBB defines the boundingbox of the ROI. Only tiles inside this bb will be rendered.  Single threaded version.
     *
     * @param graphics
     * @param _vpOffsX
     * @param _vpOffsY
     * @param _vpWidth
     * @param _vpHeight
     * @param scale
     * @param opacity
     */
    public void drawImageSingleThread(Graphics2D graphics, int _vpOffsX, int _vpOffsY, int _vpWidth, int _vpHeight, double scale, float opacity) {
        TiledImageWriter.timeOut.set(System.currentTimeMillis());
        if (painting.get()) return;
        painting.set(true);

//		RenderPos renderPos = new RenderPos(_vpOffsX, _vpOffsY, _vpWidth, _vpHeight, scale, opacity);
//		if (renderPos.equals(lastRenderPos)) return;
//		lastRenderPos = renderPos;


//		if (System.currentTimeMillis()-lastRepaint < 100) return;
//		lastRepaint = System.currentTimeMillis();

        long start = System.currentTimeMillis();
        if (getImage() == null) {
            painting.set(false);
            return;
        }

        double sc = scale / 100d;

        int vpWidth = (int) (_vpWidth / sc);
        int vpHeight = (int) (_vpHeight / sc);
        int vpOffsX = (int) (_vpOffsX / sc);
        int vpOffsY = (int) (_vpOffsY / sc);

        int topIndex = Math.max(TiledImage.YToTileY(vpOffsY, 0, tileHeight), getImage().getMinTileY());
        int bottomIndex = Math.min(TiledImage.YToTileY(vpOffsY + vpHeight, 0, tileHeight), getImage().getMaxTileY());
        int leftIndex = Math.max(TiledImage.XToTileX(vpOffsX, 0, tileWidth), getImage().getMinTileX());
        int rightIndex = Math.min(TiledImage.XToTileX(vpOffsX + vpWidth, 0, tileWidth), getImage().getMaxTileX());


        int capacity = (bottomIndex - topIndex) * (rightIndex - leftIndex);
        if (capacity < 0) return;  // classImage(roi) out of viewport
        List<Point> tileInd = new ArrayList<>(capacity);
        for (int tj = topIndex; tj <= bottomIndex; tj++) {
            for (int ti = leftIndex; ti <= rightIndex; ti++) {
                tileInd.add(new Point(ti, tj));
            }
        }

        Collections.sort(tileInd, new TileSorter(leftIndex, rightIndex, topIndex, bottomIndex));  // render from middle to outside

        for (Point tileP : tileInd) {
             /*
			try {
				AWTEvent event = java.awt.Toolkit.getDefaultToolkit().getSystemEventQueue().peekEvent();
				if (event != null) {
					//if (event.toString().contains("RepaintManager")) break;
					if (event.toString().contains("org.pushingpixels.trident.Timeline") ||
						event.toString().contains("java.awt.SentEvent")	) {
						TiledImageWriter.timeOut.set(System.currentTimeMillis());
					};
					System.out.println(event);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			*/


            final int ti = tileP.x;
            final int tj = tileP.y;

            long usedTime = System.currentTimeMillis() - start;
            if (usedTime > maxRenderingTime) {
                painting.set(false);
                break;
            }

            if (TiledImageWriter.timeOut.get() > start) {
                System.out.println("break");
                painting.set(false);
                break;
            } else {
                //System.out.println("paint: "+(TiledImageWriter.timeOut.get()-start));
            }

            Raster tile = getImage().getTile(ti, tj);
            DataBuffer dataBuffer = tile.getDataBuffer();
            WritableRaster wr = Raster.createWritableRaster(sampleModel,
                    dataBuffer, new Point(0, 0));
            BufferedImage bi;
            GraphicsConfiguration graphicConfig = graphics.getDeviceConfiguration();
            if (graphicConfig != null) {
                bi = graphics.getDeviceConfiguration().createCompatibleImage(sampleModel.getWidth(), sampleModel.getHeight(), colorModel.getTransparency());     // or volatil image???
                bi.setData(wr);
            } else {
                bi = new BufferedImage(colorModel, wr, colorModel.isAlphaPremultiplied(), null);
            }


            // if(bi == null) continue;

            // bound check
            if ((getImage().tileYToY(tj) + bi.getHeight() > getImage().getHeight())) {
                bi = bi.getSubimage(0, 0, bi.getWidth(), bi.getHeight() - (getImage().tileYToY(tj) + bi.getHeight() - getImage().getHeight()));
            }
            if ((getImage().tileXToX(ti) + bi.getWidth() > getImage().getWidth())) {
                bi = bi.getSubimage(0, 0, bi.getWidth() - (getImage().tileXToX(ti) + bi.getWidth() - getImage().getWidth()), bi.getHeight());
            }


            float[] scales = {1f, 1f, 1f, opacity};
            float[] offsets = new float[4];
            RescaleOp rop = new RescaleOp(scales, offsets, null);
            int xPos = getImage().tileXToX(ti);
            int yPos = getImage().tileYToY(tj);
            graphics.drawImage(bi, rop, xPos, yPos);
            //  AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity);
            //  AffineTransform tx = AffineTransform.getTranslateInstance(xInTile,yInTile);
            //  graphics.drawRenderedImage( bi, tx);

            bi.flush();
            //System.out.println(graphics.getDeviceConfiguration().getDevice().getAvailableAcceleratedMemory());
            painting.set(false);
        }

    }


    public AtomicBoolean getPainting() {
        return painting;
    }

    public int getTileWidth() {
        return tileWidth;
    }


    public int getTileHeight() {
        return tileHeight;
    }


    public void setTileWidth(int tileWidth) {
        this.tileWidth = tileWidth;
    }


    public void setTileHeight(int tileHeight) {
        this.tileHeight = tileHeight;
    }


    public int getWidth() {
        return width;
    }


    public int getHeight() {
        return height;
    }

    public void setImage(TiledImage image) {
        this.image = image;
    }

    public TiledImage getImage() {
        return image;
    }


    class RenderPos {
        private int x;
        private int y;
        private int width;
        private int height;
        private double scale;
        private float opacity;

        public RenderPos(int x, int y, int width, int height, double scale, float opacity) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.scale = scale;
            this.opacity = opacity;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            RenderPos renderPos = (RenderPos) o;

            if (x != renderPos.x) return false;
            if (y != renderPos.y) return false;
            if (width != renderPos.width) return false;
            if (height != renderPos.height) return false;
            if (Double.compare(renderPos.scale, scale) != 0.0001d) return false;
            return Float.compare(renderPos.opacity, opacity) == 0.001f;

        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            result = x;
            result = 31 * result + y;
            result = 31 * result + width;
            result = 31 * result + height;
            temp = Double.doubleToLongBits(scale);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            result = 31 * result + (opacity != +0.0f ? Float.floatToIntBits(opacity) : 0);
            return result;
        }
    }

}
