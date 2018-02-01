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
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Attention: This class is not thread-safe!!!<br/>
 * Channel usage (useRed,useGreen,useBlue) is treated in feats[] assignment loop - all samples are calculated!
 * <p>
 * This TissueFeatures computes the features in a circular region, not inside a squared sliding window as the original
 * TissueFeatures class does.
 */
public class TissueFeaturesCircular extends TissueFeatures {

    private final static Logger logger = LoggerFactory.getLogger(TissueFeaturesCircular.class);
    private int samples = 3;
    private int windowSize = 4;
    private int[] buf = null;
    private TiledImagePainter bimg = null;
    //private int[] p = new int[4]; // buffer of one pixel up to 4 samples
    private FeatureDescription featureDescription = null;
    private final static int sampleSize = 500;
    public final static ConcurrentHashMap<Integer, HashSet<Integer>> validPointsCnt = new ConcurrentHashMap<>();
    private final Random random = new Random();

    /**
     * bimg can be null (then raster r in buildFeatures cannot be null)
     */
    public TissueFeaturesCircular(final FeatureDescription featureDescription, final TiledImagePainter bimg) {
        this.samples = featureDescription.getSampleSize();
        this.windowSize = featureDescription.getWindowSize();
        this.bimg = bimg;
        buf = new int[(windowSize * 2 + 1) * (windowSize * 2 + 1) * samples];
    }


    /**
     * Initializes a double array of a sufficient size given the feature description.
     *
     * @return
     */
    public double[] prepareDoubleArray() {
        prepareValidPoints(windowSize);
        return new double[(validPointsCnt.get(windowSize).size()) * samples + 1]; // +1 for contextclassification???
    }


    public double[] buildFeatures(final Raster r, final int x, final int y, final double classVal) throws OrbitImageServletException {
        prepareValidPoints(windowSize);
        if (r != null)  // faster if raster is pre-assigned (e.g. the shape fits into memory)
        {
            buf = r.getPixels(x - windowSize, y - windowSize, (windowSize * 2) + 1, (windowSize * 2) + 1, buf);
            //p = r.getPixel(x, y, p); // mid-pixel
        } else { // slower, but works for very large shapes
            Raster r2 = bimg.getData(new Rectangle(x - windowSize, y - windowSize, (windowSize * 2) + 1, (windowSize * 2) + 1), featureDescription);
            if (r2 == null) System.out.println("r2 is null!!");
            buf = r2.getPixels(x - windowSize, y - windowSize, (windowSize * 2) + 1, (windowSize * 2) + 1, buf);
            //p = r2.getPixel(x, y, p);
        }

        double[] feats = prepareDoubleArray();
        int featsCnt = 0;
        HashSet<Integer> pHS = validPointsCnt.get(windowSize);
        for (int i = 0; i < (buf.length) / samples; i++) {   // buf.len-1 ?
            if (pHS.contains(i)) {
                for (int s = 0; s < samples; s++) {
                    feats[featsCnt++] = buf[i * samples + s]; // /255 for normalization
                }

            }
        }
        feats[feats.length - 1] = classVal;
        //logger.trace(Arrays.toString(feats));
        return feats;
    }

    public void prepareValidPoints(int windowSize) {
        if (!validPointsCnt.containsKey(windowSize)) {
            double mult = 5;

            double a = ((windowSize * windowSize) / (Math.PI * windowSize * windowSize));
            double p = (sampleSize / (a * (windowSize * windowSize))) * 2.2; // 5=2.2 / 7=3.6

            HashSet<Integer> pHS = new HashSet<>(sampleSize);
            int cnt = 0;
            int pos = 0;
            for (int y = -windowSize; y <= windowSize; y++)
                for (int x = -windowSize; x <= windowSize; x++) {
                    double dist = Math.sqrt(x * x + y * y);
                    if (dist <= windowSize) {
                        double f = 1d - (dist / windowSize);
                        if ((x == 0 && y == 0) || ((random.nextDouble() < Math.pow(f, mult)) && (random.nextDouble() < p))) {
                            // xHS.add(x + windowSize);
                            // yHS.add(y + windowSize);
                            pHS.add(pos);
                            //System.out.println("pos: "+pos);
                            cnt++;
                        }
                    }
                    pos++;
                }
            logger.info(cnt + " valid points created");
            validPointsCnt.put(windowSize, pHS);
        }
    }

}
