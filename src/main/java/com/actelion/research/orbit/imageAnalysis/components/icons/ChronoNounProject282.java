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

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class ChronoNounProject282 implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.01f, 0, 0, 0.01f, 0.062470015f, 0));

        // _0

        // _0_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(43.0, 26.0);
        ((GeneralPath) shape).curveTo(41.344, 26.0, 40.0, 27.343, 40.0, 29.0);
        ((GeneralPath) shape).lineTo(40.0, 57.0);
        ((GeneralPath) shape).curveTo(40.0, 58.657, 41.344, 60.0, 43.0, 60.0);
        ((GeneralPath) shape).curveTo(44.656, 60.0, 46.0, 58.657, 46.0, 57.0);
        ((GeneralPath) shape).lineTo(46.0, 29.0);
        ((GeneralPath) shape).curveTo(46.0, 27.343, 44.656, 26.0, 43.0, 26.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xCCCCCC));
        g.fill(shape);

        // _0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(87.506, 23.807);
        ((GeneralPath) shape).curveTo(87.506, 23.807, 86.091995, 19.564999, 83.263, 16.737);
        ((GeneralPath) shape).curveTo(80.435, 13.907999, 76.193, 12.4939995, 76.193, 12.4939995);
        ((GeneralPath) shape).lineTo(67.205, 21.481998);
        ((GeneralPath) shape).curveTo(62.408, 18.201998, 56.916, 15.8759985, 51.0, 14.757998);
        ((GeneralPath) shape).lineTo(51.0, 1.9999981);
        ((GeneralPath) shape).curveTo(51.0, 1.9999981, 47.0, -1.9073486E-6, 43.0, -1.9073486E-6);
        ((GeneralPath) shape).curveTo(39.0, -1.9073486E-6, 35.0, 1.9999981, 35.0, 1.9999981);
        ((GeneralPath) shape).lineTo(35.0, 14.757998);
        ((GeneralPath) shape).curveTo(15.101999, 18.519999, 0.0, 36.024, 0.0, 57.0);
        ((GeneralPath) shape).curveTo(0.0, 80.71, 19.29, 100.0, 43.0, 100.0);
        ((GeneralPath) shape).curveTo(66.71, 100.0, 86.0, 80.71, 86.0, 57.0);
        ((GeneralPath) shape).curveTo(86.0, 48.029, 83.235, 39.695, 78.518, 32.795);
        ((GeneralPath) shape).lineTo(87.506, 23.807);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(42.999996, 94.0);
        ((GeneralPath) shape).curveTo(22.597996, 94.0, 5.999996, 77.402, 5.999996, 57.0);
        ((GeneralPath) shape).curveTo(5.999996, 36.598, 22.597996, 20.0, 42.999996, 20.0);
        ((GeneralPath) shape).curveTo(63.401997, 20.0, 80.0, 36.598, 80.0, 57.0);
        ((GeneralPath) shape).curveTo(80.0, 77.402, 63.402, 94.0, 43.0, 94.0);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        g.setTransform(transformations.poll()); // _0

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
        return 0;
    }

    /**
     * Returns the width of the bounding box of the original SVG image.
     *
     * @return The width of the bounding box of the original SVG image.
     */
    public static int getOrigWidth() {
        return 1;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     *
     * @return The height of the bounding box of the original SVG image.
     */
    public static int getOrigHeight() {
        return 1;
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
    public ChronoNounProject282() {
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

