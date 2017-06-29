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

package com.actelion.research.orbit.imageAnalysis.segmenter.finitedifference;


import com.actelion.research.orbit.imageAnalysis.segmenter.geometry.Vertex;
import com.actelion.research.orbit.imageAnalysis.segmenter.linalg.AbstractFactory;
import com.actelion.research.orbit.imageAnalysis.segmenter.linalg.AbstractMatrix;
import com.actelion.research.orbit.imageAnalysis.segmenter.linalg.AbstractSolver;
import com.actelion.research.orbit.imageAnalysis.segmenter.linalg.AbstractVector;
import com.actelion.research.orbit.imageAnalysis.segmenter.math.Function;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Class to solve PDE of form:<br>
 * - alpha * div(grad u) + beta * u = gamma * f in Omega<br>
 * u = b on Omega<br>
 * where Omega = [0,n-1] * [0,m-1].
 */
public class FiniteDifferenceSolver {

  private Function force;
  private Function boundary;
  private int m;
  private int n;
  private double alpha;
  private double beta;
  private double gamma;
  private AbstractMatrix systemMatrix;
  private AbstractVector rhs;
  private AbstractVector solution;
  private boolean assembled;
  private boolean solved;

  /**
   * Constructs the solver
   *
   * @param force
   *          RHS of PDE
   * @param boundary
   *          Dirichlet boundary
   * @param m
   *          Height of Omega
   * @param n
   *          Width of Omega
   */
  public FiniteDifferenceSolver(Function force, Function boundary, int m, int n) {
    super();
    this.force = force;
    this.boundary = boundary;
    this.alpha = 1.0;
    this.beta = 1.0;
    this.gamma = 1.0;
    this.m = m;
    this.n = n;
    this.systemMatrix = null;
    this.assembled = false;
    this.solved = false;
  }

  /**
   * Solves the previously assembled linear system Ax=b
   */
  public void solve() {
    if (!assembled) {
      throw new RuntimeException("Please assemble system first");
    }
    AbstractSolver solver = AbstractFactory.createSolver();
    AbstractVector uInner = solver.solve(systemMatrix, rhs);
    setInterior(uInner);
    solved = true;
  }

  /**
   * Assembles the linear system Ax=b
   */
  public void assemble() {
    solution = AbstractFactory.createVector(m * n);
    setBoundary();
    rhs = createRightHandSide();
    systemMatrix = createSystemMatrix();
    systemMatrix.scalarMultiply(alpha);
    AbstractMatrix identity = createIdentiyMatrix((m - 2) * (n - 2), beta);
    systemMatrix = systemMatrix.add(identity);
    assembled = true;
  }

  private AbstractMatrix createSystemMatrix() {
    int mInternal = m - 2;
    int nInternal = n - 2;
    int dim = mInternal * nInternal;
    AbstractMatrix systemMatrix = AbstractFactory.createSparseMatrix(dim, dim);
    AbstractMatrix dMatrix = createDMatrix(nInternal);
    AbstractMatrix identity = createIdentiyMatrix(nInternal, -1);
    systemMatrix.setSubMatrix(dMatrix, 0, 0);
    systemMatrix.setSubMatrix(identity, 0, nInternal);

    systemMatrix.setSubMatrix(dMatrix, mInternal * nInternal - nInternal,
        mInternal * nInternal - nInternal);
    systemMatrix.setSubMatrix(identity, mInternal * nInternal - nInternal,
        mInternal * nInternal - 2 * nInternal);

    for (int i = 1; i < mInternal - 1; i++) {
      systemMatrix.setSubMatrix(identity, i * nInternal, (i - 1) * nInternal);
      systemMatrix.setSubMatrix(dMatrix, i * nInternal, i * nInternal);
      systemMatrix.setSubMatrix(identity, i * nInternal, (i + 1) * nInternal);
    }

    return systemMatrix;
  }

  private AbstractMatrix createIdentiyMatrix(int dim, double scalar) {
    AbstractMatrix identity = AbstractFactory.createSparseMatrix(dim, dim);
    for (int i = 0; i < dim; i++) {
      identity.setEntry(i, i, scalar);
    }
    return identity;
  }

  private AbstractMatrix createDMatrix(int dim) {
    AbstractMatrix d = AbstractFactory.createSparseMatrix(dim, dim);
    d.setEntry(0, 0, 4);
    d.setEntry(0, 1, -1);
    d.setEntry(dim - 1, dim - 2, -1);
    d.setEntry(dim - 1, dim - 1, 4);
    for (int i = 1; i < dim - 1; i++) {
      d.setEntry(i, i - 1, -1.0);
      d.setEntry(i, i, 4.0);
      d.setEntry(i, i + 1, -1.0);
    }
    return d;
  }

  private void setBoundary() {
    double x = 0, y = 0;
    int index = 0;

    // boundary y = 0
    for (int i = 0; i < n; i++) {
      x = i;
      y = 0;
      Vertex v = new Vertex(x, y);
      double value = boundary.getValue(v);
      solution.setEntry(i, value);
    }

    // boundary y = m -1
    index = n * (m - 1);
    for (int i = 0; i < n; i++) {
      x = i;
      y = m - 1;
      Vertex v = new Vertex(x, y);
      double value = boundary.getValue(v);
      solution.setEntry(index, value);
      index++;
    }

    // boundary x = 0
    index = n;
    for (int i = 1; i < m; i++) {
      x = 0;
      y = i;
      Vertex v = new Vertex(x, y);
      double value = boundary.getValue(v);
      solution.setEntry(index, value);
      index += n;
    }

    // boundary x = n - 1
    index = 2 * n - 1;
    for (int i = 1; i < m; i++) {
      x = n - 1;
      y = i;
      Vertex v = new Vertex(x, y);
      double value = boundary.getValue(v);
      solution.setEntry(index, value);
      index += n;
    }
  }

  private void setInterior(AbstractVector uInner) {
    int index = 0;

    for (int i = 1; i < m - 1; i++) {
      for (int j = 1; j < n - 1; j++) {
        double value = uInner.getEntry(index);
        solution.setEntry(i * n + j, value);
        index++;
      }
    }
  }

  /**
   * Writes solution to a file
   *
   * @param filename
   *          filename to destination
   */
  public void writeSolutionToFile(String filename) {
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(new File(filename));
      for (int j = 0; j < n; j += 4) {
        for (int i = 0; i < m; i += 4) {
          double x = j;
          double y = i;
          double value = solution.getEntry(i * n + j);
          writer.println(x + " " + y + " " + value);
        }
        writer.println();
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e.getMessage());
    } finally {
      writer.close();
    }

  }

  private AbstractVector createRightHandSide() {
    AbstractVector b = AbstractFactory.createVector((m - 2) * (n - 2));
    int index = 0;
    for (int i = 1; i < m - 1; i++) {
      for (int j = 1; j < n - 1; j++) {
        double x = j;
        double y = i;
        Vertex v = new Vertex(x, y);
        double value = gamma * force.getValue(v);
        if (j == 1) {
          x = 0;
          y = i;
          v = new Vertex(x, y);
          value += alpha * boundary.getValue(v);
        }
        if (j == n - 2) {
          x = n - 1;
          y = i;
          v = new Vertex(x, y);
          value += alpha * boundary.getValue(v);
        }
        if (i == 1) {
          x = j;
          y = 0;
          v = new Vertex(x, y);
          value += alpha * boundary.getValue(v);
        }
        if (i == n - 2) {
          x = j;
          y = m - 1;
          v = new Vertex(x, y);
          value += alpha * boundary.getValue(v);
        }
        b.setEntry(index, value);
        index++;
      }
    }
    return b;
  }

  /**
   * Gets the force function
   *
   * @return force function
   */
  public Function getForce() {
    return force;
  }

  /**
   * Gets the boundary function
   *
   * @return boundary function
   */
  public Function getBoundary() {
    return boundary;
  }

  /**
   * Gets the height of the domain Omega
   *
   * @return height of the domain Omega
   */
  public int getM() {
    return m;
  }

  /**
   * Gets the width of the domain Omega
   *
   * @return width of the domain Omega
   */
  public int getN() {
    return n;
  }

  /**
   * Gets alpha
   *
   * @return alpha
   */
  public double getAlpha() {
    return alpha;
  }

  /**
   * Gets beta
   *
   * @return beta
   */
  public double getBeta() {
    return beta;
  }

  /**
   * Gets gamma
   *
   * @return gamma
   */
  public double getGamma() {
    return gamma;
  }

  /**
   * Checks whether the linear system is assembled
   *
   * @return <i>True</i> if linear system is assembled
   */
  public boolean isAssembled() {
    return assembled;
  }

  /**
   * Sets beta
   *
   * @param beta
   *          beta value
   */
  public void setBeta(double beta) {
    this.beta = beta;
  }

  /**
   * Sets gamma
   *
   * @param gamma
   *          gamma value
   */
  public void setGamma(double gamma) {
    this.gamma = gamma;
  }

  /**
   * Sets alpha
   *
   * @param alpha
   *          alpha value
   */
  public void setAlpha(double alpha) {
    this.alpha = alpha;
  }

  /**
   * Returns the RHS of the linear system Ax=b
   *
   * @return RHS of the linear system Ax=b
   */
  public AbstractVector getRhs() {
    return rhs;
  }

  /**
   * Returns the system matrix A of the linear system Ax=b
   *
   * @return system matrix A of the linear system Ax=b
   */
  public AbstractMatrix getSystemMatrix() {
    return systemMatrix;
  }

  /**
   * Returns the solution vector x of the linear system Ax=b
   *
   * @return solution vector x of the linear system Ax=b
   */
  public AbstractVector getSolution() {
    if (!solved) {
      throw new RuntimeException("Please solve system first");
    }
    return solution;
  }

}
