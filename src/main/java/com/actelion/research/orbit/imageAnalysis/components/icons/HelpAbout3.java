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
public class HelpAbout3 implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.transform(new AffineTransform(-1.001374f, 0, 0, 0.410379f, 128, 75.32738f));

        // _0_0_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(127.82442, 115.70919);
        ((GeneralPath) shape).curveTo(127.82442, 122.69116, 99.209946, 128.35117, 63.91221, 128.35117);
        ((GeneralPath) shape).curveTo(28.61447, 128.35117, 7.1054274E-15, 122.69116, 0.0, 115.70919);
        ((GeneralPath) shape).curveTo(0.0, 108.72722, 28.61447, 103.067215, 63.91221, 103.067215);
        ((GeneralPath) shape).curveTo(99.209946, 103.067215, 127.82442, 108.72722, 127.82442, 115.70919);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(63.912208557128906, 115.70919036865234), 63.91221f, new Point2D.Double(63.975181579589844, 116.88513946533203), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 0.197802f, 0, 92.82166f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-1.502244f, 0.402525f, -0.402525f, -1.502244f, 617.8027f, 63.73825f));

        // _0_0_1
        shape = new Ellipse2D.Double(307.9989929199219, 56, 72, 72);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(-70.00289916992188, -383.9971008300781), new Point2D.Double(-11.91648006439209, -383.9971008300781), new float[]{0, 1}, new Color[]{new Color(0x0081EC), new Color(0x0057AE)}, NO_CYCLE, SRGB, new AffineTransform(0, 1, -1, 0, -39.9985f, 140.0029f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_1
        g.setComposite(AlphaComposite.getInstance(3, 0.4f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.667663f, 0.06708758f, -0.1789f, -0.250375f, 310.1343f, 104.4008f));

        // _0_0_2
        shape = new Ellipse2D.Double(307.9989929199219, 56, 72, 72);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(343.9989929199219, 92), 36, new Point2D.Double(343.9989929199219, 92), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(0, 1, -1, 0, -39.9985f, 140.0029f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_2
        g.setComposite(AlphaComposite.getInstance(3, 0.8f * origAlpha));

        // _0_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(64.00003, 14.177736);
        ((GeneralPath) shape).curveTo(39.563103, 14.177736, 19.143818, 31.433502, 14.22224, 54.40774);
        ((GeneralPath) shape).curveTo(24.032276, 63.55275, 42.646324, 69.72398, 64.00003, 69.72398);
        ((GeneralPath) shape).curveTo(85.35376, 69.72398, 103.96779, 63.55275, 113.77782, 54.40774);
        ((GeneralPath) shape).curveTo(108.85626, 31.433502, 88.43695, 14.177736, 64.00003, 14.177736);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(-88.0580825805664, -131.93112182617188), new Point2D.Double(-45.09658432006836, -131.93112182617188), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(0, 1.591298f, -1.591298f, 0, -146.0489f, 141.4862f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));

        // _0_0_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(72.0, 56.0);
        ((GeneralPath) shape).lineTo(48.0, 56.0);
        ((GeneralPath) shape).lineTo(48.0, 64.0);
        ((GeneralPath) shape).lineTo(56.0, 64.0);
        ((GeneralPath) shape).lineTo(56.0, 96.0);
        ((GeneralPath) shape).lineTo(48.0, 96.0);
        ((GeneralPath) shape).lineTo(48.0, 104.0);
        ((GeneralPath) shape).lineTo(80.0, 104.0);
        ((GeneralPath) shape).lineTo(80.0, 96.0);
        ((GeneralPath) shape).lineTo(72.0, 96.0);
        ((GeneralPath) shape).curveTo(72.0, 96.0, 72.0, 56.0, 72.0, 56.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x0057AE));
        g.setStroke(new BasicStroke(4, 0, 1, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-106.3852, 44.124126);
        ((GeneralPath) shape).lineTo(-106.3852, 41.32942);
        ((GeneralPath) shape).lineTo(-106.3852, 44.124126);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xC1FFFFFF, true));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));

        // _0_0_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(64.12579, 22.602966);
        ((GeneralPath) shape).curveTo(57.50303, 22.602966, 52.125797, 27.98018, 52.125797, 34.60297);
        ((GeneralPath) shape).curveTo(52.125797, 41.22576, 57.50303, 46.60297, 64.12579, 46.60297);
        ((GeneralPath) shape).curveTo(70.74859, 46.60297, 76.1258, 41.225758, 76.1258, 34.60297);
        ((GeneralPath) shape).curveTo(76.1258, 27.98018, 70.7486, 22.602966, 64.12579, 22.602966);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x0057AE));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(64.12579, 22.602966);
        ((GeneralPath) shape).curveTo(57.50303, 22.602966, 52.125797, 27.98018, 52.125797, 34.60297);
        ((GeneralPath) shape).curveTo(52.125797, 41.22576, 57.50303, 46.60297, 64.12579, 46.60297);
        ((GeneralPath) shape).curveTo(70.74859, 46.60297, 76.1258, 41.225758, 76.1258, 34.60297);
        ((GeneralPath) shape).curveTo(76.1258, 27.98018, 70.7486, 22.602966, 64.12579, 22.602966);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);

        // _0_0_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(72.0, 56.0);
        ((GeneralPath) shape).lineTo(48.0, 56.0);
        ((GeneralPath) shape).lineTo(48.0, 64.0);
        ((GeneralPath) shape).lineTo(56.0, 64.0);
        ((GeneralPath) shape).lineTo(56.0, 96.0);
        ((GeneralPath) shape).lineTo(48.0, 96.0);
        ((GeneralPath) shape).lineTo(48.0, 104.0);
        ((GeneralPath) shape).lineTo(80.0, 104.0);
        ((GeneralPath) shape).lineTo(80.0, 96.0);
        ((GeneralPath) shape).lineTo(72.0, 96.0);
        ((GeneralPath) shape).curveTo(72.0, 96.0, 72.0, 56.0, 72.0, 56.0);
        ((GeneralPath) shape).closePath();

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
    public HelpAbout3() {
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

