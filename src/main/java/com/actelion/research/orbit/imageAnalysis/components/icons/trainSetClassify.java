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
public class trainSetClassify implements ResizableIcon {
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
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -87.73738861083984f, 169.78179931640625f));
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
generalPath.moveTo(103.49224f, -158.01137f);
generalPath.curveTo(105.91442f, -157.39821f, 106.6281f, -158.77254f, 107.91674f, -159.44807f);
generalPath.curveTo(108.93876f, -159.9839f, 112.52321f, -157.50323f, 110.41414f, -156.635f);
generalPath.curveTo(107.9836f, -155.63434f, 107.2213f, -153.9185f, 106.97722f, -153.29385f);
generalPath.curveTo(105.57436f, -149.70354f, 113.98223f, -149.49315f, 111.85636f, -146.94028f);
generalPath.curveTo(110.30832f, -145.08134f, 106.19702f, -148.26518f, 106.03769f, -147.1396f);
generalPath.curveTo(105.79201f, -145.40405f, 106.52936f, -142.50153f, 104.04238f, -142.68695f);
generalPath.curveTo(98.80966f, -143.07709f, 93.42447f, -147.70811f, 91.04664f, -150.9294f);
generalPath.curveTo(88.77316f, -154.00932f, 90.88205f, -157.85484f, 92.901146f, -160.45464f);
generalPath.curveTo(94.13483f, -162.04308f, 96.890076f, -165.21397f, 99.35725f, -164.1237f);
generalPath.curveTo(102.15677f, -162.8866f, 97.39288f, -159.55544f, 103.49224f, -158.01137f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(2.651973f,0,1,5.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(103.49224f, -158.01137f);
generalPath.curveTo(105.91442f, -157.39821f, 106.6281f, -158.77254f, 107.91674f, -159.44807f);
generalPath.curveTo(108.93876f, -159.9839f, 112.52321f, -157.50323f, 110.41414f, -156.635f);
generalPath.curveTo(107.9836f, -155.63434f, 107.2213f, -153.9185f, 106.97722f, -153.29385f);
generalPath.curveTo(105.57436f, -149.70354f, 113.98223f, -149.49315f, 111.85636f, -146.94028f);
generalPath.curveTo(110.30832f, -145.08134f, 106.19702f, -148.26518f, 106.03769f, -147.1396f);
generalPath.curveTo(105.79201f, -145.40405f, 106.52936f, -142.50153f, 104.04238f, -142.68695f);
generalPath.curveTo(98.80966f, -143.07709f, 93.42447f, -147.70811f, 91.04664f, -150.9294f);
generalPath.curveTo(88.77316f, -154.00932f, 90.88205f, -157.85484f, 92.901146f, -160.45464f);
generalPath.curveTo(94.13483f, -162.04308f, 96.890076f, -165.21397f, 99.35725f, -164.1237f);
generalPath.curveTo(102.15677f, -162.8866f, 97.39288f, -159.55544f, 103.49224f, -158.01137f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
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
generalPath.moveTo(103.93986f, -156.80972f);
generalPath.curveTo(106.36204f, -156.19653f, 107.07572f, -157.57092f, 108.36438f, -158.2465f);
generalPath.curveTo(109.38638f, -158.78226f, 112.97081f, -156.30162f, 110.86174f, -155.43333f);
generalPath.curveTo(108.43122f, -154.43275f, 107.6689f, -152.7169f, 107.42482f, -152.09224f);
generalPath.curveTo(106.02196f, -148.50188f, 114.42985f, -148.29156f, 112.30394f, -145.73862f);
generalPath.curveTo(110.75592f, -143.8797f, 106.64466f, -147.06355f, 106.48531f, -145.93799f);
generalPath.curveTo(106.23961f, -144.20244f, 106.97696f, -141.29991f, 104.49004f, -141.4853f);
generalPath.curveTo(99.25726f, -141.87544f, 93.872055f, -146.50648f, 91.49424f, -149.72775f);
generalPath.curveTo(89.220764f, -152.80771f, 91.329666f, -156.65321f, 93.34877f, -159.253f);
generalPath.curveTo(94.58242f, -160.84142f, 97.3377f, -164.01236f, 99.804825f, -162.92209f);
generalPath.curveTo(102.60435f, -161.68495f, 97.8405f, -158.35382f, 103.93986f, -156.80972f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(33.29081344604492, 36.0700569152832), 5.0383153f, new Point2D.Double(33.29081344604492, 36.0700569152832), new float[] {0.0f,1.0f}, new Color[] {new Color(114, 159, 207, 255),new Color(52, 101, 164, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(2.621142625808716f, -1.1363786458969116f, 1.496679663658142f, 1.9917453527450562f, -38.39169692993164f, -181.4340362548828f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(32, 74, 135, 255);
stroke = new BasicStroke(2.651973f,0,1,5.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(103.93986f, -156.80972f);
generalPath.curveTo(106.36204f, -156.19653f, 107.07572f, -157.57092f, 108.36438f, -158.2465f);
generalPath.curveTo(109.38638f, -158.78226f, 112.97081f, -156.30162f, 110.86174f, -155.43333f);
generalPath.curveTo(108.43122f, -154.43275f, 107.6689f, -152.7169f, 107.42482f, -152.09224f);
generalPath.curveTo(106.02196f, -148.50188f, 114.42985f, -148.29156f, 112.30394f, -145.73862f);
generalPath.curveTo(110.75592f, -143.8797f, 106.64466f, -147.06355f, 106.48531f, -145.93799f);
generalPath.curveTo(106.23961f, -144.20244f, 106.97696f, -141.29991f, 104.49004f, -141.4853f);
generalPath.curveTo(99.25726f, -141.87544f, 93.872055f, -146.50648f, 91.49424f, -149.72775f);
generalPath.curveTo(89.220764f, -152.80771f, 91.329666f, -156.65321f, 93.34877f, -159.253f);
generalPath.curveTo(94.58242f, -160.84142f, 97.3377f, -164.01236f, 99.804825f, -162.92209f);
generalPath.curveTo(102.60435f, -161.68495f, 97.8405f, -158.35382f, 103.93986f, -156.80972f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.77011496f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(102.11652f, -144.48087f);
generalPath.curveTo(104.61384f, -144.83945f, 105.43002f, -147.4788f, 104.43122f, -150.2895f);
generalPath.curveTo(102.42137f, -147.09785f, 98.556114f, -149.21895f, 94.431786f, -150.26306f);
generalPath.curveTo(95.43061f, -147.45236f, 100.40192f, -144.40468f, 102.11652f, -144.48087f);
generalPath.closePath();
shape = generalPath;
paint = new Color(238, 238, 236, 255);
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
generalPath.moveTo(115.92873f, -163.60362f);
generalPath.curveTo(113.844f, -164.1116f, 110.39334f, -165.26749f, 109.62067f, -166.42538f);
generalPath.curveTo(107.8139f, -169.13289f, 105.44823f, -166.72707f, 106.8895f, -165.08842f);
generalPath.curveTo(108.55047f, -163.20003f, 110.92876f, -161.76654f, 110.95575f, -161.12971f);
generalPath.curveTo(111.11084f, -157.46931f, 106.05186f, -161.10886f, 107.03501f, -158.02058f);
generalPath.curveTo(107.62329f, -156.17255f, 110.62709f, -157.85081f, 111.38041f, -155.38841f);
generalPath.curveTo(111.97892f, -153.43216f, 109.83018f, -153.97385f, 110.822f, -152.73538f);
generalPath.curveTo(115.49129f, -146.90475f, 119.94257f, -148.82143f, 123.43369f, -150.58015f);
generalPath.curveTo(126.92482f, -152.33887f, 127.54428f, -156.85678f, 124.75703f, -160.74666f);
generalPath.curveTo(123.61233f, -162.34425f, 123.43492f, -165.55717f, 121.77645f, -166.34245f);
generalPath.curveTo(119.39669f, -167.46925f, 121.17841f, -162.32443f, 115.92873f, -163.60362f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(2.205277f,0,1,5.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(115.92873f, -163.60362f);
generalPath.curveTo(113.844f, -164.1116f, 110.39334f, -165.26749f, 109.62067f, -166.42538f);
generalPath.curveTo(107.8139f, -169.13289f, 105.44823f, -166.72707f, 106.8895f, -165.08842f);
generalPath.curveTo(108.55047f, -163.20003f, 110.92876f, -161.76654f, 110.95575f, -161.12971f);
generalPath.curveTo(111.11084f, -157.46931f, 106.05186f, -161.10886f, 107.03501f, -158.02058f);
generalPath.curveTo(107.62329f, -156.17255f, 110.62709f, -157.85081f, 111.38041f, -155.38841f);
generalPath.curveTo(111.97892f, -153.43216f, 109.83018f, -153.97385f, 110.822f, -152.73538f);
generalPath.curveTo(115.49129f, -146.90475f, 119.94257f, -148.82143f, 123.43369f, -150.58015f);
generalPath.curveTo(126.92482f, -152.33887f, 127.54428f, -156.85678f, 124.75703f, -160.74666f);
generalPath.curveTo(123.61233f, -162.34425f, 123.43492f, -165.55717f, 121.77645f, -166.34245f);
generalPath.curveTo(119.39669f, -167.46925f, 121.17841f, -162.32443f, 115.92873f, -163.60362f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
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
generalPath.moveTo(116.30811f, -162.6233f);
generalPath.curveTo(114.22338f, -163.13129f, 110.77278f, -164.28717f, 110.00007f, -165.4451f);
generalPath.curveTo(108.19328f, -168.15254f, 105.82763f, -165.74675f, 107.2689f, -164.10808f);
generalPath.curveTo(108.92985f, -162.2197f, 111.30814f, -160.78625f, 111.33515f, -160.14937f);
generalPath.curveTo(111.49025f, -156.48895f, 106.43124f, -160.12852f, 107.41439f, -157.04027f);
generalPath.curveTo(108.00267f, -155.19228f, 111.00647f, -156.87051f, 111.75983f, -154.4081f);
generalPath.curveTo(112.3583f, -152.45186f, 110.20956f, -152.99355f, 111.20138f, -151.75504f);
generalPath.curveTo(115.87069f, -145.92444f, 120.32197f, -147.84116f, 123.81306f, -149.59984f);
generalPath.curveTo(127.30424f, -151.35855f, 127.92369f, -155.87643f, 125.13641f, -159.76637f);
generalPath.curveTo(123.9917f, -161.36394f, 123.8143f, -164.57684f, 122.15582f, -165.36214f);
generalPath.curveTo(119.77608f, -166.48895f, 121.55781f, -161.34412f, 116.30811f, -162.6233f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(32.450172424316406, 33.60939407348633), 5.0383153f, new Point2D.Double(32.450172424316406, 33.60939407348633), new float[] {0.0f,1.0f}, new Color[] {new Color(239, 41, 41, 255),new Color(204, 0, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-1.2623417377471924f, -1.7617435455322266f, -1.451930046081543f, 0.7107487320899963f, 210.0374755859375f, -120.59613037109375f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(164, 0, 0, 255);
stroke = new BasicStroke(2.205277f,0,1,5.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(116.30811f, -162.6233f);
generalPath.curveTo(114.22338f, -163.13129f, 110.77278f, -164.28717f, 110.00007f, -165.4451f);
generalPath.curveTo(108.19328f, -168.15254f, 105.82763f, -165.74675f, 107.2689f, -164.10808f);
generalPath.curveTo(108.92985f, -162.2197f, 111.30814f, -160.78625f, 111.33515f, -160.14937f);
generalPath.curveTo(111.49025f, -156.48895f, 106.43124f, -160.12852f, 107.41439f, -157.04027f);
generalPath.curveTo(108.00267f, -155.19228f, 111.00647f, -156.87051f, 111.75983f, -154.4081f);
generalPath.curveTo(112.3583f, -152.45186f, 110.20956f, -152.99355f, 111.20138f, -151.75504f);
generalPath.curveTo(115.87069f, -145.92444f, 120.32197f, -147.84116f, 123.81306f, -149.59984f);
generalPath.curveTo(127.30424f, -151.35855f, 127.92369f, -155.87643f, 125.13641f, -159.76637f);
generalPath.curveTo(123.9917f, -161.36394f, 123.8143f, -164.57684f, 122.15582f, -165.36214f);
generalPath.curveTo(119.77608f, -166.48895f, 121.55781f, -161.34412f, 116.30811f, -162.6233f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.77011496f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(113.79138f, -151.2347f);
generalPath.curveTo(116.65062f, -148.9142f, 120.42543f, -149.71819f, 121.88586f, -150.76216f);
generalPath.curveTo(123.34634f, -151.80614f, 125.4567f, -154.02902f, 124.51378f, -156.83867f);
generalPath.curveTo(123.25666f, -154.66315f, 121.74235f, -153.38223f, 120.26432f, -152.46153f);
generalPath.curveTo(118.78413f, -151.53941f, 117.07703f, -150.57417f, 113.79138f, -151.2347f);
generalPath.closePath();
shape = generalPath;
paint = new Color(238, 238, 236, 255);
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
generalPath.moveTo(128.70381f, -158.0614f);
generalPath.curveTo(131.64404f, -158.65987f, 128.988f, -160.51553f, 127.82756f, -161.52165f);
generalPath.curveTo(126.90727f, -162.31963f, 129.04382f, -164.90128f, 130.65094f, -163.26639f);
generalPath.curveTo(132.503f, -161.3823f, 133.47636f, -159.07162f, 134.30728f, -158.85635f);
generalPath.curveTo(139.0833f, -157.61894f, 136.23279f, -162.71402f, 139.93237f, -160.99849f);
generalPath.curveTo(142.14626f, -159.97192f, 138.76646f, -158.1164f, 141.72816f, -156.77258f);
generalPath.curveTo(144.081f, -155.70505f, 144.19698f, -157.56322f, 145.4494f, -156.40434f);
generalPath.curveTo(151.34543f, -150.94888f, 147.09044f, -148.02534f, 143.41576f, -145.81033f);
generalPath.curveTo(139.74104f, -143.59528f, 133.53246f, -144.48355f, 129.47192f, -147.86485f);
generalPath.curveTo(125.41143f, -151.24615f, 125.06729f, -155.81425f, 128.70381f, -158.0614f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(2.3351312f,0,1,5.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(128.70381f, -158.0614f);
generalPath.curveTo(131.64404f, -158.65987f, 128.988f, -160.51553f, 127.82756f, -161.52165f);
generalPath.curveTo(126.90727f, -162.31963f, 129.04382f, -164.90128f, 130.65094f, -163.26639f);
generalPath.curveTo(132.503f, -161.3823f, 133.47636f, -159.07162f, 134.30728f, -158.85635f);
generalPath.curveTo(139.0833f, -157.61894f, 136.23279f, -162.71402f, 139.93237f, -160.99849f);
generalPath.curveTo(142.14626f, -159.97192f, 138.76646f, -158.1164f, 141.72816f, -156.77258f);
generalPath.curveTo(144.081f, -155.70505f, 144.19698f, -157.56322f, 145.4494f, -156.40434f);
generalPath.curveTo(151.34543f, -150.94888f, 147.09044f, -148.02534f, 143.41576f, -145.81033f);
generalPath.curveTo(139.74104f, -143.59528f, 133.53246f, -144.48355f, 129.47192f, -147.86485f);
generalPath.curveTo(125.41143f, -151.24615f, 125.06729f, -155.81425f, 128.70381f, -158.0614f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
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
generalPath.moveTo(128.5991f, -156.95432f);
generalPath.curveTo(131.53938f, -157.5527f, 128.8833f, -159.40837f, 127.72289f, -160.4145f);
generalPath.curveTo(126.80256f, -161.21246f, 128.93916f, -163.79411f, 130.54628f, -162.15927f);
generalPath.curveTo(132.39828f, -160.27519f, 133.37169f, -157.9645f, 134.20262f, -157.74922f);
generalPath.curveTo(138.97862f, -156.51183f, 136.1281f, -161.6069f, 139.82774f, -159.89136f);
generalPath.curveTo(142.04155f, -158.8648f, 138.66177f, -157.00922f, 141.62346f, -155.66544f);
generalPath.curveTo(143.97633f, -154.5979f, 144.09229f, -156.45602f, 145.3447f, -155.2972f);
generalPath.curveTo(151.24074f, -149.8417f, 146.98576f, -146.91821f, 143.3111f, -144.70319f);
generalPath.curveTo(139.63638f, -142.4881f, 133.42773f, -143.37642f, 129.36723f, -146.75772f);
generalPath.curveTo(125.30672f, -150.13905f, 124.96264f, -154.7071f, 128.5991f, -156.95432f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(23.537704467773438, 36.02513122558594), 4.244812f, new Point2D.Double(23.537704467773438, 36.02513122558594), new float[] {0.0f,1.0f}, new Color[] {new Color(138, 226, 52, 255),new Color(115, 210, 22, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-2.6048038005828857f, -0.5043509006500244f, 0.3967912793159485f, -1.9879266023635864f, 185.57362365722656f, -65.80636596679688f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(78, 154, 6, 255);
stroke = new BasicStroke(2.3351312f,0,1,5.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(128.5991f, -156.95432f);
generalPath.curveTo(131.53938f, -157.5527f, 128.8833f, -159.40837f, 127.72289f, -160.4145f);
generalPath.curveTo(126.80256f, -161.21246f, 128.93916f, -163.79411f, 130.54628f, -162.15927f);
generalPath.curveTo(132.39828f, -160.27519f, 133.37169f, -157.9645f, 134.20262f, -157.74922f);
generalPath.curveTo(138.97862f, -156.51183f, 136.1281f, -161.6069f, 139.82774f, -159.89136f);
generalPath.curveTo(142.04155f, -158.8648f, 138.66177f, -157.00922f, 141.62346f, -155.66544f);
generalPath.curveTo(143.97633f, -154.5979f, 144.09229f, -156.45602f, 145.3447f, -155.2972f);
generalPath.curveTo(151.24074f, -149.8417f, 146.98576f, -146.91821f, 143.3111f, -144.70319f);
generalPath.curveTo(139.63638f, -142.4881f, 133.42773f, -143.37642f, 129.36723f, -146.75772f);
generalPath.curveTo(125.30672f, -150.13905f, 124.96264f, -154.7071f, 128.5991f, -156.95432f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.77011496f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(132.07626f, -148.09686f);
generalPath.curveTo(135.47269f, -145.90656f, 139.95663f, -146.66547f, 141.69145f, -147.65088f);
generalPath.curveTo(143.42628f, -148.63629f, 145.93314f, -150.73445f, 144.8131f, -153.38646f);
generalPath.curveTo(143.31976f, -151.33302f, 141.52097f, -150.124f, 139.76527f, -149.25488f);
generalPath.curveTo(138.00697f, -148.3845f, 135.97919f, -147.47342f, 132.07626f, -148.09686f);
generalPath.closePath();
shape = generalPath;
paint = new Color(238, 238, 236, 255);
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
generalPath.moveTo(119.05743f, -137.78683f);
generalPath.curveTo(115.51431f, -137.78683f, 114.64295f, -135.86617f, 114.64295f, -133.49615f);
generalPath.curveTo(114.64295f, -131.91615f, 113.92347f, -130.53854f, 115.82432f, -129.79372f);
generalPath.lineTo(115.82432f, -127.71758f);
generalPath.curveTo(115.82432f, -127.18779f, 116.45486f, -126.76603f, 117.24689f, -126.76603f);
generalPath.lineTo(121.64391f, -126.76603f);
generalPath.curveTo(122.43594f, -126.76603f, 123.09234f, -127.18779f, 123.09234f, -127.71758f);
generalPath.lineTo(123.09234f, -130.15704f);
generalPath.curveTo(124.54372f, -130.94379f, 123.4719f, -132.14922f, 123.4719f, -133.49615f);
generalPath.curveTo(123.4719f, -135.86617f, 122.60054f, -137.78683f, 119.05743f, -137.78683f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 170, 170, 255);
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
generalPath.moveTo(93.84375f, -143.53125f);
generalPath.curveTo(93.84375f, -143.53125f, 94.03707f, -141.4167f, 95.90625f, -139.49544f);
generalPath.curveTo(95.13952f, -135.1072f, 95.45999f, -132.64339f, 97.0f, -129.66814f);
generalPath.curveTo(100.74802f, -125.68304f, 104.02066f, -120.17135f, 109.65625f, -123.87663f);
generalPath.curveTo(113.43222f, -130.30524f, 105.92692f, -131.88535f, 101.53125f, -132.63228f);
generalPath.curveTo(100.46818f, -134.95331f, 98.47306f, -136.69778f, 97.5625f, -139.10782f);
generalPath.curveTo(97.35132f, -139.29715f, 97.21199f, -139.43573f, 97.09375f, -139.56384f);
generalPath.lineTo(99.6875f, -140.33908f);
generalPath.lineTo(99.875f, -143.23483f);
generalPath.lineTo(93.84375f, -143.53125f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_11
paint = new Color(0, 255, 255, 255);
stroke = new BasicStroke(0.69157016f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(108.06361f, -122.97364f);
generalPath.curveTo(108.06361f, -122.97364f, 113.12912f, -118.80656f, 113.12912f, -117.66061f);
generalPath.curveTo(113.12912f, -116.51467f, 113.78984f, -112.7643f, 113.78984f, -112.7643f);
generalPath.curveTo(116.61414f, -112.60294f, 122.48508f, -112.56154f, 125.9204f, -112.7643f);
generalPath.curveTo(125.9204f, -112.7643f, 126.58112f, -116.51467f, 126.58112f, -117.66061f);
generalPath.curveTo(126.58112f, -118.80656f, 131.64664f, -122.97364f, 131.64664f, -122.97364f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_12
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(143.79387f, -142.92247f);
generalPath.curveTo(143.79387f, -142.92247f, 143.60056f, -140.80792f, 141.73137f, -138.88666f);
generalPath.curveTo(142.4981f, -134.49841f, 142.17763f, -132.0346f, 140.63762f, -129.05936f);
generalPath.curveTo(136.8896f, -125.07426f, 133.61696f, -119.56257f, 127.98137f, -123.26785f);
generalPath.curveTo(124.2054f, -129.69646f, 131.7107f, -131.27657f, 136.10637f, -132.0235f);
generalPath.curveTo(137.16943f, -134.34453f, 139.16457f, -136.089f, 140.07512f, -138.49904f);
generalPath.curveTo(140.2863f, -138.68837f, 140.42563f, -138.82695f, 140.54387f, -138.95506f);
generalPath.lineTo(137.95012f, -139.7303f);
generalPath.lineTo(137.76262f, -142.62605f);
generalPath.lineTo(143.79387f, -142.92247f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.1f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-0.9859529733657837f, -0.16702300310134888f, 0.22242410480976105f, -0.9749500155448914f, 0.0f, 0.0f));
// _0_0_13
shape = new Ellipse2D.Double(-104.32527160644531, 177.1243896484375, 20.220224380493164, 3.2251930236816406);
paint = new RadialGradientPaint(new Point2D.Double(10.5625, 46.0625), 8.5625f, new Point2D.Double(10.5625, 46.0625), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.1807430982589722f, 0.0f, 0.0f, 0.1883324235677719f, -106.68675231933594f, 170.06192016601562f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.16475093f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-0.9812189936637878f, -0.19289711117744446f, 0.13416674733161926f, -0.6824724078178406f, 139.29917907714844f, -137.73524475097656f));
// _0_0_14
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(35.609375f, 8.318359f);
generalPath.curveTo(35.493538f, 8.314848f, 35.380154f, 8.352181f, 35.289062f, 8.423828f);
generalPath.curveTo(26.312515f, 15.437283f, 21.689367f, 20.761894f, 19.117188f, 24.189453f);
generalPath.curveTo(17.405073f, 26.302582f, 15.48999f, 29.478264f, 13.9375f, 32.42578f);
generalPath.curveTo(13.909095f, 32.480568f, 13.891208f, 32.540188f, 13.884766f, 32.601562f);
generalPath.curveTo(13.666157f, 34.599228f, 13.792595f, 36.603287f, 14.650391f, 38.371094f);
generalPath.curveTo(14.710156f, 38.4941f, 14.818247f, 38.58682f, 14.9489155f, 38.627167f);
generalPath.curveTo(15.079583f, 38.667515f, 15.221131f, 38.65188f, 15.339844f, 38.583984f);
generalPath.curveTo(19.354279f, 36.273994f, 24.494877f, 31.421762f, 25.871094f, 29.826172f);
generalPath.curveTo(28.807535f, 26.47024f, 33.524033f, 20.533062f, 38.46875f, 11.136719f);
generalPath.curveTo(38.570885f, 10.943213f, 38.533527f, 10.705573f, 38.376953f, 10.552734f);
generalPath.curveTo(37.59823f, 9.789965f, 36.76617f, 9.058277f, 35.884766f, 8.4140625f);
generalPath.curveTo(35.80469f, 8.355178f, 35.70871f, 8.321823f, 35.609375f, 8.318359f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(28.469051361083984, 23.214420318603516), 12.3671f, new Point2D.Double(28.469051361083984, 23.214420318603516), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.16754360496997833f, 0.13406769931316376f, -0.9393553733825684f, 1.1739071607589722f, 43.93767166137695f, -7.586747169494629f));
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
generalPath.moveTo(115.31459f, -151.23206f);
generalPath.curveTo(110.87492f, -149.66061f, 103.02509f, -146.52547f, 93.25521f, -141.11041f);
generalPath.curveTo(92.87454f, -140.94698f, 93.38182f, -140.66512f, 93.708115f, -140.7071f);
generalPath.curveTo(107.31161f, -143.81494f, 114.44336f, -146.65018f, 118.49262f, -148.27586f);
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(33.17571258544922, 18.65762710571289), new Point2D.Double(31.180810928344727, 17.177289962768555), new float[] {0.0f,1.0f}, new Color[] {new Color(193, 125, 17, 255),new Color(233, 185, 110, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-0.8565163612365723f, -0.09019006788730621f, 0.3922135531902313f, -0.48301181197166443f, 126.3838882446289f, -134.5254364013672f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(143, 89, 2, 255);
stroke = new BasicStroke(0.82787037f,0,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(115.31459f, -151.23206f);
generalPath.curveTo(110.87492f, -149.66061f, 103.02509f, -146.52547f, 93.25521f, -141.11041f);
generalPath.curveTo(92.87454f, -140.94698f, 93.38182f, -140.66512f, 93.708115f, -140.7071f);
generalPath.curveTo(107.31161f, -143.81494f, 114.44336f, -146.65018f, 118.49262f, -148.27586f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.15f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_16
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(117.78443f, -148.008f);
generalPath.curveTo(116.31516f, -148.64479f, 115.06901f, -149.47134f, 114.6064f, -150.96419f);
generalPath.curveTo(116.38721f, -151.6026f, 123.35936f, -153.67793f, 127.558f, -154.3192f);
generalPath.lineTo(128.4866f, -153.1728f);
generalPath.curveTo(125.82907f, -151.61755f, 121.08222f, -149.25262f, 117.78443f, -148.008f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.8278704f,0,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(117.78443f, -148.008f);
generalPath.curveTo(116.31516f, -148.64479f, 115.06901f, -149.47134f, 114.6064f, -150.96419f);
generalPath.curveTo(116.38721f, -151.6026f, 123.35936f, -153.67793f, 127.558f, -154.3192f);
generalPath.lineTo(128.4866f, -153.1728f);
generalPath.curveTo(125.82907f, -151.61755f, 121.08222f, -149.25262f, 117.78443f, -148.008f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(118.49262f, -148.27586f);
generalPath.curveTo(117.02335f, -148.91264f, 115.77721f, -149.7392f, 115.31459f, -151.23206f);
generalPath.curveTo(117.0954f, -151.87045f, 124.06755f, -153.94579f, 128.26619f, -154.58707f);
generalPath.lineTo(129.1948f, -153.44067f);
generalPath.curveTo(126.53727f, -151.8854f, 121.79041f, -149.52048f, 118.49262f, -148.27586f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(19.635454177856445, 29.59141731262207), new Point2D.Double(23.529132843017578, 33.4850959777832), new float[] {0.0f,1.0f}, new Color[] {new Color(238, 238, 236, 255),new Color(136, 138, 133, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-0.8565163612365723f, -0.09019006788730621f, 0.3922135531902313f, -0.48301181197166443f, 126.3838882446289f, -134.5254364013672f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(136, 138, 133, 255);
stroke = new BasicStroke(0.82787037f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(118.49262f, -148.27586f);
generalPath.curveTo(117.02335f, -148.91264f, 115.77721f, -149.7392f, 115.31459f, -151.23206f);
generalPath.curveTo(117.0954f, -151.87045f, 124.06755f, -153.94579f, 128.26619f, -154.58707f);
generalPath.lineTo(129.1948f, -153.44067f);
generalPath.curveTo(126.53727f, -151.8854f, 121.79041f, -149.52048f, 118.49262f, -148.27586f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.68000036f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_18
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(128.35434f, -153.73949f);
generalPath.curveTo(121.24782f, -149.38893f, 100.03723f, -142.72697f, 95.58691f, -141.77686f);
generalPath.curveTo(105.52179f, -145.84335f, 117.78618f, -150.19273f, 128.35434f, -153.73949f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(18.1875, 28.625), new Point2D.Double(41.4375, 6.1875), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 133)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-1.0492732524871826f, -0.1777496039867401f, 0.14347213506698608f, -0.6288803815841675f, 136.98849487304688f, -129.78277587890625f));
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
generalPath.moveTo(140.18079f, -155.71819f);
generalPath.curveTo(135.25633f, -156.55357f, 135.04977f, -153.39195f, 132.4434f, -152.85358f);
generalPath.curveTo(129.42311f, -152.22969f, 127.30392f, -153.99573f, 127.07347f, -155.19273f);
generalPath.curveTo(126.78269f, -156.70312f, 128.18471f, -158.07153f, 131.47362f, -158.15674f);
generalPath.curveTo(135.1612f, -158.25227f, 140.05199f, -157.01408f, 140.18079f, -155.71819f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(10.593055725097656, 38.58195495605469), new Point2D.Double(10.165061950683594, 43.38218688964844), new float[] {0.0f,1.0f}, new Color[] {new Color(85, 87, 83, 255),new Color(31, 35, 36, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-1.0492732524871826f, -0.1777496039867401f, 0.1818552315235138f, -0.7971248030662537f, 136.05015563964844f, -120.89279174804688f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(0.8278703f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(140.18079f, -155.71819f);
generalPath.curveTo(135.25633f, -156.55357f, 135.04977f, -153.39195f, 132.4434f, -152.85358f);
generalPath.curveTo(129.42311f, -152.22969f, 127.30392f, -153.99573f, 127.07347f, -155.19273f);
generalPath.curveTo(126.78269f, -156.70312f, 128.18471f, -158.07153f, 131.47362f, -158.15674f);
generalPath.curveTo(135.1612f, -158.25227f, 140.05199f, -157.01408f, 140.18079f, -155.71819f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.29118773f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_20
paint = new LinearGradientPaint(new Point2D.Double(9.343700408935547, 38.8116569519043), new Point2D.Double(10.924744606018066, 46.82093048095703), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 133)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-0.6740690469741821f, -0.11418905854225159f, 0.10252921283245087f, -0.4494155943393707f, 134.49017333984375f, -135.29263305664062f));
stroke = new BasicStroke(0.8278704f,0,1,5.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(138.69081f, -156.35263f);
generalPath.curveTo(136.55148f, -156.6983f, 134.73483f, -155.4258f, 133.95827f, -154.55528f);
generalPath.curveTo(131.61655f, -151.93031f, 126.87952f, -154.1692f, 128.2656f, -156.03754f);
generalPath.curveTo(130.10912f, -159.10973f, 135.49713f, -156.89899f, 138.69081f, -156.35263f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.5f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-0.9859529733657837f, -0.16702300310134888f, 0.22242410480976105f, -0.9749500155448914f, 0.0f, 0.0f));
// _0_0_21
shape = new Ellipse2D.Double(-96.34359741210938, 173.01226806640625, 6.385334491729736, 2.580157995223999);
paint = new LinearGradientPaint(new Point2D.Double(12.186543464660645, 38.012454986572266), new Point2D.Double(12.186543464660645, 39.532230377197266), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 255, 255, 133)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(2.805507183074951f, 0.0f, 0.0f, 1.4068026542663574f, -127.34036254882812f, 119.84757995605469f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_22
paint = new LinearGradientPaint(new Point2D.Double(38.28942108154297, 5.253948211669922), new Point2D.Double(36.610626220703125, 7.3314619064331055), new float[] {0.0f,1.0f}, new Color[] {new Color(234, 197, 134, 255),new Color(234, 197, 134, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-0.8565163612365723f, -0.09019006788730621f, 0.3922135531902313f, -0.48301181197166443f, 126.82469940185547f, -135.99595642089844f));
stroke = new BasicStroke(0.82787037f,1,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(94.36504f, -141.249f);
generalPath.lineTo(97.95573f, -142.60603f);
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
		return 62.162837982177734;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 57.56631851196289;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private trainSetClassify() {
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
       trainSetClassify base = new trainSetClassify();
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
       trainSetClassify base = new trainSetClassify();
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
        return trainSetClassify::new;
    }
}

