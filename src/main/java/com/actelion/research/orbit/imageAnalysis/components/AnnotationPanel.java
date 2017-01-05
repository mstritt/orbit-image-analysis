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

import com.actelion.research.orbit.beans.OrbitUser;
import com.actelion.research.orbit.beans.RawAnnotation;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame.Tools;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.tasks.AnnotationClassificationTask;
import com.actelion.research.orbit.imageAnalysis.tasks.AnnotationFeaturesTask;
import com.actelion.research.orbit.imageAnalysis.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.media.jai.PlanarImage;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class AnnotationPanel extends JPanel implements PropertyChangeListener {


    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(AnnotationPanel.class);
    private final JButton btnAddAnnotationPoly = new JButton(new ImageIcon(OrbitImageAnalysis.class.getResource(OrbitUtils.DARKUI ? "/resource/annoAddPoly_substance.png" : "/resource/annoAddPoly.png")));
    private final JButton btnAddAnnotationMagneticLasso = new JButton(new ImageIcon(OrbitImageAnalysis.class.getResource(OrbitUtils.DARKUI ? "/resource/annoAddMagneticLasso_substance.png" : "/resource/annoAddPoly.png")));
    private final JButton btnAddAnnotationRect = new JButton(new ImageIcon(OrbitImageAnalysis.class.getResource(OrbitUtils.DARKUI ? "/resource/annoAddRect_substance.png" : "/resource/annoAddRect.png")));
    private final JButton btnEditAnnotation = new JButton(new ImageIcon(OrbitImageAnalysis.class.getResource("/resource/annoEdit.png")));
    private final JButton btnRemoveAnnotation = new JButton(new ImageIcon(OrbitImageAnalysis.class.getResource("/resource/annoRemove.png")));
    private final JButton btnMoveAnnotation = new JButton(new ImageIcon(OrbitImageAnalysis.class.getResource(OrbitUtils.DARKUI ? "/resource/annoMove_substance.png" : "/resource/annoMove.png")));
    private final JButton btnRotateAnnotation = new JButton(new ImageIcon(OrbitImageAnalysis.class.getResource(OrbitUtils.DARKUI ? "/resource/annoRotate_substance.png" : "/resource/annoRotate.png")));
    private final JCheckBoxMenuItem cbClosed = new JCheckBoxMenuItem("Close Annotation Polygon", true);
    private final JCheckBoxMenuItem cbSave = new JCheckBoxMenuItem("Store Annotations in DB", true);
    private final JCheckBoxMenuItem cbFixedRect = new JCheckBoxMenuItem("Draw Fixed Size Rectangle", false);
    private ImageAnnotation currentAnnotation = null;
    private static final int thumbnailWidth = 70;
    private static final int thumbnailHeight = 70;
    private final AnnotationListCellRenderer cellRenderer = new AnnotationListCellRenderer();
    private List<ImageAnnotation> annotationClipboard = null;
    private double annotationClipboardScale = 1d; // to store the mm per pixel of the source image (when pasting the scale is normalized to the mm per pixel ratio of source/dest image)
    private double fixedRectangleRatio = 1d;
    private int activeGroup = 0; // 0 means all groups, >0 means one specific active group
    private int defaultGroup = 0; // 0 means all groups, >0 means one specific active group (default group for new annotations)
    private final AtomicBoolean annoListAdjusting = new AtomicBoolean(false);

    public final ActionListener addPolygonActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            OrbitImageAnalysis.getInstance().forceLogin();
            if (OrbitImageAnalysis.loginOk) {
                prepareNewAnnotationPolygon(false);
            }
        }
    };

    public final ActionListener addMagneticLassoActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            OrbitImageAnalysis.getInstance().forceLogin();
            if (OrbitImageAnalysis.loginOk) {
                prepareNewAnnotationPolygon(true);
            }
        }
    };

    private final FilteredListModel<ImageAnnotation> model = new FilteredListModel<ImageAnnotation>() {
        @Override
        protected boolean accept(ImageAnnotation element) {
            if (activeGroup == 0) {
                return true;
            } else {
                return element.getGroup() == activeGroup;
            }
        }
    };
    private final JList list = new JList(model);

    public AnnotationPanel() {
        list.setCellRenderer(cellRenderer);


        btnAddAnnotationPoly.setToolTipText("add polygon");
        btnAddAnnotationPoly.addActionListener(addPolygonActionListener);
        btnAddAnnotationMagneticLasso.setToolTipText("<html><body>add magnetic lasso polygon<br/>hold left mouse button to draw, right-click to set fixed points, release left-mouse to finish</body></html>");
        btnAddAnnotationMagneticLasso.addActionListener(addMagneticLassoActionListener);
        btnAddAnnotationRect.setToolTipText("add rectangle");
        btnAddAnnotationRect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OrbitImageAnalysis.getInstance().forceLogin();
                if (OrbitImageAnalysis.loginOk) {
                    prepareNewAnnotationRect();
                }
            }
        });
        btnEditAnnotation.setToolTipText("edit annotation");
        btnEditAnnotation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OrbitImageAnalysis.getInstance().forceLogin();
                if (OrbitImageAnalysis.loginOk) {
                    editAnnotation();
                }
            }
        });
        btnRemoveAnnotation.setToolTipText("remove annotation");
        btnRemoveAnnotation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OrbitImageAnalysis.getInstance().forceLogin();
                if (OrbitImageAnalysis.loginOk) {
                    removeAnnotation();
                }
            }
        });
        btnMoveAnnotation.setToolTipText("move annotation");
        btnMoveAnnotation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OrbitImageAnalysis.getInstance().forceLogin();
                if (OrbitImageAnalysis.loginOk) {
                    moveAnnotation();
                }
            }
        });
        btnRotateAnnotation.setToolTipText("rotate annotation");
        btnRotateAnnotation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OrbitImageAnalysis.getInstance().forceLogin();
                if (OrbitImageAnalysis.loginOk) {
                    rotateAnnotation();
                }
            }
        });

        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                annotationClicked();
            }
        });


        // just additional so that a click on a single annotation works, too
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                annotationClicked();

            }
        });



        	/*
                    // sample code for scrolling to the selected annotation (does not work properly...)
						Thread thread = new Thread() {
							public void run() {
							final int ms = 30;
							for (int j=0; j<ms; j++) {
								final int i = j;
								try {
									SwingUtilities.invokeAndWait(new Runnable() {
										public void run() {
											Point p = new Point((int)((double)targetP.x*(i/(double)ms)+(double)currentP.x*(((double)ms-i)/(double)ms)),(int)((double)targetP.y*(i/(double)ms)+(double)currentP.y*(((double)ms-i)/(double)ms)));
											iFrame.setViewPortPositionAndAdjust(p);
										}
									});
								} catch (Exception e) {
								}
							}
			  			    iFrame.setViewPortPositionAndAdjust(targetP);
						};
						};
						thread.start();
			*/


        JMenuBar menuBar = new JMenuBar();
        // Options
        JMenu menu = new JMenu("Options");
        menu.add(cbClosed);

        JMenuItem item = new JMenuItem("Combine selected polygons");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                combineSelectedPolygons();
            }
        });
        menu.add(item);

        menu.addSeparator();

        menu.add(cbFixedRect);
        JMenuItem ratioItem = new JMenuItem("Set Fixed Rectangle ratio");
        ratioItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = (String) JOptionPane.showInputDialog(
                        AnnotationPanel.this,
                        "Please enter the height/width ratio of the fixed rectangle:",
                        "Rectangle Ratio",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        "" + fixedRectangleRatio);
                if (s != null && s.length() > 0) {
                    s = s.replaceAll(",", "\\.");
                    double d = Double.NaN;
                    try {
                        d = Double.parseDouble(s);
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(AnnotationPanel.this, "Please enter a valid number (e.g. 1.3)", "Could not set rectangle ratio", JOptionPane.ERROR_MESSAGE);
                    }
                    if (!Double.isNaN(d)) {
                        fixedRectangleRatio = d;
                        JOptionPane.showMessageDialog(AnnotationPanel.this, "Rectangle ratio successfully set to " + fixedRectangleRatio, "Ratio set", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        menu.add(ratioItem);

        JMenuItem rectangleSizeItem = new JMenuItem("Set Fixed Rectangle size");
        rectangleSizeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
                final RecognitionFrame rf = iFrame.getRecognitionFrame();
                String s = (String) JOptionPane.showInputDialog(
                        AnnotationPanel.this,
                        "Please enter the width of the fixed rectangle:",
                        "Rectangle Size",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        "" + rf.getTargetRadius());
                System.out.println("s is: " + s);
                if (s != null && s.length() > 0) {
                    Integer size = 0;
                    try {
                        s = s.replaceAll(",", "\\.");
                        size = (int) Double.parseDouble(s);
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(AnnotationPanel.this, "Please enter a valid number (e.g. 50)", "Could not set rectangle size", JOptionPane.ERROR_MESSAGE);
                    }
                    if (size > 0) {
                        rf.setTargetRadius(size);
                        OrbitImageAnalysis.getInstance().getSizeBox().setSelectedItem(new Integer(size));
                        JOptionPane.showMessageDialog(AnnotationPanel.this, "Rectangle size successfully set to " + size, "Size set", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        menu.add(rectangleSizeItem);


        menu.addSeparator();

        menu.add(cbSave);
        item = new JMenuItem("Store Annotations manually");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveUnsaved();
            }
        });
        menu.add(item);


        menuBar.add(menu);

        // Classify / Computation
        menu = new JMenu("Computation");
        item = new JMenuItem("Classification per Annotation");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                annotationClassification();
            }
        });
        menu.add(item);
        item = new JMenuItem("Features per Annotation");
        item.setToolTipText("Set class features (F3) to retrieve the features of only specific classes.");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                annotationFeatures();
            }
        });
        menu.add(item);
        item = new JMenuItem("Compute Annotation Statistics");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                computeStatistics();
            }
        });
        menu.add(item);
        menu.addSeparator();
        item = new JMenuItem("Set Selected Annotations as ROI");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setAnnotationsAsROI();
            }
        });
        menu.add(item);
        menuBar.add(menu);

        // copy&paste
        menu = new JMenu("Copy&Paste");
        item = new JMenuItem("Copy Annotation");
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                copyAnnotation();
            }
        });
        menu.add(item);
        item = new JMenuItem("Paste Annotation");
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pasteAnnotation();
            }
        });
        menu.add(item);
        menuBar.add(menu);

        // group
        menu = new JMenu("Groups");
        JMenu filterMenu = new JMenu("Visible Groups");
        final int groupSize = OrbitUtils.ANNOTATION_GROUPS;
        final JCheckBoxMenuItem[] subMenuGroup = new JCheckBoxMenuItem[groupSize + 1];
        for (int g = 0; g < (groupSize + 1); g++) {
            final int group = g;
            String lab = "All Groups";
            if (group > 0) lab = "Group " + group;
            subMenuGroup[group] = new JCheckBoxMenuItem(lab);
            subMenuGroup[group].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < (groupSize + 1); i++) {
                        if (i != group) {
                            subMenuGroup[i].setSelected(false);
                        }
                        if (!subMenuGroup[group].isSelected()) {
                            subMenuGroup[0].setSelected(true);
                        }
                    }
                    for (int i = 0; i < (groupSize + 1); i++) {
                        if (subMenuGroup[i].isSelected()) {
                            setActiveGroup(i);
                            break;
                        }
                    }
                }
            });
            if (group == 0) subMenuGroup[group].setSelected(true);
            filterMenu.add(subMenuGroup[group]);
        }
        menu.add(filterMenu);


        JMenu defaultGroupMenu = new JMenu("Default Group (new Annotations)");
        final JCheckBoxMenuItem[] subDefaultGroup = new JCheckBoxMenuItem[groupSize];
        for (int g = 0; g < groupSize; g++) {
            final int group = g + 1;
            String lab = "Group " + group;
            subDefaultGroup[group - 1] = new JCheckBoxMenuItem(lab);
            subDefaultGroup[group - 1].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    for (int i = 1; i < (groupSize + 1); i++) {
                        if (i != group) {
                            subDefaultGroup[i - 1].setSelected(false);
                        }
                        if (!subDefaultGroup[group - 1].isSelected()) {
                            subDefaultGroup[group - 1].setSelected(true);
                        }
                    }
                    for (int i = 1; i < (groupSize + 1); i++) {
                        if (subDefaultGroup[i - 1].isSelected()) {
                            defaultGroup = i;
                            setActiveGroup(i);
                            // adjust subGroup checkBoxMenuItems
                            for (int j = 0; j < (groupSize + 1); j++) {
                                if (j != group) {
                                    subMenuGroup[j].setSelected(false);
                                } else {
                                    subMenuGroup[j].setSelected(true);
                                }
                            }
                            logger.debug("default group: " + defaultGroup + "  active group set to: " + activeGroup);
                        }
                    }
                }
            });
            defaultGroupMenu.add(subDefaultGroup[group - 1]);
        }
        subDefaultGroup[0].setSelected(true);
        menu.add(defaultGroupMenu);

        menuBar.add(menu);

        // layout

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        JScrollPane scrollPane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainPanel.add(scrollPane, new GridBagConstraints(0, 0, GridBagConstraints.REMAINDER, GridBagConstraints.RELATIVE, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(1, 1, 0, 1), 0, 0));
//		JPanel btnPanel = new JPanel(new GridBagLayout());
//        btnPanel.add(btnAddAnnotationPoly,new GridBagConstraints(0, 0, 1, GridBagConstraints.RELATIVE, 1, 0, GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//        btnPanel.add(btnAddAnnotationRect,new GridBagConstraints(1, 0, 1, GridBagConstraints.RELATIVE, 1, 0, GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//        btnPanel.add(btnEditAnnotation,new GridBagConstraints  (2, 0, 1, GridBagConstraints.RELATIVE, 1, 0, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//        btnPanel.add(btnRemoveAnnotation,new GridBagConstraints(3, 0, 1, GridBagConstraints.RELATIVE, 1, 0, GridBagConstraints.SOUTHEAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//        btnPanel.add(btnMoveAnnotation,new GridBagConstraints(4, 0, 1, GridBagConstraints.RELATIVE, 1, 0, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        btnPanel.add(btnAddAnnotationMagneticLasso);
        btnPanel.add(btnAddAnnotationPoly);
        btnPanel.add(btnAddAnnotationRect);
        btnPanel.add(btnMoveAnnotation);
        btnPanel.add(btnRotateAnnotation);
        btnPanel.add(btnEditAnnotation);
        btnPanel.add(btnRemoveAnnotation);

        mainPanel.add(btnPanel, new GridBagConstraints(0, 1, 1, GridBagConstraints.RELATIVE, 1, 0, GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        setLayout(new BorderLayout());
        add(menuBar, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
    }

    private void setActiveGroup(int i) {
        activeGroup = i;
        model.filter();
        list.repaint();
        logger.debug("active group: " + activeGroup);
        RecognitionFrame.getActiveAnnotationGroup().set(i);
        // repaint active frames
        for (ImageFrame iFrame : OrbitImageAnalysis.getInstance().getIFrames()) {
            iFrame.repaint();
        }
    }


    protected void annotationClicked() {
        // first, set all unselected
        for (ImageAnnotation ia : model.getAllElements()) {
            ia.setSelected(false);
        }

        if (annoListAdjusting.get() || list.getValueIsAdjusting())
            return; // e.g. list is reloaded, don't jump to selection


        final ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
        if (list.getSelectedValues() != null && iFrame != null) {
            Rectangle bbAll = null;
            for (Object obj : list.getSelectedValues()) {
                if (obj instanceof ImageAnnotation) {
                    ImageAnnotation ann = (ImageAnnotation) obj;
                    ann.setSelected(true);
                    if (ann.getShape().getShapeList().size() > 0) {
                        IScaleableShape shape = (IScaleableShape) ann.getShape().getShapeList().get(0);
                        Rectangle bb = shape.getScaledInstance(100, new Point(0, 0)).getBounds();
                        if (bbAll == null) bbAll = bb;
                        else bbAll = bbAll.union(bb);
                    }
                }
            }
            if (bbAll != null) {
                double sc = iFrame.recognitionFrame.getScale() / 100d;
                final Point targetP = new Point((int) (bbAll.getCenterX() * sc) - iFrame.recognitionFrame.getWidth() / 2, (int) (bbAll.getCenterY() * sc) - iFrame.recognitionFrame.getHeight() / 2);
                iFrame.setViewPortPositionAndAdjust(targetP);
            }
        }
    }

    ;

    protected void combineSelectedPolygons() {
        // check if all selected annotations are of type PolygonExt (other annotations, e.g. rectangles, cannot be joined)
        ImageAnnotation[] annotations = null;
        if (list.getSelectedValue() != null && list.getSelectedValues() != null && list.getSelectedValues().length > 0) {
            annotations = new ImageAnnotation[list.getSelectedValues().length];
            for (int i = 0; i < list.getSelectedValues().length; i++) {
                annotations[i] = (ImageAnnotation) list.getSelectedValues()[i];
            }
            for (ImageAnnotation anno : annotations) {
                if (anno.getShape().getShapeList().size() > 0) {
                    IScaleableShape scaleableShape = (IScaleableShape) anno.getShape().getShapeList().get(0);
                    if (!(scaleableShape instanceof PolygonExt)) {
                        JOptionPane.showMessageDialog(AnnotationPanel.this, "Only polygon annotations can be joined.", "Please select only polygon annotations", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
        }
        // checks ok

        ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();

        if (annotations != null && annotations.length > 0) {
            Color color = null;
            String user = null;
            int rawAnnotationId = 0;
            int rawDataFileId = 0;
            int group = 0;
            PolygonExt mergedPoly = null;
            for (ImageAnnotation anno : annotations) {
                if (anno.getShape().getShapeList().size() > 0) {
                    if (color == null) color = anno.getShape().getColor();
                    if (user == null) user = anno.getUserId();
                    if (rawAnnotationId == 0) rawAnnotationId = anno.getRawAnnotationId();
                    if (rawDataFileId == 0) rawDataFileId = anno.getRawDataFileId();
                    if (group == 0) group = anno.getGroup();
                    IScaleableShape scaleableShape = (IScaleableShape) anno.getShape().getShapeList().get(0);
                    IScaleableShape pScaled = (IScaleableShape) scaleableShape.getScaledInstance(100d, new Point(0, 0));
                    PolygonExt poly = (PolygonExt) pScaled;
                    if (mergedPoly == null) mergedPoly = poly;
                    else mergedPoly.addPolygon(poly);
                }
            }

            // remove selected polygons and add new combined one
            for (ImageAnnotation anno : annotations) {
                model.removeElement(anno);
                if (iFrame != null) iFrame.recognitionFrame.getAnnotations().remove(anno);
            }


            // remove old ones from db if same user
            String loginUser = OrbitImageAnalysis.getInstance().loginUser;
            for (ImageAnnotation annotation : annotations) {
                try {
                    if (annotation.getRawDataFileId() > 0 && annotation.getUserId().equals(loginUser))
                        DALConfig.getImageProvider().DeleteRawAnnotation(annotation.getRawAnnotationId());
                } catch (Exception e) {
                    logger.error("error: ", e);
                }
            }

            ClassShape cs = new ClassShape("combined", color, ClassShape.SHAPETYPE_POLYGONEXT);
            cs.getShapeList().add(mergedPoly);
            ImageAnnotation ia = new ImageAnnotation("combined", cs);
            ia.setUserId(loginUser);
            ia.setRawAnnotationId(rawAnnotationId);
            ia.setRawDataFileId(rawDataFileId);
            ia.setGroup(group);
            model.addElement(ia);
            if (iFrame != null) iFrame.recognitionFrame.getAnnotations().add(ia);

            // add to db
            if (ia.getRawDataFileId() > 0 && loginUser != null) {
                try {
                    int id = DALConfig.getImageProvider().InsertRawAnnotation(ia);
                    ia.setRawAnnotationId(id);
                } catch (Exception e) {
                    logger.error("error: ", e);
                }
            }

            model.filter();

        } else {
            JOptionPane.showMessageDialog(AnnotationPanel.this, "Please select polygon annotations first.", "No polygon annotations selected", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void annotationClassification() {
        if (list.getSelectedValues() == null || list.getSelectedValues().length < 1) {
            JOptionPane.showMessageDialog(this, "Please select one or several annotations first.", "No annotations selected", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
        if (iFrame != null && list.getSelectedValues() != null && list.getSelectedValues().length > 0) {
            List<ImageAnnotation> annotations = new ArrayList<ImageAnnotation>();
            for (int i = 0; i < list.getSelectedValues().length; i++) {
                Object obj = list.getSelectedValues()[i];
                if (obj instanceof ImageAnnotation) {
                    annotations.add((ImageAnnotation) obj);
                }

            }
            AnnotationClassificationTask task = new AnnotationClassificationTask(iFrame.getRdf(), iFrame.recognitionFrame, OrbitImageAnalysis.getInstance().getModel(), annotations);
            OrbitImageAnalysis.getInstance().addAndExecuteTask(new ProgressPanel(iFrame.getTitle(), "Annotation Classification", task));
        }
    }

    private void annotationFeatures() {
        if (list.getSelectedValues() == null || list.getSelectedValues().length < 1) {
            JOptionPane.showMessageDialog(this, "Please select one or several annotations first.", "No annotations selected", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
        if (iFrame != null && list.getSelectedValues() != null && list.getSelectedValues().length > 0) {
            List<ImageAnnotation> annotations = new ArrayList<ImageAnnotation>();
            for (int i = 0; i < list.getSelectedValues().length; i++) {
                Object obj = list.getSelectedValues()[i];
                if (obj instanceof ImageAnnotation) {
                    annotations.add((ImageAnnotation) obj);
                }

            }
            AnnotationFeaturesTask task = new AnnotationFeaturesTask(iFrame.getRdf(), iFrame.recognitionFrame, OrbitImageAnalysis.getInstance().getModel(), annotations);
            OrbitImageAnalysis.getInstance().addAndExecuteTask(new ProgressPanel(iFrame.getTitle(), "Annotation Features", task));
        }
    }


    /**
     * Sets annotations as ROI. Does NOT check for annotations with name "ROI".
     */
    private void setAnnotationsAsROI() {
        ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
        if (iFrame == null) {
            JOptionPane.showMessageDialog(this, "Please open and select an image first", "No image available", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Object[] selectedAnnotations = list.getSelectedValues();
        if (selectedAnnotations == null || selectedAnnotations.length == 0) {
            JOptionPane.showMessageDialog(this, "Please select one or several annotations first", "No annotations selected", JOptionPane.ERROR_MESSAGE);
        }

        List<Shape> pList = new ArrayList<Shape>();
        for (int i = 0; i < selectedAnnotations.length; i++) {
            Object obj = selectedAnnotations[i];
            if (obj instanceof ImageAnnotation) {
                ImageAnnotation anno = (ImageAnnotation) obj;
                if (anno.getShape().getShapeList().size() > 0) {
                    IScaleableShape scaleableShape = (IScaleableShape) anno.getShape().getShapeList().get(0);
                    IScaleableShape pScaled = (IScaleableShape) scaleableShape.getScaledInstance(100d, new Point(0, 0));
                    pList.add(pScaled);
                }
            }
        }

        ShapeExtList roi = new ShapeExtList(pList, new Rectangle(Integer.MAX_VALUE, Integer.MAX_VALUE));
        iFrame.recognitionFrame.setROI(roi);
        JOptionPane.showMessageDialog(this, "Annotation ROI successfully set.\nPlease continue with normal classification or segmentation.", "Annotation ROI set", JOptionPane.INFORMATION_MESSAGE);
    }


    /**
     * if fullPath, the getDistPath function of polygonExt, otherwise the distance between the first and the last point of the polygon is computed
     *
     * @param fullPath
     */
    private String computeStatisticsStr(boolean fullPath, boolean copypaste) {
        ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
        if (iFrame != null && list.getModel().getSize() > 0) {
            StringBuilder sb = new StringBuilder(fullPath ? "Length of annotation path:" : "Distance from first to last point of annotation:");
            sb.append("\n");
            double mm = iFrame.recognitionFrame.getMuMeterPerPixel();
            if (mm > 0) {
                for (int i = 0; i < list.getModel().getSize(); i++) {
                    ImageAnnotation anno = (ImageAnnotation) list.getModel().getElementAt(i);
                    if (anno.getShape().getShapeList().size() > 0) {
                        PolygonExt poly = (PolygonExt) anno.getShape().getShapeList().get(0);
                        if (poly.npoints > 1) {
                            //poly = poly.getScaledInstance(100, new Point(0,0));
                            double dist;
                            if (fullPath) dist = (poly.getDistPath() / (poly.getScale() / 100d)) * mm;
                            else dist = (poly.getDistDirstLast() / (poly.getScale() / 100d)) * mm;
                            if (!copypaste)
                                sb.append(anno.getDescription() + ": " + String.format("%1.4f", dist) + " " + (char) 181 + "m\n");
                            else sb.append(String.format("%1.4f", dist) + "\n");

                        }
                    }
                }
            } // otherwise show message!
            return sb.toString();
        }
        return "";
    }

    private HashMap<ImageAnnotation, HashMap<String, String>> computeStatisticsMap(OrbitUtils.ScaleAndUnit sau) {
        HashMap<ImageAnnotation, HashMap<String, String>> map = new HashMap<ImageAnnotation, HashMap<String, String>>();
        ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
        if (iFrame != null && list.getModel().getSize() > 0) {
            double mm = sau.getScale();
            if (mm > 0) {
                for (int i = 0; i < list.getModel().getSize(); i++) {
                    ImageAnnotation anno = (ImageAnnotation) list.getModel().getElementAt(i);
                    if (anno.getShape().getShapeList().size() > 0) {
                        if (anno.getShape().getShapeList().get(0) instanceof PolygonExt) {
                            PolygonExt poly = (PolygonExt) anno.getShape().getShapeList().get(0);
                            PolygonMetrics pm = new PolygonMetrics(poly.getScaledInstance(100, new Point(0, 0)));
                            if (poly.npoints > 1) {
                                double fullPath = (poly.getDistPath() / (poly.getScale() / 100d)) * mm;
                                double dist = (poly.getDistDirstLast() / (poly.getScale() / 100d)) * mm;
                                //double area = (pm.getArea()/(poly.getScale()/100d))*mm;
                                double area = pm.getArea() * mm * mm;
                                HashMap<String, String> annoMap = new HashMap<String, String>();
                                annoMap.put("Pathlength", String.format("%1.4f", fullPath));
                                annoMap.put("First-Last", String.format("%1.4f", dist));
                                annoMap.put("Area", String.format("%1.4f", area));
                                map.put(anno, annoMap);
                            }
                        } else if (anno.getShape().getShapeList().get(0) instanceof RectangleExt) {
                            RectangleExt rectExt = (RectangleExt) anno.getShape().getShapeList().get(0);
                            rectExt = rectExt.getScaledInstance(100, new Point(0, 0));
                            double area = rectExt.getWidth() * rectExt.getHeight() * mm * mm;
                            double w = rectExt.getWidth() * mm;
                            double h = rectExt.getHeight() * mm;
                            HashMap<String, String> annoMap = new HashMap<String, String>();
                            annoMap.put("Pathlength", String.format("%1.4f", w));
                            annoMap.put("First-Last", String.format("%1.4f", h));
                            annoMap.put("Area", String.format("%1.4f", area));
                            map.put(anno, annoMap);
                        } else { // not supported
                            HashMap<String, String> annoMap = new HashMap<String, String>();
                            annoMap.put("Pathlength", String.format("%1.4f", 0d));
                            annoMap.put("First-Last", String.format("%1.4f", 0d));
                            annoMap.put("Area", String.format("%1.4f", 0d));
                            map.put(anno, annoMap);
                        }
                    }
                }
            } // otherwise show message!
        }
        return map;
    }

    private void computeStatistics() {
        getRootPane().setCursor(new Cursor(Cursor.WAIT_CURSOR));
        try {
            ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
            if (iFrame != null && list.getModel().getSize() > 0) {
                OrbitUtils.ScaleAndUnit sau = OrbitUtils.getImageScaleAndUnit(iFrame.getRdf());
                HashMap<ImageAnnotation, HashMap<String, String>> map = computeStatisticsMap(sau);
                StringBuilder sb = new StringBuilder();
                sb.append("#" + iFrame.getTitle() + "\n");

                // header
                sb.append("Annotation\tPathlength(" + sau.getUnit() + ")\tFirst-Last(" + sau.getUnit() + ")\tArea(" + sau.getUnitSquare() + ")\n");
                List<RawAnnotation> annotations = new ArrayList<RawAnnotation>();
                for (int i = 0; i < list.getModel().getSize(); i++) {
                    ImageAnnotation anno = (ImageAnnotation) list.getModel().getElementAt(i);
                    annotations.add(anno); // used later for roi area
                    sb.append(anno.getDescription().replaceAll("\\n", " ") + "\t");
                    HashMap<String, String> annoMap = map.get(anno);
                    for (String s : new String[]{"Pathlength", "First-Last", "Area"}) {
                        sb.append(annoMap.get(s) + "\t");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append("\n");
                }
                // combined annotation roi area
                IScaleableShape roiCombined = new ShapeAnnotationList(annotations, 0, null);
                if (roiCombined != null) {
                    OrbitTiledImage2 img = iFrame.recognitionFrame.bimg.getImage();
                    double roiArea = OrbitUtils.getROISize(img.getWidth(), img.getHeight(), roiCombined.getBounds(), roiCombined, null, sau.getScale());
                    String mmUnit = "mm";
                    if (sau.getUnit().equalsIgnoreCase("pixel")) mmUnit = "pixel";
                    else roiArea /= 1000000d;
                    sb.append("\nCombined ROI area (" + mmUnit + "): " + String.format("%1.4f", roiArea) + "\n");
                }

                //copy&paste columns
                sb.append("\nCopy&Paste Column Pathlength\n");
                for (int i = 0; i < list.getModel().getSize(); i++) {
                    ImageAnnotation anno = (ImageAnnotation) list.getModel().getElementAt(i);
                    HashMap<String, String> annoMap = map.get(anno);
                    System.out.println("annoMAp: " + annoMap);
                    sb.append(annoMap.get("Pathlength") + "\n");
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append("\n");
                }
                sb.append("\nCopy&Paste Column First-Last\n");
                for (int i = 0; i < list.getModel().getSize(); i++) {
                    ImageAnnotation anno = (ImageAnnotation) list.getModel().getElementAt(i);
                    HashMap<String, String> annoMap = map.get(anno);
                    sb.append(annoMap.get("First-Last") + "\n");
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append("\n");
                }
                sb.append("\nCopy&Paste Column Area\n");
                for (int i = 0; i < list.getModel().getSize(); i++) {
                    ImageAnnotation anno = (ImageAnnotation) list.getModel().getElementAt(i);
                    HashMap<String, String> annoMap = map.get(anno);
                    sb.append(annoMap.get("Area") + "\n");
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append("\n");
                }

                String res = OrbitUtils.text2SmartHtml(sb.toString());
                if (sb.length() > 0) {
                    ResultFrame rf = new ResultFrame(res, "Measurement Results for " + iFrame.getTitle());
                    OrbitImageAnalysis.getInstance().addInternalFrame(rf);
                }
            }
        } finally {
            getRootPane().setCursor(new Cursor((Cursor.DEFAULT_CURSOR)));
        }
    }

    private void computeStatisticsOld() {
        ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
        if (iFrame != null && list.getModel().getSize() > 0) {
            if (iFrame.recognitionFrame.getMuMeterPerPixel() == 0) {
                JOptionPane.showMessageDialog(this, "No scale available. Measurement cannot be performed.", "No scale available", JOptionPane.ERROR_MESSAGE);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(computeStatisticsStr(false, false));
            sb.append("\n\n");
            sb.append(computeStatisticsStr(true, false));
            sb.append("\n\nCopy&Paste Column:\n");
            sb.append(iFrame.getTitle() + "\n");
            sb.append(computeStatisticsStr(true, true));
            if (sb.length() > 0) {
                ResultFrame rf = new ResultFrame(sb.toString(), "Measurement Results for " + iFrame.getTitle());
                OrbitImageAnalysis.getInstance().addInternalFrame(rf);
            }
        }
    }


    private void moveAnnotation() {
        ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
        if (iFrame != null && list.getSelectedValues() != null) {

            iFrame.recognitionFrame.setSelectedTool(Tools.moveAnnotation);
            // iFrame.recognitionFrame.getMyListener().setShapeMode(ClassShape.SHAPETYPE_POLYGONEXT);
            iFrame.recognitionFrame.getMyListener().setDeleteMode(false);
            // jre6 cast. For jre7 use list.getSelectedValueList!
            List<ImageAnnotation> selectedAnnotationList = new ArrayList<ImageAnnotation>(list.getSelectedValues().length);
            for (Object obj : list.getSelectedValues()) {
                if (obj instanceof ImageAnnotation) {
                    selectedAnnotationList.add((ImageAnnotation) obj);
                }
            }
            iFrame.recognitionFrame.getMyListener().setCurrentAnnotationList(selectedAnnotationList);

            if (!iFrame.recognitionFrame.getMyListener().containsPropertyChangeListener(this)) {
                iFrame.recognitionFrame.getMyListener().addPropertyChangeListener(this);
            }

            iFrame.recognitionFrame.setCursor(new Cursor(Cursor.MOVE_CURSOR));
        }
    }

    private void rotateAnnotation() {
        ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
        if (iFrame != null && list.getSelectedValues() != null) {

            iFrame.recognitionFrame.setSelectedTool(Tools.rotateAnnotation);
            // iFrame.recognitionFrame.getMyListener().setShapeMode(ClassShape.SHAPETYPE_POLYGONEXT);
            iFrame.recognitionFrame.getMyListener().setDeleteMode(false);
            // jre6 cast. For jre7 use list.getSelectedValueList!
            List<ImageAnnotation> selectedAnnotationList = new ArrayList<ImageAnnotation>(list.getSelectedValues().length);
            for (Object obj : list.getSelectedValues()) {
                if (obj instanceof ImageAnnotation) {
                    selectedAnnotationList.add((ImageAnnotation) obj);
                }
            }
            iFrame.recognitionFrame.getMyListener().setCurrentAnnotationList(selectedAnnotationList);

            if (!iFrame.recognitionFrame.getMyListener().containsPropertyChangeListener(this)) {
                iFrame.recognitionFrame.getMyListener().addPropertyChangeListener(this);
            }

            iFrame.recognitionFrame.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }


    private void prepareNewAnnotationPolygon(final boolean magneticLasso) {
        ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
        if (iFrame != null) {
            logger.trace("mip layer: " + iFrame.getMipLayer());
            if (iFrame.getMipLayer() > 0) {
                JOptionPane.showMessageDialog(this, "Annotation can only be created on full-size images, not on special layers.\nPlease create the annotation on the original image.\nThe annotations will then be copied and scaled to the special resolution images.", "Cannot create annotaiton", JOptionPane.ERROR_MESSAGE);
                return;
            }

            currentAnnotation = new ImageAnnotation();
            currentAnnotation.setDescription("Annotation");
            currentAnnotation.setUserId(OrbitImageAnalysis.loginUser);
            currentAnnotation.setGroup(defaultGroup > 0 ? defaultGroup : 1);
            iFrame.recognitionFrame.getAnnotations().add(currentAnnotation);

            iFrame.recognitionFrame.setSelectedTool(magneticLasso? Tools.magneticLasso : Tools.brush);
            iFrame.recognitionFrame.getMyListener().setShapeMode(ClassShape.SHAPETYPE_POLYGONEXT);
            iFrame.recognitionFrame.getMyListener().setDeleteMode(false);
            iFrame.recognitionFrame.getMyListener().setCloseNextPolygonExt(cbClosed.isSelected());
            iFrame.recognitionFrame.getMyListener().setShapeList(currentAnnotation.getShape().getShapeList(), currentAnnotation.getShape().getShapeType(), currentAnnotation.getShape().getName());

            if (!iFrame.recognitionFrame.getMyListener().containsPropertyChangeListener(this)) {
                iFrame.recognitionFrame.getMyListener().addPropertyChangeListener(this);
            }

            iFrame.recognitionFrame.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        }
    }

    private void prepareNewAnnotationRect() {
        ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
        if (iFrame != null) {
            logger.trace("mip layer: " + iFrame.getMipLayer());
            if (iFrame.getMipLayer() > 0) {
                JOptionPane.showMessageDialog(this, "Annotation can only be created on full-size images, not on special layers.\nPlease create the annotation on the original image.\nThe annotations will then be copied and scaled to the special resolution images.", "Cannot create annotaiton", JOptionPane.ERROR_MESSAGE);
                return;
            }

            currentAnnotation = new ImageAnnotation();
            currentAnnotation.setDescription("Annotation");
            currentAnnotation.setUserId(OrbitImageAnalysis.loginUser);
            currentAnnotation.getShape().setShapeType(ClassShape.SHAPETYPE_RECTANGLE);
            currentAnnotation.setGroup(defaultGroup > 0 ? defaultGroup : 1);
            iFrame.recognitionFrame.getAnnotations().add(currentAnnotation);

            iFrame.recognitionFrame.setSelectedTool(Tools.rectangle);
            iFrame.recognitionFrame.getMyListener().setShapeMode(ClassShape.SHAPETYPE_RECTANGLE);
            iFrame.recognitionFrame.getMyListener().setFixedRectangle(cbFixedRect.isSelected());
            iFrame.recognitionFrame.getMyListener().setFixedRectangleRatio(fixedRectangleRatio);
            iFrame.recognitionFrame.getMyListener().setDeleteMode(false);
            iFrame.recognitionFrame.getMyListener().setShapeList(currentAnnotation.getShape().getShapeList(), currentAnnotation.getShape().getShapeType(), currentAnnotation.getShape().getName());

            if (!iFrame.recognitionFrame.getMyListener().containsPropertyChangeListener(this)) {
                iFrame.recognitionFrame.getMyListener().addPropertyChangeListener(this);
            }

            iFrame.recognitionFrame.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        }
    }

    private void attachAnnotation() {
        ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
        if (iFrame != null) {
//			if (currentAnnotation.getShape().getShapeList().size()>0) {
//				((PolygonExt)currentAnnotation.getShape().getShapeList().get(0)).setClosed(false);
//			}
            currentAnnotation.setDescription(generateDescription(currentAnnotation, model));
            if (cbFixedRect.isSelected()) {
                //int w = (int)((iFrame.recognitionFrame.getTargetRadius()/2d)*(iFrame.recognitionFrame.getScale()/100d));
                int w = (int) ((iFrame.recognitionFrame.getTargetRadius() / 2d));
                int h = (int) ((double) w * fixedRectangleRatio);
                currentAnnotation.setDescription(currentAnnotation.getDescription() + " [" + w * 2 + "x" + h * 2 + "]");
            }

            model.addElement(currentAnnotation);
            model.filter();
            iFrame.recognitionFrame.setSelectedTool(Tools.finger);
            iFrame.recognitionFrame.getMyListener().setShapeList(null, null);
            iFrame.recognitionFrame.getMyListener().setShapeMode(ClassShape.SHAPETYPE_POLYGONEXT);
            iFrame.recognitionFrame.getMyListener().setFixedRectangle(false);
            iFrame.recognitionFrame.getMyListener().removePropertyChangeListener(this);
            iFrame.recognitionFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }

        if (cbSave.isSelected()) {
            if (iFrame.getRdf() != null) {
                try {
                    //RawAnnotation ra = currentAnnotation.toRawAnnotation(iFrame.getRdf().getRawDataFileId(), OrbitImageAnalysis.loginUser);
                    currentAnnotation.setRawDataFileId(iFrame.getRdf().getRawDataFileId());
                    currentAnnotation.setUserId(OrbitImageAnalysis.loginUser);
                    if (currentAnnotation.getShape().getShapeList().get(0) instanceof PolygonExt) {
                        ((PolygonExt) currentAnnotation.getShape().getShapeList().get(0)).setClosed(cbClosed.isSelected());
                    }
                    int newId = DALConfig.getImageProvider().InsertRawAnnotation(currentAnnotation);
                    currentAnnotation.setRawAnnotationId(newId);
                } catch (Exception e) {
                    logger.error("Annotation cannot be saved.\nProbably you don't have the permission to save annotations for this image.", e);
                }
            } else {
                logger.info("Annotation cannot be persisted because the image is not in Orbit.");
            }
        } // cbSave


    }


    /**
     * returns a String "Annotation GROUP/NUMBER". NUMBER is the size of the model, but will be increased until the description is unique.
     */
    private String generateDescription(ImageAnnotation anno, FilteredListModel<ImageAnnotation> model) {
        model.filter();
        int n = model.getSize() + 1;
        boolean found = true;
        String d = "";
        while (found) {
            found = false;
            d = "Annotation " + currentAnnotation.getGroup() + "/" + n;
            for (int i = 0; i < model.getSize(); i++) {
                ImageAnnotation a = (ImageAnnotation) model.getElementAt(i);
                if (a.getDescription().equals(d)) {
                    found = true;
                    n++;
                }
            }
        }
        return d;
    }

    private void updateAnnotation(List<ImageAnnotation> movedAnnotationList) {
        ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
        if (iFrame != null) {
            //   model.filter();
            iFrame.recognitionFrame.setSelectedTool(Tools.finger);
            iFrame.recognitionFrame.getMyListener().setShapeMode(ClassShape.SHAPETYPE_POLYGONEXT); // ?
            iFrame.recognitionFrame.getMyListener().removePropertyChangeListener(this); // ? 
            iFrame.recognitionFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }

        if (cbSave.isSelected()) {
            if (iFrame.getRdf() != null) {
                try {
                    for (ImageAnnotation movedAnnotation : movedAnnotationList) {
                        DALConfig.getImageProvider().UpdateRawAnnotation(movedAnnotation);
                    }
                } catch (Exception e) {
                    logger.error("error: ", e);
                }
            } else {
                logger.info("Annotation cannot be persisted because the image is not in Orbit.");
            }
        } // cbSave

        list.repaint();
    }

    private void editAnnotation() {
        if (list.getSelectedValues() != null) {
            List<ImageAnnotation> annotations = new ArrayList<ImageAnnotation>();
            for (Object obj : list.getSelectedValues()) {
                ImageAnnotation annotation = (ImageAnnotation) obj;
//                if (!(annotation.getUserId() == null || annotation.getUserId().equals("") || annotation.getUserId().equals(OrbitImageAnalysis.GUEST_USER) || annotation.getUserId().equals(OrbitImageAnalysis.loginUser) || DALConfig.getImageProvider().getAdminUsers().contains(OrbitImageAnalysis.loginUser) || DALConfig.getTemporaryUsers().contains(annotation.getUserId()))) {
//                    JOptionPane.showMessageDialog(this, "Only the owner of the annotation is able edit this annotation.\nThis annotation is owned by  " + annotation.getUserId() + " but login user is " + OrbitImageAnalysis.loginUser + ".", "Cannot edit annotation.", JOptionPane.ERROR_MESSAGE);
//                    return;
//                }
                annotations.add(annotation);
            }
            if (annotations.size() == 0) return;
            AnnotationEditor editor = new AnnotationEditor(annotations);
            editor.setVisible(true);
            list.repaint();
            ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
            if (iFrame != null) {
                iFrame.recognitionFrame.repaint();
            }
            // update in db
            if (cbSave.isSelected()) {
                for (ImageAnnotation annotation : annotations) {
                    try {
                        annotation.setRawDataFileId(iFrame.getRdf().getRawDataFileId());
                        //annotation.setUserId(OrbitImageAnalysis.loginUser);
                        DALConfig.getImageProvider().UpdateRawAnnotation(annotation);
                    } catch (Exception e) {
                        logger.error("error saving annotation ", e);
                    }
                }
            }
            model.filter();

        }
    }


    /**
     * stores unsaved annotations in the orbit database
     */
    private void saveUnsaved() {
        OrbitImageAnalysis.getInstance().forceLogin();
        if (!OrbitImageAnalysis.loginOk) return;

        ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
        if (iFrame != null) {
            if (iFrame.getRdf() != null) {
                try {
                    for (int i = 0; i < list.getModel().getSize(); i++) {
                        ImageAnnotation anno = (ImageAnnotation) list.getModel().getElementAt(i);
                        anno.setRawDataFileId(iFrame.getRdf().getRawDataFileId());
                        anno.setUserId(OrbitImageAnalysis.loginUser);
                        if (anno.getRawAnnotationId() > 0) {  // update existing annotation
                            DALConfig.getImageProvider().UpdateRawAnnotation(anno);
                        } else {  // insert new annotation
                            int newId = DALConfig.getImageProvider().InsertRawAnnotation(anno);
                            anno.setRawAnnotationId(newId);
                        }
                    }
                    JOptionPane.showMessageDialog(this, list.getModel().getSize() + " Annotations successfully saved in database", "Annotations successfully saved", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    logger.error("error: ", e);
                }
            } else {
                logger.info("Annotation cannot be persisted because the image is not in Orbit.");
            }
        } // iFrame!=null
    }

    private void removeAnnotation() {
        if (list.getSelectedValue() != null && list.getSelectedValues() != null && list.getSelectedValues().length > 0) {
            ImageAnnotation[] annotations = new ImageAnnotation[list.getSelectedValues().length];

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.getSelectedValues().length; i++) {
                annotations[i] = (ImageAnnotation) list.getSelectedValues()[i];
                String s = annotations[i].getDescription();
                if (s != null && s.length() > 20) s = s.substring(0, 20) + "...";
                sb.append(s + ",");
                if (i % 4 == 0) sb.append("\n");
            }
            sb.deleteCharAt(sb.length() - 1);

            if (!(JOptionPane.showConfirmDialog(this,
                    "Do you really want to delete the following annotations: " + sb.toString() + "?",
                    "Delete Annotations", JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION)) return;


            // check rights
//            boolean rightsOk = true;
//            String otherOwner = "";
//            for (ImageAnnotation annotation : annotations) {
//                if (!(annotation.getUserId() == null || annotation.getUserId().equals("") || annotation.getUserId().equals(OrbitImageAnalysis.GUEST_USER) || annotation.getUserId().equals(OrbitImageAnalysis.loginUser) || DALConfig.getImageProvider().getAdminUsers().contains(OrbitImageAnalysis.loginUser) || DALConfig.getTemporaryUsers().contains(annotation.getUserId()))) {
//                    rightsOk = false;
//                    otherOwner = annotation.getUserId();
//                    break;
//                }
//            }
//            if (!rightsOk) {
//                JOptionPane.showMessageDialog(this, "Only the owner of the annotation is able remove the annotation(s).\nAt least one annotation is owned by  " + otherOwner + ".", "Cannot remove annotation.", JOptionPane.ERROR_MESSAGE);
//                return;
//            }

            //	(OrbitAnnotation[])list.getSelectedValues();
            // remove in annotation list
            for (ImageAnnotation annotation : annotations) {
                model.removeElement(annotation);
                model.filter();
            }

            // synch iFrame
            ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
            if (iFrame != null) {
                for (ImageAnnotation annotation : annotations) {
                    iFrame.recognitionFrame.getAnnotations().remove(annotation);
                }
                iFrame.recognitionFrame.repaint();
            }

            // remove from database
            for (ImageAnnotation annotation : annotations) {
                try {
                    DALConfig.getImageProvider().DeleteRawAnnotation(annotation.getRawAnnotationId());
                } catch (Exception e) {
                    logger.error("error: ", e);
                }
            }

        }
    }


    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(ShapePainterListener.SHAPE_DRAWN)) {
            attachAnnotation();
        }
        if (evt.getPropertyName().equals(ShapePainterListener.SHAPE_MOVED)) {
            updateAnnotation((List<ImageAnnotation>) evt.getNewValue());
        }
    }


    public FilteredListModel<ImageAnnotation> getModel() {
        return model;
    }


    /**
     * clears list model and icon cache
     */
    public void clear() {
        model.clear();
        cellRenderer.clear();
    }


    // copy&paste

    protected void copyAnnotation() {
        if (list.getSelectedValue() != null && list.getSelectedValues() != null && list.getSelectedValues().length > 0) {
            ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
            if (iFrame != null) {
                double mm = iFrame.recognitionFrame.getMuMeterPerPixel();
                annotationClipboardScale = mm > 0 ? mm : 1d;
            }
            annotationClipboard = new ArrayList<ImageAnnotation>(list.getSelectedValues().length);
            int cnt = 0;
            for (Object obj : list.getSelectedValues()) {
                if (obj instanceof ImageAnnotation) {
                    ImageAnnotation anno = (ImageAnnotation) obj;
                    anno.setModifyDate(new Date());
                    anno.setRawAnnotationId(0);
                    anno.setRawDataFileId(0);
                    annotationClipboard.add(anno);
                    cnt++;
                }
            }
            if (cnt > 0) {
                logger.info("annotation(s) copied to clipboard");
                //JOptionPane.showMessageDialog(this, cnt+" annotation(s) successfully copied to clipboard.", "Copied to clipboard", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select first one or several annotations.", "No annotation selected", JOptionPane.ERROR_MESSAGE);
        }
    }


    protected void pasteAnnotation() {
        ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
        if (iFrame == null) {
            JOptionPane.showMessageDialog(this, "Please open and select an image (from Orbit) first.", "No image selected", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (iFrame.getRdf() == null) {
            JOptionPane.showMessageDialog(this, "Please open an image from Orbit. Annotations cannot be created for file based images.", "Image is not an Orbit image", JOptionPane.ERROR_MESSAGE);
            return;
        }
        double scaleRatio = 1d;
        if (iFrame != null) {
            double mm = iFrame.recognitionFrame.getMuMeterPerPixel();
            if (annotationClipboardScale > 0 && mm > 0) scaleRatio = annotationClipboardScale / mm;
        }

        int cnt = 0;
        if (annotationClipboard != null && annotationClipboard.size() > 0) {
            OrbitImageAnalysis.getInstance().forceLogin();
            if (OrbitImageAnalysis.loginOk) {
                HashSet<String> annoNames = new HashSet<String>(model.getSize());
                for (ImageAnnotation ia : model.getAllElements()) {
                    annoNames.add(ia.getDescription());
                }

                for (ImageAnnotation annoOld : annotationClipboard) {
                    // clone annotation to be pasted in the same image (duplicated)
                    ImageAnnotation anno = annoOld.clone();
                    anno.getShape().getShapeList().set(0, ((IScaleableShape) anno.getFirstShape()).getScaledInstance(scaleRatio * 100d, new Point(0, 0))); // normalize scale to mm per pixel ratio of source and dest image
                    ((IScaleableShape) anno.getFirstShape()).setScale(100d);
                    anno.setSelected(true);
                    anno.setUserId(OrbitImageAnalysis.loginUser);
                    if (iFrame.getRdf() != null)
                        anno.setRawDataFileId(iFrame.getRdf().getRawDataFileId());

                    anno.setDescription(OrbitUtils.getNewName(anno.getDescription(), annoNames));
                    model.addElement(anno);
                    iFrame.recognitionFrame.getAnnotations().add(anno);
                    cnt++;

                    // save in DB?
                    if (cbSave.isSelected() && anno.getRawDataFileId() > 0) {
                        try {
                            int id = DALConfig.getImageProvider().InsertRawAnnotation(anno);
                            anno.setRawAnnotationId(id);
                        } catch (Exception e) {
                            logger.error("error: ", e);
                        }
                    }
                }
            }
            if (cnt > 0) {
                model.filter();
                iFrame.repaint();
                logger.info(cnt + " annotation(s) pasted");
                //JOptionPane.showMessageDialog(this, cnt+" annotation(s) successfully pasted (but not saved in the database).\nIf you want to persist the annotations please click on Options->Save annotations (in DB).", "Annotations pasted", JOptionPane.INFORMATION_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Please copy first one or several annotations to clipboard.", "No annotation in clipboard", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * 0 means all groups, >0 means one specific active group
     *
     * @return
     */
    public int getActiveGroup() {
        return activeGroup;
    }


    /**
     * 0 means all groups, >0 means one specific active group (default group for new annotations)
     *
     * @return
     */
    public int getDefaultGroup() {
        return defaultGroup;
    }

    public AtomicBoolean getAnnoListAdjusting() {
        return annoListAdjusting;
    }

    public JList getList() {
        return list;
    }

    private class AnnotationListCellRenderer extends DefaultListCellRenderer {
        private static final long serialVersionUID = 1L;
        protected long maxHashSize = 500;
        //private final HashMap<Integer, JLabel> cellHash = new HashMap<Integer, JLabel>();
        protected Map<Integer, ImageIcon> cellCache = Collections.synchronizedMap(new HashMap<Integer, ImageIcon>());
        private ExecutorService executor = Executors.newSingleThreadExecutor();
        private ImageIcon dummyThn = null;


        public AnnotationListCellRenderer() {
            dummyThn = new ImageIcon(new BufferedImage(thumbnailWidth, thumbnailHeight, BufferedImage.TYPE_INT_RGB));
            dummyThn.getImage().getGraphics().setColor(Color.white);
            dummyThn.getImage().getGraphics().fillRect(0, 0, dummyThn.getIconWidth(), dummyThn.getIconHeight());
        }


        /**
         * clears the cell cache
         */
        public void clear() {
            cellCache.clear();
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            ImageAnnotation annotation = (ImageAnnotation) value;
            OrbitUser emp = DALConfig.getImageProvider().getOrbitUser(annotation.getUserId());
            String userFullname = annotation.getUserId();
            if (emp != null) userFullname = emp.getFirstName() + " " + emp.getLastName();
            String s = "<html><body>" + annotation.getDescription() + "<br/>[" + userFullname + "]<br/>" + annotation.getSubTypeName() + " Group " + annotation.getGroup() + "</body></html>";
            JLabel label = (JLabel) super.getListCellRendererComponent(list, s, index, isSelected, cellHasFocus);
            if (annotation.getDescription().length() > 100)
                label.setVerticalTextPosition(TOP);
            else label.setVerticalTextPosition(CENTER);
            // get and set icon

            ImageIcon icon = dummyThn;
            int shapeHash = 0;
            if (annotation.getShape().getShapeList() != null && annotation.getShape().getShapeList().size() > 0)
                shapeHash = annotation.getShape().getShapeList().get(0).getBounds().x + annotation.getShape().getShapeList().get(0).getBounds().y + annotation.getShape().getShapeList().get(0).getBounds().width + annotation.getShape().getShapeList().get(0).getBounds().height;
            int hash = label.getText().hashCode() + index + shapeHash;
            if (cellCache.containsKey(hash)) icon = cellCache.get(hash);
            else {
                try {
                    if (cellCache.size() <= maxHashSize)
                        executor.execute(new ThnRunny(annotation, hash));
                } catch (Throwable re) {
                    // can happen while shutting down the executor, but no problem
                }
            } // not in hash
            label.setIcon(icon);

            return label;
            //return super.getListCellRendererComponent(list, label, index, isSelected, cellHasFocus);
        }


        /**
         * Helper class for thumbnail creation in separate thread.
         *
         * @author stritma1
         */
        public class ThnRunny implements Runnable {

            private ImageAnnotation annotation = null;
            private int hash = 0;

            public ThnRunny(ImageAnnotation annotation, int hash) {
                this.hash = hash;
                this.annotation = annotation;
            }

            public void run() {
                try {
                    ClassShape classShape = annotation.getShape();
                    if (classShape != null && classShape.getShapeList() != null) {
                        if (classShape.getShapeList() != null && classShape.getShapeList().size() > 0) {
                            IScaleableShape p = (IScaleableShape) classShape.getShapeList().get(0); // only the first shape

                            ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
                            if (iFrame != null) {
                                final long maxW = 2000;
                                Rectangle rect = p.getScaledInstance(100d, new Point(0, 0)).getBounds();
                                PlanarImage img = iFrame.recognitionFrame.bimg.getImage();
                                if ((long) rect.getWidth() * rect.getHeight() > (maxW * maxW)) {
                                    if (iFrame.recognitionFrame.bimg.getMipMaps() != null && iFrame.recognitionFrame.bimg.getMipMaps().length > 0) {
                                        img = iFrame.recognitionFrame.bimg.getMipMaps()[iFrame.recognitionFrame.bimg.getMipMaps().length - 1].getImage();
                                        double scale = (double) img.getWidth() / (double) iFrame.recognitionFrame.bimg.getImage().getWidth();
                                        rect = p.getScaledInstance(scale * 100d, new Point(0, 0)).getBounds();
                                    }
                                }
                                BufferedImage bi = img.getAsBufferedImage(rect, iFrame.recognitionFrame.bimg.getImage().getColorModel());
                                bi = TiffConverter.makeScaledImage(bi, thumbnailWidth, thumbnailHeight);
                                ImageIcon icon = new ImageIcon(bi);
                                if ((cellCache != null) && (icon != null)) {
                                    cellCache.put(hash, icon);
                                    list.revalidate();
                                    list.repaint();
                                }
                            }
                        }
                    }

                } catch (Throwable t) {
                    // can happen (e.g, outofmemory), but no problem
                }

            }
        } // ThnRunny

    }

}
