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
public class orbit_icon implements ResizableIcon {
    

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
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -611.5220336914062f, -766.1766357421875f));
// _0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_0_0 = g.getTransform();
g.transform(new AffineTransform(1.0124582052230835f, 0.0f, 0.0f, 1.0143442153930664f, -7.411852836608887f, -8.110316276550293f));
// _0_0_0_0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_0_0_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(639.3693, 779.3383);
((GeneralPath)shape).curveTo(639.333, 779.4151, 639.2815, 779.4863, 639.2443, 779.56213);
((GeneralPath)shape).curveTo(639.3222, 779.53845, 639.3664, 779.5479, 639.4006, 779.59406);
((GeneralPath)shape).curveTo(639.4007, 779.54, 639.401, 779.4883, 639.4006, 779.4342);
((GeneralPath)shape).curveTo(639.3976, 779.4058, 639.381, 779.3672, 639.3694, 779.3383);
((GeneralPath)shape).closePath();
((GeneralPath)shape).moveTo(637.3381, 782.6952);
((GeneralPath)shape).curveTo(636.29443, 783.9902, 635.07135, 785.1472, 633.9006, 786.30786);
((GeneralPath)shape).curveTo(632.8904, 787.3514, 631.67834, 788.12, 630.4318, 788.8335);
((GeneralPath)shape).curveTo(628.1619, 790.0561, 626.36774, 792.0154, 624.1506, 793.3093);
((GeneralPath)shape).curveTo(624.18304, 793.31335, 624.2162, 793.34564, 624.24426, 793.34125);
((GeneralPath)shape).curveTo(625.41766, 793.5478, 626.6205, 793.75226, 627.7755, 794.02496);
((GeneralPath)shape).curveTo(627.9928, 794.29626, 627.7327, 794.6856, 627.7755, 794.9841);
((GeneralPath)shape).curveTo(628.6602, 795.07684, 629.59485, 794.9881, 630.49426, 795.016);
((GeneralPath)shape).curveTo(632.3111, 795.013, 634.1149, 795.023, 635.93176, 795.016);
((GeneralPath)shape).curveTo(635.86316, 794.7629, 635.80426, 794.5045, 635.7755, 794.2487);
((GeneralPath)shape).curveTo(635.52313, 791.4807, 636.4879, 788.6297, 636.99426, 785.95605);
((GeneralPath)shape).curveTo(637.25574, 784.8898, 637.3065, 783.7868, 637.338, 782.69507);
((GeneralPath)shape).closePath();
((GeneralPath)shape).moveTo(639.0256, 785.1889);
((GeneralPath)shape).curveTo(638.97845, 785.44446, 639.2225, 785.5957, 639.4006, 785.76434);
((GeneralPath)shape).curveTo(639.42175, 785.7202, 639.44244, 785.68054, 639.4631, 785.6365);
((GeneralPath)shape).curveTo(639.4222, 785.4262, 639.1656, 785.3352, 639.0256, 785.1889);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(613.8406372070312, 781.6573486328125), new Point2D.Double(629.1531372070312, 781.6573486328125), new float[] {0.0f,0.1283382f,1.0f}, new Color[] {new Color(84, 37, 92, 255),new Color(123, 55, 135, 255),new Color(165, 74, 181, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 10.309959411621094f, 5.525599002838135f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0_0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_0_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(640.8908, 772.63257);
((GeneralPath)shape).curveTo(640.3046, 772.9692, 639.74774, 773.3816, 639.2033, 773.7835);
((GeneralPath)shape).curveTo(638.2233, 776.6458, 636.8161, 779.3391, 635.5783, 782.0958);
((GeneralPath)shape).curveTo(635.41614, 782.6934, 634.72534, 782.82855, 634.29706, 783.1828);
((GeneralPath)shape).curveTo(632.39935, 784.3862, 630.50793, 785.56116, 628.60956, 786.7635);
((GeneralPath)shape).curveTo(627.3403, 786.86444, 626.0329, 786.7631, 624.79706, 787.1152);
((GeneralPath)shape).curveTo(623.936, 787.59827, 623.3584, 788.5041, 622.73456, 789.2572);
((GeneralPath)shape).curveTo(621.80945, 790.5029, 620.98846, 791.8346, 620.29706, 793.22156);
((GeneralPath)shape).curveTo(620.2684, 793.5572, 620.7785, 793.4503, 620.98456, 793.54126);
((GeneralPath)shape).curveTo(621.8044, 793.64374, 622.6329, 793.8141, 623.4533, 793.829);
((GeneralPath)shape).curveTo(625.943, 792.5599, 627.8359, 790.3591, 630.29706, 789.03345);
((GeneralPath)shape).curveTo(631.5436, 788.31995, 632.7556, 787.5513, 633.7658, 786.5078);
((GeneralPath)shape).curveTo(634.9366, 785.34717, 636.15967, 784.1901, 637.2033, 782.89514);
((GeneralPath)shape).curveTo(637.1718, 783.9868, 637.12103, 785.0898, 636.85956, 786.1561);
((GeneralPath)shape).curveTo(636.3532, 788.8298, 635.3884, 791.4766, 635.6408, 794.2446);
((GeneralPath)shape).curveTo(635.6856, 794.6433, 635.764, 795.0664, 635.92206, 795.42755);
((GeneralPath)shape).curveTo(636.52826, 795.41113, 637.1416, 795.4573, 637.73456, 795.36365);
((GeneralPath)shape).curveTo(637.9578, 793.7769, 638.00433, 792.1494, 638.29706, 790.5681);
((GeneralPath)shape).curveTo(638.5666, 789.07837, 638.75104, 787.55914, 639.42206, 786.1882);
((GeneralPath)shape).curveTo(639.35376, 785.83154, 638.6922, 785.72614, 638.92206, 785.26105);
((GeneralPath)shape).curveTo(639.08954, 783.5081, 639.33264, 781.749, 639.3283, 779.9859);
((GeneralPath)shape).curveTo(639.3203, 779.8603, 639.2654, 779.71466, 639.10956, 779.7621);
((GeneralPath)shape).curveTo(639.1509, 779.67786, 639.19507, 779.5915, 639.23456, 779.50635);
((GeneralPath)shape).curveTo(639.75275, 777.7718, 640.01807, 775.9617, 640.6408, 774.2632);
((GeneralPath)shape).curveTo(640.7569, 773.7438, 640.9354, 773.20685, 641.0158, 772.69666);
((GeneralPath)shape).curveTo(640.9987, 772.64557, 640.93604, 772.6229, 640.8908, 772.63275);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(629.354736328125, 786.9873657226562), new Point2D.Double(630.4360961914062, 788.7323608398438), new float[] {0.0f,0.48661074f,1.0f}, new Color[] {new Color(147, 66, 162, 255),new Color(154, 69, 170, 255),new Color(137, 61, 150, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0_0_0_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_0_0_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(621.1862, 763.334);
((GeneralPath)shape).curveTo(621.0018, 765.78564, 620.9308, 768.2726, 620.4776, 770.6969);
((GeneralPath)shape).curveTo(620.3918, 771.08246, 620.1267, 771.3933, 619.9931, 771.7564);
((GeneralPath)shape).curveTo(620.2156, 772.011, 620.6526, 771.9872, 620.9554, 772.1346);
((GeneralPath)shape).curveTo(621.2754, 772.1753, 621.61975, 772.4523, 621.9392, 772.33057);
((GeneralPath)shape).curveTo(622.08295, 772.1347, 622.1233, 771.8605, 622.3652, 771.7316);
((GeneralPath)shape).curveTo(623.9859, 770.4638, 625.6451, 769.1781, 627.5252, 768.33417);
((GeneralPath)shape).curveTo(628.3621, 767.9959, 629.29346, 768.20734, 630.1754, 768.2182);
((GeneralPath)shape).curveTo(631.0437, 768.2515, 631.92, 768.42554, 632.77814, 768.4271);
((GeneralPath)shape).curveTo(632.93396, 767.86456, 632.7617, 767.14484, 633.0648, 766.6427);
((GeneralPath)shape).curveTo(633.2511, 766.7195, 633.2943, 766.44006, 633.4908, 766.5601);
((GeneralPath)shape).curveTo(634.31036, 766.7122, 635.38385, 766.8479, 635.7801, 767.7126);
((GeneralPath)shape).curveTo(636.176, 768.8556, 635.7524, 770.09735, 635.3703, 771.1844);
((GeneralPath)shape).curveTo(635.1221, 771.7285, 634.9459, 772.4057, 634.4538, 772.7664);
((GeneralPath)shape).curveTo(634.1924, 772.8844, 634.2671, 773.2524, 634.0503, 773.43256);
((GeneralPath)shape).curveTo(633.7679, 773.65027, 633.9642, 773.96796, 634.17926, 774.1357);
((GeneralPath)shape).curveTo(634.5864, 774.5775, 635.2367, 775.0503, 635.0514, 775.74664);
((GeneralPath)shape).curveTo(635.0454, 776.20154, 635.49774, 776.48285, 635.663, 776.87146);
((GeneralPath)shape).curveTo(636.0082, 777.3367, 636.213, 777.957, 636.6564, 778.3366);
((GeneralPath)shape).curveTo(636.9408, 778.3396, 636.97156, 777.9007, 637.1215, 777.71423);
((GeneralPath)shape).curveTo(637.8091, 776.3224, 638.3492, 774.86475, 638.9134, 773.4253);
((GeneralPath)shape).curveTo(639.4174, 772.924, 640.0914, 772.60815, 640.6786, 772.21027);
((GeneralPath)shape).curveTo(641.3997, 771.7537, 642.1561, 771.36255, 642.9227, 770.9923);
((GeneralPath)shape).curveTo(643.05396, 770.3993, 642.9428, 769.7354, 642.9802, 769.1149);
((GeneralPath)shape).curveTo(642.9808, 767.2093, 642.9832, 765.3037, 642.9852, 763.3981);
((GeneralPath)shape).curveTo(642.7367, 763.15515, 642.25183, 763.36456, 641.9153, 763.2948);
((GeneralPath)shape).curveTo(635.0312, 763.2948, 628.1471, 763.2948, 621.26306, 763.2948);
((GeneralPath)shape).lineTo(621.20526, 763.3244);
((GeneralPath)shape).lineTo(621.18634, 763.3334);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(619.8778686523438, 734.8424072265625), new Point2D.Double(611.5894775390625, 742.0526123046875), new float[] {0.0f,1.0f}, new Color[] {new Color(236, 209, 97, 255),new Color(249, 223, 110, 127)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.023052453994751f, 10.215023040771484f, 12.223862648010254f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0_0_0_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_0_0_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_3
shape = new GeneralPath();
((GeneralPath)shape).moveTo(633.41406, 766.4795);
((GeneralPath)shape).curveTo(632.95483, 766.46387, 632.9616, 767.08203, 632.91943, 767.41095);
((GeneralPath)shape).curveTo(632.8566, 767.76215, 632.96515, 768.1689, 632.86694, 768.49115);
((GeneralPath)shape).curveTo(632.1588, 768.52026, 631.4452, 768.3373, 630.73334, 768.31006);
((GeneralPath)shape).curveTo(629.495, 768.25745, 628.147, 767.94403, 627.00696, 768.607);
((GeneralPath)shape).curveTo(625.33167, 769.4859, 623.8023, 770.64996, 622.31476, 771.8308);
((GeneralPath)shape).curveTo(622.0568, 772.06415, 621.8809, 772.5486, 622.1432, 772.83044);
((GeneralPath)shape).curveTo(622.4963, 773.46185, 622.749, 774.78625, 623.06573, 775.4214);
((GeneralPath)shape).curveTo(623.35736, 775.5533, 623.44556, 774.50916, 623.69366, 774.4311);
((GeneralPath)shape).curveTo(623.98865, 774.1987, 624.4111, 774.1668, 624.6183, 773.828);
((GeneralPath)shape).curveTo(626.113, 772.57434, 628.07556, 772.1297, 629.97003, 772.0071);
((GeneralPath)shape).curveTo(631.194, 771.9869, 631.9627, 772.30566, 633.1194, 772.76514);
((GeneralPath)shape).curveTo(633.505, 773.0861, 634.15936, 773.40125, 634.4155, 773.591);
((GeneralPath)shape).curveTo(635.092, 773.09753, 635.32385, 771.526, 635.6089, 770.7664);
((GeneralPath)shape).curveTo(635.9159, 769.72656, 636.261, 768.5154, 635.75397, 767.48535);
((GeneralPath)shape).curveTo(635.27435, 766.77277, 634.3548, 766.6208, 633.5777, 766.4878);
((GeneralPath)shape).curveTo(633.5233, 766.48773, 633.4679, 766.47186, 633.4142, 766.4798);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(613.0363159179688, 744.4335327148438), new Point2D.Double(623.0324096679688, 740.2142333984375), new float[] {0.0f,1.0f}, new Color[] {new Color(68, 55, 5, 255),new Color(236, 209, 97, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.023052453994751f, 10.215023040771484f, 12.223862648010254f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0_0_0_3);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_0_0_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_4
shape = new GeneralPath();
((GeneralPath)shape).moveTo(620.0093, 771.77704);
((GeneralPath)shape).curveTo(619.71674, 771.92615, 619.615, 772.32935, 619.37634, 772.5543);
((GeneralPath)shape).curveTo(618.9677, 773.05164, 618.5768, 773.60693, 618.5708, 774.2873);
((GeneralPath)shape).curveTo(618.35077, 776.1032, 618.35944, 777.932, 618.36395, 779.7595);
((GeneralPath)shape).curveTo(617.04565, 781.1889, 615.42554, 782.2562, 614.02155, 783.58246);
((GeneralPath)shape).curveTo(613.71716, 783.9357, 614.21106, 784.3112, 614.33246, 784.6275);
((GeneralPath)shape).curveTo(616.0221, 787.2804, 617.7172, 789.94305, 619.5548, 792.49036);
((GeneralPath)shape).curveTo(619.66327, 792.6549, 619.9239, 792.97205, 620.0416, 792.641);
((GeneralPath)shape).curveTo(621.1802, 790.6453, 622.37274, 788.6695, 624.0166, 787.0646);
((GeneralPath)shape).curveTo(624.6627, 786.4775, 625.6061, 786.5736, 626.41895, 786.4677);
((GeneralPath)shape).curveTo(627.07495, 786.4036, 627.7609, 786.4657, 628.39795, 786.3341);
((GeneralPath)shape).curveTo(629.8472, 785.40466, 631.34155, 784.5346, 632.74585, 783.5412);
((GeneralPath)shape).curveTo(632.86426, 783.25867, 632.45514, 783.3416, 632.3259, 783.4193);
((GeneralPath)shape).curveTo(630.412, 783.80853, 628.4453, 783.97363, 626.5037, 784.043);
((GeneralPath)shape).curveTo(625.49255, 783.9212, 624.61725, 783.319, 623.744, 782.82654);
((GeneralPath)shape).curveTo(623.09814, 782.425, 622.34576, 781.97614, 622.1754, 781.15155);
((GeneralPath)shape).curveTo(621.72217, 779.26184, 621.4964, 777.2909, 621.49304, 775.34796);
((GeneralPath)shape).curveTo(621.53406, 774.35583, 621.77014, 773.3827, 621.9594, 772.42346);
((GeneralPath)shape).curveTo(621.77264, 772.1605, 621.3645, 772.2515, 621.1045, 772.09357);
((GeneralPath)shape).curveTo(620.7391, 771.9986, 620.3879, 771.7969, 620.0093, 771.777);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(606.3485107421875, 758.4259033203125), new Point2D.Double(614.359130859375, 751.9657592773438), new float[] {0.0f,1.0f}, new Color[] {new Color(29, 44, 94, 255),new Color(125, 147, 217, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.023052453994751f, 10.215023040771484f, 12.223862648010254f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0_0_0_4);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_0_0_5 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_5
shape = new GeneralPath();
((GeneralPath)shape).moveTo(612.3291, 778.1381);
((GeneralPath)shape).curveTo(612.3291, 778.1381, 612.7143, 784.0892, 613.3399, 783.91534);
((GeneralPath)shape).curveTo(614.4496, 782.8352, 616.21277, 781.7591, 617.34894, 780.6991);
((GeneralPath)shape).curveTo(617.68646, 780.35187, 618.15454, 780.04144, 618.323, 779.582);
((GeneralPath)shape).curveTo(618.3059, 777.5837, 618.2973, 775.55615, 618.6446, 773.59045);
((GeneralPath)shape).curveTo(618.93164, 772.9313, 619.4962, 772.43665, 619.85315, 771.81494);
((GeneralPath)shape).curveTo(620.2395, 771.27966, 620.52527, 770.6668, 620.55554, 769.9892);
((GeneralPath)shape).curveTo(620.83295, 767.8035, 621.0662, 765.60095, 621.0853, 763.3981);
((GeneralPath)shape).curveTo(620.8368, 763.15515, 620.3519, 763.36456, 620.0154, 763.2948);
((GeneralPath)shape).curveTo(617.1298, 763.2948, 614.2443, 763.2948, 611.3588, 763.2948);
((GeneralPath)shape).lineTo(611.301, 763.3244);
((GeneralPath)shape).lineTo(611.2821, 763.3334);
((GeneralPath)shape).lineTo(611.1667, 775.04047);
((GeneralPath)shape).closePath();
paint = new Color(148, 148, 148, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0_0_0_5);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_0_0_6 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_6
shape = new GeneralPath();
((GeneralPath)shape).moveTo(642.8257, 771.0976);
((GeneralPath)shape).curveTo(642.13556, 771.38666, 641.437, 771.72943, 640.8311, 772.1819);
((GeneralPath)shape).curveTo(640.3824, 772.8686, 640.4489, 773.78644, 640.0862, 774.5095);
((GeneralPath)shape).curveTo(639.7488, 775.21954, 639.68774, 776.04834, 639.4811, 776.80884);
((GeneralPath)shape).curveTo(639.3258, 777.6195, 639.0557, 778.40576, 638.8951, 779.21027);
((GeneralPath)shape).curveTo(639.0706, 779.91846, 638.8756, 780.6847, 638.8497, 781.4148);
((GeneralPath)shape).curveTo(638.74634, 782.7284, 638.5361, 784.0493, 638.4659, 785.35443);
((GeneralPath)shape).curveTo(638.631, 785.5136, 638.9874, 785.9778, 639.19183, 785.6107);
((GeneralPath)shape).curveTo(640.4168, 783.9595, 641.6028, 782.24506, 642.7166, 780.52997);
((GeneralPath)shape).curveTo(643.0514, 780.48944, 642.92694, 780.0253, 642.969, 779.7803);
((GeneralPath)shape).curveTo(642.987, 776.9088, 643.0122, 774.0327, 642.9448, 771.1637);
((GeneralPath)shape).curveTo(642.9068, 771.144, 642.88794, 771.0616, 642.82574, 771.0976);
((GeneralPath)shape).closePath();
paint = new Color(38, 115, 71, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0_0_0_6);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_0_0_7 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_7
shape = new GeneralPath();
((GeneralPath)shape).moveTo(642.7041, 780.7211);
((GeneralPath)shape).curveTo(641.9267, 781.7601, 641.2298, 782.8913, 640.45526, 783.94086);
((GeneralPath)shape).curveTo(639.63776, 785.1365, 638.6303, 786.30286, 638.4315, 787.8044);
((GeneralPath)shape).curveTo(637.98413, 790.148, 637.53394, 792.5249, 637.5365, 794.9247);
((GeneralPath)shape).curveTo(637.82135, 795.15643, 638.33954, 794.9617, 638.7136, 795.02594);
((GeneralPath)shape).curveTo(640.1021, 795.00665, 641.50714, 795.06464, 642.8854, 794.99725);
((GeneralPath)shape).curveTo(642.97327, 793.9219, 642.8981, 792.78406, 642.9231, 791.68463);
((GeneralPath)shape).curveTo(642.9042, 788.0501, 642.9667, 784.41095, 642.8599, 780.7794);
((GeneralPath)shape).curveTo(642.84503, 780.7154, 642.7667, 780.68353, 642.7041, 780.7212);
((GeneralPath)shape).closePath();
paint = new Color(160, 160, 160, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0_0_0_7);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_0_0_8 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_8
shape = new GeneralPath();
((GeneralPath)shape).moveTo(634.2317, 777.7789);
((GeneralPath)shape).curveTo(633.7351, 778.8292, 632.67535, 779.4035, 631.79584, 780.07275);
((GeneralPath)shape).curveTo(630.8618, 780.7622, 629.7932, 781.36597, 628.60333, 781.34985);
((GeneralPath)shape).curveTo(627.9376, 781.39685, 627.2404, 781.3063, 626.58655, 781.40155);
((GeneralPath)shape).curveTo(626.62317, 781.67804, 626.4276, 782.28204, 626.8153, 782.31915);
((GeneralPath)shape).curveTo(627.066, 782.34576, 627.4102, 782.34576, 627.4438, 782.68164);
((GeneralPath)shape).curveTo(627.62915, 783.09186, 627.7385, 783.5714, 628.034, 783.9109);
((GeneralPath)shape).curveTo(629.2666, 783.8528, 630.522, 783.6944, 631.7445, 783.4957);
((GeneralPath)shape).curveTo(632.51227, 783.29425, 633.33673, 783.15045, 634.0156, 782.72534);
((GeneralPath)shape).curveTo(634.78424, 782.0341, 635.3504, 781.12134, 635.876, 780.24347);
((GeneralPath)shape).curveTo(635.33936, 779.4624, 634.96655, 778.5478, 634.3871, 777.78094);
((GeneralPath)shape).curveTo(634.3304, 777.73224, 634.28876, 777.73804, 634.2316, 777.77893);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(630.6192626953125, 782.3370971679688), new Point2D.Double(627.4911499023438, 782.8685913085938), new float[] {0.0f,1.0f}, new Color[] {new Color(84, 37, 92, 255),new Color(41, 57, 106, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0_0_0_8);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_0_0_9 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_9
shape = new GeneralPath();
((GeneralPath)shape).moveTo(622.0523, 772.64246);
((GeneralPath)shape).curveTo(621.7815, 773.04535, 621.8033, 773.6024, 621.6889, 774.07166);
((GeneralPath)shape).curveTo(621.3579, 776.0404, 621.664, 778.0471, 621.96954, 779.99915);
((GeneralPath)shape).curveTo(622.1467, 780.7626, 622.19147, 781.7006, 622.906, 782.1701);
((GeneralPath)shape).curveTo(623.86414, 782.8977, 624.9118, 783.57117, 626.0657, 783.91504);
((GeneralPath)shape).curveTo(626.6765, 783.98236, 627.332, 784.077, 627.91693, 783.85925);
((GeneralPath)shape).curveTo(628.0919, 783.6088, 627.7232, 783.3119, 627.6929, 783.0517);
((GeneralPath)shape).curveTo(627.5562, 782.6885, 627.35394, 782.19403, 626.89343, 782.25446);
((GeneralPath)shape).curveTo(626.4753, 782.13385, 626.7794, 781.54803, 626.53204, 781.2982);
((GeneralPath)shape).curveTo(626.3701, 781.24854, 626.5114, 780.9698, 626.3746, 780.8562);
((GeneralPath)shape).curveTo(625.2038, 779.338, 624.30316, 777.6076, 623.4619, 775.8857);
((GeneralPath)shape).curveTo(622.9911, 774.8296, 622.71375, 773.68585, 622.17346, 772.663);
((GeneralPath)shape).curveTo(622.14166, 772.6207, 622.09485, 772.63983, 622.05237, 772.64233);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(622.96533203125, 777.0225219726562), new Point2D.Double(622.4950561523438, 773.8612670898438), new float[] {0.0f,1.0f}, new Color[] {new Color(41, 57, 106, 255),new Color(68, 55, 5, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0_0_0_9);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_0_0_10 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_10
shape = new GeneralPath();
((GeneralPath)shape).moveTo(635.04956, 776.00964);
((GeneralPath)shape).curveTo(634.75543, 776.3689, 634.70636, 776.89624, 634.47205, 777.3068);
((GeneralPath)shape).curveTo(634.1834, 777.6432, 634.35846, 777.97675, 634.6068, 778.2644);
((GeneralPath)shape).curveTo(634.9993, 778.8336, 635.25555, 779.51025, 635.7129, 780.0296);
((GeneralPath)shape).curveTo(635.9973, 780.0518, 636.0555, 779.6132, 636.21564, 779.431);
((GeneralPath)shape).curveTo(636.3964, 779.05786, 636.6667, 778.70264, 636.77844, 778.30615);
((GeneralPath)shape).curveTo(636.10693, 777.6321, 635.80054, 776.66254, 635.1191, 776.00745);
((GeneralPath)shape).lineTo(635.0559, 776.00745);
((GeneralPath)shape).lineTo(635.0499, 776.00946);
((GeneralPath)shape).closePath();
paint = new Color(38, 115, 71, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0_0_0_10);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_0_0_11 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_11
shape = new GeneralPath();
((GeneralPath)shape).moveTo(630.715, 771.8403);
((GeneralPath)shape).curveTo(627.6704, 771.3745, 622.8588, 773.4785, 623.10913, 775.3396);
((GeneralPath)shape).curveTo(623.35944, 777.2007, 623.7481, 777.86835, 624.22955, 778.70087);
((GeneralPath)shape).curveTo(624.7054, 779.5236, 625.6201, 779.98737, 626.1525, 780.76);
((GeneralPath)shape).curveTo(628.28107, 781.8251, 630.91724, 780.6252, 632.6649, 779.23114);
((GeneralPath)shape).curveTo(634.07196, 778.0843, 636.61365, 777.0031, 634.20886, 773.38324);
((GeneralPath)shape).curveTo(633.69824, 772.6788, 631.1308, 772.066, 630.71497, 771.8403);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(618.2529296875, 770.80029296875), 5.485732f, new Point2D.Double(618.2529296875, 770.80029296875), new float[] {0.0f,0.7092865f,1.0f}, new Color[] {new Color(225, 86, 101, 255),new Color(139, 39, 70, 255),new Color(97, 27, 49, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.9657214283943176f, -0.2590981125831604f, 0.1941215693950653f, 0.7208499908447266f, -118.12615966796875f, 380.8826904296875f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0_0_0_11);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_0_0_12 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_12
shape = new GeneralPath();
((GeneralPath)shape).moveTo(629.29474, 772.4999);
((GeneralPath)shape).curveTo(629.0188, 772.5069, 629.1747, 772.82666, 629.34326, 772.8882);
((GeneralPath)shape).curveTo(630.39465, 773.71857, 631.4818, 774.5986, 632.214, 775.7549);
((GeneralPath)shape).curveTo(632.4335, 776.4038, 632.2672, 777.12244, 632.321, 777.79956);
((GeneralPath)shape).curveTo(632.21936, 778.1255, 631.7967, 778.2871, 631.5402, 778.5168);
((GeneralPath)shape).curveTo(630.59045, 779.18256, 629.618, 779.9236, 628.4307, 780.0467);
((GeneralPath)shape).curveTo(627.62646, 780.2096, 626.8104, 780.06976, 626.00616, 780.1128);
((GeneralPath)shape).curveTo(625.75226, 780.247, 625.95984, 780.62976, 626.21814, 780.561);
((GeneralPath)shape).curveTo(627.7717, 780.677, 629.4801, 780.6708, 630.78467, 779.67285);
((GeneralPath)shape).curveTo(631.6764, 779.04175, 632.60596, 778.4343, 633.3627, 777.6344);
((GeneralPath)shape).curveTo(633.9063, 776.7702, 634.3324, 775.8108, 634.5356, 774.80695);
((GeneralPath)shape).curveTo(634.57227, 774.0901, 633.8308, 773.6919, 633.43097, 773.2124);
((GeneralPath)shape).curveTo(633.0605, 773.01776, 631.50446, 772.3692, 631.0919, 772.26935);
((GeneralPath)shape).curveTo(630.123, 772.14905, 629.7711, 772.169, 628.7985, 772.0754);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(633.65283203125, 774.699951171875), 4.3230734f, new Point2D.Double(633.65283203125, 774.699951171875), new float[] {0.0f,1.0f}, new Color[] {new Color(54, 52, 54, 255),new Color(100, 28, 50, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-0.6764160990715027f, -0.20700441300868988f, 0.20498496294021606f, -0.6673287153244019f, 902.9825439453125f, 1422.1575927734375f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_0_0_0_12);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_0_0_13 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_13
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.0114605f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(633.0369, 766.6539);
((GeneralPath)shape).curveTo(632.7139, 767.57916, 632.9077, 768.5044, 632.9077, 768.5044);
((GeneralPath)shape).curveTo(632.9077, 768.5044, 629.74225, 768.10785, 628.19183, 768.17395);
((GeneralPath)shape).curveTo(626.6414, 768.24005, 622.1193, 771.9411, 622.1193, 771.9411);
((GeneralPath)shape).curveTo(621.6025, 773.9899, 621.4087, 774.91516, 621.5379, 776.69965);
((GeneralPath)shape).curveTo(621.6671, 778.4841, 621.9901, 781.1938, 622.5069, 781.85474);
((GeneralPath)shape).curveTo(623.0237, 782.5157, 625.67236, 784.03577, 626.4476, 784.03577);
((GeneralPath)shape).curveTo(627.2228, 784.03577, 630.1298, 783.7714, 630.71124, 783.7053);
((GeneralPath)shape).curveTo(631.29266, 783.6392, 633.1015, 783.3088, 634.0059, 782.78);
((GeneralPath)shape).curveTo(634.91034, 782.2513, 637.0116, 777.965, 637.0116, 777.965);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_0_0_0_13);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_0_0_14 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_14
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.011f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(643.11475, 771.01587);
((GeneralPath)shape).curveTo(642.14575, 771.082, 638.91565, 773.39514, 638.91565, 773.39514);
((GeneralPath)shape).lineTo(638.14044, 775.5761);
((GeneralPath)shape).lineTo(635.1042, 782.1191);
((GeneralPath)shape).lineTo(628.32104, 786.415);
((GeneralPath)shape).curveTo(628.32104, 786.415, 625.414, 786.415, 624.5096, 786.7454);
((GeneralPath)shape).curveTo(623.60516, 787.07587, 621.4733, 790.2482, 621.4733, 790.2482);
((GeneralPath)shape).lineTo(619.9229, 792.89185);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_0_0_0_14);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_0_0_15 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_15
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.0114605f,1,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(642.7271, 780.4668);
((GeneralPath)shape).curveTo(642.0165, 782.053, 639.0448, 785.4897, 638.6572, 786.7454);
((GeneralPath)shape).curveTo(638.2696, 788.00116, 637.559, 792.4953, 637.559, 793.2223);
((GeneralPath)shape).curveTo(637.559, 793.9493, 637.48883, 795.0899, 637.48883, 795.0899);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_0_0_0_15);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_0_0_16 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_16
shape = new GeneralPath();
((GeneralPath)shape).moveTo(624.65686, 779.78973);
((GeneralPath)shape).curveTo(628.1495, 784.1255, 637.9568, 777.83136, 633.8244, 773.6148);
((GeneralPath)shape).lineTo(632.8983, 772.8222);
((GeneralPath)shape).lineTo(631.94495, 772.06396);
paint = new LinearGradientPaint(new Point2D.Double(626.9586791992188, 781.4070434570312), new Point2D.Double(627.0252685546875, 781.141357421875), new float[] {0.0f,1.0f}, new Color[] {new Color(173, 148, 43, 255),new Color(173, 148, 43, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.07089447975158691f, -0.14152559638023376f));
g.setPaint(paint);
g.fill(shape);
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.0114605f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(624.65686, 779.78973);
((GeneralPath)shape).curveTo(628.1495, 784.1255, 637.9568, 777.83136, 633.8244, 773.6148);
((GeneralPath)shape).lineTo(632.8983, 772.8222);
((GeneralPath)shape).lineTo(631.94495, 772.06396);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_0_0_0_16);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_0_0_17 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0_0_0_17
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.0114605f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(621.15155, 763.2172);
((GeneralPath)shape).curveTo(620.96515, 767.9541, 620.55304, 770.35345, 620.43964, 770.81757);
((GeneralPath)shape).curveTo(620.3104, 771.3463, 619.1476, 772.8664, 618.76, 773.32904);
((GeneralPath)shape).curveTo(618.37244, 773.7917, 618.2432, 779.0789, 618.37244, 779.54156);
((GeneralPath)shape).curveTo(618.50165, 780.0042, 614.884, 782.77997, 614.30255, 783.2426);
((GeneralPath)shape).curveTo(613.7211, 783.70526, 613.7211, 783.83746, 614.238, 784.56445);
((GeneralPath)shape).curveTo(614.75476, 785.29144, 619.4707, 792.82574, 620.0521, 793.09015);
((GeneralPath)shape).curveTo(620.63354, 793.3545, 627.2229, 793.88324, 627.4167, 794.01544);
((GeneralPath)shape).curveTo(627.6105, 794.14764, 627.2875, 794.94073, 627.2875, 794.94073);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_0_0_0_17);
g.setTransform(defaultTransform__0_0_0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 611.5220336914062f, 766.1766357421875f));
// _0_0_0_0_1
paint = new Color(0, 0, 0, 255);
stroke = new BasicStroke(1.0f,1,1,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(0.14355525, 12.045818);
((GeneralPath)shape).curveTo(0.9331093, 13.409594, 1.0048869, 14.9169235, 1.0048869, 14.9169235);
((GeneralPath)shape).curveTo(1.0061969, 16.13976, 1.2679598, 17.88351, 1.6508856, 19.869581);
((GeneralPath)shape).lineTo(2.512217, 21.089802);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_0_0_1);
g.setTransform(defaultTransform__0_0_0_0);
g.setTransform(defaultTransform__0_0_0);
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

