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
public class preferences_desktop_2 implements ResizableIcon {
    

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
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -0.75f, 0.0f));
// _0_0_0
g.setComposite(AlphaComposite.getInstance(3, 0.85294116f * origAlpha));
AffineTransform defaultTransform__0_0_0_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0
shape = new Rectangle2D.Double(8.344184875488281, 31.66289710998535, 32.36289596557617, 11.482156753540039);
paint = new LinearGradientPaint(new Point2D.Double(302.8571472167969, 366.64788818359375), new Point2D.Double(302.8571472167969, 609.5050659179688), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(0, 0, 0, 0),new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.06702374666929245f, 0.0f, 0.0f, 0.047279469668865204f, 0.30133509635925293f, 14.327980041503906f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 0.85294116f * origAlpha));
AffineTransform defaultTransform__0_0_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(40.70708, 31.663294);
((GeneralPath)shape).curveTo(40.70708, 31.663294, 40.70708, 43.144817, 40.70708, 43.144817);
((GeneralPath)shape).curveTo(44.158638, 43.16643, 49.05127, 40.572388, 49.051266, 37.403316);
((GeneralPath)shape).curveTo(49.051266, 34.23424, 45.19959, 31.663294, 40.70708, 31.663294);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(605.7142944335938, 486.64788818359375), 117.14286f, new Point2D.Double(605.7142944335938, 486.64788818359375), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.06702374666929245f, 0.0f, 0.0f, 0.047279469668865204f, 0.31452539563179016f, 14.327980041503906f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0_1);
g.setComposite(AlphaComposite.getInstance(3, 0.85294116f * origAlpha));
AffineTransform defaultTransform__0_0_0_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(8.344186, 31.663294);
((GeneralPath)shape).curveTo(8.344186, 31.663294, 8.344186, 43.144817, 8.344186, 43.144817);
((GeneralPath)shape).curveTo(4.8926277, 43.16643, 2.6449978E-9, 40.572388, 2.6449978E-9, 37.403316);
((GeneralPath)shape).curveTo(2.6449978E-9, 34.23424, 3.8516777, 31.663294, 8.344186, 31.663294);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(605.7142944335938, 486.64788818359375), 117.14286f, new Point2D.Double(605.7142944335938, 486.64788818359375), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-0.06702374666929245f, 0.0f, 0.0f, 0.047279469668865204f, 48.736751556396484f, 14.327980041503906f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0_2);
g.setTransform(defaultTransform__0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
paint = new Color(136, 138, 133, 255);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(9.022859, 9.0);
((GeneralPath)shape).curveTo(8.395477, 9.0, 7.9876804, 9.293946, 7.7367287, 9.854703);
((GeneralPath)shape).curveTo(7.7367277, 9.854703, 3.2509522, 29.876846, 3.2509522, 29.876846);
((GeneralPath)shape).curveTo(3.2509522, 29.876846, 3.0, 30.55712, 3.0, 31.681213);
((GeneralPath)shape).curveTo(3.0, 31.681213, 3.0, 37.404507, 3.0, 37.404507);
((GeneralPath)shape).curveTo(3.0, 38.50117, 3.6602912, 39.0506, 4.6625605, 39.050594);
((GeneralPath)shape).lineTo(43.371986, 39.050594);
((GeneralPath)shape).curveTo(44.360588, 39.050594, 44.971806, 38.323093, 44.971806, 37.18292);
((GeneralPath)shape).lineTo(44.971806, 31.459623);
((GeneralPath)shape).curveTo(44.971806, 31.459623, 45.078175, 30.679201, 44.8777, 30.13009);
((GeneralPath)shape).lineTo(40.140972, 10.012982);
((GeneralPath)shape).curveTo(39.95574, 9.494432, 39.50164, 9.012061, 39.011684, 9.0);
((GeneralPath)shape).lineTo(9.022859, 9.0);
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
((GeneralPath)shape).moveTo(3.0, 31.081251);
((GeneralPath)shape).lineTo(3.7675865, 30.389036);
((GeneralPath)shape).lineTo(41.52408, 30.451536);
((GeneralPath)shape).lineTo(45.0, 30.768835);
((GeneralPath)shape).lineTo(45.0, 37.207367);
((GeneralPath)shape).curveTo(45.0, 38.332935, 44.390614, 39.050697, 43.401917, 39.050697);
((GeneralPath)shape).lineTo(4.668326, 39.050697);
((GeneralPath)shape).curveTo(3.6659644, 39.050697, 3.0, 38.508648, 3.0, 37.426033);
((GeneralPath)shape).lineTo(3.0, 31.081251);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(7.604620456695557, 28.481176376342773), new Point2D.Double(36.183067321777344, 40.94393539428711), new float[] {0.0f,1.0f}, new Color[] {new Color(217, 217, 217, 255),new Color(199, 199, 199, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0039033889770508f, 0.0f, 0.0f, 1.0f, -0.2863698899745941f, 4.084438800811768f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3
shape = new GeneralPath();
((GeneralPath)shape).moveTo(3.289293, 29.978281);
((GeneralPath)shape).curveTo(2.5728183, 31.45515, 3.2886763, 32.3917, 4.328183, 32.3917);
((GeneralPath)shape).curveTo(4.328183, 32.3917, 43.447746, 32.3917, 43.447746, 32.3917);
((GeneralPath)shape).curveTo(44.570225, 32.367687, 45.29864, 31.3711, 44.880695, 30.230429);
((GeneralPath)shape).lineTo(40.151955, 10.008597);
((GeneralPath)shape).curveTo(39.966866, 9.492291, 39.495186, 9.012007, 39.005596, 9.0);
((GeneralPath)shape).lineTo(9.056921, 9.0);
((GeneralPath)shape).curveTo(8.430004, 9.0, 8.018031, 9.306182, 7.767266, 9.864512);
((GeneralPath)shape).curveTo(7.767266, 9.864512, 3.289293, 29.978281, 3.289293, 29.978281);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(15.571491241455078, 2.9585189819335938), 20.935818f, new Point2D.Double(15.571491241455078, 2.9585189819335938), new float[] {0.0f,1.0f}, new Color[] {new Color(240, 240, 240, 255),new Color(224, 224, 224, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.2901853322982788f, 0.7884153723716736f, -0.7129610776901245f, 1.1796022653579712f, -2.632237195968628f, -1.0775827169418335f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_3);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
shape = new GeneralPath();
((GeneralPath)shape).moveTo(44.85227, 29.713127);
((GeneralPath)shape).curveTo(44.916294, 30.963102, 44.435, 32.02897, 43.51973, 32.056877);
((GeneralPath)shape).curveTo(43.51973, 32.056877, 5.100482, 32.056877, 5.100482, 32.056877);
((GeneralPath)shape).curveTo(3.8010855, 32.056877, 3.2180204, 31.731932, 3.0, 31.188822);
((GeneralPath)shape).curveTo(3.0924845, 32.133156, 3.8323278, 32.838127, 5.100482, 32.838127);
((GeneralPath)shape).curveTo(5.100482, 32.838127, 43.51973, 32.838127, 43.51973, 32.838127);
((GeneralPath)shape).curveTo(44.60422, 32.805058, 45.286354, 31.414104, 44.882553, 29.843336);
((GeneralPath)shape).lineTo(44.85227, 29.713127);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_4);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_5 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5
shape = new GeneralPath();
((GeneralPath)shape).moveTo(10.981036, 11.962093);
((GeneralPath)shape).lineTo(16.007055, 11.962093);
((GeneralPath)shape).lineTo(14.592842, 29.183918);
((GeneralPath)shape).lineTo(8.152609, 29.183918);
((GeneralPath)shape).lineTo(10.981036, 11.962093);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(12.513010025024414, 30.585786819458008), new Point2D.Double(12.513010025024414, 16.885591506958008), new float[] {0.0f,1.0f}, new Color[] {new Color(103, 117, 121, 255),new Color(51, 51, 51, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.5876039862632751f, -1.1402790546417236f, 9.808271408081055f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_5);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_6 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6
shape = new GeneralPath();
((GeneralPath)shape).moveTo(36.397034, 11.962093);
((GeneralPath)shape).lineTo(31.371016, 11.962093);
((GeneralPath)shape).lineTo(32.78523, 29.183918);
((GeneralPath)shape).lineTo(39.225464, 29.183918);
((GeneralPath)shape).lineTo(36.397034, 11.962093);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(12.513010025024414, 30.585786819458008), new Point2D.Double(12.513010025024414, 16.885591506958008), new float[] {0.0f,1.0f}, new Color[] {new Color(103, 117, 121, 255),new Color(51, 51, 51, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-1.0f, 0.0f, 0.0f, 0.5876039862632751f, 48.518348693847656f, 9.808271408081055f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_6);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_7 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
shape = new GeneralPath();
((GeneralPath)shape).moveTo(21.0, 12.02602);
((GeneralPath)shape).lineTo(26.026018, 12.02602);
((GeneralPath)shape).lineTo(26.963518, 29.0);
((GeneralPath)shape).lineTo(20.0625, 29.0);
((GeneralPath)shape).lineTo(21.0, 12.02602);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(12.513010025024414, 30.585786819458008), new Point2D.Double(12.513010025024414, 23.635591506958008), new float[] {0.0f,1.0f}, new Color[] {new Color(103, 117, 121, 255),new Color(51, 51, 51, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 10.999998092651367f, -3.9739816188812256f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_7);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_8 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -1.0f, -2.0f));
// _0_0_8
g.setComposite(AlphaComposite.getInstance(3, 0.3647059f * origAlpha));
AffineTransform defaultTransform__0_0_8_0 = g.getTransform();
g.transform(new AffineTransform(1.0873786211013794f, 0.0f, 0.0f, 1.0873786211013794f, -2.146237850189209f, -2.6541261672973633f));
// _0_0_8_0
shape = new RoundRectangle2D.Double(18.125, 28.625, 12.875, 3.5, 3.5, 3.5);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_8_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_8_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(28.0625, 23.0);
((GeneralPath)shape).lineTo(20.5, 23.09375);
((GeneralPath)shape).lineTo(20.125, 23.71875);
((GeneralPath)shape).lineTo(18.875, 30.9375);
((GeneralPath)shape).lineTo(18.90625, 31.0);
((GeneralPath)shape).lineTo(30.0625, 31.0);
((GeneralPath)shape).lineTo(28.65625, 24.75);
((GeneralPath)shape).lineTo(28.0625, 23.0);
((GeneralPath)shape).closePath();
paint = new Color(186, 189, 182, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(85, 87, 83, 255);
stroke = new BasicStroke(1.0f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(28.0625, 23.0);
((GeneralPath)shape).lineTo(20.5, 23.09375);
((GeneralPath)shape).lineTo(20.125, 23.71875);
((GeneralPath)shape).lineTo(18.875, 30.9375);
((GeneralPath)shape).lineTo(18.90625, 31.0);
((GeneralPath)shape).lineTo(30.0625, 31.0);
((GeneralPath)shape).lineTo(28.65625, 24.75);
((GeneralPath)shape).lineTo(28.0625, 23.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_8_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_8_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(18.915106, 30.985245);
((GeneralPath)shape).lineTo(30.052038, 30.985245);
((GeneralPath)shape).lineTo(28.637825, 24.930641);
((GeneralPath)shape).lineTo(20.152542, 25.01903);
((GeneralPath)shape).lineTo(18.915106, 30.985245);
((GeneralPath)shape).closePath();
paint = new Color(186, 189, 182, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_8_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_8_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8_3
shape = new GeneralPath();
((GeneralPath)shape).moveTo(20.513865, 23.088388);
((GeneralPath)shape).lineTo(20.071737, 25.024391);
((GeneralPath)shape).lineTo(28.624882, 25.042698);
((GeneralPath)shape).lineTo(28.0633, 22.986097);
((GeneralPath)shape).lineTo(20.513865, 23.088388);
((GeneralPath)shape).closePath();
paint = new Color(238, 238, 236, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_8_3);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_8_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8_4
shape = new GeneralPath();
((GeneralPath)shape).moveTo(20.461903, 23.11868);
((GeneralPath)shape).lineTo(20.135769, 23.716759);
((GeneralPath)shape).lineTo(18.870913, 30.94105);
((GeneralPath)shape).lineTo(19.939156, 26.005165);
((GeneralPath)shape).lineTo(28.895407, 26.010527);
((GeneralPath)shape).lineTo(28.687382, 24.99092);
((GeneralPath)shape).lineTo(20.178432, 24.967253);
((GeneralPath)shape).lineTo(20.461903, 23.11868);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_8_4);
g.setTransform(defaultTransform__0_0_8);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_9 = g.getTransform();
g.transform(new AffineTransform(0.964285671710968f, 0.0f, 0.0f, 0.964285671710968f, -10.391072273254395f, -11.813166618347168f));
// _0_0_9
g.setComposite(AlphaComposite.getInstance(3, 0.3647059f * origAlpha));
AffineTransform defaultTransform__0_0_9_0 = g.getTransform();
g.transform(new AffineTransform(1.0873786211013794f, 0.0f, 0.0f, 1.0873786211013794f, -2.146237850189209f, -2.6541261672973633f));
// _0_0_9_0
shape = new RoundRectangle2D.Double(18.125, 28.625, 12.875, 3.5, 3.5, 3.5);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_9_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_9_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(28.0625, 23.1875);
((GeneralPath)shape).lineTo(20.5, 23.09375);
((GeneralPath)shape).lineTo(20.125, 23.71875);
((GeneralPath)shape).lineTo(18.875, 30.9375);
((GeneralPath)shape).lineTo(18.90625, 31.0);
((GeneralPath)shape).lineTo(30.0625, 31.0);
((GeneralPath)shape).lineTo(28.65625, 24.75);
((GeneralPath)shape).lineTo(28.0625, 23.1875);
((GeneralPath)shape).closePath();
paint = new Color(186, 189, 182, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(85, 87, 83, 255);
stroke = new BasicStroke(1.037037f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(28.0625, 23.1875);
((GeneralPath)shape).lineTo(20.5, 23.09375);
((GeneralPath)shape).lineTo(20.125, 23.71875);
((GeneralPath)shape).lineTo(18.875, 30.9375);
((GeneralPath)shape).lineTo(18.90625, 31.0);
((GeneralPath)shape).lineTo(30.0625, 31.0);
((GeneralPath)shape).lineTo(28.65625, 24.75);
((GeneralPath)shape).lineTo(28.0625, 23.1875);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_9_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_9_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(18.915106, 30.985245);
((GeneralPath)shape).lineTo(30.052038, 30.985245);
((GeneralPath)shape).lineTo(28.637825, 24.930641);
((GeneralPath)shape).lineTo(20.152542, 25.01903);
((GeneralPath)shape).lineTo(18.915106, 30.985245);
((GeneralPath)shape).closePath();
paint = new Color(186, 189, 182, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_9_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_9_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9_3
shape = new GeneralPath();
((GeneralPath)shape).moveTo(20.513865, 23.088388);
((GeneralPath)shape).lineTo(20.071737, 25.024391);
((GeneralPath)shape).lineTo(28.624882, 25.042698);
((GeneralPath)shape).lineTo(28.0633, 23.173597);
((GeneralPath)shape).lineTo(20.513865, 23.088388);
((GeneralPath)shape).closePath();
paint = new Color(238, 238, 236, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_9_3);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_9_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9_4
shape = new GeneralPath();
((GeneralPath)shape).moveTo(20.461903, 23.11868);
((GeneralPath)shape).lineTo(20.135769, 23.716759);
((GeneralPath)shape).lineTo(18.870913, 30.94105);
((GeneralPath)shape).lineTo(19.939156, 26.005165);
((GeneralPath)shape).lineTo(28.895407, 26.010527);
((GeneralPath)shape).lineTo(28.687382, 24.99092);
((GeneralPath)shape).lineTo(20.178432, 24.967253);
((GeneralPath)shape).lineTo(20.461903, 23.11868);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_9_4);
g.setTransform(defaultTransform__0_0_9);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_10 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 11.25f, -4.9375f));
// _0_0_10
g.setComposite(AlphaComposite.getInstance(3, 0.3647059f * origAlpha));
AffineTransform defaultTransform__0_0_10_0 = g.getTransform();
g.transform(new AffineTransform(1.0873786211013794f, 0.0f, 0.0f, 1.0873786211013794f, -2.146237850189209f, -2.6541261672973633f));
// _0_0_10_0
shape = new RoundRectangle2D.Double(18.125, 28.625, 12.875, 3.5, 3.5, 3.5);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_10_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_10_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(28.0625, 23.0);
((GeneralPath)shape).lineTo(20.5, 23.09375);
((GeneralPath)shape).lineTo(20.125, 23.71875);
((GeneralPath)shape).lineTo(18.875, 30.9375);
((GeneralPath)shape).lineTo(18.90625, 31.0);
((GeneralPath)shape).lineTo(30.0625, 31.0);
((GeneralPath)shape).lineTo(28.65625, 24.75);
((GeneralPath)shape).lineTo(28.0625, 23.0);
((GeneralPath)shape).closePath();
paint = new Color(186, 189, 182, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(85, 87, 83, 255);
stroke = new BasicStroke(1.0f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(28.0625, 23.0);
((GeneralPath)shape).lineTo(20.5, 23.09375);
((GeneralPath)shape).lineTo(20.125, 23.71875);
((GeneralPath)shape).lineTo(18.875, 30.9375);
((GeneralPath)shape).lineTo(18.90625, 31.0);
((GeneralPath)shape).lineTo(30.0625, 31.0);
((GeneralPath)shape).lineTo(28.65625, 24.75);
((GeneralPath)shape).lineTo(28.0625, 23.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_10_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_10_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(18.915106, 30.985245);
((GeneralPath)shape).lineTo(30.052038, 30.985245);
((GeneralPath)shape).lineTo(28.637825, 24.930641);
((GeneralPath)shape).lineTo(20.152542, 25.01903);
((GeneralPath)shape).lineTo(18.915106, 30.985245);
((GeneralPath)shape).closePath();
paint = new Color(186, 189, 182, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_10_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_10_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10_3
shape = new GeneralPath();
((GeneralPath)shape).moveTo(20.513865, 23.088388);
((GeneralPath)shape).lineTo(20.071737, 25.024391);
((GeneralPath)shape).lineTo(28.624882, 25.042698);
((GeneralPath)shape).lineTo(28.0633, 22.986097);
((GeneralPath)shape).lineTo(20.513865, 23.088388);
((GeneralPath)shape).closePath();
paint = new Color(238, 238, 236, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_10_3);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_10_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10_4
shape = new GeneralPath();
((GeneralPath)shape).moveTo(20.461903, 23.11868);
((GeneralPath)shape).lineTo(20.135769, 23.716759);
((GeneralPath)shape).lineTo(18.870913, 30.94105);
((GeneralPath)shape).lineTo(19.939156, 26.005165);
((GeneralPath)shape).lineTo(28.895407, 26.010527);
((GeneralPath)shape).lineTo(28.687382, 24.99092);
((GeneralPath)shape).lineTo(20.178432, 24.967253);
((GeneralPath)shape).lineTo(20.461903, 23.11868);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_10_4);
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
        return 8.0;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 48.0;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 35.16643142700195;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private preferences_desktop_2() {
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
       preferences_desktop_2 base = new preferences_desktop_2();
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
       preferences_desktop_2 base = new preferences_desktop_2();
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
        return preferences_desktop_2::new;
    }
}

