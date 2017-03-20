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
public class HelpContents5 implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.transform(new AffineTransform(1.001374f, 0, 0, 0.410379f, -2.393169E-5f, 75.32738f));

        // _0_0_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(127.82442, 115.70919);
        ((GeneralPath) shape).curveTo(127.82442, 122.69116, 99.209946, 128.35117, 63.91221, 128.35117);
        ((GeneralPath) shape).curveTo(28.61447, 128.35117, 7.1054274E-15, 122.69116, 0.0, 115.70919);
        ((GeneralPath) shape).curveTo(0.0, 108.72722, 28.61447, 103.067215, 63.91221, 103.067215);
        ((GeneralPath) shape).curveTo(99.209946, 103.067215, 127.82442, 108.72722, 127.82442, 115.70919);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(63.912208557128906, 115.70919036865234), 63.91221f, new Point2D.Double(63.912208557128906, 115.70929718017578), new float[]{0, 0.67582417f, 1}, new Color[]{BLACK, new Color(0x9F000000, true), new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 0.197802f, 0, 92.82166f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.008377f, 0, 0, 1.008628f, -2.581806f, 4.000097f));

        // _0_0_1

        // _0_0_1_0

        // _0_0_1_0_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(38.338913, 110.0964);
        ((GeneralPath) shape).lineTo(37.913086, 0.2584176);
        ((GeneralPath) shape).lineTo(108.67949, 0.6635581);
        ((GeneralPath) shape).curveTo(110.77709, 0.6554119, 112.42414, 2.3833897, 112.43226, 4.4816985);
        ((GeneralPath) shape).lineTo(109.58501, 110.33068);
        ((GeneralPath) shape).curveTo(109.59313, 112.42898, 107.95921, 114.07621, 105.8616, 114.08435);
        ((GeneralPath) shape).lineTo(38.338913, 110.0964);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x2560A8));
        g.fill(shape);

        // _0_0_1_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(107.58766, 3.0160825);
        ((GeneralPath) shape).curveTo(112.67226, 8.539454, 112.17593, 8.790735, 111.98069, 12.109645);
        ((GeneralPath) shape).lineTo(103.4758, 13.38043);
        ((GeneralPath) shape).lineTo(107.58766, 3.0160825);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(36.99221420288086, 42.161170959472656), new Point2D.Double(38.913978576660156, 39.759342193603516), new float[]{0, 0.25f, 0.5f, 1}, new Color[]{BLACK, new Color(0x99000000, true), new Color(0x47000000, true), new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(2.934016f, -0.577836f, -0.577639f, -2.935016f, 20.8843f, 149.7862f)));
        g.fill(shape);

        // _0_0_1_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(39.59741, 118.78309);
        ((GeneralPath) shape).lineTo(32.549614, 118.86172);
        ((GeneralPath) shape).lineTo(31.344292, 118.56658);
        ((GeneralPath) shape).lineTo(30.344725, 118.88633);
        ((GeneralPath) shape).lineTo(22.534641, 118.97346);
        ((GeneralPath) shape).curveTo(21.039463, 118.97927, 19.817875, 117.76602, 19.812077, 116.27033);
        ((GeneralPath) shape).lineTo(18.079159, 107.46529);
        ((GeneralPath) shape).lineTo(17.931658, 4.6068897);
        ((GeneralPath) shape).curveTo(18.105064, 2.0373514, 19.701118, -0.14092655, 21.89247, 0.007074227);
        ((GeneralPath) shape).lineTo(37.96748, 0.26457953);
        ((GeneralPath) shape).lineTo(40.110107, 9.11669);
        ((GeneralPath) shape).curveTo(41.12265, 9.5020075, 41.839123, 10.48171, 41.843586, 11.633518);
        ((GeneralPath) shape).lineTo(42.207935, 116.07766);
        ((GeneralPath) shape).curveTo(42.213734, 117.57334, 41.092587, 118.7773, 39.59741, 118.78309);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);

        // _0_0_1_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(40.073715, 118.13966);
        ((GeneralPath) shape).lineTo(33.02569, 118.1707);
        ((GeneralPath) shape).lineTo(31.791027, 117.87105);
        ((GeneralPath) shape).lineTo(30.780554, 118.251);
        ((GeneralPath) shape).lineTo(23.018883, 118.33211);
        ((GeneralPath) shape).curveTo(21.523705, 118.33791, 20.231045, 117.12113, 20.225245, 115.62544);
        ((GeneralPath) shape).lineTo(18.494036, 106.82908);
        ((GeneralPath) shape).lineTo(18.115688, 6.8455024);
        ((GeneralPath) shape).curveTo(18.312927, 8.383338, 21.522007, 11.885279, 23.373217, 11.961927);
        ((GeneralPath) shape).lineTo(41.210255, 12.067765);
        ((GeneralPath) shape).curveTo(39.076324, 46.615295, 39.916267, 82.154785, 40.073715, 118.13966);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(4.518199920654297, 41.23689270019531), new Point2D.Double(18.82662582397461, 38.015541076660156), new float[]{0, 0.18531764f, 0.28106508f, 0.4512686f, 0.4794048f, 0.65610015f, 1}, new Color[]{new Color(0xFFFFFF, true), new Color(0xFFFFFF, true), new Color(0x56FFFFFF, true), new Color(0x2BFFFFFF, true), new Color(0xFFFFFF, true), new Color(0x4EFFFFFF, true), new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(2.786016f, -0.548687f, -0.5485f, -2.786966f, 22.1002f, 169.2658f)));
        g.fill(shape);

        // _0_0_1_0_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(108.94084, 9.347689);
        ((GeneralPath) shape).lineTo(107.71864, 3.022683);
        ((GeneralPath) shape).lineTo(22.621208, 2.377771);
        ((GeneralPath) shape).curveTo(19.231724, 2.1488717, 19.86448, 9.076888, 23.69603, 9.041723);
        ((GeneralPath) shape).lineTo(108.94084, 9.347689);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(32.43852233886719, 40), new Point2D.Double(33.05025100708008, 42.76342010498047), new float[]{0, 1}, new Color[]{new Color(0x626262), new Color(0xEFEFEF)}, NO_CYCLE, SRGB, new AffineTransform(2.934016f, -0.577836f, -0.577639f, -2.935016f, 20.8843f, 149.7862f)));
        g.fill(shape);

        // _0_0_1_0_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.9749, 0.33629793);
        ((GeneralPath) shape).lineTo(108.61904, 0.63114023);
        ((GeneralPath) shape).curveTo(110.61979, 0.62339085, 112.21571, 2.2145953, 112.36535, 4.1806736);
        ((GeneralPath) shape).curveTo(111.8662, 2.6754959, 110.46956, 1.5418605, 108.79954, 1.5483462);
        ((GeneralPath) shape).lineTo(37.983673, 1.22777);
        ((GeneralPath) shape).lineTo(37.9749, 0.33629793);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x79000000, true));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.4918033f * origAlpha));

        // _0_0_1_0_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(38.029182, 0.51766706);
        ((GeneralPath) shape).lineTo(108.72142, 0.9714554);
        ((GeneralPath) shape).curveTo(110.7222, 0.96370596, 112.31811, 2.5548894, 112.46775, 4.520978);
        ((GeneralPath) shape).curveTo(111.96861, 3.01579, 110.57195, 1.8821547, 108.90196, 1.8886509);
        ((GeneralPath) shape).lineTo(38.293697, 1.6203779);
        ((GeneralPath) shape).lineTo(38.029182, 0.51766706);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(4.910700798034668, 44.64933395385742), new Point2D.Double(58.88479232788086, 36.86613082885742), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(2.934016f, -0.577836f, -0.577639f, -2.935016f, 19.22635f, 140.5151f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.34426227f * origAlpha));

        // _0_0_1_0_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(38.026585, 0.5230561);
        ((GeneralPath) shape).lineTo(108.72142, 0.8670162);
        ((GeneralPath) shape).curveTo(110.7222, 0.85926676, 112.31811, 2.4504502, 112.46775, 4.416539);
        ((GeneralPath) shape).curveTo(111.96861, 2.9113507, 110.45915, 1.2044697, 108.78912, 1.2109553);
        ((GeneralPath) shape).lineTo(38.18084, 1.1846523);
        ((GeneralPath) shape).lineTo(38.026585, 0.5230561);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(4.910700798034668, 44.64933395385742), new Point2D.Double(58.88479232788086, 36.86613082885742), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(2.934016f, -0.577836f, -0.577639f, -2.935016f, 19.22635f, 140.4106f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.397541f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.043191f, -0.121063f, -0.121022f, -1.043547f, 2.311089f, 132.8239f));

        // _0_0_1_0_8
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_1_0_8_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(30.625, 118.75);
        ((GeneralPath) shape).curveTo(32.625, 118.75, 114.11742, 108.58839, 114.11742, 108.58839);

        g.setPaint(new LinearGradientPaint(new Point2D.Double(74.0625, 85.125), new Point2D.Double(108.0625, 126.0625), new float[]{0, 1}, new Color[]{BLACK, WHITE}, NO_CYCLE, SRGB, new AffineTransform()));
        g.setStroke(new BasicStroke(0.1f, 0, 0, 4));
        g.draw(shape);

        // _0_0_1_0_8_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(31.066942, 117.61742);
        ((GeneralPath) shape).curveTo(33.06694, 117.61742, 114.25, 107.5, 114.25, 107.5);

        g.setPaint(new LinearGradientPaint(new Point2D.Double(39.8125, 79.125), new Point2D.Double(45.3125, 138.875), new float[]{0, 1}, new Color[]{BLACK, WHITE}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 0, -1)));
        g.draw(shape);

        // _0_0_1_0_8_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(31.46469, 116.79419);
        ((GeneralPath) shape).curveTo(33.464687, 116.79419, 114.25, 106.5, 114.25, 106.5);

        g.setPaint(new LinearGradientPaint(new Point2D.Double(34.5625, 99.375), new Point2D.Double(44.0625, 125.125), new float[]{0, 1}, new Color[]{BLACK, WHITE}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 0, -2)));
        g.draw(shape);

        // _0_0_1_0_8_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(31.332108, 119.81742);
        ((GeneralPath) shape).curveTo(33.332108, 119.81742, 114.02903, 109.7, 114.02903, 109.7);

        g.setPaint(new LinearGradientPaint(new Point2D.Double(82.3125, 61.875), new Point2D.Double(36.3125, 128.3125), new float[]{0, 1}, new Color[]{BLACK, WHITE}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 0, 0.7f)));
        g.draw(shape);

        // _0_0_1_0_8_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(31.906631, 115.81742);
        ((GeneralPath) shape).curveTo(33.90663, 115.81742, 114.02903, 105.7, 114.02903, 105.7);

        g.setPaint(new LinearGradientPaint(new Point2D.Double(82.3125, 61.875), new Point2D.Double(72.32701873779297, 133.3125), new float[]{0, 1}, new Color[]{BLACK, WHITE}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 0, -3.3f)));
        g.draw(shape);

        // _0_0_1_0_8_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(32.039215, 120.90581);
        ((GeneralPath) shape).curveTo(34.039215, 120.90581, 114.02903, 110.7, 114.02903, 110.7);

        g.setPaint(new LinearGradientPaint(new Point2D.Double(82.3125, 61.875), new Point2D.Double(72.32701873779297, 133.3125), new float[]{0, 1}, new Color[]{BLACK, WHITE}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 0, 1.7f)));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_1_0_8
        g.setComposite(AlphaComposite.getInstance(3, 0.69f * origAlpha));

        // _0_0_1_0_9
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.9749, 0.33629793);
        ((GeneralPath) shape).lineTo(108.61904, 0.63114023);
        ((GeneralPath) shape).curveTo(110.61979, 0.62339085, 112.21571, 2.2145953, 112.36535, 4.1806736);
        ((GeneralPath) shape).curveTo(111.81315, 2.042845, 110.3244, 1.0464218, 108.65441, 1.052918);
        ((GeneralPath) shape).lineTo(38.0402, 0.7450521);
        ((GeneralPath) shape).lineTo(37.9749, 0.33629793);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x79000000, true));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_1_0_10
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(108.94084, 9.347689);
        ((GeneralPath) shape).lineTo(107.71864, 3.022683);
        ((GeneralPath) shape).lineTo(22.621208, 2.377771);
        ((GeneralPath) shape).curveTo(19.231724, 2.1488717, 19.86448, 9.076888, 23.69603, 9.041723);
        ((GeneralPath) shape).lineTo(108.94084, 9.347689);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(15.21379280090332, 58.93998718261719), new Point2D.Double(14.701934814453125, 56.03254318237305), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(2.786016f, -0.548687f, -0.5485f, -2.786966f, 22.1002f, 169.2658f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.42213118f * origAlpha));

        // _0_0_1_0_11
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(19.836546, 7.501746);
        ((GeneralPath) shape).curveTo(20.011478, 8.242209, 21.550035, 9.737633, 22.022102, 9.875837);
        ((GeneralPath) shape).curveTo(27.863579, 9.841164, 33.705055, 9.806511, 39.54653, 9.771847);
        ((GeneralPath) shape).curveTo(39.562763, 10.160664, 39.579, 10.549501, 39.595234, 10.938339);
        ((GeneralPath) shape).curveTo(33.660984, 10.961127, 27.726727, 10.983895, 21.792477, 11.006684);
        ((GeneralPath) shape).curveTo(21.093756, 11.063029, 20.058064, 8.594901, 19.836546, 7.501746);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(15.6875, 48.890625), new Point2D.Double(16.25, 54.984375), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(2.786016f, -0.548687f, -0.5485f, -2.786966f, 22.1002f, 169.2658f)));
        g.fill(shape);

        // _0_0_1_0_12
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(19.836546, 7.501746);
        ((GeneralPath) shape).curveTo(20.011478, 8.242209, 22.054174, 9.862249, 22.526245, 10.000444);
        ((GeneralPath) shape).curveTo(28.367722, 9.96578, 33.38464, 9.965571, 39.226112, 9.930898);
        ((GeneralPath) shape).curveTo(39.242348, 10.319735, 39.161716, 10.474023, 39.17795, 10.862861);
        ((GeneralPath) shape).curveTo(33.243702, 10.885649, 29.197342, 10.746463, 22.780819, 10.806557);
        ((GeneralPath) shape).curveTo(21.007717, 10.823153, 20.058064, 8.594901, 19.836546, 7.501746);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(15.6875, 48.890625), new Point2D.Double(16.75346565246582, 55.4375), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(2.786016f, -0.548687f, -0.5485f, -2.786966f, 22.1002f, 169.2658f)));
        g.fill(shape);

        // _0_0_1_0_13
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(19.836546, 7.501746);
        ((GeneralPath) shape).curveTo(19.97353, 7.470362, 20.114796, 7.900046, 20.306814, 8.182366);
        ((GeneralPath) shape).curveTo(20.861965, 8.9986, 21.825659, 10.037958, 22.80328, 9.945895);
        ((GeneralPath) shape).curveTo(28.644754, 9.911232, 33.38464, 9.965571, 39.226112, 9.930898);
        ((GeneralPath) shape).curveTo(39.242348, 10.319735, 39.075336, 10.264884, 39.091568, 10.6537);
        ((GeneralPath) shape).curveTo(33.15732, 10.676499, 28.675852, 10.445135, 22.741602, 10.467924);
        ((GeneralPath) shape).curveTo(21.513788, 10.423652, 20.516518, 9.301212, 20.05413, 8.299358);
        ((GeneralPath) shape).curveTo(19.919855, 8.008423, 19.750055, 7.5145087, 19.836546, 7.501746);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(5.323966026306152, 55.6302375793457), new Point2D.Double(16.25, 54.984375), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(2.786016f, -0.548687f, -0.5485f, -2.786966f, 22.1002f, 169.2658f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.36885244f * origAlpha));

        // _0_0_1_0_14
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(30.384054, 118.3042);
        ((GeneralPath) shape).lineTo(31.17758, 9.240585);
        ((GeneralPath) shape).lineTo(32.447884, 9.261807);
        ((GeneralPath) shape).lineTo(31.38562, 117.99387);
        ((GeneralPath) shape).lineTo(30.384054, 118.3042);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(6.28125, 35.763671875), new Point2D.Double(14.3125, 35.763671875), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(2.786016f, -0.548687f, -0.5485f, -2.786966f, 22.1002f, 169.2658f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_1_0_15
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(40.012936, 113.99218);
        ((GeneralPath) shape).lineTo(32.964912, 114.02321);
        ((GeneralPath) shape).lineTo(31.730247, 113.72357);
        ((GeneralPath) shape).lineTo(30.719774, 114.10352);
        ((GeneralPath) shape).lineTo(22.958107, 114.18463);
        ((GeneralPath) shape).curveTo(21.462927, 114.19043, 20.170265, 112.97364, 20.164469, 111.47796);
        ((GeneralPath) shape).lineTo(18.433258, 102.6816);
        ((GeneralPath) shape).lineTo(18.115688, 6.8455024);
        ((GeneralPath) shape).curveTo(18.312927, 8.383338, 20.74035, 11.975243, 23.373217, 11.961927);
        ((GeneralPath) shape).lineTo(41.210255, 12.067765);
        ((GeneralPath) shape).curveTo(39.076324, 46.615295, 39.85549, 78.0073, 40.012936, 113.99218);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(20.606983184814453, 54.213417053222656), new Point2D.Double(14.043750762939453, 16.4375), new float[]{0, 0.25f, 0.5f, 1}, new Color[]{BLACK, new Color(0x99000000, true), new Color(0x47000000, true), new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(2.786016f, -0.548687f, -0.5485f, -2.786966f, 22.1002f, 169.2658f)));
        g.fill(shape);

        // _0_0_1_0_16
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(39.353256, 118.79322);
        ((GeneralPath) shape).lineTo(39.645996, 9.063446);
        ((GeneralPath) shape).lineTo(110.25722, 9.364429);
        ((GeneralPath) shape).curveTo(112.35481, 9.356283, 114.00183, 11.084272, 114.00999, 13.18256);
        ((GeneralPath) shape).lineTo(111.52929, 114.85415);
        ((GeneralPath) shape).curveTo(111.53745, 116.95245, 109.9035, 118.59968, 107.80591, 118.60781);
        ((GeneralPath) shape).lineTo(39.353256, 118.79322);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(92.14599609375, -60.18733596801758), new Point2D.Double(59.40861129760742, 214.4730224609375), new float[]{0.15f, 0.316f, 0.6029f, 0.8412f, 1}, new Color[]{new Color(0x80B3FF), new Color(0x69A1F0), new Color(0x4888DA), new Color(0x3378CC), new Color(0x2C72C7)}, NO_CYCLE, SRGB, new AffineTransform(1.006832f, -0.116842f, -0.116803f, -1.007175f, 4.589781f, 131.0035f)));
        g.fill(shape);

        // _0_0_1_0_17
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(39.632874, 9.085295);
        ((GeneralPath) shape).lineTo(110.27699, 9.380158);
        ((GeneralPath) shape).curveTo(112.27777, 9.372398, 113.87366, 10.963592, 114.02331, 12.929671);
        ((GeneralPath) shape).curveTo(113.5242, 11.424493, 112.12751, 10.290858, 110.45749, 10.297343);
        ((GeneralPath) shape).lineTo(39.641647, 9.976768);
        ((GeneralPath) shape).lineTo(39.632874, 9.085295);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x79000000, true));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.4918033f * origAlpha));

        // _0_0_1_0_18
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(39.687157, 9.78885);
        ((GeneralPath) shape).lineTo(110.3794, 10.242648);
        ((GeneralPath) shape).curveTo(112.38018, 10.23491, 113.97609, 11.826103, 114.12571, 13.792182);
        ((GeneralPath) shape).curveTo(113.62662, 12.286983, 112.22992, 11.153369, 110.55992, 11.159844);
        ((GeneralPath) shape).lineTo(39.64898, 11.211677);
        ((GeneralPath) shape).lineTo(39.687157, 9.78885);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(4.910700798034668, 44.64933395385742), new Point2D.Double(58.88479232788086, 36.86613082885742), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(2.934016f, -0.577836f, -0.577639f, -2.935016f, 20.8843f, 149.7862f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_1_0_19
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(39.555393, 118.1661);
        ((GeneralPath) shape).curveTo(38.44565, 118.15123, 37.555614, 69.45076, 37.63304, 9.305015);
        ((GeneralPath) shape).lineTo(41.722317, 9.35983);
        ((GeneralPath) shape).curveTo(41.62871, 69.50535, 40.665142, 118.18097, 39.555393, 118.1661);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(-36.857940673828125, 75.2253189086914), 0.9722718f, new Point2D.Double(-36.857940673828125, 75.2253189086914), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(0.988591f, 0.01835001f, 1.495426f, -112.7499f, -36.37488f, 8490.872f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.34426227f * origAlpha));

        // _0_0_1_0_20
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(39.435696, 10.046167);
        ((GeneralPath) shape).lineTo(110.3794, 10.242648);
        ((GeneralPath) shape).curveTo(112.38018, 10.23491, 113.97609, 11.826103, 114.12571, 13.792182);
        ((GeneralPath) shape).curveTo(113.62662, 12.286983, 112.1171, 10.580123, 110.4471, 10.586609);
        ((GeneralPath) shape).lineTo(39.40643, 10.658818);
        ((GeneralPath) shape).lineTo(39.435696, 10.046167);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(4.910700798034668, 44.64933395385742), new Point2D.Double(58.88479232788086, 36.86613082885742), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(2.934016f, -0.577836f, -0.577639f, -2.935016f, 20.8843f, 149.7862f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_1_0_21
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(39.353256, 118.79322);
        ((GeneralPath) shape).lineTo(39.645996, 9.063446);
        ((GeneralPath) shape).lineTo(110.25722, 9.364429);
        ((GeneralPath) shape).curveTo(112.35481, 9.356283, 114.00183, 11.084272, 114.00999, 13.18256);
        ((GeneralPath) shape).lineTo(111.52929, 114.85415);
        ((GeneralPath) shape).curveTo(111.53745, 116.95245, 109.9035, 118.59968, 107.80591, 118.60781);
        ((GeneralPath) shape).lineTo(39.353256, 118.79322);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(68.23580932617188, 120.29424285888672), new Point2D.Double(70.71067810058594, 86.63424682617188), new float[]{0, 1}, new Color[]{new Color(0x4686D8), new Color(0x4686D8, true)}, NO_CYCLE, SRGB, new AffineTransform(1.044036f, 0, 0, 1.044392f, -0.789623f, -6.841119f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.34426227f * origAlpha));

        // _0_0_1_0_22
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(39.825836, 9.910678);
        ((GeneralPath) shape).lineTo(110.3794, 10.242648);
        ((GeneralPath) shape).curveTo(112.38018, 10.23491, 113.97609, 11.826103, 114.12571, 13.792182);
        ((GeneralPath) shape).curveTo(113.62662, 12.286983, 112.21223, 10.942475, 110.54222, 10.94895);
        ((GeneralPath) shape).lineTo(39.827972, 10.853983);
        ((GeneralPath) shape).lineTo(39.825836, 9.910678);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(4.910700798034668, 44.64933395385742), new Point2D.Double(58.88479232788086, 36.86613082885742), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(2.934016f, -0.577836f, -0.577639f, -2.935016f, 20.8843f, 149.7862f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_1_0_23
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(39.632874, 9.085295);
        ((GeneralPath) shape).lineTo(110.27699, 9.380158);
        ((GeneralPath) shape).curveTo(112.27777, 9.372398, 113.87366, 10.963592, 114.02331, 12.929671);
        ((GeneralPath) shape).curveTo(113.47111, 10.791842, 111.98241, 9.795419, 110.3124, 9.801915);
        ((GeneralPath) shape).lineTo(39.69817, 9.494039);
        ((GeneralPath) shape).lineTo(39.632874, 9.085295);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x79000000, true));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.34836066f * origAlpha));

        // _0_0_1_0_24
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(108.51772, 118.58356);
        ((GeneralPath) shape).curveTo(108.27231, 118.63348, 107.97922, 118.64977, 107.71701, 118.65079);
        ((GeneralPath) shape).lineTo(39.338734, 118.80491);
        ((GeneralPath) shape).lineTo(39.292606, 118.22594);
        ((GeneralPath) shape).lineTo(107.61417, 118.12823);
        ((GeneralPath) shape).curveTo(109.71174, 118.12009, 111.39269, 116.40805, 111.38455, 114.30975);
        ((GeneralPath) shape).lineTo(111.50452, 114.91941);
        ((GeneralPath) shape).curveTo(111.51166, 116.75542, 110.23559, 118.23413, 108.51772, 118.58356);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_1_0_25
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(104.20386, 93.26027);
        ((GeneralPath) shape).curveTo(100.78681, 90.0599, 97.38536, 86.84215, 94.139694, 83.46583);
        ((GeneralPath) shape).curveTo(85.29333, 73.84393, 77.16345, 63.606102, 70.40126, 52.38746);
        ((GeneralPath) shape).curveTo(66.72051, 46.2764, 63.300484, 40.02529, 59.890846, 33.769882);
        ((GeneralPath) shape).curveTo(54.04496, 26.921272, 48.14362, 20.121471, 42.17667, 13.375752);
        ((GeneralPath) shape).curveTo(41.44724, 12.538932, 40.72594, 11.688942, 40.0, 10.842182);
        ((GeneralPath) shape).lineTo(42.20112, 10.855802);
        ((GeneralPath) shape).curveTo(43.10583, 11.978642, 44.01216, 13.098862, 44.9205, 14.216032);
        ((GeneralPath) shape).curveTo(49.07826, 19.239841, 53.25359, 24.250452, 57.428604, 29.260124);
        ((GeneralPath) shape).curveTo(54.9958, 24.811863, 52.53616, 20.374962, 49.96467, 16.000221);
        ((GeneralPath) shape).curveTo(49.23548, 14.873742, 47.13762, 12.480172, 46.08123, 10.869862);
        ((GeneralPath) shape).lineTo(49.2627, 10.882562);
        ((GeneralPath) shape).curveTo(50.7349, 12.402392, 51.52832, 14.440042, 52.97088, 16.970652);
        ((GeneralPath) shape).curveTo(56.01325, 22.984262, 59.03808, 28.996885, 62.170895, 34.95043);
        ((GeneralPath) shape).curveTo(66.401825, 40.023224, 70.63223, 45.094776, 74.85595, 50.17362);
        ((GeneralPath) shape).curveTo(84.095894, 61.421486, 93.61012, 72.46104, 104.84942, 81.693504);
        ((GeneralPath) shape).lineTo(104.78751, 82.76829);
        ((GeneralPath) shape).curveTo(92.905785, 73.1652, 83.056435, 61.46563, 73.33557, 49.707764);
        ((GeneralPath) shape).curveTo(70.33583, 46.11347, 67.32659, 42.5282, 64.30138, 38.956215);
        ((GeneralPath) shape).curveTo(66.85001, 43.69121, 69.485054, 48.381607, 72.2764, 52.994404);
        ((GeneralPath) shape).curveTo(79.202126, 64.31333, 87.55414, 74.59831, 96.64803, 84.220634);
        ((GeneralPath) shape).curveTo(99.101006, 86.768684, 101.67316, 89.193016, 104.29751, 91.56122);
        ((GeneralPath) shape).lineTo(104.20386, 93.26027);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(105.64151, 67.46245);
        ((GeneralPath) shape).curveTo(103.67191, 62.04477, 101.45583, 56.719696, 98.870445, 51.53559);
        ((GeneralPath) shape).curveTo(93.07028, 39.33467, 87.219124, 27.117292, 80.24413, 15.532802);
        ((GeneralPath) shape).curveTo(79.34013, 14.106092, 77.29306, 11.989322, 76.77715, 11.000792);
        ((GeneralPath) shape).lineTo(78.45714, 11.009792);
        ((GeneralPath) shape).curveTo(78.933044, 11.238272, 79.51208, 11.540212, 80.22149, 11.933392);
        ((GeneralPath) shape).lineTo(78.58276, 11.008222);
        ((GeneralPath) shape).lineTo(79.416084, 11.011342);
        ((GeneralPath) shape).curveTo(81.37728, 12.142322, 81.85421, 13.666342, 83.44962, 16.575592);
        ((GeneralPath) shape).curveTo(89.5688, 28.154282, 94.96803, 40.097366, 100.34672, 52.032604);
        ((GeneralPath) shape).curveTo(102.42881, 56.337368, 104.198, 60.75815, 105.76265, 65.25245);
        ((GeneralPath) shape).lineTo(105.64151, 67.46245);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(52.98485565185547, 68.39021301269531), new Point2D.Double(113.2191162109375, 49.39021301269531), new float[]{0, 1}, new Color[]{new Color(0xA4C0E4), new Color(0xA4C0E4, true)}, NO_CYCLE, SRGB, new AffineTransform(1.043191f, -0.121063f, -0.121022f, -1.043547f, -1.85471f, 132.9629f)));
        g.fill(shape);

        // _0_0_1_0_26
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-85.48819, -85.083786);
        ((GeneralPath) shape).lineTo(-85.48819, -88.002556);
        ((GeneralPath) shape).lineTo(-85.48819, -85.083786);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xC1FFFFFF, true));
        g.fill(shape);

        // _0_0_1_0_27
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(18.266323, 93.74718);
        ((GeneralPath) shape).lineTo(18.358604, 107.54784);
        ((GeneralPath) shape).lineTo(20.250357, 116.87135);
        ((GeneralPath) shape).lineTo(21.173162, 118.11756);
        ((GeneralPath) shape).lineTo(23.3879, 118.57912);
        ((GeneralPath) shape).lineTo(30.770348, 118.53297);
        ((GeneralPath) shape).lineTo(31.324032, 118.30219);
        ((GeneralPath) shape).lineTo(39.121742, 118.53297);
        ((GeneralPath) shape).lineTo(39.260162, 93.97796);
        ((GeneralPath) shape).lineTo(18.266323, 93.74718);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(28.94718360900879, 125.89598083496094), new Point2D.Double(28.94718360900879, 104.95532989501953), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(1.044036f, 0, 0, 1.044392f, -0.789623f, -6.841119f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.34836066f * origAlpha));

        // _0_0_1_0_28
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(108.51772, 118.58356);
        ((GeneralPath) shape).curveTo(108.27231, 118.63348, 107.97922, 118.64977, 107.71701, 118.65079);
        ((GeneralPath) shape).lineTo(39.338734, 118.80491);
        ((GeneralPath) shape).lineTo(39.292606, 117.70374);
        ((GeneralPath) shape).lineTo(107.61417, 117.60603);
        ((GeneralPath) shape).curveTo(109.71174, 117.5979, 111.39269, 116.40805, 111.38455, 114.30975);
        ((GeneralPath) shape).lineTo(111.50452, 114.91941);
        ((GeneralPath) shape).curveTo(111.51166, 116.75542, 110.23559, 118.23413, 108.51772, 118.58356);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.86f * origAlpha));

        // _0_0_1_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(97.49459, 42.026714);
        ((GeneralPath) shape).curveTo(97.49454, 47.318436, 93.77078, 52.904076, 86.323296, 58.78366);
        ((GeneralPath) shape).curveTo(79.58129, 63.879375, 76.03391, 71.307304, 75.68116, 81.06746);
        ((GeneralPath) shape).lineTo(72.80015, 81.06746);
        ((GeneralPath) shape).curveTo(72.25136, 70.75854, 75.15197, 62.233086, 81.502, 55.49107);
        ((GeneralPath) shape).curveTo(86.32326, 50.160255, 88.6947, 45.672142, 88.61634, 42.026714);
        ((GeneralPath) shape).curveTo(88.6163, 37.32307, 86.793625, 33.638508, 83.1483, 30.973003);
        ((GeneralPath) shape).curveTo(80.60042, 29.130798, 77.68021, 28.209656, 74.38765, 28.209585);
        ((GeneralPath) shape).curveTo(69.9583, 28.680025, 66.7441, 30.032335, 64.74505, 32.26652);
        ((GeneralPath) shape).curveTo(62.393185, 34.73604, 61.824818, 36.75471, 63.039955, 38.322544);
        ((GeneralPath) shape).curveTo(64.41185, 39.655327, 65.09782, 41.046837, 65.097824, 42.497086);
        ((GeneralPath) shape).curveTo(65.01942, 44.457016, 64.33346, 46.024918, 63.039955, 47.200787);
        ((GeneralPath) shape).curveTo(61.472042, 48.337566, 59.962933, 48.905933, 58.512638, 48.905884);
        ((GeneralPath) shape).curveTo(55.65121, 48.905933, 53.632545, 47.240047, 52.456623, 43.908195);
        ((GeneralPath) shape).curveTo(52.064644, 42.771523, 51.86866, 41.791584, 51.86866, 40.96838);
        ((GeneralPath) shape).curveTo(51.86866, 36.578323, 53.94613, 32.834957, 58.101067, 29.73828);
        ((GeneralPath) shape).curveTo(62.45198, 26.52416, 67.88084, 24.917063, 74.38765, 24.916992);
        ((GeneralPath) shape).curveTo(81.67835, 24.917063, 87.55798, 26.857346, 92.026535, 30.737823);
        ((GeneralPath) shape).curveTo(95.67186, 33.952087, 97.49454, 37.71505, 97.49459, 42.026714);
        ((GeneralPath) shape).moveTo(81.3844, 95.70773);
        ((GeneralPath) shape).curveTo(81.22758, 99.07873, 79.83607, 101.29339, 77.20987, 102.35172);
        ((GeneralPath) shape).curveTo(76.2691, 102.74368, 75.249954, 102.93968, 74.15246, 102.93968);
        ((GeneralPath) shape).curveTo(70.78145, 102.93968, 68.54719, 101.46977, 67.44968, 98.52996);
        ((GeneralPath) shape).curveTo(67.09688, 97.628426, 66.92049, 96.68768, 66.92051, 95.70773);
        ((GeneralPath) shape).curveTo(66.92049, 92.68954, 68.03762, 90.61207, 70.2719, 89.47533);
        ((GeneralPath) shape).curveTo(71.36941, 88.926575, 72.662926, 88.6522, 74.15246, 88.652176);
        ((GeneralPath) shape).curveTo(78.30737, 88.6522, 80.67882, 90.59247, 81.266815, 94.473015);
        ((GeneralPath) shape).curveTo(81.30597, 94.865005, 81.34518, 95.27657, 81.3844, 95.70773);

        g.setPaint(WHITE);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_1

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
    public HelpContents5() {
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

