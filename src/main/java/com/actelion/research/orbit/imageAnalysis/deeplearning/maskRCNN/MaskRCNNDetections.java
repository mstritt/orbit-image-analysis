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

package com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN;

import com.actelion.research.orbit.imageAnalysis.deeplearning.AbstractDetections;
import com.actelion.research.orbit.imageAnalysis.models.PolygonExt;
import com.actelion.research.orbit.imageAnalysis.models.RectangleExt;

import java.awt.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class MaskRCNNDetections extends AbstractDetections<MaskRCNNDetection> {

    public void addDetection(PolygonExt contour, RectangleExt boundingBox, Float classProbability, Integer maskClass, Point tileOffset) {
        this.detections.add(new MaskRCNNDetection(contour, boundingBox, classProbability, maskClass, tileOffset));
    }

    public void addDetection(PolygonExt contour, RectangleExt boundingBox, Float classProbability) {
        this.detections.add(new MaskRCNNDetection(contour, boundingBox, classProbability));
    }

    public List<RectangleExt> getBoundingBoxes() {
        return this.detections
                .stream()
                .filter(Objects::nonNull)
                .map(e -> e.boundingBox)
                .collect(Collectors.toList());
    }

    @Override
    public List<MaskRCNNDetection> getDetections() {
        return this.detections
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public String toString() {
        return super.toString() +
        "Bounding Boxes: " +
                getBoundingBoxes().toString() + "\n";
    }
}