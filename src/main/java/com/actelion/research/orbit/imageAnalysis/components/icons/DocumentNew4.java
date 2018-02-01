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
import java.awt.geom.*;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static java.awt.MultipleGradientPaint.ColorSpaceType.SRGB;
import static java.awt.MultipleGradientPaint.CycleMethod.NO_CYCLE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class DocumentNew4 implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.transform(new AffineTransform(0.783292f, 0, 0, 0.783292f, -6.340883f, -86.65168f));

        // _0_2_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(69.375, 125.0);
        ((GeneralPath) shape).curveTo(69.375, 132.93909, 62.939095, 139.375, 55.0, 139.375);
        ((GeneralPath) shape).curveTo(47.060905, 139.375, 40.625, 132.93909, 40.625, 125.0);
        ((GeneralPath) shape).curveTo(40.625, 117.060905, 47.060905, 110.625, 55.0, 110.625);
        ((GeneralPath) shape).curveTo(62.939095, 110.625, 69.375, 117.060905, 69.375, 125.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(55, 125), 14.375f, new Point2D.Double(55, 125), new float[]{0, 0.5f, 1}, new Color[]{WHITE, new Color(0xE3FFF520, true), new Color(0xFFF300, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_2_0

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
        return 0;
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
        return 48;
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
    public DocumentNew4() {
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

