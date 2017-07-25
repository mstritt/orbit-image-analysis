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

import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.dal.IOrbitImageMultiChannel;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;

import javax.media.jai.PlanarImage;
import java.awt.image.Raster;

@SuppressWarnings("unchecked")
public class OrbitTiledImagePlanarImage extends OrbitTiledImage2 {

    protected PlanarImage image = null;

    public OrbitTiledImagePlanarImage(String filename) throws Exception {
        super(filename);
        throw new IllegalArgumentException("Not implemented");
    }

    public OrbitTiledImagePlanarImage(PlanarImage image) throws Exception {
        super("");
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.tileWidth = image.getTileWidth();
        this.tileHeight = image.getTileHeight();
        this.tileGridXOffset = image.getTileGridXOffset();
        this.tileGridYOffset = image.getTileGridYOffset();
        this.minX = image.getMinX();
        this.minY = image.getMinY();
        this.numBands = image.getNumBands();

        this.colorModel = image.getColorModel();
        this.sampleModel = image.getSampleModel();

//		if (numBands==1) this.colorModel = grayColorModel; else
//		{
//			this.colorModel = rgbColorModel;
//		}

//		this.colorModel = rgbColorModel; // an OrbitTiledImage is always a RGB image
//		this.sampleModel = colorModel.createCompatibleSampleModel(tileWidth, tileHeight);

        // bugfix 20.04.2012 Manuel: colorModel is now always defined by input image (overview image problem)
        this.colorModel = image.getColorModel();
        this.sampleModel = image.getSampleModel();
        this.filename = "PlanarImage " + image.hashCode();
        // better set useCache always to false here???
    }


    @Override
    protected synchronized boolean readInfo(String filename) throws OrbitImageServletException {
        return true;
    }

    @Override
    protected String readInfoString(String filename) throws OrbitImageServletException {
        return null;
    }

    /**
     * will ignore channelContributions
     */
    @Override
    public Raster getTileData(int tileX, int tileY, float[] channelContributions, boolean analysis, float[] analysisHues) {
        if (image instanceof IOrbitImageMultiChannel) {
            return ((IOrbitImageMultiChannel) image).getTileData(tileX,tileY,channelContributions,analysis, analysisHues);
        } else
        if (image instanceof IOrbitImage) {
            return ((IOrbitImage) image).getTileData(tileX,tileY,analysis);
        } else {
            return image.getTile(tileX, tileY);
        }
    }


}
