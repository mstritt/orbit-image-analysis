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

import com.actelion.research.orbit.imageAnalysis.dal.ScaleoutSpark;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestScaleoutSparkParsing {

    @Test
    public void testParseSmbUrl() {
        ScaleoutSpark sc = new ScaleoutSpark();
        String[] smb = sc.parseSMBurl("domain/user:password@smb://server/share");
        System.out.println("smb: " + Arrays.toString(smb));
        assertEquals("domain", smb[0]);
        assertEquals("user", smb[1]);
        assertEquals("password", smb[2]);
        assertEquals("smb://server/share", smb[3]);

        smb = sc.parseSMBurl("user:password@smb://server/share");
        System.out.println("smb: " + Arrays.toString(smb));
        assertEquals("", smb[0]);
        assertEquals("user", smb[1]);
        assertEquals("password", smb[2]);
        assertEquals("smb://server/share", smb[3]);

        smb = sc.parseSMBurl("user@smb://server/share");
        System.out.println("smb: " + Arrays.toString(smb));
        assertEquals("", smb[0]);
        assertEquals("user", smb[1]);
        assertEquals("", smb[2]);
        assertEquals("smb://server/share", smb[3]);

        smb = sc.parseSMBurl("domain/user@smb://server/share");
        System.out.println("smb: " + Arrays.toString(smb));
        assertEquals("domain", smb[0]);
        assertEquals("user", smb[1]);
        assertEquals("", smb[2]);
        assertEquals("smb://server/share", smb[3]);

        smb = sc.parseSMBurl("smb://server/share");
        System.out.println("smb: " + Arrays.toString(smb));
        assertNull(smb[0]);
        assertNull(smb[1]);
        assertNull(smb[2]);
        assertEquals("smb://server/share", smb[3]);
    }

}
