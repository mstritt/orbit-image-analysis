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

import com.actelion.research.orbit.imageAnalysis.models.SegmentationResult;
import com.actelion.research.orbit.imageAnalysis.models.TaskResult;
import com.actelion.research.orbit.imageAnalysis.tasks.ITaskResultProducer;
import com.actelion.research.orbit.imageAnalysis.tasks.ROIArea.ROIAreaWorkerMapReduce;
import com.actelion.research.orbit.imageAnalysis.tasks.cellClassification.CellClassificationWorkerMapReduce;
import com.actelion.research.orbit.imageAnalysis.tasks.classification.ClassificationWorkerMapReduce;
import com.actelion.research.orbit.imageAnalysis.tasks.histogram.Histogram;
import com.actelion.research.orbit.imageAnalysis.tasks.histogram.HistogramWorkerMapReduce;
import com.actelion.research.orbit.imageAnalysis.tasks.segmentation.SegmentationWorkerMapReduce;

import java.util.Map;

public class TaskResultProducerFactoryGeneric {

        public static ITaskResultProducer createTaskResultProducer(Map map) {
            if (map==null || map.values().size()==0) {
                return new ITaskResultProducer() {
                    @Override
                    public TaskResult produceTaskResult(Map classificationResultMap, boolean computeROIAreas) throws Exception {
                        return new TaskResult("No results", "No results available.");
                    }
                };
            }

            Object firstEntry = map.values().iterator().next();


            if (firstEntry instanceof ClassificationResult) {
                if ( ((ClassificationResult)firstEntry).getModel().isCellClassification())
                    return new CellClassificationWorkerMapReduce();
                else return new ClassificationWorkerMapReduce();
            }
            else if (firstEntry instanceof SegmentationResult) return new SegmentationWorkerMapReduce();
            else if (firstEntry instanceof Double) return new ROIAreaWorkerMapReduce();
            else if (firstEntry instanceof Histogram[]) return new HistogramWorkerMapReduce();
            else return new ITaskResultProducer() {
                    @Override
                    public TaskResult produceTaskResult(Map classificationResultMap, boolean computeROIAreas) throws Exception {
                        return new TaskResult("Unknown Result", "The task result is unknown and cannot be interpreted.");
                    }
                };
        }
}
