package com.actelion.research.orbit.imageAnalysis.TMA;

import com.actelion.research.orbit.beans.RawAnnotation;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.beans.RawMeta;
import com.actelion.research.orbit.dal.IImageProvider;
import com.actelion.research.orbit.imageAnalysis.TMA.TMAData.Spot;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.Arc2DExt;
import com.actelion.research.orbit.imageAnalysis.models.ImageAnnotation;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.utils.TiledImagePainter;
import com.actelion.research.orbit.utils.RawUtilsCommon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class DetectSpotsGUI extends JPanel {

    // Define UI elements
    final JSpinner inputNumRows = new JSpinner(new SpinnerNumberModel(5, 1, 50, 1));
    final JSpinner inputNumCols = new JSpinner(new SpinnerNumberModel(8, 1, 50, 1));

    final JButton buttonProcess = new JButton("(Re-)Process current slide");

    final JRadioButton checkOriginalImageRB = new JRadioButton("Show Original Image");
    final JRadioButton checkMaskRB = new JRadioButton("Show Mask");
    final JRadioButton cleanMaskRB = new JRadioButton("Show Clean Mask");
    final JRadioButton showGridRB = new JRadioButton("Show Grid");
    final JRadioButton showRoiRB = new JRadioButton("Show Circles");
    final ButtonGroup imageSettings = new ButtonGroup();

    final JSpinner inputBlobMin = new JSpinner(new SpinnerNumberModel(25, 1, 100, 1));
    final JSpinner inputBlobMax = new JSpinner(new SpinnerNumberModel(90, 1, 10000, 1));
    final JSpinner inputRoiSize = new JSpinner(new SpinnerNumberModel(70, 1, 10000, 1));


    final JButton publishAnnotation = new JButton(("Publish annotations to server"));

    private final JLabel labelPublishSuccessful = new JLabel();

    // Images
    final JLabel preview = new JLabel();
    final JLabel statusLabel = new JLabel("Loading Images...", JLabel.CENTER);

    TMAData currentProcessedData = null;
    final List<TMAData> processedDataList = new CopyOnWriteArrayList<>();
    Boolean firstImage = true;
    int currentImageIndex = 0;
    int totalProcessedImages = 0;

    List<RawDataFile> rdfList;

    final JButton buttonPrev = new JButton("Previous Slide");
    final JLabel imageNum = new JLabel(String.format("%d of %d", currentImageIndex, totalProcessedImages));
    final JButton buttonNext = new JButton("Next Slide");

    public DetectSpotsGUI(List<RawDataFile> rdfList) {
        this();
        this.rdfList = rdfList;
        statusLabel.setText(String.format("Loading %d images...", rdfList.size()));
    }

    public DetectSpotsGUI() {
        super(new BorderLayout());

        final GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        JPanel parameterPanel = new JPanel(new GridBagLayout());

        int rightCol = 2;

        // Slide configuration settings.
        JPanel slideConfigurationPanel = new JPanel();
        slideConfigurationPanel.setBorder(BorderFactory.createTitledBorder("Slide configuration"));

        slideConfigurationPanel.add(new JLabel("Number of rows: "));
        slideConfigurationPanel.add(inputNumRows);
        slideConfigurationPanel.add(new JLabel("Number of columns: "));
        slideConfigurationPanel.add(inputNumCols);

        constraints.gridx = rightCol;
        constraints.gridy = 0;
        parameterPanel.add(slideConfigurationPanel, constraints);

        // Algorithm settings
        JPanel algorithmSettingsPanel = new JPanel();
        algorithmSettingsPanel.setBorder(BorderFactory.createTitledBorder("Blob detection settings"));
        algorithmSettingsPanel.add(new JLabel("Minimum blob size: "), constraints);
        algorithmSettingsPanel.add(inputBlobMin);

        algorithmSettingsPanel.add(new JLabel("Maximum blob size: "), constraints);
        algorithmSettingsPanel.add(inputBlobMax);

        algorithmSettingsPanel.add(new JLabel("ROI Diameter: "), constraints);
        algorithmSettingsPanel.add(inputRoiSize);

        constraints.gridx = rightCol;
        constraints.gridy++;
        parameterPanel.add(algorithmSettingsPanel, constraints);

        // The 'Process' button.
        constraints.gridx = rightCol;
        constraints.gridy++;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        parameterPanel.add(buttonProcess, constraints);

        // Image settings.
        JPanel imageSettingsPanel = new JPanel();
        imageSettingsPanel.setBorder(BorderFactory.createTitledBorder("Image display settings"));
        imageSettings.add(checkOriginalImageRB);
        imageSettings.add(checkMaskRB);
        imageSettings.add(cleanMaskRB);
        imageSettings.add(showGridRB);
        imageSettings.add(showRoiRB);

        imageSettingsPanel.add(checkOriginalImageRB);
        imageSettingsPanel.add(checkMaskRB);
        imageSettingsPanel.add(cleanMaskRB);
        imageSettingsPanel.add(showGridRB);
        imageSettingsPanel.add(showRoiRB);

        constraints.gridx = rightCol;
        constraints.gridy++;
        parameterPanel.add(imageSettingsPanel, constraints);

        constraints.gridx = rightCol;
        constraints.gridy++;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        parameterPanel.add(publishAnnotation, constraints);

        constraints.gridx = rightCol;
        constraints.gridy++;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        parameterPanel.add(labelPublishSuccessful, constraints);

        JPanel imageNavigatorPanel = new JPanel();
        imageNavigatorPanel.setBorder(BorderFactory.createTitledBorder("Image display settings"));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        imageNavigatorPanel.add(buttonPrev, constraints);
        imageNavigatorPanel.add(imageNum, constraints);
        imageNavigatorPanel.add(buttonNext, constraints);


        buttonPrev.setEnabled(false);
        buttonNext.setEnabled(false);
        parameterPanel.add(imageNavigatorPanel, constraints);


        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 5;

        // Images...
        parameterPanel.add(statusLabel, constraints);

        /*
         * Background task for loading images. Note that the SwingWorker method
         * can only be invoked once.
         */
        SwingWorker<Void, TMAData> loadimages = new SwingWorker<Void, TMAData>() {
            @Override
            public Void doInBackground() {
                //int spotDetectionModelId = 2418098;
                //int rdfId; // = 10813162;
                OrbitModel model;
                TMAData imgdata;

                // Load a list of image files to work on.
                try {
                    model = OrbitModel.LoadFromInputStream(DetectSpotsGUI.class.getResourceAsStream("/resource/testmodels/spot-detection.omo"));
                    //model = OrbitModel.LoadFromOrbit(spotDetectionModelId);

                    for (RawDataFile rdf : rdfList) {
                        int rdfId = rdf.getRawDataFileId();

                        // Resize the image (this is slow ~10 seconds for the double size slide images (Manuel has more details...).
                        //imgdata = new TMAData(detectSpots.prepareImages(rdfId, model.clone()), rdfId);
                        imgdata = new TMAData(rdfId, model);
                        // Needed to display the clean mask.
                        imgdata.cleanMask((int) inputBlobMin.getValue(), (int) inputBlobMax.getValue());
                        // Needed to show the grid.
                        imgdata.detectSpots((int) inputRoiSize.getValue(), (int) inputNumRows.getValue(), (int) inputNumCols.getValue());
                        publish(imgdata);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                return null;
            }

            /**
             * What to do once you get a result from SwingWorker.
             */
            @Override
            protected void process(List<TMAData> chunks) {
                try {
                    //Remove the "Loading images" label.
                    // This should probably be removed from the panel instead.
                    statusLabel.setText("");

                    // Add to the list of images that have been processed.
                    processedDataList.add(chunks.get(0));
                    totalProcessedImages++;

                    // If the first image, then display something.
                    if (firstImage) {
                        currentProcessedData = chunks.get(0);
                        showRoiRB.setSelected(true);
                        //preview.setIcon(new ImageIcon(processedData.getOriginalImage()));
                        drawAnnotations(new Point2D.Double());
                        firstImage = false;
                    }

                    // Update the UI buttons.
                    updateInfoText();
                    toggleNextPrev();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        loadimages.execute();
        // Set a default buffered image to fill the space until the real image loads.
        preview.setIcon(new ImageIcon((new BufferedImage(1024, 768, 1))));
        parameterPanel.add(preview, constraints);

        // set border for the panel
        add(parameterPanel, BorderLayout.LINE_START);

        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Smart Annotation Tool"));

        checkOriginalImageRB.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (checkOriginalImageRB.isSelected()) {
                    preview.setIcon(new ImageIcon(currentProcessedData.getOriginalImage()));
                }
            }
        });

        // TODO: These could be a single AbstractAction...
        // Enable the toggle mask functionality...
        checkMaskRB.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // show the masked image
                if (checkMaskRB.isSelected())
                    preview.setIcon(new ImageIcon(currentProcessedData.getOriginalMaskedImage()));
            }
        });

        // Show how the mask is cleaned up
        cleanMaskRB.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // show the cleaned image mask
                if (cleanMaskRB.isSelected())
                    preview.setIcon(new ImageIcon(currentProcessedData.getFilteredMaskImage()));
            }
        });

        // Display the grid overlay
        showGridRB.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (showGridRB.isSelected()) drawAnnotations(new Point2D.Double());
            }
        });

        // Show the circle ROIs
        showRoiRB.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (showRoiRB.isSelected()) drawAnnotations(new Point2D.Double());
            }
        });

        publishAnnotation.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Create a default container for the annotations that we'll store.
                Arc2DExt circle = new Arc2DExt();

                // TODO: When integrating into Orbit GUI, need to use the proper user information.
                //OrbitUser ou = new OrbitUser();
                //String user = ou.getUsername();

                int imageWidth;
                // No need to close the image provider when integrating into Orbit.
                // In fact be sure to do that, since it would be bad otherwise.
                try (IImageProvider ip = DALConfig.getImageProvider()) {

                    // Calculate the scale factor to store the annotation with.
                    List<RawMeta> widths = ip.LoadRawMetasByRawDataFileAndName(currentProcessedData.getRdfId(), RawUtilsCommon.STR_META_IMAGE_IMAGEWIDTH);
                    // It's possible that the width isn't available, in which case you need to
                    // fall back and calculate it (which is probably slower).
                    if (widths.size() > 0) {
                        // Great we can get the data without needing to load the whole image.
                        String storedImageWidth = widths.get(0).getValue();
                        imageWidth = Integer.parseInt(storedImageWidth);
                    } else {
                        RawDataFile rdf = ip.LoadRawDataFile(currentProcessedData.getRdfId());
                        TiledImagePainter tip = new TiledImagePainter();
                        tip.loadImage(rdf);
                        imageWidth = tip.getImage().getWidth();
                        tip.close();
                    }
                    double scaleFactor = (100 * (double) currentProcessedData.getOriginalImage().getWidth()) / (double) imageWidth;
                    circle.setScale(scaleFactor);

                    for (Spot spot : currentProcessedData.getSpots()) {
                        Rectangle2D bounds = spot.getRoi().getBounds2D();
                        String roiLabel = spot.getName();

                        circle.setArc(bounds, 0.0, 1.0, 1);

                        ImageAnnotation annotation = new ImageAnnotation(roiLabel, circle, ImageAnnotation.SUBTYPE_ROI, Color.cyan);

                        // Convert the annotation to 'raw' for storage in the DB.
                        RawAnnotation rawAnnotation = new RawAnnotation();
                        rawAnnotation.setData(annotation.getData());
                        rawAnnotation.setDescription(annotation.getDescription());
                        rawAnnotation.setUserId("smart-annotator");
                        rawAnnotation.setModifyDate(new Date());

                        // Link the rawAnnotation to the image in the DB.
                        rawAnnotation.setRawDataFileId(currentProcessedData.getRdfId());
                        // Set the annotation type to 0 which corresponds to "Image" type.
                        rawAnnotation.setRawAnnotationType(0);

                        // Insert the annotation into the DB.
                        ip.InsertRawAnnotation(rawAnnotation);
                    }
                    labelPublishSuccessful.setText("Annotations successfully published");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        preview.addMouseMotionListener(new MouseMotionListener() {
            boolean mousePressed = false;
            int[] rowList = null;
            int[] colList = null;
            List<Spot> spots = null;

            @Override
            public void mouseMoved(MouseEvent e) {
                if (currentProcessedData == null || currentProcessedData.getSpots() == null) return;
                rowList = currentProcessedData.getRowSeperatorList();
                colList = currentProcessedData.getColSeperatorList();
                spots = currentProcessedData.getSpots();

                boolean cursorChanged = false;

                // Change the cursor if you mouse over a circle spot.
                if (currentProcessedData.getTypeCircle()) {
                    for (Spot spot : spots) {
                        Point2D center = new Point2D.Double(spot.getRoi().getBounds2D().getCenterX(), spot.getRoi().getBounds2D().getCenterY());
                        Point2D mousePosition = e.getPoint();
                        if (mousePosition.distance(center) < spot.getRoi().getBounds2D().getWidth() / 2) {
                            preview.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
                            cursorChanged = true;
                        }
                    }
                } else {
                    // Change the cursor if you mouse over a row line (rectangle)
                    for (int value : rowList) {
                        int delta = value - e.getY();
                        if (Math.abs(delta) < 10) {
                            preview.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
                            cursorChanged = true;
                        }
                    }
                    // Change the cursor if you mouse over a column line (rectangle).
                    for (int value : colList) {
                        int delta = value - e.getX();
                        if (Math.abs(delta) < 10) {
                            preview.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
                            cursorChanged = true;
                        }
                    }
                }

                if (!cursorChanged) preview.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

                if (mousePressed) {
                    preview.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                    mousePressed = false;
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (currentProcessedData == null || currentProcessedData.getSpots() == null) return;
                mousePressed = true;
                drawAnnotations(e.getPoint());
            }


        });

        buttonProcess.addActionListener(arg0 -> {
            // Re-calculate the cleaned mask
            currentProcessedData.cleanMask((int) inputBlobMin.getValue(), (int) inputBlobMax.getValue());
            // Needed to show the grid.
            currentProcessedData.detectSpots((int) inputRoiSize.getValue(), (int) inputNumRows.getValue(), (int) inputNumCols.getValue());

            // Select the circle display and draw the annotations
            showRoiRB.setSelected(true);
            drawAnnotations(new Point2D.Double());
        });


        buttonNext.addActionListener(arg0 -> {
            ListIterator<TMAData> processedIter = processedDataList.listIterator(currentImageIndex);
            if (processedIter.hasNext()) {
                processedIter.next();
                currentImageIndex = processedIter.nextIndex();
                currentProcessedData = processedIter.next();

                // Re-calculate the cleaned mask
                currentProcessedData.cleanMask((int) inputBlobMin.getValue(), (int) inputBlobMax.getValue());
                // Needed to show the grid.
                currentProcessedData.detectSpots((int) inputRoiSize.getValue(), (int) inputNumRows.getValue(), (int) inputNumCols.getValue());

                showRoiRB.setSelected(true);
                drawAnnotations(new Point2D.Double());

                updateInfoText();

            }

            toggleNextPrev();
        });

        buttonPrev.addActionListener(arg0 -> {

            ListIterator<TMAData> processedIter = processedDataList.listIterator(currentImageIndex);

            if (processedIter.hasPrevious()) {
                currentImageIndex = processedIter.previousIndex();
                currentProcessedData = processedIter.previous();

                // Re-calculate the cleaned mask
                currentProcessedData.cleanMask((int) inputBlobMin.getValue(), (int) inputBlobMax.getValue());
                // Needed to show the grid.
                currentProcessedData.detectSpots((int) inputRoiSize.getValue(), (int) inputNumRows.getValue(), (int) inputNumCols.getValue());

                showRoiRB.setSelected(true);
                drawAnnotations(new Point2D.Double());

                updateInfoText();
            }

            toggleNextPrev();
        });
    }

    private void toggleNextPrev() {
        labelPublishSuccessful.setText("");

        if (currentImageIndex == 0) {
            buttonPrev.setEnabled(false);
        } else {
            buttonPrev.setEnabled(true);
        }

        if (currentImageIndex == totalProcessedImages - 1) {
            buttonNext.setEnabled(false);
        } else {
            buttonNext.setEnabled(true);
        }
    }

    private void updateInfoText() {
        imageNum.setText(String.format("%d of %d (RDFID: %s)", currentImageIndex + 1, totalProcessedImages, currentProcessedData.getRdfId()));
    }

    private void drawAnnotations(Point2D mousePosition) {

        int[] rowList = currentProcessedData.getRowSeperatorList();
        int[] colList = currentProcessedData.getColSeperatorList();
        List<Spot> spots = currentProcessedData.getSpots();

        BufferedImage bim;
        int x = (int) mousePosition.getX();
        int y = (int) mousePosition.getY();

        if (!showGridRB.isSelected()) {
            ListIterator<Spot> it = spots.listIterator();
            while (it.hasNext()) {
                Spot spot = it.next();
                Point2D center = new Point2D.Double(spot.getRoi().getBounds2D().getCenterX(), spot.getRoi().getBounds2D().getCenterY());

                if (mousePosition.distance(center) < spot.getRoi().getBounds2D().getWidth() / 2) {
                    Ellipse2D updatedRoi = new Ellipse2D.Double(mousePosition.getX() - (int) inputRoiSize.getValue() / 2.0, mousePosition.getY() - (int) inputRoiSize.getValue() / 2.0, (int) inputRoiSize.getValue(), (int) inputRoiSize.getValue());
                    Spot updatedSpot = new Spot(spot.getName(), updatedRoi);
                    it.set(updatedSpot);
                }
            }
        } else {
            for (int i = 0; i < rowList.length; i++) {
                int delta = rowList[i] - y;
                if (Math.abs(delta) < 10) {
                    bim = currentProcessedData.showHorizontalLine(y);
                    preview.setIcon(new ImageIcon(bim));
                    rowList[i] -= delta;
                }
            }

            for (int i = 0; i < colList.length; i++) {
                int delta = colList[i] - x;
                if (Math.abs(delta) < 10) {
                    bim = currentProcessedData.showVerticalLine(x);
                    preview.setIcon(new ImageIcon(bim));
                    colList[i] -= delta;
                }
            }
        }
        bim = currentProcessedData.drawSpots(showRoiRB.isSelected());
        currentProcessedData.setProcessedImage(bim);
        preview.setIcon(new ImageIcon(currentProcessedData.getProcessedImage()));
    }


    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        final JFrame frame = new JFrame("Parameters");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = null;
        try {
            newContentPane = new DetectSpotsGUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert newContentPane != null;
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(DetectSpotsGUI::createAndShowGUI);
    }
}
