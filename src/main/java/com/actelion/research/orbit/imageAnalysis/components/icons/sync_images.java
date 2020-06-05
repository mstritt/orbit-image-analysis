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
public class sync_images implements ResizableIcon {
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
g.setComposite(AlphaComposite.getInstance(3, 0.6f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0
shape = new Rectangle2D.Double(0.9569954872131348, 17.143653869628906, 20.21894073486328, 14.217958450317383);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(0.67052996f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(0.9569954872131348, 17.143653869628906, 20.21894073486328, 14.217958450317383);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-1.3013736009597778f, 0.221411794424057f, 0.12007444351911545f, 0.8407344818115234f, 58.80985641479492f, 4.872982501983643f));
// _0_0_1
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
g.transform(new AffineTransform(0.7482700347900391f, 0.0f, 0.0f, -0.4383470416069031f, -22.151905059814453f, 34.30451583862305f));
// _0_0_2
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
g.transform(new AffineTransform(0.5164210796356201f, -0.07485281676054001f, -0.04476672038435936f, -0.30252665281295776f, -12.003883361816406f, 35.669044494628906f));
// _0_0_3
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
g.transform(new AffineTransform(0.8251197338104248f, -0.12729710340499878f, -0.07613170146942139f, -0.48336663842201233f, -19.30690574645996f, 32.19227600097656f));
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
g.transform(new AffineTransform(-0.5659810900688171f, -0.047184910625219345f, -0.02643004059791565f, 0.3540087342262268f, 27.3309383392334f, 18.305599212646484f));
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
g.transform(new AffineTransform(-0.8219947218894958f, 0.038116421550512314f, 0.021350430324673653f, 0.5141396522521973f, 41.53690719604492f, 16.947582244873047f));
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
g.transform(new AffineTransform(-0.6986327171325684f, -0.08479823172092438f, -0.0474986806511879f, 0.4369794428348541f, 30.989255905151367f, 15.789931297302246f));
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
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8
paint = new Color(255, 102, 0, 255);
stroke = new BasicStroke(3.0f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(13.908886f, 12.997231f);
generalPath.curveTo(14.361232f, 11.313366f, 15.306676f, 9.752119f, 16.720943f, 8.562277f);
generalPath.curveTo(20.356043f, 5.5040245f, 25.71186f, 6.057538f, 28.683504f, 9.798585f);
generalPath.curveTo(31.655144f, 13.539631f, 31.117308f, 19.051552f, 27.48221f, 22.109804f);
generalPath.curveTo(25.501675f, 23.776052f, 23.010351f, 24.37016f, 20.672132f, 23.960737f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-1.193729043006897f, 0.2328932285308838f, 0.15743803977966309f, 0.702103853225708f, 48.75438690185547f, 5.035041332244873f));
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
g.transform(new AffineTransform(-0.4866008162498474f, 0.12399441003799438f, 0.0923822671175003f, 0.2878693640232086f, 24.80489158630371f, 8.64964485168457f));
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
g.transform(new AffineTransform(-1.0458868741989136f, 0.012583419680595398f, -0.047898270189762115f, 0.6041445136070251f, 46.270137786865234f, 9.382223129272461f));
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
g.setComposite(AlphaComposite.getInstance(3, 0.6f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_12
shape = new Rectangle2D.Double(0.7432937622070312, 0.35101190209388733, 20.21894073486328, 14.217958450317383);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(0.67052996f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(0.7432937622070312, 0.35101190209388733, 20.21894073486328, 14.217958450317383);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7482700347900391f, 0.0f, 0.0f, -0.4383470416069031f, -22.423234939575195f, 17.557355880737305f));
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
g.transform(new AffineTransform(0.5164210796356201f, -0.07485281676054001f, -0.04476672038435936f, -0.30252665281295776f, -12.275211334228516f, 18.921886444091797f));
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
g.transform(new AffineTransform(0.8219947814941406f, -0.038116421550512314f, -0.021350430324673653f, -0.5141396522521973f, -14.117988586425781f, 14.539020538330078f));
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
g.transform(new AffineTransform(0.49133479595184326f, 0.5838344097137451f, 0.4736658036708832f, -0.26862388849258423f, -17.382808685302734f, -11.168105125427246f));
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
g.transform(new AffineTransform(-0.19603298604488373f, -0.45881494879722595f, -0.3825528919696808f, 0.13308149576187134f, 17.403045654296875f, 18.929237365722656f));
// _0_0_17
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
g.transform(new AffineTransform(-0.39649590849876404f, -0.6200963258743286f, -0.5296849608421326f, 0.23954397439956665f, 31.482219696044922f, 27.31330108642578f));
// _0_0_18
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
g.transform(new AffineTransform(-0.2141425758600235f, -0.5778675675392151f, -0.4786652624607086f, 0.1527525633573532f, 21.62688446044922f, 20.671405792236328f));
// _0_0_19
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
g.transform(new AffineTransform(-0.8251197338104248f, 0.12729710340499878f, 0.07613170146942139f, 0.48336663842201233f, 47.41527557373047f, -10.318965911865234f));
// _0_0_20
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
g.transform(new AffineTransform(-0.7619101405143738f, -0.8235175609588623f, -0.6676899194717407f, 0.42647239565849304f, 50.63534927368164f, 29.280012130737305f));
// _0_0_21
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
g.transform(new AffineTransform(-0.7662674784660339f, -0.027167480438947678f, -0.04596152901649475f, 0.4778578579425812f, 40.412315368652344f, 2.7166035175323486f));
// _0_0_22
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
g.transform(new AffineTransform(-0.34104007482528687f, -0.3230864107608795f, -0.2616875469684601f, 0.1964128464460373f, 26.429201126098633f, 12.78455638885498f));
// _0_0_23
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
g.transform(new AffineTransform(-0.46684426069259644f, -0.804574191570282f, -0.6540690064430237f, 0.22495095431804657f, 34.97183609008789f, 29.727001190185547f));
// _0_0_24
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
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_25
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(13.148792f, 20.46595f);
generalPath.lineTo(21.642624f, 19.749557f);
generalPath.lineTo(19.222473f, 26.770332f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 102, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 102, 0, 255);
stroke = new BasicStroke(1.4400985f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(13.148792f, 20.46595f);
generalPath.lineTo(21.642624f, 19.749557f);
generalPath.lineTo(19.222473f, 26.770332f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
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
        return 0.408028781414032;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 0.01574692130088806;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 31.591970443725586;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 31.68113136291504;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private sync_images() {
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
       sync_images base = new sync_images();
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
       sync_images base = new sync_images();
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
        return sync_images::new;
    }
}

