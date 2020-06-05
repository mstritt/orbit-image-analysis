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
public class slidepreview1 implements ResizableIcon {
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
g.transform(new AffineTransform(1.0666667222976685f, 0.0f, 0.0f, 1.0666667222976685f, -0.0f, -0.0f));
// _0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, -308.2699890136719f));
// _0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.0f, 5.690700054168701f, -5.093100070953369f, 0.0f, 1039.4000244140625f, 316.82000732421875f));
// _0_0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 104.2699966430664f, -312.0799865722656f));
// _0_0_0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7385900020599365f, 0.0f, 0.0f, 1.0f, -100.56999969482422f, 311.8800048828125f));
// _0_0_0_0_0
g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(11.862f, 10.266f);
generalPath.lineTo(11.89325f, 102.297f);
generalPath.lineTo(11.862f, 194.297f);
generalPath.lineTo(111.862f, 194.297f);
generalPath.lineTo(111.862f, 117.766f);
generalPath.lineTo(111.862f, 86.766f);
generalPath.lineTo(111.862f, 10.265999f);
generalPath.lineTo(11.8619995f, 10.265999f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(13.556f, 11.36f);
generalPath.lineTo(13.556f, 49.627f);
generalPath.lineTo(13.556f, 154.22699f);
generalPath.lineTo(13.556f, 192.49399f);
generalPath.lineTo(109.556f, 192.49399f);
generalPath.lineTo(109.556f, 109.82199f);
generalPath.lineTo(109.556f, 94.03699f);
generalPath.lineTo(109.556f, 11.36499f);
generalPath.lineTo(13.556f, 11.36499f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new LinearGradientPaint(new Point2D.Double(15.5, 98.56400299072266), new Point2D.Double(112.5, 98.56400299072266), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -2.4435999393463135f, 3.359999895095825f));
stroke = new BasicStroke(1.0f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(13.556f, 11.36f);
generalPath.lineTo(13.556f, 49.627f);
generalPath.lineTo(13.556f, 154.22699f);
generalPath.lineTo(13.556f, 192.49399f);
generalPath.lineTo(109.556f, 192.49399f);
generalPath.lineTo(109.556f, 109.82199f);
generalPath.lineTo(109.556f, 94.03699f);
generalPath.lineTo(109.556f, 11.36499f);
generalPath.lineTo(13.556f, 11.36499f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(15.703f, 10.452f);
generalPath.lineTo(15.703f, 49.077f);
generalPath.lineTo(15.703f, 154.657f);
generalPath.lineTo(15.703f, 193.282f);
generalPath.lineTo(112.602005f, 193.282f);
generalPath.lineTo(112.602005f, 109.836f);
generalPath.lineTo(112.602005f, 93.903f);
generalPath.lineTo(112.602005f, 10.457001f);
generalPath.lineTo(15.703003f, 10.457001f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(103.0999984741211, 56.262001037597656), 48.9f, new Point2D.Double(103.0999984741211, 56.262001037597656), new float[] {0.0f,1.0f}, new Color[] {new Color(210, 242, 255, 255),new Color(243, 243, 243, 201)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-1.2288999557495117f, 2.1689000129699707f, -1.6426000595092773f, -0.9307000041007996f, 323.0400085449219f, -153.86000061035156f));
g.setPaint(paint);
g.fill(shape);
paint = new RadialGradientPaint(new Point2D.Double(18.18199920654297, 147.3699951171875), 48.5f, new Point2D.Double(18.18199920654297, 147.3699951171875), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.8930000066757202f, -0.012714000418782234f, 0.012729000300168991f, 1.8952000141143799f, -18.08099937438965f, -89.3280029296875f));
stroke = new BasicStroke(1.8169f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(15.703f, 10.452f);
generalPath.lineTo(15.703f, 49.077f);
generalPath.lineTo(15.703f, 154.657f);
generalPath.lineTo(15.703f, 193.282f);
generalPath.lineTo(112.602005f, 193.282f);
generalPath.lineTo(112.602005f, 109.836f);
generalPath.lineTo(112.602005f, 93.903f);
generalPath.lineTo(112.602005f, 10.457001f);
generalPath.lineTo(15.703003f, 10.457001f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_3
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_3_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(47.032f, 42.984f);
generalPath.curveTo(46.911472f, 42.990303f, 46.804993f, 43.01315f, 46.68825f, 43.0465f);
generalPath.curveTo(46.100033f, 43.21456f, 43.872753f, 44.4056f, 43.56325f, 44.9215f);
generalPath.curveTo(43.072742f, 45.73902f, 44.14468f, 50.572002f, 44.407f, 51.359f);
generalPath.curveTo(44.734f, 52.339993f, 46.0047f, 55.4449f, 45.4382f, 56.5778f);
generalPath.curveTo(45.17393f, 57.106342f, 40.5993f, 56.53452f, 39.8132f, 56.79655f);
generalPath.curveTo(39.56666f, 56.87873f, 39.42224f, 57.30453f, 39.1882f, 57.42155f);
generalPath.curveTo(36.475403f, 58.77795f, 36.06f, 60.65625f, 38.157f, 63.01535f);
generalPath.curveTo(38.92805f, 63.882782f, 39.5336f, 64.36895f, 40.4382f, 65.10915f);
generalPath.curveTo(41.23719f, 65.76287f, 42.070503f, 66.42635f, 42.9382f, 66.98415f);
generalPath.curveTo(42.9466f, 66.989555f, 43.064632f, 67.075676f, 43.15695f, 67.1404f);
generalPath.curveTo(42.289303f, 67.69818f, 41.45595f, 68.3617f, 40.65695f, 69.0154f);
generalPath.curveTo(39.752293f, 69.755585f, 39.14675f, 70.24171f, 38.37575f, 71.10921f);
generalPath.curveTo(36.27885f, 73.46821f, 36.694252f, 75.3466f, 39.40695f, 76.70301f);
generalPath.curveTo(39.64099f, 76.82003f, 39.78541f, 77.245834f, 40.03195f, 77.32801f);
generalPath.curveTo(40.81805f, 77.59004f, 45.39265f, 77.01822f, 45.65695f, 77.54676f);
generalPath.curveTo(46.223362f, 78.67956f, 44.95269f, 81.78456f, 44.62575f, 82.765564f);
generalPath.curveTo(44.36343f, 83.55252f, 43.29145f, 88.38557f, 43.782f, 89.203064f);
generalPath.curveTo(44.09154f, 89.71896f, 46.3188f, 90.909966f, 46.907f, 91.078064f);
generalPath.curveTo(47.023743f, 91.11141f, 47.130222f, 91.13426f, 47.25075f, 91.140564f);
generalPath.curveTo(47.61235f, 91.159325f, 48.01152f, 91.078064f, 48.37575f, 91.078064f);
generalPath.curveTo(48.92625f, 91.078064f, 49.68745f, 91.211075f, 50.21955f, 91.078064f);
generalPath.curveTo(53.54225f, 90.24738f, 58.22095f, 85.769966f, 60.21955f, 83.17187f);
generalPath.curveTo(60.93426f, 82.242744f, 63.45195f, 78.60547f, 62.71955f, 77.14067f);
generalPath.curveTo(62.50651f, 76.714584f, 62.35495f, 77.09552f, 62.09455f, 76.92192f);
generalPath.curveTo(61.931282f, 76.81307f, 61.85157f, 76.62452f, 61.6883f, 76.51567f);
generalPath.curveTo(61.19084f, 76.18403f, 60.6258f, 76.70851f, 60.6258f, 75.89067f);
generalPath.curveTo(60.6258f, 75.75192f, 60.52769f, 75.55128f, 60.6258f, 75.45317f);
generalPath.curveTo(60.63691f, 75.44206f, 63.133102f, 75.19518f, 63.3446f, 75.26567f);
generalPath.curveTo(63.53076f, 75.32772f, 63.57534f, 75.58416f, 63.75085f, 75.67192f);
generalPath.curveTo(63.90943f, 75.75121f, 64.14f, 75.59823f, 64.188354f, 75.45317f);
generalPath.curveTo(64.412254f, 74.78148f, 64.301636f, 71.902374f, 64.188354f, 71.10937f);
generalPath.curveTo(64.09435f, 70.45137f, 63.775833f, 69.65307f, 63.563354f, 69.015564f);
generalPath.curveTo(63.376583f, 68.455246f, 63.440384f, 67.65756f, 63.500854f, 66.92176f);
generalPath.lineTo(63.250854f, 66.92176f);
generalPath.curveTo(63.200726f, 66.2688f, 63.181244f, 65.59936f, 63.344604f, 65.10926f);
generalPath.curveTo(63.557083f, 64.47182f, 63.875603f, 63.673462f, 63.969604f, 63.01546f);
generalPath.curveTo(64.082886f, 62.22248f, 64.193504f, 59.34336f, 63.969604f, 58.67166f);
generalPath.curveTo(63.921253f, 58.5266f, 63.690685f, 58.373623f, 63.532104f, 58.45291f);
generalPath.curveTo(63.356594f, 58.540672f, 63.312016f, 58.79711f, 63.125854f, 58.85916f);
generalPath.curveTo(62.914383f, 58.929653f, 60.418255f, 58.68277f, 60.407055f, 58.67166f);
generalPath.curveTo(60.308945f, 58.57355f, 60.407055f, 58.37291f, 60.407055f, 58.23416f);
generalPath.curveTo(60.407055f, 57.41632f, 60.972095f, 57.9408f, 61.469555f, 57.60916f);
generalPath.curveTo(61.632824f, 57.500313f, 61.712536f, 57.31176f, 61.875805f, 57.20291f);
generalPath.curveTo(62.136204f, 57.029312f, 62.287766f, 57.41025f, 62.500805f, 56.98416f);
generalPath.curveTo(63.233246f, 55.51926f, 60.715504f, 51.88206f, 60.000805f, 50.95296f);
generalPath.curveTo(58.002205f, 48.35476f, 53.323505f, 43.87736f, 50.000805f, 43.04676f);
generalPath.curveTo(49.468784f, 42.91375f, 48.707504f, 43.04676f, 48.157005f, 43.04676f);
generalPath.curveTo(47.792774f, 43.04676f, 47.393604f, 42.9655f, 47.032005f, 42.98426f);
generalPath.closePath();
shape = generalPath;
paint = new Color(137, 93, 133, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_3_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(47.191f, 48.61f);
generalPath.curveTo(50.827503f, 55.3453f, 42.249302f, 59.389f, 41.9462f, 63.784f);
generalPath.curveTo(46.8872f, 66.9692f, 44.948803f, 71.0035f, 40.3067f, 72.1003f);
generalPath.curveTo(41.157143f, 78.598206f, 51.5997f, 71.89862f, 48.0064f, 80.6586f);
generalPath.curveTo(42.209103f, 90.7296f, 56.789402f, 87.1692f, 60.115402f, 82.2457f);
generalPath.curveTo(64.4092f, 78.31239f, 58.118202f, 75.499695f, 63.699f, 74.13789f);
generalPath.curveTo(61.9266f, 66.74249f, 62.093903f, 59.404892f, 57.6542f, 52.442894f);
generalPath.curveTo(55.631702f, 48.134495f, 51.0247f, 47.654293f, 47.366203f, 46.784294f);
shape = generalPath;
paint = new Color(170, 102, 183, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.78761f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_4
shape = new Rectangle2D.Double(18.937999725341797, 136.86000061035156, 88.88600158691406, 51.0099983215332);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new LinearGradientPaint(new Point2D.Double(57.01900100708008, 132.42999267578125), new Point2D.Double(55.387001037597656, 189.85000610351562), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(18.937999725341797, 136.86000061035156, 88.88600158691406, 51.0099983215332);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.2417999505996704f, 0.0f, 0.0f, 1.0f, -5.451399803161621f, 0.0f));
// _0_0_0_0_0_5
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 0.3838199973106384f, 221.75999450683594f, 165.1999969482422f));
// _0_0_0_0_0_5_0_0
g.setComposite(AlphaComposite.getInstance(3, 0.78761f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_0_0
shape = new Rectangle2D.Double(-186.74000549316406, 11.897000312805176, 0.9807800054550171, 37.02399826049805);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.13557f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-186.74000549316406, 11.897000312805176, 0.9807800054550171, 37.02399826049805);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_0_1
g.setComposite(AlphaComposite.getInstance(3, 0.78761f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_0_1_0
shape = new Rectangle2D.Double(-189.52999877929688, 11.928999900817871, 2.138200044631958, 36.959999084472656);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-189.52999877929688, 11.928999900817871, 2.138200044631958, 36.959999084472656);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.78761f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_0_1_1
shape = new Rectangle2D.Double(-196.3300018310547, 11.928999900817871, 2.138200044631958, 36.959999084472656);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-196.3300018310547, 11.928999900817871, 2.138200044631958, 36.959999084472656);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.78761f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_0_1_2
shape = new Rectangle2D.Double(-199.14999389648438, 11.928999900817871, 2.138200044631958, 36.959999084472656);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-199.14999389648438, 11.928999900817871, 2.138200044631958, 36.959999084472656);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.78761f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_0_2
shape = new Rectangle2D.Double(-178.72000122070312, 11.897000312805176, 0.9807800054550171, 37.02399826049805);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.13557f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-178.72000122070312, 11.897000312805176, 0.9807800054550171, 37.02399826049805);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.78761f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_0_3
shape = new Rectangle2D.Double(-172.99000549316406, 11.897000312805176, 0.9807800054550171, 37.02399826049805);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.13557f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-172.99000549316406, 11.897000312805176, 0.9807800054550171, 37.02399826049805);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_0_4
g.setComposite(AlphaComposite.getInstance(3, 0.78761f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_0_4_0
shape = new Rectangle2D.Double(-175.7899932861328, 11.928999900817871, 2.138200044631958, 36.959999084472656);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-175.7899932861328, 11.928999900817871, 2.138200044631958, 36.959999084472656);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.78761f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_0_4_1
shape = new Rectangle2D.Double(-182.5800018310547, 11.928999900817871, 2.138200044631958, 36.959999084472656);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-182.5800018310547, 11.928999900817871, 2.138200044631958, 36.959999084472656);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.78761f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_0_4_2
shape = new Rectangle2D.Double(-185.41000366210938, 11.928999900817871, 2.138200044631958, 36.959999084472656);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-185.41000366210938, 11.928999900817871, 2.138200044631958, 36.959999084472656);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.78761f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_0_5
shape = new Rectangle2D.Double(-164.97999572753906, 11.897000312805176, 0.9807800054550171, 37.02399826049805);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.13557f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-164.97999572753906, 11.897000312805176, 0.9807800054550171, 37.02399826049805);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-1.0f, 0.0f, 0.0f, 0.3838199973106384f, -112.37000274658203f, 165.1999969482422f));
// _0_0_0_0_0_5_0_1
g.setComposite(AlphaComposite.getInstance(3, 0.78761f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_1_0
shape = new Rectangle2D.Double(-186.74000549316406, 11.897000312805176, 0.9807800054550171, 37.02399826049805);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.13557f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-186.74000549316406, 11.897000312805176, 0.9807800054550171, 37.02399826049805);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_1_1
g.setComposite(AlphaComposite.getInstance(3, 0.78761f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_1_1_0
shape = new Rectangle2D.Double(-189.52999877929688, 11.928999900817871, 2.138200044631958, 36.959999084472656);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-189.52999877929688, 11.928999900817871, 2.138200044631958, 36.959999084472656);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.78761f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_1_1_1
shape = new Rectangle2D.Double(-196.3300018310547, 11.928999900817871, 2.138200044631958, 36.959999084472656);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-196.3300018310547, 11.928999900817871, 2.138200044631958, 36.959999084472656);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.78761f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_1_1_2
shape = new Rectangle2D.Double(-199.14999389648438, 11.928999900817871, 2.138200044631958, 36.959999084472656);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-199.14999389648438, 11.928999900817871, 2.138200044631958, 36.959999084472656);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.78761f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_1_2
shape = new Rectangle2D.Double(-178.72000122070312, 11.897000312805176, 0.9807800054550171, 37.02399826049805);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.13557f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-178.72000122070312, 11.897000312805176, 0.9807800054550171, 37.02399826049805);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.78761f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_1_3
shape = new Rectangle2D.Double(-172.99000549316406, 11.897000312805176, 0.9807800054550171, 37.02399826049805);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.13557f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-172.99000549316406, 11.897000312805176, 0.9807800054550171, 37.02399826049805);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_1_4
g.setComposite(AlphaComposite.getInstance(3, 0.78761f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_1_4_0
shape = new Rectangle2D.Double(-175.7899932861328, 11.928999900817871, 2.138200044631958, 36.959999084472656);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-175.7899932861328, 11.928999900817871, 2.138200044631958, 36.959999084472656);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.78761f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_1_4_1
shape = new Rectangle2D.Double(-182.5800018310547, 11.928999900817871, 2.138200044631958, 36.959999084472656);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-182.5800018310547, 11.928999900817871, 2.138200044631958, 36.959999084472656);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.78761f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_1_4_2
shape = new Rectangle2D.Double(-185.41000366210938, 11.928999900817871, 2.138200044631958, 36.959999084472656);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-185.41000366210938, 11.928999900817871, 2.138200044631958, 36.959999084472656);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.78761f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_1_5
shape = new Rectangle2D.Double(-164.97999572753906, 11.897000312805176, 0.9807800054550171, 37.02399826049805);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.13557f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-164.97999572753906, 11.897000312805176, 0.9807800054550171, 37.02399826049805);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9343100190162659f, 0.0f, 0.0f, 1.0702999830245972f, 0.0f, 0.0f));
// _0_0_0_0_0_6
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
generalPathText.moveTo(24.16161f, 146.07475f);
generalPathText.lineTo(24.16161f, 136.71182f);
generalPathText.lineTo(30.931532f, 136.71182f);
generalPathText.lineTo(30.931532f, 137.81459f);
generalPathText.lineTo(25.400633f, 137.81459f);
generalPathText.lineTo(25.400633f, 140.68436f);
generalPathText.lineTo(30.58239f, 140.68436f);
generalPathText.lineTo(30.58239f, 141.78288f);
generalPathText.lineTo(25.400633f, 141.78288f);
generalPathText.lineTo(25.400633f, 144.96773f);
generalPathText.lineTo(31.14868f, 144.96773f);
generalPathText.lineTo(31.14868f, 146.07475f);
generalPathText.lineTo(24.16161f, 146.07475f);
generalPathText.closePath();
generalPathText.moveTo(32.809227f, 146.07475f);
generalPathText.lineTo(32.809227f, 136.71182f);
generalPathText.lineTo(34.048252f, 136.71182f);
generalPathText.lineTo(34.048252f, 144.96773f);
generalPathText.lineTo(38.659462f, 144.96773f);
generalPathText.lineTo(38.659462f, 146.07475f);
generalPathText.lineTo(32.809227f, 146.07475f);
generalPathText.closePath();
generalPathText.moveTo(40.0837f, 146.07475f);
generalPathText.lineTo(40.0837f, 136.71182f);
generalPathText.lineTo(43.596394f, 136.71182f);
generalPathText.quadTo(44.66936f, 136.71182f, 45.31655f, 136.9971f);
generalPathText.quadTo(45.967995f, 137.2781f, 46.334167f, 137.86995f);
generalPathText.quadTo(46.70034f, 138.46178f, 46.70034f, 139.10472f);
generalPathText.quadTo(46.70034f, 139.70506f, 46.372486f, 140.23729f);
generalPathText.quadTo(46.048893f, 140.76526f, 45.393192f, 141.09311f);
generalPathText.quadTo(46.240494f, 141.34007f, 46.69608f, 141.94041f);
generalPathText.quadTo(47.155926f, 142.54077f, 47.155926f, 143.35826f);
generalPathText.quadTo(47.155926f, 144.01823f, 46.87491f, 144.58452f);
generalPathText.quadTo(46.598152f, 145.14655f, 46.1894f, 145.45311f);
generalPathText.quadTo(45.78065f, 145.75967f, 45.16327f, 145.91722f);
generalPathText.quadTo(44.550144f, 146.07475f, 43.656002f, 146.07475f);
generalPathText.lineTo(40.0837f, 146.07475f);
generalPathText.closePath();
generalPathText.moveTo(41.322723f, 140.64604f);
generalPathText.lineTo(43.34944f, 140.64604f);
generalPathText.quadTo(44.1712f, 140.64604f, 44.528854f, 140.53534f);
generalPathText.quadTo(45.001472f, 140.39484f, 45.23991f, 140.07124f);
generalPathText.quadTo(45.482605f, 139.7434f, 45.482605f, 139.25374f);
generalPathText.quadTo(45.482605f, 138.78539f, 45.25694f, 138.43198f);
generalPathText.quadTo(45.035534f, 138.07858f, 44.618267f, 137.9466f);
generalPathText.quadTo(44.20526f, 137.81459f, 43.19616f, 137.81459f);
generalPathText.lineTo(41.322723f, 137.81459f);
generalPathText.lineTo(41.322723f, 140.64604f);
generalPathText.closePath();
generalPathText.moveTo(41.322723f, 144.96773f);
generalPathText.lineTo(43.656002f, 144.96773f);
generalPathText.quadTo(44.256355f, 144.96773f, 44.49905f, 144.92514f);
generalPathText.quadTo(44.92483f, 144.8485f, 45.210106f, 144.66968f);
generalPathText.quadTo(45.499638f, 144.49084f, 45.68272f, 144.15022f);
generalPathText.quadTo(45.870064f, 143.80534f, 45.870064f, 143.35826f);
generalPathText.quadTo(45.870064f, 142.83456f, 45.60182f, 142.45135f);
generalPathText.quadTo(45.33358f, 142.06389f, 44.856705f, 141.90636f);
generalPathText.quadTo(44.38409f, 141.74881f, 43.48995f, 141.74881f);
generalPathText.lineTo(41.322723f, 141.74881f);
generalPathText.lineTo(41.322723f, 144.96773f);
generalPathText.closePath();
generalPathText.moveTo(48.394947f, 141.45503f);
generalPathText.quadTo(48.394947f, 139.79448f, 48.735573f, 138.78539f);
generalPathText.quadTo(49.0762f, 137.77202f, 49.74893f, 137.22276f);
generalPathText.quadTo(50.425926f, 136.67351f, 51.4478f, 136.67351f);
generalPathText.quadTo(52.201435f, 136.67351f, 52.767723f, 136.97581f);
generalPathText.quadTo(53.33827f, 137.2781f, 53.7087f, 137.85292f);
generalPathText.quadTo(54.07913f, 138.42346f, 54.28776f, 139.24522f);
generalPathText.quadTo(54.500652f, 140.06273f, 54.500652f, 141.45503f);
generalPathText.quadTo(54.500652f, 143.1028f, 54.160027f, 144.11617f);
generalPathText.quadTo(53.823658f, 145.12952f, 53.146667f, 145.68303f);
generalPathText.quadTo(52.473934f, 146.23656f, 51.4478f, 146.23656f);
generalPathText.quadTo(50.093815f, 146.23656f, 49.318893f, 145.2615f);
generalPathText.quadTo(48.394947f, 144.09486f, 48.394947f, 141.45503f);
generalPathText.closePath();
generalPathText.moveTo(49.574364f, 141.45503f);
generalPathText.quadTo(49.574364f, 143.76276f, 50.115105f, 144.5249f);
generalPathText.quadTo(50.655846f, 145.28706f, 51.4478f, 145.28706f);
generalPathText.quadTo(52.239754f, 145.28706f, 52.776237f, 144.52065f);
generalPathText.quadTo(53.31698f, 143.75424f, 53.31698f, 141.45503f);
generalPathText.quadTo(53.31698f, 139.14304f, 52.776237f, 138.38515f);
generalPathText.quadTo(52.239754f, 137.623f, 51.435028f, 137.623f);
generalPathText.quadTo(50.643074f, 137.623f, 50.170456f, 138.29573f);
generalPathText.quadTo(49.574364f, 139.15155f, 49.574364f, 141.45503f);
generalPathText.closePath();
generalPathText.moveTo(55.66942f, 141.45503f);
generalPathText.quadTo(55.66942f, 139.79448f, 56.010044f, 138.78539f);
generalPathText.quadTo(56.35067f, 137.77202f, 57.023403f, 137.22276f);
generalPathText.quadTo(57.700397f, 136.67351f, 58.72227f, 136.67351f);
generalPathText.quadTo(59.475906f, 136.67351f, 60.042194f, 136.97581f);
generalPathText.quadTo(60.61274f, 137.2781f, 60.98317f, 137.85292f);
generalPathText.quadTo(61.3536f, 138.42346f, 61.562233f, 139.24522f);
generalPathText.quadTo(61.775124f, 140.06273f, 61.775124f, 141.45503f);
generalPathText.quadTo(61.775124f, 143.1028f, 61.434498f, 144.11617f);
generalPathText.quadTo(61.09813f, 145.12952f, 60.42114f, 145.68303f);
generalPathText.quadTo(59.748405f, 146.23656f, 58.72227f, 146.23656f);
generalPathText.quadTo(57.368286f, 146.23656f, 56.593365f, 145.2615f);
generalPathText.quadTo(55.66942f, 144.09486f, 55.66942f, 141.45503f);
generalPathText.closePath();
generalPathText.moveTo(56.848835f, 141.45503f);
generalPathText.quadTo(56.848835f, 143.76276f, 57.389576f, 144.5249f);
generalPathText.quadTo(57.930317f, 145.28706f, 58.72227f, 145.28706f);
generalPathText.quadTo(59.514225f, 145.28706f, 60.05071f, 144.52065f);
generalPathText.quadTo(60.59145f, 143.75424f, 60.59145f, 141.45503f);
generalPathText.quadTo(60.59145f, 139.14304f, 60.05071f, 138.38515f);
generalPathText.quadTo(59.514225f, 137.623f, 58.7095f, 137.623f);
generalPathText.quadTo(57.917545f, 137.623f, 57.444927f, 138.29573f);
generalPathText.quadTo(56.848835f, 139.15155f, 56.848835f, 141.45503f);
generalPathText.closePath();
generalPathText.moveTo(63.11421f, 143.90753f);
generalPathText.lineTo(64.22124f, 143.80534f);
generalPathText.quadTo(64.36175f, 144.58452f, 64.75772f, 144.93791f);
generalPathText.quadTo(65.1537f, 145.28706f, 65.77108f, 145.28706f);
generalPathText.quadTo(66.30331f, 145.28706f, 66.69929f, 145.04436f);
generalPathText.quadTo(67.09952f, 144.80167f, 67.35499f, 144.39717f);
generalPathText.quadTo(67.61046f, 143.99268f, 67.78077f, 143.30292f);
generalPathText.quadTo(67.95534f, 142.61314f, 67.95534f, 141.89784f);
generalPathText.quadTo(67.95534f, 141.8212f, 67.95108f, 141.66792f);
generalPathText.quadTo(67.6062f, 142.21718f, 67.00585f, 142.5578f);
generalPathText.quadTo(66.40975f, 142.89842f, 65.71573f, 142.89842f);
generalPathText.quadTo(64.553345f, 142.89842f, 63.748623f, 142.05537f);
generalPathText.quadTo(62.943893f, 141.21233f, 62.943893f, 139.8328f);
generalPathText.quadTo(62.943893f, 138.41069f, 63.782684f, 137.5421f);
generalPathText.quadTo(64.621475f, 136.67351f, 65.88605f, 136.67351f);
generalPathText.quadTo(66.801476f, 136.67351f, 67.55511f, 137.1674f);
generalPathText.quadTo(68.312996f, 137.65706f, 68.70471f, 138.56822f);
generalPathText.quadTo(69.10069f, 139.47514f, 69.10069f, 141.19955f);
generalPathText.quadTo(69.10069f, 142.99635f, 68.70898f, 144.0608f);
generalPathText.quadTo(68.32151f, 145.121f, 67.55085f, 145.67877f);
generalPathText.quadTo(66.78018f, 146.23656f, 65.74554f, 146.23656f);
generalPathText.quadTo(64.64702f, 146.23656f, 63.94874f, 145.62769f);
generalPathText.quadTo(63.254715f, 145.01456f, 63.11421f, 143.90753f);
generalPathText.closePath();
generalPathText.moveTo(67.82335f, 139.77745f);
generalPathText.quadTo(67.82335f, 138.78539f, 67.29538f, 138.20631f);
generalPathText.quadTo(66.76741f, 137.623f, 66.02655f, 137.623f);
generalPathText.quadTo(65.26015f, 137.623f, 64.6896f, 138.24889f);
generalPathText.quadTo(64.12331f, 138.87479f, 64.12331f, 139.87112f);
generalPathText.quadTo(64.12331f, 140.76526f, 64.664055f, 141.32729f);
generalPathText.quadTo(65.204796f, 141.88507f, 65.99675f, 141.88507f);
generalPathText.quadTo(66.79296f, 141.88507f, 67.30815f, 141.32729f);
generalPathText.quadTo(67.82335f, 140.76526f, 67.82335f, 139.77745f);
generalPathText.closePath();
generalPathText.moveTo(70.21837f, 141.45503f);
generalPathText.quadTo(70.21837f, 139.79448f, 70.559f, 138.78539f);
generalPathText.quadTo(70.89962f, 137.77202f, 71.57236f, 137.22276f);
generalPathText.quadTo(72.249344f, 136.67351f, 73.271225f, 136.67351f);
generalPathText.quadTo(74.02486f, 136.67351f, 74.59114f, 136.97581f);
generalPathText.quadTo(75.16169f, 137.2781f, 75.53212f, 137.85292f);
generalPathText.quadTo(75.90255f, 138.42346f, 76.11118f, 139.24522f);
generalPathText.quadTo(76.32407f, 140.06273f, 76.32407f, 141.45503f);
generalPathText.quadTo(76.32407f, 143.1028f, 75.98345f, 144.11617f);
generalPathText.quadTo(75.64708f, 145.12952f, 74.97009f, 145.68303f);
generalPathText.quadTo(74.297356f, 146.23656f, 73.271225f, 146.23656f);
generalPathText.quadTo(71.91724f, 146.23656f, 71.14232f, 145.2615f);
generalPathText.quadTo(70.21837f, 144.09486f, 70.21837f, 141.45503f);
generalPathText.closePath();
generalPathText.moveTo(71.39778f, 141.45503f);
generalPathText.quadTo(71.39778f, 143.76276f, 71.93853f, 144.5249f);
generalPathText.quadTo(72.47927f, 145.28706f, 73.271225f, 145.28706f);
generalPathText.quadTo(74.06317f, 145.28706f, 74.59966f, 144.52065f);
generalPathText.quadTo(75.1404f, 143.75424f, 75.1404f, 141.45503f);
generalPathText.quadTo(75.1404f, 139.14304f, 74.59966f, 138.38515f);
generalPathText.quadTo(74.06317f, 137.623f, 73.258446f, 137.623f);
generalPathText.quadTo(72.46649f, 137.623f, 71.99388f, 138.29573f);
generalPathText.quadTo(71.39778f, 139.15155f, 71.39778f, 141.45503f);
generalPathText.closePath();
generalPathText.moveTo(77.365105f, 143.2646f);
generalPathText.lineTo(77.365105f, 142.10648f);
generalPathText.lineTo(80.89483f, 142.10648f);
generalPathText.lineTo(80.89483f, 143.2646f);
generalPathText.lineTo(77.365105f, 143.2646f);
generalPathText.closePath();
generalPathText.moveTo(81.84858f, 141.45503f);
generalPathText.quadTo(81.84858f, 139.79448f, 82.18921f, 138.78539f);
generalPathText.quadTo(82.52983f, 137.77202f, 83.20257f, 137.22276f);
generalPathText.quadTo(83.879555f, 136.67351f, 84.901436f, 136.67351f);
generalPathText.quadTo(85.65507f, 136.67351f, 86.22135f, 136.97581f);
generalPathText.quadTo(86.7919f, 137.2781f, 87.16233f, 137.85292f);
generalPathText.quadTo(87.53276f, 138.42346f, 87.741394f, 139.24522f);
generalPathText.quadTo(87.954285f, 140.06273f, 87.954285f, 141.45503f);
generalPathText.quadTo(87.954285f, 143.1028f, 87.61366f, 144.11617f);
generalPathText.quadTo(87.27729f, 145.12952f, 86.6003f, 145.68303f);
generalPathText.quadTo(85.92757f, 146.23656f, 84.901436f, 146.23656f);
generalPathText.quadTo(83.54745f, 146.23656f, 82.77253f, 145.2615f);
generalPathText.quadTo(81.84858f, 144.09486f, 81.84858f, 141.45503f);
generalPathText.closePath();
generalPathText.moveTo(83.02799f, 141.45503f);
generalPathText.quadTo(83.02799f, 143.76276f, 83.56874f, 144.5249f);
generalPathText.quadTo(84.10948f, 145.28706f, 84.901436f, 145.28706f);
generalPathText.quadTo(85.69338f, 145.28706f, 86.22987f, 144.52065f);
generalPathText.quadTo(86.770615f, 143.75424f, 86.770615f, 141.45503f);
generalPathText.quadTo(86.770615f, 139.14304f, 86.22987f, 138.38515f);
generalPathText.quadTo(85.69338f, 137.623f, 84.88866f, 137.623f);
generalPathText.quadTo(84.0967f, 137.623f, 83.62409f, 138.29573f);
generalPathText.quadTo(83.02799f, 139.15155f, 83.02799f, 141.45503f);
generalPathText.closePath();
generalPathText.moveTo(89.123055f, 141.45503f);
generalPathText.quadTo(89.123055f, 139.79448f, 89.463684f, 138.78539f);
generalPathText.quadTo(89.804306f, 137.77202f, 90.47704f, 137.22276f);
generalPathText.quadTo(91.15403f, 136.67351f, 92.17591f, 136.67351f);
generalPathText.quadTo(92.92954f, 136.67351f, 93.49583f, 136.97581f);
generalPathText.quadTo(94.066376f, 137.2781f, 94.436806f, 137.85292f);
generalPathText.quadTo(94.807236f, 138.42346f, 95.01587f, 139.24522f);
generalPathText.quadTo(95.22876f, 140.06273f, 95.22876f, 141.45503f);
generalPathText.quadTo(95.22876f, 143.1028f, 94.88814f, 144.11617f);
generalPathText.quadTo(94.551765f, 145.12952f, 93.87478f, 145.68303f);
generalPathText.quadTo(93.20204f, 146.23656f, 92.17591f, 146.23656f);
generalPathText.quadTo(90.82192f, 146.23656f, 90.047005f, 145.2615f);
generalPathText.quadTo(89.123055f, 144.09486f, 89.123055f, 141.45503f);
generalPathText.closePath();
generalPathText.moveTo(90.30247f, 141.45503f);
generalPathText.quadTo(90.30247f, 143.76276f, 90.843216f, 144.5249f);
generalPathText.quadTo(91.38396f, 145.28706f, 92.17591f, 145.28706f);
generalPathText.quadTo(92.96786f, 145.28706f, 93.50435f, 144.52065f);
generalPathText.quadTo(94.04509f, 143.75424f, 94.04509f, 141.45503f);
generalPathText.quadTo(94.04509f, 139.14304f, 93.50435f, 138.38515f);
generalPathText.quadTo(92.96786f, 137.623f, 92.16313f, 137.623f);
generalPathText.quadTo(91.37118f, 137.623f, 90.89857f, 138.29573f);
generalPathText.quadTo(90.30247f, 139.15155f, 90.30247f, 141.45503f);
generalPathText.closePath();
generalPathText.moveTo(96.39753f, 141.45503f);
generalPathText.quadTo(96.39753f, 139.79448f, 96.73816f, 138.78539f);
generalPathText.quadTo(97.07878f, 137.77202f, 97.75152f, 137.22276f);
generalPathText.quadTo(98.428505f, 136.67351f, 99.450386f, 136.67351f);
generalPathText.quadTo(100.20402f, 136.67351f, 100.7703f, 136.97581f);
generalPathText.quadTo(101.34085f, 137.2781f, 101.71128f, 137.85292f);
generalPathText.quadTo(102.08171f, 138.42346f, 102.290344f, 139.24522f);
generalPathText.quadTo(102.503235f, 140.06273f, 102.503235f, 141.45503f);
generalPathText.quadTo(102.503235f, 143.1028f, 102.16261f, 144.11617f);
generalPathText.quadTo(101.82624f, 145.12952f, 101.149254f, 145.68303f);
generalPathText.quadTo(100.47652f, 146.23656f, 99.450386f, 146.23656f);
generalPathText.quadTo(98.0964f, 146.23656f, 97.32148f, 145.2615f);
generalPathText.quadTo(96.39753f, 144.09486f, 96.39753f, 141.45503f);
generalPathText.closePath();
generalPathText.moveTo(97.57694f, 141.45503f);
generalPathText.quadTo(97.57694f, 143.76276f, 98.11769f, 144.5249f);
generalPathText.quadTo(98.65843f, 145.28706f, 99.450386f, 145.28706f);
generalPathText.quadTo(100.24233f, 145.28706f, 100.778824f, 144.52065f);
generalPathText.quadTo(101.319565f, 143.75424f, 101.319565f, 141.45503f);
generalPathText.quadTo(101.319565f, 139.14304f, 100.778824f, 138.38515f);
generalPathText.quadTo(100.24233f, 137.623f, 99.43761f, 137.623f);
generalPathText.quadTo(98.64565f, 137.623f, 98.17304f, 138.29573f);
generalPathText.quadTo(97.57694f, 139.15155f, 97.57694f, 141.45503f);
generalPathText.closePath();
generalPathText.moveTo(103.842316f, 143.90753f);
generalPathText.lineTo(104.94935f, 143.80534f);
generalPathText.quadTo(105.08986f, 144.58452f, 105.48583f, 144.93791f);
generalPathText.quadTo(105.88181f, 145.28706f, 106.49919f, 145.28706f);
generalPathText.quadTo(107.03142f, 145.28706f, 107.4274f, 145.04436f);
generalPathText.quadTo(107.82763f, 144.80167f, 108.0831f, 144.39717f);
generalPathText.quadTo(108.33857f, 143.99268f, 108.50888f, 143.30292f);
generalPathText.quadTo(108.68345f, 142.61314f, 108.68345f, 141.89784f);
generalPathText.quadTo(108.68345f, 141.8212f, 108.67919f, 141.66792f);
generalPathText.quadTo(108.33431f, 142.21718f, 107.73396f, 142.5578f);
generalPathText.quadTo(107.13786f, 142.89842f, 106.44384f, 142.89842f);
generalPathText.quadTo(105.281456f, 142.89842f, 104.47673f, 142.05537f);
generalPathText.quadTo(103.672005f, 141.21233f, 103.672005f, 139.8328f);
generalPathText.quadTo(103.672005f, 138.41069f, 104.510796f, 137.5421f);
generalPathText.quadTo(105.34959f, 136.67351f, 106.61416f, 136.67351f);
generalPathText.quadTo(107.52959f, 136.67351f, 108.28322f, 137.1674f);
generalPathText.quadTo(109.04111f, 137.65706f, 109.43282f, 138.56822f);
generalPathText.quadTo(109.828804f, 139.47514f, 109.828804f, 141.19955f);
generalPathText.quadTo(109.828804f, 142.99635f, 109.43709f, 144.0608f);
generalPathText.quadTo(109.04962f, 145.121f, 108.27896f, 145.67877f);
generalPathText.quadTo(107.50829f, 146.23656f, 106.47365f, 146.23656f);
generalPathText.quadTo(105.37513f, 146.23656f, 104.67685f, 145.62769f);
generalPathText.quadTo(103.98283f, 145.01456f, 103.842316f, 143.90753f);
generalPathText.closePath();
generalPathText.moveTo(108.55146f, 139.77745f);
generalPathText.quadTo(108.55146f, 138.78539f, 108.02349f, 138.20631f);
generalPathText.quadTo(107.49552f, 137.623f, 106.75466f, 137.623f);
generalPathText.quadTo(105.98826f, 137.623f, 105.41771f, 138.24889f);
generalPathText.quadTo(104.85142f, 138.87479f, 104.85142f, 139.87112f);
generalPathText.quadTo(104.85142f, 140.76526f, 105.392166f, 141.32729f);
generalPathText.quadTo(105.93291f, 141.88507f, 106.72486f, 141.88507f);
generalPathText.quadTo(107.52107f, 141.88507f, 108.03626f, 141.32729f);
generalPathText.quadTo(108.55146f, 140.76526f, 108.55146f, 139.77745f);
generalPathText.closePath();
shapeText = generalPath;
gText.fill(shapeText);
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
    gText.dispose();
}
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-0.7411100268363953f, 0.0f, 0.0f, 0.7040200233459473f, 97.23999786376953f, 68.87799835205078f));
// _0_0_0_0_0_7
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_7_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(47.032f, 42.984f);
generalPath.curveTo(46.911472f, 42.990303f, 46.804993f, 43.01315f, 46.68825f, 43.0465f);
generalPath.curveTo(46.100033f, 43.21456f, 43.872753f, 44.4056f, 43.56325f, 44.9215f);
generalPath.curveTo(43.072742f, 45.73902f, 44.14468f, 50.572002f, 44.407f, 51.359f);
generalPath.curveTo(44.734f, 52.339993f, 46.0047f, 55.4449f, 45.4382f, 56.5778f);
generalPath.curveTo(45.17393f, 57.106342f, 40.5993f, 56.53452f, 39.8132f, 56.79655f);
generalPath.curveTo(39.56666f, 56.87873f, 39.42224f, 57.30453f, 39.1882f, 57.42155f);
generalPath.curveTo(36.475403f, 58.77795f, 36.06f, 60.65625f, 38.157f, 63.01535f);
generalPath.curveTo(38.92805f, 63.882782f, 39.5336f, 64.36895f, 40.4382f, 65.10915f);
generalPath.curveTo(41.23719f, 65.76287f, 42.070503f, 66.42635f, 42.9382f, 66.98415f);
generalPath.curveTo(42.9466f, 66.989555f, 43.064632f, 67.075676f, 43.15695f, 67.1404f);
generalPath.curveTo(42.289303f, 67.69818f, 41.45595f, 68.3617f, 40.65695f, 69.0154f);
generalPath.curveTo(39.752293f, 69.755585f, 39.14675f, 70.24171f, 38.37575f, 71.10921f);
generalPath.curveTo(36.27885f, 73.46821f, 36.694252f, 75.3466f, 39.40695f, 76.70301f);
generalPath.curveTo(39.64099f, 76.82003f, 39.78541f, 77.245834f, 40.03195f, 77.32801f);
generalPath.curveTo(40.81805f, 77.59004f, 45.39265f, 77.01822f, 45.65695f, 77.54676f);
generalPath.curveTo(46.223362f, 78.67956f, 44.95269f, 81.78456f, 44.62575f, 82.765564f);
generalPath.curveTo(44.36343f, 83.55252f, 43.29145f, 88.38557f, 43.782f, 89.203064f);
generalPath.curveTo(44.09154f, 89.71896f, 46.3188f, 90.909966f, 46.907f, 91.078064f);
generalPath.curveTo(47.023743f, 91.11141f, 47.130222f, 91.13426f, 47.25075f, 91.140564f);
generalPath.curveTo(47.61235f, 91.159325f, 48.01152f, 91.078064f, 48.37575f, 91.078064f);
generalPath.curveTo(48.92625f, 91.078064f, 49.68745f, 91.211075f, 50.21955f, 91.078064f);
generalPath.curveTo(53.54225f, 90.24738f, 58.22095f, 85.769966f, 60.21955f, 83.17187f);
generalPath.curveTo(60.93426f, 82.242744f, 63.45195f, 78.60547f, 62.71955f, 77.14067f);
generalPath.curveTo(62.50651f, 76.714584f, 62.35495f, 77.09552f, 62.09455f, 76.92192f);
generalPath.curveTo(61.931282f, 76.81307f, 61.85157f, 76.62452f, 61.6883f, 76.51567f);
generalPath.curveTo(61.19084f, 76.18403f, 60.6258f, 76.70851f, 60.6258f, 75.89067f);
generalPath.curveTo(60.6258f, 75.75192f, 60.52769f, 75.55128f, 60.6258f, 75.45317f);
generalPath.curveTo(60.63691f, 75.44206f, 63.133102f, 75.19518f, 63.3446f, 75.26567f);
generalPath.curveTo(63.53076f, 75.32772f, 63.57534f, 75.58416f, 63.75085f, 75.67192f);
generalPath.curveTo(63.90943f, 75.75121f, 64.14f, 75.59823f, 64.188354f, 75.45317f);
generalPath.curveTo(64.412254f, 74.78148f, 64.301636f, 71.902374f, 64.188354f, 71.10937f);
generalPath.curveTo(64.09435f, 70.45137f, 63.775833f, 69.65307f, 63.563354f, 69.015564f);
generalPath.curveTo(63.376583f, 68.455246f, 63.440384f, 67.65756f, 63.500854f, 66.92176f);
generalPath.lineTo(63.250854f, 66.92176f);
generalPath.curveTo(63.200726f, 66.2688f, 63.181244f, 65.59936f, 63.344604f, 65.10926f);
generalPath.curveTo(63.557083f, 64.47182f, 63.875603f, 63.673462f, 63.969604f, 63.01546f);
generalPath.curveTo(64.082886f, 62.22248f, 64.193504f, 59.34336f, 63.969604f, 58.67166f);
generalPath.curveTo(63.921253f, 58.5266f, 63.690685f, 58.373623f, 63.532104f, 58.45291f);
generalPath.curveTo(63.356594f, 58.540672f, 63.312016f, 58.79711f, 63.125854f, 58.85916f);
generalPath.curveTo(62.914383f, 58.929653f, 60.418255f, 58.68277f, 60.407055f, 58.67166f);
generalPath.curveTo(60.308945f, 58.57355f, 60.407055f, 58.37291f, 60.407055f, 58.23416f);
generalPath.curveTo(60.407055f, 57.41632f, 60.972095f, 57.9408f, 61.469555f, 57.60916f);
generalPath.curveTo(61.632824f, 57.500313f, 61.712536f, 57.31176f, 61.875805f, 57.20291f);
generalPath.curveTo(62.136204f, 57.029312f, 62.287766f, 57.41025f, 62.500805f, 56.98416f);
generalPath.curveTo(63.233246f, 55.51926f, 60.715504f, 51.88206f, 60.000805f, 50.95296f);
generalPath.curveTo(58.002205f, 48.35476f, 53.323505f, 43.87736f, 50.000805f, 43.04676f);
generalPath.curveTo(49.468784f, 42.91375f, 48.707504f, 43.04676f, 48.157005f, 43.04676f);
generalPath.curveTo(47.792774f, 43.04676f, 47.393604f, 42.9655f, 47.032005f, 42.98426f);
generalPath.closePath();
shape = generalPath;
paint = new Color(137, 93, 133, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_7_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(47.191f, 48.61f);
generalPath.curveTo(50.827503f, 55.3453f, 42.249302f, 59.389f, 41.9462f, 63.784f);
generalPath.curveTo(46.8872f, 66.9692f, 44.948803f, 71.0035f, 40.3067f, 72.1003f);
generalPath.curveTo(41.157143f, 78.598206f, 51.5997f, 71.89862f, 48.0064f, 80.6586f);
generalPath.curveTo(42.209103f, 90.7296f, 56.789402f, 87.1692f, 60.115402f, 82.2457f);
generalPath.curveTo(64.4092f, 78.31239f, 58.118202f, 75.499695f, 63.699f, 74.13789f);
generalPath.curveTo(61.9266f, 66.74249f, 62.093903f, 59.404892f, 57.6542f, 52.442894f);
generalPath.curveTo(55.631702f, 48.134495f, 51.0247f, 47.654293f, 47.366203f, 46.784294f);
shape = generalPath;
paint = new Color(170, 102, 183, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.83178f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-82.237f, 384.0f);
generalPath.curveTo(-74.0273f, 387.3505f, -71.222f, 388.1269f, -62.84f, 388.4452f);
generalPath.curveTo(-59.6087f, 388.5679f, -45.059f, 383.0726f, -41.826f, 382.9897f);
generalPath.curveTo(-41.826f, 382.9897f, -35.2518f, 392.2841f, -22.249f, 408.06268f);
generalPath.curveTo(-21.675282f, 408.75888f, -17.654001f, 406.42987f, -18.471f, 409.76227f);
generalPath.curveTo(-21.5489f, 422.31726f, 0.3899994f, 435.31726f, 8.688f, 442.19226f);
generalPath.curveTo(8.96766f, 442.0804f, 9.341249f, 442.04645f, 9.49622f, 441.78815f);
generalPath.curveTo(11.55102f, 438.36356f, 9.317639f, 441.31363f, 9.90033f, 439.56555f);
generalPath.curveTo(10.177409f, 438.7343f, 11.398729f, 435.95584f, 11.92093f, 435.12036f);
generalPath.curveTo(14.00163f, 431.79126f, 18.79083f, 424.41138f, 18.79083f, 424.41138f);
generalPath.curveTo(18.79083f, 424.41138f, -2.53117f, 401.37137f, -13.740168f, 395.11337f);
generalPath.curveTo(-15.983368f, 393.84546f, -18.271368f, 390.9326f, -20.407967f, 389.25378f);
generalPath.curveTo(-27.763367f, 383.4745f, -25.406166f, 385.2175f, -35.763966f, 379.55508f);
generalPath.curveTo(-37.429264f, 378.64474f, -39.014866f, 377.52847f, -40.815365f, 376.92838f);
generalPath.curveTo(-41.342266f, 376.75275f, -41.885365f, 377.23312f, -42.431767f, 377.3325f);

}

private void _paint1(Graphics2D g,float origAlpha) {
generalPath.curveTo(-44.353268f, 377.68185f, -40.827465f, 375.8826f, -45.462566f, 377.7366f);
generalPath.curveTo(-47.616165f, 378.59805f, -49.651665f, 379.7301f, -51.726265f, 380.7674f);
generalPath.curveTo(-52.209805f, 381.00916f, -52.789864f, 381.41766f, -53.342667f, 381.57562f);
generalPath.curveTo(-60.524868f, 383.62772f, -73.774666f, 385.4106f, -82.236664f, 384.00034f);
generalPath.closePath();
shape = generalPath;
paint = new Color(128, 128, 128, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(77, 77, 77, 255);
stroke = new BasicStroke(1.0f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-82.237f, 384.0f);
generalPath.curveTo(-74.0273f, 387.3505f, -71.222f, 388.1269f, -62.84f, 388.4452f);
generalPath.curveTo(-59.6087f, 388.5679f, -45.059f, 383.0726f, -41.826f, 382.9897f);
generalPath.curveTo(-41.826f, 382.9897f, -35.2518f, 392.2841f, -22.249f, 408.06268f);
generalPath.curveTo(-21.675282f, 408.75888f, -17.654001f, 406.42987f, -18.471f, 409.76227f);
generalPath.curveTo(-21.5489f, 422.31726f, 0.3899994f, 435.31726f, 8.688f, 442.19226f);
generalPath.curveTo(8.96766f, 442.0804f, 9.341249f, 442.04645f, 9.49622f, 441.78815f);
generalPath.curveTo(11.55102f, 438.36356f, 9.317639f, 441.31363f, 9.90033f, 439.56555f);
generalPath.curveTo(10.177409f, 438.7343f, 11.398729f, 435.95584f, 11.92093f, 435.12036f);
generalPath.curveTo(14.00163f, 431.79126f, 18.79083f, 424.41138f, 18.79083f, 424.41138f);
generalPath.curveTo(18.79083f, 424.41138f, -2.53117f, 401.37137f, -13.740168f, 395.11337f);
generalPath.curveTo(-15.983368f, 393.84546f, -18.271368f, 390.9326f, -20.407967f, 389.25378f);
generalPath.curveTo(-27.763367f, 383.4745f, -25.406166f, 385.2175f, -35.763966f, 379.55508f);
generalPath.curveTo(-37.429264f, 378.64474f, -39.014866f, 377.52847f, -40.815365f, 376.92838f);
generalPath.curveTo(-41.342266f, 376.75275f, -41.885365f, 377.23312f, -42.431767f, 377.3325f);
generalPath.curveTo(-44.353268f, 377.68185f, -40.827465f, 375.8826f, -45.462566f, 377.7366f);
generalPath.curveTo(-47.616165f, 378.59805f, -49.651665f, 379.7301f, -51.726265f, 380.7674f);
generalPath.curveTo(-52.209805f, 381.00916f, -52.789864f, 381.41766f, -53.342667f, 381.57562f);
generalPath.curveTo(-60.524868f, 383.62772f, -73.774666f, 385.4106f, -82.236664f, 384.00034f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2
g.setComposite(AlphaComposite.getInstance(3, 0.75543f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9869899749755859f, 0.0f, 0.0f, 0.978630006313324f, -104.56999969482422f, 310.82000732421875f));
// _0_0_0_0_2_0
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(4.9646f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(5.4074f, 41.0f);
generalPath.curveTo(5.4074f, 60.095f, 20.9044f, 75.593f, 40.000397f, 75.593f);
generalPath.curveTo(59.095398f, 75.593f, 74.5934f, 60.096f, 74.5934f, 41.000004f);
generalPath.curveTo(74.5934f, 21.905005f, 59.096397f, 6.4070053f, 40.0004f, 6.4070053f);
generalPath.curveTo(20.905401f, 6.4070053f, 5.407402f, 21.904005f, 5.407402f, 41.000004f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-1.0311000347137451f, -0.03793000057339668f, 0.04966599866747856f, -1.3436000347137451f, -27.29800033569336f, 385.25f));
// _0_0_0_0_2_1
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_1_0
paint = new LinearGradientPaint(new Point2D.Double(34.84199905395508, -7.142499923706055), new Point2D.Double(35.56100082397461, 11.416000366210938), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(0.414f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(9.6228f, 14.273f);
generalPath.curveTo(16.524f, 6.0827f, 26.347801f, 1.7529993f, 37.1158f, 1.7529993f);
generalPath.curveTo(47.883797f, 1.7529993f, 58.4088f, 7.2011995f, 64.412796f, 14.980999f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_1_1
paint = new LinearGradientPaint(new Point2D.Double(34.84199905395508, -7.142499923706055), new Point2D.Double(35.56100082397461, 11.416000366210938), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(0.914f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(9.6228f, 14.573f);
generalPath.curveTo(16.524f, 6.3827f, 26.347801f, 2.0529995f, 37.1158f, 2.0529995f);
generalPath.curveTo(47.883797f, 2.0529995f, 58.4088f, 7.5011997f, 64.412796f, 15.280999f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_1_2
paint = new LinearGradientPaint(new Point2D.Double(34.84199905395508, -7.142499923706055), new Point2D.Double(35.56100082397461, 11.416000366210938), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(0.614f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(9.6228f, 14.473f);
generalPath.curveTo(16.524f, 6.2826996f, 26.347801f, 1.9529991f, 37.1158f, 1.9529991f);
generalPath.curveTo(47.883797f, 1.9529991f, 58.4088f, 7.4011993f, 64.412796f, 15.180999f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_2
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_2_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-38.284f, 385.23f);
generalPath.curveTo(-34.3457f, 381.93262f, -31.1235f, 378.31122f, -28.512402f, 374.258f);
generalPath.curveTo(-7.110401f, 392.807f, 5.342598f, 404.57f, 22.9086f, 419.94098f);
generalPath.curveTo(19.6089f, 424.53506f, 15.7764f, 428.30518f, 12.0436f, 431.88397f);
generalPath.curveTo(-4.7964f, 415.69797f, -11.756399f, 410.95197f, -38.2844f, 385.22998f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(91.89399719238281, 98.322998046875), new Point2D.Double(102.63999938964844, 87.5780029296875), new float[] {0.0f,1.0f}, new Color[] {new Color(54, 54, 54, 255),new Color(179, 179, 179, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -105.08999633789062f, 309.8800048828125f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(23, 23, 23, 113);
stroke = new BasicStroke(1.0f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-38.284f, 385.23f);
generalPath.curveTo(-34.3457f, 381.93262f, -31.1235f, 378.31122f, -28.512402f, 374.258f);
generalPath.curveTo(-7.110401f, 392.807f, 5.342598f, 404.57f, 22.9086f, 419.94098f);
generalPath.curveTo(19.6089f, 424.53506f, 15.7764f, 428.30518f, 12.0436f, 431.88397f);
generalPath.curveTo(-4.7964f, 415.69797f, -11.756399f, 410.95197f, -38.2844f, 385.22998f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_2_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-30.828f, 377.52f);
generalPath.lineTo(-34.4638f, 381.6373f);
generalPath.curveTo(-30.663898f, 387.898f, -22.1988f, 397.3373f, -10.278799f, 408.5503f);
generalPath.curveTo(-0.52239895f, 417.728f, 8.3852005f, 424.7373f, 14.8962f, 428.94128f);
generalPath.curveTo(17.1789f, 426.8997f, 18.5235f, 425.3455f, 20.0873f, 423.5463f);
generalPath.curveTo(15.396199f, 417.1861f, 7.3182993f, 408.5623f, -2.5167007f, 399.3103f);
generalPath.curveTo(-14.356701f, 388.1733f, -24.484701f, 380.8293f, -30.827702f, 377.5193f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(3.9530999660491943, 74.83300018310547), 6.932f, new Point2D.Double(0.9055799841880798, 73.2959976196289), new float[] {0.0f,0.66372f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 61),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.4359700083732605f, -0.566100001335144f, 5.670899868011475f, 5.233699798583984f, -433.7300109863281f, 13.38700008392334f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_2_2
g.setComposite(AlphaComposite.getInstance(3, 0.7326f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_2_2_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-37.659f, 384.96f);
generalPath.curveTo(-34.4309f, 381.9875f, -31.3194f, 378.44968f, -28.633f, 374.82498f);
generalPath.curveTo(-11.816999f, 389.19498f, 5.7350006f, 405.69098f, 21.714f, 419.74997f);
generalPath.curveTo(18.2859f, 424.27936f, 17.086601f, 426.46497f, 12.201701f, 430.83298f);
generalPath.curveTo(-4.4082994f, 414.86597f, -21.6983f, 400.28897f, -37.659298f, 384.95898f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(49.15700149536133, 62.38100051879883), 8.3332f, new Point2D.Double(45.900001525878906, 62.29800033569336), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.6268500089645386f, -0.7038300037384033f, 7.6057000160217285f, 6.891600131988525f, -534.4500122070312f, -18.267000198364258f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.74419f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_2_2_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-36.597f, 385.4f);
generalPath.lineTo(-28.726799f, 381.3865f);
generalPath.curveTo(-11.910799f, 395.7565f, 2.7852f, 407.3085f, 20.0512f, 420.7475f);
generalPath.curveTo(17.5006f, 425.9685f, 15.791201f, 426.2425f, 11.364301f, 430.5502f);
generalPath.curveTo(-4.9847f, 414.7262f, -20.6357f, 400.7292f, -36.5967f, 385.3992f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(39.0359992980957, 69.15299987792969), 8.3332f, new Point2D.Double(36.2859992980957, 69.15299987792969), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.6268500089645386f, -0.7038300037384033f, 7.6057000160217285f, 6.891600131988525f, -535.2899780273438f, -18.54599952697754f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_2_2_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-28.666f, 374.13f);
generalPath.curveTo(-32.6043f, 377.4274f, -35.8338f, 381.057f, -38.4449f, 385.11002f);
generalPath.lineTo(-38.26895f, 385.26944f);
generalPath.curveTo(-34.33065f, 381.97205f, -31.10115f, 378.34244f, -28.490051f, 374.28943f);
generalPath.lineTo(-28.666f, 374.13f);
generalPath.closePath();
shape = generalPath;
paint = new Color(92, 92, 92, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.68367999792099f, -0.7920500040054321f, 0.188960000872612f, 0.16405999660491943f, -78.21399688720703f, 412.69000244140625f));
// _0_0_0_0_2_2_2_3
shape = new Ellipse2D.Double(48.53860092163086, 49.94240188598633, 10.56879997253418, 3.707200050354004);
paint = new RadialGradientPaint(new Point2D.Double(53.823001861572266, 51.79600143432617), 5.2844f, new Point2D.Double(53.362998962402344, 53.70399856567383), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.35076001286506653f, 0.0f, 33.62799835205078f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.65116f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.672249972820282f, -0.8017799854278564f, 0.19213999807834625f, 0.16032999753952026f, -27.104000091552734f, 458.25f));
// _0_0_0_0_2_2_2_4
shape = new Ellipse2D.Double(48.53860092163086, 49.94240188598633, 10.56879997253418, 3.707200050354004);
paint = new RadialGradientPaint(new Point2D.Double(53.823001861572266, 51.79600143432617), 5.2844f, new Point2D.Double(53.362998962402344, 53.70399856567383), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.35076001286506653f, 0.0f, 33.62799835205078f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_2_2_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-37.011f, 370.07f);
generalPath.curveTo(-39.165203f, 372.69162f, -41.1481f, 374.9367f, -43.091904f, 376.933f);
generalPath.lineTo(-36.558804f, 382.94333f);
generalPath.curveTo(-34.140404f, 380.69342f, -31.929504f, 378.54523f, -30.292004f, 376.19962f);
generalPath.lineTo(-37.011f, 370.06992f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(28.07200050354004, 20.204999923706055), new Point2D.Double(40.19900131225586, 20.204999923706055), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(174, 174, 174, 255)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-0.35819000005722046f, 0.4021799862384796f, 0.3968200087547302f, 0.3595600128173828f, -33.88999938964844f, 356.5899963378906f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_2_2_6
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-36.767f, 371.22f);
generalPath.curveTo(-38.9212f, 373.8416f, -40.7735f, 375.3644f, -42.7174f, 377.3607f);
generalPath.lineTo(-36.558f, 382.94177f);
generalPath.curveTo(-34.1396f, 380.69186f, -31.9287f, 378.54367f, -30.291199f, 376.19806f);
generalPath.lineTo(-36.767f, 371.21997f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(67.51499938964844, 86.70600128173828), new Point2D.Double(63.402000427246094, 61.356998443603516), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0052000284194946f, 0.03706600144505501f, -0.03709600120782852f, 1.00600004196167f, -101.08000183105469f, 311.42999267578125f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_2_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(22.397f, 419.85f);
generalPath.curveTo(16.2911f, 414.1099f, 6.445999f, 405.997f, -4.983f, 395.664f);
generalPath.curveTo(-13.8197f, 387.6748f, -22.222f, 380.30402f, -28.657f, 375.545f);
generalPath.lineTo(-33.426598f, 380.1473f);
generalPath.curveTo(-28.044498f, 386.0718f, -19.903599f, 394.4043f, -11.066597f, 402.3933f);
generalPath.curveTo(0.36140347f, 412.7253f, 10.994404f, 421.2203f, 17.706404f, 425.6373f);
generalPath.lineTo(22.397604f, 419.8492f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(-22.187999725341797, 69.9219970703125), 3.3125f, new Point2D.Double(-24.22599983215332, 69.91400146484375), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-0.8920699954032898f, 1.0390000343322754f, -21.232999801635742f, -18.231000900268555f, 1459.199951171875f, 1698.9000244140625f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.8f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_2_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-36.873f, 370.17f);
generalPath.curveTo(-37.84244f, 371.46112f, -38.9028f, 372.6998f, -40.0605f, 373.8575f);
generalPath.curveTo(-40.473183f, 374.2702f, -40.907433f, 374.68365f, -41.3417f, 375.07632f);
generalPath.curveTo(-41.363403f, 375.09592f, -41.382442f, 375.11923f, -41.4042f, 375.13882f);
generalPath.curveTo(-41.971962f, 375.75613f, -42.5335f, 376.34683f, -43.0917f, 376.92f);
generalPath.lineTo(-40.8105f, 379.045f);
generalPath.curveTo(-38.666203f, 377.6895f, -36.8135f, 375.87842f, -35.4355f, 373.63882f);
generalPath.curveTo(-35.14378f, 373.1647f, -34.88919f, 372.6898f, -34.65425f, 372.20132f);
generalPath.lineTo(-36.87305f, 370.17014f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(56.25699996948242, 56.999000549316406), 9.7255f, new Point2D.Double(56.25699996948242, 56.999000549316406), new float[] {0.0f,0.66372f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 61),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.9252899885177612f, -99.09100341796875f, 320.1400146484375f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.1875f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.6643437579259793f, -0.7474271678931584f, 0.7474271678931584f, 0.6643437579259793f, 0.0f, 0.0f));
// _0_0_0_0_2_2_5
shape = new Rectangle2D.Double(-305.6099853515625, 218.85000610351562, 1.6519999504089355, 8.381999969482422);
paint = new LinearGradientPaint(new Point2D.Double(113.91999816894531, 47.0359992980957), new Point2D.Double(108.61000061035156, 69.37799835205078), new float[] {0.0f,1.0f}, new Color[] {new Color(86, 228, 253, 175),new Color(255, 255, 255, 181)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -420.2900085449219f, 160.38999938964844f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-5.3277997970581055f, 0.0f, 0.0f, 7.7866997718811035f, 87.01399993896484f, 392.5299987792969f));
// _0_0_0_0_2_3
paint = new LinearGradientPaint(new Point2D.Double(28.548999786376953, -10.10099983215332), new Point2D.Double(28.548999786376953, -0.8540199995040894), new float[] {0.0f,1.0f}, new Color[] {new Color(201, 202, 204, 255),new Color(172, 174, 177, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(0.62102f,1,1,4.0f,null,0.0f);
shape = new Ellipse2D.Double(22.167299270629883, -9.843700408935547, 12.763400077819824, 8.732799530029297);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_4
paint = new RadialGradientPaint(new Point2D.Double(28.548999786376953, -5.47730016708374), 6.6922f, new Point2D.Double(28.548999786376953, -5.47730016708374), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 0),new Color(129, 129, 129, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-5.37939977645874f, -1.0974999895552173E-6f, -5.982300081086578E-6f, 29.320999145507812f, 88.48799896240234f, 510.489990234375f));
stroke = new BasicStroke(4.0f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-99.091f, 349.88f);
generalPath.curveTo(-99.091f, 368.648f, -83.859f, 383.88f, -65.091f, 383.88f);
generalPath.curveTo(-46.323006f, 383.88f, -31.091003f, 368.648f, -31.091003f, 349.88f);
generalPath.curveTo(-31.091003f, 331.112f, -46.323006f, 315.88f, -65.091f, 315.88f);
generalPath.curveTo(-83.859f, 315.88f, -99.091f, 331.112f, -99.091f, 349.88f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.71f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-65.248f, 317.88f);
generalPath.curveTo(-65.79382f, 317.871f, -66.3527f, 317.8921f, -66.9042f, 317.9112f);
generalPath.curveTo(-84.5542f, 318.5255f, -98.312195f, 333.3522f, -97.6232f, 351.0052f);
generalPath.curveTo(-97.39908f, 356.74197f, -95.672f, 362.0652f, -92.842f, 366.6302f);
generalPath.curveTo(-92.85964f, 366.35657f, -92.862495f, 366.09323f, -92.87325f, 365.8177f);
generalPath.curveTo(-93.56291f, 348.16467f, -79.80525f, 333.33868f, -62.15425f, 332.7237f);
generalPath.curveTo(-50.24025f, 332.30902f, -39.595253f, 338.4611f, -33.71625f, 347.9427f);
generalPath.curveTo(-34.79325f, 331.2327f, -48.59925f, 318.14468f, -65.24725f, 317.88068f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(39.409000396728516, 9.579099655151367), 31.966f, new Point2D.Double(33.48400115966797, 10.614999771118164), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.7625700235366821f, -105.08999633789062f, 317.57000732421875f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.038472000509500504f, 1.1053999662399292f, 1.1382999420166016f, -0.04446899890899658f, -110.4000015258789f, 304.54998779296875f));
// _0_0_0_0_2_6
paint = new LinearGradientPaint(new Point2D.Double(13.645000457763672, 38.36800003051758), new Point2D.Double(71.4729995727539, 38.36800003051758), new float[] {0.0f,1.0f}, new Color[] {new Color(163, 165, 168, 255),new Color(255, 255, 255, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(1.7278f,1,1,4.0f,null,0.0f);
shape = new Ellipse2D.Double(14.50899887084961, 11.124000549316406, 56.099998474121094, 54.487998962402344);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.2725000381469727f, 0.0f, 0.0f, 1.2725000381469727f, -100.70999908447266f, 321.2799987792969f));
// _0_0_0_0_2_7
g.setComposite(AlphaComposite.getInstance(3, 0.40625f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9136800169944763f, 0.0f, 0.0f, 0.6306300163269043f, -393.989990234375f, 40.72100067138672f));
// _0_0_0_0_2_7_0
shape = new Ellipse2D.Double(440.6340026855469, -70.14599609375, 42.69200134277344, 40.13600158691406);
paint = new RadialGradientPaint(new Point2D.Double(461.9800109863281, -50.077999114990234), 21.346f, new Point2D.Double(461.54998779296875, -62.784000396728516), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.9244999885559082f, 8.883200166565075E-7f, -2.196299959678072E-7f, 0.9889900088310242f, -427.1099853515625f, -0.5516300201416016f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_7_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(28.333f, -1.7689f);
generalPath.curveTo(14.895f, -1.7689f, 3.9820004f, 9.1441f, 3.9820004f, 22.5821f);
generalPath.curveTo(3.9820004f, 36.0201f, 14.895f, 46.911102f, 28.333f, 46.911102f);
generalPath.curveTo(41.771f, 46.911102f, 52.662003f, 36.019104f, 52.662003f, 22.582102f);
generalPath.curveTo(52.662003f, 9.144102f, 41.770004f, -1.768898f, 28.333002f, -1.768898f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(654.5399780273438, -20.356000900268555), 38.29f, new Point2D.Double(653.77001953125, 3.276599884033203), new float[] {0.0f,0.57964f,0.8823f,1.0f}, new Color[] {new Color(162, 243, 255, 79),new Color(81, 210, 244, 119),new Color(56, 139, 201, 169),new Color(31, 68, 158, 220)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.635670006275177f, 0.0f, 0.0f, 0.635670006275177f, -387.739990234375f, 35.51100158691406f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.39062f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7026399970054626f, 0.0f, 0.0f, 0.7026399970054626f, -333.2799987792969f, 26.423999786376953f));
// _0_0_0_0_2_7_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(514.84f, -41.875f);
generalPath.curveTo(495.23303f, -41.875f, 479.30902f, -25.951f, 479.30902f, -6.344002f);
generalPath.curveTo(479.30902f, -2.9409018f, 479.78867f, 0.35289812f, 480.68402f, 3.4684982f);
generalPath.curveTo(479.99997f, 0.73939824f, 479.62152f, -2.1225019f, 479.62152f, -5.062702f);
generalPath.curveTo(479.62152f, -24.377703f, 495.30652f, -40.062702f, 514.6215f, -40.062702f);
generalPath.curveTo(533.9365f, -40.062702f, 549.6215f, -24.3777f, 549.6215f, -5.062702f);
generalPath.curveTo(549.6215f, 1.5766978f, 547.7747f, 7.7712975f, 544.559f, 13.062298f);
generalPath.curveTo(548.2111f, 7.482698f, 550.3402f, 0.8232975f, 550.3402f, -6.3437023f);
generalPath.curveTo(550.3402f, -25.950703f, 534.4472f, -41.874702f, 514.8402f, -41.874702f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(529.52001953125, -49.40800094604492), new Point2D.Double(529.1300048828125, -2.031899929046631), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.57031f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7026399970054626f, 0.0f, 0.0f, 0.7026399970054626f, -266.5899963378906f, 26.423999786376953f));
// _0_0_0_0_2_7_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(385.94f, -16.094f);
generalPath.curveTo(384.7994f, -12.5924f, 384.19f, -8.880899f, 384.19f, -5.0f);
generalPath.curveTo(384.19f, 14.819f, 400.277f, 30.905998f, 420.096f, 30.905998f);
generalPath.curveTo(439.915f, 30.905998f, 455.971f, 14.818998f, 455.971f, -5.0f);
generalPath.curveTo(455.971f, -8.8806f, 455.36163f, -12.592199f, 454.221f, -16.094f);
generalPath.curveTo(455.1052f, -12.9945f, 455.596f, -9.726f, 455.596f, -6.344f);
generalPath.curveTo(455.596f, 13.2630005f, 439.703f, 29.156f, 420.096f, 29.156f);
generalPath.curveTo(400.489f, 29.155998f, 384.565f, 13.2630005f, 384.565f, -6.344f);
generalPath.curveTo(384.565f, -9.726f, 385.05582f, -12.994499f, 385.94f, -16.094f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(425.9100036621094, 7.406199932098389), new Point2D.Double(426.2699890136719, -21.584999084472656), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7026399970054626f, 0.0f, 0.0f, 0.7026399970054626f, -266.5899963378906f, 26.423999786376953f));
// _0_0_0_0_2_7_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(385.94f, -16.094f);
generalPath.curveTo(384.7994f, -12.5924f, 384.19f, -8.880899f, 384.19f, -5.0f);
generalPath.curveTo(384.19f, 14.819f, 400.277f, 29.905998f, 420.096f, 29.905998f);
generalPath.curveTo(439.915f, 29.905998f, 455.971f, 14.818998f, 455.971f, -5.0f);
generalPath.curveTo(455.971f, -8.8806f, 455.36163f, -12.592199f, 454.221f, -16.094f);
generalPath.curveTo(455.1052f, -12.9945f, 455.596f, -9.726f, 455.596f, -6.344f);
generalPath.curveTo(455.596f, 13.2630005f, 439.703f, 29.156f, 420.096f, 29.156f);
generalPath.curveTo(400.489f, 29.155998f, 384.565f, 13.2630005f, 384.565f, -6.344f);
generalPath.curveTo(384.565f, -9.726f, 385.05582f, -12.994499f, 385.94f, -16.094f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(425.20001220703125, 35.691001892089844), new Point2D.Double(424.8599853515625, 12.001999855041504), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7026399970054626f, 0.0f, 0.0f, 0.7026399970054626f, -333.2799987792969f, 26.423999786376953f));
// _0_0_0_0_2_7_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(514.84f, -40.875f);
generalPath.curveTo(495.23303f, -40.875f, 479.30902f, -25.951f, 479.30902f, -6.344002f);
generalPath.curveTo(479.30902f, -2.9409018f, 479.78867f, 0.35289812f, 480.68402f, 3.4684982f);
generalPath.curveTo(479.99997f, 0.73939824f, 479.62152f, -2.1225019f, 479.62152f, -5.062702f);
generalPath.curveTo(479.62152f, -24.377703f, 495.30652f, -40.062702f, 514.6215f, -40.062702f);
generalPath.curveTo(533.9365f, -40.062702f, 549.6215f, -24.3777f, 549.6215f, -5.062702f);
generalPath.curveTo(549.6215f, 1.5766978f, 547.7747f, 7.7712975f, 544.559f, 13.062298f);
generalPath.curveTo(548.2111f, 7.482698f, 550.3402f, 0.8232975f, 550.3402f, -6.3437023f);
generalPath.curveTo(550.3402f, -25.950703f, 534.4472f, -40.874702f, 514.8402f, -40.874702f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(529.52001953125, -49.40800094604492), new Point2D.Double(529.6300048828125, -22.281999588012695), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_7_6
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(28.429f, -3.5255f);
generalPath.curveTo(14.458001f, -3.5255f, 3.1120014f, 7.7024994f, 3.1120014f, 21.5275f);
generalPath.curveTo(3.1120014f, 26.8858f, 4.8222013f, 31.838501f, 7.7231016f, 35.9095f);
generalPath.curveTo(5.0298014f, 31.928501f, 3.4634018f, 27.1329f, 3.4634018f, 21.9665f);
generalPath.curveTo(3.4634018f, 8.189499f, 14.652402f, -2.9995003f, 28.429401f, -2.9995003f);
generalPath.curveTo(42.2064f, -2.9995003f, 53.3734f, 8.1895f, 53.3734f, 21.9665f);
generalPath.curveTo(53.3734f, 27.1329f, 51.8031f, 31.9285f, 49.1137f, 35.9095f);
generalPath.curveTo(52.0104f, 31.838001f, 53.7248f, 26.885601f, 53.7248f, 21.5275f);
generalPath.curveTo(53.7248f, 7.7015f, 42.4008f, -3.5265007f, 28.4298f, -3.5265007f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(455.3399963378906, -91.46199798583984), new Point2D.Double(452.6600036621094, -34.051998138427734), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.6517199873924255f, 0.0f, 0.0f, 0.6517199873924255f, -266.5899963378906f, 35.222999572753906f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7026399970054626f, 0.0f, 0.0f, 0.7026399970054626f, -357.760009765625f, 26.423999786376953f));
// _0_0_0_0_2_7_7
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(549.12f, -40.125f);
generalPath.curveTo(529.996f, -40.125f, 514.464f, -24.593f, 514.464f, -5.469002f);
generalPath.curveTo(514.464f, 12.078999f, 527.565f, 26.542f, 544.495f, 28.811996f);
generalPath.curveTo(529.90497f, 26.583696f, 518.714f, 13.989997f, 518.714f, -1.2190037f);
generalPath.curveTo(518.714f, -18.001003f, 532.338f, -31.625004f, 549.12f, -31.625004f);
generalPath.curveTo(565.902f, -31.625004f, 579.526f, -18.001003f, 579.526f, -1.2190037f);
generalPath.curveTo(579.526f, 14.513996f, 567.567f, 27.443996f, 552.245f, 28.999996f);
generalPath.curveTo(569.911f, 27.426996f, 583.745f, 12.606997f, 583.745f, -5.4690056f);
generalPath.curveTo(583.745f, -24.593006f, 568.244f, -40.125004f, 549.12f, -40.125004f);
generalPath.closePath();
generalPath.moveTo(552.25f, 29.0f);
generalPath.curveTo(551.73926f, 29.05186f, 551.2054f, 29.09875f, 550.6875f, 29.125f);
generalPath.curveTo(551.20624f, 29.10194f, 551.7375f, 29.04564f, 552.25f, 29.0f);
generalPath.closePath();
generalPath.moveTo(544.5f, 28.8125f);
generalPath.curveTo(545.01154f, 28.88111f, 545.5129f, 28.95397f, 546.0312f, 29.0f);
generalPath.curveTo(545.5212f, 28.948f, 545.00116f, 28.889f, 544.50116f, 28.812f);
generalPath.closePath();
generalPath.moveTo(546.03f, 29.0005f);
generalPath.curveTo(546.54016f, 29.0458f, 547.04504f, 29.10255f, 547.5612f, 29.1255f);
generalPath.curveTo(547.0433f, 29.099249f, 546.54083f, 29.05236f, 546.03f, 29.0005f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(549.1099853515625, -5.5), 34.641f, new Point2D.Double(549.1099853515625, 15.369000434875488), new float[] {0.0f,0.795f,1.0f}, new Color[] {new Color(22, 54, 122, 0),new Color(22, 54, 122, 0),new Color(22, 54, 122, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.9995499849319458f, 0.0f, -0.0024808000307530165f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.40625f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.737309992313385f, 0.0f, 0.0f, 0.6411399841308594f, -307.55999755859375f, 33.86000061035156f));
// _0_0_0_0_2_7_8
shape = new Ellipse2D.Double(441.3970031738281, -52.3650016784668, 28.20599937438965, 35.06800079345703);
paint = new RadialGradientPaint(new Point2D.Double(455.5, -40.349998474121094), 14.103f, new Point2D.Double(455.5, -32.882999420166016), new float[] {0.0f,1.0f}, new Color[] {new Color(86, 228, 253, 175),new Color(255, 255, 255, 181)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.4865000247955322f, -8.41730013689812E-7f, 1.040699999066419E-6f, 1.8378000259399414f, -221.60000610351562f, 32.46500015258789f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.58984f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_7_9
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(29.446f, 0.21256f);
generalPath.lineTo(29.64835f, 4.43926f);
generalPath.curveTo(31.32425f, 4.469351f, 32.95675f, 4.62685f, 34.52765f, 4.87474f);
generalPath.curveTo(34.20265f, 3.4994402f, 33.87965f, 2.12434f, 33.53965f, 0.7504401f);
generalPath.curveTo(32.22965f, 0.45351014f, 30.86165f, 0.28429013f, 29.44665f, 0.2125001f);
generalPath.closePath();
generalPath.moveTo(26.342999f, 0.238178f);
generalPath.curveTo(24.984999f, 0.34142798f, 23.662998f, 0.565678f, 22.407999f, 0.878588f);
generalPath.curveTo(22.046999f, 2.335688f, 21.696999f, 3.799288f, 21.352f, 5.2589884f);
generalPath.curveTo(22.967999f, 4.8953886f, 24.657f, 4.6671886f, 26.411f, 4.5416884f);
generalPath.lineTo(26.613379f, 0.23818827f);
generalPath.curveTo(26.521019f, 0.24415827f, 26.435518f, 0.23119827f, 26.34356f, 0.23818827f);
generalPath.closePath();
generalPath.moveTo(36.011597f, 1.467778f);
generalPath.curveTo(36.427948f, 2.779578f, 36.838585f, 4.095078f, 37.2483f, 5.412678f);
generalPath.curveTo(40.2043f, 6.1379776f, 42.886997f, 7.2236776f, 45.1406f, 8.614677f);
generalPath.curveTo(43.3896f, 5.4700775f, 40.122597f, 2.9144773f, 36.011597f, 1.4677773f);
generalPath.closePath();
generalPath.moveTo(19.574596f, 1.775178f);
generalPath.curveTo(15.172596f, 3.5408778f, 11.842596f, 6.621478f, 10.513597f, 10.304978f);
generalPath.curveTo(12.571596f, 8.597178f, 15.185596f, 7.1941786f, 18.158596f, 6.1810784f);
generalPath.curveTo(18.627596f, 4.7133784f, 19.096596f, 3.2451785f, 19.574596f, 1.7751784f);
generalPath.closePath();
generalPath.moveTo(29.715595f, 5.848178f);
generalPath.lineTo(30.030375f, 12.021678f);
generalPath.curveTo(32.185276f, 12.077718f, 34.289974f, 12.271188f, 36.281273f, 12.636468f);
generalPath.curveTo(35.829273f, 10.537468f, 35.354275f, 8.435167f, 34.864273f, 6.334268f);
generalPath.curveTo(33.209274f, 6.055868f, 31.489273f, 5.882668f, 29.715273f, 5.847568f);
generalPath.closePath();
generalPath.moveTo(26.342794f, 5.925027f);
generalPath.curveTo(24.479994f, 6.061687f, 22.696594f, 6.366017f, 20.991295f, 6.7703667f);
generalPath.curveTo(20.503614f, 8.8699665f, 20.047964f, 10.968567f, 19.597195f, 13.071966f);
generalPath.curveTo(21.643394f, 12.5788965f, 23.797094f, 12.254356f, 26.050495f, 12.098546f);
generalPath.lineTo(26.342495f, 5.925546f);
generalPath.closePath();
generalPath.moveTo(37.720795f, 6.949627f);
generalPath.curveTo(38.386776f, 9.108827f, 39.053196f, 11.287027f, 39.699493f, 13.456127f);
generalPath.curveTo(42.113594f, 14.140887f, 44.323895f, 15.030027f, 46.287693f, 16.120228f);
generalPath.curveTo(46.451374f, 15.381918f, 46.535034f, 14.638728f, 46.535034f, 13.866028f);
generalPath.curveTo(46.535034f, 12.736427f, 46.339993f, 11.662628f, 45.995384f, 10.612728f);
generalPath.curveTo(43.685383f, 9.031828f, 40.877384f, 7.775328f, 37.720783f, 6.949628f);
generalPath.closePath();
generalPath.moveTo(17.641794f, 7.7437267f);
generalPath.curveTo(14.657294f, 8.824027f, 12.052195f, 10.311426f, 10.041794f, 12.098527f);
generalPath.curveTo(9.941224f, 12.678987f, 9.884414f, 13.265327f, 9.884414f, 13.866027f);
generalPath.curveTo(9.884414f, 14.898127f, 10.042384f, 15.895627f, 10.334114f, 16.863127f);
generalPath.curveTo(11.905514f, 15.868227f, 13.669714f, 14.994926f, 15.5956135f, 14.275927f);
generalPath.curveTo(16.265123f, 12.101927f, 16.949913f, 9.9205265f, 17.641813f, 7.7438264f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(419.6600036621094, -24.165000915527344), 27.473f, new Point2D.Double(419.6600036621094, -24.165000915527344), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.7195299863815308f, 0.0f, 0.0f, 0.6485199928283691f, -273.739990234375f, 28.177000045776367f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.45652f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.6643437579259793f, -0.7474271678931584f, 0.7474271678931584f, 0.6643437579259793f, 0.0f, 0.0f));
// _0_0_0_0_2_8
shape = new Rectangle2D.Double(-304.29998779296875, 228.7899932861328, 0.75586998462677, 66.29399871826172);
paint = new LinearGradientPaint(new Point2D.Double(113.43000030517578, 55.402000427246094), new Point2D.Double(114.41999816894531, 118.7300033569336), new float[] {0.0f,1.0f}, new Color[] {new Color(202, 236, 243, 251),new Color(14, 82, 104, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -420.010009765625f, 170.0500030517578f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
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
		return 1122.519775390625;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 793.7008056640625;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private slidepreview1() {
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
       slidepreview1 base = new slidepreview1();
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
       slidepreview1 base = new slidepreview1();
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
        return slidepreview1::new;
    }
}

