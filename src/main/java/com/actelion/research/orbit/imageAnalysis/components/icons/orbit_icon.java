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
public class orbit_icon implements ResizableIcon {
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
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -611.5220336914062f, -766.1766357421875f));
// _0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0124582052230835f, 0.0f, 0.0f, 1.0143442153930664f, -7.411852836608887f, -8.110316276550293f));
// _0_0_0_0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_0
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(639.3693f, 779.3383f);
generalPath.curveTo(639.333f, 779.4151f, 639.2815f, 779.4863f, 639.2443f, 779.56213f);
generalPath.curveTo(639.3222f, 779.53845f, 639.3664f, 779.5479f, 639.4006f, 779.59406f);
generalPath.curveTo(639.4007f, 779.54f, 639.401f, 779.4883f, 639.4006f, 779.4342f);
generalPath.curveTo(639.3976f, 779.4058f, 639.381f, 779.3672f, 639.3694f, 779.3383f);
generalPath.closePath();
generalPath.moveTo(637.3381f, 782.6952f);
generalPath.curveTo(636.29443f, 783.9902f, 635.07135f, 785.1472f, 633.9006f, 786.30786f);
generalPath.curveTo(632.8904f, 787.3514f, 631.67834f, 788.12f, 630.4318f, 788.8335f);
generalPath.curveTo(628.1619f, 790.0561f, 626.36774f, 792.0154f, 624.1506f, 793.3093f);
generalPath.curveTo(624.18304f, 793.31335f, 624.2162f, 793.34564f, 624.24426f, 793.34125f);
generalPath.curveTo(625.41766f, 793.5478f, 626.6205f, 793.75226f, 627.7755f, 794.02496f);
generalPath.curveTo(627.9928f, 794.29626f, 627.7327f, 794.6856f, 627.7755f, 794.9841f);
generalPath.curveTo(628.6602f, 795.07684f, 629.59485f, 794.9881f, 630.49426f, 795.016f);
generalPath.curveTo(632.3111f, 795.013f, 634.1149f, 795.023f, 635.93176f, 795.016f);
generalPath.curveTo(635.86316f, 794.7629f, 635.80426f, 794.5045f, 635.7755f, 794.2487f);
generalPath.curveTo(635.52313f, 791.4807f, 636.4879f, 788.6297f, 636.99426f, 785.95605f);
generalPath.curveTo(637.25574f, 784.8898f, 637.3065f, 783.7868f, 637.338f, 782.69507f);
generalPath.closePath();
generalPath.moveTo(639.0256f, 785.1889f);
generalPath.curveTo(638.97845f, 785.44446f, 639.2225f, 785.5957f, 639.4006f, 785.76434f);
generalPath.curveTo(639.42175f, 785.7202f, 639.44244f, 785.68054f, 639.4631f, 785.6365f);
generalPath.curveTo(639.4222f, 785.4262f, 639.1656f, 785.3352f, 639.0256f, 785.1889f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(613.8406372070312, 781.6573486328125), new Point2D.Double(629.1531372070312, 781.6573486328125), new float[] {0.0f,0.1283382f,1.0f}, new Color[] {new Color(84, 37, 92, 255),new Color(123, 55, 135, 255),new Color(165, 74, 181, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 10.309959411621094f, 5.525599002838135f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_1
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(640.8908f, 772.63257f);
generalPath.curveTo(640.3046f, 772.9692f, 639.74774f, 773.3816f, 639.2033f, 773.7835f);
generalPath.curveTo(638.2233f, 776.6458f, 636.8161f, 779.3391f, 635.5783f, 782.0958f);
generalPath.curveTo(635.41614f, 782.6934f, 634.72534f, 782.82855f, 634.29706f, 783.1828f);
generalPath.curveTo(632.39935f, 784.3862f, 630.50793f, 785.56116f, 628.60956f, 786.7635f);
generalPath.curveTo(627.3403f, 786.86444f, 626.0329f, 786.7631f, 624.79706f, 787.1152f);
generalPath.curveTo(623.936f, 787.59827f, 623.3584f, 788.5041f, 622.73456f, 789.2572f);
generalPath.curveTo(621.80945f, 790.5029f, 620.98846f, 791.8346f, 620.29706f, 793.22156f);
generalPath.curveTo(620.2684f, 793.5572f, 620.7785f, 793.4503f, 620.98456f, 793.54126f);
generalPath.curveTo(621.8044f, 793.64374f, 622.6329f, 793.8141f, 623.4533f, 793.829f);
generalPath.curveTo(625.943f, 792.5599f, 627.8359f, 790.3591f, 630.29706f, 789.03345f);
generalPath.curveTo(631.5436f, 788.31995f, 632.7556f, 787.5513f, 633.7658f, 786.5078f);
generalPath.curveTo(634.9366f, 785.34717f, 636.15967f, 784.1901f, 637.2033f, 782.89514f);
generalPath.curveTo(637.1718f, 783.9868f, 637.12103f, 785.0898f, 636.85956f, 786.1561f);
generalPath.curveTo(636.3532f, 788.8298f, 635.3884f, 791.4766f, 635.6408f, 794.2446f);
generalPath.curveTo(635.6856f, 794.6433f, 635.764f, 795.0664f, 635.92206f, 795.42755f);
generalPath.curveTo(636.52826f, 795.41113f, 637.1416f, 795.4573f, 637.73456f, 795.36365f);
generalPath.curveTo(637.9578f, 793.7769f, 638.00433f, 792.1494f, 638.29706f, 790.5681f);
generalPath.curveTo(638.5666f, 789.07837f, 638.75104f, 787.55914f, 639.42206f, 786.1882f);
generalPath.curveTo(639.35376f, 785.83154f, 638.6922f, 785.72614f, 638.92206f, 785.26105f);
generalPath.curveTo(639.08954f, 783.5081f, 639.33264f, 781.749f, 639.3283f, 779.9859f);
generalPath.curveTo(639.3203f, 779.8603f, 639.2654f, 779.71466f, 639.10956f, 779.7621f);
generalPath.curveTo(639.1509f, 779.67786f, 639.19507f, 779.5915f, 639.23456f, 779.50635f);
generalPath.curveTo(639.75275f, 777.7718f, 640.01807f, 775.9617f, 640.6408f, 774.2632f);
generalPath.curveTo(640.7569f, 773.7438f, 640.9354f, 773.20685f, 641.0158f, 772.69666f);
generalPath.curveTo(640.9987f, 772.64557f, 640.93604f, 772.6229f, 640.8908f, 772.63275f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(629.354736328125, 786.9873657226562), new Point2D.Double(630.4360961914062, 788.7323608398438), new float[] {0.0f,0.48661074f,1.0f}, new Color[] {new Color(147, 66, 162, 255),new Color(154, 69, 170, 255),new Color(137, 61, 150, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(621.1862f, 763.334f);
generalPath.curveTo(621.0018f, 765.78564f, 620.9308f, 768.2726f, 620.4776f, 770.6969f);
generalPath.curveTo(620.3918f, 771.08246f, 620.1267f, 771.3933f, 619.9931f, 771.7564f);
generalPath.curveTo(620.2156f, 772.011f, 620.6526f, 771.9872f, 620.9554f, 772.1346f);
generalPath.curveTo(621.2754f, 772.1753f, 621.61975f, 772.4523f, 621.9392f, 772.33057f);
generalPath.curveTo(622.08295f, 772.1347f, 622.1233f, 771.8605f, 622.3652f, 771.7316f);
generalPath.curveTo(623.9859f, 770.4638f, 625.6451f, 769.1781f, 627.5252f, 768.33417f);
generalPath.curveTo(628.3621f, 767.9959f, 629.29346f, 768.20734f, 630.1754f, 768.2182f);
generalPath.curveTo(631.0437f, 768.2515f, 631.92f, 768.42554f, 632.77814f, 768.4271f);
generalPath.curveTo(632.93396f, 767.86456f, 632.7617f, 767.14484f, 633.0648f, 766.6427f);
generalPath.curveTo(633.2511f, 766.7195f, 633.2943f, 766.44006f, 633.4908f, 766.5601f);
generalPath.curveTo(634.31036f, 766.7122f, 635.38385f, 766.8479f, 635.7801f, 767.7126f);
generalPath.curveTo(636.176f, 768.8556f, 635.7524f, 770.09735f, 635.3703f, 771.1844f);
generalPath.curveTo(635.1221f, 771.7285f, 634.9459f, 772.4057f, 634.4538f, 772.7664f);
generalPath.curveTo(634.1924f, 772.8844f, 634.2671f, 773.2524f, 634.0503f, 773.43256f);
generalPath.curveTo(633.7679f, 773.65027f, 633.9642f, 773.96796f, 634.17926f, 774.1357f);
generalPath.curveTo(634.5864f, 774.5775f, 635.2367f, 775.0503f, 635.0514f, 775.74664f);
generalPath.curveTo(635.0454f, 776.20154f, 635.49774f, 776.48285f, 635.663f, 776.87146f);
generalPath.curveTo(636.0082f, 777.3367f, 636.213f, 777.957f, 636.6564f, 778.3366f);
generalPath.curveTo(636.9408f, 778.3396f, 636.97156f, 777.9007f, 637.1215f, 777.71423f);
generalPath.curveTo(637.8091f, 776.3224f, 638.3492f, 774.86475f, 638.9134f, 773.4253f);
generalPath.curveTo(639.4174f, 772.924f, 640.0914f, 772.60815f, 640.6786f, 772.21027f);
generalPath.curveTo(641.3997f, 771.7537f, 642.1561f, 771.36255f, 642.9227f, 770.9923f);
generalPath.curveTo(643.05396f, 770.3993f, 642.9428f, 769.7354f, 642.9802f, 769.1149f);
generalPath.curveTo(642.9808f, 767.2093f, 642.9832f, 765.3037f, 642.9852f, 763.3981f);
generalPath.curveTo(642.7367f, 763.15515f, 642.25183f, 763.36456f, 641.9153f, 763.2948f);
generalPath.curveTo(635.0312f, 763.2948f, 628.1471f, 763.2948f, 621.26306f, 763.2948f);
generalPath.lineTo(621.20526f, 763.3244f);
generalPath.lineTo(621.18634f, 763.3334f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(619.8778686523438, 734.8424072265625), new Point2D.Double(611.5894775390625, 742.0526123046875), new float[] {0.0f,1.0f}, new Color[] {new Color(236, 209, 97, 255),new Color(249, 223, 110, 127)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.023052453994751f, 10.215023040771484f, 12.223862648010254f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_3
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(633.41406f, 766.4795f);
generalPath.curveTo(632.95483f, 766.46387f, 632.9616f, 767.08203f, 632.91943f, 767.41095f);
generalPath.curveTo(632.8566f, 767.76215f, 632.96515f, 768.1689f, 632.86694f, 768.49115f);
generalPath.curveTo(632.1588f, 768.52026f, 631.4452f, 768.3373f, 630.73334f, 768.31006f);
generalPath.curveTo(629.495f, 768.25745f, 628.147f, 767.94403f, 627.00696f, 768.607f);
generalPath.curveTo(625.33167f, 769.4859f, 623.8023f, 770.64996f, 622.31476f, 771.8308f);
generalPath.curveTo(622.0568f, 772.06415f, 621.8809f, 772.5486f, 622.1432f, 772.83044f);
generalPath.curveTo(622.4963f, 773.46185f, 622.749f, 774.78625f, 623.06573f, 775.4214f);
generalPath.curveTo(623.35736f, 775.5533f, 623.44556f, 774.50916f, 623.69366f, 774.4311f);
generalPath.curveTo(623.98865f, 774.1987f, 624.4111f, 774.1668f, 624.6183f, 773.828f);
generalPath.curveTo(626.113f, 772.57434f, 628.07556f, 772.1297f, 629.97003f, 772.0071f);
generalPath.curveTo(631.194f, 771.9869f, 631.9627f, 772.30566f, 633.1194f, 772.76514f);
generalPath.curveTo(633.505f, 773.0861f, 634.15936f, 773.40125f, 634.4155f, 773.591f);
generalPath.curveTo(635.092f, 773.09753f, 635.32385f, 771.526f, 635.6089f, 770.7664f);
generalPath.curveTo(635.9159f, 769.72656f, 636.261f, 768.5154f, 635.75397f, 767.48535f);
generalPath.curveTo(635.27435f, 766.77277f, 634.3548f, 766.6208f, 633.5777f, 766.4878f);
generalPath.curveTo(633.5233f, 766.48773f, 633.4679f, 766.47186f, 633.4142f, 766.4798f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(613.0363159179688, 744.4335327148438), new Point2D.Double(623.0324096679688, 740.2142333984375), new float[] {0.0f,1.0f}, new Color[] {new Color(68, 55, 5, 255),new Color(236, 209, 97, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.023052453994751f, 10.215023040771484f, 12.223862648010254f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_4
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(620.0093f, 771.77704f);
generalPath.curveTo(619.71674f, 771.92615f, 619.615f, 772.32935f, 619.37634f, 772.5543f);
generalPath.curveTo(618.9677f, 773.05164f, 618.5768f, 773.60693f, 618.5708f, 774.2873f);
generalPath.curveTo(618.35077f, 776.1032f, 618.35944f, 777.932f, 618.36395f, 779.7595f);
generalPath.curveTo(617.04565f, 781.1889f, 615.42554f, 782.2562f, 614.02155f, 783.58246f);
generalPath.curveTo(613.71716f, 783.9357f, 614.21106f, 784.3112f, 614.33246f, 784.6275f);
generalPath.curveTo(616.0221f, 787.2804f, 617.7172f, 789.94305f, 619.5548f, 792.49036f);
generalPath.curveTo(619.66327f, 792.6549f, 619.9239f, 792.97205f, 620.0416f, 792.641f);
generalPath.curveTo(621.1802f, 790.6453f, 622.37274f, 788.6695f, 624.0166f, 787.0646f);
generalPath.curveTo(624.6627f, 786.4775f, 625.6061f, 786.5736f, 626.41895f, 786.4677f);
generalPath.curveTo(627.07495f, 786.4036f, 627.7609f, 786.4657f, 628.39795f, 786.3341f);
generalPath.curveTo(629.8472f, 785.40466f, 631.34155f, 784.5346f, 632.74585f, 783.5412f);
generalPath.curveTo(632.86426f, 783.25867f, 632.45514f, 783.3416f, 632.3259f, 783.4193f);
generalPath.curveTo(630.412f, 783.80853f, 628.4453f, 783.97363f, 626.5037f, 784.043f);
generalPath.curveTo(625.49255f, 783.9212f, 624.61725f, 783.319f, 623.744f, 782.82654f);
generalPath.curveTo(623.09814f, 782.425f, 622.34576f, 781.97614f, 622.1754f, 781.15155f);
generalPath.curveTo(621.72217f, 779.26184f, 621.4964f, 777.2909f, 621.49304f, 775.34796f);
generalPath.curveTo(621.53406f, 774.35583f, 621.77014f, 773.3827f, 621.9594f, 772.42346f);
generalPath.curveTo(621.77264f, 772.1605f, 621.3645f, 772.2515f, 621.1045f, 772.09357f);
generalPath.curveTo(620.7391f, 771.9986f, 620.3879f, 771.7969f, 620.0093f, 771.777f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(606.3485107421875, 758.4259033203125), new Point2D.Double(614.359130859375, 751.9657592773438), new float[] {0.0f,1.0f}, new Color[] {new Color(29, 44, 94, 255),new Color(125, 147, 217, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.023052453994751f, 10.215023040771484f, 12.223862648010254f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(612.3291f, 778.1381f);
generalPath.curveTo(612.3291f, 778.1381f, 612.7143f, 784.0892f, 613.3399f, 783.91534f);
generalPath.curveTo(614.4496f, 782.8352f, 616.21277f, 781.7591f, 617.34894f, 780.6991f);
generalPath.curveTo(617.68646f, 780.35187f, 618.15454f, 780.04144f, 618.323f, 779.582f);
generalPath.curveTo(618.3059f, 777.5837f, 618.2973f, 775.55615f, 618.6446f, 773.59045f);
generalPath.curveTo(618.93164f, 772.9313f, 619.4962f, 772.43665f, 619.85315f, 771.81494f);
generalPath.curveTo(620.2395f, 771.27966f, 620.52527f, 770.6668f, 620.55554f, 769.9892f);
generalPath.curveTo(620.83295f, 767.8035f, 621.0662f, 765.60095f, 621.0853f, 763.3981f);
generalPath.curveTo(620.8368f, 763.15515f, 620.3519f, 763.36456f, 620.0154f, 763.2948f);
generalPath.curveTo(617.1298f, 763.2948f, 614.2443f, 763.2948f, 611.3588f, 763.2948f);
generalPath.lineTo(611.301f, 763.3244f);
generalPath.lineTo(611.2821f, 763.3334f);
generalPath.lineTo(611.1667f, 775.04047f);
generalPath.closePath();
shape = generalPath;
paint = new Color(148, 148, 148, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_6
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(642.8257f, 771.0976f);
generalPath.curveTo(642.13556f, 771.38666f, 641.437f, 771.72943f, 640.8311f, 772.1819f);
generalPath.curveTo(640.3824f, 772.8686f, 640.4489f, 773.78644f, 640.0862f, 774.5095f);
generalPath.curveTo(639.7488f, 775.21954f, 639.68774f, 776.04834f, 639.4811f, 776.80884f);
generalPath.curveTo(639.3258f, 777.6195f, 639.0557f, 778.40576f, 638.8951f, 779.21027f);
generalPath.curveTo(639.0706f, 779.91846f, 638.8756f, 780.6847f, 638.8497f, 781.4148f);
generalPath.curveTo(638.74634f, 782.7284f, 638.5361f, 784.0493f, 638.4659f, 785.35443f);
generalPath.curveTo(638.631f, 785.5136f, 638.9874f, 785.9778f, 639.19183f, 785.6107f);
generalPath.curveTo(640.4168f, 783.9595f, 641.6028f, 782.24506f, 642.7166f, 780.52997f);
generalPath.curveTo(643.0514f, 780.48944f, 642.92694f, 780.0253f, 642.969f, 779.7803f);
generalPath.curveTo(642.987f, 776.9088f, 643.0122f, 774.0327f, 642.9448f, 771.1637f);
generalPath.curveTo(642.9068f, 771.144f, 642.88794f, 771.0616f, 642.82574f, 771.0976f);
generalPath.closePath();
shape = generalPath;
paint = new Color(38, 115, 71, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_7
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(642.7041f, 780.7211f);
generalPath.curveTo(641.9267f, 781.7601f, 641.2298f, 782.8913f, 640.45526f, 783.94086f);
generalPath.curveTo(639.63776f, 785.1365f, 638.6303f, 786.30286f, 638.4315f, 787.8044f);
generalPath.curveTo(637.98413f, 790.148f, 637.53394f, 792.5249f, 637.5365f, 794.9247f);
generalPath.curveTo(637.82135f, 795.15643f, 638.33954f, 794.9617f, 638.7136f, 795.02594f);
generalPath.curveTo(640.1021f, 795.00665f, 641.50714f, 795.06464f, 642.8854f, 794.99725f);
generalPath.curveTo(642.97327f, 793.9219f, 642.8981f, 792.78406f, 642.9231f, 791.68463f);
generalPath.curveTo(642.9042f, 788.0501f, 642.9667f, 784.41095f, 642.8599f, 780.7794f);
generalPath.curveTo(642.84503f, 780.7154f, 642.7667f, 780.68353f, 642.7041f, 780.7212f);
generalPath.closePath();
shape = generalPath;
paint = new Color(160, 160, 160, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_8
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(634.2317f, 777.7789f);
generalPath.curveTo(633.7351f, 778.8292f, 632.67535f, 779.4035f, 631.79584f, 780.07275f);
generalPath.curveTo(630.8618f, 780.7622f, 629.7932f, 781.36597f, 628.60333f, 781.34985f);
generalPath.curveTo(627.9376f, 781.39685f, 627.2404f, 781.3063f, 626.58655f, 781.40155f);
generalPath.curveTo(626.62317f, 781.67804f, 626.4276f, 782.28204f, 626.8153f, 782.31915f);
generalPath.curveTo(627.066f, 782.34576f, 627.4102f, 782.34576f, 627.4438f, 782.68164f);
generalPath.curveTo(627.62915f, 783.09186f, 627.7385f, 783.5714f, 628.034f, 783.9109f);
generalPath.curveTo(629.2666f, 783.8528f, 630.522f, 783.6944f, 631.7445f, 783.4957f);
generalPath.curveTo(632.51227f, 783.29425f, 633.33673f, 783.15045f, 634.0156f, 782.72534f);
generalPath.curveTo(634.78424f, 782.0341f, 635.3504f, 781.12134f, 635.876f, 780.24347f);
generalPath.curveTo(635.33936f, 779.4624f, 634.96655f, 778.5478f, 634.3871f, 777.78094f);
generalPath.curveTo(634.3304f, 777.73224f, 634.28876f, 777.73804f, 634.2316f, 777.77893f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(630.6192626953125, 782.3370971679688), new Point2D.Double(627.4911499023438, 782.8685913085938), new float[] {0.0f,1.0f}, new Color[] {new Color(84, 37, 92, 255),new Color(41, 57, 106, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_9
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(622.0523f, 772.64246f);
generalPath.curveTo(621.7815f, 773.04535f, 621.8033f, 773.6024f, 621.6889f, 774.07166f);
generalPath.curveTo(621.3579f, 776.0404f, 621.664f, 778.0471f, 621.96954f, 779.99915f);
generalPath.curveTo(622.1467f, 780.7626f, 622.19147f, 781.7006f, 622.906f, 782.1701f);
generalPath.curveTo(623.86414f, 782.8977f, 624.9118f, 783.57117f, 626.0657f, 783.91504f);
generalPath.curveTo(626.6765f, 783.98236f, 627.332f, 784.077f, 627.91693f, 783.85925f);
generalPath.curveTo(628.0919f, 783.6088f, 627.7232f, 783.3119f, 627.6929f, 783.0517f);
generalPath.curveTo(627.5562f, 782.6885f, 627.35394f, 782.19403f, 626.89343f, 782.25446f);
generalPath.curveTo(626.4753f, 782.13385f, 626.7794f, 781.54803f, 626.53204f, 781.2982f);
generalPath.curveTo(626.3701f, 781.24854f, 626.5114f, 780.9698f, 626.3746f, 780.8562f);
generalPath.curveTo(625.2038f, 779.338f, 624.30316f, 777.6076f, 623.4619f, 775.8857f);
generalPath.curveTo(622.9911f, 774.8296f, 622.71375f, 773.68585f, 622.17346f, 772.663f);
generalPath.curveTo(622.14166f, 772.6207f, 622.09485f, 772.63983f, 622.05237f, 772.64233f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(622.96533203125, 777.0225219726562), new Point2D.Double(622.4950561523438, 773.8612670898438), new float[] {0.0f,1.0f}, new Color[] {new Color(41, 57, 106, 255),new Color(68, 55, 5, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_10
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(635.04956f, 776.00964f);
generalPath.curveTo(634.75543f, 776.3689f, 634.70636f, 776.89624f, 634.47205f, 777.3068f);
generalPath.curveTo(634.1834f, 777.6432f, 634.35846f, 777.97675f, 634.6068f, 778.2644f);
generalPath.curveTo(634.9993f, 778.8336f, 635.25555f, 779.51025f, 635.7129f, 780.0296f);
generalPath.curveTo(635.9973f, 780.0518f, 636.0555f, 779.6132f, 636.21564f, 779.431f);
generalPath.curveTo(636.3964f, 779.05786f, 636.6667f, 778.70264f, 636.77844f, 778.30615f);
generalPath.curveTo(636.10693f, 777.6321f, 635.80054f, 776.66254f, 635.1191f, 776.00745f);
generalPath.lineTo(635.0559f, 776.00745f);
generalPath.lineTo(635.0499f, 776.00946f);
generalPath.closePath();
shape = generalPath;
paint = new Color(38, 115, 71, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_11
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(630.715f, 771.8403f);
generalPath.curveTo(627.6704f, 771.3745f, 622.8588f, 773.4785f, 623.10913f, 775.3396f);
generalPath.curveTo(623.35944f, 777.2007f, 623.7481f, 777.86835f, 624.22955f, 778.70087f);
generalPath.curveTo(624.7054f, 779.5236f, 625.6201f, 779.98737f, 626.1525f, 780.76f);
generalPath.curveTo(628.28107f, 781.8251f, 630.91724f, 780.6252f, 632.6649f, 779.23114f);
generalPath.curveTo(634.07196f, 778.0843f, 636.61365f, 777.0031f, 634.20886f, 773.38324f);
generalPath.curveTo(633.69824f, 772.6788f, 631.1308f, 772.066f, 630.71497f, 771.8403f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(618.2529296875, 770.80029296875), 5.485732f, new Point2D.Double(618.2529296875, 770.80029296875), new float[] {0.0f,0.7092865f,1.0f}, new Color[] {new Color(225, 86, 101, 255),new Color(139, 39, 70, 255),new Color(97, 27, 49, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9657214283943176f, -0.2590981125831604f, 0.1941215693950653f, 0.7208499908447266f, -118.12615966796875f, 380.8826904296875f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_12
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(629.29474f, 772.4999f);
generalPath.curveTo(629.0188f, 772.5069f, 629.1747f, 772.82666f, 629.34326f, 772.8882f);
generalPath.curveTo(630.39465f, 773.71857f, 631.4818f, 774.5986f, 632.214f, 775.7549f);
generalPath.curveTo(632.4335f, 776.4038f, 632.2672f, 777.12244f, 632.321f, 777.79956f);
generalPath.curveTo(632.21936f, 778.1255f, 631.7967f, 778.2871f, 631.5402f, 778.5168f);
generalPath.curveTo(630.59045f, 779.18256f, 629.618f, 779.9236f, 628.4307f, 780.0467f);
generalPath.curveTo(627.62646f, 780.2096f, 626.8104f, 780.06976f, 626.00616f, 780.1128f);
generalPath.curveTo(625.75226f, 780.247f, 625.95984f, 780.62976f, 626.21814f, 780.561f);
generalPath.curveTo(627.7717f, 780.677f, 629.4801f, 780.6708f, 630.78467f, 779.67285f);
generalPath.curveTo(631.6764f, 779.04175f, 632.60596f, 778.4343f, 633.3627f, 777.6344f);
generalPath.curveTo(633.9063f, 776.7702f, 634.3324f, 775.8108f, 634.5356f, 774.80695f);
generalPath.curveTo(634.57227f, 774.0901f, 633.8308f, 773.6919f, 633.43097f, 773.2124f);
generalPath.curveTo(633.0605f, 773.01776f, 631.50446f, 772.3692f, 631.0919f, 772.26935f);
generalPath.curveTo(630.123f, 772.14905f, 629.7711f, 772.169f, 628.7985f, 772.0754f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(633.65283203125, 774.699951171875), 4.3230734f, new Point2D.Double(633.65283203125, 774.699951171875), new float[] {0.0f,1.0f}, new Color[] {new Color(54, 52, 54, 255),new Color(100, 28, 50, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-0.6764160990715027f, -0.20700441300868988f, 0.20498496294021606f, -0.6673287153244019f, 902.9825439453125f, 1422.1575927734375f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_13
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.0114605f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(633.0369f, 766.6539f);
generalPath.curveTo(632.7139f, 767.57916f, 632.9077f, 768.5044f, 632.9077f, 768.5044f);
generalPath.curveTo(632.9077f, 768.5044f, 629.74225f, 768.10785f, 628.19183f, 768.17395f);
generalPath.curveTo(626.6414f, 768.24005f, 622.1193f, 771.9411f, 622.1193f, 771.9411f);
generalPath.curveTo(621.6025f, 773.9899f, 621.4087f, 774.91516f, 621.5379f, 776.69965f);
generalPath.curveTo(621.6671f, 778.4841f, 621.9901f, 781.1938f, 622.5069f, 781.85474f);
generalPath.curveTo(623.0237f, 782.5157f, 625.67236f, 784.03577f, 626.4476f, 784.03577f);
generalPath.curveTo(627.2228f, 784.03577f, 630.1298f, 783.7714f, 630.71124f, 783.7053f);
generalPath.curveTo(631.29266f, 783.6392f, 633.1015f, 783.3088f, 634.0059f, 782.78f);
generalPath.curveTo(634.91034f, 782.2513f, 637.0116f, 777.965f, 637.0116f, 777.965f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_14
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.011f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(643.11475f, 771.01587f);
generalPath.curveTo(642.14575f, 771.082f, 638.91565f, 773.39514f, 638.91565f, 773.39514f);
generalPath.lineTo(638.14044f, 775.5761f);
generalPath.lineTo(635.1042f, 782.1191f);
generalPath.lineTo(628.32104f, 786.415f);
generalPath.curveTo(628.32104f, 786.415f, 625.414f, 786.415f, 624.5096f, 786.7454f);
generalPath.curveTo(623.60516f, 787.07587f, 621.4733f, 790.2482f, 621.4733f, 790.2482f);
generalPath.lineTo(619.9229f, 792.89185f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_15
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.0114605f,1,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(642.7271f, 780.4668f);
generalPath.curveTo(642.0165f, 782.053f, 639.0448f, 785.4897f, 638.6572f, 786.7454f);
generalPath.curveTo(638.2696f, 788.00116f, 637.559f, 792.4953f, 637.559f, 793.2223f);
generalPath.curveTo(637.559f, 793.9493f, 637.48883f, 795.0899f, 637.48883f, 795.0899f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_16
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(624.65686f, 779.78973f);
generalPath.curveTo(628.1495f, 784.1255f, 637.9568f, 777.83136f, 633.8244f, 773.6148f);
generalPath.lineTo(632.8983f, 772.8222f);
generalPath.lineTo(631.94495f, 772.06396f);
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(626.9586791992188, 781.4070434570312), new Point2D.Double(627.0252685546875, 781.141357421875), new float[] {0.0f,1.0f}, new Color[] {new Color(173, 148, 43, 255),new Color(173, 148, 43, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.07089447975158691f, -0.14152559638023376f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.0114605f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(624.65686f, 779.78973f);
generalPath.curveTo(628.1495f, 784.1255f, 637.9568f, 777.83136f, 633.8244f, 773.6148f);
generalPath.lineTo(632.8983f, 772.8222f);
generalPath.lineTo(631.94495f, 772.06396f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_17
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.0114605f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(621.15155f, 763.2172f);
generalPath.curveTo(620.96515f, 767.9541f, 620.55304f, 770.35345f, 620.43964f, 770.81757f);
generalPath.curveTo(620.3104f, 771.3463f, 619.1476f, 772.8664f, 618.76f, 773.32904f);
generalPath.curveTo(618.37244f, 773.7917f, 618.2432f, 779.0789f, 618.37244f, 779.54156f);
generalPath.curveTo(618.50165f, 780.0042f, 614.884f, 782.77997f, 614.30255f, 783.2426f);
generalPath.curveTo(613.7211f, 783.70526f, 613.7211f, 783.83746f, 614.238f, 784.56445f);
generalPath.curveTo(614.75476f, 785.29144f, 619.4707f, 792.82574f, 620.0521f, 793.09015f);
generalPath.curveTo(620.63354f, 793.3545f, 627.2229f, 793.88324f, 627.4167f, 794.01544f);
generalPath.curveTo(627.6105f, 794.14764f, 627.2875f, 794.94073f, 627.2875f, 794.94073f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 611.5220336914062f, 766.1766357421875f));
// _0_0_0_0_1
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.0f,1,1,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(0.14355525f, 12.045818f);
generalPath.curveTo(0.9331093f, 13.409594f, 1.0048869f, 14.9169235f, 1.0048869f, 14.9169235f);
generalPath.curveTo(1.0061969f, 16.13976f, 1.2679598f, 17.88351f, 1.6508856f, 19.869581f);
generalPath.lineTo(2.512217f, 21.089802f);
shape = generalPath;
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(transformsStack.pop());
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
        return 0.07177734375;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 0.1435546875;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 31.92822265625;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 31.8564453125;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private orbit_icon() {
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
       orbit_icon base = new orbit_icon();
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
       orbit_icon base = new orbit_icon();
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
        return orbit_icon::new;
    }
}

