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

package com.actelion.research.orbit.imageAnalysis.components;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * JSlider with build in propertychangelistener. Listens to event ImageFrame.SCALE_SET_EVENT_OUT.<br>
 * The range is from 1 to 800. But for the output 1-400 is mapped to 1-100 and 401-800 is mapped to 101-500.
 * The "read-back" is done in the propertyChangeListener. The Set-mapping is done in OrbitImageAnalysis.getScaleActionListener().
 */
public class SliderWithListener extends JSliderOrbit implements PropertyChangeListener {

    private static final long serialVersionUID = 1L;

    public SliderWithListener() {
        addDoubleClickListener();
    }

    public SliderWithListener(int orientation) {
        super(orientation);
        addDoubleClickListener();

    }

    public SliderWithListener(BoundedRangeModel brm) {
        super(brm);
        addDoubleClickListener();

    }

    public SliderWithListener(int min, int max) {
        super(min, max);
        addDoubleClickListener();

    }

    public SliderWithListener(int min, int max, int value) {
        super(min, max, value);
        addDoubleClickListener();

    }

    public SliderWithListener(int orientation, int min, int max, int value) {
        super(orientation, min, max, value);
        addDoubleClickListener();

    }

    private void addDoubleClickListener() {
        addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() >= 2) {
                    setValue(400);
                    fireStateChanged();
                }
            }
        });

    }

    public double getValueAdjusted() {
        double v = super.getValue();
        if (v < 400d) {
            v /= 4d;
        } else {
            v = v - 300d;
        }
        return v;
    }


    /**
     * will react on ImageFrame.SCALE_SET_EVENT_OUT
     */
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(ImageFrame.SCALE_SET_EVENT_OUT)) {
            double v = (Double) evt.getNewValue();
            if (v < 100d) {
                v *= 4d;
            } else {
                v += 300d;
            }
            setValue((int) v);
        }
    }


}
