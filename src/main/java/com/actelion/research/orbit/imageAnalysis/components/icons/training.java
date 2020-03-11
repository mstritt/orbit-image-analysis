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
public class training implements ResizableIcon {
    

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
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -87.73738861083984f, 169.78179931640625f));
// _0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(119.05743, -157.6583);
((GeneralPath)shape).curveTo(115.514305, -157.6583, 114.642944, -155.02594, 114.642944, -151.77774);
((GeneralPath)shape).curveTo(114.642944, -149.61227, 113.92346, -147.7242, 115.82432, -146.70338);
((GeneralPath)shape).lineTo(115.82432, -143.85796);
((GeneralPath)shape).curveTo(115.82432, -143.13185, 116.45486, -142.5538, 117.24689, -142.5538);
((GeneralPath)shape).lineTo(121.643906, -142.5538);
((GeneralPath)shape).curveTo(122.435936, -142.5538, 123.09234, -143.13185, 123.09234, -143.85796);
((GeneralPath)shape).lineTo(123.09234, -147.20134);
((GeneralPath)shape).curveTo(124.54372, -148.27962, 123.4719, -149.93169, 123.4719, -151.77776);
((GeneralPath)shape).curveTo(123.4719, -155.02596, 122.60054, -157.65831, 119.057434, -157.65831);
((GeneralPath)shape).closePath();
paint = new Color(255, 170, 170, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(93.84375, -165.53125);
((GeneralPath)shape).curveTo(93.84375, -165.53125, 94.03707, -162.63316, 95.90625, -160.0);
((GeneralPath)shape).curveTo(95.13952, -153.98573, 95.45999, -150.60896, 97.0, -146.53125);
((GeneralPath)shape).curveTo(100.74802, -141.0695, 104.02066, -133.5155, 109.65625, -138.59375);
((GeneralPath)shape).curveTo(113.43222, -147.40442, 105.92692, -149.57004, 101.53125, -150.59375);
((GeneralPath)shape).curveTo(100.46818, -153.77483, 98.47306, -156.1657, 97.5625, -159.46875);
((GeneralPath)shape).curveTo(97.35132, -159.72823, 97.21199, -159.91817, 97.09375, -160.09375);
((GeneralPath)shape).lineTo(99.6875, -161.15625);
((GeneralPath)shape).lineTo(99.875, -165.125);
((GeneralPath)shape).lineTo(93.84375, -165.53125);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(103.0721, -165.00746);
((GeneralPath)shape).lineTo(92.97901, -162.46555);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(1.172419f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(103.0721, -165.00746);
((GeneralPath)shape).lineTo(92.97901, -162.46555);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_3 = g.getTransform();
g.transform(new AffineTransform(-0.9697195887565613f, 0.24422112107276917f, 0.2185806781053543f, 0.9758188724517822f, 0.0f, 0.0f));
// _0_0_3
shape = new RoundRectangle2D.Double(-123.68041229248047, -138.87442016601562, 2.0780551433563232, 7.977999687194824, 1.7630902528762817, 1.7630902528762817);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_3);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_4 = g.getTransform();
g.transform(new AffineTransform(-0.9697195887565613f, 0.24422112107276917f, 0.2185806781053543f, 0.9758188724517822f, 0.0f, 0.0f));
// _0_0_4
shape = new RoundRectangle2D.Double(-126.01930236816406, -140.04771423339844, 2.0455572605133057, 10.324569702148438, 2.0455572605133057, 2.2816684246063232);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_4);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_5 = g.getTransform();
g.transform(new AffineTransform(0.9697195887565613f, -0.24422112107276917f, 0.2185806781053543f, 0.9758188724517822f, 0.0f, 0.0f));
// _0_0_5
shape = new RoundRectangle2D.Double(136.81813049316406, -138.87442016601562, 2.0780551433563232, 7.977999687194824, 1.7630902528762817, 1.7630902528762817);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_5);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_6 = g.getTransform();
g.transform(new AffineTransform(0.9697195887565613f, -0.24422112107276917f, 0.2185806781053543f, 0.9758188724517822f, 0.0f, 0.0f));
// _0_0_6
shape = new RoundRectangle2D.Double(134.47923278808594, -140.04771423339844, 2.0455572605133057, 10.324569702148438, 2.0455572605133057, 2.2816684246063232);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_6);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_7 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
paint = new Color(0, 255, 255, 255);
stroke = new BasicStroke(1.0f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(108.12854, -134.09512);
((GeneralPath)shape).curveTo(108.12854, -134.09512, 113.16616, -125.33406, 113.16616, -122.92476);
((GeneralPath)shape).curveTo(113.16616, -120.51547, 113.82324, -112.6305, 113.82324, -112.6305);
((GeneralPath)shape).curveTo(116.63199, -112.29125, 122.4706, -112.20422, 125.887, -112.6305);
((GeneralPath)shape).curveTo(125.887, -112.6305, 126.54408, -120.51547, 126.54408, -122.92476);
((GeneralPath)shape).curveTo(126.54408, -125.33406, 131.5817, -134.09512, 131.5817, -134.09512);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_7);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_8 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8
shape = new GeneralPath();
((GeneralPath)shape).moveTo(143.79387, -164.69688);
((GeneralPath)shape).curveTo(143.79387, -164.69688, 143.60056, -161.79881, 141.73137, -159.16563);
((GeneralPath)shape).curveTo(142.4981, -153.15137, 142.17763, -149.77461, 140.63762, -145.69688);
((GeneralPath)shape).curveTo(136.8896, -140.23515, 133.61696, -132.68115, 127.98137, -137.75938);
((GeneralPath)shape).curveTo(124.2054, -146.57005, 131.7107, -148.73569, 136.10637, -149.75938);
((GeneralPath)shape).curveTo(137.16943, -152.94046, 139.16457, -155.33133, 140.07512, -158.63438);
((GeneralPath)shape).curveTo(140.2863, -158.89388, 140.42563, -159.08382, 140.54387, -159.25938);
((GeneralPath)shape).lineTo(137.95012, -160.32188);
((GeneralPath)shape).lineTo(137.76262, -164.29063);
((GeneralPath)shape).lineTo(143.79387, -164.69688);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_8);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_9 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9
shape = new GeneralPath();
((GeneralPath)shape).moveTo(134.56552, -164.1731);
((GeneralPath)shape).lineTo(144.65862, -161.63118);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(1.172419f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(134.56552, -164.1731);
((GeneralPath)shape).lineTo(144.65862, -161.63118);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_9);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_10 = g.getTransform();
g.transform(new AffineTransform(0.9697195887565613f, 0.24422112107276917f, -0.2185806781053543f, 0.9758188724517822f, 0.0f, 0.0f));
// _0_0_10
shape = new RoundRectangle2D.Double(108.47386932373047, -196.121337890625, 2.0780551433563232, 7.977999687194824, 1.7630902528762817, 1.7630902528762817);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_10);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_11 = g.getTransform();
g.transform(new AffineTransform(0.9697195887565613f, 0.24422112107276917f, -0.2185806781053543f, 0.9758188724517822f, 0.0f, 0.0f));
// _0_0_11
shape = new RoundRectangle2D.Double(106.13497161865234, -197.29461669921875, 2.0455572605133057, 10.324569702148438, 2.0455572605133057, 2.2816684246063232);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_11);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_12 = g.getTransform();
g.transform(new AffineTransform(-0.9697195887565613f, -0.24422112107276917f, -0.2185806781053543f, 0.9758188724517822f, 0.0f, 0.0f));
// _0_0_12
shape = new RoundRectangle2D.Double(-95.33615112304688, -196.121337890625, 2.0780551433563232, 7.977999687194824, 1.7630902528762817, 1.7630902528762817);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_12);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_13 = g.getTransform();
g.transform(new AffineTransform(-0.9697195887565613f, -0.24422112107276917f, -0.2185806781053543f, 0.9758188724517822f, 0.0f, 0.0f));
// _0_0_13
shape = new RoundRectangle2D.Double(-97.67504119873047, -197.29461669921875, 2.0455572605133057, 10.324569702148438, 2.0455572605133057, 2.2816684246063232);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_13);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_14 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_14
shape = new GeneralPath();
((GeneralPath)shape).moveTo(123.24148, -160.63097);
((GeneralPath)shape).curveTo(124.54241, -165.73212, 128.79971, -166.82722, 129.23708, -166.10406);
((GeneralPath)shape).curveTo(130.65114, -163.76604, 126.96293, -163.49149, 126.23928, -163.76604);
((GeneralPath)shape).curveTo(124.90067, -164.2739, 123.29253, -160.42577, 123.29804, -160.41841);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(0.6158532f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(123.24148, -160.63097);
((GeneralPath)shape).curveTo(124.54241, -165.73212, 128.79971, -166.82722, 129.23708, -166.10406);
((GeneralPath)shape).curveTo(130.65114, -163.76604, 126.96293, -163.49149, 126.23928, -163.76604);
((GeneralPath)shape).curveTo(124.90067, -164.2739, 123.29253, -160.42577, 123.29804, -160.41841);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_14);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_15 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15
shape = new GeneralPath();
((GeneralPath)shape).moveTo(120.36819, -161.98245);
((GeneralPath)shape).curveTo(119.90735, -165.74084, 122.14137, -167.63336, 122.57136, -167.27026);
((GeneralPath)shape).curveTo(123.96154, -166.09631, 121.86443, -164.90657, 121.37417, -164.89224);
((GeneralPath)shape).curveTo(120.46729, -164.86574, 120.44736, -161.8595, 120.45235, -161.8561);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(0.41621017f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(120.36819, -161.98245);
((GeneralPath)shape).curveTo(119.90735, -165.74084, 122.14137, -167.63336, 122.57136, -167.27026);
((GeneralPath)shape).curveTo(123.96154, -166.09631, 121.86443, -164.90657, 121.37417, -164.89224);
((GeneralPath)shape).curveTo(120.46729, -164.86574, 120.44736, -161.8595, 120.45235, -161.8561);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_15);
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

