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
public class draw_roi2 implements ResizableIcon {
    

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
g.transform(new AffineTransform(1.0666667222976685f, 0.0f, 0.0f, 1.0666667222976685f, -0.0f, -0.0f));
// _0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, -343.7007751464844f));
// _0_0
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_0
paint = new Color(255, 255, 0, 255);
stroke = new BasicStroke(55.323944f,0,0,4.0f,null,0.0f);
shape = new GeneralPath();
((GeneralPath)shape).moveTo(389.36908, 378.59903);
((GeneralPath)shape).curveTo(342.05927, 379.01486, 294.78314, 383.2077, 248.1386, 391.12454);
((GeneralPath)shape).curveTo(223.51381, 395.30402, 198.66672, 400.6619, 176.69513, 412.5403);
((GeneralPath)shape).curveTo(165.70934, 418.47952, 155.53157, 426.03955, 147.21364, 435.35483);
((GeneralPath)shape).curveTo(138.89569, 444.67007, 132.47147, 455.7775, 129.24968, 467.84323);
((GeneralPath)shape).curveTo(125.37266, 482.36288, 126.23848, 497.95206, 130.6291, 512.3247);
((GeneralPath)shape).curveTo(135.01973, 526.6974, 142.8345, 539.89, 152.46996, 551.42303);
((GeneralPath)shape).curveTo(171.74084, 574.489, 197.77066, 590.7103, 223.40332, 606.40656);
((GeneralPath)shape).curveTo(258.06274, 627.6304, 293.99103, 649.6921, 316.5381, 683.5056);
((GeneralPath)shape).curveTo(327.8116, 700.41235, 335.36002, 720.1194, 336.1088, 740.4263);
((GeneralPath)shape).curveTo(336.85757, 760.73315, 330.423, 781.59674, 316.75903, 796.6376);
((GeneralPath)shape).curveTo(302.86823, 811.9281, 282.56946, 820.2744, 262.10617, 823.10455);
((GeneralPath)shape).curveTo(241.64288, 825.9347, 220.82916, 823.70386, 200.40036, 820.63477);
((GeneralPath)shape).curveTo(179.97156, 817.5657, 159.5823, 813.6517, 138.9314, 813.10803);
((GeneralPath)shape).curveTo(118.28047, 812.56433, 97.052315, 815.5934, 78.98116, 825.6028);
((GeneralPath)shape).curveTo(60.653214, 835.75446, 46.441654, 852.88184, 39.16655, 872.5298);
((GeneralPath)shape).curveTo(31.891447, 892.1778, 31.474049, 914.1758, 37.30143, 934.3007);
((GeneralPath)shape).curveTo(43.128815, 954.42566, 55.076176, 972.6302, 70.73965, 986.54517);
((GeneralPath)shape).curveTo(86.40312, 1000.46014, 105.69519, 1010.1187, 126.058, 1015.0509);
((GeneralPath)shape).curveTo(148.88968, 1020.5811, 172.85915, 1020.2374, 196.05508, 1016.5202);
((GeneralPath)shape).curveTo(219.25102, 1012.803, 241.78801, 1005.7849, 263.97064, 998.0518);
((GeneralPath)shape).curveTo(308.33594, 982.58575, 352.77716, 963.9379, 399.74188, 962.60034);
((GeneralPath)shape).curveTo(446.56314, 961.26685, 492.14114, 977.30054, 538.84644, 980.8539);
((GeneralPath)shape).curveTo(562.1991, 982.63055, 586.1518, 981.1856, 608.13525, 973.10913);
((GeneralPath)shape).curveTo(630.1187, 965.03265, 650.0409, 949.8128, 660.6592, 928.93805);
((GeneralPath)shape).curveTo(668.8794, 912.7778, 671.1782, 893.9213, 668.51184, 875.9876);
((GeneralPath)shape).curveTo(665.8455, 858.0539, 658.38416, 841.0239, 648.20917, 826.01733);
((GeneralPath)shape).curveTo(627.85925, 796.0042, 597.47, 774.4857, 567.3034, 754.3639);
((GeneralPath)shape).curveTo(546.18494, 740.27734, 524.39935, 726.1392, 508.98135, 705.9723);
((GeneralPath)shape).curveTo(501.27237, 695.8888, 495.28778, 684.3468, 492.5694, 671.9486);
((GeneralPath)shape).curveTo(489.85098, 659.5504, 490.52097, 646.26794, 495.4913, 634.58887);
((GeneralPath)shape).curveTo(502.098, 619.06476, 515.71466, 607.4512, 530.5646, 599.44336);
((GeneralPath)shape).curveTo(545.4145, 591.43555, 561.69366, 586.5325, 577.4992, 580.6307);
((GeneralPath)shape).curveTo(593.30475, 574.72894, 609.04944, 567.57587, 621.3147, 555.99097);
((GeneralPath)shape).curveTo(627.4473, 550.19855, 632.62994, 543.3265, 636.01495, 535.59973);
((GeneralPath)shape).curveTo(639.39996, 527.8729, 640.94244, 519.27234, 639.91345, 510.8996);
((GeneralPath)shape).curveTo(638.9966, 503.43964, 636.06335, 496.29407, 631.87115, 490.0557);
((GeneralPath)shape).curveTo(627.67896, 483.81732, 622.2516, 478.4635, 616.2416, 473.94995);
((GeneralPath)shape).curveTo(604.2216, 464.92285, 590.0539, 459.29358, 576.08044, 453.75198);
((GeneralPath)shape).curveTo(513.71576, 429.0194, 451.4775, 403.96796, 389.36896, 378.599);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_0_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_0
shape = new GeneralPath();
((GeneralPath)shape).moveTo(353.02197, 372.732);
((GeneralPath)shape).lineTo(353.02197, 362.30624);
((GeneralPath)shape).lineTo(353.02197, 372.732);
((GeneralPath)shape).closePath();
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_0);
g.setComposite(AlphaComposite.getInstance(3, 0.38139534f * origAlpha));
AffineTransform defaultTransform__0_0_1_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_1
shape = new GeneralPath();
((GeneralPath)shape).moveTo(676.89496, 819.6589);
((GeneralPath)shape).curveTo(676.895, 824.87054, 648.5474, 829.8687, 598.0884, 833.55396);
((GeneralPath)shape).curveTo(547.6293, 837.23914, 479.19208, 839.30945, 407.83215, 839.30945);
((GeneralPath)shape).curveTo(336.47223, 839.30945, 268.03503, 837.23914, 217.57596, 833.55396);
((GeneralPath)shape).curveTo(167.11688, 829.8687, 138.7693, 824.87054, 138.76935, 819.6589);
((GeneralPath)shape).curveTo(138.7693, 814.4472, 167.11688, 809.44904, 217.57596, 805.7638);
((GeneralPath)shape).curveTo(268.03503, 802.0786, 336.47223, 800.0083, 407.83215, 800.0083);
((GeneralPath)shape).curveTo(479.19208, 800.0083, 547.6293, 802.0786, 598.0884, 805.7638);
((GeneralPath)shape).curveTo(648.5474, 809.44904, 676.895, 814.4472, 676.89496, 819.6589);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(63.912208557128906, 115.70919036865234), 63.91221f, new Point2D.Double(14.046639442443848, 115.70919036865234), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(4.20988130569458f, 0.0f, 0.0f, 0.3074614405632019f, 138.7693328857422f, 784.0827026367188f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_2
shape = new GeneralPath();
((GeneralPath)shape).moveTo(628.9133, 362.00558);
((GeneralPath)shape).curveTo(631.1634, 359.84766, 645.671, 361.1014, 660.90643, 373.66754);
((GeneralPath)shape).curveTo(676.29126, 386.35687, 679.2074, 398.4606, 676.3889, 401.16345);
((GeneralPath)shape).curveTo(674.55444, 402.9228, 672.72, 404.6821, 670.8855, 406.44144);
((GeneralPath)shape).curveTo(655.0602, 393.3888, 639.235, 380.33618, 623.4097, 367.28354);
((GeneralPath)shape).curveTo(625.2442, 365.5242, 627.07874, 363.7649, 628.9133, 362.00555);
((GeneralPath)shape).curveTo(628.9133, 362.00555, 628.9133, 362.00555, 628.9133, 362.00555);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_3
shape = new GeneralPath();
((GeneralPath)shape).moveTo(196.23973, 819.94055);
((GeneralPath)shape).lineTo(325.6214, 738.2057);
((GeneralPath)shape).lineTo(326.35495, 737.5022);
((GeneralPath)shape).lineTo(279.6585, 697.5969);
((GeneralPath)shape).lineTo(278.66425, 698.5501);
((GeneralPath)shape).lineTo(196.23975, 819.9406);
((GeneralPath)shape).closePath();
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_3);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_4
shape = new GeneralPath();
((GeneralPath)shape).moveTo(203.7178, 813.27216);
((GeneralPath)shape).lineTo(324.3718, 737.09717);
((GeneralPath)shape).lineTo(325.1053, 736.3937);
((GeneralPath)shape).lineTo(280.90817, 698.7053);
((GeneralPath)shape).lineTo(279.91385, 699.6585);
((GeneralPath)shape).lineTo(203.7178, 813.27216);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(42.617530822753906, 120.64187622070312), 3.406888f, new Point2D.Double(42.617530822753906, 120.64187622070312), new float[] {0.0f,1.0f}, new Color[] {new Color(180, 148, 42, 255),new Color(228, 220, 201, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(6.570230960845947f, 6.1048383712768555f, -62.44815444946289f, 52.842552185058594f, 7558.2216796875f, -5905.86083984375f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_4);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1_5 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_5
shape = new GeneralPath();
((GeneralPath)shape).moveTo(298.77533, 721.6083);
((GeneralPath)shape).curveTo(304.6311, 726.43805, 310.61917, 724.62744, 312.71237, 726.3538);
((GeneralPath)shape).curveTo(313.05063, 726.6328, 313.27524, 727.01373, 313.43427, 727.42096);
((GeneralPath)shape).lineTo(661.58966, 392.88388);
((GeneralPath)shape).lineTo(638.57623, 373.90244);
((GeneralPath)shape).lineTo(289.75983, 709.0733);
((GeneralPath)shape).curveTo(290.80933, 708.9983, 291.74008, 709.0558, 292.40213, 709.6019);
((GeneralPath)shape).curveTo(294.31537, 711.18, 292.8924, 716.756, 298.77533, 721.6083);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(15.727076530456543, 58.08968734741211), 2.6143966f, new Point2D.Double(15.727076530456543, 58.08968734741211), new float[] {0.0f,0.5f,0.75f,1.0f}, new Color[] {new Color(37, 37, 37, 255),new Color(37, 37, 37, 255),new Color(37, 37, 37, 255),new Color(0, 0, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(8.260855674743652f, 6.9448347091674805f, -112.30320739746094f, 107.24173736572266f, 6817.0888671875f, -5744.421875f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_5);
g.setComposite(AlphaComposite.getInstance(3, 0.35348833f * origAlpha));
AffineTransform defaultTransform__0_0_1_6 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_6
shape = new GeneralPath();
((GeneralPath)shape).moveTo(325.8609, 714.0049);
((GeneralPath)shape).lineTo(312.22806, 727.0789);
((GeneralPath)shape).curveTo(314.05768, 728.86194, 311.54773, 733.7736, 315.0645, 736.6742);
((GeneralPath)shape).curveTo(318.85452, 739.80023, 322.96957, 736.2571, 325.43253, 738.2648);
((GeneralPath)shape).lineTo(339.2306, 725.0321);
((GeneralPath)shape).lineTo(325.86087, 714.0049);
((GeneralPath)shape).closePath();
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_6);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1_7 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_7
shape = new GeneralPath();
((GeneralPath)shape).moveTo(660.74945, 392.19095);
((GeneralPath)shape).lineTo(312.8585, 726.47437);
((GeneralPath)shape).curveTo(314.69815, 728.2658, 312.82568, 732.57874, 316.3606, 735.49414);
((GeneralPath)shape).curveTo(320.16992, 738.6362, 323.65585, 735.6986, 326.13132, 737.71643);
((GeneralPath)shape).lineTo(674.1875, 403.27466);
((GeneralPath)shape).lineTo(660.74945, 392.19095);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(36.6756477355957, 95.76927947998047), 47.746403f, new Point2D.Double(16.21735382080078, 64.14128112792969), new float[] {0.0f,0.09292036f,0.5043171f,0.91571385f,1.0f}, new Color[] {new Color(154, 118, 0, 255),new Color(227, 173, 0, 255),new Color(255, 205, 44, 255),new Color(227, 173, 0, 255),new Color(185, 141, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.28099381923675537f, 0.23880119621753693f, -5.642953872680664f, 5.276689529418945f, 1006.7507934570312f, 45.78274917602539f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_7);
g.setComposite(AlphaComposite.getInstance(3, 0.38604653f * origAlpha));
AffineTransform defaultTransform__0_0_1_8 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_8
shape = new GeneralPath();
((GeneralPath)shape).moveTo(299.02985, 703.2516);
((GeneralPath)shape).lineTo(292.0365, 709.9583);
((GeneralPath)shape).lineTo(291.77164, 710.20654);
((GeneralPath)shape).curveTo(293.33435, 711.5822, 291.05197, 716.5794, 296.06674, 721.5355);
((GeneralPath)shape).lineTo(296.35898, 721.7765);
((GeneralPath)shape).lineTo(298.44116, 723.49384);
((GeneralPath)shape).lineTo(298.7334, 723.7349);
((GeneralPath)shape).curveTo(304.72302, 727.8554, 310.1521, 725.3667, 312.2452, 727.0931);
((GeneralPath)shape).lineTo(319.6517, 719.9531);
((GeneralPath)shape).lineTo(299.02982, 703.2516);
((GeneralPath)shape).closePath();
paint = new Color(37, 37, 37, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_8);
g.setComposite(AlphaComposite.getInstance(3, 0.35348833f * origAlpha));
AffineTransform defaultTransform__0_0_1_9 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_9
shape = new GeneralPath();
((GeneralPath)shape).moveTo(285.73077, 692.1508);
((GeneralPath)shape).lineTo(278.65155, 698.5677);
((GeneralPath)shape).curveTo(278.72495, 698.62787, 278.14713, 699.187, 278.22076, 699.24774);
((GeneralPath)shape).curveTo(279.72296, 700.4867, 277.639, 705.48145, 280.13733, 708.39703);
((GeneralPath)shape).lineTo(280.39304, 708.6079);
((GeneralPath)shape).lineTo(281.5254, 709.54193);
((GeneralPath)shape).lineTo(281.67157, 709.66235);
((GeneralPath)shape).curveTo(285.20917, 711.76044, 289.9579, 709.14984, 291.77167, 710.2066);
((GeneralPath)shape).lineTo(299.1005, 703.1782);
((GeneralPath)shape).lineTo(285.73077, 692.1509);
((GeneralPath)shape).closePath();
paint = new Color(19, 19, 19, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_9);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1_10 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_10
shape = new GeneralPath();
((GeneralPath)shape).moveTo(282.27237, 707.82104);
((GeneralPath)shape).curveTo(285.95947, 710.79175, 290.45035, 707.9921, 292.40213, 709.6019);
((GeneralPath)shape).lineTo(640.29315, 375.31854);
((GeneralPath)shape).lineTo(626.71185, 364.11676);
((GeneralPath)shape).lineTo(278.65558, 698.55865);
((GeneralPath)shape).curveTo(278.73016, 698.61975, 278.80338, 698.6806, 278.8782, 698.7424);
((GeneralPath)shape).curveTo(280.40417, 700.0009, 278.55774, 704.8275, 282.2724, 707.8211);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(11.326383590698242, 57.38399887084961), new Point2D.Double(14.493531227111816, 57.38399887084961), new float[] {0.0f,0.09292036f,0.5043171f,0.91571385f,1.0f}, new Color[] {new Color(154, 118, 0, 255),new Color(227, 173, 0, 255),new Color(255, 205, 44, 255),new Color(227, 173, 0, 255),new Color(185, 141, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(4.569131374359131f, 3.779585838317871f, -4.249693870544434f, 4.063684463500977f, 642.5931396484375f, 256.6349792480469f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_10);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1_11 = g.getTransform();
g.transform(new AffineTransform(0.7719321250915527f, 0.6357049942016602f, -0.7237294316291809f, 0.6900838017463684f, 0.0f, 0.0f));
// _0_0_1_11
shape = new GeneralPath();
((GeneralPath)shape).moveTo(701.1333, -121.01515);
((GeneralPath)shape).lineTo(762.6639, -121.01515);
((GeneralPath)shape).lineTo(762.6639, -106.67726);
((GeneralPath)shape).lineTo(701.1333, -106.67726);
((GeneralPath)shape).closePath();
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_11);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1_12 = g.getTransform();
g.transform(new AffineTransform(0.7219375371932983f, -0.6919582486152649f, -0.7724744081497192f, -0.6350458860397339f, 0.0f, 0.0f));
// _0_0_1_12
shape = new GeneralPath();
((GeneralPath)shape).moveTo(119.72179, -709.89);
((GeneralPath)shape).curveTo(119.72179, -707.834, 98.91623, -705.8621, 61.882088, -704.4083);
((GeneralPath)shape).curveTo(24.847948, -702.95447, -25.381126, -702.1377, -77.75531, -702.1377);
((GeneralPath)shape).curveTo(-130.1295, -702.1377, -180.35858, -702.95447, -217.39272, -704.4083);
((GeneralPath)shape).curveTo(-254.42686, -705.8621, -275.23242, -707.834, -275.23242, -709.89);
((GeneralPath)shape).curveTo(-275.23242, -711.94604, -254.42686, -713.9179, -217.39273, -715.3717);
((GeneralPath)shape).curveTo(-180.35858, -716.82556, -130.12952, -717.64233, -77.755325, -717.64233);
((GeneralPath)shape).curveTo(-25.381142, -717.64233, 24.847933, -716.82556, 61.882072, -715.3717);
((GeneralPath)shape).curveTo(98.916214, -713.9179, 119.72177, -711.94604, 119.72177, -709.89);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(34.67763900756836, 7.462276935577393), 47.595196f, new Point2D.Double(34.67763900756836, 7.462276935577393), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 174),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(4.157475471496582f, -0.06257937848567963f, 0.0023558600805699825f, 0.16346268355846405f, -221.94430541992188f, -708.939697265625f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_12);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1_13 = g.getTransform();
g.transform(new AffineTransform(0.7207286953926086f, -0.6932172775268555f, -0.7712075710296631f, -0.6365837454795837f, 0.0f, 0.0f));
// _0_0_1_13
shape = new GeneralPath();
((GeneralPath)shape).moveTo(122.9193, -717.7872);
((GeneralPath)shape).curveTo(122.91923, -716.4419, 13.114985, -715.3484, -123.0309, -715.3378);
((GeneralPath)shape).curveTo(-259.1778, -715.3273, -370.7075, -716.4036, -372.8449, -717.7487);
((GeneralPath)shape).curveTo(-374.9853, -719.0938, -266.93268, -720.2043, -130.81923, -720.23596);
((GeneralPath)shape).curveTo(5.2921505, -720.26764, 118.51848, -719.2088, 122.796936, -717.8642);
paint = new RadialGradientPaint(new Point2D.Double(34.67763900756836, 7.462276935577393), 47.595196f, new Point2D.Double(34.67763900756836, 7.462276935577393), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 174),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-5.208438873291016f, 0.015292719937860966f, -4.024799563921988E-4f, -0.05274736136198044f, 55.64145278930664f, -717.9238891601562f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_13);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1_14 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_14
shape = new GeneralPath();
((GeneralPath)shape).moveTo(604.5706, 385.3876);
((GeneralPath)shape).curveTo(597.86127, 389.1182, 591.5023, 395.621, 588.0864, 401.19617);
((GeneralPath)shape).lineTo(626.2529, 432.38962);
((GeneralPath)shape).lineTo(642.7371, 416.58105);
((GeneralPath)shape).lineTo(604.5707, 385.3876);
((GeneralPath)shape).closePath();
((GeneralPath)shape).moveTo(638.72577, 413.2726);
((GeneralPath)shape).lineTo(622.2416, 429.08118);
((GeneralPath)shape).lineTo(635.6123, 440.1093);
((GeneralPath)shape).curveTo(641.45667, 436.99585, 648.16235, 430.80072, 652.0965, 424.30075);
((GeneralPath)shape).lineTo(638.7257, 413.2726);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(49.009883880615234, 8.495311737060547), 3.9750404f, new Point2D.Double(47.370887756347656, 6.770169734954834), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(174, 174, 174, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(5.934463024139404f, 4.894739151000977f, -2.0734591484069824f, 1.9884785413742065f, 347.0319519042969f, 155.96505737304688f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_14);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1_15 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_15
shape = new GeneralPath();
((GeneralPath)shape).moveTo(251.87437, 784.957);
((GeneralPath)shape).curveTo(243.19154, 784.2003, 235.72958, 772.5368, 230.9276, 768.9684);
((GeneralPath)shape).lineTo(196.24658, 819.91486);
((GeneralPath)shape).lineTo(251.87437, 784.957);
((GeneralPath)shape).closePath();
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_15);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1_16 = g.getTransform();
g.transform(new AffineTransform(0.7714493274688721f, 0.6362907290458679f, -0.7217420935630798f, 0.6921620965003967f, 0.0f, 0.0f));
// _0_0_1_16
shape = new GeneralPath();
((GeneralPath)shape).moveTo(718.94617, -123.67453);
((GeneralPath)shape).lineTo(745.47986, -123.67453);
((GeneralPath)shape).lineTo(745.47986, -117.9172);
((GeneralPath)shape).lineTo(718.94617, -117.9172);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(49.01197052001953, 2.6743078231811523), 1.7246193f, new Point2D.Double(49.01197052001953, 2.6743078231811523), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(37, 37, 37, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(7.692623615264893f, 0.0f, 0.0f, 0.9276914000511169f, 355.1824035644531f, -123.84526062011719f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_16);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1_17 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_17
shape = new GeneralPath();
((GeneralPath)shape).moveTo(656.1493, 370.85483);
((GeneralPath)shape).curveTo(666.00684, 377.82935, 672.9651, 387.35995, 673.34094, 388.27097);
((GeneralPath)shape).curveTo(673.71686, 389.18198, 664.20703, 378.49463, 656.0475, 373.54507);
((GeneralPath)shape).curveTo(647.9503, 368.6333, 636.51434, 368.34613, 635.67993, 367.75034);
((GeneralPath)shape).curveTo(634.8455, 367.15457, 629.2287, 361.71378, 634.4108, 361.9874);
((GeneralPath)shape).curveTo(639.8311, 362.2736, 648.5352, 365.4727, 656.1493, 370.85483);
((GeneralPath)shape).closePath();
paint = new LinearGradientPaint(new Point2D.Double(48.49856185913086, 0.8115049600601196), new Point2D.Double(48.732723236083984, 2.365726947784424), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 174),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(5.934463024139404f, 4.894739151000977f, -5.503552436828613f, 5.277980327606201f, 376.17156982421875f, 128.01966857910156f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_17);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1_18 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_18
shape = new GeneralPath();
((GeneralPath)shape).moveTo(351.46066, 698.456);
((GeneralPath)shape).curveTo(350.3892, 699.4825, 349.7841, 700.46497, 349.6452, 701.4035);
((GeneralPath)shape).curveTo(349.50632, 702.34216, 349.8468, 703.1499, 350.6667, 703.8268);
((GeneralPath)shape).curveTo(351.4831, 704.5008, 352.41235, 704.7414, 353.45447, 704.54865);
((GeneralPath)shape).curveTo(354.4966, 704.3557, 355.55334, 703.74615, 356.62476, 702.7197);
((GeneralPath)shape).curveTo(357.70233, 701.6874, 358.31046, 700.70197, 358.4494, 699.76337);
((GeneralPath)shape).curveTo(358.58826, 698.8247, 358.24942, 698.0185, 357.4331, 697.3444);
((GeneralPath)shape).curveTo(356.61322, 696.6675, 355.68222, 696.4255, 354.64014, 696.61835);
((GeneralPath)shape).curveTo(353.59802, 696.81116, 352.53824, 697.4237, 351.46072, 698.456);
((GeneralPath)shape).moveTo(350.00687, 697.25555);
((GeneralPath)shape).curveTo(352.19843, 695.156, 354.27292, 693.80676, 356.23044, 693.2079);
((GeneralPath)shape).curveTo(358.1879, 692.609, 359.79724, 692.83026, 361.05826, 693.8714);
((GeneralPath)shape).curveTo(362.31583, 694.9098, 362.68152, 696.31915, 362.1553, 698.0998);
((GeneralPath)shape).curveTo(361.62906, 699.88043, 360.27017, 701.8205, 358.0786, 703.9201);
((GeneralPath)shape).curveTo(355.8932, 706.0138, 353.8187, 707.36304, 351.85504, 707.9678);
((GeneralPath)shape).curveTo(349.89755, 708.5666, 348.29004, 708.3469, 347.0324, 707.30853);
((GeneralPath)shape).curveTo(345.7714, 706.2674, 345.40396, 704.85645, 345.9302, 703.07587);
((GeneralPath)shape).curveTo(346.46252, 701.2894, 347.8214, 699.34937, 350.00684, 697.25555);
((GeneralPath)shape).moveTo(370.55765, 684.6127);
((GeneralPath)shape).lineTo(379.2585, 683.35956);
((GeneralPath)shape).lineTo(375.59677, 686.8676);
((GeneralPath)shape).lineTo(369.75235, 687.7264);
((GeneralPath)shape).lineTo(369.2505, 692.9475);
((GeneralPath)shape).lineTo(365.57056, 696.47296);
((GeneralPath)shape).lineTo(366.32977, 688.663);
((GeneralPath)shape).lineTo(357.97314, 689.8745);
((GeneralPath)shape).lineTo(361.64398, 686.3577);
((GeneralPath)shape).lineTo(367.1364, 685.5666);
((GeneralPath)shape).lineTo(367.6068, 680.6452);
((GeneralPath)shape).lineTo(371.2959, 677.11096);
((GeneralPath)shape).lineTo(370.55768, 684.6126);
((GeneralPath)shape).moveTo(371.6794, 676.7435);
((GeneralPath)shape).lineTo(375.52374, 673.0606);
((GeneralPath)shape).lineTo(381.40063, 672.3751);
((GeneralPath)shape).lineTo(381.7331, 667.1118);
((GeneralPath)shape).lineTo(385.58655, 663.4201);
((GeneralPath)shape).lineTo(384.89307, 672.1151);
((GeneralPath)shape).lineTo(388.17084, 674.82135);
((GeneralPath)shape).lineTo(384.65518, 678.18945);
((GeneralPath)shape).lineTo(381.3775, 675.48315);
((GeneralPath)shape).lineTo(371.67944, 676.7436);
((GeneralPath)shape).moveTo(406.54922, 656.1827);
((GeneralPath)shape).curveTo(405.9157, 657.22327, 405.18802, 658.2457, 404.36606, 659.25006);
((GeneralPath)shape).curveTo(403.54407, 660.25446, 402.63083, 661.2378, 401.6264, 662.2001);
((GeneralPath)shape).curveTo(399.35568, 664.3755, 397.19556, 665.80054, 395.14584, 666.47534);
((GeneralPath)shape).curveTo(393.0927, 667.14734, 391.446, 666.9712, 390.20578, 665.94727);
((GeneralPath)shape).curveTo(388.9516, 664.9118, 388.64075, 663.4498, 389.27313, 661.5614);
((GeneralPath)shape).curveTo(389.90546, 659.67285, 391.39658, 657.6031, 393.74634, 655.3519);
((GeneralPath)shape).curveTo(394.65344, 654.4829, 395.56955, 653.69196, 396.49472, 652.9791);
((GeneralPath)shape).curveTo(397.426, 652.26044, 398.35544, 651.6272, 399.2831, 651.07916);
((GeneralPath)shape).lineTo(400.89334, 652.4087);
((GeneralPath)shape).curveTo(399.8857, 652.934, 398.9437, 653.5081, 398.06723, 654.13086);
((GeneralPath)shape).curveTo(397.19687, 654.74774, 396.3842, 655.4179, 395.6294, 656.14105);
((GeneralPath)shape).curveTo(394.22925, 657.4824, 393.3728, 658.70264, 393.05997, 659.80164);
((GeneralPath)shape).curveTo(392.7498, 660.892, 393.00986, 661.77997, 393.84012, 662.4654);
((GeneralPath)shape).curveTo(394.66345, 663.1452, 395.6645, 663.3201, 396.84317, 662.9903);
((GeneralPath)shape).curveTo(398.0218, 662.66046, 399.28375, 661.85114, 400.62918, 660.5622);
((GeneralPath)shape).curveTo(400.9944, 660.21234, 401.32007, 659.8786, 401.60626, 659.56104);
((GeneralPath)shape).curveTo(401.89502, 659.23486, 402.13644, 658.9292, 402.33038, 658.6442);
((GeneralPath)shape).lineTo(400.81924, 657.3965);
((GeneralPath)shape).lineTo(398.6733, 659.45233);
((GeneralPath)shape).lineTo(397.32895, 658.3423);
((GeneralPath)shape).lineTo(402.80777, 653.0934);
((GeneralPath)shape).lineTo(406.5493, 656.18256);
((GeneralPath)shape).moveTo(402.43408, 647.2797);
((GeneralPath)shape).lineTo(411.92163, 638.19037);
((GeneralPath)shape).lineTo(413.438, 639.4423);
((GeneralPath)shape).lineTo(407.46603, 645.16364);
((GeneralPath)shape).lineTo(408.9147, 646.35974);
((GeneralPath)shape).lineTo(414.53055, 640.9796);
((GeneralPath)shape).lineTo(416.04694, 642.2316);
((GeneralPath)shape).lineTo(410.43112, 647.61176);
((GeneralPath)shape).lineTo(412.21332, 649.08325);
((GeneralPath)shape).lineTo(418.38614, 643.1695);
((GeneralPath)shape).lineTo(419.90256, 644.4215);
((GeneralPath)shape).lineTo(410.2141, 653.70337);
((GeneralPath)shape).lineTo(402.4341, 647.2798);
((GeneralPath)shape).moveTo(415.2181, 635.03235);
((GeneralPath)shape).lineTo(419.1446, 631.2706);
((GeneralPath)shape).lineTo(429.43903, 630.9261);
((GeneralPath)shape).lineTo(424.10297, 626.5204);
((GeneralPath)shape).lineTo(427.4359, 623.32733);
((GeneralPath)shape).lineTo(435.2159, 629.75085);
((GeneralPath)shape).lineTo(431.2894, 633.5126);
((GeneralPath)shape).lineTo(420.99496, 633.85706);
((GeneralPath)shape).lineTo(426.33105, 638.2628);
((GeneralPath)shape).lineTo(422.99808, 641.4559);
((GeneralPath)shape).lineTo(415.21808, 635.03235);
((GeneralPath)shape).moveTo(437.3526, 613.8268);
((GeneralPath)shape).lineTo(441.2791, 610.0651);
((GeneralPath)shape).lineTo(451.57352, 609.7205);
((GeneralPath)shape).lineTo(446.23746, 605.3149);
((GeneralPath)shape).lineTo(449.5704, 602.12177);
((GeneralPath)shape).lineTo(457.3504, 608.5453);
((GeneralPath)shape).lineTo(453.42392, 612.307);
((GeneralPath)shape).lineTo(443.1295, 612.6515);
((GeneralPath)shape).lineTo(448.46558, 617.05725);
((GeneralPath)shape).lineTo(445.13263, 620.2503);
((GeneralPath)shape).lineTo(437.3526, 613.8268);
((GeneralPath)shape).moveTo(456.4061, 595.32196);
((GeneralPath)shape).curveTo(457.7028, 594.0798, 458.91827, 593.2591, 460.05264, 592.8601);
((GeneralPath)shape).curveTo(461.19315, 592.4554, 462.09338, 592.5254, 462.75345, 593.0704);
((GeneralPath)shape).curveTo(463.41348, 593.61536, 463.5602, 594.40424, 463.19357, 595.43713);
((GeneralPath)shape).curveTo(462.82693, 596.47003, 461.99225, 597.6105, 460.6895, 598.8585);
((GeneralPath)shape).curveTo(459.38675, 600.1066, 458.1669, 600.9345, 457.02988, 601.3421);
((GeneralPath)shape).curveTo(455.89896, 601.74396, 455.00345, 601.67236, 454.3434, 601.12744);
((GeneralPath)shape).curveTo(453.68332, 600.58246, 453.5349, 599.7921, 453.89807, 598.75635);
((GeneralPath)shape).curveTo(454.26733, 597.7148, 455.10336, 596.57, 456.40607, 595.3219);
((GeneralPath)shape).moveTo(457.57877, 603.00055);
((GeneralPath)shape).lineTo(465.0939, 595.80084);
((GeneralPath)shape).lineTo(466.13608, 596.6613);
((GeneralPath)shape).lineTo(458.6209, 603.8611);
((GeneralPath)shape).lineTo(457.57874, 603.0006);
((GeneralPath)shape).moveTo(457.2919, 596.05334);
((GeneralPath)shape).curveTo(456.78058, 596.5433, 456.49432, 597.0127, 456.4331, 597.4617);
((GeneralPath)shape).curveTo(456.378, 597.90485, 456.55197, 598.2928, 456.95496, 598.6255);
((GeneralPath)shape).curveTo(457.35794, 598.9582, 457.8041, 599.0823, 458.29343, 598.9976);
((GeneralPath)shape).curveTo(458.78885, 598.9072, 459.29224, 598.617, 459.80356, 598.1271);
((GeneralPath)shape).curveTo(460.30887, 597.64307, 460.59076, 597.1809, 460.64935, 596.7406);
((GeneralPath)shape).curveTo(460.71396, 596.2945, 460.54477, 595.9051, 460.1418, 595.5723);
((GeneralPath)shape).curveTo(459.73883, 595.2396, 459.2879, 595.11707, 458.789, 595.2046);
((GeneralPath)shape).curveTo(458.29623, 595.2864, 457.79718, 595.5693, 457.29187, 596.0533);
((GeneralPath)shape).moveTo(480.58624, 578.80225);
((GeneralPath)shape).curveTo(481.64093, 578.0335, 482.57422, 577.5608, 483.38602, 577.3841);
((GeneralPath)shape).curveTo(484.20047, 577.1987, 484.8665, 577.3198, 485.38412, 577.74713);
((GeneralPath)shape).curveTo(486.15533, 578.38385, 486.22498, 579.3643, 485.59308, 580.6885);
((GeneralPath)shape).curveTo(484.95767, 582.0098, 483.6477, 583.6211, 481.66315, 585.52234);
((GeneralPath)shape).curveTo(480.96307, 586.19305, 480.227, 586.8394, 479.45477, 587.4614);
((GeneralPath)shape).curveTo(478.69217, 588.0805, 477.90268, 588.6665, 477.08627, 589.2194);
((GeneralPath)shape).lineTo(475.53854, 587.9415);
((GeneralPath)shape).curveTo(476.38364, 587.4666, 477.1774, 586.96014, 477.91998, 586.42224);
((GeneralPath)shape).curveTo(478.66513, 585.8757, 479.3513, 585.302, 479.9783, 584.7013);
((GeneralPath)shape).curveTo(480.90967, 583.80896, 481.5299, 583.0506, 481.83887, 582.4262);
((GeneralPath)shape).curveTo(482.1539, 581.79596, 482.13947, 581.33887, 481.79556, 581.0549);
((GeneralPath)shape).curveTo(481.44122, 580.7623, 480.91803, 580.7864, 480.22604, 581.1272);
((GeneralPath)shape).curveTo(479.53665, 581.4592, 478.69583, 582.1006, 477.70355, 583.0512);
((GeneralPath)shape).lineTo(476.29733, 584.39844);
((GeneralPath)shape).lineTo(475.005, 583.3314);
((GeneralPath)shape).lineTo(476.48428, 581.91425);
((GeneralPath)shape).curveTo(477.36697, 581.0686, 477.94626, 580.3742, 478.22217, 579.831);
((GeneralPath)shape).curveTo(478.4946, 579.28503, 478.46924, 578.8786, 478.14627, 578.6119);
((GeneralPath)shape).curveTo(477.84744, 578.3652, 477.40646, 578.3757, 476.8231, 578.6432);
((GeneralPath)shape).curveTo(476.23978, 578.9108, 475.5646, 579.41205, 474.79755, 580.14685);
((GeneralPath)shape).curveTo(474.2314, 580.6893, 473.69568, 581.26764, 473.19028, 581.88184);
((GeneralPath)shape).curveTo(472.6849, 582.49615, 472.21735, 583.1362, 471.7875, 583.802);
((GeneralPath)shape).lineTo(470.31802, 582.58875);
((GeneralPath)shape).curveTo(470.90082, 581.8321, 471.50534, 581.10425, 472.13156, 580.40515);
((GeneralPath)shape).curveTo(472.75778, 579.7061, 473.39966, 579.0416, 474.0571, 578.41174);
((GeneralPath)shape).curveTo(475.8286, 576.71466, 477.31937, 575.5838, 478.5295, 575.01935);
((GeneralPath)shape).curveTo(479.74225, 574.44617, 480.6821, 574.435, 481.34912, 574.9857);
((GeneralPath)shape).curveTo(481.8042, 575.3615, 481.96765, 575.8711, 481.83945, 576.5144);
((GeneralPath)shape).curveTo(481.70767, 577.15485, 481.28998, 577.91754, 480.5863, 578.80237);
paint = new LinearGradientPaint(new Point2D.Double(49.15303039550781, 75.31031799316406), new Point2D.Double(82.4846420288086, 75.31031799316406), new float[] {0.0f,1.0f}, new Color[] {new Color(180, 148, 42, 255),new Color(228, 220, 201, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(4.20988130569458f, 0.0f, 0.0f, 3.7305328845977783f, 138.7693328857422f, 360.4909973144531f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_18);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1_19 = g.getTransform();
g.transform(new AffineTransform(0.7279376983642578f, 0.6856433153152466f, -0.8170589208602905f, 0.5765541195869446f, 0.0f, 0.0f));
// _0_0_1_19
shape = new GeneralPath();
((GeneralPath)shape).moveTo(671.8705, -172.63637);
((GeneralPath)shape).lineTo(689.923, -172.63637);
((GeneralPath)shape).lineTo(689.923, -168.64201);
((GeneralPath)shape).lineTo(671.8705, -168.64201);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(49.01197052001953, 2.6743078231811523), 1.7246193f, new Point2D.Double(49.01197052001953, 2.6743078231811523), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(37, 37, 37, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(5.233759880065918f, 0.0f, 0.0f, 0.6436169147491455f, 424.3800354003906f, -172.7548065185547f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_19);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_0_1_20 = g.getTransform();
g.transform(new AffineTransform(-0.7817000150680542f, -0.6236546039581299f, -0.6515713334083557f, 0.7585873603820801f, 0.0f, 0.0f));
// _0_0_1_20
shape = new GeneralPath();
((GeneralPath)shape).moveTo(-775.9558, -110.2087);
((GeneralPath)shape).lineTo(-757.72314, -110.2087);
((GeneralPath)shape).lineTo(-757.72314, -106.330765);
((GeneralPath)shape).lineTo(-775.9558, -106.330765);
((GeneralPath)shape).closePath();
paint = new RadialGradientPaint(new Point2D.Double(49.01197052001953, 2.6743078231811523), 1.7246193f, new Point2D.Double(49.01197052001953, 2.6743078231811523), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(37, 37, 37, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(5.286000728607178f, 0.0f, 0.0f, 0.6248621940612793f, -1025.91650390625f, -110.32372283935547f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0_1_20);
g.setTransform(defaultTransform__0_0_1);
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
        return 3.5813074111938477;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 7.719841480255127;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 742.2968139648438;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 744.125;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private draw_roi2() {
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
       draw_roi2 base = new draw_roi2();
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
       draw_roi2 base = new draw_roi2();
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
        return draw_roi2::new;
    }
}

