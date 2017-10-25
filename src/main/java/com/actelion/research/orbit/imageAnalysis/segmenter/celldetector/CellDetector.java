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

package com.actelion.research.orbit.imageAnalysis.segmenter.celldetector;


import com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.imageprocessing.ccl.CCL;
import com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.imageprocessing.ccl.ImageObject;
import com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.polygon.GeometricFunctions;
import com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.polygon.PolygonExtractor;
import com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.polygon.QuickHull;
import com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.seedpoint.Cell;
import com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.seedpoint.SeedPointFinder;
import com.actelion.research.orbit.imageAnalysis.segmenter.linalg.AbstractVector;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CellDetector {

  private Cell meshCells[];
  private BufferedImage cellImage;
  private Rectangle meshBoundings;

  private List<SeedPointFinder> regions;
  private List<Polygon> polygons;
  private List<Point> seedPoints;

  private float settingsCellRadius;

  public CellDetector(BufferedImage cellImage, float cellRadius) {
    this.cellImage = cellImage;
    this.settingsCellRadius = cellRadius;
    this.polygons = null;
    this.regions = null;
    this.polygons = null;
    this.seedPoints = null;
  }

  public void setCellRadius(float value) {
    settingsCellRadius = value;
    regions = null;
  }

  public void exportPolygons(File file) {
    List<Polygon> polygons = getPolygons();
    int index = 0;

    try (FileWriter writer = new FileWriter(file)) {
      for (Polygon p : polygons) {
        writer.write((new Integer(index)).toString());
        writer.write(";");
        writer.write((new Integer(p.getBounds().x)).toString());
        writer.write(";");
        writer.write((new Integer(p.getBounds().y)).toString());
        writer.write(";");
        writer.write((new Integer(p.getBounds().width)).toString());
        writer.write(";");
        writer.write((new Integer(p.getBounds().height)).toString());
        writer.write(";");
        for (int i = 0; i < p.npoints; ++i) {
          writer.write((new Integer(p.xpoints[i])).toString());
          writer.write(";");
          writer.write((new Integer(p.ypoints[i])).toString());
          if (i != p.npoints - 1) {
            writer.write(";");
          }
        }
        writer.write(System.lineSeparator());
        ++index;
      }
      writer.flush();
      writer.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void initRegions() {
    // Extract region images
    CCL ccl = new CCL();
    List<ImageObject> regionImages = ccl.Process(cellImage, Color.WHITE.getRGB(), 0);

    // Create all sub regions
    int counter = 0;
    this.regions = new ArrayList<>();
    for (ImageObject imgObj : regionImages) {
      if (imgObj.getArea() > 4) {
        SeedPointFinder finder = new SeedPointFinder(imgObj, counter, meshCells,
            settingsCellRadius);
        regions.add(finder);
        counter++;
      }
    }
  }

  private void executeInitialSearch() {
    // Execute first seed point find iteration
    for (SeedPointFinder finder : this.regions) {
      finder.findMountains(0, 0);
    }
  }

  private boolean doConvexHullMatch(Polygon poly) {
    ArrayList<Point> allPts = new ArrayList<Point>(poly.npoints);
    for (int i = 0; i < poly.npoints; ++i) {
      allPts.add(new Point(poly.xpoints[i], poly.ypoints[i]));
    }

    // make convex hull
    QuickHull quickHull = new QuickHull();
    ArrayList<Point> hull = quickHull.quickHull(allPts);

    // check, how equal the hull and the polygons are
    int xPts[] = new int[hull.size()];
    int yPts[] = new int[hull.size()];
    for (int i = 0; i < hull.size(); ++i) {
      xPts[i] = hull.get(i).x;
      yPts[i] = hull.get(i).y;
    }
    Polygon polyHull = new Polygon(xPts, yPts, hull.size());

    // calculate sizes
    double area = GeometricFunctions.calcArea(poly);
    double areaHull = GeometricFunctions.calcArea(polyHull);

    return Math.abs(1 - area / areaHull) < 0.1;
  }

  private void executeSecondIteration() {
    // Collect Data
    int cntAverageArea = 0;
    double sumAverageArea = 0.0;
    for (SeedPointFinder finder : this.regions) {
      if (finder.getSeedPoints().size() == 1) {
        cntAverageArea++;
        sumAverageArea += finder.getSeedPoints().size() > 0
            ? finder.getArea() / finder.getSeedPoints().size() : 0;
      }
    }

    int cntAverageMonotoneArea = 0;
    double sumAverageMonotoneArea = 0.0;
    for (SeedPointFinder finder : this.regions) {
      ImageObject.ColorStatistics stat = finder.getImageObject().calcStat();
      double maxStd = Math.max(Math.max(stat.getStandardDeviationR(), stat.getStandardDeviationG()),
          stat.getStandardDeviationB());
      if (maxStd < 8) {
        cntAverageMonotoneArea++;
        sumAverageMonotoneArea += finder.getImageObject().getArea();
      }
    }

    // Collect further informations
    int cnt = 0;
    double fplba = 0.0;
    List<Double> vals = new ArrayList<>();
    for (SeedPointFinder finder : this.regions) {
      ImageObject.ColorStatistics stat = finder.getImageObject().calcStat();
      vals.add(Math.max(Math.max(stat.getStandardDeviationR(), stat.getStandardDeviationG()),
          stat.getStandardDeviationB()));
    }
    Collections.sort(vals, new Comparator<Double>() {
      @Override
      public int compare(Double o1, Double o2) {
        return Double.compare(o1, o2);
      }
    });

    for (int i = 0; i < 15 && i < vals.size(); i++) {
      cnt++;
      fplba += vals.get(i);
    }
    if (cnt > 0) {
      fplba /= cnt;
    }

    double sMax = Math.max(10, fplba);

    List<SeedPointFinder> tempRegions = new ArrayList<>();
    for (SeedPointFinder finder : this.regions) {
      ImageObject.ColorStatistics stat = finder.getImageObject().calcStat();
      double maxStd = Math.max(Math.max(stat.getStandardDeviationR(), stat.getStandardDeviationG()),
          stat.getStandardDeviationB());
      if (maxStd < sMax && calcOverlap(finder.getImageObject()) >= 0.85) {
        tempRegions.add(finder);
      }
    }

    if (tempRegions.isEmpty()) {
      for (SeedPointFinder finder : this.regions) {
        PolygonExtractor polygonExtractor = new PolygonExtractor(finder.getImageObject());
        Polygon poly = polygonExtractor.getPolygon();
        if (doConvexHullMatch(poly)) {
          tempRegions.add(finder);
        }
      }
    }

    if (tempRegions.isEmpty()) {
      for (SeedPointFinder finder : this.regions) {
        ImageObject.ColorStatistics stat = finder.getImageObject().calcStat();
        double maxStd = Math.max(
            Math.max(stat.getStandardDeviationR(), stat.getStandardDeviationG()),
            stat.getStandardDeviationB());
        if (maxStd < sMax) {
          tempRegions.add(finder);
        }
      }
    }

    // do some calculations
    float tmax = 0;
    float tmin = Integer.MAX_VALUE;
    for (SeedPointFinder region : tempRegions) {
      if (region.getImageObject().getArea() > tmax) {
        tmax = region.getImageObject().getArea();
      }
      if (region.getImageObject().getArea() < tmin) {
        tmin = region.getImageObject().getArea();
      }
    }
    float max = tmax;
    float min = tmin;
    double tempAvg = (max + min) / 2.0f;

    float aboveAvg = 0;
    float belowAvg = 0;
    for (SeedPointFinder mesh : tempRegions) {
      if (mesh.getImageObject().getArea() > tempAvg) {
        ++aboveAvg;
      } else {
        ++belowAvg;
      }
    }

    double avgArea = (max + min) / (2);

    double area = 0;
    if (belowAvg > 0 && aboveAvg > 0) {
      area = avgArea * 0.7;
    } else {
      if (cntAverageMonotoneArea > 0) {
        double areaMonoton = sumAverageMonotoneArea / cntAverageMonotoneArea;
        double mmax = Math.max(areaMonoton, max);
        double mmin = Math.min(areaMonoton, max);
        area = (2 * mmax + mmin) / 2;
      } else {
        area = 0;
      }
    }

    double param2 = area;

    if (cntAverageArea > 0) {
      double avg = sumAverageArea / cntAverageArea;
      for (SeedPointFinder finder : regions) {
        finder.findMountains(Math.sqrt(avg / Math.PI) * 1.2, Math.sqrt(param2 / Math.PI));
      }
    }
  }

  private double calcOverlap(ImageObject imgObj) {

    int inOverlap = 0;
    int allCell = 0;

    Rectangle boundings = imgObj.getBoundings();

    Ellipse2D ellipse = new Ellipse2D.Float(boundings.x, boundings.y, boundings.width,
        boundings.height);

    for (int y = boundings.y; y < boundings.y + boundings.getHeight(); ++y) {
      for (int x = boundings.x; x < boundings.x + boundings.getWidth(); ++x) {
        boolean isCell = imgObj.getColorFromGlobalCoordinates(x, y) != Color.WHITE.getRGB();
        boolean isOnEllipse = ellipse.contains(new Point(x, y));

        if (isCell && isOnEllipse) {
          ++inOverlap;
        }

        if (isCell || isOnEllipse) {
          ++allCell;
        }
      }
    }

    return (float) inOverlap / (float) allCell;
  }

  private void calculatePolygons() {
    Map<SeedPointFinder, List<Polygon>> tempPolygons = new ConcurrentHashMap<SeedPointFinder, List<Polygon>>();

    // Calculate Polygons
    for (SeedPointFinder finder : regions) {
      PolygonExtractor polygonExtractor = new PolygonExtractor(finder.getImageObject(),
          finder.getSeedPoints());
      List<Polygon> polygonList = polygonExtractor.calcCellPolygons();
      tempPolygons.put(finder, polygonList);
    }

    polygons = new ArrayList<Polygon>();
    for (List<Polygon> values : tempPolygons.values()) {
      polygons.addAll(values);
    }
  }

  private void collectSeedPoints() {
    seedPoints = new ArrayList<Point>();
    for (SeedPointFinder finder : regions) {
      seedPoints.addAll(finder.getSeedPoints());
    }
  }

  public void findCells() {
    if (regions == null) {
      initRegions();

      executeInitialSearch();

      executeSecondIteration();
    }
  }

  public List<Polygon> getPolygons() {
    findCells();

    if (polygons == null) {
      calculatePolygons();
    }

    return polygons;
  }

  public List<Point> getSeedPoints() {
    findCells();

    if (seedPoints == null) {
      collectSeedPoints();
    }

    return seedPoints;
  }

  public void setDataFromImage(AbstractVector u, int imageHeight, int imageWidth) {
    assert (u.getDimension() == imageHeight * imageWidth);

    // Init structures
    meshBoundings = new Rectangle();
    meshCells = new Cell[u.getDimension()];
    polygons = null;
    regions = null;

    double minX = Double.MAX_VALUE;
    double maxX = 0;
    double minY = Double.MAX_VALUE;
    double maxY = 0;

    int id = 0;
    for (int y = 0; y < imageHeight; y++) {
      for (int x = 0; x < imageWidth; x++) {

        Cell cell = new Cell(id);

        int idXPrev = id;
        int idXNext = id;
        int idYPrev = id;
        int idYNext = id;
        if (x > 0) {
          cell.addNeighbour(id - 1);
          idXPrev = id - 1;
        }
        if (x < imageWidth - 1) {
          cell.addNeighbour(id + 1);
          idXNext = id + 1;
        }
        if (y > 0) {
          cell.addNeighbour(id - imageWidth);
          idYPrev = id - 1;
        }
        if (y < imageHeight - 1) {
          cell.addNeighbour(id + imageWidth);
          idYNext = id + 1;
        }

        // Set statistic informations
        cell.setCenter(x, y);
        cell.setCenterHeight(u.getEntry(id));
        cell.calculateGradient(idXPrev, idXNext, idYPrev, idYNext, u);

        // Add Cell
        meshCells[cell.getId()] = cell;

        // Increment counter
        id++;
      }
    }

    // Register the Boundings
    registerBoundings(minX, minY, maxX, maxY);
  }

  private synchronized void registerBoundings(double xMin, double yMin, double xMax, double yMax) {
    meshBoundings.add(xMin, yMin);
    meshBoundings.add(xMax, yMax);
  }
}
