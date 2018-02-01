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
import java.awt.geom.Rectangle2D;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static java.awt.MultipleGradientPaint.ColorSpaceType.SRGB;
import static java.awt.MultipleGradientPaint.CycleMethod.NO_CYCLE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class Slidepreview3 implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.transform(new AffineTransform(0, 1, -1, 0, 227.36919f, 5.543334f));

        // _0_0
        g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.7385876f, 0, 0, 1.109502f, -6.9184694f, -8.622529f));

        // _0_0_0
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

        g.setTransform(transformations.poll()); // _0_0_0
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(3.0941164, 3.9813657);
        ((GeneralPath) shape).lineTo(3.0941164, 46.4382);
        ((GeneralPath) shape).lineTo(3.0941164, 162.48691);
        ((GeneralPath) shape).lineTo(3.0941164, 204.94376);
        ((GeneralPath) shape).lineTo(73.99853, 204.94376);
        ((GeneralPath) shape).lineTo(73.99853, 113.2193);
        ((GeneralPath) shape).lineTo(73.99853, 95.70585);
        ((GeneralPath) shape).lineTo(73.99853, 3.9813843);
        ((GeneralPath) shape).lineTo(3.0941162, 3.9813843);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(15.5, 98.5642318725586), new Point2D.Double(112.5, 98.5642318725586), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(0.7385876f, 0, 0, 1.109502f, -8.723287f, -4.894649f)));
        g.setStroke(new BasicStroke(0.9052427f, 0, 0, 4));
        g.draw(shape);

        // _0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(4.679559, 2.9740276);
        ((GeneralPath) shape).lineTo(4.679559, 45.828674);
        ((GeneralPath) shape).lineTo(4.679559, 162.96472);
        ((GeneralPath) shape).lineTo(4.679559, 205.81937);
        ((GeneralPath) shape).lineTo(76.24832, 205.81937);
        ((GeneralPath) shape).lineTo(76.24832, 113.23549);
        ((GeneralPath) shape).lineTo(76.24832, 95.55793);
        ((GeneralPath) shape).lineTo(76.24832, 2.9740448);
        ((GeneralPath) shape).lineTo(4.679558, 2.9740448);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(103.09768676757812, 56.26235580444336), 48.9f, new Point2D.Double(103.09768676757812, 56.26235580444336), new float[]{0, 1}, new Color[]{new Color(0xD2F2FF), new Color(0xC9F3F3F3, true)}, NO_CYCLE, SRGB, new AffineTransform(-0.90764457f, 2.4064069f, -1.2132167f, -1.0326121f, 231.67377f, -179.32922f)));
        g.fill(shape);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(18.182392120361328, 147.37173461914062), 48.5f, new Point2D.Double(18.182392120361328, 147.37173461914062), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(1.3981372f, -0.01410613f, 0.00940114f, 2.102687f, -20.272675f, -107.73248f)));
        g.setStroke(new BasicStroke(1.6447041f, 0, 0, 4));
        g.draw(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.82008857f, 0, 0, 0.83749324f, -6.8375525f, 13.08678f));

        // _0_0_3

        // _0_0_3_0
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

        // _0_0_3_1
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

        g.setTransform(transformations.poll()); // _0_0_3
        g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));

        // _0_0_4
        shape = new Rectangle2D.Double(7.06886100769043, 143.22177124023438, 65.65021514892578, 56.59598922729492);
        g.setPaint(WHITE);
        g.fill(shape);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(57.019283294677734, 132.4290313720703), new Point2D.Double(55.3865852355957, 189.85377502441406), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(0.7385876f, 0, 0, 1.109502f, -6.91847f, -8.622529f)));
        g.setStroke(new BasicStroke(0.18104854f, 1, 1, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.6121794f, 0, 0, 0.4258544f, 330.90637f, 174.66783f));

        // _0_0_5
        g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));

        // _0_0_5_0
        shape = new Rectangle2D.Double(-186.7389678955078, 11.896512985229492, 0.9807788133621216, 37.023963928222656);
        g.setPaint(BLACK);
        g.fill(shape);
        g.setStroke(new BasicStroke(0.1355733f, 1, 1, 4));
        g.draw(shape);

        // _0_0_5_1
        shape = new Rectangle2D.Double(-189.53216552734375, 11.928726196289062, 2.138154983520508, 36.959537506103516);
        g.fill(shape);
        g.setStroke(new BasicStroke(0.2f, 1, 1, 4));
        g.draw(shape);

        // _0_0_5_2
        shape = new Rectangle2D.Double(-196.3284454345703, 11.928726196289062, 2.138154983520508, 36.959537506103516);
        g.fill(shape);
        g.draw(shape);

        // _0_0_5_3
        shape = new Rectangle2D.Double(-199.15386962890625, 11.928726196289062, 2.138154983520508, 36.959537506103516);
        g.fill(shape);
        g.draw(shape);

        // _0_0_5_4
        shape = new Rectangle2D.Double(-178.72088623046875, 11.896512985229492, 0.9807788133621216, 37.023963928222656);
        g.fill(shape);
        g.setStroke(new BasicStroke(0.1355733f, 1, 1, 4));
        g.draw(shape);

        // _0_0_5_5
        shape = new Rectangle2D.Double(-172.99368286132812, 11.896512985229492, 0.9807788133621216, 37.023963928222656);
        g.fill(shape);
        g.draw(shape);

        // _0_0_5_6
        shape = new Rectangle2D.Double(-175.78688049316406, 11.928726196289062, 2.138154983520508, 36.959537506103516);
        g.fill(shape);
        g.setStroke(new BasicStroke(0.2f, 1, 1, 4));
        g.draw(shape);

        // _0_0_5_7
        shape = new Rectangle2D.Double(-182.58316040039062, 11.928726196289062, 2.138154983520508, 36.959537506103516);
        g.fill(shape);
        g.draw(shape);

        // _0_0_5_8
        shape = new Rectangle2D.Double(-185.40858459472656, 11.928726196289062, 2.138154983520508, 36.959537506103516);
        g.fill(shape);
        g.draw(shape);

        // _0_0_5_9
        shape = new Rectangle2D.Double(-164.97560119628906, 11.896512985229492, 0.9807788133621216, 37.023963928222656);
        g.fill(shape);
        g.setStroke(new BasicStroke(0.1355733f, 1, 1, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_5
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-1, 0, 0, 1, 0, 0));

        // _0_0_6
        shape = new Rectangle2D.Double(-71.12432098388672, 179.7340087890625, 1.5811914205551147, 15.76681900024414);
        g.fill(shape);
        g.setStroke(new BasicStroke(0.11233405f, 1, 1, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_6
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-1, 0, 0, 1, 0, 0));

        // _0_0_7
        shape = new Rectangle2D.Double(-58.19773483276367, 179.7340087890625, 1.5811914205551147, 15.76681900024414);
        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_7
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.8931165f, 0, 0, 1.1196748f, 0, 0));

        // _0_0_8
        //  ELB0090-0009 
        shape = new GeneralPath();

        g.fill(shape);
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(44.638485, 147.2701);
        ((GeneralPath) shape).lineTo(44.638485, 140.03564);
        ((GeneralPath) shape).lineTo(49.869396, 140.03564);
        ((GeneralPath) shape).lineTo(49.869396, 140.88773);
        ((GeneralPath) shape).lineTo(45.59584, 140.88773);
        ((GeneralPath) shape).lineTo(45.59584, 143.1051);
        ((GeneralPath) shape).lineTo(49.599625, 143.1051);
        ((GeneralPath) shape).lineTo(49.599625, 143.9539);
        ((GeneralPath) shape).lineTo(45.59584, 143.9539);
        ((GeneralPath) shape).lineTo(45.59584, 146.41473);
        ((GeneralPath) shape).lineTo(50.037178, 146.41473);
        ((GeneralPath) shape).lineTo(50.037178, 147.2701);
        ((GeneralPath) shape).lineTo(44.638485, 147.2701);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(51.320232, 147.2701);
        ((GeneralPath) shape).lineTo(51.320232, 140.03564);
        ((GeneralPath) shape).lineTo(52.277588, 140.03564);
        ((GeneralPath) shape).lineTo(52.277588, 146.41473);
        ((GeneralPath) shape).lineTo(55.84053, 146.41473);
        ((GeneralPath) shape).lineTo(55.84053, 147.2701);
        ((GeneralPath) shape).lineTo(51.320232, 147.2701);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(56.94099, 147.2701);
        ((GeneralPath) shape).lineTo(56.94099, 140.03564);
        ((GeneralPath) shape).lineTo(59.655144, 140.03564);
        ((GeneralPath) shape).quadTo(60.48419, 140.03564, 60.9859, 140.25443);
        ((GeneralPath) shape).quadTo(61.487606, 140.4732, 61.770535, 140.9305);
        ((GeneralPath) shape).quadTo(62.053467, 141.38779, 62.053467, 141.88457);
        ((GeneralPath) shape).quadTo(62.053467, 142.34843, 61.80179, 142.75803);
        ((GeneralPath) shape).quadTo(61.550114, 143.16762, 61.043472, 143.42093);
        ((GeneralPath) shape).quadTo(61.69816, 143.61176, 62.05182, 144.07562);
        ((GeneralPath) shape).quadTo(62.405483, 144.53949, 62.405483, 145.17116);
        ((GeneralPath) shape).quadTo(62.405483, 145.68108, 62.189995, 146.11699);
        ((GeneralPath) shape).quadTo(61.97451, 146.5529, 61.65868, 146.78978);
        ((GeneralPath) shape).quadTo(61.34285, 147.02664, 60.867462, 147.14838);
        ((GeneralPath) shape).quadTo(60.392075, 147.2701, 59.701202, 147.2701);
        ((GeneralPath) shape).lineTo(56.94099, 147.2701);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(57.898346, 143.0755);
        ((GeneralPath) shape).lineTo(59.46433, 143.0755);
        ((GeneralPath) shape).quadTo(60.099277, 143.0755, 60.375626, 142.98996);
        ((GeneralPath) shape).quadTo(60.740803, 142.8814, 60.92668, 142.62971);
        ((GeneralPath) shape).quadTo(61.11256, 142.37804, 61.11256, 141.99971);
        ((GeneralPath) shape).quadTo(61.11256, 141.63782, 60.939842, 141.36476);
        ((GeneralPath) shape).quadTo(60.76712, 141.0917, 60.446358, 140.98972);
        ((GeneralPath) shape).quadTo(60.125595, 140.88773, 59.345894, 140.88773);
        ((GeneralPath) shape).lineTo(57.898346, 140.88773);
        ((GeneralPath) shape).lineTo(57.898346, 143.0755);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(57.898346, 146.41473);
        ((GeneralPath) shape).lineTo(59.701202, 146.41473);
        ((GeneralPath) shape).quadTo(60.165073, 146.41473, 60.352596, 146.38182);
        ((GeneralPath) shape).quadTo(60.681587, 146.32262, 60.903652, 146.18443);
        ((GeneralPath) shape).quadTo(61.12572, 146.04626, 61.26883, 145.78142);
        ((GeneralPath) shape).quadTo(61.411938, 145.51659, 61.411938, 145.17116);
        ((GeneralPath) shape).quadTo(61.411938, 144.7665, 61.204678, 144.46877);
        ((GeneralPath) shape).quadTo(60.997414, 144.17102, 60.630592, 144.0493);
        ((GeneralPath) shape).quadTo(60.26377, 143.92758, 59.572895, 143.92758);
        ((GeneralPath) shape).lineTo(57.898346, 143.92758);
        ((GeneralPath) shape).lineTo(57.898346, 146.41473);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(63.36284, 143.70058);
        ((GeneralPath) shape).quadTo(63.36284, 142.41753, 63.62603, 141.63617);
        ((GeneralPath) shape).quadTo(63.88922, 140.85483, 64.41067, 140.43044);
        ((GeneralPath) shape).quadTo(64.93211, 140.00604, 65.72169, 140.00604);
        ((GeneralPath) shape).quadTo(66.30399, 140.00604, 66.743195, 140.23962);
        ((GeneralPath) shape).quadTo(67.18239, 140.4732, 67.46861, 140.9157);
        ((GeneralPath) shape).quadTo(67.75483, 141.35818, 67.91768, 141.99149);
        ((GeneralPath) shape).quadTo(68.08053, 142.62479, 68.08053, 143.70058);
        ((GeneralPath) shape).quadTo(68.08053, 144.97375, 67.818985, 145.75674);
        ((GeneralPath) shape).quadTo(67.557434, 146.53975, 67.03599, 146.96742);
        ((GeneralPath) shape).quadTo(66.51454, 147.39511, 65.72169, 147.39511);
        ((GeneralPath) shape).quadTo(64.6755, 147.39511, 64.076744, 146.64172);
        ((GeneralPath) shape).quadTo(63.36284, 145.7403, 63.36284, 143.70058);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(64.27414, 143.70058);
        ((GeneralPath) shape).quadTo(64.27414, 145.48369, 64.69195, 146.07259);
        ((GeneralPath) shape).quadTo(65.109764, 146.66147, 65.72169, 146.66147);
        ((GeneralPath) shape).quadTo(66.3336, 146.66147, 66.74977, 146.06929);
        ((GeneralPath) shape).quadTo(67.16594, 145.47711, 67.16594, 143.70058);
        ((GeneralPath) shape).quadTo(67.16594, 141.91417, 66.74977, 141.32692);
        ((GeneralPath) shape).quadTo(66.3336, 140.73969, 65.711815, 140.73969);
        ((GeneralPath) shape).quadTo(65.0999, 140.73969, 64.73472, 141.25949);
        ((GeneralPath) shape).quadTo(64.27414, 141.92075, 64.27414, 143.70058);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(68.983604, 143.70058);
        ((GeneralPath) shape).quadTo(68.983604, 142.41753, 69.246796, 141.63617);
        ((GeneralPath) shape).quadTo(69.50999, 140.85483, 70.03143, 140.43044);
        ((GeneralPath) shape).quadTo(70.55288, 140.00604, 71.34245, 140.00604);
        ((GeneralPath) shape).quadTo(71.92476, 140.00604, 72.36396, 140.23962);
        ((GeneralPath) shape).quadTo(72.803154, 140.4732, 73.08938, 140.9157);
        ((GeneralPath) shape).quadTo(73.375595, 141.35818, 73.538445, 141.99149);
        ((GeneralPath) shape).quadTo(73.701294, 142.62479, 73.701294, 143.70058);
        ((GeneralPath) shape).quadTo(73.701294, 144.97375, 73.43975, 145.75674);
        ((GeneralPath) shape).quadTo(73.1782, 146.53975, 72.65675, 146.96742);
        ((GeneralPath) shape).quadTo(72.13531, 147.39511, 71.34245, 147.39511);
        ((GeneralPath) shape).quadTo(70.296265, 147.39511, 69.69751, 146.64172);
        ((GeneralPath) shape).quadTo(68.983604, 145.7403, 68.983604, 143.70058);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(69.894905, 143.70058);
        ((GeneralPath) shape).quadTo(69.894905, 145.48369, 70.31271, 146.07259);
        ((GeneralPath) shape).quadTo(70.73053, 146.66147, 71.34245, 146.66147);
        ((GeneralPath) shape).quadTo(71.95437, 146.66147, 72.37054, 146.06929);
        ((GeneralPath) shape).quadTo(72.786705, 145.47711, 72.786705, 143.70058);
        ((GeneralPath) shape).quadTo(72.786705, 141.91417, 72.37054, 141.32692);
        ((GeneralPath) shape).quadTo(71.95437, 140.73969, 71.33258, 140.73969);
        ((GeneralPath) shape).quadTo(70.720665, 140.73969, 70.355484, 141.25949);
        ((GeneralPath) shape).quadTo(69.894905, 141.92075, 69.894905, 143.70058);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(74.735954, 145.59555);
        ((GeneralPath) shape).lineTo(75.591324, 145.51659);
        ((GeneralPath) shape).quadTo(75.69989, 146.11864, 76.00585, 146.39005);
        ((GeneralPath) shape).quadTo(76.31181, 146.66147, 76.78884, 146.66147);
        ((GeneralPath) shape).quadTo(77.20008, 146.66147, 77.50768, 146.47394);
        ((GeneralPath) shape).quadTo(77.815285, 146.28642, 78.01268, 145.97388);
        ((GeneralPath) shape).quadTo(78.210075, 145.66135, 78.343315, 145.12839);
        ((GeneralPath) shape).quadTo(78.476555, 144.59543, 78.476555, 144.04272);
        ((GeneralPath) shape).quadTo(78.476555, 143.9835, 78.47327, 143.86507);
        ((GeneralPath) shape).quadTo(78.20678, 144.28946, 77.74455, 144.55266);
        ((GeneralPath) shape).quadTo(77.282326, 144.81584, 76.74608, 144.81584);
        ((GeneralPath) shape).quadTo(75.84794, 144.81584, 75.22615, 144.16444);
        ((GeneralPath) shape).quadTo(74.60436, 143.51305, 74.60436, 142.44713);
        ((GeneralPath) shape).quadTo(74.60436, 141.34831, 75.25247, 140.67717);
        ((GeneralPath) shape).quadTo(75.90057, 140.00604, 76.87767, 140.00604);
        ((GeneralPath) shape).quadTo(77.58499, 140.00604, 78.168945, 140.38602);
        ((GeneralPath) shape).quadTo(78.7529, 140.766, 79.05722, 141.46838);
        ((GeneralPath) shape).quadTo(79.361534, 142.17078, 79.361534, 143.50319);
        ((GeneralPath) shape).quadTo(79.361534, 144.89151, 79.06051, 145.71234);
        ((GeneralPath) shape).quadTo(78.75948, 146.53316, 78.16402, 146.96414);
        ((GeneralPath) shape).quadTo(77.56854, 147.39511, 76.769104, 147.39511);
        ((GeneralPath) shape).quadTo(75.92032, 147.39511, 75.38242, 146.92302);
        ((GeneralPath) shape).quadTo(74.84452, 146.45091, 74.735954, 145.59555);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(78.374565, 142.40436);
        ((GeneralPath) shape).quadTo(78.374565, 141.63782, 77.96662, 141.18875);
        ((GeneralPath) shape).quadTo(77.55868, 140.73969, 76.98624, 140.73969);
        ((GeneralPath) shape).quadTo(76.39406, 140.73969, 75.95486, 141.2233);
        ((GeneralPath) shape).quadTo(75.51566, 141.70691, 75.51566, 142.47675);
        ((GeneralPath) shape).quadTo(75.51566, 143.16762, 75.93347, 143.60023);
        ((GeneralPath) shape).quadTo(76.35129, 144.03285, 76.96321, 144.03285);
        ((GeneralPath) shape).quadTo(77.578415, 144.03285, 77.976494, 143.60023);
        ((GeneralPath) shape).quadTo(78.374565, 143.16762, 78.374565, 142.40436);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(80.22512, 143.70058);
        ((GeneralPath) shape).quadTo(80.22512, 142.41753, 80.48831, 141.63617);
        ((GeneralPath) shape).quadTo(80.7515, 140.85483, 81.27295, 140.43044);
        ((GeneralPath) shape).quadTo(81.794395, 140.00604, 82.58397, 140.00604);
        ((GeneralPath) shape).quadTo(83.166275, 140.00604, 83.60548, 140.23962);
        ((GeneralPath) shape).quadTo(84.04467, 140.4732, 84.330894, 140.9157);
        ((GeneralPath) shape).quadTo(84.61711, 141.35818, 84.77996, 141.99149);
        ((GeneralPath) shape).quadTo(84.94281, 142.62479, 84.94281, 143.70058);
        ((GeneralPath) shape).quadTo(84.94281, 144.97375, 84.68127, 145.75674);
        ((GeneralPath) shape).quadTo(84.419716, 146.53975, 83.89827, 146.96742);
        ((GeneralPath) shape).quadTo(83.37682, 147.39511, 82.58397, 147.39511);
        ((GeneralPath) shape).quadTo(81.53778, 147.39511, 80.939026, 146.64172);
        ((GeneralPath) shape).quadTo(80.22512, 145.7403, 80.22512, 143.70058);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(81.13642, 143.70058);
        ((GeneralPath) shape).quadTo(81.13642, 145.48369, 81.55423, 146.07259);
        ((GeneralPath) shape).quadTo(81.972046, 146.66147, 82.58397, 146.66147);
        ((GeneralPath) shape).quadTo(83.195885, 146.66147, 83.61205, 146.06929);
        ((GeneralPath) shape).quadTo(84.02822, 145.47711, 84.02822, 143.70058);
        ((GeneralPath) shape).quadTo(84.02822, 141.91417, 83.61205, 141.32692);
        ((GeneralPath) shape).quadTo(83.195885, 140.73969, 82.5741, 140.73969);
        ((GeneralPath) shape).quadTo(81.96218, 140.73969, 81.597, 141.25949);
        ((GeneralPath) shape).quadTo(81.13642, 141.92075, 81.13642, 143.70058);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(85.74719, 145.09877);
        ((GeneralPath) shape).lineTo(85.74719, 144.20393);
        ((GeneralPath) shape).lineTo(88.4745, 144.20393);
        ((GeneralPath) shape).lineTo(88.4745, 145.09877);
        ((GeneralPath) shape).lineTo(85.74719, 145.09877);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(89.21143, 143.70058);
        ((GeneralPath) shape).quadTo(89.21143, 142.41753, 89.474625, 141.63617);
        ((GeneralPath) shape).quadTo(89.737816, 140.85483, 90.25926, 140.43044);
        ((GeneralPath) shape).quadTo(90.78071, 140.00604, 91.57028, 140.00604);
        ((GeneralPath) shape).quadTo(92.15259, 140.00604, 92.59179, 140.23962);
        ((GeneralPath) shape).quadTo(93.03098, 140.4732, 93.31721, 140.9157);
        ((GeneralPath) shape).quadTo(93.603424, 141.35818, 93.76627, 141.99149);
        ((GeneralPath) shape).quadTo(93.92912, 142.62479, 93.92912, 143.70058);
        ((GeneralPath) shape).quadTo(93.92912, 144.97375, 93.66758, 145.75674);
        ((GeneralPath) shape).quadTo(93.40603, 146.53975, 92.88458, 146.96742);
        ((GeneralPath) shape).quadTo(92.36314, 147.39511, 91.57028, 147.39511);
        ((GeneralPath) shape).quadTo(90.52409, 147.39511, 89.92534, 146.64172);
        ((GeneralPath) shape).quadTo(89.21143, 145.7403, 89.21143, 143.70058);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(90.122734, 143.70058);
        ((GeneralPath) shape).quadTo(90.122734, 145.48369, 90.54054, 146.07259);
        ((GeneralPath) shape).quadTo(90.95836, 146.66147, 91.57028, 146.66147);
        ((GeneralPath) shape).quadTo(92.1822, 146.66147, 92.598366, 146.06929);
        ((GeneralPath) shape).quadTo(93.014534, 145.47711, 93.014534, 143.70058);
        ((GeneralPath) shape).quadTo(93.014534, 141.91417, 92.598366, 141.32692);
        ((GeneralPath) shape).quadTo(92.1822, 140.73969, 91.56041, 140.73969);
        ((GeneralPath) shape).quadTo(90.948494, 140.73969, 90.58331, 141.25949);
        ((GeneralPath) shape).quadTo(90.122734, 141.92075, 90.122734, 143.70058);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(94.83219, 143.70058);
        ((GeneralPath) shape).quadTo(94.83219, 142.41753, 95.09538, 141.63617);
        ((GeneralPath) shape).quadTo(95.358574, 140.85483, 95.88002, 140.43044);
        ((GeneralPath) shape).quadTo(96.40147, 140.00604, 97.19104, 140.00604);
        ((GeneralPath) shape).quadTo(97.773346, 140.00604, 98.21255, 140.23962);
        ((GeneralPath) shape).quadTo(98.65174, 140.4732, 98.937965, 140.9157);
        ((GeneralPath) shape).quadTo(99.22418, 141.35818, 99.38703, 141.99149);
        ((GeneralPath) shape).quadTo(99.54988, 142.62479, 99.54988, 143.70058);
        ((GeneralPath) shape).quadTo(99.54988, 144.97375, 99.28834, 145.75674);
        ((GeneralPath) shape).quadTo(99.02679, 146.53975, 98.50534, 146.96742);
        ((GeneralPath) shape).quadTo(97.983894, 147.39511, 97.19104, 147.39511);
        ((GeneralPath) shape).quadTo(96.14485, 147.39511, 95.5461, 146.64172);
        ((GeneralPath) shape).quadTo(94.83219, 145.7403, 94.83219, 143.70058);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(95.74349, 143.70058);
        ((GeneralPath) shape).quadTo(95.74349, 145.48369, 96.1613, 146.07259);
        ((GeneralPath) shape).quadTo(96.57912, 146.66147, 97.19104, 146.66147);
        ((GeneralPath) shape).quadTo(97.802956, 146.66147, 98.219124, 146.06929);
        ((GeneralPath) shape).quadTo(98.63529, 145.47711, 98.63529, 143.70058);
        ((GeneralPath) shape).quadTo(98.63529, 141.91417, 98.219124, 141.32692);
        ((GeneralPath) shape).quadTo(97.802956, 140.73969, 97.18117, 140.73969);
        ((GeneralPath) shape).quadTo(96.56925, 140.73969, 96.20407, 141.25949);
        ((GeneralPath) shape).quadTo(95.74349, 141.92075, 95.74349, 143.70058);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(100.45296, 143.70058);
        ((GeneralPath) shape).quadTo(100.45296, 142.41753, 100.71615, 141.63617);
        ((GeneralPath) shape).quadTo(100.97934, 140.85483, 101.500786, 140.43044);
        ((GeneralPath) shape).quadTo(102.02223, 140.00604, 102.811806, 140.00604);
        ((GeneralPath) shape).quadTo(103.39411, 140.00604, 103.83331, 140.23962);
        ((GeneralPath) shape).quadTo(104.27251, 140.4732, 104.55873, 140.9157);
        ((GeneralPath) shape).quadTo(104.84495, 141.35818, 105.0078, 141.99149);
        ((GeneralPath) shape).quadTo(105.17065, 142.62479, 105.17065, 143.70058);
        ((GeneralPath) shape).quadTo(105.17065, 144.97375, 104.9091, 145.75674);
        ((GeneralPath) shape).quadTo(104.64755, 146.53975, 104.12611, 146.96742);
        ((GeneralPath) shape).quadTo(103.60466, 147.39511, 102.811806, 147.39511);
        ((GeneralPath) shape).quadTo(101.76562, 147.39511, 101.16686, 146.64172);
        ((GeneralPath) shape).quadTo(100.45296, 145.7403, 100.45296, 143.70058);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(101.36426, 143.70058);
        ((GeneralPath) shape).quadTo(101.36426, 145.48369, 101.78207, 146.07259);
        ((GeneralPath) shape).quadTo(102.19988, 146.66147, 102.811806, 146.66147);
        ((GeneralPath) shape).quadTo(103.42372, 146.66147, 103.83989, 146.06929);
        ((GeneralPath) shape).quadTo(104.25606, 145.47711, 104.25606, 143.70058);
        ((GeneralPath) shape).quadTo(104.25606, 141.91417, 103.83989, 141.32692);
        ((GeneralPath) shape).quadTo(103.42372, 140.73969, 102.80193, 140.73969);
        ((GeneralPath) shape).quadTo(102.19002, 140.73969, 101.82484, 141.25949);
        ((GeneralPath) shape).quadTo(101.36426, 141.92075, 101.36426, 143.70058);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(106.205315, 145.59555);
        ((GeneralPath) shape).lineTo(107.060684, 145.51659);
        ((GeneralPath) shape).quadTo(107.16925, 146.11864, 107.47521, 146.39005);
        ((GeneralPath) shape).quadTo(107.78117, 146.66147, 108.2582, 146.66147);
        ((GeneralPath) shape).quadTo(108.66944, 146.66147, 108.97704, 146.47394);
        ((GeneralPath) shape).quadTo(109.284645, 146.28642, 109.48204, 145.97388);
        ((GeneralPath) shape).quadTo(109.679436, 145.66135, 109.812675, 145.12839);
        ((GeneralPath) shape).quadTo(109.945915, 144.59543, 109.945915, 144.04272);
        ((GeneralPath) shape).quadTo(109.945915, 143.9835, 109.94263, 143.86507);
        ((GeneralPath) shape).quadTo(109.67614, 144.28946, 109.21391, 144.55266);
        ((GeneralPath) shape).quadTo(108.751686, 144.81584, 108.21544, 144.81584);
        ((GeneralPath) shape).quadTo(107.3173, 144.81584, 106.69551, 144.16444);
        ((GeneralPath) shape).quadTo(106.07372, 143.51305, 106.07372, 142.44713);
        ((GeneralPath) shape).quadTo(106.07372, 141.34831, 106.72183, 140.67717);
        ((GeneralPath) shape).quadTo(107.369934, 140.00604, 108.34703, 140.00604);
        ((GeneralPath) shape).quadTo(109.05435, 140.00604, 109.638306, 140.38602);
        ((GeneralPath) shape).quadTo(110.22226, 140.766, 110.52658, 141.46838);
        ((GeneralPath) shape).quadTo(110.830894, 142.17078, 110.830894, 143.50319);
        ((GeneralPath) shape).quadTo(110.830894, 144.89151, 110.52987, 145.71234);
        ((GeneralPath) shape).quadTo(110.22884, 146.53316, 109.63338, 146.96414);
        ((GeneralPath) shape).quadTo(109.0379, 147.39511, 108.238464, 147.39511);
        ((GeneralPath) shape).quadTo(107.38968, 147.39511, 106.85178, 146.92302);
        ((GeneralPath) shape).quadTo(106.31388, 146.45091, 106.205315, 145.59555);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(109.843925, 142.40436);
        ((GeneralPath) shape).quadTo(109.843925, 141.63782, 109.43598, 141.18875);
        ((GeneralPath) shape).quadTo(109.02804, 140.73969, 108.4556, 140.73969);
        ((GeneralPath) shape).quadTo(107.86342, 140.73969, 107.42422, 141.2233);
        ((GeneralPath) shape).quadTo(106.98502, 141.70691, 106.98502, 142.47675);
        ((GeneralPath) shape).quadTo(106.98502, 143.16762, 107.40283, 143.60023);
        ((GeneralPath) shape).quadTo(107.82065, 144.03285, 108.43257, 144.03285);
        ((GeneralPath) shape).quadTo(109.047775, 144.03285, 109.445854, 143.60023);
        ((GeneralPath) shape).quadTo(109.843925, 143.16762, 109.843925, 142.40436);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        shape = new GeneralPath();

        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_8
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.5473774f, 0, 0, 0.78110826f, 9.056873f, 67.797966f));

        // _0_0_9

        // _0_0_9_0
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

        // _0_0_9_1
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
        ((GeneralPath) shape).curveTo(39.9375, 123.37108, 31.292854, 120.93242, 37.65625, 116.6875);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xAA66B7));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_9_1

        g.setTransform(transformations.poll()); // _0_0_9
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.6027528f, 0, 0, 0.5494841f, 4.2490172f, -9.982443f));

        // _0_0_10

        // _0_0_10_0
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

        // _0_0_10_1
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

        g.setTransform(transformations.poll()); // _0_0_10
        g.setComposite(AlphaComposite.getInstance(3, 0.8f * origAlpha));

        // _0_0_11
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

        // _0_0_12
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(4.2407675, 6.333107);
        ((GeneralPath) shape).lineTo(73.739456, 72.62499);
        ((GeneralPath) shape).lineTo(73.739456, 61.05921);
        ((GeneralPath) shape).lineTo(17.190214, 4.791877);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

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
        return 246;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     *
     * @return The height of the bounding box of the original SVG image.
     */
    public static int getOrigHeight() {
        return 105;
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
    public Slidepreview3() {
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

