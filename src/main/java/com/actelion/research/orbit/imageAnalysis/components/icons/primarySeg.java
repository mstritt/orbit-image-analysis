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
public class primarySeg implements ResizableIcon {
    

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
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0
shape = new Ellipse2D.Double(13.03569221496582, 20.21078109741211, 20.357166290283203, 5.057076454162598);
paint = new RadialGradientPaint(new Point2D.Double(23.8125, 43.0), 16.375f, new Point2D.Double(23.8125, 43.0), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.6215928792953491f, 0.0f, 0.0f, 0.15441417694091797f, 8.412595748901367f, 16.099491119384766f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(19.142853, 18.770922);
((GeneralPath)shape).lineTo(29.030619, 18.770922);
((GeneralPath)shape).lineTo(24.086735, 23.827991);
((GeneralPath)shape).lineTo(19.142853, 18.770922);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(22.750001907348633, 40.000755310058594), new Point2D.Double(22.750001907348633, 37.4096794128418), new float[] {0.0f,1.0f}, new Color[] {new Color(254, 203, 129, 255),new Color(252, 175, 62, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.5816329121589661f, 0.0f, 0.0f, 0.561897337436676f, 10.127540588378906f, -1.1764357089996338f));
g.setPaint(paint);
g.fill(shape);
paint = new LinearGradientPaint(new Point2D.Double(17.25, 41.147342681884766), new Point2D.Double(17.25, 36.10343933105469), new float[] {0.0f,1.0f}, new Color[] {new Color(206, 92, 0, 255),new Color(245, 121, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.5816329121589661f, 0.0f, 0.0f, 0.561897337436676f, 10.127540588378906f, -1.1764357089996338f));
stroke = new BasicStroke(0.57168025f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(19.142853, 18.770922);
((GeneralPath)shape).lineTo(29.030619, 18.770922);
((GeneralPath)shape).lineTo(24.086735, 23.827991);
((GeneralPath)shape).lineTo(19.142853, 18.770922);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_1);
g.setComposite(AlphaComposite.getInstance(3, 0.7f * origAlpha));
AffineTransform defaultTransform__0_0_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 2.0f));
// _0_0_2
paint = new LinearGradientPaint(new Point2D.Double(18.875, 35.183414459228516), new Point2D.Double(18.875, 43.97861099243164), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(1.0f,1,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(17.820312, 34.5);
((GeneralPath)shape).lineTo(24.0, 41.04297);
((GeneralPath)shape).lineTo(30.179688, 34.5);
((GeneralPath)shape).lineTo(17.820312, 34.5);
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
((GeneralPath)shape).moveTo(18.561218, 1.3872209);
((GeneralPath)shape).lineTo(16.234686, 5.0473437);
((GeneralPath)shape).lineTo(16.234686, 17.120344);
((GeneralPath)shape).lineTo(31.938774, 17.120344);
((GeneralPath)shape).lineTo(31.938774, 5.0473437);
((GeneralPath)shape).lineTo(29.612244, 1.3872209);
((GeneralPath)shape).lineTo(18.561218, 1.3872209);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(31.742900848388672, -0.1937265396118164), new Point2D.Double(9.897525787353516, 20.30753517150879), new float[] {0.0f,1.0f}, new Color[] {new Color(114, 159, 207, 255),new Color(173, 199, 227, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.5816329121589661f, 0.0f, 0.0f, 0.561897337436676f, 10.127540588378906f, -1.1413171291351318f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(52, 101, 164, 255);
stroke = new BasicStroke(0.5716802f,1,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(18.561218, 1.3872209);
((GeneralPath)shape).lineTo(16.234686, 5.0473437);
((GeneralPath)shape).lineTo(16.234686, 17.120344);
((GeneralPath)shape).lineTo(31.938774, 17.120344);
((GeneralPath)shape).lineTo(31.938774, 5.0473437);
((GeneralPath)shape).lineTo(29.612244, 1.3872209);
((GeneralPath)shape).lineTo(18.561218, 1.3872209);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_3);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
shape = new GeneralPath();
((GeneralPath)shape).moveTo(16.525503, 5.0395627);
((GeneralPath)shape).lineTo(31.64797, 5.0395627);
((GeneralPath)shape).lineTo(31.64797, 16.839397);
((GeneralPath)shape).lineTo(16.525503, 16.839397);
((GeneralPath)shape).lineTo(16.525503, 5.0395627);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(8.075193405151367, 5.041107177734375), new Point2D.Double(18.704320907592773, 33.0), new float[] {0.0f,1.0f}, new Color[] {new Color(52, 101, 164, 255),new Color(114, 159, 207, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.5816329121589661f, 0.0f, 0.0f, 0.561897337436676f, 10.127540588378906f, -1.1413171291351318f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_4);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_5 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5
paint = new Color(181, 206, 231, 255);
stroke = new BasicStroke(0.57167995f,2,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(16.816319, 5.320502);
((GeneralPath)shape).lineTo(31.357143, 5.320502);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_5);
g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));
AffineTransform defaultTransform__0_0_6 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6
paint = new LinearGradientPaint(new Point2D.Double(15.875, 11.5), new Point2D.Double(30.75, 62.5), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.5816329121589661f, 0.0f, 0.0f, 0.561897337436676f, 10.127540588378906f, -1.1413171291351318f));
stroke = new BasicStroke(0.5716802f,1,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(18.906563, 1.9491181);
((GeneralPath)shape).lineTo(16.816319, 5.1800275);
((GeneralPath)shape).lineTo(16.816319, 16.558449);
((GeneralPath)shape).lineTo(31.357143, 16.558449);
((GeneralPath)shape).lineTo(31.357143, 5.1800275);
((GeneralPath)shape).lineTo(29.2669, 1.9491181);
((GeneralPath)shape).lineTo(18.906563, 1.9491181);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_6);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_7 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
shape = new Ellipse2D.Double(14.286213874816895, 26.304035186767578, 20.445436477661133, 19.374040603637695);
paint = new Color(255, 255, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 232, 0, 255);
stroke = new BasicStroke(3.5724132f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(14.286213874816895, 26.304035186767578, 20.445436477661133, 19.374040603637695);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_7);
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
        return 12.500007629394531;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 1.101380705833435;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 24.01784896850586;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 46.36289978027344;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private primarySeg() {
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
       primarySeg base = new primarySeg();
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
       primarySeg base = new primarySeg();
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
        return primarySeg::new;
    }
}

