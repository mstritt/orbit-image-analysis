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
import java.awt.geom.Rectangle2D;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class TileWindows implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        shape = new Rectangle2D.Double(17.51532554626465, 17.791887283325195, 13.148576736450195, 12.961418151855469);
        g.setPaint(new Color(0xE6E6E6));
        g.fill(shape);
        g.setPaint(new Color(0x000080));
        g.setStroke(new BasicStroke(0.59424466f, 1, 1, 4));
        g.draw(shape);

        // _0_0_1
        shape = new Rectangle2D.Double(17.380634307861328, 17.6212215423584, 13.41795825958252, 3.0460777282714844);
        g.setPaint(new Color(0xF9F9F9));
        g.fill(shape);
        g.setPaint(new Color(0x000080));
        g.setStroke(new BasicStroke(0.29101366f, 1, 1, 4));
        g.draw(shape);

        // _0_0_2
        shape = new Rectangle2D.Double(17.51532554626465, 2.214965581893921, 13.148576736450195, 12.961418151855469);
        g.setPaint(new Color(0xE6E6E6));
        g.fill(shape);
        g.setPaint(new Color(0x000080));
        g.setStroke(new BasicStroke(0.59424466f, 1, 1, 4));
        g.draw(shape);

        // _0_0_3
        shape = new Rectangle2D.Double(17.380634307861328, 2.044299602508545, 13.41795825958252, 3.0460777282714844);
        g.setPaint(new Color(0xF9F9F9));
        g.fill(shape);
        g.setPaint(new Color(0x000080));
        g.setStroke(new BasicStroke(0.29101366f, 1, 1, 4));
        g.draw(shape);

        // _0_0_4
        shape = new Rectangle2D.Double(2.2845561504364014, 17.791887283325195, 13.148576736450195, 12.961418151855469);
        g.setPaint(new Color(0xE6E6E6));
        g.fill(shape);
        g.setPaint(new Color(0x000080));
        g.setStroke(new BasicStroke(0.59424466f, 1, 1, 4));
        g.draw(shape);

        // _0_0_5
        shape = new Rectangle2D.Double(2.14986515045166, 17.6212215423584, 13.41795825958252, 3.0460777282714844);
        g.setPaint(new Color(0xF9F9F9));
        g.fill(shape);
        g.setPaint(new Color(0x000080));
        g.setStroke(new BasicStroke(0.29101366f, 1, 1, 4));
        g.draw(shape);

        // _0_0_6
        shape = new Rectangle2D.Double(2.2845561504364014, 2.214965581893921, 13.148576736450195, 12.961418151855469);
        g.setPaint(new Color(0xE6E6E6));
        g.fill(shape);
        g.setPaint(new Color(0x000080));
        g.setStroke(new BasicStroke(0.59424466f, 1, 1, 4));
        g.draw(shape);

        // _0_0_7
        shape = new Rectangle2D.Double(2.14986515045166, 2.044299602508545, 13.41795825958252, 3.0460777282714844);
        g.setPaint(new Color(0xF9F9F9));
        g.fill(shape);
        g.setPaint(new Color(0x000080));
        g.setStroke(new BasicStroke(0.29101366f, 1, 1, 4));
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
        return 30;
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
    public TileWindows() {
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

