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

import com.actelion.research.orbit.imageAnalysis.segmenter.finitedifference.FiniteDifferenceSolver;
import com.actelion.research.orbit.imageAnalysis.segmenter.geometry.Vertex;
import com.actelion.research.orbit.imageAnalysis.segmenter.linalg.AbstractMatrix;
import com.actelion.research.orbit.imageAnalysis.segmenter.linalg.AbstractVector;
import com.actelion.research.orbit.imageAnalysis.segmenter.math.Function;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class FiniteDifferenceSolverTest {

  private static FiniteDifferenceSolver fdSolverFirstTestcase;
  private static FiniteDifferenceSolver fdSolverSecondTestcase;
  private static FiniteDifferenceSolver fdSolverThirdTestcase;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    double alpha = 2.0;
    double beta = 0;
    double gamma = 3.0;
    int m = 5;
    int n = 5;

    Function force = new Function() {

      @Override
      public double getValue(Vertex v) {
        double x = v.getCoordinates()[0];
        double y = v.getCoordinates()[1];
        return 4.0 / 3.0 * (-(x - 4) * x - (y - 4) * y);
      }
    };

    Function boundary = new Function() {

      @Override
      public double getValue(Vertex v) {
        return 0;
      }
    };

    fdSolverFirstTestcase = new FiniteDifferenceSolver(force, boundary, m, n);
    fdSolverFirstTestcase.setAlpha(alpha);
    fdSolverFirstTestcase.setBeta(beta);
    fdSolverFirstTestcase.setGamma(gamma);
    fdSolverFirstTestcase.assemble();

    m = 4;
    fdSolverSecondTestcase = new FiniteDifferenceSolver(force, boundary, m, n);
    fdSolverSecondTestcase.setAlpha(alpha);
    fdSolverSecondTestcase.setBeta(beta);
    fdSolverSecondTestcase.setGamma(gamma);
    fdSolverSecondTestcase.assemble();

    alpha = 1.0;
    beta = 0.0;
    gamma = 1.0;
    m = 5;
    n = 5;

    force = new Function() {

      @Override
      public double getValue(Vertex v) {
        return 0;
      }
    };

    boundary = new Function() {
      @Override
      public double getValue(Vertex v) {
        double x = v.getCoordinates()[0];
        double y = v.getCoordinates()[1];
        return Math.exp(x) * Math.sin(y);
      }
    };

    fdSolverThirdTestcase = new FiniteDifferenceSolver(force, boundary, m, n);
    fdSolverThirdTestcase.setAlpha(alpha);
    fdSolverThirdTestcase.setBeta(beta);
    fdSolverThirdTestcase.setGamma(gamma);
    fdSolverThirdTestcase.assemble();
  }

  @Test
  public void testPoissonEquationMatrixSquare() {
    int m = fdSolverFirstTestcase.getM();
    int n = fdSolverFirstTestcase.getN();
    AbstractMatrix systemMatrix = fdSolverFirstTestcase.getSystemMatrix();

    assertEquals((m - 2) * (n - 2), systemMatrix.getRowDimension());
    assertEquals((m - 2) * (n - 2), systemMatrix.getColumnDimension());

    double[][] expectedSystemMatrix = { { 8, -2, 0, -2, 0, 0, 0, 0, 0 },
        { -2, 8, -2, 0, -2, 0, 0, 0, 0 }, { 0, -2, 8, 0, 0, -2, 0, 0, 0 },
        { -2, 0, 0, 8, -2, 0, -2, 0, 0 }, { 0, -2, 0, -2, 8, -2, 0, -2, 0 },
        { 0, 0, -2, 0, -2, 8, 0, 0, -2 }, { 0, 0, 0, -2, 0, 0, 8, -2, 0 },
        { 0, 0, 0, 0, -2, 0, -2, 8, -2 }, { 0, 0, 0, 0, 0, -2, 0, -2, 8 } };

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        assertEquals(expectedSystemMatrix[i][j], systemMatrix.getEntry(i, j), Helper.TOLERANCE);
      }
    }

  }

  @Test
  public void testPoissonEquationRhs() {
    int n = fdSolverFirstTestcase.getN();
    int dim = (n - 2) * (n - 2);
    double gamma = fdSolverFirstTestcase.getGamma();
    Function force = fdSolverFirstTestcase.getForce();
    AbstractVector rhsActual = fdSolverFirstTestcase.getRhs();

    assertEquals(dim, rhsActual.getDimension());

    double[] expectedRhs = new double[9];
    Vertex v;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        v = new Vertex((j + 1), (i + 1));
        expectedRhs[i * 3 + j] = gamma * force.getValue(v);
      }
    }
    for (int i = 0; i < dim; i++) {
      assertEquals(expectedRhs[i], rhsActual.getEntry(i), Helper.TOLERANCE);
    }
  }

  @Test
  public void testPoissonEquationSolution() {
    int n = fdSolverFirstTestcase.getN();
    int dim = n * n;
    Function solution = new Function() {

      @Override
      public double getValue(Vertex v) {
        double x = v.getCoordinates()[0];
        double y = v.getCoordinates()[1];
        return x * (x - 4) * y * (y - 4);
      }
    };
    fdSolverFirstTestcase.solve();
    AbstractVector solutionVector = fdSolverFirstTestcase.getSolution();
    assertEquals(dim, solutionVector.getDimension());

    double[] expectedSolution = new double[dim];
    Vertex v;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        v = new Vertex(j, i);
        expectedSolution[i * n + j] = solution.getValue(v);
      }
    }
    for (int i = 0; i < dim; i++) {
      assertEquals(expectedSolution[i], solutionVector.getEntry(i), Helper.TOLERANCE);
    }
  }

  @Test
  public void testPoissonEquationMatrixRectangular() {
    int m = fdSolverSecondTestcase.getM();
    int n = fdSolverSecondTestcase.getN();
    AbstractMatrix systemMatrix = fdSolverSecondTestcase.getSystemMatrix();

    assertEquals((m - 2) * (n - 2), systemMatrix.getRowDimension());
    assertEquals((m - 2) * (n - 2), systemMatrix.getColumnDimension());

    double[][] expectedSystemMatrix = { { 8, -2, 0, -2, 0, 0 }, { -2, 8, -2, 0, -2, 0 },
        { 0, -2, 8, 0, 0, -2 }, { -2, 0, 0, 8, -2, 0 }, { 0, -2, 0, -2, 8, -2 },
        { 0, 0, -2, 0, -2, 8 } };

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        assertEquals(expectedSystemMatrix[i][j], systemMatrix.getEntry(i, j), Helper.TOLERANCE);
      }
    }

  }

  @Test
  public void testPoissonEquationRhs2() {
    int m = fdSolverThirdTestcase.getM();
    int n = fdSolverThirdTestcase.getN();
    int dim = (m - 2) * (n - 2);
    AbstractVector rhsActual = fdSolverThirdTestcase.getRhs();
    assertEquals(dim, rhsActual.getDimension());

    double[] expectedRhs = new double[dim];
    expectedRhs[0] = Math.sin(1);
    expectedRhs[1] = 0;
    expectedRhs[2] = Math.exp(4) * Math.sin(1);

    expectedRhs[3] = Math.sin(2);
    expectedRhs[4] = 0;
    expectedRhs[5] = Math.exp(4) * Math.sin(2);

    expectedRhs[6] = Math.sin(3) + Math.exp(1) * Math.sin(4);
    expectedRhs[7] = Math.exp(2) * Math.sin(4);
    expectedRhs[8] = Math.exp(3) * Math.sin(4) + Math.exp(4) * Math.sin(3);

    for (int i = 0; i < dim; i++) {
      assertEquals(expectedRhs[i], rhsActual.getEntry(i), Helper.TOLERANCE);
    }
  }

}
