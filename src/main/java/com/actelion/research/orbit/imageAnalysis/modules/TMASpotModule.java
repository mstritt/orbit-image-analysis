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

package com.actelion.research.orbit.imageAnalysis.modules;

import com.actelion.research.orbit.beans.RawAnnotation;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.components.*;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.imaging.TMAPoints;
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.utils.RawUtilsCommon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * TMA Spot detection and pseudo ROI-Annotation creation.
 * Spot naming currently disabled (extended table missing).
 */
public class TMASpotModule extends AbstractSpotModule {

    private static final long serialVersionUID = 1L;
    private final static Logger logger = LoggerFactory.getLogger(TMASpotModule.class);
    private final JButton btnEditor = new JButton("TMA Spot Editor");
    private final JButton btnShowStatistics = new JButton("Statistics");
    private final JButton btnShowHelp = new JButton("Help");
    private final JButton btnSaveSpots = new JButton("Save");
    private final JButton btnLoadSpots = new JButton("Load");
    private final JButton btnAssign = new JButton("Assign");
    private final JButton btnConvert = new JButton("Convert");
    private final JButton btnReset = new JButton("Reset");

    private TMASpotEditor spotEditor = null;
    private Dimension originalDimension = new Dimension(0, 0);

    public TMASpotModule(boolean withGui) {
        bbExtend = 2;
        if (withGui) {
            cellRenderer = new SpotCellRenderer();
            init2();
            addPropertyChangeListener(NumSpotsClassifiedListener.NUMSPOTSCLASSIFIED, new NumSpotsClassifiedListener(100));
        }
    }

    public void init2() {
        list.setCellRenderer(cellRenderer);

        list.addKeyListener(new SpotModuleKeyListener());

        list.addListSelectionListener(new ListSelectionListener() {
                                          public void valueChanged(ListSelectionEvent e) {
                                              final ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();

                                              if (list.getSelectedValue() != null && iFrame != null) {
                                                  ImageAnnotation ann = (ImageAnnotation) list.getSelectedValue();
                                                  IScaleableShape shape = (IScaleableShape) ann.getShape().getShapeList().get(0);
                                                  // set annotation as selected for highlightning in recognitionframe and unset all others
                                                  for (ImageAnnotation annotation : iFrame.getRecognitionFrame().getAnnotations()) {
                                                      if (annotation instanceof SpotAnnotation) {
                                                          annotation.setSelected(false);
                                                      }
                                                  }
                                                  if (ann instanceof SpotAnnotation) {
                                                      ann.setSelected(true);
                                                  }

                                              }
                                          }
                                      }
        );


        btnEditor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //OrbitImageAnalysis.getInstance().forceLogin();
                //if (OrbitImageAnalysis.loginOk) {
                openEditor(true);
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
                ResultFrame result = new ResultFrame(sb.toString(), "TMA Spot Statistics");
                oia.addInternalFrame(result);
                //}
            }
        });


        btnConvert.setToolTipText("Convert selected spot annotations to image annotations.");
        btnConvert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                AnnotationPanel aP = OrbitImageAnalysis.getInstance().getMetaBar().getAnnotationPanel();
                for (int i = 0; i < list.getModel().getSize(); i++) {
                    if (list.isSelectedIndex(i)) {
                        SpotAnnotation anno = (SpotAnnotation) list.getModel().getElementAt(i);
                        ImageAnnotation ia = anno.toImageAnnotation();
                        aP.getModel().addElement(ia);
                    }
                }
            }
        });

        btnAssign.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                assign();
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

        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                spotEditor = null;
                //list.setModel(new DefaultListModel());
                removeAllSpots();
                list.repaint();
                OrbitImageAnalysis.getInstance().getRenderGrid().setSpotPanel(null);
                OrbitImageAnalysis.getInstance().getRenderGrid().repaint();
            }
        });

        //list.addMouseListener(new MouseAdapter() {
        list.addListSelectionListener(new ListSelectionListener() {
                                          //public void mousePressed(java.awt.event.MouseEvent e) {
                                          public void valueChanged(ListSelectionEvent e) {
                                              final ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
                                              if (list.getSelectedValue() != null && iFrame != null) {
                                                  ImageAnnotation ann = (ImageAnnotation) list.getSelectedValue();
                                                  IScaleableShape shape = (IScaleableShape) ann.getShape().getShapeList().get(0);
                                                  Rectangle bb = shape.getScaledInstance(100, new Point(0, 0)).getBounds();
                                                  double sc = iFrame.recognitionFrame.getScale() / 100d;
                                                  // adjust original image dims with current dims (TMA overview image vs. full size image)
                                                  //sc *= Math.min( (iFrame.recognitionFrame.bimg.getWidth()/originalDimension.getWidth()),(iFrame.recognitionFrame.bimg.getHeight()/originalDimension.getHeight()));
                                                  final Point targetP = new Point((int) (bb.getCenterX() * sc) - iFrame.recognitionFrame.getWidth() / 2, (int) (bb.getCenterY() * sc) - iFrame.recognitionFrame.getHeight() / 2);

                                                  iFrame.setViewPortPositionAndAdjust(targetP);
                                              }
                                          }
                                      }
        );

        // layout
        JPanel btn1Panel = new JPanel(new GridLayout(1, 3));
        btn1Panel.add(btnEditor);
        btn1Panel.add(btnAssign);
        btn1Panel.add(btnConvert);

        setLayout(new GridBagLayout());
        JScrollPane scrollPane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, new GridBagConstraints(0, 0, GridBagConstraints.REMAINDER, 1, 0, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(1, 1, 0, 1), 0, 0));
        add(btn1Panel, new GridBagConstraints(0, 1, GridBagConstraints.REMAINDER, 1, 1, 0, GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        //	add(btnShowStatistics,new GridBagConstraints(1, 1, 1, 1,   1, 0, GridBagConstraints.SOUTHEAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(btnLoadSpots, new GridBagConstraints(0, 2, 1, 1, 1, 0, GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(btnSaveSpots, new GridBagConstraints(1, 2, 1, 1, 1, 0, GridBagConstraints.SOUTHEAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(btnShowHelp, new GridBagConstraints(2, 2, 1, 1, 1, 0, GridBagConstraints.SOUTHEAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(btnReset, new GridBagConstraints(0, 3, 3, 1, 1, 0, GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    }

    private void assign() {
        if (spotEditor != null) {
            generateSpots(spotEditor.getSpotPosList(), spotEditor.getImagePanel().getRadius(), false);
            OrbitImageAnalysis.getInstance().getIFrame().repaint();
        } else {
            JOptionPane.showMessageDialog(TMASpotModule.this, "Please generate TMA Spot with the TMA Spot Editor first.", "TMA Spots not created", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showHelp() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        String color = OrbitUtils.DARKUI ? " color=white" : "";
        String h = "<html><body" + color + ">" +
                "<h1>TMA Spot Module</h1>" +
                "<ol>" +
                "<li>For TMA tissue slides, first open on TMA overview image (File -> Open Overview Image)</li>" +
                "<li>Define a two class setup (Background, Tissue) and classify the overview image (to distinguish between background and tissue spots).</li>" +
                "<li>Click on TMA Spot editor and adjust the TMA spots.</li>" +
                // "<li>In the Assign tab, meaningful names can be assigned to the spots.</li>" +
                "<li>Click on 'accept' to set the spot positions (still on the overview image).</li>" +
                "<li>Select the original images and click on 'assign' to assign the TMA spots on the full image.</li>" +
                "<li>Optional with 'convert' the TMA spots can be converted into normal annotations. This can be useful for classification per annotation.</li>" +
                "</ol>" +
                "</body></html>";
        oia.addInternalFrame(new ResultFrame(h, "TMA Spot Module"));
    }

    private void openEditor(final boolean withGui) {
        // check prerequisites
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        final ImageFrame iFrame = oia.getIFrame();
        if (iFrame == null || (iFrame.recognitionFrame.getWidth() * iFrame.recognitionFrame.getHeight() > 6000 * 6000L))
            throw new IllegalArgumentException("TMA Spots can ony be detected on small images, e.g. TMA overview images.\nFor a big virtual slide, please open an TMA overview image by clicking on File->Open TMA overview image and apply the TMA spot detection on that image.");


        boolean originalDims = (spotEditor == null);
        if (iFrame.recognitionFrame.getClassImage() == null && spotEditor == null) {
            JOptionPane.showMessageDialog(this, "Please classify the TMA image first (background/spots).", "Image not classified.", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (spotEditor == null) {
            TMAPoints tmaPoints = new TMAPoints();
            tmaPoints.process(iFrame.recognitionFrame.getClassImage().getImage());
            spotEditor = new TMASpotEditor(tmaPoints.getSpotMap(), tmaPoints.getRadius(), iFrame.recognitionFrame.bimg, true);
        }
        RawUtilsCommon.centerComponent(spotEditor);
        spotEditor.setVisible(true);
        generateSpots(spotEditor.getSpotPosList(), spotEditor.getImagePanel().getRadius(), originalDims);
        oia.getRenderGrid().setSpotPanel(spotEditor.getImagePanel());
        oia.getRenderGrid().repaint();
    }


    protected void generateSpots(List<SpotPos> spotList, double radius, boolean setOriginalDimension) {
        DefaultListModel model = new DefaultListModel();
        ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
        if (iFrame != null) {
            if (setOriginalDimension) {
                originalDimension = new Dimension(iFrame.recognitionFrame.bimg.getWidth(), iFrame.recognitionFrame.bimg.getHeight());
            }

            // remove old tma spot annotations
            List<RawAnnotation> toDelete = new ArrayList<RawAnnotation>();
            for (RawAnnotation annotation : iFrame.recognitionFrame.getAnnotations()) {
                if (annotation.getRawAnnotationType() == RawAnnotation.ANNOTATION_TYPE_TMASPOT) {
                    toDelete.add(annotation);
                }
            }
            for (RawAnnotation annotation : toDelete) {
                iFrame.recognitionFrame.getAnnotations().remove(annotation);
            }

            // add new tma spot annotations
            List<ImageAnnotation> raList = new ArrayList<ImageAnnotation>();
            for (SpotPos sp : spotList) {
                ClassShape cs = new ClassShape("Spot", Color.green, ClassShape.SHAPETYPE_ARC);
                Arc2DExt arc = new Arc2DExt();
                arc.setArcByCenter(sp.getPos().x, sp.getPos().y, radius, 0, 360, Arc2D.CHORD);
                // adjust original image dims with current dims (TMA overview image vs. full size image)
                double sc = Math.min((iFrame.recognitionFrame.bimg.getWidth() / originalDimension.getWidth()), (iFrame.recognitionFrame.bimg.getHeight() / originalDimension.getHeight()));
                arc.setScale(arc.getScale() / sc);
                cs.getShapeList().add(arc);
                TMASpotAnnotation annotation = new TMASpotAnnotation(/*sp.getSpot().x+" / "+sp.getSpot().y*/OrbitUtils.getWellName(sp.getSpot().x, sp.getSpot().y) + ": " + sp.getName(), cs, sp.getSpot().x, sp.getSpot().y);
                annotation.setUserId(OrbitImageAnalysis.loginUser);
                if (iFrame.getRdf() != null) {
                    annotation.setRawDataFileId(iFrame.getRdf().getRawDataFileId());
                }
                raList.add(annotation);

            }
            Collections.sort(raList, new TMASpotComparator());
            for (ImageAnnotation annotation : raList) {
                iFrame.recognitionFrame.getAnnotations().add(annotation);
                model.addElement(annotation);
            }

            list.setModel(model);
        }
    }


    /**
     * Inserts new TMASpotAnnotations, updates modified, removes annotations that are in the database, but not in the list anymore.
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
                    if (ra.getRawAnnotationType() == RawAnnotation.ANNOTATION_TYPE_TMASPOT) {
                        TMASpotAnnotation annotation = new TMASpotAnnotation(ra);
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
                    TMASpotAnnotation annotation = (TMASpotAnnotation) list.getModel().getElementAt(i);
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
                logger.info(cnt + " tma spot annotations inserted/updated and " + delcnt + " spots removed.");
                if (withGui) {
                    JOptionPane.showMessageDialog(this, cnt + " spots successfully stored and " + delcnt + " spots removed.", "Spots successfully stored", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                logger.error("Error saving spots", e);
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
            List<RawAnnotation> raListRA = DALConfig.getImageProvider().LoadRawAnnotationsByRawDataFile(rdf.getRawDataFileId(), RawAnnotation.ANNOTATION_TYPE_TMASPOT);
            if (raListRA == null || raListRA.size() == 0) {
                logger.error("No spots found for this image.");
                return;
            }
            List<RawAnnotation> raList = new ArrayList<RawAnnotation>(raListRA.size());
            for (RawAnnotation ra : raListRA) {
                raList.add(new TMASpotAnnotation(ra));
            }
            Collections.sort(raList, new TMASpotComparator());
            for (RawAnnotation ra : raList) {
                if (ra.getRawAnnotationType() == RawAnnotation.ANNOTATION_TYPE_TMASPOT) {
                    TMASpotAnnotation annotation = new TMASpotAnnotation(ra);
                    newModel.addElement(annotation);
                    iFrame.getRecognitionFrame().getAnnotations().add(annotation);
                }
            }
            if (newModel.size() > 0) {
                list.setModel(newModel);
            }

            List<SpotPos> spList = new ArrayList<SpotPos>(raList.size());
            int radius = 0;
            for (RawAnnotation ann : raList) {
                if (!(ann instanceof TMASpotAnnotation)) continue;
                TMASpotAnnotation tmaAnn = (TMASpotAnnotation) ann;
                Arc2DExt arc = (Arc2DExt) tmaAnn.getShape().getShapeList().get(0);
                arc = arc.getScaledInstance(100d, new Point(0, 0));
                radius = (int) (arc.getBounds().getWidth() / 2d);
                Point pos = new Point((int) arc.getCenterX(), (int) arc.getCenterY());
                SpotPos spot = new SpotPos(pos, new Point(tmaAnn.getSpotX(), tmaAnn.getSpotY()));
                spList.add(spot);
            }
            SpotImagePanel ip = new SpotImagePanel(spList, radius, false);
            ip.setOriginalDimension(new Dimension(iFrame.recognitionFrame.bimg.getWidth(), iFrame.recognitionFrame.bimg.getHeight()));
            OrbitImageAnalysis.getInstance().getRenderGrid().setSpotPanel(ip);
            OrbitImageAnalysis.getInstance().getRenderGrid().repaint();

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error laoding spots", e);
        }
    }


    @Override
    public String getName() {
        return "TMA Spot Module";
    }

    @Override
    protected JButton getBtnStatistics() {
        return btnShowStatistics;
    }

    class TMASpotComparator implements Comparator<RawAnnotation> {

        public int compare(RawAnnotation o1, RawAnnotation o2) {
            if (o1 == null || o2 == null || (!(o1 instanceof TMASpotAnnotation)) || (!(o2 instanceof TMASpotAnnotation)))
                return 0;
            else {
                TMASpotAnnotation an1 = (TMASpotAnnotation) o1;
                TMASpotAnnotation an2 = (TMASpotAnnotation) o2;
                int res = 0;
                res = (int) Math.signum(an1.getSpotY() - an2.getSpotY());
                if (res == 0) {
                    res = (int) Math.signum(an1.getSpotX() - an2.getSpotX());
                }
                return res;
            }
        }
    }


}
