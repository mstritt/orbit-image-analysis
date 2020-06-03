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
public class mask2browser implements ResizableIcon {
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
stroke = new BasicStroke(16.028175f,1,2,4.0f,new float[] {16.028175f,16.028175f},0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(358.99115f, 719.65985f);
generalPath.curveTo(358.99115f, 765.26013f, 340.87653f, 808.9928f, 308.63223f, 841.23706f);
generalPath.curveTo(276.38797f, 873.4814f, 232.65532f, 891.596f, 187.05502f, 891.596f);
generalPath.curveTo(141.45473f, 891.596f, 97.7221f, 873.4813f, 65.47782f, 841.23706f);
generalPath.curveTo(33.233543f, 808.9928f, 15.1189f, 765.26013f, 15.118908f, 719.65985f);
generalPath.curveTo(15.118925f, 624.70215f, 92.097336f, 547.72375f, 187.05502f, 547.72375f);
generalPath.curveTo(282.01273f, 547.72375f, 358.99112f, 624.70215f, 358.99115f, 719.65985f);
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
generalPath.moveTo(39.740612f, 492.1338f);
generalPath.lineTo(335.19604f, 492.1338f);
generalPath.curveTo(335.55606f, 492.1338f, 335.8459f, 492.4208f, 335.8459f, 492.7773f);
generalPath.lineTo(335.8459f, 750.63446f);
generalPath.curveTo(335.8459f, 750.9909f, 335.55606f, 751.2779f, 335.19604f, 751.2779f);
generalPath.lineTo(39.740612f, 751.2779f);
generalPath.curveTo(39.380608f, 751.2779f, 39.09078f, 750.9909f, 39.09078f, 750.63446f);
generalPath.lineTo(39.09078f, 492.7773f);
generalPath.curveTo(39.09078f, 492.4208f, 39.380608f, 492.1338f, 39.740612f, 492.1338f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(20, 20, 20, 255);
stroke = new BasicStroke(3.4717872f,1,2,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(39.740612f, 492.1338f);
generalPath.lineTo(335.19604f, 492.1338f);
generalPath.curveTo(335.55606f, 492.1338f, 335.8459f, 492.4208f, 335.8459f, 492.7773f);
generalPath.lineTo(335.8459f, 750.63446f);
generalPath.curveTo(335.8459f, 750.9909f, 335.55606f, 751.2779f, 335.19604f, 751.2779f);
generalPath.lineTo(39.740612f, 751.2779f);
generalPath.curveTo(39.380608f, 751.2779f, 39.09078f, 750.9909f, 39.09078f, 750.63446f);
generalPath.lineTo(39.09078f, 492.7773f);
generalPath.curveTo(39.09078f, 492.4208f, 39.380608f, 492.1338f, 39.740612f, 492.1338f);
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
generalPath.moveTo(187.3027f, 547.16534f);
generalPath.curveTo(126.46346f, 547.2429f, 70.194954f, 579.46674f, 39.339252f, 631.90094f);
generalPath.lineTo(39.339252f, 750.0762f);
generalPath.curveTo(39.339252f, 750.4327f, 39.629074f, 750.72034f, 39.98908f, 750.72034f);
generalPath.lineTo(335.44357f, 750.72034f);
generalPath.curveTo(335.8036f, 750.72034f, 336.0934f, 750.4327f, 336.0934f, 750.0762f);
generalPath.lineTo(336.0934f, 633.3712f);
generalPath.curveTo(305.46017f, 580.1166f, 248.73921f, 547.2538f, 187.3027f, 547.16534f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 255, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(20, 20, 20, 255);
stroke = new BasicStroke(3.4717872f,1,2,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(187.3027f, 547.16534f);
generalPath.curveTo(126.46346f, 547.2429f, 70.194954f, 579.46674f, 39.339252f, 631.90094f);
generalPath.lineTo(39.339252f, 750.0762f);
generalPath.curveTo(39.339252f, 750.4327f, 39.629074f, 750.72034f, 39.98908f, 750.72034f);
generalPath.lineTo(335.44357f, 750.72034f);
generalPath.curveTo(335.8036f, 750.72034f, 336.0934f, 750.4327f, 336.0934f, 750.0762f);
generalPath.lineTo(336.0934f, 633.3712f);
generalPath.curveTo(305.46017f, 580.1166f, 248.73921f, 547.2538f, 187.3027f, 547.16534f);
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
paint = new Color(230, 230, 230, 255);
stroke = new BasicStroke(8.4375f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(489.50894f, 554.81757f);
generalPath.lineTo(665.625f, 554.81757f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
paint = new Color(230, 230, 230, 255);
stroke = new BasicStroke(8.4375f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(489.5089f, 638.25507f);
generalPath.lineTo(665.625f, 638.25507f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5
paint = new Color(230, 230, 230, 255);
stroke = new BasicStroke(8.4375f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(489.5089f, 721.69257f);
generalPath.lineTo(665.625f, 721.69257f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6
paint = new Color(230, 230, 230, 255);
stroke = new BasicStroke(8.4375f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(489.5089f, 805.13007f);
generalPath.lineTo(665.625f, 805.13007f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
paint = new Color(230, 230, 230, 255);
stroke = new BasicStroke(8.4375f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(489.5089f, 888.56757f);
generalPath.lineTo(665.625f, 888.56757f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8
paint = new Color(230, 230, 230, 255);
stroke = new BasicStroke(8.4375f,1,2,4.0f,null,0.0f);
shape = new RoundRectangle2D.Double(470.7589111328125, 524.5496826171875, 212.2767791748047, 399.1071472167969, 2.1057186126708984, 2.0851686000823975);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9
paint = new Color(230, 230, 230, 255);
stroke = new BasicStroke(8.4375f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(166.07143f, 460.39792f);
generalPath.curveTo(211.83144f, 430.93292f, 257.59036f, 401.46866f, 307.70123f, 387.5181f);
generalPath.curveTo(357.8121f, 373.56754f, 412.27768f, 375.1301f, 455.52646f, 396.60007f);
generalPath.curveTo(498.77524f, 418.07004f, 531.0267f, 459.72815f, 563.1696f, 501.24615f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10
paint = new Color(230, 230, 230, 255);
stroke = new BasicStroke(8.4375f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(563.1696f, 501.24615f);
generalPath.lineTo(564.5089f, 447.00507f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_11
paint = new Color(230, 230, 230, 255);
stroke = new BasicStroke(8.4375f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(563.1696f, 501.24615f);
generalPath.lineTo(510.9375f, 489.8622f);
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

