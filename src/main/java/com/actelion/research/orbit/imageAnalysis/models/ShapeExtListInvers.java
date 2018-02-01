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

import com.freedomotic.util.SerialClone.SerialClone;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class ShapeExtListInvers implements IScaleableShape {
    private static final long serialVersionUID = 1L;
    private Rectangle outerBounds = null;
    private List<Shape> shapeList = new ArrayList<Shape>();
    private Shape roi = null;
    private boolean inverse = false;
    private int rdfId = 0;


    public ShapeExtListInvers(Rectangle outerBounds) {
        this.outerBounds = outerBounds;
        inverse = false;
    }

    /**
     * ROI with exclusion of Shapes and definition of outer ROI. Use ShapeExt objects with scale at 100%!
     *
     * @param pList
     * @param outerBounds
     */
    public ShapeExtListInvers(Shape roi, List<Shape> pList, Rectangle outerBounds) {
        this(pList, outerBounds);
        this.roi = roi;
        if (roi != null)
            this.outerBounds = roi.getBounds();
    }

    /**
     * ROI with exclusion of Shapes. Use ShapeExt objects with scale at 100%!
     *
     * @param pList
     * @param outerBounds
     */
    public ShapeExtListInvers(List<Shape> pList, Rectangle outerBounds) {
        this.shapeList = pList;
        this.outerBounds = outerBounds;
        inverse = false;
    }

    public IScaleableShape getScaledInstance(double currentScale, Point currentOffset) {
        return this; // this pseudo ROI is always 100%
    }

    public void move(double dx, double dy) {
        for (Shape shape : shapeList) {
            if (shape instanceof IScaleableShape) {
                ((IScaleableShape) shape).move(dx, dy);
            }
        }
        if (roi != null && roi instanceof IScaleableShape) {
            ((IScaleableShape) roi).move(dx, dy);
            this.outerBounds = roi.getBounds();
        }
    }

    public void rotate(double angle, Point2D rotCenter) {
        for (Shape shape : shapeList) {
            if (shape instanceof IScaleableShape) {
                ((IScaleableShape) shape).rotate(angle, rotCenter);
            }
        }
        if (roi != null && roi instanceof IScaleableShape) {
            ((IScaleableShape) roi).rotate(angle, rotCenter);
            this.outerBounds = roi.getBounds();
        }
    }

    public boolean contains(Point2D paramPoint2D) {
        if (roi != null && !roi.contains(paramPoint2D)) return false;
        for (Shape p : shapeList) {
            if (p.contains(paramPoint2D)) return false;
        }
        return true;
    }

    public boolean contains(Rectangle2D paramRectangle2D) {
        if (roi != null && !roi.contains(paramRectangle2D)) return false;
        for (Shape p : shapeList) {
            if (p.contains(paramRectangle2D)) return false;
        }
        return true;
    }


    public boolean contains(int x, int y) {
        if (roi != null && !roi.contains(x, y)) return false;
        for (Shape p : shapeList) {
            if (p.contains(x, y)) return false;
        }
        return true;
    }

    public boolean contains(Point point) {
        if (roi != null && !roi.contains(point)) return false;
        for (Shape p : shapeList) {
            if (p.contains(point)) return false;
        }
        return true;
    }

    public boolean contains(double x, double y) {
        if (roi != null && !roi.contains(x, y)) return false;
        for (Shape p : shapeList) {
            if (p.contains(x, y)) return false;
        }
        return true;
    }

    public boolean contains(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
        if (roi != null && !roi.contains(paramDouble1, paramDouble2, paramDouble3, paramDouble4)) return false;
        for (Shape p : shapeList) {
            if (p.contains(paramDouble1, paramDouble2, paramDouble3, paramDouble4)) return false;
        }
        return true;
    }

    public boolean intersects(Rectangle2D paramRectangle2D) {
        if (roi != null) return roi.intersects(paramRectangle2D);
        return true;
    }

    public boolean intersects(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
        if (roi != null) return roi.intersects(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
        return true;
    }

    public Rectangle getBounds() {
        if (roi != null) return roi.getBounds();
        return outerBounds;
    }

    public Rectangle2D getBounds2D() {
        if (roi != null) return roi.getBounds2D();
        return outerBounds;
    }

    @Override
    public String toString() {
        String shapeCount = "null";
        if (shapeList != null) shapeCount = shapeList.size() + "";
        return "ShapeExtListInvers with " + shapeCount + " Shapes and roi=" + roi;
    }

    public PathIterator getPathIterator(AffineTransform at) {
        return outerBounds.getPathIterator(at);
    }

    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return outerBounds.getPathIterator(at, flatness);
    }

    public double getScale() {
        return 100d;
    }

    public void setScale(double scale) {

    }

    @Override
    public ShapeExtListInvers clone() {
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
