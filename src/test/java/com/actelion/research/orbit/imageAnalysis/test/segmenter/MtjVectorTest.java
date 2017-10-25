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

package com.actelion.research.orbit.imageAnalysis.test.segmenter;

import com.actelion.research.orbit.imageAnalysis.segmenter.linalg.AbstractVector;
import com.actelion.research.orbit.imageAnalysis.segmenter.linalg.MtjVector;
import no.uib.cipr.matrix.DenseVector;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MtjVectorTest {

  @Test
  public void testGetSubVector() {
    double[] x = new double[] { 0, 1, 2, 3, 4, 5, 6 };
    double[] expected = new double[] { 4, 5, 6 };

    DenseVector vector = new DenseVector(x);
    AbstractVector v = new MtjVector(vector);
    AbstractVector resultActual = v.getSubVector(4, 3);

    assertEquals(resultActual.getDimension(), expected.length);
    for (int i = 0; i < resultActual.getDimension(); i++) {
      assertEquals(expected[i], resultActual.getEntry(i), Helper.TOLERANCE);
    }
  }

  @Test
  public void testSetSubVector() {
    double[] x = new double[] { 1, 2 };
    double[] expected = new double[] { 0, 1, 2, 0 };

    AbstractVector vActual = new MtjVector(4);
    DenseVector tmp = new DenseVector(x);
    AbstractVector subVector = new MtjVector(tmp);
    vActual.setSubVector(1, subVector);
    assertEquals(expected.length, vActual.getDimension());
    for (int i = 0; i < 4; i++) {
      assertEquals(expected[i], vActual.getEntry(i), Helper.TOLERANCE);
    }

  }
}
