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

import com.actelion.research.orbit.imageAnalysis.features.TissueFeatures;
import com.actelion.research.orbit.imageAnalysis.models.ClassShape;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.imageAnalysis.utils.TiledImagePainter;
import weka.core.DenseInstance;
import weka.core.Instance;

import java.awt.image.Raster;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

/**
 * Not thread-safe.
 */
public class OrbitMaskClassificationModel implements IOrbitMaskModelBased, Serializable {

    private OrbitModel model;
    private HashSet<Integer> activeClasses;
    private transient TissueFeatures tissueFeatures;

    public OrbitMaskClassificationModel(OrbitModel model, int ... activeClasses) {
        this.model = model;
        this.activeClasses = new HashSet<>(activeClasses.length>0?activeClasses.length:1);
        if (activeClasses.length>0) {
            for (int c : activeClasses) {
                this.activeClasses.add(c);
            }
        } else {
            reconfigure();
        }
    }

    @Override
    public void reconfigure() {
        // build active classes form model definition
        this.activeClasses = new HashSet<>(1);
        List<ClassShape> classShapes = model.getClassShapes();
        for (int i = 0; i < classShapes.size(); i++) {
            ClassShape cs = classShapes.get(i);
            if (cs.getIncExcMode()==ClassShape.INCLUSION) {
                this.activeClasses.add(i);
            }
        }
    }


    @Override
    public void initialize(final TiledImagePainter tip) {
        this.tissueFeatures = OrbitUtils.createTissueFeatures(model.getFeatureDescription(), tip);
    }

    @Override
    public int classNum(int x, int y, final Raster raster) throws Exception {
       if (model==null) throw new IllegalStateException("Model is null. Please call initialize() before to set a mask model.");
       if (tissueFeatures==null) throw new IllegalStateException("tissueFeatures is null. Please call initialize() before to set a mask model.");
       int w = model.getFeatureDescription().getWindowSize();
       int xr = x;
       int yr = y;
       if (xr<raster.getMinX()+w) xr = raster.getMinX()+w;
       if (yr<raster.getMinY()+w) yr = raster.getMinY()+w;
       if (xr>raster.getMinX()+raster.getWidth()-1-w) xr = raster.getMinX()+raster.getWidth()-1-w;
       if (yr>raster.getMinY()+raster.getHeight()-1-w) yr = raster.getMinY()+raster.getHeight()-1-w;
       double[] features = tissueFeatures.buildFeatures(raster, xr, yr, Double.NaN);
       Instance instance = new DenseInstance(1d,features);
       instance.setDataset(model.getStructure());
       int clazz = (int) model.getClassifier().classifyInstance(instance);
       return clazz;
    }

    @Override
    public boolean isIncluded(int x, int y, final Raster raster) throws Exception {
        int clazz = classNum(x,y,raster);
        return activeClasses.contains(clazz);
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

    @Override
    public IOrbitMask clone() {
        OrbitMaskClassificationModel cloned = null;
        try {
            cloned = (OrbitMaskClassificationModel) super.clone();
            cloned.model = new OrbitModel(this.model);
            cloned.activeClasses = new HashSet<>(activeClasses);
            return cloned;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public OrbitModel getModel() {
        return model;
    }


    public HashSet<Integer> getActiveClasses() {
        return activeClasses;
    }

    public TissueFeatures getTissueFeatures() {
        return tissueFeatures;
    }
}
