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

//The names of the methods were copied from the interface org.apache.commons.math4.linear.RealMatrix

/**
 * Wrapper for abstract vector
 */
public interface AbstractVector {

  /**
   * Returns the dimension of the vector
   *
   * @return dimension of the vector
   */
  int getDimension();

  /**
   * Add a value to a specific entry
   *
   * @param index
   *          index of the entry
   * @param increment
   *          value to add
   */
  void addToEntry(int index, double increment);

  /**
   * Sets a new value for a specific entry
   *
   * @param index
   *          index of the entry
   * @param value
   *          value to set
   */
  void setEntry(int index, double value);

  /**
   * Returns the value for a specific entry
   *
   * @param index
   *          index of the entry
   * @return value at index
   */
  double getEntry(int index);

  /**
   * Subtracts a vector and return the resulting vector
   *
   * @param v
   *          vector to substract
   * @return resulting vector
   */
  AbstractVector subtract(AbstractVector v);

  /**
   * Returns a subvector
   *
   * @param index
   *          start index
   * @param n
   *          number of entries
   * @return subvector
   */
  AbstractVector getSubVector(int index, int n);

  /**
   * Multiplies every entry by a scalar value
   *
   * @param scalar
   *          scalar value to multiply with
   */
  void multiply(double scalar);

  /**
   * Sets all the values from a specified subvector
   *
   * @param index
   *          start index
   * @param v
   *          subvector
   */
  void setSubVector(int index, AbstractVector v);

}
