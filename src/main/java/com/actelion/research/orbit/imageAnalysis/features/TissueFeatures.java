/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2016 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.imageAnalysis.utils.TiledImagePainter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.image.Raster;

/**
 * Attention: This class is not thread-safe!!!<br/>
 * Channel usage (useRed,useGreen,useBlue) is treated in feats[] assignment loop - all samples are calculated!
 */
public class TissueFeatures {

    private final static Logger logger = LoggerFactory.getLogger(TissueFeatures.class);
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
    private TissueFeaturesOld oldFeatures = null; // for backward compatibility


    public TissueFeatures() {
    }

    /**
     * bimg can be null (then raster r in buildFeatures cannot be null)
     */
    public TissueFeatures(final FeatureDescription featureDescription, final TiledImagePainter bimg) {
        // for old featureDescription version use old features for backward compatibility
        if (featureDescription.getFeatureVersion() < 1) {
            oldFeatures = new TissueFeaturesOld(featureDescription, bimg);
            logger.debug("using old tissue features for backward compatibility");
        }

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
        // check backward compatibility
        if (oldFeatures != null) return oldFeatures.buildFeatures(r, x, y, classVal);

        if (featureSet == FeatureDescription.FEATURE_SET_INTENS) return buildIntensFeatures(r, x, y, classVal);

        // init
        for (int i = 0; i < samples; i++) {
            mean[i] = 0d;
            min[i] = Double.NaN;
            max[i] = Double.NaN;
            sd[i] = 0d;
            edge[i] = 0d;
        }
        if (r != null)  // faster if raster is pre-assigned (e.g. the shape fits into memory)
        {
            buf = r.getPixels(x - windowSize, y - windowSize, (windowSize * 2) + 1, (windowSize * 2) + 1, buf);
            p = r.getPixel(x, y, p); // mid-pixel
        } else { // slower, but works for very large shapes
            Raster r2 = bimg.getData(new Rectangle(x - windowSize, y - windowSize, (windowSize * 2) + 1, (windowSize * 2) + 1), featureDescription);
            // The modifyRaster works very slow. As optimization the getData() method in OrbitTiledImage2 could be overwritten (copy code from PlanarImage) with featureDescription as argument, then this new method
            // would use the getTile() method with featureDescription as argument and not the standard getTile method. This would make use of the tile caching mechanism in OrbitTiledImage2.
            // However, normally such large shapes are not used at all.
            r2 = OrbitUtils.getModifiedRaster(r2, featureDescription, bimg.getImage().getColorModel());
            if (r2 == null) System.out.println("r2 is null!!");
            buf = r2.getPixels(x - windowSize, y - windowSize, (windowSize * 2) + 1, (windowSize * 2) + 1, buf);
            p = r2.getPixel(x, y, p);
        }


//		System.out.println("pixel: "+Arrays.toString(p));
//		System.out.println("buf: "+Arrays.toString(buf));
//		System.out.println("samples: "+samples+"  windowSize: "+windowSize);

        // middle pixel
        for (int i = 0; i < samples; i++) pix[i] = p[i];
        // Remark: System.arraycopy() does not work here because pix is double[] and p is int[]!

        //int[] p = new int[4]; // r,g,b,alpha (if available)
        int cnt = 1; // bugfix due to +samples
        int bufPos = 0;

        //for (int px=x-windowSize; px<=x+windowSize; px++)
        //	for (int py=y-windowSize; py<=y+windowSize; py++)
        while (bufPos < buf.length - samples) {
            //if (r!=null)
            //p = r.getPixel(px, py, p); // better use getPixels()...

            //else p = bimg.getPixels(px, py, windowSize, p);
            //int d = Math.max(Math.abs(px-x), Math.abs(py-y)); // use it as weights
            for (int i = 0; i < samples; i++) {
                    /*
                    mean[i] +=p[i];
					if (Double.isNaN(min[i]) || (min[i] > p[i])) min[i] = p[i];
					if (Double.isNaN(max[i]) || (max[i] < p[i])) max[i] = p[i];
					*/
                mean[i] += buf[bufPos];
                if (Double.isNaN(min[i]) || (min[i] > buf[bufPos])) min[i] = buf[bufPos]; //bufPos++; // bugfix
                if (Double.isNaN(max[i]) || (max[i] < buf[bufPos])) max[i] = buf[bufPos]; //bufPos++; // bugfix
                bufPos++;
            }
            cnt++;
        }

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

//		System.out.println("pix: "+Arrays.toString(pix));
//		System.out.println("mean: "+Arrays.toString(mean));
//		System.out.println("min: "+Arrays.toString(min));
//		System.out.println("max: "+Arrays.toString(max));
//		System.out.println("sd: "+Arrays.toString(sd));

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

    public int getFeaturesPerSample() {
        return featuresPerSample;
    }


    public static double extractSD(double[] feats) {
        return sumOrNan(feats[12],feats[13],feats[14]);
    }

    public static double extractEdge(double[] feats) {
        return sumOrNan(feats[15],feats[16],feats[17]);
    }

    public static double extractMin(double[] feats) {
        return sumOrNan(feats[6],feats[7],feats[8]);
    }

    public static double extractMax(double[] feats) {
        return sumOrNan(feats[9],feats[10],feats[11]);
    }

    public static double extractMean(double[] feats) {
        return sumOrNan(feats[3],feats[4],feats[5]);
    }

    public static double extractPix(double[] feats) {
        return sumOrNan(feats[0],feats[1],feats[2]);
    }

    /**
     * returns 0 if the value is Double.NaN, otherwise the value
     * @param d
     * @return
     */
    private static double v0(double d) {
        return Double.isNaN(d)?0d:d;
    }

    private static double sumOrNan(double d1, double d2, double d3) {
        if (Double.isNaN(d1)&&Double.isNaN(d2)&&Double.isNaN(d3)) {
            return Double.NaN;
        } else {
            return v0(d1)+v0(d2)+v0(d3);
        }
    }


}
