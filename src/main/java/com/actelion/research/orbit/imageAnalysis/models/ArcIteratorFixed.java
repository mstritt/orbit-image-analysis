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

package com.actelion.research.orbit.imageAnalysis.models;

import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.util.NoSuchElementException;

class ArcIteratorFixed
        implements PathIterator {
    double x;
    double y;
    double w;
    double h;
    double angStRad;
    double increment;
    double cv;
    AffineTransform affine;
    int index;
    int arcSegs;
    int lineSegs;

    public ArcIteratorFixed(Arc2DFixed paramArc2D, AffineTransform paramAffineTransform) {
        this.w = (paramArc2D.getWidth() / 2.0D);
        this.h = (paramArc2D.getHeight() / 2.0D);
        this.x = (paramArc2D.getX() + this.w);
        this.y = (paramArc2D.getY() + this.h);
        this.angStRad = (-Math.toRadians(paramArc2D.getAngleStart()));
        this.affine = paramAffineTransform;
        double d = -paramArc2D.getAngleExtent();
        if ((d >= 360.0D) || (d <= -360.0D)) {
            this.arcSegs = 4;
            this.increment = 1.570796326794897D;
            this.cv = 0.5522847498307933D;
            if (d < 0.0D) {
                this.increment = (-this.increment);
                this.cv = (-this.cv);
            }
        } else {
            this.arcSegs = (int) Math.ceil(Math.abs(d) / 90.0D);
            this.increment = Math.toRadians(d / this.arcSegs);
            this.cv = btan(this.increment);
            if (this.cv == 0.0D)
                this.arcSegs = 0;
        }
        switch (paramArc2D.getArcType()) {
            case 0:
                this.lineSegs = 0;
                break;
            case 1:
                this.lineSegs = 1;
                break;
            case 2:
                this.lineSegs = 2;
        }
        if ((this.w >= 0.0D) && (this.h >= 0.0D))
            return;
        this.arcSegs = (this.lineSegs = -1);
    }

    public int getWindingRule() {
        return 1;
    }

    public boolean isDone() {
        return (this.index > this.arcSegs + this.lineSegs);
    }

    public void next() {
        this.index += 1;
    }

    private static double btan(double paramDouble) {
        paramDouble /= 2.0D;
        return (1.333333333333333D * Math.sin(paramDouble) / (1.0D + Math.cos(paramDouble)));
    }

    public int currentSegment(float[] paramArrayOfFloat) {
        if (isDone())
            throw new NoSuchElementException("arc iterator out of bounds");
        double d1 = this.angStRad;
        if (this.index == 0) {
            paramArrayOfFloat[0] = (float) (this.x + Math.cos(d1) * this.w);
            paramArrayOfFloat[1] = (float) (this.y + Math.sin(d1) * this.h);
            if (this.affine != null)
                this.affine.transform(paramArrayOfFloat, 0, paramArrayOfFloat, 0, 1);
            return 0;
        }
        if (this.index > this.arcSegs) {
            if (this.index == this.arcSegs + this.lineSegs)
                return 4;
            paramArrayOfFloat[0] = (float) this.x;
            paramArrayOfFloat[1] = (float) this.y;
            if (this.affine != null)
                this.affine.transform(paramArrayOfFloat, 0, paramArrayOfFloat, 0, 1);
            return 1;
        }
        d1 += this.increment * (this.index - 1);
        double d2 = Math.cos(d1);
        double d3 = Math.sin(d1);
        paramArrayOfFloat[0] = (float) (this.x + (d2 - (this.cv * d3)) * this.w);
        paramArrayOfFloat[1] = (float) (this.y + (d3 + this.cv * d2) * this.h);
        d1 += this.increment;
        d2 = Math.cos(d1);
        d3 = Math.sin(d1);
        paramArrayOfFloat[2] = (float) (this.x + (d2 + this.cv * d3) * this.w);
        paramArrayOfFloat[3] = (float) (this.y + (d3 - (this.cv * d2)) * this.h);
        paramArrayOfFloat[4] = (float) (this.x + d2 * this.w);
        paramArrayOfFloat[5] = (float) (this.y + d3 * this.h);
        if (this.affine != null)
            this.affine.transform(paramArrayOfFloat, 0, paramArrayOfFloat, 0, 3);
        return 3;
    }

    public int currentSegment(double[] paramArrayOfDouble) {
        if (isDone())
            throw new NoSuchElementException("arc iterator out of bounds");
        double d1 = this.angStRad;
        if (this.index == 0) {
            paramArrayOfDouble[0] = (this.x + Math.cos(d1) * this.w);
            paramArrayOfDouble[1] = (this.y + Math.sin(d1) * this.h);
            if (this.affine != null)
                this.affine.transform(paramArrayOfDouble, 0, paramArrayOfDouble, 0, 1);
            return 0;
        }
        if (this.index > this.arcSegs) {
            if (this.index == this.arcSegs + this.lineSegs)
                return 4;
            paramArrayOfDouble[0] = this.x;
            paramArrayOfDouble[1] = this.y;
            if (this.affine != null)
                this.affine.transform(paramArrayOfDouble, 0, paramArrayOfDouble, 0, 1);
            return 1;
        }
        d1 += this.increment * (this.index - 1);
        double d2 = Math.cos(d1);
        double d3 = Math.sin(d1);
        paramArrayOfDouble[0] = (this.x + (d2 - (this.cv * d3)) * this.w);
        paramArrayOfDouble[1] = (this.y + (d3 + this.cv * d2) * this.h);
        d1 += this.increment;
        d2 = Math.cos(d1);
        d3 = Math.sin(d1);
        paramArrayOfDouble[2] = (this.x + (d2 + this.cv * d3) * this.w);
        paramArrayOfDouble[3] = (this.y + (d3 - (this.cv * d2)) * this.h);
        paramArrayOfDouble[4] = (this.x + d2 * this.w);
        paramArrayOfDouble[5] = (this.y + d3 * this.h);
        if (this.affine != null)
            this.affine.transform(paramArrayOfDouble, 0, paramArrayOfDouble, 0, 3);
        return 3;
    }
}
