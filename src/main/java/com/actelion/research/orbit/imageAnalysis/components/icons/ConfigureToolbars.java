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
public class ConfigureToolbars implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.setComposite(AlphaComposite.getInstance(3, 0.4f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1.0035841f, -79.56615f, -202.12619f));

        // _0_0_0
        shape = new RoundRectangle2D.Double(81.62864685058594, 232.0541534423828, 124, 39.356788635253906, 4.286706447601318, 5.060499668121338);
        g.setPaint(BLACK);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_1
        shape = new RoundRectangle2D.Double(4.0625, 31.9642333984375, 119.9999771118164, 36.05894088745117, 4.1484246253967285, 4.897256851196289);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(399.774658203125, 727.0794067382812), new Point2D.Double(399.774658203125, 480.6021423339844), new float[]{0, 0.5f, 1}, new Color[]{new Color(0xCBCBCD), new Color(0xE0E0E2), new Color(0xF2F2F2)}, NO_CYCLE, SRGB, new AffineTransform(0.121457f, 0, 0, 0.1756605f, -3.8202198f, -56.522224f)));
        g.fill(shape);

        // _0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(6.125, 32.00757);
        ((GeneralPath) shape).curveTo(4.97589, 32.00757, 4.0625, 33.088528, 4.0625, 34.44506);
        ((GeneralPath) shape).lineTo(4.0625, 65.57004);
        ((GeneralPath) shape).curveTo(4.0625, 66.92659, 4.97589, 68.00754, 6.125, 68.00754);
        ((GeneralPath) shape).lineTo(122.0, 68.00754);
        ((GeneralPath) shape).curveTo(123.14913, 68.00754, 124.0625, 66.92659, 124.0625, 65.57004);
        ((GeneralPath) shape).lineTo(124.0625, 34.44506);
        ((GeneralPath) shape).curveTo(124.0625, 33.088528, 123.14913, 32.00757, 122.0, 32.00757);
        ((GeneralPath) shape).lineTo(6.125, 32.00757);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(7.53125, 35.66382);
        ((GeneralPath) shape).lineTo(120.59375, 35.66382);
        ((GeneralPath) shape).curveTo(121.68541, 35.66382, 122.5625, 36.687878, 122.5625, 37.960697);
        ((GeneralPath) shape).lineTo(122.5625, 64.21067);
        ((GeneralPath) shape).curveTo(122.5625, 65.48347, 121.68541, 66.50754, 120.59375, 66.50754);
        ((GeneralPath) shape).lineTo(7.53125, 66.50754);
        ((GeneralPath) shape).curveTo(6.43959, 66.50754, 5.5625, 65.48347, 5.5625, 64.21067);
        ((GeneralPath) shape).lineTo(5.5625, 37.960697);
        ((GeneralPath) shape).curveTo(5.5625, 36.687878, 6.43959, 35.66382, 7.53125, 35.66382);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(-333.0289001464844, -1473.650390625), new Point2D.Double(-333.0289001464844, -1301.721435546875), new float[]{0, 0.49140647f, 1}, new Color[]{WHITE, WHITE, new Color(0xDCDCDC)}, NO_CYCLE, SRGB, new AffineTransform(0.121457f, 0, 0, 0.1756605f, 115.62276f, 298.79187f)));
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9796636f, 0, 0, 0.9796636f, -140.54507f, -199.63301f));

        // _0_0_3
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.7904687f, 0, 0, 0.7904687f, -678.5531f, 631.1985f));

        // _0_0_3_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1060.3605, -478.60516);
        ((GeneralPath) shape).curveTo(1060.3605, -475.81042, 1058.0948, -473.54486, 1055.3002, -473.54486);
        ((GeneralPath) shape).curveTo(1052.5055, -473.54486, 1050.2399, -475.81042, 1050.2399, -478.60516);
        ((GeneralPath) shape).curveTo(1050.2399, -481.3999, 1052.5055, -483.66547, 1055.3002, -483.66547);
        ((GeneralPath) shape).curveTo(1058.0948, -483.66547, 1060.3605, -481.3999, 1060.3605, -478.60516);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(1052.916015625, -481.748046875), new Point2D.Double(1055.84228515625, -476.6795349121094), new float[]{0, 1}, new Color[]{new Color(0x6F6F6F), WHITE}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_3_0

        g.setTransform(transformations.poll()); // _0_0_3
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 94.6653f, -29.75048f));

        // _0_0_4

        g.setTransform(transformations.poll()); // _0_0_4
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 94.6653f, -29.75048f));

        // _0_0_5

        g.setTransform(transformations.poll()); // _0_0_5
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_6

        // _0_0_7
        g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.782995f, 0, 0, 0.650879f, -2508.727f, 494.4908f));

        // _0_0_8

        g.setTransform(transformations.poll()); // _0_0_8
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.782995f, 0, 0, 0.650879f, -2508.727f, 494.4908f));

        // _0_0_9

        g.setTransform(transformations.poll()); // _0_0_9
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 0.650879f, 692.2361f, 501.8186f));

        // _0_0_10

        g.setTransform(transformations.poll()); // _0_0_10
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 0.650879f, 692.2361f, 501.8186f));

        // _0_0_11

        g.setTransform(transformations.poll()); // _0_0_11
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, -8.163744f, -161.86371f));

        // _0_0_12

        g.setTransform(transformations.poll()); // _0_0_12
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, -8.163744f, -161.86371f));

        // _0_0_13

        g.setTransform(transformations.poll()); // _0_0_13
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_14

        // _0_0_15
        g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.782995f, 0, 0, 0.650879f, -2611.5557f, 362.3776f));

        // _0_0_16

        g.setTransform(transformations.poll()); // _0_0_16
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.782995f, 0, 0, 0.650879f, -2611.5557f, 362.3776f));

        // _0_0_17

        g.setTransform(transformations.poll()); // _0_0_17
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 0.650879f, 589.40704f, 369.70538f));

        // _0_0_18

        g.setTransform(transformations.poll()); // _0_0_18
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 0.650879f, 589.40704f, 369.70538f));

        // _0_0_19

        g.setTransform(transformations.poll()); // _0_0_19
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_20
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(103.1875, 31.96875);
        ((GeneralPath) shape).lineTo(90.96875, 32.0625);
        ((GeneralPath) shape).lineTo(88.15625, 42.3125);
        ((GeneralPath) shape).lineTo(84.625, 57.15625);
        ((GeneralPath) shape).lineTo(82.65625, 61.0);
        ((GeneralPath) shape).lineTo(75.15625, 68.03125);
        ((GeneralPath) shape).lineTo(104.125, 68.03125);
        ((GeneralPath) shape).lineTo(115.71875, 65.0);
        ((GeneralPath) shape).lineTo(122.96875, 57.6875);
        ((GeneralPath) shape).lineTo(124.0625, 54.78125);
        ((GeneralPath) shape).lineTo(124.0625, 45.4375);
        ((GeneralPath) shape).lineTo(115.375, 49.0);
        ((GeneralPath) shape).lineTo(108.65625, 45.6875);
        ((GeneralPath) shape).lineTo(105.3125, 41.0625);
        ((GeneralPath) shape).lineTo(105.46875, 34.53125);
        ((GeneralPath) shape).lineTo(115.03125, 31.96875);
        ((GeneralPath) shape).lineTo(103.1875, 31.96875);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x93000000, true));
        g.fill(shape);
        g.setPaint(BLACK);
        g.setStroke(new BasicStroke(1, 0, 0, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.3910891f * origAlpha));

        // _0_0_21
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(62.0625, 37.0);
        ((GeneralPath) shape).curveTo(60.913387, 37.0, 60.0, 38.08096, 60.0, 39.4375);
        ((GeneralPath) shape).lineTo(60.0, 61.5625);
        ((GeneralPath) shape).curveTo(60.0, 62.91904, 60.913387, 64.0, 62.0625, 64.0);
        ((GeneralPath) shape).lineTo(85.9375, 64.0);
        ((GeneralPath) shape).curveTo(87.08661, 64.0, 88.0, 62.91904, 88.0, 61.5625);
        ((GeneralPath) shape).lineTo(88.0, 39.4375);
        ((GeneralPath) shape).curveTo(88.0, 38.08096, 87.08661, 37.0, 85.9375, 37.0);
        ((GeneralPath) shape).lineTo(62.0625, 37.0);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(63.1875, 39.8125);
        ((GeneralPath) shape).lineTo(84.75, 39.8125);
        ((GeneralPath) shape).curveTo(85.89912, 39.8125, 86.8125, 40.89346, 86.8125, 42.25);
        ((GeneralPath) shape).lineTo(86.8125, 60.875);
        ((GeneralPath) shape).curveTo(86.8125, 62.23154, 85.89912, 63.3125, 84.75, 63.3125);
        ((GeneralPath) shape).lineTo(63.1875, 63.3125);
        ((GeneralPath) shape).curveTo(62.038387, 63.3125, 61.125, 62.23154, 61.125, 60.875);
        ((GeneralPath) shape).lineTo(61.125, 42.25);
        ((GeneralPath) shape).curveTo(61.125, 40.89346, 62.038387, 39.8125, 63.1875, 39.8125);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9407138f, 0, 0, 0.9407138f, -9.567127f, 27.278238f));

        // _0_0_22

        // _0_0_22_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(119.49126, -16.842312);
        ((GeneralPath) shape).curveTo(119.10365, -16.840841, 118.72728, -16.8316, 118.33501, -16.811062);
        ((GeneralPath) shape).curveTo(118.2939, -16.80891, 118.25105, -16.813421, 118.21001, -16.811062);
        ((GeneralPath) shape).curveTo(117.98133, -16.797928, 117.12633, -16.756144, 117.05376, -16.748562);
        ((GeneralPath) shape).curveTo(116.99077, -16.741983, 116.90096, -16.753454, 116.83501, -16.748562);
        ((GeneralPath) shape).curveTo(116.76382, -16.74047, 116.68718, -16.726028, 116.61626, -16.717312);
        ((GeneralPath) shape).curveTo(115.97521, -16.638536, 115.32769, -16.532988, 114.71001, -16.404812);
        ((GeneralPath) shape).curveTo(106.9427, -14.97264, 101.04409, -9.768083, 99.86626, -3.498562);
        ((GeneralPath) shape).curveTo(99.814674, -3.233109, 99.77565, -2.955104, 99.74126, -2.686062);
        ((GeneralPath) shape).curveTo(99.71989, -2.509256, 99.69256, -2.333027, 99.67876, -2.154812);
        ((GeneralPath) shape).curveTo(99.67365, -2.122237, 99.65233, -2.062429, 99.64751, -2.029812);
        ((GeneralPath) shape).curveTo(99.64751, -2.029812, 96.266174, 18.679705, 92.27251, 24.251438);
        ((GeneralPath) shape).curveTo(92.17455, 24.388096, 92.0404, 24.583061, 91.83501, 24.813938);
        ((GeneralPath) shape).curveTo(90.39485, 26.322424, 87.12168, 29.486013, 83.05376, 33.40769);
        ((GeneralPath) shape).curveTo(67.1671, 48.49616, 35.870907, 77.175026, 28.147507, 85.40769);
        ((GeneralPath) shape).curveTo(28.057117, 85.492516, 27.085007, 86.40769, 27.085007, 86.40769);
        ((GeneralPath) shape).lineTo(27.491257, 86.12644);
        ((GeneralPath) shape).curveTo(26.961508, 86.71329, 26.562017, 87.1688, 26.397507, 87.43894);
        ((GeneralPath) shape).curveTo(25.652187, 88.66284, 25.172306, 89.94837, 24.928757, 91.25144);
        ((GeneralPath) shape).curveTo(24.924917, 91.27143, 24.932487, 91.29394, 24.928757, 91.31394);
        ((GeneralPath) shape).curveTo(24.873478, 91.61914, 24.833757, 91.91421, 24.803757, 92.22019);
        ((GeneralPath) shape).curveTo(24.800568, 92.25035, 24.806707, 92.283775, 24.803757, 92.31394);
        ((GeneralPath) shape).curveTo(24.776167, 92.62068, 24.744347, 92.94536, 24.741257, 93.25144);
        ((GeneralPath) shape).curveTo(24.741096, 93.26192, 24.741386, 93.27221, 24.741257, 93.28269);
        ((GeneralPath) shape).curveTo(24.738997, 93.58765, 24.751287, 93.88599, 24.772507, 94.18894);
        ((GeneralPath) shape).curveTo(24.773867, 94.209816, 24.771036, 94.23057, 24.772507, 94.25144);
        ((GeneralPath) shape).curveTo(24.795317, 94.55438, 24.820827, 94.85817, 24.866257, 95.15769);
        ((GeneralPath) shape).curveTo(24.869267, 95.17816, 24.863148, 95.19974, 24.866257, 95.22019);
        ((GeneralPath) shape).curveTo(24.913197, 95.51937, 24.985077, 95.80083, 25.053757, 96.09519);
        ((GeneralPath) shape).curveTo(25.104946, 96.32147, 25.177637, 96.5286, 25.241257, 96.75144);
        ((GeneralPath) shape).curveTo(25.268038, 96.84333, 25.274906, 96.94147, 25.303757, 97.03269);
        ((GeneralPath) shape).curveTo(25.310717, 97.05508, 25.327927, 97.07284, 25.335007, 97.09519);
        ((GeneralPath) shape).curveTo(25.352177, 97.14847, 25.379637, 97.19841, 25.397507, 97.25144);
        ((GeneralPath) shape).curveTo(25.571367, 97.77638, 25.751757, 98.31689, 25.991257, 98.81394);
        ((GeneralPath) shape).curveTo(26.001118, 98.83415, 26.012537, 98.85628, 26.022507, 98.87644);
        ((GeneralPath) shape).curveTo(28.035967, 102.99785, 32.238346, 105.99072, 37.147507, 105.56394);
        ((GeneralPath) shape).curveTo(37.409607, 105.54652, 37.693855, 105.50752, 37.960007, 105.47019);
        ((GeneralPath) shape).curveTo(37.969875, 105.46858, 37.981388, 105.47183, 37.991257, 105.47019);
        ((GeneralPath) shape).curveTo(38.063175, 105.4599, 38.137806, 105.45072, 38.210007, 105.43894);
        ((GeneralPath) shape).curveTo(39.338387, 105.25488, 40.501526, 104.85862, 41.678757, 104.28269);
        ((GeneralPath) shape).curveTo(42.406757, 103.94393, 43.128956, 103.53719, 43.866257, 103.03269);
        ((GeneralPath) shape).curveTo(51.643517, 97.71102, 98.617805, 39.040337, 104.96001, 34.93894);
        ((GeneralPath) shape).curveTo(105.09571, 34.851185, 105.28955, 34.749187, 105.46001, 34.65769);
        ((GeneralPath) shape).curveTo(112.80601, 31.44714, 119.86066, 31.00996, 127.24126, 28.470188);
        ((GeneralPath) shape).curveTo(129.63016, 27.923807, 131.24126, 27.563938, 131.24126, 27.563938);
        ((GeneralPath) shape).curveTo(131.24634, 27.565079, 131.2678, 27.563395, 131.2725, 27.563938);
        ((GeneralPath) shape).curveTo(131.27687, 27.563889, 131.29976, 27.564573, 131.30376, 27.563938);
        ((GeneralPath) shape).curveTo(131.30705, 27.562138, 131.33208, 27.535065, 131.335, 27.532688);
        ((GeneralPath) shape).curveTo(131.33691, 27.528606, 131.36469, 27.506077, 131.36626, 27.501438);
        ((GeneralPath) shape).curveTo(131.3675, 27.496244, 131.36537, 27.475937, 131.36626, 27.470188);
        ((GeneralPath) shape).curveTo(131.36676, 27.464521, 131.36768, 27.448278, 131.36626, 27.438938);
        ((GeneralPath) shape).curveTo(131.36975, 27.438192, 131.49126, 27.407688, 131.49126, 27.407688);
        ((GeneralPath) shape).curveTo(131.65358, 27.444149, 131.63052, 27.20019, 131.46, 26.688938);
        ((GeneralPath) shape).curveTo(135.74902, 24.463318, 141.28069, 18.415287, 143.36626, 9.657688);
        ((GeneralPath) shape).curveTo(143.46727, 9.233569, 143.17181, 6.308899, 143.05376, 6.126438);
        ((GeneralPath) shape).curveTo(143.0684, 6.062298, 143.10185, 6.003224, 143.11626, 5.938938);
        ((GeneralPath) shape).lineTo(129.80376, 12.220188);
        ((GeneralPath) shape).lineTo(121.58501, 6.751438);
        ((GeneralPath) shape).curveTo(120.69769, 5.01263, 119.87348, 3.431939, 119.36626, 2.345188);
        ((GeneralPath) shape).curveTo(119.3663, -1.782678, 119.36297, -2.13287, 119.74126, -5.873562);
        ((GeneralPath) shape).curveTo(124.81593, -7.871324, 133.7725, -11.311062, 133.7725, -11.311062);
        ((GeneralPath) shape).curveTo(133.76205, -11.321144, 133.75175, -11.332253, 133.74126, -11.342312);
        ((GeneralPath) shape).curveTo(133.75388, -11.34713, 134.0225, -11.436062, 134.0225, -11.436062);
        ((GeneralPath) shape).curveTo(130.55539, -14.776197, 125.30536, -16.864365, 119.49126, -16.842312);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(36.647507, 86.00144);
        ((GeneralPath) shape).curveTo(39.104248, 85.9432, 41.485016, 87.56161, 42.803757, 89.90769);
        ((GeneralPath) shape).curveTo(42.912838, 90.10654, 43.022945, 90.29287, 43.116257, 90.50144);
        ((GeneralPath) shape).curveTo(43.126167, 90.52301, 43.137775, 90.54227, 43.147507, 90.56394);
        ((GeneralPath) shape).curveTo(43.2396, 90.774376, 43.32264, 91.00118, 43.397507, 91.22019);
        ((GeneralPath) shape).curveTo(43.405117, 91.241776, 43.42132, 91.26102, 43.428757, 91.28269);
        ((GeneralPath) shape).curveTo(43.549885, 91.64708, 43.640907, 92.0242, 43.710007, 92.40769);
        ((GeneralPath) shape).curveTo(43.741776, 92.57428, 43.751328, 92.73804, 43.772507, 92.90769);
        ((GeneralPath) shape).curveTo(43.79545, 93.10461, 43.826958, 93.301186, 43.835007, 93.50144);
        ((GeneralPath) shape).curveTo(43.96204, 96.66186, 41.096207, 99.93722, 37.835007, 100.65769);
        ((GeneralPath) shape).curveTo(37.670437, 100.68016, 37.500607, 100.68027, 37.335007, 100.68894);
        ((GeneralPath) shape).curveTo(33.682587, 100.88016, 29.969658, 97.22375, 29.741257, 93.40769);
        ((GeneralPath) shape).curveTo(29.583897, 90.77856, 31.006067, 88.14692, 33.522507, 86.78269);
        ((GeneralPath) shape).curveTo(34.13368, 86.48232, 34.828148, 86.23355, 35.553757, 86.09519);
        ((GeneralPath) shape).curveTo(35.614388, 86.08666, 35.679676, 86.10197, 35.741257, 86.09519);
        ((GeneralPath) shape).curveTo(36.036438, 86.049995, 36.336437, 86.01829, 36.647507, 86.00144);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(154.17799377441406, 33.30924606323242), 11.547417f, new Point2D.Double(154.17799377441406, 33.30924606323242), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(0.9702732f, -0.062911786f, 0.064304456f, 0.8808136f, -31.009554f, -1.065148f)));
        g.setStroke(new BasicStroke(1.5781032f, 1, 1, 4));
        g.draw(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9702732f, -0.062911786f, 0.06900478f, 0.9451966f, -33.759445f, 6.771224f));

        // _0_0_22_1

        // _0_0_22_1_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(181.67604, 9.099418);
        ((GeneralPath) shape).lineTo(167.54391, 14.798884);
        ((GeneralPath) shape).lineTo(159.38892, 8.405838);
        ((GeneralPath) shape).curveTo(158.31752, 9.823263, 157.50262, 30.099195, 162.49084, 29.926445);
        ((GeneralPath) shape).curveTo(171.6228, 29.610191, 178.29659, 20.600702, 181.67604, 9.099418);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x888A85));
        g.fill(shape);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(154.17799377441406, 33.30924606323242), 11.547417f, new Point2D.Double(154.17799377441406, 33.30924606323242), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 0.931884f, 3.581214f, -10.16833f)));
        g.setStroke(new BasicStroke(1.644f, 1, 1, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.51376146f * origAlpha));

        // _0_0_22_1_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(181.16095, 9.759779);
        ((GeneralPath) shape).lineTo(167.7547, 15.166029);
        ((GeneralPath) shape).lineTo(166.91095, 24.603529);
        ((GeneralPath) shape).lineTo(168.4422, 28.759779);
        ((GeneralPath) shape).curveTo(174.28842, 25.536423, 178.63786, 18.346592, 181.16095, 9.759779);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(173.35292053222656, 29.473955154418945), 7.125f, new Point2D.Double(173.35292053222656, 29.473955154418945), new float[]{0, 1}, new Color[]{WHITE, new Color(0x3E3E3E, true)}, NO_CYCLE, SRGB, new AffineTransform(5.093182f, 0.03710751f, -0.03342812f, 4.588167f, -711.6483f, -118.8231f)));
        g.fill(shape);

        // _0_0_22_1_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(159.31602, 8.597299);
        ((GeneralPath) shape).curveTo(159.31184, 8.602836, 159.28896, 8.622438, 159.28477, 8.628549);
        ((GeneralPath) shape).curveTo(159.27644, 8.641906, 159.26183, 8.675446, 159.25352, 8.691049);
        ((GeneralPath) shape).curveTo(158.21497, 10.788359, 157.51898, 30.297924, 162.40977, 30.128548);
        ((GeneralPath) shape).curveTo(163.49063, 30.091118, 164.55544, 29.930513, 165.56602, 29.659798);
        ((GeneralPath) shape).lineTo(166.25352, 14.066048);
        ((GeneralPath) shape).lineTo(159.31602, 8.597299);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(150.17820739746094, 56.316688537597656), 4.6959705f, new Point2D.Double(150.17820739746094, 56.316688537597656), new float[]{0, 1}, new Color[]{WHITE, new Color(0x3E3E3E, true)}, NO_CYCLE, SRGB, new AffineTransform(7.899763f, -0.133352f, 0.10295f, 6.09874f, -1031.154f, -297.761f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_22_1
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_22_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(116.11137, -18.623878);
        ((GeneralPath) shape).curveTo(107.10469, -17.517088, 100.25764, -11.395721, 99.6973, -4.161585);
        ((GeneralPath) shape).curveTo(99.69221, -4.12901, 99.67685, -4.05952, 99.67202, -4.026903);
        ((GeneralPath) shape).curveTo(99.67202, -4.026903, 96.299225, 16.69257, 92.30556, 22.264303);
        ((GeneralPath) shape).curveTo(89.17107, 26.63734, 29.248901, 80.80223, 26.425835, 85.437996);
        ((GeneralPath) shape).curveTo(20.463238, 95.22919, 31.58269, 109.19188, 43.37947, 101.11982);
        ((GeneralPath) shape).curveTo(51.15673, 95.79814, 98.1143, 37.144085, 104.4565, 33.042686);
        ((GeneralPath) shape).curveTo(108.74341, 30.270405, 131.01147, 25.523773, 131.01147, 25.523773);
        ((GeneralPath) shape).curveTo(132.31, 25.815464, 121.73279, 6.53296, 118.88664, 0.434905);
        ((GeneralPath) shape).curveTo(118.88668, -3.707017, 118.87766, -4.043026, 119.25989, -7.819724);
        ((GeneralPath) shape).curveTo(124.28718, -9.801497, 133.54074, -13.335111, 133.54074, -13.335111);
        ((GeneralPath) shape).curveTo(129.84248, -16.897923, 124.11688, -19.043024, 117.84057, -18.714413);
        ((GeneralPath) shape).curveTo(117.79946, -18.712261, 117.74862, -18.709808, 117.70758, -18.70745);
        ((GeneralPath) shape).curveTo(117.4789, -18.694317, 116.6495, -18.655834, 116.57692, -18.648254);
        ((GeneralPath) shape).curveTo(116.51393, -18.641676, 116.4101, -18.640959, 116.34414, -18.636065);
        ((GeneralPath) shape).curveTo(116.27296, -18.627974, 116.18229, -18.632593, 116.11137, -18.623878);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(36.49699, 83.93111);
        ((GeneralPath) shape).curveTo(40.14945, 83.739876, 43.682796, 87.28653, 43.85191, 91.49378);
        ((GeneralPath) shape).curveTo(43.991814, 94.97444, 40.51111, 98.60351, 36.85866, 98.79474);
        ((GeneralPath) shape).curveTo(33.20623, 98.98597, 29.484098, 95.31434, 29.255695, 91.49829);
        ((GeneralPath) shape).curveTo(29.03622, 87.831276, 31.880796, 84.1728, 36.49699, 83.93111);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x888A85));
        g.fill(shape);

        // _0_0_22_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(116.6244, -18.724503);
        ((GeneralPath) shape).curveTo(107.61773, -17.617716, 100.77068, -11.496347, 100.21034, -4.262212);
        ((GeneralPath) shape).curveTo(100.20524, -4.229637, 100.18988, -4.160146, 100.18506, -4.127529);
        ((GeneralPath) shape).curveTo(100.18506, -4.127529, 96.81226, 16.591944, 92.818596, 22.163677);
        ((GeneralPath) shape).curveTo(89.6841, 26.536715, 29.761944, 80.7016, 26.938873, 85.33737);
        ((GeneralPath) shape).curveTo(20.976274, 95.12855, 32.095726, 109.09124, 43.892506, 101.01918);
        ((GeneralPath) shape).curveTo(51.66976, 95.69751, 98.62734, 37.043457, 104.96954, 32.94206);
        ((GeneralPath) shape).curveTo(109.25644, 30.169777, 131.5245, 25.423147, 131.5245, 25.423147);
        ((GeneralPath) shape).curveTo(132.82301, 25.714838, 122.24582, 6.432335, 119.39967, 0.33428);
        ((GeneralPath) shape).curveTo(119.39971, -3.807642, 119.39069, -4.143652, 119.77292, -7.920349);
        ((GeneralPath) shape).curveTo(124.80021, -9.902122, 134.05377, -13.435737, 134.05377, -13.435737);
        ((GeneralPath) shape).curveTo(130.35551, -16.998547, 124.62991, -19.143648, 118.3536, -18.815039);
        ((GeneralPath) shape).curveTo(118.31249, -18.812887, 118.26165, -18.810434, 118.22061, -18.808075);
        ((GeneralPath) shape).curveTo(117.99193, -18.79494, 117.16253, -18.75646, 117.08995, -18.748878);
        ((GeneralPath) shape).curveTo(117.02696, -18.7423, 116.92313, -18.741585, 116.85717, -18.73669);
        ((GeneralPath) shape).curveTo(116.78599, -18.7286, 116.69532, -18.73322, 116.6244, -18.724503);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(37.010025, 83.83049);
        ((GeneralPath) shape).curveTo(40.66248, 83.63926, 44.195843, 87.18589, 44.364944, 91.39314);
        ((GeneralPath) shape).curveTo(44.504852, 94.8738, 41.024147, 98.50287, 37.371693, 98.69411);
        ((GeneralPath) shape).curveTo(33.719265, 98.88533, 29.99713, 95.21371, 29.768732, 91.39765);
        ((GeneralPath) shape).curveTo(29.549257, 87.73065, 32.39384, 84.07218, 37.010025, 83.83049);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(78.34490203857422, 47.89650344848633), 59.06985f, new Point2D.Double(78.34490203857422, 47.89650344848633), new float[]{0, 1}, new Color[]{WHITE, new Color(0x888A85, true)}, NO_CYCLE, SRGB, new AffineTransform(1.0280267f, -0.1270725f, 0.1309176f, 0.9349125f, 9.22483f, -4.675167f)));
        g.fill(shape);

        // _0_0_22_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(101.72707, -3.559096);
        ((GeneralPath) shape).lineTo(109.2038, 12.685246);
        ((GeneralPath) shape).lineTo(112.38771, 11.328075);
        ((GeneralPath) shape).lineTo(117.6703, 23.15758);
        ((GeneralPath) shape).lineTo(115.05185, 24.400543);
        ((GeneralPath) shape).lineTo(118.65027, 29.101671);
        ((GeneralPath) shape).curveTo(124.59426, 27.611395, 131.00542, 25.066742, 131.00542, 25.066742);
        ((GeneralPath) shape).curveTo(131.01009, 25.06729, 131.03352, 25.0651, 131.03784, 25.065056);
        ((GeneralPath) shape).curveTo(131.04181, 25.064423, 131.06664, 25.064589, 131.07027, 25.063372);
        ((GeneralPath) shape).curveTo(131.07285, 25.060427, 131.09862, 25.034468, 131.10085, 25.030954);
        ((GeneralPath) shape).curveTo(131.1024, 25.02632, 131.09778, 25.005417, 131.09898, 25.000225);
        ((GeneralPath) shape).curveTo(131.10075, 24.988731, 131.12727, 24.95076, 131.12772, 24.937078);
        ((GeneralPath) shape).curveTo(131.1022, 23.158255, 121.59062, 5.72749, 118.92109, -0.014474);
        ((GeneralPath) shape).curveTo(118.91809, -4.156021, 118.92468, -4.488861, 119.30212, -8.264967);
        ((GeneralPath) shape).curveTo(124.30153, -10.243293, 133.5312, -13.372962, 133.5312, -13.372962);
        ((GeneralPath) shape).curveTo(129.84975, -16.93785, 122.2903, -18.49241, 116.65361, -17.446571);
        ((GeneralPath) shape).curveTo(107.80001, -15.803859, 102.54371, -10.513387, 101.72707, -3.559096);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(222.09877014160156, 1.2351387739181519), 16.390625f, new Point2D.Double(222.09877014160156, 1.2351387739181519), new float[]{0, 1}, new Color[]{WHITE, new Color(0x888A85, true)}, NO_CYCLE, SRGB, new AffineTransform(2.3781044f, -0.3075006f, 1.0402511f, 6.867777f, -416.31964f, 88.18815f)));
        g.fill(shape);

        // _0_0_22_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(115.08391, -18.409351);
        ((GeneralPath) shape).curveTo(106.59725, -16.975058, 100.24276, -11.027059, 99.70433, -4.075509);
        ((GeneralPath) shape).curveTo(99.699234, -4.042937, 99.69376, -3.984633, 99.68894, -3.952015);
        ((GeneralPath) shape).curveTo(99.68893, -3.952012, 96.317955, 16.768951, 92.32427, 22.340685);
        ((GeneralPath) shape).curveTo(89.18979, 26.713722, 29.249104, 80.87094, 26.426025, 85.50671);
        ((GeneralPath) shape).curveTo(20.463428, 95.29789, 31.597925, 109.26415, 43.3947, 101.1921);
        ((GeneralPath) shape).curveTo(51.171963, 95.87042, 98.14554, 37.21939, 104.48774, 33.11799);
        ((GeneralPath) shape).curveTo(108.77463, 30.34571, 131.01614, 25.583134, 131.01614, 25.583134);
        ((GeneralPath) shape).curveTo(131.02122, 25.584272, 131.04774, 25.6085, 131.05246, 25.609043);
        ((GeneralPath) shape).curveTo(131.05682, 25.608995, 131.0806, 25.605707, 131.0846, 25.605074);
        ((GeneralPath) shape).curveTo(131.08788, 25.603273, 131.10959, 25.573595, 131.11253, 25.57122);
        ((GeneralPath) shape).curveTo(131.11444, 25.567142, 131.1389, 25.542007, 131.14047, 25.537369);
        ((GeneralPath) shape).curveTo(131.1417, 25.532173, 131.1354, 25.513235, 131.13629, 25.507488);
        ((GeneralPath) shape).curveTo(131.13795, 25.4886, 131.12502, 25.4416, 131.12373, 25.417847);
        ((GeneralPath) shape).curveTo(130.94423, 23.39797, 121.56715, 6.204769, 118.91, 0.511663);
        ((GeneralPath) shape).curveTo(118.91003, -3.630258, 118.90794, -3.966102, 119.29017, -7.7428);
        ((GeneralPath) shape).curveTo(124.31746, -9.72457, 133.5492, -13.274691, 133.5492, -13.274691);
        ((GeneralPath) shape).curveTo(129.85094, -16.837503, 124.13977, -18.959946, 117.86347, -18.631334);
        ((GeneralPath) shape).curveTo(117.82236, -18.629185, 117.77182, -18.647692, 117.73078, -18.645332);
        ((GeneralPath) shape).curveTo(117.5021, -18.632196, 116.67058, -18.573689, 116.598, -18.566109);
        ((GeneralPath) shape).curveTo(116.535, -18.55953, 116.43489, -18.573086, 116.36894, -18.568192);
        ((GeneralPath) shape).curveTo(116.30665, -18.561111, 116.20989, -18.54546, 116.14406, -18.540396);
        ((GeneralPath) shape).curveTo(115.79223, -18.49716, 115.42889, -18.467655, 115.08391, -18.409351);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(116.43993, -17.361046);
        ((GeneralPath) shape).curveTo(122.0447, -18.323017, 129.3848, -17.142647, 133.00873, -13.633458);
        ((GeneralPath) shape).curveTo(133.00873, -13.633458, 123.8455, -10.091808, 118.84608, -8.113479);
        ((GeneralPath) shape).curveTo(118.46864, -4.337373, 118.46291, -4.000563, 118.46591, 0.140984);
        ((GeneralPath) shape).curveTo(121.11459, 5.838089, 130.47614, 23.045216, 130.64752, 25.051138);
        ((GeneralPath) shape).curveTo(130.6479, 25.058561, 130.65161, 25.074068, 130.6517, 25.081018);
        ((GeneralPath) shape).curveTo(130.64655, 25.092344, 130.63342, 25.13397, 130.62794, 25.14475);
        ((GeneralPath) shape).curveTo(130.62819, 25.147512, 130.63173, 25.171404, 130.63213, 25.174631);
        ((GeneralPath) shape).curveTo(130.62509, 25.181929, 130.60548, 25.207012, 130.60419, 25.208485);
        ((GeneralPath) shape).curveTo(130.59703, 25.208673, 130.57405, 25.212137, 130.57207, 25.212454);
        ((GeneralPath) shape).curveTo(130.56857, 25.212696, 130.54286, 25.216297, 130.53995, 25.216427);
        ((GeneralPath) shape).curveTo(130.53995, 25.216427, 123.43085, 26.433945, 117.48685, 27.924225);
        ((GeneralPath) shape).lineTo(115.70523, 25.338558);
        ((GeneralPath) shape).lineTo(119.20264, 23.043383);
        ((GeneralPath) shape).lineTo(112.80792, 10.650339);
        ((GeneralPath) shape).lineTo(108.39574, 12.18168);
        ((GeneralPath) shape).lineTo(101.26715, -3.417541);
        ((GeneralPath) shape).curveTo(102.08378, -10.371831, 107.33352, -15.656686, 116.18711, -17.299397);
        ((GeneralPath) shape).curveTo(116.27518, -17.315739, 116.35097, -17.345776, 116.43993, -17.361046);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(35.351475, 84.12987);
        ((GeneralPath) shape).curveTo(35.72119, 84.0608, 36.11549, 84.03756, 36.512188, 84.0168);
        ((GeneralPath) shape).curveTo(40.164635, 83.82557, 43.706585, 87.350006, 43.8757, 91.55726);
        ((GeneralPath) shape).curveTo(44.015606, 95.03792, 40.512268, 98.67763, 36.85981, 98.868866);
        ((GeneralPath) shape).curveTo(33.20737, 99.0601, 29.496988, 95.38539, 29.268581, 91.56933);
        ((GeneralPath) shape).curveTo(29.067978, 88.21746, 31.419048, 84.86457, 35.351475, 84.12987);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(302.08856201171875, -10.284326553344727), 59.07331f, new Point2D.Double(302.08856201171875, -10.284326553344727), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(0.2857021f, -0.096936986f, 0.3403616f, 0.8738542f, 39.663002f, 55.64728f)));
        g.fill(shape);

        // _0_0_22_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(115.33183, -18.439997);
        ((GeneralPath) shape).curveTo(106.84519, -17.005705, 100.49069, -11.057706, 99.95226, -4.106155);
        ((GeneralPath) shape).curveTo(99.947174, -4.073584, 99.941696, -4.015279, 99.936874, -3.982662);
        ((GeneralPath) shape).curveTo(99.93687, -3.982658, 96.56589, 16.738304, 92.572205, 22.31004);
        ((GeneralPath) shape).curveTo(89.43772, 26.683077, 29.497028, 80.84029, 26.673952, 85.47607);
        ((GeneralPath) shape).curveTo(20.711351, 95.26724, 31.845856, 109.23349, 43.642628, 101.16144);
        ((GeneralPath) shape).curveTo(51.41989, 95.83976, 98.39347, 37.188744, 104.73567, 33.087345);
        ((GeneralPath) shape).curveTo(109.02257, 30.315063, 131.26408, 25.552488, 131.26408, 25.552488);
        ((GeneralPath) shape).curveTo(131.26917, 25.553627, 131.29568, 25.577854, 131.30038, 25.578398);
        ((GeneralPath) shape).curveTo(131.30475, 25.57835, 131.32852, 25.575062, 131.33252, 25.574427);
        ((GeneralPath) shape).curveTo(131.33582, 25.572628, 131.35751, 25.542952, 131.36046, 25.540575);
        ((GeneralPath) shape).curveTo(131.36237, 25.536495, 131.38683, 25.511362, 131.3884, 25.506723);
        ((GeneralPath) shape).curveTo(131.38963, 25.501528, 131.38333, 25.48259, 131.38422, 25.476843);
        ((GeneralPath) shape).curveTo(131.3859, 25.457954, 131.37294, 25.410955, 131.37166, 25.3872);
        ((GeneralPath) shape).curveTo(131.19215, 23.367325, 121.81508, 6.174123, 119.15793, 0.481018);
        ((GeneralPath) shape).curveTo(119.15796, -3.660903, 119.15587, -3.996748, 119.53809, -7.773446);
        ((GeneralPath) shape).curveTo(124.56538, -9.755217, 133.79713, -13.305337, 133.79713, -13.305337);
        ((GeneralPath) shape).curveTo(130.09888, -16.86815, 124.3877, -18.990591, 118.1114, -18.661982);
        ((GeneralPath) shape).curveTo(118.07028, -18.65983, 118.01975, -18.678337, 117.97871, -18.675978);
        ((GeneralPath) shape).curveTo(117.75003, -18.662844, 116.91851, -18.604336, 116.84593, -18.596754);
        ((GeneralPath) shape).curveTo(116.78293, -18.590176, 116.68282, -18.603731, 116.61687, -18.598839);
        ((GeneralPath) shape).curveTo(116.55458, -18.591757, 116.45783, -18.576105, 116.39199, -18.571041);
        ((GeneralPath) shape).curveTo(116.04016, -18.527807, 115.67682, -18.498302, 115.33183, -18.439997);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(116.68786, -17.391691);
        ((GeneralPath) shape).curveTo(122.29263, -18.353664, 129.63272, -17.173292, 133.25665, -13.664103);
        ((GeneralPath) shape).curveTo(133.25665, -13.664103, 124.09342, -10.122453, 119.094, -8.144126);
        ((GeneralPath) shape).curveTo(118.71657, -4.368019, 118.71084, -4.031209, 118.71384, 0.110338);
        ((GeneralPath) shape).curveTo(121.36251, 5.807443, 130.72406, 23.014568, 130.89545, 25.02049);
        ((GeneralPath) shape).curveTo(130.89584, 25.027916, 130.89954, 25.043423, 130.89963, 25.050371);
        ((GeneralPath) shape).curveTo(130.89449, 25.061699, 130.88136, 25.103325, 130.87589, 25.114103);
        ((GeneralPath) shape).curveTo(130.87611, 25.116865, 130.87965, 25.140759, 130.88007, 25.143986);
        ((GeneralPath) shape).curveTo(130.87302, 25.151281, 130.85341, 25.176367, 130.85213, 25.177837);
        ((GeneralPath) shape).curveTo(130.84496, 25.178028, 130.82198, 25.181492, 130.81999, 25.181808);
        ((GeneralPath) shape).curveTo(130.8165, 25.18205, 130.79079, 25.18565, 130.78787, 25.18578);
        ((GeneralPath) shape).curveTo(130.78787, 25.18578, 123.67878, 26.4033, 117.73478, 27.893578);
        ((GeneralPath) shape).lineTo(115.85628, 24.616098);
        ((GeneralPath) shape).lineTo(119.63392, 22.52088);
        ((GeneralPath) shape).lineTo(113.76735, 10.297149);
        ((GeneralPath) shape).lineTo(108.79473, 11.428573);
        ((GeneralPath) shape).lineTo(101.51508, -3.448188);
        ((GeneralPath) shape).curveTo(102.33172, -10.402478, 107.58145, -15.687333, 116.43504, -17.330044);
        ((GeneralPath) shape).curveTo(116.52311, -17.346384, 116.5989, -17.376423, 116.68786, -17.391691);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(35.599403, 84.09922);
        ((GeneralPath) shape).curveTo(35.969128, 84.030136, 36.363415, 84.00692, 36.76012, 83.98614);
        ((GeneralPath) shape).curveTo(40.412563, 83.79492, 43.954514, 87.31936, 44.12363, 91.526596);
        ((GeneralPath) shape).curveTo(44.26354, 95.007256, 40.760197, 98.64697, 37.10774, 98.83821);
        ((GeneralPath) shape).curveTo(33.4553, 99.02945, 29.744919, 95.35473, 29.516512, 91.53868);
        ((GeneralPath) shape).curveTo(29.31591, 88.186806, 31.666975, 84.83393, 35.599403, 84.09922);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(302.08856201171875, -10.284326553344727), 59.07331f, new Point2D.Double(302.08856201171875, -10.284326553344727), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(0.2857021f, -0.096936986f, 0.3403616f, 0.8738542f, 39.91093f, 55.616627f)));
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0280267f, -0.1270725f, 0.1338966f, 0.9561867f, 9.078821f, -5.932549f));

        // _0_0_22_7
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.956291f, -0.292417f, 0.309707f, 0.950832f, 0, 0));

        // _0_0_22_7_0
        shape = new Rectangle2D.Double(68.62531280517578, 58, 13.399776458740234, 13.094863891601562);
        g.setPaint(new Color(0x2E3436));
        g.fill(shape);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(64.03540802001953, 72.25350952148438), 8.072001f, new Point2D.Double(64.03540802001953, 72.25350952148438), new float[]{0, 1}, new Color[]{WHITE, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(0.35411f, -4.17141f, 5.032558f, -1.51988f, -331.3648f, 448.8406f)));
        g.setStroke(new BasicStroke(1.5441269f, 1, 1, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_22_7_0
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.967683f, -0.25217f, 0.307423f, 0.951573f, 0, 0));

        // _0_0_22_7_1
        shape = new Rectangle2D.Double(71.56298065185547, 55.69108581542969, 7.725412368774414, 11.043237686157227);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(77.37106323242188, 64.80364227294922), 4.14229f, new Point2D.Double(77.37106323242188, 64.80364227294922), new float[]{0, 1}, new Color[]{WHITE, new Color(0x555753, true)}, NO_CYCLE, SRGB, new AffineTransform(0.71884f, 0.05195072f, 0.124003f, 10.14631f, 11.77238f, -600.3243f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_22_7_1
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.98605f, -0.16645f, 0.08671967f, 0.996233f, 0, 0));

        // _0_0_22_7_2
        shape = new Rectangle2D.Double(82.51152038574219, 49.742820739746094, 11.254694938659668, 1.2325668334960938);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(94.13844299316406, 38.927982330322266), 6.8733773f, new Point2D.Double(94.13844299316406, 38.927982330322266), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(0.581247f, 0.005817117f, -0.07455762f, 9.383173f, 36.03053f, -309.6658f)));
        g.fill(shape);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(79.73527526855469, 48.53878402709961), new Point2D.Double(95, 48.53878402709961), new float[]{0, 1}, new Color[]{new Color(0xAA000000, true), new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(0.737301f, 0, 0, 1.016243f, 23.72264f, 1.031887f)));
        g.setStroke(new BasicStroke(0.38432986f, 1, 1, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_22_7_2
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.989282f, -0.14602f, 0.09906172f, 0.995081f, 0, 0));

        // _0_0_22_7_3
        shape = new Rectangle2D.Double(83.72756958007812, 56.03600311279297, 10.96024227142334, 1.0542099475860596);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(94.13844299316406, 38.927982330322266), 6.8733773f, new Point2D.Double(94.13844299316406, 38.927982330322266), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(0.566041f, 0.004976245f, -0.07260836f, 8.025401f, 38.46269f, -251.3652f)));
        g.fill(shape);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(79.73527526855469, 48.53878402709961), new Point2D.Double(95, 48.53878402709961), new float[]{0, 1}, new Color[]{new Color(0xAA000000, true), new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(0.718011f, 0, 0, 0.869189f, 26.47674f, 14.37374f)));
        g.setStroke(new BasicStroke(0.35075644f, 1, 1, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_22_7_3
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.990631f, -0.136567f, 0.105988f, 0.994367f, 0, 0));

        // _0_0_22_7_4
        shape = new Rectangle2D.Double(81.90776824951172, 51.249149322509766, 11.671585083007812, 1.050704836845398);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(94.13844299316406, 38.927982330322266), 6.8733773f, new Point2D.Double(94.13844299316406, 38.927982330322266), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(0.602777f, 0.004958538f, -0.07732142f, 7.998709f, 33.70512f, -255.1298f)));
        g.fill(shape);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(79.73527526855469, 48.53878402709961), new Point2D.Double(95, 48.53878402709961), new float[]{0, 1}, new Color[]{new Color(0xAA000000, true), new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(0.764612f, 0, 0, 0.866298f, 20.94123f, 9.725384f)));
        g.setStroke(new BasicStroke(0.3613577f, 1, 1, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_22_7_4

        g.setTransform(transformations.poll()); // _0_0_22_7

        // _0_0_22_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(118.97196, -7.734027);
        ((GeneralPath) shape).lineTo(133.2195, -13.233923);
        ((GeneralPath) shape).lineTo(133.86397, -11.543839);
        ((GeneralPath) shape).lineTo(118.93272, -5.62766);
        ((GeneralPath) shape).lineTo(118.97196, -7.734027);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(105.58074951171875, 11.27086067199707), new Point2D.Double(120.06922149658203, 11.27086067199707), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(1.0692341f, -0.1321662f, 0.1338966f, 0.9561867f, 4.131128f, -5.320974f)));
        g.fill(shape);

        // _0_0_22_9
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(130.32986, 23.365885);
        ((GeneralPath) shape).curveTo(134.49002, 22.577019, 140.98988, 13.893676, 143.06932, 4.141984);
        ((GeneralPath) shape).curveTo(143.16183, 3.708216, 143.49496, 7.199901, 143.38428, 7.664689);
        ((GeneralPath) shape).curveTo(141.23956, 16.670551, 135.45499, 22.817293, 131.12047, 24.881872);
        ((GeneralPath) shape).curveTo(130.86407, 25.003994, 131.15028, 26.607973, 130.32986, 23.365885);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(114.74418640136719, 51.13191604614258), new Point2D.Double(141.67282104492188, 13.184786796569824), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(1.0280267f, -0.1270725f, 0.1338966f, 0.9561867f, 9.078821f, -5.932549f)));
        g.fill(shape);

        // _0_0_22_10
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(102.34169, -4.573453);
        ((GeneralPath) shape).lineTo(108.89129, 12.254683);
        ((GeneralPath) shape).lineTo(112.91586, 11.497386);
        ((GeneralPath) shape).lineTo(118.41409, 23.06564);
        ((GeneralPath) shape).lineTo(115.14873, 25.092358);
        ((GeneralPath) shape).lineTo(117.52938, 28.301838);
        ((GeneralPath) shape).curveTo(123.47337, 26.81156, 129.88454, 24.266907, 129.88454, 24.266907);
        ((GeneralPath) shape).curveTo(129.8892, 24.267456, 129.91264, 24.265266, 129.91696, 24.26522);
        ((GeneralPath) shape).curveTo(129.92093, 24.264587, 129.94576, 24.264753, 129.94939, 24.263536);
        ((GeneralPath) shape).curveTo(129.95197, 24.260592, 129.97774, 24.234632, 129.97997, 24.23112);
        ((GeneralPath) shape).curveTo(129.9815, 24.226484, 129.9769, 24.205584, 129.9781, 24.20039);
        ((GeneralPath) shape).curveTo(129.97987, 24.188896, 130.0064, 24.150925, 130.00684, 24.137245);
        ((GeneralPath) shape).curveTo(129.98131, 22.35842, 120.46974, 4.927655, 117.80021, -0.814308);
        ((GeneralPath) shape).curveTo(117.79721, -4.955855, 117.8038, -5.288696, 118.18124, -9.064802);
        ((GeneralPath) shape).curveTo(123.18065, -11.043127, 131.36584, -14.457187, 131.36584, -14.457187);
        ((GeneralPath) shape).curveTo(127.68438, -18.022078, 121.36317, -17.908617, 115.72648, -16.862778);
        ((GeneralPath) shape).curveTo(106.87287, -15.220065, 103.15833, -11.527744, 102.34169, -4.573453);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(224.4635772705078, -4.225864887237549), 16.390625f, new Point2D.Double(224.4635772705078, -4.225864887237549), new float[]{0, 1}, new Color[]{WHITE, new Color(0x888A85, true)}, NO_CYCLE, SRGB, new AffineTransform(2.3781044f, -0.3075006f, 1.0402511f, 6.867777f, -417.44055f, 87.38833f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.3853211f * origAlpha));

        // _0_0_22_11
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(27.098349, 84.41657);
        ((GeneralPath) shape).curveTo(27.098349, 84.41657, 88.704216, 26.617735, 92.69356, 21.906666);
        ((GeneralPath) shape).curveTo(96.52428, 17.382923, 99.87276, -3.177272, 99.87276, -3.177272);
        ((GeneralPath) shape).curveTo(99.87276, -3.177272, 101.97215, -4.5997, 101.57104, -3.36635);
        ((GeneralPath) shape).curveTo(101.02145, -1.676471, 95.67815, 19.070917, 94.36663, 21.085527);
        ((GeneralPath) shape).curveTo(91.37882, 25.675047, 74.420425, 40.816917, 74.420425, 40.816917);
        ((GeneralPath) shape).lineTo(32.98598, 80.18096);
        ((GeneralPath) shape).lineTo(27.098349, 84.41657);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.8944954f * origAlpha));

        // _0_0_22_12
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.615078, 99.943756);
        ((GeneralPath) shape).curveTo(37.615078, 99.943756, 32.856266, 100.01863, 30.349546, 96.86864);
        ((GeneralPath) shape).curveTo(27.84282, 93.718636, 27.633232, 88.90799, 27.633232, 88.90799);
        ((GeneralPath) shape).lineTo(28.18361, 88.08356);
        ((GeneralPath) shape).curveTo(28.18361, 88.08356, 28.678764, 92.9097, 30.936974, 95.95886);
        ((GeneralPath) shape).curveTo(33.238453, 99.06642, 38.17531, 99.243385, 38.098366, 99.37195);
        ((GeneralPath) shape).lineTo(37.615078, 99.943756);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(19.006332397460938, 99.12092590332031), 4.6031747f, new Point2D.Double(19.006332397460938, 99.12092590332031), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(-1.0334476f, 0.07897265f, -0.1160692f, -1.3576785f, 64.00038f, 227.09045f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_22_13
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(128.77353, 9.578708);
        ((GeneralPath) shape).curveTo(128.69016, 9.848075, 129.03593, 17.915434, 129.08607, 18.200567);
        ((GeneralPath) shape).curveTo(129.20618, 22.630245, 130.2568, 22.898117, 130.37225, 23.69213);
        ((GeneralPath) shape).curveTo(131.22865, 23.366316, 130.64755, 23.772573, 131.41801, 23.296064);
        ((GeneralPath) shape).curveTo(131.34431, 22.908768, 130.25438, 20.20824, 129.80418, 19.239819);
        ((GeneralPath) shape).curveTo(129.84277, 17.036686, 129.84993, 10.857231, 129.85901, 10.270988);
        ((GeneralPath) shape).curveTo(129.44339, 9.992879, 129.28378, 9.881957, 128.77353, 9.578708);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.51376146f * origAlpha));

        // _0_0_22_14
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(142.56085, 4.47763);
        ((GeneralPath) shape).lineTo(129.92618, 10.431011);
        ((GeneralPath) shape).lineTo(129.75874, 19.404387);
        ((GeneralPath) shape).lineTo(131.53128, 23.236526);
        ((GeneralPath) shape).curveTo(136.98128, 19.822023, 140.7053, 12.752588, 142.56085, 4.47763);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(174.07650756835938, 28.159635543823242), 7.125f, new Point2D.Double(174.07650756835938, 28.159635543823242), new float[]{0, 1}, new Color[]{WHITE, new Color(0x3E3E3E, true)}, NO_CYCLE, SRGB, new AffineTransform(4.944339f, -0.2853475f, 0.2841705f, 4.338823f, -732.58093f, -60.890152f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_22_15
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(115.33183, -18.439997);
        ((GeneralPath) shape).curveTo(106.84519, -17.005705, 100.49069, -11.057706, 99.95226, -4.106155);
        ((GeneralPath) shape).curveTo(99.947174, -4.073584, 99.941696, -4.015279, 99.936874, -3.982662);
        ((GeneralPath) shape).curveTo(99.93687, -3.982658, 96.56589, 16.738304, 92.572205, 22.31004);
        ((GeneralPath) shape).curveTo(89.43772, 26.683077, 29.497028, 80.84029, 26.673952, 85.47607);
        ((GeneralPath) shape).curveTo(20.711351, 95.26724, 31.845856, 109.23349, 43.642628, 101.16144);
        ((GeneralPath) shape).curveTo(51.41989, 95.83976, 98.39347, 37.188744, 104.73567, 33.087345);
        ((GeneralPath) shape).curveTo(109.02257, 30.315063, 131.26408, 25.552488, 131.26408, 25.552488);
        ((GeneralPath) shape).curveTo(131.26917, 25.553627, 131.29568, 25.577854, 131.30038, 25.578398);
        ((GeneralPath) shape).curveTo(131.30475, 25.57835, 131.32852, 25.575062, 131.33252, 25.574427);
        ((GeneralPath) shape).curveTo(131.33582, 25.572628, 131.35751, 25.542952, 131.36046, 25.540575);
        ((GeneralPath) shape).curveTo(131.36237, 25.536495, 131.38683, 25.511362, 131.3884, 25.506723);
        ((GeneralPath) shape).curveTo(131.38963, 25.501528, 131.38333, 25.48259, 131.38422, 25.476843);
        ((GeneralPath) shape).curveTo(131.3859, 25.457954, 131.37294, 25.410955, 131.37166, 25.3872);
        ((GeneralPath) shape).curveTo(131.19215, 23.367325, 121.81508, 6.174123, 119.15793, 0.481018);
        ((GeneralPath) shape).curveTo(119.15796, -3.660903, 119.15587, -3.996748, 119.53809, -7.773446);
        ((GeneralPath) shape).curveTo(124.56538, -9.755217, 133.79713, -13.305337, 133.79713, -13.305337);
        ((GeneralPath) shape).curveTo(130.09888, -16.86815, 124.3877, -18.990591, 118.1114, -18.661982);
        ((GeneralPath) shape).curveTo(118.07028, -18.65983, 118.01975, -18.678337, 117.97871, -18.675978);
        ((GeneralPath) shape).curveTo(117.75003, -18.662844, 116.91851, -18.604336, 116.84593, -18.596754);
        ((GeneralPath) shape).curveTo(116.78293, -18.590176, 116.68282, -18.603731, 116.61687, -18.598839);
        ((GeneralPath) shape).curveTo(116.55458, -18.591757, 116.45783, -18.576105, 116.39199, -18.571041);
        ((GeneralPath) shape).curveTo(116.04016, -18.527807, 115.67682, -18.498302, 115.33183, -18.439997);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(116.68786, -17.391691);
        ((GeneralPath) shape).curveTo(122.29263, -18.353664, 129.63272, -17.173292, 133.25665, -13.664103);
        ((GeneralPath) shape).curveTo(133.25665, -13.664103, 124.09342, -10.122453, 119.094, -8.144126);
        ((GeneralPath) shape).curveTo(118.71657, -4.368019, 118.71084, -4.031209, 118.71384, 0.110338);
        ((GeneralPath) shape).curveTo(121.36251, 5.807443, 130.72406, 23.014568, 130.89545, 25.02049);
        ((GeneralPath) shape).curveTo(130.89584, 25.027916, 130.89954, 25.043423, 130.89963, 25.050371);
        ((GeneralPath) shape).curveTo(130.89449, 25.061699, 130.88136, 25.103325, 130.87589, 25.114103);
        ((GeneralPath) shape).curveTo(130.87611, 25.116865, 130.87965, 25.140759, 130.88007, 25.143986);
        ((GeneralPath) shape).curveTo(130.87302, 25.151281, 130.85341, 25.176367, 130.85213, 25.177837);
        ((GeneralPath) shape).curveTo(130.84496, 25.178028, 130.82198, 25.181492, 130.81999, 25.181808);
        ((GeneralPath) shape).curveTo(130.8165, 25.18205, 130.79079, 25.18565, 130.78787, 25.18578);
        ((GeneralPath) shape).curveTo(130.78787, 25.18578, 123.67878, 26.4033, 117.73478, 27.893578);
        ((GeneralPath) shape).lineTo(115.85628, 24.616098);
        ((GeneralPath) shape).lineTo(119.63392, 22.52088);
        ((GeneralPath) shape).lineTo(113.76735, 10.297149);
        ((GeneralPath) shape).lineTo(108.79473, 11.428573);
        ((GeneralPath) shape).lineTo(101.51508, -3.448188);
        ((GeneralPath) shape).curveTo(102.33172, -10.402478, 107.58145, -15.687333, 116.43504, -17.330044);
        ((GeneralPath) shape).curveTo(116.52311, -17.346384, 116.5989, -17.376423, 116.68786, -17.391691);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(35.599403, 84.09922);
        ((GeneralPath) shape).curveTo(35.969128, 84.030136, 36.363415, 84.00692, 36.76012, 83.98614);
        ((GeneralPath) shape).curveTo(40.412563, 83.79492, 43.954514, 87.31936, 44.12363, 91.526596);
        ((GeneralPath) shape).curveTo(44.26354, 95.007256, 40.760197, 98.64697, 37.10774, 98.83821);
        ((GeneralPath) shape).curveTo(33.4553, 99.02945, 29.744919, 95.35473, 29.516512, 91.53868);
        ((GeneralPath) shape).curveTo(29.31591, 88.186806, 31.666975, 84.83393, 35.599403, 84.09922);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(27.960590362548828, 118.94361877441406), 54.613575f, new Point2D.Double(27.960590362548828, 118.94361877441406), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(0.218502f, -0.068178505f, 0.7665978f, 2.4568331f, -26.97344f, -159.48154f)));
        g.fill(shape);

        // _0_0_22_16
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(35.93641, 81.29341);
        ((GeneralPath) shape).curveTo(41.4794, 79.98844, 47.786625, 86.20411, 46.570915, 92.06423);
        ((GeneralPath) shape).curveTo(50.7195, 88.62923, 98.45985, 35.38593, 99.44982, 32.823833);
        ((GeneralPath) shape).curveTo(100.96579, 28.900454, 96.87174, 25.35542, 92.97773, 27.026464);
        ((GeneralPath) shape).curveTo(90.26167, 28.19201, 35.57562, 81.37835, 35.93641, 81.29341);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x888A85));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.8f * origAlpha));

        // _0_0_22_17
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(35.93641, 81.29341);
        ((GeneralPath) shape).curveTo(41.4794, 79.98844, 47.786625, 86.20411, 46.570915, 92.06423);
        ((GeneralPath) shape).curveTo(50.7195, 88.62923, 98.45985, 35.38593, 99.44982, 32.823833);
        ((GeneralPath) shape).curveTo(100.96579, 28.900454, 96.87174, 25.35542, 92.97773, 27.026464);
        ((GeneralPath) shape).curveTo(90.26167, 28.19201, 35.57562, 81.37835, 35.93641, 81.29341);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.27722773f * origAlpha));

        // _0_0_22_18
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(35.93641, 81.29341);
        ((GeneralPath) shape).curveTo(41.4794, 79.98844, 47.786625, 86.20411, 46.570915, 92.06423);
        ((GeneralPath) shape).curveTo(50.7195, 88.62923, 98.45985, 35.38593, 99.44982, 32.823833);
        ((GeneralPath) shape).curveTo(100.96579, 28.900454, 96.87174, 25.35542, 92.97773, 27.026464);
        ((GeneralPath) shape).curveTo(90.26167, 28.19201, 35.57562, 81.37835, 35.93641, 81.29341);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(62.261756896972656, 77.16757202148438), 33.8983f, new Point2D.Double(56.3128547668457, 65.78478240966797), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(0.4649621f, 1.0036473f, -0.2853745f, 0.1958414f, 89.42805f, -34.203705f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));

        // _0_0_22_19
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(35.93641, 81.29341);
        ((GeneralPath) shape).curveTo(41.4794, 79.98844, 47.786625, 86.20411, 46.570915, 92.06423);
        ((GeneralPath) shape).curveTo(50.7195, 88.62923, 98.45985, 35.38593, 99.44982, 32.823833);
        ((GeneralPath) shape).curveTo(100.96579, 28.900454, 96.87174, 25.35542, 92.97773, 27.026464);
        ((GeneralPath) shape).curveTo(90.26167, 28.19201, 35.57562, 81.37835, 35.93641, 81.29341);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(22.596113204956055, 66.94859313964844), 33.8983f, new Point2D.Double(22.596113204956055, 66.94859313964844), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1.0280267f, -0.1270725f, 0.1208309f, 0.8628811f, 24.52013f, 16.2351f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.40366971f * origAlpha));

        // _0_0_22_20
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(92.89191, 27.144552);
        ((GeneralPath) shape).curveTo(93.19606, 26.95717, 95.76765, 25.674517, 98.14208, 27.764147);
        ((GeneralPath) shape).curveTo(100.16892, 29.547878, 99.89571, 31.393856, 99.33099, 33.05546);
        ((GeneralPath) shape).curveTo(99.05827, 33.85789, 77.14085, 58.710114, 73.20633, 63.23196);
        ((GeneralPath) shape).curveTo(71.27163, 65.45547, 64.65108, 72.69199, 58.57656, 79.37654);
        ((GeneralPath) shape).curveTo(52.447956, 86.120605, 46.692596, 91.97056, 46.692596, 91.97056);
        ((GeneralPath) shape).curveTo(46.692596, 91.97056, 98.621925, 34.08261, 98.935585, 32.503345);
        ((GeneralPath) shape).curveTo(99.39539, 30.188236, 98.447136, 29.451384, 97.66559, 28.711845);
        ((GeneralPath) shape).curveTo(96.86907, 27.958141, 95.46757, 27.1158, 93.560005, 27.50294);
        ((GeneralPath) shape).curveTo(90.92946, 28.036806, 37.058292, 80.83489, 36.038914, 81.2223);
        ((GeneralPath) shape).curveTo(36.038914, 81.2223, 48.975246, 68.41322, 62.627514, 55.239384);
        ((GeneralPath) shape).curveTo(76.27978, 42.065548, 90.64799, 28.526957, 92.89191, 27.144552);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x2E3436));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_22_21
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(36.45271, 80.75625);
        ((GeneralPath) shape).curveTo(36.45271, 80.75625, 40.748466, 79.725136, 44.419098, 83.16506);
        ((GeneralPath) shape).curveTo(48.43342, 86.927055, 47.212345, 91.40676, 47.212345, 91.40676);
        ((GeneralPath) shape).lineTo(46.566784, 92.17762);
        ((GeneralPath) shape).curveTo(46.566784, 92.17762, 46.919834, 90.46323, 46.50249, 88.78138);
        ((GeneralPath) shape).curveTo(46.085148, 87.09952, 45.19851, 85.371506, 43.687435, 83.98041);
        ((GeneralPath) shape).curveTo(42.198368, 82.609566, 40.78684, 81.727, 39.25321, 81.39871);
        ((GeneralPath) shape).curveTo(37.719578, 81.07043, 35.976196, 81.30726, 36.011154, 81.24127);
        ((GeneralPath) shape).lineTo(36.45271, 80.75625);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(18.988296508789062, 99.09947967529297), 4.9090157f, new Point2D.Double(18.988296508789062, 99.09947967529297), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1.0280267f, -0.1270725f, 0.1779489f, 1.270773f, 4.713284f, -37.10785f)));
        g.fill(shape);

        // _0_0_22_22
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(36.45271, 80.75625);
        ((GeneralPath) shape).curveTo(36.45271, 80.75625, 40.748466, 79.725136, 44.419098, 83.16506);
        ((GeneralPath) shape).curveTo(48.43342, 86.927055, 47.212345, 91.40676, 47.212345, 91.40676);
        ((GeneralPath) shape).lineTo(46.566784, 92.17762);
        ((GeneralPath) shape).curveTo(46.566784, 92.17762, 46.919834, 90.46323, 46.50249, 88.78138);
        ((GeneralPath) shape).curveTo(46.085148, 87.09952, 45.19851, 85.371506, 43.687435, 83.98041);
        ((GeneralPath) shape).curveTo(42.198368, 82.609566, 40.78684, 81.727, 39.25321, 81.39871);
        ((GeneralPath) shape).curveTo(37.719578, 81.07043, 35.976196, 81.30726, 36.011154, 81.24127);
        ((GeneralPath) shape).lineTo(36.45271, 80.75625);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        // _0_0_22_23
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(124.31226, -17.523397);
        ((GeneralPath) shape).curveTo(112.3204, -18.51272, 103.57065, -14.357039, 102.15465, -5.253814);
        ((GeneralPath) shape).curveTo(103.80088, -12.211305, 111.10335, -17.859943, 124.31226, -17.523397);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.7772277f * origAlpha));

        // _0_0_22_24
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(124.31226, -17.523397);
        ((GeneralPath) shape).curveTo(112.16967, -19.236233, 102.57582, -14.869527, 102.15465, -5.253814);
        ((GeneralPath) shape).curveTo(104.4641, -12.090719, 111.10335, -17.588625, 124.31226, -17.523397);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 19.704256f, -20.717312f));

        // _0_0_22_25
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(99.8125, 3.15625);
        ((GeneralPath) shape).curveTo(95.03056, 3.1270397, 90.87366, 4.127752, 87.875, 6.15625);
        ((GeneralPath) shape).curveTo(85.32026, 7.884452, 83.58831, 10.335174, 82.96875, 13.46875);
        ((GeneralPath) shape).curveTo(85.4595, 8.288529, 90.73924, 4.176798, 99.8125, 3.15625);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_22_25
        g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));

        // _0_0_22_26
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(95.13893, 26.595188);
        ((GeneralPath) shape).curveTo(94.43304, 26.573643, 93.71281, 26.719366, 92.98268, 27.032688);
        ((GeneralPath) shape).curveTo(90.26662, 28.198233, 35.590637, 81.36763, 35.951427, 81.28269);
        ((GeneralPath) shape).curveTo(36.32843, 81.19393, 36.694958, 81.14809, 37.076427, 81.12644);
        ((GeneralPath) shape).curveTo(42.90788, 75.24232, 90.43994, 29.123854, 92.98268, 28.032688);
        ((GeneralPath) shape).curveTo(96.0997, 26.695074, 99.33925, 28.698446, 99.73268, 31.563938);
        ((GeneralPath) shape).curveTo(99.99016, 28.900377, 97.78887, 26.67607, 95.13893, 26.595188);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(46.701427, 90.97019);
        ((GeneralPath) shape).curveTo(46.682194, 91.337296, 46.65241, 91.69768, 46.576427, 92.06394);
        ((GeneralPath) shape).curveTo(46.599766, 92.04462, 46.675346, 91.992645, 46.701427, 91.97019);
        ((GeneralPath) shape).curveTo(46.701977, 91.9597, 46.70092, 91.94943, 46.701427, 91.93894);
        ((GeneralPath) shape).curveTo(46.71708, 91.61381, 46.72721, 91.29306, 46.701427, 90.97019);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_22
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 1.0148767f, -40.24304f, -409.53323f));

        // _0_0_23

        g.setTransform(transformations.poll()); // _0_0_23
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 1.0148767f, -40.24304f, -409.53323f));

        // _0_0_24

        g.setTransform(transformations.poll()); // _0_0_24
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_25

        // _0_0_26
        g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.7946432f, 0, 0, 0.6605615f, -2682.3633f, 122.50693f));

        // _0_0_27

        g.setTransform(transformations.poll()); // _0_0_27
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.7946432f, 0, 0, 0.6605615f, -2682.3633f, 122.50693f));

        // _0_0_28

        g.setTransform(transformations.poll()); // _0_0_28
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 0.6605615f, 566.21735f, 129.94366f));

        // _0_0_29

        g.setTransform(transformations.poll()); // _0_0_29
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 0.6605615f, 566.21735f, 129.94366f));

        // _0_0_30

        g.setTransform(transformations.poll()); // _0_0_30
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 1.0148767f, 102.27096f, -250.41219f));

        // _0_0_31

        g.setTransform(transformations.poll()); // _0_0_31
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 1.0148767f, 102.27096f, -250.41219f));

        // _0_0_32

        g.setTransform(transformations.poll()); // _0_0_32
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_33

        // _0_0_34
        g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.7946432f, 0, 0, 0.6605615f, -2539.8496f, 281.62793f));

        // _0_0_35

        g.setTransform(transformations.poll()); // _0_0_35
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.7946432f, 0, 0, 0.6605615f, -2539.8496f, 281.62793f));

        // _0_0_36

        g.setTransform(transformations.poll()); // _0_0_36
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 0.6605615f, 708.73145f, 289.06482f));

        // _0_0_37

        g.setTransform(transformations.poll()); // _0_0_37
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 0.6605615f, 708.73145f, 289.06482f));

        // _0_0_38

        g.setTransform(transformations.poll()); // _0_0_38
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 1.0148767f, 52.034595f, -303.18576f));

        // _0_0_39

        g.setTransform(transformations.poll()); // _0_0_39
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 1.0148767f, 52.034595f, -303.18576f));

        // _0_0_40

        g.setTransform(transformations.poll()); // _0_0_40
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_41

        // _0_0_42
        g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.7946432f, 0, 0, 0.6605615f, -2590.0854f, 228.85435f));

        // _0_0_43

        g.setTransform(transformations.poll()); // _0_0_43
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.7946432f, 0, 0, 0.6605615f, -2590.0854f, 228.85435f));

        // _0_0_44

        g.setTransform(transformations.poll()); // _0_0_44
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 0.6605615f, 658.49493f, 236.29121f));

        // _0_0_45

        g.setTransform(transformations.poll()); // _0_0_45
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 0.6605615f, 658.49493f, 236.29121f));

        // _0_0_46

        g.setTransform(transformations.poll()); // _0_0_46
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 1.0148767f, -340.97626f, -177.59482f));

        // _0_0_47

        g.setTransform(transformations.poll()); // _0_0_47
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 1.0148767f, -340.97626f, -177.59482f));

        // _0_0_48

        g.setTransform(transformations.poll()); // _0_0_48
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_49

        // _0_0_50
        g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.7946432f, 0, 0, 0.6605615f, -2983.096f, 354.4453f));

        // _0_0_51

        g.setTransform(transformations.poll()); // _0_0_51
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.7946432f, 0, 0, 0.6605615f, -2983.096f, 354.4453f));

        // _0_0_52

        g.setTransform(transformations.poll()); // _0_0_52
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 0.6605615f, 265.48422f, 361.88217f));

        // _0_0_53

        g.setTransform(transformations.poll()); // _0_0_53
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 0.6605615f, 265.48422f, 361.88217f));

        // _0_0_54

        g.setTransform(transformations.poll()); // _0_0_54
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 1.0148767f, -84.82939f, 1.4213f));

        // _0_0_55

        g.setTransform(transformations.poll()); // _0_0_55
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 1.0148767f, -84.82939f, 1.4213f));

        // _0_0_56

        g.setTransform(transformations.poll()); // _0_0_56
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_57

        // _0_0_58
        g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.7946432f, 0, 0, 0.6605615f, -2726.95f, 533.4614f));

        // _0_0_59

        g.setTransform(transformations.poll()); // _0_0_59
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.7946432f, 0, 0, 0.6605615f, -2726.95f, 533.4614f));

        // _0_0_60

        g.setTransform(transformations.poll()); // _0_0_60
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 0.6605615f, 521.631f, 540.8983f));

        // _0_0_61

        g.setTransform(transformations.poll()); // _0_0_61
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 0.6605615f, 521.631f, 540.8983f));

        // _0_0_62

        g.setTransform(transformations.poll()); // _0_0_62
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 1.0148767f, -186.97644f, -235.61684f));

        // _0_0_63

        g.setTransform(transformations.poll()); // _0_0_63
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 1.0148767f, -186.97644f, -235.61684f));

        // _0_0_64

        g.setTransform(transformations.poll()); // _0_0_64
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_65

        // _0_0_66
        g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.7946432f, 0, 0, 0.6605615f, -2829.096f, 296.42328f));

        // _0_0_67

        g.setTransform(transformations.poll()); // _0_0_67
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.7946432f, 0, 0, 0.6605615f, -2829.096f, 296.42328f));

        // _0_0_68

        g.setTransform(transformations.poll()); // _0_0_68
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 0.6605615f, 419.48404f, 303.86014f));

        // _0_0_69

        g.setTransform(transformations.poll()); // _0_0_69
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 0.6605615f, 419.48404f, 303.86014f));

        // _0_0_70

        g.setTransform(transformations.poll()); // _0_0_70
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 1.0148767f, -184.939f, -236.55539f));

        // _0_0_71

        g.setTransform(transformations.poll()); // _0_0_71
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 1.0148767f, -184.939f, -236.55539f));

        // _0_0_72

        g.setTransform(transformations.poll()); // _0_0_72
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_73

        // _0_0_74
        g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.7946432f, 0, 0, 0.6605615f, -2827.0588f, 295.48474f));

        // _0_0_75

        g.setTransform(transformations.poll()); // _0_0_75
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.7946432f, 0, 0, 0.6605615f, -2827.0588f, 295.48474f));

        // _0_0_76

        g.setTransform(transformations.poll()); // _0_0_76
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 0.6605615f, 421.52148f, 302.9216f));

        // _0_0_77

        g.setTransform(transformations.poll()); // _0_0_77
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 0.6605615f, 421.52148f, 302.9216f));

        // _0_0_78

        g.setTransform(transformations.poll()); // _0_0_78
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 1.0148767f, -16.028187f, -282.9486f));

        // _0_0_79

        g.setTransform(transformations.poll()); // _0_0_79
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 1.0148767f, -16.028187f, -282.9486f));

        // _0_0_80

        g.setTransform(transformations.poll()); // _0_0_80
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_81

        // _0_0_82
        g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.7946432f, 0, 0, 0.6605615f, -2658.148f, 249.0915f));

        // _0_0_83

        g.setTransform(transformations.poll()); // _0_0_83
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.7946432f, 0, 0, 0.6605615f, -2658.148f, 249.0915f));

        // _0_0_84

        g.setTransform(transformations.poll()); // _0_0_84
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 0.6605615f, 590.43207f, 256.52823f));

        // _0_0_85

        g.setTransform(transformations.poll()); // _0_0_85
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 0.6605615f, 590.43207f, 256.52823f));

        // _0_0_86

        g.setTransform(transformations.poll()); // _0_0_86
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 1.0148767f, 126.48581f, -123.82762f));

        // _0_0_87

        g.setTransform(transformations.poll()); // _0_0_87
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 1.0148767f, 126.48581f, -123.82762f));

        // _0_0_88

        g.setTransform(transformations.poll()); // _0_0_88
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_89

        // _0_0_90
        g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.7946432f, 0, 0, 0.6605615f, -2515.6343f, 408.21252f));

        // _0_0_91

        g.setTransform(transformations.poll()); // _0_0_91
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.7946432f, 0, 0, 0.6605615f, -2515.6343f, 408.21252f));

        // _0_0_92

        g.setTransform(transformations.poll()); // _0_0_92
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 0.6605615f, 732.94617f, 415.64938f));

        // _0_0_93

        g.setTransform(transformations.poll()); // _0_0_93
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0148767f, 0, 0, 0.6605615f, 732.94617f, 415.64938f));

        // _0_0_94

        g.setTransform(transformations.poll()); // _0_0_94
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 1.3777714f, -467.50354f, -536.6983f));

        // _0_0_95

        g.setTransform(transformations.poll()); // _0_0_95
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 1.3777714f, -467.50354f, -536.6983f));

        // _0_0_96

        g.setTransform(transformations.poll()); // _0_0_96
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_97

        // _0_0_98
        g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-1.078788f, 0, 0, 0.8967627f, -4054.3835f, 185.58665f));

        // _0_0_99

        g.setTransform(transformations.poll()); // _0_0_99
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-1.078788f, 0, 0, 0.8967627f, -4054.3835f, 185.58665f));

        // _0_0_100

        g.setTransform(transformations.poll()); // _0_0_100
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 0.8967627f, 355.81253f, 195.68257f));

        // _0_0_101

        g.setTransform(transformations.poll()); // _0_0_101
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 0.8967627f, 355.81253f, 195.68257f));

        // _0_0_102

        g.setTransform(transformations.poll()); // _0_0_102
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 1.3777714f, -274.02997f, -320.67944f));

        // _0_0_103

        g.setTransform(transformations.poll()); // _0_0_103
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 1.3777714f, -274.02997f, -320.67944f));

        // _0_0_104

        g.setTransform(transformations.poll()); // _0_0_104
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_105

        // _0_0_106
        g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-1.078788f, 0, 0, 0.8967627f, -3860.9104f, 401.6057f));

        // _0_0_107

        g.setTransform(transformations.poll()); // _0_0_107
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-1.078788f, 0, 0, 0.8967627f, -3860.9104f, 401.6057f));

        // _0_0_108

        g.setTransform(transformations.poll()); // _0_0_108
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 0.8967627f, 549.28625f, 411.70178f));

        // _0_0_109

        g.setTransform(transformations.poll()); // _0_0_109
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 0.8967627f, 549.28625f, 411.70178f));

        // _0_0_110

        g.setTransform(transformations.poll()); // _0_0_110
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 1.3777714f, -342.22968f, -392.32343f));

        // _0_0_111

        g.setTransform(transformations.poll()); // _0_0_111
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 1.3777714f, -342.22968f, -392.32343f));

        // _0_0_112

        g.setTransform(transformations.poll()); // _0_0_112
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_113

        // _0_0_114
        g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-1.078788f, 0, 0, 0.8967627f, -3929.11f, 329.96146f));

        // _0_0_115

        g.setTransform(transformations.poll()); // _0_0_115
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-1.078788f, 0, 0, 0.8967627f, -3929.11f, 329.96146f));

        // _0_0_116

        g.setTransform(transformations.poll()); // _0_0_116
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 0.8967627f, 481.0867f, 340.05753f));

        // _0_0_117

        g.setTransform(transformations.poll()); // _0_0_117
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 0.8967627f, 481.0867f, 340.05753f));

        // _0_0_118

        g.setTransform(transformations.poll()); // _0_0_118
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 1.3777714f, -875.7718f, -221.82425f));

        // _0_0_119

        g.setTransform(transformations.poll()); // _0_0_119
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 1.3777714f, -875.7718f, -221.82425f));

        // _0_0_120

        g.setTransform(transformations.poll()); // _0_0_120
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_121

        // _0_0_122
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_123
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-1262.2831, -445.404);
        ((GeneralPath) shape).lineTo(-1262.2831, -449.25446);
        ((GeneralPath) shape).lineTo(-1262.2831, -445.404);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xC1FFFFFF, true));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-1.078788f, 0, 0, 0.8967627f, -4462.652f, 500.46075f));

        // _0_0_124

        g.setTransform(transformations.poll()); // _0_0_124
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-1.078788f, 0, 0, 0.8967627f, -4462.652f, 500.46075f));

        // _0_0_125

        g.setTransform(transformations.poll()); // _0_0_125
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 0.8967627f, -52.4556f, 510.5568f));

        // _0_0_126

        g.setTransform(transformations.poll()); // _0_0_126
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 0.8967627f, -52.4556f, 510.5568f));

        // _0_0_127

        g.setTransform(transformations.poll()); // _0_0_127
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 1.3777714f, -528.033f, 21.20379f));

        // _0_0_128

        g.setTransform(transformations.poll()); // _0_0_128
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 1.3777714f, -528.033f, 21.20379f));

        // _0_0_129

        g.setTransform(transformations.poll()); // _0_0_129
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_130

        // _0_0_131
        g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-1.078788f, 0, 0, 0.8967627f, -4114.913f, 743.4889f));

        // _0_0_132

        g.setTransform(transformations.poll()); // _0_0_132
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-1.078788f, 0, 0, 0.8967627f, -4114.913f, 743.4889f));

        // _0_0_133

        g.setTransform(transformations.poll()); // _0_0_133
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 0.8967627f, 295.28323f, 753.58484f));

        // _0_0_134

        g.setTransform(transformations.poll()); // _0_0_134
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 0.8967627f, 295.28323f, 753.58484f));

        // _0_0_135

        g.setTransform(transformations.poll()); // _0_0_135
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 1.3777714f, -666.7053f, -300.5936f));

        // _0_0_136

        g.setTransform(transformations.poll()); // _0_0_136
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 1.3777714f, -666.7053f, -300.5936f));

        // _0_0_137

        g.setTransform(transformations.poll()); // _0_0_137
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_138

        // _0_0_139
        g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-1.078788f, 0, 0, 0.8967627f, -4253.584f, 421.69153f));

        // _0_0_140

        g.setTransform(transformations.poll()); // _0_0_140
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-1.078788f, 0, 0, 0.8967627f, -4253.584f, 421.69153f));

        // _0_0_141

        g.setTransform(transformations.poll()); // _0_0_141
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 0.8967627f, 156.61105f, 431.7876f));

        // _0_0_142

        g.setTransform(transformations.poll()); // _0_0_142
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 0.8967627f, 156.61105f, 431.7876f));

        // _0_0_143

        g.setTransform(transformations.poll()); // _0_0_143
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 1.3777714f, -663.9394f, -301.86768f));

        // _0_0_144

        g.setTransform(transformations.poll()); // _0_0_144
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 1.3777714f, -663.9394f, -301.86768f));

        // _0_0_145

        g.setTransform(transformations.poll()); // _0_0_145
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_146

        // _0_0_147
        g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-1.078788f, 0, 0, 0.8967627f, -4250.8193f, 420.4173f));

        // _0_0_148

        g.setTransform(transformations.poll()); // _0_0_148
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-1.078788f, 0, 0, 0.8967627f, -4250.8193f, 420.4173f));

        // _0_0_149

        g.setTransform(transformations.poll()); // _0_0_149
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 0.8967627f, 159.37685f, 430.51337f));

        // _0_0_150

        g.setTransform(transformations.poll()); // _0_0_150
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 0.8967627f, 159.37685f, 430.51337f));

        // _0_0_151

        g.setTransform(transformations.poll()); // _0_0_151
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 1.3777714f, -434.6301f, -364.85013f));

        // _0_0_152

        g.setTransform(transformations.poll()); // _0_0_152
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 1.3777714f, -434.6301f, -364.85013f));

        // _0_0_153

        g.setTransform(transformations.poll()); // _0_0_153
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_154

        // _0_0_155
        g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-1.078788f, 0, 0, 0.8967627f, -4021.5105f, 357.43503f));

        // _0_0_156

        g.setTransform(transformations.poll()); // _0_0_156
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-1.078788f, 0, 0, 0.8967627f, -4021.5105f, 357.43503f));

        // _0_0_157

        g.setTransform(transformations.poll()); // _0_0_157
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 0.8967627f, 388.68613f, 367.53094f));

        // _0_0_158

        g.setTransform(transformations.poll()); // _0_0_158
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 0.8967627f, 388.68613f, 367.53094f));

        // _0_0_159

        g.setTransform(transformations.poll()); // _0_0_159
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 1.3777714f, -241.15637f, -148.83122f));

        // _0_0_160

        g.setTransform(transformations.poll()); // _0_0_160
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 1.3777714f, -241.15637f, -148.83122f));

        // _0_0_161

        g.setTransform(transformations.poll()); // _0_0_161
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_162

        // _0_0_163
        g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-1.078788f, 0, 0, 0.8967627f, -3828.037f, 573.4539f));

        // _0_0_164

        g.setTransform(transformations.poll()); // _0_0_164
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-1.078788f, 0, 0, 0.8967627f, -3828.037f, 573.4539f));

        // _0_0_165

        g.setTransform(transformations.poll()); // _0_0_165
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 0.8967627f, 582.15985f, 583.55f));

        // _0_0_166

        g.setTransform(transformations.poll()); // _0_0_166
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.3777714f, 0, 0, 0.8967627f, 582.15985f, 583.55f));

        // _0_0_167

        g.setTransform(transformations.poll()); // _0_0_167
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9796636f, 0, 0, 0.9796636f, -136.54507f, -191.7335f));

        // _0_0_168
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.7904687f, 0, 0, 0.7904687f, -678.5531f, 631.1985f));

        // _0_0_168_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1060.3605, -478.60516);
        ((GeneralPath) shape).curveTo(1060.3605, -475.81042, 1058.0948, -473.54486, 1055.3002, -473.54486);
        ((GeneralPath) shape).curveTo(1052.5055, -473.54486, 1050.2399, -475.81042, 1050.2399, -478.60516);
        ((GeneralPath) shape).curveTo(1050.2399, -481.3999, 1052.5055, -483.66547, 1055.3002, -483.66547);
        ((GeneralPath) shape).curveTo(1058.0948, -483.66547, 1060.3605, -481.3999, 1060.3605, -478.60516);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(1052.3214111328125, -481.7665710449219), new Point2D.Double(1055.2821044921875, -476.6385192871094), new float[]{0, 1}, new Color[]{new Color(0x6F6F6F), WHITE}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_168_0

        g.setTransform(transformations.poll()); // _0_0_168
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9796636f, 0, 0, 0.9796636f, -140.46373f, -183.77856f));

        // _0_0_169
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.7904687f, 0, 0, 0.7904687f, -678.5531f, 631.1985f));

        // _0_0_169_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1060.3605, -478.60516);
        ((GeneralPath) shape).curveTo(1060.3605, -475.81042, 1058.0948, -473.54486, 1055.3002, -473.54486);
        ((GeneralPath) shape).curveTo(1052.5055, -473.54486, 1050.2399, -475.81042, 1050.2399, -478.60516);
        ((GeneralPath) shape).curveTo(1050.2399, -481.3999, 1052.5055, -483.66547, 1055.3002, -483.66547);
        ((GeneralPath) shape).curveTo(1058.0948, -483.66547, 1060.3605, -481.3999, 1060.3605, -478.60516);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(1053.9857177734375, -483.1348571777344), new Point2D.Double(1057.7916259765625, -476.5428466796875), new float[]{0, 1}, new Color[]{new Color(0x6F6F6F), WHITE}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_169_0

        g.setTransform(transformations.poll()); // _0_0_169
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9796636f, 0, 0, 0.9796636f, -136.54507f, -207.63351f));

        // _0_0_170
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.7904687f, 0, 0, 0.7904687f, -678.5531f, 631.1985f));

        // _0_0_170_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1060.3605, -478.60516);
        ((GeneralPath) shape).curveTo(1060.3605, -475.81042, 1058.0948, -473.54486, 1055.3002, -473.54486);
        ((GeneralPath) shape).curveTo(1052.5055, -473.54486, 1050.2399, -475.81042, 1050.2399, -478.60516);
        ((GeneralPath) shape).curveTo(1050.2399, -481.3999, 1052.5055, -483.66547, 1055.3002, -483.66547);
        ((GeneralPath) shape).curveTo(1058.0948, -483.66547, 1060.3605, -481.3999, 1060.3605, -478.60516);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(1052.3214111328125, -481.7665710449219), new Point2D.Double(1055.2821044921875, -476.6385192871094), new float[]{0, 1}, new Color[]{new Color(0x6F6F6F), WHITE}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_170_0

        g.setTransform(transformations.poll()); // _0_0_170
        g.setComposite(AlphaComposite.getInstance(3, 0.3910891f * origAlpha));

        // _0_0_171
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(26.0625, 37.0);
        ((GeneralPath) shape).curveTo(24.913385, 37.0, 24.0, 38.08096, 24.0, 39.4375);
        ((GeneralPath) shape).lineTo(24.0, 61.5625);
        ((GeneralPath) shape).curveTo(24.0, 62.91904, 24.913387, 64.0, 26.0625, 64.0);
        ((GeneralPath) shape).lineTo(49.9375, 64.0);
        ((GeneralPath) shape).curveTo(51.086613, 64.0, 52.0, 62.91904, 52.0, 61.5625);
        ((GeneralPath) shape).lineTo(52.0, 39.4375);
        ((GeneralPath) shape).curveTo(52.0, 38.08096, 51.086613, 37.0, 49.9375, 37.0);
        ((GeneralPath) shape).lineTo(26.0625, 37.0);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(27.1875, 39.8125);
        ((GeneralPath) shape).lineTo(48.75, 39.8125);
        ((GeneralPath) shape).curveTo(49.899113, 39.8125, 50.8125, 40.89346, 50.8125, 42.25);
        ((GeneralPath) shape).lineTo(50.8125, 60.875);
        ((GeneralPath) shape).curveTo(50.8125, 62.23154, 49.899113, 63.3125, 48.75, 63.3125);
        ((GeneralPath) shape).lineTo(27.1875, 63.3125);
        ((GeneralPath) shape).curveTo(26.038387, 63.3125, 25.125, 62.23154, 25.125, 60.875);
        ((GeneralPath) shape).lineTo(25.125, 42.25);
        ((GeneralPath) shape).curveTo(25.125, 40.89346, 26.038385, 39.8125, 27.1875, 39.8125);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
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
    public ConfigureToolbars() {
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

