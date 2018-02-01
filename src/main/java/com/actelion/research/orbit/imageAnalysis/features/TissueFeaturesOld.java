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

package com.actelion.research.orbit.imageAnalysis.features;

import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.models.FeatureDescription;
import com.actelion.research.orbit.imageAnalysis.utils.TiledImagePainter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.image.Raster;

/**
 * Old version (for backward compatibility)
 * Attention: This class is not thread-safe!!!<br/>
 * Channel usage (useRed,useGreen,useBlue) is treated in feats[] assignment loop - all samples are calculated!
 */
public class TissueFeaturesOld {

    private final static Logger logger = LoggerFactory.getLogger(TissueFeaturesOld.class);
    private static double EPSILON = 0.00000001d;
    private int featuresPerSample = 6;
    private int samples = 3;
    private int windowSize = 4;
    private int[] buf = null;
    private double[] pix = null;
    private double[] mean = null;
    private double[] min = null;
    private double[] max = null;
    private double[] sd = null;
    private double[] edge = null; // edge intensity per sample
    private TiledImagePainter bimg = null;
    private int[] p = new int[4]; // buffer of one pixel up to 4 samples
    private int featureSet = FeatureDescription.FEATURE_SET_PIX_MEAN_MIN_MAX_SD_EDGE;
    private FeatureDescription featureDescription = null;


    /**
     * bimg can be null (then raster r in buildFeatures cannot be null)
     */
    public TissueFeaturesOld(final FeatureDescription featureDescription, final TiledImagePainter bimg) {
        this.samples = featureDescription.getSampleSize();
        this.windowSize = featureDescription.getWindowSize();
        this.featureSet = featureDescription.getFeatureSet();
        this.featureDescription = featureDescription;
        this.bimg = bimg;
        buf = new int[(windowSize * 2 + 1) * (windowSize * 2 + 1) * samples];
        pix = new double[samples];
        mean = new double[samples];
        min = new double[samples];
        max = new double[samples];
        sd = new double[samples];
        edge = new double[samples];
        if (featureSet == FeatureDescription.FEATURE_SET_INTENS) featuresPerSample = 1;
        else if (featureSet == FeatureDescription.FEATURE_SET_PIX_MEAN_MIN_MAX_SD) featuresPerSample = 5;
        else featuresPerSample = 6; // with edge
    }


    /**
     * Initializes a double array of a sufficient size given the feature description.
     *
     * @return
     */
    public double[] prepareDoubleArray() {
        return new double[(windowSize * 2 + 1) * (windowSize * 2 + 1) * samples + 1]; // +1 for contextclassification???
    }

    /**
     * computes tissue features (mean,min,max,sd of each sample (r,g,b or grey)).<br>
     * Not thread-safe!!!
     *
     * @param r        can be null (then bimg cannot be null in the constructor)
     * @param x
     * @param y
     * @param classVal (set to Double.NaN for classification)
     * @return
     * @throws OrbitImageServletException
     */
    public double[] buildFeatures(final Raster r, final int x, final int y, final double classVal) throws OrbitImageServletException {
        if (featureSet == FeatureDescription.FEATURE_SET_INTENS) return buildIntensFeatures(r, x, y, classVal);

        // init
        for (int i = 0; i < samples; i++) {
            mean[i] = 0d;
            min[i] = Double.NaN;
            max[i] = Double.NaN;
            sd[i] = 0d;
        }
        if (r != null)  // faster if raster is pre-assigned (e.g. the shape fits into memory)
        {
            buf = r.getPixels(x - windowSize, y - windowSize, (windowSize * 2) + 1, (windowSize * 2) + 1, buf);
            p = r.getPixel(x, y, p); // mid-pixel
        } else { // slower, but works for very large shapes
            Raster r2 = bimg.getData(new Rectangle(x - windowSize, y - windowSize, (windowSize * 2) + 1, (windowSize * 2) + 1), featureDescription);
            if (r2 == null) System.out.println("r2 is null!!");
            buf = r2.getPixels(x - windowSize, y - windowSize, (windowSize * 2) + 1, (windowSize * 2) + 1, buf);
            p = r2.getPixel(x, y, p);
        }


        // middle pixel
        for (int i = 0; i < samples; i++) pix[i] = p[i];
        // Remark: System.arraycopy() does not work here because pix is double[] and p is int[]!

        //int[] p = new int[4]; // r,g,b,alpha (if available)
        int cnt = 0; // BUG: should be 1
        int bufPos = 0;
        //try {

        //for (int px=x-windowSize; px<=x+windowSize; px++)
        //	for (int py=y-windowSize; py<=y+windowSize; py++)
        while (bufPos < buf.length - samples) {
            //if (r!=null)
            //p = r.getPixel(px, py, p); // better use getPixels()...


            //else p = bimg.getPixels(px, py, windowSize, p);
            //int d = Math.max(Math.abs(px-x), Math.abs(py-y)); // use it as weights
            for (int i = 0; i < samples; i++) {
                // BUG: correct would be only one bufPos++ in this for loop. Fixed in
                // new TissueFeatures but kept here for backward compatibility
                mean[i] += buf[bufPos];
                bufPos++;
                if (Double.isNaN(min[i]) || (min[i] > buf[bufPos])) min[i] = buf[bufPos];
                bufPos++;
                if (Double.isNaN(max[i]) || (max[i] < buf[bufPos])) max[i] = buf[bufPos];
                bufPos++;

            }
            cnt++;
        }

        //} catch (Exception e) {e.printStackTrace(); }
        if (cnt > 0)
            for (int i = 0; i < samples; i++) {
                if (mean[i] > 0)
                    mean[i] /= (double) cnt;
            }

        // sd and edge
        cnt = 0;
        bufPos = 0;
        //for (int px=x-windowSize; px<=x+windowSize; px++)
        //	for (int py=y-windowSize; py<=y+windowSize; py++)
        while (bufPos < buf.length) {
            //p = r.getPixel(px, py, p); // better use getPixels()...
            //int d = Math.max(Math.abs(px-x), Math.abs(py-y)); // use it as weights
            for (int i = 0; i < samples; i++) {
                //sd[i] += (mean[i]-p[i]) * (mean[i]-p[i]);
                sd[i] += (mean[i] - buf[bufPos]) * (mean[i] - buf[bufPos]); //bufPos++;
                edge[i] += (pix[i] - buf[bufPos]) * (pix[i] - buf[bufPos]);
                bufPos++;
            }
            cnt++;
        }

        for (int i = 0; i < samples; i++) {
            if (cnt > 1) {
                sd[i] /= (double) (cnt - 1);
                if (sd[i] > EPSILON) {
                    sd[i] = Math.sqrt(sd[i]);
                } else sd[i] = Double.NaN;

                edge[i] /= (double) (cnt - 1);
                if (edge[i] > EPSILON) {
                    edge[i] = Math.sqrt(edge[i]);
                } else edge[i] = Double.NaN;
            } else {
                sd[i] = Double.NaN;
                edge[i] = Double.NaN;
            }
        }

        // store features
        double[] feats = new double[featuresPerSample * samples + 1];
        for (int i = 0; i < samples; i++) {
            if ((i == 0) && (featureDescription.isSkipRed())) continue;
            if ((i == 1) && (featureDescription.isSkipGreen())) continue;
            if ((i == 2) && (featureDescription.isSkipBlue())) continue;
            feats[(samples * 0) + i] = pix[i];
            feats[(samples * 1) + i] = mean[i];
            feats[(samples * 2) + i] = min[i];
            feats[(samples * 3) + i] = max[i];
            feats[(samples * 4) + i] = sd[i];
            if (featureSet >= FeatureDescription.FEATURE_SET_PIX_MEAN_MIN_MAX_SD_EDGE)
                feats[(samples * 5) + i] = edge[i];
        }
        feats[feats.length - 1] = classVal;
        //logger.trace(feats.toString());
        return feats;
    }


    private double[] buildIntensFeatures(final Raster r, final int x, final int y, final double classVal) throws OrbitImageServletException {
        // init
        for (int i = 0; i < samples; i++) {
            mean[i] = 0d;
        }
        if (r != null)  // faster if raster is pre-assigned (e.g. the shape fits into memory)
        {
            buf = r.getPixels(x - windowSize, y - windowSize, (windowSize * 2) + 1, (windowSize * 2) + 1, buf);
            p = r.getPixel(x, y, p); // mid-pixel
        } else { // slower, but works for very large shapes
            Raster r2 = bimg.getData(new Rectangle(x - windowSize, y - windowSize, (windowSize * 2) + 1, (windowSize * 2) + 1), featureDescription);
            if (r2 == null) System.out.println("r2 is null!!");
            buf = r2.getPixels(x - windowSize, y - windowSize, (windowSize * 2) + 1, (windowSize * 2) + 1, buf);
            p = r2.getPixel(x, y, p);
        }

        for (int i = 0; i < samples; i++) {
            mean[0] += p[i];
        }
        mean[0] /= (double) samples;
        double[] feats = new double[featuresPerSample * samples + 1];
        for (int i = 0; i < samples; i++) {
            if ((i == 0) && (featureDescription.isSkipRed())) continue;
            if ((i == 1) && (featureDescription.isSkipGreen())) continue;
            if ((i == 2) && (featureDescription.isSkipBlue())) continue;
            feats[(samples * 0) + i] = mean[i];
        }
        feats[feats.length - 1] = classVal;
        //logger.trace(Arrays.toString(feats));
        return feats;
    }

}
