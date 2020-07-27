/*
 * Orbit, a versatile image analysis software for biological image-based quantification.
 * Copyright (C) 2009 - 2020 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.actelion.research.orbit.imageAnalysis.components;

import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.dal.IOrbitImageMultiChannel;
import com.actelion.research.orbit.gui.DoubleTextField;
import com.actelion.research.orbit.gui.IntInputVerifier;
import com.actelion.research.orbit.gui.IntegerTextField;
import com.actelion.research.orbit.imageAnalysis.components.legacy.JComboCheckBox;
import com.actelion.research.orbit.imageAnalysis.deeplearning.AbstractSegmentationSettings;
import com.actelion.research.orbit.imageAnalysis.deeplearning.DeepLabV2Resnet101.DLR101SegmentationSettings;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNSegmentationSettings;
import com.actelion.research.orbit.imageAnalysis.models.ClassShape;
import com.actelion.research.orbit.imageAnalysis.models.FeatureDescription;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImage2;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImageIOrbitImage;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import imageJ.Colour_Deconvolution;
import org.pushingpixels.neon.api.NeonCortex;
import org.pushingpixels.substance.api.SubstanceCortex;
import org.pushingpixels.substance.api.skin.GraphiteGlassSkin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.prefs.Preferences;


public class FeaturesAdminFrame extends JDialog {

    private static final Logger logger = LoggerFactory.getLogger(FeaturesAdminFrame.class);
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
    private JComboBox<? extends AnnotationGroupLabel> cbAnnotationROI = null;
    private JCheckBox cbRed = null;
    private JCheckBox cbGreen = null;
    private JCheckBox cbBlue = null;
    private JCheckBox cbNerveDetectionMode = null;
    private JCheckBox cbFilterTileEdgeShapes = null;
    private JCheckBox cbForSecondarySegmentationModel = null;
    private JCheckBox cbCytoplasmaSegmentation = null;
    private JComboCheckBox cbFeatureClasses = null;
    private JComboCheckBox cbFluoChannels = null;

    private final JRadioButton deconvChannel0 = new JRadioButton("Disable", true);
    private final JRadioButton deconvChannel1 = new JRadioButton("Stain 1", false);
    private final JRadioButton deconvChannel2 = new JRadioButton("Stain 2", false);
    private final JRadioButton deconvChannel3 = new JRadioButton("Comp", false);
    private JComboBox<? extends String> cbDeconvName = null;

    private JCheckBox cbMFS = null;
    private IntegerTextField tfMFSAlpha = null;
    private IntegerTextField tfMFSCellSize = null;

    private JCheckBox cbDeepLearning = null;
    private JTextField tfDeepLearningModelPath = null;
    private DLSegmentModelComboBoxModel dlSegmentMethodsModel = null;
    private JCheckBox cbDLStoreAnnotations = null;

    private JCheckBox cbDisableWatershed = null;
    private JCheckBox cbDoCombineCrossTiles = null;
    private JCheckBox cbDilateBeforeErode = null;
    private IntegerTextField tfNumDilate = null;
    private IntegerTextField tfNumErode = null;
    private IntegerTextField tfRemoveOutliers = null;
    private DoubleTextField tfGraphCut = null;
    private JCheckBox cbUseImageAdjustments = null;

    private final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

    private final int frameWidth = (int)(800/ NeonCortex.getScaleFactor());
    private final int frameHeight = (int)(Math.min(ge.getMaximumWindowBounds().height,800)/NeonCortex.getScaleFactor()); // 1100
    private final int btnHeight = (int)(35/NeonCortex.getScaleFactor());

    public static int selectedTab = 0;
    private FeatureDescription featureDescription;
    protected Preferences prefs = Preferences.userNodeForPackage(OrbitImageAnalysis.class);

    public FeaturesAdminFrame(FeatureDescription featureDescription) {
        this(featureDescription, -1);
    }

    public FeaturesAdminFrame(FeatureDescription featureDescription, int selectedTab) {
        this.featureDescription = featureDescription;
        if (selectedTab>=0) {
            FeaturesAdminFrame.selectedTab = selectedTab;
        }
        initialize();
    }

    private void initialize() {
        this.setTitle("Feature Configuration (F3)");
        java.net.URL imgURL = this.getClass().getResource(OrbitImageAnalysis.LOGO_NAME);
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            this.setIconImage(icon.getImage());
        }
        setResizable(false);
        setSize(new Dimension(frameWidth, frameHeight));
        setLocationRelativeTo(OrbitImageAnalysis.getInstance());


        final JTabbedPane tabs = new JTabbedPane();

        OrbitModel model = OrbitImageAnalysis.getInstance().getModel();

        // classification
        tabs.add("Classification", getClassificationJPanel(model));

        // segmentation
        tabs.add("Segmentation", getSegmentationJScrollPane(model));

        // deep learning
        tabs.add("Deep Learning", getDeepLearningJPanel());

        // roi
        tabs.add("ROI", getROIJPanel());


        // image adjustments
        tabs.add("Image Adjustments", getAdjustmentsJPanel());


        // layout
        setLayout(new BorderLayout());
        add(tabs, BorderLayout.CENTER);

        btnOK = new JButton("OK");
        add(btnOK, BorderLayout.SOUTH);

        tabs.setSelectedIndex(FeaturesAdminFrame.selectedTab);

        tabs.addChangeListener(e -> {
            logger.trace("selected tab: "+ tabs.getSelectedIndex());
            FeaturesAdminFrame.selectedTab = tabs.getSelectedIndex();
        });

        addActionListeners();
    }

    private JPanel getAdjustmentsJPanel() {
        JPanel panelImageAdjustments = new JPanel();
        panelImageAdjustments.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));

        cbUseImageAdjustments = new JCheckBox("Use image adjustments *", featureDescription.isUseImageAdjustments());
        cbUseImageAdjustments.setToolTipText("load image adjustments from database before classification (brightness, contrast, gamma) - use with care!");
        setCompBounds(cbUseImageAdjustments, frameWidth);
        panelImageAdjustments.add(cbUseImageAdjustments);

        JLabel imageAdjustmentWarning = new JLabel("<html><body>* If activated, image adjustments like gamma, brightness " +
                "and contrast from the image<br/>adjustment panel are taken into account." +
                "<br/>Please use it with care, because it will influence the quantification results,<br/>" +
                "thus you might get an unwanted bias." +
                "<br/>If you really want to use it, please double-check that the image adjustments are saved.</body></html>");
        panelImageAdjustments.add(imageAdjustmentWarning);
        return panelImageAdjustments;
    }

    private JPanel getROIJPanel() {
        JPanel panelROI = new JPanel();
        panelROI.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));

        List<AnnotationGroupLabel> annotationGroups = new ArrayList<>(12);
        annotationGroups.add(new AnnotationGroupLabel(-1, "Ignore"));
        annotationGroups.add(new AnnotationGroupLabel(0, "All Groups"));
        for (int g = 1; g < (OrbitUtils.ANNOTATION_GROUPS + 1); g++)
            annotationGroups.add(new AnnotationGroupLabel(g, "Group " + g));
        cbAnnotationROI = new JComboBox<>(annotationGroups.toArray(new AnnotationGroupLabel[0]));
        cbAnnotationROI.setSelectedIndex(0);
        int groupIdx = OrbitImageAnalysis.getInstance().getModel().getAnnotationGroup() + 1; // +1 because 'ignore' is -1
        if (cbAnnotationROI.getItemCount() > groupIdx)
            cbAnnotationROI.setSelectedIndex(groupIdx);
        cbAnnotationROI.setToolTipText("Use annotations (excl/incl/ROI) to build the ROI?");

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JLabel lab = new JLabel("Use annotations as ROI:");
        panel.add(lab);
        panel.add(cbAnnotationROI);
        setCompBounds(panel, frameWidth - 50);
        panelROI.add(panel);


        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Fixed circular ROI (pixel):");
        panel.add(lab);
        tfFixedROI = new JTextField();
        tfFixedROI.setText(Integer.toString(OrbitImageAnalysis.getInstance().getModel().getFixedCircularROI()));
        tfFixedROI.setInputVerifier(new IntInputVerifier(0));
        panel.add(tfFixedROI);
        setCompBounds(panel, frameWidth - 50);
        panelROI.add(panel);

        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("ROI offset X:");
        panel.add(lab);
        tfROIX = new JTextField();
        tfROIX.setText(Integer.toString(OrbitImageAnalysis.getInstance().getModel().getFixedROIOffsetX()));
        tfROIX.setInputVerifier(new IntInputVerifier(0));
        panel.add(tfROIX);
        setCompBounds(panel, frameWidth - 50);
        panelROI.add(panel);

        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("ROI offset Y:");
        panel.add(lab);
        tfROIY = new JTextField();
        tfROIY.setText(Integer.toString(OrbitImageAnalysis.getInstance().getModel().getFixedROIOffsetY()));
        tfROIY.setInputVerifier(new IntInputVerifier(0));
        panel.add(tfROIY);
        setCompBounds(panel, frameWidth - 50);
        panelROI.add(panel);
        return panelROI;
    }

    private JPanel getClassificationJPanel(OrbitModel model) {
        JPanel panelClassification = new JPanel();
        panelClassification.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JLabel lab = new JLabel("Structure size:");
        panel.add(lab);
        tfWindowSize = new JTextField();
        tfWindowSize.setText(Integer.toString(featureDescription.getWindowSize()));
        tfWindowSize.setInputVerifier(new IntInputVerifier(2));
        panel.add(tfWindowSize);
        setCompBounds(panel, frameWidth - 50);
        panelClassification.add(panel);

        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Median filter radius (0-5):");
        panel.add(lab);
        tfNumBlur = new JTextField();
        tfNumBlur.setText(Integer.toString(featureDescription.getNumBlur()));
        tfNumBlur.setInputVerifier(new IntInputVerifier(0, 0, 5));
        panel.add(tfNumBlur);
        setCompBounds(panel, frameWidth - 50);
        panelClassification.add(panel);

        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("RGB channels used:");
        panel.add(lab);
        JPanel colPanel = new JPanel();
        cbRed = new JCheckBox("red", !featureDescription.isSkipRed());
        cbGreen = new JCheckBox("green", !featureDescription.isSkipGreen());
        cbBlue = new JCheckBox("blue", !featureDescription.isSkipBlue());
        colPanel.add(cbRed);
        colPanel.add(cbGreen);
        colPanel.add(cbBlue);
        panel.add(colPanel);
        setCompBounds(panel, frameWidth - 50);
        panelClassification.add(panel);


        cbDeconvName = new JComboBox<>(Colour_Deconvolution.stainings);
        cbDeconvName.setSelectedIndex(0);
        if (featureDescription.getDeconvName() != null && featureDescription.getDeconvName().length() > 0 && (!featureDescription.getDeconvName().equals(Colour_Deconvolution.DECONV_NONE)))
            setDeconvName(featureDescription.getDeconvName());

        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Color Deconvolution Setup:");
        panel.add(lab);
        panel.add(cbDeconvName);
        setCompBounds(panel, frameWidth - 50);
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
        setCompBounds(panel, frameWidth - 50);
        panelClassification.add(panel);

        List<String> classList = new ArrayList<>();
        //classList.add("<ALL>");
        StringBuilder selected = new StringBuilder();
        if (model != null) {
            OrbitModel classModel = model;
            if (model.getSegmentationModel() != null) classModel = model.getSegmentationModel();
            defineFeatureClasses(featureDescription, classList, selected, classModel);
        }

        cbFeatureClasses = new JComboCheckBox(classList);
        cbFeatureClasses.setText(selected.toString());
        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Classes for retrieving features/histograms:");
        panel.add(lab);
        panel.add(cbFeatureClasses);
        setCompBounds(panel, frameWidth - 50);
        panelClassification.add(panel);


        // fluo channels
        if (featureDescription.getActiveFluoChannels()!=null) {
            setCbActiveFluoChannels(featureDescription.getActiveFluoChannels());
        }
        else {
            IOrbitImageMultiChannel multiChanImage = getOpenMultiChannelImage();
            if (multiChanImage!=null && multiChanImage.getChannelNames()!=null && multiChanImage.getChannelNames().length>0) {
                setCbActiveFluoChannels(multiChanImage.getChannelNames());
            }
        }

        if (cbFluoChannels==null)
            cbFluoChannels = new JComboCheckBox();
        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Active fluorescence channels:");
        panel.add(lab);
        panel.add(cbFluoChannels);
        setCompBounds(panel, frameWidth - 50);
        panelClassification.add(panel);

        return panelClassification;
    }

    private JScrollPane getSegmentationJScrollPane(OrbitModel model) {
        JPanel panel;
        JLabel lab;
        JPanel panelSegmentation = new JPanel();
        //panelSegmentation.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));
        panelSegmentation.setLayout(new GridLayout(-1,1));

        final OrbitModel modelFin = model;
        cbForSecondarySegmentationModel = new JCheckBox("Set Features for Secondary Segmentation", featureDescription.isForSecondarySegmentationModel());
        cbForSecondarySegmentationModel.setToolTipText("set the segmentation features for the secondary segmentation model");
        cbForSecondarySegmentationModel.addActionListener(e -> {
            // attention: we use always the segmentation model for feature description!!! (this might go wrong...)
            if (modelFin.getSegmentationModel() != null) {
                FeatureDescription fd = modelFin.getSegmentationModel().getFeatureDescription();
                if (cbForSecondarySegmentationModel.isSelected() && modelFin.getSecondarySegmentationModel() != null) {
                    fd = modelFin.getSecondarySegmentationModel().getFeatureDescription();
                }
                updateValues(fd);
            }
        });
        setCompBounds(cbForSecondarySegmentationModel, frameWidth);
        panelSegmentation.add(cbForSecondarySegmentationModel);

        cbCytoplasmaSegmentation = new JCheckBox("Cytoplasma Segmentation", featureDescription.isCytoplasmaSegmentation());
        cbCytoplasmaSegmentation.setToolTipText("performs a cytoplasma segmentation based on a nuclei staining");
        setCompBounds(cbCytoplasmaSegmentation, frameWidth);
        panelSegmentation.add(cbCytoplasmaSegmentation);


        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Minimum segmentation size:");
        panel.add(lab);
        tfMinSegmentationSize = new JTextField();
        tfMinSegmentationSize.setText(Integer.toString(featureDescription.getMinSegmentationSize()));
        tfMinSegmentationSize.setInputVerifier(new IntInputVerifier(3, 1, 2000));
        tfMinSegmentationSize.setToolTipText("the minimum area (in pixel) a segmented object must have");
        tfMinSegmentationSize.setColumns(4);
        panel.add(tfMinSegmentationSize);
        setCompBounds(panel, frameWidth - 50);
        panelSegmentation.add(panel);

        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Maximum segmentation length:");
        panel.add(lab);
        tfMaxSegmentationLength = new IntegerTextField(featureDescription.getMaxSegmentationLength(), 500, 5, 20000);
        tfMaxSegmentationLength.setText(Integer.toString(featureDescription.getMaxSegmentationLength()));
        tfMaxSegmentationLength.setToolTipText("the maximum border path-length (in pixel) a segmented cell can have");
        tfMaxSegmentationLength.setHorizontalAlignment(JTextField.LEFT);
        tfMaxSegmentationLength.setColumns(4);
        panel.add(tfMaxSegmentationLength);
        setCompBounds(panel, frameWidth - 50);
        panelSegmentation.add(panel);

        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Maximum open distance:");
        panel.add(lab);
        tfMaxOpenDistance = new IntegerTextField(featureDescription.getMaxOpenDistance(), 3, 0, 100);
        tfMaxOpenDistance.setText(Integer.toString(featureDescription.getMaxOpenDistance()));
        tfMaxOpenDistance.setToolTipText("maximum distance (in pixel) between start and end of the path of an object");
        tfMaxOpenDistance.setHorizontalAlignment(JTextField.LEFT);
        tfMaxOpenDistance.setColumns(4);
        panel.add(tfMaxOpenDistance);
        setCompBounds(panel, frameWidth - 50);
        panelSegmentation.add(panel);


        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Segmentation scale factor:");
        panel.add(lab);
        tfSegmentationScale = new DoubleTextField(1, 1, 0.1, 10);
        tfSegmentationScale.setHorizontalAlignment(JTextField.LEFT);
        tfSegmentationScale.setText(featureDescription.getSegmentationScale() + "");
        tfSegmentationScale.setColumns(4);
        panel.add(tfSegmentationScale);
        setCompBounds(panel, frameWidth - 50);
        panelSegmentation.add(panel);


        cbDisableWatershed = new JCheckBox("Disable object splitting", featureDescription.isDisableWatershed());
        cbDisableWatershed.setToolTipText("disable splitting of overlapping objects (do not apply watershed algorithm)");
        setCompBounds(cbDisableWatershed, frameWidth);
        panelSegmentation.add(cbDisableWatershed);

        cbDoCombineCrossTiles = new JCheckBox("Combine cross tile objects (slow)", featureDescription.isCombineObjectsCrossTiles());
        cbDoCombineCrossTiles.setToolTipText("combine objects across tiles");
        setCompBounds(cbDoCombineCrossTiles, frameWidth);
        panelSegmentation.add(cbDoCombineCrossTiles);

        cbFilterTileEdgeShapes = new JCheckBox("Discard tile border objects", featureDescription.isFilterTileEdgeShapes());
        cbFilterTileEdgeShapes.setToolTipText("discards objects at tile borders, e.g. objects which are divided by tiles");
        setCompBounds(cbFilterTileEdgeShapes, frameWidth);
        panelSegmentation.add(cbFilterTileEdgeShapes);


        panel = new JPanel(new GridLayout(1, 2));
        cbMFS = new JCheckBox("Mumford-Shah segmentation (cell clusters):",featureDescription.isMumfordShahSegmentation());
        cbMFS.setToolTipText("enable mumford-shah segmentation (good for cell clusters)");
        cbMFS.addActionListener(e -> {
            if (cbMFS.isSelected() && !cbDisableWatershed.isSelected()) {
                cbDisableWatershed.setSelected(true);
                JOptionPane.showMessageDialog(FeaturesAdminFrame.this,
                        "Mumford-Shah segmentation has its own object splitting algorithm, thus the additional object splitting has been disabled.\n" +
                                "However, you can enable it again in addition and try if the additional splitting (watershed algorithm) gives better results.",
                        "Additional object splitting has been disabled",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        panel.add(cbMFS);
        JPanel mfsParamPanel = new JPanel();
        mfsParamPanel.setBorder(BorderFactory.createEmptyBorder());
        JPanel mfsSizePanel = new JPanel();
        mfsSizePanel.setBorder(BorderFactory.createEmptyBorder());
        JLabel mfsSizeLabel = new JLabel("Obj size [px]");
        mfsSizeLabel.setToolTipText("Expected size of objects in pixels. Smaller values will split objects more frequently.");
        tfMFSCellSize = new IntegerTextField(18, 18, 1, 1000);
        tfMFSCellSize.setHorizontalAlignment(JTextField.LEFT);
        tfMFSCellSize.setInt(featureDescription.getMumfordShahCellSize());
        tfMFSCellSize.setColumns(3);
        mfsSizePanel.add(mfsSizeLabel);
        mfsSizePanel.add(tfMFSCellSize);
        mfsParamPanel.add(mfsSizePanel);
        JPanel mfsAlphaPanel = new JPanel();
        mfsAlphaPanel.setBorder(BorderFactory.createEmptyBorder());
        JLabel mfsAlphaLabel = new JLabel("Intens split [1-50]");
        mfsAlphaLabel.setToolTipText("Object splitting based on intensity. Smaller values will split objects more frequently.\n" +
                "Recommended range: [1,50], allowed range: [1,255].\n"+
                "This value corresponds to the alpha value of the mumford-shah functional which is responsible for the smoothing of the image.\n" +
                "Higher values will smooth the image more and thus split objects less.");
        tfMFSAlpha = new IntegerTextField(5, 5, 1, 255);
        tfMFSAlpha.setHorizontalAlignment(JTextField.LEFT);
        tfMFSAlpha.setInt(featureDescription.getMumfordShahAlpha());
        tfMFSAlpha.setColumns(3);
        mfsAlphaPanel.add(mfsAlphaLabel);
        mfsAlphaPanel.add(tfMFSAlpha);
        mfsParamPanel.add(mfsAlphaPanel);
        panel.add(mfsParamPanel);
        setCompBounds(panel, frameWidth - 50);
        panel.setPreferredSize(new Dimension((int)panel.getPreferredSize().getWidth(),(int)mfsAlphaPanel.getPreferredSize().getHeight()));
        panelSegmentation.add(panel);


        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Dilate:");
        panel.add(lab);
        tfNumDilate = new IntegerTextField(featureDescription.getNumDilate(), 10, 0, 10);
        tfNumDilate.setText(Integer.toString(featureDescription.getNumDilate()));
        tfNumDilate.setToolTipText("dilate foreground before object segmentation");
        tfNumDilate.setHorizontalAlignment(JTextField.LEFT);
        tfNumDilate.setColumns(4);
        panel.add(tfNumDilate);
        setCompBounds(panel, frameWidth - 50);
        panelSegmentation.add(panel);

        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Erode:");
        panel.add(lab);
        tfNumErode = new IntegerTextField(featureDescription.getNumErode(), 10, 0, 10);
        tfNumErode.setText(Integer.toString(featureDescription.getNumErode()));
        tfNumErode.setToolTipText("erode foreground before object segmentation");
        tfNumErode.setHorizontalAlignment(JTextField.LEFT);
        tfNumErode.setColumns(4);
        panel.add(tfNumErode);
        setCompBounds(panel, frameWidth - 50);
        panelSegmentation.add(panel);

        cbDilateBeforeErode = new JCheckBox("Dilate before erode", featureDescription.isDilateBeforeErode());
        cbDilateBeforeErode.setToolTipText("otherwise erode before dilate");
        setCompBounds(cbDilateBeforeErode, frameWidth);
        panelSegmentation.add(cbDilateBeforeErode);

        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Despeckle: [0-50]");
        panel.add(lab);
        tfRemoveOutliers = new IntegerTextField(featureDescription.getRemoveOutliers(), 0, 0, 50);
        tfRemoveOutliers.setText(Integer.toString(featureDescription.getRemoveOutliers()));
        tfRemoveOutliers.setToolTipText("despeckle foerground before object segmentation (remove outliers)");
        tfRemoveOutliers.setHorizontalAlignment(JTextField.LEFT);
        tfRemoveOutliers.setColumns(4);
        panel.add(tfRemoveOutliers);
        setCompBounds(panel, frameWidth - 50);
        panelSegmentation.add(panel);


        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Smooth objects (GraphCut): [0-100]");
        panel.add(lab);
        tfGraphCut = new DoubleTextField(featureDescription.getGraphCut(), 10, 0, 100);
        tfGraphCut.setText(Double.toString(featureDescription.getGraphCut()));
        tfGraphCut.setToolTipText("smooth objects and fill holes");
        tfGraphCut.setHorizontalAlignment(JTextField.LEFT);
        tfGraphCut.setColumns(4);
        panel.add(tfGraphCut);
        setCompBounds(panel, frameWidth - 50);
        panelSegmentation.add(panel);


        cbNerveDetectionMode = new JCheckBox("Nerve Detection Mode", featureDescription.isDeactivateWatershed());  // large object detection
        cbNerveDetectionMode.setToolTipText("activate for nerve detection (large object detection)");
        setCompBounds(cbNerveDetectionMode, frameWidth);
        panelSegmentation.add(cbNerveDetectionMode);
        setCompBounds(panelSegmentation, frameWidth-150);


        return new JScrollPane(panelSegmentation,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    }

    private JPanel getDeepLearningJPanel() {
        // Full panel for the Deep Learning settings.
        JPanel panel;
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));

        // Enable deep learning segmentation.
        cbDeepLearning = new JCheckBox("Deep Learning Segmentation", featureDescription.isDeepLearningSegmentation());  // large object detection
        cbDeepLearning.setToolTipText("Enable deep learning instance segmentation. Select a segmentation model before using it.");
        setCompBounds(cbDeepLearning, frameWidth);
        panel.add(cbDeepLearning);

        // Specify path to Deep Learning model.
        JPanel panelDeepLearning = new JPanel();
        panelDeepLearning.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));

        JLabel lab = new JLabel("Deep Learning Model Path or URL:");
        panelDeepLearning.add(lab);
        tfDeepLearningModelPath = new JTextField(featureDescription.getDeepLearningModelPath(), 15);
        tfDeepLearningModelPath.setToolTipText("can be a full path to a model file or a URL");
        tfDeepLearningModelPath.setHorizontalAlignment(JTextField.LEFT);
        panelDeepLearning.add(tfDeepLearningModelPath);
        panel.add(panelDeepLearning);

        final JButton fileSelectBtn = new JButton("browse");
        fileSelectBtn.addActionListener(chooseDLModelPath());
        panelDeepLearning.add(fileSelectBtn);
        panel.add(panelDeepLearning);

        // Options to choose a predefined model.
        JPanel panelPredefinedModel = new JPanel();
        panelPredefinedModel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));

        lab = new JLabel("Predefined Model");
        panelPredefinedModel.add(lab);

        AbstractSegmentationSettings<?>[] dLSegmentArray = getDeepLearningModels();

        dlSegmentMethodsModel =
                new DLSegmentModelComboBoxModel(dLSegmentArray);

        JComboBox<AbstractSegmentationSettings<?>> dLMethodComboBox = new JComboBox<>(dlSegmentMethodsModel);
        if (featureDescription.getDLSegment() == null) {
            dLMethodComboBox.setSelectedItem(0);
        } else {
            dLMethodComboBox.setSelectedItem(featureDescription.getDLSegment());
        }

        panelPredefinedModel.add(dLMethodComboBox);
        panel.add(panelPredefinedModel);

        // Optionally store the annotations directly.
        cbDLStoreAnnotations = new JCheckBox("Store Annotations: ",
                featureDescription.isDeepLearningStoreAnnotations());  // large object detection
        cbDLStoreAnnotations.setToolTipText("By default annotations aren't stored in the database, but displayed on " +
                "the image. It will become possible to store a selection of these annotations to the database. " +
                "For Batch computations it is necessary to check this option to store the annotations directly to the" +
                "database.");
        setCompBounds(cbDLStoreAnnotations, frameWidth);
        panel.add(cbDLStoreAnnotations);

        // Setup the options panel and return.
        setCompBounds(panel, frameWidth - 50);
        return panel;
    }

    private AbstractSegmentationSettings<?>[] getDeepLearningModels() {
        MaskRCNNSegmentationSettings nucleiSettings = new MaskRCNNSegmentationSettings(
                "Nuclei", null, "C:\\Users\\fullejo1\\Downloads\\deepretina_final.pb",
                512, 512,
                0.5f, 512, 28, 28, 2,
                "NucleiS", true,
                MaskRCNNSegmentationSettings.PostProcessMethod.STANDARD);

        MaskRCNNSegmentationSettings insulinSettings = new MaskRCNNSegmentationSettings(
                    "Pancreas Islets", null, "C:\\Users\\fullejo1\\Downloads\\insulin_009.pb",
                    512, 512,
                    16f, 10, 56, 56, 5,
                    "IsletS", true,
                    MaskRCNNSegmentationSettings.PostProcessMethod.STANDARD);
        ArrayList<Color> colors = new ArrayList<>(Arrays.asList(Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW));
        ArrayList<String> classNames = new ArrayList<>(Arrays.asList("Background", "g0", "g1", "g2", "g3"));
        try {
            insulinSettings.setCustomClassNames(colors, classNames);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Size of image to use for brain detection.
        Point brainImgDims = new Point(512, 512);
        MaskRCNNSegmentationSettings brainSettings = new MaskRCNNSegmentationSettings("Brain",
                "http://ares:8080/orbit/rdf?orbitID=19340900",
                "C:\\Users\\fullejo1\\Downloads\\finalbrainDetect2.pb", brainImgDims.x, brainImgDims.y,
                1f, 1, 28, 28, 2, "Brain",
                false, MaskRCNNSegmentationSettings.PostProcessMethod.CUSTOM);

        DLR101SegmentationSettings glomeruliSettings = new DLR101SegmentationSettings(
                "Glomeruli", null, "C:\\Users\\fullejo1\\Downloads\\glomeruli-410k.pb",
                512, 512,
                2, "Glomeruli", true);

        // Since this is a two-step method it needs a different approach...
        //MaskRCNNSegment corpus_callosum = new MaskRCNNSegment(new File("D:/deeplearning/insulin/models/insulin_009.pb"), MaskRCNNSegment.PostProcessMethod.STANDARD);

        return new AbstractSegmentationSettings<?>[]{
                nucleiSettings,
                insulinSettings,
                brainSettings,
                glomeruliSettings
        };
    }

    private ActionListener chooseDLModelPath() {
        return e -> {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "DL Segmentation Models (*.pb)", "pb");
            fileChooser.setFileFilter(filter);
            fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);

            String dir = prefs.get("OrbitImageAnalysis.OpenDeepLearningModelPath", null);
            if (dir != null) {
                File cd = new File(dir);
                fileChooser.setCurrentDirectory(cd);
            }
            int returnVal = fileChooser.showSaveDialog(FeaturesAdminFrame.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                prefs.put("OrbitImageAnalysis.OpenDeepLearningModelPath", fileChooser.getCurrentDirectory().getAbsolutePath());
                String fn = fileChooser.getSelectedFile().getAbsolutePath();
                File file = new File(fn);
                if (file.isDirectory()) return;
                tfDeepLearningModelPath.setText(file.getAbsolutePath());
            }
        };
    }

    /**
     * returns the IOrbitImageMultiChannel if an image is open and selected and a IOrbitImageMultiChannel image, null otherwise.
     */
    private IOrbitImageMultiChannel getOpenMultiChannelImage() {
        ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
        if (iFrame!=null) {
            OrbitTiledImage2 img = iFrame.recognitionFrame.bimg.getImage();
            if (img instanceof OrbitTiledImageIOrbitImage) {
                IOrbitImage oi = ((OrbitTiledImageIOrbitImage) img).getOrbitImage();
                if (oi instanceof IOrbitImageMultiChannel) {
                    return (IOrbitImageMultiChannel) oi;
                }
            }
        }
        return null;
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

        List<String> classList = new ArrayList<>();
        //classList.add("<ALL>");
        StringBuilder selected = new StringBuilder();
        OrbitModel model = OrbitImageAnalysis.getInstance().getModel();
        if (model != null) {
            OrbitModel classModel = model;
            if (model.getSegmentationModel() != null) classModel = model.getSegmentationModel();
            if (featureDescription.isForSecondarySegmentationModel() && model.getSecondarySegmentationModel() != null)
                classModel = model.getSecondarySegmentationModel();
            defineFeatureClasses(featureDescription, classList, selected, classModel);
        }

        cbFeatureClasses.setChoices(classList);
        cbFeatureClasses.setText(selected.toString());

        cbUseImageAdjustments.setSelected(featureDescription.isUseImageAdjustments());


        // segmentation

        //cbForSecondarySegmentationModel.setSelected(featureDescription.isForSecondarySegmentationModel());
        tfMinSegmentationSize.setText(Integer.toString(featureDescription.getMinSegmentationSize()));
        tfMaxSegmentationLength.setText(Integer.toString(featureDescription.getMaxSegmentationLength()));
        tfMaxOpenDistance.setText(Integer.toString(featureDescription.getMaxOpenDistance()));
        tfSegmentationScale.setText(featureDescription.getSegmentationScale() + "");
        cbDisableWatershed.setSelected(featureDescription.isDisableWatershed());
        cbDoCombineCrossTiles.setSelected(featureDescription.isCombineObjectsCrossTiles());
        cbFilterTileEdgeShapes.setSelected(featureDescription.isFilterTileEdgeShapes());
        tfNumDilate.setText(Integer.toString(featureDescription.getNumDilate()));
        tfNumErode.setText(Integer.toString(featureDescription.getNumErode()));
        cbDilateBeforeErode.setSelected(featureDescription.isDilateBeforeErode());
        tfRemoveOutliers.setText(Integer.toString(featureDescription.getRemoveOutliers()));
        tfGraphCut.setText(Double.toString(featureDescription.getGraphCut()));
        cbNerveDetectionMode.setSelected(featureDescription.isDeactivateWatershed());  // large object detection
        cbMFS.setSelected(featureDescription.isMumfordShahSegmentation());
        tfMFSAlpha.setInt(featureDescription.getMumfordShahAlpha());
        tfMFSCellSize.setInt(featureDescription.getMumfordShahCellSize());

        cbDeepLearning.setSelected(featureDescription.isDeepLearningSegmentation());
        tfDeepLearningModelPath.setText(featureDescription.getDeepLearningModelPath());
        dlSegmentMethodsModel.setSelectedItem(featureDescription.getDLSegment());

        // roi

        cbAnnotationROI.setSelectedIndex(0);
        int groupIdx = OrbitImageAnalysis.getInstance().getModel().getAnnotationGroup() + 1; // +1 because 'ignore' is -1
        if (cbAnnotationROI.getItemCount() > groupIdx)
            cbAnnotationROI.setSelectedIndex(groupIdx);


        tfFixedROI.setText(Integer.toString(OrbitImageAnalysis.getInstance().getModel().getFixedCircularROI()));
        tfROIX.setText(Integer.toString(OrbitImageAnalysis.getInstance().getModel().getFixedROIOffsetX()));
        tfROIY.setText(Integer.toString(OrbitImageAnalysis.getInstance().getModel().getFixedROIOffsetY()));

        setCbActiveFluoChannels(featureDescription.getActiveFluoChannels());
    }

    private void defineFeatureClasses(FeatureDescription featureDescription, List<String> classList, StringBuilder selected, OrbitModel classModel) {
        int i = 0;
        for (ClassShape cs : classModel.getClassShapes()) {
            String cleanCS = cs.getName().replaceAll(";", ",");
            classList.add(cleanCS);
            if (featureDescription.getFeatureClasses() != null) {
                for (int fc : featureDescription.getFeatureClasses()) {
                    if (i == fc) {
                        selected.append(cleanCS).append("; ");
                    }
                }
            }
            i++;
        }
    }


    private void setCbActiveFluoChannels(final String[] activeFluoChannels) {
        List<String> fluoChannels = new ArrayList<>();
        StringBuilder selectedChannels = new StringBuilder();
        if (activeFluoChannels!=null &&activeFluoChannels.length>0) {
            for (int i=0;i<activeFluoChannels.length; i++) {
                String channel = OrbitUtils.cleanChannelName(activeFluoChannels[i]);
                selectedChannels.append(channel);
                if (i<activeFluoChannels.length-1) selectedChannels.append("; ");
                fluoChannels.add(channel);
            }
        }
        IOrbitImageMultiChannel multiChanImage = getOpenMultiChannelImage();
        if (multiChanImage!=null && multiChanImage.getChannelNames()!=null && multiChanImage.getChannelNames().length>0) {
            for (String channel: multiChanImage.getChannelNames()) {
                channel = OrbitUtils.cleanChannelName(channel);
                if (!fluoChannels.contains(channel)) {
                    fluoChannels.add(channel);
                }
            }
        }
        if (fluoChannels.size()>0) {
            Collections.sort(fluoChannels);
        }
        else {
            selectedChannels = new StringBuilder(OrbitUtils.CHANNEL_NAME_ALL);
            fluoChannels.add(OrbitUtils.CHANNEL_NAME_ALL);
        }
        
        if (cbFluoChannels==null) {
            cbFluoChannels = new JComboCheckBox(fluoChannels);
        } else {
            cbFluoChannels.setChoices(fluoChannels);
        }
        cbFluoChannels.setText(selectedChannels.toString());
    }

    private void setCompBounds(Component comp, int width) {
        comp.setMaximumSize(new Dimension(width, btnHeight));
        comp.setPreferredSize(new Dimension(width, btnHeight));
        comp.setMinimumSize(new Dimension(width, btnHeight));
    }


    private void addActionListeners() {
        ActionListener okAction = arg0 -> exitProcedure();
        btnOK.addActionListener(okAction);

    }

    private void setDeconvChannel(int channel) {
        switch (channel) {
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
            case 0:
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
            JOptionPane.showMessageDialog(FeaturesAdminFrame.this,
                    "Cytoplasma segmentation cannot be activated for secondary segmentation model.\n" +
                            "Please select either cytoplasma segmentation or 'for secondary segmentation model', but not both.",
                    "Secondary Segmentation model and cytoplasma segmentation cannot be used together.",
                    JOptionPane.ERROR_MESSAGE);
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
        featureDescription.setDeactivateWatershed(cbNerveDetectionMode.isSelected());
        featureDescription.setNumBlur(numBlur);
        featureDescription.setSkipRed(!cbRed.isSelected());
        featureDescription.setSkipGreen(!cbGreen.isSelected());
        featureDescription.setSkipBlue(!cbBlue.isSelected());
        featureDescription.setSegmentationScale(tfSegmentationScale.getDouble());

        List<Integer> featureClasses = new ArrayList<>();
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
        featureDescription.setFilterTileEdgeShapes(cbFilterTileEdgeShapes.isSelected());
        featureDescription.setDilateBeforeErode(cbDilateBeforeErode.isSelected());
        featureDescription.setNumDilate(tfNumDilate.getInt());
        featureDescription.setNumErode(tfNumErode.getInt());
        featureDescription.setRemoveOutliers(tfRemoveOutliers.getInt());
        featureDescription.setGraphCut(tfGraphCut.getDouble());

        featureDescription.setUseImageAdjustments(cbUseImageAdjustments.isSelected());
        featureDescription.setForSecondarySegmentationModel(cbForSecondarySegmentationModel.isSelected());
        featureDescription.setCytoplasmaSegmentation(cbCytoplasmaSegmentation.isSelected());

        featureDescription.setMumfordShahSegmentation(cbMFS.isSelected());
        featureDescription.setMumfordShahAlpha(tfMFSAlpha.getInt());
        featureDescription.setMumfordShahCellSize(tfMFSCellSize.getInt());

        featureDescription.setDeepLearningSegmentation(cbDeepLearning.isSelected());
        featureDescription.setDeepLearningModelPath(tfDeepLearningModelPath.getText());

        // v3 features
        // TODO... Check this.
        featureDescription.setDLSegment(dlSegmentMethodsModel.getSelectedItem());

//        if (dlSegmentMethodsModel.getSelectedItem() != null) {
//        } else {
//            dlSegmentMethodsModel.getElementAt(0);
//        }

        featureDescription.setDeepLearningStoreAnnotations(cbDLStoreAnnotations.isSelected());

        // fluo channels
        String[] activeFluoChannels = cbFluoChannels.getCheckedItems();
        if (activeFluoChannels!=null && activeFluoChannels.length>0) {
            featureDescription.setActiveFluoChannels(activeFluoChannels);
        }

        firePropertyChange(FEATURES_DONE, null, featureDescription);
        this.dispose();
    }

    /**
     * Used to quickly test the frame layout.
     * @param args No args are required.
     */
    public static void main(String... args) {

        SwingUtilities.invokeLater(() -> {
            JDialog.setDefaultLookAndFeelDecorated(true);
            SubstanceCortex.GlobalScope.setSkin(new GraphiteGlassSkin());
            OrbitModel model = new OrbitModel();
            FeaturesAdminFrame fAFrame = new FeaturesAdminFrame(model.getFeatureDescription(), 0);
            //fAFrame.pack();
            fAFrame.setAlwaysOnTop(true);
            fAFrame.setVisible(true);
            fAFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        });
    }

    public static class AnnotationGroupLabel implements Serializable {
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

    static class DLSegmentModelComboBoxModel extends DefaultComboBoxModel<AbstractSegmentationSettings<?>> {
        public DLSegmentModelComboBoxModel(AbstractSegmentationSettings<?>[] items) {
            super(items);
        }

        @Override
        public AbstractSegmentationSettings<?> getSelectedItem() {

            return (AbstractSegmentationSettings<?>) super.getSelectedItem();
        }
    }
}
