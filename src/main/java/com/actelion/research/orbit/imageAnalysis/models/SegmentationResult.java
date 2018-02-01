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

import java.awt.*;
import java.io.Serializable;
import java.util.List;

public class SegmentationResult implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<String> header;
    private List<Shape> shapeList;
    private List<Shape> secondaryShapeList;
    private List<double[]> featureList;
    private int objectCount = 0;
    private int secondaryObjectCount = 0;
    private OrbitModel model;

    /**
     * Attention: this sets all properties to null!
     */
    public SegmentationResult() {
        header = null;
        shapeList = null;
        featureList = null;
        objectCount = 0;
        secondaryObjectCount = 0;
    }

    public SegmentationResult(int objectCount, int secondaryObjectCount, List<String> header, List<Shape> shapeList, List<double[]> featureList) {
        this.header = header;
        this.shapeList = shapeList;
        this.featureList = featureList;
        this.objectCount = objectCount;
        this.secondaryObjectCount = secondaryObjectCount;
    }

    public SegmentationResult(int objectCount, int secondaryObjectCount, List<Shape> shapeList, List<double[]> featureList) {
        this.shapeList = shapeList;
        this.featureList = featureList;
        this.objectCount = objectCount; // was always 0 before 24.4.2015
        this.secondaryObjectCount = secondaryObjectCount;
    }

    /**
     * constructor used by SegmentationMapReduce
     */
    public SegmentationResult(int objectCount, int secondaryObjectCount, OrbitModel model) {
        this.objectCount = objectCount;
        this.secondaryObjectCount = secondaryObjectCount;
        this.model = model;
    }

    public List<String> getHeader() {
        return header;
    }

    public void setHeader(List<String> header) {
        this.header = header;
    }

    public List<Shape> getShapeList() {
        return shapeList;
    }

    public void setShapeList(List<Shape> shapeList) {
        this.shapeList = shapeList;
    }

    public List<double[]> getFeatureList() {
        return featureList;
    }

    public void setFeatureList(List<double[]> featureList) {
        this.featureList = featureList;
    }

    public int getObjectCount() {
        return objectCount;
    }

    public void setObjectCount(int objectCount) {
        this.objectCount = objectCount;
    }

    public int getSecondaryObjectCount() {
        return secondaryObjectCount;
    }

    public void setSecondaryObjectCount(int secondaryObjectCount) {
        this.secondaryObjectCount = secondaryObjectCount;
    }

    public OrbitModel getModel() {
        return model;
    }

    public void setModel(OrbitModel model) {
        this.model = model;
    }

    public List<Shape> getSecondaryShapeList() {
        return secondaryShapeList;
    }

    public void setSecondaryShapeList(List<Shape> secondaryShapeList) {
        this.secondaryShapeList = secondaryShapeList;
    }
}
