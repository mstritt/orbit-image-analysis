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
public class clearSecSegModel implements ResizableIcon {
    

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
shape = new Ellipse2D.Double(11.08454418182373, 12.250814437866211, 26.4830379486084, 25.968341827392578);
paint = new Color(0, 0, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 255, 255);
stroke = new BasicStroke(18.550095f,1,2,4.0f,null,0.0f);
shape = new Ellipse2D.Double(11.08454418182373, 12.250814437866211, 26.4830379486084, 25.968341827392578);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(9.083134, 1.5812496);
((GeneralPath)shape).curveTo(10.764031, 0.73159695, 13.092472, 1.5846325, 13.953305, 3.0881877);
((GeneralPath)shape).lineTo(18.005705, 12.266054);
((GeneralPath)shape).curveTo(18.866537, 13.769606, 18.621222, 15.526355, 17.45567, 16.20495);
((GeneralPath)shape).curveTo(16.290117, 16.883545, 14.658767, 16.219406, 13.797934, 14.715854);
((GeneralPath)shape).lineTo(8.046709, 6.63045);
((GeneralPath)shape).curveTo(7.1858764, 5.1268945, 7.435487, 2.4140947, 9.083134, 1.5812496);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(12.23343276977539, 12.3632230758667), new Point2D.Double(16.870908737182617, 17.11094093322754), new float[] {0.0f,1.0f}, new Color[] {new Color(193, 125, 16, 255),new Color(155, 101, 12, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9386315941810608f, 0.25362253189086914f, -0.2515054941177368f, 0.9465312361717224f, 5.235770225524902f, -5.886826515197754f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(143, 89, 2, 255);
stroke = new BasicStroke(0.9758228f,1,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(9.083134, 1.5812496);
((GeneralPath)shape).curveTo(10.764031, 0.73159695, 13.092472, 1.5846325, 13.953305, 3.0881877);
((GeneralPath)shape).lineTo(18.005705, 12.266054);
((GeneralPath)shape).curveTo(18.866537, 13.769606, 18.621222, 15.526355, 17.45567, 16.20495);
((GeneralPath)shape).curveTo(16.290117, 16.883545, 14.658767, 16.219406, 13.797934, 14.715854);
((GeneralPath)shape).lineTo(8.046709, 6.63045);
((GeneralPath)shape).curveTo(7.1858764, 5.1268945, 7.435487, 2.4140947, 9.083134, 1.5812496);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_1);
g.setComposite(AlphaComposite.getInstance(3, 0.4230769f * origAlpha));
AffineTransform defaultTransform__0_0_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
paint = new LinearGradientPaint(new Point2D.Double(9.56215763092041, 6.952558994293213), new Point2D.Double(14.766724586486816, 14.200403213500977), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9717427492141724f, 0.0f, 0.0f, 0.9676482081413269f, 2.362257242202759f, -0.13924680650234222f));
stroke = new BasicStroke(0.9752113f,1,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(9.598116, 2.508152);
((GeneralPath)shape).curveTo(10.979889, 1.7477548, 12.339116, 2.3216467, 13.188996, 3.8042076);
((GeneralPath)shape).lineTo(17.511442, 13.564609);
((GeneralPath)shape).lineTo(15.148629, 14.938536);
((GeneralPath)shape).lineTo(9.029942, 6.4035535);
((GeneralPath)shape).curveTo(8.180062, 4.920993, 8.178455, 3.2893984, 9.598116, 2.508152);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3
shape = new Ellipse2D.Double(28.295656204223633, 11.476043701171875, 9.105976104736328, 10.200495719909668);
paint = new Color(0, 255, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 255, 0, 255);
stroke = new BasicStroke(6.817325f,1,2,4.0f,null,0.0f);
shape = new Ellipse2D.Double(28.295656204223633, 11.476043701171875, 9.105976104736328, 10.200495719909668);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_3);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
shape = new GeneralPath();
((GeneralPath)shape).moveTo(16.72544, 21.916908);
((GeneralPath)shape).curveTo(15.952423, 26.065056, 17.341492, 35.41802, 22.807804, 40.97377);
((GeneralPath)shape).curveTo(27.03173, 41.11049, 36.402573, 37.666656, 42.758747, 31.106623);
((GeneralPath)shape).curveTo(33.78356, 26.736036, 27.661238, 15.892312, 22.900885, 18.253668);
((GeneralPath)shape).lineTo(16.72544, 21.916908);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(20.764476776123047, 19.540945053100586), 14.799585f, new Point2D.Double(20.764476776123047, 19.540945053100586), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(254, 240, 136, 255),new Color(253, 230, 58, 255),new Color(218, 194, 3, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.436699241399765f, -0.20948809385299683f, 0.5484671592712402f, 1.1337131261825562f, 0.9704418182373047f, 2.3244895935058594f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(196, 160, 0, 255);
stroke = new BasicStroke(0.9696938f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(16.72544, 21.916908);
((GeneralPath)shape).curveTo(15.952423, 26.065056, 17.341492, 35.41802, 22.807804, 40.97377);
((GeneralPath)shape).curveTo(27.03173, 41.11049, 36.402573, 37.666656, 42.758747, 31.106623);
((GeneralPath)shape).curveTo(33.78356, 26.736036, 27.661238, 15.892312, 22.900885, 18.253668);
((GeneralPath)shape).lineTo(16.72544, 21.916908);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_4);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_5 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5
shape = new Ellipse2D.Double(11.731539726257324, 16.043880462646484, 7.165430068969727, 10.79175090789795);
paint = new Color(0, 255, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 255, 0, 255);
stroke = new BasicStroke(6.2202406f,1,2,4.0f,null,0.0f);
shape = new Ellipse2D.Double(11.731539726257324, 16.043880462646484, 7.165430068969727, 10.79175090789795);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_5);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_6 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6
shape = new Ellipse2D.Double(18.168060302734375, 31.954301834106445, 7.165430068969727, 10.79175090789795);
paint = new Color(0, 255, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 255, 0, 255);
stroke = new BasicStroke(6.2202406f,1,2,4.0f,null,0.0f);
shape = new Ellipse2D.Double(18.168060302734375, 31.954301834106445, 7.165430068969727, 10.79175090789795);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_6);
g.setComposite(AlphaComposite.getInstance(3, 0.46153846f * origAlpha));
AffineTransform defaultTransform__0_0_7 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(0.96969306f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(17.831217, 22.517387);
((GeneralPath)shape).curveTo(16.944897, 23.009054, 17.67537, 34.63255, 23.257675, 39.935413);
((GeneralPath)shape).curveTo(30.434954, 39.754562, 38.342735, 33.746155, 41.130894, 31.383486);
((GeneralPath)shape).curveTo(31.899904, 25.59296, 26.627825, 17.099285, 23.17232, 19.216679);
((GeneralPath)shape).lineTo(17.831217, 22.517387);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_7);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_8 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8
paint = new LinearGradientPaint(new Point2D.Double(19.616243362426758, 39.25298309326172), new Point2D.Double(18.48598289489746, 29.90907096862793), new float[] {0.0f,1.0f}, new Color[] {new Color(196, 160, 0, 255),new Color(196, 160, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.8415544629096985f, -0.48382410407066345f, 0.7754127979278564f, 1.337396264076233f, -12.922614097595215f, -9.116602897644043f));
stroke = new BasicStroke(0.969693f,1,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(25.53685, 21.413504);
((GeneralPath)shape).curveTo(26.37873, 20.688734, 31.12439, 27.304222, 40.111534, 33.39473);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_8);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_9 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9
paint = new LinearGradientPaint(new Point2D.Double(15.096997261047363, 36.967769622802734), new Point2D.Double(14.045431137084961, 29.0), new float[] {0.0f,1.0f}, new Color[] {new Color(196, 160, 0, 255),new Color(196, 160, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.8415544629096985f, -0.48382410407066345f, 0.819644570350647f, 1.4136836528778076f, -16.820459365844727f, -10.913265228271484f));
stroke = new BasicStroke(0.96969354f,1,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(19.866156, 21.984985);
((GeneralPath)shape).curveTo(23.473566, 27.15948, 22.74542, 34.007294, 28.457155, 39.48114);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_9);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_10 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10
paint = new LinearGradientPaint(new Point2D.Double(14.045431137084961, 37.575889587402344), new Point2D.Double(14.045431137084961, 29.0), new float[] {0.0f,1.0f}, new Color[] {new Color(196, 160, 0, 255),new Color(196, 160, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.8415544629096985f, -0.48382410407066345f, 0.7786623239517212f, 1.34299898147583f, -10.093832015991211f, -10.923260688781738f));
stroke = new BasicStroke(0.96969354f,1,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(24.696693, 21.899736);
((GeneralPath)shape).curveTo(24.696693, 21.899736, 32.642372, 34.548473, 35.562656, 36.515636);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_10);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_11 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_11
paint = new LinearGradientPaint(new Point2D.Double(16.928730010986328, 34.010501861572266), new Point2D.Double(14.045431137084961, 29.0), new float[] {0.0f,1.0f}, new Color[] {new Color(196, 160, 0, 255),new Color(196, 160, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.8415544629096985f, -0.48382410407066345f, 0.8371437788009644f, 1.4438666105270386f, -15.012025833129883f, -13.600055694580078f));
stroke = new BasicStroke(0.9696934f,1,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(21.117191, 21.343216);
((GeneralPath)shape).curveTo(24.46693, 24.165667, 29.57384, 35.0482, 32.107616, 38.25553);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_11);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_12 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_12
shape = new GeneralPath();
((GeneralPath)shape).moveTo(8.869056, 15.603383);
((GeneralPath)shape).lineTo(21.8035, 8.34554);
((GeneralPath)shape).curveTo(22.479073, 10.982006, 21.417734, 11.931452, 23.830221, 16.254934);
((GeneralPath)shape).lineTo(14.903493, 21.263948);
((GeneralPath)shape).curveTo(13.263305, 17.415962, 10.880534, 17.490236, 8.869056, 15.603383);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(11.9966459274292, 19.59173583984375), new Point2D.Double(17.774032592773438, 16.234594345092773), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(218, 194, 3, 255),new Color(253, 236, 105, 255),new Color(253, 239, 126, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.1452999114990234f, 0.0f, 0.0f, 1.1131139993667603f, -1.107569932937622f, -4.5383381843566895f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(196, 160, 0, 255);
stroke = new BasicStroke(1.1290921f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(8.869056, 15.603383);
((GeneralPath)shape).lineTo(21.8035, 8.34554);
((GeneralPath)shape).curveTo(22.479073, 10.982006, 21.417734, 11.931452, 23.830221, 16.254934);
((GeneralPath)shape).lineTo(14.903493, 21.263948);
((GeneralPath)shape).curveTo(13.263305, 17.415962, 10.880534, 17.490236, 8.869056, 15.603383);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_12);
g.setComposite(AlphaComposite.getInstance(3, 0.2472527f * origAlpha));
AffineTransform defaultTransform__0_0_13 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_13
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(1.1174755f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(15.200609, 19.38307);
((GeneralPath)shape).curveTo(14.282058, 17.810406, 12.30905, 16.908417, 11.048514, 15.922595);
((GeneralPath)shape).lineTo(20.931225, 10.463102);
((GeneralPath)shape).curveTo(20.909115, 12.101887, 21.570974, 13.880397, 21.919348, 15.463292);
((GeneralPath)shape).lineTo(15.200609, 19.38307);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_13);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_14 = g.getTransform();
g.transform(new AffineTransform(0.8702220916748047f, -0.49265962839126587f, 0.5073771476745605f, 0.8617241382598877f, 0.0f, 0.0f));
// _0_0_14
shape = new RoundRectangle2D.Double(-0.05050160735845566, 22.973888397216797, 14.616555213928223, 3.847700357437134, 2.2460994720458984, 2.224170446395874);
paint = new LinearGradientPaint(new Point2D.Double(10.615303993225098, 28.122554779052734), new Point2D.Double(2.006974697113037, 27.234832763671875), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(179, 0, 0, 255),new Color(255, 92, 92, 255),new Color(195, 0, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.3214961290359497f, 0.0f, 0.0f, 1.3085954189300537f, 0.6154866814613342f, -9.812482833862305f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(105, 0, 0, 255);
stroke = new BasicStroke(1.117554f,1,0,4.0f,null,0.0f);
shape = new RoundRectangle2D.Double(-0.05050160735845566, 22.973888397216797, 14.616555213928223, 3.847700357437134, 2.2460994720458984, 2.224170446395874);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_14);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_15 = g.getTransform();
g.transform(new AffineTransform(0.9671733975410461f, 0.25411731004714966f, -0.26359623670578003f, 0.9646331071853638f, 0.0f, 0.0f));
// _0_0_15
shape = new Ellipse2D.Double(10.157252311706543, 0.22307610511779785, 2.9231739044189453, 2.873910665512085);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(143, 89, 2, 255);
stroke = new BasicStroke(1.1175048f,1,1,4.0f,null,0.0f);
shape = new Ellipse2D.Double(10.157252311706543, 0.22307610511779785, 2.9231739044189453, 2.873910665512085);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_15);
g.setComposite(AlphaComposite.getInstance(3, 0.3173077f * origAlpha));
AffineTransform defaultTransform__0_0_16 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_16
shape = new GeneralPath();
((GeneralPath)shape).moveTo(29.313381, 39.10396);
((GeneralPath)shape).curveTo(29.313381, 39.10396, 30.777393, 38.619507, 31.427988, 38.19267);
((GeneralPath)shape).curveTo(30.22552, 36.311035, 28.120817, 32.48774, 26.177542, 29.603903);
((GeneralPath)shape).curveTo(27.337067, 35.933037, 29.313381, 39.10396, 29.313381, 39.10396);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_16);
g.setComposite(AlphaComposite.getInstance(3, 0.3173077f * origAlpha));
AffineTransform defaultTransform__0_0_17 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17
shape = new GeneralPath();
((GeneralPath)shape).moveTo(32.62408, 37.65542);
((GeneralPath)shape).lineTo(34.59283, 36.605354);
((GeneralPath)shape).curveTo(32.70323, 34.80925, 27.335373, 26.816725, 27.335373, 26.816725);
((GeneralPath)shape).lineTo(32.62408, 37.65542);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_17);
g.setComposite(AlphaComposite.getInstance(3, 0.3173077f * origAlpha));
AffineTransform defaultTransform__0_0_18 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_18
shape = new GeneralPath();
((GeneralPath)shape).moveTo(37.01317, 35.07135);
((GeneralPath)shape).lineTo(39.380695, 33.384014);
((GeneralPath)shape).curveTo(36.288628, 32.10108, 28.121557, 23.823214, 28.121557, 23.823214);
((GeneralPath)shape).curveTo(30.437157, 26.737669, 34.697567, 32.1569, 37.01317, 35.07135);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_18);
g.setComposite(AlphaComposite.getInstance(3, 0.3173077f * origAlpha));
AffineTransform defaultTransform__0_0_19 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_19
shape = new GeneralPath();
((GeneralPath)shape).moveTo(40.409573, 32.68068);
((GeneralPath)shape).lineTo(42.054066, 31.31677);
((GeneralPath)shape).curveTo(38.83316, 29.862782, 29.911482, 21.725426, 29.911482, 21.725426);
((GeneralPath)shape).curveTo(29.911482, 21.725426, 35.814415, 30.627987, 40.409573, 32.68068);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_19);
g.setComposite(AlphaComposite.getInstance(3, 0.31730765f * origAlpha));
AffineTransform defaultTransform__0_0_20 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_20
shape = new GeneralPath();
((GeneralPath)shape).moveTo(26.049534, 40.08754);
((GeneralPath)shape).curveTo(26.049534, 40.08754, 27.212929, 39.81691, 28.035305, 39.64666);
((GeneralPath)shape).curveTo(26.618107, 38.449257, 24.341623, 35.35296, 23.085474, 31.31448);
((GeneralPath)shape).curveTo(23.600819, 37.98573, 26.049534, 40.08754, 26.049534, 40.08754);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_20);
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
        return 1.8094968795776367;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 0.1688968986272812;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 45.03313446044922;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 47.3253059387207;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private clearSecSegModel() {
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
       clearSecSegModel base = new clearSecSegModel();
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
       clearSecSegModel base = new clearSecSegModel();
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
        return clearSecSegModel::new;
    }
}

