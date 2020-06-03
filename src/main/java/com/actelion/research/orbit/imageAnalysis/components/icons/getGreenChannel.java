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
public class getGreenChannel implements ResizableIcon {
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
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -79.62864685058594f, -236.8760986328125f));
// _0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0
shape = new Rectangle2D.Double(83.2044677734375, 303.3289489746094, 120.60572052001953, 58.02677917480469);
paint = new Color(0, 255, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 255, 0, 255);
stroke = new BasicStroke(1.3942702f,0,0,4.0f,null,0.0f);
shape = new Rectangle2D.Double(83.2044677734375, 303.3289489746094, 120.60572052001953, 58.02677917480469);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
paint = new Color(204, 204, 204, 255);
stroke = new BasicStroke(1.3942702f,0,0,4.0f,null,0.0f);
shape = new Rectangle2D.Double(83.2044677734375, 240.39645385742188, 120.60572052001953, 58.02677917480469);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
shape = new Ellipse2D.Double(87.88867950439453, 245.92279052734375, 37.25825119018555, 34.42982482910156);
paint = new Color(0, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3
shape = new Ellipse2D.Double(117.11587524414062, 255.15679931640625, 44.0, 40.0);
paint = new Color(255, 0, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
shape = new Ellipse2D.Double(159.45187377929688, 243.99905395507812, 40.0, 44.0);
paint = new Color(102, 255, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5
paint = new Color(179, 179, 179, 255);
stroke = new BasicStroke(8.0f,1,1,5.5f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(145.44489f, 278.0147f);
generalPath.curveTo(145.44489f, 338.0147f, 145.44489f, 338.0147f, 145.44489f, 338.0147f);
generalPath.lineTo(125.44488f, 318.0147f);
generalPath.lineTo(145.44489f, 338.0147f);
generalPath.lineTo(165.44489f, 318.0147f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_1
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_1_0
shape = new Rectangle2D.Double(84.0621566772461, 310.1986389160156, 117.88873291015625, 44.67893600463867);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 255, 255);
stroke = new BasicStroke(2.7352762f,0,0,4.0f,null,0.0f);
shape = new Rectangle2D.Double(84.0621566772461, 310.1986389160156, 117.88873291015625, 44.67893600463867);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-2.369846820831299f, -0.004105430096387863f, 0.003880009986460209f, -2.2397258281707764f, 199.8973388671875f, 354.01605224609375f));
// _0_1_1
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_1_1_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(23.531f, 4.5f);
generalPath.curveTo(13.683f, 4.8989f, 5.84f, 12.515f, 4.625f, 22.156f);
generalPath.lineTo(15.25f, 22.156f);
generalPath.curveTo(16.308f, 18.23f, 20.101f, 15.173f, 24.281f, 15.219f);
generalPath.curveTo(26.645f, 15.245f, 28.927f, 16.018f, 30.625f, 17.656f);
generalPath.lineTo(26.219f, 21.719f);
generalPath.lineTo(42.25f, 21.719f);
generalPath.lineTo(42.25f, 5.906f);
generalPath.lineTo(38.031f, 10.125f);
generalPath.curveTo(34.323f, 6.481f, 30.035f, 4.5602f, 24.562f, 4.5f);
generalPath.curveTo(24.215f, 4.4962f, 23.875f, 4.4861f, 23.531f, 4.5f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(15.373000144958496, 5.0472002029418945), new Point2D.Double(15.373000144958496, 22.600000381469727), new float[] {0.0f,1.0f}, new Color[] {new Color(147, 185, 221, 255),new Color(99, 150, 205, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9543700218200684f, 0.0f, 0.0f, 0.9543700218200684f, 0.4932999908924103f, 2.8945999145507812f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(56, 122, 184, 255);
stroke = new BasicStroke(1.0f,0,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(23.531f, 4.5f);
generalPath.curveTo(13.683f, 4.8989f, 5.84f, 12.515f, 4.625f, 22.156f);
generalPath.lineTo(15.25f, 22.156f);
generalPath.curveTo(16.308f, 18.23f, 20.101f, 15.173f, 24.281f, 15.219f);
generalPath.curveTo(26.645f, 15.245f, 28.927f, 16.018f, 30.625f, 17.656f);
generalPath.lineTo(26.219f, 21.719f);
generalPath.lineTo(42.25f, 21.719f);
generalPath.lineTo(42.25f, 5.906f);
generalPath.lineTo(38.031f, 10.125f);
generalPath.curveTo(34.323f, 6.481f, 30.035f, 4.5602f, 24.562f, 4.5f);
generalPath.curveTo(24.215f, 4.4962f, 23.875f, 4.4861f, 23.531f, 4.5f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.4f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_1_1_1
paint = new LinearGradientPaint(new Point2D.Double(35.233001708984375, 10.677000045776367), new Point2D.Double(10.51200008392334, 19.947999954223633), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9543700218200684f, 0.0f, 0.0f, 0.9543700218200684f, 0.4932999908924103f, 2.8945999145507812f));
stroke = new BasicStroke(1.193f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(14.219f, 21.75f);
generalPath.curveTo(15.5083f, 17.4619f, 19.8079f, 13.9962f, 24.344f, 14.0625f);
generalPath.curveTo(27.0171f, 14.10158f, 30.299f, 15.2544f, 32.3128f, 17.5313f);
generalPath.lineTo(29.094f, 20.5938f);
generalPath.lineTo(41.156f, 20.62505f);
generalPath.lineTo(41.156f, 8.56305f);
generalPath.lineTo(38.0f, 11.78125f);
generalPath.curveTo(34.458f, 7.83065f, 29.947f, 5.80565f, 24.406f, 5.75025f);
generalPath.curveTo(14.797f, 5.65405f, 7.234f, 12.56525f, 5.844f, 21.75025f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
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
        return 2.8786849975585938;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 2.8232202529907227;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 125.1213150024414;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 125.1767807006836;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private getGreenChannel() {
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
       getGreenChannel base = new getGreenChannel();
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
       getGreenChannel base = new getGreenChannel();
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
        return getGreenChannel::new;
    }
}

