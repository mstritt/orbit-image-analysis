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

package com.actelion.research.orbit.imageAnalysis.test;

import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.features.TissueFeatures;
import com.actelion.research.orbit.imageAnalysis.models.FeatureDescription;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitLogAppender;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.imageAnalysis.utils.TiledImagePainter;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.media.jai.PlanarImage;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TestFeatures {

    private static double EPSILON = 0.00000001d;

    @BeforeClass
    public static void setUp() {
        OrbitLogAppender.GUI_APPENDER = false;
        OrbitUtils.SLEEP_TASK=0;
        OrbitUtils.SLEEP_TILE=0;
    }

    @Test
    public void testIntensities() throws OrbitImageServletException {
        BufferedImage bi = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
        Color c1 = new Color(1, 2, 3);
        Color c2 = new Color(4, 8, 16);
        bi.setRGB(10, 10, c2.getRGB());
        Raster r = bi.getRaster();

        FeatureDescription descr = new FeatureDescription(1);
        descr.setSkipRed(false);
        descr.setSkipGreen(false);
        descr.setSkipBlue(false);
        TiledImagePainter tip = new TiledImagePainter(PlanarImage.wrapRenderedImage(bi), "test");
        TissueFeatures tissueFeatures = new TissueFeatures(descr, tip);
        double[] feats = tissueFeatures.buildFeatures(r, 10, 10, Double.NaN);
        System.out.println(Arrays.toString(feats));

        // pix
        assertEquals(4d, feats[0], EPSILON);
        assertEquals(8d, feats[1], EPSILON);
        assertEquals(16d, feats[2], EPSILON);

        // mean
        assertEquals(0.44444444444d, feats[3], EPSILON);
        assertEquals(0.88888888888d, feats[4], EPSILON);
        assertEquals(1.77777777777d, feats[5], EPSILON);

        //min
        assertEquals(0d, feats[6], EPSILON);
        assertEquals(0d, feats[7], EPSILON);
        assertEquals(0d, feats[8], EPSILON);

        //max
        assertEquals(4d, feats[9], EPSILON);
        assertEquals(8d, feats[10], EPSILON);
        assertEquals(16d, feats[11], EPSILON);

        //sd
        assertEquals(1.333333333333333d, feats[12], EPSILON);
        assertEquals(2.666666666666666d, feats[13], EPSILON);
        assertEquals(5.333333333333333d, feats[14], EPSILON);

    }


}
