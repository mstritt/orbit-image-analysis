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
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import static java.awt.MultipleGradientPaint.ColorSpaceType.SRGB;
import static java.awt.MultipleGradientPaint.CycleMethod.NO_CYCLE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class CellClassMarker implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.transform(new AffineTransform(1.0666667f, 0, 0, 1.0666667f, 0, 0));

        // _0
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 0, -343.70078f));

        // _0_0

        // _0_0_0
        shape = new Ellipse2D.Double(70.71428680419922, 378.0765380859375, 243.57142639160156, 318.5714416503906);
        g.setPaint(RED);
        g.fill(shape);
        g.setPaint(new Color(0xFFE800));
        g.setStroke(new BasicStroke(50, 0, 0, 4));
        g.draw(shape);

        // _0_0_1
        shape = new Ellipse2D.Double(378.21429443359375, 410.2193603515625, 243.57142639160156, 318.5714416503906);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[]{0, 1}, new Color[]{new Color(0x00FF11), new Color(0xFF2A2A, true)}, NO_CYCLE, SRGB, new AffineTransform(2.0658255f, 0.05247343f, -0.06084545f, 2.3954277f, -6.313918f, -947.01733f)));
        g.fill(shape);
        g.setPaint(new Color(0xFFE800));
        g.draw(shape);

        // _0_0_2
        shape = new Ellipse2D.Double(275.0675048828125, 716.3582763671875, 159.86502075195312, 220.57931518554688);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[]{0, 1}, new Color[]{new Color(0x00FF11), new Color(0xFF2A2A, true)}, NO_CYCLE, SRGB, new AffineTransform(1.3558784f, 0.03633268f, -0.03993514f, 1.6585975f, 22.687296f, -223.39435f)));
        g.fill(shape);
        g.setPaint(new Color(0xFFE800));
        g.setStroke(new BasicStroke(33.706413f, 0, 0, 4));
        g.draw(shape);

        // _0_0_3
        shape = new Ellipse2D.Double(506.4156799316406, 752.7064208984375, 180.0258026123047, 265.7401123046875);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[]{0, 1}, new Color[]{new Color(0x00FF11), new Color(0xFF2A2A, true)}, NO_CYCLE, SRGB, new AffineTransform(1.5268699f, 0.04377133f, -0.04497141f, 1.9981741f, 222.20747f, -379.44843f)));
        g.fill(shape);
        g.setPaint(new Color(0xFFE800));
        g.setStroke(new BasicStroke(39.259914f, 0, 0, 4));
        g.draw(shape);

        // _0_0_4
        shape = new Ellipse2D.Double(136.5498809814453, 882.1263427734375, 143.328857421875, 154.0431671142578);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[]{0, 1}, new Color[]{new Color(0x00FF11), new Color(0xFF2A2A, true)}, NO_CYCLE, SRGB, new AffineTransform(1.2156287f, 0.02537319f, -0.03580432f, 1.1582936f, -89.72461f, 225.8433f)));
        g.fill(shape);
        g.setPaint(new Color(0xFFE800));
        g.setStroke(new BasicStroke(26.671133f, 0, 0, 4));
        g.draw(shape);

        // _0_0_5
        shape = new Ellipse2D.Double(30.60478973388672, 724.0383911132812, 133.07611083984375, 160.21897888183594);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[]{0, 1}, new Color[]{new Color(0x00FF11), new Color(0xFF2A2A, true)}, NO_CYCLE, SRGB, new AffineTransform(1.128671f, 0.02639044f, -0.03324313f, 1.2047313f, -179.48354f, 41.444046f)));
        g.fill(shape);
        g.setPaint(new Color(0xFFE800));
        g.setStroke(new BasicStroke(26.209602f, 0, 0, 4));
        g.draw(shape);

        // _0_0_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(91.45387, 752.9883);
        ((GeneralPath) shape).lineTo(166.17111, 846.64734);
        ((GeneralPath) shape).lineTo(184.85052, 900.45154);
        ((GeneralPath) shape).lineTo(217.5394, 928.3498);
        ((GeneralPath) shape).lineTo(212.86958, 970.19745);
        ((GeneralPath) shape).lineTo(423.0119, 966.212);
        ((GeneralPath) shape).lineTo(425.34692, 920.37885);
        ((GeneralPath) shape).lineTo(455.70078, 908.4223);
        ((GeneralPath) shape).lineTo(453.366, 858.6039);
        ((GeneralPath) shape).lineTo(476.715, 840.669);
        ((GeneralPath) shape).lineTo(486.05472, 715.1262);
        ((GeneralPath) shape).lineTo(413.6722, 673.27856);
        ((GeneralPath) shape).lineTo(378.64847, 651.3582);
        ((GeneralPath) shape).lineTo(334.2851, 651.3582);
        ((GeneralPath) shape).lineTo(303.93124, 633.4236);
        ((GeneralPath) shape).lineTo(254.89796, 625.4526);
        ((GeneralPath) shape).lineTo(250.22816, 543.7501);
        ((GeneralPath) shape).lineTo(233.88382, 527.8081);
        ((GeneralPath) shape).lineTo(201.19489, 527.8081);
        ((GeneralPath) shape).lineTo(184.85057, 549.7282);
        ((GeneralPath) shape).lineTo(182.51578, 737.0464);
        ((GeneralPath) shape).lineTo(161.50134, 739.03906);
        ((GeneralPath) shape).lineTo(133.48251, 713.1334);
        ((GeneralPath) shape).lineTo(96.12375, 715.12634);
        ((GeneralPath) shape).lineTo(91.453926, 752.98846);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0

        g.setTransform(transformations.poll()); // _0

    }

    /**
     * Returns the X of the bounding box of the original SVG image.
     *
     * @return The X of the bounding box of the original SVG image.
     */
    public static int getOrigX() {
        return 19;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     *
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 11;
    }

    /**
     * Returns the width of the bounding box of the original SVG image.
     *
     * @return The width of the bounding box of the original SVG image.
     */
    public static int getOrigWidth() {
        return 735;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     *
     * @return The height of the bounding box of the original SVG image.
     */
    public static int getOrigHeight() {
        return 743;
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
    public CellClassMarker() {
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

