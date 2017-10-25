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

package com.actelion.research.orbit.imageAnalysis.segmenter.math;


import com.actelion.research.orbit.imageAnalysis.segmenter.geometry.Vertex;
import com.actelion.research.orbit.imageAnalysis.segmenter.linalg.AbstractFactory;
import com.actelion.research.orbit.imageAnalysis.segmenter.linalg.AbstractVector;

import java.util.List;

/**
 * Abstract class representing a two dimensional function
 */
public abstract class Function {

  /**
   * Returns a value at a given point
   *
   * @param v
   *          vertex representing the point where to evaluate the function
   * @return function value at given point
   */
  public abstract double getValue(Vertex v);

  /**
   * Returns all the function values for all given two dimensional points
   *
   * @param vertices
   *          list of vertices representing the points where to evaluate the function
   * @return vector of function values for all specified points
   */
  public AbstractVector getValues(List<Vertex> vertices) {
    final int n = vertices.size();
    AbstractVector result = AbstractFactory.createVector(n);

    for (int i = 0; i < n; i++) {
      Vertex v = vertices.get(i);
      result.setEntry(i, this.getValue(v));
    }

    return result;
  }
}
