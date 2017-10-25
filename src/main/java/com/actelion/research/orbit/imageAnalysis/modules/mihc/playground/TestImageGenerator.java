/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
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

package com.actelion.research.orbit.imageAnalysis.modules.mihc.playground;

import com.actelion.research.orbit.imageAnalysis.modules.mihc.MihcConfigData;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestImageGenerator {

    private double[][] matrix;  // S,N (signal x filter)
    private double[] gain;
    private String[] channelNames;
    private int numCells = 250;
    private double cellRadius = 10;
    private Random rand;
    private List<Arc2D>[] concentrations;
    private double[][] signals;
    private int sizeC;
    private int width;
    private int height;

    public TestImageGenerator(double[][] matrix, double[] gain, String[] channelNames, int width, int height) {
        this.matrix = matrix;
        this.gain = gain;
        this.channelNames = channelNames;
        this.rand = new Random();
        this.sizeC = channelNames.length;
        this.width = width;
        this.height = height;
        this.concentrations = new List[sizeC];
        this.signals = new double[sizeC][numCells];


        // generate concentrations
        for (int s=0; s<sizeC; s++) {
             concentrations[s] = new ArrayList<>(numCells);
            for (int i=0; i<numCells; i++) {
                int x = rand.nextInt((int)(width-cellRadius));
                int y = rand.nextInt((int)(height-cellRadius));
                Arc2D p = new Arc2D.Double(Arc2D.CHORD);
                p.setArcByCenter(x, y, cellRadius, 0d, 360d, Arc2D.CHORD);
                concentrations[s].add(p);
                double density = (rand.nextGaussian() * 100d) + 100;
                signals[s][i] = density;
            }
        }
    }

    /**
     * s = signal/fluorofore, n = filterset
     */
    public BufferedImage generateImage(int s, int n) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g = bi.createGraphics();
        for (int i = 0; i < numCells; i++) {
            double intensity = signals[s][i];
            intensity = intensity / 255d;
            if (intensity < 0) intensity = 0;
            if (intensity > 1) intensity = 1;
            intensity *= matrix[s][n];
            intensity *= 255;
            Color col = new Color((int)(intensity),(int)(intensity),(int)(intensity));
            g.setColor(col);
            //if (n==1 && s==0) System.out.println(col+" "+intensity);
           // g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,(float)(intensity/255d)));
            Arc2D p = concentrations[s].get(i);
            int offsX = n*2;
            int offsY = n*4;
            g.fillArc((int) p.getX()+offsX, (int) p.getY()+offsY, (int) p.getWidth(), (int) p.getHeight(), 0, 360);
        }
        g.dispose();
        return bi;
    }

    public void generateAllImages(String dir) throws IOException {
        for (int s=0; s<sizeC; s++) {
            for (int n=0; n<sizeC; n++) {
                BufferedImage img = generateImage(s,n);
                ImageIO.write(img,"png", new File(dir + File.separator + "img" + s + "x" + n + ".png"));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        MihcConfigData conf = new MihcConfigData();
        TestImageGenerator gen = new TestImageGenerator(conf.Asn3,conf.normGain3,conf.channelNames3,512,512);
        gen.generateAllImages("D:\\pic\\Hamamatsu\\mihc\\gen");
//        BufferedImage img = gen.generateImage(0,1);
//        ImageIO.write(img,"png",new File("d:/test.png"));
    }


}
