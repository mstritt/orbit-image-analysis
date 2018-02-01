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
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * {@link IOrbitImageServerPyramid} for NDPI images which is caching image to improve performance.
 */
public class NDPICachingOrbitImageServerPyramid extends NDPIOrbitImageServerPyramid
{
    // INNER CLASSES / INTERFACES / ENUMS =====================================

    // CONSTANTS ==============================================================

    // ATTRIBUTES =============================================================

    /** Max number of cached images */
    private final int maxCachedImages;

    /** Cache {@link Map}: file path &rarr; {@link ImageData} */
    private final Map<String, ImageData> fileName2imageData = new LinkedHashMap<>();

    // CONSTRUCTORS ===========================================================

    /**
     * {@link NDPICachingOrbitImageServerPyramid} constrcutor
     * 
     * @param maxCachedImages {@link #maxCachedImages}
     */
    public NDPICachingOrbitImageServerPyramid (final int maxCachedImages)
    {
        this.maxCachedImages = maxCachedImages;
    }

    // METHODS ================================================================
    // ORBIT IMAGE SERVER -----------------------------------------------------

    // ORBIT IMAGE SERVER PYRAMID ---------------------------------------------

    // NDPI ORBIT IMAGER SERVER PYRAMID ---------------------------------------

    @Override
    protected ImageData getImageData (final String fileName, final boolean needInfo, final boolean needMeta) throws RemoteException
    {
        synchronized (fileName2imageData) {
            ImageData imageData = fileName2imageData.get(fileName);
            if (imageData != null) {
                // NOTE Need to remove it to ensure it is added at the end (see below)
                fileName2imageData.remove(fileName);
            } else {
                int imageID = -1;
                try {
                    // NOTE Because we are caching the information, we always
                    // request the ID, the 'NDPRImageInfo' and 'NDPRImageMetadata'
                    imageID = reader.initImage(Paths.get(fileName));
                    final NDPRImageInfo info = reader.getImageInfo(imageID);
                    final NDPRImageMetadata meta = reader.getImageMetadata(imageID);
                    imageData = new ImageData(imageID, info, meta);

                    // Remove first (oldest) elements from the cache if it would
                    // otherwise exceed the limit of 'MAX_CACHED_IMAGES'
                    forget(maxCachedImages - 1);
                } catch (NDPRException exception) {
                    throw new RemoteException("Cannot get image: " + fileName, exception);
                }
            }
            fileName2imageData.put(fileName, imageData);
            return imageData;
        }
    }

    @Override
    protected void dispose (final ImageData imageData)
    {
        // NOTE Because we are caching images we never dispose
        // an image directly after it has been used. 'dispose()'
        // should be called instead when this image server isn't
        // used anymore.
    }

    // NDPI CACHING ORBIT IMAGER SERVER PYRAMID -------------------------------

    /** Free all cached images */
    public void dispose ()
    {
        synchronized (fileName2imageData) {
            forget(0);
        }
    }

    // PRIVATE ----------------------------------------------------------------

    /**
     * Forget cached images such that the cache doesn't contain more than {@code maxSize} images
     * afterwards
     */
    private void forget (final int maxSize)
    {
        if (fileName2imageData.size() > maxSize) {
            final Iterator<Entry<String, ImageData>> iter = fileName2imageData.entrySet().iterator();
            while (iter.hasNext() && fileName2imageData.size() > maxSize) {
                final Entry<String, ImageData> entry = iter.next();
                reader.closeImage(entry.getValue().id);
                iter.remove();
            }
        }
    }

    // STATIC METHODS =========================================================

}
