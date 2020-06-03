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
public class system_run_5 implements ResizableIcon {
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
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(64.0f, 4.0f);
generalPath.curveTo(60.726154f, 4.01728f, 58.624233f, 4.17392f, 55.375004f, 4.625f);
generalPath.curveTo(54.41305f, 4.77818f, 53.625004f, 5.40555f, 53.625004f, 6.375f);
generalPath.lineTo(53.031254f, 15.8125f);
generalPath.curveTo(52.94274f, 16.76769f, 52.274612f, 17.39683f, 51.562504f, 17.625f);
generalPath.curveTo(51.540672f, 17.632f, 51.521904f, 17.65003f, 51.500004f, 17.65625f);
generalPath.curveTo(47.383163f, 18.76142f, 43.477074f, 20.37835f, 39.875004f, 22.46875f);
generalPath.curveTo(39.223454f, 22.75068f, 38.382874f, 22.73369f, 37.687504f, 22.15625f);
generalPath.lineTo(30.593754f, 15.90625f);
generalPath.curveTo(29.908253f, 15.22075f, 28.913523f, 15.33437f, 28.125004f, 15.90625f);
generalPath.curveTo(25.508493f, 17.88484f, 23.889683f, 19.25975f, 21.562504f, 21.5625f);
generalPath.curveTo(19.259764f, 23.88968f, 17.884844f, 25.50848f, 15.906253f, 28.125f);
generalPath.curveTo(15.334373f, 28.91352f, 15.220753f, 29.90825f, 15.906253f, 30.59375f);
generalPath.lineTo(22.156254f, 37.6875f);
generalPath.curveTo(22.629972f, 38.25798f, 22.892452f, 38.99635f, 22.625004f, 39.53125f);
generalPath.lineTo(22.562504f, 39.65625f);
generalPath.curveTo(20.316982f, 43.45585f, 18.567642f, 47.59256f, 17.437504f, 51.96875f);
generalPath.curveTo(17.425663f, 51.98939f, 17.418833f, 52.01091f, 17.406254f, 52.03125f);
generalPath.curveTo(17.089043f, 52.54409f, 16.550863f, 52.96283f, 15.812503f, 53.03125f);
generalPath.lineTo(6.375003f, 53.625f);
generalPath.curveTo(5.4055624f, 53.625f, 4.7781925f, 54.41305f, 4.6250024f, 55.375f);
generalPath.curveTo(4.173922f, 58.62423f, 4.0172825f, 60.72615f, 4.0000024f, 64.0f);
generalPath.curveTo(4.0172825f, 67.27385f, 4.173922f, 69.37577f, 4.6250024f, 72.625f);
generalPath.curveTo(4.7781925f, 73.58695f, 5.4055624f, 74.375f, 6.375003f, 74.375f);
generalPath.lineTo(15.812503f, 74.96875f);
generalPath.curveTo(16.679853f, 75.04912f, 17.255943f, 75.61532f, 17.531254f, 76.25f);
generalPath.curveTo(18.634483f, 80.39335f, 20.297503f, 84.31421f, 22.406254f, 87.9375f);
generalPath.curveTo(22.779173f, 88.60601f, 22.787884f, 89.55186f, 22.156254f, 90.3125f);
generalPath.lineTo(15.906253f, 97.40625f);
generalPath.curveTo(15.220753f, 98.09175f, 15.334373f, 99.08648f, 15.906253f, 99.875f);
generalPath.curveTo(17.884844f, 102.49151f, 19.259764f, 104.11031f, 21.562504f, 106.4375f);
generalPath.curveTo(23.889683f, 108.74024f, 25.508484f, 110.11516f, 28.125004f, 112.09375f);
generalPath.curveTo(28.913523f, 112.66563f, 29.908253f, 112.77925f, 30.593754f, 112.09375f);
generalPath.lineTo(37.687504f, 105.84375f);
generalPath.curveTo(38.448143f, 105.21212f, 39.393993f, 105.22083f, 40.062504f, 105.59375f);
generalPath.lineTo(40.156254f, 105.5f);
generalPath.curveTo(43.683914f, 107.51717f, 47.484444f, 109.10952f, 51.500004f, 110.1875f);
generalPath.lineTo(51.500004f, 110.34375f);
generalPath.curveTo(52.236404f, 110.55276f, 52.940033f, 111.20302f, 53.031254f, 112.1875f);
generalPath.lineTo(53.625004f, 121.625f);
generalPath.curveTo(53.625004f, 122.59444f, 54.41305f, 123.22181f, 55.375004f, 123.375f);
generalPath.curveTo(58.624233f, 123.82608f, 60.726154f, 123.98272f, 64.0f, 124.0f);
generalPath.curveTo(67.27386f, 123.98272f, 69.37577f, 123.82608f, 72.62501f, 123.375f);
generalPath.curveTo(73.58695f, 123.22181f, 74.37501f, 122.59444f, 74.37501f, 121.625f);
generalPath.lineTo(74.96876f, 112.1875f);
generalPath.curveTo(75.059975f, 111.20302f, 75.7636f, 110.55276f, 76.50001f, 110.34375f);
generalPath.lineTo(76.50001f, 110.1875f);
generalPath.curveTo(80.515564f, 109.10952f, 84.3161f, 107.51717f, 87.84376f, 105.5f);
generalPath.lineTo(87.93751f, 105.59375f);
generalPath.curveTo(88.60601f, 105.22083f, 89.551865f, 105.21212f, 90.31251f, 105.84375f);
generalPath.lineTo(97.40625f, 112.09375f);
generalPath.curveTo(98.09175f, 112.77926f, 99.08649f, 112.66564f, 99.875f, 112.09375f);
generalPath.curveTo(102.49151f, 110.11516f, 104.11031f, 108.74024f, 106.4375f, 106.4375f);
generalPath.curveTo(108.74024f, 104.11031f, 110.11516f, 102.49151f, 112.09375f, 99.875f);
generalPath.curveTo(112.66564f, 99.08649f, 112.77926f, 98.09176f, 112.09375f, 97.40625f);
generalPath.lineTo(105.84375f, 90.3125f);
generalPath.curveTo(105.21212f, 89.55186f, 105.22083f, 88.60601f, 105.59375f, 87.9375f);
generalPath.curveTo(107.7025f, 84.31421f, 109.36552f, 80.39335f, 110.46875f, 76.25f);
generalPath.curveTo(110.74406f, 75.61532f, 111.32015f, 75.04912f, 112.1875f, 74.96875f);
generalPath.lineTo(121.625f, 74.375f);
generalPath.curveTo(122.59445f, 74.375f, 123.22182f, 73.58695f, 123.375f, 72.625f);
generalPath.curveTo(123.82608f, 69.37577f, 123.98272f, 67.27385f, 124.0f, 64.0f);
generalPath.curveTo(123.98272f, 60.72615f, 123.82608f, 58.62423f, 123.375f, 55.375f);
generalPath.curveTo(123.22182f, 54.41305f, 122.59445f, 53.625f, 121.625f, 53.625f);
generalPath.lineTo(112.1875f, 53.03125f);
generalPath.curveTo(111.44914f, 52.96283f, 110.91096f, 52.54409f, 110.59375f, 52.03125f);
generalPath.curveTo(110.58812f, 52.00933f, 110.56816f, 51.99066f, 110.5625f, 51.96875f);
generalPath.curveTo(109.43236f, 47.59256f, 107.41129f, 43.60384f, 105.4375f, 39.65625f);
generalPath.lineTo(105.375f, 39.53125f);
generalPath.curveTo(105.10755f, 38.99635f, 105.37003f, 38.25798f, 105.84375f, 37.6875f);
generalPath.lineTo(112.09375f, 30.59375f);
generalPath.curveTo(112.77926f, 29.90824f, 112.66563f, 28.91352f, 112.09375f, 28.125f);
generalPath.curveTo(110.11516f, 25.50848f, 108.74024f, 23.88968f, 106.4375f, 21.5625f);
generalPath.curveTo(104.11032f, 19.25975f, 102.49152f, 17.88484f, 99.875f, 15.90625f);
generalPath.curveTo(99.08648f, 15.33437f, 98.09176f, 15.22074f, 97.40625f, 15.90625f);
generalPath.lineTo(90.31251f, 22.15625f);
generalPath.curveTo(89.61713f, 22.73369f, 88.77655f, 22.75068f, 88.12501f, 22.46875f);
generalPath.curveTo(84.522934f, 20.37835f, 80.616844f, 18.76142f, 76.50001f, 17.65625f);
generalPath.curveTo(76.4781f, 17.65003f, 76.459335f, 17.632f, 76.43751f, 17.625f);
generalPath.curveTo(75.725395f, 17.39683f, 75.05727f, 16.76769f, 74.96876f, 15.8125f);
generalPath.lineTo(74.37501f, 6.375f);
generalPath.curveTo(74.37501f, 5.40555f, 73.58695f, 4.77818f, 72.62501f, 4.625f);
generalPath.curveTo(69.37577f, 4.17392f, 67.27386f, 4.01728f, 64.0f, 4.0f);
generalPath.closePath();
generalPath.moveTo(64.0f, 48.0f);
generalPath.curveTo(72.832f, 48.0f, 80.00001f, 55.168f, 80.00001f, 64.0f);
generalPath.curveTo(80.00001f, 72.832f, 72.832f, 80.0f, 64.0f, 80.0f);
generalPath.curveTo(55.168003f, 80.0f, 48.000004f, 72.832f, 48.000004f, 64.0f);
generalPath.curveTo(48.000004f, 55.168f, 55.168003f, 48.0f, 64.0f, 48.0f);
generalPath.closePath();
shape = generalPath;
paint = new Color(54, 54, 54, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(118, 118, 118, 255);
stroke = new BasicStroke(2.0f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(64.0f, 4.0f);
generalPath.curveTo(60.726154f, 4.01728f, 58.624233f, 4.17392f, 55.375004f, 4.625f);
generalPath.curveTo(54.41305f, 4.77818f, 53.625004f, 5.40555f, 53.625004f, 6.375f);
generalPath.lineTo(53.031254f, 15.8125f);
generalPath.curveTo(52.94274f, 16.76769f, 52.274612f, 17.39683f, 51.562504f, 17.625f);
generalPath.curveTo(51.540672f, 17.632f, 51.521904f, 17.65003f, 51.500004f, 17.65625f);
generalPath.curveTo(47.383163f, 18.76142f, 43.477074f, 20.37835f, 39.875004f, 22.46875f);
generalPath.curveTo(39.223454f, 22.75068f, 38.382874f, 22.73369f, 37.687504f, 22.15625f);
generalPath.lineTo(30.593754f, 15.90625f);
generalPath.curveTo(29.908253f, 15.22075f, 28.913523f, 15.33437f, 28.125004f, 15.90625f);
generalPath.curveTo(25.508493f, 17.88484f, 23.889683f, 19.25975f, 21.562504f, 21.5625f);
generalPath.curveTo(19.259764f, 23.88968f, 17.884844f, 25.50848f, 15.906253f, 28.125f);
generalPath.curveTo(15.334373f, 28.91352f, 15.220753f, 29.90825f, 15.906253f, 30.59375f);
generalPath.lineTo(22.156254f, 37.6875f);
generalPath.curveTo(22.629972f, 38.25798f, 22.892452f, 38.99635f, 22.625004f, 39.53125f);
generalPath.lineTo(22.562504f, 39.65625f);
generalPath.curveTo(20.316982f, 43.45585f, 18.567642f, 47.59256f, 17.437504f, 51.96875f);
generalPath.curveTo(17.425663f, 51.98939f, 17.418833f, 52.01091f, 17.406254f, 52.03125f);
generalPath.curveTo(17.089043f, 52.54409f, 16.550863f, 52.96283f, 15.812503f, 53.03125f);
generalPath.lineTo(6.375003f, 53.625f);
generalPath.curveTo(5.4055624f, 53.625f, 4.7781925f, 54.41305f, 4.6250024f, 55.375f);
generalPath.curveTo(4.173922f, 58.62423f, 4.0172825f, 60.72615f, 4.0000024f, 64.0f);
generalPath.curveTo(4.0172825f, 67.27385f, 4.173922f, 69.37577f, 4.6250024f, 72.625f);
generalPath.curveTo(4.7781925f, 73.58695f, 5.4055624f, 74.375f, 6.375003f, 74.375f);
generalPath.lineTo(15.812503f, 74.96875f);
generalPath.curveTo(16.679853f, 75.04912f, 17.255943f, 75.61532f, 17.531254f, 76.25f);
generalPath.curveTo(18.634483f, 80.39335f, 20.297503f, 84.31421f, 22.406254f, 87.9375f);
generalPath.curveTo(22.779173f, 88.60601f, 22.787884f, 89.55186f, 22.156254f, 90.3125f);
generalPath.lineTo(15.906253f, 97.40625f);
generalPath.curveTo(15.220753f, 98.09175f, 15.334373f, 99.08648f, 15.906253f, 99.875f);
generalPath.curveTo(17.884844f, 102.49151f, 19.259764f, 104.11031f, 21.562504f, 106.4375f);
generalPath.curveTo(23.889683f, 108.74024f, 25.508484f, 110.11516f, 28.125004f, 112.09375f);
generalPath.curveTo(28.913523f, 112.66563f, 29.908253f, 112.77925f, 30.593754f, 112.09375f);
generalPath.lineTo(37.687504f, 105.84375f);
generalPath.curveTo(38.448143f, 105.21212f, 39.393993f, 105.22083f, 40.062504f, 105.59375f);
generalPath.lineTo(40.156254f, 105.5f);
generalPath.curveTo(43.683914f, 107.51717f, 47.484444f, 109.10952f, 51.500004f, 110.1875f);
generalPath.lineTo(51.500004f, 110.34375f);
generalPath.curveTo(52.236404f, 110.55276f, 52.940033f, 111.20302f, 53.031254f, 112.1875f);
generalPath.lineTo(53.625004f, 121.625f);
generalPath.curveTo(53.625004f, 122.59444f, 54.41305f, 123.22181f, 55.375004f, 123.375f);
generalPath.curveTo(58.624233f, 123.82608f, 60.726154f, 123.98272f, 64.0f, 124.0f);
generalPath.curveTo(67.27386f, 123.98272f, 69.37577f, 123.82608f, 72.62501f, 123.375f);
generalPath.curveTo(73.58695f, 123.22181f, 74.37501f, 122.59444f, 74.37501f, 121.625f);
generalPath.lineTo(74.96876f, 112.1875f);
generalPath.curveTo(75.059975f, 111.20302f, 75.7636f, 110.55276f, 76.50001f, 110.34375f);
generalPath.lineTo(76.50001f, 110.1875f);
generalPath.curveTo(80.515564f, 109.10952f, 84.3161f, 107.51717f, 87.84376f, 105.5f);
generalPath.lineTo(87.93751f, 105.59375f);
generalPath.curveTo(88.60601f, 105.22083f, 89.551865f, 105.21212f, 90.31251f, 105.84375f);
generalPath.lineTo(97.40625f, 112.09375f);
generalPath.curveTo(98.09175f, 112.77926f, 99.08649f, 112.66564f, 99.875f, 112.09375f);
generalPath.curveTo(102.49151f, 110.11516f, 104.11031f, 108.74024f, 106.4375f, 106.4375f);
generalPath.curveTo(108.74024f, 104.11031f, 110.11516f, 102.49151f, 112.09375f, 99.875f);
generalPath.curveTo(112.66564f, 99.08649f, 112.77926f, 98.09176f, 112.09375f, 97.40625f);
generalPath.lineTo(105.84375f, 90.3125f);
generalPath.curveTo(105.21212f, 89.55186f, 105.22083f, 88.60601f, 105.59375f, 87.9375f);
generalPath.curveTo(107.7025f, 84.31421f, 109.36552f, 80.39335f, 110.46875f, 76.25f);
generalPath.curveTo(110.74406f, 75.61532f, 111.32015f, 75.04912f, 112.1875f, 74.96875f);
generalPath.lineTo(121.625f, 74.375f);
generalPath.curveTo(122.59445f, 74.375f, 123.22182f, 73.58695f, 123.375f, 72.625f);
generalPath.curveTo(123.82608f, 69.37577f, 123.98272f, 67.27385f, 124.0f, 64.0f);
generalPath.curveTo(123.98272f, 60.72615f, 123.82608f, 58.62423f, 123.375f, 55.375f);
generalPath.curveTo(123.22182f, 54.41305f, 122.59445f, 53.625f, 121.625f, 53.625f);
generalPath.lineTo(112.1875f, 53.03125f);
generalPath.curveTo(111.44914f, 52.96283f, 110.91096f, 52.54409f, 110.59375f, 52.03125f);
generalPath.curveTo(110.58812f, 52.00933f, 110.56816f, 51.99066f, 110.5625f, 51.96875f);
generalPath.curveTo(109.43236f, 47.59256f, 107.41129f, 43.60384f, 105.4375f, 39.65625f);
generalPath.lineTo(105.375f, 39.53125f);
generalPath.curveTo(105.10755f, 38.99635f, 105.37003f, 38.25798f, 105.84375f, 37.6875f);
generalPath.lineTo(112.09375f, 30.59375f);
generalPath.curveTo(112.77926f, 29.90824f, 112.66563f, 28.91352f, 112.09375f, 28.125f);
generalPath.curveTo(110.11516f, 25.50848f, 108.74024f, 23.88968f, 106.4375f, 21.5625f);
generalPath.curveTo(104.11032f, 19.25975f, 102.49152f, 17.88484f, 99.875f, 15.90625f);
generalPath.curveTo(99.08648f, 15.33437f, 98.09176f, 15.22074f, 97.40625f, 15.90625f);
generalPath.lineTo(90.31251f, 22.15625f);
generalPath.curveTo(89.61713f, 22.73369f, 88.77655f, 22.75068f, 88.12501f, 22.46875f);
generalPath.curveTo(84.522934f, 20.37835f, 80.616844f, 18.76142f, 76.50001f, 17.65625f);
generalPath.curveTo(76.4781f, 17.65003f, 76.459335f, 17.632f, 76.43751f, 17.625f);
generalPath.curveTo(75.725395f, 17.39683f, 75.05727f, 16.76769f, 74.96876f, 15.8125f);
generalPath.lineTo(74.37501f, 6.375f);
generalPath.curveTo(74.37501f, 5.40555f, 73.58695f, 4.77818f, 72.62501f, 4.625f);
generalPath.curveTo(69.37577f, 4.17392f, 67.27386f, 4.01728f, 64.0f, 4.0f);
generalPath.closePath();
generalPath.moveTo(64.0f, 48.0f);
generalPath.curveTo(72.832f, 48.0f, 80.00001f, 55.168f, 80.00001f, 64.0f);
generalPath.curveTo(80.00001f, 72.832f, 72.832f, 80.0f, 64.0f, 80.0f);
generalPath.curveTo(55.168003f, 80.0f, 48.000004f, 72.832f, 48.000004f, 64.0f);
generalPath.curveTo(48.000004f, 55.168f, 55.168003f, 48.0f, 64.0f, 48.0f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_1
paint = new LinearGradientPaint(new Point2D.Double(320.0306701660156, 88.53308868408203), new Point2D.Double(310.0306701660156, -16.466909408569336), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -230.03067016601562f, 40.266910552978516f));
stroke = new BasicStroke(1.0f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(63.96933f, 4.76691f);
generalPath.curveTo(60.695477f, 4.78419f, 58.59356f, 4.94083f, 55.34433f, 5.39191f);
generalPath.curveTo(54.382378f, 5.54509f, 53.59433f, 6.17246f, 53.59433f, 7.14191f);
generalPath.lineTo(53.00058f, 16.57941f);
generalPath.curveTo(52.912067f, 17.5346f, 52.24394f, 18.16374f, 51.53183f, 18.39191f);
generalPath.curveTo(51.51f, 18.39891f, 51.491226f, 18.41694f, 51.46933f, 18.42316f);
generalPath.curveTo(47.35249f, 19.52833f, 43.4464f, 21.14526f, 39.84433f, 23.23566f);
generalPath.curveTo(39.19278f, 23.51759f, 38.3522f, 23.5006f, 37.65683f, 22.92316f);
generalPath.lineTo(30.563078f, 16.67316f);
generalPath.curveTo(29.877579f, 15.98766f, 28.882849f, 16.10128f, 28.094328f, 16.67316f);
generalPath.curveTo(25.477818f, 18.65175f, 23.859009f, 20.02666f, 21.531828f, 22.32941f);
generalPath.curveTo(19.229088f, 24.65659f, 17.854168f, 26.27539f, 15.875578f, 28.89191f);
generalPath.curveTo(15.303698f, 29.68043f, 15.190078f, 30.67516f, 15.875578f, 31.36066f);
generalPath.lineTo(22.125578f, 38.45441f);
generalPath.curveTo(22.599298f, 39.02489f, 22.861778f, 39.76326f, 22.594328f, 40.29816f);
generalPath.lineTo(22.531828f, 40.42316f);
generalPath.curveTo(20.286308f, 44.22276f, 18.536968f, 48.359474f, 17.406828f, 52.735664f);
generalPath.curveTo(17.394987f, 52.7563f, 17.388159f, 52.777824f, 17.375578f, 52.798164f);
generalPath.curveTo(17.058369f, 53.311005f, 16.520187f, 53.729748f, 15.781828f, 53.798164f);
generalPath.lineTo(6.344328f, 54.391914f);
generalPath.curveTo(5.3748875f, 54.391914f, 4.7475176f, 55.179966f, 4.5943274f, 56.141914f);
generalPath.curveTo(4.1432476f, 59.391148f, 3.9866076f, 61.49306f, 3.9693277f, 64.766914f);
generalPath.curveTo(3.9866076f, 68.04077f, 4.1432476f, 70.142685f, 4.5943274f, 73.391914f);
generalPath.curveTo(4.7475176f, 74.35386f, 5.3748875f, 75.141914f, 6.344328f, 75.141914f);
generalPath.lineTo(15.781828f, 75.735664f);
generalPath.curveTo(16.649178f, 75.81603f, 17.225267f, 76.38223f, 17.500578f, 77.016914f);
generalPath.curveTo(18.603807f, 81.16027f, 20.266829f, 85.08112f, 22.375578f, 88.704414f);
generalPath.curveTo(22.748499f, 89.372925f, 22.757208f, 90.31878f, 22.125578f, 91.079414f);
generalPath.lineTo(15.875578f, 98.173164f);
generalPath.curveTo(15.190078f, 98.858665f, 15.303698f, 99.85339f, 15.875578f, 100.64192f);
generalPath.curveTo(17.854168f, 103.25843f, 19.229088f, 104.87723f, 21.531828f, 107.20442f);
generalPath.curveTo(23.859009f, 109.50716f, 25.477808f, 110.88208f, 28.094328f, 112.86067f);
generalPath.curveTo(28.882849f, 113.43255f, 29.877579f, 113.54617f, 30.563078f, 112.86067f);
generalPath.lineTo(37.65683f, 106.61067f);
generalPath.curveTo(38.41747f, 105.97904f, 39.36332f, 105.98775f, 40.03183f, 106.36067f);
generalPath.lineTo(40.12558f, 106.26692f);
generalPath.curveTo(43.653236f, 108.28409f, 47.45377f, 109.87644f, 51.46933f, 110.95442f);
generalPath.lineTo(51.46933f, 111.11067f);
generalPath.curveTo(52.205727f, 111.31968f, 52.90936f, 111.96994f, 53.00058f, 112.95442f);
generalPath.lineTo(53.59433f, 122.39192f);
generalPath.curveTo(53.59433f, 123.36136f, 54.382378f, 123.98873f, 55.34433f, 124.14192f);
generalPath.curveTo(58.59356f, 124.593f, 60.695477f, 124.74964f, 63.96933f, 124.76692f);
generalPath.curveTo(67.24318f, 124.74964f, 69.3451f, 124.593f, 72.59433f, 124.14192f);
generalPath.curveTo(73.55628f, 123.98873f, 74.34433f, 123.36136f, 74.34433f, 122.39192f);
generalPath.lineTo(74.93808f, 112.95442f);
generalPath.curveTo(75.0293f, 111.96994f, 75.732925f, 111.31968f, 76.46933f, 111.11067f);
generalPath.lineTo(76.46933f, 110.95442f);
generalPath.curveTo(80.484886f, 109.87644f, 84.28543f, 108.28409f, 87.81308f, 106.26692f);
generalPath.lineTo(87.90683f, 106.36067f);
generalPath.curveTo(88.57534f, 105.98775f, 89.52119f, 105.97904f, 90.28183f, 106.61067f);
generalPath.lineTo(97.37558f, 112.86067f);
generalPath.curveTo(98.06108f, 113.54618f, 99.05582f, 113.43256f, 99.84433f, 112.86067f);
generalPath.curveTo(102.46084f, 110.88208f, 104.07964f, 109.50716f, 106.40683f, 107.20442f);
generalPath.curveTo(108.70957f, 104.87723f, 110.08449f, 103.25843f, 112.06308f, 100.64192f);
generalPath.curveTo(112.63497f, 99.8534f, 112.74859f, 98.85867f, 112.06308f, 98.173164f);
generalPath.lineTo(105.81308f, 91.079414f);
generalPath.curveTo(105.18145f, 90.31878f, 105.19016f, 89.372925f, 105.56308f, 88.704414f);
generalPath.curveTo(107.67183f, 85.08112f, 109.33485f, 81.16027f, 110.43808f, 77.016914f);
generalPath.curveTo(110.71339f, 76.38223f, 111.28948f, 75.81603f, 112.15683f, 75.735664f);
generalPath.lineTo(121.59433f, 75.141914f);
generalPath.curveTo(122.56378f, 75.141914f, 123.19115f, 74.35386f, 123.34433f, 73.391914f);
generalPath.curveTo(123.79541f, 70.142685f, 123.95205f, 68.04077f, 123.96933f, 64.766914f);
generalPath.curveTo(123.95205f, 61.49306f, 123.79541f, 59.391148f, 123.34433f, 56.141914f);
generalPath.curveTo(123.19115f, 55.179966f, 122.56378f, 54.391914f, 121.59433f, 54.391914f);
generalPath.lineTo(112.15683f, 53.798164f);
generalPath.curveTo(111.41847f, 53.729748f, 110.88029f, 53.311005f, 110.56308f, 52.798164f);
generalPath.curveTo(110.55745f, 52.77624f, 110.53749f, 52.757576f, 110.53183f, 52.735664f);
generalPath.curveTo(109.40169f, 48.359474f, 107.38062f, 44.370754f, 105.40683f, 40.42316f);
generalPath.lineTo(105.34433f, 40.29816f);
generalPath.curveTo(105.07688f, 39.76326f, 105.33936f, 39.02489f, 105.81308f, 38.45441f);
generalPath.lineTo(112.06308f, 31.36066f);
generalPath.curveTo(112.74859f, 30.67515f, 112.63496f, 29.68043f, 112.06308f, 28.89191f);
generalPath.curveTo(110.08449f, 26.27539f, 108.70957f, 24.65659f, 106.40683f, 22.32941f);
generalPath.curveTo(104.07965f, 20.02666f, 102.46085f, 18.65175f, 99.84433f, 16.67316f);
generalPath.curveTo(99.05581f, 16.10128f, 98.06109f, 15.98765f, 97.37558f, 16.67316f);
generalPath.lineTo(90.28183f, 22.92316f);
generalPath.curveTo(89.58645f, 23.5006f, 88.74588f, 23.51759f, 88.09433f, 23.23566f);
generalPath.curveTo(84.492256f, 21.14526f, 80.58617f, 19.52833f, 76.46933f, 18.42316f);
generalPath.curveTo(76.447426f, 18.41694f, 76.42866f, 18.39891f, 76.40683f, 18.39191f);
generalPath.curveTo(75.69472f, 18.16374f, 75.02659f, 17.5346f, 74.93808f, 16.57941f);
generalPath.lineTo(74.34433f, 7.14191f);
generalPath.curveTo(74.34433f, 6.17246f, 73.55628f, 5.54509f, 72.59433f, 5.39191f);
generalPath.curveTo(69.3451f, 4.94083f, 67.24318f, 4.78419f, 63.96933f, 4.76691f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(64.0f, 4.0f);
generalPath.curveTo(60.72615f, 4.01728f, 58.624233f, 4.17392f, 55.375004f, 4.625f);
generalPath.curveTo(54.41305f, 4.77818f, 53.625004f, 5.40555f, 53.625004f, 6.375f);
generalPath.lineTo(53.031254f, 15.8125f);
generalPath.curveTo(52.942745f, 16.76769f, 52.27461f, 17.39683f, 51.562504f, 17.625f);
generalPath.curveTo(51.540672f, 17.632f, 51.521908f, 17.65003f, 51.500004f, 17.65625f);
generalPath.curveTo(47.383163f, 18.76142f, 43.477077f, 20.37835f, 39.875004f, 22.46875f);
generalPath.curveTo(39.223457f, 22.75068f, 38.382877f, 22.73369f, 37.687504f, 22.15625f);
generalPath.lineTo(30.593752f, 15.90625f);
generalPath.curveTo(29.908255f, 15.22075f, 28.913525f, 15.33437f, 28.125002f, 15.90625f);
generalPath.curveTo(25.508488f, 17.88484f, 23.889685f, 19.25976f, 21.562502f, 21.5625f);
generalPath.curveTo(19.259756f, 23.88968f, 17.884844f, 25.50848f, 15.906252f, 28.125f);
generalPath.curveTo(15.334375f, 28.91352f, 15.220754f, 29.90825f, 15.906252f, 30.59375f);
generalPath.lineTo(22.156252f, 37.6875f);
generalPath.curveTo(22.629972f, 38.25798f, 22.892454f, 38.99635f, 22.625002f, 39.53125f);
generalPath.lineTo(22.562502f, 39.65625f);
generalPath.curveTo(20.316984f, 43.45585f, 18.567642f, 47.592564f, 17.437502f, 51.96875f);
generalPath.curveTo(17.425657f, 51.989388f, 17.418833f, 52.010914f, 17.406252f, 52.03125f);
generalPath.curveTo(17.089043f, 52.54409f, 16.550861f, 52.962833f, 15.812502f, 53.03125f);
generalPath.lineTo(6.375002f, 53.625f);
generalPath.curveTo(5.4055614f, 53.625f, 4.7781916f, 54.41305f, 4.6250014f, 55.375f);
generalPath.curveTo(4.1739216f, 58.624233f, 4.0172815f, 60.726147f, 4.0000014f, 64.0f);
generalPath.curveTo(4.0172815f, 67.27386f, 4.1739216f, 69.37577f, 4.6250014f, 72.625f);
generalPath.curveTo(4.7781916f, 73.586945f, 5.4055614f, 74.375f, 6.375002f, 74.375f);
generalPath.lineTo(15.812502f, 74.96875f);
generalPath.curveTo(16.679848f, 75.049126f, 17.255938f, 75.61532f, 17.531252f, 76.25f);
generalPath.curveTo(18.634481f, 80.39336f, 20.297504f, 84.31421f, 22.406252f, 87.9375f);
generalPath.curveTo(22.779173f, 88.60601f, 22.787882f, 89.551865f, 22.156252f, 90.3125f);
generalPath.lineTo(15.906252f, 97.40625f);
generalPath.curveTo(15.220754f, 98.09175f, 15.334372f, 99.08648f, 15.906252f, 99.875f);
generalPath.curveTo(17.884844f, 102.49151f, 19.259756f, 104.11031f, 21.562502f, 106.4375f);
generalPath.curveTo(23.889685f, 108.74024f, 25.508486f, 110.11516f, 28.125002f, 112.09375f);
generalPath.curveTo(28.913523f, 112.66563f, 29.908255f, 112.77925f, 30.593752f, 112.09375f);
generalPath.lineTo(37.687504f, 105.84375f);
generalPath.curveTo(38.44814f, 105.21212f, 39.393993f, 105.22083f, 40.062504f, 105.59375f);
generalPath.lineTo(40.156254f, 105.5f);
generalPath.curveTo(43.683907f, 107.51717f, 47.484444f, 109.10952f, 51.500004f, 110.1875f);
generalPath.lineTo(51.500004f, 110.34375f);
generalPath.curveTo(52.236404f, 110.55276f, 52.94003f, 111.20302f, 53.031254f, 112.1875f);
generalPath.lineTo(53.625004f, 121.625f);
generalPath.curveTo(53.625004f, 122.59444f, 54.41305f, 123.22181f, 55.375004f, 123.375f);
generalPath.curveTo(58.624233f, 123.82608f, 60.72615f, 123.98272f, 64.0f, 124.0f);
generalPath.curveTo(67.27386f, 123.98272f, 69.37577f, 123.82608f, 72.625f, 123.375f);
generalPath.curveTo(73.58695f, 123.22181f, 74.375f, 122.59444f, 74.375f, 121.625f);
generalPath.lineTo(74.96875f, 112.1875f);
generalPath.curveTo(75.059975f, 111.20302f, 75.7636f, 110.55276f, 76.5f, 110.34375f);
generalPath.lineTo(76.5f, 110.1875f);
generalPath.curveTo(80.51556f, 109.10952f, 84.3161f, 107.51717f, 87.84375f, 105.5f);
generalPath.lineTo(87.9375f, 105.59375f);
generalPath.curveTo(88.60601f, 105.22083f, 89.551865f, 105.21212f, 90.3125f, 105.84375f);
generalPath.lineTo(97.40625f, 112.09375f);
generalPath.curveTo(98.09176f, 112.77926f, 99.08649f, 112.66564f, 99.875f, 112.09375f);
generalPath.curveTo(102.49151f, 110.11516f, 104.11031f, 108.74024f, 106.4375f, 106.4375f);
generalPath.curveTo(108.74024f, 104.11031f, 110.11516f, 102.49151f, 112.09375f, 99.875f);
generalPath.curveTo(112.66564f, 99.08649f, 112.77926f, 98.09176f, 112.09375f, 97.40625f);
generalPath.lineTo(105.84375f, 90.3125f);
generalPath.curveTo(105.21212f, 89.551865f, 105.22083f, 88.60601f, 105.59375f, 87.9375f);
generalPath.curveTo(107.7025f, 84.31421f, 109.36552f, 80.39336f, 110.46875f, 76.25f);
generalPath.curveTo(110.74406f, 75.61532f, 111.32015f, 75.049126f, 112.1875f, 74.96875f);
generalPath.lineTo(121.625f, 74.375f);
generalPath.curveTo(122.59445f, 74.375f, 123.22182f, 73.586945f, 123.375f, 72.625f);
generalPath.curveTo(123.82608f, 69.37577f, 123.98272f, 67.27386f, 124.0f, 64.0f);
generalPath.curveTo(123.98272f, 60.726147f, 123.82608f, 58.624233f, 123.375f, 55.375f);
generalPath.curveTo(123.22182f, 54.41305f, 122.59445f, 53.625f, 121.625f, 53.625f);
generalPath.lineTo(112.1875f, 53.03125f);
generalPath.curveTo(111.44914f, 52.962833f, 110.91096f, 52.54409f, 110.59375f, 52.03125f);
generalPath.curveTo(110.58812f, 52.00933f, 110.56816f, 51.99066f, 110.5625f, 51.96875f);
generalPath.curveTo(109.43236f, 47.592564f, 107.41129f, 43.60384f, 105.4375f, 39.65625f);
generalPath.lineTo(105.375f, 39.53125f);
generalPath.curveTo(105.10755f, 38.99635f, 105.37003f, 38.25798f, 105.84375f, 37.6875f);
generalPath.lineTo(112.09375f, 30.59375f);
generalPath.curveTo(112.77926f, 29.90824f, 112.66563f, 28.91352f, 112.09375f, 28.125f);
generalPath.curveTo(110.11516f, 25.50848f, 108.74024f, 23.88968f, 106.4375f, 21.5625f);
generalPath.curveTo(104.11032f, 19.25975f, 102.49152f, 17.88484f, 99.875f, 15.90625f);
generalPath.curveTo(99.08649f, 15.33437f, 98.09176f, 15.22075f, 97.40625f, 15.90625f);
generalPath.lineTo(90.3125f, 22.15625f);
generalPath.curveTo(89.61713f, 22.73369f, 88.77655f, 22.75068f, 88.125f, 22.46875f);
generalPath.curveTo(84.52293f, 20.37835f, 80.61684f, 18.76142f, 76.5f, 17.65625f);
generalPath.curveTo(76.478096f, 17.65003f, 76.459335f, 17.632f, 76.4375f, 17.625f);
generalPath.curveTo(75.725395f, 17.39683f, 75.05727f, 16.76769f, 74.96875f, 15.8125f);
generalPath.lineTo(74.375f, 6.375f);
generalPath.curveTo(74.375f, 5.40555f, 73.58695f, 4.77818f, 72.625f, 4.625f);
generalPath.curveTo(69.37577f, 4.17392f, 67.27386f, 4.01728f, 64.0f, 4.0f);
generalPath.closePath();
generalPath.moveTo(64.0f, 48.0f);
generalPath.curveTo(72.832f, 48.0f, 80.0f, 55.168f, 80.0f, 64.0f);
generalPath.curveTo(80.0f, 72.832f, 72.832f, 80.0f, 64.0f, 80.0f);
generalPath.curveTo(55.168003f, 80.0f, 48.000004f, 72.832f, 48.000004f, 64.0f);
generalPath.curveTo(48.000004f, 55.168f, 55.168003f, 48.0f, 64.0f, 48.0f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(64.0, 81.5), new Point2D.Double(64.0, 12.678302764892578), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(180, 180, 180, 255),new Color(209, 209, 209, 255),new Color(250, 250, 250, 255)}, MultipleGradientPaint.CycleMethod.REFLECT, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 1.500000053056283E-6f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 148.0f, 0.0f));
// _0_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-84.0f, 4.0f);
generalPath.curveTo(-87.27385f, 4.0172763f, -89.37577f, 4.1739182f, -92.625f, 4.625f);
generalPath.curveTo(-93.58695f, 4.778184f, -94.375f, 5.4055495f, -94.375f, 6.375f);
generalPath.lineTo(-94.96875f, 15.8125f);
generalPath.curveTo(-95.05726f, 16.767694f, -95.725395f, 17.39683f, -96.4375f, 17.625f);
generalPath.curveTo(-96.45933f, 17.631994f, -96.478096f, 17.650034f, -96.5f, 17.65625f);
generalPath.curveTo(-100.61684f, 18.76142f, -104.52293f, 20.378351f, -108.125f, 22.46875f);
generalPath.curveTo(-108.77655f, 22.75068f, -109.61713f, 22.733686f, -110.3125f, 22.15625f);
generalPath.lineTo(-117.40625f, 15.90625f);
generalPath.curveTo(-118.09175f, 15.220752f, -119.08648f, 15.33437f, -119.875f, 15.90625f);
generalPath.curveTo(-122.49151f, 17.884842f, -124.11032f, 19.259754f, -126.4375f, 21.5625f);
generalPath.curveTo(-128.74023f, 23.889683f, -130.11516f, 25.508484f, -132.09375f, 28.125f);
generalPath.curveTo(-132.66563f, 28.91352f, -132.77925f, 29.908253f, -132.09375f, 30.59375f);
generalPath.lineTo(-125.84375f, 37.6875f);
generalPath.curveTo(-125.37003f, 38.25798f, -125.10755f, 38.996346f, -125.375f, 39.53125f);
generalPath.lineTo(-125.4375f, 39.65625f);
generalPath.curveTo(-127.68302f, 43.45585f, -129.43236f, 47.592564f, -130.5625f, 51.96875f);
generalPath.curveTo(-130.57434f, 51.989388f, -130.58118f, 52.01091f, -130.59375f, 52.03125f);
generalPath.curveTo(-130.91096f, 52.54409f, -131.44914f, 52.962833f, -132.1875f, 53.03125f);
generalPath.lineTo(-141.625f, 53.625f);
generalPath.curveTo(-142.59444f, 53.625f, -143.22182f, 54.41305f, -143.375f, 55.375f);
generalPath.curveTo(-143.82608f, 58.624233f, -143.98273f, 60.726147f, -144.0f, 64.0f);
generalPath.curveTo(-143.98273f, 67.27386f, -143.82608f, 69.37577f, -143.375f, 72.625f);
generalPath.curveTo(-143.22182f, 73.586945f, -142.59444f, 74.375f, -141.625f, 74.375f);
generalPath.lineTo(-132.1875f, 74.96875f);
generalPath.curveTo(-131.32014f, 75.04912f, -130.74406f, 75.61532f, -130.46875f, 76.25f);
generalPath.curveTo(-129.36552f, 80.39336f, -127.7025f, 84.31421f, -125.59375f, 87.9375f);
generalPath.curveTo(-125.22083f, 88.60601f, -125.21212f, 89.551865f, -125.84375f, 90.3125f);
generalPath.lineTo(-132.09375f, 97.40625f);
generalPath.curveTo(-132.77925f, 98.09174f, -132.66563f, 99.08648f, -132.09375f, 99.875f);
generalPath.curveTo(-130.11516f, 102.49151f, -128.74023f, 104.11031f, -126.4375f, 106.4375f);
generalPath.curveTo(-124.11032f, 108.74024f, -122.49152f, 110.11516f, -119.875f, 112.09375f);
generalPath.curveTo(-119.08648f, 112.66563f, -118.09175f, 112.77925f, -117.40625f, 112.09375f);
generalPath.lineTo(-110.3125f, 105.84375f);
generalPath.curveTo(-109.55186f, 105.21212f, -108.60601f, 105.22083f, -107.9375f, 105.59375f);
generalPath.lineTo(-107.84375f, 105.5f);
generalPath.curveTo(-104.31609f, 107.51717f, -100.51556f, 109.10952f, -96.5f, 110.1875f);
generalPath.lineTo(-96.5f, 110.34375f);
generalPath.curveTo(-95.763596f, 110.55276f, -95.05997f, 111.20302f, -94.96875f, 112.1875f);
generalPath.lineTo(-94.375f, 121.625f);
generalPath.curveTo(-94.375f, 122.59444f, -93.58695f, 123.22181f, -92.625f, 123.375f);
generalPath.curveTo(-89.37577f, 123.82608f, -87.27385f, 123.98272f, -84.0f, 124.0f);
generalPath.curveTo(-80.72614f, 123.98272f, -78.62423f, 123.82608f, -75.375f, 123.375f);
generalPath.curveTo(-74.413055f, 123.22181f, -73.625f, 122.59444f, -73.625f, 121.625f);
generalPath.lineTo(-73.03125f, 112.1875f);
generalPath.curveTo(-72.940025f, 111.20302f, -72.2364f, 110.55276f, -71.5f, 110.34375f);
generalPath.lineTo(-71.5f, 110.1875f);
generalPath.curveTo(-67.48444f, 109.10952f, -63.683903f, 107.51717f, -60.15625f, 105.5f);
generalPath.lineTo(-60.0625f, 105.59375f);
generalPath.curveTo(-59.393993f, 105.22083f, -58.448135f, 105.21212f, -57.6875f, 105.84375f);
generalPath.lineTo(-50.59375f, 112.09375f);
generalPath.curveTo(-49.908245f, 112.77926f, -48.913513f, 112.66564f, -48.125f, 112.09375f);
generalPath.curveTo(-45.508488f, 110.11516f, -43.88969f, 108.74024f, -41.5625f, 106.4375f);
generalPath.curveTo(-39.259758f, 104.11031f, -37.88484f, 102.49151f, -35.90625f, 99.875f);
generalPath.curveTo(-35.33436f, 99.08649f, -35.220737f, 98.09176f, -35.90625f, 97.40625f);
generalPath.lineTo(-42.15625f, 90.3125f);
generalPath.curveTo(-42.78788f, 89.55186f, -42.779167f, 88.60601f, -42.40625f, 87.9375f);
generalPath.curveTo(-40.2975f, 84.31421f, -38.63448f, 80.39336f, -37.53125f, 76.25f);
generalPath.curveTo(-37.25594f, 75.61532f, -36.679848f, 75.04912f, -35.8125f, 74.96875f);
generalPath.lineTo(-26.374998f, 74.375f);
generalPath.curveTo(-25.405548f, 74.375f, -24.77818f, 73.586945f, -24.624998f, 72.625f);
generalPath.curveTo(-24.17392f, 69.37577f, -24.017279f, 67.27386f, -23.999998f, 64.0f);
generalPath.curveTo(-24.017279f, 60.726147f, -24.17392f, 58.624233f, -24.624998f, 55.375f);
generalPath.curveTo(-24.77818f, 54.41305f, -25.405548f, 53.625f, -26.374998f, 53.625f);
generalPath.lineTo(-35.8125f, 53.03125f);
generalPath.curveTo(-36.550858f, 52.962833f, -37.08904f, 52.54409f, -37.40625f, 52.03125f);
generalPath.curveTo(-37.41188f, 52.009327f, -37.43184f, 51.99066f, -37.4375f, 51.96875f);
generalPath.curveTo(-38.56764f, 47.592564f, -40.58871f, 43.60384f, -42.5625f, 39.65625f);
generalPath.lineTo(-42.625f, 39.53125f);
generalPath.curveTo(-42.89245f, 38.996346f, -42.62997f, 38.257977f, -42.15625f, 37.6875f);
generalPath.lineTo(-35.90625f, 30.59375f);
generalPath.curveTo(-35.220737f, 29.908243f, -35.33437f, 28.913515f, -35.90625f, 28.125f);
generalPath.curveTo(-37.88484f, 25.508484f, -39.259758f, 23.88968f, -41.5625f, 21.5625f);
generalPath.curveTo(-43.88968f, 19.259752f, -45.50848f, 17.884842f, -48.125f, 15.90625f);
generalPath.curveTo(-48.913513f, 15.334366f, -49.90824f, 15.220745f, -50.59375f, 15.90625f);
generalPath.lineTo(-57.6875f, 22.15625f);
generalPath.curveTo(-58.382874f, 22.733685f, -59.223454f, 22.750683f, -59.875f, 22.46875f);
generalPath.curveTo(-63.477074f, 20.378351f, -67.38316f, 18.76142f, -71.5f, 17.65625f);
generalPath.curveTo(-71.521904f, 17.650034f, -71.540665f, 17.631994f, -71.5625f, 17.625f);
generalPath.curveTo(-72.274605f, 17.39683f, -72.94274f, 16.767694f, -73.03125f, 15.8125f);
generalPath.lineTo(-73.625f, 6.375f);
generalPath.curveTo(-73.625f, 5.4055495f, -74.413055f, 4.778184f, -75.375f, 4.625f);
generalPath.curveTo(-78.62423f, 4.1739182f, -80.72614f, 4.0172763f, -84.0f, 4.0f);
generalPath.closePath();
generalPath.moveTo(-84.0f, 48.0f);
generalPath.curveTo(-75.168f, 48.0f, -68.0f, 55.168f, -68.0f, 64.0f);
generalPath.curveTo(-68.0f, 72.832f, -75.168f, 80.0f, -84.0f, 80.0f);
generalPath.curveTo(-92.832f, 80.0f, -100.0f, 72.832f, -100.0f, 64.0f);
generalPath.curveTo(-100.0f, 55.168f, -92.832f, 48.0f, -84.0f, 48.0f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(-1.2494016885757446, 23.725372314453125), 60.0f, new Point2D.Double(-1.2494016885757446, 61.40414047241211), new float[] {0.0f,0.610522f,0.68472904f,0.7499575f,1.0f}, new Color[] {new Color(0, 0, 0, 0),new Color(0, 0, 0, 0),new Color(0, 0, 0, 96),new Color(0, 0, 0, 0),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.3581355810165405f, 1.5026073455810547f, -1.6333333253860474f, 1.4762927293777466f, -61.051700592041016f, -44.64823532104492f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.9592391f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 1.500000053056283E-6f, 143.5f));
// _0_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(76.90625f, -70.0625f);
generalPath.curveTo(73.993996f, -66.0904f, 69.2992f, -63.5f, 64.0f, -63.5f);
generalPath.curveTo(59.104214f, -63.5f, 54.71693f, -65.68865f, 51.78125f, -69.15625f);
generalPath.lineTo(20.28125f, -38.40625f);
generalPath.curveTo(20.690083f, -37.972248f, 21.088367f, -37.541668f, 21.5625f, -37.0625f);
generalPath.curveTo(23.88968f, -34.759758f, 25.50848f, -33.38484f, 28.125f, -31.406248f);
generalPath.curveTo(28.91352f, -30.83437f, 29.90825f, -30.720749f, 30.59375f, -31.406248f);
generalPath.lineTo(37.6875f, -37.65625f);
generalPath.curveTo(38.44814f, -38.28788f, 39.39399f, -38.279167f, 40.0625f, -37.90625f);
generalPath.lineTo(40.15625f, -38.0f);
generalPath.curveTo(43.68391f, -35.98283f, 47.48444f, -34.39048f, 51.5f, -33.3125f);
generalPath.lineTo(51.5f, -33.15625f);
generalPath.curveTo(52.2364f, -32.94724f, 52.94003f, -32.296978f, 53.03125f, -31.312498f);
generalPath.lineTo(53.625f, -21.874998f);
generalPath.curveTo(53.625f, -20.90556f, 54.41305f, -20.278189f, 55.375f, -20.124998f);
generalPath.curveTo(58.624233f, -19.67392f, 60.726147f, -19.517279f, 64.0f, -19.499998f);
generalPath.curveTo(67.27386f, -19.517279f, 69.37577f, -19.67392f, 72.625f, -20.124998f);
generalPath.curveTo(73.586945f, -20.278189f, 74.375f, -20.90556f, 74.375f, -21.874998f);
generalPath.lineTo(74.96875f, -31.312498f);
generalPath.curveTo(75.059975f, -32.296978f, 75.7636f, -32.94724f, 76.5f, -33.15625f);
generalPath.lineTo(76.5f, -33.3125f);
generalPath.curveTo(80.51556f, -34.39048f, 84.31609f, -35.98283f, 87.84375f, -38.0f);
generalPath.lineTo(87.9375f, -37.90625f);
generalPath.curveTo(88.60601f, -38.279167f, 89.551865f, -38.28788f, 90.3125f, -37.65625f);
generalPath.lineTo(97.40625f, -31.406248f);
generalPath.curveTo(98.09176f, -30.72074f, 99.08649f, -30.834358f, 99.875f, -31.406248f);
generalPath.curveTo(102.49151f, -33.38484f, 104.11031f, -34.759758f, 106.4375f, -37.0625f);
generalPath.curveTo(106.92292f, -37.55307f, 107.3327f, -37.993908f, 107.75f, -38.4375f);
generalPath.lineTo(76.90625f, -70.0625f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(94.81892395019531, 67.8951187133789), 43.734375f, new Point2D.Double(94.81892395019531, 67.8951187133789), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.5780636072158813f, 0.0f, -101.84696197509766f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.9918478f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-1.0f, 0.0f, 0.0f, -1.0f, 127.98705291748047f, -15.49155044555664f));
// _0_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(76.90625f, -70.0625f);
generalPath.curveTo(73.993996f, -66.0904f, 69.2992f, -63.5f, 64.0f, -63.5f);
generalPath.curveTo(59.104214f, -63.5f, 54.71693f, -65.68865f, 51.78125f, -69.15625f);
generalPath.lineTo(20.28125f, -38.40625f);
generalPath.curveTo(20.690083f, -37.972248f, 21.088367f, -37.541668f, 21.5625f, -37.0625f);
generalPath.curveTo(23.88968f, -34.759758f, 25.50848f, -33.38484f, 28.125f, -31.406248f);
generalPath.curveTo(28.91352f, -30.83437f, 29.90825f, -30.720749f, 30.59375f, -31.406248f);
generalPath.lineTo(37.6875f, -37.65625f);
generalPath.curveTo(38.44814f, -38.28788f, 39.39399f, -38.279167f, 40.0625f, -37.90625f);
generalPath.lineTo(40.15625f, -38.0f);
generalPath.curveTo(43.68391f, -35.98283f, 47.48444f, -34.39048f, 51.5f, -33.3125f);
generalPath.lineTo(51.5f, -33.15625f);
generalPath.curveTo(52.2364f, -32.94724f, 52.94003f, -32.296978f, 53.03125f, -31.312498f);
generalPath.lineTo(53.625f, -21.874998f);
generalPath.curveTo(53.625f, -20.90556f, 54.41305f, -20.278189f, 55.375f, -20.124998f);
generalPath.curveTo(58.624233f, -19.67392f, 60.726147f, -19.517279f, 64.0f, -19.499998f);
generalPath.curveTo(67.27386f, -19.517279f, 69.37577f, -19.67392f, 72.625f, -20.124998f);
generalPath.curveTo(73.586945f, -20.278189f, 74.375f, -20.90556f, 74.375f, -21.874998f);
generalPath.lineTo(74.96875f, -31.312498f);
generalPath.curveTo(75.059975f, -32.296978f, 75.7636f, -32.94724f, 76.5f, -33.15625f);
generalPath.lineTo(76.5f, -33.3125f);
generalPath.curveTo(80.51556f, -34.39048f, 84.31609f, -35.98283f, 87.84375f, -38.0f);
generalPath.lineTo(87.9375f, -37.90625f);
generalPath.curveTo(88.60601f, -38.279167f, 89.551865f, -38.28788f, 90.3125f, -37.65625f);
generalPath.lineTo(97.40625f, -31.406248f);
generalPath.curveTo(98.09176f, -30.72074f, 99.08649f, -30.834358f, 99.875f, -31.406248f);
generalPath.curveTo(102.49151f, -33.38484f, 104.11031f, -34.759758f, 106.4375f, -37.0625f);
generalPath.curveTo(106.92292f, -37.55307f, 107.3327f, -37.993908f, 107.75f, -38.4375f);
generalPath.lineTo(76.90625f, -70.0625f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(89.56141662597656, 80.48823547363281), 43.734375f, new Point2D.Double(89.56141662597656, 80.48823547363281), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.5780636072158813f, 0.0f, -101.84696197509766f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.732342f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_6
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(64.0f, 4.0f);
generalPath.curveTo(60.72615f, 4.01728f, 58.624233f, 4.17392f, 55.375004f, 4.625f);
generalPath.curveTo(54.41305f, 4.77818f, 53.625004f, 5.40555f, 53.625004f, 6.375f);
generalPath.lineTo(53.031254f, 15.8125f);
generalPath.curveTo(52.94274f, 16.76769f, 52.274612f, 17.39683f, 51.562504f, 17.625f);
generalPath.curveTo(51.540672f, 17.632f, 51.5219f, 17.65003f, 51.500004f, 17.65625f);
generalPath.curveTo(47.383163f, 18.76142f, 43.477074f, 20.37835f, 39.875004f, 22.46875f);
generalPath.curveTo(39.223454f, 22.75068f, 38.382874f, 22.73369f, 37.687504f, 22.15625f);
generalPath.lineTo(30.593752f, 15.90625f);
generalPath.curveTo(29.908253f, 15.22075f, 28.913523f, 15.33437f, 28.125002f, 15.90625f);
generalPath.curveTo(25.508492f, 17.88484f, 23.889683f, 19.25975f, 21.562502f, 21.5625f);
generalPath.curveTo(19.259762f, 23.88968f, 17.884842f, 25.50848f, 15.906252f, 28.125f);
generalPath.curveTo(15.334372f, 28.91352f, 15.220752f, 29.90825f, 15.906252f, 30.59375f);
generalPath.lineTo(22.156252f, 37.6875f);
generalPath.curveTo(22.629972f, 38.25798f, 22.892452f, 38.99635f, 22.625002f, 39.53125f);
generalPath.lineTo(22.562502f, 39.65625f);
generalPath.curveTo(20.316982f, 43.45585f, 18.567642f, 47.592564f, 17.437502f, 51.96875f);
generalPath.curveTo(17.425661f, 51.989388f, 17.418833f, 52.01091f, 17.406252f, 52.03125f);
generalPath.curveTo(17.089043f, 52.54409f, 16.550861f, 52.962833f, 15.812502f, 53.03125f);
generalPath.lineTo(6.375002f, 53.625f);
generalPath.curveTo(5.405562f, 53.625f, 4.778192f, 54.41305f, 4.625002f, 55.375f);
generalPath.curveTo(4.173922f, 58.624233f, 4.017282f, 60.726147f, 4.000002f, 64.0f);
generalPath.curveTo(4.017282f, 67.27386f, 4.173922f, 69.37577f, 4.625002f, 72.625f);
generalPath.curveTo(4.778192f, 73.586945f, 5.405562f, 74.375f, 6.375002f, 74.375f);
generalPath.lineTo(15.812502f, 74.96875f);
generalPath.curveTo(16.679852f, 75.04912f, 17.255941f, 75.61532f, 17.531252f, 76.25f);
generalPath.curveTo(18.634481f, 80.39336f, 20.297503f, 84.31421f, 22.406252f, 87.9375f);
generalPath.curveTo(22.779173f, 88.60601f, 22.787882f, 89.551865f, 22.156252f, 90.3125f);
generalPath.lineTo(15.906252f, 97.40625f);
generalPath.curveTo(15.220752f, 98.09174f, 15.334372f, 99.08648f, 15.906252f, 99.875f);
generalPath.curveTo(17.884842f, 102.49151f, 19.259762f, 104.11031f, 21.562502f, 106.4375f);
generalPath.curveTo(23.889683f, 108.74024f, 25.508482f, 110.11516f, 28.125002f, 112.09375f);
generalPath.curveTo(28.913523f, 112.66563f, 29.908253f, 112.77925f, 30.593752f, 112.09375f);
generalPath.lineTo(37.687504f, 105.84375f);
generalPath.curveTo(38.448143f, 105.21212f, 39.393993f, 105.22083f, 40.062504f, 105.59375f);
generalPath.lineTo(40.156254f, 105.5f);
generalPath.curveTo(43.68391f, 107.51717f, 47.484444f, 109.10952f, 51.500004f, 110.1875f);
generalPath.lineTo(51.500004f, 110.34375f);
generalPath.curveTo(52.2364f, 110.55276f, 52.940033f, 111.20302f, 53.031254f, 112.1875f);
generalPath.lineTo(53.625004f, 121.625f);
generalPath.curveTo(53.625004f, 122.59444f, 54.41305f, 123.22181f, 55.375004f, 123.375f);
generalPath.curveTo(58.624233f, 123.82608f, 60.72615f, 123.98272f, 64.0f, 124.0f);
generalPath.curveTo(67.27385f, 123.98272f, 69.37577f, 123.82608f, 72.625f, 123.375f);
generalPath.curveTo(73.58695f, 123.22181f, 74.375f, 122.59444f, 74.375f, 121.625f);
generalPath.lineTo(74.96875f, 112.1875f);
generalPath.curveTo(75.059975f, 111.20302f, 75.7636f, 110.55276f, 76.5f, 110.34375f);
generalPath.lineTo(76.5f, 110.1875f);
generalPath.curveTo(80.515564f, 109.10952f, 84.3161f, 107.51717f, 87.84375f, 105.5f);
generalPath.lineTo(87.9375f, 105.59375f);
generalPath.curveTo(88.60601f, 105.22083f, 89.551865f, 105.21212f, 90.3125f, 105.84375f);
generalPath.lineTo(97.40625f, 112.09375f);
generalPath.curveTo(98.09175f, 112.77926f, 99.08649f, 112.66564f, 99.875f, 112.09375f);
generalPath.curveTo(102.49151f, 110.11516f, 104.11031f, 108.74024f, 106.4375f, 106.4375f);
generalPath.curveTo(108.74024f, 104.11031f, 110.11516f, 102.49151f, 112.09375f, 99.875f);
generalPath.curveTo(112.66564f, 99.08649f, 112.77926f, 98.09176f, 112.09375f, 97.40625f);
generalPath.lineTo(105.84375f, 90.3125f);
generalPath.curveTo(105.21212f, 89.55186f, 105.22083f, 88.60601f, 105.59375f, 87.9375f);
generalPath.curveTo(107.7025f, 84.31421f, 109.36552f, 80.39336f, 110.46875f, 76.25f);
generalPath.curveTo(110.74406f, 75.61532f, 111.32015f, 75.04912f, 112.1875f, 74.96875f);
generalPath.lineTo(121.625f, 74.375f);
generalPath.curveTo(122.59445f, 74.375f, 123.22182f, 73.586945f, 123.375f, 72.625f);
generalPath.curveTo(123.82608f, 69.37577f, 123.98272f, 67.27386f, 124.0f, 64.0f);
generalPath.curveTo(123.98272f, 60.726147f, 123.82608f, 58.624233f, 123.375f, 55.375f);
generalPath.curveTo(123.22182f, 54.41305f, 122.59445f, 53.625f, 121.625f, 53.625f);
generalPath.lineTo(112.1875f, 53.03125f);
generalPath.curveTo(111.44914f, 52.962833f, 110.91096f, 52.54409f, 110.59375f, 52.03125f);
generalPath.curveTo(110.58812f, 52.009327f, 110.56816f, 51.99066f, 110.5625f, 51.96875f);
generalPath.curveTo(109.43236f, 47.592564f, 107.41129f, 43.60384f, 105.4375f, 39.65625f);
generalPath.lineTo(105.375f, 39.53125f);
generalPath.curveTo(105.10755f, 38.99635f, 105.37003f, 38.25798f, 105.84375f, 37.6875f);
generalPath.lineTo(112.09375f, 30.59375f);
generalPath.curveTo(112.77926f, 29.90824f, 112.66563f, 28.91352f, 112.09375f, 28.125f);
generalPath.curveTo(110.11516f, 25.50848f, 108.74024f, 23.88968f, 106.4375f, 21.5625f);
generalPath.curveTo(104.11032f, 19.25975f, 102.49152f, 17.88484f, 99.875f, 15.90625f);
generalPath.curveTo(99.08648f, 15.33437f, 98.09176f, 15.22074f, 97.40625f, 15.90625f);
generalPath.lineTo(90.3125f, 22.15625f);
generalPath.curveTo(89.61713f, 22.73369f, 88.77655f, 22.75068f, 88.125f, 22.46875f);
generalPath.curveTo(84.522934f, 20.37835f, 80.616844f, 18.76142f, 76.5f, 17.65625f);
generalPath.curveTo(76.4781f, 17.65003f, 76.459335f, 17.632f, 76.4375f, 17.625f);
generalPath.curveTo(75.725395f, 17.39683f, 75.05727f, 16.76769f, 74.96875f, 15.8125f);
generalPath.lineTo(74.375f, 6.375f);
generalPath.curveTo(74.375f, 5.40555f, 73.58695f, 4.77818f, 72.625f, 4.625f);
generalPath.curveTo(69.37577f, 4.17392f, 67.27385f, 4.01728f, 64.0f, 4.0f);
generalPath.closePath();
generalPath.moveTo(64.0f, 48.0f);
generalPath.curveTo(72.832f, 48.0f, 80.0f, 55.168f, 80.0f, 64.0f);
generalPath.curveTo(80.0f, 72.832f, 72.832f, 80.0f, 64.0f, 80.0f);
generalPath.curveTo(55.168003f, 80.0f, 48.000004f, 72.832f, 48.000004f, 64.0f);
generalPath.curveTo(48.000004f, 55.168f, 55.168003f, 48.0f, 64.0f, 48.0f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(-84.0, 64.0), 60.0f, new Point2D.Double(-84.0, 64.0), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 148.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_7
paint = new LinearGradientPaint(new Point2D.Double(283.5, -52.5), new Point2D.Double(282.5, 128.5), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -230.03067016601562f, 39.46691131591797f));
stroke = new BasicStroke(1.0f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(63.96933f, 3.96691f);
generalPath.curveTo(60.695477f, 3.98419f, 58.59356f, 4.14083f, 55.34433f, 4.59191f);
generalPath.curveTo(54.382378f, 4.74509f, 53.59433f, 5.37246f, 53.59433f, 6.34191f);
generalPath.lineTo(53.00058f, 15.77941f);
generalPath.curveTo(52.912067f, 16.7346f, 52.24394f, 17.36374f, 51.53183f, 17.59191f);
generalPath.curveTo(51.51f, 17.59891f, 51.491226f, 17.61694f, 51.46933f, 17.62316f);
generalPath.curveTo(47.35249f, 18.72833f, 43.4464f, 20.34526f, 39.84433f, 22.43566f);
generalPath.curveTo(39.19278f, 22.71759f, 38.3522f, 22.7006f, 37.65683f, 22.12316f);
generalPath.lineTo(30.563078f, 15.87316f);
generalPath.curveTo(29.877579f, 15.18766f, 28.882849f, 15.30128f, 28.094328f, 15.87316f);
generalPath.curveTo(25.477818f, 17.85175f, 23.859009f, 19.22666f, 21.531828f, 21.52941f);
generalPath.curveTo(19.229088f, 23.85659f, 17.854168f, 25.47539f, 15.875578f, 28.09191f);
generalPath.curveTo(15.303698f, 28.88043f, 15.190078f, 29.87516f, 15.875578f, 30.56066f);
generalPath.lineTo(22.125578f, 37.65441f);
generalPath.curveTo(22.599298f, 38.22489f, 22.861778f, 38.96326f, 22.594328f, 39.49816f);
generalPath.lineTo(22.531828f, 39.62316f);
generalPath.curveTo(20.286308f, 43.42276f, 18.536968f, 47.559475f, 17.406828f, 51.935665f);
generalPath.curveTo(17.394987f, 51.956303f, 17.388159f, 51.977825f, 17.375578f, 51.998165f);
generalPath.curveTo(17.058369f, 52.511005f, 16.520187f, 52.92975f, 15.781828f, 52.998165f);
generalPath.lineTo(6.344328f, 53.591915f);
generalPath.curveTo(5.3748875f, 53.591915f, 4.7475176f, 54.379967f, 4.5943274f, 55.341915f);
generalPath.curveTo(4.1432476f, 58.59115f, 3.9866076f, 60.69306f, 3.9693277f, 63.966915f);
generalPath.curveTo(3.9866076f, 67.24077f, 4.1432476f, 69.34268f, 4.5943274f, 72.59192f);
generalPath.curveTo(4.7475176f, 73.55386f, 5.3748875f, 74.34192f, 6.344328f, 74.34192f);
generalPath.lineTo(15.781828f, 74.93567f);
generalPath.curveTo(16.649178f, 75.01604f, 17.225267f, 75.58223f, 17.500578f, 76.21692f);
generalPath.curveTo(18.603807f, 80.36027f, 20.266829f, 84.28112f, 22.375578f, 87.90442f);
generalPath.curveTo(22.748499f, 88.57292f, 22.757208f, 89.51878f, 22.125578f, 90.27942f);
generalPath.lineTo(15.875578f, 97.37317f);
generalPath.curveTo(15.190078f, 98.05866f, 15.303698f, 99.05339f, 15.875578f, 99.84192f);
generalPath.curveTo(17.854168f, 102.45843f, 19.229088f, 104.07723f, 21.531828f, 106.40442f);
generalPath.curveTo(23.859009f, 108.70716f, 25.477808f, 110.08208f, 28.094328f, 112.06067f);
generalPath.curveTo(28.882849f, 112.63255f, 29.877579f, 112.74617f, 30.563078f, 112.06067f);
generalPath.lineTo(37.65683f, 105.81067f);
generalPath.curveTo(38.41747f, 105.17904f, 39.36332f, 105.18775f, 40.03183f, 105.56067f);
generalPath.lineTo(40.12558f, 105.46692f);
generalPath.curveTo(43.653236f, 107.48409f, 47.45377f, 109.07644f, 51.46933f, 110.15442f);
generalPath.lineTo(51.46933f, 110.31067f);
generalPath.curveTo(52.205727f, 110.51968f, 52.90936f, 111.16994f, 53.00058f, 112.15442f);
generalPath.lineTo(53.59433f, 121.59192f);
generalPath.curveTo(53.59433f, 122.56136f, 54.382378f, 123.18873f, 55.34433f, 123.34192f);
generalPath.curveTo(58.59356f, 123.793f, 60.695477f, 123.94964f, 63.96933f, 123.96692f);
generalPath.curveTo(67.24318f, 123.94964f, 69.3451f, 123.793f, 72.59433f, 123.34192f);
generalPath.curveTo(73.55628f, 123.18873f, 74.34433f, 122.56136f, 74.34433f, 121.59192f);
generalPath.lineTo(74.93808f, 112.15442f);
generalPath.curveTo(75.0293f, 111.16994f, 75.732925f, 110.51968f, 76.46933f, 110.31067f);
generalPath.lineTo(76.46933f, 110.15442f);
generalPath.curveTo(80.484886f, 109.07644f, 84.28543f, 107.48409f, 87.81308f, 105.46692f);
generalPath.lineTo(87.90683f, 105.56067f);
generalPath.curveTo(88.57534f, 105.18775f, 89.52119f, 105.17904f, 90.28183f, 105.81067f);
generalPath.lineTo(97.37558f, 112.06067f);
generalPath.curveTo(98.06108f, 112.74618f, 99.05582f, 112.63256f, 99.84433f, 112.06067f);
generalPath.curveTo(102.46084f, 110.08208f, 104.07964f, 108.70716f, 106.40683f, 106.40442f);
generalPath.curveTo(108.70957f, 104.07723f, 110.08449f, 102.45843f, 112.06308f, 99.84192f);
generalPath.curveTo(112.63497f, 99.0534f, 112.74859f, 98.05867f, 112.06308f, 97.37317f);
generalPath.lineTo(105.81308f, 90.27942f);
generalPath.curveTo(105.18145f, 89.518776f, 105.19016f, 88.57292f, 105.56308f, 87.90442f);
generalPath.curveTo(107.67183f, 84.28112f, 109.33485f, 80.36027f, 110.43808f, 76.21692f);
generalPath.curveTo(110.71339f, 75.58223f, 111.28948f, 75.01604f, 112.15683f, 74.93567f);
generalPath.lineTo(121.59433f, 74.34192f);
generalPath.curveTo(122.56378f, 74.34192f, 123.19115f, 73.55386f, 123.34433f, 72.59192f);
generalPath.curveTo(123.79541f, 69.34268f, 123.95205f, 67.24077f, 123.96933f, 63.966915f);
generalPath.curveTo(123.95205f, 60.69306f, 123.79541f, 58.59115f, 123.34433f, 55.341915f);
generalPath.curveTo(123.19115f, 54.379967f, 122.56378f, 53.591915f, 121.59433f, 53.591915f);
generalPath.lineTo(112.15683f, 52.998165f);
generalPath.curveTo(111.41847f, 52.92975f, 110.88029f, 52.511005f, 110.56308f, 51.998165f);
generalPath.curveTo(110.55745f, 51.976242f, 110.53749f, 51.957577f, 110.53183f, 51.935665f);
generalPath.curveTo(109.40169f, 47.559475f, 107.38062f, 43.570755f, 105.40683f, 39.62316f);
generalPath.lineTo(105.34433f, 39.49816f);
generalPath.curveTo(105.07688f, 38.96326f, 105.33936f, 38.22489f, 105.81308f, 37.65441f);
generalPath.lineTo(112.06308f, 30.56066f);
generalPath.curveTo(112.74859f, 29.87515f, 112.63496f, 28.88043f, 112.06308f, 28.09191f);
generalPath.curveTo(110.08449f, 25.47539f, 108.70957f, 23.85659f, 106.40683f, 21.52941f);
generalPath.curveTo(104.07965f, 19.22666f, 102.46085f, 17.85175f, 99.84433f, 15.87316f);
generalPath.curveTo(99.05581f, 15.30128f, 98.06109f, 15.18765f, 97.37558f, 15.87316f);
generalPath.lineTo(90.28183f, 22.12316f);
generalPath.curveTo(89.58645f, 22.7006f, 88.74588f, 22.71759f, 88.09433f, 22.43566f);
generalPath.curveTo(84.492256f, 20.34526f, 80.58617f, 18.72833f, 76.46933f, 17.62316f);
generalPath.curveTo(76.447426f, 17.61694f, 76.42866f, 17.59891f, 76.40683f, 17.59191f);
generalPath.curveTo(75.69472f, 17.36374f, 75.02659f, 16.7346f, 74.93808f, 15.77941f);
generalPath.lineTo(74.34433f, 6.34191f);
generalPath.curveTo(74.34433f, 5.37246f, 73.55628f, 4.74509f, 72.59433f, 4.59191f);
generalPath.curveTo(69.3451f, 4.14083f, 67.24318f, 3.98419f, 63.96933f, 3.96691f);
generalPath.closePath();
generalPath.moveTo(63.96933f, 47.966915f);
generalPath.curveTo(72.80133f, 47.966915f, 79.96933f, 55.134914f, 79.96933f, 63.966915f);
generalPath.curveTo(79.96933f, 72.79892f, 72.80133f, 79.96692f, 63.96933f, 79.96692f);
generalPath.curveTo(55.13733f, 79.96692f, 47.96933f, 72.79892f, 47.96933f, 63.966915f);
generalPath.curveTo(47.96933f, 55.134914f, 55.13733f, 47.966915f, 63.96933f, 47.966915f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.732342f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_8
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(15.486342f, 28.9375f);
generalPath.curveTo(15.326382f, 29.522915f, 15.430352f, 30.13151f, 15.892592f, 30.59375f);
generalPath.lineTo(22.142591f, 37.6875f);
generalPath.curveTo(22.356312f, 37.944874f, 22.512882f, 38.239635f, 22.611341f, 38.53125f);
generalPath.curveTo(22.878792f, 37.99635f, 22.616312f, 37.25798f, 22.142591f, 36.6875f);
generalPath.lineTo(15.892592f, 29.59375f);
generalPath.curveTo(15.695272f, 29.396433f, 15.559372f, 29.173765f, 15.486342f, 28.9375f);
generalPath.closePath();
generalPath.moveTo(112.45509f, 28.9375f);
generalPath.curveTo(112.38207f, 29.173767f, 112.27741f, 29.39643f, 112.08009f, 29.59375f);
generalPath.lineTo(105.83009f, 36.6875f);
generalPath.curveTo(105.36419f, 37.24856f, 105.11543f, 37.967422f, 105.36134f, 38.5f);
generalPath.curveTo(105.46142f, 38.220512f, 105.62522f, 37.934223f, 105.83009f, 37.6875f);
generalPath.lineTo(112.08009f, 30.59375f);
generalPath.curveTo(112.54234f, 30.131502f, 112.61506f, 29.522913f, 112.45509f, 28.9375f);
generalPath.closePath();
generalPath.moveTo(63.986343f, 47.0f);
generalPath.curveTo(55.154343f, 47.0f, 47.98634f, 54.168f, 47.986343f, 63.0f);
generalPath.curveTo(47.986343f, 63.170002f, 48.01232f, 63.33127f, 48.017593f, 63.5f);
generalPath.curveTo(48.286224f, 54.90283f, 55.324345f, 48.0f, 63.986343f, 48.0f);
generalPath.curveTo(72.648445f, 48.0f, 79.68663f, 54.902676f, 79.95509f, 63.5f);
generalPath.curveTo(79.96036f, 63.33138f, 79.98634f, 63.16989f, 79.98634f, 63.0f);
generalPath.curveTo(79.98634f, 54.168f, 72.81834f, 47.0f, 63.986343f, 47.0f);
generalPath.closePath();
generalPath.moveTo(123.98634f, 63.5f);
generalPath.curveTo(123.95514f, 66.47986f, 123.78772f, 68.55367f, 123.36134f, 71.625f);
generalPath.curveTo(123.20816f, 72.586945f, 122.58079f, 73.375f, 121.61134f, 73.375f);
generalPath.lineTo(112.17384f, 73.96875f);
generalPath.curveTo(111.30649f, 74.04912f, 110.7304f, 74.61532f, 110.45509f, 75.25f);
generalPath.curveTo(109.35186f, 79.39336f, 107.68884f, 83.31421f, 105.58009f, 86.9375f);
generalPath.curveTo(105.34274f, 87.36298f, 105.23242f, 87.90658f, 105.36134f, 88.4375f);
generalPath.curveTo(105.40513f, 88.2537f, 105.49155f, 88.09622f, 105.58009f, 87.9375f);
generalPath.curveTo(107.68884f, 84.31421f, 109.35186f, 80.39336f, 110.45509f, 76.25f);
generalPath.curveTo(110.7304f, 75.61532f, 111.30649f, 75.04912f, 112.17384f, 74.96875f);
generalPath.lineTo(121.61134f, 74.375f);
generalPath.curveTo(122.58079f, 74.375f, 123.20816f, 73.586945f, 123.36134f, 72.625f);
generalPath.curveTo(123.81242f, 69.37577f, 123.96906f, 67.27386f, 123.98634f, 64.0f);
generalPath.curveTo(123.9854f, 63.820744f, 123.98815f, 63.672607f, 123.98634f, 63.5f);
generalPath.closePath();
generalPath.moveTo(4.017592f, 65.28125f);
generalPath.curveTo(4.0687222f, 67.85174f, 4.2236123f, 69.83206f, 4.611342f, 72.625f);
generalPath.curveTo(4.764532f, 73.586945f, 5.391902f, 74.375f, 6.361342f, 74.375f);
generalPath.lineTo(15.798842f, 74.96875f);
generalPath.curveTo(16.666191f, 75.04912f, 17.242283f, 75.61532f, 17.517591f, 76.25f);
generalPath.curveTo(18.620823f, 80.39336f, 20.283842f, 84.31421f, 22.392591f, 87.9375f);
generalPath.curveTo(22.480942f, 88.09589f, 22.536303f, 88.25413f, 22.580091f, 88.4375f);
generalPath.curveTo(22.709011f, 87.90658f, 22.629942f, 87.36298f, 22.392591f, 86.9375f);
generalPath.curveTo(20.283842f, 83.31421f, 18.620823f, 79.39336f, 17.517591f, 75.25f);
generalPath.curveTo(17.242283f, 74.61532f, 16.666191f, 74.04912f, 15.798842f, 73.96875f);
generalPath.lineTo(6.361342f, 73.375f);
generalPath.curveTo(5.391902f, 73.375f, 4.764532f, 72.586945f, 4.611342f, 71.625f);
generalPath.curveTo(4.273032f, 69.18808f, 4.090082f, 67.405876f, 4.017592f, 65.28125f);
generalPath.closePath();
generalPath.moveTo(15.486342f, 98.0625f);
generalPath.curveTo(15.305672f, 98.64705f, 15.485322f, 99.31345f, 15.892592f, 99.875f);
generalPath.curveTo(17.871181f, 102.49151f, 19.246101f, 104.11031f, 21.548841f, 106.4375f);
generalPath.curveTo(23.876022f, 108.74024f, 25.494822f, 110.11516f, 28.111341f, 112.09375f);
generalPath.curveTo(28.89986f, 112.66563f, 29.894592f, 112.77925f, 30.580091f, 112.09375f);
generalPath.lineTo(37.673843f, 105.84375f);
generalPath.curveTo(38.43448f, 105.21212f, 39.380333f, 105.22083f, 40.048843f, 105.59375f);
generalPath.lineTo(40.142593f, 105.5f);
generalPath.curveTo(43.67025f, 107.51717f, 47.470783f, 109.10952f, 51.486343f, 110.1875f);
generalPath.lineTo(51.486343f, 110.34375f);
generalPath.curveTo(52.22274f, 110.55276f, 52.926373f, 111.20302f, 53.017593f, 112.1875f);
generalPath.lineTo(53.611343f, 121.625f);
generalPath.curveTo(53.61134f, 122.59444f, 54.39939f, 123.22181f, 55.361343f, 123.375f);
generalPath.curveTo(58.61057f, 123.82608f, 60.712494f, 123.98272f, 63.986343f, 124.0f);
generalPath.curveTo(67.26019f, 123.98272f, 69.362114f, 123.82608f, 72.61134f, 123.375f);
generalPath.curveTo(73.57329f, 123.22181f, 74.36134f, 122.59444f, 74.36134f, 121.625f);
generalPath.lineTo(74.95509f, 112.1875f);
generalPath.curveTo(75.04631f, 111.20302f, 75.74995f, 110.55276f, 76.48634f, 110.34375f);
generalPath.lineTo(76.48634f, 110.1875f);
generalPath.curveTo(80.5019f, 109.10952f, 84.302444f, 107.51717f, 87.83009f, 105.5f);
generalPath.lineTo(87.92384f, 105.59375f);
generalPath.curveTo(88.59235f, 105.22083f, 89.5382f, 105.21212f, 90.29884f, 105.84375f);
generalPath.lineTo(97.39259f, 112.09375f);
generalPath.curveTo(98.078094f, 112.77926f, 99.07283f, 112.66564f, 99.86134f, 112.09375f);
generalPath.curveTo(102.47785f, 110.11516f, 104.09665f, 108.74024f, 106.42384f, 106.4375f);
generalPath.curveTo(108.72658f, 104.11031f, 110.1015f, 102.49151f, 112.08009f, 99.875f);
generalPath.curveTo(112.48737f, 99.31346f, 112.63577f, 98.64705f, 112.45509f, 98.0625f);
generalPath.curveTo(112.37783f, 98.34525f, 112.26635f, 98.618195f, 112.08009f, 98.875f);
generalPath.curveTo(110.1015f, 101.49151f, 108.72658f, 103.11031f, 106.42384f, 105.4375f);
generalPath.curveTo(104.09665f, 107.74024f, 102.47785f, 109.11516f, 99.86134f, 111.09375f);
generalPath.curveTo(99.07283f, 111.66564f, 98.078094f, 111.77926f, 97.39259f, 111.09375f);
generalPath.lineTo(90.29884f, 104.84375f);
generalPath.curveTo(89.5382f, 104.21212f, 88.59235f, 104.22083f, 87.92384f, 104.59375f);
generalPath.lineTo(87.83009f, 104.5f);
generalPath.curveTo(84.302444f, 106.51717f, 80.5019f, 108.10952f, 76.48634f, 109.1875f);
generalPath.lineTo(76.48634f, 109.34375f);
generalPath.curveTo(75.74995f, 109.55276f, 75.04631f, 110.20302f, 74.95509f, 111.1875f);
generalPath.lineTo(74.36134f, 120.625f);
generalPath.curveTo(74.36134f, 121.59444f, 73.57329f, 122.22181f, 72.61134f, 122.375f);
generalPath.curveTo(69.362114f, 122.82608f, 67.26019f, 122.98272f, 63.986343f, 123.0f);
generalPath.curveTo(60.712494f, 122.98272f, 58.61057f, 122.82608f, 55.361343f, 122.375f);
generalPath.curveTo(54.39939f, 122.22181f, 53.61134f, 121.59444f, 53.611343f, 120.625f);
generalPath.lineTo(53.017593f, 111.1875f);
generalPath.curveTo(52.926373f, 110.20302f, 52.22274f, 109.55276f, 51.486343f, 109.34375f);
generalPath.lineTo(51.486343f, 109.1875f);
generalPath.curveTo(47.470783f, 108.10952f, 43.67025f, 106.51717f, 40.142593f, 104.5f);
generalPath.lineTo(40.048843f, 104.59375f);
generalPath.curveTo(39.380333f, 104.22083f, 38.43448f, 104.21212f, 37.673843f, 104.84375f);
generalPath.lineTo(30.580091f, 111.09375f);
generalPath.curveTo(29.894592f, 111.77925f, 28.89986f, 111.66563f, 28.111341f, 111.09375f);
generalPath.curveTo(25.494822f, 109.11516f, 23.876022f, 107.74024f, 21.548841f, 105.4375f);
generalPath.curveTo(19.246101f, 103.11031f, 17.871181f, 101.49151f, 15.892592f, 98.875f);
generalPath.curveTo(15.706342f, 98.61819f, 15.563602f, 98.34525f, 15.486342f, 98.0625f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_9
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(55.234188f, 4.1094074f);
generalPath.curveTo(59.793056f, 3.6731615f, 67.427f, 3.5064633f, 72.17794f, 4.0736613f);
generalPath.curveTo(74.083694f, 4.301182f, 74.71593f, 6.9512396f, 74.32272f, 11.437402f);
generalPath.curveTo(74.29547f, 11.748351f, 73.75078f, 5.476704f, 71.82048f, 5.3962746f);
generalPath.curveTo(67.14967f, 5.201658f, 60.140186f, 4.9297585f, 55.591652f, 5.3962746f);
generalPath.curveTo(54.54607f, 5.503514f, 53.630116f, 7.5889506f, 53.625607f, 7.255083f);
generalPath.curveTo(53.60773f, 5.8609767f, 53.379456f, 4.28689f, 55.234188f, 4.1094074f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(62.93699264526367, 3.849597692489624), new Point2D.Double(63.020755767822266, 9.852097511291504), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -0.02961321547627449f, -0.45856890082359314f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.8999689817428589f, 0.4359537959098816f, -0.4359537959098816f, 0.8999689817428589f, 8.657451629638672f, -23.806880950927734f));
// _0_10
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(55.962086f, 6.8499207f);
generalPath.curveTo(55.964153f, 7.728483f, 55.718903f, 8.541995f, 55.319206f, 8.982414f);
generalPath.curveTo(54.919506f, 9.422833f, 54.426464f, 9.422833f, 54.026764f, 8.982414f);
generalPath.curveTo(53.627068f, 8.541995f, 53.381817f, 7.728483f, 53.383884f, 6.8499207f);
generalPath.curveTo(53.381817f, 5.9713583f, 53.627068f, 5.1578465f, 54.026764f, 4.7174273f);
generalPath.curveTo(54.426464f, 4.2770076f, 54.919506f, 4.2770076f, 55.319206f, 4.7174273f);
generalPath.curveTo(55.718903f, 5.1578465f, 55.964153f, 5.9713583f, 55.962086f, 6.8499207f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(54.6729850769043, 6.849920749664307), 1.2890996f, new Point2D.Double(54.045623779296875, 6.341433048248291), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 202),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.901960849761963f, 0.0f, -6.178359508514404f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-0.8999689817428589f, 0.4359537959098816f, 0.4359537959098816f, 0.8999689817428589f, 119.08978271484375f, -23.806880950927734f));
// _0_11
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(55.962086f, 6.8499207f);
generalPath.curveTo(55.964153f, 7.728483f, 55.718903f, 8.541995f, 55.319206f, 8.982414f);
generalPath.curveTo(54.919506f, 9.422833f, 54.426464f, 9.422833f, 54.026764f, 8.982414f);
generalPath.curveTo(53.627068f, 8.541995f, 53.381817f, 7.728483f, 53.383884f, 6.8499207f);
generalPath.curveTo(53.381817f, 5.9713583f, 53.627068f, 5.1578465f, 54.026764f, 4.7174273f);
generalPath.curveTo(54.426464f, 4.2770076f, 54.919506f, 4.2770076f, 55.319206f, 4.7174273f);
generalPath.curveTo(55.718903f, 5.1578465f, 55.964153f, 5.9713583f, 55.962086f, 6.8499207f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(54.6729850769043, 6.849920749664307), 1.2890996f, new Point2D.Double(54.045623779296875, 6.341433048248291), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 202),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.901960849761963f, 0.0f, -6.178359508514404f));
g.setPaint(paint);
g.fill(shape);

}

private void _paint1(Graphics2D g,float origAlpha) {
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_12
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(51.36177f, 18.300158f);
generalPath.curveTo(47.31399f, 19.538267f, 43.50271f, 21.010153f, 39.835705f, 23.2002f);
generalPath.curveTo(38.838726f, 23.56376f, 38.239384f, 23.203632f, 37.409164f, 22.69467f);
generalPath.lineTo(30.533964f, 16.58136f);
generalPath.curveTo(30.10065f, 16.223139f, 29.032452f, 15.656721f, 28.20853f, 16.379147f);
generalPath.curveTo(23.636724f, 20.338825f, 19.992825f, 24.584011f, 15.974724f, 28.71406f);
generalPath.lineTo(17.464573f, 27.925114f);
generalPath.curveTo(21.036922f, 24.466658f, 24.476221f, 20.963852f, 28.309637f, 17.592417f);
generalPath.curveTo(28.879576f, 17.120342f, 29.732199f, 17.301563f, 30.230648f, 17.794628f);
generalPath.lineTo(36.814793f, 23.59849f);
generalPath.curveTo(37.82083f, 24.58216f, 39.10522f, 24.977955f, 40.442337f, 24.514574f);
generalPath.curveTo(44.08716f, 22.164406f, 47.91375f, 20.535238f, 51.939842f, 18.94762f);
generalPath.curveTo(52.785282f, 18.599047f, 53.455727f, 17.2475f, 53.342533f, 16.140137f);
generalPath.curveTo(53.225178f, 16.85456f, 52.34317f, 17.987135f, 51.36177f, 18.300158f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(43.713863372802734, 11.362190246582031), new Point2D.Double(18.25215721130371, 21.728620529174805), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 128),new Color(255, 255, 255, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.1622810959815979f, 0.9867445826530457f, -0.9672338366508484f, 0.2538870871067047f, 0.0f, 0.0f));
// _0_13
shape = new Ellipse2D.Double(22.194091796875, -28.39023780822754, 3.231895923614502, 4.963741779327393);
paint = new RadialGradientPaint(new Point2D.Double(54.6729850769043, 6.849920749664307), 1.2890996f, new Point2D.Double(54.045623779296875, 6.341433048248291), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 202),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.2535477876663208f, 0.0f, 0.0f, 1.9252748489379883f, -44.725162506103516f, -39.09634780883789f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-1.0f, 0.0f, 0.0f, 1.0f, 128.3755645751953f, 0.0f));
// _0_14
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(51.36177f, 18.300158f);
generalPath.curveTo(47.31399f, 19.538267f, 43.50271f, 21.010153f, 39.835705f, 23.2002f);
generalPath.curveTo(38.838726f, 23.56376f, 38.668343f, 22.703184f, 37.83812f, 22.194221f);
generalPath.lineTo(30.962921f, 16.080912f);
generalPath.curveTo(30.529608f, 15.72269f, 29.032452f, 15.656721f, 28.20853f, 16.379147f);
generalPath.curveTo(22.994884f, 19.696983f, 19.49462f, 24.085808f, 15.974724f, 28.71406f);
generalPath.lineTo(17.464573f, 27.925114f);
generalPath.curveTo(19.948132f, 25.060545f, 23.468546f, 21.513493f, 28.309637f, 17.592417f);
generalPath.curveTo(28.879576f, 17.120342f, 30.161154f, 16.801115f, 30.659603f, 17.294182f);
generalPath.lineTo(37.24375f, 23.098042f);
generalPath.curveTo(38.249786f, 24.081713f, 39.10522f, 24.977955f, 40.442337f, 24.514574f);
generalPath.curveTo(44.08716f, 22.164406f, 47.91375f, 20.535238f, 51.939842f, 18.94762f);
generalPath.curveTo(52.785282f, 18.599047f, 53.455727f, 17.2475f, 53.342533f, 16.140137f);
generalPath.curveTo(53.225178f, 16.85456f, 52.34317f, 17.987135f, 51.36177f, 18.300158f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(52.7219352722168, 17.796527862548828), new Point2D.Double(38.627559661865234, 22.658023834228516), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 128),new Color(255, 255, 255, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-0.1622810959815979f, 0.9867445826530457f, 0.9672338962554932f, 0.2538870871067047f, 0.0f, 0.0f));
// _0_15
shape = new Ellipse2D.Double(-10.542396545410156, 98.84172058105469, 3.231895923614502, 4.963741779327393);
paint = new RadialGradientPaint(new Point2D.Double(54.6729850769043, 6.849920749664307), 1.2890996f, new Point2D.Double(54.045623779296875, 6.341433048248291), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 202),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.2535477876663208f, 0.0f, 0.0f, 1.9252748489379883f, -77.4616470336914f, 88.13561248779297f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.31970257f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-0.9946902990341187f, -0.48122918605804443f, -0.35745060443878174f, 0.9612933993339539f, 168.32566833496094f, 49.77916717529297f));
// _0_16
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(55.962086f, 6.8499207f);
generalPath.curveTo(55.964153f, 7.728483f, 55.718903f, 8.541995f, 55.319206f, 8.982414f);
generalPath.curveTo(54.919506f, 9.422833f, 54.426464f, 9.422833f, 54.026764f, 8.982414f);
generalPath.curveTo(53.627068f, 8.541995f, 53.381817f, 7.728483f, 53.383884f, 6.8499207f);
generalPath.curveTo(53.381817f, 5.9713583f, 53.627068f, 5.1578465f, 54.026764f, 4.7174273f);
generalPath.curveTo(54.426464f, 4.2770076f, 54.919506f, 4.2770076f, 55.319206f, 4.7174273f);
generalPath.curveTo(55.718903f, 5.1578465f, 55.964153f, 5.9713583f, 55.962086f, 6.8499207f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(54.6729850769043, 6.849920749664307), 1.2890996f, new Point2D.Double(54.6729850769043, 6.849920749664307), new float[] {0.0f,1.0f}, new Color[] {new Color(71, 71, 71, 255),new Color(71, 71, 71, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.901960849761963f, 0.0f, -6.178359508514404f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.31970257f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9946902990341187f, -0.48122918605804443f, 0.35745060443878174f, 0.9612933993339539f, -39.94389724731445f, 50.08248519897461f));
// _0_17
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(55.962086f, 6.8499207f);
generalPath.curveTo(55.964153f, 7.728483f, 55.718903f, 8.541995f, 55.319206f, 8.982414f);
generalPath.curveTo(54.919506f, 9.422833f, 54.426464f, 9.422833f, 54.026764f, 8.982414f);
generalPath.curveTo(53.627068f, 8.541995f, 53.381817f, 7.728483f, 53.383884f, 6.8499207f);
generalPath.curveTo(53.381817f, 5.9713583f, 53.627068f, 5.1578465f, 54.026764f, 4.7174273f);
generalPath.curveTo(54.426464f, 4.2770076f, 54.919506f, 4.2770076f, 55.319206f, 4.7174273f);
generalPath.curveTo(55.718903f, 5.1578465f, 55.964153f, 5.9713583f, 55.962086f, 6.8499207f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(54.6729850769043, 6.849920749664307), 1.2890996f, new Point2D.Double(54.6729850769043, 6.849920749664307), new float[] {0.0f,1.0f}, new Color[] {new Color(71, 71, 71, 255),new Color(71, 71, 71, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.901960849761963f, 0.0f, -6.178359508514404f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_18
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(109.72078f, 50.19651f);
generalPath.curveTo(109.90912f, 50.93316f, 109.69575f, 52.31158f, 110.19226f, 53.441452f);
generalPath.curveTo(110.48274f, 54.10247f, 110.88736f, 54.526817f, 111.41864f, 54.546604f);
generalPath.curveTo(116.20582f, 54.724865f, 118.36563f, 54.681114f, 121.52923f, 54.900475f);
generalPath.curveTo(122.00058f, 54.933155f, 122.58757f, 55.2264f, 122.81784f, 56.141216f);
generalPath.curveTo(123.23273f, 57.78946f, 123.16843f, 61.128777f, 123.60189f, 62.7109f);
generalPath.curveTo(124.3426f, 65.54627f, 123.89819f, 57.90543f, 123.55134f, 55.608215f);
generalPath.curveTo(123.26906f, 54.022186f, 122.5811f, 53.327606f, 121.73144f, 53.28278f);
generalPath.curveTo(118.36035f, 53.104927f, 114.984f, 53.21817f, 111.31754f, 53.08057f);
generalPath.curveTo(111.06358f, 53.114285f, 110.78853f, 52.816723f, 110.53609f, 52.38652f);
generalPath.curveTo(110.086f, 51.619465f, 110.11888f, 50.53797f, 109.72078f, 50.19651f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(114.29630279541016, 49.93735122680664), new Point2D.Double(114.29630279541016, 61.87738800048828), new float[] {0.0f,0.32512316f,1.0f}, new Color[] {new Color(255, 255, 255, 0),new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-1.0f, 0.0f, 0.0f, 1.0f, 128.270263671875f, 0.699999988079071f));
// _0_19
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(109.72078f, 49.69651f);
generalPath.curveTo(109.90912f, 50.43316f, 109.69575f, 51.81158f, 110.19226f, 52.941452f);
generalPath.curveTo(110.48274f, 53.60247f, 110.88736f, 54.026817f, 111.41864f, 54.046604f);
generalPath.curveTo(116.20582f, 54.224865f, 118.36563f, 54.681114f, 121.52923f, 54.900475f);
generalPath.curveTo(122.00058f, 54.933155f, 122.58757f, 55.2264f, 122.81784f, 56.141216f);
generalPath.curveTo(123.23273f, 57.78946f, 123.16843f, 61.128777f, 123.60189f, 62.7109f);
generalPath.curveTo(124.3426f, 65.54627f, 123.89819f, 57.90543f, 123.55134f, 55.608215f);
generalPath.curveTo(123.26906f, 54.022186f, 122.5811f, 53.327606f, 121.73144f, 53.28278f);
generalPath.curveTo(118.36035f, 53.104927f, 114.984f, 52.71817f, 111.31754f, 52.58057f);
generalPath.curveTo(111.06358f, 52.614285f, 110.78853f, 52.316723f, 110.53609f, 51.88652f);
generalPath.curveTo(110.086f, 51.119465f, 110.11888f, 50.03797f, 109.72078f, 49.69651f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(114.29630279541016, 49.93735122680664), new Point2D.Double(114.29630279541016, 61.87738800048828), new float[] {0.0f,0.32512316f,1.0f}, new Color[] {new Color(255, 255, 255, 0),new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.87360597f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_20
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(48.310017f, 64.19113f);
generalPath.curveTo(48.305267f, 64.34987f, 48.262848f, 64.50293f, 48.262848f, 64.66281f);
generalPath.curveTo(48.262848f, 73.33933f, 55.340282f, 80.3696f, 64.01681f, 80.3696f);
generalPath.curveTo(72.69333f, 80.3696f, 79.7236f, 73.33934f, 79.723595f, 64.66281f);
generalPath.curveTo(79.723595f, 64.50293f, 79.681175f, 64.34987f, 79.67643f, 64.19113f);
generalPath.curveTo(79.44806f, 72.66885f, 72.54935f, 79.47342f, 64.01681f, 79.47342f);
generalPath.curveTo(55.484264f, 79.47342f, 48.538387f, 72.66885f, 48.310017f, 64.19113f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(63.993221282958984, 80.36959838867188), new Point2D.Double(63.993221282958984, 66.13199615478516), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.87360597f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_21
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(79.67643f, 63.99045f);
generalPath.curveTo(79.681175f, 63.831715f, 79.723595f, 63.678658f, 79.723595f, 63.518776f);
generalPath.curveTo(79.723595f, 54.84225f, 72.646164f, 47.811985f, 63.96964f, 47.811985f);
generalPath.curveTo(55.293114f, 47.811985f, 48.262844f, 54.84225f, 48.262848f, 63.518776f);
generalPath.curveTo(48.262848f, 63.678658f, 48.305267f, 63.831715f, 48.310017f, 63.99045f);
generalPath.curveTo(48.538383f, 55.512733f, 55.4371f, 48.708168f, 63.96964f, 48.708168f);
generalPath.curveTo(72.50218f, 48.708168f, 79.44806f, 55.512733f, 79.67643f, 63.99045f);
generalPath.closePath();
shape = generalPath;
paint = new Color(86, 86, 86, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.87360597f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_22
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(80.264496f, 64.29709f);
generalPath.curveTo(80.26942f, 64.1324f, 80.31343f, 63.973602f, 80.31343f, 63.807724f);
generalPath.curveTo(80.31343f, 54.805862f, 72.97062f, 47.511986f, 63.968754f, 47.511986f);
generalPath.curveTo(54.966892f, 47.511986f, 47.67301f, 54.80586f, 47.673016f, 63.807724f);
generalPath.curveTo(47.673016f, 63.973602f, 47.717026f, 64.1324f, 47.72195f, 64.29709f);
generalPath.curveTo(47.95888f, 55.501484f, 55.116276f, 48.026775f, 63.968754f, 48.026775f);
generalPath.curveTo(72.821236f, 48.026775f, 80.02756f, 55.501484f, 80.264496f, 64.29709f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.3457249f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_23
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(48.310017f, 64.19113f);
generalPath.curveTo(48.305267f, 64.34987f, 48.262848f, 64.50293f, 48.262848f, 64.66281f);
generalPath.curveTo(48.262848f, 73.33933f, 55.340282f, 81.3696f, 64.01681f, 81.3696f);
generalPath.curveTo(72.69333f, 81.3696f, 79.7236f, 73.33934f, 79.723595f, 64.66281f);
generalPath.curveTo(79.723595f, 64.50293f, 79.681175f, 64.34987f, 79.67643f, 64.19113f);
generalPath.curveTo(79.44806f, 72.66885f, 72.54935f, 79.47342f, 64.01681f, 79.47342f);
generalPath.curveTo(55.484264f, 79.47342f, 48.538387f, 72.66885f, 48.310017f, 64.19113f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(63.993221282958984, 80.36959838867188), new Point2D.Double(63.993221282958984, 66.13199615478516), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_24
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(112.31492f, 97.9016f);
generalPath.curveTo(112.36723f, 98.459206f, 112.1884f, 98.93976f, 111.95746f, 99.40295f);
generalPath.lineTo(108.5973f, 103.764f);
generalPath.lineTo(111.67149f, 99.40295f);
generalPath.curveTo(111.53652f, 98.88657f, 111.48142f, 98.33027f, 111.17104f, 97.9016f);
generalPath.curveTo(109.38533f, 95.70095f, 107.11057f, 93.58181f, 106.09506f, 91.25279f);
generalPath.lineTo(112.31492f, 97.9016f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-1.0f, 0.0f, 0.0f, 1.0f, 128.4191436767578f, 0.0f));
// _0_25
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(112.31492f, 97.9016f);
generalPath.curveTo(112.36723f, 98.459206f, 112.1884f, 98.93976f, 111.95746f, 99.40295f);
generalPath.lineTo(108.5973f, 103.764f);
generalPath.lineTo(111.67149f, 99.40295f);
generalPath.curveTo(111.53652f, 98.88657f, 111.48142f, 98.33027f, 111.17104f, 97.9016f);
generalPath.curveTo(109.38533f, 95.70095f, 107.11057f, 93.58181f, 106.09506f, 91.25279f);
generalPath.lineTo(112.31492f, 97.9016f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.5892133712768555f, 0.0f, 0.0f, 0.5892133712768555f, -119.15695190429688f, -0.12997159361839294f));
// _0_26
paint = new LinearGradientPaint(new Point2D.Double(310.8499450683594, -27.65611457824707), new Point2D.Double(310.8499450683594, 270.1699523925781), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(255, 255, 255, 255),new Color(255, 255, 255, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
stroke = new BasicStroke(1.697178f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(366.04224f, 108.83997f);
generalPath.curveTo(366.13068f, 128.61708f, 355.63046f, 146.92984f, 338.51758f, 156.84402f);
generalPath.curveTo(321.4047f, 166.7582f, 300.29517f, 166.7582f, 283.18228f, 156.84402f);
generalPath.curveTo(266.0694f, 146.92984f, 255.5692f, 128.61708f, 255.65764f, 108.83997f);
generalPath.curveTo(255.5692f, 89.06287f, 266.0694f, 70.7501f, 283.18228f, 60.835926f);
generalPath.curveTo(300.29517f, 50.92175f, 321.4047f, 50.92175f, 338.51758f, 60.835926f);
generalPath.curveTo(355.63046f, 70.7501f, 366.13068f, 89.06287f, 366.04224f, 108.83997f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_27
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(64.0f, 31.46875f);
generalPath.curveTo(46.048935f, 31.46875f, 31.468752f, 46.048935f, 31.46875f, 64.0f);
generalPath.curveTo(31.46875f, 81.951065f, 46.04894f, 96.53126f, 64.0f, 96.53125f);
generalPath.curveTo(81.951065f, 96.53125f, 96.53125f, 81.951065f, 96.53125f, 64.0f);
generalPath.curveTo(96.53125f, 46.048935f, 81.95107f, 31.468752f, 64.0f, 31.46875f);
generalPath.closePath();
generalPath.moveTo(64.0f, 49.40625f);
generalPath.curveTo(72.050644f, 49.40625f, 78.59375f, 55.94936f, 78.59375f, 64.0f);
generalPath.curveTo(78.59375f, 72.050644f, 72.050644f, 78.59375f, 64.0f, 78.59375f);
generalPath.curveTo(55.94936f, 78.59375f, 49.40625f, 72.050644f, 49.40625f, 64.0f);
generalPath.curveTo(49.40625f, 55.94936f, 55.94936f, 49.40625f, 64.0f, 49.40625f);
generalPath.closePath();
shape = generalPath;
paint = new Color(52, 52, 52, 20);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.4144163131713867f, 0.0f, 0.0f, 1.4144163131713867f, -26.682235717773438f, -18.49355697631836f));
// _0_28
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(86.5466f, 58.23697f);
generalPath.curveTo(86.58257f, 66.279884f, 82.31236f, 73.72729f, 75.35293f, 77.75916f);
generalPath.curveTo(68.39349f, 81.79104f, 59.808716f, 81.79104f, 52.849277f, 77.75916f);
generalPath.curveTo(45.88984f, 73.72729f, 41.619637f, 66.279884f, 41.655605f, 58.23697f);
generalPath.curveTo(41.619637f, 50.194054f, 45.88984f, 42.746655f, 52.849277f, 38.714775f);
generalPath.curveTo(59.808716f, 34.6829f, 68.39349f, 34.6829f, 75.35293f, 38.714775f);
generalPath.curveTo(82.31236f, 42.746655f, 86.58257f, 50.194054f, 86.5466f, 58.23697f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(64.10110473632812, 61.470516204833984), 22.686441f, new Point2D.Double(63.29227066040039, 74.81649017333984), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(159, 193, 242, 255),new Color(88, 126, 181, 255),new Color(12, 42, 88, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.7860801219940186f, 1.343549058674398E-7f, -1.2826113504615932E-7f, 0.7504268288612366f, 13.712508201599121f, 14.534377098083496f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.4144163131713867f, 0.0f, 0.0f, 1.4144163131713867f, -26.682235717773438f, -18.49355697631836f));
// _0_29
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(86.5466f, 58.23697f);
generalPath.curveTo(86.58257f, 66.279884f, 82.31236f, 73.72729f, 75.35293f, 77.75916f);
generalPath.curveTo(68.39349f, 81.79104f, 59.808716f, 81.79104f, 52.849277f, 77.75916f);
generalPath.curveTo(45.88984f, 73.72729f, 41.619637f, 66.279884f, 41.655605f, 58.23697f);
generalPath.curveTo(41.619637f, 50.194054f, 45.88984f, 42.746655f, 52.849277f, 38.714775f);
generalPath.curveTo(59.808716f, 34.6829f, 68.39349f, 34.6829f, 75.35293f, 38.714775f);
generalPath.curveTo(82.31236f, 42.746655f, 86.58257f, 50.194054f, 86.5466f, 58.23697f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(64.10110473632812, 61.470516204833984), 22.686441f, new Point2D.Double(76.59712982177734, 74.42935180664062), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(159, 193, 242, 255),new Color(88, 126, 181, 255),new Color(12, 42, 88, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9144973158836365f, 0.0f, 0.0f, 0.8730195164680481f, 5.4808173179626465f, 6.99854850769043f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.4144163131713867f, 0.0f, 0.0f, 1.4144163131713867f, -26.682235717773438f, -18.49355697631836f));
// _0_30
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(86.5466f, 58.23697f);
generalPath.curveTo(86.58257f, 66.279884f, 82.31236f, 73.72729f, 75.35293f, 77.75916f);
generalPath.curveTo(68.39349f, 81.79104f, 59.808716f, 81.79104f, 52.849277f, 77.75916f);
generalPath.curveTo(45.88984f, 73.72729f, 41.619637f, 66.279884f, 41.655605f, 58.23697f);
generalPath.curveTo(41.619637f, 50.194054f, 45.88984f, 42.746655f, 52.849277f, 38.714775f);
generalPath.curveTo(59.808716f, 34.6829f, 68.39349f, 34.6829f, 75.35293f, 38.714775f);
generalPath.curveTo(82.31236f, 42.746655f, 86.58257f, 50.194054f, 86.5466f, 58.23697f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(71.9641342163086, 26.78472137451172), new Point2D.Double(79.39836120605469, 63.9555549621582), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_31
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(56.832214f, 47.33369f);
generalPath.curveTo(53.101917f, 47.479862f, 50.153896f, 50.547718f, 50.156395f, 54.28088f);
generalPath.lineTo(50.156395f, 71.64886f);
generalPath.curveTo(50.16815f, 74.047935f, 51.41679f, 76.27122f, 53.459244f, 77.529816f);
generalPath.curveTo(55.50172f, 78.788414f, 58.048992f, 78.90424f, 60.197254f, 77.8362f);
generalPath.lineTo(77.56523f, 69.15221f);
generalPath.curveTo(79.889626f, 67.96486f, 81.352455f, 65.57496f, 81.352455f, 62.964867f);
generalPath.curveTo(81.352455f, 60.354774f, 79.889626f, 57.964878f, 77.56523f, 56.777527f);
generalPath.lineTo(60.197254f, 48.093536f);
generalPath.curveTo(59.1573f, 47.561386f, 57.999928f, 47.300045f, 56.832214f, 47.33369f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(267.4247741699219, 81.25708770751953), 23.279442f, new Point2D.Double(267.4247741699219, 81.25708770751953), new float[] {0.0f,1.0f}, new Color[] {new Color(215, 215, 215, 255),new Color(255, 255, 255, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.6659365296363831f, -0.07399280369281769f, 0.19014088809490204f, 1.7112705707550049f, -125.67630767822266f, -47.418704986572266f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.6879621148109436f, 0.0f, 0.0f, 0.6879621148109436f, -80.87310791015625f, 16.17249870300293f));
// _0_32
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(200.15625f, 43.880333f);
generalPath.curveTo(194.73401f, 44.092804f, 190.46512f, 48.547672f, 190.46875f, 53.974083f);
generalPath.lineTo(190.46875f, 56.974083f);
generalPath.curveTo(190.46512f, 51.547672f, 194.73401f, 47.092804f, 200.15625f, 46.880333f);
generalPath.curveTo(201.8536f, 46.831432f, 203.55086f, 47.20056f, 205.0625f, 47.974083f);
generalPath.lineTo(230.3125f, 60.599083f);
generalPath.curveTo(233.23871f, 62.093864f, 235.20784f, 64.90962f, 235.6875f, 68.09908f);
generalPath.curveTo(235.76166f, 67.60593f, 235.8125f, 67.10714f, 235.8125f, 66.59908f);
generalPath.curveTo(235.81248f, 62.80514f, 233.69116f, 59.32498f, 230.3125f, 57.599083f);
generalPath.lineTo(205.0625f, 44.974083f);
generalPath.curveTo(203.55086f, 44.20056f, 201.8536f, 43.831432f, 200.15625f, 43.880333f);
generalPath.closePath();
shape = generalPath;
paint = new Color(18, 18, 18, 198);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.6879621148109436f, 0.0f, 0.0f, 0.6879621148109436f, -47.32783508300781f, 16.17249870300293f));
// _0_33
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(186.9375f, 67.53447f);
generalPath.curveTo(186.45778f, 70.72382f, 184.48863f, 73.53973f, 181.5625f, 75.03447f);
generalPath.lineTo(156.3125f, 87.65947f);
generalPath.curveTo(153.18985f, 89.21195f, 149.50012f, 89.05144f, 146.53125f, 87.22197f);
generalPath.curveTo(143.5624f, 85.39251f, 141.73586f, 82.14671f, 141.71875f, 78.65947f);
generalPath.lineTo(141.71875f, 81.65947f);
generalPath.curveTo(141.73586f, 85.14671f, 143.5624f, 88.39251f, 146.53125f, 90.22197f);
generalPath.curveTo(149.50012f, 92.05144f, 153.18985f, 92.21195f, 156.3125f, 90.65947f);
generalPath.lineTo(181.5625f, 78.03447f);
generalPath.curveTo(184.94118f, 76.30857f, 187.0625f, 72.82841f, 187.0625f, 69.03447f);
generalPath.curveTo(187.0625f, 68.52632f, 187.01169f, 68.02771f, 186.9375f, 67.53447f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_34
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(32.663742f, 62.55884f);
generalPath.curveTo(47.790897f, 67.271225f, 79.46524f, 66.662476f, 95.111984f, 58.07128f);
generalPath.lineTo(95.08347f, 57.156357f);
generalPath.curveTo(78.85882f, 65.65774f, 47.897488f, 67.24492f, 32.663742f, 62.55884f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(63.55694580078125, 67.19624328613281), new Point2D.Double(62.23433303833008, 51.36062240600586), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
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
		return 128.0;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 128.0;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private system_run_5() {
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
       system_run_5 base = new system_run_5();
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
       system_run_5 base = new system_run_5();
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
        return system_run_5::new;
    }
}

