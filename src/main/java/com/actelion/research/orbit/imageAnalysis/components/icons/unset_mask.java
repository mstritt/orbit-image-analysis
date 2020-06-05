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
public class unset_mask implements ResizableIcon {
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
g.transform(new AffineTransform(1.0666667222976685f, 0.0f, 0.0f, 1.0666667222976685f, -0.0f, -0.0f));
// _0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, -343.7007751464844f));
// _0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0
paint = new Color(20, 20, 20, 255);
stroke = new BasicStroke(25.968897f,1,2,4.0f,new float[] {25.968897f,25.968897f},0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(634.1518f, 748.0095f);
generalPath.curveTo(634.1518f, 821.8913f, 604.8024f, 892.747f, 552.5601f, 944.9893f);
generalPath.curveTo(500.31787f, 997.2316f, 429.4621f, 1026.581f, 355.58035f, 1026.581f);
generalPath.curveTo(281.6986f, 1026.581f, 210.84285f, 997.2316f, 158.60057f, 944.9893f);
generalPath.curveTo(106.358284f, 892.747f, 77.00889f, 821.8913f, 77.00891f, 748.0095f);
generalPath.curveTo(77.00891f, 674.1278f, 106.358315f, 603.27203f, 158.6006f, 551.0298f);
generalPath.curveTo(210.84288f, 498.78748f, 281.6986f, 469.43808f, 355.58035f, 469.43808f);
generalPath.curveTo(429.4621f, 469.43808f, 500.31784f, 498.78748f, 552.5601f, 551.0298f);
generalPath.curveTo(604.80237f, 603.27203f, 634.1518f, 674.1278f, 634.1518f, 748.0095f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
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
generalPath.moveTo(116.90107f, 379.37112f);
generalPath.lineTo(595.5989f, 379.37112f);
generalPath.curveTo(596.1822f, 379.37112f, 596.65173f, 379.83612f, 596.65173f, 380.4137f);
generalPath.lineTo(596.65173f, 798.1946f);
generalPath.curveTo(596.65173f, 798.7722f, 596.1822f, 799.2372f, 595.5989f, 799.2372f);
generalPath.lineTo(116.90107f, 799.2372f);
generalPath.curveTo(116.31779f, 799.2372f, 115.84821f, 798.7722f, 115.84821f, 798.1946f);
generalPath.lineTo(115.84821f, 380.4137f);
generalPath.curveTo(115.84821f, 379.83612f, 116.31779f, 379.37112f, 116.90107f, 379.37112f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(20, 20, 20, 255);
stroke = new BasicStroke(5.625f,1,2,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(116.90107f, 379.37112f);
generalPath.lineTo(595.5989f, 379.37112f);
generalPath.curveTo(596.1822f, 379.37112f, 596.65173f, 379.83612f, 596.65173f, 380.4137f);
generalPath.lineTo(596.65173f, 798.1946f);
generalPath.curveTo(596.65173f, 798.7722f, 596.1822f, 799.2372f, 595.5989f, 799.2372f);
generalPath.lineTo(116.90107f, 799.2372f);
generalPath.curveTo(116.31779f, 799.2372f, 115.84821f, 798.7722f, 115.84821f, 798.1946f);
generalPath.lineTo(115.84821f, 380.4137f);
generalPath.curveTo(115.84821f, 379.83612f, 116.31779f, 379.37112f, 116.90107f, 379.37112f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(355.98163f, 468.53342f);
generalPath.curveTo(257.4097f, 468.65912f, 166.2433f, 520.8682f, 116.25079f, 605.82227f);
generalPath.lineTo(116.25079f, 797.2901f);
generalPath.curveTo(116.25079f, 797.86774f, 116.72036f, 798.3338f, 117.30364f, 798.3338f);
generalPath.lineTo(595.99994f, 798.3338f);
generalPath.curveTo(596.5832f, 798.3338f, 597.0528f, 797.86774f, 597.0528f, 797.2901f);
generalPath.lineTo(597.0528f, 608.20447f);
generalPath.curveTo(547.4207f, 521.92114f, 455.52127f, 468.6767f, 355.98163f, 468.53342f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 255, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(20, 20, 20, 255);
stroke = new BasicStroke(5.625f,1,2,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(355.98163f, 468.53342f);
generalPath.curveTo(257.4097f, 468.65912f, 166.2433f, 520.8682f, 116.25079f, 605.82227f);
generalPath.lineTo(116.25079f, 797.2901f);
generalPath.curveTo(116.25079f, 797.86774f, 116.72036f, 798.3338f, 117.30364f, 798.3338f);
generalPath.lineTo(595.99994f, 798.3338f);
generalPath.curveTo(596.5832f, 798.3338f, 597.0528f, 797.86774f, 597.0528f, 797.2901f);
generalPath.lineTo(597.0528f, 608.20447f);
generalPath.curveTo(547.4207f, 521.92114f, 455.52127f, 468.6767f, 355.98163f, 468.53342f);
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
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(677.6786f, 364.63898f);
generalPath.lineTo(35.49107f, 1028.2551f);
shape = generalPath;
paint = new Color(255, 0, 14, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 0, 14, 255);
stroke = new BasicStroke(18.655512f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(677.6786f, 364.63898f);
generalPath.lineTo(35.49107f, 1028.2551f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(684.8438f, 1010.2417f);
generalPath.lineTo(21.227648f, 368.0542f);
shape = generalPath;
paint = new Color(255, 0, 14, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 0, 14, 255);
stroke = new BasicStroke(18.655512f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(684.8438f, 1010.2417f);
generalPath.lineTo(21.227648f, 368.0542f);
shape = generalPath;
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
        return 15.723775863647461;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 15.415040016174316;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 721.6953735351562;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 726.8406982421875;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private unset_mask() {
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
       unset_mask base = new unset_mask();
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
       unset_mask base = new unset_mask();
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
        return unset_mask::new;
    }
}

