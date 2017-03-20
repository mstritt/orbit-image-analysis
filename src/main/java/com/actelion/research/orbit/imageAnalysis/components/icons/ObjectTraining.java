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
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

import static java.awt.Color.*;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class ObjectTraining implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, -87.73739f, 169.7818f));

        // _0_0

        // _0_0_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(119.05743, -145.78683);
        ((GeneralPath) shape).curveTo(115.51431, -145.78683, 114.64295, -143.86617, 114.64295, -141.49615);
        ((GeneralPath) shape).curveTo(114.64295, -139.91615, 113.92347, -138.53854, 115.82432, -137.79372);
        ((GeneralPath) shape).lineTo(115.82432, -135.71758);
        ((GeneralPath) shape).curveTo(115.82432, -135.18779, 116.45486, -134.76604, 117.24689, -134.76604);
        ((GeneralPath) shape).lineTo(121.64391, -134.76604);
        ((GeneralPath) shape).curveTo(122.43594, -134.76604, 123.09234, -135.18779, 123.09234, -135.71758);
        ((GeneralPath) shape).lineTo(123.09234, -138.15704);
        ((GeneralPath) shape).curveTo(124.54372, -138.94379, 123.4719, -140.14922, 123.4719, -141.49615);
        ((GeneralPath) shape).curveTo(123.4719, -143.86617, 122.60054, -145.78683, 119.05743, -145.78683);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xFFAAAA));
        g.fill(shape);

        // _0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(93.84375, -151.53125);
        ((GeneralPath) shape).curveTo(93.84375, -151.53125, 94.03707, -149.4167, 95.90625, -147.49544);
        ((GeneralPath) shape).curveTo(95.13952, -143.1072, 95.45999, -140.64339, 97.0, -137.66814);
        ((GeneralPath) shape).curveTo(100.74802, -133.68304, 104.02066, -128.17136, 109.65625, -131.87663);
        ((GeneralPath) shape).curveTo(113.43222, -138.30524, 105.92692, -139.88535, 101.53125, -140.63228);
        ((GeneralPath) shape).curveTo(100.46818, -142.95331, 98.47306, -144.69778, 97.5625, -147.10782);
        ((GeneralPath) shape).curveTo(97.35132, -147.29715, 97.21199, -147.43573, 97.09375, -147.56384);
        ((GeneralPath) shape).lineTo(99.6875, -148.33908);
        ((GeneralPath) shape).lineTo(99.875, -151.23483);
        ((GeneralPath) shape).lineTo(93.84375, -151.53125);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);

        // _0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(108.12854, -128.59427);
        ((GeneralPath) shape).curveTo(108.12854, -128.59427, 113.16616, -122.20186, 113.16616, -120.44394);
        ((GeneralPath) shape).curveTo(113.16616, -118.68603, 113.82324, -112.93286, 113.82324, -112.93286);
        ((GeneralPath) shape).curveTo(116.63199, -112.68533, 122.4706, -112.62183, 125.887, -112.93286);
        ((GeneralPath) shape).curveTo(125.887, -112.93286, 126.54408, -118.68603, 126.54408, -120.44394);
        ((GeneralPath) shape).curveTo(126.54408, -122.20186, 131.5817, -128.59427, 131.5817, -128.59427);

        g.setPaint(CYAN);
        g.setStroke(new BasicStroke(0.85418844f, 0, 0, 4));
        g.draw(shape);

        // _0_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(143.79387, -150.92247);
        ((GeneralPath) shape).curveTo(143.79387, -150.92247, 143.60056, -148.80792, 141.73137, -146.88666);
        ((GeneralPath) shape).curveTo(142.4981, -142.49841, 142.17763, -140.0346, 140.63762, -137.05936);
        ((GeneralPath) shape).curveTo(136.8896, -133.07426, 133.61696, -127.56257, 127.98137, -131.26785);
        ((GeneralPath) shape).curveTo(124.2054, -137.69646, 131.7107, -139.27657, 136.10637, -140.0235);
        ((GeneralPath) shape).curveTo(137.16943, -142.34453, 139.16457, -144.089, 140.07512, -146.49904);
        ((GeneralPath) shape).curveTo(140.2863, -146.68837, 140.42563, -146.82695, 140.54387, -146.95506);
        ((GeneralPath) shape).lineTo(137.95012, -147.7303);
        ((GeneralPath) shape).lineTo(137.76262, -150.62605);
        ((GeneralPath) shape).lineTo(143.79387, -150.92247);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);

        // _0_0_4
        shape = new Ellipse2D.Double(91.95555114746094, -168.1304473876953, 9.05810546875, 15.859801292419434);
        g.setPaint(GREEN);
        g.fill(shape);
        g.setStroke(new BasicStroke(2.1513991f, 0, 0, 4));
        g.draw(shape);

        // _0_0_5
        shape = new Ellipse2D.Double(127.53123474121094, -163.34356689453125, 20.738136291503906, 11.461929321289062);
        g.setPaint(MAGENTA);
        g.fill(shape);
        g.setStroke(new BasicStroke(2.7673693f, 0, 0, 4));
        g.draw(shape);

        // _0_0_6
        shape = new Ellipse2D.Double(108.05567169189453, -167.2455291748047, 13.585773468017578, 16.714242935180664);
        g.setPaint(CYAN);
        g.fill(shape);
        g.setStroke(new BasicStroke(2.7048235f, 0, 0, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0

    }

    /**
     * Returns the X of the bounding box of the original SVG image.
     *
     * @return The X of the bounding box of the original SVG image.
     */
    public static int getOrigX() {
        return 4;
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
        return 59;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     *
     * @return The height of the bounding box of the original SVG image.
     */
    public static int getOrigHeight() {
        return 58;
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
    public ObjectTraining() {
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

