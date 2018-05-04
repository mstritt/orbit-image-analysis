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

package com.actelion.research.orbit.imageAnalysis.dal;

import com.actelion.research.mapReduceGeneric.IMapReduce;
import com.actelion.research.mapReduceGeneric.IRemoteContextStore;
import com.actelion.research.mapReduceGeneric.executors.IMapReduceExecutor;
import com.actelion.research.orbit.imageAnalysis.dal.MapReduceExecutor.MapReduceExecutorSparkProxy;
import com.actelion.research.orbit.imageAnalysis.utils.ExistingMRResultsViewSamba;

import javax.swing.*;

public class ScaleoutSparkCluster implements IScaleout {
    private IRemoteContextStore remoteContextStore = null;
    
    @Override
    public IMapReduceExecutor createMapReduceExecutor(IMapReduce mapReduce) {
        return new MapReduceExecutorSparkProxy("OIASparkExec",10,62,0.75d);
    }

    @Override
    public IRemoteContextStore getRemoteContextStore() {
        if (remoteContextStore == null) {
            remoteContextStore = createContextStore();
        }
        return remoteContextStore;
    }

    protected IRemoteContextStore createContextStore() {
       return DALConfig.getScaleOut().getRemoteContextStore();
    }


    @Override
    public int getParallelism() {
        return 10;
    }

    @Override
    public JInternalFrame createExistingResultView() throws Exception {
        // return new JInternalFrame();
        return new ExistingMRResultsViewSamba();
    }
}
