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

package com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.polygon;

import java.awt.*;
import java.awt.geom.PathIterator;

/**
 * Provides Functionalities for the use of geometric functions
 * 
 * @author Remo
 *
 */
public class GeometricFunctions {

  /**
   * Calculates the Approximate Area of a given Area Object. The Approximation is done, using a
   * smoothed polygon calculation.
   * 
   * @param poly
   *          Area Object
   * @return approximate area size
   */
  public static float calcArea(Polygon poly) {
    float sum = 0;
    float xBegin = 0, yBegin = 0, xPrev = 0, yPrev = 0, coords[] = new float[6];

    // Get a flattened path (curves approximated by straight lines)
    for (PathIterator iterator = poly.getPathIterator(null, 0.1); !iterator.isDone(); iterator
        .next()) {
      switch (iterator.currentSegment(coords)) {
      case PathIterator.SEG_MOVETO:
        xBegin = coords[0];
        yBegin = coords[1];
        break;

      case PathIterator.SEG_LINETO:
        // the well-known trapez-formula
        sum += (coords[0] - xPrev) * (coords[1] + yPrev) / 2.0;
        break;

      case PathIterator.SEG_CLOSE:
        sum += (xBegin - xPrev) * (yBegin + yPrev) / 2.0;
        break;

      default:
        // curved segments cannot occur, because we have a flattened path
        throw new InternalError();
      }
      xPrev = coords[0];
      yPrev = coords[1];
    }
    return sum;
  }
}
