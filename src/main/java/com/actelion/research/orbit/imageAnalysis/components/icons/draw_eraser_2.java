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
public class draw_eraser_2 implements ResizableIcon {
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
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -1427.5223388671875f, -142.60169982910156f));
// _0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(1478.415f, 145.63165f);
generalPath.lineTo(1478.415f, 142.83694f);
generalPath.lineTo(1478.415f, 145.63165f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.5491803f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(1491.4286f, 246.9441f);
generalPath.curveTo(1473.5385f, 246.9441f, 1457.3771f, 248.30249f, 1445.7723f, 250.5066f);
generalPath.curveTo(1472.5476f, 254.20296f, 1496.3416f, 253.78174f, 1517.6473f, 248.0066f);
generalPath.curveTo(1509.6405f, 247.33511f, 1500.7783f, 246.9441f, 1491.4286f, 246.9441f);
generalPath.closePath();
generalPath.moveTo(1444.7723f, 250.72536f);
generalPath.curveTo(1434.1008f, 252.84846f, 1427.5223f, 255.68665f, 1427.5223f, 258.8191f);
generalPath.curveTo(1427.5223f, 265.37634f, 1456.149f, 270.6941f, 1491.4286f, 270.6941f);
generalPath.curveTo(1526.7081f, 270.6941f, 1555.3348f, 265.3763f, 1555.3348f, 258.8191f);
generalPath.curveTo(1555.3348f, 257.8095f, 1554.6746f, 256.81772f, 1553.3973f, 255.8816f);
generalPath.curveTo(1524.5966f, 260.87198f, 1495.3411f, 265.22388f, 1460.5848f, 262.1316f);
generalPath.lineTo(1444.7723f, 250.72536f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(63.912208557128906, 115.70919036865234), 63.91221f, new Point2D.Double(28.865602493286133, 135.3350067138672), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.19780200719833374f, 1427.5223388671875f, 235.17201232910156f));
g.setPaint(paint);
g.fill(shape);
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
generalPath.moveTo(1447.12f, 222.32233f);
generalPath.lineTo(1432.4534f, 236.9889f);
generalPath.lineTo(1461.3699f, 265.90536f);
generalPath.lineTo(1476.0365f, 251.2388f);
generalPath.lineTo(1447.12f, 222.32233f);
generalPath.closePath();
shape = generalPath;
paint = new Color(136, 136, 136, 255);
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
generalPath.moveTo(1516.8151f, 160.66444f);
generalPath.lineTo(1507.012f, 160.66444f);
generalPath.lineTo(1537.384f, 191.31308f);
generalPath.lineTo(1537.384f, 180.71413f);
generalPath.lineTo(1516.8151f, 160.66444f);
generalPath.closePath();
shape = generalPath;
paint = new Color(187, 187, 187, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.5833333f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(1507.2747f, 160.60919f);
generalPath.lineTo(1516.9226f, 160.60919f);
generalPath.lineTo(1510.7479f, 166.30145f);
generalPath.lineTo(1506.117f, 161.86342f);
generalPath.lineTo(1507.2747f, 160.60919f);
generalPath.closePath();
shape = generalPath;
paint = new Color(75, 75, 75, 255);
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
generalPath.moveTo(1516.781f, 160.60837f);
generalPath.lineTo(1507.0714f, 160.60837f);
generalPath.lineTo(1537.1539f, 191.06404f);
generalPath.lineTo(1537.1539f, 180.53181f);
generalPath.lineTo(1516.781f, 160.60837f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(1316.3583984375, 335.24102783203125), new Point2D.Double(1328.429443359375, 323.1700439453125), new float[] {0.0f,1.0f}, new Color[] {new Color(136, 136, 136, 255),new Color(136, 136, 136, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.46958160400390625f, 0.0f, 0.0f, 0.46809878945350647f, 905.6295776367188f, 21.579328536987305f));
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
generalPath.moveTo(1447.6077f, 221.85275f);
generalPath.lineTo(1433.0991f, 236.34154f);
generalPath.lineTo(1461.2344f, 264.55533f);
generalPath.lineTo(1475.743f, 250.06654f);
generalPath.lineTo(1447.6077f, 221.85275f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(1182.048583984375, 508.39056396484375), new Point2D.Double(1152.9832763671875, 441.9582214355469), new float[] {0.0f,1.0f}, new Color[] {new Color(221, 221, 221, 255),new Color(238, 238, 238, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.4645220935344696f, 0.0f, 0.0f, 0.4638896882534027f, 911.0093994140625f, 24.174062728881836f));
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
generalPath.moveTo(1517.5356f, 171.1673f);
generalPath.lineTo(1456.4314f, 232.27159f);
generalPath.lineTo(1465.8964f, 241.73659f);
generalPath.lineTo(1526.9274f, 180.691f);
generalPath.lineTo(1537.4489f, 191.22722f);
generalPath.lineTo(1537.5223f, 191.15385f);
generalPath.lineTo(1517.5356f, 171.1673f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(-140.09375, 197.046875), new Point2D.Double(-214.40625, 310.046875), new float[] {0.0f,1.0f}, new Color[] {new Color(238, 238, 238, 255),new Color(223, 223, 223, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.46958160400390625f, 0.0f, 0.0f, 0.46958160400390625f, 1574.81005859375f, 89.50411224365234f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.9055558f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(1434.8372f, 237.81187f);
generalPath.lineTo(1448.9883f, 223.67644f);
generalPath.lineTo(1447.419f, 222.10616f);
generalPath.lineTo(1433.2115f, 236.38057f);
generalPath.lineTo(1434.8372f, 237.81187f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(1465.480712890625, 261.60467529296875), new Point2D.Double(1464.5074462890625, 260.5966491699219), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-1.0f, 0.0f, 0.0f, -1.0f, 2908.703857421875f, 488.0657043457031f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.48333332f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(1448.8488f, 222.2626f);
generalPath.lineTo(1433.6613f, 237.4345f);
generalPath.lineTo(1435.0363f, 237.4501f);
generalPath.lineTo(1449.5675f, 222.98135f);
generalPath.lineTo(1448.8488f, 222.2626f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.8277778f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(1507.1886f, 162.53954f);
generalPath.lineTo(1515.3212f, 162.1502f);
generalPath.lineTo(1516.7711f, 160.62817f);
generalPath.lineTo(1507.1321f, 160.7792f);
generalPath.lineTo(1507.1886f, 162.53954f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(1465.823974609375, 261.93035888671875), new Point2D.Double(1465.23193359375, 261.3089599609375), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-0.482915997505188f, -1.4677695035934448f, 0.5089942216873169f, -1.5470316410064697f, 2090.87158203125f, 2716.926513671875f));
g.setPaint(paint);
g.fill(shape);
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
generalPath.moveTo(1506.9701f, 160.6017f);
generalPath.lineTo(1445.8658f, 221.706f);
generalPath.lineTo(1456.4314f, 232.27159f);
generalPath.lineTo(1517.5356f, 171.1673f);
generalPath.lineTo(1506.9701f, 160.6017f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(1480.3826904296875, 204.03857421875), new Point2D.Double(1480.3826904296875, 160.5817108154297), new float[] {0.0f,1.0f}, new Color[] {new Color(191, 3, 3, 255),new Color(226, 8, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.5833333f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_12
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(1531.7323f, 187.09254f);
generalPath.lineTo(1536.0739f, 191.72356f);
generalPath.lineTo(1537.3281f, 190.56583f);
generalPath.lineTo(1537.3281f, 180.9179f);
generalPath.lineTo(1531.7323f, 187.09254f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.8277778f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_13
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(1534.9542f, 190.82892f);
generalPath.lineTo(1535.6896f, 182.72862f);
generalPath.lineTo(1537.2911f, 180.89014f);
generalPath.lineTo(1537.1436f, 190.88535f);
generalPath.lineTo(1534.9542f, 190.82892f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(1465.823974609375, 261.93035888671875), new Point2D.Double(1465.23193359375, 261.3089599609375), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.8255873918533325f, 0.48291608691215515f, 1.9241724014282227f, -0.5089942216873169f, -1642.1502685546875f, -392.8539123535156f));
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
generalPath.moveTo(1526.9274f, 180.69724f);
generalPath.lineTo(1465.8231f, 241.80153f);
generalPath.lineTo(1476.3887f, 252.36713f);
generalPath.lineTo(1537.493f, 191.26282f);
generalPath.lineTo(1526.9274f, 180.69724f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(1242.4285888671875, 449.114990234375), new Point2D.Double(1242.4285888671875, 352.72833251953125), new float[] {0.0f,1.0f}, new Color[] {new Color(191, 3, 3, 255),new Color(226, 8, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.46958160400390625f, 0.0f, 0.0f, 0.46958160400390625f, 904.4718017578125f, 22.54097557067871f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.49444443f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(1506.97f, 160.65308f);
generalPath.lineTo(1445.8657f, 221.75737f);
generalPath.lineTo(1476.4313f, 252.57297f);
generalPath.lineTo(1537.5356f, 191.46866f);
generalPath.lineTo(1506.97f, 160.65308f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(1518.1744384765625, 154.83128356933594), 45.83495f, new Point2D.Double(1518.1744384765625, 154.83128356933594), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(3.167754650115967f, -1.931780457496643f, 0.5553604960441589f, 0.9106864929199219f, -3369.549560546875f, 2935.457275390625f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.24444444f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_16
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(1507.2585f, 161.0581f);
generalPath.lineTo(1446.6691f, 222.22723f);
generalPath.lineTo(1447.0854f, 222.66331f);
generalPath.lineTo(1507.4104f, 162.31712f);
generalPath.lineTo(1537.3556f, 191.30173f);
generalPath.lineTo(1537.3611f, 191.25476f);
generalPath.lineTo(1517.4109f, 171.1796f);
generalPath.lineTo(1507.2585f, 161.0581f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
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
generalPath.moveTo(1525.1497f, 200.30824f);
generalPath.curveTo(1524.9146f, 200.54362f, 1524.6759f, 200.68414f, 1524.434f, 200.72981f);
generalPath.curveTo(1524.1921f, 200.77423f, 1523.9901f, 200.71571f, 1523.8278f, 200.55417f);
generalPath.curveTo(1523.6646f, 200.3917f, 1523.606f, 200.1901f, 1523.6519f, 199.94928f);
generalPath.curveTo(1523.6982f, 199.70728f, 1523.8416f, 199.4659f, 1524.0822f, 199.22514f);
generalPath.curveTo(1524.3219f, 198.98518f, 1524.5627f, 198.84154f, 1524.8047f, 198.79424f);
generalPath.curveTo(1525.0466f, 198.74687f, 1525.2489f, 198.80418f, 1525.4117f, 198.96622f);
generalPath.curveTo(1525.5778f, 199.13144f, 1525.6373f, 199.33478f, 1525.5906f, 199.57635f);
generalPath.curveTo(1525.5435f, 199.81744f, 1525.3964f, 200.06139f, 1525.1497f, 200.30824f);
generalPath.moveTo(1525.0443f, 200.19643f);
generalPath.curveTo(1525.2177f, 200.02293f, 1525.314f, 199.85132f, 1525.3333f, 199.68152f);
generalPath.curveTo(1525.3522f, 199.5113f, 1525.2926f, 199.35759f, 1525.1548f, 199.22044f);
generalPath.curveTo(1525.0212f, 199.08745f, 1524.869f, 199.03123f, 1524.6981f, 199.05171f);
generalPath.curveTo(1524.5281f, 199.07149f, 1524.3591f, 199.16545f, 1524.191f, 199.33357f);
generalPath.curveTo(1524.0223f, 199.50249f, 1523.9285f, 199.67203f, 1523.9095f, 199.84227f);
generalPath.curveTo(1523.8903f, 200.01202f, 1523.9479f, 200.1639f, 1524.0825f, 200.29782f);
generalPath.curveTo(1524.2166f, 200.43129f, 1524.369f, 200.48921f, 1524.5397f, 200.47162f);
generalPath.curveTo(1524.7104f, 200.45398f, 1524.8785f, 200.36227f, 1525.0443f, 200.19643f);
generalPath.moveTo(1526.0645f, 199.34154f);
generalPath.lineTo(1526.1116f, 198.2658f);
generalPath.lineTo(1525.0654f, 198.29233f);
generalPath.lineTo(1525.3495f, 198.00803f);
generalPath.lineTo(1526.1443f, 197.98512f);
generalPath.lineTo(1526.1855f, 197.17117f);
generalPath.lineTo(1526.4124f, 196.94421f);
generalPath.lineTo(1526.3666f, 197.98006f);
generalPath.lineTo(1527.4528f, 197.95212f);
generalPath.lineTo(1527.1687f, 198.23642f);
generalPath.lineTo(1526.3309f, 198.26225f);
generalPath.lineTo(1526.2924f, 199.1134f);
generalPath.lineTo(1526.0645f, 199.34154f);
generalPath.moveTo(1528.1022f, 197.30212f);
generalPath.lineTo(1527.6736f, 196.87555f);
generalPath.lineTo(1526.5098f, 196.84676f);
generalPath.lineTo(1526.7847f, 196.57162f);
generalPath.lineTo(1527.6879f, 196.5926f);
generalPath.lineTo(1527.6989f, 195.65683f);
generalPath.lineTo(1527.9221f, 195.43329f);
generalPath.lineTo(1527.9113f, 196.63202f);
generalPath.lineTo(1528.3428f, 197.0614f);
generalPath.lineTo(1528.1022f, 197.30212f);
generalPath.moveTo(1530.4434f, 194.90387f);
generalPath.curveTo(1530.2736f, 195.14487f, 1530.1122f, 195.3418f, 1529.9595f, 195.49464f);
generalPath.curveTo(1529.69f, 195.76442f, 1529.4365f, 195.92531f, 1529.1992f, 195.97723f);
generalPath.curveTo(1528.9626f, 196.02843f, 1528.7578f, 195.96771f, 1528.5844f, 195.7951f);
generalPath.curveTo(1528.4142f, 195.62576f, 1528.3549f, 195.42117f, 1528.4064f, 195.1813f);
generalPath.curveTo(1528.4574f, 194.94098f, 1528.6147f, 194.68896f, 1528.878f, 194.4253f);
generalPath.curveTo(1529.0507f, 194.2526f, 1529.2457f, 194.08846f, 1529.463f, 193.93279f);
generalPath.lineTo(1529.5975f, 194.0667f);
generalPath.curveTo(1529.3158f, 194.2527f, 1529.1127f, 194.408f, 1528.9882f, 194.53258f);
generalPath.curveTo(1528.8049f, 194.716f, 1528.7002f, 194.89603f, 1528.674f, 195.07268f);
generalPath.curveTo(1528.6486f, 195.2486f, 1528.7043f, 195.40466f, 1528.8412f, 195.54088f);
generalPath.curveTo(1528.9766f, 195.67567f, 1529.1364f, 195.7264f, 1529.3201f, 195.69286f);
generalPath.curveTo(1529.5035f, 195.65889f, 1529.6929f, 195.54408f, 1529.8884f, 195.34843f);
generalPath.curveTo(1529.9685f, 195.26819f, 1530.0468f, 195.17294f, 1530.1227f, 195.06265f);
generalPath.lineTo(1529.7885f, 194.72992f);
generalPath.lineTo(1530.0278f, 194.49033f);
generalPath.lineTo(1530.4434f, 194.90387f);
generalPath.moveTo(1530.8925f, 194.50958f);
generalPath.lineTo(1529.866f, 193.4879f);
generalPath.lineTo(1530.8132f, 192.53986f);
generalPath.lineTo(1530.9222f, 192.64827f);
generalPath.lineTo(1530.2155f, 193.35559f);
generalPath.lineTo(1530.5449f, 193.68346f);
generalPath.lineTo(1531.1371f, 193.09077f);
generalPath.lineTo(1531.2446f, 193.19778f);
generalPath.lineTo(1530.6523f, 193.79045f);
generalPath.lineTo(1531.0242f, 194.16046f);
generalPath.lineTo(1531.7802f, 193.40385f);
generalPath.lineTo(1531.8892f, 193.51224f);
generalPath.lineTo(1530.8925f, 194.50958f);
generalPath.moveTo(1532.1663f, 193.23482f);
generalPath.lineTo(1531.1396f, 192.21313f);
generalPath.lineTo(1531.3757f, 191.97697f);
generalPath.lineTo(1533.0219f, 191.91197f);
generalPath.lineTo(1532.229f, 191.12294f);
generalPath.lineTo(1532.4352f, 190.9166f);
generalPath.lineTo(1533.4618f, 191.93826f);
generalPath.lineTo(1533.227f, 192.17326f);
generalPath.lineTo(1531.5796f, 192.23943f);
generalPath.lineTo(1532.3726f, 193.02847f);
generalPath.lineTo(1532.1663f, 193.23482f);
shape = generalPath;
paint = new Color(240, 248, 255, 255);
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
generalPath.moveTo(1476.1359f, 252.57697f);
generalPath.lineTo(1535.9365f, 192.72069f);
generalPath.lineTo(1535.8282f, 192.69553f);
generalPath.lineTo(1476.1567f, 251.76756f);
generalPath.lineTo(1448.4828f, 224.29745f);
generalPath.lineTo(1448.4773f, 224.34444f);
generalPath.lineTo(1476.1359f, 252.57697f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 20, 45, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9588221907615662f, -0.9588221907615662f, 0.5214731097221375f, 0.5214731097221375f, 0.0f, 0.0f));
// _0_0_19
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(650.1757f, 1632.3326f);
generalPath.lineTo(650.1757f, 1623.4397f);
generalPath.lineTo(655.14496f, 1623.4397f);
generalPath.lineTo(655.14496f, 1624.383f);
generalPath.lineTo(651.43756f, 1624.383f);
generalPath.lineTo(651.43756f, 1627.2372f);
generalPath.lineTo(654.54407f, 1627.2372f);
generalPath.lineTo(654.54407f, 1628.1686f);
generalPath.lineTo(651.43756f, 1628.1686f);
generalPath.lineTo(651.43756f, 1631.3893f);
generalPath.lineTo(655.4033f, 1631.3893f);
generalPath.lineTo(655.4033f, 1632.3326f);
generalPath.lineTo(650.1757f, 1632.3326f);
generalPath.moveTo(656.8575f, 1632.3326f);
generalPath.lineTo(656.8575f, 1623.4397f);
generalPath.lineTo(659.5494f, 1623.4397f);
generalPath.curveTo(660.4026f, 1623.4397f, 661.05554f, 1623.628f, 661.50824f, 1624.0045f);
generalPath.curveTo(661.9649f, 1624.3811f, 662.19324f, 1624.9279f, 662.19324f, 1625.6449f);
generalPath.curveTo(662.19324f, 1626.8306f, 661.59436f, 1627.6719f, 660.3966f, 1628.1686f);
generalPath.lineTo(663.3649f, 1632.3326f);
generalPath.lineTo(661.81464f, 1632.3326f);
generalPath.lineTo(659.285f, 1628.5712f);
generalPath.lineTo(658.1073f, 1628.5712f);
generalPath.lineTo(658.1073f, 1632.3326f);
generalPath.lineTo(656.8575f, 1632.3326f);
generalPath.moveTo(658.1073f, 1627.6278f);
generalPath.lineTo(658.51587f, 1627.6278f);
generalPath.curveTo(660.1022f, 1627.6278f, 660.8953f, 1627.0049f, 660.8953f, 1625.7592f);
generalPath.curveTo(660.8953f, 1624.8418f, 660.23035f, 1624.383f, 658.90045f, 1624.383f);
generalPath.lineTo(658.1073f, 1624.383f);
generalPath.lineTo(658.1073f, 1627.6278f);
generalPath.moveTo(669.1513f, 1628.9316f);
generalPath.lineTo(667.63715f, 1625.0981f);
generalPath.lineTo(666.11694f, 1628.9316f);
generalPath.lineTo(669.1513f, 1628.9316f);
generalPath.moveTo(670.4853f, 1632.3326f);
generalPath.lineTo(669.5179f, 1629.8691f);
generalPath.lineTo(665.75037f, 1629.8691f);
generalPath.lineTo(664.77094f, 1632.3326f);
generalPath.lineTo(663.59924f, 1632.3326f);
generalPath.lineTo(667.1264f, 1623.4397f);
generalPath.lineTo(668.3762f, 1623.4397f);
generalPath.lineTo(671.84924f, 1632.3326f);
generalPath.lineTo(670.4853f, 1632.3326f);
generalPath.moveTo(674.87164f, 1632.555f);
generalPath.curveTo(674.2748f, 1632.555f, 673.51166f, 1632.4248f, 672.58234f, 1632.1644f);
generalPath.lineTo(672.58234f, 1630.9146f);
generalPath.curveTo(673.5838f, 1631.3793f, 674.407f, 1631.6116f, 675.05194f, 1631.6116f);
generalPath.curveTo(675.54865f, 1631.6116f, 675.9472f, 1631.4814f, 676.2477f, 1631.221f);
generalPath.curveTo(676.55206f, 1630.9606f, 676.7043f, 1630.6182f, 676.70435f, 1630.1935f);
generalPath.curveTo(676.7043f, 1629.845f, 676.6042f, 1629.5486f, 676.4039f, 1629.3042f);
generalPath.curveTo(676.2076f, 1629.0599f, 675.8431f, 1628.7875f, 675.3103f, 1628.487f);
generalPath.lineTo(674.6974f, 1628.1324f);
generalPath.curveTo(673.9403f, 1627.7f, 673.4055f, 1627.2933f, 673.0931f, 1626.9128f);
generalPath.curveTo(672.7846f, 1626.5282f, 672.6304f, 1626.0815f, 672.6304f, 1625.5728f);
generalPath.curveTo(672.6304f, 1624.8878f, 672.8788f, 1624.325f, 673.3755f, 1623.8844f);
generalPath.curveTo(673.8722f, 1623.4397f, 674.5051f, 1623.2174f, 675.27423f, 1623.2174f);
generalPath.curveTo(675.9592f, 1623.2174f, 676.68225f, 1623.3315f, 677.4434f, 1623.5599f);
generalPath.lineTo(677.4434f, 1624.7136f);
generalPath.curveTo(676.50604f, 1624.345f, 675.807f, 1624.1608f, 675.3463f, 1624.1608f);
generalPath.curveTo(674.9097f, 1624.1608f, 674.5492f, 1624.2769f, 674.2648f, 1624.5093f);
generalPath.curveTo(673.98035f, 1624.7416f, 673.83813f, 1625.034f, 673.83813f, 1625.3865f);
generalPath.curveTo(673.83813f, 1625.683f, 673.9423f, 1625.9454f, 674.1506f, 1626.1737f);
generalPath.curveTo(674.3589f, 1626.402f, 674.73944f, 1626.6744f, 675.2923f, 1626.9908f);
generalPath.lineTo(675.9292f, 1627.3514f);
generalPath.curveTo(676.6983f, 1627.788f, 677.2351f, 1628.2006f, 677.53955f, 1628.5892f);
generalPath.curveTo(677.844f, 1628.9778f, 677.9962f, 1629.4445f, 677.9962f, 1629.9893f);
generalPath.curveTo(677.9962f, 1630.7625f, 677.7098f, 1631.3833f, 677.13696f, 1631.8519f);
generalPath.curveTo(676.5681f, 1632.3206f, 675.81305f, 1632.555f, 674.87164f, 1632.555f);
generalPath.moveTo(679.76276f, 1632.3326f);
generalPath.lineTo(679.76276f, 1623.4397f);
generalPath.lineTo(684.732f, 1623.4397f);
generalPath.lineTo(684.732f, 1624.383f);
generalPath.lineTo(681.0246f, 1624.383f);
generalPath.lineTo(681.0246f, 1627.2372f);
generalPath.lineTo(684.1311f, 1627.2372f);
generalPath.lineTo(684.1311f, 1628.1686f);
generalPath.lineTo(681.0246f, 1628.1686f);
generalPath.lineTo(681.0246f, 1631.3893f);
generalPath.lineTo(684.99036f, 1631.3893f);
generalPath.lineTo(684.99036f, 1632.3326f);
generalPath.lineTo(679.76276f, 1632.3326f);
generalPath.moveTo(686.44446f, 1632.3326f);
generalPath.lineTo(686.44446f, 1623.4397f);
generalPath.lineTo(689.1364f, 1623.4397f);
generalPath.curveTo(689.9896f, 1623.4397f, 690.6426f, 1623.628f, 691.0952f, 1624.0045f);
generalPath.curveTo(691.5519f, 1624.3811f, 691.7802f, 1624.9279f, 691.7802f, 1625.6449f);
generalPath.curveTo(691.7802f, 1626.8306f, 691.18134f, 1627.6719f, 689.98364f, 1628.1686f);
generalPath.lineTo(692.95197f, 1632.3326f);
generalPath.lineTo(691.4017f, 1632.3326f);
generalPath.lineTo(688.872f, 1628.5712f);
generalPath.lineTo(687.6943f, 1628.5712f);
generalPath.lineTo(687.6943f, 1632.3326f);
generalPath.lineTo(686.44446f, 1632.3326f);
generalPath.moveTo(687.6943f, 1627.6278f);
generalPath.lineTo(688.1029f, 1627.6278f);
generalPath.curveTo(689.6892f, 1627.6278f, 690.48236f, 1627.0049f, 690.48236f, 1625.7592f);
generalPath.curveTo(690.48236f, 1624.8418f, 689.8174f, 1624.383f, 688.4874f, 1624.383f);
generalPath.lineTo(687.6943f, 1624.383f);
generalPath.lineTo(687.6943f, 1627.6278f);
shape = generalPath;
paint = new Color(156, 15, 15, 255);
g.setPaint(paint);
g.fill(shape);
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
generalPath.moveTo(1473.8667f, 250.25381f);
generalPath.lineTo(1459.7156f, 264.38925f);
generalPath.lineTo(1461.2849f, 265.95953f);
generalPath.lineTo(1475.4923f, 251.68512f);
generalPath.lineTo(1473.8667f, 250.25381f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(1465.480712890625, 261.60467529296875), new Point2D.Double(1464.4921875, 260.6382751464844), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.8666667f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_21
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(1462.4136f, 264.4753f);
generalPath.lineTo(1433.4955f, 235.81358f);
generalPath.lineTo(1432.3271f, 237.06296f);
generalPath.lineTo(1461.29f, 265.84134f);
generalPath.lineTo(1462.4136f, 264.4753f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(1465.823974609375, 261.93035888671875), new Point2D.Double(1465.23193359375, 261.3089599609375), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.875255577488133E-7f, 2.075739622116089f, -2.187833070755005f, 1.7791769835184823E-7f, 2014.2025146484375f, -2796.1845703125f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.6611111f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_22
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(1515.165f, 162.34184f);
generalPath.lineTo(1535.7773f, 182.4479f);
generalPath.lineTo(1537.3579f, 180.78629f);
generalPath.lineTo(1516.7007f, 160.56358f);
generalPath.lineTo(1515.165f, 162.34184f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(1465.823974609375, 261.93035888671875), new Point2D.Double(1465.055419921875, 261.1414794921875), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-1.875255577488133E-7f, -2.075739622116089f, 2.187833070755005f, -1.7791769835184823E-7f, 963.788330078125f, 3222.58935546875f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.85f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7071068286895752f, 0.7071068286895752f, -0.7071068286895752f, 0.7071068286895752f, 0.0f, 0.0f));
// _0_0_23
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(1180.4717f, -953.3362f);
generalPath.lineTo(1221.2197f, -952.9003f);
generalPath.lineTo(1222.4456f, -951.83307f);
generalPath.curveTo(1222.4456f, -951.83307f, 1222.4363f, -950.6754f, 1222.4727f, -950.6028f);
generalPath.lineTo(1179.2368f, -950.58466f);
generalPath.lineTo(1179.07f, -952.0992f);
generalPath.lineTo(1180.4717f, -953.3362f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(1183.02880859375, -950.5438842773438), new Point2D.Double(1183.355712890625, -953.1630249023438), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_24
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(1446.8969f, 222.67352f);
generalPath.lineTo(1445.8657f, 223.70477f);
generalPath.lineTo(1474.8438f, 252.50865f);
generalPath.lineTo(1475.8438f, 251.50865f);
generalPath.lineTo(1446.8969f, 222.67352f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(1462.9708251953125, 237.53892517089844), new Point2D.Double(1461.3133544921875, 239.19644165039062), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
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
        return 0.2352447509765625;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 127.8125;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 127.76475524902344;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private draw_eraser_2() {
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
       draw_eraser_2 base = new draw_eraser_2();
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
       draw_eraser_2 base = new draw_eraser_2();
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
        return draw_eraser_2::new;
    }
}

