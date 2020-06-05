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
public class go_up_7 implements ResizableIcon {
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
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(115.79764f, 73.2345f);
generalPath.lineTo(66.8153f, 5.5676837f);
generalPath.curveTo(66.11003f, 4.584344f, 65.06503f, 4.0157437f, 63.96308f, 4.0157437f);
generalPath.curveTo(62.86113f, 4.0157437f, 61.816135f, 4.584344f, 61.110867f, 5.5676837f);
generalPath.lineTo(12.137772f, 73.922f);
generalPath.curveTo(9.507381f, 78.06512f, 9.134662f, 84.01575f, 14.963082f, 84.01575f);
generalPath.lineTo(39.963078f, 84.01575f);
generalPath.lineTo(39.963078f, 116.01574f);
generalPath.curveTo(39.962425f, 118.39778f, 41.91203f, 120.0165f, 43.96308f, 120.01574f);
generalPath.lineTo(83.96308f, 120.01574f);
generalPath.curveTo(86.01413f, 120.0165f, 87.96374f, 118.39778f, 87.96308f, 116.01574f);
generalPath.lineTo(87.96308f, 84.01575f);
generalPath.lineTo(111.96309f, 84.01575f);
generalPath.curveTo(115.85422f, 84.01575f, 118.51638f, 76.995224f, 115.79764f, 73.2345f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(194.5, 123.90682983398438), new Point2D.Double(104.25, 5.15595817565918), new float[] {0.0f,1.0f}, new Color[] {new Color(8, 30, 62, 255),new Color(56, 125, 228, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.0f, 1.0f, -0.861046314239502f, 0.0f, 129.39927673339844f, -107.98426055908203f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.25468165f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(115.79764f, 73.2345f);
generalPath.lineTo(66.8153f, 5.5676837f);
generalPath.curveTo(66.11003f, 4.584344f, 65.06503f, 4.0157437f, 63.96308f, 4.0157437f);
generalPath.curveTo(62.86113f, 4.0157437f, 61.816135f, 4.584344f, 61.110867f, 5.5676837f);
generalPath.lineTo(12.137772f, 73.922f);
generalPath.curveTo(9.507381f, 78.06512f, 9.134662f, 84.01575f, 14.963082f, 84.01575f);
generalPath.lineTo(39.963078f, 84.01575f);
generalPath.lineTo(39.963078f, 116.01574f);
generalPath.curveTo(39.962425f, 118.39778f, 41.91203f, 120.0165f, 43.96308f, 120.01574f);
generalPath.lineTo(83.96308f, 120.01574f);
generalPath.curveTo(86.01413f, 120.0165f, 87.96374f, 118.39778f, 87.96308f, 116.01574f);
generalPath.lineTo(87.96308f, 84.01575f);
generalPath.lineTo(111.96309f, 84.01575f);
generalPath.curveTo(115.85422f, 84.01575f, 118.51638f, 76.995224f, 115.79764f, 73.2345f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(-16.668487548828125, 86.82696533203125), 60.0f, new Point2D.Double(-16.668487548828125, 86.82696533203125), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.521247386932373f, 0.2586607038974762f, -0.41060110926628113f, 0.8274344205856323f, 77.90748596191406f, -35.523704528808594f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.0f, 1.0f, -1.0f, 0.0f, 127.96308898925781f, 0.015743745490908623f));
// _0_0_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(76.5f, 11.0625f);
generalPath.curveTo(75.42291f, 11.127783f, 74.3861f, 11.439286f, 73.5f, 12.0f);
generalPath.lineTo(75.875f, 19.625f);
generalPath.lineTo(84.0f, 16.46875f);
generalPath.lineTo(84.0f, 16.0f);
generalPath.curveTo(84.0f, 13.081648f, 80.06108f, 10.84666f, 76.5f, 11.0625f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(73.74263763427734, 15.336544036865234), new Point2D.Double(78.93933868408203, 16.75075912475586), new float[] {0.0f,1.0f}, new Color[] {new Color(99, 233, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 4.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.6142322f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.0f, 1.0f, 1.0f, 0.0f, -0.16191840171813965f, 0.015743745490908623f));
// _0_0_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(115.65112f, 40.0f);
generalPath.curveTo(115.31168f, 41.15456f, 113.08862f, 46.125f, 113.08862f, 46.125f);
generalPath.lineTo(119.83862f, 46.09375f);
generalPath.lineTo(119.83862f, 44.0f);
generalPath.curveTo(119.83938f, 41.94895f, 118.22066f, 39.999344f, 115.83862f, 40.0f);
generalPath.lineTo(115.65112f, 40.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(223.32711791992188, 53.78415298461914), new Point2D.Double(226.65899658203125, 57.279232025146484), new float[] {0.0f,1.0f}, new Color[] {new Color(99, 233, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.861046314239502f, -108.161376953125f, -1.436186671257019f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(115.79764f, 73.2345f);
generalPath.lineTo(66.8153f, 5.5676837f);
generalPath.curveTo(66.11003f, 4.584344f, 65.06503f, 4.0157437f, 63.96308f, 4.0157437f);
generalPath.curveTo(62.86113f, 4.0157437f, 61.816135f, 4.584344f, 61.110867f, 5.5676837f);
generalPath.lineTo(12.137772f, 73.922f);
generalPath.curveTo(9.507381f, 78.06512f, 9.134662f, 84.01575f, 14.963082f, 84.01575f);
generalPath.lineTo(39.963078f, 84.01575f);
generalPath.lineTo(39.963078f, 116.01574f);
generalPath.curveTo(39.962425f, 118.39778f, 41.91203f, 120.0165f, 43.96308f, 120.01574f);
generalPath.lineTo(83.96308f, 120.01574f);
generalPath.curveTo(86.01413f, 120.0165f, 87.96374f, 118.39778f, 87.96308f, 116.01574f);
generalPath.lineTo(87.96308f, 84.01575f);
generalPath.lineTo(111.96309f, 84.01575f);
generalPath.curveTo(115.85422f, 84.01575f, 118.51638f, 76.995224f, 115.79764f, 73.2345f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(79.40702056884766, 56.84811782836914), 60.0f, new Point2D.Double(79.40702056884766, 56.84811782836914), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-0.01767767034471035f, 0.5816285014152527f, -0.8878982067108154f, -0.026986248791217804f, 122.02117919921875f, 31.937589645385742f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.70411986f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.0f, 0.8316411972045898f, 1.0f, 0.0f, -0.8210684061050415f, 17.48444366455078f));
// _0_0_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(72.5f, 11.0625f);
generalPath.curveTo(71.42291f, 11.127783f, 70.3861f, 11.439286f, 69.5f, 12.0f);
generalPath.lineTo(71.875f, 19.625f);
generalPath.lineTo(80.0f, 16.46875f);
generalPath.lineTo(80.0f, 16.0f);
generalPath.curveTo(80.0f, 13.081648f, 76.06108f, 10.84666f, 72.5f, 11.0625f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(74.75, 14.275883674621582), new Point2D.Double(78.93933868408203, 16.75075912475586), new float[] {0.0f,1.0f}, new Color[] {new Color(99, 233, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7490637f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9995971918106079f, -0.028382137417793274f, -0.028382137417793274f, -0.9995971918106079f, -30.523448944091797f, 163.1337890625f));
// _0_0_6
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(115.65112f, 40.0f);
generalPath.curveTo(115.31168f, 41.15456f, 113.08862f, 46.125f, 113.08862f, 46.125f);
generalPath.lineTo(119.83862f, 46.09375f);
generalPath.lineTo(119.83862f, 44.0f);
generalPath.curveTo(119.83938f, 41.94895f, 118.22066f, 39.999344f, 115.83862f, 40.0f);
generalPath.lineTo(115.65112f, 40.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(223.32711791992188, 53.78415298461914), new Point2D.Double(226.65899658203125, 57.279232025146484), new float[] {0.0f,1.0f}, new Color[] {new Color(99, 233, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.861046314239502f, -108.161376953125f, -1.436186671257019f));
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
generalPath.moveTo(61.556484f, 5.221757f);
generalPath.curveTo(63.245625f, 3.7628596f, 64.797745f, 4.1537676f, 66.30962f, 5.087866f);
generalPath.lineTo(64.06695f, 10.476987f);
generalPath.lineTo(61.556484f, 5.221757f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(63.93305587768555, 7.566767692565918), new Point2D.Double(66.20711517333984, 7.566767692565918), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.0f, 1.0f, -0.8609864711761475f, 0.0f, 129.39805603027344f, -107.98426055908203f));
// _0_0_8
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(181.55045f, 21.46494f);
generalPath.lineTo(117.50547f, 73.80696f);
generalPath.curveTo(116.11967f, 75.416504f, 116.3415f, 76.82814f, 117.40303f, 78.061066f);
generalPath.lineTo(180.0f, 129.07866f);
generalPath.curveTo(184.0f, 132.6608f, 188.0f, 132.85188f, 188.0f, 129.07866f);
generalPath.lineTo(188.0f, 99.22917f);
generalPath.lineTo(224.0f, 99.22917f);
generalPath.lineTo(224.0f, 52.770836f);
generalPath.lineTo(188.0f, 52.770836f);
generalPath.lineTo(188.0f, 23.929232f);
generalPath.curveTo(188.0f, 20.73836f, 184.84714f, 19.254284f, 181.55045f, 21.46494f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(212.7331085205078, 76.10952758789062), 56.0f, new Point2D.Double(212.7331085205078, 76.10952758789062), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(159, 193, 242, 255),new Color(88, 126, 181, 255),new Color(12, 42, 88, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.1383929252624512f, 0.0f, -10.51785659790039f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.0f, 1.0f, -0.8609864711761475f, 0.0f, 129.59805297851562f, -205.18728637695312f));
// _0_0_9
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9_0
paint = new LinearGradientPaint(new Point2D.Double(213.6340789794922, 59.980953216552734), new Point2D.Double(165.2705841064453, 60.609806060791016), new float[] {0.0f,1.0f}, new Color[] {new Color(99, 233, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 97.0f, 0.0f));
stroke = new BasicStroke(1.0777098f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(278.55045f, 21.46494f);
generalPath.lineTo(214.10547f, 73.80696f);
generalPath.curveTo(212.71967f, 75.416504f, 212.9415f, 76.82814f, 214.00304f, 78.061066f);
generalPath.lineTo(277.0f, 129.07866f);
generalPath.curveTo(281.0f, 132.6608f, 285.0f, 132.85188f, 285.0f, 129.07866f);
generalPath.lineTo(285.0f, 99.22917f);
generalPath.lineTo(321.0f, 99.22917f);
generalPath.lineTo(321.0f, 52.770836f);
generalPath.lineTo(285.0f, 52.770836f);
generalPath.lineTo(285.0f, 23.929232f);
generalPath.curveTo(285.0f, 20.73836f, 281.84714f, 19.254284f, 278.55045f, 21.46494f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(63.90625f, 8.4375f);
generalPath.curveTo(63.296486f, 8.452437f, 62.718266f, 8.781241f, 62.1875f, 9.3125f);
generalPath.lineTo(18.25f, 71.96875f);
generalPath.curveTo(17.740482f, 72.63018f, 17.347925f, 73.29412f, 17.0f, 73.9375f);
generalPath.curveTo(19.796366f, 73.982765f, 22.603848f, 74.0f, 25.4375f, 74.0f);
generalPath.curveTo(55.098255f, 74.0f, 82.807686f, 71.4484f, 106.375f, 67.09375f);
generalPath.lineTo(65.84375f, 9.4375f);
generalPath.curveTo(65.150856f, 8.743956f, 64.516014f, 8.422563f, 63.90625f, 8.4375f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(84.48117065429688, 2.0102248191833496), new Point2D.Double(85.48796844482422, 88.88377380371094), new float[] {0.0f,1.0f}, new Color[] {new Color(205, 238, 255, 255),new Color(210, 232, 237, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_11
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(63.705082f, 8.5375f);
generalPath.curveTo(63.09532f, 8.552438f, 62.5171f, 8.881241f, 61.986332f, 9.4125f);
generalPath.lineTo(18.048834f, 72.06875f);
generalPath.curveTo(17.539324f, 72.73018f, 17.146763f, 73.39412f, 16.798834f, 74.0375f);
generalPath.curveTo(16.995613f, 74.04069f, 17.195704f, 74.03459f, 17.392584f, 74.0375f);
generalPath.curveTo(17.591963f, 73.72005f, 17.803204f, 73.38763f, 18.048834f, 73.06875f);
generalPath.lineTo(61.986332f, 10.4125f);
generalPath.curveTo(62.5171f, 9.881241f, 63.09532f, 9.552438f, 63.705082f, 9.5375f);
generalPath.curveTo(64.31485f, 9.522562f, 64.94969f, 9.843955f, 65.642586f, 10.5375f);
generalPath.lineTo(105.54883f, 67.31875f);
generalPath.curveTo(105.75636f, 67.2808f, 105.96695f, 67.23198f, 106.17383f, 67.19375f);
generalPath.lineTo(65.642586f, 9.5375f);
generalPath.curveTo(64.94969f, 8.843955f, 64.31485f, 8.522562f, 63.705082f, 8.5375f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(84.48117065429688, 2.0102248191833496), new Point2D.Double(86.0235366821289, 66.12226867675781), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -0.20103709399700165f, 0.10000000149011612f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_12
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(65.61847f, 9.483761f);
generalPath.lineTo(104.67692f, 66.06875f);
generalPath.curveTo(81.10961f, 70.70585f, 53.400173f, 73.58828f, 23.739424f, 73.94375f);
generalPath.curveTo(21.420023f, 73.97155f, 19.125763f, 73.97654f, 16.833174f, 73.975f);
generalPath.curveTo(16.822252f, 73.99507f, 16.812754f, 74.01747f, 16.801924f, 74.0375f);
generalPath.curveTo(19.598284f, 74.08276f, 22.405773f, 74.1f, 25.239424f, 74.1f);
generalPath.curveTo(54.900173f, 74.1f, 82.60961f, 71.54841f, 106.17692f, 67.19375f);
generalPath.lineTo(65.645676f, 9.5375f);
generalPath.lineTo(65.61847f, 9.483761f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(103.76151275634766, 85.51464080810547), new Point2D.Double(87.09466552734375, 48.98419189453125), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -0.19768710434436798f, 0.10000000149011612f));
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
        return 5.433778762817383;
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
		return 117.36719512939453;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 126.6407470703125;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private go_up_7() {
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
       go_up_7 base = new go_up_7();
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
       go_up_7 base = new go_up_7();
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
        return go_up_7::new;
    }
}

