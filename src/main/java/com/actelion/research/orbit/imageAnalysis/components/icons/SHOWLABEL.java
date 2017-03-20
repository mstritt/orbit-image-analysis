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
import java.awt.geom.RoundRectangle2D;

import static java.awt.Color.*;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class SHOWLABEL implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        shape = new Rectangle2D.Double(0.3413531184196472, 0.2010488212108612, 31.43155288696289, 31.498899459838867);
        g.setPaint(GRAY);
        g.fill(shape);
        g.setPaint(new Color(0xCCCCCC));
        g.setStroke(new BasicStroke(0.5230163f, 1, 1, 4));
        g.draw(shape);

        // _0_0_1
        shape = new RoundRectangle2D.Double(4.107885360717773, 5.1938581466674805, 25.59418487548828, 8.725406646728516, 8.725406646728516, 8.725406646728516);
        g.setPaint(WHITE);
        g.fill(shape);
        g.setStroke(new BasicStroke(0.751969f, 1, 1, 4));
        g.draw(shape);

        // _0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(19.701023, 14.615718);
        ((GeneralPath) shape).lineTo(17.65644, 18.325459);

        g.fill(shape);
        g.setStroke(new BasicStroke(1.5895324f, 1, 1, 4));
        g.draw(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.1476882f, 0, 0, 0.8713168f, 0, 0));

        // _0_0_3
        //  label 
        g.setPaint(BLACK);
        shape = new GeneralPath();

        g.fill(shape);
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(5.9105, 7.835689);
        ((GeneralPath) shape).lineTo(6.434998, 7.835689);
        ((GeneralPath) shape).lineTo(6.434998, 13.485281);
        ((GeneralPath) shape).lineTo(5.9105, 13.485281);
        ((GeneralPath) shape).lineTo(5.9105, 7.835689);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(11.585069, 9.409183);
        ((GeneralPath) shape).lineTo(11.585069, 13.485281);
        ((GeneralPath) shape).lineTo(11.068063, 13.485281);
        ((GeneralPath) shape).lineTo(11.068063, 12.783453);
        ((GeneralPath) shape).quadTo(10.738379, 13.185568, 10.328771, 13.387875);
        ((GeneralPath) shape).quadTo(9.919163, 13.59018, 9.432129, 13.59018);
        ((GeneralPath) shape).quadTo(8.565458, 13.59018, 7.9535446, 12.962032);
        ((GeneralPath) shape).quadTo(7.34163, 12.333883, 7.34163, 11.434744);
        ((GeneralPath) shape).quadTo(7.34163, 10.555585, 7.9597883, 9.9299345);
        ((GeneralPath) shape).quadTo(8.577947, 9.304283, 9.447115, 9.304283);
        ((GeneralPath) shape).quadTo(9.949134, 9.304283, 10.354996, 9.517829);
        ((GeneralPath) shape).quadTo(10.760858, 9.731375, 11.068063, 10.158465);
        ((GeneralPath) shape).lineTo(11.068063, 9.409183);
        ((GeneralPath) shape).lineTo(11.585069, 9.409183);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(9.487077, 9.8088);
        ((GeneralPath) shape).quadTo(9.049994, 9.8088, 8.6791, 10.024843);
        ((GeneralPath) shape).quadTo(8.308205, 10.240887, 8.088415, 10.630513);
        ((GeneralPath) shape).quadTo(7.8686256, 11.020141, 7.8686256, 11.454724);
        ((GeneralPath) shape).quadTo(7.8686256, 11.884314, 8.089664, 12.277687);
        ((GeneralPath) shape).quadTo(8.310702, 12.671061, 8.684095, 12.89085);
        ((GeneralPath) shape).quadTo(9.0574875, 13.11064, 9.484579, 13.11064);
        ((GeneralPath) shape).quadTo(9.914167, 13.11064, 10.300048, 12.893348);
        ((GeneralPath) shape).quadTo(10.685929, 12.676056, 10.89448, 12.3051605);
        ((GeneralPath) shape).quadTo(11.103029, 11.934266, 11.103029, 11.46971);
        ((GeneralPath) shape).quadTo(11.103029, 10.760389, 10.635977, 10.284595);
        ((GeneralPath) shape).quadTo(10.168924, 9.8088, 9.487077, 9.8088);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(12.800155, 13.485281);
        ((GeneralPath) shape).lineTo(12.800155, 7.835689);
        ((GeneralPath) shape).lineTo(13.319657, 7.835689);
        ((GeneralPath) shape).lineTo(13.319657, 10.108513);
        ((GeneralPath) shape).quadTo(13.649343, 9.7039, 14.057701, 9.504092);
        ((GeneralPath) shape).quadTo(14.466061, 9.304283, 14.9530945, 9.304283);
        ((GeneralPath) shape).quadTo(15.819765, 9.304283, 16.431679, 9.931183);
        ((GeneralPath) shape).quadTo(17.043592, 10.558083, 17.043592, 11.454724);
        ((GeneralPath) shape).quadTo(17.043592, 12.338879, 16.425434, 12.964529);
        ((GeneralPath) shape).quadTo(15.807277, 13.59018, 14.938108, 13.59018);
        ((GeneralPath) shape).quadTo(14.441084, 13.59018, 14.036471, 13.376635);
        ((GeneralPath) shape).quadTo(13.631859, 13.16309, 13.319657, 12.735998);
        ((GeneralPath) shape).lineTo(13.319657, 13.485281);
        ((GeneralPath) shape).lineTo(12.800155, 13.485281);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(14.898147, 13.083166);
        ((GeneralPath) shape).quadTo(15.335229, 13.083166, 15.706123, 12.868372);
        ((GeneralPath) shape).quadTo(16.077019, 12.653577, 16.296808, 12.26395);
        ((GeneralPath) shape).quadTo(16.516598, 11.874323, 16.516598, 11.439739);
        ((GeneralPath) shape).quadTo(16.516598, 11.005155, 16.295559, 10.611781);
        ((GeneralPath) shape).quadTo(16.07452, 10.218408, 15.701128, 9.998618);
        ((GeneralPath) shape).quadTo(15.327736, 9.778829, 14.90564, 9.778829);
        ((GeneralPath) shape).quadTo(14.473554, 9.778829, 14.086424, 9.998618);
        ((GeneralPath) shape).quadTo(13.699294, 10.218408, 13.490744, 10.589303);
        ((GeneralPath) shape).quadTo(13.282193, 10.960198, 13.282193, 11.424753);
        ((GeneralPath) shape).quadTo(13.282193, 12.131577, 13.749247, 12.607371);
        ((GeneralPath) shape).quadTo(14.216299, 13.083166, 14.898147, 13.083166);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(21.430645, 12.131577);
        ((GeneralPath) shape).lineTo(21.872723, 12.363854);
        ((GeneralPath) shape).quadTo(21.65543, 12.790946, 21.370703, 13.053195);
        ((GeneralPath) shape).quadTo(21.085976, 13.315444, 20.730066, 13.452812);
        ((GeneralPath) shape).quadTo(20.374157, 13.59018, 19.924587, 13.59018);
        ((GeneralPath) shape).quadTo(18.928041, 13.59018, 18.36608, 12.935807);
        ((GeneralPath) shape).quadTo(17.804117, 12.281433, 17.804117, 11.457222);
        ((GeneralPath) shape).quadTo(17.804117, 10.682963, 18.28116, 10.076044);
        ((GeneralPath) shape).quadTo(18.883083, 9.304283, 19.894615, 9.304283);
        ((GeneralPath) shape).quadTo(20.93612, 9.304283, 21.558023, 10.093528);
        ((GeneralPath) shape).quadTo(22.000101, 10.652992, 22.007593, 11.487194);
        ((GeneralPath) shape).lineTo(18.343601, 11.487194);
        ((GeneralPath) shape).quadTo(18.358585, 12.199012, 18.796917, 12.654826);
        ((GeneralPath) shape).quadTo(19.235247, 13.11064, 19.87963, 13.11064);
        ((GeneralPath) shape).quadTo(20.191832, 13.11064, 20.4853, 13.001993);
        ((GeneralPath) shape).quadTo(20.778769, 12.893348, 20.984821, 12.71352);
        ((GeneralPath) shape).quadTo(21.190874, 12.533691, 21.430645, 12.131577);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(21.430645, 11.035127);
        ((GeneralPath) shape).quadTo(21.325747, 10.615528, 21.125937, 10.364518);
        ((GeneralPath) shape).quadTo(20.926128, 10.113508, 20.596443, 9.959906);
        ((GeneralPath) shape).quadTo(20.26676, 9.806303, 19.90211, 9.806303);
        ((GeneralPath) shape).quadTo(19.302683, 9.806303, 18.873093, 10.190934);
        ((GeneralPath) shape).quadTo(18.558395, 10.473165, 18.39605, 11.035127);
        ((GeneralPath) shape).lineTo(21.430645, 11.035127);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(22.907982, 7.835689);
        ((GeneralPath) shape).lineTo(23.43248, 7.835689);
        ((GeneralPath) shape).lineTo(23.43248, 13.485281);
        ((GeneralPath) shape).lineTo(22.907982, 13.485281);
        ((GeneralPath) shape).lineTo(22.907982, 7.835689);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        shape = new GeneralPath();

        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_3

        // _0_0_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(17.63558, 29.639624);
        ((GeneralPath) shape).curveTo(26.13411, 30.78217, 20.726, 27.309837, 18.205528, 25.298704);
        ((GeneralPath) shape).curveTo(13.470678, 21.520678, 15.814136, 21.359549, 12.997216, 18.099474);
        ((GeneralPath) shape).curveTo(11.375399, 16.222515, 4.3656774, 15.958595, 3.9099357, 17.53513);
        ((GeneralPath) shape).curveTo(3.124077, 20.253626, 9.13705, 28.497076, 17.63558, 29.639624);
        ((GeneralPath) shape).closePath();

        g.setPaint(YELLOW);
        g.setStroke(new BasicStroke(1.1827589f, 0, 0, 4));
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
        return 0;
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
    public SHOWLABEL() {
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

