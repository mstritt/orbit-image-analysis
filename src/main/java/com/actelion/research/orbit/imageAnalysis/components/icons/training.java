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
public class training implements ResizableIcon {
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
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -87.73738861083984f, 169.78179931640625f));
// _0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(119.05743f, -157.6583f);
generalPath.curveTo(115.514305f, -157.6583f, 114.642944f, -155.02594f, 114.642944f, -151.77774f);
generalPath.curveTo(114.642944f, -149.61227f, 113.92346f, -147.7242f, 115.82432f, -146.70338f);
generalPath.lineTo(115.82432f, -143.85796f);
generalPath.curveTo(115.82432f, -143.13185f, 116.45486f, -142.5538f, 117.24689f, -142.5538f);
generalPath.lineTo(121.643906f, -142.5538f);
generalPath.curveTo(122.435936f, -142.5538f, 123.09234f, -143.13185f, 123.09234f, -143.85796f);
generalPath.lineTo(123.09234f, -147.20134f);
generalPath.curveTo(124.54372f, -148.27962f, 123.4719f, -149.93169f, 123.4719f, -151.77776f);
generalPath.curveTo(123.4719f, -155.02596f, 122.60054f, -157.65831f, 119.057434f, -157.65831f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 170, 170, 255);
g.setPaint(paint);
g.fill(shape);
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
generalPath.moveTo(93.84375f, -165.53125f);
generalPath.curveTo(93.84375f, -165.53125f, 94.03707f, -162.63316f, 95.90625f, -160.0f);
generalPath.curveTo(95.13952f, -153.98573f, 95.45999f, -150.60896f, 97.0f, -146.53125f);
generalPath.curveTo(100.74802f, -141.0695f, 104.02066f, -133.5155f, 109.65625f, -138.59375f);
generalPath.curveTo(113.43222f, -147.40442f, 105.92692f, -149.57004f, 101.53125f, -150.59375f);
generalPath.curveTo(100.46818f, -153.77483f, 98.47306f, -156.1657f, 97.5625f, -159.46875f);
generalPath.curveTo(97.35132f, -159.72823f, 97.21199f, -159.91817f, 97.09375f, -160.09375f);
generalPath.lineTo(99.6875f, -161.15625f);
generalPath.lineTo(99.875f, -165.125f);
generalPath.lineTo(93.84375f, -165.53125f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
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
generalPath.moveTo(103.0721f, -165.00746f);
generalPath.lineTo(92.97901f, -162.46555f);
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(1.172419f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(103.0721f, -165.00746f);
generalPath.lineTo(92.97901f, -162.46555f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-0.9697195887565613f, 0.24422112107276917f, 0.2185806781053543f, 0.9758188724517822f, 0.0f, 0.0f));
// _0_0_3
shape = new RoundRectangle2D.Double(-123.68041229248047, -138.87442016601562, 2.0780551433563232, 7.977999687194824, 1.7630902528762817, 1.7630902528762817);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-0.9697195887565613f, 0.24422112107276917f, 0.2185806781053543f, 0.9758188724517822f, 0.0f, 0.0f));
// _0_0_4
shape = new RoundRectangle2D.Double(-126.01930236816406, -140.04771423339844, 2.0455572605133057, 10.324569702148438, 2.0455572605133057, 2.2816684246063232);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9697195887565613f, -0.24422112107276917f, 0.2185806781053543f, 0.9758188724517822f, 0.0f, 0.0f));
// _0_0_5
shape = new RoundRectangle2D.Double(136.81813049316406, -138.87442016601562, 2.0780551433563232, 7.977999687194824, 1.7630902528762817, 1.7630902528762817);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9697195887565613f, -0.24422112107276917f, 0.2185806781053543f, 0.9758188724517822f, 0.0f, 0.0f));
// _0_0_6
shape = new RoundRectangle2D.Double(134.47923278808594, -140.04771423339844, 2.0455572605133057, 10.324569702148438, 2.0455572605133057, 2.2816684246063232);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
paint = new Color(0, 255, 255, 255);
stroke = new BasicStroke(1.0f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(108.12854f, -134.09512f);
generalPath.curveTo(108.12854f, -134.09512f, 113.16616f, -125.33406f, 113.16616f, -122.92476f);
generalPath.curveTo(113.16616f, -120.51547f, 113.82324f, -112.6305f, 113.82324f, -112.6305f);
generalPath.curveTo(116.63199f, -112.29125f, 122.4706f, -112.20422f, 125.887f, -112.6305f);
generalPath.curveTo(125.887f, -112.6305f, 126.54408f, -120.51547f, 126.54408f, -122.92476f);
generalPath.curveTo(126.54408f, -125.33406f, 131.5817f, -134.09512f, 131.5817f, -134.09512f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(143.79387f, -164.69688f);
generalPath.curveTo(143.79387f, -164.69688f, 143.60056f, -161.79881f, 141.73137f, -159.16563f);
generalPath.curveTo(142.4981f, -153.15137f, 142.17763f, -149.77461f, 140.63762f, -145.69688f);
generalPath.curveTo(136.8896f, -140.23515f, 133.61696f, -132.68115f, 127.98137f, -137.75938f);
generalPath.curveTo(124.2054f, -146.57005f, 131.7107f, -148.73569f, 136.10637f, -149.75938f);
generalPath.curveTo(137.16943f, -152.94046f, 139.16457f, -155.33133f, 140.07512f, -158.63438f);
generalPath.curveTo(140.2863f, -158.89388f, 140.42563f, -159.08382f, 140.54387f, -159.25938f);
generalPath.lineTo(137.95012f, -160.32188f);
generalPath.lineTo(137.76262f, -164.29063f);
generalPath.lineTo(143.79387f, -164.69688f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(134.56552f, -164.1731f);
generalPath.lineTo(144.65862f, -161.63118f);
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(1.172419f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(134.56552f, -164.1731f);
generalPath.lineTo(144.65862f, -161.63118f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9697195887565613f, 0.24422112107276917f, -0.2185806781053543f, 0.9758188724517822f, 0.0f, 0.0f));
// _0_0_10
shape = new RoundRectangle2D.Double(108.47386932373047, -196.121337890625, 2.0780551433563232, 7.977999687194824, 1.7630902528762817, 1.7630902528762817);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9697195887565613f, 0.24422112107276917f, -0.2185806781053543f, 0.9758188724517822f, 0.0f, 0.0f));
// _0_0_11
shape = new RoundRectangle2D.Double(106.13497161865234, -197.29461669921875, 2.0455572605133057, 10.324569702148438, 2.0455572605133057, 2.2816684246063232);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-0.9697195887565613f, -0.24422112107276917f, -0.2185806781053543f, 0.9758188724517822f, 0.0f, 0.0f));
// _0_0_12
shape = new RoundRectangle2D.Double(-95.33615112304688, -196.121337890625, 2.0780551433563232, 7.977999687194824, 1.7630902528762817, 1.7630902528762817);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-0.9697195887565613f, -0.24422112107276917f, -0.2185806781053543f, 0.9758188724517822f, 0.0f, 0.0f));
// _0_0_13
shape = new RoundRectangle2D.Double(-97.67504119873047, -197.29461669921875, 2.0455572605133057, 10.324569702148438, 2.0455572605133057, 2.2816684246063232);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_14
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(123.24148f, -160.63097f);
generalPath.curveTo(124.54241f, -165.73212f, 128.79971f, -166.82722f, 129.23708f, -166.10406f);
generalPath.curveTo(130.65114f, -163.76604f, 126.96293f, -163.49149f, 126.23928f, -163.76604f);
generalPath.curveTo(124.90067f, -164.2739f, 123.29253f, -160.42577f, 123.29804f, -160.41841f);
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(0.6158532f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(123.24148f, -160.63097f);
generalPath.curveTo(124.54241f, -165.73212f, 128.79971f, -166.82722f, 129.23708f, -166.10406f);
generalPath.curveTo(130.65114f, -163.76604f, 126.96293f, -163.49149f, 126.23928f, -163.76604f);
generalPath.curveTo(124.90067f, -164.2739f, 123.29253f, -160.42577f, 123.29804f, -160.41841f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(120.36819f, -161.98245f);
generalPath.curveTo(119.90735f, -165.74084f, 122.14137f, -167.63336f, 122.57136f, -167.27026f);
generalPath.curveTo(123.96154f, -166.09631f, 121.86443f, -164.90657f, 121.37417f, -164.89224f);
generalPath.curveTo(120.46729f, -164.86574f, 120.44736f, -161.8595f, 120.45235f, -161.8561f);
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(0.41621017f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(120.36819f, -161.98245f);
generalPath.curveTo(119.90735f, -165.74084f, 122.14137f, -167.63336f, 122.57136f, -167.27026f);
generalPath.curveTo(123.96154f, -166.09631f, 121.86443f, -164.90657f, 121.37417f, -164.89224f);
generalPath.curveTo(120.46729f, -164.86574f, 120.44736f, -161.8595f, 120.45235f, -161.8561f);
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
		return 62.162837982177734;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 58.04068374633789;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private training() {
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
       training base = new training();
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
       training base = new training();
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
        return training::new;
    }
}

