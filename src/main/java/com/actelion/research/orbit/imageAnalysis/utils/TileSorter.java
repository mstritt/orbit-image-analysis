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

package com.actelion.research.orbit.imageAnalysis.utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class TileSorter implements Comparator<Point> {

    private double centerX;
    private double centerY;


    public TileSorter(int minX, int maxX, int minY, int maxY) {
        this.centerX = (maxX + minX) / 2d;
        this.centerY = (maxY + minY) / 2d;
    }

    @Override
    public int compare(Point p1, Point p2) {
        return (int) Math.signum(p1.distance(centerX, centerY) - p2.distance(centerX, centerY));
    }

    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        for (int x = 0; x < 5; x++)
            for (int y = 0; y < 5; y++)
                list.add(new Point(x, y));

        Collections.sort(list, new TileSorter(0, 4, 0, 4));

        for (Point p : list) {
            System.out.println(p);
        }


    }

}
