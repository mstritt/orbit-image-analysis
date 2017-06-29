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
