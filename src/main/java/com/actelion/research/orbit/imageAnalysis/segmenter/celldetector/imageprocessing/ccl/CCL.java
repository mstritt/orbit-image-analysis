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


import com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.imageprocessing.ImageFunctions;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CCL {
  private int[][] _board;
  private BufferedImage _input;
  private Graphics inputGD;
  private int _width;
  private int _height;
  private int backgroundColor;

  public List<ImageObject> Process(BufferedImage input, int bgColor, int shrink) {

    /* If required: Shrink the image. */
    if (shrink > 0) {
      input = shrinkImage(input, bgColor, shrink);
    }

    /* Prepare everything. */
    backgroundColor = bgColor;
    _input = input;
    _width = input.getWidth();
    _height = input.getHeight();
    _board = new int[_width][];
    for (int i = 0; i < _width; i++)
      _board[i] = new int[_height];

    Map<Integer, List<Pixel>> patterns = Find();
    List<ImageObject> images = new ArrayList<ImageObject>();
    for (Integer id : patterns.keySet()) {
      List<Pixel> pattern = patterns.get(id);
      BufferedImage bmp = CreateBitmap(pattern, false);

      int minX = Min(pattern, true);
      int minY = Min(pattern, false);
      images.add(new ImageObject(bmp, minX, minY, pattern));
    }
    return images;
  }

  public Map<Integer, BufferedImage> Process(BufferedImage input, int bgColor) {
    backgroundColor = bgColor;
    _input = input;
    _width = input.getWidth();
    _height = input.getHeight();
    _board = new int[_width][];
    for (int i = 0; i < _width; i++)
      _board[i] = new int[_height];

    Map<Integer, List<Pixel>> patterns = Find();
    Map<Integer, BufferedImage> images = new HashMap<Integer, BufferedImage>();

    inputGD = _input.getGraphics();
    inputGD.setColor(Color.BLUE);
    for (Integer id : patterns.keySet()) {
      BufferedImage bmp = CreateBitmap(patterns.get(id));
      images.put(id, bmp);
    }
    inputGD.dispose();

    return images;
  }

  public Map<Integer, List<Pixel>> ProcessPixel(BufferedImage input, int bgColor) {
    backgroundColor = bgColor;
    _input = ImageFunctions.copyImage(input);
    _width = input.getWidth();
    _height = input.getHeight();
    _board = new int[_width][];
    for (int i = 0; i < _width; i++)
      _board[i] = new int[_height];

    Map<Integer, List<Pixel>> patterns = Find();
    Map<Integer, BufferedImage> images = new HashMap<Integer, BufferedImage>();

    inputGD = _input.getGraphics();
    inputGD.setColor(Color.BLUE);
    for (Integer id : patterns.keySet()) {
      BufferedImage bmp = CreateBitmap(patterns.get(id));
      images.put(id, bmp);
    }
    inputGD.dispose();

    return patterns;
  }

  protected boolean CheckIsBackGround(Pixel currentPixel) {
    // check if pixel color is backgroundColor (white).
    // return currentPixel.color.getAlpha() == 255 && currentPixel.color.getRed() == 255 &&
    // currentPixel.color.getGreen() == 255 && currentPixel.color.getBlue() == 255;
    return currentPixel.color == backgroundColor;
  }

  private static int Min(List<Integer> neighboringLabels, Map<Integer, Label> allLabels) {
    if (neighboringLabels.isEmpty())
      return 0; // TODO: is 0 appropriate for empty list

    int ret = allLabels.get(neighboringLabels.get(0)).GetRoot().name;
    for (Integer n : neighboringLabels) {
      int curVal = allLabels.get(n).GetRoot().name;
      ret = (ret < curVal ? ret : curVal);
    }
    return ret;
  }

  private static int Min(List<Pixel> pattern, boolean xOrY) {
    if (pattern.isEmpty())
      return 0; // TODO: is 0 appropriate for empty list

    int ret = (xOrY ? pattern.get(0).x : pattern.get(0).y);
    for (Pixel p : pattern) {
      int curVal = (xOrY ? p.x : p.y);
      ret = (ret < curVal ? ret : curVal);
    }
    return ret;
  }

  private static int Max(List<Pixel> pattern, boolean xOrY) {
    if (pattern.isEmpty())
      return 0; // TODO: is 0 appropriate for empty list

    int ret = (xOrY ? pattern.get(0).x : pattern.get(0).y);
    for (Pixel p : pattern) {
      int curVal = (xOrY ? p.x : p.y);
      ret = (ret > curVal ? ret : curVal);
    }
    return ret;
  }

  private Map<Integer, List<Pixel>> Find() {
    int labelCount = 1;
    Map<Integer, Label> allLabels = new HashMap<Integer, Label>();

    for (int i = 0; i < _height; i++) {
      for (int j = 0; j < _width; j++) {
        Pixel currentPixel = new Pixel(j, i, _input.getRGB(j, i));

        if (CheckIsBackGround(currentPixel)) {
          continue;
        }

        List<Integer> neighboringLabels = GetNeighboringLabels(currentPixel);
        int currentLabel;

        if (neighboringLabels.isEmpty()) {
          currentLabel = labelCount;
          allLabels.put(currentLabel, new Label(currentLabel));
          labelCount++;
        } else {
          currentLabel = Min(neighboringLabels, allLabels);
          Label root = allLabels.get(currentLabel).GetRoot();

          for (Integer neighbor : neighboringLabels) {
            if (root.name != allLabels.get(neighbor).GetRoot().name) {
              allLabels.get(neighbor).Join(allLabels.get(currentLabel));
            }
          }
        }

        _board[j][i] = currentLabel;
      }
    }

    Map<Integer, List<Pixel>> patterns = AggregatePatterns(allLabels);

    return patterns;
  }

  private List<Integer> GetNeighboringLabels(Pixel pix) {
    List<Integer> neighboringLabels = new ArrayList<Integer>();

    for (int i = pix.y - 1; i <= pix.y + 2 && i < _height - 1; i++) {
      for (int j = pix.x - 1; j <= pix.x + 2 && j < _width - 1; j++) {
        if (i > -1 && j > -1 && _board[j][i] != 0) {
          if (i == pix.y || j == pix.x)
            neighboringLabels.add(_board[j][i]);
        }
      }
    }

    return neighboringLabels;
  }

  private Map<Integer, List<Pixel>> AggregatePatterns(Map<Integer, Label> allLabels) {
    Map<Integer, List<Pixel>> patterns = new HashMap<Integer, List<Pixel>>();

    for (int i = 0; i < _height; i++) {
      for (int j = 0; j < _width; j++) {
        int patternNumber = _board[j][i];

        if (patternNumber != 0) {
          patternNumber = allLabels.get(patternNumber).GetRoot().name;

          if (!patterns.containsKey(patternNumber)) {
            patterns.put(patternNumber, new ArrayList<Pixel>());
          }

          patterns.get(patternNumber).add(new Pixel(j, i, _input.getRGB(j, i)));
        }
      }
    }

    return patterns;
  }

  private BufferedImage CreateBitmap(List<Pixel> pattern, boolean drawBoundings) {
    int minX = Min(pattern, true);
    int maxX = Max(pattern, true);

    int minY = Min(pattern, false);
    int maxY = Max(pattern, false);

    int width = maxX + 1 - minX;
    int height = maxY + 1 - minY;

    BufferedImage bmp = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

    // Paint all white
    Graphics2D g = bmp.createGraphics();
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, width, height);
    g.dispose();

    for (Pixel pix : pattern) {
      bmp.setRGB(pix.x - minX, pix.y - minY, pix.color); // shift position by minX and minY
    }

    if (drawBoundings) {
      inputGD.drawRect(minX, minY, maxX - minX, maxY - minY);
    }

    return bmp;
  }

  private BufferedImage CreateBitmap(List<Pixel> pattern) {
    return CreateBitmap(pattern, true);
  }

  private BufferedImage shrinkImage(BufferedImage input, int bgColor, int shrink) {
    BufferedImage result = copyImage(input);
    for (int x = 0; x < input.getWidth(); x++) {
      for (int y = 0; y < input.getHeight(); y++) {
        if (input.getRGB(x, y) == bgColor) {
          setNeighborsTo(result, new Point(x, y), shrink, bgColor);
        }
      }
    }
    return result;
  }

  private void setNeighborsTo(BufferedImage input, Point p, int range, int color) {
    int minX = Math.max(0, p.x - range);
    int minY = Math.max(0, p.y - range);
    int maxX = Math.min(input.getWidth(), p.x + range + 1);
    int maxY = Math.min(input.getHeight(), p.y + range + 1);
    int quadRange = range * range;
    for (int x = minX; x < maxX; x++) {
      for (int y = minY; y < maxY; y++) {
        int dx = p.x - x;
        int dy = p.y - y;
        if ((dx * dx + dy * dy) <= quadRange) {
          input.setRGB(x, y, color);
        }
      }
    }
  }

  private static BufferedImage copyImage(BufferedImage input) {
    BufferedImage result = new BufferedImage(input.getWidth(), input.getHeight(), input.getType());
    for (int x = 0; x < input.getWidth(); x++) {
      for (int y = 0; y < input.getHeight(); y++) {
        result.setRGB(x, y, input.getRGB(x, y));
      }
    }
    return result;
  }

  public static String getBaseFileName(String fileName) {
    return fileName.substring(0, fileName.indexOf('.'));
  }

  public static String getFileNameExtension(String fileName) {
    return fileName.substring(fileName.indexOf('.') + 1);
  }

  public BufferedImage getProcessedImage() {
    return _input;
  }
}
