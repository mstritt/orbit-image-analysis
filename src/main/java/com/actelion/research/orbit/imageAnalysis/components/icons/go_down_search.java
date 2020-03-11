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
public class go_down_search implements ResizableIcon {
    

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
g.setComposite(AlphaComposite.getInstance(3, 0.38139534f * origAlpha));
AffineTransform defaultTransform__0_0_0 = g.getTransform();
g.transform(new AffineTransform(1.0013740062713623f, 0.0f, 0.0f, 0.41037899255752563f, -2.3931690520839766E-5f, 75.32737731933594f));
// _0_0_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(127.82442, 115.70919);
((GeneralPath)shape).curveTo(127.926834, 120.239204, 115.767685, 124.4338, 95.95111, 126.70467);
((GeneralPath)shape).curveTo(76.13453, 128.97554, 51.689888, 128.97554, 31.87331, 126.70467);
((GeneralPath)shape).curveTo(12.056729, 124.4338, -0.102419876, 120.239204, 0.0, 115.70919);
((GeneralPath)shape).lineTo(-7.1054274E-15, 115.70919);
((GeneralPath)shape).curveTo(-0.102419876, 111.17918, 12.056729, 106.98458, 31.87331, 104.71371);
((GeneralPath)shape).curveTo(51.689888, 102.44283, 76.13453, 102.44283, 95.95111, 104.71371);
((GeneralPath)shape).curveTo(115.767685, 106.98458, 127.926834, 111.17918, 127.82442, 115.70919);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(63.912208557128906, 115.70919036865234), 63.91221f, new Point2D.Double(63.912208557128906, 115.70929718017578), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.19780200719833374f, 0.0f, 92.82166290283203f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, -4.0f));
// _0_0_1
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 4.0f));
// _0_0_1_0
g.setComposite(AlphaComposite.getInstance(3, 0.1f * origAlpha));
AffineTransform defaultTransform__0_0_1_0_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_0_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(16.0, 4.0);
((GeneralPath)shape).curveTo(13.794, 4.0, 12.0, 5.794, 12.0, 8.0);
((GeneralPath)shape).lineTo(12.0, 118.0);
((GeneralPath)shape).curveTo(12.0, 121.309, 14.691, 124.0, 18.0, 124.0);
((GeneralPath)shape).lineTo(77.172, 124.0);
((GeneralPath)shape).curveTo(78.471, 124.0, 79.717, 123.513, 80.813, 122.646);
((GeneralPath)shape).curveTo(80.941, 122.593, 81.07, 122.539, 81.07, 122.539);
((GeneralPath)shape).curveTo(81.168, 122.466, 93.204, 112.453, 98.829, 106.828);
((GeneralPath)shape).curveTo(104.203, 101.457, 113.439, 90.403, 114.475, 89.161);
((GeneralPath)shape).curveTo(115.388, 88.279, 116.0, 86.722, 116.0, 85.172);
((GeneralPath)shape).lineTo(116.0, 8.0);
((GeneralPath)shape).curveTo(116.0, 5.794, 114.206, 4.0, 112.0, 4.0);
((GeneralPath)shape).lineTo(16.0, 4.0);
((GeneralPath)shape).closePath();
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_0_0);
g.setComposite(AlphaComposite.getInstance(3, 0.15f * origAlpha));
AffineTransform defaultTransform__0_0_1_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_0_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(16.0, 5.0);
((GeneralPath)shape).curveTo(14.346, 5.0, 13.0, 6.346, 13.0, 8.0);
((GeneralPath)shape).lineTo(13.0, 118.0);
((GeneralPath)shape).curveTo(13.0, 120.757, 15.243, 123.0, 18.0, 123.0);
((GeneralPath)shape).lineTo(77.172, 123.0);
((GeneralPath)shape).curveTo(78.361, 123.0, 79.454, 122.53, 80.354, 121.771);
((GeneralPath)shape).curveTo(80.396, 121.75, 80.444, 121.757, 80.483, 121.729);
((GeneralPath)shape).curveTo(80.562, 121.669, 92.5, 111.743, 98.122, 106.121);
((GeneralPath)shape).curveTo(103.434, 100.811, 112.672, 89.763, 113.707, 88.52);
((GeneralPath)shape).curveTo(114.492, 87.756, 115.001, 86.477, 115.001, 85.171);
((GeneralPath)shape).lineTo(115.001, 8.0);
((GeneralPath)shape).curveTo(115.001, 6.346, 113.655, 5.0, 112.001, 5.0);
((GeneralPath)shape).lineTo(16.0, 5.0);
((GeneralPath)shape).closePath();
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_0_1);
g.setComposite(AlphaComposite.getInstance(3, 0.2f * origAlpha));
AffineTransform defaultTransform__0_0_1_0_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_0_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(16.0, 6.0);
((GeneralPath)shape).curveTo(14.897, 6.0, 14.0, 6.897, 14.0, 8.0);
((GeneralPath)shape).lineTo(14.0, 118.0);
((GeneralPath)shape).curveTo(14.0, 120.206, 15.794, 122.0, 18.0, 122.0);
((GeneralPath)shape).lineTo(77.172, 122.0);
((GeneralPath)shape).curveTo(78.24, 122.0, 79.244, 121.584, 80.0, 120.828);
((GeneralPath)shape).curveTo(79.965, 120.864, 79.926, 120.896, 79.886, 120.927);
((GeneralPath)shape).curveTo(79.962, 120.87, 91.846, 110.983, 97.414, 105.414);
((GeneralPath)shape).curveTo(102.679, 100.15, 111.904, 89.12, 112.938, 87.88);
((GeneralPath)shape).curveTo(113.593, 87.236, 114.0, 86.23, 114.0, 85.172);
((GeneralPath)shape).lineTo(114.0, 8.0);
((GeneralPath)shape).curveTo(114.0, 6.897, 113.103, 6.0, 112.0, 6.0);
((GeneralPath)shape).lineTo(16.0, 6.0);
((GeneralPath)shape).closePath();
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_0_2);
g.setComposite(AlphaComposite.getInstance(3, 0.25f * origAlpha));
AffineTransform defaultTransform__0_0_1_0_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_0_3
shape = new GeneralPath();
((GeneralPath)shape).moveTo(16.0, 7.0);
((GeneralPath)shape).curveTo(15.448, 7.0, 15.0, 7.448, 15.0, 8.0);
((GeneralPath)shape).lineTo(15.0, 118.0);
((GeneralPath)shape).curveTo(15.0, 119.654, 16.346, 121.0, 18.0, 121.0);
((GeneralPath)shape).lineTo(77.172, 121.0);
((GeneralPath)shape).curveTo(77.973, 121.0, 78.727, 120.688, 79.293, 120.121);
((GeneralPath)shape).curveTo(79.345, 120.083, 91.238, 110.176, 96.707, 104.707);
((GeneralPath)shape).curveTo(102.176, 99.238, 112.083, 87.345, 112.183, 87.226);
((GeneralPath)shape).curveTo(112.688, 86.727, 113.0, 85.973, 113.0, 85.172);
((GeneralPath)shape).lineTo(113.0, 8.0);
((GeneralPath)shape).curveTo(113.0, 7.448, 112.553, 7.0, 112.0, 7.0);
((GeneralPath)shape).lineTo(16.0, 7.0);
((GeneralPath)shape).closePath();
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_0_3);
g.setTransform(defaultTransform__0_0_1_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(16.0, 12.0);
((GeneralPath)shape).lineTo(16.0, 122.0);
((GeneralPath)shape).curveTo(16.0, 123.104, 16.896, 124.0, 18.0, 124.0);
((GeneralPath)shape).lineTo(77.172, 124.0);
((GeneralPath)shape).curveTo(77.702, 124.0, 78.211, 123.789, 78.586, 123.414);
((GeneralPath)shape).lineTo(111.414, 90.586);
((GeneralPath)shape).curveTo(111.789, 90.211, 112.0, 89.702, 112.0, 89.172);
((GeneralPath)shape).lineTo(112.0, 12.0);
((GeneralPath)shape).lineTo(16.0, 12.0);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(102.0, 112.30470275878906), 139.5585f, new Point2D.Double(102.0, 112.30470275878906), new float[] {0.0f,0.0151f,0.0558f,0.0964f,0.1357f,0.1737f,0.2099f,0.2435f,0.2722f}, new Color[] {new Color(0, 83, 125, 255),new Color(24, 99, 137, 255),new Color(85, 140, 168, 255),new Color(137, 175, 195, 255),new Color(179, 204, 216, 255),new Color(212, 226, 233, 255),new Color(236, 242, 245, 255),new Color(250, 252, 253, 255),new Color(255, 255, 255, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 4.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(18.0, 13.0);
((GeneralPath)shape).curveTo(17.449, 13.0, 17.0, 13.449, 17.0, 14.0);
((GeneralPath)shape).lineTo(17.0, 122.0);
((GeneralPath)shape).curveTo(17.0, 122.552, 17.449, 123.0, 18.0, 123.0);
((GeneralPath)shape).lineTo(77.172, 123.0);
((GeneralPath)shape).curveTo(77.435, 123.0, 77.693, 122.894, 77.879, 122.707);
((GeneralPath)shape).lineTo(110.707, 89.879);
((GeneralPath)shape).curveTo(110.894, 89.692, 111.0, 89.435, 111.0, 89.172);
((GeneralPath)shape).lineTo(111.0, 14.0);
((GeneralPath)shape).curveTo(111.0, 13.449, 110.552, 13.0, 110.0, 13.0);
((GeneralPath)shape).lineTo(18.0, 13.0);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(102.0, 112.30470275878906), 139.5586f, new Point2D.Double(102.0, 112.30470275878906), new float[] {0.0f,0.11366145f,0.20296688f,0.2363f,0.2722f,0.5313f,0.8449f,1.0f}, new Color[] {new Color(83, 85, 87, 255),new Color(137, 138, 140, 255),new Color(236, 236, 236, 255),new Color(250, 250, 250, 255),new Color(255, 255, 255, 255),new Color(250, 250, 250, 255),new Color(235, 236, 236, 255),new Color(225, 226, 227, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 4.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 4.0f));
// _0_0_1_3
g.setComposite(AlphaComposite.getInstance(3, 0.1f * origAlpha));
AffineTransform defaultTransform__0_0_1_3_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_3_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(111.414, 86.586);
((GeneralPath)shape).curveTo(111.664, 86.336, 93.035, 93.0, 88.0, 93.0);
((GeneralPath)shape).curveTo(86.346, 93.0, 85.0, 94.346, 85.0, 96.0);
((GeneralPath)shape).curveTo(85.0, 101.035, 78.336, 119.664, 78.586, 119.414);
((GeneralPath)shape).lineTo(111.414, 86.586);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(94.34380340576172, 102.3447036743164), new Point2D.Double(86.53559875488281, 94.5365982055664), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(85, 87, 83, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_3_0);
g.setComposite(AlphaComposite.getInstance(3, 0.1f * origAlpha));
AffineTransform defaultTransform__0_0_1_3_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_3_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(111.414, 86.586);
((GeneralPath)shape).curveTo(111.789, 86.211, 97.444, 94.0, 88.0, 94.0);
((GeneralPath)shape).curveTo(86.897, 94.0, 86.0, 94.897, 86.0, 96.0);
((GeneralPath)shape).curveTo(86.0, 105.444, 78.211, 119.789, 78.586, 119.414);
((GeneralPath)shape).lineTo(111.414, 86.586);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(95.0, 103.0), new Point2D.Double(86.58650207519531, 94.58650207519531), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(85, 87, 83, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_3_1);
g.setComposite(AlphaComposite.getInstance(3, 0.1f * origAlpha));
AffineTransform defaultTransform__0_0_1_3_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_3_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(111.414, 86.586);
((GeneralPath)shape).curveTo(111.653, 86.347, 97.807, 95.0, 88.0, 95.0);
((GeneralPath)shape).curveTo(87.447, 95.0, 87.0, 95.447, 87.0, 96.0);
((GeneralPath)shape).curveTo(87.0, 105.807, 78.347, 119.653, 78.586, 119.414);
((GeneralPath)shape).lineTo(111.414, 86.586);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(95.0, 103.0), new Point2D.Double(87.29299926757812, 95.29299926757812), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(57, 59, 56, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_3_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1_3_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_3_3
shape = new GeneralPath();
((GeneralPath)shape).moveTo(78.586, 119.414);
((GeneralPath)shape).curveTo(78.586, 119.414, 90.5, 109.5, 96.0, 104.0);
((GeneralPath)shape).curveTo(101.5, 98.5, 111.414, 86.586, 111.414, 86.586);
((GeneralPath)shape).curveTo(111.414, 86.586, 98.25, 96.0, 88.0, 96.0);
((GeneralPath)shape).curveTo(88.0, 106.25, 78.586, 119.414, 78.586, 119.414);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(96.0, 104.0), new Point2D.Double(88.00019836425781, 96.00019836425781), new float[] {0.0f,0.0072f,0.0673f,0.1347f,0.2115f,0.3012f,0.4122f,0.5679f,1.0f}, new Color[] {new Color(136, 138, 133, 255),new Color(140, 142, 137, 255),new Color(171, 172, 169, 255),new Color(197, 198, 196, 255),new Color(219, 219, 218, 255),new Color(235, 235, 235, 255),new Color(247, 247, 246, 255),new Color(253, 253, 253, 255),new Color(255, 255, 255, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_3_3);
g.setTransform(defaultTransform__0_0_1_3);
g.setTransform(defaultTransform__0_0_1);
g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));
AffineTransform defaultTransform__0_0_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
g.setTransform(defaultTransform__0_0_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3
shape = new GeneralPath();
((GeneralPath)shape).moveTo(-42.93742, 3.783933);
((GeneralPath)shape).lineTo(-42.93742, 0.9892245);
((GeneralPath)shape).lineTo(-42.93742, 3.783933);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_3);
g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
AffineTransform defaultTransform__0_0_4 = g.getTransform();
g.transform(new AffineTransform(-0.7829949855804443f, 0.0f, 0.0f, 0.6508790254592896f, -2365.7958984375f, 690.3015747070312f));
// _0_0_4
g.setTransform(defaultTransform__0_0_4);
g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
AffineTransform defaultTransform__0_0_5 = g.getTransform();
g.transform(new AffineTransform(-0.7829949855804443f, 0.0f, 0.0f, 0.6508790254592896f, -2365.7958984375f, 690.3015747070312f));
// _0_0_5
g.setTransform(defaultTransform__0_0_5);
g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
AffineTransform defaultTransform__0_0_6 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 0.6508790254592896f, 835.1669921875f, 697.62939453125f));
// _0_0_6
g.setTransform(defaultTransform__0_0_6);
g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
AffineTransform defaultTransform__0_0_7 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 0.6508790254592896f, 835.1669921875f, 697.62939453125f));
// _0_0_7
g.setTransform(defaultTransform__0_0_7);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_8 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8
shape = new GeneralPath();
((GeneralPath)shape).moveTo(61.23105, 2.6244366);
((GeneralPath)shape).lineTo(61.23105, 0.41896716);
((GeneralPath)shape).lineTo(61.23105, 2.6244366);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_8);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_9 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f));
// _0_0_9
shape = new RoundRectangle2D.Double(56.0, -88.0, 16.0, 72.0, 8.618450164794922, 7.2496867179870605);
paint = new LinearGradientPaint(new Point2D.Double(56.21098327636719, 7.236054420471191), new Point2D.Double(56.21098327636719, 108.9878921508789), new float[] {0.0f,0.35f,0.5961165f,1.0f}, new Color[] {new Color(44, 114, 199, 255),new Color(86, 140, 208, 255),new Color(128, 167, 218, 255),new Color(189, 210, 236, 57)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0722453594207764f, 0.0f, 0.0f, 0.9019536972045898f, 3.7280383110046387f, -107.61749267578125f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_9);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_10 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10
shape = new GeneralPath();
((GeneralPath)shape).moveTo(61.96995, 103.13666);
((GeneralPath)shape).lineTo(24.708143, 63.712708);
((GeneralPath)shape).curveTo(23.710278, 62.656525, 23.774563, 61.03073, 24.853146, 60.050037);
((GeneralPath)shape).lineTo(27.048166, 58.05434);
((GeneralPath)shape).curveTo(28.04175, 57.1512, 29.579622, 57.088745, 30.64892, 57.910908);
((GeneralPath)shape).curveTo(30.64892, 57.910908, 60.898514, 81.16477, 63.999973, 83.54959);
((GeneralPath)shape).curveTo(67.10215, 81.16477, 97.35103, 57.910908, 97.35103, 57.910908);
((GeneralPath)shape).curveTo(98.41961, 57.088745, 99.95748, 57.1512, 100.95107, 58.05434);
((GeneralPath)shape).lineTo(103.1468, 60.050037);
((GeneralPath)shape).curveTo(104.2261, 61.03073, 104.28968, 62.656525, 103.29038, 63.71202);
((GeneralPath)shape).lineTo(66.031425, 103.13735);
((GeneralPath)shape).curveTo(65.51213, 103.68637, 64.77355, 104.0, 64.00069, 104.0);
((GeneralPath)shape).curveTo(63.227108, 104.0, 62.489243, 103.68637, 61.96995, 103.13666);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(55.99903106689453, -2.029032373229711E-7), new Point2D.Double(55.99903106689453, 136.20562744140625), new float[] {0.0f,1.0f}, new Color[] {new Color(44, 114, 199, 255),new Color(164, 192, 228, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.7142931222915649f, 0.0f, 0.0f, -0.6862784028053284f, 24.000280380249023f, 104.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_10);
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
        return 0.4189671576023102;
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
		return 127.5810317993164;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private go_down_search() {
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
       go_down_search base = new go_down_search();
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
       go_down_search base = new go_down_search();
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
        return go_down_search::new;
    }
}

