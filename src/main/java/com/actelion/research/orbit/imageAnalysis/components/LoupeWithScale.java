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

package com.actelion.research.orbit.imageAnalysis.components;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Hashtable;


public class LoupeWithScale extends JPanel {
    private static final long serialVersionUID = 1L;
    private Loupe loupe = null;
    private SliderWithListener scaleSlider = null;

    public LoupeWithScale() {
        loupe = new Loupe();
        scaleSlider = new SliderWithListener(JSlider.HORIZONTAL, 100, 1000, 300);
        scaleSlider.setMajorTickSpacing(300);
        scaleSlider.setMinorTickSpacing(100);
        scaleSlider.setPaintTicks(false);
        scaleSlider.setPaintLabels(true);
        Hashtable<Integer, Component> labelTable = new Hashtable<Integer, Component>();
        labelTable.put(100, new JLabel("100%"));
        labelTable.put(400, new JLabel("400%"));
        labelTable.put(700, new JLabel("700%"));
        labelTable.put(1000, new JLabel("1000%"));
        scaleSlider.setLabelTable(labelTable);
        scaleSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                double scale = scaleSlider.getValue();
                loupe.setScale(scale);
                loupe.repaint();
            }
        });

        // layout
        GridBagConstraints gbcLoupe = new GridBagConstraints();
        gbcLoupe.weightx = 1.0;
        gbcLoupe.weighty = 1.0;
        gbcLoupe.anchor = GridBagConstraints.NORTHEAST;
        gbcLoupe.fill = GridBagConstraints.BOTH;
        gbcLoupe.gridx = 0;
        gbcLoupe.gridy = 0;

        GridBagConstraints gbcScaleSlider = new GridBagConstraints();
        //gbcScaleSlider.insets = new Insets(2,2,2,2);
        gbcScaleSlider.weightx = 1.0;
        gbcScaleSlider.weighty = 0.0;
        gbcScaleSlider.anchor = GridBagConstraints.NORTH;
        gbcScaleSlider.fill = GridBagConstraints.HORIZONTAL;
        gbcScaleSlider.gridx = 0;
        gbcScaleSlider.gridy = 1;

        setLayout(new GridBagLayout());
        add(loupe, gbcLoupe);
        add(scaleSlider, gbcScaleSlider);

    }

    public Loupe getLoupe() {
        return loupe;
    }

    public JSlider getScaleSlider() {
        return scaleSlider;
    }

    public void setLoupe(Loupe loupe) {
        this.loupe = loupe;
    }

    public void setScaleSlider(SliderWithListener scaleSlider) {
        this.scaleSlider = scaleSlider;
    }


}
