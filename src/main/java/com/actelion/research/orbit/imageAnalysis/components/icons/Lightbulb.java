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

import static java.awt.Color.WHITE;
import static java.awt.MultipleGradientPaint.ColorSpaceType.SRGB;
import static java.awt.MultipleGradientPaint.CycleMethod.NO_CYCLE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class Lightbulb implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.003805798f, 0, 0, 0.003805798f, 0.19086267f, 0));

        // _0

        // _0_0
        shape = new Rectangle2D.Double(72.34400177001953, 256.4100036621094, 19.038000106811523, 6.3460001945495605);
        g.setPaint(new Color(0x6E6E6E));
        g.fill(shape);

        // _0_1
        shape = new Rectangle2D.Double(65.99800109863281, 252.60000610351562, 31.729000091552734, 6.3460001945495605);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(81.86299896240234, 255.77999877929688), 11.44f, new Point2D.Double(81.86299896240234, 255.77999877929688), new float[]{0, 1}, new Color[]{new Color(0xCFCFCF), new Color(0xA8A8A8)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        // _0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(162.46, 71.595);
        ((GeneralPath) shape).curveTo(162.46, 32.057, 126.09, 0.0, 81.229, 0.0);
        ((GeneralPath) shape).curveTo(36.368, 0.0, 0.0, 32.057, 0.0, 71.595);
        ((GeneralPath) shape).curveTo(0.0, 87.222, 5.741, 101.64, 15.376, 113.4);
        ((GeneralPath) shape).curveTo(16.516, 115.01, 48.648, 160.46, 51.376, 179.64);
        ((GeneralPath) shape).curveTo(54.15, 199.17, 54.15, 204.37, 54.15, 204.37);
        ((GeneralPath) shape).lineTo(69.45, 204.89);
        ((GeneralPath) shape).lineTo(69.423, 205.68);
        ((GeneralPath) shape).lineTo(81.228, 205.28);
        ((GeneralPath) shape).lineTo(93.032, 205.68);
        ((GeneralPath) shape).lineTo(93.008, 204.89);
        ((GeneralPath) shape).lineTo(108.31, 204.37);
        ((GeneralPath) shape).curveTo(108.31, 204.37, 108.31, 199.17, 111.08, 179.64);
        ((GeneralPath) shape).curveTo(113.81, 160.46, 145.94, 115.01, 147.08, 113.4);
        ((GeneralPath) shape).curveTo(156.72, 101.64, 162.46, 87.222, 162.46, 71.595);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(81.22799682617188, 102.83999633789062), 92.666f, new Point2D.Double(81.22799682617188, 102.83999633789062), new float[]{0, 1}, new Color[]{WHITE, new Color(0xCDCDCD)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        // _0_3
        shape = new Line2D.Float(79.959000f, 93.955002f, 74.882004f, 208.179993f);
        g.setPaint(new Color(0x6D6868));
        g.setStroke(new BasicStroke(0.75f, 0, 0, 4));
        g.draw(shape);

        // _0_4
        shape = new Line2D.Float(83.766998f, 93.955002f, 86.305000f, 208.179993f);
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.26000002f * origAlpha));

        // _0_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(81.229, 0.0);
        ((GeneralPath) shape).lineTo(80.792, 3.277);
        ((GeneralPath) shape).lineTo(82.894, 19.072);
        ((GeneralPath) shape).curveTo(82.161, 19.206, 81.511, 19.369, 80.792, 19.508);
        ((GeneralPath) shape).curveTo(175.54, 37.956, 123.11, 109.18, 123.11, 109.18);
        ((GeneralPath) shape).lineTo(93.032, 205.68);
        ((GeneralPath) shape).lineTo(108.31, 204.37);
        ((GeneralPath) shape).curveTo(101.11, 182.8, 138.34, 123.14, 138.34, 123.14);
        ((GeneralPath) shape).curveTo(210.69, 14.0, 81.229, 0.0, 81.229, 0.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xBCBCBC));
        g.fill(shape);

        // _0_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(80.792, 3.277);
        ((GeneralPath) shape).lineTo(80.355, 0.0);
        ((GeneralPath) shape).curveTo(80.355, 0.0, -49.105, 13.996, 23.242, 123.15);
        ((GeneralPath) shape).curveTo(23.242, 123.15, 60.47, 182.8, 53.278, 204.37);
        ((GeneralPath) shape).lineTo(68.55, 205.68);
        ((GeneralPath) shape).lineTo(38.472, 109.18);
        ((GeneralPath) shape).curveTo(38.472, 109.18, -13.957, 37.957, 80.791, 19.509);
        ((GeneralPath) shape).curveTo(80.072, 19.37, 79.423, 19.207, 78.688, 19.073);
        ((GeneralPath) shape).lineTo(80.792, 3.277);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        // _0_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(80.792, 3.277);
        ((GeneralPath) shape).lineTo(78.689, 19.072);
        ((GeneralPath) shape).curveTo(79.423, 19.206, 80.073, 19.369, 80.792, 19.508);
        ((GeneralPath) shape).curveTo(81.511, 19.369, 82.16, 19.206, 82.894, 19.072);
        ((GeneralPath) shape).lineTo(80.792, 3.277);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        // _0_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(80.792, 3.277);
        ((GeneralPath) shape).lineTo(78.689, 19.072);
        ((GeneralPath) shape).curveTo(79.423, 19.206, 80.073, 19.369, 80.792, 19.508);
        ((GeneralPath) shape).curveTo(81.511, 19.369, 82.16, 19.206, 82.894, 19.072);
        ((GeneralPath) shape).lineTo(80.792, 3.277);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_9
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(44.699, 12.747);
        ((GeneralPath) shape).curveTo(44.699, 12.747, -12.646, 56.137, 12.032, 99.798);
        ((GeneralPath) shape).curveTo(32.248, 140.11, -7.651, 60.943, 44.699, 12.747);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        // _0_10
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(109.78, 210.36);
        ((GeneralPath) shape).curveTo(109.78, 214.56, 106.37, 217.97, 102.17, 217.97);
        ((GeneralPath) shape).lineTo(60.286, 217.97);
        ((GeneralPath) shape).curveTo(56.08, 217.97, 52.671, 214.56, 52.671, 210.36);
        ((GeneralPath) shape).curveTo(52.671, 206.15, 56.08, 202.74, 60.286, 202.74);
        ((GeneralPath) shape).lineTo(102.17, 202.74);
        ((GeneralPath) shape).curveTo(106.37, 202.74, 109.78, 206.15, 109.78, 210.36);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(81.22799682617188, 210.36000061035156), 20.899f, new Point2D.Double(81.22799682617188, 210.36000061035156), new float[]{0, 1}, new Color[]{WHITE, new Color(0x818181)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        // _0_11
        shape = new Line2D.Float(109.779999f, 204.009995f, 52.671001f, 204.009995f);
        g.setPaint(new Color(0x6D6868));
        g.draw(shape);

        // _0_12
        shape = new Rectangle2D.Double(50.768001556396484, 216.38999938964844, 59.652000427246094, 6.3460001945495605);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(80.59400177001953, 219.55999755859375), 21.209f, new Point2D.Double(80.59400177001953, 219.55999755859375), new float[]{0.3315f, 1}, new Color[]{WHITE, new Color(0xA1A1A1)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        // _0_13
        shape = new Line2D.Float(54.575001f, 224.639999f, 107.879997f, 224.639999f);
        g.setPaint(new Color(0xAFAFAF));
        g.draw(shape);

        // _0_14
        shape = new Rectangle2D.Double(50.768001556396484, 225.27000427246094, 59.652000427246094, 6.3460001945495605);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(80.59400177001953, 228.44000244140625), 21.209f, new Point2D.Double(80.59400177001953, 228.44000244140625), new float[]{0.3315f, 1}, new Color[]{WHITE, new Color(0xA1A1A1)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        // _0_15
        shape = new Line2D.Float(54.575001f, 233.520004f, 107.879997f, 233.520004f);
        g.setPaint(new Color(0xAFAFAF));
        g.draw(shape);

        // _0_16
        shape = new Rectangle2D.Double(50.768001556396484, 234.16000366210938, 59.652000427246094, 6.3460001945495605);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(80.59400177001953, 237.3300018310547), 21.209f, new Point2D.Double(80.59400177001953, 237.3300018310547), new float[]{0.3315f, 1}, new Color[]{WHITE, new Color(0xA1A1A1)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        // _0_17
        shape = new Line2D.Float(54.575001f, 242.399994f, 107.879997f, 242.399994f);
        g.setPaint(new Color(0xAFAFAF));
        g.draw(shape);

        // _0_18
        shape = new Rectangle2D.Double(50.768001556396484, 243.0399932861328, 59.652000427246094, 6.3460001945495605);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(80.59400177001953, 246.2100067138672), 21.209f, new Point2D.Double(80.59400177001953, 246.2100067138672), new float[]{0.3315f, 1}, new Color[]{WHITE, new Color(0xA1A1A1)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        // _0_19
        shape = new Line2D.Float(54.575001f, 251.289993f, 107.879997f, 251.289993f);
        g.setPaint(new Color(0xAFAFAF));
        g.draw(shape);

        // _0_20
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(70.993, 101.3);
        ((GeneralPath) shape).curveTo(75.576, 108.35, 83.008, 108.35, 87.594, 101.3);
        ((GeneralPath) shape).curveTo(91.263, 95.665, 91.263, 86.529, 87.594, 80.891);
        ((GeneralPath) shape).curveTo(84.659, 76.385, 79.9, 76.385, 76.97, 80.891);
        ((GeneralPath) shape).curveTo(74.622, 84.5, 74.622, 90.346, 76.97, 93.951);
        ((GeneralPath) shape).curveTo(78.849, 96.836, 81.893, 96.841, 83.767, 93.956);

        g.setStroke(new BasicStroke(0.5f, 0, 0, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.54f * origAlpha));

        // _0_21
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(152.96, 54.972);
        ((GeneralPath) shape).curveTo(152.96, 54.972, 163.27, 97.505, 135.15, 122.61);
        ((GeneralPath) shape).curveTo(135.15, 122.61, 153.87, 61.382, 152.96, 54.972);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(135.64999389648438, 84.55999755859375), 24.964f, new Point2D.Double(135.64999389648438, 84.55999755859375), new float[]{0, 1}, new Color[]{new Color(0xCFCFCF), new Color(0xA8A8A8)}, NO_CYCLE, SRGB, new AffineTransform(0.9984f, 0.0565f, -0.0565f, 0.9984f, 14.908f, -3.2114f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_22
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(80.848, 18.4488);
        ((GeneralPath) shape).curveTo(67.961, 18.4488, 57.479, 28.9308, 57.479, 41.8178);
        ((GeneralPath) shape).curveTo(57.4787, 54.7048, 67.961, 65.1868, 80.848, 65.1868);
        ((GeneralPath) shape).curveTo(93.735, 65.1868, 104.217, 54.7048, 104.217, 41.8178);
        ((GeneralPath) shape).curveTo(104.217, 28.9308, 93.735, 18.4488, 80.848, 18.4488);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(10.017999649047852, 8.63070011138916), new Point2D.Double(63.487998962402344, 63.65999984741211), new float[]{0, 1}, new Color[]{new Color(0x236B0D), new Color(0x0A2205)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 48.848f, 9.8181f)));
        g.fill(shape);

        // _0_23
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(103.348, 41.8181);
        ((GeneralPath) shape).curveTo(103.348, 54.2381, 93.268, 64.3181, 80.848, 64.3181);
        ((GeneralPath) shape).curveTo(68.428, 64.3181, 58.348, 54.2381, 58.348, 41.8181);
        ((GeneralPath) shape).curveTo(58.348, 29.3981, 68.428, 19.3181, 80.848, 19.3181);
        ((GeneralPath) shape).curveTo(93.268, 19.3181, 103.348, 29.3981, 103.348, 41.8181);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(24.763999938964844, 16.36199951171875), 27.5f, new Point2D.Double(24.763999938964844, 16.36199951171875), new float[]{0, 1}, new Color[]{new Color(0x2EDC32), new Color(0x11661D)}, NO_CYCLE, SRGB, new AffineTransform(0.025214f, 1.0261f, -0.97814f, 0.024047f, 87.678f, 6.2424f)));
        g.fill(shape);

        // _0_24
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(80.865, 18.9743);
        ((GeneralPath) shape).curveTo(71.423, 18.9743, 63.353, 24.6831, 59.91, 32.7873);
        ((GeneralPath) shape).curveTo(64.854, 35.6203, 70.241, 37.6743, 76.029, 37.4123);
        ((GeneralPath) shape).curveTo(81.603, 37.0983, 86.402, 33.3493, 92.085, 33.6303);
        ((GeneralPath) shape).curveTo(96.299, 33.5343, 101.092, 35.1123, 103.337, 38.8183);
        ((GeneralPath) shape).curveTo(101.991, 27.6653, 92.506, 18.9743, 80.865, 18.9743);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(18.386999130249023, 14.04699993133545), 27.5f, new Point2D.Double(18.386999130249023, 14.04699993133545), new float[]{0, 1}, new Color[]{new Color(0xE6E6E6), new Color(0x11661D, true)}, NO_CYCLE, SRGB, new AffineTransform(0.011424f, 1.0988f, -1.844f, 0.018788f, 100.999f, 4.1507f)));
        g.fill(shape);

        // _0_25
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(80.848, 18.4431);
        ((GeneralPath) shape).curveTo(67.961, 18.4431, 57.473, 28.9311, 57.473, 41.8181);
        ((GeneralPath) shape).curveTo(57.473, 54.7051, 67.961, 65.1931, 80.848, 65.1931);
        ((GeneralPath) shape).curveTo(93.735, 65.1931, 104.223, 54.7051, 104.223, 41.8181);
        ((GeneralPath) shape).curveTo(104.223, 28.9311, 93.735, 18.4431, 80.848, 18.4431);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(80.848, 19.3181);
        ((GeneralPath) shape).curveTo(93.268, 19.3181, 103.348, 29.3981, 103.348, 41.8181);
        ((GeneralPath) shape).curveTo(103.348, 54.2381, 93.268, 64.3181, 80.848, 64.3181);
        ((GeneralPath) shape).curveTo(68.428, 64.3181, 58.348, 54.2381, 58.348, 41.8181);
        ((GeneralPath) shape).curveTo(58.348, 29.3981, 68.428, 19.3181, 80.848, 19.3181);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(10.017999649047852, 8.63070011138916), new Point2D.Double(63.487998962402344, 63.65999984741211), new float[]{0, 1}, new Color[]{new Color(0x236B0D), new Color(0x0A2205)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 48.845158f, 9.815259f)));
        g.fill(shape);

        // _0_26
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(84.66779, 37.08251);
        ((GeneralPath) shape).lineTo(81.96077, 37.08251);
        ((GeneralPath) shape).lineTo(74.276596, 38.358326);
        ((GeneralPath) shape).lineTo(74.276596, 41.89296);
        ((GeneralPath) shape).lineTo(75.1933, 41.97662);
        ((GeneralPath) shape).curveTo(77.07084, 42.14394, 77.59476, 42.89688, 77.59476, 45.553085);
        ((GeneralPath) shape).lineTo(77.59476, 51.8485);
        ((GeneralPath) shape).curveTo(77.59476, 54.337383, 77.332695, 54.81843, 75.67372, 55.15307);
        ((GeneralPath) shape).lineTo(74.276596, 55.466797);
        ((GeneralPath) shape).lineTo(74.276596, 59.00143);
        ((GeneralPath) shape).lineTo(87.942245, 59.00143);
        ((GeneralPath) shape).lineTo(87.942245, 55.466797);
        ((GeneralPath) shape).lineTo(86.58884, 55.15307);
        ((GeneralPath) shape).curveTo(84.92965, 54.7766, 84.66779, 54.337383, 84.66779, 51.8485);
        ((GeneralPath) shape).lineTo(84.66779, 37.08251);
        ((GeneralPath) shape).moveTo(80.86921, 27.12697);
        ((GeneralPath) shape).curveTo(78.555176, 27.12697, 76.54692, 29.09298, 76.54692, 31.414545);
        ((GeneralPath) shape).curveTo(76.54692, 33.715195, 78.38054, 35.597546, 80.69457, 35.597546);
        ((GeneralPath) shape).curveTo(83.05232, 35.597546, 85.017075, 33.631535, 85.017075, 31.26814);
        ((GeneralPath) shape).curveTo(85.017075, 28.96749, 83.22696, 27.12697, 80.86921, 27.12697);

        g.setPaint(new LinearGradientPaint(new Point2D.Double(-0.566860020160675, 22.650999069213867), new Point2D.Double(-0.3371399939060211, 23.858999252319336), new float[]{0, 1}, new Color[]{WHITE, new Color(0xC8C8C8)}, NO_CYCLE, SRGB, new AffineTransform(20.915f, 0, 0, 20.915f, 90.963f, -445.0919f)));
        g.fill(shape);

        // _0_27
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(80.848, 18.4488);
        ((GeneralPath) shape).curveTo(67.961, 18.4488, 57.479, 28.9308, 57.479, 41.8178);
        ((GeneralPath) shape).curveTo(57.4787, 54.7048, 67.961, 65.1868, 80.848, 65.1868);
        ((GeneralPath) shape).curveTo(93.735, 65.1868, 104.217, 54.7048, 104.217, 41.8178);
        ((GeneralPath) shape).curveTo(104.217, 28.9308, 93.735, 18.4488, 80.848, 18.4488);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(10.017999649047852, 8.63070011138916), new Point2D.Double(63.487998962402344, 63.65999984741211), new float[]{0, 1}, new Color[]{new Color(0x236B0D), new Color(0x0A2205)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 48.848f, 9.8181f)));
        g.fill(shape);

        // _0_28
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(103.348, 41.8181);
        ((GeneralPath) shape).curveTo(103.348, 54.2381, 93.268, 64.3181, 80.848, 64.3181);
        ((GeneralPath) shape).curveTo(68.428, 64.3181, 58.348, 54.2381, 58.348, 41.8181);
        ((GeneralPath) shape).curveTo(58.348, 29.3981, 68.428, 19.3181, 80.848, 19.3181);
        ((GeneralPath) shape).curveTo(93.268, 19.3181, 103.348, 29.3981, 103.348, 41.8181);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(24.763999938964844, 16.36199951171875), 27.5f, new Point2D.Double(24.763999938964844, 16.36199951171875), new float[]{0, 1}, new Color[]{new Color(0x2EDC32), new Color(0x11661D)}, NO_CYCLE, SRGB, new AffineTransform(0.025214f, 1.0261f, -0.97814f, 0.024047f, 87.678f, 6.2424f)));
        g.fill(shape);

        // _0_29
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(80.865, 18.9743);
        ((GeneralPath) shape).curveTo(71.423, 18.9743, 63.353, 24.6831, 59.91, 32.7873);
        ((GeneralPath) shape).curveTo(64.854, 35.6203, 70.241, 37.6743, 76.029, 37.4123);
        ((GeneralPath) shape).curveTo(81.603, 37.0983, 86.402, 33.3493, 92.085, 33.6303);
        ((GeneralPath) shape).curveTo(96.299, 33.5343, 101.092, 35.1123, 103.337, 38.8183);
        ((GeneralPath) shape).curveTo(101.991, 27.6653, 92.506, 18.9743, 80.865, 18.9743);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(18.386999130249023, 14.04699993133545), 27.5f, new Point2D.Double(18.386999130249023, 14.04699993133545), new float[]{0, 1}, new Color[]{new Color(0xE6E6E6), new Color(0x11661D, true)}, NO_CYCLE, SRGB, new AffineTransform(0.011424f, 1.0988f, -1.844f, 0.018788f, 100.999f, 4.1507f)));
        g.fill(shape);

        // _0_30
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(80.848, 18.4431);
        ((GeneralPath) shape).curveTo(67.961, 18.4431, 57.473, 28.9311, 57.473, 41.8181);
        ((GeneralPath) shape).curveTo(57.473, 54.7051, 67.961, 65.1931, 80.848, 65.1931);
        ((GeneralPath) shape).curveTo(93.735, 65.1931, 104.223, 54.7051, 104.223, 41.8181);
        ((GeneralPath) shape).curveTo(104.223, 28.9311, 93.735, 18.4431, 80.848, 18.4431);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(80.848, 19.3181);
        ((GeneralPath) shape).curveTo(93.268, 19.3181, 103.348, 29.3981, 103.348, 41.8181);
        ((GeneralPath) shape).curveTo(103.348, 54.2381, 93.268, 64.3181, 80.848, 64.3181);
        ((GeneralPath) shape).curveTo(68.428, 64.3181, 58.348, 54.2381, 58.348, 41.8181);
        ((GeneralPath) shape).curveTo(58.348, 29.3981, 68.428, 19.3181, 80.848, 19.3181);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(10.017999649047852, 8.63070011138916), new Point2D.Double(63.487998962402344, 63.65999984741211), new float[]{0, 1}, new Color[]{new Color(0x236B0D), new Color(0x0A2205)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 48.845158f, 9.815259f)));
        g.fill(shape);

        // _0_31
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(84.66779, 37.08251);
        ((GeneralPath) shape).lineTo(81.96077, 37.08251);
        ((GeneralPath) shape).lineTo(74.276596, 38.358326);
        ((GeneralPath) shape).lineTo(74.276596, 41.89296);
        ((GeneralPath) shape).lineTo(75.1933, 41.97662);
        ((GeneralPath) shape).curveTo(77.07084, 42.14394, 77.59476, 42.89688, 77.59476, 45.553085);
        ((GeneralPath) shape).lineTo(77.59476, 51.8485);
        ((GeneralPath) shape).curveTo(77.59476, 54.337383, 77.332695, 54.81843, 75.67372, 55.15307);
        ((GeneralPath) shape).lineTo(74.276596, 55.466797);
        ((GeneralPath) shape).lineTo(74.276596, 59.00143);
        ((GeneralPath) shape).lineTo(87.942245, 59.00143);
        ((GeneralPath) shape).lineTo(87.942245, 55.466797);
        ((GeneralPath) shape).lineTo(86.58884, 55.15307);
        ((GeneralPath) shape).curveTo(84.92965, 54.7766, 84.66779, 54.337383, 84.66779, 51.8485);
        ((GeneralPath) shape).lineTo(84.66779, 37.08251);
        ((GeneralPath) shape).moveTo(80.86921, 27.12697);
        ((GeneralPath) shape).curveTo(78.555176, 27.12697, 76.54692, 29.09298, 76.54692, 31.414545);
        ((GeneralPath) shape).curveTo(76.54692, 33.715195, 78.38054, 35.597546, 80.69457, 35.597546);
        ((GeneralPath) shape).curveTo(83.05232, 35.597546, 85.017075, 33.631535, 85.017075, 31.26814);
        ((GeneralPath) shape).curveTo(85.017075, 28.96749, 83.22696, 27.12697, 80.86921, 27.12697);

        g.setPaint(new LinearGradientPaint(new Point2D.Double(-0.566860020160675, 22.650999069213867), new Point2D.Double(-0.3371399939060211, 23.858999252319336), new float[]{0, 1}, new Color[]{WHITE, new Color(0xC8C8C8)}, NO_CYCLE, SRGB, new AffineTransform(20.915f, 0, 0, 20.915f, 90.963f, -445.0919f)));
        g.fill(shape);

        // _0_32
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(80.847, 12.880036);
        ((GeneralPath) shape).curveTo(51.053547, 12.880036, 26.82021, 35.86392, 26.82021, 64.12124);
        ((GeneralPath) shape).curveTo(26.819515, 92.37857, 51.053547, 115.36245, 80.847, 115.36245);
        ((GeneralPath) shape).curveTo(110.64046, 115.36245, 134.8738, 92.37857, 134.8738, 64.12124);
        ((GeneralPath) shape).curveTo(134.8738, 35.86392, 110.64046, 12.880036, 80.847, 12.880036);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(10.017999649047852, 8.63070011138916), new Point2D.Double(63.487998962402344, 63.65999984741211), new float[]{0, 1}, new Color[]{new Color(0x236B0D), new Color(0x0A2205)}, NO_CYCLE, SRGB, new AffineTransform(2.3119f, 0, 0, 2.1927f, 6.8662f, -6.0445f)));
        g.fill(shape);

        // _0_33
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(132.86475, 64.1219);
        ((GeneralPath) shape).curveTo(132.86475, 91.35523, 109.5608, 113.45765, 80.847, 113.45765);
        ((GeneralPath) shape).curveTo(52.1332, 113.45765, 28.82925, 91.35523, 28.82925, 64.1219);
        ((GeneralPath) shape).curveTo(28.82925, 36.888565, 52.1332, 14.78615, 80.847, 14.78615);
        ((GeneralPath) shape).curveTo(109.5608, 14.78615, 132.86475, 36.888565, 132.86475, 64.1219);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(24.763999938964844, 16.36199951171875), 27.5f, new Point2D.Double(24.763999938964844, 16.36199951171875), new float[]{0, 1}, new Color[]{new Color(0x2EDC32), new Color(0x11661D)}, NO_CYCLE, SRGB, new AffineTransform(0.05829225f, 2.2499294f, -2.2613618f, 0.05272786f, 96.637276f, -13.884937f)));
        g.fill(shape);

        // _0_34
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(80.88631, 14.0323);
        ((GeneralPath) shape).curveTo(59.057343, 14.0323, 40.40031, 26.549986, 32.440437, 44.320065);
        ((GeneralPath) shape).curveTo(43.870472, 50.531982, 56.324677, 55.03579, 69.705956, 54.461304);
        ((GeneralPath) shape).curveTo(82.59248, 53.772797, 93.687294, 45.55236, 106.82582, 46.16851);
        ((GeneralPath) shape).curveTo(116.56817, 45.95801, 127.6491, 49.41809, 132.83932, 57.54424);
        ((GeneralPath) shape).curveTo(129.7275, 33.089054, 107.79913, 14.0323, 80.88631, 14.0323);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(18.386999130249023, 14.04699993133545), 27.5f, new Point2D.Double(18.386999130249023, 14.04699993133545), new float[]{0, 1}, new Color[]{new Color(0xE6E6E6), new Color(0x11661D, true)}, NO_CYCLE, SRGB, new AffineTransform(0.02641115f, 2.4093387f, -4.2631435f, 0.04119645f, 127.4341f, -18.471409f)));
        g.fill(shape);

        // _0_35
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(80.847, 12.867538);
        ((GeneralPath) shape).curveTo(51.053547, 12.867538, 26.806337, 35.864574, 26.806337, 64.1219);
        ((GeneralPath) shape).curveTo(26.806337, 92.37923, 51.053547, 115.37626, 80.847, 115.37626);
        ((GeneralPath) shape).curveTo(110.64046, 115.37626, 134.88766, 92.37923, 134.88766, 64.1219);
        ((GeneralPath) shape).curveTo(134.88766, 35.864574, 110.64046, 12.867538, 80.847, 12.867538);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(80.847, 14.78615);
        ((GeneralPath) shape).curveTo(109.5608, 14.78615, 132.86475, 36.888565, 132.86475, 64.1219);
        ((GeneralPath) shape).curveTo(132.86475, 91.35523, 109.5608, 113.45765, 80.847, 113.45765);
        ((GeneralPath) shape).curveTo(52.1332, 113.45765, 28.82925, 91.35523, 28.82925, 64.1219);
        ((GeneralPath) shape).curveTo(28.82925, 36.888565, 52.1332, 14.78615, 80.847, 14.78615);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(10.017999649047852, 8.63070011138916), new Point2D.Double(63.487998962402344, 63.65999984741211), new float[]{0, 1}, new Color[]{new Color(0x236B0D), new Color(0x0A2205)}, NO_CYCLE, SRGB, new AffineTransform(2.3119f, 0, 0, 2.1927f, 6.859632f, -6.0507293f)));
        g.fill(shape);

        // _0_36
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(89.677986, 53.738117);
        ((GeneralPath) shape).lineTo(83.41961, 53.738117);
        ((GeneralPath) shape).lineTo(65.65457, 56.5356);
        ((GeneralPath) shape).lineTo(65.65457, 64.28599);
        ((GeneralPath) shape).lineTo(67.7739, 64.46943);
        ((GeneralPath) shape).curveTo(72.114586, 64.83631, 73.325836, 66.48729, 73.325836, 72.31155);
        ((GeneralPath) shape).lineTo(73.325836, 86.1155);
        ((GeneralPath) shape).curveTo(73.325836, 91.57288, 72.71997, 92.62767, 68.884575, 93.361435);
        ((GeneralPath) shape).lineTo(65.65457, 94.04934);
        ((GeneralPath) shape).lineTo(65.65457, 101.79973);
        ((GeneralPath) shape).lineTo(97.24819, 101.79973);
        ((GeneralPath) shape).lineTo(97.24819, 94.04934);
        ((GeneralPath) shape).lineTo(94.11924, 93.361435);
        ((GeneralPath) shape).curveTo(90.28337, 92.53595, 89.677986, 91.57288, 89.677986, 86.1155);
        ((GeneralPath) shape).lineTo(89.677986, 53.738117);
        ((GeneralPath) shape).moveTo(80.89604, 31.908606);
        ((GeneralPath) shape).curveTo(75.54623, 31.908606, 70.90333, 36.219475, 70.90333, 41.30997);
        ((GeneralPath) shape).curveTo(70.90333, 46.354607, 75.14247, 50.482037, 80.492294, 50.482037);
        ((GeneralPath) shape).curveTo(85.94317, 50.482037, 90.48549, 46.171165, 90.48549, 40.98895);
        ((GeneralPath) shape).curveTo(90.48549, 35.944313, 86.34692, 31.908606, 80.89604, 31.908606);

        g.setPaint(new LinearGradientPaint(new Point2D.Double(-0.566860020160675, 22.650999069213867), new Point2D.Double(-0.3371399939060211, 23.858999252319336), new float[]{0, 1}, new Color[]{WHITE, new Color(0xC8C8C8)}, NO_CYCLE, SRGB, new AffineTransform(48.35339f, 0, 0, 45.86032f, 104.23187f, -1003.5257f)));
        g.fill(shape);

        // _0_37
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(80.847, 12.880036);
        ((GeneralPath) shape).curveTo(51.053547, 12.880036, 26.82021, 35.86392, 26.82021, 64.12124);
        ((GeneralPath) shape).curveTo(26.819515, 92.37857, 51.053547, 115.36245, 80.847, 115.36245);
        ((GeneralPath) shape).curveTo(110.64046, 115.36245, 134.8738, 92.37857, 134.8738, 64.12124);
        ((GeneralPath) shape).curveTo(134.8738, 35.86392, 110.64046, 12.880036, 80.847, 12.880036);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(10.017999649047852, 8.63070011138916), new Point2D.Double(63.487998962402344, 63.65999984741211), new float[]{0, 1}, new Color[]{new Color(0x236B0D), new Color(0x0A2205)}, NO_CYCLE, SRGB, new AffineTransform(2.3119f, 0, 0, 2.1927f, 6.8662f, -6.0445f)));
        g.fill(shape);

        // _0_38
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(132.86475, 64.1219);
        ((GeneralPath) shape).curveTo(132.86475, 91.35523, 109.5608, 113.45765, 80.847, 113.45765);
        ((GeneralPath) shape).curveTo(52.1332, 113.45765, 28.82925, 91.35523, 28.82925, 64.1219);
        ((GeneralPath) shape).curveTo(28.82925, 36.888565, 52.1332, 14.78615, 80.847, 14.78615);
        ((GeneralPath) shape).curveTo(109.5608, 14.78615, 132.86475, 36.888565, 132.86475, 64.1219);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(24.763999938964844, 16.36199951171875), 27.5f, new Point2D.Double(24.763999938964844, 16.36199951171875), new float[]{0, 1}, new Color[]{new Color(0x2EDC32), new Color(0x11661D)}, NO_CYCLE, SRGB, new AffineTransform(0.05829225f, 2.2499294f, -2.2613618f, 0.05272786f, 96.637276f, -13.884937f)));
        g.fill(shape);

        // _0_39
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(80.88631, 14.0323);
        ((GeneralPath) shape).curveTo(59.057343, 14.0323, 40.40031, 26.549986, 32.440437, 44.320065);
        ((GeneralPath) shape).curveTo(43.870472, 50.531982, 56.324677, 55.03579, 69.705956, 54.461304);
        ((GeneralPath) shape).curveTo(82.59248, 53.772797, 93.687294, 45.55236, 106.82582, 46.16851);
        ((GeneralPath) shape).curveTo(116.56817, 45.95801, 127.6491, 49.41809, 132.83932, 57.54424);
        ((GeneralPath) shape).curveTo(129.7275, 33.089054, 107.79913, 14.0323, 80.88631, 14.0323);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(18.386999130249023, 14.04699993133545), 27.5f, new Point2D.Double(18.386999130249023, 14.04699993133545), new float[]{0, 1}, new Color[]{new Color(0xE6E6E6), new Color(0x11661D, true)}, NO_CYCLE, SRGB, new AffineTransform(0.02641115f, 2.4093387f, -4.2631435f, 0.04119645f, 127.4341f, -18.471409f)));
        g.fill(shape);

        // _0_40
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(80.847, 12.867538);
        ((GeneralPath) shape).curveTo(51.053547, 12.867538, 26.806337, 35.864574, 26.806337, 64.1219);
        ((GeneralPath) shape).curveTo(26.806337, 92.37923, 51.053547, 115.37626, 80.847, 115.37626);
        ((GeneralPath) shape).curveTo(110.64046, 115.37626, 134.88766, 92.37923, 134.88766, 64.1219);
        ((GeneralPath) shape).curveTo(134.88766, 35.864574, 110.64046, 12.867538, 80.847, 12.867538);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(80.847, 14.78615);
        ((GeneralPath) shape).curveTo(109.5608, 14.78615, 132.86475, 36.888565, 132.86475, 64.1219);
        ((GeneralPath) shape).curveTo(132.86475, 91.35523, 109.5608, 113.45765, 80.847, 113.45765);
        ((GeneralPath) shape).curveTo(52.1332, 113.45765, 28.82925, 91.35523, 28.82925, 64.1219);
        ((GeneralPath) shape).curveTo(28.82925, 36.888565, 52.1332, 14.78615, 80.847, 14.78615);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(10.017999649047852, 8.63070011138916), new Point2D.Double(63.487998962402344, 63.65999984741211), new float[]{0, 1}, new Color[]{new Color(0x236B0D), new Color(0x0A2205)}, NO_CYCLE, SRGB, new AffineTransform(2.3119f, 0, 0, 2.1927f, 6.859632f, -6.0507293f)));
        g.fill(shape);

        // _0_41
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(89.677986, 53.738117);
        ((GeneralPath) shape).lineTo(83.41961, 53.738117);
        ((GeneralPath) shape).lineTo(65.65457, 56.5356);
        ((GeneralPath) shape).lineTo(65.65457, 64.28599);
        ((GeneralPath) shape).lineTo(67.7739, 64.46943);
        ((GeneralPath) shape).curveTo(72.114586, 64.83631, 73.325836, 66.48729, 73.325836, 72.31155);
        ((GeneralPath) shape).lineTo(73.325836, 86.1155);
        ((GeneralPath) shape).curveTo(73.325836, 91.57288, 72.71997, 92.62767, 68.884575, 93.361435);
        ((GeneralPath) shape).lineTo(65.65457, 94.04934);
        ((GeneralPath) shape).lineTo(65.65457, 101.79973);
        ((GeneralPath) shape).lineTo(97.24819, 101.79973);
        ((GeneralPath) shape).lineTo(97.24819, 94.04934);
        ((GeneralPath) shape).lineTo(94.11924, 93.361435);
        ((GeneralPath) shape).curveTo(90.28337, 92.53595, 89.677986, 91.57288, 89.677986, 86.1155);
        ((GeneralPath) shape).lineTo(89.677986, 53.738117);
        ((GeneralPath) shape).moveTo(80.89604, 31.908606);
        ((GeneralPath) shape).curveTo(75.54623, 31.908606, 70.90333, 36.219475, 70.90333, 41.30997);
        ((GeneralPath) shape).curveTo(70.90333, 46.354607, 75.14247, 50.482037, 80.492294, 50.482037);
        ((GeneralPath) shape).curveTo(85.94317, 50.482037, 90.48549, 46.171165, 90.48549, 40.98895);
        ((GeneralPath) shape).curveTo(90.48549, 35.944313, 86.34692, 31.908606, 80.89604, 31.908606);

        g.setPaint(new LinearGradientPaint(new Point2D.Double(-0.566860020160675, 22.650999069213867), new Point2D.Double(-0.3371399939060211, 23.858999252319336), new float[]{0, 1}, new Color[]{WHITE, new Color(0xC8C8C8)}, NO_CYCLE, SRGB, new AffineTransform(48.35339f, 0, 0, 45.86032f, 104.23187f, -1003.5257f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0

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
        return 1;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     *
     * @return The height of the bounding box of the original SVG image.
     */
    public static int getOrigHeight() {
        return 1;
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
    public Lightbulb() {
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

