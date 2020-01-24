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
((GeneralPath)shapeText).moveTo(44.83259, 139.90076);
((GeneralPath)shapeText).lineTo(49.49106, 139.90076);
((GeneralPath)shapeText).lineTo(49.49106, 140.73969);
((GeneralPath)shapeText).lineTo(45.829422, 140.73969);
((GeneralPath)shapeText).lineTo(45.829422, 142.92087);
((GeneralPath)shapeText).lineTo(49.336433, 142.92087);
((GeneralPath)shapeText).lineTo(49.336433, 143.7598);
((GeneralPath)shapeText).lineTo(45.829422, 143.7598);
((GeneralPath)shapeText).lineTo(45.829422, 146.43118);
((GeneralPath)shapeText).lineTo(49.579884, 146.43118);
((GeneralPath)shapeText).lineTo(49.579884, 147.2701);
((GeneralPath)shapeText).lineTo(44.83259, 147.2701);
((GeneralPath)shapeText).lineTo(44.83259, 139.90076);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(51.218246, 139.90076);
((GeneralPath)shapeText).lineTo(52.21508, 139.90076);
((GeneralPath)shapeText).lineTo(52.21508, 146.43118);
((GeneralPath)shapeText).lineTo(55.80105, 146.43118);
((GeneralPath)shapeText).lineTo(55.80105, 147.2701);
((GeneralPath)shapeText).lineTo(51.218246, 147.2701);
((GeneralPath)shapeText).lineTo(51.218246, 139.90076);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(57.84571, 143.74992);
((GeneralPath)shapeText).lineTo(57.84571, 146.45091);
((GeneralPath)shapeText).lineTo(59.44459, 146.45091);
((GeneralPath)shapeText).quadTo(60.247322, 146.45091, 60.63553, 146.11864);
((GeneralPath)shapeText).quadTo(61.023735, 145.78307, 61.023735, 145.09877);
((GeneralPath)shapeText).quadTo(61.023735, 144.4079, 60.63553, 144.07892);
((GeneralPath)shapeText).quadTo(60.247322, 143.74992, 59.44459, 143.74992);
((GeneralPath)shapeText).lineTo(57.84571, 143.74992);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(57.84571, 140.71994);
((GeneralPath)shapeText).lineTo(57.84571, 142.94061);
((GeneralPath)shapeText).lineTo(59.319576, 142.94061);
((GeneralPath)shapeText).quadTo(60.04993, 142.94061, 60.408527, 142.66756);
((GeneralPath)shapeText).quadTo(60.767124, 142.39449, 60.767124, 141.83192);
((GeneralPath)shapeText).quadTo(60.767124, 141.27264, 60.408527, 140.99629);
((GeneralPath)shapeText).quadTo(60.04993, 140.71994, 59.319576, 140.71994);
((GeneralPath)shapeText).lineTo(57.84571, 140.71994);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(56.848877, 139.90076);
((GeneralPath)shapeText).lineTo(59.395245, 139.90076);
((GeneralPath)shapeText).quadTo(60.533543, 139.90076, 61.14875, 140.37451);
((GeneralPath)shapeText).quadTo(61.767246, 140.84825, 61.767246, 141.72336);
((GeneralPath)shapeText).quadTo(61.767246, 142.39778, 61.45142, 142.79915);
((GeneralPath)shapeText).quadTo(61.13559, 143.19722, 60.523674, 143.29591);
((GeneralPath)shapeText).quadTo(61.260605, 143.45383, 61.66526, 143.95718);
((GeneralPath)shapeText).quadTo(62.073208, 144.45724, 62.073208, 145.20734);
((GeneralPath)shapeText).quadTo(62.073208, 146.1943, 61.40207, 146.73384);
((GeneralPath)shapeText).quadTo(60.730934, 147.2701, 59.49394, 147.2701);
((GeneralPath)shapeText).lineTo(56.848877, 147.2701);
((GeneralPath)shapeText).lineTo(56.848877, 139.90076);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(66.00297, 140.55875);
((GeneralPath)shapeText).quadTo(65.23314, 140.55875, 64.84493, 141.31541);
((GeneralPath)shapeText).quadTo(64.456726, 142.07208, 64.456726, 143.59201);
((GeneralPath)shapeText).quadTo(64.456726, 145.10864, 64.84493, 145.86531);
((GeneralPath)shapeText).quadTo(65.23314, 146.622, 66.00297, 146.622);
((GeneralPath)shapeText).quadTo(66.77609, 146.622, 67.1643, 145.86531);
((GeneralPath)shapeText).quadTo(67.552505, 145.10864, 67.552505, 143.59201);
((GeneralPath)shapeText).quadTo(67.552505, 142.07208, 67.1643, 141.31541);
((GeneralPath)shapeText).quadTo(66.77609, 140.55875, 66.00297, 140.55875);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(66.00297, 139.76917);
((GeneralPath)shapeText).quadTo(67.23997, 139.76917, 67.89465, 140.74956);
((GeneralPath)shapeText).quadTo(68.54934, 141.72665, 68.54934, 143.59201);
((GeneralPath)shapeText).quadTo(68.54934, 145.45409, 67.89465, 146.43446);
((GeneralPath)shapeText).quadTo(67.23997, 147.41486, 66.00297, 147.41486);
((GeneralPath)shapeText).quadTo(64.76269, 147.41486, 64.108, 146.43446);
((GeneralPath)shapeText).quadTo(63.456604, 145.45409, 63.456604, 143.59201);
((GeneralPath)shapeText).quadTo(63.456604, 141.72665, 64.108, 140.74956);
((GeneralPath)shapeText).quadTo(64.76269, 139.76917, 66.00297, 139.76917);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(72.43304, 140.55875);
((GeneralPath)shapeText).quadTo(71.66321, 140.55875, 71.275, 141.31541);
((GeneralPath)shapeText).quadTo(70.886795, 142.07208, 70.886795, 143.59201);
((GeneralPath)shapeText).quadTo(70.886795, 145.10864, 71.275, 145.86531);
((GeneralPath)shapeText).quadTo(71.66321, 146.622, 72.43304, 146.622);
((GeneralPath)shapeText).quadTo(73.20616, 146.622, 73.59437, 145.86531);
((GeneralPath)shapeText).quadTo(73.982574, 145.10864, 73.982574, 143.59201);
((GeneralPath)shapeText).quadTo(73.982574, 142.07208, 73.59437, 141.31541);
((GeneralPath)shapeText).quadTo(73.20616, 140.55875, 72.43304, 140.55875);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(72.43304, 139.76917);
((GeneralPath)shapeText).quadTo(73.67004, 139.76917, 74.32472, 140.74956);
((GeneralPath)shapeText).quadTo(74.97941, 141.72665, 74.97941, 143.59201);
((GeneralPath)shapeText).quadTo(74.97941, 145.45409, 74.32472, 146.43446);
((GeneralPath)shapeText).quadTo(73.67004, 147.41486, 72.43304, 147.41486);
((GeneralPath)shapeText).quadTo(71.19276, 147.41486, 70.53807, 146.43446);
((GeneralPath)shapeText).quadTo(69.88667, 145.45409, 69.88667, 143.59201);
((GeneralPath)shapeText).quadTo(69.88667, 141.72665, 70.53807, 140.74956);
((GeneralPath)shapeText).quadTo(71.19276, 139.76917, 72.43304, 139.76917);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(76.76088, 147.11548);
((GeneralPath)shapeText).lineTo(76.76088, 146.20746);
((GeneralPath)shapeText).quadTo(77.135925, 146.38512, 77.52084, 146.48053);
((GeneralPath)shapeText).quadTo(77.90576, 146.57265, 78.27423, 146.57265);
((GeneralPath)shapeText).quadTo(79.26119, 146.57265, 79.78099, 145.91138);
((GeneralPath)shapeText).quadTo(80.304085, 145.24683, 80.376465, 143.89468);
((GeneralPath)shapeText).quadTo(80.09024, 144.31908, 79.6494, 144.54608);
((GeneralPath)shapeText).quadTo(79.211845, 144.77307, 78.67889, 144.77307);
((GeneralPath)shapeText).quadTo(77.57349, 144.77307, 76.928665, 144.10522);
((GeneralPath)shapeText).quadTo(76.28714, 143.4341, 76.28714, 142.27606);
((GeneralPath)shapeText).quadTo(76.28714, 141.14105, 76.958275, 140.45676);
((GeneralPath)shapeText).quadTo(77.62941, 139.76917, 78.74468, 139.76917);
((GeneralPath)shapeText).quadTo(80.02116, 139.76917, 80.69558, 140.74956);
((GeneralPath)shapeText).quadTo(81.37, 141.72665, 81.37, 143.59201);
((GeneralPath)shapeText).quadTo(81.37, 145.33565, 80.540955, 146.37524);
((GeneralPath)shapeText).quadTo(79.715195, 147.41486, 78.32029, 147.41486);
((GeneralPath)shapeText).quadTo(77.94524, 147.41486, 77.560326, 147.33919);
((GeneralPath)shapeText).quadTo(77.17541, 147.26352, 76.76088, 147.11548);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(78.74468, 143.99338);
((GeneralPath)shapeText).quadTo(79.41582, 143.99338, 79.80731, 143.53609);
((GeneralPath)shapeText).quadTo(80.19881, 143.0755, 80.19881, 142.27606);
((GeneralPath)shapeText).quadTo(80.19881, 141.4799, 79.80731, 141.01932);
((GeneralPath)shapeText).quadTo(79.41582, 140.55875, 78.74468, 140.55875);
((GeneralPath)shapeText).quadTo(78.07355, 140.55875, 77.67876, 141.01932);
((GeneralPath)shapeText).quadTo(77.28726, 141.4799, 77.28726, 142.27606);
((GeneralPath)shapeText).quadTo(77.28726, 143.0755, 77.67876, 143.53609);
((GeneralPath)shapeText).quadTo(78.07355, 143.99338, 78.74468, 143.99338);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(85.29319, 140.55875);
((GeneralPath)shapeText).quadTo(84.52336, 140.55875, 84.135155, 141.31541);
((GeneralPath)shapeText).quadTo(83.74695, 142.07208, 83.74695, 143.59201);
((GeneralPath)shapeText).quadTo(83.74695, 145.10864, 84.135155, 145.86531);
((GeneralPath)shapeText).quadTo(84.52336, 146.622, 85.29319, 146.622);
((GeneralPath)shapeText).quadTo(86.066315, 146.622, 86.45452, 145.86531);
((GeneralPath)shapeText).quadTo(86.84273, 145.10864, 86.84273, 143.59201);
((GeneralPath)shapeText).quadTo(86.84273, 142.07208, 86.45452, 141.31541);
((GeneralPath)shapeText).quadTo(86.066315, 140.55875, 85.29319, 140.55875);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(85.29319, 139.76917);
((GeneralPath)shapeText).quadTo(86.53019, 139.76917, 87.184875, 140.74956);
((GeneralPath)shapeText).quadTo(87.83956, 141.72665, 87.83956, 143.59201);
((GeneralPath)shapeText).quadTo(87.83956, 145.45409, 87.184875, 146.43446);
((GeneralPath)shapeText).quadTo(86.53019, 147.41486, 85.29319, 147.41486);
((GeneralPath)shapeText).quadTo(84.05291, 147.41486, 83.398224, 146.43446);
((GeneralPath)shapeText).quadTo(82.746826, 145.45409, 82.746826, 143.59201);
((GeneralPath)shapeText).quadTo(82.746826, 141.72665, 83.398224, 140.74956);
((GeneralPath)shapeText).quadTo(84.05291, 139.76917, 85.29319, 139.76917);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(89.00253, 144.09537);
((GeneralPath)shapeText).lineTo(91.66405, 144.09537);
((GeneralPath)shapeText).lineTo(91.66405, 144.90468);
((GeneralPath)shapeText).lineTo(89.00253, 144.90468);
((GeneralPath)shapeText).lineTo(89.00253, 144.09537);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(95.370094, 140.55875);
((GeneralPath)shapeText).quadTo(94.600266, 140.55875, 94.21206, 141.31541);
((GeneralPath)shapeText).quadTo(93.82385, 142.07208, 93.82385, 143.59201);
((GeneralPath)shapeText).quadTo(93.82385, 145.10864, 94.21206, 145.86531);
((GeneralPath)shapeText).quadTo(94.600266, 146.622, 95.370094, 146.622);
((GeneralPath)shapeText).quadTo(96.14322, 146.622, 96.531425, 145.86531);
((GeneralPath)shapeText).quadTo(96.91963, 145.10864, 96.91963, 143.59201);
((GeneralPath)shapeText).quadTo(96.91963, 142.07208, 96.531425, 141.31541);
((GeneralPath)shapeText).quadTo(96.14322, 140.55875, 95.370094, 140.55875);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(95.370094, 139.76917);
((GeneralPath)shapeText).quadTo(96.60709, 139.76917, 97.26178, 140.74956);
((GeneralPath)shapeText).quadTo(97.916466, 141.72665, 97.916466, 143.59201);
((GeneralPath)shapeText).quadTo(97.916466, 145.45409, 97.26178, 146.43446);
((GeneralPath)shapeText).quadTo(96.60709, 147.41486, 95.370094, 147.41486);
((GeneralPath)shapeText).quadTo(94.129814, 147.41486, 93.47513, 146.43446);
((GeneralPath)shapeText).quadTo(92.82373, 145.45409, 92.82373, 143.59201);
((GeneralPath)shapeText).quadTo(92.82373, 141.72665, 93.47513, 140.74956);
((GeneralPath)shapeText).quadTo(94.129814, 139.76917, 95.370094, 139.76917);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(101.80016, 140.55875);
((GeneralPath)shapeText).quadTo(101.030334, 140.55875, 100.64213, 141.31541);
((GeneralPath)shapeText).quadTo(100.25392, 142.07208, 100.25392, 143.59201);
((GeneralPath)shapeText).quadTo(100.25392, 145.10864, 100.64213, 145.86531);
((GeneralPath)shapeText).quadTo(101.030334, 146.622, 101.80016, 146.622);
((GeneralPath)shapeText).quadTo(102.57329, 146.622, 102.961494, 145.86531);
((GeneralPath)shapeText).quadTo(103.3497, 145.10864, 103.3497, 143.59201);
((GeneralPath)shapeText).quadTo(103.3497, 142.07208, 102.961494, 141.31541);
((GeneralPath)shapeText).quadTo(102.57329, 140.55875, 101.80016, 140.55875);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(101.80016, 139.76917);
((GeneralPath)shapeText).quadTo(103.03716, 139.76917, 103.69185, 140.74956);
((GeneralPath)shapeText).quadTo(104.346535, 141.72665, 104.346535, 143.59201);
((GeneralPath)shapeText).quadTo(104.346535, 145.45409, 103.69185, 146.43446);
((GeneralPath)shapeText).quadTo(103.03716, 147.41486, 101.80016, 147.41486);
((GeneralPath)shapeText).quadTo(100.55988, 147.41486, 99.9052, 146.43446);
((GeneralPath)shapeText).quadTo(99.2538, 145.45409, 99.2538, 143.59201);
((GeneralPath)shapeText).quadTo(99.2538, 141.72665, 99.9052, 140.74956);
((GeneralPath)shapeText).quadTo(100.55988, 139.76917, 101.80016, 139.76917);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(108.23023, 140.55875);
((GeneralPath)shapeText).quadTo(107.4604, 140.55875, 107.0722, 141.31541);
((GeneralPath)shapeText).quadTo(106.68399, 142.07208, 106.68399, 143.59201);
((GeneralPath)shapeText).quadTo(106.68399, 145.10864, 107.0722, 145.86531);
((GeneralPath)shapeText).quadTo(107.4604, 146.622, 108.23023, 146.622);
((GeneralPath)shapeText).quadTo(109.00336, 146.622, 109.39156, 145.86531);
((GeneralPath)shapeText).quadTo(109.77977, 145.10864, 109.77977, 143.59201);
((GeneralPath)shapeText).quadTo(109.77977, 142.07208, 109.39156, 141.31541);
((GeneralPath)shapeText).quadTo(109.00336, 140.55875, 108.23023, 140.55875);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(108.23023, 139.76917);
((GeneralPath)shapeText).quadTo(109.46723, 139.76917, 110.12192, 140.74956);
((GeneralPath)shapeText).quadTo(110.7766, 141.72665, 110.7766, 143.59201);
((GeneralPath)shapeText).quadTo(110.7766, 145.45409, 110.12192, 146.43446);
((GeneralPath)shapeText).quadTo(109.46723, 147.41486, 108.23023, 147.41486);
((GeneralPath)shapeText).quadTo(106.98995, 147.41486, 106.335266, 146.43446);
((GeneralPath)shapeText).quadTo(105.68387, 145.45409, 105.68387, 143.59201);
((GeneralPath)shapeText).quadTo(105.68387, 141.72665, 106.335266, 140.74956);
((GeneralPath)shapeText).quadTo(106.98995, 139.76917, 108.23023, 139.76917);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(112.558075, 147.11548);
((GeneralPath)shapeText).lineTo(112.558075, 146.20746);
((GeneralPath)shapeText).quadTo(112.93312, 146.38512, 113.31804, 146.48053);
((GeneralPath)shapeText).quadTo(113.70296, 146.57265, 114.07143, 146.57265);
((GeneralPath)shapeText).quadTo(115.05839, 146.57265, 115.578186, 145.91138);
((GeneralPath)shapeText).quadTo(116.10128, 145.24683, 116.17366, 143.89468);
((GeneralPath)shapeText).quadTo(115.887436, 144.31908, 115.446594, 144.54608);
((GeneralPath)shapeText).quadTo(115.00904, 144.77307, 114.47608, 144.77307);
((GeneralPath)shapeText).quadTo(113.37068, 144.77307, 112.72586, 144.10522);
((GeneralPath)shapeText).quadTo(112.084335, 143.4341, 112.084335, 142.27606);
((GeneralPath)shapeText).quadTo(112.084335, 141.14105, 112.75547, 140.45676);
((GeneralPath)shapeText).quadTo(113.426605, 139.76917, 114.54188, 139.76917);
((GeneralPath)shapeText).quadTo(115.81835, 139.76917, 116.492775, 140.74956);
((GeneralPath)shapeText).quadTo(117.1672, 141.72665, 117.1672, 143.59201);
((GeneralPath)shapeText).quadTo(117.1672, 145.33565, 116.33815, 146.37524);
((GeneralPath)shapeText).quadTo(115.51239, 147.41486, 114.117485, 147.41486);
((GeneralPath)shapeText).quadTo(113.74243, 147.41486, 113.35752, 147.33919);
((GeneralPath)shapeText).quadTo(112.9726, 147.26352, 112.558075, 147.11548);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(114.54188, 143.99338);
((GeneralPath)shapeText).quadTo(115.21301, 143.99338, 115.60451, 143.53609);
((GeneralPath)shapeText).quadTo(115.996, 143.0755, 115.996, 142.27606);
((GeneralPath)shapeText).quadTo(115.996, 141.4799, 115.60451, 141.01932);
((GeneralPath)shapeText).quadTo(115.21301, 140.55875, 114.54188, 140.55875);
((GeneralPath)shapeText).quadTo(113.87074, 140.55875, 113.47595, 141.01932);
((GeneralPath)shapeText).quadTo(113.08446, 141.4799, 113.08446, 142.27606);
((GeneralPath)shapeText).quadTo(113.08446, 143.0755, 113.47595, 143.53609);
((GeneralPath)shapeText).quadTo(113.87074, 143.99338, 114.54188, 143.99338);
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
		return 110.18728637695312;
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

