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
import java.awt.geom.Rectangle2D;

import static java.awt.Color.BLUE;
import static java.awt.Color.WHITE;
import static java.awt.MultipleGradientPaint.ColorSpaceType.SRGB;
import static java.awt.MultipleGradientPaint.CycleMethod.NO_CYCLE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class SyncFrames implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.transform(new AffineTransform(1, 0, 0, 1, -79.62865f, -236.8761f));

        // _0_0

        // _0_0_0
        shape = new Rectangle2D.Double(84.0621566772461, 239.1986541748047, 117.88873291015625, 44.67893600463867);
        g.setPaint(WHITE);
        g.fill(shape);
        g.setPaint(BLUE);
        g.setStroke(new BasicStroke(2.7352762f, 0, 0, 4));
        g.draw(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(2.413849f, 0, 0, 2.413849f, 86.72886f, 239.94144f));

        // _0_0_1

        // _0_0_1_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(23.531, 4.5);
        ((GeneralPath) shape).curveTo(13.683, 4.8989, 5.84, 12.515, 4.625, 22.156);
        ((GeneralPath) shape).lineTo(15.25, 22.156);
        ((GeneralPath) shape).curveTo(16.308, 18.23, 20.101, 15.173, 24.281, 15.219);
        ((GeneralPath) shape).curveTo(26.645, 15.245, 28.927, 16.018, 30.625, 17.656);
        ((GeneralPath) shape).lineTo(26.219, 21.719);
        ((GeneralPath) shape).lineTo(42.25, 21.719);
        ((GeneralPath) shape).lineTo(42.25, 5.906);
        ((GeneralPath) shape).lineTo(38.031, 10.125);
        ((GeneralPath) shape).curveTo(34.323, 6.481, 30.035, 4.5602, 24.562, 4.5);
        ((GeneralPath) shape).curveTo(24.215, 4.4962, 23.875, 4.4861, 23.531, 4.5);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(15.373000144958496, 5.0472002029418945), new Point2D.Double(15.373000144958496, 22.600000381469727), new float[]{0, 1}, new Color[]{new Color(0x93B9DD), new Color(0x6396CD)}, NO_CYCLE, SRGB, new AffineTransform(0.95437f, 0, 0, 0.95437f, 0.4933f, 2.8946f)));
        g.fill(shape);
        g.setPaint(new Color(0x387AB8));
        g.setStroke(new BasicStroke(1, 0, 1, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.4f * origAlpha));

        // _0_0_1_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(14.219, 21.75);
        ((GeneralPath) shape).curveTo(15.5083, 17.4619, 19.8079, 13.9962, 24.344, 14.0625);
        ((GeneralPath) shape).curveTo(27.0171, 14.10158, 30.299, 15.2544, 32.3128, 17.5313);
        ((GeneralPath) shape).lineTo(29.094, 20.5938);
        ((GeneralPath) shape).lineTo(41.156, 20.62505);
        ((GeneralPath) shape).lineTo(41.156, 8.56305);
        ((GeneralPath) shape).lineTo(38.0, 11.78125);
        ((GeneralPath) shape).curveTo(34.458, 7.83065, 29.947, 5.80565, 24.406, 5.75025);
        ((GeneralPath) shape).curveTo(14.797, 5.65405, 7.234, 12.56525, 5.844, 21.75025);

        g.setPaint(new LinearGradientPaint(new Point2D.Double(35.233001708984375, 10.677000045776367), new Point2D.Double(10.51200008392334, 19.947999954223633), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(0.95437f, 0, 0, 0.95437f, 0.4933f, 2.8946f)));
        g.setStroke(new BasicStroke(1.193f, 0, 0, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_1

        g.setTransform(transformations.poll()); // _0_0
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_1

        // _0_1_0
        shape = new Rectangle2D.Double(84.0621566772461, 310.1986389160156, 117.88873291015625, 44.67893600463867);
        g.setPaint(WHITE);
        g.fill(shape);
        g.setPaint(BLUE);
        g.setStroke(new BasicStroke(2.7352762f, 0, 0, 4));
        g.draw(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-2.3698468f, -0.00410543f, 0.00388001f, -2.2397258f, 199.89734f, 354.01605f));

        // _0_1_1

        // _0_1_1_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(23.531, 4.5);
        ((GeneralPath) shape).curveTo(13.683, 4.8989, 5.84, 12.515, 4.625, 22.156);
        ((GeneralPath) shape).lineTo(15.25, 22.156);
        ((GeneralPath) shape).curveTo(16.308, 18.23, 20.101, 15.173, 24.281, 15.219);
        ((GeneralPath) shape).curveTo(26.645, 15.245, 28.927, 16.018, 30.625, 17.656);
        ((GeneralPath) shape).lineTo(26.219, 21.719);
        ((GeneralPath) shape).lineTo(42.25, 21.719);
        ((GeneralPath) shape).lineTo(42.25, 5.906);
        ((GeneralPath) shape).lineTo(38.031, 10.125);
        ((GeneralPath) shape).curveTo(34.323, 6.481, 30.035, 4.5602, 24.562, 4.5);
        ((GeneralPath) shape).curveTo(24.215, 4.4962, 23.875, 4.4861, 23.531, 4.5);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(15.373000144958496, 5.0472002029418945), new Point2D.Double(15.373000144958496, 22.600000381469727), new float[]{0, 1}, new Color[]{new Color(0x93B9DD), new Color(0x6396CD)}, NO_CYCLE, SRGB, new AffineTransform(0.95437f, 0, 0, 0.95437f, 0.4933f, 2.8946f)));
        g.fill(shape);
        g.setPaint(new Color(0x387AB8));
        g.setStroke(new BasicStroke(1, 0, 1, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.4f * origAlpha));

        // _0_1_1_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(14.219, 21.75);
        ((GeneralPath) shape).curveTo(15.5083, 17.4619, 19.8079, 13.9962, 24.344, 14.0625);
        ((GeneralPath) shape).curveTo(27.0171, 14.10158, 30.299, 15.2544, 32.3128, 17.5313);
        ((GeneralPath) shape).lineTo(29.094, 20.5938);
        ((GeneralPath) shape).lineTo(41.156, 20.62505);
        ((GeneralPath) shape).lineTo(41.156, 8.56305);
        ((GeneralPath) shape).lineTo(38.0, 11.78125);
        ((GeneralPath) shape).curveTo(34.458, 7.83065, 29.947, 5.80565, 24.406, 5.75025);
        ((GeneralPath) shape).curveTo(14.797, 5.65405, 7.234, 12.56525, 5.844, 21.75025);

        g.setPaint(new LinearGradientPaint(new Point2D.Double(35.233001708984375, 10.677000045776367), new Point2D.Double(10.51200008392334, 19.947999954223633), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(0.95437f, 0, 0, 0.95437f, 0.4933f, 2.8946f)));
        g.setStroke(new BasicStroke(1.193f, 0, 0, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_1_1

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
        return 125;
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
    public SyncFrames() {
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

