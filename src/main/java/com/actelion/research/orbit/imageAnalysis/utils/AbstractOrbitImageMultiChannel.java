/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
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
import com.actelion.research.orbit.dal.IOrbitImageMultiChannel;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.io.IOException;

public abstract class AbstractOrbitImageMultiChannel implements IOrbitImageMultiChannel {
    private IOrbitImage orbitImage;

    public AbstractOrbitImageMultiChannel(IOrbitImage orbitImage) {
        this.orbitImage = orbitImage;
    }

    @Override
    public String readInfoString(String filename) throws OrbitImageServletException {
        return orbitImage.readInfoString(filename);
    }

    @Override
    public Raster getTileData(int tileX, int tileY, boolean analysis) {
        return orbitImage.getTileData(tileX, tileY, analysis);
    }

    @Override
    public MinMaxPerChan getMinMaxAnalysis() {
        return orbitImage.getMinMaxAnalysis();
    }

    @Override
    public boolean is16bit() {
        return orbitImage.is16bit();
    }

    @Override
    public BufferedImage getOverviewImage() {
        return orbitImage.getOverviewImage();
    }

    @Override
    public String getFilename() {
        return orbitImage.getFilename();
    }

    @Override
    public int getWidth() {
        return orbitImage.getWidth();
    }

    @Override
    public int getHeight() {
        return orbitImage.getHeight();
    }

    @Override
    public int getTileWidth() {
        return orbitImage.getTileWidth();
    }

    @Override
    public int getTileHeight() {
        return orbitImage.getTileHeight();
    }

    @Override
    public int getTileGridXOffset() {
        return orbitImage.getTileGridXOffset();
    }

    @Override
    public int getTileGridYOffset() {
        return orbitImage.getTileGridYOffset();
    }

    @Override
    public int getMinX() {
        return orbitImage.getMinX();
    }

    @Override
    public int getMinY() {
        return orbitImage.getMinY();
    }

    @Override
    public int getNumBands() {
        return orbitImage.getNumBands();
    }

    @Override
    public ColorModel getColorModel() {
        return orbitImage.getColorModel();
    }

    @Override
    public SampleModel getSampleModel() {
        return orbitImage.getSampleModel();
    }

    @Override
    public int getOriginalBitsPerSample() {
        return orbitImage.getOriginalBitsPerSample();
    }

    @Override
    public boolean getOriginalWasGrayScale() {
        return orbitImage.getOriginalWasGrayScale();
    }

    @Override
    public void close() throws IOException {
        orbitImage.close();
    }
}
