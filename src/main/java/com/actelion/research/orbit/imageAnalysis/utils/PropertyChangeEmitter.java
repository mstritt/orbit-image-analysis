/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

/**
 * provides add/remove-PropertyChangeListener and firePropertyChangeEvent methods.
 *
 * @author stritma1
 * @since 19.03.2010
 */
public class PropertyChangeEmitter {

    private List<PropertyChangeListener> pcListeners = null;

    protected void firePropertyChangeEvent(PropertyChangeEvent event) {
        if (pcListeners != null) {
            for (PropertyChangeListener pcl : pcListeners) {
                pcl.propertyChange(event);
            }
        }
    }

    /**
     * adds a propertyChangeListener. The listeners will be notified if CLASSIFICATION_PROGRESS changes.
     *
     * @param propertyChangeListener
     */
    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        if (pcListeners == null) pcListeners = new ArrayList<PropertyChangeListener>();
        pcListeners.add(propertyChangeListener);
    }

    /**
     * removes a propertyChangeListener. If this listener not exists in the propertyChangeListeners list then
     * nothing will be done.
     *
     * @param propertyChangeListener
     */
    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        if (pcListeners == null) return;
        pcListeners.remove(propertyChangeListener);
    }
}
