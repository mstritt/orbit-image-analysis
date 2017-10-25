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
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

import static java.awt.Color.*;
import static java.awt.MultipleGradientPaint.ColorSpaceType.SRGB;
import static java.awt.MultipleGradientPaint.CycleMethod.NO_CYCLE;
import static java.awt.MultipleGradientPaint.CycleMethod.REFLECT;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class ColorFill implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.setComposite(AlphaComposite.getInstance(3, 0.7f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.8684763f, 0.49573076f, -0.49573076f, -0.8684763f, 0, 0));

        // _0_0_0
        shape = new Ellipse2D.Double(15.160582542419434, -83.19001007080078, 21.14337730407715, 21.14337730407715);
        g.setPaint(new Color(0x99FF00));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0

        // _0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(126.20027, 79.1128);
        ((GeneralPath) shape).curveTo(124.6614, 84.74488, 118.84343, 88.0658, 113.20982, 86.52781);
        ((GeneralPath) shape).curveTo(107.58256, 84.99025, 104.26163, 79.17229, 105.79896, 73.54109);
        ((GeneralPath) shape).curveTo(107.33783, 67.90901, 113.1558, 64.58808, 118.78613, 66.12389);
        ((GeneralPath) shape).curveTo(124.41843, 67.66669, 127.73694, 73.484, 126.20027, 79.1128);
        ((GeneralPath) shape).closePath();

        g.setPaint(RED);
        g.fill(shape);

        // _0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(23.98635, 51.18981);
        ((GeneralPath) shape).curveTo(22.44573, 56.81882, 16.63018, 60.1404, 11.0005, 58.60219);
        ((GeneralPath) shape).curveTo(5.36689, 57.0642, 2.0475, 51.24536, 3.58637, 45.61328);
        ((GeneralPath) shape).curveTo(5.12458, 39.98361, 10.94101, 36.66356, 16.57375, 38.20002);
        ((GeneralPath) shape).curveTo(22.20429, 39.73976, 25.52522, 45.55773, 23.98635, 51.18981);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x00CC00));
        g.fill(shape);

        // _0_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(118.82027, 59.12623);
        ((GeneralPath) shape).curveTo(113.17321, 60.61471, 107.39166, 57.23735, 105.9071, 51.59006);
        ((GeneralPath) shape).curveTo(104.4241, 45.9419, 107.79993, 40.16122, 113.44743, 38.68062);
        ((GeneralPath) shape).curveTo(119.09692, 37.19279, 124.87913, 40.56775, 126.35929, 46.2216);
        ((GeneralPath) shape).curveTo(127.84383, 51.86888, 124.46778, 57.64562, 118.82027, 59.12623);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xCC0099));
        g.fill(shape);

        // _0_0_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(35.05385, 32.23453);
        ((GeneralPath) shape).curveTo(30.90544, 36.34142, 24.21065, 36.31114, 20.10267, 32.15725);
        ((GeneralPath) shape).curveTo(15.99338, 28.00819, 16.02629, 21.31799, 20.17076, 17.21132);
        ((GeneralPath) shape).curveTo(24.32267, 13.09634, 31.01702, 13.13297, 35.12631, 17.28204);
        ((GeneralPath) shape).curveTo(39.23714, 21.43023, 39.20358, 28.12283, 35.05385, 32.23453);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x009999));
        g.fill(shape);

        // _0_0_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(109.9776, 32.59823);
        ((GeneralPath) shape).curveTo(105.82526, 36.70533, 99.13528, 36.67636, 95.02423, 32.52423);
        ((GeneralPath) shape).curveTo(90.91669, 28.37823, 90.95004, 21.68169, 95.10304, 17.57218);
        ((GeneralPath) shape).curveTo(99.24992, 13.46617, 105.94077, 13.49667, 110.04766, 17.64507);
        ((GeneralPath) shape).curveTo(114.16418, 21.79611, 114.13083, 28.49266, 109.9776, 32.59823);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x660099));
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.8684763f, 0.49573076f, -0.49573076f, -0.8684763f, 0, 0));

        // _0_0_6
        shape = new Ellipse2D.Double(-49.730377197265625, -45.73215866088867, 21.14690399169922, 21.14690399169922);
        g.setPaint(new Color(0x0033CC));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_6

        // _0_0_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(89.05962, 14.04566);
        ((GeneralPath) shape).curveTo(87.51987, 19.67621, 81.70103, 22.9956, 76.0707, 21.4598);
        ((GeneralPath) shape).curveTo(70.44016, 19.92006, 67.11923, 14.10209, 68.65657, 8.470885);
        ((GeneralPath) shape).curveTo(70.19631, 2.840337, 76.01427, -0.480587, 81.64548, 1.056748);
        ((GeneralPath) shape).curveTo(87.27449, 2.597364, 90.59695, 8.414458, 89.05962, 14.04566);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x330099));
        g.fill(shape);

        // _0_0_8

        // _0_0_9
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.8684763f, 0.49573076f, -0.49573076f, -0.8684763f, 0, 0));

        // _0_0_10

        g.setTransform(transformations.poll()); // _0_0_10

        // _0_0_11
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.8684763f, 0.49573076f, -0.49573076f, -0.8684763f, 0, 0));

        // _0_0_12

        g.setTransform(transformations.poll()); // _0_0_12
        g.setComposite(AlphaComposite.getInstance(3, 0.37704918f * origAlpha));

        // _0_0_13
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(15.373706, 125.69402);
        ((GeneralPath) shape).curveTo(22.221464, 125.74933, 27.996107, 124.98911, 29.405975, 125.0239);
        ((GeneralPath) shape).curveTo(38.73244, 125.25394, 61.07722, 120.9265, 52.14107, 115.60666);
        ((GeneralPath) shape).curveTo(42.378445, 109.79479, 15.545252, 109.95091, 5.0973773, 115.55487);
        ((GeneralPath) shape).curveTo(-6.30459, 121.67058, 8.527061, 125.63869, 15.373706, 125.69402);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(29.962148666381836, 131.46768188476562), 27.01967f, new Point2D.Double(29.962148666381836, 131.46768188476562), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(0.709744f, -0.0162743f, 0.003676083f, 0.160321f, 7.971984f, 102.5261f)));
        g.fill(shape);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(27.56598472595215, 130.94268798828125), 27.01967f, new Point2D.Double(27.56598472595215, 130.94268798828125), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 0.280337f, 0, 85.27881f)));
        g.setStroke(new BasicStroke(2.152f, 0, 0, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.3647541f * origAlpha));

        // _0_0_14
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(127.69448, 121.47017);
        ((GeneralPath) shape).curveTo(127.69448, 125.07649, 99.1091, 128.0, 63.84724, 128.0);
        ((GeneralPath) shape).curveTo(28.585382, 128.0, 7.1054274E-15, 125.07649, 0.0, 121.47017);
        ((GeneralPath) shape).curveTo(0.0, 117.863846, 28.585382, 114.94034, 63.84724, 114.94034);
        ((GeneralPath) shape).curveTo(99.1091, 114.94034, 127.69448, 117.863846, 127.69448, 121.47017);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(63.84724044799805, 121.47016906738281), 63.84724f, new Point2D.Double(95.48064422607422, 121.47016906738281), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 0.102273f, 0, 109.0471f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_15

        // _0_0_16
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_17
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-300.30743, -39.677948);
        ((GeneralPath) shape).lineTo(-300.30743, -42.472656);
        ((GeneralPath) shape).lineTo(-300.30743, -39.677948);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xC1FFFFFF, true));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.25f * origAlpha));

        // _0_0_18
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(86.08322, 14.267693);
        ((GeneralPath) shape).curveTo(90.98215, 22.989826, 116.60724, 68.61337, 121.50614, 77.3355);
        ((GeneralPath) shape).curveTo(126.40506, 86.05764, 115.66144, 101.33267, 97.519325, 111.43471);
        ((GeneralPath) shape).curveTo(79.37719, 121.53674, 60.68177, 122.65416, 55.782852, 113.93203);
        ((GeneralPath) shape).curveTo(50.88395, 105.20991, 25.25885, 59.586353, 20.35992, 50.86422);
        ((GeneralPath) shape).curveTo(15.461006, 42.142094, 26.20462, 26.867058, 44.346764, 16.765024);
        ((GeneralPath) shape).curveTo(62.48889, 6.6629853, 81.184326, 5.545552, 86.08322, 14.267693);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x55000000, true));
        g.setStroke(new BasicStroke(2.9774685f, 1, 1, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.3f * origAlpha));

        // _0_0_19
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(86.08322, 14.267693);
        ((GeneralPath) shape).curveTo(90.98215, 22.989826, 116.60724, 68.61337, 121.50614, 77.3355);
        ((GeneralPath) shape).curveTo(126.40506, 86.05764, 115.66144, 101.33267, 97.519325, 111.43471);
        ((GeneralPath) shape).curveTo(79.37719, 121.53674, 60.68177, 122.65416, 55.782852, 113.93203);
        ((GeneralPath) shape).curveTo(50.88395, 105.20991, 25.25885, 59.586353, 20.35992, 50.86422);
        ((GeneralPath) shape).curveTo(15.461006, 42.142094, 26.20462, 26.867058, 44.346764, 16.765024);
        ((GeneralPath) shape).curveTo(62.48889, 6.6629853, 81.184326, 5.545552, 86.08322, 14.267693);
        ((GeneralPath) shape).closePath();

        g.setStroke(new BasicStroke(1.9849792f, 1, 1, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_20
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(86.07858, 13.960252);
        ((GeneralPath) shape).curveTo(90.97751, 22.682386, 116.60259, 68.30594, 121.5015, 77.02807);
        ((GeneralPath) shape).curveTo(126.40042, 85.7502, 115.65681, 101.02523, 97.51468, 111.12727);
        ((GeneralPath) shape).curveTo(79.37254, 121.2293, 60.677124, 122.34672, 55.77821, 113.62459);
        ((GeneralPath) shape).curveTo(50.879303, 104.90247, 25.254208, 59.278915, 20.355278, 50.556786);
        ((GeneralPath) shape).curveTo(15.456362, 41.834656, 26.199976, 26.55962, 44.34212, 16.457586);
        ((GeneralPath) shape).curveTo(62.484245, 6.3555484, 81.179665, 5.2381215, 86.07858, 13.960252);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(-70.05706787109375, 95.78132629394531), new Point2D.Double(-27.889699935913086, 66.67145538330078), new float[]{0, 0.4259708f, 0.5892781f, 0.8021978f, 1}, new Color[]{WHITE, WHITE, new Color(0xF1F1F1), new Color(0xEAEAEA), new Color(0xDFDFDF)}, NO_CYCLE, SRGB, new AffineTransform(1.129522f, 0.08477695f, 0.05309184f, 1.206648f, 150.0367f, -10.45332f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.40573773f * origAlpha));

        // _0_0_21
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(86.07858, 13.960252);
        ((GeneralPath) shape).curveTo(90.97751, 22.682386, 116.60259, 68.30594, 121.5015, 77.02807);
        ((GeneralPath) shape).curveTo(126.40042, 85.7502, 115.65681, 101.02523, 97.51468, 111.12727);
        ((GeneralPath) shape).curveTo(79.37254, 121.2293, 60.677124, 122.34672, 55.77821, 113.62459);
        ((GeneralPath) shape).curveTo(50.879303, 104.90247, 25.254208, 59.278915, 20.355278, 50.556786);
        ((GeneralPath) shape).curveTo(15.456362, 41.834656, 26.199976, 26.55962, 44.34212, 16.457586);
        ((GeneralPath) shape).curveTo(62.484245, 6.3555484, 81.179665, 5.2381215, 86.07858, 13.960252);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(70.62369537353516, 53.38029861450195), 53.565186f, new Point2D.Double(70.96444702148438, 76.70208740234375), new float[]{0, 0.5f, 1}, new Color[]{new Color(0xFFFFFF, true), new Color(0x7F7F7F, true), BLACK}, NO_CYCLE, SRGB, new AffineTransform(1.126369f, -0.578005f, 0.706687f, 1.338259f, -56.17696f, 13.71076f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_22
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(86.07858, 13.960252);
        ((GeneralPath) shape).curveTo(90.97751, 22.682386, 116.60259, 68.30594, 121.5015, 77.02807);
        ((GeneralPath) shape).curveTo(126.40042, 85.7502, 115.65681, 101.02523, 97.51468, 111.12727);
        ((GeneralPath) shape).curveTo(79.37254, 121.2293, 60.677124, 122.34672, 55.77821, 113.62459);
        ((GeneralPath) shape).curveTo(50.879303, 104.90247, 25.254208, 59.278915, 20.355278, 50.556786);
        ((GeneralPath) shape).curveTo(15.456362, 41.834656, 26.199976, 26.55962, 44.34212, 16.457586);
        ((GeneralPath) shape).curveTo(62.484245, 6.3555484, 81.179665, 5.2381215, 86.07858, 13.960252);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(-116.7874526977539, 116.55856323242188), new Point2D.Double(-84.77729034423828, 93.5679702758789), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(1.129522f, 0.08477695f, 0.05309184f, 1.206648f, 150.0367f, -10.45332f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.4f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.981188f, -0.546351f, 0.371618f, 0.661637f, 152.2798f, -63.94088f));

        // _0_0_23
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-84.361115, 47.981);
        ((GeneralPath) shape).curveTo(-84.3554, 56.5158, -90.73852, 64.40402, -101.10466, 68.6726);
        ((GeneralPath) shape).curveTo(-111.4708, 72.94118, -124.24407, 72.94118, -134.61021, 68.6726);
        ((GeneralPath) shape).curveTo(-144.97636, 64.40402, -151.35947, 56.5158, -151.35376, 47.981);
        ((GeneralPath) shape).curveTo(-151.35947, 39.446198, -144.97636, 31.557972, -134.61021, 27.289394);
        ((GeneralPath) shape).curveTo(-124.24407, 23.020817, -111.4708, 23.020817, -101.10466, 27.289394);
        ((GeneralPath) shape).curveTo(-90.73852, 31.557972, -84.3554, 39.446198, -84.361115, 47.981);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(-146.751708984375, 74.95999145507812), new Point2D.Double(-123.6665267944336, 73.41511535644531), new float[]{0, 0.4065934f, 0.45329672f, 0.5f, 0.70604396f, 1}, new Color[]{BLACK, new Color(0xAE000000, true), new Color(0x7C000000, true), new Color(0x5C000000, true), new Color(0x27000000, true), new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_23
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.981188f, -0.546351f, 0.371618f, 0.661637f, 151.317f, -64.04474f));

        // _0_0_24
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-84.361115, 47.981);
        ((GeneralPath) shape).curveTo(-84.3554, 56.5158, -90.73852, 64.40402, -101.10466, 68.6726);
        ((GeneralPath) shape).curveTo(-111.4708, 72.94118, -124.24407, 72.94118, -134.61021, 68.6726);
        ((GeneralPath) shape).curveTo(-144.97636, 64.40402, -151.35947, 56.5158, -151.35376, 47.981);
        ((GeneralPath) shape).curveTo(-151.35947, 39.446198, -144.97636, 31.557972, -134.61021, 27.289394);
        ((GeneralPath) shape).curveTo(-124.24407, 23.020817, -111.4708, 23.020817, -101.10466, 27.289394);
        ((GeneralPath) shape).curveTo(-90.73852, 31.557972, -84.3554, 39.446198, -84.361115, 47.981);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(-82.5097427368164, 64.065185546875), new Point2D.Double(-118.91475677490234, 63.44707489013672), new float[]{0, 0.4065934f, 0.45329672f, 0.5f, 0.70604396f, 1}, new Color[]{BLACK, new Color(0xAE000000, true), new Color(0x7C000000, true), new Color(0x5C000000, true), new Color(0x27000000, true), new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_24
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.981188f, -0.546351f, 0.371618f, 0.661637f, 151.317f, -64.04474f));

        // _0_0_25
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-84.361115, 47.981);
        ((GeneralPath) shape).curveTo(-84.3554, 56.5158, -90.73852, 64.40402, -101.10466, 68.6726);
        ((GeneralPath) shape).curveTo(-111.4708, 72.94118, -124.24407, 72.94118, -134.61021, 68.6726);
        ((GeneralPath) shape).curveTo(-144.97636, 64.40402, -151.35947, 56.5158, -151.35376, 47.981);
        ((GeneralPath) shape).curveTo(-151.35947, 39.446198, -144.97636, 31.557972, -134.61021, 27.289394);
        ((GeneralPath) shape).curveTo(-124.24407, 23.020817, -111.4708, 23.020817, -101.10466, 27.289394);
        ((GeneralPath) shape).curveTo(-90.73852, 31.557972, -84.3554, 39.446198, -84.361115, 47.981);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(-113.64350128173828, 78.29383087158203), new Point2D.Double(-118.3001937866211, 33.764427185058594), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_25
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_26
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(86.175316, 14.144517);
        ((GeneralPath) shape).curveTo(86.47506, 14.678203, 87.55732, 16.579153, 87.77727, 16.970747);
        ((GeneralPath) shape).curveTo(92.676186, 25.69288, 81.9484, 40.96151, 63.806274, 51.06355);
        ((GeneralPath) shape).curveTo(45.664135, 61.16558, 26.985228, 62.291836, 22.086311, 53.569702);
        ((GeneralPath) shape).curveTo(21.821533, 53.09829, 20.55641, 50.832024, 20.17709, 50.156666);
        ((GeneralPath) shape).curveTo(20.30276, 51.53979, 20.667326, 52.819427, 21.331333, 54.001617);
        ((GeneralPath) shape).curveTo(23.869791, 58.521164, 29.999317, 60.46556, 37.708336, 60.003876);
        ((GeneralPath) shape).curveTo(45.417355, 59.54219, 54.7785, 56.681877, 63.969032, 51.564342);
        ((GeneralPath) shape).curveTo(73.15957, 46.446804, 80.49596, 40.042553, 84.926834, 33.744415);
        ((GeneralPath) shape).curveTo(89.35772, 27.446274, 90.867226, 21.231024, 88.32876, 16.711473);
        ((GeneralPath) shape).curveTo(87.775375, 15.726211, 87.04797, 14.885201, 86.175316, 14.144517);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xCACACA));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.4f * origAlpha));

        // _0_0_27
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(76.72064, 9.44609);
        ((GeneralPath) shape).curveTo(68.451584, 8.532639, 56.88424, 11.342217, 45.5454, 17.65598);
        ((GeneralPath) shape).curveTo(27.40325, 27.757994, 16.65105, 43.04895, 21.54996, 51.771076);
        ((GeneralPath) shape).curveTo(21.917528, 52.425507, 22.381548, 53.003212, 22.898445, 53.547195);
        ((GeneralPath) shape).curveTo(22.63023, 53.20102, 22.377228, 52.86082, 22.161367, 52.476505);
        ((GeneralPath) shape).curveTo(17.262459, 43.75438, 28.014658, 28.463425, 46.156807, 18.361408);
        ((GeneralPath) shape).curveTo(62.930237, 9.021524, 80.173454, 7.360404, 86.55251, 14.056021);
        ((GeneralPath) shape).curveTo(84.53678, 11.462824, 81.09283, 9.929072, 76.72064, 9.44609);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xBABDB6));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_28
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(59.474255, 68.01234);
        ((GeneralPath) shape).lineTo(84.311356, 109.91412);
        ((GeneralPath) shape).curveTo(99.162285, 103.24193, 116.63784, 87.654205, 119.47193, 77.30627);
        ((GeneralPath) shape).lineTo(95.28071, 34.66616);
        ((GeneralPath) shape).curveTo(92.2947, 49.841373, 74.12331, 61.005417, 59.474255, 68.01234);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(106.2739028930664, 52.468563079833984), new Point2D.Double(79.5440902709961, 69.99189758300781), new float[]{0, 0.09292036f, 0.5043171f, 0.91571385f, 1}, new Color[]{new Color(0x9A7600), new Color(0xE3AD00), new Color(0xFFCD2C), new Color(0xE3AD00), new Color(0xB98D00)}, REFLECT, SRGB, new AffineTransform(0.961459f, -0.04366598f, -0.005518f, 1.121052f, 8.015668f, -2.987019f)));
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.979816f, -0.546512f, 0.371116f, 0.661595f, 151.1312f, -64.06692f));

        // _0_0_29
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-84.361115, 47.981);
        ((GeneralPath) shape).curveTo(-84.3554, 56.5158, -90.73852, 64.40402, -101.10466, 68.6726);
        ((GeneralPath) shape).curveTo(-111.4708, 72.94118, -124.24407, 72.94118, -134.61021, 68.6726);
        ((GeneralPath) shape).curveTo(-144.97636, 64.40402, -151.35947, 56.5158, -151.35376, 47.981);
        ((GeneralPath) shape).curveTo(-151.35947, 39.446198, -144.97636, 31.557972, -134.61021, 27.289394);
        ((GeneralPath) shape).curveTo(-124.24407, 23.020817, -111.4708, 23.020817, -101.10466, 27.289394);
        ((GeneralPath) shape).curveTo(-90.73852, 31.557972, -84.3554, 39.446198, -84.361115, 47.981);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.setStroke(new BasicStroke(1.6126516f, 1, 1, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_29

        // _0_0_30
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(19.565592, 44.07871);
        ((GeneralPath) shape).curveTo(19.288776, 46.40352, 19.590769, 48.563442, 20.594456, 50.40688);
        ((GeneralPath) shape).curveTo(25.333979, 59.111805, 42.91558, 56.9655, 60.935013, 47.738445);
        ((GeneralPath) shape).curveTo(65.75341, 45.271126, 69.73401, 42.294395, 70.78305, 41.418568);
        ((GeneralPath) shape).curveTo(63.272762, 36.70413, 22.341745, 32.47607, 19.565592, 44.07871);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xB70000));
        g.fill(shape);

        // _0_0_31
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(75.91941, 8.267599);
        ((GeneralPath) shape).curveTo(74.32025, 8.093961, 72.58884, 8.079081, 70.75175, 8.189535);
        ((GeneralPath) shape).curveTo(63.403404, 8.631355, 54.39895, 11.366976, 45.492947, 16.334478);
        ((GeneralPath) shape).curveTo(36.586945, 21.301981, 29.520496, 27.517878, 25.297035, 33.530464);
        ((GeneralPath) shape).curveTo(24.374664, 34.843567, 23.59643, 36.159657, 22.952984, 37.43395);
        ((GeneralPath) shape).curveTo(23.540272, 36.333748, 24.243547, 35.237076, 25.035446, 34.10972);
        ((GeneralPath) shape).curveTo(29.258907, 28.097124, 36.324875, 21.849207, 45.230873, 16.881704);
        ((GeneralPath) shape).curveTo(54.13687, 11.914197, 63.14133, 9.17858, 70.48968, 8.73676);
        ((GeneralPath) shape).curveTo(77.83802, 8.29494, 83.49966, 10.102715, 85.83225, 14.261084);
        ((GeneralPath) shape).curveTo(87.43591, 17.119967, 87.28495, 20.759426, 85.65947, 24.697466);
        ((GeneralPath) shape).curveTo(87.50555, 20.544144, 87.773384, 16.707153, 86.09433, 13.713858);
        ((GeneralPath) shape).curveTo(84.34487, 10.595082, 80.716866, 8.788514, 75.91941, 8.267599);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(86.407196, 26.472698);
        ((GeneralPath) shape).curveTo(85.78515, 27.645126, 85.041985, 28.820522, 84.20777, 30.008114);
        ((GeneralPath) shape).curveTo(79.75866, 36.341934, 72.42238, 42.779564, 63.21161, 47.91706);
        ((GeneralPath) shape).curveTo(54.00084, 53.054554, 44.647484, 55.93129, 36.906548, 56.396717);
        ((GeneralPath) shape).curveTo(29.165606, 56.862144, 23.00417, 54.89915, 20.444473, 50.33594);
        ((GeneralPath) shape).curveTo(18.684683, 47.19874, 18.870728, 43.246365, 20.604189, 39.034893);
        ((GeneralPath) shape).curveTo(18.643396, 43.465027, 18.341833, 47.60196, 20.1824, 50.883167);
        ((GeneralPath) shape).curveTo(22.742096, 55.446377, 28.903534, 57.409367, 36.644474, 56.943943);
        ((GeneralPath) shape).curveTo(44.385414, 56.47852, 53.738766, 53.60178, 62.949535, 48.464287);
        ((GeneralPath) shape).curveTo(72.16031, 43.32679, 79.49707, 36.921185, 83.946175, 30.587366);
        ((GeneralPath) shape).curveTo(84.910675, 29.214294, 85.72795, 27.823233, 86.407196, 26.472698);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x65000000, true));
        g.fill(shape);

        // _0_0_32
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(76.45258, 8.034723);
        ((GeneralPath) shape).curveTo(74.853424, 7.8610864, 73.12152, 7.8141828, 71.28444, 7.9246387);
        ((GeneralPath) shape).curveTo(63.936092, 8.366456, 54.931637, 11.102077, 46.025635, 16.06958);
        ((GeneralPath) shape).curveTo(40.328465, 19.247293, 35.40208, 22.950542, 31.468899, 26.776196);
        ((GeneralPath) shape).curveTo(35.26205, 23.229267, 39.91793, 19.839766, 45.226837, 16.878613);
        ((GeneralPath) shape).curveTo(54.13284, 11.911107, 63.1373, 9.175488, 70.48564, 8.733667);
        ((GeneralPath) shape).curveTo(77.833984, 8.291851, 83.60878, 10.126815, 85.79972, 14.359895);
        ((GeneralPath) shape).curveTo(87.883766, 18.386465, 86.26675, 24.14297, 82.0433, 30.155558);
        ((GeneralPath) shape).curveTo(80.57677, 32.24333, 78.9308, 34.17974, 76.82328, 36.256397);
        ((GeneralPath) shape).curveTo(79.28966, 33.9233, 81.186226, 31.703848, 82.84209, 29.346525);
        ((GeneralPath) shape).curveTo(87.06556, 23.333933, 88.864494, 17.838997, 86.53188, 13.680627);
        ((GeneralPath) shape).curveTo(84.782425, 10.561854, 81.25004, 8.555637, 76.45258, 8.034723);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(29.784527, 26.626406);
        ((GeneralPath) shape).curveTo(27.354559, 28.961544, 25.25228, 31.351425, 23.583864, 33.72661);
        ((GeneralPath) shape).curveTo(19.134754, 40.06043, 17.588583, 46.313625, 20.148277, 50.876827);
        ((GeneralPath) shape).curveTo(22.707973, 55.44004, 28.86941, 57.40303, 36.61035, 56.937603);
        ((GeneralPath) shape).curveTo(44.35129, 56.472176, 53.73473, 53.59869, 62.9455, 48.461197);
        ((GeneralPath) shape).curveTo(69.100494, 45.028114, 74.39183, 41.018833, 78.56988, 36.84667);
        ((GeneralPath) shape).curveTo(74.525505, 40.72751, 69.50104, 44.44123, 63.744297, 47.652164);
        ((GeneralPath) shape).curveTo(54.533524, 52.789658, 45.18066, 55.698418, 37.43972, 56.16384);
        ((GeneralPath) shape).curveTo(29.698778, 56.62927, 23.536856, 54.634247, 20.977161, 50.071045);
        ((GeneralPath) shape).curveTo(18.417465, 45.507828, 19.963638, 39.25465, 24.412746, 32.920822);
        ((GeneralPath) shape).curveTo(25.890022, 30.817749, 27.70524, 28.704992, 29.784527, 26.626406);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        // _0_0_33
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(59.474255, 68.01234);
        ((GeneralPath) shape).lineTo(84.311356, 109.91412);
        ((GeneralPath) shape).curveTo(99.16229, 103.24193, 116.63784, 87.654205, 119.47193, 77.30627);
        ((GeneralPath) shape).lineTo(95.28071, 34.66616);
        ((GeneralPath) shape).curveTo(92.2947, 49.841373, 74.12331, 61.005417, 59.474255, 68.01234);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(104.66047668457031, 65.8478012084961), 29.998838f, new Point2D.Double(115.72850036621094, 56.2811279296875), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(0.453553f, -0.261287f, 1.03209f, 1.791544f, -20.21086f, -24.28382f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.7827869f * origAlpha));

        // _0_0_34
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(120.02654, 75.20634);
        ((GeneralPath) shape).curveTo(120.32266, 75.73356, 121.39183, 77.6115, 121.60911, 77.99836);
        ((GeneralPath) shape).curveTo(126.44873, 86.61493, 115.85079, 101.69876, 97.928246, 111.67853);
        ((GeneralPath) shape).curveTo(80.00568, 121.65831, 61.552837, 122.77092, 56.713215, 114.15435);
        ((GeneralPath) shape).curveTo(56.451637, 113.68864, 55.201824, 111.4498, 54.8271, 110.78262);
        ((GeneralPath) shape).curveTo(54.95125, 112.14901, 55.3114, 113.41316, 55.967373, 114.58104);
        ((GeneralPath) shape).curveTo(58.475105, 119.04589, 64.53045, 120.96675, 72.146164, 120.51066);
        ((GeneralPath) shape).curveTo(79.76189, 120.05454, 89.00973, 117.22886, 98.089035, 112.17327);
        ((GeneralPath) shape).curveTo(107.16832, 107.11767, 114.41592, 100.79093, 118.79317, 94.569016);
        ((GeneralPath) shape).curveTo(123.17043, 88.34711, 124.66168, 82.20708, 122.15393, 77.742226);
        ((GeneralPath) shape).curveTo(121.60724, 76.76889, 120.88864, 75.93806, 120.02654, 75.20634);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(87.06843566894531, 146.89471435546875), new Point2D.Double(105.05599212646484, 58.6532096862793), new float[]{0, 1}, new Color[]{new Color(0x393A38), new Color(0x393A38, true)}, NO_CYCLE, SRGB, new AffineTransform(0.962775f, 0.103895f, 0.01547901f, 1.024792f, 1.181389f, -2.598443f)));
        g.fill(shape);

        // _0_0_35
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(119.58033, 74.6915);
        ((GeneralPath) shape).curveTo(119.87645, 75.21872, 120.9456, 77.096664, 121.16289, 77.48352);
        ((GeneralPath) shape).curveTo(126.00251, 86.10009, 115.40457, 101.18392, 97.482025, 111.1637);
        ((GeneralPath) shape).curveTo(79.559456, 121.14345, 61.106617, 122.25609, 56.26699, 113.6395);
        ((GeneralPath) shape).curveTo(56.00542, 113.1738, 54.755604, 110.93497, 54.38088, 110.26779);
        ((GeneralPath) shape).curveTo(54.505028, 111.63417, 54.86518, 112.89832, 55.521152, 114.0662);
        ((GeneralPath) shape).curveTo(58.028885, 118.53105, 64.08423, 120.45191, 71.69994, 119.99581);
        ((GeneralPath) shape).curveTo(79.31566, 119.53971, 88.56351, 116.71402, 97.642815, 111.65843);
        ((GeneralPath) shape).curveTo(106.7221, 106.60283, 113.9697, 100.27609, 118.34695, 94.05418);
        ((GeneralPath) shape).curveTo(122.72421, 87.83227, 124.21545, 81.69223, 121.7077, 77.22739);
        ((GeneralPath) shape).curveTo(121.16102, 76.25405, 120.44241, 75.42322, 119.58033, 74.6915);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(95.84687042236328, 117.2056884765625), new Point2D.Double(76.36178588867188, 88.40906524658203), new float[]{0, 1}, new Color[]{new Color(0x393A38), new Color(0x393A38, true)}, NO_CYCLE, SRGB, new AffineTransform(0.962775f, 0.103895f, 0.01547901f, 1.024792f, 1.181389f, -2.598443f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_36
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(15.373706, 125.69402);
        ((GeneralPath) shape).curveTo(22.221464, 125.74933, 27.996107, 124.98911, 29.405975, 125.0239);
        ((GeneralPath) shape).curveTo(38.73244, 125.25394, 61.07722, 120.9265, 52.14107, 115.60666);
        ((GeneralPath) shape).curveTo(42.378445, 109.79479, 15.545252, 109.95091, 5.0973773, 115.55487);
        ((GeneralPath) shape).curveTo(-6.30459, 121.67058, 8.527061, 125.63869, 15.373706, 125.69402);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xB90000));
        g.fill(shape);
        g.setPaint(new Color(0xAE0000));
        g.setStroke(new BasicStroke(0.75208664f, 0, 0, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.88524634f * origAlpha));

        // _0_0_37
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(15.322403, 126.05314);
        ((GeneralPath) shape).curveTo(22.170162, 126.10845, 27.970818, 125.31015, 29.380323, 125.35737);
        ((GeneralPath) shape).curveTo(38.792057, 125.67268, 61.866383, 121.20263, 52.39759, 115.35014);
        ((GeneralPath) shape).curveTo(42.73301, 109.37665, 15.545252, 109.43788, 4.7382545, 115.34966);
        ((GeneralPath) shape).curveTo(-6.612926, 121.55912, 8.475759, 125.99781, 15.322403, 126.05314);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(23.02284049987793, 104.74906158447266), new Point2D.Double(22.669342041015625, 135.73619079589844), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.setStroke(new BasicStroke(0.077f, 0, 0, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.4385246f * origAlpha));

        // _0_0_38
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(84.311356, 109.91412);
        ((GeneralPath) shape).curveTo(99.16229, 103.24193, 116.63784, 87.654205, 119.47193, 77.30627);
        ((GeneralPath) shape).curveTo(102.01223, 47.067432, 69.03892, 83.57913, 84.311356, 109.91412);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(98.66989135742188, 112.10143280029297), new Point2D.Double(74.32511901855469, 85.42376708984375), new float[]{0, 0.5f, 1}, new Color[]{new Color(0x72000000, true), new Color(0x22000000, true), new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 0, 5.335533f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_39
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(35.982327, 55.747757);
        ((GeneralPath) shape).curveTo(30.24759, 55.610603, 28.138458, 60.217285, 27.770193, 64.69856);
        ((GeneralPath) shape).curveTo(26.66944, 78.09325, 28.964888, 87.4829, 28.19733, 98.200066);
        ((GeneralPath) shape).curveTo(28.041653, 100.37373, 24.17295, 102.55924, 23.718245, 97.71671);
        ((GeneralPath) shape).curveTo(22.663063, 86.47926, 24.45652, 78.59373, 23.19495, 63.072113);
        ((GeneralPath) shape).curveTo(22.778255, 57.945328, 21.204723, 53.02035, 19.824348, 47.15959);

        g.setPaint(new Color(0xB70000));
        g.fill(shape);
        g.setPaint(BLACK);
        g.setStroke(new BasicStroke(0.1f, 0, 0, 4));
        g.draw(shape);

        // _0_0_40
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(21.43323, 51.631603);
        ((GeneralPath) shape).curveTo(22.53314, 55.958153, 23.57408, 59.862762, 23.901213, 63.887634);
        ((GeneralPath) shape).curveTo(25.162783, 79.40925, 23.36942, 87.30096, 24.4246, 98.538414);
        ((GeneralPath) shape).curveTo(24.485174, 99.183525, 24.61387, 99.69902, 24.778772, 100.11132);
        ((GeneralPath) shape).curveTo(25.219997, 99.66035, 25.523756, 99.08418, 25.565475, 98.50166);
        ((GeneralPath) shape).curveTo(26.333035, 87.78451, 23.960684, 78.526566, 25.06144, 65.131874);
        ((GeneralPath) shape).curveTo(25.34952, 61.626316, 26.576317, 57.04092, 29.940802, 56.06665);
        ((GeneralPath) shape).curveTo(27.094194, 54.590065, 24.165434, 53.167694, 21.43323, 51.631603);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(-16.602840423583984, 73.86382293701172), 4.390625f, new Point2D.Double(-16.602840423583984, 73.86382293701172), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(0.962775f, 0.103895f, 0.105414f, 6.978879f, 33.03078f, -433.3987f)));
        g.fill(shape);

        // _0_0_41
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(19.565592, 44.07871);
        ((GeneralPath) shape).curveTo(19.288776, 46.40352, 19.590769, 48.563442, 20.594456, 50.40688);
        ((GeneralPath) shape).curveTo(25.333979, 59.111805, 42.91558, 56.9655, 60.935013, 47.738445);
        ((GeneralPath) shape).curveTo(65.75341, 45.271126, 69.73401, 42.294395, 70.78305, 41.418568);
        ((GeneralPath) shape).curveTo(63.272762, 36.70413, 22.341745, 32.47607, 19.565592, 44.07871);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(78.56920623779297, 22.051414489746094), new Point2D.Double(41.43761444091797, 59.810569763183594), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.6270492f * origAlpha));

        // _0_0_42
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(15.322403, 126.05314);
        ((GeneralPath) shape).curveTo(22.170162, 126.10845, 27.970818, 125.31015, 29.380323, 125.35737);
        ((GeneralPath) shape).curveTo(38.792057, 125.67268, 61.78943, 121.27958, 52.320633, 115.42709);
        ((GeneralPath) shape).curveTo(42.656055, 109.4536, 15.596555, 109.52766, 4.789558, 115.43944);
        ((GeneralPath) shape).curveTo(-6.561623, 121.6489, 8.475759, 125.99781, 15.322403, 126.05314);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(23.02284049987793, 104.74906158447266), new Point2D.Double(22.669342041015625, 135.73619079589844), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.setStroke(new BasicStroke(0.277f, 0, 0, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.24590164f * origAlpha));

        // _0_0_43
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(15.322403, 126.05314);
        ((GeneralPath) shape).curveTo(22.170162, 126.10845, 27.970818, 125.31015, 29.380323, 125.35737);
        ((GeneralPath) shape).curveTo(38.792057, 125.67268, 61.6147, 121.54762, 52.121113, 115.73544);
        ((GeneralPath) shape).curveTo(42.48653, 109.83694, 15.743585, 109.91337, 4.8983884, 115.72965);
        ((GeneralPath) shape).curveTo(-6.503923, 121.84472, 8.475759, 125.99781, 15.322403, 126.05314);
        ((GeneralPath) shape).closePath();

        g.setStroke(new BasicStroke(0.977f, 0, 0, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.8196721f * origAlpha));

        // _0_0_44
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(32.37081, 111.10281);
        ((GeneralPath) shape).curveTo(24.46055, 110.80473, 16.101856, 111.59262, 9.985697, 113.39865);
        ((GeneralPath) shape).curveTo(6.851011, 116.25766, 18.543636, 119.04089, 27.148237, 119.25315);
        ((GeneralPath) shape).curveTo(36.93204, 119.4945, 48.007668, 116.69496, 46.063755, 112.96395);
        ((GeneralPath) shape).curveTo(42.119175, 111.91527, 37.350586, 111.29046, 32.37081, 111.10281);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(24.650917053222656, 111.04126739501953), new Point2D.Double(24.945655822753906, 122.54212188720703), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.7008197f * origAlpha));

        // _0_0_45
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(15.373706, 125.69402);
        ((GeneralPath) shape).curveTo(22.221464, 125.74933, 27.996107, 124.98911, 29.405975, 125.0239);
        ((GeneralPath) shape).curveTo(38.73244, 125.25394, 61.07722, 120.9265, 52.14107, 115.60666);
        ((GeneralPath) shape).curveTo(42.378445, 109.79479, 15.545252, 109.95091, 5.0973773, 115.55487);
        ((GeneralPath) shape).curveTo(-6.30459, 121.67058, 8.527061, 125.63869, 15.373706, 125.69402);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(29.962148666381836, 131.46768188476562), 27.01967f, new Point2D.Double(29.962148666381836, 131.46768188476562), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(0.709744f, -0.0162743f, 0.003676083f, 0.160321f, 7.971984f, 102.5261f)));
        g.fill(shape);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(27.56598472595215, 130.94268798828125), 27.01967f, new Point2D.Double(27.56598472595215, 130.94268798828125), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 0.280337f, 0, 85.27881f)));
        g.setStroke(new BasicStroke(0.75208664f, 0, 0, 4));
        g.draw(shape);

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
    public ColorFill() {
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

