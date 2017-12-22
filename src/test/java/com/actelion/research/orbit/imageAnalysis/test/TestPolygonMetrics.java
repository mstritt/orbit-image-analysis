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

import com.actelion.research.orbit.imageAnalysis.utils.OrbitLogAppender;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.imageAnalysis.utils.PolygonMetrics;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.Assert.assertEquals;

public class TestPolygonMetrics {

    private static double EPSILON = 0.00000001d;

    @BeforeClass
    public static void setUp() {
        OrbitLogAppender.GUI_APPENDER = false;
        OrbitUtils.SLEEP_TASK=0;
        OrbitUtils.SLEEP_TILE=0;
    }

    @Test
    public void testArea() {
        Polygon p = new Polygon();
        p.addPoint(0, 0);
        p.addPoint(4, 0);
        p.addPoint(4, 4);
        p.addPoint(0, 4);

        PolygonMetrics pm = new PolygonMetrics(p);
        double area = pm.getArea();

        assertEquals(16d, area, EPSILON);

    }

    @Test
    public void testArea2() {
        Polygon p = new Polygon();
        p.addPoint(2, 5);
        p.addPoint(5, 8);
        p.addPoint(10, 3);
        p.addPoint(10, 10);
        p.addPoint(4, 8);
        p.addPoint(2, 9);

        PolygonMetrics pm = new PolygonMetrics(p);
        double area1 = pm.getArea();

        double area2 = 0;
        for (int x = 0; x < 12; x++)
            for (int y = 0; y < 12; y++) {
                if (p.contains(x, y)) {
                    area2++;
                }
            }

        System.out.println("areaMetrics:" + area1 + "  areaContains:" + area2);
        assertEquals(area1, area2, 1);
    }

    @Test
    public void testPerimeter() {
        Polygon p = new Polygon();
        p.addPoint(0, 0);
        p.addPoint(4, 0);
        p.addPoint(4, 4);
        p.addPoint(0, 4);

        PolygonMetrics pm = new PolygonMetrics(p);
        double perimeter = pm.getPerimeter();

        assertEquals(16d, perimeter, EPSILON);
    }

    @Test
    public void testCircularity() {
        Polygon p = new Polygon();
        p.addPoint(0, 0);
        p.addPoint(4, 0);
        p.addPoint(4, 4);
        p.addPoint(0, 4);

        PolygonMetrics pm = new PolygonMetrics(p);
        double circularity = pm.getCircularity(pm.getArea(), pm.getPerimeter());

        //assertEquals(0.0625d,circularity,EPSILON);
        assertEquals(0.78539816, circularity, EPSILON);    // with 4*perimeter
    }

    @Test
    public void testCentroid() {
        Polygon p = new Polygon();
        p.addPoint(0, 0);
        p.addPoint(4, 0);
        p.addPoint(4, 4);
        p.addPoint(0, 4);

        PolygonMetrics pm = new PolygonMetrics(p);
        Point2D centroid = pm.getCentroid(true);
        assertEquals(new Point2D.Double(2, 2), centroid);

        p = new Polygon();
        p.addPoint(5, 5);
        p.addPoint(10, 5);
        p.addPoint(10, 10);
        p.addPoint(5, 10);

        pm.setPolygon(p);
        centroid = pm.getCentroid(true);
        assertEquals(new Point2D.Double(7.5d, 7.5d), centroid);

    }

    @Test
    public void testRoundness() {
        Polygon p = new Polygon();
        p.addPoint(0, 0);
        p.addPoint(2, -1);
        p.addPoint(4, 0);
        p.addPoint(5, 2);
        p.addPoint(4, 4);
        p.addPoint(2, 5);
        p.addPoint(0, 4);
        p.addPoint(-1, 2);
        PolygonMetrics pm = new PolygonMetrics(p);
        double r = pm.getRoundness(true);
        assertEquals(0.02943725152d, r, 0.00001d);

    }


}
