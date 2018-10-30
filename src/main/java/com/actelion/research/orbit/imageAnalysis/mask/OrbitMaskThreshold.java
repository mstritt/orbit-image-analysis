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

package com.actelion.research.orbit.imageAnalysis.mask;

import com.actelion.research.orbit.imageAnalysis.utils.TiledImagePainter;

import java.awt.*;
import java.awt.image.Raster;
import java.io.Serializable;

public class OrbitMaskThreshold implements IOrbitMask, Serializable {

    private int min;
    private int max;

    public OrbitMaskThreshold(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public void initialize(final TiledImagePainter tip) {

    }

    @Override
    public int numClasses() {
        return 2;
    }

    @Override
    public int classNum(int x, int y, final Raster raster) throws Exception {
        int intens = 0;
        for (int b=0; b<raster.getNumBands(); b++) {
            intens += raster.getSample(x,y,b);
        }
        intens /= raster.getNumBands();
        if (intens>=min && intens<=max) return 1;
        else return 0;
    }

    @Override
    public boolean isIncluded(int x, int y, final Raster raster) throws Exception {
        return classNum(x,y,raster)>0;
    }


    @Override
    public String className(int classNum) {
        if (classNum==0) return "background";
            else return "foreground";
    }

    @Override
    public int classColor(int classNum) {
        if (classNum==0) return Color.blue.getRGB();
        else return Color.white.getRGB();
    }

    @Override
    public IOrbitMask clone() {
        try {
            return (IOrbitMask) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
