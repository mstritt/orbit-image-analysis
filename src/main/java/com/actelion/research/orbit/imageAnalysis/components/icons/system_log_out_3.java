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
public class system_log_out_3 implements ResizableIcon {
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
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
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
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
shape = new Rectangle2D.Double(1.9791847467422485, 17.24085235595703, 30.999998092651367, 26.75914764404297);
paint = new LinearGradientPaint(new Point2D.Double(18.729185104370117, 44.0), new Point2D.Double(18.729185104370117, 29.06801414489746), new float[] {0.0f,1.0f}, new Color[] {new Color(186, 189, 182, 255),new Color(186, 189, 182, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.5542857f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(2.1041846f, 43.875f);
generalPath.lineTo(23.479185f, 35.0f);
generalPath.curveTo(23.479185f, 35.0f, 26.992725f, 32.780415f, 23.729185f, 31.5f);
generalPath.curveTo(20.314184f, 30.16016f, 16.729185f, 32.0f, 16.729185f, 32.0f);
generalPath.lineTo(2.1041846f, 43.875f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(2.0168467f, 43.94486f);
generalPath.lineTo(1.9780138f, 3.0545251f);
generalPath.lineTo(21.92031f, 3.0987194f);
generalPath.lineTo(21.964504f, 33.018173f);
generalPath.lineTo(2.0168467f, 43.94486f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(46.8458251953125, 19.80411720275879), new Point2D.Double(18.031221389770508, 27.759069442749023), new float[] {0.0f,1.0f}, new Color[] {new Color(78, 78, 78, 255),new Color(171, 171, 171, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -12.020814895629883f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.42222223f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(1.9489857f, 43.94486f);
generalPath.lineTo(22.097088f, 33.06237f);
generalPath.lineTo(3.5355337f, 41.989594f);
generalPath.lineTo(3.5355337f, 3.0103307f);
generalPath.lineTo(1.9650707f, 3.0103307f);
generalPath.lineTo(1.9489857f, 43.94486f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(2.0239956f, 43.75736f);
generalPath.lineTo(1.9791847f, 3.0545251f);
generalPath.lineTo(21.92031f, 3.0545251f);
generalPath.lineTo(21.741064f, 33.681087f);
generalPath.lineTo(2.0239956f, 43.75736f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(27.883882522583008, 7.139606952667236), 9.722718f, new Point2D.Double(27.883882522583008, 7.139606952667236), new float[] {0.0f,1.0f}, new Color[] {new Color(78, 78, 78, 255),new Color(97, 97, 97, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(2.5658230781555176f, 0.0f, 0.0f, 1.4032620191574097f, -49.804046630859375f, -9.48330307006836f));
g.setPaint(paint);
g.fill(shape);
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
generalPath.moveTo(17.62221f, 18.456196f);
generalPath.lineTo(19.544657f, 20.908972f);
generalPath.lineTo(18.086248f, 25.726135f);
generalPath.curveTo(18.086248f, 25.726135f, 18.351414f, 27.228739f, 19.124811f, 26.212273f);
generalPath.curveTo(19.89821f, 25.195807f, 22.097267f, 22.630219f, 21.71017f, 20.754292f);
generalPath.curveTo(21.422909f, 19.362175f, 20.627415f, 18.699263f, 20.627415f, 18.699263f);
generalPath.lineTo(17.62221f, 18.456196f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(31.852951049804688, 19.107728958129883), new Point2D.Double(34.007415771484375, 24.764583587646484), new float[] {0.0f,1.0f}, new Color[] {new Color(82, 82, 82, 255),new Color(82, 82, 82, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -13.136935234069824f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(19.456268f, 17.35134f);
generalPath.curveTo(19.456268f, 17.35134f, 21.61954f, 18.353058f, 21.688074f, 19.229593f);
generalPath.curveTo(21.789854f, 20.531315f, 17.445433f, 24.665476f, 17.445433f, 24.665476f);
generalPath.curveTo(16.9372f, 25.284195f, 16.097511f, 24.731768f, 16.56155f, 24.135145f);
generalPath.curveTo(16.56155f, 24.135145f, 20.028154f, 20.017174f, 19.809822f, 19.69363f);
generalPath.curveTo(19.536211f, 19.288174f, 17.843182f, 18.655067f, 17.843182f, 18.655067f);
generalPath.curveTo(16.826715f, 17.903769f, 18.110802f, 16.349606f, 19.456268f, 17.35134f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(31.078954696655273, 21.511184692382812), new Point2D.Double(33.71065139770508, 18.06403923034668), new float[] {0.0f,1.0f}, new Color[] {new Color(206, 206, 206, 255),new Color(158, 158, 158, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -12.020814895629883f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.8742857f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(22.229185f, 3.5f);
generalPath.lineTo(21.729185f, 33.25f);
generalPath.lineTo(3.7291846f, 43.0f);
generalPath.lineTo(32.979183f, 43.25f);
generalPath.lineTo(32.729183f, 3.5f);
generalPath.lineTo(22.229185f, 3.5f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(40.25, 31.625), new Point2D.Double(40.25, 43.25), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -12.020814895629883f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-1.0f, 0.0f, 0.0f, 1.0f, 48.20136642456055f, -0.04733499884605408f));
// _0_0_9
g.setComposite(AlphaComposite.getInstance(3, 0.2994652f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7784900069236755f, 0.0f, 0.0f, 0.7784900069236755f, -7.579814910888672f, 1.5981390476226807f));
// _0_0_9_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(40.48186f, 36.421127f);
generalPath.curveTo(40.50693f, 39.429993f, 37.530556f, 42.216076f, 32.67976f, 43.724407f);
generalPath.curveTo(27.828962f, 45.23274f, 21.845287f, 45.23274f, 16.99449f, 43.724407f);
generalPath.curveTo(12.143692f, 42.216076f, 9.167317f, 39.429993f, 9.192389f, 36.421127f);
generalPath.curveTo(9.167317f, 33.412262f, 12.143692f, 30.626177f, 16.99449f, 29.117847f);
generalPath.curveTo(21.845287f, 27.609516f, 27.828962f, 27.609516f, 32.67976f, 29.117847f);
generalPath.curveTo(37.530556f, 30.626177f, 40.50693f, 33.412262f, 40.48186f, 36.421127f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(24.837125778198242, 36.42112731933594), 15.644737f, new Point2D.Double(24.837125778198242, 36.42112731933594), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.5367230176925659f, 0.0f, 16.87306022644043f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(1.731798f, 17.593819f);
generalPath.lineTo(1.731798f, 30.355364f);
generalPath.lineTo(9.6641035f, 30.355364f);
generalPath.lineTo(9.6641035f, 36.176147f);
generalPath.lineTo(21.887745f, 23.952503f);
generalPath.lineTo(9.591343f, 11.656101f);
generalPath.lineTo(9.591343f, 17.597067f);
generalPath.lineTo(1.731798f, 17.593819f);
generalPath.closePath();
shape = generalPath;
paint = new Color(204, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(164, 0, 0, 255);
stroke = new BasicStroke(1.0f,1,1,10.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(1.731798f, 17.593819f);
generalPath.lineTo(1.731798f, 30.355364f);
generalPath.lineTo(9.6641035f, 30.355364f);
generalPath.lineTo(9.6641035f, 36.176147f);
generalPath.lineTo(21.887745f, 23.952503f);
generalPath.lineTo(9.591343f, 11.656101f);
generalPath.lineTo(9.591343f, 17.597067f);
generalPath.lineTo(1.731798f, 17.593819f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.5080214f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(9.924008f, 12.478043f);
generalPath.lineTo(9.924008f, 18.115662f);
generalPath.lineTo(2.074615f, 18.115662f);
generalPath.lineTo(2.074615f, 24.53144f);
generalPath.curveTo(12.332521f, 20.703863f, 11.954992f, 27.773987f, 21.29428f, 23.94641f);
generalPath.lineTo(9.924008f, 12.478043f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(19.701141357421875, 2.8969380855560303), 17.171415f, new Point2D.Double(19.701141357421875, 2.8969380855560303), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.2534420490264893f, 0.0f, 0.0f, 0.9538999795913696f, -15.479080200195312f, 11.276630401611328f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.4812834f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9_3
paint = new LinearGradientPaint(new Point2D.Double(8.760064125061035, 13.663073539733887), new Point2D.Double(19.75554847717285, 43.449947357177734), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9687179923057556f, 0.0f, 0.0f, 0.9689198136329651f, 0.3616813123226166f, 0.7378237247467041f));
stroke = new BasicStroke(1.0000001f,0,0,10.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(2.6834412f, 18.565933f);
generalPath.lineTo(2.6834412f, 29.355867f);
generalPath.lineTo(10.584702f, 29.355867f);
generalPath.lineTo(10.584702f, 33.48148f);
generalPath.lineTo(20.127981f, 23.941908f);
generalPath.lineTo(10.522155f, 13.997214f);
generalPath.lineTo(10.522155f, 18.568726f);
generalPath.lineTo(2.6834412f, 18.565933f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
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

