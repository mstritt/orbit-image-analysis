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
import java.awt.geom.Rectangle2D;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static java.awt.MultipleGradientPaint.ColorSpaceType.SRGB;
import static java.awt.MultipleGradientPaint.CycleMethod.NO_CYCLE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class SlidepreviewNoLoupe6 implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.7385876f, 0, 0, 1.109502f, -6.9184694f, -8.622529f));

        // _0_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(11.861845, 10.266208);
        ((GeneralPath) shape).lineTo(11.893095, 102.297455);
        ((GeneralPath) shape).lineTo(11.861845, 194.29745);
        ((GeneralPath) shape).lineTo(111.86184, 194.29745);
        ((GeneralPath) shape).lineTo(111.86184, 117.766205);
        ((GeneralPath) shape).lineTo(111.86184, 86.766205);
        ((GeneralPath) shape).lineTo(111.86184, 10.266205);
        ((GeneralPath) shape).lineTo(11.861847, 10.266205);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(2.4134474, 3.073807);
        ((GeneralPath) shape).lineTo(3.0941164, 46.4382);
        ((GeneralPath) shape).lineTo(3.0941164, 162.48691);
        ((GeneralPath) shape).lineTo(3.0941164, 204.94376);
        ((GeneralPath) shape).lineTo(73.99853, 204.94376);
        ((GeneralPath) shape).lineTo(73.99853, 113.2193);
        ((GeneralPath) shape).lineTo(73.99853, 95.70585);
        ((GeneralPath) shape).lineTo(73.99853, 3.9813843);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(15.5, 98.5642318725586), new Point2D.Double(112.5, 98.5642318725586), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(0.7385876f, 0, 0, 1.109502f, -8.723287f, -4.894649f)));
        g.setStroke(new BasicStroke(0.9052427f, 0, 0, 4));
        g.draw(shape);

        // _0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(4.22578, 4.789145);
        ((GeneralPath) shape).lineTo(4.679559, 45.828674);
        ((GeneralPath) shape).lineTo(4.679559, 162.96472);
        ((GeneralPath) shape).lineTo(4.679559, 205.81937);
        ((GeneralPath) shape).lineTo(76.24832, 205.81937);
        ((GeneralPath) shape).lineTo(76.24832, 113.23549);
        ((GeneralPath) shape).lineTo(76.24832, 95.55793);
        ((GeneralPath) shape).lineTo(74.886986, 4.1084976);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(103.09768676757812, 56.26235580444336), 48.9f, new Point2D.Double(103.09768676757812, 56.26235580444336), new float[]{0, 1}, new Color[]{new Color(0xD2F2FF), new Color(0xC9F3F3F3, true)}, NO_CYCLE, SRGB, new AffineTransform(-0.90764457f, 2.4064069f, -1.2132167f, -1.0326121f, 231.67377f, -179.32922f)));
        g.fill(shape);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(18.182392120361328, 147.37173461914062), 48.5f, new Point2D.Double(18.182392120361328, 147.37173461914062), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(1.3981372f, -0.01410613f, 0.00940114f, 2.102687f, -20.272675f, -107.73248f)));
        g.setStroke(new BasicStroke(1.6447041f, 0, 0, 4));
        g.draw(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.82008857f, 0, 0, 0.83749324f, -6.8375525f, 13.08678f));

        // _0_3

        // _0_3_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(47.032032, 42.984238);
        ((GeneralPath) shape).curveTo(46.9115, 42.99054, 46.80502, 43.013386, 46.688282, 43.046738);
        ((GeneralPath) shape).curveTo(46.100063, 43.214798, 43.872826, 44.405834, 43.563282, 44.921738);
        ((GeneralPath) shape).curveTo(43.072773, 45.739254, 44.14471, 50.572273, 44.407032, 51.359238);
        ((GeneralPath) shape).curveTo(44.734028, 52.340225, 46.004692, 55.445168, 45.438282, 56.577988);
        ((GeneralPath) shape).curveTo(45.17401, 57.10653, 40.59938, 56.534706, 39.813282, 56.796738);
        ((GeneralPath) shape).curveTo(39.566742, 56.878918, 39.422318, 57.304718, 39.188282, 57.421738);
        ((GeneralPath) shape).curveTo(36.475513, 58.778122, 36.06012, 60.656464, 38.157032, 63.015488);
        ((GeneralPath) shape).curveTo(38.92808, 63.88292, 39.53362, 64.36906, 40.438282, 65.10924);
        ((GeneralPath) shape).curveTo(41.237274, 65.76296, 42.07063, 66.42646, 42.938282, 66.98424);
        ((GeneralPath) shape).curveTo(42.946682, 66.98964, 43.06471, 67.07576, 43.157032, 67.14049);
        ((GeneralPath) shape).curveTo(42.28938, 67.698265, 41.456024, 68.36176, 40.657032, 69.01549);
        ((GeneralPath) shape).curveTo(39.75237, 69.75567, 39.14683, 70.241806, 38.375782, 71.10924);
        ((GeneralPath) shape).curveTo(36.27887, 73.46826, 36.694263, 75.3466, 39.407032, 76.70299);
        ((GeneralPath) shape).curveTo(39.641068, 76.82001, 39.785492, 77.245804, 40.032032, 77.32799);
        ((GeneralPath) shape).curveTo(40.81813, 77.59002, 45.39276, 77.018196, 45.657032, 77.54674);
        ((GeneralPath) shape).curveTo(46.223442, 78.67956, 44.952778, 81.7845, 44.625782, 82.76549);
        ((GeneralPath) shape).curveTo(44.36346, 83.55245, 43.291523, 88.385475, 43.782032, 89.20299);
        ((GeneralPath) shape).curveTo(44.091576, 89.718895, 46.318813, 90.90993, 46.907032, 91.07799);
        ((GeneralPath) shape).curveTo(47.02377, 91.111336, 47.13025, 91.134186, 47.250782, 91.14049);
        ((GeneralPath) shape).curveTo(47.61238, 91.15925, 48.011555, 91.07799, 48.375782, 91.07799);
        ((GeneralPath) shape).curveTo(48.92628, 91.07799, 49.687508, 91.21099, 50.219532, 91.07799);
        ((GeneralPath) shape).curveTo(53.542244, 90.24731, 58.220936, 85.76991, 60.219532, 83.17174);
        ((GeneralPath) shape).curveTo(60.934242, 82.242615, 63.451977, 78.60538, 62.719532, 77.14049);
        ((GeneralPath) shape).curveTo(62.50649, 76.7144, 62.354935, 77.09534, 62.094532, 76.92174);
        ((GeneralPath) shape).curveTo(61.93126, 76.81289, 61.85155, 76.62434, 61.688282, 76.51549);
        ((GeneralPath) shape).curveTo(61.19082, 76.183846, 60.625782, 76.70833, 60.625782, 75.89049);
        ((GeneralPath) shape).curveTo(60.625782, 75.75173, 60.52767, 75.551094, 60.625782, 75.45299);
        ((GeneralPath) shape).curveTo(60.63689, 75.44188, 63.133064, 75.195, 63.344532, 75.26549);
        ((GeneralPath) shape).curveTo(63.53069, 75.32754, 63.57527, 75.58398, 63.750782, 75.67174);
        ((GeneralPath) shape).curveTo(63.90936, 75.75103, 64.13993, 75.598045, 64.18828, 75.45299);
        ((GeneralPath) shape).curveTo(64.41218, 74.781296, 64.30156, 71.902214, 64.18828, 71.10924);
        ((GeneralPath) shape).curveTo(64.09428, 70.45124, 63.775757, 69.65293, 63.56328, 69.01549);
        ((GeneralPath) shape).curveTo(63.376507, 68.45517, 63.440308, 67.657486, 63.50078, 66.92174);
        ((GeneralPath) shape).lineTo(63.25078, 66.92174);
        ((GeneralPath) shape).curveTo(63.20065, 66.268776, 63.181168, 65.599304, 63.34453, 65.10924);
        ((GeneralPath) shape).curveTo(63.557007, 64.471794, 63.875526, 63.673485, 63.96953, 63.015488);
        ((GeneralPath) shape).curveTo(64.08281, 62.22251, 64.19343, 59.34343, 63.96953, 58.671738);
        ((GeneralPath) shape).curveTo(63.921177, 58.526676, 63.690605, 58.3737, 63.53203, 58.452988);
        ((GeneralPath) shape).curveTo(63.356518, 58.54075, 63.311935, 58.797188, 63.12578, 58.859238);
        ((GeneralPath) shape).curveTo(62.91431, 58.92973, 60.418137, 58.682846, 60.40703, 58.671738);
        ((GeneralPath) shape).curveTo(60.308918, 58.573627, 60.40703, 58.37299, 60.40703, 58.234238);
        ((GeneralPath) shape).curveTo(60.40703, 57.4164, 60.972065, 57.94088, 61.46953, 57.609238);
        ((GeneralPath) shape).curveTo(61.632797, 57.50039, 61.712505, 57.311836, 61.87578, 57.202988);
        ((GeneralPath) shape).curveTo(62.13618, 57.02939, 62.287735, 57.410324, 62.50078, 56.984238);
        ((GeneralPath) shape).curveTo(63.233223, 55.519352, 60.71549, 51.88211, 60.00078, 50.952988);
        ((GeneralPath) shape).curveTo(58.002182, 48.354813, 53.323486, 43.877415, 50.00078, 43.046738);
        ((GeneralPath) shape).curveTo(49.468754, 42.91373, 48.707527, 43.046738, 48.15703, 43.046738);
        ((GeneralPath) shape).curveTo(47.7928, 43.046738, 47.393627, 42.965477, 47.03203, 42.984238);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x895D85));
        g.fill(shape);

        // _0_3_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(47.190765, 48.610233);
        ((GeneralPath) shape).curveTo(50.827255, 55.345543, 42.249077, 59.38905, 41.946007, 63.784218);
        ((GeneralPath) shape).curveTo(46.886986, 66.969444, 44.94861, 71.00371, 40.306477, 72.10051);
        ((GeneralPath) shape).curveTo(41.156918, 78.598434, 51.59971, 71.89883, 48.006218, 80.65884);
        ((GeneralPath) shape).curveTo(42.208946, 90.73026, 56.789257, 87.16943, 60.114906, 82.24595);
        ((GeneralPath) shape).curveTo(64.40873, 78.312614, 58.117657, 75.49999, 63.698467, 74.13813);
        ((GeneralPath) shape).curveTo(61.926117, 66.74273, 62.0934, 59.405373, 57.65365, 52.4432);
        ((GeneralPath) shape).curveTo(55.63117, 48.13479, 51.024147, 47.654594, 47.36599, 46.784595);

        g.setPaint(new Color(0xAA66B7));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_3
        g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));

        // _0_4
        shape = new Rectangle2D.Double(7.06886100769043, 143.22177124023438, 65.65021514892578, 56.59598922729492);
        g.setPaint(WHITE);
        g.fill(shape);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(57.019283294677734, 132.4290313720703), new Point2D.Double(55.3865852355957, 189.85377502441406), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(0.7385876f, 0, 0, 1.109502f, -6.91847f, -8.622529f)));
        g.setStroke(new BasicStroke(0.18104854f, 1, 1, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.8931165f, 0, 0, 1.1196748f, 0, 0));

        // _0_5
        //  ELB0090-0009 
        g.setPaint(BLACK);
        shape = new GeneralPath();

        g.fill(shape);
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(10.921317, 147.2701);
        ((GeneralPath) shape).lineTo(10.921317, 140.03564);
        ((GeneralPath) shape).lineTo(16.152227, 140.03564);
        ((GeneralPath) shape).lineTo(16.152227, 140.88773);
        ((GeneralPath) shape).lineTo(11.878673, 140.88773);
        ((GeneralPath) shape).lineTo(11.878673, 143.1051);
        ((GeneralPath) shape).lineTo(15.882458, 143.1051);
        ((GeneralPath) shape).lineTo(15.882458, 143.9539);
        ((GeneralPath) shape).lineTo(11.878673, 143.9539);
        ((GeneralPath) shape).lineTo(11.878673, 146.41473);
        ((GeneralPath) shape).lineTo(16.320011, 146.41473);
        ((GeneralPath) shape).lineTo(16.320011, 147.2701);
        ((GeneralPath) shape).lineTo(10.921317, 147.2701);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(17.603065, 147.2701);
        ((GeneralPath) shape).lineTo(17.603065, 140.03564);
        ((GeneralPath) shape).lineTo(18.560421, 140.03564);
        ((GeneralPath) shape).lineTo(18.560421, 146.41473);
        ((GeneralPath) shape).lineTo(22.123362, 146.41473);
        ((GeneralPath) shape).lineTo(22.123362, 147.2701);
        ((GeneralPath) shape).lineTo(17.603065, 147.2701);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(23.223825, 147.2701);
        ((GeneralPath) shape).lineTo(23.223825, 140.03564);
        ((GeneralPath) shape).lineTo(25.937977, 140.03564);
        ((GeneralPath) shape).quadTo(26.767027, 140.03564, 27.268734, 140.25443);
        ((GeneralPath) shape).quadTo(27.770441, 140.4732, 28.053371, 140.9305);
        ((GeneralPath) shape).quadTo(28.3363, 141.38779, 28.3363, 141.88457);
        ((GeneralPath) shape).quadTo(28.3363, 142.34843, 28.084625, 142.75803);
        ((GeneralPath) shape).quadTo(27.832949, 143.16762, 27.326307, 143.42093);
        ((GeneralPath) shape).quadTo(27.980993, 143.61176, 28.334656, 144.07562);
        ((GeneralPath) shape).quadTo(28.688318, 144.53949, 28.688318, 145.17116);
        ((GeneralPath) shape).quadTo(28.688318, 145.68108, 28.47283, 146.11699);
        ((GeneralPath) shape).quadTo(28.257343, 146.5529, 27.941515, 146.78978);
        ((GeneralPath) shape).quadTo(27.625687, 147.02664, 27.1503, 147.14838);
        ((GeneralPath) shape).quadTo(26.674911, 147.2701, 25.984035, 147.2701);
        ((GeneralPath) shape).lineTo(23.223825, 147.2701);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(24.181181, 143.0755);
        ((GeneralPath) shape).lineTo(25.747164, 143.0755);
        ((GeneralPath) shape).quadTo(26.38211, 143.0755, 26.65846, 142.98996);
        ((GeneralPath) shape).quadTo(27.023638, 142.8814, 27.209517, 142.62971);
        ((GeneralPath) shape).quadTo(27.395395, 142.37804, 27.395395, 141.99971);
        ((GeneralPath) shape).quadTo(27.395395, 141.63782, 27.222675, 141.36476);
        ((GeneralPath) shape).quadTo(27.049957, 141.0917, 26.729195, 140.98972);
        ((GeneralPath) shape).quadTo(26.40843, 140.88773, 25.628729, 140.88773);
        ((GeneralPath) shape).lineTo(24.181181, 140.88773);
        ((GeneralPath) shape).lineTo(24.181181, 143.0755);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(24.181181, 146.41473);
        ((GeneralPath) shape).lineTo(25.984035, 146.41473);
        ((GeneralPath) shape).quadTo(26.447908, 146.41473, 26.635433, 146.38182);
        ((GeneralPath) shape).quadTo(26.96442, 146.32262, 27.186487, 146.18443);
        ((GeneralPath) shape).quadTo(27.408554, 146.04626, 27.551664, 145.78142);
        ((GeneralPath) shape).quadTo(27.694775, 145.51659, 27.694775, 145.17116);
        ((GeneralPath) shape).quadTo(27.694775, 144.7665, 27.48751, 144.46877);
        ((GeneralPath) shape).quadTo(27.280249, 144.17102, 26.913427, 144.0493);
        ((GeneralPath) shape).quadTo(26.546606, 143.92758, 25.85573, 143.92758);
        ((GeneralPath) shape).lineTo(24.181181, 143.92758);
        ((GeneralPath) shape).lineTo(24.181181, 146.41473);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(29.645672, 143.70058);
        ((GeneralPath) shape).quadTo(29.645672, 142.41753, 29.908863, 141.63617);
        ((GeneralPath) shape).quadTo(30.172052, 140.85483, 30.693499, 140.43044);
        ((GeneralPath) shape).quadTo(31.214945, 140.00604, 32.004517, 140.00604);
        ((GeneralPath) shape).quadTo(32.586826, 140.00604, 33.026024, 140.23962);
        ((GeneralPath) shape).quadTo(33.465225, 140.4732, 33.751442, 140.9157);
        ((GeneralPath) shape).quadTo(34.037663, 141.35818, 34.200512, 141.99149);
        ((GeneralPath) shape).quadTo(34.36336, 142.62479, 34.36336, 143.70058);
        ((GeneralPath) shape).quadTo(34.36336, 144.97375, 34.101814, 145.75674);
        ((GeneralPath) shape).quadTo(33.84027, 146.53975, 33.318825, 146.96742);
        ((GeneralPath) shape).quadTo(32.79738, 147.39511, 32.004517, 147.39511);
        ((GeneralPath) shape).quadTo(30.958334, 147.39511, 30.359577, 146.64172);
        ((GeneralPath) shape).quadTo(29.645672, 145.7403, 29.645672, 143.70058);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(30.556969, 143.70058);
        ((GeneralPath) shape).quadTo(30.556969, 145.48369, 30.974785, 146.07259);
        ((GeneralPath) shape).quadTo(31.3926, 146.66147, 32.004517, 146.66147);
        ((GeneralPath) shape).quadTo(32.616436, 146.66147, 33.032604, 146.06929);
        ((GeneralPath) shape).quadTo(33.448776, 145.47711, 33.448776, 143.70058);
        ((GeneralPath) shape).quadTo(33.448776, 141.91417, 33.032604, 141.32692);
        ((GeneralPath) shape).quadTo(32.616436, 140.73969, 31.994648, 140.73969);
        ((GeneralPath) shape).quadTo(31.382729, 140.73969, 31.017553, 141.25949);
        ((GeneralPath) shape).quadTo(30.556969, 141.92075, 30.556969, 143.70058);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(35.266434, 143.70058);
        ((GeneralPath) shape).quadTo(35.266434, 142.41753, 35.529625, 141.63617);
        ((GeneralPath) shape).quadTo(35.792816, 140.85483, 36.314262, 140.43044);
        ((GeneralPath) shape).quadTo(36.83571, 140.00604, 37.62528, 140.00604);
        ((GeneralPath) shape).quadTo(38.20759, 140.00604, 38.646786, 140.23962);
        ((GeneralPath) shape).quadTo(39.085987, 140.4732, 39.372204, 140.9157);
        ((GeneralPath) shape).quadTo(39.658424, 141.35818, 39.821274, 141.99149);
        ((GeneralPath) shape).quadTo(39.984123, 142.62479, 39.984123, 143.70058);
        ((GeneralPath) shape).quadTo(39.984123, 144.97375, 39.722576, 145.75674);
        ((GeneralPath) shape).quadTo(39.461033, 146.53975, 38.939587, 146.96742);
        ((GeneralPath) shape).quadTo(38.41814, 147.39511, 37.62528, 147.39511);
        ((GeneralPath) shape).quadTo(36.579098, 147.39511, 35.98034, 146.64172);
        ((GeneralPath) shape).quadTo(35.266434, 145.7403, 35.266434, 143.70058);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(36.17773, 143.70058);
        ((GeneralPath) shape).quadTo(36.17773, 145.48369, 36.595547, 146.07259);
        ((GeneralPath) shape).quadTo(37.01336, 146.66147, 37.62528, 146.66147);
        ((GeneralPath) shape).quadTo(38.237198, 146.66147, 38.653366, 146.06929);
        ((GeneralPath) shape).quadTo(39.06954, 145.47711, 39.06954, 143.70058);
        ((GeneralPath) shape).quadTo(39.06954, 141.91417, 38.653366, 141.32692);
        ((GeneralPath) shape).quadTo(38.237198, 140.73969, 37.61541, 140.73969);
        ((GeneralPath) shape).quadTo(37.00349, 140.73969, 36.638313, 141.25949);
        ((GeneralPath) shape).quadTo(36.17773, 141.92075, 36.17773, 143.70058);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(41.01879, 145.59555);
        ((GeneralPath) shape).lineTo(41.87416, 145.51659);
        ((GeneralPath) shape).quadTo(41.982727, 146.11864, 42.288685, 146.39005);
        ((GeneralPath) shape).quadTo(42.594643, 146.66147, 43.07168, 146.66147);
        ((GeneralPath) shape).quadTo(43.48291, 146.66147, 43.790516, 146.47394);
        ((GeneralPath) shape).quadTo(44.098118, 146.28642, 44.295513, 145.97388);
        ((GeneralPath) shape).quadTo(44.492905, 145.66135, 44.626144, 145.12839);
        ((GeneralPath) shape).quadTo(44.759384, 144.59543, 44.759384, 144.04272);
        ((GeneralPath) shape).quadTo(44.759384, 143.9835, 44.756096, 143.86507);
        ((GeneralPath) shape).quadTo(44.489616, 144.28946, 44.027386, 144.55266);
        ((GeneralPath) shape).quadTo(43.56516, 144.81584, 43.028908, 144.81584);
        ((GeneralPath) shape).quadTo(42.13077, 144.81584, 41.508984, 144.16444);
        ((GeneralPath) shape).quadTo(40.887196, 143.51305, 40.887196, 142.44713);
        ((GeneralPath) shape).quadTo(40.887196, 141.34831, 41.5353, 140.67717);
        ((GeneralPath) shape).quadTo(42.18341, 140.00604, 43.160503, 140.00604);
        ((GeneralPath) shape).quadTo(43.86783, 140.00604, 44.451782, 140.38602);
        ((GeneralPath) shape).quadTo(45.035736, 140.766, 45.34005, 141.46838);
        ((GeneralPath) shape).quadTo(45.644363, 142.17078, 45.644363, 143.50319);
        ((GeneralPath) shape).quadTo(45.644363, 144.89151, 45.343338, 145.71234);
        ((GeneralPath) shape).quadTo(45.042316, 146.53316, 44.446846, 146.96414);
        ((GeneralPath) shape).quadTo(43.85138, 147.39511, 43.051937, 147.39511);
        ((GeneralPath) shape).quadTo(42.203148, 147.39511, 41.665253, 146.92302);
        ((GeneralPath) shape).quadTo(41.127357, 146.45091, 41.01879, 145.59555);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(44.6574, 142.40436);
        ((GeneralPath) shape).quadTo(44.6574, 141.63782, 44.249454, 141.18875);
        ((GeneralPath) shape).quadTo(43.84151, 140.73969, 43.26907, 140.73969);
        ((GeneralPath) shape).quadTo(42.67689, 140.73969, 42.237694, 141.2233);
        ((GeneralPath) shape).quadTo(41.798492, 141.70691, 41.798492, 142.47675);
        ((GeneralPath) shape).quadTo(41.798492, 143.16762, 42.21631, 143.60023);
        ((GeneralPath) shape).quadTo(42.63412, 144.03285, 43.24604, 144.03285);
        ((GeneralPath) shape).quadTo(43.861248, 144.03285, 44.259323, 143.60023);
        ((GeneralPath) shape).quadTo(44.6574, 143.16762, 44.6574, 142.40436);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(46.507957, 143.70058);
        ((GeneralPath) shape).quadTo(46.507957, 142.41753, 46.77115, 141.63617);
        ((GeneralPath) shape).quadTo(47.03434, 140.85483, 47.555786, 140.43044);
        ((GeneralPath) shape).quadTo(48.077232, 140.00604, 48.866802, 140.00604);
        ((GeneralPath) shape).quadTo(49.449112, 140.00604, 49.88831, 140.23962);
        ((GeneralPath) shape).quadTo(50.32751, 140.4732, 50.613728, 140.9157);
        ((GeneralPath) shape).quadTo(50.89995, 141.35818, 51.062798, 141.99149);
        ((GeneralPath) shape).quadTo(51.225647, 142.62479, 51.225647, 143.70058);
        ((GeneralPath) shape).quadTo(51.225647, 144.97375, 50.9641, 145.75674);
        ((GeneralPath) shape).quadTo(50.702557, 146.53975, 50.18111, 146.96742);
        ((GeneralPath) shape).quadTo(49.659664, 147.39511, 48.866802, 147.39511);
        ((GeneralPath) shape).quadTo(47.82062, 147.39511, 47.221863, 146.64172);
        ((GeneralPath) shape).quadTo(46.507957, 145.7403, 46.507957, 143.70058);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(47.419254, 143.70058);
        ((GeneralPath) shape).quadTo(47.419254, 145.48369, 47.83707, 146.07259);
        ((GeneralPath) shape).quadTo(48.254883, 146.66147, 48.866802, 146.66147);
        ((GeneralPath) shape).quadTo(49.47872, 146.66147, 49.89489, 146.06929);
        ((GeneralPath) shape).quadTo(50.31106, 145.47711, 50.31106, 143.70058);
        ((GeneralPath) shape).quadTo(50.31106, 141.91417, 49.89489, 141.32692);
        ((GeneralPath) shape).quadTo(49.47872, 140.73969, 48.856934, 140.73969);
        ((GeneralPath) shape).quadTo(48.245014, 140.73969, 47.879837, 141.25949);
        ((GeneralPath) shape).quadTo(47.419254, 141.92075, 47.419254, 143.70058);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(52.03002, 145.09877);
        ((GeneralPath) shape).lineTo(52.03002, 144.20393);
        ((GeneralPath) shape).lineTo(54.757336, 144.20393);
        ((GeneralPath) shape).lineTo(54.757336, 145.09877);
        ((GeneralPath) shape).lineTo(52.03002, 145.09877);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(55.494267, 143.70058);
        ((GeneralPath) shape).quadTo(55.494267, 142.41753, 55.757458, 141.63617);
        ((GeneralPath) shape).quadTo(56.02065, 140.85483, 56.542095, 140.43044);
        ((GeneralPath) shape).quadTo(57.06354, 140.00604, 57.85311, 140.00604);
        ((GeneralPath) shape).quadTo(58.43542, 140.00604, 58.87462, 140.23962);
        ((GeneralPath) shape).quadTo(59.31382, 140.4732, 59.600037, 140.9157);
        ((GeneralPath) shape).quadTo(59.886257, 141.35818, 60.049107, 141.99149);
        ((GeneralPath) shape).quadTo(60.211956, 142.62479, 60.211956, 143.70058);
        ((GeneralPath) shape).quadTo(60.211956, 144.97375, 59.95041, 145.75674);
        ((GeneralPath) shape).quadTo(59.688866, 146.53975, 59.16742, 146.96742);
        ((GeneralPath) shape).quadTo(58.645973, 147.39511, 57.85311, 147.39511);
        ((GeneralPath) shape).quadTo(56.80693, 147.39511, 56.20817, 146.64172);
        ((GeneralPath) shape).quadTo(55.494267, 145.7403, 55.494267, 143.70058);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(56.405563, 143.70058);
        ((GeneralPath) shape).quadTo(56.405563, 145.48369, 56.82338, 146.07259);
        ((GeneralPath) shape).quadTo(57.24119, 146.66147, 57.85311, 146.66147);
        ((GeneralPath) shape).quadTo(58.46503, 146.66147, 58.8812, 146.06929);
        ((GeneralPath) shape).quadTo(59.29737, 145.47711, 59.29737, 143.70058);
        ((GeneralPath) shape).quadTo(59.29737, 141.91417, 58.8812, 141.32692);
        ((GeneralPath) shape).quadTo(58.46503, 140.73969, 57.843243, 140.73969);
        ((GeneralPath) shape).quadTo(57.231323, 140.73969, 56.866146, 141.25949);
        ((GeneralPath) shape).quadTo(56.405563, 141.92075, 56.405563, 143.70058);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(61.11503, 143.70058);
        ((GeneralPath) shape).quadTo(61.11503, 142.41753, 61.37822, 141.63617);
        ((GeneralPath) shape).quadTo(61.64141, 140.85483, 62.162857, 140.43044);
        ((GeneralPath) shape).quadTo(62.684303, 140.00604, 63.473873, 140.00604);
        ((GeneralPath) shape).quadTo(64.05618, 140.00604, 64.495384, 140.23962);
        ((GeneralPath) shape).quadTo(64.93458, 140.4732, 65.2208, 140.9157);
        ((GeneralPath) shape).quadTo(65.50702, 141.35818, 65.66987, 141.99149);
        ((GeneralPath) shape).quadTo(65.83272, 142.62479, 65.83272, 143.70058);
        ((GeneralPath) shape).quadTo(65.83272, 144.97375, 65.571175, 145.75674);
        ((GeneralPath) shape).quadTo(65.30962, 146.53975, 64.78818, 146.96742);
        ((GeneralPath) shape).quadTo(64.26673, 147.39511, 63.473873, 147.39511);
        ((GeneralPath) shape).quadTo(62.427692, 147.39511, 61.828934, 146.64172);
        ((GeneralPath) shape).quadTo(61.11503, 145.7403, 61.11503, 143.70058);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(62.026325, 143.70058);
        ((GeneralPath) shape).quadTo(62.026325, 145.48369, 62.44414, 146.07259);
        ((GeneralPath) shape).quadTo(62.861954, 146.66147, 63.473873, 146.66147);
        ((GeneralPath) shape).quadTo(64.08579, 146.66147, 64.50196, 146.06929);
        ((GeneralPath) shape).quadTo(64.91813, 145.47711, 64.91813, 143.70058);
        ((GeneralPath) shape).quadTo(64.91813, 141.91417, 64.50196, 141.32692);
        ((GeneralPath) shape).quadTo(64.08579, 140.73969, 63.464005, 140.73969);
        ((GeneralPath) shape).quadTo(62.852085, 140.73969, 62.486908, 141.25949);
        ((GeneralPath) shape).quadTo(62.026325, 141.92075, 62.026325, 143.70058);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(66.73579, 143.70058);
        ((GeneralPath) shape).quadTo(66.73579, 142.41753, 66.99898, 141.63617);
        ((GeneralPath) shape).quadTo(67.26217, 140.85483, 67.783615, 140.43044);
        ((GeneralPath) shape).quadTo(68.30506, 140.00604, 69.094635, 140.00604);
        ((GeneralPath) shape).quadTo(69.67694, 140.00604, 70.11614, 140.23962);
        ((GeneralPath) shape).quadTo(70.555336, 140.4732, 70.84156, 140.9157);
        ((GeneralPath) shape).quadTo(71.12778, 141.35818, 71.29063, 141.99149);
        ((GeneralPath) shape).quadTo(71.453476, 142.62479, 71.453476, 143.70058);
        ((GeneralPath) shape).quadTo(71.453476, 144.97375, 71.19193, 145.75674);
        ((GeneralPath) shape).quadTo(70.93038, 146.53975, 70.408936, 146.96742);
        ((GeneralPath) shape).quadTo(69.88749, 147.39511, 69.094635, 147.39511);
        ((GeneralPath) shape).quadTo(68.04845, 147.39511, 67.44969, 146.64172);
        ((GeneralPath) shape).quadTo(66.73579, 145.7403, 66.73579, 143.70058);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(67.64709, 143.70058);
        ((GeneralPath) shape).quadTo(67.64709, 145.48369, 68.064896, 146.07259);
        ((GeneralPath) shape).quadTo(68.48271, 146.66147, 69.094635, 146.66147);
        ((GeneralPath) shape).quadTo(69.70655, 146.66147, 70.12272, 146.06929);
        ((GeneralPath) shape).quadTo(70.53889, 145.47711, 70.53889, 143.70058);
        ((GeneralPath) shape).quadTo(70.53889, 141.91417, 70.12272, 141.32692);
        ((GeneralPath) shape).quadTo(69.70655, 140.73969, 69.08476, 140.73969);
        ((GeneralPath) shape).quadTo(68.47285, 140.73969, 68.107666, 141.25949);
        ((GeneralPath) shape).quadTo(67.64709, 141.92075, 67.64709, 143.70058);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(72.488144, 145.59555);
        ((GeneralPath) shape).lineTo(73.34351, 145.51659);
        ((GeneralPath) shape).quadTo(73.45208, 146.11864, 73.75804, 146.39005);
        ((GeneralPath) shape).quadTo(74.064, 146.66147, 74.54103, 146.66147);
        ((GeneralPath) shape).quadTo(74.95227, 146.66147, 75.25987, 146.47394);
        ((GeneralPath) shape).quadTo(75.567474, 146.28642, 75.76487, 145.97388);
        ((GeneralPath) shape).quadTo(75.962265, 145.66135, 76.095505, 145.12839);
        ((GeneralPath) shape).quadTo(76.228745, 144.59543, 76.228745, 144.04272);
        ((GeneralPath) shape).quadTo(76.228745, 143.9835, 76.22546, 143.86507);
        ((GeneralPath) shape).quadTo(75.95897, 144.28946, 75.49674, 144.55266);
        ((GeneralPath) shape).quadTo(75.034515, 144.81584, 74.49827, 144.81584);
        ((GeneralPath) shape).quadTo(73.60013, 144.81584, 72.97834, 144.16444);
        ((GeneralPath) shape).quadTo(72.35655, 143.51305, 72.35655, 142.44713);
        ((GeneralPath) shape).quadTo(72.35655, 141.34831, 73.00466, 140.67717);
        ((GeneralPath) shape).quadTo(73.65276, 140.00604, 74.62986, 140.00604);
        ((GeneralPath) shape).quadTo(75.33718, 140.00604, 75.921135, 140.38602);
        ((GeneralPath) shape).quadTo(76.50509, 140.766, 76.80941, 141.46838);
        ((GeneralPath) shape).quadTo(77.11372, 142.17078, 77.11372, 143.50319);
        ((GeneralPath) shape).quadTo(77.11372, 144.89151, 76.8127, 145.71234);
        ((GeneralPath) shape).quadTo(76.51167, 146.53316, 75.91621, 146.96414);
        ((GeneralPath) shape).quadTo(75.32073, 147.39511, 74.52129, 147.39511);
        ((GeneralPath) shape).quadTo(73.67251, 147.39511, 73.13461, 146.92302);
        ((GeneralPath) shape).quadTo(72.59671, 146.45091, 72.488144, 145.59555);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(76.126755, 142.40436);
        ((GeneralPath) shape).quadTo(76.126755, 141.63782, 75.71881, 141.18875);
        ((GeneralPath) shape).quadTo(75.31087, 140.73969, 74.73843, 140.73969);
        ((GeneralPath) shape).quadTo(74.14625, 140.73969, 73.70705, 141.2233);
        ((GeneralPath) shape).quadTo(73.26785, 141.70691, 73.26785, 142.47675);
        ((GeneralPath) shape).quadTo(73.26785, 143.16762, 73.68566, 143.60023);
        ((GeneralPath) shape).quadTo(74.10348, 144.03285, 74.7154, 144.03285);
        ((GeneralPath) shape).quadTo(75.330605, 144.03285, 75.72868, 143.60023);
        ((GeneralPath) shape).quadTo(76.126755, 143.16762, 76.126755, 142.40436);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        shape = new GeneralPath();

        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_5
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.5473774f, 0, 0, 0.78110826f, 9.056873f, 67.797966f));

        // _0_6

        // _0_6_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(47.032032, 42.984238);
        ((GeneralPath) shape).curveTo(46.9115, 42.99054, 46.80502, 43.013386, 46.688282, 43.046738);
        ((GeneralPath) shape).curveTo(46.100063, 43.214798, 43.872826, 44.405834, 43.563282, 44.921738);
        ((GeneralPath) shape).curveTo(43.072773, 45.739254, 44.14471, 50.572273, 44.407032, 51.359238);
        ((GeneralPath) shape).curveTo(44.734028, 52.340225, 46.004692, 55.445168, 45.438282, 56.577988);
        ((GeneralPath) shape).curveTo(45.17401, 57.10653, 40.59938, 56.534706, 39.813282, 56.796738);
        ((GeneralPath) shape).curveTo(39.566742, 56.878918, 39.422318, 57.304718, 39.188282, 57.421738);
        ((GeneralPath) shape).curveTo(36.475513, 58.778122, 36.06012, 60.656464, 38.157032, 63.015488);
        ((GeneralPath) shape).curveTo(38.92808, 63.88292, 39.53362, 64.36906, 40.438282, 65.10924);
        ((GeneralPath) shape).curveTo(41.237274, 65.76296, 42.07063, 66.42646, 42.938282, 66.98424);
        ((GeneralPath) shape).curveTo(42.946682, 66.98964, 43.06471, 67.07576, 43.157032, 67.14049);
        ((GeneralPath) shape).curveTo(42.28938, 67.698265, 41.456024, 68.36176, 40.657032, 69.01549);
        ((GeneralPath) shape).curveTo(39.75237, 69.75567, 39.14683, 70.241806, 38.375782, 71.10924);
        ((GeneralPath) shape).curveTo(36.27887, 73.46826, 36.694263, 75.3466, 39.407032, 76.70299);
        ((GeneralPath) shape).curveTo(39.641068, 76.82001, 39.785492, 77.245804, 40.032032, 77.32799);
        ((GeneralPath) shape).curveTo(40.81813, 77.59002, 45.39276, 77.018196, 45.657032, 77.54674);
        ((GeneralPath) shape).curveTo(46.223442, 78.67956, 44.952778, 81.7845, 44.625782, 82.76549);
        ((GeneralPath) shape).curveTo(44.36346, 83.55245, 43.291523, 88.385475, 43.782032, 89.20299);
        ((GeneralPath) shape).curveTo(44.091576, 89.718895, 46.318813, 90.90993, 46.907032, 91.07799);
        ((GeneralPath) shape).curveTo(47.02377, 91.111336, 47.13025, 91.134186, 47.250782, 91.14049);
        ((GeneralPath) shape).curveTo(47.61238, 91.15925, 48.011555, 91.07799, 48.375782, 91.07799);
        ((GeneralPath) shape).curveTo(48.92628, 91.07799, 49.687508, 91.21099, 50.219532, 91.07799);
        ((GeneralPath) shape).curveTo(53.542244, 90.24731, 58.220936, 85.76991, 60.219532, 83.17174);
        ((GeneralPath) shape).curveTo(60.934242, 82.242615, 63.451977, 78.60538, 62.719532, 77.14049);
        ((GeneralPath) shape).curveTo(62.50649, 76.7144, 62.354935, 77.09534, 62.094532, 76.92174);
        ((GeneralPath) shape).curveTo(61.93126, 76.81289, 61.85155, 76.62434, 61.688282, 76.51549);
        ((GeneralPath) shape).curveTo(61.19082, 76.183846, 60.625782, 76.70833, 60.625782, 75.89049);
        ((GeneralPath) shape).curveTo(60.625782, 75.75173, 60.52767, 75.551094, 60.625782, 75.45299);
        ((GeneralPath) shape).curveTo(60.63689, 75.44188, 63.133064, 75.195, 63.344532, 75.26549);
        ((GeneralPath) shape).curveTo(63.53069, 75.32754, 63.57527, 75.58398, 63.750782, 75.67174);
        ((GeneralPath) shape).curveTo(63.90936, 75.75103, 64.13993, 75.598045, 64.18828, 75.45299);
        ((GeneralPath) shape).curveTo(64.41218, 74.781296, 64.30156, 71.902214, 64.18828, 71.10924);
        ((GeneralPath) shape).curveTo(64.09428, 70.45124, 63.775757, 69.65293, 63.56328, 69.01549);
        ((GeneralPath) shape).curveTo(63.376507, 68.45517, 63.440308, 67.657486, 63.50078, 66.92174);
        ((GeneralPath) shape).lineTo(63.25078, 66.92174);
        ((GeneralPath) shape).curveTo(63.20065, 66.268776, 63.181168, 65.599304, 63.34453, 65.10924);
        ((GeneralPath) shape).curveTo(63.557007, 64.471794, 63.875526, 63.673485, 63.96953, 63.015488);
        ((GeneralPath) shape).curveTo(64.08281, 62.22251, 64.19343, 59.34343, 63.96953, 58.671738);
        ((GeneralPath) shape).curveTo(63.921177, 58.526676, 63.690605, 58.3737, 63.53203, 58.452988);
        ((GeneralPath) shape).curveTo(63.356518, 58.54075, 63.311935, 58.797188, 63.12578, 58.859238);
        ((GeneralPath) shape).curveTo(62.91431, 58.92973, 60.418137, 58.682846, 60.40703, 58.671738);
        ((GeneralPath) shape).curveTo(60.308918, 58.573627, 60.40703, 58.37299, 60.40703, 58.234238);
        ((GeneralPath) shape).curveTo(60.40703, 57.4164, 60.972065, 57.94088, 61.46953, 57.609238);
        ((GeneralPath) shape).curveTo(61.632797, 57.50039, 61.712505, 57.311836, 61.87578, 57.202988);
        ((GeneralPath) shape).curveTo(62.13618, 57.02939, 62.287735, 57.410324, 62.50078, 56.984238);
        ((GeneralPath) shape).curveTo(63.233223, 55.519352, 60.71549, 51.88211, 60.00078, 50.952988);
        ((GeneralPath) shape).curveTo(58.002182, 48.354813, 53.323486, 43.877415, 50.00078, 43.046738);
        ((GeneralPath) shape).curveTo(49.468754, 42.91373, 48.707527, 43.046738, 48.15703, 43.046738);
        ((GeneralPath) shape).curveTo(47.7928, 43.046738, 47.393627, 42.965477, 47.03203, 42.984238);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x895D85));
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.8268931f, 0, 0, 1.2802323f, -16.545938f, -86.79716f));

        // _0_6_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(34.96875, 104.34375);
        ((GeneralPath) shape).lineTo(34.875, 105.78125);
        ((GeneralPath) shape).curveTo(36.865532, 111.04226, 32.197144, 114.1919, 32.03125, 117.625);
        ((GeneralPath) shape).curveTo(34.735832, 120.11301, 33.665997, 123.26828, 31.125, 124.125);
        ((GeneralPath) shape).curveTo(31.590511, 129.20058, 37.310745, 123.96998, 35.34375, 130.8125);
        ((GeneralPath) shape).curveTo(32.170456, 138.67938, 40.148365, 135.87703, 41.96875, 132.03125);
        ((GeneralPath) shape).curveTo(44.31909, 128.9589, 40.88269, 126.78251, 43.9375, 125.71875);
        ((GeneralPath) shape).curveTo(42.967358, 119.94214, 43.055218, 114.18821, 40.625, 108.75);
        ((GeneralPath) shape).curveTo(39.51794, 105.38466, 36.971146, 105.02331, 34.96875, 104.34375);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(37.65625, 116.6875);
        ((GeneralPath) shape).curveTo(39.509445, 117.05814, 39.9375, 116.57086, 39.9375, 118.5);
        ((GeneralPath) shape).curveTo(39.9375, 123.37108, 31.292852, 120.93242, 37.65625, 116.6875);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xAA66B7));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_6_1

        g.setTransform(transformations.poll()); // _0_6
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.6027528f, 0, 0, 0.5494841f, 4.2490172f, -9.982443f));

        // _0_7

        // _0_7_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(47.032032, 42.984238);
        ((GeneralPath) shape).curveTo(46.9115, 42.99054, 46.80502, 43.013386, 46.688282, 43.046738);
        ((GeneralPath) shape).curveTo(46.100063, 43.214798, 43.872826, 44.405834, 43.563282, 44.921738);
        ((GeneralPath) shape).curveTo(43.072773, 45.739254, 44.14471, 50.572273, 44.407032, 51.359238);
        ((GeneralPath) shape).curveTo(44.734028, 52.340225, 46.004692, 55.445168, 45.438282, 56.577988);
        ((GeneralPath) shape).curveTo(45.17401, 57.10653, 40.59938, 56.534706, 39.813282, 56.796738);
        ((GeneralPath) shape).curveTo(39.566742, 56.878918, 39.422318, 57.304718, 39.188282, 57.421738);
        ((GeneralPath) shape).curveTo(36.475513, 58.778122, 36.06012, 60.656464, 38.157032, 63.015488);
        ((GeneralPath) shape).curveTo(38.92808, 63.88292, 39.53362, 64.36906, 40.438282, 65.10924);
        ((GeneralPath) shape).curveTo(41.237274, 65.76296, 42.07063, 66.42646, 42.938282, 66.98424);
        ((GeneralPath) shape).curveTo(42.946682, 66.98964, 43.06471, 67.07576, 43.157032, 67.14049);
        ((GeneralPath) shape).curveTo(42.28938, 67.698265, 41.456024, 68.36176, 40.657032, 69.01549);
        ((GeneralPath) shape).curveTo(39.75237, 69.75567, 39.14683, 70.241806, 38.375782, 71.10924);
        ((GeneralPath) shape).curveTo(36.27887, 73.46826, 36.694263, 75.3466, 39.407032, 76.70299);
        ((GeneralPath) shape).curveTo(39.641068, 76.82001, 39.785492, 77.245804, 40.032032, 77.32799);
        ((GeneralPath) shape).curveTo(40.81813, 77.59002, 45.39276, 77.018196, 45.657032, 77.54674);
        ((GeneralPath) shape).curveTo(46.223442, 78.67956, 44.952778, 81.7845, 44.625782, 82.76549);
        ((GeneralPath) shape).curveTo(44.36346, 83.55245, 43.291523, 88.385475, 43.782032, 89.20299);
        ((GeneralPath) shape).curveTo(44.091576, 89.718895, 46.318813, 90.90993, 46.907032, 91.07799);
        ((GeneralPath) shape).curveTo(47.02377, 91.111336, 47.13025, 91.134186, 47.250782, 91.14049);
        ((GeneralPath) shape).curveTo(47.61238, 91.15925, 48.011555, 91.07799, 48.375782, 91.07799);
        ((GeneralPath) shape).curveTo(48.92628, 91.07799, 49.687508, 91.21099, 50.219532, 91.07799);
        ((GeneralPath) shape).curveTo(53.542244, 90.24731, 58.220936, 85.76991, 60.219532, 83.17174);
        ((GeneralPath) shape).curveTo(60.934242, 82.242615, 63.451977, 78.60538, 62.719532, 77.14049);
        ((GeneralPath) shape).curveTo(62.50649, 76.7144, 62.354935, 77.09534, 62.094532, 76.92174);
        ((GeneralPath) shape).curveTo(61.93126, 76.81289, 61.85155, 76.62434, 61.688282, 76.51549);
        ((GeneralPath) shape).curveTo(61.19082, 76.183846, 60.625782, 76.70833, 60.625782, 75.89049);
        ((GeneralPath) shape).curveTo(60.625782, 75.75173, 60.52767, 75.551094, 60.625782, 75.45299);
        ((GeneralPath) shape).curveTo(60.63689, 75.44188, 63.133064, 75.195, 63.344532, 75.26549);
        ((GeneralPath) shape).curveTo(63.53069, 75.32754, 63.57527, 75.58398, 63.750782, 75.67174);
        ((GeneralPath) shape).curveTo(63.90936, 75.75103, 64.13993, 75.598045, 64.18828, 75.45299);
        ((GeneralPath) shape).curveTo(64.41218, 74.781296, 64.30156, 71.902214, 64.18828, 71.10924);
        ((GeneralPath) shape).curveTo(64.09428, 70.45124, 63.775757, 69.65293, 63.56328, 69.01549);
        ((GeneralPath) shape).curveTo(63.376507, 68.45517, 63.440308, 67.657486, 63.50078, 66.92174);
        ((GeneralPath) shape).lineTo(63.25078, 66.92174);
        ((GeneralPath) shape).curveTo(63.20065, 66.268776, 63.181168, 65.599304, 63.34453, 65.10924);
        ((GeneralPath) shape).curveTo(63.557007, 64.471794, 63.875526, 63.673485, 63.96953, 63.015488);
        ((GeneralPath) shape).curveTo(64.08281, 62.22251, 64.19343, 59.34343, 63.96953, 58.671738);
        ((GeneralPath) shape).curveTo(63.921177, 58.526676, 63.690605, 58.3737, 63.53203, 58.452988);
        ((GeneralPath) shape).curveTo(63.356518, 58.54075, 63.311935, 58.797188, 63.12578, 58.859238);
        ((GeneralPath) shape).curveTo(62.91431, 58.92973, 60.418137, 58.682846, 60.40703, 58.671738);
        ((GeneralPath) shape).curveTo(60.308918, 58.573627, 60.40703, 58.37299, 60.40703, 58.234238);
        ((GeneralPath) shape).curveTo(60.40703, 57.4164, 60.972065, 57.94088, 61.46953, 57.609238);
        ((GeneralPath) shape).curveTo(61.632797, 57.50039, 61.712505, 57.311836, 61.87578, 57.202988);
        ((GeneralPath) shape).curveTo(62.13618, 57.02939, 62.287735, 57.410324, 62.50078, 56.984238);
        ((GeneralPath) shape).curveTo(63.233223, 55.519352, 60.71549, 51.88211, 60.00078, 50.952988);
        ((GeneralPath) shape).curveTo(58.002182, 48.354813, 53.323486, 43.877415, 50.00078, 43.046738);
        ((GeneralPath) shape).curveTo(49.468754, 42.91373, 48.707527, 43.046738, 48.15703, 43.046738);
        ((GeneralPath) shape).curveTo(47.7928, 43.046738, 47.393627, 42.965477, 47.03203, 42.984238);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x895D85));
        g.fill(shape);

        // _0_7_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(47.190765, 48.610233);
        ((GeneralPath) shape).curveTo(50.827255, 55.345543, 42.249077, 59.38905, 41.946007, 63.784218);
        ((GeneralPath) shape).curveTo(46.886986, 66.969444, 44.94861, 71.00371, 40.306477, 72.10051);
        ((GeneralPath) shape).curveTo(41.156918, 78.598434, 51.59971, 71.89883, 48.006218, 80.65884);
        ((GeneralPath) shape).curveTo(42.208946, 90.73026, 56.789257, 87.16943, 60.114906, 82.24595);
        ((GeneralPath) shape).curveTo(64.40873, 78.312614, 58.117657, 75.49999, 63.698467, 74.13813);
        ((GeneralPath) shape).curveTo(61.926117, 66.74273, 62.0934, 59.405373, 57.65365, 52.4432);
        ((GeneralPath) shape).curveTo(55.63117, 48.13479, 51.024147, 47.654594, 47.36599, 46.784595);

        g.setPaint(new Color(0xAA66B7));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_7
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.6027528f, 0, 0, 0.5494841f, 16.249018f, 45.982445f));

        // _0_8
        g.setComposite(AlphaComposite.getInstance(3, 0.8f * origAlpha));

        // _0_8_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(5.1377196, 20.205397);
        ((GeneralPath) shape).lineTo(73.73864, 84.94898);
        ((GeneralPath) shape).lineTo(73.73864, 108.071686);
        ((GeneralPath) shape).lineTo(5.1377196, 37.16205);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);
        g.setStroke(new BasicStroke(0.9837678f, 0, 0, 4));
        g.draw(shape);

        // _0_8_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(4.2407675, 6.333107);
        ((GeneralPath) shape).lineTo(73.739456, 72.62499);
        ((GeneralPath) shape).lineTo(73.739456, 61.05921);
        ((GeneralPath) shape).lineTo(17.190214, 4.791877);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_8_2
        shape = new Rectangle2D.Double(29.84966278076172, 179.7340087890625, 1.5811914205551147, 15.76681900024414);
        g.setPaint(BLACK);
        g.fill(shape);
        g.setStroke(new BasicStroke(0.11233405f, 1, 1, 4));
        g.draw(shape);

        // _0_8_3
        shape = new Rectangle2D.Double(25.346527099609375, 179.7477264404297, 3.447089433670044, 15.73938274383545);
        g.fill(shape);
        g.setStroke(new BasicStroke(0.16571708f, 1, 1, 4));
        g.draw(shape);

        // _0_8_4
        shape = new Rectangle2D.Double(14.389704704284668, 179.7477264404297, 3.447089433670044, 15.73938274383545);
        g.fill(shape);
        g.draw(shape);

        // _0_8_5
        shape = new Rectangle2D.Double(9.834613800048828, 179.7477264404297, 3.447089433670044, 15.73938274383545);
        g.fill(shape);
        g.draw(shape);

        // _0_8_6
        shape = new Rectangle2D.Double(42.776248931884766, 179.7340087890625, 1.5811914205551147, 15.76681900024414);
        g.fill(shape);
        g.setStroke(new BasicStroke(0.11233405f, 1, 1, 4));
        g.draw(shape);

        // _0_8_7
        shape = new Rectangle2D.Double(52.00952911376953, 179.7340087890625, 1.5811914205551147, 15.76681900024414);
        g.fill(shape);
        g.draw(shape);

        // _0_8_8
        shape = new Rectangle2D.Double(47.50639343261719, 179.7477264404297, 3.447089433670044, 15.73938274383545);
        g.fill(shape);
        g.setStroke(new BasicStroke(0.16571708f, 1, 1, 4));
        g.draw(shape);

        // _0_8_9
        shape = new Rectangle2D.Double(36.54956817626953, 179.7477264404297, 3.447089433670044, 15.73938274383545);
        g.fill(shape);
        g.draw(shape);

        // _0_8_10
        shape = new Rectangle2D.Double(31.99448013305664, 179.7477264404297, 3.447089433670044, 15.73938274383545);
        g.fill(shape);
        g.draw(shape);

        // _0_8_11
        shape = new Rectangle2D.Double(64.93611145019531, 179.7340087890625, 1.5811914205551147, 15.76681900024414);
        g.fill(shape);
        g.setStroke(new BasicStroke(0.11233405f, 1, 1, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_8

    }

    /**
     * Returns the X of the bounding box of the original SVG image.
     *
     * @return The X of the bounding box of the original SVG image.
     */
    public static int getOrigX() {
        return -5;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     *
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return -17;
    }

    /**
     * Returns the width of the bounding box of the original SVG image.
     *
     * @return The width of the bounding box of the original SVG image.
     */
    public static int getOrigWidth() {
        return 89;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     *
     * @return The height of the bounding box of the original SVG image.
     */
    public static int getOrigHeight() {
        return 246;
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
    public SlidepreviewNoLoupe6() {
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

