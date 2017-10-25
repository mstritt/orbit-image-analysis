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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DoubleClickSlider extends JSliderOrbit {

    private static final long serialVersionUID = 1L;
    private int defValue = 0;
    private int minValue = 0;
    private int lastVal = defValue;
    private boolean toggle = false;
    private final JCheckBox checkbox = new JCheckBox("",true);

    /**
     * A slider which sets the value to the default value  when it is double-clicked.
     *
     * @param min
     * @param max
     * @param defValue
     */
    public DoubleClickSlider(int min, int max, int defValue) {
        this(min,max,defValue,false);
    }
    
    /**
     * A slider which sets the value to the default value  when it is double-clicked.
     * If toggle=true a toggle checkbox will be added which sets the value to default value (e.g. enable/disable).
     *
     * @param min
     * @param max
     * @param defValue
     */
    public DoubleClickSlider(int min, int max, int defValue, boolean toggle) {
        super(min, max, defValue);
        this.defValue = defValue;
        this.minValue = min;
        this.toggle = toggle;
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

    @Override
    public void setValue(int n) {
        super.setValue(n);
        updateCheckbox();
    }

    private void updateCheckbox() {
        if (getValue() > minValue) {
            checkbox.setSelected(true);
        } else {
            checkbox.setSelected(false);
        }
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
        if (slider.toggle) {
            panel.add(slider.checkbox, BorderLayout.WEST);
        }
        panel.add(label, BorderLayout.EAST);

        if (slider.toggle) {
            slider.checkbox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!slider.checkbox.isSelected()) {
                        slider.lastVal = slider.getValue();
                        slider.setValue(slider.minValue);
                    } else {
                        slider.setValue(slider.lastVal>slider.minValue? slider.lastVal: slider.defValue);
                    }
                }
            });
        }

        // add listener
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent paramChangeEvent) {
                String val = String.format(fmt, (slider.getValue() + offset) * multiplier);
                 //checkbox.setText(val);
                 label.setText(val);
                 slider.updateCheckbox();
            }
        });
        return panel;
    }

}
