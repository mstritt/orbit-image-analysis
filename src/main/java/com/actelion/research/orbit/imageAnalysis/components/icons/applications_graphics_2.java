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
public class applications_graphics_2 implements ResizableIcon {
    

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
g.setComposite(AlphaComposite.getInstance(3, 0.1f * origAlpha));
AffineTransform defaultTransform__0_0_0 = g.getTransform();
g.transform(new AffineTransform(1.1094890832901f, 0.0f, 0.0f, 0.5479452013969421f, -1.7189780473709106f, 16.63527488708496f));
// _0_0_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(19.125, 46.0625);
((GeneralPath)shape).curveTo(19.138721, 47.697384, 17.509726, 49.21122, 14.854842, 50.03078);
((GeneralPath)shape).curveTo(12.199959, 50.85034, 8.925041, 50.85034, 6.270158, 50.03078);
((GeneralPath)shape).curveTo(3.6152742, 49.21122, 1.9862785, 47.697384, 2.0, 46.0625);
((GeneralPath)shape).curveTo(1.9862785, 44.427616, 3.6152742, 42.91378, 6.270158, 42.09422);
((GeneralPath)shape).curveTo(8.925041, 41.27466, 12.199959, 41.27466, 14.854842, 42.09422);
((GeneralPath)shape).curveTo(17.509726, 42.91378, 19.138721, 44.427616, 19.125, 46.0625);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(10.5625, 46.0625), 8.5625f, new Point2D.Double(10.5625, 46.0625), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.5328466892242432f, 0.0f, 21.518247604370117f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 0.30268195f * origAlpha));
AffineTransform defaultTransform__0_0_1 = g.getTransform();
g.transform(new AffineTransform(0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 0.0f));
// _0_0_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(-45.96966, 31.033003);
((GeneralPath)shape).curveTo(-45.96966, 22.35596, -45.44278, 14.0343075, -44.504925, 7.898713);
((GeneralPath)shape).curveTo(-43.56707, 1.7631185, -42.295067, -1.6838213, -40.96874, -1.6838188);
((GeneralPath)shape).curveTo(-39.64241, -1.6838213, -38.370407, 1.7631187, -37.432552, 7.8987136);
((GeneralPath)shape).curveTo(-36.494698, 14.034308, -35.967815, 22.355963, -35.967815, 31.033005);
((GeneralPath)shape).lineTo(-40.96874, 31.033005);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(6.5, 23.5), 4.5f, new Point2D.Double(6.5, 23.5), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.1113158464431763f, 0.0f, 0.0f, 7.270405292510986f, -48.192291259765625f, -139.82151794433594f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1);
g.setComposite(AlphaComposite.getInstance(3, 0.30268195f * origAlpha));
AffineTransform defaultTransform__0_0_2 = g.getTransform();
g.transform(new AffineTransform(0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f));
// _0_0_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(-45.96966, -31.033007);
((GeneralPath)shape).curveTo(-45.96966, -35.45339, -45.44278, -39.69272, -44.504925, -42.818398);
((GeneralPath)shape).curveTo(-43.56707, -45.94408, -42.295067, -47.700066, -40.96874, -47.700066);
((GeneralPath)shape).curveTo(-39.64241, -47.700066, -38.370407, -45.94408, -37.432552, -42.818398);
((GeneralPath)shape).curveTo(-36.494698, -39.69272, -35.967815, -35.453384, -35.967815, -31.033005);
((GeneralPath)shape).lineTo(-40.96874, -31.033005);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(6.5, 23.5), 4.5f, new Point2D.Double(6.5, 23.5), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.1113158464431763f, 0.0f, 0.0f, 3.703791379928589f, -48.192291259765625f, -118.07209777832031f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3
shape = new GeneralPath();
((GeneralPath)shape).moveTo(23.03125, 4.5);
((GeneralPath)shape).curveTo(17.16448, 4.576939, 9.304703, 6.5845976, 9.4375, 13.03125);
((GeneralPath)shape).curveTo(9.579161, 19.90817, 17.932526, 17.194685, 18.25, 20.25);
((GeneralPath)shape).curveTo(18.763103, 25.188007, 8.07627, 40.21102, 24.3125, 43.15625);
((GeneralPath)shape).curveTo(35.15176, 45.122475, 46.655804, 38.37184, 45.5, 24.75);
((GeneralPath)shape).curveTo(44.460564, 12.499581, 34.3249, 4.811841, 24.1875, 4.5);
((GeneralPath)shape).curveTo(23.81714, 4.4886074, 23.422367, 4.4948707, 23.03125, 4.5);
((GeneralPath)shape).closePath();
((GeneralPath)shape).moveTo(20.5, 8.5);
((GeneralPath)shape).curveTo(23.26, 8.5, 25.5, 10.068, 25.5, 12.0);
((GeneralPath)shape).curveTo(25.500002, 13.932, 23.26, 15.5, 20.5, 15.5);
((GeneralPath)shape).curveTo(17.74, 15.5, 15.5, 13.932, 15.5, 12.0);
((GeneralPath)shape).curveTo(15.5, 10.068, 17.74, 8.5, 20.5, 8.5);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(28.65760040283203, 33.9866943359375), 18.572308f, new Point2D.Double(28.65760040283203, 33.9866943359375), new float[] {0.0f,1.0f}, new Color[] {new Color(231, 206, 121, 255),new Color(193, 125, 17, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(6.042988300323486f, 0.0f, 0.0f, 5.537075996398926f, -142.7943878173828f, -152.23843383789062f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(193, 125, 17, 255);
stroke = new BasicStroke(0.9999999f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(23.03125, 4.5);
((GeneralPath)shape).curveTo(17.16448, 4.576939, 9.304703, 6.5845976, 9.4375, 13.03125);
((GeneralPath)shape).curveTo(9.579161, 19.90817, 17.932526, 17.194685, 18.25, 20.25);
((GeneralPath)shape).curveTo(18.763103, 25.188007, 8.07627, 40.21102, 24.3125, 43.15625);
((GeneralPath)shape).curveTo(35.15176, 45.122475, 46.655804, 38.37184, 45.5, 24.75);
((GeneralPath)shape).curveTo(44.460564, 12.499581, 34.3249, 4.811841, 24.1875, 4.5);
((GeneralPath)shape).curveTo(23.81714, 4.4886074, 23.422367, 4.4948707, 23.03125, 4.5);
((GeneralPath)shape).closePath();
((GeneralPath)shape).moveTo(20.5, 8.5);
((GeneralPath)shape).curveTo(23.26, 8.5, 25.5, 10.068, 25.5, 12.0);
((GeneralPath)shape).curveTo(25.500002, 13.932, 23.26, 15.5, 20.5, 15.5);
((GeneralPath)shape).curveTo(17.74, 15.5, 15.5, 13.932, 15.5, 12.0);
((GeneralPath)shape).curveTo(15.5, 10.068, 17.74, 8.5, 20.5, 8.5);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_3);
g.setComposite(AlphaComposite.getInstance(3, 0.6704981f * origAlpha));
AffineTransform defaultTransform__0_0_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
paint = new LinearGradientPaint(new Point2D.Double(15.299922943115234, 9.144098281860352), new Point2D.Double(51.56820297241211, 83.0760726928711), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 133)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 1.0640332698822021f, 0.024633700028061867f));
stroke = new BasicStroke(1.0f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(23.095284, 5.524634);
((GeneralPath)shape).curveTo(20.271, 5.5616727, 16.972109, 6.09223, 14.501533, 7.305884);
((GeneralPath)shape).curveTo(12.030958, 8.519538, 10.443616, 10.213046, 10.501533, 13.024634);
((GeneralPath)shape).curveTo(10.532717, 14.538464, 10.981199, 15.35297, 11.595283, 15.930884);
((GeneralPath)shape).curveTo(12.209367, 16.508799, 13.090956, 16.854794, 14.095283, 17.118383);
((GeneralPath)shape).curveTo(15.09961, 17.381975, 16.186836, 17.537653, 17.157784, 17.868383);
((GeneralPath)shape).curveTo(17.643255, 18.033749, 18.118862, 18.248297, 18.532784, 18.618383);
((GeneralPath)shape).curveTo(18.946703, 18.988472, 19.250063, 19.565243, 19.314034, 20.180883);
((GeneralPath)shape).curveTo(19.484936, 21.825613, 18.835106, 23.684235, 18.157784, 25.837133);
((GeneralPath)shape).curveTo(17.48046, 27.990032, 16.711693, 30.350748, 16.439034, 32.587135);
((GeneralPath)shape).curveTo(16.166372, 34.82352, 16.397821, 36.867165, 17.501534, 38.493385);
((GeneralPath)shape).curveTo(18.605246, 40.119606, 20.67224, 41.47492, 24.564034, 42.180885);
((GeneralPath)shape).curveTo(29.722582, 43.11664, 35.012897, 41.973743, 38.845284, 39.024635);
((GeneralPath)shape).curveTo(42.67767, 36.075527, 45.116917, 31.384464, 44.564034, 24.868383);
((GeneralPath)shape).curveTo(43.568283, 13.13285, 33.8692, 5.8214483, 24.220284, 5.524634);
((GeneralPath)shape).curveTo(23.88329, 5.5142674, 23.488268, 5.5194798, 23.095284, 5.524634);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_4);
g.setComposite(AlphaComposite.getInstance(3, 0.16475093f * origAlpha));
AffineTransform defaultTransform__0_0_5 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.4375f, -0.875f));
// _0_0_5
shape = new GeneralPath();
((GeneralPath)shape).moveTo(35.5, 8.3125);
((GeneralPath)shape).curveTo(35.417503, 8.334556, 35.342136, 8.377624, 35.28125, 8.4375);
((GeneralPath)shape).curveTo(26.293922, 15.459378, 21.66408, 20.791641, 19.09375, 24.21875);
((GeneralPath)shape).curveTo(17.381636, 26.331879, 15.48999, 29.489983, 13.9375, 32.4375);
((GeneralPath)shape).curveTo(13.907882, 32.485626, 13.886742, 32.538475, 13.875, 32.59375);
((GeneralPath)shape).curveTo(13.656392, 34.591415, 13.798454, 36.607193, 14.65625, 38.375);
((GeneralPath)shape).curveTo(14.714969, 38.498474, 14.822246, 38.592087, 14.952537, 38.633545);
((GeneralPath)shape).curveTo(15.082828, 38.675, 15.224475, 38.66059, 15.34375, 38.59375);
((GeneralPath)shape).curveTo(19.360056, 36.282684, 24.501652, 31.405796, 25.875, 29.8125);
((GeneralPath)shape).curveTo(28.811441, 26.456568, 33.524033, 20.521343, 38.46875, 11.125);
((GeneralPath)shape).curveTo(38.55983, 10.936574, 38.522266, 10.711201, 38.375, 10.5625);
((GeneralPath)shape).curveTo(37.596275, 9.79973, 36.756405, 9.050465, 35.875, 8.40625);
((GeneralPath)shape).curveTo(35.767925, 8.325354, 35.632545, 8.291508, 35.5, 8.3125);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(28.469051361083984, 23.214420318603516), 12.3671f, new Point2D.Double(28.469051361083984, 23.214420318603516), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.16754360496997833f, 0.13406769931316376f, -0.9393553733825684f, 1.1739071607589722f, 43.93767166137695f, -7.586747169494629f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_5);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_6 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6
shape = new GeneralPath();
((GeneralPath)shape).moveTo(24.377604, 26.216887);
((GeneralPath)shape).curveTo(28.122395, 22.65966, 34.66893, 15.824043, 42.5, 5.0);
((GeneralPath)shape).curveTo(42.815075, 4.651051, 42.290607, 4.3510866, 42.0, 4.5);
((GeneralPath)shape).curveTo(30.168297, 12.786013, 24.217867, 18.976254, 20.842672, 22.51528);
paint = new LinearGradientPaint(new Point2D.Double(33.17571258544922, 18.65762710571289), new Point2D.Double(31.180810928344727, 17.177289962768555), new float[] {0.0f,1.0f}, new Color[] {new Color(193, 125, 17, 255),new Color(233, 185, 110, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.8048011064529419f, -0.08405894786119461f, -0.2587752938270569f, 0.841191828250885f, 10.723363876342773f, 3.5105159282684326f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(143, 89, 2, 255);
stroke = new BasicStroke(0.99999994f,0,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(24.377604, 26.216887);
((GeneralPath)shape).curveTo(28.122395, 22.65966, 34.66893, 15.824043, 42.5, 5.0);
((GeneralPath)shape).curveTo(42.815075, 4.651051, 42.290607, 4.3510866, 42.0, 4.5);
((GeneralPath)shape).curveTo(30.168297, 12.786013, 24.217867, 18.976254, 20.842672, 22.51528);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_6);
g.setComposite(AlphaComposite.getInstance(3, 0.15f * origAlpha));
AffineTransform defaultTransform__0_0_7 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
shape = new GeneralPath();
((GeneralPath)shape).moveTo(21.436422, 21.92153);
((GeneralPath)shape).curveTo(22.917898, 22.51538, 24.23436, 23.4576, 24.971354, 25.623137);
((GeneralPath)shape).curveTo(23.470957, 27.062363, 17.507904, 32.04784, 13.789563, 34.11851);
((GeneralPath)shape).lineTo(12.697511, 32.604244);
((GeneralPath)shape).curveTo(14.810426, 29.533985, 18.67098, 24.68227, 21.436422, 21.92153);
((GeneralPath)shape).closePath();
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.0f,0,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(21.436422, 21.92153);
((GeneralPath)shape).curveTo(22.917898, 22.51538, 24.23436, 23.4576, 24.971354, 25.623137);
((GeneralPath)shape).curveTo(23.470957, 27.062363, 17.507904, 32.04784, 13.789563, 34.11851);
((GeneralPath)shape).lineTo(12.697511, 32.604244);
((GeneralPath)shape).curveTo(14.810426, 29.533985, 18.67098, 24.68227, 21.436422, 21.92153);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_7);
g.setComposite(AlphaComposite.getInstance(3, 0.7356322f * origAlpha));
AffineTransform defaultTransform__0_0_8 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8
paint = new LinearGradientPaint(new Point2D.Double(21.424922943115234, 14.769098281860352), new Point2D.Double(16.63990020751953, 5.5), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 88)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 1.0640332698822021f, 0.024633700028061867f));
stroke = new BasicStroke(1.0f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(20.564034, 7.524634);
((GeneralPath)shape).curveTo(22.13501, 7.524634, 23.586748, 7.940535, 24.689034, 8.712133);
((GeneralPath)shape).curveTo(25.791317, 9.483732, 26.564034, 10.668887, 26.564034, 12.024634);
((GeneralPath)shape).curveTo(26.564034, 13.380382, 25.791317, 14.565535, 24.689034, 15.337134);
((GeneralPath)shape).curveTo(23.586748, 16.108732, 22.13501, 16.524633, 20.564034, 16.524633);
((GeneralPath)shape).curveTo(18.993057, 16.524633, 17.541317, 16.108732, 16.439034, 15.337134);
((GeneralPath)shape).curveTo(15.336749, 14.565535, 14.564033, 13.380381, 14.564033, 12.024634);
((GeneralPath)shape).curveTo(14.564033, 10.668887, 15.336749, 9.483732, 16.439034, 8.712133);
((GeneralPath)shape).curveTo(17.541317, 7.940535, 18.993057, 7.524634, 20.564034, 7.524634);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_8);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_9 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9
shape = new GeneralPath();
((GeneralPath)shape).moveTo(20.842672, 22.51528);
((GeneralPath)shape).curveTo(22.324148, 23.10913, 23.64061, 24.05135, 24.377604, 26.216887);
((GeneralPath)shape).curveTo(22.877207, 27.656113, 16.914154, 32.64159, 13.195813, 34.71226);
((GeneralPath)shape).lineTo(12.103761, 33.197994);
((GeneralPath)shape).curveTo(14.216676, 30.127735, 18.07723, 25.27602, 20.842672, 22.51528);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(19.635454177856445, 29.59141731262207), new Point2D.Double(23.529132843017578, 33.4850959777832), new float[] {0.0f,1.0f}, new Color[] {new Color(238, 238, 236, 255),new Color(136, 138, 133, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.8048011064529419f, -0.08405894786119461f, -0.2587752938270569f, 0.841191828250885f, 10.723363876342773f, 3.5105159282684326f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(136, 138, 133, 255);
stroke = new BasicStroke(0.99999994f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(20.842672, 22.51528);
((GeneralPath)shape).curveTo(22.324148, 23.10913, 23.64061, 24.05135, 24.377604, 26.216887);
((GeneralPath)shape).curveTo(22.877207, 27.656113, 16.914154, 32.64159, 13.195813, 34.71226);
((GeneralPath)shape).lineTo(12.103761, 33.197994);
((GeneralPath)shape).curveTo(14.216676, 30.127735, 18.07723, 25.27602, 20.842672, 22.51528);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_9);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_10 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10
shape = new GeneralPath();
((GeneralPath)shape).moveTo(28.045376, 37.921974);
((GeneralPath)shape).curveTo(27.064337, 38.51481, 28.116901, 39.195824, 28.590324, 39.592552);
((GeneralPath)shape).curveTo(28.965794, 39.9072, 28.401928, 41.427887, 27.72951, 40.755863);
((GeneralPath)shape).curveTo(26.9546, 39.981403, 26.455671, 38.903973, 26.151737, 38.87636);
((GeneralPath)shape).curveTo(24.404814, 38.71764, 25.749868, 41.02413, 24.344105, 40.516865);
((GeneralPath)shape).curveTo(23.502897, 40.213314, 24.549532, 38.939026, 23.426212, 38.54794);
((GeneralPath)shape).curveTo(22.533806, 38.237244, 22.622469, 39.191994, 22.106453, 38.726784);
((GeneralPath)shape).curveTo(19.677176, 36.536674, 20.954063, 34.634197, 22.0783, 33.148434);
((GeneralPath)shape).curveTo(23.202553, 31.662645, 25.423492, 31.503317, 27.070408, 32.820816);
((GeneralPath)shape).curveTo(28.71732, 34.138313, 29.154104, 36.423634, 28.045376, 37.921974);
((GeneralPath)shape).closePath();
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.9999998f,0,1,5.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(28.045376, 37.921974);
((GeneralPath)shape).curveTo(27.064337, 38.51481, 28.116901, 39.195824, 28.590324, 39.592552);
((GeneralPath)shape).curveTo(28.965794, 39.9072, 28.401928, 41.427887, 27.72951, 40.755863);
((GeneralPath)shape).curveTo(26.9546, 39.981403, 26.455671, 38.903973, 26.151737, 38.87636);
((GeneralPath)shape).curveTo(24.404814, 38.71764, 25.749868, 41.02413, 24.344105, 40.516865);
((GeneralPath)shape).curveTo(23.502897, 40.213314, 24.549532, 38.939026, 23.426212, 38.54794);
((GeneralPath)shape).curveTo(22.533806, 38.237244, 22.622469, 39.191994, 22.106453, 38.726784);
((GeneralPath)shape).curveTo(19.677176, 36.536674, 20.954063, 34.634197, 22.0783, 33.148434);
((GeneralPath)shape).curveTo(23.202553, 31.662645, 25.423492, 31.503317, 27.070408, 32.820816);
((GeneralPath)shape).curveTo(28.71732, 34.138313, 29.154104, 36.423634, 28.045376, 37.921974);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_10);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_11 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_11
shape = new GeneralPath();
((GeneralPath)shape).moveTo(36.695507, 34.909004);
((GeneralPath)shape).curveTo(37.590054, 34.909004, 39.091335, 35.06, 39.486423, 35.52464);
((GeneralPath)shape).curveTo(40.410248, 36.611107, 41.229923, 35.182003, 40.52713, 34.56505);
((GeneralPath)shape).curveTo(39.717213, 33.854053, 38.64075, 33.444843, 38.58787, 33.14281);
((GeneralPath)shape).curveTo(38.283947, 31.406815, 40.612427, 32.560192, 40.003914, 31.195068);
((GeneralPath)shape).curveTo(39.639786, 30.37818, 38.5088, 31.533157, 38.03623, 30.441114);
((GeneralPath)shape).curveTo(37.660797, 29.573557, 38.583996, 29.582233, 38.09309, 29.104546);
((GeneralPath)shape).curveTo(35.782043, 26.855701, 34.0687, 28.293953, 32.741673, 29.544382);
((GeneralPath)shape).curveTo(31.414629, 30.794827, 31.454754, 33.03217, 32.861122, 34.570793);
((GeneralPath)shape).curveTo(33.43871, 35.202698, 33.722527, 36.72163, 34.459137, 36.904297);
((GeneralPath)shape).curveTo(35.516106, 37.1664, 34.442924, 34.909004, 36.695507, 34.909004);
((GeneralPath)shape).closePath();
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.0f,0,1,5.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(36.695507, 34.909004);
((GeneralPath)shape).curveTo(37.590054, 34.909004, 39.091335, 35.06, 39.486423, 35.52464);
((GeneralPath)shape).curveTo(40.410248, 36.611107, 41.229923, 35.182003, 40.52713, 34.56505);
((GeneralPath)shape).curveTo(39.717213, 33.854053, 38.64075, 33.444843, 38.58787, 33.14281);
((GeneralPath)shape).curveTo(38.283947, 31.406815, 40.612427, 32.560192, 40.003914, 31.195068);
((GeneralPath)shape).curveTo(39.639786, 30.37818, 38.5088, 31.533157, 38.03623, 30.441114);
((GeneralPath)shape).curveTo(37.660797, 29.573557, 38.583996, 29.582233, 38.09309, 29.104546);
((GeneralPath)shape).curveTo(35.782043, 26.855701, 34.0687, 28.293953, 32.741673, 29.544382);
((GeneralPath)shape).curveTo(31.414629, 30.794827, 31.454754, 33.03217, 32.861122, 34.570793);
((GeneralPath)shape).curveTo(33.43871, 35.202698, 33.722527, 36.72163, 34.459137, 36.904297);
((GeneralPath)shape).curveTo(35.516106, 37.1664, 34.442924, 34.909004, 36.695507, 34.909004);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_11);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_12 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_12
shape = new GeneralPath();
((GeneralPath)shape).moveTo(38.24158, 23.925957);
((GeneralPath)shape).curveTo(37.360645, 23.925957, 37.18421, 24.533909, 36.76909, 24.925564);
((GeneralPath)shape).curveTo(36.439857, 25.23618, 35.05212, 24.621115, 35.744217, 24.072927);
((GeneralPath)shape).curveTo(36.541813, 23.441183, 36.71702, 22.694916, 36.76909, 22.426546);
((GeneralPath)shape).curveTo(37.06839, 20.884048, 34.11303, 21.633947, 34.72097, 20.425476);
((GeneralPath)shape).curveTo(35.16365, 19.54551, 36.773464, 20.383345, 36.76909, 19.927532);
((GeneralPath)shape).curveTo(36.76234, 19.2247, 36.34899, 18.162909, 37.229736, 17.989265);
((GeneralPath)shape).curveTo(39.0829, 17.623909, 41.21615, 18.901438, 42.22097, 19.925476);
((GeneralPath)shape).curveTo(43.1817, 20.90458, 42.648815, 22.616716, 42.080776, 23.832945);
((GeneralPath)shape).curveTo(41.73371, 24.576044, 40.938435, 26.088415, 40.016247, 25.906351);
((GeneralPath)shape).curveTo(38.969826, 25.69976, 40.459885, 23.925957, 38.24158, 23.925957);
((GeneralPath)shape).closePath();
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.0f,0,1,5.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(38.24158, 23.925957);
((GeneralPath)shape).curveTo(37.360645, 23.925957, 37.18421, 24.533909, 36.76909, 24.925564);
((GeneralPath)shape).curveTo(36.439857, 25.23618, 35.05212, 24.621115, 35.744217, 24.072927);
((GeneralPath)shape).curveTo(36.541813, 23.441183, 36.71702, 22.694916, 36.76909, 22.426546);
((GeneralPath)shape).curveTo(37.06839, 20.884048, 34.11303, 21.633947, 34.72097, 20.425476);
((GeneralPath)shape).curveTo(35.16365, 19.54551, 36.773464, 20.383345, 36.76909, 19.927532);
((GeneralPath)shape).curveTo(36.76234, 19.2247, 36.34899, 18.162909, 37.229736, 17.989265);
((GeneralPath)shape).curveTo(39.0829, 17.623909, 41.21615, 18.901438, 42.22097, 19.925476);
((GeneralPath)shape).curveTo(43.1817, 20.90458, 42.648815, 22.616716, 42.080776, 23.832945);
((GeneralPath)shape).curveTo(41.73371, 24.576044, 40.938435, 26.088415, 40.016247, 25.906351);
((GeneralPath)shape).curveTo(38.969826, 25.69976, 40.459885, 23.925957, 38.24158, 23.925957);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_12);
g.setComposite(AlphaComposite.getInstance(3, 0.6800002f * origAlpha));
AffineTransform defaultTransform__0_0_13 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_13
shape = new GeneralPath();
((GeneralPath)shape).moveTo(12.9375, 33.4375);
((GeneralPath)shape).curveTo(18.547565, 24.93393, 36.615368, 9.233779, 40.5, 6.625);
((GeneralPath)shape).curveTo(32.235233, 15.427256, 21.892145, 25.266733, 12.9375, 33.4375);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(18.1875, 28.625), new Point2D.Double(41.4375, 6.1875), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, -1.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_13);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_14 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_14
shape = new GeneralPath();
((GeneralPath)shape).moveTo(27.824406, 37.4965);
((GeneralPath)shape).curveTo(26.843367, 38.089333, 27.895931, 38.770348, 28.369354, 39.167076);
((GeneralPath)shape).curveTo(28.744822, 39.481724, 28.180958, 41.00241, 27.50854, 40.330387);
((GeneralPath)shape).curveTo(26.73363, 39.555927, 26.2347, 38.478497, 25.930767, 38.450886);
((GeneralPath)shape).curveTo(24.183844, 38.292164, 25.528898, 40.598656, 24.123135, 40.09139);
((GeneralPath)shape).curveTo(23.281925, 39.787838, 24.328562, 38.51355, 23.20524, 38.122463);
((GeneralPath)shape).curveTo(22.312836, 37.811768, 22.401497, 38.766518, 21.88548, 38.301308);
((GeneralPath)shape).curveTo(19.456205, 36.1112, 20.733093, 34.20872, 21.857328, 32.722958);
((GeneralPath)shape).curveTo(22.98158, 31.23717, 25.202522, 31.07784, 26.849436, 32.39534);
((GeneralPath)shape).curveTo(28.496347, 33.712837, 28.933134, 35.998158, 27.824406, 37.4965);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(23.537704467773438, 36.02513122558594), 4.244812f, new Point2D.Double(23.537704467773438, 36.02513122558594), new float[] {0.0f,1.0f}, new Color[] {new Color(138, 226, 52, 255),new Color(115, 210, 22, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9409276843070984f, 0.0f, 0.0f, 1.0482488870620728f, 1.6820708513259888f, -3.177501916885376f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(78, 154, 6, 255);
stroke = new BasicStroke(0.9999998f,0,1,5.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(27.824406, 37.4965);
((GeneralPath)shape).curveTo(26.843367, 38.089333, 27.895931, 38.770348, 28.369354, 39.167076);
((GeneralPath)shape).curveTo(28.744822, 39.481724, 28.180958, 41.00241, 27.50854, 40.330387);
((GeneralPath)shape).curveTo(26.73363, 39.555927, 26.2347, 38.478497, 25.930767, 38.450886);
((GeneralPath)shape).curveTo(24.183844, 38.292164, 25.528898, 40.598656, 24.123135, 40.09139);
((GeneralPath)shape).curveTo(23.281925, 39.787838, 24.328562, 38.51355, 23.20524, 38.122463);
((GeneralPath)shape).curveTo(22.312836, 37.811768, 22.401497, 38.766518, 21.88548, 38.301308);
((GeneralPath)shape).curveTo(19.456205, 36.1112, 20.733093, 34.20872, 21.857328, 32.722958);
((GeneralPath)shape).curveTo(22.98158, 31.23717, 25.202522, 31.07784, 26.849436, 32.39534);
((GeneralPath)shape).curveTo(28.496347, 33.712837, 28.933134, 35.998158, 27.824406, 37.4965);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_14);
g.setComposite(AlphaComposite.getInstance(3, 0.77011496f * origAlpha));
AffineTransform defaultTransform__0_0_15 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15
shape = new GeneralPath();
((GeneralPath)shape).moveTo(25.71875, 32.75);
((GeneralPath)shape).curveTo(24.385471, 31.971878, 22.878695, 32.79794, 22.34375, 33.46875);
((GeneralPath)shape).curveTo(21.808805, 34.13956, 21.082611, 35.45121, 21.65625, 36.6875);
((GeneralPath)shape).curveTo(22.033056, 35.49819, 22.574726, 34.707554, 23.125, 34.09375);
((GeneralPath)shape).curveTo(23.676092, 33.47903, 24.318087, 32.81714, 25.71875, 32.75);
((GeneralPath)shape).closePath();
paint = new Color(238, 238, 236, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_15);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_16 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_16
shape = new GeneralPath();
((GeneralPath)shape).moveTo(2.5, 39.533974);
((GeneralPath)shape).curveTo(7.193467, 39.53579, 6.721149, 34.641895, 9.0, 33.141697);
((GeneralPath)shape).curveTo(11.640769, 31.403242, 13.954982, 33.55738, 14.41701, 35.33018);
((GeneralPath)shape).curveTo(15.0, 37.56712, 14.0, 40.02569, 11.0, 41.009117);
((GeneralPath)shape).curveTo(7.636352, 42.11175, 2.889473, 41.484547, 2.5, 39.533974);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(10.593055725097656, 38.58195495605469), new Point2D.Double(10.165061950683594, 43.38218688964844), new float[] {0.0f,1.0f}, new Color[] {new Color(85, 87, 83, 255),new Color(31, 35, 36, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.267530083656311f, -0.9999949932098389f, -14.853580474853516f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.9999999f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(2.5, 39.533974);
((GeneralPath)shape).curveTo(7.193467, 39.53579, 6.721149, 34.641895, 9.0, 33.141697);
((GeneralPath)shape).curveTo(11.640769, 31.403242, 13.954982, 33.55738, 14.41701, 35.33018);
((GeneralPath)shape).curveTo(15.0, 37.56712, 14.0, 40.02569, 11.0, 41.009117);
((GeneralPath)shape).curveTo(7.636352, 42.11175, 2.889473, 41.484547, 2.5, 39.533974);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_16);
g.setComposite(AlphaComposite.getInstance(3, 0.29118773f * origAlpha));
AffineTransform defaultTransform__0_0_17 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17
paint = new LinearGradientPaint(new Point2D.Double(9.343700408935547, 38.8116569519043), new Point2D.Double(10.924744606018066, 46.82093048095703), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 17)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.6424152255058289f, 0.0f, 0.0f, 0.7146281003952026f, 3.445805072784424f, 6.787435054779053f));
stroke = new BasicStroke(1.0f,0,1,5.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(4.0, 40.11888);
((GeneralPath)shape).curveTo(6.035358, 40.093246, 7.435893, 37.673954, 7.966235, 36.13983);
((GeneralPath)shape).curveTo(9.56545, 31.513773, 14.380709, 33.712894, 13.5, 36.932713);
((GeneralPath)shape).curveTo(12.451529, 42.11423, 7.044828, 40.12705, 4.0, 40.11888);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_17);
g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));
AffineTransform defaultTransform__0_0_18 = g.getTransform();
g.transform(new AffineTransform(2.6362040042877197f, 0.0f, 0.0f, 2.1809589862823486f, -21.126216888427734f, -49.42094039916992f));
// _0_0_18
shape = new GeneralPath();
((GeneralPath)shape).moveTo(13.324543, 38.708176);
((GeneralPath)shape).curveTo(13.326366, 39.036774, 13.109865, 39.341045, 12.757017, 39.50577);
((GeneralPath)shape).curveTo(12.40417, 39.670498, 11.968916, 39.670498, 11.616069, 39.50577);
((GeneralPath)shape).curveTo(11.263221, 39.341045, 11.04672, 39.036774, 11.048543, 38.708176);
((GeneralPath)shape).curveTo(11.04672, 38.379578, 11.263221, 38.075306, 11.616069, 37.91058);
((GeneralPath)shape).curveTo(11.968916, 37.745853, 12.40417, 37.745853, 12.757017, 37.91058);
((GeneralPath)shape).curveTo(13.109865, 38.075306, 13.326366, 38.379578, 13.324543, 38.708176);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(12.186543464660645, 38.012454986572266), new Point2D.Double(12.186543464660645, 39.532230377197266), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 17)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_18);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_19 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_19
shape = new GeneralPath();
((GeneralPath)shape).moveTo(36.474537, 34.48353);
((GeneralPath)shape).curveTo(37.369083, 34.48353, 38.870365, 34.634525, 39.26545, 35.099167);
((GeneralPath)shape).curveTo(40.189278, 36.18563, 41.008953, 34.756527, 40.30616, 34.139572);
((GeneralPath)shape).curveTo(39.496243, 33.428577, 38.41978, 33.019367, 38.3669, 32.717335);
((GeneralPath)shape).curveTo(38.062977, 30.981339, 40.391453, 32.134716, 39.782944, 30.769592);
((GeneralPath)shape).curveTo(39.41881, 29.952703, 38.28783, 31.107681, 37.815254, 30.015638);
((GeneralPath)shape).curveTo(37.439827, 29.14808, 38.363026, 29.156757, 37.87212, 28.67907);
((GeneralPath)shape).curveTo(35.56107, 26.430225, 33.847725, 27.868477, 32.520702, 29.118906);
((GeneralPath)shape).curveTo(31.193659, 30.36935, 31.233784, 32.606693, 32.64015, 34.145317);
((GeneralPath)shape).curveTo(33.217735, 34.77722, 33.501553, 36.296158, 34.238167, 36.47882);
((GeneralPath)shape).curveTo(35.29513, 36.740925, 34.22195, 34.48353, 36.474537, 34.48353);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(32.450172424316406, 33.60939407348633), 5.0383153f, new Point2D.Double(32.450172424316406, 33.60939407348633), new float[] {0.0f,1.0f}, new Color[] {new Color(239, 41, 41, 255),new Color(204, 0, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.6369420289993286f, 0.696841299533844f, 0.5532571077346802f, -0.5101348161697388f, -5.00120210647583f, 25.28829002380371f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(164, 0, 0, 255);
stroke = new BasicStroke(1.0f,0,1,5.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(36.474537, 34.48353);
((GeneralPath)shape).curveTo(37.369083, 34.48353, 38.870365, 34.634525, 39.26545, 35.099167);
((GeneralPath)shape).curveTo(40.189278, 36.18563, 41.008953, 34.756527, 40.30616, 34.139572);
((GeneralPath)shape).curveTo(39.496243, 33.428577, 38.41978, 33.019367, 38.3669, 32.717335);
((GeneralPath)shape).curveTo(38.062977, 30.981339, 40.391453, 32.134716, 39.782944, 30.769592);
((GeneralPath)shape).curveTo(39.41881, 29.952703, 38.28783, 31.107681, 37.815254, 30.015638);
((GeneralPath)shape).curveTo(37.439827, 29.14808, 38.363026, 29.156757, 37.87212, 28.67907);
((GeneralPath)shape).curveTo(35.56107, 26.430225, 33.847725, 27.868477, 32.520702, 29.118906);
((GeneralPath)shape).curveTo(31.193659, 30.36935, 31.233784, 32.606693, 32.64015, 34.145317);
((GeneralPath)shape).curveTo(33.217735, 34.77722, 33.501553, 36.296158, 34.238167, 36.47882);
((GeneralPath)shape).curveTo(35.29513, 36.740925, 34.22195, 34.48353, 36.474537, 34.48353);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_19);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_20 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_20
paint = new LinearGradientPaint(new Point2D.Double(38.28942108154297, 5.253948211669922), new Point2D.Double(36.610626220703125, 7.3314619064331055), new float[] {0.0f,1.0f}, new Color[] {new Color(234, 197, 134, 255),new Color(234, 197, 134, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.8048011064529419f, -0.08405894786119461f, -0.2587752938270569f, 0.841191828250885f, 10.626724243164062f, 5.876156806945801f));
stroke = new BasicStroke(0.99999994f,1,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(41.510654, 5.5);
((GeneralPath)shape).lineTo(38.5, 8.508813);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_20);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_21 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_21
shape = new GeneralPath();
((GeneralPath)shape).moveTo(38.02061, 23.50048);
((GeneralPath)shape).curveTo(37.139675, 23.50048, 36.96324, 24.108433, 36.54812, 24.500088);
((GeneralPath)shape).curveTo(36.218887, 24.810703, 34.83115, 24.195639, 35.523247, 23.647451);
((GeneralPath)shape).curveTo(36.32084, 23.015707, 36.496044, 22.26944, 36.54812, 22.001072);
((GeneralPath)shape).curveTo(36.84742, 20.458572, 33.89206, 21.208471, 34.5, 20.0);
((GeneralPath)shape).curveTo(34.94268, 19.120033, 36.552494, 19.957869, 36.54812, 19.502056);
((GeneralPath)shape).curveTo(36.54137, 18.799225, 36.128017, 17.737432, 37.008762, 17.56379);
((GeneralPath)shape).curveTo(38.86193, 17.198433, 40.99518, 18.475962, 42.0, 19.5);
((GeneralPath)shape).curveTo(42.96073, 20.479103, 42.427845, 22.19124, 41.859806, 23.407469);
((GeneralPath)shape).curveTo(41.512737, 24.15057, 40.717464, 25.66294, 39.795277, 25.480877);
((GeneralPath)shape).curveTo(38.748856, 25.274284, 40.238914, 23.50048, 38.02061, 23.50048);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(33.29081344604492, 36.0700569152832), 5.0383153f, new Point2D.Double(33.29081344604492, 36.0700569152832), new float[] {0.0f,1.0f}, new Color[] {new Color(114, 159, 207, 255),new Color(52, 101, 164, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-0.8570756912231445f, 0.7036892175674438f, -0.6305521726608276f, -0.6305521726608276f, 89.17596435546875f, 19.040700912475586f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(32, 74, 135, 255);
stroke = new BasicStroke(1.0f,0,1,5.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(38.02061, 23.50048);
((GeneralPath)shape).curveTo(37.139675, 23.50048, 36.96324, 24.108433, 36.54812, 24.500088);
((GeneralPath)shape).curveTo(36.218887, 24.810703, 34.83115, 24.195639, 35.523247, 23.647451);
((GeneralPath)shape).curveTo(36.32084, 23.015707, 36.496044, 22.26944, 36.54812, 22.001072);
((GeneralPath)shape).curveTo(36.84742, 20.458572, 33.89206, 21.208471, 34.5, 20.0);
((GeneralPath)shape).curveTo(34.94268, 19.120033, 36.552494, 19.957869, 36.54812, 19.502056);
((GeneralPath)shape).curveTo(36.54137, 18.799225, 36.128017, 17.737432, 37.008762, 17.56379);
((GeneralPath)shape).curveTo(38.86193, 17.198433, 40.99518, 18.475962, 42.0, 19.5);
((GeneralPath)shape).curveTo(42.96073, 20.479103, 42.427845, 22.19124, 41.859806, 23.407469);
((GeneralPath)shape).curveTo(41.512737, 24.15057, 40.717464, 25.66294, 39.795277, 25.480877);
((GeneralPath)shape).curveTo(38.748856, 25.274284, 40.238914, 23.50048, 38.02061, 23.50048);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_21);
g.setComposite(AlphaComposite.getInstance(3, 0.77011496f * origAlpha));
AffineTransform defaultTransform__0_0_22 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_22
shape = new GeneralPath();
((GeneralPath)shape).moveTo(38.0, 18.5);
((GeneralPath)shape).curveTo(37.144714, 18.887354, 37.0, 20.0, 37.5, 21.0);
((GeneralPath)shape).curveTo(38.033146, 19.553299, 39.5, 20.0, 41.0, 20.0);
((GeneralPath)shape).curveTo(40.5, 19.0, 38.596325, 18.30053, 38.0, 18.5);
((GeneralPath)shape).closePath();
paint = new Color(238, 238, 236, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_22);
g.setComposite(AlphaComposite.getInstance(3, 0.77011496f * origAlpha));
AffineTransform defaultTransform__0_0_23 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_23
shape = new GeneralPath();
((GeneralPath)shape).moveTo(36.768036, 28.732128);
((GeneralPath)shape).curveTo(35.434757, 27.954006, 33.927982, 28.780067, 33.393036, 29.450878);
((GeneralPath)shape).curveTo(32.85809, 30.12169, 32.131897, 31.43334, 32.705536, 32.66963);
((GeneralPath)shape).curveTo(33.08234, 31.48032, 33.624012, 30.689684, 34.174286, 30.075878);
((GeneralPath)shape).curveTo(34.725376, 29.46116, 35.367374, 28.799269, 36.768036, 28.732128);
((GeneralPath)shape).closePath();
paint = new Color(238, 238, 236, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_23);
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
        return 3.9062087535858154;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 47.70006561279297;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 42.063453674316406;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private applications_graphics_2() {
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
       applications_graphics_2 base = new applications_graphics_2();
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
       applications_graphics_2 base = new applications_graphics_2();
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
        return applications_graphics_2::new;
    }
}

