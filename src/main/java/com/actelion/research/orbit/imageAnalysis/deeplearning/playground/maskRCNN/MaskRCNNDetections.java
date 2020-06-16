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
    private List<PolygonExt> contours;
    private List<RectangleExt> boundingBoxes;
    private List<Float> probabilities;
    private List<Integer> maskClasses;

    public class Detection {
        private final PolygonExt contour;
        private final RectangleExt boundingBox;
        private final Float classProbability;
        private final Integer maskClass;

        private Detection(PolygonExt contour, RectangleExt boundingBox, Float classProbability, Integer maskClass) {
            this.contour = contour;
            this.boundingBox = boundingBox;
            this.classProbability = classProbability;
            this.maskClass = maskClass;
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

    }

    public List<PolygonExt> getContours() {
        return contours;
    }

    public void setContours(List<PolygonExt> contours) {
        this.contours = contours;
    }

    public List<Shape> getContourShapes() {
        return this.contours
                .stream()
                .map(e -> (Shape) e)
                .collect(Collectors.toList());
    }

    public List<Integer> getMaskClasses() { return maskClasses; }

    public void setMaskClasses(List<Integer> classes) {
        this.maskClasses = classes;
    }

    public List<RectangleExt> getBoundingBoxes() {
        return boundingBoxes;
    }

    public void setBoundingBoxes(List<RectangleExt> boundingBoxes) {
        this.boundingBoxes = boundingBoxes;
    }

    public List<Float> getProbabilities() {
        return probabilities;
    }

    public void setProbabilities(List<Float> probabilities) {
        this.probabilities = probabilities;
    }

    public Detection getDetection(int i) {
        // TODO: e.g. contours may not always be defined.
        return new Detection(contours.get(i), boundingBoxes.get(i), probabilities.get(i), maskClasses.get(i));
    }

    public List<Detection> getDetections() {
        ArrayList<Detection> detections = new ArrayList<>();
        for (int i = 0; i < boundingBoxes.size(); i++) {
            detections.add(new Detection(contours.get(i), boundingBoxes.get(i), probabilities.get(i), maskClasses.get(i)));
        }
        return detections;
    }

    public String toString() {

        return "Detections Object Details: " +
                "\n" +
                "Contours: " +
                contours.toString() +
                "\n" +
                "Bounding Boxes: " +
                boundingBoxes.toString() +
                "\n" +
                "Probabilities: " +
                probabilities.toString() +
                "\n" +
                "Mask Classes: " +
                maskClasses.toString() +
                "\n";
    }
}