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
import com.actelion.research.orbit.utils.RawUtilsCommon;
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

    protected final Preferences prefs = Preferences.userNodeForPackage(this.getClass());

    private final ResourceBundle resourceBundle;

    private Command setupClassesExclusionCommand;
    private Command trainSetClassifyCommand;
    private Command classifyTrainedExclusionModelCommand;
    private Command configureExclusionClassesCommand;
    private Command exclusionModelLevelCommand;
    private Command loadAndSetLocalCommand;
    private Command loadAndSetServerCommand;
    private Command setFromModelExplorerCommand;
    private Command resetExclusionModelCommand;
    private Command exclusionHelpCommand;
    
    public ExclusionModule() {
        super();
        Locale currLocale = Locale.getDefault();
        resourceBundle = ResourceBundle.getBundle("Resources", currLocale);
        this.createCommands();
    }

    // TODO: Something different happening here... Need to figure out how best to tie in with ExclusionModule.java
    final CommandAction SetupClassesExclusionCommandAction = e -> this.setupClasses();
    final CommandAction TrainSetClassifyCommandAction = e -> this.trainSetAndClassifyExcl();
    final CommandAction ClassifyTrainedExclusionModelCommandAction = e -> this.classifyExcl();
    final CommandAction ConfigureExclusionClassesCommandAction = e -> this.configureClasses();
    final CommandAction ExclusionModelLevelCommandAction = e -> this.configureExclusionModelLevel();
    final CommandAction LoadAndSetLocalCommandAction = e -> this.loadModel();
    final CommandAction LoadAndSetServerCommandAction = e -> this.loadModelServer();
    final CommandAction SetFromModelExplorerCommandAction = e -> this.loadModelExplorer();
    final CommandAction ResetExclusionModelCommandAction = e -> this.resetModel();
    final CommandAction ExclusionHelpCommandAction = e -> this.showHelp();

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

        this.exclusionModelLevelCommand = Command.builder()
                .setText(resourceBundle.getString("Model.ConfigureModel.exclusionModelLevel.text"))
                .setIconFactory(configure_4.factory())
                .setAction(this.ExclusionModelLevelCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Model.ConfigureModel.exclusionModelLevel.text"))
                                .addDescriptionSection(resourceBundle.getString("Model.ConfigureModel.exclusionModelLevel.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("Model.ConfigureModel.exclusionModelLevel.tooltip.actionParagraph2"))
                                .addDescriptionSection(resourceBundle.getString("Model.ConfigureModel.exclusionModelLevel.tooltip.actionParagraph3"))
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

        CommandButtonProjection<Command> setupClassesProjection = this.getSetupClassesExclusionCommand().project(
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

        CommandButtonProjection<Command> trainSetClassifyProjection = this.getTrainSetClassifyCommand().project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> classifyTrainedExclusionModelProjection = this.getClassifyTrainedExclusionModelCommand().project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> configureClassesProjection = this.getConfigureExclusionClassesCommand().project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> exclusionModelLevelProjection = this.getExclusionModelLevelCommand().project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> loadAndSetLocalProjection = this.getLoadAndSetLocalCommand().project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> loadAndSetServerProjection = this.getLoadAndSetServerCommand().project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> setFromModelExplorerProjection = this.getSetFromModelExplorerCommand().project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> resetExclusionModelProjection = this.getResetExclusionModelCommand().project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> exclusionHelpProjection = this.getExclusionHelpCommand().project(
                CommandButtonPresentationModel.builder().build());

        exclusionModelBand.addRibbonCommand(configureClassesProjection, JRibbonBand.PresentationPriority.TOP);
        exclusionModelBand.addRibbonCommand(exclusionModelLevelProjection, JRibbonBand.PresentationPriority.TOP);
        exclusionModelBand.addRibbonCommand(trainSetClassifyProjection, JRibbonBand.PresentationPriority.TOP);
        exclusionModelBand.addRibbonCommand(classifyTrainedExclusionModelProjection, JRibbonBand.PresentationPriority.TOP);
        exclusionModelBand.addRibbonCommand(loadAndSetLocalProjection, JRibbonBand.PresentationPriority.MEDIUM);
        exclusionModelBand.addRibbonCommand(loadAndSetServerProjection, JRibbonBand.PresentationPriority.MEDIUM);
        exclusionModelBand.addRibbonCommand(setFromModelExplorerProjection, JRibbonBand.PresentationPriority.MEDIUM);
        exclusionModelBand.addRibbonCommand(resetExclusionModelProjection, JRibbonBand.PresentationPriority.MEDIUM);
        exclusionModelBand.addRibbonCommand(exclusionHelpProjection, JRibbonBand.PresentationPriority.MEDIUM);

        List<RibbonBandResizePolicy> resizePolicies = OrbitMenu.getGenericResizePolicy(exclusionModelBand);
        exclusionModelBand.setResizePolicies(resizePolicies);

        return exclusionModelBand;
    }

    protected void setupClasses() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        if (JOptionPane.showConfirmDialog(oia,
                "This will reset all current training shapes.\n" +
                        "Do you want to continue?",
                "Reset current training data?",
                JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {
            List<ClassShape> classShapes = new ArrayList<>(4);    // define some default classes
            classShapes.add(new ClassShape("Exclusion 1", Color.yellow, ClassShape.SHAPETYPE_POLYGONEXT, ClassShape.EXCLUSION));
            classShapes.add(new ClassShape("Exclusion 2", Color.red, ClassShape.SHAPETYPE_POLYGONEXT, ClassShape.EXCLUSION));
            classShapes.add(new ClassShape("Inclusion 1", Color.green, ClassShape.SHAPETYPE_POLYGONEXT, ClassShape.INCLUSION));
            classShapes.add(new ClassShape("Inclusion 2", Color.blue, ClassShape.SHAPETYPE_POLYGONEXT, ClassShape.INCLUSION));
            for (ImageFrame iFrame : oia.getIFrames()) {
                iFrame.recognitionFrame.setClassShapes(OrbitUtils.cloneClassShapes(classShapes));
                iFrame.recognitionFrame.setWindowSize(oia.getModel().getFeatureDescription().getWindowSize());
                iFrame.recognitionFrame.setBoundaryClass(oia.getModel().getBoundaryClass());
            }
            oia.getModel().setClassShapes(classShapes);
            oia.updateCcbModel(classShapes);
            oia.updateStatusBar();
        }
    }

    private void configureClasses() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        OrbitModel exclModel = oia.getModel().getExclusionModel();
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
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        List<ImageFrame> lowFrames = new ArrayList<>();
        for (ImageFrame iFrame : oia.getIFrames()) {
            RecognitionFrame lowResFrame = ExclusionMapGen.getExclusionMapFrame(iFrame.getRdf(), iFrame.recognitionFrame, oia.getModel());
            double scaleFactor = lowResFrame.bimg.getWidth() / (double) iFrame.recognitionFrame.bimg.getWidth();
            logger.trace("exclusion frame / normal frame scale factor: " + scaleFactor);
            List<ClassShape> classShapes = ClassShape.scaleShapes(iFrame.recognitionFrame.getClassShapes(), scaleFactor);
            lowResFrame.setClassShapes(classShapes);
            ImageFrame lowResIFrame = new ImageFrame(lowResFrame);
            lowFrames.add(lowResIFrame);
        }

        TrainWorker trainWorker = new TrainWorker(lowFrames, true, false, oia.getModel());
        trainWorker.run();

        oia.setModelAsExclusionModel(oia.getModel(), false);
        oia.setModifiedClassShapes(false);

        classifyExcl();
    }

    private void classifyExcl() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        final ImageFrame iFrame = oia.getIFrame();
        if (iFrame.getRdf() != null)
            iFrame.recognitionFrame.loadAnnotationROI(iFrame.getRdf().getRawDataFileId(), oia.getModel().getAnnotationGroup());
        final ExclusionMapGen exMapGen = ExclusionMapGen.constructExclusionMap(iFrame.getRdf(), iFrame.recognitionFrame, oia.getModel());
        OrbitWorker worker = new OrbitWorker() {
            @Override
            protected void doWork() {
                try {
                    logger.trace("start classifying exclusion map");
                    exMapGen.generateMap();
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
        ProgressPanel progressPanel = new ProgressPanel(oia.getCurrentPicName(), "Excl Map Classification", worker);
        oia.addAndExecuteTask(progressPanel);
    }


    private void resetModel() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        oia.getModel().setExclusionModel(null);
        oia.updateStatusBar();
    }

    private void configureExclusionModelLevel() {
        ExclusionAdminFrame frame = new ExclusionAdminFrame(OrbitImageAnalysis.getInstance().getModel());
        RawUtilsCommon.centerComponent(frame);
        frame.setVisible(true);
    }

    private void loadModel() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
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
            oia.getModel().setExclusionModel(exclModel);
            logger.info("exclusion model loaded and set");
            oia.updateStatusBar();
            JOptionPane.showMessageDialog(null,
                    "Exclusion model loaded and set.",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            logger.trace("load model canceled.");
        }
    }

    private void loadModelServer() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        OrbitModel exclModel = null;
        ModelBrowser modelBrowser = new ModelBrowser();
        try {
            oia.forceLogin();
            if (loginOk) {
                modelBrowser.showModelBrowser(oia, OrbitImageAnalysis.loginUser,false);  // modal
                exclModel = modelBrowser.getSelectedModel();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        if (exclModel!=null) {
            oia.getModel().setExclusionModel(exclModel);
            logger.info("exclusion model loaded and set");
            oia.updateStatusBar();
            JOptionPane.showMessageDialog(null, "Exclusion model loaded and set.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            logger.trace("load model canceled.");
        }
    }

    private void loadModelExplorer() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        OrbitModel exclModel = oia.getModelExplorer().getSelectedModel();
        if (exclModel!=null) {
            oia.getModel().setExclusionModel(exclModel);
            logger.info("exclusion model loaded and set");
            oia.updateStatusBar();
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
                "An exclusion model defines exclusion and inclusion classes and can be seen as a trainable region " +
                "of interest (ROI) definition. The model is used to exclude some regions from classification or " +
                "segmentation. This is typically used to exclude background or artefacts like dirt or folds." +
                "<br/>Internally the model is applied to a low level resolution image to classify larger regions " +
                "of a high resolution (e.g. slide) image." +
                "<br/>" +
                "<h2>How to build and use an exclusion model</h2>" +
                "<ol>" +
                "<li>Setup inclusion and exclusion classes. You might click on 'Setup classes' in this module to " +
                "use a predefined class setup. You can rename the classes or select different colors if you want.</li>" +
                "<li>Configure model parameters (F3), set structure size and median filter values. For exclusion " +
                "models for whole slide images a structure size between 4 and 15 is recommended.</li>" +
                "<li>Mark regions for exclusion and inclusion classes using the standard class marking tools from " +
                "the main toolbar. You might skip the some exclusion or inclusion class. Hint: Set the zoom to a " +
                "low level so that you have an overview of your whole image.</li>" +
                "<li>Click on 'Train, Set and Classify' and drag the classification transparency slider of your " +
                "image to check the model. This step sets the exclusion model of your main (loaded or trained) " +
                "model. If you save your model, the embedded exclusion model will be saved, too.</li>" +
                "<li>Mark further class regions or remove class regions using the rubber tool and repeat the last " +
                "setup until you're fine with the model.</li>" +
                "<li>To apply this exclusion model to further images, use the 'classify trained exclusion model' " +
                "button.</li>" +
                "<li>You can add manual exclusion or inclusion annotations with the annotation tab on the right " +
                "side, which will overrule the regions defined by the exclusion model.</li>" +
                "<li>If you're fine with your exclusion model save it to disk or in Orbit if you want (optional) " +
                "and continue with a normal classification model (either 'Model->Reset Training Data' to reset " +
                "the class regions or clasification->setup classes which does that automatically) to define an e.g. " +
                "active/non-active model.</li>" +
                "<li>Continue with a normal classification or segmentation.</li>" +
                "<li>To remove the exclusion model from the main model, click on 'Reset Exclusion Model'.</li>" +
                "<li>Hint: Often it is easier to 1) define an exclusion model, save it. 2) Creating a complete " +
                "new classification or segmentation model. Finally 3) Embed the exclusion model via model->load " +
                "existing exclusion model.</li>" +
                "</ol>" +
                "</body></html>";
        oia.addInternalFrame(new ResultFrame(h, "Exclusion Model Help"));
    }

    public Command getSetupClassesExclusionCommand() {
        return setupClassesExclusionCommand;
    }

    public Command getTrainSetClassifyCommand() {
        return trainSetClassifyCommand;
    }

    public Command getClassifyTrainedExclusionModelCommand() {
        return classifyTrainedExclusionModelCommand;
    }

    public Command getConfigureExclusionClassesCommand() {
        return configureExclusionClassesCommand;
    }

    public Command getExclusionModelLevelCommand() {
        return exclusionModelLevelCommand;
    }

    public Command getLoadAndSetLocalCommand() {
        return loadAndSetLocalCommand;
    }

    public Command getLoadAndSetServerCommand() {
        return loadAndSetServerCommand;
    }

    public Command getSetFromModelExplorerCommand() {
        return setFromModelExplorerCommand;
    }

    public Command getResetExclusionModelCommand() {
        return resetExclusionModelCommand;
    }

    public Command getExclusionHelpCommand() {
        return exclusionHelpCommand;
    }

}
