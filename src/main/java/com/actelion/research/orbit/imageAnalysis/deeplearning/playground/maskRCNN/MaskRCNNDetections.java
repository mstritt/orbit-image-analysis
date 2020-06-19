/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2020 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
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

package com.actelion.research.orbit.imageAnalysis.deeplearning.playground.maskRCNN;

import com.actelion.research.orbit.imageAnalysis.models.PolygonExt;
import com.actelion.research.orbit.imageAnalysis.models.RectangleExt;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class MaskRCNNDetections {
    private final List<Detection> detections;

    public MaskRCNNDetections() {
        this.detections = new ArrayList<>();
    }

    public void addDetection(PolygonExt contour, RectangleExt boundingBox, Float classProbability, Integer maskClass, Point tileOffset) {
        this.detections.add(new Detection(contour, boundingBox, classProbability, maskClass, tileOffset));
    }

    public void addDetection(PolygonExt contour, RectangleExt boundingBox, Float classProbability) {
        this.detections.add(new Detection(contour, boundingBox, classProbability));
    }

    public List<PolygonExt> getContours() {
        return this.detections
                .stream()
                .map(e -> e.contour)
                .collect(Collectors.toList());
    }


    public List<Shape> getContourShapes() {
        return this.detections
                .stream()
                .map(e -> (Shape) e.contour)
                .collect(Collectors.toList());
    }

    public List<Integer> getMaskClasses() {
        return this.detections
                .stream()
                .map(e -> e.maskClass)
                .collect(Collectors.toList());
    }

    public List<RectangleExt> getBoundingBoxes() {
        return this.detections
                .stream()
                .map(e -> e.boundingBox)
                .collect(Collectors.toList());
    }


    public List<Float> getProbabilities() {
        return this.detections
                .stream()
                .map(e -> e.classProbability)
                .collect(Collectors.toList());
    }


    public List<Point> getTileOffset() {
        return this.detections
                .stream()
                .map(e -> e.tileOffset)
                .collect(Collectors.toList());
    }

    public Detection getDetection(int i) {
        // TODO: e.g. contours may not always be defined.
        return detections.get(i);
    }

    public List<Detection> getDetections() {
        return detections;
    }

    public String toString() {

        return "Detections Object Details: " +
                "\n" +
                "Contours: " +
                getContours().toString() +
                "\n" +
                "Bounding Boxes: " +
                getBoundingBoxes().toString() +
                "\n" +
                "Probabilities: " +
                getProbabilities().toString() +
                "\n" +
                "Mask Classes: " +
                getMaskClasses().toString() +
                "\n";
    }

    public class Detection {
        private final PolygonExt contour;
        private final RectangleExt boundingBox;
        private final Float classProbability;
        private final Integer maskClass;
        private final Point tileOffset;

        private Detection(PolygonExt contour, RectangleExt boundingBox, Float classProbability, Integer maskClass, Point tileOffset) {
            this.contour = contour;
            this.boundingBox = boundingBox;
            this.classProbability = classProbability;
            this.maskClass = maskClass;
            this.tileOffset = tileOffset;
        }

        private Detection(PolygonExt contour, RectangleExt boundingBox, Float classProbability) {
            this(contour, boundingBox, classProbability, null, null);
        }

        public PolygonExt getContour() {
            return contour;
        }

        public Shape getContourShape() { return contour; }

        public RectangleExt getBoundingBox() {
            return boundingBox;
        }

        public Float getClassProbability() {
            return classProbability;
        }

        public Integer getMaskClass() {
            return maskClass;
        }

        public Point getTileOffset() { return tileOffset; }

    }
}