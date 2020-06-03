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
public class edit_delete_6 implements ResizableIcon {
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
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 214.92588806152344f, -100.31047821044922f));
// _0_0_0
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 214.92588806152344f, -100.31047821044922f));
// _0_0_1
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
generalPath.moveTo(-259.40213f, 132.75623f);
generalPath.lineTo(-259.40213f, 129.96152f);
generalPath.lineTo(-259.40213f, 132.75623f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 193);
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
generalPath.moveTo(215.3609f, -31.057518f);
generalPath.lineTo(215.3609f, -33.852226f);
generalPath.lineTo(215.3609f, -31.057518f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 193);
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
generalPath.moveTo(249.73645f, 22.336163f);
generalPath.lineTo(249.73645f, 20.809425f);
generalPath.lineTo(249.73645f, 22.336163f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 193);
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
generalPath.moveTo(36.38397f, 16.014486f);
generalPath.curveTo(35.368416f, 16.022627f, 34.396137f, 16.426825f, 33.67413f, 17.14105f);
generalPath.lineTo(17.141043f, 33.674137f);
generalPath.curveTo(15.619653f, 35.196144f, 15.619658f, 37.66315f, 17.141039f, 39.18516f);
generalPath.lineTo(41.925446f, 64.000015f);
generalPath.lineTo(17.141043f, 88.81487f);
generalPath.curveTo(15.619658f, 90.336876f, 15.619658f, 92.80389f, 17.141043f, 94.32589f);
generalPath.lineTo(33.67413f, 110.85897f);
generalPath.curveTo(35.196133f, 112.38036f, 37.663143f, 112.38036f, 39.185158f, 110.85898f);
generalPath.lineTo(64.00001f, 86.07458f);
generalPath.lineTo(88.81486f, 110.85898f);
generalPath.curveTo(90.33687f, 112.38036f, 92.80388f, 112.38036f, 94.32588f, 110.85897f);
generalPath.lineTo(110.85897f, 94.32589f);
generalPath.curveTo(112.38035f, 92.80389f, 112.38035f, 90.336876f, 110.85897f, 88.814865f);
generalPath.lineTo(86.07457f, 64.000015f);
generalPath.lineTo(110.85898f, 39.185165f);
generalPath.curveTo(112.38035f, 37.66315f, 112.38035f, 35.196144f, 110.85897f, 33.674133f);
generalPath.lineTo(94.32589f, 17.141047f);
generalPath.curveTo(92.80388f, 15.619666f, 90.33687f, 15.619662f, 88.814865f, 17.14105f);
generalPath.lineTo(64.00001f, 41.925453f);
generalPath.lineTo(39.18515f, 17.141047f);
generalPath.curveTo(38.440693f, 16.404446f, 37.43113f, 15.998429f, 36.38397f, 16.014486f);
generalPath.closePath();
generalPath.moveTo(66.770744f, 77.79281f);
generalPath.curveTo(66.03863f, 77.05285f, 65.04094f, 76.636475f, 64.00001f, 76.636475f);
generalPath.curveTo(62.959076f, 76.636475f, 61.961384f, 77.05284f, 61.22927f, 77.792816f);
generalPath.lineTo(66.770744f, 77.79281f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(58.743717193603516, 78.41134643554688), new Point2D.Double(58.743717193603516, -15.688620567321777), new float[] {0.0f,1.0f}, new Color[] {new Color(129, 0, 0, 255),new Color(197, 0, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9743254780769348f, 0.0f, 0.0f, 0.9743254780769348f, 5.540477275848389f, 5.540485382080078f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9743254780769348f, 0.0f, 0.0f, 0.9743254780769348f, 99.29014587402344f, 5.540480613708496f));
// _0_0_6
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-62.57895f, 106.7868f);
generalPath.lineTo(-36.416f, 79.91674f);
generalPath.lineTo(-10.606602f, 106.43324f);
generalPath.lineTo(-36.416f, 66.12816f);
generalPath.lineTo(-62.57895f, 106.7868f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.49373052f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-62.57895f, 106.7868f);
generalPath.lineTo(-36.416f, 79.91674f);
generalPath.lineTo(-10.606602f, 106.43324f);
generalPath.lineTo(-36.416f, 66.12816f);
generalPath.lineTo(-62.57895f, 106.7868f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.49812737f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.0f, 1.8163775205612183f, -1.8163775205612183f, 0.0f, 130.5519561767578f, 34.179954528808594f));
// _0_0_7
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(31.7f, 16.0f);
generalPath.lineTo(34.575f, 12.625f);
generalPath.curveTo(33.523796f, 10.929242f, 30.639864f, 10.336982f, 28.6375f, 12.3125f);
generalPath.lineTo(31.45f, 15.6875f);
generalPath.lineTo(31.7f, 16.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(26.09113311767578, 14.856743812561035), new Point2D.Double(31.500688552856445, 14.856743812561035), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0975950956344604f, 0.0f, 0.0f, 0.9110828042030334f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.79026216f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.7938181161880493f, 0.0f, 0.0f, -1.7938181161880493f, -20.276758193969727f, 130.9440460205078f));
// _0_0_8
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(31.7f, 16.0f);
generalPath.lineTo(34.575f, 12.625f);
generalPath.curveTo(33.523796f, 10.929242f, 30.639864f, 10.336982f, 28.6375f, 12.3125f);
generalPath.lineTo(31.45f, 15.6875f);
generalPath.lineTo(31.7f, 16.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(26.09113311767578, 14.856743812561035), new Point2D.Double(31.500688552856445, 14.856743812561035), new float[] {0.0f,1.0f}, new Color[] {new Color(118, 92, 68, 255),new Color(118, 92, 68, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0975950956344604f, 0.0f, 0.0f, 0.9110828042030334f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.49812737f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.0f, 1.6448194980621338f, 1.6448194980621338f, 0.0f, -0.724353015422821f, 39.5847053527832f));
// _0_0_9
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(31.7f, 16.0f);
generalPath.lineTo(34.575f, 12.625f);
generalPath.curveTo(33.523796f, 10.929242f, 30.639864f, 10.336982f, 28.6375f, 12.3125f);
generalPath.lineTo(31.45f, 15.6875f);
generalPath.lineTo(31.7f, 16.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(304.8866271972656, 385.86126708984375), new Point2D.Double(345.6203918457031, 384.62384033203125), new float[] {0.0f,1.0f}, new Color[] {new Color(118, 92, 68, 255),new Color(118, 92, 68, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.92134833f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(91.55809f, 23.43728f);
generalPath.lineTo(64.00001f, 50.995365f);
generalPath.lineTo(36.441925f, 23.437284f);
generalPath.lineTo(23.437277f, 36.441933f);
generalPath.lineTo(50.995358f, 64.000015f);
generalPath.lineTo(23.43727f, 91.558105f);
generalPath.lineTo(36.441925f, 104.56274f);
generalPath.lineTo(64.00001f, 77.00466f);
generalPath.lineTo(91.55809f, 104.56274f);
generalPath.lineTo(104.56273f, 91.5581f);
generalPath.lineTo(77.004654f, 64.000015f);
generalPath.lineTo(104.56273f, 36.44193f);
generalPath.lineTo(91.55809f, 23.43728f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(55.007041931152344, 88.46097564697266), new Point2D.Double(55.007041931152344, 36.65576934814453), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 0, 0, 255),new Color(127, 0, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9743254780769348f, 0.0f, 0.0f, 0.9743254780769348f, 5.540477275848389f, 5.540485382080078f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.79026216f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.6448194980621338f, 0.0f, 0.0f, -1.6448194980621338f, -53.80087661743164f, 129.53660583496094f));
// _0_0_11
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(88.7f, 16.0f);
generalPath.lineTo(91.575f, 12.625f);
generalPath.curveTo(90.523796f, 10.929242f, 87.63986f, 10.336982f, 85.6375f, 12.3125f);
generalPath.lineTo(88.45f, 15.6875f);
generalPath.lineTo(88.7f, 16.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(31.90625, 13.510335922241211), new Point2D.Double(34.87510681152344, 13.510335922241211), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 135, 135, 255),new Color(255, 135, 135, 0)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 56.70000076293945f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9743254780769348f, 0.0f, 0.0f, -0.9743254780769348f, 99.29014587402344f, 122.00005340576172f));
// _0_0_12
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-62.57895f, 106.7868f);
generalPath.lineTo(-36.416f, 79.91674f);
generalPath.lineTo(-10.606602f, 106.43324f);
generalPath.lineTo(-36.416f, 66.12816f);
generalPath.lineTo(-62.57895f, 106.7868f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(-36.592777252197266, 90.07295227050781), 25.986174f, new Point2D.Double(-36.592777252197266, 90.07295227050781), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.4576061964035034f, 0.0f, 0.0f, 0.7823129892349243f, -19.847694396972656f, 18.820669174194336f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.79026216f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.4958208799362183f, 0.0f, 0.0f, 1.4958208799362183f, -10.888668060302734f, 0.6143956184387207f));
// _0_0_13
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(31.7f, 16.0f);
generalPath.lineTo(34.575f, 12.625f);
generalPath.curveTo(33.523796f, 10.929242f, 30.639864f, 10.336982f, 28.6375f, 12.3125f);
generalPath.lineTo(31.45f, 15.6875f);
generalPath.lineTo(31.7f, 16.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(31.90625, 13.510335922241211), new Point2D.Double(34.87510681152344, 13.510335922241211), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(121, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -0.30000001192092896f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.79026216f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.5356935262680054f, 0.0f, 0.0f, 1.5356935262680054f, -44.14278793334961f, 0.23775550723075867f));
// _0_0_14
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(88.7f, 16.0f);
generalPath.lineTo(91.575f, 12.625f);
generalPath.curveTo(90.523796f, 10.929242f, 87.63986f, 10.336982f, 85.6375f, 12.3125f);
generalPath.lineTo(88.45f, 15.6875f);
generalPath.lineTo(88.7f, 16.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(31.90625, 13.510335922241211), new Point2D.Double(34.87510681152344, 13.510335922241211), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(121, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 56.70000076293945f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.92134833f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9743254780769348f, 0.0f, 0.0f, 0.9743254780769348f, 5.540477275848389f, 5.540485382080078f));
// _0_0_15
paint = new LinearGradientPaint(new Point2D.Double(59.999996185302734, 92.97308349609375), new Point2D.Double(57.43444061279297, 55.07938003540039), new float[] {0.0f,0.25f,0.5f,1.0f}, new Color[] {new Color(255, 245, 228, 255),new Color(255, 236, 208, 255),new Color(255, 211, 144, 255),new Color(255, 196, 106, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(1.5395266f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(88.28427f, 18.368397f);
generalPath.lineTo(60.0f, 46.652664f);
generalPath.lineTo(31.715729f, 18.368397f);
generalPath.lineTo(18.368397f, 31.715729f);
generalPath.lineTo(46.652664f, 60.0f);
generalPath.lineTo(18.368397f, 88.28427f);
generalPath.lineTo(31.715729f, 101.63161f);
generalPath.lineTo(60.0f, 73.347336f);
generalPath.lineTo(88.28427f, 101.63161f);
generalPath.lineTo(101.63161f, 88.28427f);
generalPath.lineTo(73.347336f, 60.0f);
generalPath.lineTo(101.63161f, 31.715729f);
generalPath.lineTo(88.28427f, 18.368397f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
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
generalPath.moveTo(36.427155f, 23.374601f);
generalPath.lineTo(35.696407f, 24.105347f);
generalPath.lineTo(23.424273f, 36.377483f);
generalPath.lineTo(36.18357f, 24.592505f);
generalPath.lineTo(64.00132f, 50.99825f);
generalPath.lineTo(91.29385f, 24.592506f);
generalPath.lineTo(102.2263f, 35.52495f);
generalPath.curveTo(102.13068f, 36.019463f, 102.00159f, 36.499084f, 101.86092f, 36.98643f);
generalPath.lineTo(90.01592f, 50.780094f);
generalPath.curveTo(79.33311f, 56.105892f, 64.437355f, 61.359222f, 48.422672f, 61.37588f);
generalPath.lineTo(48.696697f, 61.649906f);
generalPath.curveTo(49.156178f, 61.65532f, 49.604874f, 61.68036f, 50.06685f, 61.680363f);
generalPath.curveTo(66.1296f, 61.680363f, 77.17473f, 58.372505f, 87.88458f, 53.033222f);
generalPath.lineTo(103.62689f, 37.29091f);
generalPath.curveTo(103.69171f, 37.066345f, 103.75182f, 36.844555f, 103.80958f, 36.62106f);
generalPath.curveTo(103.87717f, 36.35953f, 103.94071f, 36.09608f, 103.99227f, 35.829426f);
generalPath.lineTo(91.53744f, 23.374601f);
generalPath.lineTo(90.806694f, 24.105347f);
generalPath.lineTo(64.00132f, 50.99825f);
generalPath.lineTo(36.427155f, 23.374601f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(68.3130111694336, 109.97648620605469), new Point2D.Double(51.54484939575195, 32.7508544921875), new float[] {0.0f,1.0f}, new Color[] {new Color(244, 245, 248, 255),new Color(253, 253, 254, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.38126802444458f, 0.0f, 0.0f, 0.6872742772102356f, 5.540477275848389f, 5.540485382080078f));
g.setPaint(paint);
g.fill(shape);
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
generalPath.moveTo(36.444862f, 23.44199f);
generalPath.lineTo(23.441982f, 36.44487f);
generalPath.lineTo(48.714417f, 61.7173f);
generalPath.curveTo(49.17388f, 61.72271f, 49.62258f, 61.747746f, 50.08456f, 61.74775f);
generalPath.curveTo(66.14731f, 61.747746f, 77.19244f, 58.43989f, 87.90229f, 53.10061f);
generalPath.lineTo(103.64461f, 37.358307f);
generalPath.curveTo(103.78528f, 36.870953f, 103.91436f, 36.391327f, 104.00998f, 35.896812f);
generalPath.lineTo(91.555145f, 23.44199f);
generalPath.lineTo(64.00001f, 50.99713f);
generalPath.lineTo(36.444862f, 23.44199f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(47.26414108276367, 21.73845672607422), new Point2D.Double(47.26414108276367, 70.35726928710938), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 135, 135, 255),new Color(255, 135, 135, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9743254780769348f, 0.0f, 0.0f, 0.9743254780769348f, 5.540477275848389f, 5.540485382080078f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_18
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(36.427155f, 23.374601f);
generalPath.lineTo(35.696407f, 24.105347f);
generalPath.lineTo(23.424273f, 36.377483f);
generalPath.lineTo(36.18357f, 24.592505f);
generalPath.lineTo(64.00773f, 52.836414f);
generalPath.lineTo(64.00132f, 50.99825f);
generalPath.lineTo(64.01101f, 52.82226f);
generalPath.lineTo(91.29385f, 24.592506f);
generalPath.lineTo(102.2263f, 35.52495f);
generalPath.curveTo(102.13068f, 36.019463f, 102.00159f, 36.499084f, 101.86092f, 36.98643f);
generalPath.lineTo(90.01592f, 50.780094f);
generalPath.curveTo(79.33311f, 56.105892f, 64.437355f, 61.359222f, 48.422672f, 61.37588f);
generalPath.lineTo(48.696697f, 61.649906f);
generalPath.curveTo(49.156178f, 61.65532f, 49.604874f, 61.68036f, 50.06685f, 61.680363f);
generalPath.curveTo(66.1296f, 61.680363f, 77.17473f, 58.372505f, 87.88458f, 53.033222f);
generalPath.lineTo(103.62689f, 37.29091f);
generalPath.curveTo(103.69171f, 37.066345f, 103.75182f, 36.844555f, 103.80958f, 36.62106f);
generalPath.curveTo(103.87717f, 36.35953f, 103.94071f, 36.09608f, 103.99227f, 35.829426f);
generalPath.lineTo(91.53744f, 23.374601f);
generalPath.lineTo(90.806694f, 24.105347f);
generalPath.lineTo(64.00132f, 50.99825f);
generalPath.lineTo(36.427155f, 23.374601f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(57.654170989990234, 71.82486724853516), new Point2D.Double(56.770992279052734, 20.362558364868164), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 0),new Color(255, 255, 255, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9743254780769348f, 0.0f, 0.0f, 0.9743254780769348f, 5.55265474319458f, 6.758389949798584f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_1
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
	private edit_delete_6() {
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
       edit_delete_6 base = new edit_delete_6();
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
       edit_delete_6 base = new edit_delete_6();
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
        return edit_delete_6::new;
    }
}

