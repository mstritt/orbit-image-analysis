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
public class mask2browser implements ResizableIcon {
    

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
g.transform(new AffineTransform(1.0666667222976685f, 0.0f, 0.0f, 1.0666667222976685f, -0.0f, -0.0f));
// _0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, -343.7007751464844f));
// _0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0
paint = new Color(20, 20, 20, 255);
stroke = new BasicStroke(16.028175f,1,2,4.0f,new float[] {16.028175f,16.028175f},0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(358.99115, 719.65985);
((GeneralPath)shape).curveTo(358.99115, 765.26013, 340.87653, 808.9928, 308.63223, 841.23706);
((GeneralPath)shape).curveTo(276.38797, 873.4814, 232.65532, 891.596, 187.05502, 891.596);
((GeneralPath)shape).curveTo(141.45473, 891.596, 97.7221, 873.4813, 65.47782, 841.23706);
((GeneralPath)shape).curveTo(33.233543, 808.9928, 15.1189, 765.26013, 15.118908, 719.65985);
((GeneralPath)shape).curveTo(15.118925, 624.70215, 92.097336, 547.72375, 187.05502, 547.72375);
((GeneralPath)shape).curveTo(282.01273, 547.72375, 358.99112, 624.70215, 358.99115, 719.65985);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(39.740612, 492.1338);
((GeneralPath)shape).lineTo(335.19604, 492.1338);
((GeneralPath)shape).curveTo(335.55606, 492.1338, 335.8459, 492.4208, 335.8459, 492.7773);
((GeneralPath)shape).lineTo(335.8459, 750.63446);
((GeneralPath)shape).curveTo(335.8459, 750.9909, 335.55606, 751.2779, 335.19604, 751.2779);
((GeneralPath)shape).lineTo(39.740612, 751.2779);
((GeneralPath)shape).curveTo(39.380608, 751.2779, 39.09078, 750.9909, 39.09078, 750.63446);
((GeneralPath)shape).lineTo(39.09078, 492.7773);
((GeneralPath)shape).curveTo(39.09078, 492.4208, 39.380608, 492.1338, 39.740612, 492.1338);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(20, 20, 20, 255);
stroke = new BasicStroke(3.4717872f,1,2,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(39.740612, 492.1338);
((GeneralPath)shape).lineTo(335.19604, 492.1338);
((GeneralPath)shape).curveTo(335.55606, 492.1338, 335.8459, 492.4208, 335.8459, 492.7773);
((GeneralPath)shape).lineTo(335.8459, 750.63446);
((GeneralPath)shape).curveTo(335.8459, 750.9909, 335.55606, 751.2779, 335.19604, 751.2779);
((GeneralPath)shape).lineTo(39.740612, 751.2779);
((GeneralPath)shape).curveTo(39.380608, 751.2779, 39.09078, 750.9909, 39.09078, 750.63446);
((GeneralPath)shape).lineTo(39.09078, 492.7773);
((GeneralPath)shape).curveTo(39.09078, 492.4208, 39.380608, 492.1338, 39.740612, 492.1338);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(187.3027, 547.16534);
((GeneralPath)shape).curveTo(126.46346, 547.2429, 70.194954, 579.46674, 39.339252, 631.90094);
((GeneralPath)shape).lineTo(39.339252, 750.0762);
((GeneralPath)shape).curveTo(39.339252, 750.4327, 39.629074, 750.72034, 39.98908, 750.72034);
((GeneralPath)shape).lineTo(335.44357, 750.72034);
((GeneralPath)shape).curveTo(335.8036, 750.72034, 336.0934, 750.4327, 336.0934, 750.0762);
((GeneralPath)shape).lineTo(336.0934, 633.3712);
((GeneralPath)shape).curveTo(305.46017, 580.1166, 248.73921, 547.2538, 187.3027, 547.16534);
((GeneralPath)shape).closePath();
paint = new Color(0, 255, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(20, 20, 20, 255);
stroke = new BasicStroke(3.4717872f,1,2,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(187.3027, 547.16534);
((GeneralPath)shape).curveTo(126.46346, 547.2429, 70.194954, 579.46674, 39.339252, 631.90094);
((GeneralPath)shape).lineTo(39.339252, 750.0762);
((GeneralPath)shape).curveTo(39.339252, 750.4327, 39.629074, 750.72034, 39.98908, 750.72034);
((GeneralPath)shape).lineTo(335.44357, 750.72034);
((GeneralPath)shape).curveTo(335.8036, 750.72034, 336.0934, 750.4327, 336.0934, 750.0762);
((GeneralPath)shape).lineTo(336.0934, 633.3712);
((GeneralPath)shape).curveTo(305.46017, 580.1166, 248.73921, 547.2538, 187.3027, 547.16534);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3
paint = new Color(230, 230, 230, 255);
stroke = new BasicStroke(8.4375f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(489.50894, 554.81757);
((GeneralPath)shape).lineTo(665.625, 554.81757);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_3);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
paint = new Color(230, 230, 230, 255);
stroke = new BasicStroke(8.4375f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(489.5089, 638.25507);
((GeneralPath)shape).lineTo(665.625, 638.25507);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_4);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_5 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5
paint = new Color(230, 230, 230, 255);
stroke = new BasicStroke(8.4375f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(489.5089, 721.69257);
((GeneralPath)shape).lineTo(665.625, 721.69257);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_5);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_6 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6
paint = new Color(230, 230, 230, 255);
stroke = new BasicStroke(8.4375f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(489.5089, 805.13007);
((GeneralPath)shape).lineTo(665.625, 805.13007);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_6);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_7 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
paint = new Color(230, 230, 230, 255);
stroke = new BasicStroke(8.4375f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(489.5089, 888.56757);
((GeneralPath)shape).lineTo(665.625, 888.56757);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_7);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_8 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8
paint = new Color(230, 230, 230, 255);
stroke = new BasicStroke(8.4375f,1,2,4.0f,null,0.0f);
shape = new RoundRectangle2D.Double(470.7589111328125, 524.5496826171875, 212.2767791748047, 399.1071472167969, 2.1057186126708984, 2.0851686000823975);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_8);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_9 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9
paint = new Color(230, 230, 230, 255);
stroke = new BasicStroke(8.4375f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(166.07143, 460.39792);
((GeneralPath)shape).curveTo(211.83144, 430.93292, 257.59036, 401.46866, 307.70123, 387.5181);
((GeneralPath)shape).curveTo(357.8121, 373.56754, 412.27768, 375.1301, 455.52646, 396.60007);
((GeneralPath)shape).curveTo(498.77524, 418.07004, 531.0267, 459.72815, 563.1696, 501.24615);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_9);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_10 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10
paint = new Color(230, 230, 230, 255);
stroke = new BasicStroke(8.4375f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(563.1696, 501.24615);
((GeneralPath)shape).lineTo(564.5089, 447.00507);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_10);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_11 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_11
paint = new Color(230, 230, 230, 255);
stroke = new BasicStroke(8.4375f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(563.1696, 501.24615);
((GeneralPath)shape).lineTo(510.9375, 489.8622);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_11);
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
        return 7.522468566894531;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 27.301246643066406;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 725.5490112304688;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 595.818603515625;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private mask2browser() {
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
       mask2browser base = new mask2browser();
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
       mask2browser base = new mask2browser();
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
        return mask2browser::new;
    }
}

