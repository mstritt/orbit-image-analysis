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

import no.uib.cipr.matrix.DenseMatrix;
import no.uib.cipr.matrix.DenseVector;
import no.uib.cipr.matrix.MatrixEntry;
import no.uib.cipr.matrix.sparse.FlexCompRowMatrix;

import java.util.Iterator;

/**
 * {@link AbstractMatrix} implementation using MTJ
 */
public class MtjMatrix implements AbstractMatrix {

  private no.uib.cipr.matrix.AbstractMatrix matrix;

  public MtjMatrix(int rowDimension, int columnDimension, boolean sparse) {
    if (sparse) {
      this.matrix = new FlexCompRowMatrix(rowDimension, columnDimension);
    } else {
      this.matrix = new DenseMatrix(rowDimension, columnDimension);
    }
  }

  public MtjMatrix(double[][] matrix) {
    this.matrix = new DenseMatrix(matrix);
  }

  public MtjMatrix(no.uib.cipr.matrix.AbstractMatrix matrix) {
    this.matrix = matrix;
  }

  /**
   * @see AbstractMatrix#getRowDimension()
   */
  @Override
  public int getRowDimension() {
    return matrix.numRows();
  }

  /**
   * @see AbstractMatrix#getColumnDimension()
   */
  @Override
  public int getColumnDimension() {
    return matrix.numColumns();
  }

  /**
   * @see AbstractMatrix#setEntry(int, int, double)
   */
  @Override
  public void setEntry(int i, int j, double value) {
    this.matrix.set(i, j, value);
  }

  /**
   * @see AbstractMatrix#addToEntry(int, int, double)
   */
  @Override
  public void addToEntry(int i, int j, double value) {
    this.matrix.add(i, j, value);
  }

  /**
   * @see AbstractMatrix#getEntry(int, int)
   */
  @Override
  public double getEntry(int i, int j) {
    return this.matrix.get(i, j);
  }

  /**
   * @see AbstractMatrix#scalarMultiply(double)
   */
  @Override
  public void scalarMultiply(double scalar) {
    this.matrix.scale(scalar);
  }

  /**
   * @see AbstractMatrix#multiply(AbstractMatrix)
   */
  @Override
  public void multiply(AbstractMatrix matrix) {
    if (matrix instanceof MtjMatrix) {
      no.uib.cipr.matrix.AbstractMatrix m = ((MtjMatrix) matrix).getMatrix();
      FlexCompRowMatrix result = new FlexCompRowMatrix(this.matrix.numRows(), m.numColumns());
      this.matrix.mult(m, result);
      this.matrix = result;
    } else {
      throw new UnsupportedOperationException();
    }
  }

  /**
   * @see AbstractMatrix#multiply(AbstractVector)
   */
  @Override
  public AbstractVector multiply(AbstractVector vector) {
    if (vector.getDimension() != this.matrix.numColumns()) {
      throw new IllegalArgumentException("Dimension mismatch");
    }
    if (vector instanceof MtjVector) {
      DenseVector v = ((MtjVector) vector).getVector();
      DenseVector result = new DenseVector(this.matrix.numRows());
      this.matrix.mult(v, result);
      return new MtjVector(result);
    }
    throw new UnsupportedOperationException();
  }

  /**
   * @see AbstractMatrix#getSubMatrix(int, int, int, int)
   */
  @Override
  // optimized for sparse matrices
  // Non optimal for dense matrices (we only need it for sparse matrices)
  public AbstractMatrix getSubMatrix(int startRow, int endRow, int startColumn, int endColumn) {
    if (startRow > endRow) {
      throw new IllegalArgumentException("startRow > endRow");
    }
    if (startColumn > endColumn) {
      throw new IllegalArgumentException("startColumn > endColumn");
    }

    final int n = endRow - startRow + 1;
    final int m = endColumn - startColumn + 1;
    FlexCompRowMatrix subMatrix = new FlexCompRowMatrix(n, m);
    Iterator<MatrixEntry> it = this.matrix.iterator();

    while (it.hasNext()) {
      MatrixEntry entry = it.next();
      int row = entry.row();
      int column = entry.column();
      if (row >= startRow && row <= endRow && column >= startColumn && column <= endColumn) {
        int subMatrixRow = row - startRow;
        int subMatrixColumn = column - startColumn;
        subMatrix.set(subMatrixRow, subMatrixColumn, entry.get());
      }
    }

    return new MtjMatrix(subMatrix);
  }

  /**
   * @see AbstractMatrix#setSubMatrix(AbstractMatrix, int, int)
   */
  @Override
  public void setSubMatrix(AbstractMatrix subMatrix, int row, int column) {
    if (subMatrix instanceof MtjMatrix) {
      no.uib.cipr.matrix.AbstractMatrix s = ((MtjMatrix) subMatrix).getMatrix();
      Iterator<MatrixEntry> it = s.iterator();
      while (it.hasNext()) {
        MatrixEntry entry = it.next();
        int i = row + entry.row();
        int j = column + entry.column();
        double value = entry.get();
        this.matrix.set(i, j, value);
      }
    }
  }

  /**
   * @see AbstractMatrix#add(AbstractMatrix)
   */
  @Override
  public AbstractMatrix add(AbstractMatrix m) {
    if (m instanceof MtjMatrix) {
      no.uib.cipr.matrix.AbstractMatrix result = (no.uib.cipr.matrix.AbstractMatrix) this.matrix
          .add(((MtjMatrix) m).getMatrix());
      return new MtjMatrix(result);
    }
    throw new UnsupportedOperationException();
  }

  public no.uib.cipr.matrix.AbstractMatrix getMatrix() {
    return this.matrix;
  }

}
