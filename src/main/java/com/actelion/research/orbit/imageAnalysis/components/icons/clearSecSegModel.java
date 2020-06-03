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
public class clearSecSegModel implements ResizableIcon {
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
shape = new Ellipse2D.Double(11.08454418182373, 12.250814437866211, 26.4830379486084, 25.968341827392578);
paint = new Color(0, 0, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 255, 255);
stroke = new BasicStroke(18.550095f,1,2,4.0f,null,0.0f);
shape = new Ellipse2D.Double(11.08454418182373, 12.250814437866211, 26.4830379486084, 25.968341827392578);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
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
generalPath.moveTo(9.083134f, 1.5812496f);
generalPath.curveTo(10.764031f, 0.73159695f, 13.092472f, 1.5846325f, 13.953305f, 3.0881877f);
generalPath.lineTo(18.005705f, 12.266054f);
generalPath.curveTo(18.866537f, 13.769606f, 18.621222f, 15.526355f, 17.45567f, 16.20495f);
generalPath.curveTo(16.290117f, 16.883545f, 14.658767f, 16.219406f, 13.797934f, 14.715854f);
generalPath.lineTo(8.046709f, 6.63045f);
generalPath.curveTo(7.1858764f, 5.1268945f, 7.435487f, 2.4140947f, 9.083134f, 1.5812496f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(12.23343276977539, 12.3632230758667), new Point2D.Double(16.870908737182617, 17.11094093322754), new float[] {0.0f,1.0f}, new Color[] {new Color(193, 125, 16, 255),new Color(155, 101, 12, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9386315941810608f, 0.25362253189086914f, -0.2515054941177368f, 0.9465312361717224f, 5.235770225524902f, -5.886826515197754f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(143, 89, 2, 255);
stroke = new BasicStroke(0.9758228f,1,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(9.083134f, 1.5812496f);
generalPath.curveTo(10.764031f, 0.73159695f, 13.092472f, 1.5846325f, 13.953305f, 3.0881877f);
generalPath.lineTo(18.005705f, 12.266054f);
generalPath.curveTo(18.866537f, 13.769606f, 18.621222f, 15.526355f, 17.45567f, 16.20495f);
generalPath.curveTo(16.290117f, 16.883545f, 14.658767f, 16.219406f, 13.797934f, 14.715854f);
generalPath.lineTo(8.046709f, 6.63045f);
generalPath.curveTo(7.1858764f, 5.1268945f, 7.435487f, 2.4140947f, 9.083134f, 1.5812496f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.4230769f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
paint = new LinearGradientPaint(new Point2D.Double(9.56215763092041, 6.952558994293213), new Point2D.Double(14.766724586486816, 14.200403213500977), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9717427492141724f, 0.0f, 0.0f, 0.9676482081413269f, 2.362257242202759f, -0.13924680650234222f));
stroke = new BasicStroke(0.9752113f,1,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(9.598116f, 2.508152f);
generalPath.curveTo(10.979889f, 1.7477548f, 12.339116f, 2.3216467f, 13.188996f, 3.8042076f);
generalPath.lineTo(17.511442f, 13.564609f);
generalPath.lineTo(15.148629f, 14.938536f);
generalPath.lineTo(9.029942f, 6.4035535f);
generalPath.curveTo(8.180062f, 4.920993f, 8.178455f, 3.2893984f, 9.598116f, 2.508152f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3
shape = new Ellipse2D.Double(28.295656204223633, 11.476043701171875, 9.105976104736328, 10.200495719909668);
paint = new Color(0, 255, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 255, 0, 255);
stroke = new BasicStroke(6.817325f,1,2,4.0f,null,0.0f);
shape = new Ellipse2D.Double(28.295656204223633, 11.476043701171875, 9.105976104736328, 10.200495719909668);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
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
generalPath.moveTo(16.72544f, 21.916908f);
generalPath.curveTo(15.952423f, 26.065056f, 17.341492f, 35.41802f, 22.807804f, 40.97377f);
generalPath.curveTo(27.03173f, 41.11049f, 36.402573f, 37.666656f, 42.758747f, 31.106623f);
generalPath.curveTo(33.78356f, 26.736036f, 27.661238f, 15.892312f, 22.900885f, 18.253668f);
generalPath.lineTo(16.72544f, 21.916908f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(20.764476776123047, 19.540945053100586), 14.799585f, new Point2D.Double(20.764476776123047, 19.540945053100586), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(254, 240, 136, 255),new Color(253, 230, 58, 255),new Color(218, 194, 3, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.436699241399765f, -0.20948809385299683f, 0.5484671592712402f, 1.1337131261825562f, 0.9704418182373047f, 2.3244895935058594f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(196, 160, 0, 255);
stroke = new BasicStroke(0.9696938f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(16.72544f, 21.916908f);
generalPath.curveTo(15.952423f, 26.065056f, 17.341492f, 35.41802f, 22.807804f, 40.97377f);
generalPath.curveTo(27.03173f, 41.11049f, 36.402573f, 37.666656f, 42.758747f, 31.106623f);
generalPath.curveTo(33.78356f, 26.736036f, 27.661238f, 15.892312f, 22.900885f, 18.253668f);
generalPath.lineTo(16.72544f, 21.916908f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5
shape = new Ellipse2D.Double(11.731539726257324, 16.043880462646484, 7.165430068969727, 10.79175090789795);
paint = new Color(0, 255, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 255, 0, 255);
stroke = new BasicStroke(6.2202406f,1,2,4.0f,null,0.0f);
shape = new Ellipse2D.Double(11.731539726257324, 16.043880462646484, 7.165430068969727, 10.79175090789795);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6
shape = new Ellipse2D.Double(18.168060302734375, 31.954301834106445, 7.165430068969727, 10.79175090789795);
paint = new Color(0, 255, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 255, 0, 255);
stroke = new BasicStroke(6.2202406f,1,2,4.0f,null,0.0f);
shape = new Ellipse2D.Double(18.168060302734375, 31.954301834106445, 7.165430068969727, 10.79175090789795);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.46153846f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(0.96969306f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(17.831217f, 22.517387f);
generalPath.curveTo(16.944897f, 23.009054f, 17.67537f, 34.63255f, 23.257675f, 39.935413f);
generalPath.curveTo(30.434954f, 39.754562f, 38.342735f, 33.746155f, 41.130894f, 31.383486f);
generalPath.curveTo(31.899904f, 25.59296f, 26.627825f, 17.099285f, 23.17232f, 19.216679f);
generalPath.lineTo(17.831217f, 22.517387f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8
paint = new LinearGradientPaint(new Point2D.Double(19.616243362426758, 39.25298309326172), new Point2D.Double(18.48598289489746, 29.90907096862793), new float[] {0.0f,1.0f}, new Color[] {new Color(196, 160, 0, 255),new Color(196, 160, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.8415544629096985f, -0.48382410407066345f, 0.7754127979278564f, 1.337396264076233f, -12.922614097595215f, -9.116602897644043f));
stroke = new BasicStroke(0.969693f,1,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(25.53685f, 21.413504f);
generalPath.curveTo(26.37873f, 20.688734f, 31.12439f, 27.304222f, 40.111534f, 33.39473f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9
paint = new LinearGradientPaint(new Point2D.Double(15.096997261047363, 36.967769622802734), new Point2D.Double(14.045431137084961, 29.0), new float[] {0.0f,1.0f}, new Color[] {new Color(196, 160, 0, 255),new Color(196, 160, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.8415544629096985f, -0.48382410407066345f, 0.819644570350647f, 1.4136836528778076f, -16.820459365844727f, -10.913265228271484f));
stroke = new BasicStroke(0.96969354f,1,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(19.866156f, 21.984985f);
generalPath.curveTo(23.473566f, 27.15948f, 22.74542f, 34.007294f, 28.457155f, 39.48114f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10
paint = new LinearGradientPaint(new Point2D.Double(14.045431137084961, 37.575889587402344), new Point2D.Double(14.045431137084961, 29.0), new float[] {0.0f,1.0f}, new Color[] {new Color(196, 160, 0, 255),new Color(196, 160, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.8415544629096985f, -0.48382410407066345f, 0.7786623239517212f, 1.34299898147583f, -10.093832015991211f, -10.923260688781738f));
stroke = new BasicStroke(0.96969354f,1,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(24.696693f, 21.899736f);
generalPath.curveTo(24.696693f, 21.899736f, 32.642372f, 34.548473f, 35.562656f, 36.515636f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_11
paint = new LinearGradientPaint(new Point2D.Double(16.928730010986328, 34.010501861572266), new Point2D.Double(14.045431137084961, 29.0), new float[] {0.0f,1.0f}, new Color[] {new Color(196, 160, 0, 255),new Color(196, 160, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.8415544629096985f, -0.48382410407066345f, 0.8371437788009644f, 1.4438666105270386f, -15.012025833129883f, -13.600055694580078f));
stroke = new BasicStroke(0.9696934f,1,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(21.117191f, 21.343216f);
generalPath.curveTo(24.46693f, 24.165667f, 29.57384f, 35.0482f, 32.107616f, 38.25553f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
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
generalPath.moveTo(8.869056f, 15.603383f);
generalPath.lineTo(21.8035f, 8.34554f);
generalPath.curveTo(22.479073f, 10.982006f, 21.417734f, 11.931452f, 23.830221f, 16.254934f);
generalPath.lineTo(14.903493f, 21.263948f);
generalPath.curveTo(13.263305f, 17.415962f, 10.880534f, 17.490236f, 8.869056f, 15.603383f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(11.9966459274292, 19.59173583984375), new Point2D.Double(17.774032592773438, 16.234594345092773), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(218, 194, 3, 255),new Color(253, 236, 105, 255),new Color(253, 239, 126, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.1452999114990234f, 0.0f, 0.0f, 1.1131139993667603f, -1.107569932937622f, -4.5383381843566895f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(196, 160, 0, 255);
stroke = new BasicStroke(1.1290921f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(8.869056f, 15.603383f);
generalPath.lineTo(21.8035f, 8.34554f);
generalPath.curveTo(22.479073f, 10.982006f, 21.417734f, 11.931452f, 23.830221f, 16.254934f);
generalPath.lineTo(14.903493f, 21.263948f);
generalPath.curveTo(13.263305f, 17.415962f, 10.880534f, 17.490236f, 8.869056f, 15.603383f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.2472527f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_13
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(1.1174755f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(15.200609f, 19.38307f);
generalPath.curveTo(14.282058f, 17.810406f, 12.30905f, 16.908417f, 11.048514f, 15.922595f);
generalPath.lineTo(20.931225f, 10.463102f);
generalPath.curveTo(20.909115f, 12.101887f, 21.570974f, 13.880397f, 21.919348f, 15.463292f);
generalPath.lineTo(15.200609f, 19.38307f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.8702220916748047f, -0.49265962839126587f, 0.5073771476745605f, 0.8617241382598877f, 0.0f, 0.0f));
// _0_0_14
shape = new RoundRectangle2D.Double(-0.05050160735845566, 22.973888397216797, 14.616555213928223, 3.847700357437134, 2.2460994720458984, 2.224170446395874);
paint = new LinearGradientPaint(new Point2D.Double(10.615303993225098, 28.122554779052734), new Point2D.Double(2.006974697113037, 27.234832763671875), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(179, 0, 0, 255),new Color(255, 92, 92, 255),new Color(195, 0, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.3214961290359497f, 0.0f, 0.0f, 1.3085954189300537f, 0.6154866814613342f, -9.812482833862305f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(105, 0, 0, 255);
stroke = new BasicStroke(1.117554f,1,0,4.0f,null,0.0f);
shape = new RoundRectangle2D.Double(-0.05050160735845566, 22.973888397216797, 14.616555213928223, 3.847700357437134, 2.2460994720458984, 2.224170446395874);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9671733975410461f, 0.25411731004714966f, -0.26359623670578003f, 0.9646331071853638f, 0.0f, 0.0f));
// _0_0_15
shape = new Ellipse2D.Double(10.157252311706543, 0.22307610511779785, 2.9231739044189453, 2.873910665512085);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(143, 89, 2, 255);
stroke = new BasicStroke(1.1175048f,1,1,4.0f,null,0.0f);
shape = new Ellipse2D.Double(10.157252311706543, 0.22307610511779785, 2.9231739044189453, 2.873910665512085);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.3173077f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_16
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(29.313381f, 39.10396f);
generalPath.curveTo(29.313381f, 39.10396f, 30.777393f, 38.619507f, 31.427988f, 38.19267f);
generalPath.curveTo(30.22552f, 36.311035f, 28.120817f, 32.48774f, 26.177542f, 29.603903f);
generalPath.curveTo(27.337067f, 35.933037f, 29.313381f, 39.10396f, 29.313381f, 39.10396f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.3173077f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(32.62408f, 37.65542f);
generalPath.lineTo(34.59283f, 36.605354f);
generalPath.curveTo(32.70323f, 34.80925f, 27.335373f, 26.816725f, 27.335373f, 26.816725f);
generalPath.lineTo(32.62408f, 37.65542f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.3173077f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_18
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.01317f, 35.07135f);
generalPath.lineTo(39.380695f, 33.384014f);
generalPath.curveTo(36.288628f, 32.10108f, 28.121557f, 23.823214f, 28.121557f, 23.823214f);
generalPath.curveTo(30.437157f, 26.737669f, 34.697567f, 32.1569f, 37.01317f, 35.07135f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.3173077f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_19
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(40.409573f, 32.68068f);
generalPath.lineTo(42.054066f, 31.31677f);
generalPath.curveTo(38.83316f, 29.862782f, 29.911482f, 21.725426f, 29.911482f, 21.725426f);
generalPath.curveTo(29.911482f, 21.725426f, 35.814415f, 30.627987f, 40.409573f, 32.68068f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.31730765f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_20
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(26.049534f, 40.08754f);
generalPath.curveTo(26.049534f, 40.08754f, 27.212929f, 39.81691f, 28.035305f, 39.64666f);
generalPath.curveTo(26.618107f, 38.449257f, 24.341623f, 35.35296f, 23.085474f, 31.31448f);
generalPath.curveTo(23.600819f, 37.98573f, 26.049534f, 40.08754f, 26.049534f, 40.08754f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
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
        return 1.8094968795776367;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 0.1688968986272812;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 45.03313446044922;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 47.3253059387207;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private clearSecSegModel() {
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
       clearSecSegModel base = new clearSecSegModel();
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
       clearSecSegModel base = new clearSecSegModel();
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
        return clearSecSegModel::new;
    }
}

