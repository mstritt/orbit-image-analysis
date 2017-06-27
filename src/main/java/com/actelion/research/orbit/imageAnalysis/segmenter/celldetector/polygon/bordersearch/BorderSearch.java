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

package com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.polygon.bordersearch;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

/**
 * This class can be used to search a border of a given object-
 */
public class BorderSearch {

  /**
   * A wrapper which simulates a simple upscaling image.
   */
  private static class ScaledImageWrapper {
    private BufferedImage img;
    private int scale;
    private int width;
    private int height;

    /**
     * Create a new wrapper.
     *
     * @param img
     *          The image.
     * @param scale
     *          The scale factor (>= 1)
     */
    public ScaledImageWrapper(BufferedImage img, int scale) {
      if (scale < 1) {
        throw new IllegalArgumentException();
      }
      this.img = img;
      this.scale = scale;
      this.width = img.getWidth() * scale;
      this.height = img.getHeight() * scale;
    }

    /**
     * Get the width.
     *
     * @return The width.
     */
    public int getWidth() {
      return width;
    }

    /**
     * Get the height.
     *
     * @return The height.
     */
    public int getHeight() {
      return height;
    }

    /**
     * Get the RGB value for a specifc pixel.
     *
     * @param x
     *          x coordinate
     * @param y
     *          y coordinate
     * @return The RGB value.
     */
    public int getRGB(int x, int y) {
      return img.getRGB(x / scale, y / scale);
    }
  };

  private static final int IMG_SCALE = 2;
  private BufferedImage image;
  private ScaledImageWrapper scaledImage;
  private Color background;
  private Point start;
  private Point center;
  private boolean inverseCenterLogic;
  private Set<Point> end;
  private Line result;

  /**
   * Search a border.
   *
   * @param image
   *          The source image.
   * @param center
   *          The center of the object (it is used to define the search direction).
   * @param start
   *          The start point. It must be at the border and on the object.
   * @param end
   *          The possible end points. The set may be empty then the full object will be searched.
   * @param background
   *          The background color.
   * @return The found line.
   */
  public Line search(BufferedImage image, Point center, Point start, Set<Point> end,
      Color background) {
    return search(image, center, start, end, background, false);
  }

  /**
   * Search a border.
   *
   * @param image
   *          The source image.
   * @param center
   *          The center of the object (it is used to define the search direction).
   * @param start
   *          The start point. It must be at the border and on the object.
   * @param end
   *          The possible end points. The set may be empty then the full object will be searched.
   * @param background
   *          The background color.
   * @param inverseCenterLogic
   *          Inverse the center logic: First check the cells which are most far away from the
   *          center.
   * @return The found line.
   */
  public Line search(BufferedImage image, Point center, Point start, Set<Point> end,
      Color background, boolean inverseCenterLogic) {
    this.result = new Line();
    this.image = image;
    this.center = center;
    this.background = background;
    this.start = start;
    this.end = end;
    this.inverseCenterLogic = inverseCenterLogic;
    prepare();

    for (Point p : getStartPoints()) {
      this.start = p;
      result = new Line();
      start();
      if (result.getPoints().size() > 1) {
        break;
      }
    }

    return result;
  }

  private List<Point> getStartPoints() {
    List<Point> result = new ArrayList<Point>();
    result.add(start);
    result.add(new Point(start.x + 1, start.y + 1));
    result.add(new Point(start.x + 1, start.y + 0));
    result.add(new Point(start.x + 0, start.y + 1));
    return result;
  }

  private void prepare() {
    int scale = IMG_SCALE;
    this.scaledImage = new ScaledImageWrapper(image, scale);
    center = new Point(scale * center.x, scale * center.y);
    start = new Point(start.x * scale, start.y * scale);
    Set<Point> endTmp = end;
    end = new HashSet<Point>();
    if (endTmp != null) {
      for (Point p : endTmp) {
        for (int x = 0; x < scale; x++) {
          for (int y = 0; y < scale; y++) {
            end.add(new Point(p.x * scale + x, p.y * scale + y));
          }
        }
      }
    }
  }

  /**
   * Add a point to the result.
   *
   * @param p
   *          The new point.
   */
  private void addPoint(Point p) {
    result.add(new Point(p.x / IMG_SCALE, p.y / IMG_SCALE));
  }

  private void start() {
    Stack<Point> callStack = new Stack<Point>();
    Set<Point> usedPoints = new HashSet<Point>();

    addPoint(start);
    usedPoints.add(start);

    /* Black: foreground, White: background. */

    Point current = start;
    while (true) {

      Point next = null;
      callStack.push(current);
      while (next == null && !callStack.isEmpty()) {
        current = callStack.pop();

        /* Get all neighbors. */
        Set<Point> whiteNeighbors = filterPixels(getNeighbors(current, false), false);
        Set<Point> blackNeighbors = filterPixels(getNeighbors(current, true), true);

        for (Point neighbor : sort(blackNeighbors)) {

          /* Only check new points. */
          if (usedPoints.contains(neighbor)) {
            continue;
          }

          /* Get all white neighbors. */
          Set<Point> nwb = filterPixels(getNeighbors(neighbor, false), false);
          Set<Point> whiteInt = intersect(whiteNeighbors, nwb);

          /* The new point must at least share one white neighbor. */
          if (whiteInt.isEmpty()) {
            continue;
          }

          next = neighbor;
          break;
        }

        /* Maybe we reached the end? Then next is null and the start is a neighbor. */
        if (next == null && blackNeighbors.contains(start)) {
          break;
        }
      }

      /* Was a next points found? */
      if (next == null) {
        break;
      }

      /* And go. */
      callStack.push(current);
      usedPoints.add(next);
      addPoint(next);
      current = next;
      if (end.contains(current)) {
        break;
      }
    }
  }

  /**
   * Sort the points in a way that the point which is the nearest to the center is returned first.
   *
   * @param points
   *          The points.
   * @return The sorted points.
   */
  private List<Point> sort(Set<Point> points) {
    List<Point> res = new ArrayList<Point>(points);
    final int reverse = inverseCenterLogic ? -1 : 1;
    res.sort(new Comparator<Point>() {

      @Override
      public int compare(Point p1, Point p2) {
        return reverse
            * Integer.compare((int) (10 * center.distance(p1)), (int) (10 * center.distance(p2)));
      };

    });
    return res;
  }

  private Set<Point> getNeighbors(Point start, boolean onlyVertHor) {

    /* Get one neighbor out of image but not more. */
    int x = start.x;
    int y = start.y;

    int x_start = Math.max(x - 1, -1);
    int y_start = Math.max(y - 1, -1);
    int x_end = Math.min(scaledImage.getWidth(), x + 1);
    int y_end = Math.min(scaledImage.getHeight(), y + 1);

    Set<Point> res = new HashSet<Point>();
    for (int xc = x_start; xc <= x_end; xc++) {
      for (int yc = y_start; yc <= y_end; yc++) {
        if (!(xc == x && yc == y)) {

          if (onlyVertHor) {
            if (xc == x || yc == y)
              res.add(new Point(xc, yc));
          } else {
            res.add(new Point(xc, yc));
          }
        }
      }
    }
    return res;
  }

  private Set<Point> filterPixels(Set<Point> pixels, boolean foreground) {
    Set<Point> res = new HashSet<Point>();
    for (Point p : pixels) {
      if (isForeground(p) == foreground) {
        res.add(p);
      }
    }
    return res;
  }

  private Set<Point> intersect(Set<Point> p1, Set<Point> p2) {
    Set<Point> res = new HashSet<Point>();
    for (Point p : p1) {
      if (p2.contains(p)) {
        res.add(p);
      }
    }
    return res;
  }

  private boolean isForeground(int x, int y) {
    if (x < 0 || x >= scaledImage.getWidth() || y < 0 || y >= scaledImage.getHeight()) {
      return false;
    }
    return scaledImage.getRGB(x, y) != background.getRGB();
  }

  private boolean isForeground(Point p) {
    if (p == null) {
      return false;
    }
    return isForeground(p.x, p.y);
  }
}
