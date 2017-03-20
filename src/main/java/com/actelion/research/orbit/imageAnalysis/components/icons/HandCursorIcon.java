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

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class HandCursorIcon implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.transform(new AffineTransform(1, 0, 0, 1, -418.58484f, -353.32162f));

        // _0_0

        // _0_0_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(419.7945, 392.4999);
        ((GeneralPath) shape).lineTo(429.85867, 407.27744);
        ((GeneralPath) shape).lineTo(432.37473, 415.76666);
        ((GeneralPath) shape).lineTo(436.7778, 420.16846);
        ((GeneralPath) shape).lineTo(436.1488, 426.77118);
        ((GeneralPath) shape).lineTo(464.4543, 426.14233);
        ((GeneralPath) shape).lineTo(464.76883, 418.91077);
        ((GeneralPath) shape).lineTo(468.8574, 417.02426);
        ((GeneralPath) shape).lineTo(468.5429, 409.1639);
        ((GeneralPath) shape).lineTo(471.68796, 406.33414);
        ((GeneralPath) shape).lineTo(472.94598, 386.526);
        ((GeneralPath) shape).lineTo(463.1963, 379.92328);
        ((GeneralPath) shape).lineTo(458.4787, 376.4647);
        ((GeneralPath) shape).lineTo(452.50308, 376.4647);
        ((GeneralPath) shape).lineTo(448.41452, 373.63495);
        ((GeneralPath) shape).lineTo(441.80988, 372.3773);
        ((GeneralPath) shape).lineTo(441.18088, 359.48627);
        ((GeneralPath) shape).lineTo(438.97934, 356.97095);
        ((GeneralPath) shape).lineTo(434.57623, 356.97095);
        ((GeneralPath) shape).lineTo(432.3747, 360.4295);
        ((GeneralPath) shape).lineTo(432.0602, 389.9846);
        ((GeneralPath) shape).lineTo(429.22964, 390.29898);
        ((GeneralPath) shape).lineTo(425.4556, 386.21158);
        ((GeneralPath) shape).lineTo(420.4235, 386.52603);
        ((GeneralPath) shape).lineTo(419.7945, 392.4999);
        ((GeneralPath) shape).closePath();

        g.setPaint(WHITE);
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(3.1078296f, 0, 0, 3.3585446f, -477.94427f, -1101.2645f));

        // _0_0_1

        // _0_0_1_0
        shape = new Rectangle2D.Double(293.82684326171875, 434.5367736816406, 1, 13.070158958435059);
        g.setPaint(new Color(0xB4B4B4));
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0, 1, 1, 0, 0, 0));

        // _0_0_1_1
        shape = new Rectangle2D.Double(433.5704650878906, 294.8509826660156, 1, 2);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_1_1

        // _0_0_1_2
        shape = new Rectangle2D.Double(296.8240966796875, 434.6076354980469, 1, 8.951157569885254);
        g.fill(shape);

        // _0_0_1_3
        shape = new Rectangle2D.Double(299.77734375, 439.54266357421875, 1, 4.054986000061035);
        g.fill(shape);

        // _0_0_1_4
        shape = new Rectangle2D.Double(302.8062438964844, 440.5307312011719, 1, 4.288136959075928);
        g.fill(shape);

        // _0_0_1_5
        shape = new Rectangle2D.Double(305.83929443359375, 442.5736389160156, 1, 7.008232116699219);
        g.fill(shape);

        // _0_0_1_6
        shape = new Rectangle2D.Double(304.8289794921875, 449.60699462890625, 1, 3.1223816871643066);
        g.fill(shape);

        // _0_0_1_7
        shape = new Rectangle2D.Double(303.8186340332031, 452.56024169921875, 1, 2.9669477939605713);
        g.fill(shape);

        // _0_0_1_8
        shape = new Rectangle2D.Double(294.803466796875, 452.6379699707031, 1, 2.9669477939605713);
        g.fill(shape);

        // _0_0_1_9
        shape = new Rectangle2D.Double(293.8482666015625, 450.41717529296875, 1, 2.178999900817871);
        g.fill(shape);

        // _0_0_1_10
        shape = new Rectangle2D.Double(292.8605651855469, 448.5743103027344, 1, 1.9789999723434448);
        g.fill(shape);

        // _0_0_1_11
        shape = new Rectangle2D.Double(291.8502197265625, 446.6261901855469, 1, 1.9789999723434448);
        g.fill(shape);

        // _0_0_1_12
        shape = new Rectangle2D.Double(290.9176330566406, 445.51568603515625, 1, 1.124112844467163);
        g.fill(shape);

        // _0_0_1_13
        shape = new Rectangle2D.Double(289.9073181152344, 442.7178649902344, 1, 2.7561700344085693);
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0, -1, -1, 0, 0, 0));

        // _0_0_1_14
        shape = new Rectangle2D.Double(-443.58563232421875, -292.7179870605469, 1, 2.7561700344085693);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_1_14

        // _0_0_1_15
        shape = new Rectangle2D.Double(292.76019287109375, 443.5339050292969, 1.100000023841858, 1.124112844467163);
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0, 1, -1, 0, 0, 0));

        // _0_0_1_16
        shape = new Rectangle2D.Double(454.5540466308594, -304.1700744628906, 1, 9.10659122467041);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_1_16

        // _0_0_1_17
        shape = new Rectangle2D.Double(304.8289794921875, 441.6686706542969, 1, 1.124112844467163);
        g.fill(shape);

        // _0_0_1_18
        shape = new Rectangle2D.Double(303.1968994140625, 440.5029296875, 1.6217360496520996, 1.124112844467163);
        g.fill(shape);

        // _0_0_1_19
        shape = new Rectangle2D.Double(300.476806640625, 439.49261474609375, 2.3989062309265137, 1.124112844467163);
        g.fill(shape);

        // _0_0_1_20
        shape = new Rectangle2D.Double(297.4458312988281, 438.4822998046875, 2.3989062309265137, 1.124112844467163);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_1

        // _0_0_2
        shape = new Rectangle2D.Double(431.4183044433594, 358.4308776855469, 3.2742371559143066, 42.78249740600586);
        g.setPaint(BLACK);
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0, 1, 1, 0, 0, 0));

        // _0_0_3
        shape = new Rectangle2D.Double(355.26788330078125, 434.7715759277344, 3.2732961177825928, 6.548474311828613);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_3

        // _0_0_4
        shape = new Rectangle2D.Double(441.2320251464844, 358.662841796875, 3.2742371559143066, 29.299787521362305);
        g.fill(shape);

        // _0_0_5
        shape = new Rectangle2D.Double(450.9016418457031, 374.816650390625, 3.2742371559143066, 13.273170471191406);
        g.fill(shape);

        // _0_0_6
        shape = new Rectangle2D.Double(460.8190002441406, 378.0508728027344, 3.2742371559143066, 14.036341667175293);
        g.fill(shape);

        // _0_0_7
        shape = new Rectangle2D.Double(470.7499084472656, 384.7379150390625, 3.2742371559143066, 22.940017700195312);
        g.fill(shape);

        // _0_0_8
        shape = new Rectangle2D.Double(467.44189453125, 407.7601623535156, 3.2742371559143066, 10.220479011535645);
        g.fill(shape);

        // _0_0_9
        shape = new Rectangle2D.Double(464.1337890625, 417.4270324707031, 3.2742371559143066, 9.711698532104492);
        g.fill(shape);

        // _0_0_10
        shape = new Rectangle2D.Double(434.6159973144531, 417.68145751953125, 3.2742371559143066, 9.711698532104492);
        g.fill(shape);

        // _0_0_11
        shape = new Rectangle2D.Double(431.4884338378906, 410.4121398925781, 3.2742371559143066, 7.132511615753174);
        g.fill(shape);

        // _0_0_12
        shape = new Rectangle2D.Double(428.2544860839844, 404.3798828125, 3.2742371559143066, 6.477852821350098);
        g.fill(shape);

        // _0_0_13
        shape = new Rectangle2D.Double(424.9463806152344, 398.00311279296875, 3.2742371559143066, 6.477852821350098);
        g.fill(shape);

        // _0_0_14
        shape = new Rectangle2D.Double(421.8928527832031, 394.36810302734375, 3.2742371559143066, 3.679553985595703);
        g.fill(shape);

        // _0_0_15
        shape = new Rectangle2D.Double(418.5848388671875, 385.21002197265625, 3.2742371559143066, 9.021759986877441);
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0, -1, -1, 0, 0, 0));

        // _0_0_16
        shape = new Rectangle2D.Double(-388.05047607421875, -427.7876281738281, 3.2732961177825928, 9.024353981018066);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_16

        // _0_0_17
        shape = new Rectangle2D.Double(427.92584228515625, 387.88116455078125, 3.601660966873169, 3.679553985595703);
        g.fill(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0, 1, -1, 0, 0, 0));

        // _0_0_18
        shape = new Rectangle2D.Double(423.9533386230469, -465.28448486328125, 3.2732961177825928, 29.817138671875);
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0_18

        // _0_0_19
        shape = new Rectangle2D.Double(467.44189453125, 381.77569580078125, 3.2742371559143066, 3.679553985595703);
        g.fill(shape);

        // _0_0_20
        shape = new Rectangle2D.Double(462.09808349609375, 377.9598693847656, 5.309948444366455, 3.679553985595703);
        g.fill(shape);

        // _0_0_21
        shape = new Rectangle2D.Double(453.1918640136719, 374.65283203125, 7.854587554931641, 3.679553985595703);
        g.fill(shape);

        // _0_0_22
        shape = new Rectangle2D.Double(443.2677307128906, 371.34576416015625, 7.854587554931641, 3.679553985595703);
        g.fill(shape);

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
        return 59;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     *
     * @return The height of the bounding box of the original SVG image.
     */
    public static int getOrigHeight() {
        return 78;
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
    public HandCursorIcon() {
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

