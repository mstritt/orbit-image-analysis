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

package com.actelion.research.orbit.imageAnalysis.mask;

import com.actelion.research.orbit.imageAnalysis.features.TissueFeatures;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.imageAnalysis.utils.TiledImagePainter;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import weka.core.DenseInstance;
import weka.core.Instance;

import java.awt.image.Raster;
import java.util.concurrent.Callable;

public class OrbitMaskClassificationModel implements IOrbitMask {

    private OrbitModel model;
    private TiledImagePainter bimg;
    private Cache<RasterKey,Raster> rasterCache = CacheBuilder.newBuilder().maximumSize(10).build();

    public OrbitMaskClassificationModel(OrbitModel model, TiledImagePainter bimg) {
        this.model = model;
        this.bimg = bimg;
    }

    @Override
    public int classNum(int x, int y) throws Exception {
       final int tileX = bimg.getImage().tileXToX(x);
       final int tileY = bimg.getImage().tileYToY(y);
       RasterKey rasterKey = new RasterKey(tileX,tileY);
       Raster raster = rasterCache.get(rasterKey, new Callable<Raster>() {
           @Override
           public Raster call() throws Exception {
               return OrbitUtils.getRasterForClassification(bimg,model.getFeatureDescription(),model.getFeatureDescription().getWindowSize(),tileX,tileY);
           }
       });
       TissueFeatures tissueFeatures = OrbitUtils.createTissueFeatures(model.getFeatureDescription(), bimg);
       double[] features = tissueFeatures.buildFeatures(raster, x, y, Double.NaN);
       Instance instance = new DenseInstance(1d,features);
       instance.setDataset(model.getStructure());
       int clazz = (int) model.getClassifier().classifyInstance(instance);
       return clazz;
    }

    @Override
    public boolean isIncluded(int x, int y) {
        return true;
    }

    @Override
    public int numClasses() {
        return model.getClassShapes().size();
    }


    @Override
    public String className(int classNum) {
        return model.getClassShapes().get(classNum).getName();
    }

    @Override
    public int classColor(int classNum) {
        return model.getClassShapes().get(classNum).getColor().getRGB();
    }

    class RasterKey {
        private int tileX;
        private int tileY;

        public RasterKey(int tileX, int tileY) {
            this.tileX = tileX;
            this.tileY = tileY;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            RasterKey rasterKey = (RasterKey) o;

            if (tileX != rasterKey.tileX) return false;
            return tileY == rasterKey.tileY;
        }

        @Override
        public int hashCode() {
            int result = tileX;
            result = 31 * result + tileY;
            return result;
        }
    }
}
