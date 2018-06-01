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

package com.actelion.research.orbit.imageAnalysis.utils;

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.IScaleableShape;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.tasks.ExclusionMapGen;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class TileIterable implements Iterable<Point> {

    private int rdfId;
    private RawDataFile rdf;
    private OrbitModel model = null;
    private RecognitionFrame rf;
    private OrbitTiledImage2 image;
    private IScaleableShape roi = null;
    private ExclusionMapGen exclusionMapGen = null;
    private int size = -1;

    public TileIterable(int imageId, OrbitModel model) throws Exception {
        this(imageId,model,0);
    }

    /**
     * Iterable to retrieve all tiles (indices) within the ROI defined by annotations stored in the DB and exclusion model.
     *
     * @param imageId: this orbit image id (rdfID)
     * @param model: model that contains an exclusion model
     * @param annotationGroup: annotationGroup -1 means ignore, 0 means use all, otherwise the specific group
     * @throws Exception
     */
    public TileIterable(int imageId, OrbitModel model, int annotationGroup) throws Exception {
        this.rdfId = imageId;
        this.rdf = DALConfig.getImageProvider().LoadRawDataFile(imageId);
        this.rf = new RecognitionFrame(this.rdf);
        this.rf.loadAnnotationROI(imageId,annotationGroup);
        this.roi = this.rf.getROI();
        this.image = rf.bimg.getImage();
        if (model != null) {
            this.model = model.clone();
            if (this.model.getExclusionModel()!=null) {
                this.exclusionMapGen = ExclusionMapGen.constructExclusionMap(rdf,rf,model);
                this.exclusionMapGen.generateMap();
            }
        }
    }

    /**
     * returns the tile indices within the ROI
     */
    public List<Point> getTileIndices() {
        Point[] allIndices = image.getTileIndices(null);
        List<Point> inROI = new ArrayList<>(allIndices.length);
        for (Point tile: allIndices) {
            if (OrbitUtils.isTileInROI(tile.x,tile.y,image,roi,exclusionMapGen)) {
                inROI.add(tile);
            }
        }
        this.size = inROI.size();
        return inROI;
    }

    public OrbitTiledImage2 getOrbitImage() {
        return image;
    }

    public BufferedImage getTileImage(Point tile) {
        return new BufferedImage(image.getColorModel(),(WritableRaster) image.getTile(tile.x,tile.y).createTranslatedChild(0,0),false,null);
    }

    public BufferedImage getImageRect(Rectangle rect) {
        return image.getAsBufferedImage(rect,image.getColorModel());
    }

    /**
     * returns the number of tiles within the ROI
     */
    public int getSize() {
        if (size<0) {  // not initialized
            getTileIndices();
        }
        return size;
    }

    @Override
    public Iterator<Point> iterator() {
        return new Iterator<Point>() {
            final List<Point> tileIndices = getTileIndices();
            int idx = 0;
            @Override
            public boolean hasNext() {
                return idx < tileIndices.size();
            }

            @Override
            public Point next() {
                return tileIndices.get(idx++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove");
            }
        };
    }


    public static void main(String[] args) throws Exception {
        TileIterable tileIter = new TileIterable(6140312,null);
        //TileIterable tileIter = new TileIterable(6140312,OrbitModel.LoadFromFile("d:/orbitModels/test.omo"));

        for (Point tile: tileIter) {
           // BufferedImage tileImage = tileIter.getTileImage(tile);
            System.out.println(tile);
        }

        System.out.println("#tiles: "+tileIter.getSize());
    }
}
