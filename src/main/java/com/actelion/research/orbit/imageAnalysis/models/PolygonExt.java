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

package com.actelion.research.orbit.imageAnalysis.models;

import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import org.apache.commons.lang3.SerializationUtils;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;


/**
 * Extends the class Polygon with the property closed. Can be used to check if a polygon should be
 * drawn closed (e.g. start and endpoint are connected) or open.
 */
public class PolygonExt extends Polygon implements IScaleableShape, Cloneable {

    private static final long serialVersionUID = 2L;
    private final double useRasterizedContainsThresh = 500d;
    private final double rasterMaxLength = 2000d; // err ~ 0.0005 millimeter

    private boolean closed = false;
    private double scale = 100.0d;
    private Point viewPortOffs = new Point(0, 0);
    private transient PolygonExt scaledInstance = null;
    protected boolean inverse = false;
    protected boolean onlyPoints = false;

    //protected BufferedImage bufImg = null;
    protected transient Raster bufRaster = null;
    protected transient double bufImgScale = 100d;
    private int rdfId = 0;


    public PolygonExt() {

    }


    public PolygonExt(Polygon p) {
        for (int i = 0; i < p.npoints; i++)
            addPoint(p.xpoints[i], p.ypoints[i]);
        setClosed(true);
        if (p instanceof PolygonExt) {
            setClosed(((PolygonExt) p).isClosed());
            setOnlyPoints(((PolygonExt) p).isOnlyPoints());
        }
    }

    public boolean containsImg(double x, double y) {
        //if (!getBounds().contains(x,y)) return false;
        if (bufRaster == null) {
            createBufImg();
        }
        double sx = (x - getBounds2D().getMinX()) * (bufImgScale / 100d);
        double sy = (y - getBounds2D().getMinY()) * (bufImgScale / 100d);
        if (sx < 0 || sy < 0 || sx >= bufRaster.getWidth() || sy >= bufRaster.getHeight()) return false;
        boolean b = bufRaster.getSample((int) sx, (int) sy, 0) > 0;
        //System.out.println("x,y:"+x+","+y+"  sx,sy:"+sx+","+sy+" "+getBounds().getMaxX()+"/"+getBounds().getMaxY()+"  bb:"+getBounds()+"  imgBounds:"+bufImg.getWidth()+"x"+bufImg.getHeight());
        return b;
    }

    protected Raster createBufImg() {
        if (bufRaster != null) return bufRaster;

        Rectangle2D bb = getBounds2D();
        double l = bb.getWidth();
        if (bb.getHeight() > l) l = bb.getHeight();
        bufImgScale = 100d;
        PolygonExt pe = this;
        if (l > rasterMaxLength) {
            setScale(100d);    // bugfix 27.03.2015 (shape has already a scale)
            bufImgScale = ((rasterMaxLength / l) * 100d);
            pe = this.getScaledInstance(bufImgScale, new Point(0, 0));
            bb = pe.getBounds2D();
        }
        int w = (int) Math.ceil(bb.getWidth());
        int h = (int) Math.ceil(bb.getHeight());
        //System.out.println("w: "+w+"  h: "+h+"  bb: "+bb);

        BufferedImage bufImg = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g2d = bufImg.createGraphics();
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, w, h);
        g2d.translate(-bb.getX(), -bb.getY());
        g2d.setColor(Color.white);
        g2d.fillPolygon(pe);
        bufRaster = bufImg.getRaster();
        return bufRaster;
    }

    public double getArea(double scale) {
        bufRaster = null;
        createBufImg();
        long pixelInROI = 0;
        for (int y = 0; y < bufRaster.getHeight(); y++) {
            for (int x = 0; x < bufRaster.getWidth(); x++) {
                if (bufRaster.getSample(x, y, 0) > 0) {
                    pixelInROI++;
                }
            }
        }
        double squareMuM = scale * scale;
        return (((double) pixelInROI * squareMuM) * (100d / bufImgScale) * (100d / bufImgScale));
    }

    /**
     * For big polygons (npoints>useRasterizedContainsThresh)containsImg is used.<br/>
     * This pixelizes the polygon which takes some time the very first time, but is very fast for the next contains queries.
     * However, to compute the area the method getArea should be used instead.
     */
    @Override
    public boolean contains(double x, double y) {
        if (npoints < useRasterizedContainsThresh)
            return super.contains(x, y);
        else return containsImg(x, y);
    }


    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }


    public void move(double dx, double dy) {
        double scaleFactor = (100d / scale);
        double dxx = dx / scaleFactor;
        double dyy = dy / scaleFactor;
        for (int i = 0; i < npoints; i++) {
            xpoints[i] += dxx;
            ypoints[i] += dyy;
        }
        invalidate();
        scaledInstance = null;
        bufRaster = null;
    }

    public void rotate(double angle, Point2D center) {
        for (int i = 0; i < npoints; i++) {
            double x = center.getX() + (Math.cos(Math.toRadians(angle)) * (xpoints[i] - center.getX()) - Math.sin(Math.toRadians(angle)) * (ypoints[i] - center.getY()));
            double y = center.getY() + (Math.sin(Math.toRadians(angle)) * (xpoints[i] - center.getX()) + Math.cos(Math.toRadians(angle)) * (ypoints[i] - center.getY()));
            xpoints[i] = (int) (Math.round(x));
            ypoints[i] = (int) (Math.round(y));
        }
        invalidate();
        scaledInstance = null;
        bufRaster = null;
    }

    /**
     * Convenience method for getScaledInstance(double currentScale, Point currentOffset).
     * @param currentScale The scale
     * @return A scaled instance of the PolygonExt.
     */
    public PolygonExt getScaledInstance(double currentScale) {
        return getScaledInstance(currentScale, new Point(0,0));
    }

    /**
     * Get a scaled instance of PolygonExt.
     * @param currentScale The scale
     * @param currentOffset Currently not used.
     * @return A scaled instance of the PolygonExt.
     */
    public PolygonExt getScaledInstance(double currentScale, Point currentOffset) {
        //return this;

        if (Math.abs(scale - currentScale) <= OrbitUtils.EPSILON && !inverse) return this;
        if ((scaledInstance != null) && (Math.abs(scaledInstance.getScale() - currentScale) <= OrbitUtils.EPSILON) && (scaledInstance.isClosed() == this.closed) && (scaledInstance.isInverse() == inverse)) {
            return scaledInstance;
        }
        double scaleFactor = (currentScale / scale);
        PolygonExt np;
        if (!inverse) np = new PolygonExt();
        else {
            np = new PolygonExtInvers(new Rectangle(Integer.MAX_VALUE, Integer.MAX_VALUE));
        }
        np.setScale(currentScale);

        // calculate the offset - see RecognitionFrame.paint
            /*
            AffineTransform trTranspInv =AffineTransform.getTranslateInstance(-currentOffset.x, -currentOffset.y);
			AffineTransform  trScale= AffineTransform.getScaleInstance(scaleFactor,scaleFactor);
			trScale.concatenate(trTranspInv);
			AffineTransform trConj =AffineTransform.getTranslateInstance(currentOffset.x, currentOffset.y);
			trConj.concatenate(trScale);
			*/

        for (int i = 0; i < npoints; i++) {
            np.addPoint((int) (xpoints[i] * scaleFactor), (int) (ypoints[i] * scaleFactor));
        }
        //np.translate((int)trConj.getTranslateX(),(int)trConj.getTranslateY());

        np.setClosed(this.closed);
        np.setOnlyPoints(this.onlyPoints);

        scaledInstance = np;
        return np;

    }

    /**
     * Returns a scaled version of the polygon (real-scaling). The new scale-factor will remain!
     *
     * @param factor The scale factor (in percent).
     * @return The scaled polygon.
     */
    public PolygonExt scale(double factor, Point2D center) {
        double scaleFactor = (factor / scale);
        PolygonExt np;
        if (!inverse) np = new PolygonExt();
        else {
            np = new PolygonExtInvers(new Rectangle(Integer.MAX_VALUE, Integer.MAX_VALUE));
        }
        np.setScale(scale);

        for (int i = 0; i < npoints; i++) {
            double x = xpoints[i];
            double y = ypoints[i];

            x -= center.getX();
            x *= scaleFactor;
            x += center.getX();

            y -= center.getY();
            y *= scaleFactor;
            y += center.getY();

            if (x < 0) x *= -1d;
            if (y < 0) y *= -1d;

            np.addPoint((int) x, (int) y);
        }

        np.setClosed(this.closed);
        np.setOnlyPoints(this.onlyPoints);
        return np;
    }

    /**
     * draws the polygon to graphics g. If this.isClosed the normal g.drawPolygon method will be called,
     * otherwise the points will be drawn line by line with open end.
     *
     * @param g
     */
    public void drawPolygon(Graphics g) {
        if (this.npoints <= 1) {
            g.drawPolygon(this);
            return;
        }
        if (onlyPoints) {
            for (int i = 0; i < npoints; i++) {
                g.drawLine(this.xpoints[i], this.ypoints[i], this.xpoints[i], this.ypoints[i]);
            }
            return;
        }
        if (!this.isClosed()) {
            for (int i = 1; i < this.npoints; i++) {
                g.drawLine(this.xpoints[i - 1], this.ypoints[i - 1], this.xpoints[i], this.ypoints[i]);
            }
        } else {
            g.drawPolygon(this);
        }
    }

    /**
     * returns the distance from the first to the last point
     *
     * @return
     */
    public double getDistDirstLast() {
        if (npoints < 2) throw new IllegalStateException("at least two points have to be set");
        Point p1 = new Point(xpoints[0], ypoints[0]);
        Point p2 = new Point(xpoints[npoints - 1], ypoints[npoints - 1]);
        return p1.distance(p2);
    }

    /**
     * returns the full path distance (summed up over all points) of the ploygon
     *
     * @return
     */
    public double getDistPath() {
        if (npoints < 2) throw new IllegalStateException("at least two points have to be set");
        double dist = 0d;
        Point p1;
        Point p2;
        for (int i = 0; i < npoints - 1; i++) {
            p1 = new Point(xpoints[i], ypoints[i]);
            p2 = new Point(xpoints[i + 1], ypoints[i + 1]);
            dist += p1.distance(p2);
        }
        return dist;
    }


    public void addPolygon(PolygonExt poly) {
        for (int i = 0; i < poly.npoints; i++) {
            addPoint(poly.xpoints[i], poly.ypoints[i]);
        }
    }

    public void invertPolygon(final Polygon p) {
        int x, y;
        for (int i = 0; i < p.npoints / 2; i++) {
            x = p.xpoints[i];
            y = p.ypoints[i];
            p.xpoints[i] = p.xpoints[p.npoints - i - 1];
            p.ypoints[i] = p.ypoints[p.npoints - i - 1];
            p.xpoints[p.npoints - i - 1] = x;
            p.ypoints[p.npoints - i - 1] = y;
        }
    }

    public String listPoints() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < npoints; i++) {
            sb.append(xpoints[i] + "," + ypoints[i] + "; ");
        }
        return sb.toString();
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public Point getViewPortOffs() {
        return viewPortOffs;
    }

    public void setViewPortOffs(Point viewPortOffs) {
        this.viewPortOffs = viewPortOffs;
    }


    public boolean isInverse() {
        return inverse;
    }


    public void setInverse(boolean inverse) {
        this.inverse = inverse;
    }

    public void resetScaledInstance() {
        scaledInstance = null;
    }


    public boolean isOnlyPoints() {
        return onlyPoints;
    }


    public void setOnlyPoints(boolean onlyPoints) {
        this.onlyPoints = onlyPoints;
    }


    @Override
    public PolygonExt clone() {
        return SerializationUtils.clone(this);
    }


    /**
     * Uses the xpoints, ypoints and bounds of another polygon.
     * All objects will be cloned.
     *
     * @param p
     */
    public void setPoly(Polygon p) {
        this.xpoints = p.xpoints.clone();
        this.ypoints = p.ypoints.clone();
        this.npoints = p.npoints;
        this.bounds = (Rectangle) p.getBounds().clone();
    }

    /**
     * Checks if the convex(!!!) polygon polygon2 is inside this polygon (just checks all points)
     *
     * @param polygon2
     * @return
     */
    public boolean contains(Polygon polygon2) {
        //all points in inner Polygon should be contained in polygon
        int[] xpoints = polygon2.xpoints;
        int[] ypoints = polygon2.ypoints;
        boolean result = true;
        for (int i = 0, j = 0; i < polygon2.npoints; i++, j++) {
            result = this.contains(xpoints[i], ypoints[j]);
            if (!result) break;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PolygonExt that = (PolygonExt) o;

        if (closed != that.closed) return false;
        if (Double.compare(that.scale, scale) != 0) return false;
        if (viewPortOffs != null ? !viewPortOffs.equals(that.viewPortOffs) : that.viewPortOffs != null) return false;
        return getBounds() != null ? getBounds().equals(that.getBounds()) : that.getBounds() == null;

    }

    /**
     * First checks equals and then in addition checks each point of the polygons (not just bounds as in equals).
     *
     * @param o
     * @return true/false
     */
    public boolean equalsExact(Object o) {
        if (!equals(o)) return false;
        PolygonExt that = (PolygonExt) o;
        if (npoints != that.npoints) return false;
        for (int i = 0; i < npoints; i++) {
            if (xpoints[i] != that.xpoints[i] || ypoints[i] != that.ypoints[i]) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (closed ? 1 : 0);
        temp = Double.doubleToLongBits(scale);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (viewPortOffs != null ? viewPortOffs.hashCode() : 0);
        result = 31 * result + (getBounds() != null ? getBounds().hashCode() : 0);
        return result;
    }

    @Override
    public int getRdfId() {
        return rdfId;
    }

    @Override
    public void setRdfId(int rdfId) {
        this.rdfId = rdfId;
    }

}
