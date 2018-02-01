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

package com.actelion.research.orbit.imageAnalysis.models;

import java.io.Serializable;

/**
 * Holds a resultString (e.g. a statistics) and a title. To be used as results from a worker (e.g. CellCountWorker).
 *
 * @author stritma1
 */
public class TaskResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private String resultStr = "";
    private String title = "";

    public TaskResult() {

    }

    public TaskResult(String title, String resultStr) {
        this.resultStr = resultStr;
        this.title = title;
    }

    public String getResultStr() {
        return resultStr;
    }

    public String getTitle() {
        return title;
    }

    public void setResultStr(String resultStr) {
        this.resultStr = resultStr;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title + ": " + resultStr;
    }

}
