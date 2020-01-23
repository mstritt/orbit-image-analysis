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
public class slidepreview3 implements ResizableIcon {
    

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
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0 = g.getTransform();
g.transform(new AffineTransform(0.0f, 1.0f, -1.0f, 0.0f, 227.3691864013672f, 5.543334007263184f));
// _0_0
g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));
AffineTransform defaultTransform__0_0_0 = g.getTransform();
g.transform(new AffineTransform(0.7385876178741455f, 0.0f, 0.0f, 1.1095019578933716f, -6.918469429016113f, -8.622529029846191f));
// _0_0_0
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
g.setTransform(defaultTransform__0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(3.0941164, 3.9813657);
((GeneralPath)shape).lineTo(3.0941164, 46.4382);
((GeneralPath)shape).lineTo(3.0941164, 162.48691);
((GeneralPath)shape).lineTo(3.0941164, 204.94376);
((GeneralPath)shape).lineTo(73.99853, 204.94376);
((GeneralPath)shape).lineTo(73.99853, 113.2193);
((GeneralPath)shape).lineTo(73.99853, 95.70585);
((GeneralPath)shape).lineTo(73.99853, 3.9813843);
((GeneralPath)shape).lineTo(3.0941162, 3.9813843);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new LinearGradientPaint(new Point2D.Double(15.5, 98.5642318725586), new Point2D.Double(112.5, 98.5642318725586), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.7385876178741455f, 0.0f, 0.0f, 1.1095019578933716f, -8.723286628723145f, -4.894649028778076f));
stroke = new BasicStroke(0.9052427f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(3.0941164, 3.9813657);
((GeneralPath)shape).lineTo(3.0941164, 46.4382);
((GeneralPath)shape).lineTo(3.0941164, 162.48691);
((GeneralPath)shape).lineTo(3.0941164, 204.94376);
((GeneralPath)shape).lineTo(73.99853, 204.94376);
((GeneralPath)shape).lineTo(73.99853, 113.2193);
((GeneralPath)shape).lineTo(73.99853, 95.70585);
((GeneralPath)shape).lineTo(73.99853, 3.9813843);
((GeneralPath)shape).lineTo(3.0941162, 3.9813843);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(4.679559, 2.9740276);
((GeneralPath)shape).lineTo(4.679559, 45.828674);
((GeneralPath)shape).lineTo(4.679559, 162.96472);
((GeneralPath)shape).lineTo(4.679559, 205.81937);
((GeneralPath)shape).lineTo(76.24832, 205.81937);
((GeneralPath)shape).lineTo(76.24832, 113.23549);
((GeneralPath)shape).lineTo(76.24832, 95.55793);
((GeneralPath)shape).lineTo(76.24832, 2.9740448);
((GeneralPath)shape).lineTo(4.679558, 2.9740448);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(103.09768676757812, 56.26235580444336), 48.9f, new Point2D.Double(103.09768676757812, 56.26235580444336), new float[] {0.0f,1.0f}, new Color[] {new Color(210, 242, 255, 255),new Color(243, 243, 243, 201)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-0.9076445698738098f, 2.406406879425049f, -1.2132166624069214f, -1.0326120853424072f, 231.67376708984375f, -179.3292236328125f));
g.setPaint(paint);
g.fill(shape);
paint = new RadialGradientPaint(new Point2D.Double(18.182392120361328, 147.37173461914062), 48.5f, new Point2D.Double(18.182392120361328, 147.37173461914062), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.3981372117996216f, -0.014106130227446556f, 0.009401139803230762f, 2.102686882019043f, -20.272674560546875f, -107.73248291015625f));
stroke = new BasicStroke(1.6447041f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(4.679559, 2.9740276);
((GeneralPath)shape).lineTo(4.679559, 45.828674);
((GeneralPath)shape).lineTo(4.679559, 162.96472);
((GeneralPath)shape).lineTo(4.679559, 205.81937);
((GeneralPath)shape).lineTo(76.24832, 205.81937);
((GeneralPath)shape).lineTo(76.24832, 113.23549);
((GeneralPath)shape).lineTo(76.24832, 95.55793);
((GeneralPath)shape).lineTo(76.24832, 2.9740448);
((GeneralPath)shape).lineTo(4.679558, 2.9740448);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_3 = g.getTransform();
g.transform(new AffineTransform(0.8200885653495789f, 0.0f, 0.0f, 0.8374932408332825f, -6.837552547454834f, 13.086779594421387f));
// _0_0_3
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_3_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3_0
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
g.setTransform(defaultTransform__0_0_3_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_3_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3_1
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
g.setTransform(defaultTransform__0_0_3_1);
g.setTransform(defaultTransform__0_0_3);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
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
g.setTransform(defaultTransform__0_0_4);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_5 = g.getTransform();
g.transform(new AffineTransform(1.6121793985366821f, 0.0f, 0.0f, 0.4258544147014618f, 330.9063720703125f, 174.66783142089844f));
// _0_0_5
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_5_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5_0
shape = new Rectangle2D.Double(-186.7389678955078, 11.896512985229492, 0.9807788133621216, 37.023963928222656);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.1355733f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-186.7389678955078, 11.896512985229492, 0.9807788133621216, 37.023963928222656);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_5_0);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_5_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5_1
shape = new Rectangle2D.Double(-189.53216552734375, 11.928726196289062, 2.138154983520508, 36.959537506103516);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-189.53216552734375, 11.928726196289062, 2.138154983520508, 36.959537506103516);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_5_1);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_5_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5_2
shape = new Rectangle2D.Double(-196.3284454345703, 11.928726196289062, 2.138154983520508, 36.959537506103516);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-196.3284454345703, 11.928726196289062, 2.138154983520508, 36.959537506103516);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_5_2);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_5_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5_3
shape = new Rectangle2D.Double(-199.15386962890625, 11.928726196289062, 2.138154983520508, 36.959537506103516);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-199.15386962890625, 11.928726196289062, 2.138154983520508, 36.959537506103516);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_5_3);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_5_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5_4
shape = new Rectangle2D.Double(-178.72088623046875, 11.896512985229492, 0.9807788133621216, 37.023963928222656);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.1355733f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-178.72088623046875, 11.896512985229492, 0.9807788133621216, 37.023963928222656);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_5_4);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_5_5 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5_5
shape = new Rectangle2D.Double(-172.99368286132812, 11.896512985229492, 0.9807788133621216, 37.023963928222656);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.1355733f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-172.99368286132812, 11.896512985229492, 0.9807788133621216, 37.023963928222656);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_5_5);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_5_6 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5_6
shape = new Rectangle2D.Double(-175.78688049316406, 11.928726196289062, 2.138154983520508, 36.959537506103516);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-175.78688049316406, 11.928726196289062, 2.138154983520508, 36.959537506103516);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_5_6);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_5_7 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5_7
shape = new Rectangle2D.Double(-182.58316040039062, 11.928726196289062, 2.138154983520508, 36.959537506103516);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-182.58316040039062, 11.928726196289062, 2.138154983520508, 36.959537506103516);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_5_7);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_5_8 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5_8
shape = new Rectangle2D.Double(-185.40858459472656, 11.928726196289062, 2.138154983520508, 36.959537506103516);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-185.40858459472656, 11.928726196289062, 2.138154983520508, 36.959537506103516);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_5_8);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_5_9 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5_9
shape = new Rectangle2D.Double(-164.97560119628906, 11.896512985229492, 0.9807788133621216, 37.023963928222656);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.1355733f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-164.97560119628906, 11.896512985229492, 0.9807788133621216, 37.023963928222656);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_5_9);
g.setTransform(defaultTransform__0_0_5);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_6 = g.getTransform();
g.transform(new AffineTransform(-1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6
shape = new Rectangle2D.Double(-71.12432098388672, 179.7340087890625, 1.5811914205551147, 15.76681900024414);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.11233405f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-71.12432098388672, 179.7340087890625, 1.5811914205551147, 15.76681900024414);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_6);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_7 = g.getTransform();
g.transform(new AffineTransform(-1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
shape = new Rectangle2D.Double(-58.19773483276367, 179.7340087890625, 1.5811914205551147, 15.76681900024414);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.11233405f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(-58.19773483276367, 179.7340087890625, 1.5811914205551147, 15.76681900024414);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_7);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_8 = g.getTransform();
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
((GeneralPath)shapeText).moveTo(44.68125, 147.2701);
((GeneralPath)shapeText).lineTo(44.68125, 139.90076);
((GeneralPath)shapeText).lineTo(49.73451, 139.90076);
((GeneralPath)shapeText).lineTo(49.73451, 140.74297);
((GeneralPath)shapeText).lineTo(45.52346, 140.74297);
((GeneralPath)shapeText).lineTo(45.52346, 143.05905);
((GeneralPath)shapeText).lineTo(49.523956, 143.05905);
((GeneralPath)shapeText).lineTo(49.523956, 143.90126);
((GeneralPath)shapeText).lineTo(45.52346, 143.90126);
((GeneralPath)shapeText).lineTo(45.52346, 146.42789);
((GeneralPath)shapeText).lineTo(49.94506, 146.42789);
((GeneralPath)shapeText).lineTo(49.94506, 147.2701);
((GeneralPath)shapeText).lineTo(44.68125, 147.2701);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(51.42222, 147.2701);
((GeneralPath)shapeText).lineTo(51.42222, 139.90076);
((GeneralPath)shapeText).lineTo(52.264427, 139.90076);
((GeneralPath)shapeText).lineTo(52.264427, 146.42789);
((GeneralPath)shapeText).lineTo(55.84382, 146.42789);
((GeneralPath)shapeText).lineTo(55.84382, 147.2701);
((GeneralPath)shapeText).lineTo(51.42222, 147.2701);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(57.042976, 147.2701);
((GeneralPath)shapeText).lineTo(57.042976, 139.90076);
((GeneralPath)shapeText).lineTo(59.836086, 139.90076);
((GeneralPath)shapeText).quadTo(60.691456, 139.90076, 61.204678, 140.13434);
((GeneralPath)shapeText).quadTo(61.721188, 140.36464, 62.01399, 140.84825);
((GeneralPath)shapeText).quadTo(62.306786, 141.33186, 62.306786, 141.85825);
((GeneralPath)shapeText).quadTo(62.306786, 142.34843, 62.076496, 142.7827);
((GeneralPath)shapeText).quadTo(61.84949, 143.21367, 61.38891, 143.48015);
((GeneralPath)shapeText).quadTo(61.93174, 143.67096, 62.22454, 144.12827);
((GeneralPath)shapeText).quadTo(62.517338, 144.58226, 62.517338, 145.20406);
((GeneralPath)shapeText).quadTo(62.517338, 145.70412, 62.300205, 146.13509);
((GeneralPath)shapeText).quadTo(62.086365, 146.56606, 61.770535, 146.79964);
((GeneralPath)shapeText).quadTo(61.45471, 147.03322, 60.977676, 147.15166);
((GeneralPath)shapeText).quadTo(60.50064, 147.2701, 59.806477, 147.2701);
((GeneralPath)shapeText).lineTo(57.042976, 147.2701);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(57.885185, 143.05905);
((GeneralPath)shapeText).lineTo(59.628822, 143.05905);
((GeneralPath)shapeText).quadTo(60.33944, 143.05905, 60.645397, 142.97021);
((GeneralPath)shapeText).quadTo(61.05334, 142.85507, 61.257313, 142.5886);
((GeneralPath)shapeText).quadTo(61.464577, 142.32211, 61.464577, 141.92075);
((GeneralPath)shapeText).quadTo(61.464577, 141.53912, 61.270473, 141.24962);
((GeneralPath)shapeText).quadTo(61.079662, 140.95682, 60.721066, 140.85153);
((GeneralPath)shapeText).quadTo(60.365757, 140.74297, 59.497227, 140.74297);
((GeneralPath)shapeText).lineTo(57.885185, 140.74297);
((GeneralPath)shapeText).lineTo(57.885185, 143.05905);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(57.885185, 146.42789);
((GeneralPath)shapeText).lineTo(59.829506, 146.42789);
((GeneralPath)shapeText).quadTo(60.329567, 146.42789, 60.53025, 146.3917);
((GeneralPath)shapeText).quadTo(60.888847, 146.33247, 61.12572, 146.1943);
((GeneralPath)shapeText).quadTo(61.36588, 146.05284, 61.520504, 145.78636);
((GeneralPath)shapeText).quadTo(61.67513, 145.51659, 61.67513, 145.16457);
((GeneralPath)shapeText).quadTo(61.67513, 144.75334, 61.507347, 144.45067);
((GeneralPath)shapeText).quadTo(61.33956, 144.148, 60.928326, 144.02628);
((GeneralPath)shapeText).quadTo(60.520382, 143.90126, 59.75055, 143.90126);
((GeneralPath)shapeText).lineTo(57.885185, 143.90126);
((GeneralPath)shapeText).lineTo(57.885185, 146.42789);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(63.36284, 143.58871);
((GeneralPath)shapeText).quadTo(63.36284, 142.30896, 63.63261, 141.47661);
((GeneralPath)shapeText).quadTo(63.90567, 140.64099, 64.43863, 140.27252);
((GeneralPath)shapeText).quadTo(64.974884, 139.90076, 65.784195, 139.90076);
((GeneralPath)shapeText).quadTo(66.38295, 139.90076, 66.8863, 140.13434);
((GeneralPath)shapeText).quadTo(67.389656, 140.36792, 67.629814, 140.80878);
((GeneralPath)shapeText).quadTo(67.86997, 141.24962, 68.03776, 141.88457);
((GeneralPath)shapeText).quadTo(68.20554, 142.51622, 68.20554, 143.58871);
((GeneralPath)shapeText).quadTo(68.20554, 144.85861, 67.935776, 145.69095);
((GeneralPath)shapeText).quadTo(67.6693, 146.5233, 67.13304, 146.89835);
((GeneralPath)shapeText).quadTo(66.60008, 147.2701, 65.784195, 147.2701);
((GeneralPath)shapeText).quadTo(64.71169, 147.2701, 64.09648, 146.62857);
((GeneralPath)shapeText).quadTo(63.36284, 145.62187, 63.36284, 143.58871);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(64.20505, 143.58543);
((GeneralPath)shapeText).quadTo(64.20505, 145.40144, 64.65905, 145.91466);
((GeneralPath)shapeText).quadTo(65.11635, 146.42789, 65.784195, 146.42789);
((GeneralPath)shapeText).quadTo(66.452034, 146.42789, 66.906044, 145.91138);
((GeneralPath)shapeText).quadTo(67.363335, 145.39487, 67.363335, 143.58543);
((GeneralPath)shapeText).quadTo(67.363335, 141.8714, 66.93236, 141.30884);
((GeneralPath)shapeText).quadTo(66.50468, 140.74297, 65.77432, 140.74297);
((GeneralPath)shapeText).quadTo(65.106476, 140.74297, 64.65247, 141.23975);
((GeneralPath)shapeText).quadTo(64.20505, 141.8747, 64.20505, 143.58543);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(68.983604, 143.58871);
((GeneralPath)shapeText).quadTo(68.983604, 142.30896, 69.25337, 141.47661);
((GeneralPath)shapeText).quadTo(69.526436, 140.64099, 70.059395, 140.27252);
((GeneralPath)shapeText).quadTo(70.59565, 139.90076, 71.40496, 139.90076);
((GeneralPath)shapeText).quadTo(72.003716, 139.90076, 72.507065, 140.13434);
((GeneralPath)shapeText).quadTo(73.01042, 140.36792, 73.25058, 140.80878);
((GeneralPath)shapeText).quadTo(73.49074, 141.24962, 73.65852, 141.88457);
((GeneralPath)shapeText).quadTo(73.82631, 142.51622, 73.82631, 143.58871);
((GeneralPath)shapeText).quadTo(73.82631, 144.85861, 73.55654, 145.69095);
((GeneralPath)shapeText).quadTo(73.29006, 146.5233, 72.75381, 146.89835);
((GeneralPath)shapeText).quadTo(72.22085, 147.2701, 71.40496, 147.2701);
((GeneralPath)shapeText).quadTo(70.33246, 147.2701, 69.71725, 146.62857);
((GeneralPath)shapeText).quadTo(68.983604, 145.62187, 68.983604, 143.58871);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(69.82581, 143.58543);
((GeneralPath)shapeText).quadTo(69.82581, 145.40144, 70.279816, 145.91466);
((GeneralPath)shapeText).quadTo(70.737114, 146.42789, 71.40496, 146.42789);
((GeneralPath)shapeText).quadTo(72.0728, 146.42789, 72.52681, 145.91138);
((GeneralPath)shapeText).quadTo(72.9841, 145.39487, 72.9841, 143.58543);
((GeneralPath)shapeText).quadTo(72.9841, 141.8714, 72.55312, 141.30884);
((GeneralPath)shapeText).quadTo(72.12544, 140.74297, 71.39509, 140.74297);
((GeneralPath)shapeText).quadTo(70.72724, 140.74297, 70.27324, 141.23975);
((GeneralPath)shapeText).quadTo(69.82581, 141.8747, 69.82581, 143.58543);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(74.81492, 145.37512);
((GeneralPath)shapeText).lineTo(75.65713, 145.37512);
((GeneralPath)shapeText).quadTo(75.76898, 145.92783, 76.08152, 146.17786);
((GeneralPath)shapeText).quadTo(76.39406, 146.42789, 76.88425, 146.42789);
((GeneralPath)shapeText).quadTo(77.30206, 146.42789, 77.67053, 146.2568);
((GeneralPath)shapeText).quadTo(78.039, 146.08574, 78.18704, 145.79951);
((GeneralPath)shapeText).quadTo(78.33838, 145.5133, 78.47326, 145.01982);
((GeneralPath)shapeText).quadTo(78.60815, 144.52304, 78.60815, 143.97035);
((GeneralPath)shapeText).quadTo(78.60815, 143.91113, 78.60486, 143.7927);
((GeneralPath)shapeText).quadTo(78.32851, 144.21709, 77.85148, 144.48027);
((GeneralPath)shapeText).quadTo(77.37444, 144.74347, 76.81845, 144.74347);
((GeneralPath)shapeText).quadTo(75.89071, 144.74347, 75.24589, 144.08878);
((GeneralPath)shapeText).quadTo(74.60436, 143.4308, 74.60436, 142.3583);
((GeneralPath)shapeText).quadTo(74.60436, 141.2529, 75.26563, 140.57848);
((GeneralPath)shapeText).quadTo(75.926895, 139.90076, 76.92044, 139.90076);
((GeneralPath)shapeText).quadTo(77.637634, 139.90076, 78.2331, 140.2791);
((GeneralPath)shapeText).quadTo(78.82857, 140.65744, 79.13782, 141.36147);
((GeneralPath)shapeText).quadTo(79.44707, 142.06221, 79.44707, 143.39133);
((GeneralPath)shapeText).quadTo(79.44707, 144.77307, 79.1444, 145.59555);
((GeneralPath)shapeText).quadTo(78.84502, 146.41473, 78.24955, 146.8424);
((GeneralPath)shapeText).quadTo(77.65408, 147.2701, 76.85135, 147.2701);
((GeneralPath)shapeText).quadTo(76.00256, 147.2701, 75.46302, 146.77333);
((GeneralPath)shapeText).quadTo(74.923485, 146.27655, 74.81492, 145.37512);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(78.60486, 142.33856);
((GeneralPath)shapeText).quadTo(78.60486, 141.60492, 78.20678, 141.17395);
((GeneralPath)shapeText).quadTo(77.80871, 140.74297, 77.07177, 140.74297);
((GeneralPath)shapeText).quadTo(76.31181, 140.74297, 75.87755, 141.20685);
((GeneralPath)shapeText).quadTo(75.44657, 141.67072, 75.44657, 142.41093);
((GeneralPath)shapeText).quadTo(75.44657, 143.0722, 75.854515, 143.48674);
((GeneralPath)shapeText).quadTo(76.26247, 143.90126, 77.045456, 143.90126);
((GeneralPath)shapeText).quadTo(77.72646, 143.90126, 78.16402, 143.48674);
((GeneralPath)shapeText).quadTo(78.60486, 143.0722, 78.60486, 142.33856);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(80.22512, 143.58871);
((GeneralPath)shapeText).quadTo(80.22512, 142.30896, 80.49489, 141.47661);
((GeneralPath)shapeText).quadTo(80.76795, 140.64099, 81.30091, 140.27252);
((GeneralPath)shapeText).quadTo(81.837166, 139.90076, 82.64648, 139.90076);
((GeneralPath)shapeText).quadTo(83.24523, 139.90076, 83.74858, 140.13434);
((GeneralPath)shapeText).quadTo(84.25194, 140.36792, 84.492096, 140.80878);
((GeneralPath)shapeText).quadTo(84.732254, 141.24962, 84.90004, 141.88457);
((GeneralPath)shapeText).quadTo(85.067825, 142.51622, 85.067825, 143.58871);
((GeneralPath)shapeText).quadTo(85.067825, 144.85861, 84.79806, 145.69095);
((GeneralPath)shapeText).quadTo(84.53158, 146.5233, 83.99532, 146.89835);
((GeneralPath)shapeText).quadTo(83.462364, 147.2701, 82.64648, 147.2701);
((GeneralPath)shapeText).quadTo(81.573975, 147.2701, 80.95876, 146.62857);
((GeneralPath)shapeText).quadTo(80.22512, 145.62187, 80.22512, 143.58871);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(81.06733, 143.58543);
((GeneralPath)shapeText).quadTo(81.06733, 145.40144, 81.52133, 145.91466);
((GeneralPath)shapeText).quadTo(81.97863, 146.42789, 82.64648, 146.42789);
((GeneralPath)shapeText).quadTo(83.314316, 146.42789, 83.768326, 145.91138);
((GeneralPath)shapeText).quadTo(84.22562, 145.39487, 84.22562, 143.58543);
((GeneralPath)shapeText).quadTo(84.22562, 141.8714, 83.79464, 141.30884);
((GeneralPath)shapeText).quadTo(83.36696, 140.74297, 82.636604, 140.74297);
((GeneralPath)shapeText).quadTo(81.96876, 140.74297, 81.514755, 141.23975);
((GeneralPath)shapeText).quadTo(81.06733, 141.8747, 81.06733, 143.58543);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(85.84589, 145.16457);
((GeneralPath)shapeText).lineTo(85.84589, 144.32236);
((GeneralPath)shapeText).lineTo(88.58307, 144.32236);
((GeneralPath)shapeText).lineTo(88.58307, 145.16457);
((GeneralPath)shapeText).lineTo(85.84589, 145.16457);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(89.21143, 143.58871);
((GeneralPath)shapeText).quadTo(89.21143, 142.30896, 89.4812, 141.47661);
((GeneralPath)shapeText).quadTo(89.754265, 140.64099, 90.287224, 140.27252);
((GeneralPath)shapeText).quadTo(90.82348, 139.90076, 91.63279, 139.90076);
((GeneralPath)shapeText).quadTo(92.231544, 139.90076, 92.73489, 140.13434);
((GeneralPath)shapeText).quadTo(93.23825, 140.36792, 93.47841, 140.80878);
((GeneralPath)shapeText).quadTo(93.71857, 141.24962, 93.88635, 141.88457);
((GeneralPath)shapeText).quadTo(94.05414, 142.51622, 94.05414, 143.58871);
((GeneralPath)shapeText).quadTo(94.05414, 144.85861, 93.78437, 145.69095);
((GeneralPath)shapeText).quadTo(93.51789, 146.5233, 92.981636, 146.89835);
((GeneralPath)shapeText).quadTo(92.44868, 147.2701, 91.63279, 147.2701);
((GeneralPath)shapeText).quadTo(90.56029, 147.2701, 89.945076, 146.62857);
((GeneralPath)shapeText).quadTo(89.21143, 145.62187, 89.21143, 143.58871);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(90.05364, 143.58543);
((GeneralPath)shapeText).quadTo(90.05364, 145.40144, 90.507645, 145.91466);
((GeneralPath)shapeText).quadTo(90.96494, 146.42789, 91.63279, 146.42789);
((GeneralPath)shapeText).quadTo(92.30063, 146.42789, 92.75464, 145.91138);
((GeneralPath)shapeText).quadTo(93.21193, 145.39487, 93.21193, 143.58543);
((GeneralPath)shapeText).quadTo(93.21193, 141.8714, 92.78095, 141.30884);
((GeneralPath)shapeText).quadTo(92.35327, 140.74297, 91.62292, 140.74297);
((GeneralPath)shapeText).quadTo(90.95507, 140.74297, 90.50107, 141.23975);
((GeneralPath)shapeText).quadTo(90.05364, 141.8747, 90.05364, 143.58543);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(94.83219, 143.58871);
((GeneralPath)shapeText).quadTo(94.83219, 142.30896, 95.10196, 141.47661);
((GeneralPath)shapeText).quadTo(95.37502, 140.64099, 95.90798, 140.27252);
((GeneralPath)shapeText).quadTo(96.44424, 139.90076, 97.25355, 139.90076);
((GeneralPath)shapeText).quadTo(97.8523, 139.90076, 98.35565, 140.13434);
((GeneralPath)shapeText).quadTo(98.85901, 140.36792, 99.09917, 140.80878);
((GeneralPath)shapeText).quadTo(99.339325, 141.24962, 99.50711, 141.88457);
((GeneralPath)shapeText).quadTo(99.6749, 142.51622, 99.6749, 143.58871);
((GeneralPath)shapeText).quadTo(99.6749, 144.85861, 99.40513, 145.69095);
((GeneralPath)shapeText).quadTo(99.13865, 146.5233, 98.602394, 146.89835);
((GeneralPath)shapeText).quadTo(98.069435, 147.2701, 97.25355, 147.2701);
((GeneralPath)shapeText).quadTo(96.181046, 147.2701, 95.565834, 146.62857);
((GeneralPath)shapeText).quadTo(94.83219, 145.62187, 94.83219, 143.58871);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(95.6744, 143.58543);
((GeneralPath)shapeText).quadTo(95.6744, 145.40144, 96.1284, 145.91466);
((GeneralPath)shapeText).quadTo(96.5857, 146.42789, 97.25355, 146.42789);
((GeneralPath)shapeText).quadTo(97.92139, 146.42789, 98.3754, 145.91138);
((GeneralPath)shapeText).quadTo(98.83269, 145.39487, 98.83269, 143.58543);
((GeneralPath)shapeText).quadTo(98.83269, 141.8714, 98.40171, 141.30884);
((GeneralPath)shapeText).quadTo(97.97403, 140.74297, 97.243675, 140.74297);
((GeneralPath)shapeText).quadTo(96.57583, 140.74297, 96.121826, 141.23975);
((GeneralPath)shapeText).quadTo(95.6744, 141.8747, 95.6744, 143.58543);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(100.45296, 143.58871);
((GeneralPath)shapeText).quadTo(100.45296, 142.30896, 100.722725, 141.47661);
((GeneralPath)shapeText).quadTo(100.99579, 140.64099, 101.52875, 140.27252);
((GeneralPath)shapeText).quadTo(102.065, 139.90076, 102.87431, 139.90076);
((GeneralPath)shapeText).quadTo(103.47307, 139.90076, 103.97642, 140.13434);
((GeneralPath)shapeText).quadTo(104.479774, 140.36792, 104.71993, 140.80878);
((GeneralPath)shapeText).quadTo(104.96009, 141.24962, 105.12788, 141.88457);
((GeneralPath)shapeText).quadTo(105.29566, 142.51622, 105.29566, 143.58871);
((GeneralPath)shapeText).quadTo(105.29566, 144.85861, 105.025894, 145.69095);
((GeneralPath)shapeText).quadTo(104.759415, 146.5233, 104.22316, 146.89835);
((GeneralPath)shapeText).quadTo(103.6902, 147.2701, 102.87431, 147.2701);
((GeneralPath)shapeText).quadTo(101.80181, 147.2701, 101.1866, 146.62857);
((GeneralPath)shapeText).quadTo(100.45296, 145.62187, 100.45296, 143.58871);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(101.295166, 143.58543);
((GeneralPath)shapeText).quadTo(101.295166, 145.40144, 101.74917, 145.91466);
((GeneralPath)shapeText).quadTo(102.20647, 146.42789, 102.87431, 146.42789);
((GeneralPath)shapeText).quadTo(103.54215, 146.42789, 103.99616, 145.91138);
((GeneralPath)shapeText).quadTo(104.45345, 145.39487, 104.45345, 143.58543);
((GeneralPath)shapeText).quadTo(104.45345, 141.8714, 104.02248, 141.30884);
((GeneralPath)shapeText).quadTo(103.594795, 140.74297, 102.86444, 140.74297);
((GeneralPath)shapeText).quadTo(102.196594, 140.74297, 101.74259, 141.23975);
((GeneralPath)shapeText).quadTo(101.295166, 141.8747, 101.295166, 143.58543);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(106.28428, 145.37512);
((GeneralPath)shapeText).lineTo(107.12649, 145.37512);
((GeneralPath)shapeText).quadTo(107.23834, 145.92783, 107.55088, 146.17786);
((GeneralPath)shapeText).quadTo(107.86342, 146.42789, 108.35361, 146.42789);
((GeneralPath)shapeText).quadTo(108.77142, 146.42789, 109.13989, 146.2568);
((GeneralPath)shapeText).quadTo(109.50836, 146.08574, 109.6564, 145.79951);
((GeneralPath)shapeText).quadTo(109.80774, 145.5133, 109.94262, 145.01982);
((GeneralPath)shapeText).quadTo(110.07751, 144.52304, 110.07751, 143.97035);
((GeneralPath)shapeText).quadTo(110.07751, 143.91113, 110.07422, 143.7927);
((GeneralPath)shapeText).quadTo(109.79787, 144.21709, 109.32084, 144.48027);
((GeneralPath)shapeText).quadTo(108.8438, 144.74347, 108.28781, 144.74347);
((GeneralPath)shapeText).quadTo(107.36007, 144.74347, 106.71525, 144.08878);
((GeneralPath)shapeText).quadTo(106.07372, 143.4308, 106.07372, 142.3583);
((GeneralPath)shapeText).quadTo(106.07372, 141.2529, 106.73499, 140.57848);
((GeneralPath)shapeText).quadTo(107.396255, 139.90076, 108.3898, 139.90076);
((GeneralPath)shapeText).quadTo(109.106995, 139.90076, 109.70246, 140.2791);
((GeneralPath)shapeText).quadTo(110.29793, 140.65744, 110.60718, 141.36147);
((GeneralPath)shapeText).quadTo(110.91643, 142.06221, 110.91643, 143.39133);
((GeneralPath)shapeText).quadTo(110.91643, 144.77307, 110.61376, 145.59555);
((GeneralPath)shapeText).quadTo(110.31438, 146.41473, 109.71891, 146.8424);
((GeneralPath)shapeText).quadTo(109.12344, 147.2701, 108.32071, 147.2701);
((GeneralPath)shapeText).quadTo(107.471924, 147.2701, 106.93238, 146.77333);
((GeneralPath)shapeText).quadTo(106.392845, 146.27655, 106.28428, 145.37512);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(110.07422, 142.33856);
((GeneralPath)shapeText).quadTo(110.07422, 141.60492, 109.67614, 141.17395);
((GeneralPath)shapeText).quadTo(109.27807, 140.74297, 108.54113, 140.74297);
((GeneralPath)shapeText).quadTo(107.78117, 140.74297, 107.34691, 141.20685);
((GeneralPath)shapeText).quadTo(106.91593, 141.67072, 106.91593, 142.41093);
((GeneralPath)shapeText).quadTo(106.91593, 143.0722, 107.323875, 143.48674);
((GeneralPath)shapeText).quadTo(107.73183, 143.90126, 108.51482, 143.90126);
((GeneralPath)shapeText).quadTo(109.19582, 143.90126, 109.63338, 143.48674);
((GeneralPath)shapeText).quadTo(110.07422, 143.0722, 110.07422, 142.33856);
((GeneralPath)shapeText).closePath();
gText.fill(shapeText);
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
    gText.dispose();
}
g.setTransform(defaultTransform__0_0_8);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_9 = g.getTransform();
g.transform(new AffineTransform(0.5473774075508118f, 0.0f, 0.0f, 0.7811082601547241f, 9.056873321533203f, 67.79796600341797f));
// _0_0_9
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_9_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9_0
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
g.setTransform(defaultTransform__0_0_9_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_9_1 = g.getTransform();
g.transform(new AffineTransform(1.8268930912017822f, 0.0f, 0.0f, 1.280232310295105f, -16.54593849182129f, -86.79715728759766f));
// _0_0_9_1
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
((GeneralPath)shape).curveTo(39.9375, 123.37108, 31.292854, 120.93242, 37.65625, 116.6875);
((GeneralPath)shape).closePath();
paint = new Color(170, 102, 183, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_9_1);
g.setTransform(defaultTransform__0_0_9);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_10 = g.getTransform();
g.transform(new AffineTransform(0.6027528047561646f, 0.0f, 0.0f, 0.5494840741157532f, 4.249017238616943f, -9.982442855834961f));
// _0_0_10
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_10_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10_0
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
g.setTransform(defaultTransform__0_0_10_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_10_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10_1
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
g.setTransform(defaultTransform__0_0_10_1);
g.setTransform(defaultTransform__0_0_10);
g.setComposite(AlphaComposite.getInstance(3, 0.8f * origAlpha));
AffineTransform defaultTransform__0_0_11 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_11
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
g.setTransform(defaultTransform__0_0_11);
g.setComposite(AlphaComposite.getInstance(3, 0.8f * origAlpha));
AffineTransform defaultTransform__0_0_12 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_12
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
        return -3.7715969938290073E-6;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 7.07259005139349E-7;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 245.0196533203125;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 104.60462188720703;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private slidepreview3() {
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
       slidepreview3 base = new slidepreview3();
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
       slidepreview3 base = new slidepreview3();
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
        return slidepreview3::new;
    }
}

