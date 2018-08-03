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

package com.actelion.research.orbit.imageAnalysis.utils;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * calculates several metrics like area or perimeter of a polygon. These metrics can be used
 * as features.
 * see http://www.gcsca.net/IJ/Shapes.html
 *
 * @author stritma1
 * @since 26.04.2010
 */
public class PolygonMetrics {

    private static final double EPSILON = 0.00000001d;
    private Polygon p = null;

    public PolygonMetrics(Polygon polygon) {
        this.p = polygon;
    }

    /**
     * Calculates the ares for all kind of polygons using a point-in-polygon test. For very large polygons (bounding box > 1000000 pixel) the
     * getAresNonIntersecting method is used.
     *
     * @return
     */
    public double getArea() {
        if (p==null) return 0;
        Rectangle bb = p.getBounds();
        if (bb.width * (long) bb.height > 1000000L) return getAreaNonIntersecting();
        double area = 0d;
        for (int x = bb.x; x < bb.getMaxX(); x++)
            for (int y = bb.y; y < bb.getMaxY(); y++) {
                if (p.contains(x, y)) area++;
            }
        return area;
    }


    /**
     * Calculates the area of the polygon for non-intersecting polygons. Polygon can be in CW or CCW.
     *
     * @return
     */
    public double getAreaNonIntersecting() {
        return getAreaNonIntersecting(p);
    }

    /**
     * Calculates the area of the polygon for non-intersecting polygons. Polygon can be in CW or CCW.
     *
     * @return
     */
    public double getAreaNonIntersecting(Polygon p) {
        if (p==null) return 0;
        double area = 0d;
//		for (int i=0; i<=(p.npoints-1); i++) {
//			if(i == p.npoints-1)
//				area += (p.xpoints[i]*p.ypoints[0])-(p.xpoints[0]*p.ypoints[i]);
//			else
//				area += (p.xpoints[i]*p.ypoints[i+1])-(p.xpoints[i+1]*p.ypoints[i]);
//		}

        int i1;
        for (int i = 0; i < p.npoints; i++) {
            i1 = (i + 1) % (p.npoints);
            //area += (p.xpoints[i]+p.xpoints[i1])*(p.ypoints[i1]-p.ypoints[i]);
            area += (p.xpoints[i] * p.ypoints[i1]) - (p.xpoints[i1] * p.ypoints[i]);
        }

        area /= 2d;
        if (area < 0) area *= -1; // if the polygon is CCW
        return area;
    }

    public double getPerimeter() {
        return getPerimeter(p);
    }

    /**
     * calculates the perimeter of the polygon. Polygon can be in CW or CCW.
     *
     * @return
     */
    public double getPerimeter(Polygon p) {
        if (p==null) return 0;
        double perimeter = 0d;
        int dx, dy;
        for (int i = 0; i < (p.npoints - 1); i++) {
            dx = p.xpoints[i + 1] - p.xpoints[i];
            dy = p.ypoints[i + 1] - p.ypoints[i];
            perimeter += Math.sqrt(dx * dx + dy * dy);
        } // and now the closing line (last to first point)
        dx = p.xpoints[p.npoints - 1] - p.xpoints[0];
        dy = p.ypoints[p.npoints - 1] - p.ypoints[0];
        perimeter += Math.sqrt(dx * dx + dy * dy);
        if (perimeter < 0) perimeter *= -1d;
        return perimeter;
    }

    /**
     * returns the circularity = 4*Pi*area / perimeter^2 (if perimeter>EPSILON, else Double.NaN)<br>
     * Also called form factor (in imageJ).
     *
     * @return
     * @see http://en.wikipedia.org/wiki/Shape_factor_%28image_analysis_and_microscopy%29
     * Update 19.2.2015: 4+Pi*A / P^2 (before it was without 4*Pi)
     */
    public double getCircularity(double area, double perimeter) {
        double circularity = 0d;
        if (perimeter > EPSILON)
            circularity = (4d * Math.PI * area) / (perimeter * perimeter);
        return circularity;
    }

    /**
     * Solidity: area/ convex area
     */
    public double getSolidity(Polygon convexHull, double area) {
        double areaCH = getAreaNonIntersecting(convexHull);

        double solidity = 0d;
        if (areaCH > 0) {
            solidity = area / areaCH;
        }

        return solidity;
    }

    public double getConvexity(Polygon convexHull, double perimeter) {
        if (perimeter < OrbitUtils.EPSILON) return 0;
        else return getPerimeter(convexHull) / perimeter;
    }

    /**
     * 4*area/pi*sqr(major axis)
     */
    public double getRoundnessNew(double area, double majorAxis) {
        return 4d * area / (Math.PI * majorAxis * majorAxis);
    }

    /**
     * sqrt((4/pi)*area)/major axis
     */
    public double getCompactness(double area, double majorAxis) {
        if (area < OrbitUtils.EPSILON || majorAxis < OrbitUtils.EPSILON) return 0d;
        else return Math.sqrt((4d / Math.PI) * area) / majorAxis;
    }

    /**
     * major axis/minor axis  (usually it's min/max - here it's inverted!)
     */
    public double getAspectRatio(double[] ferets) {
        double majorAxis = ferets[0];
        double minorAxis = ferets[2];
        if (minorAxis < OrbitUtils.EPSILON) return 0d;
        else return majorAxis / minorAxis;
    }


    /**
     * calculates the centroid of the polygon. Polygon can be in CW or CCW.<br>
     * Returns null if area of polygon < EPSILON
     *
     * @param isCW if true, the result will be multiplied by -1. Otherwise a CW order is assumed.
     * @return
     */
    public Point2D getCentroid(boolean isCW) {
        double area = getArea();
        if (area <= EPSILON) return null;
        double cx = 0.0d, cy = 0.0d;
        for (int i = 0; i < p.npoints - 1; i++) {
            cx = cx + (p.xpoints[i] + p.xpoints[i + 1]) * (p.ypoints[i] * p.xpoints[i + 1] - p.xpoints[i] * p.ypoints[i + 1]);
            cy = cy + (p.ypoints[i] + p.ypoints[i + 1]) * (p.ypoints[i] * p.xpoints[i + 1] - p.xpoints[i] * p.ypoints[i + 1]);
        }
        // last point p[n] = p[0]
        cx = cx + (p.xpoints[p.npoints - 1] + p.xpoints[0]) * (p.ypoints[p.npoints - 1] * p.xpoints[0] - p.xpoints[p.npoints - 1] * p.ypoints[0]);
        cy = cy + (p.ypoints[p.npoints - 1] + p.ypoints[0]) * (p.ypoints[p.npoints - 1] * p.xpoints[0] - p.xpoints[p.npoints - 1] * p.ypoints[0]);

        cx /= (6d * area);
        cy /= (6d * area);
        if (isCW) {
            cx *= -1;
            cy *= -1;
        }

        return new Point2D.Double(cx, cy);
    }


    public Point2D getCenter() {
        double cx = 0.0d, cy = 0.0d;
        for (int i = 0; i < p.npoints; i++) {
            cx += p.xpoints[i];
            cy += p.ypoints[i];
        }
        cx /= (double) p.npoints;
        cy /= (double) p.npoints;

        return new Point2D.Double(cx, cy);
    }


    /**
     * Calculates the roundness = aberrations of mean distance to centroid.<br>
     * This implementation is an approximation and takes only the given edgepoints into
     * account. This leads to the fact that e.g. a rectangle with 4 edge points has a roundness
     * of 0.<br>
     * It works fine if the number of points in the polygon is higher.
     *
     * @param isCW
     * @return
     */
    public double getRoundness(boolean isCW) {
        double r = 0d;
        double[] dist = new double[p.npoints];
        //Point2D c = getCentroid(isCW);
        Point2D c = getCenter(); // upd 24.02.2015 center is more accurate than centroid
        if (c == null) return 0;
        double meanD = 0d;
        // first calculate the mean dist and remember distances
        for (int i = 0; i < p.npoints; i++) {
            dist[i] = c.distance(p.xpoints[i], p.ypoints[i]);
            meanD += dist[i];
        }
        meanD /= p.npoints;
        // calculate aberration to mean distance
        for (int i = 0; i < p.npoints; i++) {
            r += Math.abs(dist[i] - meanD);
        }
        r /= (p.npoints * meanD); // bugfix 30.11.2010   /  24.2.2015: normalization by *meanD
        dist = null;
        return r;
    }


    public Polygon getScaledPolygon(float scaleFactor, boolean isCCW) {
        if (p == null) return null;
        Point2D center = getCentroid(isCCW);
        if (center == null) return p;
        Polygon pSc = new Polygon();
        for (int i = 0; i < p.npoints; i++) {
            double x = p.xpoints[i] - center.getX();
            double y = p.ypoints[i] - center.getY();
            x *= scaleFactor;
            y *= scaleFactor;
            x += center.getX();
            y += center.getY();
            pSc.addPoint((int) x, (int) y);
        }
        return pSc;
    }

    public Polygon getScaledSimplePolygon(float scaleFactor) {
        if (p == null) return null;
        Polygon pSc = new Polygon();
        for (int i = 0; i < p.npoints; i++) {
            double x = p.xpoints[i];
            double y = p.ypoints[i];
            x *= scaleFactor;
            y *= scaleFactor;
            pSc.addPoint((int) x, (int) y);
        }
        return pSc;
    }

    public Polygon getPolygon() {
        return p;
    }

    public void setPolygon(Polygon polygon) {
        this.p = polygon;
    }


}
