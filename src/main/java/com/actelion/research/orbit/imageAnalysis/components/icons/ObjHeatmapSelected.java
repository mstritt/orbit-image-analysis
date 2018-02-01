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

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class ObjHeatmapSelected implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.setPaint(new Color(0xFF2A2A));
        g.fill(shape);
        g.setStroke(new BasicStroke(50, 0, 0, 4));
        g.draw(shape);

        // _0_0_1
        shape = new Ellipse2D.Double(378.21429443359375, 410.2193603515625, 243.57142639160156, 318.5714416503906);
        g.setPaint(new Color(0xFF5555));
        g.fill(shape);
        g.draw(shape);

        // _0_0_2
        shape = new Ellipse2D.Double(275.0675048828125, 716.3582763671875, 159.86502075195312, 220.57931518554688);
        g.setPaint(new Color(0xFFAAAA));
        g.fill(shape);
        g.setStroke(new BasicStroke(33.706413f, 0, 0, 4));
        g.draw(shape);

        // _0_0_3
        shape = new Ellipse2D.Double(506.4156799316406, 752.7064208984375, 180.0258026123047, 265.7401123046875);
        g.setPaint(new Color(0xFF8080));
        g.fill(shape);
        g.setStroke(new BasicStroke(39.259914f, 0, 0, 4));
        g.draw(shape);

        // _0_0_4
        shape = new Ellipse2D.Double(136.5498809814453, 882.1263427734375, 143.328857421875, 154.0431671142578);
        g.setPaint(new Color(0xF4D7D7));
        g.fill(shape);
        g.setStroke(new BasicStroke(26.671133f, 0, 0, 4));
        g.draw(shape);

        // _0_0_5
        shape = new Ellipse2D.Double(30.60478973388672, 724.0383911132812, 133.07611083984375, 160.21897888183594);
        g.fill(shape);
        g.setStroke(new BasicStroke(26.209602f, 0, 0, 4));
        g.draw(shape);

        // _0_0_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(170.33382, 645.4021);
        ((GeneralPath) shape).curveTo(320.58975, 709.8403, 153.35504, 1266.3849, 387.1049, 830.88684);
        ((GeneralPath) shape).curveTo(620.85474, 395.3888, 622.85223, 395.71982, 622.85223, 395.71982);

        g.setPaint(new Color(0x2A7FFF));
        g.setStroke(new BasicStroke(70.73394f, 0, 0, 4));
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
    public ObjHeatmapSelected() {
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

