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

package com.actelion.research.orbit.imageAnalysis.segmenter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Test class for example usage of SegmenterFacade
 */
public class SegmenterTest2 {
  public static void main(String[] args) {
    BufferedImage cellImage = null;
    SegmentedImage segmentedImage = null;



    String imagePath = "D:\\data\\cellseg\\example1\\851f807e-6da9-4d97-a489-8b8c27c2b0db.jpg";
    String outBase = "D:\\data\\cellseg\\example1\\851f807e-6da9-4d97-a489-8b8c27c2b0db";
    int cellSize = 9;
    int alpha = 15;

    try {
      cellImage = ImageIO.read(new File(imagePath));
      BufferedImage mask = BackgroundMaskCreator.getMask(cellImage);
      segmentedImage = SegmenterFacade.detectCells(cellImage, mask, alpha, cellSize);
      BufferedImage output = segmentedImage.getPolygonPaintedImage();
      ImageIO.write(output, "png",
          new File(outBase+"_" + String.valueOf(cellSize) + "_" + String.valueOf(alpha) + ".png"));
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
