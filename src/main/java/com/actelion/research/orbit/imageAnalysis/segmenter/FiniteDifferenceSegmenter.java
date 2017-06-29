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

package com.actelion.research.orbit.imageAnalysis.segmenter;

import com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.CellDetector;
import com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.imageprocessing.ImageFunctions;
import com.actelion.research.orbit.imageAnalysis.segmenter.finitedifference.FiniteDifferenceSolver;
import com.actelion.research.orbit.imageAnalysis.segmenter.linalg.AbstractVector;
import com.actelion.research.orbit.imageAnalysis.segmenter.math.ImageFunction;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

/**
 * Class detects cells on an image, where the background noise has already been removed, performing
 * the following steps:
 * <ul>
 * <li>Convert input image to gray-valued image</li>
 * <li>Smooth image by minimizing a functional of the form \int_\Omega (f-u )^2 + \alpha \Vert\nabla
 * u\Vert_2^2 dx. This minimization problem is transformed into a PDE and solved with finite
 * differences using the class
 * {@link com.actelion.research.orbit.imageAnalysis.segmenter.finitedifference.FiniteDifferenceSolver}</li>
 * <li>Detect the cells (polygons and seed points) by making use of class
 * {@link com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.CellDetector}</li>
 * </ul>
 */
public class FiniteDifferenceSegmenter {
  private double alpha;
  private float cellSize;
  private BufferedImage bgSegmentedImage;
  private BufferedImage grayCellImage;
  private BufferedImage polygonPaintedImage;
  private AbstractVector smoothImage;
  private CellDetector cellDetector;
  private List<Polygon> polygons;
  private List<Point> seedPoints;

  /**
   * Constructs a segmenter
   *
   * @param bgSegmentedImage
   *          background noise remove image
   * @param alpha
   *          parameter indicating the <i>smoothness</i> of the resulting image by minimizing the
   *          functional
   * @param cellRadius
   *          Approximate cell radius in pixel
   */
  public FiniteDifferenceSegmenter(BufferedImage bgSegmentedImage, double alpha, float cellRadius) {
    super();
    this.cellSize = cellRadius;
    this.bgSegmentedImage = bgSegmentedImage;
    this.alpha = alpha;
  }

  /**
   * Perfoms the segmentation
   */
  public void segment() {
    grayCellImage = ImageFunctions.convertToGrayscale(bgSegmentedImage);
    smoothImage();
    detectCells();
  }

  private void smoothImage() {
    FiniteDifferenceSolver finiteDifferenceSolver = new FiniteDifferenceSolver(
        new ImageFunction(grayCellImage), new ImageFunction(grayCellImage),
        grayCellImage.getHeight(), grayCellImage.getWidth());
    finiteDifferenceSolver.setAlpha(this.alpha);
    finiteDifferenceSolver.assemble();
    finiteDifferenceSolver.solve();
    smoothImage = finiteDifferenceSolver.getSolution();
  }

  private void detectCells() {
    cellDetector = new CellDetector(grayCellImage, cellSize);
    cellDetector.setDataFromImage(smoothImage, grayCellImage.getHeight(), grayCellImage.getWidth());
    cellDetector.findCells();
    polygons = cellDetector.getPolygons();
    seedPoints = cellDetector.getSeedPoints();
    polygonPaintedImage = ImageFunctions.paintPolygons(bgSegmentedImage, polygons, seedPoints);
  }

  /**
   * Exports the detected polygons into a csv file
   *
   * @param file
   *          object to export the polygons into
   */
  public void exportToCSV(File file) {
    cellDetector.exportPolygons(file);
  }

  /**
   * Returns the gray valued image
   *
   * @return gray valued image
   */
  public BufferedImage getGrayCellImage() {
    return grayCellImage;
  }

  /**
   * Returns the smoothed image after minimizing the functional as a vector representing every pixel
   * values of the smoothed image. The values are stored in a row based fashion
   *
   * @return smoothed image
   */
  public AbstractVector getSmoothImage() {
    return smoothImage;
  }

  /**
   * Returns the original image overlaid with the polygons and seed points
   *
   * @return original image overlaid with the polygons and seed points
   */
  public BufferedImage getPolygonPaintedImage() {
    return polygonPaintedImage;
  }

  /**
   * Returns the list of detected polygons
   *
   * @return list of detected polygons
   */
  public List<Polygon> getPolygons() {
    return polygons;
  }

  /**
   * Returns the list of detected seed points (one per cell)
   *
   * @return list of detected seed points
   */
  public List<Point> getSeedPoints() {
    return seedPoints;
  }

}
