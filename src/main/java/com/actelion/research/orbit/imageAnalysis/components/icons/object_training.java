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
public class object_training implements ResizableIcon {
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
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -87.73738861083984f, 169.78179931640625f));
// _0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(119.05743f, -145.78683f);
generalPath.curveTo(115.51431f, -145.78683f, 114.64295f, -143.86617f, 114.64295f, -141.49615f);
generalPath.curveTo(114.64295f, -139.91615f, 113.92347f, -138.53854f, 115.82432f, -137.79372f);
generalPath.lineTo(115.82432f, -135.71758f);
generalPath.curveTo(115.82432f, -135.18779f, 116.45486f, -134.76604f, 117.24689f, -134.76604f);
generalPath.lineTo(121.64391f, -134.76604f);
generalPath.curveTo(122.43594f, -134.76604f, 123.09234f, -135.18779f, 123.09234f, -135.71758f);
generalPath.lineTo(123.09234f, -138.15704f);
generalPath.curveTo(124.54372f, -138.94379f, 123.4719f, -140.14922f, 123.4719f, -141.49615f);
generalPath.curveTo(123.4719f, -143.86617f, 122.60054f, -145.78683f, 119.05743f, -145.78683f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 170, 170, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(93.84375f, -151.53125f);
generalPath.curveTo(93.84375f, -151.53125f, 94.03707f, -149.4167f, 95.90625f, -147.49544f);
generalPath.curveTo(95.13952f, -143.1072f, 95.45999f, -140.64339f, 97.0f, -137.66814f);
generalPath.curveTo(100.74802f, -133.68304f, 104.02066f, -128.17136f, 109.65625f, -131.87663f);
generalPath.curveTo(113.43222f, -138.30524f, 105.92692f, -139.88535f, 101.53125f, -140.63228f);
generalPath.curveTo(100.46818f, -142.95331f, 98.47306f, -144.69778f, 97.5625f, -147.10782f);
generalPath.curveTo(97.35132f, -147.29715f, 97.21199f, -147.43573f, 97.09375f, -147.56384f);
generalPath.lineTo(99.6875f, -148.33908f);
generalPath.lineTo(99.875f, -151.23483f);
generalPath.lineTo(93.84375f, -151.53125f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
paint = new Color(0, 255, 255, 255);
stroke = new BasicStroke(0.85418844f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(108.12854f, -128.59427f);
generalPath.curveTo(108.12854f, -128.59427f, 113.16616f, -122.20186f, 113.16616f, -120.44394f);
generalPath.curveTo(113.16616f, -118.68603f, 113.82324f, -112.93286f, 113.82324f, -112.93286f);
generalPath.curveTo(116.63199f, -112.68533f, 122.4706f, -112.62183f, 125.887f, -112.93286f);
generalPath.curveTo(125.887f, -112.93286f, 126.54408f, -118.68603f, 126.54408f, -120.44394f);
generalPath.curveTo(126.54408f, -122.20186f, 131.5817f, -128.59427f, 131.5817f, -128.59427f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(143.79387f, -150.92247f);
generalPath.curveTo(143.79387f, -150.92247f, 143.60056f, -148.80792f, 141.73137f, -146.88666f);
generalPath.curveTo(142.4981f, -142.49841f, 142.17763f, -140.0346f, 140.63762f, -137.05936f);
generalPath.curveTo(136.8896f, -133.07426f, 133.61696f, -127.56257f, 127.98137f, -131.26785f);
generalPath.curveTo(124.2054f, -137.69646f, 131.7107f, -139.27657f, 136.10637f, -140.0235f);
generalPath.curveTo(137.16943f, -142.34453f, 139.16457f, -144.089f, 140.07512f, -146.49904f);
generalPath.curveTo(140.2863f, -146.68837f, 140.42563f, -146.82695f, 140.54387f, -146.95506f);
generalPath.lineTo(137.95012f, -147.7303f);
generalPath.lineTo(137.76262f, -150.62605f);
generalPath.lineTo(143.79387f, -150.92247f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
shape = new Ellipse2D.Double(91.95555114746094, -168.1304473876953, 9.05810546875, 15.859801292419434);
paint = new Color(0, 255, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 255, 0, 255);
stroke = new BasicStroke(2.1513991f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(91.95555114746094, -168.1304473876953, 9.05810546875, 15.859801292419434);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5
shape = new Ellipse2D.Double(127.53123474121094, -163.34356689453125, 20.738136291503906, 11.461929321289062);
paint = new Color(255, 0, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 0, 255, 255);
stroke = new BasicStroke(2.7673693f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(127.53123474121094, -163.34356689453125, 20.738136291503906, 11.461929321289062);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6
shape = new Ellipse2D.Double(108.05567169189453, -167.2455291748047, 13.585773468017578, 16.714242935180664);
paint = new Color(0, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 255, 255, 255);
stroke = new BasicStroke(2.7048235f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(108.05567169189453, -167.2455291748047, 13.585773468017578, 16.714242935180664);
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
        return 3.1424636840820312;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 0.575653076171875;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 58.7732048034668;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 57.01220703125;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private object_training() {
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
       object_training base = new object_training();
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
       object_training base = new object_training();
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
        return object_training::new;
    }
}

