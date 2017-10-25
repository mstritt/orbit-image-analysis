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

import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.freedomotic.util.SerialClone.SerialClone;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class ShapeExtList implements IScaleableShape {
    private static final long serialVersionUID = 1L;
    protected Rectangle outerBounds = null;
    protected List<Shape> shapeList = new ArrayList<Shape>();
    protected double scale = 100d;
    protected transient ShapeExtList scaledInstance = null;
    private int rdfId = 0;


    /**
     * ROI with junction of Shapes. Use ShapeExt objects with scale at 100%!
     *
     * @param pList
     * @param outerBounds
     */
    public ShapeExtList(List<Shape> pList, Rectangle outerBounds) {
        this.shapeList = pList;
        this.outerBounds = outerBounds;
        updateOuterbounds();
    }

    protected void updateOuterbounds() {
        if (shapeList != null && shapeList.size() > 0) {
            Rectangle bounds = new Rectangle(shapeList.get(0).getBounds());
            for (Shape p : shapeList) {
                bounds = (Rectangle) p.getBounds().createUnion(bounds);
            }
            this.outerBounds = bounds;
        }
    }


    public IScaleableShape getScaledInstance(double currentScale, Point currentOffset) {
        //	return this; // this pseudo ROI is always 100%
        // disabled because not used. Enable for e.g. ExclusionMapGen with roi!

        if (Math.abs(scale - currentScale) <= OrbitUtils.EPSILON) return this;
        if ((scaledInstance != null) && (Math.abs(scaledInstance.getScale() - currentScale) <= OrbitUtils.EPSILON)) {
            return scaledInstance;
        }

        List<Shape> newList = new ArrayList<Shape>(shapeList.size());
        for (Shape s : shapeList) {
            Shape scaled = s;
            if (scaled instanceof IScaleableShape) {
                scaled = ((IScaleableShape) s).getScaledInstance(currentScale, currentOffset);
            }
            newList.add(scaled);
        }
        ShapeExtList shapeExtList = new ShapeExtList(newList, null);
        shapeExtList.updateOuterbounds();
        scaledInstance = shapeExtList;
        scaledInstance.setScale(currentScale);
        return scaledInstance;
    }

    public void move(double dx, double dy) {
        for (Shape shape : shapeList) {
            if (shape instanceof IScaleableShape) {
                ((IScaleableShape) shape).move(dx, dy);
            }
        }
        updateOuterbounds();
    }

    public void rotate(double angle, Point2D rotCenter) {
        for (Shape shape : shapeList) {
            if (shape instanceof IScaleableShape) {
                ((IScaleableShape) shape).rotate(angle, rotCenter);
            }
        }
        updateOuterbounds();
    }

    public boolean contains(Point2D paramPoint2D) {
        for (Shape p : shapeList) {
            if (p.contains(paramPoint2D)) return true;
        }
        return false;
    }

    public boolean contains(Rectangle2D paramRectangle2D) {
        for (Shape p : shapeList) {
            if (p.contains(paramRectangle2D)) return true;
        }
        return false;
    }


    public boolean contains(int x, int y) {
        for (Shape p : shapeList) {
            if (p.contains(x, y)) return true;
        }
        return false;
    }

    public boolean contains(Point point) {
        for (Shape p : shapeList) {
            if (p.contains(point)) return true;
        }
        return false;
    }

    public boolean contains(double x, double y) {
        for (Shape p : shapeList) {
            if (p.contains(x, y)) return true;
        }
        return false;
    }

    public boolean contains(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
        for (Shape p : shapeList) {
            if (p.contains(paramDouble1, paramDouble2, paramDouble3, paramDouble4)) return true;
        }
        return false;
    }

    public boolean intersects(Rectangle2D paramRectangle2D) {
        for (Shape p : shapeList) {
            if (p.intersects(paramRectangle2D)) return true;
        }
        return false;
        //return outerBounds.intersects(paramRectangle2D);
        //return true;
    }

    public boolean intersects(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
        for (Shape p : shapeList) {
            if (p.intersects(paramDouble1, paramDouble2, paramDouble3, paramDouble4)) return true;
        }
        return false;
        //return outerBounds.intersects(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
        //return true;
    }

    public Rectangle getBounds() {
        return outerBounds;
    }

    public Rectangle2D getBounds2D() {
        return outerBounds;
    }

    @Override
    public String toString() {
        String shapeCount = "null";
        if (shapeList != null) shapeCount = shapeList.size() + "";
        return "ShapeExtList with " + shapeCount + " Shapes";
    }

    public PathIterator getPathIterator(AffineTransform at) {
        return outerBounds.getPathIterator(at);
    }

    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return outerBounds.getPathIterator(at, flatness);
    }

    public double getScale() {
        return this.scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
        for (Shape shape : shapeList) {
            if (shape instanceof IScaleableShape) {
                ((IScaleableShape) shape).setScale(scale);
            }
        }
    }

    public List<Shape> getShapeList() {
        return shapeList;
    }

    @Override
    public ShapeExtList clone() {
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
