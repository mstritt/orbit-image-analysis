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
public class Groovy_logo implements ResizableIcon {
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
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -35.39659881591797f, 279.904052734375f));
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
generalPath.moveTo(154.97687f, 331.20258f);
generalPath.curveTo(154.97687f, 329.57773f, 165.8081f, 293.656f, 179.04626f, 251.37656f);
generalPath.curveTo(192.28445f, 209.0971f, 201.70683f, 173.50655f, 199.98494f, 172.28648f);
generalPath.curveTo(198.26303f, 171.06644f, 192.30502f, 173.26572f, 186.74492f, 177.1738f);
generalPath.curveTo(169.99968f, 188.94368f, 166.55887f, 185.82394f, 154.05183f, 147.53137f);
generalPath.curveTo(140.5192f, 106.09873f, 140.0346f, 101.82267f, 147.09026f, 86.102936f);
generalPath.curveTo(151.69902f, 75.83491f, 151.42184f, 73.44137f, 143.85835f, 58.19126f);
generalPath.curveTo(139.30827f, 49.01699f, 135.58546f, 38.7481f, 135.58546f, 35.371502f);
generalPath.curveTo(135.58546f, 29.692066f, 104.59402f, 3.9390638f, 55.595974f, -31.09745f);
generalPath.curveTo(44.486313f, -39.04153f, 35.3966f, -46.883465f, 35.3966f, -48.523968f);
generalPath.curveTo(35.3966f, -50.16453f, 58.867336f, -50.549843f, 87.55379f, -49.38026f);
generalPath.lineTo(139.711f, -47.253773f);
generalPath.lineTo(144.80228f, -63.44451f);
generalPath.curveTo(166.31871f, -131.86879f, 198.81178f, -193.67236f, 213.26932f, -193.67236f);
generalPath.curveTo(216.27992f, -193.67236f, 222.39073f, -187.88728f, 226.84885f, -180.81667f);
generalPath.curveTo(234.1083f, -169.30315f, 235.10535f, -162.16885f, 236.39879f, -112.48102f);
generalPath.curveTo(237.19308f, -81.96702f, 238.82301f, -55.025116f, 240.02077f, -52.610058f);
generalPath.curveTo(241.21852f, -50.19504f, 245.01846f, -53.36465f, 248.46507f, -59.653706f);
generalPath.curveTo(252.86649f, -67.685005f, 257.4999f, -69.86239f, 264.03268f, -66.96937f);
generalPath.curveTo(270.80026f, -63.972355f, 274.6598f, -66.023834f, 278.20206f, -74.50104f);
generalPath.curveTo(283.51566f, -87.217026f, 310.10803f, -173.17207f, 310.10803f, -177.63116f);
generalPath.curveTo(310.10803f, -179.14659f, 315.3731f, -197.30463f, 321.80826f, -217.98238f);
generalPath.curveTo(328.24335f, -238.6601f, 335.6549f, -262.50308f, 338.27832f, -270.9667f);
generalPath.curveTo(342.9439f, -286.01862f, 343.67493f, -284.23734f, 371.70526f, -189.5116f);
generalPath.curveTo(400.64645f, -91.70762f, 416.22293f, -55.61746f, 424.02094f, -68.297676f);
generalPath.curveTo(429.46295f, -77.146904f, 458.0215f, -77.649055f, 466.00342f, -69.03592f);
generalPath.curveTo(470.54007f, -64.14053f, 473.42258f, -64.20471f, 475.92825f, -69.25694f);
generalPath.curveTo(481.12833f, -79.741714f, 493.57806f, -77.91559f, 496.83237f, -66.19062f);
generalPath.curveTo(499.3963f, -56.95312f, 500.0502f, -56.95312f, 503.8525f, -66.19062f);
generalPath.curveTo(506.15857f, -71.7932f, 512.9887f, -76.37703f, 519.0305f, -76.37703f);
generalPath.curveTo(527.5694f, -76.37703f, 530.8239f, -72.80081f, 533.6446f, -60.318634f);
generalPath.lineTo(537.2734f, -44.260265f);
generalPath.lineTo(593.3654f, -48.26419f);
generalPath.curveTo(624.216f, -50.46641f, 649.45746f, -50.8589f, 649.45746f, -49.136333f);
generalPath.curveTo(649.45746f, -47.413887f, 626.5514f, -28.828472f, 598.55505f, -7.8354607f);
generalPath.curveTo(570.5587f, 13.157471f, 547.18805f, 30.963896f, 546.6202f, 31.734255f);
generalPath.curveTo(546.05237f, 32.504616f, 547.31866f, 50.874245f, 549.43427f, 72.555595f);
generalPath.curveTo(554.93884f, 128.9694f, 551.3488f, 166.56639f, 537.50793f, 197.45609f);
generalPath.curveTo(531.29895f, 211.31322f, 521.2246f, 225.97423f, 515.1204f, 230.03612f);
generalPath.curveTo(509.01627f, 234.09798f, 504.022f, 238.87979f, 504.022f, 240.66228f);
generalPath.curveTo(504.022f, 242.4448f, 510.53723f, 264.21027f, 518.50037f, 289.02997f);
generalPath.curveTo(526.46344f, 313.84973f, 531.78314f, 334.1568f, 530.32184f, 334.1568f);
generalPath.curveTo(527.9368f, 334.1568f, 469.852f, 288.9067f, 379.53287f, 216.687f);
generalPath.curveTo(361.72388f, 202.44685f, 345.50604f, 190.79578f, 343.49326f, 190.79578f);
generalPath.curveTo(339.73965f, 190.79578f, 307.32635f, 215.56903f, 212.26904f, 291.08963f);
generalPath.curveTo(157.14378f, 334.88528f, 154.97687f, 336.40244f, 154.97687f, 331.2025f);
generalPath.closePath();
generalPath.moveTo(268.09335f, 227.86295f);
generalPath.curveTo(297.42285f, 204.88731f, 326.50992f, 182.43457f, 332.73132f, 177.96796f);
generalPath.curveTo(343.432f, 170.28555f, 347.0105f, 172.21162f, 398.98526f, 213.62856f);
generalPath.curveTo(429.20352f, 237.70845f, 459.0178f, 261.1641f, 465.2392f, 265.75208f);
generalPath.curveTo(471.4606f, 270.34015f, 484.28235f, 280.3108f, 493.73193f, 287.90912f);
generalPath.curveTo(504.50696f, 296.57315f, 510.01443f, 298.65924f, 508.50302f, 293.50397f);
generalPath.curveTo(491.61932f, 235.91676f, 491.1032f, 234.95695f, 479.4022f, 239.3829f);
generalPath.curveTo(465.28857f, 244.72147f, 456.52322f, 239.2448f, 452.0185f, 222.2737f);
generalPath.curveTo(449.09738f, 211.26852f, 449.98907f, 205.88622f, 457.27292f, 190.557f);
generalPath.curveTo(468.1218f, 167.72513f, 466.41748f, 146.7202f, 452.42862f, 130.853f);
generalPath.curveTo(447.061f, 124.76466f, 440.28802f, 109.71489f, 437.37762f, 97.409035f);
generalPath.lineTo(432.0859f, 75.03475f);
generalPath.lineTo(420.74042f, 90.55865f);
generalPath.curveTo(406.79584f, 109.63877f, 389.7898f, 110.62189f, 375.59277f, 93.16868f);
generalPath.lineTo(365.1279f, 80.30351f);
generalPath.lineTo(352.96948f, 96.9637f);
generalPath.curveTo(340.79486f, 113.64611f, 326.7784f, 115.80139f, 312.53195f, 103.18174f);
generalPath.curveTo(308.607f, 99.70489f, 306.87613f, 101.05628f, 306.87613f, 107.59755f);
generalPath.curveTo(306.87613f, 112.78176f, 303.17184f, 120.42643f, 298.64432f, 124.58577f);
generalPath.curveTo(285.07013f, 137.05605f, 271.82324f, 133.74466f, 262.84204f, 115.63602f);
generalPath.lineTo(254.65259f, 99.12382f);
generalPath.lineTo(248.04277f, 116.06667f);
generalPath.curveTo(244.40738f, 125.38523f, 235.99326f, 139.93332f, 229.34473f, 148.39565f);
generalPath.curveTo(221.11507f, 158.87057f, 210.9273f, 184.43022f, 197.42831f, 228.46936f);
generalPath.curveTo(186.52283f, 264.04752f, 177.60016f, 294.96707f, 177.60016f, 297.17963f);
generalPath.curveTo(177.60016f, 299.3921f, 185.9627f, 294.10004f, 196.18358f, 285.4195f);
generalPath.curveTo(206.40446f, 276.73898f, 238.76385f, 250.83856f, 268.09335f, 227.86295f);
generalPath.closePath();
generalPath.moveTo(516.86066f, 203.14647f);
generalPath.curveTo(539.1162f, 177.9262f, 544.2749f, 131.27f, 534.4375f, 44.17663f);
generalPath.curveTo(526.21606f, -28.61025f, 522.112f, -52.429882f, 517.24255f, -55.621048f);
generalPath.curveTo(513.87354f, -57.828934f, 513.35583f, -55.405327f, 515.25397f, -46.313198f);
generalPath.curveTo(527.56915f, 12.678504f, 528.2536f, 42.295444f, 517.4942f, 50.620235f);
generalPath.curveTo(510.1027f, 56.33925f, 502.2618f, 34.91191f, 496.09518f, -7.858426f);
generalPath.curveTo(491.32004f, -40.977562f, 486.32657f, -55.903065f, 482.5613f, -48.31125f);
generalPath.curveTo(481.65973f, -46.493374f, 483.23978f, -35.969265f, 486.07254f, -24.92417f);
generalPath.curveTo(488.90527f, -13.879196f, 492.78976f, 19.38265f, 494.7047f, 48.991f);
generalPath.curveTo(496.6197f, 78.59929f, 500.31857f, 109.60181f, 502.92444f, 117.88548f);
generalPath.curveTo(509.6964f, 139.4125f, 520.4757f, 134.2246f, 527.44824f, 106.0825f);
generalPath.curveTo(534.342f, 78.258354f, 535.1211f, 96.79187f, 528.41754f, 129.14072f);
generalPath.curveTo(521.45685f, 162.73064f, 500.78314f, 172.80284f, 476.83337f, 154.27245f);
generalPath.curveTo(473.0001f, 151.30658f, 471.703f, 154.3763f, 471.703f, 166.41241f);
generalPath.curveTo(471.703f, 175.27257f, 468.7668f, 190.04814f, 465.1781f, 199.2469f);
generalPath.lineTo(458.65323f, 215.97206f);
generalPath.lineTo(467.60205f, 219.01912f);
generalPath.curveTo(483.05148f, 224.27977f, 504.23532f, 217.45364f, 516.86066f, 203.14647f);
generalPath.closePath();
generalPath.moveTo(196.49414f, 147.62354f);
generalPath.curveTo(242.9538f, 120.69714f, 251.25603f, 89.29071f, 235.82298f, -1.1532906f);
generalPath.curveTo(232.24113f, -22.144346f, 229.31056f, -44.72449f, 229.31056f, -51.331493f);
generalPath.curveTo(229.31056f, -73.82736f, 223.69904f, -63.432415f, 219.49342f, -33.14581f);
generalPath.curveTo(213.9314f, 6.9088006f, 197.20229f, 40.953506f, 183.14827f, 40.81864f);
generalPath.curveTo(170.9428f, 40.70129f, 166.96576f, 36.221363f, 161.92448f, 16.91025f);
generalPath.curveTo(152.87701f, -17.747206f, 162.73918f, -70.93493f, 187.89403f, -123.14597f);
generalPath.curveTo(206.31834f, -161.38731f, 216.38297f, -164.85062f, 216.38297f, -132.9492f);
generalPath.curveTo(216.38297f, -83.201164f, 199.37161f, -9.966888f, 190.40987f, -21.134373f);
generalPath.curveTo(186.02782f, -26.594978f, 186.7385f, -50.708183f, 191.82709f, -69.2228f);
generalPath.curveTo(196.15443f, -84.96757f, 195.27522f, -108.95905f, 190.3709f, -108.95905f);
generalPath.curveTo(184.684f, -108.95905f, 173.42542f, -67.19796f, 171.93771f, -40.585537f);
generalPath.curveTo(170.62256f, -17.05907f, 171.44485f, -11.338504f, 177.00423f, -5.339529f);
generalPath.curveTo(196.48666f, 15.683606f, 222.00954f, -48.47872f, 223.29506f, -121.71076f);
generalPath.curveTo(223.9701f, -160.1676f, 220.2783f, -170.99084f, 208.516f, -165.03848f);
generalPath.curveTo(191.39722f, -156.37544f, 145.28117f, -36.42682f, 145.28117f, -0.5636298f);
generalPath.curveTo(145.28117f, 27.488455f, 152.26854f, 47.216694f, 164.56944f, 53.895256f);
generalPath.curveTo(185.48363f, 65.250175f, 205.70483f, 45.076275f, 220.03275f, -1.4382513f);
generalPath.lineTo(226.05449f, -20.987507f);
generalPath.lineTo(226.06769f, 5.5713825f);
generalPath.curveTo(226.0839f, 44.029484f, 213.6415f, 64.30035f, 174.36952f, 89.78718f);
generalPath.curveTo(164.59303f, 96.132f, 156.1862f, 101.99455f, 155.68771f, 102.8151f);
generalPath.curveTo(153.86716f, 105.81194f, 172.3751f, 158.21379f, 175.25417f, 158.21379f);
generalPath.curveTo(176.88678f, 158.21379f, 186.44531f, 153.44814f, 196.49539f, 147.62354f);
generalPath.closePath();
generalPath.moveTo(476.411f, 99.87771f);
generalPath.curveTo(481.07446f, 89.48762f, 481.8965f, 78.20063f, 480.8968f, 38.283955f);
generalPath.curveTo(479.8094f, -5.1332035f, 478.61932f, -12.805548f, 470.23535f, -30.449965f);
generalPath.curveTo(455.08655f, -62.331245f, 436.3741f, -54.19826f, 447.32718f, -20.493298f);
generalPath.curveTo(453.14972f, -2.5758963f, 460.25256f, -5.636063f, 457.7436f, -24.98115f);
generalPath.curveTo(455.74493f, -40.391087f, 459.47357f, -40.795994f, 465.972f, -25.874805f);
generalPath.curveTo(478.16498f, 2.121973f, 475.0873f, 40.918427f, 460.67337f, 40.918427f);
generalPath.curveTo(450.8062f, 40.918427f, 447.7314f, 32.386017f, 441.29984f, -12.841981f);
generalPath.curveTo(438.36926f, -33.450108f, 434.8002f, -50.31136f, 433.36856f, -50.31136f);
generalPath.curveTo(428.59958f, -50.31136f, 426.4757f, -41.825287f, 429.44135f, -34.61987f);
generalPath.curveTo(431.05225f, -30.706072f, 435.51355f, -2.5786383f, 439.3554f, 27.885601f);
generalPath.curveTo(449.02444f, 104.55654f, 462.53207f, 130.7994f, 476.411f, 99.87771f);
generalPath.closePath();
generalPath.moveTo(292.63974f, 101.09544f);
generalPath.curveTo(294.62952f, 98.40371f, 295.5395f, 85.673065f, 294.7184f, 72.01465f);
generalPath.curveTo(293.39392f, 49.982727f, 292.6518f, 48.37559f, 286.7457f, 54.748707f);
generalPath.curveTo(278.25836f, 63.90719f, 269.1373f, 46.55554f, 266.0435f, 15.365538f);
generalPath.curveTo(263.6964f, -8.296261f, 262.9782f, -7.8315287f, 280.06924f, 6.2892785f);
generalPath.curveTo(282.21213f, 8.059732f, 287.66595f, 2.0469875f, 292.18887f, -7.07248f);
generalPath.curveTo(300.46295f, -23.755333f, 303.1869f, -43.79495f, 297.18042f, -43.79495f);
generalPath.curveTo(295.4029f, -43.79495f, 293.94852f, -40.862553f, 293.94852f, -37.278534f);
generalPath.curveTo(293.94852f, -27.90439f, 285.10623f, -29.233946f, 283.1139f, -38.907627f);
generalPath.curveTo(281.95163f, -44.55077f, 279.4758f, -42.548847f, 275.05472f, -32.391216f);
generalPath.curveTo(271.5449f, -24.32715f, 267.258f, -17.72928f, 265.52832f, -17.72928f);
generalPath.curveTo(263.79865f, -17.72928f, 261.4627f, -24.32715f, 260.33743f, -32.391216f);
generalPath.curveTo(258.36548f, -46.522427f, 258.12378f, -46.61157f, 253.66006f, -34.854485f);
generalPath.curveTo(249.74947f, -24.554243f, 249.7145f, -21.273172f, 253.43546f, -13.771043f);
generalPath.curveTo(257.37607f, -5.8256135f, 264.8616f, 48.47354f, 264.8616f, 69.11302f);
generalPath.curveTo(264.8616f, 94.77757f, 282.39093f, 114.95982f, 292.63992f, 101.09544f);
generalPath.closePath();
generalPath.moveTo(351.58286f, 67.07011f);
generalPath.curveTo(363.72852f, 42.58105f, 367.32736f, 5.873159f, 360.71228f, -26.048851f);
generalPath.curveTo(355.5421f, -50.998222f, 346.5676f, -60.335995f, 333.91348f, -53.932335f);
generalPath.curveTo(324.51086f, -49.174095f, 310.19037f, 6.1055756f, 310.13962f, 37.839325f);
generalPath.curveTo(310.06042f, 87.29667f, 333.39014f, 103.75158f, 351.58286f, 67.07011f);
generalPath.closePath();
generalPath.moveTo(329.49942f, 27.885601f);
generalPath.curveTo(325.94434f, 20.717527f, 323.08188f, 6.788711f, 323.1384f, -3.0673642f);
generalPath.curveTo(323.2318f, -19.358192f, 323.63156f, -19.950674f, 327.5346f, -9.583776f);
generalPath.curveTo(332.35925f, 3.2310674f, 340.93256f, 5.45093f, 344.217f, -5.2642612f);
generalPath.curveTo(345.41132f, -9.160539f, 344.76996f, -15.611845f, 342.7918f, -19.600348f);
generalPath.curveTo(337.71048f, -29.845705f, 338.3262f, -43.79495f, 343.85974f, -43.79495f);
generalPath.curveTo(350.0111f, -43.79495f, 358.58652f, -18.561682f, 358.58652f, -0.4612633f);
generalPath.curveTo(358.58652f, 12.859767f, 345.14212f, 40.918427f, 338.75928f, 40.918427f);
generalPath.curveTo(337.22144f, 40.918427f, 333.05453f, 35.053635f, 329.49942f, 27.885601f);
generalPath.closePath();
generalPath.moveTo(415.8484f, 65.354935f);
generalPath.curveTo(429.25912f, 35.911964f, 427.95215f, -9.444975f, 412.75015f, -42.165836f);
generalPath.curveTo(404.89957f, -59.06346f, 387.45718f, -61.97682f, 380.3183f, -47.58285f);
generalPath.curveTo(373.73068f, -34.300392f, 367.15366f, 17.93216f, 369.59708f, 37.5614f);
generalPath.curveTo(374.8083f, 79.425766f, 401.9975f, 95.76436f, 415.8484f, 65.354935f);
generalPath.closePath();
generalPath.moveTo(388.39276f, 17.74148f);
generalPath.curveTo(383.08652f, 10.247698f, 381.26334f, 1.309332f, 381.4147f, -16.469671f);
generalPath.curveTo(381.58405f, -36.350845f, 382.099f, -38.144287f, 384.37613f, -26.781223f);
generalPath.curveTo(387.72186f, -10.085789f, 394.73907f, -3.7808447f, 400.8943f, -11.939596f);
generalPath.curveTo(404.71182f, -16.99971f, 404.53357f, -19.391703f, 399.79324f, -26.717045f);
generalPath.curveTo(393.47134f, -36.48638f, 392.23816f, -50.31136f, 397.6886f, -50.31136f);
generalPath.curveTo(402.56223f, -50.31136f, 419.9926f, -11.867656f, 419.9926f, -1.1186308f);
generalPath.curveTo(419.9926f, 9.372391f, 407.61523f, 27.885601f, 400.60123f, 27.885601f);
generalPath.curveTo(397.83716f, 27.885601f, 392.34332f, 23.320705f, 388.39276f, 17.74148f);
generalPath.closePath();
generalPath.moveTo(578.35565f, -11.068866f);
generalPath.lineTo(612.29065f, -36.749847f);
generalPath.lineTo(575.93176f, -37.014484f);
generalPath.curveTo(543.3925f, -37.251114f, 539.5775f, -36.080807f, 539.617f, -25.875048f);
generalPath.curveTo(539.6571f, -15.536436f, 542.9477f, 15.023053f, 543.9897f, 14.732144f);
generalPath.curveTo(544.2269f, 14.665809f, 559.69147f, 3.0553892f, 578.35565f, -11.069128f);
generalPath.closePath();
generalPath.moveTo(134.86224f, -15.66457f);
generalPath.lineTo(138.33049f, -36.40726f);
generalPath.lineTo(107.86363f, -38.47201f);
generalPath.curveTo(91.10689f, -39.60762f, 77.40005f, -38.738422f, 77.40405f, -36.540337f);
generalPath.curveTo(77.40985f, -33.32411f, 129.91061f, 8.033683f, 131.0658f, 5.7319994f);
generalPath.curveTo(131.24614f, 5.3722954f, 132.95471f, -4.2560816f, 134.86224f, -15.66457f);
generalPath.closePath();
generalPath.moveTo(343.77145f, -79.95756f);
generalPath.curveTo(350.9381f, -77.6469f, 359.02124f, -71.732666f, 361.734f, -66.81474f);
generalPath.curveTo(365.94678f, -59.17742f, 367.77927f, -59.697964f, 374.29608f, -70.383255f);
generalPath.curveTo(378.4925f, -77.2638f, 383.94632f, -82.893394f, 386.4157f, -82.893394f);
generalPath.curveTo(388.8851f, -82.893394f, 390.90552f, -84.33116f, 390.90552f, -86.08853f);
generalPath.curveTo(390.90552f, -92.15588f, 344.36597f, -245.80305f, 342.59106f, -245.59557f);
generalPath.curveTo(340.50604f, -245.35185f, 292.80502f, -84.11587f, 291.3364f, -72.348076f);
generalPath.curveTo(290.72006f, -67.409164f, 292.65445f, -65.58606f, 296.41006f, -67.56627f);
generalPath.curveTo(299.7484f, -69.326485f, 304.3642f, -66.18863f, 306.66733f, -60.59325f);
generalPath.curveTo(310.4027f, -51.518246f, 311.9284f, -52.24124f, 320.798f, -67.28925f);
generalPath.curveTo(329.22446f, -81.585495f, 332.7288f, -83.517876f, 343.77145f, -79.95756f);
generalPath.closePath();
shape = generalPath;
paint = new Color(51, 51, 51, 255);
g.setPaint(paint);
g.fill(shape);
paint = new Color(255, 255, 255, 255);
stroke = new BasicStroke(1.0f,0,0,4.0f,null,0.0f);
if (generalPath == null) {
   generalPath = new GeneralPath();
} else {
   generalPath.reset();
}
generalPath.moveTo(154.97687f, 331.20258f);
generalPath.curveTo(154.97687f, 329.57773f, 165.8081f, 293.656f, 179.04626f, 251.37656f);
generalPath.curveTo(192.28445f, 209.0971f, 201.70683f, 173.50655f, 199.98494f, 172.28648f);
generalPath.curveTo(198.26303f, 171.06644f, 192.30502f, 173.26572f, 186.74492f, 177.1738f);
generalPath.curveTo(169.99968f, 188.94368f, 166.55887f, 185.82394f, 154.05183f, 147.53137f);
generalPath.curveTo(140.5192f, 106.09873f, 140.0346f, 101.82267f, 147.09026f, 86.102936f);
generalPath.curveTo(151.69902f, 75.83491f, 151.42184f, 73.44137f, 143.85835f, 58.19126f);
generalPath.curveTo(139.30827f, 49.01699f, 135.58546f, 38.7481f, 135.58546f, 35.371502f);
generalPath.curveTo(135.58546f, 29.692066f, 104.59402f, 3.9390638f, 55.595974f, -31.09745f);
generalPath.curveTo(44.486313f, -39.04153f, 35.3966f, -46.883465f, 35.3966f, -48.523968f);
generalPath.curveTo(35.3966f, -50.16453f, 58.867336f, -50.549843f, 87.55379f, -49.38026f);
generalPath.lineTo(139.711f, -47.253773f);
generalPath.lineTo(144.80228f, -63.44451f);
generalPath.curveTo(166.31871f, -131.86879f, 198.81178f, -193.67236f, 213.26932f, -193.67236f);
generalPath.curveTo(216.27992f, -193.67236f, 222.39073f, -187.88728f, 226.84885f, -180.81667f);
generalPath.curveTo(234.1083f, -169.30315f, 235.10535f, -162.16885f, 236.39879f, -112.48102f);
generalPath.curveTo(237.19308f, -81.96702f, 238.82301f, -55.025116f, 240.02077f, -52.610058f);
generalPath.curveTo(241.21852f, -50.19504f, 245.01846f, -53.36465f, 248.46507f, -59.653706f);
generalPath.curveTo(252.86649f, -67.685005f, 257.4999f, -69.86239f, 264.03268f, -66.96937f);
generalPath.curveTo(270.80026f, -63.972355f, 274.6598f, -66.023834f, 278.20206f, -74.50104f);
generalPath.curveTo(283.51566f, -87.217026f, 310.10803f, -173.17207f, 310.10803f, -177.63116f);
generalPath.curveTo(310.10803f, -179.14659f, 315.3731f, -197.30463f, 321.80826f, -217.98238f);
generalPath.curveTo(328.24335f, -238.6601f, 335.6549f, -262.50308f, 338.27832f, -270.9667f);
generalPath.curveTo(342.9439f, -286.01862f, 343.67493f, -284.23734f, 371.70526f, -189.5116f);
generalPath.curveTo(400.64645f, -91.70762f, 416.22293f, -55.61746f, 424.02094f, -68.297676f);
generalPath.curveTo(429.46295f, -77.146904f, 458.0215f, -77.649055f, 466.00342f, -69.03592f);
generalPath.curveTo(470.54007f, -64.14053f, 473.42258f, -64.20471f, 475.92825f, -69.25694f);
generalPath.curveTo(481.12833f, -79.741714f, 493.57806f, -77.91559f, 496.83237f, -66.19062f);
generalPath.curveTo(499.3963f, -56.95312f, 500.0502f, -56.95312f, 503.8525f, -66.19062f);
generalPath.curveTo(506.15857f, -71.7932f, 512.9887f, -76.37703f, 519.0305f, -76.37703f);
generalPath.curveTo(527.5694f, -76.37703f, 530.8239f, -72.80081f, 533.6446f, -60.318634f);
generalPath.lineTo(537.2734f, -44.260265f);
generalPath.lineTo(593.3654f, -48.26419f);
generalPath.curveTo(624.216f, -50.46641f, 649.45746f, -50.8589f, 649.45746f, -49.136333f);
generalPath.curveTo(649.45746f, -47.413887f, 626.5514f, -28.828472f, 598.55505f, -7.8354607f);
generalPath.curveTo(570.5587f, 13.157471f, 547.18805f, 30.963896f, 546.6202f, 31.734255f);
generalPath.curveTo(546.05237f, 32.504616f, 547.31866f, 50.874245f, 549.43427f, 72.555595f);
generalPath.curveTo(554.93884f, 128.9694f, 551.3488f, 166.56639f, 537.50793f, 197.45609f);
generalPath.curveTo(531.29895f, 211.31322f, 521.2246f, 225.97423f, 515.1204f, 230.03612f);
generalPath.curveTo(509.01627f, 234.09798f, 504.022f, 238.87979f, 504.022f, 240.66228f);
generalPath.curveTo(504.022f, 242.4448f, 510.53723f, 264.21027f, 518.50037f, 289.02997f);
generalPath.curveTo(526.46344f, 313.84973f, 531.78314f, 334.1568f, 530.32184f, 334.1568f);
generalPath.curveTo(527.9368f, 334.1568f, 469.852f, 288.9067f, 379.53287f, 216.687f);
generalPath.curveTo(361.72388f, 202.44685f, 345.50604f, 190.79578f, 343.49326f, 190.79578f);
generalPath.curveTo(339.73965f, 190.79578f, 307.32635f, 215.56903f, 212.26904f, 291.08963f);
generalPath.curveTo(157.14378f, 334.88528f, 154.97687f, 336.40244f, 154.97687f, 331.2025f);
generalPath.closePath();
generalPath.moveTo(268.09335f, 227.86295f);
generalPath.curveTo(297.42285f, 204.88731f, 326.50992f, 182.43457f, 332.73132f, 177.96796f);
generalPath.curveTo(343.432f, 170.28555f, 347.0105f, 172.21162f, 398.98526f, 213.62856f);
generalPath.curveTo(429.20352f, 237.70845f, 459.0178f, 261.1641f, 465.2392f, 265.75208f);
generalPath.curveTo(471.4606f, 270.34015f, 484.28235f, 280.3108f, 493.73193f, 287.90912f);
generalPath.curveTo(504.50696f, 296.57315f, 510.01443f, 298.65924f, 508.50302f, 293.50397f);
generalPath.curveTo(491.61932f, 235.91676f, 491.1032f, 234.95695f, 479.4022f, 239.3829f);
generalPath.curveTo(465.28857f, 244.72147f, 456.52322f, 239.2448f, 452.0185f, 222.2737f);
generalPath.curveTo(449.09738f, 211.26852f, 449.98907f, 205.88622f, 457.27292f, 190.557f);
generalPath.curveTo(468.1218f, 167.72513f, 466.41748f, 146.7202f, 452.42862f, 130.853f);
generalPath.curveTo(447.061f, 124.76466f, 440.28802f, 109.71489f, 437.37762f, 97.409035f);
generalPath.lineTo(432.0859f, 75.03475f);
generalPath.lineTo(420.74042f, 90.55865f);
generalPath.curveTo(406.79584f, 109.63877f, 389.7898f, 110.62189f, 375.59277f, 93.16868f);
generalPath.lineTo(365.1279f, 80.30351f);
generalPath.lineTo(352.96948f, 96.9637f);
generalPath.curveTo(340.79486f, 113.64611f, 326.7784f, 115.80139f, 312.53195f, 103.18174f);
generalPath.curveTo(308.607f, 99.70489f, 306.87613f, 101.05628f, 306.87613f, 107.59755f);
generalPath.curveTo(306.87613f, 112.78176f, 303.17184f, 120.42643f, 298.64432f, 124.58577f);
generalPath.curveTo(285.07013f, 137.05605f, 271.82324f, 133.74466f, 262.84204f, 115.63602f);
generalPath.lineTo(254.65259f, 99.12382f);
generalPath.lineTo(248.04277f, 116.06667f);
generalPath.curveTo(244.40738f, 125.38523f, 235.99326f, 139.93332f, 229.34473f, 148.39565f);
generalPath.curveTo(221.11507f, 158.87057f, 210.9273f, 184.43022f, 197.42831f, 228.46936f);
generalPath.curveTo(186.52283f, 264.04752f, 177.60016f, 294.96707f, 177.60016f, 297.17963f);
generalPath.curveTo(177.60016f, 299.3921f, 185.9627f, 294.10004f, 196.18358f, 285.4195f);
generalPath.curveTo(206.40446f, 276.73898f, 238.76385f, 250.83856f, 268.09335f, 227.86295f);
generalPath.closePath();
generalPath.moveTo(516.86066f, 203.14647f);
generalPath.curveTo(539.1162f, 177.9262f, 544.2749f, 131.27f, 534.4375f, 44.17663f);
generalPath.curveTo(526.21606f, -28.61025f, 522.112f, -52.429882f, 517.24255f, -55.621048f);
generalPath.curveTo(513.87354f, -57.828934f, 513.35583f, -55.405327f, 515.25397f, -46.313198f);
generalPath.curveTo(527.56915f, 12.678504f, 528.2536f, 42.295444f, 517.4942f, 50.620235f);
generalPath.curveTo(510.1027f, 56.33925f, 502.2618f, 34.91191f, 496.09518f, -7.858426f);
generalPath.curveTo(491.32004f, -40.977562f, 486.32657f, -55.903065f, 482.5613f, -48.31125f);
generalPath.curveTo(481.65973f, -46.493374f, 483.23978f, -35.969265f, 486.07254f, -24.92417f);
generalPath.curveTo(488.90527f, -13.879196f, 492.78976f, 19.38265f, 494.7047f, 48.991f);
generalPath.curveTo(496.6197f, 78.59929f, 500.31857f, 109.60181f, 502.92444f, 117.88548f);
generalPath.curveTo(509.6964f, 139.4125f, 520.4757f, 134.2246f, 527.44824f, 106.0825f);
generalPath.curveTo(534.342f, 78.258354f, 535.1211f, 96.79187f, 528.41754f, 129.14072f);
generalPath.curveTo(521.45685f, 162.73064f, 500.78314f, 172.80284f, 476.83337f, 154.27245f);
generalPath.curveTo(473.0001f, 151.30658f, 471.703f, 154.3763f, 471.703f, 166.41241f);
generalPath.curveTo(471.703f, 175.27257f, 468.7668f, 190.04814f, 465.1781f, 199.2469f);
generalPath.lineTo(458.65323f, 215.97206f);
generalPath.lineTo(467.60205f, 219.01912f);
generalPath.curveTo(483.05148f, 224.27977f, 504.23532f, 217.45364f, 516.86066f, 203.14647f);
generalPath.closePath();
generalPath.moveTo(196.49414f, 147.62354f);
generalPath.curveTo(242.9538f, 120.69714f, 251.25603f, 89.29071f, 235.82298f, -1.1532906f);
generalPath.curveTo(232.24113f, -22.144346f, 229.31056f, -44.72449f, 229.31056f, -51.331493f);
generalPath.curveTo(229.31056f, -73.82736f, 223.69904f, -63.432415f, 219.49342f, -33.14581f);
generalPath.curveTo(213.9314f, 6.9088006f, 197.20229f, 40.953506f, 183.14827f, 40.81864f);
generalPath.curveTo(170.9428f, 40.70129f, 166.96576f, 36.221363f, 161.92448f, 16.91025f);
generalPath.curveTo(152.87701f, -17.747206f, 162.73918f, -70.93493f, 187.89403f, -123.14597f);
generalPath.curveTo(206.31834f, -161.38731f, 216.38297f, -164.85062f, 216.38297f, -132.9492f);
generalPath.curveTo(216.38297f, -83.201164f, 199.37161f, -9.966888f, 190.40987f, -21.134373f);
generalPath.curveTo(186.02782f, -26.594978f, 186.7385f, -50.708183f, 191.82709f, -69.2228f);
generalPath.curveTo(196.15443f, -84.96757f, 195.27522f, -108.95905f, 190.3709f, -108.95905f);
generalPath.curveTo(184.684f, -108.95905f, 173.42542f, -67.19796f, 171.93771f, -40.585537f);
generalPath.curveTo(170.62256f, -17.05907f, 171.44485f, -11.338504f, 177.00423f, -5.339529f);
generalPath.curveTo(196.48666f, 15.683606f, 222.00954f, -48.47872f, 223.29506f, -121.71076f);
generalPath.curveTo(223.9701f, -160.1676f, 220.2783f, -170.99084f, 208.516f, -165.03848f);
generalPath.curveTo(191.39722f, -156.37544f, 145.28117f, -36.42682f, 145.28117f, -0.5636298f);
generalPath.curveTo(145.28117f, 27.488455f, 152.26854f, 47.216694f, 164.56944f, 53.895256f);
generalPath.curveTo(185.48363f, 65.250175f, 205.70483f, 45.076275f, 220.03275f, -1.4382513f);
generalPath.lineTo(226.05449f, -20.987507f);
generalPath.lineTo(226.06769f, 5.5713825f);
generalPath.curveTo(226.0839f, 44.029484f, 213.6415f, 64.30035f, 174.36952f, 89.78718f);
generalPath.curveTo(164.59303f, 96.132f, 156.1862f, 101.99455f, 155.68771f, 102.8151f);
generalPath.curveTo(153.86716f, 105.81194f, 172.3751f, 158.21379f, 175.25417f, 158.21379f);
generalPath.curveTo(176.88678f, 158.21379f, 186.44531f, 153.44814f, 196.49539f, 147.62354f);
generalPath.closePath();
generalPath.moveTo(476.411f, 99.87771f);
generalPath.curveTo(481.07446f, 89.48762f, 481.8965f, 78.20063f, 480.8968f, 38.283955f);
generalPath.curveTo(479.8094f, -5.1332035f, 478.61932f, -12.805548f, 470.23535f, -30.449965f);
generalPath.curveTo(455.08655f, -62.331245f, 436.3741f, -54.19826f, 447.32718f, -20.493298f);
generalPath.curveTo(453.14972f, -2.5758963f, 460.25256f, -5.636063f, 457.7436f, -24.98115f);
generalPath.curveTo(455.74493f, -40.391087f, 459.47357f, -40.795994f, 465.972f, -25.874805f);
generalPath.curveTo(478.16498f, 2.121973f, 475.0873f, 40.918427f, 460.67337f, 40.918427f);
generalPath.curveTo(450.8062f, 40.918427f, 447.7314f, 32.386017f, 441.29984f, -12.841981f);
generalPath.curveTo(438.36926f, -33.450108f, 434.8002f, -50.31136f, 433.36856f, -50.31136f);
generalPath.curveTo(428.59958f, -50.31136f, 426.4757f, -41.825287f, 429.44135f, -34.61987f);
generalPath.curveTo(431.05225f, -30.706072f, 435.51355f, -2.5786383f, 439.3554f, 27.885601f);
generalPath.curveTo(449.02444f, 104.55654f, 462.53207f, 130.7994f, 476.411f, 99.87771f);
generalPath.closePath();
generalPath.moveTo(292.63974f, 101.09544f);
generalPath.curveTo(294.62952f, 98.40371f, 295.5395f, 85.673065f, 294.7184f, 72.01465f);
generalPath.curveTo(293.39392f, 49.982727f, 292.6518f, 48.37559f, 286.7457f, 54.748707f);
generalPath.curveTo(278.25836f, 63.90719f, 269.1373f, 46.55554f, 266.0435f, 15.365538f);
generalPath.curveTo(263.6964f, -8.296261f, 262.9782f, -7.8315287f, 280.06924f, 6.2892785f);
generalPath.curveTo(282.21213f, 8.059732f, 287.66595f, 2.0469875f, 292.18887f, -7.07248f);
generalPath.curveTo(300.46295f, -23.755333f, 303.1869f, -43.79495f, 297.18042f, -43.79495f);
generalPath.curveTo(295.4029f, -43.79495f, 293.94852f, -40.862553f, 293.94852f, -37.278534f);
generalPath.curveTo(293.94852f, -27.90439f, 285.10623f, -29.233946f, 283.1139f, -38.907627f);
generalPath.curveTo(281.95163f, -44.55077f, 279.4758f, -42.548847f, 275.05472f, -32.391216f);
generalPath.curveTo(271.5449f, -24.32715f, 267.258f, -17.72928f, 265.52832f, -17.72928f);
generalPath.curveTo(263.79865f, -17.72928f, 261.4627f, -24.32715f, 260.33743f, -32.391216f);
generalPath.curveTo(258.36548f, -46.522427f, 258.12378f, -46.61157f, 253.66006f, -34.854485f);
generalPath.curveTo(249.74947f, -24.554243f, 249.7145f, -21.273172f, 253.43546f, -13.771043f);
generalPath.curveTo(257.37607f, -5.8256135f, 264.8616f, 48.47354f, 264.8616f, 69.11302f);
generalPath.curveTo(264.8616f, 94.77757f, 282.39093f, 114.95982f, 292.63992f, 101.09544f);
generalPath.closePath();
generalPath.moveTo(351.58286f, 67.07011f);
generalPath.curveTo(363.72852f, 42.58105f, 367.32736f, 5.873159f, 360.71228f, -26.048851f);
generalPath.curveTo(355.5421f, -50.998222f, 346.5676f, -60.335995f, 333.91348f, -53.932335f);
generalPath.curveTo(324.51086f, -49.174095f, 310.19037f, 6.1055756f, 310.13962f, 37.839325f);
generalPath.curveTo(310.06042f, 87.29667f, 333.39014f, 103.75158f, 351.58286f, 67.07011f);
generalPath.closePath();
generalPath.moveTo(329.49942f, 27.885601f);
generalPath.curveTo(325.94434f, 20.717527f, 323.08188f, 6.788711f, 323.1384f, -3.0673642f);
generalPath.curveTo(323.2318f, -19.358192f, 323.63156f, -19.950674f, 327.5346f, -9.583776f);
generalPath.curveTo(332.35925f, 3.2310674f, 340.93256f, 5.45093f, 344.217f, -5.2642612f);
generalPath.curveTo(345.41132f, -9.160539f, 344.76996f, -15.611845f, 342.7918f, -19.600348f);
generalPath.curveTo(337.71048f, -29.845705f, 338.3262f, -43.79495f, 343.85974f, -43.79495f);
generalPath.curveTo(350.0111f, -43.79495f, 358.58652f, -18.561682f, 358.58652f, -0.4612633f);
generalPath.curveTo(358.58652f, 12.859767f, 345.14212f, 40.918427f, 338.75928f, 40.918427f);
generalPath.curveTo(337.22144f, 40.918427f, 333.05453f, 35.053635f, 329.49942f, 27.885601f);
generalPath.closePath();
generalPath.moveTo(415.8484f, 65.354935f);
generalPath.curveTo(429.25912f, 35.911964f, 427.95215f, -9.444975f, 412.75015f, -42.165836f);
generalPath.curveTo(404.89957f, -59.06346f, 387.45718f, -61.97682f, 380.3183f, -47.58285f);
generalPath.curveTo(373.73068f, -34.300392f, 367.15366f, 17.93216f, 369.59708f, 37.5614f);
generalPath.curveTo(374.8083f, 79.425766f, 401.9975f, 95.76436f, 415.8484f, 65.354935f);
generalPath.closePath();
generalPath.moveTo(388.39276f, 17.74148f);
generalPath.curveTo(383.08652f, 10.247698f, 381.26334f, 1.309332f, 381.4147f, -16.469671f);
generalPath.curveTo(381.58405f, -36.350845f, 382.099f, -38.144287f, 384.37613f, -26.781223f);
generalPath.curveTo(387.72186f, -10.085789f, 394.73907f, -3.7808447f, 400.8943f, -11.939596f);
generalPath.curveTo(404.71182f, -16.99971f, 404.53357f, -19.391703f, 399.79324f, -26.717045f);
generalPath.curveTo(393.47134f, -36.48638f, 392.23816f, -50.31136f, 397.6886f, -50.31136f);
generalPath.curveTo(402.56223f, -50.31136f, 419.9926f, -11.867656f, 419.9926f, -1.1186308f);
generalPath.curveTo(419.9926f, 9.372391f, 407.61523f, 27.885601f, 400.60123f, 27.885601f);
generalPath.curveTo(397.83716f, 27.885601f, 392.34332f, 23.320705f, 388.39276f, 17.74148f);
generalPath.closePath();
generalPath.moveTo(578.35565f, -11.068866f);
generalPath.lineTo(612.29065f, -36.749847f);
generalPath.lineTo(575.93176f, -37.014484f);
generalPath.curveTo(543.3925f, -37.251114f, 539.5775f, -36.080807f, 539.617f, -25.875048f);
generalPath.curveTo(539.6571f, -15.536436f, 542.9477f, 15.023053f, 543.9897f, 14.732144f);
generalPath.curveTo(544.2269f, 14.665809f, 559.69147f, 3.0553892f, 578.35565f, -11.069128f);
generalPath.closePath();
generalPath.moveTo(134.86224f, -15.66457f);
generalPath.lineTo(138.33049f, -36.40726f);
generalPath.lineTo(107.86363f, -38.47201f);
generalPath.curveTo(91.10689f, -39.60762f, 77.40005f, -38.738422f, 77.40405f, -36.540337f);
generalPath.curveTo(77.40985f, -33.32411f, 129.91061f, 8.033683f, 131.0658f, 5.7319994f);
generalPath.curveTo(131.24614f, 5.3722954f, 132.95471f, -4.2560816f, 134.86224f, -15.66457f);
generalPath.closePath();
generalPath.moveTo(343.77145f, -79.95756f);
generalPath.curveTo(350.9381f, -77.6469f, 359.02124f, -71.732666f, 361.734f, -66.81474f);
generalPath.curveTo(365.94678f, -59.17742f, 367.77927f, -59.697964f, 374.29608f, -70.383255f);
generalPath.curveTo(378.4925f, -77.2638f, 383.94632f, -82.893394f, 386.4157f, -82.893394f);
generalPath.curveTo(388.8851f, -82.893394f, 390.90552f, -84.33116f, 390.90552f, -86.08853f);
generalPath.curveTo(390.90552f, -92.15588f, 344.36597f, -245.80305f, 342.59106f, -245.59557f);
generalPath.curveTo(340.50604f, -245.35185f, 292.80502f, -84.11587f, 291.3364f, -72.348076f);
generalPath.curveTo(290.72006f, -67.409164f, 292.65445f, -65.58606f, 296.41006f, -67.56627f);
generalPath.curveTo(299.7484f, -69.326485f, 304.3642f, -66.18863f, 306.66733f, -60.59325f);
generalPath.curveTo(310.4027f, -51.518246f, 311.9284f, -52.24124f, 320.798f, -67.28925f);
generalPath.curveTo(329.22446f, -81.585495f, 332.7288f, -83.517876f, 343.77145f, -79.95756f);
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
generalPath.moveTo(309.54578f, -55.544712f);
generalPath.curveTo(309.04504f, -56.014725f, 308.42776f, -57.093193f, 307.01797f, -59.961067f);
generalPath.curveTo(305.1061f, -63.85041f, 304.3461f, -64.981865f, 302.7569f, -66.30485f);
generalPath.curveTo(300.669f, -68.04296f, 298.402f, -68.511116f, 296.2746f, -67.64347f);
generalPath.curveTo(294.37653f, -66.86936f, 293.85025f, -66.78601f, 292.9922f, -67.12368f);
generalPath.curveTo(291.55994f, -67.68729f, 291.0506f, -69.44096f, 291.45636f, -72.41181f);
generalPath.curveTo(291.96207f, -76.114845f, 295.79327f, -90.44249f, 303.46533f, -117.32214f);
generalPath.curveTo(319.04904f, -171.92094f, 340.0016f, -240.7607f, 342.3159f, -244.96603f);
generalPath.curveTo(342.5722f, -245.43178f, 342.5809f, -245.43178f, 342.83838f, -244.96603f);
generalPath.curveTo(344.21606f, -242.47395f, 352.31458f, -217.29082f, 363.37875f, -181.09375f);
generalPath.curveTo(378.3457f, -132.1284f, 390.78976f, -89.06329f, 390.78976f, -86.23245f);
generalPath.curveTo(390.78976f, -84.50392f, 389.4737f, -83.46582f, 386.70386f, -83.00954f);
generalPath.curveTo(383.2616f, -82.442474f, 379.27908f, -78.3683f, 373.835f, -69.84452f);
generalPath.curveTo(371.24786f, -65.79386f, 370.1437f, -64.280945f, 368.88437f, -63.060997f);
generalPath.curveTo(367.83508f, -62.044567f, 367.74744f, -62.00372f, 366.6158f, -62.00372f);
generalPath.curveTo(365.50214f, -62.00372f, 365.38922f, -62.053925f, 364.5196f, -62.93379f);
generalPath.curveTo(364.00745f, -63.452015f, 363.0149f, -64.84784f, 362.27805f, -66.08608f);
generalPath.curveTo(360.09955f, -69.74686f, 357.47885f, -72.40941f, 353.2061f, -75.30297f);
generalPath.curveTo(347.7761f, -78.98019f, 341.96152f, -81.18728f, 337.01056f, -81.45053f);
generalPath.curveTo(333.10123f, -81.65836f, 331.29855f, -80.95053f, 328.33453f, -78.04376f);
generalPath.curveTo(325.91467f, -75.67065f, 324.74832f, -73.98477f, 319.20978f, -64.85438f);
generalPath.curveTo(313.57602f, -55.56705f, 311.57538f, -53.639732f, 309.54578f, -55.544712f);
generalPath.closePath();
shape = generalPath;
paint = new Color(99, 152, 170, 255);
g.setPaint(paint);
g.fill(shape);
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
generalPath.moveTo(128.63786f, 4.6609316f);
generalPath.curveTo(118.47886f, -1.308665f, 83.13469f, -29.45374f, 78.186935f, -35.51389f);
generalPath.curveTo(77.50402f, -36.350323f, 77.44884f, -36.47741f, 77.64373f, -36.764748f);
generalPath.curveTo(78.77529f, -38.433037f, 89.98171f, -39.262936f, 102.64776f, -38.616417f);
generalPath.curveTo(107.69907f, -38.358578f, 138.14908f, -36.33151f, 138.19865f, -36.24977f);
generalPath.curveTo(138.29836f, -36.08544f, 131.67702f, 2.6418302f, 131.16815f, 4.870887f);
generalPath.curveTo(130.95564f, 5.801803f, 130.51752f, 5.7654495f, 128.63786f, 4.6609316f);
generalPath.closePath();
shape = generalPath;
paint = new Color(99, 152, 170, 255);
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
generalPath.moveTo(543.69415f, 13.878451f);
generalPath.curveTo(542.3079f, 8.408549f, 539.80646f, -16.306595f, 539.73334f, -25.254658f);
generalPath.curveTo(539.70496f, -28.731207f, 539.92004f, -30.148994f, 540.694f, -31.587387f);
generalPath.curveTo(542.4677f, -34.884026f, 546.0733f, -36.069977f, 555.98413f, -36.616673f);
generalPath.curveTo(560.9876f, -36.89268f, 584.086f, -36.935165f, 600.3954f, -36.69833f);
generalPath.lineTo(611.824f, -36.53239f);
generalPath.lineTo(584.3063f, -15.735947f);
generalPath.curveTo(559.2134f, 3.2279625f, 544.6215f, 14.188172f, 544.08136f, 14.47779f);
generalPath.curveTo(543.9462f, 14.550376f, 543.8116f, 14.341894f, 543.69415f, 13.878492f);
generalPath.lineTo(543.69415f, 13.878492f);
generalPath.closePath();
shape = generalPath;
paint = new Color(99, 152, 170, 255);
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
generalPath.moveTo(178.08835f, 296.56836f);
generalPath.curveTo(178.08835f, 295.01425f, 181.35725f, 283.3958f, 189.6423f, 255.50285f);
generalPath.curveTo(209.49348f, 188.67065f, 218.56944f, 164.44746f, 229.71523f, 148.55078f);
generalPath.curveTo(239.6865f, 134.32921f, 245.018f, 124.49778f, 250.96062f, 109.37382f);
generalPath.lineTo(254.6247f, 100.04869f);
generalPath.lineTo(259.5646f, 109.84079f);
generalPath.curveTo(268.21243f, 126.98297f, 273.4259f, 131.95267f, 282.86176f, 132.04874f);
generalPath.curveTo(294.40234f, 132.16628f, 307.04025f, 119.16853f, 307.04025f, 107.18198f);
generalPath.curveTo(307.04025f, 104.48057f, 307.9943f, 101.69294f, 308.91882f, 101.69294f);
generalPath.curveTo(309.31015f, 101.69294f, 311.53568f, 103.07137f, 313.86447f, 104.75613f);
generalPath.curveTo(319.9344f, 109.14739f, 323.49475f, 110.73537f, 328.4736f, 111.27204f);
generalPath.curveTo(333.41357f, 111.80452f, 337.0221f, 110.92846f, 341.83176f, 108.02904f);
generalPath.curveTo(346.55737f, 105.18028f, 349.27887f, 102.2644f, 357.4301f, 91.31647f);
generalPath.curveTo(361.5377f, 85.79956f, 365.02963f, 81.28574f, 365.18997f, 81.28574f);
generalPath.curveTo(365.3503f, 81.28574f, 368.3153f, 84.75164f, 371.77887f, 88.98775f);
generalPath.curveTo(375.24243f, 93.22385f, 379.4043f, 97.821724f, 381.02747f, 99.20526f);
generalPath.curveTo(392.0961f, 108.63979f, 404.0519f, 108.02426f, 414.99872f, 97.456314f);
generalPath.curveTo(416.95667f, 95.56612f, 421.56665f, 89.934105f, 425.24313f, 84.94073f);
generalPath.curveTo(428.91962f, 79.94736f, 431.97925f, 75.97684f, 432.04236f, 76.11737f);
generalPath.curveTo(432.10547f, 76.257904f, 433.4984f, 82.006516f, 435.1378f, 88.89207f);
generalPath.curveTo(436.7772f, 95.777626f, 438.83676f, 103.54377f, 439.7146f, 106.15015f);
generalPath.curveTo(443.5146f, 117.43281f, 447.89047f, 125.81171f, 453.79803f, 133.11716f);
generalPath.curveTo(459.87924f, 140.63737f, 463.63007f, 150.63216f, 464.01685f, 160.34714f);
generalPath.curveTo(464.4005f, 169.98431f, 462.31354f, 178.53275f, 456.29495f, 191.97693f);
generalPath.curveTo(451.59747f, 202.47003f, 450.42166f, 206.5655f, 450.4338f, 212.39157f);
generalPath.curveTo(450.446f, 218.2239f, 452.13486f, 224.95004f, 455.10345f, 230.9893f);
generalPath.curveTo(459.90878f, 240.76512f, 467.44952f, 243.6672f, 478.5388f, 240.0085f);
generalPath.curveTo(481.01288f, 239.19223f, 484.13358f, 238.52135f, 485.47372f, 238.51772f);
generalPath.curveTo(489.75922f, 238.50562f, 492.3769f, 242.74371f, 497.3662f, 257.77032f);
generalPath.curveTo(500.80972f, 268.14136f, 508.34018f, 293.56952f, 508.34018f, 294.82623f);
generalPath.curveTo(508.34018f, 295.47964f, 507.98874f, 295.93936f, 507.4892f, 295.93936f);
generalPath.curveTo(506.4381f, 295.93936f, 501.86606f, 293.43152f, 498.55707f, 291.03995f);
generalPath.curveTo(494.20856f, 287.89706f, 441.2847f, 246.67119f, 423.8092f, 232.81393f);
generalPath.curveTo(377.14572f, 195.81195f, 361.78116f, 183.99487f, 354.27264f, 179.33237f);
generalPath.curveTo(346.15848f, 174.29378f, 340.63235f, 173.1117f, 336.14603f, 175.45493f);
generalPath.curveTo(330.56607f, 178.36938f, 254.42535f, 237.6952f, 210.01358f, 273.7323f);
generalPath.curveTo(188.0824f, 291.52798f, 185.33609f, 293.64462f, 181.23242f, 295.91458f);
generalPath.curveTo(177.96939f, 297.71957f, 178.08835f, 297.69482f, 178.08835f, 296.56836f);
generalPath.closePath();
shape = generalPath;
paint = new Color(99, 152, 170, 255);
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
generalPath.moveTo(212.72745f, -166.03767f);
generalPath.curveTo(204.45798f, -163.70506f, 200.27844f, -154.75558f, 195.9794f, -148.00668f);
generalPath.curveTo(177.65384f, -113.77738f, 164.28284f, -77.03155f, 153.05692f, -39.9881f);
generalPath.curveTo(153.04129f, -36.88039f, 150.74004f, -34.55409f, 151.03197f, -31.64416f);
generalPath.curveTo(149.69122f, -30.40609f, 150.81522f, -28.36802f, 149.35573f, -27.11658f);
generalPath.curveTo(149.68533f, -24.00865f, 147.45543f, -20.84739f, 147.56519f, -17.52493f);
generalPath.curveTo(143.79263f, 0.22969f, 145.20934f, 19.18318f, 151.36182f, 36.22341f);
generalPath.curveTo(155.64667f, 47.46346f, 166.41888f, 58.31065f, 179.38518f, 56.01786f);
generalPath.curveTo(194.87437f, 52.41918f, 203.33788f, 36.99593f, 209.83186f, 23.78454f);
generalPath.curveTo(215.18271f, 14.04047f, 217.60686f, 2.5306f, 221.8143f, -7.35544f);
generalPath.curveTo(221.60728f, -11.16791f, 224.48206f, -14.98835f, 224.92255f, -18.35958f);
generalPath.curveTo(226.83565f, -14.26602f, 225.45277f, -8.72686f, 225.95567f, -4.13461f);
generalPath.curveTo(225.90599f, 13.39767f, 226.49619f, 31.87074f, 218.0416f, 47.80321f);
generalPath.curveTo(205.22675f, 73.00506f, 178.90582f, 86.23317f, 157.16283f, 102.42744f);
generalPath.curveTo(154.62334f, 106.39947f, 158.40974f, 111.42969f, 158.94579f, 115.6033f);
generalPath.curveTo(161.7746f, 127.78678f, 167.30833f, 139.14255f, 171.26093f, 150.90178f);
generalPath.curveTo(170.90623f, 151.93414f, 173.8816f, 153.7238f, 173.98698f, 155.3675f);
generalPath.curveTo(175.69882f, 160.05469f, 180.24796f, 154.80446f, 183.04109f, 154.26509f);
generalPath.curveTo(204.90453f, 143.46367f, 227.16037f, 128.66193f, 236.27182f, 104.916f);
generalPath.curveTo(237.7925f, 102.02386f, 238.09908f, 98.49834f, 239.60266f, 95.87475f);
generalPath.curveTo(239.60854f, 92.53786f, 241.3065f, 88.96807f, 241.32172f, 85.40029f);
generalPath.curveTo(245.64398f, 52.64673f, 238.61931f, 19.86999f, 233.7747f, -12.42061f);
generalPath.curveTo(230.92223f, -28.40528f, 229.68892f, -44.61864f, 228.17035f, -60.74113f);
generalPath.curveTo(226.99759f, -64.70527f, 225.35504f, -58.61119f, 224.7592f, -57.42197f);
generalPath.curveTo(219.1884f, -37.88411f, 218.7123f, -17.11429f, 211.73363f, 2.12068f);
generalPath.curveTo(210.85562f, 5.94838f, 208.46718f, 8.7175f, 207.89539f, 12.41997f);
generalPath.curveTo(202.5347f, 22.69371f, 197.95552f, 35.45589f, 186.63405f, 40.48774f);
generalPath.curveTo(181.90712f, 41.6339f, 176.22481f, 41.08583f, 172.01103f, 38.69098f);
generalPath.curveTo(165.92464f, 32.85539f, 163.016f, 24.19879f, 161.65233f, 16.25928f);
generalPath.curveTo(157.82268f, 2.57153f, 158.07104f, -12.32469f, 159.19537f, -26.51248f);
generalPath.curveTo(162.77362f, -66.04782f, 176.65643f, -104.14687f, 195.6749f, -138.77434f);
generalPath.curveTo(199.6955f, -144.56337f, 202.88203f, -152.63242f, 209.95222f, -155.12393f);
generalPath.curveTo(216.45769f, -153.71957f, 215.73402f, -144.82825f, 215.93709f, -139.6925f);
generalPath.curveTo(216.83456f, -116.47272f, 214.4064f, -93.32762f, 210.49506f, -70.46904f);
generalPath.curveTo(209.2169f, -62.66621f, 206.9765f, -55.26818f, 205.49515f, -47.54124f);
generalPath.curveTo(202.63362f, -38.09773f, 200.47131f, -27.58185f, 193.84169f, -20.01202f);
generalPath.curveTo(188.37599f, -18.95356f, 187.84425f, -26.83135f, 187.91699f, -30.67362f);
generalPath.curveTo(187.836f, -41.88063f, 187.43367f, -53.34135f, 190.39725f, -64.20302f);
generalPath.curveTo(189.91136f, -66.70253f, 192.2683f, -68.10188f, 191.5676f, -70.4211f);
generalPath.curveTo(194.651f, -80.02579f, 194.02994f, -90.56209f, 193.61015f, -100.55204f);
generalPath.curveTo(193.3858f, -102.72734f, 192.48764f, -109.37975f, 189.12064f, -107.21891f);
generalPath.curveTo(184.38165f, -100.56398f, 182.13625f, -92.33262f, 179.95132f, -84.57947f);
generalPath.curveTo(174.227f, -62.12555f, 169.91559f, -38.72626f, 172.3739f, -15.48993f);
generalPath.curveTo(171.83965f, -12.2678f, 174.26906f, -11.02924f, 175.34921f, -8.45126f);
generalPath.curveTo(178.50507f, -4.47331f, 184.33856f, 1.27058f, 189.43147f, -3.329f);
generalPath.curveTo(201.63483f, -11.88197f, 205.9965f, -27.27375f, 210.81493f, -40.61684f);
generalPath.curveTo(220.4901f, -71.84576f, 223.65323f, -104.89276f, 223.11575f, -137.50394f);
generalPath.curveTo(222.54486f, -145.33022f, 222.47015f, -153.8575f, 220.10953f, -161.15805f);
generalPath.curveTo(218.22896f, -163.37779f, 215.96416f, -166.21346f, 212.72745f, -166.03767f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
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
generalPath.moveTo(297.14484f, -43.06061f);
generalPath.curveTo(293.1682f, -40.93259f, 294.3896f, -36.00648f, 293.2167f, -32.56077f);
generalPath.curveTo(289.3781f, -28.03698f, 282.67163f, -33.69144f, 282.9135f, -38.57427f);
generalPath.curveTo(282.79483f, -41.0262f, 280.32614f, -42.40775f, 279.58643f, -39.21971f);
generalPath.curveTo(274.72992f, -32.2284f, 272.33658f, -23.14448f, 265.90222f, -17.45883f);
generalPath.curveTo(262.4616f, -17.4802f, 262.5058f, -23.13791f, 261.27158f, -25.63541f);
generalPath.curveTo(259.35474f, -30.74991f, 260.81198f, -37.25322f, 257.76053f, -41.73009f);
generalPath.curveTo(255.25514f, -41.11382f, 255.60823f, -36.84268f, 253.95451f, -35.77368f);
generalPath.curveTo(252.63983f, -29.30132f, 249.01344f, -21.95925f, 253.2155f, -15.63035f);
generalPath.curveTo(258.66544f, 0.66607f, 259.9689f, 18.0393f, 262.43167f, 34.98618f);
generalPath.curveTo(265.05627f, 51.71486f, 263.56183f, 69.12955f, 267.43732f, 85.53667f);
generalPath.curveTo(271.39902f, 93.39896f, 275.54294f, 104.56365f, 285.85367f, 105.06469f);
generalPath.curveTo(294.2304f, 103.28059f, 294.56183f, 93.15951f, 294.44733f, 86.28518f);
generalPath.curveTo(294.09937f, 74.86444f, 295.5023f, 62.72939f, 291.37872f, 51.88675f);
generalPath.curveTo(289.78836f, 49.79471f, 289.96713f, 54.66189f, 287.91525f, 54.45898f);
generalPath.curveTo(284.4013f, 58.10425f, 277.5893f, 58.46519f, 275.63135f, 52.97305f);
generalPath.curveTo(272.6194f, 47.84764f, 270.14703f, 41.76385f, 269.30225f, 36.15681f);
generalPath.curveTo(265.88297f, 24.96638f, 265.55023f, 12.8651f, 264.7731f, 1.19223f);
generalPath.curveTo(264.4967f, -0.73169f, 264.58453f, -5.56753f, 267.74814f, -3.50344f);
generalPath.curveTo(273.0692f, -1.50337f, 276.39276f, 4.36138f, 281.89383f, 5.59293f);
generalPath.curveTo(288.03592f, 1.5001f, 291.0727f, -6.16522f, 294.1f, -12.70448f);
generalPath.curveTo(297.6364f, -20.63015f, 300.0313f, -29.21992f, 300.46558f, -37.8432f);
generalPath.curveTo(299.8586f, -39.59204f, 299.2549f, -42.61165f, 297.14484f, -43.06061f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
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
generalPath.moveTo(340.48105f, -55.46822f);
generalPath.curveTo(330.7878f, -54.99247f, 328.38675f, -43.88944f, 324.583f, -36.87108f);
generalPath.curveTo(316.2525f, -11.65713f, 310.41992f, 14.75316f, 310.33136f, 41.45324f);
generalPath.curveTo(311.0956f, 55.9921f, 312.74222f, 72.46907f, 323.49356f, 83.33552f);
generalPath.curveTo(328.94107f, 88.71108f, 337.43015f, 86.16056f, 341.60858f, 80.54127f);
generalPath.curveTo(354.27164f, 66.28004f, 359.60727f, 47.03035f, 362.28476f, 28.5321f);
generalPath.curveTo(364.6965f, 6.13336f, 364.18222f, -17.20085f, 356.839f, -38.65039f);
generalPath.curveTo(353.49384f, -45.67408f, 349.90457f, -55.6756f, 340.48105f, -55.46822f);
generalPath.closePath();
generalPath.moveTo(343.97467f, -43.87891f);
generalPath.curveTo(349.67746f, -43.12053f, 350.3629f, -35.84569f, 352.89978f, -31.77102f);
generalPath.curveTo(354.26117f, -28.23553f, 355.32657f, -24.18875f, 356.0096f, -20.78592f);
generalPath.curveTo(357.92267f, -15.37654f, 358.0145f, -9.02965f, 358.73203f, -3.22748f);
generalPath.curveTo(358.76056f, 11.8372f, 352.37936f, 26.54716f, 343.26578f, 38.32306f);
generalPath.curveTo(341.41238f, 40.73339f, 337.70074f, 42.93262f, 335.806f, 39.17942f);
generalPath.curveTo(325.62964f, 26.15246f, 322.7775f, 9.18999f, 323.30807f, -6.95559f);
generalPath.curveTo(323.86426f, -10.04037f, 322.04227f, -14.75879f, 324.2944f, -17.01638f);
generalPath.curveTo(328.56323f, -11.39717f, 329.37497f, -1.77785f, 337.0287f, 0.75612f);
generalPath.curveTo(344.3302f, 0.18945f, 345.2824f, -9.95767f, 343.7225f, -15.55582f);
generalPath.curveTo(340.32434f, -23.86101f, 337.41818f, -33.68714f, 340.9124f, -42.39615f);
generalPath.curveTo(341.55716f, -43.42561f, 342.77295f, -43.98922f, 343.97467f, -43.87891f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
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
generalPath.moveTo(392.73764f, -55.99789f);
generalPath.curveTo(382.9137f, -55.62012f, 378.95743f, -44.28877f, 377.02832f, -36.30811f);
generalPath.curveTo(372.49667f, -17.2383f, 370.1323f, 2.44493f, 369.67218f, 22.04443f);
generalPath.curveTo(369.39386f, 40.89736f, 372.50497f, 61.92698f, 386.6599f, 75.62591f);
generalPath.curveTo(391.96567f, 81.3245f, 401.46432f, 82.49032f, 407.099f, 76.59887f);
generalPath.curveTo(412.4694f, 72.09189f, 414.97275f, 64.73553f, 418.4187f, 59.25772f);
generalPath.curveTo(417.49396f, 58.60104f, 419.68677f, 57.15719f, 418.94678f, 56.25732f);
generalPath.curveTo(421.04303f, 53.50648f, 420.1809f, 49.50396f, 421.72836f, 46.24909f);
generalPath.curveTo(425.29108f, 30.53172f, 424.5336f, 14.18711f, 423.55902f, -1.77551f);
generalPath.curveTo(422.3556f, -12.06493f, 419.87766f, -22.24818f, 416.54956f, -32.01348f);
generalPath.curveTo(413.13397f, -40.98161f, 408.74564f, -50.31015f, 400.01187f, -55.19228f);
generalPath.curveTo(398.06766f, -56.31438f, 394.98386f, -55.77803f, 392.73764f, -55.99789f);
generalPath.closePath();
generalPath.moveTo(397.7124f, -50.32217f);
generalPath.curveTo(404.4737f, -46.22876f, 406.80963f, -37.56249f, 410.44986f, -30.91784f);
generalPath.curveTo(413.01038f, -24.30528f, 417.28427f, -17.43556f, 417.9715f, -10.56994f);
generalPath.curveTo(420.94775f, -5.07846f, 420.1567f, 2.24636f, 418.35052f, 8.08428f);
generalPath.curveTo(414.5438f, 15.90097f, 409.84763f, 25.06352f, 401.22345f, 28.24347f);
generalPath.curveTo(393.7402f, 26.96651f, 389.087f, 19.33911f, 385.31433f, 13.3017f);
generalPath.curveTo(379.8571f, 1.52856f, 382.40115f, -11.89674f, 381.69586f, -24.47293f);
generalPath.curveTo(382.18365f, -27.35402f, 380.9596f, -31.71481f, 382.61206f, -33.89129f);
generalPath.curveTo(384.77155f, -30.23439f, 384.54465f, -25.26929f, 386.26373f, -21.2552f);
generalPath.curveTo(386.80362f, -16.02751f, 390.56952f, -11.16489f, 395.12274f, -8.81759f);
generalPath.curveTo(398.97244f, -9.36073f, 401.8142f, -13.65991f, 403.17245f, -17.03065f);
generalPath.curveTo(401.81f, -26.1363f, 393.09683f, -33.32163f, 394.66473f, -43.1843f);
generalPath.curveTo(394.8339f, -45.55616f, 394.03073f, -50.42523f, 397.7124f, -50.32217f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
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
generalPath.moveTo(451.44064f, -49.99232f);
generalPath.curveTo(443.20117f, -47.52388f, 443.57343f, -36.84864f, 445.1972f, -29.98537f);
generalPath.curveTo(447.0839f, -22.64193f, 448.76614f, -13.91672f, 455.0595f, -9.1078f);
generalPath.curveTo(459.1651f, -12.85767f, 457.18008f, -19.7789f, 457.517f, -24.80373f);
generalPath.curveTo(457.96152f, -28.73748f, 455.72186f, -34.0335f, 458.40088f, -37.30084f);
generalPath.curveTo(462.25833f, -36.25816f, 463.37668f, -31.02711f, 465.54666f, -28.04589f);
generalPath.curveTo(470.5746f, -16.02297f, 473.98462f, -2.99045f, 473.2361f, 10.24578f);
generalPath.curveTo(472.86264f, 20.35198f, 473.84995f, 32.57839f, 465.43567f, 39.8201f);
generalPath.curveTo(459.5537f, 43.14749f, 451.81f, 39.63376f, 450.0768f, 33.1342f);
generalPath.curveTo(442.9428f, 11.81815f, 442.3185f, -11.02438f, 437.62482f, -32.92551f);
generalPath.curveTo(437.0991f, -38.2827f, 435.04108f, -43.78878f, 434.38812f, -48.87747f);
generalPath.curveTo(429.70145f, -51.05962f, 428.23358f, -43.55551f, 428.69336f, -40.26161f);
generalPath.curveTo(437.34448f, -2.26854f, 439.0924f, 36.94491f, 447.40625f, 75.00036f);
generalPath.curveTo(448.3026f, 77.62125f, 447.96564f, 80.15929f, 449.3489f, 82.48868f);
generalPath.curveTo(452.14923f, 91.94756f, 454.40875f, 102.49934f, 461.24747f, 110.04581f);
generalPath.curveTo(463.55606f, 113.59705f, 467.79507f, 112.83804f, 469.71902f, 109.41306f);
generalPath.curveTo(479.84836f, 97.40726f, 481.25244f, 80.96307f, 480.59045f, 65.90557f);
generalPath.curveTo(480.07294f, 40.43868f, 481.60938f, 14.65724f, 477.09793f, -10.52554f);
generalPath.curveTo(473.08237f, -24.50999f, 467.10632f, -39.06334f, 455.78583f, -48.68241f);
generalPath.curveTo(454.5113f, -49.52202f, 453.0041f, -50.20327f, 451.44064f, -49.99232f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
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
generalPath.moveTo(515.48157f, -55.72354f);
generalPath.curveTo(513.36383f, -52.64547f, 515.7601f, -47.97195f, 515.80194f, -44.39113f);
generalPath.curveTo(518.88873f, -33.183f, 519.98193f, -21.43142f, 522.16113f, -9.98952f);
generalPath.curveTo(524.3735f, 7.77619f, 527.68536f, 26.48764f, 522.556f, 43.96072f);
generalPath.curveTo(521.0705f, 47.74971f, 518.44147f, 53.18419f, 513.45966f, 51.18581f);
generalPath.curveTo(507.71167f, 47.69715f, 506.47354f, 39.98961f, 504.06512f, 34.17451f);
generalPath.curveTo(503.64798f, 31.52909f, 502.39224f, 28.97324f, 502.43646f, 26.49905f);
generalPath.curveTo(500.50665f, 22.75161f, 500.69675f, 17.82675f, 499.27747f, 13.71401f);
generalPath.curveTo(495.80884f, -4.88262f, 494.52808f, -24.05681f, 488.73798f, -42.09325f);
generalPath.curveTo(487.49442f, -44.3725f, 486.95523f, -48.89571f, 484.10257f, -49.38335f);
generalPath.curveTo(480.14734f, -45.612f, 484.1772f, -39.91343f, 484.01218f, -35.36136f);
generalPath.curveTo(486.3222f, -24.89303f, 488.87384f, -14.47675f, 489.88312f, -3.755f);
generalPath.curveTo(495.2968f, 35.56677f, 495.05804f, 75.55277f, 502.40793f, 114.61144f);
generalPath.curveTo(504.58386f, 120.5414f, 506.29578f, 129.08542f, 513.12024f, 131.08038f);
generalPath.curveTo(521.518f, 126.30351f, 524.29865f, 115.87497f, 526.7172f, 107.16117f);
generalPath.curveTo(528.38666f, 102.41935f, 528.59283f, 96.01678f, 532.1773f, 92.50802f);
generalPath.curveTo(533.9239f, 99.89439f, 531.98663f, 107.96133f, 531.2068f, 115.50744f);
generalPath.curveTo(529.77606f, 122.05436f, 529.1502f, 129.62822f, 526.99f, 135.55403f);
generalPath.curveTo(527.23755f, 136.54231f, 525.53625f, 137.59436f, 526.2494f, 138.61153f);
generalPath.curveTo(522.8102f, 148.59288f, 516.93787f, 159.7514f, 505.85077f, 162.78923f);
generalPath.curveTo(494.56143f, 165.82274f, 483.6438f, 160.21347f, 474.78418f, 153.70238f);
generalPath.curveTo(472.5389f, 153.05354f, 473.02353f, 158.03198f, 472.30212f, 159.46056f);
generalPath.curveTo(471.01996f, 169.13441f, 471.80566f, 179.07233f, 468.83252f, 188.50362f);
generalPath.curveTo(466.72314f, 196.33888f, 463.84918f, 205.27545f, 460.24362f, 211.87572f);
generalPath.curveTo(460.15594f, 213.76527f, 458.94308f, 216.58284f, 462.1181f, 216.98688f);
generalPath.curveTo(472.49887f, 221.19237f, 484.41174f, 221.35709f, 494.98935f, 217.6339f);
generalPath.curveTo(508.32117f, 212.00044f, 519.5278f, 201.80751f, 525.7622f, 188.68282f);
generalPath.curveTo(526.904f, 185.24593f, 530.2266f, 183.0922f, 530.0348f, 179.5912f);
generalPath.curveTo(531.399f, 175.55684f, 532.54266f, 171.29704f, 534.01685f, 167.45953f);
generalPath.curveTo(539.1721f, 142.96288f, 539.99054f, 117.22608f, 538.2322f, 92.1203f);
generalPath.curveTo(535.938f, 52.5576f, 530.7992f, 13.20394f, 525.2354f, -26.01336f);
generalPath.curveTo(523.28723f, -35.80801f, 522.93665f, -46.7958f, 516.8565f, -55.09555f);
generalPath.curveTo(516.47394f, -55.40125f, 516.01166f, -55.79466f, 515.48157f, -55.72354f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
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
		return 614.0608520507812;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 614.0608520507812;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private Groovy_logo() {
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
       Groovy_logo base = new Groovy_logo();
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
       Groovy_logo base = new Groovy_logo();
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
        return Groovy_logo::new;
    }
}

