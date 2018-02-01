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

package com.actelion.research.orbit.imageAnalysis.modules.mihc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;

/**
 * Image registration with simple translation model.
 * Determines the translate vector u,v to minimize the cross-correlation.
 */
public class RegistrationTrans {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationTrans.class);
    private static final float eps = 0.000001f;

    /**
     * computes the normalized cross correlation (see https://de.wikipedia.org/wiki/Bildregistrierung)
     */
    private double correlation(final float[][] f, final float[][] g, final int u, final int v) {
          double n = 0d;
          double d1 = 0d;
          double d2 = 0d;
          int minX = u<0?u*-1:0;
          int minY = v<0?v*-1:0;
          int maxX = u>0?f.length-u: f.length;
          int maxY = v>0?f[0].length-v: f[0].length;
          for (int x=minX; x<maxX; x++) {
              for (int y=minY; y<maxY; y++) {
                  n += f[x][y] * g[x+u][y+v];
                  d1 += f[x][y] * f[x][y];
                  d2 += g[x+u][y+v] * g[x+u][y+v];
              }
          }
          if (d1>eps)
            d1 = Math.sqrt(d1);
          if (d2>eps)
            d2 = Math.sqrt(d2);
          double d = d1*d2;
          if (d>eps)
              return n/d;
          else
              return 0d;
    }

    private float[][] raster2float(Raster r) {
        r = r.createTranslatedChild(0,0);
        float[][] f = new float[r.getWidth()][r.getHeight()];
        for (int x=0; x<r.getWidth(); x++) {
            for (int y=0; y<r.getHeight(); y++) {
                f[x][y] = 0;
                for (int b=0; b<r.getNumBands(); b++) {
                    f[x][y] += r.getSample(x,y,b);
                }
            }
        }
        return f;
    }

    public Point findBestOffset(Raster r1, Raster r2, int searchX, int searchY) {
        float[][] f = raster2float(r1);
        float[][] g = raster2float(r2);
        int bestU = 0;
        int bestV = 0;
        double bestCC = 0d;
        for (int u=-searchX; u<searchX; u++)
            for (int v=-searchY; v<searchY; v++) {
                double cc = correlation(f, g, u, v);
                if (cc>bestCC) {
                    bestCC = cc;
                    bestU = u;
                    bestV = v;
                }
            }
        logger.info("best cc: "+bestCC);
        Point uv = new Point(bestU, bestV);
        return uv;
    }

    /**
     * Merges img1 and img2 with img2 translated by u,v.
     * Attention: img1 will be reused!
     */
    public BufferedImage mergeImg(BufferedImage img1, BufferedImage img2, int u, int v) {
        int minX = u<0?u*-1:0;
        int minY = v<0?v*-1:0;
        int maxX = u>0?img1.getWidth()-u: img1.getWidth();
        int maxY = v>0?img1.getHeight()-v: img1.getHeight();
        for (int x=minX; x<maxX; x++) {
            for (int y = minY; y < maxY; y++) {
                 img1.setRGB(x,y,img1.getRGB(x,y)+img2.getRGB(x+u,y+v));
            }
        }
        return img1;
    }

    public static void main(String[] args) throws  Exception {
        BufferedImage img1 = ImageIO.read(new File("D:\\pic\\registration\\red.png"));
        BufferedImage img2 = ImageIO.read(new File("D:\\pic\\registration\\green.png"));
        RegistrationTrans reg = new RegistrationTrans();
        float[][] f = reg.raster2float(img1.getRaster());
        float[][] g = reg.raster2float(img2.getRaster());
        int bestU = 0;
        int bestV = 0;
        double bestCC = 0d;
        int diff = 100;
        for (int u=-diff; u<diff; u++)
            for (int v=-diff; v<diff; v++) {
                double cc = reg.correlation(f, g, u, v);
                //System.out.println(u + "," + v + ": " + cc);
                if (cc>bestCC) {
                    bestCC = cc;
                    bestU = u;
                    bestV = v;
                }
            }
        System.out.println("bestUV: "+bestU+","+bestV+": "+bestCC);
        BufferedImage merged = reg.mergeImg(img1,img2,bestU,bestV);
        ImageIO.write(merged,"png",new File("d:/test.png"));
    }

}
