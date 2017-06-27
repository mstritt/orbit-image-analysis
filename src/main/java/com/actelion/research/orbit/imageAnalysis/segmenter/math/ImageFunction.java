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

package com.actelion.research.orbit.imageAnalysis.segmenter.math;


import com.actelion.research.orbit.imageAnalysis.segmenter.geometry.Vertex;

import java.awt.image.BufferedImage;

/**
 * Implementation of {@link Function} for getting the pixel value of an image as a function
 */
public class ImageFunction extends Function {

  private BufferedImage image;

  /**
   * Creates a function given an image
   *
   * @param image
   *          image on which the pixel values are read
   */
  public ImageFunction(BufferedImage image) {
    this.image = image;
  }

  /**
   * @see Function#getValue(Vertex)
   */
  @Override
  public double getValue(Vertex v) {
    int x = (int) v.getCoordinates()[0];
    int y = (int) v.getCoordinates()[1];

    if (x > this.image.getWidth() - 1) {
      x = this.image.getWidth() - 1;
    }

    if (y > this.image.getHeight() - 1) {
      y = this.image.getHeight() - 1;
    }

    return image.getRGB(x, y) & 0xFF;
  }

}
