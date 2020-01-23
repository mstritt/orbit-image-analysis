package com.actelion.research.orbit.imageAnalysis.components.icons;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.ref.WeakReference;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.swing.plaf.UIResource;

import org.pushingpixels.neon.icon.ResizableIcon;
import org.pushingpixels.neon.icon.ResizableIconUIResource;

/**
 * This class has been automatically generated using <a
 * href="https://github.com/kirill-grouchnikov/radiance">Photon SVG transcoder</a>.
 */
public class svn_update implements ResizableIcon {
    

    @SuppressWarnings("unused")
	private void innerPaint(Graphics2D g) {
        Shape shape = null;
        Paint paint = null;
        Stroke stroke = null;
        Shape clip = null;

        float origAlpha = 1.0f;
        Composite origComposite = g.getComposite();
        if (origComposite instanceof AlphaComposite) {
            AlphaComposite origAlphaComposite = 
                (AlphaComposite)origComposite;
            if (origAlphaComposite.getRule() == AlphaComposite.SRC_OVER) {
                origAlpha = origAlphaComposite.getAlpha();
            }
        }
        
	    AffineTransform defaultTransform_ = g.getTransform();
// 
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0 = g.getTransform();
g.transform(new AffineTransform(0.21102924644947052f, 0.0f, 0.0f, 0.20917175710201263f, -15.882478713989258f, -52.677642822265625f));
// _0_0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 45.06142807006836f, -54.602901458740234f));
// _0_0_0_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(594.2098, 637.24835);
((GeneralPath)shape).curveTo(594.2098, 707.02344, 481.08197, 763.58734, 341.5318, 763.58734);
((GeneralPath)shape).curveTo(201.9816, 763.58734, 88.853806, 707.02344, 88.853806, 637.24835);
((GeneralPath)shape).curveTo(88.853806, 567.47327, 201.9816, 510.90936, 341.5318, 510.90936);
((GeneralPath)shape).curveTo(481.082, 510.90936, 594.2098, 567.47327, 594.2098, 637.24835);
((GeneralPath)shape).closePath();
paint = new Color(61, 61, 61, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 45.06142807006836f, -113.5770263671875f));
// _0_0_0_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(594.2098, 637.24835);
((GeneralPath)shape).curveTo(594.2098, 707.02344, 481.08197, 763.58734, 341.5318, 763.58734);
((GeneralPath)shape).curveTo(201.9816, 763.58734, 88.853806, 707.02344, 88.853806, 637.24835);
((GeneralPath)shape).curveTo(88.853806, 567.47327, 201.9816, 510.90936, 341.5318, 510.90936);
((GeneralPath)shape).curveTo(481.082, 510.90936, 594.2098, 567.47327, 594.2098, 637.24835);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(341.53179931640625, 528.580078125), new Point2D.Double(341.53179931640625, 700.0775146484375), new float[] {0.0f,1.0f}, new Color[] {new Color(252, 252, 252, 255),new Color(192, 192, 192, 255)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(639.2651, 523.65924);
((GeneralPath)shape).curveTo(639.2651, 593.3983, 526.0559, 650.003, 386.5777, 650.003);
((GeneralPath)shape).curveTo(247.82579, 650.003, 135.0921, 593.9916, 133.9214, 524.753);
((GeneralPath)shape).lineTo(134.9214, 575.003);
((GeneralPath)shape).curveTo(134.9214, 644.7421, 247.1306, 701.34674, 386.609, 701.34674);
((GeneralPath)shape).curveTo(526.0872, 701.34674, 638.26514, 644.7421, 638.26514, 575.003);
((GeneralPath)shape).lineTo(639.26514, 523.65924);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(902.440185546875, 573.3363647460938), 252.67184f, new Point2D.Double(902.440185546875, 777.675048828125), new float[] {0.0f,0.13883302f,0.27766603f,0.3483148f,0.519832f,0.6913492f,0.7199554f,0.8247441f,0.9112725f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(188, 188, 188, 255),new Color(143, 143, 143, 255),new Color(242, 242, 242, 255),new Color(187, 187, 187, 255),new Color(63, 63, 63, 255),new Color(143, 143, 143, 255),new Color(164, 164, 164, 255),new Color(94, 94, 94, 255),new Color(172, 172, 172, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0000001192092896f, 0.0f, 0.0f, 0.7898656129837036f, -515.8470458984375f, 106.1419677734375f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_3
shape = new GeneralPath();
((GeneralPath)shape).moveTo(566.2773, 486.15744);
((GeneralPath)shape).curveTo(579.07697, 526.5242, 502.6638, 561.86523, 387.09488, 561.86523);
((GeneralPath)shape).curveTo(265.94098, 561.86523, 190.88239, 525.39215, 207.91258, 486.15744);
((GeneralPath)shape).curveTo(230.12598, 434.98117, 310.3997, 410.44965, 387.09488, 410.44965);
((GeneralPath)shape).curveTo(461.0135, 410.44965, 551.8533, 440.668, 566.2773, 486.15744);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(949.625, 517.85107421875), 119.39729f, new Point2D.Double(942.2240600585938, 440.14154052734375), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.709729552268982f, 0.06452833116054535f, -0.0521678701043129f, 0.9870303869247437f, -1209.4918212890625f, -86.25507354736328f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0_3);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_4
shape = new GeneralPath();
((GeneralPath)shape).moveTo(134.39008, 519.2338);
((GeneralPath)shape).curveTo(134.10378, 521.6951, 133.92128, 524.1743, 133.92137, 526.6713);
((GeneralPath)shape).curveTo(133.92137, 596.41046, 247.13057, 653.0151, 386.60876, 653.0151);
((GeneralPath)shape).curveTo(526.08704, 653.0151, 639.2651, 596.41046, 639.2651, 526.6713);
((GeneralPath)shape).curveTo(639.2651, 524.1743, 639.1139, 521.6951, 638.8276, 519.2338);
((GeneralPath)shape).curveTo(631.1191, 585.515, 521.0931, 638.1401, 386.60876, 638.1401);
((GeneralPath)shape).curveTo(252.12456, 638.1401, 142.09857, 585.515, 134.39006, 519.2338);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(1302.515625, 396.677001953125), 252.67184f, new Point2D.Double(1302.515625, 396.677001953125), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.4615497589111328f, 0.0f, 0.0f, 0.7922186255455017f, -1517.09814453125f, 316.29644775390625f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0_4);
g.setComposite(AlphaComposite.getInstance(3, 0.50553507f * origAlpha));
AffineTransform defaultTransform__0_0_0_5 = g.getTransform();
g.transform(new AffineTransform(0.979244589805603f, 0.0f, 0.0f, 0.979244589805603f, -888.88818359375f, 80.20003509521484f));
// _0_0_0_5
shape = new GeneralPath();
((GeneralPath)shape).moveTo(1050.3125, 441.16064);
((GeneralPath)shape).curveTo(1050.0262, 443.62198, 1049.8438, 446.10114, 1049.8438, 448.59814);
((GeneralPath)shape).curveTo(1049.8438, 518.3373, 1163.053, 574.9419, 1302.5311, 574.9419);
((GeneralPath)shape).curveTo(1442.0094, 574.9419, 1555.1874, 518.3373, 1555.1874, 448.59814);
((GeneralPath)shape).curveTo(1555.1874, 446.10114, 1555.0361, 443.62198, 1554.7499, 441.16064);
((GeneralPath)shape).curveTo(1547.0414, 507.44183, 1437.0154, 566.0669, 1302.5311, 566.0669);
((GeneralPath)shape).curveTo(1168.0469, 566.0669, 1058.021, 507.44183, 1050.3124, 441.16064);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(1228.482421875, 349.2613525390625), new Point2D.Double(1228.482421875, 687.31005859375), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(71, 71, 71, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0_5);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_6 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_6
shape = new GeneralPath();
((GeneralPath)shape).moveTo(152.9375, 571.65625);
((GeneralPath)shape).curveTo(165.10074, 588.474, 184.4765, 603.8789, 210.03125, 616.65625);
((GeneralPath)shape).curveTo(254.92583, 639.1035, 317.48145, 653.1875, 386.59375, 653.1875);
((GeneralPath)shape).curveTo(455.70612, 653.1875, 518.26965, 639.1034, 563.15625, 616.65625);
((GeneralPath)shape).curveTo(588.5327, 603.9658, 607.79047, 588.6834, 619.96875, 572.0);
((GeneralPath)shape).curveTo(605.8334, 587.5018, 586.10754, 601.21936, 562.21875, 612.53125);
((GeneralPath)shape).curveTo(516.143, 634.3492, 454.44025, 647.5625, 386.59375, 647.5625);
((GeneralPath)shape).curveTo(318.7473, 647.5625, 257.0445, 634.3492, 210.96875, 612.53125);
((GeneralPath)shape).curveTo(186.90793, 601.1379, 167.09196, 587.296, 152.9375, 571.65625);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(1302.515625, 396.677001953125), 252.67184f, new Point2D.Double(1302.515625, 396.677001953125), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.4615497589111328f, 0.0f, 0.0f, 0.7922186255455017f, -1517.09814453125f, 321.0887145996094f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0_6);
g.setComposite(AlphaComposite.getInstance(3, 0.6287129f * origAlpha));
AffineTransform defaultTransform__0_0_0_7 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, -309.3197326660156f));
// _0_0_0_7
shape = new GeneralPath();
((GeneralPath)shape).moveTo(639.2651, 873.2777);
((GeneralPath)shape).curveTo(639.2651, 943.0168, 526.0559, 999.62146, 386.5777, 999.62146);
((GeneralPath)shape).curveTo(247.82579, 999.62146, 135.0921, 943.61005, 133.9214, 874.37146);
((GeneralPath)shape).lineTo(134.9214, 924.62146);
((GeneralPath)shape).curveTo(134.9214, 994.3606, 247.1306, 1050.9652, 386.609, 1050.9652);
((GeneralPath)shape).curveTo(526.0872, 1050.9652, 638.26514, 994.36053, 638.26514, 924.62146);
((GeneralPath)shape).lineTo(639.26514, 873.2777);
((GeneralPath)shape).closePath();
paint = new Color(0, 0, 0, 76);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0_7);
g.setComposite(AlphaComposite.getInstance(3, 0.50553507f * origAlpha));
AffineTransform defaultTransform__0_0_0_8 = g.getTransform();
g.transform(new AffineTransform(0.9960461258888245f, 0.0f, 0.0f, 0.9960461258888245f, -910.7724609375f, 72.38355255126953f));
// _0_0_0_8
shape = new GeneralPath();
((GeneralPath)shape).moveTo(1058.9375, 474.46875);
((GeneralPath)shape).curveTo(1069.0624, 497.43295, 1092.363, 518.32214, 1125.4062, 534.84375);
((GeneralPath)shape).curveTo(1170.5197, 557.40045, 1233.2562, 571.5, 1302.5312, 571.5);
((GeneralPath)shape).curveTo(1371.8064, 571.5, 1434.5195, 557.4003, 1479.625, 534.84375);
((GeneralPath)shape).curveTo(1512.5835, 518.3617, 1535.8389, 497.52454, 1546.0, 474.625);
((GeneralPath)shape).curveTo(1532.4229, 496.34863, 1508.5667, 515.9022, 1477.7188, 531.53125);
((GeneralPath)shape).curveTo(1431.8534, 554.769, 1370.2719, 569.5, 1302.5311, 569.5);
((GeneralPath)shape).curveTo(1234.7908, 569.5, 1173.2091, 554.769, 1127.3438, 531.53125);
((GeneralPath)shape).curveTo(1096.4165, 515.86194, 1072.4963, 496.25967, 1058.9375, 474.46875);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(1228.482421875, 349.2613525390625), new Point2D.Double(1228.482421875, 687.31005859375), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(71, 71, 71, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0_8);
g.setTransform(defaultTransform__0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 0.27227724f * origAlpha));
AffineTransform defaultTransform__0_0_1 = g.getTransform();
g.transform(new AffineTransform(0.9628130197525024f, 0.0f, 0.0f, 0.8727686405181885f, 17.362375259399414f, -18.873504638671875f));
// _0_0_1
paint = new LinearGradientPaint(new Point2D.Double(11.863568305969238, 97.68323516845703), new Point2D.Double(113.55742645263672, 38.211856842041016), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(0.49323508f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(86.26703, 85.22004);
((GeneralPath)shape).curveTo(86.32482, 91.68118, 79.46402, 97.66393, 68.282524, 100.90288);
((GeneralPath)shape).curveTo(57.10102, 104.141815, 43.308144, 104.141815, 32.12664, 100.90288);
((GeneralPath)shape).curveTo(20.945143, 97.66393, 14.084345, 91.68118, 14.142136, 85.22004);
((GeneralPath)shape).curveTo(14.084345, 78.758896, 20.945143, 72.776146, 32.12664, 69.5372);
((GeneralPath)shape).curveTo(43.308144, 66.29826, 57.10102, 66.29826, 68.282524, 69.5372);
((GeneralPath)shape).curveTo(79.46402, 72.776146, 86.32482, 78.758896, 86.26703, 85.22004);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_1);
g.setComposite(AlphaComposite.getInstance(3, 0.27227724f * origAlpha));
AffineTransform defaultTransform__0_0_2 = g.getTransform();
g.transform(new AffineTransform(0.944675087928772f, 0.0f, 0.0f, 0.8563269376754761f, 18.27298355102539f, -17.47234344482422f));
// _0_0_2
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(0.49323508f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(86.26703, 85.22004);
((GeneralPath)shape).curveTo(86.32482, 91.68118, 79.46402, 97.66393, 68.282524, 100.90288);
((GeneralPath)shape).curveTo(57.10102, 104.141815, 43.308144, 104.141815, 32.12664, 100.90288);
((GeneralPath)shape).curveTo(20.945143, 97.66393, 14.084345, 91.68118, 14.142136, 85.22004);
((GeneralPath)shape).curveTo(14.084345, 78.758896, 20.945143, 72.776146, 32.12664, 69.5372);
((GeneralPath)shape).curveTo(43.308144, 66.29826, 57.10102, 66.29826, 68.282524, 69.5372);
((GeneralPath)shape).curveTo(79.46402, 72.776146, 86.32482, 78.758896, 86.26703, 85.22004);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_3 = g.getTransform();
g.transform(new AffineTransform(0.21102924644947052f, 0.0f, 0.0f, 0.20917175710201263f, -15.882478713989258f, -67.67764282226562f));
// _0_0_3
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_3_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 45.06142807006836f, -54.602901458740234f));
// _0_0_3_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(594.2098, 637.24835);
((GeneralPath)shape).curveTo(594.2098, 707.02344, 481.08197, 763.58734, 341.5318, 763.58734);
((GeneralPath)shape).curveTo(201.9816, 763.58734, 88.853806, 707.02344, 88.853806, 637.24835);
((GeneralPath)shape).curveTo(88.853806, 567.47327, 201.9816, 510.90936, 341.5318, 510.90936);
((GeneralPath)shape).curveTo(481.082, 510.90936, 594.2098, 567.47327, 594.2098, 637.24835);
((GeneralPath)shape).closePath();
paint = new Color(61, 61, 61, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_3_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_3_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 45.06142807006836f, -113.5770263671875f));
// _0_0_3_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(594.2098, 637.24835);
((GeneralPath)shape).curveTo(594.2098, 707.02344, 481.08197, 763.58734, 341.5318, 763.58734);
((GeneralPath)shape).curveTo(201.9816, 763.58734, 88.853806, 707.02344, 88.853806, 637.24835);
((GeneralPath)shape).curveTo(88.853806, 567.47327, 201.9816, 510.90936, 341.5318, 510.90936);
((GeneralPath)shape).curveTo(481.082, 510.90936, 594.2098, 567.47327, 594.2098, 637.24835);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(341.53179931640625, 528.580078125), new Point2D.Double(341.53179931640625, 700.0775146484375), new float[] {0.0f,1.0f}, new Color[] {new Color(252, 252, 252, 255),new Color(192, 192, 192, 255)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_3_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_3_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(639.2651, 523.65924);
((GeneralPath)shape).curveTo(639.2651, 593.3983, 526.0559, 650.003, 386.5777, 650.003);
((GeneralPath)shape).curveTo(247.82579, 650.003, 135.0921, 593.9916, 133.9214, 524.753);
((GeneralPath)shape).lineTo(134.9214, 575.003);
((GeneralPath)shape).curveTo(134.9214, 644.7421, 247.1306, 701.34674, 386.609, 701.34674);
((GeneralPath)shape).curveTo(526.0872, 701.34674, 638.26514, 644.7421, 638.26514, 575.003);
((GeneralPath)shape).lineTo(639.26514, 523.65924);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(902.440185546875, 573.3363647460938), 252.67184f, new Point2D.Double(902.440185546875, 777.675048828125), new float[] {0.0f,0.13883302f,0.27766603f,0.3483148f,0.519832f,0.6913492f,0.7199554f,0.8247441f,0.9112725f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(188, 188, 188, 255),new Color(143, 143, 143, 255),new Color(242, 242, 242, 255),new Color(187, 187, 187, 255),new Color(63, 63, 63, 255),new Color(143, 143, 143, 255),new Color(164, 164, 164, 255),new Color(94, 94, 94, 255),new Color(172, 172, 172, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0000001192092896f, 0.0f, 0.0f, 0.7898656129837036f, -515.8470458984375f, 106.1419677734375f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_3_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_3_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3_3
shape = new GeneralPath();
((GeneralPath)shape).moveTo(566.2773, 486.15744);
((GeneralPath)shape).curveTo(579.07697, 526.5242, 502.6638, 561.86523, 387.09488, 561.86523);
((GeneralPath)shape).curveTo(265.94098, 561.86523, 190.88239, 525.39215, 207.91258, 486.15744);
((GeneralPath)shape).curveTo(230.12598, 434.98117, 310.3997, 410.44965, 387.09488, 410.44965);
((GeneralPath)shape).curveTo(461.0135, 410.44965, 551.8533, 440.668, 566.2773, 486.15744);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(949.625, 517.85107421875), 119.39729f, new Point2D.Double(942.2240600585938, 440.14154052734375), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.709729552268982f, 0.06452833116054535f, -0.0521678701043129f, 0.9870303869247437f, -1209.4918212890625f, -86.25507354736328f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_3_3);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_3_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3_4
shape = new GeneralPath();
((GeneralPath)shape).moveTo(134.39008, 519.2338);
((GeneralPath)shape).curveTo(134.10378, 521.6951, 133.92128, 524.1743, 133.92137, 526.6713);
((GeneralPath)shape).curveTo(133.92137, 596.41046, 247.13057, 653.0151, 386.60876, 653.0151);
((GeneralPath)shape).curveTo(526.08704, 653.0151, 639.2651, 596.41046, 639.2651, 526.6713);
((GeneralPath)shape).curveTo(639.2651, 524.1743, 639.1139, 521.6951, 638.8276, 519.2338);
((GeneralPath)shape).curveTo(631.1191, 585.515, 521.0931, 638.1401, 386.60876, 638.1401);
((GeneralPath)shape).curveTo(252.12456, 638.1401, 142.09857, 585.515, 134.39006, 519.2338);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(1302.515625, 396.677001953125), 252.67184f, new Point2D.Double(1302.515625, 396.677001953125), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.4615497589111328f, 0.0f, 0.0f, 0.7922186255455017f, -1517.09814453125f, 316.29644775390625f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_3_4);
g.setComposite(AlphaComposite.getInstance(3, 0.50553507f * origAlpha));
AffineTransform defaultTransform__0_0_3_5 = g.getTransform();
g.transform(new AffineTransform(0.979244589805603f, 0.0f, 0.0f, 0.979244589805603f, -888.88818359375f, 80.20003509521484f));
// _0_0_3_5
shape = new GeneralPath();
((GeneralPath)shape).moveTo(1050.3125, 441.16064);
((GeneralPath)shape).curveTo(1050.0262, 443.62198, 1049.8438, 446.10114, 1049.8438, 448.59814);
((GeneralPath)shape).curveTo(1049.8438, 518.3373, 1163.053, 574.9419, 1302.5311, 574.9419);
((GeneralPath)shape).curveTo(1442.0094, 574.9419, 1555.1874, 518.3373, 1555.1874, 448.59814);
((GeneralPath)shape).curveTo(1555.1874, 446.10114, 1555.0361, 443.62198, 1554.7499, 441.16064);
((GeneralPath)shape).curveTo(1547.0414, 507.44183, 1437.0154, 566.0669, 1302.5311, 566.0669);
((GeneralPath)shape).curveTo(1168.0469, 566.0669, 1058.021, 507.44183, 1050.3124, 441.16064);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(1228.482421875, 349.2613525390625), new Point2D.Double(1228.482421875, 687.31005859375), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(71, 71, 71, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_3_5);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_3_6 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3_6
shape = new GeneralPath();
((GeneralPath)shape).moveTo(152.9375, 571.65625);
((GeneralPath)shape).curveTo(165.10074, 588.474, 184.4765, 603.8789, 210.03125, 616.65625);
((GeneralPath)shape).curveTo(254.92583, 639.1035, 317.48145, 653.1875, 386.59375, 653.1875);
((GeneralPath)shape).curveTo(455.70612, 653.1875, 518.26965, 639.1034, 563.15625, 616.65625);
((GeneralPath)shape).curveTo(588.5327, 603.9658, 607.79047, 588.6834, 619.96875, 572.0);
((GeneralPath)shape).curveTo(605.8334, 587.5018, 586.10754, 601.21936, 562.21875, 612.53125);
((GeneralPath)shape).curveTo(516.143, 634.3492, 454.44025, 647.5625, 386.59375, 647.5625);
((GeneralPath)shape).curveTo(318.7473, 647.5625, 257.0445, 634.3492, 210.96875, 612.53125);
((GeneralPath)shape).curveTo(186.90793, 601.1379, 167.09196, 587.296, 152.9375, 571.65625);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(1302.515625, 396.677001953125), 252.67184f, new Point2D.Double(1302.515625, 396.677001953125), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.4615497589111328f, 0.0f, 0.0f, 0.7922186255455017f, -1517.09814453125f, 321.0887145996094f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_3_6);
g.setComposite(AlphaComposite.getInstance(3, 0.6287129f * origAlpha));
AffineTransform defaultTransform__0_0_3_7 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, -309.3197326660156f));
// _0_0_3_7
shape = new GeneralPath();
((GeneralPath)shape).moveTo(639.2651, 873.2777);
((GeneralPath)shape).curveTo(639.2651, 943.0168, 526.0559, 999.62146, 386.5777, 999.62146);
((GeneralPath)shape).curveTo(247.82579, 999.62146, 135.0921, 943.61005, 133.9214, 874.37146);
((GeneralPath)shape).lineTo(134.9214, 924.62146);
((GeneralPath)shape).curveTo(134.9214, 994.3606, 247.1306, 1050.9652, 386.609, 1050.9652);
((GeneralPath)shape).curveTo(526.0872, 1050.9652, 638.26514, 994.36053, 638.26514, 924.62146);
((GeneralPath)shape).lineTo(639.26514, 873.2777);
((GeneralPath)shape).closePath();
paint = new Color(0, 0, 0, 76);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_3_7);
g.setComposite(AlphaComposite.getInstance(3, 0.50553507f * origAlpha));
AffineTransform defaultTransform__0_0_3_8 = g.getTransform();
g.transform(new AffineTransform(0.9960461258888245f, 0.0f, 0.0f, 0.9960461258888245f, -910.7724609375f, 72.38355255126953f));
// _0_0_3_8
shape = new GeneralPath();
((GeneralPath)shape).moveTo(1058.9375, 474.46875);
((GeneralPath)shape).curveTo(1069.0624, 497.43295, 1092.363, 518.32214, 1125.4062, 534.84375);
((GeneralPath)shape).curveTo(1170.5197, 557.40045, 1233.2562, 571.5, 1302.5312, 571.5);
((GeneralPath)shape).curveTo(1371.8064, 571.5, 1434.5195, 557.4003, 1479.625, 534.84375);
((GeneralPath)shape).curveTo(1512.5835, 518.3617, 1535.8389, 497.52454, 1546.0, 474.625);
((GeneralPath)shape).curveTo(1532.4229, 496.34863, 1508.5667, 515.9022, 1477.7188, 531.53125);
((GeneralPath)shape).curveTo(1431.8534, 554.769, 1370.2719, 569.5, 1302.5311, 569.5);
((GeneralPath)shape).curveTo(1234.7908, 569.5, 1173.2091, 554.769, 1127.3438, 531.53125);
((GeneralPath)shape).curveTo(1096.4165, 515.86194, 1072.4963, 496.25967, 1058.9375, 474.46875);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(1228.482421875, 349.2613525390625), new Point2D.Double(1228.482421875, 687.31005859375), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(71, 71, 71, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_3_8);
g.setTransform(defaultTransform__0_0_3);
g.setComposite(AlphaComposite.getInstance(3, 0.27227724f * origAlpha));
AffineTransform defaultTransform__0_0_4 = g.getTransform();
g.transform(new AffineTransform(0.9628130197525024f, 0.0f, 0.0f, 0.8727686405181885f, 17.362375259399414f, -33.873504638671875f));
// _0_0_4
paint = new LinearGradientPaint(new Point2D.Double(11.863568305969238, 97.68323516845703), new Point2D.Double(113.55742645263672, 38.211856842041016), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(0.49323508f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(86.26703, 85.22004);
((GeneralPath)shape).curveTo(86.32482, 91.68118, 79.46402, 97.66393, 68.282524, 100.90288);
((GeneralPath)shape).curveTo(57.10102, 104.141815, 43.308144, 104.141815, 32.12664, 100.90288);
((GeneralPath)shape).curveTo(20.945143, 97.66393, 14.084345, 91.68118, 14.142136, 85.22004);
((GeneralPath)shape).curveTo(14.084345, 78.758896, 20.945143, 72.776146, 32.12664, 69.5372);
((GeneralPath)shape).curveTo(43.308144, 66.29826, 57.10102, 66.29826, 68.282524, 69.5372);
((GeneralPath)shape).curveTo(79.46402, 72.776146, 86.32482, 78.758896, 86.26703, 85.22004);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_4);
g.setComposite(AlphaComposite.getInstance(3, 0.27227724f * origAlpha));
AffineTransform defaultTransform__0_0_5 = g.getTransform();
g.transform(new AffineTransform(0.944675087928772f, 0.0f, 0.0f, 0.8563269376754761f, 18.27298355102539f, -32.47234344482422f));
// _0_0_5
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(0.49323508f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(86.26703, 85.22004);
((GeneralPath)shape).curveTo(86.32482, 91.68118, 79.46402, 97.66393, 68.282524, 100.90288);
((GeneralPath)shape).curveTo(57.10102, 104.141815, 43.308144, 104.141815, 32.12664, 100.90288);
((GeneralPath)shape).curveTo(20.945143, 97.66393, 14.084345, 91.68118, 14.142136, 85.22004);
((GeneralPath)shape).curveTo(14.084345, 78.758896, 20.945143, 72.776146, 32.12664, 69.5372);
((GeneralPath)shape).curveTo(43.308144, 66.29826, 57.10102, 66.29826, 68.282524, 69.5372);
((GeneralPath)shape).curveTo(79.46402, 72.776146, 86.32482, 78.758896, 86.26703, 85.22004);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_5);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_6 = g.getTransform();
g.transform(new AffineTransform(0.21102924644947052f, 0.0f, 0.0f, 0.20917175710201263f, -15.882478713989258f, -82.67764282226562f));
// _0_0_6
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_6_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 45.06142807006836f, -54.602901458740234f));
// _0_0_6_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(594.2098, 637.24835);
((GeneralPath)shape).curveTo(594.2098, 707.02344, 481.08197, 763.58734, 341.5318, 763.58734);
((GeneralPath)shape).curveTo(201.9816, 763.58734, 88.853806, 707.02344, 88.853806, 637.24835);
((GeneralPath)shape).curveTo(88.853806, 567.47327, 201.9816, 510.90936, 341.5318, 510.90936);
((GeneralPath)shape).curveTo(481.082, 510.90936, 594.2098, 567.47327, 594.2098, 637.24835);
((GeneralPath)shape).closePath();
paint = new Color(61, 61, 61, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_6_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_6_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 45.06142807006836f, -113.5770263671875f));
// _0_0_6_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(594.2098, 637.24835);
((GeneralPath)shape).curveTo(594.2098, 707.02344, 481.08197, 763.58734, 341.5318, 763.58734);
((GeneralPath)shape).curveTo(201.9816, 763.58734, 88.853806, 707.02344, 88.853806, 637.24835);
((GeneralPath)shape).curveTo(88.853806, 567.47327, 201.9816, 510.90936, 341.5318, 510.90936);
((GeneralPath)shape).curveTo(481.082, 510.90936, 594.2098, 567.47327, 594.2098, 637.24835);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(341.53179931640625, 528.580078125), new Point2D.Double(341.53179931640625, 700.0775146484375), new float[] {0.0f,1.0f}, new Color[] {new Color(252, 252, 252, 255),new Color(192, 192, 192, 255)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_6_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_6_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(639.2651, 523.65924);
((GeneralPath)shape).curveTo(639.2651, 593.3983, 526.0559, 650.003, 386.5777, 650.003);
((GeneralPath)shape).curveTo(247.82579, 650.003, 135.0921, 593.9916, 133.9214, 524.753);
((GeneralPath)shape).lineTo(134.9214, 575.003);
((GeneralPath)shape).curveTo(134.9214, 644.7421, 247.1306, 701.34674, 386.609, 701.34674);
((GeneralPath)shape).curveTo(526.0872, 701.34674, 638.26514, 644.7421, 638.26514, 575.003);
((GeneralPath)shape).lineTo(639.26514, 523.65924);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(902.440185546875, 573.3363647460938), 252.67184f, new Point2D.Double(902.440185546875, 777.675048828125), new float[] {0.0f,0.13883302f,0.27766603f,0.3483148f,0.519832f,0.6913492f,0.7199554f,0.8247441f,0.9112725f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(188, 188, 188, 255),new Color(143, 143, 143, 255),new Color(242, 242, 242, 255),new Color(187, 187, 187, 255),new Color(63, 63, 63, 255),new Color(143, 143, 143, 255),new Color(164, 164, 164, 255),new Color(94, 94, 94, 255),new Color(172, 172, 172, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0000001192092896f, 0.0f, 0.0f, 0.7898656129837036f, -515.8470458984375f, 106.1419677734375f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_6_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_6_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6_3
shape = new GeneralPath();
((GeneralPath)shape).moveTo(566.2773, 486.15744);
((GeneralPath)shape).curveTo(579.07697, 526.5242, 502.6638, 561.86523, 387.09488, 561.86523);
((GeneralPath)shape).curveTo(265.94098, 561.86523, 190.88239, 525.39215, 207.91258, 486.15744);
((GeneralPath)shape).curveTo(230.12598, 434.98117, 310.3997, 410.44965, 387.09488, 410.44965);
((GeneralPath)shape).curveTo(461.0135, 410.44965, 551.8533, 440.668, 566.2773, 486.15744);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(949.625, 517.85107421875), 119.39729f, new Point2D.Double(942.2240600585938, 440.14154052734375), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.709729552268982f, 0.06452833116054535f, -0.0521678701043129f, 0.9870303869247437f, -1209.4918212890625f, -86.25507354736328f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_6_3);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_6_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6_4
shape = new GeneralPath();
((GeneralPath)shape).moveTo(134.39008, 519.2338);
((GeneralPath)shape).curveTo(134.10378, 521.6951, 133.92128, 524.1743, 133.92137, 526.6713);
((GeneralPath)shape).curveTo(133.92137, 596.41046, 247.13057, 653.0151, 386.60876, 653.0151);
((GeneralPath)shape).curveTo(526.08704, 653.0151, 639.2651, 596.41046, 639.2651, 526.6713);
((GeneralPath)shape).curveTo(639.2651, 524.1743, 639.1139, 521.6951, 638.8276, 519.2338);
((GeneralPath)shape).curveTo(631.1191, 585.515, 521.0931, 638.1401, 386.60876, 638.1401);
((GeneralPath)shape).curveTo(252.12456, 638.1401, 142.09857, 585.515, 134.39006, 519.2338);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(1302.515625, 396.677001953125), 252.67184f, new Point2D.Double(1302.515625, 396.677001953125), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.4615497589111328f, 0.0f, 0.0f, 0.7922186255455017f, -1517.09814453125f, 316.29644775390625f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_6_4);
g.setComposite(AlphaComposite.getInstance(3, 0.50553507f * origAlpha));
AffineTransform defaultTransform__0_0_6_5 = g.getTransform();
g.transform(new AffineTransform(0.979244589805603f, 0.0f, 0.0f, 0.979244589805603f, -888.88818359375f, 80.20003509521484f));
// _0_0_6_5
shape = new GeneralPath();
((GeneralPath)shape).moveTo(1050.3125, 441.16064);
((GeneralPath)shape).curveTo(1050.0262, 443.62198, 1049.8438, 446.10114, 1049.8438, 448.59814);
((GeneralPath)shape).curveTo(1049.8438, 518.3373, 1163.053, 574.9419, 1302.5311, 574.9419);
((GeneralPath)shape).curveTo(1442.0094, 574.9419, 1555.1874, 518.3373, 1555.1874, 448.59814);
((GeneralPath)shape).curveTo(1555.1874, 446.10114, 1555.0361, 443.62198, 1554.7499, 441.16064);
((GeneralPath)shape).curveTo(1547.0414, 507.44183, 1437.0154, 566.0669, 1302.5311, 566.0669);
((GeneralPath)shape).curveTo(1168.0469, 566.0669, 1058.021, 507.44183, 1050.3124, 441.16064);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(1228.482421875, 349.2613525390625), new Point2D.Double(1228.482421875, 687.31005859375), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(71, 71, 71, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_6_5);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_6_6 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6_6
shape = new GeneralPath();
((GeneralPath)shape).moveTo(152.9375, 571.65625);
((GeneralPath)shape).curveTo(165.10074, 588.474, 184.4765, 603.8789, 210.03125, 616.65625);
((GeneralPath)shape).curveTo(254.92583, 639.1035, 317.48145, 653.1875, 386.59375, 653.1875);
((GeneralPath)shape).curveTo(455.70612, 653.1875, 518.26965, 639.1034, 563.15625, 616.65625);
((GeneralPath)shape).curveTo(588.5327, 603.9658, 607.79047, 588.6834, 619.96875, 572.0);
((GeneralPath)shape).curveTo(605.8334, 587.5018, 586.10754, 601.21936, 562.21875, 612.53125);
((GeneralPath)shape).curveTo(516.143, 634.3492, 454.44025, 647.5625, 386.59375, 647.5625);
((GeneralPath)shape).curveTo(318.7473, 647.5625, 257.0445, 634.3492, 210.96875, 612.53125);
((GeneralPath)shape).curveTo(186.90793, 601.1379, 167.09196, 587.296, 152.9375, 571.65625);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(1302.515625, 396.677001953125), 252.67184f, new Point2D.Double(1302.515625, 396.677001953125), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.4615497589111328f, 0.0f, 0.0f, 0.7922186255455017f, -1517.09814453125f, 321.0887145996094f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_6_6);
g.setComposite(AlphaComposite.getInstance(3, 0.6287129f * origAlpha));
AffineTransform defaultTransform__0_0_6_7 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, -309.3197326660156f));
// _0_0_6_7
shape = new GeneralPath();
((GeneralPath)shape).moveTo(639.2651, 873.2777);
((GeneralPath)shape).curveTo(639.2651, 943.0168, 526.0559, 999.62146, 386.5777, 999.62146);
((GeneralPath)shape).curveTo(247.82579, 999.62146, 135.0921, 943.61005, 133.9214, 874.37146);
((GeneralPath)shape).lineTo(134.9214, 924.62146);
((GeneralPath)shape).curveTo(134.9214, 994.3606, 247.1306, 1050.9652, 386.609, 1050.9652);
((GeneralPath)shape).curveTo(526.0872, 1050.9652, 638.26514, 994.36053, 638.26514, 924.62146);
((GeneralPath)shape).lineTo(639.26514, 873.2777);
((GeneralPath)shape).closePath();
paint = new Color(0, 0, 0, 76);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_6_7);
g.setComposite(AlphaComposite.getInstance(3, 0.50553507f * origAlpha));
AffineTransform defaultTransform__0_0_6_8 = g.getTransform();
g.transform(new AffineTransform(0.9960461258888245f, 0.0f, 0.0f, 0.9960461258888245f, -910.7724609375f, 72.38355255126953f));
// _0_0_6_8
shape = new GeneralPath();
((GeneralPath)shape).moveTo(1058.9375, 474.46875);
((GeneralPath)shape).curveTo(1069.0624, 497.43295, 1092.363, 518.32214, 1125.4062, 534.84375);
((GeneralPath)shape).curveTo(1170.5197, 557.40045, 1233.2562, 571.5, 1302.5312, 571.5);
((GeneralPath)shape).curveTo(1371.8064, 571.5, 1434.5195, 557.4003, 1479.625, 534.84375);
((GeneralPath)shape).curveTo(1512.5835, 518.3617, 1535.8389, 497.52454, 1546.0, 474.625);
((GeneralPath)shape).curveTo(1532.4229, 496.34863, 1508.5667, 515.9022, 1477.7188, 531.53125);
((GeneralPath)shape).curveTo(1431.8534, 554.769, 1370.2719, 569.5, 1302.5311, 569.5);
((GeneralPath)shape).curveTo(1234.7908, 569.5, 1173.2091, 554.769, 1127.3438, 531.53125);
((GeneralPath)shape).curveTo(1096.4165, 515.86194, 1072.4963, 496.25967, 1058.9375, 474.46875);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(1228.482421875, 349.2613525390625), new Point2D.Double(1228.482421875, 687.31005859375), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(71, 71, 71, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_6_8);
g.setTransform(defaultTransform__0_0_6);
g.setComposite(AlphaComposite.getInstance(3, 0.27227724f * origAlpha));
AffineTransform defaultTransform__0_0_7 = g.getTransform();
g.transform(new AffineTransform(0.9628130197525024f, 0.0f, 0.0f, 0.8727686405181885f, 17.362375259399414f, -48.873504638671875f));
// _0_0_7
paint = new LinearGradientPaint(new Point2D.Double(11.863568305969238, 97.68323516845703), new Point2D.Double(113.55742645263672, 38.211856842041016), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(0.49323508f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(86.26703, 85.22004);
((GeneralPath)shape).curveTo(86.32482, 91.68118, 79.46402, 97.66393, 68.282524, 100.90288);
((GeneralPath)shape).curveTo(57.10102, 104.141815, 43.308144, 104.141815, 32.12664, 100.90288);
((GeneralPath)shape).curveTo(20.945143, 97.66393, 14.084345, 91.68118, 14.142136, 85.22004);
((GeneralPath)shape).curveTo(14.084345, 78.758896, 20.945143, 72.776146, 32.12664, 69.5372);
((GeneralPath)shape).curveTo(43.308144, 66.29826, 57.10102, 66.29826, 68.282524, 69.5372);
((GeneralPath)shape).curveTo(79.46402, 72.776146, 86.32482, 78.758896, 86.26703, 85.22004);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_7);
g.setComposite(AlphaComposite.getInstance(3, 0.27227724f * origAlpha));
AffineTransform defaultTransform__0_0_8 = g.getTransform();
g.transform(new AffineTransform(0.944675087928772f, 0.0f, 0.0f, 0.8563269376754761f, 18.27298355102539f, -47.47234344482422f));
// _0_0_8
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(0.49323508f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(86.26703, 85.22004);
((GeneralPath)shape).curveTo(86.32482, 91.68118, 79.46402, 97.66393, 68.282524, 100.90288);
((GeneralPath)shape).curveTo(57.10102, 104.141815, 43.308144, 104.141815, 32.12664, 100.90288);
((GeneralPath)shape).curveTo(20.945143, 97.66393, 14.084345, 91.68118, 14.142136, 85.22004);
((GeneralPath)shape).curveTo(14.084345, 78.758896, 20.945143, 72.776146, 32.12664, 69.5372);
((GeneralPath)shape).curveTo(43.308144, 66.29826, 57.10102, 66.29826, 68.282524, 69.5372);
((GeneralPath)shape).curveTo(79.46402, 72.776146, 86.32482, 78.758896, 86.26703, 85.22004);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_8);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_9 = g.getTransform();
g.transform(new AffineTransform(0.6433923244476318f, 0.0f, 0.0f, 0.6433923244476318f, 122.7645492553711f, 84.17054748535156f));
// _0_0_9
g.setTransform(defaultTransform__0_0_9);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_10 = g.getTransform();
g.transform(new AffineTransform(0.6433923244476318f, 0.0f, 0.0f, 0.6433923244476318f, 122.7645492553711f, 84.17054748535156f));
// _0_0_10
g.setTransform(defaultTransform__0_0_10);
g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));
AffineTransform defaultTransform__0_0_11 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_11
g.setTransform(defaultTransform__0_0_11);
g.setComposite(AlphaComposite.getInstance(3, 0.501845f * origAlpha));
AffineTransform defaultTransform__0_0_12 = g.getTransform();
g.transform(new AffineTransform(0.4857213795185089f, 0.0f, 0.0f, 0.4150945544242859f, 66.84616088867188f, 67.71189880371094f));
// _0_0_12
g.setTransform(defaultTransform__0_0_12);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_13 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_13
shape = new GeneralPath();
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_13);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_14 = g.getTransform();
g.transform(new AffineTransform(0.3336920142173767f, 0.0f, 0.0f, 0.3336920142173767f, -733.6383666992188f, -244.40249633789062f));
// _0_0_14
g.setTransform(defaultTransform__0_0_14);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_15 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -28.032392501831055f, 0.0f));
// _0_0_15
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_15_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(126.87202, 82.900795);
((GeneralPath)shape).lineTo(95.925125, 125.65247);
((GeneralPath)shape).curveTo(95.47954, 126.27374, 94.81932, 126.63298, 94.12311, 126.63298);
((GeneralPath)shape).curveTo(93.426895, 126.63298, 92.76667, 126.27374, 92.32109, 125.65247);
((GeneralPath)shape).lineTo(61.380028, 82.46643);
((GeneralPath)shape).curveTo(59.718155, 79.848816, 59.482674, 76.089226, 63.165054, 76.089226);
((GeneralPath)shape).lineTo(79.95998, 76.089226);
((GeneralPath)shape).lineTo(79.95998, 62.53485);
((GeneralPath)shape).curveTo(79.95955, 61.02988, 81.191315, 60.007187, 82.48716, 60.00766);
((GeneralPath)shape).lineTo(105.50521, 59.91843);
((GeneralPath)shape).curveTo(106.80106, 59.917957, 108.03282, 60.940655, 108.032394, 62.44562);
((GeneralPath)shape).lineTo(108.032394, 76.0);
((GeneralPath)shape).lineTo(124.44936, 76.08923);
((GeneralPath)shape).curveTo(126.90776, 76.08923, 128.5897, 80.52477, 126.872025, 82.900795);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(186.92596435546875, 89.88978576660156), new Point2D.Double(242.8547821044922, 91.35980987548828), new float[] {0.0f,1.0f}, new Color[] {new Color(8, 30, 62, 255),new Color(56, 125, 228, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.0f, -0.6317968964576721f, -0.5440064072608948f, 0.0f, 135.46548461914062f, 197.39422607421875f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_15_0);
g.setComposite(AlphaComposite.getInstance(3, 0.25468165f * origAlpha));
AffineTransform defaultTransform__0_0_15_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(126.87202, 82.900795);
((GeneralPath)shape).lineTo(95.925125, 125.65247);
((GeneralPath)shape).curveTo(95.47954, 126.27374, 94.81932, 126.63298, 94.12311, 126.63298);
((GeneralPath)shape).curveTo(93.426895, 126.63298, 92.76667, 126.27374, 92.32109, 125.65247);
((GeneralPath)shape).lineTo(61.380028, 82.46643);
((GeneralPath)shape).curveTo(59.718155, 79.848816, 59.482674, 76.089226, 63.165054, 76.089226);
((GeneralPath)shape).lineTo(79.95998, 76.089226);
((GeneralPath)shape).lineTo(79.95998, 62.53485);
((GeneralPath)shape).curveTo(79.95955, 61.02988, 81.191315, 60.007187, 82.48716, 60.00766);
((GeneralPath)shape).lineTo(105.45904, 60.00766);
((GeneralPath)shape).curveTo(106.75489, 60.007187, 107.98665, 61.029884, 107.98622, 62.53485);
((GeneralPath)shape).lineTo(107.98622, 76.089226);
((GeneralPath)shape).lineTo(124.44936, 76.089226);
((GeneralPath)shape).curveTo(126.90776, 76.089226, 128.5897, 80.524765, 126.872025, 82.90079);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(68.02018737792969, 88.27139282226562), 60.0f, new Point2D.Double(68.02018737792969, 88.27139282226562), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.030379630625247955f, -0.36638343334198f, -0.7259783148765564f, -0.06019638851284981f, 164.45135498046875f, 124.58737182617188f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_15_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_15_2 = g.getTransform();
g.transform(new AffineTransform(0.0f, -0.6317968964576721f, -0.6317968964576721f, 0.0f, 134.55810546875f, 129.16017150878906f));
// _0_0_15_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(76.5, 11.0625);
((GeneralPath)shape).curveTo(75.42291, 11.12778, 74.3861, 11.439286, 73.5, 12.0);
((GeneralPath)shape).lineTo(75.875, 19.625);
((GeneralPath)shape).lineTo(84.0, 16.46875);
((GeneralPath)shape).lineTo(84.0, 16.0);
((GeneralPath)shape).curveTo(84.0, 13.081648, 80.06108, 10.846661, 76.5, 11.0625);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(73.74263763427734, 15.336544036865234), new Point2D.Double(78.93933868408203, 16.75075912475586), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 4.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_15_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_15_3 = g.getTransform();
g.transform(new AffineTransform(0.0f, -0.6317968964576721f, 0.6317968964576721f, 0.0f, 55.20912170410156f, 136.123291015625f));
// _0_0_15_3
shape = new GeneralPath();
((GeneralPath)shape).moveTo(115.65112, 40.0);
((GeneralPath)shape).curveTo(115.31168, 41.15456, 113.08862, 46.125, 113.08862, 46.125);
((GeneralPath)shape).lineTo(119.83862, 46.09375);
((GeneralPath)shape).lineTo(119.83862, 44.0);
((GeneralPath)shape).curveTo(119.839386, 41.94895, 118.220665, 39.999344, 115.83862, 40.0);
((GeneralPath)shape).lineTo(115.65112, 40.0);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(223.32711791992188, 53.78415298461914), new Point2D.Double(226.65899658203125, 57.279232025146484), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.861046314239502f, -108.161376953125f, -1.436186671257019f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_15_3);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_15_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_4
shape = new GeneralPath();
((GeneralPath)shape).moveTo(126.87202, 82.900795);
((GeneralPath)shape).lineTo(95.925125, 125.65247);
((GeneralPath)shape).curveTo(95.47954, 126.27374, 94.81932, 126.63298, 94.12311, 126.63298);
((GeneralPath)shape).curveTo(93.426895, 126.63298, 92.76667, 126.27374, 92.32109, 125.65247);
((GeneralPath)shape).lineTo(61.380028, 82.46643);
((GeneralPath)shape).curveTo(59.718155, 79.848816, 59.482674, 76.089226, 63.165054, 76.089226);
((GeneralPath)shape).lineTo(79.95998, 76.089226);
((GeneralPath)shape).lineTo(79.95998, 62.53485);
((GeneralPath)shape).curveTo(79.95955, 61.02988, 81.191315, 60.007187, 82.48716, 60.00766);
((GeneralPath)shape).lineTo(105.45904, 60.00766);
((GeneralPath)shape).curveTo(106.75489, 60.007187, 107.98665, 61.029884, 107.98622, 62.53485);
((GeneralPath)shape).lineTo(107.98622, 76.089226);
((GeneralPath)shape).lineTo(124.44936, 76.089226);
((GeneralPath)shape).curveTo(126.90776, 76.089226, 128.5897, 80.524765, 126.872025, 82.90079);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(-23.234317779541016, 61.87726593017578), 60.0f, new Point2D.Double(-23.234317779541016, 61.87726593017578), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-0.011168699711561203f, -0.3674710988998413f, -0.5609713196754456f, 0.01704983040690422f, 130.80404663085938f, 108.9920425415039f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_15_4);
g.setComposite(AlphaComposite.getInstance(3, 0.70411986f * origAlpha));
AffineTransform defaultTransform__0_0_15_5 = g.getTransform();
g.transform(new AffineTransform(0.0f, -0.5254283547401428f, 0.6317968964576721f, 0.0f, 53.19267654418945f, 118.12349700927734f));
// _0_0_15_5
shape = new GeneralPath();
((GeneralPath)shape).moveTo(72.5, 11.0625);
((GeneralPath)shape).curveTo(71.42291, 11.12778, 70.3861, 11.439286, 69.5, 12.0);
((GeneralPath)shape).lineTo(71.875, 19.625);
((GeneralPath)shape).lineTo(80.0, 16.46875);
((GeneralPath)shape).lineTo(80.0, 16.0);
((GeneralPath)shape).curveTo(80.0, 13.081648, 76.06108, 10.846661, 72.5, 11.0625);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(74.75, 14.275883674621582), new Point2D.Double(78.93933868408203, 16.75075912475586), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_15_5);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_15_6 = g.getTransform();
g.transform(new AffineTransform(0.631542444229126f, 0.017931750044226646f, -0.017931750044226646f, 0.631542444229126f, 32.52680206298828f, 33.16581344604492f));
// _0_0_15_6
shape = new GeneralPath();
((GeneralPath)shape).moveTo(115.65112, 40.0);
((GeneralPath)shape).curveTo(115.31168, 41.15456, 113.08862, 46.125, 113.08862, 46.125);
((GeneralPath)shape).lineTo(119.83862, 46.09375);
((GeneralPath)shape).lineTo(119.83862, 44.0);
((GeneralPath)shape).curveTo(119.839386, 41.94895, 118.220665, 39.999344, 115.83862, 40.0);
((GeneralPath)shape).lineTo(115.65112, 40.0);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(223.32711791992188, 53.78415298461914), new Point2D.Double(226.65899658203125, 57.279232025146484), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.861046314239502f, -108.161376953125f, -1.436186671257019f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_15_6);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_15_7 = g.getTransform();
g.transform(new AffineTransform(0.6317968964576721f, 0.0f, 0.0f, -0.6317968964576721f, 53.71141815185547f, 129.17010498046875f));
// _0_0_15_7
shape = new GeneralPath();
((GeneralPath)shape).moveTo(61.556484, 5.221757);
((GeneralPath)shape).curveTo(63.245625, 3.7628593, 64.797745, 4.1537676, 66.30962, 5.087866);
((GeneralPath)shape).lineTo(64.06695, 18.984468);
((GeneralPath)shape).lineTo(61.556484, 5.221757);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(63.93305587768555, 7.566767692565918), new Point2D.Double(66.20711517333984, 7.566767692565918), new float[] {0.0f,1.0f}, new Color[] {new Color(99, 233, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_15_7);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_15_8 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_8
shape = new GeneralPath();
((GeneralPath)shape).moveTo(126.87202, 82.900795);
((GeneralPath)shape).lineTo(95.925125, 125.65247);
((GeneralPath)shape).curveTo(95.47954, 126.27374, 94.81932, 126.63298, 94.12311, 126.63298);
((GeneralPath)shape).curveTo(93.426895, 126.63298, 92.76667, 126.27374, 92.32109, 125.65247);
((GeneralPath)shape).lineTo(61.380028, 82.46643);
((GeneralPath)shape).curveTo(59.718155, 79.848816, 59.482674, 76.089226, 63.165054, 76.089226);
((GeneralPath)shape).lineTo(79.95998, 76.089226);
((GeneralPath)shape).lineTo(79.95998, 62.53485);
((GeneralPath)shape).curveTo(79.95955, 61.02988, 81.191315, 60.007187, 82.48716, 60.00766);
((GeneralPath)shape).lineTo(105.45904, 60.00766);
((GeneralPath)shape).curveTo(106.75489, 60.007187, 107.98665, 61.029884, 107.98622, 62.53485);
((GeneralPath)shape).lineTo(107.98622, 76.089226);
((GeneralPath)shape).lineTo(124.44936, 76.089226);
((GeneralPath)shape).curveTo(126.90776, 76.089226, 128.5897, 80.524765, 126.872025, 82.90079);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(64.0, 46.527523040771484), 53.298492f, new Point2D.Double(64.0, 46.527523040771484), new float[] {0.0f,1.0f}, new Color[] {new Color(46, 106, 196, 255),new Color(46, 106, 196, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.5249295234680176f, 0.015562600456178188f, -0.0018859399715438485f, 0.18479731678962708f, -3.3613109588623047f, 66.99590301513672f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_15_8);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_15_9 = g.getTransform();
g.transform(new AffineTransform(0.0f, -0.6317968964576721f, -0.5439686179161072f, 0.0f, 135.4647216796875f, 197.39422607421875f));
// _0_0_15_9
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_15_9_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_9_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(179.33453, 26.979963);
((GeneralPath)shape).lineTo(123.653824, 73.57467);
((GeneralPath)shape).curveTo(122.26802, 75.18421, 122.48985, 76.59585, 123.551384, 77.82877);
((GeneralPath)shape).lineTo(177.78409, 123.563644);
((GeneralPath)shape).curveTo(181.78409, 127.14578, 185.78409, 127.336876, 185.78409, 123.563644);
((GeneralPath)shape).lineTo(185.81009, 94.609726);
((GeneralPath)shape).lineTo(211.13469, 94.609726);
((GeneralPath)shape).lineTo(211.13474, 57.8429);
((GeneralPath)shape).lineTo(185.81013, 57.8429);
((GeneralPath)shape).lineTo(185.78413, 29.44426);
((GeneralPath)shape).curveTo(185.78413, 26.253387, 182.63127, 24.76931, 179.33458, 26.979967);
((GeneralPath)shape).lineTo(179.33456, 26.979967);
((GeneralPath)shape).lineTo(179.33453, 26.979967);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(136.6140899658203, 76.10952758789062), 56.0f, new Point2D.Double(136.6140899658203, 76.10952758789062), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(159, 193, 242, 255),new Color(88, 126, 181, 255),new Color(12, 42, 88, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.1383929252624512f, 0.0f, -10.51785659790039f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_15_9_0);
g.setTransform(defaultTransform__0_0_15_9);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_15_10 = g.getTransform();
g.transform(new AffineTransform(0.0f, -0.6317968964576721f, -0.5439686179161072f, 0.0f, 135.59107971191406f, 258.80682373046875f));
// _0_0_15_10
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_15_10_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_10_0
paint = new LinearGradientPaint(new Point2D.Double(119.33738708496094, 59.541107177734375), new Point2D.Double(178.90383911132812, 61.049652099609375), new float[] {0.0f,1.0f}, new Color[] {new Color(99, 233, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 97.0f, 0.0f));
stroke = new BasicStroke(1.7057853f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(276.49283, 26.97996);
((GeneralPath)shape).lineTo(220.85384, 73.80696);
((GeneralPath)shape).curveTo(219.46803, 75.416504, 219.68987, 76.82814, 220.75139, 78.061066);
((GeneralPath)shape).lineTo(274.94238, 123.563644);
((GeneralPath)shape).curveTo(278.94238, 127.14578, 282.94238, 127.336876, 282.94238, 123.563644);
((GeneralPath)shape).lineTo(283.0131, 94.842026);
((GeneralPath)shape).lineTo(308.3377, 94.84202);
((GeneralPath)shape).lineTo(308.3377, 58.07519);
((GeneralPath)shape).lineTo(283.01312, 58.04835);
((GeneralPath)shape).lineTo(283.01224, 57.715527);
((GeneralPath)shape).lineTo(282.94244, 29.444254);
((GeneralPath)shape).curveTo(282.94244, 26.253382, 279.78958, 24.769304, 276.4929, 26.979961);
((GeneralPath)shape).lineTo(276.49286, 26.979965);
((GeneralPath)shape).lineTo(276.4929, 26.979965);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_15_10_0);
g.setTransform(defaultTransform__0_0_15_10);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_15_11 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_11
shape = new GeneralPath();
((GeneralPath)shape).moveTo(84.0, 64.0);
((GeneralPath)shape).lineTo(84.0, 80.0);
((GeneralPath)shape).lineTo(68.24172, 80.02621);
((GeneralPath)shape).curveTo(66.1892, 80.02621, 66.29315, 82.5534, 68.24172, 85.08058);
((GeneralPath)shape).lineTo(73.32661, 91.93343);
((GeneralPath)shape).curveTo(76.51979, 92.14834, 77.473785, 92.269066, 80.77997, 92.269066);
((GeneralPath)shape).curveTo(95.76103, 92.269066, 106.70982, 91.38768, 118.412415, 87.46957);
((GeneralPath)shape).lineTo(120.781654, 84.0934);
((GeneralPath)shape).curveTo(121.98418, 82.01056, 121.17483, 80.02621, 119.439095, 80.02621);
((GeneralPath)shape).lineTo(104.0, 80.0);
((GeneralPath)shape).lineTo(104.0, 64.0);
((GeneralPath)shape).lineTo(84.0, 64.0);
((GeneralPath)shape).lineTo(84.0, 64.0);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(111.81199645996094, 2.8030190467834473), new Point2D.Double(112.0, 75.10427856445312), new float[] {0.0f,1.0f}, new Color[] {new Color(205, 238, 255, 255),new Color(210, 232, 237, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.6317968964576721f, 0.0f, 0.0f, 0.6317968964576721f, 53.71141815185547f, 48.28022384643555f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_15_11);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_15_12 = g.getTransform();
g.transform(new AffineTransform(0.6317968964576721f, 0.0f, 0.0f, 0.6317968964576721f, 143.54481506347656f, 48.28022384643555f));
// _0_0_15_12
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_15_12_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_12_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(-94.24676, 24.881062);
((GeneralPath)shape).lineTo(-94.24676, 25.88106);
((GeneralPath)shape).lineTo(-63.31684, 25.95174);
((GeneralPath)shape).lineTo(-62.59102, 24.881062);
((GeneralPath)shape).lineTo(-94.246765, 24.881062);
((GeneralPath)shape).closePath();
((GeneralPath)shape).moveTo(-118.93914, 50.247154);
((GeneralPath)shape).curveTo(-120.702, 50.247154, -121.45124, 51.436893, -121.28289, 53.153404);
((GeneralPath)shape).curveTo(-121.10926, 51.991547, -120.33656, 51.247154, -118.93914, 51.247154);
((GeneralPath)shape).lineTo(-97.96875, 51.247154);
((GeneralPath)shape).lineTo(-94.226425, 50.205658);
((GeneralPath)shape).lineTo(-118.93914, 50.247158);
((GeneralPath)shape).closePath();
((GeneralPath)shape).moveTo(-62.591015, 50.205654);
((GeneralPath)shape).lineTo(-63.350227, 51.247154);
((GeneralPath)shape).lineTo(-37.90461, 51.247154);
((GeneralPath)shape).curveTo(-36.220592, 51.247154, -35.091072, 52.418156, -34.90461, 54.090904);
((GeneralPath)shape).curveTo(-34.682312, 51.908, -35.901196, 50.247154, -37.90461, 50.247154);
((GeneralPath)shape).lineTo(-62.59101, 50.205654);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(111.81199645996094, 2.8030190467834473), new Point2D.Double(112.0, 75.10427856445312), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -141.9246826171875f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_15_12_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_15_12_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_12_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(-63.31159, 25.944496);
((GeneralPath)shape).lineTo(-63.35787, 51.24436);
((GeneralPath)shape).lineTo(-62.591, 50.205658);
((GeneralPath)shape).lineTo(-62.591003, 24.881065);
((GeneralPath)shape).lineTo(-63.311584, 25.9445);
((GeneralPath)shape).closePath();
((GeneralPath)shape).moveTo(-35.778225, 53.07994);
((GeneralPath)shape).curveTo(-35.773125, 54.028244, -35.554813, 53.717487, -36.184475, 54.822155);
((GeneralPath)shape).lineTo(-40.234474, 60.459656);
((GeneralPath)shape).curveTo(-58.757195, 67.074814, -75.970215, 68.56427, -99.68205, 69.09375);
((GeneralPath)shape).curveTo(-104.754005, 69.20701, -109.746445, 69.14874, -114.650795, 68.9375);
((GeneralPath)shape).lineTo(-114.525795, 69.09375);
((GeneralPath)shape).curveTo(-109.471664, 69.4339, -104.32127, 69.625, -99.0883, 69.625);
((GeneralPath)shape).curveTo(-75.37647, 69.625, -58.36344, 68.22995, -39.84072, 62.0284);
((GeneralPath)shape).lineTo(-36.09072, 56.68465);
((GeneralPath)shape).curveTo(-34.92921, 54.672855, -34.95845, 54.297287, -35.77822, 53.079937);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(79.73841094970703, 82.60218811035156), new Point2D.Double(50.94560623168945, 22.886703491210938), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -141.92552185058594f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_15_12_1);
g.setTransform(defaultTransform__0_0_15_12);
g.setTransform(defaultTransform__0_0_15);
g.setTransform(defaultTransform__0_0);
g.setTransform(defaultTransform__0);
g.setTransform(defaultTransform_);

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
		return 127.53147888183594;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private svn_update() {
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
	public void setDimension(Dimension newDimension) {
		this.width = newDimension.width;
		this.height = newDimension.height;
	}

    @Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
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
       svn_update base = new svn_update();
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
       svn_update base = new svn_update();
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
        return svn_update::new;
    }
}

