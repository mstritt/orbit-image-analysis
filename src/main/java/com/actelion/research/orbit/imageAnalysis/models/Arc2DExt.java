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

package com.actelion.research.orbit.imageAnalysis.models;

import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.freedomotic.util.SerialClone.SerialClone;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;


public class Arc2DExt extends Arc2DFixed.Double implements IScaleableShape {

    private static final long serialVersionUID = 2L;
    private double scale = 100.0d;
    private transient Arc2DExt scaledInstance = null;
    private int rdfId = 0;

    public Arc2DExt() {
        super();
    }

    public Arc2DExt(int type) {
        super(type);
    }

    public Arc2DExt(Rectangle2D ellipseBounds, double start, double extent, int type) {
        super(ellipseBounds, start, extent, type);
    }

    public Arc2DExt(double x, double y, double w, double h, double start, double extent, int type) {
        super(x, y, w, h, start, extent, type);
    }

    /**
     * 0..100
     */
    public Arc2DExt getScaledInstance(double currentScale, Point currentOffset) {
        if (Math.abs(scale - currentScale) <= OrbitUtils.EPSILON) return this;
        if ((scaledInstance != null) && (Math.abs(scaledInstance.getScale() - currentScale) <= OrbitUtils.EPSILON)) {
            return scaledInstance;
        }
        double scaleFactor = (currentScale / scale);
        Arc2DExt re = new Arc2DExt(x * scaleFactor, y * scaleFactor, width * scaleFactor, height * scaleFactor, start, extent, getArcType());

        re.setScale(currentScale);
        scaledInstance = re;
        return re;
    }

    public void move(double dx, double dy) {
        double scaleFactor = (100d / scale);
        double dxx = dx / scaleFactor;
        double dyy = dy / scaleFactor;
        x += dxx;
        y += dyy;
        scaledInstance = null;
    }

    public void rotate(double angle, Point2D center) {
        double tx = x;
        double ty = y;
        x = center.getX() + (Math.cos(Math.toRadians(angle)) * (tx - center.getX()) - Math.sin(Math.toRadians(angle)) * (ty - center.getY()));
        y = center.getY() + (Math.sin(Math.toRadians(angle)) * (tx - center.getX()) + Math.cos(Math.toRadians(angle)) * (ty - center.getY()));
        scaledInstance = null;
    }

    /**
     * 0..100
     */
    public double getScale() {
        return scale;
    }

    /**
     * 0..100
     */
    public void setScale(double scale) {
        this.scale = scale;
    }

    @Override
    public Arc2DExt clone() {
        return SerialClone.clone(this);
    }

    @Override
    public int getRdfId() {
        return rdfId;
    }

    @Override
    public void setRdfId(int rdfId) {
        this.rdfId = rdfId;
    }
}
