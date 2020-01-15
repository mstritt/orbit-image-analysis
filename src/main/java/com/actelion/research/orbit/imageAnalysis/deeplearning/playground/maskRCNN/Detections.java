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

import java.util.List;


public class Detections {
    private List<PolygonExt> contours;
    private List<RectangleExt> boundingBoxes;
    private List<Float> probabilities;

    public List<PolygonExt> getContours() {
        return contours;
    }

    public void setContours(List<PolygonExt> contours) {
        this.contours = contours;
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
}