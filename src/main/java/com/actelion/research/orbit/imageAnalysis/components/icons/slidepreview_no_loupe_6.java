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
((GeneralPath)shapeText).moveTo(10.964086, 147.2701);
((GeneralPath)shapeText).lineTo(10.964086, 139.90076);
((GeneralPath)shapeText).lineTo(16.017342, 139.90076);
((GeneralPath)shapeText).lineTo(16.017342, 140.74297);
((GeneralPath)shapeText).lineTo(11.806294, 140.74297);
((GeneralPath)shapeText).lineTo(11.806294, 143.05905);
((GeneralPath)shapeText).lineTo(15.806789, 143.05905);
((GeneralPath)shapeText).lineTo(15.806789, 143.90126);
((GeneralPath)shapeText).lineTo(11.806294, 143.90126);
((GeneralPath)shapeText).lineTo(11.806294, 146.42789);
((GeneralPath)shapeText).lineTo(16.227894, 146.42789);
((GeneralPath)shapeText).lineTo(16.227894, 147.2701);
((GeneralPath)shapeText).lineTo(10.964086, 147.2701);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(17.705051, 147.2701);
((GeneralPath)shapeText).lineTo(17.705051, 139.90076);
((GeneralPath)shapeText).lineTo(18.547262, 139.90076);
((GeneralPath)shapeText).lineTo(18.547262, 146.42789);
((GeneralPath)shapeText).lineTo(22.126652, 146.42789);
((GeneralPath)shapeText).lineTo(22.126652, 147.2701);
((GeneralPath)shapeText).lineTo(17.705051, 147.2701);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(23.325811, 147.2701);
((GeneralPath)shapeText).lineTo(23.325811, 139.90076);
((GeneralPath)shapeText).lineTo(26.118921, 139.90076);
((GeneralPath)shapeText).quadTo(26.974289, 139.90076, 27.48751, 140.13434);
((GeneralPath)shapeText).quadTo(28.004023, 140.36464, 28.296822, 140.84825);
((GeneralPath)shapeText).quadTo(28.58962, 141.33186, 28.58962, 141.85825);
((GeneralPath)shapeText).quadTo(28.58962, 142.34843, 28.35933, 142.7827);
((GeneralPath)shapeText).quadTo(28.132328, 143.21367, 27.671745, 143.48015);
((GeneralPath)shapeText).quadTo(28.214575, 143.67096, 28.507374, 144.12827);
((GeneralPath)shapeText).quadTo(28.800175, 144.58226, 28.800175, 145.20406);
((GeneralPath)shapeText).quadTo(28.800175, 145.70412, 28.583042, 146.13509);
((GeneralPath)shapeText).quadTo(28.3692, 146.56606, 28.053371, 146.79964);
((GeneralPath)shapeText).quadTo(27.737543, 147.03322, 27.26051, 147.15166);
((GeneralPath)shapeText).quadTo(26.783476, 147.2701, 26.089312, 147.2701);
((GeneralPath)shapeText).lineTo(23.325811, 147.2701);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(24.168022, 143.05905);
((GeneralPath)shapeText).lineTo(25.91166, 143.05905);
((GeneralPath)shapeText).quadTo(26.622272, 143.05905, 26.928232, 142.97021);
((GeneralPath)shapeText).quadTo(27.336176, 142.85507, 27.54015, 142.5886);
((GeneralPath)shapeText).quadTo(27.747412, 142.32211, 27.747412, 141.92075);
((GeneralPath)shapeText).quadTo(27.747412, 141.53912, 27.553308, 141.24962);
((GeneralPath)shapeText).quadTo(27.362495, 140.95682, 27.003899, 140.85153);
((GeneralPath)shapeText).quadTo(26.648592, 140.74297, 25.780064, 140.74297);
((GeneralPath)shapeText).lineTo(24.168022, 140.74297);
((GeneralPath)shapeText).lineTo(24.168022, 143.05905);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(24.168022, 146.42789);
((GeneralPath)shapeText).lineTo(26.11234, 146.42789);
((GeneralPath)shapeText).quadTo(26.612404, 146.42789, 26.813086, 146.3917);
((GeneralPath)shapeText).quadTo(27.171682, 146.33247, 27.408554, 146.1943);
((GeneralPath)shapeText).quadTo(27.648716, 146.05284, 27.803339, 145.78636);
((GeneralPath)shapeText).quadTo(27.957964, 145.51659, 27.957964, 145.16457);
((GeneralPath)shapeText).quadTo(27.957964, 144.75334, 27.79018, 144.45067);
((GeneralPath)shapeText).quadTo(27.622396, 144.148, 27.21116, 144.02628);
((GeneralPath)shapeText).quadTo(26.803217, 143.90126, 26.033384, 143.90126);
((GeneralPath)shapeText).lineTo(24.168022, 143.90126);
((GeneralPath)shapeText).lineTo(24.168022, 146.42789);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(29.645672, 143.58871);
((GeneralPath)shapeText).quadTo(29.645672, 142.30896, 29.915442, 141.47661);
((GeneralPath)shapeText).quadTo(30.188503, 140.64099, 30.721462, 140.27252);
((GeneralPath)shapeText).quadTo(31.257713, 139.90076, 32.067024, 139.90076);
((GeneralPath)shapeText).quadTo(32.665783, 139.90076, 33.169136, 140.13434);
((GeneralPath)shapeText).quadTo(33.672485, 140.36792, 33.912647, 140.80878);
((GeneralPath)shapeText).quadTo(34.15281, 141.24962, 34.32059, 141.88457);
((GeneralPath)shapeText).quadTo(34.488377, 142.51622, 34.488377, 143.58871);
((GeneralPath)shapeText).quadTo(34.488377, 144.85861, 34.218605, 145.69095);
((GeneralPath)shapeText).quadTo(33.952126, 146.5233, 33.415874, 146.89835);
((GeneralPath)shapeText).quadTo(32.882915, 147.2701, 32.067024, 147.2701);
((GeneralPath)shapeText).quadTo(30.994524, 147.2701, 30.379316, 146.62857);
((GeneralPath)shapeText).quadTo(29.645672, 145.62187, 29.645672, 143.58871);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(30.48788, 143.58543);
((GeneralPath)shapeText).quadTo(30.48788, 145.40144, 30.941885, 145.91466);
((GeneralPath)shapeText).quadTo(31.39918, 146.42789, 32.067024, 146.42789);
((GeneralPath)shapeText).quadTo(32.73487, 146.42789, 33.188873, 145.91138);
((GeneralPath)shapeText).quadTo(33.646168, 145.39487, 33.646168, 143.58543);
((GeneralPath)shapeText).quadTo(33.646168, 141.8714, 33.215195, 141.30884);
((GeneralPath)shapeText).quadTo(32.78751, 140.74297, 32.057156, 140.74297);
((GeneralPath)shapeText).quadTo(31.389309, 140.74297, 30.935305, 141.23975);
((GeneralPath)shapeText).quadTo(30.48788, 141.8747, 30.48788, 143.58543);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(35.266434, 143.58871);
((GeneralPath)shapeText).quadTo(35.266434, 142.30896, 35.536205, 141.47661);
((GeneralPath)shapeText).quadTo(35.809265, 140.64099, 36.342224, 140.27252);
((GeneralPath)shapeText).quadTo(36.878475, 139.90076, 37.687786, 139.90076);
((GeneralPath)shapeText).quadTo(38.286545, 139.90076, 38.789898, 140.13434);
((GeneralPath)shapeText).quadTo(39.293247, 140.36792, 39.53341, 140.80878);
((GeneralPath)shapeText).quadTo(39.77357, 141.24962, 39.941353, 141.88457);
((GeneralPath)shapeText).quadTo(40.10914, 142.51622, 40.10914, 143.58871);
((GeneralPath)shapeText).quadTo(40.10914, 144.85861, 39.839367, 145.69095);
((GeneralPath)shapeText).quadTo(39.572887, 146.5233, 39.036636, 146.89835);
((GeneralPath)shapeText).quadTo(38.503677, 147.2701, 37.687786, 147.2701);
((GeneralPath)shapeText).quadTo(36.615284, 147.2701, 36.000076, 146.62857);
((GeneralPath)shapeText).quadTo(35.266434, 145.62187, 35.266434, 143.58871);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(36.108643, 143.58543);
((GeneralPath)shapeText).quadTo(36.108643, 145.40144, 36.56265, 145.91466);
((GeneralPath)shapeText).quadTo(37.01994, 146.42789, 37.687786, 146.42789);
((GeneralPath)shapeText).quadTo(38.355633, 146.42789, 38.809635, 145.91138);
((GeneralPath)shapeText).quadTo(39.26693, 145.39487, 39.26693, 143.58543);
((GeneralPath)shapeText).quadTo(39.26693, 141.8714, 38.835957, 141.30884);
((GeneralPath)shapeText).quadTo(38.40827, 140.74297, 37.677917, 140.74297);
((GeneralPath)shapeText).quadTo(37.01007, 140.74297, 36.55607, 141.23975);
((GeneralPath)shapeText).quadTo(36.108643, 141.8747, 36.108643, 143.58543);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(41.097748, 145.37512);
((GeneralPath)shapeText).lineTo(41.939957, 145.37512);
((GeneralPath)shapeText).quadTo(42.051815, 145.92783, 42.364353, 146.17786);
((GeneralPath)shapeText).quadTo(42.67689, 146.42789, 43.167084, 146.42789);
((GeneralPath)shapeText).quadTo(43.5849, 146.42789, 43.953365, 146.2568);
((GeneralPath)shapeText).quadTo(44.32183, 146.08574, 44.469875, 145.79951);
((GeneralPath)shapeText).quadTo(44.621212, 145.5133, 44.756096, 145.01982);
((GeneralPath)shapeText).quadTo(44.89098, 144.52304, 44.89098, 143.97035);
((GeneralPath)shapeText).quadTo(44.89098, 143.91113, 44.88769, 143.7927);
((GeneralPath)shapeText).quadTo(44.61134, 144.21709, 44.134308, 144.48027);
((GeneralPath)shapeText).quadTo(43.657276, 144.74347, 43.101284, 144.74347);
((GeneralPath)shapeText).quadTo(42.17354, 144.74347, 41.52872, 144.08878);
((GeneralPath)shapeText).quadTo(40.887196, 143.4308, 40.887196, 142.3583);
((GeneralPath)shapeText).quadTo(40.887196, 141.2529, 41.548462, 140.57848);
((GeneralPath)shapeText).quadTo(42.20973, 139.90076, 43.203274, 139.90076);
((GeneralPath)shapeText).quadTo(43.920467, 139.90076, 44.515934, 140.2791);
((GeneralPath)shapeText).quadTo(45.111404, 140.65744, 45.42065, 141.36147);
((GeneralPath)shapeText).quadTo(45.7299, 142.06221, 45.7299, 143.39133);
((GeneralPath)shapeText).quadTo(45.7299, 144.77307, 45.42723, 145.59555);
((GeneralPath)shapeText).quadTo(45.127853, 146.41473, 44.532383, 146.8424);
((GeneralPath)shapeText).quadTo(43.936916, 147.2701, 43.134186, 147.2701);
((GeneralPath)shapeText).quadTo(42.285397, 147.2701, 41.745853, 146.77333);
((GeneralPath)shapeText).quadTo(41.206314, 146.27655, 41.097748, 145.37512);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(44.88769, 142.33856);
((GeneralPath)shapeText).quadTo(44.88769, 141.60492, 44.489616, 141.17395);
((GeneralPath)shapeText).quadTo(44.09154, 140.74297, 43.354607, 140.74297);
((GeneralPath)shapeText).quadTo(42.594643, 140.74297, 42.16038, 141.20685);
((GeneralPath)shapeText).quadTo(41.729404, 141.67072, 41.729404, 142.41093);
((GeneralPath)shapeText).quadTo(41.729404, 143.0722, 42.137352, 143.48674);
((GeneralPath)shapeText).quadTo(42.545296, 143.90126, 43.32829, 143.90126);
((GeneralPath)shapeText).quadTo(44.009293, 143.90126, 44.446846, 143.48674);
((GeneralPath)shapeText).quadTo(44.88769, 143.0722, 44.88769, 142.33856);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(46.507957, 143.58871);
((GeneralPath)shapeText).quadTo(46.507957, 142.30896, 46.77773, 141.47661);
((GeneralPath)shapeText).quadTo(47.05079, 140.64099, 47.583748, 140.27252);
((GeneralPath)shapeText).quadTo(48.12, 139.90076, 48.92931, 139.90076);
((GeneralPath)shapeText).quadTo(49.52807, 139.90076, 50.03142, 140.13434);
((GeneralPath)shapeText).quadTo(50.53477, 140.36792, 50.774933, 140.80878);
((GeneralPath)shapeText).quadTo(51.015095, 141.24962, 51.182877, 141.88457);
((GeneralPath)shapeText).quadTo(51.350662, 142.51622, 51.350662, 143.58871);
((GeneralPath)shapeText).quadTo(51.350662, 144.85861, 51.08089, 145.69095);
((GeneralPath)shapeText).quadTo(50.81441, 146.5233, 50.27816, 146.89835);
((GeneralPath)shapeText).quadTo(49.7452, 147.2701, 48.92931, 147.2701);
((GeneralPath)shapeText).quadTo(47.856808, 147.2701, 47.2416, 146.62857);
((GeneralPath)shapeText).quadTo(46.507957, 145.62187, 46.507957, 143.58871);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(47.350166, 143.58543);
((GeneralPath)shapeText).quadTo(47.350166, 145.40144, 47.804173, 145.91466);
((GeneralPath)shapeText).quadTo(48.261463, 146.42789, 48.92931, 146.42789);
((GeneralPath)shapeText).quadTo(49.597157, 146.42789, 50.05116, 145.91138);
((GeneralPath)shapeText).quadTo(50.508453, 145.39487, 50.508453, 143.58543);
((GeneralPath)shapeText).quadTo(50.508453, 141.8714, 50.07748, 141.30884);
((GeneralPath)shapeText).quadTo(49.649796, 140.74297, 48.91944, 140.74297);
((GeneralPath)shapeText).quadTo(48.251595, 140.74297, 47.797592, 141.23975);
((GeneralPath)shapeText).quadTo(47.350166, 141.8747, 47.350166, 143.58543);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(52.12872, 145.16457);
((GeneralPath)shapeText).lineTo(52.12872, 144.32236);
((GeneralPath)shapeText).lineTo(54.865902, 144.32236);
((GeneralPath)shapeText).lineTo(54.865902, 145.16457);
((GeneralPath)shapeText).lineTo(52.12872, 145.16457);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(55.494267, 143.58871);
((GeneralPath)shapeText).quadTo(55.494267, 142.30896, 55.764038, 141.47661);
((GeneralPath)shapeText).quadTo(56.037098, 140.64099, 56.570057, 140.27252);
((GeneralPath)shapeText).quadTo(57.106308, 139.90076, 57.91562, 139.90076);
((GeneralPath)shapeText).quadTo(58.514378, 139.90076, 59.01773, 140.13434);
((GeneralPath)shapeText).quadTo(59.52108, 140.36792, 59.761242, 140.80878);
((GeneralPath)shapeText).quadTo(60.001404, 141.24962, 60.169186, 141.88457);
((GeneralPath)shapeText).quadTo(60.33697, 142.51622, 60.33697, 143.58871);
((GeneralPath)shapeText).quadTo(60.33697, 144.85861, 60.0672, 145.69095);
((GeneralPath)shapeText).quadTo(59.80072, 146.5233, 59.26447, 146.89835);
((GeneralPath)shapeText).quadTo(58.73151, 147.2701, 57.91562, 147.2701);
((GeneralPath)shapeText).quadTo(56.843117, 147.2701, 56.22791, 146.62857);
((GeneralPath)shapeText).quadTo(55.494267, 145.62187, 55.494267, 143.58871);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(56.336475, 143.58543);
((GeneralPath)shapeText).quadTo(56.336475, 145.40144, 56.79048, 145.91466);
((GeneralPath)shapeText).quadTo(57.247772, 146.42789, 57.91562, 146.42789);
((GeneralPath)shapeText).quadTo(58.583466, 146.42789, 59.037468, 145.91138);
((GeneralPath)shapeText).quadTo(59.494762, 145.39487, 59.494762, 143.58543);
((GeneralPath)shapeText).quadTo(59.494762, 141.8714, 59.06379, 141.30884);
((GeneralPath)shapeText).quadTo(58.636105, 140.74297, 57.90575, 140.74297);
((GeneralPath)shapeText).quadTo(57.237904, 140.74297, 56.7839, 141.23975);
((GeneralPath)shapeText).quadTo(56.336475, 141.8747, 56.336475, 143.58543);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(61.11503, 143.58871);
((GeneralPath)shapeText).quadTo(61.11503, 142.30896, 61.3848, 141.47661);
((GeneralPath)shapeText).quadTo(61.65786, 140.64099, 62.19082, 140.27252);
((GeneralPath)shapeText).quadTo(62.72707, 139.90076, 63.53638, 139.90076);
((GeneralPath)shapeText).quadTo(64.13514, 139.90076, 64.63849, 140.13434);
((GeneralPath)shapeText).quadTo(65.141846, 140.36792, 65.382, 140.80878);
((GeneralPath)shapeText).quadTo(65.62216, 141.24962, 65.78995, 141.88457);
((GeneralPath)shapeText).quadTo(65.95773, 142.51622, 65.95773, 143.58871);
((GeneralPath)shapeText).quadTo(65.95773, 144.85861, 65.687965, 145.69095);
((GeneralPath)shapeText).quadTo(65.421486, 146.5233, 64.88523, 146.89835);
((GeneralPath)shapeText).quadTo(64.35227, 147.2701, 63.53638, 147.2701);
((GeneralPath)shapeText).quadTo(62.46388, 147.2701, 61.84867, 146.62857);
((GeneralPath)shapeText).quadTo(61.11503, 145.62187, 61.11503, 143.58871);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(61.957237, 143.58543);
((GeneralPath)shapeText).quadTo(61.957237, 145.40144, 62.411243, 145.91466);
((GeneralPath)shapeText).quadTo(62.868534, 146.42789, 63.53638, 146.42789);
((GeneralPath)shapeText).quadTo(64.20422, 146.42789, 64.65823, 145.91138);
((GeneralPath)shapeText).quadTo(65.115524, 145.39487, 65.115524, 143.58543);
((GeneralPath)shapeText).quadTo(65.115524, 141.8714, 64.68455, 141.30884);
((GeneralPath)shapeText).quadTo(64.25687, 140.74297, 63.526512, 140.74297);
((GeneralPath)shapeText).quadTo(62.858665, 140.74297, 62.404663, 141.23975);
((GeneralPath)shapeText).quadTo(61.957237, 141.8747, 61.957237, 143.58543);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(66.73579, 143.58871);
((GeneralPath)shapeText).quadTo(66.73579, 142.30896, 67.005554, 141.47661);
((GeneralPath)shapeText).quadTo(67.27862, 140.64099, 67.81158, 140.27252);
((GeneralPath)shapeText).quadTo(68.34783, 139.90076, 69.15714, 139.90076);
((GeneralPath)shapeText).quadTo(69.7559, 139.90076, 70.25925, 140.13434);
((GeneralPath)shapeText).quadTo(70.7626, 140.36792, 71.00276, 140.80878);
((GeneralPath)shapeText).quadTo(71.24292, 141.24962, 71.410706, 141.88457);
((GeneralPath)shapeText).quadTo(71.57849, 142.51622, 71.57849, 143.58871);
((GeneralPath)shapeText).quadTo(71.57849, 144.85861, 71.30872, 145.69095);
((GeneralPath)shapeText).quadTo(71.042244, 146.5233, 70.50599, 146.89835);
((GeneralPath)shapeText).quadTo(69.97303, 147.2701, 69.15714, 147.2701);
((GeneralPath)shapeText).quadTo(68.08464, 147.2701, 67.46943, 146.62857);
((GeneralPath)shapeText).quadTo(66.73579, 145.62187, 66.73579, 143.58871);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(67.577995, 143.58543);
((GeneralPath)shapeText).quadTo(67.577995, 145.40144, 68.032, 145.91466);
((GeneralPath)shapeText).quadTo(68.489296, 146.42789, 69.15714, 146.42789);
((GeneralPath)shapeText).quadTo(69.82498, 146.42789, 70.27899, 145.91138);
((GeneralPath)shapeText).quadTo(70.73628, 145.39487, 70.73628, 143.58543);
((GeneralPath)shapeText).quadTo(70.73628, 141.8714, 70.305305, 141.30884);
((GeneralPath)shapeText).quadTo(69.877625, 140.74297, 69.14727, 140.74297);
((GeneralPath)shapeText).quadTo(68.47942, 140.74297, 68.02542, 141.23975);
((GeneralPath)shapeText).quadTo(67.577995, 141.8747, 67.577995, 143.58543);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(72.56711, 145.37512);
((GeneralPath)shapeText).lineTo(73.40932, 145.37512);
((GeneralPath)shapeText).quadTo(73.52117, 145.92783, 73.83371, 146.17786);
((GeneralPath)shapeText).quadTo(74.14625, 146.42789, 74.63644, 146.42789);
((GeneralPath)shapeText).quadTo(75.05425, 146.42789, 75.42272, 146.2568);
((GeneralPath)shapeText).quadTo(75.79119, 146.08574, 75.93923, 145.79951);
((GeneralPath)shapeText).quadTo(76.09057, 145.5133, 76.22545, 145.01982);
((GeneralPath)shapeText).quadTo(76.36034, 144.52304, 76.36034, 143.97035);
((GeneralPath)shapeText).quadTo(76.36034, 143.91113, 76.35705, 143.7927);
((GeneralPath)shapeText).quadTo(76.080696, 144.21709, 75.60367, 144.48027);
((GeneralPath)shapeText).quadTo(75.12663, 144.74347, 74.57064, 144.74347);
((GeneralPath)shapeText).quadTo(73.6429, 144.74347, 72.99808, 144.08878);
((GeneralPath)shapeText).quadTo(72.35655, 143.4308, 72.35655, 142.3583);
((GeneralPath)shapeText).quadTo(72.35655, 141.2529, 73.01782, 140.57848);
((GeneralPath)shapeText).quadTo(73.679085, 139.90076, 74.67263, 139.90076);
((GeneralPath)shapeText).quadTo(75.389824, 139.90076, 75.98529, 140.2791);
((GeneralPath)shapeText).quadTo(76.58076, 140.65744, 76.89001, 141.36147);
((GeneralPath)shapeText).quadTo(77.19926, 142.06221, 77.19926, 143.39133);
((GeneralPath)shapeText).quadTo(77.19926, 144.77307, 76.89659, 145.59555);
((GeneralPath)shapeText).quadTo(76.597206, 146.41473, 76.00174, 146.8424);
((GeneralPath)shapeText).quadTo(75.40627, 147.2701, 74.60354, 147.2701);
((GeneralPath)shapeText).quadTo(73.75475, 147.2701, 73.21521, 146.77333);
((GeneralPath)shapeText).quadTo(72.675674, 146.27655, 72.56711, 145.37512);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(76.35705, 142.33856);
((GeneralPath)shapeText).quadTo(76.35705, 141.60492, 75.95897, 141.17395);
((GeneralPath)shapeText).quadTo(75.5609, 140.74297, 74.82396, 140.74297);
((GeneralPath)shapeText).quadTo(74.064, 140.74297, 73.62974, 141.20685);
((GeneralPath)shapeText).quadTo(73.19876, 141.67072, 73.19876, 142.41093);
((GeneralPath)shapeText).quadTo(73.19876, 143.0722, 73.606705, 143.48674);
((GeneralPath)shapeText).quadTo(74.014656, 143.90126, 74.797646, 143.90126);
((GeneralPath)shapeText).quadTo(75.47865, 143.90126, 75.91621, 143.48674);
((GeneralPath)shapeText).quadTo(76.35705, 143.0722, 76.35705, 142.33856);
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

