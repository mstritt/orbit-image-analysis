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

import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.models.PolygonExt;
import com.actelion.research.orbit.imageAnalysis.models.SegmentationResult;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitHelper;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitLogAppender;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * TestTwoLevelSegmentation test
 */
public class TestSingleSegmentation {

    @BeforeClass
    public static void setUp() {
        OrbitLogAppender.GUI_APPENDER = false;
    }

    @Test
    public void testSegmentationEquals() throws OrbitImageServletException {
        OrbitModel model = OrbitModel.LoadFromInputStream(this.getClass().getResourceAsStream("/resource/testmodels/singleSegmentation.omo"));
        //model.getSegmentationModel().getFeatureDescription().setNumDilate(1);
        RecognitionFrame rf = new RecognitionFrame("/resource/testimages/singleSegmentation2.png", true);
        int num = 10;
        PolygonExt[] polys = new PolygonExt[num];
        for (int i = 0; i < num; i++) {
            SegmentationResult res = OrbitHelper.Segmentation(rf, -1, model, null, -1, false);
            assertNotNull(res);
            assertEquals(1, res.getObjectCount());
            assertEquals(1, res.getShapeList().size());
            assertTrue(res.getShapeList().get(0) instanceof PolygonExt);
            PolygonExt poly = (PolygonExt) res.getShapeList().get(0); // shoule always be a PolygonExt
            polys[i] = poly;
        }

        // test if all are equals
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                assertTrue(polys[i].equalsExact(polys[j]));
            }
        }


    }


}
