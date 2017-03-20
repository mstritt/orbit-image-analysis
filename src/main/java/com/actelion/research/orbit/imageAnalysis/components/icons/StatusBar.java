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

import static java.awt.Color.WHITE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class StatusBar implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, -1, 0, 0));

        // _0_0_0
        shape = new Rectangle2D.Double(0.12402412295341492, -32.040157318115234, 31.793811798095703, 6.188369274139404);
        g.setPaint(new Color(0x666666));
        g.fill(shape);
        g.setPaint(new Color(0xCCCCCC));
        g.setStroke(new BasicStroke(0.23315462f, 1, 1, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_0

        // _0_0_1
        shape = new Rectangle2D.Double(0.44598472118377686, 1.9708387851715088, 31.584280014038086, 22.45705795288086);
        g.setPaint(new Color(0x1A1A1A));
        g.fill(shape);
        g.setPaint(new Color(0xCCCCCC));
        g.setStroke(new BasicStroke(0.44268677f, 1, 1, 4));
        g.draw(shape);

        // _0_0_2
        shape = new Rectangle2D.Double(0.13599058985710144, 0.28527817130088806, 31.914676666259766, 1.4299856424331665);
        g.setPaint(new Color(0x4D4D4D));
        g.fill(shape);
        g.setPaint(new Color(0xCCCCCC));
        g.setStroke(new BasicStroke(0.11229119f, 1, 1, 4));
        g.draw(shape);

        // _0_0_3
        shape = new Rectangle2D.Double(1.3384934663772583, 27.594141006469727, 12.718411445617676, 2.751638650894165);
        g.setPaint(new Color(0xE6E6E6));
        g.fill(shape);
        g.setPaint(WHITE);
        g.setStroke(new BasicStroke(0.58909035f, 1, 1, 4));
        g.draw(shape);

        // _0_0_4
        shape = new Rectangle2D.Double(15.933159828186035, 27.50364875793457, 6.703203201293945, 2.9326252937316895);
        g.setPaint(new Color(0xE6E6E6));
        g.fill(shape);
        g.setPaint(WHITE);
        g.setStroke(new BasicStroke(0.44150865f, 1, 1, 4));
        g.draw(shape);

        // _0_0_5
        shape = new Rectangle2D.Double(24.4438419342041, 27.600162506103516, 6.1416473388671875, 2.9502549171447754);
        g.setPaint(new Color(0xE6E6E6));
        g.fill(shape);
        g.setPaint(WHITE);
        g.setStroke(new BasicStroke(0.42387903f, 1, 1, 4));
        g.draw(shape);

    }

    /**
     * Returns the X of the bounding box of the original SVG image.
     *
     * @return The X of the bounding box of the original SVG image.
     */
    public static int getOrigX() {
        return 1;
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
        return 32;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     *
     * @return The height of the bounding box of the original SVG image.
     */
    public static int getOrigHeight() {
        return 32;
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
    public StatusBar() {
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

