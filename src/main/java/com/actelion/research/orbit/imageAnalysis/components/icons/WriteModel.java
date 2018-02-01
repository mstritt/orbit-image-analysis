/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2018 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.actelion.research.orbit.imageAnalysis.components.icons;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static java.awt.MultipleGradientPaint.ColorSpaceType.SRGB;
import static java.awt.MultipleGradientPaint.CycleMethod.NO_CYCLE;

/**
 * This class has been automatically generated using
 * <a href="http://ebourg.github.io/flamingo-svg-transcoder/">Flamingo SVG transcoder</a>.
 */
public class WriteModel implements org.pushingpixels.flamingo.api.common.icon.ResizableIcon {

    /**
     * Paints the transcoded SVG image on the specified graphics context. You
     * can install a custom transformation on the graphics context to scale the
     * image.
     *
     * @param g Graphics context.
     */
    public static void paint(Graphics2D g) {
        Shape shape = null;

        float origAlpha = 1.0f;
        Composite origComposite = g.getComposite();
        if (origComposite instanceof AlphaComposite) {
            AlphaComposite origAlphaComposite = (AlphaComposite) origComposite;
            if (origAlphaComposite.getRule() == AlphaComposite.SRC_OVER) {
                origAlpha = origAlphaComposite.getAlpha();
            }
        }

        java.util.LinkedList<AffineTransform> transformations = new java.util.LinkedList<AffineTransform>();


        // 
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1.0666667f, 0, 0, 1.0666667f, 0, 0));

        // _0
        transformations.offer(g.getTransform());
        g.transform(new AffineTransform(1, 0, 0, 1, 0, -343.70078f));

        // _0_0

        // _0_0_0
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(42.410683, 993.34845);
        ((GeneralPath) shape).curveTo(46.75866, 967.8471, 53.139862, 945.5428, 59.229828, 922.8538);
        ((GeneralPath) shape).curveTo(62.234028, 911.6613, 65.541084, 901.02075, 68.3402, 889.4616);
        ((GeneralPath) shape).curveTo(85.128365, 820.1337, 68.90453, 880.022, 83.757744, 817.1118);
        ((GeneralPath) shape).curveTo(87.054375, 803.1492, 91.110016, 790.48193, 94.269714, 776.29913);
        ((GeneralPath) shape).curveTo(98.746796, 756.20306, 101.42086, 732.7217, 104.78169, 711.3699);
        ((GeneralPath) shape).curveTo(106.55144, 700.1263, 108.57549, 689.17334, 110.38806, 677.97766);
        ((GeneralPath) shape).curveTo(112.45768, 665.1942, 113.76675, 655.8666, 115.29364, 642.73035);
        ((GeneralPath) shape).curveTo(116.4808, 632.5169, 115.71119, 635.3487, 116.69523, 622.324);
        ((GeneralPath) shape).curveTo(117.61765, 610.1152, 117.39604, 623.347, 117.39604, 611.19324);
        ((GeneralPath) shape).curveTo(123.40209, 623.9124, 119.20731, 612.69727, 123.7032, 635.3098);
        ((GeneralPath) shape).curveTo(124.97199, 641.69135, 126.5303, 647.6398, 127.90798, 653.8611);
        ((GeneralPath) shape).curveTo(148.55287, 747.0881, 123.62439, 633.6906, 141.92393, 722.5006);
        ((GeneralPath) shape).curveTo(142.48325, 725.2149, 143.54301, 727.1063, 144.02634, 729.9211);
        ((GeneralPath) shape).curveTo(145.40536, 737.9523, 145.49335, 745.62805, 146.12872, 754.0377);
        ((GeneralPath) shape).curveTo(146.55109, 759.6281, 147.10796, 765.1434, 147.53032, 770.73376);
        ((GeneralPath) shape).curveTo(147.80898, 774.4222, 148.08974, 778.12177, 148.23112, 781.8645);
        ((GeneralPath) shape).curveTo(148.39383, 786.17163, 148.23112, 790.5217, 148.23112, 794.85034);
        ((GeneralPath) shape).curveTo(148.23112, 802.2709, 148.23112, 809.69135, 148.23112, 817.1118);
        ((GeneralPath) shape).curveTo(148.23112, 821.4405, 148.23112, 825.76904, 148.23112, 830.0977);
        ((GeneralPath) shape).curveTo(148.23112, 831.3344, 148.1178, 832.60815, 148.23112, 833.8079);
        ((GeneralPath) shape).curveTo(148.3578, 835.14935, 148.76672, 836.2064, 148.93192, 837.5182);
        ((GeneralPath) shape).curveTo(149.2365, 839.93695, 149.39911, 842.46515, 149.63272, 844.93866);
        ((GeneralPath) shape).curveTo(150.3335, 849.2673, 151.07439, 853.55194, 151.7351, 857.92456);
        ((GeneralPath) shape).curveTo(151.80635, 858.39606, 153.11453, 868.97705, 153.1367, 869.05524);
        ((GeneralPath) shape).curveTo(153.4501, 870.16144, 154.30469, 869.67365, 154.53828, 870.9104);
        ((GeneralPath) shape).curveTo(154.85172, 872.56964, 154.31668, 874.7158, 154.53828, 876.47577);
        ((GeneralPath) shape).curveTo(154.61217, 877.0624, 155.07391, 876.03845, 155.23909, 876.47577);
        ((GeneralPath) shape).curveTo(155.26163, 876.5354, 155.23909, 881.5912, 155.23909, 882.04114);
        ((GeneralPath) shape).curveTo(155.23909, 886.3917, 155.07391, 881.1666, 155.9399, 885.75134);
        ((GeneralPath) shape).curveTo(156.04436, 886.30444, 155.7747, 887.16925, 155.9399, 887.6065);
        ((GeneralPath) shape).curveTo(156.10507, 888.04376, 156.47551, 887.16925, 156.6407, 887.6065);
        ((GeneralPath) shape).curveTo(156.78395, 887.9857, 156.50175, 892.43634, 156.6407, 893.1719);
        ((GeneralPath) shape).curveTo(156.78844, 893.95404, 157.19376, 894.2448, 157.34148, 895.027);
        ((GeneralPath) shape).curveTo(157.44595, 895.5801, 157.34148, 896.26373, 157.34148, 896.8821);
        ((GeneralPath) shape).curveTo(157.34148, 898.11884, 157.22818, 899.3925, 157.34148, 900.59235);
        ((GeneralPath) shape).curveTo(157.46817, 901.9338, 157.8483, 903.01874, 158.0423, 904.3026);
        ((GeneralPath) shape).curveTo(159.0869, 911.21576, 159.6614, 917.65656, 160.84547, 924.7089);
        ((GeneralPath) shape).curveTo(161.26976, 927.236, 161.70958, 929.75806, 162.24707, 932.1294);
        ((GeneralPath) shape).curveTo(162.41702, 932.87933, 162.8434, 933.1549, 162.94788, 933.98456);
        ((GeneralPath) shape).curveTo(163.09561, 935.1578, 162.73894, 936.5886, 162.94788, 937.69476);
        ((GeneralPath) shape).curveTo(163.05232, 938.24786, 163.43971, 937.9713, 163.64867, 937.69476);
        ((GeneralPath) shape).curveTo(163.94415, 937.3037, 164.11586, 936.45807, 164.34946, 935.83966);
        ((GeneralPath) shape).curveTo(167.42604, 927.6955, 164.4448, 936.2381, 168.55424, 919.14355);
        ((GeneralPath) shape).curveTo(169.1813, 916.5351, 170.02957, 914.33154, 170.65665, 911.7231);
        ((GeneralPath) shape).curveTo(171.66776, 907.517, 172.52544, 903.06586, 173.45982, 898.73724);
        ((GeneralPath) shape).curveTo(176.86317, 882.9711, 176.68301, 884.7341, 179.767, 865.34503);
        ((GeneralPath) shape).curveTo(183.23186, 843.56146, 180.67744, 856.6614, 183.97179, 831.9528);
        ((GeneralPath) shape).curveTo(184.56389, 827.5119, 185.31668, 823.2281, 186.07419, 818.967);
        ((GeneralPath) shape).curveTo(188.53676, 805.1145, 190.96169, 793.45245, 193.78296, 780.0094);
        ((GeneralPath) shape).curveTo(194.69759, 775.6513, 195.70496, 771.4296, 196.58615, 767.02356);
        ((GeneralPath) shape).curveTo(197.75415, 760.8398, 198.92213, 754.65607, 200.09013, 748.4723);
        ((GeneralPath) shape).curveTo(201.02454, 744.7621, 202.0947, 741.2677, 202.89333, 737.34155);
        ((GeneralPath) shape).curveTo(205.42316, 724.9045, 204.16396, 725.43634, 207.09811, 715.0801);
        ((GeneralPath) shape).curveTo(207.69276, 712.98126, 208.69061, 711.7644, 209.2005, 709.5148);
        ((GeneralPath) shape).curveTo(211.3029, 700.23914, 208.1493, 709.5148, 209.2005, 703.94934);
        ((GeneralPath) shape).curveTo(209.34825, 703.1672, 209.75357, 702.87646, 209.9013, 702.09424);
        ((GeneralPath) shape).curveTo(210.88242, 696.8999, 211.02258, 690.59247, 212.0037, 685.39813);
        ((GeneralPath) shape).curveTo(212.42418, 683.172, 213.68561, 682.05896, 214.1061, 679.8328);
        ((GeneralPath) shape).curveTo(214.31502, 678.7266, 213.77573, 676.9971, 214.1061, 676.12256);
        ((GeneralPath) shape).curveTo(214.27126, 675.6853, 214.6417, 676.55975, 214.80688, 676.12256);
        ((GeneralPath) shape).curveTo(214.97208, 675.6853, 214.6417, 674.70465, 214.80688, 674.2674);
        ((GeneralPath) shape).curveTo(214.97208, 673.83014, 215.34251, 674.70465, 215.50769, 674.2674);
        ((GeneralPath) shape).curveTo(215.67287, 673.83014, 215.40321, 672.9654, 215.50769, 672.4123);
        ((GeneralPath) shape).curveTo(215.80318, 670.8479, 216.6138, 670.2664, 216.90929, 668.702);
        ((GeneralPath) shape).curveTo(217.01375, 668.1489, 216.7441, 667.2842, 216.90929, 666.8469);
        ((GeneralPath) shape).curveTo(218.35925, 663.0086, 216.85262, 672.7124, 218.31087, 664.99176);
        ((GeneralPath) shape).curveTo(218.41534, 664.43866, 218.1457, 663.5739, 218.31087, 663.13666);
        ((GeneralPath) shape).curveTo(218.47604, 662.6994, 218.80273, 663.4132, 219.01167, 663.13666);
        ((GeneralPath) shape).curveTo(219.30714, 662.7456, 219.41698, 661.6726, 219.71246, 661.28156);
        ((GeneralPath) shape).curveTo(219.92142, 661.005, 220.20435, 661.5581, 220.41327, 661.28156);
        ((GeneralPath) shape).curveTo(220.9483, 660.57336, 222.55351, 653.9613, 223.21646, 655.7162);
        ((GeneralPath) shape).curveTo(223.38164, 656.15344, 223.1297, 656.99713, 223.21646, 657.5713);
        ((GeneralPath) shape).curveTo(223.60445, 660.139, 224.21266, 662.44305, 224.61806, 664.99176);
        ((GeneralPath) shape).curveTo(226.08255, 674.19904, 227.42123, 683.543, 228.82283, 692.81866);
        ((GeneralPath) shape).curveTo(237.77267, 752.04767, 234.1134, 721.1574, 238.634, 770.73376);
        ((GeneralPath) shape).curveTo(239.312, 778.16907, 239.73283, 785.8226, 240.73639, 792.99524);
        ((GeneralPath) shape).curveTo(242.87836, 808.3045, 246.33757, 822.17554, 248.44518, 837.5182);
        ((GeneralPath) shape).curveTo(250.86903, 855.1631, 252.2606, 873.72723, 254.75235, 891.3167);
        ((GeneralPath) shape).curveTo(255.63576, 897.5528, 256.43036, 903.911, 257.55554, 909.868);
        ((GeneralPath) shape).curveTo(258.30887, 913.8563, 259.4478, 917.24774, 260.35873, 920.9987);
        ((GeneralPath) shape).curveTo(261.5504, 925.9059, 262.67957, 930.91797, 263.86273, 935.83966);
        ((GeneralPath) shape).curveTo(264.3149, 937.7207, 264.88763, 939.4108, 265.2643, 941.405);
        ((GeneralPath) shape).curveTo(265.59467, 943.15405, 265.55536, 945.3434, 265.96512, 946.9704);
        ((GeneralPath) shape).curveTo(266.88135, 950.6086, 268.55283, 952.60785, 269.4691, 956.246);
        ((GeneralPath) shape).curveTo(269.59866, 956.76056, 269.30392, 957.6639, 269.4691, 958.10114);
        ((GeneralPath) shape).curveTo(269.63428, 958.5384, 270.00473, 957.6639, 270.1699, 958.10114);
        ((GeneralPath) shape).curveTo(270.33508, 958.5384, 270.1699, 959.3379, 270.1699, 959.9561);
        ((GeneralPath) shape).curveTo(270.1699, 960.5745, 270.1699, 961.1929, 270.1699, 961.8113);
        ((GeneralPath) shape).curveTo(270.1699, 962.4297, 270.00473, 963.2294, 270.1699, 963.66644);
        ((GeneralPath) shape).curveTo(270.19244, 963.7262, 272.10233, 963.66644, 272.27228, 963.66644);
        ((GeneralPath) shape).curveTo(272.73947, 963.66644, 273.36136, 964.5859, 273.6739, 963.66644);
        ((GeneralPath) shape).curveTo(277.56396, 952.2247, 284.26694, 918.8571, 286.28824, 909.868);
        ((GeneralPath) shape).curveTo(294.52966, 873.2165, 304.39514, 835.8192, 309.41455, 794.85034);
        ((GeneralPath) shape).curveTo(310.90024, 782.72406, 311.57947, 769.9933, 312.91855, 757.7479);
        ((GeneralPath) shape).curveTo(313.21152, 755.0689, 318.5552, 712.1996, 319.92654, 703.94934);
        ((GeneralPath) shape).curveTo(321.2156, 689.2043, 325.3146, 678.30206, 327.63528, 664.99176);
        ((GeneralPath) shape).curveTo(328.25443, 661.4408, 328.43686, 657.43494, 329.0369, 653.8611);
        ((GeneralPath) shape).curveTo(329.37897, 651.82367, 330.0206, 650.2315, 330.43848, 648.2957);
        ((GeneralPath) shape).curveTo(330.9568, 645.8946, 331.32178, 643.2763, 331.84006, 640.8752);
        ((GeneralPath) shape).curveTo(332.25797, 638.9394, 332.7953, 637.2005, 333.24167, 635.3098);
        ((GeneralPath) shape).curveTo(333.9636, 632.2522, 334.52682, 628.91876, 335.34406, 626.03424);
        ((GeneralPath) shape).curveTo(335.93872, 623.93536, 336.8704, 622.6037, 337.44647, 620.4688);
        ((GeneralPath) shape).curveTo(338.05368, 618.2185, 338.31058, 615.41974, 338.84805, 613.04834);
        ((GeneralPath) shape).curveTo(339.01804, 612.29846, 339.40112, 611.97546, 339.54886, 611.19324);
        ((GeneralPath) shape).curveTo(339.8792, 609.4442, 339.8696, 607.3047, 340.24966, 605.62787);
        ((GeneralPath) shape).curveTo(340.92953, 602.62836, 342.25998, 601.00586, 343.05283, 598.2074);
        ((GeneralPath) shape).curveTo(343.36624, 597.1012, 343.28644, 595.11554, 343.75363, 594.49713);
        ((GeneralPath) shape).curveTo(344.04913, 594.1061, 344.30203, 595.5764, 344.45444, 596.35223);
        ((GeneralPath) shape).curveTo(347.34625, 611.0736, 350.27023, 625.7697, 352.864, 640.8752);
        ((GeneralPath) shape).curveTo(358.44882, 673.3997, 363.04578, 707.11176, 368.98236, 739.1967);
        ((GeneralPath) shape).curveTo(404.7861, 932.7022, 371.81738, 740.4102, 397.01425, 870.9104);
        ((GeneralPath) shape).curveTo(399.20596, 882.2618, 400.94385, 894.2073, 402.62064, 906.1577);
        ((GeneralPath) shape).curveTo(410.66504, 963.48987, 401.6996, 909.3379, 409.6286, 961.8113);
        ((GeneralPath) shape).curveTo(410.4046, 966.94666, 411.4974, 971.7055, 412.4318, 976.6523);
        ((GeneralPath) shape).curveTo(423.601, 933.6463, 416.69296, 959.1741, 429.25095, 915.43335);
        ((GeneralPath) shape).curveTo(430.6644, 910.5101, 432.15997, 905.73755, 433.45572, 900.59235);
        ((GeneralPath) shape).curveTo(434.03522, 898.2913, 434.31982, 895.5432, 434.85733, 893.1719);
        ((GeneralPath) shape).curveTo(436.44482, 886.1679, 434.63263, 901.15186, 436.95972, 885.75134);
        ((GeneralPath) shape).curveTo(437.13324, 884.6031, 436.95972, 883.2779, 436.95972, 882.04114);
        ((GeneralPath) shape).curveTo(451.13763, 823.06354, 431.72845, 905.34753, 446.77087, 835.6631);
        ((GeneralPath) shape).curveTo(448.46622, 827.8093, 454.3006, 809.59766, 455.88126, 804.126);
        ((GeneralPath) shape).curveTo(458.3226, 795.67487, 460.31635, 786.3273, 462.88922, 778.1543);
        ((GeneralPath) shape).curveTo(463.9467, 774.79517, 465.47696, 772.51685, 466.39322, 768.87866);
        ((GeneralPath) shape).curveTo(467.38004, 764.9602, 467.5803, 759.9311, 468.4956, 755.8928);
        ((GeneralPath) shape).curveTo(470.9897, 744.8891, 472.9726, 742.4349, 474.8028, 731.7762);
        ((GeneralPath) shape).curveTo(475.41412, 728.2158, 475.65567, 724.2767, 476.20438, 720.64545);
        ((GeneralPath) shape).curveTo(476.59238, 718.0778, 477.13876, 715.6985, 477.60596, 713.225);
        ((GeneralPath) shape).curveTo(477.83957, 711.9882, 478.01703, 710.6652, 478.30676, 709.5148);
        ((GeneralPath) shape).curveTo(478.49002, 708.7871, 478.85983, 708.4418, 479.00757, 707.6596);
        ((GeneralPath) shape).curveTo(479.1465, 706.9241, 478.8643, 702.4735, 479.00757, 702.09424);
        ((GeneralPath) shape).curveTo(479.17276, 701.657, 479.54318, 702.5315, 479.70837, 702.09424);
        ((GeneralPath) shape).curveTo(480.05878, 701.1667, 479.35797, 697.4564, 479.70837, 696.5289);
        ((GeneralPath) shape).curveTo(479.87354, 696.0916, 480.244, 696.9661, 480.40918, 696.5289);
        ((GeneralPath) shape).curveTo(480.55243, 696.1496, 480.27023, 691.69904, 480.40918, 690.9635);
        ((GeneralPath) shape).curveTo(480.5569, 690.18134, 480.87637, 689.72675, 481.10995, 689.1084);
        ((GeneralPath) shape).curveTo(481.34357, 687.87164, 481.61676, 686.682, 481.81076, 685.39813);
        ((GeneralPath) shape).curveTo(482.0851, 683.5825, 482.2372, 681.6484, 482.51154, 679.8328);
        ((GeneralPath) shape).curveTo(483.17227, 675.4602, 484.00598, 671.27277, 484.61395, 666.8469);
        ((GeneralPath) shape).curveTo(484.9431, 664.4508, 485.0102, 661.8452, 485.31476, 659.4264);
        ((GeneralPath) shape).curveTo(485.71255, 656.2673, 486.15378, 653.1293, 486.71634, 650.1508);
        ((GeneralPath) shape).curveTo(487.65344, 645.1896, 489.9999, 635.841, 490.92114, 629.74445);
        ((GeneralPath) shape).curveTo(496.07196, 595.65686, 489.69476, 630.9038, 493.7243, 614.9035);
        ((GeneralPath) shape).curveTo(493.8539, 614.389, 493.49072, 613.04834, 493.7243, 613.04834);
        ((GeneralPath) shape).curveTo(494.0547, 613.04834, 494.2927, 614.1023, 494.4251, 614.9035);
        ((GeneralPath) shape).curveTo(495.93777, 624.056, 497.34018, 633.3417, 498.6299, 642.73035);
        ((GeneralPath) shape).curveTo(501.07877, 660.5573, 503.19684, 678.69434, 505.63788, 696.5289);
        ((GeneralPath) shape).curveTo(532.88934, 895.6323, 506.3885, 697.5208, 520.3546, 802.2709);
        ((GeneralPath) shape).curveTo(521.7562, 812.7832, 523.26654, 823.19836, 524.55945, 833.8079);
        ((GeneralPath) shape).curveTo(525.60364, 842.3768, 526.3723, 851.1661, 527.3626, 859.77966);
        ((GeneralPath) shape).curveTo(528.0079, 865.3919, 528.8282, 870.85675, 529.465, 876.47577);
        ((GeneralPath) shape).curveTo(530.23035, 883.22894, 530.8357, 890.10284, 531.5674, 896.8821);
        ((GeneralPath) shape).curveTo(532.23737, 903.0897, 533.017, 909.2128, 533.6698, 915.43335);
        ((GeneralPath) shape).curveTo(534.18536, 920.34656, 534.49133, 925.41174, 535.07135, 930.2743);
        ((GeneralPath) shape).curveTo(535.8947, 937.1762, 536.9646, 943.8554, 537.8746, 950.68066);
        ((GeneralPath) shape).curveTo(538.3663, 954.36865, 538.6648, 958.251, 539.2762, 961.8113);
        ((GeneralPath) shape).curveTo(539.8398, 965.0939, 540.9478, 967.6663, 541.37854, 971.0871);
        ((GeneralPath) shape).curveTo(541.674, 973.43365, 541.1953, 976.082, 541.37854, 978.50745);
        ((GeneralPath) shape).curveTo(541.44336, 979.36505, 541.8961, 979.6349, 542.07935, 980.3626);
        ((GeneralPath) shape).curveTo(542.3691, 981.5132, 542.615, 982.7611, 542.78015, 984.07294);
        ((GeneralPath) shape).curveTo(542.854, 984.65936, 542.615, 985.4907, 542.78015, 985.92786);
        ((GeneralPath) shape).curveTo(542.9453, 986.3652, 543.3158, 985.4907, 543.48096, 985.92786);
        ((GeneralPath) shape).curveTo(543.81134, 986.80255, 543.27203, 988.53204, 543.48096, 989.6382);
        ((GeneralPath) shape).curveTo(543.574, 990.13086, 545.3973, 994.95746, 545.5833, 995.2036);
        ((GeneralPath) shape).curveTo(545.7404, 995.4114, 548.22, 995.2036, 548.38654, 995.2036);
        ((GeneralPath) shape).curveTo(548.8537, 995.2036, 549.3825, 995.8171, 549.78815, 995.2036);
        ((GeneralPath) shape).curveTo(551.0868, 993.23914, 552.2759, 990.6885, 553.2921, 987.783);
        ((GeneralPath) shape).curveTo(571.7735, 934.94604, 562.5801, 960.2374, 576.41846, 909.868);
        ((GeneralPath) shape).curveTo(599.11975, 827.2388, 580.75464, 896.99, 599.54474, 830.0977);
        ((GeneralPath) shape).curveTo(603.14197, 817.29175, 606.67566, 804.35236, 610.0567, 791.14014);
        ((GeneralPath) shape).curveTo(611.5846, 785.1696, 613.0861, 779.09454, 614.26154, 772.5889);
        ((GeneralPath) shape).curveTo(616.4192, 760.6463, 618.60974, 740.65936, 620.56866, 728.066);
        ((GeneralPath) shape).curveTo(621.16534, 724.2302, 622.02264, 720.7116, 622.6711, 716.93524);
        ((GeneralPath) shape).curveTo(623.19165, 713.9037, 623.67487, 710.8188, 624.0727, 707.6596);
        ((GeneralPath) shape).curveTo(624.2284, 706.4227, 625.02435, 696.4603, 625.47424, 694.67377);
        ((GeneralPath) shape).curveTo(625.6038, 694.15924, 626.0349, 694.1791, 626.17505, 694.67377);
        ((GeneralPath) shape).curveTo(626.8019, 696.8861, 627.06934, 699.6768, 627.57666, 702.09424);
        ((GeneralPath) shape).curveTo(639.9882, 761.23376, 625.5129, 687.13885, 641.5926, 780.0094);
        ((GeneralPath) shape).curveTo(645.44696, 802.2709, 650.2825, 824.53235, 654.207, 846.79376);
        ((GeneralPath) shape).curveTo(655.7116, 855.329, 656.88855, 864.25336, 658.41174, 872.7655);
        ((GeneralPath) shape).curveTo(658.9949, 876.0241, 659.8619, 878.8757, 660.51416, 882.04114);
        ((GeneralPath) shape).curveTo(661.2645, 885.6828, 661.9157, 889.4616, 662.6165, 893.1719);
        ((GeneralPath) shape).curveTo(662.85016, 894.40857, 663.1907, 895.54065, 663.3173, 896.8821);
        ((GeneralPath) shape).curveTo(663.43066, 898.0819, 663.3173, 899.3556, 663.3173, 900.59235);

        g.setPaint(new Color(0xF2F2F2));
        g.setStroke(new BasicStroke(26.498343f, 0, 0, 4));
        g.draw(shape);

        // _0_0_1
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(246.52959, 371.17358);
        ((GeneralPath) shape).lineTo(246.52959, 356.37167);
        ((GeneralPath) shape).lineTo(246.52959, 371.17358);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0xC1FFFFFF, true));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.38139534f * origAlpha));

        // _0_0_2
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(754.161, 1005.6964);
        ((GeneralPath) shape).curveTo(754.1601, 1021.10443, 585.53986, 1033.5951, 377.5366, 1033.5951);
        ((GeneralPath) shape).curveTo(169.53334, 1033.5951, 0.91312283, 1021.10443, 0.9121843, 1005.6964);
        ((GeneralPath) shape).curveTo(0.91221255, 990.2883, 169.5327, 977.7976, 377.5366, 977.7976);
        ((GeneralPath) shape).curveTo(585.54047, 977.7976, 754.161, 990.2883, 754.161, 1005.6964);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(63.912208557128906, 115.70919036865234), 63.91221f, new Point2D.Double(14.046639442443848, 115.70919036865234), new float[]{0, 1}, new Color[]{BLACK, new Color(0x0, true)}, NO_CYCLE, SRGB, new AffineTransform(5.8928394f, 0, 0, 0.4365172f, 0.91219425f, 955.1872f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_3
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(632.71234, 355.94482);
        ((GeneralPath) shape).curveTo(635.86194, 352.88113, 656.1692, 354.66113, 677.4952, 372.50186);
        ((GeneralPath) shape).curveTo(699.03033, 390.51746, 703.11224, 407.7017, 699.167, 411.53906);
        ((GeneralPath) shape).curveTo(696.5992, 414.03687, 694.0313, 416.53467, 691.4635, 419.03247);
        ((GeneralPath) shape).curveTo(669.31177, 400.50104, 647.1603, 381.96964, 625.00867, 363.4382);
        ((GeneralPath) shape).curveTo(627.57654, 360.9404, 630.1444, 358.4426, 632.71234, 355.94482);
        ((GeneralPath) shape).curveTo(632.71234, 355.94482, 632.71234, 355.94482, 632.71234, 355.94482);

        g.setPaint(BLACK);
        g.fill(shape);

        // _0_0_4
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(27.071474, 1006.0963);
        ((GeneralPath) shape).lineTo(208.17526, 890.0534);
        ((GeneralPath) shape).lineTo(209.20206, 889.0546);
        ((GeneralPath) shape).lineTo(143.83806, 832.3993);
        ((GeneralPath) shape).lineTo(142.44632, 833.75256);
        ((GeneralPath) shape).lineTo(27.071474, 1006.0963);
        ((GeneralPath) shape).closePath();

        g.fill(shape);

        // _0_0_5
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(37.539, 996.6289);
        ((GeneralPath) shape).lineTo(206.42612, 888.4797);
        ((GeneralPath) shape).lineTo(207.45284, 887.4809);
        ((GeneralPath) shape).lineTo(145.5873, 833.973);
        ((GeneralPath) shape).lineTo(144.19548, 835.3263);
        ((GeneralPath) shape).lineTo(37.539, 996.6289);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(42.617530822753906, 120.64187622070312), 3.406888f, new Point2D.Double(42.617530822753906, 120.64187622070312), new float[]{0, 1}, new Color[]{new Color(0xB4942A), new Color(0xE4DCC9)}, NO_CYCLE, SRGB, new AffineTransform(9.196772f, 8.66732f, -87.41267f, 75.02301f, 10332.108f, -8542.834f)));
        g.fill(shape);

        // _0_0_6
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(170.5971, 866.4894);
        ((GeneralPath) shape).curveTo(178.7938, 873.34644, 187.1757, 870.7758, 190.10568, 873.22687);
        ((GeneralPath) shape).curveTo(190.57916, 873.6229, 190.89355, 874.1638, 191.11615, 874.7419);
        ((GeneralPath) shape).lineTo(678.45154, 399.78418);
        ((GeneralPath) shape).lineTo(646.23816, 372.83536);
        ((GeneralPath) shape).lineTo(157.97754, 848.6929);
        ((GeneralPath) shape).curveTo(159.44658, 848.5864, 160.74944, 848.668, 161.67615, 849.4434);
        ((GeneralPath) shape).curveTo(164.35422, 851.6839, 162.36243, 859.6004, 170.5971, 866.4894);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(15.727076530456543, 58.08968734741211), 2.6143966f, new Point2D.Double(15.727076530456543, 58.08968734741211), new float[]{0, 0.5f, 0.75f, 1}, new Color[]{new Color(0x252525), new Color(0x252525), new Color(0x252525), BLACK}, NO_CYCLE, SRGB, new AffineTransform(11.563247f, 9.859902f, -157.19798f, 152.25606f, 9294.698f, -8313.632f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.35348833f * origAlpha));

        // _0_0_7
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(208.51051, 855.69446);
        ((GeneralPath) shape).lineTo(189.42775, 874.2563);
        ((GeneralPath) shape).curveTo(191.9888, 876.7878, 188.47545, 883.76105, 193.39815, 887.87915);
        ((GeneralPath) shape).curveTo(198.70326, 892.3173, 204.46336, 887.287, 207.91092, 890.1373);
        ((GeneralPath) shape).lineTo(227.22495, 871.35034);
        ((GeneralPath) shape).lineTo(208.51051, 855.69446);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_8
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(677.27545, 398.80038);
        ((GeneralPath) shape).lineTo(190.3102, 873.398);
        ((GeneralPath) shape).curveTo(192.88527, 875.9414, 190.26428, 882.0647, 195.21233, 886.20386);
        ((GeneralPath) shape).curveTo(200.54453, 890.6648, 205.42398, 886.4941, 208.88905, 889.35895);
        ((GeneralPath) shape).lineTo(696.0856, 414.53644);
        ((GeneralPath) shape).lineTo(677.27545, 398.80038);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(36.6756477355957, 95.76927947998047), 47.746403f, new Point2D.Double(16.21735382080078, 64.14128112792969), new float[]{0, 0.09292036f, 0.5043171f, 0.91571385f, 1}, new Color[]{new Color(0x9A7600), new Color(0xE3AD00), new Color(0xFFCD2C), new Color(0xE3AD00), new Color(0xB98D00)}, NO_CYCLE, SRGB, new AffineTransform(0.393325f, 0.3390371f, -7.8988037f, 7.49156f, 1161.5958f, -93.01132f)));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.38604653f * origAlpha));

        // _0_0_9
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(170.95338, 840.42755);
        ((GeneralPath) shape).lineTo(161.16435, 849.9494);
        ((GeneralPath) shape).lineTo(160.79362, 850.3018);
        ((GeneralPath) shape).curveTo(162.98106, 852.25494, 159.78629, 859.3497, 166.80576, 866.3861);
        ((GeneralPath) shape).lineTo(167.21483, 866.7283);
        ((GeneralPath) shape).lineTo(170.1294, 869.1665);
        ((GeneralPath) shape).lineTo(170.53847, 869.5087);
        ((GeneralPath) shape).curveTo(178.92255, 875.35876, 186.52196, 871.8255, 189.45183, 874.2764);
        ((GeneralPath) shape).lineTo(199.81918, 864.1395);
        ((GeneralPath) shape).lineTo(170.95341, 840.4276);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x252525));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 0.35348833f * origAlpha));

        // _0_0_10
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(152.33778, 824.66724);
        ((GeneralPath) shape).lineTo(142.42853, 833.7775);
        ((GeneralPath) shape).curveTo(142.53128, 833.863, 141.72244, 834.6568, 141.82552, 834.74304);
        ((GeneralPath) shape).curveTo(143.92824, 836.5021, 141.0112, 843.5934, 144.50827, 847.7327);
        ((GeneralPath) shape).lineTo(144.8662, 848.03204);
        ((GeneralPath) shape).lineTo(146.45126, 849.35815);
        ((GeneralPath) shape).lineTo(146.65587, 849.5292);
        ((GeneralPath) shape).curveTo(151.60767, 852.5079, 158.25478, 848.8015, 160.79362, 850.3019);
        ((GeneralPath) shape).lineTo(171.05223, 840.3233);
        ((GeneralPath) shape).lineTo(152.33778, 824.66724);
        ((GeneralPath) shape).closePath();

        g.setPaint(new Color(0x131313));
        g.fill(shape);
        g.setComposite(AlphaComposite.getInstance(3, 1 * origAlpha));

        // _0_0_11
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(147.49687, 846.91504);
        ((GeneralPath) shape).curveTo(152.65791, 851.1326, 158.9441, 847.1579, 161.67615, 849.4434);
        ((GeneralPath) shape).lineTo(648.6415, 374.84586);
        ((GeneralPath) shape).lineTo(629.6308, 358.94217);
        ((GeneralPath) shape).lineTo(142.4342, 833.7648);
        ((GeneralPath) shape).curveTo(142.53864, 833.8515, 142.6411, 833.93787, 142.7458, 834.0256);
        ((GeneralPath) shape).curveTo(144.88184, 835.8124, 142.29727, 842.665, 147.49687, 846.91504);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(11.326383590698242, 57.38399887084961), new Point2D.Double(14.493531227111816, 57.38399887084961), new float[]{0, 0.09292036f, 0.5043171f, 0.91571385f, 1}, new Color[]{new Color(0x9A7600), new Color(0xE3AD00), new Color(0xFFCD2C), new Color(0xE3AD00), new Color(0xB98D00)}, NO_CYCLE, SRGB, new AffineTransform(6.395705f, 5.3660526f, -5.9485683f, 5.7694006f, 651.8609f, 206.34534f)));
        g.fill(shape);

        // _0_0_12
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(632.5671, 356.2256);
        ((GeneralPath) shape).lineTo(699.0523, 411.7594);
        ((GeneralPath) shape).lineTo(684.5273, 425.80685);
        ((GeneralPath) shape).lineTo(618.04205, 370.27307);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);

        // _0_0_13
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(640.9572, 364.41318);
        ((GeneralPath) shape).curveTo(636.3276, 360.5531, 543.2291, 444.28162, 433.01587, 551.42615);
        ((GeneralPath) shape).curveTo(380.08945, 602.8789, 330.2139, 652.9607, 294.36133, 690.65405);
        ((GeneralPath) shape).curveTo(258.50876, 728.3474, 239.61604, 750.56464, 241.83939, 752.4182);
        ((GeneralPath) shape).curveTo(246.46901, 756.2783, 339.5675, 672.54974, 449.78076, 565.4052);
        ((GeneralPath) shape).curveTo(502.70718, 513.95245, 552.5827, 463.87067, 588.4353, 426.17734);
        ((GeneralPath) shape).curveTo(624.28784, 388.48398, 643.18054, 366.26675, 640.9572, 364.41318);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(34.67763900756836, 7.462276935577393), 47.595196f, new Point2D.Double(34.67763900756836, 7.462276935577393), new float[]{0, 1}, new Color[]{new Color(0xAEFFFFFF, true), new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(4.26897f, -4.027903f, -0.17436853f, -0.14969303f, 294.6617f, 699.2109f)));
        g.fill(shape);

        // _0_0_14
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(651.2467, 369.73947);
        ((GeneralPath) shape).curveTo(649.79407, 368.52402, 537.8377, 475.60416, 400.47577, 609.58813);
        ((GeneralPath) shape).curveTo(263.11343, 743.5725, 151.75897, 854.3116, 151.05344, 857.63214);
        ((GeneralPath) shape).curveTo(150.34769, 860.9529, 260.55484, 755.6123, 397.90604, 621.6802);
        ((GeneralPath) shape).curveTo(535.2569, 487.74832, 648.3425, 375.35452, 651.20636, 369.92944);

        g.setPaint(new RadialGradientPaint(new Point2D.Double(34.67763900756836, 7.462276935577393), 47.595196f, new Point2D.Double(34.67763900756836, 7.462276935577393), new float[]{0, 1}, new Color[]{new Color(0xAEFFFFFF, true), new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(-5.2710423f, 5.1122856f, 0.0565352f, 0.04806852f, 583.521f, 436.0774f)));
        g.fill(shape);

        // _0_0_15
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(598.6383, 389.14136);
        ((GeneralPath) shape).curveTo(589.2468, 394.43787, 580.3458, 403.6702, 575.5643, 411.5855);
        ((GeneralPath) shape).lineTo(628.9884, 455.87228);
        ((GeneralPath) shape).lineTo(652.0623, 433.42813);
        ((GeneralPath) shape).lineTo(598.6383, 389.14136);
        ((GeneralPath) shape).closePath();
        ((GeneralPath) shape).moveTo(646.44745, 428.731);
        ((GeneralPath) shape).lineTo(623.3735, 451.17514);
        ((GeneralPath) shape).lineTo(642.0894, 466.8323);
        ((GeneralPath) shape).curveTo(650.2701, 462.412, 659.6565, 453.61646, 665.1634, 444.38815);
        ((GeneralPath) shape).lineTo(646.44745, 428.731);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(49.009883880615234, 8.495311737060547), 3.9750404f, new Point2D.Double(47.370887756347656, 6.770169734954834), new float[]{0, 1}, new Color[]{WHITE, new Color(0xAEAEAE)}, NO_CYCLE, SRGB, new AffineTransform(8.306848f, 6.9492874f, -2.9023533f, 2.8231347f, 238.14497f, 63.419575f)));
        g.fill(shape);

        // _0_0_16
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(104.94685, 956.4285);
        ((GeneralPath) shape).curveTo(92.79292, 955.3542, 82.34795, 938.795, 75.6263, 933.72876);
        ((GeneralPath) shape).lineTo(27.08107, 1006.0598);
        ((GeneralPath) shape).lineTo(104.94685, 956.4285);
        ((GeneralPath) shape).closePath();

        g.setPaint(BLACK);
        g.fill(shape);

        // _0_0_17
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(653.67847, 369.92987);
        ((GeneralPath) shape).lineTo(682.3308, 393.89966);
        ((GeneralPath) shape).lineTo(676.5144, 399.55737);
        ((GeneralPath) shape).lineTo(647.86206, 375.5876);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(49.01197052001953, 2.6743078231811523), 1.7246193f, new Point2D.Double(49.01197052001953, 2.6743078231811523), new float[]{0, 1}, new Color[]{WHITE, new Color(0x252525, true)}, NO_CYCLE, SRGB, new AffineTransform(8.306856f, 6.949296f, -0.9372174f, 0.9116372f, 261.04178f, 41.148357f)));
        g.fill(shape);

        // _0_0_18
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(670.83624, 368.5085);
        ((GeneralPath) shape).curveTo(684.6345, 378.41058, 694.37445, 391.94162, 694.9005, 393.235);
        ((GeneralPath) shape).curveTo(695.42676, 394.5284, 682.11523, 379.35507, 670.6938, 372.32797);
        ((GeneralPath) shape).curveTo(659.3597, 365.3545, 643.3519, 364.94678, 642.18396, 364.10092);
        ((GeneralPath) shape).curveTo(641.016, 363.25507, 633.1538, 355.53052, 640.40753, 355.91898);
        ((GeneralPath) shape).curveTo(647.9946, 356.3253, 660.17834, 360.86722, 670.83624, 368.5085);
        ((GeneralPath) shape).closePath();

        g.setPaint(new LinearGradientPaint(new Point2D.Double(48.49856185913086, 0.8115049600601196), new Point2D.Double(48.732723236083984, 2.365726947784424), new float[]{0, 1}, new Color[]{new Color(0xAEFFFFFF, true), new Color(0xFFFFFF, true)}, NO_CYCLE, SRGB, new AffineTransform(8.306848f, 6.9492874f, -7.703674f, 7.4933925f, 278.93356f, 23.744234f)));
        g.fill(shape);

        // _0_0_19
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(244.34415, 833.61896);
        ((GeneralPath) shape).curveTo(242.84435, 835.0763, 241.99734, 836.47125, 241.80292, 837.8037);
        ((GeneralPath) shape).curveTo(241.6085, 839.13635, 242.08511, 840.28314, 243.23273, 841.24414);
        ((GeneralPath) shape).curveTo(244.3755, 842.2011, 245.67625, 842.5427, 247.13495, 842.26904);
        ((GeneralPath) shape).curveTo(248.59369, 841.9951, 250.07288, 841.1297, 251.5726, 839.6724);
        ((GeneralPath) shape).curveTo(253.08095, 838.2067, 253.9322, 836.80774, 254.12665, 835.47516);
        ((GeneralPath) shape).curveTo(254.321, 834.1425, 253.84676, 832.99786, 252.70409, 832.04083);
        ((GeneralPath) shape).curveTo(251.55643, 831.0797, 250.25328, 830.7362, 248.79459, 831.00995);
        ((GeneralPath) shape).curveTo(247.33588, 831.2837, 245.85242, 832.1534, 244.34415, 833.61896);
        ((GeneralPath) shape).moveTo(242.3091, 831.9147);
        ((GeneralPath) shape).curveTo(245.37675, 828.9339, 248.28055, 827.0183, 251.02061, 826.168);
        ((GeneralPath) shape).curveTo(253.7606, 825.3178, 256.01328, 825.6319, 257.77844, 827.11005);
        ((GeneralPath) shape).curveTo(259.53876, 828.5843, 260.0506, 830.58527, 259.31406, 833.1133);
        ((GeneralPath) shape).curveTo(258.57742, 835.64136, 256.67532, 838.39575, 253.60764, 841.37665);
        ((GeneralPath) shape).curveTo(250.54854, 844.34906, 247.64476, 846.2647, 244.89612, 847.1233);
        ((GeneralPath) shape).curveTo(242.1561, 847.97345, 239.90593, 847.6615, 238.14555, 846.1873);
        ((GeneralPath) shape).curveTo(236.38042, 844.70917, 235.8661, 842.706, 236.60275, 840.17804);
        ((GeneralPath) shape).curveTo(237.34785, 837.6417, 239.24997, 834.8873, 242.3091, 831.9147);
        ((GeneralPath) shape).moveTo(271.07535, 813.965);
        ((GeneralPath) shape).lineTo(283.25452, 812.1859);
        ((GeneralPath) shape).lineTo(278.12897, 817.1665);
        ((GeneralPath) shape).lineTo(269.94815, 818.38574);
        ((GeneralPath) shape).lineTo(269.24564, 825.79846);
        ((GeneralPath) shape).lineTo(264.0946, 830.8037);
        ((GeneralPath) shape).lineTo(265.15732, 819.7156);
        ((GeneralPath) shape).lineTo(253.46, 821.4356);
        ((GeneralPath) shape).lineTo(258.5983, 816.4427);
        ((GeneralPath) shape).lineTo(266.2864, 815.3194);
        ((GeneralPath) shape).lineTo(266.94482, 808.33234);
        ((GeneralPath) shape).lineTo(272.1087, 803.3146);
        ((GeneralPath) shape).lineTo(271.07535, 813.965);
        ((GeneralPath) shape).moveTo(272.6455, 802.7929);
        ((GeneralPath) shape).lineTo(278.02667, 797.564);
        ((GeneralPath) shape).lineTo(286.25293, 796.5908);
        ((GeneralPath) shape).lineTo(286.71826, 789.1183);
        ((GeneralPath) shape).lineTo(292.11218, 783.877);
        ((GeneralPath) shape).lineTo(291.14148, 796.2217);
        ((GeneralPath) shape).lineTo(295.72958, 800.06384);
        ((GeneralPath) shape).lineTo(290.80847, 804.8457);
        ((GeneralPath) shape).lineTo(286.2205, 801.0034);
        ((GeneralPath) shape).lineTo(272.6455, 802.7929);
        ((GeneralPath) shape).moveTo(321.45496, 773.6016);
        ((GeneralPath) shape).curveTo(320.5682, 775.079, 319.5496, 776.5306, 318.39902, 777.95654);
        ((GeneralPath) shape).curveTo(317.24844, 779.3825, 315.97012, 780.7786, 314.56415, 782.1448);
        ((GeneralPath) shape).curveTo(311.3857, 785.2333, 308.362, 787.25653, 305.4929, 788.2146);
        ((GeneralPath) shape).curveTo(302.619, 789.16864, 300.31403, 788.9186, 298.578, 787.4649);
        ((GeneralPath) shape).curveTo(296.82245, 785.99475, 296.38733, 783.9191, 297.27246, 781.2381);
        ((GeneralPath) shape).curveTo(298.1576, 778.5568, 300.24478, 775.6183, 303.5339, 772.4222);
        ((GeneralPath) shape).curveTo(304.80362, 771.1884, 306.08597, 770.0654, 307.381, 769.0534);
        ((GeneralPath) shape).curveTo(308.68457, 768.033, 309.98557, 767.13403, 311.2841, 766.35596);
        ((GeneralPath) shape).lineTo(313.53802, 768.2436);
        ((GeneralPath) shape).curveTo(312.1276, 768.9894, 310.80896, 769.80444, 309.58215, 770.6886);
        ((GeneralPath) shape).curveTo(308.36386, 771.56445, 307.2263, 772.5159, 306.16974, 773.5426);
        ((GeneralPath) shape).curveTo(304.20984, 775.447, 303.01102, 777.1794, 302.57315, 778.73975);
        ((GeneralPath) shape).curveTo(302.13895, 780.2878, 302.50302, 781.54846, 303.66516, 782.5216);
        ((GeneralPath) shape).curveTo(304.8176, 783.4868, 306.21887, 783.73517, 307.8687, 783.26685);
        ((GeneralPath) shape).curveTo(309.51852, 782.7986, 311.28494, 781.64954, 313.1682, 779.8195);
        ((GeneralPath) shape).curveTo(313.6794, 779.3228, 314.1353, 778.84906, 314.5359, 778.39813);
        ((GeneralPath) shape).curveTo(314.9401, 777.93506, 315.27805, 777.50116, 315.5495, 777.0965);
        ((GeneralPath) shape).lineTo(313.43427, 775.325);
        ((GeneralPath) shape).lineTo(310.43045, 778.24384);
        ((GeneralPath) shape).lineTo(308.54865, 776.6679);
        ((GeneralPath) shape).lineTo(316.21774, 769.2158);
        ((GeneralPath) shape).lineTo(321.45496, 773.6016);
        ((GeneralPath) shape).moveTo(315.69464, 760.96185);
        ((GeneralPath) shape).lineTo(328.97495, 748.05725);
        ((GeneralPath) shape).lineTo(331.0975, 749.8347);
        ((GeneralPath) shape).lineTo(322.7382, 757.9575);
        ((GeneralPath) shape).lineTo(324.766, 759.65564);
        ((GeneralPath) shape).lineTo(332.62683, 752.0173);
        ((GeneralPath) shape).lineTo(334.74942, 753.7948);
        ((GeneralPath) shape).lineTo(326.88858, 761.43317);
        ((GeneralPath) shape).lineTo(329.38324, 763.5223);
        ((GeneralPath) shape).lineTo(338.02374, 755.1263);
        ((GeneralPath) shape).lineTo(340.14636, 756.9038);
        ((GeneralPath) shape).lineTo(326.5848, 770.08167);
        ((GeneralPath) shape).lineTo(315.69464, 760.96185);
        ((GeneralPath) shape).moveTo(333.5892, 743.57355);
        ((GeneralPath) shape).lineTo(339.0854, 738.23285);
        ((GeneralPath) shape).lineTo(353.49512, 737.74365);
        ((GeneralPath) shape).lineTo(346.0259, 731.4887);
        ((GeneralPath) shape).lineTo(350.69128, 726.9554);
        ((GeneralPath) shape).lineTo(361.58145, 736.0752);
        ((GeneralPath) shape).lineTo(356.08527, 741.4159);
        ((GeneralPath) shape).lineTo(341.67548, 741.905);
        ((GeneralPath) shape).lineTo(349.14474, 748.16003);
        ((GeneralPath) shape).lineTo(344.47937, 752.69336);
        ((GeneralPath) shape).lineTo(333.5892, 743.5736);
        ((GeneralPath) shape).moveTo(364.57233, 713.4671);
        ((GeneralPath) shape).lineTo(370.0685, 708.1265);
        ((GeneralPath) shape).lineTo(384.47824, 707.6372);
        ((GeneralPath) shape).lineTo(377.00903, 701.3823);
        ((GeneralPath) shape).lineTo(381.67438, 696.84894);
        ((GeneralPath) shape).lineTo(392.56454, 705.96875);
        ((GeneralPath) shape).lineTo(387.0684, 711.30945);
        ((GeneralPath) shape).lineTo(372.6586, 711.7985);
        ((GeneralPath) shape).lineTo(380.12784, 718.0536);
        ((GeneralPath) shape).lineTo(375.46252, 722.5869);
        ((GeneralPath) shape).lineTo(364.57233, 713.4671);
        ((GeneralPath) shape).moveTo(391.24274, 687.195);
        ((GeneralPath) shape).curveTo(393.0578, 685.4314, 394.7592, 684.2663, 396.34705, 683.6998);
        ((GeneralPath) shape).curveTo(397.9435, 683.1252, 399.2036, 683.2246, 400.12756, 683.99835);
        ((GeneralPath) shape).curveTo(401.05145, 684.7721, 401.25684, 685.89215, 400.74365, 687.3585);
        ((GeneralPath) shape).curveTo(400.23044, 688.825, 399.0621, 690.44415, 397.23853, 692.21606);
        ((GeneralPath) shape).curveTo(395.415, 693.98804, 393.70746, 695.1634, 392.1159, 695.7421);
        ((GeneralPath) shape).curveTo(390.5329, 696.3126, 389.2794, 696.21106, 388.3555, 695.4374);
        ((GeneralPath) shape).curveTo(387.43155, 694.66364, 387.22382, 693.5415, 387.73212, 692.071);
        ((GeneralPath) shape).curveTo(388.249, 690.5923, 389.41925, 688.967, 391.24274, 687.195);
        ((GeneralPath) shape).moveTo(392.88425, 698.09674);
        ((GeneralPath) shape).lineTo(403.40366, 687.875);
        ((GeneralPath) shape).lineTo(404.86246, 689.0966);
        ((GeneralPath) shape).lineTo(394.34302, 699.3184);
        ((GeneralPath) shape).lineTo(392.88425, 698.09674);
        ((GeneralPath) shape).moveTo(392.48276, 688.2334);
        ((GeneralPath) shape).curveTo(391.76703, 688.929, 391.36633, 689.59546, 391.28067, 690.23285);
        ((GeneralPath) shape).curveTo(391.20355, 690.86206, 391.44708, 691.4128, 392.01114, 691.8852);
        ((GeneralPath) shape).curveTo(392.5752, 692.3576, 393.19974, 692.5337, 393.8847, 692.4136);
        ((GeneralPath) shape).curveTo(394.57816, 692.2852, 395.2828, 691.8732, 395.99854, 691.1776);
        ((GeneralPath) shape).curveTo(396.70584, 690.4904, 397.10043, 689.8343, 397.1824, 689.20917);
        ((GeneralPath) shape).curveTo(397.27283, 688.5758, 397.03604, 688.0229, 396.472, 687.55054);
        ((GeneralPath) shape).curveTo(395.90793, 687.0781, 395.2767, 686.9041, 394.57837, 687.02844);
        ((GeneralPath) shape).curveTo(393.88858, 687.1446, 393.19006, 687.54626, 392.48276, 688.2334);
        ((GeneralPath) shape).moveTo(425.08936, 663.7413);
        ((GeneralPath) shape).curveTo(426.5657, 662.64984, 427.87207, 661.9787, 429.00836, 661.72784);
        ((GeneralPath) shape).curveTo(430.14838, 661.46466, 431.08066, 661.63654, 431.80524, 662.2432);
        ((GeneralPath) shape).curveTo(432.88474, 663.1472, 432.98224, 664.53925, 432.0977, 666.41925);
        ((GeneralPath) shape).curveTo(431.2083, 668.29517, 429.37463, 670.5828, 426.59674, 673.2821);
        ((GeneralPath) shape).curveTo(425.6168, 674.2343, 424.58646, 675.15204, 423.50555, 676.0351);
        ((GeneralPath) shape).curveTo(422.4381, 676.91406, 421.33295, 677.746, 420.1902, 678.531);
        ((GeneralPath) shape).lineTo(418.02377, 676.71674);
        ((GeneralPath) shape).curveTo(419.20667, 676.0425, 420.31778, 675.3234, 421.35718, 674.55975);
        ((GeneralPath) shape).curveTo(422.40024, 673.7837, 423.36066, 672.9693, 424.23834, 672.11646);
        ((GeneralPath) shape).curveTo(425.54205, 670.8496, 426.41022, 669.7729, 426.8427, 668.88635);
        ((GeneralPath) shape).curveTo(427.2837, 667.9916, 427.2635, 667.3426, 426.7821, 666.9394);
        ((GeneralPath) shape).curveTo(426.2861, 666.52405, 425.55377, 666.5582, 424.58514, 667.04205);
        ((GeneralPath) shape).curveTo(423.62015, 667.5135, 422.44318, 668.4241, 421.05423, 669.7737);
        ((GeneralPath) shape).lineTo(419.08585, 671.6864);
        ((GeneralPath) shape).lineTo(417.2769, 670.1716);
        ((GeneralPath) shape).lineTo(419.34756, 668.1595);
        ((GeneralPath) shape).curveTo(420.58313, 666.95886, 421.39398, 665.973, 421.78015, 665.20184);
        ((GeneralPath) shape).curveTo(422.16147, 664.42664, 422.126, 663.8497, 421.67392, 663.471);
        ((GeneralPath) shape).curveTo(421.25565, 663.1207, 420.63837, 663.1356, 419.8218, 663.5154);
        ((GeneralPath) shape).curveTo(419.0053, 663.8954, 418.0602, 664.607, 416.9865, 665.6502);
        ((GeneralPath) shape).curveTo(416.1941, 666.42035, 415.44415, 667.24146, 414.73672, 668.11346);
        ((GeneralPath) shape).curveTo(414.02933, 668.98566, 413.37482, 669.89435, 412.7732, 670.8396);
        ((GeneralPath) shape).lineTo(410.71628, 669.11707);
        ((GeneralPath) shape).curveTo(411.53207, 668.04285, 412.37823, 667.00946, 413.25482, 666.0169);
        ((GeneralPath) shape).curveTo(414.13138, 665.0244, 415.02985, 664.08105, 415.95013, 663.18677);
        ((GeneralPath) shape).curveTo(418.4298, 660.77734, 420.5165, 659.17175, 422.21045, 658.37036);
        ((GeneralPath) shape).curveTo(423.90796, 657.55664, 425.22354, 657.5407, 426.15723, 658.3227);
        ((GeneralPath) shape).curveTo(426.79425, 658.8562, 427.02304, 659.57965, 426.84357, 660.49304);
        ((GeneralPath) shape).curveTo(426.65912, 661.4023, 426.07446, 662.4851, 425.08945, 663.74133);

        g.setPaint(new LinearGradientPaint(new Point2D.Double(49.15303039550781, 75.31031799316406), new Point2D.Double(82.4846420288086, 75.31031799316406), new float[]{0, 1}, new Color[]{new Color(0xB4942A), new Color(0xE4DCC9)}, NO_CYCLE, SRGB, new AffineTransform(5.8928394f, 0, 0, 5.29641f, -53.37352f, 353.79453f)));
        g.fill(shape);

        // _0_0_20
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(634.4209, 354.7007);
        ((GeneralPath) shape).lineTo(652.8153, 372.2737);
        ((GeneralPath) shape).lineTo(648.247, 375.54333);
        ((GeneralPath) shape).lineTo(629.8526, 357.97034);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(49.01197052001953, 2.6743078231811523), 1.7246193f, new Point2D.Double(49.01197052001953, 2.6743078231811523), new float[]{0, 1}, new Color[]{WHITE, new Color(0x252525, true)}, NO_CYCLE, SRGB, new AffineTransform(5.332892f, 5.0947485f, -0.736098f, 0.52683944f, 382.37823f, 113.68681f)));
        g.fill(shape);

        // _0_0_21
        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(701.94495, 410.34937);
        ((GeneralPath) shape).lineTo(681.9949, 394.20557);
        ((GeneralPath) shape).lineTo(678.458, 398.38214);
        ((GeneralPath) shape).lineTo(698.4081, 414.5259);
        ((GeneralPath) shape).closePath();

        g.setPaint(new RadialGradientPaint(new Point2D.Double(49.01197052001953, 2.6743078231811523), 1.7246193f, new Point2D.Double(49.01197052001953, 2.6743078231811523), new float[]{0, 1}, new Color[]{WHITE, new Color(0x252525, true)}, NO_CYCLE, SRGB, new AffineTransform(-5.7839184f, -4.68039f, -0.5699031f, 0.67297757f, 975.5557f, 631.54846f)));
        g.fill(shape);

        g.setTransform(transformations.poll()); // _0_0

        g.setTransform(transformations.poll()); // _0

    }

    /**
     * Returns the X of the bounding box of the original SVG image.
     *
     * @return The X of the bounding box of the original SVG image.
     */
    public static int getOrigX() {
        return 1;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     *
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 10;
    }

    /**
     * Returns the width of the bounding box of the original SVG image.
     *
     * @return The width of the bounding box of the original SVG image.
     */
    public static int getOrigWidth() {
        return 755;
    }

    /**
     * Returns the height of the bounding box of the original SVG image.
     *
     * @return The height of the bounding box of the original SVG image.
     */
    public static int getOrigHeight() {
        return 727;
    }

    /**
     * The current width of this resizable icon.
     */
    int width;

    /**
     * The current height of this resizable icon.
     */
    int height;

    /**
     * Creates a new transcoded SVG image.
     */
    public WriteModel() {
        this.width = getOrigWidth();
        this.height = getOrigHeight();
    }

    @Override
    public int getIconHeight() {
        return height;
    }

    @Override
    public int getIconWidth() {
        return width;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.pushingpixels.flamingo.api.common.icon.ResizableIcon#setDimension(java.awt.Dimension)
     */
    @Override
    public void setDimension(Dimension dimension) {
        this.width = dimension.width;
        this.height = dimension.height;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.translate(x, y);

        double coef1 = (double) this.width / (double) getOrigWidth();
        double coef2 = (double) this.height / (double) getOrigHeight();
        double coef = Math.min(coef1, coef2);
        g2d.scale(coef, coef);
        paint(g2d);
        g2d.dispose();
    }
}

