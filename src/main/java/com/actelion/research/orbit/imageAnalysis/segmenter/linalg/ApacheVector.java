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

package com.actelion.research.orbit.imageAnalysis.segmenter.linalg;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

/**
 * {@link ApacheVector} implementation using Apache Math
 */
public class ApacheVector implements AbstractVector {

  private RealVector vector;

  public ApacheVector(int dimension) {
    this.vector = new ArrayRealVector(dimension);
  }

  public ApacheVector(RealVector vector) {
    this.vector = vector;
  }

  /**
   * @see ApacheVector#getDimension()
   */
  @Override
  public int getDimension() {
    return this.vector.getDimension();
  }

  /**
   * @see ApacheVector#addToEntry(int, double)
   */
  @Override
  public void addToEntry(int index, double increment) {
    this.vector.addToEntry(index, increment);
  }

  /**
   * @see ApacheVector#setEntry(int, double)
   */
  @Override
  public void setEntry(int index, double value) {
    this.vector.setEntry(index, value);
  }

  /**
   * @see ApacheVector#getEntry(int)
   */
  @Override
  public double getEntry(int index) {
    return this.vector.getEntry(index);
  }

  /**
   * @see ApacheVector#subtract(AbstractVector)
   */
  @Override
  public AbstractVector subtract(AbstractVector v) {
    if (v instanceof ApacheVector) {
      RealVector vec = this.vector.subtract(((ApacheVector) v).getVector());
      return new ApacheVector(vec);
    }
    throw new UnsupportedOperationException();
  }

  /**
   * @see ApacheVector#getSubVector(int, int)
   */
  @Override
  public AbstractVector getSubVector(int index, int n) {
    RealVector vector = this.vector.getSubVector(index, n);
    return new ApacheVector(vector);
  }

  /**
   * @see ApacheVector#multiply(double)
   */
  @Override
  public void multiply(double scalar) {
    this.vector.mapMultiplyToSelf(scalar);
  }

  public RealVector getVector() {
    return vector;
  }

  /**
   * @see ApacheVector#setSubVector(int, AbstractVector)
   */
  @Override
  public void setSubVector(int index, AbstractVector v) {
    if (v instanceof ApacheVector) {
      RealVector vec = ((ApacheVector) v).getVector();
      this.vector.setSubVector(index, vec);
    } else {
      throw new UnsupportedOperationException();
    }
  }

}
