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
public class select_rectangular2 implements ResizableIcon {
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
g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0
shape = new Rectangle2D.Double(8.0, 16.0, 112.0, 96.0);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
shape = new Rectangle2D.Double(3.9999637603759766, 15.999998092651367, 4.0, 96.0);
paint = new Color(153, 153, 153, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
shape = new Rectangle2D.Double(119.99996185302734, 15.999998092651367, 4.0, 96.0);
paint = new Color(153, 153, 153, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3
shape = new Rectangle2D.Double(8.0, 12.0, 112.0, 4.0);
paint = new Color(153, 153, 153, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
shape = new Rectangle2D.Double(8.0, 112.0, 112.0, 4.0);
paint = new Color(153, 153, 153, 255);
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
generalPath.moveTo(24.0f, 31.999998f);
generalPath.curveTo(24.0f, 38.716f, 24.0f, 89.284f, 24.0f, 96.0f);
generalPath.curveTo(31.6f, 96.0f, 96.4f, 96.0f, 104.0f, 96.0f);
generalPath.curveTo(104.0f, 89.284f, 104.0f, 38.716f, 104.0f, 31.999998f);
generalPath.curveTo(96.4f, 31.999998f, 31.6f, 31.999998f, 24.0f, 31.999998f);
generalPath.closePath();
shape = generalPath;
paint = new Color(85, 153, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(85, 153, 255, 255);
stroke = new BasicStroke(8.0f,0,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(24.0f, 31.999998f);
generalPath.curveTo(24.0f, 38.716f, 24.0f, 89.284f, 24.0f, 96.0f);
generalPath.curveTo(31.6f, 96.0f, 96.4f, 96.0f, 104.0f, 96.0f);
generalPath.curveTo(104.0f, 89.284f, 104.0f, 38.716f, 104.0f, 31.999998f);
generalPath.curveTo(96.4f, 31.999998f, 31.6f, 31.999998f, 24.0f, 31.999998f);
generalPath.closePath();
shape = generalPath;
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
generalPath.moveTo(24.0f, 31.999998f);
generalPath.curveTo(24.0f, 38.716f, 24.0f, 89.284f, 24.0f, 96.0f);
generalPath.curveTo(31.6f, 96.0f, 96.4f, 96.0f, 104.0f, 96.0f);
generalPath.curveTo(104.0f, 89.284f, 104.0f, 38.716f, 104.0f, 31.999998f);
generalPath.curveTo(96.4f, 31.999998f, 31.6f, 31.999998f, 24.0f, 31.999998f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
shape = new Rectangle2D.Double(59.823184967041016, 23.909902572631836, 8.0, 8.0);
paint = new LinearGradientPaint(new Point2D.Double(56.0, 4.0), new Point2D.Double(64.0, 4.0), new float[] {0.0f,1.0f}, new Color[] {new Color(187, 187, 187, 255),new Color(136, 136, 136, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 3.823223352432251f, 23.909902572631836f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8
shape = new Rectangle2D.Double(59.999961853027344, 95.91332244873047, 8.0, 8.0);
paint = new LinearGradientPaint(new Point2D.Double(56.0, 108.0), new Point2D.Double(64.0, 108.0), new float[] {0.0f,1.0f}, new Color[] {new Color(187, 187, 187, 255),new Color(136, 136, 136, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 4.0f, -8.086679458618164f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9
shape = new Rectangle2D.Double(16.08664321899414, 24.44023323059082, 8.0, 8.0);
paint = new LinearGradientPaint(new Point2D.Double(0.0, 4.0), new Point2D.Double(8.0, 4.0), new float[] {0.0f,1.0f}, new Color[] {new Color(187, 187, 187, 255),new Color(136, 136, 136, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 16.086679458618164f, 24.44023323059082f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10
shape = new Rectangle2D.Double(16.26342010498047, 95.73654174804688, 8.0, 8.0);
paint = new LinearGradientPaint(new Point2D.Double(0.0, 108.0), new Point2D.Double(8.0, 108.0), new float[] {0.0f,1.0f}, new Color[] {new Color(187, 187, 187, 255),new Color(136, 136, 136, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 16.263456344604492f, -8.263456344604492f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_11
shape = new Rectangle2D.Double(104.26683807373047, 25.1473388671875, 8.0, 8.0);
paint = new LinearGradientPaint(new Point2D.Double(112.0, 4.0), new Point2D.Double(120.0, 4.0), new float[] {0.0f,1.0f}, new Color[] {new Color(187, 187, 187, 255),new Color(136, 136, 136, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -7.733126163482666f, 25.147340774536133f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_12
shape = new Rectangle2D.Double(103.91327667236328, 96.26687622070312, 8.0, 8.0);
paint = new LinearGradientPaint(new Point2D.Double(112.0, 108.0), new Point2D.Double(120.0, 108.0), new float[] {0.0f,1.0f}, new Color[] {new Color(187, 187, 187, 255),new Color(136, 136, 136, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -8.086679458618164f, -7.733126163482666f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_13
shape = new Rectangle2D.Double(15.733089447021484, 59.64645004272461, 8.0, 8.0);
paint = new LinearGradientPaint(new Point2D.Double(0.0, 56.0), new Point2D.Double(8.0, 56.0), new float[] {0.0f,1.0f}, new Color[] {new Color(187, 187, 187, 255),new Color(136, 136, 136, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 15.733125686645508f, 7.646446704864502f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_14
shape = new Rectangle2D.Double(104.09005737304688, 59.82322692871094, 8.0, 8.0);
paint = new LinearGradientPaint(new Point2D.Double(112.0, 56.0), new Point2D.Double(120.0, 56.0), new float[] {0.0f,1.0f}, new Color[] {new Color(187, 187, 187, 255),new Color(136, 136, 136, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -7.909902572631836f, 7.82322359085083f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.2f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(24.0f, 32.0f);
generalPath.curveTo(24.0f, 38.716f, 24.0f, 89.284f, 24.0f, 96.0f);
generalPath.curveTo(31.6f, 96.0f, 96.4f, 96.0f, 104.0f, 96.0f);
generalPath.curveTo(104.0f, 89.284f, 104.0f, 38.716f, 104.0f, 32.0f);
generalPath.curveTo(96.4f, 32.0f, 31.6f, 32.0f, 24.0f, 32.0f);
generalPath.closePath();
generalPath.moveTo(28.0f, 36.0f);
generalPath.lineTo(99.88909f, 36.065865f);
generalPath.lineTo(100.0f, 92.0f);
generalPath.lineTo(28.0f, 92.0f);
generalPath.lineTo(28.0f, 36.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(64.0, 23.786014556884766), new Point2D.Double(64.0, 103.95767211914062), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(114, 119, 122, 255),new Color(0, 0, 0, 0),new Color(114, 117, 122, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.2f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.6570990085601807f, -0.12202899903059006f, 0.04147060960531235f, 0.33568599820137024f, 23.20479965209961f, 60.07752990722656f));
// _0_0_16
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
paint = new RadialGradientPaint(new Point2D.Double(63.912208557128906, 115.70919036865234), 63.91221f, new Point2D.Double(8.71600341796875, 123.91520690917969), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.19780200719833374f, 0.0f, 92.82166290283203f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.15839500725269318f, 0.7728170156478882f));
// _0_0_17
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(112.94799f, 0.35536432f);
generalPath.curveTo(113.36977f, -0.10112165f, 116.08929f, 0.16409583f, 118.94522f, 2.822344f);
generalPath.curveTo(121.82917f, 5.5066514f, 122.37582f, 8.067081f, 121.84747f, 8.6388445f);
generalPath.curveTo(121.5036f, 9.011015f, 121.15971f, 9.3831835f, 120.81584f, 9.755353f);
generalPath.curveTo(117.84932f, 6.9941916f, 114.88282f, 4.2330327f, 111.91632f, 1.4718714f);
generalPath.curveTo(112.2602f, 1.0997024f, 112.60409f, 0.72753394f, 112.94799f, 0.35536432f);
generalPath.curveTo(112.94799f, 0.35536432f, 112.94799f, 0.35536432f, 112.94799f, 0.35536432f);
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(31.841597f, 97.22718f);
generalPath.lineTo(56.094707f, 79.936935f);
generalPath.lineTo(56.232212f, 79.78812f);
generalPath.lineTo(47.47878f, 71.346535f);
generalPath.lineTo(47.2924f, 71.548164f);
generalPath.lineTo(31.841597f, 97.22718f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(33.24339f, 95.81655f);
generalPath.lineTo(55.860462f, 79.702446f);
generalPath.lineTo(55.99796f, 79.553635f);
generalPath.lineTo(47.71303f, 71.58102f);
generalPath.lineTo(47.52664f, 71.78265f);
generalPath.lineTo(33.24339f, 95.81655f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(42.617530822753906, 120.64187622070312), 3.406888f, new Point2D.Double(42.617530822753906, 120.64187622070312), new float[] {0.0f,1.0f}, new Color[] {new Color(180, 148, 42, 255),new Color(228, 220, 201, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.2316160202026367f, 1.2914210557937622f, -11.706159591674805f, 11.178339958190918f, 1411.8740234375f, -1325.552001953125f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(51.062305f, 76.42592f);
generalPath.curveTo(52.15999f, 77.44761f, 53.282482f, 77.06459f, 53.67486f, 77.429794f);
generalPath.curveTo(53.738266f, 77.48881f, 53.78037f, 77.5694f, 53.810177f, 77.65553f);
generalPath.lineTo(119.0733f, 6.887381f);
generalPath.lineTo(114.75934f, 2.8720372f);
generalPath.lineTo(49.372314f, 73.77426f);
generalPath.curveTo(49.569042f, 73.75839f, 49.743523f, 73.77058f, 49.867622f, 73.886086f);
generalPath.curveTo(50.226265f, 74.21992f, 49.959526f, 75.39947f, 51.062305f, 76.42592f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(15.727076530456543, 58.08968734741211), 2.6143966f, new Point2D.Double(15.727076530456543, 58.08968734741211), new float[] {0.0f,0.5f,0.75f,1.0f}, new Color[] {new Color(37, 37, 37, 255),new Color(37, 37, 37, 255),new Color(37, 37, 37, 255),new Color(0, 0, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.5485299825668335f, 1.4691139459609985f, -21.051679611206055f, 22.68597984313965f, 1272.946044921875f, -1291.4019775390625f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.35348833f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(56.139603f, 74.81749f);
generalPath.lineTo(53.58407f, 77.583176f);
generalPath.curveTo(53.92704f, 77.960365f, 53.45654f, 78.999374f, 54.115776f, 79.61297f);
generalPath.curveTo(54.82623f, 80.274254f, 55.597614f, 79.524734f, 56.059303f, 79.94943f);
generalPath.lineTo(58.64581f, 77.15019f);
generalPath.lineTo(56.139603f, 74.81749f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(118.9158f, 6.7407947f);
generalPath.lineTo(53.702244f, 77.45529f);
generalPath.curveTo(54.047096f, 77.83425f, 53.696117f, 78.74662f, 54.35873f, 79.36335f);
generalPath.curveTo(55.072807f, 80.02803f, 55.72626f, 79.40656f, 56.190292f, 79.83346f);
generalPath.lineTo(121.43482f, 9.085448f);
generalPath.lineTo(118.9158f, 6.7407947f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(36.6756477355957, 95.76927947998047), 47.746403f, new Point2D.Double(16.21735382080078, 64.14128112792969), new float[] {0.0f,0.09292036f,0.5043171f,0.91571385f,1.0f}, new Color[] {new Color(154, 118, 0, 255),new Color(227, 173, 0, 255),new Color(255, 205, 44, 255),new Color(227, 173, 0, 255),new Color(185, 141, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.05267341062426567f, 0.05051613971590996f, -1.0577939748764038f, 1.1162339448928833f, 183.7751007080078f, -66.53858184814453f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.38604653f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_6
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(51.110016f, 72.54274f);
generalPath.lineTo(49.799088f, 73.96148f);
generalPath.lineTo(49.749435f, 74.01399f);
generalPath.curveTo(50.042374f, 74.305f, 49.614532f, 75.36211f, 50.55457f, 76.41053f);
generalPath.lineTo(50.609352f, 76.46152f);
generalPath.lineTo(50.999664f, 76.82481f);
generalPath.lineTo(51.054443f, 76.8758f);
generalPath.curveTo(52.177227f, 77.74745f, 53.194927f, 77.22099f, 53.587288f, 77.58618f);
generalPath.lineTo(54.97567f, 76.07579f);
generalPath.lineTo(51.110016f, 72.54274f);
generalPath.closePath();
shape = generalPath;
paint = new Color(37, 37, 37, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.35348833f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_7
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(48.617046f, 70.194466f);
generalPath.lineTo(47.290016f, 71.55189f);
generalPath.curveTo(47.30377f, 71.56464f, 47.195457f, 71.6829f, 47.209263f, 71.695755f);
generalPath.curveTo(47.490852f, 71.95785f, 47.10021f, 73.01444f, 47.56853f, 73.631195f);
generalPath.lineTo(47.616467f, 73.6758f);
generalPath.lineTo(47.828735f, 73.87338f);
generalPath.lineTo(47.856133f, 73.898865f);
generalPath.curveTo(48.519268f, 74.34269f, 49.40944f, 73.79045f, 49.749435f, 74.01399f);
generalPath.lineTo(51.123253f, 72.5272f);
generalPath.lineTo(48.617046f, 70.194466f);
generalPath.closePath();
shape = generalPath;
paint = new Color(19, 19, 19, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_8
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(47.968758f, 73.50936f);
generalPath.curveTo(48.65992f, 74.13778f, 49.501755f, 73.54555f, 49.867622f, 73.886086f);
generalPath.lineTo(115.08119f, 3.171599f);
generalPath.lineTo(112.53531f, 0.8019672f);
generalPath.lineTo(47.290775f, 71.54999f);
generalPath.curveTo(47.304752f, 71.56292f, 47.318485f, 71.575775f, 47.332504f, 71.588844f);
generalPath.curveTo(47.618553f, 71.85508f, 47.272434f, 72.87611f, 47.968758f, 73.50936f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(11.326383590698242, 57.38399887084961), new Point2D.Double(14.493531227111816, 57.38399887084961), new float[] {0.0f,0.09292036f,0.5043171f,0.91571385f,1.0f}, new Color[] {new Color(154, 118, 0, 255),new Color(227, 173, 0, 255),new Color(255, 205, 44, 255),new Color(227, 173, 0, 255),new Color(185, 141, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.8565019965171814f, 0.7995359897613525f, -0.7966219782829285f, 0.8596339821815491f, 115.51229858398438f, -21.934789657592773f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7325119972229004f, 0.6807540059089661f, -0.6807540059089661f, 0.7325119972229004f, 0.0f, 0.0f));
// _0_0_17_9
shape = new Rectangle2D.Double(82.99185180664062, -76.58556365966797, 12.154855728149414, 2.857365846633911);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.5626800060272217f, -0.6086120009422302f, -1.1555869579315186f, -1.0720690488815308f, 76.43843841552734f, 59.62858963012695f));
// _0_0_17_10
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(82.17284f, 7.462277f);
generalPath.curveTo(82.17284f, 7.719914f, 77.16889f, 7.966999f, 68.26182f, 8.149176f);
generalPath.curveTo(59.354736f, 8.331353f, 47.274147f, 8.433699f, 34.67764f, 8.433699f);
generalPath.curveTo(22.08113f, 8.433699f, 10.00054f, 8.331353f, 1.093463f, 8.149176f);
generalPath.curveTo(-7.8136144f, 7.966999f, -12.817558f, 7.719914f, -12.817558f, 7.462277f);
generalPath.curveTo(-12.817558f, 7.20464f, -7.8136144f, 6.957555f, 1.093463f, 6.775378f);
generalPath.curveTo(10.00054f, 6.593201f, 22.08113f, 6.490855f, 34.67764f, 6.490855f);
generalPath.curveTo(47.274147f, 6.490855f, 59.354736f, 6.593201f, 68.26182f, 6.775378f);
generalPath.curveTo(77.16889f, 6.957555f, 82.17284f, 7.20464f, 82.17284f, 7.462277f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(34.67763900756836, 7.462276935577393), 47.595196f, new Point2D.Double(34.67763900756836, 7.462276935577393), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 174),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9999139904975891f, -0.007841645739972591f, 5.666079232469201E-4f, 0.02048305980861187f, -0.0012422340223565698f, 7.581357002258301f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.46591898798942566f, -0.5057169795036316f, -0.8370239734649658f, -0.7796880006790161f, 72.02738952636719f, 62.118621826171875f));
// _0_0_17_11
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(106.56087f, 7.462277f);
generalPath.curveTo(106.5609f, 7.694624f, 74.720764f, 7.8834887f, 35.24227f, 7.8853135f);
generalPath.curveTo(-4.2362256f, 7.8871384f, -36.57657f, 7.701241f, -37.196724f, 7.4689226f);
generalPath.curveTo(-37.816895f, 7.236604f, -6.484828f, 7.04482f, 32.98388f, 7.0393453f);
generalPath.curveTo(72.45259f, 7.0338707f, 105.28513f, 7.216755f, 106.52539f, 7.448987f);
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(34.67763900756836, 7.462276935577393), 47.595196f, new Point2D.Double(34.67763900756836, 7.462276935577393), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-1.5103000402450562f, 0.0026412729639559984f, -1.1670780077110976E-4f, -0.009110224433243275f, 87.05220031738281f, 7.438665866851807f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_12
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(108.38485f, 5.30161f);
generalPath.curveTo(107.12716f, 6.0907826f, 105.93515f, 7.4663906f, 105.29482f, 8.645764f);
generalPath.lineTo(112.44928f, 15.244444f);
generalPath.lineTo(115.5393f, 11.90029f);
generalPath.lineTo(108.38485f, 5.30161f);
generalPath.closePath();
generalPath.moveTo(114.78737f, 11.200422f);
generalPath.lineTo(111.69734f, 14.544576f);
generalPath.lineTo(114.20374f, 16.877474f);
generalPath.curveTo(115.29929f, 16.218853f, 116.5563f, 14.908329f, 117.29377f, 13.533321f);
generalPath.lineTo(114.78737f, 11.200422f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(49.009883880615234, 8.495312690734863), 3.9750404f, new Point2D.Double(47.370887756347656, 6.770169734954834), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(174, 174, 174, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.1124390363693237f, 1.0354360342025757f, -0.38867801427841187f, 0.42064398527145386f, 60.10820007324219f, -43.230560302734375f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_13
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(42.27053f, 89.82674f);
generalPath.curveTo(40.6429f, 89.66667f, 39.24413f, 87.19937f, 38.343975f, 86.4445f);
generalPath.lineTo(31.84288f, 97.22175f);
generalPath.lineTo(42.27053f, 89.82674f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7319869995117188f, 0.681318998336792f, -0.6786490082740784f, 0.7344629764556885f, 0.0f, 0.0f));
// _0_0_17_14
shape = new Rectangle2D.Double(86.6741943359375, -77.08168029785156, 5.241995811462402, 1.1477652788162231);
paint = new RadialGradientPaint(new Point2D.Double(49.01197052001953, 2.6743078231811523), 1.7246193f, new Point2D.Double(49.01197052001953, 2.6743078231811523), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(37, 37, 37, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.5197540521621704f, 0.0f, 0.0f, 0.18494200706481934f, 14.809029579162598f, -77.11570739746094f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_15
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(118.05347f, 2.2273397f);
generalPath.curveTo(119.90131f, 3.702737f, 121.20567f, 5.718846f, 121.27612f, 5.9115605f);
generalPath.curveTo(121.34655f, 6.104276f, 119.56393f, 3.843466f, 118.03439f, 2.796435f);
generalPath.curveTo(116.51655f, 1.7573994f, 114.37282f, 1.6966459f, 114.21641f, 1.5706147f);
generalPath.curveTo(114.06f, 1.4445845f, 113.0071f, 0.2936384f, 113.97851f, 0.35151747f);
generalPath.curveTo(114.99456f, 0.4120566f, 116.62619f, 1.0887976f, 118.05347f, 2.2273397f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(48.49856185913086, 0.8115049600601196), new Point2D.Double(48.732723236083984, 2.365726947784424), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.1124390363693237f, 1.0354360342025757f, -1.031662940979004f, 1.1165070533752441f, 65.5705337524414f, -49.14213943481445f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_16
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(60.938377f, 71.52827f);
generalPath.curveTo(60.73753f, 71.74541f, 60.6241f, 71.95325f, 60.59806f, 72.15179f);
generalPath.curveTo(60.57203f, 72.35035f, 60.635857f, 72.52122f, 60.78954f, 72.66441f);
generalPath.curveTo(60.942577f, 72.807f, 61.116776f, 72.85789f, 61.31212f, 72.817116f);
generalPath.curveTo(61.50747f, 72.7763f, 61.705563f, 72.647354f, 61.906403f, 72.43022f);
generalPath.curveTo(62.1084f, 72.21184f, 62.222393f, 72.00339f, 62.24844f, 71.80483f);
generalPath.curveTo(62.274467f, 71.60627f, 62.210957f, 71.435715f, 62.057926f, 71.29312f);
generalPath.curveTo(61.904236f, 71.149925f, 61.72972f, 71.09873f, 61.534374f, 71.13953f);
generalPath.curveTo(61.339027f, 71.18031f, 61.140366f, 71.30989f, 60.938377f, 71.52827f);
generalPath.moveTo(60.665848f, 71.27432f);
generalPath.curveTo(61.076664f, 70.83019f, 61.465534f, 70.54477f, 61.83248f, 70.41808f);
generalPath.curveTo(62.199417f, 70.2914f, 62.50109f, 70.338196f, 62.737476f, 70.55844f);
generalPath.curveTo(62.973213f, 70.7781f, 63.041763f, 71.07625f, 62.943127f, 71.45292f);
generalPath.curveTo(62.844475f, 71.8296f, 62.58975f, 72.24f, 62.178932f, 72.68414f);
generalPath.curveTo(61.76926f, 73.12704f, 61.38039f, 73.41246f, 61.0123f, 73.54039f);
generalPath.curveTo(60.645363f, 73.66707f, 60.344025f, 73.62059f, 60.108276f, 73.40094f);
generalPath.curveTo(59.87189f, 73.180695f, 59.803017f, 72.882225f, 59.901665f, 72.50556f);
generalPath.curveTo(60.00145f, 72.127655f, 60.256176f, 71.71725f, 60.665848f, 71.27432f);
generalPath.moveTo(64.51818f, 68.599846f);
generalPath.lineTo(66.14919f, 68.33476f);
generalPath.lineTo(65.46278f, 69.07686f);
generalPath.lineTo(64.367226f, 69.25853f);
generalPath.lineTo(64.27315f, 70.363014f);
generalPath.lineTo(63.58333f, 71.108795f);
generalPath.lineTo(63.725643f, 69.45667f);
generalPath.lineTo(62.15916f, 69.71296f);
generalPath.lineTo(62.84727f, 68.96902f);
generalPath.lineTo(63.87685f, 68.80165f);
generalPath.lineTo(63.965027f, 67.76058f);
generalPath.lineTo(64.65656f, 67.01295f);
generalPath.lineTo(64.51818f, 68.599846f);
generalPath.moveTo(64.728455f, 66.93522f);
generalPath.lineTo(65.44908f, 66.15612f);
generalPath.lineTo(66.550735f, 66.01111f);
generalPath.lineTo(66.61305f, 64.89771f);
generalPath.lineTo(67.335396f, 64.11677f);
generalPath.lineTo(67.20541f, 65.95611f);
generalPath.lineTo(67.81983f, 66.52859f);
generalPath.lineTo(67.16081f, 67.24108f);
generalPath.lineTo(66.54639f, 66.66859f);
generalPath.lineTo(64.728455f, 66.93522f);
generalPath.moveTo(71.26493f, 62.585747f);
generalPath.curveTo(71.14618f, 62.80587f, 71.009766f, 63.022163f, 70.85569f, 63.234623f);
generalPath.curveTo(70.7016f, 63.447098f, 70.53041f, 63.655117f, 70.342125f, 63.858673f);
generalPath.curveTo(69.91647f, 64.318855f, 69.51154f, 64.62031f, 69.12732f, 64.76306f);
generalPath.curveTo(68.742455f, 64.90522f, 68.43377f, 64.867966f, 68.20129f, 64.65136f);
generalPath.curveTo(67.96619f, 64.43231f, 67.90791f, 64.12305f, 68.02646f, 63.72357f);
generalPath.curveTo(68.14498f, 63.32407f, 68.4245f, 62.886227f, 68.864975f, 62.410007f);
generalPath.curveTo(69.03501f, 62.226185f, 69.20674f, 62.05886f, 69.38017f, 61.90807f);
generalPath.curveTo(69.55474f, 61.756035f, 69.72897f, 61.622086f, 69.90286f, 61.50615f);
generalPath.lineTo(70.20471f, 61.787403f);
generalPath.curveTo(70.01582f, 61.898533f, 69.83924f, 62.019974f, 69.67494f, 62.151714f);
generalPath.curveTo(69.511795f, 62.28222f, 69.35945f, 62.42398f, 69.21796f, 62.576958f);
generalPath.curveTo(68.9555f, 62.860714f, 68.79495f, 63.11883f, 68.73631f, 63.35132f);
generalPath.curveTo(68.67817f, 63.581974f, 68.72691f, 63.769814f, 68.88255f, 63.914814f);
generalPath.curveTo(69.03689f, 64.058624f, 69.22454f, 64.09563f, 69.44549f, 64.02586f);
generalPath.curveTo(69.66642f, 63.95608f, 69.902985f, 63.784878f, 70.15518f, 63.51221f);
generalPath.curveTo(70.22364f, 63.438206f, 70.2847f, 63.367607f, 70.33834f, 63.300423f);
generalPath.curveTo(70.39247f, 63.231426f, 70.43773f, 63.166767f, 70.47408f, 63.106483f);
generalPath.lineTo(70.19081f, 62.842533f);
generalPath.lineTo(69.78855f, 63.27743f);
generalPath.lineTo(69.53654f, 63.042618f);
generalPath.lineTo(70.56357f, 61.932266f);
generalPath.lineTo(71.26493f, 62.585747f);
generalPath.moveTo(70.49352f, 60.702435f);
generalPath.lineTo(72.271996f, 58.77967f);
generalPath.lineTo(72.556244f, 59.044506f);
generalPath.lineTo(71.43678f, 60.254795f);
generalPath.lineTo(71.708336f, 60.507816f);
generalPath.lineTo(72.76105f, 59.369705f);
generalPath.lineTo(73.0453f, 59.634552f);
generalPath.lineTo(71.99259f, 60.772663f);
generalPath.lineTo(72.326675f, 61.08394f);
generalPath.lineTo(73.483795f, 59.832943f);
generalPath.lineTo(73.76805f, 60.097794f);
generalPath.lineTo(71.95191f, 62.061275f);
generalPath.lineTo(70.49352f, 60.702435f);
generalPath.moveTo(72.88993f, 58.1116f);
generalPath.lineTo(73.62597f, 57.31584f);
generalPath.lineTo(75.555695f, 57.24295f);
generalPath.lineTo(74.555435f, 56.31097f);
generalPath.lineTo(75.18021f, 55.63551f);
generalPath.lineTo(76.6386f, 56.99435f);
generalPath.lineTo(75.902565f, 57.790108f);
generalPath.lineTo(73.97283f, 57.862988f);
generalPath.lineTo(74.9731f, 58.79498f);
generalPath.lineTo(74.34832f, 59.47044f);
generalPath.lineTo(72.88993f, 58.1116f);
generalPath.moveTo(77.03914f, 53.62577f);
generalPath.lineTo(77.77517f, 52.830025f);
generalPath.lineTo(79.7049f, 52.757122f);
generalPath.lineTo(78.704636f, 51.825153f);
generalPath.lineTo(79.329414f, 51.14968f);
generalPath.lineTo(80.7878f, 52.50852f);
generalPath.lineTo(80.05177f, 53.304276f);
generalPath.lineTo(78.12203f, 53.377155f);
generalPath.lineTo(79.12231f, 54.30915f);
generalPath.lineTo(78.49753f, 54.98461f);
generalPath.lineTo(77.03914f, 53.62577f);
generalPath.moveTo(80.61079f, 49.711254f);
generalPath.curveTo(80.85386f, 49.448483f, 81.0817f, 49.27488f, 81.29436f, 49.190475f);
generalPath.curveTo(81.50815f, 49.104855f, 81.676895f, 49.119675f, 81.80064f, 49.234962f);
generalPath.curveTo(81.924355f, 49.350246f, 81.95186f, 49.51713f, 81.88313f, 49.735622f);
generalPath.curveTo(81.81441f, 49.954124f, 81.65794f, 50.195374f, 81.41374f, 50.45939f);
generalPath.curveTo(81.16953f, 50.72341f, 80.940865f, 50.89854f, 80.72772f, 50.98477f);
generalPath.curveTo(80.51573f, 51.06978f, 80.34786f, 51.054638f, 80.22414f, 50.939354f);
generalPath.curveTo(80.1004f, 50.82407f, 80.072586f, 50.656876f, 80.140656f, 50.437775f);
generalPath.curveTo(80.20988f, 50.217445f, 80.36659f, 49.97528f, 80.61079f, 49.711254f);
generalPath.moveTo(80.83062f, 51.3356f);
generalPath.lineTo(82.239365f, 49.81257f);
generalPath.lineTo(82.43472f, 49.99459f);
generalPath.lineTo(81.02598f, 51.51763f);
generalPath.lineTo(80.83062f, 51.3356f);
generalPath.moveTo(80.77685f, 49.865974f);
generalPath.curveTo(80.681f, 49.96962f, 80.62734f, 50.068924f, 80.61587f, 50.16389f);
generalPath.curveTo(80.60554f, 50.25764f, 80.63815f, 50.339703f, 80.71369f, 50.410088f);
generalPath.curveTo(80.78923f, 50.480473f, 80.87286f, 50.506714f, 80.9646f, 50.488815f);
generalPath.curveTo(81.05746f, 50.46969f, 81.151825f, 50.408302f, 81.24767f, 50.30466f);
generalPath.curveTo(81.3424f, 50.20227f, 81.39524f, 50.104504f, 81.40622f, 50.01136f);
generalPath.curveTo(81.418335f, 49.916992f, 81.38662f, 49.834614f, 81.31108f, 49.76423f);
generalPath.curveTo(81.23554f, 49.693848f, 81.15101f, 49.66792f, 81.05749f, 49.68644f);
generalPath.curveTo(80.96512f, 49.703743f, 80.87157f, 49.763584f, 80.77685f, 49.865974f);
generalPath.moveTo(85.14347f, 46.21668f);
generalPath.curveTo(85.34118f, 46.054058f, 85.51612f, 45.954056f, 85.6683f, 45.916676f);
generalPath.curveTo(85.82097f, 45.877464f, 85.945816f, 45.90306f, 86.04285f, 45.99347f);
generalPath.curveTo(86.187416f, 46.128166f, 86.20047f, 46.33557f, 86.082016f, 46.61569f);
generalPath.curveTo(85.96291f, 46.895203f, 85.71735f, 47.236057f, 85.34534f, 47.63825f);
generalPath.curveTo(85.21411f, 47.78013f, 85.076126f, 47.916866f, 84.93137f, 48.048443f);
generalPath.curveTo(84.78842f, 48.179405f, 84.64043f, 48.303364f, 84.48739f, 48.420326f);
generalPath.lineTo(84.19726f, 48.150005f);
generalPath.curveTo(84.355675f, 48.049538f, 84.50447f, 47.9424f, 84.64367f, 47.828613f);
generalPath.curveTo(84.783356f, 47.71299f, 84.91197f, 47.59164f, 85.0295f, 47.46457f);
generalPath.curveTo(85.204094f, 47.27581f, 85.32036f, 47.11538f, 85.37828f, 46.98329f);
generalPath.curveTo(85.43733f, 46.849964f, 85.43463f, 46.75327f, 85.370155f, 46.693195f);
generalPath.curveTo(85.303734f, 46.631313f, 85.20566f, 46.636402f, 85.07594f, 46.708485f);
generalPath.curveTo(84.94671f, 46.77873f, 84.7891f, 46.9144f, 84.60309f, 47.115498f);
generalPath.lineTo(84.339485f, 47.400486f);
generalPath.lineTo(84.09724f, 47.17477f);
generalPath.lineTo(84.374535f, 46.874977f);
generalPath.curveTo(84.54f, 46.69609f, 84.64859f, 46.5492f, 84.7003f, 46.43429f);
generalPath.curveTo(84.75137f, 46.31879f, 84.74662f, 46.232822f, 84.686066f, 46.176395f);
generalPath.curveTo(84.63005f, 46.12421f, 84.547386f, 46.126427f, 84.438034f, 46.183033f);
generalPath.curveTo(84.32869f, 46.239647f, 84.202126f, 46.345673f, 84.058334f, 46.501118f);
generalPath.curveTo(83.95222f, 46.615864f, 83.85178f, 46.738205f, 83.75705f, 46.86814f);
generalPath.curveTo(83.662315f, 46.998096f, 83.57467f, 47.13349f, 83.494095f, 47.27433f);
generalPath.lineTo(83.218636f, 47.017677f);
generalPath.curveTo(83.32789f, 46.857616f, 83.44121f, 46.703648f, 83.55859f, 46.55575f);
generalPath.curveTo(83.67598f, 46.407875f, 83.7963f, 46.267315f, 83.91954f, 46.134064f);
generalPath.curveTo(84.25162f, 45.77506f, 84.53107f, 45.535835f, 84.75791f, 45.416428f);
generalPath.curveTo(84.985245f, 45.295185f, 85.16143f, 45.29281f, 85.28646f, 45.4093f);
generalPath.curveTo(85.37177f, 45.488796f, 85.40241f, 45.596592f, 85.37837f, 45.73268f);
generalPath.curveTo(85.353676f, 45.86816f, 85.275375f, 46.0295f, 85.14347f, 46.21668f);
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(49.15303039550781, 75.31031799316406), new Point2D.Double(82.4846420288086, 75.31031799316406), new float[] {0.0f,1.0f}, new Color[] {new Color(180, 148, 42, 255),new Color(228, 220, 201, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.7891589999198914f, 0.0f, 0.0f, 0.7891589999198914f, 21.068540573120117f, 0.03497228026390076f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.6852189898490906f, 0.7283369898796082f, -0.7822719812393188f, 0.622937023639679f, 0.0f, 0.0f));
// _0_0_17_17
shape = new Rectangle2D.Double(70.87551879882812, -82.5947265625, 3.594980239868164, 0.7820525765419006);
paint = new RadialGradientPaint(new Point2D.Double(49.01197052001953, 2.6743078231811523), 1.7246193f, new Point2D.Double(49.01197052001953, 2.6743078231811523), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(37, 37, 37, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0422539710998535f, 0.0f, 0.0f, 0.12601399421691895f, 21.590139389038086f, -82.61791229248047f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-0.743170976638794f, -0.6691009998321533f, -0.6056519746780396f, 0.7957289814949036f, 0.0f, 0.0f));
// _0_0_17_18
shape = new Rectangle2D.Double(-102.7270736694336, -75.745849609375, 3.5949740409851074, 0.7820497751235962);
paint = new RadialGradientPaint(new Point2D.Double(49.01197052001953, 2.6743078231811523), 1.7246193f, new Point2D.Double(49.01197052001953, 2.6743078231811523), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(37, 37, 37, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.042253017425537f, 0.0f, 0.0f, 0.12601399421691895f, -152.01229858398438f, -75.76904296875f));
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
        return 3.9999637603759766;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 0.671695351600647;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 120.0;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 115.32830810546875;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private select_rectangular2() {
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
       select_rectangular2 base = new select_rectangular2();
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
       select_rectangular2 base = new select_rectangular2();
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
        return select_rectangular2::new;
    }
}

