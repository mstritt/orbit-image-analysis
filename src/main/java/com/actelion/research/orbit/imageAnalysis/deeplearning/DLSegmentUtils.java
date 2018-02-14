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

package com.actelion.research.orbit.imageAnalysis.deeplearning;

import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DLSegmentUtils {

    public static void storeShape(Shape shape, String name, int rdfId, String user) throws Exception {
        ClassShape classShape = new ClassShape(name, Color.green, ClassShape.SHAPETYPE_POLYGONEXT);
        classShape.getShapeList().add(shape);
        SpotAnnotation spot = new CellDetectionAnnotation(name, classShape);
        spot.setRawDataFileId(rdfId);
        spot.setUserId(user);
        DALConfig.getImageProvider().InsertRawAnnotation(spot);
    }

    public static void storeShapes(List<Shape> shapes, String basename, int rdfId, String user) throws Exception {
        int total = 0;
        for (Shape shape: shapes) {
            total++;
            storeShape(shape,basename+"_"+total,rdfId,user);
        }
    }

    public static List<Shape> filterShapes(List<Shape> shapes) {
        List<Shape> filtered = new ArrayList<>(shapes.size());
        HashSet<Integer> duplicates = new HashSet<>();
        for (int i = 0; i < shapes.size(); i++) {
            if (!duplicates.contains(i)) {
                Shape s1 = shapes.get(i);
                for (int j = 0; j < shapes.size(); j++) {
                    if (i!=j) {
                        Shape s2 = shapes.get(j);
                        if (s1 instanceof PolygonExt) {
                            PolygonExt p1o = (PolygonExt) s1;
                            PolygonExt p2o = (PolygonExt) s2;
                            PolygonExt p1 = (PolygonExt) s1;
                            PolygonExt p2 = (PolygonExt) s2;
                            p1 = p1.getScaledInstance(120d, new Point(0, 0));
                            if (p1.contains(p2)) {
                                int dup = j;
                                p2 = p2.getScaledInstance(120d, new Point(0, 0));
                                if (p2.contains(p1o)) {
                                    // take bigger one
                                    if (p2o.getArea(100)>p1o.getArea(100)) {
                                        dup = i;
                                    }
                                }
                                duplicates.add(dup);
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < shapes.size(); i++) {
            Shape s = shapes.get(i);
            if (!duplicates.contains(i)) {
                filtered.add(s);
            }
        }

        return filtered;
    }


    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        PolygonExt p = new PolygonExt();
        p.addPoint(0,0);
        p.addPoint(10,0);
        p.addPoint(10,10);
        p.addPoint(0,0);

        PolygonExt p3 = new PolygonExt();
        p3.addPoint(0,0);
        p3.addPoint(11,0);
        p3.addPoint(11,11);
        p3.addPoint(0,0);


        PolygonExt p1 = new PolygonExt();
        p1.addPoint(3,3);
        p1.addPoint(7,0);
        p1.addPoint(7,7);
        p1.addPoint(3,3);

        PolygonExt p2 = new PolygonExt();
        p2.addPoint(30,30);
        p2.addPoint(70,30);
        p2.addPoint(70,70);
        p2.addPoint(30,30);


        shapes.add(p);
        shapes.add(p1);
        shapes.add(p2);
        shapes.add(p3);

        shapes = DLSegmentUtils.filterShapes(shapes);
        System.out.println("size: "+shapes.size());
        for (Shape shape: shapes) {
            PolygonExt poly = (PolygonExt) shape;
            System.out.println(poly.listPoints());
        }

    }

}
