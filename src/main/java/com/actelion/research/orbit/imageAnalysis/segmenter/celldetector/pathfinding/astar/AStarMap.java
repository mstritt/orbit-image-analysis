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

package com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.pathfinding.astar;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AStarMap {
  private BufferedImage image;
  private int backgroundColor;

  /** weather or not it is possible to walk diagonally on the map in general. */
  protected static boolean CANMOVEDIAGONALY = true;

  /** holds nodes. first dim represents x-, second y-axis. */
  private PointNode[][] nodes;
  /** list containing nodes not visited but adjacent to visited nodes. */
  private List<PointNode> openList;
  /** list containing nodes already visited/taken care of. */
  private List<PointNode> closedList;

  /** done finding path? */
  private boolean done;
  /** width + 1 is size of first dimension of nodes. */
  protected int width;
  /** higth + 1 is size of second dimension of nodes. */
  protected int higth;

  private boolean isInitialized;

  public AStarMap(BufferedImage image, Color backgroundColor) {
    this.image = image;
    this.backgroundColor = backgroundColor.getRGB();
    this.width = image.getWidth() - 2;
    this.higth = image.getHeight() - 2;
    this.isInitialized = false;
  }

  /**
   * initializes all nodes. Their coordinates will be set correctly.
   */
  private void initEmptyNodes() {
    nodes = new PointNode[image.getWidth() - 1][image.getHeight() - 1];

    for (int i = 0; i <= width; i++) {
      for (int j = 0; j <= higth; j++) {
        nodes[i][j] = new PointNode(i, j);
      }
    }
  }

  /**
   * Sets all background pixels to non walkable and the others to walkable
   */
  private void setWalkableNodes() {
    for (int y = 0; y <= higth; ++y) {
      for (int x = 0; x <= width; ++x) {
        setWalkable(x, y, image.getRGB(x, y) != backgroundColor);
      }
    }
  }

  /**
   * sets nodes walkable field at given coordinates to given value.
   * <p>
   * x/y must be bigger or equal to 0 and smaller or equal to width/hight.
   *
   * @param x
   * @param y
   * @param bool
   */
  public void setWalkable(int x, int y, boolean bool) {
    // TODO check parameter.
    if (x < width && y < higth) {
      nodes[x][y].setWalkable(bool);
    }
  }

  private void resetNodes() {
    for (int i = 0; i <= width; i++) {
      for (int j = 0; j <= higth; j++) {
        nodes[i][j].reset();
      }
    }
  }

  /**
   * finds an allowed path from start to goal coordinates on this map.
   * <p>
   * This method uses the A* algorithm. The hCosts value is calculated in the given Node
   * implementation.
   * <p>
   * This method will return a LinkedList containing the start node at the beginning followed by the
   * calculated shortest allowed path ending with the end node.
   * <p>
   * If no allowed path exists, an empty list will be returned.
   * <p>
   * <p>
   * x/y must be bigger or equal to 0 and smaller or equal to width/hight.
   *
   * @param oldX
   * @param oldY
   * @param newX
   * @param newY
   * @return
   */
  public final List<Point> findPath(int oldX, int oldY, int newX, int newY) {
    return findPath(oldX, oldY, newX, newY, null, Integer.MAX_VALUE);
  }

  /**
   * finds an allowed path from start to goal coordinates on this map.
   * <p>
   * This method uses the A* algorithm. The hCosts value is calculated in the given Node
   * implementation.
   * <p>
   * This method will return a LinkedList containing the start node at the beginning followed by the
   * calculated shortest allowed path ending with the end node.
   * <p>
   * If no allowed path exists, an empty list will be returned.
   * <p>
   * <p>
   * x/y must be bigger or equal to 0 and smaller or equal to width/hight.
   *
   * @param oldX
   * @param oldY
   * @param newX
   * @param newY
   * @param additionalDisabledPixels
   * @return
   */
  public final List<Point> findPath(int oldX, int oldY, int newX, int newY,
      List<Point> additionalDisabledPixels) {
    return findPath(oldX, oldY, newX, newY, additionalDisabledPixels, Integer.MAX_VALUE);
  }

  /**
   * finds an allowed path from start to goal coordinates on this map.
   * <p>
   * This method uses the A* algorithm. The hCosts value is calculated in the given Node
   * implementation.
   * <p>
   * This method will return a LinkedList containing the start node at the beginning followed by the
   * calculated shortest allowed path ending with the end node.
   * <p>
   * If no allowed path exists, an empty list will be returned.
   * <p>
   * <p>
   * x/y must be bigger or equal to 0 and smaller or equal to width/hight.
   *
   * @param oldX
   * @param oldY
   * @param newX
   * @param newY
   * @param additionalDisabledPixels
   * @param maxSteps
   * @return
   */
  public final List<Point> findPath(int oldX, int oldY, int newX, int newY,
      List<Point> additionalDisabledPixels, int maxSteps) {
    // TODO check input
    if (!isInitialized) {
      initEmptyNodes();
      setWalkableNodes();
      isInitialized = true;
    } else {
      resetNodes();
    }

    // set additional disabled pixels
    if (additionalDisabledPixels != null) {
      for (Point p : additionalDisabledPixels) {
        setWalkable(p.x, p.y, false);
      }
    }

    openList = new LinkedList<PointNode>();
    closedList = new LinkedList<PointNode>();
    openList.add(new PointNode(oldX, oldY)); // add starting node to open list
    done = false;

    PointNode current;
    while (!done) {
      current = lowestFInOpen(); // get node with lowest fCosts from openList
      closedList.add(current); // add current node to closed list
      openList.remove(current); // delete current node from open list

      if (closedList.size() > maxSteps) {
        return null; // return empty list
      }

      if ((current.getxPosition() == newX) && (current.getyPosition() == newY)) { // found goal
        List<PointNode> pNodes = calcPath(nodes[oldX][oldY], current);
        if (pNodes.size() > maxSteps) {
          return null;
        } else {
          return convertToPointList(calcPath(nodes[oldX][oldY], current));
        }
      }

      // for all adjacent nodes:
      List<PointNode> adjacentNodes = getAdjacent(current);
      for (int i = 0; i < adjacentNodes.size(); i++) {
        PointNode currentAdj = adjacentNodes.get(i);
        if (!openList.contains(currentAdj)) { // node is not in openList
          currentAdj.setPrevious(current); // set current node as previous for this node
          currentAdj.sethCosts(nodes[newX][newY]); // set h costs of this node (estimated costs to
                                                   // goal)
          currentAdj.setgCosts(current); // set g costs of this node (costs from start to this node)
          openList.add(currentAdj); // add node to openList
        } else { // node is in openList
          if (currentAdj.getgCosts() > currentAdj.calculategCosts(current)) { // costs from current
                                                                              // node are cheaper
                                                                              // than previous costs
            currentAdj.setPrevious(current); // set current node as previous for this node
            currentAdj.setgCosts(current); // set g costs of this node (costs from start to this
                                           // node)
          }
        }
      }

      if (openList.isEmpty()) { // no path exists
        return new LinkedList<Point>(); // return empty list
      }
    }
    return null; // unreachable
  }

  private List<Point> convertToPointList(List<PointNode> nodes) {
    List<Point> pt = new ArrayList<Point>();
    for (PointNode n : nodes) {
      pt.add(new Point(n.getxPosition(), n.getyPosition()));
    }
    return pt;
  }

  /**
   * returns the node with the lowest fCosts.
   *
   * @return
   */
  private PointNode lowestFInOpen() {
    // TODO currently, this is done by going through the whole openList!
    PointNode cheapest = openList.get(0);
    for (int i = 0; i < openList.size(); i++) {
      if (openList.get(i).getfCosts() < cheapest.getfCosts()) {
        cheapest = openList.get(i);
      }
    }
    return cheapest;
  }

  /**
   * calculates the found path between two points according to their given <code>previousNode</code>
   * field.
   *
   * @param start
   * @param goal
   * @return
   */
  private List<PointNode> calcPath(PointNode start, PointNode goal) {
    // TODO if invalid nodes are given (eg cannot find from
    // goal to start, this method will result in an infinite loop!)
    LinkedList<PointNode> path = new LinkedList<PointNode>();

    PointNode curr = goal;
    boolean done = false;
    while (!done) {
      path.addFirst(curr);
      curr = (PointNode) curr.getPrevious();

      if (curr.equals(start)) {
        done = true;
      }
    }
    return path;
  }

  /**
   * returns node at given coordinates.
   * <p>
   * x/y must be bigger or equal to 0 and smaller or equal to width/hight.
   *
   * @param x
   * @param y
   * @return node
   */
  public final PointNode getNode(int x, int y) {
    // TODO check parameter.
    return nodes[x][y];
  }

  /**
   * returns a LinkedList with nodes adjacent to the given node. if those exist, are walkable and
   * are not already in the closedList!
   */
  private List<PointNode> getAdjacent(PointNode node) {
    // TODO make loop
    int x = node.getxPosition();
    int y = node.getyPosition();
    List<PointNode> adj = new LinkedList<PointNode>();

    PointNode temp;
    if (x > 0) {
      temp = this.getNode((x - 1), y);
      if (temp.isWalkable() && !closedList.contains(temp)) {
        temp.setIsDiagonaly(false);
        adj.add(temp);
      }
    }

    if (x < width) {
      temp = this.getNode((x + 1), y);
      if (temp.isWalkable() && !closedList.contains(temp)) {
        temp.setIsDiagonaly(false);
        adj.add(temp);
      }
    }

    if (y > 0) {
      temp = this.getNode(x, (y - 1));
      if (temp.isWalkable() && !closedList.contains(temp)) {
        temp.setIsDiagonaly(false);
        adj.add(temp);
      }
    }

    if (y < higth) {
      temp = this.getNode(x, (y + 1));
      if (temp.isWalkable() && !closedList.contains(temp)) {
        temp.setIsDiagonaly(false);
        adj.add(temp);
      }
    }

    // add nodes that are diagonaly adjacent too:
    if (CANMOVEDIAGONALY) {
      if (x < width && y < higth) {
        temp = this.getNode((x + 1), (y + 1));
        if (temp.isWalkable() && !closedList.contains(temp)) {
          temp.setIsDiagonaly(true);
          adj.add(temp);
        }
      }

      if (x > 0 && y > 0) {
        temp = this.getNode((x - 1), (y - 1));
        if (temp.isWalkable() && !closedList.contains(temp)) {
          temp.setIsDiagonaly(true);
          adj.add(temp);
        }
      }

      if (x > 0 && y < higth) {
        temp = this.getNode((x - 1), (y + 1));
        if (temp.isWalkable() && !closedList.contains(temp)) {
          temp.setIsDiagonaly(true);
          adj.add(temp);
        }
      }

      if (x < width && y > 0) {
        temp = this.getNode((x + 1), (y - 1));
        if (temp.isWalkable() && !closedList.contains(temp)) {
          temp.setIsDiagonaly(true);
          adj.add(temp);
        }
      }
    }
    return adj;
  }
}
