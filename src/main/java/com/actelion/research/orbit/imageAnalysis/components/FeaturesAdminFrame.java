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

import com.actelion.research.orbit.gui.DoubleTextField;
import com.actelion.research.orbit.gui.IntInputVerifier;
import com.actelion.research.orbit.gui.IntegerTextField;
import com.actelion.research.orbit.imageAnalysis.components.legacy.JComboCheckBox;
import com.actelion.research.orbit.imageAnalysis.models.ClassShape;
import com.actelion.research.orbit.imageAnalysis.models.FeatureDescription;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import imageJ.Colour_Deconvolution;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class FeaturesAdminFrame extends JDialog {

    public static String FEATURES_DONE = "featuresAdminFrame.features_done";
    private static final long serialVersionUID = 1L;
    private JButton btnOK = null;
    private JTextField tfWindowSize = null;
    private JTextField tfMinSegmentationSize = null;
    private IntegerTextField tfMaxSegmentationLength = null;
    private IntegerTextField tfMaxOpenDistance = null;
    private DoubleTextField tfSegmentationScale = null;
    private JTextField tfNumBlur = null;
    private JTextField tfFixedROI = null;
    private JTextField tfROIX = null;
    private JTextField tfROIY = null;
    private JComboBox cbAnnotationROI = null;
    private JCheckBox cbRed = null;
    private JCheckBox cbGreen = null;
    private JCheckBox cbBlue = null;
    private JCheckBox cbDeactivateWatershed = null;
    private JCheckBox cbForSecondarySegmentationModel = null;
    private JCheckBox cbCytoplasmaSegmentation = null;
    private JComboCheckBox cbFeatureClasses = null;
    private final JRadioButton deconvChannel0 = new JRadioButton("Disable", true);
    private final JRadioButton deconvChannel1 = new JRadioButton("Stain 1", false);
    private final JRadioButton deconvChannel2 = new JRadioButton("Stain 2", false);
    private final JRadioButton deconvChannel3 = new JRadioButton("Comp", false);
    private JComboBox cbDeconvName = null;

    private JCheckBox cbDisableWatershed = null;
    private JCheckBox cbDoCombineCrossTiles = null;
    private JCheckBox cbDilateBeforeErode = null;
    private IntegerTextField tfNumDilate = null;
    private IntegerTextField tfNumErode = null;
    private IntegerTextField tfRemoveOutliers = null;
    private DoubleTextField tfGraphCut = null;
    private JCheckBox cbUseImageAdjustments = null;


    private int frameWidth = 600;
    private int frameHeight = 650;
    private int btnHeight = 25;
    private int selectedTab = 0;
    private FeatureDescription featureDescription = null;

    public FeaturesAdminFrame(FeatureDescription featureDescription) {
        this(featureDescription, 0);
    }

    public FeaturesAdminFrame(FeatureDescription featureDescription, int selectedTab) {
        this.featureDescription = featureDescription;
        this.selectedTab = selectedTab;
        initialize();
    }

    private void initialize() {
        this.setTitle("Feature Configuration");
        java.net.URL imgURL = this.getClass().getResource(OrbitImageAnalysis.LOGO_NAME);
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            this.setIconImage(icon.getImage());
        }
        setResizable(false);
        setSize(new Dimension(frameWidth, frameHeight));


        JTabbedPane tabs = new JTabbedPane();

        // classification

        JPanel panelClassification = new JPanel();
        panelClassification.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JLabel lab = new JLabel("Structure size:");
        panel.add(lab);
        tfWindowSize = new JTextField();
        tfWindowSize.setText(Integer.toString(featureDescription.getWindowSize()));
        tfWindowSize.setInputVerifier(new IntInputVerifier(2));
        panel.add(tfWindowSize);
        setCompBounds(panel, frameWidth - 50, 0);
        panelClassification.add(panel);

        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Median filter radius (0-5):");
        panel.add(lab);
        tfNumBlur = new JTextField();
        tfNumBlur.setText(Integer.toString(featureDescription.getNumBlur()));
        tfNumBlur.setInputVerifier(new IntInputVerifier(0, 0, 5));
        panel.add(tfNumBlur);
        setCompBounds(panel, frameWidth - 50, 0);
        panelClassification.add(panel);

        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Channels used:");
        panel.add(lab);
        JPanel colPanel = new JPanel();
        cbRed = new JCheckBox("red", !featureDescription.isSkipRed());
        cbGreen = new JCheckBox("green", !featureDescription.isSkipGreen());
        cbBlue = new JCheckBox("blue", !featureDescription.isSkipBlue());
        colPanel.add(cbRed);
        colPanel.add(cbGreen);
        colPanel.add(cbBlue);
        panel.add(colPanel);
        setCompBounds(panel, frameWidth - 50, 0);
        panelClassification.add(panel);


        cbDeconvName = new JComboBox(Colour_Deconvolution.stainings);
        cbDeconvName.setSelectedIndex(0);
        if (featureDescription.getDeconvName() != null && featureDescription.getDeconvName().length() > 0 && (!featureDescription.getDeconvName().equals(Colour_Deconvolution.DECONV_NONE)))
            setDeconvName(featureDescription.getDeconvName());

        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Color Deconvolution Setup:");
        panel.add(lab);
        panel.add(cbDeconvName);
        setCompBounds(panel, frameWidth - 50, 0);
        panelClassification.add(panel);

        deconvChannel0.setToolTipText("disable color deconvolution");
        deconvChannel1.setToolTipText("select primary staining");
        deconvChannel2.setToolTipText("select secondary staining");
        deconvChannel3.setToolTipText("select complementary color to staining 1 + staining 2");
        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Color Deconvolution Staining:");
        panel.add(lab);
        JPanel radioBtnPanel = new JPanel();
        radioBtnPanel.add(deconvChannel0);
        radioBtnPanel.add(deconvChannel1);
        radioBtnPanel.add(deconvChannel2);
        radioBtnPanel.add(deconvChannel3);
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(deconvChannel0);
        btnGroup.add(deconvChannel1);
        btnGroup.add(deconvChannel2);
        btnGroup.add(deconvChannel3);
        setDeconvChannel(featureDescription.getDeconvChannel());

        panel.add(radioBtnPanel);
        setCompBounds(panel, frameWidth - 50, 0);
        panelClassification.add(panel);


        List<String> classList = new ArrayList<String>();
        //classList.add("<ALL>");
        String selected = "";
        OrbitModel model = OrbitImageAnalysis.getInstance().getModel();
        if (model != null) {
            OrbitModel classModel = model;
            if (model.getSegmentationModel() != null) classModel = model.getSegmentationModel();
            int i = 0;
            for (ClassShape cs : classModel.getClassShapes()) {
                String cleanCS = cs.getName().replaceAll(";", ",");
                classList.add(cleanCS);
                if (featureDescription.getFeatureClasses() != null) {
                    for (int fc : featureDescription.getFeatureClasses()) {
                        if (i == fc) {
                            selected += cleanCS + "; ";
                        }
                    }
                }
                i++;
            }
        }

        cbFeatureClasses = new JComboCheckBox(classList);
        cbFeatureClasses.setText(selected);
        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("classes for retrieving features/histograms:");
        panel.add(lab);
        panel.add(cbFeatureClasses);
        setCompBounds(panel, frameWidth - 50, 0);
        panelClassification.add(panel);

        cbUseImageAdjustments = new JCheckBox("Use image adjustments *", featureDescription.isUseImageAdjustments());
        cbUseImageAdjustments.setToolTipText("load image adjustments from database before classification (brightness, contrast, gamma) - use with care!");
        setCompBounds(cbUseImageAdjustments, frameWidth, 0);
        panelClassification.add(cbUseImageAdjustments);

        JLabel imageAdjustmentWarning = new JLabel("<html><body>* If activated, image adjustments like gamma, brightness and contrast from the image<br/>adjustment panel are taken into account." +
                "<br/>Please use it with care, because it will influence the quantification results,<br/>thus you might get an unwanted bias." +
                "<br/>If you really want to use it, please double-check that the image adjustments are saved.</body></html>");
        panelClassification.add(imageAdjustmentWarning);

        tabs.add("Classification", panelClassification);


        // segmentation


        JPanel panelSegmentation = new JPanel();
        panelSegmentation.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));

        final OrbitModel modelFin = model;
        cbForSecondarySegmentationModel = new JCheckBox("Set Features for Secondary Segmentation", featureDescription.isForSecondarySegmentationModel());
        cbForSecondarySegmentationModel.setToolTipText("set the segmentation features for the secondary segmentation model");
        cbForSecondarySegmentationModel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // attention: we use always the segmentation model for feature description!!! (this might go wrong...)
                if (modelFin.getSegmentationModel() != null) {
                    FeatureDescription fd = modelFin.getSegmentationModel().getFeatureDescription();
                    if (cbForSecondarySegmentationModel.isSelected() && modelFin.getSecondarySegmentationModel() != null) {
                        fd = modelFin.getSecondarySegmentationModel().getFeatureDescription();
                    }
                    updateValues(fd);
                }
            }
        });
        setCompBounds(cbForSecondarySegmentationModel, frameWidth, 0);
        panelSegmentation.add(cbForSecondarySegmentationModel);

        cbCytoplasmaSegmentation = new JCheckBox("Cytoplasma Segmentation", featureDescription.isCytoplasmaSegmentation());
        cbCytoplasmaSegmentation.setToolTipText("performs a cytoplasma segmentation based on a nuclei staining");
        setCompBounds(cbCytoplasmaSegmentation, frameWidth, 0);
        panelSegmentation.add(cbCytoplasmaSegmentation);


        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Minimum segmentation size:");
        panel.add(lab);
        tfMinSegmentationSize = new JTextField();
        tfMinSegmentationSize.setText(Integer.toString(featureDescription.getMinSegmentationSize()));
        tfMinSegmentationSize.setInputVerifier(new IntInputVerifier(3, 1, 2000));
        tfMinSegmentationSize.setToolTipText("the minimum area (in pixel) a segmented object must have");
        panel.add(tfMinSegmentationSize);
        setCompBounds(panel, frameWidth - 50, 0);
        panelSegmentation.add(panel);

        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Maximum segmentation length:");
        panel.add(lab);
        tfMaxSegmentationLength = new IntegerTextField(featureDescription.getMaxSegmentationLength(), 500, 5, 20000);
        tfMaxSegmentationLength.setText(Integer.toString(featureDescription.getMaxSegmentationLength()));
        tfMaxSegmentationLength.setToolTipText("the maximum border path-length (in pixel) a segmented cell can have");
        tfMaxSegmentationLength.setHorizontalAlignment(JTextField.LEFT);
        panel.add(tfMaxSegmentationLength);
        setCompBounds(panel, frameWidth - 50, 0);
        panelSegmentation.add(panel);

        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Maximum open distance:");
        panel.add(lab);
        tfMaxOpenDistance = new IntegerTextField(featureDescription.getMaxOpenDistance(), 3, 0, 100);
        tfMaxOpenDistance.setText(Integer.toString(featureDescription.getMaxOpenDistance()));
        tfMaxOpenDistance.setToolTipText("maximum distance (in pixel) between start and end of the path of an object");
        tfMaxOpenDistance.setHorizontalAlignment(JTextField.LEFT);
        panel.add(tfMaxOpenDistance);
        setCompBounds(panel, frameWidth - 50, 0);
        panelSegmentation.add(panel);


        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Segmentation scale factor:");
        panel.add(lab);
        tfSegmentationScale = new DoubleTextField(1, 1, 0.1, 10);
        tfSegmentationScale.setHorizontalAlignment(JTextField.LEFT);
        tfSegmentationScale.setText(featureDescription.getSegmentationScale() + "");
        panel.add(tfSegmentationScale);
        setCompBounds(panel, frameWidth - 50, 0);
        panelSegmentation.add(panel);


        cbDisableWatershed = new JCheckBox("Disable object splitting", featureDescription.isDisableWatershed());
        cbDisableWatershed.setToolTipText("disable splitting of overlapping objects");
        setCompBounds(cbDisableWatershed, frameWidth, 0);
        panelSegmentation.add(cbDisableWatershed);

        cbDoCombineCrossTiles = new JCheckBox("Combine large connecting objects:", featureDescription.isCombineObjectsCrossTiles());
        cbDoCombineCrossTiles.setToolTipText("combine objects across tiles");
        setCompBounds(cbDoCombineCrossTiles, frameWidth, 0);
        panelSegmentation.add(cbDoCombineCrossTiles);

        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Dilate:");
        panel.add(lab);
        tfNumDilate = new IntegerTextField(featureDescription.getNumDilate(), 10, 0, 10);
        tfNumDilate.setText(Integer.toString(featureDescription.getNumDilate()));
        tfNumDilate.setToolTipText("dilate foreground before object segmentation");
        tfNumDilate.setHorizontalAlignment(JTextField.LEFT);
        panel.add(tfNumDilate);
        setCompBounds(panel, frameWidth - 50, 0);
        panelSegmentation.add(panel);

        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Erode:");
        panel.add(lab);
        tfNumErode = new IntegerTextField(featureDescription.getNumErode(), 10, 0, 10);
        tfNumErode.setText(Integer.toString(featureDescription.getNumErode()));
        tfNumErode.setToolTipText("erode foreground before object segmentation");
        tfNumErode.setHorizontalAlignment(JTextField.LEFT);
        panel.add(tfNumErode);
        setCompBounds(panel, frameWidth - 50, 0);
        panelSegmentation.add(panel);

        cbDilateBeforeErode = new JCheckBox("Dilate before erode", featureDescription.isDilateBeforeErode());
        cbDilateBeforeErode.setToolTipText("otherwise erode before dilate");
        setCompBounds(cbDilateBeforeErode, frameWidth, 0);
        panelSegmentation.add(cbDilateBeforeErode);

        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Despeckle: [0-50]");
        panel.add(lab);
        tfRemoveOutliers = new IntegerTextField(featureDescription.getRemoveOutliers(), 0, 0, 50);
        tfRemoveOutliers.setText(Integer.toString(featureDescription.getRemoveOutliers()));
        tfRemoveOutliers.setToolTipText("despeckle foerground before object segmentation (remove outliers)");
        tfRemoveOutliers.setHorizontalAlignment(JTextField.LEFT);
        panel.add(tfRemoveOutliers);
        setCompBounds(panel, frameWidth - 50, 0);
        panelSegmentation.add(panel);


        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Smooth objects (GraphCut): [0-100]");
        panel.add(lab);
        tfGraphCut = new DoubleTextField(featureDescription.getGraphCut(), 10, 0, 100);
        tfGraphCut.setText(Double.toString(featureDescription.getGraphCut()));
        tfGraphCut.setToolTipText("smooth objects and fill holes");
        tfGraphCut.setHorizontalAlignment(JTextField.LEFT);
        panel.add(tfGraphCut);
        setCompBounds(panel, frameWidth - 50, 0);
        panelSegmentation.add(panel);


        cbDeactivateWatershed = new JCheckBox("Nerve Detection Mode", featureDescription.isDeactivateWatershed());  // large object detection
        cbDeactivateWatershed.setToolTipText("activate for nerve detection (large object detection)");
        setCompBounds(cbDeactivateWatershed, frameWidth, 0);
        panelSegmentation.add(cbDeactivateWatershed);


        tabs.add("Segmentation", panelSegmentation);


        // roi

        JPanel panelROI = new JPanel();
        panelROI.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));

        List<AnnotationGroupLabel> annotationGroups = new ArrayList<AnnotationGroupLabel>(12);
        annotationGroups.add(new AnnotationGroupLabel(-1, "Ignore"));
        annotationGroups.add(new AnnotationGroupLabel(0, "All Groups"));
        for (int g = 1; g < (OrbitUtils.ANNOTATION_GROUPS + 1); g++)
            annotationGroups.add(new AnnotationGroupLabel(g, "Group " + g));
        cbAnnotationROI = new JComboBox(annotationGroups.toArray(new AnnotationGroupLabel[0]));
        cbAnnotationROI.setSelectedIndex(0);
        int groupIdx = OrbitImageAnalysis.getInstance().getModel().getAnnotationGroup() + 1; // +1 because 'ignore' is -1
        if (cbAnnotationROI.getItemCount() > groupIdx)
            cbAnnotationROI.setSelectedIndex(groupIdx);
        cbAnnotationROI.setToolTipText("Use annotations (excl/incl/ROI) to build the ROI?");

        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Use annotations as ROI:");
        panel.add(lab);
        panel.add(cbAnnotationROI);
        setCompBounds(panel, frameWidth - 50, 0);
        panelROI.add(panel);


        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Fixed circular ROI (pixel):");
        panel.add(lab);
        tfFixedROI = new JTextField();
        tfFixedROI.setText(Integer.toString(OrbitImageAnalysis.getInstance().getModel().getFixedCircularROI()));
        tfFixedROI.setInputVerifier(new IntInputVerifier(0));
        panel.add(tfFixedROI);
        setCompBounds(panel, frameWidth - 50, 0);
        panelROI.add(panel);

        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("ROI offset X:");
        panel.add(lab);
        tfROIX = new JTextField();
        tfROIX.setText(Integer.toString(OrbitImageAnalysis.getInstance().getModel().getFixedROIOffsetX()));
        tfROIX.setInputVerifier(new IntInputVerifier(0));
        panel.add(tfROIX);
        setCompBounds(panel, frameWidth - 50, 0);
        panelROI.add(panel);

        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("ROI offset Y:");
        panel.add(lab);
        tfROIY = new JTextField();
        tfROIY.setText(Integer.toString(OrbitImageAnalysis.getInstance().getModel().getFixedROIOffsetY()));
        tfROIY.setInputVerifier(new IntInputVerifier(0));
        panel.add(tfROIY);
        setCompBounds(panel, frameWidth - 50, 0);
        panelROI.add(panel);

        tabs.add("ROI", panelROI);


        setLayout(new BorderLayout());
        add(tabs, BorderLayout.CENTER);

        btnOK = new JButton("OK");
        add(btnOK, BorderLayout.SOUTH);

        tabs.setSelectedIndex(selectedTab);

        addActionListeners();

        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation((size.width - getWidth()) / 2, (size.height - getHeight()) / 2);
    }


    private void updateValues(FeatureDescription featureDescription) {
        this.featureDescription = featureDescription;
        tfWindowSize.setText(Integer.toString(featureDescription.getWindowSize()));
        tfNumBlur.setText(Integer.toString(featureDescription.getNumBlur()));
        cbRed.setSelected(!featureDescription.isSkipRed());
        cbGreen.setSelected(!featureDescription.isSkipGreen());
        cbBlue.setSelected(!featureDescription.isSkipBlue());

        cbDeconvName.setSelectedIndex(0);
        if (featureDescription.getDeconvName() != null && featureDescription.getDeconvName().length() > 0 && (!featureDescription.getDeconvName().equals(Colour_Deconvolution.DECONV_NONE)))
            setDeconvName(featureDescription.getDeconvName());

        setDeconvChannel(featureDescription.getDeconvChannel());

        List<String> classList = new ArrayList<String>();
        //classList.add("<ALL>");
        String selected = "";
        OrbitModel model = OrbitImageAnalysis.getInstance().getModel();
        if (model != null) {
            OrbitModel classModel = model;
            if (model.getSegmentationModel() != null) classModel = model.getSegmentationModel();
            if (featureDescription.isForSecondarySegmentationModel() && model.getSecondarySegmentationModel() != null)
                classModel = model.getSecondarySegmentationModel();
            int i = 0;
            for (ClassShape cs : classModel.getClassShapes()) {
                String cleanCS = cs.getName().replaceAll(";", ",");
                classList.add(cleanCS);
                if (featureDescription.getFeatureClasses() != null) {
                    for (int fc : featureDescription.getFeatureClasses()) {
                        if (i == fc) {
                            selected += cleanCS + "; ";
                        }
                    }
                }
                i++;
            }
        }

        cbFeatureClasses.setChoices(classList);
        cbFeatureClasses.setText(selected);

        cbUseImageAdjustments.setSelected(featureDescription.isUseImageAdjustments());


        // segmentation

        //cbForSecondarySegmentationModel.setSelected(featureDescription.isForSecondarySegmentationModel());
        tfMinSegmentationSize.setText(Integer.toString(featureDescription.getMinSegmentationSize()));
        tfMaxSegmentationLength.setText(Integer.toString(featureDescription.getMaxSegmentationLength()));
        tfMaxOpenDistance.setText(Integer.toString(featureDescription.getMaxOpenDistance()));
        tfSegmentationScale.setText(featureDescription.getSegmentationScale() + "");
        cbDisableWatershed.setSelected(featureDescription.isDisableWatershed());
        cbDoCombineCrossTiles.setSelected(featureDescription.isCombineObjectsCrossTiles());
        tfNumDilate.setText(Integer.toString(featureDescription.getNumDilate()));
        tfNumErode.setText(Integer.toString(featureDescription.getNumErode()));
        cbDilateBeforeErode.setSelected(featureDescription.isDilateBeforeErode());
        tfRemoveOutliers.setText(Integer.toString(featureDescription.getRemoveOutliers()));
        tfGraphCut.setText(Double.toString(featureDescription.getGraphCut()));
        cbDeactivateWatershed.setSelected(featureDescription.isDeactivateWatershed());  // large object detection


        // roi

        cbAnnotationROI.setSelectedIndex(0);
        int groupIdx = OrbitImageAnalysis.getInstance().getModel().getAnnotationGroup() + 1; // +1 because 'ignore' is -1
        if (cbAnnotationROI.getItemCount() > groupIdx)
            cbAnnotationROI.setSelectedIndex(groupIdx);


        tfFixedROI.setText(Integer.toString(OrbitImageAnalysis.getInstance().getModel().getFixedCircularROI()));
        tfROIX.setText(Integer.toString(OrbitImageAnalysis.getInstance().getModel().getFixedROIOffsetX()));
        tfROIY.setText(Integer.toString(OrbitImageAnalysis.getInstance().getModel().getFixedROIOffsetY()));
    }


    private void setCompBounds(Component comp, int width, int y) {
        comp.setMaximumSize(new Dimension(width, btnHeight));
        comp.setPreferredSize(new Dimension(width, btnHeight));
        comp.setMinimumSize(new Dimension(width, btnHeight));
        //comp.setBounds((frameWidth/3) + 200, y, comp.getWidth(), comp.getHeight());
    }


    private void addActionListeners() {
        ActionListener okAction = new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                exitProcedure();
            }
        };
        btnOK.addActionListener(okAction);

    }

    private void setDeconvChannel(int channel) {
        switch (channel) {
            case 0: {
                deconvChannel0.setSelected(true);
                break;
            }
            case 1: {
                deconvChannel1.setSelected(true);
                break;
            }
            case 2: {
                deconvChannel2.setSelected(true);
                break;
            }
            case 3: {
                deconvChannel3.setSelected(true);
                break;
            }
            default: {
                deconvChannel0.setSelected(true);
                break;
            }
        }
    }

    private int getDeconvChannel() {
        if (deconvChannel0.isSelected()) return 0;
        if (deconvChannel1.isSelected()) return 1;
        if (deconvChannel2.isSelected()) return 2;
        if (deconvChannel3.isSelected()) return 3;
        return 0;
    }

    private String getDeconvName() {
        String name = Colour_Deconvolution.DECONV_NONE;
        if (cbDeconvName.getSelectedItem() != null)
            name = (String) cbDeconvName.getSelectedItem();
        return name;
    }

    private void setDeconvName(String name) {
        cbDeconvName.setSelectedItem(name);
    }


    public void exitProcedure() {
        if (cbForSecondarySegmentationModel.isSelected() && cbCytoplasmaSegmentation.isSelected()) {
            JOptionPane.showMessageDialog(FeaturesAdminFrame.this, "Cytoplasma segmentation cannot be activated for secondary segmentation model.\nPlease select either cytoplasma segmentation or 'for secondary segmentation model', but not both.", "Secondary Segmentation model and cytoplasma segmentation cannot be used together.", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cbDoCombineCrossTiles.isSelected() && cbCytoplasmaSegmentation.isSelected()) {
            JOptionPane.showMessageDialog(FeaturesAdminFrame.this, "'Combine large connecting objects' and Cytoplasma Segmentation cannot be used together.\n(It would result in exactly one large object because all cytoplasma borders are connecting.)", "Cytoplasma Segmentation and Combine Objects active.", JOptionPane.ERROR_MESSAGE);
            return;
        }


        OrbitImageAnalysis.getInstance().getModel().setFixedCircularROI(OrbitUtils.parseInt(tfFixedROI.getText(), 0));
        OrbitImageAnalysis.getInstance().getModel().setFixedROIOffsetX(OrbitUtils.parseInt(tfROIX.getText(), 0));
        OrbitImageAnalysis.getInstance().getModel().setFixedROIOffsetY(OrbitUtils.parseInt(tfROIY.getText(), 0));
        OrbitImageAnalysis.getInstance().getModel().setAnnotationGroup(-1);
        if (cbAnnotationROI.getSelectedItem() != null) {
            OrbitImageAnalysis.getInstance().getModel().setAnnotationGroup(((AnnotationGroupLabel) cbAnnotationROI.getSelectedItem()).getNum());
        }

        int ws = Integer.parseInt(tfWindowSize.getText());
        int minSegSize = Integer.parseInt(tfMinSegmentationSize.getText());
        int numBlur = Integer.parseInt(tfNumBlur.getText());

        featureDescription.setWindowSize(ws);
        featureDescription.setMinSegmentationSize(minSegSize);
        featureDescription.setMaxSegmentationLength(tfMaxSegmentationLength.getInt());
        featureDescription.setMaxOpenDistance(tfMaxOpenDistance.getInt());
        featureDescription.setDeactivateWatershed(cbDeactivateWatershed.isSelected());
        featureDescription.setNumBlur(numBlur);
        featureDescription.setSkipRed(!cbRed.isSelected());
        featureDescription.setSkipGreen(!cbGreen.isSelected());
        featureDescription.setSkipBlue(!cbBlue.isSelected());
        featureDescription.setSegmentationScale(tfSegmentationScale.getDouble());

        List<Integer> featureClasses = new ArrayList<Integer>();
        OrbitModel model = OrbitImageAnalysis.getInstance().getModel();
        if (model != null) {
            OrbitModel classModel = model;
            if (model.getSegmentationModel() != null) classModel = model.getSegmentationModel();
            int i = 0;
            String[] selectedClasses = cbFeatureClasses.getCheckedItems();
            if (selectedClasses != null) {
                for (ClassShape cs : classModel.getClassShapes()) {
                    String cleanCS = cs.getName().replaceAll(";", ",");
                    for (String sc : selectedClasses) {
                        if (sc.equals(cleanCS)) {
                            featureClasses.add(i);
                            break;
                        }
                    }
                    i++;
                }
            }
        }
        featureDescription.setFeatureClasses(null);
        if (featureClasses.size() > 0) {
            int[] fca = new int[featureClasses.size()];
            for (int i = 0; i < featureClasses.size(); i++) {
                fca[i] = featureClasses.get(i);
            }
            featureDescription.setFeatureClasses(fca);
        }
        featureDescription.setDeconvName(getDeconvName());
        featureDescription.setDeconvChannel(getDeconvChannel());

        // v2 features
        featureDescription.setDisableWatershed(cbDisableWatershed.isSelected());
        featureDescription.setCombineObjectsCrossTiles(cbDoCombineCrossTiles.isSelected());
        featureDescription.setDilateBeforeErode(cbDilateBeforeErode.isSelected());
        featureDescription.setNumDilate(tfNumDilate.getInt());
        featureDescription.setNumErode(tfNumErode.getInt());
        featureDescription.setRemoveOutliers(tfRemoveOutliers.getInt());
        featureDescription.setGraphCut(tfGraphCut.getDouble());

        featureDescription.setUseImageAdjustments(cbUseImageAdjustments.isSelected());
        featureDescription.setForSecondarySegmentationModel(cbForSecondarySegmentationModel.isSelected());
        featureDescription.setCytoplasmaSegmentation(cbCytoplasmaSegmentation.isSelected());

        firePropertyChange(FEATURES_DONE, null, featureDescription);
        this.dispose();
    }

    public class AnnotationGroupLabel implements Serializable {
        private static final long serialVersionUID = 1L;
        private int num;
        private String name;

        public AnnotationGroupLabel(int num, String name) {
            this.num = num;
            this.name = name;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

}
