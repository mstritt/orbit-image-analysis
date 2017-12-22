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

import com.actelion.research.orbit.imageAnalysis.models.PolygonExt;
import com.actelion.research.orbit.imageAnalysis.models.SegmentationResult;
import com.actelion.research.orbit.imageAnalysis.tasks.ObjectSegmentationWorker;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitLogAppender;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests the correct segmentation of a pattern. Works only if the point sorting (minimum distance of the
 * surrounding polygon) is correct.
 */
public class SegmentationTestPattern {

    private final static Logger logger = LoggerFactory.getLogger(SegmentationTestPattern.class);

    @BeforeClass
    public static void setUp() {
        OrbitLogAppender.GUI_APPENDER = false;
        OrbitUtils.SLEEP_TASK=0;
        OrbitUtils.SLEEP_TILE=0;
    }

    @AfterClass
    public static void tearDown() {
    }


    @Test
    public void testBinaryToPolygonSimple() {
        int w = 100;
        int h = 100;
        short[][] smap = new short[w][h];

        for (int x = 0; x < w; x++)
            for (int y = 0; y < h; y++)
                smap[x][y] = 0;

        for (int i = 0; i < 10; i++) {
            smap[10 + i][50] = 1;
            smap[10 + i][51] = 1;
            smap[10 + i][52] = 1;
            //smap[10+i][53] = 1;
        }

        for (int i = 0; i < 10; i++) {
            smap[20][50 + i] = 1;
            smap[21][50 + i] = 1;
            smap[22][50 + i] = 1;
            //smap[10+i][53] = 1;
        }

        for (int i = 0; i < 5; i++)
            smap[20][70 + i] = 1;

        ObjectSegmentationWorker ndw = new ObjectSegmentationWorker(null, null, null, null, null);
        List<Point> pList = new ArrayList<Point>();
        ndw.addRightHandPoints(22, 59, smap, pList, 0, 0);
        double distBefore = dist(pList);
        logger.debug("dist before sorting: " + distBefore);
        assertNotNull(pList);
        assertTrue(pList.size() > 0);
        double distAfter = dist(pList);
        logger.debug("dist after sorting: " + distAfter);
        logger.debug("list size: " + pList.size());
//		int i=0;
//		for (Point p: pList) {
//			i++;
//			System.out.println(i+": "+p.x+","+p.y);
//		}
        assertTrue(pList.size() >= 40);
        assertTrue(pList.size() <= 44);
        assertTrue(distAfter <= distBefore);
        assertTrue(distAfter < 42);
    }

    @Test
    public void testJoinSegments() {
        PolygonExt p1 = new PolygonExt();
        for (int i = 0; i < 10; i++) p1.addPoint(2 + i, 2);
        p1.addPoint(11, 3);
        for (int i = 9; i >= 0; i--) p1.addPoint(2 + i, 4);
        p1.addPoint(2, 3);

        int offs = 10;
        PolygonExt p2 = new PolygonExt();
        for (int i = 0; i < 10; i++) p2.addPoint(2 + i + offs, 2);
        p2.addPoint(11 + offs, 3);
        for (int i = 9; i >= 0; i--) p2.addPoint(2 + i + offs, 4);
        p2.addPoint(2 + offs, 3);

        offs = 21;
        PolygonExt p3 = new PolygonExt();
        for (int i = 0; i < 10; i++) p3.addPoint(2 + i + offs, 2);
        p3.addPoint(11 + offs, 3);
        for (int i = 9; i >= 0; i--) p3.addPoint(2 + i + offs, 4);
        p3.addPoint(2 + offs, 3);

        System.out.println("p1: " + p1.listPoints());
        System.out.println("p2: " + p2.listPoints());
        System.out.println("p3: " + p3.listPoints());

        List<Shape> shapeList = new ArrayList<Shape>();
        SegmentationResult segRes = new SegmentationResult(shapeList.size(), 0, shapeList, null);
        shapeList.add(p1);
        shapeList.add(p2);
        shapeList.add(p3);
        ObjectSegmentationWorker ndw = new ObjectSegmentationWorker(null, null, null, null, null);
        shapeList = ndw.joinTileSegments(segRes,false).getShapeList();

        assertNotNull(shapeList);
        System.out.println("numShapes: " + shapeList.size());
        for (Shape s : shapeList) {
            System.out.println("Shape: " + ((PolygonExt) s).listPoints());
        }

        assertEquals(1, shapeList.size());

    }


    private double dist(List<Point> pList) {
        double d = 0;
        if (pList != null && pList.size() > 1) {
            for (int i = 0; i < pList.size() - 1; i++) {
                d += pList.get(i).distance(pList.get(i + 1));
            }
            d += pList.get(0).distance(pList.get(pList.size() - 1));
        }
        return d;
    }

}
