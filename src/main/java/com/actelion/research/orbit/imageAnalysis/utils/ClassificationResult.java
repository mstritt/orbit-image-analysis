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

import com.actelion.research.mapReduceGeneric.utils.KeyValue;
import com.actelion.research.orbit.imageAnalysis.models.ClassShape;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClassificationResult implements Serializable {

    private Map<String, Long> ratio;
    private Map<String, Long> exclusionRatio;
    private OrbitModel model;

    public ClassificationResult(Map<String, Long> ratio, Map<String, Long> exclusionRatio, OrbitModel model) {
        this.ratio = ratio;
        this.exclusionRatio = exclusionRatio;
        this.model = model;
    }


    private List<KeyValue<String, Double>> normalizeValues(Map<String, Long> ratio, OrbitModel model) {
        List<KeyValue<String, Double>> sortedNorm = new ArrayList<KeyValue<String, Double>>();
        if (model == null || ratio == null || ratio.size() == 0) return sortedNorm;
        long[] pixels = new long[model.getClassShapes().size()];
        double[] norm = new double[model.getClassShapes().size()];
        long sum = 0L;
        for (int i = 0; i < model.getClassShapes().size(); i++) {
            ClassShape cs = model.getClassShapes().get(i);
            pixels[i] = ratio.get(cs.getName());
            sum += pixels[i];
        }
        if (sum > 0) {
            for (int i = 0; i < model.getClassShapes().size(); i++) {
                norm[i] = (double) pixels[i] / sum;
            }
        }
        for (int i = 0; i < model.getClassShapes().size(); i++) {
            sortedNorm.add(new KeyValue<String, Double>(model.getClassShapes().get(i).getName(), norm[i]));
        }
        return sortedNorm;
    }


    public List<KeyValue<String, Double>> normalizeRatio() {
        return normalizeValues(ratio, model);
    }

    public List<KeyValue<String, Double>> normalizeRatioExclusion() {
        return normalizeValues(exclusionRatio, model.getExclusionModel());
    }

    public Map<String, Long> getRatio() {
        return ratio;
    }

    public void setRatio(Map<String, Long> ratio) {
        this.ratio = ratio;
    }

    public Map<String, Long> getExclusionRatio() {
        return exclusionRatio;
    }

    public void setExclusionRatio(Map<String, Long> exclusionRatio) {
        this.exclusionRatio = exclusionRatio;
    }

    public OrbitModel getModel() {
        return model;
    }

    public void setModel(OrbitModel model) {
        this.model = model;
    }
}
