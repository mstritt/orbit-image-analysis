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

package com.actelion.research.orbit.imageAnalysis.models;

import java.awt.*;
import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.awt.image.SampleModel;

public class ModifiedRaster extends Raster {

    public ModifiedRaster(Raster r) {
        super(r.getSampleModel(), r.getDataBuffer(), r.getBounds(), new Point(r.getSampleModelTranslateX(), r.getSampleModelTranslateY()), r.getParent());
    }

    protected ModifiedRaster(SampleModel sampleModel, DataBuffer dataBuffer, Rectangle aRegion, Point sampleModelTranslate, Raster parent) {
        super(sampleModel, dataBuffer, aRegion, sampleModelTranslate, parent);
    }

    protected ModifiedRaster(SampleModel sampleModel, DataBuffer dataBuffer, Point origin) {
        super(sampleModel, dataBuffer, origin);
    }

    protected ModifiedRaster(SampleModel sampleModel, Point origin) {
        super(sampleModel, origin);
    }
}
