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
public class svn_update implements ResizableIcon {
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
g.transform(new AffineTransform(0.21102924644947052f, 0.0f, 0.0f, 0.20917175710201263f, -15.882478713989258f, -52.677642822265625f));
// _0_0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 45.06142807006836f, -54.602901458740234f));
// _0_0_0_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(594.2098f, 637.24835f);
generalPath.curveTo(594.2098f, 707.02344f, 481.08197f, 763.58734f, 341.5318f, 763.58734f);
generalPath.curveTo(201.9816f, 763.58734f, 88.853806f, 707.02344f, 88.853806f, 637.24835f);
generalPath.curveTo(88.853806f, 567.47327f, 201.9816f, 510.90936f, 341.5318f, 510.90936f);
generalPath.curveTo(481.082f, 510.90936f, 594.2098f, 567.47327f, 594.2098f, 637.24835f);
generalPath.closePath();
shape = generalPath;
paint = new Color(61, 61, 61, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 45.06142807006836f, -113.5770263671875f));
// _0_0_0_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(594.2098f, 637.24835f);
generalPath.curveTo(594.2098f, 707.02344f, 481.08197f, 763.58734f, 341.5318f, 763.58734f);
generalPath.curveTo(201.9816f, 763.58734f, 88.853806f, 707.02344f, 88.853806f, 637.24835f);
generalPath.curveTo(88.853806f, 567.47327f, 201.9816f, 510.90936f, 341.5318f, 510.90936f);
generalPath.curveTo(481.082f, 510.90936f, 594.2098f, 567.47327f, 594.2098f, 637.24835f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(341.53179931640625, 528.580078125), new Point2D.Double(341.53179931640625, 700.0775146484375), new float[] {0.0f,1.0f}, new Color[] {new Color(252, 252, 252, 255),new Color(192, 192, 192, 255)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(639.2651f, 523.65924f);
generalPath.curveTo(639.2651f, 593.3983f, 526.0559f, 650.003f, 386.5777f, 650.003f);
generalPath.curveTo(247.82579f, 650.003f, 135.0921f, 593.9916f, 133.9214f, 524.753f);
generalPath.lineTo(134.9214f, 575.003f);
generalPath.curveTo(134.9214f, 644.7421f, 247.1306f, 701.34674f, 386.609f, 701.34674f);
generalPath.curveTo(526.0872f, 701.34674f, 638.26514f, 644.7421f, 638.26514f, 575.003f);
generalPath.lineTo(639.26514f, 523.65924f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(902.440185546875, 573.3363647460938), 252.67184f, new Point2D.Double(902.440185546875, 777.675048828125), new float[] {0.0f,0.13883302f,0.27766603f,0.3483148f,0.519832f,0.6913492f,0.7199554f,0.8247441f,0.9112725f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(188, 188, 188, 255),new Color(143, 143, 143, 255),new Color(242, 242, 242, 255),new Color(187, 187, 187, 255),new Color(63, 63, 63, 255),new Color(143, 143, 143, 255),new Color(164, 164, 164, 255),new Color(94, 94, 94, 255),new Color(172, 172, 172, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0000001192092896f, 0.0f, 0.0f, 0.7898656129837036f, -515.8470458984375f, 106.1419677734375f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(566.2773f, 486.15744f);
generalPath.curveTo(579.07697f, 526.5242f, 502.6638f, 561.86523f, 387.09488f, 561.86523f);
generalPath.curveTo(265.94098f, 561.86523f, 190.88239f, 525.39215f, 207.91258f, 486.15744f);
generalPath.curveTo(230.12598f, 434.98117f, 310.3997f, 410.44965f, 387.09488f, 410.44965f);
generalPath.curveTo(461.0135f, 410.44965f, 551.8533f, 440.668f, 566.2773f, 486.15744f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(949.625, 517.85107421875), 119.39729f, new Point2D.Double(942.2240600585938, 440.14154052734375), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.709729552268982f, 0.06452833116054535f, -0.0521678701043129f, 0.9870303869247437f, -1209.4918212890625f, -86.25507354736328f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(134.39008f, 519.2338f);
generalPath.curveTo(134.10378f, 521.6951f, 133.92128f, 524.1743f, 133.92137f, 526.6713f);
generalPath.curveTo(133.92137f, 596.41046f, 247.13057f, 653.0151f, 386.60876f, 653.0151f);
generalPath.curveTo(526.08704f, 653.0151f, 639.2651f, 596.41046f, 639.2651f, 526.6713f);
generalPath.curveTo(639.2651f, 524.1743f, 639.1139f, 521.6951f, 638.8276f, 519.2338f);
generalPath.curveTo(631.1191f, 585.515f, 521.0931f, 638.1401f, 386.60876f, 638.1401f);
generalPath.curveTo(252.12456f, 638.1401f, 142.09857f, 585.515f, 134.39006f, 519.2338f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(1302.515625, 396.677001953125), 252.67184f, new Point2D.Double(1302.515625, 396.677001953125), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.4615497589111328f, 0.0f, 0.0f, 0.7922186255455017f, -1517.09814453125f, 316.29644775390625f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.50553507f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.979244589805603f, 0.0f, 0.0f, 0.979244589805603f, -888.88818359375f, 80.20003509521484f));
// _0_0_0_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(1050.3125f, 441.16064f);
generalPath.curveTo(1050.0262f, 443.62198f, 1049.8438f, 446.10114f, 1049.8438f, 448.59814f);
generalPath.curveTo(1049.8438f, 518.3373f, 1163.053f, 574.9419f, 1302.5311f, 574.9419f);
generalPath.curveTo(1442.0094f, 574.9419f, 1555.1874f, 518.3373f, 1555.1874f, 448.59814f);
generalPath.curveTo(1555.1874f, 446.10114f, 1555.0361f, 443.62198f, 1554.7499f, 441.16064f);
generalPath.curveTo(1547.0414f, 507.44183f, 1437.0154f, 566.0669f, 1302.5311f, 566.0669f);
generalPath.curveTo(1168.0469f, 566.0669f, 1058.021f, 507.44183f, 1050.3124f, 441.16064f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(1228.482421875, 349.2613525390625), new Point2D.Double(1228.482421875, 687.31005859375), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(71, 71, 71, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_6
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(152.9375f, 571.65625f);
generalPath.curveTo(165.10074f, 588.474f, 184.4765f, 603.8789f, 210.03125f, 616.65625f);
generalPath.curveTo(254.92583f, 639.1035f, 317.48145f, 653.1875f, 386.59375f, 653.1875f);
generalPath.curveTo(455.70612f, 653.1875f, 518.26965f, 639.1034f, 563.15625f, 616.65625f);
generalPath.curveTo(588.5327f, 603.9658f, 607.79047f, 588.6834f, 619.96875f, 572.0f);
generalPath.curveTo(605.8334f, 587.5018f, 586.10754f, 601.21936f, 562.21875f, 612.53125f);
generalPath.curveTo(516.143f, 634.3492f, 454.44025f, 647.5625f, 386.59375f, 647.5625f);
generalPath.curveTo(318.7473f, 647.5625f, 257.0445f, 634.3492f, 210.96875f, 612.53125f);
generalPath.curveTo(186.90793f, 601.1379f, 167.09196f, 587.296f, 152.9375f, 571.65625f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(1302.515625, 396.677001953125), 252.67184f, new Point2D.Double(1302.515625, 396.677001953125), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.4615497589111328f, 0.0f, 0.0f, 0.7922186255455017f, -1517.09814453125f, 321.0887145996094f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.6287129f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, -309.3197326660156f));
// _0_0_0_7
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(639.2651f, 873.2777f);
generalPath.curveTo(639.2651f, 943.0168f, 526.0559f, 999.62146f, 386.5777f, 999.62146f);
generalPath.curveTo(247.82579f, 999.62146f, 135.0921f, 943.61005f, 133.9214f, 874.37146f);
generalPath.lineTo(134.9214f, 924.62146f);
generalPath.curveTo(134.9214f, 994.3606f, 247.1306f, 1050.9652f, 386.609f, 1050.9652f);
generalPath.curveTo(526.0872f, 1050.9652f, 638.26514f, 994.36053f, 638.26514f, 924.62146f);
generalPath.lineTo(639.26514f, 873.2777f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 76);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.50553507f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9960461258888245f, 0.0f, 0.0f, 0.9960461258888245f, -910.7724609375f, 72.38355255126953f));
// _0_0_0_8
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(1058.9375f, 474.46875f);
generalPath.curveTo(1069.0624f, 497.43295f, 1092.363f, 518.32214f, 1125.4062f, 534.84375f);
generalPath.curveTo(1170.5197f, 557.40045f, 1233.2562f, 571.5f, 1302.5312f, 571.5f);
generalPath.curveTo(1371.8064f, 571.5f, 1434.5195f, 557.4003f, 1479.625f, 534.84375f);
generalPath.curveTo(1512.5835f, 518.3617f, 1535.8389f, 497.52454f, 1546.0f, 474.625f);
generalPath.curveTo(1532.4229f, 496.34863f, 1508.5667f, 515.9022f, 1477.7188f, 531.53125f);
generalPath.curveTo(1431.8534f, 554.769f, 1370.2719f, 569.5f, 1302.5311f, 569.5f);
generalPath.curveTo(1234.7908f, 569.5f, 1173.2091f, 554.769f, 1127.3438f, 531.53125f);
generalPath.curveTo(1096.4165f, 515.86194f, 1072.4963f, 496.25967f, 1058.9375f, 474.46875f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(1228.482421875, 349.2613525390625), new Point2D.Double(1228.482421875, 687.31005859375), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(71, 71, 71, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.27227724f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9628130197525024f, 0.0f, 0.0f, 0.8727686405181885f, 17.362375259399414f, -18.873504638671875f));
// _0_0_1
paint = new LinearGradientPaint(new Point2D.Double(11.863568305969238, 97.68323516845703), new Point2D.Double(113.55742645263672, 38.211856842041016), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(0.49323508f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(86.26703f, 85.22004f);
generalPath.curveTo(86.32482f, 91.68118f, 79.46402f, 97.66393f, 68.282524f, 100.90288f);
generalPath.curveTo(57.10102f, 104.141815f, 43.308144f, 104.141815f, 32.12664f, 100.90288f);
generalPath.curveTo(20.945143f, 97.66393f, 14.084345f, 91.68118f, 14.142136f, 85.22004f);
generalPath.curveTo(14.084345f, 78.758896f, 20.945143f, 72.776146f, 32.12664f, 69.5372f);
generalPath.curveTo(43.308144f, 66.29826f, 57.10102f, 66.29826f, 68.282524f, 69.5372f);
generalPath.curveTo(79.46402f, 72.776146f, 86.32482f, 78.758896f, 86.26703f, 85.22004f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.27227724f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.944675087928772f, 0.0f, 0.0f, 0.8563269376754761f, 18.27298355102539f, -17.47234344482422f));
// _0_0_2
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(0.49323508f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(86.26703f, 85.22004f);
generalPath.curveTo(86.32482f, 91.68118f, 79.46402f, 97.66393f, 68.282524f, 100.90288f);
generalPath.curveTo(57.10102f, 104.141815f, 43.308144f, 104.141815f, 32.12664f, 100.90288f);
generalPath.curveTo(20.945143f, 97.66393f, 14.084345f, 91.68118f, 14.142136f, 85.22004f);
generalPath.curveTo(14.084345f, 78.758896f, 20.945143f, 72.776146f, 32.12664f, 69.5372f);
generalPath.curveTo(43.308144f, 66.29826f, 57.10102f, 66.29826f, 68.282524f, 69.5372f);
generalPath.curveTo(79.46402f, 72.776146f, 86.32482f, 78.758896f, 86.26703f, 85.22004f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.21102924644947052f, 0.0f, 0.0f, 0.20917175710201263f, -15.882478713989258f, -67.67764282226562f));
// _0_0_3
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 45.06142807006836f, -54.602901458740234f));
// _0_0_3_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(594.2098f, 637.24835f);
generalPath.curveTo(594.2098f, 707.02344f, 481.08197f, 763.58734f, 341.5318f, 763.58734f);
generalPath.curveTo(201.9816f, 763.58734f, 88.853806f, 707.02344f, 88.853806f, 637.24835f);
generalPath.curveTo(88.853806f, 567.47327f, 201.9816f, 510.90936f, 341.5318f, 510.90936f);
generalPath.curveTo(481.082f, 510.90936f, 594.2098f, 567.47327f, 594.2098f, 637.24835f);
generalPath.closePath();
shape = generalPath;
paint = new Color(61, 61, 61, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 45.06142807006836f, -113.5770263671875f));
// _0_0_3_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(594.2098f, 637.24835f);
generalPath.curveTo(594.2098f, 707.02344f, 481.08197f, 763.58734f, 341.5318f, 763.58734f);
generalPath.curveTo(201.9816f, 763.58734f, 88.853806f, 707.02344f, 88.853806f, 637.24835f);
generalPath.curveTo(88.853806f, 567.47327f, 201.9816f, 510.90936f, 341.5318f, 510.90936f);
generalPath.curveTo(481.082f, 510.90936f, 594.2098f, 567.47327f, 594.2098f, 637.24835f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(341.53179931640625, 528.580078125), new Point2D.Double(341.53179931640625, 700.0775146484375), new float[] {0.0f,1.0f}, new Color[] {new Color(252, 252, 252, 255),new Color(192, 192, 192, 255)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(639.2651f, 523.65924f);
generalPath.curveTo(639.2651f, 593.3983f, 526.0559f, 650.003f, 386.5777f, 650.003f);
generalPath.curveTo(247.82579f, 650.003f, 135.0921f, 593.9916f, 133.9214f, 524.753f);
generalPath.lineTo(134.9214f, 575.003f);
generalPath.curveTo(134.9214f, 644.7421f, 247.1306f, 701.34674f, 386.609f, 701.34674f);
generalPath.curveTo(526.0872f, 701.34674f, 638.26514f, 644.7421f, 638.26514f, 575.003f);
generalPath.lineTo(639.26514f, 523.65924f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(902.440185546875, 573.3363647460938), 252.67184f, new Point2D.Double(902.440185546875, 777.675048828125), new float[] {0.0f,0.13883302f,0.27766603f,0.3483148f,0.519832f,0.6913492f,0.7199554f,0.8247441f,0.9112725f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(188, 188, 188, 255),new Color(143, 143, 143, 255),new Color(242, 242, 242, 255),new Color(187, 187, 187, 255),new Color(63, 63, 63, 255),new Color(143, 143, 143, 255),new Color(164, 164, 164, 255),new Color(94, 94, 94, 255),new Color(172, 172, 172, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0000001192092896f, 0.0f, 0.0f, 0.7898656129837036f, -515.8470458984375f, 106.1419677734375f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(566.2773f, 486.15744f);
generalPath.curveTo(579.07697f, 526.5242f, 502.6638f, 561.86523f, 387.09488f, 561.86523f);
generalPath.curveTo(265.94098f, 561.86523f, 190.88239f, 525.39215f, 207.91258f, 486.15744f);
generalPath.curveTo(230.12598f, 434.98117f, 310.3997f, 410.44965f, 387.09488f, 410.44965f);
generalPath.curveTo(461.0135f, 410.44965f, 551.8533f, 440.668f, 566.2773f, 486.15744f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(949.625, 517.85107421875), 119.39729f, new Point2D.Double(942.2240600585938, 440.14154052734375), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.709729552268982f, 0.06452833116054535f, -0.0521678701043129f, 0.9870303869247437f, -1209.4918212890625f, -86.25507354736328f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(134.39008f, 519.2338f);
generalPath.curveTo(134.10378f, 521.6951f, 133.92128f, 524.1743f, 133.92137f, 526.6713f);
generalPath.curveTo(133.92137f, 596.41046f, 247.13057f, 653.0151f, 386.60876f, 653.0151f);
generalPath.curveTo(526.08704f, 653.0151f, 639.2651f, 596.41046f, 639.2651f, 526.6713f);
generalPath.curveTo(639.2651f, 524.1743f, 639.1139f, 521.6951f, 638.8276f, 519.2338f);
generalPath.curveTo(631.1191f, 585.515f, 521.0931f, 638.1401f, 386.60876f, 638.1401f);
generalPath.curveTo(252.12456f, 638.1401f, 142.09857f, 585.515f, 134.39006f, 519.2338f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(1302.515625, 396.677001953125), 252.67184f, new Point2D.Double(1302.515625, 396.677001953125), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.4615497589111328f, 0.0f, 0.0f, 0.7922186255455017f, -1517.09814453125f, 316.29644775390625f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.50553507f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.979244589805603f, 0.0f, 0.0f, 0.979244589805603f, -888.88818359375f, 80.20003509521484f));
// _0_0_3_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(1050.3125f, 441.16064f);
generalPath.curveTo(1050.0262f, 443.62198f, 1049.8438f, 446.10114f, 1049.8438f, 448.59814f);
generalPath.curveTo(1049.8438f, 518.3373f, 1163.053f, 574.9419f, 1302.5311f, 574.9419f);
generalPath.curveTo(1442.0094f, 574.9419f, 1555.1874f, 518.3373f, 1555.1874f, 448.59814f);
generalPath.curveTo(1555.1874f, 446.10114f, 1555.0361f, 443.62198f, 1554.7499f, 441.16064f);
generalPath.curveTo(1547.0414f, 507.44183f, 1437.0154f, 566.0669f, 1302.5311f, 566.0669f);
generalPath.curveTo(1168.0469f, 566.0669f, 1058.021f, 507.44183f, 1050.3124f, 441.16064f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(1228.482421875, 349.2613525390625), new Point2D.Double(1228.482421875, 687.31005859375), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(71, 71, 71, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3_6
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(152.9375f, 571.65625f);
generalPath.curveTo(165.10074f, 588.474f, 184.4765f, 603.8789f, 210.03125f, 616.65625f);
generalPath.curveTo(254.92583f, 639.1035f, 317.48145f, 653.1875f, 386.59375f, 653.1875f);
generalPath.curveTo(455.70612f, 653.1875f, 518.26965f, 639.1034f, 563.15625f, 616.65625f);
generalPath.curveTo(588.5327f, 603.9658f, 607.79047f, 588.6834f, 619.96875f, 572.0f);
generalPath.curveTo(605.8334f, 587.5018f, 586.10754f, 601.21936f, 562.21875f, 612.53125f);
generalPath.curveTo(516.143f, 634.3492f, 454.44025f, 647.5625f, 386.59375f, 647.5625f);
generalPath.curveTo(318.7473f, 647.5625f, 257.0445f, 634.3492f, 210.96875f, 612.53125f);
generalPath.curveTo(186.90793f, 601.1379f, 167.09196f, 587.296f, 152.9375f, 571.65625f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(1302.515625, 396.677001953125), 252.67184f, new Point2D.Double(1302.515625, 396.677001953125), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.4615497589111328f, 0.0f, 0.0f, 0.7922186255455017f, -1517.09814453125f, 321.0887145996094f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.6287129f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, -309.3197326660156f));
// _0_0_3_7
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(639.2651f, 873.2777f);
generalPath.curveTo(639.2651f, 943.0168f, 526.0559f, 999.62146f, 386.5777f, 999.62146f);
generalPath.curveTo(247.82579f, 999.62146f, 135.0921f, 943.61005f, 133.9214f, 874.37146f);
generalPath.lineTo(134.9214f, 924.62146f);
generalPath.curveTo(134.9214f, 994.3606f, 247.1306f, 1050.9652f, 386.609f, 1050.9652f);
generalPath.curveTo(526.0872f, 1050.9652f, 638.26514f, 994.36053f, 638.26514f, 924.62146f);
generalPath.lineTo(639.26514f, 873.2777f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 76);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.50553507f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9960461258888245f, 0.0f, 0.0f, 0.9960461258888245f, -910.7724609375f, 72.38355255126953f));
// _0_0_3_8
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(1058.9375f, 474.46875f);
generalPath.curveTo(1069.0624f, 497.43295f, 1092.363f, 518.32214f, 1125.4062f, 534.84375f);
generalPath.curveTo(1170.5197f, 557.40045f, 1233.2562f, 571.5f, 1302.5312f, 571.5f);
generalPath.curveTo(1371.8064f, 571.5f, 1434.5195f, 557.4003f, 1479.625f, 534.84375f);
generalPath.curveTo(1512.5835f, 518.3617f, 1535.8389f, 497.52454f, 1546.0f, 474.625f);
generalPath.curveTo(1532.4229f, 496.34863f, 1508.5667f, 515.9022f, 1477.7188f, 531.53125f);
generalPath.curveTo(1431.8534f, 554.769f, 1370.2719f, 569.5f, 1302.5311f, 569.5f);
generalPath.curveTo(1234.7908f, 569.5f, 1173.2091f, 554.769f, 1127.3438f, 531.53125f);
generalPath.curveTo(1096.4165f, 515.86194f, 1072.4963f, 496.25967f, 1058.9375f, 474.46875f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(1228.482421875, 349.2613525390625), new Point2D.Double(1228.482421875, 687.31005859375), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(71, 71, 71, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.27227724f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9628130197525024f, 0.0f, 0.0f, 0.8727686405181885f, 17.362375259399414f, -33.873504638671875f));
// _0_0_4
paint = new LinearGradientPaint(new Point2D.Double(11.863568305969238, 97.68323516845703), new Point2D.Double(113.55742645263672, 38.211856842041016), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(0.49323508f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(86.26703f, 85.22004f);
generalPath.curveTo(86.32482f, 91.68118f, 79.46402f, 97.66393f, 68.282524f, 100.90288f);
generalPath.curveTo(57.10102f, 104.141815f, 43.308144f, 104.141815f, 32.12664f, 100.90288f);
generalPath.curveTo(20.945143f, 97.66393f, 14.084345f, 91.68118f, 14.142136f, 85.22004f);
generalPath.curveTo(14.084345f, 78.758896f, 20.945143f, 72.776146f, 32.12664f, 69.5372f);
generalPath.curveTo(43.308144f, 66.29826f, 57.10102f, 66.29826f, 68.282524f, 69.5372f);
generalPath.curveTo(79.46402f, 72.776146f, 86.32482f, 78.758896f, 86.26703f, 85.22004f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.27227724f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.944675087928772f, 0.0f, 0.0f, 0.8563269376754761f, 18.27298355102539f, -32.47234344482422f));
// _0_0_5
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(0.49323508f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(86.26703f, 85.22004f);
generalPath.curveTo(86.32482f, 91.68118f, 79.46402f, 97.66393f, 68.282524f, 100.90288f);
generalPath.curveTo(57.10102f, 104.141815f, 43.308144f, 104.141815f, 32.12664f, 100.90288f);
generalPath.curveTo(20.945143f, 97.66393f, 14.084345f, 91.68118f, 14.142136f, 85.22004f);
generalPath.curveTo(14.084345f, 78.758896f, 20.945143f, 72.776146f, 32.12664f, 69.5372f);
generalPath.curveTo(43.308144f, 66.29826f, 57.10102f, 66.29826f, 68.282524f, 69.5372f);
generalPath.curveTo(79.46402f, 72.776146f, 86.32482f, 78.758896f, 86.26703f, 85.22004f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.21102924644947052f, 0.0f, 0.0f, 0.20917175710201263f, -15.882478713989258f, -82.67764282226562f));
// _0_0_6
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 45.06142807006836f, -54.602901458740234f));
// _0_0_6_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(594.2098f, 637.24835f);
generalPath.curveTo(594.2098f, 707.02344f, 481.08197f, 763.58734f, 341.5318f, 763.58734f);
generalPath.curveTo(201.9816f, 763.58734f, 88.853806f, 707.02344f, 88.853806f, 637.24835f);
generalPath.curveTo(88.853806f, 567.47327f, 201.9816f, 510.90936f, 341.5318f, 510.90936f);
generalPath.curveTo(481.082f, 510.90936f, 594.2098f, 567.47327f, 594.2098f, 637.24835f);
generalPath.closePath();
shape = generalPath;
paint = new Color(61, 61, 61, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 45.06142807006836f, -113.5770263671875f));
// _0_0_6_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(594.2098f, 637.24835f);
generalPath.curveTo(594.2098f, 707.02344f, 481.08197f, 763.58734f, 341.5318f, 763.58734f);
generalPath.curveTo(201.9816f, 763.58734f, 88.853806f, 707.02344f, 88.853806f, 637.24835f);
generalPath.curveTo(88.853806f, 567.47327f, 201.9816f, 510.90936f, 341.5318f, 510.90936f);
generalPath.curveTo(481.082f, 510.90936f, 594.2098f, 567.47327f, 594.2098f, 637.24835f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(341.53179931640625, 528.580078125), new Point2D.Double(341.53179931640625, 700.0775146484375), new float[] {0.0f,1.0f}, new Color[] {new Color(252, 252, 252, 255),new Color(192, 192, 192, 255)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(639.2651f, 523.65924f);
generalPath.curveTo(639.2651f, 593.3983f, 526.0559f, 650.003f, 386.5777f, 650.003f);
generalPath.curveTo(247.82579f, 650.003f, 135.0921f, 593.9916f, 133.9214f, 524.753f);
generalPath.lineTo(134.9214f, 575.003f);
generalPath.curveTo(134.9214f, 644.7421f, 247.1306f, 701.34674f, 386.609f, 701.34674f);
generalPath.curveTo(526.0872f, 701.34674f, 638.26514f, 644.7421f, 638.26514f, 575.003f);
generalPath.lineTo(639.26514f, 523.65924f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(902.440185546875, 573.3363647460938), 252.67184f, new Point2D.Double(902.440185546875, 777.675048828125), new float[] {0.0f,0.13883302f,0.27766603f,0.3483148f,0.519832f,0.6913492f,0.7199554f,0.8247441f,0.9112725f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(188, 188, 188, 255),new Color(143, 143, 143, 255),new Color(242, 242, 242, 255),new Color(187, 187, 187, 255),new Color(63, 63, 63, 255),new Color(143, 143, 143, 255),new Color(164, 164, 164, 255),new Color(94, 94, 94, 255),new Color(172, 172, 172, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0000001192092896f, 0.0f, 0.0f, 0.7898656129837036f, -515.8470458984375f, 106.1419677734375f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(566.2773f, 486.15744f);
generalPath.curveTo(579.07697f, 526.5242f, 502.6638f, 561.86523f, 387.09488f, 561.86523f);
generalPath.curveTo(265.94098f, 561.86523f, 190.88239f, 525.39215f, 207.91258f, 486.15744f);
generalPath.curveTo(230.12598f, 434.98117f, 310.3997f, 410.44965f, 387.09488f, 410.44965f);
generalPath.curveTo(461.0135f, 410.44965f, 551.8533f, 440.668f, 566.2773f, 486.15744f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(949.625, 517.85107421875), 119.39729f, new Point2D.Double(942.2240600585938, 440.14154052734375), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.709729552268982f, 0.06452833116054535f, -0.0521678701043129f, 0.9870303869247437f, -1209.4918212890625f, -86.25507354736328f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(134.39008f, 519.2338f);
generalPath.curveTo(134.10378f, 521.6951f, 133.92128f, 524.1743f, 133.92137f, 526.6713f);
generalPath.curveTo(133.92137f, 596.41046f, 247.13057f, 653.0151f, 386.60876f, 653.0151f);
generalPath.curveTo(526.08704f, 653.0151f, 639.2651f, 596.41046f, 639.2651f, 526.6713f);
generalPath.curveTo(639.2651f, 524.1743f, 639.1139f, 521.6951f, 638.8276f, 519.2338f);
generalPath.curveTo(631.1191f, 585.515f, 521.0931f, 638.1401f, 386.60876f, 638.1401f);
generalPath.curveTo(252.12456f, 638.1401f, 142.09857f, 585.515f, 134.39006f, 519.2338f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(1302.515625, 396.677001953125), 252.67184f, new Point2D.Double(1302.515625, 396.677001953125), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.4615497589111328f, 0.0f, 0.0f, 0.7922186255455017f, -1517.09814453125f, 316.29644775390625f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.50553507f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.979244589805603f, 0.0f, 0.0f, 0.979244589805603f, -888.88818359375f, 80.20003509521484f));
// _0_0_6_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(1050.3125f, 441.16064f);
generalPath.curveTo(1050.0262f, 443.62198f, 1049.8438f, 446.10114f, 1049.8438f, 448.59814f);
generalPath.curveTo(1049.8438f, 518.3373f, 1163.053f, 574.9419f, 1302.5311f, 574.9419f);
generalPath.curveTo(1442.0094f, 574.9419f, 1555.1874f, 518.3373f, 1555.1874f, 448.59814f);
generalPath.curveTo(1555.1874f, 446.10114f, 1555.0361f, 443.62198f, 1554.7499f, 441.16064f);
generalPath.curveTo(1547.0414f, 507.44183f, 1437.0154f, 566.0669f, 1302.5311f, 566.0669f);
generalPath.curveTo(1168.0469f, 566.0669f, 1058.021f, 507.44183f, 1050.3124f, 441.16064f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(1228.482421875, 349.2613525390625), new Point2D.Double(1228.482421875, 687.31005859375), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(71, 71, 71, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6_6
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(152.9375f, 571.65625f);
generalPath.curveTo(165.10074f, 588.474f, 184.4765f, 603.8789f, 210.03125f, 616.65625f);
generalPath.curveTo(254.92583f, 639.1035f, 317.48145f, 653.1875f, 386.59375f, 653.1875f);
generalPath.curveTo(455.70612f, 653.1875f, 518.26965f, 639.1034f, 563.15625f, 616.65625f);
generalPath.curveTo(588.5327f, 603.9658f, 607.79047f, 588.6834f, 619.96875f, 572.0f);
generalPath.curveTo(605.8334f, 587.5018f, 586.10754f, 601.21936f, 562.21875f, 612.53125f);
generalPath.curveTo(516.143f, 634.3492f, 454.44025f, 647.5625f, 386.59375f, 647.5625f);
generalPath.curveTo(318.7473f, 647.5625f, 257.0445f, 634.3492f, 210.96875f, 612.53125f);
generalPath.curveTo(186.90793f, 601.1379f, 167.09196f, 587.296f, 152.9375f, 571.65625f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(1302.515625, 396.677001953125), 252.67184f, new Point2D.Double(1302.515625, 396.677001953125), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.4615497589111328f, 0.0f, 0.0f, 0.7922186255455017f, -1517.09814453125f, 321.0887145996094f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.6287129f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, -309.3197326660156f));
// _0_0_6_7
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(639.2651f, 873.2777f);
generalPath.curveTo(639.2651f, 943.0168f, 526.0559f, 999.62146f, 386.5777f, 999.62146f);
generalPath.curveTo(247.82579f, 999.62146f, 135.0921f, 943.61005f, 133.9214f, 874.37146f);
generalPath.lineTo(134.9214f, 924.62146f);
generalPath.curveTo(134.9214f, 994.3606f, 247.1306f, 1050.9652f, 386.609f, 1050.9652f);
generalPath.curveTo(526.0872f, 1050.9652f, 638.26514f, 994.36053f, 638.26514f, 924.62146f);
generalPath.lineTo(639.26514f, 873.2777f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 76);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.50553507f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9960461258888245f, 0.0f, 0.0f, 0.9960461258888245f, -910.7724609375f, 72.38355255126953f));
// _0_0_6_8
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(1058.9375f, 474.46875f);
generalPath.curveTo(1069.0624f, 497.43295f, 1092.363f, 518.32214f, 1125.4062f, 534.84375f);
generalPath.curveTo(1170.5197f, 557.40045f, 1233.2562f, 571.5f, 1302.5312f, 571.5f);
generalPath.curveTo(1371.8064f, 571.5f, 1434.5195f, 557.4003f, 1479.625f, 534.84375f);
generalPath.curveTo(1512.5835f, 518.3617f, 1535.8389f, 497.52454f, 1546.0f, 474.625f);
generalPath.curveTo(1532.4229f, 496.34863f, 1508.5667f, 515.9022f, 1477.7188f, 531.53125f);
generalPath.curveTo(1431.8534f, 554.769f, 1370.2719f, 569.5f, 1302.5311f, 569.5f);
generalPath.curveTo(1234.7908f, 569.5f, 1173.2091f, 554.769f, 1127.3438f, 531.53125f);
generalPath.curveTo(1096.4165f, 515.86194f, 1072.4963f, 496.25967f, 1058.9375f, 474.46875f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(1228.482421875, 349.2613525390625), new Point2D.Double(1228.482421875, 687.31005859375), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(71, 71, 71, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.27227724f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9628130197525024f, 0.0f, 0.0f, 0.8727686405181885f, 17.362375259399414f, -48.873504638671875f));
// _0_0_7
paint = new LinearGradientPaint(new Point2D.Double(11.863568305969238, 97.68323516845703), new Point2D.Double(113.55742645263672, 38.211856842041016), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(0.49323508f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(86.26703f, 85.22004f);
generalPath.curveTo(86.32482f, 91.68118f, 79.46402f, 97.66393f, 68.282524f, 100.90288f);
generalPath.curveTo(57.10102f, 104.141815f, 43.308144f, 104.141815f, 32.12664f, 100.90288f);
generalPath.curveTo(20.945143f, 97.66393f, 14.084345f, 91.68118f, 14.142136f, 85.22004f);
generalPath.curveTo(14.084345f, 78.758896f, 20.945143f, 72.776146f, 32.12664f, 69.5372f);
generalPath.curveTo(43.308144f, 66.29826f, 57.10102f, 66.29826f, 68.282524f, 69.5372f);
generalPath.curveTo(79.46402f, 72.776146f, 86.32482f, 78.758896f, 86.26703f, 85.22004f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.27227724f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.944675087928772f, 0.0f, 0.0f, 0.8563269376754761f, 18.27298355102539f, -47.47234344482422f));
// _0_0_8
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(0.49323508f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(86.26703f, 85.22004f);
generalPath.curveTo(86.32482f, 91.68118f, 79.46402f, 97.66393f, 68.282524f, 100.90288f);
generalPath.curveTo(57.10102f, 104.141815f, 43.308144f, 104.141815f, 32.12664f, 100.90288f);
generalPath.curveTo(20.945143f, 97.66393f, 14.084345f, 91.68118f, 14.142136f, 85.22004f);
generalPath.curveTo(14.084345f, 78.758896f, 20.945143f, 72.776146f, 32.12664f, 69.5372f);
generalPath.curveTo(43.308144f, 66.29826f, 57.10102f, 66.29826f, 68.282524f, 69.5372f);
generalPath.curveTo(79.46402f, 72.776146f, 86.32482f, 78.758896f, 86.26703f, 85.22004f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.6433923244476318f, 0.0f, 0.0f, 0.6433923244476318f, 122.7645492553711f, 84.17054748535156f));
// _0_0_9
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.6433923244476318f, 0.0f, 0.0f, 0.6433923244476318f, 122.7645492553711f, 84.17054748535156f));
// _0_0_10
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_11
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.501845f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.4857213795185089f, 0.0f, 0.0f, 0.4150945544242859f, 66.84616088867188f, 67.71189880371094f));
// _0_0_12
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_13
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.3336920142173767f, 0.0f, 0.0f, 0.3336920142173767f, -733.6383666992188f, -244.40249633789062f));
// _0_0_14
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -28.032392501831055f, 0.0f));
// _0_0_15
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(126.87202f, 82.900795f);
generalPath.lineTo(95.925125f, 125.65247f);
generalPath.curveTo(95.47954f, 126.27374f, 94.81932f, 126.63298f, 94.12311f, 126.63298f);
generalPath.curveTo(93.426895f, 126.63298f, 92.76667f, 126.27374f, 92.32109f, 125.65247f);
generalPath.lineTo(61.380028f, 82.46643f);
generalPath.curveTo(59.718155f, 79.848816f, 59.482674f, 76.089226f, 63.165054f, 76.089226f);
generalPath.lineTo(79.95998f, 76.089226f);
generalPath.lineTo(79.95998f, 62.53485f);
generalPath.curveTo(79.95955f, 61.02988f, 81.191315f, 60.007187f, 82.48716f, 60.00766f);
generalPath.lineTo(105.50521f, 59.91843f);
generalPath.curveTo(106.80106f, 59.917957f, 108.03282f, 60.940655f, 108.032394f, 62.44562f);
generalPath.lineTo(108.032394f, 76.0f);
generalPath.lineTo(124.44936f, 76.08923f);
generalPath.curveTo(126.90776f, 76.08923f, 128.5897f, 80.52477f, 126.872025f, 82.900795f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(186.92596435546875, 89.88978576660156), new Point2D.Double(242.8547821044922, 91.35980987548828), new float[] {0.0f,1.0f}, new Color[] {new Color(8, 30, 62, 255),new Color(56, 125, 228, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.0f, -0.6317968964576721f, -0.5440064072608948f, 0.0f, 135.46548461914062f, 197.39422607421875f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.25468165f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(126.87202f, 82.900795f);
generalPath.lineTo(95.925125f, 125.65247f);
generalPath.curveTo(95.47954f, 126.27374f, 94.81932f, 126.63298f, 94.12311f, 126.63298f);
generalPath.curveTo(93.426895f, 126.63298f, 92.76667f, 126.27374f, 92.32109f, 125.65247f);
generalPath.lineTo(61.380028f, 82.46643f);
generalPath.curveTo(59.718155f, 79.848816f, 59.482674f, 76.089226f, 63.165054f, 76.089226f);
generalPath.lineTo(79.95998f, 76.089226f);
generalPath.lineTo(79.95998f, 62.53485f);
generalPath.curveTo(79.95955f, 61.02988f, 81.191315f, 60.007187f, 82.48716f, 60.00766f);
generalPath.lineTo(105.45904f, 60.00766f);
generalPath.curveTo(106.75489f, 60.007187f, 107.98665f, 61.029884f, 107.98622f, 62.53485f);
generalPath.lineTo(107.98622f, 76.089226f);
generalPath.lineTo(124.44936f, 76.089226f);
generalPath.curveTo(126.90776f, 76.089226f, 128.5897f, 80.524765f, 126.872025f, 82.90079f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(68.02018737792969, 88.27139282226562), 60.0f, new Point2D.Double(68.02018737792969, 88.27139282226562), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.030379630625247955f, -0.36638343334198f, -0.7259783148765564f, -0.06019638851284981f, 164.45135498046875f, 124.58737182617188f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.0f, -0.6317968964576721f, -0.6317968964576721f, 0.0f, 134.55810546875f, 129.16017150878906f));
// _0_0_15_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(76.5f, 11.0625f);
generalPath.curveTo(75.42291f, 11.12778f, 74.3861f, 11.439286f, 73.5f, 12.0f);
generalPath.lineTo(75.875f, 19.625f);
generalPath.lineTo(84.0f, 16.46875f);
generalPath.lineTo(84.0f, 16.0f);
generalPath.curveTo(84.0f, 13.081648f, 80.06108f, 10.846661f, 76.5f, 11.0625f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(73.74263763427734, 15.336544036865234), new Point2D.Double(78.93933868408203, 16.75075912475586), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 4.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.0f, -0.6317968964576721f, 0.6317968964576721f, 0.0f, 55.20912170410156f, 136.123291015625f));
// _0_0_15_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(115.65112f, 40.0f);
generalPath.curveTo(115.31168f, 41.15456f, 113.08862f, 46.125f, 113.08862f, 46.125f);
generalPath.lineTo(119.83862f, 46.09375f);
generalPath.lineTo(119.83862f, 44.0f);
generalPath.curveTo(119.839386f, 41.94895f, 118.220665f, 39.999344f, 115.83862f, 40.0f);
generalPath.lineTo(115.65112f, 40.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(223.32711791992188, 53.78415298461914), new Point2D.Double(226.65899658203125, 57.279232025146484), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.861046314239502f, -108.161376953125f, -1.436186671257019f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(126.87202f, 82.900795f);
generalPath.lineTo(95.925125f, 125.65247f);
generalPath.curveTo(95.47954f, 126.27374f, 94.81932f, 126.63298f, 94.12311f, 126.63298f);
generalPath.curveTo(93.426895f, 126.63298f, 92.76667f, 126.27374f, 92.32109f, 125.65247f);
generalPath.lineTo(61.380028f, 82.46643f);
generalPath.curveTo(59.718155f, 79.848816f, 59.482674f, 76.089226f, 63.165054f, 76.089226f);
generalPath.lineTo(79.95998f, 76.089226f);
generalPath.lineTo(79.95998f, 62.53485f);
generalPath.curveTo(79.95955f, 61.02988f, 81.191315f, 60.007187f, 82.48716f, 60.00766f);
generalPath.lineTo(105.45904f, 60.00766f);
generalPath.curveTo(106.75489f, 60.007187f, 107.98665f, 61.029884f, 107.98622f, 62.53485f);
generalPath.lineTo(107.98622f, 76.089226f);
generalPath.lineTo(124.44936f, 76.089226f);
generalPath.curveTo(126.90776f, 76.089226f, 128.5897f, 80.524765f, 126.872025f, 82.90079f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(-23.234317779541016, 61.87726593017578), 60.0f, new Point2D.Double(-23.234317779541016, 61.87726593017578), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-0.011168699711561203f, -0.3674710988998413f, -0.5609713196754456f, 0.01704983040690422f, 130.80404663085938f, 108.9920425415039f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.70411986f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.0f, -0.5254283547401428f, 0.6317968964576721f, 0.0f, 53.19267654418945f, 118.12349700927734f));
// _0_0_15_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(72.5f, 11.0625f);
generalPath.curveTo(71.42291f, 11.12778f, 70.3861f, 11.439286f, 69.5f, 12.0f);
generalPath.lineTo(71.875f, 19.625f);
generalPath.lineTo(80.0f, 16.46875f);
generalPath.lineTo(80.0f, 16.0f);
generalPath.curveTo(80.0f, 13.081648f, 76.06108f, 10.846661f, 72.5f, 11.0625f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(74.75, 14.275883674621582), new Point2D.Double(78.93933868408203, 16.75075912475586), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.631542444229126f, 0.017931750044226646f, -0.017931750044226646f, 0.631542444229126f, 32.52680206298828f, 33.16581344604492f));
// _0_0_15_6
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(115.65112f, 40.0f);
generalPath.curveTo(115.31168f, 41.15456f, 113.08862f, 46.125f, 113.08862f, 46.125f);
generalPath.lineTo(119.83862f, 46.09375f);
generalPath.lineTo(119.83862f, 44.0f);
generalPath.curveTo(119.839386f, 41.94895f, 118.220665f, 39.999344f, 115.83862f, 40.0f);
generalPath.lineTo(115.65112f, 40.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(223.32711791992188, 53.78415298461914), new Point2D.Double(226.65899658203125, 57.279232025146484), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.861046314239502f, -108.161376953125f, -1.436186671257019f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.6317968964576721f, 0.0f, 0.0f, -0.6317968964576721f, 53.71141815185547f, 129.17010498046875f));
// _0_0_15_7
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(61.556484f, 5.221757f);
generalPath.curveTo(63.245625f, 3.7628593f, 64.797745f, 4.1537676f, 66.30962f, 5.087866f);
generalPath.lineTo(64.06695f, 18.984468f);
generalPath.lineTo(61.556484f, 5.221757f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(63.93305587768555, 7.566767692565918), new Point2D.Double(66.20711517333984, 7.566767692565918), new float[] {0.0f,1.0f}, new Color[] {new Color(99, 233, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_8
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(126.87202f, 82.900795f);

}

private void _paint1(Graphics2D g,float origAlpha) {
generalPath.lineTo(95.925125f, 125.65247f);
generalPath.curveTo(95.47954f, 126.27374f, 94.81932f, 126.63298f, 94.12311f, 126.63298f);
generalPath.curveTo(93.426895f, 126.63298f, 92.76667f, 126.27374f, 92.32109f, 125.65247f);
generalPath.lineTo(61.380028f, 82.46643f);
generalPath.curveTo(59.718155f, 79.848816f, 59.482674f, 76.089226f, 63.165054f, 76.089226f);
generalPath.lineTo(79.95998f, 76.089226f);
generalPath.lineTo(79.95998f, 62.53485f);
generalPath.curveTo(79.95955f, 61.02988f, 81.191315f, 60.007187f, 82.48716f, 60.00766f);
generalPath.lineTo(105.45904f, 60.00766f);
generalPath.curveTo(106.75489f, 60.007187f, 107.98665f, 61.029884f, 107.98622f, 62.53485f);
generalPath.lineTo(107.98622f, 76.089226f);
generalPath.lineTo(124.44936f, 76.089226f);
generalPath.curveTo(126.90776f, 76.089226f, 128.5897f, 80.524765f, 126.872025f, 82.90079f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(64.0, 46.527523040771484), 53.298492f, new Point2D.Double(64.0, 46.527523040771484), new float[] {0.0f,1.0f}, new Color[] {new Color(46, 106, 196, 255),new Color(46, 106, 196, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.5249295234680176f, 0.015562600456178188f, -0.0018859399715438485f, 0.18479731678962708f, -3.3613109588623047f, 66.99590301513672f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.0f, -0.6317968964576721f, -0.5439686179161072f, 0.0f, 135.4647216796875f, 197.39422607421875f));
// _0_0_15_9
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_9_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(179.33453f, 26.979963f);
generalPath.lineTo(123.653824f, 73.57467f);
generalPath.curveTo(122.26802f, 75.18421f, 122.48985f, 76.59585f, 123.551384f, 77.82877f);
generalPath.lineTo(177.78409f, 123.563644f);
generalPath.curveTo(181.78409f, 127.14578f, 185.78409f, 127.336876f, 185.78409f, 123.563644f);
generalPath.lineTo(185.81009f, 94.609726f);
generalPath.lineTo(211.13469f, 94.609726f);
generalPath.lineTo(211.13474f, 57.8429f);
generalPath.lineTo(185.81013f, 57.8429f);
generalPath.lineTo(185.78413f, 29.44426f);
generalPath.curveTo(185.78413f, 26.253387f, 182.63127f, 24.76931f, 179.33458f, 26.979967f);
generalPath.lineTo(179.33456f, 26.979967f);
generalPath.lineTo(179.33453f, 26.979967f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(136.6140899658203, 76.10952758789062), 56.0f, new Point2D.Double(136.6140899658203, 76.10952758789062), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(159, 193, 242, 255),new Color(88, 126, 181, 255),new Color(12, 42, 88, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.1383929252624512f, 0.0f, -10.51785659790039f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.0f, -0.6317968964576721f, -0.5439686179161072f, 0.0f, 135.59107971191406f, 258.80682373046875f));
// _0_0_15_10
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_10_0
paint = new LinearGradientPaint(new Point2D.Double(119.33738708496094, 59.541107177734375), new Point2D.Double(178.90383911132812, 61.049652099609375), new float[] {0.0f,1.0f}, new Color[] {new Color(99, 233, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 97.0f, 0.0f));
stroke = new BasicStroke(1.7057853f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(276.49283f, 26.97996f);
generalPath.lineTo(220.85384f, 73.80696f);
generalPath.curveTo(219.46803f, 75.416504f, 219.68987f, 76.82814f, 220.75139f, 78.061066f);
generalPath.lineTo(274.94238f, 123.563644f);
generalPath.curveTo(278.94238f, 127.14578f, 282.94238f, 127.336876f, 282.94238f, 123.563644f);
generalPath.lineTo(283.0131f, 94.842026f);
generalPath.lineTo(308.3377f, 94.84202f);
generalPath.lineTo(308.3377f, 58.07519f);
generalPath.lineTo(283.01312f, 58.04835f);
generalPath.lineTo(283.01224f, 57.715527f);
generalPath.lineTo(282.94244f, 29.444254f);
generalPath.curveTo(282.94244f, 26.253382f, 279.78958f, 24.769304f, 276.4929f, 26.979961f);
generalPath.lineTo(276.49286f, 26.979965f);
generalPath.lineTo(276.4929f, 26.979965f);
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
// _0_0_15_11
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(84.0f, 64.0f);
generalPath.lineTo(84.0f, 80.0f);
generalPath.lineTo(68.24172f, 80.02621f);
generalPath.curveTo(66.1892f, 80.02621f, 66.29315f, 82.5534f, 68.24172f, 85.08058f);
generalPath.lineTo(73.32661f, 91.93343f);
generalPath.curveTo(76.51979f, 92.14834f, 77.473785f, 92.269066f, 80.77997f, 92.269066f);
generalPath.curveTo(95.76103f, 92.269066f, 106.70982f, 91.38768f, 118.412415f, 87.46957f);
generalPath.lineTo(120.781654f, 84.0934f);
generalPath.curveTo(121.98418f, 82.01056f, 121.17483f, 80.02621f, 119.439095f, 80.02621f);
generalPath.lineTo(104.0f, 80.0f);
generalPath.lineTo(104.0f, 64.0f);
generalPath.lineTo(84.0f, 64.0f);
generalPath.lineTo(84.0f, 64.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(111.81199645996094, 2.8030190467834473), new Point2D.Double(112.0, 75.10427856445312), new float[] {0.0f,1.0f}, new Color[] {new Color(205, 238, 255, 255),new Color(210, 232, 237, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.6317968964576721f, 0.0f, 0.0f, 0.6317968964576721f, 53.71141815185547f, 48.28022384643555f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.6317968964576721f, 0.0f, 0.0f, 0.6317968964576721f, 143.54481506347656f, 48.28022384643555f));
// _0_0_15_12
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_12_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-94.24676f, 24.881062f);
generalPath.lineTo(-94.24676f, 25.88106f);
generalPath.lineTo(-63.31684f, 25.95174f);
generalPath.lineTo(-62.59102f, 24.881062f);
generalPath.lineTo(-94.246765f, 24.881062f);
generalPath.closePath();
generalPath.moveTo(-118.93914f, 50.247154f);
generalPath.curveTo(-120.702f, 50.247154f, -121.45124f, 51.436893f, -121.28289f, 53.153404f);
generalPath.curveTo(-121.10926f, 51.991547f, -120.33656f, 51.247154f, -118.93914f, 51.247154f);
generalPath.lineTo(-97.96875f, 51.247154f);
generalPath.lineTo(-94.226425f, 50.205658f);
generalPath.lineTo(-118.93914f, 50.247158f);
generalPath.closePath();
generalPath.moveTo(-62.591015f, 50.205654f);
generalPath.lineTo(-63.350227f, 51.247154f);
generalPath.lineTo(-37.90461f, 51.247154f);
generalPath.curveTo(-36.220592f, 51.247154f, -35.091072f, 52.418156f, -34.90461f, 54.090904f);
generalPath.curveTo(-34.682312f, 51.908f, -35.901196f, 50.247154f, -37.90461f, 50.247154f);
generalPath.lineTo(-62.59101f, 50.205654f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(111.81199645996094, 2.8030190467834473), new Point2D.Double(112.0, 75.10427856445312), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -141.9246826171875f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_12_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-63.31159f, 25.944496f);
generalPath.lineTo(-63.35787f, 51.24436f);
generalPath.lineTo(-62.591f, 50.205658f);
generalPath.lineTo(-62.591003f, 24.881065f);
generalPath.lineTo(-63.311584f, 25.9445f);
generalPath.closePath();
generalPath.moveTo(-35.778225f, 53.07994f);
generalPath.curveTo(-35.773125f, 54.028244f, -35.554813f, 53.717487f, -36.184475f, 54.822155f);
generalPath.lineTo(-40.234474f, 60.459656f);
generalPath.curveTo(-58.757195f, 67.074814f, -75.970215f, 68.56427f, -99.68205f, 69.09375f);
generalPath.curveTo(-104.754005f, 69.20701f, -109.746445f, 69.14874f, -114.650795f, 68.9375f);
generalPath.lineTo(-114.525795f, 69.09375f);
generalPath.curveTo(-109.471664f, 69.4339f, -104.32127f, 69.625f, -99.0883f, 69.625f);
generalPath.curveTo(-75.37647f, 69.625f, -58.36344f, 68.22995f, -39.84072f, 62.0284f);
generalPath.lineTo(-36.09072f, 56.68465f);
generalPath.curveTo(-34.92921f, 54.672855f, -34.95845f, 54.297287f, -35.77822f, 53.079937f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(79.73841094970703, 82.60218811035156), new Point2D.Double(50.94560623168945, 22.886703491210938), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -141.92552185058594f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
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
_paint1(g, origAlpha);


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
		return 127.53147888183594;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private svn_update() {
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
       svn_update base = new svn_update();
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
       svn_update base = new svn_update();
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
        return svn_update::new;
    }
}

