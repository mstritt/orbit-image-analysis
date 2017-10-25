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

import com.freedomotic.util.SerialClone.SerialClone;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class PolygonExtInvers extends PolygonExt {
    private static final long serialVersionUID = 1L;
    private Rectangle outerBounds = null;

    public PolygonExtInvers(Rectangle outerBounds) {
        this.outerBounds = outerBounds;
        inverse = false;
    }

    public PolygonExtInvers(Polygon p, Rectangle outerBounds) {
        super(p);
        this.outerBounds = outerBounds;
        inverse = false;
    }

    public boolean contains(Point2D paramPoint2D) {
        return !super.contains(paramPoint2D);
    }

    public boolean contains(Rectangle2D paramRectangle2D) {
        return !super.contains(paramRectangle2D);
    }

    public boolean contains(double paramDouble1, double paramDouble2) {
        return !super.contains(paramDouble1, paramDouble2);
    }

    public boolean contains(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
        return !super.contains(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
    }

    public boolean intersects(Rectangle2D paramRectangle2D) {
        return true;
    }

    public boolean intersects(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
        return true;
    }

    public Rectangle getBounds() {
        return outerBounds;
    }

    public Rectangle2D getBounds2D() {
        return outerBounds;
    }

    @Override
    public PolygonExtInvers clone() {
        return SerialClone.clone(this);
    }
}
