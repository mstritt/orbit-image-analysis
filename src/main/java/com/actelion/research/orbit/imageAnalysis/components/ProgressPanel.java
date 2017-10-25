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

import com.actelion.research.orbit.imageAnalysis.tasks.OrbitWorker;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ProgressPanel extends JPanel implements PropertyChangeListener {

    public static final String PROGRESS_DONE = "progressPanel_done";
    private static final long serialVersionUID = 1L;
    private OrbitWorker worker = null;
    private int progress = 0;
    private boolean paused = false;
    private boolean canceled = false;

    private JProgressBar progressBar = null;
    private JLabel workerNameLabel = null;
    private JButton btnPauseResume = null;
    private JButton btnCancel = null;

    public ProgressPanel(String imageName, String workerName, OrbitWorker worker) {
        this.worker = worker;
        setName(workerName + " (" + imageName + ")");
        // build GUI
        workerNameLabel = new JLabel("<HTML><BODY>" + workerName + "<BR/>(" + imageName + ")</BODY></HTML>");
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        progressBar.setValue(0);
        btnPauseResume = new JButton("pause");

        btnPauseResume.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (paused) {
                    ProgressPanel.this.worker.resume();
                    paused = false;
                    btnPauseResume.setText("pause");
                } else {
                    ProgressPanel.this.worker.pause();
                    paused = true;
                    btnPauseResume.setText("resume");
                }
            }
        });
        btnCancel = new JButton("cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                canceled = true;
                ProgressPanel.this.worker.cancel(true);
            }
        });

        // build GridBagLayout/Constraints
        setLayout(new GridBagLayout());
        GridBagConstraints gbcNameLabel = new GridBagConstraints();
        gbcNameLabel.insets = new Insets(1, 0, 1, 0);
        gbcNameLabel.weightx = 1.0;
        gbcNameLabel.weighty = 0.0;
        gbcNameLabel.anchor = GridBagConstraints.NORTHWEST;
        gbcNameLabel.fill = GridBagConstraints.VERTICAL;
        gbcNameLabel.gridx = 0;
        gbcNameLabel.gridy = 0;

        GridBagConstraints gbcBtnPauseResume = new GridBagConstraints();
        gbcBtnPauseResume.insets = new Insets(1, 0, 1, 0);
        gbcBtnPauseResume.weightx = 1.0;
        gbcBtnPauseResume.weighty = 0.0;
        gbcBtnPauseResume.anchor = GridBagConstraints.NORTHEAST;
        gbcBtnPauseResume.fill = GridBagConstraints.HORIZONTAL;
        gbcBtnPauseResume.gridx = 1;
        gbcBtnPauseResume.gridy = 0;

        GridBagConstraints gbcBtnCancel = new GridBagConstraints();
        gbcBtnCancel.insets = new Insets(1, 0, 1, 0);
        gbcBtnCancel.weightx = 1.0;
        gbcBtnCancel.weighty = 0.0;
        gbcBtnCancel.anchor = GridBagConstraints.NORTHEAST;
        gbcBtnCancel.fill = GridBagConstraints.HORIZONTAL;
        gbcBtnCancel.gridx = 2;
        gbcBtnCancel.gridy = 0;

        GridBagConstraints gbcProgressBar = new GridBagConstraints();
        gbcProgressBar.insets = new Insets(1, 0, 5, 0);
        gbcProgressBar.weightx = 1.0;
        gbcProgressBar.weighty = 0.0;
        gbcProgressBar.gridwidth = GridBagConstraints.REMAINDER;
        gbcProgressBar.anchor = GridBagConstraints.NORTHWEST;
        gbcProgressBar.fill = GridBagConstraints.HORIZONTAL;
        gbcProgressBar.gridx = 0;
        gbcProgressBar.gridy = 1;


        add(workerNameLabel, gbcNameLabel);
        add(progressBar, gbcProgressBar);
        add(btnPauseResume, gbcBtnPauseResume);
        add(btnCancel, gbcBtnCancel);
    }


    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("progress") && (evt.getSource() instanceof OrbitWorker)) {
            progress = (Integer) evt.getNewValue();
            if (progressBar != null) {
                progressBar.setValue(progress);
                String s = progress + "%";
                if (evt.getSource() instanceof OrbitWorker) {
                    s += " (" + OrbitUtils.formatTime(((OrbitWorker) evt.getSource()).getTimeEst() / 1000d) + ")";
                }
                progressBar.setString(s);
            }
            //repaint();
        } else if (evt.getPropertyName().equals(OrbitWorker.TASK_DONE) && (evt.getSource() instanceof OrbitWorker)) {
            if (canceled) {
                progressBar.setValue(0);
                progressBar.setString("0%");
                canceled = false; // for new execution
                firePropertyChange(PROGRESS_DONE, null, false);
            } else firePropertyChange(PROGRESS_DONE, null, true);

        }
    }


    public OrbitWorker getWorker() {
        return worker;
    }


    public void setWorker(OrbitWorker worker) {
        this.worker = worker;
    }


}
