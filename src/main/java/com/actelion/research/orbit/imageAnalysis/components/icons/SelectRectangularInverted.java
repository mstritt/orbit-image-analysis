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
public class SelectRectangularInverted implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));

        // _0_0_0
        shape = new Rectangle2D.Double(8, 16, 112, 96);
        g.setPaint(WHITE);
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_1
        shape = new Rectangle2D.Double(3.9999637603759766, 15.999998092651367, 4, 96);
        g.setPaint(new Color(0x99C2DC));
        g.fill(shape);

        // _0_0_2
        shape = new Rectangle2D.Double(119.99996185302734, 15.999998092651367, 4, 96);
        g.fill(shape);

        // _0_0_3
        shape = new Rectangle2D.Double(8, 12, 112, 4);
        g.fill(shape);

        // _0_0_4
        shape = new Rectangle2D.Double(8, 112, 112, 4);
        g.fill(shape);

        // _0_0_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(24.0, 31.999998);
        ((GeneralPath) shape).curveTo(24.0, 38.716, 24.0, 89.284, 24.0, 96.0);
        ((GeneralPath) shape).curveTo(31.6, 96.0, 96.4, 96.0, 104.0, 96.0);
        ((GeneralPath) shape).curveTo(104.0, 89.284, 104.0, 38.716, 104.0, 31.999998);
        ((GeneralPath) shape).curveTo(96.4, 31.999998, 31.6, 31.999998, 24.0, 31.999998);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xBBBBBB));
        g.setStroke(new BasicStroke(8, 0, 1, 4));
        g.draw(shape);

        // _0_0_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(24.0, 31.999998);
        ((GeneralPath) shape).curveTo(24.0, 38.716, 24.0, 89.284, 24.0, 96.0);
        ((GeneralPath) shape).curveTo(31.6, 96.0, 96.4, 96.0, 104.0, 96.0);
        ((GeneralPath) shape).curveTo(104.0, 89.284, 104.0, 38.716, 104.0, 31.999998);
        ((GeneralPath) shape).curveTo(96.4, 31.999998, 31.6, 31.999998, 24.0, 31.999998);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);

        // _0_0_7
        shape = new Rectangle2D.Double(59.999961853027344, 8, 8, 8);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(56, 4), new Point2D.Double(64, 4), new float[]{0, 1}, new Color[]{new Color(0xBBBBBB), new Color(0x888888)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 4, 8)));
        g.fill(shape);

        // _0_0_8
        shape = new Rectangle2D.Double(59.999961853027344, 112, 8, 8);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(56, 108), new Point2D.Double(64, 108), new float[]{0, 1}, new Color[]{new Color(0xBBBBBB), new Color(0x888888)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 4, 8)));
        g.fill(shape);

        // _0_0_9
        shape = new Rectangle2D.Double(-3.647804260253906E-5, 8, 8, 8);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(0, 4), new Point2D.Double(8, 4), new float[]{0, 1}, new Color[]{new Color(0xBBBBBB), new Color(0x888888)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 0, 8)));
        g.fill(shape);

        // _0_0_10
        shape = new Rectangle2D.Double(-3.647804260253906E-5, 112, 8, 8);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(0, 108), new Point2D.Double(8, 108), new float[]{0, 1}, new Color[]{new Color(0xBBBBBB), new Color(0x888888)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 0, 8)));
        g.fill(shape);

        // _0_0_11
        shape = new Rectangle2D.Double(119.99996185302734, 8, 8, 8);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(112, 4), new Point2D.Double(120, 4), new float[]{0, 1}, new Color[]{new Color(0xBBBBBB), new Color(0x888888)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 8, 8)));
        g.fill(shape);

        // _0_0_12
        shape = new Rectangle2D.Double(119.99996185302734, 112, 8, 8);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(112, 108), new Point2D.Double(120, 108), new float[]{0, 1}, new Color[]{new Color(0xBBBBBB), new Color(0x888888)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 8, 8)));
        g.fill(shape);

        // _0_0_13
        shape = new Rectangle2D.Double(-3.647804260253906E-5, 60.000003814697266, 8, 8);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(0, 56), new Point2D.Double(8, 56), new float[]{0, 1}, new Color[]{new Color(0xBBBBBB), new Color(0x888888)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 0, 8)));
        g.fill(shape);

        // _0_0_14
        shape = new Rectangle2D.Double(119.99996185302734, 60.000003814697266, 8, 8);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(112, 56), new Point2D.Double(120, 56), new float[]{0, 1}, new Color[]{new Color(0xBBBBBB), new Color(0x888888)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 8, 8)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.2f * origAlpha));

        // _0_0_15
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(24.0, 32.0);
        ((GeneralPath) shape).curveTo(24.0, 38.716, 24.0, 89.284, 24.0, 96.0);
        ((GeneralPath) shape).curveTo(31.6, 96.0, 96.4, 96.0, 104.0, 96.0);
        ((GeneralPath) shape).curveTo(104.0, 89.284, 104.0, 38.716, 104.0, 32.0);
        ((GeneralPath) shape).curveTo(96.4, 32.0, 31.6, 32.0, 24.0, 32.0);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(28.0, 36.0);
        ((GeneralPath) shape).lineTo(99.88909, 36.065865);
        ((GeneralPath) shape).lineTo(100.0, 92.0);
        ((GeneralPath) shape).lineTo(28.0, 92.0);
        ((GeneralPath) shape).lineTo(28.0, 36.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(64, 23.786014556884766), new Point2D.Double(64, 103.95767211914062), new float[]{0, 0.5f, 1}, new Color[]{new Color(0x72777A), new Color(0x0, true), new Color(0x72757A)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.657099f, -0.122029f, 0.04147061f, 0.335686f, 23.2048f, 60.07753f));

        // _0_0_16
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(127.82442, 115.70919);
        ((GeneralPath) shape).curveTo(127.82442, 122.69116, 99.209946, 128.35117, 63.91221, 128.35117);
        ((GeneralPath) shape).curveTo(28.61447, 128.35117, 7.1054274E-15, 122.69116, 0.0, 115.70919);
        ((GeneralPath) shape).curveTo(0.0, 108.72722, 28.61447, 103.067215, 63.91221, 103.067215);
        ((GeneralPath) shape).curveTo(99.209946, 103.067215, 127.82442, 108.72722, 127.82442, 115.70919);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(63.912208557128906, 115.70919036865234), 63.91221f, new Point2D.Double(8.71600341796875, 123.91520690917969), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 0.197802f, 0, 92.82166f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_16
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 0.158395f, 0.772817f));

        // _0_0_17

        // _0_0_17_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(112.94799, 0.35536432);
        ((GeneralPath) shape).curveTo(113.36977, -0.10112165, 116.08929, 0.16409583, 118.94522, 2.822344);
        ((GeneralPath) shape).curveTo(121.82917, 5.5066514, 122.37582, 8.067081, 121.84747, 8.6388445);
        ((GeneralPath) shape).curveTo(121.5036, 9.011015, 121.15971, 9.3831835, 120.81584, 9.755353);
        ((GeneralPath) shape).curveTo(117.84932, 6.9941916, 114.88282, 4.2330327, 111.91632, 1.4718714);
        ((GeneralPath) shape).curveTo(112.2602, 1.0997024, 112.60409, 0.72753394, 112.94799, 0.35536432);
        ((GeneralPath) shape).curveTo(112.94799, 0.35536432, 112.94799, 0.35536432, 112.94799, 0.35536432);

        g.setPaint(BLACK);
        g.fill(shape);

        // _0_0_17_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(31.841597, 97.22718);
        ((GeneralPath) shape).lineTo(56.094707, 79.936935);
        ((GeneralPath) shape).lineTo(56.232212, 79.78812);
        ((GeneralPath) shape).lineTo(47.47878, 71.346535);
        ((GeneralPath) shape).lineTo(47.2924, 71.548164);
        ((GeneralPath) shape).lineTo(31.841597, 97.22718);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        // _0_0_17_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(33.24339, 95.81655);
        ((GeneralPath) shape).lineTo(55.860462, 79.702446);
        ((GeneralPath) shape).lineTo(55.99796, 79.553635);
        ((GeneralPath) shape).lineTo(47.71303, 71.58102);
        ((GeneralPath) shape).lineTo(47.52664, 71.78265);
        ((GeneralPath) shape).lineTo(33.24339, 95.81655);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(42.617530822753906, 120.64187622070312), 3.406888f, new Point2D.Double(42.617530822753906, 120.64187622070312), new float[]{0, 1}, new Color[]{new Color(0xB4942A), new Color(0xE4DCC9)}, NO_CYCLE, SRGB, new AffineTransform(1.231616f, 1.291421f, -11.70616f, 11.17834f, 1411.874f, -1325.552f)));
        g.fill(shape);

        // _0_0_17_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(51.062305, 76.42592);
        ((GeneralPath) shape).curveTo(52.15999, 77.44761, 53.282482, 77.06459, 53.67486, 77.429794);
        ((GeneralPath) shape).curveTo(53.738266, 77.48881, 53.78037, 77.5694, 53.810177, 77.65553);
        ((GeneralPath) shape).lineTo(119.0733, 6.887381);
        ((GeneralPath) shape).lineTo(114.75934, 2.8720372);
        ((GeneralPath) shape).lineTo(49.372314, 73.77426);
        ((GeneralPath) shape).curveTo(49.569042, 73.75839, 49.743523, 73.77058, 49.867622, 73.886086);
        ((GeneralPath) shape).curveTo(50.226265, 74.21992, 49.959526, 75.39947, 51.062305, 76.42592);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(15.727076530456543, 58.08968734741211), 2.6143966f, new Point2D.Double(15.727076530456543, 58.08968734741211), new float[]{0, 0.5f, 0.75f, 1}, new Color[]{new Color(0x252525), new Color(0x252525), new Color(0x252525), BLACK}, NO_CYCLE, SRGB, new AffineTransform(1.54853f, 1.469114f, -21.05168f, 22.68598f, 1272.946f, -1291.402f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.35348833f * origAlpha));

        // _0_0_17_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(56.139603, 74.81749);
        ((GeneralPath) shape).lineTo(53.58407, 77.583176);
        ((GeneralPath) shape).curveTo(53.92704, 77.960365, 53.45654, 78.999374, 54.115776, 79.61297);
        ((GeneralPath) shape).curveTo(54.82623, 80.274254, 55.597614, 79.524734, 56.059303, 79.94943);
        ((GeneralPath) shape).lineTo(58.64581, 77.15019);
        ((GeneralPath) shape).lineTo(56.139603, 74.81749);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_17_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(118.9158, 6.7407947);
        ((GeneralPath) shape).lineTo(53.702244, 77.45529);
        ((GeneralPath) shape).curveTo(54.047096, 77.83425, 53.696117, 78.74662, 54.35873, 79.36335);
        ((GeneralPath) shape).curveTo(55.072807, 80.02803, 55.72626, 79.40656, 56.190292, 79.83346);
        ((GeneralPath) shape).lineTo(121.43482, 9.085448);
        ((GeneralPath) shape).lineTo(118.9158, 6.7407947);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(36.6756477355957, 95.76927947998047), 47.746403f, new Point2D.Double(16.21735382080078, 64.14128112792969), new float[]{0, 0.09292036f, 0.5043171f, 0.91571385f, 1}, new Color[]{new Color(0x9A7600), new Color(0xE3AD00), new Color(0xFFCD2C), new Color(0xE3AD00), new Color(0xB98D00)}, NO_CYCLE, SRGB, new AffineTransform(0.05267341f, 0.05051614f, -1.057794f, 1.116234f, 183.7751f, -66.53858f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.38604653f * origAlpha));

        // _0_0_17_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(51.110016, 72.54274);
        ((GeneralPath) shape).lineTo(49.799088, 73.96148);
        ((GeneralPath) shape).lineTo(49.749435, 74.01399);
        ((GeneralPath) shape).curveTo(50.042374, 74.305, 49.614532, 75.36211, 50.55457, 76.41053);
        ((GeneralPath) shape).lineTo(50.609352, 76.46152);
        ((GeneralPath) shape).lineTo(50.999664, 76.82481);
        ((GeneralPath) shape).lineTo(51.054443, 76.8758);
        ((GeneralPath) shape).curveTo(52.177227, 77.74745, 53.194927, 77.22099, 53.587288, 77.58618);
        ((GeneralPath) shape).lineTo(54.97567, 76.07579);
        ((GeneralPath) shape).lineTo(51.110016, 72.54274);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x252525));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.35348833f * origAlpha));

        // _0_0_17_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(48.617046, 70.194466);
        ((GeneralPath) shape).lineTo(47.290016, 71.55189);
        ((GeneralPath) shape).curveTo(47.30377, 71.56464, 47.195457, 71.6829, 47.209263, 71.695755);
        ((GeneralPath) shape).curveTo(47.490852, 71.95785, 47.10021, 73.01444, 47.56853, 73.631195);
        ((GeneralPath) shape).lineTo(47.616467, 73.6758);
        ((GeneralPath) shape).lineTo(47.828735, 73.87338);
        ((GeneralPath) shape).lineTo(47.856133, 73.898865);
        ((GeneralPath) shape).curveTo(48.519268, 74.34269, 49.40944, 73.79045, 49.749435, 74.01399);
        ((GeneralPath) shape).lineTo(51.123253, 72.5272);
        ((GeneralPath) shape).lineTo(48.617046, 70.194466);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x131313));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_17_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(47.968758, 73.50936);
        ((GeneralPath) shape).curveTo(48.65992, 74.13778, 49.501755, 73.54555, 49.867622, 73.886086);
        ((GeneralPath) shape).lineTo(115.08119, 3.171599);
        ((GeneralPath) shape).lineTo(112.53531, 0.8019672);
        ((GeneralPath) shape).lineTo(47.290775, 71.54999);
        ((GeneralPath) shape).curveTo(47.304752, 71.56292, 47.318485, 71.575775, 47.332504, 71.588844);
        ((GeneralPath) shape).curveTo(47.618553, 71.85508, 47.272434, 72.87611, 47.968758, 73.50936);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(11.326383590698242, 57.38399887084961), new Point2D.Double(14.493531227111816, 57.38399887084961), new float[]{0, 0.09292036f, 0.5043171f, 0.91571385f, 1}, new Color[]{new Color(0x9A7600), new Color(0xE3AD00), new Color(0xFFCD2C), new Color(0xE3AD00), new Color(0xB98D00)}, NO_CYCLE, SRGB, new AffineTransform(0.856502f, 0.799536f, -0.796622f, 0.859634f, 115.5123f, -21.93479f)));
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.732512f, 0.680754f, -0.680754f, 0.732512f, 0, 0));

        // _0_0_17_9
        shape = new Rectangle2D.Double(82.99185180664062, -76.58556365966797, 12.154855728149414, 2.857365846633911);
        g.setPaint(BLACK);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_17_9
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.56268f, -0.608612f, -1.155587f, -1.072069f, 76.43844f, 59.62859f));

        // _0_0_17_10
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(82.17284, 7.462277);
        ((GeneralPath) shape).curveTo(82.17284, 7.719914, 77.16889, 7.966999, 68.26182, 8.149176);
        ((GeneralPath) shape).curveTo(59.354736, 8.331353, 47.274147, 8.433699, 34.67764, 8.433699);
        ((GeneralPath) shape).curveTo(22.08113, 8.433699, 10.00054, 8.331353, 1.093463, 8.149176);
        ((GeneralPath) shape).curveTo(-7.8136144, 7.966999, -12.817558, 7.719914, -12.817558, 7.462277);
        ((GeneralPath) shape).curveTo(-12.817558, 7.20464, -7.8136144, 6.957555, 1.093463, 6.775378);
        ((GeneralPath) shape).curveTo(10.00054, 6.593201, 22.08113, 6.490855, 34.67764, 6.490855);
        ((GeneralPath) shape).curveTo(47.274147, 6.490855, 59.354736, 6.593201, 68.26182, 6.775378);
        ((GeneralPath) shape).curveTo(77.16889, 6.957555, 82.17284, 7.20464, 82.17284, 7.462277);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(34.67763900756836, 7.462276935577393), 47.595196f, new Point2D.Double(34.67763900756836, 7.462276935577393), new float[]{0, 1}, new Color[]{new Color(0xAEFFFFFF, true), new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(0.999914f, -0.007841646f, 5.666079E-4f, 0.02048306f, -0.001242234f, 7.581357f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_17_10
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.465919f, -0.505717f, -0.837024f, -0.779688f, 72.02739f, 62.11862f));

        // _0_0_17_11
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(106.56087, 7.462277);
        ((GeneralPath) shape).curveTo(106.5609, 7.694624, 74.720764, 7.8834887, 35.24227, 7.8853135);
        ((GeneralPath) shape).curveTo(-4.2362256, 7.8871384, -36.57657, 7.701241, -37.196724, 7.4689226);
        ((GeneralPath) shape).curveTo(-37.816895, 7.236604, -6.484828, 7.04482, 32.98388, 7.0393453);
        ((GeneralPath) shape).curveTo(72.45259, 7.0338707, 105.28513, 7.216755, 106.52539, 7.448987);

        g.setPaint(new RadialGradientPaint(new Point2D.Double(34.67763900756836, 7.462276935577393), 47.595196f, new Point2D.Double(34.67763900756836, 7.462276935577393), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(-1.5103f, 0.002641273f, -1.167078E-4f, -0.009110224f, 87.0522f, 7.438666f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_17_11

        // _0_0_17_12
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(108.38485, 5.30161);
        ((GeneralPath) shape).curveTo(107.12716, 6.0907826, 105.93515, 7.4663906, 105.29482, 8.645764);
        ((GeneralPath) shape).lineTo(112.44928, 15.244444);
        ((GeneralPath) shape).lineTo(115.5393, 11.90029);
        ((GeneralPath) shape).lineTo(108.38485, 5.30161);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(114.78737, 11.200422);
        ((GeneralPath) shape).lineTo(111.69734, 14.544576);
        ((GeneralPath) shape).lineTo(114.20374, 16.877474);
        ((GeneralPath) shape).curveTo(115.29929, 16.218853, 116.5563, 14.908329, 117.29377, 13.533321);
        ((GeneralPath) shape).lineTo(114.78737, 11.200422);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(49.009883880615234, 8.495312690734863), 3.9750404f, new Point2D.Double(47.370887756347656, 6.770169734954834), new float[]{0, 1}, new Color[]{WHITE, new Color(0xAEAEAE)}, NO_CYCLE, SRGB, new AffineTransform(1.112439f, 1.035436f, -0.388678f, 0.420644f, 60.1082f, -43.23056f)));
        g.fill(shape);

        // _0_0_17_13
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(42.27053, 89.82674);
        ((GeneralPath) shape).curveTo(40.6429, 89.66667, 39.24413, 87.19937, 38.343975, 86.4445);
        ((GeneralPath) shape).lineTo(31.84288, 97.22175);
        ((GeneralPath) shape).lineTo(42.27053, 89.82674);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.731987f, 0.681319f, -0.678649f, 0.734463f, 0, 0));

        // _0_0_17_14
        shape = new Rectangle2D.Double(86.6741943359375, -77.08168029785156, 5.241995811462402, 1.1477652788162231);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(49.01197052001953, 2.6743078231811523), 1.7246193f, new Point2D.Double(49.01197052001953, 2.6743078231811523), new float[]{0, 1}, new Color[]{WHITE, new Color(0x252525, true)}, NO_CYCLE, SRGB, new AffineTransform(1.519754f, 0, 0, 0.184942f, 14.80903f, -77.11571f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_17_14

        // _0_0_17_15
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(118.05347, 2.2273397);
        ((GeneralPath) shape).curveTo(119.90131, 3.702737, 121.20567, 5.718846, 121.27612, 5.9115605);
        ((GeneralPath) shape).curveTo(121.34655, 6.104276, 119.56393, 3.843466, 118.03439, 2.796435);
        ((GeneralPath) shape).curveTo(116.51655, 1.7573994, 114.37282, 1.6966459, 114.21641, 1.5706147);
        ((GeneralPath) shape).curveTo(114.06, 1.4445845, 113.0071, 0.2936384, 113.97851, 0.35151747);
        ((GeneralPath) shape).curveTo(114.99456, 0.4120566, 116.62619, 1.0887976, 118.05347, 2.2273397);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(48.49856185913086, 0.8115049600601196), new Point2D.Double(48.732723236083984, 2.365726947784424), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1.112439f, 1.035436f, -1.031663f, 1.116507f, 65.57053f, -49.14214f)));
        g.fill(shape);

        // _0_0_17_16
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(60.938377, 71.52827);
        ((GeneralPath) shape).curveTo(60.73753, 71.74541, 60.6241, 71.95325, 60.59806, 72.15179);
        ((GeneralPath) shape).curveTo(60.57203, 72.35035, 60.635857, 72.52122, 60.78954, 72.66441);
        ((GeneralPath) shape).curveTo(60.942577, 72.807, 61.116776, 72.85789, 61.31212, 72.817116);
        ((GeneralPath) shape).curveTo(61.50747, 72.7763, 61.705563, 72.647354, 61.906403, 72.43022);
        ((GeneralPath) shape).curveTo(62.1084, 72.21184, 62.222393, 72.00339, 62.24844, 71.80483);
        ((GeneralPath) shape).curveTo(62.274467, 71.60627, 62.210957, 71.435715, 62.057926, 71.29312);
        ((GeneralPath) shape).curveTo(61.904236, 71.149925, 61.72972, 71.09873, 61.534374, 71.13953);
        ((GeneralPath) shape).curveTo(61.339027, 71.18031, 61.140366, 71.30989, 60.938377, 71.52827);
        ((GeneralPath) shape).moveTo(60.665848, 71.27432);
        ((GeneralPath) shape).curveTo(61.076664, 70.83019, 61.465534, 70.54477, 61.83248, 70.41808);
        ((GeneralPath) shape).curveTo(62.199417, 70.2914, 62.50109, 70.338196, 62.737476, 70.55844);
        ((GeneralPath) shape).curveTo(62.973213, 70.7781, 63.041763, 71.07625, 62.943127, 71.45292);
        ((GeneralPath) shape).curveTo(62.844475, 71.8296, 62.58975, 72.24, 62.178932, 72.68414);
        ((GeneralPath) shape).curveTo(61.76926, 73.12704, 61.38039, 73.41246, 61.0123, 73.54039);
        ((GeneralPath) shape).curveTo(60.645363, 73.66707, 60.344025, 73.62059, 60.108276, 73.40094);
        ((GeneralPath) shape).curveTo(59.87189, 73.180695, 59.803017, 72.882225, 59.901665, 72.50556);
        ((GeneralPath) shape).curveTo(60.00145, 72.127655, 60.256176, 71.71725, 60.665848, 71.27432);
        ((GeneralPath) shape).moveTo(64.51818, 68.599846);
        ((GeneralPath) shape).lineTo(66.14919, 68.33476);
        ((GeneralPath) shape).lineTo(65.46278, 69.07686);
        ((GeneralPath) shape).lineTo(64.367226, 69.25853);
        ((GeneralPath) shape).lineTo(64.27315, 70.363014);
        ((GeneralPath) shape).lineTo(63.58333, 71.108795);
        ((GeneralPath) shape).lineTo(63.725643, 69.45667);
        ((GeneralPath) shape).lineTo(62.15916, 69.71296);
        ((GeneralPath) shape).lineTo(62.84727, 68.96902);
        ((GeneralPath) shape).lineTo(63.87685, 68.80165);
        ((GeneralPath) shape).lineTo(63.965027, 67.76058);
        ((GeneralPath) shape).lineTo(64.65656, 67.01295);
        ((GeneralPath) shape).lineTo(64.51818, 68.599846);
        ((GeneralPath) shape).moveTo(64.728455, 66.93522);
        ((GeneralPath) shape).lineTo(65.44908, 66.15612);
        ((GeneralPath) shape).lineTo(66.550735, 66.01111);
        ((GeneralPath) shape).lineTo(66.61305, 64.89771);
        ((GeneralPath) shape).lineTo(67.335396, 64.11677);
        ((GeneralPath) shape).lineTo(67.20541, 65.95611);
        ((GeneralPath) shape).lineTo(67.81983, 66.52859);
        ((GeneralPath) shape).lineTo(67.16081, 67.24108);
        ((GeneralPath) shape).lineTo(66.54639, 66.66859);
        ((GeneralPath) shape).lineTo(64.728455, 66.93522);
        ((GeneralPath) shape).moveTo(71.26493, 62.585747);
        ((GeneralPath) shape).curveTo(71.14618, 62.80587, 71.009766, 63.022163, 70.85569, 63.234623);
        ((GeneralPath) shape).curveTo(70.7016, 63.447098, 70.53041, 63.655117, 70.342125, 63.858673);
        ((GeneralPath) shape).curveTo(69.91647, 64.318855, 69.51154, 64.62031, 69.12732, 64.76306);
        ((GeneralPath) shape).curveTo(68.742455, 64.90522, 68.43377, 64.867966, 68.20129, 64.65136);
        ((GeneralPath) shape).curveTo(67.96619, 64.43231, 67.90791, 64.12305, 68.02646, 63.72357);
        ((GeneralPath) shape).curveTo(68.14498, 63.32407, 68.4245, 62.886227, 68.864975, 62.410007);
        ((GeneralPath) shape).curveTo(69.03501, 62.226185, 69.20674, 62.05886, 69.38017, 61.90807);
        ((GeneralPath) shape).curveTo(69.55474, 61.756035, 69.72897, 61.622086, 69.90286, 61.50615);
        ((GeneralPath) shape).lineTo(70.20471, 61.787403);
        ((GeneralPath) shape).curveTo(70.01582, 61.898533, 69.83924, 62.019974, 69.67494, 62.151714);
        ((GeneralPath) shape).curveTo(69.511795, 62.28222, 69.35945, 62.42398, 69.21796, 62.576958);
        ((GeneralPath) shape).curveTo(68.9555, 62.860714, 68.79495, 63.11883, 68.73631, 63.35132);
        ((GeneralPath) shape).curveTo(68.67817, 63.581974, 68.72691, 63.769814, 68.88255, 63.914814);
        ((GeneralPath) shape).curveTo(69.03689, 64.058624, 69.22454, 64.09563, 69.44549, 64.02586);
        ((GeneralPath) shape).curveTo(69.66642, 63.95608, 69.902985, 63.784878, 70.15518, 63.51221);
        ((GeneralPath) shape).curveTo(70.22364, 63.438206, 70.2847, 63.367607, 70.33834, 63.300423);
        ((GeneralPath) shape).curveTo(70.39247, 63.231426, 70.43773, 63.166767, 70.47408, 63.106483);
        ((GeneralPath) shape).lineTo(70.19081, 62.842533);
        ((GeneralPath) shape).lineTo(69.78855, 63.27743);
        ((GeneralPath) shape).lineTo(69.53654, 63.042618);
        ((GeneralPath) shape).lineTo(70.56357, 61.932266);
        ((GeneralPath) shape).lineTo(71.26493, 62.585747);
        ((GeneralPath) shape).moveTo(70.49352, 60.702435);
        ((GeneralPath) shape).lineTo(72.271996, 58.77967);
        ((GeneralPath) shape).lineTo(72.556244, 59.044506);
        ((GeneralPath) shape).lineTo(71.43678, 60.254795);
        ((GeneralPath) shape).lineTo(71.708336, 60.507816);
        ((GeneralPath) shape).lineTo(72.76105, 59.369705);
        ((GeneralPath) shape).lineTo(73.0453, 59.634552);
        ((GeneralPath) shape).lineTo(71.99259, 60.772663);
        ((GeneralPath) shape).lineTo(72.326675, 61.08394);
        ((GeneralPath) shape).lineTo(73.483795, 59.832943);
        ((GeneralPath) shape).lineTo(73.76805, 60.097794);
        ((GeneralPath) shape).lineTo(71.95191, 62.061275);
        ((GeneralPath) shape).lineTo(70.49352, 60.702435);
        ((GeneralPath) shape).moveTo(72.88993, 58.1116);
        ((GeneralPath) shape).lineTo(73.62597, 57.31584);
        ((GeneralPath) shape).lineTo(75.555695, 57.24295);
        ((GeneralPath) shape).lineTo(74.555435, 56.31097);
        ((GeneralPath) shape).lineTo(75.18021, 55.63551);
        ((GeneralPath) shape).lineTo(76.6386, 56.99435);
        ((GeneralPath) shape).lineTo(75.902565, 57.790108);
        ((GeneralPath) shape).lineTo(73.97283, 57.862988);
        ((GeneralPath) shape).lineTo(74.9731, 58.79498);
        ((GeneralPath) shape).lineTo(74.34832, 59.47044);
        ((GeneralPath) shape).lineTo(72.88993, 58.1116);
        ((GeneralPath) shape).moveTo(77.03914, 53.62577);
        ((GeneralPath) shape).lineTo(77.77517, 52.830025);
        ((GeneralPath) shape).lineTo(79.7049, 52.757122);
        ((GeneralPath) shape).lineTo(78.704636, 51.825153);
        ((GeneralPath) shape).lineTo(79.329414, 51.14968);
        ((GeneralPath) shape).lineTo(80.7878, 52.50852);
        ((GeneralPath) shape).lineTo(80.05177, 53.304276);
        ((GeneralPath) shape).lineTo(78.12203, 53.377155);
        ((GeneralPath) shape).lineTo(79.12231, 54.30915);
        ((GeneralPath) shape).lineTo(78.49753, 54.98461);
        ((GeneralPath) shape).lineTo(77.03914, 53.62577);
        ((GeneralPath) shape).moveTo(80.61079, 49.711254);
        ((GeneralPath) shape).curveTo(80.85386, 49.448483, 81.0817, 49.27488, 81.29436, 49.190475);
        ((GeneralPath) shape).curveTo(81.50815, 49.104855, 81.676895, 49.119675, 81.80064, 49.234962);
        ((GeneralPath) shape).curveTo(81.924355, 49.350246, 81.95186, 49.51713, 81.88313, 49.735622);
        ((GeneralPath) shape).curveTo(81.81441, 49.954124, 81.65794, 50.195374, 81.41374, 50.45939);
        ((GeneralPath) shape).curveTo(81.16953, 50.72341, 80.940865, 50.89854, 80.72772, 50.98477);
        ((GeneralPath) shape).curveTo(80.51573, 51.06978, 80.34786, 51.054638, 80.22414, 50.939354);
        ((GeneralPath) shape).curveTo(80.1004, 50.82407, 80.072586, 50.656876, 80.140656, 50.437775);
        ((GeneralPath) shape).curveTo(80.20988, 50.217445, 80.36659, 49.97528, 80.61079, 49.711254);
        ((GeneralPath) shape).moveTo(80.83062, 51.3356);
        ((GeneralPath) shape).lineTo(82.239365, 49.81257);
        ((GeneralPath) shape).lineTo(82.43472, 49.99459);
        ((GeneralPath) shape).lineTo(81.02598, 51.51763);
        ((GeneralPath) shape).lineTo(80.83062, 51.3356);
        ((GeneralPath) shape).moveTo(80.77685, 49.865974);
        ((GeneralPath) shape).curveTo(80.681, 49.96962, 80.62734, 50.068924, 80.61587, 50.16389);
        ((GeneralPath) shape).curveTo(80.60554, 50.25764, 80.63815, 50.339703, 80.71369, 50.410088);
        ((GeneralPath) shape).curveTo(80.78923, 50.480473, 80.87286, 50.506714, 80.9646, 50.488815);
        ((GeneralPath) shape).curveTo(81.05746, 50.46969, 81.151825, 50.408302, 81.24767, 50.30466);
        ((GeneralPath) shape).curveTo(81.3424, 50.20227, 81.39524, 50.104504, 81.40622, 50.01136);
        ((GeneralPath) shape).curveTo(81.418335, 49.916992, 81.38662, 49.834614, 81.31108, 49.76423);
        ((GeneralPath) shape).curveTo(81.23554, 49.693848, 81.15101, 49.66792, 81.05749, 49.68644);
        ((GeneralPath) shape).curveTo(80.96512, 49.703743, 80.87157, 49.763584, 80.77685, 49.865974);
        ((GeneralPath) shape).moveTo(85.14347, 46.21668);
        ((GeneralPath) shape).curveTo(85.34118, 46.054058, 85.51612, 45.954056, 85.6683, 45.916676);
        ((GeneralPath) shape).curveTo(85.82097, 45.877464, 85.945816, 45.90306, 86.04285, 45.99347);
        ((GeneralPath) shape).curveTo(86.187416, 46.128166, 86.20047, 46.33557, 86.082016, 46.61569);
        ((GeneralPath) shape).curveTo(85.96291, 46.895203, 85.71735, 47.236057, 85.34534, 47.63825);
        ((GeneralPath) shape).curveTo(85.21411, 47.78013, 85.076126, 47.916866, 84.93137, 48.048443);
        ((GeneralPath) shape).curveTo(84.78842, 48.179405, 84.64043, 48.303364, 84.48739, 48.420326);
        ((GeneralPath) shape).lineTo(84.19726, 48.150005);
        ((GeneralPath) shape).curveTo(84.355675, 48.049538, 84.50447, 47.9424, 84.64367, 47.828613);
        ((GeneralPath) shape).curveTo(84.783356, 47.71299, 84.91197, 47.59164, 85.0295, 47.46457);
        ((GeneralPath) shape).curveTo(85.204094, 47.27581, 85.32036, 47.11538, 85.37828, 46.98329);
        ((GeneralPath) shape).curveTo(85.43733, 46.849964, 85.43463, 46.75327, 85.370155, 46.693195);
        ((GeneralPath) shape).curveTo(85.303734, 46.631313, 85.20566, 46.636402, 85.07594, 46.708485);
        ((GeneralPath) shape).curveTo(84.94671, 46.77873, 84.7891, 46.9144, 84.60309, 47.115498);
        ((GeneralPath) shape).lineTo(84.339485, 47.400486);
        ((GeneralPath) shape).lineTo(84.09724, 47.17477);
        ((GeneralPath) shape).lineTo(84.374535, 46.874977);
        ((GeneralPath) shape).curveTo(84.54, 46.69609, 84.64859, 46.5492, 84.7003, 46.43429);
        ((GeneralPath) shape).curveTo(84.75137, 46.31879, 84.74662, 46.232822, 84.686066, 46.176395);
        ((GeneralPath) shape).curveTo(84.63005, 46.12421, 84.547386, 46.126427, 84.438034, 46.183033);
        ((GeneralPath) shape).curveTo(84.32869, 46.239647, 84.202126, 46.345673, 84.058334, 46.501118);
        ((GeneralPath) shape).curveTo(83.95222, 46.615864, 83.85178, 46.738205, 83.75705, 46.86814);
        ((GeneralPath) shape).curveTo(83.662315, 46.998096, 83.57467, 47.13349, 83.494095, 47.27433);
        ((GeneralPath) shape).lineTo(83.218636, 47.017677);
        ((GeneralPath) shape).curveTo(83.32789, 46.857616, 83.44121, 46.703648, 83.55859, 46.55575);
        ((GeneralPath) shape).curveTo(83.67598, 46.407875, 83.7963, 46.267315, 83.91954, 46.134064);
        ((GeneralPath) shape).curveTo(84.25162, 45.77506, 84.53107, 45.535835, 84.75791, 45.416428);
        ((GeneralPath) shape).curveTo(84.985245, 45.295185, 85.16143, 45.29281, 85.28646, 45.4093);
        ((GeneralPath) shape).curveTo(85.37177, 45.488796, 85.40241, 45.596592, 85.37837, 45.73268);
        ((GeneralPath) shape).curveTo(85.353676, 45.86816, 85.275375, 46.0295, 85.14347, 46.21668);

        g.setPaint(new LinearGradientPaint(new Point2D.Double(49.15303039550781, 75.31031799316406), new Point2D.Double(82.4846420288086, 75.31031799316406), new float[]{0, 1}, new Color[]{new Color(0xB4942A), new Color(0xE4DCC9)}, NO_CYCLE, SRGB, new AffineTransform(0.789159f, 0, 0, 0.789159f, 21.06854f, 0.03497228f)));
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.685219f, 0.728337f, -0.782272f, 0.622937f, 0, 0));

        // _0_0_17_17
        shape = new Rectangle2D.Double(70.87551879882812, -82.5947265625, 3.594980239868164, 0.7820525765419006);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(49.01197052001953, 2.6743078231811523), 1.7246193f, new Point2D.Double(49.01197052001953, 2.6743078231811523), new float[]{0, 1}, new Color[]{WHITE, new Color(0x252525, true)}, NO_CYCLE, SRGB, new AffineTransform(1.042254f, 0, 0, 0.126014f, 21.59014f, -82.61791f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_17_17
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.743171f, -0.669101f, -0.605652f, 0.795729f, 0, 0));

        // _0_0_17_18
        shape = new Rectangle2D.Double(-102.7270736694336, -75.745849609375, 3.5949740409851074, 0.7820497751235962);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(49.01197052001953, 2.6743078231811523), 1.7246193f, new Point2D.Double(49.01197052001953, 2.6743078231811523), new float[]{0, 1}, new Color[]{WHITE, new Color(0x252525, true)}, NO_CYCLE, SRGB, new AffineTransform(1.042253f, 0, 0, 0.126014f, -152.0123f, -75.76904f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_17_18

        g.setTransform(transformations.poll()); // _0_0_17

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
        return 122;
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
    public SelectRectangularInverted() {
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

