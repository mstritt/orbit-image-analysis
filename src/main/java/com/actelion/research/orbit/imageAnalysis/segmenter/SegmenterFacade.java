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

package com.actelion.research.orbit.imageAnalysis.segmenter;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * The facade provides an interface for detecting cells given an image.
 */
public class SegmenterFacade {

  private static final Color BACKGROUND_COLOR = Color.WHITE;

  /**
   * Detects the cells on an image. A binary mask indicating fore- and background pixels (WHITE =
   * foreground, BLACK = background) is applied on the input image. Every background pixel color is
   * changed to the defined constant value <i>BACKGROUND_COLOR</i>. On this background-filtered
   * image, the class {@link FiniteDifferenceSegmenter} performs the actual cell detection.
   *
   * @param image
   *          functional Original image
   * @param mask
   *          Binary mask (WHITE = foreground, BLACK = background)
   * @param alpha
   *          Value needed by
   *          {@link com.actelion.research.orbit.segmenter.finitedifference.FiniteDifferenceSolver}
   * @param cellRadius
   *          Approximate cell radius in pixel
   * @return Object containing the polygons, a seedpoint per cell and the original image with
   *         polygons and seedpoints overlaid
   */
  public static SegmentedImage detectCells(BufferedImage image, BufferedImage mask, double alpha,
      float cellRadius) {
    BufferedImage bgSegmentedImage = filterBackground(image, mask);
    FiniteDifferenceSegmenter segmenter = new FiniteDifferenceSegmenter(bgSegmentedImage, alpha,
        cellRadius);
    segmenter.segment();
    return new SegmentedImage(segmenter.getPolygons(), segmenter.getSeedPoints(),
        segmenter.getPolygonPaintedImage());
  }

  /**
   * Applies a binary mask on a source image. The mask has to be defined as a
   * BufferedImage.TYPE_BYTE_BINARY image, with Color.BLACK beeing the background and Color.WHITE
   * indicating foreground pixels. Every background pixel color is changed to the defined constant
   * value <i>BACKGROUND_COLOR</i>.
   *
   * @param source
   *          input image
   * @param mask
   *          binary mask (WHITE = foreground, BLACK = background)
   * @return source with every background pixel (following the binary mask) color changed to given
   *         constant <i>BACKGROUND_COLOR</i>
   */
  public static BufferedImage filterBackground(BufferedImage source, BufferedImage mask) {
    BufferedImage target = new BufferedImage(source.getWidth(), source.getHeight(),
        source.getType());

    for (int y = 0; y < source.getHeight(); ++y) {
      for (int x = 0; x < source.getWidth(); ++x) {
        Color c = new Color(source.getRGB(x, y));

        if (mask.getRGB(x, y) == Color.WHITE.getRGB()) {
          target.setRGB(x, y, c.getRGB());
        } else {
          target.setRGB(x, y, BACKGROUND_COLOR.getRGB());
        }
      }
    }

    return target;
  }

}
