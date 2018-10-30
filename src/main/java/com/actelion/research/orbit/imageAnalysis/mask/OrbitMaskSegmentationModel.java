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

package com.actelion.research.orbit.imageAnalysis.mask;

import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.models.PolygonExt;
import com.actelion.research.orbit.imageAnalysis.models.SegmentationResult;
import com.actelion.research.orbit.imageAnalysis.models.ShapeAnnotationList;
import com.actelion.research.orbit.imageAnalysis.tasks.ObjectSegmentationWorker;
import com.actelion.research.orbit.imageAnalysis.utils.PolygonMetrics;
import com.actelion.research.orbit.imageAnalysis.utils.TiledImagePainter;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.awt.*;
import java.awt.image.Raster;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class OrbitMaskSegmentationModel implements IOrbitMaskModelBased, Serializable {

    private OrbitModel model;
    private transient TiledImagePainter tip;
    private transient LoadingCache<MyPoint,OrbitMaskSegmentation> tileShapeCache = null;

    public OrbitMaskSegmentationModel(OrbitModel model) {
        this.model = model;
    }


    private synchronized LoadingCache<MyPoint,OrbitMaskSegmentation> getTileShapeCache() {
        if (tileShapeCache==null) {
            tileShapeCache = CacheBuilder.
                    newBuilder().
                    //recordStats().
                            maximumSize(Runtime.getRuntime().availableProcessors()).
                            build(new CacheLoader<MyPoint, OrbitMaskSegmentation>() {
                                @Override
                                public OrbitMaskSegmentation load(MyPoint tile) throws Exception {
                                    double scaleOuter = 1.5d;
                                    double scaleInner = 0.8d;
                                    boolean bin = false;

                                    RecognitionFrame rf = new RecognitionFrame(tile.tip);
                                    List<Point> tiles = new ArrayList<>(1);
                                    tiles.add(new Point(tile.x,tile.y));
                                    ObjectSegmentationWorker segmentationWorker = new ObjectSegmentationWorker(null,rf,null,null,tiles);
                                    segmentationWorker.setModel(model);
                                    segmentationWorker.setNumThreads(1);
                                    segmentationWorker.setWithGUI(false);
                                    segmentationWorker.run();
                                    SegmentationResult segmentationResult = segmentationWorker.getSegmentationResult();
                                    List<Shape> shapeList = segmentationResult.getShapeList();
                                    if (bin && shapeList!=null) {
                                        // scale shape and exclude inner part
                                        List<Shape> binnedShapes = new ArrayList<>(shapeList.size());
                                        PolygonMetrics pm = new PolygonMetrics(null);
                                        for (Shape shape: shapeList) {
                                            if (shape instanceof PolygonExt) {
                                                PolygonExt pe = (PolygonExt) shape;
                                                pm.setPolygon(pe.clone());
                                                Shape outer = pe.scale(100d * scaleOuter, pm.getCenter());
                                                pm.setPolygon(pe.clone());
                                                Shape inner = pe.scale(100d * scaleInner, pm.getCenter());
                                                ShapeAnnotationList combined = new ShapeAnnotationList(new ArrayList<Shape>(), Collections.singletonList(inner), outer, outer.getBounds());
                                                binnedShapes.add(combined);
                                            }
                                        }
                                        shapeList = binnedShapes;
                                    }
                                    OrbitMaskSegmentation segMask = new OrbitMaskSegmentation(shapeList);
                                    return segMask;
                                }
                            });
        }
        return tileShapeCache;
    }

   
    @Override
    public void reconfigure() {

    }

    @Override
    public void initialize(TiledImagePainter tip) {
        this.tip = tip;
    }

    @Override
    public int numClasses() {
        return 2;  // maybe class per object in the future?
    }

    @Override
    public int classNum(int x, int y, Raster raster) throws Exception {
        MyPoint tile = new MyPoint(tip.getImage().XToTileX(x),tip.getImage().YToTileY(y), tip);
        OrbitMaskSegmentation segMask = getTileShapeCache().get(tile);
        return segMask.classNum(x,y,raster);
    }

    @Override
    public boolean isIncluded(int x, int y, Raster raster) throws Exception {
        return classNum(x,y,raster)>0;
    }

    @Override
    public String className(int classNum) {
        return classNum==0? "background": "object";
    }

    @Override
    public int classColor(int classNum) {
        return classNum==0? Color.blue.getRGB() : Color.yellow.getRGB();
    }

    @Override
    public OrbitModel getModel() {
        return model;
    }


    @Override
    public IOrbitMask clone() {
        OrbitMaskSegmentationModel cloned = null;
        try {
            cloned = (OrbitMaskSegmentationModel) super.clone();
            cloned.model = new OrbitModel(this.model);
            return cloned;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    class MyPoint implements Serializable {
        private int x;
        private int y;
        private transient TiledImagePainter tip;

        public MyPoint(int x, int y, TiledImagePainter tip) {
            this.x = x;
            this.y = y;
            this.tip = tip;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyPoint myPoint = (MyPoint) o;
            return x == myPoint.x &&
                    y == myPoint.y;
        }

        @Override
        public int hashCode() {

            return Objects.hash(x, y);
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public TiledImagePainter getTip() {
            return tip;
        }
    }
}
