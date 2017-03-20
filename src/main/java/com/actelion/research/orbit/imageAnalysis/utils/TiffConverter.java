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

import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.utils.RawUtilsCommon;
import com.sun.media.jai.codec.*;
import ij.ImagePlus;
import ij.io.Opener;
import ij.process.ImageProcessor;
import loci.formats.ChannelSeparator;
import loci.formats.FormatException;
import loci.formats.in.LIFReader;
import loci.formats.in.ZeissZVIReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.MemoryCacheImageInputStream;
import javax.media.jai.*;
import javax.media.jai.operator.ScaleDescriptor;
import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.*;
import java.awt.image.renderable.ParameterBlock;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class TiffConverter {

    private static Logger logger = LoggerFactory.getLogger(TiffConverter.class);
    private static final double[] subtract_grey = new double[]{0};
    private static final double[] divide_grey = new double[]{1. / 16.};
    private static final double[] subtract_rgb = new double[]{0, 0, 0};
    private static final double[] divide_rgb = new double[]{1. / 16., 1. / 16., 1. / 16.};
    private static final ColorModel rgbColorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB), new int[]{8, 8, 8}, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
    private static final ColorModel greyColorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_GRAY), new int[]{8}, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);

    /**
     * SourceImage can be of type URL or String. If it is a String, then a File(sourceImage) will be opened.<br>
     * If biCubicInterpolation is false nearest interpolation will be used.
     *
     * @param sourceImage
     * @param width
     * @param height
     * @return
     */
    public static RenderedImage convertImageToRenderedImage(Object sourceImage, int width, int height, boolean biCubicInterpolation) {
        try {
            // read
            PlanarImage image = null;
            if (sourceImage instanceof URL) {
                image = JAI.create("url", sourceImage);
            } else {
                image = loadFromFile((String) sourceImage);
            }


            // v2
            /*
            ImageInputStream imageStream = null;
			if (sourceImage instanceof URL) {
				imageStream = new MemoryCacheImageInputStream(((URL) sourceImage).openStream());
			} else {
				imageStream = ImageIO.createImageInputStream(new File((String)sourceImage));
			}
			
			ImageReader reader = null;
			try {
				reader = ImageIO.getImageReaders(imageStream).next();
			} catch (NoSuchElementException ex) {
				return null;
			}
	 		ImageReadParam param = reader.getDefaultReadParam();
			reader.setInput(imageStream);
	 		int sw = 1024; if (width>0) sw = width;
	 		int sh = 768; if (height>0) sh = height;
	 		//int subSW = reader.getWidth(0) / sw;
	 		//int subSH = reader.getHeight(0) / sh;
	 		int subSW = 1;
	 		int subSH = 1;
	 		//param.setSourceRegion(new Rectangle(0,0,sw*subSW,sh*subSH));
	 		//param.setSourceSubsampling(subSW, subSH, 0, 0);
	 		RenderedImage image = reader.read(0,param);
	 		reader.dispose();
	 		imageStream.close();
	 		*/

            // v1
        /*
              File file = new File(sourceImage);
			  if (!file.exists()) {
				  //logger.error("sourceImage does not exist: "+sourceImage);
				  System.out.println("sourceImage does not exist: "+sourceImage);
				  return null;
			  }
		      SeekableStream seekableStream = new FileSeekableStream(file);   
		      ImageDecoder decoder = null;
		      if (isTiffFile(sourceImage))
		      {
		        decoder = ImageCodec.createImageDecoder("tiff", seekableStream, null);
		      } else  // assumes it's a jpg
		      {
		    	decoder = ImageCodec.createImageDecoder("jpeg",seekableStream, null);
		      }
		      ImageDecodeParam param = decoder.getParam();
		      
		      RenderedImage image = decoder.decodeAsRenderedImage();
		  */

            // scale
            if (width > 0 || height > 0) {
                float xScale = (float) width / image.getWidth();
                float yScale = xScale;
                int interpolType = Interpolation.INTERP_NEAREST;
                if (biCubicInterpolation) interpolType = Interpolation.INTERP_BICUBIC;
                if (height > 0) yScale = (float) height / image.getHeight();
                RenderedOp renderedOp = ScaleDescriptor.create(image, new Float(xScale), new Float(yScale),
                        new Float(0.0f), new Float(0.0f), Interpolation.getInstance(interpolType), null);
                image = renderedOp.getRendering();
            }

            // 16bit to 8bit per pixel
            int numComponents = image.getColorModel().getNumComponents();
            int bitsPerPixel = image.getColorModel().getPixelSize();
            boolean is16bit = (bitsPerPixel / numComponents) == 16;
            boolean isGrey = numComponents == 1; // else 3 components is assumed
            if (is16bit) {
                ParameterBlock pbRescale = new ParameterBlock();
                if (isGrey) {
                    pbRescale.add(divide_grey);
                    pbRescale.add(subtract_grey);
                } else {
                    pbRescale.add(divide_rgb);
                    pbRescale.add(subtract_rgb);
                }
                pbRescale.addSource(image);
                image = JAI.create("rescale", pbRescale, null);
                ParameterBlock pbConvert = new ParameterBlock();
                pbConvert.addSource(image);
                pbConvert.add(DataBuffer.TYPE_BYTE);
                image = JAI.create("format", pbConvert);
            } // now it's 8bit per pixel


            // ColorModel and ColorSpace -> target: sRGB or grey, 8bit per pixel
            // ensure sRGB (source was type_rgb) or grey (source was grey)
            ColorModel colorModel = rgbColorModel;
            if (isGrey) colorModel = greyColorModel;
              /*  // rendering hints can be used as further parameter of JAI.create, but unclear what exactly it does.
              ImageLayout layout = new ImageLayout();
         	  layout.setColorModel(colorModel);
        	  RenderingHints rh = new RenderingHints(JAI.KEY_IMAGE_LAYOUT, layout);
        	  */

            try {
                ParameterBlock pb = new ParameterBlock();
                pb.addSource(image).add(colorModel);
                RenderedOp dst = JAI.create("ColorConvert", pb);
                image = dst.getRendering();
            } catch (IllegalArgumentException ex) {
                System.out.println("Warning: Cannot convert color model. Original color model: " + image.getColorModel());
            }

        	  /*
        	  ColorConvertOp colorConvertOp = new ColorConvertOp(null);
         	 BufferedImage bi = RenderedOp.wrapRenderedImage(image).getAsBufferedImage());
        	  System.out.println("dest colormodel: "+ rgbColorModel.toString());
        	  System.out.println("dest colorspace: "+ rgbColorModel.getColorSpace().getName(0));
		     BufferedImage bi2 = colorConvertOp.createCompatibleDestImage(bi, rgbColorModel);
        	  image = colorConvertOp.filter(bi, bi2);
        	  */

            return image;
        } catch (Exception e) {
            //logger.error("error: ",e);
            e.printStackTrace();
            return null;
        }
    }


    public static BufferedImage getScaledImage(RenderedImage image, float scale) {

        RenderedOp renderedOp = ScaleDescriptor.create(image, scale, scale,
                new Float(0.0f), new Float(0.0f), Interpolation.getInstance(Interpolation.INTERP_NEAREST), null);
        return renderedOp.getRendering().getAsBufferedImage();

		/*
		ParameterBlock pb = new ParameterBlock();
		pb.addSource(image); // The source image
		pb.add((double)scale); // The xScale
		pb.add((double)scale); // The yScale
		pb.add(0.0); // The x translation
		pb.add(0.0); // The y translation
 
		RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_RENDERING,
			    RenderingHints.VALUE_RENDER_QUALITY);
		RenderedOp resizedImage = JAI.create("SubsampleAverage", pb, qualityHints);
		return resizedImage.getAsBufferedImage();
		*/
    }

    /**
     * Scales an image. If either width or height < 0 then the size will be computed with respect to the ratio of the original image.<br/>
     * If both width and height < 0 then the original width and height will be used.
     *
     * @param image
     * @param width
     * @param height
     * @return
     */
    public static BufferedImage getScaledImage(BufferedImage image, int width, int height) {
        Map<RenderingHints.Key, Object> map = new HashMap<RenderingHints.Key, Object>();
        map.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        map.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        map.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int sizeX = width;
        int sizeY = height;
        if (sizeY < 0 && sizeX >= 0) {
            double ratio = image.getWidth() / (double) image.getHeight();
            sizeY = (int) ((((double) sizeX / image.getWidth()) * image.getWidth()) / ratio);
        } else if (sizeX < 0 && sizeY >= 0) {
            double ratio = image.getHeight() / (double) image.getWidth();
            sizeX = (int) ((((double) sizeY / image.getHeight()) * image.getHeight()) / ratio);
        } // else sizeX and sizeY is equal to the original size
        if (sizeX <= 0) sizeX = 1;
        if (sizeY <= 0) sizeY = 1;
        BufferedImage bi = new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bi.createGraphics();
        g2d.setRenderingHints(map);
        //g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, renderingHintInterpolation);
        g2d.drawImage(image, 0, 0, sizeX, sizeY, null);
        return bi;
    }

    public static PlanarImage blurImage(BufferedImage image) {
        Map<RenderingHints.Key, Object> map = new HashMap<RenderingHints.Key, Object>();
        map.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        map.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        map.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        RenderingHints hints = new RenderingHints(map);


        final float ninth = 1.0f / 9.0f;
        final float[] blurKernel = {
                ninth, ninth, ninth,
                ninth, ninth, ninth,
                ninth, ninth, ninth
        };

        KernelJAI kernel = new KernelJAI(3, 3,
                blurKernel);
        return JAI.create("convolve", image, kernel, hints);
    }

    /**
     * Tries to get an embedded thumbnail of the image.<br>
     * If not available and imagesize<5000 it build a downscaled image.<br>
     * Else it creatse an empty black image of the specified size.
     *
     * @param displayImage
     * @param sourceImage
     * @param sizeX
     * @param sizeY
     * @param imageType
     * @param useFullSizeForEmbedded
     * @param imageNum
     * @return
     */
    public static BufferedImage getDownsampledImage(PlanarImage displayImage, Object sourceImage, int sizeX, int sizeY, int imageType, boolean useFullSizeForEmbedded, int imageNum) {
        BufferedImage image = new BufferedImage(sizeX, sizeY, imageType);
        if (displayImage != null) {
            BufferedImage thn = getEmbeddedThumbnail(sourceImage, imageNum);
            if (thn != null) {
                if (useFullSizeForEmbedded) {
                    sizeX = thn.getWidth();
                    sizeY = thn.getHeight();
                    image = new BufferedImage(sizeX, sizeY, imageType);
                }
                image.getGraphics().drawImage(thn, 0, 0, sizeX, sizeY, null);
                return image;
            }
            if ((thn == null) && (displayImage != null) && (displayImage.getWidth() < 5000) && (displayImage.getHeight() < 5000)) {
                image.getGraphics().drawImage(displayImage.getAsBufferedImage(), 0, 0, sizeX, sizeY, null);
                return image;
            }


        }

        image.getGraphics().setColor(Color.black);
        image.getGraphics().fillRect(0, 0, sizeX, sizeY);
        return image;
    }


    public static BufferedImage getDownsampledImage(Object sourceImage, int sizeX, int sizeY, int imageNum, boolean returnBlackBoxIfNotPossible) {
        BufferedImage image = null;
        BufferedImage thn = getEmbeddedThumbnail(sourceImage, imageNum);
        if (thn != null) {
            if (sizeY == -1) {
                double ratio = thn.getWidth() / (double) thn.getHeight();
                sizeY = (int) ((((double) sizeX / thn.getWidth()) * thn.getWidth()) / ratio);
            }
            image = new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_INT_RGB);
            image.getGraphics().drawImage(thn, 0, 0, sizeX, sizeY, null);
            return image;
        }


        // no thumbnail, so try to load the image
        PlanarImage displayImage = null;
        if (sourceImage instanceof URL) {
            displayImage = JAI.create("url", sourceImage);
        } else {
            displayImage = loadFromFile((String) sourceImage);
        }

        if ((sizeY == -1) && (displayImage != null)) {
            double ratio = displayImage.getWidth() / (double) displayImage.getHeight();
            sizeY = (int) ((((double) sizeX / displayImage.getWidth()) * displayImage.getWidth()) / ratio);
        }

        if ((thn == null) && (displayImage != null) && (displayImage.getWidth() < 5000) && (displayImage.getHeight() < 5000)) {
            image = new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_INT_RGB);
            image.getGraphics().drawImage(displayImage.getAsBufferedImage(), 0, 0, sizeX, sizeY, null);
            displayImage.dispose();
            displayImage = null;
            return image;
        }


        // try to load a sidecar _thumb or -thumb image
        if (new File((String) sourceImage).exists()) // only if source is an existing file (and not URL)
        {
            for (String thumbStr : RawUtilsCommon.STR_THUMBS) {
                String fn = (String) sourceImage;
                String ending = RawUtilsCommon.getExtension(fn, false);
                if (ending == null || ending.length() < 1) continue;
                fn = fn.substring(0, fn.length() - ending.length() - 1);
                for (String thnEnding : new String[]{ending, "jpg"})  // maybe its not the original ending, but a jpg
                {
                    String thumbFn = fn + thumbStr + "." + thnEnding;
                    if (new File(thumbFn).exists()) {
                        logger.debug("reading sidecar thumbnail: " + thumbFn);
                        PlanarImage scThn = loadFromFile(thumbFn);
                        if (scThn != null && scThn.getWidth() < 5000 && scThn.getHeight() < 5000) {
                            image = new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_INT_RGB);
                            image.getGraphics().drawImage(scThn.getAsBufferedImage(), 0, 0, sizeX, sizeY, null);
                            return image;
                        }
                    }
                }
            }
        }

        if (returnBlackBoxIfNotPossible) {
            if (sizeY == -1) sizeY = (int) (sizeX * 0.75d);
            image = new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_INT_RGB);
            image.getGraphics().setColor(Color.black);
            image.getGraphics().fillRect(0, 0, sizeX, sizeY);
            return image;
        }
        return null;
    }


    private static BufferedImage getEmbeddedThumbnail(Object sourceImage, int imageNum) {
        if (sourceImage == null) return null;
        BufferedImage thumbnail = null;
        ImageInputStream imageStream = null;
        ImageReader reader = null;
        try {
            if (sourceImage instanceof URL) {
                imageStream = new MemoryCacheImageInputStream(((URL) sourceImage).openStream());
            } else if (sourceImage instanceof String) {
                imageStream = ImageIO.createImageInputStream(new File((String) sourceImage));
            }
            if (imageStream == null) return null;

            try {
                reader = ImageIO.getImageReaders(imageStream).next();
            } catch (NoSuchElementException ex) {
                logger.trace("no such element");
                return null;
            }
            ImageReadParam readParam = reader.getDefaultReadParam();
            reader.setInput(imageStream);

            // Read thumbnail and IFD if present.
            //IIOMetadata thumbnailIFD = null;
            if (reader.getNumImages(true) > 1) {
                // for (int i=0; i<reader.getNumImages(true); i++) {
                // 	System.out.println("Image #"+i+" dimensions: "+reader.getWidth(i)+"/"+reader.getHeight(i));
                // }
                if (((long) reader.getWidth(imageNum) * reader.getHeight(imageNum)) < 3000 * 3000L)
                    thumbnail = reader.read(imageNum, readParam);
                //   thumbnailIFD = tiffReader.getImageMetadata(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (imageStream != null) imageStream.close();
                if (reader != null) reader.dispose();
            } catch (Exception e) {
            }
        }
        return thumbnail;
    }


    public static RenderedImage getEmbeddedThumbnailRendered(Object sourceImage, int imageNum) {
        if (sourceImage == null) return null;
        RenderedImage thumbnail = null;
        try {
            ImageInputStream imageStream = null;
            if (sourceImage instanceof URL) {
                imageStream = new MemoryCacheImageInputStream(((URL) sourceImage).openStream());
            } else {
                imageStream = ImageIO.createImageInputStream(new File((String) sourceImage));
            }
            ImageReader reader = ImageIO.getImageReaders(imageStream).next();
            ImageReadParam readParam = reader.getDefaultReadParam();
            reader.setInput(imageStream);

            // Read thumbnail and IFD if present.
            //IIOMetadata thumbnailIFD = null;
            if (reader.getNumImages(true) > 1) {
                //  for (int i=0; i<reader.getNumImages(true); i++) {
                //  	System.out.println("Image #"+i+" dimensions: "+reader.getWidth(i)+"/"+reader.getHeight(i));
                // }
                thumbnail = reader.readAsRenderedImage(imageNum, readParam);
                //   thumbnailIFD = tiffReader.getImageMetadata(1);
            }
            imageStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return thumbnail;
    }


    /**
     * scales an image with scaleFactor and returns it as a renderedOp.<br>
     * The format is always a jpeg compressed (quality 0.85) tif in sRGB colorSpace or GreyScale, 8 bit per sample.<br>
     * The new width of the scaled image is returned.
     *
     * @param fileName
     * @param scaleFactor
     * @param convertBPP
     * @param convertColorModel
     * @return the new width
     */
    public static RenderedOp convertScale(String fileName, float scaleFactor, boolean convertBPP, boolean convertColorModel) {
        // TODO: better quality -> renderinghints
        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        PlanarImage image = loadFromFile(fileName);
        RenderedOp formattedImage = null;
        // 16bit to 8bit per pixel
        int numComponents = image.getColorModel().getNumComponents();
        int bitsPerPixel = image.getColorModel().getPixelSize();
        boolean is16bit = (bitsPerPixel / numComponents) == 16;
        boolean isGrey = numComponents == 1; // else 3 components is assumed
        if (is16bit) {
            ParameterBlock pbRescale = new ParameterBlock();
            if (isGrey) {
                pbRescale.add(divide_grey);
                pbRescale.add(subtract_grey);
            } else {
                pbRescale.add(divide_rgb);
                pbRescale.add(subtract_rgb);
            }
            pbRescale.addSource(image);
            image = JAI.create("rescale", pbRescale, renderingHints);
            ParameterBlock pbConvert = new ParameterBlock();
            pbConvert.addSource(image);
            pbConvert.add(DataBuffer.TYPE_BYTE);
            formattedImage = JAI.create("format", pbConvert);
        } // now it's 8bit per pixel

        Object source = image;
        if (formattedImage != null) source = formattedImage;
        RenderedOp colorConvertImage = null;
        // ColorModel and ColorSpace -> target: sRGB or grey, 8bit per pixel
        // ensure sRGB (source was type_rgb) or grey (source was grey)
        ColorModel colorModel = rgbColorModel;
        if (isGrey) colorModel = greyColorModel;
        try {
            ParameterBlock pb = new ParameterBlock();
            pb.addSource(source).add(colorModel);
            colorConvertImage = JAI.create("ColorConvert", pb);
        } catch (IllegalArgumentException ex) {
            colorConvertImage = null;
            System.out.println("Warning: Cannot convert color model. Original color model: " + image.getColorModel());
        }

        if (colorConvertImage != null) source = colorConvertImage;

        ParameterBlock pb = new ParameterBlock();
        pb.addSource(source);
        pb.add(scaleFactor); // scale factor is ~ 0.3
        pb.add(scaleFactor); // ~0.3
        pb.add(0.0F); // The x translation
        pb.add(0.0F); // The y translation
        //pb.add(new InterpolationNearest());
        pb.add(new InterpolationBicubic(8)); // another attempt
        //pb.add(new InterpolationBilinear(5)); // another attempt
        RenderedOp scaled = JAI.create("scale", pb);
        image = null;
        return scaled;
    }


    /**
     * scales an image with scaleFactor and saves the new image to oldname.num.tif.<br>
     * The format is always a jpeg compressed (quality 0.85) tif in sRGB colorSpace or GreyScale, 8 bit per sample.<br>
     * The new width of the scaled image is returned.
     *
     * @param fileName
     * @param num
     * @param scaleFactor
     * @param convertBPP
     * @param convertColorModel
     * @return the new width
     */
    public static int convertScale(String fileName, int num, float scaleFactor, boolean convertBPP, boolean convertColorModel) {
        // TODO: better quality -> renderinghints
        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        PlanarImage image = loadFromFile(fileName);
        RenderedOp formattedImage = null;
        // 16bit to 8bit per pixel
        int numComponents = image.getColorModel().getNumComponents();
        int bitsPerPixel = image.getColorModel().getPixelSize();
        boolean is16bit = (bitsPerPixel / numComponents) == 16;
        boolean isGrey = numComponents == 1; // else 3 components is assumed
        if (is16bit) {
            ParameterBlock pbRescale = new ParameterBlock();
            if (isGrey) {
                pbRescale.add(divide_grey);
                pbRescale.add(subtract_grey);
            } else {
                pbRescale.add(divide_rgb);
                pbRescale.add(subtract_rgb);
            }
            pbRescale.addSource(image);
            image = JAI.create("rescale", pbRescale, renderingHints);
            ParameterBlock pbConvert = new ParameterBlock();
            pbConvert.addSource(image);
            pbConvert.add(DataBuffer.TYPE_BYTE);
            formattedImage = JAI.create("format", pbConvert);
        } // now it's 8bit per pixel

        Object source = image;
        if (formattedImage != null) source = formattedImage;
        RenderedOp colorConvertImage = null;
        // ColorModel and ColorSpace -> target: sRGB or grey, 8bit per pixel
        // ensure sRGB (source was type_rgb) or grey (source was grey)
        ColorModel colorModel = rgbColorModel;
        if (isGrey) colorModel = greyColorModel;
        try {
            ParameterBlock pb = new ParameterBlock();
            pb.addSource(source).add(colorModel);
            colorConvertImage = JAI.create("ColorConvert", pb);
        } catch (IllegalArgumentException ex) {
            colorConvertImage = null;
            System.out.println("Warning: Cannot convert color model. Original color model: " + image.getColorModel());
        }

        if (colorConvertImage != null) source = colorConvertImage;

        ParameterBlock pb = new ParameterBlock();
        pb.addSource(source);
        pb.add(scaleFactor); // scale factor is ~ 0.3
        pb.add(scaleFactor); // ~0.3
        pb.add(0.0F); // The x translation
        pb.add(0.0F); // The y translation
        //pb.add(new InterpolationNearest());
        pb.add(new InterpolationBicubic(8)); // another attempt
        //pb.add(new InterpolationBilinear(5)); // another attempt
        RenderedOp scaled = JAI.create("scale", pb);


        // save
        //String fn = fileName.substring(0, fileName.length()-4) + "."+num+".tif";
        String fn = fileName.split("\\.")[0] + "." + num + ".tif";
        TIFFEncodeParam param = new TIFFEncodeParam();
        param.setTileSize(OrbitUtils.TILE_SIZE, OrbitUtils.TILE_SIZE);
        param.setWriteTiled(true);
        param.setCompression(TIFFEncodeParam.COMPRESSION_JPEG_TTN2);
        JPEGEncodeParam jpgParam = new JPEGEncodeParam();
        jpgParam.setQuality(0.85f);
        param.setJPEGEncodeParam(jpgParam);
        JAI.create("filestore", scaled, fn, "TIFF", param);
        //System.out.println("finished writing number "+num);
        return scaled.getWidth();
    }


    /**
     * scales an image with scaleFactor and saves the new image to oldname.num.tif.<br>
     * The format is always a jpeg compressed (quality 0.85) tif in sRGB colorSpace or GreyScale, 8 bit per sample.<br>
     * The new width of the scaled image is returned.
     *
     * @param fileName
     * @param num
     * @param scaleFactor
     * @return the new width
     */
    public static int convertScale(String fileName, int num, float scaleFactor) {
        RenderedOp scaled = convertScale(fileName, scaleFactor, true, true);

        // save
        //String fn = fileName.substring(0, fileName.length()-4) + "."+num+".tif";
        String fn = fileName.split("\\.")[0] + "." + num + ".tif";
        TIFFEncodeParam param = new TIFFEncodeParam();
        param.setTileSize(OrbitUtils.TILE_SIZE, OrbitUtils.TILE_SIZE);
        param.setWriteTiled(true);
        param.setCompression(TIFFEncodeParam.COMPRESSION_JPEG_TTN2);
        JPEGEncodeParam jpgParam = new JPEGEncodeParam();
        jpgParam.setQuality(0.85f);
        param.setJPEGEncodeParam(jpgParam);

        JAI.create("filestore", scaled, fn, "TIFF", param);
        return scaled.getWidth();
    }

    /**
     * scales an image with scaleFactor and saves the new image to toFileName.<br>
     * The format is always a jpeg compressed (quality 0.85) tif in sRGB colorSpace or GreyScale, 8 bit per sample.<br>
     * The new width of the scaled image is returned.
     *
     * @param fileName
     * @param scaleFactor
     * @return the new width
     */
    public static int convertScale(String fileName, String toFileName, float scaleFactor) {
        RenderedOp scaled = convertScale(fileName, scaleFactor, true, true);

        // save
        //String fn = fileName.substring(0, fileName.length()-4) + "."+num+".tif";
        TIFFEncodeParam param = new TIFFEncodeParam();
        param.setTileSize(OrbitUtils.TILE_SIZE, OrbitUtils.TILE_SIZE);
        param.setWriteTiled(true);
        param.setCompression(TIFFEncodeParam.COMPRESSION_JPEG_TTN2);
        JPEGEncodeParam jpgParam = new JPEGEncodeParam();
        jpgParam.setQuality(0.85f);
        param.setJPEGEncodeParam(jpgParam);

        JAI.create("filestore", scaled, toFileName, "TIFF", param);
        return scaled.getWidth();
    }


    /**
     * scales an image with scaleFactor and outputs it to the outputStream.<br>
     * The format is always a jpeg compressed (quality 0.85) tif in sRGB colorSpace or GreyScale, 8 bit per sample.<br>
     * The new width of the scaled image is returned.
     *
     * @param fileName
     * @return the new width
     */
    public static int convertScale(String fileName, float scaleFactor, OutputStream outStream) {
        RenderedOp scaled = convertScale(fileName, scaleFactor, true, true);

        // save
        TIFFEncodeParam param = new TIFFEncodeParam();
        param.setTileSize(OrbitUtils.TILE_SIZE, OrbitUtils.TILE_SIZE);
        param.setWriteTiled(true);
        param.setCompression(TIFFEncodeParam.COMPRESSION_JPEG_TTN2);
        JPEGEncodeParam jpgParam = new JPEGEncodeParam();
        jpgParam.setQuality(0.85f);
        param.setJPEGEncodeParam(jpgParam);

        ImageEncoder encoder = ImageCodec.createImageEncoder("TIFF", outStream, param);
        try {
            encoder.encode(scaled);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return scaled.getWidth();
    }


    private static void convertImage(String sourceImage, OutputStream outStream, int width, int height, boolean biCubicInterpolation) {
        try {
            RenderedImage image = convertImageToRenderedImage(sourceImage, width, height, biCubicInterpolation);
            logger.trace("convertImageToRenderedImage done");
            // write
            JPEGEncodeParam encodeParam = new JPEGEncodeParam();
            encodeParam.setQuality(0.85F);
            logger.trace("now building encoder");
            ImageEncoder encoder = ImageCodec.createImageEncoder("JPEG", outStream, encodeParam);
            // ImageEncoder encoder = ImageCodec.createImageEncoder("PNG", outStream, null); // png
            logger.trace("starting encode process");
            logger.trace("image to encode: " + image);
            encoder.encode(image);
            logger.trace("encoding done");

        } catch (IOException e) {
            //logger.error("error: ",e);
            e.printStackTrace();
            outStream = null;
        }
    }


    public static boolean convertImage(String sourceImage, String targetImage, int width, int height, boolean biCubicInterpolation) {
        FileOutputStream outStream;
        try {
            outStream = new FileOutputStream(targetImage);
            convertImage(sourceImage, outStream, width, height, biCubicInterpolation);
        } catch (FileNotFoundException e) {
            //logger.error("error: ",e);
            e.printStackTrace();
            return false;
        }
        return outStream != null;
    }

    public static byte[] convertImage(String sourceImage, int width, int height, boolean biCubicInterpolation) {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        convertImage(sourceImage, outStream, width, height, biCubicInterpolation);
        return outStream.toByteArray();
    }


    public static ImageIcon getImageIcon(URL fileURL, int width, int height) {

        try {
            RenderedImage image = convertImageToRenderedImage(fileURL, width, height, false);
            if (image == null) return null;
            ImageIcon icon = new ImageIcon(RenderedOp.wrapRenderedImage(image).getAsBufferedImage());
            return icon;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static RenderedImage getThumbRenderedImage(URL fileURL, int width, int height) {

        try {
            RenderedImage image = convertImageToRenderedImage(fileURL, width, height, false);
            return image;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    public static ImageIcon getImageIcon(String fileName, int width, int height) {
        File file = new File(fileName);
        if (!file.exists()) {
            //logger.error("Image does not exist: "+fileName);
            System.out.println("Image does not exist: " + fileName);
            return null;
        }

        ImageIcon thumbnail = null;

        String extension = getExtension(file);
        if (extension != null) {
            if (isTiffFile(fileName)) {        // tiff
                try {
                    RenderedImage image = convertImageToRenderedImage(fileName, width, height, false);
                    ImageIcon icon = new ImageIcon(RenderedOp.wrapRenderedImage(image).getAsBufferedImage());
                    return icon;

                } catch (Exception ex) {
                    return null;
                }
            } else {  // jpg or png
                ImageIcon tmpIcon = new ImageIcon(file.getPath());
                if (tmpIcon != null) {
                    if (width > 0 || height > 0) {
                        if (width == 0) width = -1;
                        if (height == 0) height = -1;
                        thumbnail = new ImageIcon(tmpIcon.getImage().
                                getScaledInstance(width, height,
                                        Image.SCALE_DEFAULT));
                    } else {
                        thumbnail = tmpIcon;
                    }
                }
            }
        }

        return thumbnail;
    }

    /**
     * Creates a new bufferedImage as scaled version of the old image. If the new image is smaller it is
     * centered with a white background around.
     *
     * @param image
     * @param width
     * @param height
     * @return
     */
    public static BufferedImage makeScaledImage(BufferedImage image, int width, int height) {
        int w = width;
        int h = height;
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        int iw = w;
        int ih = h;
        if (image.getWidth() > image.getHeight()) {  // adjust height
            ih = (int) (w * ((double) image.getHeight() / image.getWidth()));
        } else {    // adjust icon width
            iw = (int) (h * ((double) image.getWidth() / image.getHeight()));
        }
        int iOffsX = 0;
        int iOffsY = 0;
        if (iw < w) {
            iOffsX = (w - iw) / 2;
        }
        if (ih < h) {
            iOffsY = (h - ih) / 2;
        }
        img.getGraphics().setColor(Color.white);
        img.getGraphics().fillRect(0, 0, w, h);
        img.getGraphics().drawImage(image, iOffsX, iOffsY, iw, ih, null);
        return img;
    }


    public static boolean isTiffFile(File f) {
        if (f == null) return false;
        return isTiffFile(f.getName());
    }

    public static boolean isTiffFile(String filename) {
        String ext = getExtension(filename);
        if (ext != null) {
            return ext.equals("tiff") || ext.equals("tif") || ext.equals("svs");
        }
        return false;
    }

    /**
     * returns the lowercase ending of the filename
     *
     * @return
     */
    public static String getExtension(String filename) {
        String ext = null;
        String s = filename;
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
    }

    /**
     * returns the lowercase ending of the filename
     *
     * @param f
     * @return
     */
    public static String getExtension(File f) {
        return getExtension(f.getName());
    }

    public static int getNumPagesInZVI(String filename) throws IOException, FormatException {

        ImageProcessorReader r = new ImageProcessorReader(
                new ChannelSeparator(new ZeissZVIReader())); // LociPrefs.makeImageReader()
        r.setId(filename);
        int num = r.getImageCount();
        //int width = r.getSizeX();
        //int height = r.getSizeY();
        // howto color conversion: http://trac.openmicroscopy.org.uk/ome/browser/bioformats.git/components/loci-plugins/utils/Read_Image.java
        r.close();
        return num;
    }

    public static int getNumPagesInLIF(String filename) throws IOException, FormatException {

        ImageProcessorReader r = new ImageProcessorReader(
                new ChannelSeparator(new LIFReader()));
        r.setId(filename);
        int num = r.getImageCount();
        r.close();
        return num;
    }

    public static PlanarImage getZVIPage(String filename, int num) throws IOException, FormatException {
        ImageProcessorReader r = new ImageProcessorReader(
                new ChannelSeparator(new ZeissZVIReader())); // LociPrefs.makeImageReader()
        r.setId(filename);
        ImageProcessor ip = r.openProcessors(num)[0]; // (page)[0]
        return PlanarImage.wrapRenderedImage(ip.getBufferedImage());
    }

    public static PlanarImage getLIFPage(String filename, int num) throws IOException, FormatException {
        ImageProcessorReader r = new ImageProcessorReader(
                new ChannelSeparator(new LIFReader()));
        r.setId(filename);
        ImageProcessor ip = r.openProcessors(num)[0]; // (page)[0]
        return PlanarImage.wrapRenderedImage(ip.getBufferedImage());
    }

    public static String generatePseudoMultiPageFileName(String filename, int num) {
        String ending = filename.substring(filename.length() - 4, filename.length()); // should be .zvi or .lif
        String fnPage = filename.substring(0, filename.length() - 4) + "#" + num + "#" + ending;
        logger.trace("pseude multi-page filename: " + fnPage);
        return fnPage;
    }

    /**
     * Reads images from local filesystem. Uses JAI except ZVI/LIF format which is read by LOCI.
     * If an image contains several frames (e.g. ZVI/LIF images) the frame can be specified with imagename#framenum#.ending, e.g. example#1#.zvi.
     *
     * @param filename
     * @return
     * @throws OrbitImageServletException
     */
    public static PlanarImage loadFromFile(String filename) throws IllegalArgumentException {
        PlanarImage img = null;
        if (RawUtilsCommon.isZVIFile(filename) || RawUtilsCommon.isLIFFile(filename)) {
            logger.debug("file is zvi/lif file");
            String fn = filename;
            int pageNum = 0;
            if (fn.contains("#")) {
                String[] split = fn.split("#");
                if (split != null && split.length == 3) {
                    fn = split[0] + split[2];
                    pageNum = Integer.parseInt(split[1]);
                }
            }
            try {
                if (RawUtilsCommon.isZVIFile(filename))
                    img = TiffConverter.getZVIPage(fn, pageNum);
                else if (RawUtilsCommon.isLIFFile(filename))
                    img = TiffConverter.getLIFPage(fn, pageNum);
            } catch (Exception ex) {
                throw new IllegalArgumentException("error reading ZVI/LIF file " + fn + ": " + ex.getMessage());
            }

        } else if (RawUtilsCommon.isImageFile(filename) && !(filename.toLowerCase().endsWith("bmp") || filename.toLowerCase().endsWith("dcm") || filename.toLowerCase().endsWith("pcx"))) {
            PNGDecodeParam param = null;
            if (filename.toLowerCase().endsWith("png")) {
                param = new PNGDecodeParam();
                param.setSuppressAlpha(true);   // we don't support alpha channels here
            }
            img = JAI.create("fileload", filename, param);
            if (img.getColorModel() instanceof IndexColorModel) {  // convert to rgb image (works only for small images!)
                BufferedImage bi = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
                bi.getGraphics().drawImage(img.getAsBufferedImage(), 0, 0, null);
                img = PlanarImage.wrapRenderedImage(bi);
            }
            img.getNumBands();
        } else {
            // Try to load via imagej. But currently not supported because file dialog / dragHandler only supports files with type RawUtils.isImageFle().
            // Still used for bmp files.
            Opener opener = new Opener();
            ImagePlus imp = opener.openImage(filename);
            img = PlanarImage.wrapRenderedImage(imp.getProcessor().getBufferedImage());
            // ImagePlus[] imps = BF.openImagePlus(filename);
            BufferedImage bi = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
            bi.getGraphics().drawImage(img.getAsBufferedImage(), 0, 0, null);
            img = PlanarImage.wrapRenderedImage(bi);
        }

        return img;
    }

}

