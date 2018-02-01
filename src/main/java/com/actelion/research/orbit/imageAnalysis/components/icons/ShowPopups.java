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
import java.awt.geom.Rectangle2D;

import static java.awt.Color.*;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class ShowPopups implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.transform(new AffineTransform(1, 0, 0, 1, -79.62865f, -236.8761f));

        // _0_0

        // _0_0_0
        shape = new Rectangle2D.Double(85.78311157226562, 241.449951171875, 116.2145767211914, 117.78132629394531);
        g.setPaint(WHITE);
        g.fill(shape);
        g.setPaint(BLUE);
        g.setStroke(new BasicStroke(4.409427f, 0, 0, 4));
        g.draw(shape);

        // _0_0_1
        shape = new Rectangle2D.Double(120.79837799072266, 257.7753601074219, 70.43382263183594, 60.51008987426758);
        g.setPaint(WHITE);
        g.fill(shape);
        g.setPaint(BLUE);
        g.setStroke(new BasicStroke(2.4604707f, 0, 0, 4));
        g.draw(shape);

        // _0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(120.32559, 256.87967);
        ((GeneralPath) shape).curveTo(95.63882, 344.87253, 95.63882, 344.87253, 95.63882, 344.87253);

        g.setPaint(BLACK);
        g.setStroke(new BasicStroke(1.0141658f, 0, 0, 4));
        g.draw(shape);

        // _0_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(191.79599, 318.95993);
        ((GeneralPath) shape).curveTo(95.63809, 344.84772, 95.63809, 344.84772, 95.63809, 344.84772);

        g.setStroke(new BasicStroke(1.0394388f, 0, 0, 4));
        g.draw(shape);

        // _0_0_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(119.96717, 319.12338);
        ((GeneralPath) shape).curveTo(95.643684, 344.86108, 95.643684, 344.86108, 95.643684, 344.86108);

        g.setStroke(new BasicStroke(1.042525f, 0, 0, 4));
        g.draw(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0344315f, 0, 0, 0.9667147f, 0, 0));

        // _0_0_5
        //  123 
        shape = new GeneralPath();

        g.fill(shape);
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(130.35881, 305.94998);
        ((GeneralPath) shape).lineTo(127.27463, 305.94998);
        ((GeneralPath) shape).lineTo(127.27463, 286.29114);
        ((GeneralPath) shape).quadTo(126.15518, 287.3535, 124.350365, 288.4158);
        ((GeneralPath) shape).quadTo(122.54554, 289.47815, 121.106255, 290.015);
        ((GeneralPath) shape).lineTo(121.106255, 287.03363);
        ((GeneralPath) shape).quadTo(123.687836, 285.81137, 125.624016, 284.0808);
        ((GeneralPath) shape).quadTo(127.5602, 282.35025, 128.37123, 280.72818);
        ((GeneralPath) shape).lineTo(130.35881, 280.72818);
        ((GeneralPath) shape).lineTo(130.35881, 305.94998);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(154.46687, 302.98);
        ((GeneralPath) shape).lineTo(154.46687, 305.94998);
        ((GeneralPath) shape).lineTo(137.85796, 305.94998);
        ((GeneralPath) shape).quadTo(137.82368, 304.83054, 138.2235, 303.80246);
        ((GeneralPath) shape).quadTo(138.85175, 302.11188, 140.25105, 300.46698);
        ((GeneralPath) shape).quadTo(141.65036, 298.82208, 144.28906, 296.66315);
        ((GeneralPath) shape).quadTo(148.37846, 293.3048, 149.81775, 291.3401);
        ((GeneralPath) shape).quadTo(151.25703, 289.37534, 151.25703, 287.62762);
        ((GeneralPath) shape).quadTo(151.25703, 285.79996, 149.94911, 284.53772);
        ((GeneralPath) shape).quadTo(148.64119, 283.27548, 146.52795, 283.27548);
        ((GeneralPath) shape).quadTo(144.30048, 283.27548, 142.964, 284.61197);
        ((GeneralPath) shape).quadTo(141.62752, 285.94846, 141.61609, 288.313);
        ((GeneralPath) shape).lineTo(138.44052, 287.99316);
        ((GeneralPath) shape).quadTo(138.77179, 284.44064, 140.89645, 282.5844);
        ((GeneralPath) shape).quadTo(143.02112, 280.72818, 146.59648, 280.72818);
        ((GeneralPath) shape).quadTo(150.21754, 280.72818, 152.32507, 282.7329);
        ((GeneralPath) shape).quadTo(154.4326, 284.73764, 154.4326, 287.69617);
        ((GeneralPath) shape).quadTo(154.4326, 289.20398, 153.81577, 290.6604);
        ((GeneralPath) shape).quadTo(153.19893, 292.11682, 151.76535, 293.72748);
        ((GeneralPath) shape).quadTo(150.33177, 295.3381, 147.0077, 298.14813);
        ((GeneralPath) shape).quadTo(144.23193, 300.4784, 143.44376, 301.3123);
        ((GeneralPath) shape).quadTo(142.65558, 302.14615, 142.14154, 302.98);
        ((GeneralPath) shape).lineTo(154.46687, 302.98);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(157.78523, 299.31326);
        ((GeneralPath) shape).lineTo(160.86942, 298.90204);
        ((GeneralPath) shape).quadTo(161.4063, 301.52933, 162.67995, 302.683);
        ((GeneralPath) shape).quadTo(163.95361, 303.83673, 165.7927, 303.83673);
        ((GeneralPath) shape).quadTo(167.96304, 303.83673, 169.46516, 302.32892);
        ((GeneralPath) shape).quadTo(170.96727, 300.8211, 170.96727, 298.59363);
        ((GeneralPath) shape).quadTo(170.96727, 296.46896, 169.57939, 295.0925);
        ((GeneralPath) shape).quadTo(168.19151, 293.71603, 166.044, 293.71603);
        ((GeneralPath) shape).quadTo(165.17586, 293.71603, 163.87364, 294.05872);
        ((GeneralPath) shape).lineTo(164.21634, 291.3515);
        ((GeneralPath) shape).quadTo(164.52475, 291.38577, 164.70752, 291.38577);
        ((GeneralPath) shape).quadTo(166.68369, 291.38577, 168.26004, 290.3577);
        ((GeneralPath) shape).quadTo(169.83641, 289.32965, 169.83641, 287.18213);
        ((GeneralPath) shape).quadTo(169.83641, 285.49155, 168.6884, 284.3778);
        ((GeneralPath) shape).quadTo(167.5404, 283.26407, 165.72415, 283.26407);
        ((GeneralPath) shape).quadTo(163.91934, 283.26407, 162.71992, 284.39493);
        ((GeneralPath) shape).quadTo(161.52052, 285.52582, 161.17784, 287.78754);
        ((GeneralPath) shape).lineTo(158.09364, 287.23926);
        ((GeneralPath) shape).quadTo(158.6648, 284.1322, 160.66953, 282.4302);
        ((GeneralPath) shape).quadTo(162.67424, 280.72818, 165.65562, 280.72818);
        ((GeneralPath) shape).quadTo(167.71175, 280.72818, 169.44232, 281.60776);
        ((GeneralPath) shape).quadTo(171.17288, 282.4873, 172.08672, 284.01227);
        ((GeneralPath) shape).quadTo(173.00055, 285.53723, 173.00055, 287.25067);
        ((GeneralPath) shape).quadTo(173.00055, 288.88416, 172.1267, 290.22064);
        ((GeneralPath) shape).quadTo(171.25285, 291.5571, 169.53941, 292.34528);
        ((GeneralPath) shape).quadTo(171.76688, 292.8593, 173.00055, 294.47568);
        ((GeneralPath) shape).quadTo(174.23422, 296.092, 174.23422, 298.5251);
        ((GeneralPath) shape).quadTo(174.23422, 301.81488, 171.83542, 304.1052);
        ((GeneralPath) shape).quadTo(169.4366, 306.39548, 165.76985, 306.39548);
        ((GeneralPath) shape).quadTo(162.46863, 306.39548, 160.28114, 304.42502);
        ((GeneralPath) shape).quadTo(158.09364, 302.45456, 157.78523, 299.31326);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        shape = new GeneralPath();

        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_5

        g.setTransform(transformations.poll()); // _0_0

    }

    /**
     * Returns the X of the bounding box of the original SVG image.
     *
     * @return The X of the bounding box of the original SVG image.
     */
    public static int getOrigX() {
        return 4;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     *
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 3;
    }

    /**
     * Returns the width of the bounding box of the original SVG image.
     *
     * @return The width of the bounding box of the original SVG image.
     */
    public static int getOrigWidth() {
        return 121;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     *
     * @return The height of the bounding box of the original SVG image.
     */
    public static int getOrigHeight() {
        return 123;
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
    public ShowPopups() {
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

