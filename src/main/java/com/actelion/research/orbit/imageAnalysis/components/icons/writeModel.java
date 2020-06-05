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
public class writeModel implements ResizableIcon {
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
paint = new Color(242, 242, 242, 255);
stroke = new BasicStroke(26.498343f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(42.410683f, 993.34845f);
generalPath.curveTo(46.75866f, 967.8471f, 53.139862f, 945.5428f, 59.229828f, 922.8538f);
generalPath.curveTo(62.234028f, 911.6613f, 65.541084f, 901.02075f, 68.3402f, 889.4616f);
generalPath.curveTo(85.128365f, 820.1337f, 68.90453f, 880.022f, 83.757744f, 817.1118f);
generalPath.curveTo(87.054375f, 803.1492f, 91.110016f, 790.48193f, 94.269714f, 776.29913f);
generalPath.curveTo(98.746796f, 756.20306f, 101.42086f, 732.7217f, 104.78169f, 711.3699f);
generalPath.curveTo(106.55144f, 700.1263f, 108.57549f, 689.17334f, 110.38806f, 677.97766f);
generalPath.curveTo(112.45768f, 665.1942f, 113.76675f, 655.8666f, 115.29364f, 642.73035f);
generalPath.curveTo(116.4808f, 632.5169f, 115.71119f, 635.3487f, 116.69523f, 622.324f);
generalPath.curveTo(117.61765f, 610.1152f, 117.39604f, 623.347f, 117.39604f, 611.19324f);
generalPath.curveTo(123.40209f, 623.9124f, 119.20731f, 612.69727f, 123.7032f, 635.3098f);
generalPath.curveTo(124.97199f, 641.69135f, 126.5303f, 647.6398f, 127.90798f, 653.8611f);
generalPath.curveTo(148.55287f, 747.0881f, 123.62439f, 633.6906f, 141.92393f, 722.5006f);
generalPath.curveTo(142.48325f, 725.2149f, 143.54301f, 727.1063f, 144.02634f, 729.9211f);
generalPath.curveTo(145.40536f, 737.9523f, 145.49335f, 745.62805f, 146.12872f, 754.0377f);
generalPath.curveTo(146.55109f, 759.6281f, 147.10796f, 765.1434f, 147.53032f, 770.73376f);
generalPath.curveTo(147.80898f, 774.4222f, 148.08974f, 778.12177f, 148.23112f, 781.8645f);
generalPath.curveTo(148.39383f, 786.17163f, 148.23112f, 790.5217f, 148.23112f, 794.85034f);
generalPath.curveTo(148.23112f, 802.2709f, 148.23112f, 809.69135f, 148.23112f, 817.1118f);
generalPath.curveTo(148.23112f, 821.4405f, 148.23112f, 825.76904f, 148.23112f, 830.0977f);
generalPath.curveTo(148.23112f, 831.3344f, 148.1178f, 832.60815f, 148.23112f, 833.8079f);
generalPath.curveTo(148.3578f, 835.14935f, 148.76672f, 836.2064f, 148.93192f, 837.5182f);
generalPath.curveTo(149.2365f, 839.93695f, 149.39911f, 842.46515f, 149.63272f, 844.93866f);
generalPath.curveTo(150.3335f, 849.2673f, 151.07439f, 853.55194f, 151.7351f, 857.92456f);
generalPath.curveTo(151.80635f, 858.39606f, 153.11453f, 868.97705f, 153.1367f, 869.05524f);
generalPath.curveTo(153.4501f, 870.16144f, 154.30469f, 869.67365f, 154.53828f, 870.9104f);
generalPath.curveTo(154.85172f, 872.56964f, 154.31668f, 874.7158f, 154.53828f, 876.47577f);
generalPath.curveTo(154.61217f, 877.0624f, 155.07391f, 876.03845f, 155.23909f, 876.47577f);
generalPath.curveTo(155.26163f, 876.5354f, 155.23909f, 881.5912f, 155.23909f, 882.04114f);
generalPath.curveTo(155.23909f, 886.3917f, 155.07391f, 881.1666f, 155.9399f, 885.75134f);
generalPath.curveTo(156.04436f, 886.30444f, 155.7747f, 887.16925f, 155.9399f, 887.6065f);
generalPath.curveTo(156.10507f, 888.04376f, 156.47551f, 887.16925f, 156.6407f, 887.6065f);
generalPath.curveTo(156.78395f, 887.9857f, 156.50175f, 892.43634f, 156.6407f, 893.1719f);
generalPath.curveTo(156.78844f, 893.95404f, 157.19376f, 894.2448f, 157.34148f, 895.027f);
generalPath.curveTo(157.44595f, 895.5801f, 157.34148f, 896.26373f, 157.34148f, 896.8821f);
generalPath.curveTo(157.34148f, 898.11884f, 157.22818f, 899.3925f, 157.34148f, 900.59235f);
generalPath.curveTo(157.46817f, 901.9338f, 157.8483f, 903.01874f, 158.0423f, 904.3026f);
generalPath.curveTo(159.0869f, 911.21576f, 159.6614f, 917.65656f, 160.84547f, 924.7089f);
generalPath.curveTo(161.26976f, 927.236f, 161.70958f, 929.75806f, 162.24707f, 932.1294f);
generalPath.curveTo(162.41702f, 932.87933f, 162.8434f, 933.1549f, 162.94788f, 933.98456f);
generalPath.curveTo(163.09561f, 935.1578f, 162.73894f, 936.5886f, 162.94788f, 937.69476f);
generalPath.curveTo(163.05232f, 938.24786f, 163.43971f, 937.9713f, 163.64867f, 937.69476f);
generalPath.curveTo(163.94415f, 937.3037f, 164.11586f, 936.45807f, 164.34946f, 935.83966f);
generalPath.curveTo(167.42604f, 927.6955f, 164.4448f, 936.2381f, 168.55424f, 919.14355f);
generalPath.curveTo(169.1813f, 916.5351f, 170.02957f, 914.33154f, 170.65665f, 911.7231f);
generalPath.curveTo(171.66776f, 907.517f, 172.52544f, 903.06586f, 173.45982f, 898.73724f);
generalPath.curveTo(176.86317f, 882.9711f, 176.68301f, 884.7341f, 179.767f, 865.34503f);
generalPath.curveTo(183.23186f, 843.56146f, 180.67744f, 856.6614f, 183.97179f, 831.9528f);
generalPath.curveTo(184.56389f, 827.5119f, 185.31668f, 823.2281f, 186.07419f, 818.967f);
generalPath.curveTo(188.53676f, 805.1145f, 190.96169f, 793.45245f, 193.78296f, 780.0094f);
generalPath.curveTo(194.69759f, 775.6513f, 195.70496f, 771.4296f, 196.58615f, 767.02356f);
generalPath.curveTo(197.75415f, 760.8398f, 198.92213f, 754.65607f, 200.09013f, 748.4723f);
generalPath.curveTo(201.02454f, 744.7621f, 202.0947f, 741.2677f, 202.89333f, 737.34155f);
generalPath.curveTo(205.42316f, 724.9045f, 204.16396f, 725.43634f, 207.09811f, 715.0801f);
generalPath.curveTo(207.69276f, 712.98126f, 208.69061f, 711.7644f, 209.2005f, 709.5148f);
generalPath.curveTo(211.3029f, 700.23914f, 208.1493f, 709.5148f, 209.2005f, 703.94934f);
generalPath.curveTo(209.34825f, 703.1672f, 209.75357f, 702.87646f, 209.9013f, 702.09424f);
generalPath.curveTo(210.88242f, 696.8999f, 211.02258f, 690.59247f, 212.0037f, 685.39813f);
generalPath.curveTo(212.42418f, 683.172f, 213.68561f, 682.05896f, 214.1061f, 679.8328f);
generalPath.curveTo(214.31502f, 678.7266f, 213.77573f, 676.9971f, 214.1061f, 676.12256f);
generalPath.curveTo(214.27126f, 675.6853f, 214.6417f, 676.55975f, 214.80688f, 676.12256f);
generalPath.curveTo(214.97208f, 675.6853f, 214.6417f, 674.70465f, 214.80688f, 674.2674f);
generalPath.curveTo(214.97208f, 673.83014f, 215.34251f, 674.70465f, 215.50769f, 674.2674f);
generalPath.curveTo(215.67287f, 673.83014f, 215.40321f, 672.9654f, 215.50769f, 672.4123f);
generalPath.curveTo(215.80318f, 670.8479f, 216.6138f, 670.2664f, 216.90929f, 668.702f);
generalPath.curveTo(217.01375f, 668.1489f, 216.7441f, 667.2842f, 216.90929f, 666.8469f);
generalPath.curveTo(218.35925f, 663.0086f, 216.85262f, 672.7124f, 218.31087f, 664.99176f);
generalPath.curveTo(218.41534f, 664.43866f, 218.1457f, 663.5739f, 218.31087f, 663.13666f);
generalPath.curveTo(218.47604f, 662.6994f, 218.80273f, 663.4132f, 219.01167f, 663.13666f);
generalPath.curveTo(219.30714f, 662.7456f, 219.41698f, 661.6726f, 219.71246f, 661.28156f);
generalPath.curveTo(219.92142f, 661.005f, 220.20435f, 661.5581f, 220.41327f, 661.28156f);
generalPath.curveTo(220.9483f, 660.57336f, 222.55351f, 653.9613f, 223.21646f, 655.7162f);
generalPath.curveTo(223.38164f, 656.15344f, 223.1297f, 656.99713f, 223.21646f, 657.5713f);
generalPath.curveTo(223.60445f, 660.139f, 224.21266f, 662.44305f, 224.61806f, 664.99176f);
generalPath.curveTo(226.08255f, 674.19904f, 227.42123f, 683.543f, 228.82283f, 692.81866f);
generalPath.curveTo(237.77267f, 752.04767f, 234.1134f, 721.1574f, 238.634f, 770.73376f);
generalPath.curveTo(239.312f, 778.16907f, 239.73283f, 785.8226f, 240.73639f, 792.99524f);
generalPath.curveTo(242.87836f, 808.3045f, 246.33757f, 822.17554f, 248.44518f, 837.5182f);
generalPath.curveTo(250.86903f, 855.1631f, 252.2606f, 873.72723f, 254.75235f, 891.3167f);
generalPath.curveTo(255.63576f, 897.5528f, 256.43036f, 903.911f, 257.55554f, 909.868f);
generalPath.curveTo(258.30887f, 913.8563f, 259.4478f, 917.24774f, 260.35873f, 920.9987f);
generalPath.curveTo(261.5504f, 925.9059f, 262.67957f, 930.91797f, 263.86273f, 935.83966f);
generalPath.curveTo(264.3149f, 937.7207f, 264.88763f, 939.4108f, 265.2643f, 941.405f);
generalPath.curveTo(265.59467f, 943.15405f, 265.55536f, 945.3434f, 265.96512f, 946.9704f);
generalPath.curveTo(266.88135f, 950.6086f, 268.55283f, 952.60785f, 269.4691f, 956.246f);
generalPath.curveTo(269.59866f, 956.76056f, 269.30392f, 957.6639f, 269.4691f, 958.10114f);
generalPath.curveTo(269.63428f, 958.5384f, 270.00473f, 957.6639f, 270.1699f, 958.10114f);
generalPath.curveTo(270.33508f, 958.5384f, 270.1699f, 959.3379f, 270.1699f, 959.9561f);
generalPath.curveTo(270.1699f, 960.5745f, 270.1699f, 961.1929f, 270.1699f, 961.8113f);
generalPath.curveTo(270.1699f, 962.4297f, 270.00473f, 963.2294f, 270.1699f, 963.66644f);
generalPath.curveTo(270.19244f, 963.7262f, 272.10233f, 963.66644f, 272.27228f, 963.66644f);
generalPath.curveTo(272.73947f, 963.66644f, 273.36136f, 964.5859f, 273.6739f, 963.66644f);
generalPath.curveTo(277.56396f, 952.2247f, 284.26694f, 918.8571f, 286.28824f, 909.868f);
generalPath.curveTo(294.52966f, 873.2165f, 304.39514f, 835.8192f, 309.41455f, 794.85034f);
generalPath.curveTo(310.90024f, 782.72406f, 311.57947f, 769.9933f, 312.91855f, 757.7479f);
generalPath.curveTo(313.21152f, 755.0689f, 318.5552f, 712.1996f, 319.92654f, 703.94934f);
generalPath.curveTo(321.2156f, 689.2043f, 325.3146f, 678.30206f, 327.63528f, 664.99176f);
generalPath.curveTo(328.25443f, 661.4408f, 328.43686f, 657.43494f, 329.0369f, 653.8611f);
generalPath.curveTo(329.37897f, 651.82367f, 330.0206f, 650.2315f, 330.43848f, 648.2957f);
generalPath.curveTo(330.9568f, 645.8946f, 331.32178f, 643.2763f, 331.84006f, 640.8752f);
generalPath.curveTo(332.25797f, 638.9394f, 332.7953f, 637.2005f, 333.24167f, 635.3098f);
generalPath.curveTo(333.9636f, 632.2522f, 334.52682f, 628.91876f, 335.34406f, 626.03424f);
generalPath.curveTo(335.93872f, 623.93536f, 336.8704f, 622.6037f, 337.44647f, 620.4688f);
generalPath.curveTo(338.05368f, 618.2185f, 338.31058f, 615.41974f, 338.84805f, 613.04834f);
generalPath.curveTo(339.01804f, 612.29846f, 339.40112f, 611.97546f, 339.54886f, 611.19324f);
generalPath.curveTo(339.8792f, 609.4442f, 339.8696f, 607.3047f, 340.24966f, 605.62787f);
generalPath.curveTo(340.92953f, 602.62836f, 342.25998f, 601.00586f, 343.05283f, 598.2074f);
generalPath.curveTo(343.36624f, 597.1012f, 343.28644f, 595.11554f, 343.75363f, 594.49713f);
generalPath.curveTo(344.04913f, 594.1061f, 344.30203f, 595.5764f, 344.45444f, 596.35223f);
generalPath.curveTo(347.34625f, 611.0736f, 350.27023f, 625.7697f, 352.864f, 640.8752f);
generalPath.curveTo(358.44882f, 673.3997f, 363.04578f, 707.11176f, 368.98236f, 739.1967f);
generalPath.curveTo(404.7861f, 932.7022f, 371.81738f, 740.4102f, 397.01425f, 870.9104f);
generalPath.curveTo(399.20596f, 882.2618f, 400.94385f, 894.2073f, 402.62064f, 906.1577f);
generalPath.curveTo(410.66504f, 963.48987f, 401.6996f, 909.3379f, 409.6286f, 961.8113f);
generalPath.curveTo(410.4046f, 966.94666f, 411.4974f, 971.7055f, 412.4318f, 976.6523f);
generalPath.curveTo(423.601f, 933.6463f, 416.69296f, 959.1741f, 429.25095f, 915.43335f);
generalPath.curveTo(430.6644f, 910.5101f, 432.15997f, 905.73755f, 433.45572f, 900.59235f);
generalPath.curveTo(434.03522f, 898.2913f, 434.31982f, 895.5432f, 434.85733f, 893.1719f);
generalPath.curveTo(436.44482f, 886.1679f, 434.63263f, 901.15186f, 436.95972f, 885.75134f);
generalPath.curveTo(437.13324f, 884.6031f, 436.95972f, 883.2779f, 436.95972f, 882.04114f);
generalPath.curveTo(451.13763f, 823.06354f, 431.72845f, 905.34753f, 446.77087f, 835.6631f);
generalPath.curveTo(448.46622f, 827.8093f, 454.3006f, 809.59766f, 455.88126f, 804.126f);
generalPath.curveTo(458.3226f, 795.67487f, 460.31635f, 786.3273f, 462.88922f, 778.1543f);
generalPath.curveTo(463.9467f, 774.79517f, 465.47696f, 772.51685f, 466.39322f, 768.87866f);
generalPath.curveTo(467.38004f, 764.9602f, 467.5803f, 759.9311f, 468.4956f, 755.8928f);
generalPath.curveTo(470.9897f, 744.8891f, 472.9726f, 742.4349f, 474.8028f, 731.7762f);
generalPath.curveTo(475.41412f, 728.2158f, 475.65567f, 724.2767f, 476.20438f, 720.64545f);
generalPath.curveTo(476.59238f, 718.0778f, 477.13876f, 715.6985f, 477.60596f, 713.225f);
generalPath.curveTo(477.83957f, 711.9882f, 478.01703f, 710.6652f, 478.30676f, 709.5148f);
generalPath.curveTo(478.49002f, 708.7871f, 478.85983f, 708.4418f, 479.00757f, 707.6596f);
generalPath.curveTo(479.1465f, 706.9241f, 478.8643f, 702.4735f, 479.00757f, 702.09424f);
generalPath.curveTo(479.17276f, 701.657f, 479.54318f, 702.5315f, 479.70837f, 702.09424f);
generalPath.curveTo(480.05878f, 701.1667f, 479.35797f, 697.4564f, 479.70837f, 696.5289f);
generalPath.curveTo(479.87354f, 696.0916f, 480.244f, 696.9661f, 480.40918f, 696.5289f);
generalPath.curveTo(480.55243f, 696.1496f, 480.27023f, 691.69904f, 480.40918f, 690.9635f);
generalPath.curveTo(480.5569f, 690.18134f, 480.87637f, 689.72675f, 481.10995f, 689.1084f);
generalPath.curveTo(481.34357f, 687.87164f, 481.61676f, 686.682f, 481.81076f, 685.39813f);
generalPath.curveTo(482.0851f, 683.5825f, 482.2372f, 681.6484f, 482.51154f, 679.8328f);
generalPath.curveTo(483.17227f, 675.4602f, 484.00598f, 671.27277f, 484.61395f, 666.8469f);
generalPath.curveTo(484.9431f, 664.4508f, 485.0102f, 661.8452f, 485.31476f, 659.4264f);
generalPath.curveTo(485.71255f, 656.2673f, 486.15378f, 653.1293f, 486.71634f, 650.1508f);
generalPath.curveTo(487.65344f, 645.1896f, 489.9999f, 635.841f, 490.92114f, 629.74445f);
generalPath.curveTo(496.07196f, 595.65686f, 489.69476f, 630.9038f, 493.7243f, 614.9035f);
generalPath.curveTo(493.8539f, 614.389f, 493.49072f, 613.04834f, 493.7243f, 613.04834f);
generalPath.curveTo(494.0547f, 613.04834f, 494.2927f, 614.1023f, 494.4251f, 614.9035f);
generalPath.curveTo(495.93777f, 624.056f, 497.34018f, 633.3417f, 498.6299f, 642.73035f);
generalPath.curveTo(501.07877f, 660.5573f, 503.19684f, 678.69434f, 505.63788f, 696.5289f);
generalPath.curveTo(532.88934f, 895.6323f, 506.3885f, 697.5208f, 520.3546f, 802.2709f);
generalPath.curveTo(521.7562f, 812.7832f, 523.26654f, 823.19836f, 524.55945f, 833.8079f);
generalPath.curveTo(525.60364f, 842.3768f, 526.3723f, 851.1661f, 527.3626f, 859.77966f);
generalPath.curveTo(528.0079f, 865.3919f, 528.8282f, 870.85675f, 529.465f, 876.47577f);
generalPath.curveTo(530.23035f, 883.22894f, 530.8357f, 890.10284f, 531.5674f, 896.8821f);
generalPath.curveTo(532.23737f, 903.0897f, 533.017f, 909.2128f, 533.6698f, 915.43335f);
generalPath.curveTo(534.18536f, 920.34656f, 534.49133f, 925.41174f, 535.07135f, 930.2743f);
generalPath.curveTo(535.8947f, 937.1762f, 536.9646f, 943.8554f, 537.8746f, 950.68066f);
generalPath.curveTo(538.3663f, 954.36865f, 538.6648f, 958.251f, 539.2762f, 961.8113f);
generalPath.curveTo(539.8398f, 965.0939f, 540.9478f, 967.6663f, 541.37854f, 971.0871f);
generalPath.curveTo(541.674f, 973.43365f, 541.1953f, 976.082f, 541.37854f, 978.50745f);
generalPath.curveTo(541.44336f, 979.36505f, 541.8961f, 979.6349f, 542.07935f, 980.3626f);
generalPath.curveTo(542.3691f, 981.5132f, 542.615f, 982.7611f, 542.78015f, 984.07294f);
generalPath.curveTo(542.854f, 984.65936f, 542.615f, 985.4907f, 542.78015f, 985.92786f);
generalPath.curveTo(542.9453f, 986.3652f, 543.3158f, 985.4907f, 543.48096f, 985.92786f);
generalPath.curveTo(543.81134f, 986.80255f, 543.27203f, 988.53204f, 543.48096f, 989.6382f);
generalPath.curveTo(543.574f, 990.13086f, 545.3973f, 994.95746f, 545.5833f, 995.2036f);
generalPath.curveTo(545.7404f, 995.4114f, 548.22f, 995.2036f, 548.38654f, 995.2036f);
generalPath.curveTo(548.8537f, 995.2036f, 549.3825f, 995.8171f, 549.78815f, 995.2036f);
generalPath.curveTo(551.0868f, 993.23914f, 552.2759f, 990.6885f, 553.2921f, 987.783f);
generalPath.curveTo(571.7735f, 934.94604f, 562.5801f, 960.2374f, 576.41846f, 909.868f);
generalPath.curveTo(599.11975f, 827.2388f, 580.75464f, 896.99f, 599.54474f, 830.0977f);
generalPath.curveTo(603.14197f, 817.29175f, 606.67566f, 804.35236f, 610.0567f, 791.14014f);
generalPath.curveTo(611.5846f, 785.1696f, 613.0861f, 779.09454f, 614.26154f, 772.5889f);
generalPath.curveTo(616.4192f, 760.6463f, 618.60974f, 740.65936f, 620.56866f, 728.066f);
generalPath.curveTo(621.16534f, 724.2302f, 622.02264f, 720.7116f, 622.6711f, 716.93524f);
generalPath.curveTo(623.19165f, 713.9037f, 623.67487f, 710.8188f, 624.0727f, 707.6596f);
generalPath.curveTo(624.2284f, 706.4227f, 625.02435f, 696.4603f, 625.47424f, 694.67377f);
generalPath.curveTo(625.6038f, 694.15924f, 626.0349f, 694.1791f, 626.17505f, 694.67377f);
generalPath.curveTo(626.8019f, 696.8861f, 627.06934f, 699.6768f, 627.57666f, 702.09424f);
generalPath.curveTo(639.9882f, 761.23376f, 625.5129f, 687.13885f, 641.5926f, 780.0094f);
generalPath.curveTo(645.44696f, 802.2709f, 650.2825f, 824.53235f, 654.207f, 846.79376f);
generalPath.curveTo(655.7116f, 855.329f, 656.88855f, 864.25336f, 658.41174f, 872.7655f);
generalPath.curveTo(658.9949f, 876.0241f, 659.8619f, 878.8757f, 660.51416f, 882.04114f);
generalPath.curveTo(661.2645f, 885.6828f, 661.9157f, 889.4616f, 662.6165f, 893.1719f);
generalPath.curveTo(662.85016f, 894.40857f, 663.1907f, 895.54065f, 663.3173f, 896.8821f);
generalPath.curveTo(663.43066f, 898.0819f, 663.3173f, 899.3556f, 663.3173f, 900.59235f);
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
generalPath.moveTo(246.52959f, 371.17358f);
generalPath.lineTo(246.52959f, 356.37167f);
generalPath.lineTo(246.52959f, 371.17358f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 193);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.38139534f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(754.161f, 1005.6964f);
generalPath.curveTo(754.1601f, 1021.10443f, 585.53986f, 1033.5951f, 377.5366f, 1033.5951f);
generalPath.curveTo(169.53334f, 1033.5951f, 0.91312283f, 1021.10443f, 0.9121843f, 1005.6964f);
generalPath.curveTo(0.91221255f, 990.2883f, 169.5327f, 977.7976f, 377.5366f, 977.7976f);
generalPath.curveTo(585.54047f, 977.7976f, 754.161f, 990.2883f, 754.161f, 1005.6964f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(63.912208557128906, 115.70919036865234), 63.91221f, new Point2D.Double(14.046639442443848, 115.70919036865234), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(5.892839431762695f, 0.0f, 0.0f, 0.43651720881462097f, 0.9121942520141602f, 955.1871948242188f));
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
generalPath.moveTo(632.71234f, 355.94482f);
generalPath.curveTo(635.86194f, 352.88113f, 656.1692f, 354.66113f, 677.4952f, 372.50186f);
generalPath.curveTo(699.03033f, 390.51746f, 703.11224f, 407.7017f, 699.167f, 411.53906f);
generalPath.curveTo(696.5992f, 414.03687f, 694.0313f, 416.53467f, 691.4635f, 419.03247f);
generalPath.curveTo(669.31177f, 400.50104f, 647.1603f, 381.96964f, 625.00867f, 363.4382f);
generalPath.curveTo(627.57654f, 360.9404f, 630.1444f, 358.4426f, 632.71234f, 355.94482f);
generalPath.curveTo(632.71234f, 355.94482f, 632.71234f, 355.94482f, 632.71234f, 355.94482f);
shape = generalPath;
paint = new Color(0, 0, 0, 255);
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
generalPath.moveTo(27.071474f, 1006.0963f);
generalPath.lineTo(208.17526f, 890.0534f);
generalPath.lineTo(209.20206f, 889.0546f);
generalPath.lineTo(143.83806f, 832.3993f);
generalPath.lineTo(142.44632f, 833.75256f);
generalPath.lineTo(27.071474f, 1006.0963f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
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
generalPath.moveTo(37.539f, 996.6289f);
generalPath.lineTo(206.42612f, 888.4797f);
generalPath.lineTo(207.45284f, 887.4809f);
generalPath.lineTo(145.5873f, 833.973f);
generalPath.lineTo(144.19548f, 835.3263f);
generalPath.lineTo(37.539f, 996.6289f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(42.617530822753906, 120.64187622070312), 3.406888f, new Point2D.Double(42.617530822753906, 120.64187622070312), new float[] {0.0f,1.0f}, new Color[] {new Color(180, 148, 42, 255),new Color(228, 220, 201, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(9.196771621704102f, 8.667320251464844f, -87.41266632080078f, 75.02301025390625f, 10332.1083984375f, -8542.833984375f));
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
generalPath.moveTo(170.5971f, 866.4894f);
generalPath.curveTo(178.7938f, 873.34644f, 187.1757f, 870.7758f, 190.10568f, 873.22687f);
generalPath.curveTo(190.57916f, 873.6229f, 190.89355f, 874.1638f, 191.11615f, 874.7419f);
generalPath.lineTo(678.45154f, 399.78418f);
generalPath.lineTo(646.23816f, 372.83536f);
generalPath.lineTo(157.97754f, 848.6929f);
generalPath.curveTo(159.44658f, 848.5864f, 160.74944f, 848.668f, 161.67615f, 849.4434f);
generalPath.curveTo(164.35422f, 851.6839f, 162.36243f, 859.6004f, 170.5971f, 866.4894f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(15.727076530456543, 58.08968734741211), 2.6143966f, new Point2D.Double(15.727076530456543, 58.08968734741211), new float[] {0.0f,0.5f,0.75f,1.0f}, new Color[] {new Color(37, 37, 37, 255),new Color(37, 37, 37, 255),new Color(37, 37, 37, 255),new Color(0, 0, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(11.563246726989746f, 9.859902381896973f, -157.19798278808594f, 152.2560577392578f, 9294.6982421875f, -8313.6318359375f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.35348833f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(208.51051f, 855.69446f);
generalPath.lineTo(189.42775f, 874.2563f);
generalPath.curveTo(191.9888f, 876.7878f, 188.47545f, 883.76105f, 193.39815f, 887.87915f);
generalPath.curveTo(198.70326f, 892.3173f, 204.46336f, 887.287f, 207.91092f, 890.1373f);
generalPath.lineTo(227.22495f, 871.35034f);
generalPath.lineTo(208.51051f, 855.69446f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
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
generalPath.moveTo(677.27545f, 398.80038f);
generalPath.lineTo(190.3102f, 873.398f);
generalPath.curveTo(192.88527f, 875.9414f, 190.26428f, 882.0647f, 195.21233f, 886.20386f);
generalPath.curveTo(200.54453f, 890.6648f, 205.42398f, 886.4941f, 208.88905f, 889.35895f);
generalPath.lineTo(696.0856f, 414.53644f);
generalPath.lineTo(677.27545f, 398.80038f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(36.6756477355957, 95.76927947998047), 47.746403f, new Point2D.Double(16.21735382080078, 64.14128112792969), new float[] {0.0f,0.09292036f,0.5043171f,0.91571385f,1.0f}, new Color[] {new Color(154, 118, 0, 255),new Color(227, 173, 0, 255),new Color(255, 205, 44, 255),new Color(227, 173, 0, 255),new Color(185, 141, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.39332500100135803f, 0.33903709053993225f, -7.8988037109375f, 7.491559982299805f, 1161.5958251953125f, -93.01132202148438f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.38604653f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(170.95338f, 840.42755f);
generalPath.lineTo(161.16435f, 849.9494f);
generalPath.lineTo(160.79362f, 850.3018f);
generalPath.curveTo(162.98106f, 852.25494f, 159.78629f, 859.3497f, 166.80576f, 866.3861f);
generalPath.lineTo(167.21483f, 866.7283f);
generalPath.lineTo(170.1294f, 869.1665f);
generalPath.lineTo(170.53847f, 869.5087f);
generalPath.curveTo(178.92255f, 875.35876f, 186.52196f, 871.8255f, 189.45183f, 874.2764f);
generalPath.lineTo(199.81918f, 864.1395f);
generalPath.lineTo(170.95341f, 840.4276f);
generalPath.closePath();
shape = generalPath;
paint = new Color(37, 37, 37, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 0.35348833f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(152.33778f, 824.66724f);
generalPath.lineTo(142.42853f, 833.7775f);
generalPath.curveTo(142.53128f, 833.863f, 141.72244f, 834.6568f, 141.82552f, 834.74304f);
generalPath.curveTo(143.92824f, 836.5021f, 141.0112f, 843.5934f, 144.50827f, 847.7327f);
generalPath.lineTo(144.8662f, 848.03204f);
generalPath.lineTo(146.45126f, 849.35815f);
generalPath.lineTo(146.65587f, 849.5292f);
generalPath.curveTo(151.60767f, 852.5079f, 158.25478f, 848.8015f, 160.79362f, 850.3019f);
generalPath.lineTo(171.05223f, 840.3233f);
generalPath.lineTo(152.33778f, 824.66724f);
generalPath.closePath();
shape = generalPath;
paint = new Color(19, 19, 19, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_11
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(147.49687f, 846.91504f);
generalPath.curveTo(152.65791f, 851.1326f, 158.9441f, 847.1579f, 161.67615f, 849.4434f);
generalPath.lineTo(648.6415f, 374.84586f);
generalPath.lineTo(629.6308f, 358.94217f);
generalPath.lineTo(142.4342f, 833.7648f);
generalPath.curveTo(142.53864f, 833.8515f, 142.6411f, 833.93787f, 142.7458f, 834.0256f);
generalPath.curveTo(144.88184f, 835.8124f, 142.29727f, 842.665f, 147.49687f, 846.91504f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(11.326383590698242, 57.38399887084961), new Point2D.Double(14.493531227111816, 57.38399887084961), new float[] {0.0f,0.09292036f,0.5043171f,0.91571385f,1.0f}, new Color[] {new Color(154, 118, 0, 255),new Color(227, 173, 0, 255),new Color(255, 205, 44, 255),new Color(227, 173, 0, 255),new Color(185, 141, 0, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(6.395705223083496f, 5.366052627563477f, -5.948568344116211f, 5.769400596618652f, 651.8609008789062f, 206.3453369140625f));
g.setPaint(paint);
g.fill(shape);
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
generalPath.moveTo(632.5671f, 356.2256f);
generalPath.lineTo(699.0523f, 411.7594f);
generalPath.lineTo(684.5273f, 425.80685f);
generalPath.lineTo(618.04205f, 370.27307f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
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
generalPath.moveTo(640.9572f, 364.41318f);
generalPath.curveTo(636.3276f, 360.5531f, 543.2291f, 444.28162f, 433.01587f, 551.42615f);
generalPath.curveTo(380.08945f, 602.8789f, 330.2139f, 652.9607f, 294.36133f, 690.65405f);
generalPath.curveTo(258.50876f, 728.3474f, 239.61604f, 750.56464f, 241.83939f, 752.4182f);
generalPath.curveTo(246.46901f, 756.2783f, 339.5675f, 672.54974f, 449.78076f, 565.4052f);
generalPath.curveTo(502.70718f, 513.95245f, 552.5827f, 463.87067f, 588.4353f, 426.17734f);
generalPath.curveTo(624.28784f, 388.48398f, 643.18054f, 366.26675f, 640.9572f, 364.41318f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(34.67763900756836, 7.462276935577393), 47.595196f, new Point2D.Double(34.67763900756836, 7.462276935577393), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 174),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(4.268970012664795f, -4.027903079986572f, -0.17436853051185608f, -0.14969302713871002f, 294.6617126464844f, 699.2108764648438f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_14
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(651.2467f, 369.73947f);
generalPath.curveTo(649.79407f, 368.52402f, 537.8377f, 475.60416f, 400.47577f, 609.58813f);
generalPath.curveTo(263.11343f, 743.5725f, 151.75897f, 854.3116f, 151.05344f, 857.63214f);
generalPath.curveTo(150.34769f, 860.9529f, 260.55484f, 755.6123f, 397.90604f, 621.6802f);
generalPath.curveTo(535.2569f, 487.74832f, 648.3425f, 375.35452f, 651.20636f, 369.92944f);
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(34.67763900756836, 7.462276935577393), 47.595196f, new Point2D.Double(34.67763900756836, 7.462276935577393), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 174),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-5.271042346954346f, 5.112285614013672f, 0.05653519928455353f, 0.04806851968169212f, 583.52099609375f, 436.077392578125f));
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
generalPath.moveTo(598.6383f, 389.14136f);
generalPath.curveTo(589.2468f, 394.43787f, 580.3458f, 403.6702f, 575.5643f, 411.5855f);
generalPath.lineTo(628.9884f, 455.87228f);
generalPath.lineTo(652.0623f, 433.42813f);
generalPath.lineTo(598.6383f, 389.14136f);
generalPath.closePath();
generalPath.moveTo(646.44745f, 428.731f);
generalPath.lineTo(623.3735f, 451.17514f);
generalPath.lineTo(642.0894f, 466.8323f);
generalPath.curveTo(650.2701f, 462.412f, 659.6565f, 453.61646f, 665.1634f, 444.38815f);
generalPath.lineTo(646.44745f, 428.731f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(49.009883880615234, 8.495311737060547), 3.9750404f, new Point2D.Double(47.370887756347656, 6.770169734954834), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(174, 174, 174, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(8.30684757232666f, 6.949287414550781f, -2.902353286743164f, 2.823134660720825f, 238.1449737548828f, 63.41957473754883f));
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
generalPath.moveTo(104.94685f, 956.4285f);
generalPath.curveTo(92.79292f, 955.3542f, 82.34795f, 938.795f, 75.6263f, 933.72876f);
generalPath.lineTo(27.08107f, 1006.0598f);
generalPath.lineTo(104.94685f, 956.4285f);
generalPath.closePath();
shape = generalPath;
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
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
generalPath.moveTo(653.67847f, 369.92987f);
generalPath.lineTo(682.3308f, 393.89966f);
generalPath.lineTo(676.5144f, 399.55737f);
generalPath.lineTo(647.86206f, 375.5876f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(49.01197052001953, 2.6743078231811523), 1.7246193f, new Point2D.Double(49.01197052001953, 2.6743078231811523), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(37, 37, 37, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(8.306856155395508f, 6.949295997619629f, -0.9372174143791199f, 0.9116371870040894f, 261.0417785644531f, 41.14835739135742f));
g.setPaint(paint);
g.fill(shape);
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
generalPath.moveTo(670.83624f, 368.5085f);
generalPath.curveTo(684.6345f, 378.41058f, 694.37445f, 391.94162f, 694.9005f, 393.235f);
generalPath.curveTo(695.42676f, 394.5284f, 682.11523f, 379.35507f, 670.6938f, 372.32797f);
generalPath.curveTo(659.3597f, 365.3545f, 643.3519f, 364.94678f, 642.18396f, 364.10092f);
generalPath.curveTo(641.016f, 363.25507f, 633.1538f, 355.53052f, 640.40753f, 355.91898f);
generalPath.curveTo(647.9946f, 356.3253f, 660.17834f, 360.86722f, 670.83624f, 368.5085f);
generalPath.closePath();
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(48.49856185913086, 0.8115049600601196), new Point2D.Double(48.732723236083984, 2.365726947784424), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 174),new Color(255, 255, 255, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(8.30684757232666f, 6.949287414550781f, -7.703673839569092f, 7.493392467498779f, 278.9335632324219f, 23.744234085083008f));
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
generalPath.moveTo(244.34415f, 833.61896f);
generalPath.curveTo(242.84435f, 835.0763f, 241.99734f, 836.47125f, 241.80292f, 837.8037f);
generalPath.curveTo(241.6085f, 839.13635f, 242.08511f, 840.28314f, 243.23273f, 841.24414f);
generalPath.curveTo(244.3755f, 842.2011f, 245.67625f, 842.5427f, 247.13495f, 842.26904f);
generalPath.curveTo(248.59369f, 841.9951f, 250.07288f, 841.1297f, 251.5726f, 839.6724f);
generalPath.curveTo(253.08095f, 838.2067f, 253.9322f, 836.80774f, 254.12665f, 835.47516f);
generalPath.curveTo(254.321f, 834.1425f, 253.84676f, 832.99786f, 252.70409f, 832.04083f);
generalPath.curveTo(251.55643f, 831.0797f, 250.25328f, 830.7362f, 248.79459f, 831.00995f);
generalPath.curveTo(247.33588f, 831.2837f, 245.85242f, 832.1534f, 244.34415f, 833.61896f);
generalPath.moveTo(242.3091f, 831.9147f);
generalPath.curveTo(245.37675f, 828.9339f, 248.28055f, 827.0183f, 251.02061f, 826.168f);
generalPath.curveTo(253.7606f, 825.3178f, 256.01328f, 825.6319f, 257.77844f, 827.11005f);
generalPath.curveTo(259.53876f, 828.5843f, 260.0506f, 830.58527f, 259.31406f, 833.1133f);
generalPath.curveTo(258.57742f, 835.64136f, 256.67532f, 838.39575f, 253.60764f, 841.37665f);
generalPath.curveTo(250.54854f, 844.34906f, 247.64476f, 846.2647f, 244.89612f, 847.1233f);
generalPath.curveTo(242.1561f, 847.97345f, 239.90593f, 847.6615f, 238.14555f, 846.1873f);
generalPath.curveTo(236.38042f, 844.70917f, 235.8661f, 842.706f, 236.60275f, 840.17804f);
generalPath.curveTo(237.34785f, 837.6417f, 239.24997f, 834.8873f, 242.3091f, 831.9147f);
generalPath.moveTo(271.07535f, 813.965f);
generalPath.lineTo(283.25452f, 812.1859f);
generalPath.lineTo(278.12897f, 817.1665f);
generalPath.lineTo(269.94815f, 818.38574f);
generalPath.lineTo(269.24564f, 825.79846f);
generalPath.lineTo(264.0946f, 830.8037f);
generalPath.lineTo(265.15732f, 819.7156f);
generalPath.lineTo(253.46f, 821.4356f);
generalPath.lineTo(258.5983f, 816.4427f);
generalPath.lineTo(266.2864f, 815.3194f);
generalPath.lineTo(266.94482f, 808.33234f);
generalPath.lineTo(272.1087f, 803.3146f);
generalPath.lineTo(271.07535f, 813.965f);
generalPath.moveTo(272.6455f, 802.7929f);
generalPath.lineTo(278.02667f, 797.564f);
generalPath.lineTo(286.25293f, 796.5908f);
generalPath.lineTo(286.71826f, 789.1183f);
generalPath.lineTo(292.11218f, 783.877f);
generalPath.lineTo(291.14148f, 796.2217f);
generalPath.lineTo(295.72958f, 800.06384f);
generalPath.lineTo(290.80847f, 804.8457f);
generalPath.lineTo(286.2205f, 801.0034f);
generalPath.lineTo(272.6455f, 802.7929f);
generalPath.moveTo(321.45496f, 773.6016f);
generalPath.curveTo(320.5682f, 775.079f, 319.5496f, 776.5306f, 318.39902f, 777.95654f);
generalPath.curveTo(317.24844f, 779.3825f, 315.97012f, 780.7786f, 314.56415f, 782.1448f);
generalPath.curveTo(311.3857f, 785.2333f, 308.362f, 787.25653f, 305.4929f, 788.2146f);
generalPath.curveTo(302.619f, 789.16864f, 300.31403f, 788.9186f, 298.578f, 787.4649f);
generalPath.curveTo(296.82245f, 785.99475f, 296.38733f, 783.9191f, 297.27246f, 781.2381f);
generalPath.curveTo(298.1576f, 778.5568f, 300.24478f, 775.6183f, 303.5339f, 772.4222f);
generalPath.curveTo(304.80362f, 771.1884f, 306.08597f, 770.0654f, 307.381f, 769.0534f);
generalPath.curveTo(308.68457f, 768.033f, 309.98557f, 767.13403f, 311.2841f, 766.35596f);
generalPath.lineTo(313.53802f, 768.2436f);
generalPath.curveTo(312.1276f, 768.9894f, 310.80896f, 769.80444f, 309.58215f, 770.6886f);
generalPath.curveTo(308.36386f, 771.56445f, 307.2263f, 772.5159f, 306.16974f, 773.5426f);
generalPath.curveTo(304.20984f, 775.447f, 303.01102f, 777.1794f, 302.57315f, 778.73975f);
generalPath.curveTo(302.13895f, 780.2878f, 302.50302f, 781.54846f, 303.66516f, 782.5216f);
generalPath.curveTo(304.8176f, 783.4868f, 306.21887f, 783.73517f, 307.8687f, 783.26685f);
generalPath.curveTo(309.51852f, 782.7986f, 311.28494f, 781.64954f, 313.1682f, 779.8195f);
generalPath.curveTo(313.6794f, 779.3228f, 314.1353f, 778.84906f, 314.5359f, 778.39813f);
generalPath.curveTo(314.9401f, 777.93506f, 315.27805f, 777.50116f, 315.5495f, 777.0965f);
generalPath.lineTo(313.43427f, 775.325f);
generalPath.lineTo(310.43045f, 778.24384f);
generalPath.lineTo(308.54865f, 776.6679f);
generalPath.lineTo(316.21774f, 769.2158f);
generalPath.lineTo(321.45496f, 773.6016f);
generalPath.moveTo(315.69464f, 760.96185f);
generalPath.lineTo(328.97495f, 748.05725f);
generalPath.lineTo(331.0975f, 749.8347f);
generalPath.lineTo(322.7382f, 757.9575f);
generalPath.lineTo(324.766f, 759.65564f);
generalPath.lineTo(332.62683f, 752.0173f);
generalPath.lineTo(334.74942f, 753.7948f);
generalPath.lineTo(326.88858f, 761.43317f);
generalPath.lineTo(329.38324f, 763.5223f);
generalPath.lineTo(338.02374f, 755.1263f);
generalPath.lineTo(340.14636f, 756.9038f);
generalPath.lineTo(326.5848f, 770.08167f);
generalPath.lineTo(315.69464f, 760.96185f);
generalPath.moveTo(333.5892f, 743.57355f);
generalPath.lineTo(339.0854f, 738.23285f);
generalPath.lineTo(353.49512f, 737.74365f);
generalPath.lineTo(346.0259f, 731.4887f);
generalPath.lineTo(350.69128f, 726.9554f);
generalPath.lineTo(361.58145f, 736.0752f);
generalPath.lineTo(356.08527f, 741.4159f);
generalPath.lineTo(341.67548f, 741.905f);
generalPath.lineTo(349.14474f, 748.16003f);
generalPath.lineTo(344.47937f, 752.69336f);
generalPath.lineTo(333.5892f, 743.5736f);
generalPath.moveTo(364.57233f, 713.4671f);
generalPath.lineTo(370.0685f, 708.1265f);
generalPath.lineTo(384.47824f, 707.6372f);
generalPath.lineTo(377.00903f, 701.3823f);
generalPath.lineTo(381.67438f, 696.84894f);
generalPath.lineTo(392.56454f, 705.96875f);
generalPath.lineTo(387.0684f, 711.30945f);
generalPath.lineTo(372.6586f, 711.7985f);
generalPath.lineTo(380.12784f, 718.0536f);
generalPath.lineTo(375.46252f, 722.5869f);
generalPath.lineTo(364.57233f, 713.4671f);
generalPath.moveTo(391.24274f, 687.195f);
generalPath.curveTo(393.0578f, 685.4314f, 394.7592f, 684.2663f, 396.34705f, 683.6998f);
generalPath.curveTo(397.9435f, 683.1252f, 399.2036f, 683.2246f, 400.12756f, 683.99835f);
generalPath.curveTo(401.05145f, 684.7721f, 401.25684f, 685.89215f, 400.74365f, 687.3585f);
generalPath.curveTo(400.23044f, 688.825f, 399.0621f, 690.44415f, 397.23853f, 692.21606f);
generalPath.curveTo(395.415f, 693.98804f, 393.70746f, 695.1634f, 392.1159f, 695.7421f);
generalPath.curveTo(390.5329f, 696.3126f, 389.2794f, 696.21106f, 388.3555f, 695.4374f);
generalPath.curveTo(387.43155f, 694.66364f, 387.22382f, 693.5415f, 387.73212f, 692.071f);
generalPath.curveTo(388.249f, 690.5923f, 389.41925f, 688.967f, 391.24274f, 687.195f);
generalPath.moveTo(392.88425f, 698.09674f);
generalPath.lineTo(403.40366f, 687.875f);
generalPath.lineTo(404.86246f, 689.0966f);
generalPath.lineTo(394.34302f, 699.3184f);
generalPath.lineTo(392.88425f, 698.09674f);
generalPath.moveTo(392.48276f, 688.2334f);
generalPath.curveTo(391.76703f, 688.929f, 391.36633f, 689.59546f, 391.28067f, 690.23285f);
generalPath.curveTo(391.20355f, 690.86206f, 391.44708f, 691.4128f, 392.01114f, 691.8852f);
generalPath.curveTo(392.5752f, 692.3576f, 393.19974f, 692.5337f, 393.8847f, 692.4136f);
generalPath.curveTo(394.57816f, 692.2852f, 395.2828f, 691.8732f, 395.99854f, 691.1776f);
generalPath.curveTo(396.70584f, 690.4904f, 397.10043f, 689.8343f, 397.1824f, 689.20917f);
generalPath.curveTo(397.27283f, 688.5758f, 397.03604f, 688.0229f, 396.472f, 687.55054f);
generalPath.curveTo(395.90793f, 687.0781f, 395.2767f, 686.9041f, 394.57837f, 687.02844f);
generalPath.curveTo(393.88858f, 687.1446f, 393.19006f, 687.54626f, 392.48276f, 688.2334f);
generalPath.moveTo(425.08936f, 663.7413f);
generalPath.curveTo(426.5657f, 662.64984f, 427.87207f, 661.9787f, 429.00836f, 661.72784f);
generalPath.curveTo(430.14838f, 661.46466f, 431.08066f, 661.63654f, 431.80524f, 662.2432f);
generalPath.curveTo(432.88474f, 663.1472f, 432.98224f, 664.53925f, 432.0977f, 666.41925f);
generalPath.curveTo(431.2083f, 668.29517f, 429.37463f, 670.5828f, 426.59674f, 673.2821f);
generalPath.curveTo(425.6168f, 674.2343f, 424.58646f, 675.15204f, 423.50555f, 676.0351f);
generalPath.curveTo(422.4381f, 676.91406f, 421.33295f, 677.746f, 420.1902f, 678.531f);
generalPath.lineTo(418.02377f, 676.71674f);
generalPath.curveTo(419.20667f, 676.0425f, 420.31778f, 675.3234f, 421.35718f, 674.55975f);
generalPath.curveTo(422.40024f, 673.7837f, 423.36066f, 672.9693f, 424.23834f, 672.11646f);
generalPath.curveTo(425.54205f, 670.8496f, 426.41022f, 669.7729f, 426.8427f, 668.88635f);
generalPath.curveTo(427.2837f, 667.9916f, 427.2635f, 667.3426f, 426.7821f, 666.9394f);
generalPath.curveTo(426.2861f, 666.52405f, 425.55377f, 666.5582f, 424.58514f, 667.04205f);
generalPath.curveTo(423.62015f, 667.5135f, 422.44318f, 668.4241f, 421.05423f, 669.7737f);
generalPath.lineTo(419.08585f, 671.6864f);
generalPath.lineTo(417.2769f, 670.1716f);
generalPath.lineTo(419.34756f, 668.1595f);
generalPath.curveTo(420.58313f, 666.95886f, 421.39398f, 665.973f, 421.78015f, 665.20184f);
generalPath.curveTo(422.16147f, 664.42664f, 422.126f, 663.8497f, 421.67392f, 663.471f);
generalPath.curveTo(421.25565f, 663.1207f, 420.63837f, 663.1356f, 419.8218f, 663.5154f);
generalPath.curveTo(419.0053f, 663.8954f, 418.0602f, 664.607f, 416.9865f, 665.6502f);
generalPath.curveTo(416.1941f, 666.42035f, 415.44415f, 667.24146f, 414.73672f, 668.11346f);
generalPath.curveTo(414.02933f, 668.98566f, 413.37482f, 669.89435f, 412.7732f, 670.8396f);
generalPath.lineTo(410.71628f, 669.11707f);
generalPath.curveTo(411.53207f, 668.04285f, 412.37823f, 667.00946f, 413.25482f, 666.0169f);
generalPath.curveTo(414.13138f, 665.0244f, 415.02985f, 664.08105f, 415.95013f, 663.18677f);
generalPath.curveTo(418.4298f, 660.77734f, 420.5165f, 659.17175f, 422.21045f, 658.37036f);
generalPath.curveTo(423.90796f, 657.55664f, 425.22354f, 657.5407f, 426.15723f, 658.3227f);
generalPath.curveTo(426.79425f, 658.8562f, 427.02304f, 659.57965f, 426.84357f, 660.49304f);
generalPath.curveTo(426.65912f, 661.4023f, 426.07446f, 662.4851f, 425.08945f, 663.74133f);
shape = generalPath;
paint = new LinearGradientPaint(new Point2D.Double(49.15303039550781, 75.31031799316406), new Point2D.Double(82.4846420288086, 75.31031799316406), new float[] {0.0f,1.0f}, new Color[] {new Color(180, 148, 42, 255),new Color(228, 220, 201, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(5.892839431762695f, 0.0f, 0.0f, 5.296410083770752f, -53.37351989746094f, 353.7945251464844f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_20
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(634.4209f, 354.7007f);
generalPath.lineTo(652.8153f, 372.2737f);
generalPath.lineTo(648.247f, 375.54333f);
generalPath.lineTo(629.8526f, 357.97034f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(49.01197052001953, 2.6743078231811523), 1.7246193f, new Point2D.Double(49.01197052001953, 2.6743078231811523), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(37, 37, 37, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(5.332891941070557f, 5.094748497009277f, -0.7360979914665222f, 0.5268394351005554f, 382.37823486328125f, 113.68681335449219f));
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_21
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(701.94495f, 410.34937f);
generalPath.lineTo(681.9949f, 394.20557f);
generalPath.lineTo(678.458f, 398.38214f);
generalPath.lineTo(698.4081f, 414.5259f);
generalPath.closePath();
shape = generalPath;
paint = new RadialGradientPaint(new Point2D.Double(49.01197052001953, 2.6743078231811523), 1.7246193f, new Point2D.Double(49.01197052001953, 2.6743078231811523), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(37, 37, 37, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(-5.783918380737305f, -4.680389881134033f, -0.5699030756950378f, 0.6729775667190552f, 975.5557250976562f, 631.5484619140625f));
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
        return 0.9729966521263123;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static double getOrigY() {
        return 9.792383193969727;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static double getOrigWidth() {
		return 754.9325561523438;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 726.094970703125;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private writeModel() {
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
       writeModel base = new writeModel();
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
       writeModel base = new writeModel();
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
        return writeModel::new;
    }
}

