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

import com.actelion.research.orbit.beans.RawAnnotation;
import com.actelion.research.orbit.imageAnalysis.models.ImageAnnotation;
import com.actelion.research.orbit.imageAnalysis.models.PolygonExt;
import com.actelion.research.orbit.imageAnalysis.models.RectangleExt;
import com.actelion.research.orbit.imageAnalysis.models.ShapeAnnotationList;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitLogAppender;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class TestShapeAnnotationList {

    static Logger logger = LoggerFactory.getLogger(TestShapeAnnotationList.class);

    @BeforeClass
    public static void setUp() {
        OrbitLogAppender.GUI_APPENDER = false;
    }

    @AfterClass
    public static void tearDown() {
    }

    @Test
    public void testOuterBounds() {
        Rectangle bounds = new Rectangle(100, 100, 200, 200);
        List<RawAnnotation> annos = new ArrayList<RawAnnotation>();
        annos.add(new ImageAnnotation("incl1", new RectangleExt(50, 50, 10, 10), ImageAnnotation.SUBTYPE_INCLUSION, Color.yellow));

        ShapeAnnotationList roi = new ShapeAnnotationList(annos, 0, bounds);
        logger.info("annosShape: " + roi);
        Rectangle re = roi.getBounds();
        System.out.println("bounds: " + re);
        assertEquals(50, re.x);
        assertEquals(50, re.y);
        assertEquals(250, re.width);
        assertEquals(250, re.height);
    }

    @Test
    public void testROI() {
        List<RawAnnotation> annos = new ArrayList<RawAnnotation>();
        annos.add(new ImageAnnotation("roi", new RectangleExt(100, 100, 200, 200), ImageAnnotation.SUBTYPE_ROI, Color.yellow));
        annos.add(new ImageAnnotation("incl1", new RectangleExt(50, 50, 10, 10), ImageAnnotation.SUBTYPE_INCLUSION, Color.yellow));

        ShapeAnnotationList roi = new ShapeAnnotationList(annos, 0, null);
        logger.info("annosShape: " + roi);
        Rectangle re = roi.getBounds();
        System.out.println("bounds: " + re);
        assertEquals(50, re.x);
        assertEquals(50, re.y);
        assertEquals(250, re.width);
        assertEquals(250, re.height);

        assertTrue(roi.contains(110, 110));
        assertTrue(roi.contains(299, 299));
        assertTrue(roi.contains(51, 51));

        assertFalse(roi.contains(70, 70));
        assertFalse(roi.contains(310, 310));
        assertFalse(roi.contains(40, 40));
    }


    @Test
    public void testExcl() {
        List<RawAnnotation> annos = new ArrayList<RawAnnotation>();
        annos.add(new ImageAnnotation("roi", new RectangleExt(100, 100, 200, 200), ImageAnnotation.SUBTYPE_ROI, Color.yellow));
        annos.add(new ImageAnnotation("incl1", new RectangleExt(150, 150, 50, 50), ImageAnnotation.SUBTYPE_EXCLUSION, Color.yellow));

        ShapeAnnotationList roi = new ShapeAnnotationList(annos, 0, null);
        logger.info("annosShape: " + roi);
        Rectangle re = roi.getBounds();
        System.out.println("bounds: " + re);
        assertEquals(100, re.x);
        assertEquals(100, re.y);
        assertEquals(200, re.width);
        assertEquals(200, re.height);

        assertTrue(roi.contains(110, 110));
        assertTrue(roi.contains(299, 299));

        assertFalse(roi.contains(70, 70));
        assertFalse(roi.contains(310, 310));
        assertFalse(roi.contains(170, 170)); // excl
    }

    @Test
    public void testExclIncl() {
        List<RawAnnotation> annos = new ArrayList<RawAnnotation>();
        annos.add(new ImageAnnotation("roi", new RectangleExt(100, 100, 200, 200), ImageAnnotation.SUBTYPE_ROI, Color.yellow));
        annos.add(new ImageAnnotation("excl1", new RectangleExt(150, 150, 50, 50), ImageAnnotation.SUBTYPE_EXCLUSION, Color.yellow));
        annos.add(new ImageAnnotation("incl1", new RectangleExt(170, 170, 20, 20), ImageAnnotation.SUBTYPE_INCLUSION, Color.yellow));

        ShapeAnnotationList roi = new ShapeAnnotationList(annos, 0, null);
        logger.info("annosShape: " + roi);
        Rectangle re = roi.getBounds();
        System.out.println("bounds: " + re);
        assertEquals(100, re.x);
        assertEquals(100, re.y);
        assertEquals(200, re.width);
        assertEquals(200, re.height);

        assertTrue(roi.contains(110, 110));
        assertTrue(roi.contains(299, 299));
        assertTrue(roi.contains(180, 180)); // incl

        assertFalse(roi.contains(70, 70));
        assertFalse(roi.contains(310, 310));
        assertFalse(roi.contains(160, 160)); // excl
        assertFalse(roi.contains(195, 195)); // excl
    }


    @Test
    public void testScale() {
        List<RawAnnotation> annos = new ArrayList<RawAnnotation>();
        annos.add(new ImageAnnotation("excl1", new RectangleExt(25, 25, 50, 50), ImageAnnotation.SUBTYPE_EXCLUSION, Color.yellow));
        annos.add(new ImageAnnotation("incl1", new RectangleExt(40, 40, 50, 50), ImageAnnotation.SUBTYPE_INCLUSION, Color.yellow));

        PolygonExt p = new PolygonExt();
        p.addPoint(0, 0);
        p.addPoint(100, 0);
        p.addPoint(100, 100);
        p.addPoint(0, 100);
        annos.add(new ImageAnnotation("incl1", p, ImageAnnotation.SUBTYPE_ROI, Color.yellow));

        ShapeAnnotationList roi = new ShapeAnnotationList(annos, 0, null);
        System.out.println("scaled: " + roi);
        System.out.println("original bounds: " + roi.getBounds());

        ShapeAnnotationList scaled = (ShapeAnnotationList) roi.getScaledInstance(50d, new Point(0, 0));
        System.out.println("scaled: " + scaled);

        Rectangle re = scaled.getBounds();
        System.out.println("scaled bounds: " + re);


        assertEquals(0, re.x);
        assertEquals(0, re.y);
        assertEquals(50, re.width);
        assertEquals(50, re.height);

        assertTrue(scaled.contains(0, 0));
        assertTrue(scaled.contains(49, 49));

        assertFalse(scaled.contains(15, 15)); // excl
        assertTrue(scaled.contains(24, 24)); // incl inside excl

        assertFalse(scaled.contains(50, 50));
        assertFalse(scaled.contains(1000, 1000));


    }


}
