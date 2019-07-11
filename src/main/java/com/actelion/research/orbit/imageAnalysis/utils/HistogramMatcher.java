/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2019 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
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

package com.actelion.research.orbit.imageAnalysis.utils;

import ij.ImagePlus;
import ij.process.ImageConverter;
import ij.process.ImageProcessor;
import imageJ.Colour_Deconvolution;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class HistogramMatcher {

    public static BufferedImage matchHisto(BufferedImage bi1, BufferedImage bi2) {
        int[] histo1 = getBrightnessHistogram(bi1);

        ImagePlus ip = new ImagePlus("img",bi2);
        ImageConverter ic = new ImageConverter(ip);
        ic.convertToHSB();
        ImageProcessor processor = ip.getStack().getProcessor(2); // HSB -> processor 3 = brightness
       // ic.convertToGray8();
       // ImageProcessor processor = ip.getProcessor();
        int[] histo2 = processor.getHistogram();

        int[] lut = matchHistograms(histo2, histo1);
        //System.out.println(Arrays.toString(lut));

        int c;
        for (int x=0; x<processor.getWidth(); x++)
            for (int y=0; y<processor.getHeight(); y++) {
                c = processor.get(x,y);
                if (c>18)
                    processor.set(x,y,lut[c]);
            }

        //processor.setThreshold(20,200,ImageProcessor.NO_LUT_UPDATE);
        //processor.setAutoThreshold(AutoThresholder.Method.Otsu, false,ImageProcessor.OVER_UNDER_LUT);
        //processor.applyTable(lut);

        ic.convertHSBToRGB();
        return ip.getBufferedImage();
    }

    public static BufferedImage matchHisto(BufferedImage bi2, int[] histoToMatch) {
        ImagePlus ip = new ImagePlus("img",bi2);
        ImageConverter ic = new ImageConverter(ip);
        ic.convertToHSB();
        ImageProcessor processor = ip.getStack().getProcessor(2); // HSB -> processor 2 = saturation
        // ic.convertToGray8();
        // ImageProcessor processor = ip.getProcessor();
        int[] histo2 = processor.getHistogram();

        int[] lut = matchHistograms(histo2, histoToMatch);

        int c;
        for (int x=0; x<processor.getWidth(); x++)
            for (int y=0; y<processor.getHeight(); y++) {
                c = processor.get(x,y);
                if (c>18)
                    processor.set(x,y,lut[c]);
            }

        //processor.setThreshold(20,200,ImageProcessor.NO_LUT_UPDATE);
        //processor.setAutoThreshold(AutoThresholder.Method.Otsu, false,ImageProcessor.OVER_UNDER_LUT);
        //processor.applyTable(lut);

        ic.convertHSBToRGB();
        return ip.getBufferedImage();
    }


    protected static int[] getBrightnessHistogram(BufferedImage bi1) {
        ImagePlus ip = new ImagePlus("img",bi1);
        ImageConverter ic = new ImageConverter(ip);
        ic.convertToHSB();
        ImageProcessor processor = ip.getStack().getProcessor(2); // HSB -> processor 2 = saturation
       // ic.convertToGray8();
       // ImageProcessor processor = ip.getProcessor();
        int[] histOri = processor.getHistogram();
        return histOri;
    }


    protected static int[] matchHistograms (int[] hA, int[] hR) {
        int K = hA.length;
        double[] PA = Cdf(hA); // get CDF of histogram hA
        double[] PR = Cdf(hR); // get CDF of histogram hR
        int[] F = new int[K]; // pixel mapping function f()

        // compute pixel mapping function f():
        for (int a = 0; a < K; a++) {
            int j = K - 1;
            do {
                F[a] = j;
                j--;
            } while (j >= 0 && PA[a] <= PR[j]);
        }
        return F;
    }

    protected static double[] Cdf (int[] h) {
        // returns the cumul. probability distribution function (cdf) for histogram h
        int K = h.length;
        int n = 0;		// sum all histogram values
        for (int i=0; i<K; i++)	{
            n += h[i];
        }
        double[] P = new double[K];
        int c = h[0];
        P[0] = (double) c / n;
        for (int i=1; i<K; i++) {
            c += h[i];
            P[i] = (double) c / n;
        }
        return P;
    }

    public static void main(String[] args) throws IOException {
        // D:\pic\ihc-default\alcian.png
        BufferedImage bi1 = ImageIO.read(new File("D:\\imgdark.png"));
        BufferedImage bi2 = ImageIO.read(new File("D:\\imgbright.png"));

        bi1 = Colour_Deconvolution.getProcessedImage(bi1,"Alcian blue & H",0,bi1);
        bi2 = Colour_Deconvolution.getProcessedImage(bi2,"Alcian blue & H",0,bi2);

        BufferedImage bNorm = matchHisto(bi1,bi2);
        System.out.println("norm: "+ bNorm);
        ImageIO.write(bNorm,"png",new File("d:/imgnorm.png"));
    }
}
