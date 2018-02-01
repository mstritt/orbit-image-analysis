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

import com.actelion.research.orbit.beans.MinMaxPerChan;
import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;

import javax.media.jai.PlanarImage;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.io.IOException;

public class OrbitImagePlanar implements IOrbitImage {

    private PlanarImage image;
    private String name;

    public OrbitImagePlanar(PlanarImage image, String name) {
        this.image = image;
        this.name = name;
    }

    @Override
    public String readInfoString(String s) throws OrbitImageServletException {
        return "";
    }

    @Override
    public Raster getTileData(int tileX, int tileY, boolean analysis) {
        if (image instanceof IOrbitImage) {
            return ((IOrbitImage) image).getTileData(tileX,tileY,analysis);
        } else {
            return image.getTile(tileX, tileY);
        }
    }

    @Override
    public MinMaxPerChan getMinMaxAnalysis() {
        if (image instanceof IOrbitImage) {
            return ((IOrbitImage) image).getMinMaxAnalysis();
        } else {
            return null;
        }
    }

    @Override
    public boolean is16bit() {
        if (image instanceof IOrbitImage) {
            return ((IOrbitImage) image).is16bit();
        } else {
            return false;
        }
    }


    @Override
    public String getFilename() {
        return name;
    }

    @Override
    public int getWidth() {
        return image.getWidth();
    }

    @Override
    public int getHeight() {
        return image.getHeight();
    }

    @Override
    public int getTileWidth() {
        return image.getTileWidth();
    }

    @Override
    public int getTileHeight() {
        return image.getTileHeight();
    }

    @Override
    public int getTileGridXOffset() {
        return image.getTileGridXOffset();
    }

    @Override
    public int getTileGridYOffset() {
        return image.getTileGridYOffset();
    }

    @Override
    public int getMinX() {
        return image.getMinX();
    }

    @Override
    public int getMinY() {
        return image.getMinY();
    }

    @Override
    public int getNumBands() {
        return image.getNumBands();
    }

    @Override
    public ColorModel getColorModel() {
        return image.getColorModel();
    }

    @Override
    public SampleModel getSampleModel() {
        return image.getSampleModel();
    }

    @Override
    public int getOriginalBitsPerSample() {
        return 8;
    }

    @Override
    public boolean getOriginalWasGrayScale() {
        return false;
    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public BufferedImage getOverviewImage() {
        return null;
    }
}
