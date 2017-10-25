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

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class ShapeExtListWithExclusions extends ShapeExtList {

    private IScaleableShape exclShape;


    /**
     * ROI with junction of Shapes in combination with a negative shape. Use ShapeExt objects with scale at 100%!
     *
     * @param pList
     * @param outerBounds
     */
    public ShapeExtListWithExclusions(List<Shape> pList, IScaleableShape exclShape, Rectangle outerBounds) {
        super(pList, outerBounds);
        this.exclShape = exclShape;
    }

    @Override
    public boolean contains(double x, double y) {
        if (exclShape.contains(x, y)) return false;
        else return super.contains(x, y);
    }

    @Override
    public boolean contains(int x, int y) {
        if (exclShape.contains(x, y)) return false;
        else return super.contains(x, y);
    }

    @Override
    public boolean contains(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
        if (exclShape.contains(paramDouble1, paramDouble2, paramDouble3, paramDouble4)) return false;
        else return super.contains(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
    }

    @Override
    public boolean contains(Point2D paramPoint2D) {
        if (exclShape.contains(paramPoint2D)) return false;
        else return super.contains(paramPoint2D);
    }

    @Override
    public boolean contains(Rectangle2D paramRectangle2D) {
        if (exclShape.contains(paramRectangle2D)) return false;
        else return super.contains(paramRectangle2D);
    }

    @Override
    public boolean contains(Point point) {
        if (exclShape.contains(point)) return false;
        else return super.contains(point);
    }

    @Override
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
        IScaleableShape exclShapeScaled = exclShape != null ? (IScaleableShape) exclShape.getScaledInstance(currentScale, currentOffset) : null;
        ShapeExtList shapeExtList = new ShapeExtListWithExclusions(newList, exclShapeScaled, null);
        shapeExtList.updateOuterbounds();
        scaledInstance = shapeExtList;
        scaledInstance.setScale(currentScale);
        return scaledInstance;
    }
}
