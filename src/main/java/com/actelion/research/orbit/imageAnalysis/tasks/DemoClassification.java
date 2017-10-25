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

package com.actelion.research.orbit.imageAnalysis.tasks;

import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.utils.ClassificationResult;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitHelper;

public class DemoClassification {

    public static void main(String[] args) throws Exception {
        OrbitModel model = OrbitModel.LoadFromInputStream(DemoClassification.class.getResourceAsStream("/resource/testmodels/tissueClassification.omo"));
        RecognitionFrame rf = new RecognitionFrame("/resource/testimages/tissueClassification.jpg", true);
        ClassificationResult res = OrbitHelper.Classify(null, rf, model, null, -1, null);
        for (String name : res.getRatio().keySet()) {
            System.out.println(name + ": " + res.getRatio().get(name));
        }
    }

}
