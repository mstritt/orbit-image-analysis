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

import com.actelion.research.orbit.imageAnalysis.dal.localImage.ndpi.NDPReadWrapper.*;
import com.actelion.research.orbit.imageAnalysis.dal.localImage.ndpi.NDPITiledReader.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

/**
 * {@link IOrbitImageServerPyramid} for NDPI images
 * <p/>
 * TODO Caching image to improve performance if necessary.
 */
public class NDPIOrbitImageServerPyramid 
{
    // INNER CLASSES / INTERFACES / ENUMS =====================================

    /** Bundles data usually needed for one image */
    protected static final class ImageData
    {
        protected final int id;
        protected final NDPRImageInfo info;
        protected final NDPRImageMetadata meta;

        protected ImageData (final int id, final NDPRImageInfo info, final NDPRImageMetadata meta)
        {
            this.id = id;
            this.info = info;
            this.meta = meta;
        }
    }

    // CONSTANTS ==============================================================

    /** The width and height of tiles returned by this {@link IOrbitImageServerPyramid} */
    protected static final int DST_TILE_SIZE = 512;

    /**
     * The width and height of the downscaled source image level with the lowest resolution
     * <p/>
     * NOTE This is needed to calculate the (theoretical) number of pyramid levels, which we cannot
     * get directly from NDPI images (although internally these images are organized this way)
     */
    protected static final int MIN_SRC_LEVEL_SIZE = 1024;

    // ATTRIBUTES =============================================================
    
    final NDPITiledReader reader = new NDPITiledReader();

    // CONSTRUCTORS ===========================================================

    public NDPIOrbitImageServerPyramid ()
    {
        NDPReadWrapper.INSTANCE.setOption(Option.TextEncoding, Encoding.UTF8.type);
    }

    // METHODS ================================================================
    // ORBIT IMAGE SERVER -----------------------------------------------------

    public String getInfo (final String fileName) throws RemoteException
    {
        return getInfo(fileName, 0);
    }

    public byte[] getTile (final String fileName, final int tileX, final int tileY) throws RemoteException
    {
        return getTile(fileName, tileX, tileY, 0);
    }

    public byte[] getData (final String fileName) throws RemoteException
    {
        // TODO Is there no method to get the whole image as a byte array?
        // (We could use 'getTileData()' though if we really need this)
        // throw new UnsupportedOperationException();
        return null;
    }

    // ORBIT IMAGE SERVER PYRAMID ---------------------------------------------

    public byte[] getTile (final String fileName, final int level, final int tileX, final int tileY) throws RemoteException
    {
        ImageData imageData = null;
        try {
            imageData = getImageData(fileName, false, true);

            // Scale factor for the source tile in this 'level'
            final double scaleFactor = Math.pow(imageData.meta.pyramidRatio, level);

            return reader.getTileData(imageData.id, //
                               (int)(DST_TILE_SIZE * tileX * scaleFactor), //
                               (int)(DST_TILE_SIZE * tileY * scaleFactor), //
                               (int) (DST_TILE_SIZE * scaleFactor), //
                               (int) (DST_TILE_SIZE * scaleFactor), //
                               DST_TILE_SIZE, //
                               DST_TILE_SIZE);
        } catch (NDPRException | IOException exception) {
            throw new RemoteException("Cannot get tile (" + tileX + "," + tileY + ") from level " + level + " of NDPI image: " + fileName, exception);
        } finally {
            dispose(imageData);
        }
    }

    public String getInfo (final String fileName, final int level) throws RemoteException
    {
        ImageData imageData = null;
        try {
            imageData = getImageData(fileName, true, true);

            // Scale factor for the image in this 'level'
            final double scaleFactor = 1.0 / Math.pow(imageData.meta.pyramidRatio, level);

            final Map<String, Object> keyVal = new HashMap<>();
            keyVal.put("isTiled", true);
            keyVal.put("width", (int)(imageData.info.imageWidth * scaleFactor));
            keyVal.put("height", (int)(imageData.info.imageHeight * scaleFactor));
            keyVal.put("minX", 0);
            keyVal.put("minY", 0);
            keyVal.put("numBands", imageData.info.channels);
            keyVal.put("tileWidth", DST_TILE_SIZE);
            keyVal.put("tileHeight", DST_TILE_SIZE);
            keyVal.put("tileGridXOffset", 0);
            keyVal.put("tileGridYOffset", 0);
            keyVal.put("bitsPerSample", imageData.info.bitsPerChannel);
            keyVal.put("photometric", 6); // ycbcr // TODO ???
            keyVal.put("pyramidLevels", getPyramidLevels(imageData.info.imageWidth, imageData.info.imageHeight, imageData.meta.pyramidRatio));
            keyVal.put("emissionWavelength", imageData.meta.wavelength);

            // TODO How to handle multiple channels? -> NDPIS file which contains several NDPI files
            if (!imageData.meta.channelNames.isEmpty()) {
                keyVal.put("channelName", imageData.meta.channelNames.get(0));
            }

            final StringBuilder str = new StringBuilder();
            String sep = "";
            for (String key : keyVal.keySet()) {
                str.append(sep + key + "=" + keyVal.get(key));
                sep = ",";
            }
            return str.toString();
        } finally {
            dispose(imageData);
        }
    }

    public int getPyramidLevels (final String fileName) throws RemoteException
    {
        // NOTE This information is not directly contained in NDPI images, so we
        // calculate a theoretical value based on the size and pyramid level ratio.
        ImageData imageData = null;
        try {
            imageData = getImageData(fileName, true, true);
            return getPyramidLevels(imageData.info.imageWidth, imageData.info.imageHeight, imageData.meta.pyramidRatio);
        } finally {
            dispose(imageData);
        }
    }

    public byte[] getOverviewImage (final String fileName) throws RemoteException
    {
        ImageData imageData = null;
        try {
            imageData = getImageData(fileName, false, false);
            return reader.getSlideData(imageData.id);
        } catch (NDPRException | IOException exception) {
            throw new RemoteException("Cannot get overview image of NDPI image: " + fileName, exception);
        } finally {
            dispose(imageData);
        }
    }
    
    // NDPI ORBIT IMAGER SERVER PYRAMID ---------------------------------------

    /**
     * Get the {@link ImageData} for the given {@code fileName} either from the cache or by
     * initializing and reading the information over the NDPR API.
     * 
     * @param fileName file path
     * @param needInfo Need the {@link NDPRImageInfo} set to {@link ImageData#info}?
     * @param needMeta Need the {@link NDPRImageMetadata} set to {@link ImageData#meta}?
     */
    protected ImageData getImageData (final String fileName, final boolean needInfo, final boolean needMeta) throws RemoteException
    {
        try {
            final int imageID = reader.initImage(Paths.get(fileName));
            final NDPRImageInfo info = needInfo ? reader.getImageInfo(imageID) : null;
            final NDPRImageMetadata meta = needMeta ? reader.getImageMetadata(imageID) : null;
            return new ImageData(imageID, info, meta);
        } catch (NDPRException exception) {
            throw new RemoteException("Cannot get image: " + fileName, exception);
        }
    }

    /**
     * Dispose data for one image
     * 
     * @param imageData {@link ImageData} for that image of {@code null} (if the initialization of
     *        the image has failed)
     */
    protected void dispose (final ImageData imageData)
    {
        if (imageData != null) {
            reader.closeImage(imageData.id);
        }
    }

    // PRIVATE ----------------------------------------------------------------

    protected int getPyramidLevels (final int width, final int height, final float pyramidRatio)
    {
        final int size = Math.min(width, height);
        return (int) (Math.log(size) / Math.log(pyramidRatio)) - (int) (Math.log(MIN_SRC_LEVEL_SIZE) / Math.log(pyramidRatio)) + 1;
    }

    // STATIC METHODS =========================================================

    public static void main (String[] args)
    {
        NDPIOrbitImageServerPyramid imageServer = new NDPIOrbitImageServerPyramid();

        System.out.println(imageServer.getPyramidLevels(1, 1, 2.0f));
    }

}
