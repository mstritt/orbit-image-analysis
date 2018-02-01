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
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

import static java.awt.Color.*;
import static java.awt.MultipleGradientPaint.ColorSpaceType.SRGB;
import static java.awt.MultipleGradientPaint.CycleMethod.NO_CYCLE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class PrimarySeg implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.setComposite(AlphaComposite.getInstance(3, 0.2f * origAlpha));

        // _0_0_0
        shape = new Ellipse2D.Double(13.03569221496582, 20.21078109741211, 20.357166290283203, 5.057076454162598);
        g.setPaint(new RadialGradientPaint(new Point2D.Double(23.8125, 43), 16.375f, new Point2D.Double(23.8125, 43), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(0.6215929f, 0, 0, 0.15441418f, 8.412596f, 16.099491f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(19.142853, 18.770922);
        ((GeneralPath) shape).lineTo(29.030619, 18.770922);
        ((GeneralPath) shape).lineTo(24.086735, 23.827991);
        ((GeneralPath) shape).lineTo(19.142853, 18.770922);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(22.750001907348633, 40.000755310058594), new Point2D.Double(22.750001907348633, 37.4096794128418), new float[]{0, 1}, new Color[]{new Color(0xFECB81), new Color(0xFCAF3E)}, NO_CYCLE, SRGB, new AffineTransform(0.5816329f, 0, 0, 0.56189734f, 10.127541f, -1.1764357f)));
        g.fill(shape);
        g.setPaint(new LinearGradientPaint(new Point2D.Double(17.25, 41.147342681884766), new Point2D.Double(17.25, 36.10343933105469), new float[]{0, 1}, new Color[]{new Color(0xCE5C00), new Color(0xF57900)}, NO_CYCLE, SRGB, new AffineTransform(0.5816329f, 0, 0, 0.56189734f, 10.127541f, -1.1764357f)));
        g.setStroke(new BasicStroke(0.57168025f, 1, 1, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.7f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 0, 2));

        // _0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(17.820312, 34.5);
        ((GeneralPath) shape).lineTo(24.0, 41.04297);
        ((GeneralPath) shape).lineTo(30.179688, 34.5);
        ((GeneralPath) shape).lineTo(17.820312, 34.5);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(18.875, 35.183414459228516), new Point2D.Double(18.875, 43.97861099243164), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.setStroke(new BasicStroke(1, 1, 0, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_2
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(18.561218, 1.3872209);
        ((GeneralPath) shape).lineTo(16.234686, 5.0473437);
        ((GeneralPath) shape).lineTo(16.234686, 17.120344);
        ((GeneralPath) shape).lineTo(31.938774, 17.120344);
        ((GeneralPath) shape).lineTo(31.938774, 5.0473437);
        ((GeneralPath) shape).lineTo(29.612244, 1.3872209);
        ((GeneralPath) shape).lineTo(18.561218, 1.3872209);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(31.742900848388672, -0.1937265396118164), new Point2D.Double(9.897525787353516, 20.30753517150879), new float[]{0, 1}, new Color[]{new Color(0x729FCF), new Color(0xADC7E3)}, NO_CYCLE, SRGB, new AffineTransform(0.5816329f, 0, 0, 0.56189734f, 10.127541f, -1.1413171f)));
        g.fill(shape);
        g.setPaint(new Color(0x3465A4));
        g.setStroke(new BasicStroke(0.5716802f, 1, 0, 4));
        g.draw(shape);

        // _0_0_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(16.525503, 5.0395627);
        ((GeneralPath) shape).lineTo(31.64797, 5.0395627);
        ((GeneralPath) shape).lineTo(31.64797, 16.839397);
        ((GeneralPath) shape).lineTo(16.525503, 16.839397);
        ((GeneralPath) shape).lineTo(16.525503, 5.0395627);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(8.075193405151367, 5.041107177734375), new Point2D.Double(18.704320907592773, 33), new float[]{0, 1}, new Color[]{new Color(0x3465A4), new Color(0x729FCF)}, NO_CYCLE, SRGB, new AffineTransform(0.5816329f, 0, 0, 0.56189734f, 10.127541f, -1.1413171f)));
        g.fill(shape);

        // _0_0_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(16.816319, 5.320502);
        ((GeneralPath) shape).lineTo(31.357143, 5.320502);

        g.setPaint(new Color(0xB5CEE7));
        g.setStroke(new BasicStroke(0.57167995f, 2, 0, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));

        // _0_0_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(18.906563, 1.9491181);
        ((GeneralPath) shape).lineTo(16.816319, 5.1800275);
        ((GeneralPath) shape).lineTo(16.816319, 16.558449);
        ((GeneralPath) shape).lineTo(31.357143, 16.558449);
        ((GeneralPath) shape).lineTo(31.357143, 5.1800275);
        ((GeneralPath) shape).lineTo(29.2669, 1.9491181);
        ((GeneralPath) shape).lineTo(18.906563, 1.9491181);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(15.875, 11.5), new Point2D.Double(30.75, 62.5), new float[]{0, 1}, new Color[]{WHITE, new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(0.5816329f, 0, 0, 0.56189734f, 10.127541f, -1.1413171f)));
        g.setStroke(new BasicStroke(0.5716802f, 1, 0, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_7
        shape = new Ellipse2D.Double(14.286213874816895, 26.304035186767578, 20.445436477661133, 19.374040603637695);
        g.setPaint(YELLOW);
        g.fill(shape);
        g.setPaint(new Color(0xFFE800));
        g.setStroke(new BasicStroke(3.5724132f, 0, 0, 4));
        g.draw(shape);

    }

    /**
     * Returns the X of the bounding box of the original SVG image.
     *
     * @return The X of the bounding box of the original SVG image.
     */
    public static int getOrigX() {
        return 13;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     *
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 2;
    }

    /**
     * Returns the width of the bounding box of the original SVG image.
     *
     * @return The width of the bounding box of the original SVG image.
     */
    public static int getOrigWidth() {
        return 25;
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
    public PrimarySeg() {
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

