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


public class RectangleExt extends Rectangle implements IScaleableShape {

    private static final long serialVersionUID = 2L;
    private double scale = 100.0d;
    private transient RectangleExt scaledInstance = null;
    private int rdfId = 0;


    public RectangleExt() {
        super();
    }

    public RectangleExt(int x, int y, int width, int height) {
        super(x, y, width, height);
    }


    public RectangleExt getScaledInstance(double currentScale, Point currentOffset) {
        if (Math.abs(scale - currentScale) <= OrbitUtils.EPSILON) return this;
        if ((scaledInstance != null) && (Math.abs(scaledInstance.getScale() - currentScale) <= OrbitUtils.EPSILON)) {
            return scaledInstance;
        }
        double scaleFactor = (currentScale / scale);
        // calculate the offset - see RecognitionFrame.paint
            /*
            AffineTransform trTranspInv =AffineTransform.getTranslateInstance(-currentOffset.x, -currentOffset.y);
			AffineTransform  trScale= AffineTransform.getScaleInstance(scaleFactor,scaleFactor);
			trScale.concatenate(trTranspInv);
			AffineTransform trConj =AffineTransform.getTranslateInstance(currentOffset.x, currentOffset.y);
			trConj.concatenate(trScale);
			*/
        RectangleExt re = new RectangleExt((int) (x * scaleFactor), (int) (y * scaleFactor), (int) (width * scaleFactor), (int) (height * scaleFactor));
        //re.translate((int)trConj.getTranslateX(),(int)trConj.getTranslateY());
        re.setScale(currentScale);
        scaledInstance = re;
        return re;
    }


    public void move(double dx, double dy) {
        double scaleFactor = (100d / scale);
        double dxx = dx / scaleFactor;
        double dyy = dy / scaleFactor;
        translate((int) dxx, (int) dyy);
        scaledInstance = null;
    }

    /**
     * only rotates the center, not the oriantation of the rectangle
     *
     * @param angle
     * @param rotCenter
     */
    public void rotate(double angle, Point2D rotCenter) {
        double tx = getCenterX();
        double ty = getCenterY();
        double cx = rotCenter.getX() + (Math.cos(Math.toRadians(angle)) * (tx - rotCenter.getX()) - Math.sin(Math.toRadians(angle)) * (ty - rotCenter.getY()));
        double cy = rotCenter.getY() + (Math.sin(Math.toRadians(angle)) * (tx - rotCenter.getX()) + Math.cos(Math.toRadians(angle)) * (ty - rotCenter.getY()));
        setLocation((int) (cx - (width / 2)), (int) (cy - (height / 2)));
        scaledInstance = null;
    }

    /**
     * 0..100
     */
    public double getScale() {
        return scale;
    }

    /**
     * 0..100
     */
    public void setScale(double scale) {
        this.scale = scale;
    }

    @Override
    public RectangleExt clone() {
        return SerializationUtils.clone(this);
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
