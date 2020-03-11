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
public class tab_new_6 implements ResizableIcon {
    

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
g.setComposite(AlphaComposite.getInstance(3, 0.7802198f * origAlpha));
AffineTransform defaultTransform__0_0_0 = g.getTransform();
g.transform(new AffineTransform(-1.0f, 0.0f, 0.0f, 1.0f, 128.0f, 0.0f));
// _0_0_0
g.setComposite(AlphaComposite.getInstance(3, 0.25f * origAlpha));
AffineTransform defaultTransform__0_0_0_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(71.78125, 20.0);
((GeneralPath)shape).curveTo(67.47136, 20.0, 64.0, 23.471355, 64.0, 27.78125);
((GeneralPath)shape).lineTo(64.0, 48.0);
((GeneralPath)shape).lineTo(29.0, 48.0);
((GeneralPath)shape).lineTo(29.0, 89.0);
((GeneralPath)shape).lineTo(120.0, 89.0);
((GeneralPath)shape).lineTo(120.0, 27.78125);
((GeneralPath)shape).curveTo(120.0, 23.471355, 116.52865, 20.0, 112.21875, 20.0);
((GeneralPath)shape).lineTo(71.78125, 20.0);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(55.54030227661133, 199.0931854248047), new Point2D.Double(53.0167236328125, 40.745628356933594), new float[] {0.0f,0.4259708f,0.5892781f,0.8021978f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 255),new Color(241, 241, 241, 255),new Color(234, 234, 234, 255),new Color(223, 223, 223, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(4.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(71.78125, 20.0);
((GeneralPath)shape).curveTo(67.47136, 20.0, 64.0, 23.471355, 64.0, 27.78125);
((GeneralPath)shape).lineTo(64.0, 48.0);
((GeneralPath)shape).lineTo(29.0, 48.0);
((GeneralPath)shape).lineTo(29.0, 89.0);
((GeneralPath)shape).lineTo(120.0, 89.0);
((GeneralPath)shape).lineTo(120.0, 27.78125);
((GeneralPath)shape).curveTo(120.0, 23.471355, 116.52865, 20.0, 112.21875, 20.0);
((GeneralPath)shape).lineTo(71.78125, 20.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 0.3f * origAlpha));
AffineTransform defaultTransform__0_0_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(71.78125, 20.0);
((GeneralPath)shape).curveTo(67.47136, 20.0, 64.0, 23.471355, 64.0, 27.78125);
((GeneralPath)shape).lineTo(64.0, 48.0);
((GeneralPath)shape).lineTo(25.0, 48.0);
((GeneralPath)shape).lineTo(25.0, 84.0);
((GeneralPath)shape).lineTo(120.0, 84.0);
((GeneralPath)shape).lineTo(120.0, 27.78125);
((GeneralPath)shape).curveTo(120.0, 23.471355, 116.52865, 20.0, 112.21875, 20.0);
((GeneralPath)shape).lineTo(71.78125, 20.0);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(55.54030227661133, 199.0931854248047), new Point2D.Double(53.0167236328125, 40.745628356933594), new float[] {0.0f,0.4259708f,0.5892781f,0.8021978f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 255),new Color(241, 241, 241, 255),new Color(234, 234, 234, 255),new Color(223, 223, 223, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(71.78125, 20.0);
((GeneralPath)shape).curveTo(67.47136, 20.0, 64.0, 23.471355, 64.0, 27.78125);
((GeneralPath)shape).lineTo(64.0, 48.0);
((GeneralPath)shape).lineTo(25.0, 48.0);
((GeneralPath)shape).lineTo(25.0, 84.0);
((GeneralPath)shape).lineTo(120.0, 84.0);
((GeneralPath)shape).lineTo(120.0, 27.78125);
((GeneralPath)shape).curveTo(120.0, 23.471355, 116.52865, 20.0, 112.21875, 20.0);
((GeneralPath)shape).lineTo(71.78125, 20.0);
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
((GeneralPath)shape).moveTo(71.78125, 20.0);
((GeneralPath)shape).curveTo(67.47136, 20.0, 64.0, 23.471355, 64.0, 27.78125);
((GeneralPath)shape).lineTo(64.0, 48.0);
((GeneralPath)shape).lineTo(24.0, 48.0);
((GeneralPath)shape).lineTo(24.0, 84.0);
((GeneralPath)shape).lineTo(120.0, 84.0);
((GeneralPath)shape).lineTo(120.0, 27.78125);
((GeneralPath)shape).curveTo(120.0, 23.471355, 116.52865, 20.0, 112.21875, 20.0);
((GeneralPath)shape).lineTo(71.78125, 20.0);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(55.54030227661133, 199.0931854248047), new Point2D.Double(53.0167236328125, 40.745628356933594), new float[] {0.0f,0.4259708f,0.5892781f,0.8021978f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 255),new Color(241, 241, 241, 255),new Color(234, 234, 234, 255),new Color(223, 223, 223, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0_2);
g.setTransform(defaultTransform__0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(116.76293, 4.7358413);
((GeneralPath)shape).lineTo(116.76293, 1.9411328);
((GeneralPath)shape).lineTo(116.76293, 4.7358413);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(-106.1155, -66.353806);
((GeneralPath)shape).lineTo(-106.1155, -69.14851);
((GeneralPath)shape).lineTo(-106.1155, -66.353806);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3
shape = new GeneralPath();
((GeneralPath)shape).moveTo(-225.6177, -152.98405);
((GeneralPath)shape).lineTo(-225.6177, -155.77876);
((GeneralPath)shape).lineTo(-225.6177, -152.98405);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_3);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -42.666099548339844f, -8.402420043945312f));
// _0_0_4
g.setTransform(defaultTransform__0_0_4);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_5 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -42.666099548339844f, -8.402420043945312f));
// _0_0_5
g.setTransform(defaultTransform__0_0_5);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_6 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6
shape = new GeneralPath();
((GeneralPath)shape).moveTo(20.9737, -87.22878);
((GeneralPath)shape).lineTo(20.9737, -90.02349);
((GeneralPath)shape).lineTo(20.9737, -87.22878);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_6);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_7 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
shape = new GeneralPath();
((GeneralPath)shape).moveTo(81.28432, -7.9325066);
((GeneralPath)shape).lineTo(81.28432, -9.459243);
((GeneralPath)shape).lineTo(81.28432, -7.932507);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_7);
g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));
AffineTransform defaultTransform__0_0_8 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8
g.setTransform(defaultTransform__0_0_8);
g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));
AffineTransform defaultTransform__0_0_9 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9
g.setTransform(defaultTransform__0_0_9);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_10 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10
shape = new GeneralPath();
((GeneralPath)shape).moveTo(-323.1997, -170.67877);
((GeneralPath)shape).lineTo(-323.1997, -173.47348);
((GeneralPath)shape).lineTo(-323.1997, -170.67877);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_10);
g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
AffineTransform defaultTransform__0_0_11 = g.getTransform();
g.transform(new AffineTransform(-0.7829949855804443f, 0.0f, 0.0f, 0.6508790254592896f, -2646.05810546875f, 515.8389282226562f));
// _0_0_11
g.setTransform(defaultTransform__0_0_11);
g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
AffineTransform defaultTransform__0_0_12 = g.getTransform();
g.transform(new AffineTransform(-0.7829949855804443f, 0.0f, 0.0f, 0.6508790254592896f, -2646.05810546875f, 515.8389282226562f));
// _0_0_12
g.setTransform(defaultTransform__0_0_12);
g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
AffineTransform defaultTransform__0_0_13 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 0.6508790254592896f, 554.9047241210938f, 523.1666870117188f));
// _0_0_13
g.setTransform(defaultTransform__0_0_13);
g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
AffineTransform defaultTransform__0_0_14 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 0.6508790254592896f, 554.9047241210938f, 523.1666870117188f));
// _0_0_14
g.setTransform(defaultTransform__0_0_14);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_15 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15
g.setComposite(AlphaComposite.getInstance(3, 0.1f * origAlpha));
AffineTransform defaultTransform__0_0_15_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(71.78125, 16.0);
((GeneralPath)shape).curveTo(67.47136, 16.0, 64.0, 19.471355, 64.0, 23.78125);
((GeneralPath)shape).lineTo(64.0, 40.0);
((GeneralPath)shape).lineTo(8.0, 40.0);
((GeneralPath)shape).lineTo(8.0, 104.0);
((GeneralPath)shape).lineTo(120.0, 104.0);
((GeneralPath)shape).lineTo(120.0, 23.78125);
((GeneralPath)shape).curveTo(120.0, 19.471355, 116.52865, 16.0, 112.21875, 16.0);
((GeneralPath)shape).lineTo(71.78125, 16.0);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(55.54030227661133, 199.0931854248047), new Point2D.Double(53.0167236328125, 40.745628356933594), new float[] {0.0f,0.4259708f,0.5892781f,0.8021978f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 255),new Color(241, 241, 241, 255),new Color(234, 234, 234, 255),new Color(223, 223, 223, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(8.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(71.78125, 16.0);
((GeneralPath)shape).curveTo(67.47136, 16.0, 64.0, 19.471355, 64.0, 23.78125);
((GeneralPath)shape).lineTo(64.0, 40.0);
((GeneralPath)shape).lineTo(8.0, 40.0);
((GeneralPath)shape).lineTo(8.0, 104.0);
((GeneralPath)shape).lineTo(120.0, 104.0);
((GeneralPath)shape).lineTo(120.0, 23.78125);
((GeneralPath)shape).curveTo(120.0, 19.471355, 116.52865, 16.0, 112.21875, 16.0);
((GeneralPath)shape).lineTo(71.78125, 16.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_15_0);
g.setComposite(AlphaComposite.getInstance(3, 0.2f * origAlpha));
AffineTransform defaultTransform__0_0_15_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(71.78125, 16.0);
((GeneralPath)shape).curveTo(67.47136, 16.0, 64.0, 19.471355, 64.0, 23.78125);
((GeneralPath)shape).lineTo(64.0, 40.0);
((GeneralPath)shape).lineTo(8.0, 40.0);
((GeneralPath)shape).lineTo(8.0, 104.0);
((GeneralPath)shape).lineTo(120.0, 104.0);
((GeneralPath)shape).lineTo(120.0, 23.78125);
((GeneralPath)shape).curveTo(120.0, 19.471355, 116.52865, 16.0, 112.21875, 16.0);
((GeneralPath)shape).lineTo(71.78125, 16.0);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(55.54030227661133, 199.0931854248047), new Point2D.Double(53.0167236328125, 40.745628356933594), new float[] {0.0f,0.4259708f,0.5892781f,0.8021978f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 255),new Color(241, 241, 241, 255),new Color(234, 234, 234, 255),new Color(223, 223, 223, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(6.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(71.78125, 16.0);
((GeneralPath)shape).curveTo(67.47136, 16.0, 64.0, 19.471355, 64.0, 23.78125);
((GeneralPath)shape).lineTo(64.0, 40.0);
((GeneralPath)shape).lineTo(8.0, 40.0);
((GeneralPath)shape).lineTo(8.0, 104.0);
((GeneralPath)shape).lineTo(120.0, 104.0);
((GeneralPath)shape).lineTo(120.0, 23.78125);
((GeneralPath)shape).curveTo(120.0, 19.471355, 116.52865, 16.0, 112.21875, 16.0);
((GeneralPath)shape).lineTo(71.78125, 16.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_15_1);
g.setComposite(AlphaComposite.getInstance(3, 0.3f * origAlpha));
AffineTransform defaultTransform__0_0_15_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(71.78125, 16.0);
((GeneralPath)shape).curveTo(67.47136, 16.0, 64.0, 19.471355, 64.0, 23.78125);
((GeneralPath)shape).lineTo(64.0, 40.0);
((GeneralPath)shape).lineTo(8.0, 40.0);
((GeneralPath)shape).lineTo(8.0, 104.0);
((GeneralPath)shape).lineTo(120.0, 104.0);
((GeneralPath)shape).lineTo(120.0, 23.78125);
((GeneralPath)shape).curveTo(120.0, 19.471355, 116.52865, 16.0, 112.21875, 16.0);
((GeneralPath)shape).lineTo(71.78125, 16.0);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(55.54030227661133, 199.0931854248047), new Point2D.Double(53.0167236328125, 40.745628356933594), new float[] {0.0f,0.4259708f,0.5892781f,0.8021978f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 255),new Color(241, 241, 241, 255),new Color(234, 234, 234, 255),new Color(223, 223, 223, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(71.78125, 16.0);
((GeneralPath)shape).curveTo(67.47136, 16.0, 64.0, 19.471355, 64.0, 23.78125);
((GeneralPath)shape).lineTo(64.0, 40.0);
((GeneralPath)shape).lineTo(8.0, 40.0);
((GeneralPath)shape).lineTo(8.0, 104.0);
((GeneralPath)shape).lineTo(120.0, 104.0);
((GeneralPath)shape).lineTo(120.0, 23.78125);
((GeneralPath)shape).curveTo(120.0, 19.471355, 116.52865, 16.0, 112.21875, 16.0);
((GeneralPath)shape).lineTo(71.78125, 16.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_15_2);
g.setComposite(AlphaComposite.getInstance(3, 0.25f * origAlpha));
AffineTransform defaultTransform__0_0_15_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_3
shape = new GeneralPath();
((GeneralPath)shape).moveTo(71.78125, 16.0);
((GeneralPath)shape).curveTo(67.47136, 16.0, 64.0, 19.471355, 64.0, 23.78125);
((GeneralPath)shape).lineTo(64.0, 40.0);
((GeneralPath)shape).lineTo(8.0, 40.0);
((GeneralPath)shape).lineTo(8.0, 104.0);
((GeneralPath)shape).lineTo(120.0, 104.0);
((GeneralPath)shape).lineTo(120.0, 23.78125);
((GeneralPath)shape).curveTo(120.0, 19.471355, 116.52865, 16.0, 112.21875, 16.0);
((GeneralPath)shape).lineTo(71.78125, 16.0);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(55.54030227661133, 199.0931854248047), new Point2D.Double(53.0167236328125, 40.745628356933594), new float[] {0.0f,0.4259708f,0.5892781f,0.8021978f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 255),new Color(241, 241, 241, 255),new Color(234, 234, 234, 255),new Color(223, 223, 223, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(4.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(71.78125, 16.0);
((GeneralPath)shape).curveTo(67.47136, 16.0, 64.0, 19.471355, 64.0, 23.78125);
((GeneralPath)shape).lineTo(64.0, 40.0);
((GeneralPath)shape).lineTo(8.0, 40.0);
((GeneralPath)shape).lineTo(8.0, 104.0);
((GeneralPath)shape).lineTo(120.0, 104.0);
((GeneralPath)shape).lineTo(120.0, 23.78125);
((GeneralPath)shape).curveTo(120.0, 19.471355, 116.52865, 16.0, 112.21875, 16.0);
((GeneralPath)shape).lineTo(71.78125, 16.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_15_3);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_15_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_4
shape = new GeneralPath();
((GeneralPath)shape).moveTo(71.78125, 16.0);
((GeneralPath)shape).curveTo(67.47136, 16.0, 64.0, 19.471355, 64.0, 23.78125);
((GeneralPath)shape).lineTo(64.0, 40.0);
((GeneralPath)shape).lineTo(8.0, 40.0);
((GeneralPath)shape).lineTo(8.0, 104.0);
((GeneralPath)shape).lineTo(120.0, 104.0);
((GeneralPath)shape).lineTo(120.0, 23.78125);
((GeneralPath)shape).curveTo(120.0, 19.471355, 116.52865, 16.0, 112.21875, 16.0);
((GeneralPath)shape).lineTo(71.78125, 16.0);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(55.54030227661133, 199.0931854248047), new Point2D.Double(53.0167236328125, 40.745628356933594), new float[] {0.0f,0.4259708f,0.5892781f,0.8021978f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 255),new Color(241, 241, 241, 255),new Color(234, 234, 234, 255),new Color(223, 223, 223, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_15_4);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_15_5 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_5
shape = new GeneralPath();
((GeneralPath)shape).moveTo(71.78125, 16.0);
((GeneralPath)shape).curveTo(67.47136, 16.0, 64.0, 19.471355, 64.0, 23.78125);
((GeneralPath)shape).lineTo(64.0, 40.0);
((GeneralPath)shape).lineTo(8.0, 40.0);
((GeneralPath)shape).lineTo(8.0, 104.0);
((GeneralPath)shape).lineTo(120.0, 104.0);
((GeneralPath)shape).lineTo(120.0, 23.78125);
((GeneralPath)shape).curveTo(120.0, 19.471355, 116.52865, 16.0, 112.21875, 16.0);
((GeneralPath)shape).lineTo(71.78125, 16.0);
((GeneralPath)shape).closePath();
((GeneralPath)shape).moveTo(71.78125, 20.0);
((GeneralPath)shape).lineTo(112.21875, 20.0);
((GeneralPath)shape).curveTo(114.38082, 20.0, 116.0, 21.619188, 116.0, 23.78125);
((GeneralPath)shape).lineTo(116.0, 100.0);
((GeneralPath)shape).lineTo(12.0, 100.0);
((GeneralPath)shape).lineTo(12.0, 44.0);
((GeneralPath)shape).lineTo(64.0, 44.0);
((GeneralPath)shape).lineTo(68.0, 44.0);
((GeneralPath)shape).lineTo(68.0, 40.0);
((GeneralPath)shape).lineTo(68.0, 23.78125);
((GeneralPath)shape).curveTo(68.0, 21.61919, 69.619194, 20.0, 71.78125, 20.0);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_15_5);
g.setTransform(defaultTransform__0_0_15);
g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));
AffineTransform defaultTransform__0_0_16 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_16
shape = new GeneralPath();
((GeneralPath)shape).moveTo(72.0, 24.0);
((GeneralPath)shape).lineTo(72.0, 48.0);
((GeneralPath)shape).lineTo(16.0, 48.0);
((GeneralPath)shape).lineTo(16.0, 96.0);
((GeneralPath)shape).lineTo(112.0, 96.0);
((GeneralPath)shape).lineTo(112.0, 56.0);
((GeneralPath)shape).lineTo(112.0, 48.0);
((GeneralPath)shape).lineTo(112.0, 24.0);
((GeneralPath)shape).lineTo(72.0, 24.0);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_16);
g.setComposite(AlphaComposite.getInstance(3, 0.1f * origAlpha));
AffineTransform defaultTransform__0_0_17 = g.getTransform();
g.transform(new AffineTransform(0.9285709857940674f, 0.0f, 0.0f, 0.9285709857940674f, 71.74028015136719f, 4.4156084060668945f));
// _0_0_17
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_17_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_0
paint = new Color(191, 94, 0, 255);
stroke = new BasicStroke(8.615389f,0,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(41.438, 24.399);
((GeneralPath)shape).lineTo(56.0, 28.0);
((GeneralPath)shape).lineTo(41.438, 31.601);
((GeneralPath)shape).lineTo(52.249, 42.0);
((GeneralPath)shape).lineTo(37.837, 37.837);
((GeneralPath)shape).lineTo(42.0, 52.249);
((GeneralPath)shape).lineTo(31.601, 41.438);
((GeneralPath)shape).lineTo(28.0, 56.0);
((GeneralPath)shape).lineTo(24.399, 41.438);
((GeneralPath)shape).lineTo(14.0, 52.249);
((GeneralPath)shape).lineTo(18.163, 37.837);
((GeneralPath)shape).lineTo(3.751, 42.0);
((GeneralPath)shape).lineTo(14.562, 31.601);
((GeneralPath)shape).lineTo(0.0, 28.0);
((GeneralPath)shape).lineTo(14.562, 24.399);
((GeneralPath)shape).lineTo(3.751, 14.0);
((GeneralPath)shape).lineTo(18.163, 18.163);
((GeneralPath)shape).lineTo(14.0, 3.751);
((GeneralPath)shape).lineTo(24.399, 14.562);
((GeneralPath)shape).lineTo(28.0, 0.0);
((GeneralPath)shape).lineTo(28.0, 0.0);
((GeneralPath)shape).lineTo(31.601, 14.562);
((GeneralPath)shape).lineTo(42.0, 3.751);
((GeneralPath)shape).lineTo(37.837, 18.163);
((GeneralPath)shape).lineTo(52.249, 14.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_17_0);
g.setTransform(defaultTransform__0_0_17);
g.setComposite(AlphaComposite.getInstance(3, 0.15f * origAlpha));
AffineTransform defaultTransform__0_0_18 = g.getTransform();
g.transform(new AffineTransform(0.9285709857940674f, 0.0f, 0.0f, 0.9285709857940674f, 71.74028015136719f, 4.4156084060668945f));
// _0_0_18
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_18_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_18_0
paint = new Color(191, 94, 0, 255);
stroke = new BasicStroke(6.4615417f,0,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(41.438, 24.399);
((GeneralPath)shape).lineTo(56.0, 28.0);
((GeneralPath)shape).lineTo(41.438, 31.601);
((GeneralPath)shape).lineTo(52.249, 42.0);
((GeneralPath)shape).lineTo(37.837, 37.837);
((GeneralPath)shape).lineTo(42.0, 52.249);
((GeneralPath)shape).lineTo(31.601, 41.438);
((GeneralPath)shape).lineTo(28.0, 56.0);
((GeneralPath)shape).lineTo(24.399, 41.438);
((GeneralPath)shape).lineTo(14.0, 52.249);
((GeneralPath)shape).lineTo(18.163, 37.837);
((GeneralPath)shape).lineTo(3.751, 42.0);
((GeneralPath)shape).lineTo(14.562, 31.601);
((GeneralPath)shape).lineTo(0.0, 28.0);
((GeneralPath)shape).lineTo(14.562, 24.399);
((GeneralPath)shape).lineTo(3.751, 14.0);
((GeneralPath)shape).lineTo(18.163, 18.163);
((GeneralPath)shape).lineTo(14.0, 3.751);
((GeneralPath)shape).lineTo(24.399, 14.562);
((GeneralPath)shape).lineTo(28.0, 0.0);
((GeneralPath)shape).lineTo(28.0, 0.0);
((GeneralPath)shape).lineTo(31.601, 14.562);
((GeneralPath)shape).lineTo(42.0, 3.751);
((GeneralPath)shape).lineTo(37.837, 18.163);
((GeneralPath)shape).lineTo(52.249, 14.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_18_0);
g.setTransform(defaultTransform__0_0_18);
g.setComposite(AlphaComposite.getInstance(3, 0.2f * origAlpha));
AffineTransform defaultTransform__0_0_19 = g.getTransform();
g.transform(new AffineTransform(0.9285709857940674f, 0.0f, 0.0f, 0.9285709857940674f, 71.74028015136719f, 4.4156084060668945f));
// _0_0_19
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_19_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_19_0
paint = new Color(191, 94, 0, 255);
stroke = new BasicStroke(4.3076944f,0,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(41.438, 24.399);
((GeneralPath)shape).lineTo(56.0, 28.0);
((GeneralPath)shape).lineTo(41.438, 31.601);
((GeneralPath)shape).lineTo(52.249, 42.0);
((GeneralPath)shape).lineTo(37.837, 37.837);
((GeneralPath)shape).lineTo(42.0, 52.249);
((GeneralPath)shape).lineTo(31.601, 41.438);
((GeneralPath)shape).lineTo(28.0, 56.0);
((GeneralPath)shape).lineTo(24.399, 41.438);
((GeneralPath)shape).lineTo(14.0, 52.249);
((GeneralPath)shape).lineTo(18.163, 37.837);
((GeneralPath)shape).lineTo(3.751, 42.0);
((GeneralPath)shape).lineTo(14.562, 31.601);
((GeneralPath)shape).lineTo(0.0, 28.0);
((GeneralPath)shape).lineTo(14.562, 24.399);
((GeneralPath)shape).lineTo(3.751, 14.0);
((GeneralPath)shape).lineTo(18.163, 18.163);
((GeneralPath)shape).lineTo(14.0, 3.751);
((GeneralPath)shape).lineTo(24.399, 14.562);
((GeneralPath)shape).lineTo(28.0, 0.0);
((GeneralPath)shape).lineTo(28.0, 0.0);
((GeneralPath)shape).lineTo(31.601, 14.562);
((GeneralPath)shape).lineTo(42.0, 3.751);
((GeneralPath)shape).lineTo(37.837, 18.163);
((GeneralPath)shape).lineTo(52.249, 14.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_19_0);
g.setTransform(defaultTransform__0_0_19);
g.setComposite(AlphaComposite.getInstance(3, 0.25f * origAlpha));
AffineTransform defaultTransform__0_0_20 = g.getTransform();
g.transform(new AffineTransform(0.9285709857940674f, 0.0f, 0.0f, 0.9285709857940674f, 71.74028015136719f, 4.4156084060668945f));
// _0_0_20
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_20_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_20_0
paint = new Color(191, 94, 0, 255);
stroke = new BasicStroke(2.1538472f,0,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(41.438, 24.399);
((GeneralPath)shape).lineTo(56.0, 28.0);
((GeneralPath)shape).lineTo(41.438, 31.601);
((GeneralPath)shape).lineTo(52.249, 42.0);
((GeneralPath)shape).lineTo(37.837, 37.837);
((GeneralPath)shape).lineTo(42.0, 52.249);
((GeneralPath)shape).lineTo(31.601, 41.438);
((GeneralPath)shape).lineTo(28.0, 56.0);
((GeneralPath)shape).lineTo(24.399, 41.438);
((GeneralPath)shape).lineTo(14.0, 52.249);
((GeneralPath)shape).lineTo(18.163, 37.837);
((GeneralPath)shape).lineTo(3.751, 42.0);
((GeneralPath)shape).lineTo(14.562, 31.601);
((GeneralPath)shape).lineTo(0.0, 28.0);
((GeneralPath)shape).lineTo(14.562, 24.399);
((GeneralPath)shape).lineTo(3.751, 14.0);
((GeneralPath)shape).lineTo(18.163, 18.163);
((GeneralPath)shape).lineTo(14.0, 3.751);
((GeneralPath)shape).lineTo(24.399, 14.562);
((GeneralPath)shape).lineTo(28.0, 0.0);
((GeneralPath)shape).lineTo(28.0, 0.0);
((GeneralPath)shape).lineTo(31.601, 14.562);
((GeneralPath)shape).lineTo(42.0, 3.751);
((GeneralPath)shape).lineTo(37.837, 18.163);
((GeneralPath)shape).lineTo(52.249, 14.0);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_20_0);
g.setTransform(defaultTransform__0_0_20);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_21 = g.getTransform();
g.transform(new AffineTransform(0.9285709857940674f, 0.0f, 0.0f, 0.9285709857940674f, 71.74028015136719f, 4.4156084060668945f));
// _0_0_21
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_21_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_21_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(41.438, 24.399);
((GeneralPath)shape).lineTo(56.0, 28.0);
((GeneralPath)shape).lineTo(41.438, 31.601);
((GeneralPath)shape).lineTo(52.249, 42.0);
((GeneralPath)shape).lineTo(37.837, 37.837);
((GeneralPath)shape).lineTo(42.0, 52.249);
((GeneralPath)shape).lineTo(31.601, 41.438);
((GeneralPath)shape).lineTo(28.0, 56.0);
((GeneralPath)shape).lineTo(24.399, 41.438);
((GeneralPath)shape).lineTo(14.0, 52.249);
((GeneralPath)shape).lineTo(18.163, 37.837);
((GeneralPath)shape).lineTo(3.751, 42.0);
((GeneralPath)shape).lineTo(14.562, 31.601);
((GeneralPath)shape).lineTo(0.0, 28.0);
((GeneralPath)shape).lineTo(14.562, 24.399);
((GeneralPath)shape).lineTo(3.751, 14.0);
((GeneralPath)shape).lineTo(18.163, 18.163);
((GeneralPath)shape).lineTo(14.0, 3.751);
((GeneralPath)shape).lineTo(24.399, 14.562);
((GeneralPath)shape).lineTo(28.0, 0.0);
((GeneralPath)shape).lineTo(28.0, 0.0);
((GeneralPath)shape).lineTo(31.601, 14.562);
((GeneralPath)shape).lineTo(42.0, 3.751);
((GeneralPath)shape).lineTo(37.837, 18.163);
((GeneralPath)shape).lineTo(52.249, 14.0);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(28.0, 57.5), new Point2D.Double(28.0, 0.0), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 234, 0, 255),new Color(255, 204, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_21_0);
g.setTransform(defaultTransform__0_0_21);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_22 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_22
shape = new GeneralPath();
((GeneralPath)shape).moveTo(97.75042, 6.4141383);
((GeneralPath)shape).lineTo(94.65667, 18.882889);
((GeneralPath)shape).lineTo(85.75042, 9.632889);
((GeneralPath)shape).lineTo(89.31292, 21.976639);
((GeneralPath)shape).lineTo(76.96917, 18.414139);
((GeneralPath)shape).lineTo(86.21917, 27.320389);
((GeneralPath)shape).lineTo(79.06292, 29.101639);
((GeneralPath)shape).curveTo(84.0324, 31.664938, 90.58036, 33.22664, 97.75042, 33.22664);
((GeneralPath)shape).curveTo(104.92048, 33.22664, 111.43719, 31.664938, 116.40667, 29.101639);
((GeneralPath)shape).lineTo(109.25042, 27.320389);
((GeneralPath)shape).lineTo(118.53167, 18.414139);
((GeneralPath)shape).lineTo(106.15667, 21.976639);
((GeneralPath)shape).lineTo(109.75042, 9.632889);
((GeneralPath)shape).lineTo(100.81292, 18.882889);
((GeneralPath)shape).lineTo(97.75042, 6.414139);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(-39.53125, 78.0), new Point2D.Double(-39.53125, 51.1875), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 248, 168, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 137.28167724609375f, -44.77336120605469f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_22);
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
        return 0.0;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 127.74026489257812;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 108.0;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private tab_new_6() {
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
       tab_new_6 base = new tab_new_6();
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
       tab_new_6 base = new tab_new_6();
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
        return tab_new_6::new;
    }
}

