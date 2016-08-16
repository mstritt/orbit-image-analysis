/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2016 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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

package com.actelion.research.orbit.imageAnalysis.modules;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NumSpotsClassifiedListener implements PropertyChangeListener {

    public static final String NUMSPOTSCLASSIFIED = "NumSpotsClassifiedListener.NUMSPOTSCLASSIFIED";
    protected int targetNum = 100;

    public NumSpotsClassifiedListener(int targetNum) {
        this.targetNum = targetNum;
    }

    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(NUMSPOTSCLASSIFIED)) {
            int cnt = (Integer) evt.getNewValue();
            if (cnt > 0 && (cnt % targetNum == 0)) {
                JOptionPane.showMessageDialog(null, getMessage(cnt), getTitle(cnt), JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public int getTargetNum() {
        return targetNum;
    }

    public void setTargetNum(int targetNum) {
        this.targetNum = targetNum;
    }

    public String getMessage(int num) {
        return "You classified " + num + " spots.\nCongratulation!";
    }

    public String getTitle(int num) {
        return num + " spots classified";
    }

}
