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

import static java.awt.Color.*;
import static java.awt.MultipleGradientPaint.ColorSpaceType.SRGB;
import static java.awt.MultipleGradientPaint.CycleMethod.NO_CYCLE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class ClearSecSegModel implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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

        // _0_0_0
        shape = new Ellipse2D.Double(11.08454418182373, 12.250814437866211, 26.4830379486084, 25.968341827392578);
        g.setPaint(BLUE);
        g.fill(shape);
        g.setStroke(new BasicStroke(18.550095f, 1, 2, 4));
        g.draw(shape);

        // _0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(9.083134, 1.5812496);
        ((GeneralPath) shape).curveTo(10.764031, 0.73159695, 13.092472, 1.5846325, 13.953305, 3.0881877);
        ((GeneralPath) shape).lineTo(18.005705, 12.266054);
        ((GeneralPath) shape).curveTo(18.866537, 13.769606, 18.621222, 15.526355, 17.45567, 16.20495);
        ((GeneralPath) shape).curveTo(16.290117, 16.883545, 14.658767, 16.219406, 13.797934, 14.715854);
        ((GeneralPath) shape).lineTo(8.046709, 6.63045);
        ((GeneralPath) shape).curveTo(7.1858764, 5.1268945, 7.435487, 2.4140947, 9.083134, 1.5812496);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(12.23343276977539, 12.3632230758667), new Point2D.Double(16.870908737182617, 17.11094093322754), new float[]{0, 1}, new Color[]{new Color(0xC17D10), new Color(0x9B650C)}, NO_CYCLE, SRGB, new AffineTransform(0.9386316f, 0.25362253f, -0.2515055f, 0.94653124f, 5.23577f, -5.8868265f)));
        g.fill(shape);
        g.setPaint(new Color(0x8F5902));
        g.setStroke(new BasicStroke(0.9758228f, 1, 0, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.4230769f * origAlpha));

        // _0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(9.598116, 2.508152);
        ((GeneralPath) shape).curveTo(10.979889, 1.7477548, 12.339116, 2.3216467, 13.188996, 3.8042076);
        ((GeneralPath) shape).lineTo(17.511442, 13.564609);
        ((GeneralPath) shape).lineTo(15.148629, 14.938536);
        ((GeneralPath) shape).lineTo(9.029942, 6.4035535);
        ((GeneralPath) shape).curveTo(8.180062, 4.920993, 8.178455, 3.2893984, 9.598116, 2.508152);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(9.56215763092041, 6.952558994293213), new Point2D.Double(14.766724586486816, 14.200403213500977), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(0.97174275f, 0, 0, 0.9676482f, 2.3622572f, -0.1392468f)));
        g.setStroke(new BasicStroke(0.9752113f, 1, 0, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_3
        shape = new Ellipse2D.Double(28.295656204223633, 11.476043701171875, 9.105976104736328, 10.200495719909668);
        g.setPaint(GREEN);
        g.fill(shape);
        g.setStroke(new BasicStroke(6.817325f, 1, 2, 4));
        g.draw(shape);

        // _0_0_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(16.72544, 21.916908);
        ((GeneralPath) shape).curveTo(15.952423, 26.065056, 17.341492, 35.41802, 22.807804, 40.97377);
        ((GeneralPath) shape).curveTo(27.03173, 41.11049, 36.402573, 37.666656, 42.758747, 31.106623);
        ((GeneralPath) shape).curveTo(33.78356, 26.736036, 27.661238, 15.892312, 22.900885, 18.253668);
        ((GeneralPath) shape).lineTo(16.72544, 21.916908);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(20.764476776123047, 19.540945053100586), 14.799585f, new Point2D.Double(20.764476776123047, 19.540945053100586), new float[]{0, 0.5f, 1}, new Color[]{new Color(0xFEF088), new Color(0xFDE63A), new Color(0xDAC203)}, NO_CYCLE, SRGB, new AffineTransform(0.43669924f, -0.2094881f, 0.54846716f, 1.1337131f, 0.9704418f, 2.3244896f)));
        g.fill(shape);
        g.setPaint(new Color(0xC4A000));
        g.setStroke(new BasicStroke(0.9696938f, 0, 0, 4));
        g.draw(shape);

        // _0_0_5
        shape = new Ellipse2D.Double(11.731539726257324, 16.043880462646484, 7.165430068969727, 10.79175090789795);
        g.setPaint(GREEN);
        g.fill(shape);
        g.setStroke(new BasicStroke(6.2202406f, 1, 2, 4));
        g.draw(shape);

        // _0_0_6
        shape = new Ellipse2D.Double(18.168060302734375, 31.954301834106445, 7.165430068969727, 10.79175090789795);
        g.fill(shape);
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.46153846f * origAlpha));

        // _0_0_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(17.831217, 22.517387);
        ((GeneralPath) shape).curveTo(16.944897, 23.009054, 17.67537, 34.63255, 23.257675, 39.935413);
        ((GeneralPath) shape).curveTo(30.434954, 39.754562, 38.342735, 33.746155, 41.130894, 31.383486);
        ((GeneralPath) shape).curveTo(31.899904, 25.59296, 26.627825, 17.099285, 23.17232, 19.216679);
        ((GeneralPath) shape).lineTo(17.831217, 22.517387);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.setStroke(new BasicStroke(0.96969306f, 0, 0, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(25.53685, 21.413504);
        ((GeneralPath) shape).curveTo(26.37873, 20.688734, 31.12439, 27.304222, 40.111534, 33.39473);

        g.setPaint(new LinearGradientPaint(new Point2D.Double(19.616243362426758, 39.25298309326172), new Point2D.Double(18.48598289489746, 29.90907096862793), new float[]{0, 1}, new Color[]{new Color(0xC4A000), new Color(0xC4A000, true)}, NO_CYCLE, SRGB, new AffineTransform(0.84155446f, -0.4838241f, 0.7754128f, 1.3373963f, -12.922614f, -9.116603f)));
        g.setStroke(new BasicStroke(0.969693f, 1, 0, 4));
        g.draw(shape);

        // _0_0_9
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(19.866156, 21.984985);
        ((GeneralPath) shape).curveTo(23.473566, 27.15948, 22.74542, 34.007294, 28.457155, 39.48114);

        g.setPaint(new LinearGradientPaint(new Point2D.Double(15.096997261047363, 36.967769622802734), new Point2D.Double(14.045431137084961, 29), new float[]{0, 1}, new Color[]{new Color(0xC4A000), new Color(0xC4A000, true)}, NO_CYCLE, SRGB, new AffineTransform(0.84155446f, -0.4838241f, 0.8196446f, 1.4136837f, -16.82046f, -10.913265f)));
        g.setStroke(new BasicStroke(0.96969354f, 1, 0, 4));
        g.draw(shape);

        // _0_0_10
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(24.696693, 21.899736);
        ((GeneralPath) shape).curveTo(24.696693, 21.899736, 32.642372, 34.548473, 35.562656, 36.515636);

        g.setPaint(new LinearGradientPaint(new Point2D.Double(14.045431137084961, 37.575889587402344), new Point2D.Double(14.045431137084961, 29), new float[]{0, 1}, new Color[]{new Color(0xC4A000), new Color(0xC4A000, true)}, NO_CYCLE, SRGB, new AffineTransform(0.84155446f, -0.4838241f, 0.7786623f, 1.342999f, -10.093832f, -10.923261f)));
        g.draw(shape);

        // _0_0_11
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(21.117191, 21.343216);
        ((GeneralPath) shape).curveTo(24.46693, 24.165667, 29.57384, 35.0482, 32.107616, 38.25553);

        g.setPaint(new LinearGradientPaint(new Point2D.Double(16.928730010986328, 34.010501861572266), new Point2D.Double(14.045431137084961, 29), new float[]{0, 1}, new Color[]{new Color(0xC4A000), new Color(0xC4A000, true)}, NO_CYCLE, SRGB, new AffineTransform(0.84155446f, -0.4838241f, 0.8371438f, 1.4438666f, -15.012026f, -13.600056f)));
        g.setStroke(new BasicStroke(0.9696934f, 1, 0, 4));
        g.draw(shape);

        // _0_0_12
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(8.869056, 15.603383);
        ((GeneralPath) shape).lineTo(21.8035, 8.34554);
        ((GeneralPath) shape).curveTo(22.479073, 10.982006, 21.417734, 11.931452, 23.830221, 16.254934);
        ((GeneralPath) shape).lineTo(14.903493, 21.263948);
        ((GeneralPath) shape).curveTo(13.263305, 17.415962, 10.880534, 17.490236, 8.869056, 15.603383);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(11.9966459274292, 19.59173583984375), new Point2D.Double(17.774032592773438, 16.234594345092773), new float[]{0, 0.5f, 1}, new Color[]{new Color(0xDAC203), new Color(0xFDEC69), new Color(0xFDEF7E)}, NO_CYCLE, SRGB, new AffineTransform(1.1452999f, 0, 0, 1.113114f, -1.1075699f, -4.538338f)));
        g.fill(shape);
        g.setPaint(new Color(0xC4A000));
        g.setStroke(new BasicStroke(1.1290921f, 1, 1, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.2472527f * origAlpha));

        // _0_0_13
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(15.200609, 19.38307);
        ((GeneralPath) shape).curveTo(14.282058, 17.810406, 12.30905, 16.908417, 11.048514, 15.922595);
        ((GeneralPath) shape).lineTo(20.931225, 10.463102);
        ((GeneralPath) shape).curveTo(20.909115, 12.101887, 21.570974, 13.880397, 21.919348, 15.463292);
        ((GeneralPath) shape).lineTo(15.200609, 19.38307);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.setStroke(new BasicStroke(1.1174755f, 0, 0, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.8702221f, -0.49265963f, 0.50737715f, 0.86172414f, 0, 0));

        // _0_0_14
        shape = new RoundRectangle2D.Double(-0.05050160735845566, 22.973888397216797, 14.616555213928223, 3.847700357437134, 2.2460994720458984, 2.224170446395874);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(10.615303993225098, 28.122554779052734), new Point2D.Double(2.006974697113037, 27.234832763671875), new float[]{0, 0.5f, 1}, new Color[]{new Color(0xB30000), new Color(0xFF5C5C), new Color(0xC30000)}, NO_CYCLE, SRGB, new AffineTransform(1.3214961f, 0, 0, 1.3085954f, 0.6154867f, -9.812483f)));
        g.fill(shape);
        g.setPaint(new Color(0x690000));
        g.setStroke(new BasicStroke(1.117554f, 1, 0, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_14
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.9671734f, 0.2541173f, -0.26359624f, 0.9646331f, 0, 0));

        // _0_0_15
        shape = new Ellipse2D.Double(10.157252311706543, 0.22307610511779785, 2.9231739044189453, 2.873910665512085);
        g.setPaint(WHITE);
        g.fill(shape);
        g.setPaint(new Color(0x8F5902));
        g.setStroke(new BasicStroke(1.1175048f, 1, 1, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_15
        g.setComposite(AlphaComposite.getInstance(3, 0.3173077f * origAlpha));

        // _0_0_16
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(29.313381, 39.10396);
        ((GeneralPath) shape).curveTo(29.313381, 39.10396, 30.777393, 38.619507, 31.427988, 38.19267);
        ((GeneralPath) shape).curveTo(30.22552, 36.311035, 28.120817, 32.48774, 26.177542, 29.603903);
        ((GeneralPath) shape).curveTo(27.337067, 35.933037, 29.313381, 39.10396, 29.313381, 39.10396);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);

        // _0_0_17
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(32.62408, 37.65542);
        ((GeneralPath) shape).lineTo(34.59283, 36.605354);
        ((GeneralPath) shape).curveTo(32.70323, 34.80925, 27.335373, 26.816725, 27.335373, 26.816725);
        ((GeneralPath) shape).lineTo(32.62408, 37.65542);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        // _0_0_18
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.01317, 35.07135);
        ((GeneralPath) shape).lineTo(39.380695, 33.384014);
        ((GeneralPath) shape).curveTo(36.288628, 32.10108, 28.121557, 23.823214, 28.121557, 23.823214);
        ((GeneralPath) shape).curveTo(30.437157, 26.737669, 34.697567, 32.1569, 37.01317, 35.07135);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        // _0_0_19
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(40.409573, 32.68068);
        ((GeneralPath) shape).lineTo(42.054066, 31.31677);
        ((GeneralPath) shape).curveTo(38.83316, 29.862782, 29.911482, 21.725426, 29.911482, 21.725426);
        ((GeneralPath) shape).curveTo(29.911482, 21.725426, 35.814415, 30.627987, 40.409573, 32.68068);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.31730765f * origAlpha));

        // _0_0_20
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(26.049534, 40.08754);
        ((GeneralPath) shape).curveTo(26.049534, 40.08754, 27.212929, 39.81691, 28.035305, 39.64666);
        ((GeneralPath) shape).curveTo(26.618107, 38.449257, 24.341623, 35.35296, 23.085474, 31.31448);
        ((GeneralPath) shape).curveTo(23.600819, 37.98573, 26.049534, 40.08754, 26.049534, 40.08754);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

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
        return 1;
    }

    /**
     * Returns the width of the bounding box of the original SVG image.
     *
     * @return The width of the bounding box of the original SVG image.
     */
    public static int getOrigWidth() {
        return 46;
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
    public ClearSecSegModel() {
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

