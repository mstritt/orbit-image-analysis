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
public class DrawEraser2 implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.transform(new AffineTransform(1, 0, 0, 1, -1427.5223f, -142.6017f));

        // _0_0

        // _0_0_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1478.415, 145.63165);
        ((GeneralPath) shape).lineTo(1478.415, 142.83694);
        ((GeneralPath) shape).lineTo(1478.415, 145.63165);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xC1FFFFFF, true));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.5491803f * origAlpha));

        // _0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1491.4286, 246.9441);
        ((GeneralPath) shape).curveTo(1473.5385, 246.9441, 1457.3771, 248.30249, 1445.7723, 250.5066);
        ((GeneralPath) shape).curveTo(1472.5476, 254.20296, 1496.3416, 253.78174, 1517.6473, 248.0066);
        ((GeneralPath) shape).curveTo(1509.6405, 247.33511, 1500.7783, 246.9441, 1491.4286, 246.9441);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(1444.7723, 250.72536);
        ((GeneralPath) shape).curveTo(1434.1008, 252.84846, 1427.5223, 255.68665, 1427.5223, 258.8191);
        ((GeneralPath) shape).curveTo(1427.5223, 265.37634, 1456.149, 270.6941, 1491.4286, 270.6941);
        ((GeneralPath) shape).curveTo(1526.7081, 270.6941, 1555.3348, 265.3763, 1555.3348, 258.8191);
        ((GeneralPath) shape).curveTo(1555.3348, 257.8095, 1554.6746, 256.81772, 1553.3973, 255.8816);
        ((GeneralPath) shape).curveTo(1524.5966, 260.87198, 1495.3411, 265.22388, 1460.5848, 262.1316);
        ((GeneralPath) shape).lineTo(1444.7723, 250.72536);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(63.912208557128906, 115.70919036865234), 63.91221f, new Point2D.Double(28.865602493286133, 135.3350067138672), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 0.197802f, 1427.5223f, 235.17201f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1447.12, 222.32233);
        ((GeneralPath) shape).lineTo(1432.4534, 236.9889);
        ((GeneralPath) shape).lineTo(1461.3699, 265.90536);
        ((GeneralPath) shape).lineTo(1476.0365, 251.2388);
        ((GeneralPath) shape).lineTo(1447.12, 222.32233);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x888888));
        g.fill(shape);

        // _0_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1516.8151, 160.66444);
        ((GeneralPath) shape).lineTo(1507.012, 160.66444);
        ((GeneralPath) shape).lineTo(1537.384, 191.31308);
        ((GeneralPath) shape).lineTo(1537.384, 180.71413);
        ((GeneralPath) shape).lineTo(1516.8151, 160.66444);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xBBBBBB));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.5833333f * origAlpha));

        // _0_0_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1507.2747, 160.60919);
        ((GeneralPath) shape).lineTo(1516.9226, 160.60919);
        ((GeneralPath) shape).lineTo(1510.7479, 166.30145);
        ((GeneralPath) shape).lineTo(1506.117, 161.86342);
        ((GeneralPath) shape).lineTo(1507.2747, 160.60919);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x4B4B4B));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1516.781, 160.60837);
        ((GeneralPath) shape).lineTo(1507.0714, 160.60837);
        ((GeneralPath) shape).lineTo(1537.1539, 191.06404);
        ((GeneralPath) shape).lineTo(1537.1539, 180.53181);
        ((GeneralPath) shape).lineTo(1516.781, 160.60837);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(1316.3583984375, 335.24102783203125), new Point2D.Double(1328.429443359375, 323.1700439453125), new float[]{0, 1}, new Color[]{new Color(0x888888), new Color(0x888888, true)}, NO_CYCLE, SRGB, new AffineTransform(0.4695816f, 0, 0, 0.4680988f, 905.6296f, 21.579329f)));
        g.fill(shape);

        // _0_0_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1447.6077, 221.85275);
        ((GeneralPath) shape).lineTo(1433.0991, 236.34154);
        ((GeneralPath) shape).lineTo(1461.2344, 264.55533);
        ((GeneralPath) shape).lineTo(1475.743, 250.06654);
        ((GeneralPath) shape).lineTo(1447.6077, 221.85275);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(1182.048583984375, 508.39056396484375), new Point2D.Double(1152.9832763671875, 441.9582214355469), new float[]{0, 1}, new Color[]{new Color(0xDDDDDD), new Color(0xEEEEEE)}, NO_CYCLE, SRGB, new AffineTransform(0.4645221f, 0, 0, 0.4638897f, 911.0094f, 24.174063f)));
        g.fill(shape);

        // _0_0_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1517.5356, 171.1673);
        ((GeneralPath) shape).lineTo(1456.4314, 232.27159);
        ((GeneralPath) shape).lineTo(1465.8964, 241.73659);
        ((GeneralPath) shape).lineTo(1526.9274, 180.691);
        ((GeneralPath) shape).lineTo(1537.4489, 191.22722);
        ((GeneralPath) shape).lineTo(1537.5223, 191.15385);
        ((GeneralPath) shape).lineTo(1517.5356, 171.1673);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(-140.09375, 197.046875), new Point2D.Double(-214.40625, 310.046875), new float[]{0, 1}, new Color[]{new Color(0xEEEEEE), new Color(0xDFDFDF)}, NO_CYCLE, SRGB, new AffineTransform(0.4695816f, 0, 0, 0.4695816f, 1574.81f, 89.50411f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.9055558f * origAlpha));

        // _0_0_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1434.8372, 237.81187);
        ((GeneralPath) shape).lineTo(1448.9883, 223.67644);
        ((GeneralPath) shape).lineTo(1447.419, 222.10616);
        ((GeneralPath) shape).lineTo(1433.2115, 236.38057);
        ((GeneralPath) shape).lineTo(1434.8372, 237.81187);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(1465.480712890625, 261.60467529296875), new Point2D.Double(1464.5074462890625, 260.5966491699219), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(-1, 0, 0, -1, 2908.7039f, 488.0657f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.48333332f * origAlpha));

        // _0_0_9
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1448.8488, 222.2626);
        ((GeneralPath) shape).lineTo(1433.6613, 237.4345);
        ((GeneralPath) shape).lineTo(1435.0363, 237.4501);
        ((GeneralPath) shape).lineTo(1449.5675, 222.98135);
        ((GeneralPath) shape).lineTo(1448.8488, 222.2626);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.8277778f * origAlpha));

        // _0_0_10
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1507.1886, 162.53954);
        ((GeneralPath) shape).lineTo(1515.3212, 162.1502);
        ((GeneralPath) shape).lineTo(1516.7711, 160.62817);
        ((GeneralPath) shape).lineTo(1507.1321, 160.7792);
        ((GeneralPath) shape).lineTo(1507.1886, 162.53954);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(1465.823974609375, 261.93035888671875), new Point2D.Double(1465.23193359375, 261.3089599609375), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(-0.482916f, -1.4677695f, 0.5089942f, -1.5470316f, 2090.8716f, 2716.9265f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_11
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1506.9701, 160.6017);
        ((GeneralPath) shape).lineTo(1445.8658, 221.706);
        ((GeneralPath) shape).lineTo(1456.4314, 232.27159);
        ((GeneralPath) shape).lineTo(1517.5356, 171.1673);
        ((GeneralPath) shape).lineTo(1506.9701, 160.6017);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(1480.3826904296875, 204.03857421875), new Point2D.Double(1480.3826904296875, 160.5817108154297), new float[]{0, 1}, new Color[]{new Color(0xBF0303), new Color(0xE20800)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.5833333f * origAlpha));

        // _0_0_12
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1531.7323, 187.09254);
        ((GeneralPath) shape).lineTo(1536.0739, 191.72356);
        ((GeneralPath) shape).lineTo(1537.3281, 190.56583);
        ((GeneralPath) shape).lineTo(1537.3281, 180.9179);
        ((GeneralPath) shape).lineTo(1531.7323, 187.09254);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.8277778f * origAlpha));

        // _0_0_13
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1534.9542, 190.82892);
        ((GeneralPath) shape).lineTo(1535.6896, 182.72862);
        ((GeneralPath) shape).lineTo(1537.2911, 180.89014);
        ((GeneralPath) shape).lineTo(1537.1436, 190.88535);
        ((GeneralPath) shape).lineTo(1534.9542, 190.82892);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(1465.823974609375, 261.93035888671875), new Point2D.Double(1465.23193359375, 261.3089599609375), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(1.8255874f, 0.4829161f, 1.9241724f, -0.5089942f, -1642.1503f, -392.8539f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_14
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1526.9274, 180.69724);
        ((GeneralPath) shape).lineTo(1465.8231, 241.80153);
        ((GeneralPath) shape).lineTo(1476.3887, 252.36713);
        ((GeneralPath) shape).lineTo(1537.493, 191.26282);
        ((GeneralPath) shape).lineTo(1526.9274, 180.69724);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(1242.4285888671875, 449.114990234375), new Point2D.Double(1242.4285888671875, 352.72833251953125), new float[]{0, 1}, new Color[]{new Color(0xBF0303), new Color(0xE20800)}, NO_CYCLE, SRGB, new AffineTransform(0.4695816f, 0, 0, 0.4695816f, 904.4718f, 22.540976f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.49444443f * origAlpha));

        // _0_0_15
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1506.97, 160.65308);
        ((GeneralPath) shape).lineTo(1445.8657, 221.75737);
        ((GeneralPath) shape).lineTo(1476.4313, 252.57297);
        ((GeneralPath) shape).lineTo(1537.5356, 191.46866);
        ((GeneralPath) shape).lineTo(1506.97, 160.65308);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(1518.1744384765625, 154.83128356933594), 45.83495f, new Point2D.Double(1518.1744384765625, 154.83128356933594), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(3.1677547f, -1.9317805f, 0.5553605f, 0.9106865f, -3369.5496f, 2935.4573f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.24444444f * origAlpha));

        // _0_0_16
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1507.2585, 161.0581);
        ((GeneralPath) shape).lineTo(1446.6691, 222.22723);
        ((GeneralPath) shape).lineTo(1447.0854, 222.66331);
        ((GeneralPath) shape).lineTo(1507.4104, 162.31712);
        ((GeneralPath) shape).lineTo(1537.3556, 191.30173);
        ((GeneralPath) shape).lineTo(1537.3611, 191.25476);
        ((GeneralPath) shape).lineTo(1517.4109, 171.1796);
        ((GeneralPath) shape).lineTo(1507.2585, 161.0581);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_17
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1525.1497, 200.30824);
        ((GeneralPath) shape).curveTo(1524.9146, 200.54362, 1524.6759, 200.68414, 1524.434, 200.72981);
        ((GeneralPath) shape).curveTo(1524.1921, 200.77423, 1523.9901, 200.71571, 1523.8278, 200.55417);
        ((GeneralPath) shape).curveTo(1523.6646, 200.3917, 1523.606, 200.1901, 1523.6519, 199.94928);
        ((GeneralPath) shape).curveTo(1523.6982, 199.70728, 1523.8416, 199.4659, 1524.0822, 199.22514);
        ((GeneralPath) shape).curveTo(1524.3219, 198.98518, 1524.5627, 198.84154, 1524.8047, 198.79424);
        ((GeneralPath) shape).curveTo(1525.0466, 198.74687, 1525.2489, 198.80418, 1525.4117, 198.96622);
        ((GeneralPath) shape).curveTo(1525.5778, 199.13144, 1525.6373, 199.33478, 1525.5906, 199.57635);
        ((GeneralPath) shape).curveTo(1525.5435, 199.81744, 1525.3964, 200.06139, 1525.1497, 200.30824);
        ((GeneralPath) shape).moveTo(1525.0443, 200.19643);
        ((GeneralPath) shape).curveTo(1525.2177, 200.02293, 1525.314, 199.85132, 1525.3333, 199.68152);
        ((GeneralPath) shape).curveTo(1525.3522, 199.5113, 1525.2926, 199.35759, 1525.1548, 199.22044);
        ((GeneralPath) shape).curveTo(1525.0212, 199.08745, 1524.869, 199.03123, 1524.6981, 199.05171);
        ((GeneralPath) shape).curveTo(1524.5281, 199.07149, 1524.3591, 199.16545, 1524.191, 199.33357);
        ((GeneralPath) shape).curveTo(1524.0223, 199.50249, 1523.9285, 199.67203, 1523.9095, 199.84227);
        ((GeneralPath) shape).curveTo(1523.8903, 200.01202, 1523.9479, 200.1639, 1524.0825, 200.29782);
        ((GeneralPath) shape).curveTo(1524.2166, 200.43129, 1524.369, 200.48921, 1524.5397, 200.47162);
        ((GeneralPath) shape).curveTo(1524.7104, 200.45398, 1524.8785, 200.36227, 1525.0443, 200.19643);
        ((GeneralPath) shape).moveTo(1526.0645, 199.34154);
        ((GeneralPath) shape).lineTo(1526.1116, 198.2658);
        ((GeneralPath) shape).lineTo(1525.0654, 198.29233);
        ((GeneralPath) shape).lineTo(1525.3495, 198.00803);
        ((GeneralPath) shape).lineTo(1526.1443, 197.98512);
        ((GeneralPath) shape).lineTo(1526.1855, 197.17117);
        ((GeneralPath) shape).lineTo(1526.4124, 196.94421);
        ((GeneralPath) shape).lineTo(1526.3666, 197.98006);
        ((GeneralPath) shape).lineTo(1527.4528, 197.95212);
        ((GeneralPath) shape).lineTo(1527.1687, 198.23642);
        ((GeneralPath) shape).lineTo(1526.3309, 198.26225);
        ((GeneralPath) shape).lineTo(1526.2924, 199.1134);
        ((GeneralPath) shape).lineTo(1526.0645, 199.34154);
        ((GeneralPath) shape).moveTo(1528.1022, 197.30212);
        ((GeneralPath) shape).lineTo(1527.6736, 196.87555);
        ((GeneralPath) shape).lineTo(1526.5098, 196.84676);
        ((GeneralPath) shape).lineTo(1526.7847, 196.57162);
        ((GeneralPath) shape).lineTo(1527.6879, 196.5926);
        ((GeneralPath) shape).lineTo(1527.6989, 195.65683);
        ((GeneralPath) shape).lineTo(1527.9221, 195.43329);
        ((GeneralPath) shape).lineTo(1527.9113, 196.63202);
        ((GeneralPath) shape).lineTo(1528.3428, 197.0614);
        ((GeneralPath) shape).lineTo(1528.1022, 197.30212);
        ((GeneralPath) shape).moveTo(1530.4434, 194.90387);
        ((GeneralPath) shape).curveTo(1530.2736, 195.14487, 1530.1122, 195.3418, 1529.9595, 195.49464);
        ((GeneralPath) shape).curveTo(1529.69, 195.76442, 1529.4365, 195.92531, 1529.1992, 195.97723);
        ((GeneralPath) shape).curveTo(1528.9626, 196.02843, 1528.7578, 195.96771, 1528.5844, 195.7951);
        ((GeneralPath) shape).curveTo(1528.4142, 195.62576, 1528.3549, 195.42117, 1528.4064, 195.1813);
        ((GeneralPath) shape).curveTo(1528.4574, 194.94098, 1528.6147, 194.68896, 1528.878, 194.4253);
        ((GeneralPath) shape).curveTo(1529.0507, 194.2526, 1529.2457, 194.08846, 1529.463, 193.93279);
        ((GeneralPath) shape).lineTo(1529.5975, 194.0667);
        ((GeneralPath) shape).curveTo(1529.3158, 194.2527, 1529.1127, 194.408, 1528.9882, 194.53258);
        ((GeneralPath) shape).curveTo(1528.8049, 194.716, 1528.7002, 194.89603, 1528.674, 195.07268);
        ((GeneralPath) shape).curveTo(1528.6486, 195.2486, 1528.7043, 195.40466, 1528.8412, 195.54088);
        ((GeneralPath) shape).curveTo(1528.9766, 195.67567, 1529.1364, 195.7264, 1529.3201, 195.69286);
        ((GeneralPath) shape).curveTo(1529.5035, 195.65889, 1529.6929, 195.54408, 1529.8884, 195.34843);
        ((GeneralPath) shape).curveTo(1529.9685, 195.26819, 1530.0468, 195.17294, 1530.1227, 195.06265);
        ((GeneralPath) shape).lineTo(1529.7885, 194.72992);
        ((GeneralPath) shape).lineTo(1530.0278, 194.49033);
        ((GeneralPath) shape).lineTo(1530.4434, 194.90387);
        ((GeneralPath) shape).moveTo(1530.8925, 194.50958);
        ((GeneralPath) shape).lineTo(1529.866, 193.4879);
        ((GeneralPath) shape).lineTo(1530.8132, 192.53986);
        ((GeneralPath) shape).lineTo(1530.9222, 192.64827);
        ((GeneralPath) shape).lineTo(1530.2155, 193.35559);
        ((GeneralPath) shape).lineTo(1530.5449, 193.68346);
        ((GeneralPath) shape).lineTo(1531.1371, 193.09077);
        ((GeneralPath) shape).lineTo(1531.2446, 193.19778);
        ((GeneralPath) shape).lineTo(1530.6523, 193.79045);
        ((GeneralPath) shape).lineTo(1531.0242, 194.16046);
        ((GeneralPath) shape).lineTo(1531.7802, 193.40385);
        ((GeneralPath) shape).lineTo(1531.8892, 193.51224);
        ((GeneralPath) shape).lineTo(1530.8925, 194.50958);
        ((GeneralPath) shape).moveTo(1532.1663, 193.23482);
        ((GeneralPath) shape).lineTo(1531.1396, 192.21313);
        ((GeneralPath) shape).lineTo(1531.3757, 191.97697);
        ((GeneralPath) shape).lineTo(1533.0219, 191.91197);
        ((GeneralPath) shape).lineTo(1532.229, 191.12294);
        ((GeneralPath) shape).lineTo(1532.4352, 190.9166);
        ((GeneralPath) shape).lineTo(1533.4618, 191.93826);
        ((GeneralPath) shape).lineTo(1533.227, 192.17326);
        ((GeneralPath) shape).lineTo(1531.5796, 192.23943);
        ((GeneralPath) shape).lineTo(1532.3726, 193.02847);
        ((GeneralPath) shape).lineTo(1532.1663, 193.23482);

        g.setPaint(new Color(0xF0F8FF));
        g.fill(shape);

        // _0_0_18
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1476.1359, 252.57697);
        ((GeneralPath) shape).lineTo(1535.9365, 192.72069);
        ((GeneralPath) shape).lineTo(1535.8282, 192.69553);
        ((GeneralPath) shape).lineTo(1476.1567, 251.76756);
        ((GeneralPath) shape).lineTo(1448.4828, 224.29745);
        ((GeneralPath) shape).lineTo(1448.4773, 224.34444);
        ((GeneralPath) shape).lineTo(1476.1359, 252.57697);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x00142D));
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9588222f, -0.9588222f, 0.5214731f, 0.5214731f, 0, 0));

        // _0_0_19
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(650.1757, 1632.3326);
        ((GeneralPath) shape).lineTo(650.1757, 1623.4397);
        ((GeneralPath) shape).lineTo(655.14496, 1623.4397);
        ((GeneralPath) shape).lineTo(655.14496, 1624.383);
        ((GeneralPath) shape).lineTo(651.43756, 1624.383);
        ((GeneralPath) shape).lineTo(651.43756, 1627.2372);
        ((GeneralPath) shape).lineTo(654.54407, 1627.2372);
        ((GeneralPath) shape).lineTo(654.54407, 1628.1686);
        ((GeneralPath) shape).lineTo(651.43756, 1628.1686);
        ((GeneralPath) shape).lineTo(651.43756, 1631.3893);
        ((GeneralPath) shape).lineTo(655.4033, 1631.3893);
        ((GeneralPath) shape).lineTo(655.4033, 1632.3326);
        ((GeneralPath) shape).lineTo(650.1757, 1632.3326);
        ((GeneralPath) shape).moveTo(656.8575, 1632.3326);
        ((GeneralPath) shape).lineTo(656.8575, 1623.4397);
        ((GeneralPath) shape).lineTo(659.5494, 1623.4397);
        ((GeneralPath) shape).curveTo(660.4026, 1623.4397, 661.05554, 1623.628, 661.50824, 1624.0045);
        ((GeneralPath) shape).curveTo(661.9649, 1624.3811, 662.19324, 1624.9279, 662.19324, 1625.6449);
        ((GeneralPath) shape).curveTo(662.19324, 1626.8306, 661.59436, 1627.6719, 660.3966, 1628.1686);
        ((GeneralPath) shape).lineTo(663.3649, 1632.3326);
        ((GeneralPath) shape).lineTo(661.81464, 1632.3326);
        ((GeneralPath) shape).lineTo(659.285, 1628.5712);
        ((GeneralPath) shape).lineTo(658.1073, 1628.5712);
        ((GeneralPath) shape).lineTo(658.1073, 1632.3326);
        ((GeneralPath) shape).lineTo(656.8575, 1632.3326);
        ((GeneralPath) shape).moveTo(658.1073, 1627.6278);
        ((GeneralPath) shape).lineTo(658.51587, 1627.6278);
        ((GeneralPath) shape).curveTo(660.1022, 1627.6278, 660.8953, 1627.0049, 660.8953, 1625.7592);
        ((GeneralPath) shape).curveTo(660.8953, 1624.8418, 660.23035, 1624.383, 658.90045, 1624.383);
        ((GeneralPath) shape).lineTo(658.1073, 1624.383);
        ((GeneralPath) shape).lineTo(658.1073, 1627.6278);
        ((GeneralPath) shape).moveTo(669.1513, 1628.9316);
        ((GeneralPath) shape).lineTo(667.63715, 1625.0981);
        ((GeneralPath) shape).lineTo(666.11694, 1628.9316);
        ((GeneralPath) shape).lineTo(669.1513, 1628.9316);
        ((GeneralPath) shape).moveTo(670.4853, 1632.3326);
        ((GeneralPath) shape).lineTo(669.5179, 1629.8691);
        ((GeneralPath) shape).lineTo(665.75037, 1629.8691);
        ((GeneralPath) shape).lineTo(664.77094, 1632.3326);
        ((GeneralPath) shape).lineTo(663.59924, 1632.3326);
        ((GeneralPath) shape).lineTo(667.1264, 1623.4397);
        ((GeneralPath) shape).lineTo(668.3762, 1623.4397);
        ((GeneralPath) shape).lineTo(671.84924, 1632.3326);
        ((GeneralPath) shape).lineTo(670.4853, 1632.3326);
        ((GeneralPath) shape).moveTo(674.87164, 1632.555);
        ((GeneralPath) shape).curveTo(674.2748, 1632.555, 673.51166, 1632.4248, 672.58234, 1632.1644);
        ((GeneralPath) shape).lineTo(672.58234, 1630.9146);
        ((GeneralPath) shape).curveTo(673.5838, 1631.3793, 674.407, 1631.6116, 675.05194, 1631.6116);
        ((GeneralPath) shape).curveTo(675.54865, 1631.6116, 675.9472, 1631.4814, 676.2477, 1631.221);
        ((GeneralPath) shape).curveTo(676.55206, 1630.9606, 676.7043, 1630.6182, 676.70435, 1630.1935);
        ((GeneralPath) shape).curveTo(676.7043, 1629.845, 676.6042, 1629.5486, 676.4039, 1629.3042);
        ((GeneralPath) shape).curveTo(676.2076, 1629.0599, 675.8431, 1628.7875, 675.3103, 1628.487);
        ((GeneralPath) shape).lineTo(674.6974, 1628.1324);
        ((GeneralPath) shape).curveTo(673.9403, 1627.7, 673.4055, 1627.2933, 673.0931, 1626.9128);
        ((GeneralPath) shape).curveTo(672.7846, 1626.5282, 672.6304, 1626.0815, 672.6304, 1625.5728);
        ((GeneralPath) shape).curveTo(672.6304, 1624.8878, 672.8788, 1624.325, 673.3755, 1623.8844);
        ((GeneralPath) shape).curveTo(673.8722, 1623.4397, 674.5051, 1623.2174, 675.27423, 1623.2174);
        ((GeneralPath) shape).curveTo(675.9592, 1623.2174, 676.68225, 1623.3315, 677.4434, 1623.5599);
        ((GeneralPath) shape).lineTo(677.4434, 1624.7136);
        ((GeneralPath) shape).curveTo(676.50604, 1624.345, 675.807, 1624.1608, 675.3463, 1624.1608);
        ((GeneralPath) shape).curveTo(674.9097, 1624.1608, 674.5492, 1624.2769, 674.2648, 1624.5093);
        ((GeneralPath) shape).curveTo(673.98035, 1624.7416, 673.83813, 1625.034, 673.83813, 1625.3865);
        ((GeneralPath) shape).curveTo(673.83813, 1625.683, 673.9423, 1625.9454, 674.1506, 1626.1737);
        ((GeneralPath) shape).curveTo(674.3589, 1626.402, 674.73944, 1626.6744, 675.2923, 1626.9908);
        ((GeneralPath) shape).lineTo(675.9292, 1627.3514);
        ((GeneralPath) shape).curveTo(676.6983, 1627.788, 677.2351, 1628.2006, 677.53955, 1628.5892);
        ((GeneralPath) shape).curveTo(677.844, 1628.9778, 677.9962, 1629.4445, 677.9962, 1629.9893);
        ((GeneralPath) shape).curveTo(677.9962, 1630.7625, 677.7098, 1631.3833, 677.13696, 1631.8519);
        ((GeneralPath) shape).curveTo(676.5681, 1632.3206, 675.81305, 1632.555, 674.87164, 1632.555);
        ((GeneralPath) shape).moveTo(679.76276, 1632.3326);
        ((GeneralPath) shape).lineTo(679.76276, 1623.4397);
        ((GeneralPath) shape).lineTo(684.732, 1623.4397);
        ((GeneralPath) shape).lineTo(684.732, 1624.383);
        ((GeneralPath) shape).lineTo(681.0246, 1624.383);
        ((GeneralPath) shape).lineTo(681.0246, 1627.2372);
        ((GeneralPath) shape).lineTo(684.1311, 1627.2372);
        ((GeneralPath) shape).lineTo(684.1311, 1628.1686);
        ((GeneralPath) shape).lineTo(681.0246, 1628.1686);
        ((GeneralPath) shape).lineTo(681.0246, 1631.3893);
        ((GeneralPath) shape).lineTo(684.99036, 1631.3893);
        ((GeneralPath) shape).lineTo(684.99036, 1632.3326);
        ((GeneralPath) shape).lineTo(679.76276, 1632.3326);
        ((GeneralPath) shape).moveTo(686.44446, 1632.3326);
        ((GeneralPath) shape).lineTo(686.44446, 1623.4397);
        ((GeneralPath) shape).lineTo(689.1364, 1623.4397);
        ((GeneralPath) shape).curveTo(689.9896, 1623.4397, 690.6426, 1623.628, 691.0952, 1624.0045);
        ((GeneralPath) shape).curveTo(691.5519, 1624.3811, 691.7802, 1624.9279, 691.7802, 1625.6449);
        ((GeneralPath) shape).curveTo(691.7802, 1626.8306, 691.18134, 1627.6719, 689.98364, 1628.1686);
        ((GeneralPath) shape).lineTo(692.95197, 1632.3326);
        ((GeneralPath) shape).lineTo(691.4017, 1632.3326);
        ((GeneralPath) shape).lineTo(688.872, 1628.5712);
        ((GeneralPath) shape).lineTo(687.6943, 1628.5712);
        ((GeneralPath) shape).lineTo(687.6943, 1632.3326);
        ((GeneralPath) shape).lineTo(686.44446, 1632.3326);
        ((GeneralPath) shape).moveTo(687.6943, 1627.6278);
        ((GeneralPath) shape).lineTo(688.1029, 1627.6278);
        ((GeneralPath) shape).curveTo(689.6892, 1627.6278, 690.48236, 1627.0049, 690.48236, 1625.7592);
        ((GeneralPath) shape).curveTo(690.48236, 1624.8418, 689.8174, 1624.383, 688.4874, 1624.383);
        ((GeneralPath) shape).lineTo(687.6943, 1624.383);
        ((GeneralPath) shape).lineTo(687.6943, 1627.6278);

        g.setPaint(new Color(0x9C0F0F));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_19

        // _0_0_20
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1473.8667, 250.25381);
        ((GeneralPath) shape).lineTo(1459.7156, 264.38925);
        ((GeneralPath) shape).lineTo(1461.2849, 265.95953);
        ((GeneralPath) shape).lineTo(1475.4923, 251.68512);
        ((GeneralPath) shape).lineTo(1473.8667, 250.25381);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(1465.480712890625, 261.60467529296875), new Point2D.Double(1464.4921875, 260.6382751464844), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.8666667f * origAlpha));

        // _0_0_21
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1462.4136, 264.4753);
        ((GeneralPath) shape).lineTo(1433.4955, 235.81358);
        ((GeneralPath) shape).lineTo(1432.3271, 237.06296);
        ((GeneralPath) shape).lineTo(1461.29, 265.84134);
        ((GeneralPath) shape).lineTo(1462.4136, 264.4753);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(1465.823974609375, 261.93035888671875), new Point2D.Double(1465.23193359375, 261.3089599609375), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(0, 2.0757396f, -2.187833f, 0, 2014.2025f, -2796.1846f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.6611111f * origAlpha));

        // _0_0_22
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1515.165, 162.34184);
        ((GeneralPath) shape).lineTo(1535.7773, 182.4479);
        ((GeneralPath) shape).lineTo(1537.3579, 180.78629);
        ((GeneralPath) shape).lineTo(1516.7007, 160.56358);
        ((GeneralPath) shape).lineTo(1515.165, 162.34184);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(1465.823974609375, 261.93035888671875), new Point2D.Double(1465.055419921875, 261.1414794921875), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(0, -2.0757396f, 2.187833f, 0, 963.7883f, 3222.5894f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.85f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.7071068f, 0.7071068f, -0.7071068f, 0.7071068f, 0, 0));

        // _0_0_23
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1180.4717, -953.3362);
        ((GeneralPath) shape).lineTo(1221.2197, -952.9003);
        ((GeneralPath) shape).lineTo(1222.4456, -951.83307);
        ((GeneralPath) shape).curveTo(1222.4456, -951.83307, 1222.4363, -950.6754, 1222.4727, -950.6028);
        ((GeneralPath) shape).lineTo(1179.2368, -950.58466);
        ((GeneralPath) shape).lineTo(1179.07, -952.0992);
        ((GeneralPath) shape).lineTo(1180.4717, -953.3362);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(1183.02880859375, -950.5438842773438), new Point2D.Double(1183.355712890625, -953.1630249023438), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_23
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_24
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1446.8969, 222.67352);
        ((GeneralPath) shape).lineTo(1445.8657, 223.70477);
        ((GeneralPath) shape).lineTo(1474.8438, 252.50865);
        ((GeneralPath) shape).lineTo(1475.8438, 251.50865);
        ((GeneralPath) shape).lineTo(1446.8969, 222.67352);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(1462.9708251953125, 237.53892517089844), new Point2D.Double(1461.3133544921875, 239.19644165039062), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0

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
        return 1;
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
    public DrawEraser2() {
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

