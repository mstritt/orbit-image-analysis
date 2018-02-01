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

/**
 * This class represents an AbstractNode. It has all the appropriate fields as well as getter and
 * setter to be used by the A* algorithm.
 * <p>
 * <p>
 * An <code>AbstractNode</code> has x- and y-coordinates and can be walkable or not. A previous
 * AbstractNode may be set, as well as the <code>fCosts</code>, <code>gCosts</code> and
 * <code>hCosts</code>.
 * <p>
 * <p>
 * <code>fCosts</code>: <code>gCosts</code> + <code>hCosts</code>
 * <p>
 * <code>gCosts</code>: calculated costs from start AbstractNode to this AbstractNode
 * <p>
 * <code>hCosts</code>: estimated costs to get from this AbstractNode to end AbstractNode
 * <p>
 * <p>
 * A subclass has to override the heuristic function
 * <p>
 * <code>sethCosts(AbstractNode endAbstractNode)</code>
 * <p>
 * 
 * @see PointNode#sethCosts(AbstractNode endNode) example Implementation using manhatten method
 *      <p>
 *
 * @version 1.0
 */
public abstract class AbstractNode {

  /** costs to move sideways from one square to another. */
  protected static final int BASICMOVEMENTCOST = 10;
  /** costs to move diagonally from one square to another. */
  protected static final int DIAGONALMOVEMENTCOST = 14;

  private int xPosition;
  private int yPosition;
  private boolean walkable;

  // for pathfinding:

  /** the previous AbstractNode of this one on the currently calculated path. */
  private AbstractNode previous;

  /** weather or not the move from previous to this AbstractNode is diagonally. */
  private boolean diagonally;

  /** optional extra penalty. */
  private int movementPanelty;

  // private int fCosts; // g + h costs

  /** calculated costs from start AbstractNode to this AbstractNode. */
  private int gCosts;

  /** estimated costs to get from this AbstractNode to end AbstractNode. */
  private int hCosts;

  /**
   * constructs a walkable AbstractNode with given coordinates.
   *
   * @param xPosition
   * @param yPosition
   */
  public AbstractNode(int xPosition, int yPosition) {
    this.xPosition = xPosition;
    this.yPosition = yPosition;
    this.walkable = true;
    this.movementPanelty = 0;
  }

  public void reset() {
    this.movementPanelty = 0;
    this.gCosts = 0;
    this.hCosts = 0;
    this.previous = null;
  }

  /**
   * returns weather or not the move from the <code>previousAbstractNode</code> was diagonally. If
   * it is not diagonal, it is sideways.
   *
   * @return
   */
  public boolean isDiagonaly() {
    return diagonally;
  }

  /**
   * sets weather or not the move from the <code>previousAbstractNode</code> was diagonally. If it
   * is not diagonal, it is sideways.
   *
   * @param isDiagonaly
   */
  public void setIsDiagonaly(boolean isDiagonaly) {
    this.diagonally = isDiagonaly;
  }

  /**
   * sets x and y coordinates.
   *
   * @param x
   * @param y
   */
  public void setCoordinates(int x, int y) {
    this.xPosition = x;
    this.yPosition = y;
  }

  /**
   * @return the xPosition
   */
  public int getxPosition() {
    return xPosition;
  }

  /**
   * @return the yPosition
   */
  public int getyPosition() {
    return yPosition;
  }

  /**
   * @return the walkable
   */
  public boolean isWalkable() {
    return walkable;
  }

  /**
   * @param walkable
   *          the walkable to set
   */
  public void setWalkable(boolean walkable) {
    this.walkable = walkable;
  }

  /**
   * returns the node set as previous node on the current path.
   *
   * @return the previous
   */
  public AbstractNode getPrevious() {
    return previous;
  }

  /**
   * @param previous
   *          the previous to set
   */
  public void setPrevious(AbstractNode previous) {
    this.previous = previous;
  }

  /**
   * sets a general penalty for the movement on this node.
   *
   * @param movementPanelty
   *          the movementPanelty to set
   */
  public void setMovementPanelty(int movementPanelty) {
    this.movementPanelty = movementPanelty;
  }

  /**
   * returns <code>gCosts</code> + <code>hCosts</code>.
   * <p>
   *
   *
   * @return the fCosts
   */
  public int getfCosts() {
    return gCosts + hCosts;
  }

  /**
   * returns the calculated costs from start AbstractNode to this AbstractNode.
   *
   * @return the gCosts
   */
  public int getgCosts() {
    return gCosts;
  }

  /**
   * sets gCosts to <code>gCosts</code> plus <code>movementPanelty</code> for this AbstractNode.
   *
   * @param gCosts
   *          the gCosts to set
   */
  private void setgCosts(int gCosts) {
    this.gCosts = gCosts + movementPanelty;
  }

  /**
   * sets gCosts to <code>gCosts</code> plus <code>movementPanelty</code> for this AbstractNode
   * given the previous AbstractNode as well as the basic cost from it to this AbstractNode.
   *
   * @param previousAbstractNode
   * @param basicCost
   */
  public void setgCosts(AbstractNode previousAbstractNode, int basicCost) {
    setgCosts(previousAbstractNode.getgCosts() + basicCost);
  }

  /**
   * sets gCosts to <code>gCosts</code> plus <code>movementPanelty</code> for this AbstractNode
   * given the previous AbstractNode.
   * <p>
   * It will assume <code>BASICMOVEMENTCOST</code> as the cost from
   * <code>previousAbstractNode</code> to itself if the movement is not diagonally, otherwise it
   * will assume <code>DIAGONALMOVEMENTCOST</code>. Weather or not it is diagonally is set in the
   * Map class method which finds the adjacent AbstractNodes.
   *
   * @param previousAbstractNode
   */
  public void setgCosts(AbstractNode previousAbstractNode) {
    if (diagonally) {
      setgCosts(previousAbstractNode, DIAGONALMOVEMENTCOST);
    } else {
      setgCosts(previousAbstractNode, BASICMOVEMENTCOST);
    }
  }

  /**
   * calculates - but does not set - g costs.
   * <p>
   * It will assume <code>BASICMOVEMENTCOST</code> as the cost from
   * <code>previousAbstractNode</code> to itself if the movement is not diagonally, otherwise it
   * will assume <code>DIAGONALMOVEMENTCOST</code>. Weather or not it is diagonally is set in the
   * Map class method which finds the adjacent AbstractNodes.
   *
   * @param previousAbstractNode
   * @return gCosts
   */
  public int calculategCosts(AbstractNode previousAbstractNode) {
    if (diagonally) {
      return (previousAbstractNode.getgCosts() + DIAGONALMOVEMENTCOST + movementPanelty);
    } else {
      return (previousAbstractNode.getgCosts() + BASICMOVEMENTCOST + movementPanelty);
    }
  }

  /**
   * calculates - but does not set - g costs, adding a movementPanelty.
   *
   * @param previousAbstractNode
   * @param movementCost
   *          costs from previous AbstractNode to this AbstractNode.
   * @return gCosts
   */
  public int calculategCosts(AbstractNode previousAbstractNode, int movementCost) {
    return (previousAbstractNode.getgCosts() + movementCost + movementPanelty);
  }

  /**
   * returns estimated costs to get from this AbstractNode to end AbstractNode.
   *
   * @return the hCosts
   */
  public int gethCosts() {
    return hCosts;
  }

  /**
   * sets hCosts.
   *
   * @param hCosts
   *          the hCosts to set
   */
  protected void sethCosts(int hCosts) {
    this.hCosts = hCosts;
  }

  /**
   * calculates hCosts for this AbstractNode to a given end AbstractNode. Uses Manhatten method.
   *
   * @param endAbstractNode
   */
  public abstract void sethCosts(AbstractNode endAbstractNode);

  /* @return the movementPanelty */
  /* private int getMovementPanelty() { return movementPanelty; } */

  /**
   * returns a String containing the coordinates, as well as h, f and g costs.
   *
   * @return
   */
  @Override
  public String toString() {
    return "(" + getxPosition() + ", " + getyPosition() + "): h: " + gethCosts() + " g: "
        + getgCosts() + " f: " + getfCosts();
  }

  /**
   * returns weather the coordinates of AbstractNodes are equal.
   *
   * @param obj
   * @return
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final AbstractNode other = (AbstractNode) obj;
    if (this.xPosition != other.xPosition) {
      return false;
    }
    if (this.yPosition != other.yPosition) {
      return false;
    }
    return true;
  }

  /**
   * returns hash code calculated with coordinates.
   *
   * @return
   */
  @Override
  public int hashCode() {
    int hash = 3;
    hash = 17 * hash + this.xPosition;
    hash = 17 * hash + this.yPosition;
    return hash;
  }

}
