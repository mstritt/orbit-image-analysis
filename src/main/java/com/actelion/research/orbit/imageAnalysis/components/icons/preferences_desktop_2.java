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
public class preferences_desktop_2 implements ResizableIcon {
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
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -0.75f, 0.0f));
// _0_0_0
g.setComposite(AlphaComposite.getInstance(3, 0.85294116f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0
shape = new Rectangle2D.Double(8.344184875488281, 31.66289710998535, 32.36289596557617, 11.482156753540039);
paint = new LinearGradientPaint(new Point2D.Double(302.8571472167969, 366.64788818359375), new Point2D.Double(302.8571472167969, 609.5050659179688), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(0, 0, 0, 0),new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.06702374666929245f, 0.0f, 0.0f, 0.047279469668865204f, 0.30133509635925293f, 14.327980041503906f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.85294116f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(40.70708f, 31.663294f);
generalPath.curveTo(40.70708f, 31.663294f, 40.70708f, 43.144817f, 40.70708f, 43.144817f);
generalPath.curveTo(44.158638f, 43.16643f, 49.05127f, 40.572388f, 49.051266f, 37.403316f);
generalPath.curveTo(49.051266f, 34.23424f, 45.19959f, 31.663294f, 40.70708f, 31.663294f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(605.7142944335938, 486.64788818359375), 117.14286f, new Point2D.Double(605.7142944335938, 486.64788818359375), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.06702374666929245f, 0.0f, 0.0f, 0.047279469668865204f, 0.31452539563179016f, 14.327980041503906f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.85294116f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(8.344186f, 31.663294f);
generalPath.curveTo(8.344186f, 31.663294f, 8.344186f, 43.144817f, 8.344186f, 43.144817f);
generalPath.curveTo(4.8926277f, 43.16643f, 2.6449978E-9f, 40.572388f, 2.6449978E-9f, 37.403316f);
generalPath.curveTo(2.6449978E-9f, 34.23424f, 3.8516777f, 31.663294f, 8.344186f, 31.663294f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(605.7142944335938, 486.64788818359375), 117.14286f, new Point2D.Double(605.7142944335938, 486.64788818359375), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-0.06702374666929245f, 0.0f, 0.0f, 0.047279469668865204f, 48.736751556396484f, 14.327980041503906f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
paint = new Color(136, 138, 133, 255);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(9.022859f, 9.0f);
generalPath.curveTo(8.395477f, 9.0f, 7.9876804f, 9.293946f, 7.7367287f, 9.854703f);
generalPath.curveTo(7.7367277f, 9.854703f, 3.2509522f, 29.876846f, 3.2509522f, 29.876846f);
generalPath.curveTo(3.2509522f, 29.876846f, 3.0f, 30.55712f, 3.0f, 31.681213f);
generalPath.curveTo(3.0f, 31.681213f, 3.0f, 37.404507f, 3.0f, 37.404507f);
generalPath.curveTo(3.0f, 38.50117f, 3.6602912f, 39.0506f, 4.6625605f, 39.050594f);
generalPath.lineTo(43.371986f, 39.050594f);
generalPath.curveTo(44.360588f, 39.050594f, 44.971806f, 38.323093f, 44.971806f, 37.18292f);
generalPath.lineTo(44.971806f, 31.459623f);
generalPath.curveTo(44.971806f, 31.459623f, 45.078175f, 30.679201f, 44.8777f, 30.13009f);
generalPath.lineTo(40.140972f, 10.012982f);
generalPath.curveTo(39.95574f, 9.494432f, 39.50164f, 9.012061f, 39.011684f, 9.0f);
generalPath.lineTo(9.022859f, 9.0f);
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
generalPath.moveTo(3.0f, 31.081251f);
generalPath.lineTo(3.7675865f, 30.389036f);
generalPath.lineTo(41.52408f, 30.451536f);
generalPath.lineTo(45.0f, 30.768835f);
generalPath.lineTo(45.0f, 37.207367f);
generalPath.curveTo(45.0f, 38.332935f, 44.390614f, 39.050697f, 43.401917f, 39.050697f);
generalPath.lineTo(4.668326f, 39.050697f);
generalPath.curveTo(3.6659644f, 39.050697f, 3.0f, 38.508648f, 3.0f, 37.426033f);
generalPath.lineTo(3.0f, 31.081251f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(7.604620456695557, 28.481176376342773), new Point2D.Double(36.183067321777344, 40.94393539428711), new float[] {0.0f,1.0f}, new Color[] {new Color(217, 217, 217, 255),new Color(199, 199, 199, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0039033889770508f, 0.0f, 0.0f, 1.0f, -0.2863698899745941f, 4.084438800811768f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(3.289293f, 29.978281f);
generalPath.curveTo(2.5728183f, 31.45515f, 3.2886763f, 32.3917f, 4.328183f, 32.3917f);
generalPath.curveTo(4.328183f, 32.3917f, 43.447746f, 32.3917f, 43.447746f, 32.3917f);
generalPath.curveTo(44.570225f, 32.367687f, 45.29864f, 31.3711f, 44.880695f, 30.230429f);
generalPath.lineTo(40.151955f, 10.008597f);
generalPath.curveTo(39.966866f, 9.492291f, 39.495186f, 9.012007f, 39.005596f, 9.0f);
generalPath.lineTo(9.056921f, 9.0f);
generalPath.curveTo(8.430004f, 9.0f, 8.018031f, 9.306182f, 7.767266f, 9.864512f);
generalPath.curveTo(7.767266f, 9.864512f, 3.289293f, 29.978281f, 3.289293f, 29.978281f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(15.571491241455078, 2.9585189819335938), 20.935818f, new Point2D.Double(15.571491241455078, 2.9585189819335938), new float[] {0.0f,1.0f}, new Color[] {new Color(240, 240, 240, 255),new Color(224, 224, 224, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.2901853322982788f, 0.7884153723716736f, -0.7129610776901245f, 1.1796022653579712f, -2.632237195968628f, -1.0775827169418335f));
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
generalPath.moveTo(44.85227f, 29.713127f);
generalPath.curveTo(44.916294f, 30.963102f, 44.435f, 32.02897f, 43.51973f, 32.056877f);
generalPath.curveTo(43.51973f, 32.056877f, 5.100482f, 32.056877f, 5.100482f, 32.056877f);
generalPath.curveTo(3.8010855f, 32.056877f, 3.2180204f, 31.731932f, 3.0f, 31.188822f);
generalPath.curveTo(3.0924845f, 32.133156f, 3.8323278f, 32.838127f, 5.100482f, 32.838127f);
generalPath.curveTo(5.100482f, 32.838127f, 43.51973f, 32.838127f, 43.51973f, 32.838127f);
generalPath.curveTo(44.60422f, 32.805058f, 45.286354f, 31.414104f, 44.882553f, 29.843336f);
generalPath.lineTo(44.85227f, 29.713127f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
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
generalPath.moveTo(10.981036f, 11.962093f);
generalPath.lineTo(16.007055f, 11.962093f);
generalPath.lineTo(14.592842f, 29.183918f);
generalPath.lineTo(8.152609f, 29.183918f);
generalPath.lineTo(10.981036f, 11.962093f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(12.513010025024414, 30.585786819458008), new Point2D.Double(12.513010025024414, 16.885591506958008), new float[] {0.0f,1.0f}, new Color[] {new Color(103, 117, 121, 255),new Color(51, 51, 51, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.5876039862632751f, -1.1402790546417236f, 9.808271408081055f));
g.setPaint(paint);
g.fill(shape);
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
generalPath.moveTo(36.397034f, 11.962093f);
generalPath.lineTo(31.371016f, 11.962093f);
generalPath.lineTo(32.78523f, 29.183918f);
generalPath.lineTo(39.225464f, 29.183918f);
generalPath.lineTo(36.397034f, 11.962093f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(12.513010025024414, 30.585786819458008), new Point2D.Double(12.513010025024414, 16.885591506958008), new float[] {0.0f,1.0f}, new Color[] {new Color(103, 117, 121, 255),new Color(51, 51, 51, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-1.0f, 0.0f, 0.0f, 0.5876039862632751f, 48.518348693847656f, 9.808271408081055f));
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
generalPath.moveTo(21.0f, 12.02602f);
generalPath.lineTo(26.026018f, 12.02602f);
generalPath.lineTo(26.963518f, 29.0f);
generalPath.lineTo(20.0625f, 29.0f);
generalPath.lineTo(21.0f, 12.02602f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(12.513010025024414, 30.585786819458008), new Point2D.Double(12.513010025024414, 23.635591506958008), new float[] {0.0f,1.0f}, new Color[] {new Color(103, 117, 121, 255),new Color(51, 51, 51, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 10.999998092651367f, -3.9739816188812256f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -1.0f, -2.0f));
// _0_0_8
g.setComposite(AlphaComposite.getInstance(3, 0.3647059f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0873786211013794f, 0.0f, 0.0f, 1.0873786211013794f, -2.146237850189209f, -2.6541261672973633f));
// _0_0_8_0
shape = new RoundRectangle2D.Double(18.125, 28.625, 12.875, 3.5, 3.5, 3.5);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(28.0625f, 23.0f);
generalPath.lineTo(20.5f, 23.09375f);
generalPath.lineTo(20.125f, 23.71875f);
generalPath.lineTo(18.875f, 30.9375f);
generalPath.lineTo(18.90625f, 31.0f);
generalPath.lineTo(30.0625f, 31.0f);
generalPath.lineTo(28.65625f, 24.75f);
generalPath.lineTo(28.0625f, 23.0f);
generalPath.closePath();
shape = generalPath;
paint = new Color(186, 189, 182, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(85, 87, 83, 255);
stroke = new BasicStroke(1.0f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(28.0625f, 23.0f);
generalPath.lineTo(20.5f, 23.09375f);
generalPath.lineTo(20.125f, 23.71875f);
generalPath.lineTo(18.875f, 30.9375f);
generalPath.lineTo(18.90625f, 31.0f);
generalPath.lineTo(30.0625f, 31.0f);
generalPath.lineTo(28.65625f, 24.75f);
generalPath.lineTo(28.0625f, 23.0f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(18.915106f, 30.985245f);
generalPath.lineTo(30.052038f, 30.985245f);
generalPath.lineTo(28.637825f, 24.930641f);
generalPath.lineTo(20.152542f, 25.01903f);
generalPath.lineTo(18.915106f, 30.985245f);
generalPath.closePath();
shape = generalPath;
paint = new Color(186, 189, 182, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(20.513865f, 23.088388f);
generalPath.lineTo(20.071737f, 25.024391f);
generalPath.lineTo(28.624882f, 25.042698f);
generalPath.lineTo(28.0633f, 22.986097f);
generalPath.lineTo(20.513865f, 23.088388f);
generalPath.closePath();
shape = generalPath;
paint = new Color(238, 238, 236, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(20.461903f, 23.11868f);
generalPath.lineTo(20.135769f, 23.716759f);
generalPath.lineTo(18.870913f, 30.94105f);
generalPath.lineTo(19.939156f, 26.005165f);
generalPath.lineTo(28.895407f, 26.010527f);
generalPath.lineTo(28.687382f, 24.99092f);
generalPath.lineTo(20.178432f, 24.967253f);
generalPath.lineTo(20.461903f, 23.11868f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.964285671710968f, 0.0f, 0.0f, 0.964285671710968f, -10.391072273254395f, -11.813166618347168f));
// _0_0_9
g.setComposite(AlphaComposite.getInstance(3, 0.3647059f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0873786211013794f, 0.0f, 0.0f, 1.0873786211013794f, -2.146237850189209f, -2.6541261672973633f));
// _0_0_9_0
shape = new RoundRectangle2D.Double(18.125, 28.625, 12.875, 3.5, 3.5, 3.5);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(28.0625f, 23.1875f);
generalPath.lineTo(20.5f, 23.09375f);
generalPath.lineTo(20.125f, 23.71875f);
generalPath.lineTo(18.875f, 30.9375f);
generalPath.lineTo(18.90625f, 31.0f);
generalPath.lineTo(30.0625f, 31.0f);
generalPath.lineTo(28.65625f, 24.75f);
generalPath.lineTo(28.0625f, 23.1875f);
generalPath.closePath();
shape = generalPath;
paint = new Color(186, 189, 182, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(85, 87, 83, 255);
stroke = new BasicStroke(1.037037f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(28.0625f, 23.1875f);
generalPath.lineTo(20.5f, 23.09375f);
generalPath.lineTo(20.125f, 23.71875f);
generalPath.lineTo(18.875f, 30.9375f);
generalPath.lineTo(18.90625f, 31.0f);
generalPath.lineTo(30.0625f, 31.0f);
generalPath.lineTo(28.65625f, 24.75f);
generalPath.lineTo(28.0625f, 23.1875f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(18.915106f, 30.985245f);
generalPath.lineTo(30.052038f, 30.985245f);
generalPath.lineTo(28.637825f, 24.930641f);
generalPath.lineTo(20.152542f, 25.01903f);
generalPath.lineTo(18.915106f, 30.985245f);
generalPath.closePath();
shape = generalPath;
paint = new Color(186, 189, 182, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(20.513865f, 23.088388f);
generalPath.lineTo(20.071737f, 25.024391f);
generalPath.lineTo(28.624882f, 25.042698f);
generalPath.lineTo(28.0633f, 23.173597f);
generalPath.lineTo(20.513865f, 23.088388f);
generalPath.closePath();
shape = generalPath;
paint = new Color(238, 238, 236, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(20.461903f, 23.11868f);
generalPath.lineTo(20.135769f, 23.716759f);
generalPath.lineTo(18.870913f, 30.94105f);
generalPath.lineTo(19.939156f, 26.005165f);
generalPath.lineTo(28.895407f, 26.010527f);
generalPath.lineTo(28.687382f, 24.99092f);
generalPath.lineTo(20.178432f, 24.967253f);
generalPath.lineTo(20.461903f, 23.11868f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 11.25f, -4.9375f));
// _0_0_10
g.setComposite(AlphaComposite.getInstance(3, 0.3647059f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0873786211013794f, 0.0f, 0.0f, 1.0873786211013794f, -2.146237850189209f, -2.6541261672973633f));
// _0_0_10_0
shape = new RoundRectangle2D.Double(18.125, 28.625, 12.875, 3.5, 3.5, 3.5);
paint = new Color(0, 0, 0, 255);
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
generalPath.moveTo(28.0625f, 23.0f);
generalPath.lineTo(20.5f, 23.09375f);
generalPath.lineTo(20.125f, 23.71875f);
generalPath.lineTo(18.875f, 30.9375f);
generalPath.lineTo(18.90625f, 31.0f);
generalPath.lineTo(30.0625f, 31.0f);
generalPath.lineTo(28.65625f, 24.75f);
generalPath.lineTo(28.0625f, 23.0f);
generalPath.closePath();
shape = generalPath;
paint = new Color(186, 189, 182, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(85, 87, 83, 255);
stroke = new BasicStroke(1.0f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(28.0625f, 23.0f);
generalPath.lineTo(20.5f, 23.09375f);
generalPath.lineTo(20.125f, 23.71875f);
generalPath.lineTo(18.875f, 30.9375f);
generalPath.lineTo(18.90625f, 31.0f);
generalPath.lineTo(30.0625f, 31.0f);
generalPath.lineTo(28.65625f, 24.75f);
generalPath.lineTo(28.0625f, 23.0f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(18.915106f, 30.985245f);
generalPath.lineTo(30.052038f, 30.985245f);
generalPath.lineTo(28.637825f, 24.930641f);
generalPath.lineTo(20.152542f, 25.01903f);
generalPath.lineTo(18.915106f, 30.985245f);
generalPath.closePath();
shape = generalPath;
paint = new Color(186, 189, 182, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(20.513865f, 23.088388f);
generalPath.lineTo(20.071737f, 25.024391f);
generalPath.lineTo(28.624882f, 25.042698f);
generalPath.lineTo(28.0633f, 22.986097f);
generalPath.lineTo(20.513865f, 23.088388f);
generalPath.closePath();
shape = generalPath;
paint = new Color(238, 238, 236, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(20.461903f, 23.11868f);
generalPath.lineTo(20.135769f, 23.716759f);
generalPath.lineTo(18.870913f, 30.94105f);
generalPath.lineTo(19.939156f, 26.005165f);
generalPath.lineTo(28.895407f, 26.010527f);
generalPath.lineTo(28.687382f, 24.99092f);
generalPath.lineTo(20.178432f, 24.967253f);
generalPath.lineTo(20.461903f, 23.11868f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
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
        return 0.0;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 8.0;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 48.0;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 35.16643142700195;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private preferences_desktop_2() {
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
       preferences_desktop_2 base = new preferences_desktop_2();
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
       preferences_desktop_2 base = new preferences_desktop_2();
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
        return preferences_desktop_2::new;
    }
}

