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
public class go_up_search implements ResizableIcon {
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
g.setComposite(AlphaComposite.getInstance(3, 0.38139534f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0013740062713623f, 0.0f, 0.0f, 0.41037899255752563f, -2.3931690520839766E-5f, 75.32737731933594f));
// _0_0_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(127.82442f, 115.70919f);
generalPath.curveTo(127.926834f, 120.239204f, 115.767685f, 124.4338f, 95.95111f, 126.70467f);
generalPath.curveTo(76.13453f, 128.97554f, 51.689888f, 128.97554f, 31.87331f, 126.70467f);
generalPath.curveTo(12.056729f, 124.4338f, -0.102419876f, 120.239204f, 0.0f, 115.70919f);
generalPath.lineTo(-7.1054274E-15f, 115.70919f);
generalPath.curveTo(-0.102419876f, 111.17918f, 12.056729f, 106.98458f, 31.87331f, 104.71371f);
generalPath.curveTo(51.689888f, 102.44283f, 76.13453f, 102.44283f, 95.95111f, 104.71371f);
generalPath.curveTo(115.767685f, 106.98458f, 127.926834f, 111.17918f, 127.82442f, 115.70919f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(63.912208557128906, 115.70919036865234), 63.91221f, new Point2D.Double(63.912208557128906, 115.70929718017578), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.19780200719833374f, 0.0f, 92.82166290283203f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, -4.0f));
// _0_0_1
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 4.0f));
// _0_0_1_0
g.setComposite(AlphaComposite.getInstance(3, 0.1f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_0_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(16.0f, 4.0f);
generalPath.curveTo(13.794f, 4.0f, 12.0f, 5.794f, 12.0f, 8.0f);
generalPath.lineTo(12.0f, 118.0f);
generalPath.curveTo(12.0f, 121.309f, 14.691f, 124.0f, 18.0f, 124.0f);
generalPath.lineTo(77.172f, 124.0f);
generalPath.curveTo(78.471f, 124.0f, 79.717f, 123.513f, 80.813f, 122.646f);
generalPath.curveTo(80.941f, 122.593f, 81.07f, 122.539f, 81.07f, 122.539f);
generalPath.curveTo(81.168f, 122.466f, 93.204f, 112.453f, 98.829f, 106.828f);
generalPath.curveTo(104.203f, 101.457f, 113.439f, 90.403f, 114.475f, 89.161f);
generalPath.curveTo(115.388f, 88.279f, 116.0f, 86.722f, 116.0f, 85.172f);
generalPath.lineTo(116.0f, 8.0f);
generalPath.curveTo(116.0f, 5.794f, 114.206f, 4.0f, 112.0f, 4.0f);
generalPath.lineTo(16.0f, 4.0f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.15f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_0_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(16.0f, 5.0f);
generalPath.curveTo(14.346f, 5.0f, 13.0f, 6.346f, 13.0f, 8.0f);
generalPath.lineTo(13.0f, 118.0f);
generalPath.curveTo(13.0f, 120.757f, 15.243f, 123.0f, 18.0f, 123.0f);
generalPath.lineTo(77.172f, 123.0f);
generalPath.curveTo(78.361f, 123.0f, 79.454f, 122.53f, 80.354f, 121.771f);
generalPath.curveTo(80.396f, 121.75f, 80.444f, 121.757f, 80.483f, 121.729f);
generalPath.curveTo(80.562f, 121.669f, 92.5f, 111.743f, 98.122f, 106.121f);
generalPath.curveTo(103.434f, 100.811f, 112.672f, 89.763f, 113.707f, 88.52f);
generalPath.curveTo(114.492f, 87.756f, 115.001f, 86.477f, 115.001f, 85.171f);
generalPath.lineTo(115.001f, 8.0f);
generalPath.curveTo(115.001f, 6.346f, 113.655f, 5.0f, 112.001f, 5.0f);
generalPath.lineTo(16.0f, 5.0f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.2f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_0_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(16.0f, 6.0f);
generalPath.curveTo(14.897f, 6.0f, 14.0f, 6.897f, 14.0f, 8.0f);
generalPath.lineTo(14.0f, 118.0f);
generalPath.curveTo(14.0f, 120.206f, 15.794f, 122.0f, 18.0f, 122.0f);
generalPath.lineTo(77.172f, 122.0f);
generalPath.curveTo(78.24f, 122.0f, 79.244f, 121.584f, 80.0f, 120.828f);
generalPath.curveTo(79.965f, 120.864f, 79.926f, 120.896f, 79.886f, 120.927f);
generalPath.curveTo(79.962f, 120.87f, 91.846f, 110.983f, 97.414f, 105.414f);
generalPath.curveTo(102.679f, 100.15f, 111.904f, 89.12f, 112.938f, 87.88f);
generalPath.curveTo(113.593f, 87.236f, 114.0f, 86.23f, 114.0f, 85.172f);
generalPath.lineTo(114.0f, 8.0f);
generalPath.curveTo(114.0f, 6.897f, 113.103f, 6.0f, 112.0f, 6.0f);
generalPath.lineTo(16.0f, 6.0f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.25f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_0_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(16.0f, 7.0f);
generalPath.curveTo(15.448f, 7.0f, 15.0f, 7.448f, 15.0f, 8.0f);
generalPath.lineTo(15.0f, 118.0f);
generalPath.curveTo(15.0f, 119.654f, 16.346f, 121.0f, 18.0f, 121.0f);
generalPath.lineTo(77.172f, 121.0f);
generalPath.curveTo(77.973f, 121.0f, 78.727f, 120.688f, 79.293f, 120.121f);
generalPath.curveTo(79.345f, 120.083f, 91.238f, 110.176f, 96.707f, 104.707f);
generalPath.curveTo(102.176f, 99.238f, 112.083f, 87.345f, 112.183f, 87.226f);
generalPath.curveTo(112.688f, 86.727f, 113.0f, 85.973f, 113.0f, 85.172f);
generalPath.lineTo(113.0f, 8.0f);
generalPath.curveTo(113.0f, 7.448f, 112.553f, 7.0f, 112.0f, 7.0f);
generalPath.lineTo(16.0f, 7.0f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(16.0f, 12.0f);
generalPath.lineTo(16.0f, 122.0f);
generalPath.curveTo(16.0f, 123.104f, 16.896f, 124.0f, 18.0f, 124.0f);
generalPath.lineTo(77.172f, 124.0f);
generalPath.curveTo(77.702f, 124.0f, 78.211f, 123.789f, 78.586f, 123.414f);
generalPath.lineTo(111.414f, 90.586f);
generalPath.curveTo(111.789f, 90.211f, 112.0f, 89.702f, 112.0f, 89.172f);
generalPath.lineTo(112.0f, 12.0f);
generalPath.lineTo(16.0f, 12.0f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(102.0, 112.30470275878906), 139.5585f, new Point2D.Double(102.0, 112.30470275878906), new float[] {0.0f,0.0151f,0.0558f,0.0964f,0.1357f,0.1737f,0.2099f,0.2435f,0.2722f}, new Color[] {new Color(0, 83, 125, 255),new Color(24, 99, 137, 255),new Color(85, 140, 168, 255),new Color(137, 175, 195, 255),new Color(179, 204, 216, 255),new Color(212, 226, 233, 255),new Color(236, 242, 245, 255),new Color(250, 252, 253, 255),new Color(255, 255, 255, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 4.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(18.0f, 13.0f);
generalPath.curveTo(17.449f, 13.0f, 17.0f, 13.449f, 17.0f, 14.0f);
generalPath.lineTo(17.0f, 122.0f);
generalPath.curveTo(17.0f, 122.552f, 17.449f, 123.0f, 18.0f, 123.0f);
generalPath.lineTo(77.172f, 123.0f);
generalPath.curveTo(77.435f, 123.0f, 77.693f, 122.894f, 77.879f, 122.707f);
generalPath.lineTo(110.707f, 89.879f);
generalPath.curveTo(110.894f, 89.692f, 111.0f, 89.435f, 111.0f, 89.172f);
generalPath.lineTo(111.0f, 14.0f);
generalPath.curveTo(111.0f, 13.449f, 110.552f, 13.0f, 110.0f, 13.0f);
generalPath.lineTo(18.0f, 13.0f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(102.0, 112.30470275878906), 139.5586f, new Point2D.Double(102.0, 112.30470275878906), new float[] {0.0f,0.11366145f,0.20296688f,0.2363f,0.2722f,0.5313f,0.8449f,1.0f}, new Color[] {new Color(83, 85, 87, 255),new Color(137, 138, 140, 255),new Color(236, 236, 236, 255),new Color(250, 250, 250, 255),new Color(255, 255, 255, 255),new Color(250, 250, 250, 255),new Color(235, 236, 236, 255),new Color(225, 226, 227, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 4.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 4.0f));
// _0_0_1_3
g.setComposite(AlphaComposite.getInstance(3, 0.1f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_3_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(111.414f, 86.586f);
generalPath.curveTo(111.664f, 86.336f, 93.035f, 93.0f, 88.0f, 93.0f);
generalPath.curveTo(86.346f, 93.0f, 85.0f, 94.346f, 85.0f, 96.0f);
generalPath.curveTo(85.0f, 101.035f, 78.336f, 119.664f, 78.586f, 119.414f);
generalPath.lineTo(111.414f, 86.586f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(94.34380340576172, 102.3447036743164), new Point2D.Double(86.53559875488281, 94.5365982055664), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(85, 87, 83, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.1f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_3_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(111.414f, 86.586f);
generalPath.curveTo(111.789f, 86.211f, 97.444f, 94.0f, 88.0f, 94.0f);
generalPath.curveTo(86.897f, 94.0f, 86.0f, 94.897f, 86.0f, 96.0f);
generalPath.curveTo(86.0f, 105.444f, 78.211f, 119.789f, 78.586f, 119.414f);
generalPath.lineTo(111.414f, 86.586f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(95.0, 103.0), new Point2D.Double(86.58650207519531, 94.58650207519531), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(85, 87, 83, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.1f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_3_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(111.414f, 86.586f);
generalPath.curveTo(111.653f, 86.347f, 97.807f, 95.0f, 88.0f, 95.0f);
generalPath.curveTo(87.447f, 95.0f, 87.0f, 95.447f, 87.0f, 96.0f);
generalPath.curveTo(87.0f, 105.807f, 78.347f, 119.653f, 78.586f, 119.414f);
generalPath.lineTo(111.414f, 86.586f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(95.0, 103.0), new Point2D.Double(87.29299926757812, 95.29299926757812), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(57, 59, 56, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_3_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(78.586f, 119.414f);
generalPath.curveTo(78.586f, 119.414f, 90.5f, 109.5f, 96.0f, 104.0f);
generalPath.curveTo(101.5f, 98.5f, 111.414f, 86.586f, 111.414f, 86.586f);
generalPath.curveTo(111.414f, 86.586f, 98.25f, 96.0f, 88.0f, 96.0f);
generalPath.curveTo(88.0f, 106.25f, 78.586f, 119.414f, 78.586f, 119.414f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(96.0, 104.0), new Point2D.Double(88.00019836425781, 96.00019836425781), new float[] {0.0f,0.0072f,0.0673f,0.1347f,0.2115f,0.3012f,0.4122f,0.5679f,1.0f}, new Color[] {new Color(136, 138, 133, 255),new Color(140, 142, 137, 255),new Color(171, 172, 169, 255),new Color(197, 198, 196, 255),new Color(219, 219, 218, 255),new Color(235, 235, 235, 255),new Color(247, 247, 246, 255),new Color(253, 253, 253, 255),new Color(255, 255, 255, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
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
generalPath.moveTo(-42.93742f, 3.783933f);
generalPath.lineTo(-42.93742f, 0.9892245f);
generalPath.lineTo(-42.93742f, 3.783933f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-0.7829949855804443f, 0.0f, 0.0f, 0.6508790254592896f, -2365.7958984375f, 690.3015747070312f));
// _0_0_4
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-0.7829949855804443f, 0.0f, 0.0f, 0.6508790254592896f, -2365.7958984375f, 690.3015747070312f));
// _0_0_5
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 0.6508790254592896f, 835.1669921875f, 697.62939453125f));
// _0_0_6
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 0.6508790254592896f, 835.1669921875f, 697.62939453125f));
// _0_0_7
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(61.23105f, 2.6244366f);
generalPath.lineTo(61.23105f, 0.41896716f);
generalPath.lineTo(61.23105f, 2.6244366f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 120.0f));
// _0_0_9
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f));
// _0_0_9_0
shape = new RoundRectangle2D.Double(56.0, -88.0, 16.0, 72.0, 8.618450164794922, 7.2496867179870605);
paint = new LinearGradientPaint(new Point2D.Double(56.21098327636719, 7.236054420471191), new Point2D.Double(56.21098327636719, 108.9878921508789), new float[] {0.0f,0.35f,0.5961165f,1.0f}, new Color[] {new Color(44, 114, 199, 255),new Color(86, 140, 208, 255),new Color(128, 167, 218, 255),new Color(189, 210, 236, 57)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0722453594207764f, 0.0f, 0.0f, 0.9019536972045898f, 3.7280383110046387f, -107.61749267578125f));
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
generalPath.moveTo(61.96995f, 103.13666f);
generalPath.lineTo(24.708143f, 63.712708f);
generalPath.curveTo(23.710278f, 62.656525f, 23.774563f, 61.03073f, 24.853146f, 60.050037f);
generalPath.lineTo(27.048166f, 58.05434f);
generalPath.curveTo(28.04175f, 57.1512f, 29.579622f, 57.088745f, 30.64892f, 57.910908f);
generalPath.curveTo(30.64892f, 57.910908f, 60.898514f, 81.16477f, 63.999973f, 83.54959f);
generalPath.curveTo(67.10215f, 81.16477f, 97.35103f, 57.910908f, 97.35103f, 57.910908f);
generalPath.curveTo(98.41961f, 57.088745f, 99.95748f, 57.1512f, 100.95107f, 58.05434f);
generalPath.lineTo(103.1468f, 60.050037f);
generalPath.curveTo(104.2261f, 61.03073f, 104.28968f, 62.656525f, 103.29038f, 63.71202f);
generalPath.lineTo(66.031425f, 103.13735f);
generalPath.curveTo(65.51213f, 103.68637f, 64.77355f, 104.0f, 64.00069f, 104.0f);
generalPath.curveTo(63.227108f, 104.0f, 62.489243f, 103.68637f, 61.96995f, 103.13666f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(55.99903106689453, -2.029032373229711E-7), new Point2D.Double(55.99903106689453, 136.20562744140625), new float[] {0.0f,1.0f}, new Color[] {new Color(44, 114, 199, 255),new Color(164, 192, 228, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.7142931222915649f, 0.0f, 0.0f, -0.6862784028053284f, 24.000280380249023f, 104.0f));
g.setPaint(paint);
g.fill(shape);
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
        return 0.4189671576023102;
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
		return 127.5810317993164;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private go_up_search() {
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
       go_up_search base = new go_up_search();
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
       go_up_search base = new go_up_search();
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
        return go_up_search::new;
    }
}

