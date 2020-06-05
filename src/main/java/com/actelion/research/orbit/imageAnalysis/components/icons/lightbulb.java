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
public class lightbulb implements ResizableIcon {
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
g.transform(new AffineTransform(0.003805798012763262f, 0.0f, 0.0f, 0.003805798012763262f, 0.19086266348300995f, -0.0f));
// _0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0
shape = new Rectangle2D.Double(72.34400177001953, 256.4100036621094, 19.038000106811523, 6.3460001945495605);
paint = new Color(110, 110, 110, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_1
shape = new Rectangle2D.Double(65.99800109863281, 252.60000610351562, 31.729000091552734, 6.3460001945495605);
paint = new RadialGradientPaint(new Point2D.Double(81.86299896240234, 255.77999877929688), 11.44f, new Point2D.Double(81.86299896240234, 255.77999877929688), new float[] {0.0f,1.0f}, new Color[] {new Color(207, 207, 207, 255),new Color(168, 168, 168, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(162.46f, 71.595f);
generalPath.curveTo(162.46f, 32.057f, 126.09f, 0.0f, 81.229f, 0.0f);
generalPath.curveTo(36.368f, 0.0f, 0.0f, 32.057f, 0.0f, 71.595f);
generalPath.curveTo(0.0f, 87.222f, 5.741f, 101.64f, 15.376f, 113.4f);
generalPath.curveTo(16.516f, 115.01f, 48.648f, 160.46f, 51.376f, 179.64f);
generalPath.curveTo(54.15f, 199.17f, 54.15f, 204.37f, 54.15f, 204.37f);
generalPath.lineTo(69.45f, 204.89f);
generalPath.lineTo(69.423f, 205.68f);
generalPath.lineTo(81.228f, 205.28f);
generalPath.lineTo(93.032f, 205.68f);
generalPath.lineTo(93.008f, 204.89f);
generalPath.lineTo(108.31f, 204.37f);
generalPath.curveTo(108.31f, 204.37f, 108.31f, 199.17f, 111.08f, 179.64f);
generalPath.curveTo(113.81f, 160.46f, 145.94f, 115.01f, 147.08f, 113.4f);
generalPath.curveTo(156.72f, 101.64f, 162.46f, 87.222f, 162.46f, 71.595f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(81.22799682617188, 102.83999633789062), 92.666f, new Point2D.Double(81.22799682617188, 102.83999633789062), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(205, 205, 205, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_3
paint = new Color(109, 104, 104, 255);
stroke = new BasicStroke(0.75f,0,0,4.0f,null,0.0f);
shape = new Line2D.Float(79.959000f,93.955002f,74.882004f,208.179993f);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_4
paint = new Color(109, 104, 104, 255);
stroke = new BasicStroke(0.75f,0,0,4.0f,null,0.0f);
shape = new Line2D.Float(83.766998f,93.955002f,86.305000f,208.179993f);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.26000002f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(81.229f, 0.0f);
generalPath.lineTo(80.792f, 3.277f);
generalPath.lineTo(82.894f, 19.072f);
generalPath.curveTo(82.161f, 19.206f, 81.511f, 19.369f, 80.792f, 19.508f);
generalPath.curveTo(175.54f, 37.956f, 123.11f, 109.18f, 123.11f, 109.18f);
generalPath.lineTo(93.032f, 205.68f);
generalPath.lineTo(108.31f, 204.37f);
generalPath.curveTo(101.11f, 182.8f, 138.34f, 123.14f, 138.34f, 123.14f);
generalPath.curveTo(210.69f, 14.0f, 81.229f, 0.0f, 81.229f, 0.0f);
generalPath.closePath();
shape = generalPath;
paint = new Color(188, 188, 188, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.26000002f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_6
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(80.792f, 3.277f);
generalPath.lineTo(80.355f, 0.0f);
generalPath.curveTo(80.355f, 0.0f, -49.105f, 13.996f, 23.242f, 123.15f);
generalPath.curveTo(23.242f, 123.15f, 60.47f, 182.8f, 53.278f, 204.37f);
generalPath.lineTo(68.55f, 205.68f);
generalPath.lineTo(38.472f, 109.18f);
generalPath.curveTo(38.472f, 109.18f, -13.957f, 37.957f, 80.791f, 19.509f);
generalPath.curveTo(80.072f, 19.37f, 79.423f, 19.207f, 78.688f, 19.073f);
generalPath.lineTo(80.792f, 3.277f);
generalPath.closePath();
shape = generalPath;
paint = new Color(188, 188, 188, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.26000002f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_7
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(80.792f, 3.277f);
generalPath.lineTo(78.689f, 19.072f);
generalPath.curveTo(79.423f, 19.206f, 80.073f, 19.369f, 80.792f, 19.508f);
generalPath.curveTo(81.511f, 19.369f, 82.16f, 19.206f, 82.894f, 19.072f);
generalPath.lineTo(80.792f, 3.277f);
generalPath.closePath();
shape = generalPath;
paint = new Color(188, 188, 188, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.26000002f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_8
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(80.792f, 3.277f);
generalPath.lineTo(78.689f, 19.072f);
generalPath.curveTo(79.423f, 19.206f, 80.073f, 19.369f, 80.792f, 19.508f);
generalPath.curveTo(81.511f, 19.369f, 82.16f, 19.206f, 82.894f, 19.072f);
generalPath.lineTo(80.792f, 3.277f);
generalPath.closePath();
shape = generalPath;
paint = new Color(188, 188, 188, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_9
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(44.699f, 12.747f);
generalPath.curveTo(44.699f, 12.747f, -12.646f, 56.137f, 12.032f, 99.798f);
generalPath.curveTo(32.248f, 140.11f, -7.651f, 60.943f, 44.699f, 12.747f);
generalPath.closePath();
shape = generalPath;
paint = new Color(188, 188, 188, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_10
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(109.78f, 210.36f);
generalPath.curveTo(109.78f, 214.56f, 106.37f, 217.97f, 102.17f, 217.97f);
generalPath.lineTo(60.286f, 217.97f);
generalPath.curveTo(56.08f, 217.97f, 52.671f, 214.56f, 52.671f, 210.36f);
generalPath.curveTo(52.671f, 206.15f, 56.08f, 202.74f, 60.286f, 202.74f);
generalPath.lineTo(102.17f, 202.74f);
generalPath.curveTo(106.37f, 202.74f, 109.78f, 206.15f, 109.78f, 210.36f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(81.22799682617188, 210.36000061035156), 20.899f, new Point2D.Double(81.22799682617188, 210.36000061035156), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(129, 129, 129, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_11
paint = new Color(109, 104, 104, 255);
stroke = new BasicStroke(0.75f,0,0,4.0f,null,0.0f);
shape = new Line2D.Float(109.779999f,204.009995f,52.671001f,204.009995f);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_12
shape = new Rectangle2D.Double(50.768001556396484, 216.38999938964844, 59.652000427246094, 6.3460001945495605);
paint = new RadialGradientPaint(new Point2D.Double(80.59400177001953, 219.55999755859375), 21.209f, new Point2D.Double(80.59400177001953, 219.55999755859375), new float[] {0.3315f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(161, 161, 161, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_13
paint = new Color(175, 175, 175, 255);
stroke = new BasicStroke(0.75f,0,0,4.0f,null,0.0f);
shape = new Line2D.Float(54.575001f,224.639999f,107.879997f,224.639999f);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_14
shape = new Rectangle2D.Double(50.768001556396484, 225.27000427246094, 59.652000427246094, 6.3460001945495605);
paint = new RadialGradientPaint(new Point2D.Double(80.59400177001953, 228.44000244140625), 21.209f, new Point2D.Double(80.59400177001953, 228.44000244140625), new float[] {0.3315f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(161, 161, 161, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_15
paint = new Color(175, 175, 175, 255);
stroke = new BasicStroke(0.75f,0,0,4.0f,null,0.0f);
shape = new Line2D.Float(54.575001f,233.520004f,107.879997f,233.520004f);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_16
shape = new Rectangle2D.Double(50.768001556396484, 234.16000366210938, 59.652000427246094, 6.3460001945495605);
paint = new RadialGradientPaint(new Point2D.Double(80.59400177001953, 237.3300018310547), 21.209f, new Point2D.Double(80.59400177001953, 237.3300018310547), new float[] {0.3315f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(161, 161, 161, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_17
paint = new Color(175, 175, 175, 255);
stroke = new BasicStroke(0.75f,0,0,4.0f,null,0.0f);
shape = new Line2D.Float(54.575001f,242.399994f,107.879997f,242.399994f);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_18
shape = new Rectangle2D.Double(50.768001556396484, 243.0399932861328, 59.652000427246094, 6.3460001945495605);
paint = new RadialGradientPaint(new Point2D.Double(80.59400177001953, 246.2100067138672), 21.209f, new Point2D.Double(80.59400177001953, 246.2100067138672), new float[] {0.3315f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(161, 161, 161, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_19
paint = new Color(175, 175, 175, 255);
stroke = new BasicStroke(0.75f,0,0,4.0f,null,0.0f);
shape = new Line2D.Float(54.575001f,251.289993f,107.879997f,251.289993f);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_20
paint = new Color(175, 175, 175, 255);
stroke = new BasicStroke(0.5f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(70.993f, 101.3f);
generalPath.curveTo(75.576f, 108.35f, 83.008f, 108.35f, 87.594f, 101.3f);
generalPath.curveTo(91.263f, 95.665f, 91.263f, 86.529f, 87.594f, 80.891f);
generalPath.curveTo(84.659f, 76.385f, 79.9f, 76.385f, 76.97f, 80.891f);
generalPath.curveTo(74.622f, 84.5f, 74.622f, 90.346f, 76.97f, 93.951f);
generalPath.curveTo(78.849f, 96.836f, 81.893f, 96.841f, 83.767f, 93.956f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.54f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_21
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(152.96f, 54.972f);
generalPath.curveTo(152.96f, 54.972f, 163.27f, 97.505f, 135.15f, 122.61f);
generalPath.curveTo(135.15f, 122.61f, 153.87f, 61.382f, 152.96f, 54.972f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(135.64999389648438, 84.55999755859375), 24.964f, new Point2D.Double(135.64999389648438, 84.55999755859375), new float[] {0.0f,1.0f}, new Color[] {new Color(207, 207, 207, 255),new Color(168, 168, 168, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9983999729156494f, 0.05649999901652336f, -0.05649999901652336f, 0.9983999729156494f, 14.907999992370605f, -3.211400032043457f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_22
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(80.848f, 18.4488f);
generalPath.curveTo(67.961f, 18.4488f, 57.479f, 28.9308f, 57.479f, 41.8178f);
generalPath.curveTo(57.4787f, 54.7048f, 67.961f, 65.1868f, 80.848f, 65.1868f);
generalPath.curveTo(93.735f, 65.1868f, 104.217f, 54.7048f, 104.217f, 41.8178f);
generalPath.curveTo(104.217f, 28.9308f, 93.735f, 18.4488f, 80.848f, 18.4488f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(10.017999649047852, 8.63070011138916), new Point2D.Double(63.487998962402344, 63.65999984741211), new float[] {0.0f,1.0f}, new Color[] {new Color(35, 107, 13, 255),new Color(10, 34, 5, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 48.847999572753906f, 9.818099975585938f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_23
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(103.348f, 41.8181f);
generalPath.curveTo(103.348f, 54.2381f, 93.268f, 64.3181f, 80.848f, 64.3181f);
generalPath.curveTo(68.428f, 64.3181f, 58.348f, 54.2381f, 58.348f, 41.8181f);
generalPath.curveTo(58.348f, 29.3981f, 68.428f, 19.3181f, 80.848f, 19.3181f);
generalPath.curveTo(93.268f, 19.3181f, 103.348f, 29.3981f, 103.348f, 41.8181f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(24.763999938964844, 16.36199951171875), 27.5f, new Point2D.Double(24.763999938964844, 16.36199951171875), new float[] {0.0f,1.0f}, new Color[] {new Color(46, 220, 50, 255),new Color(17, 102, 29, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.025213999673724174f, 1.0261000394821167f, -0.9781399965286255f, 0.0240470003336668f, 87.6780014038086f, 6.242400169372559f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_24
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(80.865f, 18.9743f);
generalPath.curveTo(71.423f, 18.9743f, 63.353f, 24.6831f, 59.91f, 32.7873f);
generalPath.curveTo(64.854f, 35.6203f, 70.241f, 37.6743f, 76.029f, 37.4123f);
generalPath.curveTo(81.603f, 37.0983f, 86.402f, 33.3493f, 92.085f, 33.6303f);
generalPath.curveTo(96.299f, 33.5343f, 101.092f, 35.1123f, 103.337f, 38.8183f);
generalPath.curveTo(101.991f, 27.6653f, 92.506f, 18.9743f, 80.865f, 18.9743f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(18.386999130249023, 14.04699993133545), 27.5f, new Point2D.Double(18.386999130249023, 14.04699993133545), new float[] {0.0f,1.0f}, new Color[] {new Color(230, 230, 230, 255),new Color(17, 102, 29, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.01142400037497282f, 1.0987999439239502f, -1.843999981880188f, 0.01878800056874752f, 100.9990005493164f, 4.150700092315674f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_25
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(80.848f, 18.4431f);
generalPath.curveTo(67.961f, 18.4431f, 57.473f, 28.9311f, 57.473f, 41.8181f);
generalPath.curveTo(57.473f, 54.7051f, 67.961f, 65.1931f, 80.848f, 65.1931f);
generalPath.curveTo(93.735f, 65.1931f, 104.223f, 54.7051f, 104.223f, 41.8181f);
generalPath.curveTo(104.223f, 28.9311f, 93.735f, 18.4431f, 80.848f, 18.4431f);
generalPath.closePath();
generalPath.moveTo(80.848f, 19.3181f);
generalPath.curveTo(93.268f, 19.3181f, 103.348f, 29.3981f, 103.348f, 41.8181f);
generalPath.curveTo(103.348f, 54.2381f, 93.268f, 64.3181f, 80.848f, 64.3181f);
generalPath.curveTo(68.428f, 64.3181f, 58.348f, 54.2381f, 58.348f, 41.8181f);
generalPath.curveTo(58.348f, 29.3981f, 68.428f, 19.3181f, 80.848f, 19.3181f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(10.017999649047852, 8.63070011138916), new Point2D.Double(63.487998962402344, 63.65999984741211), new float[] {0.0f,1.0f}, new Color[] {new Color(35, 107, 13, 255),new Color(10, 34, 5, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 48.845157623291016f, 9.815258979797363f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_26
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(84.66779f, 37.08251f);
generalPath.lineTo(81.96077f, 37.08251f);
generalPath.lineTo(74.276596f, 38.358326f);
generalPath.lineTo(74.276596f, 41.89296f);
generalPath.lineTo(75.1933f, 41.97662f);
generalPath.curveTo(77.07084f, 42.14394f, 77.59476f, 42.89688f, 77.59476f, 45.553085f);
generalPath.lineTo(77.59476f, 51.8485f);
generalPath.curveTo(77.59476f, 54.337383f, 77.332695f, 54.81843f, 75.67372f, 55.15307f);
generalPath.lineTo(74.276596f, 55.466797f);
generalPath.lineTo(74.276596f, 59.00143f);
generalPath.lineTo(87.942245f, 59.00143f);
generalPath.lineTo(87.942245f, 55.466797f);
generalPath.lineTo(86.58884f, 55.15307f);
generalPath.curveTo(84.92965f, 54.7766f, 84.66779f, 54.337383f, 84.66779f, 51.8485f);
generalPath.lineTo(84.66779f, 37.08251f);
generalPath.moveTo(80.86921f, 27.12697f);
generalPath.curveTo(78.555176f, 27.12697f, 76.54692f, 29.09298f, 76.54692f, 31.414545f);
generalPath.curveTo(76.54692f, 33.715195f, 78.38054f, 35.597546f, 80.69457f, 35.597546f);
generalPath.curveTo(83.05232f, 35.597546f, 85.017075f, 33.631535f, 85.017075f, 31.26814f);
generalPath.curveTo(85.017075f, 28.96749f, 83.22696f, 27.12697f, 80.86921f, 27.12697f);
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(-0.566860020160675, 22.650999069213867), new Point2D.Double(-0.3371399939060211, 23.858999252319336), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(200, 200, 200, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(20.915000915527344f, 0.0f, 0.0f, 20.915000915527344f, 90.96299743652344f, -445.0918884277344f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_27
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(80.848f, 18.4488f);
generalPath.curveTo(67.961f, 18.4488f, 57.479f, 28.9308f, 57.479f, 41.8178f);
generalPath.curveTo(57.4787f, 54.7048f, 67.961f, 65.1868f, 80.848f, 65.1868f);
generalPath.curveTo(93.735f, 65.1868f, 104.217f, 54.7048f, 104.217f, 41.8178f);
generalPath.curveTo(104.217f, 28.9308f, 93.735f, 18.4488f, 80.848f, 18.4488f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(10.017999649047852, 8.63070011138916), new Point2D.Double(63.487998962402344, 63.65999984741211), new float[] {0.0f,1.0f}, new Color[] {new Color(35, 107, 13, 255),new Color(10, 34, 5, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 48.847999572753906f, 9.818099975585938f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_28
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(103.348f, 41.8181f);
generalPath.curveTo(103.348f, 54.2381f, 93.268f, 64.3181f, 80.848f, 64.3181f);
generalPath.curveTo(68.428f, 64.3181f, 58.348f, 54.2381f, 58.348f, 41.8181f);
generalPath.curveTo(58.348f, 29.3981f, 68.428f, 19.3181f, 80.848f, 19.3181f);
generalPath.curveTo(93.268f, 19.3181f, 103.348f, 29.3981f, 103.348f, 41.8181f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(24.763999938964844, 16.36199951171875), 27.5f, new Point2D.Double(24.763999938964844, 16.36199951171875), new float[] {0.0f,1.0f}, new Color[] {new Color(46, 220, 50, 255),new Color(17, 102, 29, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.025213999673724174f, 1.0261000394821167f, -0.9781399965286255f, 0.0240470003336668f, 87.6780014038086f, 6.242400169372559f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_29
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(80.865f, 18.9743f);
generalPath.curveTo(71.423f, 18.9743f, 63.353f, 24.6831f, 59.91f, 32.7873f);
generalPath.curveTo(64.854f, 35.6203f, 70.241f, 37.6743f, 76.029f, 37.4123f);
generalPath.curveTo(81.603f, 37.0983f, 86.402f, 33.3493f, 92.085f, 33.6303f);
generalPath.curveTo(96.299f, 33.5343f, 101.092f, 35.1123f, 103.337f, 38.8183f);
generalPath.curveTo(101.991f, 27.6653f, 92.506f, 18.9743f, 80.865f, 18.9743f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(18.386999130249023, 14.04699993133545), 27.5f, new Point2D.Double(18.386999130249023, 14.04699993133545), new float[] {0.0f,1.0f}, new Color[] {new Color(230, 230, 230, 255),new Color(17, 102, 29, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.01142400037497282f, 1.0987999439239502f, -1.843999981880188f, 0.01878800056874752f, 100.9990005493164f, 4.150700092315674f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_30
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(80.848f, 18.4431f);
generalPath.curveTo(67.961f, 18.4431f, 57.473f, 28.9311f, 57.473f, 41.8181f);
generalPath.curveTo(57.473f, 54.7051f, 67.961f, 65.1931f, 80.848f, 65.1931f);
generalPath.curveTo(93.735f, 65.1931f, 104.223f, 54.7051f, 104.223f, 41.8181f);
generalPath.curveTo(104.223f, 28.9311f, 93.735f, 18.4431f, 80.848f, 18.4431f);
generalPath.closePath();
generalPath.moveTo(80.848f, 19.3181f);
generalPath.curveTo(93.268f, 19.3181f, 103.348f, 29.3981f, 103.348f, 41.8181f);
generalPath.curveTo(103.348f, 54.2381f, 93.268f, 64.3181f, 80.848f, 64.3181f);
generalPath.curveTo(68.428f, 64.3181f, 58.348f, 54.2381f, 58.348f, 41.8181f);
generalPath.curveTo(58.348f, 29.3981f, 68.428f, 19.3181f, 80.848f, 19.3181f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(10.017999649047852, 8.63070011138916), new Point2D.Double(63.487998962402344, 63.65999984741211), new float[] {0.0f,1.0f}, new Color[] {new Color(35, 107, 13, 255),new Color(10, 34, 5, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 48.845157623291016f, 9.815258979797363f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_31
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(84.66779f, 37.08251f);
generalPath.lineTo(81.96077f, 37.08251f);
generalPath.lineTo(74.276596f, 38.358326f);
generalPath.lineTo(74.276596f, 41.89296f);
generalPath.lineTo(75.1933f, 41.97662f);
generalPath.curveTo(77.07084f, 42.14394f, 77.59476f, 42.89688f, 77.59476f, 45.553085f);
generalPath.lineTo(77.59476f, 51.8485f);
generalPath.curveTo(77.59476f, 54.337383f, 77.332695f, 54.81843f, 75.67372f, 55.15307f);
generalPath.lineTo(74.276596f, 55.466797f);
generalPath.lineTo(74.276596f, 59.00143f);
generalPath.lineTo(87.942245f, 59.00143f);
generalPath.lineTo(87.942245f, 55.466797f);
generalPath.lineTo(86.58884f, 55.15307f);
generalPath.curveTo(84.92965f, 54.7766f, 84.66779f, 54.337383f, 84.66779f, 51.8485f);
generalPath.lineTo(84.66779f, 37.08251f);
generalPath.moveTo(80.86921f, 27.12697f);
generalPath.curveTo(78.555176f, 27.12697f, 76.54692f, 29.09298f, 76.54692f, 31.414545f);
generalPath.curveTo(76.54692f, 33.715195f, 78.38054f, 35.597546f, 80.69457f, 35.597546f);
generalPath.curveTo(83.05232f, 35.597546f, 85.017075f, 33.631535f, 85.017075f, 31.26814f);
generalPath.curveTo(85.017075f, 28.96749f, 83.22696f, 27.12697f, 80.86921f, 27.12697f);
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(-0.566860020160675, 22.650999069213867), new Point2D.Double(-0.3371399939060211, 23.858999252319336), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(200, 200, 200, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(20.915000915527344f, 0.0f, 0.0f, 20.915000915527344f, 90.96299743652344f, -445.0918884277344f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_32
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(80.847f, 12.880036f);
generalPath.curveTo(51.053547f, 12.880036f, 26.82021f, 35.86392f, 26.82021f, 64.12124f);
generalPath.curveTo(26.819515f, 92.37857f, 51.053547f, 115.36245f, 80.847f, 115.36245f);
generalPath.curveTo(110.64046f, 115.36245f, 134.8738f, 92.37857f, 134.8738f, 64.12124f);
generalPath.curveTo(134.8738f, 35.86392f, 110.64046f, 12.880036f, 80.847f, 12.880036f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(10.017999649047852, 8.63070011138916), new Point2D.Double(63.487998962402344, 63.65999984741211), new float[] {0.0f,1.0f}, new Color[] {new Color(35, 107, 13, 255),new Color(10, 34, 5, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(2.3118999004364014f, 0.0f, 0.0f, 2.192699909210205f, 6.866199970245361f, -6.04449987411499f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_33
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(132.86475f, 64.1219f);
generalPath.curveTo(132.86475f, 91.35523f, 109.5608f, 113.45765f, 80.847f, 113.45765f);
generalPath.curveTo(52.1332f, 113.45765f, 28.82925f, 91.35523f, 28.82925f, 64.1219f);
generalPath.curveTo(28.82925f, 36.888565f, 52.1332f, 14.78615f, 80.847f, 14.78615f);
generalPath.curveTo(109.5608f, 14.78615f, 132.86475f, 36.888565f, 132.86475f, 64.1219f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(24.763999938964844, 16.36199951171875), 27.5f, new Point2D.Double(24.763999938964844, 16.36199951171875), new float[] {0.0f,1.0f}, new Color[] {new Color(46, 220, 50, 255),new Color(17, 102, 29, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.05829225108027458f, 2.249929428100586f, -2.261361837387085f, 0.05272785946726799f, 96.63727569580078f, -13.884937286376953f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_34
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(80.88631f, 14.0323f);
generalPath.curveTo(59.057343f, 14.0323f, 40.40031f, 26.549986f, 32.440437f, 44.320065f);
generalPath.curveTo(43.870472f, 50.531982f, 56.324677f, 55.03579f, 69.705956f, 54.461304f);
generalPath.curveTo(82.59248f, 53.772797f, 93.687294f, 45.55236f, 106.82582f, 46.16851f);
generalPath.curveTo(116.56817f, 45.95801f, 127.6491f, 49.41809f, 132.83932f, 57.54424f);
generalPath.curveTo(129.7275f, 33.089054f, 107.79913f, 14.0323f, 80.88631f, 14.0323f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(18.386999130249023, 14.04699993133545), 27.5f, new Point2D.Double(18.386999130249023, 14.04699993133545), new float[] {0.0f,1.0f}, new Color[] {new Color(230, 230, 230, 255),new Color(17, 102, 29, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.02641114965081215f, 2.4093387126922607f, -4.263143539428711f, 0.04119645059108734f, 127.43409729003906f, -18.47140884399414f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_35
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(80.847f, 12.867538f);
generalPath.curveTo(51.053547f, 12.867538f, 26.806337f, 35.864574f, 26.806337f, 64.1219f);
generalPath.curveTo(26.806337f, 92.37923f, 51.053547f, 115.37626f, 80.847f, 115.37626f);
generalPath.curveTo(110.64046f, 115.37626f, 134.88766f, 92.37923f, 134.88766f, 64.1219f);
generalPath.curveTo(134.88766f, 35.864574f, 110.64046f, 12.867538f, 80.847f, 12.867538f);
generalPath.closePath();
generalPath.moveTo(80.847f, 14.78615f);
generalPath.curveTo(109.5608f, 14.78615f, 132.86475f, 36.888565f, 132.86475f, 64.1219f);
generalPath.curveTo(132.86475f, 91.35523f, 109.5608f, 113.45765f, 80.847f, 113.45765f);
generalPath.curveTo(52.1332f, 113.45765f, 28.82925f, 91.35523f, 28.82925f, 64.1219f);
generalPath.curveTo(28.82925f, 36.888565f, 52.1332f, 14.78615f, 80.847f, 14.78615f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(10.017999649047852, 8.63070011138916), new Point2D.Double(63.487998962402344, 63.65999984741211), new float[] {0.0f,1.0f}, new Color[] {new Color(35, 107, 13, 255),new Color(10, 34, 5, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(2.3118999004364014f, 0.0f, 0.0f, 2.192699909210205f, 6.8596320152282715f, -6.050729274749756f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_36
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(89.677986f, 53.738117f);
generalPath.lineTo(83.41961f, 53.738117f);
generalPath.lineTo(65.65457f, 56.5356f);
generalPath.lineTo(65.65457f, 64.28599f);
generalPath.lineTo(67.7739f, 64.46943f);
generalPath.curveTo(72.114586f, 64.83631f, 73.325836f, 66.48729f, 73.325836f, 72.31155f);
generalPath.lineTo(73.325836f, 86.1155f);
generalPath.curveTo(73.325836f, 91.57288f, 72.71997f, 92.62767f, 68.884575f, 93.361435f);
generalPath.lineTo(65.65457f, 94.04934f);
generalPath.lineTo(65.65457f, 101.79973f);
generalPath.lineTo(97.24819f, 101.79973f);
generalPath.lineTo(97.24819f, 94.04934f);
generalPath.lineTo(94.11924f, 93.361435f);
generalPath.curveTo(90.28337f, 92.53595f, 89.677986f, 91.57288f, 89.677986f, 86.1155f);
generalPath.lineTo(89.677986f, 53.738117f);
generalPath.moveTo(80.89604f, 31.908606f);
generalPath.curveTo(75.54623f, 31.908606f, 70.90333f, 36.219475f, 70.90333f, 41.30997f);
generalPath.curveTo(70.90333f, 46.354607f, 75.14247f, 50.482037f, 80.492294f, 50.482037f);
generalPath.curveTo(85.94317f, 50.482037f, 90.48549f, 46.171165f, 90.48549f, 40.98895f);
generalPath.curveTo(90.48549f, 35.944313f, 86.34692f, 31.908606f, 80.89604f, 31.908606f);
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(-0.566860020160675, 22.650999069213867), new Point2D.Double(-0.3371399939060211, 23.858999252319336), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(200, 200, 200, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(48.353389739990234f, 0.0f, 0.0f, 45.860321044921875f, 104.23187255859375f, -1003.5256958007812f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_37
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(80.847f, 12.880036f);
generalPath.curveTo(51.053547f, 12.880036f, 26.82021f, 35.86392f, 26.82021f, 64.12124f);
generalPath.curveTo(26.819515f, 92.37857f, 51.053547f, 115.36245f, 80.847f, 115.36245f);
generalPath.curveTo(110.64046f, 115.36245f, 134.8738f, 92.37857f, 134.8738f, 64.12124f);
generalPath.curveTo(134.8738f, 35.86392f, 110.64046f, 12.880036f, 80.847f, 12.880036f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(10.017999649047852, 8.63070011138916), new Point2D.Double(63.487998962402344, 63.65999984741211), new float[] {0.0f,1.0f}, new Color[] {new Color(35, 107, 13, 255),new Color(10, 34, 5, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(2.3118999004364014f, 0.0f, 0.0f, 2.192699909210205f, 6.866199970245361f, -6.04449987411499f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_38
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(132.86475f, 64.1219f);
generalPath.curveTo(132.86475f, 91.35523f, 109.5608f, 113.45765f, 80.847f, 113.45765f);
generalPath.curveTo(52.1332f, 113.45765f, 28.82925f, 91.35523f, 28.82925f, 64.1219f);
generalPath.curveTo(28.82925f, 36.888565f, 52.1332f, 14.78615f, 80.847f, 14.78615f);
generalPath.curveTo(109.5608f, 14.78615f, 132.86475f, 36.888565f, 132.86475f, 64.1219f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(24.763999938964844, 16.36199951171875), 27.5f, new Point2D.Double(24.763999938964844, 16.36199951171875), new float[] {0.0f,1.0f}, new Color[] {new Color(46, 220, 50, 255),new Color(17, 102, 29, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.05829225108027458f, 2.249929428100586f, -2.261361837387085f, 0.05272785946726799f, 96.63727569580078f, -13.884937286376953f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_39
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(80.88631f, 14.0323f);
generalPath.curveTo(59.057343f, 14.0323f, 40.40031f, 26.549986f, 32.440437f, 44.320065f);
generalPath.curveTo(43.870472f, 50.531982f, 56.324677f, 55.03579f, 69.705956f, 54.461304f);
generalPath.curveTo(82.59248f, 53.772797f, 93.687294f, 45.55236f, 106.82582f, 46.16851f);
generalPath.curveTo(116.56817f, 45.95801f, 127.6491f, 49.41809f, 132.83932f, 57.54424f);
generalPath.curveTo(129.7275f, 33.089054f, 107.79913f, 14.0323f, 80.88631f, 14.0323f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(18.386999130249023, 14.04699993133545), 27.5f, new Point2D.Double(18.386999130249023, 14.04699993133545), new float[] {0.0f,1.0f}, new Color[] {new Color(230, 230, 230, 255),new Color(17, 102, 29, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.02641114965081215f, 2.4093387126922607f, -4.263143539428711f, 0.04119645059108734f, 127.43409729003906f, -18.47140884399414f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_40
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(80.847f, 12.867538f);
generalPath.curveTo(51.053547f, 12.867538f, 26.806337f, 35.864574f, 26.806337f, 64.1219f);
generalPath.curveTo(26.806337f, 92.37923f, 51.053547f, 115.37626f, 80.847f, 115.37626f);
generalPath.curveTo(110.64046f, 115.37626f, 134.88766f, 92.37923f, 134.88766f, 64.1219f);
generalPath.curveTo(134.88766f, 35.864574f, 110.64046f, 12.867538f, 80.847f, 12.867538f);
generalPath.closePath();
generalPath.moveTo(80.847f, 14.78615f);
generalPath.curveTo(109.5608f, 14.78615f, 132.86475f, 36.888565f, 132.86475f, 64.1219f);
generalPath.curveTo(132.86475f, 91.35523f, 109.5608f, 113.45765f, 80.847f, 113.45765f);
generalPath.curveTo(52.1332f, 113.45765f, 28.82925f, 91.35523f, 28.82925f, 64.1219f);
generalPath.curveTo(28.82925f, 36.888565f, 52.1332f, 14.78615f, 80.847f, 14.78615f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(10.017999649047852, 8.63070011138916), new Point2D.Double(63.487998962402344, 63.65999984741211), new float[] {0.0f,1.0f}, new Color[] {new Color(35, 107, 13, 255),new Color(10, 34, 5, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(2.3118999004364014f, 0.0f, 0.0f, 2.192699909210205f, 6.8596320152282715f, -6.050729274749756f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_41
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(89.677986f, 53.738117f);
generalPath.lineTo(83.41961f, 53.738117f);
generalPath.lineTo(65.65457f, 56.5356f);
generalPath.lineTo(65.65457f, 64.28599f);
generalPath.lineTo(67.7739f, 64.46943f);
generalPath.curveTo(72.114586f, 64.83631f, 73.325836f, 66.48729f, 73.325836f, 72.31155f);
generalPath.lineTo(73.325836f, 86.1155f);
generalPath.curveTo(73.325836f, 91.57288f, 72.71997f, 92.62767f, 68.884575f, 93.361435f);
generalPath.lineTo(65.65457f, 94.04934f);
generalPath.lineTo(65.65457f, 101.79973f);
generalPath.lineTo(97.24819f, 101.79973f);
generalPath.lineTo(97.24819f, 94.04934f);
generalPath.lineTo(94.11924f, 93.361435f);
generalPath.curveTo(90.28337f, 92.53595f, 89.677986f, 91.57288f, 89.677986f, 86.1155f);
generalPath.lineTo(89.677986f, 53.738117f);
generalPath.moveTo(80.89604f, 31.908606f);
generalPath.curveTo(75.54623f, 31.908606f, 70.90333f, 36.219475f, 70.90333f, 41.30997f);
generalPath.curveTo(70.90333f, 46.354607f, 75.14247f, 50.482037f, 80.492294f, 50.482037f);
generalPath.curveTo(85.94317f, 50.482037f, 90.48549f, 46.171165f, 90.48549f, 40.98895f);
generalPath.curveTo(90.48549f, 35.944313f, 86.34692f, 31.908606f, 80.89604f, 31.908606f);
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(-0.566860020160675, 22.650999069213867), new Point2D.Double(-0.3371399939060211, 23.858999252319336), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(200, 200, 200, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(48.353389739990234f, 0.0f, 0.0f, 45.860321044921875f, 104.23187255859375f, -1003.5256958007812f));
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
        return 0.003978953696787357;
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
		return 0.988727331161499;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 0.9999963045120239;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private lightbulb() {
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
       lightbulb base = new lightbulb();
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
       lightbulb base = new lightbulb();
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
        return lightbulb::new;
    }
}

