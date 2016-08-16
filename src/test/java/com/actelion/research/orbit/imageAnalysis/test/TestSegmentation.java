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
import com.actelion.research.orbit.imageAnalysis.models.SegmentationResult;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitHelper;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitLogAppender;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * TestTwoLevelSegmentation test
 */
public class TestSegmentation {

    @BeforeClass
    public static void setUp() {
        OrbitLogAppender.GUI_APPENDER = false;
    }

    @Test
    public void testObjectSegmentation() throws OrbitImageServletException {
        OrbitModel model = OrbitModel.LoadFromInputStream(this.getClass().getResourceAsStream("/resource/testmodels/segmentation.omo"));
        RecognitionFrame rf = new RecognitionFrame("/resource/testimages/segmentation.jpg", true);
        SegmentationResult res = OrbitHelper.Segmentation(rf, -1, model, null, -1, false);
        assertNotNull(res);
        assertEquals(2295, res.getObjectCount()); // 2297 ?
    }


}
