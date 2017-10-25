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

package com.actelion.research.orbit.imageAnalysis.modules;

import com.actelion.research.orbit.gui.DoubleTextField;
import com.actelion.research.orbit.gui.IntegerTextField;
import com.actelion.research.orbit.imageAnalysis.models.NerveDetectionParams;
import com.actelion.research.orbit.utils.RawUtilsCommon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NerveDetectionParamsDialog extends JDialog {
    private static final long serialVersionUID = 1L;
    private NerveDetectionParams params;

    private final JCheckBox cbFluoImage = new JCheckBox("Fluorescence Image (nerves are red)", false);
    private final DoubleTextField tfGamma = new DoubleTextField(0.65, 0.65);
    private final DoubleTextField tfUnsharp1 = new DoubleTextField(10, 10);
    private final DoubleTextField tfUnsharp2 = new DoubleTextField(0.7, 0.7);
    private final DoubleTextField tfHysteresis1 = new DoubleTextField(100, 100);
    private final DoubleTextField tfHysteresis2 = new DoubleTextField(55, 55);
    private final IntegerTextField tfSegmentLengthSingle = new IntegerTextField(15, 15);
    private final IntegerTextField tfSegmentLengthMerged = new IntegerTextField(30, 30);
    private final IntegerTextField tfSegmentDistanceMerge = new IntegerTextField(10, 10);
    private final JCheckBox cbJunctionCrossing = new JCheckBox("Only junction crossings", true);
    private final DoubleTextField tfJunctionDistance = new DoubleTextField(30, 30);

    private final JLabel labGamma = new JLabel("Gamma (0.0-1.0)");
    private final JLabel labUnsharp1 = new JLabel("Unsharp Mask Radius (Sigma)");
    private final JLabel labUnsharp2 = new JLabel("Unsharp Mask Weight (0.1-0.9)");
    private final JLabel labHysteresis1 = new JLabel("Hysteresis High (0-255)");
    private final JLabel labHysteresis2 = new JLabel("Hysteresis Low (0-255)");
    private final JLabel labSegmentLengthSingle = new JLabel("Min Length Before Merge");
    private final JLabel labSegmentLengthMerged = new JLabel("Min Length After Merge");
    private final JLabel labSegmentDistanceMerge = new JLabel("Segment Merging Distance");
    private final JLabel labJunctionDistance = new JLabel("Junction crossing distance");

    private final JButton btnOk = new JButton("Ok");
    private final JButton btnCancel = new JButton("Cancel");

    public NerveDetectionParamsDialog(final NerveDetectionParams params) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.params = params;

        cbFluoImage.setSelected(params.isFluoImage());
        tfGamma.setText(String.format("%1$.2f", params.getGamma()));
        tfUnsharp1.setText(String.format("%1$.2f", params.getUnsharpMaskThrethold1()));
        tfUnsharp2.setText(String.format("%1$.2f", params.getUnsharpMaskThrethold2()));
        tfHysteresis1.setText(String.format("%1$.2f", params.getEdgeDetectionthreshold1()));
        tfHysteresis2.setText(String.format("%1$.2f", params.getEdgeDetectionthreshold2()));
        tfSegmentLengthSingle.setInt(params.getSegmentLengthSingle());
        tfSegmentLengthMerged.setInt(params.getSegmentLengthMerged());
        tfSegmentDistanceMerge.setInt(params.getSegmentDistanceMerge());
        cbJunctionCrossing.setSelected(params.isOnlyJunctionCrossings());
        tfJunctionDistance.setText(String.format("%1$.2f", params.getJunctionCrossingDistance()));

        labGamma.setFont(labGamma.getFont().deriveFont(Font.BOLD));
        labHysteresis2.setFont(labHysteresis2.getFont().deriveFont(Font.BOLD));


        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                NerveDetectionParamsDialog.this.params.setFluoImage(cbFluoImage.isSelected());
                NerveDetectionParamsDialog.this.params.setGamma((float) tfGamma.getDouble());
                NerveDetectionParamsDialog.this.params.setUnsharpMaskThrethold1((float) tfUnsharp1.getDouble());
                NerveDetectionParamsDialog.this.params.setUnsharpMaskThrethold2((float) tfUnsharp2.getDouble());
                NerveDetectionParamsDialog.this.params.setEdgeDetectionthreshold1((float) tfHysteresis1.getDouble());
                NerveDetectionParamsDialog.this.params.setEdgeDetectionthreshold2((float) tfHysteresis2.getDouble());
                NerveDetectionParamsDialog.this.params.setSegmentLengthSingle(tfSegmentLengthSingle.getInt());
                NerveDetectionParamsDialog.this.params.setSegmentLengthMerged(tfSegmentLengthMerged.getInt());
                NerveDetectionParamsDialog.this.params.setSegmentDistanceMerge(tfSegmentDistanceMerge.getInt());
                NerveDetectionParamsDialog.this.params.setOnlyJunctionCrossings(cbJunctionCrossing.isSelected());
                NerveDetectionParamsDialog.this.params.setJunctionCrossingDistance(tfJunctionDistance.getDouble());
                NerveDetectionParamsDialog.this.setVisible(false);
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                NerveDetectionParamsDialog.this.setVisible(false);
            }
        });

        initGui();
    }

    private void initGui() {
        setVisible(false);
        setTitle("Nerve Detection Parameters");
        setSize(350, 400);
        setResizable(false);
        RawUtilsCommon.centerComponent(this);

        setLayout(new GridBagLayout());
        JPanel btnPanel = new JPanel();
        btnPanel.add(btnOk);
        btnPanel.add(btnCancel);

        Insets insLab = new Insets(3, 10, 0, 0);
        Insets insTf = new Insets(0, 10, 0, 10);
        Insets insBtn = new Insets(20, 0, 0, 10);
        int y = 0;

        add(labGamma, new GridBagConstraints(0, y, 1, 1, 0, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, insLab, 0, 0));
        add(tfGamma, new GridBagConstraints(1, y, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insTf, 0, 0));
        y++;
        add(labUnsharp1, new GridBagConstraints(0, y, 1, 1, 0, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, insLab, 0, 0));
        add(tfUnsharp1, new GridBagConstraints(1, y, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insTf, 0, 0));
        y++;
        add(labUnsharp2, new GridBagConstraints(0, y, 1, 1, 0, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, insLab, 0, 0));
        add(tfUnsharp2, new GridBagConstraints(1, y, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insTf, 0, 0));
        y++;
        add(labHysteresis1, new GridBagConstraints(0, y, 1, 1, 0, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, insLab, 0, 0));
        add(tfHysteresis1, new GridBagConstraints(1, y, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insTf, 0, 0));
        y++;
        add(labHysteresis2, new GridBagConstraints(0, y, 1, 1, 0, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, insLab, 0, 0));
        add(tfHysteresis2, new GridBagConstraints(1, y, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insTf, 0, 0));
        y++;
        add(labSegmentLengthSingle, new GridBagConstraints(0, y, 1, 1, 0, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, insLab, 0, 0));
        add(tfSegmentLengthSingle, new GridBagConstraints(1, y, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insTf, 0, 0));
        y++;
        add(labSegmentLengthMerged, new GridBagConstraints(0, y, 1, 1, 0, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, insLab, 0, 0));
        add(tfSegmentLengthMerged, new GridBagConstraints(1, y, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insTf, 0, 0));
        y++;
        add(labSegmentDistanceMerge, new GridBagConstraints(0, y, 1, 1, 0, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, insLab, 0, 0));
        add(tfSegmentDistanceMerge, new GridBagConstraints(1, y, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insTf, 0, 0));
        y++;
        add(labJunctionDistance, new GridBagConstraints(0, y, 1, 1, 0, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, insLab, 0, 0));
        add(tfJunctionDistance, new GridBagConstraints(1, y, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insTf, 0, 0));
        y++;
        add(cbJunctionCrossing, new GridBagConstraints(0, y, 2, 1, 1, 0, GridBagConstraints.NORTHEAST, GridBagConstraints.HORIZONTAL, insTf, 0, 0));
        y++;
        add(cbFluoImage, new GridBagConstraints(0, y, 2, 1, 1, 0, GridBagConstraints.NORTHEAST, GridBagConstraints.HORIZONTAL, insTf, 0, 0));

        add(btnPanel, new GridBagConstraints(1, y, 1, 1, 1, 0, GridBagConstraints.SOUTHEAST, GridBagConstraints.NONE, insBtn, 0, 0));
    }

    /**
     * displays the dialog. Call getParams() afterwards to retrieve the parameters.
     */
    public void showDialog() {
        setModalityType(DEFAULT_MODALITY_TYPE);
        this.setVisible(true);
    }

    /**
     * to be called after showDialog()
     *
     * @return
     */
    public NerveDetectionParams getParams() {
        return params;
    }

}
