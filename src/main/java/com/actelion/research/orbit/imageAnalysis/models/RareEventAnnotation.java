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

import com.actelion.research.orbit.beans.RawAnnotation;

import java.io.IOException;

public class RareEventAnnotation extends SpotAnnotation {
    private static final long serialVersionUID = 1L;

    public RareEventAnnotation() {
    }

    public RareEventAnnotation(String text, ClassShape shape) {
        super(text, shape);
    }

    public RareEventAnnotation(RawAnnotation ra) throws IOException, ClassNotFoundException {
        super(ra);
    }

    @Override
    public int getSpotType() {
        return SPOT_TYPE_RAREEVENT;
    }

}
