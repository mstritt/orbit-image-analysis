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
public class go_up_7 implements ResizableIcon {
    

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
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(115.79764, 73.2345);
((GeneralPath)shape).lineTo(66.8153, 5.5676837);
((GeneralPath)shape).curveTo(66.11003, 4.584344, 65.06503, 4.0157437, 63.96308, 4.0157437);
((GeneralPath)shape).curveTo(62.86113, 4.0157437, 61.816135, 4.584344, 61.110867, 5.5676837);
((GeneralPath)shape).lineTo(12.137772, 73.922);
((GeneralPath)shape).curveTo(9.507381, 78.06512, 9.134662, 84.01575, 14.963082, 84.01575);
((GeneralPath)shape).lineTo(39.963078, 84.01575);
((GeneralPath)shape).lineTo(39.963078, 116.01574);
((GeneralPath)shape).curveTo(39.962425, 118.39778, 41.91203, 120.0165, 43.96308, 120.01574);
((GeneralPath)shape).lineTo(83.96308, 120.01574);
((GeneralPath)shape).curveTo(86.01413, 120.0165, 87.96374, 118.39778, 87.96308, 116.01574);
((GeneralPath)shape).lineTo(87.96308, 84.01575);
((GeneralPath)shape).lineTo(111.96309, 84.01575);
((GeneralPath)shape).curveTo(115.85422, 84.01575, 118.51638, 76.995224, 115.79764, 73.2345);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(194.5, 123.90682983398438), new Point2D.Double(104.25, 5.15595817565918), new float[] {0.0f,1.0f}, new Color[] {new Color(8, 30, 62, 255),new Color(56, 125, 228, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.0f, 1.0f, -0.861046314239502f, 0.0f, 129.39927673339844f, -107.98426055908203f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 0.25468165f * origAlpha));
AffineTransform defaultTransform__0_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(115.79764, 73.2345);
((GeneralPath)shape).lineTo(66.8153, 5.5676837);
((GeneralPath)shape).curveTo(66.11003, 4.584344, 65.06503, 4.0157437, 63.96308, 4.0157437);
((GeneralPath)shape).curveTo(62.86113, 4.0157437, 61.816135, 4.584344, 61.110867, 5.5676837);
((GeneralPath)shape).lineTo(12.137772, 73.922);
((GeneralPath)shape).curveTo(9.507381, 78.06512, 9.134662, 84.01575, 14.963082, 84.01575);
((GeneralPath)shape).lineTo(39.963078, 84.01575);
((GeneralPath)shape).lineTo(39.963078, 116.01574);
((GeneralPath)shape).curveTo(39.962425, 118.39778, 41.91203, 120.0165, 43.96308, 120.01574);
((GeneralPath)shape).lineTo(83.96308, 120.01574);
((GeneralPath)shape).curveTo(86.01413, 120.0165, 87.96374, 118.39778, 87.96308, 116.01574);
((GeneralPath)shape).lineTo(87.96308, 84.01575);
((GeneralPath)shape).lineTo(111.96309, 84.01575);
((GeneralPath)shape).curveTo(115.85422, 84.01575, 118.51638, 76.995224, 115.79764, 73.2345);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(-16.668487548828125, 86.82696533203125), 60.0f, new Point2D.Double(-16.668487548828125, 86.82696533203125), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.521247386932373f, 0.2586607038974762f, -0.41060110926628113f, 0.8274344205856323f, 77.90748596191406f, -35.523704528808594f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2 = g.getTransform();
g.transform(new AffineTransform(0.0f, 1.0f, -1.0f, 0.0f, 127.96308898925781f, 0.015743745490908623f));
// _0_0_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(76.5, 11.0625);
((GeneralPath)shape).curveTo(75.42291, 11.127783, 74.3861, 11.439286, 73.5, 12.0);
((GeneralPath)shape).lineTo(75.875, 19.625);
((GeneralPath)shape).lineTo(84.0, 16.46875);
((GeneralPath)shape).lineTo(84.0, 16.0);
((GeneralPath)shape).curveTo(84.0, 13.081648, 80.06108, 10.84666, 76.5, 11.0625);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(73.74263763427734, 15.336544036865234), new Point2D.Double(78.93933868408203, 16.75075912475586), new float[] {0.0f,1.0f}, new Color[] {new Color(99, 233, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 4.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2);
g.setComposite(AlphaComposite.getInstance(3, 0.6142322f * origAlpha));
AffineTransform defaultTransform__0_0_3 = g.getTransform();
g.transform(new AffineTransform(0.0f, 1.0f, 1.0f, 0.0f, -0.16191840171813965f, 0.015743745490908623f));
// _0_0_3
shape = new GeneralPath();
((GeneralPath)shape).moveTo(115.65112, 40.0);
((GeneralPath)shape).curveTo(115.31168, 41.15456, 113.08862, 46.125, 113.08862, 46.125);
((GeneralPath)shape).lineTo(119.83862, 46.09375);
((GeneralPath)shape).lineTo(119.83862, 44.0);
((GeneralPath)shape).curveTo(119.83938, 41.94895, 118.22066, 39.999344, 115.83862, 40.0);
((GeneralPath)shape).lineTo(115.65112, 40.0);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(223.32711791992188, 53.78415298461914), new Point2D.Double(226.65899658203125, 57.279232025146484), new float[] {0.0f,1.0f}, new Color[] {new Color(99, 233, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.861046314239502f, -108.161376953125f, -1.436186671257019f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_3);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
shape = new GeneralPath();
((GeneralPath)shape).moveTo(115.79764, 73.2345);
((GeneralPath)shape).lineTo(66.8153, 5.5676837);
((GeneralPath)shape).curveTo(66.11003, 4.584344, 65.06503, 4.0157437, 63.96308, 4.0157437);
((GeneralPath)shape).curveTo(62.86113, 4.0157437, 61.816135, 4.584344, 61.110867, 5.5676837);
((GeneralPath)shape).lineTo(12.137772, 73.922);
((GeneralPath)shape).curveTo(9.507381, 78.06512, 9.134662, 84.01575, 14.963082, 84.01575);
((GeneralPath)shape).lineTo(39.963078, 84.01575);
((GeneralPath)shape).lineTo(39.963078, 116.01574);
((GeneralPath)shape).curveTo(39.962425, 118.39778, 41.91203, 120.0165, 43.96308, 120.01574);
((GeneralPath)shape).lineTo(83.96308, 120.01574);
((GeneralPath)shape).curveTo(86.01413, 120.0165, 87.96374, 118.39778, 87.96308, 116.01574);
((GeneralPath)shape).lineTo(87.96308, 84.01575);
((GeneralPath)shape).lineTo(111.96309, 84.01575);
((GeneralPath)shape).curveTo(115.85422, 84.01575, 118.51638, 76.995224, 115.79764, 73.2345);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(79.40702056884766, 56.84811782836914), 60.0f, new Point2D.Double(79.40702056884766, 56.84811782836914), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-0.01767767034471035f, 0.5816285014152527f, -0.8878982067108154f, -0.026986248791217804f, 122.02117919921875f, 31.937589645385742f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_4);
g.setComposite(AlphaComposite.getInstance(3, 0.70411986f * origAlpha));
AffineTransform defaultTransform__0_0_5 = g.getTransform();
g.transform(new AffineTransform(0.0f, 0.8316411972045898f, 1.0f, 0.0f, -0.8210684061050415f, 17.48444366455078f));
// _0_0_5
shape = new GeneralPath();
((GeneralPath)shape).moveTo(72.5, 11.0625);
((GeneralPath)shape).curveTo(71.42291, 11.127783, 70.3861, 11.439286, 69.5, 12.0);
((GeneralPath)shape).lineTo(71.875, 19.625);
((GeneralPath)shape).lineTo(80.0, 16.46875);
((GeneralPath)shape).lineTo(80.0, 16.0);
((GeneralPath)shape).curveTo(80.0, 13.081648, 76.06108, 10.84666, 72.5, 11.0625);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(74.75, 14.275883674621582), new Point2D.Double(78.93933868408203, 16.75075912475586), new float[] {0.0f,1.0f}, new Color[] {new Color(99, 233, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_5);
g.setComposite(AlphaComposite.getInstance(3, 0.7490637f * origAlpha));
AffineTransform defaultTransform__0_0_6 = g.getTransform();
g.transform(new AffineTransform(0.9995971918106079f, -0.028382137417793274f, -0.028382137417793274f, -0.9995971918106079f, -30.523448944091797f, 163.1337890625f));
// _0_0_6
shape = new GeneralPath();
((GeneralPath)shape).moveTo(115.65112, 40.0);
((GeneralPath)shape).curveTo(115.31168, 41.15456, 113.08862, 46.125, 113.08862, 46.125);
((GeneralPath)shape).lineTo(119.83862, 46.09375);
((GeneralPath)shape).lineTo(119.83862, 44.0);
((GeneralPath)shape).curveTo(119.83938, 41.94895, 118.22066, 39.999344, 115.83862, 40.0);
((GeneralPath)shape).lineTo(115.65112, 40.0);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(223.32711791992188, 53.78415298461914), new Point2D.Double(226.65899658203125, 57.279232025146484), new float[] {0.0f,1.0f}, new Color[] {new Color(99, 233, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.861046314239502f, -108.161376953125f, -1.436186671257019f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_6);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_7 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
shape = new GeneralPath();
((GeneralPath)shape).moveTo(61.556484, 5.221757);
((GeneralPath)shape).curveTo(63.245625, 3.7628596, 64.797745, 4.1537676, 66.30962, 5.087866);
((GeneralPath)shape).lineTo(64.06695, 10.476987);
((GeneralPath)shape).lineTo(61.556484, 5.221757);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(63.93305587768555, 7.566767692565918), new Point2D.Double(66.20711517333984, 7.566767692565918), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_7);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_8 = g.getTransform();
g.transform(new AffineTransform(0.0f, 1.0f, -0.8609864711761475f, 0.0f, 129.39805603027344f, -107.98426055908203f));
// _0_0_8
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_8_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(181.55045, 21.46494);
((GeneralPath)shape).lineTo(117.50547, 73.80696);
((GeneralPath)shape).curveTo(116.11967, 75.416504, 116.3415, 76.82814, 117.40303, 78.061066);
((GeneralPath)shape).lineTo(180.0, 129.07866);
((GeneralPath)shape).curveTo(184.0, 132.6608, 188.0, 132.85188, 188.0, 129.07866);
((GeneralPath)shape).lineTo(188.0, 99.22917);
((GeneralPath)shape).lineTo(224.0, 99.22917);
((GeneralPath)shape).lineTo(224.0, 52.770836);
((GeneralPath)shape).lineTo(188.0, 52.770836);
((GeneralPath)shape).lineTo(188.0, 23.929232);
((GeneralPath)shape).curveTo(188.0, 20.73836, 184.84714, 19.254284, 181.55045, 21.46494);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(212.7331085205078, 76.10952758789062), 56.0f, new Point2D.Double(212.7331085205078, 76.10952758789062), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(159, 193, 242, 255),new Color(88, 126, 181, 255),new Color(12, 42, 88, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.1383929252624512f, 0.0f, -10.51785659790039f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_8_0);
g.setTransform(defaultTransform__0_0_8);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_9 = g.getTransform();
g.transform(new AffineTransform(0.0f, 1.0f, -0.8609864711761475f, 0.0f, 129.59805297851562f, -205.18728637695312f));
// _0_0_9
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_9_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9_0
paint = new LinearGradientPaint(new Point2D.Double(213.6340789794922, 59.980953216552734), new Point2D.Double(165.2705841064453, 60.609806060791016), new float[] {0.0f,1.0f}, new Color[] {new Color(99, 233, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 97.0f, 0.0f));
stroke = new BasicStroke(1.0777098f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(278.55045, 21.46494);
((GeneralPath)shape).lineTo(214.10547, 73.80696);
((GeneralPath)shape).curveTo(212.71967, 75.416504, 212.9415, 76.82814, 214.00304, 78.061066);
((GeneralPath)shape).lineTo(277.0, 129.07866);
((GeneralPath)shape).curveTo(281.0, 132.6608, 285.0, 132.85188, 285.0, 129.07866);
((GeneralPath)shape).lineTo(285.0, 99.22917);
((GeneralPath)shape).lineTo(321.0, 99.22917);
((GeneralPath)shape).lineTo(321.0, 52.770836);
((GeneralPath)shape).lineTo(285.0, 52.770836);
((GeneralPath)shape).lineTo(285.0, 23.929232);
((GeneralPath)shape).curveTo(285.0, 20.73836, 281.84714, 19.254284, 278.55045, 21.46494);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_9_0);
g.setTransform(defaultTransform__0_0_9);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_10 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10
shape = new GeneralPath();
((GeneralPath)shape).moveTo(63.90625, 8.4375);
((GeneralPath)shape).curveTo(63.296486, 8.452437, 62.718266, 8.781241, 62.1875, 9.3125);
((GeneralPath)shape).lineTo(18.25, 71.96875);
((GeneralPath)shape).curveTo(17.740482, 72.63018, 17.347925, 73.29412, 17.0, 73.9375);
((GeneralPath)shape).curveTo(19.796366, 73.982765, 22.603848, 74.0, 25.4375, 74.0);
((GeneralPath)shape).curveTo(55.098255, 74.0, 82.807686, 71.4484, 106.375, 67.09375);
((GeneralPath)shape).lineTo(65.84375, 9.4375);
((GeneralPath)shape).curveTo(65.150856, 8.743956, 64.516014, 8.422563, 63.90625, 8.4375);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(84.48117065429688, 2.0102248191833496), new Point2D.Double(85.48796844482422, 88.88377380371094), new float[] {0.0f,1.0f}, new Color[] {new Color(205, 238, 255, 255),new Color(210, 232, 237, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_10);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_11 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_11
shape = new GeneralPath();
((GeneralPath)shape).moveTo(63.705082, 8.5375);
((GeneralPath)shape).curveTo(63.09532, 8.552438, 62.5171, 8.881241, 61.986332, 9.4125);
((GeneralPath)shape).lineTo(18.048834, 72.06875);
((GeneralPath)shape).curveTo(17.539324, 72.73018, 17.146763, 73.39412, 16.798834, 74.0375);
((GeneralPath)shape).curveTo(16.995613, 74.04069, 17.195704, 74.03459, 17.392584, 74.0375);
((GeneralPath)shape).curveTo(17.591963, 73.72005, 17.803204, 73.38763, 18.048834, 73.06875);
((GeneralPath)shape).lineTo(61.986332, 10.4125);
((GeneralPath)shape).curveTo(62.5171, 9.881241, 63.09532, 9.552438, 63.705082, 9.5375);
((GeneralPath)shape).curveTo(64.31485, 9.522562, 64.94969, 9.843955, 65.642586, 10.5375);
((GeneralPath)shape).lineTo(105.54883, 67.31875);
((GeneralPath)shape).curveTo(105.75636, 67.2808, 105.96695, 67.23198, 106.17383, 67.19375);
((GeneralPath)shape).lineTo(65.642586, 9.5375);
((GeneralPath)shape).curveTo(64.94969, 8.843955, 64.31485, 8.522562, 63.705082, 8.5375);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(84.48117065429688, 2.0102248191833496), new Point2D.Double(86.0235366821289, 66.12226867675781), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -0.20103709399700165f, 0.10000000149011612f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_11);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_12 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_12
shape = new GeneralPath();
((GeneralPath)shape).moveTo(65.61847, 9.483761);
((GeneralPath)shape).lineTo(104.67692, 66.06875);
((GeneralPath)shape).curveTo(81.10961, 70.70585, 53.400173, 73.58828, 23.739424, 73.94375);
((GeneralPath)shape).curveTo(21.420023, 73.97155, 19.125763, 73.97654, 16.833174, 73.975);
((GeneralPath)shape).curveTo(16.822252, 73.99507, 16.812754, 74.01747, 16.801924, 74.0375);
((GeneralPath)shape).curveTo(19.598284, 74.08276, 22.405773, 74.1, 25.239424, 74.1);
((GeneralPath)shape).curveTo(54.900173, 74.1, 82.60961, 71.54841, 106.17692, 67.19375);
((GeneralPath)shape).lineTo(65.645676, 9.5375);
((GeneralPath)shape).lineTo(65.61847, 9.483761);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(103.76151275634766, 85.51464080810547), new Point2D.Double(87.09466552734375, 48.98419189453125), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -0.19768710434436798f, 0.10000000149011612f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_12);
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
        return 5.433778762817383;
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
		return 117.36719512939453;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 126.6407470703125;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private go_up_7() {
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
       go_up_7 base = new go_up_7();
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
       go_up_7 base = new go_up_7();
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
        return go_up_7::new;
    }
}

