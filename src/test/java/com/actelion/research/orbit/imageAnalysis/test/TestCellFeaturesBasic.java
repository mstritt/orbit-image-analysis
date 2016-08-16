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

package com.actelion.research.orbit.imageAnalysis.test;

import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.features.ObjectFeatureBuilderTiled;
import com.actelion.research.orbit.imageAnalysis.models.RectangleExt;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitLogAppender;
import com.actelion.research.orbit.imageAnalysis.utils.TiledImagePainter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.media.jai.PlanarImage;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * CellFeatures test based on a generated image
 */
public class TestCellFeaturesBasic {

    static Logger logger = LoggerFactory.getLogger(TestCellFeaturesBasic.class);
    double delta = 0.000001d;

    @BeforeClass
    public static void setUp() {
        OrbitLogAppender.GUI_APPENDER = false;
    }

    @AfterClass
    public static void tearDown() {
    }


    @Test
    public void cellFeaturesBasic() {
        BufferedImage bi = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
        Color c1 = new Color(1, 2, 3);
        Color c2 = new Color(4, 8, 16);
        bi.setRGB(10, 10, c2.getRGB());
        bi.setRGB(8, 8, c1.getRGB());
        bi.setRGB(12, 12, c1.getRGB());

        TiledImagePainter tip = new TiledImagePainter(PlanarImage.wrapRenderedImage(bi), "test");
        RecognitionFrame rf = new RecognitionFrame(tip);
        Shape shape = new RectangleExt(9, 9, 3, 3);

        ObjectFeatureBuilderTiled cellFeatureBuilder = new ObjectFeatureBuilderTiled(null);
        double[] feats = cellFeatureBuilder.buildFeatures(shape, 1, rf, null, 3, 0, 0);
        assertEquals(4d, feats[1], delta);
        assertEquals(8d, feats[5], delta);
        assertEquals(16d, feats[9], delta);
        assertEquals(1d, feats[23], delta); // class

        System.out.println(Arrays.toString(feats));


    }


}
