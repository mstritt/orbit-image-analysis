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

package com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.imageprocessing;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorModel;

/**
 * <p>
 * Provides an abstract implementation of the <code>BufferedImageOp</code> interface. This class can
 * be used to created new image filters based on <code>BufferedImageOp</code>.
 * </p>
 *
 * @author Romain Guy <romain.guy@mac.com>
 */

abstract class AbstractFilter implements BufferedImageOp {
  @Override
  public abstract BufferedImage filter(BufferedImage src, BufferedImage dest);

  /**
   * {@inheritDoc}
   */
  @Override
  public Rectangle2D getBounds2D(BufferedImage src) {
    return new Rectangle(0, 0, src.getWidth(), src.getHeight());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public BufferedImage createCompatibleDestImage(BufferedImage src, ColorModel destCM) {
    if (destCM == null) {
      destCM = src.getColorModel();
    }

    return new BufferedImage(destCM,
        destCM.createCompatibleWritableRaster(src.getWidth(), src.getHeight()),
        destCM.isAlphaPremultiplied(), null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Point2D getPoint2D(Point2D srcPt, Point2D dstPt) {
    return (Point2D) srcPt.clone();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public RenderingHints getRenderingHints() {
    return null;
  }
}
