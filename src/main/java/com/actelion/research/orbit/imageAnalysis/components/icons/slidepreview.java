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
public class slidepreview implements ResizableIcon {
    

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
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 104.2738037109375f, -312.0760803222656f));
// _0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0 = g.getTransform();
g.transform(new AffineTransform(0.7385876178741455f, 0.0f, 0.0f, 1.0f, -100.57259368896484f, 311.8841857910156f));
// _0_0_0
g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));
AffineTransform defaultTransform__0_0_0_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0
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
g.setTransform(defaultTransform__0_0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(13.556394, 11.359958);
((GeneralPath)shape).lineTo(13.556394, 49.626534);
((GeneralPath)shape).lineTo(13.556394, 154.22183);
((GeneralPath)shape).lineTo(13.556394, 192.4884);
((GeneralPath)shape).lineTo(109.5564, 192.4884);
((GeneralPath)shape).lineTo(109.5564, 109.81665);
((GeneralPath)shape).lineTo(109.5564, 94.031685);
((GeneralPath)shape).lineTo(109.5564, 11.35994);
((GeneralPath)shape).lineTo(13.556404, 11.35994);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new LinearGradientPaint(new Point2D.Double(15.5, 98.5642318725586), new Point2D.Double(112.5, 98.5642318725586), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -2.443605899810791f, 3.3599579334259033f));
stroke = new BasicStroke(1.0f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(13.556394, 11.359958);
((GeneralPath)shape).lineTo(13.556394, 49.626534);
((GeneralPath)shape).lineTo(13.556394, 154.22183);
((GeneralPath)shape).lineTo(13.556394, 192.4884);
((GeneralPath)shape).lineTo(109.5564, 192.4884);
((GeneralPath)shape).lineTo(109.5564, 109.81665);
((GeneralPath)shape).lineTo(109.5564, 94.031685);
((GeneralPath)shape).lineTo(109.5564, 11.35994);
((GeneralPath)shape).lineTo(13.556404, 11.35994);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_0_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(15.702982, 10.452039);
((GeneralPath)shape).lineTo(15.702982, 49.077156);
((GeneralPath)shape).lineTo(15.702982, 154.6525);
((GeneralPath)shape).lineTo(15.702982, 193.27762);
((GeneralPath)shape).lineTo(112.60247, 193.27762);
((GeneralPath)shape).lineTo(112.60247, 109.83127);
((GeneralPath)shape).lineTo(112.60247, 93.8984);
((GeneralPath)shape).lineTo(112.60247, 10.452049);
((GeneralPath)shape).lineTo(15.70298, 10.452049);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(103.09768676757812, 56.26235580444336), 48.9f, new Point2D.Double(103.09768676757812, 56.26235580444336), new float[] {0.0f,1.0f}, new Color[] {new Color(210, 242, 255, 255),new Color(243, 243, 243, 201)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-1.228892207145691f, 2.168907403945923f, -1.6426172256469727f, -0.930698812007904f, 323.03851318359375f, -153.85885620117188f));
g.setPaint(paint);
g.fill(shape);
paint = new RadialGradientPaint(new Point2D.Double(18.182392120361328, 147.37173461914062), 48.5f, new Point2D.Double(18.182392120361328, 147.37173461914062), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.892987608909607f, -0.012713929638266563f, 0.012728540226817131f, 1.8951630592346191f, -18.080732345581055f, -89.32833099365234f));
stroke = new BasicStroke(1.8168653f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(15.702982, 10.452039);
((GeneralPath)shape).lineTo(15.702982, 49.077156);
((GeneralPath)shape).lineTo(15.702982, 154.6525);
((GeneralPath)shape).lineTo(15.702982, 193.27762);
((GeneralPath)shape).lineTo(112.60247, 193.27762);
((GeneralPath)shape).lineTo(112.60247, 109.83127);
((GeneralPath)shape).lineTo(112.60247, 93.8984);
((GeneralPath)shape).lineTo(112.60247, 10.452049);
((GeneralPath)shape).lineTo(15.70298, 10.452049);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_0_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_3
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_3_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_3_0
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
g.setTransform(defaultTransform__0_0_0_3_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_3_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_3_1
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
g.setTransform(defaultTransform__0_0_0_3_1);
g.setTransform(defaultTransform__0_0_0_3);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_0_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_4
shape = new Rectangle2D.Double(18.937944412231445, 136.8580780029297, 88.88616180419922, 51.01026916503906);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new LinearGradientPaint(new Point2D.Double(57.019283294677734, 132.4290313720703), new Point2D.Double(55.3865852355957, 189.85377502441406), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(0.2f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(18.937944412231445, 136.8580780029297, 88.88616180419922, 51.01026916503906);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_0_4);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_5 = g.getTransform();
g.transform(new AffineTransform(1.2418439388275146f, 0.0f, 0.0f, 1.0f, -5.451368808746338f, 0.0f));
// _0_0_0_5
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_5_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_5_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_5_0_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 0.38382488489151f, 221.75723266601562f, 165.20057678222656f));
// _0_0_0_5_0_0
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_0_5_0_0_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_5_0_0_0
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
g.setTransform(defaultTransform__0_0_0_5_0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_0_5_0_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_5_0_0_1
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
g.setTransform(defaultTransform__0_0_0_5_0_0_1);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_0_5_0_0_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_5_0_0_2
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
g.setTransform(defaultTransform__0_0_0_5_0_0_2);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_0_5_0_0_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_5_0_0_3
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
g.setTransform(defaultTransform__0_0_0_5_0_0_3);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_0_5_0_0_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_5_0_0_4
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
g.setTransform(defaultTransform__0_0_0_5_0_0_4);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_0_5_0_0_5 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_5_0_0_5
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
g.setTransform(defaultTransform__0_0_0_5_0_0_5);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_0_5_0_0_6 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_5_0_0_6
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
g.setTransform(defaultTransform__0_0_0_5_0_0_6);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_0_5_0_0_7 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_5_0_0_7
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
g.setTransform(defaultTransform__0_0_0_5_0_0_7);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_0_5_0_0_8 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_5_0_0_8
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
g.setTransform(defaultTransform__0_0_0_5_0_0_8);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_0_5_0_0_9 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_5_0_0_9
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
g.setTransform(defaultTransform__0_0_0_5_0_0_9);
g.setTransform(defaultTransform__0_0_0_5_0_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_5_0_1 = g.getTransform();
g.transform(new AffineTransform(-1.0f, 0.0f, 0.0f, 0.38382488489151f, -112.37364196777344f, 165.20057678222656f));
// _0_0_0_5_0_1
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_0_5_0_1_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_5_0_1_0
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
g.setTransform(defaultTransform__0_0_0_5_0_1_0);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_0_5_0_1_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_5_0_1_1
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
g.setTransform(defaultTransform__0_0_0_5_0_1_1);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_0_5_0_1_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_5_0_1_2
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
g.setTransform(defaultTransform__0_0_0_5_0_1_2);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_0_5_0_1_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_5_0_1_3
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
g.setTransform(defaultTransform__0_0_0_5_0_1_3);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_0_5_0_1_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_5_0_1_4
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
g.setTransform(defaultTransform__0_0_0_5_0_1_4);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_0_5_0_1_5 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_5_0_1_5
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
g.setTransform(defaultTransform__0_0_0_5_0_1_5);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_0_5_0_1_6 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_5_0_1_6
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
g.setTransform(defaultTransform__0_0_0_5_0_1_6);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_0_5_0_1_7 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_5_0_1_7
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
g.setTransform(defaultTransform__0_0_0_5_0_1_7);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_0_5_0_1_8 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_5_0_1_8
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
g.setTransform(defaultTransform__0_0_0_5_0_1_8);
g.setComposite(AlphaComposite.getInstance(3, 0.7876106f * origAlpha));
AffineTransform defaultTransform__0_0_0_5_0_1_9 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_5_0_1_9
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
g.setTransform(defaultTransform__0_0_0_5_0_1_9);
g.setTransform(defaultTransform__0_0_0_5_0_1);
g.setTransform(defaultTransform__0_0_0_5_0);
g.setTransform(defaultTransform__0_0_0_5);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_6 = g.getTransform();
g.transform(new AffineTransform(0.9343072772026062f, 0.0f, 0.0f, 1.0703116655349731f, 0.0f, 0.0f));
{
    Graphics2D gText = ((Graphics2D)g.create());
            Shape shapeText = null;
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
paint = new Color(0, 0, 0, 255);
gText.setPaint(paint);
shapeText = new GeneralPath();
((GeneralPath)shapeText).moveTo(20.139038, 136.53703);
((GeneralPath)shapeText).lineTo(26.16824, 136.53703);
((GeneralPath)shapeText).lineTo(26.16824, 137.6228);
((GeneralPath)shapeText).lineTo(21.429186, 137.6228);
((GeneralPath)shapeText).lineTo(21.429186, 140.4458);
((GeneralPath)shapeText).lineTo(25.968119, 140.4458);
((GeneralPath)shapeText).lineTo(25.968119, 141.53156);
((GeneralPath)shapeText).lineTo(21.429186, 141.53156);
((GeneralPath)shapeText).lineTo(21.429186, 144.98898);
((GeneralPath)shapeText).lineTo(26.283203, 144.98898);
((GeneralPath)shapeText).lineTo(26.283203, 146.07475);
((GeneralPath)shapeText).lineTo(20.139038, 146.07475);
((GeneralPath)shapeText).lineTo(20.139038, 136.53703);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(28.403643, 136.53703);
((GeneralPath)shapeText).lineTo(29.69379, 136.53703);
((GeneralPath)shapeText).lineTo(29.69379, 144.98898);
((GeneralPath)shapeText).lineTo(34.33491, 144.98898);
((GeneralPath)shapeText).lineTo(34.33491, 146.07475);
((GeneralPath)shapeText).lineTo(28.403643, 146.07475);
((GeneralPath)shapeText).lineTo(28.403643, 136.53703);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(36.9812, 141.51878);
((GeneralPath)shapeText).lineTo(36.9812, 145.01453);
((GeneralPath)shapeText).lineTo(39.05055, 145.01453);
((GeneralPath)shapeText).quadTo(40.089478, 145.01453, 40.59191, 144.58449);
((GeneralPath)shapeText).quadTo(41.094345, 144.15018, 41.094345, 143.26453);
((GeneralPath)shapeText).quadTo(41.094345, 142.37038, 40.59191, 141.94458);
((GeneralPath)shapeText).quadTo(40.089478, 141.51878, 39.05055, 141.51878);
((GeneralPath)shapeText).lineTo(36.9812, 141.51878);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(36.9812, 137.59726);
((GeneralPath)shapeText).lineTo(36.9812, 140.47134);
((GeneralPath)shapeText).lineTo(38.88875, 140.47134);
((GeneralPath)shapeText).quadTo(39.834003, 140.47134, 40.298115, 140.11794);
((GeneralPath)shapeText).quadTo(40.762226, 139.76453, 40.762226, 139.03642);
((GeneralPath)shapeText).quadTo(40.762226, 138.31258, 40.298115, 137.95491);
((GeneralPath)shapeText).quadTo(39.834003, 137.59726, 38.88875, 137.59726);
((GeneralPath)shapeText).lineTo(36.9812, 137.59726);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(35.691055, 136.53703);
((GeneralPath)shapeText).lineTo(38.98668, 136.53703);
((GeneralPath)shapeText).quadTo(40.459915, 136.53703, 41.256145, 137.15018);
((GeneralPath)shapeText).quadTo(42.056633, 137.7633, 42.056633, 138.89592);
((GeneralPath)shapeText).quadTo(42.056633, 139.76878, 41.647873, 140.28825);
((GeneralPath)shapeText).quadTo(41.239113, 140.80347, 40.447144, 140.9312);
((GeneralPath)shapeText).quadTo(41.400913, 141.13557, 41.924637, 141.78703);
((GeneralPath)shapeText).quadTo(42.452618, 142.43423, 42.452618, 143.40504);
((GeneralPath)shapeText).quadTo(42.452618, 144.68242, 41.584003, 145.3807);
((GeneralPath)shapeText).quadTo(40.71539, 146.07475, 39.114414, 146.07475);
((GeneralPath)shapeText).lineTo(35.691055, 146.07475);
((GeneralPath)shapeText).lineTo(35.691055, 136.53703);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(47.538692, 137.38861);
((GeneralPath)shapeText).quadTo(46.542343, 137.38861, 46.03991, 138.36794);
((GeneralPath)shapeText).quadTo(45.537476, 139.34726, 45.537476, 141.3144);
((GeneralPath)shapeText).quadTo(45.537476, 143.2773, 46.03991, 144.25662);
((GeneralPath)shapeText).quadTo(46.542343, 145.23595, 47.538692, 145.23595);
((GeneralPath)shapeText).quadTo(48.539303, 145.23595, 49.041737, 144.25662);
((GeneralPath)shapeText).quadTo(49.54417, 143.2773, 49.54417, 141.3144);
((GeneralPath)shapeText).quadTo(49.54417, 139.34726, 49.041737, 138.36794);
((GeneralPath)shapeText).quadTo(48.539303, 137.38861, 47.538692, 137.38861);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(47.538692, 136.36671);
((GeneralPath)shapeText).quadTo(49.139668, 136.36671, 49.98699, 137.63557);
((GeneralPath)shapeText).quadTo(50.834316, 138.90018, 50.834316, 141.3144);
((GeneralPath)shapeText).quadTo(50.834316, 143.72438, 49.98699, 144.99324);
((GeneralPath)shapeText).quadTo(49.139668, 146.2621, 47.538692, 146.2621);
((GeneralPath)shapeText).quadTo(45.93346, 146.2621, 45.086136, 144.99324);
((GeneralPath)shapeText).quadTo(44.243073, 143.72438, 44.243073, 141.3144);
((GeneralPath)shapeText).quadTo(44.243073, 138.90018, 45.086136, 137.63557);
((GeneralPath)shapeText).quadTo(45.93346, 136.36671, 47.538692, 136.36671);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(55.86078, 137.38861);
((GeneralPath)shapeText).quadTo(54.86443, 137.38861, 54.361996, 138.36794);
((GeneralPath)shapeText).quadTo(53.859562, 139.34726, 53.859562, 141.3144);
((GeneralPath)shapeText).quadTo(53.859562, 143.2773, 54.361996, 144.25662);
((GeneralPath)shapeText).quadTo(54.86443, 145.23595, 55.86078, 145.23595);
((GeneralPath)shapeText).quadTo(56.86139, 145.23595, 57.363823, 144.25662);
((GeneralPath)shapeText).quadTo(57.866257, 143.2773, 57.866257, 141.3144);
((GeneralPath)shapeText).quadTo(57.866257, 139.34726, 57.363823, 138.36794);
((GeneralPath)shapeText).quadTo(56.86139, 137.38861, 55.86078, 137.38861);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(55.86078, 136.36671);
((GeneralPath)shapeText).quadTo(57.461754, 136.36671, 58.30908, 137.63557);
((GeneralPath)shapeText).quadTo(59.156403, 138.90018, 59.156403, 141.3144);
((GeneralPath)shapeText).quadTo(59.156403, 143.72438, 58.30908, 144.99324);
((GeneralPath)shapeText).quadTo(57.461754, 146.2621, 55.86078, 146.2621);
((GeneralPath)shapeText).quadTo(54.255547, 146.2621, 53.408222, 144.99324);
((GeneralPath)shapeText).quadTo(52.56516, 143.72438, 52.56516, 141.3144);
((GeneralPath)shapeText).quadTo(52.56516, 138.90018, 53.408222, 137.63557);
((GeneralPath)shapeText).quadTo(54.255547, 136.36671, 55.86078, 136.36671);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(61.462063, 145.87463);
((GeneralPath)shapeText).lineTo(61.462063, 144.69945);
((GeneralPath)shapeText).quadTo(61.947464, 144.92938, 62.44564, 145.05286);
((GeneralPath)shapeText).quadTo(62.943813, 145.17207, 63.4207, 145.17207);
((GeneralPath)shapeText).quadTo(64.698074, 145.17207, 65.37083, 144.31624);
((GeneralPath)shapeText).quadTo(66.04783, 143.45613, 66.1415, 141.70613);
((GeneralPath)shapeText).quadTo(65.771065, 142.2554, 65.20051, 142.54921);
((GeneralPath)shapeText).quadTo(64.63421, 142.843, 63.944424, 142.843);
((GeneralPath)shapeText).quadTo(62.513767, 142.843, 61.679214, 141.97864);
((GeneralPath)shapeText).quadTo(60.848923, 141.11003, 60.848923, 139.61125);
((GeneralPath)shapeText).quadTo(60.848923, 138.14227, 61.717537, 137.25662);
((GeneralPath)shapeText).quadTo(62.58615, 136.36671, 64.02958, 136.36671);
((GeneralPath)shapeText).quadTo(65.68165, 136.36671, 66.55452, 137.63557);
((GeneralPath)shapeText).quadTo(67.42739, 138.90018, 67.42739, 141.3144);
((GeneralPath)shapeText).quadTo(67.42739, 143.5711, 66.3544, 144.9166);
((GeneralPath)shapeText).quadTo(65.28567, 146.2621, 63.480312, 146.2621);
((GeneralPath)shapeText).quadTo(62.99491, 146.2621, 62.496735, 146.16417);
((GeneralPath)shapeText).quadTo(61.998558, 146.06624, 61.462063, 145.87463);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(64.02958, 141.83388);
((GeneralPath)shapeText).quadTo(64.89819, 141.83388, 65.404884, 141.24202);
((GeneralPath)shapeText).quadTo(65.911575, 140.64592, 65.911575, 139.61125);
((GeneralPath)shapeText).quadTo(65.911575, 138.58083, 65.404884, 137.98473);
((GeneralPath)shapeText).quadTo(64.89819, 137.38861, 64.02958, 137.38861);
((GeneralPath)shapeText).quadTo(63.16097, 137.38861, 62.65002, 137.98473);
((GeneralPath)shapeText).quadTo(62.143326, 138.58083, 62.143326, 139.61125);
((GeneralPath)shapeText).quadTo(62.143326, 140.64592, 62.65002, 141.24202);
((GeneralPath)shapeText).quadTo(63.16097, 141.83388, 64.02958, 141.83388);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(72.50495, 137.38861);
((GeneralPath)shapeText).quadTo(71.5086, 137.38861, 71.006165, 138.36794);
((GeneralPath)shapeText).quadTo(70.50373, 139.34726, 70.50373, 141.3144);
((GeneralPath)shapeText).quadTo(70.50373, 143.2773, 71.006165, 144.25662);
((GeneralPath)shapeText).quadTo(71.5086, 145.23595, 72.50495, 145.23595);
((GeneralPath)shapeText).quadTo(73.50556, 145.23595, 74.00799, 144.25662);
((GeneralPath)shapeText).quadTo(74.51042, 143.2773, 74.51042, 141.3144);
((GeneralPath)shapeText).quadTo(74.51042, 139.34726, 74.00799, 138.36794);
((GeneralPath)shapeText).quadTo(73.50556, 137.38861, 72.50495, 137.38861);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(72.50495, 136.36671);
((GeneralPath)shapeText).quadTo(74.10593, 136.36671, 74.95325, 137.63557);
((GeneralPath)shapeText).quadTo(75.800575, 138.90018, 75.800575, 141.3144);
((GeneralPath)shapeText).quadTo(75.800575, 143.72438, 74.95325, 144.99324);
((GeneralPath)shapeText).quadTo(74.10593, 146.2621, 72.50495, 146.2621);
((GeneralPath)shapeText).quadTo(70.89972, 146.2621, 70.05239, 144.99324);
((GeneralPath)shapeText).quadTo(69.20933, 143.72438, 69.20933, 141.3144);
((GeneralPath)shapeText).quadTo(69.20933, 138.90018, 70.05239, 137.63557);
((GeneralPath)shapeText).quadTo(70.89972, 136.36671, 72.50495, 136.36671);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(77.30575, 141.96587);
((GeneralPath)shapeText).lineTo(80.7504, 141.96587);
((GeneralPath)shapeText).lineTo(80.7504, 143.01332);
((GeneralPath)shapeText).lineTo(77.30575, 143.01332);
((GeneralPath)shapeText).lineTo(77.30575, 141.96587);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(85.546936, 137.38861);
((GeneralPath)shapeText).quadTo(84.55058, 137.38861, 84.04815, 138.36794);
((GeneralPath)shapeText).quadTo(83.545715, 139.34726, 83.545715, 141.3144);
((GeneralPath)shapeText).quadTo(83.545715, 143.2773, 84.04815, 144.25662);
((GeneralPath)shapeText).quadTo(84.55058, 145.23595, 85.546936, 145.23595);
((GeneralPath)shapeText).quadTo(86.54755, 145.23595, 87.04997, 144.25662);
((GeneralPath)shapeText).quadTo(87.55241, 143.2773, 87.55241, 141.3144);
((GeneralPath)shapeText).quadTo(87.55241, 139.34726, 87.04997, 138.36794);
((GeneralPath)shapeText).quadTo(86.54755, 137.38861, 85.546936, 137.38861);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(85.546936, 136.36671);
((GeneralPath)shapeText).quadTo(87.14791, 136.36671, 87.99523, 137.63557);
((GeneralPath)shapeText).quadTo(88.84256, 138.90018, 88.84256, 141.3144);
((GeneralPath)shapeText).quadTo(88.84256, 143.72438, 87.99523, 144.99324);
((GeneralPath)shapeText).quadTo(87.14791, 146.2621, 85.546936, 146.2621);
((GeneralPath)shapeText).quadTo(83.9417, 146.2621, 83.094376, 144.99324);
((GeneralPath)shapeText).quadTo(82.25131, 143.72438, 82.25131, 141.3144);
((GeneralPath)shapeText).quadTo(82.25131, 138.90018, 83.094376, 137.63557);
((GeneralPath)shapeText).quadTo(83.9417, 136.36671, 85.546936, 136.36671);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(93.869026, 137.38861);
((GeneralPath)shapeText).quadTo(92.87267, 137.38861, 92.37024, 138.36794);
((GeneralPath)shapeText).quadTo(91.867805, 139.34726, 91.867805, 141.3144);
((GeneralPath)shapeText).quadTo(91.867805, 143.2773, 92.37024, 144.25662);
((GeneralPath)shapeText).quadTo(92.87267, 145.23595, 93.869026, 145.23595);
((GeneralPath)shapeText).quadTo(94.86964, 145.23595, 95.37206, 144.25662);
((GeneralPath)shapeText).quadTo(95.8745, 143.2773, 95.8745, 141.3144);
((GeneralPath)shapeText).quadTo(95.8745, 139.34726, 95.37206, 138.36794);
((GeneralPath)shapeText).quadTo(94.86964, 137.38861, 93.869026, 137.38861);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(93.869026, 136.36671);
((GeneralPath)shapeText).quadTo(95.47, 136.36671, 96.31732, 137.63557);
((GeneralPath)shapeText).quadTo(97.16465, 138.90018, 97.16465, 141.3144);
((GeneralPath)shapeText).quadTo(97.16465, 143.72438, 96.31732, 144.99324);
((GeneralPath)shapeText).quadTo(95.47, 146.2621, 93.869026, 146.2621);
((GeneralPath)shapeText).quadTo(92.263794, 146.2621, 91.416466, 144.99324);
((GeneralPath)shapeText).quadTo(90.5734, 143.72438, 90.5734, 141.3144);
((GeneralPath)shapeText).quadTo(90.5734, 138.90018, 91.416466, 137.63557);
((GeneralPath)shapeText).quadTo(92.263794, 136.36671, 93.869026, 136.36671);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(102.19111, 137.38861);
((GeneralPath)shapeText).quadTo(101.194756, 137.38861, 100.69232, 138.36794);
((GeneralPath)shapeText).quadTo(100.18989, 139.34726, 100.18989, 141.3144);
((GeneralPath)shapeText).quadTo(100.18989, 143.2773, 100.69232, 144.25662);
((GeneralPath)shapeText).quadTo(101.194756, 145.23595, 102.19111, 145.23595);
((GeneralPath)shapeText).quadTo(103.19172, 145.23595, 103.694145, 144.25662);
((GeneralPath)shapeText).quadTo(104.19658, 143.2773, 104.19658, 141.3144);
((GeneralPath)shapeText).quadTo(104.19658, 139.34726, 103.694145, 138.36794);
((GeneralPath)shapeText).quadTo(103.19172, 137.38861, 102.19111, 137.38861);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(102.19111, 136.36671);
((GeneralPath)shapeText).quadTo(103.79208, 136.36671, 104.639404, 137.63557);
((GeneralPath)shapeText).quadTo(105.48673, 138.90018, 105.48673, 141.3144);
((GeneralPath)shapeText).quadTo(105.48673, 143.72438, 104.639404, 144.99324);
((GeneralPath)shapeText).quadTo(103.79208, 146.2621, 102.19111, 146.2621);
((GeneralPath)shapeText).quadTo(100.58588, 146.2621, 99.73855, 144.99324);
((GeneralPath)shapeText).quadTo(98.895485, 143.72438, 98.895485, 141.3144);
((GeneralPath)shapeText).quadTo(98.895485, 138.90018, 99.73855, 137.63557);
((GeneralPath)shapeText).quadTo(100.58588, 136.36671, 102.19111, 136.36671);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(107.79238, 145.87463);
((GeneralPath)shapeText).lineTo(107.79238, 144.69945);
((GeneralPath)shapeText).quadTo(108.27779, 144.92938, 108.77596, 145.05286);
((GeneralPath)shapeText).quadTo(109.27414, 145.17207, 109.75102, 145.17207);
((GeneralPath)shapeText).quadTo(111.0284, 145.17207, 111.70115, 144.31624);
((GeneralPath)shapeText).quadTo(112.37815, 143.45613, 112.471825, 141.70613);
((GeneralPath)shapeText).quadTo(112.10139, 142.2554, 111.53083, 142.54921);
((GeneralPath)shapeText).quadTo(110.96453, 142.843, 110.27475, 142.843);
((GeneralPath)shapeText).quadTo(108.844086, 142.843, 108.00954, 141.97864);
((GeneralPath)shapeText).quadTo(107.179245, 141.11003, 107.179245, 139.61125);
((GeneralPath)shapeText).quadTo(107.179245, 138.14227, 108.04786, 137.25662);
((GeneralPath)shapeText).quadTo(108.91647, 136.36671, 110.3599, 136.36671);
((GeneralPath)shapeText).quadTo(112.01197, 136.36671, 112.88484, 137.63557);
((GeneralPath)shapeText).quadTo(113.75771, 138.90018, 113.75771, 141.3144);
((GeneralPath)shapeText).quadTo(113.75771, 143.5711, 112.68472, 144.9166);
((GeneralPath)shapeText).quadTo(111.61599, 146.2621, 109.81063, 146.2621);
((GeneralPath)shapeText).quadTo(109.32523, 146.2621, 108.82706, 146.16417);
((GeneralPath)shapeText).quadTo(108.32888, 146.06624, 107.79238, 145.87463);
((GeneralPath)shapeText).closePath();
((GeneralPath)shapeText).moveTo(110.3599, 141.83388);
((GeneralPath)shapeText).quadTo(111.228516, 141.83388, 111.73521, 141.24202);
((GeneralPath)shapeText).quadTo(112.2419, 140.64592, 112.2419, 139.61125);
((GeneralPath)shapeText).quadTo(112.2419, 138.58083, 111.73521, 137.98473);
((GeneralPath)shapeText).quadTo(111.228516, 137.38861, 110.3599, 137.38861);
((GeneralPath)shapeText).quadTo(109.49129, 137.38861, 108.98034, 137.98473);
((GeneralPath)shapeText).quadTo(108.47365, 138.58083, 108.47365, 139.61125);
((GeneralPath)shapeText).quadTo(108.47365, 140.64592, 108.98034, 141.24202);
((GeneralPath)shapeText).quadTo(109.49129, 141.83388, 110.3599, 141.83388);
((GeneralPath)shapeText).closePath();
gText.fill(shapeText);
gText.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
    gText.dispose();
}
g.setTransform(defaultTransform__0_0_0_6);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_7 = g.getTransform();
g.transform(new AffineTransform(-0.7411137223243713f, 0.0f, 0.0f, 0.7040170431137085f, 97.23987579345703f, 68.87820434570312f));
// _0_0_0_7
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_7_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_7_0
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
g.setTransform(defaultTransform__0_0_0_7_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_7_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_7_1
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
g.setTransform(defaultTransform__0_0_0_7_1);
g.setTransform(defaultTransform__0_0_0_7);
g.setTransform(defaultTransform__0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 0.8317757f * origAlpha));
AffineTransform defaultTransform__0_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(-82.23669, 384.0046);
((GeneralPath)shape).curveTo(-74.02697, 387.35513, -71.22149, 388.13153, -62.839336, 388.44983);
((GeneralPath)shape).curveTo(-59.60807, 388.57254, -45.05807, 383.0772, -41.82554, 382.99432);
((GeneralPath)shape).curveTo(-41.82554, 382.99432, -35.251312, 392.28873, -22.248293, 408.0675);
((GeneralPath)shape).curveTo(-21.674574, 408.7637, -17.653267, 406.43466, -18.47026, 409.76712);
((GeneralPath)shape).curveTo(-21.5482, 422.32187, 0.39063454, 435.32227, 8.688396, 442.19666);
((GeneralPath)shape).curveTo(8.9680605, 442.0848, 9.34165, 442.05084, 9.496619, 441.79254);
((GeneralPath)shape).curveTo(11.55141, 438.3679, 9.318036, 441.31802, 9.900731, 439.56995);
((GeneralPath)shape).curveTo(10.177815, 438.7387, 11.39909, 435.96024, 11.921289, 435.12473);
((GeneralPath)shape).curveTo(14.00197, 431.79562, 18.791183, 424.41577, 18.791183, 424.41577);
((GeneralPath)shape).curveTo(18.791183, 424.41577, -2.5305882, 401.37628, -13.739792, 395.11768);
((GeneralPath)shape).curveTo(-15.983011, 393.84976, -18.270996, 390.93686, -20.40763, 389.25806);
((GeneralPath)shape).curveTo(-27.763058, 383.4788, -25.405857, 385.22177, -35.763866, 379.5594);
((GeneralPath)shape).curveTo(-37.429123, 378.64905, -39.01481, 377.5328, -40.815258, 376.93265);
((GeneralPath)shape).curveTo(-41.342155, 376.75702, -41.885265, 377.2374, -42.431705, 377.33676);
((GeneralPath)shape).curveTo(-44.353188, 377.68613, -40.827423, 375.88684, -45.46254, 377.74088);
((GeneralPath)shape).curveTo(-47.61613, 378.60233, -49.651653, 379.7344, -51.72627, 380.77173);
((GeneralPath)shape).curveTo(-52.209805, 381.0135, -52.789875, 381.422, -53.342716, 381.57996);
((GeneralPath)shape).curveTo(-60.52495, 383.63202, -73.77479, 385.41495, -82.23669, 384.00464);
((GeneralPath)shape).closePath();
paint = new Color(128, 128, 128, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(77, 77, 77, 255);
stroke = new BasicStroke(1.0f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(-82.23669, 384.0046);
((GeneralPath)shape).curveTo(-74.02697, 387.35513, -71.22149, 388.13153, -62.839336, 388.44983);
((GeneralPath)shape).curveTo(-59.60807, 388.57254, -45.05807, 383.0772, -41.82554, 382.99432);
((GeneralPath)shape).curveTo(-41.82554, 382.99432, -35.251312, 392.28873, -22.248293, 408.0675);
((GeneralPath)shape).curveTo(-21.674574, 408.7637, -17.653267, 406.43466, -18.47026, 409.76712);
((GeneralPath)shape).curveTo(-21.5482, 422.32187, 0.39063454, 435.32227, 8.688396, 442.19666);
((GeneralPath)shape).curveTo(8.9680605, 442.0848, 9.34165, 442.05084, 9.496619, 441.79254);
((GeneralPath)shape).curveTo(11.55141, 438.3679, 9.318036, 441.31802, 9.900731, 439.56995);
((GeneralPath)shape).curveTo(10.177815, 438.7387, 11.39909, 435.96024, 11.921289, 435.12473);
((GeneralPath)shape).curveTo(14.00197, 431.79562, 18.791183, 424.41577, 18.791183, 424.41577);
((GeneralPath)shape).curveTo(18.791183, 424.41577, -2.5305882, 401.37628, -13.739792, 395.11768);
((GeneralPath)shape).curveTo(-15.983011, 393.84976, -18.270996, 390.93686, -20.40763, 389.25806);
((GeneralPath)shape).curveTo(-27.763058, 383.4788, -25.405857, 385.22177, -35.763866, 379.5594);
((GeneralPath)shape).curveTo(-37.429123, 378.64905, -39.01481, 377.5328, -40.815258, 376.93265);
((GeneralPath)shape).curveTo(-41.342155, 376.75702, -41.885265, 377.2374, -42.431705, 377.33676);
((GeneralPath)shape).curveTo(-44.353188, 377.68613, -40.827423, 375.88684, -45.46254, 377.74088);
((GeneralPath)shape).curveTo(-47.61613, 378.60233, -49.651653, 379.7344, -51.72627, 380.77173);
((GeneralPath)shape).curveTo(-52.209805, 381.0135, -52.789875, 381.422, -53.342716, 381.57996);
((GeneralPath)shape).curveTo(-60.52495, 383.63202, -73.77479, 385.41495, -82.23669, 384.00464);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
g.setComposite(AlphaComposite.getInstance(3, 0.75543475f * origAlpha));
AffineTransform defaultTransform__0_0_2_0 = g.getTransform();
g.transform(new AffineTransform(0.9869871139526367f, 0.0f, 0.0f, 0.9786286950111389f, -104.57089233398438f, 310.8235778808594f));
// _0_0_2_0
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(4.964609f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(5.4074473, 40.999996);
((GeneralPath)shape).curveTo(5.4074473, 60.095108, 20.90493, 75.59259, 40.000042, 75.59259);
((GeneralPath)shape).curveTo(59.095154, 75.59259, 74.592636, 60.095108, 74.592636, 41.0);
((GeneralPath)shape).curveTo(74.592636, 21.90489, 59.09515, 6.4074097, 40.000042, 6.4074097);
((GeneralPath)shape).curveTo(20.904932, 6.4074097, 5.407448, 21.904892, 5.407448, 41.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_2_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2_1 = g.getTransform();
g.transform(new AffineTransform(-1.0311110019683838f, -0.0379299595952034f, 0.04966593161225319f, -1.3436360359191895f, -27.298179626464844f, 385.25445556640625f));
// _0_0_2_1
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2_1_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_1_0
paint = new LinearGradientPaint(new Point2D.Double(34.84189224243164, -7.142457962036133), new Point2D.Double(35.56138610839844, 11.415727615356445), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(0.414f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(9.622763, 14.273311);
((GeneralPath)shape).curveTo(16.52386, 6.082676, 26.348398, 1.7526093, 37.11637, 1.7526093);
((GeneralPath)shape).curveTo(47.884342, 1.7526093, 58.408875, 7.2008324, 64.4136, 14.980124);
((GeneralPath)shape).curveTo(64.4136, 14.980124, 64.4136, 14.980124, 64.4136, 14.980124);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_2_1_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2_1_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_1_1
paint = new LinearGradientPaint(new Point2D.Double(34.84189224243164, -7.142457962036133), new Point2D.Double(35.56138610839844, 11.415727615356445), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(0.914f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(9.622763, 14.573311);
((GeneralPath)shape).curveTo(16.52386, 6.382676, 26.348398, 2.0526092, 37.11637, 2.0526092);
((GeneralPath)shape).curveTo(47.884342, 2.0526092, 58.408875, 7.5008326, 64.4136, 15.280125);
((GeneralPath)shape).curveTo(64.4136, 15.280125, 64.4136, 15.280125, 64.4136, 15.280125);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_2_1_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2_1_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_1_2
paint = new LinearGradientPaint(new Point2D.Double(34.84189224243164, -7.142457962036133), new Point2D.Double(35.56138610839844, 11.415727615356445), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(0.614f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(9.622763, 14.473311);
((GeneralPath)shape).curveTo(16.52386, 6.282676, 26.348398, 1.9526092, 37.11637, 1.9526092);
((GeneralPath)shape).curveTo(47.884342, 1.9526092, 58.408875, 7.400832, 64.4136, 15.180124);
((GeneralPath)shape).curveTo(64.4136, 15.180124, 64.4136, 15.180124, 64.4136, 15.180124);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_2_1_2);
g.setTransform(defaultTransform__0_0_2_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(-38.2843, 385.23026);
((GeneralPath)shape).curveTo(-34.345966, 381.9329, -31.123833, 378.31146, -28.512672, 374.2585);
((GeneralPath)shape).curveTo(-7.1107903, 392.80756, 5.342369, 404.57028, 22.90857, 419.94122);
((GeneralPath)shape).curveTo(19.608889, 424.5353, 15.776389, 428.30542, 12.043579, 431.88416);
((GeneralPath)shape).curveTo(-4.7963295, 415.69806, -11.756073, 410.95172, -38.284306, 385.23026);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(91.89352416992188, 98.32296752929688), new Point2D.Double(102.63838958740234, 87.5781021118164), new float[] {0.0f,1.0f}, new Color[] {new Color(54, 54, 54, 255),new Color(179, 179, 179, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -105.0914077758789f, 309.8841857910156f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(23, 23, 23, 113);
stroke = new BasicStroke(1.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(-38.2843, 385.23026);
((GeneralPath)shape).curveTo(-34.345966, 381.9329, -31.123833, 378.31146, -28.512672, 374.2585);
((GeneralPath)shape).curveTo(-7.1107903, 392.80756, 5.342369, 404.57028, 22.90857, 419.94122);
((GeneralPath)shape).curveTo(19.608889, 424.5353, 15.776389, 428.30542, 12.043579, 431.88416);
((GeneralPath)shape).curveTo(-4.7963295, 415.69806, -11.756073, 410.95172, -38.284306, 385.23026);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_2_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_3
shape = new GeneralPath();
((GeneralPath)shape).moveTo(-30.827559, 377.5197);
((GeneralPath)shape).lineTo(-34.463352, 381.63705);
((GeneralPath)shape).curveTo(-30.663486, 387.89774, -22.198402, 397.3374, -10.278845, 408.55);
((GeneralPath)shape).curveTo(-0.52246857, 417.72772, 8.38508, 424.7371, 14.8961315, 428.9411);
((GeneralPath)shape).curveTo(17.178822, 426.89944, 18.52341, 425.34534, 20.087252, 423.5461);
((GeneralPath)shape).curveTo(15.396162, 417.18594, 7.3181915, 408.5616, -2.5162487, 399.3105);
((GeneralPath)shape).curveTo(-14.355937, 388.173, -24.484581, 380.82962, -30.827557, 377.51974);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(3.953125, 74.83329772949219), 6.93199f, new Point2D.Double(0.9055841565132141, 73.29568481445312), new float[] {0.0f,0.6637168f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 61),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.43596601486206055f, -0.5661020278930664f, 5.670909881591797f, 5.233695983886719f, -433.73150634765625f, 13.386980056762695f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2_3);
g.setComposite(AlphaComposite.getInstance(3, 0.73260075f * origAlpha));
AffineTransform defaultTransform__0_0_2_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_4
shape = new GeneralPath();
((GeneralPath)shape).moveTo(-37.65858, 384.95584);
((GeneralPath)shape).curveTo(-34.430492, 381.98334, -31.318977, 378.4455, -28.632576, 374.8213);
((GeneralPath)shape).curveTo(-11.816116, 389.1909, 5.7356186, 405.6877, 21.71447, 419.74612);
((GeneralPath)shape).curveTo(18.28639, 424.27548, 17.08702, 426.46112, 12.20214, 430.82944);
((GeneralPath)shape).curveTo(-4.4081793, 414.8627, -21.69749, 400.2854, -37.65858, 384.95584);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(49.15742874145508, 62.38064193725586), 8.333237f, new Point2D.Double(45.900455474853516, 62.298255920410156), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.6268460154533386f, -0.7038319706916809f, 7.605719089508057f, 6.891554832458496f, -534.4470825195312f, -18.266569137573242f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2_4);
g.setComposite(AlphaComposite.getInstance(3, 0.74418604f * origAlpha));
AffineTransform defaultTransform__0_0_2_5 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_5
shape = new GeneralPath();
((GeneralPath)shape).moveTo(-36.59702, 385.39948);
((GeneralPath)shape).lineTo(-28.7268, 381.386);
((GeneralPath)shape).curveTo(-11.910339, 395.7556, 2.7850418, 407.30753, 20.05102, 420.7474);
((GeneralPath)shape).curveTo(17.50045, 425.96844, 15.79105, 426.24246, 11.36409, 430.5501);
((GeneralPath)shape).curveTo(-4.985319, 414.7262, -20.63593, 400.72903, -36.59702, 385.39948);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(39.03649139404297, 69.15291595458984), 8.333237f, new Point2D.Double(36.28557586669922, 69.15291595458984), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.6268460154533386f, -0.7038319706916809f, 7.605719089508057f, 6.891554832458496f, -535.28515625f, -18.54591941833496f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2_5);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2_6 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_6
shape = new GeneralPath();
((GeneralPath)shape).moveTo(-28.665571, 374.1309);
((GeneralPath)shape).curveTo(-32.603905, 377.42825, -35.833332, 381.05786, -38.444496, 385.11084);
((GeneralPath)shape).lineTo(-38.268547, 385.27026);
((GeneralPath)shape).curveTo(-34.33021, 381.9729, -31.100784, 378.3433, -28.489622, 374.2903);
((GeneralPath)shape).lineTo(-28.665571, 374.1309);
((GeneralPath)shape).closePath();
paint = new Color(92, 92, 92, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2_6);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2_7 = g.getTransform();
g.transform(new AffineTransform(0.6836779713630676f, -0.7920539975166321f, 0.18895800411701202f, 0.16406099498271942f, -78.2137222290039f, 412.6910400390625f));
// _0_0_2_7
shape = new GeneralPath();
((GeneralPath)shape).moveTo(59.107132, 51.796238);
((GeneralPath)shape).curveTo(59.107132, 52.81994, 56.74122, 53.64981, 53.82272, 53.64981);
((GeneralPath)shape).curveTo(50.90422, 53.64981, 48.538307, 52.81994, 48.538307, 51.796238);
((GeneralPath)shape).curveTo(48.538307, 50.772537, 50.90422, 49.942665, 53.82272, 49.942665);
((GeneralPath)shape).curveTo(56.74122, 49.942665, 59.107132, 50.772537, 59.107132, 51.796238);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(53.82271957397461, 51.79623794555664), 5.284413f, new Point2D.Double(53.363365173339844, 53.70447540283203), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.3507629930973053f, 0.0f, 33.62805938720703f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2_7);
g.setComposite(AlphaComposite.getInstance(3, 0.6511628f * origAlpha));
AffineTransform defaultTransform__0_0_2_8 = g.getTransform();
g.transform(new AffineTransform(0.672249972820282f, -0.8017820119857788f, 0.1921350061893463f, 0.1603280007839203f, -27.103639602661133f, 458.2549743652344f));
// _0_0_2_8
shape = new GeneralPath();
((GeneralPath)shape).moveTo(59.107132, 51.796238);
((GeneralPath)shape).curveTo(59.107132, 52.81994, 56.74122, 53.64981, 53.82272, 53.64981);
((GeneralPath)shape).curveTo(50.90422, 53.64981, 48.538307, 52.81994, 48.538307, 51.796238);
((GeneralPath)shape).curveTo(48.538307, 50.772537, 50.90422, 49.942665, 53.82272, 49.942665);
((GeneralPath)shape).curveTo(56.74122, 49.942665, 59.107132, 50.772537, 59.107132, 51.796238);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(53.82271957397461, 51.79623794555664), 5.284413f, new Point2D.Double(53.363365173339844, 53.70447540283203), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.3507629930973053f, 0.0f, 33.62805938720703f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2_8);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2_9 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_9
shape = new GeneralPath();
((GeneralPath)shape).moveTo(-37.010513, 370.06705);
((GeneralPath)shape).curveTo(-39.16476, 372.68866, -41.147564, 374.93372, -43.091423, 376.93008);
((GeneralPath)shape).lineTo(-36.558304, 382.94043);
((GeneralPath)shape).curveTo(-34.13988, 380.69055, -31.928997, 378.5423, -30.2915, 376.19675);
((GeneralPath)shape).lineTo(-37.01051, 370.06705);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(28.07171058654785, 20.204627990722656), new Point2D.Double(40.19868850708008, 20.20462989807129), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(174, 174, 174, 255)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-0.3581880033016205f, 0.4021790027618408f, 0.39682498574256897f, 0.35956498980522156f, -33.88959884643555f, 356.59320068359375f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2_9);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2_10 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_10
shape = new GeneralPath();
((GeneralPath)shape).moveTo(-36.767323, 371.21866);
((GeneralPath)shape).curveTo(-38.921574, 373.84027, -40.773865, 375.363, -42.717728, 377.35938);
((GeneralPath)shape).lineTo(-36.558308, 382.94043);
((GeneralPath)shape).curveTo(-34.139885, 380.69055, -31.929, 378.5423, -30.291504, 376.19675);
((GeneralPath)shape).lineTo(-36.767326, 371.21866);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(67.51517486572266, 86.70606231689453), new Point2D.Double(63.40166473388672, 61.357200622558594), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0052039623260498f, 0.037066441029310226f, -0.03709647059440613f, 1.006018042564392f, -101.08016204833984f, 311.4317626953125f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2_10);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2_11 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_11
shape = new GeneralPath();
((GeneralPath)shape).moveTo(22.39697, 419.8477);
((GeneralPath)shape).curveTo(16.29105, 414.10757, 6.445571, 405.9943, -4.982708, 395.66214);
((GeneralPath)shape).curveTo(-13.81944, 387.67297, -22.22175, 380.30264, -28.65713, 375.54318);
((GeneralPath)shape).lineTo(-33.42672, 380.1455);
((GeneralPath)shape).curveTo(-28.044659, 386.07004, -19.90372, 394.40274, -11.06699, 402.3919);
((GeneralPath)shape).curveTo(0.3612814, 412.72406, 10.994041, 421.21906, 17.705801, 425.63583);
((GeneralPath)shape).lineTo(22.39697, 419.8477);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(-22.1875, 69.921875), 3.3125f, new Point2D.Double(-24.22588539123535, 69.91436767578125), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-0.8920683860778809f, 1.0389972925186157f, -21.233230590820312f, -18.230581283569336f, 1459.1827392578125f, 1698.9056396484375f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2_11);
g.setComposite(AlphaComposite.getInstance(3, 0.8f * origAlpha));
AffineTransform defaultTransform__0_0_2_12 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_12
shape = new GeneralPath();
((GeneralPath)shape).moveTo(-36.872658, 370.16544);
((GeneralPath)shape).curveTo(-37.842094, 371.45654, -38.902435, 372.69522, -40.060158, 373.85294);
((GeneralPath)shape).curveTo(-40.47283, 374.26562, -40.90709, 374.67908, -41.341408, 375.0717);
((GeneralPath)shape).curveTo(-41.36311, 375.09128, -41.38215, 375.1146, -41.403908, 375.1342);
((GeneralPath)shape).curveTo(-41.97167, 375.7515, -42.533207, 376.34216, -43.091408, 376.91544);
((GeneralPath)shape).lineTo(-40.810158, 379.04044);
((GeneralPath)shape).curveTo(-38.665886, 377.68497, -36.813198, 375.8738, -35.435158, 373.6342);
((GeneralPath)shape).curveTo(-35.143433, 373.16006, -34.888844, 372.68515, -34.653908, 372.1967);
((GeneralPath)shape).lineTo(-36.872658, 370.16544);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(56.256771087646484, 56.998897552490234), 9.725522f, new Point2D.Double(56.256771087646484, 56.998897552490234), new float[] {0.0f,0.6637168f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 61),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.9252870082855225f, -99.0914077758789f, 320.14276123046875f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2_12);
g.setComposite(AlphaComposite.getInstance(3, 0.1875f * origAlpha));
AffineTransform defaultTransform__0_0_2_13 = g.getTransform();
g.transform(new AffineTransform(0.6643393039703369f, -0.7474310994148254f, 0.7474311590194702f, 0.6643393039703369f, 0.0f, 0.0f));
// _0_0_2_13
shape = new Rectangle2D.Double(-305.6112060546875, 218.8498992919922, 1.6520304679870605, 8.381975173950195);
paint = new LinearGradientPaint(new Point2D.Double(113.91755676269531, 47.035709381103516), new Point2D.Double(108.60655975341797, 69.3776626586914), new float[] {0.0f,1.0f}, new Color[] {new Color(86, 228, 253, 175),new Color(255, 255, 255, 181)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -420.2874755859375f, 160.38697814941406f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2_13);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2_14 = g.getTransform();
g.transform(new AffineTransform(-5.327775001525879f, 0.0f, 0.0f, 7.786747932434082f, 87.0138931274414f, 392.53424072265625f));
// _0_0_2_14
paint = new LinearGradientPaint(new Point2D.Double(28.549489974975586, -10.100502967834473), new Point2D.Double(28.549489974975586, -0.8540247082710266), new float[] {0.0f,1.0f}, new Color[] {new Color(201, 202, 204, 255),new Color(172, 174, 177, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(0.62102485f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(34.93114, -5.477264);
((GeneralPath)shape).curveTo(34.93114, -3.0657718, 32.07398, -1.1108713, 28.54949, -1.1108713);
((GeneralPath)shape).curveTo(25.025002, -1.1108713, 22.16784, -3.065772, 22.16784, -5.477264);
((GeneralPath)shape).curveTo(22.16784, -7.888756, 25.025002, -9.843657, 28.54949, -9.843657);
((GeneralPath)shape).curveTo(32.07398, -9.843657, 34.93114, -7.888756, 34.93114, -5.477264);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_2_14);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2_15 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_15
paint = new RadialGradientPaint(new Point2D.Double(28.549489974975586, -5.477263927459717), 6.6921635f, new Point2D.Double(28.549489974975586, -5.477263927459717), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 0),new Color(129, 129, 129, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-5.379427909851074f, -1.0975300028803758E-6f, -5.982265975035261E-6f, 29.321460723876953f, 88.48848724365234f, 510.4855651855469f));
stroke = new BasicStroke(3.9999998f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(-99.09137, 349.8842);
((GeneralPath)shape).curveTo(-99.09137, 368.6522, -83.85937, 383.8842, -65.09137, 383.8842);
((GeneralPath)shape).curveTo(-46.32337, 383.8842, -31.09137, 368.6522, -31.09137, 349.8842);
((GeneralPath)shape).curveTo(-31.09137, 331.11618, -46.32337, 315.8842, -65.09137, 315.8842);
((GeneralPath)shape).curveTo(-83.85937, 315.8842, -99.09137, 331.11618, -99.09137, 349.8842);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_2_15);
g.setComposite(AlphaComposite.getInstance(3, 0.71f * origAlpha));
AffineTransform defaultTransform__0_0_2_16 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_16
shape = new GeneralPath();
((GeneralPath)shape).moveTo(-65.24766, 317.8842);
((GeneralPath)shape).curveTo(-65.79348, 317.87518, -66.35233, 317.89627, -66.90391, 317.91537);
((GeneralPath)shape).curveTo(-84.554214, 318.5297, -98.31232, 333.35602, -97.62266, 351.00912);
((GeneralPath)shape).curveTo(-97.39854, 356.74594, -95.671486, 362.06955, -92.84141, 366.63412);
((GeneralPath)shape).curveTo(-92.85905, 366.3605, -92.8619, 366.09717, -92.87266, 365.82162);
((GeneralPath)shape).curveTo(-93.56232, 348.16852, -79.80421, 333.3422, -62.153908, 332.72787);
((GeneralPath)shape).curveTo(-50.239502, 332.3132, -39.594955, 338.4652, -33.716408, 347.94662);
((GeneralPath)shape).curveTo(-34.793434, 331.23694, -48.599804, 318.1491, -65.24766, 317.88412);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(39.40945816040039, 9.579120635986328), 31.965544f, new Point2D.Double(33.4835319519043, 10.615250587463379), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.7625716924667358f, -105.0914077758789f, 317.5706787109375f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2_16);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2_17 = g.getTransform();
g.transform(new AffineTransform(0.0384724885225296f, 1.105376958847046f, 1.1382620334625244f, -0.04446890950202942f, -110.40129089355469f, 304.54638671875f));
// _0_0_2_17
paint = new LinearGradientPaint(new Point2D.Double(13.644913673400879, 38.367759704589844), new Point2D.Double(71.47347259521484, 38.367759704589844), new float[] {0.0f,1.0f}, new Color[] {new Color(163, 165, 168, 255),new Color(255, 255, 255, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(1.7278044f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(70.60957, 38.36776);
((GeneralPath)shape).curveTo(70.60957, 53.41439, 58.05099, 65.61209, 42.559196, 65.61209);
((GeneralPath)shape).curveTo(27.067402, 65.61209, 14.50882, 53.414387, 14.50882, 38.36776);
((GeneralPath)shape).curveTo(14.50882, 23.321129, 27.067402, 11.123426, 42.559196, 11.123426);
((GeneralPath)shape).curveTo(58.05099, 11.123426, 70.60957, 23.32113, 70.60957, 38.36776);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_2_17);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2_18 = g.getTransform();
g.transform(new AffineTransform(1.272465467453003f, 0.0f, 0.0f, 1.272465467453003f, -100.71121215820312f, 321.2789611816406f));
// _0_0_2_18
g.setComposite(AlphaComposite.getInstance(3, 0.40625f * origAlpha));
AffineTransform defaultTransform__0_0_2_18_0 = g.getTransform();
g.transform(new AffineTransform(0.9136751294136047f, 0.0f, 0.0f, 0.6306344866752625f, -393.9872741699219f, 40.72113037109375f));
// _0_0_2_18_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(483.3296, -50.078033);
((GeneralPath)shape).curveTo(483.3296, -38.99479, 473.77277, -30.01004, 461.98383, -30.01004);
((GeneralPath)shape).curveTo(450.19485, -30.01004, 440.63803, -38.99479, 440.63803, -50.078033);
((GeneralPath)shape).curveTo(440.63803, -61.16128, 450.19485, -70.14603, 461.98383, -70.14603);
((GeneralPath)shape).curveTo(473.77277, -70.14603, 483.3296, -61.161278, 483.3296, -50.078033);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(461.9837951660156, -50.078033447265625), 21.345785f, new Point2D.Double(461.5453186035156, -62.78385925292969), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.9245078563690186f, 8.883228588274505E-7f, -2.1962546270515304E-7f, 0.9889928102493286f, -427.1076965332031f, -0.5516313910484314f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2_18_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2_18_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_18_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(28.332724, -1.7688984);
((GeneralPath)shape).curveTo(14.895174, -1.7688984, 3.9821777, 9.144091, 3.9821777, 22.581644);
((GeneralPath)shape).curveTo(3.9821777, 36.019196, 14.895174, 46.910767, 28.332724, 46.910767);
((GeneralPath)shape).curveTo(41.770275, 46.910767, 52.661846, 36.019196, 52.661846, 22.581644);
((GeneralPath)shape).curveTo(52.661846, 9.144091, 41.770256, -1.768898, 28.332724, -1.768898);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(654.5357055664062, -20.356201171875), 38.29028f, new Point2D.Double(653.7733764648438, 3.2766332626342773), new float[] {0.0f,0.57963896f,0.8822989f,1.0f}, new Color[] {new Color(162, 243, 255, 79),new Color(81, 210, 244, 119),new Color(56, 139, 201, 169),new Color(31, 68, 158, 220)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.6356658935546875f, 0.0f, 0.0f, 0.6356658935546875f, -387.74407958984375f, 35.51068115234375f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2_18_1);
g.setComposite(AlphaComposite.getInstance(3, 0.390625f * origAlpha));
AffineTransform defaultTransform__0_0_2_18_2 = g.getTransform();
g.transform(new AffineTransform(0.7026383876800537f, 0.0f, 0.0f, 0.7026383876800537f, -333.2755126953125f, 26.424467086791992f));
// _0_0_2_18_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(514.84375, -41.875);
((GeneralPath)shape).curveTo(495.23627, -41.875, 479.3125, -25.95124, 479.3125, -6.34375);
((GeneralPath)shape).curveTo(479.3125, -2.9406471, 479.79214, 0.35313177, 480.6875, 3.46875);
((GeneralPath)shape).curveTo(480.00345, 0.73960924, 479.625, -2.122239, 479.625, -5.0625);
((GeneralPath)shape).curveTo(479.625, -24.377249, 495.31024, -40.0625, 514.625, -40.0625);
((GeneralPath)shape).curveTo(533.93976, -40.0625, 549.625, -24.377247, 549.625, -5.0625);
((GeneralPath)shape).curveTo(549.625, 1.5769448, 547.7782, 7.7719746, 544.5625, 13.0625);
((GeneralPath)shape).curveTo(548.2146, 7.482852, 550.34375, 0.82337, 550.34375, -6.34375);
((GeneralPath)shape).curveTo(550.34375, -25.95124, 534.45123, -41.875, 514.84375, -41.875);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(529.51708984375, -49.40803527832031), new Point2D.Double(529.1305541992188, -2.031881332397461), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2_18_2);
g.setComposite(AlphaComposite.getInstance(3, 0.5703125f * origAlpha));
AffineTransform defaultTransform__0_0_2_18_3 = g.getTransform();
g.transform(new AffineTransform(0.7026383876800537f, 0.0f, 0.0f, 0.7026383876800537f, -266.5909729003906f, 26.424467086791992f));
// _0_0_2_18_3
shape = new GeneralPath();
((GeneralPath)shape).moveTo(385.9375, -16.09375);
((GeneralPath)shape).curveTo(384.79688, -12.592159, 384.1875, -8.880613, 384.1875, -5.0);
((GeneralPath)shape).curveTo(384.1875, 14.819393, 400.27435, 30.90625, 420.09375, 30.90625);
((GeneralPath)shape).curveTo(439.91315, 30.90625, 455.96875, 14.819393, 455.96875, -5.0);
((GeneralPath)shape).curveTo(455.96875, -8.880612, 455.35938, -12.592159, 454.21875, -16.09375);
((GeneralPath)shape).curveTo(455.10294, -12.994237, 455.59375, -9.725784, 455.59375, -6.34375);
((GeneralPath)shape).curveTo(455.59375, 13.263741, 439.70123, 29.15625, 420.09375, 29.15625);
((GeneralPath)shape).curveTo(400.48627, 29.156248, 384.5625, 13.263741, 384.5625, -6.34375);
((GeneralPath)shape).curveTo(384.5625, -9.725784, 385.0533, -12.994237, 385.9375, -16.09375);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(425.90679931640625, 7.40625), new Point2D.Double(426.270263671875, -21.585128784179688), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2_18_3);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2_18_4 = g.getTransform();
g.transform(new AffineTransform(0.7026383876800537f, 0.0f, 0.0f, 0.7026383876800537f, -266.5909729003906f, 26.424467086791992f));
// _0_0_2_18_4
shape = new GeneralPath();
((GeneralPath)shape).moveTo(385.9375, -16.09375);
((GeneralPath)shape).curveTo(384.79688, -12.592159, 384.1875, -8.880613, 384.1875, -5.0);
((GeneralPath)shape).curveTo(384.1875, 14.819393, 400.27435, 29.90625, 420.09375, 29.90625);
((GeneralPath)shape).curveTo(439.91315, 29.90625, 455.96875, 14.819394, 455.96875, -5.0);
((GeneralPath)shape).curveTo(455.96875, -8.880612, 455.35938, -12.592159, 454.21875, -16.09375);
((GeneralPath)shape).curveTo(455.10294, -12.994237, 455.59375, -9.725784, 455.59375, -6.34375);
((GeneralPath)shape).curveTo(455.59375, 13.263741, 439.70123, 29.15625, 420.09375, 29.15625);
((GeneralPath)shape).curveTo(400.48627, 29.156248, 384.5625, 13.263741, 384.5625, -6.34375);
((GeneralPath)shape).curveTo(384.5625, -9.725784, 385.0533, -12.994237, 385.9375, -16.09375);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(425.19970703125, 35.690521240234375), new Point2D.Double(424.8560485839844, 12.002443313598633), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2_18_4);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2_18_5 = g.getTransform();
g.transform(new AffineTransform(0.7026383876800537f, 0.0f, 0.0f, 0.7026383876800537f, -333.2755126953125f, 26.424467086791992f));
// _0_0_2_18_5
shape = new GeneralPath();
((GeneralPath)shape).moveTo(514.84375, -40.875);
((GeneralPath)shape).curveTo(495.23627, -40.875, 479.3125, -25.95124, 479.3125, -6.34375);
((GeneralPath)shape).curveTo(479.3125, -2.9406471, 479.79214, 0.35313177, 480.6875, 3.46875);
((GeneralPath)shape).curveTo(480.00345, 0.73960924, 479.625, -2.122239, 479.625, -5.0625);
((GeneralPath)shape).curveTo(479.625, -24.377249, 495.31024, -40.0625, 514.625, -40.0625);
((GeneralPath)shape).curveTo(533.93976, -40.0625, 549.625, -24.377247, 549.625, -5.0625);
((GeneralPath)shape).curveTo(549.625, 1.5769448, 547.7782, 7.7719746, 544.5625, 13.0625);
((GeneralPath)shape).curveTo(548.2146, 7.482852, 550.34375, 0.82337, 550.34375, -6.34375);
((GeneralPath)shape).curveTo(550.34375, -25.95124, 534.45123, -40.875, 514.84375, -40.875);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(529.51708984375, -49.40803527832031), new Point2D.Double(529.6305541992188, -22.28188133239746), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2_18_5);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2_18_6 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_18_6
shape = new GeneralPath();
((GeneralPath)shape).moveTo(28.429342, -3.5254953);
((GeneralPath)shape).curveTo(14.458402, -3.5254953, 3.112383, 7.70249, 3.112402, 21.527956);
((GeneralPath)shape).curveTo(3.112402, 26.886229, 4.822624, 31.838602, 7.7234535, 35.910084);
((GeneralPath)shape).curveTo(5.030179, 31.929077, 3.4637074, 27.133469, 3.4637074, 21.967102);
((GeneralPath)shape).curveTo(3.4637074, 8.190124, 14.652351, -2.998518, 28.429342, -2.998518);
((GeneralPath)shape).curveTo(42.206295, -2.998518, 53.373024, 8.1901245, 53.37299, 21.967102);
((GeneralPath)shape).curveTo(53.37299, 27.133467, 51.80267, 31.929077, 49.113243, 35.910084);
((GeneralPath)shape).curveTo(52.009983, 31.8386, 53.724304, 26.886227, 53.724304, 21.527954);
((GeneralPath)shape).curveTo(53.72432, 7.70249, 42.400246, -3.5254953, 28.429342, -3.5254953);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(455.33935546875, -91.4619140625), new Point2D.Double(452.660888671875, -34.0517578125), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.6517223119735718f, 0.0f, 0.0f, 0.6517223119735718f, -266.5909729003906f, 35.222721099853516f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2_18_6);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2_18_7 = g.getTransform();
g.transform(new AffineTransform(0.7026383876800537f, 0.0f, 0.0f, 0.7026383876800537f, -357.7611389160156f, 26.424467086791992f));
// _0_0_2_18_7
shape = new GeneralPath();
((GeneralPath)shape).moveTo(549.125, -40.125);
((GeneralPath)shape).curveTo(530.00055, -40.125, 514.46875, -24.593172, 514.46875, -5.46875);
((GeneralPath)shape).curveTo(514.46875, 12.079336, 527.5698, 26.541828, 544.5, 28.8125);
((GeneralPath)shape).curveTo(529.9104, 26.584162, 518.71875, 13.990063, 518.71875, -1.21875);
((GeneralPath)shape).curveTo(518.71875, -18.000893, 532.3429, -31.625002, 549.125, -31.625);
((GeneralPath)shape).curveTo(565.9071, -31.625, 579.53125, -18.000893, 579.53125, -1.21875);
((GeneralPath)shape).curveTo(579.53125, 14.514505, 567.57245, 27.44413, 552.25, 29.0);
((GeneralPath)shape).curveTo(569.9163, 27.426971, 583.75, 12.606974, 583.75, -5.46875);
((GeneralPath)shape).curveTo(583.75, -24.593172, 568.2494, -40.125, 549.125, -40.125);
((GeneralPath)shape).closePath();
((GeneralPath)shape).moveTo(552.25, 29.0);
((GeneralPath)shape).curveTo(551.73926, 29.05186, 551.2054, 29.09875, 550.6875, 29.125);
((GeneralPath)shape).curveTo(551.20624, 29.10194, 551.7374, 29.04564, 552.25, 29.0);
((GeneralPath)shape).closePath();
((GeneralPath)shape).moveTo(544.5, 28.8125);
((GeneralPath)shape).curveTo(545.01154, 28.88111, 545.51294, 28.953968, 546.03125, 29.0);
((GeneralPath)shape).curveTo(545.5204, 28.94814, 545.0031, 28.88934, 544.5, 28.8125);
((GeneralPath)shape).closePath();
((GeneralPath)shape).moveTo(546.03125, 29.0);
((GeneralPath)shape).curveTo(546.5414, 29.0453, 547.04626, 29.102055, 547.5625, 29.125);
((GeneralPath)shape).curveTo(547.04456, 29.09875, 546.5421, 29.05186, 546.03125, 29.0);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(549.109375, -5.5), 34.640625f, new Point2D.Double(549.109375, 15.369064331054688), new float[] {0.0f,0.795f,1.0f}, new Color[] {new Color(22, 54, 122, 0),new Color(22, 54, 122, 0),new Color(22, 54, 122, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.9995489120483398f, 0.0f, -0.002480830065906048f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2_18_7);
g.setComposite(AlphaComposite.getInstance(3, 0.40625f * origAlpha));
AffineTransform defaultTransform__0_0_2_18_8 = g.getTransform();
g.transform(new AffineTransform(0.7373059988021851f, 0.0f, 0.0f, 0.6411355137825012f, -307.5618896484375f, 33.860286712646484f));
// _0_0_2_18_8
shape = new GeneralPath();
((GeneralPath)shape).moveTo(469.60727, -34.831043);
((GeneralPath)shape).curveTo(469.60727, -25.147263, 463.29294, -17.297005, 455.50378, -17.297005);
((GeneralPath)shape).curveTo(447.71466, -17.297005, 441.40033, -25.14726, 441.40033, -34.831043);
((GeneralPath)shape).curveTo(441.40033, -44.514824, 447.71466, -52.36508, 455.50378, -52.36508);
((GeneralPath)shape).curveTo(463.2929, -52.36508, 469.60724, -44.514824, 469.60724, -34.831043);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(455.5038146972656, -40.34979248046875), 14.103466f, new Point2D.Double(455.5038146972656, -32.88325119018555), new float[] {0.0f,1.0f}, new Color[] {new Color(86, 228, 253, 175),new Color(255, 255, 255, 181)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.486486554145813f, -8.417273988925444E-7f, 1.0406811270513572E-6f, 1.837837815284729f, -221.59640502929688f, 32.46456527709961f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2_18_8);
g.setComposite(AlphaComposite.getInstance(3, 0.58984375f * origAlpha));
AffineTransform defaultTransform__0_0_2_18_9 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_18_9
shape = new GeneralPath();
((GeneralPath)shape).moveTo(29.44629, 0.21256398);
((GeneralPath)shape).lineTo(29.648642, 4.439237);
((GeneralPath)shape).curveTo(31.324497, 4.469328, 32.957016, 4.62683, 34.52795, 4.874713);
((GeneralPath)shape).curveTo(34.201626, 3.499492, 33.87911, 2.1244318, 33.53858, 0.75050807);
((GeneralPath)shape).curveTo(32.228886, 0.45357358, 30.86117, 0.2843541, 29.44629, 0.21256398);
((GeneralPath)shape).closePath();
((GeneralPath)shape).moveTo(26.343327, 0.23818238);
((GeneralPath)shape).curveTo(24.984999, 0.34143147, 23.662796, 0.5656826, 22.4084, 0.87858707);
((GeneralPath)shape).curveTo(22.04677, 2.335656, 21.6967, 3.7993238, 21.351604, 5.2589564);
((GeneralPath)shape).curveTo(22.968073, 4.895446, 24.65706, 4.6671686, 26.41077, 4.5417023);
((GeneralPath)shape).lineTo(26.613146, 0.23818207);
((GeneralPath)shape).curveTo(26.520786, 0.24415207, 26.435284, 0.23119207, 26.343328, 0.23818207);
((GeneralPath)shape).closePath();
((GeneralPath)shape).moveTo(36.011967, 1.4677594);
((GeneralPath)shape).curveTo(36.428314, 2.779594, 36.83896, 4.0950537, 37.24864, 5.412652);
((GeneralPath)shape).curveTo(40.20459, 6.137951, 42.88738, 7.2236633, 45.14096, 8.614676);
((GeneralPath)shape).curveTo(43.389896, 5.4700694, 40.122684, 2.9145107, 36.01197, 1.4677593);
((GeneralPath)shape).closePath();
((GeneralPath)shape).moveTo(19.575256, 1.7751533);
((GeneralPath)shape).curveTo(15.17321, 3.5408685, 11.842925, 6.6214757, 10.513713, 10.305347);
((GeneralPath)shape).curveTo(12.572208, 8.597153, 15.186, 7.1941733, 18.158703, 6.1811385);
((GeneralPath)shape).curveTo(18.628277, 4.7133965, 19.097061, 3.2452433, 19.575256, 1.7751533);
((GeneralPath)shape).closePath();
((GeneralPath)shape).moveTo(29.716108, 5.848128);
((GeneralPath)shape).lineTo(30.030891, 12.021631);
((GeneralPath)shape).curveTo(32.18577, 12.077671, 34.290455, 12.271145, 36.281784, 12.636419);
((GeneralPath)shape).curveTo(35.830017, 10.538348, 35.355488, 8.435743, 34.865215, 6.3348365);
((GeneralPath)shape).curveTo(33.210037, 6.056418, 31.49036, 5.883179, 29.716108, 5.8481283);
((GeneralPath)shape).closePath();
((GeneralPath)shape).moveTo(26.343328, 5.924977);
((GeneralPath)shape).curveTo(24.480545, 6.0616336, 22.697088, 6.3659706, 20.991827, 6.770313);
((GeneralPath)shape).curveTo(20.50415, 8.869917, 20.048494, 10.968524, 19.59775, 13.0718975);
((GeneralPath)shape).curveTo(21.643957, 12.578826, 23.797682, 12.25429, 26.051016, 12.09848);
((GeneralPath)shape).lineTo(26.343328, 5.9249773);
((GeneralPath)shape).closePath();
((GeneralPath)shape).moveTo(37.720856, 6.949625);
((GeneralPath)shape).curveTo(38.386837, 9.108831, 39.05327, 11.28702, 39.699535, 13.4561405);
((GeneralPath)shape).curveTo(42.113613, 14.140901, 44.32391, 15.030043, 46.28772, 16.120226);
((GeneralPath)shape).curveTo(46.451393, 15.38192, 46.535053, 14.638714, 46.535053, 13.866);
((GeneralPath)shape).curveTo(46.535053, 12.736368, 46.340015, 11.662572, 45.995403, 10.612742);
((GeneralPath)shape).curveTo(43.685352, 9.031858, 40.877403, 7.775354, 37.72085, 6.9496255);
((GeneralPath)shape).closePath();
((GeneralPath)shape).moveTo(17.641542, 7.743727);
((GeneralPath)shape).curveTo(14.657038, 8.824017, 12.051964, 10.311432, 10.041523, 12.098481);
((GeneralPath)shape).curveTo(9.940949, 12.678941, 9.884139, 13.265328, 9.884139, 13.866);
((GeneralPath)shape).curveTo(9.884139, 14.898075, 10.042107, 15.895623, 10.333835, 16.863098);
((GeneralPath)shape).curveTo(11.905232, 15.868199, 13.669479, 14.9949045, 15.595377, 14.275862);
((GeneralPath)shape).curveTo(16.264887, 12.1018715, 16.9497, 9.92042, 17.641542, 7.743729);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(419.6562805175781, -24.165376663208008), 27.472944f, new Point2D.Double(419.6562805175781, -24.165376663208008), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.7195271849632263f, 0.0f, 0.0f, 0.6485208868980408f, -273.7445068359375f, 28.17670249938965f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2_18_9);
g.setTransform(defaultTransform__0_0_2_18);
g.setComposite(AlphaComposite.getInstance(3, 0.45652172f * origAlpha));
AffineTransform defaultTransform__0_0_2_19 = g.getTransform();
g.transform(new AffineTransform(0.6643393039703369f, -0.7474310994148254f, 0.7474311590194702f, 0.6643393039703369f, 0.0f, 0.0f));
// _0_0_2_19
shape = new Rectangle2D.Double(-304.2992858886719, 228.7867889404297, 0.7558689117431641, 66.29393005371094);
paint = new LinearGradientPaint(new Point2D.Double(113.4251708984375, 55.401756286621094), new Point2D.Double(114.41651916503906, 118.73043823242188), new float[] {0.0f,1.0f}, new Color[] {new Color(202, 236, 243, 251),new Color(14, 82, 104, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -420.0090026855469f, 170.0531768798828f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2_19);
g.setTransform(defaultTransform__0_0_2);
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
        return -1.7884979248046875;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return -8.328826904296875;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 135.0901641845703;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 220.83750915527344;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private slidepreview() {
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
       slidepreview base = new slidepreview();
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
       slidepreview base = new slidepreview();
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
        return slidepreview::new;
    }
}
