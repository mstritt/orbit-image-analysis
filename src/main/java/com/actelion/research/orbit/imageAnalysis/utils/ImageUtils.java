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

import com.actelion.research.orbit.beans.RawData;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.beans.RawMeta;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.utils.RawUtilsCommon;
import com.sun.media.imageio.plugins.jpeg2000.J2KImageWriteParam;
import ij.ImagePlus;
import ij.process.ShortProcessor;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


/**
 * Created by wirthma1 on 6/12/2014.
 */
public class ImageUtils {

    public enum PlateScalingMin {min, p01, p05, p1, p5}

    ;

    public enum PlateScalingMax {max, p95, p99, p995, p999}

    ;
    public static PlateScalingMin defaultPlateScalingMin = PlateScalingMin.p05;
    public static PlateScalingMax defaultPlateScalingMax = PlateScalingMax.p99;

    static {
        ImageIO.scanForPlugins();
    }

    /**
     * Converts image file into a BufferedImage
     *
     * @param inputFile
     * @return
     * @throws IOException
     */
    public static BufferedImage convertImageFileToBI(String inputFile) throws IOException {

        BufferedImage bi = null;


        try {
            ImageIO.setUseCache(false);
            bi = ImageIO.read(new File(inputFile));
        } catch (javax.imageio.IIOException e) // in case tiff format is not recognized, try to resolve exception using ImagePlus (ImageJ) methods
        {
            if (inputFile.endsWith(".tif") || inputFile.endsWith(".tiff")) {
                ImagePlus ip = new ImagePlus(inputFile); // :TODO validate if tiff to be read is truly 16 bit :: otherwise there could be a scaling issue occurring afterwards
                bi = ((ShortProcessor) ip.getProcessor().convertToShort(false)).get16BitBufferedImage();
            } else {
                throw e;
            }
        }

        return bi;
    }


    /**
     * Stores BufferedImage as JPEG2000 encoded file.
     *
     * @param bi
     * @param filename
     * @param dEncRate
     * @param lossless
     * @throws IOException
     */
    public static void storeBIAsJP2File(BufferedImage bi, String filename, double dEncRate, boolean lossless) throws IOException {

        if (hasJPEG2000FileTag(filename)) {

            IIOImage iioImage = new IIOImage(bi, null, null);

            ImageWriter jp2iw = ImageIO.getImageWritersBySuffix("jp2").next();
            J2KImageWriteParam writeParam = (J2KImageWriteParam) jp2iw.getDefaultWriteParam();

            // Indicates using the lossless scheme or not. It is equivalent to use reversible quantization and 5x3 integer wavelet filters. The default is true.
            writeParam.setLossless(lossless);

            if (lossless)
                writeParam.setFilter(J2KImageWriteParam.FILTER_53); // Specifies which wavelet filters to use for the specified tile-components. JPEG 2000 part I only supports w5x3 and w9x7 filters.
            else
                writeParam.setFilter(J2KImageWriteParam.FILTER_97);

            if (!lossless) {
                // The bitrate in bits-per-pixel for encoding. Should be set when lossy compression scheme is used. With the default value Double.MAX_VALUE, a lossless compression will be done.
                writeParam.setEncodingRate(dEncRate);

                // changes in compression rate are done in the following way
                // however JPEG2000 implementation seems not to support this <-- no differences visible
                //                writeParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                //                writeParam.setCompressionType(writeParam.getCompressionTypes()[0]);
                //                writeParam.setCompressionQuality(1.0f);
            }

            ImageOutputStream ios = null;
            try {
                ios = new FileImageOutputStream(new File(filename));
                jp2iw.setOutput(ios);
                jp2iw.write(null, iioImage, writeParam);
                jp2iw.dispose();
                ios.flush();
            } finally {
                if (ios != null) ios.close();
            }
        } else
            System.err.println("please name your file as valid JPEG2000 file: ends with .jp2");
    }

    /**
     * Verifies JPEG2000 file tag
     *
     * @param filename
     * @return
     */
    private static boolean hasJPEG2000FileTag(String filename) {

        return filename.endsWith(".jp2");
    }


    /**
     * Stores BufferedImage as JPEG2000 encoded bytestream
     *
     * @param bi
     * @return
     * @throws IOException
     */
    public static byte[] encodeBufferedImageAsJP2(BufferedImage bi) throws IOException {

        byte[] byteStream = null;

        ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
        ImageIO.write(bi, "jpeg2000", baos);
        baos.flush();
        byteStream = baos.toByteArray();
        baos.close();

        return byteStream;
    }

    /**
     * Stores BufferedImage as JPEG encoded bytestream
     *
     * @param bi
     * @return
     * @throws IOException
     */
    public static byte[] encodeBufferedImageAsJPEG(BufferedImage bi) throws IOException {

        byte[] byteStream = null;

        ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
        ImageIO.write(bi, "jpeg", baos);
        baos.flush();
        byteStream = baos.toByteArray();
        baos.close();

        return byteStream;
    }

    /**
     * Rescales using min/max intensities and converts to 8bit. Works for gray color images.
     *
     * @param bi16
     * @return
     */
    public static BufferedImage convertTo8bit(BufferedImage bi16, int rdfId) {
        if (rdfId > 0)
            try {
                return convertTo8bit(rdfId, bi16, defaultPlateScalingMin, defaultPlateScalingMax);
            } catch (Exception e) {
                e.printStackTrace();
                return convertTo8bit(bi16, 0d, 100d); // use local percentiles instead
            }
        else return convertTo8bit(bi16, 0d, 100d); // use local percentiles instead
    }


    /**
     * Rescales using arbitrary intensities and converts to 8bit. Works for gray- and rgb color images.
     *
     * @param bi16
     * @return
     */
    public static BufferedImage convertTo8bit(BufferedImage bi16, double intScalingMin, double intScalignMax) {
        // TODO: use min,max from plate meta data, not image specific
        int[][] minMax = ImageUtils.getMinMaxIntensitiesOfBI(bi16);
        BufferedImage bi = null;
        if (bi16.getSampleModel().getNumBands() == 1) {
            bi16 = ImageUtils.scaleIntensities(bi16, getPercentileIntensity(bi16, intScalingMin), getPercentileIntensity(bi16, intScalignMax));
            bi = new BufferedImage(bi16.getWidth(), bi16.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        } else if (bi16.getSampleModel().getNumBands() == 3) {
            bi16 = ImageUtils.scaleIntensities(bi16, getPercentileIntensity(bi16, intScalingMin), getPercentileIntensity(bi16, intScalignMax));
            bi = new BufferedImage(bi16.getWidth(), bi16.getHeight(), BufferedImage.TYPE_INT_RGB);
        } else {
            throw new IllegalArgumentException("Only images with 1 band (gray-color) or 3 bands (rgb) supported. This image has " + bi16.getSampleModel().getNumBands() + " bands.");
        }
        Graphics2D g2d = bi.createGraphics();
        g2d.drawImage(bi16, 0, 0, null);
        g2d.dispose();
        return bi;
    }


    /**
     * Rescales using plate intensities and converts to 8bit. Works for gray- and rgb color images.
     *
     * @param bi16
     * @return
     */
    public static BufferedImage convertTo8bit(int rdfId, BufferedImage bi16, PlateScalingMin plateScalingMin, PlateScalingMax plateScalingMax) throws Exception {
        RawDataFile rdf = DALConfig.getImageProvider().LoadRawDataFile(rdfId);
                /*
                if (plateScalingMin==defaultPlateScalingMin && plateScalingMax==defaultPlateScalingMax) {
                    // /orbitvol1/2014-11/4309324.1002.jpg
                    String url = RawUtils.STR_SERVER+"/rawFile?rawFile="+rdf.getDataPath()+"/"+rdfId+"."+RawUtils.LEVEL_8BITPREVIEW+".jpg";
                    System.out.println("url: " + url);
                    return ImageIO.read(new URL(url));
                }
                */

        RawData rd = DALConfig.getImageProvider().LoadRawData(rdf.getRawDataId());
        List<RawMeta> rmList = DALConfig.getImageProvider().LoadRawMetasByRawDataFile(rdfId);
        List<RawMeta> rmDataList = DALConfig.getImageProvider().LoadRawMetasByRawData(rd.getRawDataId());
        rmList.addAll(rmDataList);
        HashMap<String, RawMeta> rmHash = RawUtilsCommon.getHashFromMetaList(rmList);

        if (!rmHash.containsKey(RawUtilsCommon.STR_META_CHANNEL))
            throw new Exception("Error: Meta data 'Channel' not available for RawDataFile " + rdfId);
        //int channel = Integer.parseInt(rmHash.get(RawUtils.STR_META_CHANNEL).getValue()) - 1;
        int channel = Integer.parseInt(rmHash.get(RawUtilsCommon.STR_META_CHANNEL).getValue());
        String metaKey = "Percentiles_wvlength_" + channel + "_channel_0";
        if (!rmHash.containsKey(metaKey))
            throw new Exception("Error: Meta data '" + metaKey + "' not available for RawDataFile " + rdfId);
        String val = rmHash.get(metaKey).getValue();
        int[] minmax = parseMinMax(val, plateScalingMin, plateScalingMax);

        BufferedImage bi = null;
        if (bi16.getSampleModel().getNumBands() == 1) {
            bi16 = ImageUtils.scaleIntensities(bi16, new int[]{minmax[0]}, new int[]{minmax[1]});
            bi = new BufferedImage(bi16.getWidth(), bi16.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        } else {
            throw new IllegalArgumentException("Only images with 1 band (gray-color) supported. This image has " + bi16.getSampleModel().getNumBands() + " bands.");
        }
        Graphics2D g2d = bi.createGraphics();
        g2d.drawImage(bi16, 0, 0, null);
        g2d.dispose();
        return bi;
    }

    /**
     * input format is e.g. "MIN=82;0.1%=176;0.5%=186;1%=191;5%=204;95%=1726;99%=4239;99.5%=4832;99.9%=6079;MAX=65535";
     * returns int[2] with int[0]=minValue and int[1]=maxValue
     *
     * @param percentiles
     * @return
     */
    public static int[] parseMinMax(String percentiles, PlateScalingMin min, PlateScalingMax max) {
        //String percentiles = "MIN=82;0.1%=176;0.5%=186;1%=191;5%=204;95%=1726;99%=4239;99.5%=4832;99.9%=6079;MAX=65535";
        int[] minmax = new int[2];
        String[] split = percentiles.split(";", -1);
        for (String s : split) {
            String[] keyval = s.split("=", -1);
            //System.out.println("test: "+keyval[0]+" min: "+min.toString()+" max: "+max.toString());
            if (keyval[0].equalsIgnoreCase(getMinIntensityName(min))) minmax[0] = Integer.parseInt(keyval[1]);
            if (keyval[0].equalsIgnoreCase(getMaxIntensityName(max))) minmax[1] = Integer.parseInt(keyval[1]);
        }
        return minmax;
    }


    /**
     * Rescales using predefined min,max intensities and converts to 8bit. Works for gray- and rgb color images.
     *
     * @param bi16
     * @return
     */
    public static BufferedImage convertTo8bit(BufferedImage bi16, int min, int max) {
        BufferedImage bi = null;
        if (bi16.getSampleModel().getNumBands() == 1) {
            bi16 = ImageUtils.scaleIntensities(bi16, new int[]{min}, new int[]{max});
            bi = new BufferedImage(bi16.getWidth(), bi16.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        } else if (bi16.getSampleModel().getNumBands() == 3) {
            throw new IllegalArgumentException("only grayscale images supported");
        } else {
            throw new IllegalArgumentException("Only images with 1 band (gray-color) or 3 bands (rgb) supported. This image has " + bi16.getSampleModel().getNumBands() + " bands.");
        }
        Graphics2D g2d = bi.createGraphics();
        g2d.drawImage(bi16, 0, 0, null);
        g2d.dispose();
        return bi;
    }


    private static String getMinIntensityName(PlateScalingMin plateScalingMin) {
        switch (plateScalingMin) {
            case min:
                return "MIN";
            case p01:
                return "0.1%";
            case p05:
                return "0.5%";
            case p1:
                return "1%";
            case p5:
                return "5%";
            default:
                return "MIN";
        }
    }

    private static String getMaxIntensityName(PlateScalingMax plateScalingMax) {
        switch (plateScalingMax) {
            case max:
                return "MAX";
            case p95:
                return "95%";
            case p99:
                return "99%";
            case p995:
                return "99.5%";
            case p999:
                return "99.9%";
            default:
                return "MAX";
        }
    }

    /**
     * scales bands to min = 0 & max = 2^8 or 2^16
     *
     * @param image
     * @param min   int[] containing minima per band
     * @param max
     * @return
     */
    public static BufferedImage scaleIntensities(BufferedImage image, int[] min, int[] max) throws IllegalArgumentException {
        WritableRaster raster = image.getRaster();

        if ((min.length != max.length) || min.length != raster.getNumBands())
            throw new IllegalArgumentException("Please ensure consistency of min and max arrays and number of bands in image");

        int width = image.getWidth();
        int height = image.getHeight();

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                for (int band = 0; band < raster.getNumBands(); band++) {
                    int pixel = raster.getSample(col, row, band);
                    if (pixel < min[band]) pixel = min[band];
                    if (pixel > max[band]) pixel = max[band];
                    pixel = ((int) (((((double) pixel - min[band]) / (max[band] - min[band])) * ((int) Math.pow(2, image.getColorModel().getPixelSize()) - 1)) + 0.5));
                    raster.setSample(col, row, band, pixel);
                }
            }
        }

        return image;
    }

    /**
     * Can be used to verify impact of different encoding algorithms. Compares two BufferedImages and outputs differences between those.
     *
     * @param image
     * @param image2
     * @return
     */
    public static int[] calculateBufferedImageDifferencesPxByPx(BufferedImage image, BufferedImage image2) {
        int width = image.getWidth();
        int height = image.getHeight();

        int width2 = image2.getWidth();
        int height2 = image2.getHeight();

        WritableRaster raster1 = image.getRaster();
        WritableRaster raster2 = image2.getRaster();

        if (width != width2 || height != height2)
            throw new IllegalArgumentException("Please insert two identical images that were treated with different image algorithms");

        int[] diff = new int[width * height];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                for (int band = 0; band < raster1.getNumBands(); band++) {
                    int p1 = raster1.getSample(col, row, band);
                    int p2 = raster2.getSample(col, row, band);

                    diff[((row * width) + col)] = p2 - p1;
                }
            }
        }

        return diff;
    }


    /**
     * Returns min and max intensities and percentiles 0.01, 0.05, 0.1, 0.9, 0.95, 0.99 of a BufferedImage.
     *
     * @param image
     * @return
     */
    public static int[][] getMinMaxIntensitiesOfBI(BufferedImage image) {
        WritableRaster raster = image.getRaster();
        // per band: { min, 1%, 5%, 10%, 90%, 95%, 99%, max }
        int[][] intensities = new int[raster.getNumBands()][8];

        DescriptiveStatistics[] ds = new DescriptiveStatistics[raster.getNumBands()];
        for (int i = 0; i < raster.getNumBands(); i++)
            ds[i] = new DescriptiveStatistics();

        int width = image.getWidth();
        int height = image.getHeight();

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                for (int band = 0; band < raster.getNumBands(); band++) {
                    ds[band].addValue(raster.getSample(col, row, band));
                }
            }
        }

        for (int i = 0; i < ds.length; i++) {
            intensities[i][0] = (int) ds[i].getMin();
            intensities[i][1] = (int) ds[i].getPercentile(1);
            intensities[i][2] = (int) ds[i].getPercentile(5);
            intensities[i][3] = (int) ds[i].getPercentile(10);
            intensities[i][4] = (int) ds[i].getPercentile(90);
            intensities[i][5] = (int) ds[i].getPercentile(95);
            intensities[i][6] = (int) ds[i].getPercentile(99);
            intensities[i][7] = (int) ds[i].getMax();
        }
        return intensities;
    }

    public static int[] getPercentileIntensity(BufferedImage image, double percentile) {
        WritableRaster raster = image.getRaster();
        int[] intensities = new int[raster.getNumBands()];

        DescriptiveStatistics[] ds = new DescriptiveStatistics[raster.getNumBands()];
        for (int i = 0; i < raster.getNumBands(); i++)
            ds[i] = new DescriptiveStatistics();

        int width = image.getWidth();
        int height = image.getHeight();

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                for (int band = 0; band < raster.getNumBands(); band++) {
                    ds[band].addValue(raster.getSample(col, row, band));
                }
            }
        }

        for (int i = 0; i < ds.length; i++) {
            if (percentile == 0d) intensities[i] = (int) ds[i].getMin();
            else if (percentile == 100d) intensities[i] = (int) ds[i].getMax();
            else
                intensities[i] = (int) ds[i].getPercentile(percentile);
        }
        return intensities;
    }

    /**
     * Calculates and returns band histograms of a BufferedImage
     *
     * @param image
     * @return
     */
    public static int[][] getChannelHistograms(BufferedImage image) {
        WritableRaster raster = image.getRaster();
        int[][] histograms = new int[raster.getNumBands()][(int) (Math.pow(2, image.getColorModel().getPixelSize()) - 1)];

        int width = image.getWidth();
        int height = image.getHeight();

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                for (int band = 0; band < raster.getNumBands(); band++) {
                    histograms[band][raster.getSample(col, row, band)]++;
                }
            }
        }

        return histograms;
    }

    /**
     * Calculates and returns band histograms of a BufferedImage w/o a need to extract the raster
     *
     * @param raster
     * @param width
     * @param height
     * @param iNumBins
     * @return
     */
    public static int[][] getChannelHistograms(WritableRaster raster, int width, int height, int iNumBins) {

        int[][] histograms = new int[raster.getNumBands()][iNumBins];


        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                for (int band = 0; band < raster.getNumBands(); band++) {
                    histograms[band][raster.getSample(col, row, band)]++;
                }
            }
        }

        return histograms;
    }


}
