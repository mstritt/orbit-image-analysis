/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2016 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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
public class SystemLogOut3 implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        shape = new RoundRectangle2D.Double(1.4809070825576782, 2.5692098140716553, 31.99555015563965, 41.9420280456543, 1.4142104387283325, 1.4142096042633057);
        g.setPaint(new Color(0xEEEEEC));
        g.fill(shape);
        g.setPaint(new Color(0x555753));
        g.setStroke(new BasicStroke(1, 0, 0, 10));
        g.draw(shape);

        // _0_0_1
        shape = new Rectangle2D.Double(1.9791847467422485, 17.24085235595703, 30.999998092651367, 26.75914764404297);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(18.729185104370117, 44), new Point2D.Double(18.729185104370117, 29.06801414489746), new float[]{0, 1}, new Color[]{new Color(0xBABDB6), new Color(0xBABDB6, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.5542857f * origAlpha));

        // _0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(2.1041846, 43.875);
        ((GeneralPath) shape).lineTo(23.479185, 35.0);
        ((GeneralPath) shape).curveTo(23.479185, 35.0, 26.992725, 32.780415, 23.729185, 31.5);
        ((GeneralPath) shape).curveTo(20.314184, 30.16016, 16.729185, 32.0, 16.729185, 32.0);
        ((GeneralPath) shape).lineTo(2.1041846, 43.875);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(2.0168467, 43.94486);
        ((GeneralPath) shape).lineTo(1.9780138, 3.0545251);
        ((GeneralPath) shape).lineTo(21.92031, 3.0987194);
        ((GeneralPath) shape).lineTo(21.964504, 33.018173);
        ((GeneralPath) shape).lineTo(2.0168467, 43.94486);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(46.8458251953125, 19.80411720275879), new Point2D.Double(18.031221389770508, 27.759069442749023), new float[]{0, 1}, new Color[]{new Color(0x4E4E4E), new Color(0xABABAB)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, -12.020815f, 0)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.42222223f * origAlpha));

        // _0_0_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1.9489857, 43.94486);
        ((GeneralPath) shape).lineTo(22.097088, 33.06237);
        ((GeneralPath) shape).lineTo(3.5355337, 41.989594);
        ((GeneralPath) shape).lineTo(3.5355337, 3.0103307);
        ((GeneralPath) shape).lineTo(1.9650707, 3.0103307);
        ((GeneralPath) shape).lineTo(1.9489857, 43.94486);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(2.0239956, 43.75736);
        ((GeneralPath) shape).lineTo(1.9791847, 3.0545251);
        ((GeneralPath) shape).lineTo(21.92031, 3.0545251);
        ((GeneralPath) shape).lineTo(21.741064, 33.681087);
        ((GeneralPath) shape).lineTo(2.0239956, 43.75736);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(27.883882522583008, 7.139606952667236), 9.722718f, new Point2D.Double(27.883882522583008, 7.139606952667236), new float[]{0, 1}, new Color[]{new Color(0x4E4E4E), new Color(0x616161, true)}, NO_CYCLE, SRGB, new AffineTransform(2.565823f, 0, 0, 1.403262f, -49.804047f, -9.483303f)));
        g.fill(shape);

        // _0_0_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(17.62221, 18.456196);
        ((GeneralPath) shape).lineTo(19.544657, 20.908972);
        ((GeneralPath) shape).lineTo(18.086248, 25.726135);
        ((GeneralPath) shape).curveTo(18.086248, 25.726135, 18.351414, 27.228739, 19.124811, 26.212273);
        ((GeneralPath) shape).curveTo(19.89821, 25.195807, 22.097267, 22.630219, 21.71017, 20.754292);
        ((GeneralPath) shape).curveTo(21.422909, 19.362175, 20.627415, 18.699263, 20.627415, 18.699263);
        ((GeneralPath) shape).lineTo(17.62221, 18.456196);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(31.852951049804688, 19.107728958129883), new Point2D.Double(34.007415771484375, 24.764583587646484), new float[]{0, 1}, new Color[]{new Color(0x525252), new Color(0x525252, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, -13.136935f, 0)));
        g.fill(shape);

        // _0_0_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(19.456268, 17.35134);
        ((GeneralPath) shape).curveTo(19.456268, 17.35134, 21.61954, 18.353058, 21.688074, 19.229593);
        ((GeneralPath) shape).curveTo(21.789854, 20.531315, 17.445433, 24.665476, 17.445433, 24.665476);
        ((GeneralPath) shape).curveTo(16.9372, 25.284195, 16.097511, 24.731768, 16.56155, 24.135145);
        ((GeneralPath) shape).curveTo(16.56155, 24.135145, 20.028154, 20.017174, 19.809822, 19.69363);
        ((GeneralPath) shape).curveTo(19.536211, 19.288174, 17.843182, 18.655067, 17.843182, 18.655067);
        ((GeneralPath) shape).curveTo(16.826715, 17.903769, 18.110802, 16.349606, 19.456268, 17.35134);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(31.078954696655273, 21.511184692382812), new Point2D.Double(33.71065139770508, 18.06403923034668), new float[]{0, 1}, new Color[]{new Color(0xCECECE), new Color(0x9E9E9E)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, -12.020815f, 0)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.8742857f * origAlpha));

        // _0_0_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(22.229185, 3.5);
        ((GeneralPath) shape).lineTo(21.729185, 33.25);
        ((GeneralPath) shape).lineTo(3.7291846, 43.0);
        ((GeneralPath) shape).lineTo(32.979183, 43.25);
        ((GeneralPath) shape).lineTo(32.729183, 3.5);
        ((GeneralPath) shape).lineTo(22.229185, 3.5);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(40.25, 31.625), new Point2D.Double(40.25, 43.25), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, -12.020815f, 0)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-1, 0, 0, 1, 48.201366f, -0.047335f));

        // _0_0_9
        g.setComposite(AlphaComposite.getInstance(3, 0.2994652f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.77849f, 0, 0, 0.77849f, -7.579815f, 1.598139f));

        // _0_0_9_0
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

        g.setTransform(transformations.poll()); // _0_0_9_0
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_9_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(1.731798, 17.593819);
        ((GeneralPath) shape).lineTo(1.731798, 30.355364);
        ((GeneralPath) shape).lineTo(9.6641035, 30.355364);
        ((GeneralPath) shape).lineTo(9.6641035, 36.176147);
        ((GeneralPath) shape).lineTo(21.887745, 23.952503);
        ((GeneralPath) shape).lineTo(9.591343, 11.656101);
        ((GeneralPath) shape).lineTo(9.591343, 17.597067);
        ((GeneralPath) shape).lineTo(1.731798, 17.593819);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xCC0000));
        g.fill(shape);
        g.setPaint(new Color(0xA40000));
        g.setStroke(new BasicStroke(1, 1, 1, 10));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.5080214f * origAlpha));

        // _0_0_9_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(9.924008, 12.478043);
        ((GeneralPath) shape).lineTo(9.924008, 18.115662);
        ((GeneralPath) shape).lineTo(2.074615, 18.115662);
        ((GeneralPath) shape).lineTo(2.074615, 24.53144);
        ((GeneralPath) shape).curveTo(12.332521, 20.703863, 11.954992, 27.773987, 21.29428, 23.94641);
        ((GeneralPath) shape).lineTo(9.924008, 12.478043);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(19.701141357421875, 2.8969380855560303), 17.171415f, new Point2D.Double(19.701141357421875, 2.8969380855560303), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1.253442f, 0, 0, 0.9539f, -15.47908f, 11.27663f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.4812834f * origAlpha));

        // _0_0_9_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(2.6834412, 18.565933);
        ((GeneralPath) shape).lineTo(2.6834412, 29.355867);
        ((GeneralPath) shape).lineTo(10.584702, 29.355867);
        ((GeneralPath) shape).lineTo(10.584702, 33.48148);
        ((GeneralPath) shape).lineTo(20.127981, 23.941908);
        ((GeneralPath) shape).lineTo(10.522155, 13.997214);
        ((GeneralPath) shape).lineTo(10.522155, 18.568726);
        ((GeneralPath) shape).lineTo(2.6834412, 18.565933);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(8.760064125061035, 13.663073539733887), new Point2D.Double(19.75554847717285, 43.449947357177734), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(0.968718f, 0, 0, 0.9689198f, 0.3616813f, 0.7378237f)));
        g.setStroke(new BasicStroke(1, 0, 0, 10));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_9

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
        return 48;
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
    public SystemLogOut3() {
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

