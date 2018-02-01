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
import java.awt.geom.GeneralPath;
import java.awt.geom.RoundRectangle2D;

import static java.awt.Color.GREEN;
import static java.awt.Color.WHITE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class Mask2browser implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        Composite origComposite = ((Graphics2D)g).getComposite();
        if (origComposite instanceof AlphaComposite) {
            AlphaComposite origAlphaComposite = (AlphaComposite)origComposite;
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
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(358.99115, 719.65985);
        ((GeneralPath) shape).curveTo(358.99115, 765.26013, 340.87653, 808.9928, 308.63223, 841.23706);
        ((GeneralPath) shape).curveTo(276.38797, 873.4814, 232.65532, 891.596, 187.05502, 891.596);
        ((GeneralPath) shape).curveTo(141.45473, 891.596, 97.7221, 873.4813, 65.47782, 841.23706);
        ((GeneralPath) shape).curveTo(33.233543, 808.9928, 15.1189, 765.26013, 15.118908, 719.65985);
        ((GeneralPath) shape).curveTo(15.118925, 624.70215, 92.097336, 547.72375, 187.05502, 547.72375);
        ((GeneralPath) shape).curveTo(282.01273, 547.72375, 358.99112, 624.70215, 358.99115, 719.65985);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x141414));
        g.setStroke(new BasicStroke(16.028175f, 1, 2, 4, new float[]{16.028175f, 16.028175f}, 0));
        g.draw(shape);

        // _0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(39.740612, 492.1338);
        ((GeneralPath) shape).lineTo(335.19604, 492.1338);
        ((GeneralPath) shape).curveTo(335.55606, 492.1338, 335.8459, 492.4208, 335.8459, 492.7773);
        ((GeneralPath) shape).lineTo(335.8459, 750.63446);
        ((GeneralPath) shape).curveTo(335.8459, 750.9909, 335.55606, 751.2779, 335.19604, 751.2779);
        ((GeneralPath) shape).lineTo(39.740612, 751.2779);
        ((GeneralPath) shape).curveTo(39.380608, 751.2779, 39.09078, 750.9909, 39.09078, 750.63446);
        ((GeneralPath) shape).lineTo(39.09078, 492.7773);
        ((GeneralPath) shape).curveTo(39.09078, 492.4208, 39.380608, 492.1338, 39.740612, 492.1338);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);
        g.setPaint(new Color(0x141414));
        g.setStroke(new BasicStroke(3.4717872f, 1, 2, 4));
        g.draw(shape);

        // _0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(187.3027, 547.16534);
        ((GeneralPath) shape).curveTo(126.46346, 547.2429, 70.194954, 579.46674, 39.339252, 631.90094);
        ((GeneralPath) shape).lineTo(39.339252, 750.0762);
        ((GeneralPath) shape).curveTo(39.339252, 750.4327, 39.629074, 750.72034, 39.98908, 750.72034);
        ((GeneralPath) shape).lineTo(335.44357, 750.72034);
        ((GeneralPath) shape).curveTo(335.8036, 750.72034, 336.0934, 750.4327, 336.0934, 750.0762);
        ((GeneralPath) shape).lineTo(336.0934, 633.3712);
        ((GeneralPath) shape).curveTo(305.46017, 580.1166, 248.73921, 547.2538, 187.3027, 547.16534);
        ((GeneralPath) shape).closePath();

        g.setPaint(GREEN);
        g.fill(shape);
        g.setPaint(new Color(0x141414));
        g.draw(shape);

        // _0_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(489.50894, 554.81757);
        ((GeneralPath) shape).lineTo(665.625, 554.81757);

        g.setPaint(new Color(0xE6E6E6));
        g.setStroke(new BasicStroke(8.4375f, 0, 0, 4));
        g.draw(shape);

        // _0_0_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(489.5089, 638.25507);
        ((GeneralPath) shape).lineTo(665.625, 638.25507);

        g.draw(shape);

        // _0_0_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(489.5089, 721.69257);
        ((GeneralPath) shape).lineTo(665.625, 721.69257);

        g.draw(shape);

        // _0_0_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(489.5089, 805.13007);
        ((GeneralPath) shape).lineTo(665.625, 805.13007);

        g.draw(shape);

        // _0_0_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(489.5089, 888.56757);
        ((GeneralPath) shape).lineTo(665.625, 888.56757);

        g.draw(shape);

        // _0_0_8
        shape = new RoundRectangle2D.Double(470.7589111328125, 524.5496826171875, 212.2767791748047, 399.1071472167969, 2.1057186126708984, 2.0851686000823975);
        g.setStroke(new BasicStroke(8.4375f, 1, 2, 4));
        g.draw(shape);

        // _0_0_9
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(166.07143, 460.39792);
        ((GeneralPath) shape).curveTo(211.83144, 430.93292, 257.59036, 401.46866, 307.70123, 387.5181);
        ((GeneralPath) shape).curveTo(357.8121, 373.56754, 412.27768, 375.1301, 455.52646, 396.60007);
        ((GeneralPath) shape).curveTo(498.77524, 418.07004, 531.0267, 459.72815, 563.1696, 501.24615);

        g.setStroke(new BasicStroke(8.4375f, 0, 0, 4));
        g.draw(shape);

        // _0_0_10
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(563.1696, 501.24615);
        ((GeneralPath) shape).lineTo(564.5089, 447.00507);

        g.setStroke(new BasicStroke(8.4375f, 1, 1, 4));
        g.draw(shape);

        // _0_0_11
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(563.1696, 501.24615);
        ((GeneralPath) shape).lineTo(510.9375, 489.8622);

        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0

        g.setTransform(transformations.poll()); // _0

    }

    /**
     * Returns the X of the bounding box of the original SVG image.
     * 
     * @return The X of the bounding box of the original SVG image.
     */
    public static int getOrigX() {
        return 8;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 28;
    }

    /**
     * Returns the width of the bounding box of the original SVG image.
     * 
     * @return The width of the bounding box of the original SVG image.
     */
    public static int getOrigWidth() {
        return 726;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     * 
     * @return The height of the bounding box of the original SVG image.
     */
    public static int getOrigHeight() {
        return 596;
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
    public Mask2browser() {
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

