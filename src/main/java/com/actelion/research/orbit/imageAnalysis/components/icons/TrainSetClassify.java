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

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class TrainSetClassify implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, -87.73739f, 169.7818f));

        // _0_0

        // _0_0_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(103.49224, -158.01137);
        ((GeneralPath) shape).curveTo(105.91442, -157.39821, 106.6281, -158.77254, 107.91674, -159.44807);
        ((GeneralPath) shape).curveTo(108.93876, -159.9839, 112.52321, -157.50323, 110.41414, -156.635);
        ((GeneralPath) shape).curveTo(107.9836, -155.63434, 107.2213, -153.9185, 106.97722, -153.29385);
        ((GeneralPath) shape).curveTo(105.57436, -149.70354, 113.98223, -149.49315, 111.85636, -146.94028);
        ((GeneralPath) shape).curveTo(110.30832, -145.08134, 106.19702, -148.26518, 106.03769, -147.1396);
        ((GeneralPath) shape).curveTo(105.79201, -145.40405, 106.52936, -142.50153, 104.04238, -142.68695);
        ((GeneralPath) shape).curveTo(98.80966, -143.07709, 93.42447, -147.70811, 91.04664, -150.9294);
        ((GeneralPath) shape).curveTo(88.77316, -154.00932, 90.88205, -157.85484, 92.901146, -160.45464);
        ((GeneralPath) shape).curveTo(94.13483, -162.04308, 96.890076, -165.21397, 99.35725, -164.1237);
        ((GeneralPath) shape).curveTo(102.15677, -162.8866, 97.39288, -159.55544, 103.49224, -158.01137);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);
        g.setStroke(new BasicStroke(2.651973f, 0, 1, 5));
        g.draw(shape);

        // _0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(103.93986, -156.80972);
        ((GeneralPath) shape).curveTo(106.36204, -156.19653, 107.07572, -157.57092, 108.36438, -158.2465);
        ((GeneralPath) shape).curveTo(109.38638, -158.78226, 112.97081, -156.30162, 110.86174, -155.43333);
        ((GeneralPath) shape).curveTo(108.43122, -154.43275, 107.6689, -152.7169, 107.42482, -152.09224);
        ((GeneralPath) shape).curveTo(106.02196, -148.50188, 114.42985, -148.29156, 112.30394, -145.73862);
        ((GeneralPath) shape).curveTo(110.75592, -143.8797, 106.64466, -147.06355, 106.48531, -145.93799);
        ((GeneralPath) shape).curveTo(106.23961, -144.20244, 106.97696, -141.29991, 104.49004, -141.4853);
        ((GeneralPath) shape).curveTo(99.25726, -141.87544, 93.872055, -146.50648, 91.49424, -149.72775);
        ((GeneralPath) shape).curveTo(89.220764, -152.80771, 91.329666, -156.65321, 93.34877, -159.253);
        ((GeneralPath) shape).curveTo(94.58242, -160.84142, 97.3377, -164.01236, 99.804825, -162.92209);
        ((GeneralPath) shape).curveTo(102.60435, -161.68495, 97.8405, -158.35382, 103.93986, -156.80972);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(33.29081344604492, 36.0700569152832), 5.0383153f, new Point2D.Double(33.29081344604492, 36.0700569152832), new float[]{0, 1}, new Color[]{new Color(0x729FCF), new Color(0x3465A4)}, NO_CYCLE, SRGB, new AffineTransform(2.6211426f, -1.1363786f, 1.4966797f, 1.9917454f, -38.391697f, -181.43404f)));
        g.fill(shape);
        g.setPaint(new Color(0x204A87));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.77011496f * origAlpha));

        // _0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(102.11652, -144.48087);
        ((GeneralPath) shape).curveTo(104.61384, -144.83945, 105.43002, -147.4788, 104.43122, -150.2895);
        ((GeneralPath) shape).curveTo(102.42137, -147.09785, 98.556114, -149.21895, 94.431786, -150.26306);
        ((GeneralPath) shape).curveTo(95.43061, -147.45236, 100.40192, -144.40468, 102.11652, -144.48087);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xEEEEEC));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(115.92873, -163.60362);
        ((GeneralPath) shape).curveTo(113.844, -164.1116, 110.39334, -165.26749, 109.62067, -166.42538);
        ((GeneralPath) shape).curveTo(107.8139, -169.13289, 105.44823, -166.72707, 106.8895, -165.08842);
        ((GeneralPath) shape).curveTo(108.55047, -163.20003, 110.92876, -161.76654, 110.95575, -161.12971);
        ((GeneralPath) shape).curveTo(111.11084, -157.46931, 106.05186, -161.10886, 107.03501, -158.02058);
        ((GeneralPath) shape).curveTo(107.62329, -156.17255, 110.62709, -157.85081, 111.38041, -155.38841);
        ((GeneralPath) shape).curveTo(111.97892, -153.43216, 109.83018, -153.97385, 110.822, -152.73538);
        ((GeneralPath) shape).curveTo(115.49129, -146.90475, 119.94257, -148.82143, 123.43369, -150.58015);
        ((GeneralPath) shape).curveTo(126.92482, -152.33887, 127.54428, -156.85678, 124.75703, -160.74666);
        ((GeneralPath) shape).curveTo(123.61233, -162.34425, 123.43492, -165.55717, 121.77645, -166.34245);
        ((GeneralPath) shape).curveTo(119.39669, -167.46925, 121.17841, -162.32443, 115.92873, -163.60362);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);
        g.setStroke(new BasicStroke(2.205277f, 0, 1, 5));
        g.draw(shape);

        // _0_0_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(116.30811, -162.6233);
        ((GeneralPath) shape).curveTo(114.22338, -163.13129, 110.77278, -164.28717, 110.00007, -165.4451);
        ((GeneralPath) shape).curveTo(108.19328, -168.15254, 105.82763, -165.74675, 107.2689, -164.10808);
        ((GeneralPath) shape).curveTo(108.92985, -162.2197, 111.30814, -160.78625, 111.33515, -160.14937);
        ((GeneralPath) shape).curveTo(111.49025, -156.48895, 106.43124, -160.12852, 107.41439, -157.04027);
        ((GeneralPath) shape).curveTo(108.00267, -155.19228, 111.00647, -156.87051, 111.75983, -154.4081);
        ((GeneralPath) shape).curveTo(112.3583, -152.45186, 110.20956, -152.99355, 111.20138, -151.75504);
        ((GeneralPath) shape).curveTo(115.87069, -145.92444, 120.32197, -147.84116, 123.81306, -149.59984);
        ((GeneralPath) shape).curveTo(127.30424, -151.35855, 127.92369, -155.87643, 125.13641, -159.76637);
        ((GeneralPath) shape).curveTo(123.9917, -161.36394, 123.8143, -164.57684, 122.15582, -165.36214);
        ((GeneralPath) shape).curveTo(119.77608, -166.48895, 121.55781, -161.34412, 116.30811, -162.6233);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(32.450172424316406, 33.60939407348633), 5.0383153f, new Point2D.Double(32.450172424316406, 33.60939407348633), new float[]{0, 1}, new Color[]{new Color(0xEF2929), new Color(0xCC0000)}, NO_CYCLE, SRGB, new AffineTransform(-1.2623417f, -1.7617435f, -1.45193f, 0.71074873f, 210.03748f, -120.59613f)));
        g.fill(shape);
        g.setPaint(new Color(0xA40000));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.77011496f * origAlpha));

        // _0_0_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(113.79138, -151.2347);
        ((GeneralPath) shape).curveTo(116.65062, -148.9142, 120.42543, -149.71819, 121.88586, -150.76216);
        ((GeneralPath) shape).curveTo(123.34634, -151.80614, 125.4567, -154.02902, 124.51378, -156.83867);
        ((GeneralPath) shape).curveTo(123.25666, -154.66315, 121.74235, -153.38223, 120.26432, -152.46153);
        ((GeneralPath) shape).curveTo(118.78413, -151.53941, 117.07703, -150.57417, 113.79138, -151.2347);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xEEEEEC));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(128.70381, -158.0614);
        ((GeneralPath) shape).curveTo(131.64404, -158.65987, 128.988, -160.51553, 127.82756, -161.52165);
        ((GeneralPath) shape).curveTo(126.90727, -162.31963, 129.04382, -164.90128, 130.65094, -163.26639);
        ((GeneralPath) shape).curveTo(132.503, -161.3823, 133.47636, -159.07162, 134.30728, -158.85635);
        ((GeneralPath) shape).curveTo(139.0833, -157.61894, 136.23279, -162.71402, 139.93237, -160.99849);
        ((GeneralPath) shape).curveTo(142.14626, -159.97192, 138.76646, -158.1164, 141.72816, -156.77258);
        ((GeneralPath) shape).curveTo(144.081, -155.70505, 144.19698, -157.56322, 145.4494, -156.40434);
        ((GeneralPath) shape).curveTo(151.34543, -150.94888, 147.09044, -148.02534, 143.41576, -145.81033);
        ((GeneralPath) shape).curveTo(139.74104, -143.59528, 133.53246, -144.48355, 129.47192, -147.86485);
        ((GeneralPath) shape).curveTo(125.41143, -151.24615, 125.06729, -155.81425, 128.70381, -158.0614);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);
        g.setStroke(new BasicStroke(2.3351312f, 0, 1, 5));
        g.draw(shape);

        // _0_0_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(128.5991, -156.95432);
        ((GeneralPath) shape).curveTo(131.53938, -157.5527, 128.8833, -159.40837, 127.72289, -160.4145);
        ((GeneralPath) shape).curveTo(126.80256, -161.21246, 128.93916, -163.79411, 130.54628, -162.15927);
        ((GeneralPath) shape).curveTo(132.39828, -160.27519, 133.37169, -157.9645, 134.20262, -157.74922);
        ((GeneralPath) shape).curveTo(138.97862, -156.51183, 136.1281, -161.6069, 139.82774, -159.89136);
        ((GeneralPath) shape).curveTo(142.04155, -158.8648, 138.66177, -157.00922, 141.62346, -155.66544);
        ((GeneralPath) shape).curveTo(143.97633, -154.5979, 144.09229, -156.45602, 145.3447, -155.2972);
        ((GeneralPath) shape).curveTo(151.24074, -149.8417, 146.98576, -146.91821, 143.3111, -144.70319);
        ((GeneralPath) shape).curveTo(139.63638, -142.4881, 133.42773, -143.37642, 129.36723, -146.75772);
        ((GeneralPath) shape).curveTo(125.30672, -150.13905, 124.96264, -154.7071, 128.5991, -156.95432);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(23.537704467773438, 36.02513122558594), 4.244812f, new Point2D.Double(23.537704467773438, 36.02513122558594), new float[]{0, 1}, new Color[]{new Color(0x8AE234), new Color(0x73D216)}, NO_CYCLE, SRGB, new AffineTransform(-2.6048038f, -0.5043509f, 0.39679128f, -1.9879266f, 185.57362f, -65.806366f)));
        g.fill(shape);
        g.setPaint(new Color(0x4E9A06));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.77011496f * origAlpha));

        // _0_0_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(132.07626, -148.09686);
        ((GeneralPath) shape).curveTo(135.47269, -145.90656, 139.95663, -146.66547, 141.69145, -147.65088);
        ((GeneralPath) shape).curveTo(143.42628, -148.63629, 145.93314, -150.73445, 144.8131, -153.38646);
        ((GeneralPath) shape).curveTo(143.31976, -151.33302, 141.52097, -150.124, 139.76527, -149.25488);
        ((GeneralPath) shape).curveTo(138.00697, -148.3845, 135.97919, -147.47342, 132.07626, -148.09686);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xEEEEEC));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_9
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(119.05743, -137.78683);
        ((GeneralPath) shape).curveTo(115.51431, -137.78683, 114.64295, -135.86617, 114.64295, -133.49615);
        ((GeneralPath) shape).curveTo(114.64295, -131.91615, 113.92347, -130.53854, 115.82432, -129.79372);
        ((GeneralPath) shape).lineTo(115.82432, -127.71758);
        ((GeneralPath) shape).curveTo(115.82432, -127.18779, 116.45486, -126.76603, 117.24689, -126.76603);
        ((GeneralPath) shape).lineTo(121.64391, -126.76603);
        ((GeneralPath) shape).curveTo(122.43594, -126.76603, 123.09234, -127.18779, 123.09234, -127.71758);
        ((GeneralPath) shape).lineTo(123.09234, -130.15704);
        ((GeneralPath) shape).curveTo(124.54372, -130.94379, 123.4719, -132.14922, 123.4719, -133.49615);
        ((GeneralPath) shape).curveTo(123.4719, -135.86617, 122.60054, -137.78683, 119.05743, -137.78683);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xFFAAAA));
        g.fill(shape);

        // _0_0_10
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(93.84375, -143.53125);
        ((GeneralPath) shape).curveTo(93.84375, -143.53125, 94.03707, -141.4167, 95.90625, -139.49544);
        ((GeneralPath) shape).curveTo(95.13952, -135.1072, 95.45999, -132.64339, 97.0, -129.66814);
        ((GeneralPath) shape).curveTo(100.74802, -125.68304, 104.02066, -120.17135, 109.65625, -123.87663);
        ((GeneralPath) shape).curveTo(113.43222, -130.30524, 105.92692, -131.88535, 101.53125, -132.63228);
        ((GeneralPath) shape).curveTo(100.46818, -134.95331, 98.47306, -136.69778, 97.5625, -139.10782);
        ((GeneralPath) shape).curveTo(97.35132, -139.29715, 97.21199, -139.43573, 97.09375, -139.56384);
        ((GeneralPath) shape).lineTo(99.6875, -140.33908);
        ((GeneralPath) shape).lineTo(99.875, -143.23483);
        ((GeneralPath) shape).lineTo(93.84375, -143.53125);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);

        // _0_0_11
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(108.06361, -122.97364);
        ((GeneralPath) shape).curveTo(108.06361, -122.97364, 113.12912, -118.80656, 113.12912, -117.66061);
        ((GeneralPath) shape).curveTo(113.12912, -116.51467, 113.78984, -112.7643, 113.78984, -112.7643);
        ((GeneralPath) shape).curveTo(116.61414, -112.60294, 122.48508, -112.56154, 125.9204, -112.7643);
        ((GeneralPath) shape).curveTo(125.9204, -112.7643, 126.58112, -116.51467, 126.58112, -117.66061);
        ((GeneralPath) shape).curveTo(126.58112, -118.80656, 131.64664, -122.97364, 131.64664, -122.97364);

        g.setPaint(CYAN);
        g.setStroke(new BasicStroke(0.69157016f, 0, 0, 4));
        g.draw(shape);

        // _0_0_12
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(143.79387, -142.92247);
        ((GeneralPath) shape).curveTo(143.79387, -142.92247, 143.60056, -140.80792, 141.73137, -138.88666);
        ((GeneralPath) shape).curveTo(142.4981, -134.49841, 142.17763, -132.0346, 140.63762, -129.05936);
        ((GeneralPath) shape).curveTo(136.8896, -125.07426, 133.61696, -119.56257, 127.98137, -123.26785);
        ((GeneralPath) shape).curveTo(124.2054, -129.69646, 131.7107, -131.27657, 136.10637, -132.0235);
        ((GeneralPath) shape).curveTo(137.16943, -134.34453, 139.16457, -136.089, 140.07512, -138.49904);
        ((GeneralPath) shape).curveTo(140.2863, -138.68837, 140.42563, -138.82695, 140.54387, -138.95506);
        ((GeneralPath) shape).lineTo(137.95012, -139.7303);
        ((GeneralPath) shape).lineTo(137.76262, -142.62605);
        ((GeneralPath) shape).lineTo(143.79387, -142.92247);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.1f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.985953f, -0.167023f, 0.2224241f, -0.97495f, 0, 0));

        // _0_0_13
        shape = new Ellipse2D.Double(-104.32527160644531, 177.1243896484375, 20.220224380493164, 3.2251930236816406);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(10.5625, 46.0625), 8.5625f, new Point2D.Double(10.5625, 46.0625), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(1.1807431f, 0, 0, 0.18833242f, -106.68675f, 170.06192f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_13
        g.setComposite(AlphaComposite.getInstance(3, 0.16475093f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.981219f, -0.19289711f, 0.13416675f, -0.6824724f, 139.29918f, -137.73524f));

        // _0_0_14
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(35.609375, 8.318359);
        ((GeneralPath) shape).curveTo(35.493538, 8.314848, 35.380154, 8.352181, 35.289062, 8.423828);
        ((GeneralPath) shape).curveTo(26.312515, 15.437283, 21.689367, 20.761894, 19.117188, 24.189453);
        ((GeneralPath) shape).curveTo(17.405073, 26.302582, 15.48999, 29.478264, 13.9375, 32.42578);
        ((GeneralPath) shape).curveTo(13.909095, 32.480568, 13.891208, 32.540188, 13.884766, 32.601562);
        ((GeneralPath) shape).curveTo(13.666157, 34.599228, 13.792595, 36.603287, 14.650391, 38.371094);
        ((GeneralPath) shape).curveTo(14.710156, 38.4941, 14.818247, 38.58682, 14.9489155, 38.627167);
        ((GeneralPath) shape).curveTo(15.079583, 38.667515, 15.221131, 38.65188, 15.339844, 38.583984);
        ((GeneralPath) shape).curveTo(19.354279, 36.273994, 24.494877, 31.421762, 25.871094, 29.826172);
        ((GeneralPath) shape).curveTo(28.807535, 26.47024, 33.524033, 20.533062, 38.46875, 11.136719);
        ((GeneralPath) shape).curveTo(38.570885, 10.943213, 38.533527, 10.705573, 38.376953, 10.552734);
        ((GeneralPath) shape).curveTo(37.59823, 9.789965, 36.76617, 9.058277, 35.884766, 8.4140625);
        ((GeneralPath) shape).curveTo(35.80469, 8.355178, 35.70871, 8.321823, 35.609375, 8.318359);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(28.469051361083984, 23.214420318603516), 12.3671f, new Point2D.Double(28.469051361083984, 23.214420318603516), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(0.1675436f, 0.1340677f, -0.9393554f, 1.1739072f, 43.93767f, -7.586747f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_14
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_15
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(115.31459, -151.23206);
        ((GeneralPath) shape).curveTo(110.87492, -149.66061, 103.02509, -146.52547, 93.25521, -141.11041);
        ((GeneralPath) shape).curveTo(92.87454, -140.94698, 93.38182, -140.66512, 93.708115, -140.7071);
        ((GeneralPath) shape).curveTo(107.31161, -143.81494, 114.44336, -146.65018, 118.49262, -148.27586);

        g.setPaint(new LinearGradientPaint(new Point2D.Double(33.17571258544922, 18.65762710571289), new Point2D.Double(31.180810928344727, 17.177289962768555), new float[]{0, 1}, new Color[]{new Color(0xC17D11), new Color(0xE9B96E)}, NO_CYCLE, SRGB, new AffineTransform(-0.85651636f, -0.09019007f, 0.39221355f, -0.4830118f, 126.38389f, -134.52544f)));
        g.fill(shape);
        g.setPaint(new Color(0x8F5902));
        g.setStroke(new BasicStroke(0.82787037f, 0, 1, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.15f * origAlpha));

        // _0_0_16
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(117.78443, -148.008);
        ((GeneralPath) shape).curveTo(116.31516, -148.64479, 115.06901, -149.47134, 114.6064, -150.96419);
        ((GeneralPath) shape).curveTo(116.38721, -151.6026, 123.35936, -153.67793, 127.558, -154.3192);
        ((GeneralPath) shape).lineTo(128.4866, -153.1728);
        ((GeneralPath) shape).curveTo(125.82907, -151.61755, 121.08222, -149.25262, 117.78443, -148.008);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);
        g.setStroke(new BasicStroke(0.8278704f, 0, 1, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_17
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(118.49262, -148.27586);
        ((GeneralPath) shape).curveTo(117.02335, -148.91264, 115.77721, -149.7392, 115.31459, -151.23206);
        ((GeneralPath) shape).curveTo(117.0954, -151.87045, 124.06755, -153.94579, 128.26619, -154.58707);
        ((GeneralPath) shape).lineTo(129.1948, -153.44067);
        ((GeneralPath) shape).curveTo(126.53727, -151.8854, 121.79041, -149.52048, 118.49262, -148.27586);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(19.635454177856445, 29.59141731262207), new Point2D.Double(23.529132843017578, 33.4850959777832), new float[]{0, 1}, new Color[]{new Color(0xEEEEEC), new Color(0x888A85)}, NO_CYCLE, SRGB, new AffineTransform(-0.85651636f, -0.09019007f, 0.39221355f, -0.4830118f, 126.38389f, -134.52544f)));
        g.fill(shape);
        g.setPaint(new Color(0x888A85));
        g.setStroke(new BasicStroke(0.82787037f, 0, 0, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.68000036f * origAlpha));

        // _0_0_18
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(128.35434, -153.73949);
        ((GeneralPath) shape).curveTo(121.24782, -149.38893, 100.03723, -142.72697, 95.58691, -141.77686);
        ((GeneralPath) shape).curveTo(105.52179, -145.84335, 117.78618, -150.19273, 128.35434, -153.73949);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(18.1875, 28.625), new Point2D.Double(41.4375, 6.1875), new float[]{0, 1}, new Color[]{WHITE, new Color(0x85FFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(-1.0492733f, -0.1777496f, 0.14347214f, -0.6288804f, 136.9885f, -129.78278f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_19
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(140.18079, -155.71819);
        ((GeneralPath) shape).curveTo(135.25633, -156.55357, 135.04977, -153.39195, 132.4434, -152.85358);
        ((GeneralPath) shape).curveTo(129.42311, -152.22969, 127.30392, -153.99573, 127.07347, -155.19273);
        ((GeneralPath) shape).curveTo(126.78269, -156.70312, 128.18471, -158.07153, 131.47362, -158.15674);
        ((GeneralPath) shape).curveTo(135.1612, -158.25227, 140.05199, -157.01408, 140.18079, -155.71819);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(10.593055725097656, 38.58195495605469), new Point2D.Double(10.165061950683594, 43.38218688964844), new float[]{0, 1}, new Color[]{new Color(0x555753), new Color(0x1F2324)}, NO_CYCLE, SRGB, new AffineTransform(-1.0492733f, -0.1777496f, 0.18185523f, -0.7971248f, 136.05016f, -120.89279f)));
        g.fill(shape);
        g.setPaint(BLACK);
        g.setStroke(new BasicStroke(0.8278703f, 0, 0, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.29118773f * origAlpha));

        // _0_0_20
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(138.69081, -156.35263);
        ((GeneralPath) shape).curveTo(136.55148, -156.6983, 134.73483, -155.4258, 133.95827, -154.55528);
        ((GeneralPath) shape).curveTo(131.61655, -151.93031, 126.87952, -154.1692, 128.2656, -156.03754);
        ((GeneralPath) shape).curveTo(130.10912, -159.10973, 135.49713, -156.89899, 138.69081, -156.35263);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(9.343700408935547, 38.8116569519043), new Point2D.Double(10.924744606018066, 46.82093048095703), new float[]{0, 1}, new Color[]{WHITE, new Color(0x85FFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(-0.67406905f, -0.11418906f, 0.10252921f, -0.4494156f, 134.49017f, -135.29263f)));
        g.setStroke(new BasicStroke(0.8278704f, 0, 1, 5));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.985953f, -0.167023f, 0.2224241f, -0.97495f, 0, 0));

        // _0_0_21
        shape = new Ellipse2D.Double(-96.34359741210938, 173.01226806640625, 6.385334491729736, 2.580157995223999);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(12.186543464660645, 38.012454986572266), new Point2D.Double(12.186543464660645, 39.532230377197266), new float[]{0, 1}, new Color[]{WHITE, new Color(0x85FFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(2.8055072f, 0, 0, 1.4068027f, -127.34036f, 119.84758f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_21
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_22
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(94.36504, -141.249);
        ((GeneralPath) shape).lineTo(97.95573, -142.60603);

        g.setPaint(new LinearGradientPaint(new Point2D.Double(38.28942108154297, 5.253948211669922), new Point2D.Double(36.610626220703125, 7.3314619064331055), new float[]{0, 1}, new Color[]{new Color(0xEAC586), new Color(0xEAC586, true)}, NO_CYCLE, SRGB, new AffineTransform(-0.85651636f, -0.09019007f, 0.39221355f, -0.4830118f, 126.8247f, -135.99596f)));
        g.setStroke(new BasicStroke(0.82787037f, 1, 0, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0

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
        return 62;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     *
     * @return The height of the bounding box of the original SVG image.
     */
    public static int getOrigHeight() {
        return 58;
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
    public TrainSetClassify() {
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

