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
public class cross implements ResizableIcon {
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
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0
shape = new Rectangle2D.Double(0.7645368576049805, 0.41804227232933044, 30.761459350585938, 31.105712890625);
paint = new Color(51, 51, 51, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(125, 125, 181, 255);
stroke = new BasicStroke(0.40056232f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(0.7645368576049805, 0.41804227232933044, 30.761459350585938, 31.105712890625);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
shape = new Rectangle2D.Double(3.2993574142456055, 2.7678585052490234, 25.69182014465332, 18.40608024597168);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(0.86f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(3.2993574142456055, 2.7678585052490234, 25.69182014465332, 18.40608024597168);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
shape = new Rectangle2D.Double(3.0958375930786133, 25.342479705810547, 25.099628448486328, 2.293881416320801);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(0.4841821f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(3.0958375930786133, 25.342479705810547, 25.099628448486328, 2.293881416320801);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
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
generalPath.moveTo(9.012794f, 24.208595f);
generalPath.lineTo(9.012794f, 27.666185f);
generalPath.lineTo(10.381983f, 28.918934f);
generalPath.lineTo(10.479773f, 28.918934f);
generalPath.lineTo(10.62647f, 28.918934f);
generalPath.lineTo(10.72427f, 28.918934f);
generalPath.lineTo(12.093457f, 27.666185f);
generalPath.lineTo(12.093457f, 24.208595f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(0.30956125f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(9.012794f, 24.208595f);
generalPath.lineTo(9.012794f, 27.666185f);
generalPath.lineTo(10.381983f, 28.918934f);
generalPath.lineTo(10.479773f, 28.918934f);
generalPath.lineTo(10.62647f, 28.918934f);
generalPath.lineTo(10.72427f, 28.918934f);
generalPath.lineTo(12.093457f, 27.666185f);
generalPath.lineTo(12.093457f, 24.208595f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7488716840744019f, 0.0f, 0.0f, 0.5690102577209473f, -20.194122314453125f, -0.9660151600837708f));
// _0_0_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.003887f, 19.249956f);
generalPath.curveTo(37.00573f, 19.83393f, 36.786873f, 20.374664f, 36.430187f, 20.667408f);
generalPath.curveTo(36.0735f, 20.96015f, 35.633514f, 20.96015f, 35.27683f, 20.667408f);
generalPath.curveTo(34.920143f, 20.374664f, 34.701286f, 19.83393f, 34.70313f, 19.249956f);
generalPath.curveTo(34.701286f, 18.665983f, 34.920143f, 18.125248f, 35.27683f, 17.832504f);
generalPath.curveTo(35.633514f, 17.539762f, 36.0735f, 17.539762f, 36.430187f, 17.832504f);
generalPath.curveTo(36.786873f, 18.125248f, 37.00573f, 18.665983f, 37.003887f, 19.249956f);
generalPath.closePath();
shape = generalPath;
paint = new Color(204, 204, 204, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(204, 204, 204, 255);
stroke = new BasicStroke(0.3600241f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.003887f, 19.249956f);
generalPath.curveTo(37.00573f, 19.83393f, 36.786873f, 20.374664f, 36.430187f, 20.667408f);
generalPath.curveTo(36.0735f, 20.96015f, 35.633514f, 20.96015f, 35.27683f, 20.667408f);
generalPath.curveTo(34.920143f, 20.374664f, 34.701286f, 19.83393f, 34.70313f, 19.249956f);
generalPath.curveTo(34.701286f, 18.665983f, 34.920143f, 18.125248f, 35.27683f, 17.832504f);
generalPath.curveTo(35.633514f, 17.539762f, 36.0735f, 17.539762f, 36.430187f, 17.832504f);
generalPath.curveTo(36.786873f, 18.125248f, 37.00573f, 18.665983f, 37.003887f, 19.249956f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.6364778876304626f, 0.005731690209358931f, -0.0026428799610584974f, 0.48361077904701233f, -11.191279411315918f, 9.29566478729248f));
// _0_0_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.003887f, 19.249956f);
generalPath.curveTo(37.00573f, 19.83393f, 36.786873f, 20.374664f, 36.430187f, 20.667408f);
generalPath.curveTo(36.0735f, 20.96015f, 35.633514f, 20.96015f, 35.27683f, 20.667408f);
generalPath.curveTo(34.920143f, 20.374664f, 34.701286f, 19.83393f, 34.70313f, 19.249956f);
generalPath.curveTo(34.701286f, 18.665983f, 34.920143f, 18.125248f, 35.27683f, 17.832504f);
generalPath.curveTo(35.633514f, 17.539762f, 36.0735f, 17.539762f, 36.430187f, 17.832504f);
generalPath.curveTo(36.786873f, 18.125248f, 37.00573f, 18.665983f, 37.003887f, 19.249956f);
generalPath.closePath();
shape = generalPath;
paint = new Color(204, 204, 204, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(204, 204, 204, 255);
stroke = new BasicStroke(0.3600241f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.003887f, 19.249956f);
generalPath.curveTo(37.00573f, 19.83393f, 36.786873f, 20.374664f, 36.430187f, 20.667408f);
generalPath.curveTo(36.0735f, 20.96015f, 35.633514f, 20.96015f, 35.27683f, 20.667408f);
generalPath.curveTo(34.920143f, 20.374664f, 34.701286f, 19.83393f, 34.70313f, 19.249956f);
generalPath.curveTo(34.701286f, 18.665983f, 34.920143f, 18.125248f, 35.27683f, 17.832504f);
generalPath.curveTo(35.633514f, 17.539762f, 36.0735f, 17.539762f, 36.430187f, 17.832504f);
generalPath.curveTo(36.786873f, 18.125248f, 37.00573f, 18.665983f, 37.003887f, 19.249956f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.5664361119270325f, -0.061249859631061554f, 0.026451289653778076f, 0.459532231092453f, 3.0251972675323486f, 2.0013587474823f));
// _0_0_6
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.003887f, 19.249956f);
generalPath.curveTo(37.00573f, 19.83393f, 36.786873f, 20.374664f, 36.430187f, 20.667408f);
generalPath.curveTo(36.0735f, 20.96015f, 35.633514f, 20.96015f, 35.27683f, 20.667408f);
generalPath.curveTo(34.920143f, 20.374664f, 34.701286f, 19.83393f, 34.70313f, 19.249956f);
generalPath.curveTo(34.701286f, 18.665983f, 34.920143f, 18.125248f, 35.27683f, 17.832504f);
generalPath.curveTo(35.633514f, 17.539762f, 36.0735f, 17.539762f, 36.430187f, 17.832504f);
generalPath.curveTo(36.786873f, 18.125248f, 37.00573f, 18.665983f, 37.003887f, 19.249956f);
generalPath.closePath();
shape = generalPath;
paint = new Color(204, 204, 204, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(204, 204, 204, 255);
stroke = new BasicStroke(0.3600241f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.003887f, 19.249956f);
generalPath.curveTo(37.00573f, 19.83393f, 36.786873f, 20.374664f, 36.430187f, 20.667408f);
generalPath.curveTo(36.0735f, 20.96015f, 35.633514f, 20.96015f, 35.27683f, 20.667408f);
generalPath.curveTo(34.920143f, 20.374664f, 34.701286f, 19.83393f, 34.70313f, 19.249956f);
generalPath.curveTo(34.701286f, 18.665983f, 34.920143f, 18.125248f, 35.27683f, 17.832504f);
generalPath.curveTo(35.633514f, 17.539762f, 36.0735f, 17.539762f, 36.430187f, 17.832504f);
generalPath.curveTo(36.786873f, 18.125248f, 37.00573f, 18.665983f, 37.003887f, 19.249956f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.5168362259864807f, 0.0971650704741478f, -0.0448027104139328f, 0.3927043080329895f, -10.03794002532959f, -2.737287759780884f));
// _0_0_7
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.003887f, 19.249956f);
generalPath.curveTo(37.00573f, 19.83393f, 36.786873f, 20.374664f, 36.430187f, 20.667408f);
generalPath.curveTo(36.0735f, 20.96015f, 35.633514f, 20.96015f, 35.27683f, 20.667408f);
generalPath.curveTo(34.920143f, 20.374664f, 34.701286f, 19.83393f, 34.70313f, 19.249956f);
generalPath.curveTo(34.701286f, 18.665983f, 34.920143f, 18.125248f, 35.27683f, 17.832504f);
generalPath.curveTo(35.633514f, 17.539762f, 36.0735f, 17.539762f, 36.430187f, 17.832504f);
generalPath.curveTo(36.786873f, 18.125248f, 37.00573f, 18.665983f, 37.003887f, 19.249956f);
generalPath.closePath();
shape = generalPath;
paint = new Color(204, 204, 204, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(204, 204, 204, 255);
stroke = new BasicStroke(0.3600241f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.003887f, 19.249956f);
generalPath.curveTo(37.00573f, 19.83393f, 36.786873f, 20.374664f, 36.430187f, 20.667408f);
generalPath.curveTo(36.0735f, 20.96015f, 35.633514f, 20.96015f, 35.27683f, 20.667408f);
generalPath.curveTo(34.920143f, 20.374664f, 34.701286f, 19.83393f, 34.70313f, 19.249956f);
generalPath.curveTo(34.701286f, 18.665983f, 34.920143f, 18.125248f, 35.27683f, 17.832504f);
generalPath.curveTo(35.633514f, 17.539762f, 36.0735f, 17.539762f, 36.430187f, 17.832504f);
generalPath.curveTo(36.786873f, 18.125248f, 37.00573f, 18.665983f, 37.003887f, 19.249956f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.6947152018547058f, -0.05742023140192032f, 0.02647639997303486f, 0.5278608798980713f, -16.563743591308594f, 5.355872631072998f));
// _0_0_8
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.003887f, 19.249956f);
generalPath.curveTo(37.00573f, 19.83393f, 36.786873f, 20.374664f, 36.430187f, 20.667408f);
generalPath.curveTo(36.0735f, 20.96015f, 35.633514f, 20.96015f, 35.27683f, 20.667408f);
generalPath.curveTo(34.920143f, 20.374664f, 34.701286f, 19.83393f, 34.70313f, 19.249956f);
generalPath.curveTo(34.701286f, 18.665983f, 34.920143f, 18.125248f, 35.27683f, 17.832504f);
generalPath.curveTo(35.633514f, 17.539762f, 36.0735f, 17.539762f, 36.430187f, 17.832504f);
generalPath.curveTo(36.786873f, 18.125248f, 37.00573f, 18.665983f, 37.003887f, 19.249956f);
generalPath.closePath();
shape = generalPath;
paint = new Color(204, 204, 204, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(204, 204, 204, 255);
stroke = new BasicStroke(0.3600241f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.003887f, 19.249956f);
generalPath.curveTo(37.00573f, 19.83393f, 36.786873f, 20.374664f, 36.430187f, 20.667408f);
generalPath.curveTo(36.0735f, 20.96015f, 35.633514f, 20.96015f, 35.27683f, 20.667408f);
generalPath.curveTo(34.920143f, 20.374664f, 34.701286f, 19.83393f, 34.70313f, 19.249956f);
generalPath.curveTo(34.701286f, 18.665983f, 34.920143f, 18.125248f, 35.27683f, 17.832504f);
generalPath.curveTo(35.633514f, 17.539762f, 36.0735f, 17.539762f, 36.430187f, 17.832504f);
generalPath.curveTo(36.786873f, 18.125248f, 37.00573f, 18.665983f, 37.003887f, 19.249956f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0001064538955688f, 0.2590976357460022f, -0.10377854853868484f, 0.8748002052307129f, -14.033634185791016f, -7.0690412521362305f));
// _0_0_9
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.003887f, 19.249956f);
generalPath.curveTo(37.00573f, 19.83393f, 36.786873f, 20.374664f, 36.430187f, 20.667408f);
generalPath.curveTo(36.0735f, 20.96015f, 35.633514f, 20.96015f, 35.27683f, 20.667408f);
generalPath.curveTo(34.920143f, 20.374664f, 34.701286f, 19.83393f, 34.70313f, 19.249956f);
generalPath.curveTo(34.701286f, 18.665983f, 34.920143f, 18.125248f, 35.27683f, 17.832504f);
generalPath.curveTo(35.633514f, 17.539762f, 36.0735f, 17.539762f, 36.430187f, 17.832504f);
generalPath.curveTo(36.786873f, 18.125248f, 37.00573f, 18.665983f, 37.003887f, 19.249956f);
generalPath.closePath();
shape = generalPath;
paint = new Color(204, 204, 204, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(204, 204, 204, 255);
stroke = new BasicStroke(0.3600241f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.003887f, 19.249956f);
generalPath.curveTo(37.00573f, 19.83393f, 36.786873f, 20.374664f, 36.430187f, 20.667408f);
generalPath.curveTo(36.0735f, 20.96015f, 35.633514f, 20.96015f, 35.27683f, 20.667408f);
generalPath.curveTo(34.920143f, 20.374664f, 34.701286f, 19.83393f, 34.70313f, 19.249956f);
generalPath.curveTo(34.701286f, 18.665983f, 34.920143f, 18.125248f, 35.27683f, 17.832504f);
generalPath.curveTo(35.633514f, 17.539762f, 36.0735f, 17.539762f, 36.430187f, 17.832504f);
generalPath.curveTo(36.786873f, 18.125248f, 37.00573f, 18.665983f, 37.003887f, 19.249956f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.8226556777954102f, 0.04947822913527489f, -0.021367600187659264f, 0.6673952341079712f, -8.11094856262207f, -10.220070838928223f));
// _0_0_10
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.003887f, 19.249956f);
generalPath.curveTo(37.00573f, 19.83393f, 36.786873f, 20.374664f, 36.430187f, 20.667408f);
generalPath.curveTo(36.0735f, 20.96015f, 35.633514f, 20.96015f, 35.27683f, 20.667408f);
generalPath.curveTo(34.920143f, 20.374664f, 34.701286f, 19.83393f, 34.70313f, 19.249956f);
generalPath.curveTo(34.701286f, 18.665983f, 34.920143f, 18.125248f, 35.27683f, 17.832504f);
generalPath.curveTo(35.633514f, 17.539762f, 36.0735f, 17.539762f, 36.430187f, 17.832504f);
generalPath.curveTo(36.786873f, 18.125248f, 37.00573f, 18.665983f, 37.003887f, 19.249956f);
generalPath.closePath();
shape = generalPath;
paint = new Color(204, 204, 204, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(204, 204, 204, 255);
stroke = new BasicStroke(0.3600241f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.003887f, 19.249956f);
generalPath.curveTo(37.00573f, 19.83393f, 36.786873f, 20.374664f, 36.430187f, 20.667408f);
generalPath.curveTo(36.0735f, 20.96015f, 35.633514f, 20.96015f, 35.27683f, 20.667408f);
generalPath.curveTo(34.920143f, 20.374664f, 34.701286f, 19.83393f, 34.70313f, 19.249956f);
generalPath.curveTo(34.701286f, 18.665983f, 34.920143f, 18.125248f, 35.27683f, 17.832504f);
generalPath.curveTo(35.633514f, 17.539762f, 36.0735f, 17.539762f, 36.430187f, 17.832504f);
generalPath.curveTo(36.786873f, 18.125248f, 37.00573f, 18.665983f, 37.003887f, 19.249956f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.6991944313049316f, -0.11007501929998398f, 0.04753686115145683f, 0.567234992980957f, -0.6360608339309692f, -1.2641842365264893f));
// _0_0_11
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.003887f, 19.249956f);
generalPath.curveTo(37.00573f, 19.83393f, 36.786873f, 20.374664f, 36.430187f, 20.667408f);
generalPath.curveTo(36.0735f, 20.96015f, 35.633514f, 20.96015f, 35.27683f, 20.667408f);
generalPath.curveTo(34.920143f, 20.374664f, 34.701286f, 19.83393f, 34.70313f, 19.249956f);
generalPath.curveTo(34.701286f, 18.665983f, 34.920143f, 18.125248f, 35.27683f, 17.832504f);
generalPath.curveTo(35.633514f, 17.539762f, 36.0735f, 17.539762f, 36.430187f, 17.832504f);
generalPath.curveTo(36.786873f, 18.125248f, 37.00573f, 18.665983f, 37.003887f, 19.249956f);
generalPath.closePath();
shape = generalPath;
paint = new Color(204, 204, 204, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(204, 204, 204, 255);
stroke = new BasicStroke(0.3600241f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.003887f, 19.249956f);
generalPath.curveTo(37.00573f, 19.83393f, 36.786873f, 20.374664f, 36.430187f, 20.667408f);
generalPath.curveTo(36.0735f, 20.96015f, 35.633514f, 20.96015f, 35.27683f, 20.667408f);
generalPath.curveTo(34.920143f, 20.374664f, 34.701286f, 19.83393f, 34.70313f, 19.249956f);
generalPath.curveTo(34.701286f, 18.665983f, 34.920143f, 18.125248f, 35.27683f, 17.832504f);
generalPath.curveTo(35.633514f, 17.539762f, 36.0735f, 17.539762f, 36.430187f, 17.832504f);
generalPath.curveTo(36.786873f, 18.125248f, 37.00573f, 18.665983f, 37.003887f, 19.249956f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.8257830739021301f, 0.1652420312166214f, -0.07619292289018631f, 0.6274493336677551f, -17.346834182739258f, -8.224159240722656f));
// _0_0_12
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.003887f, 19.249956f);
generalPath.curveTo(37.00573f, 19.83393f, 36.786873f, 20.374664f, 36.430187f, 20.667408f);
generalPath.curveTo(36.0735f, 20.96015f, 35.633514f, 20.96015f, 35.27683f, 20.667408f);
generalPath.curveTo(34.920143f, 20.374664f, 34.701286f, 19.83393f, 34.70313f, 19.249956f);
generalPath.curveTo(34.701286f, 18.665983f, 34.920143f, 18.125248f, 35.27683f, 17.832504f);
generalPath.curveTo(35.633514f, 17.539762f, 36.0735f, 17.539762f, 36.430187f, 17.832504f);
generalPath.curveTo(36.786873f, 18.125248f, 37.00573f, 18.665983f, 37.003887f, 19.249956f);
generalPath.closePath();
shape = generalPath;
paint = new Color(204, 204, 204, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(204, 204, 204, 255);
stroke = new BasicStroke(0.3600241f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.003887f, 19.249956f);
generalPath.curveTo(37.00573f, 19.83393f, 36.786873f, 20.374664f, 36.430187f, 20.667408f);
generalPath.curveTo(36.0735f, 20.96015f, 35.633514f, 20.96015f, 35.27683f, 20.667408f);
generalPath.curveTo(34.920143f, 20.374664f, 34.701286f, 19.83393f, 34.70313f, 19.249956f);
generalPath.curveTo(34.701286f, 18.665983f, 34.920143f, 18.125248f, 35.27683f, 17.832504f);
generalPath.curveTo(35.633514f, 17.539762f, 36.0735f, 17.539762f, 36.430187f, 17.832504f);
generalPath.curveTo(36.786873f, 18.125248f, 37.00573f, 18.665983f, 37.003887f, 19.249956f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.5245476365089417f, -0.0906294733285904f, 0.04178914055228233f, 0.39856359362602234f, -14.764765739440918f, 14.603731155395508f));
// _0_0_13
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.003887f, 19.249956f);
generalPath.curveTo(37.00573f, 19.83393f, 36.786873f, 20.374664f, 36.430187f, 20.667408f);
generalPath.curveTo(36.0735f, 20.96015f, 35.633514f, 20.96015f, 35.27683f, 20.667408f);
generalPath.curveTo(34.920143f, 20.374664f, 34.701286f, 19.83393f, 34.70313f, 19.249956f);
generalPath.curveTo(34.701286f, 18.665983f, 34.920143f, 18.125248f, 35.27683f, 17.832504f);
generalPath.curveTo(35.633514f, 17.539762f, 36.0735f, 17.539762f, 36.430187f, 17.832504f);
generalPath.curveTo(36.786873f, 18.125248f, 37.00573f, 18.665983f, 37.003887f, 19.249956f);
generalPath.closePath();
shape = generalPath;
paint = new Color(204, 204, 204, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(204, 204, 204, 255);
stroke = new BasicStroke(0.3600241f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.003887f, 19.249956f);
generalPath.curveTo(37.00573f, 19.83393f, 36.786873f, 20.374664f, 36.430187f, 20.667408f);
generalPath.curveTo(36.0735f, 20.96015f, 35.633514f, 20.96015f, 35.27683f, 20.667408f);
generalPath.curveTo(34.920143f, 20.374664f, 34.701286f, 19.83393f, 34.70313f, 19.249956f);
generalPath.curveTo(34.701286f, 18.665983f, 34.920143f, 18.125248f, 35.27683f, 17.832504f);
generalPath.curveTo(35.633514f, 17.539762f, 36.0735f, 17.539762f, 36.430187f, 17.832504f);
generalPath.curveTo(36.786873f, 18.125248f, 37.00573f, 18.665983f, 37.003887f, 19.249956f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9588814973831177f, -0.19862008094787598f, 0.0915834903717041f, 0.7285805940628052f, -29.681690216064453f, 6.495574474334717f));
// _0_0_14
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.003887f, 19.249956f);
generalPath.curveTo(37.00573f, 19.83393f, 36.786873f, 20.374664f, 36.430187f, 20.667408f);
generalPath.curveTo(36.0735f, 20.96015f, 35.633514f, 20.96015f, 35.27683f, 20.667408f);
generalPath.curveTo(34.920143f, 20.374664f, 34.701286f, 19.83393f, 34.70313f, 19.249956f);
generalPath.curveTo(34.701286f, 18.665983f, 34.920143f, 18.125248f, 35.27683f, 17.832504f);
generalPath.curveTo(35.633514f, 17.539762f, 36.0735f, 17.539762f, 36.430187f, 17.832504f);
generalPath.curveTo(36.786873f, 18.125248f, 37.00573f, 18.665983f, 37.003887f, 19.249956f);
generalPath.closePath();
shape = generalPath;
paint = new Color(204, 204, 204, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(204, 204, 204, 255);
stroke = new BasicStroke(0.3600241f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.003887f, 19.249956f);
generalPath.curveTo(37.00573f, 19.83393f, 36.786873f, 20.374664f, 36.430187f, 20.667408f);
generalPath.curveTo(36.0735f, 20.96015f, 35.633514f, 20.96015f, 35.27683f, 20.667408f);
generalPath.curveTo(34.920143f, 20.374664f, 34.701286f, 19.83393f, 34.70313f, 19.249956f);
generalPath.curveTo(34.701286f, 18.665983f, 34.920143f, 18.125248f, 35.27683f, 17.832504f);
generalPath.curveTo(35.633514f, 17.539762f, 36.0735f, 17.539762f, 36.430187f, 17.832504f);
generalPath.curveTo(36.786873f, 18.125248f, 37.00573f, 18.665983f, 37.003887f, 19.249956f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7538958787918091f, -0.05170371010899544f, 0.023840520530939102f, 0.5728277564048767f, -18.463054656982422f, 8.340845108032227f));
// _0_0_15
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.003887f, 19.249956f);
generalPath.curveTo(37.00573f, 19.83393f, 36.786873f, 20.374664f, 36.430187f, 20.667408f);
generalPath.curveTo(36.0735f, 20.96015f, 35.633514f, 20.96015f, 35.27683f, 20.667408f);
generalPath.curveTo(34.920143f, 20.374664f, 34.701286f, 19.83393f, 34.70313f, 19.249956f);
generalPath.curveTo(34.701286f, 18.665983f, 34.920143f, 18.125248f, 35.27683f, 17.832504f);
generalPath.curveTo(35.633514f, 17.539762f, 36.0735f, 17.539762f, 36.430187f, 17.832504f);
generalPath.curveTo(36.786873f, 18.125248f, 37.00573f, 18.665983f, 37.003887f, 19.249956f);
generalPath.closePath();
shape = generalPath;
paint = new Color(204, 204, 204, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(204, 204, 204, 255);
stroke = new BasicStroke(0.3600241f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.003887f, 19.249956f);
generalPath.curveTo(37.00573f, 19.83393f, 36.786873f, 20.374664f, 36.430187f, 20.667408f);
generalPath.curveTo(36.0735f, 20.96015f, 35.633514f, 20.96015f, 35.27683f, 20.667408f);
generalPath.curveTo(34.920143f, 20.374664f, 34.701286f, 19.83393f, 34.70313f, 19.249956f);
generalPath.curveTo(34.701286f, 18.665983f, 34.920143f, 18.125248f, 35.27683f, 17.832504f);
generalPath.curveTo(35.633514f, 17.539762f, 36.0735f, 17.539762f, 36.430187f, 17.832504f);
generalPath.curveTo(36.786873f, 18.125248f, 37.00573f, 18.665983f, 37.003887f, 19.249956f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7737888097763062f, -0.10737934708595276f, 0.04951250180602074f, 0.587942898273468f, -19.92238998413086f, 11.46832275390625f));
// _0_0_16
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.003887f, 19.249956f);
generalPath.curveTo(37.00573f, 19.83393f, 36.786873f, 20.374664f, 36.430187f, 20.667408f);
generalPath.curveTo(36.0735f, 20.96015f, 35.633514f, 20.96015f, 35.27683f, 20.667408f);
generalPath.curveTo(34.920143f, 20.374664f, 34.701286f, 19.83393f, 34.70313f, 19.249956f);
generalPath.curveTo(34.701286f, 18.665983f, 34.920143f, 18.125248f, 35.27683f, 17.832504f);
generalPath.curveTo(35.633514f, 17.539762f, 36.0735f, 17.539762f, 36.430187f, 17.832504f);
generalPath.curveTo(36.786873f, 18.125248f, 37.00573f, 18.665983f, 37.003887f, 19.249956f);
generalPath.closePath();
shape = generalPath;
paint = new Color(204, 204, 204, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(204, 204, 204, 255);
stroke = new BasicStroke(0.3600241f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(37.003887f, 19.249956f);
generalPath.curveTo(37.00573f, 19.83393f, 36.786873f, 20.374664f, 36.430187f, 20.667408f);
generalPath.curveTo(36.0735f, 20.96015f, 35.633514f, 20.96015f, 35.27683f, 20.667408f);
generalPath.curveTo(34.920143f, 20.374664f, 34.701286f, 19.83393f, 34.70313f, 19.249956f);
generalPath.curveTo(34.701286f, 18.665983f, 34.920143f, 18.125248f, 35.27683f, 17.832504f);
generalPath.curveTo(35.633514f, 17.539762f, 36.0735f, 17.539762f, 36.430187f, 17.832504f);
generalPath.curveTo(36.786873f, 18.125248f, 37.00573f, 18.665983f, 37.003887f, 19.249956f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7432631850242615f, 0.0f, 0.0f, 0.773467481136322f, -10.075807571411133f, 44.24010467529297f));
// _0_0_17
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_0
paint = new Color(0, 255, 0, 255);
stroke = new BasicStroke(2.6377745f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(35.27832f, -47.567947f);
generalPath.lineTo(35.27832f, -35.872417f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17_1
paint = new Color(0, 255, 0, 255);
stroke = new BasicStroke(2.6377745f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(29.430553f, -41.720184f);
generalPath.lineTo(41.126083f, -41.720184f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
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
        return 0.5642557144165039;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 0.2177611142396927;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 31.16202163696289;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 31.506275177001953;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private cross() {
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
       cross base = new cross();
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
       cross base = new cross();
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
        return cross::new;
    }
}

