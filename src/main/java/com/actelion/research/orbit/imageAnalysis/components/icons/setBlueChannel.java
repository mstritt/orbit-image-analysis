package com.actelion.research.orbit.imageAnalysis.components.icons;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.ref.WeakReference;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.swing.plaf.UIResource;

import org.pushingpixels.neon.icon.ResizableIcon;
import org.pushingpixels.neon.icon.ResizableIconUIResource;

/**
 * This class has been automatically generated using <a
 * href="https://github.com/kirill-grouchnikov/radiance">Photon SVG transcoder</a>.
 */
public class setBlueChannel implements ResizableIcon {
    

    @SuppressWarnings("unused")
	private void innerPaint(Graphics2D g) {
        Shape shape = null;
        Paint paint = null;
        Stroke stroke = null;
        Shape clip = null;

        float origAlpha = 1.0f;
        Composite origComposite = g.getComposite();
        if (origComposite instanceof AlphaComposite) {
            AlphaComposite origAlphaComposite = 
                (AlphaComposite)origComposite;
            if (origAlphaComposite.getRule() == AlphaComposite.SRC_OVER) {
                origAlpha = origAlphaComposite.getAlpha();
            }
        }
        
	    AffineTransform defaultTransform_ = g.getTransform();
// 
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -79.62864685058594f, -236.8760986328125f));
// _0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0
shape = new Rectangle2D.Double(83.20446014404297, 238.27513122558594, 120.60572052001953, 58.02677917480469);
paint = new Color(0, 0, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 255, 255);
stroke = new BasicStroke(1.3942702f,0,0,4.0f,null,0.0f);
shape = new Rectangle2D.Double(83.20446014404297, 238.27513122558594, 120.60572052001953, 58.02677917480469);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
paint = new Color(204, 204, 204, 255);
stroke = new BasicStroke(1.3942702f,0,0,4.0f,null,0.0f);
shape = new Rectangle2D.Double(83.20446014404297, 305.27349853515625, 120.60572052001953, 58.02677917480469);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
shape = new Ellipse2D.Double(88.06546020507812, 310.7998352050781, 37.25825119018555, 34.42982482910156);
paint = new Color(0, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3
shape = new Ellipse2D.Double(117.29264831542969, 320.0338439941406, 44.0, 40.0);
paint = new Color(255, 0, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_3);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
shape = new Ellipse2D.Double(159.62864685058594, 308.8760986328125, 40.0, 44.0);
paint = new Color(102, 255, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_4);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_5 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5
paint = new Color(179, 179, 179, 255);
stroke = new BasicStroke(8.0f,1,1,5.5f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(143.52489, 329.11874);
((GeneralPath)shape).curveTo(143.52489, 269.11874, 143.52489, 269.11874, 143.52489, 269.11874);
((GeneralPath)shape).lineTo(163.52489, 289.11874);
((GeneralPath)shape).lineTo(143.52489, 269.11874);
((GeneralPath)shape).lineTo(123.52488, 289.11874);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_5);
g.setTransform(defaultTransform__0_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_1
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_1_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_1_0
shape = new Rectangle2D.Double(84.0621566772461, 310.1986389160156, 117.88873291015625, 44.67893600463867);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 255, 255);
stroke = new BasicStroke(2.7352762f,0,0,4.0f,null,0.0f);
shape = new Rectangle2D.Double(84.0621566772461, 310.1986389160156, 117.88873291015625, 44.67893600463867);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_1_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_1_1 = g.getTransform();
g.transform(new AffineTransform(-2.369846820831299f, -0.004105430096387863f, 0.003880009986460209f, -2.2397258281707764f, 199.8973388671875f, 354.01605224609375f));
// _0_1_1
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_1_1_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_1_1_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(23.531, 4.5);
((GeneralPath)shape).curveTo(13.683, 4.8989, 5.84, 12.515, 4.625, 22.156);
((GeneralPath)shape).lineTo(15.25, 22.156);
((GeneralPath)shape).curveTo(16.308, 18.23, 20.101, 15.173, 24.281, 15.219);
((GeneralPath)shape).curveTo(26.645, 15.245, 28.927, 16.018, 30.625, 17.656);
((GeneralPath)shape).lineTo(26.219, 21.719);
((GeneralPath)shape).lineTo(42.25, 21.719);
((GeneralPath)shape).lineTo(42.25, 5.906);
((GeneralPath)shape).lineTo(38.031, 10.125);
((GeneralPath)shape).curveTo(34.323, 6.481, 30.035, 4.5602, 24.562, 4.5);
((GeneralPath)shape).curveTo(24.215, 4.4962, 23.875, 4.4861, 23.531, 4.5);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(15.373000144958496, 5.0472002029418945), new Point2D.Double(15.373000144958496, 22.600000381469727), new float[] {0.0f,1.0f}, new Color[] {new Color(147, 185, 221, 255),new Color(99, 150, 205, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9543700218200684f, 0.0f, 0.0f, 0.9543700218200684f, 0.4932999908924103f, 2.8945999145507812f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(56, 122, 184, 255);
stroke = new BasicStroke(1.0f,0,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(23.531, 4.5);
((GeneralPath)shape).curveTo(13.683, 4.8989, 5.84, 12.515, 4.625, 22.156);
((GeneralPath)shape).lineTo(15.25, 22.156);
((GeneralPath)shape).curveTo(16.308, 18.23, 20.101, 15.173, 24.281, 15.219);
((GeneralPath)shape).curveTo(26.645, 15.245, 28.927, 16.018, 30.625, 17.656);
((GeneralPath)shape).lineTo(26.219, 21.719);
((GeneralPath)shape).lineTo(42.25, 21.719);
((GeneralPath)shape).lineTo(42.25, 5.906);
((GeneralPath)shape).lineTo(38.031, 10.125);
((GeneralPath)shape).curveTo(34.323, 6.481, 30.035, 4.5602, 24.562, 4.5);
((GeneralPath)shape).curveTo(24.215, 4.4962, 23.875, 4.4861, 23.531, 4.5);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_1_1_0);
g.setComposite(AlphaComposite.getInstance(3, 0.4f * origAlpha));
AffineTransform defaultTransform__0_1_1_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_1_1_1
paint = new LinearGradientPaint(new Point2D.Double(35.233001708984375, 10.677000045776367), new Point2D.Double(10.51200008392334, 19.947999954223633), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9543700218200684f, 0.0f, 0.0f, 0.9543700218200684f, 0.4932999908924103f, 2.8945999145507812f));
stroke = new BasicStroke(1.193f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(14.219, 21.75);
((GeneralPath)shape).curveTo(15.5083, 17.4619, 19.8079, 13.9962, 24.344, 14.0625);
((GeneralPath)shape).curveTo(27.0171, 14.10158, 30.299, 15.2544, 32.3128, 17.5313);
((GeneralPath)shape).lineTo(29.094, 20.5938);
((GeneralPath)shape).lineTo(41.156, 20.62505);
((GeneralPath)shape).lineTo(41.156, 8.56305);
((GeneralPath)shape).lineTo(38.0, 11.78125);
((GeneralPath)shape).curveTo(34.458, 7.83065, 29.947, 5.80565, 24.406, 5.75025);
((GeneralPath)shape).curveTo(14.797, 5.65405, 7.234, 12.56525, 5.844, 21.75025);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_1_1_1);
g.setTransform(defaultTransform__0_1_1);
g.setTransform(defaultTransform__0_1);
g.setTransform(defaultTransform__0);
g.setTransform(defaultTransform_);

	}

    /**
     * Returns the X of the bounding box of the original SVG image.
     * 
     * @return The X of the bounding box of the original SVG image.
     */
    public static double getOrigX() {
        return 2.8786773681640625;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 0.701904296875;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 125.12132263183594;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 127.298095703125;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private setBlueChannel() {
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
	public void setDimension(Dimension newDimension) {
		this.width = newDimension.width;
		this.height = newDimension.height;
	}

    @Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
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
       setBlueChannel base = new setBlueChannel();
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
       setBlueChannel base = new setBlueChannel();
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
        return setBlueChannel::new;
    }
}

