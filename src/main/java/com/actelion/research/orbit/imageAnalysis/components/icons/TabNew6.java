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
import java.awt.geom.Point2D;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static java.awt.MultipleGradientPaint.ColorSpaceType.SRGB;
import static java.awt.MultipleGradientPaint.CycleMethod.NO_CYCLE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class TabNew6 implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.setComposite(AlphaComposite.getInstance(3, 0.7802198f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-1, 0, 0, 1, 128, 0));

        // _0_0_0
        g.setComposite(AlphaComposite.getInstance(3, 0.25f * origAlpha));

        // _0_0_0_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(71.78125, 20.0);
        ((GeneralPath) shape).curveTo(67.47136, 20.0, 64.0, 23.471355, 64.0, 27.78125);
        ((GeneralPath) shape).lineTo(64.0, 48.0);
        ((GeneralPath) shape).lineTo(29.0, 48.0);
        ((GeneralPath) shape).lineTo(29.0, 89.0);
        ((GeneralPath) shape).lineTo(120.0, 89.0);
        ((GeneralPath) shape).lineTo(120.0, 27.78125);
        ((GeneralPath) shape).curveTo(120.0, 23.471355, 116.52865, 20.0, 112.21875, 20.0);
        ((GeneralPath) shape).lineTo(71.78125, 20.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(55.54030227661133, 199.0931854248047), new Point2D.Double(53.0167236328125, 40.745628356933594), new float[]{0, 0.4259708f, 0.5892781f, 0.8021978f, 1}, new Color[]{WHITE, WHITE, new Color(0xF1F1F1), new Color(0xEAEAEA), new Color(0xDFDFDF)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);
        g.setPaint(BLACK);
        g.setStroke(new BasicStroke(4, 1, 1, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.3f * origAlpha));

        // _0_0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(71.78125, 20.0);
        ((GeneralPath) shape).curveTo(67.47136, 20.0, 64.0, 23.471355, 64.0, 27.78125);
        ((GeneralPath) shape).lineTo(64.0, 48.0);
        ((GeneralPath) shape).lineTo(25.0, 48.0);
        ((GeneralPath) shape).lineTo(25.0, 84.0);
        ((GeneralPath) shape).lineTo(120.0, 84.0);
        ((GeneralPath) shape).lineTo(120.0, 27.78125);
        ((GeneralPath) shape).curveTo(120.0, 23.471355, 116.52865, 20.0, 112.21875, 20.0);
        ((GeneralPath) shape).lineTo(71.78125, 20.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(55.54030227661133, 199.0931854248047), new Point2D.Double(53.0167236328125, 40.745628356933594), new float[]{0, 0.4259708f, 0.5892781f, 0.8021978f, 1}, new Color[]{WHITE, WHITE, new Color(0xF1F1F1), new Color(0xEAEAEA), new Color(0xDFDFDF)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);
        g.setPaint(BLACK);
        g.setStroke(new BasicStroke(2, 1, 1, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(71.78125, 20.0);
        ((GeneralPath) shape).curveTo(67.47136, 20.0, 64.0, 23.471355, 64.0, 27.78125);
        ((GeneralPath) shape).lineTo(64.0, 48.0);
        ((GeneralPath) shape).lineTo(24.0, 48.0);
        ((GeneralPath) shape).lineTo(24.0, 84.0);
        ((GeneralPath) shape).lineTo(120.0, 84.0);
        ((GeneralPath) shape).lineTo(120.0, 27.78125);
        ((GeneralPath) shape).curveTo(120.0, 23.471355, 116.52865, 20.0, 112.21875, 20.0);
        ((GeneralPath) shape).lineTo(71.78125, 20.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(55.54030227661133, 199.0931854248047), new Point2D.Double(53.0167236328125, 40.745628356933594), new float[]{0, 0.4259708f, 0.5892781f, 0.8021978f, 1}, new Color[]{WHITE, WHITE, new Color(0xF1F1F1), new Color(0xEAEAEA), new Color(0xDFDFDF)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_0

        // _0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(116.76293, 4.7358413);
        ((GeneralPath) shape).lineTo(116.76293, 1.9411328);
        ((GeneralPath) shape).lineTo(116.76293, 4.7358413);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xC1FFFFFF, true));
        g.fill(shape);

        // _0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-106.1155, -66.353806);
        ((GeneralPath) shape).lineTo(-106.1155, -69.14851);
        ((GeneralPath) shape).lineTo(-106.1155, -66.353806);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        // _0_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-225.6177, -152.98405);
        ((GeneralPath) shape).lineTo(-225.6177, -155.77876);
        ((GeneralPath) shape).lineTo(-225.6177, -152.98405);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, -42.6661f, -8.40242f));

        // _0_0_4

        g.setTransform(transformations.poll()); // _0_0_4
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, -42.6661f, -8.40242f));

        // _0_0_5

        g.setTransform(transformations.poll()); // _0_0_5

        // _0_0_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(20.9737, -87.22878);
        ((GeneralPath) shape).lineTo(20.9737, -90.02349);
        ((GeneralPath) shape).lineTo(20.9737, -87.22878);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        // _0_0_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(81.28432, -7.9325066);
        ((GeneralPath) shape).lineTo(81.28432, -9.459243);
        ((GeneralPath) shape).lineTo(81.28432, -7.932507);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));

        // _0_0_8

        // _0_0_9
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_10
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(-323.1997, -170.67877);
        ((GeneralPath) shape).lineTo(-323.1997, -173.47348);
        ((GeneralPath) shape).lineTo(-323.1997, -170.67877);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.782995f, 0, 0, 0.650879f, -2646.058f, 515.8389f));

        // _0_0_11

        g.setTransform(transformations.poll()); // _0_0_11
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.782995f, 0, 0, 0.650879f, -2646.058f, 515.8389f));

        // _0_0_12

        g.setTransform(transformations.poll()); // _0_0_12
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 0.650879f, 554.9047f, 523.1667f));

        // _0_0_13

        g.setTransform(transformations.poll()); // _0_0_13
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 0.650879f, 554.9047f, 523.1667f));

        // _0_0_14

        g.setTransform(transformations.poll()); // _0_0_14
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_15
        g.setComposite(AlphaComposite.getInstance(3, 0.1f * origAlpha));

        // _0_0_15_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(71.78125, 16.0);
        ((GeneralPath) shape).curveTo(67.47136, 16.0, 64.0, 19.471355, 64.0, 23.78125);
        ((GeneralPath) shape).lineTo(64.0, 40.0);
        ((GeneralPath) shape).lineTo(8.0, 40.0);
        ((GeneralPath) shape).lineTo(8.0, 104.0);
        ((GeneralPath) shape).lineTo(120.0, 104.0);
        ((GeneralPath) shape).lineTo(120.0, 23.78125);
        ((GeneralPath) shape).curveTo(120.0, 19.471355, 116.52865, 16.0, 112.21875, 16.0);
        ((GeneralPath) shape).lineTo(71.78125, 16.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(55.54030227661133, 199.0931854248047), new Point2D.Double(53.0167236328125, 40.745628356933594), new float[]{0, 0.4259708f, 0.5892781f, 0.8021978f, 1}, new Color[]{WHITE, WHITE, new Color(0xF1F1F1), new Color(0xEAEAEA), new Color(0xDFDFDF)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);
        g.setPaint(BLACK);
        g.setStroke(new BasicStroke(8, 1, 1, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.2f * origAlpha));

        // _0_0_15_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(71.78125, 16.0);
        ((GeneralPath) shape).curveTo(67.47136, 16.0, 64.0, 19.471355, 64.0, 23.78125);
        ((GeneralPath) shape).lineTo(64.0, 40.0);
        ((GeneralPath) shape).lineTo(8.0, 40.0);
        ((GeneralPath) shape).lineTo(8.0, 104.0);
        ((GeneralPath) shape).lineTo(120.0, 104.0);
        ((GeneralPath) shape).lineTo(120.0, 23.78125);
        ((GeneralPath) shape).curveTo(120.0, 19.471355, 116.52865, 16.0, 112.21875, 16.0);
        ((GeneralPath) shape).lineTo(71.78125, 16.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(55.54030227661133, 199.0931854248047), new Point2D.Double(53.0167236328125, 40.745628356933594), new float[]{0, 0.4259708f, 0.5892781f, 0.8021978f, 1}, new Color[]{WHITE, WHITE, new Color(0xF1F1F1), new Color(0xEAEAEA), new Color(0xDFDFDF)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);
        g.setPaint(BLACK);
        g.setStroke(new BasicStroke(6, 1, 1, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.3f * origAlpha));

        // _0_0_15_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(71.78125, 16.0);
        ((GeneralPath) shape).curveTo(67.47136, 16.0, 64.0, 19.471355, 64.0, 23.78125);
        ((GeneralPath) shape).lineTo(64.0, 40.0);
        ((GeneralPath) shape).lineTo(8.0, 40.0);
        ((GeneralPath) shape).lineTo(8.0, 104.0);
        ((GeneralPath) shape).lineTo(120.0, 104.0);
        ((GeneralPath) shape).lineTo(120.0, 23.78125);
        ((GeneralPath) shape).curveTo(120.0, 19.471355, 116.52865, 16.0, 112.21875, 16.0);
        ((GeneralPath) shape).lineTo(71.78125, 16.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(55.54030227661133, 199.0931854248047), new Point2D.Double(53.0167236328125, 40.745628356933594), new float[]{0, 0.4259708f, 0.5892781f, 0.8021978f, 1}, new Color[]{WHITE, WHITE, new Color(0xF1F1F1), new Color(0xEAEAEA), new Color(0xDFDFDF)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);
        g.setPaint(BLACK);
        g.setStroke(new BasicStroke(2, 1, 1, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.25f * origAlpha));

        // _0_0_15_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(71.78125, 16.0);
        ((GeneralPath) shape).curveTo(67.47136, 16.0, 64.0, 19.471355, 64.0, 23.78125);
        ((GeneralPath) shape).lineTo(64.0, 40.0);
        ((GeneralPath) shape).lineTo(8.0, 40.0);
        ((GeneralPath) shape).lineTo(8.0, 104.0);
        ((GeneralPath) shape).lineTo(120.0, 104.0);
        ((GeneralPath) shape).lineTo(120.0, 23.78125);
        ((GeneralPath) shape).curveTo(120.0, 19.471355, 116.52865, 16.0, 112.21875, 16.0);
        ((GeneralPath) shape).lineTo(71.78125, 16.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(55.54030227661133, 199.0931854248047), new Point2D.Double(53.0167236328125, 40.745628356933594), new float[]{0, 0.4259708f, 0.5892781f, 0.8021978f, 1}, new Color[]{WHITE, WHITE, new Color(0xF1F1F1), new Color(0xEAEAEA), new Color(0xDFDFDF)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);
        g.setPaint(BLACK);
        g.setStroke(new BasicStroke(4, 1, 1, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_15_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(71.78125, 16.0);
        ((GeneralPath) shape).curveTo(67.47136, 16.0, 64.0, 19.471355, 64.0, 23.78125);
        ((GeneralPath) shape).lineTo(64.0, 40.0);
        ((GeneralPath) shape).lineTo(8.0, 40.0);
        ((GeneralPath) shape).lineTo(8.0, 104.0);
        ((GeneralPath) shape).lineTo(120.0, 104.0);
        ((GeneralPath) shape).lineTo(120.0, 23.78125);
        ((GeneralPath) shape).curveTo(120.0, 19.471355, 116.52865, 16.0, 112.21875, 16.0);
        ((GeneralPath) shape).lineTo(71.78125, 16.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(55.54030227661133, 199.0931854248047), new Point2D.Double(53.0167236328125, 40.745628356933594), new float[]{0, 0.4259708f, 0.5892781f, 0.8021978f, 1}, new Color[]{WHITE, WHITE, new Color(0xF1F1F1), new Color(0xEAEAEA), new Color(0xDFDFDF)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        // _0_0_15_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(71.78125, 16.0);
        ((GeneralPath) shape).curveTo(67.47136, 16.0, 64.0, 19.471355, 64.0, 23.78125);
        ((GeneralPath) shape).lineTo(64.0, 40.0);
        ((GeneralPath) shape).lineTo(8.0, 40.0);
        ((GeneralPath) shape).lineTo(8.0, 104.0);
        ((GeneralPath) shape).lineTo(120.0, 104.0);
        ((GeneralPath) shape).lineTo(120.0, 23.78125);
        ((GeneralPath) shape).curveTo(120.0, 19.471355, 116.52865, 16.0, 112.21875, 16.0);
        ((GeneralPath) shape).lineTo(71.78125, 16.0);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(71.78125, 20.0);
        ((GeneralPath) shape).lineTo(112.21875, 20.0);
        ((GeneralPath) shape).curveTo(114.38082, 20.0, 116.0, 21.619188, 116.0, 23.78125);
        ((GeneralPath) shape).lineTo(116.0, 100.0);
        ((GeneralPath) shape).lineTo(12.0, 100.0);
        ((GeneralPath) shape).lineTo(12.0, 44.0);
        ((GeneralPath) shape).lineTo(64.0, 44.0);
        ((GeneralPath) shape).lineTo(68.0, 44.0);
        ((GeneralPath) shape).lineTo(68.0, 40.0);
        ((GeneralPath) shape).lineTo(68.0, 23.78125);
        ((GeneralPath) shape).curveTo(68.0, 21.61919, 69.619194, 20.0, 71.78125, 20.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));

        // _0_0_16
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(72.0, 24.0);
        ((GeneralPath) shape).lineTo(72.0, 48.0);
        ((GeneralPath) shape).lineTo(16.0, 48.0);
        ((GeneralPath) shape).lineTo(16.0, 96.0);
        ((GeneralPath) shape).lineTo(112.0, 96.0);
        ((GeneralPath) shape).lineTo(112.0, 56.0);
        ((GeneralPath) shape).lineTo(112.0, 48.0);
        ((GeneralPath) shape).lineTo(112.0, 24.0);
        ((GeneralPath) shape).lineTo(72.0, 24.0);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.1f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.928571f, 0, 0, 0.928571f, 71.74028f, 4.4156084f));

        // _0_0_17
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_17_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(41.438, 24.399);
        ((GeneralPath) shape).lineTo(56.0, 28.0);
        ((GeneralPath) shape).lineTo(41.438, 31.601);
        ((GeneralPath) shape).lineTo(52.249, 42.0);
        ((GeneralPath) shape).lineTo(37.837, 37.837);
        ((GeneralPath) shape).lineTo(42.0, 52.249);
        ((GeneralPath) shape).lineTo(31.601, 41.438);
        ((GeneralPath) shape).lineTo(28.0, 56.0);
        ((GeneralPath) shape).lineTo(24.399, 41.438);
        ((GeneralPath) shape).lineTo(14.0, 52.249);
        ((GeneralPath) shape).lineTo(18.163, 37.837);
        ((GeneralPath) shape).lineTo(3.751, 42.0);
        ((GeneralPath) shape).lineTo(14.562, 31.601);
        ((GeneralPath) shape).lineTo(0.0, 28.0);
        ((GeneralPath) shape).lineTo(14.562, 24.399);
        ((GeneralPath) shape).lineTo(3.751, 14.0);
        ((GeneralPath) shape).lineTo(18.163, 18.163);
        ((GeneralPath) shape).lineTo(14.0, 3.751);
        ((GeneralPath) shape).lineTo(24.399, 14.562);
        ((GeneralPath) shape).lineTo(28.0, 0.0);
        ((GeneralPath) shape).lineTo(28.0, 0.0);
        ((GeneralPath) shape).lineTo(31.601, 14.562);
        ((GeneralPath) shape).lineTo(42.0, 3.751);
        ((GeneralPath) shape).lineTo(37.837, 18.163);
        ((GeneralPath) shape).lineTo(52.249, 14.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xBF5E00));
        g.setStroke(new BasicStroke(8.615389f, 0, 1, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_17
        g.setComposite(AlphaComposite.getInstance(3, 0.15f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.928571f, 0, 0, 0.928571f, 71.74028f, 4.4156084f));

        // _0_0_18
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_18_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(41.438, 24.399);
        ((GeneralPath) shape).lineTo(56.0, 28.0);
        ((GeneralPath) shape).lineTo(41.438, 31.601);
        ((GeneralPath) shape).lineTo(52.249, 42.0);
        ((GeneralPath) shape).lineTo(37.837, 37.837);
        ((GeneralPath) shape).lineTo(42.0, 52.249);
        ((GeneralPath) shape).lineTo(31.601, 41.438);
        ((GeneralPath) shape).lineTo(28.0, 56.0);
        ((GeneralPath) shape).lineTo(24.399, 41.438);
        ((GeneralPath) shape).lineTo(14.0, 52.249);
        ((GeneralPath) shape).lineTo(18.163, 37.837);
        ((GeneralPath) shape).lineTo(3.751, 42.0);
        ((GeneralPath) shape).lineTo(14.562, 31.601);
        ((GeneralPath) shape).lineTo(0.0, 28.0);
        ((GeneralPath) shape).lineTo(14.562, 24.399);
        ((GeneralPath) shape).lineTo(3.751, 14.0);
        ((GeneralPath) shape).lineTo(18.163, 18.163);
        ((GeneralPath) shape).lineTo(14.0, 3.751);
        ((GeneralPath) shape).lineTo(24.399, 14.562);
        ((GeneralPath) shape).lineTo(28.0, 0.0);
        ((GeneralPath) shape).lineTo(28.0, 0.0);
        ((GeneralPath) shape).lineTo(31.601, 14.562);
        ((GeneralPath) shape).lineTo(42.0, 3.751);
        ((GeneralPath) shape).lineTo(37.837, 18.163);
        ((GeneralPath) shape).lineTo(52.249, 14.0);
        ((GeneralPath) shape).closePath();

        g.setStroke(new BasicStroke(6.4615417f, 0, 1, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_18
        g.setComposite(AlphaComposite.getInstance(3, 0.2f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.928571f, 0, 0, 0.928571f, 71.74028f, 4.4156084f));

        // _0_0_19
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_19_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(41.438, 24.399);
        ((GeneralPath) shape).lineTo(56.0, 28.0);
        ((GeneralPath) shape).lineTo(41.438, 31.601);
        ((GeneralPath) shape).lineTo(52.249, 42.0);
        ((GeneralPath) shape).lineTo(37.837, 37.837);
        ((GeneralPath) shape).lineTo(42.0, 52.249);
        ((GeneralPath) shape).lineTo(31.601, 41.438);
        ((GeneralPath) shape).lineTo(28.0, 56.0);
        ((GeneralPath) shape).lineTo(24.399, 41.438);
        ((GeneralPath) shape).lineTo(14.0, 52.249);
        ((GeneralPath) shape).lineTo(18.163, 37.837);
        ((GeneralPath) shape).lineTo(3.751, 42.0);
        ((GeneralPath) shape).lineTo(14.562, 31.601);
        ((GeneralPath) shape).lineTo(0.0, 28.0);
        ((GeneralPath) shape).lineTo(14.562, 24.399);
        ((GeneralPath) shape).lineTo(3.751, 14.0);
        ((GeneralPath) shape).lineTo(18.163, 18.163);
        ((GeneralPath) shape).lineTo(14.0, 3.751);
        ((GeneralPath) shape).lineTo(24.399, 14.562);
        ((GeneralPath) shape).lineTo(28.0, 0.0);
        ((GeneralPath) shape).lineTo(28.0, 0.0);
        ((GeneralPath) shape).lineTo(31.601, 14.562);
        ((GeneralPath) shape).lineTo(42.0, 3.751);
        ((GeneralPath) shape).lineTo(37.837, 18.163);
        ((GeneralPath) shape).lineTo(52.249, 14.0);
        ((GeneralPath) shape).closePath();

        g.setStroke(new BasicStroke(4.3076944f, 0, 1, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_19
        g.setComposite(AlphaComposite.getInstance(3, 0.25f * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.928571f, 0, 0, 0.928571f, 71.74028f, 4.4156084f));

        // _0_0_20
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_20_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(41.438, 24.399);
        ((GeneralPath) shape).lineTo(56.0, 28.0);
        ((GeneralPath) shape).lineTo(41.438, 31.601);
        ((GeneralPath) shape).lineTo(52.249, 42.0);
        ((GeneralPath) shape).lineTo(37.837, 37.837);
        ((GeneralPath) shape).lineTo(42.0, 52.249);
        ((GeneralPath) shape).lineTo(31.601, 41.438);
        ((GeneralPath) shape).lineTo(28.0, 56.0);
        ((GeneralPath) shape).lineTo(24.399, 41.438);
        ((GeneralPath) shape).lineTo(14.0, 52.249);
        ((GeneralPath) shape).lineTo(18.163, 37.837);
        ((GeneralPath) shape).lineTo(3.751, 42.0);
        ((GeneralPath) shape).lineTo(14.562, 31.601);
        ((GeneralPath) shape).lineTo(0.0, 28.0);
        ((GeneralPath) shape).lineTo(14.562, 24.399);
        ((GeneralPath) shape).lineTo(3.751, 14.0);
        ((GeneralPath) shape).lineTo(18.163, 18.163);
        ((GeneralPath) shape).lineTo(14.0, 3.751);
        ((GeneralPath) shape).lineTo(24.399, 14.562);
        ((GeneralPath) shape).lineTo(28.0, 0.0);
        ((GeneralPath) shape).lineTo(28.0, 0.0);
        ((GeneralPath) shape).lineTo(31.601, 14.562);
        ((GeneralPath) shape).lineTo(42.0, 3.751);
        ((GeneralPath) shape).lineTo(37.837, 18.163);
        ((GeneralPath) shape).lineTo(52.249, 14.0);
        ((GeneralPath) shape).closePath();

        g.setStroke(new BasicStroke(2.1538472f, 0, 1, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_20
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.928571f, 0, 0, 0.928571f, 71.74028f, 4.4156084f));

        // _0_0_21

        // _0_0_21_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(41.438, 24.399);
        ((GeneralPath) shape).lineTo(56.0, 28.0);
        ((GeneralPath) shape).lineTo(41.438, 31.601);
        ((GeneralPath) shape).lineTo(52.249, 42.0);
        ((GeneralPath) shape).lineTo(37.837, 37.837);
        ((GeneralPath) shape).lineTo(42.0, 52.249);
        ((GeneralPath) shape).lineTo(31.601, 41.438);
        ((GeneralPath) shape).lineTo(28.0, 56.0);
        ((GeneralPath) shape).lineTo(24.399, 41.438);
        ((GeneralPath) shape).lineTo(14.0, 52.249);
        ((GeneralPath) shape).lineTo(18.163, 37.837);
        ((GeneralPath) shape).lineTo(3.751, 42.0);
        ((GeneralPath) shape).lineTo(14.562, 31.601);
        ((GeneralPath) shape).lineTo(0.0, 28.0);
        ((GeneralPath) shape).lineTo(14.562, 24.399);
        ((GeneralPath) shape).lineTo(3.751, 14.0);
        ((GeneralPath) shape).lineTo(18.163, 18.163);
        ((GeneralPath) shape).lineTo(14.0, 3.751);
        ((GeneralPath) shape).lineTo(24.399, 14.562);
        ((GeneralPath) shape).lineTo(28.0, 0.0);
        ((GeneralPath) shape).lineTo(28.0, 0.0);
        ((GeneralPath) shape).lineTo(31.601, 14.562);
        ((GeneralPath) shape).lineTo(42.0, 3.751);
        ((GeneralPath) shape).lineTo(37.837, 18.163);
        ((GeneralPath) shape).lineTo(52.249, 14.0);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(28, 57.5), new Point2D.Double(28, 0), new float[]{0, 1}, new Color[]{new Color(0xFFEA00), new Color(0xFFCC00)}, NO_CYCLE, SRGB, new AffineTransform()));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_21

        // _0_0_22
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(97.75042, 6.4141383);
        ((GeneralPath) shape).lineTo(94.65667, 18.882889);
        ((GeneralPath) shape).lineTo(85.75042, 9.632889);
        ((GeneralPath) shape).lineTo(89.31292, 21.976639);
        ((GeneralPath) shape).lineTo(76.96917, 18.414139);
        ((GeneralPath) shape).lineTo(86.21917, 27.320389);
        ((GeneralPath) shape).lineTo(79.06292, 29.101639);
        ((GeneralPath) shape).curveTo(84.0324, 31.664938, 90.58036, 33.22664, 97.75042, 33.22664);
        ((GeneralPath) shape).curveTo(104.92048, 33.22664, 111.43719, 31.664938, 116.40667, 29.101639);
        ((GeneralPath) shape).lineTo(109.25042, 27.320389);
        ((GeneralPath) shape).lineTo(118.53167, 18.414139);
        ((GeneralPath) shape).lineTo(106.15667, 21.976639);
        ((GeneralPath) shape).lineTo(109.75042, 9.632889);
        ((GeneralPath) shape).lineTo(100.81292, 18.882889);
        ((GeneralPath) shape).lineTo(97.75042, 6.414139);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(-39.53125, 78), new Point2D.Double(-39.53125, 51.1875), new float[]{0, 1}, new Color[]{new Color(0xFFF8A8), new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(1, 0, 0, 1, 137.28168f, -44.77336f)));
        g.fill(shape);

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
        return 128;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     *
     * @return The height of the bounding box of the original SVG image.
     */
    public static int getOrigHeight() {
        return 108;
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
    public TabNew6() {
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

