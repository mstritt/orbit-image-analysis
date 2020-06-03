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
public class document_open_7 implements ResizableIcon {
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
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(118.983f, 31.0f);
generalPath.curveTo(118.992f, 29.35f, 117.64999f, 28.0f, 115.99999f, 28.0f);
generalPath.lineTo(40.961006f, 28.0f);
generalPath.curveTo(40.961006f, 28.0f, 32.061005f, 20.0f, 30.961f, 20.0f);
generalPath.lineTo(14.999998f, 20.0f);
generalPath.curveTo(12.799996f, 20.0f, 10.999999f, 21.8f, 10.999999f, 24.0f);
generalPath.lineTo(10.999999f, 31.0f);
generalPath.curveTo(10.999999f, 31.0f, 11.999999f, 116.0f, 8.0f, 116.0f);
generalPath.lineTo(122.0f, 116.0f);
generalPath.curveTo(117.99999f, 116.0f, 118.983f, 31.0f, 118.983f, 31.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(72.00050354003906, 96.0), new Point2D.Double(72.00050354003906, 4.882811917923391E-4), new float[] {0.0f,0.0769f,0.5858f,0.9645f}, new Color[] {new Color(0, 71, 158, 255),new Color(44, 114, 199, 255),new Color(110, 161, 223, 255),new Color(173, 203, 238, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -6.999995231628418f, 20.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.6f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0033403635025024f, 0.0f, 0.0f, 1.0f, -8.237468719482422f, 20.0f));
// _0_1
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_1_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(132.0f, 96.0f);
generalPath.curveTo(132.0f, 98.2f, 128.4f, 100.0f, 124.0f, 100.0f);
generalPath.lineTo(20.0f, 100.0f);
generalPath.curveTo(15.6f, 100.0f, 12.0f, 98.2f, 12.0f, 96.0f);
generalPath.curveTo(12.0f, 93.8f, 15.6f, 92.0f, 20.0f, 92.0f);
generalPath.lineTo(124.0f, 92.0f);
generalPath.curveTo(128.4f, 92.0f, 132.0f, 93.8f, 132.0f, 96.0f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(10.884862f, 54.0f);
generalPath.curveTo(10.893892f, 55.75f, 10.902922f, 57.755f, 10.910952f, 60.0f);
generalPath.lineTo(119.09511f, 60.0f);
generalPath.curveTo(119.10414f, 57.755f, 119.11317f, 55.75f, 119.1212f, 54.0f);
generalPath.lineTo(10.884862f, 54.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(71.99949645996094, 14.257800102233887), new Point2D.Double(71.99949645996094, 19.95829963684082), new float[] {0.25f,1.0f}, new Color[] {new Color(113, 168, 245, 0),new Color(0, 87, 174, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0033403635025024f, 0.0f, 0.0f, 1.0f, -7.237468242645264f, 40.0f));
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
generalPath.moveTo(119.99722f, 31.0f);
generalPath.curveTo(120.00622f, 29.35f, 118.66422f, 28.0f, 117.01422f, 28.0f);
generalPath.lineTo(42.975224f, 28.0f);
generalPath.lineTo(36.38922f, 21.414f);
generalPath.curveTo(35.61122f, 20.636f, 34.075222f, 20.0f, 32.975224f, 20.0f);
generalPath.lineTo(12.014222f, 20.0f);
generalPath.curveTo(9.814222f, 20.0f, 8.014222f, 21.8f, 8.014222f, 24.0f);
generalPath.curveTo(8.014222f, 24.0f, 7.982222f, 54.4993f, 8.014222f, 60.0313f);
generalPath.lineTo(12.014222f, 60.0313f);
generalPath.curveTo(12.014222f, 53.222298f, 12.014222f, 24.0f, 12.014222f, 24.0f);
generalPath.lineTo(32.901222f, 23.997f);
generalPath.curveTo(33.08322f, 24.019f, 33.470222f, 24.179f, 33.560223f, 24.243f);
generalPath.lineTo(41.318222f, 32.0f);
generalPath.curveTo(41.318222f, 32.0f, 114.02722f, 32.0f, 115.99922f, 32.0f);
generalPath.curveTo(115.99922f, 32.435f, 116.00022f, 56.4003f, 116.00222f, 60.0313f);
generalPath.lineTo(120.01422f, 60.0313f);
generalPath.curveTo(120.04522f, 54.4993f, 119.99722f, 31.0f, 119.99722f, 31.0f);
generalPath.closePath();
shape = generalPath;
paint = new Color(94, 149, 227, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.8308491110801697f, -8.682967234108219E-8f, 8.746107482693333E-8f, 0.8248509764671326f, 10.825650215148926f, 1.1777911186218262f));
// _0_4
g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.057571291923523f, 0.0f, 0.0f, 1.0540506839752197f, -3.6845595836639404f, -1.7469078302383423f));
// _0_4_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(16.0f, 8.0f);
generalPath.lineTo(16.0f, 120.0f);
generalPath.curveTo(16.0f, 120.0f, 79.15625f, 120.0f, 79.15625f, 120.0f);
generalPath.lineTo(79.1875f, 120.0f);
generalPath.curveTo(79.18751f, 120.0f, 91.09375f, 110.09375f, 96.59375f, 104.59375f);
generalPath.curveTo(102.09375f, 99.09375f, 112.0f, 87.1875f, 112.0f, 87.1875f);
generalPath.lineTo(112.0f, 87.15625f);
generalPath.lineTo(112.0f, 8.0f);
generalPath.lineTo(16.0f, 8.0f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_4_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(16.000002f, 8.0f);
generalPath.lineTo(16.0f, 120.0f);
generalPath.curveTo(16.0f, 120.0f, 79.146416f, 120.0f, 79.146416f, 120.0f);
generalPath.lineTo(112.0f, 87.14642f);
generalPath.lineTo(112.0f, 8.0f);
generalPath.lineTo(16.000002f, 8.0f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_4_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(18.000002f, 9.000004f);
generalPath.curveTo(17.449001f, 9.000004f, 17.000002f, 9.4488535f, 17.000002f, 9.999668f);
generalPath.lineTo(17.000002f, 117.96352f);
generalPath.curveTo(17.000002f, 118.51533f, 17.449001f, 118.96318f, 18.000002f, 118.96318f);
generalPath.lineTo(77.172f, 118.96318f);
generalPath.curveTo(77.435f, 118.96318f, 79.93468f, 119.08131f, 80.12068f, 118.89438f);
generalPath.lineTo(110.707f, 88.0942f);
generalPath.curveTo(110.894f, 87.907265f, 111.0f, 85.40942f, 111.0f, 85.14651f);
generalPath.lineTo(111.0f, 9.999668f);
generalPath.curveTo(111.0f, 9.4488535f, 110.552f, 9.000004f, 110.0f, 9.000004f);
generalPath.lineTo(18.000002f, 9.000004f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(102.0, 112.30470275878906), 139.5586f, new Point2D.Double(102.0, 112.30470275878906), new float[] {0.0f,0.18851049f,0.25718147f,0.30111277f,0.5313f,0.8449f,1.0f}, new Color[] {new Color(183, 184, 185, 255),new Color(236, 236, 236, 255),new Color(250, 250, 250, 255),new Color(255, 255, 255, 255),new Color(250, 250, 250, 255),new Color(235, 236, 236, 255),new Color(225, 226, 227, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.2950340509414673f, 1.3831430578647996E-7f, -1.3627884243305743E-7f, 1.2946006059646606f, -30.09345245361328f, -33.11961364746094f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.4f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 40.0f, 0.0f));
// _0_4_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(41.87953f, 115.98249f);
generalPath.curveTo(41.87953f, 115.98249f, 66.18914f, 91.672874f, 66.18914f, 91.672874f);
generalPath.curveTo(66.18914f, 91.672874f, 56.836f, 94.586f, 46.586f, 94.586f);
generalPath.curveTo(46.586f, 104.836f, 41.87953f, 115.98249f, 41.87953f, 115.98249f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_4_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(79.172f, 120.0f);
generalPath.curveTo(79.172f, 120.0f, 91.086f, 110.086f, 96.586f, 104.586f);
generalPath.curveTo(102.086f, 99.086f, 112.0f, 87.172f, 112.0f, 87.172f);
generalPath.curveTo(112.0f, 87.172f, 98.25f, 96.0f, 88.0f, 96.0f);
generalPath.curveTo(88.0f, 106.25f, 79.172f, 120.0f, 79.172f, 120.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(98.61743927001953, 106.4144287109375), new Point2D.Double(91.2287368774414, 99.25497436523438), new float[] {0.0f,1.0f}, new Color[] {new Color(162, 162, 162, 255),new Color(255, 255, 255, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.9f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(124.36598f, 113.79242f);
generalPath.curveTo(124.27969f, 115.00674f, 122.85389f, 116.0f, 121.19831f, 116.0f);
generalPath.lineTo(6.812906f, 116.0f);
generalPath.curveTo(5.157329f, 116.0f, 3.731522f, 115.00674f, 3.644228f, 113.79242f);
generalPath.lineTo(0.007982f, 62.20463f);
generalPath.curveTo(-0.112423f, 60.992527f, 1.143808f, 60.0f, 2.799384f, 60.0f);
generalPath.lineTo(125.21183f, 60.0f);
generalPath.curveTo(126.86741f, 60.0f, 128.11761f, 60.99179f, 127.9912f, 62.203896f);
generalPath.lineTo(124.36598f, 113.79242f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(122.74437713623047, 96.0), new Point2D.Double(122.74437713623047, 20.0), new float[] {0.0f,0.130533f,0.346213f,0.72006166f,1.0f}, new Color[] {new Color(114, 180, 244, 255),new Color(179, 217, 255, 255),new Color(179, 217, 255, 255),new Color(113, 168, 245, 255),new Color(80, 142, 217, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0033807754516602f, 0.0f, 0.0f, 0.7368420958518982f, -8.237799644470215f, 45.26315689086914f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_6
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(125.21293f, 60.0f);
generalPath.lineTo(2.799926f, 60.0f);
generalPath.curveTo(1.1449261f, 60.0f, -0.11207393f, 60.992527f, 0.00792607f, 62.20463f);
generalPath.lineTo(3.6439261f, 113.79242f);
generalPath.curveTo(3.730926f, 115.00674f, 5.156926f, 116.0f, 6.8129263f, 116.0f);
generalPath.lineTo(121.19793f, 116.0f);
generalPath.curveTo(122.85393f, 116.0f, 124.27993f, 115.00674f, 124.36593f, 113.79242f);
generalPath.lineTo(127.99093f, 62.203896f);
generalPath.curveTo(128.11893f, 60.99179f, 126.86793f, 60.0f, 125.21293f, 60.0f);
generalPath.closePath();
generalPath.moveTo(120.41393f, 113.05263f);
generalPath.curveTo(118.87493f, 113.05263f, 9.134926f, 113.05263f, 7.597926f, 113.05263f);
generalPath.curveTo(7.229926f, 107.83726f, 4.5229263f, 70.62756f, 4.065926f, 64.14925f);
generalPath.curveTo(6.518926f, 64.14925f, 121.45793f, 64.14925f, 123.93493f, 64.14925f);
generalPath.curveTo(123.81393f, 65.85872f, 120.49293f, 111.92821f, 120.41393f, 113.05263f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(-178.0, -232.8496551513672), new Point2D.Double(-178.0, -304.61468505859375), new float[] {0.0f,0.1f,1.0f}, new Color[] {new Color(207, 231, 255, 255),new Color(113, 168, 245, 255),new Color(44, 114, 199, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.7368420958518982f, 242.0009307861328f, 284.368408203125f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.835f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_7
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(4.0f, 64.0f);
generalPath.curveTo(4.027349f, 64.77587f, 4.180272f, 68.80112f, 4.2225137f, 70.0f);
generalPath.curveTo(7.123925f, 70.0f, 122.78934f, 70.0f, 125.71499f, 70.0f);
generalPath.curveTo(125.74343f, 69.19122f, 125.93026f, 64.204735f, 125.9375f, 64.0f);
generalPath.curveTo(123.41788f, 64.0f, 6.495205f, 64.0f, 4.0f, 64.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(-168.99215698242188, -300.5), new Point2D.Double(-168.99215698242188, -296.4844055175781), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0172053575515747f, 0.0f, 0.0f, 1.5f, 246.03225708007812f, 514.75f));
g.setPaint(paint);
g.fill(shape);
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
		return 128.0;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 123.0719985961914;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private document_open_7() {
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
       document_open_7 base = new document_open_7();
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
       document_open_7 base = new document_open_7();
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
        return document_open_7::new;
    }
}

