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
import java.awt.geom.RoundRectangle2D;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static java.awt.MultipleGradientPaint.ColorSpaceType.SRGB;
import static java.awt.MultipleGradientPaint.CycleMethod.NO_CYCLE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class EditClear3 implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.setComposite(AlphaComposite.getInstance(3, 0.47368422f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.43578f, 0, 0, 0.825704f, -5.05046f, 13.43182f));

        // _0_0_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(38.142857, 30.857143);
        ((GeneralPath) shape).curveTo(38.142857, 36.45889, 31.171291, 41.0, 22.571428, 41.0);
        ((GeneralPath) shape).curveTo(13.971566, 41.0, 7.0, 36.45889, 7.0, 30.857143);
        ((GeneralPath) shape).curveTo(7.0, 25.255398, 13.971566, 20.714287, 22.571428, 20.714287);
        ((GeneralPath) shape).curveTo(31.171291, 20.714287, 38.142857, 25.255398, 38.142857, 30.857143);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(22.571428298950195, 30.85714340209961), 15.571428f, new Point2D.Double(22.571428298950195, 30.85714340209961), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 0.651376f, 0, 10.75754f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(6.9163117, 1.7780186);
        ((GeneralPath) shape).curveTo(8.646088, 0.8999591, 11.042237, 1.7815151, 11.928102, 3.3353386);
        ((GeneralPath) shape).lineTo(16.098341, 12.820053);
        ((GeneralPath) shape).curveTo(16.984205, 14.373873, 16.731756, 16.189358, 15.532312, 16.890638);
        ((GeneralPath) shape).curveTo(14.332867, 17.591923, 12.654079, 16.90558, 11.768213, 15.351758);
        ((GeneralPath) shape).lineTo(5.84975, 6.996031);
        ((GeneralPath) shape).curveTo(4.9638853, 5.4422064, 5.2207537, 2.6387086, 6.9163117, 1.7780186);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(12.23343276977539, 12.3632230758667), new Point2D.Double(16.870908737182617, 17.11094093322754), new float[]{0, 1}, new Color[]{new Color(0xC17D10), new Color(0x9B650C)}, NO_CYCLE, SRGB, new AffineTransform(0.965926f, 0.262102f, -0.258819f, 0.978177f, 2.957072f, -5.939741f)));
        g.fill(shape);
        g.setPaint(new Color(0x8F5902));
        g.setStroke(new BasicStroke(1.0063211f, 1, 0, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.4230769f * origAlpha));

        // _0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(7.44627, 2.7359104);
        ((GeneralPath) shape).curveTo(8.868223, 1.9500906, 10.266975, 2.5431693, 11.141568, 4.0752983);
        ((GeneralPath) shape).lineTo(15.589706, 14.162023);
        ((GeneralPath) shape).lineTo(13.158185, 15.581885);
        ((GeneralPath) shape).lineTo(6.861574, 6.761549);
        ((GeneralPath) shape).curveTo(5.986981, 5.2294207, 5.9853272, 3.5432765, 7.44627, 2.7359104);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(9.56215763092041, 6.952558994293213), new Point2D.Double(14.766724586486816, 14.200403213500977), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.setStroke(new BasicStroke(1.0056905f, 1, 0, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(14.780848, 22.793568);
        ((GeneralPath) shape).curveTo(13.985353, 27.080402, 15.414814, 36.746067, 21.040081, 42.487564);
        ((GeneralPath) shape).curveTo(25.386835, 42.628857, 35.03017, 39.06988, 41.571175, 32.290527);
        ((GeneralPath) shape).curveTo(32.335, 27.773815, 26.034647, 16.567549, 21.135868, 19.007853);
        ((GeneralPath) shape).lineTo(14.780848, 22.793568);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(20.764476776123047, 19.540945053100586), 14.799585f, new Point2D.Double(20.764476776123047, 19.540945053100586), new float[]{0, 0.5f, 1}, new Color[]{new Color(0xFEF088), new Color(0xFDE63A), new Color(0xDAC203)}, NO_CYCLE, SRGB, new AffineTransform(0.449398f, -0.216492f, 0.564416f, 1.171617f, -1.432288f, 2.546108f)));
        g.fill(shape);
        g.setPaint(new Color(0xC4A000));
        g.setStroke(new BasicStroke(1, 0, 0, 4));
        g.draw(shape);

        // _0_0_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(16.33836, 24.367273);
        ((GeneralPath) shape).curveTo(18.687374, 30.637545, 18.827803, 37.155575, 23.522142, 42.28716);

        g.setPaint(new LinearGradientPaint(new Point2D.Double(9.105389595031738, 38.82814407348633), new Point2D.Double(10.146956443786621, 30.140830993652344), new float[]{0, 1}, new Color[]{new Color(0xC4A000), new Color(0xC4A000, true)}, NO_CYCLE, SRGB, new AffineTransform(0.866026f, -0.5f, 0.797491f, 1.381294f, -15.69909f, -9.225099f)));
        g.setStroke(new BasicStroke(1, 1, 0, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.46153846f * origAlpha));

        // _0_0_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(15.91878, 23.414124);
        ((GeneralPath) shape).curveTo(15.006687, 23.922228, 15.758401, 35.934338, 21.503035, 41.41449);
        ((GeneralPath) shape).curveTo(28.88902, 41.227592, 37.02675, 35.018303, 39.895985, 32.576645);
        ((GeneralPath) shape).curveTo(30.39657, 26.592524, 24.971184, 17.814877, 21.415195, 20.003061);
        ((GeneralPath) shape).lineTo(15.91878, 23.414124);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.setStroke(new BasicStroke(1, 0, 0, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(23.848486, 22.273333);
        ((GeneralPath) shape).curveTo(24.714846, 21.524332, 29.598505, 28.360998, 38.846985, 34.655132);

        g.setPaint(new LinearGradientPaint(new Point2D.Double(19.616243362426758, 39.25298309326172), new Point2D.Double(18.48598289489746, 29.90907096862793), new float[]{0, 1}, new Color[]{new Color(0xC4A000), new Color(0xC4A000, true)}, NO_CYCLE, SRGB, new AffineTransform(0.866026f, -0.5f, 0.797961f, 1.38211f, -15.72934f, -9.277499f)));
        g.setStroke(new BasicStroke(1, 1, 0, 4));
        g.draw(shape);

        // _0_0_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(18.012894, 22.86392);
        ((GeneralPath) shape).curveTo(21.725203, 28.211416, 20.975883, 35.288177, 26.853708, 40.94503);

        g.setPaint(new LinearGradientPaint(new Point2D.Double(15.096997261047363, 36.967769622802734), new Point2D.Double(14.045431137084961, 29), new float[]{0, 1}, new Color[]{new Color(0xC4A000), new Color(0xC4A000, true)}, NO_CYCLE, SRGB, new AffineTransform(0.866026f, -0.5f, 0.843479f, 1.460948f, -19.74053f, -11.13423f)));
        g.draw(shape);

        // _0_0_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(22.983898, 22.775822);
        ((GeneralPath) shape).curveTo(22.983898, 22.775822, 31.160627, 35.84745, 34.165833, 37.880383);

        g.setPaint(new LinearGradientPaint(new Point2D.Double(14.045431137084961, 37.575889587402344), new Point2D.Double(14.045431137084961, 29), new float[]{0, 1}, new Color[]{new Color(0xC4A000), new Color(0xC4A000, true)}, NO_CYCLE, SRGB, new AffineTransform(0.866026f, -0.5f, 0.801305f, 1.3879f, -12.8183f, -11.14456f)));
        g.draw(shape);

        // _0_0_9
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(19.300308, 22.200695);
        ((GeneralPath) shape).curveTo(22.747454, 25.11751, 28.002865, 36.363884, 30.610323, 39.678444);

        g.setPaint(new LinearGradientPaint(new Point2D.Double(16.928730010986328, 34.010501861572266), new Point2D.Double(14.045431137084961, 29), new float[]{0, 1}, new Color[]{new Color(0xC4A000), new Color(0xC4A000, true)}, NO_CYCLE, SRGB, new AffineTransform(0.866026f, -0.5f, 0.861487f, 1.49214f, -17.87951f, -13.91085f)));
        g.draw(shape);

        // _0_0_10
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(8.508945, 18.061867);
        ((GeneralPath) shape).lineTo(19.970615, 11.50296);
        ((GeneralPath) shape).curveTo(20.569265, 13.885531, 19.628777, 14.743545, 21.766565, 18.650673);
        ((GeneralPath) shape).lineTo(13.856274, 23.177313);
        ((GeneralPath) shape).curveTo(12.402846, 19.699894, 10.291388, 19.767015, 8.508945, 18.061867);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(11.9966459274292, 19.59173583984375), new Point2D.Double(17.774032592773438, 16.234594345092773), new float[]{0, 0.5f, 1}, new Color[]{new Color(0xDAC203), new Color(0xFDEC69), new Color(0xFDEF7E)}, NO_CYCLE, SRGB, new AffineTransform(1.014891f, 0, 0, 1.00592f, -0.331699f, -0.140188f)));
        g.fill(shape);
        g.setPaint(new Color(0xC4A000));
        g.setStroke(new BasicStroke(1.0103954f, 1, 1, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.24725272f * origAlpha));

        // _0_0_11
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(14.043449, 21.24569);
        ((GeneralPath) shape).curveTo(13.229488, 19.824472, 11.481136, 19.009348, 10.36413, 18.11846);
        ((GeneralPath) shape).lineTo(19.121552, 13.184722);
        ((GeneralPath) shape).curveTo(19.10196, 14.66569, 19.688457, 16.272928, 19.997164, 17.703388);
        ((GeneralPath) shape).lineTo(14.043449, 21.24569);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.setStroke(new BasicStroke(1, 0, 0, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.866025f, -0.500001f, 0.5f, 0.866026f, 0, 0));

        // _0_0_12
        shape = new RoundRectangle2D.Double(-1.4127867221832275, 24.17477798461914, 13.015023231506348, 3.459890604019165, 1.9999947547912598, 1.9999960660934448);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(10.615303993225098, 28.122554779052734), new Point2D.Double(2.006974697113037, 27.234832763671875), new float[]{0, 0.5f, 1}, new Color[]{new Color(0xB30000), new Color(0xFF5C5C), new Color(0xC30000)}, NO_CYCLE, SRGB, new AffineTransform(1.1767f, 0, 0, 1.176702f, -0.819769f, -5.307055f)));
        g.fill(shape);
        g.setPaint(new Color(0x690000));
        g.setStroke(new BasicStroke(0.99999803f, 1, 0, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_12
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.583557f, 0.156364f, -0.156364f, 0.583557f, 20.45782f, 5.158782f));

        // _0_0_13
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-17.172594, 4.083618);
        ((GeneralPath) shape).curveTo(-17.172232, 4.850756, -17.581287, 5.559776, -18.245588, 5.943449);
        ((GeneralPath) shape).curveTo(-18.90989, 6.3271227, -19.728447, 6.3271227, -20.392748, 5.943449);
        ((GeneralPath) shape).curveTo(-21.057049, 5.559776, -21.466105, 4.850756, -21.465742, 4.083618);
        ((GeneralPath) shape).curveTo(-21.466105, 3.3164802, -21.057049, 2.6074607, -20.392748, 2.2237873);
        ((GeneralPath) shape).curveTo(-19.728447, 1.8401139, -18.90989, 1.8401139, -18.245588, 2.2237873);
        ((GeneralPath) shape).curveTo(-17.581287, 2.6074607, -17.172232, 3.3164802, -17.172594, 4.083618);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);
        g.setPaint(new Color(0x8F5902));
        g.setStroke(new BasicStroke(1.6552416f, 1, 1, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_13
        g.setComposite(AlphaComposite.getInstance(3, 0.31730768f * origAlpha));

        // _0_0_14
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(27.734835, 40.55524);
        ((GeneralPath) shape).curveTo(27.734835, 40.55524, 29.241419, 40.054592, 29.910933, 39.613483);
        ((GeneralPath) shape).curveTo(28.673494, 37.66894, 26.507591, 33.71782, 24.507807, 30.737564);
        ((GeneralPath) shape).curveTo(25.70105, 37.2783, 27.734835, 40.55524, 27.734835, 40.55524);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);

        // _0_0_15
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(31.141806, 39.05827);
        ((GeneralPath) shape).lineTo(33.167805, 37.9731);
        ((GeneralPath) shape).curveTo(31.223259, 36.116943, 25.699306, 27.857203, 25.699306, 27.857203);
        ((GeneralPath) shape).lineTo(31.141806, 39.05827);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        // _0_0_16
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(35.658524, 36.38781);
        ((GeneralPath) shape).lineTo(38.094894, 34.64406);
        ((GeneralPath) shape).curveTo(34.91291, 33.318233, 26.508352, 24.763609, 26.508352, 24.763609);
        ((GeneralPath) shape).curveTo(28.891289, 27.775503, 33.275585, 33.375916, 35.658524, 36.38781);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        // _0_0_17
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(39.15369, 33.91721);
        ((GeneralPath) shape).lineTo(40.846, 32.5077);
        ((GeneralPath) shape).curveTo(37.53144, 31.005098, 28.350325, 22.595682, 28.350325, 22.595682);
        ((GeneralPath) shape).curveTo(28.350325, 22.595682, 34.42491, 31.795889, 39.15369, 33.91721);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.31730765f * origAlpha));

        // _0_0_18
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(24.376076, 41.571705);
        ((GeneralPath) shape).curveTo(24.376076, 41.571705, 25.573301, 41.292027, 26.419592, 41.116085);
        ((GeneralPath) shape).curveTo(24.961184, 39.87865, 22.618504, 36.67883, 21.325825, 32.50533);
        ((GeneralPath) shape).curveTo(21.856155, 39.399624, 24.376076, 41.571705, 24.376076, 41.571705);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        // _0_0_19
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(21.370872, 41.96945);
        ((GeneralPath) shape).curveTo(21.370872, 41.96945, 22.618893, 41.955776, 22.618893, 41.955776);
        ((GeneralPath) shape).curveTo(20.320795, 39.436707, 19.480717, 36.590443, 18.188038, 32.549526);
        ((GeneralPath) shape).curveTo(18.055456, 37.234108, 21.370872, 41.96945, 21.370872, 41.96945);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

    }

    /**
     * Returns the X of the bounding box of the original SVG image.
     *
     * @return The X of the bounding box of the original SVG image.
     */
    public static int getOrigX() {
        return 5;
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
        return 44;
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
    public EditClear3() {
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

