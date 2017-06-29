/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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

package com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.imageprocessing.ccl;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.List;

public class ImageObject {
  private int x;
  private int y;
  private BufferedImage image;
  private List<Pixel> pixels;

  public ImageObject(BufferedImage image, int x, int y, List<Pixel> pixels) {
    this.image = image;
    this.x = x;
    this.y = y;
    this.pixels = pixels;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public List<Pixel> getPixels() {
    return Collections.unmodifiableList(pixels);
  }

  public Rectangle getBoundings() {
    return new Rectangle(x, y, image.getWidth(), image.getHeight());
  }

  public BufferedImage getImage() {
    return image;
  }

  public int getArea() {
    return pixels.size();
  }

  public boolean contains(Point p) {
    if (!(p.x >= x && p.y >= y && (p.x < (x + image.getWidth()))
        && (p.y < (y + image.getHeight())))) {
      return false;
    }
    return true;
    // return new Color(image.getRGB(p.x - x, p.y - y)).getAlpha() > 0;
  }

  public int getColorFromGlobalCoordinates(int x, int y) {
    return image.getRGB(x - this.x, y - this.y);
  }

  public int getColorFromLocalCoordinates(int x, int y) {
    return image.getRGB(x, y);
  }

  public ColorStatistics calcStat() {
    return new ColorStatistics(pixels);
  }

  public static class ColorStatistics {
    private int minR;
    private int maxR;
    private double avgR;
    private double stdevR;
    private int minG;
    private int maxG;
    private double avgG;
    private double stdevG;
    private int minB;
    private int maxB;
    private double avgB;
    private double stdevB;
    private int count;

    public int getMinR() {
      return minR;
    }

    public int getMaxR() {
      return maxR;
    }

    public double getAvgR() {
      return avgR;
    }

    public double getStandardDeviationR() {
      return stdevR;
    }

    public int getMinG() {
      return minG;
    }

    public double getAvgG() {
      return avgG;
    }

    public int getMaxG() {
      return maxG;
    }

    public double getStandardDeviationG() {
      return stdevG;
    }

    public int getMinB() {
      return minB;
    }

    public int getMaxB() {
      return maxB;
    }

    public double getAvgB() {
      return avgB;
    }

    public double getStandardDeviationB() {
      return stdevB;
    }

    public ColorStatistics(List<Pixel> pixels) {
      calculate(pixels);
    }

    public int getCount() {
      return count;
    }

    private void calculate(List<Pixel> pixels) {
      count = 0;
      int sumR = 0;
      int sumG = 0;
      int sumB = 0;
      for (Pixel pixel : pixels) {
        Color c = new Color(pixel.color);
        if (count == 0) {
          minR = maxR = c.getRed();
          minG = maxG = c.getGreen();
          minB = maxB = c.getBlue();
        } else {
          minR = Math.min(minR, c.getRed());
          minG = Math.min(minG, c.getGreen());
          minB = Math.min(minB, c.getBlue());
          maxR = Math.max(maxR, c.getRed());
          maxG = Math.max(maxG, c.getGreen());
          maxB = Math.max(maxB, c.getBlue());
        }
        sumR += c.getRed();
        sumG += c.getGreen();
        sumB += c.getBlue();
        count++;
      }
      avgR = sumR * 1.0 / count;
      avgG = sumG * 1.0 / count;
      avgB = sumB * 1.0 / count;
      stdevR = 0;
      stdevG = 0;
      stdevB = 0;
      for (Pixel pixel : pixels) {
        Color c = new Color(pixel.color);
        stdevR += Math.pow(c.getRed() - avgR, 2);
        stdevG += Math.pow(c.getGreen() - avgG, 2);
        stdevB += Math.pow(c.getBlue() - avgB, 2);
      }
      stdevR = Math.sqrt(stdevR / count);
      stdevG = Math.sqrt(stdevG / count);
      stdevB = Math.sqrt(stdevB / count);
    }

  }
}
