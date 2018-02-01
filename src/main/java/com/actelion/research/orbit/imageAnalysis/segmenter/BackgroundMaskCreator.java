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

package com.actelion.research.orbit.imageAnalysis.segmenter;
import com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.preprocessing.BackgroundFilter;
import com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.preprocessing.StainingColor;
import java.awt.image.BufferedImage;

/**
 * Class generates a binary mask given an input image of cells based on the algorithm developed in
 * the class
 * {@link com.actelion.research.orbit.imageAnalysis.segmenter.celldetector.preprocessing.BackgroundFilter}
 */
public class BackgroundMaskCreator {

  /**
   * Returns the binray mask (WHITE = foreground, BLACK = background) for the given input image
   *
   * @param image
   *          original input image of cells
   * @return binary mask (WHITE = foreground, BLACK = background) of type
   *         BufferedImage.TYPE_BYTE_BINARY
   */
  public static BufferedImage getMask(BufferedImage image) {
    BackgroundFilter bgFilter = new BackgroundFilter(image);
    StainingColor staining = bgFilter.recognizeCellStaining();
    return bgFilter.createBgMask(staining);
  }
}
