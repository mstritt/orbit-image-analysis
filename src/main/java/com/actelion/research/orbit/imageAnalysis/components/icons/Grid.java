/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2020 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
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
import java.awt.geom.Point2D;

import static java.awt.MultipleGradientPaint.ColorSpaceType.SRGB;
import static java.awt.MultipleGradientPaint.CycleMethod.NO_CYCLE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class Grid implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        Composite origComposite = ((Graphics2D) g).getComposite();
        if (origComposite instanceof AlphaComposite) {
            AlphaComposite origAlphaComposite = (AlphaComposite) origComposite;
            if (origAlphaComposite.getRule() == AlphaComposite.SRC_OVER) {
                origAlpha = origAlphaComposite.getAlpha();
            }
        }

        java.util.LinkedList<AffineTransform> transformations = new java.util.LinkedList<AffineTransform>();


        // 
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0666667f, 0, 0, 1.0666667f, 0, 0));

        // _0
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 0, -343.70078f));

        // _0_0

        // _0_0_0
        shape = new Ellipse2D.Double(294.66131591796875, 412.35736083984375, 143.328857421875, 154.0431671142578);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[]{0, 1}, new Color[]{new Color(0x00FF11), new Color(0xFF2A2A, true)}, NO_CYCLE, SRGB, new AffineTransform(1.2156287f, 0.02537319f, -0.03580432f, 1.1582936f, 68.3868f, -243.92572f)));
        g.fill(shape);
        g.setPaint(new Color(0xFFE800));
        g.setStroke(new BasicStroke(26.671133f, 0, 0, 4));
        g.draw(shape);

        // _0_0_1
        shape = new Ellipse2D.Double(42.49726104736328, 377.1440124511719, 133.07611083984375, 160.21897888183594);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[]{0, 1}, new Color[]{new Color(0x00FF11), new Color(0xFF2A2A, true)}, NO_CYCLE, SRGB, new AffineTransform(1.128671f, 0.02639044f, -0.03324313f, 1.2047313f, -167.59106f, -305.45035f)));
        g.fill(shape);
        g.setPaint(new Color(0xFFE800));
        g.setStroke(new BasicStroke(26.209602f, 0, 0, 4));
        g.draw(shape);

        // _0_0_2
        shape = new Ellipse2D.Double(524.4633178710938, 410.8026123046875, 143.32887268066406, 154.0431671142578);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[]{0, 1}, new Color[]{new Color(0x00FF11), new Color(0xFF2A2A, true)}, NO_CYCLE, SRGB, new AffineTransform(1.2156287f, 0.02537319f, -0.03580432f, 1.1582936f, 298.18875f, -245.48051f)));
        g.fill(shape);
        g.setPaint(new Color(0xFFE800));
        g.setStroke(new BasicStroke(26.671133f, 0, 0, 4));
        g.draw(shape);

        // _0_0_3
        shape = new Ellipse2D.Double(293.1766052246094, 647.1847534179688, 133.07611083984375, 160.21897888183594);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[]{0, 1}, new Color[]{new Color(0x00FF11), new Color(0xFF2A2A, true)}, NO_CYCLE, SRGB, new AffineTransform(1.128671f, 0.02639044f, -0.03324313f, 1.2047315f, 83.08828f, -35.40961f)));
        g.fill(shape);
        g.setPaint(new Color(0xFFE800));
        g.setStroke(new BasicStroke(26.209602f, 0, 0, 4));
        g.draw(shape);

        // _0_0_4
        shape = new Ellipse2D.Double(503.7065124511719, 867.0897216796875, 133.07611083984375, 160.21897888183594);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[]{0, 1}, new Color[]{new Color(0x00FF11), new Color(0xFF2A2A, true)}, NO_CYCLE, SRGB, new AffineTransform(1.128671f, 0.02639044f, -0.03324313f, 1.2047315f, 293.61816f, 184.49529f)));
        g.fill(shape);
        g.setPaint(new Color(0xFFE800));
        g.draw(shape);

        // _0_0_5
        shape = new Ellipse2D.Double(522.4564208984375, 632.91845703125, 133.07611083984375, 160.21897888183594);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[]{0, 1}, new Color[]{new Color(0x00FF11), new Color(0xFF2A2A, true)}, NO_CYCLE, SRGB, new AffineTransform(1.128671f, 0.02639044f, -0.03324313f, 1.2047315f, 312.36816f, -49.67592f)));
        g.fill(shape);
        g.setPaint(new Color(0xFFE800));
        g.draw(shape);

        // _0_0_6
        shape = new Ellipse2D.Double(28.199691772460938, 640.0823974609375, 143.32887268066406, 154.0431671142578);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[]{0, 1}, new Color[]{new Color(0x00FF11), new Color(0xFF2A2A, true)}, NO_CYCLE, SRGB, new AffineTransform(1.2156289f, 0.02537319f, -0.03580432f, 1.1582936f, -198.07486f, -16.20067f)));
        g.fill(shape);
        g.setPaint(new Color(0xFFE800));
        g.setStroke(new BasicStroke(26.671133f, 0, 0, 4));
        g.draw(shape);

        // _0_0_7
        shape = new Ellipse2D.Double(242.19427490234375, 868.3025512695312, 143.32887268066406, 154.0431671142578);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[]{0, 1}, new Color[]{new Color(0x00FF11), new Color(0xFF2A2A, true)}, NO_CYCLE, SRGB, new AffineTransform(1.2156289f, 0.02537319f, -0.03580432f, 1.1582936f, 15.919705f, 212.01944f)));
        g.fill(shape);
        g.setPaint(new Color(0xFFE800));
        g.draw(shape);

        // _0_0_8
        shape = new Ellipse2D.Double(30.23773193359375, 875.4765014648438, 143.32887268066406, 154.0431671142578);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[]{0, 1}, new Color[]{new Color(0x00FF11), new Color(0xFF2A2A, true)}, NO_CYCLE, SRGB, new AffineTransform(1.2156289f, 0.02537319f, -0.03580432f, 1.1582936f, -196.0368f, 219.19334f)));
        g.fill(shape);
        g.setPaint(new Color(0xFFE800));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0

        g.setTransform(transformations.poll()); // _0

    }

    /**
     * Returns the X of the bounding box of the original SVG image.
     *
     * @return The X of the bounding box of the original SVG image.
     */
    public static int getOrigX() {
        return 16;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     *
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 22;
    }

    /**
     * Returns the width of the bounding box of the original SVG image.
     *
     * @return The width of the bounding box of the original SVG image.
     */
    public static int getOrigWidth() {
        return 711;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     *
     * @return The height of the bounding box of the original SVG image.
     */
    public static int getOrigHeight() {
        return 725;
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
    public Grid() {
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

