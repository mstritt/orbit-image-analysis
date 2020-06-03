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
public class cellClassMarker implements ResizableIcon {
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
shape = new Ellipse2D.Double(70.71428680419922, 378.0765380859375, 243.57142639160156, 318.5714416503906);
paint = new Color(255, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 232, 0, 255);
stroke = new BasicStroke(50.0f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(70.71428680419922, 378.0765380859375, 243.57142639160156, 318.5714416503906);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
shape = new Ellipse2D.Double(378.21429443359375, 410.2193603515625, 243.57142639160156, 318.5714416503906);
paint = new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 255, 17, 255),new Color(255, 42, 42, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(2.0658254623413086f, 0.05247342959046364f, -0.060845449566841125f, 2.395427703857422f, -6.313918113708496f, -947.017333984375f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 232, 0, 255);
stroke = new BasicStroke(50.0f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(378.21429443359375, 410.2193603515625, 243.57142639160156, 318.5714416503906);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
shape = new Ellipse2D.Double(275.0675048828125, 716.3582763671875, 159.86502075195312, 220.57931518554688);
paint = new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 255, 17, 255),new Color(255, 42, 42, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.3558783531188965f, 0.03633268177509308f, -0.039935141801834106f, 1.658597469329834f, 22.68729591369629f, -223.39434814453125f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 232, 0, 255);
stroke = new BasicStroke(33.706413f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(275.0675048828125, 716.3582763671875, 159.86502075195312, 220.57931518554688);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3
shape = new Ellipse2D.Double(506.4156799316406, 752.7064208984375, 180.0258026123047, 265.7401123046875);
paint = new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 255, 17, 255),new Color(255, 42, 42, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.5268698930740356f, 0.04377133026719093f, -0.04497141018509865f, 1.9981740713119507f, 222.2074737548828f, -379.44842529296875f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 232, 0, 255);
stroke = new BasicStroke(39.259914f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(506.4156799316406, 752.7064208984375, 180.0258026123047, 265.7401123046875);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
shape = new Ellipse2D.Double(136.5498809814453, 882.1263427734375, 143.328857421875, 154.0431671142578);
paint = new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 255, 17, 255),new Color(255, 42, 42, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.215628743171692f, 0.025373190641403198f, -0.03580432012677193f, 1.158293604850769f, -89.724609375f, 225.8433074951172f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 232, 0, 255);
stroke = new BasicStroke(26.671133f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(136.5498809814453, 882.1263427734375, 143.328857421875, 154.0431671142578);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5
shape = new Ellipse2D.Double(30.60478973388672, 724.0383911132812, 133.07611083984375, 160.21897888183594);
paint = new RadialGradientPaint(new Point2D.Double(261.6165771484375, 631.5341796875), 146.7857f, new Point2D.Double(261.6165771484375, 631.5341796875), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 255, 17, 255),new Color(255, 42, 42, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.1286710500717163f, 0.026390440762043f, -0.03324313089251518f, 1.2047313451766968f, -179.48353576660156f, 41.44404602050781f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 232, 0, 255);
stroke = new BasicStroke(26.209602f,0,0,4.0f,null,0.0f);
shape = new Ellipse2D.Double(30.60478973388672, 724.0383911132812, 133.07611083984375, 160.21897888183594);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(91.45387f, 752.9883f);
generalPath.lineTo(166.17111f, 846.64734f);
generalPath.lineTo(184.85052f, 900.45154f);
generalPath.lineTo(217.5394f, 928.3498f);
generalPath.lineTo(212.86958f, 970.19745f);
generalPath.lineTo(423.0119f, 966.212f);
generalPath.lineTo(425.34692f, 920.37885f);
generalPath.lineTo(455.70078f, 908.4223f);
generalPath.lineTo(453.366f, 858.6039f);
generalPath.lineTo(476.715f, 840.669f);
generalPath.lineTo(486.05472f, 715.1262f);
generalPath.lineTo(413.6722f, 673.27856f);
generalPath.lineTo(378.64847f, 651.3582f);
generalPath.lineTo(334.2851f, 651.3582f);
generalPath.lineTo(303.93124f, 633.4236f);
generalPath.lineTo(254.89796f, 625.4526f);
generalPath.lineTo(250.22816f, 543.7501f);
generalPath.lineTo(233.88382f, 527.8081f);
generalPath.lineTo(201.19489f, 527.8081f);
generalPath.lineTo(184.85057f, 549.7282f);
generalPath.lineTo(182.51578f, 737.0464f);
generalPath.lineTo(161.50134f, 739.03906f);
generalPath.lineTo(133.48251f, 713.1334f);
generalPath.lineTo(96.12375f, 715.12634f);
generalPath.lineTo(91.453926f, 752.98846f);
generalPath.closePath();
shape = generalPath;
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
        return 18.666654586791992;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 10.000814437866211;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 734.4762573242188;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 742.8571166992188;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private cellClassMarker() {
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
       cellClassMarker base = new cellClassMarker();
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
       cellClassMarker base = new cellClassMarker();
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
        return cellClassMarker::new;
    }
}

