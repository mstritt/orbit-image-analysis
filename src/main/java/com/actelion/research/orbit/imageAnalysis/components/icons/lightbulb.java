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
public class lightbulb implements ResizableIcon {
    

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
g.transform(new AffineTransform(0.003805798012763262f, 0.0f, 0.0f, 0.003805798012763262f, 0.19086266348300995f, -0.0f));
// _0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0
shape = new Rectangle2D.Double(72.34400177001953, 256.4100036621094, 19.038000106811523, 6.3460001945495605);
paint = new Color(110, 110, 110, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_1
shape = new Rectangle2D.Double(65.99800109863281, 252.60000610351562, 31.729000091552734, 6.3460001945495605);
paint = new RadialGradientPaint(new Point2D.Double(81.86299896240234, 255.77999877929688), 11.44f, new Point2D.Double(81.86299896240234, 255.77999877929688), new float[] {0.0f,1.0f}, new Color[] {new Color(207, 207, 207, 255),new Color(168, 168, 168, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(162.46, 71.595);
((GeneralPath)shape).curveTo(162.46, 32.057, 126.09, 0.0, 81.229, 0.0);
((GeneralPath)shape).curveTo(36.368, 0.0, 0.0, 32.057, 0.0, 71.595);
((GeneralPath)shape).curveTo(0.0, 87.222, 5.741, 101.64, 15.376, 113.4);
((GeneralPath)shape).curveTo(16.516, 115.01, 48.648, 160.46, 51.376, 179.64);
((GeneralPath)shape).curveTo(54.15, 199.17, 54.15, 204.37, 54.15, 204.37);
((GeneralPath)shape).lineTo(69.45, 204.89);
((GeneralPath)shape).lineTo(69.423, 205.68);
((GeneralPath)shape).lineTo(81.228, 205.28);
((GeneralPath)shape).lineTo(93.032, 205.68);
((GeneralPath)shape).lineTo(93.008, 204.89);
((GeneralPath)shape).lineTo(108.31, 204.37);
((GeneralPath)shape).curveTo(108.31, 204.37, 108.31, 199.17, 111.08, 179.64);
((GeneralPath)shape).curveTo(113.81, 160.46, 145.94, 115.01, 147.08, 113.4);
((GeneralPath)shape).curveTo(156.72, 101.64, 162.46, 87.222, 162.46, 71.595);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(81.22799682617188, 102.83999633789062), 92.666f, new Point2D.Double(81.22799682617188, 102.83999633789062), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(205, 205, 205, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_3
paint = new Color(109, 104, 104, 255);
stroke = new BasicStroke(0.75f,0,0,4.0f,null,0.0f);
shape = new Line2D.Float(79.959000f,93.955002f,74.882004f,208.179993f);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_3);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_4
paint = new Color(109, 104, 104, 255);
stroke = new BasicStroke(0.75f,0,0,4.0f,null,0.0f);
shape = new Line2D.Float(83.766998f,93.955002f,86.305000f,208.179993f);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_4);
g.setComposite(AlphaComposite.getInstance(3, 0.26000002f * origAlpha));
AffineTransform defaultTransform__0_5 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_5
shape = new GeneralPath();
((GeneralPath)shape).moveTo(81.229, 0.0);
((GeneralPath)shape).lineTo(80.792, 3.277);
((GeneralPath)shape).lineTo(82.894, 19.072);
((GeneralPath)shape).curveTo(82.161, 19.206, 81.511, 19.369, 80.792, 19.508);
((GeneralPath)shape).curveTo(175.54, 37.956, 123.11, 109.18, 123.11, 109.18);
((GeneralPath)shape).lineTo(93.032, 205.68);
((GeneralPath)shape).lineTo(108.31, 204.37);
((GeneralPath)shape).curveTo(101.11, 182.8, 138.34, 123.14, 138.34, 123.14);
((GeneralPath)shape).curveTo(210.69, 14.0, 81.229, 0.0, 81.229, 0.0);
((GeneralPath)shape).closePath();
paint = new Color(188, 188, 188, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_5);
g.setComposite(AlphaComposite.getInstance(3, 0.26000002f * origAlpha));
AffineTransform defaultTransform__0_6 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_6
shape = new GeneralPath();
((GeneralPath)shape).moveTo(80.792, 3.277);
((GeneralPath)shape).lineTo(80.355, 0.0);
((GeneralPath)shape).curveTo(80.355, 0.0, -49.105, 13.996, 23.242, 123.15);
((GeneralPath)shape).curveTo(23.242, 123.15, 60.47, 182.8, 53.278, 204.37);
((GeneralPath)shape).lineTo(68.55, 205.68);
((GeneralPath)shape).lineTo(38.472, 109.18);
((GeneralPath)shape).curveTo(38.472, 109.18, -13.957, 37.957, 80.791, 19.509);
((GeneralPath)shape).curveTo(80.072, 19.37, 79.423, 19.207, 78.688, 19.073);
((GeneralPath)shape).lineTo(80.792, 3.277);
((GeneralPath)shape).closePath();
paint = new Color(188, 188, 188, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_6);
g.setComposite(AlphaComposite.getInstance(3, 0.26000002f * origAlpha));
AffineTransform defaultTransform__0_7 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_7
shape = new GeneralPath();
((GeneralPath)shape).moveTo(80.792, 3.277);
((GeneralPath)shape).lineTo(78.689, 19.072);
((GeneralPath)shape).curveTo(79.423, 19.206, 80.073, 19.369, 80.792, 19.508);
((GeneralPath)shape).curveTo(81.511, 19.369, 82.16, 19.206, 82.894, 19.072);
((GeneralPath)shape).lineTo(80.792, 3.277);
((GeneralPath)shape).closePath();
paint = new Color(188, 188, 188, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_7);
g.setComposite(AlphaComposite.getInstance(3, 0.26000002f * origAlpha));
AffineTransform defaultTransform__0_8 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_8
shape = new GeneralPath();
((GeneralPath)shape).moveTo(80.792, 3.277);
((GeneralPath)shape).lineTo(78.689, 19.072);
((GeneralPath)shape).curveTo(79.423, 19.206, 80.073, 19.369, 80.792, 19.508);
((GeneralPath)shape).curveTo(81.511, 19.369, 82.16, 19.206, 82.894, 19.072);
((GeneralPath)shape).lineTo(80.792, 3.277);
((GeneralPath)shape).closePath();
paint = new Color(188, 188, 188, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_8);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_9 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_9
shape = new GeneralPath();
((GeneralPath)shape).moveTo(44.699, 12.747);
((GeneralPath)shape).curveTo(44.699, 12.747, -12.646, 56.137, 12.032, 99.798);
((GeneralPath)shape).curveTo(32.248, 140.11, -7.651, 60.943, 44.699, 12.747);
((GeneralPath)shape).closePath();
paint = new Color(188, 188, 188, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_9);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_10 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_10
shape = new GeneralPath();
((GeneralPath)shape).moveTo(109.78, 210.36);
((GeneralPath)shape).curveTo(109.78, 214.56, 106.37, 217.97, 102.17, 217.97);
((GeneralPath)shape).lineTo(60.286, 217.97);
((GeneralPath)shape).curveTo(56.08, 217.97, 52.671, 214.56, 52.671, 210.36);
((GeneralPath)shape).curveTo(52.671, 206.15, 56.08, 202.74, 60.286, 202.74);
((GeneralPath)shape).lineTo(102.17, 202.74);
((GeneralPath)shape).curveTo(106.37, 202.74, 109.78, 206.15, 109.78, 210.36);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(81.22799682617188, 210.36000061035156), 20.899f, new Point2D.Double(81.22799682617188, 210.36000061035156), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(129, 129, 129, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_10);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_11 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_11
paint = new Color(109, 104, 104, 255);
stroke = new BasicStroke(0.75f,0,0,4.0f,null,0.0f);
shape = new Line2D.Float(109.779999f,204.009995f,52.671001f,204.009995f);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_11);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_12 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_12
shape = new Rectangle2D.Double(50.768001556396484, 216.38999938964844, 59.652000427246094, 6.3460001945495605);
paint = new RadialGradientPaint(new Point2D.Double(80.59400177001953, 219.55999755859375), 21.209f, new Point2D.Double(80.59400177001953, 219.55999755859375), new float[] {0.3315f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(161, 161, 161, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_12);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_13 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_13
paint = new Color(175, 175, 175, 255);
stroke = new BasicStroke(0.75f,0,0,4.0f,null,0.0f);
shape = new Line2D.Float(54.575001f,224.639999f,107.879997f,224.639999f);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_13);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_14 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_14
shape = new Rectangle2D.Double(50.768001556396484, 225.27000427246094, 59.652000427246094, 6.3460001945495605);
paint = new RadialGradientPaint(new Point2D.Double(80.59400177001953, 228.44000244140625), 21.209f, new Point2D.Double(80.59400177001953, 228.44000244140625), new float[] {0.3315f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(161, 161, 161, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_14);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_15 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_15
paint = new Color(175, 175, 175, 255);
stroke = new BasicStroke(0.75f,0,0,4.0f,null,0.0f);
shape = new Line2D.Float(54.575001f,233.520004f,107.879997f,233.520004f);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_15);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_16 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_16
shape = new Rectangle2D.Double(50.768001556396484, 234.16000366210938, 59.652000427246094, 6.3460001945495605);
paint = new RadialGradientPaint(new Point2D.Double(80.59400177001953, 237.3300018310547), 21.209f, new Point2D.Double(80.59400177001953, 237.3300018310547), new float[] {0.3315f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(161, 161, 161, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_16);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_17 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_17
paint = new Color(175, 175, 175, 255);
stroke = new BasicStroke(0.75f,0,0,4.0f,null,0.0f);
shape = new Line2D.Float(54.575001f,242.399994f,107.879997f,242.399994f);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_17);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_18 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_18
shape = new Rectangle2D.Double(50.768001556396484, 243.0399932861328, 59.652000427246094, 6.3460001945495605);
paint = new RadialGradientPaint(new Point2D.Double(80.59400177001953, 246.2100067138672), 21.209f, new Point2D.Double(80.59400177001953, 246.2100067138672), new float[] {0.3315f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(161, 161, 161, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_18);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_19 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_19
paint = new Color(175, 175, 175, 255);
stroke = new BasicStroke(0.75f,0,0,4.0f,null,0.0f);
shape = new Line2D.Float(54.575001f,251.289993f,107.879997f,251.289993f);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_19);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_20 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_20
paint = new Color(175, 175, 175, 255);
stroke = new BasicStroke(0.5f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(70.993, 101.3);
((GeneralPath)shape).curveTo(75.576, 108.35, 83.008, 108.35, 87.594, 101.3);
((GeneralPath)shape).curveTo(91.263, 95.665, 91.263, 86.529, 87.594, 80.891);
((GeneralPath)shape).curveTo(84.659, 76.385, 79.9, 76.385, 76.97, 80.891);
((GeneralPath)shape).curveTo(74.622, 84.5, 74.622, 90.346, 76.97, 93.951);
((GeneralPath)shape).curveTo(78.849, 96.836, 81.893, 96.841, 83.767, 93.956);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_20);
g.setComposite(AlphaComposite.getInstance(3, 0.54f * origAlpha));
AffineTransform defaultTransform__0_21 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_21
shape = new GeneralPath();
((GeneralPath)shape).moveTo(152.96, 54.972);
((GeneralPath)shape).curveTo(152.96, 54.972, 163.27, 97.505, 135.15, 122.61);
((GeneralPath)shape).curveTo(135.15, 122.61, 153.87, 61.382, 152.96, 54.972);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(135.64999389648438, 84.55999755859375), 24.964f, new Point2D.Double(135.64999389648438, 84.55999755859375), new float[] {0.0f,1.0f}, new Color[] {new Color(207, 207, 207, 255),new Color(168, 168, 168, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9983999729156494f, 0.05649999901652336f, -0.05649999901652336f, 0.9983999729156494f, 14.907999992370605f, -3.211400032043457f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_21);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_22 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_22
shape = new GeneralPath();
((GeneralPath)shape).moveTo(80.848, 18.4488);
((GeneralPath)shape).curveTo(67.961, 18.4488, 57.479, 28.9308, 57.479, 41.8178);
((GeneralPath)shape).curveTo(57.4787, 54.7048, 67.961, 65.1868, 80.848, 65.1868);
((GeneralPath)shape).curveTo(93.735, 65.1868, 104.217, 54.7048, 104.217, 41.8178);
((GeneralPath)shape).curveTo(104.217, 28.9308, 93.735, 18.4488, 80.848, 18.4488);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(10.017999649047852, 8.63070011138916), new Point2D.Double(63.487998962402344, 63.65999984741211), new float[] {0.0f,1.0f}, new Color[] {new Color(35, 107, 13, 255),new Color(10, 34, 5, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 48.847999572753906f, 9.818099975585938f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_22);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_23 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_23
shape = new GeneralPath();
((GeneralPath)shape).moveTo(103.348, 41.8181);
((GeneralPath)shape).curveTo(103.348, 54.2381, 93.268, 64.3181, 80.848, 64.3181);
((GeneralPath)shape).curveTo(68.428, 64.3181, 58.348, 54.2381, 58.348, 41.8181);
((GeneralPath)shape).curveTo(58.348, 29.3981, 68.428, 19.3181, 80.848, 19.3181);
((GeneralPath)shape).curveTo(93.268, 19.3181, 103.348, 29.3981, 103.348, 41.8181);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(24.763999938964844, 16.36199951171875), 27.5f, new Point2D.Double(24.763999938964844, 16.36199951171875), new float[] {0.0f,1.0f}, new Color[] {new Color(46, 220, 50, 255),new Color(17, 102, 29, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.025213999673724174f, 1.0261000394821167f, -0.9781399965286255f, 0.0240470003336668f, 87.6780014038086f, 6.242400169372559f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_23);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_24 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_24
shape = new GeneralPath();
((GeneralPath)shape).moveTo(80.865, 18.9743);
((GeneralPath)shape).curveTo(71.423, 18.9743, 63.353, 24.6831, 59.91, 32.7873);
((GeneralPath)shape).curveTo(64.854, 35.6203, 70.241, 37.6743, 76.029, 37.4123);
((GeneralPath)shape).curveTo(81.603, 37.0983, 86.402, 33.3493, 92.085, 33.6303);
((GeneralPath)shape).curveTo(96.299, 33.5343, 101.092, 35.1123, 103.337, 38.8183);
((GeneralPath)shape).curveTo(101.991, 27.6653, 92.506, 18.9743, 80.865, 18.9743);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(18.386999130249023, 14.04699993133545), 27.5f, new Point2D.Double(18.386999130249023, 14.04699993133545), new float[] {0.0f,1.0f}, new Color[] {new Color(230, 230, 230, 255),new Color(17, 102, 29, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.01142400037497282f, 1.0987999439239502f, -1.843999981880188f, 0.01878800056874752f, 100.9990005493164f, 4.150700092315674f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_24);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_25 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_25
shape = new GeneralPath();
((GeneralPath)shape).moveTo(80.848, 18.4431);
((GeneralPath)shape).curveTo(67.961, 18.4431, 57.473, 28.9311, 57.473, 41.8181);
((GeneralPath)shape).curveTo(57.473, 54.7051, 67.961, 65.1931, 80.848, 65.1931);
((GeneralPath)shape).curveTo(93.735, 65.1931, 104.223, 54.7051, 104.223, 41.8181);
((GeneralPath)shape).curveTo(104.223, 28.9311, 93.735, 18.4431, 80.848, 18.4431);
((GeneralPath)shape).closePath();
((GeneralPath)shape).moveTo(80.848, 19.3181);
((GeneralPath)shape).curveTo(93.268, 19.3181, 103.348, 29.3981, 103.348, 41.8181);
((GeneralPath)shape).curveTo(103.348, 54.2381, 93.268, 64.3181, 80.848, 64.3181);
((GeneralPath)shape).curveTo(68.428, 64.3181, 58.348, 54.2381, 58.348, 41.8181);
((GeneralPath)shape).curveTo(58.348, 29.3981, 68.428, 19.3181, 80.848, 19.3181);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(10.017999649047852, 8.63070011138916), new Point2D.Double(63.487998962402344, 63.65999984741211), new float[] {0.0f,1.0f}, new Color[] {new Color(35, 107, 13, 255),new Color(10, 34, 5, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 48.845157623291016f, 9.815258979797363f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_25);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_26 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_26
shape = new GeneralPath();
((GeneralPath)shape).moveTo(84.66779, 37.08251);
((GeneralPath)shape).lineTo(81.96077, 37.08251);
((GeneralPath)shape).lineTo(74.276596, 38.358326);
((GeneralPath)shape).lineTo(74.276596, 41.89296);
((GeneralPath)shape).lineTo(75.1933, 41.97662);
((GeneralPath)shape).curveTo(77.07084, 42.14394, 77.59476, 42.89688, 77.59476, 45.553085);
((GeneralPath)shape).lineTo(77.59476, 51.8485);
((GeneralPath)shape).curveTo(77.59476, 54.337383, 77.332695, 54.81843, 75.67372, 55.15307);
((GeneralPath)shape).lineTo(74.276596, 55.466797);
((GeneralPath)shape).lineTo(74.276596, 59.00143);
((GeneralPath)shape).lineTo(87.942245, 59.00143);
((GeneralPath)shape).lineTo(87.942245, 55.466797);
((GeneralPath)shape).lineTo(86.58884, 55.15307);
((GeneralPath)shape).curveTo(84.92965, 54.7766, 84.66779, 54.337383, 84.66779, 51.8485);
((GeneralPath)shape).lineTo(84.66779, 37.08251);
((GeneralPath)shape).moveTo(80.86921, 27.12697);
((GeneralPath)shape).curveTo(78.555176, 27.12697, 76.54692, 29.09298, 76.54692, 31.414545);
((GeneralPath)shape).curveTo(76.54692, 33.715195, 78.38054, 35.597546, 80.69457, 35.597546);
((GeneralPath)shape).curveTo(83.05232, 35.597546, 85.017075, 33.631535, 85.017075, 31.26814);
((GeneralPath)shape).curveTo(85.017075, 28.96749, 83.22696, 27.12697, 80.86921, 27.12697);
paint = new LinearGradientPaint(new Point2D.Double(-0.566860020160675, 22.650999069213867), new Point2D.Double(-0.3371399939060211, 23.858999252319336), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(200, 200, 200, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(20.915000915527344f, 0.0f, 0.0f, 20.915000915527344f, 90.96299743652344f, -445.0918884277344f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_26);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_27 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_27
shape = new GeneralPath();
((GeneralPath)shape).moveTo(80.848, 18.4488);
((GeneralPath)shape).curveTo(67.961, 18.4488, 57.479, 28.9308, 57.479, 41.8178);
((GeneralPath)shape).curveTo(57.4787, 54.7048, 67.961, 65.1868, 80.848, 65.1868);
((GeneralPath)shape).curveTo(93.735, 65.1868, 104.217, 54.7048, 104.217, 41.8178);
((GeneralPath)shape).curveTo(104.217, 28.9308, 93.735, 18.4488, 80.848, 18.4488);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(10.017999649047852, 8.63070011138916), new Point2D.Double(63.487998962402344, 63.65999984741211), new float[] {0.0f,1.0f}, new Color[] {new Color(35, 107, 13, 255),new Color(10, 34, 5, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 48.847999572753906f, 9.818099975585938f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_27);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_28 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_28
shape = new GeneralPath();
((GeneralPath)shape).moveTo(103.348, 41.8181);
((GeneralPath)shape).curveTo(103.348, 54.2381, 93.268, 64.3181, 80.848, 64.3181);
((GeneralPath)shape).curveTo(68.428, 64.3181, 58.348, 54.2381, 58.348, 41.8181);
((GeneralPath)shape).curveTo(58.348, 29.3981, 68.428, 19.3181, 80.848, 19.3181);
((GeneralPath)shape).curveTo(93.268, 19.3181, 103.348, 29.3981, 103.348, 41.8181);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(24.763999938964844, 16.36199951171875), 27.5f, new Point2D.Double(24.763999938964844, 16.36199951171875), new float[] {0.0f,1.0f}, new Color[] {new Color(46, 220, 50, 255),new Color(17, 102, 29, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.025213999673724174f, 1.0261000394821167f, -0.9781399965286255f, 0.0240470003336668f, 87.6780014038086f, 6.242400169372559f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_28);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_29 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_29
shape = new GeneralPath();
((GeneralPath)shape).moveTo(80.865, 18.9743);
((GeneralPath)shape).curveTo(71.423, 18.9743, 63.353, 24.6831, 59.91, 32.7873);
((GeneralPath)shape).curveTo(64.854, 35.6203, 70.241, 37.6743, 76.029, 37.4123);
((GeneralPath)shape).curveTo(81.603, 37.0983, 86.402, 33.3493, 92.085, 33.6303);
((GeneralPath)shape).curveTo(96.299, 33.5343, 101.092, 35.1123, 103.337, 38.8183);
((GeneralPath)shape).curveTo(101.991, 27.6653, 92.506, 18.9743, 80.865, 18.9743);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(18.386999130249023, 14.04699993133545), 27.5f, new Point2D.Double(18.386999130249023, 14.04699993133545), new float[] {0.0f,1.0f}, new Color[] {new Color(230, 230, 230, 255),new Color(17, 102, 29, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.01142400037497282f, 1.0987999439239502f, -1.843999981880188f, 0.01878800056874752f, 100.9990005493164f, 4.150700092315674f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_29);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_30 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_30
shape = new GeneralPath();
((GeneralPath)shape).moveTo(80.848, 18.4431);
((GeneralPath)shape).curveTo(67.961, 18.4431, 57.473, 28.9311, 57.473, 41.8181);
((GeneralPath)shape).curveTo(57.473, 54.7051, 67.961, 65.1931, 80.848, 65.1931);
((GeneralPath)shape).curveTo(93.735, 65.1931, 104.223, 54.7051, 104.223, 41.8181);
((GeneralPath)shape).curveTo(104.223, 28.9311, 93.735, 18.4431, 80.848, 18.4431);
((GeneralPath)shape).closePath();
((GeneralPath)shape).moveTo(80.848, 19.3181);
((GeneralPath)shape).curveTo(93.268, 19.3181, 103.348, 29.3981, 103.348, 41.8181);
((GeneralPath)shape).curveTo(103.348, 54.2381, 93.268, 64.3181, 80.848, 64.3181);
((GeneralPath)shape).curveTo(68.428, 64.3181, 58.348, 54.2381, 58.348, 41.8181);
((GeneralPath)shape).curveTo(58.348, 29.3981, 68.428, 19.3181, 80.848, 19.3181);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(10.017999649047852, 8.63070011138916), new Point2D.Double(63.487998962402344, 63.65999984741211), new float[] {0.0f,1.0f}, new Color[] {new Color(35, 107, 13, 255),new Color(10, 34, 5, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 48.845157623291016f, 9.815258979797363f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_30);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_31 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_31
shape = new GeneralPath();
((GeneralPath)shape).moveTo(84.66779, 37.08251);
((GeneralPath)shape).lineTo(81.96077, 37.08251);
((GeneralPath)shape).lineTo(74.276596, 38.358326);
((GeneralPath)shape).lineTo(74.276596, 41.89296);
((GeneralPath)shape).lineTo(75.1933, 41.97662);
((GeneralPath)shape).curveTo(77.07084, 42.14394, 77.59476, 42.89688, 77.59476, 45.553085);
((GeneralPath)shape).lineTo(77.59476, 51.8485);
((GeneralPath)shape).curveTo(77.59476, 54.337383, 77.332695, 54.81843, 75.67372, 55.15307);
((GeneralPath)shape).lineTo(74.276596, 55.466797);
((GeneralPath)shape).lineTo(74.276596, 59.00143);
((GeneralPath)shape).lineTo(87.942245, 59.00143);
((GeneralPath)shape).lineTo(87.942245, 55.466797);
((GeneralPath)shape).lineTo(86.58884, 55.15307);
((GeneralPath)shape).curveTo(84.92965, 54.7766, 84.66779, 54.337383, 84.66779, 51.8485);
((GeneralPath)shape).lineTo(84.66779, 37.08251);
((GeneralPath)shape).moveTo(80.86921, 27.12697);
((GeneralPath)shape).curveTo(78.555176, 27.12697, 76.54692, 29.09298, 76.54692, 31.414545);
((GeneralPath)shape).curveTo(76.54692, 33.715195, 78.38054, 35.597546, 80.69457, 35.597546);
((GeneralPath)shape).curveTo(83.05232, 35.597546, 85.017075, 33.631535, 85.017075, 31.26814);
((GeneralPath)shape).curveTo(85.017075, 28.96749, 83.22696, 27.12697, 80.86921, 27.12697);
paint = new LinearGradientPaint(new Point2D.Double(-0.566860020160675, 22.650999069213867), new Point2D.Double(-0.3371399939060211, 23.858999252319336), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(200, 200, 200, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(20.915000915527344f, 0.0f, 0.0f, 20.915000915527344f, 90.96299743652344f, -445.0918884277344f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_31);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_32 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_32
shape = new GeneralPath();
((GeneralPath)shape).moveTo(80.847, 12.880036);
((GeneralPath)shape).curveTo(51.053547, 12.880036, 26.82021, 35.86392, 26.82021, 64.12124);
((GeneralPath)shape).curveTo(26.819515, 92.37857, 51.053547, 115.36245, 80.847, 115.36245);
((GeneralPath)shape).curveTo(110.64046, 115.36245, 134.8738, 92.37857, 134.8738, 64.12124);
((GeneralPath)shape).curveTo(134.8738, 35.86392, 110.64046, 12.880036, 80.847, 12.880036);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(10.017999649047852, 8.63070011138916), new Point2D.Double(63.487998962402344, 63.65999984741211), new float[] {0.0f,1.0f}, new Color[] {new Color(35, 107, 13, 255),new Color(10, 34, 5, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(2.3118999004364014f, 0.0f, 0.0f, 2.192699909210205f, 6.866199970245361f, -6.04449987411499f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_32);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_33 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_33
shape = new GeneralPath();
((GeneralPath)shape).moveTo(132.86475, 64.1219);
((GeneralPath)shape).curveTo(132.86475, 91.35523, 109.5608, 113.45765, 80.847, 113.45765);
((GeneralPath)shape).curveTo(52.1332, 113.45765, 28.82925, 91.35523, 28.82925, 64.1219);
((GeneralPath)shape).curveTo(28.82925, 36.888565, 52.1332, 14.78615, 80.847, 14.78615);
((GeneralPath)shape).curveTo(109.5608, 14.78615, 132.86475, 36.888565, 132.86475, 64.1219);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(24.763999938964844, 16.36199951171875), 27.5f, new Point2D.Double(24.763999938964844, 16.36199951171875), new float[] {0.0f,1.0f}, new Color[] {new Color(46, 220, 50, 255),new Color(17, 102, 29, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.05829225108027458f, 2.249929428100586f, -2.261361837387085f, 0.05272785946726799f, 96.63727569580078f, -13.884937286376953f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_33);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_34 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_34
shape = new GeneralPath();
((GeneralPath)shape).moveTo(80.88631, 14.0323);
((GeneralPath)shape).curveTo(59.057343, 14.0323, 40.40031, 26.549986, 32.440437, 44.320065);
((GeneralPath)shape).curveTo(43.870472, 50.531982, 56.324677, 55.03579, 69.705956, 54.461304);
((GeneralPath)shape).curveTo(82.59248, 53.772797, 93.687294, 45.55236, 106.82582, 46.16851);
((GeneralPath)shape).curveTo(116.56817, 45.95801, 127.6491, 49.41809, 132.83932, 57.54424);
((GeneralPath)shape).curveTo(129.7275, 33.089054, 107.79913, 14.0323, 80.88631, 14.0323);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(18.386999130249023, 14.04699993133545), 27.5f, new Point2D.Double(18.386999130249023, 14.04699993133545), new float[] {0.0f,1.0f}, new Color[] {new Color(230, 230, 230, 255),new Color(17, 102, 29, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.02641114965081215f, 2.4093387126922607f, -4.263143539428711f, 0.04119645059108734f, 127.43409729003906f, -18.47140884399414f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_34);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_35 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_35
shape = new GeneralPath();
((GeneralPath)shape).moveTo(80.847, 12.867538);
((GeneralPath)shape).curveTo(51.053547, 12.867538, 26.806337, 35.864574, 26.806337, 64.1219);
((GeneralPath)shape).curveTo(26.806337, 92.37923, 51.053547, 115.37626, 80.847, 115.37626);
((GeneralPath)shape).curveTo(110.64046, 115.37626, 134.88766, 92.37923, 134.88766, 64.1219);
((GeneralPath)shape).curveTo(134.88766, 35.864574, 110.64046, 12.867538, 80.847, 12.867538);
((GeneralPath)shape).closePath();
((GeneralPath)shape).moveTo(80.847, 14.78615);
((GeneralPath)shape).curveTo(109.5608, 14.78615, 132.86475, 36.888565, 132.86475, 64.1219);
((GeneralPath)shape).curveTo(132.86475, 91.35523, 109.5608, 113.45765, 80.847, 113.45765);
((GeneralPath)shape).curveTo(52.1332, 113.45765, 28.82925, 91.35523, 28.82925, 64.1219);
((GeneralPath)shape).curveTo(28.82925, 36.888565, 52.1332, 14.78615, 80.847, 14.78615);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(10.017999649047852, 8.63070011138916), new Point2D.Double(63.487998962402344, 63.65999984741211), new float[] {0.0f,1.0f}, new Color[] {new Color(35, 107, 13, 255),new Color(10, 34, 5, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(2.3118999004364014f, 0.0f, 0.0f, 2.192699909210205f, 6.8596320152282715f, -6.050729274749756f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_35);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_36 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_36
shape = new GeneralPath();
((GeneralPath)shape).moveTo(89.677986, 53.738117);
((GeneralPath)shape).lineTo(83.41961, 53.738117);
((GeneralPath)shape).lineTo(65.65457, 56.5356);
((GeneralPath)shape).lineTo(65.65457, 64.28599);
((GeneralPath)shape).lineTo(67.7739, 64.46943);
((GeneralPath)shape).curveTo(72.114586, 64.83631, 73.325836, 66.48729, 73.325836, 72.31155);
((GeneralPath)shape).lineTo(73.325836, 86.1155);
((GeneralPath)shape).curveTo(73.325836, 91.57288, 72.71997, 92.62767, 68.884575, 93.361435);
((GeneralPath)shape).lineTo(65.65457, 94.04934);
((GeneralPath)shape).lineTo(65.65457, 101.79973);
((GeneralPath)shape).lineTo(97.24819, 101.79973);
((GeneralPath)shape).lineTo(97.24819, 94.04934);
((GeneralPath)shape).lineTo(94.11924, 93.361435);
((GeneralPath)shape).curveTo(90.28337, 92.53595, 89.677986, 91.57288, 89.677986, 86.1155);
((GeneralPath)shape).lineTo(89.677986, 53.738117);
((GeneralPath)shape).moveTo(80.89604, 31.908606);
((GeneralPath)shape).curveTo(75.54623, 31.908606, 70.90333, 36.219475, 70.90333, 41.30997);
((GeneralPath)shape).curveTo(70.90333, 46.354607, 75.14247, 50.482037, 80.492294, 50.482037);
((GeneralPath)shape).curveTo(85.94317, 50.482037, 90.48549, 46.171165, 90.48549, 40.98895);
((GeneralPath)shape).curveTo(90.48549, 35.944313, 86.34692, 31.908606, 80.89604, 31.908606);
paint = new LinearGradientPaint(new Point2D.Double(-0.566860020160675, 22.650999069213867), new Point2D.Double(-0.3371399939060211, 23.858999252319336), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(200, 200, 200, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(48.353389739990234f, 0.0f, 0.0f, 45.860321044921875f, 104.23187255859375f, -1003.5256958007812f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_36);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_37 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_37
shape = new GeneralPath();
((GeneralPath)shape).moveTo(80.847, 12.880036);
((GeneralPath)shape).curveTo(51.053547, 12.880036, 26.82021, 35.86392, 26.82021, 64.12124);
((GeneralPath)shape).curveTo(26.819515, 92.37857, 51.053547, 115.36245, 80.847, 115.36245);
((GeneralPath)shape).curveTo(110.64046, 115.36245, 134.8738, 92.37857, 134.8738, 64.12124);
((GeneralPath)shape).curveTo(134.8738, 35.86392, 110.64046, 12.880036, 80.847, 12.880036);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(10.017999649047852, 8.63070011138916), new Point2D.Double(63.487998962402344, 63.65999984741211), new float[] {0.0f,1.0f}, new Color[] {new Color(35, 107, 13, 255),new Color(10, 34, 5, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(2.3118999004364014f, 0.0f, 0.0f, 2.192699909210205f, 6.866199970245361f, -6.04449987411499f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_37);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_38 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_38
shape = new GeneralPath();
((GeneralPath)shape).moveTo(132.86475, 64.1219);
((GeneralPath)shape).curveTo(132.86475, 91.35523, 109.5608, 113.45765, 80.847, 113.45765);
((GeneralPath)shape).curveTo(52.1332, 113.45765, 28.82925, 91.35523, 28.82925, 64.1219);
((GeneralPath)shape).curveTo(28.82925, 36.888565, 52.1332, 14.78615, 80.847, 14.78615);
((GeneralPath)shape).curveTo(109.5608, 14.78615, 132.86475, 36.888565, 132.86475, 64.1219);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(24.763999938964844, 16.36199951171875), 27.5f, new Point2D.Double(24.763999938964844, 16.36199951171875), new float[] {0.0f,1.0f}, new Color[] {new Color(46, 220, 50, 255),new Color(17, 102, 29, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.05829225108027458f, 2.249929428100586f, -2.261361837387085f, 0.05272785946726799f, 96.63727569580078f, -13.884937286376953f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_38);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_39 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_39
shape = new GeneralPath();
((GeneralPath)shape).moveTo(80.88631, 14.0323);
((GeneralPath)shape).curveTo(59.057343, 14.0323, 40.40031, 26.549986, 32.440437, 44.320065);
((GeneralPath)shape).curveTo(43.870472, 50.531982, 56.324677, 55.03579, 69.705956, 54.461304);
((GeneralPath)shape).curveTo(82.59248, 53.772797, 93.687294, 45.55236, 106.82582, 46.16851);
((GeneralPath)shape).curveTo(116.56817, 45.95801, 127.6491, 49.41809, 132.83932, 57.54424);
((GeneralPath)shape).curveTo(129.7275, 33.089054, 107.79913, 14.0323, 80.88631, 14.0323);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(18.386999130249023, 14.04699993133545), 27.5f, new Point2D.Double(18.386999130249023, 14.04699993133545), new float[] {0.0f,1.0f}, new Color[] {new Color(230, 230, 230, 255),new Color(17, 102, 29, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.02641114965081215f, 2.4093387126922607f, -4.263143539428711f, 0.04119645059108734f, 127.43409729003906f, -18.47140884399414f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_39);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_40 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_40
shape = new GeneralPath();
((GeneralPath)shape).moveTo(80.847, 12.867538);
((GeneralPath)shape).curveTo(51.053547, 12.867538, 26.806337, 35.864574, 26.806337, 64.1219);
((GeneralPath)shape).curveTo(26.806337, 92.37923, 51.053547, 115.37626, 80.847, 115.37626);
((GeneralPath)shape).curveTo(110.64046, 115.37626, 134.88766, 92.37923, 134.88766, 64.1219);
((GeneralPath)shape).curveTo(134.88766, 35.864574, 110.64046, 12.867538, 80.847, 12.867538);
((GeneralPath)shape).closePath();
((GeneralPath)shape).moveTo(80.847, 14.78615);
((GeneralPath)shape).curveTo(109.5608, 14.78615, 132.86475, 36.888565, 132.86475, 64.1219);
((GeneralPath)shape).curveTo(132.86475, 91.35523, 109.5608, 113.45765, 80.847, 113.45765);
((GeneralPath)shape).curveTo(52.1332, 113.45765, 28.82925, 91.35523, 28.82925, 64.1219);
((GeneralPath)shape).curveTo(28.82925, 36.888565, 52.1332, 14.78615, 80.847, 14.78615);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(10.017999649047852, 8.63070011138916), new Point2D.Double(63.487998962402344, 63.65999984741211), new float[] {0.0f,1.0f}, new Color[] {new Color(35, 107, 13, 255),new Color(10, 34, 5, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(2.3118999004364014f, 0.0f, 0.0f, 2.192699909210205f, 6.8596320152282715f, -6.050729274749756f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_40);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_41 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_41
shape = new GeneralPath();
((GeneralPath)shape).moveTo(89.677986, 53.738117);
((GeneralPath)shape).lineTo(83.41961, 53.738117);
((GeneralPath)shape).lineTo(65.65457, 56.5356);
((GeneralPath)shape).lineTo(65.65457, 64.28599);
((GeneralPath)shape).lineTo(67.7739, 64.46943);
((GeneralPath)shape).curveTo(72.114586, 64.83631, 73.325836, 66.48729, 73.325836, 72.31155);
((GeneralPath)shape).lineTo(73.325836, 86.1155);
((GeneralPath)shape).curveTo(73.325836, 91.57288, 72.71997, 92.62767, 68.884575, 93.361435);
((GeneralPath)shape).lineTo(65.65457, 94.04934);
((GeneralPath)shape).lineTo(65.65457, 101.79973);
((GeneralPath)shape).lineTo(97.24819, 101.79973);
((GeneralPath)shape).lineTo(97.24819, 94.04934);
((GeneralPath)shape).lineTo(94.11924, 93.361435);
((GeneralPath)shape).curveTo(90.28337, 92.53595, 89.677986, 91.57288, 89.677986, 86.1155);
((GeneralPath)shape).lineTo(89.677986, 53.738117);
((GeneralPath)shape).moveTo(80.89604, 31.908606);
((GeneralPath)shape).curveTo(75.54623, 31.908606, 70.90333, 36.219475, 70.90333, 41.30997);
((GeneralPath)shape).curveTo(70.90333, 46.354607, 75.14247, 50.482037, 80.492294, 50.482037);
((GeneralPath)shape).curveTo(85.94317, 50.482037, 90.48549, 46.171165, 90.48549, 40.98895);
((GeneralPath)shape).curveTo(90.48549, 35.944313, 86.34692, 31.908606, 80.89604, 31.908606);
paint = new LinearGradientPaint(new Point2D.Double(-0.566860020160675, 22.650999069213867), new Point2D.Double(-0.3371399939060211, 23.858999252319336), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(200, 200, 200, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(48.353389739990234f, 0.0f, 0.0f, 45.860321044921875f, 104.23187255859375f, -1003.5256958007812f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_41);
g.setTransform(defaultTransform__0);
g.setTransform(defaultTransform_);

	}

    /**
     * Returns the X of the bounding box of the original SVG image.
     * 
     * @return The X of the bounding box of the original SVG image.
     */
    public static double getOrigX() {
        return 0.003978953696787357;
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
		return 0.988727331161499;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 0.9999963045120239;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private lightbulb() {
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
       lightbulb base = new lightbulb();
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
       lightbulb base = new lightbulb();
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
        return lightbulb::new;
    }
}

