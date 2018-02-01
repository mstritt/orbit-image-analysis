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

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.OpenMapRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

/**
 * {@link AbstractMatrix} implementation using Apache Math
 */
public class ApacheMatrix implements AbstractMatrix {

  private RealMatrix matrix;

  public ApacheMatrix(int rowDimension, int columnDimension, boolean sparse) {
    if (sparse) {
      this.matrix = new OpenMapRealMatrix(rowDimension, columnDimension);
    } else {
      this.matrix = new Array2DRowRealMatrix(rowDimension, columnDimension);
    }
  }

  public ApacheMatrix(double[][] m) {
    this.matrix = new Array2DRowRealMatrix(m);
  }

  private ApacheMatrix(RealMatrix m) {
    this.matrix = m;
  }

  /**
   * @see AbstractMatrix#getRowDimension()
   */
  @Override
  public int getRowDimension() {
    return this.matrix.getRowDimension();
  }

  /**
   * @see AbstractMatrix#getColumnDimension()
   */
  @Override
  public int getColumnDimension() {
    return this.matrix.getColumnDimension();
  }

  /**
   * @see AbstractMatrix#setEntry(int, int, double)
   */
  @Override
  public void setEntry(int i, int j, double value) {
    this.matrix.setEntry(i, j, value);
  }

  /**
   * @see AbstractMatrix#addToEntry(int, int, double)
   */
  @Override
  public void addToEntry(int i, int j, double value) {
    this.matrix.addToEntry(i, j, value);
  }

  /**
   * @see AbstractMatrix#getEntry(int, int)
   */
  @Override
  public double getEntry(int i, int j) {
    return matrix.getEntry(i, j);
  }

  /**
   * @see AbstractMatrix#scalarMultiply(double)
   */
  @Override
  public void scalarMultiply(double scalar) {
    this.matrix = matrix.scalarMultiply(scalar);
  }

  /**
   * @see AbstractMatrix#multiply(AbstractMatrix)
   */
  @Override
  public void multiply(AbstractMatrix m) {
    if (m instanceof ApacheMatrix) {
      this.matrix = this.matrix.multiply(((ApacheMatrix) m).getMatrix());
    } else {
      throw new UnsupportedOperationException();
    }

  }

  /**
   * @see AbstractMatrix#multiply(AbstractVector)
   */
  @Override
  public AbstractVector multiply(AbstractVector vector) {
    if (vector instanceof ApacheVector) {
      RealVector vec = this.matrix.operate(((ApacheVector) vector).getVector());
      return new ApacheVector(vec);
    }
    throw new UnsupportedOperationException();
  }

  /**
   * @see AbstractMatrix#getSubMatrix(int, int, int, int)
   */
  @Override
  public AbstractMatrix getSubMatrix(int startRow, int endRow, int startColumn, int endColumn) {
    RealMatrix subMatrix = this.matrix.getSubMatrix(startRow, endRow, startColumn, endColumn);
    return new ApacheMatrix(subMatrix);
  }

  /**
   * @see AbstractMatrix#setSubMatrix(AbstractMatrix, int, int)
   */
  @Override
  public void setSubMatrix(AbstractMatrix subMatrix, int row, int column) {
    throw new UnsupportedOperationException();
  }

  /**
   * @see AbstractMatrix#add(AbstractMatrix)
   */
  @Override
  public AbstractMatrix add(AbstractMatrix m) {
    if (m instanceof ApacheMatrix) {
      RealMatrix result = this.matrix.add(((ApacheMatrix) m).getMatrix());
      return new ApacheMatrix(result);
    }
    throw new UnsupportedOperationException();
  }

  public RealMatrix getMatrix() {
    return this.matrix;
  }

}
