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

package com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.seedpoint;

import com.actelion.research.orbit.imageAnalysis.segmenter.linalg.AbstractVector;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Cell {
  private int id;
  private Point center;
  private double center_height;
  private List<Integer> neighbours;
  private RealVector gradient;

  public Cell(int id) {
    this.id = id;
    this.neighbours = new ArrayList<Integer>();
    this.gradient = null;
    this.center = null;
    this.center_height = -1;
  }

  public int getId() {
    return id;
  }

  public void setCenter(int x, int y) {
    center = new Point(x, y);
  }

  public Point getCenter() {
    return center;
  }

  public void setCenterHeight(double center_height) {
    this.center_height = center_height;
  }

  public double getCenterHeight() {
    return center_height;
  }

  public void addNeighbour(int id) {
    if (!neighbours.contains(id))
      neighbours.add(id);
  }

  public List<Integer> getNeighbours() {
    return neighbours;
  }

  public RealVector getGradient() {
    return gradient;
  }

  public void calculateGradient(int idXPrev, int idXNext, int idYPrev, int idYNext,
      AbstractVector u) {

    double xdiff = (u.getEntry(idXNext) - u.getEntry(idXPrev)) / 2.0;
    double ydiff = (u.getEntry(idYNext) - u.getEntry(idYPrev)) / 2.0;
    gradient = new ArrayRealVector(new double[] { xdiff, ydiff });

  }
}
