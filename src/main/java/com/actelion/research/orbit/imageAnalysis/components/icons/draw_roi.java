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
public class draw_roi implements ResizableIcon {
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
paint = new Color(255, 255, 0, 255);
stroke = new BasicStroke(55.323944f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(389.36908f, 378.59903f);
generalPath.curveTo(342.05927f, 379.01486f, 294.78314f, 383.2077f, 248.1386f, 391.12454f);
generalPath.curveTo(223.51381f, 395.30402f, 198.66672f, 400.6619f, 176.69513f, 412.5403f);
generalPath.curveTo(165.70934f, 418.47952f, 155.53157f, 426.03955f, 147.21364f, 435.35483f);
generalPath.curveTo(138.89569f, 444.67007f, 132.47147f, 455.7775f, 129.24968f, 467.84323f);
generalPath.curveTo(125.37266f, 482.36288f, 126.23848f, 497.95206f, 130.6291f, 512.3247f);
generalPath.curveTo(135.01973f, 526.6974f, 142.8345f, 539.89f, 152.46996f, 551.42303f);
generalPath.curveTo(171.74084f, 574.489f, 197.77066f, 590.7103f, 223.40332f, 606.40656f);
generalPath.curveTo(258.06274f, 627.6304f, 293.99103f, 649.6921f, 316.5381f, 683.5056f);
generalPath.curveTo(327.8116f, 700.41235f, 335.36002f, 720.1194f, 336.1088f, 740.4263f);
generalPath.curveTo(336.85757f, 760.73315f, 330.423f, 781.59674f, 316.75903f, 796.6376f);
generalPath.curveTo(302.86823f, 811.9281f, 282.56946f, 820.2744f, 262.10617f, 823.10455f);
generalPath.curveTo(241.64288f, 825.9347f, 220.82916f, 823.70386f, 200.40036f, 820.63477f);
generalPath.curveTo(179.97156f, 817.5657f, 159.5823f, 813.6517f, 138.9314f, 813.10803f);
generalPath.curveTo(118.28047f, 812.56433f, 97.052315f, 815.5934f, 78.98116f, 825.6028f);
generalPath.curveTo(60.653214f, 835.75446f, 46.441654f, 852.88184f, 39.16655f, 872.5298f);
generalPath.curveTo(31.891447f, 892.1778f, 31.474049f, 914.1758f, 37.30143f, 934.3007f);
generalPath.curveTo(43.128815f, 954.42566f, 55.076176f, 972.6302f, 70.73965f, 986.54517f);
generalPath.curveTo(86.40312f, 1000.46014f, 105.69519f, 1010.1187f, 126.058f, 1015.0509f);
generalPath.curveTo(148.88968f, 1020.5811f, 172.85915f, 1020.2374f, 196.05508f, 1016.5202f);
generalPath.curveTo(219.25102f, 1012.803f, 241.78801f, 1005.7849f, 263.97064f, 998.0518f);
generalPath.curveTo(308.33594f, 982.58575f, 352.77716f, 963.9379f, 399.74188f, 962.60034f);
generalPath.curveTo(446.56314f, 961.26685f, 492.14114f, 977.30054f, 538.84644f, 980.8539f);
generalPath.curveTo(562.1991f, 982.63055f, 586.1518f, 981.1856f, 608.13525f, 973.10913f);
generalPath.curveTo(630.1187f, 965.03265f, 650.0409f, 949.8128f, 660.6592f, 928.93805f);
generalPath.curveTo(668.8794f, 912.7778f, 671.1782f, 893.9213f, 668.51184f, 875.9876f);
generalPath.curveTo(665.8455f, 858.0539f, 658.38416f, 841.0239f, 648.20917f, 826.01733f);
generalPath.curveTo(627.85925f, 796.0042f, 597.47f, 774.4857f, 567.3034f, 754.3639f);
generalPath.curveTo(546.18494f, 740.27734f, 524.39935f, 726.1392f, 508.98135f, 705.9723f);
generalPath.curveTo(501.27237f, 695.8888f, 495.28778f, 684.3468f, 492.5694f, 671.9486f);
generalPath.curveTo(489.85098f, 659.5504f, 490.52097f, 646.26794f, 495.4913f, 634.58887f);
generalPath.curveTo(502.098f, 619.06476f, 515.71466f, 607.4512f, 530.5646f, 599.44336f);
generalPath.curveTo(545.4145f, 591.43555f, 561.69366f, 586.5325f, 577.4992f, 580.6307f);
generalPath.curveTo(593.30475f, 574.72894f, 609.04944f, 567.57587f, 621.3147f, 555.99097f);
generalPath.curveTo(627.4473f, 550.19855f, 632.62994f, 543.3265f, 636.01495f, 535.59973f);
generalPath.curveTo(639.39996f, 527.8729f, 640.94244f, 519.27234f, 639.91345f, 510.8996f);
generalPath.curveTo(638.9966f, 503.43964f, 636.06335f, 496.29407f, 631.87115f, 490.0557f);
generalPath.curveTo(627.67896f, 483.81732f, 622.2516f, 478.4635f, 616.2416f, 473.94995f);
generalPath.curveTo(604.2216f, 464.92285f, 590.0539f, 459.29358f, 576.08044f, 453.75198f);
generalPath.curveTo(513.71576f, 429.0194f, 451.4775f, 403.96796f, 389.36896f, 378.599f);
generalPath.closePath();
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
        return 3.5813074111938477;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 7.719841480255127;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 742.2968139648438;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 744.125;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private draw_roi() {
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
       draw_roi base = new draw_roi();
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
       draw_roi base = new draw_roi();
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
        return draw_roi::new;
    }
}

