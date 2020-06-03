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
public class slidepreview_no_loupe_6 implements ResizableIcon {
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
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -0.0f, -0.0f));
// _0
g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7385876178741455f, 0.0f, 0.0f, 1.1095019578933716f, -6.918469429016113f, -8.622529029846191f));
// _0_0
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
// _0_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(2.4134474f, 3.073807f);
generalPath.lineTo(3.0941164f, 46.4382f);
generalPath.lineTo(3.0941164f, 162.48691f);
generalPath.lineTo(3.0941164f, 204.94376f);
generalPath.lineTo(73.99853f, 204.94376f);
generalPath.lineTo(73.99853f, 113.2193f);
generalPath.lineTo(73.99853f, 95.70585f);
generalPath.lineTo(73.99853f, 3.9813843f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new LinearGradientPaint(new Point2D.Double(15.5, 98.5642318725586), new Point2D.Double(112.5, 98.5642318725586), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.7385876178741455f, 0.0f, 0.0f, 1.1095019578933716f, -8.723286628723145f, -4.894649028778076f));
stroke = new BasicStroke(0.9052427f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(2.4134474f, 3.073807f);
generalPath.lineTo(3.0941164f, 46.4382f);
generalPath.lineTo(3.0941164f, 162.48691f);
generalPath.lineTo(3.0941164f, 204.94376f);
generalPath.lineTo(73.99853f, 204.94376f);
generalPath.lineTo(73.99853f, 113.2193f);
generalPath.lineTo(73.99853f, 95.70585f);
generalPath.lineTo(73.99853f, 3.9813843f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
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
generalPath.moveTo(4.22578f, 4.789145f);
generalPath.lineTo(4.679559f, 45.828674f);
generalPath.lineTo(4.679559f, 162.96472f);
generalPath.lineTo(4.679559f, 205.81937f);
generalPath.lineTo(76.24832f, 205.81937f);
generalPath.lineTo(76.24832f, 113.23549f);
generalPath.lineTo(76.24832f, 95.55793f);
generalPath.lineTo(74.886986f, 4.1084976f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(103.09768676757812, 56.26235580444336), 48.9f, new Point2D.Double(103.09768676757812, 56.26235580444336), new float[] {0.0f,1.0f}, new Color[] {new Color(210, 242, 255, 255),new Color(243, 243, 243, 201)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-0.9076445698738098f, 2.406406879425049f, -1.2132166624069214f, -1.0326120853424072f, 231.67376708984375f, -179.3292236328125f));
g.setPaint(paint);
g.fill(shape);
paint = new RadialGradientPaint(new Point2D.Double(18.182392120361328, 147.37173461914062), 48.5f, new Point2D.Double(18.182392120361328, 147.37173461914062), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.3981372117996216f, -0.014106130227446556f, 0.009401139803230762f, 2.102686882019043f, -20.272674560546875f, -107.73248291015625f));
stroke = new BasicStroke(1.6447041f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(4.22578f, 4.789145f);
generalPath.lineTo(4.679559f, 45.828674f);
generalPath.lineTo(4.679559f, 162.96472f);
generalPath.lineTo(4.679559f, 205.81937f);
generalPath.lineTo(76.24832f, 205.81937f);
generalPath.lineTo(76.24832f, 113.23549f);
generalPath.lineTo(76.24832f, 95.55793f);
generalPath.lineTo(74.886986f, 4.1084976f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.8200885653495789f, 0.0f, 0.0f, 0.8374932408332825f, -6.837552547454834f, 13.086779594421387f));
// _0_3
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_3_0
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
// _0_3_1
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
// _0_4
shape = new Rectangle2D.Double(7.06886100769043, 143.22177124023438, 65.65021514892578, 56.59598922729492);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new LinearGradientPaint(new Point2D.Double(57.019283294677734, 132.4290313720703), new Point2D.Double(55.3865852355957, 189.85377502441406), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.7385876178741455f, 0.0f, 0.0f, 1.1095019578933716f, -6.9184699058532715f, -8.622529029846191f));
stroke = new BasicStroke(0.18104854f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(7.06886100769043, 143.22177124023438, 65.65021514892578, 56.59598922729492);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.8931164741516113f, 0.0f, 0.0f, 1.119674801826477f, 0.0f, 0.0f));
// _0_5
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
generalPathText.moveTo(10.921317f, 147.2701f);
generalPathText.lineTo(10.921317f, 140.03564f);
generalPathText.lineTo(16.152227f, 140.03564f);
generalPathText.lineTo(16.152227f, 140.88773f);
generalPathText.lineTo(11.878673f, 140.88773f);
generalPathText.lineTo(11.878673f, 143.1051f);
generalPathText.lineTo(15.882457f, 143.1051f);
generalPathText.lineTo(15.882457f, 143.9539f);
generalPathText.lineTo(11.878673f, 143.9539f);
generalPathText.lineTo(11.878673f, 146.41473f);
generalPathText.lineTo(16.320011f, 146.41473f);
generalPathText.lineTo(16.320011f, 147.2701f);
generalPathText.lineTo(10.921317f, 147.2701f);
generalPathText.closePath();
generalPathText.moveTo(17.603065f, 147.2701f);
generalPathText.lineTo(17.603065f, 140.03564f);
generalPathText.lineTo(18.560421f, 140.03564f);
generalPathText.lineTo(18.560421f, 146.41473f);
generalPathText.lineTo(22.123362f, 146.41473f);
generalPathText.lineTo(22.123362f, 147.2701f);
generalPathText.lineTo(17.603065f, 147.2701f);
generalPathText.closePath();
generalPathText.moveTo(23.223825f, 147.2701f);
generalPathText.lineTo(23.223825f, 140.03564f);
generalPathText.lineTo(25.937977f, 140.03564f);
generalPathText.quadTo(26.767027f, 140.03564f, 27.26709f, 140.25607f);
generalPathText.quadTo(27.770441f, 140.4732f, 28.053371f, 140.9305f);
generalPathText.quadTo(28.3363f, 141.38779f, 28.3363f, 141.88457f);
generalPathText.quadTo(28.3363f, 142.34843f, 28.08298f, 142.75967f);
generalPathText.quadTo(27.832949f, 143.16762f, 27.326307f, 143.42093f);
generalPathText.quadTo(27.980993f, 143.61176f, 28.333012f, 144.07562f);
generalPathText.quadTo(28.688318f, 144.53949f, 28.688318f, 145.17116f);
generalPathText.quadTo(28.688318f, 145.68108f, 28.471186f, 146.11864f);
generalPathText.quadTo(28.257343f, 146.5529f, 27.941515f, 146.78978f);
generalPathText.quadTo(27.625687f, 147.02664f, 27.148653f, 147.14838f);
generalPathText.quadTo(26.674911f, 147.2701f, 25.984035f, 147.2701f);
generalPathText.lineTo(23.223825f, 147.2701f);
generalPathText.closePath();
generalPathText.moveTo(24.181181f, 143.0755f);
generalPathText.lineTo(25.747164f, 143.0755f);
generalPathText.quadTo(26.38211f, 143.0755f, 26.65846f, 142.98996f);
generalPathText.quadTo(27.023638f, 142.8814f, 27.20787f, 142.63136f);
generalPathText.quadTo(27.395395f, 142.37804f, 27.395395f, 141.99971f);
generalPathText.quadTo(27.395395f, 141.63782f, 27.221031f, 141.36476f);
generalPathText.quadTo(27.049957f, 141.0917f, 26.727549f, 140.98972f);
generalPathText.quadTo(26.40843f, 140.88773f, 25.628729f, 140.88773f);
generalPathText.lineTo(24.181181f, 140.88773f);
generalPathText.lineTo(24.181181f, 143.0755f);
generalPathText.closePath();
generalPathText.moveTo(24.181181f, 146.41473f);
generalPathText.lineTo(25.984035f, 146.41473f);
generalPathText.quadTo(26.447908f, 146.41473f, 26.635431f, 146.38182f);
generalPathText.quadTo(26.96442f, 146.32262f, 27.184843f, 146.18443f);
generalPathText.quadTo(27.408554f, 146.04626f, 27.550018f, 145.78307f);
generalPathText.quadTo(27.694775f, 145.51659f, 27.694775f, 145.17116f);
generalPathText.quadTo(27.694775f, 144.7665f, 27.48751f, 144.47041f);
generalPathText.quadTo(27.280249f, 144.17102f, 26.911781f, 144.0493f);
generalPathText.quadTo(26.546606f, 143.92758f, 25.85573f, 143.92758f);
generalPathText.lineTo(24.181181f, 143.92758f);
generalPathText.lineTo(24.181181f, 146.41473f);
generalPathText.closePath();
generalPathText.moveTo(29.645672f, 143.70058f);
generalPathText.quadTo(29.645672f, 142.41753f, 29.908863f, 141.63782f);
generalPathText.quadTo(30.172052f, 140.85483f, 30.691854f, 140.43044f);
generalPathText.quadTo(31.214945f, 140.00604f, 32.004517f, 140.00604f);
generalPathText.quadTo(32.586826f, 140.00604f, 33.02438f, 140.23962f);
generalPathText.quadTo(33.465225f, 140.4732f, 33.751442f, 140.91734f);
generalPathText.quadTo(34.037663f, 141.35818f, 34.198868f, 141.99313f);
generalPathText.quadTo(34.36336f, 142.62479f, 34.36336f, 143.70058f);
generalPathText.quadTo(34.36336f, 144.97375f, 34.10017f, 145.75674f);
generalPathText.quadTo(33.84027f, 146.53975f, 33.31718f, 146.96742f);
generalPathText.quadTo(32.79738f, 147.39511f, 32.004517f, 147.39511f);
generalPathText.quadTo(30.958334f, 147.39511f, 30.359577f, 146.64172f);
generalPathText.quadTo(29.645672f, 145.7403f, 29.645672f, 143.70058f);
generalPathText.closePath();
generalPathText.moveTo(30.556969f, 143.70058f);
generalPathText.quadTo(30.556969f, 145.48369f, 30.974785f, 146.07259f);
generalPathText.quadTo(31.3926f, 146.66147f, 32.004517f, 146.66147f);
generalPathText.quadTo(32.616436f, 146.66147f, 33.03096f, 146.06929f);
generalPathText.quadTo(33.448776f, 145.47711f, 33.448776f, 143.70058f);
generalPathText.quadTo(33.448776f, 141.91417f, 33.03096f, 141.32857f);
generalPathText.quadTo(32.616436f, 140.73969f, 31.994648f, 140.73969f);
generalPathText.quadTo(31.382729f, 140.73969f, 31.017553f, 141.25949f);
generalPathText.quadTo(30.556969f, 141.92075f, 30.556969f, 143.70058f);
generalPathText.closePath();
generalPathText.moveTo(35.266434f, 143.70058f);
generalPathText.quadTo(35.266434f, 142.41753f, 35.529625f, 141.63782f);
generalPathText.quadTo(35.792816f, 140.85483f, 36.312614f, 140.43044f);
generalPathText.quadTo(36.83571f, 140.00604f, 37.62528f, 140.00604f);
generalPathText.quadTo(38.20759f, 140.00604f, 38.64514f, 140.23962f);
generalPathText.quadTo(39.085987f, 140.4732f, 39.372204f, 140.91734f);
generalPathText.quadTo(39.658424f, 141.35818f, 39.81963f, 141.99313f);
generalPathText.quadTo(39.984123f, 142.62479f, 39.984123f, 143.70058f);
generalPathText.quadTo(39.984123f, 144.97375f, 39.720932f, 145.75674f);
generalPathText.quadTo(39.461033f, 146.53975f, 38.937943f, 146.96742f);
generalPathText.quadTo(38.41814f, 147.39511f, 37.62528f, 147.39511f);
generalPathText.quadTo(36.579098f, 147.39511f, 35.98034f, 146.64172f);
generalPathText.quadTo(35.266434f, 145.7403f, 35.266434f, 143.70058f);
generalPathText.closePath();
generalPathText.moveTo(36.17773f, 143.70058f);
generalPathText.quadTo(36.17773f, 145.48369f, 36.595547f, 146.07259f);
generalPathText.quadTo(37.01336f, 146.66147f, 37.62528f, 146.66147f);
generalPathText.quadTo(38.237198f, 146.66147f, 38.651722f, 146.06929f);
generalPathText.quadTo(39.06954f, 145.47711f, 39.06954f, 143.70058f);
generalPathText.quadTo(39.06954f, 141.91417f, 38.651722f, 141.32857f);
generalPathText.quadTo(38.237198f, 140.73969f, 37.61541f, 140.73969f);
generalPathText.quadTo(37.00349f, 140.73969f, 36.638313f, 141.25949f);
generalPathText.quadTo(36.17773f, 141.92075f, 36.17773f, 143.70058f);
generalPathText.closePath();
generalPathText.moveTo(41.01879f, 145.59555f);
generalPathText.lineTo(41.87416f, 145.51659f);
generalPathText.quadTo(41.982727f, 146.11864f, 42.288685f, 146.3917f);
generalPathText.quadTo(42.594643f, 146.66147f, 43.07168f, 146.66147f);
generalPathText.quadTo(43.48291f, 146.66147f, 43.78887f, 146.47394f);
generalPathText.quadTo(44.098118f, 146.28642f, 44.295513f, 145.97388f);
generalPathText.quadTo(44.492905f, 145.66135f, 44.6245f, 145.12839f);
generalPathText.quadTo(44.759384f, 144.59543f, 44.759384f, 144.04272f);
generalPathText.quadTo(44.759384f, 143.9835f, 44.756096f, 143.86507f);
generalPathText.quadTo(44.489616f, 144.28946f, 44.02574f, 144.55266f);
generalPathText.quadTo(43.56516f, 144.81584f, 43.028908f, 144.81584f);
generalPathText.quadTo(42.13077f, 144.81584f, 41.508984f, 144.16444f);
generalPathText.quadTo(40.887196f, 143.51305f, 40.887196f, 142.44713f);
generalPathText.quadTo(40.887196f, 141.34831f, 41.5353f, 140.67717f);
generalPathText.quadTo(42.18341f, 140.00604f, 43.160503f, 140.00604f);
generalPathText.quadTo(43.86783f, 140.00604f, 44.450138f, 140.38766f);
generalPathText.quadTo(45.035736f, 140.766f, 45.338406f, 141.47003f);
generalPathText.quadTo(45.644363f, 142.17078f, 45.644363f, 143.50319f);
generalPathText.quadTo(45.644363f, 144.89151f, 45.341694f, 145.71399f);
generalPathText.quadTo(45.042316f, 146.53316f, 44.446846f, 146.96414f);
generalPathText.quadTo(43.85138f, 147.39511f, 43.051937f, 147.39511f);
generalPathText.quadTo(42.203148f, 147.39511f, 41.66361f, 146.92465f);
generalPathText.quadTo(41.127357f, 146.45091f, 41.01879f, 145.59555f);
generalPathText.closePath();
generalPathText.moveTo(44.6574f, 142.40436f);
generalPathText.quadTo(44.6574f, 141.63782f, 44.249454f, 141.1904f);
generalPathText.quadTo(43.84151f, 140.73969f, 43.26907f, 140.73969f);
generalPathText.quadTo(42.67689f, 140.73969f, 42.236046f, 141.2233f);
generalPathText.quadTo(41.798492f, 141.70691f, 41.798492f, 142.47675f);
generalPathText.quadTo(41.798492f, 143.16762f, 42.21631f, 143.60188f);
generalPathText.quadTo(42.63412f, 144.03285f, 43.24604f, 144.03285f);
generalPathText.quadTo(43.861248f, 144.03285f, 44.259323f, 143.60188f);
generalPathText.quadTo(44.6574f, 143.16762f, 44.6574f, 142.40436f);
generalPathText.closePath();
generalPathText.moveTo(46.507957f, 143.70058f);
generalPathText.quadTo(46.507957f, 142.41753f, 46.77115f, 141.63782f);
generalPathText.quadTo(47.03434f, 140.85483f, 47.55414f, 140.43044f);
generalPathText.quadTo(48.077232f, 140.00604f, 48.866802f, 140.00604f);
generalPathText.quadTo(49.449112f, 140.00604f, 49.886665f, 140.23962f);
generalPathText.quadTo(50.32751f, 140.4732f, 50.613728f, 140.91734f);
generalPathText.quadTo(50.89995f, 141.35818f, 51.061153f, 141.99313f);
generalPathText.quadTo(51.225647f, 142.62479f, 51.225647f, 143.70058f);
generalPathText.quadTo(51.225647f, 144.97375f, 50.962456f, 145.75674f);
generalPathText.quadTo(50.702557f, 146.53975f, 50.179466f, 146.96742f);
generalPathText.quadTo(49.659664f, 147.39511f, 48.866802f, 147.39511f);
generalPathText.quadTo(47.82062f, 147.39511f, 47.221863f, 146.64172f);
generalPathText.quadTo(46.507957f, 145.7403f, 46.507957f, 143.70058f);
generalPathText.closePath();
generalPathText.moveTo(47.419254f, 143.70058f);
generalPathText.quadTo(47.419254f, 145.48369f, 47.83707f, 146.07259f);
generalPathText.quadTo(48.254883f, 146.66147f, 48.866802f, 146.66147f);
generalPathText.quadTo(49.47872f, 146.66147f, 49.893246f, 146.06929f);
generalPathText.quadTo(50.31106f, 145.47711f, 50.31106f, 143.70058f);
generalPathText.quadTo(50.31106f, 141.91417f, 49.893246f, 141.32857f);
generalPathText.quadTo(49.47872f, 140.73969f, 48.856934f, 140.73969f);
generalPathText.quadTo(48.245014f, 140.73969f, 47.879837f, 141.25949f);
generalPathText.quadTo(47.419254f, 141.92075f, 47.419254f, 143.70058f);
generalPathText.closePath();
generalPathText.moveTo(52.03002f, 145.09877f);
generalPathText.lineTo(52.03002f, 144.20393f);
generalPathText.lineTo(54.757336f, 144.20393f);
generalPathText.lineTo(54.757336f, 145.09877f);
generalPathText.lineTo(52.03002f, 145.09877f);
generalPathText.closePath();
generalPathText.moveTo(55.494267f, 143.70058f);
generalPathText.quadTo(55.494267f, 142.41753f, 55.757458f, 141.63782f);
generalPathText.quadTo(56.02065f, 140.85483f, 56.540447f, 140.43044f);
generalPathText.quadTo(57.06354f, 140.00604f, 57.85311f, 140.00604f);
generalPathText.quadTo(58.43542f, 140.00604f, 58.872974f, 140.23962f);
generalPathText.quadTo(59.31382f, 140.4732f, 59.600037f, 140.91734f);
generalPathText.quadTo(59.886257f, 141.35818f, 60.047462f, 141.99313f);
generalPathText.quadTo(60.211956f, 142.62479f, 60.211956f, 143.70058f);
generalPathText.quadTo(60.211956f, 144.97375f, 59.948765f, 145.75674f);
generalPathText.quadTo(59.688866f, 146.53975f, 59.165775f, 146.96742f);
generalPathText.quadTo(58.645973f, 147.39511f, 57.85311f, 147.39511f);
generalPathText.quadTo(56.80693f, 147.39511f, 56.20817f, 146.64172f);
generalPathText.quadTo(55.494267f, 145.7403f, 55.494267f, 143.70058f);
generalPathText.closePath();
generalPathText.moveTo(56.405563f, 143.70058f);
generalPathText.quadTo(56.405563f, 145.48369f, 56.82338f, 146.07259f);
generalPathText.quadTo(57.24119f, 146.66147f, 57.85311f, 146.66147f);
generalPathText.quadTo(58.46503f, 146.66147f, 58.879555f, 146.06929f);
generalPathText.quadTo(59.29737f, 145.47711f, 59.29737f, 143.70058f);
generalPathText.quadTo(59.29737f, 141.91417f, 58.879555f, 141.32857f);
generalPathText.quadTo(58.46503f, 140.73969f, 57.843243f, 140.73969f);
generalPathText.quadTo(57.231323f, 140.73969f, 56.866146f, 141.25949f);
generalPathText.quadTo(56.405563f, 141.92075f, 56.405563f, 143.70058f);
generalPathText.closePath();
generalPathText.moveTo(61.11503f, 143.70058f);
generalPathText.quadTo(61.11503f, 142.41753f, 61.37822f, 141.63782f);
generalPathText.quadTo(61.64141f, 140.85483f, 62.16121f, 140.43044f);
generalPathText.quadTo(62.684303f, 140.00604f, 63.473873f, 140.00604f);
generalPathText.quadTo(64.05618f, 140.00604f, 64.49374f, 140.23962f);
generalPathText.quadTo(64.93458f, 140.4732f, 65.2208f, 140.91734f);
generalPathText.quadTo(65.50702f, 141.35818f, 65.66822f, 141.99313f);
generalPathText.quadTo(65.83272f, 142.62479f, 65.83272f, 143.70058f);
generalPathText.quadTo(65.83272f, 144.97375f, 65.56953f, 145.75674f);
generalPathText.quadTo(65.30962f, 146.53975f, 64.78654f, 146.96742f);
generalPathText.quadTo(64.26673f, 147.39511f, 63.473873f, 147.39511f);
generalPathText.quadTo(62.427692f, 147.39511f, 61.828934f, 146.64172f);
generalPathText.quadTo(61.11503f, 145.7403f, 61.11503f, 143.70058f);
generalPathText.closePath();
generalPathText.moveTo(62.026325f, 143.70058f);
generalPathText.quadTo(62.026325f, 145.48369f, 62.44414f, 146.07259f);
generalPathText.quadTo(62.861954f, 146.66147f, 63.473873f, 146.66147f);
generalPathText.quadTo(64.08579f, 146.66147f, 64.50031f, 146.06929f);
generalPathText.quadTo(64.91813f, 145.47711f, 64.91813f, 143.70058f);
generalPathText.quadTo(64.91813f, 141.91417f, 64.50031f, 141.32857f);
generalPathText.quadTo(64.08579f, 140.73969f, 63.464005f, 140.73969f);
generalPathText.quadTo(62.852085f, 140.73969f, 62.486908f, 141.25949f);
generalPathText.quadTo(62.026325f, 141.92075f, 62.026325f, 143.70058f);
generalPathText.closePath();
generalPathText.moveTo(66.73579f, 143.70058f);
generalPathText.quadTo(66.73579f, 142.41753f, 66.99898f, 141.63782f);
generalPathText.quadTo(67.26217f, 140.85483f, 67.78197f, 140.43044f);
generalPathText.quadTo(68.30506f, 140.00604f, 69.094635f, 140.00604f);
generalPathText.quadTo(69.67694f, 140.00604f, 70.114494f, 140.23962f);
generalPathText.quadTo(70.555336f, 140.4732f, 70.84156f, 140.91734f);
generalPathText.quadTo(71.12778f, 141.35818f, 71.28898f, 141.99313f);
generalPathText.quadTo(71.453476f, 142.62479f, 71.453476f, 143.70058f);
generalPathText.quadTo(71.453476f, 144.97375f, 71.190285f, 145.75674f);
generalPathText.quadTo(70.93038f, 146.53975f, 70.407295f, 146.96742f);
generalPathText.quadTo(69.88749f, 147.39511f, 69.094635f, 147.39511f);
generalPathText.quadTo(68.04845f, 147.39511f, 67.44969f, 146.64172f);
generalPathText.quadTo(66.73579f, 145.7403f, 66.73579f, 143.70058f);
generalPathText.closePath();
generalPathText.moveTo(67.64709f, 143.70058f);
generalPathText.quadTo(67.64709f, 145.48369f, 68.064896f, 146.07259f);
generalPathText.quadTo(68.48271f, 146.66147f, 69.094635f, 146.66147f);
generalPathText.quadTo(69.70655f, 146.66147f, 70.12107f, 146.06929f);
generalPathText.quadTo(70.53889f, 145.47711f, 70.53889f, 143.70058f);
generalPathText.quadTo(70.53889f, 141.91417f, 70.12107f, 141.32857f);
generalPathText.quadTo(69.70655f, 140.73969f, 69.08476f, 140.73969f);
generalPathText.quadTo(68.47285f, 140.73969f, 68.107666f, 141.25949f);
generalPathText.quadTo(67.64709f, 141.92075f, 67.64709f, 143.70058f);
generalPathText.closePath();
generalPathText.moveTo(72.488144f, 145.59555f);
generalPathText.lineTo(73.34351f, 145.51659f);
generalPathText.quadTo(73.45208f, 146.11864f, 73.75804f, 146.3917f);
generalPathText.quadTo(74.064f, 146.66147f, 74.54103f, 146.66147f);
generalPathText.quadTo(74.95227f, 146.66147f, 75.258224f, 146.47394f);
generalPathText.quadTo(75.567474f, 146.28642f, 75.76487f, 145.97388f);
generalPathText.quadTo(75.962265f, 145.66135f, 76.09386f, 145.12839f);
generalPathText.quadTo(76.228745f, 144.59543f, 76.228745f, 144.04272f);
generalPathText.quadTo(76.228745f, 143.9835f, 76.22545f, 143.86507f);
generalPathText.quadTo(75.95897f, 144.28946f, 75.4951f, 144.55266f);
generalPathText.quadTo(75.034515f, 144.81584f, 74.49827f, 144.81584f);
generalPathText.quadTo(73.60013f, 144.81584f, 72.97834f, 144.16444f);
generalPathText.quadTo(72.35655f, 143.51305f, 72.35655f, 142.44713f);
generalPathText.quadTo(72.35655f, 141.34831f, 73.00466f, 140.67717f);
generalPathText.quadTo(73.65276f, 140.00604f, 74.62986f, 140.00604f);
generalPathText.quadTo(75.33718f, 140.00604f, 75.919495f, 140.38766f);
generalPathText.quadTo(76.50509f, 140.766f, 76.80776f, 141.47003f);
generalPathText.quadTo(77.11372f, 142.17078f, 77.11372f, 143.50319f);
generalPathText.quadTo(77.11372f, 144.89151f, 76.81105f, 145.71399f);
generalPathText.quadTo(76.51167f, 146.53316f, 75.91621f, 146.96414f);
generalPathText.quadTo(75.32073f, 147.39511f, 74.52129f, 147.39511f);
generalPathText.quadTo(73.67251f, 147.39511f, 73.132965f, 146.92465f);
generalPathText.quadTo(72.59671f, 146.45091f, 72.488144f, 145.59555f);
generalPathText.closePath();
generalPathText.moveTo(76.126755f, 142.40436f);
generalPathText.quadTo(76.126755f, 141.63782f, 75.71881f, 141.1904f);
generalPathText.quadTo(75.31087f, 140.73969f, 74.73843f, 140.73969f);
generalPathText.quadTo(74.14625f, 140.73969f, 73.70541f, 141.2233f);
generalPathText.quadTo(73.26785f, 141.70691f, 73.26785f, 142.47675f);
generalPathText.quadTo(73.26785f, 143.16762f, 73.68566f, 143.60188f);
generalPathText.quadTo(74.10348f, 144.03285f, 74.7154f, 144.03285f);
generalPathText.quadTo(75.330605f, 144.03285f, 75.72868f, 143.60188f);
generalPathText.quadTo(76.126755f, 143.16762f, 76.126755f, 142.40436f);
generalPathText.closePath();
shapeText = generalPath;
gText.fill(shapeText);
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
    gText.dispose();
}
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.5473774075508118f, 0.0f, 0.0f, 0.7811082601547241f, 9.056873321533203f, 67.79796600341797f));
// _0_6
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_6_0
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
g.transform(new AffineTransform(1.8268930912017822f, 0.0f, 0.0f, 1.280232310295105f, -16.54593849182129f, -86.79715728759766f));
// _0_6_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(34.96875f, 104.34375f);
generalPath.lineTo(34.875f, 105.78125f);
generalPath.curveTo(36.865532f, 111.04226f, 32.197144f, 114.1919f, 32.03125f, 117.625f);
generalPath.curveTo(34.735832f, 120.11301f, 33.665997f, 123.26828f, 31.125f, 124.125f);
generalPath.curveTo(31.590511f, 129.20058f, 37.310745f, 123.96998f, 35.34375f, 130.8125f);
generalPath.curveTo(32.170456f, 138.67938f, 40.148365f, 135.87703f, 41.96875f, 132.03125f);
generalPath.curveTo(44.31909f, 128.9589f, 40.88269f, 126.78251f, 43.9375f, 125.71875f);
generalPath.curveTo(42.967358f, 119.94214f, 43.055218f, 114.18821f, 40.625f, 108.75f);
generalPath.curveTo(39.51794f, 105.38466f, 36.971146f, 105.02331f, 34.96875f, 104.34375f);
generalPath.closePath();
generalPath.moveTo(37.65625f, 116.6875f);
generalPath.curveTo(39.509445f, 117.05814f, 39.9375f, 116.57086f, 39.9375f, 118.5f);
generalPath.curveTo(39.9375f, 123.37108f, 31.292852f, 120.93242f, 37.65625f, 116.6875f);
generalPath.closePath();
shape = generalPath;
paint = new Color(170, 102, 183, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.6027528047561646f, 0.0f, 0.0f, 0.5494840741157532f, 4.249017238616943f, -9.982442855834961f));
// _0_7
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_7_0
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
// _0_7_1
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
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.6027528047561646f, 0.0f, 0.0f, 0.5494840741157532f, 16.2490177154541f, 45.982444763183594f));
// _0_8
g.setComposite(AlphaComposite.getInstance(3, 0.8f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_8_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(5.1377196f, 20.205397f);
generalPath.lineTo(73.73864f, 84.94898f);
generalPath.lineTo(73.73864f, 108.071686f);
generalPath.lineTo(5.1377196f, 37.16205f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(0.9837678f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(5.1377196f, 20.205397f);
generalPath.lineTo(73.73864f, 84.94898f);
generalPath.lineTo(73.73864f, 108.071686f);
generalPath.lineTo(5.1377196f, 37.16205f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.8f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_8_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(4.2407675f, 6.333107f);
generalPath.lineTo(73.739456f, 72.62499f);
generalPath.lineTo(73.739456f, 61.05921f);
generalPath.lineTo(17.190214f, 4.791877f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(0.9837678f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(4.2407675f, 6.333107f);
generalPath.lineTo(73.739456f, 72.62499f);
generalPath.lineTo(73.739456f, 61.05921f);
generalPath.lineTo(17.190214f, 4.791877f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_8_2
shape = new Rectangle2D.Double(29.84966278076172, 179.7340087890625, 1.5811914205551147, 15.76681900024414);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.11233405f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(29.84966278076172, 179.7340087890625, 1.5811914205551147, 15.76681900024414);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_8_3
shape = new Rectangle2D.Double(25.346527099609375, 179.7477264404297, 3.447089433670044, 15.73938274383545);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.16571708f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(25.346527099609375, 179.7477264404297, 3.447089433670044, 15.73938274383545);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_8_4
shape = new Rectangle2D.Double(14.389704704284668, 179.7477264404297, 3.447089433670044, 15.73938274383545);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.16571708f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(14.389704704284668, 179.7477264404297, 3.447089433670044, 15.73938274383545);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_8_5
shape = new Rectangle2D.Double(9.834613800048828, 179.7477264404297, 3.447089433670044, 15.73938274383545);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.16571708f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(9.834613800048828, 179.7477264404297, 3.447089433670044, 15.73938274383545);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_8_6
shape = new Rectangle2D.Double(42.776248931884766, 179.7340087890625, 1.5811914205551147, 15.76681900024414);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.11233405f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(42.776248931884766, 179.7340087890625, 1.5811914205551147, 15.76681900024414);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_8_7
shape = new Rectangle2D.Double(52.00952911376953, 179.7340087890625, 1.5811914205551147, 15.76681900024414);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.11233405f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(52.00952911376953, 179.7340087890625, 1.5811914205551147, 15.76681900024414);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_8_8
shape = new Rectangle2D.Double(47.50639343261719, 179.7477264404297, 3.447089433670044, 15.73938274383545);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.16571708f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(47.50639343261719, 179.7477264404297, 3.447089433670044, 15.73938274383545);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_8_9
shape = new Rectangle2D.Double(36.54956817626953, 179.7477264404297, 3.447089433670044, 15.73938274383545);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.16571708f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(36.54956817626953, 179.7477264404297, 3.447089433670044, 15.73938274383545);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_8_10
shape = new Rectangle2D.Double(31.99448013305664, 179.7477264404297, 3.447089433670044, 15.73938274383545);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.16571708f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(31.99448013305664, 179.7477264404297, 3.447089433670044, 15.73938274383545);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_8_11
shape = new Rectangle2D.Double(64.93611145019531, 179.7340087890625, 1.5811914205551147, 15.76681900024414);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.11233405f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(64.93611145019531, 179.7340087890625, 1.5811914205551147, 15.76681900024414);
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
        return -5.543333530426025;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return -17.65045738220215;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 88.63050842285156;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 245.0196533203125;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private slidepreview_no_loupe_6() {
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
       slidepreview_no_loupe_6 base = new slidepreview_no_loupe_6();
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
       slidepreview_no_loupe_6 base = new slidepreview_no_loupe_6();
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
        return slidepreview_no_loupe_6::new;
    }
}

