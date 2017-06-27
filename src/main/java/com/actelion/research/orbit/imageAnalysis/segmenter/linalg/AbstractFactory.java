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

package com.actelion.research.orbit.imageAnalysis.segmenter.linalg;

/**
 * Wrapper class to abstract underlying Linear Algebra library. Sparse and dense matrices, vectors
 * and a solver can be created.
 */
public class AbstractFactory {

  private static final int MTJ = 0;
  private static final int APACHE = 1;

  private static final int FRAMEWORK = MTJ;

  /**
   * Creates and returns a sparse matrix
   *
   * @param rowDimension
   *          row dimension of matrix
   * @param columnDimension
   *          column dimension of matrix
   * @return sparse matrix
   */
  public static AbstractMatrix createSparseMatrix(int rowDimension, int columnDimension) {
    final boolean isSparse = true;
    switch (FRAMEWORK) {
    case MTJ:
      return new MtjMatrix(rowDimension, columnDimension, isSparse);
    case APACHE:
      return new ApacheMatrix(rowDimension, columnDimension, isSparse);
    default:
      assert (false);
    }
    return null;
  }

  /**
   * Creates and returns a dense matrix
   *
   * @param rowDimension
   *          row dimension of matrix
   * @param columnDimension
   *          column dimension of matrix
   * @return dense matrix
   */
  public static AbstractMatrix createDenseMatrix(int rowDimension, int columnDimension) {
    final boolean isSparse = false;
    switch (FRAMEWORK) {
    case MTJ:
      return new MtjMatrix(rowDimension, columnDimension, isSparse);
    case APACHE:
      return new ApacheMatrix(rowDimension, columnDimension, isSparse);
    default:
      assert (false);
    }
    return null;
  }

  /**
   * Creates and returns a dense matrix based on a two dimensional array
   *
   * @param matrix
   *          two dimensional array
   * @return dense matrix
   */
  public static AbstractMatrix createDenseMatrix(double[][] matrix) {
    switch (FRAMEWORK) {
    case MTJ:
      return new MtjMatrix(matrix);
    case APACHE:
      return new ApacheMatrix(matrix);
    default:
      assert (false);
    }
    return null;
  }

  /**
   * Creates and returns a solver
   *
   * @return solver
   */
  public static AbstractSolver createSolver() {
    switch (FRAMEWORK) {
    case MTJ:
      return new MtjSolver();
    case APACHE:
      return new ApacheSolver();
    default:
      assert (false);
    }
    return null;
  }

  /**
   * Creates and returns a vector
   *
   * @param dimension
   *          dimension of vector
   * @return vector
   */
  public static AbstractVector createVector(int dimension) {
    switch (FRAMEWORK) {
    case MTJ:
      return new MtjVector(dimension);
    case APACHE:
      return new ApacheVector(dimension);
    default:
      assert (false);
    }
    return null;
  }

}
