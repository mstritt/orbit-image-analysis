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

package com.actelion.research.orbit.imageAnalysis.utils;

import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.dal.IOrbitImageMultiChannel;

import java.awt.image.Raster;
import java.io.IOException;

public class OrbitTiledImageIOrbitImage extends OrbitTiledImage2 {

    protected IOrbitImage image;

    public OrbitTiledImageIOrbitImage(IOrbitImage image) {
        this(image,0);
    }

    public OrbitTiledImageIOrbitImage(IOrbitImage image, int level) {
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

        // bugfix 20.04.2012 Manuel: colorModel is now always defined by input image (overview image problem)
        this.colorModel = image.getColorModel();
        this.sampleModel = image.getSampleModel();
        this.filename = image.getFilename();
        // better set useCache always to false here???

        this.originalWasGrayScale = image.getOriginalWasGrayScale();
        this.originalBitsPerSample = image.getOriginalBitsPerSample();
    }

    @Override
    protected synchronized boolean readInfo(String filename) {
        return true;
    }

    @Override
    protected String readInfoString(String filename) {
        return null; // or use infoStr from image?
    }

    @Override
    public Raster getTileData(int arg0, int arg1, float[] channelContributions, boolean analysis, float[] analysisHues) {
        if (image instanceof IOrbitImageMultiChannel) {
            return  ((IOrbitImageMultiChannel)image).getTileData(arg0, arg1, channelContributions, analysis, analysisHues);
        } else {
            return image.getTileData(arg0, arg1, analysis);
        }
    }

    @Override
    public void close() throws IOException {
         image.close();
    }

    public IOrbitImage getOrbitImage() {
        return image;
    }
}
