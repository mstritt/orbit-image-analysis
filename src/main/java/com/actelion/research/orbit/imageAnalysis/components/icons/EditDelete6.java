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
public class EditDelete6 implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.transform(new AffineTransform(1, 0, 0, 1, 214.92589f, -100.31048f));

        // _0_0_0

        g.setTransform(transformations.poll()); // _0_0_0
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 214.92589f, -100.31048f));

        // _0_0_1

        g.setTransform(transformations.poll()); // _0_0_1

        // _0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-259.40213, 132.75623);
        ((GeneralPath) shape).lineTo(-259.40213, 129.96152);
        ((GeneralPath) shape).lineTo(-259.40213, 132.75623);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xC1FFFFFF, true));
        g.fill(shape);

        // _0_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(215.3609, -31.057518);
        ((GeneralPath) shape).lineTo(215.3609, -33.852226);
        ((GeneralPath) shape).lineTo(215.3609, -31.057518);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        // _0_0_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(249.73645, 22.336163);
        ((GeneralPath) shape).lineTo(249.73645, 20.809425);
        ((GeneralPath) shape).lineTo(249.73645, 22.336163);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        // _0_0_5
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

        // _0_0_6
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

        g.setTransform(transformations.poll()); // _0_0_6
        g.setComposite(AlphaComposite.getInstance(3, 0.49812737f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0, 1.8163775f, -1.8163775f, 0, 130.55196f, 34.179955f));

        // _0_0_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(31.7, 16.0);
        ((GeneralPath) shape).lineTo(34.575, 12.625);
        ((GeneralPath) shape).curveTo(33.523796, 10.929242, 30.639864, 10.336982, 28.6375, 12.3125);
        ((GeneralPath) shape).lineTo(31.45, 15.6875);
        ((GeneralPath) shape).lineTo(31.7, 16.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(26.09113311767578, 14.856743812561035), new Point2D.Double(31.500688552856445, 14.856743812561035), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1.0975951f, 0, 0, 0.9110828f, 0, 0)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_7
        g.setComposite(AlphaComposite.getInstance(3, 0.79026216f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.7938181f, 0, 0, -1.7938181f, -20.276758f, 130.94405f));

        // _0_0_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(31.7, 16.0);
        ((GeneralPath) shape).lineTo(34.575, 12.625);
        ((GeneralPath) shape).curveTo(33.523796, 10.929242, 30.639864, 10.336982, 28.6375, 12.3125);
        ((GeneralPath) shape).lineTo(31.45, 15.6875);
        ((GeneralPath) shape).lineTo(31.7, 16.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(26.09113311767578, 14.856743812561035), new Point2D.Double(31.500688552856445, 14.856743812561035), new float[]{0, 1}, new Color[]{new Color(0x765C44), new Color(0x765C44, true)}, NO_CYCLE, SRGB, new AffineTransform(1.0975951f, 0, 0, 0.9110828f, 0, 0)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_8
        g.setComposite(AlphaComposite.getInstance(3, 0.49812737f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0, 1.6448195f, 1.6448195f, 0, -0.724353f, 39.584705f));

        // _0_0_9
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(31.7, 16.0);
        ((GeneralPath) shape).lineTo(34.575, 12.625);
        ((GeneralPath) shape).curveTo(33.523796, 10.929242, 30.639864, 10.336982, 28.6375, 12.3125);
        ((GeneralPath) shape).lineTo(31.45, 15.6875);
        ((GeneralPath) shape).lineTo(31.7, 16.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(304.8866271972656, 385.86126708984375), new Point2D.Double(345.6203918457031, 384.62384033203125), new float[]{0, 1}, new Color[]{new Color(0x765C44), new Color(0x765C44, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_9
        g.setComposite(AlphaComposite.getInstance(3, 0.92134833f * origAlpha));

        // _0_0_10
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

        // _0_0_11
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(88.7, 16.0);
        ((GeneralPath) shape).lineTo(91.575, 12.625);
        ((GeneralPath) shape).curveTo(90.523796, 10.929242, 87.63986, 10.336982, 85.6375, 12.3125);
        ((GeneralPath) shape).lineTo(88.45, 15.6875);
        ((GeneralPath) shape).lineTo(88.7, 16.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(31.90625, 13.510335922241211), new Point2D.Double(34.87510681152344, 13.510335922241211), new float[]{0, 1}, new Color[]{new Color(0xFF8787), new Color(0xFF8787, true)}, REFLECT, SRGB, new AffineTransform(1, 0, 0, 1, 56.7f, 0)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_11
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9743255f, 0, 0, -0.9743255f, 99.290146f, 122.00005f));

        // _0_0_12
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-62.57895, 106.7868);
        ((GeneralPath) shape).lineTo(-36.416, 79.91674);
        ((GeneralPath) shape).lineTo(-10.606602, 106.43324);
        ((GeneralPath) shape).lineTo(-36.416, 66.12816);
        ((GeneralPath) shape).lineTo(-62.57895, 106.7868);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(-36.592777252197266, 90.07295227050781), 25.986174f, new Point2D.Double(-36.592777252197266, 90.07295227050781), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(0.4576062f, 0, 0, 0.782313f, -19.847694f, 18.82067f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_12
        g.setComposite(AlphaComposite.getInstance(3, 0.79026216f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.4958209f, 0, 0, 1.4958209f, -10.888668f, 0.6143956f));

        // _0_0_13
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(31.7, 16.0);
        ((GeneralPath) shape).lineTo(34.575, 12.625);
        ((GeneralPath) shape).curveTo(33.523796, 10.929242, 30.639864, 10.336982, 28.6375, 12.3125);
        ((GeneralPath) shape).lineTo(31.45, 15.6875);
        ((GeneralPath) shape).lineTo(31.7, 16.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(31.90625, 13.510335922241211), new Point2D.Double(34.87510681152344, 13.510335922241211), new float[]{0, 1}, new Color[]{WHITE, new Color(0x790000, true)}, REFLECT, SRGB, new AffineTransform(1, 0, 0, 1, -0.3f, 0)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_13
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.5356935f, 0, 0, 1.5356935f, -44.142788f, 0.2377555f));

        // _0_0_14
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(88.7, 16.0);
        ((GeneralPath) shape).lineTo(91.575, 12.625);
        ((GeneralPath) shape).curveTo(90.523796, 10.929242, 87.63986, 10.336982, 85.6375, 12.3125);
        ((GeneralPath) shape).lineTo(88.45, 15.6875);
        ((GeneralPath) shape).lineTo(88.7, 16.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(31.90625, 13.510335922241211), new Point2D.Double(34.87510681152344, 13.510335922241211), new float[]{0, 1}, new Color[]{WHITE, new Color(0x790000, true)}, REFLECT, SRGB, new AffineTransform(1, 0, 0, 1, 56.7f, 0)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_14
        g.setComposite(AlphaComposite.getInstance(3, 0.92134833f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9743255f, 0, 0, 0.9743255f, 5.5404773f, 5.5404854f));

        // _0_0_15
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

        g.setTransform(transformations.poll()); // _0_0_15
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_16
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

        // _0_0_17
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

        // _0_0_18
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

        // _0_1

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
    public EditDelete6() {
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

