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

package com.actelion.research.orbit.imageAnalysis.segmenter.geometry;

/**
 * Class represents a pixel in an image or point on a discretized two dimensional function
 */
public class Vertex {
  private static final int DIMENSION = 2;

  private double[] coordinates;

  /**
   * Constructs a vertex
   *
   * @param x
   *          X coordinate
   * @param y
   *          Y coordinate
   */
  public Vertex(double x, double y) {
    super();
    this.coordinates = new double[DIMENSION];
    this.coordinates[0] = x;
    this.coordinates[1] = y;
  }

  /**
   * Get coordinates of vertex
   *
   * @return coordinates of vertex
   */
  public double[] getCoordinates() {
    return coordinates;
  }

  /**
   * Calculates and returns the euclidian distance between two vertices
   *
   * @param a
   *          vertex a
   * @param b
   *          vertex b
   * @return euclidian distance between two vertices
   */
  public static double calculateDistance(Vertex a, Vertex b) {
    double sum = 0.0;
    for (int i = 0; i < DIMENSION; i++) {
      double diff = a.getCoordinates()[i] - b.getCoordinates()[i];
      sum += (diff * diff);
    }
    return Math.sqrt(sum);
  }
}
