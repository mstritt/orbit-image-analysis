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
import java.awt.geom.*;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static java.awt.MultipleGradientPaint.ColorSpaceType.SRGB;
import static java.awt.MultipleGradientPaint.CycleMethod.NO_CYCLE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class EditCopy4 implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.setComposite(AlphaComposite.getInstance(3, 0.49999997f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.001508f, 0, 0, 1.000616f, -0.05002205f, -0.06304895f));

        // _0_0_0
        g.setComposite(AlphaComposite.getInstance(3, 0.17045452f * origAlpha));

        // _0_0_0_0
        shape = new Rectangle2D.Double(20.161836624145508, 34.03341293334961, 13, 2);
        g.setPaint(BLACK);
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_0_1
        shape = new RoundRectangle2D.Double(1.5484408140182495, 1.5629303455352783, 30.95155906677246, 35.976688385009766, 1.131310224533081, 1.1323192119598389);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(22.308330535888672, 18.99213981628418), new Point2D.Double(35.78529357910156, 39.49823760986328), new float[]{0, 0.59928656f, 0.82758623f, 1}, new Color[]{new Color(0xF0F0EF), new Color(0xE8E8E8), WHITE, new Color(0xD8D8D3)}, NO_CYCLE, SRGB, new AffineTransform(1.065698f, 0, 0, 0.987595f, -8.54832f, -4.891713f)));
        g.fill(shape);
        g.setPaint(new Color(0x888A85));
        g.setStroke(new BasicStroke(0.99893934f, 0, 0, 4));
        g.draw(shape);

        // _0_0_0_2
        shape = new Rectangle2D.Double(2.532512903213501, 2.5605955123901367, 28.970741271972656, 33.981056213378906);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(26.076091766357422, 26.69667625427246), new Point2D.Double(30.811172485351562, 42.00735092163086), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(0.998504f, 0, 0, 0.998246f, -6.970391f, -4.892901f)));
        g.setStroke(new BasicStroke(0.99893963f, 0, 0, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.17045452f * origAlpha));

        // _0_0_0_3
        shape = new Rectangle2D.Double(7.016119003295898, 10.033413887023926, 21, 2);
        g.setPaint(BLACK);
        g.fill(shape);

        // _0_0_0_4
        shape = new Rectangle2D.Double(7.016119003295898, 14.033413887023926, 20, 2);
        g.fill(shape);

        // _0_0_0_5
        shape = new Rectangle2D.Double(7.016119003295898, 18.033414840698242, 18, 2);
        g.fill(shape);

        // _0_0_0_6
        shape = new Rectangle2D.Double(7.016119003295898, 22.033414840698242, 21, 2);
        g.fill(shape);

        // _0_0_0_7
        shape = new Rectangle2D.Double(7.016119003295898, 26.03341293334961, 13, 2);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_1

        // _0_0_1_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(15.072946, 10.500852);
        ((GeneralPath) shape).lineTo(44.929333, 10.500852);
        ((GeneralPath) shape).curveTo(45.24507, 10.500852, 45.499256, 10.753945, 45.499256, 11.068324);
        ((GeneralPath) shape).lineTo(45.499256, 38.235687);
        ((GeneralPath) shape).curveTo(45.499256, 40.71214, 38.619446, 46.538773, 36.231323, 46.538773);
        ((GeneralPath) shape).lineTo(15.072946, 46.538773);
        ((GeneralPath) shape).curveTo(14.757206, 46.538773, 14.50302, 46.285683, 14.50302, 45.9713);
        ((GeneralPath) shape).lineTo(14.50302, 11.068324);
        ((GeneralPath) shape).curveTo(14.50302, 10.753945, 14.757206, 10.500852, 15.072946, 10.500852);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(22.308330535888672, 18.99213981628418), new Point2D.Double(35.78529357910156, 39.49823760986328), new float[]{0, 0.59928656f, 0.82758623f, 1}, new Color[]{new Color(0xF0F0EF), new Color(0xE8E8E8), WHITE, new Color(0xD8D8D3)}, NO_CYCLE, SRGB, new AffineTransform(1.067236f, 0, 0, 0.989276f, 4.391684f, 4.035227f)));
        g.fill(shape);
        g.setPaint(new Color(0x888A85));
        g.setStroke(new BasicStroke(1, 0, 0, 4));
        g.draw(shape);

        // _0_0_1_1
        shape = new Rectangle2D.Double(15.502950668334961, 11.5, 28.99734878540039, 34.04076385498047);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(26.076091766357422, 26.69667625427246), new Point2D.Double(30.811172485351562, 42.00735092163086), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(0.999421f, 0, 0, 1, 5.991319f, 4.033411f)));
        g.draw(shape);

        // _0_0_1_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(36.220917, 46.536964);
        ((GeneralPath) shape).curveTo(38.251335, 46.866863, 45.80971, 42.00704, 45.50533, 38.039124);
        ((GeneralPath) shape).curveTo(43.942066, 40.46222, 40.746807, 39.32586, 36.63805, 39.48487);
        ((GeneralPath) shape).curveTo(36.63805, 39.48487, 37.033417, 46.036964, 36.220917, 46.536964);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(35.99658203125, 40.458221435546875), new Point2D.Double(33.664920806884766, 37.770721435546875), new float[]{0, 1}, new Color[]{new Color(0x7C7C7C), new Color(0xB8B8B8)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 6.161836f, 4.033411f)));
        g.fill(shape);
        g.setPaint(new Color(0x868A84));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.36931816f * origAlpha));

        // _0_0_1_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.671356, 44.345463);
        ((GeneralPath) shape).curveTo(39.041134, 43.661636, 42.099606, 42.198997, 43.398987, 40.317993);
        ((GeneralPath) shape).curveTo(41.80289, 40.99805, 40.451176, 40.527493, 37.69665, 40.5084);
        ((GeneralPath) shape).curveTo(37.69665, 40.5084, 37.858974, 43.570496, 37.671356, 44.345463);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(33.39600372314453, 36.92133331298828), new Point2D.Double(34.170047760009766, 38.07038116455078), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 6.161836f, 3.658411f)));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.17045452f * origAlpha));

        // _0_0_1_4
        shape = new Rectangle2D.Double(20, 19.033414840698242, 21, 2);
        g.setPaint(BLACK);
        g.fill(shape);

        // _0_0_1_5
        shape = new Rectangle2D.Double(20, 23.033414840698242, 19.992233276367188, 2);
        g.fill(shape);

        // _0_0_1_6
        shape = new Rectangle2D.Double(20, 27.033414840698242, 17.976701736450195, 2);
        g.fill(shape);

        // _0_0_1_7
        shape = new Rectangle2D.Double(20, 31.033414840698242, 21, 2);
        g.fill(shape);

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
        return 2;
    }

    /**
     * Returns the width of the bounding box of the original SVG image.
     *
     * @return The width of the bounding box of the original SVG image.
     */
    public static int getOrigWidth() {
        return 46;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     *
     * @return The height of the bounding box of the original SVG image.
     */
    public static int getOrigHeight() {
        return 47;
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
    public EditCopy4() {
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

