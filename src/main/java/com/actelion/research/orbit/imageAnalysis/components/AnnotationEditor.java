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

import com.actelion.research.orbit.imageAnalysis.models.ImageAnnotation;
import com.actelion.research.orbit.imageAnalysis.models.PolygonExt;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnnotationEditor extends JDialog {

    private static final long serialVersionUID = 1L;
    protected final Logger logger = LoggerFactory.getLogger(AnnotationEditor.class);
    private final JTextArea textArea = new JTextArea();
    private final JButton okBtn = new JButton("Ok");
    private final JButton cancelBtn = new JButton("Cancel");
    private final JButton colorChooseBtn = new JButton("change");
    private final JLabel subTypeLabel = new JLabel("Type:");
    private final JLabel groupLabel = new JLabel("Group:");
    private final JLabel colorLabel = new JLabel("Shape Color:");
    private final JCheckBox cbClosed = new JCheckBox("closed polygon", true);
    @SuppressWarnings({"unchecked", "rawtypes"})
    private final JComboBox cbSubType = new JComboBox(new ImageAnnotation.SubType[]{
            new ImageAnnotation.SubType(ImageAnnotation.SUBTYPE_NORMAL),
            new ImageAnnotation.SubType(ImageAnnotation.SUBTYPE_ROI),
            new ImageAnnotation.SubType(ImageAnnotation.SUBTYPE_EXCLUSION),
            new ImageAnnotation.SubType(ImageAnnotation.SUBTYPE_INCLUSION)
    });
    @SuppressWarnings({"unchecked", "rawtypes"})
    private final JComboBox cbGroup = new JComboBox(buildGroupList());
    private List<ImageAnnotation> annotations = null;
    private List<AnnotationProperties> annotationProperties = null;

    private Integer[] buildGroupList() {
        List<Integer> list = new ArrayList<Integer>(OrbitUtils.ANNOTATION_GROUPS);
        for (int i = 0; i < OrbitUtils.ANNOTATION_GROUPS; i++)
            list.add(i + 1);
        return list.toArray(new Integer[0]);
    }

    public AnnotationEditor(final List<ImageAnnotation> annotations) {
        setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.annotations = annotations;
        this.setTitle("Edit Annotation(s)");
        this.setIconImage(OrbitImageAnalysis.getInstance().getIconImage());


        // save properties for restore
        if (annotationNotNull()) {
            annotationProperties = new ArrayList<AnnotationEditor.AnnotationProperties>(annotations.size());
            for (ImageAnnotation anno : annotations) {
                annotationProperties.add(new AnnotationProperties(anno));
            }
        }

        if (annotations.size() == 1) {
            textArea.setText(annotations.get(0).getDescription());
            textArea.setEditable(true);
            textArea.setEnabled(true);
        } else {
            textArea.setText("<disabled for multi annotations>");
            textArea.setEditable(false);
            textArea.setEnabled(false);
        }
        Shape s = annotations.get(0).getShape().getShapeList().get(0);
        if (s instanceof PolygonExt) {
            cbClosed.setEnabled(true);
            cbClosed.setSelected(((PolygonExt) s).isClosed());
        } else {
            cbClosed.setEnabled(false);
            cbClosed.setSelected(false);
        }

        cbClosed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AnnotationUpdater() {
                    @Override
                    void update(final ImageAnnotation annotation) {
                        Shape s = annotation.getShape().getShapeList().get(0);
                        if (s instanceof PolygonExt) {
                            ((PolygonExt) s).setClosed(cbClosed.isSelected());
                        }
                    }
                }.run();


            }
        });

        okBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                save();
                close(false);
            }
        });

        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                close(true);
            }
        });

        if (annotationNotNull()) {
            colorChooseBtn.setBackground(new Color(annotations.get(0).getColor()));
        }
        colorChooseBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color initColor = Color.yellow;
                if (annotationNotNull()) initColor = new Color(annotations.get(0).getColor());
                final Color color = JColorChooser.showDialog(AnnotationEditor.this, "Annotation Shape Color", initColor);
                new AnnotationUpdater() {
                    @Override
                    void update(ImageAnnotation annotation) {
                        if (color != null) {
                            annotation.setColor(color.getRGB());
                            annotation.getShape().setColor(color);
                        }
                    }
                }.run();
                if (color != null) {
                    colorChooseBtn.setBackground(color);
                }
            }
        });


        if (annotationNotNull()) {
            int idx = 0;
            for (int i = 0; i < cbSubType.getModel().getSize(); i++) {
                ImageAnnotation.SubType subType = (ImageAnnotation.SubType) cbSubType.getItemAt(i);
                if (subType.getSubType() == annotations.get(0).getSubType()) {
                    idx = i;
                    break;
                }
            }
            cbSubType.setSelectedIndex(idx);

            idx = 0;
            for (int i = 0; i < cbGroup.getModel().getSize(); i++) {
                Integer g = (Integer) cbGroup.getItemAt(i);
                if (g == annotations.get(0).getGroup()) {
                    idx = i;
                    break;
                }
            }
            cbGroup.setSelectedIndex(idx);
        }
        cbSubType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final ImageAnnotation.SubType subType = (ImageAnnotation.SubType) cbSubType.getSelectedItem();
                if (subType != null) {
                    new AnnotationUpdater() {
                        @Override
                        void update(ImageAnnotation annotation) {
                            annotation.setSubType(subType.getSubType());
                            logger.trace("Annotation: " + annotation.getDescription() + " subType set: " + annotation.getSubTypeName());
                        }
                    }.run();
                }
            }
        });

        cbGroup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final Integer g = (Integer) cbGroup.getSelectedItem();
                if (g != null) {
                    new AnnotationUpdater() {
                        @Override
                        void update(ImageAnnotation annotation) {
                            annotation.setGroup(g);
                            logger.trace("Annotation: " + annotation.getDescription() + " group set: " + annotation.getGroup());
                        }
                    }.run();
                }
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

        GridBagConstraints gbcClosed = new GridBagConstraints();
        gbcClosed.weightx = 0;
        gbcClosed.weighty = 0;
        gbcClosed.anchor = GridBagConstraints.NORTHWEST;
        gbcClosed.fill = GridBagConstraints.NONE;
        gbcClosed.gridwidth = GridBagConstraints.REMAINDER;
        gbcClosed.gridx = 0;
        gbcClosed.gridy = 1;

        GridBagConstraints gbcSubTypePanel = new GridBagConstraints();
        gbcSubTypePanel.insets = new Insets(0, 0, 0, 0);
        gbcSubTypePanel.weightx = 0.0;
        gbcSubTypePanel.weighty = 0.0;
        gbcSubTypePanel.anchor = GridBagConstraints.SOUTHWEST;
        gbcSubTypePanel.fill = GridBagConstraints.REMAINDER;
        gbcSubTypePanel.gridx = 0;
        gbcSubTypePanel.gridy = 2;

        GridBagConstraints gbcColorPanel = new GridBagConstraints();
        gbcColorPanel.insets = new Insets(0, 0, 0, 0);
        gbcColorPanel.weightx = 0.0;
        gbcColorPanel.weighty = 0.0;
        gbcColorPanel.anchor = GridBagConstraints.SOUTHWEST;
        gbcColorPanel.fill = GridBagConstraints.RELATIVE;
        gbcColorPanel.gridx = 0;
        gbcColorPanel.gridy = 3;

        GridBagConstraints gbcGroupPanel = new GridBagConstraints();
        gbcGroupPanel.insets = new Insets(0, 0, 0, 0);
        gbcGroupPanel.weightx = 0.0;
        gbcGroupPanel.weighty = 0.0;
        gbcGroupPanel.anchor = GridBagConstraints.SOUTHWEST;
        gbcGroupPanel.fill = GridBagConstraints.REMAINDER;
        gbcGroupPanel.gridx = 1;
        gbcGroupPanel.gridy = 3;

        GridBagConstraints gbcBtnPanel = new GridBagConstraints();
        gbcBtnPanel.insets = new Insets(0, 0, 0, 0);
        gbcBtnPanel.weightx = 0.0;
        gbcBtnPanel.weighty = 0.0;
        gbcBtnPanel.anchor = GridBagConstraints.SOUTHEAST;
        gbcBtnPanel.fill = GridBagConstraints.REMAINDER;
        gbcBtnPanel.gridx = 1;
        gbcBtnPanel.gridy = 4;

        GridBagConstraints gbcSaveBtn = new GridBagConstraints();
        gbcSaveBtn.insets = new Insets(2, 0, 2, 2);
        gbcSaveBtn.weightx = 0.0;
        gbcSaveBtn.weighty = 0.0;
        gbcSaveBtn.anchor = GridBagConstraints.SOUTHEAST;
        gbcSaveBtn.fill = GridBagConstraints.NONE;
        gbcSaveBtn.gridx = 0;
        gbcSaveBtn.gridy = 0;

        GridBagConstraints gbcCloseBtn = new GridBagConstraints();
        gbcCloseBtn.insets = new Insets(2, 0, 2, 2);
        gbcCloseBtn.weightx = 0.0;
        gbcCloseBtn.weighty = 0.0;
        gbcCloseBtn.anchor = GridBagConstraints.SOUTHEAST;
        gbcCloseBtn.fill = GridBagConstraints.NONE;
        gbcCloseBtn.gridx = 2;
        gbcCloseBtn.gridy = 0;

        JPanel btnPanel = new JPanel(new GridBagLayout());
        btnPanel.add(okBtn, gbcSaveBtn);
        btnPanel.add(cancelBtn, gbcCloseBtn);

        JPanel subTypePanel = new JPanel();
        subTypePanel.add(subTypeLabel);
        subTypePanel.add(cbSubType);

        JPanel colorPanel = new JPanel();
        colorPanel.add(colorLabel);
        colorPanel.add(colorChooseBtn);

        JPanel groupPanel = new JPanel();
        groupPanel.add(groupLabel);
        groupPanel.add(cbGroup);

        setLayout(new GridBagLayout());
        add(new JScrollPane(textArea), gbcTextfield);
        add(cbClosed, gbcClosed);
        add(subTypePanel, gbcSubTypePanel);
        add(colorPanel, gbcColorPanel);
        add(groupPanel, gbcGroupPanel);
        add(btnPanel, gbcBtnPanel);

        setSize(400, 250);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation((size.width - getWidth()) / 2, (size.height - getHeight()) / 2);
    }

    private boolean annotationNotNull() {
        return annotations != null && annotations.size() > 0;
    }

    /**
     * set description for first annotation (only if one annotation has been selected for editing)
     */
    private void save() {
        if (annotations != null && annotations.size() == 1) {
            annotations.get(0).setDescription(textArea.getText());
        }
    }

    private void close(boolean cancel) {
        // restore annotation properties
        if (cancel) {
            if (annotationNotNull()) {
                if (annotationProperties.size() == annotations.size()) {
                    for (int i = 0; i < annotationProperties.size(); i++) {
                        AnnotationProperties ap = annotationProperties.get(i);
                        ap.restore(annotations.get(i));
                    }
                } else {
                    logger.error("could not restore annotation changes");
                }
            }
        }

        setVisible(false);
    }


    abstract class AnnotationUpdater {
        abstract void update(final ImageAnnotation annotation);

        public void run() {
            if (annotations != null && annotations.size() > 0) {
                for (ImageAnnotation anno : annotations) {
                    update(anno);
                }
            }
        }
    }

    class AnnotationProperties {
        String desc;
        int color;
        int subType;
        int group;
        boolean closed;
        Date modDate;
        String user;

        public AnnotationProperties(ImageAnnotation anno) {
            this.desc = anno.getDescription();
            this.color = anno.getColor();
            this.subType = anno.getSubType();
            this.group = anno.getGroup();
            this.closed = true;
            this.modDate = anno.getModifyDate();
            this.user = anno.getUserId();
            Shape s = anno.getShape().getShapeList().get(0);
            if (s instanceof PolygonExt) {
                closed = ((PolygonExt) s).isClosed();
            }
        }

        public void restore(ImageAnnotation anno) {
            anno.setDescription(desc);
            anno.setColor(color);
            anno.setSubType(subType);
            anno.setGroup(group);
            anno.setModifyDate(modDate);
            anno.setUserId(user);
            Shape s = anno.getShape().getShapeList().get(0);
            if (s instanceof PolygonExt) {
                ((PolygonExt) s).setClosed(closed);
            }
        }
    }

}
