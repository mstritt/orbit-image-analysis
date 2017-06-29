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

import com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.imageprocessing.ImageFunctions;
import com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.imageprocessing.ccl.ImageObject;
import com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.imageprocessing.ccl.Pixel;
import com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.pathfinding.astar.AStarMap;
import com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.pathfinding.floodfill.FloodFill;
import com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.polygon.bordersearch.BorderSearch;
import com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.polygon.bordersearch.Line;
import com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.polygon.voronoi.GraphEdge;
import com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.polygon.voronoi.Voronoi;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

public class PolygonExtractor {
  private final static Color BACKGROUND_COLOR = Color.WHITE;
  private final static boolean ENABLE_ASTAR_ALGORITHM = true;
  private final static int MAXIMUM_ALLOWED_LINE_SHORT_PER_STEP_IN_MOVE = 80;

  private List<Point> seedPoints;
  private ImageObject region;
  private AStarMap pathFinder;
  private FloodFill floodFill;

  public PolygonExtractor(ImageObject region, List<Point> seedPoints) {
    this.seedPoints = seedPoints;
    this.region = region;
    this.pathFinder = null;
    this.floodFill = null;
  }

  public PolygonExtractor(ImageObject region) {
    this(region, null);
  }

  /**
   * Rotation Point enum
   *
   * @author Remo
   *
   */
  private enum FixedRotationPoint {
    FIX_P1, FIX_P2, NONE
  }

  /**
   * Starts the voronoi edge detection with trimming and splitting so that no background is touched
   * by a line
   *
   * The Returned Edges correspond to the global coordinates
   *
   * @return List of GraphEdge Objects
   */
  private List<GraphEdge> getVoronoiEdges(boolean globalizeEdges, boolean trimAndSplitEdges) {
    if (seedPoints.size() <= 0) {
      return new ArrayList<GraphEdge>();
    }

    List<GraphEdge> edges = executeVoronoi();
    edges = filterDoubleEdges(edges);

    if (trimAndSplitEdges)
      edges = trimAndSplitEdges(edges);

    if (globalizeEdges) {
      globallizeEdges(edges);
    }

    return edges;
  }

  public Polygon getPolygon() {
    Pixel p = region.getPixels().get(0);

    Polygon result = getPolygon(new Point(p.x - region.getX(), p.y - region.getY()),
        region.getImage());
    result.translate(region.getX(), region.getY());
    return result;
  }

  /**
   * Calculate all CellPolygons.
   *
   * @return The polygons.
   */
  public List<Polygon> calcCellPolygons() {
    if (seedPoints == null) {
      return new ArrayList<Polygon>();
    }
    if (pathFinder == null) {
      pathFinder = new AStarMap(region.getImage(), BACKGROUND_COLOR);
    }
    if (floodFill == null) {
      floodFill = new FloodFill(region.getBoundings().width, region.getBoundings().height);
    }

    return translatePolygonsToGlobalCoordinates(getCellBorderPolygons(correctEdgePositions(
        trimAndSplitEdges(removeUselessEdges(getVoronoiEdges(false, false))))));
  }

  private List<Polygon> translatePolygonsToGlobalCoordinates(List<Polygon> polygons) {

    for (Polygon poly : polygons) {
      poly.translate(region.getX(), region.getY());
    }

    return polygons;
  }

  /**
   * Modifies the positions of all edges, so that they correspont to the global positions
   *
   * @param edges
   *          List of GraphEdge Objects
   */
  private void globallizeEdges(List<GraphEdge> edges) {
    int baseX = region.getX();
    int basyY = region.getY();

    for (GraphEdge edge : edges) {
      edge.x1 += baseX;
      edge.x2 += baseX;
      edge.y1 += basyY;
      edge.y2 += basyY;
    }
  }

  /**
   * Trims and splits edges, so that they don't lie on the background
   *
   * @param edges
   *          List of GraphEdge Objects
   * @return List of GraphEdge Objects
   */
  private List<GraphEdge> trimAndSplitEdges(List<GraphEdge> edges) {
    List<GraphEdge> realEdges = new ArrayList<GraphEdge>();

    for (GraphEdge edge : edges) {
      List<Point> points = getPixelsLinear(new Point((int) edge.x1, (int) edge.y1),
          new Point((int) edge.x2, (int) edge.y2));
      realEdges.addAll(convertPointListToGraphEdges(points, edge.site1, edge.site2));
    }

    return realEdges;
  }

  private List<GraphEdge> removeSmallEdges(List<GraphEdge> edges) {
    float minSize = 8;

    List<GraphEdge> result = new ArrayList<GraphEdge>();
    Set<GraphEdge> edgesToCheck = new HashSet<GraphEdge>();
    Set<GraphEdge> smallEdges = new HashSet<GraphEdge>();
    Map<Point, GraphEdge> smallEdgesMap = new HashMap<Point, GraphEdge>();
    Map<Point, Integer> pointOcurrences = new HashMap<Point, Integer>();

    // collect small edges
    for (GraphEdge e : edges) {
      Point p1 = new Point((int) e.x1, (int) e.y1);
      Point p2 = new Point((int) e.x2, (int) e.y2);

      incrementPoint(pointOcurrences, p1);
      incrementPoint(pointOcurrences, p2);

      if (p1.distance(p2) <= minSize) {
        // Check, if a removement is valid:
        GraphEdge testEdge = new GraphEdge();
        testEdge.site1 = e.site1;
        testEdge.site2 = e.site2;
        testEdge.x1 = testEdge.x2 = testEdge.y1 = testEdge.y2 = 0;
        if (isNewEdgeValid(edges, e, testEdge)) {
          if (!smallEdgesMap.containsKey(p1)) {
            smallEdgesMap.put(p1, e);
            smallEdges.add(e);
          }
          if (!smallEdgesMap.containsKey(p2)) {
            smallEdgesMap.put(p2, e);
            smallEdges.add(e);
          }
        } else {
          edgesToCheck.add(e);
        }
      } else {
        edgesToCheck.add(e);
      }
    }

    // remove small edges (if possible)
    for (GraphEdge e : edgesToCheck) {
      Point p1 = new Point((int) e.x1, (int) e.y1);
      Point p2 = new Point((int) e.x2, (int) e.y2);

      GraphEdge newEdge = new GraphEdge();
      newEdge.site1 = e.site1;
      newEdge.site2 = e.site2;
      newEdge.x1 = e.x1;
      newEdge.y1 = e.y1;
      newEdge.x2 = e.x2;
      newEdge.y2 = e.y2;

      if (smallEdgesMap.containsKey(p1) && pointOcurrences.get(p1) <= 2) {
        GraphEdge found = smallEdgesMap.get(p1);
        if (smallEdges.contains(found)) {
          if ((int) found.x1 == (int) e.x1 && (int) found.y1 == (int) e.y1) {
            newEdge.x1 = found.x2;
            newEdge.y1 = found.y2;
          } else {
            newEdge.x1 = found.x1;
            newEdge.y1 = found.y1;
          }
        }
        smallEdgesMap.remove(p1);
      }

      if (smallEdgesMap.containsKey(p2) && pointOcurrences.get(p2) <= 2) {
        GraphEdge found = smallEdgesMap.get(p2);
        if (smallEdges.contains(found)) {
          if ((int) found.x2 == (int) e.x2 && (int) found.y2 == (int) e.y2) {
            newEdge.x2 = found.x1;
            newEdge.y2 = found.y1;
          } else {
            newEdge.x2 = found.x2;
            newEdge.y2 = found.y2;
          }
          smallEdges.remove(found);
        }
      }
      result.add(newEdge);
    }

    // Add small edges, which are not connected to others
    for (GraphEdge e : smallEdges) {
      result.add(e);
    }

    return result;
  }

  /**
   * Moves all edges parallel to the smallest position between two cell centers. This movement is
   * only done, if the edge is connected between two borders and does not intersect other edges
   *
   * In a second step, the algorithm tries to rotate some lines. The rotation is done, by fixing
   * always one point of the line
   *
   * When ENABLE_ASTAR_ALGORITHM is true, also situations are tested, where the centers do not see
   * each other direct
   *
   * @param edges
   * @return
   */
  private List<GraphEdge> correctEdgePositions(List<GraphEdge> edges) {
    List<GraphEdge> correcteEdges = new ArrayList<GraphEdge>();

    // Check, which graph edges do not touch others
    Map<Point, Integer> edgePointCount = new HashMap<Point, Integer>();
    for (GraphEdge e : edges) {
      incrementPoint(edgePointCount, new Point((int) e.x1, (int) e.y1));
      incrementPoint(edgePointCount, new Point((int) e.x2, (int) e.y2));
    }

    // iterate all graph edges and modify the center position of all edges, which split
    // 2 zells without interaction of other borders
    for (GraphEdge e : edges) {
      Point p1 = new Point((int) e.x1, (int) e.y1);
      Point p2 = new Point((int) e.x2, (int) e.y2);

      GraphEdge newEdge = null;

      if (p1.distance(p2) >= 8) {
        if (edgePointCount.get(p1) == 1 && edgePointCount.get(p2) == 1) {
          newEdge = moveEdgeToSmallestRegion(e);
          if (isNewEdgeValid(edges, e, newEdge)) {
            GraphEdge temp = rotateEdgeToSmallestRegion(newEdge, FixedRotationPoint.NONE);
            if (isNewEdgeValid(edges, e, temp)) {
              newEdge = temp;
            }
          }
        } else if (edgePointCount.get(p1) == 1) {
          newEdge = rotateEdgeToSmallestRegion(e, FixedRotationPoint.FIX_P2);
        } else if (edgePointCount.get(p2) == 1) {
          newEdge = rotateEdgeToSmallestRegion(e, FixedRotationPoint.FIX_P1);
        }
      }

      if (newEdge != null) {
        if (isNewEdgeValid(edges, e, newEdge)) {
          correcteEdges.add(newEdge);
        } else {
          correcteEdges.add(e);
        }
      } else {
        correcteEdges.add(e);
      }
    }

    return correcteEdges;
  }

  /**
   * Tries to rotate an edge to the smalest rotation The parameter fixedPoint defines, which point
   * should be fix and not moved. If None is selected, the algorithm first fixes p1 and then p2 and
   * returns a new edge which had the smallest distance
   *
   * @param edge
   * @param fixedPoint
   * @return
   */
  private GraphEdge rotateEdgeToSmallestRegion(GraphEdge edge, FixedRotationPoint fixedPoint) {
    GraphEdge result = new GraphEdge();
    result.site1 = edge.site1;
    result.site2 = edge.site2;
    result.x1 = edge.x1;
    result.x2 = edge.x2;
    result.y1 = edge.y1;
    result.y2 = edge.y2;

    int maxDegree = 40; // maximum degree to test from the current
    Point2D vecx1x2 = null;
    Point2D vecx2x1 = null;

    int smallestDegree = 0;
    FixedRotationPoint smallestFixPoint = FixedRotationPoint.NONE;

    // Calculate current edge size
    Point p1 = new Point((int) edge.x1, (int) edge.y1);
    Point p2 = new Point((int) edge.x2, (int) edge.y2);
    Float smallestWidth = (float) p1.distance(p2);
    Float lastWidthx1x2 = smallestWidth;
    Float lastWidthx2x1 = smallestWidth;

    // Iterate degrees
    for (int deg = -1 * maxDegree; deg <= maxDegree; ++deg) {
      switch (fixedPoint) {
      case FIX_P1:
        vecx1x2 = getRotatedEdgeVector(edge, FixedRotationPoint.FIX_P1, deg);
        break;
      case FIX_P2:
        vecx2x1 = getRotatedEdgeVector(edge, FixedRotationPoint.FIX_P2, deg);
        break;
      case NONE:
        vecx1x2 = getRotatedEdgeVector(edge, FixedRotationPoint.FIX_P1, deg);
        vecx2x1 = getRotatedEdgeVector(edge, FixedRotationPoint.FIX_P2, deg);
        break;
      default:
        return edge;
      }

      // Check, if a vector could be calculated
      if (vecx1x2 != null) {
        float width = getCellWidth(new Point((int) edge.x1, (int) edge.y1), vecx1x2);
        if (Math.abs(lastWidthx1x2 - width) > MAXIMUM_ALLOWED_LINE_SHORT_PER_STEP_IN_MOVE) {
          lastWidthx1x2 = (float) Integer.MAX_VALUE;
        } else if (width < smallestWidth) {
          lastWidthx1x2 = width;
          smallestWidth = width;
          smallestDegree = deg;
          smallestFixPoint = FixedRotationPoint.FIX_P1;
        }
      }

      // Check, if a vector could be calculated
      if (vecx2x1 != null) {
        float width = getCellWidth(new Point((int) edge.x2, (int) edge.y2), vecx2x1);
        if (Math.abs(lastWidthx2x1 - width) > MAXIMUM_ALLOWED_LINE_SHORT_PER_STEP_IN_MOVE) {
          lastWidthx2x1 = (float) Integer.MAX_VALUE;
        } else if (width < smallestWidth) {
          lastWidthx2x1 = width;
          smallestWidth = width;
          smallestDegree = deg;
          smallestFixPoint = FixedRotationPoint.FIX_P2;
        }
      }
    }

    // Finish the new GraphEdge, if one could be found
    Point2D tempVector;
    Point tempEnd;
    switch (smallestFixPoint) {
    case FIX_P1:
      tempVector = getRotatedEdgeVector(edge, FixedRotationPoint.FIX_P1, smallestDegree);
      tempEnd = findLastForegroundPoint(new Point((int) result.x1, (int) result.y1), tempVector);
      result.x2 = tempEnd.getX();
      result.y2 = tempEnd.getY();
      break;
    case FIX_P2:
      tempVector = getRotatedEdgeVector(edge, FixedRotationPoint.FIX_P2, smallestDegree);
      tempEnd = findLastForegroundPoint(new Point((int) result.x2, (int) result.y2), tempVector);
      result.x1 = tempEnd.getX();
      result.y1 = tempEnd.getY();
      break;
    default:
      result = edge;
    }

    return result;
  }

  /**
   * Tests, if a new calculated Edge is valid. An edge is valid, if the a star algorithm can't find
   * a path to the oter
   *
   * @param edges
   * @param edges
   * @return
   */
  private boolean isNewEdgeValid(List<GraphEdge> edges, GraphEdge oldEdge, GraphEdge newEdge) {
    Point p1 = new Point((int) newEdge.x1, (int) newEdge.y1);
    Point p2 = new Point((int) newEdge.x2, (int) newEdge.y2);
    Point c1 = convertGlobalToLocal(seedPoints.get(newEdge.site1));
    Point c2 = convertGlobalToLocal(seedPoints.get(newEdge.site2));
    int width = region.getImage().getWidth();
    int height = region.getImage().getHeight();

    // Adjust to region within the image
    c1.x = (c1.x >= width) ? width - 2 : (c1.x < 0) ? 1 : c1.x;
    c1.y = (c1.y >= height) ? height - 2 : (c1.y < 0) ? 1 : c1.y;
    c2.x = (c2.x >= width) ? width - 2 : (c2.x < 0) ? 1 : c2.x;
    c2.y = (c2.y >= height) ? height - 2 : (c2.y < 0) ? 1 : c2.y;

    // Make sure, the nearest point of the line does not
    // fall below the distance of 5
    List<Point> line = getPixelsLinear(p1, p2);
    if (getShortestDistance(line, c1) <= 5 || getShortestDistance(line, c2) <= 5) {
      return false;
    }

    // Test, that the new line does not intersect others.
    // This solves situations, where the original line had one end beside a small
    // background pixel (Hole) with other lines.
    Line2D newEdgeLine = new Line2D.Double(newEdge.x1, newEdge.y1, newEdge.x2, newEdge.y2);
    for (GraphEdge e : edges) {
      Line2D eLine = new Line2D.Double(e.x1, e.y1, e.x2, e.y2);
      if (eLine.intersectsLine(newEdgeLine)) {
        return false;
      }
    }

    // paint all edges white except the old edge which should be replaced
    BufferedImage img = ImageFunctions.copyImage(region.getImage());
    Graphics2D g = img.createGraphics();
    g.setColor(BACKGROUND_COLOR);
    g.setStroke(new BasicStroke(1));
    for (GraphEdge e : edges) {
      if (e != oldEdge) {
        g.drawLine((int) e.x1, (int) e.y1, (int) e.x2, (int) e.y2);
      }
    }
    g.drawLine((int) newEdge.x1, (int) newEdge.y1, (int) newEdge.x2, (int) newEdge.y2);
    g.dispose();

    // if the point is not in range, the edge movement was valid
    return !floodFill.arePointsConnected(img, c1, c2, BACKGROUND_COLOR.getRGB());
  }

  private double getShortestDistance(List<Point> route, Point center) {
    double dist = Integer.MAX_VALUE;

    for (Point pt : route) {
      Point p1 = new Point(pt.x, pt.y);
      double tempDist = p1.distance(center);
      if (tempDist < dist) {
        dist = tempDist;
      }
    }

    return dist;
  }

  /**
   * Rotates a vector acording to the given degree. The Parameter fixedPoint is not allowed to be
   * NONE in this function.
   *
   * @param edge
   * @param fixedPoint
   * @param degree
   * @return
   */
  private Point2D getRotatedEdgeVector(GraphEdge edge, FixedRotationPoint fixedPoint,
      double degree) {
    Point2D vector;

    switch (fixedPoint) {
    case FIX_P1:
      vector = new Point2D.Float((float) (edge.x2 - edge.x1), (float) (edge.y2 - edge.y1));
      break;
    case FIX_P2:
      vector = new Point2D.Float((float) (edge.x1 - edge.x2), (float) (edge.y1 - edge.y2));
      break;
    default:
      return null;
    }

    double rad = degree / 180.0 * Math.PI;
    double rot_x = vector.getX() * Math.cos(rad) - vector.getY() * Math.sin(rad);
    double rot_y = vector.getX() * Math.sin(rad) + vector.getY() * Math.cos(rad);

    return new Point2D.Float((float) rot_x, (float) rot_y);
  }

  /**
   * Moves the edge parallel to the smallest position between two cell centers. This movement is
   * only done, if the edge is connected between two borders and does not intersect other edges
   *
   * When ENABLE_ASTAR_ALGORITHM is true, also situations are tested, where the centers do not see
   * each other direct
   *
   * @param edge
   * @return
   */
  private GraphEdge moveEdgeToSmallestRegion(GraphEdge edge) {
    GraphEdge result = new GraphEdge();

    float checkPercentage = 60.0f;
    result.site1 = edge.site1;
    result.site2 = edge.site2;
    result.x1 = edge.x1;
    result.x2 = edge.x2;
    result.y1 = edge.y1;
    result.y2 = edge.y2;

    // Get all pixels between the two cell points
    Point center1 = convertGlobalToLocal(seedPoints.get(edge.site1));
    Point center2 = convertGlobalToLocal(seedPoints.get(edge.site2));
    List<Point> points = getPixelsLinear(center1, center2);

    // Check, if the line does not pass any kind of background color
    boolean traceLineLinear = true;
    boolean modificationEnabled = true;
    for (Point pt : points) {
      if (region.getColorFromLocalCoordinates(pt.x, pt.y) == BACKGROUND_COLOR.getRGB()) {
        modificationEnabled = false;
        break;
      }
    }

    // If no linear line can be made, try to find the path with the a star algorithm
    if (ENABLE_ASTAR_ALGORITHM && !modificationEnabled) {
      modificationEnabled = true;
      traceLineLinear = false;
    }

    // if the connection line between the two centers consists only of cell points, then try to find
    // the smallest region
    // This is done by parallel movement of the voronoi edge along this line
    if (modificationEnabled) {
      // 1. Schnittpunkt zwischen Edge und Center linie finden
      Point edge1 = new Point((int) edge.x1, (int) edge.y1);
      Point edge2 = new Point((int) edge.x2, (int) edge.y2);

      // 2. Calculate a vector for the parallel lines
      Point2D edgeVector = new Point2D.Float(edge1.x - edge2.x, edge1.y - edge2.y);

      // 3. Calculate length on the center points
      float lengthCenter1 = getCellWidth(center1, edgeVector);
      float lengthCenter2 = getCellWidth(center2, edgeVector);
      float smallestLength = Integer.MAX_VALUE;
      Point smallestLengthBasePoint = null;

      // 4. Find smallest width (in a 50 percent range from the base)
      List<Point> traceRoute = null;
      if (traceLineLinear) {
        traceRoute = getPixelsLinear(center1, center2);
      } else {
        traceRoute = pathFinder.findPath(center1.x, center1.y, center2.x, center2.y);
      }

      int traceIndex = getPointListIntersectIndex(traceRoute, getPixelsLinear(edge1, edge2));

      // We have to make sure, that
      // the edge does intersect our trace line. So they belong to the same area
      if (traceIndex < 0) {
        return result;
      }

      float blockedSize = (float) center1.distance(center2) / 100.0f * (100 - checkPercentage)
          / 2.0f;
      float lastLength = 0;

      // Search smallest position from our initial line
      // a--|---<-x->---|--b (a = center1, x = intersection, b = center2)
      // so first from x to a
      // and the second step is from x to b
      for (int step = 0; step < 2; ++step) {
        int sign = 0;
        int startValue = 0;
        int max = 0;

        switch (step) {
        case 0:
          sign = -1;
          startValue = traceIndex;
          max = 0;
          break;
        case 1:
          sign = 1;
          startValue = traceIndex;
          max = traceRoute.size();
          break;
        }

        for (int i = startValue; ((sign < 0) ? i >= max : i < max); i += sign) {
          Point base = traceRoute.get(i);
          float distCenter1 = (float) center1.distance(base);
          float distCenter2 = (float) center2.distance(base);
          if (distCenter1 > blockedSize && distCenter2 > blockedSize) {
            float len = getCellWidth(base, edgeVector);
            if (lastLength == 0) {
              lastLength = len;
            }

            // The length is not allowed to decrease more than 6 per movement (Prevent possible
            // holes in cell centers)
            if (Math.abs(len - lastLength) > MAXIMUM_ALLOWED_LINE_SHORT_PER_STEP_IN_MOVE) {
              break;
            }
            lastLength = len;

            if (len < lengthCenter1 && len < lengthCenter2 && len < smallestLength) {
              smallestLength = len;
              smallestLengthBasePoint = base;
            }
          }
        }
      }

      // 6. Add new smallest line
      if (smallestLengthBasePoint != null) {
        Point end1 = findLastForegroundPoint(smallestLengthBasePoint, edgeVector);
        Point end2 = findLastForegroundPoint(smallestLengthBasePoint,
            new Point2D.Float((float) -edgeVector.getX(), (float) -edgeVector.getY()));
        result.x1 = end1.x;
        result.y1 = end1.y;
        result.x2 = end2.x;
        result.y2 = end2.y;
      }
    }

    return result;
  }

  /**
   * Returns the index, where list l1 is intersected by list l2. if no direct intersection point is
   * found, the nearest point is returned, as long as the distance is smaller than 2
   *
   * @param l1
   *          List for which the index is searched
   * @param l2
   *          List to find intersections
   * @return Index for List l1
   */
  private int getPointListIntersectIndex(List<Point> l1, List<Point> l2) {
    Map<Point, Integer> checkMap = new HashMap<Point, Integer>();

    for (Point p : l1) {
      checkMap.put(p, 0);
    }

    for (Point p : l2) {
      if (checkMap.containsKey(p)) {
        return l1.indexOf(p);
      }
    }

    // return nearest index, if nothing was found
    int smallestIndex = -1;
    double smallestDistance = Integer.MAX_VALUE;
    for (int i = 0; i < l1.size(); ++i) {
      for (Point p2 : l2) {
        double tempDist = l1.get(i).distance(p2);
        if (tempDist < smallestDistance) {
          smallestIndex = i;
          smallestDistance = tempDist;
        }
      }
    }

    if (smallestDistance > 2) {
      smallestIndex = -1;
    }

    return smallestIndex;
  }

  private void incrementPoint(Map<Point, Integer> pointMap, Point pt) {
    Integer val = pointMap.get(pt);
    if (val != null) {
      pointMap.put(pt, val + 1);
    } else {
      pointMap.put(pt, 1);
    }
  }

  /**
   * Converts a point to the global coordinates
   *
   * @param global
   * @return
   */
  private Point convertGlobalToLocal(Point global) {
    return new Point(global.x - region.getX(), global.y - region.getY());
  }

  /**
   * Returns the width of a cell from a base point and a line. Line is calculated by walking the
   * direction vector in both directions
   *
   * @param base
   *          start point
   * @param direction
   *          direction to test
   * @return
   */
  private float getCellWidth(Point base, Point2D direction) {
    Point end1 = findLastForegroundPoint(base, direction);
    Point end2 = findLastForegroundPoint(base,
        new Point2D.Float((float) -direction.getX(), (float) -direction.getY()));

    return (float) end1.distance(end2);
  }

  /**
   * Returns the last foreground coloured pixel lient on the line of a given direction
   *
   * @param base
   *          start point
   * @param direction
   *          direction in which it searches
   * @return
   */
  private Point findLastForegroundPoint(Point base, Point2D direction) {
    Point maxTarget = getFurthestPoint(base, direction);
    List<Point> points = getPixelsLinear(base, maxTarget);

    Point lastPoint = base;

    // Allow a maximum of 2 background colored points on the line
    int backgroundPoints = 0;
    for (Point pt : points) {
      if (region.getColorFromLocalCoordinates(pt.x, pt.y) == BACKGROUND_COLOR.getRGB()) {
        ++backgroundPoints;
      } else {
        lastPoint = pt;
      }

      if (backgroundPoints > 3) {
        break;
      }
    }

    return lastPoint;
  }

  /**
   * Returns the furthest point from a given base and a direction. This furthest point lies always
   * on the border of the image.
   *
   * @param base
   *          base center point
   * @param direction
   *          direction to walk
   * @return Point on border
   */
  private Point getFurthestPoint(Point base, Point2D direction) {
    float factorX = 0;
    float factorY = 0;
    float smallestFactor = 0;

    if (direction.getX() != 0) {
      if (direction.getX() < 0) {
        factorX = (float) (-(float) base.x / direction.getX());
      } else {
        factorX = (float) ((region.getBoundings().getWidth() - 1 - base.x) / direction.getX());
      }
    } else {
      factorX = Integer.MAX_VALUE;
    }

    if (direction.getY() != 0) {
      if (direction.getY() < 0) {
        factorY = (float) (-(float) base.y / direction.getY());
      } else {
        factorY = (float) ((region.getBoundings().getHeight() - 1 - base.y) / direction.getY());
      }
    } else {
      factorY = Integer.MAX_VALUE;
    }

    smallestFactor = (factorX < factorY) ? factorX : factorY;

    return new Point((int) (base.x + direction.getX() * smallestFactor),
        (int) (base.y + direction.getY() * smallestFactor));
  }

  /**
   * Convertes a pixel list with the given side informations to a GraphEdge
   *
   * @param points
   *          pixels
   * @param site1
   *          site 1
   * @param site2
   *          site 2
   * @return List of GraphEdge objects
   */
  private List<GraphEdge> convertPointListToGraphEdges(List<Point> points, int site1, int site2) {
    List<GraphEdge> edges = new ArrayList<GraphEdge>();

    boolean lastPixelWasBackground = true;
    boolean edgeInProgress = false;
    Point lastPoint = null;
    GraphEdge edge = null;

    Graphics2D g = region.getImage().createGraphics();
    g.setStroke(new BasicStroke(3));
    g.setColor(Color.CYAN);

    for (int i = 0; i < points.size(); ++i) {
      Point pt = points.get(i);

      if (region.getColorFromLocalCoordinates(pt.x, pt.y) != BACKGROUND_COLOR.getRGB()) {
        if (lastPixelWasBackground) {
          edgeInProgress = true;
          edge = new GraphEdge();
          edge.site1 = site1;
          edge.site2 = site2;
          edge.x1 = pt.x;
          edge.y1 = pt.y;
        }

        lastPixelWasBackground = false;
      } else {
        if (edgeInProgress) {
          edge.x2 = lastPoint.x;
          edge.y2 = lastPoint.y;
          edges.add(edge);
          edgeInProgress = false;
        }

        lastPixelWasBackground = true;
      }

      lastPoint = pt;
    }

    if (edgeInProgress) {
      edge.x2 = lastPoint.x;
      edge.y2 = lastPoint.y;
      edges.add(edge);
    }

    g.dispose();

    return edges;
  }

  /**
   * Returns all Pixels which are touched by a line
   *
   * Bresenham's line algorithm See:
   * http://rosettacode.org/wiki/Bitmap/Bresenham%27s_line_algorithm#Java
   *
   * @return List of GraphEdge objects
   */
  private List<Point> getPixelsLinear(Point p1, Point p2) {
    List<Point> points = new ArrayList<Point>();

    int y1 = p1.y;
    int y2 = p2.y;
    int x1 = p1.x;
    int x2 = p2.x;

    int d = 0;

    int dy = Math.abs(y2 - y1);
    int dx = Math.abs(x2 - x1);

    int dy2 = (dy << 1); // slope scaling factors to avoid floating
    int dx2 = (dx << 1); // point

    int ix = x1 < x2 ? 1 : -1; // increment direction
    int iy = y1 < y2 ? 1 : -1;

    if (dy <= dx) {
      for (;;) {
        points.add(new Point(x1, y1));
        if (x1 == x2)
          break;
        x1 += ix;
        d += dy2;
        if (d > dx) {
          y1 += iy;
          d -= dx2;
        }
      }
    } else {
      for (;;) {
        points.add(new Point(x1, y1));
        if (y1 == y2)
          break;
        y1 += iy;
        d += dx2;
        if (d > dy) {
          x1 += ix;
          d -= dy2;
        }
      }
    }

    return points;
  }

  /**
   * Starts the Voronoi edge detection algorithm
   *
   * @return List of GraphEdge objects
   */
  private List<GraphEdge> executeVoronoi() {
    double xPositions[] = new double[seedPoints.size()];
    double yPositions[] = new double[seedPoints.size()];

    for (int i = 0; i < seedPoints.size(); ++i) {
      xPositions[i] = seedPoints.get(i).getX() - region.getBoundings().x;
      yPositions[i] = seedPoints.get(i).getY() - region.getBoundings().y;
    }

    Voronoi voronoi = new Voronoi(1);
    List<GraphEdge> edges = voronoi.generateVoronoi(xPositions, yPositions, 0,
        region.getBoundings().getWidth() - 1, 0, region.getBoundings().getHeight() - 1);

    return edges;
  }

  /**
   * Remove useless edges of a given collection.
   *
   * @param edges
   *          The edges.
   * @return The new filtered set.
   */
  private List<GraphEdge> removeUselessEdges(List<GraphEdge> edges) {
    List<GraphEdge> result = new ArrayList<>();

    /* Algorithm 1: For each edge: Use the border search to connect both ends of the edges on two
     * ways. These are the possible results: - No ways works (e.g. when one side of the edge is
     * inside a structure) - Both ways work If both work and exactly one of the resulted areas does
     * not contain a mountain point, then the edge is useless. */
    BorderSearch bs = new BorderSearch();
    for (GraphEdge edge : edges) {
      Set<Point> end = new HashSet<Point>();
      end.add(new Point((int) edge.x2, (int) edge.y2));
      int good = 0;
      for (boolean direction : new boolean[] { true, false }) {
        Line line = bs.search(region.getImage(), new Point(0, 0),
            new Point((int) edge.x1, (int) edge.y1), end, BACKGROUND_COLOR, direction);
        if (line.getPoints().size() == 1) {
          continue;
        }
        if (!line.last().equals(new Point((int) edge.x2, (int) edge.y2))) {
          continue;
        }
        Polygon poly = line.toPolygon();
        boolean match = false;
        for (Point c : seedPoints) {
          if (poly.contains(new Point(c.x - region.getX(), c.y - region.getY()))) {
            match = true;
            break;
          }
        }
        if (match) {
          good++;
        }
      }
      if (good != 1) {
        result.add(edge);
      }
    }

    edges = removeSmallEdges(trimAndSplitEdges(result));

    // Try a flood fill algorithm with the same logic as algorithm 2
    Iterator<GraphEdge> edgeIter = edges.iterator();
    while (edgeIter.hasNext()) {
      GraphEdge edge = edgeIter.next();

      Point p1 = new Point((int) edge.x1, (int) edge.y1);
      Point p2 = new Point((int) edge.x2, (int) edge.y2);

      // if the edge is to small, let it stay and continue
      // The points must connect to background, otherwise they are also ignored
      if (p1.distance(p2) <= 5
          || !ImageFunctions.belongsOneNeighbourToColour(region.getImage(), p1,
              BACKGROUND_COLOR.getRGB())
          || !ImageFunctions.belongsOneNeighbourToColour(region.getImage(), p2,
              BACKGROUND_COLOR.getRGB())) {
        continue;
      }

      Point c1 = convertGlobalToLocal(seedPoints.get(edge.site1));
      Point c2 = convertGlobalToLocal(seedPoints.get(edge.site2));

      BufferedImage img = ImageFunctions.copyImage(region.getImage());
      Graphics2D g = img.createGraphics();

      // set other edges to background color
      g.setStroke(new BasicStroke(1));
      g.setColor(BACKGROUND_COLOR);
      for (GraphEdge e : edges) {
        if (edge != e) {
          int signX = (e.x1 < e.x2) ? -1 : 1;
          int signY = (e.y1 < e.y2) ? -1 : 1;
          g.drawLine((int) e.x1 + signX, (int) e.y1 + signY, (int) e.x2 - signX,
              (int) e.y2 - signY);
        }
      }
      g.dispose();

      // remove edge, if the second mountain was not found
      if (!floodFill.arePointsConnected(img, c1, c2, BACKGROUND_COLOR.getRGB())) {
        edgeIter.remove();
      }
    }

    return edges;
  }

  /**
   * Calculate all cell edges.
   *
   * @param edges
   *          The edges.
   * @return The edges.
   */
  private List<Polygon> getCellBorderPolygons(List<GraphEdge> edges) {
    List<Polygon> result = new ArrayList<>();

    // TODO: Improve speed and design

    /* Algorithm: 1) Draw all edges with background color 2) For each center point: 2.1) Get the
     * object on which the center point is. 2.2) Copy the object to a new image and add all touching
     * edges. 2.3) Get now the border of this new created object which also contains the edges.
     *
     * Finished:)
     *
     * Alternative algorithms made (many...) problems, but obviously this one is not very fast. */

    /* Copy the image and draw all edges. */
    BufferedImage img = ImageFunctions.copyImage(region.getImage());
    Graphics2D g = img.createGraphics();
    g.setColor(BACKGROUND_COLOR);
    g.setStroke(new BasicStroke(1));
    for (GraphEdge edge : edges) {
      g.drawLine((int) edge.x1, (int) edge.y1, (int) edge.x2, (int) edge.y2);
    }
    g.dispose();

    /* Iterate through all mountain / center points. */
    for (int i = 0; i < seedPoints.size(); i++) {

      /* Get the polygon. */
      final int site = i;
      Point center = seedPoints.get(i);
      center = new Point(center.x - region.getX(), center.y - region.getY());
      Polygon poly = getPolygon(center, img);

      // if a polygon has less then 10 points something went wrong.
      // therefore, all neighbor pixels are tested as a center point
      // This can be done, because the seed placement algorithm makes sure, that
      // these fields do not lie on the background.
      // This fix solved a not detected Cell on a test image
      boolean finished = false;
      if (poly.npoints < 10) {
        for (int y = center.y - 1; y <= center.y + 1 && !finished; ++y) {
          for (int x = center.x - 1; x <= center.x + 1 && !finished; ++x) {
            if (x >= 0 && y >= 0 && x < region.getImage().getWidth()
                && y < region.getImage().getHeight()) {
              poly = getPolygon(new Point(x, y), img);
              if (poly.npoints > 10) {
                center = new Point(x, y);
                finished = true;
              }
            }
          }
        }
      }

      /* Add now the border to get a better object. (optional step!) */
      {

        /* Create an image with the current polygon. */
        BufferedImage tmp = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        Graphics2D tg = tmp.createGraphics();
        tg.setColor(BACKGROUND_COLOR);
        tg.fillRect(0, 0, tmp.getWidth(), tmp.getHeight());
        tg.setColor(Color.BLACK);
        tg.setStroke(new BasicStroke(1));
        tg.fillPolygon(poly);
        for (int j = 0; j < poly.npoints; j++) {
          tmp.setRGB(poly.xpoints[j], poly.ypoints[j], tg.getColor().getRGB());
        }

        /* Add all edges. */
        for (GraphEdge edge : edges) {
          if (edge.site1 == site || edge.site2 == site)
            tg.drawLine((int) edge.x1, (int) edge.y1, (int) edge.x2, (int) edge.y2);
        }
        tg.dispose();

        /* Get now the new polygon. */
        poly = getPolygon(center, tmp);
      }

      result.add(poly);
    }

    return result;
  }

  /**
   * Remove all doubled entries in a List of GraphEdges.
   *
   * @param edges
   *          The edges.
   * @return The list with only unique edges.
   */
  private List<GraphEdge> filterDoubleEdges(List<GraphEdge> edges) {
    List<GraphEdge> result = new ArrayList<>();
    for (GraphEdge e : edges) {
      boolean found = false;
      for (GraphEdge e2 : result) {
        if ((int) e.x1 == (int) e2.x1 && (int) e.y1 == (int) e2.y1 && (int) e.x2 == (int) e2.x2
            && (int) e.y2 == (int) e2.y2) {
          found = true;
          break;
        }
      }
      if (!found) {
        result.add(e);
      }
    }
    return result;
  }

  /* public Polygon getPolygon() { Pixel p = region.getPixels().get(0);
   *
   * Polygon result = getPolygon(new Point(p.x - region.getX(), p.y - region.getY()),
   * region.getImage()); result.translate(region.getX(), region.getY()); return result; } */

  /**
   * Get the polygon of an object on which is a given (center) point. The point must not be on white
   * background.
   *
   * @param center
   *          The center point
   * @param img
   *          The input image.
   * @return The found polygon.
   */
  private Polygon getPolygon(Point center, BufferedImage img) {
    BorderSearch bs = new BorderSearch();
    int x;
    int y = center.y;

    /* Go right. */
    for (x = center.x; x < img.getWidth() - 1; x++) {
      if (img.getRGB(x, y) != BACKGROUND_COLOR.getRGB()
          && img.getRGB(x + 1, y) == BACKGROUND_COLOR.getRGB()) {

        /* Get the polygon. */
        Polygon poly = bs.search(img, center, new Point(x, y), null, BACKGROUND_COLOR).toPolygon();

        if (poly.contains(center)) {
          // if (containsOrIsOnBorder(poly, center)) {

          /* If the polygon contains the center we are done. Unless this is the case we just found a
           * hole. */
          return poly;
        }
      }
    }

    /* Go left. */
    for (x = center.x; x >= 1; x--) {
      if (img.getRGB(x, y) != BACKGROUND_COLOR.getRGB()
          && img.getRGB(x - 1, y) == BACKGROUND_COLOR.getRGB()) {

        /* Get the polygon. */
        Polygon poly = bs.search(img, center, new Point(x, y), null, BACKGROUND_COLOR).toPolygon();
        if (poly.contains(center)) {
          // if (containsOrIsOnBorder(poly, center)) {

          /* If the polygon contains the center we are done. Unless this is the case we just found a
           * hole. */
          return poly;
        }
      }
    }
    x = center.x;

    /* Go down */
    for (y = center.y; y < img.getHeight() - 1; y++) {
      if (img.getRGB(x, y) != BACKGROUND_COLOR.getRGB()
          && img.getRGB(x, y + 1) == BACKGROUND_COLOR.getRGB()) {

        /* Get the polygon. */
        Polygon poly = bs.search(img, center, new Point(x, y), null, BACKGROUND_COLOR).toPolygon();
        if (poly.contains(center)) {
          // if (containsOrIsOnBorder(poly, center)) {

          /* If the polygon contains the center we are done. Unless this is the case we just found a
           * hole. */
          return poly;
        }
      }
    }

    /* Go Up */
    for (y = center.y; y >= 1; y--) {
      if (img.getRGB(x, y) != BACKGROUND_COLOR.getRGB()
          && img.getRGB(x, y - 1) == BACKGROUND_COLOR.getRGB()) {

        /* Get the polygon. */
        Polygon poly = bs.search(img, center, new Point(x, y), null, BACKGROUND_COLOR).toPolygon();
        if (poly.contains(center)) {
          // if (containsOrIsOnBorder(poly, center)) {

          /* If the polygon contains the center we are done. Unless this is the case we just found a
           * hole. */
          return poly;
        }
      }
    }
    return bs.search(img, center, new Point(x, y), null, BACKGROUND_COLOR).toPolygon();
  }

}
