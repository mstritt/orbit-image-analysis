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
import java.awt.geom.*;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static java.awt.MultipleGradientPaint.ColorSpaceType.SRGB;
import static java.awt.MultipleGradientPaint.CycleMethod.NO_CYCLE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class EditFind4 implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.transform(new AffineTransform(0.02165152f, 0, 0, 0.01485743f, 43.0076f, 42.68539f));

        // _0_0_0
        g.setComposite(AlphaComposite.getInstance(3, 0.40206185f * origAlpha));

        // _0_0_0_0
        shape = new Rectangle2D.Double(-1559.2523193359375, -150.6968536376953, 1339.633544921875, 478.357177734375);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(302.8571472167969, 366.64788818359375), new Point2D.Double(302.8571472167969, 609.5050659179688), new float[]{0, 0.5f, 1}, new Color[]{new Color(0x0, true), BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(2.774389f, 0, 0, 1.969706f, -1892.179f, -872.8854f)));
        g.fill(shape);

        // _0_0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-219.61876, -150.68037);
        ((GeneralPath) shape).curveTo(-219.61876, -150.68037, -219.61876, 327.65042, -219.61876, 327.65042);
        ((GeneralPath) shape).curveTo(-76.74459, 328.55087, 125.78146, 220.48074, 125.78138, 88.45424);
        ((GeneralPath) shape).curveTo(125.78138, -43.572304, -33.655437, -150.68036, -219.61876, -150.68037);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(605.7142944335938, 486.64788818359375), 117.14286f, new Point2D.Double(605.7142944335938, 486.64788818359375), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(2.774389f, 0, 0, 1.969706f, -1891.633f, -872.8854f)));
        g.fill(shape);

        // _0_0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-1559.2523, -150.68037);
        ((GeneralPath) shape).curveTo(-1559.2523, -150.68037, -1559.2523, 327.65042, -1559.2523, 327.65042);
        ((GeneralPath) shape).curveTo(-1702.1265, 328.55087, -1904.6525, 220.48074, -1904.6525, 88.45424);
        ((GeneralPath) shape).curveTo(-1904.6525, -43.572304, -1745.2157, -150.68036, -1559.2523, -150.68037);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(605.7142944335938, 486.64788818359375), 117.14286f, new Point2D.Double(605.7142944335938, 486.64788818359375), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(-2.774389f, 0, 0, 1.969706f, 112.7623f, -872.8854f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_1

        // _0_1_0
        shape = new RoundRectangle2D.Double(6.60355281829834, 3.6464462280273438, 34.875, 40.920494079589844, 2.2980971336364746, 2.2980971336364746);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(33.966678619384766, 35.736915588378906), 86.70845f, new Point2D.Double(33.966678619384766, 35.736915588378906), new float[]{0, 1}, new Color[]{new Color(0xFAFAFA), new Color(0xBBBBBB)}, NO_CYCLE, SRGB, new AffineTransform(0.960493f, 0, 0, 1.041132f, 0, 0)));
        g.fill(shape);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(8.824419021606445, 3.7561285495758057), 37.751713f, new Point2D.Double(8.824419021606445, 3.7561285495758057), new float[]{0, 1}, new Color[]{new Color(0xA3A3A3), new Color(0x4C4C4C)}, NO_CYCLE, SRGB, new AffineTransform(0.968273f, 0, 0, 1.032767f, 3.353553f, 0.646447f)));
        g.setStroke(new BasicStroke(1, 1, 1, 4));
        g.draw(shape);

        // _0_1_1
        shape = new RoundRectangle2D.Double(7.666053771972656, 4.583946228027344, 32.77588653564453, 38.94638442993164, 0.2980971336364746, 0.2980971336364746);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(8.143556594848633, 7.26789665222168), 38.158695f, new Point2D.Double(8.143556594848633, 7.26789665222168), new float[]{0, 1}, new Color[]{WHITE, new Color(0xF8F8F8)}, NO_CYCLE, SRGB, new AffineTransform(0.968273f, 0, 0, 1.032767f, 3.353553f, 0.646447f)));
        g.draw(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 0.646447f, -0.03798933f));

        // _0_1_2
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.229703f, 0, 0, 0.229703f, 4.967081f, 4.244972f));

        // _0_1_2_0

        // _0_1_2_0_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(23.428, 113.07);
        ((GeneralPath) shape).curveTo(23.428, 115.043, 21.828, 116.642, 19.855, 116.642);
        ((GeneralPath) shape).curveTo(17.881, 116.642, 16.282, 115.042, 16.282, 113.07);
        ((GeneralPath) shape).curveTo(16.282, 111.096, 17.882, 109.497, 19.855, 109.497);
        ((GeneralPath) shape).curveTo(21.828, 109.497, 23.428, 111.097, 23.428, 113.07);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);

        // _0_1_2_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(23.428, 63.07);
        ((GeneralPath) shape).curveTo(23.428, 65.043, 21.828, 66.643, 19.855, 66.643);
        ((GeneralPath) shape).curveTo(17.881, 66.643, 16.282, 65.043, 16.282, 63.07);
        ((GeneralPath) shape).curveTo(16.282, 61.096, 17.882, 59.497, 19.855, 59.497);
        ((GeneralPath) shape).curveTo(21.828, 59.497, 23.428, 61.097, 23.428, 63.07);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_1_2_0

        // _0_1_2_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(9.995011, 29.952326);
        ((GeneralPath) shape).curveTo(9.995011, 30.40553, 9.627486, 30.772825, 9.174282, 30.772825);
        ((GeneralPath) shape).curveTo(8.720848, 30.772825, 8.353554, 30.4053, 8.353554, 29.952326);
        ((GeneralPath) shape).curveTo(8.353554, 29.498892, 8.721078, 29.131598, 9.174282, 29.131598);
        ((GeneralPath) shape).curveTo(9.627486, 29.131598, 9.995011, 29.499123, 9.995011, 29.952326);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(20.892099380493164, 114.56839752197266), 5.256f, new Point2D.Double(20.892099380493164, 114.56839752197266), new float[]{0, 1}, new Color[]{new Color(0xF0F0F0), new Color(0x9A9A9A)}, NO_CYCLE, SRGB, new AffineTransform(0.229703f, 0, 0, 0.229703f, 4.613529f, 3.979808f)));
        g.fill(shape);

        // _0_1_2_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(9.995011, 18.467176);
        ((GeneralPath) shape).curveTo(9.995011, 18.92038, 9.627486, 19.287905, 9.174282, 19.287905);
        ((GeneralPath) shape).curveTo(8.720848, 19.287905, 8.353554, 18.92038, 8.353554, 18.467176);
        ((GeneralPath) shape).curveTo(8.353554, 18.013742, 8.721078, 17.646446, 9.174282, 17.646446);
        ((GeneralPath) shape).curveTo(9.627486, 17.646446, 9.995011, 18.013971, 9.995011, 18.467176);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(20.892099380493164, 64.56790161132812), 5.257f, new Point2D.Double(20.892099380493164, 64.56790161132812), new float[]{0, 1}, new Color[]{new Color(0xF0F0F0), new Color(0x9A9A9A)}, NO_CYCLE, SRGB, new AffineTransform(0.229703f, 0, 0, 0.229703f, 4.613529f, 3.979808f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_1_2

        // _0_1_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(11.505723, 5.4942765);
        ((GeneralPath) shape).lineTo(11.505723, 43.400867);

        g.setPaint(new Color(0x4000000, true));
        g.setStroke(new BasicStroke(0.9885531f, 0, 0, 4));
        g.draw(shape);

        // _0_1_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(12.5, 5.0205154);
        ((GeneralPath) shape).lineTo(12.5, 43.038227);

        g.setPaint(new Color(0x34FFFFFF, true));
        g.setStroke(new BasicStroke(1, 0, 0, 4));
        g.draw(shape);

        // _0_2
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.909091f, 0, 0, 1, 2.363628f, 0));

        // _0_2_0

        // _0_2_0_0
        shape = new RoundRectangle2D.Double(15.000001907348633, 9, 22.000003814697266, 1, 0.3031298518180847, 0.13078175485134125);
        g.setPaint(new Color(0x8C9B9B9B, true));
        g.fill(shape);

        // _0_2_0_1
        shape = new RoundRectangle2D.Double(15.000001907348633, 11, 22.000003814697266, 1, 0.3031298518180847, 0.13078175485134125);
        g.fill(shape);

        // _0_2_0_2
        shape = new RoundRectangle2D.Double(15.000001907348633, 13, 22.000003814697266, 1, 0.3031298518180847, 0.13078175485134125);
        g.fill(shape);

        // _0_2_0_3
        shape = new RoundRectangle2D.Double(15.000001907348633, 15, 22.000003814697266, 1, 0.3031298518180847, 0.13078175485134125);
        g.fill(shape);

        // _0_2_0_4
        shape = new RoundRectangle2D.Double(15.000001907348633, 17, 22.000003814697266, 1, 0.3031298518180847, 0.13078175485134125);
        g.fill(shape);

        // _0_2_0_5
        shape = new RoundRectangle2D.Double(15.000001907348633, 19, 22.000003814697266, 1, 0.3031298518180847, 0.13078175485134125);
        g.fill(shape);

        // _0_2_0_6
        shape = new RoundRectangle2D.Double(15.000001907348633, 21, 22.000003814697266, 1, 0.3031298518180847, 0.13078175485134125);
        g.fill(shape);

        // _0_2_0_7
        shape = new RoundRectangle2D.Double(15.000001907348633, 23, 22.000003814697266, 1, 0.3031298518180847, 0.13078175485134125);
        g.fill(shape);

        // _0_2_0_8
        shape = new RoundRectangle2D.Double(14.999992370605469, 25, 9.900005340576172, 1, 0.1364084780216217, 0.13078175485134125);
        g.fill(shape);

        // _0_2_0_9
        shape = new RoundRectangle2D.Double(14.999992370605469, 29, 22.000003814697266, 1, 0.3031298518180847, 0.13078175485134125);
        g.fill(shape);

        // _0_2_0_10
        shape = new RoundRectangle2D.Double(14.999992370605469, 31, 22.000003814697266, 1, 0.3031298518180847, 0.13078175485134125);
        g.fill(shape);

        // _0_2_0_11
        shape = new RoundRectangle2D.Double(14.999992370605469, 33, 22.000003814697266, 1, 0.3031298518180847, 0.13078175485134125);
        g.fill(shape);

        // _0_2_0_12
        shape = new RoundRectangle2D.Double(14.999992370605469, 35, 22.000003814697266, 1, 0.3031298518180847, 0.13078175485134125);
        g.fill(shape);

        // _0_2_0_13
        shape = new RoundRectangle2D.Double(14.999992370605469, 37, 15.40001392364502, 1, 0.21219104528427124, 0.13078175485134125);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_2_0
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.665377f, 0, 0, 0.665377f, 15.98645f, 17.90835f));

        // _0_2_1
        g.setComposite(AlphaComposite.getInstance(3, 0.17112298f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.446431f, 0, 0, 1.51999f, -10.97453f, -17.75168f));

        // _0_2_1_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(40.65864, 37.967922);
        ((GeneralPath) shape).curveTo(40.65864, 40.140213, 33.258526, 41.901203, 24.13002, 41.901203);
        ((GeneralPath) shape).curveTo(15.001513, 41.901203, 7.6013966, 40.140213, 7.6013966, 37.967922);
        ((GeneralPath) shape).curveTo(7.6013966, 35.79563, 15.001513, 34.03464, 24.130018, 34.03464);
        ((GeneralPath) shape).curveTo(33.258526, 34.03464, 40.65864, 35.79563, 40.65864, 37.967922);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(24.13001823425293, 37.96792221069336), 16.528622f, new Point2D.Double(24.13001823425293, 37.96792221069336), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 0.237968f, 0, 28.93278f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_2_1_0
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_2_1_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(18.62757, 3.1435547);
        ((GeneralPath) shape).curveTo(10.488439, 3.1435547, 3.8827682, 9.749226, 3.8827682, 17.888355);
        ((GeneralPath) shape).curveTo(3.8827682, 26.027487, 10.488439, 32.63316, 18.62757, 32.63316);
        ((GeneralPath) shape).curveTo(22.107124, 32.63316, 25.17857, 31.248766, 27.701292, 29.23051);
        ((GeneralPath) shape).curveTo(27.495914, 30.237392, 27.623257, 31.265879, 28.457436, 31.990437);
        ((GeneralPath) shape).lineTo(39.42152, 41.517845);
        ((GeneralPath) shape).curveTo(40.654938, 42.589176, 42.508984, 42.448807, 43.58031, 41.21539);
        ((GeneralPath) shape).curveTo(44.651638, 39.98197, 44.51127, 38.127926, 43.27785, 37.0566);
        ((GeneralPath) shape).lineTo(32.31377, 27.529188);
        ((GeneralPath) shape).curveTo(31.642242, 26.94591, 30.82089, 26.773218, 30.00753, 26.886465);
        ((GeneralPath) shape).curveTo(31.99423, 24.374044, 33.37237, 21.337664, 33.37237, 17.888355);
        ((GeneralPath) shape).curveTo(33.37237, 9.749226, 26.766699, 3.1435547, 18.62757, 3.1435547);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(18.551954, 4.369738);
        ((GeneralPath) shape).curveTo(26.191414, 4.369738, 31.843729, 9.158689, 31.843729, 17.661512);
        ((GeneralPath) shape).curveTo(31.843729, 26.336626, 26.027039, 30.953287, 18.551954, 30.953287);
        ((GeneralPath) shape).curveTo(11.249005, 30.953287, 5.2601805, 25.475197, 5.2601805, 17.661512);
        ((GeneralPath) shape).curveTo(5.2601805, 9.677406, 11.084819, 4.369738, 18.551954, 4.369738);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xDCDCDC));
        g.fill(shape);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(27.36634063720703, 26.58029556274414), new Point2D.Double(31.33596420288086, 30.557771682739258), new float[]{0, 1}, new Color[]{new Color(0x8A8A8A), new Color(0x484848)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.setStroke(new BasicStroke(3.0058157f, 1, 0, 10));
        g.draw(shape);

        // _0_2_1_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(18.602905, 3.0803552);
        ((GeneralPath) shape).curveTo(10.437465, 3.0803552, 3.8104408, 9.707379, 3.8104408, 17.87282);
        ((GeneralPath) shape).curveTo(3.8104408, 26.03826, 10.437465, 32.665283, 18.602905, 32.665283);
        ((GeneralPath) shape).curveTo(22.093708, 32.665283, 25.175081, 31.276417, 27.70596, 29.251638);
        ((GeneralPath) shape).curveTo(27.49992, 30.261774, 27.627672, 31.293585, 28.464546, 32.020485);
        ((GeneralPath) shape).lineTo(39.464073, 41.57869);
        ((GeneralPath) shape).curveTo(40.701477, 42.653484, 42.561516, 42.51266, 43.636307, 41.275257);
        ((GeneralPath) shape).curveTo(44.711098, 40.037853, 44.570274, 38.177814, 43.33287, 37.103024);
        ((GeneralPath) shape).lineTo(32.333347, 27.544815);
        ((GeneralPath) shape).curveTo(31.659649, 26.959652, 30.835642, 26.786402, 30.019653, 26.900017);
        ((GeneralPath) shape).curveTo(32.012775, 24.379473, 33.39537, 21.333277, 33.39537, 17.87282);
        ((GeneralPath) shape).curveTo(33.39537, 9.707379, 26.768345, 3.0803552, 18.602905, 3.0803552);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(18.527046, 6.266424);
        ((GeneralPath) shape).curveTo(24.808153, 6.2664247, 29.905865, 11.364135, 29.905865, 17.645243);
        ((GeneralPath) shape).curveTo(29.905865, 23.926352, 24.808153, 29.024061, 18.527046, 29.024061);
        ((GeneralPath) shape).curveTo(12.245938, 29.024061, 7.1482277, 23.926352, 7.1482277, 17.645243);
        ((GeneralPath) shape).curveTo(7.1482277, 11.364135, 12.245938, 6.266424, 18.527046, 6.266424);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xDCDCDC));
        g.fill(shape);

        // _0_2_1_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(39.507004, 41.57769);
        ((GeneralPath) shape).curveTo(39.02833, 39.304504, 40.904335, 36.76627, 43.091057, 36.789314);
        ((GeneralPath) shape).curveTo(43.091057, 36.789314, 32.33069, 27.531204, 32.33069, 27.531204);
        ((GeneralPath) shape).curveTo(29.385899, 27.474499, 28.061188, 29.80382, 28.553877, 32.131126);
        ((GeneralPath) shape).lineTo(39.507004, 41.57769);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(30.65625, 34), new Point2D.Double(33.21875, 31.0625), new float[]{0, 0.5f, 1}, new Color[]{new Color(0x7D7D7D), new Color(0xB1B1B1), new Color(0x686868)}, NO_CYCLE, SRGB, new AffineTransform(1.334593f, 0, 0, 1.291292f, -6.973842f, -7.460658f)));
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.245743f, 0, 0, 1.245743f, -3.425346f, -6.177033f));

        // _0_2_1_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(28.549437, 18.920233);
        ((GeneralPath) shape).curveTo(28.549437, 25.022175, 23.602835, 29.968777, 17.500893, 29.968777);
        ((GeneralPath) shape).curveTo(11.398951, 29.968777, 6.4523487, 25.022175, 6.4523487, 18.920233);
        ((GeneralPath) shape).curveTo(6.4523487, 12.818291, 11.398951, 7.871689, 17.500893, 7.871689);
        ((GeneralPath) shape).curveTo(23.602835, 7.871689, 28.549437, 12.818291, 28.549437, 18.920233);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(18.292673110961914, 13.602121353149414), new Point2D.Double(17.500892639160156, 25.74346923828125), new float[]{0, 0.5f, 1}, new Color[]{WHITE, new Color(0x38FFFFFF, true), WHITE}, NO_CYCLE, SRGB, new AffineTransform()));
        g.setStroke(new BasicStroke(1.206434f, 1, 0, 10));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_2_1_4
        g.setComposite(AlphaComposite.getInstance(3, 0.4331551f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.752986f, 0.658037f, -0.648902f, 0.760872f, 0, 0));

        // _0_2_1_5
        shape = new RoundRectangle2D.Double(40.37333679199219, 0.14086054265499115, 19.048439025878906, 4.440478324890137, 6.422405242919922, 4.440478324890137);
        g.setPaint(WHITE);
        g.setStroke(new BasicStroke(1.5029539f, 1, 0, 10));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_2_1_5
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.398614f, 0, 0, 1.398614f, -6.224338f, -8.298958f));

        // _0_2_1_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(25.897785, 18.478292);
        ((GeneralPath) shape).curveTo(25.89879, 21.447306, 24.315418, 24.191217, 21.744347, 25.676014);
        ((GeneralPath) shape).curveTo(19.173273, 27.160812, 16.00529, 27.160812, 13.434216, 25.676014);
        ((GeneralPath) shape).curveTo(10.863142, 24.191217, 9.27977, 21.447306, 9.280776, 18.478292);
        ((GeneralPath) shape).curveTo(9.27977, 15.509279, 10.863142, 12.7653675, 13.434216, 11.28057);
        ((GeneralPath) shape).curveTo(16.00529, 9.7957735, 19.173273, 9.7957735, 21.744347, 11.28057);
        ((GeneralPath) shape).curveTo(24.315418, 12.7653675, 25.89879, 15.509279, 25.897785, 18.478292);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(18.240928649902344, 21.8179874420166), 8.308505f, new Point2D.Double(18.240928649902344, 21.8179874420166), new float[]{0, 1}, new Color[]{new Color(0x35729FCF, true), new Color(0xAC729FCF, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);
        g.setPaint(new Color(0x3063A3));
        g.setStroke(new BasicStroke(1.0745695f, 1, 0, 10));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_2_1_6
        g.setComposite(AlphaComposite.getInstance(3, 0.8342246f * origAlpha));

        // _0_2_1_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(18.156916, 7.3966937);
        ((GeneralPath) shape).curveTo(12.949325, 7.3966937, 8.732368, 11.613651, 8.732368, 16.821241);
        ((GeneralPath) shape).curveTo(8.732368, 18.325216, 9.152676, 19.709015, 9.77954, 20.971144);
        ((GeneralPath) shape).curveTo(11.03192, 21.432756, 12.362297, 21.746826, 13.774307, 21.746826);
        ((GeneralPath) shape).curveTo(19.945263, 21.746826, 24.873589, 16.88519, 25.254414, 10.809698);
        ((GeneralPath) shape).curveTo(23.523449, 8.764167, 21.044374, 7.3966937, 18.156916, 7.3966937);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(15.4143705368042, 13.078408241271973), 6.65625f, new Point2D.Double(15.4143705368042, 13.078408241271973), new float[]{0, 1}, new Color[]{WHITE, new Color(0x3FFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(2.592963f, 0, 0, 2.252104f, -25.05975f, -18.941f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_2_1

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
        return 4;
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
        return 45;
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
    public EditFind4() {
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

