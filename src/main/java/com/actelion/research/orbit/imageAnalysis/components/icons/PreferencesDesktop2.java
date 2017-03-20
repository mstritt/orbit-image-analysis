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
public class PreferencesDesktop2 implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.transform(new AffineTransform(1, 0, 0, 1, -0.75f, 0));

        // _0_0_0
        g.setComposite(AlphaComposite.getInstance(3, 0.85294116f * origAlpha));

        // _0_0_0_0
        shape = new Rectangle2D.Double(8.344184875488281, 31.66289710998535, 32.36289596557617, 11.482156753540039);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(302.8571472167969, 366.64788818359375), new Point2D.Double(302.8571472167969, 609.5050659179688), new float[]{0, 0.5f, 1}, new Color[]{new Color(0x0, true), BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(0.06702375f, 0, 0, 0.04727947f, 0.3013351f, 14.32798f)));
        g.fill(shape);

        // _0_0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(40.70708, 31.663294);
        ((GeneralPath) shape).curveTo(40.70708, 31.663294, 40.70708, 43.144817, 40.70708, 43.144817);
        ((GeneralPath) shape).curveTo(44.158638, 43.16643, 49.05127, 40.572388, 49.051266, 37.403316);
        ((GeneralPath) shape).curveTo(49.051266, 34.23424, 45.19959, 31.663294, 40.70708, 31.663294);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(605.7142944335938, 486.64788818359375), 117.14286f, new Point2D.Double(605.7142944335938, 486.64788818359375), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(0.06702375f, 0, 0, 0.04727947f, 0.3145254f, 14.32798f)));
        g.fill(shape);

        // _0_0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(8.344186, 31.663294);
        ((GeneralPath) shape).curveTo(8.344186, 31.663294, 8.344186, 43.144817, 8.344186, 43.144817);
        ((GeneralPath) shape).curveTo(4.8926277, 43.16643, 2.6449978E-9, 40.572388, 2.6449978E-9, 37.403316);
        ((GeneralPath) shape).curveTo(2.6449978E-9, 34.23424, 3.8516777, 31.663294, 8.344186, 31.663294);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(605.7142944335938, 486.64788818359375), 117.14286f, new Point2D.Double(605.7142944335938, 486.64788818359375), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(-0.06702375f, 0, 0, 0.04727947f, 48.73675f, 14.32798f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(9.022859, 9.0);
        ((GeneralPath) shape).curveTo(8.395477, 9.0, 7.9876804, 9.293946, 7.7367287, 9.854703);
        ((GeneralPath) shape).curveTo(7.7367277, 9.854703, 3.2509522, 29.876846, 3.2509522, 29.876846);
        ((GeneralPath) shape).curveTo(3.2509522, 29.876846, 3.0, 30.55712, 3.0, 31.681213);
        ((GeneralPath) shape).curveTo(3.0, 31.681213, 3.0, 37.404507, 3.0, 37.404507);
        ((GeneralPath) shape).curveTo(3.0, 38.50117, 3.6602912, 39.0506, 4.6625605, 39.050594);
        ((GeneralPath) shape).lineTo(43.371986, 39.050594);
        ((GeneralPath) shape).curveTo(44.360588, 39.050594, 44.971806, 38.323093, 44.971806, 37.18292);
        ((GeneralPath) shape).lineTo(44.971806, 31.459623);
        ((GeneralPath) shape).curveTo(44.971806, 31.459623, 45.078175, 30.679201, 44.8777, 30.13009);
        ((GeneralPath) shape).lineTo(40.140972, 10.012982);
        ((GeneralPath) shape).curveTo(39.95574, 9.494432, 39.50164, 9.012061, 39.011684, 9.0);
        ((GeneralPath) shape).lineTo(9.022859, 9.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x888A85));
        g.setStroke(new BasicStroke(2, 1, 1, 4));
        g.draw(shape);

        // _0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(3.0, 31.081251);
        ((GeneralPath) shape).lineTo(3.7675865, 30.389036);
        ((GeneralPath) shape).lineTo(41.52408, 30.451536);
        ((GeneralPath) shape).lineTo(45.0, 30.768835);
        ((GeneralPath) shape).lineTo(45.0, 37.207367);
        ((GeneralPath) shape).curveTo(45.0, 38.332935, 44.390614, 39.050697, 43.401917, 39.050697);
        ((GeneralPath) shape).lineTo(4.668326, 39.050697);
        ((GeneralPath) shape).curveTo(3.6659644, 39.050697, 3.0, 38.508648, 3.0, 37.426033);
        ((GeneralPath) shape).lineTo(3.0, 31.081251);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(7.604620456695557, 28.481176376342773), new Point2D.Double(36.183067321777344, 40.94393539428711), new float[]{0, 1}, new Color[]{new Color(0xD9D9D9), new Color(0xC7C7C7)}, NO_CYCLE, SRGB, new AffineTransform(1.0039034f, 0, 0, 1, -0.2863699f, 4.084439f)));
        g.fill(shape);

        // _0_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(3.289293, 29.978281);
        ((GeneralPath) shape).curveTo(2.5728183, 31.45515, 3.2886763, 32.3917, 4.328183, 32.3917);
        ((GeneralPath) shape).curveTo(4.328183, 32.3917, 43.447746, 32.3917, 43.447746, 32.3917);
        ((GeneralPath) shape).curveTo(44.570225, 32.367687, 45.29864, 31.3711, 44.880695, 30.230429);
        ((GeneralPath) shape).lineTo(40.151955, 10.008597);
        ((GeneralPath) shape).curveTo(39.966866, 9.492291, 39.495186, 9.012007, 39.005596, 9.0);
        ((GeneralPath) shape).lineTo(9.056921, 9.0);
        ((GeneralPath) shape).curveTo(8.430004, 9.0, 8.018031, 9.306182, 7.767266, 9.864512);
        ((GeneralPath) shape).curveTo(7.767266, 9.864512, 3.289293, 29.978281, 3.289293, 29.978281);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(15.571491241455078, 2.9585189819335938), 20.935818f, new Point2D.Double(15.571491241455078, 2.9585189819335938), new float[]{0, 1}, new Color[]{new Color(0xF0F0F0), new Color(0xE0E0E0)}, NO_CYCLE, SRGB, new AffineTransform(1.2901853f, 0.7884154f, -0.7129611f, 1.1796023f, -2.6322372f, -1.0775827f)));
        g.fill(shape);

        // _0_0_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(44.85227, 29.713127);
        ((GeneralPath) shape).curveTo(44.916294, 30.963102, 44.435, 32.02897, 43.51973, 32.056877);
        ((GeneralPath) shape).curveTo(43.51973, 32.056877, 5.100482, 32.056877, 5.100482, 32.056877);
        ((GeneralPath) shape).curveTo(3.8010855, 32.056877, 3.2180204, 31.731932, 3.0, 31.188822);
        ((GeneralPath) shape).curveTo(3.0924845, 32.133156, 3.8323278, 32.838127, 5.100482, 32.838127);
        ((GeneralPath) shape).curveTo(5.100482, 32.838127, 43.51973, 32.838127, 43.51973, 32.838127);
        ((GeneralPath) shape).curveTo(44.60422, 32.805058, 45.286354, 31.414104, 44.882553, 29.843336);
        ((GeneralPath) shape).lineTo(44.85227, 29.713127);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);

        // _0_0_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(10.981036, 11.962093);
        ((GeneralPath) shape).lineTo(16.007055, 11.962093);
        ((GeneralPath) shape).lineTo(14.592842, 29.183918);
        ((GeneralPath) shape).lineTo(8.152609, 29.183918);
        ((GeneralPath) shape).lineTo(10.981036, 11.962093);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(12.513010025024414, 30.585786819458008), new Point2D.Double(12.513010025024414, 16.885591506958008), new float[]{0, 1}, new Color[]{new Color(0x677579), new Color(0x333333)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 0.587604f, -1.140279f, 9.808271f)));
        g.fill(shape);

        // _0_0_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(36.397034, 11.962093);
        ((GeneralPath) shape).lineTo(31.371016, 11.962093);
        ((GeneralPath) shape).lineTo(32.78523, 29.183918);
        ((GeneralPath) shape).lineTo(39.225464, 29.183918);
        ((GeneralPath) shape).lineTo(36.397034, 11.962093);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(12.513010025024414, 30.585786819458008), new Point2D.Double(12.513010025024414, 16.885591506958008), new float[]{0, 1}, new Color[]{new Color(0x677579), new Color(0x333333)}, NO_CYCLE, SRGB, new AffineTransform(-1, 0, 0, 0.587604f, 48.51835f, 9.808271f)));
        g.fill(shape);

        // _0_0_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(21.0, 12.02602);
        ((GeneralPath) shape).lineTo(26.026018, 12.02602);
        ((GeneralPath) shape).lineTo(26.963518, 29.0);
        ((GeneralPath) shape).lineTo(20.0625, 29.0);
        ((GeneralPath) shape).lineTo(21.0, 12.02602);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(12.513010025024414, 30.585786819458008), new Point2D.Double(12.513010025024414, 23.635591506958008), new float[]{0, 1}, new Color[]{new Color(0x677579), new Color(0x333333)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 10.999998f, -3.9739816f)));
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, -1, -2));

        // _0_0_8
        g.setComposite(AlphaComposite.getInstance(3, 0.3647059f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0873786f, 0, 0, 1.0873786f, -2.1462379f, -2.6541262f));

        // _0_0_8_0
        shape = new RoundRectangle2D.Double(18.125, 28.625, 12.875, 3.5, 3.5, 3.5);
        g.setPaint(BLACK);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_8_0
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_8_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(28.0625, 23.0);
        ((GeneralPath) shape).lineTo(20.5, 23.09375);
        ((GeneralPath) shape).lineTo(20.125, 23.71875);
        ((GeneralPath) shape).lineTo(18.875, 30.9375);
        ((GeneralPath) shape).lineTo(18.90625, 31.0);
        ((GeneralPath) shape).lineTo(30.0625, 31.0);
        ((GeneralPath) shape).lineTo(28.65625, 24.75);
        ((GeneralPath) shape).lineTo(28.0625, 23.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xBABDB6));
        g.fill(shape);
        g.setPaint(new Color(0x555753));
        g.setStroke(new BasicStroke(1, 0, 0, 4));
        g.draw(shape);

        // _0_0_8_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(18.915106, 30.985245);
        ((GeneralPath) shape).lineTo(30.052038, 30.985245);
        ((GeneralPath) shape).lineTo(28.637825, 24.930641);
        ((GeneralPath) shape).lineTo(20.152542, 25.01903);
        ((GeneralPath) shape).lineTo(18.915106, 30.985245);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xBABDB6));
        g.fill(shape);

        // _0_0_8_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(20.513865, 23.088388);
        ((GeneralPath) shape).lineTo(20.071737, 25.024391);
        ((GeneralPath) shape).lineTo(28.624882, 25.042698);
        ((GeneralPath) shape).lineTo(28.0633, 22.986097);
        ((GeneralPath) shape).lineTo(20.513865, 23.088388);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xEEEEEC));
        g.fill(shape);

        // _0_0_8_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(20.461903, 23.11868);
        ((GeneralPath) shape).lineTo(20.135769, 23.716759);
        ((GeneralPath) shape).lineTo(18.870913, 30.94105);
        ((GeneralPath) shape).lineTo(19.939156, 26.005165);
        ((GeneralPath) shape).lineTo(28.895407, 26.010527);
        ((GeneralPath) shape).lineTo(28.687382, 24.99092);
        ((GeneralPath) shape).lineTo(20.178432, 24.967253);
        ((GeneralPath) shape).lineTo(20.461903, 23.11868);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_8
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9642857f, 0, 0, 0.9642857f, -10.391072f, -11.813167f));

        // _0_0_9
        g.setComposite(AlphaComposite.getInstance(3, 0.3647059f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0873786f, 0, 0, 1.0873786f, -2.1462379f, -2.6541262f));

        // _0_0_9_0
        shape = new RoundRectangle2D.Double(18.125, 28.625, 12.875, 3.5, 3.5, 3.5);
        g.setPaint(BLACK);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_9_0
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_9_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(28.0625, 23.1875);
        ((GeneralPath) shape).lineTo(20.5, 23.09375);
        ((GeneralPath) shape).lineTo(20.125, 23.71875);
        ((GeneralPath) shape).lineTo(18.875, 30.9375);
        ((GeneralPath) shape).lineTo(18.90625, 31.0);
        ((GeneralPath) shape).lineTo(30.0625, 31.0);
        ((GeneralPath) shape).lineTo(28.65625, 24.75);
        ((GeneralPath) shape).lineTo(28.0625, 23.1875);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xBABDB6));
        g.fill(shape);
        g.setPaint(new Color(0x555753));
        g.setStroke(new BasicStroke(1.037037f, 0, 0, 4));
        g.draw(shape);

        // _0_0_9_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(18.915106, 30.985245);
        ((GeneralPath) shape).lineTo(30.052038, 30.985245);
        ((GeneralPath) shape).lineTo(28.637825, 24.930641);
        ((GeneralPath) shape).lineTo(20.152542, 25.01903);
        ((GeneralPath) shape).lineTo(18.915106, 30.985245);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xBABDB6));
        g.fill(shape);

        // _0_0_9_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(20.513865, 23.088388);
        ((GeneralPath) shape).lineTo(20.071737, 25.024391);
        ((GeneralPath) shape).lineTo(28.624882, 25.042698);
        ((GeneralPath) shape).lineTo(28.0633, 23.173597);
        ((GeneralPath) shape).lineTo(20.513865, 23.088388);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xEEEEEC));
        g.fill(shape);

        // _0_0_9_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(20.461903, 23.11868);
        ((GeneralPath) shape).lineTo(20.135769, 23.716759);
        ((GeneralPath) shape).lineTo(18.870913, 30.94105);
        ((GeneralPath) shape).lineTo(19.939156, 26.005165);
        ((GeneralPath) shape).lineTo(28.895407, 26.010527);
        ((GeneralPath) shape).lineTo(28.687382, 24.99092);
        ((GeneralPath) shape).lineTo(20.178432, 24.967253);
        ((GeneralPath) shape).lineTo(20.461903, 23.11868);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_9
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 11.25f, -4.9375f));

        // _0_0_10
        g.setComposite(AlphaComposite.getInstance(3, 0.3647059f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0873786f, 0, 0, 1.0873786f, -2.1462379f, -2.6541262f));

        // _0_0_10_0
        shape = new RoundRectangle2D.Double(18.125, 28.625, 12.875, 3.5, 3.5, 3.5);
        g.setPaint(BLACK);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_10_0
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_10_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(28.0625, 23.0);
        ((GeneralPath) shape).lineTo(20.5, 23.09375);
        ((GeneralPath) shape).lineTo(20.125, 23.71875);
        ((GeneralPath) shape).lineTo(18.875, 30.9375);
        ((GeneralPath) shape).lineTo(18.90625, 31.0);
        ((GeneralPath) shape).lineTo(30.0625, 31.0);
        ((GeneralPath) shape).lineTo(28.65625, 24.75);
        ((GeneralPath) shape).lineTo(28.0625, 23.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xBABDB6));
        g.fill(shape);
        g.setPaint(new Color(0x555753));
        g.setStroke(new BasicStroke(1, 0, 0, 4));
        g.draw(shape);

        // _0_0_10_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(18.915106, 30.985245);
        ((GeneralPath) shape).lineTo(30.052038, 30.985245);
        ((GeneralPath) shape).lineTo(28.637825, 24.930641);
        ((GeneralPath) shape).lineTo(20.152542, 25.01903);
        ((GeneralPath) shape).lineTo(18.915106, 30.985245);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xBABDB6));
        g.fill(shape);

        // _0_0_10_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(20.513865, 23.088388);
        ((GeneralPath) shape).lineTo(20.071737, 25.024391);
        ((GeneralPath) shape).lineTo(28.624882, 25.042698);
        ((GeneralPath) shape).lineTo(28.0633, 22.986097);
        ((GeneralPath) shape).lineTo(20.513865, 23.088388);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xEEEEEC));
        g.fill(shape);

        // _0_0_10_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(20.461903, 23.11868);
        ((GeneralPath) shape).lineTo(20.135769, 23.716759);
        ((GeneralPath) shape).lineTo(18.870913, 30.94105);
        ((GeneralPath) shape).lineTo(19.939156, 26.005165);
        ((GeneralPath) shape).lineTo(28.895407, 26.010527);
        ((GeneralPath) shape).lineTo(28.687382, 24.99092);
        ((GeneralPath) shape).lineTo(20.178432, 24.967253);
        ((GeneralPath) shape).lineTo(20.461903, 23.11868);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_10

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
        return 8;
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
        return 36;
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
    public PreferencesDesktop2() {
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

