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
import com.actelion.research.orbit.imageAnalysis.components.ImageFrame;
import com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis;
import com.actelion.research.orbit.imageAnalysis.components.ResultFrame;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.imageAnalysis.utils.PolygonMetrics;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ManualBoxCountModule extends AbstractSpotModule {

    private static final long serialVersionUID = 1L;
    protected final JButton btnGenerateSpots = new JButton("Generate");
    protected final JButton btnShowStatistics = new JButton("Statistics");
    protected final JButton btnSaveSpots = new JButton("Save");
    protected final JButton btnLoadSpots = new JButton("Load");

    protected int boxWidth = 300;
    protected double percentage = 20;

    protected final Map<String, Double> areaCache = new ConcurrentHashMap<String, Double>();
    protected Random rand = new Random();

    public ManualBoxCountModule(boolean withGui) {
        if (withGui) {
            if (OrbitImageAnalysis.getInstance().getLoadedModelFilename().equals("none")) {
                JOptionPane.showMessageDialog(this, "No model loaded. Please create or load an appropriate model (see help).", "Please load or create a model", JOptionPane.INFORMATION_MESSAGE);
            }
            cellRenderer = new SpotCellRenderer();
            init2();
            addPropertyChangeListener(NumSpotsClassifiedListener.NUMSPOTSCLASSIFIED, new NumSpotsClassifiedListener(100));
        }
    }

    @Override
    protected int getClassNumOffset() {
        return 0;
    }


    public void init2() {
        list.setCellRenderer(cellRenderer);

        list.addKeyListener(new SpotModuleKeyListener());

        btnGenerateSpots.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateSpots(true);
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
        item = new JMenuItem("Reset all Boxes");
        item.setToolTipText("set class to 'undefined'");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetAllSpots();
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
                "<h1>Manual Box Count Module</h1>" +
                "<h2>Prerequisites</h2>" +
                "<ul>" +
                "<li>Create (F4) or load an appropriate model. The model should contain count classes, e.g. class names from '0' till '9'.</li>" +
                "<li>Load an image from Orbit</li>" +
                "<li>Activate the manual box count module (Tools->Manuel Box Count Module)</li>" +
                "</ul>" +

                "<h2>Create Count Boxes</h2>" +
                "<ul>" +
                "<li>Create annotations on the image where you want to count (if not already done).</li>" +
                "<li>Click the 'Generate' button. Enter the box size and the percentage and click 'ok'. The percentage will be the percentage areawhich will be covert by the boxes in each annotation. Ensure that the box size is small enough that Orbit is able is place enough boxes.</li>" +
                "</ul>" +

                "<h2>Load Existing Boxes</h2>" +
                "<ul>" +
                "<li>Click on the 'Load' button to see if already detected boxes have been persisted and load them.</li>" +
                "</ul>" +

                "<h2>Count Objects in Boxes</h2>" +
                "<ol>" +
                "<li>Click on the first box entry in the list.</li>" +
                "<li>Use the keyboard and press a number (e.g. 0-9) to assign a count number to the selected box.<br/>The selection will automatically jump to the next box. By holding down the ctrl key you can prevent this and the selection will stay on the selected item.</li>" +
                "<li>With backspace you can mark spots as unseen (undefined).</li>" +


                "<li>Once you think you counted enough boxes, click on 'Statistics' to retrieve a statistic.</li>" +
                "<li>Click on 'Save' to persist your boxes and counts. You can always continue the quantification by pressing the 'Load' button after you opened the same image.</li>" +
                "</ol>" +

                "</body></html>";
        oia.addInternalFrame(new ResultFrame(h, "Manual Box Count Help"));
    }


    private void showStatistics() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        final ImageFrame iFrame = oia.getIFrame();

        String areaUnit = "�m�";
        double mmpp = 1d;
        if (iFrame != null && (!Double.isNaN(iFrame.recognitionFrame.getMuMeterPerPixel())) && (iFrame.recognitionFrame.getMuMeterPerPixel() > 0)) {
            mmpp = iFrame.recognitionFrame.getMuMeterPerPixel(); // mumeter per pixel
        } else {
            areaUnit = "pixel";
        }


        StringBuilder sb = new StringBuilder("#Statistics\n\n");
        sb.append("Annotation\tCount\tCount/NumBoxes\tBoxesArea(" + areaUnit + ")\tNumBoxes\tAnnotationArea(" + areaUnit + ")\tPercentAnnotation\n"); // header

        RawDataFile rdf = iFrame.getRdf();
        if (rdf == null) {
            logger.error("No Orbit image");
            return;
        }
        List<RawAnnotation> annotations = null;
        try {
            annotations = DALConfig.getImageProvider().LoadRawAnnotationsByRawDataFile(rdf.getRawDataFileId(), RawAnnotation.ANNOTATION_TYPE_IMAGE);
        } catch (Exception e) {
            logger.error("Error loading annotations");
            return;
        }

        // generate the FOV field per annotation
        areaCache.clear();

        for (RawAnnotation ra : annotations) {
            if (ra.getRawAnnotationType() != RawAnnotation.ANNOTATION_TYPE_IMAGE) continue;
            if (ra.getDescription().equalsIgnoreCase("ROI")) continue;
            ImageAnnotation anno = null;
            try {
                anno = new ImageAnnotation(ra);
            } catch (Exception e) {
                logger.error("error creating image annotation");
                continue;
            }

            if (anno.getShape().getShapeList() == null || anno.getShape().getShapeList().size() < 1) {
                logger.error("annotation contains no shape");
                continue;
            }
            Shape annoShape = ((IScaleableShape) anno.getShape().getShapeList().get(0)).getScaledInstance(100, new Point(0, 0));
            double shapeArea = getShapeArea(annoShape, anno.getDescription());
            double squareMmMeterPerAnno = shapeArea * mmpp * mmpp;
            int numBoxesInAnno = countNumSpots(annoShape);
            double boxArea = (double) numBoxesInAnno * boxWidth * boxWidth * mmpp * mmpp;
            double areaPercentage = (boxArea / squareMmMeterPerAnno) * 100d;
            int[] counts = computeCounts(annoShape);
            int count = 0;
            for (int i = 0; i < counts.length; i++) {
                count += counts[i] * i; // starting from 0 - with first class!
            }
            double countNorm = count / (double) numBoxesInAnno;
            sb.append(anno.getDescription() + "\t" + count + "\t" + countNorm + "\t" + boxArea + "\t" + numBoxesInAnno + "\t" + squareMmMeterPerAnno + "\t" + areaPercentage + "\n");

        }

        String res = OrbitUtils.text2SmartHtml(sb.toString());
        final ResultFrame result = new ResultFrame(res, getName() + " Statistics");
        new Thread(new Runnable() {
            public void run() {
                oia.addInternalFrame(result);
            }
        }).start();

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
        if (iFrame.recognitionFrame.getAnnotations() == null || iFrame.recognitionFrame.getAnnotations().size() < 1) {
            logger.error("No annotations found. Please create at least one annotation first in which the boxes will be created.");
            return;
        }

        if (withGui) {
            // ask for numX and numX spots
            ManualClassificationRasterDialog dialog = new ManualClassificationRasterDialog();
            dialog.setTitle("Set Parameters");
            dialog.getLabNumX().setText("Box Size:");
            dialog.getLabNumY().setText("Percent Coverage:");
            if (dialog.showOpenDialog(oia) == ManualClassificationRasterDialog.APPROVE_OPTION) {
                boxWidth = dialog.getNumX();
                percentage = dialog.getNumY();
                logger.debug("boxWidth: " + boxWidth + "  percentage: " + percentage);
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
                List<Point> pList = generateGridPerAnnotation(iFrame);
                List<Shape> shapes = iFrame.recognitionFrame.getObjectSegmentationList();
                for (Point p : pList) {
                    addGridShape(p, shapes);
                }

                // segmentation done, nuclei should be marked in the recognitionFrame

                if (shapes.size() == 0) {
                    logger.info("No spots found.");
                    if (withGui)
                        JOptionPane.showMessageDialog(ManualBoxCountModule.this, "No spots found in selected region of interest", "No spots found", JOptionPane.INFORMATION_MESSAGE);
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
                    ManualBoxCountAnnotation annotation = new ManualBoxCountAnnotation(ManualClassSpotAnnotation.LABEL_UNIDENTIFIED, cs);
                    annotation.setRawDataFileId(rdfId);
                    annotation.setUserId(DEFAULT_USER);
                    // squareMuMeter
                    if (iFrame != null && (!Double.isNaN(iFrame.recognitionFrame.getMuMeterPerPixel())) && (iFrame.recognitionFrame.getMuMeterPerPixel() > 0)) {
                        double mmpp = iFrame.recognitionFrame.getMuMeterPerPixel() / 1000d; // millimeter per pixel
                        double squareMmMeterPerSpot = (shape.getBounds().width * mmpp) * (shape.getBounds().height * mmpp);
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


    private List<Point> generateGridPerAnnotation(ImageFrame iFrame) {
        RawDataFile rdf = iFrame.getRdf();
        if (rdf == null) {
            logger.error("No Orbit image");
            return new ArrayList<Point>();
        }
        List<RawAnnotation> annotations = null;
        try {
            annotations = DALConfig.getImageProvider().LoadRawAnnotationsByRawDataFile(rdf.getRawDataFileId(), RawAnnotation.ANNOTATION_TYPE_IMAGE);
        } catch (Exception e) {
            logger.error("Error loading annotations");
            return new ArrayList<Point>();
        }

        // generate the FOV field per annotation
        areaCache.clear();
        List<Point> pList = new ArrayList<Point>();
        for (RawAnnotation ra : annotations) {
            if (ra.getRawAnnotationType() != RawAnnotation.ANNOTATION_TYPE_IMAGE) continue;
            if (ra.getDescription().equalsIgnoreCase("ROI")) continue;
            ImageAnnotation anno = null;
            try {
                anno = new ImageAnnotation(ra);
            } catch (Exception e) {
                logger.error("error creating image annotation");
                continue;
            }

            if (anno.getShape().getShapeList() == null || anno.getShape().getShapeList().size() < 1) {
                logger.error("annotation contains no shape");
                continue;
            }
            Shape annoShape = ((IScaleableShape) anno.getShape().getShapeList().get(0)).getScaledInstance(100, new Point(0, 0));
            Rectangle bb = annoShape.getBounds();

            int cnt = 0;
            int maxCnt = 100000;
            Rectangle re = new Rectangle();
            Rectangle reOther = new Rectangle();
            boolean added = false;
            List<Point> shapePList = new ArrayList<Point>();
            while ((!added) || percentArea(shapePList, annoShape, anno.getDescription()) < percentage) {
                int x = bb.x + rand.nextInt(bb.width);
                int y = bb.y + rand.nextInt(bb.height);
                Point p = new Point(x, y);
                if (inShapeNotOverlapping(p, shapePList, annoShape, re, reOther)) {
                    shapePList.add(p);
                    added = true;
                } else {
                    added = false;
                }
                cnt++;
                if (cnt > maxCnt) {
                    logger.error("Cannot place boxes. Please select a smaller boxes width.");
                    return new ArrayList<Point>();
                }
            }
            pList.addAll(shapePList);
        }
        return pList;
    }

    private boolean inShapeNotOverlapping(Point p, List<Point> pList, Shape shape, Rectangle re, Rectangle reOther) {
        int wh = boxWidth / 2;
        re.setFrame(p.x - wh, p.y - wh, boxWidth, boxWidth);
        if (!shape.contains(re)) return false;
        for (Point point : pList) {
            reOther.setFrame(point.x - wh, point.y - wh, boxWidth, boxWidth);
            if (re.intersects(reOther)) return false;
        }
        return true;
    }

    /**
     * Assumes that the boxes are not overlapping.
     */
    private double percentArea(List<Point> pList, Shape shape, String annoName) {
        double area = getShapeArea(shape, annoName);
        double reArea = boxWidth * boxWidth * pList.size();
        double percentage = (reArea / area) * 100d;
        logger.info(annoName + ": " + percentage + "%");
        return percentage;
    }

    private double getShapeArea(Shape shape, String annoName) {
        Double area = areaCache.get(annoName);
        if (area == null) {
            if (shape instanceof Polygon) {
                Polygon poly = (Polygon) shape;
                PolygonMetrics pm = new PolygonMetrics(poly);
                area = pm.getArea();
            } else { // renctangle
                Rectangle rect = shape.getBounds();
                area = new Double(rect.width * rect.height);
            }
            areaCache.put(annoName, area);
        }
        return area;
    }

    private void addGridShape(Point point, List<Shape> shapes) {
        Polygon p = new Polygon();
        int hw = boxWidth / 2;
        p.addPoint(point.x - hw, point.y - hw);
        p.addPoint(point.x + hw, point.y - hw);
        p.addPoint(point.x + hw, point.y + hw);
        p.addPoint(point.x - hw, point.y + hw);
        shapes.add(p);
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
                        ManualBoxCountAnnotation annotation = new ManualBoxCountAnnotation(ra);
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
                    ManualBoxCountAnnotation annotation = (ManualBoxCountAnnotation) list.getModel().getElementAt(i);
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
                    ManualBoxCountAnnotation annotation = new ManualBoxCountAnnotation(ra);
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
        return "Manual Box Count";
    }

    @Override
    protected JButton getBtnStatistics() {
        return btnShowStatistics;
    }


    class ManualBoxCountAnnotation extends ManualClassSpotAnnotation {
        public ManualBoxCountAnnotation() {
            super();
        }

        public ManualBoxCountAnnotation(RawAnnotation ra) throws IOException, ClassNotFoundException {
            super(ra);
        }

        public ManualBoxCountAnnotation(String text, ClassShape shape) {
            super(text, shape);
        }

        private static final long serialVersionUID = 1L;

        @Override
        public int getSpotType() {
            return SPOT_TYPE_BOXCOUNT;
        }
    }

}
