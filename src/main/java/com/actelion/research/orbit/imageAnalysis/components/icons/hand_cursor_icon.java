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
public class hand_cursor_icon implements ResizableIcon {
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
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, -418.5848388671875f, -353.3216247558594f));
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
generalPath.moveTo(419.7945f, 392.4999f);
generalPath.lineTo(429.85867f, 407.27744f);
generalPath.lineTo(432.37473f, 415.76666f);
generalPath.lineTo(436.7778f, 420.16846f);
generalPath.lineTo(436.1488f, 426.77118f);
generalPath.lineTo(464.4543f, 426.14233f);
generalPath.lineTo(464.76883f, 418.91077f);
generalPath.lineTo(468.8574f, 417.02426f);
generalPath.lineTo(468.5429f, 409.1639f);
generalPath.lineTo(471.68796f, 406.33414f);
generalPath.lineTo(472.94598f, 386.526f);
generalPath.lineTo(463.1963f, 379.92328f);
generalPath.lineTo(458.4787f, 376.4647f);
generalPath.lineTo(452.50308f, 376.4647f);
generalPath.lineTo(448.41452f, 373.63495f);
generalPath.lineTo(441.80988f, 372.3773f);
generalPath.lineTo(441.18088f, 359.48627f);
generalPath.lineTo(438.97934f, 356.97095f);
generalPath.lineTo(434.57623f, 356.97095f);
generalPath.lineTo(432.3747f, 360.4295f);
generalPath.lineTo(432.0602f, 389.9846f);
generalPath.lineTo(429.22964f, 390.29898f);
generalPath.lineTo(425.4556f, 386.21158f);
generalPath.lineTo(420.4235f, 386.52603f);
generalPath.lineTo(419.7945f, 392.4999f);
generalPath.closePath();
shape = generalPath;
paint = new Color(255, 255, 255, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(3.1078295707702637f, 0.0f, 0.0f, 3.3585445880889893f, -477.94427490234375f, -1101.2645263671875f));
// _0_0_1
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_0
shape = new Rectangle2D.Double(293.82684326171875, 434.5367736816406, 1.0, 13.070158958435059);
paint = new Color(180, 180, 180, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f));
// _0_0_1_1
shape = new Rectangle2D.Double(433.5704650878906, 294.8509826660156, 1.0, 2.0);
paint = new Color(180, 180, 180, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_2
shape = new Rectangle2D.Double(296.8240966796875, 434.6076354980469, 1.0, 8.951157569885254);
paint = new Color(180, 180, 180, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_3
shape = new Rectangle2D.Double(299.77734375, 439.54266357421875, 1.0, 4.054986000061035);
paint = new Color(180, 180, 180, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_4
shape = new Rectangle2D.Double(302.8062438964844, 440.5307312011719, 1.0, 4.288136959075928);
paint = new Color(180, 180, 180, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_5
shape = new Rectangle2D.Double(305.83929443359375, 442.5736389160156, 1.0, 7.008232116699219);
paint = new Color(180, 180, 180, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_6
shape = new Rectangle2D.Double(304.8289794921875, 449.60699462890625, 1.0, 3.1223816871643066);
paint = new Color(180, 180, 180, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_7
shape = new Rectangle2D.Double(303.8186340332031, 452.56024169921875, 1.0, 2.9669477939605713);
paint = new Color(180, 180, 180, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_8
shape = new Rectangle2D.Double(294.803466796875, 452.6379699707031, 1.0, 2.9669477939605713);
paint = new Color(180, 180, 180, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_9
shape = new Rectangle2D.Double(293.8482666015625, 450.41717529296875, 1.0, 2.178999900817871);
paint = new Color(180, 180, 180, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_10
shape = new Rectangle2D.Double(292.8605651855469, 448.5743103027344, 1.0, 1.9789999723434448);
paint = new Color(180, 180, 180, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_11
shape = new Rectangle2D.Double(291.8502197265625, 446.6261901855469, 1.0, 1.9789999723434448);
paint = new Color(180, 180, 180, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_12
shape = new Rectangle2D.Double(290.9176330566406, 445.51568603515625, 1.0, 1.124112844467163);
paint = new Color(180, 180, 180, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_13
shape = new Rectangle2D.Double(289.9073181152344, 442.7178649902344, 1.0, 2.7561700344085693);
paint = new Color(180, 180, 180, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f));
// _0_0_1_14
shape = new Rectangle2D.Double(-443.58563232421875, -292.7179870605469, 1.0, 2.7561700344085693);
paint = new Color(180, 180, 180, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_15
shape = new Rectangle2D.Double(292.76019287109375, 443.5339050292969, 1.100000023841858, 1.124112844467163);
paint = new Color(180, 180, 180, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.0f, 1.0f, -1.0f, 0.0f, 0.0f, 0.0f));
// _0_0_1_16
shape = new Rectangle2D.Double(454.5540466308594, -304.1700744628906, 1.0, 9.10659122467041);
paint = new Color(180, 180, 180, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_17
shape = new Rectangle2D.Double(304.8289794921875, 441.6686706542969, 1.0, 1.124112844467163);
paint = new Color(180, 180, 180, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_18
shape = new Rectangle2D.Double(303.1968994140625, 440.5029296875, 1.6217360496520996, 1.124112844467163);
paint = new Color(180, 180, 180, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_19
shape = new Rectangle2D.Double(300.476806640625, 439.49261474609375, 2.3989062309265137, 1.124112844467163);
paint = new Color(180, 180, 180, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_1_20
shape = new Rectangle2D.Double(297.4458312988281, 438.4822998046875, 2.3989062309265137, 1.124112844467163);
paint = new Color(180, 180, 180, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_2
shape = new Rectangle2D.Double(431.4183044433594, 358.4308776855469, 3.2742371559143066, 42.78249740600586);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f));
// _0_0_3
shape = new Rectangle2D.Double(355.26788330078125, 434.7715759277344, 3.2732961177825928, 6.548474311828613);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_4
shape = new Rectangle2D.Double(441.2320251464844, 358.662841796875, 3.2742371559143066, 29.299787521362305);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_5
shape = new Rectangle2D.Double(450.9016418457031, 374.816650390625, 3.2742371559143066, 13.273170471191406);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_6
shape = new Rectangle2D.Double(460.8190002441406, 378.0508728027344, 3.2742371559143066, 14.036341667175293);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_7
shape = new Rectangle2D.Double(470.7499084472656, 384.7379150390625, 3.2742371559143066, 22.940017700195312);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_8
shape = new Rectangle2D.Double(467.44189453125, 407.7601623535156, 3.2742371559143066, 10.220479011535645);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_9
shape = new Rectangle2D.Double(464.1337890625, 417.4270324707031, 3.2742371559143066, 9.711698532104492);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_10
shape = new Rectangle2D.Double(434.6159973144531, 417.68145751953125, 3.2742371559143066, 9.711698532104492);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_11
shape = new Rectangle2D.Double(431.4884338378906, 410.4121398925781, 3.2742371559143066, 7.132511615753174);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_12
shape = new Rectangle2D.Double(428.2544860839844, 404.3798828125, 3.2742371559143066, 6.477852821350098);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_13
shape = new Rectangle2D.Double(424.9463806152344, 398.00311279296875, 3.2742371559143066, 6.477852821350098);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_14
shape = new Rectangle2D.Double(421.8928527832031, 394.36810302734375, 3.2742371559143066, 3.679553985595703);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_15
shape = new Rectangle2D.Double(418.5848388671875, 385.21002197265625, 3.2742371559143066, 9.021759986877441);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f));
// _0_0_16
shape = new Rectangle2D.Double(-388.05047607421875, -427.7876281738281, 3.2732961177825928, 9.024353981018066);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_17
shape = new Rectangle2D.Double(427.92584228515625, 387.88116455078125, 3.601660966873169, 3.679553985595703);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(0.0f, 1.0f, -1.0f, 0.0f, 0.0f, 0.0f));
// _0_0_18
shape = new Rectangle2D.Double(423.9533386230469, -465.28448486328125, 3.2732961177825928, 29.817138671875);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_19
shape = new Rectangle2D.Double(467.44189453125, 381.77569580078125, 3.2742371559143066, 3.679553985595703);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_20
shape = new Rectangle2D.Double(462.09808349609375, 377.9598693847656, 5.309948444366455, 3.679553985595703);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_21
shape = new Rectangle2D.Double(453.1918640136719, 374.65283203125, 7.854587554931641, 3.679553985595703);
paint = new Color(0, 0, 0, 255);
g.setPaint(paint);
g.fill(shape);
g.setTransform(transformsStack.pop());
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
transformsStack.push(g.getTransform());
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0_22
shape = new Rectangle2D.Double(443.2677307128906, 371.34576416015625, 7.854587554931641, 3.679553985595703);
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
		return 58.53676986694336;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static double getOrigHeight() {
		return 77.16290283203125;
	}

	/** The current width of this resizable icon. */
	private int width;

    /** The current height of this resizable icon. */
	private int height;

	/**
	 * Creates a new transcoded SVG image. This is marked as private to indicate that app
	 * code should be using the {@link #of(int, int)} method to obtain a pre-configured instance.
	 */
	private hand_cursor_icon() {
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
       hand_cursor_icon base = new hand_cursor_icon();
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
       hand_cursor_icon base = new hand_cursor_icon();
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
        return hand_cursor_icon::new;
    }
}

