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

import com.actelion.research.orbit.imageAnalysis.dal.localImage.ndpi.NDPReadWrapper.NDPRException;
import com.actelion.research.orbit.imageAnalysis.dal.localImage.ndpi.NDPReadWrapper.RequestType;
import com.sun.jna.Pointer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Read NDPI images using proprietary C++ library via JNA.
 * 
 * @see NDPReadJNA
 * @see NDPReadWrapper
 *
 * @author patrick.rammelt@idorsia.com
 */
public class NDPITiledReader
{
    // INNER CLASSES / INTERFACES / ENUMS =====================================

    /** @see  com.actelion.research.orbit.imageAnalysis.dal.localImage.ndpi.NDPITiledReader#getImageInfo(int) */
    public static final class NDPRImageInfo
    {
        public final int imageWidth;
        public final int imageHeight;
        public final int physicalX;
        public final int physicalY;
        public final int physicalWidth;
        public final int physicalHeight;
        public final int channels;
        public final int bitsPerChannel;
        public final int zLayers;
        public final String zLayerPositions; // comma separated
        public final float lens;
        public final double resolutionMuMperPixel;

        public NDPRImageInfo (final int imageWidth,
                              final int imageHeight,
                              final int physicalX,
                              final int physicalY,
                              final int physicalWidth,
                              final int physicalHeight,
                              final int channels,
                              final int bitsPerChannel,
                              final int zLayers,
                              final String zLayerPositions,
                              final float lens,
                              final double resolutionMuMperPixel)
        {
            this.imageWidth = imageWidth;
            this.imageHeight = imageHeight;
            this.physicalX = physicalX;
            this.physicalY = physicalY;
            this.physicalWidth = physicalWidth;
            this.physicalHeight = physicalHeight;
            this.channels = channels;
            this.bitsPerChannel = bitsPerChannel;
            this.zLayers = zLayers;
            this.zLayerPositions = zLayerPositions;
            this.lens = lens;
            this.resolutionMuMperPixel = resolutionMuMperPixel;
        }
    }

    /** @see  com.actelion.research.orbit.imageAnalysis.dal.localImage.ndpi.NDPITiledReader#getImageMetadata(int) */
    public static final class NDPRImageMetadata
    {
        public final float lens;
        public final long bgColor;
        public final String barcode;
        public final String creator;
        public final String manufacturer;
        public final String scannerModel;
        public final String serialNumber;
        public final String creationTime;
        public final String calibrationInfo;
        public final float defaultViewAngle;
        public final List<String> channelNames;
        public final int exposureRatio;
        public final int exposureTime;
        public final int gainRed;
        public final int gainGreen;
        public final int gainBlue;
        public final int wavelength;
        public final int lampAge;
        public final int illuminationMode;
        public final int jpegQuality;
        public final boolean labelObscured;
        public final int focusTime;
        public final int scanTime;
        public final int writeTime;
        public final String imageName;
        public final String compressionType;
        public final String imageTitle;
        public final int subImages;
        public final float defaultGamma;
        public final String format;
        public final long imageSize;
        public final int bitsPerChannel;
        public final int channels;
        public final float pyramidRatio;
        public final boolean fullyAutomatic;

        public NDPRImageMetadata (final float lens,
                                  final long bgColor,
                                  final String barcode,
                                  final String creator,
                                  final String manufacturer,
                                  final String scannerModel,
                                  final String serialNumber,
                                  final String creationTime,
                                  final String calibrationInfo,
                                  final float defaultViewAngle,
                                  final List<String> channelNames,
                                  final int exposureRatio,
                                  final int exposureTime,
                                  final int gainRed,
                                  final int gainGreen,
                                  final int gainBlue,
                                  final int wavelength,
                                  final int lampAge,
                                  final int illuminationMode,
                                  final int jpegQuality,
                                  final boolean labelObscured,
                                  final int focusTime,
                                  final int scanTime,
                                  final int writeTime,
                                  final String imageName,
                                  final String compressionType,
                                  final String imageTitle,
                                  final int subImages,
                                  final float defaultGamma,
                                  final String format,
                                  final long imageSize,
                                  final int bitsPerChannel,
                                  final int channels,
                                  final float pyramidRatio,
                                  final boolean fullyAutomatic)
        {
            this.lens = lens;
            this.bgColor = bgColor;
            this.barcode = barcode;
            this.creator = creator;
            this.manufacturer = manufacturer;
            this.scannerModel = scannerModel;
            this.serialNumber = serialNumber;
            this.creationTime = creationTime;
            this.calibrationInfo = calibrationInfo;
            this.defaultViewAngle = defaultViewAngle;
            this.channelNames = channelNames;
            this.exposureRatio = exposureRatio;
            this.exposureTime = exposureTime;
            this.gainRed = gainRed;
            this.gainGreen = gainGreen;
            this.gainBlue = gainBlue;
            this.wavelength = wavelength;
            this.lampAge = lampAge;
            this.illuminationMode = illuminationMode;
            this.jpegQuality = jpegQuality;
            this.labelObscured = labelObscured;
            this.focusTime = focusTime;
            this.scanTime = scanTime;
            this.writeTime = writeTime;
            this.imageName = imageName;
            this.compressionType = compressionType;
            this.imageTitle = imageTitle;
            this.subImages = subImages;
            this.defaultGamma = defaultGamma;
            this.format = format;
            this.imageSize = imageSize;
            this.bitsPerChannel = bitsPerChannel;
            this.channels = channels;
            this.pyramidRatio = pyramidRatio;
            this.fullyAutomatic = fullyAutomatic;
        }
    }

    /** @see  com.actelion.research.orbit.imageAnalysis.dal.localImage.ndpi.NDPITiledReader #getImageResolution(int) */
    public static final class NDPRImageResolution
    {
        public final double x;
        public final double y;
        public final String unit;

        public NDPRImageResolution (final double x, final double y, final String unit)
        {
            this.x = x;
            this.y = y;
            this.unit = unit;
        }
    }

    // CONSTANTS ==============================================================

    private static final NDPReadWrapper NDPR = NDPReadWrapper.INSTANCE;

    private static final List<String> EMPTY_CHANNEL_NAMES = Collections.emptyList();

    /**
     * Nanometers used to get the number of pixels (x,y) and calculate the resolution in nm/pixel
     * 
     * @see #getImageResolution(int)
     */
    private static final int NANOMETERS_FOR_RESOLUTION = 1000000000; // 1m

    // ATTRIBUTES =============================================================

    // CONSTRUCTORS ===========================================================

    // METHODS ================================================================
    // INIT -------------------------------------------------------------------

    /**
     * Initialize a test image
     * 
     * @param width Width of the image
     * @param height Height of the image
     * @return Image ID
     */
    public int initTestImage (final int width, final int height) throws NDPReadWrapper.NDPRException
    {
        final int requestID = NDPR.createRequest(NDPReadWrapper.RequestType.InitTestImage);
        try {
            NDPR.setRequestInt(requestID, "width", width);
            NDPR.setRequestInt(requestID, "height", height);
            final int imageID = NDPR.executeRequest(requestID);
            return imageID;
        } finally {
            NDPR.freeRequest(requestID);
        }
    }

    /**
     * Initialize an image
     * 
     * @param imgFile Image file {@link Path}
     * @return Image ID
     */
    public int initImage (final Path imgFile) throws NDPReadWrapper.NDPRException
    {
        final int requestID = NDPR.createRequest(NDPReadWrapper.RequestType.InitFileImage);
        try {
            NDPR.setRequestString(requestID, "filename", imgFile.toString());
            final int imageID = NDPR.executeRequest(requestID);
            return imageID;
        } finally {
            NDPR.freeRequest(requestID);
        }
    }

    // CLOSE ------------------------------------------------------------------

    /**
     * Close an image
     * <p/>
     * NOTE This method does not throw {@link Exception}s but return {@code false} in case of an error
     * because it will often be used in a {@code finally} block.
     * 
     * @param imageID Image ID - see {@link #initImage(Path)} / {@link #initTestImage(int, int)}<br>
     *        NOTE Does nothing if {@code imageID} &le; 0 (returns {@code false} in this case).
     * @return success
     */
    public boolean closeImage (final int imageID)
    {
        if (imageID < 0) {
            return false;
        } else {
            try {
                final int requestID = NDPR.createRequest(RequestType.CloseImage);
                try {
                    NDPR.setRequestInt(requestID, "imageid", imageID);
                    NDPR.executeRequest(requestID);
                } finally {
                    NDPR.freeRequest(requestID);
                }
                return true;
            } catch (final NDPReadWrapper.NDPRException exception) {
                return false;
            }
        }
    }

    // IMAGE INFO -------------------------------------------------------------

    /**
     * Read info attributes of an image
     * 
     * @param imageID Image ID - see {@link #initImage(Path)} / {@link #initTestImage(int, int)}
     * @return {@link NDPRImageInfo}
     */
    public NDPRImageInfo getImageInfo (final int imageID) throws NDPRException
    {
        final int requestID = NDPR.createRequest(RequestType.GetImageInfo);
        try {
            NDPR.setRequestInt(requestID, "imageid", imageID);
            NDPR.executeRequest(requestID);

            final int imageWidth = NDPR.getRequestInt(requestID, "width");
            final int imageHeight = NDPR.getRequestInt(requestID, "height");
            final int physicalX = NDPR.getRequestInt(requestID, "physicalx");
            final int physicalY = NDPR.getRequestInt(requestID, "physicaly");
            final int physicalWidth = NDPR.getRequestInt(requestID, "physicalwidth");
            final int physicalHeight = NDPR.getRequestInt(requestID, "physicalheight");
            final int channels = NDPR.getRequestInt(requestID, "nochannels");
            final int bitsPerChannel = NDPR.getRequestInt(requestID, "bitsperchannel");
            final int zLayers = NDPR.getRequestInt(requestID, "nozlayers");
            final String zLayerPositions = NDPR.getRequestString(requestID, "zlayers");
            final float lens = NDPR.getRequestFloat(requestID, "lens");
            final double resolutionMuMperPixel = getImageResolution(imageID).x/1000d;
            // TODO There are some more attributes which could be read

            return new NDPRImageInfo(imageWidth, imageHeight, //
                                     physicalX, physicalY, physicalWidth, physicalHeight, //
                                     channels, bitsPerChannel, //
                                     zLayers, zLayerPositions, //
                                     lens,resolutionMuMperPixel);
        } finally {
            NDPR.freeRequest(requestID);
        }
    }

    // IMAGE METADATA ---------------------------------------------------------

    /**
     * Read all metadata of an image
     * <p/>
     * Reads the following information:
     * 
     * <pre>
     * ndpImage.Lens                float  Lens that the image was scanned with 
     * ndpImage.BackgroundColor     int    Calculated image background colour (RGB) 
     * ndpImage.Reference           string Barcode or manually entered slide reference entered during scanning 
     * ndpImage.Creator             string Name of the software that created this image 
     * ndpImage.HardwareMake        string Name of the manufacturer of the scanner used 
     * ndpImage.HardwareModel       string Name of the model of scanner used 
     * ndpImage.HardwareSerial      string Serial number of the scanner used 
     * ndpImage.CreationDateTime    string Date and time of scan (ISO format) 
     * ndpImage.CalibrationInfo     string Raw calibration data from the scanner
     * ndpImage.DefaultViewingAngle float  Recommend angle to rotate this image by
     * ndpImage.FilterSetName       string Name of the filter set used (channel name)
     *   According to 'ndpImage.NoSubImages' all channel names are read and stored in {@link NDPRImageMetadata#channelNames}
     * ndpImage.ExposureRatio       int    Exposure time ratio used 
     * ndpImage.ExposureTime        int    Exposure time used (ns) 
     * ndpImage.GainRed             int    Gain multiplier used for red channel 
     * ndpImage.GainGreen           int    Gain multiplier used for green channel
     * ndpImage.GainBlue            int    Gain multiplier used for blue channel 
     * ndpImage.WaveLength          int    Emission wavelength of the sample (nm) 
     * ndpImage.LampAge             int    Age of the fluorescence lamp (hours)
     * ndpImage.IlluminationMode    int    TODO &rarr; enum
     *   0: Brightfield 
     *   1: Fluorescence 
     *   2: Fluorescence with Brightfield focusing 
     *   4: 36 bit Fluorescence 
     *   5: 36 bit Fluorescence with B/F focusing 
     *   6: 12 bit Mono Fluorescence 
     *   7: 12 bit Mono Fluorescence with B/F focus 
     *   13: 14 bit Mono Fluorescence 
     *   14: 14 bit Mono Fluorescence with B/F focus 
     * ndpImage.JpegQuality         int    JPEG compression quality setting (%) 
     * ndpImage.LabelObscured       bool   True if the label area of the macro image was obscured for privacy by the scanning software 
     * ndpImage.FocusTime           int    Duration of the focus stage of scanning (s) 
     * ndpImage.ScanTime            int    Duration of the scanning process (s)
     * ndpImage.WriteTime           int    Time taken to finish writing the file to disk at the end of scanning
     * ndpImage.Name                string User friendly name to refer to this image 
     * ndpImage.CompressionType     string Type of compression used within this image. 
     * ndpImage.Title               string User friendly title to refer to this image 
     * ndpImage.NoSubImages         int    Number of sub-images present (for multispectral images) 
     * ndpImage.DefaultGamma        float  Recommended gamma value to display with
     * ndpImage.Format              string User friendly description of the file format e.g. ‘NanoZoomer Digital Pathology Image (ndpi)’ 
     * ndpImage.DataSize            i64    File size of the image (bytes)
     * ndpImage.BitsPerChannel      int    Number of bits per channel in the source data 
     * ndpImage.NoChannels          int    Number of channels in the source data 
     * ndpImage.PyramidRatio        float  Ratio between the highest and second highest resolution pyramid layers in the image file
     * ndpImage.FullyAutomaticFocus bool   Flag indicating if the slide was focussed without manual intervention
     * </pre>
     * 
     * @param imageID Image ID - see {@link #initImage(Path)} / {@link #initTestImage(int, int)}
     * @return {@link NDPRImageMetadata}
     */
    public NDPRImageMetadata getImageMetadata (final int imageID) throws NDPRException
    {
        final int requestID = NDPR.createRequest(RequestType.GetMetadata);
        try {
            NDPR.setRequestInt(requestID, "imageid", imageID);

            final float lens = getImageMetadataFloat(requestID, "ndpImage.Lens");
            final long bgColor = getImageMetadataInt64(requestID, "ndpImage.BackgroundColor");
            final String barcode = getImageMetadataString(requestID, "ndpImage.Reference");
            final String creator = getImageMetadataString(requestID, "ndpImage.Creator");
            final String manufacturer = getImageMetadataString(requestID, "ndpImage.HardwareMake");
            final String scannerModel = getImageMetadataString(requestID, "ndpImage.HardwareModel");
            final String serialNumber = getImageMetadataString(requestID, "ndpImage.HardwareSerial");
            final String creationTime = getImageMetadataString(requestID, "ndpImage.CreationDateTime");
            final String calibrationInfo = getImageMetadataString(requestID, "ndpImage.CalibrationInfo");
            final float defaultViewAngle = getImageMetadataFloat(requestID, "ndpImage.DefaultViewingAngle");
            final int exposureRatio = getImageMetadataInt(requestID, "ndpImage.ExposureRatio");
            final int exposureTime = getImageMetadataInt(requestID, "ndpImage.ExposureTime");
            final int gainRed = getImageMetadataInt(requestID, "ndpImage.GainRed");
            final int gainGreen = getImageMetadataInt(requestID, "ndpImage.GainGreen");
            final int gainBlue = getImageMetadataInt(requestID, "ndpImage.GainBlue");
            final int wavelength = getImageMetadataInt(requestID, "ndpImage.WaveLength");
            final int lampAge = getImageMetadataInt(requestID, "ndpImage.LampAge");
            final int illuminationMode = getImageMetadataInt(requestID, "ndpImage.IlluminationMode");
            final int jpegQuality = getImageMetadataInt(requestID, "ndpImage.JpegQuality");
            final boolean labelObscured = getImageMetadataBool(requestID, "ndpImage.LabelObscured");
            final int focusTime = getImageMetadataInt(requestID, "ndpImage.FocusTime");
            final int scanTime = getImageMetadataInt(requestID, "ndpImage.ScanTime");
            final int writeTime = getImageMetadataInt(requestID, "ndpImage.WriteTime");
            final String imageName = getImageMetadataString(requestID, "ndpImage.Name");
            final String compressionType = getImageMetadataString(requestID, "ndpImage.CompressionType");
            final String imageTitle = getImageMetadataString(requestID, "ndpImage.Title");
            final int subImages = getImageMetadataInt(requestID, "ndpImage.NoSubImages");
            final float defaultGamma = getImageMetadataFloat(requestID, "ndpImage.DefaultGamma");
            final String format = getImageMetadataString(requestID, "ndpImage.Format");
            final long imageSize = getImageMetadataInt64(requestID, "ndpImage.DataSize");
            final int bitsPerChannel = getImageMetadataInt(requestID, "ndpImage.BitsPerChannel");
            final int channels = getImageMetadataInt(requestID, "ndpImage.NoChannels");
            final float pyramidRatio = getImageMetadataFloat(requestID, "ndpImage.PyramidRatio");
            final boolean fullyAutomatic = getImageMetadataBool(requestID, "ndpImage.FullyAutomaticFocus");

            final List<String> channelNames;
            if (subImages <= 1) {
                final String filterSetName = getImageMetadataString(requestID, "ndpImage.FilterSetName");
                channelNames = filterSetName == null || filterSetName.isEmpty() ? EMPTY_CHANNEL_NAMES : Arrays.asList(filterSetName);
            } else {
                channelNames = new ArrayList<>();
                for (int subImage = 0; subImage < subImages; subImage++) {
                    NDPR.setRequestInt(requestID, "subimage", subImage);
                    final String filterSetName = getImageMetadataString(requestID, "ndpImage.FilterSetName");
                    channelNames.add(filterSetName);
                }
            }

            return new NDPRImageMetadata(lens, bgColor, barcode, creator, manufacturer, scannerModel, serialNumber, creationTime, calibrationInfo, defaultViewAngle, channelNames,
                                         exposureRatio, exposureTime, gainRed, gainGreen, gainBlue, wavelength, lampAge, illuminationMode, jpegQuality, labelObscured, focusTime,
                                         scanTime, writeTime, imageName, compressionType, imageTitle, subImages, defaultGamma, format, imageSize, bitsPerChannel, channels,
                                         pyramidRatio, fullyAutomatic);
        } finally {
            NDPR.freeRequest(requestID);
        }
    }

    private boolean getImageMetadataBool (final int requestID, final String metadataName) throws NDPRException
    {
        NDPR.setRequestString(requestID, "metadataname", metadataName);
        NDPR.executeRequest(requestID);
        return NDPR.getRequestInt(requestID, "value") != 0;
    }

    private int getImageMetadataInt (final int requestID, final String metadataName) throws NDPRException
    {
        NDPR.setRequestString(requestID, "metadataname", metadataName);
        NDPR.executeRequest(requestID);
        return NDPR.getRequestInt(requestID, "value");
    }

    private long getImageMetadataInt64 (final int requestID, final String metadataName) throws NDPRException
    {
        NDPR.setRequestString(requestID, "metadataname", metadataName);
        NDPR.executeRequest(requestID);
        return NDPR.getRequestInt64(requestID, "value");
    }

    private float getImageMetadataFloat (final int requestID, final String metadataName) throws NDPRException
    {
        NDPR.setRequestString(requestID, "metadataname", metadataName);
        NDPR.executeRequest(requestID);
        return NDPR.getRequestFloat(requestID, "value");
    }

    private String getImageMetadataString (final int requestID, final String metadataName) throws NDPRException
    {
        NDPR.setRequestString(requestID, "metadataname", metadataName);
        NDPR.executeRequest(requestID);
        return NDPR.getRequestString(requestID, "value");
    }

    // IMAGE RESOLUTION -------------------------------------------------------

    /**
     * Read the resolution of an image
     * 
     * @param imageID Image ID - see {@link #initImage(Path)} / {@link #initTestImage(int, int)}
     * @return {@link NDPRImageResolution}
     */
    public NDPRImageResolution getImageResolution (final int imageID) throws NDPRException
    {
        final int requestID = NDPR.createRequest(RequestType.ConvertUnits);
        try {
            NDPR.setRequestInt(requestID, "imageid", imageID);

            NDPR.setRequestInt(requestID, "physicalwidth", NANOMETERS_FOR_RESOLUTION); 
            NDPR.setRequestInt(requestID, "physicalheight", NANOMETERS_FOR_RESOLUTION); 

            NDPR.executeRequest(requestID);

            final int xPixelsPerMeter = NDPR.getRequestInt(requestID, "pixelwidth");
            final int yPixelsPerMeter = NDPR.getRequestInt(requestID, "pixelheight");

            return new NDPRImageResolution((double) NANOMETERS_FOR_RESOLUTION / (double) xPixelsPerMeter, //
                                           (double) NANOMETERS_FOR_RESOLUTION / (double) yPixelsPerMeter, //
                                           "nm/pixel");
        } finally {
            NDPR.freeRequest(requestID);
        }
    }

    // SLIDE IMAGE ------------------------------------------------------------

    /**
     * Get the slide overview image
     * 
     * @param imageID Image ID - see {@link #initImage(Path)} / {@link #initTestImage(int, int)}
     * @return Byte array for the jpeg representation of the slide image
     */
    public byte[] getSlideData (final int imageID) throws NDPRException, IOException
    {
        final int requestID = NDPR.createRequest(RequestType.GetMetaImage);
        try {
            NDPR.setRequestString(requestID, "format", "JPEG");
            NDPR.setRequestString(requestID, "metaimagename", "ndpImage.SlideImage");
            NDPR.setRequestInt(requestID, "imageid", imageID);

            // NOTE This request throws an exception if no such image is
            // present, but we simply want to return 'null' in this case
            try {
                NDPR.executeRequest(requestID);
            } catch (NDPRException exception) {
                switch (exception.getError()) {
                case MetaImageNotPresent:
                    return null;
                default:
                    throw exception;
                }
            }

            // TODO Create a method to read out that information?
            // final int imageWidth = NDPR.getRequestInt(requestID, "width");
            // final int imageHeight = NDPR.getRequestInt(requestID, "height");
            // final int physicalX = NDPR.getRequestInt(requestID, "physicalx");
            // final int physicalY = NDPR.getRequestInt(requestID, "physicaly");
            // final int physicalWidth = NDPR.getRequestInt(requestID, "physicalwidth");
            // final int physicalHeight = NDPR.getRequestInt(requestID, "physicalheight");

            final Pointer imgBuffer = NDPR.getRequestPointer(requestID, "imagebuffer");
            final int imgBufferSize = NDPR.getRequestInt(requestID, "buffersize");

            return imgBuffer.getByteArray(0, imgBufferSize);
        } finally {
            NDPR.freeRequest(requestID);
        }
    }

    /**
     * Get the slide overview image
     * 
     * @param imageID Image ID - see {@link #initImage(Path)} / {@link #initTestImage(int, int)}
     * @return {@link BufferedImage}
     */
    public BufferedImage getSlideImage (final int imageID) throws NDPRException, IOException
    {
        final byte[] data = getSlideData(imageID);
        return data == null ? null : ImageIO.read(new ByteArrayInputStream(getSlideData(imageID)));
    }

    // TILES ------------------------------------------------------------------

    /**
     * Get a tile from a NDPI image
     * 
     * @param imageID Image ID
     * @param left Left pixel coordinate of the tile in the given image
     * @param top Top pixel coordinate of the tile in the given image
     * @param srcWidth Width of the tile in the given image
     * @param srcHeight Height of the tile in the given image
     * @param dstWidth Width of the returned tile (scaled)
     * @param dstHeight Height of the returned tile (scaled)
     * @return Byte array for the jpeg representation of the specified tile ({@code dstWidth} x
     *         {@code dstHeight})
     */
    public byte[]
           getTileData (final int imageID, final int left, final int top, final int srcWidth, final int srcHeight, final int dstWidth, final int dstHeight) throws NDPRException,
                                                                                                                                                            IOException
    {
        final int requestID = NDPR.createRequest(RequestType.GetRegion);
        try {
            NDPR.setRequestString(requestID, "format", "JPEG");
            NDPR.setRequestInt(requestID, "imageid", imageID);
            NDPR.setRequestInt(requestID, "sourcewidth", srcWidth);
            NDPR.setRequestInt(requestID, "sourceheight", srcHeight);
            NDPR.setRequestInt(requestID, "width", dstWidth);
            NDPR.setRequestInt(requestID, "height", dstHeight);
            NDPR.setRequestInt(requestID, "left", left);
            NDPR.setRequestInt(requestID, "top", top);
            NDPR.executeRequest(requestID);

            final Pointer imgBuffer = NDPR.getRequestPointer(requestID, "imagebuffer");
            final int imgBufferSize = NDPR.getRequestInt(requestID, "buffersize");

            return imgBuffer.getByteArray(0, imgBufferSize);
        } finally {
            NDPR.freeRequest(requestID);
        }
    }

    /**
     * Get a tile from a NDPI image
     * 
     * @param imageID Image ID
     * @param left Left pixel coordinate of the tile in the given image
     * @param top Top pixel coordinate of the tile in the given image
     * @param srcWidth Width of the tile in the given image
     * @param srcHeight Height of the tile in the given image
     * @param dstWidth Width of the returned tile (scaled)
     * @param dstHeight Height of the returned tile (scaled)
     * @return {@link BufferedImage} ({@code dstWidth} x {@code dstHeight}) for the specified tile
     */
    public BufferedImage
           getTileImage (final int imageID, final int left, final int top, final int srcWidth, final int srcHeight, final int dstWidth, final int dstHeight) throws NDPRException,
                                                                                                                                                             IOException
    {
        return ImageIO.read(new ByteArrayInputStream(getTileData(imageID, left, top, srcWidth, srcHeight, dstWidth, dstHeight)));
    }

    // STATIC METHODS =========================================================

}
