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

import com.actelion.research.orbit.imageAnalysis.models.PolygonExt;
import com.actelion.research.orbit.imageAnalysis.models.SegmentationResult;
import com.actelion.research.orbit.imageAnalysis.tasks.ObjectSegmentationWorker;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitLogAppender;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests join tile segments.
 */
public class TestJoinTileSegments {


    @BeforeClass
    public static void setUp() {
        OrbitLogAppender.GUI_APPENDER = false;
    }


    @Test
    public void testJoinSegments() {
        PolygonExt p1 = new PolygonExt();
        p1.addPoint(1, 3);
        p1.addPoint(1, 1);
        p1.addPoint(3, 1);
        p1.addPoint(3, 3);
        p1.addPoint(1, 3);

        PolygonExt p2 = new PolygonExt();
        p2.addPoint(1, 5);
        p2.addPoint(1, 3);
        p2.addPoint(3, 3);
        p2.addPoint(3, 5);
        p2.addPoint(1, 5);

        List<Shape> shapeList = new ArrayList<Shape>();
        shapeList.add(p1);
        shapeList.add(p2);
        SegmentationResult segRes = new SegmentationResult(shapeList.size(), 0, shapeList, null);
        ObjectSegmentationWorker ndw = new ObjectSegmentationWorker(null, null, null, null);
        shapeList = ndw.joinTileSegments(segRes).getShapeList();

        assertNotNull(shapeList);
        System.out.println("numShapes: " + shapeList.size());
        for (Shape s : shapeList) {
            System.out.println("Shape: " + ((PolygonExt) s).listPoints());
        }

        assertEquals(1, shapeList.size());

    }


}
