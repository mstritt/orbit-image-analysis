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

package com.actelion.research.orbit.imageAnalysis.components;

import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExclusionAdminFrame extends JDialog {
    private static final long serialVersionUID = 1L;
    protected final Logger logger = LoggerFactory.getLogger(ExclusionAdminFrame.class);
    private OrbitModel model = null;
    private final JButton okBtn = new JButton("Ok");
    private final JButton cancelBtn = new JButton("Cancel");
    private final JCheckBox cbClassSeg = new JCheckBox("Exclusion for Segmentation? (otherwise for classification)", false);
    private final JCheckBox cbNegChannel = new JCheckBox("Exclusion on Negative Channel?", false);
    private final JCheckBox cbErodeDilate = new JCheckBox("Erode and Dilate?", true);
    private final DefaultComboBoxModel exclCbModel = new DefaultComboBoxModel(new Integer[]{1, 2, 3});
    private final JComboBox cbExclusionLevel = new JComboBox(exclCbModel);


    public ExclusionAdminFrame(OrbitModel model) {
        setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
        this.model = model;

        setTitle("Configure Exclusion Model");
        setResizable(false);
        setIconImage(null);

        // set values
        if (model != null) {
            cbClassSeg.setSelected(model.isUseExclusionForSegmentation());
            cbNegChannel.setSelected(model.isApplyExclusionOnNegativeChannel());
            cbErodeDilate.setSelected(model.isPerformErodeDiliate());
            int exclLevel = model.getExclusionLevel();
            if (model.getExclusionModel()!=null) exclLevel = model.getExclusionModel().getExclusionLevel();
            cbExclusionLevel.setSelectedItem(exclLevel);
        }

        okBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                save();
                close();
            }
        });

        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });

        // layout
        setLayout(new GridBagLayout());
        JPanel panelBtn = new JPanel();
        panelBtn.add(okBtn);
        panelBtn.add(cancelBtn);
        Insets insets = new Insets(5, 5, 5, 5);
        add(new JLabel("Exclusion Model Level"), new GridBagConstraints(0, 2, GridBagConstraints.RELATIVE, 1, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, insets, 0, 0));
        add(cbExclusionLevel, new GridBagConstraints(1, 2, GridBagConstraints.REMAINDER, 1, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, insets, 0, 0));
        add(panelBtn, new GridBagConstraints(0, 3, GridBagConstraints.RELATIVE, 1, 1, 1, GridBagConstraints.SOUTHEAST, GridBagConstraints.NONE, insets, 0, 0));
        pack();
    }

    /**
     * Sets values on model <b>and also in embedded exclusion model</b> if available.<br/>
     * (To avoid problems if a user has set the exclusion model already and later wants to change the parameters.)
     */
    private void save() {
        if (model != null) {
            model.setUseExclusionForSegmentation(cbClassSeg.isSelected());
            model.setApplyExclusionOnNegativeChannel(cbNegChannel.isSelected());
            model.setPerformErodeDiliate(cbErodeDilate.isSelected());
            model.setExclusionLevel((Integer) cbExclusionLevel.getSelectedItem());
            if (model.getExclusionModel() != null) {
                model.getExclusionModel().setUseExclusionForSegmentation(cbClassSeg.isSelected());
                model.getExclusionModel().setApplyExclusionOnNegativeChannel(cbNegChannel.isSelected());
                model.getExclusionModel().setPerformErodeDiliate(cbErodeDilate.isSelected());
                model.getExclusionModel().setExclusionLevel((Integer) cbExclusionLevel.getSelectedItem());
            }
        }
    }

    private void close() {
        setVisible(false);
        dispose();
    }


}
