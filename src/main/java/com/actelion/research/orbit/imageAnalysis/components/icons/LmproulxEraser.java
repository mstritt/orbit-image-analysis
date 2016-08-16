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
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

import static java.awt.Color.*;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class LmproulxEraser implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.transform(new AffineTransform(1, 0, 0, 1, -319.39615f, -587.1113f));

        // _0_0
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 243.96419f, 64.42567f));

        // _0_0_0

        // _0_0_0_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(111.41357, 583.0844);
        ((GeneralPath) shape).lineTo(232.79573, 524.732);
        ((GeneralPath) shape).lineTo(307.32678, 553.4565);
        ((GeneralPath) shape).lineTo(199.95718, 637.96375);
        ((GeneralPath) shape).lineTo(111.41357, 583.0844);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);
        g.setPaint(BLACK);
        g.setStroke(new BasicStroke(4.092603f, 1, 0, 4));
        g.draw(shape);

        // _0_0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(109.30667, 586.08954);
        ((GeneralPath) shape).lineTo(108.54177, 660.302);
        ((GeneralPath) shape).lineTo(197.55443, 709.6002);
        ((GeneralPath) shape).lineTo(199.06966, 636.6884);
        ((GeneralPath) shape).lineTo(109.30667, 586.08954);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);
        g.setPaint(BLACK);
        g.draw(shape);

        // _0_0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(201.0293, 708.3478);
        ((GeneralPath) shape).lineTo(307.72977, 618.7247);
        ((GeneralPath) shape).lineTo(308.87906, 556.7068);
        ((GeneralPath) shape).lineTo(199.0789, 639.90204);
        ((GeneralPath) shape).curveTo(198.67691, 662.5531, 200.12698, 683.7606, 201.0293, 708.3478);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);
        g.setPaint(BLACK);
        g.draw(shape);

        // _0_0_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(191.12642, 699.0212);
        ((GeneralPath) shape).lineTo(164.21848, 718.4453);
        ((GeneralPath) shape).curveTo(157.70485, 720.08386, 149.67596, 720.3957, 143.16232, 718.1717);
        ((GeneralPath) shape).lineTo(86.57702, 688.39545);
        ((GeneralPath) shape).curveTo(78.621574, 685.76807, 78.78098, 681.60913, 77.87787, 675.083);
        ((GeneralPath) shape).lineTo(77.43377, 627.2067);
        ((GeneralPath) shape).curveTo(79.79582, 618.4826, 86.51426, 614.07245, 93.4218, 611.0024);
        ((GeneralPath) shape).lineTo(115.18328, 599.95404);
        ((GeneralPath) shape).lineTo(190.23819, 642.30615);
        ((GeneralPath) shape).lineTo(191.12642, 699.0212);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);
        g.setPaint(BLACK);
        g.setStroke(new BasicStroke(4.003575f, 1, 0, 4));
        g.draw(shape);

        // _0_0_0_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(141.24146, 570.7651);
        ((GeneralPath) shape).lineTo(228.38431, 617.1936);
        ((GeneralPath) shape).lineTo(286.24146, 572.9079);
        ((GeneralPath) shape).lineTo(206.95573, 537.1936);
        ((GeneralPath) shape).lineTo(141.24146, 570.7651);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLUE);
        g.fill(shape);
        g.setPaint(BLACK);
        g.setStroke(new BasicStroke(5, 1, 0, 4));
        g.draw(shape);

        // _0_0_0_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(227.63992, 618.93396);
        ((GeneralPath) shape).lineTo(227.63992, 685.79517);
        ((GeneralPath) shape).lineTo(283.41217, 640.52454);
        ((GeneralPath) shape).lineTo(285.55725, 576.4492);

        g.setPaint(BLUE);
        g.fill(shape);
        g.setPaint(BLACK);
        g.setStroke(new BasicStroke(4.939821f, 1, 0, 4));
        g.draw(shape);

        // _0_0_0_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(148.49242, 715.2385);
        ((GeneralPath) shape).lineTo(148.49243, 657.6598);
        ((GeneralPath) shape).lineTo(155.05841, 658.67);
        ((GeneralPath) shape).lineTo(153.54318, 715.2385);
        ((GeneralPath) shape).lineTo(148.49242, 715.2385);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xF2F2F2));
        g.fill(shape);

        // _0_0_0_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(150.39917, 662.15283);
        ((GeneralPath) shape).lineTo(80.78478, 629.0029);
        ((GeneralPath) shape).lineTo(88.958954, 619.7707);
        ((GeneralPath) shape).lineTo(154.92482, 654.55334);
        ((GeneralPath) shape).lineTo(150.39917, 662.15283);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        // _0_0_0_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(186.66434, 643.77136);
        ((GeneralPath) shape).lineTo(155.12787, 662.9714);
        ((GeneralPath) shape).lineTo(153.23944, 655.55524);
        ((GeneralPath) shape).lineTo(184.78612, 641.4339);
        ((GeneralPath) shape).lineTo(186.66434, 643.77136);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0

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
        return 236;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     *
     * @return The height of the bounding box of the original SVG image.
     */
    public static int getOrigHeight() {
        return 200;
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
    public LmproulxEraser() {
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

