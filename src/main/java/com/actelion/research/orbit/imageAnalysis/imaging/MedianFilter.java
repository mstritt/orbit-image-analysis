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

package com.actelion.research.orbit.imageAnalysis.imaging;

import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.operator.MedianFilterDescriptor;
import java.awt.image.renderable.ParameterBlock;

public class MedianFilter implements IImageManipulation {

    private PlanarImage source;
    private int radius = 7;
    private boolean parameterSet = false;

    public MedianFilter() {
    }


    public MedianFilter(PlanarImage source, int radius) {
        this();
        this.source = source;
        this.radius = radius;
        if (this.radius % 2 == 0) this.radius++;
        parameterSet = true;
    }

    public void setParameter(PlanarImage source, int radius) {
        this.source = source;
        this.radius = radius;
        if (this.radius % 2 == 0) this.radius++;
        parameterSet = true;
    }


    public PlanarImage process() {
        if (!parameterSet) throw new IllegalStateException("parameters not set");
        PlanarImage pi = source;
        //   for (int i=0; i<numIter; i++) {
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(pi);
        pb.add(MedianFilterDescriptor.MEDIAN_MASK_SQUARE);
        pb.add(radius);
        pi = JAI.create("MedianFilter", pb);
        //  }
        return pi;

    }

}
