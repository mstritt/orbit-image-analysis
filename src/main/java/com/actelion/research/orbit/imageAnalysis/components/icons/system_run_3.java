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
public class system_run_3 implements ResizableIcon {
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
g.setComposite(AlphaComposite.getInstance(3, 0.49019608f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.3881570100784302f, 0.0f, 0.0f, 0.4983609914779663f, -4.756162166595459f, 25.478679656982422f));
// _0_0_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(24.8125f, 34.65625f);
generalPath.curveTo(24.827724f, 38.07159f, 23.02037f, 41.234055f, 20.074806f, 42.946148f);
generalPath.curveTo(17.129242f, 44.658245f, 13.495757f, 44.658245f, 10.550193f, 42.946148f);
generalPath.curveTo(7.604629f, 41.234055f, 5.797276f, 38.07159f, 5.8125f, 34.65625f);
generalPath.curveTo(5.797276f, 31.240908f, 7.604629f, 28.078447f, 10.550193f, 26.36635f);
generalPath.curveTo(13.495757f, 24.654255f, 17.129242f, 24.654255f, 20.074806f, 26.36635f);
generalPath.curveTo(23.02037f, 28.078447f, 24.827724f, 31.240908f, 24.8125f, 34.65625f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(15.3125, 34.65625), 9.5f, new Point2D.Double(15.3125, 34.65625), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.003288984298706f, 0.0f, -0.11400099843740463f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.24705882f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.4736829996109009f, 0.0f, 0.0f, 0.6557379961013794f, 10.434249877929688f, 15.524580001831055f));
// _0_0_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(24.8125f, 34.65625f);
generalPath.curveTo(24.827724f, 38.07159f, 23.02037f, 41.234055f, 20.074806f, 42.946148f);
generalPath.curveTo(17.129242f, 44.658245f, 13.495757f, 44.658245f, 10.550193f, 42.946148f);
generalPath.curveTo(7.604629f, 41.234055f, 5.797276f, 38.07159f, 5.8125f, 34.65625f);
generalPath.curveTo(5.797276f, 31.240908f, 7.604629f, 28.078447f, 10.550193f, 26.36635f);
generalPath.curveTo(13.495757f, 24.654255f, 17.129242f, 24.654255f, 20.074806f, 26.36635f);
generalPath.curveTo(23.02037f, 28.078447f, 24.827724f, 31.240908f, 24.8125f, 34.65625f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(15.3125, 34.65625), 9.5f, new Point2D.Double(15.3125, 34.65625), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.003288984298706f, 0.0f, -0.11400099843740463f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9659259915351868f, 0.25881901383399963f, -0.25881901383399963f, 0.9659259915351868f, 6.162129878997803f, 8.385499954223633f));
// _0_0_2
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(31.0f, 0.5f);
generalPath.curveTo(30.438065f, 0.5f, 29.8842f, 0.547001f, 29.34375f, 0.625f);
generalPath.lineTo(29.125f, 3.71875f);
generalPath.curveTo(28.16536f, 3.9344947f, 27.275486f, 4.3022814f, 26.46875f, 4.8125f);
generalPath.lineTo(24.125f, 2.78125f);
generalPath.curveTo(22.999998f, 3.500001f, 22.5f, 4.0f, 21.78125f, 5.125f);
generalPath.lineTo(23.8125f, 7.46875f);
generalPath.curveTo(23.30228f, 8.275486f, 22.934496f, 9.1653595f, 22.71875f, 10.125f);
generalPath.lineTo(19.625f, 10.34375f);
generalPath.curveTo(19.547f, 10.8842f, 19.5f, 11.438062f, 19.5f, 12.0f);
generalPath.curveTo(19.499998f, 12.561939f, 19.547f, 13.115801f, 19.625f, 13.65625f);
generalPath.lineTo(22.71875f, 13.875f);
generalPath.curveTo(22.934496f, 14.834641f, 23.30228f, 15.724514f, 23.8125f, 16.53125f);
generalPath.lineTo(21.78125f, 18.875f);
generalPath.curveTo(22.5f, 19.999998f, 23.0f, 20.5f, 24.125f, 21.21875f);
generalPath.lineTo(26.46875f, 19.1875f);
generalPath.curveTo(27.275486f, 19.69772f, 28.16536f, 20.065504f, 29.125f, 20.28125f);
generalPath.lineTo(29.34375f, 23.375f);
generalPath.curveTo(29.8842f, 23.453f, 30.438063f, 23.5f, 31.0f, 23.5f);
generalPath.curveTo(31.561935f, 23.5f, 32.115803f, 23.453f, 32.65625f, 23.375f);
generalPath.lineTo(32.875f, 20.28125f);
generalPath.curveTo(33.83464f, 20.065504f, 34.724514f, 19.69772f, 35.53125f, 19.1875f);
generalPath.lineTo(37.875f, 21.21875f);
generalPath.curveTo(39.000004f, 20.499998f, 39.5f, 20.0f, 40.21875f, 18.875f);
generalPath.lineTo(38.1875f, 16.53125f);
generalPath.curveTo(38.69772f, 15.724514f, 39.065506f, 14.834641f, 39.28125f, 13.875f);
generalPath.lineTo(42.375f, 13.65625f);
generalPath.curveTo(42.453f, 13.115801f, 42.5f, 12.561939f, 42.5f, 12.0f);
generalPath.curveTo(42.5f, 11.438063f, 42.453f, 10.884199f, 42.375f, 10.34375f);
generalPath.lineTo(39.28125f, 10.125f);
generalPath.curveTo(39.065506f, 9.1653595f, 38.69772f, 8.275486f, 38.1875f, 7.46875f);
generalPath.lineTo(40.21875f, 5.125f);
generalPath.curveTo(39.56926f, 4.0173154f, 39.0f, 3.5f, 37.875f, 2.78125f);
generalPath.lineTo(35.53125f, 4.8125f);
generalPath.curveTo(34.724514f, 4.3022814f, 33.83464f, 3.9344947f, 32.875f, 3.71875f);
generalPath.lineTo(32.65625f, 0.625f);
generalPath.curveTo(32.1158f, 0.547001f, 31.561937f, 0.5f, 31.0f, 0.5f);
generalPath.closePath();
generalPath.moveTo(31.0f, 9.5f);
generalPath.curveTo(32.38f, 9.5f, 33.5f, 10.619998f, 33.5f, 12.0f);
generalPath.curveTo(33.5f, 13.380003f, 32.380005f, 14.5f, 31.0f, 14.5f);
generalPath.curveTo(29.619999f, 14.5f, 28.5f, 13.380003f, 28.5f, 12.0f);
generalPath.curveTo(28.5f, 10.619998f, 29.619999f, 9.5f, 31.0f, 9.5f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(22.96537971496582, 35.31056594848633), new Point2D.Double(12.641190528869629, 11.423575401306152), new float[] {0.0f,1.0f}, new Color[] {new Color(136, 138, 133, 255),new Color(211, 215, 207, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9659259915351868f, -0.25881901383399963f, 0.25881901383399963f, 0.9659259915351868f, 7.281559944152832f, 0.7556419968605042f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(46, 52, 54, 255);
stroke = new BasicStroke(1.0054358f,2,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(31.0f, 0.5f);
generalPath.curveTo(30.438065f, 0.5f, 29.8842f, 0.547001f, 29.34375f, 0.625f);
generalPath.lineTo(29.125f, 3.71875f);
generalPath.curveTo(28.16536f, 3.9344947f, 27.275486f, 4.3022814f, 26.46875f, 4.8125f);
generalPath.lineTo(24.125f, 2.78125f);
generalPath.curveTo(22.999998f, 3.500001f, 22.5f, 4.0f, 21.78125f, 5.125f);
generalPath.lineTo(23.8125f, 7.46875f);
generalPath.curveTo(23.30228f, 8.275486f, 22.934496f, 9.1653595f, 22.71875f, 10.125f);
generalPath.lineTo(19.625f, 10.34375f);
generalPath.curveTo(19.547f, 10.8842f, 19.5f, 11.438062f, 19.5f, 12.0f);
generalPath.curveTo(19.499998f, 12.561939f, 19.547f, 13.115801f, 19.625f, 13.65625f);
generalPath.lineTo(22.71875f, 13.875f);
generalPath.curveTo(22.934496f, 14.834641f, 23.30228f, 15.724514f, 23.8125f, 16.53125f);
generalPath.lineTo(21.78125f, 18.875f);
generalPath.curveTo(22.5f, 19.999998f, 23.0f, 20.5f, 24.125f, 21.21875f);
generalPath.lineTo(26.46875f, 19.1875f);
generalPath.curveTo(27.275486f, 19.69772f, 28.16536f, 20.065504f, 29.125f, 20.28125f);
generalPath.lineTo(29.34375f, 23.375f);
generalPath.curveTo(29.8842f, 23.453f, 30.438063f, 23.5f, 31.0f, 23.5f);
generalPath.curveTo(31.561935f, 23.5f, 32.115803f, 23.453f, 32.65625f, 23.375f);
generalPath.lineTo(32.875f, 20.28125f);
generalPath.curveTo(33.83464f, 20.065504f, 34.724514f, 19.69772f, 35.53125f, 19.1875f);
generalPath.lineTo(37.875f, 21.21875f);
generalPath.curveTo(39.000004f, 20.499998f, 39.5f, 20.0f, 40.21875f, 18.875f);
generalPath.lineTo(38.1875f, 16.53125f);
generalPath.curveTo(38.69772f, 15.724514f, 39.065506f, 14.834641f, 39.28125f, 13.875f);
generalPath.lineTo(42.375f, 13.65625f);
generalPath.curveTo(42.453f, 13.115801f, 42.5f, 12.561939f, 42.5f, 12.0f);
generalPath.curveTo(42.5f, 11.438063f, 42.453f, 10.884199f, 42.375f, 10.34375f);
generalPath.lineTo(39.28125f, 10.125f);
generalPath.curveTo(39.065506f, 9.1653595f, 38.69772f, 8.275486f, 38.1875f, 7.46875f);
generalPath.lineTo(40.21875f, 5.125f);
generalPath.curveTo(39.56926f, 4.0173154f, 39.0f, 3.5f, 37.875f, 2.78125f);
generalPath.lineTo(35.53125f, 4.8125f);
generalPath.curveTo(34.724514f, 4.3022814f, 33.83464f, 3.9344947f, 32.875f, 3.71875f);
generalPath.lineTo(32.65625f, 0.625f);
generalPath.curveTo(32.1158f, 0.547001f, 31.561937f, 0.5f, 31.0f, 0.5f);
generalPath.closePath();
generalPath.moveTo(31.0f, 9.5f);
generalPath.curveTo(32.38f, 9.5f, 33.5f, 10.619998f, 33.5f, 12.0f);
generalPath.curveTo(33.5f, 13.380003f, 32.380005f, 14.5f, 31.0f, 14.5f);
generalPath.curveTo(29.619999f, 14.5f, 28.5f, 13.380003f, 28.5f, 12.0f);
generalPath.curveTo(28.5f, 10.619998f, 29.619999f, 9.5f, 31.0f, 9.5f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_1
paint = new LinearGradientPaint(new Point2D.Double(17.413135528564453, 7.870833396911621), new Point2D.Double(17.027729034423828, 52.50489044189453), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9659259915351868f, -0.25881901383399963f, 0.25881901383399963f, 0.9659259915351868f, 7.281559944152832f, 0.7556419968605042f));
stroke = new BasicStroke(1.1333336f,2,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(31.000008f, 1.437503f);
generalPath.curveTo(30.739935f, 1.437503f, 30.477873f, 1.47946f, 30.218758f, 1.500003f);
generalPath.lineTo(30.000008f, 4.562504f);
generalPath.curveTo(28.682978f, 4.737208f, 27.478296f, 5.264549f, 26.468756f, 6.031255f);
generalPath.lineTo(24.156256f, 4.062504f);
generalPath.curveTo(23.765211f, 4.40014f, 23.400139f, 4.765213f, 23.062504f, 5.156255f);
generalPath.lineTo(25.031256f, 7.468756f);
generalPath.curveTo(24.26455f, 8.478295f, 23.737207f, 9.682977f, 23.562504f, 11.000006f);
generalPath.lineTo(20.500004f, 11.218757f);
generalPath.curveTo(20.47946f, 11.477873f, 20.437504f, 11.739933f, 20.437504f, 12.000007f);
generalPath.curveTo(20.437504f, 12.26008f, 20.47946f, 12.52214f, 20.500004f, 12.781257f);
generalPath.lineTo(23.562504f, 13.000007f);
generalPath.curveTo(23.737207f, 14.317036f, 24.26455f, 15.521718f, 25.031256f, 16.531258f);
generalPath.lineTo(23.062504f, 18.84376f);
generalPath.curveTo(23.400139f, 19.2348f, 23.765211f, 19.599874f, 24.156256f, 19.93751f);
generalPath.lineTo(26.468756f, 17.968758f);
generalPath.curveTo(27.478294f, 18.735464f, 28.682978f, 19.262806f, 30.000006f, 19.43751f);
generalPath.lineTo(30.218758f, 22.50001f);
generalPath.curveTo(30.477873f, 22.520554f, 30.739935f, 22.56251f, 31.000008f, 22.56251f);
generalPath.curveTo(31.260078f, 22.56251f, 31.52214f, 22.520554f, 31.781258f, 22.50001f);
generalPath.lineTo(32.000008f, 19.43751f);
generalPath.curveTo(33.317036f, 19.262806f, 34.521717f, 18.735464f, 35.531258f, 17.968758f);
generalPath.lineTo(37.843758f, 19.93751f);
generalPath.curveTo(38.234802f, 19.599874f, 38.599873f, 19.2348f, 38.937508f, 18.843758f);
generalPath.lineTo(36.968758f, 16.531258f);
generalPath.curveTo(37.735462f, 15.521718f, 38.262806f, 14.317036f, 38.437508f, 13.000007f);
generalPath.lineTo(41.50001f, 12.781257f);
generalPath.curveTo(41.520554f, 12.522141f, 41.56251f, 12.26008f, 41.56251f, 12.000006f);
generalPath.curveTo(41.56251f, 11.739934f, 41.520554f, 11.477873f, 41.50001f, 11.218757f);
generalPath.lineTo(38.437508f, 11.000007f);
generalPath.curveTo(38.262806f, 9.682977f, 37.735462f, 8.478296f, 36.968758f, 7.468755f);
generalPath.lineTo(38.937508f, 5.156254f);
generalPath.curveTo(38.599876f, 4.765213f, 38.234802f, 4.400139f, 37.843758f, 4.062504f);
generalPath.lineTo(35.531258f, 6.031255f);
generalPath.curveTo(34.52172f, 5.264549f, 33.317036f, 4.737207f, 32.000008f, 4.562504f);
generalPath.lineTo(31.781258f, 1.500003f);
generalPath.curveTo(31.52214f, 1.47946f, 31.26008f, 1.437504f, 31.000008f, 1.437503f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.8f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(31.0f, 0.875f);
generalPath.curveTo(30.67898f, 0.87500006f, 30.416025f, 0.91938233f, 30.1875f, 0.9375f);
generalPath.lineTo(29.6875f, 0.96875f);
generalPath.lineTo(29.65625f, 1.46875f);
generalPath.lineTo(29.46875f, 4.125f);
generalPath.curveTo(28.408657f, 4.334056f, 27.427074f, 4.7655263f, 26.5625f, 5.34375f);
generalPath.lineTo(24.15625f, 3.3125f);
generalPath.lineTo(22.3125f, 5.15625f);
generalPath.lineTo(24.34375f, 7.5625f);
generalPath.curveTo(23.765526f, 8.427073f, 23.334055f, 9.408658f, 23.125f, 10.46875f);
generalPath.lineTo(20.46875f, 10.65625f);
generalPath.lineTo(19.96875f, 10.6875f);
generalPath.lineTo(19.9375f, 11.1875f);
generalPath.curveTo(19.91938f, 11.416028f, 19.875f, 11.678982f, 19.875f, 12.0f);
generalPath.curveTo(19.875f, 12.321017f, 19.919382f, 12.583973f, 19.9375f, 12.8125f);
generalPath.lineTo(19.96875f, 13.3125f);
generalPath.lineTo(20.46875f, 13.34375f);
generalPath.lineTo(23.125f, 13.53125f);
generalPath.curveTo(23.334057f, 14.591342f, 23.765526f, 15.572926f, 24.34375f, 16.4375f);
generalPath.lineTo(22.625f, 18.46875f);
generalPath.lineTo(22.3125f, 18.84375f);
generalPath.lineTo(22.625f, 19.21875f);
generalPath.curveTo(22.98067f, 19.630678f, 23.36932f, 20.01933f, 23.78125f, 20.375f);
generalPath.lineTo(24.15625f, 20.6875f);
generalPath.lineTo(24.53125f, 20.375f);
generalPath.lineTo(26.5625f, 18.65625f);
generalPath.curveTo(27.427073f, 19.234474f, 28.408657f, 19.665945f, 29.46875f, 19.875f);
generalPath.lineTo(29.65625f, 22.53125f);
generalPath.lineTo(29.6875f, 23.03125f);
generalPath.lineTo(30.1875f, 23.0625f);
generalPath.curveTo(30.416027f, 23.08062f, 30.678982f, 23.125f, 31.0f, 23.125f);
generalPath.curveTo(31.321018f, 23.125002f, 31.583973f, 23.08062f, 31.8125f, 23.0625f);
generalPath.lineTo(32.3125f, 23.03125f);
generalPath.lineTo(32.34375f, 22.53125f);
generalPath.lineTo(32.53125f, 19.875f);
generalPath.curveTo(33.59134f, 19.665943f, 34.572926f, 19.234474f, 35.4375f, 18.65625f);
generalPath.lineTo(37.46875f, 20.375f);
generalPath.lineTo(37.84375f, 20.6875f);
generalPath.lineTo(38.21875f, 20.375f);
generalPath.curveTo(38.630684f, 20.01933f, 39.01933f, 19.63068f, 39.375f, 19.21875f);
generalPath.lineTo(39.6875f, 18.84375f);
generalPath.lineTo(39.375f, 18.46875f);
generalPath.lineTo(37.65625f, 16.4375f);
generalPath.curveTo(38.234474f, 15.572927f, 38.665943f, 14.591342f, 38.875f, 13.53125f);
generalPath.lineTo(41.53125f, 13.34375f);
generalPath.lineTo(42.03125f, 13.3125f);
generalPath.lineTo(42.0625f, 12.8125f);
generalPath.curveTo(42.080616f, 12.583975f, 42.125f, 12.321018f, 42.125f, 12.0f);
generalPath.curveTo(42.125f, 11.678985f, 42.08062f, 11.416028f, 42.0625f, 11.1875f);
generalPath.lineTo(42.03125f, 10.6875f);
generalPath.lineTo(41.53125f, 10.65625f);
generalPath.lineTo(38.875f, 10.46875f);
generalPath.curveTo(38.665943f, 9.408658f, 38.234474f, 8.4270735f, 37.65625f, 7.5625f);
generalPath.lineTo(39.375f, 5.53125f);
generalPath.lineTo(39.6875f, 5.15625f);
generalPath.lineTo(39.375f, 4.78125f);
generalPath.curveTo(39.019333f, 4.3693213f, 38.63068f, 3.9806705f, 38.21875f, 3.625f);
generalPath.lineTo(37.84375f, 3.3125f);
generalPath.lineTo(37.46875f, 3.625f);
generalPath.lineTo(35.4375f, 5.34375f);
generalPath.curveTo(34.572926f, 4.7655263f, 33.591343f, 4.3340554f, 32.53125f, 4.125f);
generalPath.lineTo(32.34375f, 1.46875f);
generalPath.lineTo(32.3125f, 0.96875f);
generalPath.lineTo(31.8125f, 0.9375f);
generalPath.curveTo(31.583973f, 0.9193822f, 31.321016f, 0.87500125f, 31.0f, 0.875f);
generalPath.closePath();
generalPath.moveTo(31.0f, 8.5f);
generalPath.curveTo(32.932f, 8.499998f, 34.499996f, 10.067999f, 34.5f, 12.0f);
generalPath.curveTo(34.500004f, 13.932002f, 32.932f, 15.499998f, 31.0f, 15.5f);
generalPath.curveTo(29.067999f, 15.500002f, 27.500002f, 13.932001f, 27.5f, 12.0f);
generalPath.curveTo(27.499998f, 10.067998f, 29.067999f, 8.500002f, 31.0f, 8.5f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(31.0, 12.0), 11.125f, new Point2D.Double(31.0, 12.0), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9774659872055054f, -0.261911004781723f, 0.261911004781723f, 0.9774659872055054f, -2.4443750381469727f, 8.389657020568848f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(31.0f, 4.0f);
generalPath.curveTo(26.584003f, 4.0f, 23.0f, 7.584f, 23.0f, 12.0f);
generalPath.curveTo(23.0f, 16.416f, 26.584002f, 20.000002f, 31.0f, 20.0f);
generalPath.curveTo(35.416f, 20.0f, 39.0f, 16.416f, 39.0f, 12.0f);
generalPath.curveTo(39.0f, 7.584f, 35.416f, 4.0f, 31.0f, 4.0f);
generalPath.closePath();
generalPath.moveTo(31.0f, 9.0f);
generalPath.curveTo(32.656f, 8.999998f, 33.999996f, 10.344006f, 34.0f, 12.0f);
generalPath.curveTo(34.000004f, 13.655994f, 32.656f, 14.999998f, 31.0f, 15.0f);
generalPath.curveTo(29.344f, 15.000002f, 28.000002f, 13.655994f, 28.0f, 12.0f);
generalPath.curveTo(27.999998f, 10.344006f, 29.344002f, 9.000002f, 31.0f, 9.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(21.78813362121582, 21.87696075439453), new Point2D.Double(10.211396217346191, 3.423278570175171), new float[] {0.0f,1.0f}, new Color[] {new Color(211, 215, 207, 255),new Color(136, 138, 133, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9091060161590576f, -0.2435940057039261f, 0.2435940057039261f, 0.9091060161590576f, 8.67676067352295f, 1.4170730113983154f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.8823530077934265f, -1.0264300271956017E-6f, 1.0264300271956017E-6f, 0.8823530077934265f, 10.264690399169922f, -4.764686107635498f));
// _0_0_2_4
paint = new LinearGradientPaint(new Point2D.Double(16.48750114440918, 13.970829010009766), new Point2D.Double(32.566654205322266, 30.758346557617188), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9659259915351868f, -0.25881901383399963f, 0.25881901383399963f, 0.9659259915351868f, -4.116819858551025f, 6.729656219482422f));
stroke = new BasicStroke(1.1333332f,2,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(32.0f, 19.0f);
generalPath.curveTo(32.013622f, 22.045813f, 30.396517f, 24.866106f, 27.761011f, 26.39296f);
generalPath.curveTo(25.125507f, 27.919811f, 21.874493f, 27.919811f, 19.238989f, 26.39296f);
generalPath.curveTo(16.603483f, 24.866106f, 14.986379f, 22.045813f, 15.0f, 19.0f);
generalPath.curveTo(14.986379f, 15.954186f, 16.603483f, 13.133893f, 19.238989f, 11.607041f);
generalPath.curveTo(21.874493f, 10.080189f, 25.125507f, 10.080189f, 27.761011f, 11.607041f);
generalPath.curveTo(30.396517f, 13.133893f, 32.013622f, 15.954186f, 32.0f, 19.0f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.4117650091648102f, -4.790002776644542E-7f, 4.790002776644542E-7f, 0.4117650091648102f, 21.323530197143555f, 4.176469802856445f));
// _0_0_2_5
paint = new LinearGradientPaint(new Point2D.Double(28.357093811035156, 22.794660568237305), new Point2D.Double(17.73212432861328, 5.187518119812012), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9659259915351868f, -0.25881901383399963f, 0.25881901383399963f, 0.9659259915351868f, -4.116824150085449f, 6.729647159576416f));
stroke = new BasicStroke(2.4285712f,2,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(32.0f, 19.0f);
generalPath.curveTo(32.013622f, 22.045813f, 30.396517f, 24.866106f, 27.761011f, 26.39296f);
generalPath.curveTo(25.125507f, 27.919811f, 21.874493f, 27.919811f, 19.238989f, 26.39296f);
generalPath.curveTo(16.603483f, 24.866106f, 14.986379f, 22.045813f, 15.0f, 19.0f);
generalPath.curveTo(14.986379f, 15.954186f, 16.603483f, 13.133893f, 19.238989f, 11.607041f);
generalPath.curveTo(21.874493f, 10.080189f, 25.125507f, 10.080189f, 27.761011f, 11.607041f);
generalPath.curveTo(30.396517f, 13.133893f, 32.013622f, 15.954186f, 32.0f, 19.0f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9659259915351868f, 0.25881901383399963f, -0.25881901383399963f, 0.9659259915351868f, -6.837870121002197f, -6.614500045776367f));
// _0_0_3
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(31.0f, 0.5f);
generalPath.curveTo(30.438065f, 0.5f, 29.8842f, 0.547001f, 29.34375f, 0.625f);
generalPath.lineTo(29.125f, 3.71875f);
generalPath.curveTo(28.16536f, 3.9344947f, 27.275486f, 4.3022814f, 26.46875f, 4.8125f);
generalPath.lineTo(24.125f, 2.78125f);
generalPath.curveTo(22.999998f, 3.500001f, 22.5f, 4.0f, 21.78125f, 5.125f);
generalPath.lineTo(23.8125f, 7.46875f);
generalPath.curveTo(23.30228f, 8.275486f, 22.934496f, 9.1653595f, 22.71875f, 10.125f);
generalPath.lineTo(19.625f, 10.34375f);
generalPath.curveTo(19.547f, 10.8842f, 19.5f, 11.438062f, 19.5f, 12.0f);
generalPath.curveTo(19.499998f, 12.561939f, 19.547f, 13.115801f, 19.625f, 13.65625f);
generalPath.lineTo(22.71875f, 13.875f);
generalPath.curveTo(22.934496f, 14.834641f, 23.30228f, 15.724514f, 23.8125f, 16.53125f);
generalPath.lineTo(21.78125f, 18.875f);
generalPath.curveTo(22.5f, 19.999998f, 23.0f, 20.5f, 24.125f, 21.21875f);
generalPath.lineTo(26.46875f, 19.1875f);
generalPath.curveTo(27.275486f, 19.69772f, 28.16536f, 20.065504f, 29.125f, 20.28125f);
generalPath.lineTo(29.34375f, 23.375f);
generalPath.curveTo(29.8842f, 23.453f, 30.438063f, 23.5f, 31.0f, 23.5f);
generalPath.curveTo(31.561935f, 23.5f, 32.115803f, 23.453f, 32.65625f, 23.375f);
generalPath.lineTo(32.875f, 20.28125f);
generalPath.curveTo(33.83464f, 20.065504f, 34.724514f, 19.69772f, 35.53125f, 19.1875f);
generalPath.lineTo(37.875f, 21.21875f);
generalPath.curveTo(39.000004f, 20.499998f, 39.5f, 20.0f, 40.21875f, 18.875f);
generalPath.lineTo(38.1875f, 16.53125f);
generalPath.curveTo(38.69772f, 15.724514f, 39.065506f, 14.834641f, 39.28125f, 13.875f);
generalPath.lineTo(42.375f, 13.65625f);
generalPath.curveTo(42.453f, 13.115801f, 42.5f, 12.561939f, 42.5f, 12.0f);
generalPath.curveTo(42.5f, 11.438063f, 42.453f, 10.884199f, 42.375f, 10.34375f);
generalPath.lineTo(39.28125f, 10.125f);
generalPath.curveTo(39.065506f, 9.1653595f, 38.69772f, 8.275486f, 38.1875f, 7.46875f);
generalPath.lineTo(40.21875f, 5.125f);
generalPath.curveTo(39.56926f, 4.0173154f, 39.0f, 3.5f, 37.875f, 2.78125f);
generalPath.lineTo(35.53125f, 4.8125f);
generalPath.curveTo(34.724514f, 4.3022814f, 33.83464f, 3.9344947f, 32.875f, 3.71875f);
generalPath.lineTo(32.65625f, 0.625f);
generalPath.curveTo(32.1158f, 0.547001f, 31.561937f, 0.5f, 31.0f, 0.5f);
generalPath.closePath();
generalPath.moveTo(31.0f, 9.5f);
generalPath.curveTo(32.38f, 9.5f, 33.5f, 10.619998f, 33.5f, 12.0f);
generalPath.curveTo(33.5f, 13.380003f, 32.380005f, 14.5f, 31.0f, 14.5f);
generalPath.curveTo(29.619999f, 14.5f, 28.5f, 13.380003f, 28.5f, 12.0f);
generalPath.curveTo(28.5f, 10.619998f, 29.619999f, 9.5f, 31.0f, 9.5f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(22.96537971496582, 35.31056594848633), new Point2D.Double(12.641190528869629, 11.423575401306152), new float[] {0.0f,1.0f}, new Color[] {new Color(136, 138, 133, 255),new Color(211, 215, 207, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9659259915351868f, -0.25881901383399963f, 0.25881901383399963f, 0.9659259915351868f, 7.281559944152832f, 0.7556419968605042f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(46, 52, 54, 255);
stroke = new BasicStroke(1.0054358f,2,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(31.0f, 0.5f);
generalPath.curveTo(30.438065f, 0.5f, 29.8842f, 0.547001f, 29.34375f, 0.625f);
generalPath.lineTo(29.125f, 3.71875f);
generalPath.curveTo(28.16536f, 3.9344947f, 27.275486f, 4.3022814f, 26.46875f, 4.8125f);
generalPath.lineTo(24.125f, 2.78125f);
generalPath.curveTo(22.999998f, 3.500001f, 22.5f, 4.0f, 21.78125f, 5.125f);
generalPath.lineTo(23.8125f, 7.46875f);
generalPath.curveTo(23.30228f, 8.275486f, 22.934496f, 9.1653595f, 22.71875f, 10.125f);
generalPath.lineTo(19.625f, 10.34375f);
generalPath.curveTo(19.547f, 10.8842f, 19.5f, 11.438062f, 19.5f, 12.0f);
generalPath.curveTo(19.499998f, 12.561939f, 19.547f, 13.115801f, 19.625f, 13.65625f);
generalPath.lineTo(22.71875f, 13.875f);
generalPath.curveTo(22.934496f, 14.834641f, 23.30228f, 15.724514f, 23.8125f, 16.53125f);
generalPath.lineTo(21.78125f, 18.875f);
generalPath.curveTo(22.5f, 19.999998f, 23.0f, 20.5f, 24.125f, 21.21875f);
generalPath.lineTo(26.46875f, 19.1875f);
generalPath.curveTo(27.275486f, 19.69772f, 28.16536f, 20.065504f, 29.125f, 20.28125f);
generalPath.lineTo(29.34375f, 23.375f);
generalPath.curveTo(29.8842f, 23.453f, 30.438063f, 23.5f, 31.0f, 23.5f);
generalPath.curveTo(31.561935f, 23.5f, 32.115803f, 23.453f, 32.65625f, 23.375f);
generalPath.lineTo(32.875f, 20.28125f);
generalPath.curveTo(33.83464f, 20.065504f, 34.724514f, 19.69772f, 35.53125f, 19.1875f);
generalPath.lineTo(37.875f, 21.21875f);
generalPath.curveTo(39.000004f, 20.499998f, 39.5f, 20.0f, 40.21875f, 18.875f);
generalPath.lineTo(38.1875f, 16.53125f);
generalPath.curveTo(38.69772f, 15.724514f, 39.065506f, 14.834641f, 39.28125f, 13.875f);
generalPath.lineTo(42.375f, 13.65625f);
generalPath.curveTo(42.453f, 13.115801f, 42.5f, 12.561939f, 42.5f, 12.0f);
generalPath.curveTo(42.5f, 11.438063f, 42.453f, 10.884199f, 42.375f, 10.34375f);
generalPath.lineTo(39.28125f, 10.125f);
generalPath.curveTo(39.065506f, 9.1653595f, 38.69772f, 8.275486f, 38.1875f, 7.46875f);
generalPath.lineTo(40.21875f, 5.125f);
generalPath.curveTo(39.56926f, 4.0173154f, 39.0f, 3.5f, 37.875f, 2.78125f);
generalPath.lineTo(35.53125f, 4.8125f);
generalPath.curveTo(34.724514f, 4.3022814f, 33.83464f, 3.9344947f, 32.875f, 3.71875f);
generalPath.lineTo(32.65625f, 0.625f);
generalPath.curveTo(32.1158f, 0.547001f, 31.561937f, 0.5f, 31.0f, 0.5f);
generalPath.closePath();
generalPath.moveTo(31.0f, 9.5f);
generalPath.curveTo(32.38f, 9.5f, 33.5f, 10.619998f, 33.5f, 12.0f);
generalPath.curveTo(33.5f, 13.380003f, 32.380005f, 14.5f, 31.0f, 14.5f);
generalPath.curveTo(29.619999f, 14.5f, 28.5f, 13.380003f, 28.5f, 12.0f);
generalPath.curveTo(28.5f, 10.619998f, 29.619999f, 9.5f, 31.0f, 9.5f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3_1
paint = new LinearGradientPaint(new Point2D.Double(17.413135528564453, 7.870833396911621), new Point2D.Double(17.027729034423828, 52.50489044189453), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9659259915351868f, -0.25881901383399963f, 0.25881901383399963f, 0.9659259915351868f, 7.281559944152832f, 0.7556419968605042f));
stroke = new BasicStroke(1.1333336f,2,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(31.000008f, 1.437503f);
generalPath.curveTo(30.739935f, 1.437503f, 30.477873f, 1.47946f, 30.218758f, 1.500003f);
generalPath.lineTo(30.000008f, 4.562504f);
generalPath.curveTo(28.682978f, 4.737208f, 27.478296f, 5.264549f, 26.468756f, 6.031255f);
generalPath.lineTo(24.156256f, 4.062504f);
generalPath.curveTo(23.765211f, 4.40014f, 23.400139f, 4.765213f, 23.062504f, 5.156255f);
generalPath.lineTo(25.031256f, 7.468756f);
generalPath.curveTo(24.26455f, 8.478295f, 23.737207f, 9.682977f, 23.562504f, 11.000006f);
generalPath.lineTo(20.500004f, 11.218757f);
generalPath.curveTo(20.47946f, 11.477873f, 20.437504f, 11.739933f, 20.437504f, 12.000007f);
generalPath.curveTo(20.437504f, 12.26008f, 20.47946f, 12.52214f, 20.500004f, 12.781257f);
generalPath.lineTo(23.562504f, 13.000007f);
generalPath.curveTo(23.737207f, 14.317036f, 24.26455f, 15.521718f, 25.031256f, 16.531258f);
generalPath.lineTo(23.062504f, 18.84376f);
generalPath.curveTo(23.400139f, 19.2348f, 23.765211f, 19.599874f, 24.156256f, 19.93751f);
generalPath.lineTo(26.468756f, 17.968758f);
generalPath.curveTo(27.478294f, 18.735464f, 28.682978f, 19.262806f, 30.000006f, 19.43751f);
generalPath.lineTo(30.218758f, 22.50001f);
generalPath.curveTo(30.477873f, 22.520554f, 30.739935f, 22.56251f, 31.000008f, 22.56251f);
generalPath.curveTo(31.260078f, 22.56251f, 31.52214f, 22.520554f, 31.781258f, 22.50001f);
generalPath.lineTo(32.000008f, 19.43751f);
generalPath.curveTo(33.317036f, 19.262806f, 34.521717f, 18.735464f, 35.531258f, 17.968758f);
generalPath.lineTo(37.843758f, 19.93751f);
generalPath.curveTo(38.234802f, 19.599874f, 38.599873f, 19.2348f, 38.937508f, 18.843758f);
generalPath.lineTo(36.968758f, 16.531258f);
generalPath.curveTo(37.735462f, 15.521718f, 38.262806f, 14.317036f, 38.437508f, 13.000007f);
generalPath.lineTo(41.50001f, 12.781257f);
generalPath.curveTo(41.520554f, 12.522141f, 41.56251f, 12.26008f, 41.56251f, 12.000006f);
generalPath.curveTo(41.56251f, 11.739934f, 41.520554f, 11.477873f, 41.50001f, 11.218757f);
generalPath.lineTo(38.437508f, 11.000007f);
generalPath.curveTo(38.262806f, 9.682977f, 37.735462f, 8.478296f, 36.968758f, 7.468755f);
generalPath.lineTo(38.937508f, 5.156254f);
generalPath.curveTo(38.599876f, 4.765213f, 38.234802f, 4.400139f, 37.843758f, 4.062504f);
generalPath.lineTo(35.531258f, 6.031255f);
generalPath.curveTo(34.52172f, 5.264549f, 33.317036f, 4.737207f, 32.000008f, 4.562504f);
generalPath.lineTo(31.781258f, 1.500003f);
generalPath.curveTo(31.52214f, 1.47946f, 31.26008f, 1.437504f, 31.000008f, 1.437503f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.8f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(31.0f, 0.875f);
generalPath.curveTo(30.67898f, 0.87500006f, 30.416025f, 0.91938233f, 30.1875f, 0.9375f);
generalPath.lineTo(29.6875f, 0.96875f);
generalPath.lineTo(29.65625f, 1.46875f);
generalPath.lineTo(29.46875f, 4.125f);
generalPath.curveTo(28.408657f, 4.334056f, 27.427074f, 4.7655263f, 26.5625f, 5.34375f);
generalPath.lineTo(24.15625f, 3.3125f);
generalPath.lineTo(22.3125f, 5.15625f);
generalPath.lineTo(24.34375f, 7.5625f);
generalPath.curveTo(23.765526f, 8.427073f, 23.334055f, 9.408658f, 23.125f, 10.46875f);
generalPath.lineTo(20.46875f, 10.65625f);
generalPath.lineTo(19.96875f, 10.6875f);
generalPath.lineTo(19.9375f, 11.1875f);
generalPath.curveTo(19.91938f, 11.416028f, 19.875f, 11.678982f, 19.875f, 12.0f);
generalPath.curveTo(19.875f, 12.321017f, 19.919382f, 12.583973f, 19.9375f, 12.8125f);
generalPath.lineTo(19.96875f, 13.3125f);
generalPath.lineTo(20.46875f, 13.34375f);
generalPath.lineTo(23.125f, 13.53125f);
generalPath.curveTo(23.334057f, 14.591342f, 23.765526f, 15.572926f, 24.34375f, 16.4375f);
generalPath.lineTo(22.625f, 18.46875f);
generalPath.lineTo(22.3125f, 18.84375f);
generalPath.lineTo(22.625f, 19.21875f);
generalPath.curveTo(22.98067f, 19.630678f, 23.36932f, 20.01933f, 23.78125f, 20.375f);
generalPath.lineTo(24.15625f, 20.6875f);
generalPath.lineTo(24.53125f, 20.375f);
generalPath.lineTo(26.5625f, 18.65625f);
generalPath.curveTo(27.427073f, 19.234474f, 28.408657f, 19.665945f, 29.46875f, 19.875f);
generalPath.lineTo(29.65625f, 22.53125f);
generalPath.lineTo(29.6875f, 23.03125f);
generalPath.lineTo(30.1875f, 23.0625f);
generalPath.curveTo(30.416027f, 23.08062f, 30.678982f, 23.125f, 31.0f, 23.125f);
generalPath.curveTo(31.321018f, 23.125002f, 31.583973f, 23.08062f, 31.8125f, 23.0625f);
generalPath.lineTo(32.3125f, 23.03125f);
generalPath.lineTo(32.34375f, 22.53125f);
generalPath.lineTo(32.53125f, 19.875f);
generalPath.curveTo(33.59134f, 19.665943f, 34.572926f, 19.234474f, 35.4375f, 18.65625f);
generalPath.lineTo(37.46875f, 20.375f);
generalPath.lineTo(37.84375f, 20.6875f);
generalPath.lineTo(38.21875f, 20.375f);
generalPath.curveTo(38.630684f, 20.01933f, 39.01933f, 19.63068f, 39.375f, 19.21875f);
generalPath.lineTo(39.6875f, 18.84375f);
generalPath.lineTo(39.375f, 18.46875f);
generalPath.lineTo(37.65625f, 16.4375f);
generalPath.curveTo(38.234474f, 15.572927f, 38.665943f, 14.591342f, 38.875f, 13.53125f);
generalPath.lineTo(41.53125f, 13.34375f);
generalPath.lineTo(42.03125f, 13.3125f);
generalPath.lineTo(42.0625f, 12.8125f);
generalPath.curveTo(42.080616f, 12.583975f, 42.125f, 12.321018f, 42.125f, 12.0f);
generalPath.curveTo(42.125f, 11.678985f, 42.08062f, 11.416028f, 42.0625f, 11.1875f);
generalPath.lineTo(42.03125f, 10.6875f);
generalPath.lineTo(41.53125f, 10.65625f);
generalPath.lineTo(38.875f, 10.46875f);
generalPath.curveTo(38.665943f, 9.408658f, 38.234474f, 8.4270735f, 37.65625f, 7.5625f);
generalPath.lineTo(39.375f, 5.53125f);
generalPath.lineTo(39.6875f, 5.15625f);
generalPath.lineTo(39.375f, 4.78125f);
generalPath.curveTo(39.019333f, 4.3693213f, 38.63068f, 3.9806705f, 38.21875f, 3.625f);
generalPath.lineTo(37.84375f, 3.3125f);
generalPath.lineTo(37.46875f, 3.625f);
generalPath.lineTo(35.4375f, 5.34375f);
generalPath.curveTo(34.572926f, 4.7655263f, 33.591343f, 4.3340554f, 32.53125f, 4.125f);
generalPath.lineTo(32.34375f, 1.46875f);
generalPath.lineTo(32.3125f, 0.96875f);
generalPath.lineTo(31.8125f, 0.9375f);
generalPath.curveTo(31.583973f, 0.9193822f, 31.321016f, 0.87500125f, 31.0f, 0.875f);
generalPath.closePath();
generalPath.moveTo(31.0f, 8.5f);
generalPath.curveTo(32.932f, 8.499998f, 34.499996f, 10.067999f, 34.5f, 12.0f);
generalPath.curveTo(34.500004f, 13.932002f, 32.932f, 15.499998f, 31.0f, 15.5f);
generalPath.curveTo(29.067999f, 15.500002f, 27.500002f, 13.932001f, 27.5f, 12.0f);
generalPath.curveTo(27.499998f, 10.067998f, 29.067999f, 8.500002f, 31.0f, 8.5f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(31.0, 12.0), 11.125f, new Point2D.Double(31.0, 12.0), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9774659872055054f, -0.261911004781723f, 0.261911004781723f, 0.9774659872055054f, -2.4443750381469727f, 8.389657020568848f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_3_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(31.0f, 4.0f);
generalPath.curveTo(26.584003f, 4.0f, 23.0f, 7.584f, 23.0f, 12.0f);
generalPath.curveTo(23.0f, 16.416f, 26.584002f, 20.000002f, 31.0f, 20.0f);
generalPath.curveTo(35.416f, 20.0f, 39.0f, 16.416f, 39.0f, 12.0f);
generalPath.curveTo(39.0f, 7.584f, 35.416f, 4.0f, 31.0f, 4.0f);
generalPath.closePath();
generalPath.moveTo(31.0f, 9.0f);
generalPath.curveTo(32.656f, 8.999998f, 33.999996f, 10.344006f, 34.0f, 12.0f);
generalPath.curveTo(34.000004f, 13.655994f, 32.656f, 14.999998f, 31.0f, 15.0f);
generalPath.curveTo(29.344f, 15.000002f, 28.000002f, 13.655994f, 28.0f, 12.0f);
generalPath.curveTo(27.999998f, 10.344006f, 29.344002f, 9.000002f, 31.0f, 9.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(21.78813362121582, 21.87696075439453), new Point2D.Double(10.211396217346191, 3.423278570175171), new float[] {0.0f,1.0f}, new Color[] {new Color(211, 215, 207, 255),new Color(136, 138, 133, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9091060161590576f, -0.2435940057039261f, 0.2435940057039261f, 0.9091060161590576f, 8.67676067352295f, 1.4170730113983154f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.8823530077934265f, -1.0264300271956017E-6f, 1.0264300271956017E-6f, 0.8823530077934265f, 10.264690399169922f, -4.764686107635498f));
// _0_0_3_4
paint = new LinearGradientPaint(new Point2D.Double(16.48750114440918, 13.970829010009766), new Point2D.Double(32.566654205322266, 30.758346557617188), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9659259915351868f, -0.25881901383399963f, 0.25881901383399963f, 0.9659259915351868f, -4.116819858551025f, 6.729656219482422f));
stroke = new BasicStroke(1.1333332f,2,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(32.0f, 19.0f);
generalPath.curveTo(32.013622f, 22.045813f, 30.396517f, 24.866106f, 27.761011f, 26.39296f);
generalPath.curveTo(25.125507f, 27.919811f, 21.874493f, 27.919811f, 19.238989f, 26.39296f);
generalPath.curveTo(16.603483f, 24.866106f, 14.986379f, 22.045813f, 15.0f, 19.0f);
generalPath.curveTo(14.986379f, 15.954186f, 16.603483f, 13.133893f, 19.238989f, 11.607041f);
generalPath.curveTo(21.874493f, 10.080189f, 25.125507f, 10.080189f, 27.761011f, 11.607041f);
generalPath.curveTo(30.396517f, 13.133893f, 32.013622f, 15.954186f, 32.0f, 19.0f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.4117650091648102f, -4.790002776644542E-7f, 4.790002776644542E-7f, 0.4117650091648102f, 21.323530197143555f, 4.176469802856445f));
// _0_0_3_5
paint = new LinearGradientPaint(new Point2D.Double(28.357093811035156, 22.794660568237305), new Point2D.Double(17.73212432861328, 5.187518119812012), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9659259915351868f, -0.25881901383399963f, 0.25881901383399963f, 0.9659259915351868f, -4.116824150085449f, 6.729647159576416f));
stroke = new BasicStroke(2.4285712f,2,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(32.0f, 19.0f);
generalPath.curveTo(32.013622f, 22.045813f, 30.396517f, 24.866106f, 27.761011f, 26.39296f);
generalPath.curveTo(25.125507f, 27.919811f, 21.874493f, 27.919811f, 19.238989f, 26.39296f);
generalPath.curveTo(16.603483f, 24.866106f, 14.986379f, 22.045813f, 15.0f, 19.0f);
generalPath.curveTo(14.986379f, 15.954186f, 16.603483f, 13.133893f, 19.238989f, 11.607041f);
generalPath.curveTo(21.874493f, 10.080189f, 25.125507f, 10.080189f, 27.761011f, 11.607041f);
generalPath.curveTo(30.396517f, 13.133893f, 32.013622f, 15.954186f, 32.0f, 19.0f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(16.15625f, 26.5f);
generalPath.curveTo(15.667854f, 26.518776f, 15.184245f, 26.593794f, 14.71875f, 26.6875f);
generalPath.lineTo(14.6875f, 26.6875f);
generalPath.curveTo(14.33804f, 26.75907f, 13.989707f, 26.857916f, 13.65625f, 26.96875f);
generalPath.curveTo(13.173912f, 27.12907f, 12.723532f, 27.3266f, 12.28125f, 27.5625f);
generalPath.lineTo(12.9375f, 30.6875f);
generalPath.curveTo(12.461256f, 31.040215f, 12.013429f, 31.452682f, 11.65625f, 31.9375f);
generalPath.lineTo(8.5625f, 31.3125f);
generalPath.curveTo(8.306103f, 31.796885f, 8.071723f, 32.280857f, 7.90625f, 32.8125f);
generalPath.curveTo(7.676383f, 33.551033f, 7.530997f, 34.34993f, 7.5f, 35.15625f);
generalPath.lineTo(10.5625f, 36.1875f);
generalPath.curveTo(10.632137f, 36.77997f, 10.764473f, 37.36819f, 11.0f, 37.90625f);
generalPath.lineTo(8.875f, 40.28125f);
generalPath.curveTo(9.152689f, 40.72257f, 9.464725f, 41.145897f, 9.8125f, 41.53125f);
generalPath.lineTo(10.4375f, 42.125f);
generalPath.curveTo(10.825721f, 42.4804f, 11.241422f, 42.810104f, 11.6875f, 43.09375f);
generalPath.lineTo(14.0625f, 40.96875f);
generalPath.curveTo(14.347986f, 41.096024f, 14.626055f, 41.1978f, 14.9375f, 41.28125f);
generalPath.curveTo(15.232216f, 41.360218f, 15.549433f, 41.43545f, 15.84375f, 41.46875f);
generalPath.lineTo(16.84375f, 44.5f);
generalPath.curveTo(17.332146f, 44.481224f, 17.815756f, 44.406208f, 18.28125f, 44.3125f);
generalPath.lineTo(18.3125f, 44.3125f);
generalPath.curveTo(18.66196f, 44.24093f, 19.010292f, 44.142086f, 19.34375f, 44.03125f);
generalPath.curveTo(19.826088f, 43.87093f, 20.276468f, 43.6734f, 20.71875f, 43.4375f);
generalPath.lineTo(20.0625f, 40.3125f);
generalPath.curveTo(20.538744f, 39.959785f, 20.98657f, 39.547318f, 21.34375f, 39.0625f);
generalPath.lineTo(24.4375f, 39.6875f);
generalPath.curveTo(24.693897f, 39.203114f, 24.928276f, 38.719143f, 25.09375f, 38.1875f);
generalPath.curveTo(25.323618f, 37.448967f, 25.469004f, 36.65007f, 25.5f, 35.84375f);
generalPath.lineTo(22.4375f, 34.8125f);
generalPath.curveTo(22.367863f, 34.22003f, 22.235527f, 33.63181f, 22.0f, 33.09375f);
generalPath.lineTo(24.125f, 30.71875f);
generalPath.curveTo(23.847311f, 30.277433f, 23.535275f, 29.854103f, 23.1875f, 29.46875f);
generalPath.lineTo(22.5625f, 28.875f);
generalPath.curveTo(22.174278f, 28.5196f, 21.758577f, 28.189896f, 21.3125f, 27.90625f);
generalPath.lineTo(18.9375f, 30.03125f);
generalPath.curveTo(18.652014f, 29.903976f, 18.373945f, 29.8022f, 18.0625f, 29.71875f);
generalPath.curveTo(17.767784f, 29.639782f, 17.450567f, 29.564548f, 17.15625f, 29.53125f);
generalPath.lineTo(16.15625f, 26.5f);
generalPath.closePath();
generalPath.moveTo(16.28125f, 33.5f);
generalPath.curveTo(16.394758f, 33.487328f, 16.508957f, 33.493053f, 16.625f, 33.5f);
generalPath.curveTo(16.75762f, 33.50794f, 16.897951f, 33.526783f, 17.03125f, 33.5625f);
generalPath.curveTo(18.097631f, 33.848232f, 18.723236f, 34.964867f, 18.4375f, 36.03125f);
generalPath.curveTo(18.151764f, 37.097637f, 17.035131f, 37.723236f, 15.96875f, 37.4375f);
generalPath.curveTo(14.902369f, 37.151768f, 14.276764f, 36.035133f, 14.5625f, 34.96875f);
generalPath.curveTo(14.781268f, 34.1523f, 15.486686f, 33.588696f, 16.28125f, 33.5f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(14.495688438415527, 29.880390167236328), new Point2D.Double(26.737476348876953, 42.564117431640625), new float[] {0.0f,1.0f}, new Color[] {new Color(211, 215, 207, 255),new Color(136, 138, 133, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -3.0f, 1.0f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(46, 52, 54, 255);
stroke = new BasicStroke(1.0000001f,1,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(16.15625f, 26.5f);
generalPath.curveTo(15.667854f, 26.518776f, 15.184245f, 26.593794f, 14.71875f, 26.6875f);
generalPath.lineTo(14.6875f, 26.6875f);
generalPath.curveTo(14.33804f, 26.75907f, 13.989707f, 26.857916f, 13.65625f, 26.96875f);
generalPath.curveTo(13.173912f, 27.12907f, 12.723532f, 27.3266f, 12.28125f, 27.5625f);
generalPath.lineTo(12.9375f, 30.6875f);
generalPath.curveTo(12.461256f, 31.040215f, 12.013429f, 31.452682f, 11.65625f, 31.9375f);
generalPath.lineTo(8.5625f, 31.3125f);
generalPath.curveTo(8.306103f, 31.796885f, 8.071723f, 32.280857f, 7.90625f, 32.8125f);
generalPath.curveTo(7.676383f, 33.551033f, 7.530997f, 34.34993f, 7.5f, 35.15625f);
generalPath.lineTo(10.5625f, 36.1875f);
generalPath.curveTo(10.632137f, 36.77997f, 10.764473f, 37.36819f, 11.0f, 37.90625f);
generalPath.lineTo(8.875f, 40.28125f);
generalPath.curveTo(9.152689f, 40.72257f, 9.464725f, 41.145897f, 9.8125f, 41.53125f);
generalPath.lineTo(10.4375f, 42.125f);
generalPath.curveTo(10.825721f, 42.4804f, 11.241422f, 42.810104f, 11.6875f, 43.09375f);
generalPath.lineTo(14.0625f, 40.96875f);
generalPath.curveTo(14.347986f, 41.096024f, 14.626055f, 41.1978f, 14.9375f, 41.28125f);
generalPath.curveTo(15.232216f, 41.360218f, 15.549433f, 41.43545f, 15.84375f, 41.46875f);
generalPath.lineTo(16.84375f, 44.5f);
generalPath.curveTo(17.332146f, 44.481224f, 17.815756f, 44.406208f, 18.28125f, 44.3125f);
generalPath.lineTo(18.3125f, 44.3125f);
generalPath.curveTo(18.66196f, 44.24093f, 19.010292f, 44.142086f, 19.34375f, 44.03125f);
generalPath.curveTo(19.826088f, 43.87093f, 20.276468f, 43.6734f, 20.71875f, 43.4375f);
generalPath.lineTo(20.0625f, 40.3125f);
generalPath.curveTo(20.538744f, 39.959785f, 20.98657f, 39.547318f, 21.34375f, 39.0625f);
generalPath.lineTo(24.4375f, 39.6875f);
generalPath.curveTo(24.693897f, 39.203114f, 24.928276f, 38.719143f, 25.09375f, 38.1875f);
generalPath.curveTo(25.323618f, 37.448967f, 25.469004f, 36.65007f, 25.5f, 35.84375f);
generalPath.lineTo(22.4375f, 34.8125f);
generalPath.curveTo(22.367863f, 34.22003f, 22.235527f, 33.63181f, 22.0f, 33.09375f);
generalPath.lineTo(24.125f, 30.71875f);
generalPath.curveTo(23.847311f, 30.277433f, 23.535275f, 29.854103f, 23.1875f, 29.46875f);
generalPath.lineTo(22.5625f, 28.875f);
generalPath.curveTo(22.174278f, 28.5196f, 21.758577f, 28.189896f, 21.3125f, 27.90625f);
generalPath.lineTo(18.9375f, 30.03125f);
generalPath.curveTo(18.652014f, 29.903976f, 18.373945f, 29.8022f, 18.0625f, 29.71875f);
generalPath.curveTo(17.767784f, 29.639782f, 17.450567f, 29.564548f, 17.15625f, 29.53125f);
generalPath.lineTo(16.15625f, 26.5f);
generalPath.closePath();
generalPath.moveTo(16.28125f, 33.5f);
generalPath.curveTo(16.394758f, 33.487328f, 16.508957f, 33.493053f, 16.625f, 33.5f);
generalPath.curveTo(16.75762f, 33.50794f, 16.897951f, 33.526783f, 17.03125f, 33.5625f);
generalPath.curveTo(18.097631f, 33.848232f, 18.723236f, 34.964867f, 18.4375f, 36.03125f);
generalPath.curveTo(18.151764f, 37.097637f, 17.035131f, 37.723236f, 15.96875f, 37.4375f);
generalPath.curveTo(14.902369f, 37.151768f, 14.276764f, 36.035133f, 14.5625f, 34.96875f);
generalPath.curveTo(14.781268f, 34.1523f, 15.486686f, 33.588696f, 16.28125f, 33.5f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -3.0f, 1.0f));
// _0_0_5
paint = new LinearGradientPaint(new Point2D.Double(14.375, 31.0625), new Point2D.Double(30.4375, 44.0625), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(1.0000001f,1,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(18.46875f, 26.46875f);
generalPath.lineTo(16.375f, 27.0625f);
generalPath.lineTo(17.21875f, 31.09375f);
generalPath.curveTo(17.274872f, 31.40599f, 17.174576f, 31.725925f, 16.95025f, 31.95025f);
generalPath.curveTo(16.725925f, 32.174576f, 16.40599f, 32.27487f, 16.09375f, 32.21875f);
generalPath.lineTo(12.03125f, 31.375f);
generalPath.lineTo(11.4375f, 33.46875f);
generalPath.lineTo(15.40625f, 34.78125f);
generalPath.curveTo(15.71319f, 34.88695f, 15.946796f, 35.139347f, 16.028484f, 35.453533f);
generalPath.curveTo(16.110172f, 35.767715f, 16.029085f, 36.101933f, 15.8125f, 36.34375f);
generalPath.lineTo(13.09375f, 39.40625f);
generalPath.lineTo(14.5625f, 40.90625f);
generalPath.lineTo(17.65625f, 38.15625f);
generalPath.curveTo(17.898067f, 37.939667f, 18.232285f, 37.858578f, 18.546469f, 37.940266f);
generalPath.curveTo(18.860653f, 38.021954f, 19.113049f, 38.25556f, 19.21875f, 38.5625f);
generalPath.lineTo(20.53125f, 42.53125f);
generalPath.lineTo(22.625f, 41.9375f);
generalPath.lineTo(21.78125f, 37.90625f);
generalPath.curveTo(21.725128f, 37.59401f, 21.825424f, 37.274075f, 22.04975f, 37.049747f);
generalPath.curveTo(22.274075f, 36.825424f, 22.59401f, 36.72513f, 22.90625f, 36.78125f);
generalPath.lineTo(26.96875f, 37.625f);
generalPath.lineTo(27.5625f, 35.53125f);
generalPath.lineTo(23.59375f, 34.21875f);
generalPath.curveTo(23.28681f, 34.11305f, 23.053204f, 33.860653f, 22.971516f, 33.546467f);
generalPath.curveTo(22.889828f, 33.232285f, 22.970915f, 32.898067f, 23.1875f, 32.65625f);
generalPath.lineTo(25.90625f, 29.59375f);
generalPath.lineTo(24.4375f, 28.09375f);
generalPath.lineTo(21.34375f, 30.84375f);
generalPath.curveTo(21.101933f, 31.060335f, 20.767715f, 31.141422f, 20.453531f, 31.059734f);
generalPath.curveTo(20.139347f, 30.978046f, 19.886951f, 30.74444f, 19.78125f, 30.4375f);
generalPath.lineTo(18.46875f, 26.46875f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.9372549f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(15.78125f, 26.84375f);
generalPath.lineTo(12.78125f, 27.71875f);
generalPath.lineTo(13.71875f, 32.1875f);
generalPath.curveTo(13.746003f, 32.339127f, 13.702685f, 32.484814f, 13.59375f, 32.59375f);
generalPath.curveTo(13.484816f, 32.702686f, 13.339128f, 32.746002f, 13.1875f, 32.71875f);
generalPath.lineTo(8.6875f, 31.78125f);
generalPath.lineTo(7.8125f, 34.78125f);
generalPath.lineTo(12.25f, 36.25f);
generalPath.curveTo(12.3991f, 36.301346f, 12.491569f, 36.44113f, 12.53125f, 36.59375f);
generalPath.curveTo(12.57093f, 36.74637f, 12.542708f, 36.882534f, 12.4375f, 37.0f);
generalPath.lineTo(9.40625f, 40.4375f);
generalPath.lineTo(11.53125f, 42.59375f);
generalPath.lineTo(15.0f, 39.53125f);
generalPath.curveTo(15.117466f, 39.42604f, 15.253631f, 39.39782f, 15.40625f, 39.4375f);
generalPath.curveTo(15.558869f, 39.47718f, 15.698654f, 39.56965f, 15.75f, 39.71875f);
generalPath.lineTo(17.21875f, 44.15625f);
generalPath.lineTo(20.21875f, 43.28125f);
generalPath.lineTo(19.28125f, 38.8125f);
generalPath.curveTo(19.253998f, 38.660873f, 19.297316f, 38.515186f, 19.40625f, 38.40625f);
generalPath.curveTo(19.515184f, 38.297314f, 19.660873f, 38.253998f, 19.8125f, 38.28125f);
generalPath.lineTo(24.3125f, 39.21875f);
generalPath.lineTo(25.1875f, 36.21875f);
generalPath.lineTo(20.75f, 34.75f);
generalPath.curveTo(20.6009f, 34.698654f, 20.50843f, 34.55887f, 20.46875f, 34.40625f);
generalPath.curveTo(20.42907f, 34.25363f, 20.457293f, 34.117466f, 20.5625f, 34.0f);
generalPath.lineTo(23.59375f, 30.5625f);
generalPath.lineTo(21.46875f, 28.40625f);
generalPath.lineTo(18.0f, 31.46875f);
generalPath.curveTo(17.882534f, 31.57396f, 17.746368f, 31.60218f, 17.59375f, 31.5625f);
generalPath.curveTo(17.441132f, 31.52282f, 17.301346f, 31.43035f, 17.25f, 31.28125f);
generalPath.lineTo(15.78125f, 26.84375f);
generalPath.closePath();
generalPath.moveTo(16.5f, 32.5f);
generalPath.curveTo(18.155998f, 32.5f, 19.5f, 33.844f, 19.5f, 35.5f);
generalPath.curveTo(19.500002f, 37.156002f, 18.155998f, 38.5f, 16.5f, 38.5f);
generalPath.curveTo(14.844002f, 38.5f, 13.5f, 37.156f, 13.5f, 35.5f);
generalPath.curveTo(13.5f, 33.844f, 14.844002f, 32.5f, 16.5f, 32.5f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(42.5, 34.5), 8.6875f, new Point2D.Double(42.5, 34.5), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.9964029788970947f, -26.0f, 1.1240999698638916f));
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
generalPath.moveTo(16.5f, 30.0f);
generalPath.curveTo(13.464f, 30.0f, 11.0f, 32.464f, 11.0f, 35.5f);
generalPath.curveTo(11.0f, 38.536f, 13.464f, 40.999996f, 16.5f, 41.0f);
generalPath.curveTo(19.536f, 41.0f, 22.0f, 38.536003f, 22.0f, 35.5f);
generalPath.curveTo(22.0f, 32.464f, 19.536f, 30.0f, 16.5f, 30.0f);
generalPath.closePath();
generalPath.moveTo(16.5f, 33.0f);
generalPath.curveTo(17.879997f, 33.0f, 18.999998f, 34.120003f, 19.0f, 35.5f);
generalPath.curveTo(19.0f, 36.879997f, 17.879997f, 38.0f, 16.5f, 38.0f);
generalPath.curveTo(15.120003f, 38.0f, 14.000001f, 36.879997f, 14.0f, 35.5f);
generalPath.curveTo(14.0f, 34.120003f, 15.120003f, 33.0f, 16.5f, 33.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(16.793787002563477, 30.675884246826172), new Point2D.Double(22.052892684936523, 37.12823486328125), new float[] {0.0f,1.0f}, new Color[] {new Color(136, 138, 133, 255),new Color(211, 215, 207, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -3.0f, 1.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9494010210037231f, 0.0f, 0.0f, 0.9494019746780396f, -2.0664169788360596f, 2.6629860401153564f));
// _0_0_8
paint = new LinearGradientPaint(new Point2D.Double(20.806716918945312, 36.82530212402344), new Point2D.Double(17.4493350982666, 30.900535583496094), new float[] {0.0f,1.0f}, new Color[] {new Color(238, 238, 236, 255),new Color(238, 238, 236, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(1.0532955f,1,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(22.715805f, 34.587067f);
generalPath.curveTo(22.72087f, 35.71935f, 22.119709f, 36.7678f, 21.139957f, 37.335407f);
generalPath.curveTo(20.160206f, 37.903015f, 18.951637f, 37.903015f, 17.971886f, 37.335407f);
generalPath.curveTo(16.992134f, 36.7678f, 16.390974f, 35.71935f, 16.396038f, 34.587067f);
generalPath.curveTo(16.390974f, 33.454784f, 16.992134f, 32.406334f, 17.971886f, 31.838726f);
generalPath.curveTo(18.951637f, 31.271118f, 20.160206f, 31.271118f, 21.139957f, 31.838726f);
generalPath.curveTo(22.119709f, 32.406334f, 22.72087f, 33.454784f, 22.715805f, 34.587067f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.582334041595459f, 0.0f, 0.0f, -1.5823390483856201f, -14.444009780883789f, 90.22846984863281f));
// _0_0_9
paint = new LinearGradientPaint(new Point2D.Double(17.65999412536621, 36.68048858642578), new Point2D.Double(23.03179359436035, 31.111194610595703), new float[] {0.0f,1.0f}, new Color[] {new Color(238, 238, 236, 255),new Color(238, 238, 236, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(0.631977f,1,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}

}

private void _paint1(Graphics2D g,float origAlpha) {
generalPath.moveTo(22.715805f, 34.587067f);
generalPath.curveTo(22.72087f, 35.71935f, 22.119709f, 36.7678f, 21.139957f, 37.335407f);
generalPath.curveTo(20.160206f, 37.903015f, 18.951637f, 37.903015f, 17.971886f, 37.335407f);
generalPath.curveTo(16.992134f, 36.7678f, 16.390974f, 35.71935f, 16.396038f, 34.587067f);
generalPath.curveTo(16.390974f, 33.454784f, 16.992134f, 32.406334f, 17.971886f, 31.838726f);
generalPath.curveTo(18.951637f, 31.271118f, 20.160206f, 31.271118f, 21.139957f, 31.838726f);
generalPath.curveTo(22.119709f, 32.406334f, 22.72087f, 33.454784f, 22.715805f, 34.587067f);
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
_paint1(g, origAlpha);


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
        return 3.291367292404175;
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
		return 44.40890884399414;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 47.7346076965332;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private system_run_3() {
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
       system_run_3 base = new system_run_3();
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
       system_run_3 base = new system_run_3();
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
        return system_run_3::new;
    }
}

