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

package com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.imageprocessing;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Provides Functions for different Image Manipulations. These include, the creation of an image
 * copy, the centered Drawing of an Image and further more, such as Auto Crop and resizing.
 *
 * @author Remo
 *
 */
public class ImageFunctions {
  /**
   * Copies a given Image
   *
   * @param source
   *          source image
   * @return independent duplicate of the source image
   */
  public static BufferedImage copyImage(BufferedImage source) {
    BufferedImage dest = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());

    source.getRaster().getDataBuffer();
    if (source.getRaster().getDataBuffer().getDataType() == DataBuffer.TYPE_BYTE) {
      byte[] srcbuf = ((DataBufferByte) source.getRaster().getDataBuffer()).getData();
      byte[] destbuf = ((DataBufferByte) dest.getRaster().getDataBuffer()).getData();
      System.arraycopy(srcbuf, 0, destbuf, 0, destbuf.length);
    } else {
      int[] srcbuf = ((DataBufferInt) source.getRaster().getDataBuffer()).getData();
      int[] destbuf = ((DataBufferInt) dest.getRaster().getDataBuffer()).getData();
      System.arraycopy(srcbuf, 0, destbuf, 0, destbuf.length);
    }

    return dest;
  }

  /**
   * Draws the source image centered in the destination image
   *
   * @param src
   *          source image
   * @param dest
   *          destination image
   */
  public static void drawImageCentered(BufferedImage src, BufferedImage dest) {
    Graphics g = dest.getGraphics();
    int x = (dest.getWidth() - src.getWidth()) / 2;
    int y = (dest.getHeight() - src.getHeight()) / 2;
    g.drawImage(src, x, y, null);
    g.dispose();
  }

  /***
   * Crops an Image using the top left pixel as a reference for the ignoring color. The colors can
   * have a tolerance up to 0.05
   *
   * @param source
   *          source Image
   * @return cropped Image
   */
  public static BufferedImage cropImage(BufferedImage source) {
    float tolerance = 0.05f;
    int baseColor = source.getRGB(0, 0);
    int width = source.getWidth();
    int height = source.getHeight();

    // find bottom Cropping position
    int bottomX = 0, bottomY = 0;
    boolean end = false;
    for (int y = 0; y < height && !end; ++y) {
      for (int x = 0; x < width && !end; ++x) {
        if (!colorWithinTolerance(baseColor, source.getRGB(x, y), tolerance)) {
          bottomX = x;
          bottomY = y;
          end = true;
        }
      }
    }

    // find top Cropping position
    int topX = 0, topY = height - 1;
    end = false;
    for (int y = height - 1; y >= bottomY && !end; --y) {
      for (int x = 0; x < width && !end; ++x) {
        if (!colorWithinTolerance(baseColor, source.getRGB(x, y), tolerance)) {
          topX = x;
          topY = y;
          end = true;
        }
      }
    }

    // find left Cropping position
    int leftX = 0, leftY = 0;
    end = false;
    for (int x = 0; x < width && !end; ++x) {
      for (int y = bottomY; y <= topY && !end; ++y) {
        if (!colorWithinTolerance(baseColor, source.getRGB(x, y), tolerance)) {
          leftX = x;
          leftY = y;
          end = true;
        }
      }
    }

    // find right Cropping position
    int rightX = width - 1, rightY = 0;
    end = false;
    for (int x = width - 1; x >= leftX && !end; --x) {
      for (int y = bottomY; y <= topY && !end; ++y) {
        if (!colorWithinTolerance(baseColor, source.getRGB(x, y), tolerance)) {
          rightX = x;
          rightY = y;
          end = true;
        }
      }
    }

    // Extract edges
    int[] cols = { leftX, topX, rightX, bottomX };
    int[] rows = { leftY, topY, rightY, bottomY };
    Arrays.sort(cols);
    Arrays.sort(rows);

    int leftBottomCornerX = cols[0];
    int leftBottomCornerY = rows[0];
    int rightTopCornerX = cols[cols.length - 1];
    int rightTopCornerY = rows[rows.length - 1];

    /* source.setRGB(leftX, leftY, Color.RED.getIntArgbPre()); source.setRGB(topX, topY,
     * Color.RED.getIntArgbPre()); source.setRGB(rightX, rightY, Color.RED.getIntArgbPre());
     * source.setRGB(bottomX, bottomY, Color.RED.getIntArgbPre()); source.setRGB(leftBottomCornerX,
     * leftBottomCornerY, Color.WHITE.getIntArgbPre()); source.setRGB(rightTopCornerX,
     * rightTopCornerY, Color.WHITE.getIntArgbPre()); */

    // Crop Image
    BufferedImage dest = new BufferedImage(rightTopCornerX - leftBottomCornerX + 1,
        rightTopCornerY - leftBottomCornerY + 1, source.getType());

    dest.getGraphics().drawImage(source, 0, 0, dest.getWidth(), dest.getHeight(), leftBottomCornerX,
        leftBottomCornerY, rightTopCornerX + 1, rightTopCornerY + 1, null);

    return dest;
  }

  /**
   * Checks, if a Color lies within a given tolerance The Distance is represented through the
   * euclidic distance
   *
   * @param a
   *          color A
   * @param b
   *          color B
   * @param tolerance
   *          tolerance between 0 and 1
   * @return true, if the color lies within the tolerance, otherwise false
   */
  public static boolean colorWithinTolerance(int a, int b, double tolerance) {
    int aAlpha = (a & 0xFF000000) >>> 24; // Alpha level
    int aRed = (a & 0x00FF0000) >>> 16; // Red level
    int aGreen = (a & 0x0000FF00) >>> 8; // Green level
    int aBlue = a & 0x000000FF; // Blue level

    int bAlpha = (b & 0xFF000000) >>> 24; // Alpha level
    int bRed = (b & 0x00FF0000) >>> 16; // Red level
    int bGreen = (b & 0x0000FF00) >>> 8; // Green level
    int bBlue = b & 0x000000FF; // Blue level

    double distance = Math
        .sqrt((aAlpha - bAlpha) * (aAlpha - bAlpha) + (aRed - bRed) * (aRed - bRed)
            + (aGreen - bGreen) * (aGreen - bGreen) + (aBlue - bBlue) * (aBlue - bBlue));

    // 510.0 is the maximum distance between two colors
    // (0,0,0,0 -> 255,255,255,255)
    double percentAway = distance / 510.0d;

    return (percentAway <= tolerance);
  }

  /**
   * Resizes a given image so it fits the new dimensions
   *
   * @param source
   *          image which should be resized
   * @param width
   *          new width
   * @param height
   *          new height
   * @return resized image
   */
  public static BufferedImage resizeImage(BufferedImage source, int width, int height) {
    BufferedImage dest = new BufferedImage(width, height, source.getType());
    Graphics2D g = dest.createGraphics();
    g.drawImage(source, 0, 0, width, height, null);
    g.dispose();
    return dest;
  }

  /**
   * Returns the first point which belongs to the foreground and not on the border Starting in the
   * images center
   *
   * @param image
   *          image
   * @param bgColor
   *          background color
   * @return Point if found, otherwise null
   */
  public static Point getPointOnForegroundNotOnBorder(BufferedImage image, int bgColor) {
    for (int y = image.getHeight() / 2; y < image.getHeight(); ++y) {
      for (int x = image.getWidth() / 2; x < image.getWidth(); ++x) {
        if (image.getRGB(x, y) != bgColor
            && !belongsOneNeighbourToColour(image, new Point(x, y), bgColor)) {
          return new Point(x, y);
        }
      }

      for (int x = 0; x < image.getWidth() / 2; ++x) {
        if (image.getRGB(x, y) != bgColor
            && !belongsOneNeighbourToColour(image, new Point(x, y), bgColor)) {
          return new Point(x, y);
        }
      }
    }

    for (int y = 0; y < image.getHeight() / 2; ++y) {
      for (int x = image.getWidth() / 2; x < image.getWidth(); ++x) {
        if (image.getRGB(x, y) != bgColor
            && !belongsOneNeighbourToColour(image, new Point(x, y), bgColor)) {
          return new Point(x, y);
        }
      }

      for (int x = 0; x < image.getWidth() / 2; ++x) {
        if (image.getRGB(x, y) != bgColor
            && !belongsOneNeighbourToColour(image, new Point(x, y), bgColor)) {
          return new Point(x, y);
        }
      }
    }
    return null;
  }

  /**
   * Returns the first point, which could be a border pixel This means, a pixel which has a
   * Neighbour colored like the background
   *
   * @param image
   *          Image
   * @param center
   *          center point
   * @param bgColor
   *          background color
   * @return list of border Points
   */
  public static List<Point> getBorderPoint(BufferedImage image, Point center, int bgColor) {
    List<Point> borderPoints = new ArrayList<Point>();

    for (int y = center.y; y < image.getHeight(); ++y) {
      for (int x = center.x; x < image.getWidth(); ++x) {
        if (belongsOneNeighbourToColour(image, new Point(x, y), bgColor)) {
          borderPoints.add(new Point(x, y));
        }
      }

      for (int x = 0; x < center.x; ++x) {
        if (belongsOneNeighbourToColour(image, new Point(x, y), bgColor)) {
          borderPoints.add(new Point(x, y));
        }
      }
    }

    for (int y = 0; y < center.y; ++y) {
      for (int x = center.x; x < image.getWidth(); ++x) {
        if (belongsOneNeighbourToColour(image, new Point(x, y), bgColor)) {
          borderPoints.add(new Point(x, y));
        }
      }

      for (int x = 0; x < center.x; ++x) {
        if (belongsOneNeighbourToColour(image, new Point(x, y), bgColor)) {
          borderPoints.add(new Point(x, y));
        }
      }
    }

    return borderPoints;
  }

  /**
   * Returns if at least one neighbour pixel belongs to a given Color
   *
   * @param pt
   * @return
   */
  public static boolean belongsOneNeighbourToColour(BufferedImage img, Point pt, int bgColor) {
    int xStart = Math.max(pt.x - 1, 0);
    int xEnd = Math.min(pt.x + 1, img.getWidth() - 1);
    int yStart = Math.max(pt.y, 0);
    int yEnd = Math.min(pt.y + 1, img.getHeight() - 1);

    for (int y = yStart; y <= yEnd; ++y) {
      for (int x = xStart; x <= xEnd; ++x) {
        if (img.getRGB(x, y) == bgColor) {
          return true;
        }
      }
    }

    return false;
  }

  public static BufferedImage convertToGrayscale(BufferedImage input) {
    int alpha, red, green, blue;
    int newPixel;

    BufferedImage lum = new BufferedImage(input.getWidth(), input.getHeight(), input.getType());

    for (int i = 0; i < input.getWidth(); i++) {
      for (int j = 0; j < input.getHeight(); j++) {

        // Get pixels by R, G, B
        alpha = new Color(input.getRGB(i, j)).getAlpha();
        red = new Color(input.getRGB(i, j)).getRed();
        green = new Color(input.getRGB(i, j)).getGreen();
        blue = new Color(input.getRGB(i, j)).getBlue();

        // Convert using ITU-R BT.601 conversion (see: https://en.wikipedia.org/wiki/YCbCr)
        red = (int) (0.299 * red + 0.587 * green + 0.114 * blue);
        // Return back to original format
        newPixel = colorToRGB(alpha, red, red, red);

        // Write pixels into image
        lum.setRGB(i, j, newPixel);

      }
    }

    return lum;
  }

  // Convert R, G, B, Alpha to standard 8 bit
  private static int colorToRGB(int alpha, int red, int green, int blue) {

    int newPixel = 0;
    newPixel += alpha;
    newPixel = newPixel << 8;
    newPixel += red;
    newPixel = newPixel << 8;
    newPixel += green;
    newPixel = newPixel << 8;
    newPixel += blue;

    return newPixel;

  }

  /**
   * Paint all polygons.
   *
   * @param img
   *          The input image.
   * @param polygons
   *          The polygons.
   * @param seedPoints
   *          The seed points.
   */
  public static BufferedImage paintPolygons(BufferedImage img, List<Polygon> polygons,
      List<Point> seedPoints) {
    BufferedImage output = ImageFunctions.copyImage(img);
    Graphics2D g = output.createGraphics();

    g.setStroke(new BasicStroke(1));
    g.setColor(Color.BLACK);
    for (Polygon p : polygons) {
      g.drawPolygon(p);
    }

    g.setColor(Color.RED);
    for (Point p : seedPoints) {
      g.fillArc(p.x - 2, p.y - 2, 4, 4, 0, 360);
    }
    g.dispose();
    return output;
  }
}
