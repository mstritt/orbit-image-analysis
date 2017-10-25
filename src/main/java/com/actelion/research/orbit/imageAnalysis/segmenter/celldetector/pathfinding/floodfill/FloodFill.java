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

package com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.pathfinding.floodfill;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * FloodFill Algorithm which allows to check, if 2 points on a raster are connected.
 * 
 * The FloodFill checks only horizontal and vertical connections between pixels. So vertical
 * neighbors are not processed
 * 
 * @author Remo
 */
public class FloodFill {
  private int width;
  private int height;
  private boolean checked[][];
  private Deque<Integer> xvalues;
  private Deque<Integer> yvalues;

  /**
   * Initializes the flood fill structures
   * 
   * @param width
   *          width of the raster
   * @param height
   *          height of the raster
   */
  public FloodFill(int width, int height) {
    this.width = width;
    this.height = height;
    this.xvalues = new ArrayDeque<Integer>(width * height);
    this.yvalues = new ArrayDeque<Integer>(width * height);
    this.checked = new boolean[height][width];
  }

  /**
   * Resets all data structures
   */
  private void resetData() {
    xvalues.clear();
    yvalues.clear();

    for (int y = 0; y < height; ++y) {
      for (int x = 0; x < width; ++x) {
        checked[y][x] = false;
      }
    }
  }

  /**
   * Appends a flood fill algorithm on the given image. The function tries to reach the end point
   * from the start point horizontal and vertical pixel neighbors
   * 
   * diagonal connections are ignored
   * 
   * @param img
   *          Image to which the algorithm should be applied
   * @param p1
   *          Point1 on the grid
   * @param p2
   *          Point2 on the grid
   * @return
   */
  public boolean arePointsConnected(BufferedImage img, Point p1, Point p2, int bgColor) {
    boolean pointFound = false;

    // reset data structures
    resetData();

    // add initial point
    checked[p1.y][p1.x] = true;
    yvalues.push(p1.y);
    xvalues.push(p1.x);

    // do flood fill
    while (!xvalues.isEmpty() && !pointFound) {
      int y = yvalues.pop();
      int x = xvalues.pop();
      int xi;
      int yi;

      // Check right pixel
      if (x < width - 1) {
        xi = x + 1;
        yi = y;
        if (xi == p2.x && yi == p2.y) {
          pointFound = true;
        } else if (!checked[yi][xi] && img.getRGB(xi, yi) != bgColor) {
          checked[yi][xi] = true;
          yvalues.push(yi);
          xvalues.push(xi);
        }
      }

      // Check left pixel
      if (x > 0) {
        xi = x - 1;
        yi = y;
        if (xi == p2.x && yi == p2.y) {
          pointFound = true;
        } else if (!checked[yi][xi] && img.getRGB(xi, yi) != bgColor) {
          checked[yi][xi] = true;
          yvalues.push(yi);
          xvalues.push(xi);
        }
      }

      // Check bottom Pixel
      if (y < height - 1) {
        xi = x;
        yi = y + 1;
        if (xi == p2.x && yi == p2.y) {
          pointFound = true;
        } else if (!checked[yi][xi] && img.getRGB(xi, yi) != bgColor) {
          checked[yi][xi] = true;
          yvalues.push(yi);
          xvalues.push(xi);
        }
      }

      // Check top Pixel
      if (y > 0) {
        xi = x;
        yi = y - 1;
        if (xi == p2.x && yi == p2.y) {
          pointFound = true;
        } else if (!checked[yi][xi] && img.getRGB(xi, yi) != bgColor) {
          checked[yi][xi] = true;
          yvalues.push(yi);
          xvalues.push(xi);
        }
      }
    }

    return pointFound;
  }
}
