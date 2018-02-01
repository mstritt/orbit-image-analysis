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
import java.awt.geom.AffineTransform;
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
public class SvnUpdate implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.transform(new AffineTransform(0.21102925f, 0, 0, 0.20917176f, -15.882479f, -52.677643f));

        // _0_0_0
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 45.061428f, -54.6029f));

        // _0_0_0_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(594.2098, 637.24835);
        ((GeneralPath) shape).curveTo(594.2098, 707.02344, 481.08197, 763.58734, 341.5318, 763.58734);
        ((GeneralPath) shape).curveTo(201.9816, 763.58734, 88.853806, 707.02344, 88.853806, 637.24835);
        ((GeneralPath) shape).curveTo(88.853806, 567.47327, 201.9816, 510.90936, 341.5318, 510.90936);
        ((GeneralPath) shape).curveTo(481.082, 510.90936, 594.2098, 567.47327, 594.2098, 637.24835);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x3D3D3D));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0_0
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 45.061428f, -113.57703f));

        // _0_0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(594.2098, 637.24835);
        ((GeneralPath) shape).curveTo(594.2098, 707.02344, 481.08197, 763.58734, 341.5318, 763.58734);
        ((GeneralPath) shape).curveTo(201.9816, 763.58734, 88.853806, 707.02344, 88.853806, 637.24835);
        ((GeneralPath) shape).curveTo(88.853806, 567.47327, 201.9816, 510.90936, 341.5318, 510.90936);
        ((GeneralPath) shape).curveTo(481.082, 510.90936, 594.2098, 567.47327, 594.2098, 637.24835);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(341.53179931640625, 528.580078125), new Point2D.Double(341.53179931640625, 700.0775146484375), new float[]{0, 1}, new Color[]{new Color(0xFCFCFC), LIGHT_GRAY}, REFLECT, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0_1

        // _0_0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(639.2651, 523.65924);
        ((GeneralPath) shape).curveTo(639.2651, 593.3983, 526.0559, 650.003, 386.5777, 650.003);
        ((GeneralPath) shape).curveTo(247.82579, 650.003, 135.0921, 593.9916, 133.9214, 524.753);
        ((GeneralPath) shape).lineTo(134.9214, 575.003);
        ((GeneralPath) shape).curveTo(134.9214, 644.7421, 247.1306, 701.34674, 386.609, 701.34674);
        ((GeneralPath) shape).curveTo(526.0872, 701.34674, 638.26514, 644.7421, 638.26514, 575.003);
        ((GeneralPath) shape).lineTo(639.26514, 523.65924);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(902.440185546875, 573.3363647460938), 252.67184f, new Point2D.Double(902.440185546875, 777.675048828125), new float[]{0, 0.13883302f, 0.27766603f, 0.3483148f, 0.519832f, 0.6913492f, 0.7199554f, 0.8247441f, 0.9112725f, 1}, new Color[]{WHITE, new Color(0xBCBCBC), new Color(0x8F8F8F), new Color(0xF2F2F2), new Color(0xBBBBBB), new Color(0x3F3F3F), new Color(0x8F8F8F), new Color(0xA4A4A4), new Color(0x5E5E5E), new Color(0xACACAC)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 0.7898656f, -515.84705f, 106.14197f)));
        g.fill(shape);

        // _0_0_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(566.2773, 486.15744);
        ((GeneralPath) shape).curveTo(579.07697, 526.5242, 502.6638, 561.86523, 387.09488, 561.86523);
        ((GeneralPath) shape).curveTo(265.94098, 561.86523, 190.88239, 525.39215, 207.91258, 486.15744);
        ((GeneralPath) shape).curveTo(230.12598, 434.98117, 310.3997, 410.44965, 387.09488, 410.44965);
        ((GeneralPath) shape).curveTo(461.0135, 410.44965, 551.8533, 440.668, 566.2773, 486.15744);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(949.625, 517.85107421875), 119.39729f, new Point2D.Double(942.2240600585938, 440.14154052734375), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1.7097296f, 0.06452833f, -0.05216787f, 0.9870304f, -1209.4918f, -86.25507f)));
        g.fill(shape);

        // _0_0_0_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(134.39008, 519.2338);
        ((GeneralPath) shape).curveTo(134.10378, 521.6951, 133.92128, 524.1743, 133.92137, 526.6713);
        ((GeneralPath) shape).curveTo(133.92137, 596.41046, 247.13057, 653.0151, 386.60876, 653.0151);
        ((GeneralPath) shape).curveTo(526.08704, 653.0151, 639.2651, 596.41046, 639.2651, 526.6713);
        ((GeneralPath) shape).curveTo(639.2651, 524.1743, 639.1139, 521.6951, 638.8276, 519.2338);
        ((GeneralPath) shape).curveTo(631.1191, 585.515, 521.0931, 638.1401, 386.60876, 638.1401);
        ((GeneralPath) shape).curveTo(252.12456, 638.1401, 142.09857, 585.515, 134.39006, 519.2338);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(1302.515625, 396.677001953125), 252.67184f, new Point2D.Double(1302.515625, 396.677001953125), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1.4615498f, 0, 0, 0.7922186f, -1517.0981f, 316.29645f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.50553507f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9792446f, 0, 0, 0.9792446f, -888.8882f, 80.200035f));

        // _0_0_0_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1050.3125, 441.16064);
        ((GeneralPath) shape).curveTo(1050.0262, 443.62198, 1049.8438, 446.10114, 1049.8438, 448.59814);
        ((GeneralPath) shape).curveTo(1049.8438, 518.3373, 1163.053, 574.9419, 1302.5311, 574.9419);
        ((GeneralPath) shape).curveTo(1442.0094, 574.9419, 1555.1874, 518.3373, 1555.1874, 448.59814);
        ((GeneralPath) shape).curveTo(1555.1874, 446.10114, 1555.0361, 443.62198, 1554.7499, 441.16064);
        ((GeneralPath) shape).curveTo(1547.0414, 507.44183, 1437.0154, 566.0669, 1302.5311, 566.0669);
        ((GeneralPath) shape).curveTo(1168.0469, 566.0669, 1058.021, 507.44183, 1050.3124, 441.16064);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(1228.482421875, 349.2613525390625), new Point2D.Double(1228.482421875, 687.31005859375), new float[]{0, 1}, new Color[]{BLACK, new Color(0x474747, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0_5
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_0_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(152.9375, 571.65625);
        ((GeneralPath) shape).curveTo(165.10074, 588.474, 184.4765, 603.8789, 210.03125, 616.65625);
        ((GeneralPath) shape).curveTo(254.92583, 639.1035, 317.48145, 653.1875, 386.59375, 653.1875);
        ((GeneralPath) shape).curveTo(455.70612, 653.1875, 518.26965, 639.1034, 563.15625, 616.65625);
        ((GeneralPath) shape).curveTo(588.5327, 603.9658, 607.79047, 588.6834, 619.96875, 572.0);
        ((GeneralPath) shape).curveTo(605.8334, 587.5018, 586.10754, 601.21936, 562.21875, 612.53125);
        ((GeneralPath) shape).curveTo(516.143, 634.3492, 454.44025, 647.5625, 386.59375, 647.5625);
        ((GeneralPath) shape).curveTo(318.7473, 647.5625, 257.0445, 634.3492, 210.96875, 612.53125);
        ((GeneralPath) shape).curveTo(186.90793, 601.1379, 167.09196, 587.296, 152.9375, 571.65625);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(1302.515625, 396.677001953125), 252.67184f, new Point2D.Double(1302.515625, 396.677001953125), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1.4615498f, 0, 0, 0.7922186f, -1517.0981f, 321.0887f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.6287129f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 0, -309.31973f));

        // _0_0_0_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(639.2651, 873.2777);
        ((GeneralPath) shape).curveTo(639.2651, 943.0168, 526.0559, 999.62146, 386.5777, 999.62146);
        ((GeneralPath) shape).curveTo(247.82579, 999.62146, 135.0921, 943.61005, 133.9214, 874.37146);
        ((GeneralPath) shape).lineTo(134.9214, 924.62146);
        ((GeneralPath) shape).curveTo(134.9214, 994.3606, 247.1306, 1050.9652, 386.609, 1050.9652);
        ((GeneralPath) shape).curveTo(526.0872, 1050.9652, 638.26514, 994.36053, 638.26514, 924.62146);
        ((GeneralPath) shape).lineTo(639.26514, 873.2777);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x4C000000, true));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0_7
        g.setComposite(AlphaComposite.getInstance(3, 0.50553507f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9960461f, 0, 0, 0.9960461f, -910.77246f, 72.38355f));

        // _0_0_0_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1058.9375, 474.46875);
        ((GeneralPath) shape).curveTo(1069.0624, 497.43295, 1092.363, 518.32214, 1125.4062, 534.84375);
        ((GeneralPath) shape).curveTo(1170.5197, 557.40045, 1233.2562, 571.5, 1302.5312, 571.5);
        ((GeneralPath) shape).curveTo(1371.8064, 571.5, 1434.5195, 557.4003, 1479.625, 534.84375);
        ((GeneralPath) shape).curveTo(1512.5835, 518.3617, 1535.8389, 497.52454, 1546.0, 474.625);
        ((GeneralPath) shape).curveTo(1532.4229, 496.34863, 1508.5667, 515.9022, 1477.7188, 531.53125);
        ((GeneralPath) shape).curveTo(1431.8534, 554.769, 1370.2719, 569.5, 1302.5311, 569.5);
        ((GeneralPath) shape).curveTo(1234.7908, 569.5, 1173.2091, 554.769, 1127.3438, 531.53125);
        ((GeneralPath) shape).curveTo(1096.4165, 515.86194, 1072.4963, 496.25967, 1058.9375, 474.46875);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(1228.482421875, 349.2613525390625), new Point2D.Double(1228.482421875, 687.31005859375), new float[]{0, 1}, new Color[]{BLACK, new Color(0x474747, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0_8

        g.setTransform(transformations.poll()); // _0_0_0
        g.setComposite(AlphaComposite.getInstance(3, 0.27227724f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.962813f, 0, 0, 0.87276864f, 17.362375f, -18.873505f));

        // _0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(86.26703, 85.22004);
        ((GeneralPath) shape).curveTo(86.26703, 95.178406, 70.12132, 103.25127, 50.204582, 103.25127);
        ((GeneralPath) shape).curveTo(30.287844, 103.25127, 14.142136, 95.178406, 14.142136, 85.22004);
        ((GeneralPath) shape).curveTo(14.142136, 75.26167, 30.287844, 67.18881, 50.204582, 67.18881);
        ((GeneralPath) shape).curveTo(70.12132, 67.18881, 86.26703, 75.26167, 86.26703, 85.22004);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(11.863568305969238, 97.68323516845703), new Point2D.Double(113.55742645263672, 38.211856842041016), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.setStroke(new BasicStroke(0.49323508f, 0, 0, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_1
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9446751f, 0, 0, 0.85632694f, 18.272984f, -17.472343f));

        // _0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(86.26703, 85.22004);
        ((GeneralPath) shape).curveTo(86.26703, 95.178406, 70.12132, 103.25127, 50.204582, 103.25127);
        ((GeneralPath) shape).curveTo(30.287844, 103.25127, 14.142136, 95.178406, 14.142136, 85.22004);
        ((GeneralPath) shape).curveTo(14.142136, 75.26167, 30.287844, 67.18881, 50.204582, 67.18881);
        ((GeneralPath) shape).curveTo(70.12132, 67.18881, 86.26703, 75.26167, 86.26703, 85.22004);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_2
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.21102925f, 0, 0, 0.20917176f, -15.882479f, -67.67764f));

        // _0_0_3
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 45.061428f, -54.6029f));

        // _0_0_3_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(594.2098, 637.24835);
        ((GeneralPath) shape).curveTo(594.2098, 707.02344, 481.08197, 763.58734, 341.5318, 763.58734);
        ((GeneralPath) shape).curveTo(201.9816, 763.58734, 88.853806, 707.02344, 88.853806, 637.24835);
        ((GeneralPath) shape).curveTo(88.853806, 567.47327, 201.9816, 510.90936, 341.5318, 510.90936);
        ((GeneralPath) shape).curveTo(481.082, 510.90936, 594.2098, 567.47327, 594.2098, 637.24835);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x3D3D3D));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_3_0
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 45.061428f, -113.57703f));

        // _0_0_3_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(594.2098, 637.24835);
        ((GeneralPath) shape).curveTo(594.2098, 707.02344, 481.08197, 763.58734, 341.5318, 763.58734);
        ((GeneralPath) shape).curveTo(201.9816, 763.58734, 88.853806, 707.02344, 88.853806, 637.24835);
        ((GeneralPath) shape).curveTo(88.853806, 567.47327, 201.9816, 510.90936, 341.5318, 510.90936);
        ((GeneralPath) shape).curveTo(481.082, 510.90936, 594.2098, 567.47327, 594.2098, 637.24835);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(341.53179931640625, 528.580078125), new Point2D.Double(341.53179931640625, 700.0775146484375), new float[]{0, 1}, new Color[]{new Color(0xFCFCFC), LIGHT_GRAY}, REFLECT, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_3_1

        // _0_0_3_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(639.2651, 523.65924);
        ((GeneralPath) shape).curveTo(639.2651, 593.3983, 526.0559, 650.003, 386.5777, 650.003);
        ((GeneralPath) shape).curveTo(247.82579, 650.003, 135.0921, 593.9916, 133.9214, 524.753);
        ((GeneralPath) shape).lineTo(134.9214, 575.003);
        ((GeneralPath) shape).curveTo(134.9214, 644.7421, 247.1306, 701.34674, 386.609, 701.34674);
        ((GeneralPath) shape).curveTo(526.0872, 701.34674, 638.26514, 644.7421, 638.26514, 575.003);
        ((GeneralPath) shape).lineTo(639.26514, 523.65924);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(902.440185546875, 573.3363647460938), 252.67184f, new Point2D.Double(902.440185546875, 777.675048828125), new float[]{0, 0.13883302f, 0.27766603f, 0.3483148f, 0.519832f, 0.6913492f, 0.7199554f, 0.8247441f, 0.9112725f, 1}, new Color[]{WHITE, new Color(0xBCBCBC), new Color(0x8F8F8F), new Color(0xF2F2F2), new Color(0xBBBBBB), new Color(0x3F3F3F), new Color(0x8F8F8F), new Color(0xA4A4A4), new Color(0x5E5E5E), new Color(0xACACAC)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 0.7898656f, -515.84705f, 106.14197f)));
        g.fill(shape);

        // _0_0_3_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(566.2773, 486.15744);
        ((GeneralPath) shape).curveTo(579.07697, 526.5242, 502.6638, 561.86523, 387.09488, 561.86523);
        ((GeneralPath) shape).curveTo(265.94098, 561.86523, 190.88239, 525.39215, 207.91258, 486.15744);
        ((GeneralPath) shape).curveTo(230.12598, 434.98117, 310.3997, 410.44965, 387.09488, 410.44965);
        ((GeneralPath) shape).curveTo(461.0135, 410.44965, 551.8533, 440.668, 566.2773, 486.15744);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(949.625, 517.85107421875), 119.39729f, new Point2D.Double(942.2240600585938, 440.14154052734375), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1.7097296f, 0.06452833f, -0.05216787f, 0.9870304f, -1209.4918f, -86.25507f)));
        g.fill(shape);

        // _0_0_3_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(134.39008, 519.2338);
        ((GeneralPath) shape).curveTo(134.10378, 521.6951, 133.92128, 524.1743, 133.92137, 526.6713);
        ((GeneralPath) shape).curveTo(133.92137, 596.41046, 247.13057, 653.0151, 386.60876, 653.0151);
        ((GeneralPath) shape).curveTo(526.08704, 653.0151, 639.2651, 596.41046, 639.2651, 526.6713);
        ((GeneralPath) shape).curveTo(639.2651, 524.1743, 639.1139, 521.6951, 638.8276, 519.2338);
        ((GeneralPath) shape).curveTo(631.1191, 585.515, 521.0931, 638.1401, 386.60876, 638.1401);
        ((GeneralPath) shape).curveTo(252.12456, 638.1401, 142.09857, 585.515, 134.39006, 519.2338);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(1302.515625, 396.677001953125), 252.67184f, new Point2D.Double(1302.515625, 396.677001953125), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1.4615498f, 0, 0, 0.7922186f, -1517.0981f, 316.29645f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.50553507f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9792446f, 0, 0, 0.9792446f, -888.8882f, 80.200035f));

        // _0_0_3_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1050.3125, 441.16064);
        ((GeneralPath) shape).curveTo(1050.0262, 443.62198, 1049.8438, 446.10114, 1049.8438, 448.59814);
        ((GeneralPath) shape).curveTo(1049.8438, 518.3373, 1163.053, 574.9419, 1302.5311, 574.9419);
        ((GeneralPath) shape).curveTo(1442.0094, 574.9419, 1555.1874, 518.3373, 1555.1874, 448.59814);
        ((GeneralPath) shape).curveTo(1555.1874, 446.10114, 1555.0361, 443.62198, 1554.7499, 441.16064);
        ((GeneralPath) shape).curveTo(1547.0414, 507.44183, 1437.0154, 566.0669, 1302.5311, 566.0669);
        ((GeneralPath) shape).curveTo(1168.0469, 566.0669, 1058.021, 507.44183, 1050.3124, 441.16064);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(1228.482421875, 349.2613525390625), new Point2D.Double(1228.482421875, 687.31005859375), new float[]{0, 1}, new Color[]{BLACK, new Color(0x474747, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_3_5
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_3_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(152.9375, 571.65625);
        ((GeneralPath) shape).curveTo(165.10074, 588.474, 184.4765, 603.8789, 210.03125, 616.65625);
        ((GeneralPath) shape).curveTo(254.92583, 639.1035, 317.48145, 653.1875, 386.59375, 653.1875);
        ((GeneralPath) shape).curveTo(455.70612, 653.1875, 518.26965, 639.1034, 563.15625, 616.65625);
        ((GeneralPath) shape).curveTo(588.5327, 603.9658, 607.79047, 588.6834, 619.96875, 572.0);
        ((GeneralPath) shape).curveTo(605.8334, 587.5018, 586.10754, 601.21936, 562.21875, 612.53125);
        ((GeneralPath) shape).curveTo(516.143, 634.3492, 454.44025, 647.5625, 386.59375, 647.5625);
        ((GeneralPath) shape).curveTo(318.7473, 647.5625, 257.0445, 634.3492, 210.96875, 612.53125);
        ((GeneralPath) shape).curveTo(186.90793, 601.1379, 167.09196, 587.296, 152.9375, 571.65625);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(1302.515625, 396.677001953125), 252.67184f, new Point2D.Double(1302.515625, 396.677001953125), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1.4615498f, 0, 0, 0.7922186f, -1517.0981f, 321.0887f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.6287129f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 0, -309.31973f));

        // _0_0_3_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(639.2651, 873.2777);
        ((GeneralPath) shape).curveTo(639.2651, 943.0168, 526.0559, 999.62146, 386.5777, 999.62146);
        ((GeneralPath) shape).curveTo(247.82579, 999.62146, 135.0921, 943.61005, 133.9214, 874.37146);
        ((GeneralPath) shape).lineTo(134.9214, 924.62146);
        ((GeneralPath) shape).curveTo(134.9214, 994.3606, 247.1306, 1050.9652, 386.609, 1050.9652);
        ((GeneralPath) shape).curveTo(526.0872, 1050.9652, 638.26514, 994.36053, 638.26514, 924.62146);
        ((GeneralPath) shape).lineTo(639.26514, 873.2777);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x4C000000, true));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_3_7
        g.setComposite(AlphaComposite.getInstance(3, 0.50553507f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9960461f, 0, 0, 0.9960461f, -910.77246f, 72.38355f));

        // _0_0_3_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1058.9375, 474.46875);
        ((GeneralPath) shape).curveTo(1069.0624, 497.43295, 1092.363, 518.32214, 1125.4062, 534.84375);
        ((GeneralPath) shape).curveTo(1170.5197, 557.40045, 1233.2562, 571.5, 1302.5312, 571.5);
        ((GeneralPath) shape).curveTo(1371.8064, 571.5, 1434.5195, 557.4003, 1479.625, 534.84375);
        ((GeneralPath) shape).curveTo(1512.5835, 518.3617, 1535.8389, 497.52454, 1546.0, 474.625);
        ((GeneralPath) shape).curveTo(1532.4229, 496.34863, 1508.5667, 515.9022, 1477.7188, 531.53125);
        ((GeneralPath) shape).curveTo(1431.8534, 554.769, 1370.2719, 569.5, 1302.5311, 569.5);
        ((GeneralPath) shape).curveTo(1234.7908, 569.5, 1173.2091, 554.769, 1127.3438, 531.53125);
        ((GeneralPath) shape).curveTo(1096.4165, 515.86194, 1072.4963, 496.25967, 1058.9375, 474.46875);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(1228.482421875, 349.2613525390625), new Point2D.Double(1228.482421875, 687.31005859375), new float[]{0, 1}, new Color[]{BLACK, new Color(0x474747, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_3_8

        g.setTransform(transformations.poll()); // _0_0_3
        g.setComposite(AlphaComposite.getInstance(3, 0.27227724f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.962813f, 0, 0, 0.87276864f, 17.362375f, -33.873505f));

        // _0_0_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(86.26703, 85.22004);
        ((GeneralPath) shape).curveTo(86.26703, 95.178406, 70.12132, 103.25127, 50.204582, 103.25127);
        ((GeneralPath) shape).curveTo(30.287844, 103.25127, 14.142136, 95.178406, 14.142136, 85.22004);
        ((GeneralPath) shape).curveTo(14.142136, 75.26167, 30.287844, 67.18881, 50.204582, 67.18881);
        ((GeneralPath) shape).curveTo(70.12132, 67.18881, 86.26703, 75.26167, 86.26703, 85.22004);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(11.863568305969238, 97.68323516845703), new Point2D.Double(113.55742645263672, 38.211856842041016), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_4
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9446751f, 0, 0, 0.85632694f, 18.272984f, -32.472343f));

        // _0_0_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(86.26703, 85.22004);
        ((GeneralPath) shape).curveTo(86.26703, 95.178406, 70.12132, 103.25127, 50.204582, 103.25127);
        ((GeneralPath) shape).curveTo(30.287844, 103.25127, 14.142136, 95.178406, 14.142136, 85.22004);
        ((GeneralPath) shape).curveTo(14.142136, 75.26167, 30.287844, 67.18881, 50.204582, 67.18881);
        ((GeneralPath) shape).curveTo(70.12132, 67.18881, 86.26703, 75.26167, 86.26703, 85.22004);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_5
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.21102925f, 0, 0, 0.20917176f, -15.882479f, -82.67764f));

        // _0_0_6
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 45.061428f, -54.6029f));

        // _0_0_6_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(594.2098, 637.24835);
        ((GeneralPath) shape).curveTo(594.2098, 707.02344, 481.08197, 763.58734, 341.5318, 763.58734);
        ((GeneralPath) shape).curveTo(201.9816, 763.58734, 88.853806, 707.02344, 88.853806, 637.24835);
        ((GeneralPath) shape).curveTo(88.853806, 567.47327, 201.9816, 510.90936, 341.5318, 510.90936);
        ((GeneralPath) shape).curveTo(481.082, 510.90936, 594.2098, 567.47327, 594.2098, 637.24835);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x3D3D3D));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_6_0
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 45.061428f, -113.57703f));

        // _0_0_6_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(594.2098, 637.24835);
        ((GeneralPath) shape).curveTo(594.2098, 707.02344, 481.08197, 763.58734, 341.5318, 763.58734);
        ((GeneralPath) shape).curveTo(201.9816, 763.58734, 88.853806, 707.02344, 88.853806, 637.24835);
        ((GeneralPath) shape).curveTo(88.853806, 567.47327, 201.9816, 510.90936, 341.5318, 510.90936);
        ((GeneralPath) shape).curveTo(481.082, 510.90936, 594.2098, 567.47327, 594.2098, 637.24835);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(341.53179931640625, 528.580078125), new Point2D.Double(341.53179931640625, 700.0775146484375), new float[]{0, 1}, new Color[]{new Color(0xFCFCFC), LIGHT_GRAY}, REFLECT, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_6_1

        // _0_0_6_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(639.2651, 523.65924);
        ((GeneralPath) shape).curveTo(639.2651, 593.3983, 526.0559, 650.003, 386.5777, 650.003);
        ((GeneralPath) shape).curveTo(247.82579, 650.003, 135.0921, 593.9916, 133.9214, 524.753);
        ((GeneralPath) shape).lineTo(134.9214, 575.003);
        ((GeneralPath) shape).curveTo(134.9214, 644.7421, 247.1306, 701.34674, 386.609, 701.34674);
        ((GeneralPath) shape).curveTo(526.0872, 701.34674, 638.26514, 644.7421, 638.26514, 575.003);
        ((GeneralPath) shape).lineTo(639.26514, 523.65924);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(902.440185546875, 573.3363647460938), 252.67184f, new Point2D.Double(902.440185546875, 777.675048828125), new float[]{0, 0.13883302f, 0.27766603f, 0.3483148f, 0.519832f, 0.6913492f, 0.7199554f, 0.8247441f, 0.9112725f, 1}, new Color[]{WHITE, new Color(0xBCBCBC), new Color(0x8F8F8F), new Color(0xF2F2F2), new Color(0xBBBBBB), new Color(0x3F3F3F), new Color(0x8F8F8F), new Color(0xA4A4A4), new Color(0x5E5E5E), new Color(0xACACAC)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 0.7898656f, -515.84705f, 106.14197f)));
        g.fill(shape);

        // _0_0_6_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(566.2773, 486.15744);
        ((GeneralPath) shape).curveTo(579.07697, 526.5242, 502.6638, 561.86523, 387.09488, 561.86523);
        ((GeneralPath) shape).curveTo(265.94098, 561.86523, 190.88239, 525.39215, 207.91258, 486.15744);
        ((GeneralPath) shape).curveTo(230.12598, 434.98117, 310.3997, 410.44965, 387.09488, 410.44965);
        ((GeneralPath) shape).curveTo(461.0135, 410.44965, 551.8533, 440.668, 566.2773, 486.15744);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(949.625, 517.85107421875), 119.39729f, new Point2D.Double(942.2240600585938, 440.14154052734375), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1.7097296f, 0.06452833f, -0.05216787f, 0.9870304f, -1209.4918f, -86.25507f)));
        g.fill(shape);

        // _0_0_6_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(134.39008, 519.2338);
        ((GeneralPath) shape).curveTo(134.10378, 521.6951, 133.92128, 524.1743, 133.92137, 526.6713);
        ((GeneralPath) shape).curveTo(133.92137, 596.41046, 247.13057, 653.0151, 386.60876, 653.0151);
        ((GeneralPath) shape).curveTo(526.08704, 653.0151, 639.2651, 596.41046, 639.2651, 526.6713);
        ((GeneralPath) shape).curveTo(639.2651, 524.1743, 639.1139, 521.6951, 638.8276, 519.2338);
        ((GeneralPath) shape).curveTo(631.1191, 585.515, 521.0931, 638.1401, 386.60876, 638.1401);
        ((GeneralPath) shape).curveTo(252.12456, 638.1401, 142.09857, 585.515, 134.39006, 519.2338);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(1302.515625, 396.677001953125), 252.67184f, new Point2D.Double(1302.515625, 396.677001953125), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1.4615498f, 0, 0, 0.7922186f, -1517.0981f, 316.29645f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.50553507f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9792446f, 0, 0, 0.9792446f, -888.8882f, 80.200035f));

        // _0_0_6_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1050.3125, 441.16064);
        ((GeneralPath) shape).curveTo(1050.0262, 443.62198, 1049.8438, 446.10114, 1049.8438, 448.59814);
        ((GeneralPath) shape).curveTo(1049.8438, 518.3373, 1163.053, 574.9419, 1302.5311, 574.9419);
        ((GeneralPath) shape).curveTo(1442.0094, 574.9419, 1555.1874, 518.3373, 1555.1874, 448.59814);
        ((GeneralPath) shape).curveTo(1555.1874, 446.10114, 1555.0361, 443.62198, 1554.7499, 441.16064);
        ((GeneralPath) shape).curveTo(1547.0414, 507.44183, 1437.0154, 566.0669, 1302.5311, 566.0669);
        ((GeneralPath) shape).curveTo(1168.0469, 566.0669, 1058.021, 507.44183, 1050.3124, 441.16064);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(1228.482421875, 349.2613525390625), new Point2D.Double(1228.482421875, 687.31005859375), new float[]{0, 1}, new Color[]{BLACK, new Color(0x474747, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_6_5
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_6_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(152.9375, 571.65625);
        ((GeneralPath) shape).curveTo(165.10074, 588.474, 184.4765, 603.8789, 210.03125, 616.65625);
        ((GeneralPath) shape).curveTo(254.92583, 639.1035, 317.48145, 653.1875, 386.59375, 653.1875);
        ((GeneralPath) shape).curveTo(455.70612, 653.1875, 518.26965, 639.1034, 563.15625, 616.65625);
        ((GeneralPath) shape).curveTo(588.5327, 603.9658, 607.79047, 588.6834, 619.96875, 572.0);
        ((GeneralPath) shape).curveTo(605.8334, 587.5018, 586.10754, 601.21936, 562.21875, 612.53125);
        ((GeneralPath) shape).curveTo(516.143, 634.3492, 454.44025, 647.5625, 386.59375, 647.5625);
        ((GeneralPath) shape).curveTo(318.7473, 647.5625, 257.0445, 634.3492, 210.96875, 612.53125);
        ((GeneralPath) shape).curveTo(186.90793, 601.1379, 167.09196, 587.296, 152.9375, 571.65625);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(1302.515625, 396.677001953125), 252.67184f, new Point2D.Double(1302.515625, 396.677001953125), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1.4615498f, 0, 0, 0.7922186f, -1517.0981f, 321.0887f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.6287129f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 0, -309.31973f));

        // _0_0_6_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(639.2651, 873.2777);
        ((GeneralPath) shape).curveTo(639.2651, 943.0168, 526.0559, 999.62146, 386.5777, 999.62146);
        ((GeneralPath) shape).curveTo(247.82579, 999.62146, 135.0921, 943.61005, 133.9214, 874.37146);
        ((GeneralPath) shape).lineTo(134.9214, 924.62146);
        ((GeneralPath) shape).curveTo(134.9214, 994.3606, 247.1306, 1050.9652, 386.609, 1050.9652);
        ((GeneralPath) shape).curveTo(526.0872, 1050.9652, 638.26514, 994.36053, 638.26514, 924.62146);
        ((GeneralPath) shape).lineTo(639.26514, 873.2777);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x4C000000, true));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_6_7
        g.setComposite(AlphaComposite.getInstance(3, 0.50553507f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9960461f, 0, 0, 0.9960461f, -910.77246f, 72.38355f));

        // _0_0_6_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1058.9375, 474.46875);
        ((GeneralPath) shape).curveTo(1069.0624, 497.43295, 1092.363, 518.32214, 1125.4062, 534.84375);
        ((GeneralPath) shape).curveTo(1170.5197, 557.40045, 1233.2562, 571.5, 1302.5312, 571.5);
        ((GeneralPath) shape).curveTo(1371.8064, 571.5, 1434.5195, 557.4003, 1479.625, 534.84375);
        ((GeneralPath) shape).curveTo(1512.5835, 518.3617, 1535.8389, 497.52454, 1546.0, 474.625);
        ((GeneralPath) shape).curveTo(1532.4229, 496.34863, 1508.5667, 515.9022, 1477.7188, 531.53125);
        ((GeneralPath) shape).curveTo(1431.8534, 554.769, 1370.2719, 569.5, 1302.5311, 569.5);
        ((GeneralPath) shape).curveTo(1234.7908, 569.5, 1173.2091, 554.769, 1127.3438, 531.53125);
        ((GeneralPath) shape).curveTo(1096.4165, 515.86194, 1072.4963, 496.25967, 1058.9375, 474.46875);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(1228.482421875, 349.2613525390625), new Point2D.Double(1228.482421875, 687.31005859375), new float[]{0, 1}, new Color[]{BLACK, new Color(0x474747, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_6_8

        g.setTransform(transformations.poll()); // _0_0_6
        g.setComposite(AlphaComposite.getInstance(3, 0.27227724f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.962813f, 0, 0, 0.87276864f, 17.362375f, -48.873505f));

        // _0_0_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(86.26703, 85.22004);
        ((GeneralPath) shape).curveTo(86.26703, 95.178406, 70.12132, 103.25127, 50.204582, 103.25127);
        ((GeneralPath) shape).curveTo(30.287844, 103.25127, 14.142136, 95.178406, 14.142136, 85.22004);
        ((GeneralPath) shape).curveTo(14.142136, 75.26167, 30.287844, 67.18881, 50.204582, 67.18881);
        ((GeneralPath) shape).curveTo(70.12132, 67.18881, 86.26703, 75.26167, 86.26703, 85.22004);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(11.863568305969238, 97.68323516845703), new Point2D.Double(113.55742645263672, 38.211856842041016), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_7
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9446751f, 0, 0, 0.85632694f, 18.272984f, -47.472343f));

        // _0_0_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(86.26703, 85.22004);
        ((GeneralPath) shape).curveTo(86.26703, 95.178406, 70.12132, 103.25127, 50.204582, 103.25127);
        ((GeneralPath) shape).curveTo(30.287844, 103.25127, 14.142136, 95.178406, 14.142136, 85.22004);
        ((GeneralPath) shape).curveTo(14.142136, 75.26167, 30.287844, 67.18881, 50.204582, 67.18881);
        ((GeneralPath) shape).curveTo(70.12132, 67.18881, 86.26703, 75.26167, 86.26703, 85.22004);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_8
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.6433923f, 0, 0, 0.6433923f, 122.76455f, 84.17055f));

        // _0_0_9

        g.setTransform(transformations.poll()); // _0_0_9
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.6433923f, 0, 0, 0.6433923f, 122.76455f, 84.17055f));

        // _0_0_10

        g.setTransform(transformations.poll()); // _0_0_10
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_11
        g.setComposite(AlphaComposite.getInstance(3, 0.501845f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.48572138f, 0, 0, 0.41509455f, 66.84616f, 67.7119f));

        // _0_0_12

        g.setTransform(transformations.poll()); // _0_0_12
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_13
        shape = new GeneralPath();

        g.setPaint(BLACK);
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.333692f, 0, 0, 0.333692f, -733.63837f, -244.4025f));

        // _0_0_14

        g.setTransform(transformations.poll()); // _0_0_14
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, -28.032393f, 0));

        // _0_0_15

        // _0_0_15_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(126.87202, 82.900795);
        ((GeneralPath) shape).lineTo(95.925125, 125.65247);
        ((GeneralPath) shape).curveTo(95.47954, 126.27374, 94.81932, 126.63298, 94.12311, 126.63298);
        ((GeneralPath) shape).curveTo(93.426895, 126.63298, 92.76667, 126.27374, 92.32109, 125.65247);
        ((GeneralPath) shape).lineTo(61.380028, 82.46643);
        ((GeneralPath) shape).curveTo(59.718155, 79.848816, 59.482674, 76.089226, 63.165054, 76.089226);
        ((GeneralPath) shape).lineTo(79.95998, 76.089226);
        ((GeneralPath) shape).lineTo(79.95998, 62.53485);
        ((GeneralPath) shape).curveTo(79.95955, 61.02988, 81.191315, 60.007187, 82.48716, 60.00766);
        ((GeneralPath) shape).lineTo(105.50521, 59.91843);
        ((GeneralPath) shape).curveTo(106.80106, 59.917957, 108.03282, 60.940655, 108.032394, 62.44562);
        ((GeneralPath) shape).lineTo(108.032394, 76.0);
        ((GeneralPath) shape).lineTo(124.44936, 76.08923);
        ((GeneralPath) shape).curveTo(126.90776, 76.08923, 128.5897, 80.52477, 126.872025, 82.900795);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(186.92596435546875, 89.88978576660156), new Point2D.Double(242.8547821044922, 91.35980987548828), new float[]{0, 1}, new Color[]{new Color(0x081E3E), new Color(0x387DE4)}, NO_CYCLE, SRGB, new AffineTransform(0, -0.6317969f, -0.5440064f, 0, 135.46548f, 197.39423f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.25468165f * origAlpha));

        // _0_0_15_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(126.87202, 82.900795);
        ((GeneralPath) shape).lineTo(95.925125, 125.65247);
        ((GeneralPath) shape).curveTo(95.47954, 126.27374, 94.81932, 126.63298, 94.12311, 126.63298);
        ((GeneralPath) shape).curveTo(93.426895, 126.63298, 92.76667, 126.27374, 92.32109, 125.65247);
        ((GeneralPath) shape).lineTo(61.380028, 82.46643);
        ((GeneralPath) shape).curveTo(59.718155, 79.848816, 59.482674, 76.089226, 63.165054, 76.089226);
        ((GeneralPath) shape).lineTo(79.95998, 76.089226);
        ((GeneralPath) shape).lineTo(79.95998, 62.53485);
        ((GeneralPath) shape).curveTo(79.95955, 61.02988, 81.191315, 60.007187, 82.48716, 60.00766);
        ((GeneralPath) shape).lineTo(105.45904, 60.00766);
        ((GeneralPath) shape).curveTo(106.75489, 60.007187, 107.98665, 61.029884, 107.98622, 62.53485);
        ((GeneralPath) shape).lineTo(107.98622, 76.089226);
        ((GeneralPath) shape).lineTo(124.44936, 76.089226);
        ((GeneralPath) shape).curveTo(126.90776, 76.089226, 128.5897, 80.524765, 126.872025, 82.90079);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(68.02018737792969, 88.27139282226562), 60, new Point2D.Double(68.02018737792969, 88.27139282226562), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(0.03037963f, -0.36638343f, -0.7259783f, -0.06019639f, 164.45135f, 124.58737f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0, -0.6317969f, -0.6317969f, 0, 134.5581f, 129.16017f));

        // _0_0_15_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(76.5, 11.0625);
        ((GeneralPath) shape).curveTo(75.42291, 11.12778, 74.3861, 11.439286, 73.5, 12.0);
        ((GeneralPath) shape).lineTo(75.875, 19.625);
        ((GeneralPath) shape).lineTo(84.0, 16.46875);
        ((GeneralPath) shape).lineTo(84.0, 16.0);
        ((GeneralPath) shape).curveTo(84.0, 13.081648, 80.06108, 10.846661, 76.5, 11.0625);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(73.74263763427734, 15.336544036865234), new Point2D.Double(78.93933868408203, 16.75075912475586), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, REFLECT, SRGB, new AffineTransform(1, 0, 0, 1, 4, 0)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_15_2
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0, -0.6317969f, 0.6317969f, 0, 55.20912f, 136.12329f));

        // _0_0_15_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(115.65112, 40.0);
        ((GeneralPath) shape).curveTo(115.31168, 41.15456, 113.08862, 46.125, 113.08862, 46.125);
        ((GeneralPath) shape).lineTo(119.83862, 46.09375);
        ((GeneralPath) shape).lineTo(119.83862, 44.0);
        ((GeneralPath) shape).curveTo(119.839386, 41.94895, 118.220665, 39.999344, 115.83862, 40.0);
        ((GeneralPath) shape).lineTo(115.65112, 40.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(223.32711791992188, 53.78415298461914), new Point2D.Double(226.65899658203125, 57.279232025146484), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, REFLECT, SRGB, new AffineTransform(1, 0, 0, 0.8610463f, -108.16138f, -1.4361867f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_15_3

        // _0_0_15_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(126.87202, 82.900795);
        ((GeneralPath) shape).lineTo(95.925125, 125.65247);
        ((GeneralPath) shape).curveTo(95.47954, 126.27374, 94.81932, 126.63298, 94.12311, 126.63298);
        ((GeneralPath) shape).curveTo(93.426895, 126.63298, 92.76667, 126.27374, 92.32109, 125.65247);
        ((GeneralPath) shape).lineTo(61.380028, 82.46643);
        ((GeneralPath) shape).curveTo(59.718155, 79.848816, 59.482674, 76.089226, 63.165054, 76.089226);
        ((GeneralPath) shape).lineTo(79.95998, 76.089226);
        ((GeneralPath) shape).lineTo(79.95998, 62.53485);
        ((GeneralPath) shape).curveTo(79.95955, 61.02988, 81.191315, 60.007187, 82.48716, 60.00766);
        ((GeneralPath) shape).lineTo(105.45904, 60.00766);
        ((GeneralPath) shape).curveTo(106.75489, 60.007187, 107.98665, 61.029884, 107.98622, 62.53485);
        ((GeneralPath) shape).lineTo(107.98622, 76.089226);
        ((GeneralPath) shape).lineTo(124.44936, 76.089226);
        ((GeneralPath) shape).curveTo(126.90776, 76.089226, 128.5897, 80.524765, 126.872025, 82.90079);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(-23.234317779541016, 61.87726593017578), 60, new Point2D.Double(-23.234317779541016, 61.87726593017578), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(-0.0111687f, -0.3674711f, -0.5609713f, 0.01704983f, 130.80405f, 108.99204f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.70411986f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0, -0.52542835f, 0.6317969f, 0, 53.192677f, 118.1235f));

        // _0_0_15_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(72.5, 11.0625);
        ((GeneralPath) shape).curveTo(71.42291, 11.12778, 70.3861, 11.439286, 69.5, 12.0);
        ((GeneralPath) shape).lineTo(71.875, 19.625);
        ((GeneralPath) shape).lineTo(80.0, 16.46875);
        ((GeneralPath) shape).lineTo(80.0, 16.0);
        ((GeneralPath) shape).curveTo(80.0, 13.081648, 76.06108, 10.846661, 72.5, 11.0625);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(74.75, 14.275883674621582), new Point2D.Double(78.93933868408203, 16.75075912475586), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, REFLECT, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_15_5
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.63154244f, 0.01793175f, -0.01793175f, 0.63154244f, 32.526802f, 33.165813f));

        // _0_0_15_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(115.65112, 40.0);
        ((GeneralPath) shape).curveTo(115.31168, 41.15456, 113.08862, 46.125, 113.08862, 46.125);
        ((GeneralPath) shape).lineTo(119.83862, 46.09375);
        ((GeneralPath) shape).lineTo(119.83862, 44.0);
        ((GeneralPath) shape).curveTo(119.839386, 41.94895, 118.220665, 39.999344, 115.83862, 40.0);
        ((GeneralPath) shape).lineTo(115.65112, 40.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(223.32711791992188, 53.78415298461914), new Point2D.Double(226.65899658203125, 57.279232025146484), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, REFLECT, SRGB, new AffineTransform(1, 0, 0, 0.8610463f, -108.16138f, -1.4361867f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_15_6
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.6317969f, 0, 0, -0.6317969f, 53.71142f, 129.1701f));

        // _0_0_15_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(61.556484, 5.221757);
        ((GeneralPath) shape).curveTo(63.245625, 3.7628593, 64.797745, 4.1537676, 66.30962, 5.087866);
        ((GeneralPath) shape).lineTo(64.06695, 18.984468);
        ((GeneralPath) shape).lineTo(61.556484, 5.221757);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(63.93305587768555, 7.566767692565918), new Point2D.Double(66.20711517333984, 7.566767692565918), new float[]{0, 1}, new Color[]{new Color(0x63E9FF), new Color(0xFFFFFF, true)}, REFLECT, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_15_7

        // _0_0_15_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(126.87202, 82.900795);
        ((GeneralPath) shape).lineTo(95.925125, 125.65247);
        ((GeneralPath) shape).curveTo(95.47954, 126.27374, 94.81932, 126.63298, 94.12311, 126.63298);
        ((GeneralPath) shape).curveTo(93.426895, 126.63298, 92.76667, 126.27374, 92.32109, 125.65247);
        ((GeneralPath) shape).lineTo(61.380028, 82.46643);
        ((GeneralPath) shape).curveTo(59.718155, 79.848816, 59.482674, 76.089226, 63.165054, 76.089226);
        ((GeneralPath) shape).lineTo(79.95998, 76.089226);
        ((GeneralPath) shape).lineTo(79.95998, 62.53485);
        ((GeneralPath) shape).curveTo(79.95955, 61.02988, 81.191315, 60.007187, 82.48716, 60.00766);
        ((GeneralPath) shape).lineTo(105.45904, 60.00766);
        ((GeneralPath) shape).curveTo(106.75489, 60.007187, 107.98665, 61.029884, 107.98622, 62.53485);
        ((GeneralPath) shape).lineTo(107.98622, 76.089226);
        ((GeneralPath) shape).lineTo(124.44936, 76.089226);
        ((GeneralPath) shape).curveTo(126.90776, 76.089226, 128.5897, 80.524765, 126.872025, 82.90079);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(64, 46.527523040771484), 53.298492f, new Point2D.Double(64, 46.527523040771484), new float[]{0, 1}, new Color[]{new Color(0x2E6AC4), new Color(0x2E6AC4, true)}, NO_CYCLE, SRGB, new AffineTransform(1.5249295f, 0.0155626f, -0.00188594f, 0.18479732f, -3.361311f, 66.9959f)));
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0, -0.6317969f, -0.5439686f, 0, 135.46472f, 197.39423f));

        // _0_0_15_9

        // _0_0_15_9_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(179.33453, 26.979963);
        ((GeneralPath) shape).lineTo(123.653824, 73.57467);
        ((GeneralPath) shape).curveTo(122.26802, 75.18421, 122.48985, 76.59585, 123.551384, 77.82877);
        ((GeneralPath) shape).lineTo(177.78409, 123.563644);
        ((GeneralPath) shape).curveTo(181.78409, 127.14578, 185.78409, 127.336876, 185.78409, 123.563644);
        ((GeneralPath) shape).lineTo(185.81009, 94.609726);
        ((GeneralPath) shape).lineTo(211.13469, 94.609726);
        ((GeneralPath) shape).lineTo(211.13474, 57.8429);
        ((GeneralPath) shape).lineTo(185.81013, 57.8429);
        ((GeneralPath) shape).lineTo(185.78413, 29.44426);
        ((GeneralPath) shape).curveTo(185.78413, 26.253387, 182.63127, 24.76931, 179.33458, 26.979967);
        ((GeneralPath) shape).lineTo(179.33456, 26.979967);
        ((GeneralPath) shape).lineTo(179.33453, 26.979967);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(136.6140899658203, 76.10952758789062), 56, new Point2D.Double(136.6140899658203, 76.10952758789062), new float[]{0, 0.5f, 1}, new Color[]{new Color(0x9FC1F2), new Color(0x587EB5), new Color(0x0C2A58)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1.1383929f, 0, -10.517857f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_15_9
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0, -0.6317969f, -0.5439686f, 0, 135.59108f, 258.80682f));

        // _0_0_15_10

        // _0_0_15_10_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(276.49283, 26.97996);
        ((GeneralPath) shape).lineTo(220.85384, 73.80696);
        ((GeneralPath) shape).curveTo(219.46803, 75.416504, 219.68987, 76.82814, 220.75139, 78.061066);
        ((GeneralPath) shape).lineTo(274.94238, 123.563644);
        ((GeneralPath) shape).curveTo(278.94238, 127.14578, 282.94238, 127.336876, 282.94238, 123.563644);
        ((GeneralPath) shape).lineTo(283.0131, 94.842026);
        ((GeneralPath) shape).lineTo(308.3377, 94.84202);
        ((GeneralPath) shape).lineTo(308.3377, 58.07519);
        ((GeneralPath) shape).lineTo(283.01312, 58.04835);
        ((GeneralPath) shape).lineTo(283.01224, 57.715527);
        ((GeneralPath) shape).lineTo(282.94244, 29.444254);
        ((GeneralPath) shape).curveTo(282.94244, 26.253382, 279.78958, 24.769304, 276.4929, 26.979961);
        ((GeneralPath) shape).lineTo(276.49286, 26.979965);
        ((GeneralPath) shape).lineTo(276.4929, 26.979965);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(119.33738708496094, 59.541107177734375), new Point2D.Double(178.90383911132812, 61.049652099609375), new float[]{0, 1}, new Color[]{new Color(0x63E9FF), new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 97, 0)));
        g.setStroke(new BasicStroke(1.7057853f, 1, 1, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_15_10

        // _0_0_15_11
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(84.0, 64.0);
        ((GeneralPath) shape).lineTo(84.0, 80.0);
        ((GeneralPath) shape).lineTo(68.24172, 80.02621);
        ((GeneralPath) shape).curveTo(66.1892, 80.02621, 66.29315, 82.5534, 68.24172, 85.08058);
        ((GeneralPath) shape).lineTo(73.32661, 91.93343);
        ((GeneralPath) shape).curveTo(76.51979, 92.14834, 77.473785, 92.269066, 80.77997, 92.269066);
        ((GeneralPath) shape).curveTo(95.76103, 92.269066, 106.70982, 91.38768, 118.412415, 87.46957);
        ((GeneralPath) shape).lineTo(120.781654, 84.0934);
        ((GeneralPath) shape).curveTo(121.98418, 82.01056, 121.17483, 80.02621, 119.439095, 80.02621);
        ((GeneralPath) shape).lineTo(104.0, 80.0);
        ((GeneralPath) shape).lineTo(104.0, 64.0);
        ((GeneralPath) shape).lineTo(84.0, 64.0);
        ((GeneralPath) shape).lineTo(84.0, 64.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(111.81199645996094, 2.8030190467834473), new Point2D.Double(112, 75.10427856445312), new float[]{0, 1}, new Color[]{new Color(0xCDEEFF), new Color(0xD2E8ED, true)}, NO_CYCLE, SRGB, new AffineTransform(0.6317969f, 0, 0, 0.6317969f, 53.71142f, 48.280224f)));
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.6317969f, 0, 0, 0.6317969f, 143.54482f, 48.280224f));

        // _0_0_15_12

        // _0_0_15_12_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-94.24676, 24.881062);
        ((GeneralPath) shape).lineTo(-94.24676, 25.88106);
        ((GeneralPath) shape).lineTo(-63.31684, 25.95174);
        ((GeneralPath) shape).lineTo(-62.59102, 24.881062);
        ((GeneralPath) shape).lineTo(-94.246765, 24.881062);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(-118.93914, 50.247154);
        ((GeneralPath) shape).curveTo(-120.702, 50.247154, -121.45124, 51.436893, -121.28289, 53.153404);
        ((GeneralPath) shape).curveTo(-121.10926, 51.991547, -120.33656, 51.247154, -118.93914, 51.247154);
        ((GeneralPath) shape).lineTo(-97.96875, 51.247154);
        ((GeneralPath) shape).lineTo(-94.226425, 50.205658);
        ((GeneralPath) shape).lineTo(-118.93914, 50.247158);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(-62.591015, 50.205654);
        ((GeneralPath) shape).lineTo(-63.350227, 51.247154);
        ((GeneralPath) shape).lineTo(-37.90461, 51.247154);
        ((GeneralPath) shape).curveTo(-36.220592, 51.247154, -35.091072, 52.418156, -34.90461, 54.090904);
        ((GeneralPath) shape).curveTo(-34.682312, 51.908, -35.901196, 50.247154, -37.90461, 50.247154);
        ((GeneralPath) shape).lineTo(-62.59101, 50.205654);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(111.81199645996094, 2.8030190467834473), new Point2D.Double(112, 75.10427856445312), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, -141.92468f, 0)));
        g.fill(shape);

        // _0_0_15_12_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-63.31159, 25.944496);
        ((GeneralPath) shape).lineTo(-63.35787, 51.24436);
        ((GeneralPath) shape).lineTo(-62.591, 50.205658);
        ((GeneralPath) shape).lineTo(-62.591003, 24.881065);
        ((GeneralPath) shape).lineTo(-63.311584, 25.9445);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(-35.778225, 53.07994);
        ((GeneralPath) shape).curveTo(-35.773125, 54.028244, -35.554813, 53.717487, -36.184475, 54.822155);
        ((GeneralPath) shape).lineTo(-40.234474, 60.459656);
        ((GeneralPath) shape).curveTo(-58.757195, 67.074814, -75.970215, 68.56427, -99.68205, 69.09375);
        ((GeneralPath) shape).curveTo(-104.754005, 69.20701, -109.746445, 69.14874, -114.650795, 68.9375);
        ((GeneralPath) shape).lineTo(-114.525795, 69.09375);
        ((GeneralPath) shape).curveTo(-109.471664, 69.4339, -104.32127, 69.625, -99.0883, 69.625);
        ((GeneralPath) shape).curveTo(-75.37647, 69.625, -58.36344, 68.22995, -39.84072, 62.0284);
        ((GeneralPath) shape).lineTo(-36.09072, 56.68465);
        ((GeneralPath) shape).curveTo(-34.92921, 54.672855, -34.95845, 54.297287, -35.77822, 53.079937);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(79.73841094970703, 82.60218811035156), new Point2D.Double(50.94560623168945, 22.886703491210938), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, -141.92552f, 0)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_15_12

        g.setTransform(transformations.poll()); // _0_0_15

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
    public SvnUpdate() {
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

