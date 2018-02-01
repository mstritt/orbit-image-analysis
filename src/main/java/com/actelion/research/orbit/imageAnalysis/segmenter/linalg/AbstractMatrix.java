/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2018 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
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

// The names of the methods were copied from the interface org.apache.commons.math4.linear.RealMatrix

/**
 * Wrapper interface for abstract matrices
 */
public interface AbstractMatrix {

  /**
   * Returns the row dimension of the matrix
   *
   * @return row dimension of the matrix
   */
  int getRowDimension();

  /**
   * Returns the column dimension of the matrix
   *
   * @return column dimension of the matrix
   */
  int getColumnDimension();

  /**
   * Sets a specific value in the matrix
   *
   * @param i
   *          row index
   * @param j
   *          column index
   * @param value
   *          new value
   */
  void setEntry(int i, int j, double value);

  /**
   * Adds a value to a specific entry in the matrix
   *
   * @param i
   *          row index
   * @param j
   *          column index
   * @param value
   *          value to add
   */
  void addToEntry(int i, int j, double value);

  /**
   * Returns the value of a specific entry in the matrix
   *
   * @param i
   *          row index
   * @param j
   *          column index
   * @return value at entry (i,j)
   */
  double getEntry(int i, int j);

  /**
   * Multiplies every entry in the matrix by a scalar
   *
   * @param scalar
   *          value to multiply with
   */
  void scalarMultiply(double scalar);

  /**
   * Performs a matrix-matrix multiplication and stores the resulting matrix
   *
   * @param matrix
   *          matrix to multiply with
   */
  void multiply(AbstractMatrix matrix);

  /**
   * Performs a matrix-vector multiplication and returns the resulting vector
   *
   * @param vector
   *          vector to multiply with
   * @return resulting vector
   */
  AbstractVector multiply(AbstractVector vector);

  /**
   * Return a submatrix
   *
   * @param startRow
   *          start row index
   * @param endRow
   *          end row index (inclusive)
   * @param startColumn
   *          start column index
   * @param endColumn
   *          end column index (inclusive)
   * @return submatrix
   */
  AbstractMatrix getSubMatrix(int startRow, int endRow, int startColumn, int endColumn);

  /**
   * Sets all the values from a specified submatrix
   *
   * @param subMatrix
   *          submatrix
   * @param row
   *          top left row index
   * @param column
   *          top left column index
   */
  void setSubMatrix(AbstractMatrix subMatrix, int row, int column);

  /**
   * Performs a matrix addition and returns the resulting matrix
   *
   * @param m
   *          matrix to add
   * @return resulting matrix after addition
   */
  AbstractMatrix add(AbstractMatrix m);
}
