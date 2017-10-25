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

package com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.polygon.bordersearch;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple line which contains N points.
 */
public class Line {
  private List<Point> points;

  public interface ILineFunction {
    public void process(Point start, Point end);
  }

  /**
   * Create a new empty line.
   */
  public Line() {
    points = new ArrayList<Point>();
  }

  /**
   * Get all points of the line. (readonly)
   *
   * @return All points.
   */
  public List<Point> getPoints() {
    return Collections.unmodifiableList(points);
  }

  /**
   * Execute a function for each subline.
   * 
   * @param f
   *          A function.
   */
  public void foreachSubLine(ILineFunction f) {
    if (points.size() > 1) {

      /* Maybe parallel (does this work with Graphics2D draw? */
      for (int i = 0; i < points.size() - 1; i++) {
        f.process(points.get(i), points.get(i + 1));
      }
    }
  }

  /**
   * Return the first point if it exists.
   *
   * @return The first point or null.
   */
  public Point first() {
    if (points.isEmpty()) {
      return null;
    }
    return points.get(0);
  }

  /**
   * Return the last point if it exists.
   *
   * @return The last point or null.
   */
  public Point last() {
    if (points.isEmpty()) {
      return null;
    }
    return points.get(points.size() - 1);
  }

  /**
   * Add a new point to the line.
   *
   * @param p
   *          The new point.
   */
  public void add(Point p) {
    if (points.isEmpty() || !points.get(points.size() - 1).equals(p)) {
      points.add(p);
    }
  }

  /**
   * Append a line to the current line.
   *
   * @param l
   *          The new line.
   */
  public void append(Line l) {
    for (Point p : l.getPoints()) {
      add(p);
    }
  }

  /**
   * Convert the line to a polygon.
   *
   * @return The polygon.
   */
  public Polygon toPolygon() {
    int size = points.size();
    if (size > 1 && first().equals(last())) {
      size--;
    }
    int[] xpoints = new int[size];
    int[] ypoints = new int[size];
    for (int i = 0; i < size; i++) {
      Point p = points.get(i);
      xpoints[i] = p.x;
      ypoints[i] = p.y;
    }
    return new Polygon(xpoints, ypoints, size);
  }

  /**
   * Get a smoothed line. It has a new point distance.
   *
   * @param maxDist
   *          The (new) maximum distance between two points.
   * @return The smoothed line-
   */
  public Line getSmoothedLine(int maxDist) {

    /* Test arguments. */
    if (maxDist < 2) {
      Line result = new Line();
      result.points = new ArrayList<Point>(points);
      return result;
    }
    int maxDistSquared = maxDist * maxDist;
    Line result = new Line();

    /* Test simple cases. */
    if (points.size() <= 2) {
      result.points = new ArrayList<Point>(points);
      return result;
    }

    /* Create now the new line. */
    Point current = points.get(0);
    result.add(current);
    int i = 1;
    boolean pointFound = true;
    while (pointFound && i < points.size() - 1) {

      /* Find the farest point with a distance <= maxDist. */
      pointFound = false;
      for (int j = points.size() - 1; j > i; j--) {
        Point p = points.get(j);
        if (result.points.size() == 1) {
          int ldx = last().x - p.x;
          int ldy = last().y - p.y;
          int lastDistSquared = ldx * ldx + ldy * ldy;
          if (lastDistSquared <= maxDistSquared)
            continue;
        }

        int dx = p.x - current.x;
        int dy = p.y - current.y;
        int distSquared = dx * dx + dy * dy;
        if (distSquared <= maxDistSquared || (j == i + 1)) {

          /* Next point found. */
          current = p;
          result.add(current);
          i = j;
          pointFound = true;
          break;
        }
      }
    }
    return result;
  }

  /* An "improved" line algorithm which creates at least a line with three points. */
  // public Line getSmoothedLine2(int maxDist) {
  // if (maxDist < 2) {
  // Line result = new Line();
  // result.points = new ArrayList<Point>(points);
  // return result;
  // }
  // int maxDistSquared = maxDist * maxDist;
  // Line result = new Line();
  // if (points.size() <= 2) {
  // result.points = new ArrayList<Point>(points);
  // return result;
  // }
  // int i_max;
  // Point last = points.get(points.size() - 1);
  // for (i_max = points.size() - 2; i_max >= 0; i_max--) {
  // Point p = points.get(i_max);
  // int dx = p.x - last.x;
  // int dy = p.y - last.y;
  // int distSquared = dx * dx + dy * dy;
  // if (distSquared >= maxDistSquared) {
  // break;
  // }
  // }
  // Point current = points.get(0);
  // result.add(current);
  // int i = 1;
  // boolean pointFound = true;
  // while (pointFound && i < points.size() - 1) {
  //
  // /* Find the farest point with a distance <= maxDist. */
  // pointFound = false;
  // for (int j = i_max; j > i; j--) {
  // Point p = points.get(j);
  // int dx = p.x - current.x;
  // int dy = p.y - current.y;
  // int distSquared = dx * dx + dy * dy;
  // if (distSquared <= maxDistSquared) {
  //
  // /* Next point found. */
  // current = p;
  // result.add(current);
  // i = j;
  // pointFound = true;
  // break;
  // }
  // }
  // }
  // result.add(last);
  // return result;
  // }
}
