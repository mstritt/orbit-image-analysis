/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2018 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
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
public class EditPaste4 implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.02325216f, 0, 0, 0.01485743f, 44.80627f, 43.06039f));

        // _0_0_0
        g.setComposite(AlphaComposite.getInstance(3, 0.40206185f * origAlpha));

        // _0_0_0_0
        shape = new Rectangle2D.Double(-1559.2523193359375, -150.6968536376953, 1339.633544921875, 478.357177734375);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(302.8571472167969, 366.64788818359375), new Point2D.Double(302.8571472167969, 609.5050659179688), new float[]{0, 0.5f, 1}, new Color[]{new Color(0x0, true), BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(2.774389f, 0, 0, 1.969706f, -1892.179f, -872.8854f)));
        g.fill(shape);

        // _0_0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-219.61876, -150.68037);
        ((GeneralPath) shape).curveTo(-219.61876, -150.68037, -219.61876, 327.65042, -219.61876, 327.65042);
        ((GeneralPath) shape).curveTo(-76.74459, 328.55087, 125.78146, 220.48074, 125.78138, 88.45424);
        ((GeneralPath) shape).curveTo(125.78138, -43.572304, -33.655437, -150.68036, -219.61876, -150.68037);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(605.7142944335938, 486.64788818359375), 117.14286f, new Point2D.Double(605.7142944335938, 486.64788818359375), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(2.774389f, 0, 0, 1.969706f, -1891.633f, -872.8854f)));
        g.fill(shape);

        // _0_0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-1559.2523, -150.68037);
        ((GeneralPath) shape).curveTo(-1559.2523, -150.68037, -1559.2523, 327.65042, -1559.2523, 327.65042);
        ((GeneralPath) shape).curveTo(-1702.1265, 328.55087, -1904.6525, 220.48074, -1904.6525, 88.45424);
        ((GeneralPath) shape).curveTo(-1904.6525, -43.572304, -1745.2157, -150.68036, -1559.2523, -150.68037);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(605.7142944335938, 486.64788818359375), 117.14286f, new Point2D.Double(605.7142944335938, 486.64788818359375), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(-2.774389f, 0, 0, 1.969706f, 112.7623f, -872.8854f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_1
        shape = new RoundRectangle2D.Double(4.464317321777344, 4.5, 39.035682678222656, 41.04543685913086, 2.775874137878418, 2.7758727073669434);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(6.107174396514893, 10.451290130615234), new Point2D.Double(33.85714340209961, 37.879859924316406), new float[]{0, 1}, new Color[]{new Color(0xC68827), new Color(0x89601F)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);
        g.setPaint(new Color(0x714C16));
        g.setStroke(new BasicStroke(1, 0, 0, 4));
        g.draw(shape);

        // _0_0_2
        shape = new RoundRectangle2D.Double(8.53232192993164, 6.529515743255615, 30.95155906677246, 35.976688385009766, 1.1330167055130005, 1.1330167055130005);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(22.308330535888672, 18.99213981628418), new Point2D.Double(35.78529357910156, 39.49823760986328), new float[]{0, 0.59928656f, 0.82758623f, 1}, new Color[]{new Color(0xF0F0EF), new Color(0xE8E8E8), WHITE, new Color(0xD8D8D3)}, NO_CYCLE, SRGB, new AffineTransform(1.065698f, 0, 0, 0.987595f, -1.564439f, 0.07487332f)));
        g.fill(shape);
        g.setPaint(new Color(0x888A85));
        g.draw(shape);

        // _0_0_3
        shape = new RoundRectangle2D.Double(18, 0, 12, 4, 1.9677506685256958, 1.9677506685256958);
        g.setPaint(new Color(0x5C5C5C));
        g.fill(shape);

        // _0_0_4
        shape = new Rectangle2D.Double(9.517141342163086, 7.466585636138916, 29.01414680480957, 34.04076385498047);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(26.076091766357422, 26.69667625427246), new Point2D.Double(30.811172485351562, 42.00735092163086), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.draw(shape);

        // _0_0_5
        shape = new RoundRectangle2D.Double(5.439342498779297, 5.430777549743652, 37.085655212402344, 39.092987060546875, 0.9575969576835632, 0.9575969576835632);
        g.setPaint(new Color(0xC68827));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.10795455f * origAlpha));

        // _0_0_6
        shape = new RoundRectangle2D.Double(14.791487693786621, 4.472271919250488, 18.947376251220703, 7, 2.7758753299713135, 2.7758727073669434);
        g.setPaint(BLACK);
        g.fill(shape);
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_7
        shape = new RoundRectangle2D.Double(14.526322364807129, 3.5, 18.947376251220703, 7, 2.7758753299713135, 2.7758727073669434);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(25.404571533203125, 3.818019390106201), new Point2D.Double(25.464210510253906, 9.32335090637207), new float[]{0, 0.5f, 1}, new Color[]{new Color(0x97978A), new Color(0xC2C2B9), new Color(0x7D7D6F)}, NO_CYCLE, SRGB, new AffineTransform(1.052632f, 0, 0, 1, -1.789474f, 0)));
        g.fill(shape);
        g.setPaint(new Color(0x5C5C5C));
        g.draw(shape);

        // _0_0_8
        shape = new RoundRectangle2D.Double(19.151323318481445, 1.20867919921875, 9.697376251220703, 3.5826404094696045, 0.6508727073669434, 0.6508727073669434);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(25.404571533203125, 3.818019390106201), new Point2D.Double(25.404571533203125, 6.481060981750488), new float[]{0, 0.5f, 1}, new Color[]{new Color(0x97978A), new Color(0xC2C2B9), new Color(0x7D7D6F)}, NO_CYCLE, SRGB, new AffineTransform(0.538743f, 0, 0, 0.511806f, 10.8008f, -0.58264f)));
        g.fill(shape);

        // _0_0_9
        shape = new RoundRectangle2D.Double(14.953014373779297, 3.9375, 18.093992233276367, 6.1875, 2.0258727073669434, 2.0258727073669434);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(25.404571533203125, 3.818019390106201), new Point2D.Double(25.464210510253906, 9.32335090637207), new float[]{0, 0.5f, 1}, new Color[]{new Color(0x97978A), new Color(0xC2C2B9), new Color(0x7D7D6F)}, NO_CYCLE, SRGB, new AffineTransform(1.005222f, 0, 0, 0.883928f, -0.627923f, 0.84375f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.48863637f * origAlpha));

        // _0_0_10
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(39.018307, 36.25);
        ((GeneralPath) shape).lineTo(39.0625, 42.0625);
        ((GeneralPath) shape).lineTo(30.5625, 42.018307);
        ((GeneralPath) shape).lineTo(39.018307, 36.25);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(36.8125, 39.15625), new Point2D.Double(39.0625, 42.0625), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_11
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(30.059082, 42.086864);
        ((GeneralPath) shape).curveTo(31.850224, 42.254517, 39.04881, 37.717278, 39.53992, 33.698856);
        ((GeneralPath) shape).curveTo(37.97666, 36.121952, 34.584972, 35.667446, 30.476213, 35.826454);
        ((GeneralPath) shape).curveTo(30.476213, 35.826454, 30.871582, 41.586864, 30.059082, 42.086864);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(35.99658203125, 40.458221435546875), new Point2D.Double(33.664920806884766, 37.770721435546875), new float[]{0, 1}, new Color[]{new Color(0x7C7C7C), new Color(0xB8B8B8)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);
        g.setPaint(new Color(0x868A84));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.31681818f * origAlpha));

        // _0_0_12
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(19.46875, 1.46875);
        ((GeneralPath) shape).curveTo(19.466654, 1.4708456, 19.470413, 1.4975336, 19.46875, 1.5);
        ((GeneralPath) shape).curveTo(19.46758, 1.502776, 19.438116, 1.4969757, 19.4375, 1.5);
        ((GeneralPath) shape).lineTo(19.4375, 4.375);
        ((GeneralPath) shape).curveTo(19.4375, 4.381423, 19.46641, 4.400698, 19.46875, 4.40625);
        ((GeneralPath) shape).curveTo(19.471216, 4.4079137, 19.465975, 4.43633, 19.46875, 4.4375);
        ((GeneralPath) shape).lineTo(15.9375, 4.4375);
        ((GeneralPath) shape).curveTo(15.91974, 4.4375, 15.892285, 4.4357553, 15.875, 4.4375);
        ((GeneralPath) shape).curveTo(15.840968, 4.4426713, 15.781454, 4.4572763, 15.75, 4.46875);
        ((GeneralPath) shape).curveTo(15.611832, 4.5269966, 15.482328, 4.66777, 15.4375, 4.8125);
        ((GeneralPath) shape).curveTo(15.426991, 4.8535347, 15.4375, 4.924349, 15.4375, 4.96875);
        ((GeneralPath) shape).lineTo(15.4375, 9.125);
        ((GeneralPath) shape).curveTo(15.4375, 9.14276, 15.435755, 9.170215, 15.4375, 9.1875);
        ((GeneralPath) shape).curveTo(15.442671, 9.221532, 15.457276, 9.281046, 15.46875, 9.3125);
        ((GeneralPath) shape).curveTo(15.478458, 9.335528, 15.487176, 9.3851, 15.5, 9.40625);
        ((GeneralPath) shape).curveTo(15.5046, 9.41307, 15.526336, 9.430921, 15.53125, 9.4375);
        ((GeneralPath) shape).curveTo(15.552124, 9.462814, 15.599686, 9.510377, 15.625, 9.53125);
        ((GeneralPath) shape).curveTo(15.638159, 9.541079, 15.6734, 9.55395, 15.6875, 9.5625);
        ((GeneralPath) shape).curveTo(15.702038, 9.570378, 15.734648, 9.587278, 15.75, 9.59375);
        ((GeneralPath) shape).curveTo(15.781454, 9.605224, 15.840968, 9.619829, 15.875, 9.625);
        ((GeneralPath) shape).curveTo(15.892285, 9.626745, 15.91974, 9.625, 15.9375, 9.625);
        ((GeneralPath) shape).lineTo(32.0625, 9.625);
        ((GeneralPath) shape).curveTo(32.08026, 9.625, 32.107716, 9.626745, 32.125, 9.625);
        ((GeneralPath) shape).curveTo(32.15903, 9.619829, 32.218548, 9.605224, 32.25, 9.59375);
        ((GeneralPath) shape).curveTo(32.26535, 9.587278, 32.297962, 9.570378, 32.3125, 9.5625);
        ((GeneralPath) shape).curveTo(32.3266, 9.55395, 32.36184, 9.541079, 32.375, 9.53125);
        ((GeneralPath) shape).curveTo(32.400314, 9.510377, 32.447876, 9.462814, 32.46875, 9.4375);
        ((GeneralPath) shape).curveTo(32.473663, 9.430921, 32.4954, 9.41307, 32.5, 9.40625);
        ((GeneralPath) shape).curveTo(32.512825, 9.3851, 32.52154, 9.335528, 32.53125, 9.3125);
        ((GeneralPath) shape).curveTo(32.542725, 9.281046, 32.557327, 9.221532, 32.5625, 9.1875);
        ((GeneralPath) shape).curveTo(32.564243, 9.170215, 32.5625, 9.14276, 32.5625, 9.125);
        ((GeneralPath) shape).lineTo(32.5625, 4.96875);
        ((GeneralPath) shape).curveTo(32.5625, 4.924349, 32.57301, 4.8535347, 32.5625, 4.8125);
        ((GeneralPath) shape).curveTo(32.517673, 4.66777, 32.38817, 4.5269966, 32.25, 4.46875);
        ((GeneralPath) shape).curveTo(32.218548, 4.4572763, 32.15903, 4.4426713, 32.125, 4.4375);
        ((GeneralPath) shape).curveTo(32.107716, 4.4357553, 32.08026, 4.4375, 32.0625, 4.4375);
        ((GeneralPath) shape).lineTo(28.53125, 4.4375);
        ((GeneralPath) shape).curveTo(28.534025, 4.43633, 28.528784, 4.4079137, 28.53125, 4.40625);
        ((GeneralPath) shape).curveTo(28.53359, 4.400698, 28.5625, 4.381423, 28.5625, 4.375);
        ((GeneralPath) shape).lineTo(28.5625, 1.5);
        ((GeneralPath) shape).curveTo(28.561884, 1.4969757, 28.53242, 1.502776, 28.53125, 1.5);
        ((GeneralPath) shape).curveTo(28.529587, 1.4975336, 28.533346, 1.4708456, 28.53125, 1.46875);
        ((GeneralPath) shape).curveTo(28.528475, 1.4675798, 28.503023, 1.4693657, 28.5, 1.46875);
        ((GeneralPath) shape).lineTo(19.5, 1.46875);
        ((GeneralPath) shape).curveTo(19.496977, 1.4693657, 19.471525, 1.4675798, 19.46875, 1.46875);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(25.682828903198242, 12.172059059143066), new Point2D.Double(25.692169189453125, -0.2029409557580948), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.3693182f * origAlpha));

        // _0_0_13
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(31.50952, 40.68705);
        ((GeneralPath) shape).curveTo(32.8793, 40.00322, 36.038784, 38.086018, 37.338165, 36.205013);
        ((GeneralPath) shape).curveTo(35.545643, 36.581497, 34.347244, 36.794586, 31.610577, 36.900494);
        ((GeneralPath) shape).curveTo(31.610577, 36.900494, 31.697138, 39.91208, 31.50952, 40.68705);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(33.39600372314453, 36.92133331298828), new Point2D.Double(34.170047760009766, 38.07038116455078), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.17045455f * origAlpha));

        // _0_0_14
        shape = new Rectangle2D.Double(14, 15, 21, 2);
        g.setPaint(BLACK);
        g.fill(shape);

        // _0_0_15
        shape = new Rectangle2D.Double(14, 19, 20, 2);
        g.fill(shape);

        // _0_0_16
        shape = new Rectangle2D.Double(14, 23, 18, 2);
        g.fill(shape);

        // _0_0_17
        shape = new Rectangle2D.Double(14, 27, 21, 2);
        g.fill(shape);

        // _0_0_18
        shape = new Rectangle2D.Double(14, 31, 13, 2);
        g.fill(shape);

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
        return 48;
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
    public EditPaste4() {
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

