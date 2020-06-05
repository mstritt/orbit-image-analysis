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
public class ribbon_bar implements ResizableIcon {
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
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f));
// _0_0_0
shape = new Rectangle2D.Double(0.22005188465118408, -10.876255989074707, 31.746553421020508, 8.964639663696289);
paint = new Color(102, 102, 102, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(204, 204, 204, 255);
stroke = new BasicStroke(0.28041378f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(0.22005188465118408, -10.876255989074707, 31.746553421020508, 8.964639663696289);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
shape = new Rectangle2D.Double(0.29186734557151794, 11.228486061096191, 31.602922439575195, 20.593345642089844);
paint = new Color(26, 26, 26, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(204, 204, 204, 255);
stroke = new BasicStroke(0.42404476f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(0.29186734557151794, 11.228486061096191, 31.602922439575195, 20.593345642089844);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.017215609550476f, 0.0f, 0.0f, 1.0663553476333618f, 9.241545677185059f, 2.1647984981536865f));
// _0_0_2
paint = new Color(255, 0, 0, 255);
stroke = new BasicStroke(0.6117833f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(6.8054304f, 4.2714934f);
generalPath.curveTo(6.809433f, 5.1794815f, 6.3342443f, 6.02024f, 5.5597973f, 6.47541f);
generalPath.curveTo(4.7853503f, 6.93058f, 3.8300352f, 6.93058f, 3.0555882f, 6.47541f);
generalPath.curveTo(2.2811413f, 6.02024f, 1.8059524f, 5.1794815f, 1.8099551f, 4.2714934f);
generalPath.curveTo(1.8059524f, 3.3635054f, 2.2811413f, 2.522747f, 3.0555882f, 2.067577f);
generalPath.curveTo(3.8300352f, 1.6124066f, 4.7853503f, 1.6124066f, 5.5597973f, 2.067577f);
generalPath.curveTo(6.3342443f, 2.522747f, 6.809433f, 3.3635054f, 6.8054304f, 4.2714934f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3
paint = new Color(0, 255, 0, 255);
stroke = new BasicStroke(0.6371697f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(20.049957275390625, 4.063622951507568, 5.14412784576416, 5.312210559844971);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
paint = new Color(0, 177, 255, 255);
stroke = new BasicStroke(0.6371697f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(3.1063871f, 9.096748f);
generalPath.lineTo(4.9120235f, 8.640881f);
generalPath.lineTo(7.520166f, 9.422367f);
generalPath.lineTo(5.5139027f, 7.533776f);
generalPath.lineTo(7.319539f, 7.2732806f);
generalPath.lineTo(7.520166f, 4.407832f);
generalPath.lineTo(5.447027f, 4.798575f);
generalPath.lineTo(3.9757676f, 4.0170894f);
generalPath.lineTo(2.4376328f, 5.189318f);
generalPath.lineTo(3.7082658f, 6.4266706f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5
shape = new Rectangle2D.Double(0.13599058985710144, 0.28527817130088806, 31.914676666259766, 1.4299856424331665);
paint = new Color(77, 77, 77, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(204, 204, 204, 255);
stroke = new BasicStroke(0.11229119f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(0.13599058985710144, 0.28527817130088806, 31.914676666259766, 1.4299856424331665);
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
        return 0.07984496653079987;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 0.22913257777690887;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 31.920154571533203;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 31.7708683013916;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private ribbon_bar() {
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
       ribbon_bar base = new ribbon_bar();
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
       ribbon_bar base = new ribbon_bar();
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
        return ribbon_bar::new;
    }
}

