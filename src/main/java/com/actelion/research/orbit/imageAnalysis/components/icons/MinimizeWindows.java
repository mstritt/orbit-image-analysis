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
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

import static java.awt.Color.WHITE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class MinimizeWindows implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        shape = new Rectangle2D.Double(9.239285469055176, 26.556798934936523, 20.817813873291016, 2.9786431789398193);
        g.setPaint(new Color(0xE6E6E6));
        g.fill(shape);
        g.setPaint(new Color(0x000080));
        g.setStroke(new BasicStroke(0.35844824f, 1, 1, 4));
        g.draw(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 0.10529023f, -0.5532729f));

        // _0_0_1

        // _0_0_1_0
        shape = new Rectangle2D.Double(1.854203462600708, 2.745607376098633, 17.934127807617188, 13.952226638793945);
        g.setPaint(new Color(0xDCDCDC));
        g.fill(shape);
        g.setPaint(new Color(0x7D7DB5));
        g.setStroke(new BasicStroke(0.3600241f, 1, 1, 4));
        g.draw(shape);

        // _0_0_1_1
        shape = new Rectangle2D.Double(1.6704905033111572, 2.5618953704833984, 18.30155372619629, 3.278928756713867);
        g.setPaint(new Color(0xB3B3B3));
        g.fill(shape);
        g.setPaint(new Color(0x7D7DB5));
        g.setStroke(new BasicStroke(0.17631109f, 1, 1, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_1

        // _0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(16.607817, 23.647017);
        ((GeneralPath) shape).lineTo(17.750793, 14.916528);
        ((GeneralPath) shape).lineTo(15.439303, 16.450138);
        ((GeneralPath) shape).lineTo(12.408151, 11.881517);
        ((GeneralPath) shape).lineTo(7.414739, 15.194507);
        ((GeneralPath) shape).lineTo(10.445891, 19.763128);
        ((GeneralPath) shape).lineTo(8.134402, 21.296738);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);
        g.setPaint(new Color(0x214478));
        g.setStroke(new BasicStroke(0.2620545f, 1, 1, 4));
        g.draw(shape);

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
        return 2;
    }

    /**
     * Returns the width of the bounding box of the original SVG image.
     *
     * @return The width of the bounding box of the original SVG image.
     */
    public static int getOrigWidth() {
        return 29;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     *
     * @return The height of the bounding box of the original SVG image.
     */
    public static int getOrigHeight() {
        return 28;
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
    public MinimizeWindows() {
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

