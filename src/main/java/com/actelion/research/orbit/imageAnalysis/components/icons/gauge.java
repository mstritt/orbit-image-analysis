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
public class gauge implements ResizableIcon {
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
shape = new Rectangle2D.Double(0.5591395497322083, 0.4912334382534027, 31.50276756286621, 31.570112228393555);
paint = new Color(128, 128, 128, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(204, 204, 204, 255);
stroke = new BasicStroke(0.5242f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(0.5591395497322083, 0.4912334382534027, 31.50276756286621, 31.570112228393555);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.82308030128479f, 0.0f, 0.0f, 1.238771677017212f, 4.035398960113525f, -3.683445930480957f));
// _0_0_1
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_0
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(1.0f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(2.5004907f, 22.62316f);
generalPath.lineTo(27.326792f, 22.62316f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_1
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(1.0f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(2.232581f, 20.033365f);
generalPath.lineTo(2.232581f, 25.212954f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_2
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(1.0f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(27.594702f, 20.033365f);
generalPath.lineTo(27.594702f, 25.212954f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0031274557113647f, 0.0f, 0.0f, 0.9968823790550232f, 0.0f, 0.0f));
// _0_0_2_0
{
    Graphics2D gText = ((Graphics2D)g.create());
            Shape shapeText = null;
            GeneralPath generalPathText = null;
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
paint = new Color(255, 255, 255, 255);
gText.setPaint(paint);
if (generalPathText == null) {
   generalPathText = new GeneralPath();
} else {
   generalPathText.reset();
}
generalPathText.moveTo(1.7750667f, 12.57888f);
generalPathText.quadTo(1.7750667f, 11.373026f, 2.0224214f, 10.640238f);
generalPathText.quadTo(2.269776f, 9.904358f, 2.7583017f, 9.505498f);
generalPathText.quadTo(3.2499194f, 9.106639f, 3.9919834f, 9.106639f);
generalPathText.quadTo(4.5392556f, 9.106639f, 4.9504833f, 9.326166f);
generalPathText.quadTo(5.3648024f, 9.545693f, 5.6338005f, 9.963104f);
generalPathText.quadTo(5.9027987f, 10.377423f, 6.0543036f, 10.974167f);
generalPathText.quadTo(6.2089005f, 11.567818f, 6.2089005f, 12.57888f);
generalPathText.quadTo(6.2089005f, 13.775459f, 5.9615455f, 14.511339f);
generalPathText.quadTo(5.717283f, 15.24722f, 5.225665f, 15.649171f);
generalPathText.quadTo(4.7371397f, 16.051123f, 3.9919834f, 16.051123f);
generalPathText.quadTo(3.0087485f, 16.051123f, 2.4460166f, 15.34307f);
generalPathText.quadTo(1.7750667f, 14.49588f, 1.7750667f, 12.57888f);
generalPathText.closePath();
generalPathText.moveTo(2.6315324f, 12.57888f);
generalPathText.quadTo(2.6315324f, 14.254709f, 3.024208f, 14.808165f);
generalPathText.quadTo(3.4168837f, 15.361621f, 3.9919834f, 15.361621f);
generalPathText.quadTo(4.5670834f, 15.361621f, 4.956667f, 14.805073f);
generalPathText.quadTo(5.349343f, 14.248525f, 5.349343f, 12.57888f);
generalPathText.quadTo(5.349343f, 10.8999605f, 4.956667f, 10.349596f);
generalPathText.quadTo(4.5670834f, 9.79614f, 3.9827077f, 9.79614f);
generalPathText.quadTo(3.407608f, 9.79614f, 3.0644033f, 10.284665f);
generalPathText.quadTo(2.6315324f, 10.906144f, 2.6315324f, 12.57888f);
generalPathText.closePath();
generalPathText.moveTo(7.524518f, 15.933629f);
generalPathText.lineTo(7.524518f, 14.981314f);
generalPathText.lineTo(8.476834f, 14.981314f);
generalPathText.lineTo(8.476834f, 15.933629f);
generalPathText.lineTo(7.524518f, 15.933629f);
generalPathText.closePath();
generalPathText.moveTo(14.028402f, 10.797927f);
generalPathText.lineTo(13.1966715f, 10.862857f);
generalPathText.quadTo(13.085362f, 10.37124f, 12.881294f, 10.148621f);
generalPathText.quadTo(12.544273f, 9.793048f, 12.046473f, 9.793048f);
generalPathText.quadTo(11.647613f, 9.793048f, 11.347695f, 10.015667f);
generalPathText.quadTo(10.951927f, 10.303217f, 10.7231245f, 10.856673f);
generalPathText.quadTo(10.497414f, 11.407038f, 10.488137f, 12.427376f);
generalPathText.quadTo(10.791147f, 11.966678f, 11.22711f, 11.744059f);
generalPathText.quadTo(11.663073f, 11.521439f, 12.13923f, 11.521439f);
generalPathText.quadTo(12.974052f, 11.521439f, 13.56152f, 12.136734f);
generalPathText.quadTo(14.148988f, 12.752028f, 14.148988f, 13.725988f);
generalPathText.quadTo(14.148988f, 14.366018f, 13.870713f, 14.916383f);
generalPathText.quadTo(13.595531f, 15.463655f, 13.11319f, 15.757389f);
generalPathText.quadTo(12.630848f, 16.051123f, 12.018644f, 16.051123f);
generalPathText.quadTo(10.976663f, 16.051123f, 10.318081f, 15.284323f);
generalPathText.quadTo(9.659499f, 14.514431f, 9.659499f, 12.752028f);
generalPathText.quadTo(9.659499f, 10.779375f, 10.386104f, 9.885806f);
generalPathText.quadTo(11.023042f, 9.106639f, 12.099035f, 9.106639f);
generalPathText.quadTo(12.899846f, 9.106639f, 13.413107f, 9.558061f);
generalPathText.quadTo(13.926368f, 10.006392f, 14.028402f, 10.797927f);
generalPathText.closePath();
generalPathText.moveTo(10.617998f, 13.72908f);
generalPathText.quadTo(10.617998f, 14.161951f, 10.800423f, 14.557718f);
generalPathText.quadTo(10.985939f, 14.950394f, 11.3136835f, 15.157554f);
generalPathText.quadTo(11.644521f, 15.361621f, 12.006277f, 15.361621f);
generalPathText.quadTo(12.534998f, 15.361621f, 12.915306f, 14.934935f);
generalPathText.quadTo(13.295613f, 14.508247f, 13.295613f, 13.775459f);
generalPathText.quadTo(13.295613f, 13.070498f, 12.918398f, 12.665455f);
generalPathText.quadTo(12.544273f, 12.260411f, 11.972266f, 12.260411f);
generalPathText.quadTo(11.406442f, 12.260411f, 11.010674f, 12.665455f);
generalPathText.quadTo(10.617998f, 13.070498f, 10.617998f, 13.72908f);
generalPathText.closePath();
shapeText = generalPath;
gText.fill(shapeText);
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
    gText.dispose();
}
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.03692401945590973f, 0.0f, 0.0f, 0.036160729825496674f, 15.86967945098877f, 1.5473711490631104f));
// _0_0_2_1
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_1_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_1_0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_1_0_0_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(140.4844f, 385.875f);
generalPath.lineTo(118.12501f, 385.875f);
generalPath.lineTo(118.12501f, 368.2969f);
generalPath.lineTo(117.56251f, 368.2969f);
generalPath.quadTo(105.75001f, 389.3906f, 80.57811f, 389.3906f);
generalPath.quadTo(57.79691f, 389.3906f, 45.56251f, 370.96878f);
generalPath.lineTo(44.859413f, 370.96878f);
generalPath.lineTo(44.859413f, 443.24997f);
generalPath.lineTo(19.265614f, 443.24997f);
generalPath.lineTo(19.265614f, 236.67188f);
generalPath.lineTo(44.578114f, 236.67188f);
generalPath.lineTo(44.578114f, 299.81247f);
generalPath.quadTo(44.578114f, 326.39056f, 46.757812f, 338.13278f);
generalPath.quadTo(48.93751f, 349.87497f, 57.726612f, 358.2422f);
generalPath.quadTo(66.51561f, 366.60938f, 79.45311f, 366.60938f);
generalPath.quadTo(85.21881f, 366.60938f, 91.61721f, 364.4297f);
generalPath.quadTo(98.01561f, 362.25f, 103.85161f, 356.69528f);
generalPath.quadTo(109.68751f, 351.1406f, 111.93751f, 344.1797f);
generalPath.quadTo(114.18751f, 337.21878f, 114.67971f, 328.0781f);
generalPath.quadTo(115.17191f, 318.9375f, 115.17191f, 300.09378f);
generalPath.lineTo(115.17191f, 236.67188f);
generalPath.lineTo(140.4844f, 236.67188f);
generalPath.lineTo(140.4844f, 385.87497f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.003440260887146f, 0.0f, 0.0f, 0.9965714812278748f, 0.0f, 0.0f));
// _0_0_2_2
{
    Graphics2D gText = ((Graphics2D)g.create());
            Shape shapeText = null;
            GeneralPath generalPathText = null;
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
paint = new Color(255, 255, 255, 255);
gText.setPaint(paint);
if (generalPathText == null) {
   generalPathText = new GeneralPath();
} else {
   generalPathText.reset();
}
generalPathText.moveTo(23.133873f, 15.719844f);
generalPathText.lineTo(23.133873f, 10.246819f);
generalPathText.lineTo(23.96187f, 10.246819f);
generalPathText.lineTo(23.96187f, 11.012974f);
generalPathText.quadTo(24.219545f, 10.611f, 24.645569f, 10.367067f);
generalPathText.quadTo(25.075027f, 10.123135f, 25.6213f, 10.123135f);
generalPathText.quadTo(26.229414f, 10.123135f, 26.617643f, 10.377375f);
generalPathText.quadTo(27.009312f, 10.628179f, 27.167353f, 11.081687f);
generalPathText.quadTo(27.816694f, 10.123135f, 28.857702f, 10.123135f);
generalPathText.quadTo(29.671957f, 10.123135f, 30.108286f, 10.573208f);
generalPathText.quadTo(30.548052f, 11.023281f, 30.548052f, 11.961219f);
generalPathText.lineTo(30.548052f, 15.719844f);
generalPathText.lineTo(29.627293f, 15.719844f);
generalPathText.lineTo(29.627293f, 12.27043f);
generalPathText.quadTo(29.627293f, 11.713851f, 29.534529f, 11.469918f);
generalPathText.quadTo(29.445202f, 11.225986f, 29.208141f, 11.078252f);
generalPathText.quadTo(28.971079f, 10.927082f, 28.651562f, 10.927082f);
generalPathText.quadTo(28.07437f, 10.927082f, 27.69301f, 11.311877f);
generalPathText.quadTo(27.31165f, 11.693236f, 27.31165f, 12.538412f);
generalPathText.lineTo(27.31165f, 15.719844f);
generalPathText.lineTo(26.384018f, 15.719844f);
generalPathText.lineTo(26.384018f, 12.163923f);
generalPathText.quadTo(26.384018f, 11.545503f, 26.157265f, 11.236293f);
generalPathText.quadTo(25.93051f, 10.927082f, 25.41516f, 10.927082f);
generalPathText.quadTo(25.023493f, 10.927082f, 24.690233f, 11.133223f);
generalPathText.quadTo(24.360409f, 11.339362f, 24.209238f, 11.737901f);
generalPathText.quadTo(24.061504f, 12.133002f, 24.061504f, 12.878544f);
generalPathText.lineTo(24.061504f, 15.719844f);
generalPathText.lineTo(23.133873f, 15.719844f);
generalPathText.closePath();
shapeText = generalPath;
gText.fill(shapeText);
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
    gText.dispose();
}
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
        return 0.29703953862190247;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 0.22913342714309692;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 31.702960968017578;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 31.77086639404297;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private gauge() {
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
       gauge base = new gauge();
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
       gauge base = new gauge();
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
        return gauge::new;
    }
}

