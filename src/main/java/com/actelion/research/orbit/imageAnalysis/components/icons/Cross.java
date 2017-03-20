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

package com.actelion.research.orbit.imageAnalysis.components.icons;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

import static java.awt.Color.*;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class Cross implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

    /**
     * Paints the transcoded SVG image on the specified graphics context. You
     * can install a custom transformation on the graphics context to scale the
     * image.
     *
     * @param g Graphics context.
     */
    public static void paint(Graphics2D g) {
        Shape shape = null;

        float origAlpha = 1.0f;
        Composite origComposite = g.getComposite();
        if (origComposite instanceof AlphaComposite) {
            AlphaComposite origAlphaComposite = (AlphaComposite) origComposite;
            if (origAlphaComposite.getRule() == AlphaComposite.SRC_OVER) {
                origAlpha = origAlphaComposite.getAlpha();
            }
        }

        java.util.LinkedList<AffineTransform> transformations = new java.util.LinkedList<AffineTransform>();


        // 

        // _0

        // _0_0

        // _0_0_0
        shape = new Rectangle2D.Double(0.7645368576049805, 0.41804227232933044, 30.761459350585938, 31.105712890625);
        g.setPaint(new Color(0x333333));
        g.fill(shape);
        g.setPaint(new Color(0x7D7DB5));
        g.setStroke(new BasicStroke(0.40056232f, 1, 1, 4));
        g.draw(shape);

        // _0_0_1
        shape = new Rectangle2D.Double(3.2993574142456055, 2.7678585052490234, 25.69182014465332, 18.40608024597168);
        g.setPaint(BLACK);
        g.fill(shape);
        g.setPaint(WHITE);
        g.setStroke(new BasicStroke(0.86f, 1, 1, 4));
        g.draw(shape);

        // _0_0_2
        shape = new Rectangle2D.Double(3.0958375930786133, 25.342479705810547, 25.099628448486328, 2.293881416320801);
        g.setPaint(BLACK);
        g.fill(shape);
        g.setPaint(WHITE);
        g.setStroke(new BasicStroke(0.4841821f, 1, 1, 4));
        g.draw(shape);

        // _0_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(9.012794, 24.208595);
        ((GeneralPath) shape).lineTo(9.012794, 27.666185);
        ((GeneralPath) shape).lineTo(10.381983, 28.918934);
        ((GeneralPath) shape).lineTo(10.479773, 28.918934);
        ((GeneralPath) shape).lineTo(10.62647, 28.918934);
        ((GeneralPath) shape).lineTo(10.72427, 28.918934);
        ((GeneralPath) shape).lineTo(12.093457, 27.666185);
        ((GeneralPath) shape).lineTo(12.093457, 24.208595);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);
        g.setPaint(WHITE);
        g.setStroke(new BasicStroke(0.30956125f, 0, 0, 4));
        g.draw(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.7488717f, 0, 0, 0.56901026f, -20.194122f, -0.96601516f));

        // _0_0_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xCCCCCC));
        g.fill(shape);
        g.setStroke(new BasicStroke(0.3600241f, 1, 1, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_4
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.6364779f, 0.00573169f, -0.00264288f, 0.48361078f, -11.191279f, 9.295665f));

        // _0_0_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_5
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.5664361f, -0.06124986f, 0.02645129f, 0.45953223f, 3.0251973f, 2.0013587f));

        // _0_0_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_6
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.5168362f, 0.09716507f, -0.04480271f, 0.3927043f, -10.03794f, -2.7372878f));

        // _0_0_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_7
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.6947152f, -0.05742023f, 0.0264764f, 0.5278609f, -16.563744f, 5.3558726f));

        // _0_0_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_8
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0001065f, 0.25909764f, -0.10377855f, 0.8748002f, -14.033634f, -7.0690413f));

        // _0_0_9
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_9
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.8226557f, 0.04947823f, -0.0213676f, 0.66739523f, -8.110949f, -10.220071f));

        // _0_0_10
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_10
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.69919443f, -0.11007502f, 0.04753686f, 0.567235f, -0.63606083f, -1.2641842f));

        // _0_0_11
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_11
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.8257831f, 0.16524203f, -0.07619292f, 0.62744933f, -17.346834f, -8.224159f));

        // _0_0_12
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_12
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.52454764f, -0.09062947f, 0.04178914f, 0.3985636f, -14.764766f, 14.603731f));

        // _0_0_13
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_13
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9588815f, -0.19862008f, 0.09158349f, 0.7285806f, -29.68169f, 6.4955745f));

        // _0_0_14
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_14
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.7538959f, -0.05170371f, 0.02384052f, 0.57282776f, -18.463055f, 8.340845f));

        // _0_0_15
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_15
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.7737888f, -0.10737935f, 0.0495125f, 0.5879429f, -19.92239f, 11.468323f));

        // _0_0_16
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_16
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.7432632f, 0, 0, 0.7734675f, -10.075808f, 44.240105f));

        // _0_0_17

        // _0_0_17_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(35.27832, -47.567947);
        ((GeneralPath) shape).lineTo(35.27832, -35.872417);

        g.setPaint(GREEN);
        g.setStroke(new BasicStroke(2.6377745f, 0, 0, 4));
        g.draw(shape);

        // _0_0_17_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(29.430553, -41.720184);
        ((GeneralPath) shape).lineTo(41.126083, -41.720184);

        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_17

    }

    /**
     * Returns the X of the bounding box of the original SVG image.
     *
     * @return The X of the bounding box of the original SVG image.
     */
    public static int getOrigX() {
        return 1;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     *
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 1;
    }

    /**
     * Returns the width of the bounding box of the original SVG image.
     *
     * @return The width of the bounding box of the original SVG image.
     */
    public static int getOrigWidth() {
        return 32;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     *
     * @return The height of the bounding box of the original SVG image.
     */
    public static int getOrigHeight() {
        return 32;
    }

    /**
     * The current width of this resizable icon.
     */
    int width;

    /**
     * The current height of this resizable icon.
     */
    int height;

    /**
     * Creates a new transcoded SVG image.
     */
    public Cross() {
        this.width = getOrigWidth();
        this.height = getOrigHeight();
    }

    @Override
    public int getIconHeight() {
        return height;
    }

    @Override
    public int getIconWidth() {
        return width;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.pushingpixels.flamingo.api.common.icon.ResizableIcon#setDimension(java.awt.Dimension)
     */
    @Override
    public void setDimension(Dimension dimension) {
        this.width = dimension.width;
        this.height = dimension.height;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.translate(x, y);

        double coef1 = (double) this.width / (double) getOrigWidth();
        double coef2 = (double) this.height / (double) getOrigHeight();
        double coef = Math.min(coef1, coef2);
        g2d.scale(coef, coef);
        paint(g2d);
        g2d.dispose();
    }
}

