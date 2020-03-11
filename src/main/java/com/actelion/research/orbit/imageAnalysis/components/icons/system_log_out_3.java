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
public class system_log_out_3 implements ResizableIcon {
    

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
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0
shape = new RoundRectangle2D.Double(1.4809070825576782, 2.5692098140716553, 31.99555015563965, 41.9420280456543, 1.4142104387283325, 1.4142096042633057);
paint = new Color(238, 238, 236, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(85, 87, 83, 255);
stroke = new BasicStroke(1.0000005f,0,0,10.0f,null,0.0f);
shape = new RoundRectangle2D.Double(1.4809070825576782, 2.5692098140716553, 31.99555015563965, 41.9420280456543, 1.4142104387283325, 1.4142096042633057);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
shape = new Rectangle2D.Double(1.9791847467422485, 17.24085235595703, 30.999998092651367, 26.75914764404297);
paint = new LinearGradientPaint(new Point2D.Double(18.729185104370117, 44.0), new Point2D.Double(18.729185104370117, 29.06801414489746), new float[] {0.0f,1.0f}, new Color[] {new Color(186, 189, 182, 255),new Color(186, 189, 182, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1);
g.setComposite(AlphaComposite.getInstance(3, 0.5542857f * origAlpha));
AffineTransform defaultTransform__0_0_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(2.1041846, 43.875);
((GeneralPath)shape).lineTo(23.479185, 35.0);
((GeneralPath)shape).curveTo(23.479185, 35.0, 26.992725, 32.780415, 23.729185, 31.5);
((GeneralPath)shape).curveTo(20.314184, 30.16016, 16.729185, 32.0, 16.729185, 32.0);
((GeneralPath)shape).lineTo(2.1041846, 43.875);
((GeneralPath)shape).closePath();
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3
shape = new GeneralPath();
((GeneralPath)shape).moveTo(2.0168467, 43.94486);
((GeneralPath)shape).lineTo(1.9780138, 3.0545251);
((GeneralPath)shape).lineTo(21.92031, 3.0987194);
((GeneralPath)shape).lineTo(21.964504, 33.018173);
((GeneralPath)shape).lineTo(2.0168467, 43.94486);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(46.8458251953125, 19.80411720275879), new Point2D.Double(18.031221389770508, 27.759069442749023), new float[] {0.0f,1.0f}, new Color[] {new Color(78, 78, 78, 255),new Color(171, 171, 171, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -12.020814895629883f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_3);
g.setComposite(AlphaComposite.getInstance(3, 0.42222223f * origAlpha));
AffineTransform defaultTransform__0_0_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
shape = new GeneralPath();
((GeneralPath)shape).moveTo(1.9489857, 43.94486);
((GeneralPath)shape).lineTo(22.097088, 33.06237);
((GeneralPath)shape).lineTo(3.5355337, 41.989594);
((GeneralPath)shape).lineTo(3.5355337, 3.0103307);
((GeneralPath)shape).lineTo(1.9650707, 3.0103307);
((GeneralPath)shape).lineTo(1.9489857, 43.94486);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_4);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_5 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5
shape = new GeneralPath();
((GeneralPath)shape).moveTo(2.0239956, 43.75736);
((GeneralPath)shape).lineTo(1.9791847, 3.0545251);
((GeneralPath)shape).lineTo(21.92031, 3.0545251);
((GeneralPath)shape).lineTo(21.741064, 33.681087);
((GeneralPath)shape).lineTo(2.0239956, 43.75736);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(27.883882522583008, 7.139606952667236), 9.722718f, new Point2D.Double(27.883882522583008, 7.139606952667236), new float[] {0.0f,1.0f}, new Color[] {new Color(78, 78, 78, 255),new Color(97, 97, 97, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(2.5658230781555176f, 0.0f, 0.0f, 1.4032620191574097f, -49.804046630859375f, -9.48330307006836f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_5);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_6 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6
shape = new GeneralPath();
((GeneralPath)shape).moveTo(17.62221, 18.456196);
((GeneralPath)shape).lineTo(19.544657, 20.908972);
((GeneralPath)shape).lineTo(18.086248, 25.726135);
((GeneralPath)shape).curveTo(18.086248, 25.726135, 18.351414, 27.228739, 19.124811, 26.212273);
((GeneralPath)shape).curveTo(19.89821, 25.195807, 22.097267, 22.630219, 21.71017, 20.754292);
((GeneralPath)shape).curveTo(21.422909, 19.362175, 20.627415, 18.699263, 20.627415, 18.699263);
((GeneralPath)shape).lineTo(17.62221, 18.456196);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(31.852951049804688, 19.107728958129883), new Point2D.Double(34.007415771484375, 24.764583587646484), new float[] {0.0f,1.0f}, new Color[] {new Color(82, 82, 82, 255),new Color(82, 82, 82, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -13.136935234069824f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_6);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_7 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
shape = new GeneralPath();
((GeneralPath)shape).moveTo(19.456268, 17.35134);
((GeneralPath)shape).curveTo(19.456268, 17.35134, 21.61954, 18.353058, 21.688074, 19.229593);
((GeneralPath)shape).curveTo(21.789854, 20.531315, 17.445433, 24.665476, 17.445433, 24.665476);
((GeneralPath)shape).curveTo(16.9372, 25.284195, 16.097511, 24.731768, 16.56155, 24.135145);
((GeneralPath)shape).curveTo(16.56155, 24.135145, 20.028154, 20.017174, 19.809822, 19.69363);
((GeneralPath)shape).curveTo(19.536211, 19.288174, 17.843182, 18.655067, 17.843182, 18.655067);
((GeneralPath)shape).curveTo(16.826715, 17.903769, 18.110802, 16.349606, 19.456268, 17.35134);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(31.078954696655273, 21.511184692382812), new Point2D.Double(33.71065139770508, 18.06403923034668), new float[] {0.0f,1.0f}, new Color[] {new Color(206, 206, 206, 255),new Color(158, 158, 158, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -12.020814895629883f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_7);
g.setComposite(AlphaComposite.getInstance(3, 0.8742857f * origAlpha));
AffineTransform defaultTransform__0_0_8 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8
shape = new GeneralPath();
((GeneralPath)shape).moveTo(22.229185, 3.5);
((GeneralPath)shape).lineTo(21.729185, 33.25);
((GeneralPath)shape).lineTo(3.7291846, 43.0);
((GeneralPath)shape).lineTo(32.979183, 43.25);
((GeneralPath)shape).lineTo(32.729183, 3.5);
((GeneralPath)shape).lineTo(22.229185, 3.5);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(40.25, 31.625), new Point2D.Double(40.25, 43.25), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -12.020814895629883f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_8);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_9 = g.getTransform();
g.transform(new AffineTransform(-1.0f, 0.0f, 0.0f, 1.0f, 48.20136642456055f, -0.04733499884605408f));
// _0_0_9
g.setComposite(AlphaComposite.getInstance(3, 0.2994652f * origAlpha));
AffineTransform defaultTransform__0_0_9_0 = g.getTransform();
g.transform(new AffineTransform(0.7784900069236755f, 0.0f, 0.0f, 0.7784900069236755f, -7.579814910888672f, 1.5981390476226807f));
// _0_0_9_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(40.48186, 36.421127);
((GeneralPath)shape).curveTo(40.50693, 39.429993, 37.530556, 42.216076, 32.67976, 43.724407);
((GeneralPath)shape).curveTo(27.828962, 45.23274, 21.845287, 45.23274, 16.99449, 43.724407);
((GeneralPath)shape).curveTo(12.143692, 42.216076, 9.167317, 39.429993, 9.192389, 36.421127);
((GeneralPath)shape).curveTo(9.167317, 33.412262, 12.143692, 30.626177, 16.99449, 29.117847);
((GeneralPath)shape).curveTo(21.845287, 27.609516, 27.828962, 27.609516, 32.67976, 29.117847);
((GeneralPath)shape).curveTo(37.530556, 30.626177, 40.50693, 33.412262, 40.48186, 36.421127);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(24.837125778198242, 36.42112731933594), 15.644737f, new Point2D.Double(24.837125778198242, 36.42112731933594), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.5367230176925659f, 0.0f, 16.87306022644043f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_9_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_9_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(1.731798, 17.593819);
((GeneralPath)shape).lineTo(1.731798, 30.355364);
((GeneralPath)shape).lineTo(9.6641035, 30.355364);
((GeneralPath)shape).lineTo(9.6641035, 36.176147);
((GeneralPath)shape).lineTo(21.887745, 23.952503);
((GeneralPath)shape).lineTo(9.591343, 11.656101);
((GeneralPath)shape).lineTo(9.591343, 17.597067);
((GeneralPath)shape).lineTo(1.731798, 17.593819);
((GeneralPath)shape).closePath();
paint = new Color(204, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(164, 0, 0, 255);
stroke = new BasicStroke(1.0f,1,1,10.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(1.731798, 17.593819);
((GeneralPath)shape).lineTo(1.731798, 30.355364);
((GeneralPath)shape).lineTo(9.6641035, 30.355364);
((GeneralPath)shape).lineTo(9.6641035, 36.176147);
((GeneralPath)shape).lineTo(21.887745, 23.952503);
((GeneralPath)shape).lineTo(9.591343, 11.656101);
((GeneralPath)shape).lineTo(9.591343, 17.597067);
((GeneralPath)shape).lineTo(1.731798, 17.593819);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_9_1);
g.setComposite(AlphaComposite.getInstance(3, 0.5080214f * origAlpha));
AffineTransform defaultTransform__0_0_9_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(9.924008, 12.478043);
((GeneralPath)shape).lineTo(9.924008, 18.115662);
((GeneralPath)shape).lineTo(2.074615, 18.115662);
((GeneralPath)shape).lineTo(2.074615, 24.53144);
((GeneralPath)shape).curveTo(12.332521, 20.703863, 11.954992, 27.773987, 21.29428, 23.94641);
((GeneralPath)shape).lineTo(9.924008, 12.478043);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(19.701141357421875, 2.8969380855560303), 17.171415f, new Point2D.Double(19.701141357421875, 2.8969380855560303), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.2534420490264893f, 0.0f, 0.0f, 0.9538999795913696f, -15.479080200195312f, 11.276630401611328f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_9_2);
g.setComposite(AlphaComposite.getInstance(3, 0.4812834f * origAlpha));
AffineTransform defaultTransform__0_0_9_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9_3
paint = new LinearGradientPaint(new Point2D.Double(8.760064125061035, 13.663073539733887), new Point2D.Double(19.75554847717285, 43.449947357177734), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9687179923057556f, 0.0f, 0.0f, 0.9689198136329651f, 0.3616813123226166f, 0.7378237247467041f));
stroke = new BasicStroke(1.0000001f,0,0,10.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(2.6834412, 18.565933);
((GeneralPath)shape).lineTo(2.6834412, 29.355867);
((GeneralPath)shape).lineTo(10.584702, 29.355867);
((GeneralPath)shape).lineTo(10.584702, 33.48148);
((GeneralPath)shape).lineTo(20.127981, 23.941908);
((GeneralPath)shape).lineTo(10.522155, 13.997214);
((GeneralPath)shape).lineTo(10.522155, 18.568726);
((GeneralPath)shape).lineTo(2.6834412, 18.565933);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_9_3);
g.setTransform(defaultTransform__0_0_9);
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
		return 48.0;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 47.38999938964844;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private system_log_out_3() {
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
       system_log_out_3 base = new system_log_out_3();
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
       system_log_out_3 base = new system_log_out_3();
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
        return system_log_out_3::new;
    }
}

