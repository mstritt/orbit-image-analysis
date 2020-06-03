package com.actelion.research.orbit.imageAnalysis.components.icons;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.ref.WeakReference;
import java.util.Base64;
import java.util.Stack;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import javax.swing.plaf.UIResource;

import org.pushingpixels.neon.api.icon.ResizableIcon;
import org.pushingpixels.neon.api.icon.ResizableIconUIResource;

/**
 * This class has been automatically generated using <a
 * href="https://github.com/kirill-grouchnikov/radiance">Photon SVG transcoder</a>.
 */
public class clustering implements ResizableIcon {
    private Shape shape = null;
    private GeneralPath generalPath = null;
    private Paint paint = null;
    private Stroke stroke = null;
    private Shape clip = null;
    private Stack<AffineTransform> transformsStack = new Stack<>();

    

	private void _paint0(Graphics2D g,float origAlpha) {
transformsStack.push(g.getTransform());
// 
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -79.62864685058594f, -236.8760986328125f));
// _0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0
shape = new Ellipse2D.Double(108.16342163085938, 257.1127624511719, 8.58731460571289, 8.58731460571289);
paint = new Color(85, 153, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(85, 153, 255, 255);
stroke = new BasicStroke(2.0f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(108.16342163085938, 257.1127624511719, 8.58731460571289, 8.58731460571289);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
shape = new Ellipse2D.Double(94.39566040039062, 279.344970703125, 8.58731460571289, 8.58731460571289);
paint = new Color(85, 153, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(85, 153, 255, 255);
stroke = new BasicStroke(2.0f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(94.39566040039062, 279.344970703125, 8.58731460571289, 8.58731460571289);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
shape = new Ellipse2D.Double(108.71456146240234, 288.5373840332031, 8.58731460571289, 8.58731460571289);
paint = new Color(85, 153, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(85, 153, 255, 255);
stroke = new BasicStroke(2.0f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(108.71456146240234, 288.5373840332031, 8.58731460571289, 8.58731460571289);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3
shape = new Ellipse2D.Double(94.3956527709961, 292.956787109375, 8.58731460571289, 8.58731460571289);
paint = new Color(85, 153, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(85, 153, 255, 255);
stroke = new BasicStroke(2.0f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(94.3956527709961, 292.956787109375, 8.58731460571289, 8.58731460571289);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
shape = new Ellipse2D.Double(112.60364532470703, 274.3952331542969, 8.58731460571289, 8.58731460571289);
paint = new Color(85, 153, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(85, 153, 255, 255);
stroke = new BasicStroke(2.0f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(112.60364532470703, 274.3952331542969, 8.58731460571289, 8.58731460571289);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5
shape = new Ellipse2D.Double(96.05250549316406, 266.7938537597656, 8.58731460571289, 8.58731460571289);
paint = new Color(85, 153, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(85, 153, 255, 255);
stroke = new BasicStroke(2.0f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(96.05250549316406, 266.7938537597656, 8.58731460571289, 8.58731460571289);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6
shape = new Ellipse2D.Double(106.3956527709961, 340.956787109375, 8.58731460571289, 8.58731460571289);
paint = new Color(0, 255, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 255, 0, 255);
stroke = new BasicStroke(2.0f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(106.3956527709961, 340.956787109375, 8.58731460571289, 8.58731460571289);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
shape = new Ellipse2D.Double(127.14781188964844, 340.42645263671875, 8.58731460571289, 8.58731460571289);
paint = new Color(0, 255, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 255, 0, 255);
stroke = new BasicStroke(2.0f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(127.14781188964844, 340.42645263671875, 8.58731460571289, 8.58731460571289);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8
shape = new Ellipse2D.Double(119.89997100830078, 328.6482849121094, 8.58731460571289, 8.58731460571289);
paint = new Color(0, 255, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 255, 0, 255);
stroke = new BasicStroke(2.0f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(119.89997100830078, 328.6482849121094, 8.58731460571289, 8.58731460571289);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9
shape = new Ellipse2D.Double(133.0473175048828, 327.5217590332031, 8.58731460571289, 8.58731460571289);
paint = new Color(0, 255, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 255, 0, 255);
stroke = new BasicStroke(2.0f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(133.0473175048828, 327.5217590332031, 8.58731460571289, 8.58731460571289);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10
shape = new Ellipse2D.Double(144.89134216308594, 334.8562927246094, 8.58731460571289, 8.58731460571289);
paint = new Color(0, 255, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 255, 0, 255);
stroke = new BasicStroke(2.0f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(144.89134216308594, 334.8562927246094, 8.58731460571289, 8.58731460571289);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_11
shape = new Ellipse2D.Double(142.683349609375, 318.572021484375, 8.58731460571289, 8.58731460571289);
paint = new Color(0, 255, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 255, 0, 255);
stroke = new BasicStroke(2.0f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(142.683349609375, 318.572021484375, 8.58731460571289, 8.58731460571289);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_12
shape = new Ellipse2D.Double(117.46672821044922, 346.9671936035156, 8.58731460571289, 8.58731460571289);
paint = new Color(0, 255, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 255, 0, 255);
stroke = new BasicStroke(2.0f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(117.46672821044922, 346.9671936035156, 8.58731460571289, 8.58731460571289);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_13
shape = new Ellipse2D.Double(129.53257751464844, 313.2478942871094, 8.58731460571289, 8.58731460571289);
paint = new Color(0, 255, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 255, 0, 255);
stroke = new BasicStroke(2.0f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(129.53257751464844, 313.2478942871094, 8.58731460571289, 8.58731460571289);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_14
shape = new Ellipse2D.Double(162.46151733398438, 267.5043640136719, 8.58731460571289, 8.58731460571289);
paint = new Color(255, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 0, 0, 255);
stroke = new BasicStroke(2.0f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(162.46151733398438, 267.5043640136719, 8.58731460571289, 8.58731460571289);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15
shape = new Ellipse2D.Double(166.173828125, 278.68634033203125, 8.58731460571289, 8.58731460571289);
paint = new Color(255, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 0, 0, 255);
stroke = new BasicStroke(2.0f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(166.173828125, 278.68634033203125, 8.58731460571289, 8.58731460571289);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_16
shape = new Ellipse2D.Double(175.05770874023438, 269.4281005859375, 8.58731460571289, 8.58731460571289);
paint = new Color(255, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 0, 0, 255);
stroke = new BasicStroke(2.0f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(175.05770874023438, 269.4281005859375, 8.58731460571289, 8.58731460571289);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17
shape = new Ellipse2D.Double(177.82028198242188, 283.4801330566406, 8.58731460571289, 8.58731460571289);
paint = new Color(255, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 0, 0, 255);
stroke = new BasicStroke(2.0f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(177.82028198242188, 283.4801330566406, 8.58731460571289, 8.58731460571289);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_18
shape = new Ellipse2D.Double(172.9155731201172, 256.39166259765625, 8.58731460571289, 8.58731460571289);
paint = new Color(255, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 0, 0, 255);
stroke = new BasicStroke(2.0f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(172.9155731201172, 256.39166259765625, 8.58731460571289, 8.58731460571289);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_19
shape = new Ellipse2D.Double(186.6591033935547, 260.6308898925781, 8.58731460571289, 8.58731460571289);
paint = new Color(255, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 0, 0, 255);
stroke = new BasicStroke(2.0f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(186.6591033935547, 260.6308898925781, 8.58731460571289, 8.58731460571289);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_20
shape = new Ellipse2D.Double(188.34019470214844, 274.4645080566406, 8.58731460571289, 8.58731460571289);
paint = new Color(255, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 0, 0, 255);
stroke = new BasicStroke(2.0f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(188.34019470214844, 274.4645080566406, 8.58731460571289, 8.58731460571289);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_21
shape = new Ellipse2D.Double(164.3644256591797, 291.171630859375, 8.58731460571289, 8.58731460571289);
paint = new Color(255, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 0, 0, 255);
stroke = new BasicStroke(2.0f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(164.3644256591797, 291.171630859375, 8.58731460571289, 8.58731460571289);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_22
shape = new Ellipse2D.Double(155.14781188964844, 281.2513122558594, 8.58731460571289, 8.58731460571289);
paint = new Color(255, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 0, 0, 255);
stroke = new BasicStroke(2.0f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(155.14781188964844, 281.2513122558594, 8.58731460571289, 8.58731460571289);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_23
shape = new Ellipse2D.Double(181.86190795898438, 248.21490478515625, 8.58731460571289, 8.58731460571289);
paint = new Color(255, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 0, 0, 255);
stroke = new BasicStroke(2.0f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(181.86190795898438, 248.21490478515625, 8.58731460571289, 8.58731460571289);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());

}



    @SuppressWarnings("unused")
	private void innerPaint(Graphics2D g) {
        float origAlpha = 1.0f;
        Composite origComposite = g.getComposite();
        if (origComposite instanceof AlphaComposite) {
            AlphaComposite origAlphaComposite = 
                (AlphaComposite)origComposite;
            if (origAlphaComposite.getRule() == AlphaComposite.SRC_OVER) {
                origAlpha = origAlphaComposite.getAlpha();
            }
        }
        
	    _paint0(g, origAlpha);


	    shape = null;
	    generalPath = null;
	    paint = null;
	    stroke = null;
	    clip = null;
        transformsStack.clear();
	}

    /**
     * Returns the X of the bounding box of the original SVG image.
     * 
     * @return The X of the bounding box of the original SVG image.
     */
    public static double getOrigX() {
        return 13.767005920410156;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 10.33880615234375;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 104.5318603515625;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 109.339599609375;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private clustering() {
        this.width = (int) getOrigWidth();
        this.height = (int) getOrigHeight();
	}

    @Override
	public int getIconHeight() {
		return height;
	}

    @Override
	public int getIconWidth() {
		return width;
	}

	@Override
	public synchronized void setDimension(Dimension newDimension) {
		this.width = newDimension.width;
		this.height = newDimension.height;
	}

    @Override
	public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		g2d.translate(x, y);

        double coef1 = (double) this.width / getOrigWidth();
        double coef2 = (double) this.height / getOrigHeight();
        double coef = Math.min(coef1, coef2);
        g2d.clipRect(0, 0, this.width, this.height);
        g2d.scale(coef, coef);
        g2d.translate(-getOrigX(), -getOrigY());
        if (coef1 != coef2) {
            if (coef1 < coef2) {
               int extraDy = (int) ((getOrigWidth() - getOrigHeight()) / 2.0);
               g2d.translate(0, extraDy);
            } else {
               int extraDx = (int) ((getOrigHeight() - getOrigWidth()) / 2.0);
               g2d.translate(extraDx, 0);
            }
        }
        Graphics2D g2ForInner = (Graphics2D) g2d.create();
        innerPaint(g2ForInner);
        g2ForInner.dispose();
        g2d.dispose();
	}
    
    /**
     * Returns a new instance of this icon with specified dimensions.
     *
     * @param width Required width of the icon
     * @param height Required height of the icon
     * @return A new instance of this icon with specified dimensions.
     */
    public static ResizableIcon of(int width, int height) {
       clustering base = new clustering();
       base.width = width;
       base.height = height;
       return base;
    }

    /**
     * Returns a new {@link UIResource} instance of this icon with specified dimensions.
     *
     * @param width Required width of the icon
     * @param height Required height of the icon
     * @return A new {@link UIResource} instance of this icon with specified dimensions.
     */
    public static ResizableIconUIResource uiResourceOf(int width, int height) {
       clustering base = new clustering();
       base.width = width;
       base.height = height;
       return new ResizableIconUIResource(base);
    }

    /**
     * Returns a factory that returns instances of this icon on demand.
     *
     * @return Factory that returns instances of this icon on demand.
     */
    public static Factory factory() {
        return clustering::new;
    }
}

