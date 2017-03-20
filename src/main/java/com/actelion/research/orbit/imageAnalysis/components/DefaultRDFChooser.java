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

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.gui.AbstractOrbitTree;
import com.actelion.research.orbit.gui.RawDataMetaPanel;
import com.actelion.research.orbit.gui.RdfSearchBox;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.utils.RdfThnCellRendererBig;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class DefaultRDFChooser extends JComponent implements Accessible {
    private static final long serialVersionUID = 1L;
    public static String RDFCHOOSER_DIALOGTYPE_CHANGED = "RDFCHOOSER_DIALOGTYPE_CHANGED";
    public static int APPROVE_OPTION = 0;
    public static int CANCEL_OPTION = 1;
    public static int RDFCHOOSER_ERROR = 2;
    private List<RawDataFile> selectedFiles;
    private final ImageList rdfList;
    private AbstractOrbitTree rdTree;
    private boolean multiSelectionEnabled;
    private int status;
    private JDialog dialog;
    public static final int OPEN_DIALOG = 0;
    public static final int SAVE_DIALOG = 1;
    public static final int CUSTOM_DIALOG = 2;
    private int dialogType;
    private String title;
    private final RdfSearchBox searchBox;
    private final RawDataMetaPanel rawDataMetaPanel;
    private final JLabel numResultLabel;


    public DefaultRDFChooser() {
        this.selectedFiles = null;
        this.rdfList = new ImageList(new RdfThnCellRendererBig(DALConfig.getImageProvider()));
        this.multiSelectionEnabled = false;
        this.status = APPROVE_OPTION;
        this.dialog = null;
        this.dialogType = 0;
        this.title = "Orbit Data Chooser";
        this.searchBox = new RdfSearchBox();
        this.rawDataMetaPanel = new RawDataMetaPanel();
        this.numResultLabel = new JLabel("0 Results");

        this.rdTree = DALConfig.getImageProvider().createOrbitTree();
        this.rdTree.addPropertyChangeListener(this.rdfList);
        this.rdTree.addPropertyChangeListener(this.rawDataMetaPanel);

        this.setLayout(new GridBagLayout());
        this.rdfList.setBackground(Color.white);
        this.rdfList.addPropertyChangeListener("RDFLIST_modelSize", new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                int size = ((Integer) evt.getNewValue()).intValue();
                DefaultRDFChooser.this.numResultLabel.setText(size + " Results");
            }
        });
        this.searchBox.addPropertyChangeListener(this.rdfList);
        JButton okBtn = new JButton("Load");
        okBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultRDFChooser.this.loadFile();
            }
        });
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultRDFChooser.this.setStatus(DefaultRDFChooser.CANCEL_OPTION);
                DefaultRDFChooser.this.exitProcedure();
            }
        });
        JPanel btnPanel = new JPanel();
        btnPanel.add(okBtn);
        btnPanel.add(cancelBtn);
        MouseAdapter ml = new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (DefaultRDFChooser.this.rdfList.getSelectedValue() != null && e.getButton() == 1 && e.getClickCount() >= 2) {
                    DefaultRDFChooser.this.loadFile();
                }

            }
        };
        this.rdfList.addMouseListener(ml);
        GridBagConstraints gbcSplitPane = new GridBagConstraints();
        gbcSplitPane.weightx = 1.0D;
        gbcSplitPane.weighty = 1.0D;
        gbcSplitPane.anchor = 18;
        gbcSplitPane.fill = 1;
        gbcSplitPane.gridx = 0;
        gbcSplitPane.gridy = 0;
        GridBagConstraints gbcBtn = new GridBagConstraints();
        gbcBtn.weightx = 0.0D;
        gbcBtn.weighty = 0.0D;
        gbcBtn.anchor = 14;
        gbcBtn.fill = 0;
        gbcBtn.gridx = 0;
        gbcBtn.gridy = 2;
        JScrollPane listScrollPane = new JScrollPane(this.rdfList);
        final JTabbedPane leftPanel = new JTabbedPane();
        JScrollPane xPressPanel = new JScrollPane(this.rdTree);
        xPressPanel.setPreferredSize(new Dimension(250, 400));
        xPressPanel.getVerticalScrollBar().setUnitIncrement(16);
        leftPanel.add("Raw Data", xPressPanel);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(this.searchBox, "North");
        rightPanel.add(listScrollPane, "Center");
        rightPanel.add(this.numResultLabel, "South");
        JSplitPane splitPane = new JSplitPane(1, leftPanel, rightPanel);
        this.rawDataMetaPanel.setPreferredSize(new Dimension(690, 150));
        this.add(splitPane, gbcSplitPane);
        this.add(this.rawDataMetaPanel, new GridBagConstraints(0, 1, 0, 1, 1.0D, 0.0D, 18, 2, new Insets(5, 5, 0, 0), 0, 0));
        this.add(btnPanel, gbcBtn);
        this.setPreferredSize(new Dimension(700, 800));

    }

    private void loadFile() {
        this.selectedFiles = new ArrayList(this.rdfList.getSelectedValues().length);
        if (this.rdfList.getSelectedValues().length > 0) {
            Object[] var1 = this.rdfList.getSelectedValues();
            int var2 = var1.length;

            for (int var3 = 0; var3 < var2; ++var3) {
                Object obj = var1[var3];
                if (obj instanceof RawDataFile) {
                    RawDataFile rdf = (RawDataFile) obj;
                    this.selectedFiles.add(rdf);
                }
            }
        }

        this.setStatus(APPROVE_OPTION);
        this.exitProcedure();
    }

    public void setDialogType(int dialogType) {
        if (this.dialogType != dialogType) {
            if (dialogType != 0 && dialogType != 1 && dialogType != 2) {
                throw new IllegalArgumentException("Incorrect Dialog Type: " + dialogType);
            } else {
                int oldValue = this.dialogType;
                this.dialogType = dialogType;
                if (dialogType != 0 && dialogType == 1) {
                    ;
                }

                this.firePropertyChange(RDFCHOOSER_DIALOGTYPE_CHANGED, oldValue, dialogType);
            }
        }
    }

    public int getDialogType() {
        return this.dialogType;
    }

    public int showOpenDialog(Component parent) throws HeadlessException {
        this.setDialogType(0);
        return this.showDialog(parent, null);
    }

    public int showDialog(Component parent, String approveButtonText) throws HeadlessException {
        this.dialog = this.createDialog(parent);
        this.dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                DefaultRDFChooser.this.status = DefaultRDFChooser.CANCEL_OPTION;
            }
        });
        this.status = RDFCHOOSER_ERROR;
        this.dialog.setVisible(true);
        this.firePropertyChange("RDFChooserClosingProperty", this.dialog, null);
        this.dialog.removeAll();
        this.dialog.dispose();
        this.dialog = null;
        return this.status;
    }

    protected JDialog createDialog(Component parent) throws HeadlessException {
        this.putClientProperty("AccessibleDescription", this.title);
        JDialog dialog;
        if (parent instanceof Frame) {
            dialog = new JDialog((Frame) parent, this.title, true);
        } else {
            dialog = new JDialog((Dialog) parent, this.title, true);
        }

        dialog.setComponentOrientation(this.getComponentOrientation());
        Container contentPane = dialog.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(this, "Center");
        if (JDialog.isDefaultLookAndFeelDecorated()) {
            boolean supportsWindowDecorations = UIManager.getLookAndFeel().getSupportsWindowDecorations();
            if (supportsWindowDecorations) {
                dialog.getRootPane().setWindowDecorationStyle(6);
            }
        }

        dialog.pack();
        dialog.setLocationRelativeTo(parent);
        return dialog;
    }

    private void exitProcedure() {
        this.dialog.setVisible(false);
    }

    public RawDataFile getSelectedFile() {
        return this.getSelectedFiles() != null && this.getSelectedFiles().size() > 0 ? this.getSelectedFiles().get(0) : null;
    }

    public List<RawDataFile> getSelectedFiles() {
        return this.selectedFiles;
    }

    public void setSelectedFiles(List<RawDataFile> selectedFiles) {
        this.selectedFiles = selectedFiles;
    }

    public boolean isMultiSelectionEnabled() {
        return this.multiSelectionEnabled;
    }

    public void setMultiSelectionEnabled(boolean multiSelectionEnabled) {
        this.multiSelectionEnabled = multiSelectionEnabled;
        if (multiSelectionEnabled) {
            this.rdfList.setSelectionMode(2);
        } else {
            this.rdfList.setSelectionMode(0);
        }

    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
