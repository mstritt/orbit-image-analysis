/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2016 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Bean for a ShapeList plus properties like name and color.
 */
public class ClassShape implements Serializable, Cloneable {

    private static final long serialVersionUID = 2L;
    public static final int SHAPETYPE_POLYGONEXT = 0;
    public static final int SHAPETYPE_ARC = 1;
    public static final int SHAPETYPE_RECTANGLE = 2;

    public static final String STR_UNDEFINED = "Undefined";
    public static final String STR_Inclusion = "Inclusion";
    public static final String STR_Exclusion = "Exclusion";

    public static final int UNDEFINED = 0;
    public static final int INCLUSION = 1;
    public static final int EXCLUSION = 2;

    private int incExcMode = UNDEFINED; // only used if model is used as an exclusion model
    private List<Shape> shapeList = new ArrayList<Shape>();
    private Color color = Color.white;
    private String name = "Class";
    private int shapeType = SHAPETYPE_POLYGONEXT;

    // features only used for old (obsolete) object count
    @Deprecated
    private int segmentationObjectSize = 12;
    @Deprecated
    private int segmentationMinimumSize = 1;
    @Deprecated
    private boolean kickTargetsLessThanMin = true;
    @Deprecated
    private boolean enableObjectCount = false; // obsolete
    @Deprecated
    private double mixtureTreshold = 0.1d;
    @Deprecated
    private boolean shapeDefinesCell = false;

    public ClassShape() {

    }

    public ClassShape(String name, Color color, int shapeType) {
        this.color = color;
        this.name = name;
        this.shapeType = shapeType;
        this.shapeList = new ArrayList<Shape>();
    }

    public ClassShape(String name, Color color, int shapeType, int incExclMode) {
        this.color = color;
        this.name = name;
        this.shapeType = shapeType;
        this.shapeList = new ArrayList<Shape>();
        this.incExcMode = incExclMode;
    }


    /**
     * scales all classShapes by a scale factor and returns the scaled shapes (used e.g. for exclusion model)
     *
     * @param shapes
     * @param factor
     * @return
     */
    public static List<ClassShape> scaleShapes(List<ClassShape> shapes, double factor) {
        List<ClassShape> classShapes = new ArrayList<ClassShape>(shapes.size());
        for (ClassShape csOld : shapes) {
            ClassShape cs = csOld.clone();
            List<Shape> shapeList = cs.getShapeList();
            for (int i = 0; i < shapeList.size(); i++) {
                Shape s = shapeList.get(i);
                if (s instanceof IScaleableShape) {
                    s = ((IScaleableShape) s).getScaledInstance(factor * 100d, new Point(0, 0));
                    ((IScaleableShape) s).setScale(100);
                    shapeList.set(i, s);
                }
            }
            classShapes.add(cs);
        }
        return classShapes;
    }


    public ClassShape clone() {
        return SerialClone.clone(this);
    }


    public String toString() {
        return "Class: " + getName() + " Color:(" + getColor().getRed() + "," + getColor().getGreen() + "," + getColor().getBlue() + ") IncExclMode:" + incExcMode;
    }

    /**
     * based on name,color,shapeType,incExclMode, bounds of first shape (before only name and color was relevant!)
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + shapeType;
        result = prime * result + incExcMode;
        if (shapeList != null && shapeList.size() > 0) {
            Rectangle re = shapeList.get(0).getBounds();
            if (re != null) {
                result = prime * result + shapeList.get(0).getBounds().hashCode();
            }
        }
        return result;
    }

    /**
     * based on name,color,shapeType,incExcMode,bounds of first shape (before only name and color was relevant!)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof ClassShape))
            return false;
        ClassShape other = (ClassShape) obj;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (shapeType != other.shapeType)
            return false;
        if (incExcMode != other.incExcMode)
            return false;
        if (shapeList != null && shapeList.size() > 0) {
            Rectangle re = shapeList.get(0).getBounds();
            if (re != null) {
                if (other.getShapeList() == null || other.getShapeList().size() == 0) return false;
                else {
                    Rectangle reOther = other.getShapeList().get(0).getBounds();
                    if (reOther == null) return false;
                    else {
                        if (re.hashCode() != reOther.hashCode()) return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Checks only name,color and incExcMode
     * @param o
     * @return
     */
    public boolean equalsSimple(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassShape that = (ClassShape) o;

        if (incExcMode != that.incExcMode) return false;
        if (shapeType != that.shapeType) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }


    public List<Shape> getShapeList() {
        return shapeList;
    }

    public void setShapeList(List<Shape> shapeList) {
        this.shapeList = shapeList;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShapeType() {
        return shapeType;
    }

    public void setShapeType(int shapeType) {
        this.shapeType = shapeType;
    }

    public int getIncExcMode() {
        return incExcMode;
    }

    public void setIncExcMode(int incExcMode) {
        this.incExcMode = incExcMode;
    }

    @Deprecated
    public int getSegmentationObjectSize() {
        return segmentationObjectSize;
    }

    @Deprecated
    public void setSegmentationObjectSize(int segmentationObjectSize) {
        this.segmentationObjectSize = segmentationObjectSize;
    }

    @Deprecated
    public int getSegmentationMinimumSize() {
        return segmentationMinimumSize;
    }

    @Deprecated
    public void setSegmentationMinimumSize(int segmentationMinimumSize) {
        this.segmentationMinimumSize = segmentationMinimumSize;
    }

    @Deprecated
    public boolean isKickTargetsLessThanMin() {
        return kickTargetsLessThanMin;
    }

    @Deprecated
    public void setKickTargetsLessThanMin(boolean kickTargetsLessThanMin) {
        this.kickTargetsLessThanMin = kickTargetsLessThanMin;
    }

    @Deprecated
    public boolean isEnableObjectCount() {
        return enableObjectCount;
    }

    @Deprecated
    public void setEnableObjectCount(boolean enableObjectCount) {
        this.enableObjectCount = enableObjectCount;
    }

    @Deprecated
    public double getMixtureTreshold() {
        return mixtureTreshold;
    }

    @Deprecated
    public void setMixtureTreshold(double mixtureTreshold) {
        this.mixtureTreshold = mixtureTreshold;
    }

    @Deprecated
    public boolean isShapeDefinesCell() {
        return shapeDefinesCell;
    }

    @Deprecated
    public void setShapeDefinesCell(boolean shapeDefinesCell) {
        this.shapeDefinesCell = shapeDefinesCell;
    }

    public static String getExclInclModeString(int mode) {
        switch (mode) {
            case UNDEFINED:
                return STR_UNDEFINED;
            case INCLUSION:
                return STR_Inclusion;
            case EXCLUSION:
                return STR_Exclusion;
            default:
                return STR_UNDEFINED;
        }
    }


}
