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

package com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.polygon;

import java.awt.*;
import java.util.ArrayList;

public class QuickHull {
  @SuppressWarnings("unchecked")
  public ArrayList<Point> quickHull(ArrayList<Point> points) {
    ArrayList<Point> convexHull = new ArrayList<Point>();
    if (points.size() < 3)
      return (ArrayList<Point>) points.clone();

    int minPoint = -1, maxPoint = -1;
    int minX = Integer.MAX_VALUE;
    int maxX = Integer.MIN_VALUE;
    for (int i = 0; i < points.size(); i++) {
      if (points.get(i).x < minX) {
        minX = points.get(i).x;
        minPoint = i;
      }
      if (points.get(i).x > maxX) {
        maxX = points.get(i).x;
        maxPoint = i;
      }
    }
    Point A = points.get(minPoint);
    Point B = points.get(maxPoint);
    convexHull.add(A);
    convexHull.add(B);
    points.remove(A);
    points.remove(B);

    ArrayList<Point> leftSet = new ArrayList<Point>();
    ArrayList<Point> rightSet = new ArrayList<Point>();

    for (int i = 0; i < points.size(); i++) {
      Point p = points.get(i);
      if (pointLocation(A, B, p) == -1)
        leftSet.add(p);
      else if (pointLocation(A, B, p) == 1)
        rightSet.add(p);
    }
    hullSet(A, B, rightSet, convexHull);
    hullSet(B, A, leftSet, convexHull);

    return convexHull;
  }

  public int distance(Point A, Point B, Point C) {
    int ABx = B.x - A.x;
    int ABy = B.y - A.y;
    int num = ABx * (A.y - C.y) - ABy * (A.x - C.x);
    if (num < 0)
      num = -num;
    return num;
  }

  public void hullSet(Point A, Point B, ArrayList<Point> set, ArrayList<Point> hull) {
    int insertPosition = hull.indexOf(B);
    if (set.size() == 0)
      return;
    if (set.size() == 1) {
      Point p = set.get(0);
      set.remove(p);
      hull.add(insertPosition, p);
      return;
    }
    int dist = Integer.MIN_VALUE;
    int furthestPoint = -1;
    for (int i = 0; i < set.size(); i++) {
      Point p = set.get(i);
      int distance = distance(A, B, p);
      if (distance > dist) {
        dist = distance;
        furthestPoint = i;
      }
    }
    Point P = set.get(furthestPoint);
    set.remove(furthestPoint);
    hull.add(insertPosition, P);

    // Determine who's to the left of AP
    ArrayList<Point> leftSetAP = new ArrayList<Point>();
    for (int i = 0; i < set.size(); i++) {
      Point M = set.get(i);
      if (pointLocation(A, P, M) == 1) {
        leftSetAP.add(M);
      }
    }

    // Determine who's to the left of PB
    ArrayList<Point> leftSetPB = new ArrayList<Point>();
    for (int i = 0; i < set.size(); i++) {
      Point M = set.get(i);
      if (pointLocation(P, B, M) == 1) {
        leftSetPB.add(M);
      }
    }
    hullSet(A, P, leftSetAP, hull);
    hullSet(P, B, leftSetPB, hull);

  }

  public int pointLocation(Point A, Point B, Point P) {
    int cp1 = (B.x - A.x) * (P.y - A.y) - (B.y - A.y) * (P.x - A.x);
    if (cp1 > 0)
      return 1;
    else if (cp1 == 0)
      return 0;
    else
      return -1;
  }

}
