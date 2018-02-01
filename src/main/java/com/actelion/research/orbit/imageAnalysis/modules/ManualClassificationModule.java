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

package com.actelion.research.orbit.imageAnalysis.modules;

import com.actelion.research.orbit.beans.RawAnnotation;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.components.ImageFrame;
import com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis;
import com.actelion.research.orbit.imageAnalysis.components.ResultFrame;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.features.TissueFeatures;
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import weka.core.DenseInstance;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ManualClassificationModule extends AbstractSpotModule {

    private static final long serialVersionUID = 1L;
    protected final JButton btnGenerateSpots = new JButton("Generate");
    protected final JButton btnShowStatistics = new JButton("Statistics");
    protected final JButton btnSaveSpots = new JButton("Save");
    protected final JButton btnLoadSpots = new JButton("Load");

    protected int numX = 30;
    protected int numY = 30;

    public ManualClassificationModule(boolean withGui) {
        if (withGui) {
            if (OrbitImageAnalysis.getInstance().getLoadedModelFilename().equals("none")) {
                JOptionPane.showMessageDialog(this, "No model loaded. Please load or create an appropriate model.", "Please load a model", JOptionPane.INFORMATION_MESSAGE);
            }
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
                //}
            }
        });

        btnShowStatistics.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showStatistics();
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


        list.addListSelectionListener(new ListSelectionListener() {
                                          public void valueChanged(ListSelectionEvent e) {
                                              final ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();

                                              if (list.getSelectedValue() != null && iFrame != null) {
                                                  ImageAnnotation ann = (ImageAnnotation) list.getSelectedValue();
                                                  PolygonExt shape = (PolygonExt) ann.getShape().getShapeList().get(0);
                                                  Rectangle bb = shape.getScaledInstance(100, new Point(0, 0)).getBounds();
                                                  double sc = iFrame.recognitionFrame.getScale() / 100d;
                                                  final Point targetP = new Point((int) (bb.getCenterX() * sc) - iFrame.recognitionFrame.getWidth() / 2, (int) (bb.getCenterY() * sc) - iFrame.recognitionFrame.getHeight() / 2);

                                                  // set annotation as selected for highlightning in recognitionframe and unset all others
                                                  for (ImageAnnotation annotation : iFrame.getRecognitionFrame().getAnnotations()) {
                                                      if (annotation instanceof SpotAnnotation) {
                                                          annotation.setSelected(false);
                                                      }
                                                  }
                                                  if (ann instanceof SpotAnnotation) {
                                                      ann.setSelected(true);
                                                  }

                                                  iFrame.setViewPortPositionAndAdjust(targetP);
                                              }
                                          }
                                      }
        );

        // layout


        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Spots");
        JMenuItem item = new JMenuItem("Remove Selected");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeSpots();
                repaintFrameAndList();
            }
        });
        menu.add(item);
        item = new JMenuItem("Remove in ROI");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeSpotsInROI();
                repaintFrameAndList();
            }
        });
        menu.add(item);
        menu.addSeparator();
        item = new JMenuItem("Classify as Proposed Class");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                classify();
                repaintFrameAndList();
            }
        });
        menu.add(item);
        item = new JMenuItem("Accept Proposed Classes for Selected Spots");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                accept();
                repaintFrameAndList();
            }
        });
        menu.add(item);
        menuBar.add(menu);

        menu = new JMenu("Sort");
        item = new JMenuItem("Shuffle");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                shuffle();
            }
        });
        menu.add(item);
        item = new JMenuItem("Sort by Class");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sortByClass(false);
            }
        });
        menu.add(item);
        item = new JMenuItem("Sort by Proposed Class");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sortByClass(true);
            }
        });
        menu.add(item);
        menuBar.add(menu);

        menu = new JMenu("Help");
        item = new JMenuItem("Show Help");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showHelp();
            }
        });
        menu.add(item);
        menuBar.add(menu);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        JScrollPane scrollPane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainPanel.add(scrollPane, new GridBagConstraints(0, 0, GridBagConstraints.REMAINDER, 1, 0, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(1, 1, 0, 1), 0, 0));
        mainPanel.add(btnGenerateSpots, new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        mainPanel.add(btnShowStatistics, new GridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.SOUTHEAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        mainPanel.add(btnLoadSpots, new GridBagConstraints(0, 2, 1, 1, 1, 0, GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        mainPanel.add(btnSaveSpots, new GridBagConstraints(1, 2, 1, 1, 1, 0, GridBagConstraints.SOUTHEAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

        setLayout(new BorderLayout());
        add(menuBar, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
    }


    protected void sortByClass(final boolean useProposedClass) {
        DefaultListModel listModel = (DefaultListModel) list.getModel();
        List<SpotAnnotation> annotationList = new ArrayList<SpotAnnotation>(listModel.size());
        for (int i = 0; i < listModel.getSize(); i++) {
            SpotAnnotation annotation = (SpotAnnotation) listModel.get(i);
            annotationList.add(annotation);
        }
        Collections.sort(annotationList, new Comparator<SpotAnnotation>() {
            public int compare(SpotAnnotation o1, SpotAnnotation o2) {
                if (useProposedClass)
                    return o1.getProposedClassNum() - o2.getProposedClassNum();
                else return o1.getClassNum() - o2.getClassNum(); // real class
            }
        });
        clear();
        DefaultListModel newModel = new DefaultListModel();
        for (SpotAnnotation annotation : annotationList) {
            newModel.addElement(annotation);
        }
        list.setModel(newModel);
    }


    private void showHelp() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        String color = OrbitUtils.DARKUI ? " color=white" : "";
        String h = "<html><body" + color + ">" +
                "<h1>Manual Classifiaction Module</h1>" +
                "<h2>Prerequisites</h2>" +
                "<ul>" +
                "<li>Load or create (F4) an appropriate model (.cell)</li>" +
                "<li>Load an image from Orbit</li>" +
                "<li>Activate the manual classification module (Tools->Manuel Classification Module)</li>" +
                "</ul>" +

                "<h2>Create a spot grid</h2>" +
                "<ul>" +
                "<li>Select a region of interest (ROI) if you want. If you want to distrubute the grid over the whole image, continue with the next step.</li>" +
                "<li>Click the 'Generate' button. Enter the number of spots you want to create and click 'ok'.</li>" +
                "</ul>" +

                "<h2>Load existing spots</h2>" +
                "<ul>" +
                "<li>Click on the 'Load' button to see if already detected spots have been persisted and load them.</li>" +
                "</ul>" +

                "<h2>Quantify spot classes</h2>" +
                "<ol>" +
                "<li>Click on 'Shuffle' to shuffle the list. This is necessary to achieve unbiased results. Generated spot lists are always shuffeled by default.</li>" +
                "<li>Click on the first spot entry in the list.</li>" +
                "<li>Use the keyboard and press a number (e.g. 1-3) to assign the selected spot a class.<br/>The selection will automatically jump to the next spot. By holding down the ctrl key you can prevent this and the selection will stay on the selected item.</li>" +
                "<li>Use specific classes only when you are sure. Otherwise select the 'other' class. These spots will later be excluded from the statistics.</li>" +
                "<li>With backspace you can make spots as unseen (undefined).</li>" +


                "<li>Once you think you classified enough samples, click on 'Statistics' to retrieve a classification statistic.</li>" +
                "<li>Click on 'Save' to persist your classifications. You can always continue with the classification by pressing the 'Load' button, shuffle your list and continue the classification.</li>" +
                "</ol>" +

                "</body></html>";
        oia.addInternalFrame(new ResultFrame(h, "Manual Classification Help"));
    }


    private void accept() {
        if (!(list.getSelectedValues() != null && list.getSelectedValues().length > 0)) {
            logger.error("No spots selected. Please Select some spots.\nHint: You can use CTRL-A to select all spots.");
        }
        for (Object o : list.getSelectedValues()) {
            SpotAnnotation spot = (SpotAnnotation) o;
            if (spot.getProposedClassNum() >= 0)
                spot.setClassNum(spot.getProposedClassNum());
        }
    }

    private void classify() {
        OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        OrbitModel model = oia.getModel();
        if (model.getClassifier() == null || (!model.getClassifier().isBuild())) {
            JOptionPane.showMessageDialog(this, "Model not trained. Please train a model first.", "Model not trained", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ImageFrame iFrame = oia.getIFrame();
        if (iFrame == null) {
            JOptionPane.showMessageDialog(this, "Please open at lease one image", "No image available", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            TissueFeatures tissueFeatures = new TissueFeatures(model.getFeatureDescription(), iFrame.recognitionFrame.bimg);
            double[] feats = tissueFeatures.prepareDoubleArray();
            int x, y;
            Rectangle re;
            SpotAnnotation spot;
            DenseInstance inst;
            for (int i = 0; i < list.getModel().getSize(); i++) {
                spot = (SpotAnnotation) list.getModel().getElementAt(i);
                re = spot.getShape().getShapeList().get(0).getBounds();
                x = (int) re.getCenterX();
                y = (int) re.getCenterY();
                feats = tissueFeatures.buildFeatures(null, x, y, Double.NaN);
                inst = new DenseInstance(1.0d, feats);
                inst.setDataset(model.getStructure());
                double classVal = model.getClassifier().classifyInstance(inst);
                spot.setProposedClassNum((int) classVal);
                String classLabel = model.getClassShapes().get((int) classVal).getName();
                spot.setDescription(classLabel + "*");
                spot.setColor(model.getClassShapes().get((int) classVal).getColor().getRGB());
            }
            repaintFrameAndList();
        } catch (Exception e1) {
            logger.error("Error classifying spots: " + e1.getMessage());
            e1.printStackTrace();
        }
    }


    private void showStatistics() {
        final OrbitModel model = OrbitImageAnalysis.getInstance().getModel();
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        final ImageFrame iFrame = oia.getIFrame();
        double overallMM = Double.NaN;
        if (iFrame != null && (!Double.isNaN(iFrame.recognitionFrame.getMuMeterPerPixel())) && (iFrame.recognitionFrame.getMuMeterPerPixel() > 0)) {
            int minX = 0;
            int minY = 0;
            int maxX = iFrame.recognitionFrame.bimg.getWidth();
            int maxY = iFrame.recognitionFrame.bimg.getHeight();
            if (iFrame.recognitionFrame.getROI() != null) {
                Rectangle re = iFrame.recognitionFrame.getROI().getScaledInstance(100, new Point(0, 0)).getBounds();
                minX = (int) re.getMinX();
                minY = (int) re.getMinY();
                maxX = (int) re.getMaxX();
                maxY = (int) re.getMaxY();
            }
            double mmpp = iFrame.recognitionFrame.getMuMeterPerPixel() / 1000d; // millimeter per pixel
            overallMM = ((maxX - minX) * mmpp) * ((maxY - minY) * mmpp);
        }

        //OrbitImageAnalysis.getInstance().forceLogin();
        //if (OrbitImageAnalysis.loginOk) {
        StringBuilder sb = new StringBuilder("#Available Spots: " + list.getModel().getSize() + "\n\n");
        StringBuilder cpTable = new StringBuilder();
        logger.info("Manual Classification Statistics");
        logger.info("Available Spots: " + list.getModel().getSize() + "\n");
        sb.append("#Absolute counts / area:\n\n");
        sb.append("Classname\tCount\tArea\tUnit\n");
        logger.info("Absolute counts / area:\n");
        double firstMuMeterPerSpot = Double.NaN;
        if (list.getModel().getSize() > 0) {
            firstMuMeterPerSpot = ((ManualClassSpotAnnotation) list.getModel().getElementAt(0)).getSquareMilliMeter();
        }
        int[] counts = computeCounts();
        for (int i = 0; i < counts.length; i++) {
            sb.append(model.getClassShapes().get(i).getName() + "\t" + counts[i]);
            if (!Double.isNaN(firstMuMeterPerSpot)) {
                sb.append("\t" + String.format("%1$.2f", counts[i] * firstMuMeterPerSpot).replaceAll("\\.", ",") + "\tmm�"); // �m�
                cpTable.append(String.format("%1$.4f", counts[i] * firstMuMeterPerSpot).replaceAll("\\.", ",") + "\n");
                logger.info(" ~ " + String.format("%1$.8f", counts[i] * firstMuMeterPerSpot) + " mm�");
            }
            sb.append("\n");
        }
        if (model.getClassShapes().size() > 2) {
            sb.append("\n\n#Relative Counts (class / all without last class):\n\n");
            sb.append("Classname\tRelative\n");
            logger.info("\n\nRelative Counts (class / all without last class):\n");
            for (int i = 0; i < counts.length - 1; i++) {
                double rel = counts[i];
                double sum = 0d;
                for (int j = 0; j < counts.length - 1; j++) {
                    sum += counts[j];
                }
                if (sum > 0) {
                    rel /= sum;
                    sb.append(model.getClassShapes().get(i).getName() + "\t" + String.format("%1$.4f", rel).replaceAll("\\.", ","));
                    cpTable.append(String.format("%1$.4f", rel).replaceAll("\\.", ",") + "\n");
                    sb.append("\n");
                    logger.info(model.getClassShapes().get(i).getName() + ": " + String.format("%1$.8f", rel));
                }
            }
            if (!Double.isNaN(overallMM)) {
                sb.append("\n\n#Extrapolated Areas:\n\n");
                sb.append("Classname\tArea\tUnit\n");
                logger.info("\n\nExtrapolated Areas:\n");
                for (int i = 0; i < counts.length; i++) {
                    double rel = counts[i];
                    double sum = 0d;
                    for (int j = 0; j < counts.length; j++) {
                        sum += counts[j];
                    }
                    if (sum > 0) {
                        rel /= sum;
                        sb.append(model.getClassShapes().get(i).getName() + "\t" + String.format("%1$.2f", overallMM * rel).replaceAll("\\.", ",") + "\tmm�");
                        sb.append("\n");
                        cpTable.append(String.format("%1$.4f", overallMM * rel).replaceAll("\\.", ",") + "\n");
                        logger.info(model.getClassShapes().get(i).getName() + ": " + String.format("%1$.8f", overallMM * rel) + " mm�");
                    }
                }
            }
        }
        String res = OrbitUtils.text2SmartHtml(sb.toString() + "\n\n#Copy&Paste Data Column\n" + iFrame.getTitle() + "\n" + cpTable.toString());
        ResultFrame result = new ResultFrame(res, "Manual Classification Statistics");
        oia.addInternalFrame(result);
        //}
    }

    private void generateSpots(final boolean withGui) {
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

        if (withGui) {
            // ask for numX and numX spots
            ManualClassificationRasterDialog dialog = new ManualClassificationRasterDialog();
            if (dialog.showOpenDialog(oia) == ManualClassificationRasterDialog.APPROVE_OPTION) {
                numX = dialog.getNumX();
                numY = dialog.getNumY();
                logger.debug("numX: " + numX + "  numY: " + numY);
            } else {
                return;
            }
        }

        clear(); // clear list and cellHash
        list.setModel(new DefaultListModel());
        list.repaint();

        // ok, we have at least one open image and a model
        new Thread() {
            public void run() {

                iFrame.recognitionFrame.setObjectSegmentationList(new ArrayList<Shape>());
                List<Shape> shapes = iFrame.recognitionFrame.getObjectSegmentationList();

                // generate the FOV field
                int crossWidth = 20;
                int minX = 0;
                int minY = 0;
                int maxX = iFrame.recognitionFrame.bimg.getWidth();
                int maxY = iFrame.recognitionFrame.bimg.getHeight();
                if (iFrame.recognitionFrame.getROI() != null) {
                    Rectangle re = iFrame.recognitionFrame.getROI().getScaledInstance(100, new Point(0, 0)).getBounds();
                    minX = (int) re.getMinX();
                    minY = (int) re.getMinY();
                    maxX = (int) re.getMaxX();
                    maxY = (int) re.getMaxY();
                }
                double stepX = (maxX - minX) / (double) numX;
                double stepY = (maxY - minY) / (double) numY;
                double xOffs = (maxX - (minX + (numX - 1) * stepX)) / 2d;
                double yOffs = (maxY - (minY + (numY - 1) * stepY)) / 2d;
                for (int ix = 0; ix < numX; ix++)
                    for (int iy = 0; iy < numY; iy++) {
                        int x = (int) Math.round(minX + stepX * ix + xOffs);
                        int y = (int) Math.round(minY + stepY * iy + yOffs);
                        Polygon p = new Polygon();
                        p.addPoint(x - crossWidth, y);
                        p.addPoint(x + crossWidth, y);
                        p.addPoint(x, y);
                        p.addPoint(x, y - crossWidth);
                        p.addPoint(x, y + crossWidth);
                        p.addPoint(x, y);
                        shapes.add(p);
                    }


                // segmentation done, nuclei should be marked in the recognitionFrame

                if (shapes.size() == 0) {
                    logger.info("No spots found.");
                    if (withGui)
                        JOptionPane.showMessageDialog(ManualClassificationModule.this, "No spots found in selected region of interest", "No spots found", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                // shuffle shape list to be unbiased for manual classification
                Collections.shuffle(shapes);
                final DefaultListModel listModel = new DefaultListModel();
                for (Shape shape : shapes) {
                    // at FOV to list
                    ClassShape cs = new ClassShape("Spot", Color.green, ClassShape.SHAPETYPE_POLYGONEXT);
                    PolygonExt pe = new PolygonExt((Polygon) shape);
                    cs.getShapeList().add(pe);
                    ManualClassSpotAnnotation annotation = new ManualClassSpotAnnotation(ManualClassSpotAnnotation.LABEL_UNIDENTIFIED, cs);
                    annotation.setRawDataFileId(rdfId);
                    annotation.setUserId(DEFAULT_USER);
                    // squareMuMeter
                    if (iFrame != null && (!Double.isNaN(iFrame.recognitionFrame.getMuMeterPerPixel())) && (iFrame.recognitionFrame.getMuMeterPerPixel() > 0)) {
                        double mmpp = iFrame.recognitionFrame.getMuMeterPerPixel() / 1000d; // millimeter per pixel
                        double squareMmMeterPerSpot = (stepX * mmpp) * (stepY * mmpp);
                        annotation.setSquareMilliMeter(squareMmMeterPerSpot);
                    }
                    listModel.addElement(annotation);
                    iFrame.getRecognitionFrame().getAnnotations().add(annotation);
                }
                try {
                    SwingUtilities.invokeAndWait(new Runnable() {
                        public void run() {
                            list.setModel(listModel);
                            OrbitImageAnalysis.getInstance().getIFrame().getRecognitionFrame().repaint();
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
     * Inserts new ManualClassSpotAnnotations, updates modified, removes annotations that are in the database, but not in the list anymore.
     * Forces the user to login, however, no 'owner'-check is done. Thus, everyone with an Osiris account can modify or delete
     * spot annotations.
     *
     * @param withGui
     */
    private void saveSpots(boolean withGui) {
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
                    if (ra.getRawAnnotationType() == RawAnnotation.ANNOTATION_TYPE_MANUALCLASS) {
                        ManualClassSpotAnnotation annotation = new ManualClassSpotAnnotation(ra);
                        if (!listContainsAnnotationId(annotation.getRawAnnotationId())) {
                            if (delOld || removeOld()) {
                                DALConfig.getImageProvider().DeleteRawAnnotation(annotation.getRawAnnotationId());
                                delcnt++;
                                delOld = true;
                            } else break;
                        }
                    }
                }
                logger.info(delcnt + " manual classification annotations removed from database");
            } catch (Exception e) {
                logger.error("Error reading existing manual classifications from orbit", e);
            }

            // insert / update new spots
            int cnt = 0;
            try {
                for (int i = 0; i < list.getModel().getSize(); i++) {
                    ManualClassSpotAnnotation annotation = (ManualClassSpotAnnotation) list.getModel().getElementAt(i);
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
                        logger.error("Manual classification spots cannot be saved because it is not assigned to an Orbit file. (Manual classification spots from local images cannot be saved, only spots from images loaded from Orbit.)");
                        break;
                    }
                }
                logger.info(cnt + " manual classification spot annotations inserted/updated and " + delcnt + " spots removed.");
                if (withGui) {
                    JOptionPane.showMessageDialog(this, cnt + " manual classification spots successfully stored and " + delcnt + " spots removed.", "Spots successfully stored", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                logger.error("Error saving manual classification spots", e);
            }
        } // loginOk
    }


    private void loadSpots() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        final ImageFrame iFrame = oia.getIFrame();
        if (oia.getModel() == null) {
            logger.error("Please load an appropriate Orbit model (.cell) first.");
            return;
        }

        RawDataFile rdf = iFrame == null ? null : iFrame.getRdf();
        if (rdf == null) {
            logger.error("No Orbit imagen open. Please open an Orbit image first.");
            return;
        }
        try {
            DefaultListModel newModel = new DefaultListModel();
            List<RawAnnotation> raList = DALConfig.getImageProvider().LoadRawAnnotationsByRawDataFile(rdf.getRawDataFileId());
            if (raList == null || raList.size() == 0) {
                logger.error("No spots found for this image.");
                return;
            }
            for (RawAnnotation ra : raList) {
                if (ra.getRawAnnotationType() == RawAnnotation.ANNOTATION_TYPE_MANUALCLASS) {
                    ManualClassSpotAnnotation annotation = new ManualClassSpotAnnotation(ra);
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

    @Override
    public String getName() {
        return "Manual Classification";
    }

    @Override
    protected JButton getBtnStatistics() {
        return btnShowStatistics;
    }


}
