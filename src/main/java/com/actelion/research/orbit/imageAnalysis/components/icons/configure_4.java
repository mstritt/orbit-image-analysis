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
public class configure_4 implements ResizableIcon {
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
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(99.787f, 3.875f);
generalPath.curveTo(99.39939f, 3.87647f, 99.02302f, 3.885712f, 98.63075f, 3.90625f);
generalPath.curveTo(98.589645f, 3.908401f, 98.54679f, 3.9038904f, 98.50575f, 3.90625f);
generalPath.curveTo(98.27707f, 3.9193845f, 97.42207f, 3.9611683f, 97.3495f, 3.96875f);
generalPath.curveTo(97.286514f, 3.9753282f, 97.19671f, 3.9638567f, 97.13075f, 3.96875f);
generalPath.curveTo(97.05957f, 3.9768414f, 96.982925f, 3.9912841f, 96.912f, 4.0f);
generalPath.curveTo(96.27095f, 4.0787754f, 95.62343f, 4.184325f, 95.00575f, 4.3125f);
generalPath.curveTo(87.23845f, 5.744672f, 81.33983f, 10.949229f, 80.162f, 17.21875f);
generalPath.curveTo(80.11042f, 17.484203f, 80.071396f, 17.762209f, 80.037f, 18.03125f);
generalPath.curveTo(80.01563f, 18.208055f, 79.988304f, 18.384285f, 79.9745f, 18.5625f);
generalPath.curveTo(79.9694f, 18.595076f, 79.948074f, 18.654882f, 79.94325f, 18.6875f);
generalPath.curveTo(79.94325f, 18.6875f, 76.56192f, 39.39702f, 72.56825f, 44.96875f);
generalPath.curveTo(72.4703f, 45.105408f, 72.33614f, 45.300373f, 72.13075f, 45.53125f);
generalPath.curveTo(70.6906f, 47.039734f, 67.41743f, 50.203327f, 63.349503f, 54.125f);
generalPath.curveTo(47.462845f, 69.21347f, 16.16665f, 97.89234f, 8.443251f, 106.125f);
generalPath.curveTo(8.352861f, 106.20983f, 7.380751f, 107.125f, 7.380751f, 107.125f);
generalPath.lineTo(7.787001f, 106.84375f);
generalPath.curveTo(7.257251f, 107.4306f, 6.857761f, 107.88611f, 6.693251f, 108.15625f);
generalPath.curveTo(5.947931f, 109.38015f, 5.468051f, 110.66568f, 5.224501f, 111.96875f);
generalPath.curveTo(5.220661f, 111.98874f, 5.228231f, 112.01125f, 5.224501f, 112.03125f);
generalPath.curveTo(5.169221f, 112.33645f, 5.129501f, 112.63152f, 5.099501f, 112.9375f);
generalPath.curveTo(5.096311f, 112.96766f, 5.102451f, 113.00109f, 5.099501f, 113.03125f);
generalPath.curveTo(5.071911f, 113.33799f, 5.040091f, 113.66267f, 5.037001f, 113.96875f);
generalPath.curveTo(5.036841f, 113.97923f, 5.037131f, 113.98952f, 5.037001f, 114.0f);
generalPath.curveTo(5.034741f, 114.30496f, 5.047031f, 114.6033f, 5.068251f, 114.90625f);
generalPath.curveTo(5.069611f, 114.92713f, 5.066781f, 114.94788f, 5.068251f, 114.96875f);
generalPath.curveTo(5.091061f, 115.27169f, 5.116571f, 115.57548f, 5.162001f, 115.875f);
generalPath.curveTo(5.165011f, 115.89547f, 5.158891f, 115.91705f, 5.162001f, 115.9375f);
generalPath.curveTo(5.208941f, 116.23668f, 5.280821f, 116.51814f, 5.349501f, 116.8125f);
generalPath.curveTo(5.400691f, 117.03878f, 5.473381f, 117.24591f, 5.537001f, 117.46875f);
generalPath.curveTo(5.563781f, 117.56064f, 5.570651f, 117.65878f, 5.599501f, 117.75f);
generalPath.curveTo(5.606461f, 117.77239f, 5.623671f, 117.79015f, 5.630751f, 117.8125f);
generalPath.curveTo(5.647921f, 117.86578f, 5.675381f, 117.91572f, 5.693251f, 117.96875f);
generalPath.curveTo(5.867111f, 118.49369f, 6.047501f, 119.0342f, 6.287001f, 119.53125f);
generalPath.curveTo(6.296861f, 119.55146f, 6.308281f, 119.57359f, 6.318251f, 119.59375f);
generalPath.curveTo(8.331711f, 123.71516f, 12.534091f, 126.70803f, 17.44325f, 126.28125f);
generalPath.curveTo(17.70535f, 126.26383f, 17.989601f, 126.22483f, 18.25575f, 126.1875f);
generalPath.curveTo(18.265621f, 126.18589f, 18.27713f, 126.18914f, 18.287f, 126.1875f);
generalPath.curveTo(18.358921f, 126.17721f, 18.433552f, 126.16803f, 18.50575f, 126.15625f);
generalPath.curveTo(19.63413f, 125.97219f, 20.797272f, 125.57593f, 21.9745f, 125.0f);
generalPath.curveTo(22.702501f, 124.66124f, 23.424702f, 124.2545f, 24.162f, 123.75f);
generalPath.curveTo(31.939259f, 118.42833f, 78.91355f, 59.75765f, 85.25575f, 55.65625f);
generalPath.curveTo(85.39145f, 55.568497f, 85.5853f, 55.4665f, 85.75575f, 55.375f);
generalPath.curveTo(93.10175f, 52.16445f, 100.1564f, 51.727272f, 107.537f, 49.1875f);
generalPath.curveTo(109.92589f, 48.64112f, 111.537f, 48.28125f, 111.537f, 48.28125f);
generalPath.curveTo(111.54208f, 48.28239f, 111.56354f, 48.280704f, 111.56825f, 48.28125f);
generalPath.curveTo(111.57261f, 48.2812f, 111.5955f, 48.281883f, 111.5995f, 48.28125f);
generalPath.curveTo(111.60279f, 48.27945f, 111.62781f, 48.252377f, 111.63075f, 48.25f);
generalPath.curveTo(111.63266f, 48.24592f, 111.66043f, 48.22339f, 111.662f, 48.21875f);
generalPath.curveTo(111.66323f, 48.21356f, 111.66111f, 48.19325f, 111.662f, 48.1875f);
generalPath.curveTo(111.6625f, 48.181835f, 111.66342f, 48.16559f, 111.662f, 48.15625f);
generalPath.curveTo(111.66549f, 48.155506f, 111.787f, 48.125f, 111.787f, 48.125f);
generalPath.curveTo(111.94932f, 48.16146f, 111.92626f, 47.9175f, 111.75575f, 47.40625f);
generalPath.curveTo(116.04476f, 45.18063f, 121.57642f, 39.1326f, 123.662f, 30.375f);
generalPath.curveTo(123.76301f, 29.95088f, 123.46756f, 27.02621f, 123.3495f, 26.84375f);
generalPath.curveTo(123.36414f, 26.77961f, 123.39759f, 26.720535f, 123.412f, 26.65625f);
generalPath.lineTo(110.0995f, 32.9375f);
generalPath.lineTo(101.88075f, 27.46875f);
generalPath.curveTo(100.99343f, 25.729942f, 100.16922f, 24.149252f, 99.662f, 23.0625f);
generalPath.curveTo(99.66204f, 18.934633f, 99.65871f, 18.584442f, 100.037f, 14.84375f);
generalPath.curveTo(105.11167f, 12.845988f, 114.06825f, 9.40625f, 114.06825f, 9.40625f);
generalPath.curveTo(114.05779f, 9.396168f, 114.0475f, 9.385059f, 114.037f, 9.375f);
generalPath.curveTo(114.04962f, 9.370182f, 114.31825f, 9.28125f, 114.31825f, 9.28125f);
generalPath.curveTo(110.85113f, 5.941115f, 105.6011f, 3.8529482f, 99.787f, 3.875f);
generalPath.closePath();
generalPath.moveTo(16.94325f, 106.71875f);
generalPath.curveTo(19.39999f, 106.66051f, 21.780762f, 108.27892f, 23.0995f, 110.625f);
generalPath.curveTo(23.208582f, 110.82385f, 23.318691f, 111.01018f, 23.412f, 111.21875f);
generalPath.curveTo(23.421911f, 111.24032f, 23.433521f, 111.25958f, 23.44325f, 111.28125f);
generalPath.curveTo(23.535345f, 111.49169f, 23.618382f, 111.71849f, 23.69325f, 111.9375f);
generalPath.curveTo(23.70086f, 111.95909f, 23.717068f, 111.97833f, 23.7245f, 112.0f);
generalPath.curveTo(23.845629f, 112.36439f, 23.936651f, 112.74151f, 24.00575f, 113.125f);
generalPath.curveTo(24.037521f, 113.29159f, 24.047073f, 113.45535f, 24.06825f, 113.625f);
generalPath.curveTo(24.091192f, 113.82192f, 24.122702f, 114.0185f, 24.13075f, 114.21875f);
generalPath.curveTo(24.257786f, 117.37917f, 21.39195f, 120.65453f, 18.13075f, 121.375f);
generalPath.curveTo(17.96618f, 121.39747f, 17.79635f, 121.39758f, 17.63075f, 121.40625f);
generalPath.curveTo(13.978331f, 121.59747f, 10.265401f, 117.94106f, 10.037001f, 114.125f);
generalPath.curveTo(9.879641f, 111.49587f, 11.301811f, 108.86423f, 13.818251f, 107.5f);
generalPath.curveTo(14.429421f, 107.19963f, 15.123891f, 106.95086f, 15.849501f, 106.8125f);
generalPath.curveTo(15.910131f, 106.80397f, 15.975421f, 106.81928f, 16.037f, 106.8125f);
generalPath.curveTo(16.332182f, 106.76731f, 16.632181f, 106.7356f, 16.94325f, 106.71875f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new RadialGradientPaint(new Point2D.Double(154.17799377441406, 33.30924606323242), 11.547417f, new Point2D.Double(154.17799377441406, 33.30924606323242), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9702731966972351f, -0.06291178613901138f, 0.06430445611476898f, 0.8808135986328125f, -50.713809967041016f, 19.652164459228516f));
stroke = new BasicStroke(1.5781032f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(99.787f, 3.875f);
generalPath.curveTo(99.39939f, 3.87647f, 99.02302f, 3.885712f, 98.63075f, 3.90625f);
generalPath.curveTo(98.589645f, 3.908401f, 98.54679f, 3.9038904f, 98.50575f, 3.90625f);
generalPath.curveTo(98.27707f, 3.9193845f, 97.42207f, 3.9611683f, 97.3495f, 3.96875f);
generalPath.curveTo(97.286514f, 3.9753282f, 97.19671f, 3.9638567f, 97.13075f, 3.96875f);
generalPath.curveTo(97.05957f, 3.9768414f, 96.982925f, 3.9912841f, 96.912f, 4.0f);
generalPath.curveTo(96.27095f, 4.0787754f, 95.62343f, 4.184325f, 95.00575f, 4.3125f);
generalPath.curveTo(87.23845f, 5.744672f, 81.33983f, 10.949229f, 80.162f, 17.21875f);
generalPath.curveTo(80.11042f, 17.484203f, 80.071396f, 17.762209f, 80.037f, 18.03125f);
generalPath.curveTo(80.01563f, 18.208055f, 79.988304f, 18.384285f, 79.9745f, 18.5625f);
generalPath.curveTo(79.9694f, 18.595076f, 79.948074f, 18.654882f, 79.94325f, 18.6875f);
generalPath.curveTo(79.94325f, 18.6875f, 76.56192f, 39.39702f, 72.56825f, 44.96875f);
generalPath.curveTo(72.4703f, 45.105408f, 72.33614f, 45.300373f, 72.13075f, 45.53125f);
generalPath.curveTo(70.6906f, 47.039734f, 67.41743f, 50.203327f, 63.349503f, 54.125f);
generalPath.curveTo(47.462845f, 69.21347f, 16.16665f, 97.89234f, 8.443251f, 106.125f);
generalPath.curveTo(8.352861f, 106.20983f, 7.380751f, 107.125f, 7.380751f, 107.125f);
generalPath.lineTo(7.787001f, 106.84375f);
generalPath.curveTo(7.257251f, 107.4306f, 6.857761f, 107.88611f, 6.693251f, 108.15625f);
generalPath.curveTo(5.947931f, 109.38015f, 5.468051f, 110.66568f, 5.224501f, 111.96875f);
generalPath.curveTo(5.220661f, 111.98874f, 5.228231f, 112.01125f, 5.224501f, 112.03125f);
generalPath.curveTo(5.169221f, 112.33645f, 5.129501f, 112.63152f, 5.099501f, 112.9375f);
generalPath.curveTo(5.096311f, 112.96766f, 5.102451f, 113.00109f, 5.099501f, 113.03125f);
generalPath.curveTo(5.071911f, 113.33799f, 5.040091f, 113.66267f, 5.037001f, 113.96875f);
generalPath.curveTo(5.036841f, 113.97923f, 5.037131f, 113.98952f, 5.037001f, 114.0f);
generalPath.curveTo(5.034741f, 114.30496f, 5.047031f, 114.6033f, 5.068251f, 114.90625f);
generalPath.curveTo(5.069611f, 114.92713f, 5.066781f, 114.94788f, 5.068251f, 114.96875f);
generalPath.curveTo(5.091061f, 115.27169f, 5.116571f, 115.57548f, 5.162001f, 115.875f);
generalPath.curveTo(5.165011f, 115.89547f, 5.158891f, 115.91705f, 5.162001f, 115.9375f);
generalPath.curveTo(5.208941f, 116.23668f, 5.280821f, 116.51814f, 5.349501f, 116.8125f);
generalPath.curveTo(5.400691f, 117.03878f, 5.473381f, 117.24591f, 5.537001f, 117.46875f);
generalPath.curveTo(5.563781f, 117.56064f, 5.570651f, 117.65878f, 5.599501f, 117.75f);
generalPath.curveTo(5.606461f, 117.77239f, 5.623671f, 117.79015f, 5.630751f, 117.8125f);
generalPath.curveTo(5.647921f, 117.86578f, 5.675381f, 117.91572f, 5.693251f, 117.96875f);
generalPath.curveTo(5.867111f, 118.49369f, 6.047501f, 119.0342f, 6.287001f, 119.53125f);
generalPath.curveTo(6.296861f, 119.55146f, 6.308281f, 119.57359f, 6.318251f, 119.59375f);
generalPath.curveTo(8.331711f, 123.71516f, 12.534091f, 126.70803f, 17.44325f, 126.28125f);
generalPath.curveTo(17.70535f, 126.26383f, 17.989601f, 126.22483f, 18.25575f, 126.1875f);
generalPath.curveTo(18.265621f, 126.18589f, 18.27713f, 126.18914f, 18.287f, 126.1875f);
generalPath.curveTo(18.358921f, 126.17721f, 18.433552f, 126.16803f, 18.50575f, 126.15625f);
generalPath.curveTo(19.63413f, 125.97219f, 20.797272f, 125.57593f, 21.9745f, 125.0f);
generalPath.curveTo(22.702501f, 124.66124f, 23.424702f, 124.2545f, 24.162f, 123.75f);
generalPath.curveTo(31.939259f, 118.42833f, 78.91355f, 59.75765f, 85.25575f, 55.65625f);
generalPath.curveTo(85.39145f, 55.568497f, 85.5853f, 55.4665f, 85.75575f, 55.375f);
generalPath.curveTo(93.10175f, 52.16445f, 100.1564f, 51.727272f, 107.537f, 49.1875f);
generalPath.curveTo(109.92589f, 48.64112f, 111.537f, 48.28125f, 111.537f, 48.28125f);
generalPath.curveTo(111.54208f, 48.28239f, 111.56354f, 48.280704f, 111.56825f, 48.28125f);
generalPath.curveTo(111.57261f, 48.2812f, 111.5955f, 48.281883f, 111.5995f, 48.28125f);
generalPath.curveTo(111.60279f, 48.27945f, 111.62781f, 48.252377f, 111.63075f, 48.25f);
generalPath.curveTo(111.63266f, 48.24592f, 111.66043f, 48.22339f, 111.662f, 48.21875f);
generalPath.curveTo(111.66323f, 48.21356f, 111.66111f, 48.19325f, 111.662f, 48.1875f);
generalPath.curveTo(111.6625f, 48.181835f, 111.66342f, 48.16559f, 111.662f, 48.15625f);
generalPath.curveTo(111.66549f, 48.155506f, 111.787f, 48.125f, 111.787f, 48.125f);
generalPath.curveTo(111.94932f, 48.16146f, 111.92626f, 47.9175f, 111.75575f, 47.40625f);
generalPath.curveTo(116.04476f, 45.18063f, 121.57642f, 39.1326f, 123.662f, 30.375f);
generalPath.curveTo(123.76301f, 29.95088f, 123.46756f, 27.02621f, 123.3495f, 26.84375f);
generalPath.curveTo(123.36414f, 26.77961f, 123.39759f, 26.720535f, 123.412f, 26.65625f);
generalPath.lineTo(110.0995f, 32.9375f);
generalPath.lineTo(101.88075f, 27.46875f);
generalPath.curveTo(100.99343f, 25.729942f, 100.16922f, 24.149252f, 99.662f, 23.0625f);
generalPath.curveTo(99.66204f, 18.934633f, 99.65871f, 18.584442f, 100.037f, 14.84375f);
generalPath.curveTo(105.11167f, 12.845988f, 114.06825f, 9.40625f, 114.06825f, 9.40625f);
generalPath.curveTo(114.05779f, 9.396168f, 114.0475f, 9.385059f, 114.037f, 9.375f);
generalPath.curveTo(114.04962f, 9.370182f, 114.31825f, 9.28125f, 114.31825f, 9.28125f);
generalPath.curveTo(110.85113f, 5.941115f, 105.6011f, 3.8529482f, 99.787f, 3.875f);
generalPath.closePath();
generalPath.moveTo(16.94325f, 106.71875f);
generalPath.curveTo(19.39999f, 106.66051f, 21.780762f, 108.27892f, 23.0995f, 110.625f);
generalPath.curveTo(23.208582f, 110.82385f, 23.318691f, 111.01018f, 23.412f, 111.21875f);
generalPath.curveTo(23.421911f, 111.24032f, 23.433521f, 111.25958f, 23.44325f, 111.28125f);
generalPath.curveTo(23.535345f, 111.49169f, 23.618382f, 111.71849f, 23.69325f, 111.9375f);
generalPath.curveTo(23.70086f, 111.95909f, 23.717068f, 111.97833f, 23.7245f, 112.0f);
generalPath.curveTo(23.845629f, 112.36439f, 23.936651f, 112.74151f, 24.00575f, 113.125f);
generalPath.curveTo(24.037521f, 113.29159f, 24.047073f, 113.45535f, 24.06825f, 113.625f);
generalPath.curveTo(24.091192f, 113.82192f, 24.122702f, 114.0185f, 24.13075f, 114.21875f);
generalPath.curveTo(24.257786f, 117.37917f, 21.39195f, 120.65453f, 18.13075f, 121.375f);
generalPath.curveTo(17.96618f, 121.39747f, 17.79635f, 121.39758f, 17.63075f, 121.40625f);
generalPath.curveTo(13.978331f, 121.59747f, 10.265401f, 117.94106f, 10.037001f, 114.125f);
generalPath.curveTo(9.879641f, 111.49587f, 11.301811f, 108.86423f, 13.818251f, 107.5f);
generalPath.curveTo(14.429421f, 107.19963f, 15.123891f, 106.95086f, 15.849501f, 106.8125f);
generalPath.curveTo(15.910131f, 106.80397f, 15.975421f, 106.81928f, 16.037f, 106.8125f);
generalPath.curveTo(16.332182f, 106.76731f, 16.632181f, 106.7356f, 16.94325f, 106.71875f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9702731966972351f, -0.06291178613901138f, 0.06900478154420853f, 0.9451966285705566f, -53.46369934082031f, 27.488536834716797f));
// _0_0_1
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(181.67604f, 9.099418f);
generalPath.lineTo(167.54391f, 14.798884f);
generalPath.lineTo(159.38892f, 8.405838f);
generalPath.curveTo(158.31752f, 9.823263f, 157.50262f, 30.099195f, 162.49084f, 29.926445f);
generalPath.curveTo(171.6228f, 29.610191f, 178.29659f, 20.600702f, 181.67604f, 9.099418f);
generalPath.closePath();
shape = generalPath;
paint = new Color(136, 138, 133, 255);
g.setPaint(paint);
g.fill(shape);
paint = new RadialGradientPaint(new Point2D.Double(154.17799377441406, 33.30924606323242), 11.547417f, new Point2D.Double(154.17799377441406, 33.30924606323242), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 0.9318839907646179f, 3.58121395111084f, -10.168330192565918f));
stroke = new BasicStroke(1.644f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(181.67604f, 9.099418f);
generalPath.lineTo(167.54391f, 14.798884f);
generalPath.lineTo(159.38892f, 8.405838f);
generalPath.curveTo(158.31752f, 9.823263f, 157.50262f, 30.099195f, 162.49084f, 29.926445f);
generalPath.curveTo(171.6228f, 29.610191f, 178.29659f, 20.600702f, 181.67604f, 9.099418f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.51376146f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(181.16095f, 9.759779f);
generalPath.lineTo(167.7547f, 15.166029f);
generalPath.lineTo(166.91095f, 24.603529f);
generalPath.lineTo(168.4422f, 28.759779f);
generalPath.curveTo(174.28842f, 25.536423f, 178.63786f, 18.346592f, 181.16095f, 9.759779f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(173.35292053222656, 29.473955154418945), 7.125f, new Point2D.Double(173.35292053222656, 29.473955154418945), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(62, 62, 62, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(5.09318208694458f, 0.03710750862956047f, -0.033428121358156204f, 4.588167190551758f, -711.6483154296875f, -118.8230972290039f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.51376146f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(159.31602f, 8.597299f);
generalPath.curveTo(159.31184f, 8.602836f, 159.28896f, 8.622438f, 159.28477f, 8.628549f);
generalPath.curveTo(159.27644f, 8.641906f, 159.26183f, 8.675446f, 159.25352f, 8.691049f);
generalPath.curveTo(158.21497f, 10.788359f, 157.51898f, 30.297924f, 162.40977f, 30.128548f);
generalPath.curveTo(163.49063f, 30.091118f, 164.55544f, 29.930513f, 165.56602f, 29.659798f);
generalPath.lineTo(166.25352f, 14.066048f);
generalPath.lineTo(159.31602f, 8.597299f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(150.17820739746094, 56.316688537597656), 4.6959705f, new Point2D.Double(150.17820739746094, 56.316688537597656), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(62, 62, 62, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(7.899763107299805f, -0.13335199654102325f, 0.10294999927282333f, 6.098740100860596f, -1031.154052734375f, -297.760986328125f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
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
generalPath.moveTo(96.40711f, 2.0934336f);
generalPath.curveTo(87.40044f, 3.2002237f, 80.55338f, 9.321591f, 79.99305f, 16.555727f);
generalPath.curveTo(79.987946f, 16.588303f, 79.97259f, 16.657791f, 79.967766f, 16.690409f);
generalPath.curveTo(79.967766f, 16.690409f, 76.59497f, 37.40988f, 72.6013f, 42.981613f);
generalPath.curveTo(69.46681f, 47.354652f, 9.544644f, 101.51954f, 6.721579f, 106.15531f);
generalPath.curveTo(0.7589817f, 115.9465f, 11.878434f, 129.9092f, 23.675213f, 121.83713f);
generalPath.curveTo(31.452477f, 116.51545f, 78.41005f, 57.861397f, 84.75224f, 53.76f);
generalPath.curveTo(89.03915f, 50.987717f, 111.30722f, 46.241085f, 111.30722f, 46.241085f);
generalPath.curveTo(112.60573f, 46.532776f, 102.02853f, 27.250273f, 99.18238f, 21.152218f);
generalPath.curveTo(99.18242f, 17.010296f, 99.1734f, 16.674286f, 99.55563f, 12.897588f);
generalPath.curveTo(104.58292f, 10.915815f, 113.83648f, 7.3822007f, 113.83648f, 7.3822007f);
generalPath.curveTo(110.13822f, 3.8193886f, 104.41262f, 1.6742877f, 98.13631f, 2.0028987f);
generalPath.curveTo(98.0952f, 2.0050497f, 98.04436f, 2.0075026f, 98.00332f, 2.0098608f);
generalPath.curveTo(97.77464f, 2.022996f, 96.94524f, 2.0614781f, 96.872665f, 2.0690584f);
generalPath.curveTo(96.80968f, 2.075637f, 96.70585f, 2.0763528f, 96.63989f, 2.0812466f);
generalPath.curveTo(96.5687f, 2.089338f, 96.478035f, 2.084718f, 96.40711f, 2.0934336f);
generalPath.closePath();
generalPath.moveTo(16.792732f, 104.64842f);
generalPath.curveTo(20.445192f, 104.45719f, 23.978542f, 108.00384f, 24.147654f, 112.21109f);
generalPath.curveTo(24.287558f, 115.69175f, 20.806852f, 119.32082f, 17.154408f, 119.51205f);
generalPath.curveTo(13.501973f, 119.70328f, 9.779841f, 116.03165f, 9.551438f, 112.2156f);
generalPath.curveTo(9.331964f, 108.54859f, 12.176541f, 104.89011f, 16.792732f, 104.64842f);
generalPath.closePath();
shape = generalPath;
paint = new Color(136, 138, 133, 255);
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
generalPath.moveTo(96.92014f, 1.9928089f);
generalPath.curveTo(87.913475f, 3.099597f, 81.06642f, 9.220965f, 80.50609f, 16.4551f);
generalPath.curveTo(80.500984f, 16.487675f, 80.48563f, 16.557165f, 80.480804f, 16.589783f);
generalPath.curveTo(80.480804f, 16.589783f, 77.10801f, 37.309254f, 73.11434f, 42.88099f);
generalPath.curveTo(69.97984f, 47.25403f, 10.057688f, 101.41891f, 7.2346168f, 106.05468f);
generalPath.curveTo(1.2720191f, 115.84586f, 12.391471f, 129.80855f, 24.188251f, 121.73649f);
generalPath.curveTo(31.965506f, 116.41482f, 78.92308f, 57.76077f, 85.26528f, 53.65937f);
generalPath.curveTo(89.552185f, 50.88709f, 111.82025f, 46.14046f, 111.82025f, 46.14046f);
generalPath.curveTo(113.11876f, 46.43215f, 102.54156f, 27.149647f, 99.69541f, 21.051592f);
generalPath.curveTo(99.69545f, 16.90967f, 99.68643f, 16.57366f, 100.06866f, 12.796963f);
generalPath.curveTo(105.09595f, 10.81519f, 114.34951f, 7.281575f, 114.34951f, 7.281575f);
generalPath.curveTo(110.65125f, 3.7187645f, 104.92565f, 1.5736628f, 98.64934f, 1.9022737f);
generalPath.curveTo(98.60823f, 1.9044247f, 98.55739f, 1.906877f, 98.51635f, 1.9092366f);
generalPath.curveTo(98.28767f, 1.9223711f, 97.458275f, 1.9608519f, 97.3857f, 1.9684335f);
generalPath.curveTo(97.32271f, 1.9750117f, 97.21887f, 1.975728f, 97.15292f, 1.9806212f);
generalPath.curveTo(97.08173f, 1.9887125f, 96.991066f, 1.9840931f, 96.92014f, 1.9928089f);
generalPath.closePath();
generalPath.moveTo(17.30577f, 104.5478f);
generalPath.curveTo(20.958221f, 104.35657f, 24.491585f, 107.9032f, 24.66069f, 112.11045f);
generalPath.curveTo(24.800596f, 115.59111f, 21.319891f, 119.22018f, 17.667437f, 119.41142f);
generalPath.curveTo(14.01501f, 119.60264f, 10.292873f, 115.93102f, 10.064477f, 112.11496f);
generalPath.curveTo(9.845f, 108.44796f, 12.689584f, 104.78949f, 17.30577f, 104.5478f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(78.34490203857422, 47.89650344848633), 59.06985f, new Point2D.Double(78.34490203857422, 47.89650344848633), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(136, 138, 133, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0280267000198364f, -0.1270724982023239f, 0.13091759383678436f, 0.9349125027656555f, -10.479426383972168f, 16.042144775390625f));
g.setPaint(paint);
g.fill(shape);
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
generalPath.moveTo(82.02281f, 17.158216f);
generalPath.lineTo(89.49955f, 33.402557f);
generalPath.lineTo(92.68346f, 32.045387f);
generalPath.lineTo(97.96604f, 43.87489f);
generalPath.lineTo(95.347595f, 45.117855f);
generalPath.lineTo(98.94601f, 49.81898f);
generalPath.curveTo(104.89f, 48.328705f, 111.30116f, 45.784054f, 111.30116f, 45.784054f);
generalPath.curveTo(111.30583f, 45.784603f, 111.32926f, 45.782413f, 111.33358f, 45.782368f);
generalPath.curveTo(111.33755f, 45.781734f, 111.36238f, 45.781902f, 111.36601f, 45.78068f);
generalPath.curveTo(111.36859f, 45.777737f, 111.39435f, 45.751778f, 111.39659f, 45.74827f);
generalPath.curveTo(111.39814f, 45.74363f, 111.39352f, 45.72273f, 111.39473f, 45.717537f);
generalPath.curveTo(111.3965f, 45.706043f, 111.42302f, 45.66807f, 111.42346f, 45.654392f);
generalPath.curveTo(111.39794f, 43.87557f, 101.88636f, 26.444801f, 99.21683f, 20.702839f);
generalPath.curveTo(99.21383f, 16.56129f, 99.22042f, 16.22845f, 99.59786f, 12.452345f);
generalPath.curveTo(104.59727f, 10.474019f, 113.82695f, 7.3443503f, 113.82695f, 7.3443503f);
generalPath.curveTo(110.14548f, 3.7794616f, 102.58604f, 2.2249012f, 96.949356f, 3.270741f);
generalPath.curveTo(88.09576f, 4.9134526f, 82.839455f, 10.203925f, 82.02281f, 17.158216f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(222.09877014160156, 1.2351387739181519), 16.390625f, new Point2D.Double(222.09877014160156, 1.2351387739181519), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(136, 138, 133, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(2.3781044483184814f, -0.30750060081481934f, 1.0402511358261108f, 6.867776870727539f, -436.0238952636719f, 108.90545654296875f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(95.37965f, 2.3079607f);
generalPath.curveTo(86.893f, 3.7422552f, 80.538506f, 9.690253f, 80.00007f, 16.641804f);
generalPath.curveTo(79.99498f, 16.674376f, 79.98951f, 16.73268f, 79.98469f, 16.765297f);
generalPath.curveTo(79.98467f, 16.7653f, 76.6137f, 37.486263f, 72.62002f, 43.058f);
generalPath.curveTo(69.48553f, 47.431034f, 9.544847f, 101.58825f, 6.72177f, 106.22402f);
generalPath.curveTo(0.7591726f, 116.0152f, 11.89367f, 129.98146f, 23.690441f, 121.90941f);
generalPath.curveTo(31.467705f, 116.58773f, 78.441284f, 57.936703f, 84.783485f, 53.8353f);
generalPath.curveTo(89.07038f, 51.063023f, 111.31189f, 46.300446f, 111.31189f, 46.300446f);
generalPath.curveTo(111.31697f, 46.301586f, 111.34349f, 46.32581f, 111.3482f, 46.326355f);
generalPath.curveTo(111.35256f, 46.32631f, 111.37633f, 46.32302f, 111.38033f, 46.322384f);
generalPath.curveTo(111.38362f, 46.320583f, 111.40533f, 46.29091f, 111.40827f, 46.288532f);
generalPath.curveTo(111.41018f, 46.284454f, 111.43464f, 46.25932f, 111.43621f, 46.25468f);
generalPath.curveTo(111.43744f, 46.249485f, 111.43114f, 46.23055f, 111.43203f, 46.2248f);
generalPath.curveTo(111.4337f, 46.20591f, 111.42075f, 46.158913f, 111.41947f, 46.13516f);
generalPath.curveTo(111.23997f, 44.11528f, 101.86289f, 26.922081f, 99.20574f, 21.228975f);
generalPath.curveTo(99.20577f, 17.087053f, 99.20368f, 16.75121f, 99.58591f, 12.974512f);
generalPath.curveTo(104.6132f, 10.992742f, 113.84494f, 7.4426208f, 113.84494f, 7.4426208f);
generalPath.curveTo(110.14668f, 3.879809f, 104.43551f, 1.7573663f, 98.15921f, 2.0859766f);
generalPath.curveTo(98.1181f, 2.088127f, 98.06756f, 2.069621f, 98.02652f, 2.0719793f);
generalPath.curveTo(97.79784f, 2.0851147f, 96.966324f, 2.1436226f, 96.893745f, 2.1512036f);
generalPath.curveTo(96.83075f, 2.1577826f, 96.73064f, 2.1442266f, 96.66468f, 2.1491199f);
generalPath.curveTo(96.602394f, 2.1562014f, 96.50564f, 2.1718526f, 96.439804f, 2.1769168f);
generalPath.curveTo(96.087975f, 2.2201514f, 95.72464f, 2.2496562f, 95.37965f, 2.3079607f);
generalPath.closePath();
generalPath.moveTo(96.73568f, 3.3562663f);
generalPath.curveTo(102.34044f, 2.3942943f, 109.68053f, 3.574666f, 113.30447f, 7.083854f);
generalPath.curveTo(113.30447f, 7.083854f, 104.14124f, 10.625504f, 99.14182f, 12.603833f);
generalPath.curveTo(98.76438f, 16.379938f, 98.75865f, 16.71675f, 98.76165f, 20.858295f);
generalPath.curveTo(101.41033f, 26.5554f, 110.77187f, 43.762527f, 110.94326f, 45.768448f);
generalPath.curveTo(110.94365f, 45.775875f, 110.94735f, 45.79138f, 110.94744f, 45.79833f);
generalPath.curveTo(110.94229f, 45.809658f, 110.92917f, 45.851284f, 110.92369f, 45.862064f);
generalPath.curveTo(110.92393f, 45.864822f, 110.92747f, 45.888718f, 110.92787f, 45.891945f);
generalPath.curveTo(110.92083f, 45.89924f, 110.90122f, 45.924324f, 110.89993f, 45.925797f);
generalPath.curveTo(110.89277f, 45.925987f, 110.86979f, 45.92945f, 110.8678f, 45.929768f);
generalPath.curveTo(110.86431f, 45.930008f, 110.8386f, 45.93361f, 110.83568f, 45.93374f);
generalPath.curveTo(110.83568f, 45.93374f, 103.72659f, 47.151257f, 97.78259f, 48.641537f);
generalPath.lineTo(96.00098f, 46.05587f);
generalPath.lineTo(99.49838f, 43.760696f);
generalPath.lineTo(93.10366f, 31.367651f);
generalPath.lineTo(88.69148f, 32.89899f);
generalPath.lineTo(81.5629f, 17.29977f);
generalPath.curveTo(82.379524f, 10.345481f, 87.62926f, 5.060626f, 96.48286f, 3.4179146f);
generalPath.curveTo(96.57092f, 3.4015741f, 96.64671f, 3.3715355f, 96.73568f, 3.3562663f);
generalPath.closePath();
generalPath.moveTo(15.64722f, 104.84718f);
generalPath.curveTo(16.016935f, 104.77811f, 16.411234f, 104.75487f, 16.807932f, 104.73411f);
generalPath.curveTo(20.460379f, 104.54288f, 24.002329f, 108.06732f, 24.171444f, 112.27457f);
generalPath.curveTo(24.311352f, 115.75523f, 20.80801f, 119.39494f, 17.155556f, 119.58618f);
generalPath.curveTo(13.503114f, 119.77741f, 9.792731f, 116.1027f, 9.564325f, 112.28664f);
generalPath.curveTo(9.363722f, 108.93477f, 11.714792f, 105.58188f, 15.64722f, 104.84718f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(302.08856201171875, -10.284326553344727), 59.07331f, new Point2D.Double(302.08856201171875, -10.284326553344727), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.285702109336853f, -0.09693698585033417f, 0.3403615951538086f, 0.8738542199134827f, 19.9587459564209f, 76.36459350585938f));
g.setPaint(paint);
g.fill(shape);
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
generalPath.moveTo(95.62758f, 2.2773147f);
generalPath.curveTo(87.14093f, 3.711608f, 80.78644f, 9.659606f, 80.24801f, 16.611156f);
generalPath.curveTo(80.24291f, 16.643728f, 80.23744f, 16.702032f, 80.23262f, 16.73465f);
generalPath.curveTo(80.232605f, 16.734653f, 76.861626f, 37.455616f, 72.86795f, 43.02735f);
generalPath.curveTo(69.73346f, 47.400387f, 9.792772f, 101.5576f, 6.969697f, 106.19338f);
generalPath.curveTo(1.0070949f, 115.98455f, 12.1416f, 129.9508f, 23.938372f, 121.87875f);
generalPath.curveTo(31.715635f, 116.55707f, 78.68922f, 57.906055f, 85.03142f, 53.804657f);
generalPath.curveTo(89.31831f, 51.032375f, 111.55982f, 46.2698f, 111.55982f, 46.2698f);
generalPath.curveTo(111.5649f, 46.27094f, 111.59142f, 46.295166f, 111.59613f, 46.29571f);
generalPath.curveTo(111.60049f, 46.295662f, 111.62426f, 46.292374f, 111.62826f, 46.29174f);
generalPath.curveTo(111.63155f, 46.28994f, 111.65326f, 46.26026f, 111.6562f, 46.25789f);
generalPath.curveTo(111.65811f, 46.253807f, 111.68257f, 46.228676f, 111.68414f, 46.224033f);
generalPath.curveTo(111.68537f, 46.21884f, 111.67907f, 46.1999f, 111.67996f, 46.194153f);
generalPath.curveTo(111.68163f, 46.175266f, 111.66868f, 46.12827f, 111.6674f, 46.10451f);
generalPath.curveTo(111.4879f, 44.084637f, 102.11082f, 26.891436f, 99.45367f, 21.19833f);
generalPath.curveTo(99.4537f, 17.05641f, 99.45161f, 16.720564f, 99.83383f, 12.943866f);
generalPath.curveTo(104.86112f, 10.962095f, 114.09287f, 7.411975f, 114.09287f, 7.411975f);
generalPath.curveTo(110.39461f, 3.849162f, 104.68344f, 1.7267196f, 98.40714f, 2.0553298f);
generalPath.curveTo(98.36602f, 2.0574815f, 98.31549f, 2.038975f, 98.27445f, 2.0413342f);
generalPath.curveTo(98.04577f, 2.054468f, 97.21426f, 2.1129768f, 97.14168f, 2.1205568f);
generalPath.curveTo(97.07868f, 2.1271365f, 96.97857f, 2.1135807f, 96.91261f, 2.118473f);
generalPath.curveTo(96.85033f, 2.1255555f, 96.75357f, 2.1412065f, 96.68773f, 2.1462708f);
generalPath.curveTo(96.33591f, 2.1895056f, 95.97257f, 2.2190094f, 95.62758f, 2.2773147f);
generalPath.closePath();
generalPath.moveTo(96.983604f, 3.3256197f);
generalPath.curveTo(102.58837f, 2.3636467f, 109.92846f, 3.5440202f, 113.5524f, 7.053209f);
generalPath.curveTo(113.5524f, 7.053209f, 104.38916f, 10.594859f, 99.38974f, 12.573186f);
generalPath.curveTo(99.01231f, 16.349293f, 99.00658f, 16.686104f, 99.00958f, 20.82765f);
generalPath.curveTo(101.65825f, 26.524755f, 111.0198f, 43.73188f, 111.19119f, 45.737804f);
generalPath.curveTo(111.19158f, 45.745228f, 111.19528f, 45.760735f, 111.19537f, 45.76768f);
generalPath.curveTo(111.19022f, 45.77901f, 111.1771f, 45.820637f, 111.17162f, 45.831417f);
generalPath.curveTo(111.17186f, 45.83418f, 111.1754f, 45.85807f, 111.1758f, 45.861298f);
generalPath.curveTo(111.16876f, 45.868595f, 111.14915f, 45.893677f, 111.14786f, 45.89515f);
generalPath.curveTo(111.1407f, 45.89534f, 111.11772f, 45.898804f, 111.11573f, 45.89912f);
generalPath.curveTo(111.11224f, 45.899364f, 111.08653f, 45.90296f, 111.08361f, 45.90309f);
generalPath.curveTo(111.08361f, 45.90309f, 103.97452f, 47.12061f, 98.03052f, 48.61089f);
generalPath.lineTo(96.15203f, 45.33341f);
generalPath.lineTo(99.92966f, 43.238194f);
generalPath.lineTo(94.063095f, 31.014462f);
generalPath.lineTo(89.09047f, 32.145885f);
generalPath.lineTo(81.81083f, 17.269123f);
generalPath.curveTo(82.627464f, 10.314834f, 87.8772f, 5.0299788f, 96.73078f, 3.3872688f);
generalPath.curveTo(96.818855f, 3.3709273f, 96.894646f, 3.3408887f, 96.983604f, 3.3256197f);
generalPath.closePath();
generalPath.moveTo(15.895147f, 104.81653f);
generalPath.curveTo(16.26487f, 104.74745f, 16.65916f, 104.72423f, 17.055864f, 104.70345f);
generalPath.curveTo(20.708307f, 104.51223f, 24.25026f, 108.03667f, 24.419373f, 112.24391f);
generalPath.curveTo(24.55928f, 115.72457f, 21.05594f, 119.36428f, 17.403484f, 119.55552f);
generalPath.curveTo(13.751044f, 119.74676f, 10.040662f, 116.07204f, 9.812256f, 112.25599f);
generalPath.curveTo(9.611653f, 108.90412f, 11.962719f, 105.55124f, 15.895147f, 104.81653f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(302.08856201171875, -10.284326553344727), 59.07331f, new Point2D.Double(302.08856201171875, -10.284326553344727), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.285702109336853f, -0.09693698585033417f, 0.3403615951538086f, 0.8738542199134827f, 20.206674575805664f, 76.33393859863281f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0280267000198364f, -0.1270724982023239f, 0.133896604180336f, 0.9561867117881775f, -10.625434875488281f, 14.78476333618164f));
// _0_0_7
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9562910199165344f, -0.2924169898033142f, 0.30970698595046997f, 0.9508320093154907f, 0.0f, 0.0f));
// _0_0_7_0
shape = new Rectangle2D.Double(68.62531280517578, 58.0, 13.399776458740234, 13.094863891601562);
paint = new Color(46, 52, 54, 255);
g.setPaint(paint);
g.fill(shape);
paint = new RadialGradientPaint(new Point2D.Double(64.03540802001953, 72.25350952148438), 8.072001f, new Point2D.Double(64.03540802001953, 72.25350952148438), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.3541100025177002f, -4.171410083770752f, 5.032557964324951f, -1.5198800563812256f, -331.36480712890625f, 448.8406066894531f));
stroke = new BasicStroke(1.5441269f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(68.62531280517578, 58.0, 13.399776458740234, 13.094863891601562);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9676830172538757f, -0.25216999650001526f, 0.3074229955673218f, 0.9515730142593384f, 0.0f, 0.0f));
// _0_0_7_1
shape = new Rectangle2D.Double(71.56298065185547, 55.69108581542969, 7.725412368774414, 11.043237686157227);
paint = new RadialGradientPaint(new Point2D.Double(77.37106323242188, 64.80364227294922), 4.14229f, new Point2D.Double(77.37106323242188, 64.80364227294922), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(85, 87, 83, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.7188400030136108f, 0.05195071920752525f, 0.12400300055742264f, 10.146309852600098f, 11.772379875183105f, -600.3242797851562f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.986050009727478f, -0.16644999384880066f, 0.08671966940164566f, 0.9962329864501953f, 0.0f, 0.0f));
// _0_0_7_2
shape = new Rectangle2D.Double(82.51152038574219, 49.742820739746094, 11.254694938659668, 1.2325668334960938);
paint = new RadialGradientPaint(new Point2D.Double(94.13844299316406, 38.927982330322266), 6.8733773f, new Point2D.Double(94.13844299316406, 38.927982330322266), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.5812469720840454f, 0.005817117169499397f, -0.07455761730670929f, 9.383172988891602f, 36.0305290222168f, -309.6658020019531f));
g.setPaint(paint);
g.fill(shape);
paint = new LinearGradientPaint(new Point2D.Double(79.73527526855469, 48.53878402709961), new Point2D.Double(95.0, 48.53878402709961), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 170),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.7373009920120239f, -6.658052029706596E-7f, 1.2727259957046044E-7f, 1.0162429809570312f, 23.722639083862305f, 1.0318870544433594f));
stroke = new BasicStroke(0.38432986f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(82.51152038574219, 49.742820739746094, 11.254694938659668, 1.2325668334960938);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9892820119857788f, -0.14601999521255493f, 0.09906172007322311f, 0.9950810074806213f, 0.0f, 0.0f));
// _0_0_7_3
shape = new Rectangle2D.Double(83.72756958007812, 56.03600311279297, 10.96024227142334, 1.0542099475860596);
paint = new RadialGradientPaint(new Point2D.Double(94.13844299316406, 38.927982330322266), 6.8733773f, new Point2D.Double(94.13844299316406, 38.927982330322266), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.5660409927368164f, 0.004976245108991861f, -0.07260835915803909f, 8.02540111541748f, 38.46268844604492f, -251.36520385742188f));
g.setPaint(paint);
g.fill(shape);
paint = new LinearGradientPaint(new Point2D.Double(79.73527526855469, 48.53878402709961), new Point2D.Double(95.0, 48.53878402709961), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 170),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.7180110216140747f, 5.475357056639041E-7f, -1.861064014008207E-8f, 0.8691890239715576f, 26.47673988342285f, 14.373740196228027f));
stroke = new BasicStroke(0.35075644f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(83.72756958007812, 56.03600311279297, 10.96024227142334, 1.0542099475860596);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.9906309843063354f, -0.13656699657440186f, 0.10598800331354141f, 0.9943670034408569f, 0.0f, 0.0f));
// _0_0_7_4
shape = new Rectangle2D.Double(81.90776824951172, 51.249149322509766, 11.671585083007812, 1.050704836845398);
paint = new RadialGradientPaint(new Point2D.Double(94.13844299316406, 38.927982330322266), 6.8733773f, new Point2D.Double(94.13844299316406, 38.927982330322266), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.6027770042419434f, 0.004958537872880697f, -0.07732141762971878f, 7.998709201812744f, 33.70512008666992f, -255.1298065185547f));
g.setPaint(paint);
g.fill(shape);
paint = new LinearGradientPaint(new Point2D.Double(79.73527526855469, 48.53878402709961), new Point2D.Double(95.0, 48.53878402709961), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 170),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.7646120190620422f, -9.213433145305316E-7f, -8.915483107330147E-8f, 0.8662980198860168f, 20.94123077392578f, 9.725383758544922f));
stroke = new BasicStroke(0.3613577f,1,1,4.0f,null,0.0f);
shape = new Rectangle2D.Double(81.90776824951172, 51.249149322509766, 11.671585083007812, 1.050704836845398);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(99.2677f, 12.983285f);
generalPath.lineTo(113.51524f, 7.483389f);
generalPath.lineTo(114.15971f, 9.173473f);
generalPath.lineTo(99.22846f, 15.089652f);
generalPath.lineTo(99.2677f, 12.983285f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(105.58074951171875, 11.27086067199707), new Point2D.Double(120.06922149658203, 11.27086067199707), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0692341327667236f, -0.13216620683670044f, 0.133896604180336f, 0.9561867117881775f, -15.573127746582031f, 15.39633846282959f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(110.6256f, 44.0832f);
generalPath.curveTo(114.78576f, 43.29433f, 121.28563f, 34.61099f, 123.36506f, 24.859297f);
generalPath.curveTo(123.45757f, 24.425528f, 123.7907f, 27.917213f, 123.68001f, 28.382002f);
generalPath.curveTo(121.53531f, 37.387863f, 115.75073f, 43.534607f, 111.41621f, 45.599182f);
generalPath.curveTo(111.15981f, 45.721306f, 111.44603f, 47.325287f, 110.6256f, 44.0832f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(114.74418640136719, 51.13191604614258), new Point2D.Double(141.67282104492188, 13.184786796569824), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0280267000198364f, -0.1270724982023239f, 0.133896604180336f, 0.9561867117881775f, -10.625434875488281f, 14.78476333618164f));
g.setPaint(paint);
g.fill(shape);
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
generalPath.moveTo(82.637436f, 16.14386f);
generalPath.lineTo(89.18703f, 32.971996f);
generalPath.lineTo(93.21161f, 32.2147f);
generalPath.lineTo(98.70983f, 43.78295f);
generalPath.lineTo(95.44447f, 45.80967f);
generalPath.lineTo(97.82512f, 49.01915f);
generalPath.curveTo(103.76911f, 47.52887f, 110.18027f, 44.98422f, 110.18027f, 44.98422f);
generalPath.curveTo(110.18494f, 44.984768f, 110.20838f, 44.98258f, 110.2127f, 44.982533f);
generalPath.curveTo(110.21667f, 44.9819f, 110.2415f, 44.982067f, 110.24512f, 44.980846f);
generalPath.curveTo(110.2477f, 44.977905f, 110.27347f, 44.951946f, 110.2757f, 44.948433f);
generalPath.curveTo(110.27725f, 44.943794f, 110.27264f, 44.922894f, 110.27385f, 44.9177f);
generalPath.curveTo(110.27562f, 44.906208f, 110.30213f, 44.868237f, 110.30257f, 44.854557f);
generalPath.curveTo(110.27705f, 43.075733f, 100.76548f, 25.644966f, 98.09595f, 19.903004f);
generalPath.curveTo(98.09295f, 15.761457f, 98.09954f, 15.428616f, 98.47698f, 11.65251f);
generalPath.curveTo(103.47639f, 9.674185f, 111.66159f, 6.2601247f, 111.66159f, 6.2601247f);
generalPath.curveTo(107.98012f, 2.6952353f, 101.65891f, 2.8086948f, 96.022224f, 3.8545353f);
generalPath.curveTo(87.16862f, 5.497247f, 83.45408f, 9.189568f, 82.637436f, 16.14386f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(224.4635772705078, -4.225864887237549), 16.390625f, new Point2D.Double(224.4635772705078, -4.225864887237549), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(136, 138, 133, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(2.3781044483184814f, -0.30750060081481934f, 1.0402511358261108f, 6.867776870727539f, -437.1448059082031f, 108.10563659667969f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.3853211f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_11
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(7.3940916f, 105.13388f);
generalPath.curveTo(7.3940916f, 105.13388f, 68.999954f, 47.33505f, 72.9893f, 42.623978f);
generalPath.curveTo(76.82002f, 38.100235f, 80.1685f, 17.54004f, 80.1685f, 17.54004f);
generalPath.curveTo(80.1685f, 17.54004f, 82.2679f, 16.117613f, 81.86678f, 17.350962f);
generalPath.curveTo(81.31719f, 19.04084f, 75.97389f, 39.78823f, 74.66237f, 41.80284f);
generalPath.curveTo(71.67457f, 46.39236f, 54.716167f, 61.53423f, 54.716167f, 61.53423f);
generalPath.lineTo(13.281724f, 100.89827f);
generalPath.lineTo(7.3940916f, 105.13388f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.8944954f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_12
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(17.910824f, 120.66107f);
generalPath.curveTo(17.910824f, 120.66107f, 13.152011f, 120.73594f, 10.64529f, 117.58595f);
generalPath.curveTo(8.138563f, 114.43595f, 7.9289765f, 109.6253f, 7.9289765f, 109.6253f);
generalPath.lineTo(8.479355f, 108.80087f);
generalPath.curveTo(8.479355f, 108.80087f, 8.974508f, 113.62701f, 11.232718f, 116.67617f);
generalPath.curveTo(13.534196f, 119.78373f, 18.47105f, 119.9607f, 18.394112f, 120.08926f);
generalPath.lineTo(17.910824f, 120.66107f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(19.006332397460938, 99.12092590332031), 4.6031747f, new Point2D.Double(19.006332397460938, 99.12092590332031), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-1.0334476232528687f, 0.07897265255451202f, -0.11606919765472412f, -1.3576785326004028f, 44.29612731933594f, 247.80776977539062f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_13
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(109.06927f, 30.29602f);
generalPath.curveTo(108.9859f, 30.565388f, 109.33167f, 38.632744f, 109.38181f, 38.917877f);
generalPath.curveTo(109.50191f, 43.347557f, 110.55255f, 43.61543f, 110.668f, 44.409443f);
generalPath.curveTo(111.5244f, 44.083626f, 110.9433f, 44.489887f, 111.71376f, 44.013374f);
generalPath.curveTo(111.64006f, 43.62608f, 110.55012f, 40.925552f, 110.09993f, 39.95713f);
generalPath.curveTo(110.13851f, 37.753998f, 110.14567f, 31.574543f, 110.15475f, 30.9883f);
generalPath.curveTo(109.73913f, 30.710192f, 109.57953f, 30.59927f, 109.06927f, 30.29602f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.51376146f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_14
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(122.85659f, 25.194942f);
generalPath.lineTo(110.22192f, 31.148323f);
generalPath.lineTo(110.05449f, 40.121696f);
generalPath.lineTo(111.82702f, 43.95384f);
generalPath.curveTo(117.27702f, 40.539337f, 121.00104f, 33.4699f, 122.85659f, 25.194942f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(174.07650756835938, 28.159635543823242), 7.125f, new Point2D.Double(174.07650756835938, 28.159635543823242), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(62, 62, 62, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(4.944338798522949f, -0.28534749150276184f, 0.2841705083847046f, 4.338822841644287f, -752.28515625f, -40.1728401184082f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-228.9185f, -67.271774f);
generalPath.lineTo(-228.9185f, -70.06648f);
generalPath.lineTo(-228.9185f, -67.271774f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_16
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(65.6909f, -129.46266f);
generalPath.lineTo(65.6909f, -132.25737f);
generalPath.lineTo(65.6909f, -129.46266f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.06147539f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_18
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-91.3174f, -199.09776f);
generalPath.lineTo(-91.3174f, -201.89247f);
generalPath.lineTo(-91.3174f, -199.09776f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_19
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-210.8196f, -285.728f);
generalPath.lineTo(-210.8196f, -288.5227f);
generalPath.lineTo(-210.8196f, -285.728f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -27.868000030517578f, -141.14639282226562f));
// _0_0_20
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -27.868000030517578f, -141.14639282226562f));
// _0_0_21
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
generalPath.moveTo(35.7718f, -219.97273f);
generalPath.lineTo(35.7718f, -222.76746f);
generalPath.lineTo(35.7718f, -219.97273f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_23
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-56.852646f, -146.07906f);
generalPath.lineTo(-56.852646f, -147.6058f);
generalPath.lineTo(-56.852646f, -146.07906f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_24
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.5778689f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_25
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_26
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-308.4016f, -303.42273f);
generalPath.lineTo(-308.4016f, -306.21744f);
generalPath.lineTo(-308.4016f, -303.42273f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-0.7829949855804443f, 0.0f, 0.0f, 0.6508790254592896f, -2631.260009765625f, 383.09490966796875f));
// _0_0_27
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-0.7829949855804443f, 0.0f, 0.0f, 0.6508790254592896f, -2631.260009765625f, 383.09490966796875f));
// _0_0_28
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 0.6508790254592896f, 569.7028198242188f, 390.4226989746094f));
// _0_0_29
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.40163934f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 0.6508790254592896f, 569.7028198242188f, 390.4226989746094f));
// _0_0_30
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_31
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(95.62758f, 2.2773147f);
generalPath.curveTo(87.14093f, 3.711608f, 80.78644f, 9.659606f, 80.24801f, 16.611156f);
generalPath.curveTo(80.24291f, 16.643728f, 80.23744f, 16.702032f, 80.23262f, 16.73465f);
generalPath.curveTo(80.232605f, 16.734653f, 76.861626f, 37.455616f, 72.86795f, 43.02735f);
generalPath.curveTo(69.73346f, 47.400387f, 9.792772f, 101.5576f, 6.969697f, 106.19338f);
generalPath.curveTo(1.0070949f, 115.98455f, 12.1416f, 129.9508f, 23.938372f, 121.87875f);
generalPath.curveTo(31.715635f, 116.55707f, 78.68922f, 57.906055f, 85.03142f, 53.804657f);
generalPath.curveTo(89.31831f, 51.032375f, 111.55982f, 46.2698f, 111.55982f, 46.2698f);
generalPath.curveTo(111.5649f, 46.27094f, 111.59142f, 46.295166f, 111.59613f, 46.29571f);
generalPath.curveTo(111.60049f, 46.295662f, 111.62426f, 46.292374f, 111.62826f, 46.29174f);
generalPath.curveTo(111.63155f, 46.28994f, 111.65326f, 46.26026f, 111.6562f, 46.25789f);
generalPath.curveTo(111.65811f, 46.253807f, 111.68257f, 46.228676f, 111.68414f, 46.224033f);
generalPath.curveTo(111.68537f, 46.21884f, 111.67907f, 46.1999f, 111.67996f, 46.194153f);
generalPath.curveTo(111.68163f, 46.175266f, 111.66868f, 46.12827f, 111.6674f, 46.10451f);
generalPath.curveTo(111.4879f, 44.084637f, 102.11082f, 26.891436f, 99.45367f, 21.19833f);
generalPath.curveTo(99.4537f, 17.05641f, 99.45161f, 16.720564f, 99.83383f, 12.943866f);
generalPath.curveTo(104.86112f, 10.962095f, 114.09287f, 7.411975f, 114.09287f, 7.411975f);
generalPath.curveTo(110.39461f, 3.849162f, 104.68344f, 1.7267196f, 98.40714f, 2.0553298f);
generalPath.curveTo(98.36602f, 2.0574815f, 98.31549f, 2.038975f, 98.27445f, 2.0413342f);
generalPath.curveTo(98.04577f, 2.054468f, 97.21426f, 2.1129768f, 97.14168f, 2.1205568f);
generalPath.curveTo(97.07868f, 2.1271365f, 96.97857f, 2.1135807f, 96.91261f, 2.118473f);
generalPath.curveTo(96.85033f, 2.1255555f, 96.75357f, 2.1412065f, 96.68773f, 2.1462708f);
generalPath.curveTo(96.33591f, 2.1895056f, 95.97257f, 2.2190094f, 95.62758f, 2.2773147f);
generalPath.closePath();
generalPath.moveTo(96.983604f, 3.3256197f);
generalPath.curveTo(102.58837f, 2.3636467f, 109.92846f, 3.5440202f, 113.5524f, 7.053209f);
generalPath.curveTo(113.5524f, 7.053209f, 104.38916f, 10.594859f, 99.38974f, 12.573186f);
generalPath.curveTo(99.01231f, 16.349293f, 99.00658f, 16.686104f, 99.00958f, 20.82765f);
generalPath.curveTo(101.65825f, 26.524755f, 111.0198f, 43.73188f, 111.19119f, 45.737804f);
generalPath.curveTo(111.19158f, 45.745228f, 111.19528f, 45.760735f, 111.19537f, 45.76768f);
generalPath.curveTo(111.19022f, 45.77901f, 111.1771f, 45.820637f, 111.17162f, 45.831417f);
generalPath.curveTo(111.17186f, 45.83418f, 111.1754f, 45.85807f, 111.1758f, 45.861298f);
generalPath.curveTo(111.16876f, 45.868595f, 111.14915f, 45.893677f, 111.14786f, 45.89515f);
generalPath.curveTo(111.1407f, 45.89534f, 111.11772f, 45.898804f, 111.11573f, 45.89912f);
generalPath.curveTo(111.11224f, 45.899364f, 111.08653f, 45.90296f, 111.08361f, 45.90309f);
generalPath.curveTo(111.08361f, 45.90309f, 103.97452f, 47.12061f, 98.03052f, 48.61089f);
generalPath.lineTo(96.15203f, 45.33341f);
generalPath.lineTo(99.92966f, 43.238194f);
generalPath.lineTo(94.063095f, 31.014462f);
generalPath.lineTo(89.09047f, 32.145885f);
generalPath.lineTo(81.81083f, 17.269123f);
generalPath.curveTo(82.627464f, 10.314834f, 87.8772f, 5.0299788f, 96.73078f, 3.3872688f);
generalPath.curveTo(96.818855f, 3.3709273f, 96.894646f, 3.3408887f, 96.983604f, 3.3256197f);
generalPath.closePath();
generalPath.moveTo(15.895147f, 104.81653f);
generalPath.curveTo(16.26487f, 104.74745f, 16.65916f, 104.72423f, 17.055864f, 104.70345f);
generalPath.curveTo(20.708307f, 104.51223f, 24.25026f, 108.03667f, 24.419373f, 112.24391f);
generalPath.curveTo(24.55928f, 115.72457f, 21.05594f, 119.36428f, 17.403484f, 119.55552f);
generalPath.curveTo(13.751044f, 119.74676f, 10.040662f, 116.07204f, 9.812256f, 112.25599f);
generalPath.curveTo(9.611653f, 108.90412f, 11.962719f, 105.55124f, 15.895147f, 104.81653f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(27.960590362548828, 118.94361877441406), 54.613575f, new Point2D.Double(27.960590362548828, 118.94361877441406), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.2185019999742508f, -0.06817850470542908f, 0.7665978074073792f, 2.4568331241607666f, -46.677696228027344f, -138.76422119140625f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_32
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(16.232155f, 102.01072f);
generalPath.curveTo(21.775145f, 100.70575f, 28.08237f, 106.92142f, 26.866657f, 112.78154f);
generalPath.curveTo(31.015247f, 109.34654f, 78.75559f, 56.10324f, 79.74557f, 53.541145f);

}

private void _paint1(Graphics2D g,float origAlpha) {
generalPath.curveTo(81.261536f, 49.617764f, 77.16749f, 46.07273f, 73.273476f, 47.74378f);
generalPath.curveTo(70.55741f, 48.90932f, 15.871363f, 102.09566f, 16.232155f, 102.01072f);
generalPath.closePath();
shape = generalPath;
paint = new Color(136, 138, 133, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.8f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_33
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(16.232155f, 102.01072f);
generalPath.curveTo(21.775145f, 100.70575f, 28.08237f, 106.92142f, 26.866657f, 112.78154f);
generalPath.curveTo(31.015247f, 109.34654f, 78.75559f, 56.10324f, 79.74557f, 53.541145f);
generalPath.curveTo(81.261536f, 49.617764f, 77.16749f, 46.07273f, 73.273476f, 47.74378f);
generalPath.curveTo(70.55741f, 48.90932f, 15.871363f, 102.09566f, 16.232155f, 102.01072f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.27722773f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_34
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(16.232155f, 102.01072f);
generalPath.curveTo(21.775145f, 100.70575f, 28.08237f, 106.92142f, 26.866657f, 112.78154f);
generalPath.curveTo(31.015247f, 109.34654f, 78.75559f, 56.10324f, 79.74557f, 53.541145f);
generalPath.curveTo(81.261536f, 49.617764f, 77.16749f, 46.07273f, 73.273476f, 47.74378f);
generalPath.curveTo(70.55741f, 48.90932f, 15.871363f, 102.09566f, 16.232155f, 102.01072f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(62.261756896972656, 77.16757202148438), 33.8983f, new Point2D.Double(56.3128547668457, 65.78478240966797), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.46496209502220154f, 1.0036473274230957f, -0.2853744924068451f, 0.19584140181541443f, 69.72379302978516f, -13.486393928527832f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_35
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(16.232155f, 102.01072f);
generalPath.curveTo(21.775145f, 100.70575f, 28.08237f, 106.92142f, 26.866657f, 112.78154f);
generalPath.curveTo(31.015247f, 109.34654f, 78.75559f, 56.10324f, 79.74557f, 53.541145f);
generalPath.curveTo(81.261536f, 49.617764f, 77.16749f, 46.07273f, 73.273476f, 47.74378f);
generalPath.curveTo(70.55741f, 48.90932f, 15.871363f, 102.09566f, 16.232155f, 102.01072f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(22.596113204956055, 66.94859313964844), 33.8983f, new Point2D.Double(22.596113204956055, 66.94859313964844), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0280267000198364f, -0.1270724982023239f, 0.12083090096712112f, 0.8628811240196228f, 4.8158745765686035f, 36.95241165161133f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.40366971f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_36
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(73.18765f, 47.861862f);
generalPath.curveTo(73.491806f, 47.67448f, 76.06339f, 46.39183f, 78.43782f, 48.481457f);
generalPath.curveTo(80.46467f, 50.26519f, 80.19145f, 52.111168f, 79.62674f, 53.772774f);
generalPath.curveTo(79.35402f, 54.575203f, 57.436592f, 79.42743f, 53.502075f, 83.94927f);
generalPath.curveTo(51.56737f, 86.17278f, 44.946823f, 93.4093f, 38.872307f, 100.09385f);
generalPath.curveTo(32.743702f, 106.83792f, 26.988342f, 112.68787f, 26.988342f, 112.68787f);
generalPath.curveTo(26.988342f, 112.68787f, 78.91766f, 54.799923f, 79.23133f, 53.220657f);
generalPath.curveTo(79.69114f, 50.90555f, 78.74288f, 50.168694f, 77.961334f, 49.429157f);
generalPath.curveTo(77.16482f, 48.675453f, 75.76331f, 47.833115f, 73.85575f, 48.220253f);
generalPath.curveTo(71.225204f, 48.75412f, 17.354036f, 101.5522f, 16.334658f, 101.93961f);
generalPath.curveTo(16.334658f, 101.93961f, 29.27099f, 89.13053f, 42.923256f, 75.956696f);
generalPath.curveTo(56.575523f, 62.78286f, 70.943726f, 49.244267f, 73.18765f, 47.861862f);
generalPath.closePath();
shape = generalPath;
paint = new Color(46, 52, 54, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_37
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(16.748453f, 101.47356f);
generalPath.curveTo(16.748453f, 101.47356f, 21.04421f, 100.44245f, 24.714842f, 103.88237f);
generalPath.curveTo(28.72916f, 107.64437f, 27.508091f, 112.12407f, 27.508091f, 112.12407f);
generalPath.lineTo(26.862528f, 112.89493f);
generalPath.curveTo(26.862528f, 112.89493f, 27.215576f, 111.18054f, 26.798235f, 109.49869f);
generalPath.curveTo(26.380892f, 107.81683f, 25.494253f, 106.08882f, 23.98318f, 104.69772f);
generalPath.curveTo(22.494114f, 103.32688f, 21.082584f, 102.44431f, 19.548952f, 102.11602f);
generalPath.curveTo(18.015322f, 101.78774f, 16.271942f, 102.02457f, 16.3069f, 101.95858f);
generalPath.lineTo(16.748453f, 101.47356f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(18.988296508789062, 99.09947967529297), 4.9090157f, new Point2D.Double(18.988296508789062, 99.09947967529297), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0280267000198364f, -0.1270724982023239f, 0.17794890701770782f, 1.2707730531692505f, -14.990971565246582f, -16.39053726196289f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_38
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(16.748453f, 101.47356f);
generalPath.curveTo(16.748453f, 101.47356f, 21.04421f, 100.44245f, 24.714842f, 103.88237f);
generalPath.curveTo(28.72916f, 107.64437f, 27.508091f, 112.12407f, 27.508091f, 112.12407f);
generalPath.lineTo(26.862528f, 112.89493f);
generalPath.curveTo(26.862528f, 112.89493f, 27.215576f, 111.18054f, 26.798235f, 109.49869f);
generalPath.curveTo(26.380892f, 107.81683f, 25.494253f, 106.08882f, 23.98318f, 104.69772f);
generalPath.curveTo(22.494114f, 103.32688f, 21.082584f, 102.44431f, 19.548952f, 102.11602f);
generalPath.curveTo(18.015322f, 101.78774f, 16.271942f, 102.02457f, 16.3069f, 101.95858f);
generalPath.lineTo(16.748453f, 101.47356f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(18.988296508789062, 99.09947967529297), 4.9090157f, new Point2D.Double(18.988296508789062, 99.09947967529297), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0280267000198364f, -0.1270724982023239f, 0.17794890701770782f, 1.2707730531692505f, -14.990971565246582f, -16.39053726196289f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_39
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(104.608f, 3.193915f);
generalPath.curveTo(92.61614f, 2.204592f, 83.866394f, 6.3602734f, 82.4504f, 15.463498f);
generalPath.curveTo(84.09662f, 8.506007f, 91.39909f, 2.857369f, 104.608f, 3.193915f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7772277f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_40
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(104.608f, 3.193915f);
generalPath.curveTo(92.465416f, 1.4810786f, 82.87157f, 5.8477845f, 82.4504f, 15.463498f);
generalPath.curveTo(84.75984f, 8.626593f, 91.39909f, 3.1286864f, 104.608f, 3.193915f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.7772277f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_41
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(99.8125f, 3.15625f);
generalPath.curveTo(95.03056f, 3.1270397f, 90.87366f, 4.127752f, 87.875f, 6.15625f);
generalPath.curveTo(85.32026f, 7.884452f, 83.58831f, 10.335174f, 82.96875f, 13.46875f);
generalPath.curveTo(85.4595f, 8.288529f, 90.73924f, 4.176798f, 99.8125f, 3.15625f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_42
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(75.43467f, 47.3125f);
generalPath.curveTo(74.728775f, 47.290955f, 74.00855f, 47.43668f, 73.27842f, 47.75f);
generalPath.curveTo(70.56236f, 48.915543f, 15.88638f, 102.08494f, 16.247171f, 102.0f);
generalPath.curveTo(16.624176f, 101.91124f, 16.990704f, 101.8654f, 17.372171f, 101.84375f);
generalPath.curveTo(23.203625f, 95.959625f, 70.73569f, 49.841167f, 73.27842f, 48.75f);
generalPath.curveTo(76.39545f, 47.412388f, 79.634995f, 49.41576f, 80.02842f, 52.28125f);
generalPath.curveTo(80.2859f, 49.617687f, 78.08462f, 47.39338f, 75.43467f, 47.3125f);
generalPath.closePath();
generalPath.moveTo(26.997171f, 111.6875f);
generalPath.curveTo(26.97794f, 112.05461f, 26.948153f, 112.41499f, 26.872171f, 112.78125f);
generalPath.curveTo(26.89551f, 112.76193f, 26.971088f, 112.70996f, 26.997171f, 112.6875f);
generalPath.curveTo(26.99772f, 112.67701f, 26.996666f, 112.66674f, 26.997171f, 112.65625f);
generalPath.curveTo(27.012821f, 112.33112f, 27.022957f, 112.01037f, 26.997171f, 111.6875f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
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
	private configure_4() {
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
       configure_4 base = new configure_4();
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
       configure_4 base = new configure_4();
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
        return configure_4::new;
    }
}

