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
public class chrono_noun_project_282 implements ResizableIcon {
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
g.transform(new AffineTransform(0.009999999776482582f, 0.0f, 0.0f, 0.009999999776482582f, 0.06247001508317851f, -0.0f));
// _0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(43.0f, 26.0f);
generalPath.curveTo(41.344f, 26.0f, 40.0f, 27.343f, 40.0f, 29.0f);
generalPath.lineTo(40.0f, 57.0f);
generalPath.curveTo(40.0f, 58.657f, 41.344f, 60.0f, 43.0f, 60.0f);
generalPath.curveTo(44.656f, 60.0f, 46.0f, 58.657f, 46.0f, 57.0f);
generalPath.lineTo(46.0f, 29.0f);
generalPath.curveTo(46.0f, 27.343f, 44.656f, 26.0f, 43.0f, 26.0f);
generalPath.closePath();
shape = generalPath;
paint = new Color(204, 204, 204, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(87.506f, 23.807f);
generalPath.curveTo(87.506f, 23.807f, 86.091995f, 19.564999f, 83.263f, 16.737f);
generalPath.curveTo(80.435f, 13.907999f, 76.193f, 12.4939995f, 76.193f, 12.4939995f);
generalPath.lineTo(67.205f, 21.481998f);
generalPath.curveTo(62.408f, 18.201998f, 56.916f, 15.8759985f, 51.0f, 14.757998f);
generalPath.lineTo(51.0f, 1.9999981f);
generalPath.curveTo(51.0f, 1.9999981f, 47.0f, -1.9073486E-6f, 43.0f, -1.9073486E-6f);
generalPath.curveTo(39.0f, -1.9073486E-6f, 35.0f, 1.9999981f, 35.0f, 1.9999981f);
generalPath.lineTo(35.0f, 14.757998f);
generalPath.curveTo(15.101999f, 18.519999f, 0.0f, 36.024f, 0.0f, 57.0f);
generalPath.curveTo(0.0f, 80.71f, 19.29f, 100.0f, 43.0f, 100.0f);
generalPath.curveTo(66.71f, 100.0f, 86.0f, 80.71f, 86.0f, 57.0f);
generalPath.curveTo(86.0f, 48.029f, 83.235f, 39.695f, 78.518f, 32.795f);
generalPath.lineTo(87.506f, 23.807f);
generalPath.closePath();
generalPath.moveTo(42.999996f, 94.0f);
generalPath.curveTo(22.597996f, 94.0f, 5.999996f, 77.402f, 5.999996f, 57.0f);
generalPath.curveTo(5.999996f, 36.598f, 22.597996f, 20.0f, 42.999996f, 20.0f);
generalPath.curveTo(63.401997f, 20.0f, 80.0f, 36.598f, 80.0f, 57.0f);
generalPath.curveTo(80.0f, 77.402f, 63.402f, 94.0f, 43.0f, 94.0f);
generalPath.closePath();
shape = generalPath;
paint = new Color(204, 204, 204, 255);
g.setPaint(paint);
g.fill(shape);
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
        return 0.06247001513838768;
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
		return 0.875059962272644;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 1.0;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private chrono_noun_project_282() {
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
       chrono_noun_project_282 base = new chrono_noun_project_282();
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
       chrono_noun_project_282 base = new chrono_noun_project_282();
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
        return chrono_noun_project_282::new;
    }
}

