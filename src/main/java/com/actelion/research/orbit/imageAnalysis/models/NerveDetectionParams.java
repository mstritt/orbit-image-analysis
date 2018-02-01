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

import java.io.Serializable;

public class NerveDetectionParams implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean fluoImage = false;
    private int segmentLengthSingle = 15;
    private int segmentLengthMerged = 30;
    private int segmentDistanceMerge = 10;
    private float gamma = 0.65f;
    private float unsharpMaskThrethold1 = 10f;
    private float unsharpMaskThrethold2 = 0.7f;
    private float edgeDetectionthreshold1 = 100;
    private float edgeDetectionthreshold2 = 55;
    private boolean onlyJunctionCrossings = true;
    private double junctionCrossingDistance = 30;

    public NerveDetectionParams() {

    }

    public NerveDetectionParams(boolean fluoImage, int segmentLengthSingle, int segmentLengthMerged, int segmentDistanceMerge, float gamma, float unsharpMaskThrethold1,
                                float unsharpMaskThrethold2, float edgeDetectionthreshold1, float edgeDetectionthreshold2, boolean onlyJunctionCrossings,
                                double junctionCrossingDistance) {
        this.fluoImage = fluoImage;
        this.segmentLengthSingle = segmentLengthSingle;
        this.segmentLengthMerged = segmentLengthMerged;
        this.segmentDistanceMerge = segmentDistanceMerge;
        this.gamma = gamma;
        this.unsharpMaskThrethold1 = unsharpMaskThrethold1;
        this.unsharpMaskThrethold2 = unsharpMaskThrethold2;
        this.edgeDetectionthreshold1 = edgeDetectionthreshold1;
        this.edgeDetectionthreshold2 = edgeDetectionthreshold2;
        this.onlyJunctionCrossings = onlyJunctionCrossings;
        this.junctionCrossingDistance = junctionCrossingDistance;
    }


    @Override
    public String toString() {
        return "NerveDetectionParams{" +
                "fluoImage=" + fluoImage +
                ", segmentLengthSingle=" + segmentLengthSingle +
                ", segmentLengthMerged=" + segmentLengthMerged +
                ", segmentDistanceMerge=" + segmentDistanceMerge +
                ", gamma=" + gamma +
                ", unsharpMaskThrethold1=" + unsharpMaskThrethold1 +
                ", unsharpMaskThrethold2=" + unsharpMaskThrethold2 +
                ", edgeDetectionthreshold1=" + edgeDetectionthreshold1 +
                ", edgeDetectionthreshold2=" + edgeDetectionthreshold2 +
                ", onlyJunctionCrossings=" + onlyJunctionCrossings +
                ", junctionCrossingDistance=" + junctionCrossingDistance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NerveDetectionParams that = (NerveDetectionParams) o;

        if (Float.compare(that.edgeDetectionthreshold1, edgeDetectionthreshold1) != 0) return false;
        if (Float.compare(that.edgeDetectionthreshold2, edgeDetectionthreshold2) != 0) return false;
        if (fluoImage != that.fluoImage) return false;
        if (Float.compare(that.gamma, gamma) != 0) return false;
        if (Double.compare(that.junctionCrossingDistance, junctionCrossingDistance) != 0) return false;
        if (onlyJunctionCrossings != that.onlyJunctionCrossings) return false;
        if (segmentDistanceMerge != that.segmentDistanceMerge) return false;
        if (segmentLengthMerged != that.segmentLengthMerged) return false;
        if (segmentLengthSingle != that.segmentLengthSingle) return false;
        if (Float.compare(that.unsharpMaskThrethold1, unsharpMaskThrethold1) != 0) return false;
        return Float.compare(that.unsharpMaskThrethold2, unsharpMaskThrethold2) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (fluoImage ? 1 : 0);
        result = 31 * result + segmentLengthSingle;
        result = 31 * result + segmentLengthMerged;
        result = 31 * result + segmentDistanceMerge;
        result = 31 * result + (gamma != +0.0f ? Float.floatToIntBits(gamma) : 0);
        result = 31 * result + (unsharpMaskThrethold1 != +0.0f ? Float.floatToIntBits(unsharpMaskThrethold1) : 0);
        result = 31 * result + (unsharpMaskThrethold2 != +0.0f ? Float.floatToIntBits(unsharpMaskThrethold2) : 0);
        result = 31 * result + (edgeDetectionthreshold1 != +0.0f ? Float.floatToIntBits(edgeDetectionthreshold1) : 0);
        result = 31 * result + (edgeDetectionthreshold2 != +0.0f ? Float.floatToIntBits(edgeDetectionthreshold2) : 0);
        result = 31 * result + (onlyJunctionCrossings ? 1 : 0);
        temp = Double.doubleToLongBits(junctionCrossingDistance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public int getSegmentLengthSingle() {
        return segmentLengthSingle;
    }

    public void setSegmentLengthSingle(int segmentLengthSingle) {
        this.segmentLengthSingle = segmentLengthSingle;
    }

    public int getSegmentLengthMerged() {
        return segmentLengthMerged;
    }

    public void setSegmentLengthMerged(int segmentLengthMerged) {
        this.segmentLengthMerged = segmentLengthMerged;
    }

    public int getSegmentDistanceMerge() {
        return segmentDistanceMerge;
    }

    public void setSegmentDistanceMerge(int segmentDistanceMerge) {
        this.segmentDistanceMerge = segmentDistanceMerge;
    }

    public float getGamma() {
        return gamma;
    }

    public void setGamma(float gamma) {
        this.gamma = gamma;
    }

    public float getUnsharpMaskThrethold1() {
        return unsharpMaskThrethold1;
    }

    public void setUnsharpMaskThrethold1(float unsharpMaskThrethold1) {
        this.unsharpMaskThrethold1 = unsharpMaskThrethold1;
    }

    public float getUnsharpMaskThrethold2() {
        return unsharpMaskThrethold2;
    }

    public void setUnsharpMaskThrethold2(float unsharpMaskThrethold2) {
        this.unsharpMaskThrethold2 = unsharpMaskThrethold2;
    }

    public float getEdgeDetectionthreshold1() {
        return edgeDetectionthreshold1;
    }

    public void setEdgeDetectionthreshold1(float edgeDetectionthreshold1) {
        this.edgeDetectionthreshold1 = edgeDetectionthreshold1;
    }

    public float getEdgeDetectionthreshold2() {
        return edgeDetectionthreshold2;
    }

    public void setEdgeDetectionthreshold2(float edgeDetectionthreshold2) {
        this.edgeDetectionthreshold2 = edgeDetectionthreshold2;
    }

    public boolean isOnlyJunctionCrossings() {
        return onlyJunctionCrossings;
    }

    public void setOnlyJunctionCrossings(boolean onlyJunctionCrossings) {
        this.onlyJunctionCrossings = onlyJunctionCrossings;
    }

    public double getJunctionCrossingDistance() {
        return junctionCrossingDistance;
    }

    public void setJunctionCrossingDistance(double junctionCrossingDistance) {
        this.junctionCrossingDistance = junctionCrossingDistance;
    }

    public boolean isFluoImage() {
        return fluoImage;
    }

    public void setFluoImage(boolean fluoImage) {
        this.fluoImage = fluoImage;
    }


}
