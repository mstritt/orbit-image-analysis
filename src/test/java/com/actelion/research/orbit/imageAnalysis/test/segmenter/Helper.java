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

package com.actelion.research.orbit.imageAnalysis.test.segmenter;


import com.actelion.research.orbit.imageAnalysis.segmenter.linalg.AbstractVector;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Helper {
  public static final double TOLERANCE = 1e-10;

  public static void printVectorToFile(AbstractVector vector, String filename) {
    try (PrintWriter out = new PrintWriter(filename)) {
      for (int i = 0; i < vector.getDimension(); i++) {
        out.println(vector.getEntry(i));
      }
    } catch (FileNotFoundException e) {
      System.out.println("Error while printing mesh into file!");
      e.printStackTrace();
    }
  }
}
