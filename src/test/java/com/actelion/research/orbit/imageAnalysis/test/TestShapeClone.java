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

import com.actelion.research.orbit.imageAnalysis.models.ClassShape;
import com.actelion.research.orbit.imageAnalysis.models.PolygonExt;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitLogAppender;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;

import static junit.framework.Assert.assertTrue;

public class TestShapeClone {

    @BeforeClass
    public static void setUp() {
        OrbitLogAppender.GUI_APPENDER = false;
    }

    @Test
    public void wellName2Pos() {
        ClassShape cs1 = new ClassShape("cs1", new Color(255, 135, 32), ClassShape.SHAPETYPE_POLYGONEXT);
        PolygonExt pe1 = new PolygonExt();
        pe1.addPoint(1, 1);
        pe1.addPoint(10, 10);
        pe1.addPoint(5, 5);
        cs1.getShapeList().add(pe1);

        ClassShape cs2 = cs1.clone();
        assertTrue(cs1 != cs2);

        assertTrue(cs1.getShapeList().get(0) != cs2.getShapeList().get(0));    // only works with deep-clone of the shape

    }


}
