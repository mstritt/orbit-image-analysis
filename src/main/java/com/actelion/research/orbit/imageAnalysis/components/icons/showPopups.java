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
public class showPopups implements ResizableIcon {
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
shape = new Rectangle2D.Double(85.78311157226562, 241.449951171875, 116.2145767211914, 117.78132629394531);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 255, 255);
stroke = new BasicStroke(4.409427f,0,0,4.0f,null,0.0f);
shape = new Rectangle2D.Double(85.78311157226562, 241.449951171875, 116.2145767211914, 117.78132629394531);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
shape = new Rectangle2D.Double(120.79837799072266, 257.7753601074219, 70.43382263183594, 60.51008987426758);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 255, 255);
stroke = new BasicStroke(2.4604707f,0,0,4.0f,null,0.0f);
shape = new Rectangle2D.Double(120.79837799072266, 257.7753601074219, 70.43382263183594, 60.51008987426758);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.0141658f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(120.32559f, 256.87967f);
generalPath.curveTo(95.63882f, 344.87253f, 95.63882f, 344.87253f, 95.63882f, 344.87253f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.0394388f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(191.79599f, 318.95993f);
generalPath.curveTo(95.63809f, 344.84772f, 95.63809f, 344.84772f, 95.63809f, 344.84772f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.042525f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(119.96717f, 319.12338f);
generalPath.curveTo(95.643684f, 344.86108f, 95.643684f, 344.86108f, 95.643684f, 344.86108f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0344314575195312f, 0.0f, 0.0f, 0.9667146801948547f, 0.0f, 0.0f));
// _0_0_5
{
    Graphics2D gText = ((Graphics2D)g.create());
            Shape shapeText = null;
            GeneralPath generalPathText = null;
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
paint = new Color(0, 0, 0, 255);
gText.setPaint(paint);
if (generalPathText == null) {
   generalPathText = new GeneralPath();
} else {
   generalPathText.reset();
}
generalPathText.moveTo(130.35881f, 305.94998f);
generalPathText.lineTo(127.27463f, 305.94998f);
generalPathText.lineTo(127.27463f, 286.29114f);
generalPathText.quadTo(126.15518f, 287.3535f, 124.350365f, 288.4158f);
generalPathText.quadTo(122.54554f, 289.47815f, 121.106255f, 290.015f);
generalPathText.lineTo(121.106255f, 287.03363f);
generalPathText.quadTo(123.687836f, 285.81137f, 125.61831f, 284.08652f);
generalPathText.quadTo(127.5602f, 282.35025f, 128.37123f, 280.72818f);
generalPathText.lineTo(130.35881f, 280.72818f);
generalPathText.lineTo(130.35881f, 305.94998f);
generalPathText.closePath();
generalPathText.moveTo(154.46687f, 302.98f);
generalPathText.lineTo(154.46687f, 305.94998f);
generalPathText.lineTo(137.85796f, 305.94998f);
generalPathText.quadTo(137.82368f, 304.83054f, 138.2235f, 303.80246f);
generalPathText.quadTo(138.85175f, 302.11188f, 140.24535f, 300.46698f);
generalPathText.quadTo(141.65036f, 298.82208f, 144.28906f, 296.66315f);
generalPathText.quadTo(148.37846f, 293.3048f, 149.81775f, 291.3401f);
generalPathText.quadTo(151.25703f, 289.37534f, 151.25703f, 287.62762f);
generalPathText.quadTo(151.25703f, 285.79996f, 149.9434f, 284.54343f);
generalPathText.quadTo(148.64119f, 283.27548f, 146.52795f, 283.27548f);
generalPathText.quadTo(144.30048f, 283.27548f, 142.964f, 284.61197f);
generalPathText.quadTo(141.62752f, 285.94846f, 141.61609f, 288.313f);
generalPathText.lineTo(138.44052f, 287.99316f);
generalPathText.quadTo(138.77179f, 284.44064f, 140.89645f, 282.59012f);
generalPathText.quadTo(143.02112f, 280.72818f, 146.59648f, 280.72818f);
generalPathText.quadTo(150.21754f, 280.72818f, 152.31937f, 282.73862f);
generalPathText.quadTo(154.4326f, 284.73764f, 154.4326f, 287.69617f);
generalPathText.quadTo(154.4326f, 289.20398f, 153.81577f, 290.6661f);
generalPathText.quadTo(153.19893f, 292.11682f, 151.75964f, 293.72748f);
generalPathText.quadTo(150.33177f, 295.3381f, 147.0077f, 298.14813f);
generalPathText.quadTo(144.23195f, 300.4784f, 143.44376f, 301.3123f);
generalPathText.quadTo(142.65558f, 302.14615f, 142.14154f, 302.98f);
generalPathText.lineTo(154.46687f, 302.98f);
generalPathText.closePath();
generalPathText.moveTo(157.78523f, 299.31326f);
generalPathText.lineTo(160.86942f, 298.90204f);
generalPathText.quadTo(161.4063f, 301.52933f, 162.67424f, 302.683f);
generalPathText.quadTo(163.95361f, 303.83673f, 165.7927f, 303.83673f);
generalPathText.quadTo(167.96304f, 303.83673f, 169.45946f, 302.32892f);
generalPathText.quadTo(170.96727f, 300.8211f, 170.96727f, 298.59363f);
generalPathText.quadTo(170.96727f, 296.46896f, 169.57368f, 295.0982f);
generalPathText.quadTo(168.19151f, 293.71603f, 166.044f, 293.71603f);
generalPathText.quadTo(165.17586f, 293.71603f, 163.87364f, 294.05872f);
generalPathText.lineTo(164.21634f, 291.3515f);
generalPathText.quadTo(164.52475f, 291.38577f, 164.70752f, 291.38577f);
generalPathText.quadTo(166.68369f, 291.38577f, 168.26004f, 290.3577f);
generalPathText.quadTo(169.83641f, 289.32965f, 169.83641f, 287.18213f);
generalPathText.quadTo(169.83641f, 285.49155f, 168.6827f, 284.3835f);
generalPathText.quadTo(167.5404f, 283.26407f, 165.72415f, 283.26407f);
generalPathText.quadTo(163.91934f, 283.26407f, 162.71992f, 284.39493f);
generalPathText.quadTo(161.52052f, 285.52582f, 161.17784f, 287.78754f);
generalPathText.lineTo(158.09364f, 287.23926f);
generalPathText.quadTo(158.6648f, 284.1322f, 160.6638f, 282.4302f);
generalPathText.quadTo(162.67424f, 280.72818f, 165.65562f, 280.72818f);
generalPathText.quadTo(167.71175f, 280.72818f, 169.4366f, 281.60776f);
generalPathText.quadTo(171.17288f, 282.4873f, 172.08672f, 284.01797f);
generalPathText.quadTo(173.00055f, 285.53723f, 173.00055f, 287.25067f);
generalPathText.quadTo(173.00055f, 288.88416f, 172.12099f, 290.22064f);
generalPathText.quadTo(171.25285f, 291.5571f, 169.53941f, 292.34528f);
generalPathText.quadTo(171.76688f, 292.8593f, 173.00055f, 294.48138f);
generalPathText.quadTo(174.23422f, 296.092f, 174.23422f, 298.5251f);
generalPathText.quadTo(174.23422f, 301.81488f, 171.83542f, 304.1109f);
generalPathText.quadTo(169.4366f, 306.39548f, 165.76985f, 306.39548f);
generalPathText.quadTo(162.46863f, 306.39548f, 160.27542f, 304.43073f);
generalPathText.quadTo(158.09364f, 302.45456f, 157.78523f, 299.31326f);
generalPathText.closePath();
shapeText = generalPath;
gText.fill(shapeText);
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
    gText.dispose();
}
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
        return 3.9497528076171875;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 2.369140625;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 120.6240005493164;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 122.19075012207031;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private showPopups() {
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
       showPopups base = new showPopups();
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
       showPopups base = new showPopups();
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
        return showPopups::new;
    }
}

