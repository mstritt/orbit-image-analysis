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
public class application_exit_3 implements ResizableIcon {
    

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
g.setComposite(AlphaComposite.getInstance(3, 0.7f * origAlpha));
AffineTransform defaultTransform__0_0_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0
shape = new RoundRectangle2D.Double(12.0, 1.0, 35.0, 45.0, 1.9889464378356934, 2.00976824760437);
paint = new Color(0, 0, 0, 80);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
shape = new RoundRectangle2D.Double(13.500009536743164, 2.500009059906006, 31.999980926513672, 41.99998092651367, 1.414406180381775, 1.416163682937622);
paint = new RadialGradientPaint(new Point2D.Double(93.78003692626953, 40.54505157470703), 16.321514f, new Point2D.Double(93.78003692626953, 40.54505157470703), new float[] {0.0f,1.0f}, new Color[] {new Color(80, 80, 80, 255),new Color(24, 24, 24, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(2.0182700157165527f, 0.0f, 0.0f, 2.643807888031006f, -144.57334899902344f, -62.192134857177734f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.0000198f,0,0,10.0f,null,0.0f);
shape = new RoundRectangle2D.Double(13.500009536743164, 2.500009059906006, 31.999980926513672, 41.99998092651367, 1.414406180381775, 1.416163682937622);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
shape = new Rectangle2D.Double(13.999631881713867, 31.736305236816406, 30.999998092651367, 12.263458251953125);
paint = new LinearGradientPaint(new Point2D.Double(30.93592071533203, 43.75735855102539), new Point2D.Double(30.93592071533203, 28.112619400024414), new float[] {0.0f,1.0f}, new Color[] {new Color(114, 126, 10, 255),new Color(114, 126, 10, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0255119800567627f, 0.0f, 0.0f, 0.6483420133590698f, -0.8658636212348938f, 15.630022048950195f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3
shape = new GeneralPath();
((GeneralPath)shape).moveTo(14.037294, 43.944622);
((GeneralPath)shape).lineTo(13.998461, 3.0542872);
((GeneralPath)shape).lineTo(33.940758, 3.0984814);
((GeneralPath)shape).lineTo(33.98495, 33.017937);
((GeneralPath)shape).lineTo(14.037294, 43.944622);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(46.8458251953125, 19.80411720275879), new Point2D.Double(18.031221389770508, 27.759069442749023), new float[] {0.0f,1.0f}, new Color[] {new Color(78, 78, 78, 255),new Color(171, 171, 171, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -3.6735026515088975E-4f, -2.3809999402146786E-4f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_3);
g.setComposite(AlphaComposite.getInstance(3, 0.42222223f * origAlpha));
AffineTransform defaultTransform__0_0_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
shape = new GeneralPath();
((GeneralPath)shape).moveTo(13.969433, 43.944622);
((GeneralPath)shape).lineTo(34.117535, 33.06213);
((GeneralPath)shape).lineTo(15.555981, 41.989353);
((GeneralPath)shape).lineTo(15.555981, 3.0100925);
((GeneralPath)shape).lineTo(13.985518, 3.0100925);
((GeneralPath)shape).lineTo(13.969433, 43.944622);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_4);
g.setComposite(AlphaComposite.getInstance(3, 0.2994652f * origAlpha));
AffineTransform defaultTransform__0_0_5 = g.getTransform();
g.transform(new AffineTransform(0.7784900069236755f, 0.0f, 0.0f, 0.7784900069236755f, -7.5801825523376465f, 1.5979008674621582f));
// _0_0_5
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
g.setTransform(defaultTransform__0_0_5);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_6 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6
shape = new GeneralPath();
((GeneralPath)shape).moveTo(1.7314304, 17.59358);
((GeneralPath)shape).lineTo(1.7314304, 30.355125);
((GeneralPath)shape).lineTo(9.663735, 30.355125);
((GeneralPath)shape).lineTo(9.663735, 36.175907);
((GeneralPath)shape).lineTo(21.887377, 23.952265);
((GeneralPath)shape).lineTo(9.590974, 11.655863);
((GeneralPath)shape).lineTo(9.590974, 17.596828);
((GeneralPath)shape).lineTo(1.7314304, 17.59358);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(11.131293296813965, 15.165678024291992), new Point2D.Double(11.118230819702148, 32.401405334472656), new float[] {0.0f,1.0f}, new Color[] {new Color(218, 63, 63, 255),new Color(194, 47, 47, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -3.6735026515088975E-4f, -2.3809999402146786E-4f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(164, 0, 0, 255);
stroke = new BasicStroke(0.9999998f,1,1,10.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(1.7314304, 17.59358);
((GeneralPath)shape).lineTo(1.7314304, 30.355125);
((GeneralPath)shape).lineTo(9.663735, 30.355125);
((GeneralPath)shape).lineTo(9.663735, 36.175907);
((GeneralPath)shape).lineTo(21.887377, 23.952265);
((GeneralPath)shape).lineTo(9.590974, 11.655863);
((GeneralPath)shape).lineTo(9.590974, 17.596828);
((GeneralPath)shape).lineTo(1.7314304, 17.59358);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_6);
g.setComposite(AlphaComposite.getInstance(3, 0.4812834f * origAlpha));
AffineTransform defaultTransform__0_0_7 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
paint = new LinearGradientPaint(new Point2D.Double(8.760064125061035, 13.663073539733887), new Point2D.Double(19.75554847717285, 43.449947357177734), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -3.6735026515088975E-4f, -2.3809999402146786E-4f));
stroke = new BasicStroke(1.0f,0,0,10.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(2.7189574, 18.399748);
((GeneralPath)shape).lineTo(2.7189574, 29.535791);
((GeneralPath)shape).lineTo(10.552776, 29.535791);
((GeneralPath)shape).lineTo(10.552776, 33.79374);
((GeneralPath)shape).lineTo(20.404228, 23.948168);
((GeneralPath)shape).lineTo(10.488209, 13.684476);
((GeneralPath)shape).lineTo(10.488209, 18.40263);
((GeneralPath)shape).lineTo(2.7189574, 18.399748);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_7);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_8 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8
shape = new GeneralPath();
((GeneralPath)shape).moveTo(14.044443, 43.757122);
((GeneralPath)shape).lineTo(13.999632, 3.0542872);
((GeneralPath)shape).lineTo(33.940758, 3.0542872);
((GeneralPath)shape).lineTo(33.761513, 33.68085);
((GeneralPath)shape).lineTo(14.044443, 43.757122);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(27.883882522583008, 7.139606952667236), 9.722718f, new Point2D.Double(27.883882522583008, 7.139606952667236), new float[] {0.0f,1.0f}, new Color[] {new Color(78, 78, 78, 255),new Color(97, 97, 97, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(2.5658230781555176f, 0.0f, 0.0f, 1.4032620191574097f, -37.783599853515625f, -9.483540534973145f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_8);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_9 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9
shape = new GeneralPath();
((GeneralPath)shape).moveTo(29.642656, 18.455957);
((GeneralPath)shape).lineTo(31.565104, 20.908733);
((GeneralPath)shape).lineTo(30.106695, 25.725899);
((GeneralPath)shape).curveTo(30.106695, 25.725899, 30.37186, 27.2285, 31.14526, 26.212034);
((GeneralPath)shape).curveTo(31.918657, 25.195568, 34.117714, 22.62998, 33.730618, 20.754053);
((GeneralPath)shape).curveTo(33.443356, 19.361937, 32.64786, 18.699024, 32.64786, 18.699024);
((GeneralPath)shape).lineTo(29.642656, 18.455957);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(31.852951049804688, 19.107728958129883), new Point2D.Double(34.007415771484375, 24.764583587646484), new float[] {0.0f,1.0f}, new Color[] {new Color(82, 82, 82, 255),new Color(82, 82, 82, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -1.1164876222610474f, -2.3809999402146786E-4f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_9);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_10 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10
shape = new GeneralPath();
((GeneralPath)shape).moveTo(31.476715, 17.351103);
((GeneralPath)shape).curveTo(31.476715, 17.351103, 33.639984, 18.35282, 33.708523, 19.229355);
((GeneralPath)shape).curveTo(33.810303, 20.531076, 29.46588, 24.665237, 29.46588, 24.665237);
((GeneralPath)shape).curveTo(28.957647, 25.283957, 28.117958, 24.73153, 28.581997, 24.134909);
((GeneralPath)shape).curveTo(28.581997, 24.134909, 32.0486, 20.016935, 31.830269, 19.693394);
((GeneralPath)shape).curveTo(31.556658, 19.287935, 29.863628, 18.65483, 29.863628, 18.65483);
((GeneralPath)shape).curveTo(28.847162, 17.90353, 30.131248, 16.349367, 31.476715, 17.351103);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(31.078954696655273, 21.511184692382812), new Point2D.Double(33.71065139770508, 18.06403923034668), new float[] {0.0f,1.0f}, new Color[] {new Color(206, 206, 206, 255),new Color(158, 158, 158, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -3.6735026515088975E-4f, -2.3809999402146786E-4f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_10);
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
        return 1.0;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 47.0;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 45.0;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private application_exit_3() {
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
       application_exit_3 base = new application_exit_3();
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
       application_exit_3 base = new application_exit_3();
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
        return application_exit_3::new;
    }
}

