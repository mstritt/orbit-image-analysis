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
public class slidepreview3 implements ResizableIcon {
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
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.0f, 1.0f, -1.0f, 0.0f, 227.3691864013672f, 5.543334007263184f));
// _0_0
g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7385876178741455f, 0.0f, 0.0f, 1.1095019578933716f, -6.918469429016113f, -8.622529029846191f));
// _0_0_0
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
// _0_0_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(3.0941164f, 3.9813657f);
generalPath.lineTo(3.0941164f, 46.4382f);
generalPath.lineTo(3.0941164f, 162.48691f);
generalPath.lineTo(3.0941164f, 204.94376f);
generalPath.lineTo(73.99853f, 204.94376f);
generalPath.lineTo(73.99853f, 113.2193f);
generalPath.lineTo(73.99853f, 95.70585f);
generalPath.lineTo(73.99853f, 3.9813843f);
generalPath.lineTo(3.0941162f, 3.9813843f);
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
generalPath.moveTo(3.0941164f, 3.9813657f);
generalPath.lineTo(3.0941164f, 46.4382f);
generalPath.lineTo(3.0941164f, 162.48691f);
generalPath.lineTo(3.0941164f, 204.94376f);
generalPath.lineTo(73.99853f, 204.94376f);
generalPath.lineTo(73.99853f, 113.2193f);
generalPath.lineTo(73.99853f, 95.70585f);
generalPath.lineTo(73.99853f, 3.9813843f);
generalPath.lineTo(3.0941162f, 3.9813843f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(4.679559f, 2.9740276f);
generalPath.lineTo(4.679559f, 45.828674f);
generalPath.lineTo(4.679559f, 162.96472f);
generalPath.lineTo(4.679559f, 205.81937f);
generalPath.lineTo(76.24832f, 205.81937f);
generalPath.lineTo(76.24832f, 113.23549f);
generalPath.lineTo(76.24832f, 95.55793f);
generalPath.lineTo(76.24832f, 2.9740448f);
generalPath.lineTo(4.679558f, 2.9740448f);
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
generalPath.moveTo(4.679559f, 2.9740276f);
generalPath.lineTo(4.679559f, 45.828674f);
generalPath.lineTo(4.679559f, 162.96472f);
generalPath.lineTo(4.679559f, 205.81937f);
generalPath.lineTo(76.24832f, 205.81937f);
generalPath.lineTo(76.24832f, 113.23549f);
generalPath.lineTo(76.24832f, 95.55793f);
generalPath.lineTo(76.24832f, 2.9740448f);
generalPath.lineTo(4.679558f, 2.9740448f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.8200885653495789f, 0.0f, 0.0f, 0.8374932408332825f, -6.837552547454834f, 13.086779594421387f));
// _0_0_3
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3_0
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
// _0_0_3_1
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
// _0_0_4
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
g.transform(new AffineTransform(1.6121793985366821f, 0.0f, 0.0f, 0.4258544147014618f, 330.9063720703125f, 174.66783142089844f));
// _0_0_5
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5_0
shape = new Rectangle2D.Double(-186.7389678955078, 11.896512985229492, 0.9807788133621216, 37.023963928222656);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.1355733f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-186.7389678955078, 11.896512985229492, 0.9807788133621216, 37.023963928222656);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5_1
shape = new Rectangle2D.Double(-189.53216552734375, 11.928726196289062, 2.138154983520508, 36.959537506103516);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-189.53216552734375, 11.928726196289062, 2.138154983520508, 36.959537506103516);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5_2
shape = new Rectangle2D.Double(-196.3284454345703, 11.928726196289062, 2.138154983520508, 36.959537506103516);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-196.3284454345703, 11.928726196289062, 2.138154983520508, 36.959537506103516);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5_3
shape = new Rectangle2D.Double(-199.15386962890625, 11.928726196289062, 2.138154983520508, 36.959537506103516);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-199.15386962890625, 11.928726196289062, 2.138154983520508, 36.959537506103516);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5_4
shape = new Rectangle2D.Double(-178.72088623046875, 11.896512985229492, 0.9807788133621216, 37.023963928222656);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.1355733f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-178.72088623046875, 11.896512985229492, 0.9807788133621216, 37.023963928222656);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5_5
shape = new Rectangle2D.Double(-172.99368286132812, 11.896512985229492, 0.9807788133621216, 37.023963928222656);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.1355733f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-172.99368286132812, 11.896512985229492, 0.9807788133621216, 37.023963928222656);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5_6
shape = new Rectangle2D.Double(-175.78688049316406, 11.928726196289062, 2.138154983520508, 36.959537506103516);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-175.78688049316406, 11.928726196289062, 2.138154983520508, 36.959537506103516);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5_7
shape = new Rectangle2D.Double(-182.58316040039062, 11.928726196289062, 2.138154983520508, 36.959537506103516);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-182.58316040039062, 11.928726196289062, 2.138154983520508, 36.959537506103516);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5_8
shape = new Rectangle2D.Double(-185.40858459472656, 11.928726196289062, 2.138154983520508, 36.959537506103516);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-185.40858459472656, 11.928726196289062, 2.138154983520508, 36.959537506103516);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5_9
shape = new Rectangle2D.Double(-164.97560119628906, 11.896512985229492, 0.9807788133621216, 37.023963928222656);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.1355733f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-164.97560119628906, 11.896512985229492, 0.9807788133621216, 37.023963928222656);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6
shape = new Rectangle2D.Double(-71.12432098388672, 179.7340087890625, 1.5811914205551147, 15.76681900024414);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.11233405f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-71.12432098388672, 179.7340087890625, 1.5811914205551147, 15.76681900024414);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
shape = new Rectangle2D.Double(-58.19773483276367, 179.7340087890625, 1.5811914205551147, 15.76681900024414);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.11233405f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-58.19773483276367, 179.7340087890625, 1.5811914205551147, 15.76681900024414);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.8931164741516113f, 0.0f, 0.0f, 1.119674801826477f, 0.0f, 0.0f));
// _0_0_8
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
generalPathText.moveTo(44.638485f, 147.2701f);
generalPathText.lineTo(44.638485f, 140.03564f);
generalPathText.lineTo(49.869392f, 140.03564f);
generalPathText.lineTo(49.869392f, 140.88773f);
generalPathText.lineTo(45.59584f, 140.88773f);
generalPathText.lineTo(45.59584f, 143.1051f);
generalPathText.lineTo(49.599625f, 143.1051f);
generalPathText.lineTo(49.599625f, 143.9539f);
generalPathText.lineTo(45.59584f, 143.9539f);
generalPathText.lineTo(45.59584f, 146.41473f);
generalPathText.lineTo(50.037178f, 146.41473f);
generalPathText.lineTo(50.037178f, 147.2701f);
generalPathText.lineTo(44.638485f, 147.2701f);
generalPathText.closePath();
generalPathText.moveTo(51.320232f, 147.2701f);
generalPathText.lineTo(51.320232f, 140.03564f);
generalPathText.lineTo(52.277588f, 140.03564f);
generalPathText.lineTo(52.277588f, 146.41473f);
generalPathText.lineTo(55.84053f, 146.41473f);
generalPathText.lineTo(55.84053f, 147.2701f);
generalPathText.lineTo(51.320232f, 147.2701f);
generalPathText.closePath();
generalPathText.moveTo(56.94099f, 147.2701f);
generalPathText.lineTo(56.94099f, 140.03564f);
generalPathText.lineTo(59.655144f, 140.03564f);
generalPathText.quadTo(60.48419f, 140.03564f, 60.984253f, 140.25607f);
generalPathText.quadTo(61.487606f, 140.4732f, 61.770535f, 140.9305f);
generalPathText.quadTo(62.053467f, 141.38779f, 62.053467f, 141.88457f);
generalPathText.quadTo(62.053467f, 142.34843f, 61.800144f, 142.75967f);
generalPathText.quadTo(61.550114f, 143.16762f, 61.043472f, 143.42093f);
generalPathText.quadTo(61.69816f, 143.61176f, 62.050175f, 144.07562f);
generalPathText.quadTo(62.405483f, 144.53949f, 62.405483f, 145.17116f);
generalPathText.quadTo(62.405483f, 145.68108f, 62.18835f, 146.11864f);
generalPathText.quadTo(61.97451f, 146.5529f, 61.65868f, 146.78978f);
generalPathText.quadTo(61.34285f, 147.02664f, 60.865818f, 147.14838f);
generalPathText.quadTo(60.392075f, 147.2701f, 59.701202f, 147.2701f);
generalPathText.lineTo(56.94099f, 147.2701f);
generalPathText.closePath();
generalPathText.moveTo(57.898346f, 143.0755f);
generalPathText.lineTo(59.46433f, 143.0755f);
generalPathText.quadTo(60.099277f, 143.0755f, 60.375626f, 142.98996f);
generalPathText.quadTo(60.740803f, 142.8814f, 60.925037f, 142.63136f);
generalPathText.quadTo(61.11256f, 142.37804f, 61.11256f, 141.99971f);
generalPathText.quadTo(61.11256f, 141.63782f, 60.938194f, 141.36476f);
generalPathText.quadTo(60.76712f, 141.0917f, 60.444714f, 140.98972f);
generalPathText.quadTo(60.125595f, 140.88773f, 59.345894f, 140.88773f);
generalPathText.lineTo(57.898346f, 140.88773f);
generalPathText.lineTo(57.898346f, 143.0755f);
generalPathText.closePath();
generalPathText.moveTo(57.898346f, 146.41473f);
generalPathText.lineTo(59.701202f, 146.41473f);
generalPathText.quadTo(60.165073f, 146.41473f, 60.352596f, 146.38182f);
generalPathText.quadTo(60.681583f, 146.32262f, 60.902008f, 146.18443f);
generalPathText.quadTo(61.12572f, 146.04626f, 61.267185f, 145.78307f);
generalPathText.quadTo(61.411938f, 145.51659f, 61.411938f, 145.17116f);
generalPathText.quadTo(61.411938f, 144.7665f, 61.204678f, 144.47041f);
generalPathText.quadTo(60.997414f, 144.17102f, 60.62895f, 144.0493f);
generalPathText.quadTo(60.26377f, 143.92758f, 59.572895f, 143.92758f);
generalPathText.lineTo(57.898346f, 143.92758f);
generalPathText.lineTo(57.898346f, 146.41473f);
generalPathText.closePath();
generalPathText.moveTo(63.36284f, 143.70058f);
generalPathText.quadTo(63.36284f, 142.41753f, 63.62603f, 141.63782f);
generalPathText.quadTo(63.88922f, 140.85483f, 64.40902f, 140.43044f);
generalPathText.quadTo(64.93211f, 140.00604f, 65.72169f, 140.00604f);
generalPathText.quadTo(66.30399f, 140.00604f, 66.74155f, 140.23962f);
generalPathText.quadTo(67.18239f, 140.4732f, 67.46861f, 140.91734f);
generalPathText.quadTo(67.75483f, 141.35818f, 67.91603f, 141.99313f);
generalPathText.quadTo(68.08053f, 142.62479f, 68.08053f, 143.70058f);
generalPathText.quadTo(68.08053f, 144.97375f, 67.81734f, 145.75674f);
generalPathText.quadTo(67.557434f, 146.53975f, 67.03435f, 146.96742f);
generalPathText.quadTo(66.51454f, 147.39511f, 65.72169f, 147.39511f);
generalPathText.quadTo(64.6755f, 147.39511f, 64.076744f, 146.64172f);
generalPathText.quadTo(63.36284f, 145.7403f, 63.36284f, 143.70058f);
generalPathText.closePath();
generalPathText.moveTo(64.27414f, 143.70058f);
generalPathText.quadTo(64.27414f, 145.48369f, 64.69195f, 146.07259f);
generalPathText.quadTo(65.109764f, 146.66147f, 65.72169f, 146.66147f);
generalPathText.quadTo(66.3336f, 146.66147f, 66.74812f, 146.06929f);
generalPathText.quadTo(67.16594f, 145.47711f, 67.16594f, 143.70058f);
generalPathText.quadTo(67.16594f, 141.91417f, 66.74812f, 141.32857f);
generalPathText.quadTo(66.3336f, 140.73969f, 65.711815f, 140.73969f);
generalPathText.quadTo(65.0999f, 140.73969f, 64.73472f, 141.25949f);
generalPathText.quadTo(64.27414f, 141.92075f, 64.27414f, 143.70058f);
generalPathText.closePath();
generalPathText.moveTo(68.983604f, 143.70058f);
generalPathText.quadTo(68.983604f, 142.41753f, 69.246796f, 141.63782f);
generalPathText.quadTo(69.50999f, 140.85483f, 70.029785f, 140.43044f);
generalPathText.quadTo(70.55288f, 140.00604f, 71.34245f, 140.00604f);
generalPathText.quadTo(71.92476f, 140.00604f, 72.36231f, 140.23962f);
generalPathText.quadTo(72.803154f, 140.4732f, 73.08938f, 140.91734f);
generalPathText.quadTo(73.375595f, 141.35818f, 73.5368f, 141.99313f);
generalPathText.quadTo(73.701294f, 142.62479f, 73.701294f, 143.70058f);
generalPathText.quadTo(73.701294f, 144.97375f, 73.4381f, 145.75674f);
generalPathText.quadTo(73.1782f, 146.53975f, 72.65511f, 146.96742f);
generalPathText.quadTo(72.13531f, 147.39511f, 71.34245f, 147.39511f);
generalPathText.quadTo(70.296265f, 147.39511f, 69.69751f, 146.64172f);
generalPathText.quadTo(68.983604f, 145.7403f, 68.983604f, 143.70058f);
generalPathText.closePath();
generalPathText.moveTo(69.894905f, 143.70058f);
generalPathText.quadTo(69.894905f, 145.48369f, 70.31271f, 146.07259f);
generalPathText.quadTo(70.73053f, 146.66147f, 71.34245f, 146.66147f);
generalPathText.quadTo(71.95437f, 146.66147f, 72.36889f, 146.06929f);
generalPathText.quadTo(72.786705f, 145.47711f, 72.786705f, 143.70058f);
generalPathText.quadTo(72.786705f, 141.91417f, 72.36889f, 141.32857f);
generalPathText.quadTo(71.95437f, 140.73969f, 71.33258f, 140.73969f);
generalPathText.quadTo(70.720665f, 140.73969f, 70.355484f, 141.25949f);
generalPathText.quadTo(69.894905f, 141.92075f, 69.894905f, 143.70058f);
generalPathText.closePath();
generalPathText.moveTo(74.735954f, 145.59555f);
generalPathText.lineTo(75.591324f, 145.51659f);
generalPathText.quadTo(75.69989f, 146.11864f, 76.00585f, 146.3917f);
generalPathText.quadTo(76.31181f, 146.66147f, 76.78884f, 146.66147f);
generalPathText.quadTo(77.20008f, 146.66147f, 77.506035f, 146.47394f);
generalPathText.quadTo(77.815285f, 146.28642f, 78.01268f, 145.97388f);
generalPathText.quadTo(78.210075f, 145.66135f, 78.34167f, 145.12839f);
generalPathText.quadTo(78.476555f, 144.59543f, 78.476555f, 144.04272f);
generalPathText.quadTo(78.476555f, 143.9835f, 78.47326f, 143.86507f);
generalPathText.quadTo(78.20678f, 144.28946f, 77.74291f, 144.55266f);
generalPathText.quadTo(77.282326f, 144.81584f, 76.74608f, 144.81584f);
generalPathText.quadTo(75.84794f, 144.81584f, 75.22615f, 144.16444f);
generalPathText.quadTo(74.60436f, 143.51305f, 74.60436f, 142.44713f);
generalPathText.quadTo(74.60436f, 141.34831f, 75.25247f, 140.67717f);
generalPathText.quadTo(75.90057f, 140.00604f, 76.87767f, 140.00604f);
generalPathText.quadTo(77.58499f, 140.00604f, 78.167305f, 140.38766f);
generalPathText.quadTo(78.7529f, 140.766f, 79.05557f, 141.47003f);
generalPathText.quadTo(79.361534f, 142.17078f, 79.361534f, 143.50319f);
generalPathText.quadTo(79.361534f, 144.89151f, 79.05886f, 145.71399f);
generalPathText.quadTo(78.75948f, 146.53316f, 78.16402f, 146.96414f);
generalPathText.quadTo(77.56854f, 147.39511f, 76.769104f, 147.39511f);
generalPathText.quadTo(75.92032f, 147.39511f, 75.380775f, 146.92465f);
generalPathText.quadTo(74.84452f, 146.45091f, 74.735954f, 145.59555f);
generalPathText.closePath();
generalPathText.moveTo(78.374565f, 142.40436f);
generalPathText.quadTo(78.374565f, 141.63782f, 77.96662f, 141.1904f);
generalPathText.quadTo(77.55868f, 140.73969f, 76.98624f, 140.73969f);
generalPathText.quadTo(76.39406f, 140.73969f, 75.95322f, 141.2233f);
generalPathText.quadTo(75.51566f, 141.70691f, 75.51566f, 142.47675f);
generalPathText.quadTo(75.51566f, 143.16762f, 75.93347f, 143.60188f);
generalPathText.quadTo(76.35129f, 144.03285f, 76.96321f, 144.03285f);
generalPathText.quadTo(77.578415f, 144.03285f, 77.976494f, 143.60188f);
generalPathText.quadTo(78.374565f, 143.16762f, 78.374565f, 142.40436f);
generalPathText.closePath();
generalPathText.moveTo(80.22512f, 143.70058f);
generalPathText.quadTo(80.22512f, 142.41753f, 80.48831f, 141.63782f);
generalPathText.quadTo(80.7515f, 140.85483f, 81.2713f, 140.43044f);
generalPathText.quadTo(81.794395f, 140.00604f, 82.58397f, 140.00604f);
generalPathText.quadTo(83.166275f, 140.00604f, 83.60383f, 140.23962f);
generalPathText.quadTo(84.04467f, 140.4732f, 84.330894f, 140.91734f);
generalPathText.quadTo(84.61711f, 141.35818f, 84.77831f, 141.99313f);
generalPathText.quadTo(84.94281f, 142.62479f, 84.94281f, 143.70058f);
generalPathText.quadTo(84.94281f, 144.97375f, 84.67962f, 145.75674f);
generalPathText.quadTo(84.419716f, 146.53975f, 83.89663f, 146.96742f);
generalPathText.quadTo(83.37682f, 147.39511f, 82.58397f, 147.39511f);
generalPathText.quadTo(81.53778f, 147.39511f, 80.939026f, 146.64172f);
generalPathText.quadTo(80.22512f, 145.7403f, 80.22512f, 143.70058f);
generalPathText.closePath();
generalPathText.moveTo(81.13642f, 143.70058f);
generalPathText.quadTo(81.13642f, 145.48369f, 81.55423f, 146.07259f);
generalPathText.quadTo(81.972046f, 146.66147f, 82.58397f, 146.66147f);
generalPathText.quadTo(83.195885f, 146.66147f, 83.610405f, 146.06929f);
generalPathText.quadTo(84.02822f, 145.47711f, 84.02822f, 143.70058f);
generalPathText.quadTo(84.02822f, 141.91417f, 83.610405f, 141.32857f);
generalPathText.quadTo(83.195885f, 140.73969f, 82.5741f, 140.73969f);
generalPathText.quadTo(81.96218f, 140.73969f, 81.597f, 141.25949f);
generalPathText.quadTo(81.13642f, 141.92075f, 81.13642f, 143.70058f);
generalPathText.closePath();
generalPathText.moveTo(85.74719f, 145.09877f);
generalPathText.lineTo(85.74719f, 144.20393f);
generalPathText.lineTo(88.4745f, 144.20393f);
generalPathText.lineTo(88.4745f, 145.09877f);
generalPathText.lineTo(85.74719f, 145.09877f);
generalPathText.closePath();
generalPathText.moveTo(89.21143f, 143.70058f);
generalPathText.quadTo(89.21143f, 142.41753f, 89.474625f, 141.63782f);
generalPathText.quadTo(89.737816f, 140.85483f, 90.257614f, 140.43044f);
generalPathText.quadTo(90.78071f, 140.00604f, 91.57028f, 140.00604f);
generalPathText.quadTo(92.15259f, 140.00604f, 92.59014f, 140.23962f);
generalPathText.quadTo(93.03098f, 140.4732f, 93.31721f, 140.91734f);
generalPathText.quadTo(93.603424f, 141.35818f, 93.764626f, 141.99313f);
generalPathText.quadTo(93.92912f, 142.62479f, 93.92912f, 143.70058f);
generalPathText.quadTo(93.92912f, 144.97375f, 93.66593f, 145.75674f);
generalPathText.quadTo(93.40603f, 146.53975f, 92.88294f, 146.96742f);
generalPathText.quadTo(92.36314f, 147.39511f, 91.57028f, 147.39511f);
generalPathText.quadTo(90.52409f, 147.39511f, 89.92534f, 146.64172f);
generalPathText.quadTo(89.21143f, 145.7403f, 89.21143f, 143.70058f);
generalPathText.closePath();
generalPathText.moveTo(90.122734f, 143.70058f);
generalPathText.quadTo(90.122734f, 145.48369f, 90.54054f, 146.07259f);
generalPathText.quadTo(90.95836f, 146.66147f, 91.57028f, 146.66147f);
generalPathText.quadTo(92.1822f, 146.66147f, 92.59672f, 146.06929f);
generalPathText.quadTo(93.014534f, 145.47711f, 93.014534f, 143.70058f);
generalPathText.quadTo(93.014534f, 141.91417f, 92.59672f, 141.32857f);
generalPathText.quadTo(92.1822f, 140.73969f, 91.56041f, 140.73969f);
generalPathText.quadTo(90.948494f, 140.73969f, 90.58331f, 141.25949f);
generalPathText.quadTo(90.122734f, 141.92075f, 90.122734f, 143.70058f);
generalPathText.closePath();
generalPathText.moveTo(94.83219f, 143.70058f);
generalPathText.quadTo(94.83219f, 142.41753f, 95.09538f, 141.63782f);
generalPathText.quadTo(95.358574f, 140.85483f, 95.87837f, 140.43044f);
generalPathText.quadTo(96.40147f, 140.00604f, 97.19104f, 140.00604f);
generalPathText.quadTo(97.773346f, 140.00604f, 98.2109f, 140.23962f);
generalPathText.quadTo(98.65174f, 140.4732f, 98.937965f, 140.91734f);
generalPathText.quadTo(99.22418f, 141.35818f, 99.38538f, 141.99313f);
generalPathText.quadTo(99.54988f, 142.62479f, 99.54988f, 143.70058f);
generalPathText.quadTo(99.54988f, 144.97375f, 99.28669f, 145.75674f);
generalPathText.quadTo(99.02679f, 146.53975f, 98.5037f, 146.96742f);
generalPathText.quadTo(97.983894f, 147.39511f, 97.19104f, 147.39511f);
generalPathText.quadTo(96.14485f, 147.39511f, 95.5461f, 146.64172f);
generalPathText.quadTo(94.83219f, 145.7403f, 94.83219f, 143.70058f);
generalPathText.closePath();
generalPathText.moveTo(95.74349f, 143.70058f);
generalPathText.quadTo(95.74349f, 145.48369f, 96.1613f, 146.07259f);
generalPathText.quadTo(96.57912f, 146.66147f, 97.19104f, 146.66147f);
generalPathText.quadTo(97.802956f, 146.66147f, 98.217476f, 146.06929f);
generalPathText.quadTo(98.63529f, 145.47711f, 98.63529f, 143.70058f);
generalPathText.quadTo(98.63529f, 141.91417f, 98.217476f, 141.32857f);
generalPathText.quadTo(97.802956f, 140.73969f, 97.18117f, 140.73969f);
generalPathText.quadTo(96.56925f, 140.73969f, 96.20407f, 141.25949f);
generalPathText.quadTo(95.74349f, 141.92075f, 95.74349f, 143.70058f);
generalPathText.closePath();
generalPathText.moveTo(100.45296f, 143.70058f);
generalPathText.quadTo(100.45296f, 142.41753f, 100.71615f, 141.63782f);
generalPathText.quadTo(100.97934f, 140.85483f, 101.49914f, 140.43044f);
generalPathText.quadTo(102.02223f, 140.00604f, 102.811806f, 140.00604f);
generalPathText.quadTo(103.39411f, 140.00604f, 103.831665f, 140.23962f);
generalPathText.quadTo(104.27251f, 140.4732f, 104.55873f, 140.91734f);
generalPathText.quadTo(104.84495f, 141.35818f, 105.00615f, 141.99313f);
generalPathText.quadTo(105.17065f, 142.62479f, 105.17065f, 143.70058f);
generalPathText.quadTo(105.17065f, 144.97375f, 104.907455f, 145.75674f);
generalPathText.quadTo(104.64755f, 146.53975f, 104.124466f, 146.96742f);
generalPathText.quadTo(103.60466f, 147.39511f, 102.811806f, 147.39511f);
generalPathText.quadTo(101.76562f, 147.39511f, 101.16686f, 146.64172f);
generalPathText.quadTo(100.45296f, 145.7403f, 100.45296f, 143.70058f);
generalPathText.closePath();
generalPathText.moveTo(101.36426f, 143.70058f);
generalPathText.quadTo(101.36426f, 145.48369f, 101.78207f, 146.07259f);
generalPathText.quadTo(102.19988f, 146.66147f, 102.811806f, 146.66147f);
generalPathText.quadTo(103.42372f, 146.66147f, 103.83824f, 146.06929f);
generalPathText.quadTo(104.25606f, 145.47711f, 104.25606f, 143.70058f);
generalPathText.quadTo(104.25606f, 141.91417f, 103.83824f, 141.32857f);
generalPathText.quadTo(103.42372f, 140.73969f, 102.80193f, 140.73969f);
generalPathText.quadTo(102.19002f, 140.73969f, 101.82484f, 141.25949f);
generalPathText.quadTo(101.36426f, 141.92075f, 101.36426f, 143.70058f);
generalPathText.closePath();
generalPathText.moveTo(106.205315f, 145.59555f);
generalPathText.lineTo(107.060684f, 145.51659f);
generalPathText.quadTo(107.16925f, 146.11864f, 107.47521f, 146.3917f);
generalPathText.quadTo(107.78117f, 146.66147f, 108.2582f, 146.66147f);
generalPathText.quadTo(108.66944f, 146.66147f, 108.975395f, 146.47394f);
generalPathText.quadTo(109.284645f, 146.28642f, 109.48204f, 145.97388f);
generalPathText.quadTo(109.679436f, 145.66135f, 109.81103f, 145.12839f);
generalPathText.quadTo(109.945915f, 144.59543f, 109.945915f, 144.04272f);
generalPathText.quadTo(109.945915f, 143.9835f, 109.94262f, 143.86507f);
generalPathText.quadTo(109.67614f, 144.28946f, 109.21227f, 144.55266f);
generalPathText.quadTo(108.751686f, 144.81584f, 108.21544f, 144.81584f);
generalPathText.quadTo(107.3173f, 144.81584f, 106.69551f, 144.16444f);
generalPathText.quadTo(106.07372f, 143.51305f, 106.07372f, 142.44713f);
generalPathText.quadTo(106.07372f, 141.34831f, 106.72183f, 140.67717f);
generalPathText.quadTo(107.369934f, 140.00604f, 108.34703f, 140.00604f);
generalPathText.quadTo(109.05435f, 140.00604f, 109.636665f, 140.38766f);
generalPathText.quadTo(110.22226f, 140.766f, 110.52493f, 141.47003f);
generalPathText.quadTo(110.830894f, 142.17078f, 110.830894f, 143.50319f);
generalPathText.quadTo(110.830894f, 144.89151f, 110.52822f, 145.71399f);
generalPathText.quadTo(110.22884f, 146.53316f, 109.63338f, 146.96414f);
generalPathText.quadTo(109.0379f, 147.39511f, 108.238464f, 147.39511f);
generalPathText.quadTo(107.38968f, 147.39511f, 106.850136f, 146.92465f);
generalPathText.quadTo(106.31388f, 146.45091f, 106.205315f, 145.59555f);
generalPathText.closePath();
generalPathText.moveTo(109.843925f, 142.40436f);
generalPathText.quadTo(109.843925f, 141.63782f, 109.43598f, 141.1904f);
generalPathText.quadTo(109.02804f, 140.73969f, 108.4556f, 140.73969f);
generalPathText.quadTo(107.86342f, 140.73969f, 107.42258f, 141.2233f);
generalPathText.quadTo(106.98502f, 141.70691f, 106.98502f, 142.47675f);
generalPathText.quadTo(106.98502f, 143.16762f, 107.40283f, 143.60188f);
generalPathText.quadTo(107.82065f, 144.03285f, 108.43257f, 144.03285f);
generalPathText.quadTo(109.047775f, 144.03285f, 109.445854f, 143.60188f);
generalPathText.quadTo(109.843925f, 143.16762f, 109.843925f, 142.40436f);
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
// _0_0_9
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9_0
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
// _0_0_9_1
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
generalPath.curveTo(39.9375f, 123.37108f, 31.292854f, 120.93242f, 37.65625f, 116.6875f);
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
// _0_0_10
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10_0
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
// _0_0_10_1
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
g.setComposite(AlphaComposite.getInstance(3, 0.8f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_11
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
// _0_0_12
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
        return -3.7715969938290073E-6;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 7.07259005139349E-7;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 245.0196533203125;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 104.52823638916016;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private slidepreview3() {
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
       slidepreview3 base = new slidepreview3();
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
       slidepreview3 base = new slidepreview3();
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
        return slidepreview3::new;
    }
}

