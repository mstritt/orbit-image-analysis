/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2016 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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
import java.awt.geom.Point2D;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static java.awt.MultipleGradientPaint.ColorSpaceType.SRGB;
import static java.awt.MultipleGradientPaint.CycleMethod.NO_CYCLE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class SystemHelp3 implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.transform(new AffineTransform(0.92086333f, 0, 0, 0.92086333f, 0, 0));

        // _0
        g.setComposite(AlphaComposite.getInstance(3, 0.7f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0859375f, 0, 0, 1.0859375f, -3.9093733f, -8.253123f));

        // _0_0
        shape = new Ellipse2D.Double(11.599998474121094, 11.599998474121094, 116, 116);
        g.setPaint(BLACK);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0
        g.setComposite(AlphaComposite.getInstance(3, 0.6f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, -0.099998474f, 1.9102535f));

        // _0_1
        shape = new Ellipse2D.Double(11.599998474121094, 111.5999984741211, 116, 21.145999908447266);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(69.60009765625, 69.57669830322266), 58, new Point2D.Double(69.60009765625, 69.57669830322266), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, -0.1823f, 0, 134.8566f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_1
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0859375f, 0, 0, 1.0859375f, -3.9093733f, -8.253123f));

        // _0_2
        shape = new Ellipse2D.Double(11.599998474121094, 11.599998474121094, 116, 116);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(69.60009765625, 69.60009765625), 58, new Point2D.Double(69.60009765625, 69.60009765625), new float[]{0.6154f, 0.8225f, 1}, new Color[]{new Color(0xEEEEEE), new Color(0xDDDDDD), WHITE}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_2

        // _0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(26.062502, 67.328125);
        ((GeneralPath) shape).curveTo(26.062502, 92.477356, 46.52265, 112.9375, 71.671875, 112.9375);
        ((GeneralPath) shape).curveTo(96.821106, 112.9375, 117.28125, 92.477356, 117.28125, 67.328125);
        ((GeneralPath) shape).curveTo(117.28125, 42.1789, 96.821106, 21.718754, 71.671875, 21.718754);
        ((GeneralPath) shape).curveTo(46.52265, 21.718754, 26.062502, 42.1789, 26.062502, 67.328125);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(27.600099563598633, 69.60009765625), new Point2D.Double(111.60009765625, 69.60009765625), new float[]{0, 1}, new Color[]{new Color(0x2A94EC), new Color(0x0057AE)}, NO_CYCLE, SRGB, new AffineTransform(1.0859375f, 0, 0, 1.0859375f, -3.9093733f, -8.253123f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.3f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0859375f, 0, 0, 1.0859375f, -3.9093733f, -8.253123f));

        // _0_4
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_4_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(77.041, 104.759);
        ((GeneralPath) shape).curveTo(63.767, 106.115, 50.122, 103.11, 46.565, 98.042);
        ((GeneralPath) shape).curveTo(43.007, 92.976, 50.885, 87.768, 64.16, 86.41);
        ((GeneralPath) shape).curveTo(77.434, 85.054, 91.079, 88.058, 94.637, 93.126);
        ((GeneralPath) shape).curveTo(98.193, 98.194, 90.315, 103.401, 77.041, 104.759);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xA8DDE0));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_4
        g.setComposite(AlphaComposite.getInstance(3, 0.8f * origAlpha));

        // _0_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(71.671875, 24.06655);
        ((GeneralPath) shape).curveTo(50.28868, 24.06655, 32.41958, 38.77123, 28.113838, 58.349598);
        ((GeneralPath) shape).curveTo(36.698174, 66.14228, 52.986153, 54.358776, 71.671875, 54.358776);
        ((GeneralPath) shape).curveTo(90.357605, 54.358776, 106.64666, 66.14228, 115.22991, 58.349598);
        ((GeneralPath) shape).curveTo(110.92417, 38.77123, 93.05616, 24.06655, 71.671875, 24.06655);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(135.5601043701172, 417.66461181640625), new Point2D.Double(161.87620544433594, 417.66461181640625), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(0, 1.7280523f, 1.7280523f, 0, -650.07477f, -218.71693f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0859375f, 0, 0, 1.0859375f, -3.9093733f, -8.253123f));

        // _0_6

        // _0_6_0

        // _0_6_0_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(27.6, 69.6);
        ((GeneralPath) shape).curveTo(27.6, 92.759, 46.441, 111.6, 69.6, 111.6);
        ((GeneralPath) shape).curveTo(92.759, 111.6, 111.6, 92.759, 111.6, 69.6);
        ((GeneralPath) shape).curveTo(111.6, 46.441, 92.759, 27.6, 69.6, 27.6);
        ((GeneralPath) shape).curveTo(46.441, 27.6, 27.6, 46.441, 27.6, 69.6);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x00316E));
        g.setStroke(new BasicStroke(2, 0, 0, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_6
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0859375f, 0, 0, 1.1113796f, -3.201342f, -9.317722f));

        // _0_7

        // _0_7_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(63.37, 80.089);
        ((GeneralPath) shape).lineTo(63.192, 77.746);
        ((GeneralPath) shape).curveTo(63.012, 73.148, 64.44, 68.462, 68.451, 63.684);
        ((GeneralPath) shape).curveTo(71.304, 60.26, 73.62, 57.286, 73.62, 54.221);
        ((GeneralPath) shape).curveTo(73.62, 51.157, 71.571, 48.994, 67.202, 48.903);
        ((GeneralPath) shape).curveTo(64.173, 48.903, 60.696, 49.895, 58.289, 51.517);
        ((GeneralPath) shape).lineTo(55.348, 41.784);
        ((GeneralPath) shape).curveTo(58.556, 39.89, 63.815, 38.088, 70.233, 38.088);
        ((GeneralPath) shape).curveTo(81.91, 38.088, 87.348, 44.668, 87.348, 52.058);
        ((GeneralPath) shape).curveTo(87.348, 58.997, 83.069, 63.415, 79.681, 67.289);
        ((GeneralPath) shape).curveTo(76.472, 70.894, 75.046, 74.41, 75.135, 78.466);
        ((GeneralPath) shape).lineTo(75.135, 80.088);
        ((GeneralPath) shape).lineTo(63.37, 80.088);
        ((GeneralPath) shape).lineTo(63.37, 80.089);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        // _0_7_1
        shape = new Ellipse2D.Double(61.599998474121094, 85.5999984741211, 16, 16);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_7
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0859375f, 0, 0, 1.0859375f, -3.201342f, -8.253123f));

        // _0_8

        // _0_8_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(63.37, 80.089);
        ((GeneralPath) shape).lineTo(63.192, 77.746);
        ((GeneralPath) shape).curveTo(63.012, 73.148, 64.44, 68.462, 68.451, 63.684);
        ((GeneralPath) shape).curveTo(71.304, 60.26, 73.62, 57.286, 73.62, 54.221);
        ((GeneralPath) shape).curveTo(73.62, 51.157, 71.571, 48.994, 67.202, 48.903);
        ((GeneralPath) shape).curveTo(64.173, 48.903, 60.696, 49.895, 58.289, 51.517);
        ((GeneralPath) shape).lineTo(55.348, 41.784);
        ((GeneralPath) shape).curveTo(58.556, 39.89, 63.815, 38.088, 70.233, 38.088);
        ((GeneralPath) shape).curveTo(81.91, 38.088, 87.348, 44.668, 87.348, 52.058);
        ((GeneralPath) shape).curveTo(87.348, 58.997, 83.069, 63.415, 79.681, 67.289);
        ((GeneralPath) shape).curveTo(76.472, 70.894, 75.046, 74.41, 75.135, 78.466);
        ((GeneralPath) shape).lineTo(75.135, 80.088);
        ((GeneralPath) shape).lineTo(63.37, 80.088);
        ((GeneralPath) shape).lineTo(63.37, 80.089);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);

        // _0_8_1
        shape = new Ellipse2D.Double(61.599998474121094, 85.5999984741211, 16, 16);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_8

        g.setTransform(transformations.poll()); // _0

    }

    /**
     * Returns the X of the bounding box of the original SVG image.
     *
     * @return The X of the bounding box of the original SVG image.
     */
    public static int getOrigX() {
        return -3;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     *
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return -7;
    }

    /**
     * Returns the width of the bounding box of the original SVG image.
     *
     * @return The width of the bounding box of the original SVG image.
     */
    public static int getOrigWidth() {
        return 140;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     *
     * @return The height of the bounding box of the original SVG image.
     */
    public static int getOrigHeight() {
        return 140;
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
    public SystemHelp3() {
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

