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

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class SyncImages implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

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
        g.setComposite(AlphaComposite.getInstance(3, 0.6f * origAlpha));

        // _0_0_0
        shape = new Rectangle2D.Double(0.9569954872131348, 17.143653869628906, 20.21894073486328, 14.217958450317383);
        g.setPaint(BLACK);
        g.fill(shape);
        g.setPaint(WHITE);
        g.setStroke(new BasicStroke(0.67052996f, 1, 1, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-1.3013736f, 0.2214118f, 0.12007444f, 0.8407345f, 58.809856f, 4.8729825f));

        // _0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xCCCCCC));
        g.fill(shape);
        g.setStroke(new BasicStroke(0.3600241f, 1, 1, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_1
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.74827003f, 0, 0, -0.43834704f, -22.151905f, 34.304516f));

        // _0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_2
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.5164211f, -0.07485282f, -0.04476672f, -0.30252665f, -12.003883f, 35.669044f));

        // _0_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_3
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.82511973f, -0.1272971f, -0.0761317f, -0.48336664f, -19.306906f, 32.192276f));

        // _0_0_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_4
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.5659811f, -0.04718491f, -0.02643004f, 0.35400873f, 27.330938f, 18.3056f));

        // _0_0_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_5
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.8219947f, 0.03811642f, 0.02135043f, 0.51413965f, 41.536907f, 16.947582f));

        // _0_0_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_6
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.6986327f, -0.08479823f, -0.04749868f, 0.43697944f, 30.989256f, 15.789931f));

        // _0_0_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_7

        // _0_0_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(13.908886, 12.997231);
        ((GeneralPath) shape).curveTo(14.361232, 11.313366, 15.306676, 9.752119, 16.720943, 8.562277);
        ((GeneralPath) shape).curveTo(20.356043, 5.5040245, 25.71186, 6.057538, 28.683504, 9.798585);
        ((GeneralPath) shape).curveTo(31.655144, 13.539631, 31.117308, 19.051552, 27.48221, 22.109804);
        ((GeneralPath) shape).curveTo(25.501675, 23.776052, 23.010351, 24.37016, 20.672132, 23.960737);

        g.setPaint(new Color(0xFF6600));
        g.setStroke(new BasicStroke(3, 1, 1, 4));
        g.draw(shape);
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-1.193729f, 0.23289323f, 0.15743804f, 0.70210385f, 48.754387f, 5.0350413f));

        // _0_0_9
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xCCCCCC));
        g.fill(shape);
        g.setStroke(new BasicStroke(0.3600241f, 1, 1, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_9
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.48660082f, 0.12399441f, 0.09238227f, 0.28786936f, 24.804892f, 8.649645f));

        // _0_0_10
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_10
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-1.0458869f, 0.01258342f, -0.04789827f, 0.6041445f, 46.270138f, 9.382223f));

        // _0_0_11
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_11
        g.setComposite(AlphaComposite.getInstance(3, 0.6f * origAlpha));

        // _0_0_12
        shape = new Rectangle2D.Double(0.7432937622070312, 0.35101190209388733, 20.21894073486328, 14.217958450317383);
        g.setPaint(BLACK);
        g.fill(shape);
        g.setPaint(WHITE);
        g.setStroke(new BasicStroke(0.67052996f, 1, 1, 4));
        g.draw(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.74827003f, 0, 0, -0.43834704f, -22.423235f, 17.557356f));

        // _0_0_13
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xCCCCCC));
        g.fill(shape);
        g.setStroke(new BasicStroke(0.3600241f, 1, 1, 4));
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_13
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.5164211f, -0.07485282f, -0.04476672f, -0.30252665f, -12.275211f, 18.921886f));

        // _0_0_14
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_14
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.8219948f, -0.03811642f, -0.02135043f, -0.51413965f, -14.117989f, 14.539021f));

        // _0_0_15
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_15
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(0.4913348f, 0.5838344f, 0.4736658f, -0.2686239f, -17.382809f, -11.168105f));

        // _0_0_16
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_16
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.19603299f, -0.45881495f, -0.3825529f, 0.1330815f, 17.403046f, 18.929237f));

        // _0_0_17
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_17
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.3964959f, -0.6200963f, -0.52968496f, 0.23954397f, 31.48222f, 27.313301f));

        // _0_0_18
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_18
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.21414258f, -0.57786757f, -0.47866526f, 0.15275256f, 21.626884f, 20.671406f));

        // _0_0_19
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_19
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.82511973f, 0.1272971f, 0.0761317f, 0.48336664f, 47.415276f, -10.318966f));

        // _0_0_20
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_20
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.76191014f, -0.82351756f, -0.6676899f, 0.4264724f, 50.63535f, 29.280012f));

        // _0_0_21
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_21
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.7662675f, -0.02716748f, -0.04596153f, 0.47785786f, 40.412315f, 2.7166035f));

        // _0_0_22
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_22
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.34104007f, -0.3230864f, -0.26168755f, 0.19641285f, 26.429201f, 12.784556f));

        // _0_0_23
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_23
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(-0.46684426f, -0.8045742f, -0.654069f, 0.22495095f, 34.971836f, 29.727001f));

        // _0_0_24
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.003887, 19.249956);
        ((GeneralPath) shape).curveTo(37.004383, 19.83266, 36.78523, 20.371403, 36.429096, 20.662958);
        ((GeneralPath) shape).curveTo(36.072968, 20.954514, 35.63405, 20.954514, 35.27792, 20.662958);
        ((GeneralPath) shape).curveTo(34.921787, 20.371403, 34.702633, 19.83266, 34.70313, 19.249956);
        ((GeneralPath) shape).curveTo(34.702633, 18.667252, 34.921787, 18.12851, 35.27792, 17.836954);
        ((GeneralPath) shape).curveTo(35.63405, 17.545399, 36.072968, 17.545399, 36.429096, 17.836954);
        ((GeneralPath) shape).curveTo(36.78523, 18.12851, 37.004383, 18.667252, 37.003887, 19.249956);
        ((GeneralPath) shape).closePath();

        g.fill(shape);
        g.draw(shape);

        g.setTransform(transformations.poll()); // _0_0_24

        // _0_0_25
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(13.148792, 20.46595);
        ((GeneralPath) shape).lineTo(21.642624, 19.749557);
        ((GeneralPath) shape).lineTo(19.222473, 26.770332);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xFF6600));
        g.fill(shape);
        g.setStroke(new BasicStroke(1.4400985f, 1, 1, 4));
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
    public SyncImages() {
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

