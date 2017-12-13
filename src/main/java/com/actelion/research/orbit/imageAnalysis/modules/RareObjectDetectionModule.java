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

import com.actelion.research.orbit.beans.RawAnnotation;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.components.*;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.tasks.ObjectSegmentationWorker;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

/**
 * RawObjectDetection means segmentation + manual confirmation/rejection.
 */
public class RareObjectDetectionModule extends AbstractSpotModule {

    private static final long serialVersionUID = 1L;
    protected static final Logger logger = LoggerFactory.getLogger(RareObjectDetectionModule.class);
    private final JButton btnGenerateSpots = new JButton("Detect");
    private final JButton btnShowStatistics = new JButton("Statistics");
    private final JButton btnShowHelp = new JButton("Help");
    private final JButton btnSaveSpots = new JButton("Save");
    private final JButton btnLoadSpots = new JButton("Load");
    private final JButton btnShuffleSpots = new JButton("Shuffle");
    private final JButton btnRemSpots = new JButton("Remove Selected");
    private final JButton btnRemSpotsROI = new JButton("Remove in ROI");

    public RareObjectDetectionModule(boolean withGui) {
        if (withGui) {
            if (OrbitImageAnalysis.getInstance().getLoadedModelFilename().equals("none")) {
                JOptionPane.showMessageDialog(this, "No model loaded. Please load an appropriate rare object detection model.", "Please load a model", JOptionPane.INFORMATION_MESSAGE);
            }
            cellRenderer = new SpotCellRenderer();
            init2();
            addPropertyChangeListener(NumSpotsClassifiedListener.NUMSPOTSCLASSIFIED, new NumSpotsClassifiedListener(100));
        }
    }

    public void init2() {
        list.setCellRenderer(cellRenderer);

        list.addKeyListener(new SpotModuleKeyListener());

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                for (int i = 0; i < list.getModel().getSize(); i++) {
                    SpotAnnotation sa = (SpotAnnotation) list.getModel().getElementAt(i);
                    sa.setSelected(false);
                }
                if (list.getSelectedValue() != null) {
                    SpotAnnotation annotation = (SpotAnnotation) (list.getSelectedValue());
                    annotation.setSelected(true);
                }
            }
        });

        btnGenerateSpots.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //OrbitImageAnalysis.getInstance().forceLogin();
                //if (OrbitImageAnalysis.loginOk) {
                generateSpots(true);
                OrbitImageAnalysis.getInstance().getIFrame().getRecognitionFrame().repaint();
                //}
            }
        });

        btnShowStatistics.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final OrbitModel model = OrbitImageAnalysis.getInstance().getModel();
                final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
                //OrbitImageAnalysis.getInstance().forceLogin();
                //if (OrbitImageAnalysis.loginOk) {
                StringBuilder sb = new StringBuilder("Available Spots: " + list.getModel().getSize() + "\n\n");
                sb.append("Absolute Counts:\n\n");
                int[] counts = computeCounts();
                for (int i = 0; i < counts.length; i++) {
                    sb.append(model.getClassShapes().get(i).getName() + ": " + counts[i] + "\n");
                }
                if (model.getClassShapes().size() > 2) {
                    sb.append("\n\nRelative Counts (class / all without last class):\n\n");
                    for (int i = 0; i < counts.length - 1; i++) {
                        double rel = counts[i];
                        double sum = 0d;
                        for (int j = 0; j < counts.length - 1; j++) {
                            sum += counts[j];
                        }
                        if (sum > 0) {
                            rel /= sum;
                            sb.append(model.getClassShapes().get(i).getName() + ": " + String.format("%1$.4f", rel) + "\n");
                        }
                    }
                }
                ResultFrame result = new ResultFrame(sb.toString(), "Rare Object Detection Statistics");
                oia.addInternalFrame(result);
                //}
            }
        });

        btnShuffleSpots.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                shuffle();
            }
        });

        btnShowHelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showHelp();
            }
        });

        btnSaveSpots.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveSpots(true);
            }
        });

        btnLoadSpots.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadSpots();
            }
        });

        btnRemSpots.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeSpots();
                repaintFrameAndList();
            }
        });

        btnRemSpotsROI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeSpotsInROI();
                repaintFrameAndList();
            }
        });

        //list.addMouseListener(new MouseAdapter() {
        list.addListSelectionListener(new ListSelectionListener() {
                                          //public void mousePressed(java.awt.event.MouseEvent e) {
                                          public void valueChanged(ListSelectionEvent e) {
                                              final ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
                                              if (list.getSelectedValue() != null && iFrame != null) {
                                                  ImageAnnotation ann = (ImageAnnotation) list.getSelectedValue();
                                                  PolygonExt shape = (PolygonExt) ann.getShape().getShapeList().get(0);
                                                  Rectangle bb = shape.getScaledInstance(100, new Point(0, 0)).getBounds();
                                                  double sc = iFrame.recognitionFrame.getScale() / 100d;
                                                  final Point targetP = new Point((int) (bb.getCenterX() * sc) - iFrame.recognitionFrame.getWidth() / 2, (int) (bb.getCenterY() * sc) - iFrame.recognitionFrame.getHeight() / 2);
                                                  //final Point currentP = new Point((int)(iFrame.recognitionFrame.getViewPortOffset().x*sc),(int)(iFrame.recognitionFrame.getViewPortOffset().y*sc));

                                                  iFrame.setViewPortPositionAndAdjust(targetP);
                                              }
                                          }
                                      }
        );

        // layout
        JPanel remSpotsPanel = new JPanel();
        remSpotsPanel.add(btnRemSpots);
        remSpotsPanel.add(btnRemSpotsROI);

        setLayout(new GridBagLayout());
        JScrollPane scrollPane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, new GridBagConstraints(0, 0, GridBagConstraints.REMAINDER, 1, 0, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(1, 1, 0, 1), 0, 0));
        add(btnGenerateSpots, new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(btnShowStatistics, new GridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.SOUTHEAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(btnShowHelp, new GridBagConstraints(2, 1, 1, 1, 1, 0, GridBagConstraints.SOUTHEAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(btnLoadSpots, new GridBagConstraints(0, 2, 1, 1, 1, 0, GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(btnSaveSpots, new GridBagConstraints(1, 2, 1, 1, 1, 0, GridBagConstraints.SOUTHEAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(btnShuffleSpots, new GridBagConstraints(2, 2, 1, 1, 1, 0, GridBagConstraints.SOUTHEAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(remSpotsPanel, new GridBagConstraints(0, 3, GridBagConstraints.REMAINDER, 1, 1, 0, GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    }


    protected void showHelp() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        String color = OrbitUtils.DARKUI ? " color=white" : "";
        String h = "<html><body" + color + ">" +
                "<h1>Rare Object Detection Module</h1>" +
                "<h2>Prerequisites</h2>" +
                "<ul>" +
                "<li>Load an appropriate model (background/foreground segmentation model + count classes (c1, c2, ...) as main model))</li>" +
                "<li>Load a rare object detection image from Orbit</li>" +
                "<li>Activate the Rare Object Detection module (Tools->Rare Object Detection Module)</li>" +
                "</ul>" +

                "<h2>Detect new spots</h2>" +
                "<ul>" +
                "<li>Click the 'Detect' button. This will detect new blue nuclei spots and list these spots in the list.<br/>You can also mark a region of interest (ROI) before spot detection to get fast results for a smaller region.</li>" +
                "<li>You can click on the 'Save' button to save detected spots.</li>" +
                "</ul>" +

                "<h2>Load existing spots</h2>" +
                "<ul>" +
                "<li>Click on the 'Load' button to see if already detected spots have been persisted and load them.</li>" +
                "</ul>" +

                "<h2>Quantify spot classes</h2>" +
                "<ol>" +
                "<li>Click on 'Shuffle' to shuffle the list. This is necessary to achieve unbiased results.</li>" +
                "<li>Click on the first spot entry in the list.</li>" +
                "<li>Use the keyboard and press a number (e.g. 1-3) to assign the selected spot a class.<br/>The selection will automatically jump to the next spot. By holding down the ctrl key you can prevent this and the selection will stay on the selected item.</li>" +
                "<li>Use specific classes only when you are sure. Otherwise select the 'other' class. These spots will later be excluded from the statistics.</li>" +

                "<li>Once you think you classified enough samples, click on 'Statistics' to retrieve a classification statistic.</li>" +
                "<li>Click on 'Save' to persist your classifications. You can always continue with the classification by pressing the 'Load' button, shuffle your list and continue the classification.</li>" +
                "</ol>" +

                "</body></html>";
        oia.addInternalFrame(new ResultFrame(h, "Rare Object Detection Help"));
    }

    protected void generateSpots(final boolean withGui) {
        // check prerequisites
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        final OrbitModel model = oia.getModel();
        final ImageFrame iFrame = oia.getIFrame();
        RawDataFile rdf = iFrame.getRdf();
        final int rdfId = rdf == null ? 0 : rdf.getRawDataFileId();
        if (iFrame == null) {
            logger.error("No image available. Please open an image first.");
            return;
        }
        if (model == null) {
            logger.error("No model loaded. Please load a model first.");
            return;
        }
        if (model.getSegmentationModel() == null) {
            logger.error("Model does not contain a segmentation model.");
            return;
        }

        boolean addOld = false;
        if (list.getModel().getSize() > 0) {
            if (JOptionPane.showConfirmDialog(this,
                    "Do you want to keep the existing spots?\nOtherwise the existing spots will be removed from the list but still kept in the database.\nIf you then press the 'save spots' button they will also be removed from the database.",
                    "Keep existing spots?", JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {
                addOld = true;
            }
        }
        if (!addOld) {
            removeAllSpots();
            repaintFrameAndList();
        }
        final boolean addOldFin = addOld;
        // ok, we have at least one open image and a model that contains a segmentation model
        iFrame.getOpacitySlider().setEnabled(true);
        final ObjectSegmentationWorker segWorker = createSpotDetectionWorker(rdf, iFrame.recognitionFrame, model, null); // tiles=null (last parameter)

        // no exclusion map so far
        final ProgressPanel progressPanel = new ProgressPanel(oia.getTitle(), "Nuclei Detection", segWorker);
        oia.addAndExecuteTask(progressPanel, true);

        new Thread() {
            public void run() {
                oia.waitForWorker(segWorker);
                // segmentation done, nuclei should be marked in the recognitionFrame
                List<Shape> shapes = iFrame.recognitionFrame.getObjectSegmentationList();
                if (shapes == null) {
                    logger.error("No shapelist found.");
                    return;
                }
                if (shapes.size() == 0) {
                    logger.info("No nuclei found.");
                    if (withGui)
                        JOptionPane.showMessageDialog(RareObjectDetectionModule.this, "No nuclei found in selected region of interest", "No nuclei found", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                // shuffle shape list to be unbiased for manual classification
                Collections.shuffle(shapes);
                final DefaultListModel listModel = new DefaultListModel();
                if (addOldFin) {
                    for (int i = 0; i < list.getModel().getSize(); i++) {
                        listModel.addElement(list.getModel().getElementAt(i));
                    }
                }
                for (Shape shape : shapes) {
                    // at FOV to list
                    ClassShape cs = new ClassShape("Nuclei", Color.white, ClassShape.SHAPETYPE_POLYGONEXT);
                    PolygonExt pe = new PolygonExt((Polygon) shape);
                    cs.getShapeList().add(pe);
                    SpotAnnotation annotation = new RareEventAnnotation(SpotAnnotation.LABEL_UNIDENTIFIED, cs);
                    annotation.setRawDataFileId(rdfId);
                    annotation.setUserId(DEFAULT_USER);
                    listModel.addElement(annotation);
                    iFrame.getRecognitionFrame().getAnnotations().add(annotation);
                }
                if (iFrame.recognitionFrame.getObjectSegmentationList() != null)
                    iFrame.recognitionFrame.getObjectSegmentationList().clear();
                try {
                    SwingUtilities.invokeAndWait(new Runnable() {
                        public void run() {
                            list.setModel(listModel);
                        }
                    });
                } catch (Exception e) {
                    logger.error("error updating spot list", e);
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /**
     * Creates a OrbitWorker that detects spots (e.g. blue nuclei) which can be retrieved via recognitionframe.getObjectSegmentationList().
     * The model must contain a segmentation model because the NucleidSegmentationWorker fetches the nested segmentation model out of the model.
     * Set the ROI in recognitionFrame before (will be used in nucleiSegmentationWorkerMultiCore).
     *
     * @param recognitionFrame
     * @param model
     * @return
     */
    public ObjectSegmentationWorker createSpotDetectionWorker(final RawDataFile rdf, final RecognitionFrame recognitionFrame, final OrbitModel model, List<Point> tiles) {
        IScaleableShape fixedROI = null;
        if (model.getFixedCircularROI() > 0) {
            fixedROI = new Arc2DExt();
            ((Arc2DExt) fixedROI).setArcByCenter((recognitionFrame.bimg.getWidth() / 2d) + model.getFixedROIOffsetX(), (recognitionFrame.bimg.getHeight() / 2d) + model.getFixedROIOffsetY(), model.getFixedCircularROI(), 0, 360, Arc2DExt.CHORD);
        }
        //recognitionFrame.setClassShapes(model.getSegmentationModel().getClassShapes());
        if (recognitionFrame.getROI() == null)
            recognitionFrame.setROI(fixedROI);
        final ObjectSegmentationWorker segWorker = new ObjectSegmentationWorker(rdf, recognitionFrame, null, model.getSegmentationModel().getClassShapes(), tiles);
        segWorker.setModel(model); // segWorker fetches the segmentation model out of the model
        segWorker.setDoWatershed(false);
        segWorker.setDoErode(false);
        segWorker.setDoDilate(true);
        return segWorker;
    }


    /**
     * Inserts new SpotAnnotations, updates modified, removes annotations that are in the database, but not in the list anymore.
     * Forces the user to login, however, no 'owner'-check is done. Thus, everyone with an Osiris account can modify or delete
     * spot annotations.
     *
     * @param withGui
     */
    protected void saveSpots(boolean withGui) {
        OrbitImageAnalysis.getInstance().forceLogin();
        if (OrbitImageAnalysis.loginOk) {
            final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
            final ImageFrame iFrame = oia.getIFrame();
            RawDataFile rdf = iFrame == null ? null : iFrame.getRdf();
            String user = DEFAULT_USER;
            if (!OrbitImageAnalysis.loginUser.equals(OrbitImageAnalysis.GUEST_USER)) {
                user = OrbitImageAnalysis.loginUser;
            }

            // remove spots that are in db but not in the list anymore
            int delcnt = 0;
            boolean delOld = false;
            try {
                List<RawAnnotation> raList = DALConfig.getImageProvider().LoadRawAnnotationsByRawDataFile(rdf.getRawDataFileId());
                for (RawAnnotation ra : raList) {
                    if (ra.getRawAnnotationType() == RawAnnotation.ANNOTATION_TYPE_SPOT) {
                        SpotAnnotation annotation = new RareEventAnnotation(ra);
                        if (!listContainsAnnotationId(annotation.getRawAnnotationId())) {
                            if (delOld || removeOld()) {
                                DALConfig.getImageProvider().DeleteRawAnnotation(annotation.getRawAnnotationId());
                                delcnt++;
                                delOld = true;
                            } else break;
                        }
                    }
                }
                logger.info(delcnt + " spot annotations removed from database");
            } catch (Exception e) {
                logger.error("Error reading existing spots from orbit", e);
            }

            // insert / update new spots
            int cnt = 0;
            try {
                for (int i = 0; i < list.getModel().getSize(); i++) {
                    SpotAnnotation annotation = (SpotAnnotation) list.getModel().getElementAt(i);
                    if (annotation.getRawDataFileId() > 0) {
                        if (annotation.getUserId().equals(DEFAULT_USER)) {
                            annotation.setUserId(user);
                        }
                        if (annotation.getRawAnnotationId() > 0) {
                            DALConfig.getImageProvider().UpdateRawAnnotation(annotation);
                        } else {
                            DALConfig.getImageProvider().InsertRawAnnotation(annotation);
                        }
                        cnt++;
                    } else {
                        logger.error("Spot cannot be saved because it is not assigned to an Orbit file. (Spots from local images cannot be saved, only Sports from images loaded from Orbit.)");
                        break;
                    }
                }
                logger.info(cnt + " spot annotations inserted/updated and " + delcnt + " spots removed.");
                if (withGui) {
                    JOptionPane.showMessageDialog(this, cnt + " spots successfully stored and " + delcnt + " spots removed.", "Spots successfully stored", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                logger.error("Error saving spots", e);
            }
        } // loginOk
    }


    protected void loadSpots() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        final ImageFrame iFrame = oia.getIFrame();
        if (oia.getModel() == null) {
            logger.error("Please load an appropriate Orbit model (.omo) first.");
            return;
        }

        RawDataFile rdf = iFrame == null ? null : iFrame.getRdf();
        if (rdf == null) {
            logger.error("No Orbit imagen open. Please open an Orbit image first.");
            return;
        }
        try {
            DefaultListModel newModel = new DefaultListModel();
            List<RawAnnotation> raList = DALConfig.getImageProvider().LoadRawAnnotationsByRawDataFile(rdf.getRawDataFileId(), RawAnnotation.ANNOTATION_TYPE_SPOT);
            if (raList == null || raList.size() == 0) {
                logger.error("No spots found for this image.");
                return;
            }
            for (RawAnnotation ra : raList) {
                if (ra.getRawAnnotationType() == RawAnnotation.ANNOTATION_TYPE_SPOT) {
                    SpotAnnotation annotation = new RareEventAnnotation(ra);
                    newModel.addElement(annotation);
                    iFrame.getRecognitionFrame().getAnnotations().add(annotation);
                }
            }
            if (newModel.size() > 0) {
                list.setModel(newModel);
            }
        } catch (Exception e) {
            logger.error("Error laoding spots", e);
        }
    }


    @Override
    public String getName() {
        return "Rare Object Detection";
    }

    @Override
    protected JButton getBtnStatistics() {
        return btnShowStatistics;
    }


}
