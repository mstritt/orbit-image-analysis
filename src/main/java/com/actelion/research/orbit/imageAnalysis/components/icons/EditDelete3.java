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
public class EditDelete3 implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.transform(new AffineTransform(0.02262383f, 0, 0, 0.01966248f, 44.39519f, 41.98146f));

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
        g.setComposite(AlphaComposite.getInstance(3, 0.38659793f * origAlpha));

        // _0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(4.75, 21.0);
        ((GeneralPath) shape).lineTo(43.25, 21.0);
        ((GeneralPath) shape).lineTo(42.375, 32.25);
        ((GeneralPath) shape).lineTo(5.625, 32.25);
        ((GeneralPath) shape).lineTo(4.75, 21.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(25, 21), new Point2D.Double(25, 32.25), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));

        // _0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(4.000805, 16.500029);
        ((GeneralPath) shape).curveTo(3.9568443, 16.464575, 5.72773, 42.00552, 5.7282343, 42.013264);
        ((GeneralPath) shape).curveTo(5.8943634, 44.56396, 7.288948, 45.496197, 8.84989, 45.499996);
        ((GeneralPath) shape).curveTo(8.905668, 45.500126, 38.133934, 45.49671, 38.756645, 45.494057);
        ((GeneralPath) shape).curveTo(41.38534, 45.482838, 42.029343, 43.85947, 42.202267, 42.085777);
        ((GeneralPath) shape).curveTo(42.216137, 42.050804, 43.986115, 16.535, 43.99998, 16.500029);
        ((GeneralPath) shape).curveTo(30.666924, 16.500029, 17.333866, 16.500029, 4.000805, 16.500029);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xBABDB6));
        g.fill(shape);
        g.setPaint(new Color(0x555753));
        g.setStroke(new BasicStroke(1, 0, 0, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.23711339f * origAlpha));

        // _0_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(43.457954, 20.71267);
        ((GeneralPath) shape).lineTo(7.2079372, 20.689264);
        ((GeneralPath) shape).curveTo(34.519245, 21.326591, 39.885143, 24.337412, 43.214188, 24.183575);
        ((GeneralPath) shape).lineTo(43.457954, 20.71267);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(7.373860836029053, 27.37662124633789), new Point2D.Double(7.529111862182617, 69.46050262451172), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(3.520411f, 0, 0, 0.348016f, -3.037918f, 1.544257f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.12886599f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 0.08838865f, 0.08838865f));

        // _0_0_4
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_4_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(29.163486, 19.614075);
        ((GeneralPath) shape).curveTo(29.163486, 19.614075, 30.279472, 23.33545, 29.517143, 26.348055);
        ((GeneralPath) shape).curveTo(28.754814, 29.360659, 29.269247, 34.210167, 29.269247, 34.210167);
        ((GeneralPath) shape).lineTo(30.884373, 34.634373);
        ((GeneralPath) shape).curveTo(30.884373, 34.634373, 30.117495, 30.028639, 30.931356, 26.524832);
        ((GeneralPath) shape).curveTo(31.745218, 23.021023, 30.577814, 19.614988, 30.577814, 19.614988);
        ((GeneralPath) shape).lineTo(29.163486, 19.614075);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);
        g.setStroke(new BasicStroke(1.3f, 0, 0, 4));
        g.draw(shape);

        // _0_0_4_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(9.912416, 19.75934);
        ((GeneralPath) shape).curveTo(9.912416, 19.75934, 11.028404, 23.480717, 10.266074, 26.49332);
        ((GeneralPath) shape).curveTo(9.503745, 29.505924, 10.018178, 34.355434, 10.018178, 34.355434);
        ((GeneralPath) shape).lineTo(11.456527, 33.80737);
        ((GeneralPath) shape).curveTo(11.456527, 33.80737, 10.866426, 30.173906, 11.680288, 26.670097);
        ((GeneralPath) shape).curveTo(12.49415, 23.16629, 11.326745, 19.760256, 11.326745, 19.760256);
        ((GeneralPath) shape).lineTo(9.912416, 19.75934);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        // _0_0_4_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(11.66716, 19.714073);
        ((GeneralPath) shape).curveTo(11.66716, 19.714073, 12.783146, 23.43545, 12.020817, 26.448053);
        ((GeneralPath) shape).curveTo(11.258488, 29.460657, 8.617841, 31.76449, 8.617841, 31.76449);
        ((GeneralPath) shape).lineTo(9.826038, 33.73022);
        ((GeneralPath) shape).curveTo(9.826038, 33.73022, 12.621168, 30.12864, 13.43503, 26.62483);
        ((GeneralPath) shape).curveTo(14.248892, 23.121023, 13.081487, 19.714989, 13.081487, 19.714989);
        ((GeneralPath) shape).lineTo(11.66716, 19.714073);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        // _0_0_4_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(21.163486, 19.614075);
        ((GeneralPath) shape).curveTo(21.163486, 19.614075, 22.279472, 23.33545, 21.517143, 26.348055);
        ((GeneralPath) shape).curveTo(20.754814, 29.360659, 21.269247, 34.210167, 21.269247, 34.210167);
        ((GeneralPath) shape).lineTo(22.928568, 34.766956);
        ((GeneralPath) shape).curveTo(22.928568, 34.766956, 22.117495, 30.028639, 22.931356, 26.524832);
        ((GeneralPath) shape).curveTo(23.745218, 23.021023, 22.577814, 19.614988, 22.577814, 19.614988);
        ((GeneralPath) shape).lineTo(21.163486, 19.614075);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        // _0_0_4_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(35.163486, 19.614075);
        ((GeneralPath) shape).curveTo(35.163486, 19.614075, 36.279472, 23.33545, 35.517143, 26.348055);
        ((GeneralPath) shape).curveTo(34.754814, 29.360659, 36.55088, 33.50306, 36.55088, 33.50306);
        ((GeneralPath) shape).lineTo(38.077614, 32.292084);
        ((GeneralPath) shape).curveTo(38.077614, 32.292084, 36.117496, 30.028639, 36.93136, 26.524832);
        ((GeneralPath) shape).curveTo(37.74522, 23.021023, 36.577812, 19.614988, 36.577812, 19.614988);
        ((GeneralPath) shape).lineTo(35.163486, 19.614075);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        // _0_0_4_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(31.163486, 19.614075);
        ((GeneralPath) shape).curveTo(31.163486, 19.614075, 32.279472, 23.33545, 31.517143, 26.348055);
        ((GeneralPath) shape).curveTo(30.754814, 29.360659, 31.269247, 34.210167, 31.269247, 34.210167);
        ((GeneralPath) shape).lineTo(32.795982, 34.148235);
        ((GeneralPath) shape).curveTo(32.795982, 34.148235, 32.117496, 30.028639, 32.93136, 26.524832);
        ((GeneralPath) shape).curveTo(33.74522, 23.021023, 32.577812, 19.614988, 32.577812, 19.614988);
        ((GeneralPath) shape).lineTo(31.163486, 19.614075);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        // _0_0_4_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(33.163486, 19.614075);
        ((GeneralPath) shape).curveTo(33.163486, 19.614075, 34.279472, 23.33545, 33.517143, 26.348055);
        ((GeneralPath) shape).curveTo(32.754814, 29.360659, 32.473755, 34.03339, 32.473755, 34.03339);
        ((GeneralPath) shape).lineTo(34.265656, 34.457596);
        ((GeneralPath) shape).curveTo(34.265656, 34.457596, 34.117496, 30.028639, 34.93136, 26.524832);
        ((GeneralPath) shape).curveTo(35.74522, 23.021023, 34.577812, 19.614988, 34.577812, 19.614988);
        ((GeneralPath) shape).lineTo(33.163486, 19.614075);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        // _0_0_4_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(27.163486, 19.614075);
        ((GeneralPath) shape).curveTo(27.163486, 19.614075, 28.279472, 23.33545, 27.517143, 26.348055);
        ((GeneralPath) shape).curveTo(26.754814, 29.360659, 28.064743, 33.989197, 28.064743, 33.989197);
        ((GeneralPath) shape).lineTo(29.724062, 33.308548);
        ((GeneralPath) shape).curveTo(29.724062, 33.308548, 28.117495, 30.028639, 28.931356, 26.524832);
        ((GeneralPath) shape).curveTo(29.745218, 23.021023, 28.577814, 19.614988, 28.577814, 19.614988);
        ((GeneralPath) shape).lineTo(27.163486, 19.614075);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        // _0_0_4_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(25.163486, 19.614075);
        ((GeneralPath) shape).curveTo(25.163486, 19.614075, 26.279472, 23.33545, 25.517143, 26.348055);
        ((GeneralPath) shape).curveTo(24.754814, 29.360659, 24.164394, 34.077583, 24.164394, 34.077583);
        ((GeneralPath) shape).lineTo(25.69113, 34.28082);
        ((GeneralPath) shape).curveTo(25.69113, 34.28082, 26.117495, 30.028639, 26.931356, 26.524832);
        ((GeneralPath) shape).curveTo(27.745218, 23.021023, 26.577814, 19.614988, 26.577814, 19.614988);
        ((GeneralPath) shape).lineTo(25.163486, 19.614075);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        // _0_0_4_9
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(23.163486, 19.614075);
        ((GeneralPath) shape).curveTo(23.163486, 19.614075, 24.279472, 23.33545, 23.517143, 26.348055);
        ((GeneralPath) shape).curveTo(22.754814, 29.360659, 23.269247, 34.210167, 23.269247, 34.210167);
        ((GeneralPath) shape).lineTo(24.707596, 33.6621);
        ((GeneralPath) shape).curveTo(24.707596, 33.6621, 24.117495, 30.028639, 24.931356, 26.524832);
        ((GeneralPath) shape).curveTo(25.745218, 23.021023, 24.577814, 19.614988, 24.577814, 19.614988);
        ((GeneralPath) shape).lineTo(23.163486, 19.614075);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        // _0_0_4_10
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(13.313608, 19.714073);
        ((GeneralPath) shape).curveTo(13.313608, 19.714073, 14.429594, 23.43545, 13.667265, 26.448053);
        ((GeneralPath) shape).curveTo(12.904936, 29.460657, 13.419369, 34.310165, 13.419369, 34.310165);
        ((GeneralPath) shape).lineTo(14.999517, 34.698425);
        ((GeneralPath) shape).curveTo(14.999517, 34.698425, 14.267616, 30.12864, 15.081478, 26.62483);
        ((GeneralPath) shape).curveTo(15.89534, 23.121023, 14.727935, 19.714989, 14.727935, 19.714989);
        ((GeneralPath) shape).lineTo(13.313608, 19.714073);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        // _0_0_4_11
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(19.418083, 20.520258);
        ((GeneralPath) shape).curveTo(19.418083, 20.520258, 19.615713, 24.1298, 19.064632, 27.254238);
        ((GeneralPath) shape).curveTo(18.52486, 30.31456, 21.306417, 34.496773, 21.306417, 34.496773);
        ((GeneralPath) shape).lineTo(22.721163, 33.86443);
        ((GeneralPath) shape).curveTo(22.721163, 33.86443, 19.926762, 31.248787, 20.55876, 27.078695);
        ((GeneralPath) shape).curveTo(21.116432, 23.399015, 20.83241, 20.521172, 20.83241, 20.521172);
        ((GeneralPath) shape).lineTo(19.418083, 20.520258);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        // _0_0_4_12
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(15.163487, 19.614075);
        ((GeneralPath) shape).curveTo(15.163487, 19.614075, 16.279472, 23.33545, 15.517144, 26.348055);
        ((GeneralPath) shape).curveTo(14.754815, 29.360659, 15.269248, 34.210167, 15.269248, 34.210167);
        ((GeneralPath) shape).lineTo(16.707596, 33.6621);
        ((GeneralPath) shape).curveTo(16.707596, 33.6621, 16.117495, 30.028639, 16.931356, 26.524832);
        ((GeneralPath) shape).curveTo(17.745218, 23.021023, 16.577814, 19.614988, 16.577814, 19.614988);
        ((GeneralPath) shape).lineTo(15.163487, 19.614075);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        // _0_0_4_13
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(16.81613, 20.479515);
        ((GeneralPath) shape).curveTo(16.81613, 20.479515, 17.932116, 24.200891, 17.169786, 27.213495);
        ((GeneralPath) shape).curveTo(16.407457, 30.226099, 14.726988, 31.80438, 14.726988, 31.80438);
        ((GeneralPath) shape).lineTo(15.964957, 32.939804);
        ((GeneralPath) shape).curveTo(15.964957, 32.939804, 17.770138, 30.89408, 18.584, 27.390272);
        ((GeneralPath) shape).curveTo(19.397861, 23.886463, 18.230455, 20.480429, 18.230455, 20.480429);
        ((GeneralPath) shape).lineTo(16.81613, 20.479515);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_4

        // _0_0_5

        // _0_0_5_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(29.163486, 19.614075);
        ((GeneralPath) shape).curveTo(29.163486, 19.614075, 30.279472, 23.33545, 29.517143, 26.348055);
        ((GeneralPath) shape).curveTo(28.754814, 29.360659, 29.269247, 34.210167, 29.269247, 34.210167);
        ((GeneralPath) shape).lineTo(30.884373, 34.634373);
        ((GeneralPath) shape).curveTo(30.884373, 34.634373, 30.117495, 30.028639, 30.931356, 26.524832);
        ((GeneralPath) shape).curveTo(31.745218, 23.021023, 30.577814, 19.614988, 30.577814, 19.614988);
        ((GeneralPath) shape).lineTo(29.163486, 19.614075);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(9.57962417602539, 33.58826446533203), 2.5527742f, new Point2D.Double(9.57962417602539, 33.58826446533203), new float[]{0, 1}, new Color[]{WHITE, new Color(0xD5D5D5)}, NO_CYCLE, SRGB, new AffineTransform(3.146715f, 0.06924886f, -0.06039991f, 2.744612f, -0.332562f, -61.89699f)));
        g.fill(shape);

        // _0_0_5_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(9.912416, 19.75934);
        ((GeneralPath) shape).curveTo(9.912416, 19.75934, 11.028404, 23.480717, 10.266074, 26.49332);
        ((GeneralPath) shape).curveTo(9.503745, 29.505924, 10.018178, 34.355434, 10.018178, 34.355434);
        ((GeneralPath) shape).lineTo(11.456527, 33.80737);
        ((GeneralPath) shape).curveTo(11.456527, 33.80737, 10.866426, 30.173906, 11.680288, 26.670097);
        ((GeneralPath) shape).curveTo(12.49415, 23.16629, 11.326745, 19.760256, 11.326745, 19.760256);
        ((GeneralPath) shape).lineTo(9.912416, 19.75934);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(9.57962417602539, 33.58826446533203), 2.5527742f, new Point2D.Double(9.57962417602539, 33.58826446533203), new float[]{0, 1}, new Color[]{WHITE, new Color(0xD5D5D5)}, NO_CYCLE, SRGB, new AffineTransform(3.146715f, 0.06924886f, -0.06039991f, 2.744612f, -19.58362f, -61.75172f)));
        g.fill(shape);

        // _0_0_5_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(11.66716, 19.714073);
        ((GeneralPath) shape).curveTo(11.66716, 19.714073, 12.783146, 23.43545, 12.020817, 26.448053);
        ((GeneralPath) shape).curveTo(11.258488, 29.460657, 8.617841, 31.76449, 8.617841, 31.76449);
        ((GeneralPath) shape).lineTo(9.826038, 33.73022);
        ((GeneralPath) shape).curveTo(9.826038, 33.73022, 12.621168, 30.12864, 13.43503, 26.62483);
        ((GeneralPath) shape).curveTo(14.248892, 23.121023, 13.081487, 19.714989, 13.081487, 19.714989);
        ((GeneralPath) shape).lineTo(11.66716, 19.714073);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(9.57962417602539, 33.58826446533203), 2.5527742f, new Point2D.Double(9.57962417602539, 33.58826446533203), new float[]{0, 1}, new Color[]{WHITE, new Color(0xD5D5D5)}, NO_CYCLE, SRGB, new AffineTransform(3.146715f, 0.06924886f, -0.06039991f, 2.744612f, -17.82887f, -61.79699f)));
        g.fill(shape);

        // _0_0_5_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(21.163486, 19.614075);
        ((GeneralPath) shape).curveTo(21.163486, 19.614075, 22.279472, 23.33545, 21.517143, 26.348055);
        ((GeneralPath) shape).curveTo(20.754814, 29.360659, 21.269247, 34.210167, 21.269247, 34.210167);
        ((GeneralPath) shape).lineTo(22.928568, 34.766956);
        ((GeneralPath) shape).curveTo(22.928568, 34.766956, 22.117495, 30.028639, 22.931356, 26.524832);
        ((GeneralPath) shape).curveTo(23.745218, 23.021023, 22.577814, 19.614988, 22.577814, 19.614988);
        ((GeneralPath) shape).lineTo(21.163486, 19.614075);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(9.57962417602539, 33.58826446533203), 2.5527742f, new Point2D.Double(9.57962417602539, 33.58826446533203), new float[]{0, 1}, new Color[]{WHITE, new Color(0xD5D5D5)}, NO_CYCLE, SRGB, new AffineTransform(3.146715f, 0.06924886f, -0.06039991f, 2.744612f, -8.332562f, -61.89699f)));
        g.fill(shape);

        // _0_0_5_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(35.163486, 19.614075);
        ((GeneralPath) shape).curveTo(35.163486, 19.614075, 36.279472, 23.33545, 35.517143, 26.348055);
        ((GeneralPath) shape).curveTo(34.754814, 29.360659, 36.55088, 33.50306, 36.55088, 33.50306);
        ((GeneralPath) shape).lineTo(38.077614, 32.292084);
        ((GeneralPath) shape).curveTo(38.077614, 32.292084, 36.117496, 30.028639, 36.93136, 26.524832);
        ((GeneralPath) shape).curveTo(37.74522, 23.021023, 36.577812, 19.614988, 36.577812, 19.614988);
        ((GeneralPath) shape).lineTo(35.163486, 19.614075);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(9.57962417602539, 33.58826446533203), 2.5527742f, new Point2D.Double(9.57962417602539, 33.58826446533203), new float[]{0, 1}, new Color[]{WHITE, new Color(0xD5D5D5)}, NO_CYCLE, SRGB, new AffineTransform(3.146715f, 0.06924886f, -0.06039991f, 2.744612f, 5.667438f, -61.89699f)));
        g.fill(shape);

        // _0_0_5_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(31.163486, 19.614075);
        ((GeneralPath) shape).curveTo(31.163486, 19.614075, 32.279472, 23.33545, 31.517143, 26.348055);
        ((GeneralPath) shape).curveTo(30.754814, 29.360659, 31.269247, 34.210167, 31.269247, 34.210167);
        ((GeneralPath) shape).lineTo(32.795982, 34.148235);
        ((GeneralPath) shape).curveTo(32.795982, 34.148235, 32.117496, 30.028639, 32.93136, 26.524832);
        ((GeneralPath) shape).curveTo(33.74522, 23.021023, 32.577812, 19.614988, 32.577812, 19.614988);
        ((GeneralPath) shape).lineTo(31.163486, 19.614075);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(9.57962417602539, 33.58826446533203), 2.5527742f, new Point2D.Double(9.57962417602539, 33.58826446533203), new float[]{0, 1}, new Color[]{WHITE, new Color(0xD5D5D5)}, NO_CYCLE, SRGB, new AffineTransform(3.146715f, 0.06924886f, -0.06039991f, 2.744612f, 1.667438f, -61.89699f)));
        g.fill(shape);

        // _0_0_5_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(33.163486, 19.614075);
        ((GeneralPath) shape).curveTo(33.163486, 19.614075, 34.279472, 23.33545, 33.517143, 26.348055);
        ((GeneralPath) shape).curveTo(32.754814, 29.360659, 32.473755, 34.03339, 32.473755, 34.03339);
        ((GeneralPath) shape).lineTo(34.265656, 34.457596);
        ((GeneralPath) shape).curveTo(34.265656, 34.457596, 34.117496, 30.028639, 34.93136, 26.524832);
        ((GeneralPath) shape).curveTo(35.74522, 23.021023, 34.577812, 19.614988, 34.577812, 19.614988);
        ((GeneralPath) shape).lineTo(33.163486, 19.614075);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(9.57962417602539, 33.58826446533203), 2.5527742f, new Point2D.Double(9.57962417602539, 33.58826446533203), new float[]{0, 1}, new Color[]{WHITE, new Color(0xD5D5D5)}, NO_CYCLE, SRGB, new AffineTransform(3.146715f, 0.06924886f, -0.06039991f, 2.744612f, 3.667438f, -61.89699f)));
        g.fill(shape);

        // _0_0_5_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(27.163486, 19.614075);
        ((GeneralPath) shape).curveTo(27.163486, 19.614075, 28.279472, 23.33545, 27.517143, 26.348055);
        ((GeneralPath) shape).curveTo(26.754814, 29.360659, 28.064743, 33.989197, 28.064743, 33.989197);
        ((GeneralPath) shape).lineTo(29.724062, 33.308548);
        ((GeneralPath) shape).curveTo(29.724062, 33.308548, 28.117495, 30.028639, 28.931356, 26.524832);
        ((GeneralPath) shape).curveTo(29.745218, 23.021023, 28.577814, 19.614988, 28.577814, 19.614988);
        ((GeneralPath) shape).lineTo(27.163486, 19.614075);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(9.57962417602539, 33.58826446533203), 2.5527742f, new Point2D.Double(9.57962417602539, 33.58826446533203), new float[]{0, 1}, new Color[]{WHITE, new Color(0xD5D5D5)}, NO_CYCLE, SRGB, new AffineTransform(3.146715f, 0.06924886f, -0.06039991f, 2.744612f, -2.332562f, -61.89699f)));
        g.fill(shape);

        // _0_0_5_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(25.163486, 19.614075);
        ((GeneralPath) shape).curveTo(25.163486, 19.614075, 26.279472, 23.33545, 25.517143, 26.348055);
        ((GeneralPath) shape).curveTo(24.754814, 29.360659, 24.164394, 34.077583, 24.164394, 34.077583);
        ((GeneralPath) shape).lineTo(25.69113, 34.28082);
        ((GeneralPath) shape).curveTo(25.69113, 34.28082, 26.117495, 30.028639, 26.931356, 26.524832);
        ((GeneralPath) shape).curveTo(27.745218, 23.021023, 26.577814, 19.614988, 26.577814, 19.614988);
        ((GeneralPath) shape).lineTo(25.163486, 19.614075);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(9.57962417602539, 33.58826446533203), 2.5527742f, new Point2D.Double(9.57962417602539, 33.58826446533203), new float[]{0, 1}, new Color[]{WHITE, new Color(0xD5D5D5)}, NO_CYCLE, SRGB, new AffineTransform(3.146715f, 0.06924886f, -0.06039991f, 2.744612f, -4.332562f, -61.89699f)));
        g.fill(shape);

        // _0_0_5_9
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(23.163486, 19.614075);
        ((GeneralPath) shape).curveTo(23.163486, 19.614075, 24.279472, 23.33545, 23.517143, 26.348055);
        ((GeneralPath) shape).curveTo(22.754814, 29.360659, 23.269247, 34.210167, 23.269247, 34.210167);
        ((GeneralPath) shape).lineTo(24.707596, 33.6621);
        ((GeneralPath) shape).curveTo(24.707596, 33.6621, 24.117495, 30.028639, 24.931356, 26.524832);
        ((GeneralPath) shape).curveTo(25.745218, 23.021023, 24.577814, 19.614988, 24.577814, 19.614988);
        ((GeneralPath) shape).lineTo(23.163486, 19.614075);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(9.57962417602539, 33.58826446533203), 2.5527742f, new Point2D.Double(9.57962417602539, 33.58826446533203), new float[]{0, 1}, new Color[]{WHITE, new Color(0xD5D5D5)}, NO_CYCLE, SRGB, new AffineTransform(3.146715f, 0.06924886f, -0.06039991f, 2.744612f, -6.332562f, -61.89699f)));
        g.fill(shape);

        // _0_0_5_10
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(13.313608, 19.714073);
        ((GeneralPath) shape).curveTo(13.313608, 19.714073, 14.429594, 23.43545, 13.667265, 26.448053);
        ((GeneralPath) shape).curveTo(12.904936, 29.460657, 13.419369, 34.310165, 13.419369, 34.310165);
        ((GeneralPath) shape).lineTo(14.999517, 34.698425);
        ((GeneralPath) shape).curveTo(14.999517, 34.698425, 14.267616, 30.12864, 15.081478, 26.62483);
        ((GeneralPath) shape).curveTo(15.89534, 23.121023, 14.727935, 19.714989, 14.727935, 19.714989);
        ((GeneralPath) shape).lineTo(13.313608, 19.714073);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(9.57962417602539, 33.58826446533203), 2.5527742f, new Point2D.Double(9.57962417602539, 33.58826446533203), new float[]{0, 1}, new Color[]{WHITE, new Color(0xD5D5D5)}, NO_CYCLE, SRGB, new AffineTransform(3.146715f, 0.06924886f, -0.06039991f, 2.744612f, -16.18243f, -61.79699f)));
        g.fill(shape);

        // _0_0_5_11
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(19.418083, 20.520258);
        ((GeneralPath) shape).curveTo(19.418083, 20.520258, 19.615713, 24.1298, 19.064632, 27.254238);
        ((GeneralPath) shape).curveTo(18.52486, 30.31456, 21.306417, 34.496773, 21.306417, 34.496773);
        ((GeneralPath) shape).lineTo(22.721163, 33.86443);
        ((GeneralPath) shape).curveTo(22.721163, 33.86443, 19.926762, 31.248787, 20.55876, 27.078695);
        ((GeneralPath) shape).curveTo(21.116432, 23.399015, 20.83241, 20.521172, 20.83241, 20.521172);
        ((GeneralPath) shape).lineTo(19.418083, 20.520258);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(9.57962417602539, 33.58826446533203), 2.5527742f, new Point2D.Double(9.57962417602539, 33.58826446533203), new float[]{0, 1}, new Color[]{WHITE, new Color(0xD5D5D5)}, NO_CYCLE, SRGB, new AffineTransform(3.146715f, 0.06924886f, -0.06039991f, 2.744612f, -10.78506f, -60.99081f)));
        g.fill(shape);

        // _0_0_5_12
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(15.163487, 19.614075);
        ((GeneralPath) shape).curveTo(15.163487, 19.614075, 16.279472, 23.33545, 15.517144, 26.348055);
        ((GeneralPath) shape).curveTo(14.754815, 29.360659, 15.269248, 34.210167, 15.269248, 34.210167);
        ((GeneralPath) shape).lineTo(16.707596, 33.6621);
        ((GeneralPath) shape).curveTo(16.707596, 33.6621, 16.117495, 30.028639, 16.931356, 26.524832);
        ((GeneralPath) shape).curveTo(17.745218, 23.021023, 16.577814, 19.614988, 16.577814, 19.614988);
        ((GeneralPath) shape).lineTo(15.163487, 19.614075);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(9.57962417602539, 33.58826446533203), 2.5527742f, new Point2D.Double(9.57962417602539, 33.58826446533203), new float[]{0, 1}, new Color[]{WHITE, new Color(0xD5D5D5)}, NO_CYCLE, SRGB, new AffineTransform(3.146715f, 0.06924886f, -0.06039991f, 2.744612f, -14.33255f, -61.89699f)));
        g.fill(shape);

        // _0_0_5_13
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(16.81613, 20.479515);
        ((GeneralPath) shape).curveTo(16.81613, 20.479515, 17.932116, 24.200891, 17.169786, 27.213495);
        ((GeneralPath) shape).curveTo(16.407457, 30.226099, 14.726988, 31.80438, 14.726988, 31.80438);
        ((GeneralPath) shape).lineTo(15.964957, 32.939804);
        ((GeneralPath) shape).curveTo(15.964957, 32.939804, 17.770138, 30.89408, 18.584, 27.390272);
        ((GeneralPath) shape).curveTo(19.397861, 23.886463, 18.230455, 20.480429, 18.230455, 20.480429);
        ((GeneralPath) shape).lineTo(16.81613, 20.479515);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(9.57962417602539, 33.58826446533203), 2.5527742f, new Point2D.Double(9.57962417602539, 33.58826446533203), new float[]{0, 1}, new Color[]{WHITE, new Color(0xD5D5D5)}, NO_CYCLE, SRGB, new AffineTransform(3.146715f, 0.06924886f, -0.06039991f, 2.744612f, -12.67991f, -61.03155f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.62886596f * origAlpha));

        // _0_0_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(5.414681, 19.121548);
        ((GeneralPath) shape).curveTo(5.3634243, 19.121414, 6.251433, 31.93862, 6.956946, 40.927803);
        ((GeneralPath) shape).curveTo(7.138951, 43.235264, 7.508862, 44.174408, 8.942307, 44.174408);
        ((GeneralPath) shape).curveTo(20.75913, 44.174408, 37.552948, 44.260506, 38.124794, 44.258404);
        ((GeneralPath) shape).curveTo(40.8913, 44.248245, 40.839523, 43.22092, 41.068645, 41.03815);
        ((GeneralPath) shape).curveTo(41.152054, 40.243546, 42.601147, 19.210922, 42.587322, 19.210922);
        ((GeneralPath) shape).curveTo(32.686245, 19.210922, 17.64779, 19.153519, 5.414681, 19.121548);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.setStroke(new BasicStroke(1, 0, 0, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(7.163233, 6.56876);
        ((GeneralPath) shape).curveTo(6.0964704, 6.571197, 5.203674, 6.59587, 4.7173743, 7.611591);
        ((GeneralPath) shape).curveTo(4.6328516, 7.788132, 2.0564582, 14.953189, 1.9325929, 15.226435);
        ((GeneralPath) shape).curveTo(0.8721842, 17.565664, 1.8500978, 20.512358, 3.8982468, 20.492628);
        ((GeneralPath) shape).curveTo(4.2877545, 20.488998, 44.257347, 20.510899, 44.877144, 20.492628);
        ((GeneralPath) shape).curveTo(46.620636, 20.442135, 46.843746, 17.029898, 46.093185, 15.494889);
        ((GeneralPath) shape).curveTo(46.050663, 15.407927, 42.567223, 7.513946, 42.47838, 7.374125);
        ((GeneralPath) shape).curveTo(42.067463, 6.749683, 41.14725, 6.476015, 40.463707, 6.501646);
        ((GeneralPath) shape).curveTo(40.329056, 6.506821, 7.296499, 6.568457, 7.163233, 6.56876);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(24.0000057220459, 15.837312698364258), new Point2D.Double(24.0000057220459, 21), new float[]{0, 0.7567568f, 1}, new Color[]{new Color(0x598BCB), new Color(0x2F5C96), new Color(0x203E65)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);
        g.setPaint(new Color(0x204A87));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.14948454f * origAlpha));

        // _0_0_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(4.79225, 20.902176);
        ((GeneralPath) shape).lineTo(7.292169, 20.902264);
        ((GeneralPath) shape).lineTo(8.058021, 41.513138);
        ((GeneralPath) shape).lineTo(7.2954774, 44.58633);
        ((GeneralPath) shape).curveTo(6.688538, 44.099873, 6.4168015, 43.36201, 6.2792296, 42.52353);
        ((GeneralPath) shape).lineTo(4.79225, 20.902176);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x555753));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.42783505f * origAlpha));

        // _0_0_9
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(8.033569, 41.611683);
        ((GeneralPath) shape).lineTo(7.3212657, 44.54057);
        ((GeneralPath) shape).curveTo(7.744129, 44.765465, 8.057012, 44.85283, 8.5125475, 45.007175);
        ((GeneralPath) shape).lineTo(38.53843, 44.978477);
        ((GeneralPath) shape).curveTo(39.11735, 44.938854, 39.669098, 44.912678, 40.052765, 44.806892);
        ((GeneralPath) shape).lineTo(38.00699, 41.370872);
        ((GeneralPath) shape).lineTo(8.033569, 41.611683);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xEEEEEC));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.371134f * origAlpha));

        // _0_0_10
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(38.00699, 41.370872);
        ((GeneralPath) shape).lineTo(40.01949, 44.81576);
        ((GeneralPath) shape).curveTo(40.63769, 44.55256, 41.34983, 44.09195, 41.630913, 42.961864);
        ((GeneralPath) shape).lineTo(43.139313, 20.94521);
        ((GeneralPath) shape).lineTo(39.69211, 20.942984);
        ((GeneralPath) shape).lineTo(38.00699, 41.370872);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.38659793f * origAlpha));

        // _0_0_11
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(40.375, 7.53125);
        ((GeneralPath) shape).curveTo(40.307785, 7.5315127, 40.187424, 7.5621486, 40.0625, 7.5625);
        ((GeneralPath) shape).curveTo(39.812653, 7.5632033, 39.458454, 7.5614724, 39.0, 7.5625);
        ((GeneralPath) shape).curveTo(38.083088, 7.5645556, 36.778275, 7.559461, 35.21875, 7.5625);
        ((GeneralPath) shape).curveTo(32.0997, 7.5685787, 27.959843, 7.58628, 23.8125, 7.59375);
        ((GeneralPath) shape).curveTo(15.517814, 7.6086903, 7.175529, 7.593706, 7.15625, 7.59375);
        ((GeneralPath) shape).curveTo(6.6366935, 7.594937, 6.261561, 7.652425, 6.0625, 7.71875);
        ((GeneralPath) shape).curveTo(5.863439, 7.7850757, 5.795362, 7.77194, 5.65625, 8.0625);
        ((GeneralPath) shape).curveTo(5.7244234, 7.9201074, 5.6779785, 8.036386, 5.65625, 8.09375);
        ((GeneralPath) shape).curveTo(5.6345215, 8.151114, 5.6013284, 8.238751, 5.5625, 8.34375);
        ((GeneralPath) shape).curveTo(5.4848433, 8.553747, 5.3772674, 8.870004, 5.25, 9.21875);
        ((GeneralPath) shape).curveTo(4.9954653, 9.916243, 4.647162, 10.82881, 4.3125, 11.75);
        ((GeneralPath) shape).curveTo(3.977838, 12.67119, 3.6668003, 13.599915, 3.40625, 14.3125);
        ((GeneralPath) shape).curveTo(3.275975, 14.668793, 3.1460285, 14.962545, 3.0625, 15.1875);
        ((GeneralPath) shape).curveTo(2.9789715, 15.412455, 2.96316, 15.461769, 2.875, 15.65625);
        ((GeneralPath) shape).curveTo(2.463348, 16.564342, 2.4810984, 17.654814, 2.75, 18.40625);
        ((GeneralPath) shape).curveTo(3.0189016, 19.157686, 3.387622, 19.473745, 3.90625, 19.46875);
        ((GeneralPath) shape).curveTo(4.0431166, 19.467474, 4.618759, 19.468534, 5.75, 19.46875);
        ((GeneralPath) shape).curveTo(6.881241, 19.468966, 8.469657, 19.46812, 10.375, 19.46875);
        ((GeneralPath) shape).curveTo(14.185686, 19.470007, 19.25455, 19.46738, 24.3125, 19.46875);
        ((GeneralPath) shape).curveTo(29.37045, 19.47012, 34.44211, 19.469322, 38.28125, 19.46875);
        ((GeneralPath) shape).curveTo(40.20082, 19.468464, 41.785362, 19.469906, 42.9375, 19.46875);
        ((GeneralPath) shape).curveTo(44.089638, 19.467594, 44.934708, 19.466068, 44.84375, 19.46875);
        ((GeneralPath) shape).curveTo(44.93948, 19.465979, 44.944878, 19.474737, 45.0625, 19.3125);
        ((GeneralPath) shape).curveTo(45.180122, 19.150263, 45.303425, 18.79192, 45.375, 18.375);
        ((GeneralPath) shape).curveTo(45.51815, 17.541162, 45.378994, 16.424294, 45.15625, 15.96875);
        ((GeneralPath) shape).curveTo(45.08818, 15.829539, 45.122097, 15.876058, 45.09375, 15.8125);
        ((GeneralPath) shape).curveTo(45.065403, 15.748942, 45.01873, 15.674998, 44.96875, 15.5625);
        ((GeneralPath) shape).curveTo(44.868786, 15.337505, 44.72996, 15.002468, 44.5625, 14.625);
        ((GeneralPath) shape).curveTo(44.227577, 13.870065, 43.788494, 12.876072, 43.34375, 11.875);
        ((GeneralPath) shape).curveTo(42.899006, 10.873928, 42.46493, 9.884789, 42.125, 9.125);
        ((GeneralPath) shape).curveTo(41.955036, 8.745106, 41.790173, 8.413838, 41.6875, 8.1875);
        ((GeneralPath) shape).curveTo(41.636166, 8.074331, 41.590405, 7.997518, 41.5625, 7.9375);
        ((GeneralPath) shape).curveTo(41.439575, 7.7832594, 40.85875, 7.517798, 40.5, 7.53125);
        ((GeneralPath) shape).curveTo(40.400017, 7.535093, 40.456734, 7.5311365, 40.4375, 7.53125);
        ((GeneralPath) shape).curveTo(40.418266, 7.5313635, 40.408607, 7.531119, 40.375, 7.53125);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(21.67790985107422, 19.969507217407227), new Point2D.Double(22.33352279663086, 11.643976211547852), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.8298969f * origAlpha));

        // _0_0_12
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(8.0, 10.0);
        ((GeneralPath) shape).lineTo(7.375, 12.0);
        ((GeneralPath) shape).lineTo(39.375, 12.0);
        ((GeneralPath) shape).lineTo(38.593147, 10.07544);
        ((GeneralPath) shape).lineTo(8.0, 10.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(27.5, 14), new Point2D.Double(27.625, 18.750015258789062), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 0.799991f, 0, -1.199875f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_13
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(9.853549, 1.5000014);
        ((GeneralPath) shape).lineTo(37.167316, 1.5000014);
        ((GeneralPath) shape).curveTo(37.363186, 1.5000014, 37.52087, 1.6576864, 37.52087, 1.853555);
        ((GeneralPath) shape).lineTo(37.52087, 11.500003);
        ((GeneralPath) shape).curveTo(37.52087, 11.500003, 9.499995, 11.500003, 9.499995, 11.500003);
        ((GeneralPath) shape).lineTo(9.499995, 1.853555);
        ((GeneralPath) shape).curveTo(9.499995, 1.6576864, 9.6576805, 1.5000014, 9.853549, 1.5000014);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(26.151338577270508, -5.740115642547607), new Point2D.Double(27.50038719177246, 13.351767539978027), new float[]{0, 1}, new Color[]{WHITE, new Color(0xD3D3D3)}, NO_CYCLE, SRGB, new AffineTransform(0.984533f, 0, 0, 1.203586f, 0.971903f, -2.123191f)));
        g.fill(shape);
        g.setPaint(new Color(0x888A85));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.62886596f * origAlpha));

        // _0_0_14
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(10.499998, 10.522594);
        ((GeneralPath) shape).lineTo(10.499998, 2.5000012);
        ((GeneralPath) shape).lineTo(36.50438, 2.5000012);
        ((GeneralPath) shape).lineTo(36.50438, 10.611733);

        g.setPaint(WHITE);
        g.setStroke(new BasicStroke(1, 2, 0, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.814384f, 0, 0, 0.796379f, 7.58372f, 3.212694f));

        // _0_0_15
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(43.0, 15.0);
        ((GeneralPath) shape).curveTo(43.0, 15.690356, 41.88071, 16.25, 40.5, 16.25);
        ((GeneralPath) shape).curveTo(39.11929, 16.25, 38.0, 15.690356, 38.0, 15.0);
        ((GeneralPath) shape).curveTo(38.0, 14.309644, 39.11929, 13.75, 40.5, 13.75);
        ((GeneralPath) shape).curveTo(41.88071, 13.75, 43.0, 14.309644, 43.0, 15.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xCC0000));
        g.fill(shape);
        g.setPaint(new Color(0xA40000));
        g.setStroke(new BasicStroke(1.2417247f, 2, 0, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_15
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.814384f, 0, 0, 0.796379f, 7.58372f, 2.549784f));

        // _0_0_16
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(43.0, 15.0);
        ((GeneralPath) shape).curveTo(43.0, 15.690356, 41.88071, 16.25, 40.5, 16.25);
        ((GeneralPath) shape).curveTo(39.11929, 16.25, 38.0, 15.690356, 38.0, 15.0);
        ((GeneralPath) shape).curveTo(38.0, 14.309644, 39.11929, 13.75, 40.5, 13.75);
        ((GeneralPath) shape).curveTo(41.88071, 13.75, 43.0, 14.309644, 43.0, 15.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xEF2929));
        g.fill(shape);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(40.5, 13.822796821594238), new Point2D.Double(40.5, 16.87784194946289), new float[]{0, 1}, new Color[]{new Color(0xA40000), new Color(0xFFC4C4)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_16
        g.setComposite(AlphaComposite.getInstance(3, 0.2731959f * origAlpha));

        // _0_0_17
        shape = new Rectangle2D.Double(9, 6.6875, 29, 5.3125);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(23.5, 12), new Point2D.Double(23.5, 6.6875), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.13917527f * origAlpha));

        // _0_0_18
        shape = new RoundRectangle2D.Double(12, 4, 23, 1, 1, 1);
        g.setPaint(BLACK);
        g.fill(shape);

        // _0_0_19
        shape = new RoundRectangle2D.Double(12, 6, 15, 1, 1, 1);
        g.fill(shape);

        // _0_0_20
        shape = new RoundRectangle2D.Double(12, 8, 19, 1, 1, 1);
        g.fill(shape);

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
        return 47;
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
    public EditDelete3() {
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

