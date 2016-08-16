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

import com.actelion.research.orbit.beans.RawAnnotation;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.components.*;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.tasks.NerveDetectionWorker;
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

public class NerveDetectionModule extends AbstractSpotModule {

    private static final long serialVersionUID = 1L;
    protected static final Logger logger = LoggerFactory.getLogger(NerveDetectionModule.class);
    private final JButton btnGenerateSpots = new JButton("Detect");
    private final JButton btnShowStatistics = new JButton("Statistics");
    private final JButton btnShowHelp = new JButton("Help");
    private final JButton btnSaveSpots = new JButton("Save");
    private final JButton btnLoadSpots = new JButton("Load");
    private final JButton btnShuffleSpots = new JButton("Shuffle");
    private final JButton btnRemSpots = new JButton("Remove Selected");
    private final JButton btnRemSpotsROI = new JButton("Remove in ROI");
    private final JButton btnOptions = new JButton("Options");
    private final NerveDetectionParams nerveDetectionParams = new NerveDetectionParams();

    private final int annotationColor = Color.white.getRGB();
    private final int selectedColor = Color.yellow.getRGB();
    private boolean withGUI = true;

    public NerveDetectionModule(boolean withGui) {
        this.withGUI = withGui;
        if (withGui) {
            cellRenderer = new SpotCellRenderer();
            init2();
            addPropertyChangeListener(NumSpotsClassifiedListener.NUMSPOTSCLASSIFIED, new NumSpotsClassifiedListener(100));
        }
    }

    public void init2() {
        list.setCellRenderer(cellRenderer);

        list.addKeyListener(new SpotModuleKeyListener());

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
                ImageFrame iFrame = oia.getIFrame();
                //OrbitImageAnalysis.getInstance().forceLogin();
                //if (OrbitImageAnalysis.loginOk) {
                StringBuilder sb = new StringBuilder("Available Spots: " + list.getModel().getSize() + "\n\n");

                // absolute counts
                sb.append("Absolute Counts:\n\n");
                int[] counts = computeCounts();
                for (int i = 0; i < counts.length; i++) {
                    sb.append(model.getClassShapes().get(i).getName() + ": " + counts[i] + "\n");
                }

                // weighted counts
                sb.append("\n\nWeighted Counts (count*classnumber,  last class excluded):\n\n");
                int cntAll = 0;
                for (int i = 0; i < counts.length - 1; i++) {
                    int cnt = counts[i] * (i + 1);
                    sb.append(model.getClassShapes().get(i).getName() + "x" + (i + 1) + ": " + cnt + "\n");
                    cntAll += cnt;
                }
                sb.append("Weighted Count: " + cntAll + "\n");

                // relative counts
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

                // juncion length
                if (iFrame != null) {
                    ImageAnnotation junction = NerveDetectionWorker.getJunctionAnnotation(iFrame.recognitionFrame.getAnnotations());
                    if (junction != null) {
                        PolygonExt poly = (PolygonExt) junction.getShape().getShapeList().get(0);
                        poly = poly.getScaledInstance(100d, new Point(0, 0));
                        double mmpp = iFrame.recognitionFrame.getMuMeterPerPixel();
                        if (mmpp > 0) {
                            double len = poly.getDistPath() * mmpp;
                            sb.append("\nJunction length: " + String.format("%1$.2f", len) + " " + OrbitUtils.muMeter + "\n");
                        }
                    }
                }

                ResultFrame result = new ResultFrame(sb.toString(), "Statistics");
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

        btnOptions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                NerveDetectionParamsDialog paramDlg = new NerveDetectionParamsDialog(nerveDetectionParams);
                paramDlg.showDialog();
            }
        });

        list.addListSelectionListener(new ListSelectionListener() {
                                          //public void mousePressed(java.awt.event.MouseEvent e) {
                                          public void valueChanged(ListSelectionEvent e) {
                                              // unmark all annotations
                                              for (int i = 0; i < list.getModel().getSize(); i++) {
                                                  ((ImageAnnotation) list.getModel().getElementAt(i)).setColor(annotationColor);
                                              }

                                              final ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
                                              if (list.getSelectedValue() != null && iFrame != null) {
                                                  ImageAnnotation ann = (ImageAnnotation) list.getSelectedValue();
                                                  ann.setColor(selectedColor);
                                                  PolygonExt shape = (PolygonExt) ann.getShape().getShapeList().get(0);
                                                  Rectangle bb = shape.getScaledInstance(100, new Point(0, 0)).getBounds();
                                                  double sc = iFrame.recognitionFrame.getScale() / 100d;
                                                  final Point targetP = new Point((int) (bb.getCenterX() * sc) - iFrame.recognitionFrame.getWidth() / 2, (int) (bb.getCenterY() * sc) - iFrame.recognitionFrame.getHeight() / 2);

                                                  iFrame.setViewPortPositionAndAdjust(targetP);
                                              }
                                          }
                                      }
        );

        // layout

        setLayout(new GridBagLayout());
        JScrollPane scrollPane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, new GridBagConstraints(0, 0, GridBagConstraints.REMAINDER, 1, 0, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(1, 1, 0, 1), 0, 0));
        add(btnGenerateSpots, new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(btnShowStatistics, new GridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.SOUTHEAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(btnShowHelp, new GridBagConstraints(2, 1, 1, 1, 1, 0, GridBagConstraints.SOUTHEAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(btnLoadSpots, new GridBagConstraints(0, 2, 1, 1, 1, 0, GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(btnSaveSpots, new GridBagConstraints(1, 2, 1, 1, 1, 0, GridBagConstraints.SOUTHEAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(btnShuffleSpots, new GridBagConstraints(2, 2, 1, 1, 1, 0, GridBagConstraints.SOUTHEAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

        add(btnRemSpots, new GridBagConstraints(0, 3, 1, 1, 1, 0, GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(btnRemSpotsROI, new GridBagConstraints(1, 3, 1, 1, 1, 0, GridBagConstraints.SOUTHEAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(btnOptions, new GridBagConstraints(2, 3, 1, 1, 1, 0, GridBagConstraints.SOUTHEAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    }


    protected void showHelp() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        String color = OrbitUtils.DARKUI ? " color=white" : "";
        String h = "<html><body" + color + ">" +
                "<h1>Nerve Detection Module</h1>" +
                "<h2>Prerequisites</h2>" +
                "<ul>" +
                "<li>Setup or load an apropriate model. The model only defines the classnames, no training is required.</li>" +
                "<li>Load a skin biopsy image from Orbit</li>" +
                "<li>Activate the nerve detection module (Tools->Nerve Detection Module)</li>" +
                "</ul>" +

                "<h2>Model definition</h2>" +
                "<ul>" +
                "<li>Define model classes like '1x corssing', '2x crossing', ... and an additional 'other' class.</li>" +
                "<li>Later assign all wrong detected residues to this 'other' class.</li>" +
                "</ul>" +

                "<h2>Fluorescence Images</h2>" +
                "<ul>" +
                "<li>Ensure that the nerves are in red channel.</li>" +
                "<li>Open the module option menu and check the 'Fluorescence Image' option.</li>" +
                "</ul>" +

                "<h2>Detect new nerve segments</h2>" +
                "<ul>" +
                "<li>Click the 'Detect' button. This will detect nerve segments and list these spots in the list.<br/>You can also mark a region of interest (ROI) before spot detection to get fast results for a smaller region.</li>" +
                "<li>You can click on the 'Save' button to save detected spots.</li>" +
                "</ul>" +

                "<h2>Filter junction crossing nerves</h2>" +
                "<ul>" +
                "<li>Activate the 'Annotation' tab.</li>" +
                "<li>In the Annotation->Options menu, uncheck 'close polygons' (for a nicer display).</li>" +
                "<li>Click on add polygon and draw the junction.</li>" +
                "<li>You might continue and draw the junction several steps (click again on 'add polygon'). When finished, click on 'Options->Combine Polygons' to merge the junction segments to a single path.</li>" +
                "<li>Select the junction annotation, click on 'edit' and rename it to <b>'junction'</b>. This is very important, because the nerve detection module will search for an annotation called 'junction' (otherwise it will do the nerve detection on the whole image). You might give it also another color.</li>" +
                "<li>Go back to the nerve detection tab, select a ROI around the junction and click on 'detect'.</li>" +
                "<li>Remark: The old annotations are automatically removed from the database and the new combined one is automatically stored in the database.</li>" +
                "</ul>" +


                "<h2>Load existing nerve segments</h2>" +
                "<ul>" +
                "<li>Click on the 'Load' button to see if already detected spots have been persisted and load them.</li>" +
                "</ul>" +

                "<h2>Quantify nerve classes</h2>" +
                "<ol>" +
                "<li>Click on 'Shuffle' to shuffle the list. This is necessary to achieve unbiased results.</li>" +
                "<li>Click on the first spot entry in the list.</li>" +
                "<li>Use the keyboard and press a number (e.g. 1-3) to assign the selected spot a class.<br/>The selection will automatically jump to the next spot. By holding down the ctrl key you can prevent this and the selection will stay on the selected item.</li>" +
                "<li>Use specific classes only when you are sure. Otherwise select the 'other' class. These spots will later be excluded from the statistics.</li>" +
                "<li>Use backspace to reset the spot class (set to undefined).</li>" +

                "<li>Once you think you classified enough samples, click on 'Statistics' to retrieve a classification statistic.</li>" +
                "<li>Click on 'Save' to persist your classifications. You can always continue with the classification by pressing the 'Load' button, shuffle your list and continue the classification.</li>" +
                "</ol>" +

                "</body></html>";
        oia.addInternalFrame(new ResultFrame(h, "Nerve Detection Help"));
    }

    protected void generateSpots(final boolean withGui) {
        // check prerequisites
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        final OrbitModel model = oia.getModel();
        final ImageFrame iFrame = oia.getIFrame();
        if (iFrame == null) {
            logger.error("No image available. Please open an image first.");
            return;
        }
        RawDataFile rdf = iFrame.getRdf();
        final int rdfId = rdf == null ? 0 : rdf.getRawDataFileId();

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
        final NerveDetectionWorker segWorker = createSpotDetectionWorker(iFrame.recognitionFrame, model, null); // tiles=null (last parameter)

        // no exclusion map so far
        final ProgressPanel progressPanel = new ProgressPanel(oia.getTitle(), "Nerve Detection", segWorker);
        oia.addAndExecuteTask(progressPanel, true);

        new Thread() {
            public void run() {
                oia.waitForWorker(segWorker);
                // segmentation done, objects should be marked in the recognitionFrame
                List<Shape> shapes = iFrame.recognitionFrame.getObjectSegmentationList();
                if (shapes == null) {
                    logger.error("Sorry, an error in nerve detection appeared.");
                    return;
                }
                if (shapes.size() == 0) {
                    logger.info("No nerves found.");
                    if (withGui)
                        JOptionPane.showMessageDialog(NerveDetectionModule.this, "No nerves found in selected region of interest", "No nerves found", JOptionPane.INFORMATION_MESSAGE);
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
                    ClassShape cs = new ClassShape("Nerves", Color.white, ClassShape.SHAPETYPE_POLYGONEXT);
                    PolygonExt pe = new PolygonExt((Polygon) shape);
                    cs.getShapeList().add(pe);
                    SpotAnnotation annotation = new NerveAnnotation(SpotAnnotation.LABEL_UNIDENTIFIED, cs);
                    annotation.setRawDataFileId(rdfId);
                    String user = DEFAULT_USER;
                    if (withGui && !OrbitImageAnalysis.GUEST_USER.equals(OrbitImageAnalysis.loginUser)) {
                        user = OrbitImageAnalysis.loginUser;
                    }
                    annotation.setUserId(user);
                    listModel.addElement(annotation);
                    iFrame.getRecognitionFrame().getAnnotations().add(annotation);
                }
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
     *
     * @param recognitionFrame
     * @param model
     * @return
     */
    public NerveDetectionWorker createSpotDetectionWorker(final RecognitionFrame recognitionFrame, final OrbitModel model, List<Point> tiles) {
        Shape fixedROI = null;
        if (model.getFixedCircularROI() > 0) {
            fixedROI = new Arc2DExt();
            ((Arc2DExt) fixedROI).setArcByCenter((recognitionFrame.bimg.getWidth() / 2d) + model.getFixedROIOffsetX(), (recognitionFrame.bimg.getHeight() / 2d) + model.getFixedROIOffsetY(), model.getFixedCircularROI(), 0, 360, Arc2DExt.CHORD);
        }
        boolean orderPoints = false;
        List<ClassShape> classShapes = new OrbitModel().getClassShapes(); // default class shapes
        if (model != null) {
            classShapes = model.getClassShapes();
            if (model.getSegmentationModel() != null) classShapes = model.getSegmentationModel().getClassShapes();
        }
        final NerveDetectionWorker segWorker = new NerveDetectionWorker(recognitionFrame, fixedROI, null, classShapes, orderPoints, tiles);
        segWorker.setModel(model); // segWorker fetches the segmentation model out of the model
        segWorker.setDoWatershed(false);
        segWorker.setDoErode(false);
        segWorker.setDoDilate(false);
        segWorker.setDoSkeletonize(true);
        segWorker.setNerveDetectionParams(nerveDetectionParams);
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
                        SpotAnnotation annotation = new NerveAnnotation(ra);
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
                    SpotAnnotation annotation = new NerveAnnotation(ra);
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


    public void loadSpots(ImageFrame iFrame) {
        synchronized (iFrame.recognitionFrame.getAnnotations()) {
            for (ImageAnnotation anno : iFrame.recognitionFrame.getAnnotations()) {
                if (anno instanceof NerveAnnotation) {
                    ((DefaultListModel) list.getModel()).addElement(anno);
                }
            }
        }
    }

    @Override
    public String getName() {
        return "Nerve Detection";
    }

    @Override
    protected JButton getBtnStatistics() {
        return btnShowStatistics;
    }


}
