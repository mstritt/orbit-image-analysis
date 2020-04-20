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

import com.actelion.research.orbit.gui.IntInputVerifier;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.ModelAnnotation;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.utils.RawUtilsCommon;
import org.jdesktop.swingx.JXSearchField;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ModelBrowser {

    private OrbitModel selectedModel;

    public static void main(String[] args) throws Exception {

        ModelBrowser browser = new ModelBrowser();
        browser.showModelBrowser(null, "orbit");
    }

    public void showModelBrowser(final Frame owner, final String username) throws Exception {
         showModelBrowser(owner,username,true);
    }

    public void showModelBrowser(final Frame owner, final String username, final boolean loadInOrbit) throws Exception {
        List<ModelAnnotation> modelList = OrbitModel.LoadFromOrbitUser(null);
        for (ModelAnnotation modelAnnotation : modelList) {
            System.out.println("model: " + modelAnnotation.getDescription() + " (" + modelAnnotation.getRawAnnotationId() + ")");
        }

        // display
        final JDialog frame = new JDialog(owner, "Orbit Models", true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(1024, 800);
        frame.setLayout(new BorderLayout());
        frame.setModal(true);

        final TableModel tableModel = new OrbitModelTableModel(modelList);
        final JTable table = new JTable(tableModel);
        table.setAutoCreateRowSorter(true);
        table.getColumnModel().getColumn(4).setCellRenderer(tableCellRenderer);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        final JTextField searchFieldName = new JTextField("Search by Model Name");
        final JTextField searchFieldElb = new JTextField("Search by ELB");
        final JTextField searchFieldId = new JTextField("Search by Model ID");
//        searchFieldName.setRecentSearchesSaveKey("com.actelion.research.orbit.OrbitImageAnalysis.searchfield.modelBrowser.name");
//        searchFieldElb.setRecentSearchesSaveKey("com.actelion.research.orbit.OrbitImageAnalysis.searchfield.modelBrowser.elb");
//        searchFieldId.setRecentSearchesSaveKey("com.actelion.research.orbit.OrbitImageAnalysis.searchfield.modelBrowser.Id");
//        prepareSearchfield(searchFieldName);
//        prepareSearchfield(searchFieldElb);
//        prepareSearchfield(searchFieldId);

        searchFieldName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("find action name: " + searchFieldName.getText());
                table.getRowSorter().allRowsChanged();
            }
        });

        searchFieldElb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("find action elb: " + searchFieldElb.getText());
                table.getRowSorter().allRowsChanged();
            }
        });

        searchFieldId.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("find action id: " + searchFieldId.getText());
                table.getRowSorter().allRowsChanged();
            }
        });
        searchFieldId.setInputVerifier(new IntInputVerifier(0));

        final JCheckBox onlyMine = new JCheckBox("only mine", false);
        onlyMine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("only mine: " + onlyMine.isSelected());
                table.getRowSorter().allRowsChanged();
            }
        });


        // filter
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tableModel);
        RowFilter<Object, Object> filter = new RowFilter<Object, Object>() {
            public boolean include(Entry entry) {
                String nameFilter = searchFieldName.getText();
                String elbFilter = searchFieldElb.getText();
                String idFilter = searchFieldId.getText();
                Integer idNum = null;
                try {
                    idNum = Integer.parseInt(idFilter);
                } catch (Exception e) {
                }
                if (onlyMine.isSelected() && !entry.getStringValue(2).equals(username)) return false;
                if (nameFilter.length() > 0 && !entry.getStringValue(0).toLowerCase().contains(nameFilter.toLowerCase()))
                    return false;
                if (elbFilter.length() > 0 && !entry.getStringValue(1).toLowerCase().contains(elbFilter.toLowerCase()))
                    return false;
                return !(idNum != null && idNum > 0 && idFilter.length() > 0 && !(entry.getValue(3)).equals(idNum));
            }
        };
        sorter.setRowFilter(filter);
        table.setRowSorter(sorter);


        final JButton loadButton = new JButton("load");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() >= 0) {
                    final ModelAnnotation annotation = (ModelAnnotation) table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), -1);
                    selectedModel = annotation.getModel();
                    if (loadInOrbit) {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                OrbitImageAnalysis.getInstance().loadModel(annotation.getModel(), getNameAndELB(annotation.getDescription())[0]);
                            }
                        });
                    }
                    frame.setVisible(false);
                    frame.dispose();
                }
            }
        });

        final JButton cancelButton = new JButton("cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
            }
        });

        final JButton delButton = new JButton("delete");
        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() >= 0) {
                    final ModelAnnotation annotation = (ModelAnnotation) table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), -1);
                    // security check
                    if ((username.equalsIgnoreCase(annotation.getUserId())) || DALConfig.getImageProvider().getAdminUsers().contains(username)) {
                        if (JOptionPane.showConfirmDialog(frame,
                                "Do you really want to delete the model '" + annotation.getDescription() + "'",
                                "Delete Model", JOptionPane.YES_NO_OPTION)
                                == JOptionPane.YES_OPTION) {
                            boolean deleted = false;
                            try {
                                deleted = DALConfig.getImageProvider().DeleteRawAnnotation(annotation.getRawAnnotationId());
                                ((OrbitModelTableModel) table.getModel()).removeElement(annotation);
                                table.getRowSorter().allRowsChanged();
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                            if (deleted)
                                JOptionPane.showMessageDialog(frame, "Model successfully deleted.", "Success", JOptionPane.INFORMATION_MESSAGE);
                            else
                                JOptionPane.showMessageDialog(frame, "Could not delete model (see log for details).", "Failure", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Sorry, but you are not the owner of this model.", "Cannot delete model", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        final JButton copyButton = new JButton("copy identifier");
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() >= 0) {
                    ModelAnnotation annotation = (ModelAnnotation) table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), -1);
                    String ident = annotation.getDescription() + " (" + annotation.getRawAnnotationId() + ")";
                    Transferable stringSelection = new StringSelection(ident);
                    Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clpbrd.setContents(stringSelection, null);
                    JOptionPane.showMessageDialog(frame, "Model identifier copied to clipboard.", "Copied to clipboard", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        final JButton downloadButton = new JButton("download");
        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() >= 0) {
                    final ModelAnnotation annotation = (ModelAnnotation) table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), -1);
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            String fn = getNameAndELB(annotation.getDescription())[0];
                            if (!fn.toLowerCase().endsWith(OrbitUtils.MODEL_ENDING))
                                fn += OrbitUtils.MODEL_ENDING;
                            OrbitImageAnalysis.getInstance().saveModel(annotation.getModel(), fn);
                            //JOptionPane.showMessageDialog(frame,"Model identifier copied to clipboard.","Copied to clipboard",JOptionPane.INFORMATION_MESSAGE);
                        }
                    });
                }
            }
        });


        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel searchPanel = new JPanel(new GridLayout(1, 3));
        searchPanel.add(searchFieldName);
        searchPanel.add(searchFieldElb);
        searchPanel.add(searchFieldId);
        topPanel.add(searchPanel, BorderLayout.CENTER);
        topPanel.add(onlyMine, BorderLayout.EAST);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel leftBottomPanel = new JPanel();
        leftBottomPanel.add(delButton);
        leftBottomPanel.add(downloadButton);
        leftBottomPanel.add(copyButton);

        JPanel rightBottomPanel = new JPanel();
        rightBottomPanel.add(loadButton);
        rightBottomPanel.add(cancelButton);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(leftBottomPanel, BorderLayout.WEST);
        bottomPanel.add(rightBottomPanel, BorderLayout.EAST);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        RawUtilsCommon.centerComponent(frame);
        frame.setVisible(true);
    }

    @Deprecated
    private void prepareSearchfield(JXSearchField searchField) {
        searchField.setSearchMode(JXSearchField.SearchMode.INSTANT);
        searchField.setInstantSearchDelay(250);
        searchField.getRecentSearches().setMaxRecents(40);
        if (OrbitUtils.DARKUI) {
            searchField.setDisabledTextColor(Color.lightGray);
            searchField.setUseSeperatePopupButton(false);
            searchField.setLayoutStyle(JXSearchField.LayoutStyle.MAC);
            searchField.getPopupButton().setIcon(new ImageIcon(this.getClass().getResource("/resource/nav_down.png")));
            searchField.getPopupButton().setPressedIcon(new ImageIcon(this.getClass().getResource("/resource/nav_down.png")));
            searchField.getPopupButton().setRolloverIcon(new ImageIcon(this.getClass().getResource("/resource/nav_down.png")));
            searchField.getCancelButton().setIcon(new ImageIcon(this.getClass().getResource("/resource/delete2.png")));
            searchField.getCancelButton().setPressedIcon(new ImageIcon(this.getClass().getResource("/resource/delete2.png")));
            searchField.getCancelButton().setRolloverIcon(new ImageIcon(this.getClass().getResource("/resource/delete2.png")));
        }
    }


    private String[] getNameAndELB(String descr) {
        String name = descr;
        String elb = "";
        // description is in format "[ELB] name" - so we extract the elb form the name here
        if (descr.contains("[") && descr.contains("]")) {
            elb = descr.substring(descr.indexOf("["), descr.indexOf("]") + 1);
            elb = elb.replaceAll("\\[", "").replaceAll("]", "").trim();
            name = descr.replaceAll("\\[" + elb + "]", "").trim();
            name = name.replaceAll("\\[", "").replaceAll("]", "").trim();
        }
        return new String[]{name, elb};
    }


    class OrbitModelTableModel extends AbstractTableModel {

        private String[] columnNames = new String[]{"Name", "ELB", "User", "Id", "Date"};
        private List<ModelAnnotation> modelAnnotations;

        public OrbitModelTableModel(List<ModelAnnotation> modelAnnotations) {
            this.modelAnnotations = modelAnnotations;
        }


        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return modelAnnotations.size();
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            ModelAnnotation modelAnnotation = modelAnnotations.get(row);
            if (col < 0) return modelAnnotation; // <0 return the "full row"
            String[] nameAndElb = getNameAndELB(modelAnnotation.getDescription());
            String name = nameAndElb[0];
            String elb = nameAndElb[1];

            switch (col) {
                case 0:
                    return name;
                case 1:
                    return elb;
                case 2:
                    return modelAnnotations.get(row).getUserId();
                case 3:
                    return modelAnnotations.get(row).getRawAnnotationId();
                case 4:
                    return modelAnnotations.get(row).getModifyDate();
                default:
                    return modelAnnotations.get(row).getDescription();
            }
        }

        public Class getColumnClass(int c) {
            if (modelAnnotations.size() == 0) return String.class; // no data available
            return getValueAt(0, c).getClass();
        }

        public void removeRow(int row) {
            modelAnnotations.remove(row);
        }

        public void removeElement(ModelAnnotation element) {
            modelAnnotations.remove(element);
        }

    }

    protected TableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {
        {
            setHorizontalAlignment(JLabel.RIGHT);
        }

        SimpleDateFormat f = new SimpleDateFormat("HH:mm   dd.MM.yyyy");

        public Component getTableCellRendererComponent(JTable table,
                                                       Object value, boolean isSelected, boolean hasFocus,
                                                       int row, int column) {
            if (value instanceof Date) {
                value = f.format(value);
            }
            return super.getTableCellRendererComponent(table, value, isSelected,
                    hasFocus, row, column);
        }
    };

    public OrbitModel getSelectedModel() {
        return selectedModel;
    }
}
