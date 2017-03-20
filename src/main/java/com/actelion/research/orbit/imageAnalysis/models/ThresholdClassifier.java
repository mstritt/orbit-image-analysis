/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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

import weka.classifiers.AbstractClassifier;
import weka.core.Instance;
import weka.core.Instances;

public class ThresholdClassifier extends AbstractClassifier {

    private static final long serialVersionUID = 1L;
    private double[] mins = null;
    private double[] maxs = null;

    public ThresholdClassifier() {
    }

    public ThresholdClassifier(double[] mins, double[] maxs) {
        if (mins == null || maxs == null) throw new IllegalArgumentException("mins and maxs must not be null");
        if (mins.length != maxs.length) throw new IllegalArgumentException("mins.length != maxs.length");
        this.mins = mins;
        this.maxs = maxs;
    }


    public void buildClassifier(Instances data) throws Exception {
        // do nothing
    }

    @Override
    public double classifyInstance(Instance instance) throws Exception {
        if (instance == null) throw new IllegalArgumentException("instance cannot be null");
        //System.out.println(threshs.length+" threshs: "+ Arrays.toString(threshs));
        //System.out.println(instance.numAttributes()+" attributes: "+ Arrays.toString(instance.toDoubleArray()));

        if (mins == null || ((instance.numAttributes() - 1) != mins.length))
            throw new IllegalStateException("thresholds length is not equal to feature length (mins=" + ((mins == null) ? "null" : mins.length) + " attributes-1=" + (instance.numAttributes() - 1) + ")");

        int yes = 0, no = 0;
        for (int a = 0; a < instance.numAttributes() - 1; a++) {  // -1 because last attribute is (missing) class value
            if (Double.isNaN(mins[a]) || Double.isNaN(maxs[a])) continue; // NaN means this dimension should be ignored
            if (instance.value(a) >= mins[a] && instance.value(a) <= maxs[a]) yes++;
            else no++;
        }
        if (yes > no) return 1;
        else return 0; // majority vote
    }

    public double[] getMins() {
        return mins;
    }

    public void setMins(double[] mins) {
        this.mins = mins;
    }

    public double[] getMaxs() {
        return maxs;
    }

    public void setMaxs(double[] maxs) {
        this.maxs = maxs;
    }


}
