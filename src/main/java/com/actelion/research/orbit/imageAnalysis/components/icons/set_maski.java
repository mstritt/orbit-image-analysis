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
public class set_maski implements ResizableIcon {
    

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
stroke = new BasicStroke(25.968897f,1,2,4.0f,new float[] {25.968897f,25.968897f},0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(634.1518, 748.0095);
((GeneralPath)shape).curveTo(634.1518, 821.8913, 604.8024, 892.747, 552.5601, 944.9893);
((GeneralPath)shape).curveTo(500.31787, 997.2316, 429.4621, 1026.581, 355.58035, 1026.581);
((GeneralPath)shape).curveTo(281.6986, 1026.581, 210.84285, 997.2316, 158.60057, 944.9893);
((GeneralPath)shape).curveTo(106.358284, 892.747, 77.00889, 821.8913, 77.00891, 748.0095);
((GeneralPath)shape).curveTo(77.00891, 674.1278, 106.358315, 603.27203, 158.6006, 551.0298);
((GeneralPath)shape).curveTo(210.84288, 498.78748, 281.6986, 469.43808, 355.58035, 469.43808);
((GeneralPath)shape).curveTo(429.4621, 469.43808, 500.31784, 498.78748, 552.5601, 551.0298);
((GeneralPath)shape).curveTo(604.80237, 603.27203, 634.1518, 674.1278, 634.1518, 748.0095);
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
((GeneralPath)shape).moveTo(116.90107, 379.37112);
((GeneralPath)shape).lineTo(595.5989, 379.37112);
((GeneralPath)shape).curveTo(596.1822, 379.37112, 596.65173, 379.83612, 596.65173, 380.4137);
((GeneralPath)shape).lineTo(596.65173, 798.1946);
((GeneralPath)shape).curveTo(596.65173, 798.7722, 596.1822, 799.2372, 595.5989, 799.2372);
((GeneralPath)shape).lineTo(116.90107, 799.2372);
((GeneralPath)shape).curveTo(116.31779, 799.2372, 115.84821, 798.7722, 115.84821, 798.1946);
((GeneralPath)shape).lineTo(115.84821, 380.4137);
((GeneralPath)shape).curveTo(115.84821, 379.83612, 116.31779, 379.37112, 116.90107, 379.37112);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(20, 20, 20, 255);
stroke = new BasicStroke(5.625f,1,2,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(116.90107, 379.37112);
((GeneralPath)shape).lineTo(595.5989, 379.37112);
((GeneralPath)shape).curveTo(596.1822, 379.37112, 596.65173, 379.83612, 596.65173, 380.4137);
((GeneralPath)shape).lineTo(596.65173, 798.1946);
((GeneralPath)shape).curveTo(596.65173, 798.7722, 596.1822, 799.2372, 595.5989, 799.2372);
((GeneralPath)shape).lineTo(116.90107, 799.2372);
((GeneralPath)shape).curveTo(116.31779, 799.2372, 115.84821, 798.7722, 115.84821, 798.1946);
((GeneralPath)shape).lineTo(115.84821, 380.4137);
((GeneralPath)shape).curveTo(115.84821, 379.83612, 116.31779, 379.37112, 116.90107, 379.37112);
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
((GeneralPath)shape).moveTo(355.98163, 468.53342);
((GeneralPath)shape).curveTo(257.4097, 468.65912, 166.2433, 520.8682, 116.25079, 605.82227);
((GeneralPath)shape).lineTo(116.25079, 797.2901);
((GeneralPath)shape).curveTo(116.25079, 797.86774, 116.72036, 798.3338, 117.30364, 798.3338);
((GeneralPath)shape).lineTo(595.99994, 798.3338);
((GeneralPath)shape).curveTo(596.5832, 798.3338, 597.0528, 797.86774, 597.0528, 797.2901);
((GeneralPath)shape).lineTo(597.0528, 608.20447);
((GeneralPath)shape).curveTo(547.4207, 521.92114, 455.52127, 468.6767, 355.98163, 468.53342);
((GeneralPath)shape).closePath();
paint = new Color(0, 255, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(20, 20, 20, 255);
stroke = new BasicStroke(5.625f,1,2,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(355.98163, 468.53342);
((GeneralPath)shape).curveTo(257.4097, 468.65912, 166.2433, 520.8682, 116.25079, 605.82227);
((GeneralPath)shape).lineTo(116.25079, 797.2901);
((GeneralPath)shape).curveTo(116.25079, 797.86774, 116.72036, 798.3338, 117.30364, 798.3338);
((GeneralPath)shape).lineTo(595.99994, 798.3338);
((GeneralPath)shape).curveTo(596.5832, 798.3338, 597.0528, 797.86774, 597.0528, 797.2901);
((GeneralPath)shape).lineTo(597.0528, 608.20447);
((GeneralPath)shape).curveTo(547.4207, 521.92114, 455.52127, 468.6767, 355.98163, 468.53342);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_2);
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
        return 68.20055389404297;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 35.04837417602539;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 622.1467895507812;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 707.2073974609375;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private set_maski() {
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
       set_maski base = new set_maski();
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
       set_maski base = new set_maski();
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
        return set_maski::new;
    }
}

