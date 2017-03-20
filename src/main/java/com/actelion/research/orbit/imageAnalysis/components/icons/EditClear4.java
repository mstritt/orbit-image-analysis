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

import static java.awt.Color.*;
import static java.awt.MultipleGradientPaint.ColorSpaceType.SRGB;
import static java.awt.MultipleGradientPaint.CycleMethod.NO_CYCLE;
import static java.awt.MultipleGradientPaint.CycleMethod.REFLECT;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class EditClear4 implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.setComposite(AlphaComposite.getInstance(3, 0.88586956f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.7564409f, 0, 0, 0.7564409f, 41.737305f, 27.955805f));

        // _0_0_0
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_0_0
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 214.92589f, -100.31048f));

        // _0_0_0_0_0

        g.setTransform(transformations.poll()); // _0_0_0_0_0
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 214.92589f, -100.31048f));

        // _0_0_0_0_1

        g.setTransform(transformations.poll()); // _0_0_0_0_1

        // _0_0_0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-259.40213, 132.75623);
        ((GeneralPath) shape).lineTo(-259.40213, 129.96152);
        ((GeneralPath) shape).lineTo(-259.40213, 132.75623);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xC1FFFFFF, true));
        g.fill(shape);

        // _0_0_0_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(215.3609, -31.057518);
        ((GeneralPath) shape).lineTo(215.3609, -33.852226);
        ((GeneralPath) shape).lineTo(215.3609, -31.057518);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        // _0_0_0_0_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(249.73645, 22.336163);
        ((GeneralPath) shape).lineTo(249.73645, 20.809425);
        ((GeneralPath) shape).lineTo(249.73645, 22.336163);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        // _0_0_0_0_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(36.38397, 16.014486);
        ((GeneralPath) shape).curveTo(35.368416, 16.022627, 34.396137, 16.426825, 33.67413, 17.14105);
        ((GeneralPath) shape).lineTo(17.141043, 33.674137);
        ((GeneralPath) shape).curveTo(15.619653, 35.196144, 15.619658, 37.66315, 17.141039, 39.18516);
        ((GeneralPath) shape).lineTo(41.925446, 64.000015);
        ((GeneralPath) shape).lineTo(17.141043, 88.81487);
        ((GeneralPath) shape).curveTo(15.619658, 90.336876, 15.619658, 92.80389, 17.141043, 94.32589);
        ((GeneralPath) shape).lineTo(33.67413, 110.85897);
        ((GeneralPath) shape).curveTo(35.196133, 112.38036, 37.663143, 112.38036, 39.185158, 110.85898);
        ((GeneralPath) shape).lineTo(64.00001, 86.07458);
        ((GeneralPath) shape).lineTo(88.81486, 110.85898);
        ((GeneralPath) shape).curveTo(90.33687, 112.38036, 92.80388, 112.38036, 94.32588, 110.85897);
        ((GeneralPath) shape).lineTo(110.85897, 94.32589);
        ((GeneralPath) shape).curveTo(112.38035, 92.80389, 112.38035, 90.336876, 110.85897, 88.814865);
        ((GeneralPath) shape).lineTo(86.07457, 64.000015);
        ((GeneralPath) shape).lineTo(110.85898, 39.185165);
        ((GeneralPath) shape).curveTo(112.38035, 37.66315, 112.38035, 35.196144, 110.85897, 33.674133);
        ((GeneralPath) shape).lineTo(94.32589, 17.141047);
        ((GeneralPath) shape).curveTo(92.80388, 15.619666, 90.33687, 15.619662, 88.814865, 17.14105);
        ((GeneralPath) shape).lineTo(64.00001, 41.925453);
        ((GeneralPath) shape).lineTo(39.18515, 17.141047);
        ((GeneralPath) shape).curveTo(38.440693, 16.404446, 37.43113, 15.998429, 36.38397, 16.014486);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(66.770744, 77.79281);
        ((GeneralPath) shape).curveTo(66.03863, 77.05285, 65.04094, 76.636475, 64.00001, 76.636475);
        ((GeneralPath) shape).curveTo(62.959076, 76.636475, 61.961384, 77.05284, 61.22927, 77.792816);
        ((GeneralPath) shape).lineTo(66.770744, 77.79281);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(58.743717193603516, 78.41134643554688), new Point2D.Double(58.743717193603516, -15.688620567321777), new float[]{0, 1}, new Color[]{new Color(0x810000), new Color(0xC50000)}, NO_CYCLE, SRGB, new AffineTransform(0.9743255f, 0, 0, 0.9743255f, 5.5404773f, 5.5404854f)));
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9743255f, 0, 0, 0.9743255f, 99.290146f, 5.5404806f));

        // _0_0_0_0_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-62.57895, 106.7868);
        ((GeneralPath) shape).lineTo(-36.416, 79.91674);
        ((GeneralPath) shape).lineTo(-10.606602, 106.43324);
        ((GeneralPath) shape).lineTo(-36.416, 66.12816);
        ((GeneralPath) shape).lineTo(-62.57895, 106.7868);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);
        g.setStroke(new BasicStroke(0.49373052f, 0, 0, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_0_0_6
        g.setComposite(AlphaComposite.getInstance(3, 0.49812737f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0, 1.8163775f, -1.8163775f, 0, 130.55196f, 34.179955f));

        // _0_0_0_0_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(31.7, 16.0);
        ((GeneralPath) shape).lineTo(34.575, 12.625);
        ((GeneralPath) shape).curveTo(33.523796, 10.929242, 30.639864, 10.336982, 28.6375, 12.3125);
        ((GeneralPath) shape).lineTo(31.45, 15.6875);
        ((GeneralPath) shape).lineTo(31.7, 16.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(26.09113311767578, 14.856743812561035), new Point2D.Double(31.500688552856445, 14.856743812561035), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1.0975951f, 0, 0, 0.9110828f, 0, 0)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0_0_7
        g.setComposite(AlphaComposite.getInstance(3, 0.79026216f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.7938181f, 0, 0, -1.7938181f, -20.276758f, 130.94405f));

        // _0_0_0_0_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(31.7, 16.0);
        ((GeneralPath) shape).lineTo(34.575, 12.625);
        ((GeneralPath) shape).curveTo(33.523796, 10.929242, 30.639864, 10.336982, 28.6375, 12.3125);
        ((GeneralPath) shape).lineTo(31.45, 15.6875);
        ((GeneralPath) shape).lineTo(31.7, 16.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(26.09113311767578, 14.856743812561035), new Point2D.Double(31.500688552856445, 14.856743812561035), new float[]{0, 1}, new Color[]{new Color(0x765C44), new Color(0x765C44, true)}, NO_CYCLE, SRGB, new AffineTransform(1.0975951f, 0, 0, 0.9110828f, 0, 0)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0_0_8
        g.setComposite(AlphaComposite.getInstance(3, 0.49812737f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0, 1.6448195f, 1.6448195f, 0, -0.724353f, 39.584705f));

        // _0_0_0_0_9
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(31.7, 16.0);
        ((GeneralPath) shape).lineTo(34.575, 12.625);
        ((GeneralPath) shape).curveTo(33.523796, 10.929242, 30.639864, 10.336982, 28.6375, 12.3125);
        ((GeneralPath) shape).lineTo(31.45, 15.6875);
        ((GeneralPath) shape).lineTo(31.7, 16.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(304.8866271972656, 385.86126708984375), new Point2D.Double(345.6203918457031, 384.62384033203125), new float[]{0, 1}, new Color[]{new Color(0x765C44), new Color(0x765C44, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0_0_9
        g.setComposite(AlphaComposite.getInstance(3, 0.92134833f * origAlpha));

        // _0_0_0_0_10
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(91.55809, 23.43728);
        ((GeneralPath) shape).lineTo(64.00001, 50.995365);
        ((GeneralPath) shape).lineTo(36.441925, 23.437284);
        ((GeneralPath) shape).lineTo(23.437277, 36.441933);
        ((GeneralPath) shape).lineTo(50.995358, 64.000015);
        ((GeneralPath) shape).lineTo(23.43727, 91.558105);
        ((GeneralPath) shape).lineTo(36.441925, 104.56274);
        ((GeneralPath) shape).lineTo(64.00001, 77.00466);
        ((GeneralPath) shape).lineTo(91.55809, 104.56274);
        ((GeneralPath) shape).lineTo(104.56273, 91.5581);
        ((GeneralPath) shape).lineTo(77.004654, 64.000015);
        ((GeneralPath) shape).lineTo(104.56273, 36.44193);
        ((GeneralPath) shape).lineTo(91.55809, 23.43728);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(55.007041931152344, 88.46097564697266), new Point2D.Double(55.007041931152344, 36.65576934814453), new float[]{0, 1}, new Color[]{RED, new Color(0x7F0000)}, NO_CYCLE, SRGB, new AffineTransform(0.9743255f, 0, 0, 0.9743255f, 5.5404773f, 5.5404854f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.79026216f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.6448195f, 0, 0, -1.6448195f, -53.800877f, 129.5366f));

        // _0_0_0_0_11
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(88.7, 16.0);
        ((GeneralPath) shape).lineTo(91.575, 12.625);
        ((GeneralPath) shape).curveTo(90.523796, 10.929242, 87.63986, 10.336982, 85.6375, 12.3125);
        ((GeneralPath) shape).lineTo(88.45, 15.6875);
        ((GeneralPath) shape).lineTo(88.7, 16.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(31.90625, 13.510335922241211), new Point2D.Double(34.87510681152344, 13.510335922241211), new float[]{0, 1}, new Color[]{new Color(0xFF8787), new Color(0xFF8787, true)}, REFLECT, SRGB, new AffineTransform(1, 0, 0, 1, 56.7f, 0)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0_0_11
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9743255f, 0, 0, -0.9743255f, 99.290146f, 122.00005f));

        // _0_0_0_0_12
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-62.57895, 106.7868);
        ((GeneralPath) shape).lineTo(-36.416, 79.91674);
        ((GeneralPath) shape).lineTo(-10.606602, 106.43324);
        ((GeneralPath) shape).lineTo(-36.416, 66.12816);
        ((GeneralPath) shape).lineTo(-62.57895, 106.7868);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(-36.592777252197266, 90.07295227050781), 25.986174f, new Point2D.Double(-36.592777252197266, 90.07295227050781), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(0.4576062f, 0, 0, 0.782313f, -19.847694f, 18.82067f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0_0_12
        g.setComposite(AlphaComposite.getInstance(3, 0.79026216f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.4958209f, 0, 0, 1.4958209f, -10.888668f, 0.6143956f));

        // _0_0_0_0_13
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(31.7, 16.0);
        ((GeneralPath) shape).lineTo(34.575, 12.625);
        ((GeneralPath) shape).curveTo(33.523796, 10.929242, 30.639864, 10.336982, 28.6375, 12.3125);
        ((GeneralPath) shape).lineTo(31.45, 15.6875);
        ((GeneralPath) shape).lineTo(31.7, 16.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(31.90625, 13.510335922241211), new Point2D.Double(34.87510681152344, 13.510335922241211), new float[]{0, 1}, new Color[]{WHITE, new Color(0x252525, true)}, REFLECT, SRGB, new AffineTransform(1, 0, 0, 1, -0.3f, 0)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0_0_13
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.5356935f, 0, 0, 1.5356935f, -44.142788f, 0.2377555f));

        // _0_0_0_0_14
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(88.7, 16.0);
        ((GeneralPath) shape).lineTo(91.575, 12.625);
        ((GeneralPath) shape).curveTo(90.523796, 10.929242, 87.63986, 10.336982, 85.6375, 12.3125);
        ((GeneralPath) shape).lineTo(88.45, 15.6875);
        ((GeneralPath) shape).lineTo(88.7, 16.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(31.90625, 13.510335922241211), new Point2D.Double(34.87510681152344, 13.510335922241211), new float[]{0, 1}, new Color[]{WHITE, new Color(0x252525, true)}, REFLECT, SRGB, new AffineTransform(1, 0, 0, 1, 56.7f, 0)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0_0_14
        g.setComposite(AlphaComposite.getInstance(3, 0.92134833f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9743255f, 0, 0, 0.9743255f, 5.5404773f, 5.5404854f));

        // _0_0_0_0_15
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
        g.setStroke(new BasicStroke(1.5395266f, 1, 1, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_0_0_15
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_0_0_16
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(36.427155, 23.374601);
        ((GeneralPath) shape).lineTo(35.696407, 24.105347);
        ((GeneralPath) shape).lineTo(23.424273, 36.377483);
        ((GeneralPath) shape).lineTo(36.18357, 24.592505);
        ((GeneralPath) shape).lineTo(64.00132, 50.99825);
        ((GeneralPath) shape).lineTo(91.29385, 24.592506);
        ((GeneralPath) shape).lineTo(102.2263, 35.52495);
        ((GeneralPath) shape).curveTo(102.13068, 36.019463, 102.00159, 36.499084, 101.86092, 36.98643);
        ((GeneralPath) shape).lineTo(90.01592, 50.780094);
        ((GeneralPath) shape).curveTo(79.33311, 56.105892, 64.437355, 61.359222, 48.422672, 61.37588);
        ((GeneralPath) shape).lineTo(48.696697, 61.649906);
        ((GeneralPath) shape).curveTo(49.156178, 61.65532, 49.604874, 61.68036, 50.06685, 61.680363);
        ((GeneralPath) shape).curveTo(66.1296, 61.680363, 77.17473, 58.372505, 87.88458, 53.033222);
        ((GeneralPath) shape).lineTo(103.62689, 37.29091);
        ((GeneralPath) shape).curveTo(103.69171, 37.066345, 103.75182, 36.844555, 103.80958, 36.62106);
        ((GeneralPath) shape).curveTo(103.87717, 36.35953, 103.94071, 36.09608, 103.99227, 35.829426);
        ((GeneralPath) shape).lineTo(91.53744, 23.374601);
        ((GeneralPath) shape).lineTo(90.806694, 24.105347);
        ((GeneralPath) shape).lineTo(64.00132, 50.99825);
        ((GeneralPath) shape).lineTo(36.427155, 23.374601);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(68.3130111694336, 109.97648620605469), new Point2D.Double(51.54484939575195, 32.7508544921875), new float[]{0, 1}, new Color[]{new Color(0xF4F5F8), new Color(0xFDFDFE)}, NO_CYCLE, SRGB, new AffineTransform(1.381268f, 0, 0, 0.6872743f, 5.5404773f, 5.5404854f)));
        g.fill(shape);

        // _0_0_0_0_17
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(36.444862, 23.44199);
        ((GeneralPath) shape).lineTo(23.441982, 36.44487);
        ((GeneralPath) shape).lineTo(48.714417, 61.7173);
        ((GeneralPath) shape).curveTo(49.17388, 61.72271, 49.62258, 61.747746, 50.08456, 61.74775);
        ((GeneralPath) shape).curveTo(66.14731, 61.747746, 77.19244, 58.43989, 87.90229, 53.10061);
        ((GeneralPath) shape).lineTo(103.64461, 37.358307);
        ((GeneralPath) shape).curveTo(103.78528, 36.870953, 103.91436, 36.391327, 104.00998, 35.896812);
        ((GeneralPath) shape).lineTo(91.555145, 23.44199);
        ((GeneralPath) shape).lineTo(64.00001, 50.99713);
        ((GeneralPath) shape).lineTo(36.444862, 23.44199);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(47.26414108276367, 21.73845672607422), new Point2D.Double(47.26414108276367, 70.35726928710938), new float[]{0, 1}, new Color[]{new Color(0xFF8787), new Color(0xFF8787, true)}, NO_CYCLE, SRGB, new AffineTransform(0.9743255f, 0, 0, 0.9743255f, 5.5404773f, 5.5404854f)));
        g.fill(shape);

        // _0_0_0_0_18
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(36.427155, 23.374601);
        ((GeneralPath) shape).lineTo(35.696407, 24.105347);
        ((GeneralPath) shape).lineTo(23.424273, 36.377483);
        ((GeneralPath) shape).lineTo(36.18357, 24.592505);
        ((GeneralPath) shape).lineTo(64.00773, 52.836414);
        ((GeneralPath) shape).lineTo(64.00132, 50.99825);
        ((GeneralPath) shape).lineTo(64.01101, 52.82226);
        ((GeneralPath) shape).lineTo(91.29385, 24.592506);
        ((GeneralPath) shape).lineTo(102.2263, 35.52495);
        ((GeneralPath) shape).curveTo(102.13068, 36.019463, 102.00159, 36.499084, 101.86092, 36.98643);
        ((GeneralPath) shape).lineTo(90.01592, 50.780094);
        ((GeneralPath) shape).curveTo(79.33311, 56.105892, 64.437355, 61.359222, 48.422672, 61.37588);
        ((GeneralPath) shape).lineTo(48.696697, 61.649906);
        ((GeneralPath) shape).curveTo(49.156178, 61.65532, 49.604874, 61.68036, 50.06685, 61.680363);
        ((GeneralPath) shape).curveTo(66.1296, 61.680363, 77.17473, 58.372505, 87.88458, 53.033222);
        ((GeneralPath) shape).lineTo(103.62689, 37.29091);
        ((GeneralPath) shape).curveTo(103.69171, 37.066345, 103.75182, 36.844555, 103.80958, 36.62106);
        ((GeneralPath) shape).curveTo(103.87717, 36.35953, 103.94071, 36.09608, 103.99227, 35.829426);
        ((GeneralPath) shape).lineTo(91.53744, 23.374601);
        ((GeneralPath) shape).lineTo(90.806694, 24.105347);
        ((GeneralPath) shape).lineTo(64.00132, 50.99825);
        ((GeneralPath) shape).lineTo(36.427155, 23.374601);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(57.654170989990234, 71.82486724853516), new Point2D.Double(56.770992279052734, 20.362558364868164), new float[]{0, 1}, new Color[]{new Color(0xFFFFFF, true), WHITE}, NO_CYCLE, SRGB, new AffineTransform(0.9743255f, 0, 0, 0.9743255f, 5.5526547f, 6.75839f)));
        g.fill(shape);

        // _0_0_0_1

        g.setTransform(transformations.poll()); // _0_0_0

        // _0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(71.18175, 2.3002229);
        ((GeneralPath) shape).curveTo(74.977356, 1.427029, 77.39999, 3.1070192, 79.56865, 5.2592793);
        ((GeneralPath) shape).lineTo(61.47789, 56.53421);
        ((GeneralPath) shape).lineTo(53.09099, 53.575153);
        ((GeneralPath) shape).lineTo(71.18175, 2.3002229);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(-300.78125, -178.25), new Point2D.Double(-275.78125, -178.25), new float[]{0, 0.25f, 0.5f, 0.75f, 1}, new Color[]{new Color(0xF0E0C7), new Color(0xC5B496), new Color(0x9B7E56), new Color(0xC9AD86), new Color(0xE4CCAB)}, NO_CYCLE, SRGB, new AffineTransform(0.3354753f, 0.118362f, -0.118362f, 0.3354753f, 140.11034f, 128.53165f)));
        g.fill(shape);
        g.setPaint(new Color(0x74000000, true));
        g.setStroke(new BasicStroke(0.39999998f, 1, 1, 4));
        g.draw(shape);

        // _0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(71.18175, 2.3002229);
        ((GeneralPath) shape).curveTo(74.977356, 1.427029, 77.39999, 3.1070192, 79.56865, 5.2592793);
        ((GeneralPath) shape).lineTo(61.47789, 56.53421);
        ((GeneralPath) shape).lineTo(53.09099, 53.575153);
        ((GeneralPath) shape).lineTo(71.18175, 2.3002229);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(108.72569274902344, 34.64228820800781), new Point2D.Double(92.84992218017578, 1.4231866598129272), new float[]{0, 1}, new Color[]{BLACK, new Color(0xF4F0DB, true)}, NO_CYCLE, SRGB, new AffineTransform(0.9430266f, 0.3327174f, -0.3327174f, 0.9430266f, -16.96131f, 5.0420747f)));
        g.fill(shape);

        // _0_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(71.18175, 2.3002229);
        ((GeneralPath) shape).curveTo(74.977356, 1.427029, 77.39999, 3.1070192, 79.56865, 5.2592793);
        ((GeneralPath) shape).lineTo(61.47789, 56.53421);
        ((GeneralPath) shape).lineTo(53.09099, 53.575153);
        ((GeneralPath) shape).lineTo(71.18175, 2.3002229);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(71.54351043701172, -57.65826416015625), new Point2D.Double(92.71680450439453, -12.442840576171875), new float[]{0, 1}, new Color[]{new Color(0xF4F0DB), new Color(0xF4F0DB, true)}, NO_CYCLE, SRGB, new AffineTransform(0.9430266f, 0.3327174f, -0.3327174f, 0.9430266f, -16.96131f, 5.0420747f)));
        g.fill(shape);

        // _0_0_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(55.38204, 123.29951);
        ((GeneralPath) shape).lineTo(105.91218, 98.95073);
        ((GeneralPath) shape).curveTo(113.92744, 71.77357, 49.520844, 97.99175, 25.55097, 98.7165);
        ((GeneralPath) shape).lineTo(0.691747, 111.42233);
        ((GeneralPath) shape).lineTo(6.768446, 110.59369);
        ((GeneralPath) shape).lineTo(13.338647, 108.11072);
        ((GeneralPath) shape).lineTo(7.368751, 112.56696);
        ((GeneralPath) shape).lineTo(13.851299, 112.13165);
        ((GeneralPath) shape).lineTo(13.95, 115.01311);
        ((GeneralPath) shape).lineTo(16.100782, 110.87285);
        ((GeneralPath) shape).lineTo(12.568932, 116.39417);
        ((GeneralPath) shape).curveTo(12.568932, 116.39417, 11.543627, 118.17372, 13.753336, 117.34508);
        ((GeneralPath) shape).curveTo(15.963045, 116.51644, 21.68398, 117.22282, 21.68398, 117.22282);
        ((GeneralPath) shape).lineTo(18.124876, 118.63851);
        ((GeneralPath) shape).lineTo(28.036892, 118.60388);
        ((GeneralPath) shape).lineTo(30.445475, 121.26511);
        ((GeneralPath) shape).lineTo(40.19029, 121.08981);
        ((GeneralPath) shape).lineTo(35.220657, 122.48414);
        ((GeneralPath) shape).lineTo(38.809223, 123.0233);
        ((GeneralPath) shape).lineTo(37.980583, 124.12816);
        ((GeneralPath) shape).lineTo(45.43835, 121.64223);
        ((GeneralPath) shape).lineTo(41.23401, 126.22369);
        ((GeneralPath) shape).lineTo(48.200485, 125.23301);
        ((GeneralPath) shape).lineTo(45.162136, 127.1665);
        ((GeneralPath) shape).lineTo(55.38204, 123.29951);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(17.95388412475586, 121.78518676757812), new Point2D.Double(124.22025299072266, 85.54688262939453), new float[]{0, 1}, new Color[]{new Color(0xAF8D5F), new Color(0xAF8D5F, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, -14.5f, 1.1f)));
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.019354f, 0, 0, 1.019354f, -14.346842f, 0.9417934f));

        // _0_0_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(66.64518, 50.081028);
        ((GeneralPath) shape).curveTo(63.07044, 49.229866, 64.95205, 54.279697, 63.70655, 56.044567);
        ((GeneralPath) shape).curveTo(62.522717, 57.722057, 58.420765, 57.771107, 56.556152, 59.22842);
        ((GeneralPath) shape).curveTo(53.388954, 61.703773, 50.831818, 64.75161, 48.61111, 67.842575);
        ((GeneralPath) shape).curveTo(46.096878, 71.3421, 44.714775, 75.4137, 42.35135, 78.999886);
        ((GeneralPath) shape).curveTo(39.209663, 83.766975, 35.750584, 88.39366, 32.09578, 92.90242);
        ((GeneralPath) shape).lineTo(21.865606, 105.52291);
        ((GeneralPath) shape).lineTo(27.836027, 99.843216);
        ((GeneralPath) shape).lineTo(22.720945, 106.15346);
        ((GeneralPath) shape).lineTo(27.687832, 101.84772);
        ((GeneralPath) shape).lineTo(23.045586, 108.01875);
        ((GeneralPath) shape).lineTo(25.70194, 109.0014);
        ((GeneralPath) shape).lineTo(27.755594, 109.37716);
        ((GeneralPath) shape).lineTo(28.203026, 110.51999);
        ((GeneralPath) shape).lineTo(25.495867, 112.10145);
        ((GeneralPath) shape).lineTo(30.71118, 113.50716);
        ((GeneralPath) shape).curveTo(30.71118, 113.50716, 33.230614, 112.27513, 34.046432, 111.25056);
        ((GeneralPath) shape).curveTo(34.86225, 110.22599, 41.861614, 101.89028, 41.861614, 101.89028);
        ((GeneralPath) shape).lineTo(32.51219, 113.85927);
        ((GeneralPath) shape).lineTo(36.17208, 113.46796);
        ((GeneralPath) shape).lineTo(36.807236, 114.26138);
        ((GeneralPath) shape).lineTo(39.781162, 115.64075);
        ((GeneralPath) shape).lineTo(46.087505, 107.60714);
        ((GeneralPath) shape).lineTo(41.769897, 115.64345);
        ((GeneralPath) shape).lineTo(44.0762, 116.04287);
        ((GeneralPath) shape).lineTo(44.678898, 116.64976);
        ((GeneralPath) shape).lineTo(46.602703, 116.27941);
        ((GeneralPath) shape).lineTo(48.410774, 118.10009);
        ((GeneralPath) shape).lineTo(48.100254, 119.17196);
        ((GeneralPath) shape).lineTo(52.471508, 115.72791);
        ((GeneralPath) shape).lineTo(51.507496, 118.757);
        ((GeneralPath) shape).lineTo(53.268982, 117.45398);
        ((GeneralPath) shape).lineTo(54.19631, 119.92618);
        ((GeneralPath) shape).lineTo(55.647278, 119.69505);
        ((GeneralPath) shape).lineTo(56.632477, 121.0717);
        ((GeneralPath) shape).lineTo(58.050983, 120.65404);
        ((GeneralPath) shape).lineTo(57.960648, 121.56303);
        ((GeneralPath) shape).lineTo(60.29236, 120.6804);
        ((GeneralPath) shape).lineTo(62.252853, 114.80877);
        ((GeneralPath) shape).lineTo(62.47588, 121.80227);
        ((GeneralPath) shape).lineTo(65.38488, 122.80858);
        ((GeneralPath) shape).lineTo(67.77163, 113.67404);
        ((GeneralPath) shape).lineTo(66.73846, 122.01785);
        ((GeneralPath) shape).lineTo(72.86408, 82.957504);
        ((GeneralPath) shape).curveTo(73.55086, 78.578255, 75.36266, 74.445274, 75.57969, 70.000465);
        ((GeneralPath) shape).curveTo(75.70751, 67.382614, 74.245125, 64.478645, 73.898636, 61.769516);
        ((GeneralPath) shape).curveTo(73.78592, 60.888184, 74.08194, 60.07106, 74.2021, 59.22907);
        ((GeneralPath) shape).curveTo(74.41786, 57.71714, 75.754295, 55.776955, 74.90641, 54.707756);
        ((GeneralPath) shape).curveTo(74.215, 53.835876, 71.36004, 51.20366, 66.64518, 50.081028);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(-352.859130859375, -29.344430923461914), 91.92762f, new Point2D.Double(-352.859130859375, -29.344430923461914), new float[]{0, 0.5f, 1}, new Color[]{new Color(0xBEA57F), new Color(0xA6865C), new Color(0xD8AC6E)}, NO_CYCLE, SRGB, new AffineTransform(-0.2343078f, 0.4910111f, -0.3835806f, -0.1484282f, -35.185482f, 234.29922f)));
        g.fill(shape);
        g.setPaint(BLACK);
        g.setStroke(new BasicStroke(0.05863914f, 0, 0, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_5

        // _0_0_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-225.6177, -152.98405);
        ((GeneralPath) shape).lineTo(-225.6177, -155.77876);
        ((GeneralPath) shape).lineTo(-225.6177, -152.98405);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xC1FFFFFF, true));
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, -42.6661f, -8.40242f));

        // _0_0_7

        g.setTransform(transformations.poll()); // _0_0_7
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, -42.6661f, -8.40242f));

        // _0_0_8

        g.setTransform(transformations.poll()); // _0_0_8
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_9

        // _0_0_10
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_11
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-323.1997, -170.67877);
        ((GeneralPath) shape).lineTo(-323.1997, -173.47348);
        ((GeneralPath) shape).lineTo(-323.1997, -170.67877);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.782995f, 0, 0, 0.650879f, -2646.058f, 515.8389f));

        // _0_0_12

        g.setTransform(transformations.poll()); // _0_0_12
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.782995f, 0, 0, 0.650879f, -2646.058f, 515.8389f));

        // _0_0_13

        g.setTransform(transformations.poll()); // _0_0_13
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 0.650879f, 554.9047f, 523.1667f));

        // _0_0_14

        g.setTransform(transformations.poll()); // _0_0_14
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 0.650879f, 554.9047f, 523.1667f));

        // _0_0_15

        g.setTransform(transformations.poll()); // _0_0_15
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 198.5654f, -43.95872f));

        // _0_0_16

        g.setTransform(transformations.poll()); // _0_0_16
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 198.5654f, -43.95872f));

        // _0_0_17

        g.setTransform(transformations.poll()); // _0_0_17
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_18

        // _0_0_19
        g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.782995f, 0, 0, 0.650879f, -2404.827f, 480.2826f));

        // _0_0_20

        g.setTransform(transformations.poll()); // _0_0_20
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.782995f, 0, 0, 0.650879f, -2404.827f, 480.2826f));

        // _0_0_21

        g.setTransform(transformations.poll()); // _0_0_21
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 0.650879f, 796.1362f, 487.6104f));

        // _0_0_22

        g.setTransform(transformations.poll()); // _0_0_22
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 0.650879f, 796.1362f, 487.6104f));

        // _0_0_23

        g.setTransform(transformations.poll()); // _0_0_23
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.3507f, 0.032833483f, 0.045062426f, 0.2589192f, 30.355118f, 87.3558f));

        // _0_0_24

        // _0_0_24_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(82.01065, -145.59375);
        ((GeneralPath) shape).curveTo(78.92987, -140.45912, 75.15205, -135.5423, 72.6044, -129.9375);
        ((GeneralPath) shape).curveTo(71.18226, -126.8088, 70.62851, -123.27206, 69.9169, -119.96875);
        ((GeneralPath) shape).curveTo(69.20529, -116.66544, 68.34441, -113.61085, 66.51065, -111.4375);
        ((GeneralPath) shape).curveTo(64.00738, -108.47067, 60.111088, -106.4523, 56.0419, -104.40625);
        ((GeneralPath) shape).curveTo(51.97271, -102.3602, 47.745678, -100.30451, 44.7294, -96.9375);
        ((GeneralPath) shape).curveTo(35.447437, -86.57624, 28.889029, -73.48141, 21.760649, -61.46875);
        ((GeneralPath) shape).curveTo(10.175019, -41.944828, 1.3197886, -20.826788, -11.426851, -2.34375);
        ((GeneralPath) shape).curveTo(-35.12897, 32.025047, -62.339, 64.14207, -87.8331, 97.4375);
        ((GeneralPath) shape).lineTo(-86.3956, 98.53125);
        ((GeneralPath) shape).curveTo(-60.93769, 65.28307, -33.7281, 33.154736, -9.958101, -1.3125);
        ((GeneralPath) shape).curveTo(2.9306085, -20.001545, 11.823279, -41.18309, 23.323149, -60.5625);
        ((GeneralPath) shape).curveTo(30.496689, -72.651245, 37.01423, -85.60646, 46.07315, -95.71875);
        ((GeneralPath) shape).curveTo(48.77216, -98.73159, 52.75042, -100.76467, 56.82315, -102.8125);
        ((GeneralPath) shape).curveTo(60.895878, -104.86033, 65.05324, -106.92431, 67.88565, -110.28125);
        ((GeneralPath) shape).curveTo(70.06306, -112.86188, 70.97238, -116.19343, 71.69815, -119.5625);
        ((GeneralPath) shape).curveTo(72.42392, -122.93157, 72.98101, -126.37229, 74.26065, -129.1875);
        ((GeneralPath) shape).curveTo(76.69486, -134.54272, 80.39144, -139.43674, 83.5419, -144.6875);
        ((GeneralPath) shape).lineTo(82.01065, -145.59375);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x926B3F));
        g.fill(shape);

        // _0_0_24_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(81.56133, -144.96875);
        ((GeneralPath) shape).curveTo(78.5135, -139.99416, 75.06899, -135.29181, 72.74883, -130.1875);
        ((GeneralPath) shape).curveTo(71.46919, -127.37229, 70.9121, -123.93157, 70.18633, -120.5625);
        ((GeneralPath) shape).curveTo(69.46056, -117.19343, 68.55125, -113.86188, 66.37383, -111.28125);
        ((GeneralPath) shape).curveTo(63.541424, -107.92431, 59.384064, -105.86033, 55.311333, -103.8125);
        ((GeneralPath) shape).curveTo(51.238605, -101.76467, 47.260345, -99.73159, 44.561333, -96.71875);
        ((GeneralPath) shape).curveTo(35.502415, -86.60646, 28.984875, -73.651245, 21.811335, -61.5625);
        ((GeneralPath) shape).curveTo(10.311463, -42.18309, 1.4187886, -21.001545, -11.469916, -2.3125);
        ((GeneralPath) shape).curveTo(-35.239918, 32.154736, -62.449505, 64.28307, -87.90742, 97.53125);
        ((GeneralPath) shape).lineTo(-87.90742, 98.53125);
        ((GeneralPath) shape).curveTo(-62.449505, 65.28307, -35.239918, 33.154736, -11.469916, -1.3125);
        ((GeneralPath) shape).curveTo(1.4187886, -20.001545, 10.311463, -41.18309, 21.811335, -60.5625);
        ((GeneralPath) shape).curveTo(28.984875, -72.651245, 35.502415, -85.60646, 44.561333, -95.71875);
        ((GeneralPath) shape).curveTo(47.260345, -98.73159, 51.238605, -100.76467, 55.311333, -102.8125);
        ((GeneralPath) shape).curveTo(59.384064, -104.86033, 63.541424, -106.92431, 66.37383, -110.28125);
        ((GeneralPath) shape).curveTo(68.55125, -112.86188, 69.46056, -116.19343, 70.18633, -119.5625);
        ((GeneralPath) shape).curveTo(70.9121, -122.93157, 71.46919, -126.37229, 72.74883, -129.1875);
        ((GeneralPath) shape).curveTo(75.183044, -134.54272, 78.87962, -139.43674, 82.03008, -144.6875);
        ((GeneralPath) shape).lineTo(81.56133, -144.96875);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(-97.94491577148438, -23.21875), new Point2D.Double(73.43008422851562, -23.21875), new float[]{0, 1}, new Color[]{new Color(0xDCC0A1), new Color(0xDCC0A1, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 8.6f, 0)));
        g.fill(shape);

        // _0_0_24_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(84.0909, -145.59375);
        ((GeneralPath) shape).curveTo(81.01012, -140.45912, 77.2323, -135.5423, 74.68465, -129.9375);
        ((GeneralPath) shape).curveTo(73.26251, -126.8088, 72.708755, -123.27206, 71.99715, -119.96875);
        ((GeneralPath) shape).curveTo(71.28554, -116.66544, 70.42466, -113.61085, 68.5909, -111.4375);
        ((GeneralPath) shape).curveTo(66.08763, -108.47067, 62.191338, -106.4523, 58.122147, -104.40625);
        ((GeneralPath) shape).curveTo(54.05296, -102.3602, 49.825928, -100.30451, 46.809647, -96.9375);
        ((GeneralPath) shape).curveTo(37.527687, -86.57624, 30.969278, -73.48141, 23.840899, -61.46875);
        ((GeneralPath) shape).curveTo(12.255268, -41.944828, 3.4000378, -20.826788, -9.346602, -2.34375);
        ((GeneralPath) shape).curveTo(-33.048725, 32.025047, -60.25875, 64.14207, -85.75285, 97.4375);
        ((GeneralPath) shape).lineTo(-84.75285, 97.4375);
        ((GeneralPath) shape).curveTo(-59.25875, 64.14207, -32.048725, 32.025047, -8.346602, -2.34375);
        ((GeneralPath) shape).curveTo(4.400038, -20.826788, 13.255268, -41.944828, 24.840899, -61.46875);
        ((GeneralPath) shape).curveTo(31.969278, -73.48141, 38.527687, -86.57624, 47.809647, -96.9375);
        ((GeneralPath) shape).curveTo(50.825928, -100.30451, 55.05296, -102.3602, 59.122147, -104.40625);
        ((GeneralPath) shape).curveTo(63.191338, -106.4523, 67.08763, -108.47067, 69.5909, -111.4375);
        ((GeneralPath) shape).curveTo(71.42466, -113.61085, 72.28554, -116.66544, 72.99715, -119.96875);
        ((GeneralPath) shape).curveTo(73.708755, -123.27206, 74.26251, -126.8088, 75.68465, -129.9375);
        ((GeneralPath) shape).curveTo(78.15883, -135.38066, 81.78023, -140.18117, 84.80965, -145.15625);
        ((GeneralPath) shape).lineTo(84.0909, -145.59375);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x4A341B));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_24
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.3507f, 0.032833483f, 0.045062426f, 0.2589192f, 28.743696f, 86.83085f));

        // _0_0_25

        // _0_0_25_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(102.87208, -134.49783);
        ((GeneralPath) shape).curveTo(96.567535, -126.44204, 91.37855, -117.46424, 84.309586, -110.71659);
        ((GeneralPath) shape).curveTo(76.65436, -103.40931, 64.045074, -99.92617, 57.153336, -90.8416);
        ((GeneralPath) shape).curveTo(48.225796, -79.07347, 44.465916, -63.48666, 38.340836, -50.122845);
        ((GeneralPath) shape).curveTo(33.091263, -38.6692, 28.538984, -26.93513, 22.778334, -15.904095);
        ((GeneralPath) shape).curveTo(12.356744, 4.052133, -0.47605625, 22.931452, -10.471666, 43.314655);
        ((GeneralPath) shape).curveTo(-18.254686, 59.18589, -22.903316, 76.41286, -30.221666, 92.15841);
        ((GeneralPath) shape).curveTo(-34.200768, 100.71954, -39.804996, 108.59591, -44.690414, 116.97091);
        ((GeneralPath) shape).lineTo(-42.534164, 118.25216);
        ((GeneralPath) shape).curveTo(-37.726547, 110.01052, -32.050285, 102.0634, -27.940416, 93.22091);
        ((GeneralPath) shape).curveTo(-20.499907, 77.21254, -15.861826, 60.019566, -8.221666, 44.439655);
        ((GeneralPath) shape).curveTo(1.6699038, 24.2686, 14.485814, 5.380106, 24.997084, -14.747845);
        ((GeneralPath) shape).curveTo(30.844494, -25.945004, 35.383514, -37.698883, 40.590836, -49.060345);
        ((GeneralPath) shape).curveTo(46.856693, -62.73132, 50.670055, -78.15909, 59.153336, -89.3416);
        ((GeneralPath) shape).curveTo(65.31459, -97.46326, 77.70847, -100.99364, 86.028336, -108.93534);
        ((GeneralPath) shape).curveTo(93.448074, -116.01782, 98.68291, -125.06688, 104.84083, -132.93533);
        ((GeneralPath) shape).lineTo(102.87208, -134.49783);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(108.79048156738281, -174.8221893310547), new Point2D.Double(-33.218544006347656, 135.07704162597656), new float[]{0, 1}, new Color[]{new Color(0xD8B789), new Color(0xB17F3A)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        // _0_0_25_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(102.80865, -135.075);
        ((GeneralPath) shape).curveTo(96.69862, -127.23982, 91.465065, -118.27118, 84.0899, -111.23125);
        ((GeneralPath) shape).curveTo(75.770035, -103.28955, 63.376167, -99.75916, 57.214897, -91.6375);
        ((GeneralPath) shape).curveTo(48.731617, -80.45499, 44.918266, -65.02723, 38.652397, -51.35625);
        ((GeneralPath) shape).curveTo(33.445076, -39.994785, 28.906067, -28.24091, 23.058645, -17.04375);
        ((GeneralPath) shape).curveTo(12.547376, 3.084201, -0.26852378, 21.972692, -10.160104, 42.14375);
        ((GeneralPath) shape).curveTo(-17.800264, 57.72366, -22.438343, 74.91663, -29.878855, 90.925);
        ((GeneralPath) shape).curveTo(-33.988724, 99.7675, -39.664986, 107.71461, -44.472603, 115.95625);
        ((GeneralPath) shape).lineTo(-45.347603, 115.45625);
        ((GeneralPath) shape).curveTo(-45.408894, 115.56078, -45.474033, 115.66406, -45.535103, 115.76875);
        ((GeneralPath) shape).lineTo(-43.378853, 117.05);
        ((GeneralPath) shape).curveTo(-38.571236, 108.80836, -32.894974, 100.86124, -28.785105, 92.01875);
        ((GeneralPath) shape).curveTo(-21.344593, 76.01038, -16.706514, 58.81741, -9.066354, 43.2375);
        ((GeneralPath) shape).curveTo(0.82521623, 23.066444, 13.641126, 4.1779513, 24.152395, -15.95);
        ((GeneralPath) shape).curveTo(29.999805, -27.14716, 34.538826, -38.901035, 39.746147, -50.2625);
        ((GeneralPath) shape).curveTo(46.012005, -63.933475, 49.825367, -79.36124, 58.308647, -90.54375);
        ((GeneralPath) shape).curveTo(64.46991, -98.665405, 76.863785, -102.1958, 85.18365, -110.1375);
        ((GeneralPath) shape).curveTo(92.603386, -117.21998, 97.83823, -126.26904, 103.99615, -134.1375);
        ((GeneralPath) shape).lineTo(102.80865, -135.075);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xEAD7BD));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_25
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.3507f, 0.032833483f, 0.045062426f, 0.2589192f, 43.05654f, 78.81879f));

        // _0_0_26

        // _0_0_26_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(59.28125, -98.375);
        ((GeneralPath) shape).curveTo(57.79135, -90.9255, 57.5193, -83.09793, 54.9375, -76.5);
        ((GeneralPath) shape).curveTo(54.17468, -74.55057, 52.375362, -72.845314, 50.53125, -71.03125);
        ((GeneralPath) shape).curveTo(48.687138, -69.217186, 46.78569, -67.28562, 46.09375, -64.65625);
        ((GeneralPath) shape).curveTo(42.33606, -50.377026, 45.1777, -33.977486, 40.21875, -20.6875);
        ((GeneralPath) shape).curveTo(33.141613, -1.720771, 19.520222, 15.175525, 9.4375, 33.53125);
        ((GeneralPath) shape).curveTo(0.34443438, 50.085293, -7.299196, 67.406395, -16.96875, 83.4375);
        ((GeneralPath) shape).curveTo(-25.798042, 98.07554, -37.548347, 111.13696, -46.34375, 126.0625);
        ((GeneralPath) shape).curveTo(-53.82378, 138.75587, -59.12723, 152.61041, -65.46875, 165.78125);
        ((GeneralPath) shape).lineTo(-63.78125, 166.59375);
        ((GeneralPath) shape).curveTo(-57.393887, 153.32768, -52.09083, 139.5102, -44.71875, 127.0);
        ((GeneralPath) shape).curveTo(-36.054493, 112.29702, -24.299587, 99.28533, -15.34375, 84.4375);
        ((GeneralPath) shape).curveTo(-5.5909452, 68.26838, 2.0847366, 50.926666, 11.125, 34.46875);
        ((GeneralPath) shape).curveTo(21.095585, 16.317175, 34.773796, -0.63377315, 42.0, -20.0);
        ((GeneralPath) shape).curveTo(47.21632, -33.979736, 44.304214, -50.468517, 47.90625, -64.15625);
        ((GeneralPath) shape).curveTo(48.430172, -66.14715, 50.05237, -67.86331, 51.875, -69.65625);
        ((GeneralPath) shape).curveTo(53.69763, -71.44919, 55.708553, -73.31075, 56.6875, -75.8125);
        ((GeneralPath) shape).curveTo(59.434475, -82.83254, 59.708717, -90.76234, 61.15625, -98.0);
        ((GeneralPath) shape).lineTo(59.28125, -98.375);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x977248));
        g.fill(shape);

        // _0_0_26_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(58.48125, -99.275);
        ((GeneralPath) shape).curveTo(56.991352, -91.8255, 56.7193, -83.99793, 54.1375, -77.4);
        ((GeneralPath) shape).curveTo(53.37468, -75.45057, 51.57536, -73.745316, 49.73125, -71.93125);
        ((GeneralPath) shape).curveTo(47.88714, -70.11718, 45.98569, -68.18562, 45.29375, -65.55625);
        ((GeneralPath) shape).curveTo(41.53606, -51.277023, 44.3777, -34.877487, 39.41875, -21.5875);
        ((GeneralPath) shape).curveTo(32.341614, -2.620771, 18.720222, 14.275525, 8.6375, 32.63125);
        ((GeneralPath) shape).curveTo(-0.45556563, 49.185295, -8.0991955, 66.50639, -17.76875, 82.5375);
        ((GeneralPath) shape).curveTo(-26.598042, 97.17554, -38.348347, 110.23696, -47.14375, 125.1625);
        ((GeneralPath) shape).curveTo(-54.62378, 137.85588, -59.927235, 151.7104, -66.26875, 164.88126);
        ((GeneralPath) shape).lineTo(-64.58125, 165.69376);
        ((GeneralPath) shape).curveTo(-58.193886, 152.42769, -52.89083, 138.61018, -45.51875, 126.1);
        ((GeneralPath) shape).curveTo(-36.854492, 111.39702, -25.099586, 98.38533, -16.14375, 83.5375);
        ((GeneralPath) shape).curveTo(-6.3909454, 67.36838, 1.2847365, 50.02667, 10.325, 33.56875);
        ((GeneralPath) shape).curveTo(20.295584, 15.417175, 33.973797, -1.5337731, 41.2, -20.9);
        ((GeneralPath) shape).curveTo(46.41632, -34.879738, 43.504215, -51.36852, 47.10625, -65.05625);
        ((GeneralPath) shape).curveTo(47.630173, -67.04715, 49.252365, -68.76331, 51.075, -70.55625);
        ((GeneralPath) shape).curveTo(52.897633, -72.34919, 54.908554, -74.210754, 55.8875, -76.7125);
        ((GeneralPath) shape).curveTo(58.634476, -83.732544, 58.90872, -91.66234, 60.35625, -98.9);
        ((GeneralPath) shape).lineTo(58.48125, -99.275);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(60.35625076293945, -54.913631439208984), new Point2D.Double(60.35625076293945, 33.209373474121094), new float[]{0, 1}, new Color[]{new Color(0xC2A27E), new Color(0xC2A27E, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_26
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.3507f, 0.032833483f, 0.045062426f, 0.2589192f, 157.5364f, 90.28487f));

        // _0_0_27

        // _0_0_27_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-260.85233, -96.09375);
        ((GeneralPath) shape).curveTo(-261.59955, -90.614174, -261.52722, -85.038826, -263.03983, -80.09375);
        ((GeneralPath) shape).curveTo(-263.79248, -77.63315, -265.34912, -75.28564, -266.88358, -72.84375);
        ((GeneralPath) shape).curveTo(-268.41806, -70.40186, -269.9092, -67.84039, -270.38358, -64.90625);
        ((GeneralPath) shape).curveTo(-272.84177, -49.70187, -270.48056, -33.636887, -272.97733, -18.65625);
        ((GeneralPath) shape).curveTo(-276.67496, 3.5295308, -283.89194, 25.246902, -289.10233, 47.375);
        ((GeneralPath) shape).curveTo(-293.82477, 67.43077, -297.6159, 87.70094, -302.69608, 107.59375);
        ((GeneralPath) shape).curveTo(-309.22702, 133.16753, -316.875, 158.4671, -323.97733, 183.9375);
        ((GeneralPath) shape).lineTo(-322.25858, 184.40625);
        ((GeneralPath) shape).curveTo(-315.1633, 158.96117, -307.49005, 133.65598, -300.94608, 108.03125);
        ((GeneralPath) shape).curveTo(-295.84644, 88.06212, -292.0619, 67.7823, -287.35233, 47.78125);
        ((GeneralPath) shape).curveTo(-282.16702, 25.759748, -274.92493, 4.02925, -271.19608, -18.34375);
        ((GeneralPath) shape).curveTo(-268.63522, -33.708885, -271.0298, -49.80398, -268.63358, -64.625);
        ((GeneralPath) shape).curveTo(-268.23056, -67.1178, -266.8672, -69.46436, -265.35233, -71.875);
        ((GeneralPath) shape).curveTo(-263.8375, -74.28564, -262.1497, -76.751434, -261.28983, -79.5625);
        ((GeneralPath) shape).curveTo(-259.66302, -84.88091, -259.7926, -90.552734, -259.07108, -95.84375);
        ((GeneralPath) shape).lineTo(-260.85233, -96.09375);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x613F23));
        g.fill(shape);

        // _0_0_27_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-262.05234, -96.99375);
        ((GeneralPath) shape).curveTo(-262.79956, -91.514175, -262.72723, -85.93883, -264.23984, -80.99375);
        ((GeneralPath) shape).curveTo(-264.9925, -78.53315, -266.5491, -76.18564, -268.0836, -73.74375);
        ((GeneralPath) shape).curveTo(-269.61807, -71.301865, -271.10922, -68.740395, -271.5836, -65.80625);
        ((GeneralPath) shape).curveTo(-274.04178, -50.601868, -271.68057, -34.536884, -274.17734, -19.55625);
        ((GeneralPath) shape).curveTo(-277.87497, 2.6295307, -285.09192, 24.346903, -290.30234, 46.475);
        ((GeneralPath) shape).curveTo(-295.02478, 66.53077, -298.81592, 86.80094, -303.8961, 106.69375);
        ((GeneralPath) shape).curveTo(-310.42703, 132.26752, -318.075, 157.5671, -325.17734, 183.0375);
        ((GeneralPath) shape).lineTo(-323.4586, 183.50626);
        ((GeneralPath) shape).curveTo(-316.3633, 158.06116, -308.69003, 132.75598, -302.1461, 107.13125);
        ((GeneralPath) shape).curveTo(-297.04642, 87.16212, -293.2619, 66.8823, -288.55234, 46.88125);
        ((GeneralPath) shape).curveTo(-283.36703, 24.859749, -276.1249, 3.1292503, -272.3961, -19.24375);
        ((GeneralPath) shape).curveTo(-269.83524, -34.608883, -272.2298, -50.70398, -269.8336, -65.525);
        ((GeneralPath) shape).curveTo(-269.43057, -68.0178, -268.06717, -70.364365, -266.55234, -72.775);
        ((GeneralPath) shape).curveTo(-265.0375, -75.18564, -263.3497, -77.651436, -262.48984, -80.4625);
        ((GeneralPath) shape).curveTo(-260.86304, -85.780914, -260.99258, -91.452736, -260.2711, -96.74375);
        ((GeneralPath) shape).lineTo(-262.05234, -96.99375);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xCEB58E));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_27
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.3507f, 0.032833483f, 0.045062426f, 0.2589192f, 169.91267f, 94.43622f));

        // _0_0_28

        // _0_0_28_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-299.625, -112.90625);
        ((GeneralPath) shape).curveTo(-301.31366, -110.01137, -303.21954, -107.15465, -304.78125, -104.03125);
        ((GeneralPath) shape).curveTo(-306.35287, -100.88803, -306.71304, -97.26099, -308.28125, -95.46875);
        ((GeneralPath) shape).curveTo(-308.63596, -95.06337, -309.75345, -94.72704, -311.09375, -94.4375);
        ((GeneralPath) shape).curveTo(-312.43405, -94.14796, -314.11157, -93.86948, -315.03125, -92.375);
        ((GeneralPath) shape).curveTo(-317.93762, -87.65217, -319.25262, -81.3787, -320.3125, -75.84375);
        ((GeneralPath) shape).curveTo(-321.51614, -69.5581, -320.31967, -63.12488, -321.75, -57.5625);
        ((GeneralPath) shape).curveTo(-324.6018, -46.47217, -329.70917, -35.747517, -333.5, -24.59375);
        ((GeneralPath) shape).curveTo(-342.46045, 1.7706546, -352.132, 27.989382, -359.9375, 54.78125);
        ((GeneralPath) shape).curveTo(-370.2737, 90.25959, -378.54745, 126.31388, -387.84375, 162.03125);
        ((GeneralPath) shape).lineTo(-385.625, 162.59375);
        ((GeneralPath) shape).curveTo(-376.31757, 126.83358, -368.03018, 90.79956, -357.71875, 55.40625);
        ((GeneralPath) shape).curveTo(-349.94357, 28.718424, -340.286, 2.5590978, -331.3125, -23.84375);
        ((GeneralPath) shape).curveTo(-327.57953, -34.827282, -322.45755, -45.588745, -319.53125, -56.96875);
        ((GeneralPath) shape).curveTo(-317.92737, -63.206097, -319.1531, -69.7109, -318.0625, -75.40625);
        ((GeneralPath) shape).curveTo(-317.01047, -80.900185, -315.64694, -86.987816, -313.0625, -91.1875);
        ((GeneralPath) shape).curveTo(-312.811, -91.59621, -311.89597, -91.90618, -310.59375, -92.1875);
        ((GeneralPath) shape).curveTo(-309.29153, -92.46882, -307.68497, -92.68591, -306.5625, -93.96875);
        ((GeneralPath) shape).curveTo(-304.23108, -96.63324, -303.9871, -100.46332, -302.71875, -103.0);
        ((GeneralPath) shape).curveTo(-301.24554, -105.94642, -299.3633, -108.77003, -297.625, -111.75);
        ((GeneralPath) shape).lineTo(-299.625, -112.90625);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x83653D));
        g.fill(shape);

        // _0_0_28_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-300.625, -114.90625);
        ((GeneralPath) shape).curveTo(-302.31366, -112.01137, -304.21954, -109.15465, -305.78125, -106.03125);
        ((GeneralPath) shape).curveTo(-307.35287, -102.88803, -307.71304, -99.26099, -309.28125, -97.46875);
        ((GeneralPath) shape).curveTo(-309.63596, -97.06337, -310.75345, -96.72704, -312.09375, -96.4375);
        ((GeneralPath) shape).curveTo(-313.43405, -96.14796, -315.11157, -95.86948, -316.03125, -94.375);
        ((GeneralPath) shape).curveTo(-318.93762, -89.65217, -320.25262, -83.3787, -321.3125, -77.84375);
        ((GeneralPath) shape).curveTo(-322.51614, -71.5581, -321.31967, -65.124886, -322.75, -59.5625);
        ((GeneralPath) shape).curveTo(-325.6018, -48.47217, -330.70917, -37.747517, -334.5, -26.59375);
        ((GeneralPath) shape).curveTo(-343.46045, -0.22934555, -353.132, 25.989382, -360.9375, 52.78125);
        ((GeneralPath) shape).curveTo(-371.2737, 88.25959, -379.54745, 124.31388, -388.84375, 160.03125);
        ((GeneralPath) shape).lineTo(-386.625, 160.59375);
        ((GeneralPath) shape).curveTo(-377.31757, 124.83358, -369.03018, 88.79956, -358.71875, 53.40625);
        ((GeneralPath) shape).curveTo(-350.94357, 26.718424, -341.286, 0.5590977, -332.3125, -25.84375);
        ((GeneralPath) shape).curveTo(-328.57953, -36.827282, -323.45755, -47.588745, -320.53125, -58.96875);
        ((GeneralPath) shape).curveTo(-318.92737, -65.2061, -320.1531, -71.7109, -319.0625, -77.40625);
        ((GeneralPath) shape).curveTo(-318.01047, -82.900185, -316.64694, -88.987816, -314.0625, -93.1875);
        ((GeneralPath) shape).curveTo(-313.811, -93.59621, -312.89597, -93.90618, -311.59375, -94.1875);
        ((GeneralPath) shape).curveTo(-310.29153, -94.46882, -308.68497, -94.68591, -307.5625, -95.96875);
        ((GeneralPath) shape).curveTo(-305.23108, -98.63324, -304.9871, -102.46332, -303.71875, -105.0);
        ((GeneralPath) shape).curveTo(-302.24554, -107.94642, -300.3633, -110.77003, -298.625, -113.75);
        ((GeneralPath) shape).lineTo(-300.625, -114.90625);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xAB6C40));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_28

        // _0_0_29
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(14.132562, 113.00619);
        ((GeneralPath) shape).curveTo(15.483965, 111.54392, 12.444914, 113.17767, 13.587564, 111.69588);
        ((GeneralPath) shape).curveTo(19.927769, 103.47392, 26.789383, 92.26137, 32.065296, 83.939766);
        ((GeneralPath) shape).curveTo(25.773712, 93.755455, 23.487095, 104.18829, 14.132562, 113.00619);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x2B2014));
        g.fill(shape);

        // _0_0_30
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-471.49695, 121.76876);
        ((GeneralPath) shape).lineTo(-471.49695, 121.76876);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.setStroke(new BasicStroke(1, 0, 0, 4));
        g.draw(shape);

        // _0_0_31
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(44.702282, 124.994);
        ((GeneralPath) shape).curveTo(46.053684, 123.53176, 43.70485, 125.45199, 44.157276, 123.68372);
        ((GeneralPath) shape).curveTo(46.75664, 113.52444, 49.045204, 97.65146, 54.321117, 89.329865);
        ((GeneralPath) shape).curveTo(48.029537, 99.14556, 48.565086, 114.47165, 44.702282, 124.994);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x2B2014));
        g.fill(shape);

        // _0_0_32
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(33.620148, 119.98873);
        ((GeneralPath) shape).curveTo(34.971542, 118.52648, 32.480034, 120.39952, 33.07514, 118.67843);
        ((GeneralPath) shape).curveTo(36.33783, 109.24254, 46.48652, 86.03772, 50.370678, 76.92452);
        ((GeneralPath) shape).curveTo(46.4231, 86.82741, 37.48295, 109.46637, 33.620148, 119.98873);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        // _0_0_33
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(49.227303, 61.871082);
        ((GeneralPath) shape).curveTo(42.431263, 62.10761, 40.43329, 69.465164, 36.67264, 74.16266);
        ((GeneralPath) shape).curveTo(40.496475, 69.41214, 43.238205, 62.685806, 49.227303, 61.871082);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(57.92425537109375, 60.8710823059082), new Point2D.Double(63.37673568725586, 67.0168685913086), new float[]{0, 1}, new Color[]{new Color(0xF4F0DB), new Color(0xF4F0DB, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, -14, 1)));
        g.fill(shape);

        // _0_0_34
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(43.916836, 75.027916);
        ((GeneralPath) shape).lineTo(40.22209, 82.91183);
        ((GeneralPath) shape).lineTo(33.701614, 92.027504);

        g.setPaint(new LinearGradientPaint(new Point2D.Double(-781.8572998046875, 20.049320220947266), new Point2D.Double(-742.670654296875, 20.049320220947266), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(0.3507f, 0.03283347f, 0.045062438f, 0.2589192f, 305.23166f, 103.3643f)));
        g.setStroke(new BasicStroke(0.29887018f, 0, 0, 4));
        g.draw(shape);

        // _0_0_35
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(51.01857, 66.34074);
        ((GeneralPath) shape).curveTo(52.03595, 72.972015, 49.82295, 73.63677, 49.074818, 77.00716);
        ((GeneralPath) shape).curveTo(49.79401, 73.44773, 53.317657, 69.732765, 51.01857, 66.34074);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xF4F0DB));
        g.fill(shape);

        // _0_0_36
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.019354f, 0, 0, 1.019354f, -14.346842f, 0.9417934f));

        // _0_0_37
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(62.15625, 55.71875);
        ((GeneralPath) shape).curveTo(61.97268, 55.765972, 61.83159, 55.91292, 61.791874, 56.09826);
        ((GeneralPath) shape).curveTo(61.75216, 56.283596, 61.82065, 56.475456, 61.96875, 56.59375);
        ((GeneralPath) shape).curveTo(66.01791, 60.0226, 70.09287, 60.99838, 74.03125, 62.21875);
        ((GeneralPath) shape).curveTo(74.29877, 62.305042, 74.58558, 62.15814, 74.671875, 61.890625);
        ((GeneralPath) shape).curveTo(74.75817, 61.62311, 74.61127, 61.336292, 74.34375, 61.25);
        ((GeneralPath) shape).curveTo(70.364006, 60.01681, 66.49397, 59.120014, 62.625, 55.84375);
        ((GeneralPath) shape).curveTo(62.50078, 55.724003, 62.3236, 55.676758, 62.15625, 55.71875);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x8C8C8C));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_37
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.019354f, 0, 0, 1.019354f, -14.346842f, 0.9417934f));

        // _0_0_38
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(62.30297, 57.21851);
        ((GeneralPath) shape).curveTo(66.26203, 60.571068, 70.22109, 61.516, 74.18016, 62.74278);

        g.setPaint(new Color(0x7F000000, true));
        g.setStroke(new BasicStroke(1, 1, 0, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_38

        // _0_0_39
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.2, 72.333336);
        ((GeneralPath) shape).curveTo(33.718796, 76.4513, 29.551617, 84.20788, 24.666668, 91.13333);
        ((GeneralPath) shape).curveTo(29.550117, 85.19812, 33.724358, 77.62484, 37.2, 72.333336);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);

        // _0_0_40
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(24.117476, 117.12282);
        ((GeneralPath) shape).curveTo(24.875202, 116.21278, 24.166883, 120.14253, 25.45766, 117.43104);
        ((GeneralPath) shape).curveTo(30.584208, 106.66187, 37.105522, 95.58883, 41.795143, 86.1869);
        ((GeneralPath) shape).lineTo(24.117476, 117.12282);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x863E3E));
        g.fill(shape);

        // _0_0_41
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(15.450808, 115.25615);
        ((GeneralPath) shape).curveTo(16.208536, 114.34611, 15.500216, 118.27586, 16.790995, 115.56437);
        ((GeneralPath) shape).curveTo(21.917542, 104.7952, 24.705524, 105.32216, 29.395145, 95.92023);
        ((GeneralPath) shape).lineTo(15.450808, 115.25615);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        // _0_0_42
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(49.18414, 123.12281);
        ((GeneralPath) shape).curveTo(49.941868, 122.21277, 49.336735, 127.02861, 49.990993, 124.0977);
        ((GeneralPath) shape).curveTo(51.650875, 116.66186, 52.038857, 117.18882, 52.32848, 111.52023);
        ((GeneralPath) shape).curveTo(51.10259, 115.79242, 50.41003, 120.1373, 49.18414, 123.12281);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        // _0_0_43
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(31.46875, 75.96875);
        ((GeneralPath) shape).curveTo(31.229956, 76.02929, 31.070826, 76.25472, 31.09375, 76.5);
        ((GeneralPath) shape).curveTo(31.139088, 77.20121, 31.632017, 77.78474, 32.3125, 78.4375);
        ((GeneralPath) shape).curveTo(32.992985, 79.09027, 33.923676, 79.77733, 35.0, 80.5);
        ((GeneralPath) shape).curveTo(37.152653, 81.94535, 39.91473, 83.46591, 42.5, 84.6875);
        ((GeneralPath) shape).curveTo(45.167747, 85.94807, 48.98105, 87.25307, 52.375, 88.09375);
        ((GeneralPath) shape).curveTo(54.071976, 88.51409, 55.67868, 88.81279, 56.96875, 88.9375);
        ((GeneralPath) shape).curveTo(57.613785, 88.999855, 58.168953, 89.010414, 58.65625, 88.96875);
        ((GeneralPath) shape).curveTo(59.143547, 88.92709, 59.567966, 88.844635, 59.90625, 88.59375);
        ((GeneralPath) shape).curveTo(60.08766, 88.50488, 60.197784, 88.31559, 60.18537, 88.11396);
        ((GeneralPath) shape).curveTo(60.17296, 87.91233, 60.040447, 87.737976, 59.849506, 87.672035);
        ((GeneralPath) shape).curveTo(59.65856, 87.60609, 59.446697, 87.66151, 59.3125, 87.8125);
        ((GeneralPath) shape).curveTo(59.24083, 87.865654, 58.9569, 87.935036, 58.5625, 87.96875);
        ((GeneralPath) shape).curveTo(58.1681, 88.00247, 57.668274, 87.99606, 57.0625, 87.9375);
        ((GeneralPath) shape).curveTo(55.850952, 87.82038, 54.290237, 87.53748, 52.625, 87.125);
        ((GeneralPath) shape).curveTo(49.294525, 86.30004, 45.509895, 84.99676, 42.9375, 83.78125);
        ((GeneralPath) shape).curveTo(40.393345, 82.57909, 37.655304, 81.09267, 35.5625, 79.6875);
        ((GeneralPath) shape).curveTo(34.516098, 78.98492, 33.611805, 78.30564, 33.0, 77.71875);
        ((GeneralPath) shape).curveTo(32.388195, 77.13187, 32.103966, 76.59548, 32.09375, 76.4375);
        ((GeneralPath) shape).curveTo(32.089077, 76.28558, 32.01556, 76.144035, 31.893967, 76.05283);
        ((GeneralPath) shape).curveTo(31.772373, 75.96164, 31.615902, 75.9307, 31.46875, 75.96875);
        ((GeneralPath) shape).lineTo(31.46875, 75.96875);
        ((GeneralPath) shape).closePath();

        g.setPaint(GRAY);
        g.fill(shape);

        // _0_0_44
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(31.6, 77.46667);
        ((GeneralPath) shape).curveTo(31.711102, 79.18504, 37.58175, 82.81502, 42.71117, 85.23876);
        ((GeneralPath) shape).curveTo(47.951313, 87.71483, 57.96019, 90.41616, 59.6, 89.2);
        ((GeneralPath) shape).lineTo(59.6, 89.2);

        g.setPaint(new Color(0x74000000, true));
        g.setStroke(new BasicStroke(1, 0, 0, 4));
        g.draw(shape);

        // _0_0_45
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(31.5625, 76.2875);
        ((GeneralPath) shape).curveTo(31.43076, 76.2947, 31.306974, 76.3464, 31.21875, 76.44375);
        ((GeneralPath) shape).curveTo(31.22203, 76.45209, 31.21534, 76.4667, 31.21875, 76.475);
        ((GeneralPath) shape).curveTo(31.412415, 76.94679, 31.810968, 77.3689, 32.3125, 77.85);
        ((GeneralPath) shape).curveTo(32.992985, 78.50277, 33.923676, 79.22108, 35.0, 79.94375);
        ((GeneralPath) shape).curveTo(37.152653, 81.3891, 39.91473, 82.90966, 42.5, 84.13125);
        ((GeneralPath) shape).curveTo(45.167747, 85.39181, 48.98105, 86.696815, 52.375, 87.5375);
        ((GeneralPath) shape).curveTo(54.071976, 87.95784, 55.67868, 88.25654, 56.96875, 88.38125);
        ((GeneralPath) shape).curveTo(57.613785, 88.4436, 58.168953, 88.45416, 58.65625, 88.4125);
        ((GeneralPath) shape).curveTo(59.10677, 88.373985, 59.48785, 88.27787, 59.8125, 88.06875);
        ((GeneralPath) shape).curveTo(59.65463, 88.00137, 59.461143, 88.02263, 59.3125, 88.13125);
        ((GeneralPath) shape).curveTo(59.24083, 88.1844, 58.9569, 88.285034, 58.5625, 88.31875);
        ((GeneralPath) shape).curveTo(58.1681, 88.35247, 57.668274, 88.34606, 57.0625, 88.2875);
        ((GeneralPath) shape).curveTo(55.850952, 88.17038, 54.290237, 87.85623, 52.625, 87.44375);
        ((GeneralPath) shape).curveTo(49.294525, 86.61879, 45.509895, 85.346756, 42.9375, 84.13125);
        ((GeneralPath) shape).curveTo(40.393345, 82.929085, 37.655304, 81.411415, 35.5625, 80.00625);
        ((GeneralPath) shape).curveTo(34.516098, 79.303665, 33.611805, 78.62439, 33.0, 78.0375);
        ((GeneralPath) shape).curveTo(32.388195, 77.450615, 32.103966, 76.94548, 32.09375, 76.7875);
        ((GeneralPath) shape).curveTo(32.094006, 76.6493, 32.03814, 76.50722, 31.9375, 76.4125);
        ((GeneralPath) shape).curveTo(31.836863, 76.31778, 31.700432, 76.27888, 31.5625, 76.2875);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(45.217750549316406, 79.26189422607422), new Point2D.Double(73.8125, 79.26189422607422), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, -14, 3.1f)));
        g.fill(shape);

        // _0_0_46
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(57.2, 79.933334);
        ((GeneralPath) shape).curveTo(56.390118, 84.11114, 54.45154, 93.36806, 50.8, 110.33333);
        ((GeneralPath) shape).curveTo(54.82815, 99.72629, 55.931, 89.850586, 57.2, 79.933334);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x2B2014));
        g.fill(shape);

        // _0_0_47
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(51.466667, 63.266666);
        ((GeneralPath) shape).curveTo(47.985462, 67.384636, 46.218285, 70.60788, 43.333336, 77.8);
        ((GeneralPath) shape).curveTo(46.616783, 70.66479, 47.991024, 68.558174, 51.466667, 63.266666);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);

        // _0_0_48
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(38.133335, 88.6);
        ((GeneralPath) shape).curveTo(34.65213, 92.717964, 28.351618, 106.20788, 24.400002, 113.53333);
        ((GeneralPath) shape).curveTo(28.350119, 106.26479, 34.657692, 93.8915, 38.133335, 88.6);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        // _0_0_49
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(51.466667, 89.666664);
        ((GeneralPath) shape).curveTo(48.918797, 94.58463, 41.95162, 112.20788, 38.0, 119.53333);
        ((GeneralPath) shape).curveTo(41.95012, 112.26479, 48.791023, 95.35817, 51.466667, 89.666664);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xDDD298));
        g.fill(shape);

        // _0_0_50
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(59.466667, 67.0);
        ((GeneralPath) shape).curveTo(59.052128, 70.4513, 59.418285, 76.87455, 54.933334, 84.6);
        ((GeneralPath) shape).curveTo(58.216785, 76.26479, 59.45769, 71.22484, 59.466667, 67.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xBB7C3E));
        g.fill(shape);

        // _0_0_51
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(49.0, 57.875);
        ((GeneralPath) shape).curveTo(48.859657, 57.911102, 48.78505, 58.00091, 48.71875, 58.125);
        ((GeneralPath) shape).curveTo(48.748196, 58.170692, 48.76864, 58.214966, 48.8125, 58.25);
        ((GeneralPath) shape).curveTo(52.94002, 61.74521, 57.110397, 62.75601, 61.125, 64.0);
        ((GeneralPath) shape).curveTo(61.3636, 64.076965, 61.600132, 63.96014, 61.71875, 63.75);
        ((GeneralPath) shape).curveTo(61.656208, 63.64961, 61.55888, 63.539154, 61.4375, 63.5);
        ((GeneralPath) shape).curveTo(57.380737, 62.242943, 53.44385, 61.339676, 49.5, 58.0);
        ((GeneralPath) shape).curveTo(49.37338, 57.877937, 49.17059, 57.83219, 49.0, 57.875);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(62.71875, 57.44154357910156), new Point2D.Double(75.71875, 57.44154357910156), new float[]{0, 1}, new Color[]{new Color(0xFCFCFC), new Color(0xFCFCFC, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, -14, 3.5f)));
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9025936f, 0, 0, 0.9025936f, -4.3815145f, 1.4103976f));

        // _0_0_52
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(62.15625, 55.71875);
        ((GeneralPath) shape).curveTo(61.97268, 55.765972, 61.83159, 55.91292, 61.791874, 56.09826);
        ((GeneralPath) shape).curveTo(61.75216, 56.283596, 61.82065, 56.475456, 61.96875, 56.59375);
        ((GeneralPath) shape).curveTo(66.01791, 60.0226, 70.09287, 60.99838, 74.03125, 62.21875);
        ((GeneralPath) shape).curveTo(74.29877, 62.305042, 74.58558, 62.15814, 74.671875, 61.890625);
        ((GeneralPath) shape).curveTo(74.75817, 61.62311, 74.61127, 61.336292, 74.34375, 61.25);
        ((GeneralPath) shape).curveTo(70.364006, 60.01681, 66.49397, 59.120014, 62.625, 55.84375);
        ((GeneralPath) shape).curveTo(62.50078, 55.724003, 62.3236, 55.676758, 62.15625, 55.71875);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x8C8C8C));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_52
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9025936f, 0, 0, 0.9025936f, -4.3815145f, 1.4103976f));

        // _0_0_53
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(62.30297, 57.21851);
        ((GeneralPath) shape).curveTo(66.26203, 60.571068, 70.22109, 61.516, 74.18016, 62.74278);

        g.setPaint(new Color(0x7F000000, true));
        g.setStroke(new BasicStroke(1, 1, 0, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_53
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.8854565f, 0, 0, 0.8854565f, -6.829295f, 6.9561114f));

        // _0_0_54
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(66.11127, 50.670094);
        ((GeneralPath) shape).curveTo(65.97093, 50.706196, 65.89632, 50.796005, 65.83002, 50.920094);
        ((GeneralPath) shape).curveTo(65.85947, 50.965786, 65.879906, 51.01006, 65.92377, 51.045094);
        ((GeneralPath) shape).curveTo(70.05129, 54.540302, 74.221664, 55.5511, 78.23627, 56.795094);
        ((GeneralPath) shape).curveTo(78.47488, 56.872063, 78.7114, 56.755238, 78.83002, 56.545094);
        ((GeneralPath) shape).curveTo(78.76748, 56.444702, 78.67015, 56.334248, 78.54877, 56.295094);
        ((GeneralPath) shape).curveTo(74.492004, 55.038036, 70.55512, 54.13477, 66.61127, 50.795094);
        ((GeneralPath) shape).curveTo(66.48465, 50.67303, 66.28186, 50.62729, 66.11127, 50.670094);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(62.71875, 57.44154357910156), new Point2D.Double(75.71875, 57.44154357910156), new float[]{0, 1}, new Color[]{new Color(0xFCFCFC), new Color(0xFCFCFC, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 3.1112697f, -3.7049062f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_54

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
    public EditClear4() {
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

