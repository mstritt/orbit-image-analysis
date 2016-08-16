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

package com.actelion.research.orbit.imageAnalysis.components;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DoubleClickSlider extends JSlider {

    private static final long serialVersionUID = 1L;
    private int defValue = 0;

    /**
     * a slider which sets the value to the default value  when it is double-clicked
     *
     * @param min
     * @param max
     * @param defValue
     */
    public DoubleClickSlider(int min, int max, int defValue) {
        super(min, max, defValue);
        this.defValue = defValue;
        setPaintLabels(false);
        setPaintTicks(false);
        //setMajorTickSpacing(50);
        setValue(defValue);

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
                    setValue(DoubleClickSlider.this.defValue);
                }
            }
        });
    }

    public int getDefValue() {
        return defValue;
    }

    /**
     * Returns a panel with a label next to the slider showing the value of the slider.<br/>
     * The value will be (value+offset)*multiplier.<br/>
     * Default: Set offset to 0 and multiplier to 1.
     *
     * @param slider
     * @param offset
     * @param multiplier
     * @return
     */
    public static JPanel wrapToPanelWithValue(final DoubleClickSlider slider, final double offset, final double multiplier) {
        final String fmt = (Math.abs((int) multiplier - multiplier) < 0.001) ? "%1$.0f" : "%1$.2f";
        String val = String.format(fmt, (slider.getValue() + offset) * multiplier);
        final JLabel label = new JLabel(val);
        final JPanel panel = new JPanel(new BorderLayout());
        panel.add(slider, BorderLayout.CENTER);
        panel.add(label, BorderLayout.EAST);

        // add listener
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent paramChangeEvent) {
                String val = String.format(fmt, (slider.getValue() + offset) * multiplier);
                label.setText(val);
            }
        });
        return panel;
    }

}
