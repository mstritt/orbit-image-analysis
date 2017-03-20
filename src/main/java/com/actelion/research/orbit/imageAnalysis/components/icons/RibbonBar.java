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
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

import static java.awt.Color.GREEN;
import static java.awt.Color.RED;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class RibbonBar implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        shape = new Rectangle2D.Double(0.22005188465118408, -10.876255989074707, 31.746553421020508, 8.964639663696289);
        g.setPaint(new Color(0x666666));
        g.fill(shape);
        g.setPaint(new Color(0xCCCCCC));
        g.setStroke(new BasicStroke(0.28041378f, 1, 1, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_0

        // _0_0_1
        shape = new Rectangle2D.Double(0.29186734557151794, 11.228486061096191, 31.602922439575195, 20.593345642089844);
        g.setPaint(new Color(0x1A1A1A));
        g.fill(shape);
        g.setPaint(new Color(0xCCCCCC));
        g.setStroke(new BasicStroke(0.42404476f, 1, 1, 4));
        g.draw(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0172156f, 0, 0, 1.0663553f, 9.241546f, 2.1647985f));

        // _0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(6.8054304, 4.2714934);
        ((GeneralPath) shape).curveTo(6.8054304, 5.670948, 5.6871552, 6.8054304, 4.3076925, 6.8054304);
        ((GeneralPath) shape).curveTo(2.9282303, 6.8054304, 1.8099551, 5.670948, 1.8099551, 4.2714934);
        ((GeneralPath) shape).curveTo(1.8099551, 2.8720388, 2.9282303, 1.7375567, 4.3076925, 1.7375567);
        ((GeneralPath) shape).curveTo(5.6871552, 1.7375567, 6.8054304, 2.8720388, 6.8054304, 4.2714934);
        ((GeneralPath) shape).closePath();

        g.setPaint(RED);
        g.setStroke(new BasicStroke(0.6117833f, 1, 1, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_2

        // _0_0_3
        shape = new Rectangle2D.Double(20.049957275390625, 4.063622951507568, 5.14412784576416, 5.312210559844971);
        g.setPaint(GREEN);
        g.setStroke(new BasicStroke(0.6371697f, 1, 1, 4));
        g.draw(shape);

        // _0_0_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(3.1063871, 9.096748);
        ((GeneralPath) shape).lineTo(4.9120235, 8.640881);
        ((GeneralPath) shape).lineTo(7.520166, 9.422367);
        ((GeneralPath) shape).lineTo(5.5139027, 7.533776);
        ((GeneralPath) shape).lineTo(7.319539, 7.2732806);
        ((GeneralPath) shape).lineTo(7.520166, 4.407832);
        ((GeneralPath) shape).lineTo(5.447027, 4.798575);
        ((GeneralPath) shape).lineTo(3.9757676, 4.0170894);
        ((GeneralPath) shape).lineTo(2.4376328, 5.189318);
        ((GeneralPath) shape).lineTo(3.7082658, 6.4266706);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x00B1FF));
        g.draw(shape);

        // _0_0_5
        shape = new Rectangle2D.Double(0.13599058985710144, 0.28527817130088806, 31.914676666259766, 1.4299856424331665);
        g.setPaint(new Color(0x4D4D4D));
        g.fill(shape);
        g.setPaint(new Color(0xCCCCCC));
        g.setStroke(new BasicStroke(0.11229119f, 1, 1, 4));
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
    public RibbonBar() {
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

