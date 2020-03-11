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
public class set_segmask implements ResizableIcon {
    

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
shape = new GeneralPath();
((GeneralPath)shape).moveTo(37.756676, 371.92258);
((GeneralPath)shape).lineTo(678.0915, 371.92258);
((GeneralPath)shape).curveTo(678.87177, 371.92258, 679.4999, 372.65027, 679.4999, 373.5542);
((GeneralPath)shape).lineTo(679.4999, 1027.3755);
((GeneralPath)shape).curveTo(679.4999, 1028.2795, 678.87177, 1029.0072, 678.0915, 1029.0072);
((GeneralPath)shape).lineTo(37.756676, 1029.0072);
((GeneralPath)shape).curveTo(36.976444, 1029.0072, 36.348305, 1028.2795, 36.348305, 1027.3755);
((GeneralPath)shape).lineTo(36.348305, 373.5542);
((GeneralPath)shape).curveTo(36.348305, 372.65027, 36.976444, 371.92258, 37.756676, 371.92258);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(20, 20, 20, 255);
stroke = new BasicStroke(8.1386175f,1,2,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(37.756676, 371.92258);
((GeneralPath)shape).lineTo(678.0915, 371.92258);
((GeneralPath)shape).curveTo(678.87177, 371.92258, 679.4999, 372.65027, 679.4999, 373.5542);
((GeneralPath)shape).lineTo(679.4999, 1027.3755);
((GeneralPath)shape).curveTo(679.4999, 1028.2795, 678.87177, 1029.0072, 678.0915, 1029.0072);
((GeneralPath)shape).lineTo(37.756676, 1029.0072);
((GeneralPath)shape).curveTo(36.976444, 1029.0072, 36.348305, 1028.2795, 36.348305, 1027.3755);
((GeneralPath)shape).lineTo(36.348305, 373.5542);
((GeneralPath)shape).curveTo(36.348305, 372.65027, 36.976444, 371.92258, 37.756676, 371.92258);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
shape = new Ellipse2D.Double(86.45487976074219, 427.6564025878906, 196.0634765625, 218.16168212890625);
paint = new Color(0, 0, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 255, 255);
stroke = new BasicStroke(8.579384f,1,1,4.0f,null,0.0f);
shape = new Ellipse2D.Double(86.45487976074219, 427.6564025878906, 196.0634765625, 218.16168212890625);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
shape = new Ellipse2D.Double(201.36595153808594, 782.6343994140625, 260.8841857910156, 169.14309692382812);
paint = new Color(0, 0, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 255, 255);
stroke = new BasicStroke(8.71404f,1,1,4.0f,null,0.0f);
shape = new Ellipse2D.Double(201.36595153808594, 782.6343994140625, 260.8841857910156, 169.14309692382812);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3
shape = new Ellipse2D.Double(397.1851501464844, 480.23931884765625, 230.1832733154297, 217.46005249023438);
paint = new Color(0, 0, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 255, 255);
stroke = new BasicStroke(9.281008f,1,1,4.0f,null,0.0f);
shape = new Ellipse2D.Double(397.1851501464844, 480.23931884765625, 230.1832733154297, 217.46005249023438);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_3);
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
        return 34.430931091308594;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 25.762664794921875;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 694.7095336914062;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 709.571533203125;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private set_segmask() {
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
       set_segmask base = new set_segmask();
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
       set_segmask base = new set_segmask();
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
        return set_segmask::new;
    }
}

