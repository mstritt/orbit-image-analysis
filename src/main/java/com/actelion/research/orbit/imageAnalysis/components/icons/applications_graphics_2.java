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
public class applications_graphics_2 implements ResizableIcon {
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
g.setComposite(AlphaComposite.getInstance(3, 0.1f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.1094890832901f, 0.0f, 0.0f, 0.5479452013969421f, -1.7189780473709106f, 16.63527488708496f));
// _0_0_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(19.125f, 46.0625f);
generalPath.curveTo(19.138721f, 47.697384f, 17.509726f, 49.21122f, 14.854842f, 50.03078f);
generalPath.curveTo(12.199959f, 50.85034f, 8.925041f, 50.85034f, 6.270158f, 50.03078f);
generalPath.curveTo(3.6152742f, 49.21122f, 1.9862785f, 47.697384f, 2.0f, 46.0625f);
generalPath.curveTo(1.9862785f, 44.427616f, 3.6152742f, 42.91378f, 6.270158f, 42.09422f);
generalPath.curveTo(8.925041f, 41.27466f, 12.199959f, 41.27466f, 14.854842f, 42.09422f);
generalPath.curveTo(17.509726f, 42.91378f, 19.138721f, 44.427616f, 19.125f, 46.0625f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(10.5625, 46.0625), 8.5625f, new Point2D.Double(10.5625, 46.0625), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.5328466892242432f, 0.0f, 21.518247604370117f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.30268195f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 0.0f));
// _0_0_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-45.96966f, 31.033003f);
generalPath.curveTo(-45.96966f, 22.35596f, -45.44278f, 14.0343075f, -44.504925f, 7.898713f);
generalPath.curveTo(-43.56707f, 1.7631185f, -42.295067f, -1.6838213f, -40.96874f, -1.6838188f);
generalPath.curveTo(-39.64241f, -1.6838213f, -38.370407f, 1.7631187f, -37.432552f, 7.8987136f);
generalPath.curveTo(-36.494698f, 14.034308f, -35.967815f, 22.355963f, -35.967815f, 31.033005f);
generalPath.lineTo(-40.96874f, 31.033005f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(6.5, 23.5), 4.5f, new Point2D.Double(6.5, 23.5), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.1113158464431763f, 0.0f, 0.0f, 7.270405292510986f, -48.192291259765625f, -139.82151794433594f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.30268195f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f));
// _0_0_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-45.96966f, -31.033007f);
generalPath.curveTo(-45.96966f, -35.45339f, -45.44278f, -39.69272f, -44.504925f, -42.818398f);
generalPath.curveTo(-43.56707f, -45.94408f, -42.295067f, -47.700066f, -40.96874f, -47.700066f);
generalPath.curveTo(-39.64241f, -47.700066f, -38.370407f, -45.94408f, -37.432552f, -42.818398f);
generalPath.curveTo(-36.494698f, -39.69272f, -35.967815f, -35.453384f, -35.967815f, -31.033005f);
generalPath.lineTo(-40.96874f, -31.033005f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(6.5, 23.5), 4.5f, new Point2D.Double(6.5, 23.5), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.1113158464431763f, 0.0f, 0.0f, 3.703791379928589f, -48.192291259765625f, -118.07209777832031f));
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
generalPath.moveTo(23.03125f, 4.5f);
generalPath.curveTo(17.16448f, 4.576939f, 9.304703f, 6.5845976f, 9.4375f, 13.03125f);
generalPath.curveTo(9.579161f, 19.90817f, 17.932526f, 17.194685f, 18.25f, 20.25f);
generalPath.curveTo(18.763103f, 25.188007f, 8.07627f, 40.21102f, 24.3125f, 43.15625f);
generalPath.curveTo(35.15176f, 45.122475f, 46.655804f, 38.37184f, 45.5f, 24.75f);
generalPath.curveTo(44.460564f, 12.499581f, 34.3249f, 4.811841f, 24.1875f, 4.5f);
generalPath.curveTo(23.81714f, 4.4886074f, 23.422367f, 4.4948707f, 23.03125f, 4.5f);
generalPath.closePath();
generalPath.moveTo(20.5f, 8.5f);
generalPath.curveTo(23.26f, 8.5f, 25.5f, 10.068f, 25.5f, 12.0f);
generalPath.curveTo(25.500002f, 13.932f, 23.26f, 15.5f, 20.5f, 15.5f);
generalPath.curveTo(17.74f, 15.5f, 15.5f, 13.932f, 15.5f, 12.0f);
generalPath.curveTo(15.5f, 10.068f, 17.74f, 8.5f, 20.5f, 8.5f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(28.65760040283203, 33.9866943359375), 18.572308f, new Point2D.Double(28.65760040283203, 33.9866943359375), new float[] {0.0f,1.0f}, new Color[] {new Color(231, 206, 121, 255),new Color(193, 125, 17, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(6.042988300323486f, 0.0f, 0.0f, 5.537075996398926f, -142.7943878173828f, -152.23843383789062f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(193, 125, 17, 255);
stroke = new BasicStroke(0.9999999f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(23.03125f, 4.5f);
generalPath.curveTo(17.16448f, 4.576939f, 9.304703f, 6.5845976f, 9.4375f, 13.03125f);
generalPath.curveTo(9.579161f, 19.90817f, 17.932526f, 17.194685f, 18.25f, 20.25f);
generalPath.curveTo(18.763103f, 25.188007f, 8.07627f, 40.21102f, 24.3125f, 43.15625f);
generalPath.curveTo(35.15176f, 45.122475f, 46.655804f, 38.37184f, 45.5f, 24.75f);
generalPath.curveTo(44.460564f, 12.499581f, 34.3249f, 4.811841f, 24.1875f, 4.5f);
generalPath.curveTo(23.81714f, 4.4886074f, 23.422367f, 4.4948707f, 23.03125f, 4.5f);
generalPath.closePath();
generalPath.moveTo(20.5f, 8.5f);
generalPath.curveTo(23.26f, 8.5f, 25.5f, 10.068f, 25.5f, 12.0f);
generalPath.curveTo(25.500002f, 13.932f, 23.26f, 15.5f, 20.5f, 15.5f);
generalPath.curveTo(17.74f, 15.5f, 15.5f, 13.932f, 15.5f, 12.0f);
generalPath.curveTo(15.5f, 10.068f, 17.74f, 8.5f, 20.5f, 8.5f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.6704981f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
paint = new LinearGradientPaint(new Point2D.Double(15.299922943115234, 9.144098281860352), new Point2D.Double(51.56820297241211, 83.0760726928711), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 133)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 1.0640332698822021f, 0.024633700028061867f));
stroke = new BasicStroke(1.0f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(23.095284f, 5.524634f);
generalPath.curveTo(20.271f, 5.5616727f, 16.972109f, 6.09223f, 14.501533f, 7.305884f);
generalPath.curveTo(12.030958f, 8.519538f, 10.443616f, 10.213046f, 10.501533f, 13.024634f);
generalPath.curveTo(10.532717f, 14.538464f, 10.981199f, 15.35297f, 11.595283f, 15.930884f);
generalPath.curveTo(12.209367f, 16.508799f, 13.090956f, 16.854794f, 14.095283f, 17.118383f);
generalPath.curveTo(15.09961f, 17.381975f, 16.186836f, 17.537653f, 17.157784f, 17.868383f);
generalPath.curveTo(17.643255f, 18.033749f, 18.118862f, 18.248297f, 18.532784f, 18.618383f);
generalPath.curveTo(18.946703f, 18.988472f, 19.250063f, 19.565243f, 19.314034f, 20.180883f);
generalPath.curveTo(19.484936f, 21.825613f, 18.835106f, 23.684235f, 18.157784f, 25.837133f);
generalPath.curveTo(17.48046f, 27.990032f, 16.711693f, 30.350748f, 16.439034f, 32.587135f);
generalPath.curveTo(16.166372f, 34.82352f, 16.397821f, 36.867165f, 17.501534f, 38.493385f);
generalPath.curveTo(18.605246f, 40.119606f, 20.67224f, 41.47492f, 24.564034f, 42.180885f);
generalPath.curveTo(29.722582f, 43.11664f, 35.012897f, 41.973743f, 38.845284f, 39.024635f);
generalPath.curveTo(42.67767f, 36.075527f, 45.116917f, 31.384464f, 44.564034f, 24.868383f);
generalPath.curveTo(43.568283f, 13.13285f, 33.8692f, 5.8214483f, 24.220284f, 5.524634f);
generalPath.curveTo(23.88329f, 5.5142674f, 23.488268f, 5.5194798f, 23.095284f, 5.524634f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.16475093f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.4375f, -0.875f));
// _0_0_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(35.5f, 8.3125f);
generalPath.curveTo(35.417503f, 8.334556f, 35.342136f, 8.377624f, 35.28125f, 8.4375f);
generalPath.curveTo(26.293922f, 15.459378f, 21.66408f, 20.791641f, 19.09375f, 24.21875f);
generalPath.curveTo(17.381636f, 26.331879f, 15.48999f, 29.489983f, 13.9375f, 32.4375f);
generalPath.curveTo(13.907882f, 32.485626f, 13.886742f, 32.538475f, 13.875f, 32.59375f);
generalPath.curveTo(13.656392f, 34.591415f, 13.798454f, 36.607193f, 14.65625f, 38.375f);
generalPath.curveTo(14.714969f, 38.498474f, 14.822246f, 38.592087f, 14.952537f, 38.633545f);
generalPath.curveTo(15.082828f, 38.675f, 15.224475f, 38.66059f, 15.34375f, 38.59375f);
generalPath.curveTo(19.360056f, 36.282684f, 24.501652f, 31.405796f, 25.875f, 29.8125f);
generalPath.curveTo(28.811441f, 26.456568f, 33.524033f, 20.521343f, 38.46875f, 11.125f);
generalPath.curveTo(38.55983f, 10.936574f, 38.522266f, 10.711201f, 38.375f, 10.5625f);
generalPath.curveTo(37.596275f, 9.79973f, 36.756405f, 9.050465f, 35.875f, 8.40625f);
generalPath.curveTo(35.767925f, 8.325354f, 35.632545f, 8.291508f, 35.5f, 8.3125f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(28.469051361083984, 23.214420318603516), 12.3671f, new Point2D.Double(28.469051361083984, 23.214420318603516), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.16754360496997833f, 0.13406769931316376f, -0.9393553733825684f, 1.1739071607589722f, 43.93767166137695f, -7.586747169494629f));
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
generalPath.moveTo(24.377604f, 26.216887f);
generalPath.curveTo(28.122395f, 22.65966f, 34.66893f, 15.824043f, 42.5f, 5.0f);
generalPath.curveTo(42.815075f, 4.651051f, 42.290607f, 4.3510866f, 42.0f, 4.5f);
generalPath.curveTo(30.168297f, 12.786013f, 24.217867f, 18.976254f, 20.842672f, 22.51528f);
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(33.17571258544922, 18.65762710571289), new Point2D.Double(31.180810928344727, 17.177289962768555), new float[] {0.0f,1.0f}, new Color[] {new Color(193, 125, 17, 255),new Color(233, 185, 110, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.8048011064529419f, -0.08405894786119461f, -0.2587752938270569f, 0.841191828250885f, 10.723363876342773f, 3.5105159282684326f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(143, 89, 2, 255);
stroke = new BasicStroke(0.99999994f,0,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(24.377604f, 26.216887f);
generalPath.curveTo(28.122395f, 22.65966f, 34.66893f, 15.824043f, 42.5f, 5.0f);
generalPath.curveTo(42.815075f, 4.651051f, 42.290607f, 4.3510866f, 42.0f, 4.5f);
generalPath.curveTo(30.168297f, 12.786013f, 24.217867f, 18.976254f, 20.842672f, 22.51528f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.15f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(21.436422f, 21.92153f);
generalPath.curveTo(22.917898f, 22.51538f, 24.23436f, 23.4576f, 24.971354f, 25.623137f);
generalPath.curveTo(23.470957f, 27.062363f, 17.507904f, 32.04784f, 13.789563f, 34.11851f);
generalPath.lineTo(12.697511f, 32.604244f);
generalPath.curveTo(14.810426f, 29.533985f, 18.67098f, 24.68227f, 21.436422f, 21.92153f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.0f,0,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(21.436422f, 21.92153f);
generalPath.curveTo(22.917898f, 22.51538f, 24.23436f, 23.4576f, 24.971354f, 25.623137f);
generalPath.curveTo(23.470957f, 27.062363f, 17.507904f, 32.04784f, 13.789563f, 34.11851f);
generalPath.lineTo(12.697511f, 32.604244f);
generalPath.curveTo(14.810426f, 29.533985f, 18.67098f, 24.68227f, 21.436422f, 21.92153f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7356322f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8
paint = new LinearGradientPaint(new Point2D.Double(21.424922943115234, 14.769098281860352), new Point2D.Double(16.63990020751953, 5.5), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 88)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 1.0640332698822021f, 0.024633700028061867f));
stroke = new BasicStroke(1.0f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(20.564034f, 7.524634f);
generalPath.curveTo(22.13501f, 7.524634f, 23.586748f, 7.940535f, 24.689034f, 8.712133f);
generalPath.curveTo(25.791317f, 9.483732f, 26.564034f, 10.668887f, 26.564034f, 12.024634f);
generalPath.curveTo(26.564034f, 13.380382f, 25.791317f, 14.565535f, 24.689034f, 15.337134f);
generalPath.curveTo(23.586748f, 16.108732f, 22.13501f, 16.524633f, 20.564034f, 16.524633f);
generalPath.curveTo(18.993057f, 16.524633f, 17.541317f, 16.108732f, 16.439034f, 15.337134f);
generalPath.curveTo(15.336749f, 14.565535f, 14.564033f, 13.380381f, 14.564033f, 12.024634f);
generalPath.curveTo(14.564033f, 10.668887f, 15.336749f, 9.483732f, 16.439034f, 8.712133f);
generalPath.curveTo(17.541317f, 7.940535f, 18.993057f, 7.524634f, 20.564034f, 7.524634f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(20.842672f, 22.51528f);
generalPath.curveTo(22.324148f, 23.10913f, 23.64061f, 24.05135f, 24.377604f, 26.216887f);
generalPath.curveTo(22.877207f, 27.656113f, 16.914154f, 32.64159f, 13.195813f, 34.71226f);
generalPath.lineTo(12.103761f, 33.197994f);
generalPath.curveTo(14.216676f, 30.127735f, 18.07723f, 25.27602f, 20.842672f, 22.51528f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(19.635454177856445, 29.59141731262207), new Point2D.Double(23.529132843017578, 33.4850959777832), new float[] {0.0f,1.0f}, new Color[] {new Color(238, 238, 236, 255),new Color(136, 138, 133, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.8048011064529419f, -0.08405894786119461f, -0.2587752938270569f, 0.841191828250885f, 10.723363876342773f, 3.5105159282684326f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(136, 138, 133, 255);
stroke = new BasicStroke(0.99999994f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(20.842672f, 22.51528f);
generalPath.curveTo(22.324148f, 23.10913f, 23.64061f, 24.05135f, 24.377604f, 26.216887f);
generalPath.curveTo(22.877207f, 27.656113f, 16.914154f, 32.64159f, 13.195813f, 34.71226f);
generalPath.lineTo(12.103761f, 33.197994f);
generalPath.curveTo(14.216676f, 30.127735f, 18.07723f, 25.27602f, 20.842672f, 22.51528f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
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
generalPath.moveTo(28.045376f, 37.921974f);
generalPath.curveTo(27.064337f, 38.51481f, 28.116901f, 39.195824f, 28.590324f, 39.592552f);
generalPath.curveTo(28.965794f, 39.9072f, 28.401928f, 41.427887f, 27.72951f, 40.755863f);
generalPath.curveTo(26.9546f, 39.981403f, 26.455671f, 38.903973f, 26.151737f, 38.87636f);
generalPath.curveTo(24.404814f, 38.71764f, 25.749868f, 41.02413f, 24.344105f, 40.516865f);
generalPath.curveTo(23.502897f, 40.213314f, 24.549532f, 38.939026f, 23.426212f, 38.54794f);
generalPath.curveTo(22.533806f, 38.237244f, 22.622469f, 39.191994f, 22.106453f, 38.726784f);
generalPath.curveTo(19.677176f, 36.536674f, 20.954063f, 34.634197f, 22.0783f, 33.148434f);
generalPath.curveTo(23.202553f, 31.662645f, 25.423492f, 31.503317f, 27.070408f, 32.820816f);
generalPath.curveTo(28.71732f, 34.138313f, 29.154104f, 36.423634f, 28.045376f, 37.921974f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.9999998f,0,1,5.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(28.045376f, 37.921974f);
generalPath.curveTo(27.064337f, 38.51481f, 28.116901f, 39.195824f, 28.590324f, 39.592552f);
generalPath.curveTo(28.965794f, 39.9072f, 28.401928f, 41.427887f, 27.72951f, 40.755863f);
generalPath.curveTo(26.9546f, 39.981403f, 26.455671f, 38.903973f, 26.151737f, 38.87636f);
generalPath.curveTo(24.404814f, 38.71764f, 25.749868f, 41.02413f, 24.344105f, 40.516865f);
generalPath.curveTo(23.502897f, 40.213314f, 24.549532f, 38.939026f, 23.426212f, 38.54794f);
generalPath.curveTo(22.533806f, 38.237244f, 22.622469f, 39.191994f, 22.106453f, 38.726784f);
generalPath.curveTo(19.677176f, 36.536674f, 20.954063f, 34.634197f, 22.0783f, 33.148434f);
generalPath.curveTo(23.202553f, 31.662645f, 25.423492f, 31.503317f, 27.070408f, 32.820816f);
generalPath.curveTo(28.71732f, 34.138313f, 29.154104f, 36.423634f, 28.045376f, 37.921974f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
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
generalPath.moveTo(36.695507f, 34.909004f);
generalPath.curveTo(37.590054f, 34.909004f, 39.091335f, 35.06f, 39.486423f, 35.52464f);
generalPath.curveTo(40.410248f, 36.611107f, 41.229923f, 35.182003f, 40.52713f, 34.56505f);
generalPath.curveTo(39.717213f, 33.854053f, 38.64075f, 33.444843f, 38.58787f, 33.14281f);
generalPath.curveTo(38.283947f, 31.406815f, 40.612427f, 32.560192f, 40.003914f, 31.195068f);
generalPath.curveTo(39.639786f, 30.37818f, 38.5088f, 31.533157f, 38.03623f, 30.441114f);
generalPath.curveTo(37.660797f, 29.573557f, 38.583996f, 29.582233f, 38.09309f, 29.104546f);
generalPath.curveTo(35.782043f, 26.855701f, 34.0687f, 28.293953f, 32.741673f, 29.544382f);
generalPath.curveTo(31.414629f, 30.794827f, 31.454754f, 33.03217f, 32.861122f, 34.570793f);
generalPath.curveTo(33.43871f, 35.202698f, 33.722527f, 36.72163f, 34.459137f, 36.904297f);
generalPath.curveTo(35.516106f, 37.1664f, 34.442924f, 34.909004f, 36.695507f, 34.909004f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.0f,0,1,5.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(36.695507f, 34.909004f);
generalPath.curveTo(37.590054f, 34.909004f, 39.091335f, 35.06f, 39.486423f, 35.52464f);
generalPath.curveTo(40.410248f, 36.611107f, 41.229923f, 35.182003f, 40.52713f, 34.56505f);
generalPath.curveTo(39.717213f, 33.854053f, 38.64075f, 33.444843f, 38.58787f, 33.14281f);
generalPath.curveTo(38.283947f, 31.406815f, 40.612427f, 32.560192f, 40.003914f, 31.195068f);
generalPath.curveTo(39.639786f, 30.37818f, 38.5088f, 31.533157f, 38.03623f, 30.441114f);
generalPath.curveTo(37.660797f, 29.573557f, 38.583996f, 29.582233f, 38.09309f, 29.104546f);
generalPath.curveTo(35.782043f, 26.855701f, 34.0687f, 28.293953f, 32.741673f, 29.544382f);
generalPath.curveTo(31.414629f, 30.794827f, 31.454754f, 33.03217f, 32.861122f, 34.570793f);
generalPath.curveTo(33.43871f, 35.202698f, 33.722527f, 36.72163f, 34.459137f, 36.904297f);
generalPath.curveTo(35.516106f, 37.1664f, 34.442924f, 34.909004f, 36.695507f, 34.909004f);
generalPath.closePath();
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
generalPath.moveTo(38.24158f, 23.925957f);
generalPath.curveTo(37.360645f, 23.925957f, 37.18421f, 24.533909f, 36.76909f, 24.925564f);
generalPath.curveTo(36.439857f, 25.23618f, 35.05212f, 24.621115f, 35.744217f, 24.072927f);
generalPath.curveTo(36.541813f, 23.441183f, 36.71702f, 22.694916f, 36.76909f, 22.426546f);
generalPath.curveTo(37.06839f, 20.884048f, 34.11303f, 21.633947f, 34.72097f, 20.425476f);
generalPath.curveTo(35.16365f, 19.54551f, 36.773464f, 20.383345f, 36.76909f, 19.927532f);
generalPath.curveTo(36.76234f, 19.2247f, 36.34899f, 18.162909f, 37.229736f, 17.989265f);
generalPath.curveTo(39.0829f, 17.623909f, 41.21615f, 18.901438f, 42.22097f, 19.925476f);
generalPath.curveTo(43.1817f, 20.90458f, 42.648815f, 22.616716f, 42.080776f, 23.832945f);
generalPath.curveTo(41.73371f, 24.576044f, 40.938435f, 26.088415f, 40.016247f, 25.906351f);
generalPath.curveTo(38.969826f, 25.69976f, 40.459885f, 23.925957f, 38.24158f, 23.925957f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.0f,0,1,5.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(38.24158f, 23.925957f);
generalPath.curveTo(37.360645f, 23.925957f, 37.18421f, 24.533909f, 36.76909f, 24.925564f);
generalPath.curveTo(36.439857f, 25.23618f, 35.05212f, 24.621115f, 35.744217f, 24.072927f);
generalPath.curveTo(36.541813f, 23.441183f, 36.71702f, 22.694916f, 36.76909f, 22.426546f);
generalPath.curveTo(37.06839f, 20.884048f, 34.11303f, 21.633947f, 34.72097f, 20.425476f);
generalPath.curveTo(35.16365f, 19.54551f, 36.773464f, 20.383345f, 36.76909f, 19.927532f);
generalPath.curveTo(36.76234f, 19.2247f, 36.34899f, 18.162909f, 37.229736f, 17.989265f);
generalPath.curveTo(39.0829f, 17.623909f, 41.21615f, 18.901438f, 42.22097f, 19.925476f);
generalPath.curveTo(43.1817f, 20.90458f, 42.648815f, 22.616716f, 42.080776f, 23.832945f);
generalPath.curveTo(41.73371f, 24.576044f, 40.938435f, 26.088415f, 40.016247f, 25.906351f);
generalPath.curveTo(38.969826f, 25.69976f, 40.459885f, 23.925957f, 38.24158f, 23.925957f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.6800002f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_13
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(12.9375f, 33.4375f);
generalPath.curveTo(18.547565f, 24.93393f, 36.615368f, 9.233779f, 40.5f, 6.625f);
generalPath.curveTo(32.235233f, 15.427256f, 21.892145f, 25.266733f, 12.9375f, 33.4375f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(18.1875, 28.625), new Point2D.Double(41.4375, 6.1875), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, -1.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_14
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(27.824406f, 37.4965f);
generalPath.curveTo(26.843367f, 38.089333f, 27.895931f, 38.770348f, 28.369354f, 39.167076f);
generalPath.curveTo(28.744822f, 39.481724f, 28.180958f, 41.00241f, 27.50854f, 40.330387f);
generalPath.curveTo(26.73363f, 39.555927f, 26.2347f, 38.478497f, 25.930767f, 38.450886f);
generalPath.curveTo(24.183844f, 38.292164f, 25.528898f, 40.598656f, 24.123135f, 40.09139f);
generalPath.curveTo(23.281925f, 39.787838f, 24.328562f, 38.51355f, 23.20524f, 38.122463f);
generalPath.curveTo(22.312836f, 37.811768f, 22.401497f, 38.766518f, 21.88548f, 38.301308f);
generalPath.curveTo(19.456205f, 36.1112f, 20.733093f, 34.20872f, 21.857328f, 32.722958f);
generalPath.curveTo(22.98158f, 31.23717f, 25.202522f, 31.07784f, 26.849436f, 32.39534f);
generalPath.curveTo(28.496347f, 33.712837f, 28.933134f, 35.998158f, 27.824406f, 37.4965f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(23.537704467773438, 36.02513122558594), 4.244812f, new Point2D.Double(23.537704467773438, 36.02513122558594), new float[] {0.0f,1.0f}, new Color[] {new Color(138, 226, 52, 255),new Color(115, 210, 22, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9409276843070984f, 0.0f, 0.0f, 1.0482488870620728f, 1.6820708513259888f, -3.177501916885376f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(78, 154, 6, 255);
stroke = new BasicStroke(0.9999998f,0,1,5.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(27.824406f, 37.4965f);
generalPath.curveTo(26.843367f, 38.089333f, 27.895931f, 38.770348f, 28.369354f, 39.167076f);
generalPath.curveTo(28.744822f, 39.481724f, 28.180958f, 41.00241f, 27.50854f, 40.330387f);
generalPath.curveTo(26.73363f, 39.555927f, 26.2347f, 38.478497f, 25.930767f, 38.450886f);
generalPath.curveTo(24.183844f, 38.292164f, 25.528898f, 40.598656f, 24.123135f, 40.09139f);
generalPath.curveTo(23.281925f, 39.787838f, 24.328562f, 38.51355f, 23.20524f, 38.122463f);
generalPath.curveTo(22.312836f, 37.811768f, 22.401497f, 38.766518f, 21.88548f, 38.301308f);
generalPath.curveTo(19.456205f, 36.1112f, 20.733093f, 34.20872f, 21.857328f, 32.722958f);
generalPath.curveTo(22.98158f, 31.23717f, 25.202522f, 31.07784f, 26.849436f, 32.39534f);
generalPath.curveTo(28.496347f, 33.712837f, 28.933134f, 35.998158f, 27.824406f, 37.4965f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.77011496f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(25.71875f, 32.75f);
generalPath.curveTo(24.385471f, 31.971878f, 22.878695f, 32.79794f, 22.34375f, 33.46875f);
generalPath.curveTo(21.808805f, 34.13956f, 21.082611f, 35.45121f, 21.65625f, 36.6875f);
generalPath.curveTo(22.033056f, 35.49819f, 22.574726f, 34.707554f, 23.125f, 34.09375f);
generalPath.curveTo(23.676092f, 33.47903f, 24.318087f, 32.81714f, 25.71875f, 32.75f);
generalPath.closePath();
shape = generalPath;
paint = new Color(238, 238, 236, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_16
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(2.5f, 39.533974f);
generalPath.curveTo(7.193467f, 39.53579f, 6.721149f, 34.641895f, 9.0f, 33.141697f);
generalPath.curveTo(11.640769f, 31.403242f, 13.954982f, 33.55738f, 14.41701f, 35.33018f);
generalPath.curveTo(15.0f, 37.56712f, 14.0f, 40.02569f, 11.0f, 41.009117f);
generalPath.curveTo(7.636352f, 42.11175f, 2.889473f, 41.484547f, 2.5f, 39.533974f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(10.593055725097656, 38.58195495605469), new Point2D.Double(10.165061950683594, 43.38218688964844), new float[] {0.0f,1.0f}, new Color[] {new Color(85, 87, 83, 255),new Color(31, 35, 36, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.267530083656311f, -0.9999949932098389f, -14.853580474853516f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.9999999f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(2.5f, 39.533974f);
generalPath.curveTo(7.193467f, 39.53579f, 6.721149f, 34.641895f, 9.0f, 33.141697f);
generalPath.curveTo(11.640769f, 31.403242f, 13.954982f, 33.55738f, 14.41701f, 35.33018f);
generalPath.curveTo(15.0f, 37.56712f, 14.0f, 40.02569f, 11.0f, 41.009117f);
generalPath.curveTo(7.636352f, 42.11175f, 2.889473f, 41.484547f, 2.5f, 39.533974f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.29118773f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17
paint = new LinearGradientPaint(new Point2D.Double(9.343700408935547, 38.8116569519043), new Point2D.Double(10.924744606018066, 46.82093048095703), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 17)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.6424152255058289f, 0.0f, 0.0f, 0.7146281003952026f, 3.445805072784424f, 6.787435054779053f));
stroke = new BasicStroke(1.0f,0,1,5.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(4.0f, 40.11888f);
generalPath.curveTo(6.035358f, 40.093246f, 7.435893f, 37.673954f, 7.966235f, 36.13983f);
generalPath.curveTo(9.56545f, 31.513773f, 14.380709f, 33.712894f, 13.5f, 36.932713f);
generalPath.curveTo(12.451529f, 42.11423f, 7.044828f, 40.12705f, 4.0f, 40.11888f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(2.6362040042877197f, 0.0f, 0.0f, 2.1809589862823486f, -21.126216888427734f, -49.42094039916992f));
// _0_0_18
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(13.324543f, 38.708176f);
generalPath.curveTo(13.326366f, 39.036774f, 13.109865f, 39.341045f, 12.757017f, 39.50577f);
generalPath.curveTo(12.40417f, 39.670498f, 11.968916f, 39.670498f, 11.616069f, 39.50577f);
generalPath.curveTo(11.263221f, 39.341045f, 11.04672f, 39.036774f, 11.048543f, 38.708176f);
generalPath.curveTo(11.04672f, 38.379578f, 11.263221f, 38.075306f, 11.616069f, 37.91058f);
generalPath.curveTo(11.968916f, 37.745853f, 12.40417f, 37.745853f, 12.757017f, 37.91058f);
generalPath.curveTo(13.109865f, 38.075306f, 13.326366f, 38.379578f, 13.324543f, 38.708176f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(12.186543464660645, 38.012454986572266), new Point2D.Double(12.186543464660645, 39.532230377197266), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 17)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_19
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(36.474537f, 34.48353f);
generalPath.curveTo(37.369083f, 34.48353f, 38.870365f, 34.634525f, 39.26545f, 35.099167f);
generalPath.curveTo(40.189278f, 36.18563f, 41.008953f, 34.756527f, 40.30616f, 34.139572f);
generalPath.curveTo(39.496243f, 33.428577f, 38.41978f, 33.019367f, 38.3669f, 32.717335f);
generalPath.curveTo(38.062977f, 30.981339f, 40.391453f, 32.134716f, 39.782944f, 30.769592f);
generalPath.curveTo(39.41881f, 29.952703f, 38.28783f, 31.107681f, 37.815254f, 30.015638f);
generalPath.curveTo(37.439827f, 29.14808f, 38.363026f, 29.156757f, 37.87212f, 28.67907f);
generalPath.curveTo(35.56107f, 26.430225f, 33.847725f, 27.868477f, 32.520702f, 29.118906f);
generalPath.curveTo(31.193659f, 30.36935f, 31.233784f, 32.606693f, 32.64015f, 34.145317f);
generalPath.curveTo(33.217735f, 34.77722f, 33.501553f, 36.296158f, 34.238167f, 36.47882f);
generalPath.curveTo(35.29513f, 36.740925f, 34.22195f, 34.48353f, 36.474537f, 34.48353f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(32.450172424316406, 33.60939407348633), 5.0383153f, new Point2D.Double(32.450172424316406, 33.60939407348633), new float[] {0.0f,1.0f}, new Color[] {new Color(239, 41, 41, 255),new Color(204, 0, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.6369420289993286f, 0.696841299533844f, 0.5532571077346802f, -0.5101348161697388f, -5.00120210647583f, 25.28829002380371f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(164, 0, 0, 255);
stroke = new BasicStroke(1.0f,0,1,5.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(36.474537f, 34.48353f);
generalPath.curveTo(37.369083f, 34.48353f, 38.870365f, 34.634525f, 39.26545f, 35.099167f);
generalPath.curveTo(40.189278f, 36.18563f, 41.008953f, 34.756527f, 40.30616f, 34.139572f);
generalPath.curveTo(39.496243f, 33.428577f, 38.41978f, 33.019367f, 38.3669f, 32.717335f);
generalPath.curveTo(38.062977f, 30.981339f, 40.391453f, 32.134716f, 39.782944f, 30.769592f);
generalPath.curveTo(39.41881f, 29.952703f, 38.28783f, 31.107681f, 37.815254f, 30.015638f);
generalPath.curveTo(37.439827f, 29.14808f, 38.363026f, 29.156757f, 37.87212f, 28.67907f);
generalPath.curveTo(35.56107f, 26.430225f, 33.847725f, 27.868477f, 32.520702f, 29.118906f);
generalPath.curveTo(31.193659f, 30.36935f, 31.233784f, 32.606693f, 32.64015f, 34.145317f);
generalPath.curveTo(33.217735f, 34.77722f, 33.501553f, 36.296158f, 34.238167f, 36.47882f);
generalPath.curveTo(35.29513f, 36.740925f, 34.22195f, 34.48353f, 36.474537f, 34.48353f);
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
paint = new LinearGradientPaint(new Point2D.Double(38.28942108154297, 5.253948211669922), new Point2D.Double(36.610626220703125, 7.3314619064331055), new float[] {0.0f,1.0f}, new Color[] {new Color(234, 197, 134, 255),new Color(234, 197, 134, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.8048011064529419f, -0.08405894786119461f, -0.2587752938270569f, 0.841191828250885f, 10.626724243164062f, 5.876156806945801f));
stroke = new BasicStroke(0.99999994f,1,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(41.510654f, 5.5f);
generalPath.lineTo(38.5f, 8.508813f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_21
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(38.02061f, 23.50048f);
generalPath.curveTo(37.139675f, 23.50048f, 36.96324f, 24.108433f, 36.54812f, 24.500088f);
generalPath.curveTo(36.218887f, 24.810703f, 34.83115f, 24.195639f, 35.523247f, 23.647451f);
generalPath.curveTo(36.32084f, 23.015707f, 36.496044f, 22.26944f, 36.54812f, 22.001072f);
generalPath.curveTo(36.84742f, 20.458572f, 33.89206f, 21.208471f, 34.5f, 20.0f);
generalPath.curveTo(34.94268f, 19.120033f, 36.552494f, 19.957869f, 36.54812f, 19.502056f);
generalPath.curveTo(36.54137f, 18.799225f, 36.128017f, 17.737432f, 37.008762f, 17.56379f);
generalPath.curveTo(38.86193f, 17.198433f, 40.99518f, 18.475962f, 42.0f, 19.5f);
generalPath.curveTo(42.96073f, 20.479103f, 42.427845f, 22.19124f, 41.859806f, 23.407469f);
generalPath.curveTo(41.512737f, 24.15057f, 40.717464f, 25.66294f, 39.795277f, 25.480877f);
generalPath.curveTo(38.748856f, 25.274284f, 40.238914f, 23.50048f, 38.02061f, 23.50048f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(33.29081344604492, 36.0700569152832), 5.0383153f, new Point2D.Double(33.29081344604492, 36.0700569152832), new float[] {0.0f,1.0f}, new Color[] {new Color(114, 159, 207, 255),new Color(52, 101, 164, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-0.8570756912231445f, 0.7036892175674438f, -0.6305521726608276f, -0.6305521726608276f, 89.17596435546875f, 19.040700912475586f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(32, 74, 135, 255);
stroke = new BasicStroke(1.0f,0,1,5.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(38.02061f, 23.50048f);
generalPath.curveTo(37.139675f, 23.50048f, 36.96324f, 24.108433f, 36.54812f, 24.500088f);
generalPath.curveTo(36.218887f, 24.810703f, 34.83115f, 24.195639f, 35.523247f, 23.647451f);
generalPath.curveTo(36.32084f, 23.015707f, 36.496044f, 22.26944f, 36.54812f, 22.001072f);
generalPath.curveTo(36.84742f, 20.458572f, 33.89206f, 21.208471f, 34.5f, 20.0f);
generalPath.curveTo(34.94268f, 19.120033f, 36.552494f, 19.957869f, 36.54812f, 19.502056f);
generalPath.curveTo(36.54137f, 18.799225f, 36.128017f, 17.737432f, 37.008762f, 17.56379f);
generalPath.curveTo(38.86193f, 17.198433f, 40.99518f, 18.475962f, 42.0f, 19.5f);
generalPath.curveTo(42.96073f, 20.479103f, 42.427845f, 22.19124f, 41.859806f, 23.407469f);
generalPath.curveTo(41.512737f, 24.15057f, 40.717464f, 25.66294f, 39.795277f, 25.480877f);
generalPath.curveTo(38.748856f, 25.274284f, 40.238914f, 23.50048f, 38.02061f, 23.50048f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.77011496f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_22
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(38.0f, 18.5f);
generalPath.curveTo(37.144714f, 18.887354f, 37.0f, 20.0f, 37.5f, 21.0f);
generalPath.curveTo(38.033146f, 19.553299f, 39.5f, 20.0f, 41.0f, 20.0f);
generalPath.curveTo(40.5f, 19.0f, 38.596325f, 18.30053f, 38.0f, 18.5f);
generalPath.closePath();
shape = generalPath;
paint = new Color(238, 238, 236, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.77011496f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_23
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(36.768036f, 28.732128f);
generalPath.curveTo(35.434757f, 27.954006f, 33.927982f, 28.780067f, 33.393036f, 29.450878f);
generalPath.curveTo(32.85809f, 30.12169f, 32.131897f, 31.43334f, 32.705536f, 32.66963f);
generalPath.curveTo(33.08234f, 31.48032f, 33.624012f, 30.689684f, 34.174286f, 30.075878f);
generalPath.curveTo(34.725376f, 29.46116f, 35.367374f, 28.799269f, 36.768036f, 28.732128f);
generalPath.closePath();
shape = generalPath;
paint = new Color(238, 238, 236, 255);
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
        return 0.0;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 3.9062087535858154;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 47.70006561279297;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 42.063453674316406;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private applications_graphics_2() {
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
       applications_graphics_2 base = new applications_graphics_2();
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
       applications_graphics_2 base = new applications_graphics_2();
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
        return applications_graphics_2::new;
    }
}

