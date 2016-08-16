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
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static java.awt.MultipleGradientPaint.ColorSpaceType.SRGB;
import static java.awt.MultipleGradientPaint.CycleMethod.NO_CYCLE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class DocumentOpen5 implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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

        // _0_1

        // _0_1_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(4.6200285, 38.651016);
        ((GeneralPath) shape).curveTo(4.6618366, 39.07147, 5.117414, 39.491924, 5.5311837, 39.491924);
        ((GeneralPath) shape).lineTo(36.667347, 39.491924);
        ((GeneralPath) shape).curveTo(37.081116, 39.491924, 37.45308, 39.07147, 37.41127, 38.651016);
        ((GeneralPath) shape).lineTo(34.714653, 11.531728);
        ((GeneralPath) shape).curveTo(34.672844, 11.111274, 34.217266, 10.69082, 33.803497, 10.69082);
        ((GeneralPath) shape).lineTo(21.080082, 10.69082);
        ((GeneralPath) shape).curveTo(20.489536, 10.69082, 19.870998, 10.311268, 19.677221, 9.730485);
        ((GeneralPath) shape).lineTo(18.574219, 6.4246087);
        ((GeneralPath) shape).curveTo(18.404966, 5.9173307, 18.02707, 5.6888137, 17.259747, 5.6888137);
        ((GeneralPath) shape).lineTo(2.3224187, 5.6888137);
        ((GeneralPath) shape).curveTo(1.9086492, 5.6888137, 1.5366876, 6.109268, 1.5784956, 6.529722);
        ((GeneralPath) shape).lineTo(4.6200285, 38.651016);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(26.10677719116211, 38.19511413574219), 32.25977f, new Point2D.Double(26.10677719116211, 38.19511413574219), new float[]{0, 1}, new Color[]{new Color(0xA0A0A0), new Color(0xA8A8A8)}, NO_CYCLE, SRGB, new AffineTransform(1.015635f, 0, 0.103105f, 1.000512f, 0, -0.08369458f)));
        g.fill(shape);
        g.setPaint(new Color(0x5A5A5A));
        g.setStroke(new BasicStroke(1, 1, 1, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.11363633f * origAlpha));

        // _0_1_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(3.3386018, 17.533487);
        ((GeneralPath) shape).lineTo(34.48846, 17.533487);

        g.setPaint(new Color(0x729FCF));
        g.fill(shape);
        g.setPaint(BLACK);
        g.draw(shape);

        // _0_1_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(5.3301525, 37.533485);
        ((GeneralPath) shape).lineTo(35.317905, 37.533485);

        g.setPaint(new Color(0x729FCF));
        g.fill(shape);
        g.setPaint(BLACK);
        g.draw(shape);

        // _0_1_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(5.3301525, 35.533485);
        ((GeneralPath) shape).lineTo(35.317905, 35.533485);

        g.setPaint(new Color(0x729FCF));
        g.fill(shape);
        g.setPaint(BLACK);
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.02165152f, 0, 0, 0.01903841f, 42.41538f, 36.93372f));

        // _0_1_4
        g.setComposite(AlphaComposite.getInstance(3, 0.40206185f * origAlpha));

        // _0_1_4_0
        shape = new Rectangle2D.Double(-1559.2523193359375, -150.6968536376953, 1339.633544921875, 478.357177734375);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(302.8571472167969, 366.64788818359375), new Point2D.Double(302.8571472167969, 609.5050659179688), new float[]{0, 0.5f, 1}, new Color[]{new Color(0x0, true), BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(2.774389f, 0, 0, 1.969706f, -1892.179f, -872.8854f)));
        g.fill(shape);

        // _0_1_4_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-219.61876, -150.68037);
        ((GeneralPath) shape).curveTo(-219.61876, -150.68037, -219.61876, 327.65042, -219.61876, 327.65042);
        ((GeneralPath) shape).curveTo(-76.74459, 328.55087, 125.78146, 220.48074, 125.78138, 88.45424);
        ((GeneralPath) shape).curveTo(125.78138, -43.572304, -33.655437, -150.68036, -219.61876, -150.68037);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(605.7142944335938, 486.64788818359375), 117.14286f, new Point2D.Double(605.7142944335938, 486.64788818359375), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(2.774389f, 0, 0, 1.969706f, -1891.633f, -872.8854f)));
        g.fill(shape);

        // _0_1_4_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-1559.2523, -150.68037);
        ((GeneralPath) shape).curveTo(-1559.2523, -150.68037, -1559.2523, 327.65042, -1559.2523, 327.65042);
        ((GeneralPath) shape).curveTo(-1702.1265, 328.55087, -1904.6525, 220.48074, -1904.6525, 88.45424);
        ((GeneralPath) shape).curveTo(-1904.6525, -43.572304, -1745.2157, -150.68036, -1559.2523, -150.68037);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(605.7142944335938, 486.64788818359375), 117.14286f, new Point2D.Double(605.7142944335938, 486.64788818359375), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(-2.774389f, 0, 0, 1.969706f, 112.7623f, -872.8854f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_1_4
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_1_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(6.171752, 38.418674);
        ((GeneralPath) shape).curveTo(6.203108, 38.729, 6.017127, 38.935886, 5.6963477, 38.832443);
        ((GeneralPath) shape).lineTo(5.6963477, 38.832443);
        ((GeneralPath) shape).curveTo(5.3755684, 38.729, 5.14778, 38.522118, 5.1164236, 38.21179);
        ((GeneralPath) shape).lineTo(2.0868573, 6.8445945);
        ((GeneralPath) shape).curveTo(2.0555012, 6.534267, 2.243451, 6.346871, 2.5537784, 6.346871);
        ((GeneralPath) shape).lineTo(17.303532, 6.255425);
        ((GeneralPath) shape).curveTo(17.834814, 6.2521315, 18.04296, 6.308731, 18.18333, 6.7726374);
        ((GeneralPath) shape).curveTo(18.18333, 6.7726374, 19.268703, 9.885435, 19.429564, 10.470742);
        ((GeneralPath) shape).lineTo(17.873968, 7.553706);
        ((GeneralPath) shape).curveTo(17.608788, 7.0564437, 17.275225, 7.1399364, 16.901178, 7.1399364);
        ((GeneralPath) shape).lineTo(3.7717774, 7.1399364);
        ((GeneralPath) shape).curveTo(3.4614503, 7.1399364, 3.2754695, 7.3468213, 3.3068254, 7.657149);
        ((GeneralPath) shape).lineTo(6.285646, 38.522118);
        ((GeneralPath) shape).lineTo(6.171752, 38.418674);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(5.265791416168213, 18.725862503051758), new Point2D.Double(8.212224006652832, 52.625850677490234), new float[]{0, 1}, new Color[]{new Color(0xB3FFFFFF, true), new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1.462696f, 0, 0.06907908f, 0.683669f, 0, 0)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.11363633f * origAlpha));

        // _0_1_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(2.3052332, 7.533487);
        ((GeneralPath) shape).lineTo(17.088966, 7.533487);

        g.setPaint(new Color(0x729FCF));
        g.fill(shape);
        g.setPaint(BLACK);
        g.draw(shape);

        // _0_1_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(2.7573333, 11.533487);
        ((GeneralPath) shape).lineTo(33.496216, 11.533487);

        g.setPaint(new Color(0x729FCF));
        g.fill(shape);
        g.setPaint(BLACK);
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.034424f, 0, 0.10452f, 1.034424f, -10.03248f, 2.631914f));

        // _0_1_8

        // _0_1_8_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(41.785744, 9.0363865);
        ((GeneralPath) shape).curveTo(41.79537, 8.561804, 41.800934, 8.311881, 41.36235, 8.312183);
        ((GeneralPath) shape).lineTo(28.80653, 8.32084);
        ((GeneralPath) shape).curveTo(28.50653, 8.32084, 28.481916, 8.177634, 28.80653, 8.32084);
        ((GeneralPath) shape).curveTo(29.131144, 8.4640465, 30.053629, 8.979112, 30.989227, 9.021835);
        ((GeneralPath) shape).curveTo(30.989227, 9.021835, 41.785706, 9.038299, 41.785744, 9.0363865);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x94FFFFFF, true));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_1_8
        g.setComposite(AlphaComposite.getInstance(3, 0.11363633f * origAlpha));

        // _0_1_9
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(3.1628954, 15.533487);
        ((GeneralPath) shape).lineTo(33.99345, 15.533487);

        g.setPaint(new Color(0x729FCF));
        g.fill(shape);
        g.setPaint(BLACK);
        g.draw(shape);

        // _0_1_10
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(5.1594715, 33.533485);
        ((GeneralPath) shape).lineTo(35.147224, 33.533485);

        g.setPaint(new Color(0x729FCF));
        g.fill(shape);
        g.setPaint(BLACK);
        g.draw(shape);

        // _0_1_11
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(4.8658085, 31.533487);
        ((GeneralPath) shape).lineTo(34.974533, 31.533487);

        g.setPaint(new Color(0x729FCF));
        g.fill(shape);
        g.setPaint(BLACK);
        g.draw(shape);

        // _0_1_12
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(4.6336365, 29.533487);
        ((GeneralPath) shape).lineTo(34.80285, 29.533487);

        g.setPaint(new Color(0x729FCF));
        g.fill(shape);
        g.setPaint(BLACK);
        g.draw(shape);

        // _0_1_13
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(4.4629555, 27.533487);
        ((GeneralPath) shape).lineTo(34.632168, 27.533487);

        g.setPaint(new Color(0x729FCF));
        g.fill(shape);
        g.setPaint(BLACK);
        g.draw(shape);

        // _0_1_14
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(4.255672, 25.533487);
        ((GeneralPath) shape).lineTo(34.460793, 25.533487);

        g.setPaint(new Color(0x729FCF));
        g.fill(shape);
        g.setPaint(BLACK);
        g.draw(shape);

        // _0_1_15
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(4.02352, 23.533487);
        ((GeneralPath) shape).lineTo(34.2891, 23.533487);

        g.setPaint(new Color(0x729FCF));
        g.fill(shape);
        g.setPaint(BLACK);
        g.draw(shape);

        // _0_1_16
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(3.852839, 21.533487);
        ((GeneralPath) shape).lineTo(34.11842, 21.533487);

        g.setPaint(new Color(0x729FCF));
        g.fill(shape);
        g.setPaint(BLACK);
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.034424f, 0, 0.10452f, 1.034424f, -10.03248f, 2.631914f));

        // _0_1_17

        // _0_1_17_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(41.785744, 9.0363865);
        ((GeneralPath) shape).curveTo(41.79537, 8.561804, 41.800934, 8.311881, 41.36235, 8.312183);
        ((GeneralPath) shape).lineTo(28.80653, 8.32084);
        ((GeneralPath) shape).curveTo(28.50653, 8.32084, 28.481916, 8.177634, 28.80653, 8.32084);
        ((GeneralPath) shape).curveTo(29.131144, 8.4640465, 30.053629, 8.979112, 30.989227, 9.021835);
        ((GeneralPath) shape).curveTo(30.989227, 9.021835, 41.785706, 9.038299, 41.785744, 9.0363865);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x94FFFFFF, true));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_1_17
        g.setComposite(AlphaComposite.getInstance(3, 0.11363633f * origAlpha));

        // _0_1_18
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(2.9642313, 13.533487);
        ((GeneralPath) shape).lineTo(33.990734, 13.533487);

        g.setPaint(new Color(0x729FCF));
        g.fill(shape);
        g.setPaint(BLACK);
        g.draw(shape);

        // _0_1_19
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(3.651419, 19.533487);
        ((GeneralPath) shape).lineTo(33.947216, 19.533487);

        g.setPaint(new Color(0x729FCF));
        g.fill(shape);
        g.setPaint(BLACK);
        g.draw(shape);

        // _0_1_20
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(2.5242572, 9.533487);
        ((GeneralPath) shape).lineTo(17.805073, 9.533487);

        g.setPaint(new Color(0x729FCF));
        g.fill(shape);
        g.setPaint(BLACK);
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.39204544f * origAlpha));

        // _0_1_21
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(34.375, 14.125);
        ((GeneralPath) shape).lineTo(37.0, 38.75);
        ((GeneralPath) shape).lineTo(6.0, 38.875);
        ((GeneralPath) shape).curveTo(6.0, 38.875, 4.125, 14.125, 4.125, 14.125);
        ((GeneralPath) shape).curveTo(4.125, 14.125, 34.5, 14.125, 34.375, 14.125);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(22.25, 37.625), new Point2D.Double(19.75, 14.875), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_1_22
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(43.375, 2.4944034);
        ((GeneralPath) shape).curveTo(43.875, 19.373135, 34.29994, 21.022879, 37.36244, 31.494661);
        ((GeneralPath) shape).curveTo(37.36244, 31.494661, 5.875, 32.380596, 5.875, 32.380596);
        ((GeneralPath) shape).curveTo(4.0, 19.527987, 14.25, 11.166045, 11.25, 2.649254);
        ((GeneralPath) shape).lineTo(43.375, 2.4944034);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(25.875, 10.625), new Point2D.Double(25.25, 30.875), new float[]{0, 0.5f, 1}, new Color[]{new Color(0xFAFAFA), new Color(0xA8A8A8), new Color(0xCDCDCD)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1.238806f, 0, -7.880597f)));
        g.fill(shape);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(8.824419021606445, 3.7561285495758057), 37.751713f, new Point2D.Double(8.824419021606445, 3.7561285495758057), new float[]{0, 1}, new Color[]{new Color(0xA3A3A3), new Color(0x4C4C4C)}, NO_CYCLE, SRGB, new AffineTransform(0.968273f, 0, 0, 1.046686f, 44.36453f, -17.00717f)));
        g.setStroke(new BasicStroke(1, 0, 0, 4));
        g.draw(shape);

        // _0_1_23
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(15.4375, 6.5625);
        ((GeneralPath) shape).lineTo(39.0, 6.5625);

        g.setPaint(new Color(0xA1A1A1));
        g.draw(shape);

        // _0_1_24
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(5.7785654, 39.065998);
        ((GeneralPath) shape).curveTo(5.8820076, 39.277466, 6.0888915, 39.488926, 6.399217, 39.488926);
        ((GeneralPath) shape).lineTo(39.70767, 39.488926);
        ((GeneralPath) shape).curveTo(39.914562, 39.488926, 40.228832, 39.36262, 40.415844, 39.224575);
        ((GeneralPath) shape).curveTo(40.946247, 38.83304, 41.070705, 38.61219, 41.308624, 38.251106);
        ((GeneralPath) shape).curveTo(43.756752, 34.53565, 47.113766, 18.974215, 47.113766, 18.974215);
        ((GeneralPath) shape).curveTo(47.21721, 18.762754, 47.010326, 18.551294, 46.7, 18.551294);
        ((GeneralPath) shape).lineTo(11.776358, 18.551294);
        ((GeneralPath) shape).curveTo(11.466032, 18.551294, 10.120393, 34.658623, 6.913359, 37.838318);
        ((GeneralPath) shape).lineTo(5.6751237, 39.065998);
        ((GeneralPath) shape).lineTo(5.7785654, 39.065998);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(22.175975799560547, 36.987998962402344), new Point2D.Double(22.065330505371094, 32.050498962402344), new float[]{0, 1}, new Color[]{new Color(0x6194CB), new Color(0x729FCF)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1.022118f, 52.05694f, -1.323026f)));
        g.fill(shape);
        g.setPaint(new Color(0x3465A4));
        g.setStroke(new BasicStroke(1, 0, 1, 4));
        g.draw(shape);

        // _0_1_25
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(15.356073, 8.5625);
        ((GeneralPath) shape).lineTo(35.08142, 8.5625);

        g.setPaint(new Color(0xA1A1A1));
        g.setStroke(new BasicStroke(1, 0, 0, 4));
        g.draw(shape);

        // _0_1_26
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(13.134476, 20.138641);
        ((GeneralPath) shape).curveTo(12.361729, 25.129398, 11.633175, 29.147884, 10.418486, 33.652504);
        ((GeneralPath) shape).curveTo(12.804971, 32.945396, 17.534601, 30.448, 27.534601, 30.448);
        ((GeneralPath) shape).curveTo(37.534603, 30.448, 44.258175, 21.1993, 45.186253, 20.094446);
        ((GeneralPath) shape).lineTo(13.134476, 20.138641);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(14.899378776550293, 27.059642791748047), new Point2D.Double(22.71544647216797, 41.83689498901367), new float[]{0, 1}, new Color[]{new Color(0x22FFFFFF, true), new Color(0xDFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1.535299f, 0, 0, 0.651339f, 3.451418f, 2.448f)));
        g.fill(shape);

        // _0_1_27
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(15.143007, 10.5625);
        ((GeneralPath) shape).lineTo(39.457832, 10.5625);

        g.setPaint(new Color(0xA1A1A1));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.52272725f * origAlpha));

        // _0_1_28
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(45.820084, 19.6875);
        ((GeneralPath) shape).lineTo(12.661612, 19.6875);
        ((GeneralPath) shape).curveTo(12.661612, 19.6875, 10.513864, 35.707108, 7.93934, 37.928078);
        ((GeneralPath) shape).curveTo(16.060417, 37.928078, 39.51051, 37.87944, 39.53033, 37.87944);
        ((GeneralPath) shape).curveTo(41.28199, 37.87944, 44.43797, 25.243248, 45.820084, 19.6875);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(19.11611557006836, 28.946041107177734), new Point2D.Double(19.426923751831055, 51.91269302368164), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1.421537f, 0, 0, 0.703464f, 0, 0)));
        g.setStroke(new BasicStroke(1, 1, 0, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_1_29
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(14.398767, 12.5625);
        ((GeneralPath) shape).lineTo(38.25216, 12.5625);

        g.setPaint(new Color(0xA1A1A1));
        g.setStroke(new BasicStroke(1, 0, 0, 4));
        g.draw(shape);

        // _0_1_30
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(13.629028, 14.5625);
        ((GeneralPath) shape).lineTo(36.97533, 14.5625);

        g.draw(shape);

        // _0_1_31
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(12.520679, 16.5625);
        ((GeneralPath) shape).lineTo(31.16684, 16.5625);

        g.draw(shape);

        // _0_1_32
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(6.375, 31.75);
        ((GeneralPath) shape).curveTo(5.1336346, 19.511961, 13.5625, 12.6875, 12.0, 3.0);
        ((GeneralPath) shape).lineTo(42.875, 3.0);
        ((GeneralPath) shape).lineTo(12.875, 3.625);
        ((GeneralPath) shape).curveTo(14.125, 13.1875, 6.6786165, 18.271446, 6.375, 31.75);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);

        // _0_2

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
        return 47;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     *
     * @return The height of the bounding box of the original SVG image.
     */
    public static int getOrigHeight() {
        return 42;
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
    public DocumentOpen5() {
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

