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
public class grid implements ResizableIcon {
    

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
shape = new Ellipse2D.Double(294.66131591796875, 412.35736083984375, 143.328857421875, 154.0431671142578);
paint = new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 255, 17, 255),new Color(255, 42, 42, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.215628743171692f, 0.025373190641403198f, -0.03580432012677193f, 1.158293604850769f, 68.38680267333984f, -243.92572021484375f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 232, 0, 255);
stroke = new BasicStroke(26.671133f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(294.66131591796875, 412.35736083984375, 143.328857421875, 154.0431671142578);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
shape = new Ellipse2D.Double(42.49726104736328, 377.1440124511719, 133.07611083984375, 160.21897888183594);
paint = new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 255, 17, 255),new Color(255, 42, 42, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.1286710500717163f, 0.026390440762043f, -0.03324313089251518f, 1.2047313451766968f, -167.591064453125f, -305.4503479003906f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 232, 0, 255);
stroke = new BasicStroke(26.209602f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(42.49726104736328, 377.1440124511719, 133.07611083984375, 160.21897888183594);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
shape = new Ellipse2D.Double(524.4633178710938, 410.8026123046875, 143.32887268066406, 154.0431671142578);
paint = new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 255, 17, 255),new Color(255, 42, 42, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.215628743171692f, 0.025373190641403198f, -0.03580432012677193f, 1.158293604850769f, 298.1887512207031f, -245.4805145263672f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 232, 0, 255);
stroke = new BasicStroke(26.671133f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(524.4633178710938, 410.8026123046875, 143.32887268066406, 154.0431671142578);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3
shape = new Ellipse2D.Double(293.1766052246094, 647.1847534179688, 133.07611083984375, 160.21897888183594);
paint = new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 255, 17, 255),new Color(255, 42, 42, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.1286710500717163f, 0.026390440762043f, -0.03324313089251518f, 1.2047314643859863f, 83.0882797241211f, -35.409610748291016f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 232, 0, 255);
stroke = new BasicStroke(26.209602f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(293.1766052246094, 647.1847534179688, 133.07611083984375, 160.21897888183594);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_3);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
shape = new Ellipse2D.Double(503.7065124511719, 867.0897216796875, 133.07611083984375, 160.21897888183594);
paint = new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 255, 17, 255),new Color(255, 42, 42, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.1286710500717163f, 0.026390440762043f, -0.03324313089251518f, 1.2047314643859863f, 293.6181640625f, 184.4952850341797f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 232, 0, 255);
stroke = new BasicStroke(26.209602f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(503.7065124511719, 867.0897216796875, 133.07611083984375, 160.21897888183594);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_4);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_5 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5
shape = new Ellipse2D.Double(522.4564208984375, 632.91845703125, 133.07611083984375, 160.21897888183594);
paint = new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 255, 17, 255),new Color(255, 42, 42, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.1286710500717163f, 0.026390440762043f, -0.03324313089251518f, 1.2047314643859863f, 312.3681640625f, -49.67591857910156f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 232, 0, 255);
stroke = new BasicStroke(26.209602f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(522.4564208984375, 632.91845703125, 133.07611083984375, 160.21897888183594);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_5);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_6 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6
shape = new Ellipse2D.Double(28.199691772460938, 640.0823974609375, 143.32887268066406, 154.0431671142578);
paint = new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 255, 17, 255),new Color(255, 42, 42, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.2156288623809814f, 0.025373190641403198f, -0.03580432012677193f, 1.158293604850769f, -198.07485961914062f, -16.20067024230957f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 232, 0, 255);
stroke = new BasicStroke(26.671133f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(28.199691772460938, 640.0823974609375, 143.32887268066406, 154.0431671142578);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_6);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_7 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
shape = new Ellipse2D.Double(242.19427490234375, 868.3025512695312, 143.32887268066406, 154.0431671142578);
paint = new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 255, 17, 255),new Color(255, 42, 42, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.2156288623809814f, 0.025373190641403198f, -0.03580432012677193f, 1.158293604850769f, 15.919705390930176f, 212.01943969726562f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 232, 0, 255);
stroke = new BasicStroke(26.671133f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(242.19427490234375, 868.3025512695312, 143.32887268066406, 154.0431671142578);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_7);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_8 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8
shape = new Ellipse2D.Double(30.23773193359375, 875.4765014648438, 143.32887268066406, 154.0431671142578);
paint = new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 255, 17, 255),new Color(255, 42, 42, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.2156288623809814f, 0.025373190641403198f, -0.03580432012677193f, 1.158293604850769f, -196.03680419921875f, 219.19334411621094f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 232, 0, 255);
stroke = new BasicStroke(26.671133f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(30.23773193359375, 875.4765014648438, 143.32887268066406, 154.0431671142578);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_8);
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
        return 15.85506820678711;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 21.694337844848633;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 710.6812133789062;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 724.0704956054688;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private grid() {
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
       grid base = new grid();
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
       grid base = new grid();
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
        return grid::new;
    }
}

