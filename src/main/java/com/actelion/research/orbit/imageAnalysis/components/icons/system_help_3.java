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
public class system_help_3 implements ResizableIcon {
    

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
g.transform(new AffineTransform(0.9208633303642273f, 0.0f, 0.0f, 0.9208633303642273f, -0.0f, -0.0f));
// _0
g.setComposite(AlphaComposite.getInstance(3, 0.7f * origAlpha));
AffineTransform defaultTransform__0_0 = g.getTransform();
g.transform(new AffineTransform(1.0859375f, 0.0f, 0.0f, 1.0859375f, -3.9093732833862305f, -8.25312328338623f));
// _0_0
shape = new Ellipse2D.Double(11.599998474121094, 11.599998474121094, 116.0, 116.0);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0);
g.setComposite(AlphaComposite.getInstance(3, 0.6f * origAlpha));
AffineTransform defaultTransform__0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -0.09999847412109375f, 1.9102535247802734f));
// _0_1
shape = new Ellipse2D.Double(11.599998474121094, 111.5999984741211, 116.0, 21.145999908447266);
paint = new RadialGradientPaint(new Point2D.Double(69.60009765625, 69.57669830322266), 58.0f, new Point2D.Double(69.60009765625, 69.57669830322266), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, -0.18230000138282776f, 0.0f, 134.85659790039062f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_2 = g.getTransform();
g.transform(new AffineTransform(1.0859375f, 0.0f, 0.0f, 1.0859375f, -3.9093732833862305f, -8.25312328338623f));
// _0_2
shape = new Ellipse2D.Double(11.599998474121094, 11.599998474121094, 116.0, 116.0);
paint = new RadialGradientPaint(new Point2D.Double(69.60009765625, 69.60009765625), 58.0f, new Point2D.Double(69.60009765625, 69.60009765625), new float[] {0.6154f,0.8225f,1.0f}, new Color[] {new Color(238, 238, 238, 255),new Color(221, 221, 221, 255),new Color(255, 255, 255, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_3
shape = new GeneralPath();
((GeneralPath)shape).moveTo(26.062502, 67.328125);
((GeneralPath)shape).curveTo(26.062502, 92.477356, 46.52265, 112.9375, 71.671875, 112.9375);
((GeneralPath)shape).curveTo(96.821106, 112.9375, 117.28125, 92.477356, 117.28125, 67.328125);
((GeneralPath)shape).curveTo(117.28125, 42.1789, 96.821106, 21.718754, 71.671875, 21.718754);
((GeneralPath)shape).curveTo(46.52265, 21.718754, 26.062502, 42.1789, 26.062502, 67.328125);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(27.600099563598633, 69.60009765625), new Point2D.Double(111.60009765625, 69.60009765625), new float[] {0.0f,1.0f}, new Color[] {new Color(42, 148, 236, 255),new Color(0, 87, 174, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0859375f, 0.0f, 0.0f, 1.0859375f, -3.9093732833862305f, -8.25312328338623f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_3);
g.setComposite(AlphaComposite.getInstance(3, 0.3f * origAlpha));
AffineTransform defaultTransform__0_4 = g.getTransform();
g.transform(new AffineTransform(1.0859375f, 0.0f, 0.0f, 1.0859375f, -3.9093732833862305f, -8.25312328338623f));
// _0_4
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_4_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_4_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(77.041, 104.759);
((GeneralPath)shape).curveTo(63.767, 106.115, 50.122, 103.11, 46.565, 98.042);
((GeneralPath)shape).curveTo(43.007, 92.976, 50.885, 87.768, 64.16, 86.41);
((GeneralPath)shape).curveTo(77.434, 85.054, 91.079, 88.058, 94.637, 93.126);
((GeneralPath)shape).curveTo(98.193, 98.194, 90.315, 103.401, 77.041, 104.759);
((GeneralPath)shape).closePath();
paint = new Color(168, 221, 224, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_4_0);
g.setTransform(defaultTransform__0_4);
g.setComposite(AlphaComposite.getInstance(3, 0.8f * origAlpha));
AffineTransform defaultTransform__0_5 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_5
shape = new GeneralPath();
((GeneralPath)shape).moveTo(71.671875, 24.06655);
((GeneralPath)shape).curveTo(50.28868, 24.06655, 32.41958, 38.77123, 28.113838, 58.349598);
((GeneralPath)shape).curveTo(36.698174, 66.14228, 52.986153, 54.358776, 71.671875, 54.358776);
((GeneralPath)shape).curveTo(90.357605, 54.358776, 106.64666, 66.14228, 115.22991, 58.349598);
((GeneralPath)shape).curveTo(110.92417, 38.77123, 93.05616, 24.06655, 71.671875, 24.06655);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(135.5601043701172, 417.66461181640625), new Point2D.Double(161.87620544433594, 417.66461181640625), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.0f, 1.7280522584915161f, 1.7280522584915161f, 0.0f, -650.0747680664062f, -218.71693420410156f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_5);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_6 = g.getTransform();
g.transform(new AffineTransform(1.0859375f, 0.0f, 0.0f, 1.0859375f, -3.9093732833862305f, -8.25312328338623f));
// _0_6
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_6_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_6_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_6_0_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_6_0_0
paint = new Color(0, 49, 110, 255);
stroke = new BasicStroke(2.0f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(27.6, 69.6);
((GeneralPath)shape).curveTo(27.6, 92.759, 46.441, 111.6, 69.6, 111.6);
((GeneralPath)shape).curveTo(92.759, 111.6, 111.6, 92.759, 111.6, 69.6);
((GeneralPath)shape).curveTo(111.6, 46.441, 92.759, 27.6, 69.6, 27.6);
((GeneralPath)shape).curveTo(46.441, 27.6, 27.6, 46.441, 27.6, 69.6);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_6_0_0);
g.setTransform(defaultTransform__0_6_0);
g.setTransform(defaultTransform__0_6);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_7 = g.getTransform();
g.transform(new AffineTransform(1.0859375f, 0.0f, 0.0f, 1.111379623413086f, -3.2013421058654785f, -9.31772232055664f));
// _0_7
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_7_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_7_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(63.37, 80.089);
((GeneralPath)shape).lineTo(63.192, 77.746);
((GeneralPath)shape).curveTo(63.012, 73.148, 64.44, 68.462, 68.451, 63.684);
((GeneralPath)shape).curveTo(71.304, 60.26, 73.62, 57.286, 73.62, 54.221);
((GeneralPath)shape).curveTo(73.62, 51.157, 71.571, 48.994, 67.202, 48.903);
((GeneralPath)shape).curveTo(64.173, 48.903, 60.696, 49.895, 58.289, 51.517);
((GeneralPath)shape).lineTo(55.348, 41.784);
((GeneralPath)shape).curveTo(58.556, 39.89, 63.815, 38.088, 70.233, 38.088);
((GeneralPath)shape).curveTo(81.91, 38.088, 87.348, 44.668, 87.348, 52.058);
((GeneralPath)shape).curveTo(87.348, 58.997, 83.069, 63.415, 79.681, 67.289);
((GeneralPath)shape).curveTo(76.472, 70.894, 75.046, 74.41, 75.135, 78.466);
((GeneralPath)shape).lineTo(75.135, 80.088);
((GeneralPath)shape).lineTo(63.37, 80.088);
((GeneralPath)shape).lineTo(63.37, 80.089);
((GeneralPath)shape).closePath();
paint = new Color(0, 49, 110, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_7_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_7_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_7_1
shape = new Ellipse2D.Double(61.599998474121094, 85.5999984741211, 16.0, 16.0);
paint = new Color(0, 49, 110, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_7_1);
g.setTransform(defaultTransform__0_7);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_8 = g.getTransform();
g.transform(new AffineTransform(1.0859375f, 0.0f, 0.0f, 1.0859375f, -3.2013421058654785f, -8.25312328338623f));
// _0_8
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_8_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_8_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(63.37, 80.089);
((GeneralPath)shape).lineTo(63.192, 77.746);
((GeneralPath)shape).curveTo(63.012, 73.148, 64.44, 68.462, 68.451, 63.684);
((GeneralPath)shape).curveTo(71.304, 60.26, 73.62, 57.286, 73.62, 54.221);
((GeneralPath)shape).curveTo(73.62, 51.157, 71.571, 48.994, 67.202, 48.903);
((GeneralPath)shape).curveTo(64.173, 48.903, 60.696, 49.895, 58.289, 51.517);
((GeneralPath)shape).lineTo(55.348, 41.784);
((GeneralPath)shape).curveTo(58.556, 39.89, 63.815, 38.088, 70.233, 38.088);
((GeneralPath)shape).curveTo(81.91, 38.088, 87.348, 44.668, 87.348, 52.058);
((GeneralPath)shape).curveTo(87.348, 58.997, 83.069, 63.415, 79.681, 67.289);
((GeneralPath)shape).curveTo(76.472, 70.894, 75.046, 74.41, 75.135, 78.466);
((GeneralPath)shape).lineTo(75.135, 80.088);
((GeneralPath)shape).lineTo(63.37, 80.088);
((GeneralPath)shape).lineTo(63.37, 80.089);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_8_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_8_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_8_1
shape = new Ellipse2D.Double(61.599998474121094, 85.5999984741211, 16.0, 16.0);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_8_1);
g.setTransform(defaultTransform__0_8);
g.setTransform(defaultTransform__0);
g.setTransform(defaultTransform_);

	}

    /**
     * Returns the X of the bounding box of the original SVG image.
     * 
     * @return The X of the bounding box of the original SVG image.
     */
    public static double getOrigX() {
        return -3.6000001430511475;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return -7.600000381469727;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 139.20001220703125;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 139.20001220703125;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private system_help_3() {
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
       system_help_3 base = new system_help_3();
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
       system_help_3 base = new system_help_3();
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
        return system_help_3::new;
    }
}

