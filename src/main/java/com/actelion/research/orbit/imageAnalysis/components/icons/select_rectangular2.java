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
public class select_rectangular2 implements ResizableIcon {
    

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
g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));
AffineTransform defaultTransform__0_0_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0
shape = new Rectangle2D.Double(8.0, 16.0, 112.0, 96.0);
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
shape = new Rectangle2D.Double(3.9999637603759766, 15.999998092651367, 4.0, 96.0);
paint = new Color(153, 153, 153, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
shape = new Rectangle2D.Double(119.99996185302734, 15.999998092651367, 4.0, 96.0);
paint = new Color(153, 153, 153, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3
shape = new Rectangle2D.Double(8.0, 12.0, 112.0, 4.0);
paint = new Color(153, 153, 153, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_3);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
shape = new Rectangle2D.Double(8.0, 112.0, 112.0, 4.0);
paint = new Color(153, 153, 153, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_4);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_5 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5
shape = new GeneralPath();
((GeneralPath)shape).moveTo(24.0, 31.999998);
((GeneralPath)shape).curveTo(24.0, 38.716, 24.0, 89.284, 24.0, 96.0);
((GeneralPath)shape).curveTo(31.6, 96.0, 96.4, 96.0, 104.0, 96.0);
((GeneralPath)shape).curveTo(104.0, 89.284, 104.0, 38.716, 104.0, 31.999998);
((GeneralPath)shape).curveTo(96.4, 31.999998, 31.6, 31.999998, 24.0, 31.999998);
((GeneralPath)shape).closePath();
paint = new Color(85, 153, 255, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(85, 153, 255, 255);
stroke = new BasicStroke(8.0f,0,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(24.0, 31.999998);
((GeneralPath)shape).curveTo(24.0, 38.716, 24.0, 89.284, 24.0, 96.0);
((GeneralPath)shape).curveTo(31.6, 96.0, 96.4, 96.0, 104.0, 96.0);
((GeneralPath)shape).curveTo(104.0, 89.284, 104.0, 38.716, 104.0, 31.999998);
((GeneralPath)shape).curveTo(96.4, 31.999998, 31.6, 31.999998, 24.0, 31.999998);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_5);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_6 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6
shape = new GeneralPath();
((GeneralPath)shape).moveTo(24.0, 31.999998);
((GeneralPath)shape).curveTo(24.0, 38.716, 24.0, 89.284, 24.0, 96.0);
((GeneralPath)shape).curveTo(31.6, 96.0, 96.4, 96.0, 104.0, 96.0);
((GeneralPath)shape).curveTo(104.0, 89.284, 104.0, 38.716, 104.0, 31.999998);
((GeneralPath)shape).curveTo(96.4, 31.999998, 31.6, 31.999998, 24.0, 31.999998);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_6);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_7 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
shape = new Rectangle2D.Double(59.823184967041016, 23.909902572631836, 8.0, 8.0);
paint = new LinearGradientPaint(new Point2D.Double(56.0, 4.0), new Point2D.Double(64.0, 4.0), new float[] {0.0f,1.0f}, new Color[] {new Color(187, 187, 187, 255),new Color(136, 136, 136, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 3.823223352432251f, 23.909902572631836f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_7);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_8 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8
shape = new Rectangle2D.Double(59.999961853027344, 95.91332244873047, 8.0, 8.0);
paint = new LinearGradientPaint(new Point2D.Double(56.0, 108.0), new Point2D.Double(64.0, 108.0), new float[] {0.0f,1.0f}, new Color[] {new Color(187, 187, 187, 255),new Color(136, 136, 136, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 4.0f, -8.086679458618164f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_8);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_9 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9
shape = new Rectangle2D.Double(16.08664321899414, 24.44023323059082, 8.0, 8.0);
paint = new LinearGradientPaint(new Point2D.Double(0.0, 4.0), new Point2D.Double(8.0, 4.0), new float[] {0.0f,1.0f}, new Color[] {new Color(187, 187, 187, 255),new Color(136, 136, 136, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 16.086679458618164f, 24.44023323059082f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_9);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_10 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10
shape = new Rectangle2D.Double(16.26342010498047, 95.73654174804688, 8.0, 8.0);
paint = new LinearGradientPaint(new Point2D.Double(0.0, 108.0), new Point2D.Double(8.0, 108.0), new float[] {0.0f,1.0f}, new Color[] {new Color(187, 187, 187, 255),new Color(136, 136, 136, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 16.263456344604492f, -8.263456344604492f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_10);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_11 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_11
shape = new Rectangle2D.Double(104.26683807373047, 25.1473388671875, 8.0, 8.0);
paint = new LinearGradientPaint(new Point2D.Double(112.0, 4.0), new Point2D.Double(120.0, 4.0), new float[] {0.0f,1.0f}, new Color[] {new Color(187, 187, 187, 255),new Color(136, 136, 136, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -7.733126163482666f, 25.147340774536133f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_11);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_12 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_12
shape = new Rectangle2D.Double(103.91327667236328, 96.26687622070312, 8.0, 8.0);
paint = new LinearGradientPaint(new Point2D.Double(112.0, 108.0), new Point2D.Double(120.0, 108.0), new float[] {0.0f,1.0f}, new Color[] {new Color(187, 187, 187, 255),new Color(136, 136, 136, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -8.086679458618164f, -7.733126163482666f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_12);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_13 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_13
shape = new Rectangle2D.Double(15.733089447021484, 59.64645004272461, 8.0, 8.0);
paint = new LinearGradientPaint(new Point2D.Double(0.0, 56.0), new Point2D.Double(8.0, 56.0), new float[] {0.0f,1.0f}, new Color[] {new Color(187, 187, 187, 255),new Color(136, 136, 136, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 15.733125686645508f, 7.646446704864502f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_13);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_14 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_14
shape = new Rectangle2D.Double(104.09005737304688, 59.82322692871094, 8.0, 8.0);
paint = new LinearGradientPaint(new Point2D.Double(112.0, 56.0), new Point2D.Double(120.0, 56.0), new float[] {0.0f,1.0f}, new Color[] {new Color(187, 187, 187, 255),new Color(136, 136, 136, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -7.909902572631836f, 7.82322359085083f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_14);
g.setComposite(AlphaComposite.getInstance(3, 0.2f * origAlpha));
AffineTransform defaultTransform__0_0_15 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15
shape = new GeneralPath();
((GeneralPath)shape).moveTo(24.0, 32.0);
((GeneralPath)shape).curveTo(24.0, 38.716, 24.0, 89.284, 24.0, 96.0);
((GeneralPath)shape).curveTo(31.6, 96.0, 96.4, 96.0, 104.0, 96.0);
((GeneralPath)shape).curveTo(104.0, 89.284, 104.0, 38.716, 104.0, 32.0);
((GeneralPath)shape).curveTo(96.4, 32.0, 31.6, 32.0, 24.0, 32.0);
((GeneralPath)shape).closePath();
((GeneralPath)shape).moveTo(28.0, 36.0);
((GeneralPath)shape).lineTo(99.88909, 36.065865);
((GeneralPath)shape).lineTo(100.0, 92.0);
((GeneralPath)shape).lineTo(28.0, 92.0);
((GeneralPath)shape).lineTo(28.0, 36.0);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(64.0, 23.786014556884766), new Point2D.Double(64.0, 103.95767211914062), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(114, 119, 122, 255),new Color(0, 0, 0, 0),new Color(114, 117, 122, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_15);
g.setComposite(AlphaComposite.getInstance(3, 0.2f * origAlpha));
AffineTransform defaultTransform__0_0_16 = g.getTransform();
g.transform(new AffineTransform(0.6570990085601807f, -0.12202899903059006f, 0.04147060960531235f, 0.33568599820137024f, 23.20479965209961f, 60.07752990722656f));
// _0_0_16
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
paint = new RadialGradientPaint(new Point2D.Double(63.912208557128906, 115.70919036865234), 63.91221f, new Point2D.Double(8.71600341796875, 123.91520690917969), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.19780200719833374f, 0.0f, 92.82166290283203f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_16);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_17 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.15839500725269318f, 0.7728170156478882f));
// _0_0_17
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_17_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(112.94799, 0.35536432);
((GeneralPath)shape).curveTo(113.36977, -0.10112165, 116.08929, 0.16409583, 118.94522, 2.822344);
((GeneralPath)shape).curveTo(121.82917, 5.5066514, 122.37582, 8.067081, 121.84747, 8.6388445);
((GeneralPath)shape).curveTo(121.5036, 9.011015, 121.15971, 9.3831835, 120.81584, 9.755353);
((GeneralPath)shape).curveTo(117.84932, 6.9941916, 114.88282, 4.2330327, 111.91632, 1.4718714);
((GeneralPath)shape).curveTo(112.2602, 1.0997024, 112.60409, 0.72753394, 112.94799, 0.35536432);
((GeneralPath)shape).curveTo(112.94799, 0.35536432, 112.94799, 0.35536432, 112.94799, 0.35536432);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_17_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_17_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(31.841597, 97.22718);
((GeneralPath)shape).lineTo(56.094707, 79.936935);
((GeneralPath)shape).lineTo(56.232212, 79.78812);
((GeneralPath)shape).lineTo(47.47878, 71.346535);
((GeneralPath)shape).lineTo(47.2924, 71.548164);
((GeneralPath)shape).lineTo(31.841597, 97.22718);
((GeneralPath)shape).closePath();
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_17_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_17_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(33.24339, 95.81655);
((GeneralPath)shape).lineTo(55.860462, 79.702446);
((GeneralPath)shape).lineTo(55.99796, 79.553635);
((GeneralPath)shape).lineTo(47.71303, 71.58102);
((GeneralPath)shape).lineTo(47.52664, 71.78265);
((GeneralPath)shape).lineTo(33.24339, 95.81655);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(42.617530822753906, 120.64187622070312), 3.406888f, new Point2D.Double(42.617530822753906, 120.64187622070312), new float[] {0.0f,1.0f}, new Color[] {new Color(180, 148, 42, 255),new Color(228, 220, 201, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.2316160202026367f, 1.2914210557937622f, -11.706159591674805f, 11.178339958190918f, 1411.8740234375f, -1325.552001953125f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_17_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_17_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_3
shape = new GeneralPath();
((GeneralPath)shape).moveTo(51.062305, 76.42592);
((GeneralPath)shape).curveTo(52.15999, 77.44761, 53.282482, 77.06459, 53.67486, 77.429794);
((GeneralPath)shape).curveTo(53.738266, 77.48881, 53.78037, 77.5694, 53.810177, 77.65553);
((GeneralPath)shape).lineTo(119.0733, 6.887381);
((GeneralPath)shape).lineTo(114.75934, 2.8720372);
((GeneralPath)shape).lineTo(49.372314, 73.77426);
((GeneralPath)shape).curveTo(49.569042, 73.75839, 49.743523, 73.77058, 49.867622, 73.886086);
((GeneralPath)shape).curveTo(50.226265, 74.21992, 49.959526, 75.39947, 51.062305, 76.42592);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(15.727076530456543, 58.08968734741211), 2.6143966f, new Point2D.Double(15.727076530456543, 58.08968734741211), new float[] {0.0f,0.5f,0.75f,1.0f}, new Color[] {new Color(37, 37, 37, 255),new Color(37, 37, 37, 255),new Color(37, 37, 37, 255),new Color(0, 0, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.5485299825668335f, 1.4691139459609985f, -21.051679611206055f, 22.68597984313965f, 1272.946044921875f, -1291.4019775390625f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_17_3);
g.setComposite(AlphaComposite.getInstance(3, 0.35348833f * origAlpha));
AffineTransform defaultTransform__0_0_17_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_4
shape = new GeneralPath();
((GeneralPath)shape).moveTo(56.139603, 74.81749);
((GeneralPath)shape).lineTo(53.58407, 77.583176);
((GeneralPath)shape).curveTo(53.92704, 77.960365, 53.45654, 78.999374, 54.115776, 79.61297);
((GeneralPath)shape).curveTo(54.82623, 80.274254, 55.597614, 79.524734, 56.059303, 79.94943);
((GeneralPath)shape).lineTo(58.64581, 77.15019);
((GeneralPath)shape).lineTo(56.139603, 74.81749);
((GeneralPath)shape).closePath();
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_17_4);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_17_5 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_5
shape = new GeneralPath();
((GeneralPath)shape).moveTo(118.9158, 6.7407947);
((GeneralPath)shape).lineTo(53.702244, 77.45529);
((GeneralPath)shape).curveTo(54.047096, 77.83425, 53.696117, 78.74662, 54.35873, 79.36335);
((GeneralPath)shape).curveTo(55.072807, 80.02803, 55.72626, 79.40656, 56.190292, 79.83346);
((GeneralPath)shape).lineTo(121.43482, 9.085448);
((GeneralPath)shape).lineTo(118.9158, 6.7407947);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(36.6756477355957, 95.76927947998047), 47.746403f, new Point2D.Double(16.21735382080078, 64.14128112792969), new float[] {0.0f,0.09292036f,0.5043171f,0.91571385f,1.0f}, new Color[] {new Color(154, 118, 0, 255),new Color(227, 173, 0, 255),new Color(255, 205, 44, 255),new Color(227, 173, 0, 255),new Color(185, 141, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.05267341062426567f, 0.05051613971590996f, -1.0577939748764038f, 1.1162339448928833f, 183.7751007080078f, -66.53858184814453f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_17_5);
g.setComposite(AlphaComposite.getInstance(3, 0.38604653f * origAlpha));
AffineTransform defaultTransform__0_0_17_6 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_6
shape = new GeneralPath();
((GeneralPath)shape).moveTo(51.110016, 72.54274);
((GeneralPath)shape).lineTo(49.799088, 73.96148);
((GeneralPath)shape).lineTo(49.749435, 74.01399);
((GeneralPath)shape).curveTo(50.042374, 74.305, 49.614532, 75.36211, 50.55457, 76.41053);
((GeneralPath)shape).lineTo(50.609352, 76.46152);
((GeneralPath)shape).lineTo(50.999664, 76.82481);
((GeneralPath)shape).lineTo(51.054443, 76.8758);
((GeneralPath)shape).curveTo(52.177227, 77.74745, 53.194927, 77.22099, 53.587288, 77.58618);
((GeneralPath)shape).lineTo(54.97567, 76.07579);
((GeneralPath)shape).lineTo(51.110016, 72.54274);
((GeneralPath)shape).closePath();
paint = new Color(37, 37, 37, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_17_6);
g.setComposite(AlphaComposite.getInstance(3, 0.35348833f * origAlpha));
AffineTransform defaultTransform__0_0_17_7 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_7
shape = new GeneralPath();
((GeneralPath)shape).moveTo(48.617046, 70.194466);
((GeneralPath)shape).lineTo(47.290016, 71.55189);
((GeneralPath)shape).curveTo(47.30377, 71.56464, 47.195457, 71.6829, 47.209263, 71.695755);
((GeneralPath)shape).curveTo(47.490852, 71.95785, 47.10021, 73.01444, 47.56853, 73.631195);
((GeneralPath)shape).lineTo(47.616467, 73.6758);
((GeneralPath)shape).lineTo(47.828735, 73.87338);
((GeneralPath)shape).lineTo(47.856133, 73.898865);
((GeneralPath)shape).curveTo(48.519268, 74.34269, 49.40944, 73.79045, 49.749435, 74.01399);
((GeneralPath)shape).lineTo(51.123253, 72.5272);
((GeneralPath)shape).lineTo(48.617046, 70.194466);
((GeneralPath)shape).closePath();
paint = new Color(19, 19, 19, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_17_7);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_17_8 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_8
shape = new GeneralPath();
((GeneralPath)shape).moveTo(47.968758, 73.50936);
((GeneralPath)shape).curveTo(48.65992, 74.13778, 49.501755, 73.54555, 49.867622, 73.886086);
((GeneralPath)shape).lineTo(115.08119, 3.171599);
((GeneralPath)shape).lineTo(112.53531, 0.8019672);
((GeneralPath)shape).lineTo(47.290775, 71.54999);
((GeneralPath)shape).curveTo(47.304752, 71.56292, 47.318485, 71.575775, 47.332504, 71.588844);
((GeneralPath)shape).curveTo(47.618553, 71.85508, 47.272434, 72.87611, 47.968758, 73.50936);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(11.326383590698242, 57.38399887084961), new Point2D.Double(14.493531227111816, 57.38399887084961), new float[] {0.0f,0.09292036f,0.5043171f,0.91571385f,1.0f}, new Color[] {new Color(154, 118, 0, 255),new Color(227, 173, 0, 255),new Color(255, 205, 44, 255),new Color(227, 173, 0, 255),new Color(185, 141, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.8565019965171814f, 0.7995359897613525f, -0.7966219782829285f, 0.8596339821815491f, 115.51229858398438f, -21.934789657592773f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_17_8);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_17_9 = g.getTransform();
g.transform(new AffineTransform(0.7325119972229004f, 0.6807540059089661f, -0.6807540059089661f, 0.7325119972229004f, 0.0f, 0.0f));
// _0_0_17_9
shape = new Rectangle2D.Double(82.99185180664062, -76.58556365966797, 12.154855728149414, 2.857365846633911);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_17_9);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_17_10 = g.getTransform();
g.transform(new AffineTransform(0.5626800060272217f, -0.6086120009422302f, -1.1555869579315186f, -1.0720690488815308f, 76.43843841552734f, 59.62858963012695f));
// _0_0_17_10
shape = new GeneralPath();
((GeneralPath)shape).moveTo(82.17284, 7.462277);
((GeneralPath)shape).curveTo(82.17284, 7.719914, 77.16889, 7.966999, 68.26182, 8.149176);
((GeneralPath)shape).curveTo(59.354736, 8.331353, 47.274147, 8.433699, 34.67764, 8.433699);
((GeneralPath)shape).curveTo(22.08113, 8.433699, 10.00054, 8.331353, 1.093463, 8.149176);
((GeneralPath)shape).curveTo(-7.8136144, 7.966999, -12.817558, 7.719914, -12.817558, 7.462277);
((GeneralPath)shape).curveTo(-12.817558, 7.20464, -7.8136144, 6.957555, 1.093463, 6.775378);
((GeneralPath)shape).curveTo(10.00054, 6.593201, 22.08113, 6.490855, 34.67764, 6.490855);
((GeneralPath)shape).curveTo(47.274147, 6.490855, 59.354736, 6.593201, 68.26182, 6.775378);
((GeneralPath)shape).curveTo(77.16889, 6.957555, 82.17284, 7.20464, 82.17284, 7.462277);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(34.67763900756836, 7.462276935577393), 47.595196f, new Point2D.Double(34.67763900756836, 7.462276935577393), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 174),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9999139904975891f, -0.007841645739972591f, 5.666079232469201E-4f, 0.02048305980861187f, -0.0012422340223565698f, 7.581357002258301f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_17_10);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_17_11 = g.getTransform();
g.transform(new AffineTransform(0.46591898798942566f, -0.5057169795036316f, -0.8370239734649658f, -0.7796880006790161f, 72.02738952636719f, 62.118621826171875f));
// _0_0_17_11
shape = new GeneralPath();
((GeneralPath)shape).moveTo(106.56087, 7.462277);
((GeneralPath)shape).curveTo(106.5609, 7.694624, 74.720764, 7.8834887, 35.24227, 7.8853135);
((GeneralPath)shape).curveTo(-4.2362256, 7.8871384, -36.57657, 7.701241, -37.196724, 7.4689226);
((GeneralPath)shape).curveTo(-37.816895, 7.236604, -6.484828, 7.04482, 32.98388, 7.0393453);
((GeneralPath)shape).curveTo(72.45259, 7.0338707, 105.28513, 7.216755, 106.52539, 7.448987);
paint = new RadialGradientPaint(new Point2D.Double(34.67763900756836, 7.462276935577393), 47.595196f, new Point2D.Double(34.67763900756836, 7.462276935577393), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-1.5103000402450562f, 0.0026412729639559984f, -1.1670780077110976E-4f, -0.009110224433243275f, 87.05220031738281f, 7.438665866851807f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_17_11);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_17_12 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_12
shape = new GeneralPath();
((GeneralPath)shape).moveTo(108.38485, 5.30161);
((GeneralPath)shape).curveTo(107.12716, 6.0907826, 105.93515, 7.4663906, 105.29482, 8.645764);
((GeneralPath)shape).lineTo(112.44928, 15.244444);
((GeneralPath)shape).lineTo(115.5393, 11.90029);
((GeneralPath)shape).lineTo(108.38485, 5.30161);
((GeneralPath)shape).closePath();
((GeneralPath)shape).moveTo(114.78737, 11.200422);
((GeneralPath)shape).lineTo(111.69734, 14.544576);
((GeneralPath)shape).lineTo(114.20374, 16.877474);
((GeneralPath)shape).curveTo(115.29929, 16.218853, 116.5563, 14.908329, 117.29377, 13.533321);
((GeneralPath)shape).lineTo(114.78737, 11.200422);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(49.009883880615234, 8.495312690734863), 3.9750404f, new Point2D.Double(47.370887756347656, 6.770169734954834), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(174, 174, 174, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.1124390363693237f, 1.0354360342025757f, -0.38867801427841187f, 0.42064398527145386f, 60.10820007324219f, -43.230560302734375f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_17_12);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_17_13 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_13
shape = new GeneralPath();
((GeneralPath)shape).moveTo(42.27053, 89.82674);
((GeneralPath)shape).curveTo(40.6429, 89.66667, 39.24413, 87.19937, 38.343975, 86.4445);
((GeneralPath)shape).lineTo(31.84288, 97.22175);
((GeneralPath)shape).lineTo(42.27053, 89.82674);
((GeneralPath)shape).closePath();
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_17_13);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_17_14 = g.getTransform();
g.transform(new AffineTransform(0.7319869995117188f, 0.681318998336792f, -0.6786490082740784f, 0.7344629764556885f, 0.0f, 0.0f));
// _0_0_17_14
shape = new Rectangle2D.Double(86.6741943359375, -77.08168029785156, 5.241995811462402, 1.1477652788162231);
paint = new RadialGradientPaint(new Point2D.Double(49.01197052001953, 2.6743078231811523), 1.7246193f, new Point2D.Double(49.01197052001953, 2.6743078231811523), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(37, 37, 37, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.5197540521621704f, 0.0f, 0.0f, 0.18494200706481934f, 14.809029579162598f, -77.11570739746094f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_17_14);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_17_15 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_15
shape = new GeneralPath();
((GeneralPath)shape).moveTo(118.05347, 2.2273397);
((GeneralPath)shape).curveTo(119.90131, 3.702737, 121.20567, 5.718846, 121.27612, 5.9115605);
((GeneralPath)shape).curveTo(121.34655, 6.104276, 119.56393, 3.843466, 118.03439, 2.796435);
((GeneralPath)shape).curveTo(116.51655, 1.7573994, 114.37282, 1.6966459, 114.21641, 1.5706147);
((GeneralPath)shape).curveTo(114.06, 1.4445845, 113.0071, 0.2936384, 113.97851, 0.35151747);
((GeneralPath)shape).curveTo(114.99456, 0.4120566, 116.62619, 1.0887976, 118.05347, 2.2273397);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(48.49856185913086, 0.8115049600601196), new Point2D.Double(48.732723236083984, 2.365726947784424), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.1124390363693237f, 1.0354360342025757f, -1.031662940979004f, 1.1165070533752441f, 65.5705337524414f, -49.14213943481445f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_17_15);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_17_16 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_16
shape = new GeneralPath();
((GeneralPath)shape).moveTo(60.938377, 71.52827);
((GeneralPath)shape).curveTo(60.73753, 71.74541, 60.6241, 71.95325, 60.59806, 72.15179);
((GeneralPath)shape).curveTo(60.57203, 72.35035, 60.635857, 72.52122, 60.78954, 72.66441);
((GeneralPath)shape).curveTo(60.942577, 72.807, 61.116776, 72.85789, 61.31212, 72.817116);
((GeneralPath)shape).curveTo(61.50747, 72.7763, 61.705563, 72.647354, 61.906403, 72.43022);
((GeneralPath)shape).curveTo(62.1084, 72.21184, 62.222393, 72.00339, 62.24844, 71.80483);
((GeneralPath)shape).curveTo(62.274467, 71.60627, 62.210957, 71.435715, 62.057926, 71.29312);
((GeneralPath)shape).curveTo(61.904236, 71.149925, 61.72972, 71.09873, 61.534374, 71.13953);
((GeneralPath)shape).curveTo(61.339027, 71.18031, 61.140366, 71.30989, 60.938377, 71.52827);
((GeneralPath)shape).moveTo(60.665848, 71.27432);
((GeneralPath)shape).curveTo(61.076664, 70.83019, 61.465534, 70.54477, 61.83248, 70.41808);
((GeneralPath)shape).curveTo(62.199417, 70.2914, 62.50109, 70.338196, 62.737476, 70.55844);
((GeneralPath)shape).curveTo(62.973213, 70.7781, 63.041763, 71.07625, 62.943127, 71.45292);
((GeneralPath)shape).curveTo(62.844475, 71.8296, 62.58975, 72.24, 62.178932, 72.68414);
((GeneralPath)shape).curveTo(61.76926, 73.12704, 61.38039, 73.41246, 61.0123, 73.54039);
((GeneralPath)shape).curveTo(60.645363, 73.66707, 60.344025, 73.62059, 60.108276, 73.40094);
((GeneralPath)shape).curveTo(59.87189, 73.180695, 59.803017, 72.882225, 59.901665, 72.50556);
((GeneralPath)shape).curveTo(60.00145, 72.127655, 60.256176, 71.71725, 60.665848, 71.27432);
((GeneralPath)shape).moveTo(64.51818, 68.599846);
((GeneralPath)shape).lineTo(66.14919, 68.33476);
((GeneralPath)shape).lineTo(65.46278, 69.07686);
((GeneralPath)shape).lineTo(64.367226, 69.25853);
((GeneralPath)shape).lineTo(64.27315, 70.363014);
((GeneralPath)shape).lineTo(63.58333, 71.108795);
((GeneralPath)shape).lineTo(63.725643, 69.45667);
((GeneralPath)shape).lineTo(62.15916, 69.71296);
((GeneralPath)shape).lineTo(62.84727, 68.96902);
((GeneralPath)shape).lineTo(63.87685, 68.80165);
((GeneralPath)shape).lineTo(63.965027, 67.76058);
((GeneralPath)shape).lineTo(64.65656, 67.01295);
((GeneralPath)shape).lineTo(64.51818, 68.599846);
((GeneralPath)shape).moveTo(64.728455, 66.93522);
((GeneralPath)shape).lineTo(65.44908, 66.15612);
((GeneralPath)shape).lineTo(66.550735, 66.01111);
((GeneralPath)shape).lineTo(66.61305, 64.89771);
((GeneralPath)shape).lineTo(67.335396, 64.11677);
((GeneralPath)shape).lineTo(67.20541, 65.95611);
((GeneralPath)shape).lineTo(67.81983, 66.52859);
((GeneralPath)shape).lineTo(67.16081, 67.24108);
((GeneralPath)shape).lineTo(66.54639, 66.66859);
((GeneralPath)shape).lineTo(64.728455, 66.93522);
((GeneralPath)shape).moveTo(71.26493, 62.585747);
((GeneralPath)shape).curveTo(71.14618, 62.80587, 71.009766, 63.022163, 70.85569, 63.234623);
((GeneralPath)shape).curveTo(70.7016, 63.447098, 70.53041, 63.655117, 70.342125, 63.858673);
((GeneralPath)shape).curveTo(69.91647, 64.318855, 69.51154, 64.62031, 69.12732, 64.76306);
((GeneralPath)shape).curveTo(68.742455, 64.90522, 68.43377, 64.867966, 68.20129, 64.65136);
((GeneralPath)shape).curveTo(67.96619, 64.43231, 67.90791, 64.12305, 68.02646, 63.72357);
((GeneralPath)shape).curveTo(68.14498, 63.32407, 68.4245, 62.886227, 68.864975, 62.410007);
((GeneralPath)shape).curveTo(69.03501, 62.226185, 69.20674, 62.05886, 69.38017, 61.90807);
((GeneralPath)shape).curveTo(69.55474, 61.756035, 69.72897, 61.622086, 69.90286, 61.50615);
((GeneralPath)shape).lineTo(70.20471, 61.787403);
((GeneralPath)shape).curveTo(70.01582, 61.898533, 69.83924, 62.019974, 69.67494, 62.151714);
((GeneralPath)shape).curveTo(69.511795, 62.28222, 69.35945, 62.42398, 69.21796, 62.576958);
((GeneralPath)shape).curveTo(68.9555, 62.860714, 68.79495, 63.11883, 68.73631, 63.35132);
((GeneralPath)shape).curveTo(68.67817, 63.581974, 68.72691, 63.769814, 68.88255, 63.914814);
((GeneralPath)shape).curveTo(69.03689, 64.058624, 69.22454, 64.09563, 69.44549, 64.02586);
((GeneralPath)shape).curveTo(69.66642, 63.95608, 69.902985, 63.784878, 70.15518, 63.51221);
((GeneralPath)shape).curveTo(70.22364, 63.438206, 70.2847, 63.367607, 70.33834, 63.300423);
((GeneralPath)shape).curveTo(70.39247, 63.231426, 70.43773, 63.166767, 70.47408, 63.106483);
((GeneralPath)shape).lineTo(70.19081, 62.842533);
((GeneralPath)shape).lineTo(69.78855, 63.27743);
((GeneralPath)shape).lineTo(69.53654, 63.042618);
((GeneralPath)shape).lineTo(70.56357, 61.932266);
((GeneralPath)shape).lineTo(71.26493, 62.585747);
((GeneralPath)shape).moveTo(70.49352, 60.702435);
((GeneralPath)shape).lineTo(72.271996, 58.77967);
((GeneralPath)shape).lineTo(72.556244, 59.044506);
((GeneralPath)shape).lineTo(71.43678, 60.254795);
((GeneralPath)shape).lineTo(71.708336, 60.507816);
((GeneralPath)shape).lineTo(72.76105, 59.369705);
((GeneralPath)shape).lineTo(73.0453, 59.634552);
((GeneralPath)shape).lineTo(71.99259, 60.772663);
((GeneralPath)shape).lineTo(72.326675, 61.08394);
((GeneralPath)shape).lineTo(73.483795, 59.832943);
((GeneralPath)shape).lineTo(73.76805, 60.097794);
((GeneralPath)shape).lineTo(71.95191, 62.061275);
((GeneralPath)shape).lineTo(70.49352, 60.702435);
((GeneralPath)shape).moveTo(72.88993, 58.1116);
((GeneralPath)shape).lineTo(73.62597, 57.31584);
((GeneralPath)shape).lineTo(75.555695, 57.24295);
((GeneralPath)shape).lineTo(74.555435, 56.31097);
((GeneralPath)shape).lineTo(75.18021, 55.63551);
((GeneralPath)shape).lineTo(76.6386, 56.99435);
((GeneralPath)shape).lineTo(75.902565, 57.790108);
((GeneralPath)shape).lineTo(73.97283, 57.862988);
((GeneralPath)shape).lineTo(74.9731, 58.79498);
((GeneralPath)shape).lineTo(74.34832, 59.47044);
((GeneralPath)shape).lineTo(72.88993, 58.1116);
((GeneralPath)shape).moveTo(77.03914, 53.62577);
((GeneralPath)shape).lineTo(77.77517, 52.830025);
((GeneralPath)shape).lineTo(79.7049, 52.757122);
((GeneralPath)shape).lineTo(78.704636, 51.825153);
((GeneralPath)shape).lineTo(79.329414, 51.14968);
((GeneralPath)shape).lineTo(80.7878, 52.50852);
((GeneralPath)shape).lineTo(80.05177, 53.304276);
((GeneralPath)shape).lineTo(78.12203, 53.377155);
((GeneralPath)shape).lineTo(79.12231, 54.30915);
((GeneralPath)shape).lineTo(78.49753, 54.98461);
((GeneralPath)shape).lineTo(77.03914, 53.62577);
((GeneralPath)shape).moveTo(80.61079, 49.711254);
((GeneralPath)shape).curveTo(80.85386, 49.448483, 81.0817, 49.27488, 81.29436, 49.190475);
((GeneralPath)shape).curveTo(81.50815, 49.104855, 81.676895, 49.119675, 81.80064, 49.234962);
((GeneralPath)shape).curveTo(81.924355, 49.350246, 81.95186, 49.51713, 81.88313, 49.735622);
((GeneralPath)shape).curveTo(81.81441, 49.954124, 81.65794, 50.195374, 81.41374, 50.45939);
((GeneralPath)shape).curveTo(81.16953, 50.72341, 80.940865, 50.89854, 80.72772, 50.98477);
((GeneralPath)shape).curveTo(80.51573, 51.06978, 80.34786, 51.054638, 80.22414, 50.939354);
((GeneralPath)shape).curveTo(80.1004, 50.82407, 80.072586, 50.656876, 80.140656, 50.437775);
((GeneralPath)shape).curveTo(80.20988, 50.217445, 80.36659, 49.97528, 80.61079, 49.711254);
((GeneralPath)shape).moveTo(80.83062, 51.3356);
((GeneralPath)shape).lineTo(82.239365, 49.81257);
((GeneralPath)shape).lineTo(82.43472, 49.99459);
((GeneralPath)shape).lineTo(81.02598, 51.51763);
((GeneralPath)shape).lineTo(80.83062, 51.3356);
((GeneralPath)shape).moveTo(80.77685, 49.865974);
((GeneralPath)shape).curveTo(80.681, 49.96962, 80.62734, 50.068924, 80.61587, 50.16389);
((GeneralPath)shape).curveTo(80.60554, 50.25764, 80.63815, 50.339703, 80.71369, 50.410088);
((GeneralPath)shape).curveTo(80.78923, 50.480473, 80.87286, 50.506714, 80.9646, 50.488815);
((GeneralPath)shape).curveTo(81.05746, 50.46969, 81.151825, 50.408302, 81.24767, 50.30466);
((GeneralPath)shape).curveTo(81.3424, 50.20227, 81.39524, 50.104504, 81.40622, 50.01136);
((GeneralPath)shape).curveTo(81.418335, 49.916992, 81.38662, 49.834614, 81.31108, 49.76423);
((GeneralPath)shape).curveTo(81.23554, 49.693848, 81.15101, 49.66792, 81.05749, 49.68644);
((GeneralPath)shape).curveTo(80.96512, 49.703743, 80.87157, 49.763584, 80.77685, 49.865974);
((GeneralPath)shape).moveTo(85.14347, 46.21668);
((GeneralPath)shape).curveTo(85.34118, 46.054058, 85.51612, 45.954056, 85.6683, 45.916676);
((GeneralPath)shape).curveTo(85.82097, 45.877464, 85.945816, 45.90306, 86.04285, 45.99347);
((GeneralPath)shape).curveTo(86.187416, 46.128166, 86.20047, 46.33557, 86.082016, 46.61569);
((GeneralPath)shape).curveTo(85.96291, 46.895203, 85.71735, 47.236057, 85.34534, 47.63825);
((GeneralPath)shape).curveTo(85.21411, 47.78013, 85.076126, 47.916866, 84.93137, 48.048443);
((GeneralPath)shape).curveTo(84.78842, 48.179405, 84.64043, 48.303364, 84.48739, 48.420326);
((GeneralPath)shape).lineTo(84.19726, 48.150005);
((GeneralPath)shape).curveTo(84.355675, 48.049538, 84.50447, 47.9424, 84.64367, 47.828613);
((GeneralPath)shape).curveTo(84.783356, 47.71299, 84.91197, 47.59164, 85.0295, 47.46457);
((GeneralPath)shape).curveTo(85.204094, 47.27581, 85.32036, 47.11538, 85.37828, 46.98329);
((GeneralPath)shape).curveTo(85.43733, 46.849964, 85.43463, 46.75327, 85.370155, 46.693195);
((GeneralPath)shape).curveTo(85.303734, 46.631313, 85.20566, 46.636402, 85.07594, 46.708485);
((GeneralPath)shape).curveTo(84.94671, 46.77873, 84.7891, 46.9144, 84.60309, 47.115498);
((GeneralPath)shape).lineTo(84.339485, 47.400486);
((GeneralPath)shape).lineTo(84.09724, 47.17477);
((GeneralPath)shape).lineTo(84.374535, 46.874977);
((GeneralPath)shape).curveTo(84.54, 46.69609, 84.64859, 46.5492, 84.7003, 46.43429);
((GeneralPath)shape).curveTo(84.75137, 46.31879, 84.74662, 46.232822, 84.686066, 46.176395);
((GeneralPath)shape).curveTo(84.63005, 46.12421, 84.547386, 46.126427, 84.438034, 46.183033);
((GeneralPath)shape).curveTo(84.32869, 46.239647, 84.202126, 46.345673, 84.058334, 46.501118);
((GeneralPath)shape).curveTo(83.95222, 46.615864, 83.85178, 46.738205, 83.75705, 46.86814);
((GeneralPath)shape).curveTo(83.662315, 46.998096, 83.57467, 47.13349, 83.494095, 47.27433);
((GeneralPath)shape).lineTo(83.218636, 47.017677);
((GeneralPath)shape).curveTo(83.32789, 46.857616, 83.44121, 46.703648, 83.55859, 46.55575);
((GeneralPath)shape).curveTo(83.67598, 46.407875, 83.7963, 46.267315, 83.91954, 46.134064);
((GeneralPath)shape).curveTo(84.25162, 45.77506, 84.53107, 45.535835, 84.75791, 45.416428);
((GeneralPath)shape).curveTo(84.985245, 45.295185, 85.16143, 45.29281, 85.28646, 45.4093);
((GeneralPath)shape).curveTo(85.37177, 45.488796, 85.40241, 45.596592, 85.37837, 45.73268);
((GeneralPath)shape).curveTo(85.353676, 45.86816, 85.275375, 46.0295, 85.14347, 46.21668);
paint = new LinearGradientPaint(new Point2D.Double(49.15303039550781, 75.31031799316406), new Point2D.Double(82.4846420288086, 75.31031799316406), new float[] {0.0f,1.0f}, new Color[] {new Color(180, 148, 42, 255),new Color(228, 220, 201, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.7891589999198914f, 0.0f, 0.0f, 0.7891589999198914f, 21.068540573120117f, 0.03497228026390076f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_17_16);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_17_17 = g.getTransform();
g.transform(new AffineTransform(0.6852189898490906f, 0.7283369898796082f, -0.7822719812393188f, 0.622937023639679f, 0.0f, 0.0f));
// _0_0_17_17
shape = new Rectangle2D.Double(70.87551879882812, -82.5947265625, 3.594980239868164, 0.7820525765419006);
paint = new RadialGradientPaint(new Point2D.Double(49.01197052001953, 2.6743078231811523), 1.7246193f, new Point2D.Double(49.01197052001953, 2.6743078231811523), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(37, 37, 37, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0422539710998535f, 0.0f, 0.0f, 0.12601399421691895f, 21.590139389038086f, -82.61791229248047f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_17_17);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_17_18 = g.getTransform();
g.transform(new AffineTransform(-0.743170976638794f, -0.6691009998321533f, -0.6056519746780396f, 0.7957289814949036f, 0.0f, 0.0f));
// _0_0_17_18
shape = new Rectangle2D.Double(-102.7270736694336, -75.745849609375, 3.5949740409851074, 0.7820497751235962);
paint = new RadialGradientPaint(new Point2D.Double(49.01197052001953, 2.6743078231811523), 1.7246193f, new Point2D.Double(49.01197052001953, 2.6743078231811523), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(37, 37, 37, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.042253017425537f, 0.0f, 0.0f, 0.12601399421691895f, -152.01229858398438f, -75.76904296875f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_17_18);
g.setTransform(defaultTransform__0_0_17);
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
        return 3.9999637603759766;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 0.671695351600647;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 120.0;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 115.32830810546875;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private select_rectangular2() {
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
       select_rectangular2 base = new select_rectangular2();
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
       select_rectangular2 base = new select_rectangular2();
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
        return select_rectangular2::new;
    }
}

