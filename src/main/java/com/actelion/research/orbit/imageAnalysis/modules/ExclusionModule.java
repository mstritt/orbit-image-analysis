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

import com.actelion.research.orbit.imageAnalysis.components.*;
import com.actelion.research.orbit.imageAnalysis.components.icons.*;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.ClassShape;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.tasks.ExclusionMapGen;
import com.actelion.research.orbit.imageAnalysis.tasks.OrbitWorker;
import com.actelion.research.orbit.imageAnalysis.tasks.TrainWorker;
import com.actelion.research.orbit.imageAnalysis.utils.ClassListCellRenderer;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import org.pushingpixels.flamingo.api.common.CommandAction;
import org.pushingpixels.flamingo.api.common.RichTooltip;
import org.pushingpixels.flamingo.api.common.model.Command;
import org.pushingpixels.flamingo.api.common.model.CommandButtonPresentationModel;
import org.pushingpixels.flamingo.api.common.projection.CommandButtonProjection;
import org.pushingpixels.flamingo.api.ribbon.JRibbonBand;
import org.pushingpixels.flamingo.api.ribbon.resize.CoreRibbonResizePolicies;
import org.pushingpixels.flamingo.api.ribbon.resize.RibbonBandResizePolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import static com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis.loginOk;

public class ExclusionModule extends AbstractOrbitModule {

    private static final long serialVersionUID = 1L;
    private final static Logger logger = LoggerFactory.getLogger(ExclusionModule.class);
//    private final JButton btnSetupClasses = new JButton("Setup Classes");
//    private final JButton btnConfigureClasses = new JButton("Configure Classes");
//    private final JButton btnTrain = new JButton("Train, Set and Classify");
//    private final JButton btnLoad = new JButton(btnLoadTextLocal);
//    private final JButton btnLoadServer = new JButton(btnLoadTextServer);
//    private final JButton btnLoadExplorer = new JButton(btnLoadTextServer);
//    private final JButton btnClassify = new JButton("Classify Trained Exclusion Model");
//    private final JButton btnReset = new JButton("Reset Exclusion Model");
//    private final JButton btnHelp = new JButton("Help");
    protected final Preferences prefs = Preferences.userNodeForPackage(this.getClass());

//    public static final String btnLoadTextLocal = "Load and Set (local)";
//    public static final String btnLoadTextServer = "Load and Set (server)";
//    public static final String btnLoadTextExplorer = "Set from Model Explorer";
    private ResourceBundle resourceBundle;

    private Command setupClassesExclusionCommand;
    private Command trainSetClassifyCommand;
    private Command classifyTrainedExclusionModelCommand;
    private Command configureExclusionClassesCommand;
    // Exclusion Model Level, see section Models.
    private Command loadAndSetLocalCommand;
    private Command loadAndSetServerCommand;
    private Command setFromModelExplorerCommand;
    private Command resetExclusionModelCommand;
    private Command exclusionHelpCommand;
    
    public ExclusionModule() {
        Locale currLocale = Locale.getDefault();
        resourceBundle = ResourceBundle.getBundle("Resources", currLocale);
        this.createCommands();
//        btnSetupClasses.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                setupClasses();
//            }
//        });
//
//        btnConfigureClasses.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                configureClasses();
//            }
//        });
//
//        btnTrain.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                trainSetAndClassifyExcl();
//            }
//        });
//
//        btnClassify.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                classifyExcl();
//            }
//        });
//
//        btnReset.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                resetModel();
//            }
//        });
//
//        btnLoad.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                loadModel();
//            }
//        });
//
//        btnLoadServer.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                loadModelServer();
//            }
//        });
//
//        btnLoadExplorer.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                loadModelExplorer();
//            }
//        });
//
//        btnHelp.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                showHelp();
//            }
//        });
//
//        setLayout(new GridLayout(7, 1));
//        add(btnSetupClasses);
//        add(btnConfigureClasses);
//        add(btnTrain);
//        add(btnLoad);
//        add(btnClassify);
//        add(btnReset);
//        add(btnHelp);
    }

    // TODO: Something different happening here... Need to figure out how best to tie in with ExclusionModule.java
    public final CommandAction SetupClassesExclusionCommandAction = e -> this.setupClasses();
    public final CommandAction TrainSetClassifyCommandAction = e -> this.trainSetAndClassifyExcl();
    public final CommandAction ClassifyTrainedExclusionModelCommandAction = e -> this.classifyExcl();
    public final CommandAction ConfigureExclusionClassesCommandAction = e -> this.configureClasses();
    public final CommandAction LoadAndSetLocalCommandAction = e -> this.loadModel();
    public final CommandAction LoadAndSetServerCommandAction = e -> this.loadModelServer();
    public final CommandAction SetFromModelExplorerCommandAction = e -> this.loadModelExplorer();
    public final CommandAction ResetExclusionModelCommandAction = e -> this.resetModel();
    public final CommandAction ExclusionHelpCommandAction = e -> this.showHelp();

    private void createCommands() {
        this.setupClassesExclusionCommand = Command.builder()
                .setText(resourceBundle.getString("ExclusionModel.Setup.setupClasses.text"))
                .setIconFactory(system_run_5.factory())
                .setAction(this.SetupClassesExclusionCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("ExclusionModel.Setup.setupClasses.text"))
                                .addDescriptionSection(resourceBundle.getString("ExclusionModel.Setup.setupClasses.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("ExclusionModel.Setup.setupClasses.tooltip.actionParagraph2"))
                                .build())
                .build();

        this.trainSetClassifyCommand = Command.builder()
                .setText(resourceBundle.getString("ExclusionModel.Exclusion.trainSetClassify.text"))
                .setIconFactory(trainSetClassify.factory())
                .setAction(this.TrainSetClassifyCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("ExclusionModel.Exclusion.trainSetClassify.text"))
                                .addDescriptionSection(resourceBundle
                                        .getString("ExclusionModel.Exclusion.trainSetClassify.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle
                                        .getString("ExclusionModel.Exclusion.trainSetClassify.tooltip.actionParagraph2"))
                                .build())
                .build();

        this.classifyTrainedExclusionModelCommand = Command.builder()
                .setText(resourceBundle.getString("ExclusionModel.Exclusion.classifyExclusionModel.text"))
                .setIconFactory(applications_graphics_2.factory())
                .setAction(this.ClassifyTrainedExclusionModelCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle
                                        .getString("ExclusionModel.Exclusion.classifyExclusionModel.tooltip.text"))
                                .addDescriptionSection(resourceBundle
                                        .getString("ExclusionModel.Exclusion.classifyExclusionModel.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle
                                        .getString("ExclusionModel.Exclusion.classifyExclusionModel.tooltip.actionParagraph2"))
                                .build())
                .build();

        this.configureExclusionClassesCommand = Command.builder()
                .setText(resourceBundle.getString("ExclusionModel.Exclusion.configureExclusionClasses.text"))
                .setIconFactory(configure_4.factory())
                .setAction(this.ConfigureExclusionClassesCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("ExclusionModel.Exclusion.configureExclusionClasses.text"))
                                .addDescriptionSection(resourceBundle.getString("ExclusionModel.Exclusion.configureExclusionClasses.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.loadAndSetLocalCommand = Command.builder()
                .setText(resourceBundle.getString("ExclusionModel.Exclusion.loadAndSetLocal.text"))
                .setIconFactory(document_open_5.factory())
                .setAction(this.LoadAndSetLocalCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("ExclusionModel.Exclusion.loadAndSetLocal.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("ExclusionModel.Exclusion.loadAndSetLocal.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.loadAndSetServerCommand = Command.builder()
                .setText(resourceBundle.getString("ExclusionModel.Exclusion.loadAndSetServer.text"))
                .setIconFactory(document_open_5.factory())
                .setAction(this.LoadAndSetServerCommandAction)
                .setActionEnabled(!DALConfig.isLocalImageProvider())
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("ExclusionModel.Exclusion.loadAndSetServer.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("ExclusionModel.Exclusion.loadAndSetServer.actionParagraph1"))
                                .build())
                .build();

        this.setFromModelExplorerCommand = Command.builder()
                .setText(resourceBundle.getString("ExclusionModel.Exclusion.setModelExplorer.text"))
                .setIconFactory(document_open_5.factory())
                .setAction(this.SetFromModelExplorerCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("ExclusionModel.Exclusion.setModelExplorer.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("ExclusionModel.Exclusion.setModelExplorer.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.resetExclusionModelCommand = Command.builder()
                .setText(resourceBundle.getString("ExclusionModel.Exclusion.resetExclusionModel.text"))
                .setIconFactory(edit_delete_6.factory())
                .setAction(this.ResetExclusionModelCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("ExclusionModel.Exclusion.resetExclusionModel.text"))
                                .addDescriptionSection(resourceBundle.getString("ExclusionModel.Exclusion.resetExclusionModel.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.exclusionHelpCommand = Command.builder()
                .setText(resourceBundle.getString("ExclusionModel.Exclusion.exclusionHelp.text"))
                .setIconFactory(help_about_3.factory())
                .setAction(this.ExclusionHelpCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("ExclusionModel.Exclusion.exclusionHelp.text"))
                                .addDescriptionSection(resourceBundle.getString("ExclusionModel.Exclusion.exclusionHelp.tooltip.actionParagraph1"))
                                .build())
                .build();
    }

    public JRibbonBand getSetupExclusionClassesBand() {
        JRibbonBand setupClassesBand = new JRibbonBand(
                resourceBundle.getString("ExclusionModel.Setup.textBandTitle"),
                null,
                null);

        setupClassesBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("ExclusionModel.Setup.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("ExclusionModel.Setup.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> setupClassesProjection = this.setupClassesExclusionCommand.project(
                CommandButtonPresentationModel.builder().setTextClickAction().build());

        setupClassesBand.addRibbonCommand(setupClassesProjection,
                JRibbonBand.PresentationPriority.TOP);

        List<RibbonBandResizePolicy> resizePolicies = new ArrayList<>();
        resizePolicies.add(new CoreRibbonResizePolicies.Mirror(setupClassesBand));
        setupClassesBand.setResizePolicies(resizePolicies);

        return setupClassesBand;
    }

    public JRibbonBand getExclusionModelBand() {
        JRibbonBand exclusionModelBand = new JRibbonBand(
                resourceBundle.getString("ExclusionModel.Exclusion.textBandTitle"),
                null,
                null);

        exclusionModelBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("ExclusionModel.Exclusion.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("ExclusionModel.Exclusion.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> trainSetClassifyProjection = this.trainSetClassifyCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> classifyTrainedExclusionModelProjection = this.classifyTrainedExclusionModelCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> configureClassesProjection = this.configureExclusionClassesCommand.project(
                CommandButtonPresentationModel.builder().build());
//        CommandButtonProjection<Command> exclusionModelLevelProjection = this.exclusionModelLevelCommand.project(
//                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> loadAndSetLocalProjection = this.loadAndSetLocalCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> loadAndSetServerProjection = this.loadAndSetServerCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> setFromModelExplorerProjection = this.setFromModelExplorerCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> resetExclusionModelProjection = this.resetExclusionModelCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> exclusionHelpProjection = this.exclusionHelpCommand.project(
                CommandButtonPresentationModel.builder().build());

        exclusionModelBand.addRibbonCommand(trainSetClassifyProjection, JRibbonBand.PresentationPriority.TOP);
        exclusionModelBand.addRibbonCommand(classifyTrainedExclusionModelProjection, JRibbonBand.PresentationPriority.TOP);
        exclusionModelBand.addRibbonCommand(configureClassesProjection, JRibbonBand.PresentationPriority.MEDIUM);
//        exclusionModelBand.addRibbonCommand(exclusionModelLevelProjection, JRibbonBand.PresentationPriority.MEDIUM);
        exclusionModelBand.addRibbonCommand(loadAndSetLocalProjection, JRibbonBand.PresentationPriority.MEDIUM);
        exclusionModelBand.addRibbonCommand(loadAndSetServerProjection, JRibbonBand.PresentationPriority.MEDIUM);
        exclusionModelBand.addRibbonCommand(setFromModelExplorerProjection, JRibbonBand.PresentationPriority.MEDIUM);
        exclusionModelBand.addRibbonCommand(resetExclusionModelProjection, JRibbonBand.PresentationPriority.MEDIUM);
        exclusionModelBand.addRibbonCommand(exclusionHelpProjection, JRibbonBand.PresentationPriority.MEDIUM);

//        List<RibbonBandResizePolicy> resizePolicies = getGenericResizePolicy(exclusionModelBand);
//        exclusionModelBand.setResizePolicies(resizePolicies);

        return exclusionModelBand;
    }

    protected void setupClasses() {
        final OrbitImageAnalysis OIA = OrbitImageAnalysis.getInstance();
        if (JOptionPane.showConfirmDialog(OIA,
                "This will reset all current training shapes.\n" +
                        "Do you want to continue?",
                "Reset current training data?",
                JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {
            List<ClassShape> classShapes = new ArrayList<ClassShape>(4);    // define some default classes
            classShapes.add(new ClassShape("Exclusion 1", Color.yellow, ClassShape.SHAPETYPE_POLYGONEXT, ClassShape.EXCLUSION));
            classShapes.add(new ClassShape("Exclusion 2", Color.red, ClassShape.SHAPETYPE_POLYGONEXT, ClassShape.EXCLUSION));
            classShapes.add(new ClassShape("Inclusion 1", Color.green, ClassShape.SHAPETYPE_POLYGONEXT, ClassShape.INCLUSION));
            classShapes.add(new ClassShape("Inclusion 2", Color.blue, ClassShape.SHAPETYPE_POLYGONEXT, ClassShape.INCLUSION));
            for (ImageFrame iFrame : OIA.getIFrames()) {
                iFrame.recognitionFrame.setClassShapes(OrbitUtils.cloneClassShapes(classShapes));
                iFrame.recognitionFrame.setWindowSize(OIA.getModel().getFeatureDescription().getWindowSize());
                iFrame.recognitionFrame.setBoundaryClass(OIA.getModel().getBoundaryClass());
            }
            OIA.updateCcbModel(classShapes);
            //updateStatusBar();
            //OIA.getModel().setClassShapes(classShapes);
            //OIA.makeClassComboBox();
        }
    }

    private void configureClasses() {
        final OrbitImageAnalysis OIA = OrbitImageAnalysis.getInstance();
        OrbitModel exclModel = OIA.getModel().getExclusionModel();
        if (exclModel == null) {
            JOptionPane.showMessageDialog(ExclusionModule.this, "Exclusion model not available.\n" +
                    "Please train an exclusion model first.",
                    "Exclusion model not available.",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        ClassAdminFrame configFrame = new ClassAdminFrame(exclModel.getClassShapes(), new ClassListCellRenderer(), -1, false);
        configFrame.setAlwaysOnTop(true);
        configFrame.setVisible(true);
    }


    private void trainSetAndClassifyExcl() {
        final OrbitImageAnalysis OIA = OrbitImageAnalysis.getInstance();
        List<ImageFrame> lowFrames = new ArrayList<ImageFrame>();
        for (ImageFrame iFrame : OIA.getIFrames()) {
            RecognitionFrame lowResFrame = ExclusionMapGen.getExclusionMapFrame(iFrame.getRdf(), iFrame.recognitionFrame, OIA.getModel());
            double scaleFactor = lowResFrame.bimg.getWidth() / (double) iFrame.recognitionFrame.bimg.getWidth();
            logger.trace("exclusion frame / normal frame scalefactor: " + scaleFactor);
            List<ClassShape> classShapes = ClassShape.scaleShapes(iFrame.recognitionFrame.getClassShapes(), scaleFactor);
            lowResFrame.setClassShapes(classShapes);
            ImageFrame lowResIFrame = new ImageFrame(lowResFrame);
            lowFrames.add(lowResIFrame);
        }

        TrainWorker trainWorker = new TrainWorker(lowFrames, true, false, OIA.getModel());
        trainWorker.run();

        OIA.setModelAsExclusionModel(OIA.getModel(), false);
        OIA.setModifiedClassShapes(false);

        classifyExcl();
    }

    private void classifyExcl() {
        final OrbitImageAnalysis OIA = OrbitImageAnalysis.getInstance();
        final ImageFrame iFrame = OIA.getIFrame();
        if (iFrame.getRdf() != null)
            iFrame.recognitionFrame.loadAnnotationROI(iFrame.getRdf().getRawDataFileId(), OIA.getModel().getAnnotationGroup());
        final ExclusionMapGen exMapGen = ExclusionMapGen.constructExclusionMap(iFrame.getRdf(), iFrame.recognitionFrame, OIA.getModel());
        OrbitWorker worker = new OrbitWorker() {
            @Override
            protected void doWork() throws Exception {
                try {
                    logger.trace("start classifying exclusion map");
                    exMapGen.generateMap();
                    //iFrame.recognitionFrame.setExMapGen(exMapGen);
                    if (exMapGen.getClassificationImage() != null)
                        iFrame.recognitionFrame.setClassImage(exMapGen.getClassificationImage());
                    iFrame.recognitionFrame.setClassImageScale((float) (1d / exMapGen.getScaleFactor()));
                    iFrame.getOpacitySlider().setEnabled(true);
                    iFrame.repaint();
                    logger.trace("end classifying exclusion map");
                } catch (Exception e1) {
                    e1.printStackTrace();
                    logger.error("error creating the exclusion map (maybe the exclusion model is not set?): " + e1.getMessage());
                }
            }
        };
        ProgressPanel progressPanel = new ProgressPanel(OIA.getCurrentPicName(), "Excl Map Classification", worker);
        OIA.addAndExecuteTask(progressPanel);
    }


    private void resetModel() {
        final OrbitImageAnalysis OIA = OrbitImageAnalysis.getInstance();
        OIA.getModel().setExclusionModel(null);
        OIA.updateStatusBar();
    }

    private void loadModel() {
        final OrbitImageAnalysis OIA = OrbitImageAnalysis.getInstance();
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "OrbitImageAnalysis Models (*.omo)", "omo");
        fileChooser.setFileFilter(filter);
        String dir = prefs.get("OrbitImageAnalysis.OpenExclusionModelCurrentDir", null);
        if (dir != null) {
            File cd = new File(dir);
            fileChooser.setCurrentDirectory(cd);
        }
        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            prefs.put("OrbitImageAnalysis.OpenExclusionModelCurrentDir", fileChooser.getCurrentDirectory().getAbsolutePath());
            File file = fileChooser.getSelectedFile();
            OrbitModel exclModel = OrbitModel.LoadFromFile(file.getAbsolutePath());
            OIA.getModel().setExclusionModel(exclModel);
            logger.info("exclusion model loaded and set");
            OIA.updateStatusBar();
            JOptionPane.showMessageDialog(null, "Exclusion model loaded and set.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            logger.trace("load model canceled.");
        }
    }

    private void loadModelServer() {
        final OrbitImageAnalysis OIA = OrbitImageAnalysis.getInstance();
        OrbitModel exclModel = null;
        ModelBrowser modelBrowser = new ModelBrowser();
        try {
            OIA.forceLogin();
            if (loginOk) {
                modelBrowser.showModelBrowser(OIA, OIA.loginUser,false);  // modal
                exclModel = modelBrowser.getSelectedModel();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        if (exclModel!=null) {
            OIA.getModel().setExclusionModel(exclModel);
            logger.info("exclusion model loaded and set");
            OIA.updateStatusBar();
            JOptionPane.showMessageDialog(null, "Exclusion model loaded and set.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            logger.trace("load model canceled.");
        }
    }

    private void loadModelExplorer() {
        final OrbitImageAnalysis OIA = OrbitImageAnalysis.getInstance();
        OrbitModel exclModel = OIA.getModelExplorer().getSelectedModel();
        if (exclModel!=null) {
            OIA.getModel().setExclusionModel(exclModel);
            logger.info("exclusion model loaded and set");
            OIA.updateStatusBar();
            JOptionPane.showMessageDialog(null, "Exclusion set.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            logger.trace("set model canceled.");
        }
    }


    @Override
    public String getName() {
        return "Exclusion Model";
    }

    @Override
    public void init() {
    }

    @Override
    public void reset() {
    }

    private void showHelp() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        String color = OrbitUtils.DARKUI ? " color=white" : "";
        String h = "<html><body" + color + ">" +
                "<h1>Exclusion Model Module</h1>" +
                "<h2>Description</h2>" +
                "An exclusion model defines exclusion and inclusion classes and can be seen as a trainable region of interest (ROI) definition. The model is used to exclude some regions from classification or segmentation. This is typically used to exclude background or artefacts like dirt or folds." +
                "<br/>Internally the model is applied to a low level resolution image to classify larger regions of a high resolution (e.g. slide) image.<br/>" +
                "<h2>How to build and use an exclusion model</h2>" +
                "<ol>" +
                "<li>Setup inclusion and exclusion classes. You might click on 'Setup classes' in this module to use a predefined class setup. You can rename the classes or select different colors if you want.</li>" +
                "<li>Configure model parameters (F3), set structure size and median filter values. For exclusion models for whole slide images a structure size between 4 and 15 is recommended.</li>" +
                "<li>Mark regions for exclusion and inclusion classes using the standard class marking tools from the main toolbar. You might skip the some exclusion or inclusion class. Hint: Set the zoom to a low level so that you have an overview of your whole image.</li>" +
                "<li>Click on 'Train, Set and Classify' and drag the classification transparency slider of your image to check the model. This step sets the exclusion model of your main (loaded or trained) model. If you save your model, the embedded exclusion model will be saved, too.</li>" +
                "<li>Mark further class regions or remove class regions using the rubber tool and repeat the last setp until you're fine with the model.</li>" +
                "<li>To apply this exclusion model to further images, use the 'classify trained exclusion model' button.</li>" +
                "<li>You can add manual exclusion or inclusion annotations with the annotation tab on the right side, which will overrule the regions defined by the exclusion model.</li>" +
                "<li>If you're fine with your exclusion model save it to disk or in Orbit if you want (optional) and continue with a normal classification model (either 'Model->Reset Training Data' to reset the class regions or clasification->setup classes which does that automatically) to define an e.g. active/non-active model.</li>" +
                "<li>Continue with a normal classification or segmentation.</li>" +
                "<li>To remove the exclusion model from the main model, click on 'Reset Exclusion Model'.</li>" +
                "<li>Hint: Often it is easier to 1) define an exclusion model, save it. 2) Creating a complete new classification or segmentation model. Finally 3) Embed the exclusion model via model->load existing exclusion model.</li>" +
                "</ol>" +
                "</body></html>";
        oia.addInternalFrame(new ResultFrame(h, "Exclusion Model Help"));
    }

//
//    public JButton getBtnClassify() {
//        return btnClassify;
//    }
//
//    public JButton getBtnConfigureClasses() {
//        return btnConfigureClasses;
//    }
//
//    public JButton getBtnHelp() {
//        return btnHelp;
//    }
//
//    public JButton getBtnLoad() {
//        return btnLoad;
//    }
//
//    public JButton getBtnLoadServer() {
//        return btnLoadServer;
//    }
//
//    public JButton getBtnLoadExplorer() {
//        return btnLoadExplorer;
//    }
//
//    public JButton getBtnReset() {
//        return btnReset;
//    }
//
//    public JButton getBtnSetupClasses() {
//        return btnSetupClasses;
//    }
//
//    public JButton getBtnTrain() {
//        return btnTrain;
//    }
}
