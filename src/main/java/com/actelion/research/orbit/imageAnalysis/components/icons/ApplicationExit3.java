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
import java.awt.geom.*;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static java.awt.MultipleGradientPaint.ColorSpaceType.SRGB;
import static java.awt.MultipleGradientPaint.CycleMethod.NO_CYCLE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class ApplicationExit3 implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.setComposite(AlphaComposite.getInstance(3, 0.7f * origAlpha));

        // _0_0_0
        shape = new RoundRectangle2D.Double(12, 1, 35, 45, 1.9889464378356934, 2.00976824760437);
        g.setPaint(new Color(0x50000000, true));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_1
        shape = new RoundRectangle2D.Double(13.500009536743164, 2.500009059906006, 31.999980926513672, 41.99998092651367, 1.414406180381775, 1.416163682937622);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(93.78003692626953, 40.54505157470703), 16.321514f, new Point2D.Double(93.78003692626953, 40.54505157470703), new float[]{0, 1}, new Color[]{new Color(0x505050), new Color(0x181818)}, NO_CYCLE, SRGB, new AffineTransform(2.01827f, 0, 0, 2.643808f, -144.57335f, -62.192135f)));
        g.fill(shape);
        g.setPaint(BLACK);
        g.setStroke(new BasicStroke(1.0000198f, 0, 0, 10));
        g.draw(shape);

        // _0_0_2
        shape = new Rectangle2D.Double(13.999631881713867, 31.736305236816406, 30.999998092651367, 12.263458251953125);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(30.93592071533203, 43.75735855102539), new Point2D.Double(30.93592071533203, 28.112619400024414), new float[]{0, 1}, new Color[]{new Color(0x727E0A), new Color(0x727E0A, true)}, NO_CYCLE, SRGB, new AffineTransform(1.025512f, 0, 0, 0.648342f, -0.8658636f, 15.630022f)));
        g.fill(shape);

        // _0_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(14.037294, 43.944622);
        ((GeneralPath) shape).lineTo(13.998461, 3.0542872);
        ((GeneralPath) shape).lineTo(33.940758, 3.0984814);
        ((GeneralPath) shape).lineTo(33.98495, 33.017937);
        ((GeneralPath) shape).lineTo(14.037294, 43.944622);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(46.8458251953125, 19.80411720275879), new Point2D.Double(18.031221389770508, 27.759069442749023), new float[]{0, 1}, new Color[]{new Color(0x4E4E4E), new Color(0xABABAB)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, -3.6735027E-4f, -2.381E-4f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.42222223f * origAlpha));

        // _0_0_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(13.969433, 43.944622);
        ((GeneralPath) shape).lineTo(34.117535, 33.06213);
        ((GeneralPath) shape).lineTo(15.555981, 41.989353);
        ((GeneralPath) shape).lineTo(15.555981, 3.0100925);
        ((GeneralPath) shape).lineTo(13.985518, 3.0100925);
        ((GeneralPath) shape).lineTo(13.969433, 43.944622);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.2994652f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.77849f, 0, 0, 0.77849f, -7.5801826f, 1.5979009f));

        // _0_0_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(40.48186, 36.421127);
        ((GeneralPath) shape).curveTo(40.483814, 39.421745, 37.50237, 42.19488, 32.66107, 43.69549);
        ((GeneralPath) shape).curveTo(27.81977, 45.196106, 21.854479, 45.196106, 17.01318, 43.69549);
        ((GeneralPath) shape).curveTo(12.17188, 42.19488, 9.190436, 39.421745, 9.192389, 36.421127);
        ((GeneralPath) shape).curveTo(9.190436, 33.42051, 12.17188, 30.647373, 17.01318, 29.14676);
        ((GeneralPath) shape).curveTo(21.854479, 27.646149, 27.81977, 27.646149, 32.66107, 29.14676);
        ((GeneralPath) shape).curveTo(37.50237, 30.647373, 40.483814, 33.42051, 40.48186, 36.421127);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(24.837125778198242, 36.42112731933594), 15.644737f, new Point2D.Double(24.837125778198242, 36.42112731933594), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 0.536723f, 0, 16.87306f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_5
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1.7314304, 17.59358);
        ((GeneralPath) shape).lineTo(1.7314304, 30.355125);
        ((GeneralPath) shape).lineTo(9.663735, 30.355125);
        ((GeneralPath) shape).lineTo(9.663735, 36.175907);
        ((GeneralPath) shape).lineTo(21.887377, 23.952265);
        ((GeneralPath) shape).lineTo(9.590974, 11.655863);
        ((GeneralPath) shape).lineTo(9.590974, 17.596828);
        ((GeneralPath) shape).lineTo(1.7314304, 17.59358);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(11.131293296813965, 15.165678024291992), new Point2D.Double(11.118230819702148, 32.401405334472656), new float[]{0, 1}, new Color[]{new Color(0xDA3F3F), new Color(0xC22F2F)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, -3.6735027E-4f, -2.381E-4f)));
        g.fill(shape);
        g.setPaint(new Color(0xA40000));
        g.setStroke(new BasicStroke(1, 1, 1, 10));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.4812834f * origAlpha));

        // _0_0_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(2.7189574, 18.399748);
        ((GeneralPath) shape).lineTo(2.7189574, 29.535791);
        ((GeneralPath) shape).lineTo(10.552776, 29.535791);
        ((GeneralPath) shape).lineTo(10.552776, 33.79374);
        ((GeneralPath) shape).lineTo(20.404228, 23.948168);
        ((GeneralPath) shape).lineTo(10.488209, 13.684476);
        ((GeneralPath) shape).lineTo(10.488209, 18.40263);
        ((GeneralPath) shape).lineTo(2.7189574, 18.399748);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(8.760064125061035, 13.663073539733887), new Point2D.Double(19.75554847717285, 43.449947357177734), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, -3.6735027E-4f, -2.381E-4f)));
        g.setStroke(new BasicStroke(1, 0, 0, 10));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(14.044443, 43.757122);
        ((GeneralPath) shape).lineTo(13.999632, 3.0542872);
        ((GeneralPath) shape).lineTo(33.940758, 3.0542872);
        ((GeneralPath) shape).lineTo(33.761513, 33.68085);
        ((GeneralPath) shape).lineTo(14.044443, 43.757122);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(27.883882522583008, 7.139606952667236), 9.722718f, new Point2D.Double(27.883882522583008, 7.139606952667236), new float[]{0, 1}, new Color[]{new Color(0x4E4E4E), new Color(0x616161, true)}, NO_CYCLE, SRGB, new AffineTransform(2.565823f, 0, 0, 1.403262f, -37.7836f, -9.483541f)));
        g.fill(shape);

        // _0_0_9
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(29.642656, 18.455957);
        ((GeneralPath) shape).lineTo(31.565104, 20.908733);
        ((GeneralPath) shape).lineTo(30.106695, 25.725899);
        ((GeneralPath) shape).curveTo(30.106695, 25.725899, 30.37186, 27.2285, 31.14526, 26.212034);
        ((GeneralPath) shape).curveTo(31.918657, 25.195568, 34.117714, 22.62998, 33.730618, 20.754053);
        ((GeneralPath) shape).curveTo(33.443356, 19.361937, 32.64786, 18.699024, 32.64786, 18.699024);
        ((GeneralPath) shape).lineTo(29.642656, 18.455957);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(31.852951049804688, 19.107728958129883), new Point2D.Double(34.007415771484375, 24.764583587646484), new float[]{0, 1}, new Color[]{new Color(0x525252), new Color(0x525252, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, -1.1164876f, -2.381E-4f)));
        g.fill(shape);

        // _0_0_10
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(31.476715, 17.351103);
        ((GeneralPath) shape).curveTo(31.476715, 17.351103, 33.639984, 18.35282, 33.708523, 19.229355);
        ((GeneralPath) shape).curveTo(33.810303, 20.531076, 29.46588, 24.665237, 29.46588, 24.665237);
        ((GeneralPath) shape).curveTo(28.957647, 25.283957, 28.117958, 24.73153, 28.581997, 24.134909);
        ((GeneralPath) shape).curveTo(28.581997, 24.134909, 32.0486, 20.016935, 31.830269, 19.693394);
        ((GeneralPath) shape).curveTo(31.556658, 19.287935, 29.863628, 18.65483, 29.863628, 18.65483);
        ((GeneralPath) shape).curveTo(28.847162, 17.90353, 30.131248, 16.349367, 31.476715, 17.351103);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(31.078954696655273, 21.511184692382812), new Point2D.Double(33.71065139770508, 18.06403923034668), new float[]{0, 1}, new Color[]{new Color(0xCECECE), new Color(0x9E9E9E)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, -3.6735027E-4f, -2.381E-4f)));
        g.fill(shape);

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
        return 47;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     *
     * @return The height of the bounding box of the original SVG image.
     */
    public static int getOrigHeight() {
        return 45;
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
    public ApplicationExit3() {
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

