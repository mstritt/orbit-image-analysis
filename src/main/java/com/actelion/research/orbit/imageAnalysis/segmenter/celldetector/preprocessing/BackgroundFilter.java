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

package com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.preprocessing;


import com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.imageprocessing.UnsharpMaskFilter;
import com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.imageprocessing.ccl.CCL;
import com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.imageprocessing.ccl.Pixel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

/**
 * The BackgroundFilter class implements the logic to separate the background of tissue section
 * images from the cells. This is done by recognizing the used Staining on such an image and then
 * removing all regions which are colorized with a color which does not belong to the found staining
 * color.
 *
 * The Staining color can be detected automatically or it can be set manually with a StainingColor
 * enum structure.
 *
 * Currently the following staining colorizations are supported - BLUE - GREEN - RED - WHITE
 *
 * @author Remo, Banjamin
 * @version 1.0
 */
public class BackgroundFilter {
  private final static int STAINING_RECOGNITION_MINIMAL_DIFFERENCE = 40;
  private final static int STAINING_CLASSIFICATION_MINIMAL_DISTANCE = 7;
  private final static float UNSHARPMASK_FILTER_INTENSITY = 0.3f;
  private final static int UNSHARPMASK_FILTER_RADIUS = 64;
  private final static int UNSHARPMASK_FILTER_THRESHOLD = 0;
  private final static int MINIMAL_OBJECT_SIZE = 40;
  // private final static Color BAKGROUND_COLOR = Color.WHITE;

  private BufferedImage inputImage;

  /**
   * Initializes the Background filter for the given input image
   *
   * @param inputImage
   */
  public BackgroundFilter(BufferedImage inputImage) {
    this.inputImage = inputImage;
  }

  /**
   * Evaluates, which Staining was used in the Cell image. This is done by
   *
   * Calculating the average over each color channel. The Analysis of different histograms has
   * shown, that this is a good way. (At least, it worked for all tested images)
   *
   * Important: The Colors are only added, if a minimum distance in a color channel is reached. This
   * is, because one of the images was recognized wrong. The background had more red than the cells
   * blue in it. This helps to prevent the wrong recognition of the staining color by just taking
   * regions into account, where the color has intense changes in it.
   *
   * @return the recognized staining color
   */
  public StainingColor recognizeCellStaining() {
    int count = 0;
    int red = 0;
    int blue = 0;
    int green = 0;

    for (int y = 0; y < inputImage.getHeight(); ++y) {
      for (int x = 0; x < inputImage.getWidth(); ++x) {
        Color c = new Color(inputImage.getRGB(x, y));

        if (Math.abs(c.getRed() - c.getBlue()) > STAINING_RECOGNITION_MINIMAL_DIFFERENCE
            || Math.abs(c.getGreen() - c.getBlue()) > STAINING_RECOGNITION_MINIMAL_DIFFERENCE
            || Math.abs(c.getGreen() - c.getRed()) > STAINING_RECOGNITION_MINIMAL_DIFFERENCE) {

          red += c.getRed();
          blue += c.getBlue();
          green += c.getGreen();

          ++count;
        }
      }
    }

    // Calculate average value of each color channel
    if (count <= 0) {
      count = 1;
    }
    red /= count;
    blue /= count;
    green /= count;

    // Set staining according to the average values
    if (Math.abs(red - blue) < 5 && Math.abs(red - green) < 5 && Math.abs(green - blue) < 5) {
      return StainingColor.BLACK_WHITE;
    } else if (red > blue && red > green) {
      return StainingColor.RED;
    } else if (blue > red && blue > green) {
      return StainingColor.BLUE;
    } else if (green > red && green > blue) {
      return StainingColor.GREEN;
    }

    return StainingColor.UNKNOWN;
  }

  /**
   * Extracts all cell colored regions from the image. The image is set to white
   *
   * @param staining
   *          used cell staining color in the image
   * @return extracted cell picture
   */
  public BufferedImage createBgMask(StainingColor staining) {
    BufferedImage cellsImage = filterBackground(inputImage, staining);
    return removeSmallObjects(cellsImage, MINIMAL_OBJECT_SIZE);
  }

  /**
   * Filters the background from the image and returns an image which only contains regions which
   * belong to the giving staining color
   *
   * @param source
   *          image
   * @param staining
   *          staining color of the cells
   * @return Image which only contains the cell colored regions
   */
  private BufferedImage filterBackground(BufferedImage source, StainingColor staining) {
    UnsharpMaskFilter filter = new UnsharpMaskFilter(UNSHARPMASK_FILTER_INTENSITY,
        UNSHARPMASK_FILTER_RADIUS, UNSHARPMASK_FILTER_THRESHOLD);
    BufferedImage sharpenedSource = new BufferedImage(source.getWidth(), source.getHeight(),
        source.getType());
    BufferedImage target = new BufferedImage(source.getWidth(), source.getHeight(),
        BufferedImage.TYPE_BYTE_BINARY);

    // Apply unsharp mask filter to the input image
    filter.filter(source, sharpenedSource);

    for (int y = 0; y < source.getHeight(); ++y) {
      for (int x = 0; x < source.getWidth(); ++x) {
        Color c_sharpened = new Color(sharpenedSource.getRGB(x, y));

        if (belongsToStaining(staining, c_sharpened, STAINING_CLASSIFICATION_MINIMAL_DISTANCE)) {
          target.setRGB(x, y, Color.WHITE.getRGB());
        } else {
          target.setRGB(x, y, Color.BLACK.getRGB());
        }
      }
    }

    return target;
  }

  /**
   * Removes all small objects from an image. An object is classifies as to small, if it consists of
   * less pixels than the second parameter defines.
   *
   * @param source
   *          source image
   * @param minimalObjectSize
   *          minimal size of an object
   * @return image where all small objects are filtered out
   */
  private BufferedImage removeSmallObjects(BufferedImage source, int minimalObjectSize) {
    BufferedImage target = new BufferedImage(source.getWidth(), source.getHeight(),
        source.getType());

    // target.getGraphics().setColor(Color.BLACK);
    // target.getGraphics().fillRect(0, 0, source.getWidth(), source.getHeight());
    // target.getGraphics().dispose();

    // Remove small noise
    CCL ccl = new CCL();
    Map<Integer, List<Pixel>> output = ccl.ProcessPixel(source, Color.BLACK.getRGB());

    for (List<Pixel> pixelList : output.values()) {
      if (pixelList.size() > minimalObjectSize) {
        for (Pixel px : pixelList) {
          target.setRGB(px.x, px.y, px.color);
        }
      }
    }

    return target;
  }

  /**
   * Returns, if a Color belongs to a given staining.
   *
   * Tests have shown, that the check of red < 218 and green < 218 for the blue staining helps to
   * reduce unnecessary noise. The same does apply for the green color where the absolute difference
   * between the channels green and blue as wall as green and red must be smaller than 8
   *
   * @param staining
   *          staining Color
   * @param color
   *          Color to check
   * @param minDistance
   *          minimal distance for the staining color in comparison to the other channels
   * @return True if the color belongs to the staining, otherwise false
   */
  private boolean belongsToStaining(StainingColor staining, Color color, int minDistance) {
    int red = color.getRed();
    int green = color.getGreen();
    int blue = color.getBlue();

    switch (staining) {
    case BLUE:
      return (blue > red + minDistance && blue > green + minDistance && red < 218 && green < 218);

    case RED:
      return (red > blue + minDistance && red > green + minDistance);

    case BLACK_WHITE:
      return (red > 35 && blue > 35 && green > 35);

    case GREEN:
      return ((green > blue + minDistance || Math.abs(green - blue) < 8)
          && (green > red + minDistance || Math.abs(green - red) < 8));

    case UNKNOWN:
      return false;
    }

    return false;
  }
}
