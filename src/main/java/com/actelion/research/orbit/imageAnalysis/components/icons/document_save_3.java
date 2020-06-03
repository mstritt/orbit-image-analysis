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
public class document_save_3 implements ResizableIcon {
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
g.transform(new AffineTransform(0.024114049971103668f, 0.0f, 0.0f, 0.019292019307613373f, 45.48952865600586f, 41.752281188964844f));
// _0_0_0
g.setComposite(AlphaComposite.getInstance(3, 0.40206185f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0
shape = new Rectangle2D.Double(-1559.2523193359375, -150.6968536376953, 1339.633544921875, 478.357177734375);
paint = new LinearGradientPaint(new Point2D.Double(302.8571472167969, 366.64788818359375), new Point2D.Double(302.8571472167969, 609.5050659179688), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(0, 0, 0, 0),new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(2.7743890285491943f, 0.0f, 0.0f, 1.9697060585021973f, -1892.178955078125f, -872.8853759765625f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.40206185f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-219.61876f, -150.68037f);
generalPath.curveTo(-219.61876f, -150.68037f, -219.61876f, 327.65042f, -219.61876f, 327.65042f);
generalPath.curveTo(-76.74459f, 328.55087f, 125.78146f, 220.48074f, 125.78138f, 88.45424f);
generalPath.curveTo(125.78138f, -43.572304f, -33.655437f, -150.68036f, -219.61876f, -150.68037f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(605.7142944335938, 486.64788818359375), 117.14286f, new Point2D.Double(605.7142944335938, 486.64788818359375), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(2.7743890285491943f, 0.0f, 0.0f, 1.9697060585021973f, -1891.633056640625f, -872.8853759765625f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.40206185f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-1559.2523f, -150.68037f);
generalPath.curveTo(-1559.2523f, -150.68037f, -1559.2523f, 327.65042f, -1559.2523f, 327.65042f);
generalPath.curveTo(-1702.1265f, 328.55087f, -1904.6525f, 220.48074f, -1904.6525f, 88.45424f);
generalPath.curveTo(-1904.6525f, -43.572304f, -1745.2157f, -150.68036f, -1559.2523f, -150.68037f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(605.7142944335938, 486.64788818359375), 117.14286f, new Point2D.Double(605.7142944335938, 486.64788818359375), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-2.7743890285491943f, 0.0f, 0.0f, 1.9697060585021973f, 112.76229858398438f, -872.8853759765625f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
paint = new Color(83, 83, 83, 255);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(11.28569f, 13.087628f);
generalPath.curveTo(10.66069f, 13.087628f, 10.254441f, 13.377808f, 10.004442f, 13.931381f);
generalPath.curveTo(10.004441f, 13.931381f, 3.5356915f, 31.034939f, 3.5356915f, 31.034939f);
generalPath.curveTo(3.5356915f, 31.034939f, 3.2856915f, 31.706497f, 3.2856915f, 32.81619f);
generalPath.curveTo(3.2856915f, 32.81619f, 3.2856915f, 42.466156f, 3.2856915f, 42.466156f);
generalPath.curveTo(3.2856915f, 43.54877f, 3.943477f, 44.09116f, 4.9419417f, 44.091156f);
generalPath.lineTo(43.50444f, 44.091156f);
generalPath.curveTo(44.489292f, 44.091156f, 45.09819f, 43.372974f, 45.09819f, 42.247406f);
generalPath.lineTo(45.09819f, 32.59744f);
generalPath.curveTo(45.09819f, 32.59744f, 45.20415f, 31.827015f, 45.00444f, 31.284939f);
generalPath.lineTo(38.28569f, 14.087631f);
generalPath.curveTo(38.101166f, 13.575725f, 37.648785f, 13.099533f, 37.16069f, 13.087628f);
generalPath.lineTo(11.28569f, 13.087628f);
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
generalPath.moveTo(3.2735915f, 32.12181f);
generalPath.lineTo(4.0381937f, 31.429598f);
generalPath.lineTo(41.647884f, 31.492098f);
generalPath.lineTo(45.11029f, 31.809395f);
generalPath.lineTo(45.11029f, 42.24793f);
generalPath.curveTo(45.11029f, 43.373497f, 44.503273f, 44.09126f, 43.518417f, 44.09126f);
generalPath.lineTo(4.9354315f, 44.09126f);
generalPath.curveTo(3.9369667f, 44.09126f, 3.2735915f, 43.549206f, 3.2735915f, 42.466595f);
generalPath.lineTo(3.2735915f, 32.12181f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(7.604620456695557, 28.481176376342773), new Point2D.Double(36.183067321777344, 40.94393539428711), new float[] {0.0f,1.0f}, new Color[] {new Color(187, 187, 187, 255),new Color(159, 159, 159, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 5.125f));
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
generalPath.moveTo(3.5490842f, 31.039404f);
generalPath.curveTo(2.8347986f, 32.50369f, 3.5484686f, 33.432262f, 4.5847983f, 33.432262f);
generalPath.curveTo(4.5847983f, 33.432262f, 43.584797f, 33.432262f, 43.584797f, 33.432262f);
generalPath.curveTo(44.703842f, 33.40845f, 45.430035f, 32.420357f, 45.013367f, 31.289404f);
generalPath.lineTo(38.299084f, 14.078704f);
generalPath.curveTo(38.11456f, 13.566798f, 37.64432f, 13.090606f, 37.156223f, 13.078701f);
generalPath.lineTo(11.299083f, 13.078701f);
generalPath.curveTo(10.674083f, 13.078701f, 10.263369f, 13.382274f, 10.01337f, 13.935847f);
generalPath.curveTo(10.01337f, 13.935847f, 3.5490842f, 31.039404f, 3.5490842f, 31.039404f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(15.571491241455078, 2.9585189819335938), 20.935818f, new Point2D.Double(15.571491241455078, 2.9585189819335938), new float[] {0.0f,1.0f}, new Color[] {new Color(228, 228, 228, 255),new Color(211, 211, 211, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.2862420082092285f, 0.7816979885101318f, -0.710781991481781f, 1.169551968574524f, -2.3543479442596436f, 0.24814000725746155f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
shape = new Rectangle2D.Double(7.857995986938477, 36.2991828918457, 17.625, 5.5625);
paint = new LinearGradientPaint(new Point2D.Double(7.0625, 35.28125), new Point2D.Double(24.6875, 35.28125), new float[] {0.0f,1.0f}, new Color[] {new Color(131, 131, 131, 255),new Color(187, 187, 187, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.7954930067062378f, 3.799180030822754f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.81142855f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(7.857995f, 41.86168f);
generalPath.curveTo(7.857995f, 41.86168f, 7.857995f, 37.850197f, 7.857995f, 37.850197f);
generalPath.curveTo(9.693522f, 41.029423f, 16.154486f, 41.86168f, 20.795492f, 41.86168f);
generalPath.curveTo(20.795492f, 41.86168f, 7.857995f, 41.86168f, 7.857995f, 41.86168f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(12.277412414550781, 37.205810546875), new Point2D.Double(12.221822738647461, 33.7586669921875), new float[] {0.0f,1.0f}, new Color[] {new Color(238, 238, 238, 255),new Color(238, 238, 238, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 5.125f));
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
generalPath.moveTo(44.79616f, 30.753689f);
generalPath.curveTo(44.859684f, 32.003662f, 44.38216f, 33.069527f, 43.474045f, 33.09744f);
generalPath.curveTo(43.474045f, 33.09744f, 5.3553295f, 33.09744f, 5.3553295f, 33.09744f);
generalPath.curveTo(4.0660977f, 33.09744f, 3.4875937f, 32.77249f, 3.271279f, 32.22938f);
generalPath.curveTo(3.3630404f, 33.173714f, 4.0970964f, 33.87869f, 5.3553295f, 33.87869f);
generalPath.curveTo(5.3553295f, 33.87869f, 43.474045f, 33.87869f, 43.474045f, 33.87869f);
generalPath.curveTo(44.550053f, 33.845615f, 45.226852f, 32.454662f, 44.82621f, 30.883898f);
generalPath.lineTo(44.79616f, 30.753689f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.69142854f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(10.96875f, 15.28125f);
generalPath.curveTo(10.922675f, 15.481571f, 10.78125f, 15.668047f, 10.78125f, 15.875f);
generalPath.curveTo(10.78125f, 16.823605f, 11.37223f, 17.664474f, 12.125f, 18.46875f);
generalPath.curveTo(12.365268f, 18.314674f, 12.490117f, 18.114342f, 12.75f, 17.96875f);
generalPath.curveTo(11.809691f, 17.152746f, 11.196604f, 16.252169f, 10.96875f, 15.28125f);
generalPath.closePath();
generalPath.moveTo(37.625f, 15.28125f);
generalPath.curveTo(37.396275f, 16.250866f, 36.78299f, 17.153675f, 35.84375f, 17.96875f);
generalPath.curveTo(36.117893f, 18.122332f, 36.247738f, 18.33699f, 36.5f, 18.5f);
generalPath.curveTo(37.257263f, 17.693344f, 37.8125f, 16.826956f, 37.8125f, 15.875f);
generalPath.curveTo(37.8125f, 15.668047f, 37.670906f, 15.481571f, 37.625f, 15.28125f);
generalPath.closePath();
generalPath.moveTo(39.8125f, 23.71875f);
generalPath.curveTo(39.198708f, 27.758862f, 32.513885f, 30.96875f, 24.28125f, 30.96875f);
generalPath.curveTo(16.068996f, 30.968752f, 9.421101f, 27.775965f, 8.78125f, 23.75f);
generalPath.curveTo(8.748893f, 23.947132f, 8.65625f, 24.141882f, 8.65625f, 24.34375f);
generalPath.curveTo(8.65625f, 28.661697f, 15.645354f, 32.1875f, 24.28125f, 32.1875f);
generalPath.curveTo(32.917145f, 32.1875f, 39.9375f, 28.661697f, 39.9375f, 24.34375f);
generalPath.curveTo(39.9375f, 24.130827f, 39.84845f, 23.926394f, 39.8125f, 23.71875f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(23.688077926635742, 11.318835258483887), new Point2D.Double(23.688077926635742, 26.3571834564209), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 65),new Color(255, 255, 255, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 5.125f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.08838842809200287f, 5.3017802238464355f));
// _0_0_8
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(8.57367f, 25.593554f);
generalPath.curveTo(8.575866f, 25.957785f, 8.315223f, 26.295048f, 7.890435f, 26.477634f);
generalPath.curveTo(7.4656477f, 26.660223f, 6.9416537f, 26.660223f, 6.516866f, 26.477634f);
generalPath.curveTo(6.0920787f, 26.295048f, 5.8314357f, 25.957785f, 5.833631f, 25.593554f);
generalPath.curveTo(5.8314357f, 25.229322f, 6.0920787f, 24.89206f, 6.516866f, 24.709473f);
generalPath.curveTo(6.9416537f, 24.526884f, 7.4656477f, 24.526884f, 7.890435f, 24.709473f);
generalPath.curveTo(8.315223f, 24.89206f, 8.575866f, 25.229322f, 8.57367f, 25.593554f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 117);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 33.96704864501953f, 5.213389873504639f));
// _0_0_9
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(8.57367f, 25.593554f);
generalPath.curveTo(8.575866f, 25.957785f, 8.315223f, 26.295048f, 7.890435f, 26.477634f);
generalPath.curveTo(7.4656477f, 26.660223f, 6.9416537f, 26.660223f, 6.516866f, 26.477634f);
generalPath.curveTo(6.0920787f, 26.295048f, 5.8314357f, 25.957785f, 5.833631f, 25.593554f);
generalPath.curveTo(5.8314357f, 25.229322f, 6.0920787f, 24.89206f, 6.516866f, 24.709473f);
generalPath.curveTo(6.9416537f, 24.526884f, 7.4656477f, 24.526884f, 7.890435f, 24.709473f);
generalPath.curveTo(8.315223f, 24.89206f, 8.575866f, 25.229322f, 8.57367f, 25.593554f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 117);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10
paint = new LinearGradientPaint(new Point2D.Double(12.37835693359375, 4.433135986328125), new Point2D.Double(44.096099853515625, 47.620635986328125), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 5.125f));
stroke = new BasicStroke(1.0000002f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(11.642515f, 13.540723f);
generalPath.curveTo(11.040823f, 13.540723f, 10.649724f, 13.820081f, 10.409049f, 14.35301f);
generalPath.curveTo(10.409048f, 14.35301f, 3.994034f, 30.943731f, 3.994034f, 30.943731f);
generalPath.curveTo(3.994034f, 30.943731f, 3.7533574f, 31.590246f, 3.7533574f, 32.658554f);
generalPath.curveTo(3.7533574f, 32.658554f, 3.7533574f, 41.94865f, 3.7533574f, 41.94865f);
generalPath.curveTo(3.7533574f, 43.30339f, 4.1974134f, 43.57555f, 5.3478413f, 43.57555f);
generalPath.lineTo(43.034744f, 43.57555f);
generalPath.curveTo(44.357872f, 43.57555f, 44.56906f, 43.25915f, 44.56906f, 41.738056f);
generalPath.lineTo(44.56906f, 32.447964f);
generalPath.curveTo(44.56906f, 32.447964f, 44.67107f, 31.70627f, 44.478806f, 31.184408f);
generalPath.lineTo(37.885616f, 14.378434f);
generalPath.curveTo(37.707973f, 13.885617f, 37.334965f, 13.552184f, 36.86507f, 13.540723f);
generalPath.lineTo(11.642515f, 13.540723f);
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
paint = new Color(255, 255, 255, 108);
stroke = new BasicStroke(1.0000005f,2,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(40.5f, 36.554165f);
generalPath.lineTo(40.5f, 41.5751f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_12
paint = new Color(255, 255, 255, 108);
stroke = new BasicStroke(1.0000005f,2,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(38.5f, 36.61394f);
generalPath.lineTo(38.5f, 41.634876f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_13
paint = new Color(255, 255, 255, 108);
stroke = new BasicStroke(1.0000005f,2,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(36.5f, 36.61394f);
generalPath.lineTo(36.5f, 41.634876f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_14
paint = new Color(255, 255, 255, 108);
stroke = new BasicStroke(1.0000005f,2,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(34.5f, 36.61394f);
generalPath.lineTo(34.5f, 41.634876f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15
paint = new Color(255, 255, 255, 108);
stroke = new BasicStroke(1.0000005f,2,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(32.5f, 36.61394f);
generalPath.lineTo(32.5f, 41.634876f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_16
paint = new Color(255, 255, 255, 108);
stroke = new BasicStroke(1.0000005f,2,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(30.5f, 36.61394f);
generalPath.lineTo(30.5f, 41.634876f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.09714284f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.0000005f,2,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(39.5f, 36.604065f);
generalPath.lineTo(39.5f, 41.625f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.09714284f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_18
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.0000005f,2,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.5f, 36.66384f);
generalPath.lineTo(37.5f, 41.684776f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.09714284f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_19
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.0000005f,2,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(35.5f, 36.66384f);
generalPath.lineTo(35.5f, 41.684776f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.09714284f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_20
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.0000005f,2,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(33.5f, 36.66384f);
generalPath.lineTo(33.5f, 41.684776f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.09714284f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_21
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.0000005f,2,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(31.5f, 36.66384f);
generalPath.lineTo(31.5f, 41.684776f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.44f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_22
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(7.875f, 36.3125f);
generalPath.lineTo(7.875f, 41.84375f);
generalPath.lineTo(20.4375f, 41.84375f);
generalPath.lineTo(8.21875f, 41.5f);
generalPath.lineTo(7.875f, 36.3125f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.20571427f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.037814974784851f, 0.0f, 0.0f, 1.0607470273971558f, -1.6328779458999634f, 3.030369997024536f));
// _0_0_23
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(39.875f, 19.5625f);
generalPath.curveTo(39.898838f, 21.958838f, 37.068905f, 24.177746f, 32.456768f, 25.379019f);
generalPath.curveTo(27.844637f, 26.580294f, 22.155363f, 26.580294f, 17.54323f, 25.379019f);
generalPath.curveTo(12.931097f, 24.177746f, 10.101163f, 21.958838f, 10.125f, 19.5625f);
generalPath.curveTo(10.101163f, 17.166162f, 12.931097f, 14.947254f, 17.54323f, 13.745981f);
generalPath.curveTo(22.155363f, 12.544707f, 27.844637f, 12.544707f, 32.456768f, 13.745981f);
generalPath.curveTo(37.068905f, 14.947254f, 39.898838f, 17.166162f, 39.875f, 19.5625f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(33.431175231933594, 31.96477699279785), new Point2D.Double(21.747974395751953, 11.780678749084473), new float[] {0.0f,0.5f,0.75f,0.84166664f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(230, 230, 230, 255),new Color(255, 255, 255, 255),new Color(225, 225, 225, 255),new Color(255, 255, 255, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_1
g.setComposite(AlphaComposite.getInstance(3, 0.14117648f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.1301900148391724f, 1.178179022145491E-16f, 7.91854375568848E-17f, -0.7596009969711304f, -3.9097249507904053f, 53.6655387878418f));
// _0_1_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(40.48186f, 36.421127f);
generalPath.curveTo(40.50693f, 39.429993f, 37.530556f, 42.216076f, 32.67976f, 43.724407f);
generalPath.curveTo(27.828962f, 45.23274f, 21.845287f, 45.23274f, 16.99449f, 43.724407f);
generalPath.curveTo(12.143692f, 42.216076f, 9.167317f, 39.429993f, 9.192389f, 36.421127f);
generalPath.curveTo(9.167317f, 33.412262f, 12.143692f, 30.626177f, 16.99449f, 29.117847f);
generalPath.curveTo(21.845287f, 27.609516f, 27.828962f, 27.609516f, 32.67976f, 29.117847f);
generalPath.curveTo(37.530556f, 30.626177f, 40.50693f, 33.412262f, 40.48186f, 36.421127f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(24.837125778198242, 36.42112731933594), 15.644737f, new Point2D.Double(24.837125778198242, 36.42112731933594), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, -7.816466730460888E-32f, -1.1324090298499951E-32f, 0.5367230176925659f, -5.89796224012562E-14f, 16.87306022644043f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_1_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(3.2034502f, 25.835194f);
generalPath.curveTo(2.1729476f, -5.385337f, 28.741615f, -0.4511153f, 28.582417f, 15.788689f);
generalPath.lineTo(35.89533f, 15.788689f);
generalPath.lineTo(24.517653f, 28.774672f);
generalPath.lineTo(12.585426f, 15.788689f);
generalPath.curveTo(12.585426f, 15.788689f, 20.12686f, 15.788689f, 20.12686f, 15.788689f);
generalPath.curveTo(20.583921f, 4.8193226f, 3.4092324f, 1.6100346f, 3.2034502f, 25.835194f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(14.751648902893066, 15.86843204498291), new Point2D.Double(8.895328521728516, 16.743431091308594), new float[] {0.0f,1.0f}, new Color[] {new Color(52, 101, 164, 255),new Color(52, 101, 164, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
paint = new LinearGradientPaint(new Point2D.Double(12.25, 18.25), new Point2D.Double(7.0, 21.118431091308594), new float[] {0.0f,1.0f}, new Color[] {new Color(32, 74, 135, 255),new Color(32, 74, 135, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(0.9999998f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(3.2034502f, 25.835194f);
generalPath.curveTo(2.1729476f, -5.385337f, 28.741615f, -0.4511153f, 28.582417f, 15.788689f);
generalPath.lineTo(35.89533f, 15.788689f);
generalPath.lineTo(24.517653f, 28.774672f);
generalPath.lineTo(12.585426f, 15.788689f);
generalPath.curveTo(12.585426f, 15.788689f, 20.12686f, 15.788689f, 20.12686f, 15.788689f);
generalPath.curveTo(20.583921f, 4.8193226f, 3.4092324f, 1.6100346f, 3.2034502f, 25.835194f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.4715909f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_1_2
paint = new LinearGradientPaint(new Point2D.Double(33.059906005859375, 27.39411735534668), new Point2D.Double(12.624337196350098, 12.583768844604492), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9141139984130859f, 1.412791001969375E-16f, -1.412791001969375E-16f, 0.9141139984130859f, -3.8686978816986084f, -2.706902027130127f));
stroke = new BasicStroke(0.99999934f,0,0,10.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(7.6642103f, 9.104105f);
generalPath.curveTo(12.40638f, -0.0400306f, 28.122335f, 2.7175443f, 27.761604f, 16.579393f);
generalPath.lineTo(34.078976f, 16.579393f);
generalPath.curveTo(34.078976f, 16.579393f, 24.513151f, 27.53677f, 24.513151f, 27.53677f);
generalPath.lineTo(14.41668f, 16.579393f);
generalPath.curveTo(14.41668f, 16.579393f, 20.87332f, 16.579393f, 20.87332f, 16.579393f);
generalPath.curveTo(21.144976f, 5.0041614f, 10.922265f, 5.5345216f, 7.6642103f, 9.104105f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.49431816f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_1_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(34.767155f, 16.211613f);
generalPath.lineTo(32.782978f, 18.757322f);
generalPath.curveTo(27.372948f, 17.24103f, 24.89683f, 21.486664f, 17.109283f, 20.489113f);
generalPath.lineTo(13.247998f, 16.080076f);
generalPath.lineTo(20.434467f, 16.162863f);
generalPath.curveTo(20.48322f, 4.3164573f, 8.34431f, 4.998966f, 5.0292664f, 13.627829f);
generalPath.curveTo(8.83722f, -1.2611216f, 27.893316f, 0.8064118f, 28.28332f, 16.114113f);
generalPath.lineTo(34.767155f, 16.211613f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(23.44707679748535, 6.457674503326416), 19.0625f, new Point2D.Double(23.44707679748535, 6.457674503326416), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-1.3144710063934326f, -0.010063120163977146f, -0.010229639708995819f, 1.3362209796905518f, 46.2210807800293f, -4.909886837005615f));
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
        return 0.0;
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
		return 48.0;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private document_save_3() {
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
       document_save_3 base = new document_save_3();
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
       document_save_3 base = new document_save_3();
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
        return document_save_3::new;
    }
}

