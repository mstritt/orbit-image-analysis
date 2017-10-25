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

import com.actelion.research.orbit.imageAnalysis.models.TaskResult;
import com.actelion.research.orbit.imageAnalysis.tasks.ROIArea.ROIAreaMapReduce;
import com.actelion.research.orbit.imageAnalysis.tasks.ROIArea.ROIAreaWorkerMapReduce;
import com.actelion.research.orbit.imageAnalysis.tasks.cellClassification.CellClassificationMapReduce;
import com.actelion.research.orbit.imageAnalysis.tasks.cellClassification.CellClassificationWorkerMapReduce;
import com.actelion.research.orbit.imageAnalysis.tasks.classification.ClassificationMapReduce;
import com.actelion.research.orbit.imageAnalysis.tasks.classification.ClassificationWorkerMapReduce;
import com.actelion.research.orbit.imageAnalysis.tasks.segmentation.SegmentationMapReduce;
import com.actelion.research.orbit.imageAnalysis.tasks.segmentation.SegmentationWorkerMapReduce;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class TaskResultProducerFactoryMapReduce {
    private static final Logger logger = LoggerFactory.getLogger(TaskResultProducerFactoryMapReduce.class);

    public static ITaskResultProducer createTaskResultProducer(String mapReduceClassName) {
        if (mapReduceClassName.equals(CellClassificationMapReduce.class.getName()))
            return new CellClassificationWorkerMapReduce();
        else if (mapReduceClassName.equals(ClassificationMapReduce.class.getName()))
            return new ClassificationWorkerMapReduce();
        else if (mapReduceClassName.equals(SegmentationMapReduce.class.getName()))
            return new SegmentationWorkerMapReduce();
        else if (mapReduceClassName.equals(ROIAreaMapReduce.class.getName())) return new ROIAreaWorkerMapReduce();
        else return new ITaskResultProducer() {
                @Override
                public TaskResult produceTaskResult(Map classificationResultMap, boolean computeROIAreas) throws Exception {
                    logger.info("For this map reduce no ResultProducer is known. You can enhance this functionality by enhancing the class TaskResultProducerFactoryMapReduce");
                    return new TaskResult("Unknown Result", "The task result is unknown and cannot be interpreted.");
                }
            };
    }
}
