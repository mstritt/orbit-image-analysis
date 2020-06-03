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
public class color_fill implements ResizableIcon {
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
g.setComposite(AlphaComposite.getInstance(3, 0.7f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-0.8684762716293335f, 0.49573075771331787f, -0.49573075771331787f, -0.8684762716293335f, 0.0f, 0.0f));
// _0_0_0
shape = new Ellipse2D.Double(15.160582542419434, -83.19001007080078, 21.14337730407715, 21.14337730407715);
paint = new Color(153, 255, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(126.20027f, 79.1128f);
generalPath.curveTo(124.6614f, 84.74488f, 118.84343f, 88.0658f, 113.20982f, 86.52781f);
generalPath.curveTo(107.58256f, 84.99025f, 104.26163f, 79.17229f, 105.79896f, 73.54109f);
generalPath.curveTo(107.33783f, 67.90901f, 113.1558f, 64.58808f, 118.78613f, 66.12389f);
generalPath.curveTo(124.41843f, 67.66669f, 127.73694f, 73.484f, 126.20027f, 79.1128f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(23.98635f, 51.18981f);
generalPath.curveTo(22.44573f, 56.81882f, 16.63018f, 60.1404f, 11.0005f, 58.60219f);
generalPath.curveTo(5.36689f, 57.0642f, 2.0475f, 51.24536f, 3.58637f, 45.61328f);
generalPath.curveTo(5.12458f, 39.98361f, 10.94101f, 36.66356f, 16.57375f, 38.20002f);
generalPath.curveTo(22.20429f, 39.73976f, 25.52522f, 45.55773f, 23.98635f, 51.18981f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 204, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(118.82027f, 59.12623f);
generalPath.curveTo(113.17321f, 60.61471f, 107.39166f, 57.23735f, 105.9071f, 51.59006f);
generalPath.curveTo(104.4241f, 45.9419f, 107.79993f, 40.16122f, 113.44743f, 38.68062f);
generalPath.curveTo(119.09692f, 37.19279f, 124.87913f, 40.56775f, 126.35929f, 46.2216f);
generalPath.curveTo(127.84383f, 51.86888f, 124.46778f, 57.64562f, 118.82027f, 59.12623f);
generalPath.closePath();
shape = generalPath;
paint = new Color(204, 0, 153, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(35.05385f, 32.23453f);
generalPath.curveTo(30.90544f, 36.34142f, 24.21065f, 36.31114f, 20.10267f, 32.15725f);
generalPath.curveTo(15.99338f, 28.00819f, 16.02629f, 21.31799f, 20.17076f, 17.21132f);
generalPath.curveTo(24.32267f, 13.09634f, 31.01702f, 13.13297f, 35.12631f, 17.28204f);
generalPath.curveTo(39.23714f, 21.43023f, 39.20358f, 28.12283f, 35.05385f, 32.23453f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 153, 153, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(109.9776f, 32.59823f);
generalPath.curveTo(105.82526f, 36.70533f, 99.13528f, 36.67636f, 95.02423f, 32.52423f);
generalPath.curveTo(90.91669f, 28.37823f, 90.95004f, 21.68169f, 95.10304f, 17.57218f);
generalPath.curveTo(99.24992f, 13.46617f, 105.94077f, 13.49667f, 110.04766f, 17.64507f);
generalPath.curveTo(114.16418f, 21.79611f, 114.13083f, 28.49266f, 109.9776f, 32.59823f);
generalPath.closePath();
shape = generalPath;
paint = new Color(102, 0, 153, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-0.8684762716293335f, 0.49573075771331787f, -0.49573075771331787f, -0.8684762716293335f, 0.0f, 0.0f));
// _0_0_6
shape = new Ellipse2D.Double(-49.730377197265625, -45.73215866088867, 21.14690399169922, 21.14690399169922);
paint = new Color(0, 51, 204, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(89.05962f, 14.04566f);
generalPath.curveTo(87.51987f, 19.67621f, 81.70103f, 22.9956f, 76.0707f, 21.4598f);
generalPath.curveTo(70.44016f, 19.92006f, 67.11923f, 14.10209f, 68.65657f, 8.470885f);
generalPath.curveTo(70.19631f, 2.840337f, 76.01427f, -0.480587f, 81.64548f, 1.056748f);
generalPath.curveTo(87.27449f, 2.597364f, 90.59695f, 8.414458f, 89.05962f, 14.04566f);
generalPath.closePath();
shape = generalPath;
paint = new Color(51, 0, 153, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-0.8684762716293335f, 0.49573075771331787f, -0.49573075771331787f, -0.8684762716293335f, 0.0f, 0.0f));
// _0_0_10
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_11
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-0.8684762716293335f, 0.49573075771331787f, -0.49573075771331787f, -0.8684762716293335f, 0.0f, 0.0f));
// _0_0_12
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.37704918f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_13
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(15.373706f, 125.69402f);
generalPath.curveTo(22.221464f, 125.74933f, 27.996107f, 124.98911f, 29.405975f, 125.0239f);
generalPath.curveTo(38.73244f, 125.25394f, 61.07722f, 120.9265f, 52.14107f, 115.60666f);
generalPath.curveTo(42.378445f, 109.79479f, 15.545252f, 109.95091f, 5.0973773f, 115.55487f);
generalPath.curveTo(-6.30459f, 121.67058f, 8.527061f, 125.63869f, 15.373706f, 125.69402f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(29.962148666381836, 131.46768188476562), 27.01967f, new Point2D.Double(29.962148666381836, 131.46768188476562), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.7097439765930176f, -0.01627429947257042f, 0.0036760829389095306f, 0.16032099723815918f, 7.971983909606934f, 102.5261001586914f));
g.setPaint(paint);
g.fill(shape);
paint = new RadialGradientPaint(new Point2D.Double(27.56598472595215, 130.94268798828125), 27.01967f, new Point2D.Double(27.56598472595215, 130.94268798828125), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.28033700585365295f, 0.0f, 85.27880859375f));
stroke = new BasicStroke(2.152f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(15.373706f, 125.69402f);
generalPath.curveTo(22.221464f, 125.74933f, 27.996107f, 124.98911f, 29.405975f, 125.0239f);
generalPath.curveTo(38.73244f, 125.25394f, 61.07722f, 120.9265f, 52.14107f, 115.60666f);
generalPath.curveTo(42.378445f, 109.79479f, 15.545252f, 109.95091f, 5.0973773f, 115.55487f);
generalPath.curveTo(-6.30459f, 121.67058f, 8.527061f, 125.63869f, 15.373706f, 125.69402f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.3647541f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_14
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(127.69448f, 121.47017f);
generalPath.curveTo(127.7968f, 123.81001f, 115.65001f, 125.9766f, 95.85357f, 127.14955f);
generalPath.curveTo(76.05714f, 128.32251f, 51.637344f, 128.32251f, 31.84091f, 127.14955f);
generalPath.curveTo(12.044474f, 125.9766f, -0.10231576f, 123.81001f, 0.0f, 121.47017f);
generalPath.curveTo(-0.10231576f, 119.130325f, 12.044474f, 116.96374f, 31.84091f, 115.79079f);
generalPath.curveTo(51.637344f, 114.61783f, 76.05714f, 114.61783f, 95.85357f, 115.79079f);
generalPath.curveTo(115.65001f, 116.96374f, 127.7968f, 119.130325f, 127.69448f, 121.47017f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(63.84724044799805, 121.47016906738281), 63.84724f, new Point2D.Double(95.48064422607422, 121.47016906738281), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.10227300226688385f, 0.0f, 109.0470962524414f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_16
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-300.30743f, -39.677948f);
generalPath.lineTo(-300.30743f, -42.472656f);
generalPath.lineTo(-300.30743f, -39.677948f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.25f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_18
paint = new Color(0, 0, 0, 85);
stroke = new BasicStroke(2.9774685f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(86.08322f, 14.267693f);
generalPath.curveTo(90.98215f, 22.989826f, 116.60724f, 68.61337f, 121.50614f, 77.3355f);
generalPath.curveTo(126.40506f, 86.05764f, 115.66144f, 101.33267f, 97.519325f, 111.43471f);
generalPath.curveTo(79.37719f, 121.53674f, 60.68177f, 122.65416f, 55.782852f, 113.93203f);
generalPath.curveTo(50.88395f, 105.20991f, 25.25885f, 59.586353f, 20.35992f, 50.86422f);
generalPath.curveTo(15.461006f, 42.142094f, 26.20462f, 26.867058f, 44.346764f, 16.765024f);
generalPath.curveTo(62.48889f, 6.6629853f, 81.184326f, 5.545552f, 86.08322f, 14.267693f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.3f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_19
paint = new Color(0, 0, 0, 85);
stroke = new BasicStroke(1.9849792f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(86.08322f, 14.267693f);
generalPath.curveTo(90.98215f, 22.989826f, 116.60724f, 68.61337f, 121.50614f, 77.3355f);
generalPath.curveTo(126.40506f, 86.05764f, 115.66144f, 101.33267f, 97.519325f, 111.43471f);
generalPath.curveTo(79.37719f, 121.53674f, 60.68177f, 122.65416f, 55.782852f, 113.93203f);
generalPath.curveTo(50.88395f, 105.20991f, 25.25885f, 59.586353f, 20.35992f, 50.86422f);
generalPath.curveTo(15.461006f, 42.142094f, 26.20462f, 26.867058f, 44.346764f, 16.765024f);
generalPath.curveTo(62.48889f, 6.6629853f, 81.184326f, 5.545552f, 86.08322f, 14.267693f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_20
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(86.07858f, 13.960252f);
generalPath.curveTo(90.97751f, 22.682386f, 116.60259f, 68.30594f, 121.5015f, 77.02807f);
generalPath.curveTo(126.40042f, 85.7502f, 115.65681f, 101.02523f, 97.51468f, 111.12727f);
generalPath.curveTo(79.37254f, 121.2293f, 60.677124f, 122.34672f, 55.77821f, 113.62459f);
generalPath.curveTo(50.879303f, 104.90247f, 25.254208f, 59.278915f, 20.355278f, 50.556786f);
generalPath.curveTo(15.456362f, 41.834656f, 26.199976f, 26.55962f, 44.34212f, 16.457586f);
generalPath.curveTo(62.484245f, 6.3555484f, 81.179665f, 5.2381215f, 86.07858f, 13.960252f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(-70.05706787109375, 95.78132629394531), new Point2D.Double(-27.889699935913086, 66.67145538330078), new float[] {0.0f,0.4259708f,0.5892781f,0.8021978f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 255),new Color(241, 241, 241, 255),new Color(234, 234, 234, 255),new Color(223, 223, 223, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.1295219659805298f, 0.08477695286273956f, 0.05309183895587921f, 1.2066479921340942f, 150.0366973876953f, -10.453319549560547f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.40573773f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_21
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(86.07858f, 13.960252f);
generalPath.curveTo(90.97751f, 22.682386f, 116.60259f, 68.30594f, 121.5015f, 77.02807f);
generalPath.curveTo(126.40042f, 85.7502f, 115.65681f, 101.02523f, 97.51468f, 111.12727f);
generalPath.curveTo(79.37254f, 121.2293f, 60.677124f, 122.34672f, 55.77821f, 113.62459f);
generalPath.curveTo(50.879303f, 104.90247f, 25.254208f, 59.278915f, 20.355278f, 50.556786f);
generalPath.curveTo(15.456362f, 41.834656f, 26.199976f, 26.55962f, 44.34212f, 16.457586f);
generalPath.curveTo(62.484245f, 6.3555484f, 81.179665f, 5.2381215f, 86.07858f, 13.960252f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(70.62369537353516, 53.38029861450195), 53.565186f, new Point2D.Double(70.96444702148438, 76.70208740234375), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(255, 255, 255, 0),new Color(127, 127, 127, 0),new Color(0, 0, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.1263689994812012f, -0.5780050158500671f, 0.7066869735717773f, 1.338258981704712f, -56.17695999145508f, 13.710760116577148f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_22
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(86.07858f, 13.960252f);
generalPath.curveTo(90.97751f, 22.682386f, 116.60259f, 68.30594f, 121.5015f, 77.02807f);
generalPath.curveTo(126.40042f, 85.7502f, 115.65681f, 101.02523f, 97.51468f, 111.12727f);
generalPath.curveTo(79.37254f, 121.2293f, 60.677124f, 122.34672f, 55.77821f, 113.62459f);
generalPath.curveTo(50.879303f, 104.90247f, 25.254208f, 59.278915f, 20.355278f, 50.556786f);
generalPath.curveTo(15.456362f, 41.834656f, 26.199976f, 26.55962f, 44.34212f, 16.457586f);
generalPath.curveTo(62.484245f, 6.3555484f, 81.179665f, 5.2381215f, 86.07858f, 13.960252f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(-116.7874526977539, 116.55856323242188), new Point2D.Double(-84.77729034423828, 93.5679702758789), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.1295219659805298f, 0.08477695286273956f, 0.05309183895587921f, 1.2066479921340942f, 150.0366973876953f, -10.453319549560547f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.4f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9811879992485046f, -0.5463510155677795f, 0.37161800265312195f, 0.661637008190155f, 152.27980041503906f, -63.940879821777344f));
// _0_0_23
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-84.361115f, 47.981f);
generalPath.curveTo(-84.307434f, 56.53853f, -90.68003f, 64.46244f, -101.06588f, 68.75229f);
generalPath.curveTo(-111.45173f, 73.04214f, -124.263145f, 73.04214f, -134.64899f, 68.75229f);
generalPath.curveTo(-145.03484f, 64.46244f, -151.40744f, 56.53853f, -151.35376f, 47.981f);
generalPath.curveTo(-151.40744f, 39.42347f, -145.03484f, 31.49956f, -134.64899f, 27.20971f);
generalPath.curveTo(-124.263145f, 22.919859f, -111.45173f, 22.919859f, -101.06588f, 27.20971f);
generalPath.curveTo(-90.68003f, 31.49956f, -84.307434f, 39.42347f, -84.361115f, 47.981f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(-146.751708984375, 74.95999145507812), new Point2D.Double(-123.6665267944336, 73.41511535644531), new float[] {0.0f,0.4065934f,0.45329672f,0.5f,0.70604396f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 174),new Color(0, 0, 0, 124),new Color(0, 0, 0, 92),new Color(0, 0, 0, 39),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.4f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9811879992485046f, -0.5463510155677795f, 0.37161800265312195f, 0.661637008190155f, 151.31700134277344f, -64.04473876953125f));
// _0_0_24
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-84.361115f, 47.981f);
generalPath.curveTo(-84.307434f, 56.53853f, -90.68003f, 64.46244f, -101.06588f, 68.75229f);
generalPath.curveTo(-111.45173f, 73.04214f, -124.263145f, 73.04214f, -134.64899f, 68.75229f);
generalPath.curveTo(-145.03484f, 64.46244f, -151.40744f, 56.53853f, -151.35376f, 47.981f);
generalPath.curveTo(-151.40744f, 39.42347f, -145.03484f, 31.49956f, -134.64899f, 27.20971f);
generalPath.curveTo(-124.263145f, 22.919859f, -111.45173f, 22.919859f, -101.06588f, 27.20971f);
generalPath.curveTo(-90.68003f, 31.49956f, -84.307434f, 39.42347f, -84.361115f, 47.981f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(-82.5097427368164, 64.065185546875), new Point2D.Double(-118.91475677490234, 63.44707489013672), new float[] {0.0f,0.4065934f,0.45329672f,0.5f,0.70604396f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 174),new Color(0, 0, 0, 124),new Color(0, 0, 0, 92),new Color(0, 0, 0, 39),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.4f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9811879992485046f, -0.5463510155677795f, 0.37161800265312195f, 0.661637008190155f, 151.31700134277344f, -64.04473876953125f));
// _0_0_25
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-84.361115f, 47.981f);
generalPath.curveTo(-84.307434f, 56.53853f, -90.68003f, 64.46244f, -101.06588f, 68.75229f);
generalPath.curveTo(-111.45173f, 73.04214f, -124.263145f, 73.04214f, -134.64899f, 68.75229f);
generalPath.curveTo(-145.03484f, 64.46244f, -151.40744f, 56.53853f, -151.35376f, 47.981f);
generalPath.curveTo(-151.40744f, 39.42347f, -145.03484f, 31.49956f, -134.64899f, 27.20971f);
generalPath.curveTo(-124.263145f, 22.919859f, -111.45173f, 22.919859f, -101.06588f, 27.20971f);
generalPath.curveTo(-90.68003f, 31.49956f, -84.307434f, 39.42347f, -84.361115f, 47.981f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(-113.64350128173828, 78.29383087158203), new Point2D.Double(-118.3001937866211, 33.764427185058594), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_26
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(86.175316f, 14.144517f);
generalPath.curveTo(86.47506f, 14.678203f, 87.55732f, 16.579153f, 87.77727f, 16.970747f);
generalPath.curveTo(92.676186f, 25.69288f, 81.9484f, 40.96151f, 63.806274f, 51.06355f);
generalPath.curveTo(45.664135f, 61.16558f, 26.985228f, 62.291836f, 22.086311f, 53.569702f);
generalPath.curveTo(21.821533f, 53.09829f, 20.55641f, 50.832024f, 20.17709f, 50.156666f);
generalPath.curveTo(20.30276f, 51.53979f, 20.667326f, 52.819427f, 21.331333f, 54.001617f);
generalPath.curveTo(23.869791f, 58.521164f, 29.999317f, 60.46556f, 37.708336f, 60.003876f);
generalPath.curveTo(45.417355f, 59.54219f, 54.7785f, 56.681877f, 63.969032f, 51.564342f);
generalPath.curveTo(73.15957f, 46.446804f, 80.49596f, 40.042553f, 84.926834f, 33.744415f);
generalPath.curveTo(89.35772f, 27.446274f, 90.867226f, 21.231024f, 88.32876f, 16.711473f);
generalPath.curveTo(87.775375f, 15.726211f, 87.04797f, 14.885201f, 86.175316f, 14.144517f);
generalPath.closePath();
shape = generalPath;
paint = new Color(202, 202, 202, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.4f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_27
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(76.72064f, 9.44609f);
generalPath.curveTo(68.451584f, 8.532639f, 56.88424f, 11.342217f, 45.5454f, 17.65598f);
generalPath.curveTo(27.40325f, 27.757994f, 16.65105f, 43.04895f, 21.54996f, 51.771076f);
generalPath.curveTo(21.917528f, 52.425507f, 22.381548f, 53.003212f, 22.898445f, 53.547195f);
generalPath.curveTo(22.63023f, 53.20102f, 22.377228f, 52.86082f, 22.161367f, 52.476505f);
generalPath.curveTo(17.262459f, 43.75438f, 28.014658f, 28.463425f, 46.156807f, 18.361408f);
generalPath.curveTo(62.930237f, 9.021524f, 80.173454f, 7.360404f, 86.55251f, 14.056021f);
generalPath.curveTo(84.53678f, 11.462824f, 81.09283f, 9.929072f, 76.72064f, 9.44609f);
generalPath.closePath();
shape = generalPath;
paint = new Color(186, 189, 182, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_28
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(59.474255f, 68.01234f);
generalPath.lineTo(84.311356f, 109.91412f);
generalPath.curveTo(99.162285f, 103.24193f, 116.63784f, 87.654205f, 119.47193f, 77.30627f);
generalPath.lineTo(95.28071f, 34.66616f);
generalPath.curveTo(92.2947f, 49.841373f, 74.12331f, 61.005417f, 59.474255f, 68.01234f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(106.2739028930664, 52.468563079833984), new Point2D.Double(79.5440902709961, 69.99189758300781), new float[] {0.0f,0.09292036f,0.5043171f,0.91571385f,1.0f}, new Color[] {new Color(154, 118, 0, 255),new Color(227, 173, 0, 255),new Color(255, 205, 44, 255),new Color(227, 173, 0, 255),new Color(185, 141, 0, 255)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9614589810371399f, -0.04366597905755043f, -0.005518000107258558f, 1.1210520267486572f, 8.015667915344238f, -2.9870190620422363f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9798160195350647f, -0.5465120077133179f, 0.3711160123348236f, 0.6615949869155884f, 151.13119506835938f, -64.0669174194336f));
// _0_0_29
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(1.6126516f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-84.361115f, 47.981f);
generalPath.curveTo(-84.307434f, 56.53853f, -90.68003f, 64.46244f, -101.06588f, 68.75229f);
generalPath.curveTo(-111.45173f, 73.04214f, -124.263145f, 73.04214f, -134.64899f, 68.75229f);
generalPath.curveTo(-145.03484f, 64.46244f, -151.40744f, 56.53853f, -151.35376f, 47.981f);
generalPath.curveTo(-151.40744f, 39.42347f, -145.03484f, 31.49956f, -134.64899f, 27.20971f);
generalPath.curveTo(-124.263145f, 22.919859f, -111.45173f, 22.919859f, -101.06588f, 27.20971f);
generalPath.curveTo(-90.68003f, 31.49956f, -84.307434f, 39.42347f, -84.361115f, 47.981f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_30
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(19.565592f, 44.07871f);
generalPath.curveTo(19.288776f, 46.40352f, 19.590769f, 48.563442f, 20.594456f, 50.40688f);
generalPath.curveTo(25.333979f, 59.111805f, 42.91558f, 56.9655f, 60.935013f, 47.738445f);
generalPath.curveTo(65.75341f, 45.271126f, 69.73401f, 42.294395f, 70.78305f, 41.418568f);
generalPath.curveTo(63.272762f, 36.70413f, 22.341745f, 32.47607f, 19.565592f, 44.07871f);
generalPath.closePath();
shape = generalPath;
paint = new Color(183, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_31
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(75.91941f, 8.267599f);
generalPath.curveTo(74.32025f, 8.093961f, 72.58884f, 8.079081f, 70.75175f, 8.189535f);
generalPath.curveTo(63.403404f, 8.631355f, 54.39895f, 11.366976f, 45.492947f, 16.334478f);
generalPath.curveTo(36.586945f, 21.301981f, 29.520496f, 27.517878f, 25.297035f, 33.530464f);
generalPath.curveTo(24.374664f, 34.843567f, 23.59643f, 36.159657f, 22.952984f, 37.43395f);
generalPath.curveTo(23.540272f, 36.333748f, 24.243547f, 35.237076f, 25.035446f, 34.10972f);
generalPath.curveTo(29.258907f, 28.097124f, 36.324875f, 21.849207f, 45.230873f, 16.881704f);
generalPath.curveTo(54.13687f, 11.914197f, 63.14133f, 9.17858f, 70.48968f, 8.73676f);
generalPath.curveTo(77.83802f, 8.29494f, 83.49966f, 10.102715f, 85.83225f, 14.261084f);
generalPath.curveTo(87.43591f, 17.119967f, 87.28495f, 20.759426f, 85.65947f, 24.697466f);
generalPath.curveTo(87.50555f, 20.544144f, 87.773384f, 16.707153f, 86.09433f, 13.713858f);
generalPath.curveTo(84.34487f, 10.595082f, 80.716866f, 8.788514f, 75.91941f, 8.267599f);
generalPath.closePath();
generalPath.moveTo(86.407196f, 26.472698f);
generalPath.curveTo(85.78515f, 27.645126f, 85.041985f, 28.820522f, 84.20777f, 30.008114f);
generalPath.curveTo(79.75866f, 36.341934f, 72.42238f, 42.779564f, 63.21161f, 47.91706f);
generalPath.curveTo(54.00084f, 53.054554f, 44.647484f, 55.93129f, 36.906548f, 56.396717f);
generalPath.curveTo(29.165606f, 56.862144f, 23.00417f, 54.89915f, 20.444473f, 50.33594f);
generalPath.curveTo(18.684683f, 47.19874f, 18.870728f, 43.246365f, 20.604189f, 39.034893f);
generalPath.curveTo(18.643396f, 43.465027f, 18.341833f, 47.60196f, 20.1824f, 50.883167f);
generalPath.curveTo(22.742096f, 55.446377f, 28.903534f, 57.409367f, 36.644474f, 56.943943f);
generalPath.curveTo(44.385414f, 56.47852f, 53.738766f, 53.60178f, 62.949535f, 48.464287f);
generalPath.curveTo(72.16031f, 43.32679f, 79.49707f, 36.921185f, 83.946175f, 30.587366f);
generalPath.curveTo(84.910675f, 29.214294f, 85.72795f, 27.823233f, 86.407196f, 26.472698f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 101);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_32
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(76.45258f, 8.034723f);
generalPath.curveTo(74.853424f, 7.8610864f, 73.12152f, 7.8141828f, 71.28444f, 7.9246387f);
generalPath.curveTo(63.936092f, 8.366456f, 54.931637f, 11.102077f, 46.025635f, 16.06958f);
generalPath.curveTo(40.328465f, 19.247293f, 35.40208f, 22.950542f, 31.468899f, 26.776196f);
generalPath.curveTo(35.26205f, 23.229267f, 39.91793f, 19.839766f, 45.226837f, 16.878613f);
generalPath.curveTo(54.13284f, 11.911107f, 63.1373f, 9.175488f, 70.48564f, 8.733667f);
generalPath.curveTo(77.833984f, 8.291851f, 83.60878f, 10.126815f, 85.79972f, 14.359895f);
generalPath.curveTo(87.883766f, 18.386465f, 86.26675f, 24.14297f, 82.0433f, 30.155558f);
generalPath.curveTo(80.57677f, 32.24333f, 78.9308f, 34.17974f, 76.82328f, 36.256397f);
generalPath.curveTo(79.28966f, 33.9233f, 81.186226f, 31.703848f, 82.84209f, 29.346525f);
generalPath.curveTo(87.06556f, 23.333933f, 88.864494f, 17.838997f, 86.53188f, 13.680627f);
generalPath.curveTo(84.782425f, 10.561854f, 81.25004f, 8.555637f, 76.45258f, 8.034723f);
generalPath.closePath();
generalPath.moveTo(29.784527f, 26.626406f);
generalPath.curveTo(27.354559f, 28.961544f, 25.25228f, 31.351425f, 23.583864f, 33.72661f);
generalPath.curveTo(19.134754f, 40.06043f, 17.588583f, 46.313625f, 20.148277f, 50.876827f);
generalPath.curveTo(22.707973f, 55.44004f, 28.86941f, 57.40303f, 36.61035f, 56.937603f);
generalPath.curveTo(44.35129f, 56.472176f, 53.73473f, 53.59869f, 62.9455f, 48.461197f);
generalPath.curveTo(69.100494f, 45.028114f, 74.39183f, 41.018833f, 78.56988f, 36.84667f);
generalPath.curveTo(74.525505f, 40.72751f, 69.50104f, 44.44123f, 63.744297f, 47.652164f);
generalPath.curveTo(54.533524f, 52.789658f, 45.18066f, 55.698418f, 37.43972f, 56.16384f);
generalPath.curveTo(29.698778f, 56.62927f, 23.536856f, 54.634247f, 20.977161f, 50.071045f);
generalPath.curveTo(18.417465f, 45.507828f, 19.963638f, 39.25465f, 24.412746f, 32.920822f);
generalPath.curveTo(25.890022f, 30.817749f, 27.70524f, 28.704992f, 29.784527f, 26.626406f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 101);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_33
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(59.474255f, 68.01234f);
generalPath.lineTo(84.311356f, 109.91412f);
generalPath.curveTo(99.16229f, 103.24193f, 116.63784f, 87.654205f, 119.47193f, 77.30627f);
generalPath.lineTo(95.28071f, 34.66616f);
generalPath.curveTo(92.2947f, 49.841373f, 74.12331f, 61.005417f, 59.474255f, 68.01234f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(104.66047668457031, 65.8478012084961), 29.998838f, new Point2D.Double(115.72850036621094, 56.2811279296875), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.4535529911518097f, -0.26128700375556946f, 1.0320899486541748f, 1.791543960571289f, -20.210859298706055f, -24.2838191986084f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7827869f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_34
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(120.02654f, 75.20634f);
generalPath.curveTo(120.32266f, 75.73356f, 121.39183f, 77.6115f, 121.60911f, 77.99836f);
generalPath.curveTo(126.44873f, 86.61493f, 115.85079f, 101.69876f, 97.928246f, 111.67853f);
generalPath.curveTo(80.00568f, 121.65831f, 61.552837f, 122.77092f, 56.713215f, 114.15435f);
generalPath.curveTo(56.451637f, 113.68864f, 55.201824f, 111.4498f, 54.8271f, 110.78262f);
generalPath.curveTo(54.95125f, 112.14901f, 55.3114f, 113.41316f, 55.967373f, 114.58104f);
generalPath.curveTo(58.475105f, 119.04589f, 64.53045f, 120.96675f, 72.146164f, 120.51066f);
generalPath.curveTo(79.76189f, 120.05454f, 89.00973f, 117.22886f, 98.089035f, 112.17327f);
generalPath.curveTo(107.16832f, 107.11767f, 114.41592f, 100.79093f, 118.79317f, 94.569016f);
generalPath.curveTo(123.17043f, 88.34711f, 124.66168f, 82.20708f, 122.15393f, 77.742226f);
generalPath.curveTo(121.60724f, 76.76889f, 120.88864f, 75.93806f, 120.02654f, 75.20634f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(87.06843566894531, 146.89471435546875), new Point2D.Double(105.05599212646484, 58.6532096862793), new float[] {0.0f,1.0f}, new Color[] {new Color(57, 58, 56, 255),new Color(57, 58, 56, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9627749919891357f, 0.10389500111341476f, 0.015479009598493576f, 1.024791955947876f, 1.1813889741897583f, -2.598443031311035f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7827869f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_35
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(119.58033f, 74.6915f);
generalPath.curveTo(119.87645f, 75.21872f, 120.9456f, 77.096664f, 121.16289f, 77.48352f);
generalPath.curveTo(126.00251f, 86.10009f, 115.40457f, 101.18392f, 97.482025f, 111.1637f);
generalPath.curveTo(79.559456f, 121.14345f, 61.106617f, 122.25609f, 56.26699f, 113.6395f);
generalPath.curveTo(56.00542f, 113.1738f, 54.755604f, 110.93497f, 54.38088f, 110.26779f);
generalPath.curveTo(54.505028f, 111.63417f, 54.86518f, 112.89832f, 55.521152f, 114.0662f);
generalPath.curveTo(58.028885f, 118.53105f, 64.08423f, 120.45191f, 71.69994f, 119.99581f);
generalPath.curveTo(79.31566f, 119.53971f, 88.56351f, 116.71402f, 97.642815f, 111.65843f);
generalPath.curveTo(106.7221f, 106.60283f, 113.9697f, 100.27609f, 118.34695f, 94.05418f);
generalPath.curveTo(122.72421f, 87.83227f, 124.21545f, 81.69223f, 121.7077f, 77.22739f);
generalPath.curveTo(121.16102f, 76.25405f, 120.44241f, 75.42322f, 119.58033f, 74.6915f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(95.84687042236328, 117.2056884765625), new Point2D.Double(76.36178588867188, 88.40906524658203), new float[] {0.0f,1.0f}, new Color[] {new Color(57, 58, 56, 255),new Color(57, 58, 56, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9627749919891357f, 0.10389500111341476f, 0.015479009598493576f, 1.024791955947876f, 1.1813889741897583f, -2.598443031311035f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_36
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(15.373706f, 125.69402f);
generalPath.curveTo(22.221464f, 125.74933f, 27.996107f, 124.98911f, 29.405975f, 125.0239f);
generalPath.curveTo(38.73244f, 125.25394f, 61.07722f, 120.9265f, 52.14107f, 115.60666f);
generalPath.curveTo(42.378445f, 109.79479f, 15.545252f, 109.95091f, 5.0973773f, 115.55487f);
generalPath.curveTo(-6.30459f, 121.67058f, 8.527061f, 125.63869f, 15.373706f, 125.69402f);
generalPath.closePath();
shape = generalPath;
paint = new Color(185, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(174, 0, 0, 255);
stroke = new BasicStroke(0.75208664f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(15.373706f, 125.69402f);
generalPath.curveTo(22.221464f, 125.74933f, 27.996107f, 124.98911f, 29.405975f, 125.0239f);
generalPath.curveTo(38.73244f, 125.25394f, 61.07722f, 120.9265f, 52.14107f, 115.60666f);
generalPath.curveTo(42.378445f, 109.79479f, 15.545252f, 109.95091f, 5.0973773f, 115.55487f);
generalPath.curveTo(-6.30459f, 121.67058f, 8.527061f, 125.63869f, 15.373706f, 125.69402f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.88524634f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_37
paint = new LinearGradientPaint(new Point2D.Double(23.02284049987793, 104.74906158447266), new Point2D.Double(22.669342041015625, 135.73619079589844), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(0.077f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(15.322403f, 126.05314f);
generalPath.curveTo(22.170162f, 126.10845f, 27.970818f, 125.31015f, 29.380323f, 125.35737f);
generalPath.curveTo(38.792057f, 125.67268f, 61.866383f, 121.20263f, 52.39759f, 115.35014f);
generalPath.curveTo(42.73301f, 109.37665f, 15.545252f, 109.43788f, 4.7382545f, 115.34966f);
generalPath.curveTo(-6.612926f, 121.55912f, 8.475759f, 125.99781f, 15.322403f, 126.05314f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.4385246f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_38
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(84.311356f, 109.91412f);
generalPath.curveTo(99.16229f, 103.24193f, 116.63784f, 87.654205f, 119.47193f, 77.30627f);
generalPath.curveTo(102.01223f, 47.067432f, 69.03892f, 83.57913f, 84.311356f, 109.91412f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(98.66989135742188, 112.10143280029297), new Point2D.Double(74.32511901855469, 85.42376708984375), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(0, 0, 0, 114),new Color(0, 0, 0, 34),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 5.335533142089844f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_39
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(35.982327f, 55.747757f);
generalPath.curveTo(30.24759f, 55.610603f, 28.138458f, 60.217285f, 27.770193f, 64.69856f);
generalPath.curveTo(26.66944f, 78.09325f, 28.964888f, 87.4829f, 28.19733f, 98.200066f);
generalPath.curveTo(28.041653f, 100.37373f, 24.17295f, 102.55924f, 23.718245f, 97.71671f);
generalPath.curveTo(22.663063f, 86.47926f, 24.45652f, 78.59373f, 23.19495f, 63.072113f);
generalPath.curveTo(22.778255f, 57.945328f, 21.204723f, 53.02035f, 19.824348f, 47.15959f);
shape = generalPath;
paint = new Color(183, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.1f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(35.982327f, 55.747757f);
generalPath.curveTo(30.24759f, 55.610603f, 28.138458f, 60.217285f, 27.770193f, 64.69856f);
generalPath.curveTo(26.66944f, 78.09325f, 28.964888f, 87.4829f, 28.19733f, 98.200066f);
generalPath.curveTo(28.041653f, 100.37373f, 24.17295f, 102.55924f, 23.718245f, 97.71671f);
generalPath.curveTo(22.663063f, 86.47926f, 24.45652f, 78.59373f, 23.19495f, 63.072113f);
generalPath.curveTo(22.778255f, 57.945328f, 21.204723f, 53.02035f, 19.824348f, 47.15959f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_40
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(21.43323f, 51.631603f);
generalPath.curveTo(22.53314f, 55.958153f, 23.57408f, 59.862762f, 23.901213f, 63.887634f);
generalPath.curveTo(25.162783f, 79.40925f, 23.36942f, 87.30096f, 24.4246f, 98.538414f);
generalPath.curveTo(24.485174f, 99.183525f, 24.61387f, 99.69902f, 24.778772f, 100.11132f);
generalPath.curveTo(25.219997f, 99.66035f, 25.523756f, 99.08418f, 25.565475f, 98.50166f);
generalPath.curveTo(26.333035f, 87.78451f, 23.960684f, 78.526566f, 25.06144f, 65.131874f);
generalPath.curveTo(25.34952f, 61.626316f, 26.576317f, 57.04092f, 29.940802f, 56.06665f);
generalPath.curveTo(27.094194f, 54.590065f, 24.165434f, 53.167694f, 21.43323f, 51.631603f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(-16.602840423583984, 73.86382293701172), 4.390625f, new Point2D.Double(-16.602840423583984, 73.86382293701172), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9627749919891357f, 0.10389500111341476f, 0.1054140031337738f, 6.978878974914551f, 33.03078079223633f, -433.3987121582031f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_41
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(19.565592f, 44.07871f);
generalPath.curveTo(19.288776f, 46.40352f, 19.590769f, 48.563442f, 20.594456f, 50.40688f);
generalPath.curveTo(25.333979f, 59.111805f, 42.91558f, 56.9655f, 60.935013f, 47.738445f);
generalPath.curveTo(65.75341f, 45.271126f, 69.73401f, 42.294395f, 70.78305f, 41.418568f);
generalPath.curveTo(63.272762f, 36.70413f, 22.341745f, 32.47607f, 19.565592f, 44.07871f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(78.56920623779297, 22.051414489746094), new Point2D.Double(41.43761444091797, 59.810569763183594), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.6270492f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_42
paint = new LinearGradientPaint(new Point2D.Double(23.02284049987793, 104.74906158447266), new Point2D.Double(22.669342041015625, 135.73619079589844), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(0.277f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(15.322403f, 126.05314f);
generalPath.curveTo(22.170162f, 126.10845f, 27.970818f, 125.31015f, 29.380323f, 125.35737f);
generalPath.curveTo(38.792057f, 125.67268f, 61.78943f, 121.27958f, 52.320633f, 115.42709f);
generalPath.curveTo(42.656055f, 109.4536f, 15.596555f, 109.52766f, 4.789558f, 115.43944f);
generalPath.curveTo(-6.561623f, 121.6489f, 8.475759f, 125.99781f, 15.322403f, 126.05314f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.24590164f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_43
paint = new LinearGradientPaint(new Point2D.Double(23.02284049987793, 104.74906158447266), new Point2D.Double(22.669342041015625, 135.73619079589844), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(0.977f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(15.322403f, 126.05314f);
generalPath.curveTo(22.170162f, 126.10845f, 27.970818f, 125.31015f, 29.380323f, 125.35737f);
generalPath.curveTo(38.792057f, 125.67268f, 61.6147f, 121.54762f, 52.121113f, 115.73544f);
generalPath.curveTo(42.48653f, 109.83694f, 15.743585f, 109.91337f, 4.8983884f, 115.72965f);
generalPath.curveTo(-6.503923f, 121.84472f, 8.475759f, 125.99781f, 15.322403f, 126.05314f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.8196721f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_44
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(32.37081f, 111.10281f);
generalPath.curveTo(24.46055f, 110.80473f, 16.101856f, 111.59262f, 9.985697f, 113.39865f);
generalPath.curveTo(6.851011f, 116.25766f, 18.543636f, 119.04089f, 27.148237f, 119.25315f);
generalPath.curveTo(36.93204f, 119.4945f, 48.007668f, 116.69496f, 46.063755f, 112.96395f);
generalPath.curveTo(42.119175f, 111.91527f, 37.350586f, 111.29046f, 32.37081f, 111.10281f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(24.650917053222656, 111.04126739501953), new Point2D.Double(24.945655822753906, 122.54212188720703), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7008197f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_45
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(15.373706f, 125.69402f);
generalPath.curveTo(22.221464f, 125.74933f, 27.996107f, 124.98911f, 29.405975f, 125.0239f);
generalPath.curveTo(38.73244f, 125.25394f, 61.07722f, 120.9265f, 52.14107f, 115.60666f);
generalPath.curveTo(42.378445f, 109.79479f, 15.545252f, 109.95091f, 5.0973773f, 115.55487f);
generalPath.curveTo(-6.30459f, 121.67058f, 8.527061f, 125.63869f, 15.373706f, 125.69402f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(29.962148666381836, 131.46768188476562), 27.01967f, new Point2D.Double(29.962148666381836, 131.46768188476562), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.7097439765930176f, -0.01627429947257042f, 0.0036760829389095306f, 0.16032099723815918f, 7.971983909606934f, 102.5261001586914f));
g.setPaint(paint);
g.fill(shape);
paint = new RadialGradientPaint(new Point2D.Double(27.56598472595215, 130.94268798828125), 27.01967f, new Point2D.Double(27.56598472595215, 130.94268798828125), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.28033700585365295f, 0.0f, 85.27880859375f));
stroke = new BasicStroke(0.75208664f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(15.373706f, 125.69402f);
generalPath.curveTo(22.221464f, 125.74933f, 27.996107f, 124.98911f, 29.405975f, 125.0239f);
generalPath.curveTo(38.73244f, 125.25394f, 61.07722f, 120.9265f, 52.14107f, 115.60666f);
generalPath.curveTo(42.378445f, 109.79479f, 15.545252f, 109.95091f, 5.0973773f, 115.55487f);
generalPath.curveTo(-6.30459f, 121.67058f, 8.527061f, 125.63869f, 15.373706f, 125.69402f);
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
		return 128.0;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private color_fill() {
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
       color_fill base = new color_fill();
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
       color_fill base = new color_fill();
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
        return color_fill::new;
    }
}

