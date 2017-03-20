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
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static java.awt.MultipleGradientPaint.ColorSpaceType.SRGB;
import static java.awt.MultipleGradientPaint.CycleMethod.NO_CYCLE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class GoUpSearch implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.setComposite(AlphaComposite.getInstance(3, 0.38139534f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.001374f, 0, 0, 0.410379f, -2.393169E-5f, 75.32738f));

        // _0_0_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(127.82442, 115.70919);
        ((GeneralPath) shape).curveTo(127.82442, 122.69116, 99.209946, 128.35117, 63.91221, 128.35117);
        ((GeneralPath) shape).curveTo(28.61447, 128.35117, 7.1054274E-15, 122.69116, 0.0, 115.70919);
        ((GeneralPath) shape).curveTo(0.0, 108.72722, 28.61447, 103.067215, 63.91221, 103.067215);
        ((GeneralPath) shape).curveTo(99.209946, 103.067215, 127.82442, 108.72722, 127.82442, 115.70919);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(63.912208557128906, 115.70919036865234), 63.91221f, new Point2D.Double(63.912208557128906, 115.70929718017578), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 0.197802f, 0, 92.82166f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 0, -4));

        // _0_0_1
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 0, 4));

        // _0_0_1_0
        g.setComposite(AlphaComposite.getInstance(3, 0.1f * origAlpha));

        // _0_0_1_0_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(16.0, 4.0);
        ((GeneralPath) shape).curveTo(13.794, 4.0, 12.0, 5.794, 12.0, 8.0);
        ((GeneralPath) shape).lineTo(12.0, 118.0);
        ((GeneralPath) shape).curveTo(12.0, 121.309, 14.691, 124.0, 18.0, 124.0);
        ((GeneralPath) shape).lineTo(77.172, 124.0);
        ((GeneralPath) shape).curveTo(78.471, 124.0, 79.717, 123.513, 80.813, 122.646);
        ((GeneralPath) shape).curveTo(80.941, 122.593, 81.07, 122.539, 81.07, 122.539);
        ((GeneralPath) shape).curveTo(81.168, 122.466, 93.204, 112.453, 98.829, 106.828);
        ((GeneralPath) shape).curveTo(104.203, 101.457, 113.439, 90.403, 114.475, 89.161);
        ((GeneralPath) shape).curveTo(115.388, 88.279, 116.0, 86.722, 116.0, 85.172);
        ((GeneralPath) shape).lineTo(116.0, 8.0);
        ((GeneralPath) shape).curveTo(116.0, 5.794, 114.206, 4.0, 112.0, 4.0);
        ((GeneralPath) shape).lineTo(16.0, 4.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.15f * origAlpha));

        // _0_0_1_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(16.0, 5.0);
        ((GeneralPath) shape).curveTo(14.346, 5.0, 13.0, 6.346, 13.0, 8.0);
        ((GeneralPath) shape).lineTo(13.0, 118.0);
        ((GeneralPath) shape).curveTo(13.0, 120.757, 15.243, 123.0, 18.0, 123.0);
        ((GeneralPath) shape).lineTo(77.172, 123.0);
        ((GeneralPath) shape).curveTo(78.361, 123.0, 79.454, 122.53, 80.354, 121.771);
        ((GeneralPath) shape).curveTo(80.396, 121.75, 80.444, 121.757, 80.483, 121.729);
        ((GeneralPath) shape).curveTo(80.562, 121.669, 92.5, 111.743, 98.122, 106.121);
        ((GeneralPath) shape).curveTo(103.434, 100.811, 112.672, 89.763, 113.707, 88.52);
        ((GeneralPath) shape).curveTo(114.492, 87.756, 115.001, 86.477, 115.001, 85.171);
        ((GeneralPath) shape).lineTo(115.001, 8.0);
        ((GeneralPath) shape).curveTo(115.001, 6.346, 113.655, 5.0, 112.001, 5.0);
        ((GeneralPath) shape).lineTo(16.0, 5.0);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.2f * origAlpha));

        // _0_0_1_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(16.0, 6.0);
        ((GeneralPath) shape).curveTo(14.897, 6.0, 14.0, 6.897, 14.0, 8.0);
        ((GeneralPath) shape).lineTo(14.0, 118.0);
        ((GeneralPath) shape).curveTo(14.0, 120.206, 15.794, 122.0, 18.0, 122.0);
        ((GeneralPath) shape).lineTo(77.172, 122.0);
        ((GeneralPath) shape).curveTo(78.24, 122.0, 79.244, 121.584, 80.0, 120.828);
        ((GeneralPath) shape).curveTo(79.965, 120.864, 79.926, 120.896, 79.886, 120.927);
        ((GeneralPath) shape).curveTo(79.962, 120.87, 91.846, 110.983, 97.414, 105.414);
        ((GeneralPath) shape).curveTo(102.679, 100.15, 111.904, 89.12, 112.938, 87.88);
        ((GeneralPath) shape).curveTo(113.593, 87.236, 114.0, 86.23, 114.0, 85.172);
        ((GeneralPath) shape).lineTo(114.0, 8.0);
        ((GeneralPath) shape).curveTo(114.0, 6.897, 113.103, 6.0, 112.0, 6.0);
        ((GeneralPath) shape).lineTo(16.0, 6.0);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.25f * origAlpha));

        // _0_0_1_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(16.0, 7.0);
        ((GeneralPath) shape).curveTo(15.448, 7.0, 15.0, 7.448, 15.0, 8.0);
        ((GeneralPath) shape).lineTo(15.0, 118.0);
        ((GeneralPath) shape).curveTo(15.0, 119.654, 16.346, 121.0, 18.0, 121.0);
        ((GeneralPath) shape).lineTo(77.172, 121.0);
        ((GeneralPath) shape).curveTo(77.973, 121.0, 78.727, 120.688, 79.293, 120.121);
        ((GeneralPath) shape).curveTo(79.345, 120.083, 91.238, 110.176, 96.707, 104.707);
        ((GeneralPath) shape).curveTo(102.176, 99.238, 112.083, 87.345, 112.183, 87.226);
        ((GeneralPath) shape).curveTo(112.688, 86.727, 113.0, 85.973, 113.0, 85.172);
        ((GeneralPath) shape).lineTo(113.0, 8.0);
        ((GeneralPath) shape).curveTo(113.0, 7.448, 112.553, 7.0, 112.0, 7.0);
        ((GeneralPath) shape).lineTo(16.0, 7.0);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_1_0
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_1_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(16.0, 12.0);
        ((GeneralPath) shape).lineTo(16.0, 122.0);
        ((GeneralPath) shape).curveTo(16.0, 123.104, 16.896, 124.0, 18.0, 124.0);
        ((GeneralPath) shape).lineTo(77.172, 124.0);
        ((GeneralPath) shape).curveTo(77.702, 124.0, 78.211, 123.789, 78.586, 123.414);
        ((GeneralPath) shape).lineTo(111.414, 90.586);
        ((GeneralPath) shape).curveTo(111.789, 90.211, 112.0, 89.702, 112.0, 89.172);
        ((GeneralPath) shape).lineTo(112.0, 12.0);
        ((GeneralPath) shape).lineTo(16.0, 12.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(102, 112.30470275878906), 139.5585f, new Point2D.Double(102, 112.30470275878906), new float[]{0, 0.0151f, 0.0558f, 0.0964f, 0.1357f, 0.1737f, 0.2099f, 0.2435f, 0.2722f}, new Color[]{new Color(0x00537D), new Color(0x186389), new Color(0x558CA8), new Color(0x89AFC3), new Color(0xB3CCD8), new Color(0xD4E2E9), new Color(0xECF2F5), new Color(0xFAFCFD), WHITE}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 0, 4)));
        g.fill(shape);

        // _0_0_1_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(18.0, 13.0);
        ((GeneralPath) shape).curveTo(17.449, 13.0, 17.0, 13.449, 17.0, 14.0);
        ((GeneralPath) shape).lineTo(17.0, 122.0);
        ((GeneralPath) shape).curveTo(17.0, 122.552, 17.449, 123.0, 18.0, 123.0);
        ((GeneralPath) shape).lineTo(77.172, 123.0);
        ((GeneralPath) shape).curveTo(77.435, 123.0, 77.693, 122.894, 77.879, 122.707);
        ((GeneralPath) shape).lineTo(110.707, 89.879);
        ((GeneralPath) shape).curveTo(110.894, 89.692, 111.0, 89.435, 111.0, 89.172);
        ((GeneralPath) shape).lineTo(111.0, 14.0);
        ((GeneralPath) shape).curveTo(111.0, 13.449, 110.552, 13.0, 110.0, 13.0);
        ((GeneralPath) shape).lineTo(18.0, 13.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(102, 112.30470275878906), 139.5586f, new Point2D.Double(102, 112.30470275878906), new float[]{0, 0.11366145f, 0.20296688f, 0.2363f, 0.2722f, 0.5313f, 0.8449f, 1}, new Color[]{new Color(0x535557), new Color(0x898A8C), new Color(0xECECEC), new Color(0xFAFAFA), WHITE, new Color(0xFAFAFA), new Color(0xEBECEC), new Color(0xE1E2E3)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 0, 4)));
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 0, 4));

        // _0_0_1_3
        g.setComposite(AlphaComposite.getInstance(3, 0.1f * origAlpha));

        // _0_0_1_3_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(111.414, 86.586);
        ((GeneralPath) shape).curveTo(111.664, 86.336, 93.035, 93.0, 88.0, 93.0);
        ((GeneralPath) shape).curveTo(86.346, 93.0, 85.0, 94.346, 85.0, 96.0);
        ((GeneralPath) shape).curveTo(85.0, 101.035, 78.336, 119.664, 78.586, 119.414);
        ((GeneralPath) shape).lineTo(111.414, 86.586);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(94.34380340576172, 102.3447036743164), new Point2D.Double(86.53559875488281, 94.5365982055664), new float[]{0, 1}, new Color[]{WHITE, new Color(0x555753)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        // _0_0_1_3_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(111.414, 86.586);
        ((GeneralPath) shape).curveTo(111.789, 86.211, 97.444, 94.0, 88.0, 94.0);
        ((GeneralPath) shape).curveTo(86.897, 94.0, 86.0, 94.897, 86.0, 96.0);
        ((GeneralPath) shape).curveTo(86.0, 105.444, 78.211, 119.789, 78.586, 119.414);
        ((GeneralPath) shape).lineTo(111.414, 86.586);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(95, 103), new Point2D.Double(86.58650207519531, 94.58650207519531), new float[]{0, 1}, new Color[]{WHITE, new Color(0x555753)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        // _0_0_1_3_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(111.414, 86.586);
        ((GeneralPath) shape).curveTo(111.653, 86.347, 97.807, 95.0, 88.0, 95.0);
        ((GeneralPath) shape).curveTo(87.447, 95.0, 87.0, 95.447, 87.0, 96.0);
        ((GeneralPath) shape).curveTo(87.0, 105.807, 78.347, 119.653, 78.586, 119.414);
        ((GeneralPath) shape).lineTo(111.414, 86.586);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(95, 103), new Point2D.Double(87.29299926757812, 95.29299926757812), new float[]{0, 1}, new Color[]{WHITE, new Color(0x393B38)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_1_3_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(78.586, 119.414);
        ((GeneralPath) shape).curveTo(78.586, 119.414, 90.5, 109.5, 96.0, 104.0);
        ((GeneralPath) shape).curveTo(101.5, 98.5, 111.414, 86.586, 111.414, 86.586);
        ((GeneralPath) shape).curveTo(111.414, 86.586, 98.25, 96.0, 88.0, 96.0);
        ((GeneralPath) shape).curveTo(88.0, 106.25, 78.586, 119.414, 78.586, 119.414);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(96, 104), new Point2D.Double(88.00019836425781, 96.00019836425781), new float[]{0, 0.0072f, 0.0673f, 0.1347f, 0.2115f, 0.3012f, 0.4122f, 0.5679f, 1}, new Color[]{new Color(0x888A85), new Color(0x8C8E89), new Color(0xABACA9), new Color(0xC5C6C4), new Color(0xDBDBDA), new Color(0xEBEBEB), new Color(0xF7F7F6), new Color(0xFDFDFD), WHITE}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_1_3

        g.setTransform(transformations.poll()); // _0_0_1
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_2
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-42.93742, 3.783933);
        ((GeneralPath) shape).lineTo(-42.93742, 0.9892245);
        ((GeneralPath) shape).lineTo(-42.93742, 3.783933);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xC1FFFFFF, true));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.782995f, 0, 0, 0.650879f, -2365.796f, 690.3016f));

        // _0_0_4

        g.setTransform(transformations.poll()); // _0_0_4
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.782995f, 0, 0, 0.650879f, -2365.796f, 690.3016f));

        // _0_0_5

        g.setTransform(transformations.poll()); // _0_0_5
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 0.650879f, 835.167f, 697.6294f));

        // _0_0_6

        g.setTransform(transformations.poll()); // _0_0_6
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 0.650879f, 835.167f, 697.6294f));

        // _0_0_7

        g.setTransform(transformations.poll()); // _0_0_7
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(61.23105, 2.6244366);
        ((GeneralPath) shape).lineTo(61.23105, 0.41896716);
        ((GeneralPath) shape).lineTo(61.23105, 2.6244366);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, -1, 0, 120));

        // _0_0_9
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, -1, 0, 0));

        // _0_0_9_0
        shape = new RoundRectangle2D.Double(56, -88, 16, 72, 8.618450164794922, 7.2496867179870605);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(56.21098327636719, 7.236054420471191), new Point2D.Double(56.21098327636719, 108.9878921508789), new float[]{0, 0.35f, 0.5961165f, 1}, new Color[]{new Color(0x2C72C7), new Color(0x568CD0), new Color(0x80A7DA), new Color(0x39BDD2EC, true)}, NO_CYCLE, SRGB, new AffineTransform(1.0722454f, 0, 0, 0.9019537f, 3.7280383f, -107.61749f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_9_0

        // _0_0_9_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(61.96995, 103.13666);
        ((GeneralPath) shape).lineTo(24.708143, 63.712708);
        ((GeneralPath) shape).curveTo(23.710278, 62.656525, 23.774563, 61.03073, 24.853146, 60.050037);
        ((GeneralPath) shape).lineTo(27.048166, 58.05434);
        ((GeneralPath) shape).curveTo(28.04175, 57.1512, 29.579622, 57.088745, 30.64892, 57.910908);
        ((GeneralPath) shape).curveTo(30.64892, 57.910908, 60.898514, 81.16477, 63.999973, 83.54959);
        ((GeneralPath) shape).curveTo(67.10215, 81.16477, 97.35103, 57.910908, 97.35103, 57.910908);
        ((GeneralPath) shape).curveTo(98.41961, 57.088745, 99.95748, 57.1512, 100.95107, 58.05434);
        ((GeneralPath) shape).lineTo(103.1468, 60.050037);
        ((GeneralPath) shape).curveTo(104.2261, 61.03073, 104.28968, 62.656525, 103.29038, 63.71202);
        ((GeneralPath) shape).lineTo(66.031425, 103.13735);
        ((GeneralPath) shape).curveTo(65.51213, 103.68637, 64.77355, 104.0, 64.00069, 104.0);
        ((GeneralPath) shape).curveTo(63.227108, 104.0, 62.489243, 103.68637, 61.96995, 103.13666);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(55.99903106689453, 0), new Point2D.Double(55.99903106689453, 136.20562744140625), new float[]{0, 1}, new Color[]{new Color(0x2C72C7), new Color(0xA4C0E4)}, NO_CYCLE, SRGB, new AffineTransform(0.7142931f, 0, 0, -0.6862784f, 24.00028f, 104)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_9

    }

    /**
     * Returns the X of the bounding box of the original SVG image.
     *
     * @return The X of the bounding box of the original SVG image.
     */
    public static int getOrigX() {
        return 0;
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
        return 128;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     *
     * @return The height of the bounding box of the original SVG image.
     */
    public static int getOrigHeight() {
        return 128;
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
    public GoUpSearch() {
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

