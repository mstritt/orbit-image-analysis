/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
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
public class ProcessStop4 implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.setComposite(AlphaComposite.getInstance(3, 0.6306818f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.173803f, 0, 0, 0.6f, -5.265866f, 19.575f));

        // _0_0_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(40.875, 36.75);
        ((GeneralPath) shape).curveTo(40.875, 41.92767, 33.823486, 46.125, 25.125, 46.125);
        ((GeneralPath) shape).curveTo(16.426516, 46.125, 9.375, 41.92767, 9.375, 36.75);
        ((GeneralPath) shape).curveTo(9.375, 31.57233, 16.426516, 27.375, 25.125, 27.375);
        ((GeneralPath) shape).curveTo(33.823486, 27.375, 40.875, 31.57233, 40.875, 36.75);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(25.125, 36.75), 15.75f, new Point2D.Double(25.125, 36.75), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 0.595238f, 0, 14.875f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(15.591006, 0.4919213);
        ((GeneralPath) shape).lineTo(32.67631, 0.4919213);
        ((GeneralPath) shape).lineTo(45.497585, 13.586385);
        ((GeneralPath) shape).lineTo(45.497585, 31.48003);
        ((GeneralPath) shape).lineTo(32.848988, 43.49693);
        ((GeneralPath) shape).lineTo(15.418649, 43.49693);
        ((GeneralPath) shape).lineTo(2.4943857, 30.658264);
        ((GeneralPath) shape).lineTo(2.4943857, 13.464078);
        ((GeneralPath) shape).lineTo(15.591006, 0.4919213);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(23.99598503112793, 20.105337142944336), new Point2D.Double(41.04783630371094, 37.95978546142578), new float[]{0, 1}, new Color[]{new Color(0xCC0000), new Color(0xB30000)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 0, -2)));
        g.fill(shape);
        g.setPaint(new Color(0x860000));
        g.setStroke(new BasicStroke(1, 0, 0, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.8131868f * origAlpha));

        // _0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(16.020655, 1.5003424);
        ((GeneralPath) shape).lineTo(32.24856, 1.5003424);
        ((GeneralPath) shape).lineTo(44.496456, 13.922717);
        ((GeneralPath) shape).lineTo(44.496456, 31.037);
        ((GeneralPath) shape).lineTo(32.638474, 42.48783);
        ((GeneralPath) shape).lineTo(15.870253, 42.48783);
        ((GeneralPath) shape).lineTo(3.5090792, 30.208717);
        ((GeneralPath) shape).lineTo(3.5090792, 13.84561);
        ((GeneralPath) shape).lineTo(16.020655, 1.5003424);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(15.737001419067383, 12.503600120544434), new Point2D.Double(53.570125579833984, 47.37431716918945), new float[]{0, 1}, new Color[]{new Color(0xFF8B8B), new Color(0xEC1B1B)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 0, -2)));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.28977272f * origAlpha));

        // _0_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(15.6875, 0.75);
        ((GeneralPath) shape).lineTo(2.75, 13.5625);
        ((GeneralPath) shape).lineTo(2.75, 30.5625);
        ((GeneralPath) shape).lineTo(5.6875, 33.46875);
        ((GeneralPath) shape).curveTo(22.45004, 33.5263, 22.164665, 20.450068, 45.25, 21.59375);
        ((GeneralPath) shape).lineTo(45.25, 13.6875);
        ((GeneralPath) shape).lineTo(32.5625, 0.75);
        ((GeneralPath) shape).lineTo(15.6875, 0.75);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(16.75, 10.666343688964844), 21.25f, new Point2D.Double(16.75, 10.666343688964844), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(4.154957f, 0, 0, 3.198723f, -52.84553f, -23.50921f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(16.767176, 10.5);
        ((GeneralPath) shape).lineTo(12.5, 14.767175);
        ((GeneralPath) shape).lineTo(20.035074, 22.30225);
        ((GeneralPath) shape).lineTo(12.5, 29.837324);
        ((GeneralPath) shape).lineTo(16.767176, 34.1045);
        ((GeneralPath) shape).lineTo(24.30225, 26.569426);
        ((GeneralPath) shape).lineTo(31.837324, 34.1045);
        ((GeneralPath) shape).lineTo(36.1045, 29.837324);
        ((GeneralPath) shape).lineTo(28.569426, 22.30225);
        ((GeneralPath) shape).lineTo(36.1045, 14.767175);
        ((GeneralPath) shape).lineTo(31.837324, 10.5);
        ((GeneralPath) shape).lineTo(24.30225, 18.035074);
        ((GeneralPath) shape).lineTo(16.767176, 10.5);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(24.302249908447266, 33.302249908447266), 12.30225f, new Point2D.Double(24.302249908447266, 33.302249908447266), new float[]{0, 1}, new Color[]{WHITE, new Color(0xDBDBDB)}, NO_CYCLE, SRGB, new AffineTransform(1.693981f, 0, 0, 1.693981f, -16.86529f, -25.11111f)));
        g.fill(shape);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(21.75, 15.802249908447266), new Point2D.Double(24.302249908447266, 35.052249908447266), new float[]{0, 1}, new Color[]{new Color(0xFF0202), new Color(0xFF9B9B)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 0, -2)));
        g.setStroke(new BasicStroke(1, 1, 1, 4));
        g.draw(shape);

    }

    /**
     * Returns the X of the bounding box of the original SVG image.
     *
     * @return The X of the bounding box of the original SVG image.
     */
    public static int getOrigX() {
        return 2;
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
        return 45;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     *
     * @return The height of the bounding box of the original SVG image.
     */
    public static int getOrigHeight() {
        return 48;
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
    public ProcessStop4() {
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

