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

package com.actelion.research.orbit.imageAnalysis.tasks.histogram;

import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;

import java.io.Serializable;
import java.util.Arrays;

public class Histogram implements Serializable {

    public static final int numBins = 256;
    private OrbitModel model;
    private long[] bins = new long[numBins];

    public Histogram(OrbitModel model) {
        this.model = model;
    }

    public void inc(int bin) {
        if (bin >= numBins)
            throw new IllegalArgumentException("cannot increment bin " + bin + " because this histogram has only " + numBins + " bins.");
        bins[bin]++;
    }

    public void add(Histogram histogram) {
        if (numBins != histogram.getBins().length)
            throw new IllegalArgumentException("Histogram dimensions don't match.");
        for (int i = 0; i < numBins; i++) {
            bins[i] += histogram.getBins()[i];
        }
    }

    public long getNumPixel() {
        long pixel = 0;
        for (int i = 0; i < bins.length; i++) {
            pixel += bins[i];
        }
        return pixel;
    }

    @Override
    public String toString() {
        return Arrays.toString(bins);
    }

    public OrbitModel getModel() {
        return model;
    }

    public void setModel(OrbitModel model) {
        this.model = model;
    }

    public long[] getBins() {
        return bins;
    }

    public void setBins(long[] bins) {
        this.bins = bins;
    }
}
