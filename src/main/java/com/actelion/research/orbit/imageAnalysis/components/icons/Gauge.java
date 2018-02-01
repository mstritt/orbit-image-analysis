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

package com.actelion.research.orbit.imageAnalysis.components.icons;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

import static java.awt.Color.GRAY;
import static java.awt.Color.WHITE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class Gauge implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        shape = new Rectangle2D.Double(0.5591395497322083, 0.4912334382534027, 31.50276756286621, 31.570112228393555);
        g.setPaint(GRAY);
        g.fill(shape);
        g.setPaint(new Color(0xCCCCCC));
        g.setStroke(new BasicStroke(0.5242f, 1, 1, 4));
        g.draw(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.8230803f, 0, 0, 1.2387717f, 4.035399f, -3.683446f));

        // _0_0_1

        // _0_0_1_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(2.5004907, 22.62316);
        ((GeneralPath) shape).lineTo(27.326792, 22.62316);

        g.setPaint(WHITE);
        g.setStroke(new BasicStroke(1, 1, 1, 4));
        g.draw(shape);

        // _0_0_1_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(2.232581, 20.033365);
        ((GeneralPath) shape).lineTo(2.232581, 25.212954);

        g.draw(shape);

        // _0_0_1_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(27.594702, 20.033365);
        ((GeneralPath) shape).lineTo(27.594702, 25.212954);

        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_1

        // _0_0_2
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0031275f, 0, 0, 0.9968824f, 0, 0));

        // _0_0_2_0
        //  0.6  
        shape = new GeneralPath();

        g.fill(shape);
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1.7750667, 12.57888);
        ((GeneralPath) shape).quadTo(1.7750667, 11.373026, 2.0224214, 10.638692);
        ((GeneralPath) shape).quadTo(2.269776, 9.904358, 2.7598476, 9.505498);
        ((GeneralPath) shape).quadTo(3.2499194, 9.106639, 3.9919834, 9.106639);
        ((GeneralPath) shape).quadTo(4.5392556, 9.106639, 4.952029, 9.326166);
        ((GeneralPath) shape).quadTo(5.3648024, 9.545693, 5.6338005, 9.961558);
        ((GeneralPath) shape).quadTo(5.9027987, 10.377423, 6.0558496, 10.972621);
        ((GeneralPath) shape).quadTo(6.2089005, 11.567818, 6.2089005, 12.57888);
        ((GeneralPath) shape).quadTo(6.2089005, 13.775459, 5.9630914, 14.511339);
        ((GeneralPath) shape).quadTo(5.717283, 15.24722, 5.227211, 15.649171);
        ((GeneralPath) shape).quadTo(4.7371397, 16.051123, 3.9919834, 16.051123);
        ((GeneralPath) shape).quadTo(3.0087485, 16.051123, 2.4460166, 15.34307);
        ((GeneralPath) shape).quadTo(1.7750667, 14.49588, 1.7750667, 12.57888);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(2.6315324, 12.57888);
        ((GeneralPath) shape).quadTo(2.6315324, 14.254709, 3.024208, 14.808165);
        ((GeneralPath) shape).quadTo(3.4168837, 15.361621, 3.9919834, 15.361621);
        ((GeneralPath) shape).quadTo(4.5670834, 15.361621, 4.958213, 14.805073);
        ((GeneralPath) shape).quadTo(5.349343, 14.248525, 5.349343, 12.57888);
        ((GeneralPath) shape).quadTo(5.349343, 10.8999605, 4.958213, 10.34805);
        ((GeneralPath) shape).quadTo(4.5670834, 9.79614, 3.9827077, 9.79614);
        ((GeneralPath) shape).quadTo(3.407608, 9.79614, 3.0644033, 10.284665);
        ((GeneralPath) shape).quadTo(2.6315324, 10.906144, 2.6315324, 12.57888);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(7.524518, 15.933629);
        ((GeneralPath) shape).lineTo(7.524518, 14.981314);
        ((GeneralPath) shape).lineTo(8.476834, 14.981314);
        ((GeneralPath) shape).lineTo(8.476834, 15.933629);
        ((GeneralPath) shape).lineTo(7.524518, 15.933629);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(14.028402, 10.797927);
        ((GeneralPath) shape).lineTo(13.1966715, 10.862857);
        ((GeneralPath) shape).quadTo(13.085362, 10.37124, 12.881294, 10.148621);
        ((GeneralPath) shape).quadTo(12.544273, 9.793048, 12.046473, 9.793048);
        ((GeneralPath) shape).quadTo(11.647613, 9.793048, 11.347695, 10.015667);
        ((GeneralPath) shape).quadTo(10.951927, 10.303217, 10.72467, 10.855127);
        ((GeneralPath) shape).quadTo(10.497414, 11.407038, 10.488137, 12.427376);
        ((GeneralPath) shape).quadTo(10.791147, 11.966678, 11.22711, 11.744059);
        ((GeneralPath) shape).quadTo(11.663073, 11.521439, 12.13923, 11.521439);
        ((GeneralPath) shape).quadTo(12.974052, 11.521439, 13.56152, 12.136734);
        ((GeneralPath) shape).quadTo(14.148988, 12.752028, 14.148988, 13.725988);
        ((GeneralPath) shape).quadTo(14.148988, 14.366018, 13.872259, 14.914837);
        ((GeneralPath) shape).quadTo(13.595531, 15.463655, 13.11319, 15.757389);
        ((GeneralPath) shape).quadTo(12.630848, 16.051123, 12.018644, 16.051123);
        ((GeneralPath) shape).quadTo(10.976663, 16.051123, 10.318081, 15.282777);
        ((GeneralPath) shape).quadTo(9.659499, 14.514431, 9.659499, 12.752028);
        ((GeneralPath) shape).quadTo(9.659499, 10.779375, 10.386104, 9.885806);
        ((GeneralPath) shape).quadTo(11.023042, 9.106639, 12.099035, 9.106639);
        ((GeneralPath) shape).quadTo(12.899846, 9.106639, 13.413107, 9.556515);
        ((GeneralPath) shape).quadTo(13.926368, 10.006392, 14.028402, 10.797927);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(10.617998, 13.72908);
        ((GeneralPath) shape).quadTo(10.617998, 14.161951, 10.801969, 14.556172);
        ((GeneralPath) shape).quadTo(10.985939, 14.950394, 11.315229, 15.156008);
        ((GeneralPath) shape).quadTo(11.644521, 15.361621, 12.006277, 15.361621);
        ((GeneralPath) shape).quadTo(12.534998, 15.361621, 12.915306, 14.934935);
        ((GeneralPath) shape).quadTo(13.295613, 14.508247, 13.295613, 13.775459);
        ((GeneralPath) shape).quadTo(13.295613, 13.070498, 12.919944, 12.665455);
        ((GeneralPath) shape).quadTo(12.544273, 12.260411, 11.972266, 12.260411);
        ((GeneralPath) shape).quadTo(11.406442, 12.260411, 11.01222, 12.665455);
        ((GeneralPath) shape).quadTo(10.617998, 13.070498, 10.617998, 13.72908);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        shape = new GeneralPath();

        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_2_0
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.03692402f, 0, 0, 0.03616073f, 15.869679f, 1.5473711f));

        // _0_0_2_1

        // _0_0_2_1_0

        // _0_0_2_1_0_0

        // _0_0_2_1_0_0_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(140.4844, 385.875);
        ((GeneralPath) shape).lineTo(118.12501, 385.875);
        ((GeneralPath) shape).lineTo(118.12501, 368.2969);
        ((GeneralPath) shape).lineTo(117.56251, 368.2969);
        ((GeneralPath) shape).quadTo(105.75001, 389.3906, 80.57811, 389.3906);
        ((GeneralPath) shape).quadTo(57.79691, 389.3906, 45.56251, 370.96878);
        ((GeneralPath) shape).lineTo(44.859413, 370.96878);
        ((GeneralPath) shape).lineTo(44.859413, 443.24997);
        ((GeneralPath) shape).lineTo(19.265614, 443.24997);
        ((GeneralPath) shape).lineTo(19.265614, 236.67188);
        ((GeneralPath) shape).lineTo(44.578114, 236.67188);
        ((GeneralPath) shape).lineTo(44.578114, 299.81247);
        ((GeneralPath) shape).quadTo(44.578114, 326.39056, 46.757812, 338.13278);
        ((GeneralPath) shape).quadTo(48.93751, 349.87497, 57.726612, 358.2422);
        ((GeneralPath) shape).quadTo(66.51561, 366.60938, 79.45311, 366.60938);
        ((GeneralPath) shape).quadTo(85.21881, 366.60938, 91.61721, 364.4297);
        ((GeneralPath) shape).quadTo(98.01561, 362.25, 103.85161, 356.69528);
        ((GeneralPath) shape).quadTo(109.68751, 351.1406, 111.93751, 344.1797);
        ((GeneralPath) shape).quadTo(114.18751, 337.21878, 114.67971, 328.0781);
        ((GeneralPath) shape).quadTo(115.17191, 318.9375, 115.17191, 300.09378);
        ((GeneralPath) shape).lineTo(115.17191, 236.67188);
        ((GeneralPath) shape).lineTo(140.4844, 236.67188);
        ((GeneralPath) shape).lineTo(140.4844, 385.87497);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_2_1
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0034403f, 0, 0, 0.9965715f, 0, 0));

        // _0_0_2_2
        //  m 
        shape = new GeneralPath();

        g.fill(shape);
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(23.133873, 15.719844);
        ((GeneralPath) shape).lineTo(23.133873, 10.2468195);
        ((GeneralPath) shape).lineTo(23.96187, 10.2468195);
        ((GeneralPath) shape).lineTo(23.96187, 11.012974);
        ((GeneralPath) shape).quadTo(24.219545, 10.611, 24.647287, 10.367067);
        ((GeneralPath) shape).quadTo(25.075027, 10.123135, 25.6213, 10.123135);
        ((GeneralPath) shape).quadTo(26.229414, 10.123135, 26.619362, 10.375657);
        ((GeneralPath) shape).quadTo(27.009312, 10.628179, 27.16735, 11.081687);
        ((GeneralPath) shape).quadTo(27.816694, 10.123135, 28.857702, 10.123135);
        ((GeneralPath) shape).quadTo(29.671957, 10.123135, 30.110004, 10.573208);
        ((GeneralPath) shape).quadTo(30.548052, 11.023281, 30.548052, 11.961219);
        ((GeneralPath) shape).lineTo(30.548052, 15.719844);
        ((GeneralPath) shape).lineTo(29.627293, 15.719844);
        ((GeneralPath) shape).lineTo(29.627293, 12.27043);
        ((GeneralPath) shape).quadTo(29.627293, 11.713851, 29.536247, 11.469918);
        ((GeneralPath) shape).quadTo(29.445202, 11.225986, 29.208141, 11.076533);
        ((GeneralPath) shape).quadTo(28.971079, 10.927082, 28.651562, 10.927082);
        ((GeneralPath) shape).quadTo(28.07437, 10.927082, 27.693008, 11.31016);
        ((GeneralPath) shape).quadTo(27.31165, 11.693236, 27.31165, 12.538412);
        ((GeneralPath) shape).lineTo(27.31165, 15.719844);
        ((GeneralPath) shape).lineTo(26.384018, 15.719844);
        ((GeneralPath) shape).lineTo(26.384018, 12.163924);
        ((GeneralPath) shape).quadTo(26.384018, 11.545503, 26.157265, 11.236293);
        ((GeneralPath) shape).quadTo(25.93051, 10.927082, 25.41516, 10.927082);
        ((GeneralPath) shape).quadTo(25.023493, 10.927082, 24.69195, 11.133223);
        ((GeneralPath) shape).quadTo(24.360409, 11.339363, 24.210957, 11.736182);
        ((GeneralPath) shape).quadTo(24.061504, 12.133002, 24.061504, 12.878544);
        ((GeneralPath) shape).lineTo(24.061504, 15.719844);
        ((GeneralPath) shape).lineTo(23.133873, 15.719844);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        shape = new GeneralPath();

        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_2_2

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
    public Gauge() {
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

