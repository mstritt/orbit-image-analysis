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

import com.actelion.research.orbit.beans.RawData;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.beans.RawMeta;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.utils.RawUtilsCommon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashSet;

public class MetaCellEditor extends AbstractCellEditor implements TableCellEditor {

    private static final long serialVersionUID = 1L;
    protected static final String EDIT = "edit";
    protected static final String[] writeableMetas = new String[]{"Description", "Comment", "Keywords", "Origin", "Lab Name", "Organ", "Filename"};
    protected Logger logger = LoggerFactory.getLogger(MetaCellEditor.class);
    private JDialog dialog = null;
    private JTextArea textArea = new JTextArea();
    private JButton saveBtn = new JButton("Save");
    private JButton saveAndCloseBtn = new JButton("Save & Close");
    private JButton closeBtn = new JButton("Close");
    protected RawMeta key = null;
    private HashSet<String> writeableKeySet = null;

    public MetaCellEditor() {

        dialog = new JDialog();

        saveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });

        saveAndCloseBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                save();
                close();
            }
        });

        closeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });


        GridBagConstraints gbcTextfield = new GridBagConstraints();
        gbcTextfield.weightx = 1.0;
        gbcTextfield.weighty = 1.0;
        gbcTextfield.anchor = GridBagConstraints.NORTHEAST;
        gbcTextfield.fill = GridBagConstraints.BOTH;
        gbcTextfield.gridwidth = GridBagConstraints.REMAINDER;
        gbcTextfield.gridx = 0;
        gbcTextfield.gridy = 0;

        GridBagConstraints gbcBtnPanel = new GridBagConstraints();
        gbcBtnPanel.insets = new Insets(0, 0, 0, 0);
        gbcBtnPanel.weightx = 0.0;
        gbcBtnPanel.weighty = 0.0;
        gbcBtnPanel.anchor = GridBagConstraints.SOUTHEAST;
        gbcBtnPanel.fill = GridBagConstraints.REMAINDER;
        gbcBtnPanel.gridx = 0;
        gbcBtnPanel.gridy = 1;

        GridBagConstraints gbcSaveBtn = new GridBagConstraints();
        gbcSaveBtn.insets = new Insets(2, 0, 2, 2);
        gbcSaveBtn.weightx = 0.0;
        gbcSaveBtn.weighty = 0.0;
        gbcSaveBtn.anchor = GridBagConstraints.SOUTHEAST;
        gbcSaveBtn.fill = GridBagConstraints.NONE;
        gbcSaveBtn.gridx = 0;
        gbcSaveBtn.gridy = 0;

        GridBagConstraints gbcSaveAndCloseBtn = new GridBagConstraints();
        gbcSaveAndCloseBtn.insets = new Insets(2, 0, 2, 2);
        gbcSaveAndCloseBtn.weightx = 0.0;
        gbcSaveAndCloseBtn.weighty = 0.0;
        gbcSaveAndCloseBtn.anchor = GridBagConstraints.SOUTHEAST;
        gbcSaveAndCloseBtn.fill = GridBagConstraints.NONE;
        gbcSaveAndCloseBtn.gridx = 1;
        gbcSaveAndCloseBtn.gridy = 0;

        GridBagConstraints gbcCloseBtn = new GridBagConstraints();
        gbcCloseBtn.insets = new Insets(2, 0, 2, 2);
        gbcCloseBtn.weightx = 0.0;
        gbcCloseBtn.weighty = 0.0;
        gbcCloseBtn.anchor = GridBagConstraints.SOUTHEAST;
        gbcCloseBtn.fill = GridBagConstraints.NONE;
        gbcCloseBtn.gridx = 2;
        gbcCloseBtn.gridy = 0;

        JPanel btnPanel = new JPanel(new GridBagLayout());
        btnPanel.add(saveBtn, gbcSaveBtn);
        btnPanel.add(saveAndCloseBtn, gbcSaveAndCloseBtn);
        btnPanel.add(closeBtn, gbcCloseBtn);

        dialog.setLayout(new GridBagLayout());
        dialog.add(new JScrollPane(textArea), gbcTextfield);
        dialog.add(btnPanel, gbcBtnPanel);
        dialog.pack();

        dialog.setSize(400, 200);
        Toolkit toolkit = dialog.getToolkit();
        Dimension size = toolkit.getScreenSize();
        dialog.setLocation((size.width - dialog.getWidth()) / 2, (size.height - dialog.getHeight()) / 2);
    }

    protected HashSet<String> getWriteableKeyset() {
        if (writeableKeySet == null) {
            writeableKeySet = new HashSet<String>();
            for (String k : writeableMetas) {
                writeableKeySet.add(k.toLowerCase());
            }
        }
        return writeableKeySet;
    }

    private void save() {
        if (key != null) {
            String strKey = key.getName().toLowerCase();
            if (isWriteable(strKey)) {
                //System.out.println("save "+key.getRawDataFileId()+" / "+key.getRawDataId());
                try {
                    if (strKey.equalsIgnoreCase("Comment")) {
                        if (key.getRawDataId() > 0) { // update rawData
                            RawData rd = DALConfig.getImageProvider().LoadRawData(key.getRawDataId());
                            rd.setComment(textArea.getText());
                            if (!DALConfig.getImageProvider().UpdateRawData(rd))
                                logger.error("Error updating meta data for RawData");
                        }
                    }
                    if (strKey.equalsIgnoreCase("Description")) {
                        if (key.getRawDataId() > 0) { // update rawData
                            RawData rd = DALConfig.getImageProvider().LoadRawData(key.getRawDataId());
                            rd.setDescription(textArea.getText());
                            if (!DALConfig.getImageProvider().UpdateRawData(rd))
                                logger.error("Error updating meta data for RawData");
                        }
                    }
                    if (strKey.equalsIgnoreCase("Lab Name")) {
                        if (key.getRawDataId() > 0) { // update rawData
                            RawData rd = DALConfig.getImageProvider().LoadRawData(key.getRawDataId());
                            rd.setLabname(textArea.getText());
                            if (!DALConfig.getImageProvider().UpdateRawData(rd))
                                logger.error("Error updating meta data for RawData");
                        }
                    }
                    if (strKey.equalsIgnoreCase("Keywords")) {
                        if (key.getRawDataId() > 0) { // update rawData
                            RawData rd = DALConfig.getImageProvider().LoadRawData(key.getRawDataId());
                            rd.setKeywords(textArea.getText());
                            if (!DALConfig.getImageProvider().UpdateRawData(rd))
                                logger.error("Error updating meta data for RawData");
                        }
                    }
                    if (strKey.equalsIgnoreCase("Origin")) {
                        if (key.getRawDataId() > 0) { // update rawData
                            RawData rd = DALConfig.getImageProvider().LoadRawData(key.getRawDataId());
                            rd.setOrigin(textArea.getText());
                            if (!DALConfig.getImageProvider().UpdateRawData(rd))
                                logger.error("Error updating meta data for RawData");
                        }
                    }
                    // meta data for raw data (=organ)
                    if (strKey.equalsIgnoreCase("Organ") || strKey.equals("Description") || strKey.equals("Comment")) {
                        if (key.getRawMetaId() > 0) { // update rawMeta
                            key.setValue(textArea.getText());
                            if (!DALConfig.getImageProvider().UpdateRawMeta(key))
                                logger.error("Error updating meta data for RawData");
                        }
                    }
                    // meta data for raw data file (=description and comment)
                    if ((key.getName().equals("Description") || key.getName().equals("Comment")) && key.getRawDataId() <= 0) {
                        if (key.getRawMetaId() > 0) { // update rawMeta
                            key.setValue(textArea.getText());
                            key.setModifyDate(new Date());
                            if (!DALConfig.getImageProvider().UpdateRawMeta(key))
                                logger.error("Error updating meta data for RawDataFile");
                        } else if (key.getRawMetaId() == 0 && key.getRawDataFileId() > 0) {
                            // insert new meta data
                            key.setValue(textArea.getText());
                            key.setModifyDate(new Date());
                            if (DALConfig.getImageProvider().InsertRawMeta(key) <= 0)
                                logger.error("Error inserting meta data for RawDataFile");
                        }
                    }

                    if (strKey.equalsIgnoreCase("Filename")) {
                        RawDataFile rdf = DALConfig.getImageProvider().LoadRawDataFile(key.getRawDataFileId());
                        String ext = RawUtilsCommon.getExtension(rdf.getFileName());
                        if (textArea.getText().toLowerCase().endsWith(ext)) {
                            rdf.setFileName(textArea.getText());
                            DALConfig.getImageProvider().UpdateRawDataFile(rdf);
                            // TODO: update sidebar
                        } else {
                            JOptionPane.showMessageDialog(null, "Cannot rename filename, ending has to be " + ext + ".", "Error renaming file", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                    logger.info("meta data updated");

                } catch (Exception e) {
                    logger.error("Error updating meta data", e);
                }

            }
        }
    }

    private void close() {
        fireEditingStopped();
        dialog.setVisible(false);
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (isSelected) {

        }
        key = (RawMeta) table.getValueAt(row, 0);
        if (key != null) {
            if (isWriteable(key.getName())) {
                saveBtn.setEnabled(true);
                saveAndCloseBtn.setEnabled(true);
                textArea.setEditable(true);
                dialog.setTitle(key.getName() + " [editable]");
            } else {
                saveBtn.setEnabled(false);
                saveAndCloseBtn.setEnabled(false);
                textArea.setEditable(false);
                dialog.setTitle(key.getName() + " [not editable]");
            }
        }

        textArea.setText((String) value);
        dialog.setVisible(true);
        return new JLabel(" " + value);
    }

    public Object getCellEditorValue() {
        return textArea.getText();
    }


    private boolean isWriteable(String mateName) {
        String userStr = null;
        try {
            if (key.getRawDataFileId() != 0) {
                RawDataFile rdf = DALConfig.getImageProvider().LoadRawDataFile(key.getRawDataFileId());
                if (rdf != null) {
                    userStr = rdf.getUserId();
                }
            } else if (key.getRawDataId() != 0) {
                RawData rd = DALConfig.getImageProvider().LoadRawData(key.getRawDataId());
                if (rd != null) {
                    userStr = rd.getUserId();
                }
            }
            if (userStr != null) {
                key.setUserId(userStr);
            }
        } catch (Exception e) {
            logger.error("error: ", e);
        }
        logger.trace("loginUser: " + OrbitImageAnalysis.loginUser);
        logger.trace("keyUser: " + userStr);

        if (key == null || key.getUserId() == null) return false;
        return ((OrbitImageAnalysis.loginUser.equalsIgnoreCase(userStr) || DALConfig.getImageProvider().getAdminUsers().contains(OrbitImageAnalysis.loginUser)) && getWriteableKeyset().contains(mateName.toLowerCase()));
    }

}
