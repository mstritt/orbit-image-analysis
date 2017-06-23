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

import java.awt.image.Raster;
import java.io.IOException;

@SuppressWarnings("unchecked")
public class OrbitTiledImageIOrbitImage extends OrbitTiledImage2 {

    protected IOrbitImage image = null;

    public OrbitTiledImageIOrbitImage(IOrbitImage image) throws Exception {
        this(image,0);
    }

    public OrbitTiledImageIOrbitImage(IOrbitImage image, int level) throws Exception {
        //super("");
        this.image = image;
        this.level = level;
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
        //this.filename = "PlanarImage "+image.hashCode();
        this.filename = image.getFilename();
        // better set useCache always to false here???

        this.originalWasGrayScale = image.getOriginalWasGrayScale();
        this.originalBitsPerSample = image.getOriginalBitsPerSample();
    }


    @Override
    protected synchronized boolean readInfo(String filename) throws OrbitImageServletException {
        return true;
    }

    @Override
    protected String readInfoString(String filename) throws OrbitImageServletException {
        return null; // or use infoStr from image?
    }

    @Override
    public Raster getTileData(int arg0, int arg1, float[] channelContributions, boolean analysis) {
        if (image instanceof IOrbitImageMultiChannel) {
            return  ((IOrbitImageMultiChannel)image).getTileData(arg0, arg1, channelContributions, analysis);
        } else {
            return image.getTileData(arg0, arg1, analysis);
        }
    }

//	public BufferedImage getBufferedImage() {
//		return image.getBufferedImage();
//	}


    @Override
    public void close() throws IOException {
         image.close();
    }

    public IOrbitImage getOrbitImage() {
        return image;
    }
}
