/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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


import com.actelion.research.orbit.imageAnalysis.segmenter.linalg.AbstractMatrix;
import com.actelion.research.orbit.imageAnalysis.segmenter.linalg.AbstractVector;
import com.actelion.research.orbit.imageAnalysis.segmenter.linalg.MtjMatrix;
import com.actelion.research.orbit.imageAnalysis.segmenter.linalg.MtjVector;
import no.uib.cipr.matrix.DenseMatrix;
import no.uib.cipr.matrix.DenseVector;
import no.uib.cipr.matrix.sparse.FlexCompRowMatrix;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MtjMatrixTest {

  @Test
  public void testMultiply() {
    double[][] tmpMatrix = { { 1, 2, 3 }, { 4, 5, 6 } };
    double[] tmpVector = { 1, 2, 3 };
    double[] resultExpected = { 14, 32 };
    DenseMatrix denseMatrix = new DenseMatrix(tmpMatrix);
    DenseVector denseVector = new DenseVector(tmpVector);
    AbstractMatrix abstractMatrix = new MtjMatrix(denseMatrix);
    AbstractVector abstractVector = new MtjVector(denseVector);

    AbstractVector resultActual = abstractMatrix.multiply(abstractVector);
    assertEquals(resultExpected.length, resultActual.getDimension());
    for (int i = 0; i < resultActual.getDimension(); i++) {
      assertEquals(resultExpected[i], resultActual.getEntry(i), Helper.TOLERANCE);
    }

  }

  @Test
  public void testGetSubMatrixDense() {
    double[][] tmpMatrix = { { 1, 2, 3 }, { 4, 5, 6 } };
    double[][] expteced = { { 5, 6 } };
    DenseMatrix denseMatrix = new DenseMatrix(tmpMatrix);
    AbstractMatrix abstractMatrix = new MtjMatrix(denseMatrix);

    AbstractMatrix resultActual = abstractMatrix.getSubMatrix(1, 1, 1, 2);
    assertEquals(1, resultActual.getRowDimension());
    assertEquals(2, resultActual.getColumnDimension());
    for (int i = 0; i < resultActual.getRowDimension(); i++) {
      for (int j = 0; j < resultActual.getColumnDimension(); j++) {
        assertEquals(expteced[i][j], resultActual.getEntry(i, j), Helper.TOLERANCE);
      }
    }
  }

  @Test
  public void testGetSubMatrixSparse() {
    FlexCompRowMatrix tmpMatrix = new FlexCompRowMatrix(5, 5);
    double[][] expteced = { { 1, 0 }, { 0, 1 } };
    tmpMatrix.set(0, 0, 1);
    tmpMatrix.set(1, 1, 1);
    AbstractMatrix abstractMatrix = new MtjMatrix(tmpMatrix);

    AbstractMatrix resultActual = abstractMatrix.getSubMatrix(0, 1, 0, 1);
    assertEquals(2, resultActual.getRowDimension());
    assertEquals(2, resultActual.getColumnDimension());
    for (int i = 0; i < resultActual.getRowDimension(); i++) {
      for (int j = 0; j < resultActual.getColumnDimension(); j++) {
        assertEquals(expteced[i][j], resultActual.getEntry(i, j), Helper.TOLERANCE);
      }
    }
  }

  @Test
  public void testSetSubMatrix() {
    boolean sparse = true;
    MtjMatrix actual = new MtjMatrix(4, 4, sparse);
    MtjMatrix subMatrix = new MtjMatrix(2, 2, sparse);
    subMatrix.setEntry(0, 0, 1);
    subMatrix.setEntry(1, 1, 1);
    actual.setSubMatrix(subMatrix, 2, 1);
    double[][] expected = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1.0, 0, 0 }, { 0, 0, 1.0, 0 } };
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        assertEquals(expected[i][j], actual.getEntry(i, j), Helper.TOLERANCE);
      }
    }

  }
}
