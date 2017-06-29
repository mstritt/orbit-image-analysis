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

import no.uib.cipr.matrix.DenseVector;

/**
 * {@link ApacheVector} implementation using MTJ
 */
public class MtjVector implements AbstractVector {

  private DenseVector vector;

  public MtjVector(int dimension) {
    this.vector = new DenseVector(dimension);
    this.vector.zero();
  }

  public MtjVector(DenseVector vector) {
    this.vector = vector;
  }

  /**
   * @see ApacheVector#getDimension()
   */
  @Override
  public int getDimension() {
    return this.vector.size();
  }

  /**
   * @see ApacheVector#addToEntry(int, double)
   */
  @Override
  public void addToEntry(int index, double increment) {
    this.vector.add(index, increment);
  }

  /**
   * @see ApacheVector#setEntry(int, double)
   */
  @Override
  public void setEntry(int index, double value) {
    this.vector.set(index, value);
  }

  /**
   * @see ApacheVector#getEntry(int)
   */
  @Override
  public double getEntry(int index) {
    return this.vector.get(index);
  }

  /**
   * @see ApacheVector#subtract(AbstractVector)
   */
  @Override
  public AbstractVector subtract(AbstractVector v) {
    if (v instanceof MtjVector) {
      DenseVector tmp = ((MtjVector) v).getVector();
      tmp.scale(-1);
      tmp.add(this.vector);
      return new MtjVector(tmp);
    } else {
      throw new UnsupportedOperationException();
    }
  }

  /**
   * @see ApacheVector#getSubVector(int, int)
   */
  @Override
  public AbstractVector getSubVector(int index, int n) {
    DenseVector subVector = new DenseVector(n);
    for (int i = index, j = 0; i < index + n; i++, j++) {
      double value = this.vector.get(i);
      subVector.set(j, value);
    }
    return new MtjVector(subVector);
  }

  /**
   * @see ApacheVector#multiply(double)
   */
  @Override
  public void multiply(double scalar) {
    this.vector.scale(scalar);
  }

  /**
   * @see ApacheVector#setSubVector(int, AbstractVector)
   */
  @Override
  public void setSubVector(int index, AbstractVector v) {
    for (int i = index, j = 0; i < index + v.getDimension(); i++, j++) {
      double value = v.getEntry(j);
      this.vector.set(i, value);
    }
  }

  public DenseVector getVector() {
    return vector;
  }

}
