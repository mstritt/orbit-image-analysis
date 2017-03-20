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

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static java.awt.MultipleGradientPaint.ColorSpaceType.SRGB;
import static java.awt.MultipleGradientPaint.CycleMethod.NO_CYCLE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class DocumentOpen7 implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(118.983, 31.0);
        ((GeneralPath) shape).curveTo(118.992, 29.35, 117.64999, 28.0, 115.99999, 28.0);
        ((GeneralPath) shape).lineTo(40.961006, 28.0);
        ((GeneralPath) shape).curveTo(40.961006, 28.0, 32.061005, 20.0, 30.961, 20.0);
        ((GeneralPath) shape).lineTo(14.999998, 20.0);
        ((GeneralPath) shape).curveTo(12.799996, 20.0, 10.999999, 21.8, 10.999999, 24.0);
        ((GeneralPath) shape).lineTo(10.999999, 31.0);
        ((GeneralPath) shape).curveTo(10.999999, 31.0, 11.999999, 116.0, 8.0, 116.0);
        ((GeneralPath) shape).lineTo(122.0, 116.0);
        ((GeneralPath) shape).curveTo(117.99999, 116.0, 118.983, 31.0, 118.983, 31.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(72.00050354003906, 96), new Point2D.Double(72.00050354003906, 4.882811917923391E-4), new float[]{0, 0.0769f, 0.5858f, 0.9645f}, new Color[]{new Color(0x00479E), new Color(0x2C72C7), new Color(0x6EA1DF), new Color(0xADCBEE)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, -6.999995f, 20)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.6f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0033404f, 0, 0, 1, -8.237469f, 20));

        // _0_1
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_1_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(132.0, 96.0);
        ((GeneralPath) shape).curveTo(132.0, 98.2, 128.4, 100.0, 124.0, 100.0);
        ((GeneralPath) shape).lineTo(20.0, 100.0);
        ((GeneralPath) shape).curveTo(15.6, 100.0, 12.0, 98.2, 12.0, 96.0);
        ((GeneralPath) shape).curveTo(12.0, 93.8, 15.6, 92.0, 20.0, 92.0);
        ((GeneralPath) shape).lineTo(124.0, 92.0);
        ((GeneralPath) shape).curveTo(128.4, 92.0, 132.0, 93.8, 132.0, 96.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_1
        g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));

        // _0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(10.884862, 54.0);
        ((GeneralPath) shape).curveTo(10.893892, 55.75, 10.902922, 57.755, 10.910952, 60.0);
        ((GeneralPath) shape).lineTo(119.09511, 60.0);
        ((GeneralPath) shape).curveTo(119.10414, 57.755, 119.11317, 55.75, 119.1212, 54.0);
        ((GeneralPath) shape).lineTo(10.884862, 54.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(71.99949645996094, 14.257800102233887), new Point2D.Double(71.99949645996094, 19.95829963684082), new float[]{0.25f, 1}, new Color[]{new Color(0x71A8F5, true), new Color(0x0057AE)}, NO_CYCLE, SRGB, new AffineTransform(1.0033404f, 0, 0, 1, -7.2374682f, 40)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(119.99722, 31.0);
        ((GeneralPath) shape).curveTo(120.00622, 29.35, 118.66422, 28.0, 117.01422, 28.0);
        ((GeneralPath) shape).lineTo(42.975224, 28.0);
        ((GeneralPath) shape).lineTo(36.38922, 21.414);
        ((GeneralPath) shape).curveTo(35.61122, 20.636, 34.075222, 20.0, 32.975224, 20.0);
        ((GeneralPath) shape).lineTo(12.014222, 20.0);
        ((GeneralPath) shape).curveTo(9.814222, 20.0, 8.014222, 21.8, 8.014222, 24.0);
        ((GeneralPath) shape).curveTo(8.014222, 24.0, 7.982222, 54.4993, 8.014222, 60.0313);
        ((GeneralPath) shape).lineTo(12.014222, 60.0313);
        ((GeneralPath) shape).curveTo(12.014222, 53.222298, 12.014222, 24.0, 12.014222, 24.0);
        ((GeneralPath) shape).lineTo(32.901222, 23.997);
        ((GeneralPath) shape).curveTo(33.08322, 24.019, 33.470222, 24.179, 33.560223, 24.243);
        ((GeneralPath) shape).lineTo(41.318222, 32.0);
        ((GeneralPath) shape).curveTo(41.318222, 32.0, 114.02722, 32.0, 115.99922, 32.0);
        ((GeneralPath) shape).curveTo(115.99922, 32.435, 116.00022, 56.4003, 116.00222, 60.0313);
        ((GeneralPath) shape).lineTo(120.01422, 60.0313);
        ((GeneralPath) shape).curveTo(120.04522, 54.4993, 119.99722, 31.0, 119.99722, 31.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x5E95E3));
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.8308491f, 0, 0, 0.824851f, 10.82565f, 1.1777911f));

        // _0_4
        g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0575713f, 0, 0, 1.0540507f, -3.6845596f, -1.7469078f));

        // _0_4_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(16.0, 8.0);
        ((GeneralPath) shape).lineTo(16.0, 120.0);
        ((GeneralPath) shape).curveTo(16.0, 120.0, 79.15625, 120.0, 79.15625, 120.0);
        ((GeneralPath) shape).lineTo(79.1875, 120.0);
        ((GeneralPath) shape).curveTo(79.18751, 120.0, 91.09375, 110.09375, 96.59375, 104.59375);
        ((GeneralPath) shape).curveTo(102.09375, 99.09375, 112.0, 87.1875, 112.0, 87.1875);
        ((GeneralPath) shape).lineTo(112.0, 87.15625);
        ((GeneralPath) shape).lineTo(112.0, 8.0);
        ((GeneralPath) shape).lineTo(16.0, 8.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_4_0
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_4_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(16.000002, 8.0);
        ((GeneralPath) shape).lineTo(16.0, 120.0);
        ((GeneralPath) shape).curveTo(16.0, 120.0, 79.146416, 120.0, 79.146416, 120.0);
        ((GeneralPath) shape).lineTo(112.0, 87.14642);
        ((GeneralPath) shape).lineTo(112.0, 8.0);
        ((GeneralPath) shape).lineTo(16.000002, 8.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);

        // _0_4_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(18.000002, 9.000004);
        ((GeneralPath) shape).curveTo(17.449001, 9.000004, 17.000002, 9.4488535, 17.000002, 9.999668);
        ((GeneralPath) shape).lineTo(17.000002, 117.96352);
        ((GeneralPath) shape).curveTo(17.000002, 118.51533, 17.449001, 118.96318, 18.000002, 118.96318);
        ((GeneralPath) shape).lineTo(77.172, 118.96318);
        ((GeneralPath) shape).curveTo(77.435, 118.96318, 79.93468, 119.08131, 80.12068, 118.89438);
        ((GeneralPath) shape).lineTo(110.707, 88.0942);
        ((GeneralPath) shape).curveTo(110.894, 87.907265, 111.0, 85.40942, 111.0, 85.14651);
        ((GeneralPath) shape).lineTo(111.0, 9.999668);
        ((GeneralPath) shape).curveTo(111.0, 9.4488535, 110.552, 9.000004, 110.0, 9.000004);
        ((GeneralPath) shape).lineTo(18.000002, 9.000004);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(102, 112.30470275878906), 139.5586f, new Point2D.Double(102, 112.30470275878906), new float[]{0, 0.18851049f, 0.25718147f, 0.30111277f, 0.5313f, 0.8449f, 1}, new Color[]{new Color(0xB7B8B9), new Color(0xECECEC), new Color(0xFAFAFA), WHITE, new Color(0xFAFAFA), new Color(0xEBECEC), new Color(0xE1E2E3)}, NO_CYCLE, SRGB, new AffineTransform(1.295034f, 0, 0, 1.2946006f, -30.093452f, -33.119614f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.4f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 40, 0));

        // _0_4_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(41.87953, 115.98249);
        ((GeneralPath) shape).curveTo(41.87953, 115.98249, 66.18914, 91.672874, 66.18914, 91.672874);
        ((GeneralPath) shape).curveTo(66.18914, 91.672874, 56.836, 94.586, 46.586, 94.586);
        ((GeneralPath) shape).curveTo(46.586, 104.836, 41.87953, 115.98249, 41.87953, 115.98249);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_4_3
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_4_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(79.172, 120.0);
        ((GeneralPath) shape).curveTo(79.172, 120.0, 91.086, 110.086, 96.586, 104.586);
        ((GeneralPath) shape).curveTo(102.086, 99.086, 112.0, 87.172, 112.0, 87.172);
        ((GeneralPath) shape).curveTo(112.0, 87.172, 98.25, 96.0, 88.0, 96.0);
        ((GeneralPath) shape).curveTo(88.0, 106.25, 79.172, 120.0, 79.172, 120.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(98.61743927001953, 106.4144287109375), new Point2D.Double(91.2287368774414, 99.25497436523438), new float[]{0, 1}, new Color[]{new Color(0xA2A2A2), WHITE}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_4
        g.setComposite(AlphaComposite.getInstance(3, 0.9f * origAlpha));

        // _0_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(124.36598, 113.79242);
        ((GeneralPath) shape).curveTo(124.27969, 115.00674, 122.85389, 116.0, 121.19831, 116.0);
        ((GeneralPath) shape).lineTo(6.812906, 116.0);
        ((GeneralPath) shape).curveTo(5.157329, 116.0, 3.731522, 115.00674, 3.644228, 113.79242);
        ((GeneralPath) shape).lineTo(0.007982, 62.20463);
        ((GeneralPath) shape).curveTo(-0.112423, 60.992527, 1.143808, 60.0, 2.799384, 60.0);
        ((GeneralPath) shape).lineTo(125.21183, 60.0);
        ((GeneralPath) shape).curveTo(126.86741, 60.0, 128.11761, 60.99179, 127.9912, 62.203896);
        ((GeneralPath) shape).lineTo(124.36598, 113.79242);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(122.74437713623047, 96), new Point2D.Double(122.74437713623047, 20), new float[]{0, 0.130533f, 0.346213f, 0.72006166f, 1}, new Color[]{new Color(0x72B4F4), new Color(0xB3D9FF), new Color(0xB3D9FF), new Color(0x71A8F5), new Color(0x508ED9)}, NO_CYCLE, SRGB, new AffineTransform(1.0033808f, 0, 0, 0.7368421f, -8.2378f, 45.263157f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(125.21293, 60.0);
        ((GeneralPath) shape).lineTo(2.799926, 60.0);
        ((GeneralPath) shape).curveTo(1.1449261, 60.0, -0.11207393, 60.992527, 0.00792607, 62.20463);
        ((GeneralPath) shape).lineTo(3.6439261, 113.79242);
        ((GeneralPath) shape).curveTo(3.730926, 115.00674, 5.156926, 116.0, 6.8129263, 116.0);
        ((GeneralPath) shape).lineTo(121.19793, 116.0);
        ((GeneralPath) shape).curveTo(122.85393, 116.0, 124.27993, 115.00674, 124.36593, 113.79242);
        ((GeneralPath) shape).lineTo(127.99093, 62.203896);
        ((GeneralPath) shape).curveTo(128.11893, 60.99179, 126.86793, 60.0, 125.21293, 60.0);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(120.41393, 113.05263);
        ((GeneralPath) shape).curveTo(118.87493, 113.05263, 9.134926, 113.05263, 7.597926, 113.05263);
        ((GeneralPath) shape).curveTo(7.229926, 107.83726, 4.5229263, 70.62756, 4.065926, 64.14925);
        ((GeneralPath) shape).curveTo(6.518926, 64.14925, 121.45793, 64.14925, 123.93493, 64.14925);
        ((GeneralPath) shape).curveTo(123.81393, 65.85872, 120.49293, 111.92821, 120.41393, 113.05263);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(-178, -232.8496551513672), new Point2D.Double(-178, -304.61468505859375), new float[]{0, 0.1f, 1}, new Color[]{new Color(0xCFE7FF), new Color(0x71A8F5), new Color(0x2C72C7)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 0.7368421f, 242.00093f, 284.3684f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.835f * origAlpha));

        // _0_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(4.0, 64.0);
        ((GeneralPath) shape).curveTo(4.027349, 64.77587, 4.180272, 68.80112, 4.2225137, 70.0);
        ((GeneralPath) shape).curveTo(7.123925, 70.0, 122.78934, 70.0, 125.71499, 70.0);
        ((GeneralPath) shape).curveTo(125.74343, 69.19122, 125.93026, 64.204735, 125.9375, 64.0);
        ((GeneralPath) shape).curveTo(123.41788, 64.0, 6.495205, 64.0, 4.0, 64.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(-168.99215698242188, -300.5), new Point2D.Double(-168.99215698242188, -296.4844055175781), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1.0172054f, 0, 0, 1.5f, 246.03226f, 514.75f)));
        g.fill(shape);

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
        return 0;
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
        return 124;
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
    public DocumentOpen7() {
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

