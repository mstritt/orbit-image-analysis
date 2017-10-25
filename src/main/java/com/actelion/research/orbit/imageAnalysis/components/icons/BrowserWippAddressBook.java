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

import static java.awt.Color.WHITE;
import static java.awt.MultipleGradientPaint.ColorSpaceType.SRGB;
import static java.awt.MultipleGradientPaint.CycleMethod.NO_CYCLE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class BrowserWippAddressBook implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.0033670033f, 0, 0, 0.0033670033f, 0.14646465f, 0));

        // _0
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, -28.832f, -49.245f));

        // _0_0

        // _0_0_0

        // _0_0_0_0
        shape = new Rectangle2D.Double(-27.874000549316406, 99.42900085449219, 335.80999755859375, 246.72000122070312);
        g.setPaint(new Color(0x131516));
        g.fill(shape);
        g.setStroke(new BasicStroke(0.19711f, 0, 0, 4));
        g.draw(shape);

        // _0_0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-34.745, 93.571);
        ((GeneralPath) shape).lineTo(-34.745, 337.361);
        ((GeneralPath) shape).lineTo(116.05501, 337.361);
        ((GeneralPath) shape).lineTo(116.045006, 337.361);
        ((GeneralPath) shape).curveTo(125.175, 332.16098, 134.29501, 337.681, 143.46501, 332.481);
        ((GeneralPath) shape).curveTo(152.91501, 337.681, 162.35501, 332.16098, 171.85501, 337.361);
        ((GeneralPath) shape).lineTo(301.065, 337.361);
        ((GeneralPath) shape).lineTo(301.065, 93.571);
        ((GeneralPath) shape).curveTo(189.145, 93.572, 77.225006, 93.572, -34.744995, 93.572);
        ((GeneralPath) shape).lineTo(-34.749996, 93.572);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xC0C1C5));
        g.fill(shape);
        g.setPaint(new Color(0x7E8387));
        g.setStroke(new BasicStroke(1.8252f, 0, 0, 4));
        g.draw(shape);

        // _0_0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-14.167, 94.529);
        ((GeneralPath) shape).lineTo(-14.167, 327.549);
        ((GeneralPath) shape).curveTo(-14.167, 327.549, 74.441, 326.58902, 115.053, 328.509);
        ((GeneralPath) shape).curveTo(155.703, 330.469, 143.473, 333.42902, 143.473, 333.42902);
        ((GeneralPath) shape).curveTo(143.473, 333.42902, 129.973, 330.46902, 165.973, 328.509);
        ((GeneralPath) shape).curveTo(201.973, 326.589, 292.263, 327.549, 292.263, 327.549);
        ((GeneralPath) shape).lineTo(292.263, 94.52901);
        ((GeneralPath) shape).lineTo(292.263, 94.52801);
        ((GeneralPath) shape).curveTo(292.263, 94.52801, 202.293, 92.840004, 166.433, 94.20901);
        ((GeneralPath) shape).curveTo(130.563, 95.62401, 142.933, 100.09901, 142.933, 100.09901);
        ((GeneralPath) shape).curveTo(142.933, 100.09901, 156.25299, 95.62401, 115.513, 94.20901);
        ((GeneralPath) shape).curveTo(74.764, 92.840004, -14.166992, 94.52801, -14.166992, 94.52801);
        ((GeneralPath) shape).lineTo(-14.163992, 94.52801);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x42494C));
        g.fill(shape);

        // _0_0_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-19.505, 83.123);
        ((GeneralPath) shape).curveTo(-19.368, 163.93, -19.230999, 244.733, -19.049, 325.59302);
        ((GeneralPath) shape).curveTo(-19.049, 325.59302, 75.399, 324.63303, 116.05101, 326.59302);
        ((GeneralPath) shape).curveTo(156.66101, 328.51303, 143.47101, 333.433, 143.47101, 333.433);
        ((GeneralPath) shape).curveTo(143.47101, 333.433, 130.97101, 328.513, 166.97101, 326.59302);
        ((GeneralPath) shape).curveTo(202.931, 324.63303, 287.381, 325.59302, 287.381, 325.59302);
        ((GeneralPath) shape).curveTo(287.251, 244.78302, 287.11102, 163.97302, 286.931, 83.12302);
        ((GeneralPath) shape).lineTo(286.931, 83.126015);
        ((GeneralPath) shape).curveTo(286.931, 83.126015, 202.841, 81.39201, 166.97101, 82.807014);
        ((GeneralPath) shape).curveTo(131.061, 84.17502, 143.47101, 88.64702, 143.47101, 88.64702);
        ((GeneralPath) shape).curveTo(143.47101, 88.64702, 156.80101, 84.17502, 116.05101, 82.80702);
        ((GeneralPath) shape).curveTo(75.309006, 81.39202, -19.508987, 83.12602, -19.508987, 83.12602);
        ((GeneralPath) shape).lineTo(-19.503988, 83.12602);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);
        g.setPaint(new Color(0x7E8387));
        g.draw(shape);

        // _0_0_0_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-7.3226, 87.686);
        ((GeneralPath) shape).curveTo(-7.1857, 164.7, -7.0488997, 241.716, -6.8663, 318.736);
        ((GeneralPath) shape).curveTo(-6.8663, 318.736, 66.775696, 318.736, 105.2937, 320.69598);
        ((GeneralPath) shape).curveTo(118.0237, 324.25598, 130.7537, 327.866, 143.4737, 331.46597);
        ((GeneralPath) shape).curveTo(156.5237, 327.90598, 169.5737, 324.30597, 182.62369, 320.69598);
        ((GeneralPath) shape).curveTo(216.71368, 318.736, 283.46368, 318.736, 283.46368, 318.736);
        ((GeneralPath) shape).lineTo(283.46368, 87.68599);
        ((GeneralPath) shape).lineTo(283.46368, 87.68199);
        ((GeneralPath) shape).curveTo(283.46368, 87.68199, 215.98367, 84.48799, 182.08368, 88.36599);
        ((GeneralPath) shape).curveTo(148.17368, 92.19899, 142.93369, 102.05599, 142.93369, 102.05599);
        ((GeneralPath) shape).curveTo(142.93369, 102.05599, 142.43369, 92.19899, 103.73369, 88.36599);
        ((GeneralPath) shape).curveTo(65.09169, 84.48799, -7.3163147, 87.68199, -7.3163147, 87.68199);
        ((GeneralPath) shape).lineTo(-7.318915, 87.68199);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x42494C));
        g.fill(shape);

        // _0_0_0_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-11.247, 70.393);
        ((GeneralPath) shape).curveTo(-11.11, 151.2, -10.973, 232.00299, -10.79, 312.863);
        ((GeneralPath) shape).curveTo(-10.79, 312.863, 66.776, 311.903, 105.29, 313.863);
        ((GeneralPath) shape).curveTo(118.020004, 319.703, 130.75, 325.59302, 143.47, 331.47302);
        ((GeneralPath) shape).curveTo(156.52, 325.63303, 169.57, 319.75302, 182.62, 313.86304);
        ((GeneralPath) shape).curveTo(216.70999, 311.90305, 279.53998, 312.86304, 279.53998, 312.86304);
        ((GeneralPath) shape).curveTo(279.39996, 232.05304, 279.25998, 151.24304, 279.11996, 70.393036);
        ((GeneralPath) shape).lineTo(279.11996, 70.396034);
        ((GeneralPath) shape).curveTo(279.11996, 70.396034, 216.51996, 68.20603, 182.61996, 72.03903);
        ((GeneralPath) shape).curveTo(148.71997, 75.87103, 143.46997, 85.72603, 143.46997, 85.72603);
        ((GeneralPath) shape).curveTo(143.46997, 85.72603, 142.96997, 75.87103, 104.27997, 72.03903);
        ((GeneralPath) shape).curveTo(65.634964, 68.20603, -11.2500305, 70.396034, -11.2500305, 70.396034);
        ((GeneralPath) shape).lineTo(-11.24703, 70.396034);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);
        g.setPaint(new Color(0x7E8387));
        g.draw(shape);

        // _0_0_0_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(3.4455, 72.036);
        ((GeneralPath) shape).lineTo(3.4455, 306.966);
        ((GeneralPath) shape).curveTo(3.4455, 306.966, 67.915504, 305.776, 104.275505, 312.85602);
        ((GeneralPath) shape).curveTo(140.64551, 319.966, 143.4655, 330.466, 143.4655, 330.466);
        ((GeneralPath) shape).curveTo(143.4655, 330.466, 150.0455, 319.966, 181.61551, 312.85602);
        ((GeneralPath) shape).curveTo(213.18552, 305.77603, 275.6055, 307.966, 275.6055, 307.966);
        ((GeneralPath) shape).curveTo(275.46548, 229.356, 275.3355, 150.696, 275.1955, 72.03601);
        ((GeneralPath) shape).lineTo(275.1955, 72.03201);
        ((GeneralPath) shape).curveTo(275.1955, 72.03201, 210.1755, 68.83801, 178.46548, 72.67001);
        ((GeneralPath) shape).curveTo(146.70549, 76.50301, 142.87549, 97.17201, 142.87549, 97.17201);
        ((GeneralPath) shape).curveTo(142.87549, 97.17201, 141.32549, 76.50301, 105.14549, 72.67001);
        ((GeneralPath) shape).curveTo(68.9155, 68.83801, 3.4454956, 72.03201, 3.4454956, 72.03201);
        ((GeneralPath) shape).lineTo(3.4409957, 72.03201);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x42494C));
        g.fill(shape);

        // _0_0_0_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-2.4404, 59.625);
        ((GeneralPath) shape).curveTo(-2.3035, 140.43, -2.1667, 221.245, -2.0298998, 302.08502);
        ((GeneralPath) shape).lineTo(-2.0298998, 302.09503);
        ((GeneralPath) shape).curveTo(-2.0298998, 302.09503, 68.9201, 299.90503, 105.2901, 306.97504);
        ((GeneralPath) shape).curveTo(141.6501, 314.09503, 143.4701, 330.47504, 143.4701, 330.47504);
        ((GeneralPath) shape).curveTo(143.4701, 330.47504, 151.0501, 314.09503, 182.62009, 306.97504);
        ((GeneralPath) shape).curveTo(214.20009, 299.90503, 269.77008, 302.09503, 269.77008, 302.09503);
        ((GeneralPath) shape).curveTo(269.63007, 221.28503, 269.5001, 140.48503, 269.36008, 59.635025);
        ((GeneralPath) shape).lineTo(269.36008, 59.630024);
        ((GeneralPath) shape).curveTo(269.36008, 59.630024, 210.78008, 57.440025, 179.02008, 61.272022);
        ((GeneralPath) shape).curveTo(147.26009, 65.10502, 143.47008, 85.72802, 143.47008, 85.72802);
        ((GeneralPath) shape).curveTo(143.47008, 85.72802, 141.92007, 65.10502, 105.70007, 61.27202);
        ((GeneralPath) shape).curveTo(69.51407, 57.440018, -2.4399261, 59.63002, -2.4399261, 59.63002);
        ((GeneralPath) shape).lineTo(-2.4403262, 59.63002);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);
        g.setPaint(new Color(0x7E8387));
        g.draw(shape);

        // _0_0_0_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(21.696, 58.94);
        ((GeneralPath) shape).curveTo(21.787998, 138.65, 21.924, 218.41, 22.060999, 298.16);
        ((GeneralPath) shape).curveTo(22.060999, 298.16, 70.562996, 296.57, 104.1, 304.83002);
        ((GeneralPath) shape).curveTo(137.59, 313.13, 143.79, 327.55002, 143.79, 327.55002);
        ((GeneralPath) shape).curveTo(143.79, 327.55002, 147.34999, 313.13, 176.42, 304.83002);
        ((GeneralPath) shape).curveTo(205.44, 296.57, 261.91998, 298.16, 261.91998, 298.16);
        ((GeneralPath) shape).curveTo(261.83, 218.45001, 261.68997, 138.7, 261.56, 58.940002);
        ((GeneralPath) shape).curveTo(261.56, 58.940002, 205.66, 57.800003, 176.42, 61.496002);
        ((GeneralPath) shape).curveTo(147.17, 65.191, 143.79, 93.663, 143.79, 93.663);
        ((GeneralPath) shape).curveTo(143.79, 93.663, 142.23999, 65.191, 108.88999, 61.496002);
        ((GeneralPath) shape).curveTo(75.58199, 57.800003, 21.695992, 58.940002, 21.695992, 58.940002);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x42494C));
        g.fill(shape);

        // _0_0_0_9
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(14.213, 50.773);
        ((GeneralPath) shape).lineTo(14.213, 293.053);
        ((GeneralPath) shape).curveTo(14.213, 293.053, 73.072, 290.59302, 105.29, 299.173);
        ((GeneralPath) shape).curveTo(137.5, 307.703, 143.47, 327.553, 143.47, 327.553);
        ((GeneralPath) shape).curveTo(143.47, 327.553, 146.9, 307.703, 174.78, 299.173);
        ((GeneralPath) shape).curveTo(202.7, 290.59302, 254.44, 291.683, 254.44, 291.683);
        ((GeneralPath) shape).curveTo(254.53, 211.38301, 254.62, 131.08301, 254.71, 50.77301);
        ((GeneralPath) shape).lineTo(254.71, 50.77601);
        ((GeneralPath) shape).curveTo(254.71, 50.77601, 202.88, 48.58601, 174.78, 52.46401);
        ((GeneralPath) shape).curveTo(146.70999, 56.29701, 143.47, 85.72601, 143.47, 85.72601);
        ((GeneralPath) shape).curveTo(143.47, 85.72601, 141.92, 56.297012, 109.89, 52.464012);
        ((GeneralPath) shape).curveTo(77.863, 48.586014, 14.212997, 50.776012, 14.212997, 50.776012);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(50.53099822998047, 101.72000122070312), new Point2D.Double(143.50999450683594, 101.72000122070312), new float[]{0, 0.36863f, 0.52941f, 0.67843f, 1}, new Color[]{WHITE, WHITE, new Color(0xA0A3A7), WHITE, WHITE}, NO_CYCLE, SRGB, new AffineTransform(2.5867f, 0, 0, 2.5867f, -116.5f, -75.062f)));
        g.fill(shape);
        g.setPaint(new Color(0x7E8387));
        g.draw(shape);

        // _0_0_0_10
        shape = new Line2D.Float(143.470001f, 82.804001f, 143.470001f, 327.549988f);
        g.draw(shape);

        // _0_0_0_11
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(38.715, 119.99);
        ((GeneralPath) shape).curveTo(68.099, 120.17, 89.909, 121.45, 105.28999, 123.909996);
        ((GeneralPath) shape).curveTo(120.51999, 126.38, 128.54999, 129.89, 129.73999, 134.68);

        g.setPaint(new Color(0x005399));
        g.setStroke(new BasicStroke(2.7375f, 0, 0, 4));
        g.draw(shape);

        // _0_0_0_12
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(38.67, 143.21);
        ((GeneralPath) shape).curveTo(68.05299, 143.40001, 89.863, 144.67001, 105.24, 147.14);
        ((GeneralPath) shape).curveTo(120.479996, 149.65, 128.51, 153.16, 129.7, 157.91);

        g.draw(shape);

        // _0_0_0_13
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(38.67, 170.27);
        ((GeneralPath) shape).curveTo(68.05299, 170.45, 89.863, 171.73001, 105.24, 174.19);
        ((GeneralPath) shape).curveTo(120.479996, 176.66, 128.51, 180.17, 129.7, 184.96);

        g.draw(shape);

        // _0_0_0_14
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(38.67, 195.91);
        ((GeneralPath) shape).curveTo(68.05299, 196.1, 89.863, 197.37001, 105.24, 199.84);
        ((GeneralPath) shape).curveTo(120.479996, 202.3, 128.51, 205.86, 129.7, 210.61);

        g.draw(shape);

        // _0_0_0_15
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(38.67, 257.6);
        ((GeneralPath) shape).curveTo(68.05299, 257.78, 89.863, 259.06, 105.24, 261.52002);
        ((GeneralPath) shape).curveTo(120.479996, 263.99002, 128.51, 267.50003, 129.7, 272.29);

        g.draw(shape);

        // _0_0_0_16
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(246.23, 120.99);
        ((GeneralPath) shape).curveTo(216.84, 121.13, 195.03, 122.409996, 179.66, 124.869995);
        ((GeneralPath) shape).curveTo(164.42, 127.38, 156.39, 130.89, 155.20001, 135.64);

        g.draw(shape);

        // _0_0_0_17
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(246.23, 146.41);
        ((GeneralPath) shape).curveTo(216.84, 146.59, 195.03, 147.87001, 179.66, 150.33);
        ((GeneralPath) shape).curveTo(164.42, 152.84, 156.39, 156.35, 155.20001, 161.1);

        g.draw(shape);

        // _0_0_0_18
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(246.23, 168.95);
        ((GeneralPath) shape).curveTo(216.84, 169.12999, 195.03, 170.41, 179.66, 172.87);
        ((GeneralPath) shape).curveTo(164.42, 175.34, 156.39, 178.84999, 155.20001, 183.64);

        g.draw(shape);

        // _0_0_0_19
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(246.23, 194.41);
        ((GeneralPath) shape).curveTo(216.84, 194.59, 195.03, 195.87001, 179.66, 198.33);
        ((GeneralPath) shape).curveTo(164.42, 200.79001, 156.39, 204.31, 155.20001, 209.1);

        g.draw(shape);

        // _0_0_0_20
        shape = new Rectangle2D.Double(255.58999633789062, 153.27999877929688, 21.992000579833984, 22.51799964904785);
        g.setPaint(new Color(0xF1E900));
        g.fill(shape);
        g.setPaint(new Color(0x7E8387));
        g.setStroke(new BasicStroke(1.8262f, 0, 0, 4));
        g.draw(shape);

        // _0_0_0_21
        shape = new Rectangle2D.Double(270.0799865722656, 182.5399932861328, 21.992000579833984, 22.51799964904785);
        g.setPaint(new Color(0x2A1970));
        g.fill(shape);
        g.setPaint(new Color(0x7E8387));
        g.draw(shape);

        // _0_0_0_22
        shape = new Rectangle2D.Double(280.8699951171875, 210.44000244140625, 21.992000579833984, 22.51799964904785);
        g.setPaint(new Color(0x00873B));
        g.fill(shape);
        g.setPaint(new Color(0x7E8387));
        g.draw(shape);

        // _0_0_0_23
        shape = new Rectangle2D.Double(-42.03900146484375, 81.80500030517578, 21.992000579833984, 22.51799964904785);
        g.setPaint(new Color(0xE77470));
        g.fill(shape);
        g.setPaint(new Color(0x7E8387));
        g.draw(shape);

        // _0_0_0_24
        shape = new Rectangle2D.Double(-34.20600128173828, 93.55500030517578, 21.992000579833984, 22.51799964904785);
        g.setPaint(new Color(0xE4719D));
        g.fill(shape);
        g.setPaint(new Color(0x7E8387));
        g.draw(shape);

        // _0_0_0_25
        shape = new Rectangle2D.Double(-25.39299964904785, 108.23999786376953, 21.992000579833984, 22.51799964904785);
        g.setPaint(new Color(0x6C488D));
        g.fill(shape);
        g.setPaint(new Color(0x7E8387));
        g.draw(shape);

        // _0_0_0_26
        shape = new Rectangle2D.Double(-8.750399589538574, 121.94999694824219, 21.992000579833984, 22.51799964904785);
        g.setPaint(new Color(0xFFD75F));
        g.fill(shape);
        g.setPaint(new Color(0x7E8387));
        g.draw(shape);

        // _0_0_0_27
        shape = new Rectangle2D.Double(287.7099914550781, 239.19000244140625, 21.992000579833984, 22.51799964904785);
        g.setPaint(new Color(0x3FAD38));
        g.fill(shape);
        g.setPaint(new Color(0x7E8387));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0

        g.setTransform(transformations.poll()); // _0

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
        return 1;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     *
     * @return The height of the bounding box of the original SVG image.
     */
    public static int getOrigHeight() {
        return 1;
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
    public BrowserWippAddressBook() {
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

