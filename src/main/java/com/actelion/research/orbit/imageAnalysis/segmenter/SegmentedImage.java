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

package com.actelion.research.orbit.imageAnalysis.segmenter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Result class of cell detection.
 */
public class SegmentedImage {

  private List<Polygon> polygons;
  private List<Point> seedPoints;
  private BufferedImage polygonPaintedImage;

  /**
   * Construct a result class given the polygons, seed points as well as the original image overlaid
   * with the polygon and seed point information
   *
   * @param polygons
   *          detected polygons, each one representing a cell
   * @param seedPoints
   *          seed point of each cell
   * @param polygonPaintedImage
   *          original image overlaid with the polygons and seed points
   */
  public SegmentedImage(List<Polygon> polygons, List<Point> seedPoints,
      BufferedImage polygonPaintedImage) {
    super();
    this.polygons = polygons;
    this.seedPoints = seedPoints;
    this.polygonPaintedImage = polygonPaintedImage;
  }

  /**
   * Returns the list of deteced polygons
   *
   * @return list of deteced polygons
   */
  public List<Polygon> getPolygons() {
    return polygons;
  }

  /**
   * Returns the list of deteced seed points
   *
   * @return list of detected seed points
   */
  public List<Point> getSeedPoints() {
    return seedPoints;
  }

  /**
   * Returns the original image overlaid with the polygons and seed points
   *
   * @return original image overlaid with the polygons and seed points
   */
  public BufferedImage getPolygonPaintedImage() {
    return polygonPaintedImage;
  }
}
