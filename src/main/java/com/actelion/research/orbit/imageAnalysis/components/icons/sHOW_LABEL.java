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
public class sHOW_LABEL implements ResizableIcon {
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
shape = new Rectangle2D.Double(0.3413531184196472, 0.2010488212108612, 31.43155288696289, 31.498899459838867);
paint = new Color(128, 128, 128, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(204, 204, 204, 255);
stroke = new BasicStroke(0.5230163f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(0.3413531184196472, 0.2010488212108612, 31.43155288696289, 31.498899459838867);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
shape = new RoundRectangle2D.Double(4.107885360717773, 5.1938581466674805, 25.59418487548828, 8.725406646728516, 8.725406646728516, 8.725406646728516);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(0.751969f,1,1,4.0f,null,0.0f);
shape = new RoundRectangle2D.Double(4.107885360717773, 5.1938581466674805, 25.59418487548828, 8.725406646728516, 8.725406646728516, 8.725406646728516);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(19.701023f, 14.615718f);
generalPath.lineTo(17.65644f, 18.325459f);
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(1.5895324f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(19.701023f, 14.615718f);
generalPath.lineTo(17.65644f, 18.325459f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.1476881504058838f, 0.0f, 0.0f, 0.8713167905807495f, 0.0f, 0.0f));
// _0_0_3
{
    Graphics2D gText = ((Graphics2D)g.create());
            Shape shapeText = null;
            GeneralPath generalPathText = null;
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
paint = new Color(0, 0, 0, 255);
gText.setPaint(paint);
if (generalPathText == null) {
   generalPathText = new GeneralPath();
} else {
   generalPathText.reset();
}
generalPathText.moveTo(5.9105f, 7.835689f);
generalPathText.lineTo(6.434998f, 7.835689f);
generalPathText.lineTo(6.434998f, 13.485281f);
generalPathText.lineTo(5.9105f, 13.485281f);
generalPathText.lineTo(5.9105f, 7.835689f);
generalPathText.closePath();
generalPathText.moveTo(11.585069f, 9.409183f);
generalPathText.lineTo(11.585069f, 13.485281f);
generalPathText.lineTo(11.068063f, 13.485281f);
generalPathText.lineTo(11.068063f, 12.783453f);
generalPathText.quadTo(10.738379f, 13.185568f, 10.328771f, 13.387875f);
generalPathText.quadTo(9.919163f, 13.59018f, 9.432129f, 13.59018f);
generalPathText.quadTo(8.565458f, 13.59018f, 7.9535446f, 12.963281f);
generalPathText.quadTo(7.34163f, 12.333883f, 7.34163f, 11.434744f);
generalPathText.quadTo(7.34163f, 10.555585f, 7.9585395f, 9.931183f);
generalPathText.quadTo(8.577947f, 9.304283f, 9.447115f, 9.304283f);
generalPathText.quadTo(9.949134f, 9.304283f, 10.353747f, 9.519077f);
generalPathText.quadTo(10.760858f, 9.731375f, 11.068063f, 10.158465f);
generalPathText.lineTo(11.068063f, 9.409183f);
generalPathText.lineTo(11.585069f, 9.409183f);
generalPathText.closePath();
generalPathText.moveTo(9.487077f, 9.8088f);
generalPathText.quadTo(9.049994f, 9.8088f, 8.677851f, 10.026093f);
generalPathText.quadTo(8.308205f, 10.240887f, 8.088415f, 10.630513f);
generalPathText.quadTo(7.8686256f, 11.020141f, 7.8686256f, 11.454724f);
generalPathText.quadTo(7.8686256f, 11.884314f, 8.088415f, 12.278935f);
generalPathText.quadTo(8.310702f, 12.671061f, 8.682846f, 12.89085f);
generalPathText.quadTo(9.0574875f, 13.11064f, 9.484579f, 13.11064f);
generalPathText.quadTo(9.914167f, 13.11064f, 10.2987995f, 12.893348f);
generalPathText.quadTo(10.685929f, 12.676056f, 10.89323f, 12.30641f);
generalPathText.quadTo(11.103029f, 11.934266f, 11.103029f, 11.46971f);
generalPathText.quadTo(11.103029f, 10.760389f, 10.635977f, 10.285844f);
generalPathText.quadTo(10.168924f, 9.8088f, 9.487077f, 9.8088f);
generalPathText.closePath();
generalPathText.moveTo(12.800155f, 13.485281f);
generalPathText.lineTo(12.800155f, 7.835689f);
generalPathText.lineTo(13.319657f, 7.835689f);
generalPathText.lineTo(13.319657f, 10.108513f);
generalPathText.quadTo(13.649343f, 9.7039f, 14.056453f, 9.504092f);
generalPathText.quadTo(14.466061f, 9.304283f, 14.9530945f, 9.304283f);
generalPathText.quadTo(15.819765f, 9.304283f, 16.431679f, 9.931183f);
generalPathText.quadTo(17.043592f, 10.558083f, 17.043592f, 11.454724f);
generalPathText.quadTo(17.043592f, 12.338879f, 16.424187f, 12.965778f);
generalPathText.quadTo(15.807277f, 13.59018f, 14.938108f, 13.59018f);
generalPathText.quadTo(14.441084f, 13.59018f, 14.036471f, 13.377884f);
generalPathText.quadTo(13.631859f, 13.16309f, 13.319657f, 12.735998f);
generalPathText.lineTo(13.319657f, 13.485281f);
generalPathText.lineTo(12.800155f, 13.485281f);
generalPathText.closePath();
generalPathText.moveTo(14.898147f, 13.083166f);
generalPathText.quadTo(15.335229f, 13.083166f, 15.704875f, 12.868372f);
generalPathText.quadTo(16.077019f, 12.653577f, 16.296808f, 12.26395f);
generalPathText.quadTo(16.516598f, 11.874323f, 16.516598f, 11.439739f);
generalPathText.quadTo(16.516598f, 11.005155f, 16.29431f, 10.61303f);
generalPathText.quadTo(16.07452f, 10.218408f, 15.69988f, 9.998618f);
generalPathText.quadTo(15.327736f, 9.778829f, 14.90564f, 9.778829f);
generalPathText.quadTo(14.473554f, 9.778829f, 14.086424f, 9.998618f);
generalPathText.quadTo(13.699294f, 10.218408f, 13.489495f, 10.590552f);
generalPathText.quadTo(13.282193f, 10.960198f, 13.282193f, 11.424753f);
generalPathText.quadTo(13.282193f, 12.131577f, 13.749247f, 12.60862f);
generalPathText.quadTo(14.216299f, 13.083166f, 14.898147f, 13.083166f);
generalPathText.closePath();
generalPathText.moveTo(21.430645f, 12.131577f);
generalPathText.lineTo(21.872723f, 12.363854f);
generalPathText.quadTo(21.65543f, 12.790946f, 21.370703f, 13.053195f);
generalPathText.quadTo(21.085976f, 13.315444f, 20.728817f, 13.452812f);
generalPathText.quadTo(20.374157f, 13.59018f, 19.924587f, 13.59018f);
generalPathText.quadTo(18.928041f, 13.59018f, 18.36608f, 12.935807f);
generalPathText.quadTo(17.804117f, 12.281433f, 17.804117f, 11.457222f);
generalPathText.quadTo(17.804117f, 10.682963f, 18.28116f, 10.076044f);
generalPathText.quadTo(18.883083f, 9.304283f, 19.894615f, 9.304283f);
generalPathText.quadTo(20.93612f, 9.304283f, 21.558023f, 10.093528f);
generalPathText.quadTo(22.000101f, 10.652992f, 22.007593f, 11.487194f);
generalPathText.lineTo(18.343601f, 11.487194f);
generalPathText.quadTo(18.358585f, 12.199012f, 18.795668f, 12.656075f);
generalPathText.quadTo(19.235247f, 13.11064f, 19.87963f, 13.11064f);
generalPathText.quadTo(20.191832f, 13.11064f, 20.48405f, 13.0032425f);
generalPathText.quadTo(20.778769f, 12.893348f, 20.983574f, 12.71352f);
generalPathText.quadTo(21.190874f, 12.533691f, 21.430645f, 12.131577f);
generalPathText.closePath();
generalPathText.moveTo(21.430645f, 11.035127f);
generalPathText.quadTo(21.325747f, 10.615528f, 21.125937f, 10.3657675f);
generalPathText.quadTo(20.926128f, 10.113508f, 20.596443f, 9.961154f);
generalPathText.quadTo(20.26676f, 9.806303f, 19.90211f, 9.806303f);
generalPathText.quadTo(19.302683f, 9.806303f, 18.873093f, 10.190934f);
generalPathText.quadTo(18.558395f, 10.473165f, 18.39605f, 11.035127f);
generalPathText.lineTo(21.430645f, 11.035127f);
generalPathText.closePath();
generalPathText.moveTo(22.907982f, 7.835689f);
generalPathText.lineTo(23.43248f, 7.835689f);
generalPathText.lineTo(23.43248f, 13.485281f);
generalPathText.lineTo(22.907982f, 13.485281f);
generalPathText.lineTo(22.907982f, 7.835689f);
generalPathText.closePath();
shapeText = generalPath;
gText.fill(shapeText);
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
    gText.dispose();
}
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
paint = new Color(255, 255, 0, 255);
stroke = new BasicStroke(1.1827589f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(17.63558f, 29.639624f);
generalPath.curveTo(26.13411f, 30.78217f, 20.726f, 27.309837f, 18.205528f, 25.298704f);
generalPath.curveTo(13.470678f, 21.520678f, 15.814136f, 21.359549f, 12.997216f, 18.099474f);
generalPath.curveTo(11.375399f, 16.222515f, 4.3656774f, 15.958595f, 3.9099357f, 17.53513f);
generalPath.curveTo(3.124077f, 20.253626f, 9.13705f, 28.497076f, 17.63558f, 29.639624f);
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
        return 0.07984498143196106;
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
		return 31.920154571533203;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 31.961456298828125;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private sHOW_LABEL() {
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
       sHOW_LABEL base = new sHOW_LABEL();
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
       sHOW_LABEL base = new sHOW_LABEL();
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
        return sHOW_LABEL::new;
    }
}

