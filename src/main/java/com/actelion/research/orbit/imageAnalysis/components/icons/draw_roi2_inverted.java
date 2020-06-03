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
public class draw_roi2_inverted implements ResizableIcon {
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
g.transform(new AffineTransform(1.0666667222976685f, 0.0f, 0.0f, 1.0666667222976685f, -0.0f, -0.0f));
// _0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, -343.7007751464844f));
// _0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0
shape = new Rectangle2D.Double(3.5714111328125, 348.0765075683594, 700.7142944335938, 701.4285888671875);
paint = new Color(255, 255, 0, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 255, 0, 255);
stroke = new BasicStroke(3.0f,0,0,4.0f,null,0.0f);
shape = new Rectangle2D.Double(3.5714111328125, 348.0765075683594, 700.7142944335938, 701.4285888671875);
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
generalPath.moveTo(391.08337f, 372.17047f);
generalPath.curveTo(343.77356f, 372.5863f, 296.49747f, 376.77914f, 249.8529f, 384.69598f);
generalPath.curveTo(225.22812f, 388.87546f, 200.38104f, 394.23334f, 178.40942f, 406.11176f);
generalPath.curveTo(167.42363f, 412.05096f, 157.24586f, 419.611f, 148.92793f, 428.92627f);
generalPath.curveTo(140.60999f, 438.24152f, 134.18576f, 449.34894f, 130.96397f, 461.41467f);
generalPath.curveTo(127.08695f, 475.93433f, 127.952774f, 491.5235f, 132.3434f, 505.89618f);
generalPath.curveTo(136.73402f, 520.26886f, 144.5488f, 533.4615f, 154.18425f, 544.9945f);
generalPath.curveTo(173.45515f, 568.0605f, 199.48495f, 584.2818f, 225.11761f, 599.978f);
generalPath.curveTo(259.77704f, 621.20184f, 295.70532f, 643.26355f, 318.25238f, 677.0771f);
generalPath.curveTo(329.5259f, 693.9838f, 337.0743f, 713.6908f, 337.8231f, 733.99774f);
generalPath.curveTo(338.57187f, 754.3046f, 332.1373f, 775.1682f, 318.47333f, 790.20905f);
generalPath.curveTo(304.58252f, 805.4996f, 284.28375f, 813.8459f, 263.82047f, 816.676f);
generalPath.curveTo(243.35718f, 819.50616f, 222.54346f, 817.2753f, 202.11465f, 814.20624f);
generalPath.curveTo(181.68585f, 811.13715f, 161.2966f, 807.2232f, 140.64569f, 806.6795f);
generalPath.curveTo(119.99478f, 806.13586f, 98.76662f, 809.16486f, 80.695465f, 819.1743f);
generalPath.curveTo(62.367516f, 829.326f, 48.155968f, 846.45337f, 40.880867f, 866.1013f);
generalPath.curveTo(33.605766f, 885.7493f, 33.18837f, 907.7473f, 39.015755f, 927.87225f);
generalPath.curveTo(44.84314f, 947.9972f, 56.790497f, 966.2017f, 72.453964f, 980.1167f);
generalPath.curveTo(88.11743f, 994.0317f, 107.4095f, 1003.69025f, 127.77229f, 1008.62244f);
generalPath.curveTo(150.60397f, 1014.15265f, 174.57344f, 1013.80896f, 197.76938f, 1010.09174f);
generalPath.curveTo(220.96532f, 1006.3745f, 243.5023f, 999.35645f, 265.68494f, 991.62335f);
generalPath.curveTo(310.05023f, 976.1573f, 354.49146f, 957.5095f, 401.45618f, 956.17194f);
generalPath.curveTo(448.27744f, 954.83844f, 493.85544f, 970.87213f, 540.5607f, 974.4255f);
generalPath.curveTo(563.9133f, 976.20215f, 587.8661f, 974.7572f, 609.84955f, 966.6807f);
generalPath.curveTo(631.833f, 958.60425f, 651.7552f, 943.3844f, 662.3735f, 922.50964f);
generalPath.curveTo(670.5937f, 906.34937f, 672.8925f, 887.4929f, 670.22614f, 869.5592f);
generalPath.curveTo(667.5598f, 851.6255f, 660.09845f, 834.5955f, 649.92346f, 819.5889f);
generalPath.curveTo(629.57355f, 789.5758f, 599.18427f, 768.0573f, 569.0177f, 747.9355f);
generalPath.curveTo(547.89923f, 733.84894f, 526.11365f, 719.7108f, 510.69565f, 699.5439f);
generalPath.curveTo(502.98666f, 689.4604f, 497.00208f, 677.9184f, 494.2837f, 665.5202f);
generalPath.curveTo(491.56528f, 653.122f, 492.23526f, 639.83954f, 497.2056f, 628.16046f);
generalPath.curveTo(503.8123f, 612.63635f, 517.42896f, 601.02277f, 532.2789f, 593.0149f);
generalPath.curveTo(547.1288f, 585.0071f, 563.40796f, 580.104f, 579.2135f, 574.2022f);
generalPath.curveTo(595.01904f, 568.3005f, 610.76373f, 561.1474f, 623.029f, 549.5625f);
generalPath.curveTo(629.1616f, 543.7701f, 634.34424f, 536.898f, 637.72925f, 529.17126f);
generalPath.curveTo(641.11426f, 521.44446f, 642.65674f, 512.8439f, 641.62775f, 504.47113f);
generalPath.curveTo(640.7109f, 497.01117f, 637.77765f, 489.8656f, 633.58545f, 483.62723f);
generalPath.curveTo(629.39325f, 477.38885f, 623.9659f, 472.03503f, 617.9559f, 467.52148f);
generalPath.curveTo(605.9359f, 458.4944f, 591.7682f, 452.8651f, 577.79474f, 447.32352f);
generalPath.curveTo(515.4302f, 422.59085f, 453.1919f, 397.53943f, 391.08337f, 372.17047f);
generalPath.closePath();
shape = generalPath;
paint = new Color(72, 69, 55, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 255, 0, 255);
stroke = new BasicStroke(55.323944f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(391.08337f, 372.17047f);
generalPath.curveTo(343.77356f, 372.5863f, 296.49747f, 376.77914f, 249.8529f, 384.69598f);
generalPath.curveTo(225.22812f, 388.87546f, 200.38104f, 394.23334f, 178.40942f, 406.11176f);
generalPath.curveTo(167.42363f, 412.05096f, 157.24586f, 419.611f, 148.92793f, 428.92627f);
generalPath.curveTo(140.60999f, 438.24152f, 134.18576f, 449.34894f, 130.96397f, 461.41467f);
generalPath.curveTo(127.08695f, 475.93433f, 127.952774f, 491.5235f, 132.3434f, 505.89618f);
generalPath.curveTo(136.73402f, 520.26886f, 144.5488f, 533.4615f, 154.18425f, 544.9945f);
generalPath.curveTo(173.45515f, 568.0605f, 199.48495f, 584.2818f, 225.11761f, 599.978f);
generalPath.curveTo(259.77704f, 621.20184f, 295.70532f, 643.26355f, 318.25238f, 677.0771f);
generalPath.curveTo(329.5259f, 693.9838f, 337.0743f, 713.6908f, 337.8231f, 733.99774f);
generalPath.curveTo(338.57187f, 754.3046f, 332.1373f, 775.1682f, 318.47333f, 790.20905f);
generalPath.curveTo(304.58252f, 805.4996f, 284.28375f, 813.8459f, 263.82047f, 816.676f);
generalPath.curveTo(243.35718f, 819.50616f, 222.54346f, 817.2753f, 202.11465f, 814.20624f);
generalPath.curveTo(181.68585f, 811.13715f, 161.2966f, 807.2232f, 140.64569f, 806.6795f);
generalPath.curveTo(119.99478f, 806.13586f, 98.76662f, 809.16486f, 80.695465f, 819.1743f);
generalPath.curveTo(62.367516f, 829.326f, 48.155968f, 846.45337f, 40.880867f, 866.1013f);
generalPath.curveTo(33.605766f, 885.7493f, 33.18837f, 907.7473f, 39.015755f, 927.87225f);
generalPath.curveTo(44.84314f, 947.9972f, 56.790497f, 966.2017f, 72.453964f, 980.1167f);
generalPath.curveTo(88.11743f, 994.0317f, 107.4095f, 1003.69025f, 127.77229f, 1008.62244f);
generalPath.curveTo(150.60397f, 1014.15265f, 174.57344f, 1013.80896f, 197.76938f, 1010.09174f);
generalPath.curveTo(220.96532f, 1006.3745f, 243.5023f, 999.35645f, 265.68494f, 991.62335f);
generalPath.curveTo(310.05023f, 976.1573f, 354.49146f, 957.5095f, 401.45618f, 956.17194f);
generalPath.curveTo(448.27744f, 954.83844f, 493.85544f, 970.87213f, 540.5607f, 974.4255f);
generalPath.curveTo(563.9133f, 976.20215f, 587.8661f, 974.7572f, 609.84955f, 966.6807f);
generalPath.curveTo(631.833f, 958.60425f, 651.7552f, 943.3844f, 662.3735f, 922.50964f);
generalPath.curveTo(670.5937f, 906.34937f, 672.8925f, 887.4929f, 670.22614f, 869.5592f);
generalPath.curveTo(667.5598f, 851.6255f, 660.09845f, 834.5955f, 649.92346f, 819.5889f);
generalPath.curveTo(629.57355f, 789.5758f, 599.18427f, 768.0573f, 569.0177f, 747.9355f);
generalPath.curveTo(547.89923f, 733.84894f, 526.11365f, 719.7108f, 510.69565f, 699.5439f);
generalPath.curveTo(502.98666f, 689.4604f, 497.00208f, 677.9184f, 494.2837f, 665.5202f);
generalPath.curveTo(491.56528f, 653.122f, 492.23526f, 639.83954f, 497.2056f, 628.16046f);
generalPath.curveTo(503.8123f, 612.63635f, 517.42896f, 601.02277f, 532.2789f, 593.0149f);
generalPath.curveTo(547.1288f, 585.0071f, 563.40796f, 580.104f, 579.2135f, 574.2022f);
generalPath.curveTo(595.01904f, 568.3005f, 610.76373f, 561.1474f, 623.029f, 549.5625f);
generalPath.curveTo(629.1616f, 543.7701f, 634.34424f, 536.898f, 637.72925f, 529.17126f);
generalPath.curveTo(641.11426f, 521.44446f, 642.65674f, 512.8439f, 641.62775f, 504.47113f);
generalPath.curveTo(640.7109f, 497.01117f, 637.77765f, 489.8656f, 633.58545f, 483.62723f);
generalPath.curveTo(629.39325f, 477.38885f, 623.9659f, 472.03503f, 617.9559f, 467.52148f);
generalPath.curveTo(605.9359f, 458.4944f, 591.7682f, 452.8651f, 577.79474f, 447.32352f);
generalPath.curveTo(515.4302f, 422.59085f, 453.1919f, 397.53943f, 391.08337f, 372.17047f);
generalPath.closePath();
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
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
generalPath.moveTo(353.02197f, 372.732f);
generalPath.lineTo(353.02197f, 362.30624f);
generalPath.lineTo(353.02197f, 372.732f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.38139534f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(676.89496f, 819.6589f);
generalPath.curveTo(676.895f, 824.87054f, 648.5474f, 829.8687f, 598.0884f, 833.55396f);
generalPath.curveTo(547.6293f, 837.23914f, 479.19208f, 839.30945f, 407.83215f, 839.30945f);
generalPath.curveTo(336.47223f, 839.30945f, 268.03503f, 837.23914f, 217.57596f, 833.55396f);
generalPath.curveTo(167.11688f, 829.8687f, 138.7693f, 824.87054f, 138.76935f, 819.6589f);
generalPath.curveTo(138.7693f, 814.4472f, 167.11688f, 809.44904f, 217.57596f, 805.7638f);
generalPath.curveTo(268.03503f, 802.0786f, 336.47223f, 800.0083f, 407.83215f, 800.0083f);
generalPath.curveTo(479.19208f, 800.0083f, 547.6293f, 802.0786f, 598.0884f, 805.7638f);
generalPath.curveTo(648.5474f, 809.44904f, 676.895f, 814.4472f, 676.89496f, 819.6589f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(63.912208557128906, 115.70919036865234), 63.91221f, new Point2D.Double(14.046639442443848, 115.70919036865234), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(4.20988130569458f, 0.0f, 0.0f, 0.3074614405632019f, 138.7693328857422f, 784.0827026367188f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(628.9133f, 362.00558f);
generalPath.curveTo(631.1634f, 359.84766f, 645.671f, 361.1014f, 660.90643f, 373.66754f);
generalPath.curveTo(676.29126f, 386.35687f, 679.2074f, 398.4606f, 676.3889f, 401.16345f);
generalPath.curveTo(674.55444f, 402.9228f, 672.72f, 404.6821f, 670.8855f, 406.44144f);
generalPath.curveTo(655.0602f, 393.3888f, 639.235f, 380.33618f, 623.4097f, 367.28354f);
generalPath.curveTo(625.2442f, 365.5242f, 627.07874f, 363.7649f, 628.9133f, 362.00555f);
generalPath.curveTo(628.9133f, 362.00555f, 628.9133f, 362.00555f, 628.9133f, 362.00555f);
shape = generalPath;
paint = new Color(0, 0, 0, 255);
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
generalPath.moveTo(196.23973f, 819.94055f);
generalPath.lineTo(325.6214f, 738.2057f);
generalPath.lineTo(326.35495f, 737.5022f);
generalPath.lineTo(279.6585f, 697.5969f);
generalPath.lineTo(278.66425f, 698.5501f);
generalPath.lineTo(196.23975f, 819.9406f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(203.7178f, 813.27216f);
generalPath.lineTo(324.3718f, 737.09717f);
generalPath.lineTo(325.1053f, 736.3937f);
generalPath.lineTo(280.90817f, 698.7053f);
generalPath.lineTo(279.91385f, 699.6585f);
generalPath.lineTo(203.7178f, 813.27216f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(42.617530822753906, 120.64187622070312), 3.406888f, new Point2D.Double(42.617530822753906, 120.64187622070312), new float[] {0.0f,1.0f}, new Color[] {new Color(180, 148, 42, 255),new Color(228, 220, 201, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(6.570230960845947f, 6.1048383712768555f, -62.44815444946289f, 52.842552185058594f, 7558.2216796875f, -5905.86083984375f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(298.77533f, 721.6083f);
generalPath.curveTo(304.6311f, 726.43805f, 310.61917f, 724.62744f, 312.71237f, 726.3538f);
generalPath.curveTo(313.05063f, 726.6328f, 313.27524f, 727.01373f, 313.43427f, 727.42096f);
generalPath.lineTo(661.58966f, 392.88388f);
generalPath.lineTo(638.57623f, 373.90244f);
generalPath.lineTo(289.75983f, 709.0733f);
generalPath.curveTo(290.80933f, 708.9983f, 291.74008f, 709.0558f, 292.40213f, 709.6019f);
generalPath.curveTo(294.31537f, 711.18f, 292.8924f, 716.756f, 298.77533f, 721.6083f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(15.727076530456543, 58.08968734741211), 2.6143966f, new Point2D.Double(15.727076530456543, 58.08968734741211), new float[] {0.0f,0.5f,0.75f,1.0f}, new Color[] {new Color(37, 37, 37, 255),new Color(37, 37, 37, 255),new Color(37, 37, 37, 255),new Color(0, 0, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(8.260855674743652f, 6.9448347091674805f, -112.30320739746094f, 107.24173736572266f, 6817.0888671875f, -5744.421875f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.35348833f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_6
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(325.8609f, 714.0049f);
generalPath.lineTo(312.22806f, 727.0789f);
generalPath.curveTo(314.05768f, 728.86194f, 311.54773f, 733.7736f, 315.0645f, 736.6742f);
generalPath.curveTo(318.85452f, 739.80023f, 322.96957f, 736.2571f, 325.43253f, 738.2648f);
generalPath.lineTo(339.2306f, 725.0321f);
generalPath.lineTo(325.86087f, 714.0049f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_7
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(660.74945f, 392.19095f);
generalPath.lineTo(312.8585f, 726.47437f);
generalPath.curveTo(314.69815f, 728.2658f, 312.82568f, 732.57874f, 316.3606f, 735.49414f);
generalPath.curveTo(320.16992f, 738.6362f, 323.65585f, 735.6986f, 326.13132f, 737.71643f);
generalPath.lineTo(674.1875f, 403.27466f);
generalPath.lineTo(660.74945f, 392.19095f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(36.6756477355957, 95.76927947998047), 47.746403f, new Point2D.Double(16.21735382080078, 64.14128112792969), new float[] {0.0f,0.09292036f,0.5043171f,0.91571385f,1.0f}, new Color[] {new Color(154, 118, 0, 255),new Color(227, 173, 0, 255),new Color(255, 205, 44, 255),new Color(227, 173, 0, 255),new Color(185, 141, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.28099381923675537f, 0.23880119621753693f, -5.642953872680664f, 5.276689529418945f, 1006.7507934570312f, 45.78274917602539f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.38604653f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_8
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(299.02985f, 703.2516f);
generalPath.lineTo(292.0365f, 709.9583f);
generalPath.lineTo(291.77164f, 710.20654f);
generalPath.curveTo(293.33435f, 711.5822f, 291.05197f, 716.5794f, 296.06674f, 721.5355f);
generalPath.lineTo(296.35898f, 721.7765f);
generalPath.lineTo(298.44116f, 723.49384f);
generalPath.lineTo(298.7334f, 723.7349f);
generalPath.curveTo(304.72302f, 727.8554f, 310.1521f, 725.3667f, 312.2452f, 727.0931f);
generalPath.lineTo(319.6517f, 719.9531f);
generalPath.lineTo(299.02982f, 703.2516f);
generalPath.closePath();
shape = generalPath;
paint = new Color(37, 37, 37, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.35348833f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_9
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(285.73077f, 692.1508f);
generalPath.lineTo(278.65155f, 698.5677f);
generalPath.curveTo(278.72495f, 698.62787f, 278.14713f, 699.187f, 278.22076f, 699.24774f);
generalPath.curveTo(279.72296f, 700.4867f, 277.639f, 705.48145f, 280.13733f, 708.39703f);
generalPath.lineTo(280.39304f, 708.6079f);
generalPath.lineTo(281.5254f, 709.54193f);
generalPath.lineTo(281.67157f, 709.66235f);
generalPath.curveTo(285.20917f, 711.76044f, 289.9579f, 709.14984f, 291.77167f, 710.2066f);
generalPath.lineTo(299.1005f, 703.1782f);
generalPath.lineTo(285.73077f, 692.1509f);
generalPath.closePath();
shape = generalPath;
paint = new Color(19, 19, 19, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_10
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(282.27237f, 707.82104f);
generalPath.curveTo(285.95947f, 710.79175f, 290.45035f, 707.9921f, 292.40213f, 709.6019f);
generalPath.lineTo(640.29315f, 375.31854f);
generalPath.lineTo(626.71185f, 364.11676f);
generalPath.lineTo(278.65558f, 698.55865f);
generalPath.curveTo(278.73016f, 698.61975f, 278.80338f, 698.6806f, 278.8782f, 698.7424f);
generalPath.curveTo(280.40417f, 700.0009f, 278.55774f, 704.8275f, 282.2724f, 707.8211f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(11.326383590698242, 57.38399887084961), new Point2D.Double(14.493531227111816, 57.38399887084961), new float[] {0.0f,0.09292036f,0.5043171f,0.91571385f,1.0f}, new Color[] {new Color(154, 118, 0, 255),new Color(227, 173, 0, 255),new Color(255, 205, 44, 255),new Color(227, 173, 0, 255),new Color(185, 141, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(4.569131374359131f, 3.779585838317871f, -4.249693870544434f, 4.063684463500977f, 642.5931396484375f, 256.6349792480469f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7719321250915527f, 0.6357049942016602f, -0.7237294316291809f, 0.6900838017463684f, 0.0f, 0.0f));
// _0_0_2_11
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(701.1333f, -121.01515f);
generalPath.lineTo(762.6639f, -121.01515f);
generalPath.lineTo(762.6639f, -106.67726f);
generalPath.lineTo(701.1333f, -106.67726f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7219375371932983f, -0.6919582486152649f, -0.7724744081497192f, -0.6350458860397339f, 0.0f, 0.0f));
// _0_0_2_12
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(119.72179f, -709.89f);
generalPath.curveTo(119.72179f, -707.834f, 98.91623f, -705.8621f, 61.882088f, -704.4083f);
generalPath.curveTo(24.847948f, -702.95447f, -25.381126f, -702.1377f, -77.75531f, -702.1377f);
generalPath.curveTo(-130.1295f, -702.1377f, -180.35858f, -702.95447f, -217.39272f, -704.4083f);
generalPath.curveTo(-254.42686f, -705.8621f, -275.23242f, -707.834f, -275.23242f, -709.89f);
generalPath.curveTo(-275.23242f, -711.94604f, -254.42686f, -713.9179f, -217.39273f, -715.3717f);
generalPath.curveTo(-180.35858f, -716.82556f, -130.12952f, -717.64233f, -77.755325f, -717.64233f);
generalPath.curveTo(-25.381142f, -717.64233f, 24.847933f, -716.82556f, 61.882072f, -715.3717f);
generalPath.curveTo(98.916214f, -713.9179f, 119.72177f, -711.94604f, 119.72177f, -709.89f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(34.67763900756836, 7.462276935577393), 47.595196f, new Point2D.Double(34.67763900756836, 7.462276935577393), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 174),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(4.157475471496582f, -0.06257937848567963f, 0.0023558600805699825f, 0.16346268355846405f, -221.94430541992188f, -708.939697265625f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7207286953926086f, -0.6932172775268555f, -0.7712075710296631f, -0.6365837454795837f, 0.0f, 0.0f));
// _0_0_2_13
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(122.9193f, -717.7872f);
generalPath.curveTo(122.91923f, -716.4419f, 13.114985f, -715.3484f, -123.0309f, -715.3378f);
generalPath.curveTo(-259.1778f, -715.3273f, -370.7075f, -716.4036f, -372.8449f, -717.7487f);
generalPath.curveTo(-374.9853f, -719.0938f, -266.93268f, -720.2043f, -130.81923f, -720.23596f);
generalPath.curveTo(5.2921505f, -720.26764f, 118.51848f, -719.2088f, 122.796936f, -717.8642f);
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(34.67763900756836, 7.462276935577393), 47.595196f, new Point2D.Double(34.67763900756836, 7.462276935577393), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 174),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-5.208438873291016f, 0.015292719937860966f, -4.024799563921988E-4f, -0.05274736136198044f, 55.64145278930664f, -717.9238891601562f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_14
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(604.5706f, 385.3876f);
generalPath.curveTo(597.86127f, 389.1182f, 591.5023f, 395.621f, 588.0864f, 401.19617f);
generalPath.lineTo(626.2529f, 432.38962f);
generalPath.lineTo(642.7371f, 416.58105f);
generalPath.lineTo(604.5707f, 385.3876f);
generalPath.closePath();
generalPath.moveTo(638.72577f, 413.2726f);
generalPath.lineTo(622.2416f, 429.08118f);
generalPath.lineTo(635.6123f, 440.1093f);
generalPath.curveTo(641.45667f, 436.99585f, 648.16235f, 430.80072f, 652.0965f, 424.30075f);
generalPath.lineTo(638.7257f, 413.2726f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(49.009883880615234, 8.495311737060547), 3.9750404f, new Point2D.Double(47.370887756347656, 6.770169734954834), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(174, 174, 174, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(5.934463024139404f, 4.894739151000977f, -2.0734591484069824f, 1.9884785413742065f, 347.0319519042969f, 155.96505737304688f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_15
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(251.87437f, 784.957f);
generalPath.curveTo(243.19154f, 784.2003f, 235.72958f, 772.5368f, 230.9276f, 768.9684f);
generalPath.lineTo(196.24658f, 819.91486f);
generalPath.lineTo(251.87437f, 784.957f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7714493274688721f, 0.6362907290458679f, -0.7217420935630798f, 0.6921620965003967f, 0.0f, 0.0f));
// _0_0_2_16
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(718.94617f, -123.67453f);
generalPath.lineTo(745.47986f, -123.67453f);
generalPath.lineTo(745.47986f, -117.9172f);
generalPath.lineTo(718.94617f, -117.9172f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(49.01197052001953, 2.6743078231811523), 1.7246193f, new Point2D.Double(49.01197052001953, 2.6743078231811523), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(37, 37, 37, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(7.692623615264893f, 0.0f, 0.0f, 0.9276914000511169f, 355.1824035644531f, -123.84526062011719f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_17
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(656.1493f, 370.85483f);
generalPath.curveTo(666.00684f, 377.82935f, 672.9651f, 387.35995f, 673.34094f, 388.27097f);
generalPath.curveTo(673.71686f, 389.18198f, 664.20703f, 378.49463f, 656.0475f, 373.54507f);
generalPath.curveTo(647.9503f, 368.6333f, 636.51434f, 368.34613f, 635.67993f, 367.75034f);
generalPath.curveTo(634.8455f, 367.15457f, 629.2287f, 361.71378f, 634.4108f, 361.9874f);
generalPath.curveTo(639.8311f, 362.2736f, 648.5352f, 365.4727f, 656.1493f, 370.85483f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(48.49856185913086, 0.8115049600601196), new Point2D.Double(48.732723236083984, 2.365726947784424), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 174),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(5.934463024139404f, 4.894739151000977f, -5.503552436828613f, 5.277980327606201f, 376.17156982421875f, 128.01966857910156f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2_18
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(351.46066f, 698.456f);
generalPath.curveTo(350.3892f, 699.4825f, 349.7841f, 700.46497f, 349.6452f, 701.4035f);
generalPath.curveTo(349.50632f, 702.34216f, 349.8468f, 703.1499f, 350.6667f, 703.8268f);
generalPath.curveTo(351.4831f, 704.5008f, 352.41235f, 704.7414f, 353.45447f, 704.54865f);
generalPath.curveTo(354.4966f, 704.3557f, 355.55334f, 703.74615f, 356.62476f, 702.7197f);
generalPath.curveTo(357.70233f, 701.6874f, 358.31046f, 700.70197f, 358.4494f, 699.76337f);
generalPath.curveTo(358.58826f, 698.8247f, 358.24942f, 698.0185f, 357.4331f, 697.3444f);
generalPath.curveTo(356.61322f, 696.6675f, 355.68222f, 696.4255f, 354.64014f, 696.61835f);
generalPath.curveTo(353.59802f, 696.81116f, 352.53824f, 697.4237f, 351.46072f, 698.456f);
generalPath.moveTo(350.00687f, 697.25555f);
generalPath.curveTo(352.19843f, 695.156f, 354.27292f, 693.80676f, 356.23044f, 693.2079f);
generalPath.curveTo(358.1879f, 692.609f, 359.79724f, 692.83026f, 361.05826f, 693.8714f);
generalPath.curveTo(362.31583f, 694.9098f, 362.68152f, 696.31915f, 362.1553f, 698.0998f);
generalPath.curveTo(361.62906f, 699.88043f, 360.27017f, 701.8205f, 358.0786f, 703.9201f);
generalPath.curveTo(355.8932f, 706.0138f, 353.8187f, 707.36304f, 351.85504f, 707.9678f);
generalPath.curveTo(349.89755f, 708.5666f, 348.29004f, 708.3469f, 347.0324f, 707.30853f);
generalPath.curveTo(345.7714f, 706.2674f, 345.40396f, 704.85645f, 345.9302f, 703.07587f);
generalPath.curveTo(346.46252f, 701.2894f, 347.8214f, 699.34937f, 350.00684f, 697.25555f);
generalPath.moveTo(370.55765f, 684.6127f);
generalPath.lineTo(379.2585f, 683.35956f);
generalPath.lineTo(375.59677f, 686.8676f);
generalPath.lineTo(369.75235f, 687.7264f);
generalPath.lineTo(369.2505f, 692.9475f);
generalPath.lineTo(365.57056f, 696.47296f);
generalPath.lineTo(366.32977f, 688.663f);
generalPath.lineTo(357.97314f, 689.8745f);
generalPath.lineTo(361.64398f, 686.3577f);
generalPath.lineTo(367.1364f, 685.5666f);
generalPath.lineTo(367.6068f, 680.6452f);
generalPath.lineTo(371.2959f, 677.11096f);
generalPath.lineTo(370.55768f, 684.6126f);
generalPath.moveTo(371.6794f, 676.7435f);
generalPath.lineTo(375.52374f, 673.0606f);
generalPath.lineTo(381.40063f, 672.3751f);
generalPath.lineTo(381.7331f, 667.1118f);
generalPath.lineTo(385.58655f, 663.4201f);
generalPath.lineTo(384.89307f, 672.1151f);
generalPath.lineTo(388.17084f, 674.82135f);
generalPath.lineTo(384.65518f, 678.18945f);
generalPath.lineTo(381.3775f, 675.48315f);
generalPath.lineTo(371.67944f, 676.7436f);
generalPath.moveTo(406.54922f, 656.1827f);
generalPath.curveTo(405.9157f, 657.22327f, 405.18802f, 658.2457f, 404.36606f, 659.25006f);
generalPath.curveTo(403.54407f, 660.25446f, 402.63083f, 661.2378f, 401.6264f, 662.2001f);
generalPath.curveTo(399.35568f, 664.3755f, 397.19556f, 665.80054f, 395.14584f, 666.47534f);
generalPath.curveTo(393.0927f, 667.14734f, 391.446f, 666.9712f, 390.20578f, 665.94727f);
generalPath.curveTo(388.9516f, 664.9118f, 388.64075f, 663.4498f, 389.27313f, 661.5614f);
generalPath.curveTo(389.90546f, 659.67285f, 391.39658f, 657.6031f, 393.74634f, 655.3519f);
generalPath.curveTo(394.65344f, 654.4829f, 395.56955f, 653.69196f, 396.49472f, 652.9791f);
generalPath.curveTo(397.426f, 652.26044f, 398.35544f, 651.6272f, 399.2831f, 651.07916f);
generalPath.lineTo(400.89334f, 652.4087f);
generalPath.curveTo(399.8857f, 652.934f, 398.9437f, 653.5081f, 398.06723f, 654.13086f);
generalPath.curveTo(397.19687f, 654.74774f, 396.3842f, 655.4179f, 395.6294f, 656.14105f);
generalPath.curveTo(394.22925f, 657.4824f, 393.3728f, 658.70264f, 393.05997f, 659.80164f);
generalPath.curveTo(392.7498f, 660.892f, 393.00986f, 661.77997f, 393.84012f, 662.4654f);
generalPath.curveTo(394.66345f, 663.1452f, 395.6645f, 663.3201f, 396.84317f, 662.9903f);
generalPath.curveTo(398.0218f, 662.66046f, 399.28375f, 661.85114f, 400.62918f, 660.5622f);
generalPath.curveTo(400.9944f, 660.21234f, 401.32007f, 659.8786f, 401.60626f, 659.56104f);
generalPath.curveTo(401.89502f, 659.23486f, 402.13644f, 658.9292f, 402.33038f, 658.6442f);
generalPath.lineTo(400.81924f, 657.3965f);
generalPath.lineTo(398.6733f, 659.45233f);
generalPath.lineTo(397.32895f, 658.3423f);
generalPath.lineTo(402.80777f, 653.0934f);
generalPath.lineTo(406.5493f, 656.18256f);
generalPath.moveTo(402.43408f, 647.2797f);
generalPath.lineTo(411.92163f, 638.19037f);
generalPath.lineTo(413.438f, 639.4423f);
generalPath.lineTo(407.46603f, 645.16364f);
generalPath.lineTo(408.9147f, 646.35974f);
generalPath.lineTo(414.53055f, 640.9796f);
generalPath.lineTo(416.04694f, 642.2316f);
generalPath.lineTo(410.43112f, 647.61176f);
generalPath.lineTo(412.21332f, 649.08325f);
generalPath.lineTo(418.38614f, 643.1695f);
generalPath.lineTo(419.90256f, 644.4215f);
generalPath.lineTo(410.2141f, 653.70337f);
generalPath.lineTo(402.4341f, 647.2798f);
generalPath.moveTo(415.2181f, 635.03235f);
generalPath.lineTo(419.1446f, 631.2706f);
generalPath.lineTo(429.43903f, 630.9261f);
generalPath.lineTo(424.10297f, 626.5204f);
generalPath.lineTo(427.4359f, 623.32733f);
generalPath.lineTo(435.2159f, 629.75085f);
generalPath.lineTo(431.2894f, 633.5126f);
generalPath.lineTo(420.99496f, 633.85706f);
generalPath.lineTo(426.33105f, 638.2628f);
generalPath.lineTo(422.99808f, 641.4559f);
generalPath.lineTo(415.21808f, 635.03235f);
generalPath.moveTo(437.3526f, 613.8268f);
generalPath.lineTo(441.2791f, 610.0651f);
generalPath.lineTo(451.57352f, 609.7205f);
generalPath.lineTo(446.23746f, 605.3149f);
generalPath.lineTo(449.5704f, 602.12177f);
generalPath.lineTo(457.3504f, 608.5453f);
generalPath.lineTo(453.42392f, 612.307f);
generalPath.lineTo(443.1295f, 612.6515f);
generalPath.lineTo(448.46558f, 617.05725f);
generalPath.lineTo(445.13263f, 620.2503f);
generalPath.lineTo(437.3526f, 613.8268f);
generalPath.moveTo(456.4061f, 595.32196f);
generalPath.curveTo(457.7028f, 594.0798f, 458.91827f, 593.2591f, 460.05264f, 592.8601f);
generalPath.curveTo(461.19315f, 592.4554f, 462.09338f, 592.5254f, 462.75345f, 593.0704f);
generalPath.curveTo(463.41348f, 593.61536f, 463.5602f, 594.40424f, 463.19357f, 595.43713f);
generalPath.curveTo(462.82693f, 596.47003f, 461.99225f, 597.6105f, 460.6895f, 598.8585f);
generalPath.curveTo(459.38675f, 600.1066f, 458.1669f, 600.9345f, 457.02988f, 601.3421f);
generalPath.curveTo(455.89896f, 601.74396f, 455.00345f, 601.67236f, 454.3434f, 601.12744f);
generalPath.curveTo(453.68332f, 600.58246f, 453.5349f, 599.7921f, 453.89807f, 598.75635f);
generalPath.curveTo(454.26733f, 597.7148f, 455.10336f, 596.57f, 456.40607f, 595.3219f);
generalPath.moveTo(457.57877f, 603.00055f);
generalPath.lineTo(465.0939f, 595.80084f);
generalPath.lineTo(466.13608f, 596.6613f);
generalPath.lineTo(458.6209f, 603.8611f);
generalPath.lineTo(457.57874f, 603.0006f);
generalPath.moveTo(457.2919f, 596.05334f);
generalPath.curveTo(456.78058f, 596.5433f, 456.49432f, 597.0127f, 456.4331f, 597.4617f);
generalPath.curveTo(456.378f, 597.90485f, 456.55197f, 598.2928f, 456.95496f, 598.6255f);
generalPath.curveTo(457.35794f, 598.9582f, 457.8041f, 599.0823f, 458.29343f, 598.9976f);
generalPath.curveTo(458.78885f, 598.9072f, 459.29224f, 598.617f, 459.80356f, 598.1271f);
generalPath.curveTo(460.30887f, 597.64307f, 460.59076f, 597.1809f, 460.64935f, 596.7406f);
generalPath.curveTo(460.71396f, 596.2945f, 460.54477f, 595.9051f, 460.1418f, 595.5723f);
generalPath.curveTo(459.73883f, 595.2396f, 459.2879f, 595.11707f, 458.789f, 595.2046f);
generalPath.curveTo(458.29623f, 595.2864f, 457.79718f, 595.5693f, 457.29187f, 596.0533f);
generalPath.moveTo(480.58624f, 578.80225f);
generalPath.curveTo(481.64093f, 578.0335f, 482.57422f, 577.5608f, 483.38602f, 577.3841f);
generalPath.curveTo(484.20047f, 577.1987f, 484.8665f, 577.3198f, 485.38412f, 577.74713f);
generalPath.curveTo(486.15533f, 578.38385f, 486.22498f, 579.3643f, 485.59308f, 580.6885f);
generalPath.curveTo(484.95767f, 582.0098f, 483.6477f, 583.6211f, 481.66315f, 585.52234f);
generalPath.curveTo(480.96307f, 586.19305f, 480.227f, 586.8394f, 479.45477f, 587.4614f);
generalPath.curveTo(478.69217f, 588.0805f, 477.90268f, 588.6665f, 477.08627f, 589.2194f);
generalPath.lineTo(475.53854f, 587.9415f);
generalPath.curveTo(476.38364f, 587.4666f, 477.1774f, 586.96014f, 477.91998f, 586.42224f);
generalPath.curveTo(478.66513f, 585.8757f, 479.3513f, 585.302f, 479.9783f, 584.7013f);
generalPath.curveTo(480.90967f, 583.80896f, 481.5299f, 583.0506f, 481.83887f, 582.4262f);
generalPath.curveTo(482.1539f, 581.79596f, 482.13947f, 581.33887f, 481.79556f, 581.0549f);
generalPath.curveTo(481.44122f, 580.7623f, 480.91803f, 580.7864f, 480.22604f, 581.1272f);
generalPath.curveTo(479.53665f, 581.4592f, 478.69583f, 582.1006f, 477.70355f, 583.0512f);
generalPath.lineTo(476.29733f, 584.39844f);
generalPath.lineTo(475.005f, 583.3314f);
generalPath.lineTo(476.48428f, 581.91425f);
generalPath.curveTo(477.36697f, 581.0686f, 477.94626f, 580.3742f, 478.22217f, 579.831f);
generalPath.curveTo(478.4946f, 579.28503f, 478.46924f, 578.8786f, 478.14627f, 578.6119f);
generalPath.curveTo(477.84744f, 578.3652f, 477.40646f, 578.3757f, 476.8231f, 578.6432f);
generalPath.curveTo(476.23978f, 578.9108f, 475.5646f, 579.41205f, 474.79755f, 580.14685f);
generalPath.curveTo(474.2314f, 580.6893f, 473.69568f, 581.26764f, 473.19028f, 581.88184f);
generalPath.curveTo(472.6849f, 582.49615f, 472.21735f, 583.1362f, 471.7875f, 583.802f);
generalPath.lineTo(470.31802f, 582.58875f);
generalPath.curveTo(470.90082f, 581.8321f, 471.50534f, 581.10425f, 472.13156f, 580.40515f);
generalPath.curveTo(472.75778f, 579.7061f, 473.39966f, 579.0416f, 474.0571f, 578.41174f);
generalPath.curveTo(475.8286f, 576.71466f, 477.31937f, 575.5838f, 478.5295f, 575.01935f);
generalPath.curveTo(479.74225f, 574.44617f, 480.6821f, 574.435f, 481.34912f, 574.9857f);
generalPath.curveTo(481.8042f, 575.3615f, 481.96765f, 575.8711f, 481.83945f, 576.5144f);
generalPath.curveTo(481.70767f, 577.15485f, 481.28998f, 577.91754f, 480.5863f, 578.80237f);
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(49.15303039550781, 75.31031799316406), new Point2D.Double(82.4846420288086, 75.31031799316406), new float[] {0.0f,1.0f}, new Color[] {new Color(180, 148, 42, 255),new Color(228, 220, 201, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(4.20988130569458f, 0.0f, 0.0f, 3.7305328845977783f, 138.7693328857422f, 360.4909973144531f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.7279376983642578f, 0.6856433153152466f, -0.8170589208602905f, 0.5765541195869446f, 0.0f, 0.0f));
// _0_0_2_19
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(671.8705f, -172.63637f);
generalPath.lineTo(689.923f, -172.63637f);
generalPath.lineTo(689.923f, -168.64201f);
generalPath.lineTo(671.8705f, -168.64201f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(49.01197052001953, 2.6743078231811523), 1.7246193f, new Point2D.Double(49.01197052001953, 2.6743078231811523), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(37, 37, 37, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(5.233759880065918f, 0.0f, 0.0f, 0.6436169147491455f, 424.3800354003906f, -172.7548065185547f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(-0.7817000150680542f, -0.6236546039581299f, -0.6515713334083557f, 0.7585873603820801f, 0.0f, 0.0f));
// _0_0_2_20
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(-775.9558f, -110.2087f);
generalPath.lineTo(-757.72314f, -110.2087f);
generalPath.lineTo(-757.72314f, -106.330765f);
generalPath.lineTo(-775.9558f, -106.330765f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(49.01197052001953, 2.6743078231811523), 1.7246193f, new Point2D.Double(49.01197052001953, 2.6743078231811523), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(37, 37, 37, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(5.286000728607178f, 0.0f, 0.0f, 0.6248621940612793f, -1025.91650390625f, -110.32372283935547f));
g.setPaint(paint);
g.fill(shape);
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
        return 2.209505319595337;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 0.8106120228767395;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 750.6286010742188;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 753.6473999023438;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private draw_roi2_inverted() {
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
       draw_roi2_inverted base = new draw_roi2_inverted();
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
       draw_roi2_inverted base = new draw_roi2_inverted();
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
        return draw_roi2_inverted::new;
    }
}

