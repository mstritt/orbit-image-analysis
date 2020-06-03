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
public class system_help_3 implements ResizableIcon {
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
g.transform(new AffineTransform(0.9208633303642273f, 0.0f, 0.0f, 0.9208633303642273f, -0.0f, -0.0f));
// _0
g.setComposite(AlphaComposite.getInstance(3, 0.7f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0859375f, 0.0f, 0.0f, 1.0859375f, -3.9093732833862305f, -8.25312328338623f));
// _0_0
shape = new Ellipse2D.Double(11.599998474121094, 11.599998474121094, 116.0, 116.0);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.6f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -0.09999847412109375f, 1.9102535247802734f));
// _0_1
shape = new Ellipse2D.Double(11.599998474121094, 111.5999984741211, 116.0, 21.145999908447266);
paint = new RadialGradientPaint(new Point2D.Double(69.60009765625, 69.57669830322266), 58.0f, new Point2D.Double(69.60009765625, 69.57669830322266), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, -0.18230000138282776f, 0.0f, 134.85659790039062f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0859375f, 0.0f, 0.0f, 1.0859375f, -3.9093732833862305f, -8.25312328338623f));
// _0_2
shape = new Ellipse2D.Double(11.599998474121094, 11.599998474121094, 116.0, 116.0);
paint = new RadialGradientPaint(new Point2D.Double(69.60009765625, 69.60009765625), 58.0f, new Point2D.Double(69.60009765625, 69.60009765625), new float[] {0.6154f,0.8225f,1.0f}, new Color[] {new Color(238, 238, 238, 255),new Color(221, 221, 221, 255),new Color(255, 255, 255, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(26.062502f, 67.328125f);
generalPath.curveTo(26.062502f, 92.477356f, 46.52265f, 112.9375f, 71.671875f, 112.9375f);
generalPath.curveTo(96.821106f, 112.9375f, 117.28125f, 92.477356f, 117.28125f, 67.328125f);
generalPath.curveTo(117.28125f, 42.1789f, 96.821106f, 21.718754f, 71.671875f, 21.718754f);
generalPath.curveTo(46.52265f, 21.718754f, 26.062502f, 42.1789f, 26.062502f, 67.328125f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(27.600099563598633, 69.60009765625), new Point2D.Double(111.60009765625, 69.60009765625), new float[] {0.0f,1.0f}, new Color[] {new Color(42, 148, 236, 255),new Color(0, 87, 174, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0859375f, 0.0f, 0.0f, 1.0859375f, -3.9093732833862305f, -8.25312328338623f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.3f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0859375f, 0.0f, 0.0f, 1.0859375f, -3.9093732833862305f, -8.25312328338623f));
// _0_4
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_4_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(77.041f, 104.759f);
generalPath.curveTo(63.767f, 106.115f, 50.122f, 103.11f, 46.565f, 98.042f);
generalPath.curveTo(43.007f, 92.976f, 50.885f, 87.768f, 64.16f, 86.41f);
generalPath.curveTo(77.434f, 85.054f, 91.079f, 88.058f, 94.637f, 93.126f);
generalPath.curveTo(98.193f, 98.194f, 90.315f, 103.401f, 77.041f, 104.759f);
generalPath.closePath();
shape = generalPath;
paint = new Color(168, 221, 224, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.8f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(71.671875f, 24.06655f);
generalPath.curveTo(50.28868f, 24.06655f, 32.41958f, 38.77123f, 28.113838f, 58.349598f);
generalPath.curveTo(36.698174f, 66.14228f, 52.986153f, 54.358776f, 71.671875f, 54.358776f);
generalPath.curveTo(90.357605f, 54.358776f, 106.64666f, 66.14228f, 115.22991f, 58.349598f);
generalPath.curveTo(110.92417f, 38.77123f, 93.05616f, 24.06655f, 71.671875f, 24.06655f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(135.5601043701172, 417.66461181640625), new Point2D.Double(161.87620544433594, 417.66461181640625), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.0f, 1.7280522584915161f, 1.7280522584915161f, 0.0f, -650.0747680664062f, -218.71693420410156f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0859375f, 0.0f, 0.0f, 1.0859375f, -3.9093732833862305f, -8.25312328338623f));
// _0_6
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_6_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_6_0_0
paint = new Color(0, 49, 110, 255);
stroke = new BasicStroke(2.0f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(27.6f, 69.6f);
generalPath.curveTo(27.6f, 92.759f, 46.441f, 111.6f, 69.6f, 111.6f);
generalPath.curveTo(92.759f, 111.6f, 111.6f, 92.759f, 111.6f, 69.6f);
generalPath.curveTo(111.6f, 46.441f, 92.759f, 27.6f, 69.6f, 27.6f);
generalPath.curveTo(46.441f, 27.6f, 27.6f, 46.441f, 27.6f, 69.6f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0859375f, 0.0f, 0.0f, 1.111379623413086f, -3.2013421058654785f, -9.31772232055664f));
// _0_7
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_7_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(63.37f, 80.089f);
generalPath.lineTo(63.192f, 77.746f);
generalPath.curveTo(63.012f, 73.148f, 64.44f, 68.462f, 68.451f, 63.684f);
generalPath.curveTo(71.304f, 60.26f, 73.62f, 57.286f, 73.62f, 54.221f);
generalPath.curveTo(73.62f, 51.157f, 71.571f, 48.994f, 67.202f, 48.903f);
generalPath.curveTo(64.173f, 48.903f, 60.696f, 49.895f, 58.289f, 51.517f);
generalPath.lineTo(55.348f, 41.784f);
generalPath.curveTo(58.556f, 39.89f, 63.815f, 38.088f, 70.233f, 38.088f);
generalPath.curveTo(81.91f, 38.088f, 87.348f, 44.668f, 87.348f, 52.058f);
generalPath.curveTo(87.348f, 58.997f, 83.069f, 63.415f, 79.681f, 67.289f);
generalPath.curveTo(76.472f, 70.894f, 75.046f, 74.41f, 75.135f, 78.466f);
generalPath.lineTo(75.135f, 80.088f);
generalPath.lineTo(63.37f, 80.088f);
generalPath.lineTo(63.37f, 80.089f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 49, 110, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_7_1
shape = new Ellipse2D.Double(61.599998474121094, 85.5999984741211, 16.0, 16.0);
paint = new Color(0, 49, 110, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0859375f, 0.0f, 0.0f, 1.0859375f, -3.2013421058654785f, -8.25312328338623f));
// _0_8
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_8_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(63.37f, 80.089f);
generalPath.lineTo(63.192f, 77.746f);
generalPath.curveTo(63.012f, 73.148f, 64.44f, 68.462f, 68.451f, 63.684f);
generalPath.curveTo(71.304f, 60.26f, 73.62f, 57.286f, 73.62f, 54.221f);
generalPath.curveTo(73.62f, 51.157f, 71.571f, 48.994f, 67.202f, 48.903f);
generalPath.curveTo(64.173f, 48.903f, 60.696f, 49.895f, 58.289f, 51.517f);
generalPath.lineTo(55.348f, 41.784f);
generalPath.curveTo(58.556f, 39.89f, 63.815f, 38.088f, 70.233f, 38.088f);
generalPath.curveTo(81.91f, 38.088f, 87.348f, 44.668f, 87.348f, 52.058f);
generalPath.curveTo(87.348f, 58.997f, 83.069f, 63.415f, 79.681f, 67.289f);
generalPath.curveTo(76.472f, 70.894f, 75.046f, 74.41f, 75.135f, 78.466f);
generalPath.lineTo(75.135f, 80.088f);
generalPath.lineTo(63.37f, 80.088f);
generalPath.lineTo(63.37f, 80.089f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_8_1
shape = new Ellipse2D.Double(61.599998474121094, 85.5999984741211, 16.0, 16.0);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
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

