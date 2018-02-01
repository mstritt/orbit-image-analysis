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


import com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.imageprocessing.ImageFunctions;
import com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.imageprocessing.ccl.ImageObject;

import java.awt.*;
import java.util.*;
import java.util.List;

public class SeedPointFinder {
  // Change has not a huge impact (Used for center calculation of a mountain)
  // Was initially used as a paint radius size in the first test versions
  private final static float MOUNTAIN_PAINT_SIZE = 4.0f;
  private final static float MINIMAL_CELL_AREA = 10;
  private final static int MINIMAL_BORDER_DISTANCE = 7;
  private final static Color BACKGROUND_COLOR = Color.WHITE;

  private SeedPointType type;
  private int id;
  private double minVal;
  private double maxVal;
  private double avgGradient;
  private double medianGradient;
  private double globalAvgGradient;
  private double globalMedianGradient;

  private ImageObject region;

  private Map<Integer, Cell> cells;
  private List<Point> seedPoints;
  private Cell globalCellData[];

  private float mustBeLowerRadis;
  private float cellRadius;
  private float settingsCellRadius;
  private float mountainPercentage;
  private boolean searchOnlyRealMountains;

  public SeedPointFinder(ImageObject region, int id, Cell globalCellData[],
      float settingsCellRadius) {
    this.id = id;
    this.region = region;
    this.globalCellData = globalCellData;
    this.cells = new HashMap<Integer, Cell>();
    this.settingsCellRadius = settingsCellRadius;

    extractRegionCells();
  }

  public int getId() {
    return id;
  }

  public SeedPointType getType() {
    return type;
  }

  public double getArea() {
    return region.getArea();
  }

  private void extractRegionCells() {
    // global gradient informations
    Double globalGradNorms[] = new Double[globalCellData.length];
    // List<Double> globalGradNorms = new ArrayList<Double>();
    double globalGradNormSum = 0;

    // regional gradient informations
    // List<Double> regionGradNorms = new ArrayList<Double>();
    double regionGradNormSum = 0;

    minVal = Integer.MAX_VALUE;
    maxVal = 0;
    cells.clear();

    // Add all cells which belong to the current sub region
    for (int i = 0; i < globalCellData.length; ++i) {
      if (region.contains(globalCellData[i].getCenter())) {
        minVal = Math.min(globalCellData[i].getCenterHeight(), minVal);
        maxVal = Math.max(globalCellData[i].getCenterHeight(), maxVal);

        cells.put(globalCellData[i].getId(), globalCellData[i]);

        // register gradient norm for regional cell
        double gradNorm = globalCellData[i].getGradient().getNorm();
        // regionGradNorms.add(gradNorm);
        regionGradNormSum += gradNorm;
      }

      // register gradient norm for global cell
      double gradNorm = globalCellData[i].getGradient().getNorm();
      globalGradNorms[i] = gradNorm;
      globalGradNormSum += gradNorm;
    }

    // Calculate local median and average gradient
    Double regionGradNorms[] = new Double[cells.size()];
    int cnt = 0;
    for (Cell cell : cells.values()) {
      regionGradNorms[cnt] = cell.getGradient().getNorm();
      cnt++;
    }
    medianGradient = calculateMedian(regionGradNorms);
    avgGradient = regionGradNormSum / cells.size();

    // calculate global median and average gradient
    globalMedianGradient = calculateMedian(globalGradNorms);
    globalAvgGradient = globalGradNormSum / cells.size();
  }

  private double calculateMedian(Double[] values) {
    Arrays.sort(values);
    if (values.length % 2 == 0) {
      return (values[values.length / 2] + values[values.length / 2 - 1]) / 2;
    } else {
      return values[values.length / 2];
    }
  }

  public List<Point> getSeedPoints() {
    return seedPoints;
  }

  public ImageObject getImageObject() {
    return region;
  }

  public List<Point> findMountains(double inCellRadius, double monotonRadius) {
    seedPoints = new ArrayList<Point>();
    mustBeLowerRadis = 5;

    // System.out.println(medianGradient + " / " + globalMedianGradient + " / " + avgGradient + " /
    // " +
    // globalAvgGradient);
    if ((avgGradient < globalMedianGradient * globalAvgGradient
        && Math.abs(medianGradient - avgGradient) < 2) && avgGradient > 4
        || globalMedianGradient < 0.5 /* minVal < 100 */ /* avgGradient > 2 */ /* || (avgGradient >
                                                                                * 4 && maxVal >=
                                                                                * 254.5 && minVal <
                                                                                * 130) */) {
      cellRadius = settingsCellRadius;
      mountainPercentage = 0.92f;
      searchOnlyRealMountains = true;
    } else {
      cellRadius = settingsCellRadius;
      mountainPercentage = 0.80f;
      searchOnlyRealMountains = false;
    }

    // Adjust radius due to the calculated sizes
    if (inCellRadius > 0) {
      if (searchOnlyRealMountains) {
        if (globalMedianGradient < 0.5) {
          cellRadius = (float) inCellRadius * 1.2f;
        } else {
          cellRadius = (float) inCellRadius * cellRadius / 15;
        }
      } else {
        if (monotonRadius > 0) {
          cellRadius = (float) monotonRadius * cellRadius / 10.0f;
        } else {
          cellRadius = (float) inCellRadius * cellRadius / 10.0f;
        }
      }
    }

    // Create mountain list
    seedPoints = createMountainList();

    // If no Mountains where found, add one to the center of the object
    if (seedPoints.isEmpty() && region.getArea() > MINIMAL_CELL_AREA) {
      Point center = ImageFunctions.getPointOnForegroundNotOnBorder(region.getImage(),
          Color.WHITE.getRGB());
      if (center != null) {
        center.translate(region.getBoundings().x, region.getBoundings().y);
      } else {
        center = new Point(region.getBoundings().x + region.getBoundings().width / 2,
            region.getBoundings().y + region.getBoundings().height / 2);
      }
      seedPoints.add(center);
      type = SeedPointType.ADDED_CENTER;
    } else {
      if (searchOnlyRealMountains) {
        type = SeedPointType.REAL_MOUNTAIN;
      } else {
        type = SeedPointType.FAKE_MOUNTAIN;
      }
    }

    return seedPoints;
  }

  /**
   * Calculates the Center out of a given list of points
   *
   * @param points
   *          Point List
   * @return Center Point
   */
  private Point calculateMountainCenter(List<Integer> points) {
    int minX = Integer.MAX_VALUE;
    int minY = Integer.MAX_VALUE;
    int maxX = 0;
    int maxY = 0;

    for (int id : points) {
      Cell c = cells.get(id);

      if (c != null) {
        minX = (c.getCenter().x < minX) ? c.getCenter().x : minX;
        minY = (c.getCenter().y < minY) ? c.getCenter().y : minY;

        maxX = (c.getCenter().x > maxX) ? c.getCenter().x : maxX;
        maxY = (c.getCenter().y > maxY) ? c.getCenter().y : maxY;
      }
    }

    return new Point((maxX + minX) / 2, (maxY + minY) / 2);
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

  private boolean isMountainValid(List<Integer> points) {
    Point center = calculateMountainCenter(points);

    if (ImageFunctions.belongsOneNeighbourToColour(region.getImage(), convertGlobalToLocal(center),
        BACKGROUND_COLOR.getRGB())) {
      return false;
    }

    int number_of_white_pixels = 0;
    int sample_count = 0;
    Rectangle boundings = region.getBoundings();
    int minX = center.x - MINIMAL_BORDER_DISTANCE;
    int maxX = center.x + MINIMAL_BORDER_DISTANCE + 1;
    int minY = center.y - MINIMAL_BORDER_DISTANCE;
    int maxY = center.y + MINIMAL_BORDER_DISTANCE + 1;
    int maxSquareDist = MINIMAL_BORDER_DISTANCE * MINIMAL_BORDER_DISTANCE;

    // Do not use parallelism, because there is not much to do (minimum_border_dist is most times <=
    // 10)
    for (int x = minX; x < maxX; x++) {
      for (int y = minY; y < maxY; y++) {
        if (x == center.x && y == center.y) {

          // Do not test the center itself.
          continue;
        }
        int dx = center.x - x;
        int dy = center.y - y;
        int squareDist = dx * dx + dy * dy;
        if (squareDist > maxSquareDist) {

          // To far away.
          continue;
        }
        if (x < boundings.x || x >= (boundings.x + boundings.width) || y < boundings.y
            || y >= (boundings.y + boundings.height)
            || region.getColorFromGlobalCoordinates(x, y) == Color.WHITE.getRGB()) {
          number_of_white_pixels++;
        }
        sample_count++;
      }
    }

    return (float) number_of_white_pixels / (float) sample_count < 0.15f;
  }

  private List<Point> createMountainList() {
    boolean cellProcessed[] = new boolean[globalCellData.length];
    boolean cellProcessedMustBeLower[] = new boolean[globalCellData.length];
    for (int i = 0; i < cellProcessed.length; ++i) {
      cellProcessed[i] = false;
      cellProcessedMustBeLower[i] = false;
    }

    List<List<Integer>> mountains = new ArrayList<List<Integer>>();
    List<Point> mountainCenters = new ArrayList<Point>();

    // Iterate from min to max
    for (int height = (int) minVal; height < (int) maxVal; height += 2) {

      // Find cells which belong to this height
      for (int cid : cells.keySet()) {
        Cell cell = cells.get(cid);

        if (cell != null && cellProcessed[cid] == false
            && Math.abs(cell.getCenterHeight() - height) < 1
            && region
                .getColorFromGlobalCoordinates(cell.getCenter().x,
                    cell.getCenter().y) != Color.WHITE
                        .getRGB()
            && ((searchOnlyRealMountains == true && areNeighboursSmallerAndNotWhite(cid)
                && checkMustBeLowerNeighbours(cell.getCenter(), cell.getCenterHeight(),
                    cellProcessedMustBeLower, cid))
                || searchOnlyRealMountains == false)) {

          List<Integer> test = new ArrayList<Integer>();
          test.add(cell.getId());

          if (isMountainValid(test)) {
            List<Integer> mountain_cells = findMountain(cellProcessed, cid);
            if (mountain_cells != null) {
              mountains.add(mountain_cells);
              mountainCenters.add(calculateMountainCenter(mountain_cells));
            }
          }
        }
      }
    }

    return mountainCenters;
  }

  private List<Integer> findMountain(boolean[] cellGlobalProcessed, int cell_id) {
    Cell main_cell = cells.get(cell_id);
    boolean nb_processed[] = new boolean[globalCellData.length];
    List<Integer> nb_cells = new ArrayList<Integer>();
    List<Integer> nb_cells_register = new ArrayList<Integer>();
    Point center = main_cell.getCenter();

    for (int i = 0; i < nb_processed.length; ++i) {
      nb_processed[i] = false;
    }

    // Collect all neighbours within a given distance
    addNeighbourInfos(cell_id, cellGlobalProcessed, nb_processed, nb_cells, nb_cells_register,
        center);

    // check, if it is a mountain
    double ref_height = main_cell.getCenterHeight();
    int greater_count = 0;

    // Count how many cells have a greater height
    for (int cid : nb_cells) {
      Cell c = cells.get(cid);
      if (c != null && c.getCenterHeight() > ref_height) {
        ++greater_count;
      }
    }

    // check, if in tollerance
    if ((float) greater_count / (float) nb_cells.size() > mountainPercentage) {
      nb_cells.clear();
      Collections.sort(nb_cells_register);
    } else {
      nb_cells_register = null;
    }

    return nb_cells_register;
  }

  private boolean areNeighboursSmallerAndNotWhite(int id) {
    Cell cell = cells.get(id);
    double height = cell.getCenterHeight();
    int counts = 0;

    for (int idx : cell.getNeighbours()) {
      Cell c = cells.get(idx);
      if (c != null && height > c.getCenterHeight()
          && region.getColorFromGlobalCoordinates(c.getCenter().x, c.getCenter().y) != Color.WHITE
              .getRGB()) {
        ++counts;
      }
    }

    return (float) counts / (float) cell.getNeighbours().size() <= 1.0
        - mountainPercentage /* 0.2f */;
  }

  private boolean checkMustBeLowerNeighbours(Point center, double center_height,
      boolean cellProcessedMustBeLower[], int cell_id) {
    Cell main_cell = cells.get(cell_id);
    cellProcessedMustBeLower[cell_id] = true;

    if (main_cell.getCenter().distance(center) < mustBeLowerRadis) {
      if (main_cell.getCenterHeight() < center_height
          && Math.abs(main_cell.getCenterHeight() - center_height) > 5.0f) {
        return false;
      }
    }

    // Iterate neighbours
    for (int id : main_cell.getNeighbours()) {
      // Check if not already processed
      Cell c = cells.get(id);
      if (c != null && cellProcessedMustBeLower[id] == false
          && c.getCenter().distance(center) <= mustBeLowerRadis) {
        if (!checkMustBeLowerNeighbours(center, center_height, cellProcessedMustBeLower, id)) {
          return false;
        }
      }
    }

    return true;
  }

  private void addNeighbourInfos(int cell_id, boolean cellGlobalProcessed[], boolean nb_processed[],
      List<Integer> nb_cells, List<Integer> nb_cells_register, Point center) {
    Cell main_cell = cells.get(cell_id);

    // mark as processed
    nb_processed[cell_id] = true;

    // load data
    Point pos = main_cell.getCenter();

    // check if register is allowed
    if (center.distance(pos) < MOUNTAIN_PAINT_SIZE) {
      nb_cells_register.add(cell_id);
    }

    // check if in check distance
    if (center.distance(pos) < cellRadius && main_cell.getCenterHeight() < maxVal) {
      cellGlobalProcessed[cell_id] = true;
      nb_cells.add(cell_id);
    }

    // Iterate neighbours
    for (int id : main_cell.getNeighbours()) {
      // Check if not already processed
      Cell c = cells.get(id);
      if (c != null && !nb_processed[id] && !cellGlobalProcessed[id]
          && center.distance(pos) < cellRadius && c.getCenterHeight() < maxVal) {

        pos = c.getCenter();
        addNeighbourInfos(id, cellGlobalProcessed, nb_processed, nb_cells, nb_cells_register,
            center);
      }
    }
  }
}
