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
public class insert_object implements ResizableIcon {
    

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
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0
g.setComposite(AlphaComposite.getInstance(3, 0.2f * origAlpha));
AffineTransform defaultTransform__0_0_0 = g.getTransform();
g.transform(new AffineTransform(1.068703055381775f, 0.0f, 0.0f, 1.4117648601531982f, -2.948499917984009f, -20.20589256286621f));
// _0_0_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(40.1875, 43.0);
((GeneralPath)shape).curveTo(40.21374, 44.14218, 37.098434, 45.19979, 32.021214, 45.772358);
((GeneralPath)shape).curveTo(26.94399, 46.34493, 20.68101, 46.34493, 15.603787, 45.772358);
((GeneralPath)shape).curveTo(10.526565, 45.19979, 7.4112587, 44.14218, 7.4375, 43.0);
((GeneralPath)shape).curveTo(7.4112587, 41.85782, 10.526565, 40.80021, 15.603787, 40.227642);
((GeneralPath)shape).curveTo(20.68101, 39.65507, 26.94399, 39.65507, 32.021214, 40.227642);
((GeneralPath)shape).curveTo(37.098434, 40.80021, 40.21374, 41.85782, 40.1875, 43.0);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(23.8125, 43.0), 16.375f, new Point2D.Double(23.8125, 43.0), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.19465599954128265f, 0.0f, 34.62976837158203f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, -2.0625f));
// _0_0_1
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(15.500002, 35.500004);
((GeneralPath)shape).lineTo(32.50001, 35.500004);
((GeneralPath)shape).lineTo(24.000008, 44.499996);
((GeneralPath)shape).lineTo(15.500002, 35.500004);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(22.750001907348633, 40.000755310058594), new Point2D.Double(22.750001907348633, 37.4096794128418), new float[] {0.0f,1.0f}, new Color[] {new Color(254, 203, 129, 255),new Color(252, 175, 62, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
paint = new LinearGradientPaint(new Point2D.Double(17.25, 41.147342681884766), new Point2D.Double(17.25, 36.10343933105469), new float[] {0.0f,1.0f}, new Color[] {new Color(206, 92, 0, 255),new Color(245, 121, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(1.0000005f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(15.500002, 35.500004);
((GeneralPath)shape).lineTo(32.50001, 35.500004);
((GeneralPath)shape).lineTo(24.000008, 44.499996);
((GeneralPath)shape).lineTo(15.500002, 35.500004);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_1_0);
g.setComposite(AlphaComposite.getInstance(3, 0.7f * origAlpha));
AffineTransform defaultTransform__0_0_1_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 2.0f));
// _0_0_1_1
paint = new LinearGradientPaint(new Point2D.Double(18.875, 35.183414459228516), new Point2D.Double(18.875, 43.97861099243164), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(1.0f,1,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(17.8125, 34.5);
((GeneralPath)shape).lineTo(24.0, 41.0625);
((GeneralPath)shape).lineTo(30.1875, 34.5);
((GeneralPath)shape).lineTo(17.8125, 34.5);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_1_1);
g.setTransform(defaultTransform__0_0_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(14.5, 2.5);
((GeneralPath)shape).lineTo(10.5, 9.013864);
((GeneralPath)shape).lineTo(10.5, 30.5);
((GeneralPath)shape).lineTo(37.5, 30.5);
((GeneralPath)shape).lineTo(37.5, 9.013864);
((GeneralPath)shape).lineTo(33.5, 2.5);
((GeneralPath)shape).lineTo(14.5, 2.5);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(31.742900848388672, -0.1937265396118164), new Point2D.Double(9.897525787353516, 20.30753517150879), new float[] {0.0f,1.0f}, new Color[] {new Color(114, 159, 207, 255),new Color(173, 199, 227, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 2.118606445833393E-8f, -2.0f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(52, 101, 164, 255);
stroke = new BasicStroke(1.0000004f,1,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(14.5, 2.5);
((GeneralPath)shape).lineTo(10.5, 9.013864);
((GeneralPath)shape).lineTo(10.5, 30.5);
((GeneralPath)shape).lineTo(37.5, 30.5);
((GeneralPath)shape).lineTo(37.5, 9.013864);
((GeneralPath)shape).lineTo(33.5, 2.5);
((GeneralPath)shape).lineTo(14.5, 2.5);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3
shape = new GeneralPath();
((GeneralPath)shape).moveTo(11.0, 9.000017);
((GeneralPath)shape).lineTo(37.00002, 9.000017);
((GeneralPath)shape).lineTo(37.00002, 30.0);
((GeneralPath)shape).lineTo(11.0, 30.0);
((GeneralPath)shape).lineTo(11.0, 9.000017);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(8.075193405151367, 5.041107177734375), new Point2D.Double(18.704320907592773, 33.0), new float[] {0.0f,1.0f}, new Color[] {new Color(52, 101, 164, 255),new Color(114, 159, 207, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 2.118606445833393E-8f, -2.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_3);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
paint = new Color(181, 206, 231, 255);
stroke = new BasicStroke(1.0f,2,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(11.5, 9.5);
((GeneralPath)shape).lineTo(36.5, 9.5);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_4);
g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));
AffineTransform defaultTransform__0_0_5 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5
paint = new LinearGradientPaint(new Point2D.Double(15.875, 11.5), new Point2D.Double(30.75, 62.5), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 2.118606445833393E-8f, -2.0f));
stroke = new BasicStroke(1.0000004f,1,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(15.09375, 3.5);
((GeneralPath)shape).lineTo(11.5, 9.25);
((GeneralPath)shape).lineTo(11.5, 29.5);
((GeneralPath)shape).lineTo(36.5, 29.5);
((GeneralPath)shape).lineTo(36.5, 9.25);
((GeneralPath)shape).lineTo(32.90625, 3.5);
((GeneralPath)shape).lineTo(15.09375, 3.5);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_5);
g.setTransform(defaultTransform__0_0);
g.setTransform(defaultTransform__0);
g.setTransform(defaultTransform_);

	}

    /**
     * Returns the X of the bounding box of the original SVG image.
     * 
     * @return The X of the bounding box of the original SVG image.
     */
    public static double getOrigX() {
        return 4.971934795379639;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 1.999999761581421;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 35.056114196777344;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 43.22224807739258;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private insert_object() {
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
       insert_object base = new insert_object();
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
       insert_object base = new insert_object();
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
        return insert_object::new;
    }
}

