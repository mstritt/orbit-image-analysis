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
public class slidepreview2 implements ResizableIcon {
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
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, -308.2677307128906f));
// _0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.0f, 5.690731048583984f, -5.093120574951172f, 0.0f, 1039.353759765625f, 316.8201599121094f));
// _0_0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 104.2738037109375f, -312.0760803222656f));
// _0_0_0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7385876178741455f, 0.0f, 0.0f, 1.0f, -100.57259368896484f, 311.8841857910156f));
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
generalPath.moveTo(11.861845f, 10.266208f);
generalPath.lineTo(11.893095f, 102.297455f);
generalPath.lineTo(11.861845f, 194.29745f);
generalPath.lineTo(111.86184f, 194.29745f);
generalPath.lineTo(111.86184f, 117.766205f);
generalPath.lineTo(111.86184f, 86.766205f);
generalPath.lineTo(111.86184f, 10.266205f);
generalPath.lineTo(11.861847f, 10.266205f);
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
generalPath.moveTo(13.556394f, 11.359958f);
generalPath.lineTo(13.556394f, 49.626534f);
generalPath.lineTo(13.556394f, 154.22183f);
generalPath.lineTo(13.556394f, 192.4884f);
generalPath.lineTo(109.5564f, 192.4884f);
generalPath.lineTo(109.5564f, 109.81665f);
generalPath.lineTo(109.5564f, 94.031685f);
generalPath.lineTo(109.5564f, 11.35994f);
generalPath.lineTo(13.556404f, 11.35994f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new LinearGradientPaint(new Point2D.Double(15.5, 98.5642318725586), new Point2D.Double(112.5, 98.5642318725586), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -2.443605899810791f, 3.3599579334259033f));
stroke = new BasicStroke(1.0f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(13.556394f, 11.359958f);
generalPath.lineTo(13.556394f, 49.626534f);
generalPath.lineTo(13.556394f, 154.22183f);
generalPath.lineTo(13.556394f, 192.4884f);
generalPath.lineTo(109.5564f, 192.4884f);
generalPath.lineTo(109.5564f, 109.81665f);
generalPath.lineTo(109.5564f, 94.031685f);
generalPath.lineTo(109.5564f, 11.35994f);
generalPath.lineTo(13.556404f, 11.35994f);
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
generalPath.moveTo(15.702982f, 10.452039f);
generalPath.lineTo(15.702982f, 49.077156f);
generalPath.lineTo(15.702982f, 154.6525f);
generalPath.lineTo(15.702982f, 193.27762f);
generalPath.lineTo(112.60247f, 193.27762f);
generalPath.lineTo(112.60247f, 109.83127f);
generalPath.lineTo(112.60247f, 93.8984f);
generalPath.lineTo(112.60247f, 10.452049f);
generalPath.lineTo(15.70298f, 10.452049f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(103.09768676757812, 56.26235580444336), 48.9f, new Point2D.Double(103.09768676757812, 56.26235580444336), new float[] {0.0f,1.0f}, new Color[] {new Color(210, 242, 255, 255),new Color(243, 243, 243, 201)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-1.228892207145691f, 2.168907403945923f, -1.6426172256469727f, -0.930698812007904f, 323.03851318359375f, -153.85885620117188f));
g.setPaint(paint);
g.fill(shape);
paint = new RadialGradientPaint(new Point2D.Double(18.182392120361328, 147.37173461914062), 48.5f, new Point2D.Double(18.182392120361328, 147.37173461914062), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.892987608909607f, -0.012713929638266563f, 0.012728540226817131f, 1.8951630592346191f, -18.080732345581055f, -89.32833099365234f));
stroke = new BasicStroke(1.8168653f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(15.702982f, 10.452039f);
generalPath.lineTo(15.702982f, 49.077156f);
generalPath.lineTo(15.702982f, 154.6525f);
generalPath.lineTo(15.702982f, 193.27762f);
generalPath.lineTo(112.60247f, 193.27762f);
generalPath.lineTo(112.60247f, 109.83127f);
generalPath.lineTo(112.60247f, 93.8984f);
generalPath.lineTo(112.60247f, 10.452049f);
generalPath.lineTo(15.70298f, 10.452049f);
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
generalPath.moveTo(47.032032f, 42.984238f);
generalPath.curveTo(46.9115f, 42.99054f, 46.80502f, 43.013386f, 46.688282f, 43.046738f);
generalPath.curveTo(46.100063f, 43.214798f, 43.872826f, 44.405834f, 43.563282f, 44.921738f);
generalPath.curveTo(43.072773f, 45.739254f, 44.14471f, 50.572273f, 44.407032f, 51.359238f);
generalPath.curveTo(44.734028f, 52.340225f, 46.004692f, 55.445168f, 45.438282f, 56.577988f);
generalPath.curveTo(45.17401f, 57.10653f, 40.59938f, 56.534706f, 39.813282f, 56.796738f);
generalPath.curveTo(39.566742f, 56.878918f, 39.422318f, 57.304718f, 39.188282f, 57.421738f);
generalPath.curveTo(36.475513f, 58.778122f, 36.06012f, 60.656464f, 38.157032f, 63.015488f);
generalPath.curveTo(38.92808f, 63.88292f, 39.53362f, 64.36906f, 40.438282f, 65.10924f);
generalPath.curveTo(41.237274f, 65.76296f, 42.07063f, 66.42646f, 42.938282f, 66.98424f);
generalPath.curveTo(42.946682f, 66.98964f, 43.06471f, 67.07576f, 43.157032f, 67.14049f);
generalPath.curveTo(42.28938f, 67.698265f, 41.456024f, 68.36176f, 40.657032f, 69.01549f);
generalPath.curveTo(39.75237f, 69.75567f, 39.14683f, 70.241806f, 38.375782f, 71.10924f);
generalPath.curveTo(36.27887f, 73.46826f, 36.694263f, 75.3466f, 39.407032f, 76.70299f);
generalPath.curveTo(39.641068f, 76.82001f, 39.785492f, 77.245804f, 40.032032f, 77.32799f);
generalPath.curveTo(40.81813f, 77.59002f, 45.39276f, 77.018196f, 45.657032f, 77.54674f);
generalPath.curveTo(46.223442f, 78.67956f, 44.952778f, 81.7845f, 44.625782f, 82.76549f);
generalPath.curveTo(44.36346f, 83.55245f, 43.291523f, 88.385475f, 43.782032f, 89.20299f);
generalPath.curveTo(44.091576f, 89.718895f, 46.318813f, 90.90993f, 46.907032f, 91.07799f);
generalPath.curveTo(47.02377f, 91.111336f, 47.13025f, 91.134186f, 47.250782f, 91.14049f);
generalPath.curveTo(47.61238f, 91.15925f, 48.011555f, 91.07799f, 48.375782f, 91.07799f);
generalPath.curveTo(48.92628f, 91.07799f, 49.687508f, 91.21099f, 50.219532f, 91.07799f);
generalPath.curveTo(53.542244f, 90.24731f, 58.220936f, 85.76991f, 60.219532f, 83.17174f);
generalPath.curveTo(60.934242f, 82.242615f, 63.451977f, 78.60538f, 62.719532f, 77.14049f);
generalPath.curveTo(62.50649f, 76.7144f, 62.354935f, 77.09534f, 62.094532f, 76.92174f);
generalPath.curveTo(61.93126f, 76.81289f, 61.85155f, 76.62434f, 61.688282f, 76.51549f);
generalPath.curveTo(61.19082f, 76.183846f, 60.625782f, 76.70833f, 60.625782f, 75.89049f);
generalPath.curveTo(60.625782f, 75.75173f, 60.52767f, 75.551094f, 60.625782f, 75.45299f);
generalPath.curveTo(60.63689f, 75.44188f, 63.133064f, 75.195f, 63.344532f, 75.26549f);
generalPath.curveTo(63.53069f, 75.32754f, 63.57527f, 75.58398f, 63.750782f, 75.67174f);
generalPath.curveTo(63.90936f, 75.75103f, 64.13993f, 75.598045f, 64.18828f, 75.45299f);
generalPath.curveTo(64.41218f, 74.781296f, 64.30156f, 71.902214f, 64.18828f, 71.10924f);
generalPath.curveTo(64.09428f, 70.45124f, 63.775757f, 69.65293f, 63.56328f, 69.01549f);
generalPath.curveTo(63.376507f, 68.45517f, 63.440308f, 67.657486f, 63.50078f, 66.92174f);
generalPath.lineTo(63.25078f, 66.92174f);
generalPath.curveTo(63.20065f, 66.268776f, 63.181168f, 65.599304f, 63.34453f, 65.10924f);
generalPath.curveTo(63.557007f, 64.471794f, 63.875526f, 63.673485f, 63.96953f, 63.015488f);
generalPath.curveTo(64.08281f, 62.22251f, 64.19343f, 59.34343f, 63.96953f, 58.671738f);
generalPath.curveTo(63.921177f, 58.526676f, 63.690605f, 58.3737f, 63.53203f, 58.452988f);
generalPath.curveTo(63.356518f, 58.54075f, 63.311935f, 58.797188f, 63.12578f, 58.859238f);
generalPath.curveTo(62.91431f, 58.92973f, 60.418137f, 58.682846f, 60.40703f, 58.671738f);
generalPath.curveTo(60.308918f, 58.573627f, 60.40703f, 58.37299f, 60.40703f, 58.234238f);
generalPath.curveTo(60.40703f, 57.4164f, 60.972065f, 57.94088f, 61.46953f, 57.609238f);
generalPath.curveTo(61.632797f, 57.50039f, 61.712505f, 57.311836f, 61.87578f, 57.202988f);
generalPath.curveTo(62.13618f, 57.02939f, 62.287735f, 57.410324f, 62.50078f, 56.984238f);
generalPath.curveTo(63.233223f, 55.519352f, 60.71549f, 51.88211f, 60.00078f, 50.952988f);
generalPath.curveTo(58.002182f, 48.354813f, 53.323486f, 43.877415f, 50.00078f, 43.046738f);
generalPath.curveTo(49.468754f, 42.91373f, 48.707527f, 43.046738f, 48.15703f, 43.046738f);
generalPath.curveTo(47.7928f, 43.046738f, 47.393627f, 42.965477f, 47.03203f, 42.984238f);
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
generalPath.moveTo(47.190765f, 48.610233f);
generalPath.curveTo(50.827255f, 55.345543f, 42.249077f, 59.38905f, 41.946007f, 63.784218f);
generalPath.curveTo(46.886986f, 66.969444f, 44.94861f, 71.00371f, 40.306477f, 72.10051f);
generalPath.curveTo(41.156918f, 78.598434f, 51.59971f, 71.89883f, 48.006218f, 80.65884f);
generalPath.curveTo(42.208946f, 90.73026f, 56.789257f, 87.16943f, 60.114906f, 82.24595f);
generalPath.curveTo(64.40873f, 78.312614f, 58.117657f, 75.49999f, 63.698467f, 74.13813f);
generalPath.curveTo(61.926117f, 66.74273f, 62.0934f, 59.405373f, 57.65365f, 52.4432f);
generalPath.curveTo(55.63117f, 48.13479f, 51.024147f, 47.654594f, 47.36599f, 46.784595f);
shape = generalPath;
paint = new Color(170, 102, 183, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(18.937944f, 136.85808f);
generalPath.lineTo(107.82411f, 136.85808f);
generalPath.lineTo(107.82411f, 187.86835f);
generalPath.lineTo(18.937943f, 187.86835f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new LinearGradientPaint(new Point2D.Double(57.019283294677734, 132.4290313720703), new Point2D.Double(55.3865852355957, 189.85377502441406), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(18.937944f, 136.85808f);
generalPath.lineTo(107.82411f, 136.85808f);
generalPath.lineTo(107.82411f, 187.86835f);
generalPath.lineTo(18.937943f, 187.86835f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.2418439388275146f, 0.0f, 0.0f, 1.0f, -5.451368808746338f, 0.0f));
// _0_0_0_0_0_5
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 0.38382488489151f, 221.75723266601562f, 165.20057678222656f));
// _0_0_0_0_0_5_0_0
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_0_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-186.73897f, 11.896513f);
generalPath.lineTo(-185.7582f, 11.896513f);
generalPath.lineTo(-185.7582f, 48.92048f);
generalPath.lineTo(-186.73897f, 48.92048f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.1355733f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-186.73897f, 11.896513f);
generalPath.lineTo(-185.7582f, 11.896513f);
generalPath.lineTo(-185.7582f, 48.92048f);
generalPath.lineTo(-186.73897f, 48.92048f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_0_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-189.53217f, 11.928726f);
generalPath.lineTo(-187.39401f, 11.928726f);
generalPath.lineTo(-187.39401f, 48.888264f);
generalPath.lineTo(-189.53217f, 48.888264f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-189.53217f, 11.928726f);
generalPath.lineTo(-187.39401f, 11.928726f);
generalPath.lineTo(-187.39401f, 48.888264f);
generalPath.lineTo(-189.53217f, 48.888264f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_0_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-196.32845f, 11.928726f);
generalPath.lineTo(-194.19029f, 11.928726f);
generalPath.lineTo(-194.19029f, 48.888264f);
generalPath.lineTo(-196.32845f, 48.888264f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-196.32845f, 11.928726f);
generalPath.lineTo(-194.19029f, 11.928726f);
generalPath.lineTo(-194.19029f, 48.888264f);
generalPath.lineTo(-196.32845f, 48.888264f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_0_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-199.15387f, 11.928726f);
generalPath.lineTo(-197.01572f, 11.928726f);
generalPath.lineTo(-197.01572f, 48.888264f);
generalPath.lineTo(-199.15387f, 48.888264f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-199.15387f, 11.928726f);
generalPath.lineTo(-197.01572f, 11.928726f);
generalPath.lineTo(-197.01572f, 48.888264f);
generalPath.lineTo(-199.15387f, 48.888264f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_0_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-178.72089f, 11.896513f);
generalPath.lineTo(-177.74011f, 11.896513f);
generalPath.lineTo(-177.74011f, 48.92048f);
generalPath.lineTo(-178.72089f, 48.92048f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.1355733f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-178.72089f, 11.896513f);
generalPath.lineTo(-177.74011f, 11.896513f);
generalPath.lineTo(-177.74011f, 48.92048f);
generalPath.lineTo(-178.72089f, 48.92048f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_0_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-172.99368f, 11.896513f);
generalPath.lineTo(-172.01291f, 11.896513f);
generalPath.lineTo(-172.01291f, 48.92048f);
generalPath.lineTo(-172.99368f, 48.92048f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.1355733f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-172.99368f, 11.896513f);
generalPath.lineTo(-172.01291f, 11.896513f);
generalPath.lineTo(-172.01291f, 48.92048f);
generalPath.lineTo(-172.99368f, 48.92048f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_0_6
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-175.78688f, 11.928726f);
generalPath.lineTo(-173.64873f, 11.928726f);
generalPath.lineTo(-173.64873f, 48.888264f);
generalPath.lineTo(-175.78688f, 48.888264f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-175.78688f, 11.928726f);
generalPath.lineTo(-173.64873f, 11.928726f);
generalPath.lineTo(-173.64873f, 48.888264f);
generalPath.lineTo(-175.78688f, 48.888264f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_0_7
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-182.58316f, 11.928726f);
generalPath.lineTo(-180.445f, 11.928726f);
generalPath.lineTo(-180.445f, 48.888264f);
generalPath.lineTo(-182.58316f, 48.888264f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-182.58316f, 11.928726f);
generalPath.lineTo(-180.445f, 11.928726f);
generalPath.lineTo(-180.445f, 48.888264f);
generalPath.lineTo(-182.58316f, 48.888264f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_0_8
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-185.40858f, 11.928726f);
generalPath.lineTo(-183.27043f, 11.928726f);
generalPath.lineTo(-183.27043f, 48.888264f);
generalPath.lineTo(-185.40858f, 48.888264f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-185.40858f, 11.928726f);
generalPath.lineTo(-183.27043f, 11.928726f);
generalPath.lineTo(-183.27043f, 48.888264f);
generalPath.lineTo(-185.40858f, 48.888264f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_0_9
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-164.9756f, 11.896513f);
generalPath.lineTo(-163.99483f, 11.896513f);
generalPath.lineTo(-163.99483f, 48.92048f);
generalPath.lineTo(-164.9756f, 48.92048f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.1355733f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-164.9756f, 11.896513f);
generalPath.lineTo(-163.99483f, 11.896513f);
generalPath.lineTo(-163.99483f, 48.92048f);
generalPath.lineTo(-164.9756f, 48.92048f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-1.0f, 0.0f, 0.0f, 0.38382488489151f, -112.37364196777344f, 165.20057678222656f));
// _0_0_0_0_0_5_0_1
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_1_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-186.73897f, 11.896513f);
generalPath.lineTo(-185.7582f, 11.896513f);
generalPath.lineTo(-185.7582f, 48.92048f);
generalPath.lineTo(-186.73897f, 48.92048f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.1355733f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-186.73897f, 11.896513f);
generalPath.lineTo(-185.7582f, 11.896513f);
generalPath.lineTo(-185.7582f, 48.92048f);
generalPath.lineTo(-186.73897f, 48.92048f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_1_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-189.53217f, 11.928726f);
generalPath.lineTo(-187.39401f, 11.928726f);
generalPath.lineTo(-187.39401f, 48.888264f);
generalPath.lineTo(-189.53217f, 48.888264f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-189.53217f, 11.928726f);
generalPath.lineTo(-187.39401f, 11.928726f);
generalPath.lineTo(-187.39401f, 48.888264f);
generalPath.lineTo(-189.53217f, 48.888264f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_1_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-196.32845f, 11.928726f);
generalPath.lineTo(-194.19029f, 11.928726f);
generalPath.lineTo(-194.19029f, 48.888264f);
generalPath.lineTo(-196.32845f, 48.888264f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-196.32845f, 11.928726f);
generalPath.lineTo(-194.19029f, 11.928726f);
generalPath.lineTo(-194.19029f, 48.888264f);
generalPath.lineTo(-196.32845f, 48.888264f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_1_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-199.15387f, 11.928726f);
generalPath.lineTo(-197.01572f, 11.928726f);
generalPath.lineTo(-197.01572f, 48.888264f);
generalPath.lineTo(-199.15387f, 48.888264f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-199.15387f, 11.928726f);
generalPath.lineTo(-197.01572f, 11.928726f);
generalPath.lineTo(-197.01572f, 48.888264f);
generalPath.lineTo(-199.15387f, 48.888264f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_1_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-178.72089f, 11.896513f);
generalPath.lineTo(-177.74011f, 11.896513f);
generalPath.lineTo(-177.74011f, 48.92048f);
generalPath.lineTo(-178.72089f, 48.92048f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.1355733f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-178.72089f, 11.896513f);
generalPath.lineTo(-177.74011f, 11.896513f);
generalPath.lineTo(-177.74011f, 48.92048f);
generalPath.lineTo(-178.72089f, 48.92048f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_1_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-172.99368f, 11.896513f);
generalPath.lineTo(-172.01291f, 11.896513f);
generalPath.lineTo(-172.01291f, 48.92048f);
generalPath.lineTo(-172.99368f, 48.92048f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.1355733f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-172.99368f, 11.896513f);
generalPath.lineTo(-172.01291f, 11.896513f);
generalPath.lineTo(-172.01291f, 48.92048f);
generalPath.lineTo(-172.99368f, 48.92048f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_1_6
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-175.78688f, 11.928726f);
generalPath.lineTo(-173.64873f, 11.928726f);
generalPath.lineTo(-173.64873f, 48.888264f);
generalPath.lineTo(-175.78688f, 48.888264f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-175.78688f, 11.928726f);
generalPath.lineTo(-173.64873f, 11.928726f);
generalPath.lineTo(-173.64873f, 48.888264f);
generalPath.lineTo(-175.78688f, 48.888264f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_1_7
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-182.58316f, 11.928726f);
generalPath.lineTo(-180.445f, 11.928726f);
generalPath.lineTo(-180.445f, 48.888264f);
generalPath.lineTo(-182.58316f, 48.888264f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-182.58316f, 11.928726f);
generalPath.lineTo(-180.445f, 11.928726f);
generalPath.lineTo(-180.445f, 48.888264f);
generalPath.lineTo(-182.58316f, 48.888264f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_1_8
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-185.40858f, 11.928726f);
generalPath.lineTo(-183.27043f, 11.928726f);
generalPath.lineTo(-183.27043f, 48.888264f);
generalPath.lineTo(-185.40858f, 48.888264f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-185.40858f, 11.928726f);
generalPath.lineTo(-183.27043f, 11.928726f);
generalPath.lineTo(-183.27043f, 48.888264f);
generalPath.lineTo(-185.40858f, 48.888264f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5_0_1_9
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-164.9756f, 11.896513f);
generalPath.lineTo(-163.99483f, 11.896513f);
generalPath.lineTo(-163.99483f, 48.92048f);
generalPath.lineTo(-164.9756f, 48.92048f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.1355733f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-164.9756f, 11.896513f);
generalPath.lineTo(-163.99483f, 11.896513f);
generalPath.lineTo(-163.99483f, 48.92048f);
generalPath.lineTo(-164.9756f, 48.92048f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9343072772026062f, 0.0f, 0.0f, 1.0703116655349731f, 0.0f, 0.0f));
// _0_0_0_0_0_6
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_6_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(24.112732f, 146.07475f);
generalPath.lineTo(24.112732f, 136.71161f);
generalPath.lineTo(30.88281f, 136.71161f);
generalPath.lineTo(30.88281f, 137.81654f);
generalPath.lineTo(25.351784f, 137.81654f);
generalPath.lineTo(25.351784f, 140.68425f);

}

private void _paint1(Graphics2D g,float origAlpha) {
generalPath.lineTo(30.531532f, 140.68425f);
generalPath.lineTo(30.531532f, 141.78279f);
generalPath.lineTo(25.351784f, 141.78279f);
generalPath.lineTo(25.351784f, 144.96985f);
generalPath.lineTo(31.099962f, 144.96985f);
generalPath.lineTo(31.099962f, 146.07477f);
generalPath.lineTo(24.112732f, 146.07477f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_6_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(32.77332f, 146.07475f);
generalPath.lineTo(32.77332f, 136.71161f);
generalPath.lineTo(34.01237f, 136.71161f);
generalPath.lineTo(34.01237f, 144.96983f);
generalPath.lineTo(38.623688f, 144.96983f);
generalPath.lineTo(38.623688f, 146.07475f);
generalPath.lineTo(32.77332f, 146.07475f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_6_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(40.054348f, 146.07475f);
generalPath.lineTo(40.054348f, 136.71161f);
generalPath.lineTo(43.567123f, 136.71161f);
generalPath.quadTo(44.640118f, 136.71161f, 45.28519f, 136.99902f);
generalPath.quadTo(45.93665f, 137.28004f, 46.3007f, 137.87402f);
generalPath.quadTo(46.67114f, 138.46161f, 46.67114f, 139.10669f);
generalPath.quadTo(46.67114f, 139.70706f, 46.34541f, 140.23717f);
generalPath.quadTo(46.01968f, 140.76727f, 45.36183f, 141.093f);
generalPath.quadTo(46.211285f, 141.34209f, 46.664753f, 141.94246f);
generalPath.quadTo(47.124607f, 142.54283f, 47.124607f, 143.36034f);
generalPath.quadTo(47.124607f, 144.01819f, 46.843586f, 144.58661f);
generalPath.quadTo(46.56895f, 145.14867f, 46.16019f, 145.45523f);
generalPath.quadTo(45.75143f, 145.7618f, 45.131905f, 145.92148f);
generalPath.quadTo(44.518764f, 146.07475f, 43.624603f, 146.07475f);
generalPath.lineTo(40.054344f, 146.07475f);
generalPath.closePath();
generalPath.moveTo(41.2934f, 140.64592f);
generalPath.lineTo(43.318035f, 140.64592f);
generalPath.quadTo(44.14194f, 140.64592f, 44.499603f, 140.53734f);
generalPath.quadTo(44.972233f, 140.39684f, 45.208546f, 140.07109f);
generalPath.quadTo(45.45125f, 139.74536f, 45.45125f, 139.25357f);
generalPath.quadTo(45.45125f, 138.78732f, 45.227707f, 138.43605f);
generalPath.quadTo(45.004166f, 138.07838f, 44.58902f, 137.95065f);
generalPath.quadTo(44.173874f, 137.81653f, 43.16475f, 137.81653f);
generalPath.lineTo(41.2934f, 137.81653f);
generalPath.lineTo(41.2934f, 140.6459f);
generalPath.closePath();
generalPath.moveTo(41.2934f, 144.96983f);
generalPath.lineTo(43.624607f, 144.96983f);
generalPath.quadTo(44.22497f, 144.96983f, 44.467674f, 144.92514f);
generalPath.quadTo(44.895596f, 144.84843f, 45.183002f, 144.66966f);
generalPath.quadTo(45.470413f, 144.49083f, 45.655632f, 144.15233f);
generalPath.quadTo(45.84085f, 143.80743f, 45.84085f, 143.36035f);
generalPath.quadTo(45.84085f, 142.83662f, 45.5726f, 142.45341f);
generalPath.quadTo(45.30435f, 142.06381f, 44.825336f, 141.91054f);
generalPath.quadTo(44.352707f, 141.75085f, 43.458546f, 141.75085f);
generalPath.lineTo(41.2934f, 141.75085f);
generalPath.lineTo(41.2934f, 144.96985f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_6_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(48.376434f, 141.45705f);
generalPath.quadTo(48.376434f, 139.79646f, 48.71494f, 138.78734f);
generalPath.quadTo(49.05983f, 137.77184f, 49.73045f, 137.22256f);
generalPath.quadTo(50.40746f, 136.6733f, 51.429356f, 136.6733f);
generalPath.quadTo(52.183006f, 136.6733f, 52.75144f, 136.97986f);
generalPath.quadTo(53.31987f, 137.28004f, 53.690308f, 137.85486f);
generalPath.quadTo(54.060745f, 138.4233f, 54.27151f, 139.2472f);
generalPath.quadTo(54.482277f, 140.06471f, 54.482277f, 141.45705f);
generalPath.quadTo(54.482277f, 143.10486f, 54.143772f, 144.12036f);
generalPath.quadTo(53.805267f, 145.12949f, 53.12826f, 145.68513f);
generalPath.quadTo(52.45764f, 146.2344f, 51.429356f, 146.2344f);
generalPath.quadTo(50.07534f, 146.2344f, 49.30253f, 145.26361f);
generalPath.quadTo(48.376434f, 144.09482f, 48.376434f, 141.45705f);
generalPath.closePath();
generalPath.moveTo(49.558006f, 141.45705f);
generalPath.quadTo(49.558006f, 143.76271f, 50.0945f, 144.52913f);
generalPath.quadTo(50.637386f, 145.28917f, 51.429356f, 145.28917f);
generalPath.quadTo(52.22133f, 145.28917f, 52.757824f, 144.52274f);
generalPath.quadTo(53.30071f, 143.75632f, 53.30071f, 141.45705f);
generalPath.quadTo(53.30071f, 139.14499f, 52.757824f, 138.38496f);
generalPath.quadTo(52.22133f, 137.62492f, 51.41658f, 137.62492f);
generalPath.quadTo(50.624607f, 137.62492f, 50.15198f, 138.29555f);
generalPath.quadTo(49.558002f, 139.15138f, 49.558002f, 141.45705f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_6_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(55.65746f, 141.45705f);
generalPath.quadTo(55.65746f, 139.79646f, 55.995964f, 138.78734f);
generalPath.quadTo(56.340855f, 137.77184f, 57.011475f, 137.22256f);
generalPath.quadTo(57.688484f, 136.6733f, 58.71038f, 136.6733f);
generalPath.quadTo(59.46403f, 136.6733f, 60.032463f, 136.97986f);
generalPath.quadTo(60.600895f, 137.28004f, 60.971333f, 137.85486f);
generalPath.quadTo(61.34177f, 138.4233f, 61.552536f, 139.2472f);
generalPath.quadTo(61.7633f, 140.06471f, 61.7633f, 141.45705f);
generalPath.quadTo(61.7633f, 143.10486f, 61.424797f, 144.12036f);
generalPath.quadTo(61.086292f, 145.12949f, 60.409286f, 145.68513f);
generalPath.quadTo(59.738667f, 146.2344f, 58.71038f, 146.2344f);
generalPath.quadTo(57.356365f, 146.2344f, 56.583553f, 145.26361f);
generalPath.quadTo(55.657455f, 144.09482f, 55.657455f, 141.45705f);
generalPath.closePath();
generalPath.moveTo(56.83903f, 141.45705f);
generalPath.quadTo(56.83903f, 143.76271f, 57.375526f, 144.52913f);
generalPath.quadTo(57.91841f, 145.28917f, 58.71038f, 145.28917f);
generalPath.quadTo(59.502354f, 145.28917f, 60.03885f, 144.52274f);
generalPath.quadTo(60.581734f, 143.75632f, 60.581734f, 141.45705f);
generalPath.quadTo(60.581734f, 139.14499f, 60.03885f, 138.38496f);
generalPath.quadTo(59.502354f, 137.62492f, 58.69761f, 137.62492f);
generalPath.quadTo(57.905636f, 137.62492f, 57.43301f, 138.29555f);
generalPath.quadTo(56.83903f, 139.15138f, 56.83903f, 141.45705f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_6_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(63.110935f, 143.9096f);
generalPath.lineTo(64.21586f, 143.80742f);
generalPath.quadTo(64.35637f, 144.58661f, 64.75236f, 144.93788f);
generalPath.quadTo(65.148346f, 145.28915f, 65.76787f, 145.28915f);
generalPath.quadTo(66.29798f, 145.28915f, 66.69396f, 145.04645f);
generalPath.quadTo(67.09634f, 144.80374f, 67.35181f, 144.40137f);
generalPath.quadTo(67.607285f, 143.99261f, 67.779724f, 143.30283f);
generalPath.quadTo(67.95217f, 142.61305f, 67.95217f, 141.89772f);
generalPath.quadTo(67.95217f, 141.82112f, 67.94577f, 141.6678f);
generalPath.quadTo(67.600876f, 142.21707f, 67.00051f, 142.56197f);
generalPath.quadTo(66.40653f, 142.90047f, 65.710365f, 142.90047f);
generalPath.quadTo(64.54796f, 142.90047f, 63.74321f, 142.0574f);
generalPath.quadTo(62.938465f, 141.21434f, 62.938465f, 139.83478f);
generalPath.quadTo(62.938465f, 138.4105f, 63.775146f, 137.5419f);
generalPath.quadTo(64.61821f, 136.6733f, 65.88281f, 136.6733f);
generalPath.quadTo(66.796135f, 136.6733f, 67.54978f, 137.16507f);
generalPath.quadTo(68.30982f, 137.65686f, 68.69942f, 138.57019f);
generalPath.quadTo(69.095406f, 139.47713f, 69.095406f, 141.20157f);
generalPath.quadTo(69.095406f, 142.99628f, 68.7058f, 144.06288f);
generalPath.quadTo(68.3162f, 145.12311f, 67.543396f, 145.67876f);
generalPath.quadTo(66.77697f, 146.2344f, 65.7423f, 146.2344f);
generalPath.quadTo(64.64376f, 146.2344f, 63.947594f, 145.62766f);
generalPath.quadTo(63.251427f, 145.01451f, 63.110916f, 143.90959f);
generalPath.closePath();
generalPath.moveTo(67.818054f, 139.7773f);
generalPath.quadTo(67.818054f, 138.78734f, 67.28794f, 138.20613f);
generalPath.quadTo(66.76422f, 137.62492f, 66.02334f, 137.62492f);
generalPath.quadTo(65.25691f, 137.62492f, 64.688484f, 138.25084f);
generalPath.quadTo(64.120056f, 138.87675f, 64.120056f, 139.87311f);
generalPath.quadTo(64.120056f, 140.76727f, 64.656555f, 141.32932f);
generalPath.quadTo(65.19944f, 141.88498f, 65.99141f, 141.88498f);
generalPath.quadTo(66.789764f, 141.88498f, 67.30072f, 141.32932f);
generalPath.quadTo(67.818054f, 140.76727f, 67.818054f, 139.7773f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_6_6
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(70.21951f, 141.45705f);
generalPath.quadTo(70.21951f, 139.79646f, 70.558014f, 138.78734f);
generalPath.quadTo(70.90291f, 137.77184f, 71.573524f, 137.22256f);
generalPath.quadTo(72.250534f, 136.6733f, 73.27243f, 136.6733f);
generalPath.quadTo(74.02608f, 136.6733f, 74.59451f, 136.97986f);
generalPath.quadTo(75.16294f, 137.28004f, 75.53338f, 137.85486f);
generalPath.quadTo(75.90382f, 138.4233f, 76.114586f, 139.2472f);
generalPath.quadTo(76.325356f, 140.06471f, 76.325356f, 141.45705f);
generalPath.quadTo(76.325356f, 143.10486f, 75.986855f, 144.12036f);
generalPath.quadTo(75.64835f, 145.12949f, 74.971344f, 145.68513f);
generalPath.quadTo(74.30072f, 146.2344f, 73.27244f, 146.2344f);
generalPath.quadTo(71.91842f, 146.2344f, 71.145615f, 145.26361f);
generalPath.quadTo(70.21952f, 144.09482f, 70.21952f, 141.45705f);
generalPath.closePath();
generalPath.moveTo(71.401085f, 141.45705f);
generalPath.quadTo(71.401085f, 143.76271f, 71.937584f, 144.52913f);
generalPath.quadTo(72.48047f, 145.28917f, 73.27244f, 145.28917f);
generalPath.quadTo(74.06441f, 145.28917f, 74.60091f, 144.52274f);
generalPath.quadTo(75.14379f, 143.75632f, 75.14379f, 141.45705f);
generalPath.quadTo(75.14379f, 139.14499f, 74.60091f, 138.38496f);
generalPath.quadTo(74.06441f, 137.62492f, 73.25967f, 137.62492f);
generalPath.quadTo(72.4677f, 137.62492f, 71.99506f, 138.29555f);
generalPath.quadTo(71.401085f, 139.15138f, 71.401085f, 141.45705f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_6_7
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(77.37281f, 143.26453f);
generalPath.lineTo(77.37281f, 142.1085f);
generalPath.lineTo(80.90475f, 142.1085f);
generalPath.lineTo(80.90475f, 143.26453f);
generalPath.lineTo(77.37281f, 143.26453f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_6_8
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(81.86916f, 141.45705f);
generalPath.quadTo(81.86916f, 139.79646f, 82.207664f, 138.78734f);
generalPath.quadTo(82.55255f, 137.77184f, 83.223175f, 137.22256f);
generalPath.quadTo(83.900185f, 136.6733f, 84.92208f, 136.6733f);
generalPath.quadTo(85.67573f, 136.6733f, 86.24416f, 136.97986f);
generalPath.quadTo(86.81259f, 137.28004f, 87.18303f, 137.85486f);
generalPath.quadTo(87.55347f, 138.4233f, 87.76424f, 139.2472f);
generalPath.quadTo(87.975006f, 140.06471f, 87.975006f, 141.45705f);
generalPath.quadTo(87.975006f, 143.10486f, 87.636505f, 144.12036f);
generalPath.quadTo(87.298004f, 145.12949f, 86.620995f, 145.68513f);
generalPath.quadTo(85.95037f, 146.2344f, 84.92209f, 146.2344f);
generalPath.quadTo(83.56807f, 146.2344f, 82.795265f, 145.26361f);
generalPath.quadTo(81.86917f, 144.09482f, 81.86917f, 141.45705f);
generalPath.closePath();
generalPath.moveTo(83.050735f, 141.45705f);
generalPath.quadTo(83.050735f, 143.76271f, 83.587234f, 144.52913f);
generalPath.quadTo(84.13012f, 145.28917f, 84.92209f, 145.28917f);
generalPath.quadTo(85.71406f, 145.28917f, 86.25056f, 144.52274f);
generalPath.quadTo(86.79344f, 143.75632f, 86.79344f, 141.45705f);
generalPath.quadTo(86.79344f, 139.14499f, 86.25056f, 138.38496f);
generalPath.quadTo(85.71406f, 137.62492f, 84.90932f, 137.62492f);
generalPath.quadTo(84.11735f, 137.62492f, 83.644714f, 138.29555f);
generalPath.quadTo(83.050735f, 139.15138f, 83.050735f, 141.45705f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_6_9
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(89.150185f, 141.45705f);
generalPath.quadTo(89.150185f, 139.79646f, 89.488686f, 138.78734f);
generalPath.quadTo(89.83357f, 137.77184f, 90.504196f, 137.22256f);
generalPath.quadTo(91.181206f, 136.6733f, 92.2031f, 136.6733f);
generalPath.quadTo(92.95675f, 136.6733f, 93.525185f, 136.97986f);
generalPath.quadTo(94.09361f, 137.28004f, 94.46405f, 137.85486f);
generalPath.quadTo(94.83449f, 138.4233f, 95.04526f, 139.2472f);
generalPath.quadTo(95.25603f, 140.06471f, 95.25603f, 141.45705f);
generalPath.quadTo(95.25603f, 143.10486f, 94.91753f, 144.12036f);
generalPath.quadTo(94.579025f, 145.12949f, 93.902016f, 145.68513f);
generalPath.quadTo(93.23139f, 146.2344f, 92.20311f, 146.2344f);
generalPath.quadTo(90.84909f, 146.2344f, 90.07629f, 145.26361f);
generalPath.quadTo(89.15019f, 144.09482f, 89.15019f, 141.45705f);
generalPath.closePath();
generalPath.moveTo(90.33176f, 141.45705f);
generalPath.quadTo(90.33176f, 143.76271f, 90.868256f, 144.52913f);
generalPath.quadTo(91.41114f, 145.28917f, 92.20311f, 145.28917f);
generalPath.quadTo(92.99508f, 145.28917f, 93.53158f, 144.52274f);
generalPath.quadTo(94.07446f, 143.75632f, 94.07446f, 141.45705f);
generalPath.quadTo(94.07446f, 139.14499f, 93.53158f, 138.38496f);
generalPath.quadTo(92.99508f, 137.62492f, 92.19034f, 137.62492f);
generalPath.quadTo(91.39837f, 137.62492f, 90.925735f, 138.29555f);
generalPath.quadTo(90.33176f, 139.15138f, 90.33176f, 141.45705f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_6_10
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(96.43121f, 141.45705f);
generalPath.quadTo(96.43121f, 139.79646f, 96.769714f, 138.78734f);
generalPath.quadTo(97.11461f, 137.77184f, 97.785225f, 137.22256f);
generalPath.quadTo(98.462234f, 136.6733f, 99.48413f, 136.6733f);
generalPath.quadTo(100.237785f, 136.6733f, 100.80621f, 136.97986f);
generalPath.quadTo(101.37464f, 137.28004f, 101.74509f, 137.85486f);
generalPath.quadTo(102.115524f, 138.4233f, 102.32629f, 139.2472f);
generalPath.quadTo(102.537056f, 140.06471f, 102.537056f, 141.45705f);
generalPath.quadTo(102.537056f, 143.10486f, 102.19855f, 144.12036f);
generalPath.quadTo(101.86005f, 145.12949f, 101.18304f, 145.68513f);
generalPath.quadTo(100.51241f, 146.2344f, 99.48413f, 146.2344f);
generalPath.quadTo(98.13012f, 146.2344f, 97.35731f, 145.26361f);
generalPath.quadTo(96.43121f, 144.09482f, 96.43121f, 141.45705f);
generalPath.closePath();
generalPath.moveTo(97.612785f, 141.45705f);
generalPath.quadTo(97.612785f, 143.76271f, 98.149284f, 144.52913f);
generalPath.quadTo(98.69217f, 145.28917f, 99.48414f, 145.28917f);
generalPath.quadTo(100.276115f, 145.28917f, 100.8126f, 144.52274f);
generalPath.quadTo(101.35549f, 143.75632f, 101.35549f, 141.45705f);
generalPath.quadTo(101.35549f, 139.14499f, 100.8126f, 138.38496f);
generalPath.quadTo(100.27611f, 137.62492f, 99.47136f, 137.62492f);
generalPath.quadTo(98.67939f, 137.62492f, 98.20676f, 138.29555f);
generalPath.quadTo(97.61278f, 139.15138f, 97.61278f, 141.45705f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_6_11
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(103.88469f, 143.9096f);
generalPath.lineTo(104.98962f, 143.80742f);
generalPath.quadTo(105.13013f, 144.58661f, 105.52611f, 144.93788f);
generalPath.quadTo(105.9221f, 145.28915f, 106.54162f, 145.28915f);
generalPath.quadTo(107.07173f, 145.28915f, 107.46772f, 145.04645f);
generalPath.quadTo(107.87009f, 144.80374f, 108.12557f, 144.40137f);
generalPath.quadTo(108.38104f, 143.99261f, 108.55349f, 143.30283f);
generalPath.quadTo(108.72593f, 142.61305f, 108.72593f, 141.89772f);
generalPath.quadTo(108.72593f, 141.82112f, 108.71993f, 141.6678f);
generalPath.quadTo(108.375046f, 142.21707f, 107.77467f, 142.56197f);
generalPath.quadTo(107.180695f, 142.90047f, 106.48452f, 142.90047f);
generalPath.quadTo(105.32211f, 142.90047f, 104.51737f, 142.0574f);
generalPath.quadTo(103.71262f, 141.21434f, 103.71262f, 139.83478f);
generalPath.quadTo(103.71262f, 138.4105f, 104.5493f, 137.5419f);
generalPath.quadTo(105.39237f, 136.6733f, 106.656975f, 136.6733f);
generalPath.quadTo(107.5703f, 136.6733f, 108.323944f, 137.16507f);
generalPath.quadTo(109.083984f, 137.65686f, 109.47359f, 138.57019f);
generalPath.quadTo(109.86957f, 139.47713f, 109.86957f, 141.20157f);
generalPath.quadTo(109.86957f, 142.99628f, 109.479965f, 144.06288f);
generalPath.quadTo(109.09036f, 145.12311f, 108.31756f, 145.67876f);
generalPath.quadTo(107.55114f, 146.2344f, 106.51647f, 146.2344f);
generalPath.quadTo(105.41793f, 146.2344f, 104.72176f, 145.62766f);
generalPath.quadTo(104.0256f, 145.01451f, 103.885086f, 143.90959f);
generalPath.closePath();
generalPath.moveTo(108.59181f, 139.7773f);
generalPath.quadTo(108.59181f, 138.78734f, 108.0617f, 138.20613f);
generalPath.quadTo(107.53798f, 137.62492f, 106.7971f, 137.62492f);
generalPath.quadTo(106.03068f, 137.62492f, 105.462234f, 138.25084f);
generalPath.quadTo(104.89381f, 138.87675f, 104.89381f, 139.87311f);
generalPath.quadTo(104.89381f, 140.76727f, 105.430305f, 141.32932f);
generalPath.quadTo(105.97318f, 141.88498f, 106.76517f, 141.88498f);
generalPath.quadTo(107.563515f, 141.88498f, 108.07447f, 141.32932f);
generalPath.quadTo(108.59181f, 140.76727f, 108.59181f, 139.7773f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-0.7411137223243713f, 0.0f, 0.0f, 0.7040170431137085f, 97.23987579345703f, 68.87820434570312f));
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
generalPath.moveTo(47.032032f, 42.984238f);
generalPath.curveTo(46.9115f, 42.99054f, 46.80502f, 43.013386f, 46.688282f, 43.046738f);
generalPath.curveTo(46.100063f, 43.214798f, 43.872826f, 44.405834f, 43.563282f, 44.921738f);
generalPath.curveTo(43.072773f, 45.739254f, 44.14471f, 50.572273f, 44.407032f, 51.359238f);
generalPath.curveTo(44.734028f, 52.340225f, 46.004692f, 55.445168f, 45.438282f, 56.577988f);
generalPath.curveTo(45.17401f, 57.10653f, 40.59938f, 56.534706f, 39.813282f, 56.796738f);
generalPath.curveTo(39.566742f, 56.878918f, 39.422318f, 57.304718f, 39.188282f, 57.421738f);
generalPath.curveTo(36.475513f, 58.778122f, 36.06012f, 60.656464f, 38.157032f, 63.015488f);
generalPath.curveTo(38.92808f, 63.88292f, 39.53362f, 64.36906f, 40.438282f, 65.10924f);
generalPath.curveTo(41.237274f, 65.76296f, 42.07063f, 66.42646f, 42.938282f, 66.98424f);
generalPath.curveTo(42.946682f, 66.98964f, 43.06471f, 67.07576f, 43.157032f, 67.14049f);
generalPath.curveTo(42.28938f, 67.698265f, 41.456024f, 68.36176f, 40.657032f, 69.01549f);
generalPath.curveTo(39.75237f, 69.75567f, 39.14683f, 70.241806f, 38.375782f, 71.10924f);
generalPath.curveTo(36.27887f, 73.46826f, 36.694263f, 75.3466f, 39.407032f, 76.70299f);
generalPath.curveTo(39.641068f, 76.82001f, 39.785492f, 77.245804f, 40.032032f, 77.32799f);
generalPath.curveTo(40.81813f, 77.59002f, 45.39276f, 77.018196f, 45.657032f, 77.54674f);
generalPath.curveTo(46.223442f, 78.67956f, 44.952778f, 81.7845f, 44.625782f, 82.76549f);
generalPath.curveTo(44.36346f, 83.55245f, 43.291523f, 88.385475f, 43.782032f, 89.20299f);
generalPath.curveTo(44.091576f, 89.718895f, 46.318813f, 90.90993f, 46.907032f, 91.07799f);
generalPath.curveTo(47.02377f, 91.111336f, 47.13025f, 91.134186f, 47.250782f, 91.14049f);
generalPath.curveTo(47.61238f, 91.15925f, 48.011555f, 91.07799f, 48.375782f, 91.07799f);
generalPath.curveTo(48.92628f, 91.07799f, 49.687508f, 91.21099f, 50.219532f, 91.07799f);
generalPath.curveTo(53.542244f, 90.24731f, 58.220936f, 85.76991f, 60.219532f, 83.17174f);
generalPath.curveTo(60.934242f, 82.242615f, 63.451977f, 78.60538f, 62.719532f, 77.14049f);
generalPath.curveTo(62.50649f, 76.7144f, 62.354935f, 77.09534f, 62.094532f, 76.92174f);
generalPath.curveTo(61.93126f, 76.81289f, 61.85155f, 76.62434f, 61.688282f, 76.51549f);
generalPath.curveTo(61.19082f, 76.183846f, 60.625782f, 76.70833f, 60.625782f, 75.89049f);
generalPath.curveTo(60.625782f, 75.75173f, 60.52767f, 75.551094f, 60.625782f, 75.45299f);
generalPath.curveTo(60.63689f, 75.44188f, 63.133064f, 75.195f, 63.344532f, 75.26549f);
generalPath.curveTo(63.53069f, 75.32754f, 63.57527f, 75.58398f, 63.750782f, 75.67174f);
generalPath.curveTo(63.90936f, 75.75103f, 64.13993f, 75.598045f, 64.18828f, 75.45299f);
generalPath.curveTo(64.41218f, 74.781296f, 64.30156f, 71.902214f, 64.18828f, 71.10924f);
generalPath.curveTo(64.09428f, 70.45124f, 63.775757f, 69.65293f, 63.56328f, 69.01549f);
generalPath.curveTo(63.376507f, 68.45517f, 63.440308f, 67.657486f, 63.50078f, 66.92174f);
generalPath.lineTo(63.25078f, 66.92174f);
generalPath.curveTo(63.20065f, 66.268776f, 63.181168f, 65.599304f, 63.34453f, 65.10924f);
generalPath.curveTo(63.557007f, 64.471794f, 63.875526f, 63.673485f, 63.96953f, 63.015488f);
generalPath.curveTo(64.08281f, 62.22251f, 64.19343f, 59.34343f, 63.96953f, 58.671738f);
generalPath.curveTo(63.921177f, 58.526676f, 63.690605f, 58.3737f, 63.53203f, 58.452988f);
generalPath.curveTo(63.356518f, 58.54075f, 63.311935f, 58.797188f, 63.12578f, 58.859238f);
generalPath.curveTo(62.91431f, 58.92973f, 60.418137f, 58.682846f, 60.40703f, 58.671738f);
generalPath.curveTo(60.308918f, 58.573627f, 60.40703f, 58.37299f, 60.40703f, 58.234238f);
generalPath.curveTo(60.40703f, 57.4164f, 60.972065f, 57.94088f, 61.46953f, 57.609238f);
generalPath.curveTo(61.632797f, 57.50039f, 61.712505f, 57.311836f, 61.87578f, 57.202988f);
generalPath.curveTo(62.13618f, 57.02939f, 62.287735f, 57.410324f, 62.50078f, 56.984238f);
generalPath.curveTo(63.233223f, 55.519352f, 60.71549f, 51.88211f, 60.00078f, 50.952988f);
generalPath.curveTo(58.002182f, 48.354813f, 53.323486f, 43.877415f, 50.00078f, 43.046738f);
generalPath.curveTo(49.468754f, 42.91373f, 48.707527f, 43.046738f, 48.15703f, 43.046738f);
generalPath.curveTo(47.7928f, 43.046738f, 47.393627f, 42.965477f, 47.03203f, 42.984238f);
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
generalPath.moveTo(47.190765f, 48.610233f);
generalPath.curveTo(50.827255f, 55.345543f, 42.249077f, 59.38905f, 41.946007f, 63.784218f);
generalPath.curveTo(46.886986f, 66.969444f, 44.94861f, 71.00371f, 40.306477f, 72.10051f);
generalPath.curveTo(41.156918f, 78.598434f, 51.59971f, 71.89883f, 48.006218f, 80.65884f);
generalPath.curveTo(42.208946f, 90.73026f, 56.789257f, 87.16943f, 60.114906f, 82.24595f);
generalPath.curveTo(64.40873f, 78.312614f, 58.117657f, 75.49999f, 63.698467f, 74.13813f);
generalPath.curveTo(61.926117f, 66.74273f, 62.0934f, 59.405373f, 57.65365f, 52.4432f);
generalPath.curveTo(55.63117f, 48.13479f, 51.024147f, 47.654594f, 47.36599f, 46.784595f);
shape = generalPath;
paint = new Color(170, 102, 183, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.8317757f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-82.23669f, 384.0046f);
generalPath.curveTo(-74.02697f, 387.35513f, -71.22149f, 388.13153f, -62.839336f, 388.44983f);
generalPath.curveTo(-59.60807f, 388.57254f, -45.05807f, 383.0772f, -41.82554f, 382.99432f);
generalPath.curveTo(-41.82554f, 382.99432f, -35.251312f, 392.28873f, -22.248293f, 408.0675f);
generalPath.curveTo(-21.674574f, 408.7637f, -17.653267f, 406.43466f, -18.47026f, 409.76712f);
generalPath.curveTo(-21.5482f, 422.32187f, 0.39063454f, 435.32227f, 8.688396f, 442.19666f);
generalPath.curveTo(8.9680605f, 442.0848f, 9.34165f, 442.05084f, 9.496619f, 441.79254f);
generalPath.curveTo(11.55141f, 438.3679f, 9.318036f, 441.31802f, 9.900731f, 439.56995f);
generalPath.curveTo(10.177815f, 438.7387f, 11.39909f, 435.96024f, 11.921289f, 435.12473f);
generalPath.curveTo(14.00197f, 431.79562f, 18.791183f, 424.41577f, 18.791183f, 424.41577f);
generalPath.curveTo(18.791183f, 424.41577f, -2.5305882f, 401.37628f, -13.739792f, 395.11768f);
generalPath.curveTo(-15.983011f, 393.84976f, -18.270996f, 390.93686f, -20.40763f, 389.25806f);
generalPath.curveTo(-27.763058f, 383.4788f, -25.405857f, 385.22177f, -35.763866f, 379.5594f);
generalPath.curveTo(-37.429123f, 378.64905f, -39.01481f, 377.5328f, -40.815258f, 376.93265f);
generalPath.curveTo(-41.342155f, 376.75702f, -41.885265f, 377.2374f, -42.431705f, 377.33676f);
generalPath.curveTo(-44.353188f, 377.68613f, -40.827423f, 375.88684f, -45.46254f, 377.74088f);
generalPath.curveTo(-47.61613f, 378.60233f, -49.651653f, 379.7344f, -51.72627f, 380.77173f);
generalPath.curveTo(-52.209805f, 381.0135f, -52.789875f, 381.422f, -53.342716f, 381.57996f);
generalPath.curveTo(-60.52495f, 383.63202f, -73.77479f, 385.41495f, -82.23669f, 384.00464f);
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
generalPath.moveTo(-82.23669f, 384.0046f);
generalPath.curveTo(-74.02697f, 387.35513f, -71.22149f, 388.13153f, -62.839336f, 388.44983f);
generalPath.curveTo(-59.60807f, 388.57254f, -45.05807f, 383.0772f, -41.82554f, 382.99432f);
generalPath.curveTo(-41.82554f, 382.99432f, -35.251312f, 392.28873f, -22.248293f, 408.0675f);
generalPath.curveTo(-21.674574f, 408.7637f, -17.653267f, 406.43466f, -18.47026f, 409.76712f);
generalPath.curveTo(-21.5482f, 422.32187f, 0.39063454f, 435.32227f, 8.688396f, 442.19666f);
generalPath.curveTo(8.9680605f, 442.0848f, 9.34165f, 442.05084f, 9.496619f, 441.79254f);
generalPath.curveTo(11.55141f, 438.3679f, 9.318036f, 441.31802f, 9.900731f, 439.56995f);
generalPath.curveTo(10.177815f, 438.7387f, 11.39909f, 435.96024f, 11.921289f, 435.12473f);
generalPath.curveTo(14.00197f, 431.79562f, 18.791183f, 424.41577f, 18.791183f, 424.41577f);
generalPath.curveTo(18.791183f, 424.41577f, -2.5305882f, 401.37628f, -13.739792f, 395.11768f);
generalPath.curveTo(-15.983011f, 393.84976f, -18.270996f, 390.93686f, -20.40763f, 389.25806f);
generalPath.curveTo(-27.763058f, 383.4788f, -25.405857f, 385.22177f, -35.763866f, 379.5594f);
generalPath.curveTo(-37.429123f, 378.64905f, -39.01481f, 377.5328f, -40.815258f, 376.93265f);
generalPath.curveTo(-41.342155f, 376.75702f, -41.885265f, 377.2374f, -42.431705f, 377.33676f);
generalPath.curveTo(-44.353188f, 377.68613f, -40.827423f, 375.88684f, -45.46254f, 377.74088f);
generalPath.curveTo(-47.61613f, 378.60233f, -49.651653f, 379.7344f, -51.72627f, 380.77173f);
generalPath.curveTo(-52.209805f, 381.0135f, -52.789875f, 381.422f, -53.342716f, 381.57996f);
generalPath.curveTo(-60.52495f, 383.63202f, -73.77479f, 385.41495f, -82.23669f, 384.00464f);
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
g.setComposite(AlphaComposite.getInstance(3, 0.75543475f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9869871139526367f, 0.0f, 0.0f, 0.9786286950111389f, -104.57089233398438f, 310.8235778808594f));
// _0_0_0_0_2_0
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(4.964609f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(5.4074473f, 40.999996f);
generalPath.curveTo(5.4074473f, 60.095108f, 20.90493f, 75.59259f, 40.000042f, 75.59259f);
generalPath.curveTo(59.095154f, 75.59259f, 74.592636f, 60.095108f, 74.592636f, 41.0f);
generalPath.curveTo(74.592636f, 21.90489f, 59.09515f, 6.4074097f, 40.000042f, 6.4074097f);
generalPath.curveTo(20.904932f, 6.4074097f, 5.407448f, 21.904892f, 5.407448f, 41.0f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-1.0311110019683838f, -0.0379299595952034f, 0.04966593161225319f, -1.3436360359191895f, -27.298179626464844f, 385.25445556640625f));
// _0_0_0_0_2_1
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_1_0
paint = new LinearGradientPaint(new Point2D.Double(34.84189224243164, -7.142457962036133), new Point2D.Double(35.56138610839844, 11.415727615356445), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(0.414f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(9.622763f, 14.273311f);
generalPath.curveTo(16.52386f, 6.082676f, 26.348398f, 1.7526093f, 37.11637f, 1.7526093f);
generalPath.curveTo(47.884342f, 1.7526093f, 58.408875f, 7.2008324f, 64.4136f, 14.980124f);
generalPath.curveTo(64.4136f, 14.980124f, 64.4136f, 14.980124f, 64.4136f, 14.980124f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_1_1
paint = new LinearGradientPaint(new Point2D.Double(34.84189224243164, -7.142457962036133), new Point2D.Double(35.56138610839844, 11.415727615356445), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(0.914f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(9.622763f, 14.573311f);
generalPath.curveTo(16.52386f, 6.382676f, 26.348398f, 2.0526092f, 37.11637f, 2.0526092f);
generalPath.curveTo(47.884342f, 2.0526092f, 58.408875f, 7.5008326f, 64.4136f, 15.280125f);
generalPath.curveTo(64.4136f, 15.280125f, 64.4136f, 15.280125f, 64.4136f, 15.280125f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_1_2
paint = new LinearGradientPaint(new Point2D.Double(34.84189224243164, -7.142457962036133), new Point2D.Double(35.56138610839844, 11.415727615356445), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(0.614f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(9.622763f, 14.473311f);
generalPath.curveTo(16.52386f, 6.282676f, 26.348398f, 1.9526092f, 37.11637f, 1.9526092f);
generalPath.curveTo(47.884342f, 1.9526092f, 58.408875f, 7.400832f, 64.4136f, 15.180124f);
generalPath.curveTo(64.4136f, 15.180124f, 64.4136f, 15.180124f, 64.4136f, 15.180124f);
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
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-38.2843f, 385.23026f);
generalPath.curveTo(-34.345966f, 381.9329f, -31.123833f, 378.31146f, -28.512672f, 374.2585f);
generalPath.curveTo(-7.1107903f, 392.80756f, 5.342369f, 404.57028f, 22.90857f, 419.94122f);
generalPath.curveTo(19.608889f, 424.5353f, 15.776389f, 428.30542f, 12.043579f, 431.88416f);
generalPath.curveTo(-4.7963295f, 415.69806f, -11.756073f, 410.95172f, -38.284306f, 385.23026f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(91.89352416992188, 98.32296752929688), new Point2D.Double(102.63838958740234, 87.5781021118164), new float[] {0.0f,1.0f}, new Color[] {new Color(54, 54, 54, 255),new Color(179, 179, 179, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -105.0914077758789f, 309.8841857910156f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(23, 23, 23, 113);
stroke = new BasicStroke(1.0f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-38.2843f, 385.23026f);
generalPath.curveTo(-34.345966f, 381.9329f, -31.123833f, 378.31146f, -28.512672f, 374.2585f);
generalPath.curveTo(-7.1107903f, 392.80756f, 5.342369f, 404.57028f, 22.90857f, 419.94122f);
generalPath.curveTo(19.608889f, 424.5353f, 15.776389f, 428.30542f, 12.043579f, 431.88416f);
generalPath.curveTo(-4.7963295f, 415.69806f, -11.756073f, 410.95172f, -38.284306f, 385.23026f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-30.827559f, 377.5197f);
generalPath.lineTo(-34.463352f, 381.63705f);
generalPath.curveTo(-30.663486f, 387.89774f, -22.198402f, 397.3374f, -10.278845f, 408.55f);
generalPath.curveTo(-0.52246857f, 417.72772f, 8.38508f, 424.7371f, 14.8961315f, 428.9411f);
generalPath.curveTo(17.178822f, 426.89944f, 18.52341f, 425.34534f, 20.087252f, 423.5461f);
generalPath.curveTo(15.396162f, 417.18594f, 7.3181915f, 408.5616f, -2.5162487f, 399.3105f);
generalPath.curveTo(-14.355937f, 388.173f, -24.484581f, 380.82962f, -30.827557f, 377.51974f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(3.953125, 74.83329772949219), 6.93199f, new Point2D.Double(0.9055841565132141, 73.29568481445312), new float[] {0.0f,0.6637168f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 61),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.43596601486206055f, -0.5661020278930664f, 5.670909881591797f, 5.233695983886719f, -433.73150634765625f, 13.386980056762695f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.73260075f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-37.65858f, 384.95584f);
generalPath.curveTo(-34.430492f, 381.98334f, -31.318977f, 378.4455f, -28.632576f, 374.8213f);
generalPath.curveTo(-11.816116f, 389.1909f, 5.7356186f, 405.6877f, 21.71447f, 419.74612f);
generalPath.curveTo(18.28639f, 424.27548f, 17.08702f, 426.46112f, 12.20214f, 430.82944f);
generalPath.curveTo(-4.4081793f, 414.8627f, -21.69749f, 400.2854f, -37.65858f, 384.95584f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(49.15742874145508, 62.38064193725586), 8.333237f, new Point2D.Double(45.900455474853516, 62.298255920410156), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.6268460154533386f, -0.7038319706916809f, 7.605719089508057f, 6.891554832458496f, -534.4470825195312f, -18.266569137573242f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.74418604f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-36.59702f, 385.39948f);
generalPath.lineTo(-28.7268f, 381.386f);
generalPath.curveTo(-11.910339f, 395.7556f, 2.7850418f, 407.30753f, 20.05102f, 420.7474f);
generalPath.curveTo(17.50045f, 425.96844f, 15.79105f, 426.24246f, 11.36409f, 430.5501f);
generalPath.curveTo(-4.985319f, 414.7262f, -20.63593f, 400.72903f, -36.59702f, 385.39948f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(39.03649139404297, 69.15291595458984), 8.333237f, new Point2D.Double(36.28557586669922, 69.15291595458984), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.6268460154533386f, -0.7038319706916809f, 7.605719089508057f, 6.891554832458496f, -535.28515625f, -18.54591941833496f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_6
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-28.665571f, 374.1309f);
generalPath.curveTo(-32.603905f, 377.42825f, -35.833332f, 381.05786f, -38.444496f, 385.11084f);
generalPath.lineTo(-38.268547f, 385.27026f);
generalPath.curveTo(-34.33021f, 381.9729f, -31.100784f, 378.3433f, -28.489622f, 374.2903f);
generalPath.lineTo(-28.665571f, 374.1309f);
generalPath.closePath();
shape = generalPath;
paint = new Color(92, 92, 92, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.6836779713630676f, -0.7920539975166321f, 0.18895800411701202f, 0.16406099498271942f, -78.2137222290039f, 412.6910400390625f));
// _0_0_0_0_2_7
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(59.107132f, 51.796238f);
generalPath.curveTo(59.107132f, 52.81994f, 56.74122f, 53.64981f, 53.82272f, 53.64981f);
generalPath.curveTo(50.90422f, 53.64981f, 48.538307f, 52.81994f, 48.538307f, 51.796238f);
generalPath.curveTo(48.538307f, 50.772537f, 50.90422f, 49.942665f, 53.82272f, 49.942665f);
generalPath.curveTo(56.74122f, 49.942665f, 59.107132f, 50.772537f, 59.107132f, 51.796238f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(53.82271957397461, 51.79623794555664), 5.284413f, new Point2D.Double(53.363365173339844, 53.70447540283203), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.3507629930973053f, 0.0f, 33.62805938720703f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.6511628f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.672249972820282f, -0.8017820119857788f, 0.1921350061893463f, 0.1603280007839203f, -27.103639602661133f, 458.2549743652344f));
// _0_0_0_0_2_8
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(59.107132f, 51.796238f);
generalPath.curveTo(59.107132f, 52.81994f, 56.74122f, 53.64981f, 53.82272f, 53.64981f);
generalPath.curveTo(50.90422f, 53.64981f, 48.538307f, 52.81994f, 48.538307f, 51.796238f);
generalPath.curveTo(48.538307f, 50.772537f, 50.90422f, 49.942665f, 53.82272f, 49.942665f);
generalPath.curveTo(56.74122f, 49.942665f, 59.107132f, 50.772537f, 59.107132f, 51.796238f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(53.82271957397461, 51.79623794555664), 5.284413f, new Point2D.Double(53.363365173339844, 53.70447540283203), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.3507629930973053f, 0.0f, 33.62805938720703f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_9
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-37.010513f, 370.06705f);
generalPath.curveTo(-39.16476f, 372.68866f, -41.147564f, 374.93372f, -43.091423f, 376.93008f);
generalPath.lineTo(-36.558304f, 382.94043f);
generalPath.curveTo(-34.13988f, 380.69055f, -31.928997f, 378.5423f, -30.2915f, 376.19675f);
generalPath.lineTo(-37.01051f, 370.06705f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(28.07171058654785, 20.204627990722656), new Point2D.Double(40.19868850708008, 20.20462989807129), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(174, 174, 174, 255)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-0.3581880033016205f, 0.4021790027618408f, 0.39682498574256897f, 0.35956498980522156f, -33.88959884643555f, 356.59320068359375f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_10
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-36.767323f, 371.21866f);
generalPath.curveTo(-38.921574f, 373.84027f, -40.773865f, 375.363f, -42.717728f, 377.35938f);
generalPath.lineTo(-36.558308f, 382.94043f);
generalPath.curveTo(-34.139885f, 380.69055f, -31.929f, 378.5423f, -30.291504f, 376.19675f);
generalPath.lineTo(-36.767326f, 371.21866f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(67.51517486572266, 86.70606231689453), new Point2D.Double(63.40166473388672, 61.357200622558594), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0052039623260498f, 0.037066441029310226f, -0.03709647059440613f, 1.006018042564392f, -101.08016204833984f, 311.4317626953125f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_11
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(22.39697f, 419.8477f);
generalPath.curveTo(16.29105f, 414.10757f, 6.445571f, 405.9943f, -4.982708f, 395.66214f);
generalPath.curveTo(-13.81944f, 387.67297f, -22.22175f, 380.30264f, -28.65713f, 375.54318f);
generalPath.lineTo(-33.42672f, 380.1455f);
generalPath.curveTo(-28.044659f, 386.07004f, -19.90372f, 394.40274f, -11.06699f, 402.3919f);
generalPath.curveTo(0.3612814f, 412.72406f, 10.994041f, 421.21906f, 17.705801f, 425.63583f);
generalPath.lineTo(22.39697f, 419.8477f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(-22.1875, 69.921875), 3.3125f, new Point2D.Double(-24.22588539123535, 69.91436767578125), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-0.8920683860778809f, 1.0389972925186157f, -21.233230590820312f, -18.230581283569336f, 1459.1827392578125f, 1698.9056396484375f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.8f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_12
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-36.872658f, 370.16544f);
generalPath.curveTo(-37.842094f, 371.45654f, -38.902435f, 372.69522f, -40.060158f, 373.85294f);
generalPath.curveTo(-40.47283f, 374.26562f, -40.90709f, 374.67908f, -41.341408f, 375.0717f);
generalPath.curveTo(-41.36311f, 375.09128f, -41.38215f, 375.1146f, -41.403908f, 375.1342f);
generalPath.curveTo(-41.97167f, 375.7515f, -42.533207f, 376.34216f, -43.091408f, 376.91544f);
generalPath.lineTo(-40.810158f, 379.04044f);
generalPath.curveTo(-38.665886f, 377.68497f, -36.813198f, 375.8738f, -35.435158f, 373.6342f);
generalPath.curveTo(-35.143433f, 373.16006f, -34.888844f, 372.68515f, -34.653908f, 372.1967f);
generalPath.lineTo(-36.872658f, 370.16544f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(56.256771087646484, 56.998897552490234), 9.725522f, new Point2D.Double(56.256771087646484, 56.998897552490234), new float[] {0.0f,0.6637168f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 61),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.9252870082855225f, -99.0914077758789f, 320.14276123046875f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.1875f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.6643393039703369f, -0.7474310994148254f, 0.7474311590194702f, 0.6643393039703369f, 0.0f, 0.0f));
// _0_0_0_0_2_13
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-305.6112f, 218.8499f);
generalPath.lineTo(-303.95917f, 218.8499f);
generalPath.lineTo(-303.95917f, 227.23187f);
generalPath.lineTo(-305.6112f, 227.23187f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(113.91755676269531, 47.035709381103516), new Point2D.Double(108.60655975341797, 69.3776626586914), new float[] {0.0f,1.0f}, new Color[] {new Color(86, 228, 253, 175),new Color(255, 255, 255, 181)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -420.2874755859375f, 160.38697814941406f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-5.327775001525879f, 0.0f, 0.0f, 7.786747932434082f, 87.0138931274414f, 392.53424072265625f));
// _0_0_0_0_2_14
paint = new LinearGradientPaint(new Point2D.Double(28.549489974975586, -10.100502967834473), new Point2D.Double(28.549489974975586, -0.8540247082710266), new float[] {0.0f,1.0f}, new Color[] {new Color(201, 202, 204, 255),new Color(172, 174, 177, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(0.62102485f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(34.93114f, -5.477264f);
generalPath.curveTo(34.93114f, -4.319225f, 34.25879f, -3.2086155f, 33.062f, -2.389758f);
generalPath.curveTo(31.865208f, -1.5709007f, 30.242008f, -1.1108713f, 28.54949f, -1.1108713f);
generalPath.curveTo(26.856972f, -1.1108713f, 25.233772f, -1.5709007f, 24.036982f, -2.389758f);
generalPath.curveTo(22.840189f, -3.2086155f, 22.16784f, -4.319225f, 22.16784f, -5.477264f);
generalPath.curveTo(22.16784f, -6.635303f, 22.840189f, -7.745912f, 24.036982f, -8.56477f);
generalPath.curveTo(25.233772f, -9.383627f, 26.856972f, -9.843657f, 28.54949f, -9.843657f);
generalPath.curveTo(30.242008f, -9.843657f, 31.865208f, -9.383627f, 33.062f, -8.56477f);
generalPath.curveTo(34.25879f, -7.745912f, 34.93114f, -6.635303f, 34.93114f, -5.477264f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_15
paint = new RadialGradientPaint(new Point2D.Double(28.549489974975586, -5.477263927459717), 6.6921635f, new Point2D.Double(28.549489974975586, -5.477263927459717), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 0),new Color(129, 129, 129, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-5.379427909851074f, -1.0975300028803758E-6f, -5.982265975035261E-6f, 29.321460723876953f, 88.48848724365234f, 510.4855651855469f));
stroke = new BasicStroke(3.9999998f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-99.09137f, 349.8842f);
generalPath.curveTo(-99.09137f, 368.6522f, -83.85937f, 383.8842f, -65.09137f, 383.8842f);
generalPath.curveTo(-46.32337f, 383.8842f, -31.09137f, 368.6522f, -31.09137f, 349.8842f);
generalPath.curveTo(-31.09137f, 331.11618f, -46.32337f, 315.8842f, -65.09137f, 315.8842f);
generalPath.curveTo(-83.85937f, 315.8842f, -99.09137f, 331.11618f, -99.09137f, 349.8842f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.71f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_16
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}

}

private void _paint2(Graphics2D g,float origAlpha) {
generalPath.moveTo(-65.24766f, 317.8842f);
generalPath.curveTo(-65.79348f, 317.87518f, -66.35233f, 317.89627f, -66.90391f, 317.91537f);
generalPath.curveTo(-84.554214f, 318.5297f, -98.31232f, 333.35602f, -97.62266f, 351.00912f);
generalPath.curveTo(-97.39854f, 356.74594f, -95.671486f, 362.06955f, -92.84141f, 366.63412f);
generalPath.curveTo(-92.85905f, 366.3605f, -92.8619f, 366.09717f, -92.87266f, 365.82162f);
generalPath.curveTo(-93.56232f, 348.16852f, -79.80421f, 333.3422f, -62.153908f, 332.72787f);
generalPath.curveTo(-50.239502f, 332.3132f, -39.594955f, 338.4652f, -33.716408f, 347.94662f);
generalPath.curveTo(-34.793434f, 331.23694f, -48.599804f, 318.1491f, -65.24766f, 317.88412f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(39.40945816040039, 9.579120635986328), 31.965544f, new Point2D.Double(33.4835319519043, 10.615250587463379), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.7625716924667358f, -105.0914077758789f, 317.5706787109375f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.0384724885225296f, 1.105376958847046f, 1.1382620334625244f, -0.04446890950202942f, -110.40129089355469f, 304.54638671875f));
// _0_0_0_0_2_17
paint = new LinearGradientPaint(new Point2D.Double(13.644913673400879, 38.367759704589844), new Point2D.Double(71.47347259521484, 38.367759704589844), new float[] {0.0f,1.0f}, new Color[] {new Color(163, 165, 168, 255),new Color(255, 255, 255, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(1.7278044f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(70.60957f, 38.36776f);
generalPath.curveTo(70.60957f, 45.593407f, 67.654274f, 52.52311f, 62.393806f, 57.632412f);
generalPath.curveTo(57.13334f, 62.741714f, 49.998615f, 65.61209f, 42.559193f, 65.61209f);
generalPath.curveTo(27.067398f, 65.61209f, 14.508817f, 53.41439f, 14.508816f, 38.36776f);
generalPath.curveTo(14.508816f, 23.32113f, 27.067398f, 11.123426f, 42.559193f, 11.123426f);
generalPath.curveTo(49.998615f, 11.1234255f, 57.13334f, 13.993802f, 62.393806f, 19.103106f);
generalPath.curveTo(67.654274f, 24.21241f, 70.60957f, 31.142113f, 70.60957f, 38.36776f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.272465467453003f, 0.0f, 0.0f, 1.272465467453003f, -100.71121215820312f, 321.2789611816406f));
// _0_0_0_0_2_18
g.setComposite(AlphaComposite.getInstance(3, 0.40625f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9136751294136047f, 0.0f, 0.0f, 0.6306344866752625f, -393.9872741699219f, 40.72113037109375f));
// _0_0_0_0_2_18_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(483.3296f, -50.078033f);
generalPath.curveTo(483.3296f, -38.994793f, 473.77277f, -30.010052f, 461.98383f, -30.01004f);
generalPath.curveTo(456.32257f, -30.010038f, 450.8932f, -32.124336f, 446.89008f, -35.887817f);
generalPath.curveTo(442.88696f, -39.651295f, 440.63803f, -44.75567f, 440.63803f, -50.078033f);
generalPath.curveTo(440.63803f, -55.4004f, 442.88696f, -60.504772f, 446.89008f, -64.26825f);
generalPath.curveTo(450.8932f, -68.03173f, 456.32257f, -70.14603f, 461.98383f, -70.14603f);
generalPath.curveTo(473.77277f, -70.14602f, 483.3296f, -61.161274f, 483.3296f, -50.078033f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(461.9837951660156, -50.078033447265625), 21.345785f, new Point2D.Double(461.5453186035156, -62.78385925292969), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.9245078563690186f, 8.883228588274505E-7f, -2.1962546270515304E-7f, 0.9889928102493286f, -427.1076965332031f, -0.5516313910484314f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_18_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(28.332724f, -1.7688984f);
generalPath.curveTo(14.895174f, -1.7688984f, 3.9821777f, 9.144091f, 3.9821777f, 22.581644f);
generalPath.curveTo(3.9821777f, 36.019196f, 14.895174f, 46.910767f, 28.332724f, 46.910767f);
generalPath.curveTo(41.770275f, 46.910767f, 52.661846f, 36.019196f, 52.661846f, 22.581644f);
generalPath.curveTo(52.661846f, 9.144091f, 41.770256f, -1.768898f, 28.332724f, -1.768898f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(654.5357055664062, -20.356201171875), 38.29028f, new Point2D.Double(653.7733764648438, 3.2766332626342773), new float[] {0.0f,0.57963896f,0.8822989f,1.0f}, new Color[] {new Color(162, 243, 255, 79),new Color(81, 210, 244, 119),new Color(56, 139, 201, 169),new Color(31, 68, 158, 220)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.6356658935546875f, 0.0f, 0.0f, 0.6356658935546875f, -387.74407958984375f, 35.51068115234375f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.390625f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7026383876800537f, 0.0f, 0.0f, 0.7026383876800537f, -333.2755126953125f, 26.424467086791992f));
// _0_0_0_0_2_18_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(514.84375f, -41.875f);
generalPath.curveTo(495.23627f, -41.875f, 479.3125f, -25.95124f, 479.3125f, -6.34375f);
generalPath.curveTo(479.3125f, -2.9406471f, 479.79214f, 0.35313177f, 480.6875f, 3.46875f);
generalPath.curveTo(480.00345f, 0.73960924f, 479.625f, -2.122239f, 479.625f, -5.0625f);
generalPath.curveTo(479.625f, -24.377249f, 495.31024f, -40.0625f, 514.625f, -40.0625f);
generalPath.curveTo(533.93976f, -40.0625f, 549.625f, -24.377247f, 549.625f, -5.0625f);
generalPath.curveTo(549.625f, 1.5769448f, 547.7782f, 7.7719746f, 544.5625f, 13.0625f);
generalPath.curveTo(548.2146f, 7.482852f, 550.34375f, 0.82337f, 550.34375f, -6.34375f);
generalPath.curveTo(550.34375f, -25.95124f, 534.45123f, -41.875f, 514.84375f, -41.875f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(529.51708984375, -49.40803527832031), new Point2D.Double(529.1305541992188, -2.031881332397461), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.5703125f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7026383876800537f, 0.0f, 0.0f, 0.7026383876800537f, -266.5909729003906f, 26.424467086791992f));
// _0_0_0_0_2_18_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(385.9375f, -16.09375f);
generalPath.curveTo(384.79688f, -12.592159f, 384.1875f, -8.880613f, 384.1875f, -5.0f);
generalPath.curveTo(384.1875f, 14.819393f, 400.27435f, 30.90625f, 420.09375f, 30.90625f);
generalPath.curveTo(439.91315f, 30.90625f, 455.96875f, 14.819393f, 455.96875f, -5.0f);
generalPath.curveTo(455.96875f, -8.880612f, 455.35938f, -12.592159f, 454.21875f, -16.09375f);
generalPath.curveTo(455.10294f, -12.994237f, 455.59375f, -9.725784f, 455.59375f, -6.34375f);
generalPath.curveTo(455.59375f, 13.263741f, 439.70123f, 29.15625f, 420.09375f, 29.15625f);
generalPath.curveTo(400.48627f, 29.156248f, 384.5625f, 13.263741f, 384.5625f, -6.34375f);
generalPath.curveTo(384.5625f, -9.725784f, 385.0533f, -12.994237f, 385.9375f, -16.09375f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(425.90679931640625, 7.40625), new Point2D.Double(426.270263671875, -21.585128784179688), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7026383876800537f, 0.0f, 0.0f, 0.7026383876800537f, -266.5909729003906f, 26.424467086791992f));
// _0_0_0_0_2_18_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(385.9375f, -16.09375f);
generalPath.curveTo(384.79688f, -12.592159f, 384.1875f, -8.880613f, 384.1875f, -5.0f);
generalPath.curveTo(384.1875f, 14.819393f, 400.27435f, 29.90625f, 420.09375f, 29.90625f);
generalPath.curveTo(439.91315f, 29.90625f, 455.96875f, 14.819394f, 455.96875f, -5.0f);
generalPath.curveTo(455.96875f, -8.880612f, 455.35938f, -12.592159f, 454.21875f, -16.09375f);
generalPath.curveTo(455.10294f, -12.994237f, 455.59375f, -9.725784f, 455.59375f, -6.34375f);
generalPath.curveTo(455.59375f, 13.263741f, 439.70123f, 29.15625f, 420.09375f, 29.15625f);
generalPath.curveTo(400.48627f, 29.156248f, 384.5625f, 13.263741f, 384.5625f, -6.34375f);
generalPath.curveTo(384.5625f, -9.725784f, 385.0533f, -12.994237f, 385.9375f, -16.09375f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(425.19970703125, 35.690521240234375), new Point2D.Double(424.8560485839844, 12.002443313598633), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7026383876800537f, 0.0f, 0.0f, 0.7026383876800537f, -333.2755126953125f, 26.424467086791992f));
// _0_0_0_0_2_18_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(514.84375f, -40.875f);
generalPath.curveTo(495.23627f, -40.875f, 479.3125f, -25.95124f, 479.3125f, -6.34375f);
generalPath.curveTo(479.3125f, -2.9406471f, 479.79214f, 0.35313177f, 480.6875f, 3.46875f);
generalPath.curveTo(480.00345f, 0.73960924f, 479.625f, -2.122239f, 479.625f, -5.0625f);
generalPath.curveTo(479.625f, -24.377249f, 495.31024f, -40.0625f, 514.625f, -40.0625f);
generalPath.curveTo(533.93976f, -40.0625f, 549.625f, -24.377247f, 549.625f, -5.0625f);
generalPath.curveTo(549.625f, 1.5769448f, 547.7782f, 7.7719746f, 544.5625f, 13.0625f);
generalPath.curveTo(548.2146f, 7.482852f, 550.34375f, 0.82337f, 550.34375f, -6.34375f);
generalPath.curveTo(550.34375f, -25.95124f, 534.45123f, -40.875f, 514.84375f, -40.875f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(529.51708984375, -49.40803527832031), new Point2D.Double(529.6305541992188, -22.28188133239746), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_18_6
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(28.429342f, -3.5254953f);
generalPath.curveTo(14.458402f, -3.5254953f, 3.112383f, 7.70249f, 3.112402f, 21.527956f);
generalPath.curveTo(3.112402f, 26.886229f, 4.822624f, 31.838602f, 7.7234535f, 35.910084f);
generalPath.curveTo(5.030179f, 31.929077f, 3.4637074f, 27.133469f, 3.4637074f, 21.967102f);
generalPath.curveTo(3.4637074f, 8.190124f, 14.652351f, -2.998518f, 28.429342f, -2.998518f);
generalPath.curveTo(42.206295f, -2.998518f, 53.373024f, 8.1901245f, 53.37299f, 21.967102f);
generalPath.curveTo(53.37299f, 27.133467f, 51.80267f, 31.929077f, 49.113243f, 35.910084f);
generalPath.curveTo(52.009983f, 31.8386f, 53.724304f, 26.886227f, 53.724304f, 21.527954f);
generalPath.curveTo(53.72432f, 7.70249f, 42.400246f, -3.5254953f, 28.429342f, -3.5254953f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(455.33935546875, -91.4619140625), new Point2D.Double(452.660888671875, -34.0517578125), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.6517223119735718f, 0.0f, 0.0f, 0.6517223119735718f, -266.5909729003906f, 35.222721099853516f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7026383876800537f, 0.0f, 0.0f, 0.7026383876800537f, -357.7611389160156f, 26.424467086791992f));
// _0_0_0_0_2_18_7
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(549.125f, -40.125f);
generalPath.curveTo(530.00055f, -40.125f, 514.46875f, -24.593172f, 514.46875f, -5.46875f);
generalPath.curveTo(514.46875f, 12.079336f, 527.5698f, 26.541828f, 544.5f, 28.8125f);
generalPath.curveTo(529.9104f, 26.584162f, 518.71875f, 13.990063f, 518.71875f, -1.21875f);
generalPath.curveTo(518.71875f, -18.000893f, 532.3429f, -31.625002f, 549.125f, -31.625f);
generalPath.curveTo(565.9071f, -31.625f, 579.53125f, -18.000893f, 579.53125f, -1.21875f);
generalPath.curveTo(579.53125f, 14.514505f, 567.57245f, 27.44413f, 552.25f, 29.0f);
generalPath.curveTo(569.9163f, 27.426971f, 583.75f, 12.606974f, 583.75f, -5.46875f);
generalPath.curveTo(583.75f, -24.593172f, 568.2494f, -40.125f, 549.125f, -40.125f);
generalPath.closePath();
generalPath.moveTo(552.25f, 29.0f);
generalPath.curveTo(551.73926f, 29.05186f, 551.2054f, 29.09875f, 550.6875f, 29.125f);
generalPath.curveTo(551.20624f, 29.10194f, 551.7374f, 29.04564f, 552.25f, 29.0f);
generalPath.closePath();
generalPath.moveTo(544.5f, 28.8125f);
generalPath.curveTo(545.01154f, 28.88111f, 545.51294f, 28.953968f, 546.03125f, 29.0f);
generalPath.curveTo(545.5204f, 28.94814f, 545.0031f, 28.88934f, 544.5f, 28.8125f);
generalPath.closePath();
generalPath.moveTo(546.03125f, 29.0f);
generalPath.curveTo(546.5414f, 29.0453f, 547.04626f, 29.102055f, 547.5625f, 29.125f);
generalPath.curveTo(547.04456f, 29.09875f, 546.5421f, 29.05186f, 546.03125f, 29.0f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(549.109375, -5.5), 34.640625f, new Point2D.Double(549.109375, 15.369064331054688), new float[] {0.0f,0.795f,1.0f}, new Color[] {new Color(22, 54, 122, 0),new Color(22, 54, 122, 0),new Color(22, 54, 122, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.9995489120483398f, 0.0f, -0.002480830065906048f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.40625f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7373059988021851f, 0.0f, 0.0f, 0.6411355137825012f, -307.5618896484375f, 33.860286712646484f));
// _0_0_0_0_2_18_8
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(469.60727f, -34.831043f);
generalPath.curveTo(469.60727f, -30.180723f, 468.12137f, -25.720867f, 465.47644f, -22.432598f);
generalPath.curveTo(462.83154f, -19.144327f, 459.24426f, -17.296999f, 455.50378f, -17.297005f);
generalPath.curveTo(447.71466f, -17.297012f, 441.40033f, -25.147266f, 441.40033f, -34.831043f);
generalPath.curveTo(441.40033f, -44.51482f, 447.71466f, -52.365074f, 455.50378f, -52.36508f);
generalPath.curveTo(463.2929f, -52.365074f, 469.60724f, -44.51482f, 469.60724f, -34.831043f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(455.5038146972656, -40.34979248046875), 14.103466f, new Point2D.Double(455.5038146972656, -32.88325119018555), new float[] {0.0f,1.0f}, new Color[] {new Color(86, 228, 253, 175),new Color(255, 255, 255, 181)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.486486554145813f, -8.417273988925444E-7f, 1.0406811270513572E-6f, 1.837837815284729f, -221.59640502929688f, 32.46456527709961f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.58984375f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_2_18_9
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(29.44629f, 0.21256398f);
generalPath.lineTo(29.648642f, 4.439237f);
generalPath.curveTo(31.324497f, 4.469328f, 32.957016f, 4.62683f, 34.52795f, 4.874713f);
generalPath.curveTo(34.201626f, 3.499492f, 33.87911f, 2.1244318f, 33.53858f, 0.75050807f);
generalPath.curveTo(32.228886f, 0.45357358f, 30.86117f, 0.2843541f, 29.44629f, 0.21256398f);
generalPath.closePath();
generalPath.moveTo(26.343327f, 0.23818238f);
generalPath.curveTo(24.984999f, 0.34143147f, 23.662796f, 0.5656826f, 22.4084f, 0.87858707f);
generalPath.curveTo(22.04677f, 2.335656f, 21.6967f, 3.7993238f, 21.351604f, 5.2589564f);
generalPath.curveTo(22.968073f, 4.895446f, 24.65706f, 4.6671686f, 26.41077f, 4.5417023f);
generalPath.lineTo(26.613146f, 0.23818207f);
generalPath.curveTo(26.520786f, 0.24415207f, 26.435284f, 0.23119207f, 26.343328f, 0.23818207f);
generalPath.closePath();
generalPath.moveTo(36.011967f, 1.4677594f);
generalPath.curveTo(36.428314f, 2.779594f, 36.83896f, 4.0950537f, 37.24864f, 5.412652f);
generalPath.curveTo(40.20459f, 6.137951f, 42.88738f, 7.2236633f, 45.14096f, 8.614676f);
generalPath.curveTo(43.389896f, 5.4700694f, 40.122684f, 2.9145107f, 36.01197f, 1.4677593f);
generalPath.closePath();
generalPath.moveTo(19.575256f, 1.7751533f);
generalPath.curveTo(15.17321f, 3.5408685f, 11.842925f, 6.6214757f, 10.513713f, 10.305347f);
generalPath.curveTo(12.572208f, 8.597153f, 15.186f, 7.1941733f, 18.158703f, 6.1811385f);
generalPath.curveTo(18.628277f, 4.7133965f, 19.097061f, 3.2452433f, 19.575256f, 1.7751533f);
generalPath.closePath();
generalPath.moveTo(29.716108f, 5.848128f);
generalPath.lineTo(30.030891f, 12.021631f);
generalPath.curveTo(32.18577f, 12.077671f, 34.290455f, 12.271145f, 36.281784f, 12.636419f);
generalPath.curveTo(35.830017f, 10.538348f, 35.355488f, 8.435743f, 34.865215f, 6.3348365f);
generalPath.curveTo(33.210037f, 6.056418f, 31.49036f, 5.883179f, 29.716108f, 5.8481283f);
generalPath.closePath();
generalPath.moveTo(26.343328f, 5.924977f);
generalPath.curveTo(24.480545f, 6.0616336f, 22.697088f, 6.3659706f, 20.991827f, 6.770313f);
generalPath.curveTo(20.50415f, 8.869917f, 20.048494f, 10.968524f, 19.59775f, 13.0718975f);
generalPath.curveTo(21.643957f, 12.578826f, 23.797682f, 12.25429f, 26.051016f, 12.09848f);
generalPath.lineTo(26.343328f, 5.9249773f);
generalPath.closePath();
generalPath.moveTo(37.720856f, 6.949625f);
generalPath.curveTo(38.386837f, 9.108831f, 39.05327f, 11.28702f, 39.699535f, 13.4561405f);
generalPath.curveTo(42.113613f, 14.140901f, 44.32391f, 15.030043f, 46.28772f, 16.120226f);
generalPath.curveTo(46.451393f, 15.38192f, 46.535053f, 14.638714f, 46.535053f, 13.866f);
generalPath.curveTo(46.535053f, 12.736368f, 46.340015f, 11.662572f, 45.995403f, 10.612742f);
generalPath.curveTo(43.685352f, 9.031858f, 40.877403f, 7.775354f, 37.72085f, 6.9496255f);
generalPath.closePath();
generalPath.moveTo(17.641542f, 7.743727f);
generalPath.curveTo(14.657038f, 8.824017f, 12.051964f, 10.311432f, 10.041523f, 12.098481f);
generalPath.curveTo(9.940949f, 12.678941f, 9.884139f, 13.265328f, 9.884139f, 13.866f);
generalPath.curveTo(9.884139f, 14.898075f, 10.042107f, 15.895623f, 10.333835f, 16.863098f);
generalPath.curveTo(11.905232f, 15.868199f, 13.669479f, 14.9949045f, 15.595377f, 14.275862f);
generalPath.curveTo(16.264887f, 12.1018715f, 16.9497f, 9.92042f, 17.641542f, 7.743729f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(419.6562805175781, -24.165376663208008), 27.472944f, new Point2D.Double(419.6562805175781, -24.165376663208008), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.7195271849632263f, 0.0f, 0.0f, 0.6485208868980408f, -273.7445068359375f, 28.17670249938965f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.45652172f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.6643393039703369f, -0.7474310994148254f, 0.7474311590194702f, 0.6643393039703369f, 0.0f, 0.0f));
// _0_0_0_0_2_19
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-304.2993f, 228.78679f);
generalPath.lineTo(-303.54343f, 228.78679f);
generalPath.lineTo(-303.54343f, 295.08072f);
generalPath.lineTo(-304.2993f, 295.08072f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(113.4251708984375, 55.401756286621094), new Point2D.Double(114.41651916503906, 118.73043823242188), new float[] {0.0f,1.0f}, new Color[] {new Color(202, 236, 243, 251),new Color(14, 82, 104, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -420.0090026855469f, 170.0531768798828f));
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
_paint2(g, origAlpha);


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
	private slidepreview2() {
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
       slidepreview2 base = new slidepreview2();
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
       slidepreview2 base = new slidepreview2();
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
        return slidepreview2::new;
    }
}

