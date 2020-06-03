package com.actelion.research.orbit.imageAnalysis.components.icons;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.ref.WeakReference;
import java.util.Base64;
import java.util.Stack;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import javax.swing.plaf.UIResource;

import org.pushingpixels.neon.api.icon.ResizableIcon;
import org.pushingpixels.neon.api.icon.ResizableIconUIResource;

/**
 * This class has been automatically generated using <a
 * href="https://github.com/kirill-grouchnikov/radiance">Photon SVG transcoder</a>.
 */
public class tab_new_6 implements ResizableIcon {
    private Shape shape = null;
    private GeneralPath generalPath = null;
    private Paint paint = null;
    private Stroke stroke = null;
    private Shape clip = null;
    private Stack<AffineTransform> transformsStack = new Stack<>();

    

	private void _paint0(Graphics2D g,float origAlpha) {
transformsStack.push(g.getTransform());
// 
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0
g.setComposite(AlphaComposite.getInstance(3, 0.7802198f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-1.0f, 0.0f, 0.0f, 1.0f, 128.0f, 0.0f));
// _0_0_0
g.setComposite(AlphaComposite.getInstance(3, 0.25f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(71.78125f, 20.0f);
generalPath.curveTo(67.47136f, 20.0f, 64.0f, 23.471355f, 64.0f, 27.78125f);
generalPath.lineTo(64.0f, 48.0f);
generalPath.lineTo(29.0f, 48.0f);
generalPath.lineTo(29.0f, 89.0f);
generalPath.lineTo(120.0f, 89.0f);
generalPath.lineTo(120.0f, 27.78125f);
generalPath.curveTo(120.0f, 23.471355f, 116.52865f, 20.0f, 112.21875f, 20.0f);
generalPath.lineTo(71.78125f, 20.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(55.54030227661133, 199.0931854248047), new Point2D.Double(53.0167236328125, 40.745628356933594), new float[] {0.0f,0.4259708f,0.5892781f,0.8021978f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 255),new Color(241, 241, 241, 255),new Color(234, 234, 234, 255),new Color(223, 223, 223, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(4.0f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(71.78125f, 20.0f);
generalPath.curveTo(67.47136f, 20.0f, 64.0f, 23.471355f, 64.0f, 27.78125f);
generalPath.lineTo(64.0f, 48.0f);
generalPath.lineTo(29.0f, 48.0f);
generalPath.lineTo(29.0f, 89.0f);
generalPath.lineTo(120.0f, 89.0f);
generalPath.lineTo(120.0f, 27.78125f);
generalPath.curveTo(120.0f, 23.471355f, 116.52865f, 20.0f, 112.21875f, 20.0f);
generalPath.lineTo(71.78125f, 20.0f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.3f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(71.78125f, 20.0f);
generalPath.curveTo(67.47136f, 20.0f, 64.0f, 23.471355f, 64.0f, 27.78125f);
generalPath.lineTo(64.0f, 48.0f);
generalPath.lineTo(25.0f, 48.0f);
generalPath.lineTo(25.0f, 84.0f);
generalPath.lineTo(120.0f, 84.0f);
generalPath.lineTo(120.0f, 27.78125f);
generalPath.curveTo(120.0f, 23.471355f, 116.52865f, 20.0f, 112.21875f, 20.0f);
generalPath.lineTo(71.78125f, 20.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(55.54030227661133, 199.0931854248047), new Point2D.Double(53.0167236328125, 40.745628356933594), new float[] {0.0f,0.4259708f,0.5892781f,0.8021978f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 255),new Color(241, 241, 241, 255),new Color(234, 234, 234, 255),new Color(223, 223, 223, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(71.78125f, 20.0f);
generalPath.curveTo(67.47136f, 20.0f, 64.0f, 23.471355f, 64.0f, 27.78125f);
generalPath.lineTo(64.0f, 48.0f);
generalPath.lineTo(25.0f, 48.0f);
generalPath.lineTo(25.0f, 84.0f);
generalPath.lineTo(120.0f, 84.0f);
generalPath.lineTo(120.0f, 27.78125f);
generalPath.curveTo(120.0f, 23.471355f, 116.52865f, 20.0f, 112.21875f, 20.0f);
generalPath.lineTo(71.78125f, 20.0f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(71.78125f, 20.0f);
generalPath.curveTo(67.47136f, 20.0f, 64.0f, 23.471355f, 64.0f, 27.78125f);
generalPath.lineTo(64.0f, 48.0f);
generalPath.lineTo(24.0f, 48.0f);
generalPath.lineTo(24.0f, 84.0f);
generalPath.lineTo(120.0f, 84.0f);
generalPath.lineTo(120.0f, 27.78125f);
generalPath.curveTo(120.0f, 23.471355f, 116.52865f, 20.0f, 112.21875f, 20.0f);
generalPath.lineTo(71.78125f, 20.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(55.54030227661133, 199.0931854248047), new Point2D.Double(53.0167236328125, 40.745628356933594), new float[] {0.0f,0.4259708f,0.5892781f,0.8021978f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 255),new Color(241, 241, 241, 255),new Color(234, 234, 234, 255),new Color(223, 223, 223, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(116.76293f, 4.7358413f);
generalPath.lineTo(116.76293f, 1.9411328f);
generalPath.lineTo(116.76293f, 4.7358413f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-106.1155f, -66.353806f);
generalPath.lineTo(-106.1155f, -69.14851f);
generalPath.lineTo(-106.1155f, -66.353806f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-225.6177f, -152.98405f);
generalPath.lineTo(-225.6177f, -155.77876f);
generalPath.lineTo(-225.6177f, -152.98405f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -42.666099548339844f, -8.402420043945312f));
// _0_0_4
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -42.666099548339844f, -8.402420043945312f));
// _0_0_5
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(20.9737f, -87.22878f);
generalPath.lineTo(20.9737f, -90.02349f);
generalPath.lineTo(20.9737f, -87.22878f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(81.28432f, -7.9325066f);
generalPath.lineTo(81.28432f, -9.459243f);
generalPath.lineTo(81.28432f, -7.932507f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-323.1997f, -170.67877f);
generalPath.lineTo(-323.1997f, -173.47348f);
generalPath.lineTo(-323.1997f, -170.67877f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-0.7829949855804443f, 0.0f, 0.0f, 0.6508790254592896f, -2646.05810546875f, 515.8389282226562f));
// _0_0_11
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-0.7829949855804443f, 0.0f, 0.0f, 0.6508790254592896f, -2646.05810546875f, 515.8389282226562f));
// _0_0_12
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 0.6508790254592896f, 554.9047241210938f, 523.1666870117188f));
// _0_0_13
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 0.6508790254592896f, 554.9047241210938f, 523.1666870117188f));
// _0_0_14
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15
g.setComposite(AlphaComposite.getInstance(3, 0.1f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(71.78125f, 16.0f);
generalPath.curveTo(67.47136f, 16.0f, 64.0f, 19.471355f, 64.0f, 23.78125f);
generalPath.lineTo(64.0f, 40.0f);
generalPath.lineTo(8.0f, 40.0f);
generalPath.lineTo(8.0f, 104.0f);
generalPath.lineTo(120.0f, 104.0f);
generalPath.lineTo(120.0f, 23.78125f);
generalPath.curveTo(120.0f, 19.471355f, 116.52865f, 16.0f, 112.21875f, 16.0f);
generalPath.lineTo(71.78125f, 16.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(55.54030227661133, 199.0931854248047), new Point2D.Double(53.0167236328125, 40.745628356933594), new float[] {0.0f,0.4259708f,0.5892781f,0.8021978f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 255),new Color(241, 241, 241, 255),new Color(234, 234, 234, 255),new Color(223, 223, 223, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(8.0f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(71.78125f, 16.0f);
generalPath.curveTo(67.47136f, 16.0f, 64.0f, 19.471355f, 64.0f, 23.78125f);
generalPath.lineTo(64.0f, 40.0f);
generalPath.lineTo(8.0f, 40.0f);
generalPath.lineTo(8.0f, 104.0f);
generalPath.lineTo(120.0f, 104.0f);
generalPath.lineTo(120.0f, 23.78125f);
generalPath.curveTo(120.0f, 19.471355f, 116.52865f, 16.0f, 112.21875f, 16.0f);
generalPath.lineTo(71.78125f, 16.0f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.2f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(71.78125f, 16.0f);
generalPath.curveTo(67.47136f, 16.0f, 64.0f, 19.471355f, 64.0f, 23.78125f);
generalPath.lineTo(64.0f, 40.0f);
generalPath.lineTo(8.0f, 40.0f);
generalPath.lineTo(8.0f, 104.0f);
generalPath.lineTo(120.0f, 104.0f);
generalPath.lineTo(120.0f, 23.78125f);
generalPath.curveTo(120.0f, 19.471355f, 116.52865f, 16.0f, 112.21875f, 16.0f);
generalPath.lineTo(71.78125f, 16.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(55.54030227661133, 199.0931854248047), new Point2D.Double(53.0167236328125, 40.745628356933594), new float[] {0.0f,0.4259708f,0.5892781f,0.8021978f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 255),new Color(241, 241, 241, 255),new Color(234, 234, 234, 255),new Color(223, 223, 223, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(6.0f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(71.78125f, 16.0f);
generalPath.curveTo(67.47136f, 16.0f, 64.0f, 19.471355f, 64.0f, 23.78125f);
generalPath.lineTo(64.0f, 40.0f);
generalPath.lineTo(8.0f, 40.0f);
generalPath.lineTo(8.0f, 104.0f);
generalPath.lineTo(120.0f, 104.0f);
generalPath.lineTo(120.0f, 23.78125f);
generalPath.curveTo(120.0f, 19.471355f, 116.52865f, 16.0f, 112.21875f, 16.0f);
generalPath.lineTo(71.78125f, 16.0f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.3f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(71.78125f, 16.0f);
generalPath.curveTo(67.47136f, 16.0f, 64.0f, 19.471355f, 64.0f, 23.78125f);
generalPath.lineTo(64.0f, 40.0f);
generalPath.lineTo(8.0f, 40.0f);
generalPath.lineTo(8.0f, 104.0f);
generalPath.lineTo(120.0f, 104.0f);
generalPath.lineTo(120.0f, 23.78125f);
generalPath.curveTo(120.0f, 19.471355f, 116.52865f, 16.0f, 112.21875f, 16.0f);
generalPath.lineTo(71.78125f, 16.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(55.54030227661133, 199.0931854248047), new Point2D.Double(53.0167236328125, 40.745628356933594), new float[] {0.0f,0.4259708f,0.5892781f,0.8021978f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 255),new Color(241, 241, 241, 255),new Color(234, 234, 234, 255),new Color(223, 223, 223, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(71.78125f, 16.0f);
generalPath.curveTo(67.47136f, 16.0f, 64.0f, 19.471355f, 64.0f, 23.78125f);
generalPath.lineTo(64.0f, 40.0f);
generalPath.lineTo(8.0f, 40.0f);
generalPath.lineTo(8.0f, 104.0f);
generalPath.lineTo(120.0f, 104.0f);
generalPath.lineTo(120.0f, 23.78125f);
generalPath.curveTo(120.0f, 19.471355f, 116.52865f, 16.0f, 112.21875f, 16.0f);
generalPath.lineTo(71.78125f, 16.0f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.25f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(71.78125f, 16.0f);
generalPath.curveTo(67.47136f, 16.0f, 64.0f, 19.471355f, 64.0f, 23.78125f);
generalPath.lineTo(64.0f, 40.0f);
generalPath.lineTo(8.0f, 40.0f);
generalPath.lineTo(8.0f, 104.0f);
generalPath.lineTo(120.0f, 104.0f);
generalPath.lineTo(120.0f, 23.78125f);
generalPath.curveTo(120.0f, 19.471355f, 116.52865f, 16.0f, 112.21875f, 16.0f);
generalPath.lineTo(71.78125f, 16.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(55.54030227661133, 199.0931854248047), new Point2D.Double(53.0167236328125, 40.745628356933594), new float[] {0.0f,0.4259708f,0.5892781f,0.8021978f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 255),new Color(241, 241, 241, 255),new Color(234, 234, 234, 255),new Color(223, 223, 223, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(4.0f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(71.78125f, 16.0f);
generalPath.curveTo(67.47136f, 16.0f, 64.0f, 19.471355f, 64.0f, 23.78125f);
generalPath.lineTo(64.0f, 40.0f);
generalPath.lineTo(8.0f, 40.0f);
generalPath.lineTo(8.0f, 104.0f);
generalPath.lineTo(120.0f, 104.0f);
generalPath.lineTo(120.0f, 23.78125f);
generalPath.curveTo(120.0f, 19.471355f, 116.52865f, 16.0f, 112.21875f, 16.0f);
generalPath.lineTo(71.78125f, 16.0f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(71.78125f, 16.0f);
generalPath.curveTo(67.47136f, 16.0f, 64.0f, 19.471355f, 64.0f, 23.78125f);
generalPath.lineTo(64.0f, 40.0f);
generalPath.lineTo(8.0f, 40.0f);
generalPath.lineTo(8.0f, 104.0f);
generalPath.lineTo(120.0f, 104.0f);
generalPath.lineTo(120.0f, 23.78125f);
generalPath.curveTo(120.0f, 19.471355f, 116.52865f, 16.0f, 112.21875f, 16.0f);
generalPath.lineTo(71.78125f, 16.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(55.54030227661133, 199.0931854248047), new Point2D.Double(53.0167236328125, 40.745628356933594), new float[] {0.0f,0.4259708f,0.5892781f,0.8021978f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 255),new Color(241, 241, 241, 255),new Color(234, 234, 234, 255),new Color(223, 223, 223, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(71.78125f, 16.0f);
generalPath.curveTo(67.47136f, 16.0f, 64.0f, 19.471355f, 64.0f, 23.78125f);
generalPath.lineTo(64.0f, 40.0f);
generalPath.lineTo(8.0f, 40.0f);
generalPath.lineTo(8.0f, 104.0f);
generalPath.lineTo(120.0f, 104.0f);
generalPath.lineTo(120.0f, 23.78125f);
generalPath.curveTo(120.0f, 19.471355f, 116.52865f, 16.0f, 112.21875f, 16.0f);
generalPath.lineTo(71.78125f, 16.0f);
generalPath.closePath();
generalPath.moveTo(71.78125f, 20.0f);
generalPath.lineTo(112.21875f, 20.0f);
generalPath.curveTo(114.38082f, 20.0f, 116.0f, 21.619188f, 116.0f, 23.78125f);
generalPath.lineTo(116.0f, 100.0f);
generalPath.lineTo(12.0f, 100.0f);
generalPath.lineTo(12.0f, 44.0f);
generalPath.lineTo(64.0f, 44.0f);
generalPath.lineTo(68.0f, 44.0f);
generalPath.lineTo(68.0f, 40.0f);
generalPath.lineTo(68.0f, 23.78125f);
generalPath.curveTo(68.0f, 21.61919f, 69.619194f, 20.0f, 71.78125f, 20.0f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_16
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(72.0f, 24.0f);
generalPath.lineTo(72.0f, 48.0f);
generalPath.lineTo(16.0f, 48.0f);
generalPath.lineTo(16.0f, 96.0f);
generalPath.lineTo(112.0f, 96.0f);
generalPath.lineTo(112.0f, 56.0f);
generalPath.lineTo(112.0f, 48.0f);
generalPath.lineTo(112.0f, 24.0f);
generalPath.lineTo(72.0f, 24.0f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.1f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9285709857940674f, 0.0f, 0.0f, 0.9285709857940674f, 71.74028015136719f, 4.4156084060668945f));
// _0_0_17
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_0
paint = new Color(191, 94, 0, 255);
stroke = new BasicStroke(8.615389f,0,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(41.438f, 24.399f);
generalPath.lineTo(56.0f, 28.0f);
generalPath.lineTo(41.438f, 31.601f);
generalPath.lineTo(52.249f, 42.0f);
generalPath.lineTo(37.837f, 37.837f);
generalPath.lineTo(42.0f, 52.249f);
generalPath.lineTo(31.601f, 41.438f);
generalPath.lineTo(28.0f, 56.0f);
generalPath.lineTo(24.399f, 41.438f);
generalPath.lineTo(14.0f, 52.249f);
generalPath.lineTo(18.163f, 37.837f);
generalPath.lineTo(3.751f, 42.0f);
generalPath.lineTo(14.562f, 31.601f);
generalPath.lineTo(0.0f, 28.0f);
generalPath.lineTo(14.562f, 24.399f);
generalPath.lineTo(3.751f, 14.0f);
generalPath.lineTo(18.163f, 18.163f);
generalPath.lineTo(14.0f, 3.751f);
generalPath.lineTo(24.399f, 14.562f);
generalPath.lineTo(28.0f, 0.0f);
generalPath.lineTo(28.0f, 0.0f);
generalPath.lineTo(31.601f, 14.562f);
generalPath.lineTo(42.0f, 3.751f);
generalPath.lineTo(37.837f, 18.163f);
generalPath.lineTo(52.249f, 14.0f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.15f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9285709857940674f, 0.0f, 0.0f, 0.9285709857940674f, 71.74028015136719f, 4.4156084060668945f));
// _0_0_18
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_18_0
paint = new Color(191, 94, 0, 255);
stroke = new BasicStroke(6.4615417f,0,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(41.438f, 24.399f);
generalPath.lineTo(56.0f, 28.0f);
generalPath.lineTo(41.438f, 31.601f);
generalPath.lineTo(52.249f, 42.0f);
generalPath.lineTo(37.837f, 37.837f);
generalPath.lineTo(42.0f, 52.249f);
generalPath.lineTo(31.601f, 41.438f);
generalPath.lineTo(28.0f, 56.0f);
generalPath.lineTo(24.399f, 41.438f);
generalPath.lineTo(14.0f, 52.249f);
generalPath.lineTo(18.163f, 37.837f);
generalPath.lineTo(3.751f, 42.0f);
generalPath.lineTo(14.562f, 31.601f);
generalPath.lineTo(0.0f, 28.0f);
generalPath.lineTo(14.562f, 24.399f);
generalPath.lineTo(3.751f, 14.0f);
generalPath.lineTo(18.163f, 18.163f);
generalPath.lineTo(14.0f, 3.751f);
generalPath.lineTo(24.399f, 14.562f);
generalPath.lineTo(28.0f, 0.0f);
generalPath.lineTo(28.0f, 0.0f);
generalPath.lineTo(31.601f, 14.562f);
generalPath.lineTo(42.0f, 3.751f);
generalPath.lineTo(37.837f, 18.163f);
generalPath.lineTo(52.249f, 14.0f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.2f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9285709857940674f, 0.0f, 0.0f, 0.9285709857940674f, 71.74028015136719f, 4.4156084060668945f));
// _0_0_19
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_19_0
paint = new Color(191, 94, 0, 255);
stroke = new BasicStroke(4.3076944f,0,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(41.438f, 24.399f);
generalPath.lineTo(56.0f, 28.0f);
generalPath.lineTo(41.438f, 31.601f);
generalPath.lineTo(52.249f, 42.0f);
generalPath.lineTo(37.837f, 37.837f);
generalPath.lineTo(42.0f, 52.249f);
generalPath.lineTo(31.601f, 41.438f);
generalPath.lineTo(28.0f, 56.0f);
generalPath.lineTo(24.399f, 41.438f);
generalPath.lineTo(14.0f, 52.249f);
generalPath.lineTo(18.163f, 37.837f);
generalPath.lineTo(3.751f, 42.0f);
generalPath.lineTo(14.562f, 31.601f);
generalPath.lineTo(0.0f, 28.0f);
generalPath.lineTo(14.562f, 24.399f);
generalPath.lineTo(3.751f, 14.0f);
generalPath.lineTo(18.163f, 18.163f);
generalPath.lineTo(14.0f, 3.751f);
generalPath.lineTo(24.399f, 14.562f);
generalPath.lineTo(28.0f, 0.0f);
generalPath.lineTo(28.0f, 0.0f);
generalPath.lineTo(31.601f, 14.562f);
generalPath.lineTo(42.0f, 3.751f);
generalPath.lineTo(37.837f, 18.163f);
generalPath.lineTo(52.249f, 14.0f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.25f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9285709857940674f, 0.0f, 0.0f, 0.9285709857940674f, 71.74028015136719f, 4.4156084060668945f));
// _0_0_20
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_20_0
paint = new Color(191, 94, 0, 255);
stroke = new BasicStroke(2.1538472f,0,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(41.438f, 24.399f);
generalPath.lineTo(56.0f, 28.0f);
generalPath.lineTo(41.438f, 31.601f);
generalPath.lineTo(52.249f, 42.0f);
generalPath.lineTo(37.837f, 37.837f);
generalPath.lineTo(42.0f, 52.249f);
generalPath.lineTo(31.601f, 41.438f);
generalPath.lineTo(28.0f, 56.0f);
generalPath.lineTo(24.399f, 41.438f);
generalPath.lineTo(14.0f, 52.249f);
generalPath.lineTo(18.163f, 37.837f);
generalPath.lineTo(3.751f, 42.0f);
generalPath.lineTo(14.562f, 31.601f);
generalPath.lineTo(0.0f, 28.0f);
generalPath.lineTo(14.562f, 24.399f);
generalPath.lineTo(3.751f, 14.0f);
generalPath.lineTo(18.163f, 18.163f);
generalPath.lineTo(14.0f, 3.751f);
generalPath.lineTo(24.399f, 14.562f);
generalPath.lineTo(28.0f, 0.0f);
generalPath.lineTo(28.0f, 0.0f);
generalPath.lineTo(31.601f, 14.562f);
generalPath.lineTo(42.0f, 3.751f);
generalPath.lineTo(37.837f, 18.163f);
generalPath.lineTo(52.249f, 14.0f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9285709857940674f, 0.0f, 0.0f, 0.9285709857940674f, 71.74028015136719f, 4.4156084060668945f));
// _0_0_21
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_21_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(41.438f, 24.399f);
generalPath.lineTo(56.0f, 28.0f);
generalPath.lineTo(41.438f, 31.601f);
generalPath.lineTo(52.249f, 42.0f);
generalPath.lineTo(37.837f, 37.837f);
generalPath.lineTo(42.0f, 52.249f);
generalPath.lineTo(31.601f, 41.438f);
generalPath.lineTo(28.0f, 56.0f);
generalPath.lineTo(24.399f, 41.438f);
generalPath.lineTo(14.0f, 52.249f);
generalPath.lineTo(18.163f, 37.837f);
generalPath.lineTo(3.751f, 42.0f);
generalPath.lineTo(14.562f, 31.601f);
generalPath.lineTo(0.0f, 28.0f);
generalPath.lineTo(14.562f, 24.399f);
generalPath.lineTo(3.751f, 14.0f);
generalPath.lineTo(18.163f, 18.163f);
generalPath.lineTo(14.0f, 3.751f);
generalPath.lineTo(24.399f, 14.562f);
generalPath.lineTo(28.0f, 0.0f);
generalPath.lineTo(28.0f, 0.0f);
generalPath.lineTo(31.601f, 14.562f);
generalPath.lineTo(42.0f, 3.751f);
generalPath.lineTo(37.837f, 18.163f);
generalPath.lineTo(52.249f, 14.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(28.0, 57.5), new Point2D.Double(28.0, 0.0), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 234, 0, 255),new Color(255, 204, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_22
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(97.75042f, 6.4141383f);
generalPath.lineTo(94.65667f, 18.882889f);
generalPath.lineTo(85.75042f, 9.632889f);
generalPath.lineTo(89.31292f, 21.976639f);
generalPath.lineTo(76.96917f, 18.414139f);
generalPath.lineTo(86.21917f, 27.320389f);
generalPath.lineTo(79.06292f, 29.101639f);
generalPath.curveTo(84.0324f, 31.664938f, 90.58036f, 33.22664f, 97.75042f, 33.22664f);
generalPath.curveTo(104.92048f, 33.22664f, 111.43719f, 31.664938f, 116.40667f, 29.101639f);
generalPath.lineTo(109.25042f, 27.320389f);
generalPath.lineTo(118.53167f, 18.414139f);
generalPath.lineTo(106.15667f, 21.976639f);
generalPath.lineTo(109.75042f, 9.632889f);
generalPath.lineTo(100.81292f, 18.882889f);
generalPath.lineTo(97.75042f, 6.414139f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(-39.53125, 78.0), new Point2D.Double(-39.53125, 51.1875), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 248, 168, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 137.28167724609375f, -44.77336120605469f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());

}



    @SuppressWarnings("unused")
	private void innerPaint(Graphics2D g) {
        float origAlpha = 1.0f;
        Composite origComposite = g.getComposite();
        if (origComposite instanceof AlphaComposite) {
            AlphaComposite origAlphaComposite = 
                (AlphaComposite)origComposite;
            if (origAlphaComposite.getRule() == AlphaComposite.SRC_OVER) {
                origAlpha = origAlphaComposite.getAlpha();
            }
        }
        
	    _paint0(g, origAlpha);


	    shape = null;
	    generalPath = null;
	    paint = null;
	    stroke = null;
	    clip = null;
        transformsStack.clear();
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
	public synchronized void setDimension(Dimension newDimension) {
		this.width = newDimension.width;
		this.height = newDimension.height;
	}

    @Override
	public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
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

