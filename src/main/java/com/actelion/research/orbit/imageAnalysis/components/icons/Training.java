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
import java.awt.geom.RoundRectangle2D;

import static java.awt.Color.CYAN;
import static java.awt.Color.WHITE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class Training implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        ((GeneralPath) shape).moveTo(119.05743, -157.6583);
        ((GeneralPath) shape).curveTo(115.514305, -157.6583, 114.642944, -155.02594, 114.642944, -151.77774);
        ((GeneralPath) shape).curveTo(114.642944, -149.61227, 113.92346, -147.7242, 115.82432, -146.70338);
        ((GeneralPath) shape).lineTo(115.82432, -143.85796);
        ((GeneralPath) shape).curveTo(115.82432, -143.13185, 116.45486, -142.5538, 117.24689, -142.5538);
        ((GeneralPath) shape).lineTo(121.643906, -142.5538);
        ((GeneralPath) shape).curveTo(122.435936, -142.5538, 123.09234, -143.13185, 123.09234, -143.85796);
        ((GeneralPath) shape).lineTo(123.09234, -147.20134);
        ((GeneralPath) shape).curveTo(124.54372, -148.27962, 123.4719, -149.93169, 123.4719, -151.77776);
        ((GeneralPath) shape).curveTo(123.4719, -155.02596, 122.60054, -157.65831, 119.057434, -157.65831);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xFFAAAA));
        g.fill(shape);

        // _0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(93.84375, -165.53125);
        ((GeneralPath) shape).curveTo(93.84375, -165.53125, 94.03707, -162.63316, 95.90625, -160.0);
        ((GeneralPath) shape).curveTo(95.13952, -153.98573, 95.45999, -150.60896, 97.0, -146.53125);
        ((GeneralPath) shape).curveTo(100.74802, -141.0695, 104.02066, -133.5155, 109.65625, -138.59375);
        ((GeneralPath) shape).curveTo(113.43222, -147.40442, 105.92692, -149.57004, 101.53125, -150.59375);
        ((GeneralPath) shape).curveTo(100.46818, -153.77483, 98.47306, -156.1657, 97.5625, -159.46875);
        ((GeneralPath) shape).curveTo(97.35132, -159.72823, 97.21199, -159.91817, 97.09375, -160.09375);
        ((GeneralPath) shape).lineTo(99.6875, -161.15625);
        ((GeneralPath) shape).lineTo(99.875, -165.125);
        ((GeneralPath) shape).lineTo(93.84375, -165.53125);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);

        // _0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(103.0721, -165.00746);
        ((GeneralPath) shape).lineTo(92.97901, -162.46555);

        g.fill(shape);
        g.setStroke(new BasicStroke(1.172419f, 0, 0, 4));
        g.draw(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.9697196f, 0.24422112f, 0.21858068f, 0.9758189f, 0, 0));

        // _0_0_3
        shape = new RoundRectangle2D.Double(-123.68041229248047, -138.87442016601562, 2.0780551433563232, 7.977999687194824, 1.7630902528762817, 1.7630902528762817);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_3
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.9697196f, 0.24422112f, 0.21858068f, 0.9758189f, 0, 0));

        // _0_0_4
        shape = new RoundRectangle2D.Double(-126.01930236816406, -140.04771423339844, 2.0455572605133057, 10.324569702148438, 2.0455572605133057, 2.2816684246063232);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_4
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9697196f, -0.24422112f, 0.21858068f, 0.9758189f, 0, 0));

        // _0_0_5
        shape = new RoundRectangle2D.Double(136.81813049316406, -138.87442016601562, 2.0780551433563232, 7.977999687194824, 1.7630902528762817, 1.7630902528762817);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_5
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9697196f, -0.24422112f, 0.21858068f, 0.9758189f, 0, 0));

        // _0_0_6
        shape = new RoundRectangle2D.Double(134.47923278808594, -140.04771423339844, 2.0455572605133057, 10.324569702148438, 2.0455572605133057, 2.2816684246063232);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_6

        // _0_0_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(108.12854, -134.09512);
        ((GeneralPath) shape).curveTo(108.12854, -134.09512, 113.16616, -125.33406, 113.16616, -122.92476);
        ((GeneralPath) shape).curveTo(113.16616, -120.51547, 113.82324, -112.6305, 113.82324, -112.6305);
        ((GeneralPath) shape).curveTo(116.63199, -112.29125, 122.4706, -112.20422, 125.887, -112.6305);
        ((GeneralPath) shape).curveTo(125.887, -112.6305, 126.54408, -120.51547, 126.54408, -122.92476);
        ((GeneralPath) shape).curveTo(126.54408, -125.33406, 131.5817, -134.09512, 131.5817, -134.09512);

        g.setPaint(CYAN);
        g.setStroke(new BasicStroke(1, 0, 0, 4));
        g.draw(shape);

        // _0_0_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(143.79387, -164.69688);
        ((GeneralPath) shape).curveTo(143.79387, -164.69688, 143.60056, -161.79881, 141.73137, -159.16563);
        ((GeneralPath) shape).curveTo(142.4981, -153.15137, 142.17763, -149.77461, 140.63762, -145.69688);
        ((GeneralPath) shape).curveTo(136.8896, -140.23515, 133.61696, -132.68115, 127.98137, -137.75938);
        ((GeneralPath) shape).curveTo(124.2054, -146.57005, 131.7107, -148.73569, 136.10637, -149.75938);
        ((GeneralPath) shape).curveTo(137.16943, -152.94046, 139.16457, -155.33133, 140.07512, -158.63438);
        ((GeneralPath) shape).curveTo(140.2863, -158.89388, 140.42563, -159.08382, 140.54387, -159.25938);
        ((GeneralPath) shape).lineTo(137.95012, -160.32188);
        ((GeneralPath) shape).lineTo(137.76262, -164.29063);
        ((GeneralPath) shape).lineTo(143.79387, -164.69688);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);

        // _0_0_9
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(134.56552, -164.1731);
        ((GeneralPath) shape).lineTo(144.65862, -161.63118);

        g.fill(shape);
        g.setStroke(new BasicStroke(1.172419f, 0, 0, 4));
        g.draw(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9697196f, 0.24422112f, -0.21858068f, 0.9758189f, 0, 0));

        // _0_0_10
        shape = new RoundRectangle2D.Double(108.47386932373047, -196.121337890625, 2.0780551433563232, 7.977999687194824, 1.7630902528762817, 1.7630902528762817);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_10
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9697196f, 0.24422112f, -0.21858068f, 0.9758189f, 0, 0));

        // _0_0_11
        shape = new RoundRectangle2D.Double(106.13497161865234, -197.29461669921875, 2.0455572605133057, 10.324569702148438, 2.0455572605133057, 2.2816684246063232);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_11
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.9697196f, -0.24422112f, -0.21858068f, 0.9758189f, 0, 0));

        // _0_0_12
        shape = new RoundRectangle2D.Double(-95.33615112304688, -196.121337890625, 2.0780551433563232, 7.977999687194824, 1.7630902528762817, 1.7630902528762817);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_12
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.9697196f, -0.24422112f, -0.21858068f, 0.9758189f, 0, 0));

        // _0_0_13
        shape = new RoundRectangle2D.Double(-97.67504119873047, -197.29461669921875, 2.0455572605133057, 10.324569702148438, 2.0455572605133057, 2.2816684246063232);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_13

        // _0_0_14
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(123.24148, -160.63097);
        ((GeneralPath) shape).curveTo(124.54241, -165.73212, 128.79971, -166.82722, 129.23708, -166.10406);
        ((GeneralPath) shape).curveTo(130.65114, -163.76604, 126.96293, -163.49149, 126.23928, -163.76604);
        ((GeneralPath) shape).curveTo(124.90067, -164.2739, 123.29253, -160.42577, 123.29804, -160.41841);

        g.fill(shape);
        g.setStroke(new BasicStroke(0.6158532f, 1, 1, 4));
        g.draw(shape);

        // _0_0_15
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(120.36819, -161.98245);
        ((GeneralPath) shape).curveTo(119.90735, -165.74084, 122.14137, -167.63336, 122.57136, -167.27026);
        ((GeneralPath) shape).curveTo(123.96154, -166.09631, 121.86443, -164.90657, 121.37417, -164.89224);
        ((GeneralPath) shape).curveTo(120.46729, -164.86574, 120.44736, -161.8595, 120.45235, -161.8561);

        g.fill(shape);
        g.setStroke(new BasicStroke(0.41621017f, 1, 1, 4));
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
        return 0;
    }

    /**
     * Returns the width of the bounding box of the original SVG image.
     *
     * @return The width of the bounding box of the original SVG image.
     */
    public static int getOrigWidth() {
        return 63;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     *
     * @return The height of the bounding box of the original SVG image.
     */
    public static int getOrigHeight() {
        return 59;
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
    public Training() {
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

