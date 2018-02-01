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
public class EditDeleteShred implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.transform(new AffineTransform(1.1080127f, 0, 0, 1.1080127f, -165.19827f, -16.799255f));

        // _0_0_0
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 153.16399f, 13.518947f));

        // _0_0_0_0
        g.setComposite(AlphaComposite.getInstance(3, 0.544f * origAlpha));

        // _0_0_0_0_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(11.736314, 15.103483);
        ((GeneralPath) shape).lineTo(7.106703, 20.598568);
        ((GeneralPath) shape).lineTo(6.5471587, 69.22486);
        ((GeneralPath) shape).lineTo(16.31857, 105.86016);
        ((GeneralPath) shape).lineTo(56.237957, 112.79081);
        ((GeneralPath) shape).lineTo(88.83992, 80.34411);
        ((GeneralPath) shape).lineTo(83.05509, 15.420126);
        ((GeneralPath) shape).lineTo(72.55149, 5.509303);
        ((GeneralPath) shape).lineTo(46.370148, 24.86561);
        ((GeneralPath) shape).lineTo(22.037128, 15.103483);
        ((GeneralPath) shape).lineTo(19.192429, 8.556951);
        ((GeneralPath) shape).lineTo(11.736314, 15.103483);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.setStroke(new BasicStroke(5.415101f, 1, 1, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(11.260806, 13.893782);
        ((GeneralPath) shape).lineTo(6.569972, 19.461536);
        ((GeneralPath) shape).lineTo(6.122074, 69.09127);
        ((GeneralPath) shape).lineTo(15.652862, 106.10144);
        ((GeneralPath) shape).lineTo(56.350952, 112.87295);
        ((GeneralPath) shape).lineTo(89.38405, 79.99717);
        ((GeneralPath) shape).lineTo(83.52273, 14.214613);
        ((GeneralPath) shape).lineTo(72.88022, 4.172726);
        ((GeneralPath) shape).lineTo(46.35265, 23.785007);
        ((GeneralPath) shape).lineTo(21.697842, 13.893782);
        ((GeneralPath) shape).lineTo(18.815521, 7.260677);
        ((GeneralPath) shape).lineTo(11.260806, 13.893782);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(-25, 106.49996185302734), 45, new Point2D.Double(-25, 106.49996185302734), new float[]{0, 0.4259708f, 0.5892781f, 0.8021978f, 1}, new Color[]{WHITE, WHITE, new Color(0xF1F1F1), new Color(0xEAEAEA), new Color(0xDFDFDF)}, NO_CYCLE, SRGB, new AffineTransform(3.304423f, -0.06021802f, 0.06740556f, 3.506126f, 164.8159f, -262.0347f)));
        g.fill(shape);
        g.setPaint(WHITE);
        g.setStroke(new BasicStroke(1.8050337f, 0, 0, 4));
        g.draw(shape);

        // _0_0_0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(83.1369, 13.8313);
        ((GeneralPath) shape).curveTo(83.1255, 13.838804, 83.01691, 13.911898, 83.011, 13.914836);
        ((GeneralPath) shape).curveTo(83.011, 13.914836, 73.39822, 72.0977, 74.07184, 72.0977);
        ((GeneralPath) shape).curveTo(74.64337, 72.0977, 85.02032, 71.52874, 88.6347, 71.34588);
        ((GeneralPath) shape).lineTo(83.51462, 14.207212);
        ((GeneralPath) shape).lineTo(83.1369, 13.8313);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(5.61745023727417, 14.175036430358887), new Point2D.Double(78.43311309814453, 33.486366271972656), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(1.342973f, 0, 0, 1.336577f, -18.5513f, -0.954583f)));
        g.fill(shape);

        // _0_0_0_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(17.311823, 43.42109);
        ((GeneralPath) shape).lineTo(17.311823, 94.39409);
        ((GeneralPath) shape).lineTo(56.35093, 112.87295);
        ((GeneralPath) shape).lineTo(89.38402, 79.99717);
        ((GeneralPath) shape).lineTo(89.38402, 43.42109);
        ((GeneralPath) shape).lineTo(17.311823, 43.42109);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(-24.852529525756836, 99.77497100830078), 46, new Point2D.Double(-24.852529525756836, 99.77497100830078), new float[]{0, 0.4065934f, 0.45329672f, 0.5f, 0.70604396f, 1}, new Color[]{BLACK, new Color(0xAE000000, true), new Color(0x7C000000, true), new Color(0x5C000000, true), new Color(0x27000000, true), new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(0.891156f, -0.802687f, 0.849938f, 0.93465f, 18.95693f, -5.057665f)));
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 114.3422f, 61.23268f));

        // _0_0_0_0_4

        g.setTransform(transformations.poll()); // _0_0_0_0_4
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 114.3422f, 61.23268f));

        // _0_0_0_0_5

        g.setTransform(transformations.poll()); // _0_0_0_0_5

        // _0_0_0_0_6

        // _0_0_0_0_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(11.260796, 13.893782);
        ((GeneralPath) shape).lineTo(6.569964, 19.461536);
        ((GeneralPath) shape).lineTo(6.100688, 69.124756);
        ((GeneralPath) shape).lineTo(15.697544, 105.95886);
        ((GeneralPath) shape).lineTo(56.35093, 112.87295);
        ((GeneralPath) shape).lineTo(89.38402, 79.99717);
        ((GeneralPath) shape).lineTo(83.5227, 14.214613);
        ((GeneralPath) shape).lineTo(72.880196, 4.1727266);
        ((GeneralPath) shape).lineTo(46.35263, 23.785007);
        ((GeneralPath) shape).lineTo(21.697828, 13.893782);
        ((GeneralPath) shape).lineTo(18.81551, 7.260677);
        ((GeneralPath) shape).lineTo(11.260796, 13.893782);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(-25, 106.49996185302734), 45, new Point2D.Double(-25, 106.49996185302734), new float[]{0, 0.4259708f, 0.5892781f, 0.8021978f, 1}, new Color[]{WHITE, WHITE, new Color(0xF1F1F1), new Color(0xEAEAEA), new Color(0xDFDFDF)}, NO_CYCLE, SRGB, new AffineTransform(3.304422f, -0.06021802f, 0.06740554f, 3.506126f, 164.8159f, -262.0347f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.27999997f * origAlpha));

        // _0_0_0_0_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(83.1369, 13.8313);
        ((GeneralPath) shape).curveTo(83.1255, 13.838804, 83.01691, 13.911898, 83.011, 13.914836);
        ((GeneralPath) shape).curveTo(83.011, 13.914836, 76.90936, 55.16894, 74.07184, 72.0977);
        ((GeneralPath) shape).curveTo(73.97736, 72.66137, 85.02032, 71.52874, 88.6347, 71.34588);
        ((GeneralPath) shape).lineTo(83.51462, 14.207212);
        ((GeneralPath) shape).lineTo(83.1369, 13.8313);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(-77.42876434326172, 190.54241943359375), new Point2D.Double(96.13469696044922, 13.831299781799316), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.25f * origAlpha));

        // _0_0_0_0_9
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(72.90315, 4.207369);
        ((GeneralPath) shape).lineTo(71.11693, 50.66494);
        ((GeneralPath) shape).lineTo(69.23583, 87.08621);
        ((GeneralPath) shape).lineTo(46.22893, 23.6437);
        ((GeneralPath) shape).lineTo(72.90315, 4.207369);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(96.6502456665039, 5.458127975463867), new Point2D.Double(54.975372314453125, 9.625616073608398), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(1.342973f, 0, 0, 1.336577f, -18.5513f, -0.954583f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_0_0_10
        g.setComposite(AlphaComposite.getInstance(3, 0.34836066f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.342973f, 0, 0, 1.336577f, -18.5513f, -0.954583f));

        // _0_0_0_0_11
        g.setComposite(AlphaComposite.getInstance(3, 0.15163933f * origAlpha));

        // _0_0_0_0_11_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(48.341026, 18.52733);
        ((GeneralPath) shape).lineTo(58.927536, 51.636658);
        ((GeneralPath) shape).lineTo(44.26558, 16.897154);
        ((GeneralPath) shape).lineTo(48.341026, 18.52733);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);

        // _0_0_0_0_11_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(48.341026, 18.52733);
        ((GeneralPath) shape).lineTo(56.086304, 42.77849);
        ((GeneralPath) shape).lineTo(45.064995, 17.226322);
        ((GeneralPath) shape).lineTo(48.341026, 18.52733);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        // _0_0_0_0_11_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(48.341026, 18.52733);
        ((GeneralPath) shape).lineTo(56.97335, 45.499283);
        ((GeneralPath) shape).lineTo(47.14874, 18.068687);
        ((GeneralPath) shape).lineTo(48.341026, 18.52733);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0_0_11
        g.setComposite(AlphaComposite.getInstance(3, 0.43442622f * origAlpha));

        // _0_0_0_0_12
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(18.84023, 7.5257673);
        ((GeneralPath) shape).lineTo(33.606316, 44.502205);
        ((GeneralPath) shape).lineTo(27.175922, 59.197964);
        ((GeneralPath) shape).lineTo(31.343767, 44.73923);
        ((GeneralPath) shape).lineTo(17.173092, 8.947938);
        ((GeneralPath) shape).lineTo(18.84023, 7.5257673);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);

        // _0_0_0_0_13
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(18.84023, 7.5257673);
        ((GeneralPath) shape).lineTo(33.606316, 44.502205);
        ((GeneralPath) shape).lineTo(27.175922, 59.197964);
        ((GeneralPath) shape).lineTo(32.4155, 44.73923);
        ((GeneralPath) shape).lineTo(17.88758, 8.473881);
        ((GeneralPath) shape).lineTo(18.84023, 7.5257673);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_0_0_14
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(6.060533, 69.815216);
        ((GeneralPath) shape).lineTo(24.898544, 100.44896);
        ((GeneralPath) shape).lineTo(30.239304, 91.18235);
        ((GeneralPath) shape).lineTo(55.71824, 113.20301);
        ((GeneralPath) shape).lineTo(15.716198, 106.12119);
        ((GeneralPath) shape).lineTo(6.060533, 69.815216);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(-88.02957153320312, 196.5928192138672), new Point2D.Double(43.88938522338867, 91.50910949707031), new float[]{0, 1}, new Color[]{new Color(0xF4F5F8), new Color(0xFDFDFE)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, -13, 0)));
        g.fill(shape);

        // _0_0_0_0_15
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(15.729063, 106.00985);
        ((GeneralPath) shape).lineTo(24.950739, 100.33498);
        ((GeneralPath) shape).lineTo(30.270935, 91.024635);
        ((GeneralPath) shape).lineTo(23.798029, 99.58128);
        ((GeneralPath) shape).lineTo(15.019704, 103.30542);
        ((GeneralPath) shape).lineTo(15.729063, 106.00985);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xF000000, true));
        g.fill(shape);

        // _0_0_0_0_16
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(15.729063, 106.00985);
        ((GeneralPath) shape).lineTo(24.950739, 100.33498);
        ((GeneralPath) shape).lineTo(30.270935, 91.024635);
        ((GeneralPath) shape).lineTo(24.463055, 99.98029);
        ((GeneralPath) shape).lineTo(15.285714, 104.45813);
        ((GeneralPath) shape).lineTo(15.729063, 106.00985);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0_0

        g.setTransform(transformations.poll()); // _0_0_0
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 214.92589f, -100.31048f));

        // _0_0_1

        g.setTransform(transformations.poll()); // _0_0_1
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 214.92589f, -100.31048f));

        // _0_0_2

        g.setTransform(transformations.poll()); // _0_0_2
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.1276596f, 0, 0, 1.1276596f, -22.021275f, -16.085106f));

        // _0_0_3

        // _0_0_3_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(88.47965, 79.007095);
        ((GeneralPath) shape).curveTo(87.98245, 79.011086, 87.50644, 79.20897, 87.15296, 79.55865);
        ((GeneralPath) shape).lineTo(79.05864, 87.65297);
        ((GeneralPath) shape).curveTo(78.31379, 88.39812, 78.31379, 89.60593, 79.05864, 90.351074);
        ((GeneralPath) shape).lineTo(91.19267, 102.50002);
        ((GeneralPath) shape).lineTo(79.05864, 114.64895);
        ((GeneralPath) shape).curveTo(78.31379, 115.3941, 78.31379, 116.60191, 79.05864, 117.34706);
        ((GeneralPath) shape).lineTo(87.15296, 125.44138);
        ((GeneralPath) shape).curveTo(87.89811, 126.18623, 89.10591, 126.18623, 89.85106, 125.44138);
        ((GeneralPath) shape).lineTo(102.00001, 113.30735);
        ((GeneralPath) shape).lineTo(114.14894, 125.44138);
        ((GeneralPath) shape).curveTo(114.8941, 126.18623, 116.1019, 126.18623, 116.84705, 125.44138);
        ((GeneralPath) shape).lineTo(124.94137, 117.34706);
        ((GeneralPath) shape).curveTo(125.68622, 116.60191, 125.68622, 115.39411, 124.94137, 114.64895);
        ((GeneralPath) shape).lineTo(112.80734, 102.50002);
        ((GeneralPath) shape).lineTo(124.94138, 90.351074);
        ((GeneralPath) shape).curveTo(125.68622, 89.60593, 125.68622, 88.39812, 124.94137, 87.65297);
        ((GeneralPath) shape).lineTo(116.84705, 79.55865);
        ((GeneralPath) shape).curveTo(116.1019, 78.8138, 114.8941, 78.8138, 114.14894, 79.55865);
        ((GeneralPath) shape).lineTo(102.00001, 91.69268);
        ((GeneralPath) shape).lineTo(89.85106, 79.55864);
        ((GeneralPath) shape).curveTo(89.48659, 79.19801, 88.99233, 78.99924, 88.47965, 79.007095);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(103.35651, 109.25274);
        ((GeneralPath) shape).curveTo(102.99808, 108.89046, 102.50963, 108.68661, 102.00001, 108.68661);
        ((GeneralPath) shape).curveTo(101.49038, 108.68661, 101.00193, 108.89046, 100.6435, 109.25274);
        ((GeneralPath) shape).lineTo(103.35651, 109.25274);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(58.743717193603516, 78.41134643554688), new Point2D.Double(58.743717193603516, -15.688620567321777), new float[]{0, 1}, new Color[]{new Color(0x810000), new Color(0xC50000)}, NO_CYCLE, SRGB, new AffineTransform(0.4770136f, 0, 0, 0.4770136f, 73.3792f, 73.8792f)));
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.4770136f, 0, 0, 0.4770136f, 119.27747f, 73.8792f));

        // _0_0_3_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-62.57895, 106.7868);
        ((GeneralPath) shape).lineTo(-36.416, 79.91674);
        ((GeneralPath) shape).lineTo(-10.606602, 106.43324);
        ((GeneralPath) shape).lineTo(-36.416, 66.12816);
        ((GeneralPath) shape).lineTo(-62.57895, 106.7868);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);
        g.setStroke(new BasicStroke(0.8943044f, 0, 0, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_3_1
        g.setComposite(AlphaComposite.getInstance(3, 0.49812737f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0, 0.8892682f, -0.8892682f, 0, 134.58273f, 87.90061f));

        // _0_0_3_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(31.7, 16.0);
        ((GeneralPath) shape).lineTo(34.575, 12.625);
        ((GeneralPath) shape).curveTo(33.523796, 10.929242, 30.639864, 10.336982, 28.6375, 12.3125);
        ((GeneralPath) shape).lineTo(31.45, 15.6875);
        ((GeneralPath) shape).lineTo(31.7, 16.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(26.09113311767578, 14.856743812561035), new Point2D.Double(31.500688552856445, 14.856743812561035), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1.0975951f, 0, 0, 0.9110828f, 0, 0)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_3_2
        g.setComposite(AlphaComposite.getInstance(3, 0.79026216f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.8782235f, 0, 0, -0.8782235f, 60.73951f, 135.2747f));

        // _0_0_3_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(31.7, 16.0);
        ((GeneralPath) shape).lineTo(34.575, 12.625);
        ((GeneralPath) shape).curveTo(33.523796, 10.929242, 30.639864, 10.336982, 28.6375, 12.3125);
        ((GeneralPath) shape).lineTo(31.45, 15.6875);
        ((GeneralPath) shape).lineTo(31.7, 16.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(26.09113311767578, 14.856743812561035), new Point2D.Double(31.500688552856445, 14.856743812561035), new float[]{0, 1}, new Color[]{new Color(0x765C44), new Color(0x765C44, true)}, NO_CYCLE, SRGB, new AffineTransform(1.0975951f, 0, 0, 0.9110828f, 0, 0)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_3_3
        g.setComposite(AlphaComposite.getInstance(3, 0.49812737f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0, 0.8052763f, 0.8052763f, 0, 70.31204f, 90.546684f));

        // _0_0_3_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(31.7, 16.0);
        ((GeneralPath) shape).lineTo(34.575, 12.625);
        ((GeneralPath) shape).curveTo(33.523796, 10.929242, 30.639864, 10.336982, 28.6375, 12.3125);
        ((GeneralPath) shape).lineTo(31.45, 15.6875);
        ((GeneralPath) shape).lineTo(31.7, 16.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(304.8866271972656, 385.86126708984375), new Point2D.Double(345.6203918457031, 384.62384033203125), new float[]{0, 1}, new Color[]{new Color(0x765C44), new Color(0x765C44, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_3_4
        g.setComposite(AlphaComposite.getInstance(3, 0.92134833f * origAlpha));

        // _0_0_3_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(115.49198, 82.641174);
        ((GeneralPath) shape).lineTo(102.00001, 96.133156);
        ((GeneralPath) shape).lineTo(88.50803, 82.641174);
        ((GeneralPath) shape).lineTo(82.14116, 89.00803);
        ((GeneralPath) shape).lineTo(95.63315, 102.50001);
        ((GeneralPath) shape).lineTo(82.14116, 115.99199);
        ((GeneralPath) shape).lineTo(88.50803, 122.35885);
        ((GeneralPath) shape).lineTo(102.0, 108.86687);
        ((GeneralPath) shape).lineTo(115.49198, 122.35885);
        ((GeneralPath) shape).lineTo(121.85884, 115.99199);
        ((GeneralPath) shape).lineTo(108.36686, 102.50001);
        ((GeneralPath) shape).lineTo(121.85884, 89.00803);
        ((GeneralPath) shape).lineTo(115.49198, 82.641174);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(55.007041931152344, 88.46097564697266), new Point2D.Double(55.007041931152344, 36.65576934814453), new float[]{0, 1}, new Color[]{RED, new Color(0x7F0000)}, NO_CYCLE, SRGB, new AffineTransform(0.4770136f, 0, 0, 0.4770136f, 73.3792f, 73.8792f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.79026216f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.8052763f, 0, 0, -0.8052763f, 44.32666f, 134.58565f));

        // _0_0_3_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(88.7, 16.0);
        ((GeneralPath) shape).lineTo(91.575, 12.625);
        ((GeneralPath) shape).curveTo(90.523796, 10.929242, 87.63986, 10.336982, 85.6375, 12.3125);
        ((GeneralPath) shape).lineTo(88.45, 15.6875);
        ((GeneralPath) shape).lineTo(88.7, 16.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(31.90625, 13.510335922241211), new Point2D.Double(34.87510681152344, 13.510335922241211), new float[]{0, 1}, new Color[]{new Color(0xFF8787), new Color(0xFF8787, true)}, REFLECT, SRGB, new AffineTransform(1, 0, 0, 1, 56.7f, 0)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_3_6
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.4770136f, 0, 0, -0.4770136f, 119.27747f, 130.89587f));

        // _0_0_3_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-62.57895, 106.7868);
        ((GeneralPath) shape).lineTo(-36.416, 79.91674);
        ((GeneralPath) shape).lineTo(-10.606602, 106.43324);
        ((GeneralPath) shape).lineTo(-36.416, 66.12816);
        ((GeneralPath) shape).lineTo(-62.57895, 106.7868);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(-36.592777252197266, 90.07295227050781), 25.986174f, new Point2D.Double(-36.592777252197266, 90.07295227050781), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(0.4576062f, 0, 0, 0.782313f, -19.847694f, 18.82067f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_3_7
        g.setComposite(AlphaComposite.getInstance(3, 0.79026216f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.732329f, 0, 0, 0.732329f, 65.33576f, 71.46747f));

        // _0_0_3_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(31.7, 16.0);
        ((GeneralPath) shape).lineTo(34.575, 12.625);
        ((GeneralPath) shape).curveTo(33.523796, 10.929242, 30.639864, 10.336982, 28.6375, 12.3125);
        ((GeneralPath) shape).lineTo(31.45, 15.6875);
        ((GeneralPath) shape).lineTo(31.7, 16.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(31.90625, 13.510335922241211), new Point2D.Double(34.87510681152344, 13.510335922241211), new float[]{0, 1}, new Color[]{WHITE, new Color(0x790000, true)}, REFLECT, SRGB, new AffineTransform(1, 0, 0, 1, -0.3f, 0)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_3_8
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.75185f, 0, 0, 0.75185f, 49.05509f, 71.28307f));

        // _0_0_3_9
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(88.7, 16.0);
        ((GeneralPath) shape).lineTo(91.575, 12.625);
        ((GeneralPath) shape).curveTo(90.523796, 10.929242, 87.63986, 10.336982, 85.6375, 12.3125);
        ((GeneralPath) shape).lineTo(88.45, 15.6875);
        ((GeneralPath) shape).lineTo(88.7, 16.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(31.90625, 13.510335922241211), new Point2D.Double(34.87510681152344, 13.510335922241211), new float[]{0, 1}, new Color[]{WHITE, new Color(0x790000, true)}, REFLECT, SRGB, new AffineTransform(1, 0, 0, 1, 56.7f, 0)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_3_9
        g.setComposite(AlphaComposite.getInstance(3, 0.92134833f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.4770136f, 0, 0, 0.4770136f, 73.3792f, 73.8792f));

        // _0_0_3_10
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(88.28427, 18.368397);
        ((GeneralPath) shape).lineTo(60.0, 46.652664);
        ((GeneralPath) shape).lineTo(31.715729, 18.368397);
        ((GeneralPath) shape).lineTo(18.368397, 31.715729);
        ((GeneralPath) shape).lineTo(46.652664, 60.0);
        ((GeneralPath) shape).lineTo(18.368397, 88.28427);
        ((GeneralPath) shape).lineTo(31.715729, 101.63161);
        ((GeneralPath) shape).lineTo(60.0, 73.347336);
        ((GeneralPath) shape).lineTo(88.28427, 101.63161);
        ((GeneralPath) shape).lineTo(101.63161, 88.28427);
        ((GeneralPath) shape).lineTo(73.347336, 60.0);
        ((GeneralPath) shape).lineTo(101.63161, 31.715729);
        ((GeneralPath) shape).lineTo(88.28427, 18.368397);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(59.999996185302734, 92.97308349609375), new Point2D.Double(57.43444061279297, 55.07938003540039), new float[]{0, 0.25f, 0.5f, 1}, new Color[]{new Color(0xFFF5E4), new Color(0xFFECD0), new Color(0xFFD390), new Color(0xFFC46A)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.setStroke(new BasicStroke(2.7885764f, 1, 1, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_3_10
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_3_11
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(88.5008, 82.61049);
        ((GeneralPath) shape).lineTo(88.14304, 82.96825);
        ((GeneralPath) shape).lineTo(82.1348, 88.97648);
        ((GeneralPath) shape).lineTo(88.38154, 83.20676);
        ((GeneralPath) shape).lineTo(102.00065, 96.13457);
        ((GeneralPath) shape).lineTo(115.36262, 83.20676);
        ((GeneralPath) shape).lineTo(120.71497, 88.5591);
        ((GeneralPath) shape).curveTo(120.66815, 88.8012, 120.60495, 89.03602, 120.53608, 89.27461);
        ((GeneralPath) shape).lineTo(114.73696, 96.02776);
        ((GeneralPath) shape).curveTo(109.50684, 98.635185, 102.21413, 101.20713, 94.3736, 101.21528);
        ((GeneralPath) shape).lineTo(94.50776, 101.34944);
        ((GeneralPath) shape).curveTo(94.73271, 101.35209, 94.95238, 101.36435, 95.17856, 101.36435);
        ((GeneralPath) shape).curveTo(103.04262, 101.36435, 108.45013, 99.74488, 113.69349, 97.13085);
        ((GeneralPath) shape).lineTo(121.40067, 89.42368);
        ((GeneralPath) shape).curveTo(121.4324, 89.313736, 121.46183, 89.205154, 121.49011, 89.09573);
        ((GeneralPath) shape).curveTo(121.5232, 88.96769, 121.55431, 88.838715, 121.57955, 88.70816);
        ((GeneralPath) shape).lineTo(115.48187, 82.61049);
        ((GeneralPath) shape).lineTo(115.12411, 82.96825);
        ((GeneralPath) shape).lineTo(102.00065, 96.13457);
        ((GeneralPath) shape).lineTo(88.5008, 82.61049);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(68.3130111694336, 109.97648620605469), new Point2D.Double(51.54484939575195, 32.7508544921875), new float[]{0, 1}, new Color[]{new Color(0xF4F5F8), new Color(0xFDFDFE)}, NO_CYCLE, SRGB, new AffineTransform(0.6762458f, 0, 0, 0.336478f, 73.3792f, 73.8792f)));
        g.fill(shape);

        // _0_0_3_12
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(88.50946, 82.64348);
        ((GeneralPath) shape).lineTo(82.14347, 89.009476);
        ((GeneralPath) shape).lineTo(94.51643, 101.38244);
        ((GeneralPath) shape).curveTo(94.74138, 101.38508, 94.96106, 101.39734, 95.18723, 101.39734);
        ((GeneralPath) shape).curveTo(103.05129, 101.39734, 108.4588, 99.77787, 113.70216, 97.16385);
        ((GeneralPath) shape).lineTo(121.40934, 89.45668);
        ((GeneralPath) shape).curveTo(121.47821, 89.21808, 121.54141, 88.98326, 121.58823, 88.74115);
        ((GeneralPath) shape).lineTo(115.49055, 82.64348);
        ((GeneralPath) shape).lineTo(102.0, 96.13402);
        ((GeneralPath) shape).lineTo(88.50946, 82.64348);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(47.26414108276367, 21.73845672607422), new Point2D.Double(47.26414108276367, 70.35726928710938), new float[]{0, 1}, new Color[]{new Color(0xFF8787), new Color(0xFF8787, true)}, NO_CYCLE, SRGB, new AffineTransform(0.4770136f, 0, 0, 0.4770136f, 73.3792f, 73.8792f)));
        g.fill(shape);

        // _0_0_3_13
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(88.5008, 82.61049);
        ((GeneralPath) shape).lineTo(88.14304, 82.96825);
        ((GeneralPath) shape).lineTo(82.1348, 88.97648);
        ((GeneralPath) shape).lineTo(88.38154, 83.20676);
        ((GeneralPath) shape).lineTo(102.00378, 97.0345);
        ((GeneralPath) shape).lineTo(102.00065, 96.13457);
        ((GeneralPath) shape).lineTo(102.00539, 97.02757);
        ((GeneralPath) shape).lineTo(115.36262, 83.20676);
        ((GeneralPath) shape).lineTo(120.71497, 88.5591);
        ((GeneralPath) shape).curveTo(120.66815, 88.8012, 120.60495, 89.03602, 120.53608, 89.27461);
        ((GeneralPath) shape).lineTo(114.73696, 96.02776);
        ((GeneralPath) shape).curveTo(109.50684, 98.635185, 102.21413, 101.20713, 94.3736, 101.21528);
        ((GeneralPath) shape).lineTo(94.50776, 101.34944);
        ((GeneralPath) shape).curveTo(94.73271, 101.35209, 94.95238, 101.36435, 95.17856, 101.36435);
        ((GeneralPath) shape).curveTo(103.04262, 101.36435, 108.45013, 99.74488, 113.69349, 97.13085);
        ((GeneralPath) shape).lineTo(121.40067, 89.42368);
        ((GeneralPath) shape).curveTo(121.4324, 89.313736, 121.46183, 89.205154, 121.49011, 89.09573);
        ((GeneralPath) shape).curveTo(121.5232, 88.96769, 121.55431, 88.838715, 121.57955, 88.70816);
        ((GeneralPath) shape).lineTo(115.48187, 82.61049);
        ((GeneralPath) shape).lineTo(115.12411, 82.96825);
        ((GeneralPath) shape).lineTo(102.00065, 96.13457);
        ((GeneralPath) shape).lineTo(88.5008, 82.61049);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(57.654170989990234, 71.82486724853516), new Point2D.Double(56.770992279052734, 20.362558364868164), new float[]{0, 1}, new Color[]{new Color(0xFFFFFF, true), WHITE}, NO_CYCLE, SRGB, new AffineTransform(0.4770136f, 0, 0, 0.4770136f, 73.38515f, 74.47547f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_3

        // _0_1

    }

    /**
     * Returns the X of the bounding box of the original SVG image.
     *
     * @return The X of the bounding box of the original SVG image.
     */
    public static int getOrigX() {
        return 3;
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
        return 118;
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
    public EditDeleteShred() {
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

