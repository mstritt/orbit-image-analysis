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

package com.actelion.research.orbit.imageAnalysis.dal;

import com.actelion.research.mapReduceGeneric.IMapReduce;
import com.actelion.research.mapReduceGeneric.IRemoteContextStore;
import com.actelion.research.mapReduceGeneric.executors.IMapReduceExecutor;

import javax.swing.*;
import java.util.Collection;
import java.util.Map;

public class ScaleoutNoop implements IScaleout {
    @Override
    public IMapReduceExecutor createMapReduceExecutor(IMapReduce mapReduce) {
        return new IMapReduceExecutor() {
            @Override
            public Map execute(Collection collection, IMapReduce iMapReduce) throws Exception {
                throw new Exception("No Scaleout Executor available. Please define a scaleout executor in the configuration.");
            }

            @Override
            public double getProgress() {
                return 0;
            }

            @Override
            public void cancel() {

            }
        };
    }

    @Override
    public IRemoteContextStore getRemoteContextStore() {
        return null;
    }

    @Override
    public int getParallelism() {
        return 100;
    }

    @Override
    public JInternalFrame createExistingResultView() {
        JInternalFrame frame = new JInternalFrame("Existing Results");
        JLabel label = new JLabel("Not implemented for this Scaleout implementation.");
        label.setFont(label.getFont().deriveFont(32));
        frame.add(label);
        frame.pack();
        return frame;
    }
}
