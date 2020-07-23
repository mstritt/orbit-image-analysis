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

package com.actelion.research.orbit.imageAnalysis.deeplearning.DeepLabV2Resnet101;

import com.actelion.research.orbit.imageAnalysis.deeplearning.AbstractDetections;
import com.actelion.research.orbit.imageAnalysis.models.PolygonExt;
import com.actelion.research.orbit.imageAnalysis.models.RectangleExt;

import java.awt.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class DLR101Detections extends AbstractDetections<DLR101Detection> {

    private long[] result;

    public DLR101Detections() {
        super();
    }

    public DLR101Detections(long[] mask) {
        super();
        this.setRawDetections(mask);
    }

    protected void setRawDetections(long[] result) {
        this.result = result;
    }

    public long[] getResult() {
        return result;
    }

    @Override
    public List<DLR101Detection> getDetections() {
        return this.detections
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public void addDetection(PolygonExt contour, RectangleExt boundingBox, Float classProbability, Integer maskClass, Point tileOffset) {
        this.addDetection(contour, maskClass, tileOffset);
    }

    public void addDetection(PolygonExt contour,  Integer detectionClass, Point tileOffset) {
        this.detections.add(new DLR101Detection(contour, detectionClass, tileOffset));
    }
}