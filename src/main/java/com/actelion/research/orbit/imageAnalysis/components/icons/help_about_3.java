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
public class help_about_3 implements ResizableIcon {
    

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
g.setComposite(AlphaComposite.getInstance(3, 0.38139534f * origAlpha));
AffineTransform defaultTransform__0_0_0 = g.getTransform();
g.transform(new AffineTransform(-1.0013740062713623f, 0.0f, 0.0f, 0.41037899255752563f, 128.0f, 75.32737731933594f));
// _0_0_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(127.82442, 115.70919);
((GeneralPath)shape).curveTo(127.926834, 120.239204, 115.767685, 124.4338, 95.95111, 126.70467);
((GeneralPath)shape).curveTo(76.13453, 128.97554, 51.689888, 128.97554, 31.87331, 126.70467);
((GeneralPath)shape).curveTo(12.056729, 124.4338, -0.102419876, 120.239204, 0.0, 115.70919);
((GeneralPath)shape).lineTo(-7.1054274E-15, 115.70919);
((GeneralPath)shape).curveTo(-0.102419876, 111.17918, 12.056729, 106.98458, 31.87331, 104.71371);
((GeneralPath)shape).curveTo(51.689888, 102.44283, 76.13453, 102.44283, 95.95111, 104.71371);
((GeneralPath)shape).curveTo(115.767685, 106.98458, 127.926834, 111.17918, 127.82442, 115.70919);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(63.912208557128906, 115.70919036865234), 63.91221f, new Point2D.Double(63.975181579589844, 116.88513946533203), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.19780200719833374f, 0.0f, 92.82166290283203f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1 = g.getTransform();
g.transform(new AffineTransform(-1.502243995666504f, 0.40252500772476196f, -0.40252500772476196f, -1.502243995666504f, 617.8026733398438f, 63.738250732421875f));
// _0_0_1
shape = new Ellipse2D.Double(307.9989929199219, 56.0, 72.0, 72.0);
paint = new LinearGradientPaint(new Point2D.Double(-70.00289916992188, -383.9971008300781), new Point2D.Double(-11.91648006439209, -383.9971008300781), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 129, 236, 255),new Color(0, 87, 174, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.0f, 1.0f, -1.0f, 0.0f, -39.99850082397461f, 140.00289916992188f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1);
g.setComposite(AlphaComposite.getInstance(3, 0.4f * origAlpha));
AffineTransform defaultTransform__0_0_2 = g.getTransform();
g.transform(new AffineTransform(-0.6676629781723022f, 0.0670875832438469f, -0.17890000343322754f, -0.25037500262260437f, 310.1343078613281f, 104.40080261230469f));
// _0_0_2
shape = new Ellipse2D.Double(307.9989929199219, 56.0, 72.0, 72.0);
paint = new RadialGradientPaint(new Point2D.Double(343.9989929199219, 92.0), 36.0f, new Point2D.Double(343.9989929199219, 92.0), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.0f, 1.0f, -1.0f, 0.0f, -39.99850082397461f, 140.00289916992188f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2);
g.setComposite(AlphaComposite.getInstance(3, 0.8f * origAlpha));
AffineTransform defaultTransform__0_0_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3
shape = new GeneralPath();
((GeneralPath)shape).moveTo(64.00003, 14.177736);
((GeneralPath)shape).curveTo(39.563103, 14.177736, 19.143818, 31.433502, 14.22224, 54.40774);
((GeneralPath)shape).curveTo(24.032276, 63.55275, 42.646324, 69.72398, 64.00003, 69.72398);
((GeneralPath)shape).curveTo(85.35376, 69.72398, 103.96779, 63.55275, 113.77782, 54.40774);
((GeneralPath)shape).curveTo(108.85626, 31.433502, 88.43695, 14.177736, 64.00003, 14.177736);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(-88.0580825805664, -131.93112182617188), new Point2D.Double(-45.09658432006836, -131.93112182617188), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.0f, 1.59129798412323f, -1.59129798412323f, 0.0f, -146.0489044189453f, 141.4862060546875f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_3);
g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));
AffineTransform defaultTransform__0_0_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
paint = new Color(0, 87, 174, 255);
stroke = new BasicStroke(4.0f,0,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(72.0, 56.0);
((GeneralPath)shape).lineTo(48.0, 56.0);
((GeneralPath)shape).lineTo(48.0, 64.0);
((GeneralPath)shape).lineTo(56.0, 64.0);
((GeneralPath)shape).lineTo(56.0, 96.0);
((GeneralPath)shape).lineTo(48.0, 96.0);
((GeneralPath)shape).lineTo(48.0, 104.0);
((GeneralPath)shape).lineTo(80.0, 104.0);
((GeneralPath)shape).lineTo(80.0, 96.0);
((GeneralPath)shape).lineTo(72.0, 96.0);
((GeneralPath)shape).curveTo(72.0, 96.0, 72.0, 56.0, 72.0, 56.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_4);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_5 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5
shape = new GeneralPath();
((GeneralPath)shape).moveTo(-106.3852, 44.124126);
((GeneralPath)shape).lineTo(-106.3852, 41.32942);
((GeneralPath)shape).lineTo(-106.3852, 44.124126);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_5);
g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));
AffineTransform defaultTransform__0_0_6 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6
paint = new Color(0, 87, 174, 255);
stroke = new BasicStroke(4.0f,0,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(64.12579, 22.602966);
((GeneralPath)shape).curveTo(57.50303, 22.602966, 52.125797, 27.98018, 52.125797, 34.60297);
((GeneralPath)shape).curveTo(52.125797, 41.22576, 57.50303, 46.60297, 64.12579, 46.60297);
((GeneralPath)shape).curveTo(70.74859, 46.60297, 76.1258, 41.225758, 76.1258, 34.60297);
((GeneralPath)shape).curveTo(76.1258, 27.98018, 70.7486, 22.602966, 64.12579, 22.602966);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_6);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_7 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
shape = new GeneralPath();
((GeneralPath)shape).moveTo(64.12579, 22.602966);
((GeneralPath)shape).curveTo(57.50303, 22.602966, 52.125797, 27.98018, 52.125797, 34.60297);
((GeneralPath)shape).curveTo(52.125797, 41.22576, 57.50303, 46.60297, 64.12579, 46.60297);
((GeneralPath)shape).curveTo(70.74859, 46.60297, 76.1258, 41.225758, 76.1258, 34.60297);
((GeneralPath)shape).curveTo(76.1258, 27.98018, 70.7486, 22.602966, 64.12579, 22.602966);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_7);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_8 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8
shape = new GeneralPath();
((GeneralPath)shape).moveTo(72.0, 56.0);
((GeneralPath)shape).lineTo(48.0, 56.0);
((GeneralPath)shape).lineTo(48.0, 64.0);
((GeneralPath)shape).lineTo(56.0, 64.0);
((GeneralPath)shape).lineTo(56.0, 96.0);
((GeneralPath)shape).lineTo(48.0, 96.0);
((GeneralPath)shape).lineTo(48.0, 104.0);
((GeneralPath)shape).lineTo(80.0, 104.0);
((GeneralPath)shape).lineTo(80.0, 96.0);
((GeneralPath)shape).lineTo(72.0, 96.0);
((GeneralPath)shape).curveTo(72.0, 96.0, 72.0, 56.0, 72.0, 56.0);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_8);
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
        return 0.0;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 0.0;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 128.0;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 128.0;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private help_about_3() {
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
       help_about_3 base = new help_about_3();
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
       help_about_3 base = new help_about_3();
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
        return help_about_3::new;
    }
}

