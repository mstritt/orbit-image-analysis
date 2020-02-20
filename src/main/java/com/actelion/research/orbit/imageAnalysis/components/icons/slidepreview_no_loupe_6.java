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
public class slidepreview_no_loupe_6 implements ResizableIcon {
    

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
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -0.0f, -0.0f));
// _0
g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));
AffineTransform defaultTransform__0_0 = g.getTransform();
g.transform(new AffineTransform(0.7385876178741455f, 0.0f, 0.0f, 1.1095019578933716f, -6.918469429016113f, -8.622529029846191f));
// _0_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(11.861845, 10.266208);
((GeneralPath)shape).lineTo(11.893095, 102.297455);
((GeneralPath)shape).lineTo(11.861845, 194.29745);
((GeneralPath)shape).lineTo(111.86184, 194.29745);
((GeneralPath)shape).lineTo(111.86184, 117.766205);
((GeneralPath)shape).lineTo(111.86184, 86.766205);
((GeneralPath)shape).lineTo(111.86184, 10.266205);
((GeneralPath)shape).lineTo(11.861847, 10.266205);
((GeneralPath)shape).closePath();
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(2.4134474, 3.073807);
((GeneralPath)shape).lineTo(3.0941164, 46.4382);
((GeneralPath)shape).lineTo(3.0941164, 162.48691);
((GeneralPath)shape).lineTo(3.0941164, 204.94376);
((GeneralPath)shape).lineTo(73.99853, 204.94376);
((GeneralPath)shape).lineTo(73.99853, 113.2193);
((GeneralPath)shape).lineTo(73.99853, 95.70585);
((GeneralPath)shape).lineTo(73.99853, 3.9813843);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new LinearGradientPaint(new Point2D.Double(15.5, 98.5642318725586), new Point2D.Double(112.5, 98.5642318725586), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.7385876178741455f, 0.0f, 0.0f, 1.1095019578933716f, -8.723286628723145f, -4.894649028778076f));
stroke = new BasicStroke(0.9052427f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(2.4134474, 3.073807);
((GeneralPath)shape).lineTo(3.0941164, 46.4382);
((GeneralPath)shape).lineTo(3.0941164, 162.48691);
((GeneralPath)shape).lineTo(3.0941164, 204.94376);
((GeneralPath)shape).lineTo(73.99853, 204.94376);
((GeneralPath)shape).lineTo(73.99853, 113.2193);
((GeneralPath)shape).lineTo(73.99853, 95.70585);
((GeneralPath)shape).lineTo(73.99853, 3.9813843);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(4.22578, 4.789145);
((GeneralPath)shape).lineTo(4.679559, 45.828674);
((GeneralPath)shape).lineTo(4.679559, 162.96472);
((GeneralPath)shape).lineTo(4.679559, 205.81937);
((GeneralPath)shape).lineTo(76.24832, 205.81937);
((GeneralPath)shape).lineTo(76.24832, 113.23549);
((GeneralPath)shape).lineTo(76.24832, 95.55793);
((GeneralPath)shape).lineTo(74.886986, 4.1084976);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(103.09768676757812, 56.26235580444336), 48.9f, new Point2D.Double(103.09768676757812, 56.26235580444336), new float[] {0.0f,1.0f}, new Color[] {new Color(210, 242, 255, 255),new Color(243, 243, 243, 201)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-0.9076445698738098f, 2.406406879425049f, -1.2132166624069214f, -1.0326120853424072f, 231.67376708984375f, -179.3292236328125f));
g.setPaint(paint);
g.fill(shape);
paint = new RadialGradientPaint(new Point2D.Double(18.182392120361328, 147.37173461914062), 48.5f, new Point2D.Double(18.182392120361328, 147.37173461914062), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.3981372117996216f, -0.014106130227446556f, 0.009401139803230762f, 2.102686882019043f, -20.272674560546875f, -107.73248291015625f));
stroke = new BasicStroke(1.6447041f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(4.22578, 4.789145);
((GeneralPath)shape).lineTo(4.679559, 45.828674);
((GeneralPath)shape).lineTo(4.679559, 162.96472);
((GeneralPath)shape).lineTo(4.679559, 205.81937);
((GeneralPath)shape).lineTo(76.24832, 205.81937);
((GeneralPath)shape).lineTo(76.24832, 113.23549);
((GeneralPath)shape).lineTo(76.24832, 95.55793);
((GeneralPath)shape).lineTo(74.886986, 4.1084976);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_3 = g.getTransform();
g.transform(new AffineTransform(0.8200885653495789f, 0.0f, 0.0f, 0.8374932408332825f, -6.837552547454834f, 13.086779594421387f));
// _0_3
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_3_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_3_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(47.032032, 42.984238);
((GeneralPath)shape).curveTo(46.9115, 42.99054, 46.80502, 43.013386, 46.688282, 43.046738);
((GeneralPath)shape).curveTo(46.100063, 43.214798, 43.872826, 44.405834, 43.563282, 44.921738);
((GeneralPath)shape).curveTo(43.072773, 45.739254, 44.14471, 50.572273, 44.407032, 51.359238);
((GeneralPath)shape).curveTo(44.734028, 52.340225, 46.004692, 55.445168, 45.438282, 56.577988);
((GeneralPath)shape).curveTo(45.17401, 57.10653, 40.59938, 56.534706, 39.813282, 56.796738);
((GeneralPath)shape).curveTo(39.566742, 56.878918, 39.422318, 57.304718, 39.188282, 57.421738);
((GeneralPath)shape).curveTo(36.475513, 58.778122, 36.06012, 60.656464, 38.157032, 63.015488);
((GeneralPath)shape).curveTo(38.92808, 63.88292, 39.53362, 64.36906, 40.438282, 65.10924);
((GeneralPath)shape).curveTo(41.237274, 65.76296, 42.07063, 66.42646, 42.938282, 66.98424);
((GeneralPath)shape).curveTo(42.946682, 66.98964, 43.06471, 67.07576, 43.157032, 67.14049);
((GeneralPath)shape).curveTo(42.28938, 67.698265, 41.456024, 68.36176, 40.657032, 69.01549);
((GeneralPath)shape).curveTo(39.75237, 69.75567, 39.14683, 70.241806, 38.375782, 71.10924);
((GeneralPath)shape).curveTo(36.27887, 73.46826, 36.694263, 75.3466, 39.407032, 76.70299);
((GeneralPath)shape).curveTo(39.641068, 76.82001, 39.785492, 77.245804, 40.032032, 77.32799);
((GeneralPath)shape).curveTo(40.81813, 77.59002, 45.39276, 77.018196, 45.657032, 77.54674);
((GeneralPath)shape).curveTo(46.223442, 78.67956, 44.952778, 81.7845, 44.625782, 82.76549);
((GeneralPath)shape).curveTo(44.36346, 83.55245, 43.291523, 88.385475, 43.782032, 89.20299);
((GeneralPath)shape).curveTo(44.091576, 89.718895, 46.318813, 90.90993, 46.907032, 91.07799);
((GeneralPath)shape).curveTo(47.02377, 91.111336, 47.13025, 91.134186, 47.250782, 91.14049);
((GeneralPath)shape).curveTo(47.61238, 91.15925, 48.011555, 91.07799, 48.375782, 91.07799);
((GeneralPath)shape).curveTo(48.92628, 91.07799, 49.687508, 91.21099, 50.219532, 91.07799);
((GeneralPath)shape).curveTo(53.542244, 90.24731, 58.220936, 85.76991, 60.219532, 83.17174);
((GeneralPath)shape).curveTo(60.934242, 82.242615, 63.451977, 78.60538, 62.719532, 77.14049);
((GeneralPath)shape).curveTo(62.50649, 76.7144, 62.354935, 77.09534, 62.094532, 76.92174);
((GeneralPath)shape).curveTo(61.93126, 76.81289, 61.85155, 76.62434, 61.688282, 76.51549);
((GeneralPath)shape).curveTo(61.19082, 76.183846, 60.625782, 76.70833, 60.625782, 75.89049);
((GeneralPath)shape).curveTo(60.625782, 75.75173, 60.52767, 75.551094, 60.625782, 75.45299);
((GeneralPath)shape).curveTo(60.63689, 75.44188, 63.133064, 75.195, 63.344532, 75.26549);
((GeneralPath)shape).curveTo(63.53069, 75.32754, 63.57527, 75.58398, 63.750782, 75.67174);
((GeneralPath)shape).curveTo(63.90936, 75.75103, 64.13993, 75.598045, 64.18828, 75.45299);
((GeneralPath)shape).curveTo(64.41218, 74.781296, 64.30156, 71.902214, 64.18828, 71.10924);
((GeneralPath)shape).curveTo(64.09428, 70.45124, 63.775757, 69.65293, 63.56328, 69.01549);
((GeneralPath)shape).curveTo(63.376507, 68.45517, 63.440308, 67.657486, 63.50078, 66.92174);
((GeneralPath)shape).lineTo(63.25078, 66.92174);
((GeneralPath)shape).curveTo(63.20065, 66.268776, 63.181168, 65.599304, 63.34453, 65.10924);
((GeneralPath)shape).curveTo(63.557007, 64.471794, 63.875526, 63.673485, 63.96953, 63.015488);
((GeneralPath)shape).curveTo(64.08281, 62.22251, 64.19343, 59.34343, 63.96953, 58.671738);
((GeneralPath)shape).curveTo(63.921177, 58.526676, 63.690605, 58.3737, 63.53203, 58.452988);
((GeneralPath)shape).curveTo(63.356518, 58.54075, 63.311935, 58.797188, 63.12578, 58.859238);
((GeneralPath)shape).curveTo(62.91431, 58.92973, 60.418137, 58.682846, 60.40703, 58.671738);
((GeneralPath)shape).curveTo(60.308918, 58.573627, 60.40703, 58.37299, 60.40703, 58.234238);
((GeneralPath)shape).curveTo(60.40703, 57.4164, 60.972065, 57.94088, 61.46953, 57.609238);
((GeneralPath)shape).curveTo(61.632797, 57.50039, 61.712505, 57.311836, 61.87578, 57.202988);
((GeneralPath)shape).curveTo(62.13618, 57.02939, 62.287735, 57.410324, 62.50078, 56.984238);
((GeneralPath)shape).curveTo(63.233223, 55.519352, 60.71549, 51.88211, 60.00078, 50.952988);
((GeneralPath)shape).curveTo(58.002182, 48.354813, 53.323486, 43.877415, 50.00078, 43.046738);
((GeneralPath)shape).curveTo(49.468754, 42.91373, 48.707527, 43.046738, 48.15703, 43.046738);
((GeneralPath)shape).curveTo(47.7928, 43.046738, 47.393627, 42.965477, 47.03203, 42.984238);
((GeneralPath)shape).closePath();
paint = new Color(137, 93, 133, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_3_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_3_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_3_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(47.190765, 48.610233);
((GeneralPath)shape).curveTo(50.827255, 55.345543, 42.249077, 59.38905, 41.946007, 63.784218);
((GeneralPath)shape).curveTo(46.886986, 66.969444, 44.94861, 71.00371, 40.306477, 72.10051);
((GeneralPath)shape).curveTo(41.156918, 78.598434, 51.59971, 71.89883, 48.006218, 80.65884);
((GeneralPath)shape).curveTo(42.208946, 90.73026, 56.789257, 87.16943, 60.114906, 82.24595);
((GeneralPath)shape).curveTo(64.40873, 78.312614, 58.117657, 75.49999, 63.698467, 74.13813);
((GeneralPath)shape).curveTo(61.926117, 66.74273, 62.0934, 59.405373, 57.65365, 52.4432);
((GeneralPath)shape).curveTo(55.63117, 48.13479, 51.024147, 47.654594, 47.36599, 46.784595);
paint = new Color(170, 102, 183, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_3_1);
g.setTransform(defaultTransform__0_3);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_4 = g.getTransform();
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
g.setTransform(defaultTransform__0_4);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_5 = g.getTransform();
g.transform(new AffineTransform(0.8931164741516113f, 0.0f, 0.0f, 1.119674801826477f, 0.0f, 0.0f));
{
    Graphics2D gText = ((Graphics2D)g.create());
            Shape shapeText = null;
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
paint = new Color(0, 0, 0, 255);
gText.setPaint(paint);
shapeText = new GeneralPath();
((GeneralPath)shapeText).moveTo(7.8140244, 139.90076);
((GeneralPath)shapeText).lineTo(12.472496, 139.90076);
((GeneralPath)shapeText).lineTo(12.472496, 140.74297);
((GeneralPath)shapeText).lineTo(8.810859, 140.74297);
((GeneralPath)shapeText).lineTo(8.810859, 142.8485);
((GeneralPath)shapeText).lineTo(12.317871, 142.8485);
((GeneralPath)shapeText).lineTo(12.317871, 143.6907);
((GeneralPath)shapeText).lineTo(8.810859, 143.6907);
((GeneralPath)shapeText).lineTo(8.810859, 146.42789);
((GeneralPath)shapeText).lineTo(12.561322, 146.42789);
((GeneralPath)shapeText).lineTo(12.561322, 147.2701);
((GeneralPath)shapeText).lineTo(7.8140244, 147.2701);
((GeneralPath)shapeText).lineTo(7.8140244, 139.90076);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(14.199682, 139.90076);
((GeneralPath)shapeText).lineTo(15.196517, 139.90076);
((GeneralPath)shapeText).lineTo(15.196517, 146.42789);
((GeneralPath)shapeText).lineTo(18.782486, 146.42789);
((GeneralPath)shapeText).lineTo(18.782486, 147.2701);
((GeneralPath)shapeText).lineTo(14.199682, 147.2701);
((GeneralPath)shapeText).lineTo(14.199682, 139.90076);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(20.827147, 143.6907);
((GeneralPath)shapeText).lineTo(20.827147, 146.44763);
((GeneralPath)shapeText).lineTo(22.42603, 146.44763);
((GeneralPath)shapeText).quadTo(23.22876, 146.44763, 23.616966, 146.10876);
((GeneralPath)shapeText).quadTo(24.005173, 145.76991, 24.005173, 145.06587);
((GeneralPath)shapeText).quadTo(24.005173, 144.35855, 23.616966, 144.02628);
((GeneralPath)shapeText).quadTo(23.22876, 143.6907, 22.42603, 143.6907);
((GeneralPath)shapeText).lineTo(20.827147, 143.6907);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(20.827147, 140.72324);
((GeneralPath)shapeText).lineTo(20.827147, 142.8781);
((GeneralPath)shapeText).lineTo(22.301014, 142.8781);
((GeneralPath)shapeText).quadTo(23.031366, 142.8781, 23.389965, 142.61491);
((GeneralPath)shapeText).quadTo(23.748562, 142.34843, 23.748562, 141.79903);
((GeneralPath)shapeText).quadTo(23.748562, 141.25949, 23.389965, 140.993);
((GeneralPath)shapeText).quadTo(23.031366, 140.72324, 22.301014, 140.72324);
((GeneralPath)shapeText).lineTo(20.827147, 140.72324);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(19.830313, 139.90076);
((GeneralPath)shapeText).lineTo(22.37668, 139.90076);
((GeneralPath)shapeText).quadTo(23.51498, 139.90076, 24.130188, 140.36792);
((GeneralPath)shapeText).quadTo(24.748686, 140.8318, 24.748686, 141.68716);
((GeneralPath)shapeText).quadTo(24.748686, 142.34843, 24.432856, 142.74323);
((GeneralPath)shapeText).quadTo(24.117027, 143.13472, 23.50511, 143.23341);
((GeneralPath)shapeText).quadTo(24.242043, 143.39462, 24.646698, 143.90454);
((GeneralPath)shapeText).quadTo(25.054644, 144.4112, 25.054644, 145.17116);
((GeneralPath)shapeText).quadTo(25.054644, 146.17786, 24.383509, 146.72397);
((GeneralPath)shapeText).quadTo(23.712372, 147.2701, 22.475378, 147.2701);
((GeneralPath)shapeText).lineTo(19.830313, 147.2701);
((GeneralPath)shapeText).lineTo(19.830313, 139.90076);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(28.98441, 140.58835);
((GeneralPath)shapeText).quadTo(28.214577, 140.58835, 27.82637, 141.33844);
((GeneralPath)shapeText).quadTo(27.438164, 142.08525, 27.438164, 143.58543);
((GeneralPath)shapeText).quadTo(27.438164, 145.08232, 27.82637, 145.83241);
((GeneralPath)shapeText).quadTo(28.214577, 146.5825, 28.98441, 146.5825);
((GeneralPath)shapeText).quadTo(29.75753, 146.5825, 30.145737, 145.83241);
((GeneralPath)shapeText).quadTo(30.533943, 145.08232, 30.533943, 143.58543);
((GeneralPath)shapeText).quadTo(30.533943, 142.08525, 30.145737, 141.33844);
((GeneralPath)shapeText).quadTo(29.75753, 140.58835, 28.98441, 140.58835);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(28.98441, 139.79549);
((GeneralPath)shapeText).quadTo(30.221403, 139.79549, 30.876091, 140.76929);
((GeneralPath)shapeText).quadTo(31.530777, 141.7398, 31.530777, 143.58871);
((GeneralPath)shapeText).quadTo(31.530777, 145.43105, 30.876091, 146.40486);
((GeneralPath)shapeText).quadTo(30.221403, 147.37537, 28.98441, 147.37537);
((GeneralPath)shapeText).quadTo(27.744123, 147.37537, 27.089437, 146.40486);
((GeneralPath)shapeText).quadTo(26.438042, 145.43105, 26.438042, 143.58871);
((GeneralPath)shapeText).quadTo(26.438042, 141.7398, 27.089437, 140.76929);
((GeneralPath)shapeText).quadTo(27.744123, 139.79549, 28.98441, 139.79549);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(35.414482, 140.58835);
((GeneralPath)shapeText).quadTo(34.64465, 140.58835, 34.256443, 141.33844);
((GeneralPath)shapeText).quadTo(33.868237, 142.08525, 33.868237, 143.58543);
((GeneralPath)shapeText).quadTo(33.868237, 145.08232, 34.256443, 145.83241);
((GeneralPath)shapeText).quadTo(34.64465, 146.5825, 35.414482, 146.5825);
((GeneralPath)shapeText).quadTo(36.187603, 146.5825, 36.57581, 145.83241);
((GeneralPath)shapeText).quadTo(36.964016, 145.08232, 36.964016, 143.58543);
((GeneralPath)shapeText).quadTo(36.964016, 142.08525, 36.57581, 141.33844);
((GeneralPath)shapeText).quadTo(36.187603, 140.58835, 35.414482, 140.58835);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(35.414482, 139.79549);
((GeneralPath)shapeText).quadTo(36.651478, 139.79549, 37.306164, 140.76929);
((GeneralPath)shapeText).quadTo(37.96085, 141.7398, 37.96085, 143.58871);
((GeneralPath)shapeText).quadTo(37.96085, 145.43105, 37.306164, 146.40486);
((GeneralPath)shapeText).quadTo(36.651478, 147.37537, 35.414482, 147.37537);
((GeneralPath)shapeText).quadTo(34.1742, 147.37537, 33.51951, 146.40486);
((GeneralPath)shapeText).quadTo(32.868114, 145.43105, 32.868114, 143.58871);
((GeneralPath)shapeText).quadTo(32.868114, 141.7398, 33.51951, 140.76929);
((GeneralPath)shapeText).quadTo(34.1742, 139.79549, 35.414482, 139.79549);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(39.74232, 147.07928);
((GeneralPath)shapeText).lineTo(39.74232, 146.17128);
((GeneralPath)shapeText).quadTo(40.117367, 146.34564, 40.50228, 146.44104);
((GeneralPath)shapeText).quadTo(40.8872, 146.53316, 41.255665, 146.53316);
((GeneralPath)shapeText).quadTo(42.24263, 146.53316, 42.762432, 145.8719);
((GeneralPath)shapeText).quadTo(43.285522, 145.20734, 43.3579, 143.86507);
((GeneralPath)shapeText).quadTo(43.07168, 144.28946, 42.630836, 144.51646);
((GeneralPath)shapeText).quadTo(42.193283, 144.74347, 41.66032, 144.74347);
((GeneralPath)shapeText).quadTo(40.55492, 144.74347, 39.910103, 144.0822);
((GeneralPath)shapeText).quadTo(39.268578, 143.42093, 39.268578, 142.27277);
((GeneralPath)shapeText).quadTo(39.268578, 141.15092, 39.939713, 140.4732);
((GeneralPath)shapeText).quadTo(40.610847, 139.79549, 41.72612, 139.79549);
((GeneralPath)shapeText).quadTo(43.002594, 139.79549, 43.677017, 140.76929);
((GeneralPath)shapeText).quadTo(44.351444, 141.7398, 44.351444, 143.58871);
((GeneralPath)shapeText).quadTo(44.351444, 145.3159, 43.522392, 146.34564);
((GeneralPath)shapeText).quadTo(42.696632, 147.37537, 41.301723, 147.37537);
((GeneralPath)shapeText).quadTo(40.926678, 147.37537, 40.54176, 147.2997);
((GeneralPath)shapeText).quadTo(40.156845, 147.22733, 39.74232, 147.07928);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(41.72612, 143.96048);
((GeneralPath)shapeText).quadTo(42.397255, 143.96048, 42.78875, 143.50977);
((GeneralPath)shapeText).quadTo(43.180244, 143.05905, 43.180244, 142.27277);
((GeneralPath)shapeText).quadTo(43.180244, 141.49307, 42.78875, 141.04236);
((GeneralPath)shapeText).quadTo(42.397255, 140.58835, 41.72612, 140.58835);
((GeneralPath)shapeText).quadTo(41.05498, 140.58835, 40.6602, 141.04236);
((GeneralPath)shapeText).quadTo(40.2687, 141.49307, 40.2687, 142.27277);
((GeneralPath)shapeText).quadTo(40.2687, 143.05905, 40.6602, 143.50977);
((GeneralPath)shapeText).quadTo(41.05498, 143.96048, 41.72612, 143.96048);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(48.274628, 140.58835);
((GeneralPath)shapeText).quadTo(47.504795, 140.58835, 47.11659, 141.33844);
((GeneralPath)shapeText).quadTo(46.728382, 142.08525, 46.728382, 143.58543);
((GeneralPath)shapeText).quadTo(46.728382, 145.08232, 47.11659, 145.83241);
((GeneralPath)shapeText).quadTo(47.504795, 146.5825, 48.274628, 146.5825);
((GeneralPath)shapeText).quadTo(49.04775, 146.5825, 49.435955, 145.83241);
((GeneralPath)shapeText).quadTo(49.82416, 145.08232, 49.82416, 143.58543);
((GeneralPath)shapeText).quadTo(49.82416, 142.08525, 49.435955, 141.33844);
((GeneralPath)shapeText).quadTo(49.04775, 140.58835, 48.274628, 140.58835);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(48.274628, 139.79549);
((GeneralPath)shapeText).quadTo(49.511623, 139.79549, 50.16631, 140.76929);
((GeneralPath)shapeText).quadTo(50.820995, 141.7398, 50.820995, 143.58871);
((GeneralPath)shapeText).quadTo(50.820995, 145.43105, 50.16631, 146.40486);
((GeneralPath)shapeText).quadTo(49.511623, 147.37537, 48.274628, 147.37537);
((GeneralPath)shapeText).quadTo(47.034344, 147.37537, 46.379654, 146.40486);
((GeneralPath)shapeText).quadTo(45.72826, 145.43105, 45.72826, 143.58871);
((GeneralPath)shapeText).quadTo(45.72826, 141.7398, 46.379654, 140.76929);
((GeneralPath)shapeText).quadTo(47.034344, 139.79549, 48.274628, 139.79549);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(51.983967, 144.14142);
((GeneralPath)shapeText).lineTo(54.64548, 144.14142);
((GeneralPath)shapeText).lineTo(54.64548, 144.95403);
((GeneralPath)shapeText).lineTo(51.983967, 144.95403);
((GeneralPath)shapeText).lineTo(51.983967, 144.14142);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(58.351532, 140.58835);
((GeneralPath)shapeText).quadTo(57.5817, 140.58835, 57.193493, 141.33844);
((GeneralPath)shapeText).quadTo(56.805286, 142.08525, 56.805286, 143.58543);
((GeneralPath)shapeText).quadTo(56.805286, 145.08232, 57.193493, 145.83241);
((GeneralPath)shapeText).quadTo(57.5817, 146.5825, 58.351532, 146.5825);
((GeneralPath)shapeText).quadTo(59.124653, 146.5825, 59.51286, 145.83241);
((GeneralPath)shapeText).quadTo(59.901066, 145.08232, 59.901066, 143.58543);
((GeneralPath)shapeText).quadTo(59.901066, 142.08525, 59.51286, 141.33844);
((GeneralPath)shapeText).quadTo(59.124653, 140.58835, 58.351532, 140.58835);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(58.351532, 139.79549);
((GeneralPath)shapeText).quadTo(59.588528, 139.79549, 60.243214, 140.76929);
((GeneralPath)shapeText).quadTo(60.8979, 141.7398, 60.8979, 143.58871);
((GeneralPath)shapeText).quadTo(60.8979, 145.43105, 60.243214, 146.40486);
((GeneralPath)shapeText).quadTo(59.588528, 147.37537, 58.351532, 147.37537);
((GeneralPath)shapeText).quadTo(57.111248, 147.37537, 56.45656, 146.40486);
((GeneralPath)shapeText).quadTo(55.805164, 145.43105, 55.805164, 143.58871);
((GeneralPath)shapeText).quadTo(55.805164, 141.7398, 56.45656, 140.76929);
((GeneralPath)shapeText).quadTo(57.111248, 139.79549, 58.351532, 139.79549);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(64.7816, 140.58835);
((GeneralPath)shapeText).quadTo(64.01177, 140.58835, 63.623566, 141.33844);
((GeneralPath)shapeText).quadTo(63.23536, 142.08525, 63.23536, 143.58543);
((GeneralPath)shapeText).quadTo(63.23536, 145.08232, 63.623566, 145.83241);
((GeneralPath)shapeText).quadTo(64.01177, 146.5825, 64.7816, 146.5825);
((GeneralPath)shapeText).quadTo(65.554726, 146.5825, 65.94293, 145.83241);
((GeneralPath)shapeText).quadTo(66.33114, 145.08232, 66.33114, 143.58543);
((GeneralPath)shapeText).quadTo(66.33114, 142.08525, 65.94293, 141.33844);
((GeneralPath)shapeText).quadTo(65.554726, 140.58835, 64.7816, 140.58835);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(64.7816, 139.79549);
((GeneralPath)shapeText).quadTo(66.0186, 139.79549, 66.67329, 140.76929);
((GeneralPath)shapeText).quadTo(67.32797, 141.7398, 67.32797, 143.58871);
((GeneralPath)shapeText).quadTo(67.32797, 145.43105, 66.67329, 146.40486);
((GeneralPath)shapeText).quadTo(66.0186, 147.37537, 64.7816, 147.37537);
((GeneralPath)shapeText).quadTo(63.54132, 147.37537, 62.88663, 146.40486);
((GeneralPath)shapeText).quadTo(62.235237, 145.43105, 62.235237, 143.58871);
((GeneralPath)shapeText).quadTo(62.235237, 141.7398, 62.88663, 140.76929);
((GeneralPath)shapeText).quadTo(63.54132, 139.79549, 64.7816, 139.79549);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(71.21168, 140.58835);
((GeneralPath)shapeText).quadTo(70.44185, 140.58835, 70.05364, 141.33844);
((GeneralPath)shapeText).quadTo(69.665436, 142.08525, 69.665436, 143.58543);
((GeneralPath)shapeText).quadTo(69.665436, 145.08232, 70.05364, 145.83241);
((GeneralPath)shapeText).quadTo(70.44185, 146.5825, 71.21168, 146.5825);
((GeneralPath)shapeText).quadTo(71.9848, 146.5825, 72.37301, 145.83241);
((GeneralPath)shapeText).quadTo(72.761215, 145.08232, 72.761215, 143.58543);
((GeneralPath)shapeText).quadTo(72.761215, 142.08525, 72.37301, 141.33844);
((GeneralPath)shapeText).quadTo(71.9848, 140.58835, 71.21168, 140.58835);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(71.21168, 139.79549);
((GeneralPath)shapeText).quadTo(72.44868, 139.79549, 73.10336, 140.76929);
((GeneralPath)shapeText).quadTo(73.75805, 141.7398, 73.75805, 143.58871);
((GeneralPath)shapeText).quadTo(73.75805, 145.43105, 73.10336, 146.40486);
((GeneralPath)shapeText).quadTo(72.44868, 147.37537, 71.21168, 147.37537);
((GeneralPath)shapeText).quadTo(69.9714, 147.37537, 69.31671, 146.40486);
((GeneralPath)shapeText).quadTo(68.66531, 145.43105, 68.66531, 143.58871);
((GeneralPath)shapeText).quadTo(68.66531, 141.7398, 69.31671, 140.76929);
((GeneralPath)shapeText).quadTo(69.9714, 139.79549, 71.21168, 139.79549);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(75.53951, 147.07928);
((GeneralPath)shapeText).lineTo(75.53951, 146.17128);
((GeneralPath)shapeText).quadTo(75.91456, 146.34564, 76.29948, 146.44104);
((GeneralPath)shapeText).quadTo(76.684395, 146.53316, 77.052864, 146.53316);
((GeneralPath)shapeText).quadTo(78.039825, 146.53316, 78.55962, 145.8719);
((GeneralPath)shapeText).quadTo(79.08272, 145.20734, 79.1551, 143.86507);
((GeneralPath)shapeText).quadTo(78.86887, 144.28946, 78.42803, 144.51646);
((GeneralPath)shapeText).quadTo(77.99048, 144.74347, 77.45752, 144.74347);
((GeneralPath)shapeText).quadTo(76.35212, 144.74347, 75.7073, 144.0822);
((GeneralPath)shapeText).quadTo(75.06577, 143.42093, 75.06577, 142.27277);
((GeneralPath)shapeText).quadTo(75.06577, 141.15092, 75.73691, 140.4732);
((GeneralPath)shapeText).quadTo(76.40804, 139.79549, 77.523315, 139.79549);
((GeneralPath)shapeText).quadTo(78.79979, 139.79549, 79.47421, 140.76929);
((GeneralPath)shapeText).quadTo(80.148636, 141.7398, 80.148636, 143.58871);
((GeneralPath)shapeText).quadTo(80.148636, 145.3159, 79.31959, 146.34564);
((GeneralPath)shapeText).quadTo(78.49383, 147.37537, 77.09892, 147.37537);
((GeneralPath)shapeText).quadTo(76.72387, 147.37537, 76.33896, 147.2997);
((GeneralPath)shapeText).quadTo(75.95404, 147.22733, 75.53951, 147.07928);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(77.523315, 143.96048);
((GeneralPath)shapeText).quadTo(78.19445, 143.96048, 78.585945, 143.50977);
((GeneralPath)shapeText).quadTo(78.97744, 143.05905, 78.97744, 142.27277);
((GeneralPath)shapeText).quadTo(78.97744, 141.49307, 78.585945, 141.04236);
((GeneralPath)shapeText).quadTo(78.19445, 140.58835, 77.523315, 140.58835);
((GeneralPath)shapeText).quadTo(76.85218, 140.58835, 76.45739, 141.04236);
((GeneralPath)shapeText).quadTo(76.065895, 141.49307, 76.065895, 142.27277);
((GeneralPath)shapeText).quadTo(76.065895, 143.05905, 76.45739, 143.50977);
((GeneralPath)shapeText).quadTo(76.85218, 143.96048, 77.523315, 143.96048);
((GeneralPath)shapeText).closePath();
gText.fill(shapeText);
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
    gText.dispose();
}
g.setTransform(defaultTransform__0_5);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_6 = g.getTransform();
g.transform(new AffineTransform(0.5473774075508118f, 0.0f, 0.0f, 0.7811082601547241f, 9.056873321533203f, 67.79796600341797f));
// _0_6
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_6_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_6_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(47.032032, 42.984238);
((GeneralPath)shape).curveTo(46.9115, 42.99054, 46.80502, 43.013386, 46.688282, 43.046738);
((GeneralPath)shape).curveTo(46.100063, 43.214798, 43.872826, 44.405834, 43.563282, 44.921738);
((GeneralPath)shape).curveTo(43.072773, 45.739254, 44.14471, 50.572273, 44.407032, 51.359238);
((GeneralPath)shape).curveTo(44.734028, 52.340225, 46.004692, 55.445168, 45.438282, 56.577988);
((GeneralPath)shape).curveTo(45.17401, 57.10653, 40.59938, 56.534706, 39.813282, 56.796738);
((GeneralPath)shape).curveTo(39.566742, 56.878918, 39.422318, 57.304718, 39.188282, 57.421738);
((GeneralPath)shape).curveTo(36.475513, 58.778122, 36.06012, 60.656464, 38.157032, 63.015488);
((GeneralPath)shape).curveTo(38.92808, 63.88292, 39.53362, 64.36906, 40.438282, 65.10924);
((GeneralPath)shape).curveTo(41.237274, 65.76296, 42.07063, 66.42646, 42.938282, 66.98424);
((GeneralPath)shape).curveTo(42.946682, 66.98964, 43.06471, 67.07576, 43.157032, 67.14049);
((GeneralPath)shape).curveTo(42.28938, 67.698265, 41.456024, 68.36176, 40.657032, 69.01549);
((GeneralPath)shape).curveTo(39.75237, 69.75567, 39.14683, 70.241806, 38.375782, 71.10924);
((GeneralPath)shape).curveTo(36.27887, 73.46826, 36.694263, 75.3466, 39.407032, 76.70299);
((GeneralPath)shape).curveTo(39.641068, 76.82001, 39.785492, 77.245804, 40.032032, 77.32799);
((GeneralPath)shape).curveTo(40.81813, 77.59002, 45.39276, 77.018196, 45.657032, 77.54674);
((GeneralPath)shape).curveTo(46.223442, 78.67956, 44.952778, 81.7845, 44.625782, 82.76549);
((GeneralPath)shape).curveTo(44.36346, 83.55245, 43.291523, 88.385475, 43.782032, 89.20299);
((GeneralPath)shape).curveTo(44.091576, 89.718895, 46.318813, 90.90993, 46.907032, 91.07799);
((GeneralPath)shape).curveTo(47.02377, 91.111336, 47.13025, 91.134186, 47.250782, 91.14049);
((GeneralPath)shape).curveTo(47.61238, 91.15925, 48.011555, 91.07799, 48.375782, 91.07799);
((GeneralPath)shape).curveTo(48.92628, 91.07799, 49.687508, 91.21099, 50.219532, 91.07799);
((GeneralPath)shape).curveTo(53.542244, 90.24731, 58.220936, 85.76991, 60.219532, 83.17174);
((GeneralPath)shape).curveTo(60.934242, 82.242615, 63.451977, 78.60538, 62.719532, 77.14049);
((GeneralPath)shape).curveTo(62.50649, 76.7144, 62.354935, 77.09534, 62.094532, 76.92174);
((GeneralPath)shape).curveTo(61.93126, 76.81289, 61.85155, 76.62434, 61.688282, 76.51549);
((GeneralPath)shape).curveTo(61.19082, 76.183846, 60.625782, 76.70833, 60.625782, 75.89049);
((GeneralPath)shape).curveTo(60.625782, 75.75173, 60.52767, 75.551094, 60.625782, 75.45299);
((GeneralPath)shape).curveTo(60.63689, 75.44188, 63.133064, 75.195, 63.344532, 75.26549);
((GeneralPath)shape).curveTo(63.53069, 75.32754, 63.57527, 75.58398, 63.750782, 75.67174);
((GeneralPath)shape).curveTo(63.90936, 75.75103, 64.13993, 75.598045, 64.18828, 75.45299);
((GeneralPath)shape).curveTo(64.41218, 74.781296, 64.30156, 71.902214, 64.18828, 71.10924);
((GeneralPath)shape).curveTo(64.09428, 70.45124, 63.775757, 69.65293, 63.56328, 69.01549);
((GeneralPath)shape).curveTo(63.376507, 68.45517, 63.440308, 67.657486, 63.50078, 66.92174);
((GeneralPath)shape).lineTo(63.25078, 66.92174);
((GeneralPath)shape).curveTo(63.20065, 66.268776, 63.181168, 65.599304, 63.34453, 65.10924);
((GeneralPath)shape).curveTo(63.557007, 64.471794, 63.875526, 63.673485, 63.96953, 63.015488);
((GeneralPath)shape).curveTo(64.08281, 62.22251, 64.19343, 59.34343, 63.96953, 58.671738);
((GeneralPath)shape).curveTo(63.921177, 58.526676, 63.690605, 58.3737, 63.53203, 58.452988);
((GeneralPath)shape).curveTo(63.356518, 58.54075, 63.311935, 58.797188, 63.12578, 58.859238);
((GeneralPath)shape).curveTo(62.91431, 58.92973, 60.418137, 58.682846, 60.40703, 58.671738);
((GeneralPath)shape).curveTo(60.308918, 58.573627, 60.40703, 58.37299, 60.40703, 58.234238);
((GeneralPath)shape).curveTo(60.40703, 57.4164, 60.972065, 57.94088, 61.46953, 57.609238);
((GeneralPath)shape).curveTo(61.632797, 57.50039, 61.712505, 57.311836, 61.87578, 57.202988);
((GeneralPath)shape).curveTo(62.13618, 57.02939, 62.287735, 57.410324, 62.50078, 56.984238);
((GeneralPath)shape).curveTo(63.233223, 55.519352, 60.71549, 51.88211, 60.00078, 50.952988);
((GeneralPath)shape).curveTo(58.002182, 48.354813, 53.323486, 43.877415, 50.00078, 43.046738);
((GeneralPath)shape).curveTo(49.468754, 42.91373, 48.707527, 43.046738, 48.15703, 43.046738);
((GeneralPath)shape).curveTo(47.7928, 43.046738, 47.393627, 42.965477, 47.03203, 42.984238);
((GeneralPath)shape).closePath();
paint = new Color(137, 93, 133, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_6_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_6_1 = g.getTransform();
g.transform(new AffineTransform(1.8268930912017822f, 0.0f, 0.0f, 1.280232310295105f, -16.54593849182129f, -86.79715728759766f));
// _0_6_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(34.96875, 104.34375);
((GeneralPath)shape).lineTo(34.875, 105.78125);
((GeneralPath)shape).curveTo(36.865532, 111.04226, 32.197144, 114.1919, 32.03125, 117.625);
((GeneralPath)shape).curveTo(34.735832, 120.11301, 33.665997, 123.26828, 31.125, 124.125);
((GeneralPath)shape).curveTo(31.590511, 129.20058, 37.310745, 123.96998, 35.34375, 130.8125);
((GeneralPath)shape).curveTo(32.170456, 138.67938, 40.148365, 135.87703, 41.96875, 132.03125);
((GeneralPath)shape).curveTo(44.31909, 128.9589, 40.88269, 126.78251, 43.9375, 125.71875);
((GeneralPath)shape).curveTo(42.967358, 119.94214, 43.055218, 114.18821, 40.625, 108.75);
((GeneralPath)shape).curveTo(39.51794, 105.38466, 36.971146, 105.02331, 34.96875, 104.34375);
((GeneralPath)shape).closePath();
((GeneralPath)shape).moveTo(37.65625, 116.6875);
((GeneralPath)shape).curveTo(39.509445, 117.05814, 39.9375, 116.57086, 39.9375, 118.5);
((GeneralPath)shape).curveTo(39.9375, 123.37108, 31.292852, 120.93242, 37.65625, 116.6875);
((GeneralPath)shape).closePath();
paint = new Color(170, 102, 183, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_6_1);
g.setTransform(defaultTransform__0_6);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_7 = g.getTransform();
g.transform(new AffineTransform(0.6027528047561646f, 0.0f, 0.0f, 0.5494840741157532f, 4.249017238616943f, -9.982442855834961f));
// _0_7
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_7_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_7_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(47.032032, 42.984238);
((GeneralPath)shape).curveTo(46.9115, 42.99054, 46.80502, 43.013386, 46.688282, 43.046738);
((GeneralPath)shape).curveTo(46.100063, 43.214798, 43.872826, 44.405834, 43.563282, 44.921738);
((GeneralPath)shape).curveTo(43.072773, 45.739254, 44.14471, 50.572273, 44.407032, 51.359238);
((GeneralPath)shape).curveTo(44.734028, 52.340225, 46.004692, 55.445168, 45.438282, 56.577988);
((GeneralPath)shape).curveTo(45.17401, 57.10653, 40.59938, 56.534706, 39.813282, 56.796738);
((GeneralPath)shape).curveTo(39.566742, 56.878918, 39.422318, 57.304718, 39.188282, 57.421738);
((GeneralPath)shape).curveTo(36.475513, 58.778122, 36.06012, 60.656464, 38.157032, 63.015488);
((GeneralPath)shape).curveTo(38.92808, 63.88292, 39.53362, 64.36906, 40.438282, 65.10924);
((GeneralPath)shape).curveTo(41.237274, 65.76296, 42.07063, 66.42646, 42.938282, 66.98424);
((GeneralPath)shape).curveTo(42.946682, 66.98964, 43.06471, 67.07576, 43.157032, 67.14049);
((GeneralPath)shape).curveTo(42.28938, 67.698265, 41.456024, 68.36176, 40.657032, 69.01549);
((GeneralPath)shape).curveTo(39.75237, 69.75567, 39.14683, 70.241806, 38.375782, 71.10924);
((GeneralPath)shape).curveTo(36.27887, 73.46826, 36.694263, 75.3466, 39.407032, 76.70299);
((GeneralPath)shape).curveTo(39.641068, 76.82001, 39.785492, 77.245804, 40.032032, 77.32799);
((GeneralPath)shape).curveTo(40.81813, 77.59002, 45.39276, 77.018196, 45.657032, 77.54674);
((GeneralPath)shape).curveTo(46.223442, 78.67956, 44.952778, 81.7845, 44.625782, 82.76549);
((GeneralPath)shape).curveTo(44.36346, 83.55245, 43.291523, 88.385475, 43.782032, 89.20299);
((GeneralPath)shape).curveTo(44.091576, 89.718895, 46.318813, 90.90993, 46.907032, 91.07799);
((GeneralPath)shape).curveTo(47.02377, 91.111336, 47.13025, 91.134186, 47.250782, 91.14049);
((GeneralPath)shape).curveTo(47.61238, 91.15925, 48.011555, 91.07799, 48.375782, 91.07799);
((GeneralPath)shape).curveTo(48.92628, 91.07799, 49.687508, 91.21099, 50.219532, 91.07799);
((GeneralPath)shape).curveTo(53.542244, 90.24731, 58.220936, 85.76991, 60.219532, 83.17174);
((GeneralPath)shape).curveTo(60.934242, 82.242615, 63.451977, 78.60538, 62.719532, 77.14049);
((GeneralPath)shape).curveTo(62.50649, 76.7144, 62.354935, 77.09534, 62.094532, 76.92174);
((GeneralPath)shape).curveTo(61.93126, 76.81289, 61.85155, 76.62434, 61.688282, 76.51549);
((GeneralPath)shape).curveTo(61.19082, 76.183846, 60.625782, 76.70833, 60.625782, 75.89049);
((GeneralPath)shape).curveTo(60.625782, 75.75173, 60.52767, 75.551094, 60.625782, 75.45299);
((GeneralPath)shape).curveTo(60.63689, 75.44188, 63.133064, 75.195, 63.344532, 75.26549);
((GeneralPath)shape).curveTo(63.53069, 75.32754, 63.57527, 75.58398, 63.750782, 75.67174);
((GeneralPath)shape).curveTo(63.90936, 75.75103, 64.13993, 75.598045, 64.18828, 75.45299);
((GeneralPath)shape).curveTo(64.41218, 74.781296, 64.30156, 71.902214, 64.18828, 71.10924);
((GeneralPath)shape).curveTo(64.09428, 70.45124, 63.775757, 69.65293, 63.56328, 69.01549);
((GeneralPath)shape).curveTo(63.376507, 68.45517, 63.440308, 67.657486, 63.50078, 66.92174);
((GeneralPath)shape).lineTo(63.25078, 66.92174);
((GeneralPath)shape).curveTo(63.20065, 66.268776, 63.181168, 65.599304, 63.34453, 65.10924);
((GeneralPath)shape).curveTo(63.557007, 64.471794, 63.875526, 63.673485, 63.96953, 63.015488);
((GeneralPath)shape).curveTo(64.08281, 62.22251, 64.19343, 59.34343, 63.96953, 58.671738);
((GeneralPath)shape).curveTo(63.921177, 58.526676, 63.690605, 58.3737, 63.53203, 58.452988);
((GeneralPath)shape).curveTo(63.356518, 58.54075, 63.311935, 58.797188, 63.12578, 58.859238);
((GeneralPath)shape).curveTo(62.91431, 58.92973, 60.418137, 58.682846, 60.40703, 58.671738);
((GeneralPath)shape).curveTo(60.308918, 58.573627, 60.40703, 58.37299, 60.40703, 58.234238);
((GeneralPath)shape).curveTo(60.40703, 57.4164, 60.972065, 57.94088, 61.46953, 57.609238);
((GeneralPath)shape).curveTo(61.632797, 57.50039, 61.712505, 57.311836, 61.87578, 57.202988);
((GeneralPath)shape).curveTo(62.13618, 57.02939, 62.287735, 57.410324, 62.50078, 56.984238);
((GeneralPath)shape).curveTo(63.233223, 55.519352, 60.71549, 51.88211, 60.00078, 50.952988);
((GeneralPath)shape).curveTo(58.002182, 48.354813, 53.323486, 43.877415, 50.00078, 43.046738);
((GeneralPath)shape).curveTo(49.468754, 42.91373, 48.707527, 43.046738, 48.15703, 43.046738);
((GeneralPath)shape).curveTo(47.7928, 43.046738, 47.393627, 42.965477, 47.03203, 42.984238);
((GeneralPath)shape).closePath();
paint = new Color(137, 93, 133, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_7_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_7_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_7_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(47.190765, 48.610233);
((GeneralPath)shape).curveTo(50.827255, 55.345543, 42.249077, 59.38905, 41.946007, 63.784218);
((GeneralPath)shape).curveTo(46.886986, 66.969444, 44.94861, 71.00371, 40.306477, 72.10051);
((GeneralPath)shape).curveTo(41.156918, 78.598434, 51.59971, 71.89883, 48.006218, 80.65884);
((GeneralPath)shape).curveTo(42.208946, 90.73026, 56.789257, 87.16943, 60.114906, 82.24595);
((GeneralPath)shape).curveTo(64.40873, 78.312614, 58.117657, 75.49999, 63.698467, 74.13813);
((GeneralPath)shape).curveTo(61.926117, 66.74273, 62.0934, 59.405373, 57.65365, 52.4432);
((GeneralPath)shape).curveTo(55.63117, 48.13479, 51.024147, 47.654594, 47.36599, 46.784595);
paint = new Color(170, 102, 183, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_7_1);
g.setTransform(defaultTransform__0_7);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_8 = g.getTransform();
g.transform(new AffineTransform(0.6027528047561646f, 0.0f, 0.0f, 0.5494840741157532f, 16.2490177154541f, 45.982444763183594f));
// _0_8
g.setComposite(AlphaComposite.getInstance(3, 0.8f * origAlpha));
AffineTransform defaultTransform__0_8_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_8_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(5.1377196, 20.205397);
((GeneralPath)shape).lineTo(73.73864, 84.94898);
((GeneralPath)shape).lineTo(73.73864, 108.071686);
((GeneralPath)shape).lineTo(5.1377196, 37.16205);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(0.9837678f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(5.1377196, 20.205397);
((GeneralPath)shape).lineTo(73.73864, 84.94898);
((GeneralPath)shape).lineTo(73.73864, 108.071686);
((GeneralPath)shape).lineTo(5.1377196, 37.16205);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_8_0);
g.setComposite(AlphaComposite.getInstance(3, 0.8f * origAlpha));
AffineTransform defaultTransform__0_8_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_8_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(4.2407675, 6.333107);
((GeneralPath)shape).lineTo(73.739456, 72.62499);
((GeneralPath)shape).lineTo(73.739456, 61.05921);
((GeneralPath)shape).lineTo(17.190214, 4.791877);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(0.9837678f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(4.2407675, 6.333107);
((GeneralPath)shape).lineTo(73.739456, 72.62499);
((GeneralPath)shape).lineTo(73.739456, 61.05921);
((GeneralPath)shape).lineTo(17.190214, 4.791877);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_8_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_8_2 = g.getTransform();
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
g.setTransform(defaultTransform__0_8_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_8_3 = g.getTransform();
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
g.setTransform(defaultTransform__0_8_3);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_8_4 = g.getTransform();
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
g.setTransform(defaultTransform__0_8_4);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_8_5 = g.getTransform();
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
g.setTransform(defaultTransform__0_8_5);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_8_6 = g.getTransform();
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
g.setTransform(defaultTransform__0_8_6);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_8_7 = g.getTransform();
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
g.setTransform(defaultTransform__0_8_7);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_8_8 = g.getTransform();
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
g.setTransform(defaultTransform__0_8_8);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_8_9 = g.getTransform();
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
g.setTransform(defaultTransform__0_8_9);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_8_10 = g.getTransform();
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
g.setTransform(defaultTransform__0_8_10);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_8_11 = g.getTransform();
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
g.setTransform(defaultTransform__0_8_11);
g.setTransform(defaultTransform__0_8);
g.setTransform(defaultTransform__0);
g.setTransform(defaultTransform_);

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

