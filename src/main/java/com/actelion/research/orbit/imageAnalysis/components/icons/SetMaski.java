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

import static java.awt.Color.GREEN;
import static java.awt.Color.WHITE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class SetMaski implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        ((GeneralPath) shape).moveTo(634.1518, 748.0095);
        ((GeneralPath) shape).curveTo(634.1518, 821.8913, 604.8024, 892.747, 552.5601, 944.9893);
        ((GeneralPath) shape).curveTo(500.31787, 997.2316, 429.4621, 1026.581, 355.58035, 1026.581);
        ((GeneralPath) shape).curveTo(281.6986, 1026.581, 210.84285, 997.2316, 158.60057, 944.9893);
        ((GeneralPath) shape).curveTo(106.358284, 892.747, 77.00889, 821.8913, 77.00891, 748.0095);
        ((GeneralPath) shape).curveTo(77.00891, 674.1278, 106.358315, 603.27203, 158.6006, 551.0298);
        ((GeneralPath) shape).curveTo(210.84288, 498.78748, 281.6986, 469.43808, 355.58035, 469.43808);
        ((GeneralPath) shape).curveTo(429.4621, 469.43808, 500.31784, 498.78748, 552.5601, 551.0298);
        ((GeneralPath) shape).curveTo(604.80237, 603.27203, 634.1518, 674.1278, 634.1518, 748.0095);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x141414));
        g.setStroke(new BasicStroke(25.968897f, 1, 2, 4, new float[]{25.968897f, 25.968897f}, 0));
        g.draw(shape);

        // _0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(116.90107, 379.37112);
        ((GeneralPath) shape).lineTo(595.5989, 379.37112);
        ((GeneralPath) shape).curveTo(596.1822, 379.37112, 596.65173, 379.83612, 596.65173, 380.4137);
        ((GeneralPath) shape).lineTo(596.65173, 798.1946);
        ((GeneralPath) shape).curveTo(596.65173, 798.7722, 596.1822, 799.2372, 595.5989, 799.2372);
        ((GeneralPath) shape).lineTo(116.90107, 799.2372);
        ((GeneralPath) shape).curveTo(116.31779, 799.2372, 115.84821, 798.7722, 115.84821, 798.1946);
        ((GeneralPath) shape).lineTo(115.84821, 380.4137);
        ((GeneralPath) shape).curveTo(115.84821, 379.83612, 116.31779, 379.37112, 116.90107, 379.37112);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);
        g.setPaint(new Color(0x141414));
        g.setStroke(new BasicStroke(5.625f, 1, 2, 4));
        g.draw(shape);

        // _0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(355.98163, 468.53342);
        ((GeneralPath) shape).curveTo(257.4097, 468.65912, 166.2433, 520.8682, 116.25079, 605.82227);
        ((GeneralPath) shape).lineTo(116.25079, 797.2901);
        ((GeneralPath) shape).curveTo(116.25079, 797.86774, 116.72036, 798.3338, 117.30364, 798.3338);
        ((GeneralPath) shape).lineTo(595.99994, 798.3338);
        ((GeneralPath) shape).curveTo(596.5832, 798.3338, 597.0528, 797.86774, 597.0528, 797.2901);
        ((GeneralPath) shape).lineTo(597.0528, 608.20447);
        ((GeneralPath) shape).curveTo(547.4207, 521.92114, 455.52127, 468.6767, 355.98163, 468.53342);
        ((GeneralPath) shape).closePath();

        g.setPaint(GREEN);
        g.fill(shape);
        g.setPaint(new Color(0x141414));
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
        return 69;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 36;
    }

    /**
     * Returns the width of the bounding box of the original SVG image.
     * 
     * @return The width of the bounding box of the original SVG image.
     */
    public static int getOrigWidth() {
        return 623;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     * 
     * @return The height of the bounding box of the original SVG image.
     */
    public static int getOrigHeight() {
        return 708;
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
    public SetMaski() {
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

