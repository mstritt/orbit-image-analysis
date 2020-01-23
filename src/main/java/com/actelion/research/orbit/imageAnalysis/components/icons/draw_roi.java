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
public class draw_roi implements ResizableIcon {
    

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
g.transform(new AffineTransform(1.0666667222976685f, 0.0f, 0.0f, 1.0666667222976685f, -0.0f, -0.0f));
// _0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, -343.7007751464844f));
// _0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0
paint = new Color(255, 255, 0, 255);
stroke = new BasicStroke(55.323944f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(389.36908, 378.59903);
((GeneralPath)shape).curveTo(342.05927, 379.01486, 294.78314, 383.2077, 248.1386, 391.12454);
((GeneralPath)shape).curveTo(223.51381, 395.30402, 198.66672, 400.6619, 176.69513, 412.5403);
((GeneralPath)shape).curveTo(165.70934, 418.47952, 155.53157, 426.03955, 147.21364, 435.35483);
((GeneralPath)shape).curveTo(138.89569, 444.67007, 132.47147, 455.7775, 129.24968, 467.84323);
((GeneralPath)shape).curveTo(125.37266, 482.36288, 126.23848, 497.95206, 130.6291, 512.3247);
((GeneralPath)shape).curveTo(135.01973, 526.6974, 142.8345, 539.89, 152.46996, 551.42303);
((GeneralPath)shape).curveTo(171.74084, 574.489, 197.77066, 590.7103, 223.40332, 606.40656);
((GeneralPath)shape).curveTo(258.06274, 627.6304, 293.99103, 649.6921, 316.5381, 683.5056);
((GeneralPath)shape).curveTo(327.8116, 700.41235, 335.36002, 720.1194, 336.1088, 740.4263);
((GeneralPath)shape).curveTo(336.85757, 760.73315, 330.423, 781.59674, 316.75903, 796.6376);
((GeneralPath)shape).curveTo(302.86823, 811.9281, 282.56946, 820.2744, 262.10617, 823.10455);
((GeneralPath)shape).curveTo(241.64288, 825.9347, 220.82916, 823.70386, 200.40036, 820.63477);
((GeneralPath)shape).curveTo(179.97156, 817.5657, 159.5823, 813.6517, 138.9314, 813.10803);
((GeneralPath)shape).curveTo(118.28047, 812.56433, 97.052315, 815.5934, 78.98116, 825.6028);
((GeneralPath)shape).curveTo(60.653214, 835.75446, 46.441654, 852.88184, 39.16655, 872.5298);
((GeneralPath)shape).curveTo(31.891447, 892.1778, 31.474049, 914.1758, 37.30143, 934.3007);
((GeneralPath)shape).curveTo(43.128815, 954.42566, 55.076176, 972.6302, 70.73965, 986.54517);
((GeneralPath)shape).curveTo(86.40312, 1000.46014, 105.69519, 1010.1187, 126.058, 1015.0509);
((GeneralPath)shape).curveTo(148.88968, 1020.5811, 172.85915, 1020.2374, 196.05508, 1016.5202);
((GeneralPath)shape).curveTo(219.25102, 1012.803, 241.78801, 1005.7849, 263.97064, 998.0518);
((GeneralPath)shape).curveTo(308.33594, 982.58575, 352.77716, 963.9379, 399.74188, 962.60034);
((GeneralPath)shape).curveTo(446.56314, 961.26685, 492.14114, 977.30054, 538.84644, 980.8539);
((GeneralPath)shape).curveTo(562.1991, 982.63055, 586.1518, 981.1856, 608.13525, 973.10913);
((GeneralPath)shape).curveTo(630.1187, 965.03265, 650.0409, 949.8128, 660.6592, 928.93805);
((GeneralPath)shape).curveTo(668.8794, 912.7778, 671.1782, 893.9213, 668.51184, 875.9876);
((GeneralPath)shape).curveTo(665.8455, 858.0539, 658.38416, 841.0239, 648.20917, 826.01733);
((GeneralPath)shape).curveTo(627.85925, 796.0042, 597.47, 774.4857, 567.3034, 754.3639);
((GeneralPath)shape).curveTo(546.18494, 740.27734, 524.39935, 726.1392, 508.98135, 705.9723);
((GeneralPath)shape).curveTo(501.27237, 695.8888, 495.28778, 684.3468, 492.5694, 671.9486);
((GeneralPath)shape).curveTo(489.85098, 659.5504, 490.52097, 646.26794, 495.4913, 634.58887);
((GeneralPath)shape).curveTo(502.098, 619.06476, 515.71466, 607.4512, 530.5646, 599.44336);
((GeneralPath)shape).curveTo(545.4145, 591.43555, 561.69366, 586.5325, 577.4992, 580.6307);
((GeneralPath)shape).curveTo(593.30475, 574.72894, 609.04944, 567.57587, 621.3147, 555.99097);
((GeneralPath)shape).curveTo(627.4473, 550.19855, 632.62994, 543.3265, 636.01495, 535.59973);
((GeneralPath)shape).curveTo(639.39996, 527.8729, 640.94244, 519.27234, 639.91345, 510.8996);
((GeneralPath)shape).curveTo(638.9966, 503.43964, 636.06335, 496.29407, 631.87115, 490.0557);
((GeneralPath)shape).curveTo(627.67896, 483.81732, 622.2516, 478.4635, 616.2416, 473.94995);
((GeneralPath)shape).curveTo(604.2216, 464.92285, 590.0539, 459.29358, 576.08044, 453.75198);
((GeneralPath)shape).curveTo(513.71576, 429.0194, 451.4775, 403.96796, 389.36896, 378.599);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_0);
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

