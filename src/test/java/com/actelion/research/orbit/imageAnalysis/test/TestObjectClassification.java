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
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.models.SegmentationResult;
import com.actelion.research.orbit.imageAnalysis.utils.ClassificationResult;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitHelper;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitLogAppender;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * TestObjectClassification test
 */
public class TestObjectClassification {

    @BeforeClass
    public static void setUp() {
        OrbitLogAppender.GUI_APPENDER = false;
        OrbitUtils.SLEEP_TASK=0;
        OrbitUtils.SLEEP_TILE=0;
    }

    @Test
    public void testObjectSegmentation() throws OrbitImageServletException {
        OrbitModel model = OrbitModel.LoadFromInputStream(this.getClass().getResourceAsStream("/resource/testmodels/objectClassification.omo"));
        RecognitionFrame rf = new RecognitionFrame("/resource/testimages/objectClassification.jpg", true);
        SegmentationResult res = OrbitHelper.Segmentation(rf, -1, model, null, -1, false);
        assertNotNull(res);
        assertEquals(6, res.getObjectCount());
        assertNotNull(res.getFeatureList());
        assertEquals(6, res.getFeatureList().size());
        assertEquals(5.1969, res.getFeatureList().get(5)[0], 0.001d);  // might fail die to TSP point sorter in ObjectSegmentationWorker/PointSorter
    }

    // might fail due to tsp point sorter...
    @Test
    public void testObjectClassification() throws OrbitImageServletException {
        OrbitModel model = OrbitModel.LoadFromInputStream(this.getClass().getResourceAsStream("/resource/testmodels/objectClassification.omo"));
        RecognitionFrame rf = new RecognitionFrame("/resource/testimages/objectClassification.jpg", true);
        ClassificationResult res = OrbitHelper.CellClassification(rf, model, null, -1);
        assertNotNull(res);
        assertEquals(1l, (long) res.getRatio().get("Other Objects"));
        assertEquals(2l, (long) res.getRatio().get("Stained Objects"));
        assertEquals(3l, (long) res.getRatio().get("Normal Objects"));
    }

}
