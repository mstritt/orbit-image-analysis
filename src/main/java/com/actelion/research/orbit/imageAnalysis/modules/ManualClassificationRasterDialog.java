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


import com.actelion.research.orbit.gui.IntInputVerifier;

import javax.accessibility.Accessible;
import javax.accessibility.AccessibleContext;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Dialog to select numX and numY values.
 */
public class ManualClassificationRasterDialog extends JComponent implements Accessible {

    private static final long serialVersionUID = 1L;
    public static String MANUALCLASSIFICATIONRASTER_DIALOGTYPE_CHANGED = "MANUALCLASSIFICATIONRASTER_DIALOGTYPE_CHANGED";
    public static int APPROVE_OPTION = 0;
    public static int CANCEL_OPTION = 1;
    public static int RASTERDIALOG_ERROR = 2;
    private boolean multiSelectionEnabled = false;
    private int status = APPROVE_OPTION;
    private JDialog dialog = null;
    public static final int OPEN_DIALOG = 0;
    public static final int SAVE_DIALOG = 1;
    public static final int CUSTOM_DIALOG = 2;
    private int dialogType = OPEN_DIALOG;
    private String title = "Number X/Y spots";

    private JLabel labNumX = new JLabel("Grid #X spots:");
    private JTextField tfNumX = null;
    private int numX = 30;

    private JLabel labNumY = new JLabel("Grid #Y spots:");
    private JTextField tfNumY = null;
    private int numY = 30;

    public ManualClassificationRasterDialog() {
        setLayout(new GridBagLayout());
        tfNumX = new JTextField(numX + "", 4);
        tfNumY = new JTextField(numY + "", 4);
        tfNumX.setInputVerifier(new IntInputVerifier(numX));
        tfNumY.setInputVerifier(new IntInputVerifier(numY));
        tfNumX.setHorizontalAlignment(JTextField.TRAILING);
        tfNumY.setHorizontalAlignment(JTextField.TRAILING);

        // Buttons
        JButton okBtn = new JButton("Ok");
        okBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    numX = Integer.parseInt(tfNumX.getText());
                    numY = Integer.parseInt(tfNumY.getText());
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(ManualClassificationRasterDialog.this, "Error parsing values. Please enter correct integer values.", "Error parsing values.", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                setStatus(APPROVE_OPTION);
                exitProcedure();
            }
        });
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setStatus(CANCEL_OPTION);
                exitProcedure();
            }
        });
        JPanel btnPanel = new JPanel();
        btnPanel.add(okBtn);
        btnPanel.add(cancelBtn);

        // Layout
        GridBagConstraints gbcLabX = new GridBagConstraints();
        gbcLabX.anchor = GridBagConstraints.NORTHWEST;
        gbcLabX.gridx = 0;
        gbcLabX.gridy = 0;
        gbcLabX.insets = new Insets(5, 5, 5, 5);

        GridBagConstraints gbcLabY = new GridBagConstraints();
        gbcLabY.anchor = GridBagConstraints.NORTHWEST;
        gbcLabY.gridx = 0;
        gbcLabY.gridy = 1;
        gbcLabY.insets = new Insets(5, 5, 5, 5);

        GridBagConstraints gbcBoxWidthLab = new GridBagConstraints();
        gbcBoxWidthLab.anchor = GridBagConstraints.NORTHWEST;
        gbcBoxWidthLab.gridx = 0;
        gbcBoxWidthLab.gridy = 2;
        gbcBoxWidthLab.insets = new Insets(5, 5, 5, 5);

        GridBagConstraints gbcFieldX = new GridBagConstraints();
        gbcFieldX.anchor = GridBagConstraints.NORTHEAST;
        gbcFieldX.gridx = 1;
        gbcFieldX.gridy = 0;
        gbcFieldX.insets = new Insets(0, 5, 5, 5);

        GridBagConstraints gbcFieldY = new GridBagConstraints();
        gbcFieldY.anchor = GridBagConstraints.NORTHEAST;
        gbcFieldY.gridx = 1;
        gbcFieldY.gridy = 1;
        gbcFieldY.insets = new Insets(0, 5, 5, 5);

        GridBagConstraints gbcFieldBoxWidth = new GridBagConstraints();
        gbcFieldBoxWidth.anchor = GridBagConstraints.NORTHEAST;
        gbcFieldBoxWidth.gridx = 1;
        gbcFieldBoxWidth.gridy = 2;
        gbcFieldBoxWidth.insets = new Insets(0, 5, 5, 5);

        GridBagConstraints gbcBtn = new GridBagConstraints();
        gbcBtn.anchor = GridBagConstraints.SOUTHEAST;
        gbcBtn.gridwidth = GridBagConstraints.REMAINDER;
        gbcBtn.gridx = 0;
        gbcBtn.gridy = 3;
        gbcBtn.insets = new Insets(15, 0, 0, 0);

        add(labNumX, gbcLabX);
        add(labNumY, gbcLabY);
        add(tfNumX, gbcFieldX);
        add(tfNumY, gbcFieldY);
        add(btnPanel, gbcBtn);

        setPreferredSize(new Dimension(200, 150));

        //	this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        /*
        this.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
		    exitProcedure();
		    }
	    });
	    */
    }


    public void setDialogType(int dialogType) {
        if (this.dialogType == dialogType) {
            return;
        }
        if (!(dialogType == OPEN_DIALOG || dialogType == SAVE_DIALOG || dialogType == CUSTOM_DIALOG)) {
            throw new IllegalArgumentException("Incorrect Dialog Type: " + dialogType);
        }
        int oldValue = this.dialogType;
        this.dialogType = dialogType;
        if (dialogType == OPEN_DIALOG || dialogType == SAVE_DIALOG) {
          /*  setApproveButtonText(null); */
        }
        firePropertyChange(MANUALCLASSIFICATIONRASTER_DIALOGTYPE_CHANGED, oldValue, dialogType);
    }

    public int getDialogType() {
        return dialogType;
    }


    public int showOpenDialog(Component parent) throws HeadlessException {
        setDialogType(OPEN_DIALOG);
        return showDialog(parent, null);
    }

    public int showDialog(Component parent, String approveButtonText) throws HeadlessException {
        dialog = createDialog(parent);
        dialog.setResizable(false);
        dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                status = CANCEL_OPTION;
            }
        });
        status = RASTERDIALOG_ERROR;
        dialog.setVisible(true);
        firePropertyChange("RasterDialogClosingProperty", dialog, null);
        dialog.removeAll();
        dialog.dispose();
        dialog = null;
        return status;
    }


    protected JDialog createDialog(Component parent) throws HeadlessException {
        putClientProperty(AccessibleContext.ACCESSIBLE_DESCRIPTION_PROPERTY,
                title);

        JDialog dialog;

        //Window window = JOptionPane.getWindowForComponent(parent);
        Component window = parent;
        if (window instanceof Frame) {
            dialog = new JDialog((Frame) window, title, true);
        } else {
            if (window instanceof Dialog) {
                dialog = new JDialog((Dialog) window, title, true);
            } else if (window instanceof Window) {
                dialog = new JDialog((Window) window, title, JDialog.DEFAULT_MODALITY_TYPE);
            } else {
                throw new IllegalArgumentException("parent must be a frame, dialog or window");
            }
        }
        dialog.setComponentOrientation(this.getComponentOrientation());

        Container contentPane = dialog.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(this, BorderLayout.CENTER);

        if (JDialog.isDefaultLookAndFeelDecorated()) {
            boolean supportsWindowDecorations =
                    UIManager.getLookAndFeel().getSupportsWindowDecorations();
            if (supportsWindowDecorations) {
                dialog.getRootPane().setWindowDecorationStyle(JRootPane.FILE_CHOOSER_DIALOG);
            }
        }
        dialog.pack();
        dialog.setLocationRelativeTo(parent);

        return dialog;
    }


    private void exitProcedure() {
        dialog.setVisible(false);
    }


    public int getNumX() {
        return numX;
    }

    public void setNumX(int numX) {
        this.numX = numX;
    }

    public int getNumY() {
        return numY;
    }

    public void setNumY(int numY) {
        this.numY = numY;
    }

    public boolean isMultiSelectionEnabled() {
        return multiSelectionEnabled;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public JLabel getLabNumX() {
        return labNumX;
    }

    public JLabel getLabNumY() {
        return labNumY;
    }

}
