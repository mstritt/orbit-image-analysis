package com.actelion.research.orbit.imageAnalysis.components;

import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.utils.ICustomMenu;
import org.pushingpixels.flamingo.api.common.CommandButtonPresentationState;
import org.pushingpixels.flamingo.api.common.RichTooltip;
import org.pushingpixels.flamingo.api.common.model.*;
import org.pushingpixels.flamingo.api.common.projection.CommandButtonProjection;
import org.pushingpixels.flamingo.api.ribbon.*;
import org.pushingpixels.flamingo.api.ribbon.projection.RibbonApplicationMenuCommandButtonProjection;
import org.pushingpixels.flamingo.api.ribbon.resize.CoreRibbonResizePolicies;
import org.pushingpixels.flamingo.api.ribbon.resize.RibbonBandResizePolicy;
import org.pushingpixels.flamingo.api.ribbon.synapse.model.ComponentPresentationModel;
import org.pushingpixels.neon.api.NeonCortex;
import org.pushingpixels.neon.api.icon.ResizableIcon;

import com.actelion.research.orbit.imageAnalysis.components.icons.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

public class OrbitMenu extends JRibbonFrame {

    private OrbitImageAnalysis oia = null;

    private final ResourceBundle resourceBundle;

    // Commands for Image tasks
    private Command openImageCommand;
    private Command overviewCommand;
    private Command openForPrintingCommand;
    private Command openSpecialResolutionCommand;
    private final CommandMenuContentModel openSpecialResolutionContentModel = new CommandMenuContentModel();
    private Command saveImageLinksCommand;
    private Command imageProviderCommand;

    // Commands for Edit tasks
    private Command copyImageCommand;
    private Command copyImageLinkCommand;
    private Command copyImageFullCommand;
    private Command pasteImageCommand;

    // Commands for Model tasks
    private Command openModelServerCommand;
    private Command openModelCommand;
    private Command restoreTrainingShapesCommand;
    private Command saveModelServerCommand;
    private Command saveModelAsCommand;
    private Command saveNestedExclusionModelCommand;
    private Command saveNestedSegmentationModelCommand;
    private Command classesCommand;
    private Command featuresCommand;
    private Command fuzzinessCommand;
    private Command performClusteringCommand;
    private Command resetMainModelCommand;
    private Command resetPrimarySegmentationModelCommand;
    private Command resetSecondarySegmentationModelCommand;
    private Command resetEntireModelCommand;

    // Commands for Exclusion Model Tasks
    // See also Exclusion module.
    private Command eraserCommand;
    private Command polygonCommand;
    private Command circleCommand;
    private Command rectangleCommand;

    // Commands for classification Tasks
    private Command setupClassesClassificationCommand;
    // Commands for Draw Tasks are defined in Exclusion Model
    private Command trainCommand;
    private Command defineRoiCommand;
    private Command classifyCommand;
    // Commands for Reset are already defined...

    // Commands for Object Detection Tasks
    private Command setupClassesObjectSegmentationCommand;
    private Command setPrimarySegmentationModelCommand;
    private Command setSecondarySegmentationModelCommand;
    // Commands for Features and Define ROI are defined in Exclusion Model and Classification
    private Command objectSegmentationCommand;
    private Command showSegmentationHeatmapCommand;
    // Commands for Reset Primary and Secondary Model are defined in Exclusion Model
    private Command setupClassesObjectClassificationCommand;
    private Command objectMarkerCommand;
    private Command trainObjectsCommand;
    // Define ROI defined in Classification
    private Command objectClassificationCommand;

    // Commands for ROI Tasks
    // Define ROI command defined in Classification
    private Command resetRoiCommand;
    private Command invertRoiCommand;
    private Command measureAreaCommand;
    private Command segmentationAsRoiCommand;
    private Command tmaRoiCommand;

    // Commands for Mask Tasks
    private Command setClassificationMaskCommand;
    private Command setSegmentationMaskCommand;
    private Command unsetMaskCommand;
    private Command configureMaskCommand;
    private Command maskToExplorerCommand;

    // Commands for Batch Tasks
    private Command localExecutionCommand;
    private Command scaleOutExecutionCommand;
    private Command roiAreaComputationCommand;
    private Command retrieveExistingResultsCommand;

    // Commands for Tools Tasks
    private Command orbitBrowserCommand;
    private Command dbCleanupCommand;
    private Command channelColorResetCommand;
    private Command saveFullImageCommand;
    private Command saveCurrentViewCommand;
    private Command saveClassificationImageCommand;
    private Command scriptEditorCommand;

    // Commands for View Tasks
    private Command tileWindowsCommand;
    private Command cascadeWindowsCommand;
    private Command minimizeWindowsCommand;
    private Command closeWindowsCommand;
    private Command showToolbarCommand;
    private Command showStatusBarCommand;
    private Command showGaugeCommand;
    private Command showLabelsCommand;
    private Command showCenterCrossCommand;
    private Command showMarkupCommand;
    private Command showSyncFramesCommand;
    private Command showPopupResultsCommand;

    // Commands for Help Tasks
    private Command orbitManualCommand;
    private Command orbitTutorialsCommand;
    private Command aboutCommand;
    private Command showLogCommand;
    private Command showLogModelCommand;

    // Taskbar commands
    private Command handToolCommand;

    // Application menu commands
    private Command loginMenuCommand;
    private Command logoutMenuCommand;

    public OrbitMenu() {
        super();

        // Set the application icon.
        this.setApplicationIcon(orbit_icon.factory());

        // Button labels
        Locale currLocale = Locale.getDefault();
        resourceBundle = ResourceBundle.getBundle("Resources", currLocale);
        setTitle(resourceBundle.getString("Frame.title"));
    }

    public OrbitMenu(OrbitImageAnalysis oia) {
        this();
        this.oia = oia;
        this.configureRibbon(oia.getRibbon());
        updateMenuImageProviderEntries();
    }

    /**
     * Set enabled/disabled state (and text label) depending on image provider used.
     */
    void updateMenuImageProviderEntries() {
        // TODO: This is useful, but feels like it should be handled by a listener...
        if (DALConfig.isLocalImageProvider()) {
            this.openImageCommand.setText(resourceBundle.getString("Image.OpenImage.Local.text"));
            this.openModelServerCommand.setActionEnabled(false);
            this.saveModelServerCommand.setActionEnabled(false);
            oia.getExclusionModule().getLoadAndSetServerCommand().setActionEnabled(false);
            this.scaleOutExecutionCommand.setActionEnabled(false);
            this.retrieveExistingResultsCommand.setActionEnabled(false);
            this.orbitBrowserCommand.setActionEnabled(false);
        } else {
            this.openImageCommand.setText(resourceBundle.getString("Image.OpenImage.Server.text"));
            this.openModelServerCommand.setActionEnabled(true);
            this.saveModelServerCommand.setActionEnabled(true);
            oia.getExclusionModule().getLoadAndSetServerCommand().setActionEnabled(true);
            this.scaleOutExecutionCommand.setActionEnabled(true);
            this.retrieveExistingResultsCommand.setActionEnabled(true);
            this.orbitBrowserCommand.setActionEnabled(true);
        }
        toggleLoginButtons();
    }

    void toggleLoginButtons() {
        if (DALConfig.isLocalImageProvider()) {
            this.loginMenuCommand.setActionEnabled(false);
            this.logoutMenuCommand.setActionEnabled(false);
        } else {
            if (OrbitImageAnalysis.loginUser.equals(OrbitImageAnalysis.GUEST_USER)) {
                this.loginMenuCommand.setActionEnabled(true);
                this.logoutMenuCommand.setActionEnabled(false);
            } else {
                this.loginMenuCommand.setActionEnabled(false);
                this.logoutMenuCommand.setText("Logout user " + OrbitImageAnalysis.loginUser);
                this.logoutMenuCommand.setActionEnabled(true);
            }

        }
    }

    /**
     * Create all commands used by the orbit menu.
     * Note that Modules are responsible for creating their own commands.
     */
    private void createCommands() {
        // Image Task Commands
        this.openImageCommand = Command.builder()
                .setText(resourceBundle.getString("Image.OpenImage.text"))
                .setIconFactory(document_open_5.factory())
                .setAction(oia.OpenImageCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Image.OpenImage.text"))
                                .addDescriptionSection(resourceBundle.getString("Image.OpenImage.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.overviewCommand = Command.builder()
                .setText(resourceBundle.getString("Image.OpenSpecial.View.text"))
                .setIconFactory(slidepreview_no_loupe_6.factory())
                .setAction(oia.OverviewCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Image.OpenSpecial.View.text"))
                                .addDescriptionSection(resourceBundle.getString("Image.OpenSpecial.View.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.openForPrintingCommand = Command.builder()
                .setText(resourceBundle.getString("Image.OpenSpecial.OpenForPrinting.text"))
                .setIconFactory(document_open_5.factory())
                .setAction(oia.OpenForPrintingCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Image.OpenSpecial.OpenForPrinting.text"))
                                .addDescriptionSection(resourceBundle.getString("Image.OpenSpecial.OpenForPrinting.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.openSpecialResolutionCommand = Command.builder()
                .setText(resourceBundle.getString("Image.OpenSpecial.OpenSpecialResolution.text"))
                .setIconFactory(document_open_5.factory())
                .setSecondaryContentModel(this.getOpenSpecialResolutionContentModel())
                .setSecondaryEnabled(false)
                .build();

        this.saveImageLinksCommand = Command.builder()
                .setText(resourceBundle.getString("Image.Save.SaveLinks.text"))
                .setIconFactory(document_save_as_3.factory())
                .setAction(oia.SaveAsOrbitFileCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Image.Save.SaveLinks.text"))
                                .addDescriptionSection(resourceBundle.getString("Image.Save.SaveLinks.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.imageProviderCommand = Command.builder()
                .setText(resourceBundle.getString("Image.ImageProvider.SwitchImageProvider.text"))
                .setIconFactory(system_run_3.factory())
                .setAction(oia.ImageProviderCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Image.ImageProvider.SwitchImageProvider.text"))
                                .addDescriptionSection(resourceBundle.getString("Image.ImageProvider.SwitchImageProvider.tooltip.actionParagraph1"))
                                .build())
                .build();

        // Edit Task Commands
        this.copyImageCommand = Command.builder()
                .setText(resourceBundle.getString("Edit.Copy.CopyImage.text"))
                .setIconFactory(edit_copy_4.factory())
                .setAction(oia.CopyImageCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Edit.Copy.CopyImage.text"))
                                .addDescriptionSection(resourceBundle.getString("Edit.Copy.CopyImage.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.copyImageLinkCommand = Command.builder()
                .setText(resourceBundle.getString("Edit.Copy.CopyImageLink.text"))
                .setIconFactory(edit_copy_4.factory())
                .setAction(oia.CopyImageLinkCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Edit.Copy.CopyImageLink.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("Edit.Copy.CopyImageLink.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.copyImageFullCommand = Command.builder()
                .setText(resourceBundle.getString("Edit.Copy.CopyImageFull.text"))
                .setIconFactory(edit_copy_4.factory())
                .setAction(oia.CopyImageFullCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Edit.Copy.CopyImageFull.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("Edit.Copy.CopyImageFull.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("Edit.Copy.CopyImageFull.tooltip.actionParagraph2"))
                                .build())
                .build();

        this.pasteImageCommand = Command.builder()
                .setText(resourceBundle.getString("Edit.Paste.Paste.text"))
                .setIconFactory(edit_paste_4.factory())
                .setAction(oia.PasteImageCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Edit.Paste.Paste.text"))
                                .addDescriptionSection(resourceBundle.getString("Edit.Paste.Paste.tooltip.actionParagraph1"))
                                .build())
                .build();

        // Model task commands
        this.openModelServerCommand = Command.builder()
                .setText(resourceBundle.getString("Model.OpenModel.OpenModelServer.text"))
                .setIconFactory(document_open_5.factory())
                .setAction(oia.OpenModelServerCommandAction)
                .setActionEnabled(!DALConfig.isLocalImageProvider())
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Model.OpenModel.OpenModelServer.text"))
                                .addDescriptionSection(resourceBundle.getString("Model.OpenModel.OpenModelServer.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.openModelCommand = Command.builder()
                .setText(resourceBundle.getString("Model.OpenModel.OpenModel.text"))
                .setIconFactory(document_open_5.factory())
                .setAction(oia.OpenModelCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Model.OpenModel.OpenModel.text"))
                                .addDescriptionSection(resourceBundle.getString("Model.OpenModel.OpenModel.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.restoreTrainingShapesCommand = Command.builder()
                .setText(resourceBundle.getString("Model.OpenModel.RestoreTrainingShapes.text"))
                .setIconFactory(restoreShapes.factory())
                .setAction(oia.RestoreTrainingShapesCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Model.OpenModel.RestoreTrainingShapes.text"))
                                .addDescriptionSection(resourceBundle.getString("Model.OpenModel.RestoreTrainingShapes.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.saveModelServerCommand = Command.builder()
                .setText(resourceBundle.getString("Model.SaveModel.saveModelServer.text"))
                .setIconFactory(document_save_3.factory())
                .setAction(oia.SaveModelServerCommandAction)
                .setActionEnabled(!DALConfig.isLocalImageProvider())
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Model.SaveModel.saveModelServer.text"))
                                .addDescriptionSection(resourceBundle.getString("Model.SaveModel.saveModelServer.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.saveModelAsCommand = Command.builder()
                .setText(resourceBundle.getString("Model.SaveModel.saveModelAs.text"))
                .setIconFactory(document_save_as_3.factory())
                .setAction(oia.SaveModelAsCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Model.SaveModel.saveModelAs.text"))
                                .addDescriptionSection(resourceBundle.getString("Model.SaveModel.saveModelAs.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.saveNestedExclusionModelCommand = Command.builder()
                .setText(resourceBundle.getString("Model.SaveModel.saveNestedExclusionModel.text"))
                .setIconFactory(document_save_as_3.factory())
                .setAction(oia.SaveNestedExclusionModelCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Model.SaveModel.saveNestedExclusionModel.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("Model.SaveModel.saveNestedExclusionModel.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.saveNestedSegmentationModelCommand = Command.builder()
                .setText(resourceBundle.getString("Model.SaveModel.saveNestedSegmentationModel.text"))
                .setIconFactory(document_save_as_3.factory())
                .setAction(oia.SaveNestedSegmentationModelCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Model.SaveModel.saveNestedSegmentationModel.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("Model.SaveModel.saveNestedSegmentationModel.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.classesCommand = Command.builder()
                .setText(resourceBundle.getString("Model.ConfigureModel.classes.text"))
                .setIconFactory(configure_4.factory())
                .setAction(oia.ClassesCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Model.ConfigureModel.classes.text"))
                                .addDescriptionSection(resourceBundle.getString("Model.ConfigureModel.classes.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.featuresCommand = Command.builder()
                .setText(resourceBundle.getString("Model.ConfigureModel.features.text"))
                .setIconFactory(preferences_desktop_2.factory())
                .setAction(oia.FeaturesCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Model.ConfigureModel.features.text"))
                                .addDescriptionSection(resourceBundle.getString("Model.ConfigureModel.features.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.fuzzinessCommand = Command.builder()
                .setText(resourceBundle.getString("Model.ConfigureModel.fuzziness.text"))
                .setIconFactory(configure_4.factory())
                .setAction(oia.FuzzinessCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Model.ConfigureModel.fuzziness.text"))
                                .addDescriptionSection(resourceBundle.getString("Model.ConfigureModel.fuzziness.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("Model.ConfigureModel.fuzziness.tooltip.actionParagraph2"))
                                .build())
                .build();

        this.performClusteringCommand = Command.builder()
                .setText(resourceBundle.getString("Model.Clustering.performClustering.text"))
                .setIconFactory(clustering.factory())
                .setAction(oia.PerformClusteringCommandAction)
                .setToggleSelected(oia.isPerformClustering())
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Model.Clustering.performClustering.text"))
                                .addDescriptionSection(resourceBundle.getString("Model.Clustering.performClustering.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.resetMainModelCommand = Command.builder()
                .setText(resourceBundle.getString("Model.Reset.resetMainModel.text"))
                .setIconFactory(edit_clear_3.factory())
                .setAction(oia.ResetMainModelCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Model.Reset.resetMainModel.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("Model.Reset.resetMainModel.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("Model.Reset.resetMainModel.tooltip.actionParagraph2"))
                                .build())
                .build();

        this.resetPrimarySegmentationModelCommand = Command.builder()
                .setText(resourceBundle.getString("Model.Reset.resetPrimarySegmentationModel.text"))
                .setIconFactory(edit_delete_6.factory())
                .setAction(oia.ResetPrimarySegmentationModelCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Model.Reset.resetPrimarySegmentationModel.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("Model.Reset.resetPrimarySegmentationModel.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.resetSecondarySegmentationModelCommand = Command.builder()
                .setText(resourceBundle.getString("Model.Reset.resetSecondarySegmentationModel.text"))
                .setIconFactory(clearSecSegModel.factory())
                .setAction(oia.ResetSecondarySegmentationModelCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Model.Reset.resetSecondarySegmentationModel.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("Model.Reset.resetSecondarySegmentationModel.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.resetEntireModelCommand = Command.builder()
                .setText(resourceBundle.getString("Model.Reset.resetEntireModel.text"))
                .setIconFactory(edit_delete_3.factory())
                .setAction(oia.ResetEntireModelCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Model.Reset.resetEntireModel.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("Model.Reset.resetEntireModel.tooltip.actionParagraph1"))
                                .build())
                .build();

        // Exclusion Model Task commands
        this.eraserCommand = Command.builder()
                .setText(resourceBundle.getString("ExclusionModel.Draw.eraser.text"))
                .setIconFactory(draw_eraser_2.factory())
                .setAction(oia.EraserCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("ExclusionModel.Draw.eraser.text"))
                                .addDescriptionSection(resourceBundle.getString("ExclusionModel.Draw.eraser.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.polygonCommand = Command.builder()
                .setText(resourceBundle.getString("ExclusionModel.Draw.polygon.text"))
                .setIconFactory(draw_poly.factory())
                .setAction(oia.PolygonCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("ExclusionModel.Draw.polygon.text"))
                                .addDescriptionSection(resourceBundle.getString("ExclusionModel.Draw.polygon.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("ExclusionModel.Draw.polygon.actionParagraph2"))
                                .build())
                .build();

        this.circleCommand = Command.builder()
                .setText(resourceBundle.getString("ExclusionModel.Draw.circle.text"))
                .setIconFactory(draw_circle.factory())
                .setAction(oia.CircleCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("ExclusionModel.Draw.circle.text"))
                                .addDescriptionSection(resourceBundle.getString("ExclusionModel.Draw.circle.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("ExclusionModel.Draw.circle.tooltip.actionParagraph2"))
                                .build())
                .build();

        this.rectangleCommand = Command.builder()
                .setText(resourceBundle.getString("ExclusionModel.Draw.rectangle.text"))
                .setIconFactory(draw_rectangle.factory())
                .setAction(oia.RectangleCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("ExclusionModel.Draw.rectangle.text"))
                                .addDescriptionSection(resourceBundle.getString("ExclusionModel.Draw.rectangle.tooltip.actionParagraph1"))
                                .build())
                .build();

        // Classification Task Commands
        this.setupClassesClassificationCommand = Command.builder()
                .setText(resourceBundle.getString("Classification.Setup.setupClasses.text"))
                .setIconFactory(system_run_5.factory())
                .setAction(oia.SetupClassesClassificationCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Classification.Setup.setupClasses.text"))
                                .addDescriptionSection(resourceBundle.getString("Classification.Setup.setupClasses.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("Classification.Setup.setupClasses.tooltip.actionParagraph2"))
                                .build())
                .build();

        this.trainCommand = Command.builder()
                .setText(resourceBundle.getString("Classification.MachineLearning.train.text"))
                .setIconFactory(training.factory())
                .setAction(oia.TrainCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Classification.MachineLearning.train.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("Classification.MachineLearning.train.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("Classification.MachineLearning.train.tooltip.actionParagraph2"))
                                .build())
                .build();

        this.defineRoiCommand = Command.builder()
                .setText(resourceBundle.getString("Classification.MachineLearning.defineRoi.text"))
                .setIconFactory(draw_roi.factory())
                .setAction(oia.DefineRoiCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Classification.MachineLearning.defineRoi.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("Classification.MachineLearning.defineRoi.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("Classification.MachineLearning.defineRoi.tooltip.actionParagraph2"))
                                .addDescriptionSection(resourceBundle.getString("Classification.MachineLearning.defineRoi.tooltip.actionParagraph3"))

                                .build())
                .build();

        this.classifyCommand = Command.builder()
                .setText(resourceBundle.getString("Classification.MachineLearning.classify.text"))
                .setIconFactory(applications_graphics_2.factory())
                .setAction(oia.ClassifyCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Classification.MachineLearning.classify.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("Classification.MachineLearning.classify.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("Classification.MachineLearning.classify.tooltip.actionParagraph2"))
                                .addDescriptionSection(resourceBundle.getString("Classification.MachineLearning.classify.tooltip.actionParagraph3"))
                                .build())
                .build();

        // Object Detection Task Commands
        this.setupClassesObjectSegmentationCommand = Command.builder()
                .setText(resourceBundle.getString("ObjectDetection.Setup.setupClasses.text"))
                .setIconFactory(system_run_5.factory())
                .setAction(oia.SetupClassesObjectSegmentationCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("ObjectDetection.Setup.setupClasses.text"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.Setup.setupClasses.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.Setup.setupClasses.tooltip.actionParagraph2"))
                                .build())
                .build();

        this.setPrimarySegmentationModelCommand = Command.builder()
                .setText(resourceBundle.getString("ObjectDetection.ObjectSegmentation.setPrimarySegmentationModel.text"))
                .setIconFactory(primarySeg.factory())
                .setAction(oia.SetPrimarySegmentationModelCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("ObjectDetection.ObjectSegmentation.setPrimarySegmentationModel.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.setPrimarySegmentationModel.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.setPrimarySegmentationModel.tooltip.actionParagraph2"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.setPrimarySegmentationModel.tooltip.actionParagraph3"))
                                .build())
                .build();

        this.setSecondarySegmentationModelCommand = Command.builder()
                .setText(resourceBundle.getString("ObjectDetection.ObjectSegmentation.setSecondarySegmentationModel.text"))
                .setIconFactory(secondarySeg.factory())
                .setAction(oia.SetSecondarySegmentationModelCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("ObjectDetection.ObjectSegmentation.setSecondarySegmentationModel.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.setSecondarySegmentationModel.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.setSecondarySegmentationModel.tooltip.actionParagraph2"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.setSecondarySegmentationModel.tooltip.actionParagraph3"))
                                .build())
                .build();

        this.objectSegmentationCommand = Command.builder()
                .setText(resourceBundle.getString("ObjectDetection.ObjectSegmentation.objectSegmentation.text"))
                .setIconFactory(segmentation.factory())
                .setAction(oia.ObjectSegmentationCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("ObjectDetection.ObjectSegmentation.objectSegmentation.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.objectSegmentation.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.objectSegmentation.tooltip.actionParagraph2"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.objectSegmentation.tooltip.actionParagraph3"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.objectSegmentation.tooltip.actionParagraph4"))
                                .build())
                .build();

        this.showSegmentationHeatmapCommand = Command.builder()
                .setText(resourceBundle.getString("ObjectDetection.ObjectSegmentation.showSegmentationHeatmap.text"))
                .setIconFactory(obj_heatmap.factory())
                .setAction(oia.ShowSegmentationHeatmapCommandAction)
                .setToggleSelected(false)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("ObjectDetection.ObjectSegmentation.showSegmentationHeatmap.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.showSegmentationHeatmap.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.showSegmentationHeatmap.tooltip.actionParagraph2"))
                                .build())
                .build();

        this.setupClassesObjectClassificationCommand = Command.builder()
                .setText(resourceBundle.getString("ObjectDetection.ObjectSegmentation.objectClassification.setupClasses.text"))
                .setIconFactory(system_run_5.factory())
                .setAction(oia.SetupClassesObjectClassificationCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("ObjectDetection.ObjectSegmentation.objectClassification.setupClasses.text"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.objectClassification.setupClasses.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.objectClassification.setupClasses.tooltip.actionParagraph2"))
                                .build())
                .build();

        this.objectMarkerCommand = Command.builder()
                .setText(resourceBundle.getString("ObjectDetection.ObjectSegmentation.objectMarker.text"))
                .setIconFactory(cellClassMarker.factory())
                .setAction(oia.ObjectMarkerCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("ObjectDetection.ObjectSegmentation.objectMarker.text"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.objectMarker.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.objectMarker.tooltip.actionParagraph2"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.objectMarker.tooltip.actionParagraph3"))
                                .build())
                .build();

        this.trainObjectsCommand = Command.builder()
                .setText(resourceBundle.getString("ObjectDetection.ObjectSegmentation.trainObjects.text"))
                .setIconFactory(object_training.factory())
                .setAction(oia.TrainObjectsCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("ObjectDetection.ObjectSegmentation.trainObjects.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.trainObjects.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.trainObjects.tooltip.actionParagraph2"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.trainObjects.tooltip.actionParagraph3"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.trainObjects.tooltip.actionParagraph4"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.trainObjects.tooltip.actionParagraph5"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.trainObjects.tooltip.actionParagraph6"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.trainObjects.tooltip.actionParagraph7"))
                                .build())
                .build();

        this.objectClassificationCommand = Command.builder()
                .setText(resourceBundle.getString("ObjectDetection.ObjectSegmentation.objectClassification.text"))
                .setIconFactory(obj_classification.factory())
                .setAction(oia.ObjectClassificationCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("ObjectDetection.ObjectSegmentation.objectClassification.text"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.objectClassification.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.objectClassification.tooltip.actionParagraph2"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.objectClassification.tooltip.actionParagraph3"))
                                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.objectClassification.tooltip.actionParagraph4"))
                                .build())
                .build();

        // ROI Task Commands
        this.resetRoiCommand = Command.builder()
                .setText(resourceBundle.getString("ROI.RegionOfInterest.resetRoi.text"))
                .setIconFactory(edit_clear_3.factory())
                .setAction(oia.ResetRoiCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("ROI.RegionOfInterest.resetRoi.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("ROI.RegionOfInterest.resetRoi.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.invertRoiCommand = Command.builder()
                .setText(resourceBundle.getString("ROI.RegionOfInterest.invertRoi.text"))
                .setIconFactory(draw_roi2_inverted.factory())
                .setAction(oia.InvertRoiCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("ROI.RegionOfInterest.invertRoi.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("ROI.RegionOfInterest.invertRoi.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("ROI.RegionOfInterest.invertRoi.tooltip.actionParagraph2"))
                                .build())
                .build();

        this.measureAreaCommand = Command.builder()
                .setText(resourceBundle.getString("ROI.RegionOfInterest.measureArea.text"))
                .setIconFactory(lineal.factory())
                .setAction(oia.MeasureAreaCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("ROI.RegionOfInterest.measureArea.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("ROI.RegionOfInterest.measureArea.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("ROI.RegionOfInterest.measureArea.tooltip.actionParagraph2"))
                                .build())
                .build();

        this.segmentationAsRoiCommand = Command.builder()
                .setText(resourceBundle.getString("ROI.SpecialROIs.segmentationAsRoi.text"))
                .setIconFactory(segmentation.factory())
                .setAction(oia.SegmentationAsRoiCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("ROI.SpecialROIs.segmentationAsRoi.text"))
                                .addDescriptionSection(resourceBundle.getString("ROI.SpecialROIs.segmentationAsRoi.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.tmaRoiCommand = Command.builder()
                .setText(resourceBundle.getString("ROI.SpecialROIs.tmaGrid.text"))
                .setIconFactory(grid.factory())
                .setAction(oia.TmaRoiCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("ROI.SpecialROIs.tmaGrid.text"))
                                .addDescriptionSection(resourceBundle.getString("ROI.SpecialROIs.tmaGrid.tooltip.actionParagraph1"))
                                .build())
                .build();

        // Mask Task Commands
        this.setClassificationMaskCommand = Command.builder()
                .setText(resourceBundle.getString("Mask.ModelBasedMasks.setClassificationMask.text"))
                .setIconFactory(set_maski.factory())
                .setAction(oia.SetClassificationMaskCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Mask.ModelBasedMasks.setClassificationMask.text"))
                                .addDescriptionSection(resourceBundle.getString("Mask.ModelBasedMasks.setClassificationMask.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.setSegmentationMaskCommand = Command.builder()
                .setText(resourceBundle.getString("Mask.ModelBasedMasks.setSegmentationMask.text"))
                .setIconFactory(set_segmask.factory())
                .setAction(oia.SetSegmentationMaskCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Mask.ModelBasedMasks.setSegmentationMask.text"))
                                .addDescriptionSection(resourceBundle.getString("Mask.ModelBasedMasks.setSegmentationMask.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.unsetMaskCommand = Command.builder()
                .setText(resourceBundle.getString("Mask.ModelBasedMasks.unsetMask.text"))
                .setIconFactory(unset_mask.factory())
                .setAction(oia.UnsetMaskCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Mask.ModelBasedMasks.unsetMask.text"))
                                .addDescriptionSection(resourceBundle.getString("Mask.ModelBasedMasks.unsetMask.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.configureMaskCommand = Command.builder()
                .setText(resourceBundle.getString("Mask.ModelBasedMasks.configureMask.text"))
                .setIconFactory(system_run_5.factory())
                .setAction(oia.ConfigureMaskCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Mask.ModelBasedMasks.configureMask.text"))
                                .addDescriptionSection(resourceBundle.getString("Mask.ModelBasedMasks.configureMask.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.maskToExplorerCommand = Command.builder()
                .setText(resourceBundle.getString("Mask.ModelBasedMasks.maskToExplorer.text"))
                .setIconFactory(mask2browser.factory())
                .setAction(oia.MaskToExplorerCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Mask.ModelBasedMasks.maskToExplorer.text"))
                                .addDescriptionSection(resourceBundle.getString("Mask.ModelBasedMasks.maskToExplorer.tooltip.actionParagraph1"))
                                .build())
                .build();

        // Batch Task Commands
        this.localExecutionCommand = Command.builder()
                .setText(resourceBundle.getString("Batch.BatchExecute.localExecution.text"))
                .setIconFactory(system_run_3.factory())
                .setAction(oia.LocalExecutionCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Batch.BatchExecute.localExecution.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("Batch.BatchExecute.localExecution.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.scaleOutExecutionCommand = Command.builder()
                .setText(resourceBundle.getString("Batch.BatchExecute.scaleoutExecution.text"))
                .setIconFactory(system_run_3.factory())
                .setAction(oia.ScaleOutExecutionCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Batch.BatchExecute.scaleoutExecution.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("Batch.BatchExecute.scaleoutExecution.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("Batch.BatchExecute.scaleoutExecution.tooltip.actionParagraph2"))
                                .addDescriptionSection(resourceBundle.getString("Batch.BatchExecute.scaleoutExecution.tooltip.actionParagraph3"))
                                .build())
                .build();

        this.roiAreaComputationCommand = Command.builder()
                .setText(resourceBundle.getString("Batch.BatchExecute.roiAreaComputation.text"))
                .setIconFactory(lineal.factory())
                .setAction(oia.RoiAreaComputationCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Batch.BatchExecute.roiAreaComputation.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("Batch.BatchExecute.roiAreaComputation.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("Batch.BatchExecute.roiAreaComputation.tooltip.actionParagraph2"))
                                .build())
                .build();

        this.retrieveExistingResultsCommand = Command.builder()
                .setText(resourceBundle.getString("Batch.BatchExecute.retrieveExistingResults.text"))
                .setIconFactory(go_down_search.factory())
                .setAction(oia.RetrieveExistingResultsCommandAction)
                .setActionEnabled(!DALConfig.isLocalImageProvider())
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Batch.BatchExecute.retrieveExistingResults.text"))
                                .addDescriptionSection(resourceBundle.getString("Batch.BatchExecute.retrieveExistingResults.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("Batch.BatchExecute.retrieveExistingResults.tooltip.actionParagraph2"))
                                .build())
                .build();

        // Tools Task Commands
        this.orbitBrowserCommand = Command.builder()
                .setText(resourceBundle.getString("Tools.ManageFiles.orbitBrowser.text"))
                .setIconFactory(browser_wipp_Address_Book.factory())
                .setAction(oia.OrbitBrowserCommandAction)
                .setActionEnabled(!DALConfig.isLocalImageProvider())
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Tools.ManageFiles.orbitBrowser.text"))
                                .addDescriptionSection(resourceBundle.getString("Tools.ManageFiles.orbitBrowser.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("Tools.ManageFiles.orbitBrowser.tooltip.actionParagraph2"))
                                .build())
                .build();

        this.dbCleanupCommand = Command.builder()
                .setText(resourceBundle.getString("Tools.ManageFiles.dbCleanup.text"))
                .setIconFactory(system_run_5.factory())
                .setAction(oia.DbCleanupCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Tools.ManageFiles.dbCleanup.text"))
                                .addDescriptionSection(resourceBundle.getString("Tools.ManageFiles.dbCleanup.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("Tools.ManageFiles.dbCleanup.tooltip.actionParagraph2"))
                                .addDescriptionSection(resourceBundle.getString("Tools.ManageFiles.dbCleanup.tooltip.actionParagraph3"))
                                .build())
                .build();

        this.channelColorResetCommand = Command.builder()
                .setText(resourceBundle.getString("Tools.ManageFiles.channelColorReset.text"))
                .setIconFactory(system_run_5.factory())
                .setAction(oia.ChannelColorResetCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Tools.ManageFiles.channelColorReset.text"))
                                .addDescriptionSection(resourceBundle.getString("Tools.ManageFiles.channelColorReset.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("Tools.ManageFiles.channelColorReset.tooltip.actionParagraph2"))
                                .build())
                .build();

        this.saveFullImageCommand = Command.builder()
                .setText(resourceBundle.getString("Tools.SaveImage.saveFullImage.text"))
                .setIconFactory(document_save_as_3.factory())
                .setAction(oia.SaveFullImageCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Tools.SaveImage.saveFullImage.text"))
                                .addDescriptionSection(resourceBundle.getString("Tools.SaveImage.saveFullImage.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("Tools.SaveImage.saveFullImage.tooltip.actionParagraph2"))
                                .build())
                .build();

        this.saveCurrentViewCommand = Command.builder()
                .setText(resourceBundle.getString("Tools.SaveImage.saveCurrentView.text"))
                .setIconFactory(document_save_as_3.factory())
                .setAction(oia.SaveCurrentViewCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Tools.SaveImage.saveCurrentView.text"))
                                .addDescriptionSection(resourceBundle.getString("Tools.SaveImage.saveCurrentView.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("Tools.SaveImage.saveCurrentView.tooltip.actionParagraph2"))
                                .build())
                .build();

        this.saveClassificationImageCommand = Command.builder()
                .setText(resourceBundle.getString("Tools.SaveImage.saveClassificationImage.text"))
                .setIconFactory(document_save_as_3.factory())
                .setAction(oia.SaveClassificationImageCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Tools.SaveImage.saveClassificationImage.text"))
                                .addDescriptionSection(resourceBundle.getString("Tools.SaveImage.saveClassificationImage.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("Tools.SaveImage.saveClassificationImage.tooltip.actionParagraph2"))
                                .build())
                .build();

        this.scriptEditorCommand = Command.builder()
                .setText(resourceBundle.getString("Tools.Script.retrieveExistingResults.text"))
                .setIconFactory(Groovy_logo.factory())
                .setAction(oia.ScriptEditorCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Tools.Script.retrieveExistingResults.text"))
                                .addDescriptionSection(resourceBundle.getString("Tools.Script.retrieveExistingResults.tooltip.actionParagraph1"))
                                .build())
                .build();

        // View Task Commands
        this.tileWindowsCommand = Command.builder()
                .setText(resourceBundle.getString("View.Arrange.tileWindows.text"))
                .setIconFactory(tile_windows.factory())
                .setAction(oia.TileWindowsCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("View.Arrange.tileWindows.text"))
                                .addDescriptionSection(resourceBundle.getString("View.Arrange.tileWindows.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.cascadeWindowsCommand = Command.builder()
                .setText(resourceBundle.getString("View.Arrange.cascadeWindows.text"))
                .setIconFactory(cascade_windows.factory())
                .setAction(oia.CascadeWindowsCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("View.Arrange.cascadeWindows.text"))
                                .addDescriptionSection(resourceBundle.getString("View.Arrange.cascadeWindows.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.minimizeWindowsCommand = Command.builder()
                .setText(resourceBundle.getString("View.Arrange.minimizeWindows.text"))
                .setIconFactory(minimize_windows.factory())
                .setAction(oia.MinimizeWindowsCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("View.Arrange.minimizeWindows.text"))
                                .addDescriptionSection(resourceBundle.getString("View.Arrange.minimizeWindows.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.closeWindowsCommand = Command.builder()
                .setText(resourceBundle.getString("View.Arrange.closeWindows.text"))
                .setIconFactory(close_windows.factory())
                .setAction(oia.CloseWindowsCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("View.Arrange.closeWindows.text"))
                                .addDescriptionSection(resourceBundle.getString("View.Arrange.closeWindows.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.showToolbarCommand = Command.builder()
                .setText(resourceBundle.getString("View.Show.showToolbar.text"))
                .setIconFactory(ribbon_bar.factory())
                .setAction(oia.ShowToolbarCommandAction)
                // TODO: This needs to update when the ribbon is minimized or not...
                .setToggleSelected(oia.isShowToolbar())
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("View.Show.showToolbar.text"))
                                .addDescriptionSection(resourceBundle.getString("View.Show.showToolbar.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.showStatusBarCommand = Command.builder()
                .setText(resourceBundle.getString("View.Show.showStatusBar.text"))
                .setIconFactory(status_bar.factory())
                .setAction(oia.ShowStatusBarCommandAction)
                .setToggleSelected(oia.isShowStatusbar())
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("View.Show.showStatusBar.text"))
                                .addDescriptionSection(resourceBundle.getString("View.Show.showStatusBar.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.showGaugeCommand = Command.builder()
                .setText(resourceBundle.getString("View.Show.showGauge.text"))
                .setIconFactory(gauge.factory())
                .setAction(oia.ShowGaugeCommandAction)
                .setToggleSelected(oia.isShowGauge())
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("View.Show.showGauge.text"))
                                .addDescriptionSection(resourceBundle.getString("View.Show.showGauge.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.showLabelsCommand = Command.builder()
                .setText(resourceBundle.getString("View.Show.showLabels.text"))
                .setIconFactory(sHOW_LABEL.factory())
                .setAction(oia.ShowLabelsCommandAction)
                .setToggleSelected(oia.isShowAnnotationLabels())
                .setToggleSelected(true)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("View.Show.showLabels.text"))
                                .addDescriptionSection(resourceBundle.getString("View.Show.showLabels.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.showCenterCrossCommand = Command.builder()
                .setText(resourceBundle.getString("View.Show.showCenterCross.text"))
                .setIconFactory(cross.factory())
                .setAction(oia.ShowCenterCrossCommandAction)
                .setToggleSelected(oia.isShowCenterCross())
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("View.Show.showCenterCross.text"))
                                .addDescriptionSection(resourceBundle.getString("View.Show.showCenterCross.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("View.Show.showCenterCross.tooltip.actionParagraph2"))
                                .build())
                .build();

        this.showMarkupCommand = Command.builder()
                .setText(resourceBundle.getString("View.Show.showMarkup.text"))
                .setIconFactory(toggle_markup.factory())
                .setAction(oia.ShowMarkupCommandAction)
                .setToggleSelected(oia.isShowMarkup())
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("View.Show.showMarkup.text"))
                                .addDescriptionSection(resourceBundle.getString("View.Show.showMarkup.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.showSyncFramesCommand = Command.builder()
                .setText(resourceBundle.getString("View.Show.syncFrames.text"))
                .setIconFactory(sync_images.factory())
                .setAction(oia.ShowSyncFramesCommandAction)
                .setToggleSelected(oia.isSyncFrames())
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("View.Show.syncFrames.text"))
                                .addDescriptionSection(resourceBundle.getString("View.Show.syncFrames.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("View.Show.syncFrames.tooltip.actionParagraph2"))
                                .build())
                .build();

        this.showPopupResultsCommand = Command.builder()
                .setText(resourceBundle.getString("View.Show.popupResults.text"))
                .setIconFactory(showPopups.factory())
                .setAction(oia.ShowPopupResultsCommandAction)
                .setToggleSelected(oia.isShowPopupResults())
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("View.Show.popupResults.text"))
                                .addDescriptionSection(resourceBundle.getString("View.Show.popupResults.tooltip.actionParagraph1"))
                                .addDescriptionSection(resourceBundle.getString("View.Show.popupResults.tooltip.actionParagraph2"))
                                .build())
                .build();

        // Help Task Commands
        this.orbitManualCommand = Command.builder()
                .setText(resourceBundle.getString("Help.Documentation.orbitManual.text"))
                .setIconFactory(system_help_3.factory())
                .setAction(oia.OrbitManualCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Help.Documentation.orbitManual.text"))
                                .addDescriptionSection(resourceBundle.getString("Help.Documentation.orbitManual.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.orbitTutorialsCommand = Command.builder()
                .setText(resourceBundle.getString("Help.Documentation.orbitTutorials.text"))
                .setIconFactory(system_help_3.factory())
                .setAction(oia.OrbitTutorialsCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Help.Documentation.orbitTutorials.text"))
                                .addDescriptionSection(resourceBundle.getString("Help.Documentation.orbitTutorials.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.aboutCommand = Command.builder()
                .setText(resourceBundle.getString("Help.Documentation.about.text"))
                .setIconFactory(help_about_3.factory())
                .setAction(oia.AboutCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Help.Documentation.about.text"))
                                .addDescriptionSection(resourceBundle.getString("Help.Documentation.about.tooltip.actionParagraph1"))
                                .build())
                .build();

       this.showLogCommand = Command.builder()
                .setText(resourceBundle.getString("Help.Logs.showLog.text"))
                .setIconFactory(system_log_out_3.factory())
                .setAction(oia.ShowLogCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Help.Logs.showLog.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("Help.Logs.showLog.tooltip.actionParagraph1"))
                                .build())
                .build();

        this.showLogModelCommand = Command.builder()
                .setText(resourceBundle.getString("Help.Logs.logModel.text"))
                .setIconFactory(writeModel.factory())
                .setAction(oia.ShowLogModelCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Help.Logs.logModel.tooltip.text"))
                                .addDescriptionSection(resourceBundle.getString("Help.Logs.logModel.tooltip.actionParagraph1"))
                                .build())
                .build();


        // Taskbar Commands.
        this.handToolCommand = Command.builder()
                .setText(resourceBundle.getString("Taskbar.HandTool.textTaskbarTitle"))
                .setIconFactory(hand_cursor_icon.factory())
                .setAction(oia.HandToolCommandAction)
                .setActionRichTooltip(
                        RichTooltip.builder()
                                .setTitle(resourceBundle.getString("Taskbar.HandTool.textTaskbarTitle"))
                                .addDescriptionSection(resourceBundle.getString("Taskbar.HandTool.textTaskbarTitle"))
                                .build())
                .build();

    }

    /**
     * Create the OrbitMenu JRibbon
     * @param ribbon The OrbitMenu JRibbon
     */
    public void configureRibbon(final JRibbon ribbon) {
        this.createCommands();

        JRibbonBand openImageBand = this.getImageBand();
        JRibbonBand openSpecialBand = this.getOpenSpecialBand();
        JRibbonBand saveBand = this.getSaveBand();
        JRibbonBand imageProviderBand = this.getImageProviderBand();
        RibbonTask imageTask = new RibbonTask(resourceBundle.getString("Image.textTaskTitle"),
                openImageBand,
                openSpecialBand,
                saveBand,
                imageProviderBand);
        imageTask.setKeyTip("I");

        JRibbonBand copyBand = this.getCopyBand();
        JRibbonBand pasteBand = this.getPasteBand();
        RibbonTask editTask = new RibbonTask(resourceBundle.getString("Edit.textTaskTitle"),
                copyBand,
                pasteBand);

        JRibbonBand openModelBand = this.getOpenModelBand();
        JRibbonBand saveModelBand = this.getSaveModelBand();
        JRibbonBand configureModelBand = this.getConfigureModelBand();
        JRibbonBand resetModelBand = this.getResetModelBand();

        RibbonTask modelTask = new RibbonTask(resourceBundle.getString("Model.textTaskTitle"),
                openModelBand,
                saveModelBand,
                configureModelBand,
                resetModelBand);

        JRibbonBand setupClassesBand = oia.getExclusionModule().getSetupExclusionClassesBand();
        JRibbonBand drawBand = this.getDrawBand();
        JRibbonBand exclusionBand = oia.getExclusionModule().getExclusionModelBand();
        RibbonTask exclusionModelTask = new RibbonTask(resourceBundle.getString("ExclusionModel.textTaskTitle"),
                setupClassesBand,
                drawBand,
                exclusionBand);

        JRibbonBand setupClassesClassificationBand = this.getSetupClassificationClassesBand();
        JRibbonBand drawClassificationBand = this.getDrawBand();
        JRibbonBand machineLearningBand = this.getMachineLearningBand();
        JRibbonBand resetModelClassificationBand = this.getResetModelBand();

        RibbonTask classificationTask = new RibbonTask(resourceBundle.getString("Classification.textTaskTitle"),
                setupClassesClassificationBand,
                drawClassificationBand,
                machineLearningBand,
                resetModelClassificationBand);

        JRibbonBand setupClassesObjectDetectionBand = this.getSetupObjectSegmentationClassesBand();
        JRibbonBand drawObjectDetectionBand = this.getDrawBand();
        JRibbonBand machineLearningObjectDetectionBand = this.getMachineLearningBand();
        JRibbonBand objectSegmentationBand = this.getObjectSegmentationBand();
        JRibbonBand objectClassificationBand = this.getObjectClassificationBand();
        RibbonTask objectDetectionTask = new RibbonTask(resourceBundle.getString("ObjectDetection.textTaskTitle"),
                setupClassesObjectDetectionBand,
                drawObjectDetectionBand,
                machineLearningObjectDetectionBand,
                objectSegmentationBand,
                objectClassificationBand);

        JRibbonBand roiBand = this.getRoiBand();
        JRibbonBand specialRoiBand = this.getSpecialRoiBand();
        RibbonTask roiTask = new RibbonTask(resourceBundle.getString("ROI.textTaskTitle"),
                roiBand,
                specialRoiBand);

        JRibbonBand maskBand = this.getModelBasedMasksBand();
        RibbonTask maskTask = new RibbonTask(resourceBundle.getString("Mask.textTaskTitle"),
                maskBand);

        JRibbonBand batchBand = this.getBatchBand();
        RibbonTask batchTask = new RibbonTask(resourceBundle.getString("Batch.textTaskTitle"),
                batchBand);

        JRibbonBand manageFilesBand = this.getManageFilesBand();
        JRibbonBand saveImageBand = this.getSaveImageBand();
        JRibbonBand extensionsBand = this.getExtensionsBand();
        JRibbonBand scriptBand = this.getScriptBand();
        RibbonTask toolsTask = new RibbonTask(resourceBundle.getString("Tools.textTaskTitle"),
                manageFilesBand,
                saveImageBand,
                extensionsBand,
                scriptBand);

        JRibbonBand arrangeBand = this.getArrangeBand();
        JRibbonBand showBand = this.getShowBand();
        RibbonTask viewTask = new RibbonTask(resourceBundle.getString("View.textTaskTitle"),
                arrangeBand,
                showBand);

        JRibbonBand documentationBand = this.getDocumentationBand();
        JRibbonBand logsBand = this.getLogsBand();
        RibbonTask helpTask = new RibbonTask(resourceBundle.getString("Help.textTaskTitle"),
                documentationBand,
                logsBand);

        // Add the tabs to the Window.
        ribbon.addTask(imageTask);
        ribbon.addTask(editTask);
        ribbon.addTask(modelTask);
        ribbon.addTask(exclusionModelTask);
        ribbon.addTask(classificationTask);
        ribbon.addTask(objectDetectionTask);
        ribbon.addTask(roiTask);
        ribbon.addTask(maskTask);
        ribbon.addTask(batchTask);
        ribbon.addTask(toolsTask);

        ICustomMenu customMenu = DALConfig.getCustomMenu();
        if (customMenu != null) {
            JRibbonBand customMenuBand = this.getCustomMenuBand(customMenu);
            RibbonTask customMenuTask = new RibbonTask(resourceBundle.getString("Custom.textTaskTitle"),
                    customMenuBand);
            ribbon.addTask(customMenuTask);
        }

        ribbon.addTask(viewTask);
        ribbon.addTask(helpTask);

        configureApplicationMenu(ribbon);
        configureTaskBar(ribbon);

        configureKeyboardShortcuts(ribbon);
    }

    /**
     * Configure OrbitMenu shortcuts.
     *
     * @param ribbon The radiance JRibbon component.
     */
    private void configureKeyboardShortcuts(JRibbon ribbon) {
        KeyStroke f1KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0);
        KeyStroke f2KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0);
        KeyStroke f3KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0);
        KeyStroke f4KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0);
        KeyStroke f5KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0);
        KeyStroke f6KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0);
        KeyStroke f7KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0);
        KeyStroke f8KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0);
        KeyStroke f9KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0);
        KeyStroke f10KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0);
        KeyStroke f11KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0);
        KeyStroke f12KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0);

        KeyStroke copyImageKeyStroke = (NeonCortex.getPlatform() != NeonCortex.Platform.MACOS)
                ? KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_DOWN_MASK)
                : KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_DOWN_MASK);
        KeyStroke copyImageFullKeyStroke = (NeonCortex.getPlatform() != NeonCortex.Platform.MACOS)
                ? KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK)
                : KeyStroke.getKeyStroke(KeyEvent.VK_C, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());
        KeyStroke pasteKeyStroke = (NeonCortex.getPlatform() != NeonCortex.Platform.MACOS)
                ? KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK)
                : KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());
        KeyStroke loadOverviewKeyStroke = (NeonCortex.getPlatform() != NeonCortex.Platform.MACOS)
                ? KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK)
                : KeyStroke.getKeyStroke(KeyEvent.VK_O, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());

        KeyStroke handToolKeyStroke = (NeonCortex.getPlatform() != NeonCortex.Platform.MACOS)
                ? KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.ALT_DOWN_MASK)
                : KeyStroke.getKeyStroke(KeyEvent.VK_H, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());
        KeyStroke eraserKeyStroke = (NeonCortex.getPlatform() != NeonCortex.Platform.MACOS)
                ? KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_DOWN_MASK)
                : KeyStroke.getKeyStroke(KeyEvent.VK_E, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());
        KeyStroke polygonKeyStroke = (NeonCortex.getPlatform() != NeonCortex.Platform.MACOS)
                ? KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK)
                : KeyStroke.getKeyStroke(KeyEvent.VK_P, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());
        KeyStroke circleKeyStroke = (NeonCortex.getPlatform() != NeonCortex.Platform.MACOS)
                ? KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_DOWN_MASK)
                : KeyStroke.getKeyStroke(KeyEvent.VK_E, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());
        KeyStroke rectangleKeyStroke = (NeonCortex.getPlatform() != NeonCortex.Platform.MACOS)
                ? KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_DOWN_MASK)
                : KeyStroke.getKeyStroke(KeyEvent.VK_R, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());
        KeyStroke roiKeyStroke = (NeonCortex.getPlatform() != NeonCortex.Platform.MACOS)
                ? KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.ALT_DOWN_MASK)
                : KeyStroke.getKeyStroke(KeyEvent.VK_I, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());
        KeyStroke setupClassesClassificationKeyStroke = (NeonCortex.getPlatform() != NeonCortex.Platform.MACOS)
                ? KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.ALT_DOWN_MASK)
                : KeyStroke.getKeyStroke(KeyEvent.VK_1, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());
        KeyStroke setupClassesSegmentationKeyStroke = (NeonCortex.getPlatform() != NeonCortex.Platform.MACOS)
                ? KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.ALT_DOWN_MASK)
                : KeyStroke.getKeyStroke(KeyEvent.VK_2, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());
        KeyStroke setupClassesObjectClassificationKeyStroke = (NeonCortex.getPlatform() != NeonCortex.Platform.MACOS)
                ? KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.ALT_DOWN_MASK)
                : KeyStroke.getKeyStroke(KeyEvent.VK_3, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());
        KeyStroke prevClassKeyStroke = (NeonCortex.getPlatform() != NeonCortex.Platform.MACOS)
                ? KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, InputEvent.ALT_DOWN_MASK)
                : KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());
        KeyStroke nextClassKeyStroke = (NeonCortex.getPlatform() != NeonCortex.Platform.MACOS)
                ? KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, InputEvent.ALT_DOWN_MASK)
                : KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());
        KeyStroke zoomInKeyStroke = (NeonCortex.getPlatform() != NeonCortex.Platform.MACOS)
                ? KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, InputEvent.ALT_DOWN_MASK)
                : KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());
        KeyStroke zoomOutKeyStroke = (NeonCortex.getPlatform() != NeonCortex.Platform.MACOS)
                ? KeyStroke.getKeyStroke(KeyEvent.VK_UP, InputEvent.ALT_DOWN_MASK)
                : KeyStroke.getKeyStroke(KeyEvent.VK_UP, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());

        ribbon.registerKeyboardAction(oia.orbitManualAction, f1KeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia.classesAction, f2KeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia.featuresAction, f3KeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia.fuzzinessAction, f4KeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia.showMarkupAction, f5KeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia.handAction, f6KeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia.trainAction, f7KeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia.classifyAction, f8KeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia.tileWindowsAction, f9KeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia.cascadeWindowsAction, f10KeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia.minimizeWindowsAction, f11KeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia.closeWindowsAction, f12KeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);

        ribbon.registerKeyboardAction(oia.copyImageAction, copyImageKeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia.copyImageFullAction, copyImageFullKeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia.PasteImageAction, pasteKeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia.overviewAction, loadOverviewKeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);

        ribbon.registerKeyboardAction(oia.handAction, handToolKeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia.eraserAction, eraserKeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia.polygonAction, polygonKeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia.circleAction, circleKeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia.rectangleAction, rectangleKeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia.defineRoiAction, roiKeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia.setupClassesClassificationAction, setupClassesClassificationKeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia.setupClassesObjectSegmentationAction, setupClassesSegmentationKeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia.setupClassesObjectClassificationAction, setupClassesObjectClassificationKeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia.prevClassAction, prevClassKeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia.nextClassAction, nextClassKeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia.zoomInAction, zoomInKeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia.zoomOutAction, zoomOutKeyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);


    }

    /**
     * Define the application menu for OrbitMenu.
     * @param ribbon The radiance JRibbon component.
     */
    private void configureApplicationMenu(final JRibbon ribbon) {
        Map<Command, CommandButtonPresentationModel.Overlay> applicationMenuOverlays =
                new HashMap<>();
        Map<Command, CommandButtonPresentationState> applicationMenuSecondaryStates =
                new HashMap<>();

        CommandMenuContentModel openImageMenu = new CommandMenuContentModel(
                new CommandGroup(
                        resourceBundle.getString("AppMenu.PrimaryOptions.OpenImage.text"),
                        openImageCommand
                )
        );

        CommandMenuContentModel openModelMenu = new CommandMenuContentModel(
                new CommandGroup(
                        resourceBundle.getString("AppMenu.PrimaryOptions.OpenModel.text"),
                        openModelServerCommand,
                        openModelCommand
                )
        );

        CommandMenuContentModel saveModelMenu = new CommandMenuContentModel(
                new CommandGroup(
                        resourceBundle.getString("AppMenu.PrimaryOptions.SaveModel.text"),
                        saveModelAsCommand,
                        saveModelServerCommand,
                        saveNestedExclusionModelCommand,
                        saveNestedSegmentationModelCommand
                )
        );

        CommandMenuContentModel helpMenu = new CommandMenuContentModel(
                new CommandGroup(
                        resourceBundle.getString("AppMenu.PrimaryOptions.Help.text"),
                        orbitManualCommand,
                        orbitTutorialsCommand,
                        //version check
                        aboutCommand
                )
        );

        // Application menu commands
        Command openImageMenuCommand = Command.builder()
                .setText(resourceBundle.getString("AppMenu.PrimaryOptions.OpenImage.text"))
                .setIconFactory(document_open_5.factory())
                .setSecondaryContentModel(openImageMenu)
                .build();

        Command openModelMenuCommand = Command.builder()
                .setText(resourceBundle.getString("AppMenu.PrimaryOptions.OpenModel.text"))
                .setIconFactory(document_open_5.factory())
                .setSecondaryContentModel(openModelMenu)
                .build();

        Command saveModelAsMenuCommand = Command.builder()
                .setText(resourceBundle.getString("AppMenu.PrimaryOptions.SaveModel.text"))
                .setIconFactory(document_save_3.factory())
                .setSecondaryContentModel(saveModelMenu)
                .build();

        Command helpMenuCommand = Command.builder()
                .setText(resourceBundle.getString("AppMenu.PrimaryOptions.Help.text"))
                .setIconFactory(help_about_3.factory())
                .setSecondaryContentModel(helpMenu)
                .build();

        this.loginMenuCommand = Command.builder()
                .setText(resourceBundle.getString("AppMenu.PrimaryOptions.Login.text"))
                .setIconFactory(document_save_3.factory())
                .setAction(oia.LogInCommand)
                .setActionEnabled(!DALConfig.isLocalImageProvider())
                .build();

        this.logoutMenuCommand = Command.builder()
                .setText(resourceBundle.getString("AppMenu.PrimaryOptions.Logout.text"))
                .setIconFactory(system_log_out_3.factory())
                .setAction(oia.LogOffCommand)
                .setActionEnabled(DALConfig.isLocalImageProvider())
                .build();

        Command exitApplicationMenuCommand = Command.builder()
                .setText(resourceBundle.getString("AppMenu.PrimaryOptions.Exit.text"))
                .setIconFactory(application_exit_3.factory())
                .setAction(oia.ExitApplicationCommand)
                .build();

        // Add the options to the menu
        RibbonApplicationMenu applicationMenu = new RibbonApplicationMenu(
                new CommandGroup(openImageMenuCommand),
                new CommandGroup(saveImageLinksCommand),
                new CommandGroup(openModelMenuCommand),
                new CommandGroup(saveModelAsMenuCommand),
                new CommandGroup(helpMenuCommand),
                new CommandGroup(getLoginMenuCommand()),
                new CommandGroup(getLogoutMenuCommand()),
                new CommandGroup(exitApplicationMenuCommand)
                );

        try {
            final BufferedImage appMenuButtonTooltipImage = ImageIO
                    .read(OrbitMenu.class.getResource(
                            "/ribbon/" +
                                    "application-menu-overview-image.png"));
            final int appMenuButtonTooltipImageWidth = appMenuButtonTooltipImage.getWidth();
            final int appMenuButtonTooltipImageHeight = appMenuButtonTooltipImage.getHeight();
            final float appMenuButtonTooltipImageRatio = (float) appMenuButtonTooltipImageWidth
                    / (float) appMenuButtonTooltipImageHeight;
            final int appMenuButtonTooltipImageInitialWidth = 160;
            final int appMenuButtonTooltipImageInitialHeight = (int)
                    (appMenuButtonTooltipImageInitialWidth
                            / appMenuButtonTooltipImageRatio);
            final ResizableIcon appMenuRichTooltipMainIcon = new ResizableIcon() {
                private int width;
                private int height;

                @Override
                public int getIconWidth() {
                    return this.width;
                }

                @Override
                public int getIconHeight() {
                    return this.height;
                }

                @Override
                public void setDimension(Dimension newDimension) {
                    this.width = newDimension.width;
                    this.height = newDimension.height;
                }

                @Override
                public void paintIcon(Component c, Graphics g, int x, int y) {
                    g.drawImage(appMenuButtonTooltipImage, x, y, getIconWidth(), getIconHeight(),
                            null);
                }
            };

            appMenuRichTooltipMainIcon.setDimension(new Dimension(
                    appMenuButtonTooltipImageInitialWidth, appMenuButtonTooltipImageInitialHeight));


            RibbonApplicationMenuCommandButtonProjection ribbonMenuCommandProjection =
                    new RibbonApplicationMenuCommandButtonProjection(
                            Command.builder()
                                    .setIconFactory(orbit_icon.factory())
                                    .setText(resourceBundle.getString("AppMenu.title"))
                                    .setSecondaryRichTooltip(RichTooltip.builder()
                                            .setTitle(resourceBundle.getString(
                                                    "AppMenu.tooltip.title"))
                                            .addDescriptionSection(resourceBundle.getString(
                                                    "AppMenu.tooltip.paragraph1"))
                                            .setMainIconFactory(() -> appMenuRichTooltipMainIcon)
                                            .setFooterIconFactory(help_about_3.factory())
                                            .addFooterSection(resourceBundle.getString(
                                                    "AppMenu.tooltip.footer1"))
                                            .build())
                                    .setSecondaryContentModel(applicationMenu)
                                    .build(),
                            CommandButtonPresentationModel.builder().build());
            ribbonMenuCommandProjection.setCommandOverlays(applicationMenuOverlays);
            ribbonMenuCommandProjection.setSecondaryLevelCommandPresentationState(
                    applicationMenuSecondaryStates);

            ribbon.setApplicationMenuCommand(ribbonMenuCommandProjection);
        } catch (Throwable t) {
            t.printStackTrace(System.err);
        }
    }

    /**
     * Define the task bar.
     * The smaller links at the top of the window.
     * @param ribbon The radiance JRibbon component.
     */
    private void configureTaskBar(final JRibbon ribbon) {
        // Hand tool
        ribbon.addTaskbarCommand(this.handToolCommand);
        // Classes
        ribbon.addTaskbarComponent(new RibbonClassComboBoxProjection(oia.ccbModel,
                ComponentPresentationModel.builder().build()));
        // Configure Classes
        ribbon.addTaskbarCommand(this.classesCommand);
        // Configure Features
        ribbon.addTaskbarCommand(this.featuresCommand);
    }

    /**
     * Get the image band for the OrbitMenu.
     * @return The image band
     */
    private JRibbonBand getImageBand() {
        JRibbonBand openImageBand = new JRibbonBand(
                resourceBundle.getString("Image.OpenImage.textBandTitle"),
                null,
                null);

        openImageBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("Image.OpenImage.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("Image.OpenImage.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> openImageProjection = this.openImageCommand.project(
                CommandButtonPresentationModel.builder().setFlat(true).build());

        openImageBand.addRibbonCommand(openImageProjection, JRibbonBand.PresentationPriority.TOP);

        List<RibbonBandResizePolicy> resizePolicies = new ArrayList<>();
        resizePolicies.add(new CoreRibbonResizePolicies.Mirror(openImageBand));
        resizePolicies.add(new CoreRibbonResizePolicies.Mid2Low(openImageBand));
        openImageBand.setResizePolicies(resizePolicies);

        return openImageBand;
    }

    /**
     * Get the open special band for the OrbitMenu.
     * @return The open special band
     */
    private JRibbonBand getOpenSpecialBand() {
        JRibbonBand openSpecialBand = new JRibbonBand(
                resourceBundle.getString("Image.OpenSpecial.textBandTitle"),
                null,
                null);

        openSpecialBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("Image.OpenSpecial.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("Image.OpenSpecial.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> overviewProjection = this.overviewCommand.project(
                CommandButtonPresentationModel.builder().build());

        CommandButtonProjection<Command> openForPrintingProjection = this.openForPrintingCommand.project(
                CommandButtonPresentationModel.builder().build());

        CommandButtonProjection<Command> openSpecialResolutionProjection = this.getOpenSpecialResolutionCommand().project(
                CommandButtonPresentationModel.builder()
                        .setTextClickPopup()
                        .build());

        openSpecialBand.addRibbonCommand(overviewProjection, JRibbonBand.PresentationPriority.TOP);
        openSpecialBand.addRibbonCommand(openForPrintingProjection, JRibbonBand.PresentationPriority.TOP);
        openSpecialBand.addRibbonCommand(openSpecialResolutionProjection, JRibbonBand.PresentationPriority.TOP);

        List<RibbonBandResizePolicy> resizePolicies = new ArrayList<>();
        resizePolicies.add(new CoreRibbonResizePolicies.Mirror(openSpecialBand));
        resizePolicies.add(new CoreRibbonResizePolicies.Mid2Low(openSpecialBand));
        openSpecialBand.setResizePolicies(resizePolicies);

        return openSpecialBand;
    }

    /**
     * Get the save band for the OrbitMenu.
     * @return The save band
     */
    private JRibbonBand getSaveBand() {
        JRibbonBand saveImageBand = new JRibbonBand(
                resourceBundle.getString("Image.Save.textBandTitle"),
                null,
                null);

        saveImageBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("Image.Save.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("Image.Save.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> saveImageLinksProjection = this.saveImageLinksCommand.project(
                CommandButtonPresentationModel.builder().build());

        saveImageBand.addRibbonCommand(saveImageLinksProjection, JRibbonBand.PresentationPriority.TOP);

        List<RibbonBandResizePolicy> resizePolicies = new ArrayList<>();
        resizePolicies.add(new CoreRibbonResizePolicies.Mirror(saveImageBand));
        resizePolicies.add(new CoreRibbonResizePolicies.Mid2Low(saveImageBand));
        saveImageBand.setResizePolicies(resizePolicies);

        return saveImageBand;
    }

    /**
     * Get the image provider band for the OrbitMenu.
     * @return The image provider band
     */
    protected JRibbonBand getImageProviderBand() {
        JRibbonBand imageProviderBand = new JRibbonBand(
                resourceBundle.getString("Image.ImageProvider.textBandTitle"),
                null,
                null);

        imageProviderBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("Image.ImageProvider.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("Image.ImageProvider.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> imageProviderProjection = this.imageProviderCommand.project(
                CommandButtonPresentationModel.builder().build());

        imageProviderBand.addRibbonCommand(imageProviderProjection, JRibbonBand.PresentationPriority.TOP);

        List<RibbonBandResizePolicy> resizePolicies = new ArrayList<>();
        resizePolicies.add(new CoreRibbonResizePolicies.Mirror(imageProviderBand));
        resizePolicies.add(new CoreRibbonResizePolicies.Mid2Low(imageProviderBand));
        imageProviderBand.setResizePolicies(resizePolicies);

        return imageProviderBand;
    }

    /**
     * Get the copy band for the OrbitMenu.
     * @return The copy band
     */
    private JRibbonBand getCopyBand() {
        JRibbonBand copyBand = new JRibbonBand(
                resourceBundle.getString("Edit.Copy.textBandTitle"),
                null,
                null);

        copyBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("Edit.Copy.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("Edit.Copy.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> copyImageProjection = this.copyImageCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> copyImageLinkProjection = this.copyImageLinkCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> copyImageFullProjection = this.copyImageFullCommand.project(
                CommandButtonPresentationModel.builder().build());

        copyBand.addRibbonCommand(copyImageProjection, JRibbonBand.PresentationPriority.TOP);
        copyBand.addRibbonCommand(copyImageLinkProjection, JRibbonBand.PresentationPriority.MEDIUM);
        copyBand.addRibbonCommand(copyImageFullProjection, JRibbonBand.PresentationPriority.MEDIUM);

        List<RibbonBandResizePolicy> resizePolicies = new ArrayList<>();
        resizePolicies.add(new CoreRibbonResizePolicies.Mirror(copyBand));
        resizePolicies.add(new CoreRibbonResizePolicies.Mid2Low(copyBand));
        copyBand.setResizePolicies(resizePolicies);

        return copyBand;
    }

    /**
     * Get the paste band for the OrbitMenu.
     * @return The paste band
     */
    private JRibbonBand getPasteBand() {
        JRibbonBand pasteBand = new JRibbonBand(
                resourceBundle.getString("Edit.Paste.textBandTitle"),
                null,
                null);

        pasteBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("Edit.Paste.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("Edit.Paste.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> pasteImageProjection = this.pasteImageCommand.project(
                CommandButtonPresentationModel.builder().build());

        pasteBand.addRibbonCommand(pasteImageProjection, JRibbonBand.PresentationPriority.TOP);

        List<RibbonBandResizePolicy> resizePolicies = new ArrayList<>();
        resizePolicies.add(new CoreRibbonResizePolicies.Mirror(pasteBand));
        resizePolicies.add(new CoreRibbonResizePolicies.Mid2Low(pasteBand));
        pasteBand.setResizePolicies(resizePolicies);

        return pasteBand;
    }

    /**
     * Get the open model band for the OrbitMenu.
     * @return The open model band
     */
    private JRibbonBand getOpenModelBand() {
        JRibbonBand openModelBand = new JRibbonBand(
                resourceBundle.getString("Model.OpenModel.textBandTitle"),
                null,
                null);

        openModelBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("Model.OpenModel.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("Model.OpenModel.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> openModelServerProjection = this.openModelServerCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> openModelProjection = this.openModelCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> restoreTrainingShapesProjection = this.restoreTrainingShapesCommand.project(
                CommandButtonPresentationModel.builder().build());

        openModelBand.addRibbonCommand(openModelServerProjection, JRibbonBand.PresentationPriority.TOP);
        openModelBand.addRibbonCommand(openModelProjection, JRibbonBand.PresentationPriority.TOP);
        openModelBand.addRibbonCommand(restoreTrainingShapesProjection, JRibbonBand.PresentationPriority.TOP);

        List<RibbonBandResizePolicy> resizePolicies = new ArrayList<>();
        resizePolicies.add(new CoreRibbonResizePolicies.Mirror(openModelBand));
        resizePolicies.add(new CoreRibbonResizePolicies.Mid2Low(openModelBand));
        openModelBand.setResizePolicies(resizePolicies);

        return openModelBand;
    }

    /**
     * Get the save model band for the OrbitMenu.
     * @return The save model band
     */
    private JRibbonBand getSaveModelBand() {
        JRibbonBand saveModelBand = new JRibbonBand(
                resourceBundle.getString("Model.SaveModel.textBandTitle"),
                null,
                null);

        saveModelBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("Model.SaveModel.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("Model.SaveModel.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> saveModelServerProjection = this.saveModelServerCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> saveModelAsProjection = this.saveModelAsCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> saveNestedExclusionModelProjection = this.saveNestedExclusionModelCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> saveNestedSegmentationModelProjection = this.saveNestedSegmentationModelCommand.project(
                CommandButtonPresentationModel.builder().build());

        saveModelBand.addRibbonCommand(saveModelServerProjection, JRibbonBand.PresentationPriority.TOP);
        saveModelBand.addRibbonCommand(saveModelAsProjection, JRibbonBand.PresentationPriority.LOW);
        saveModelBand.addRibbonCommand(saveNestedExclusionModelProjection, JRibbonBand.PresentationPriority.LOW);
        saveModelBand.addRibbonCommand(saveNestedSegmentationModelProjection, JRibbonBand.PresentationPriority.LOW);

        List<RibbonBandResizePolicy> resizePolicies = new ArrayList<>();
        resizePolicies.add(new CoreRibbonResizePolicies.Mirror(saveModelBand));
        resizePolicies.add(new CoreRibbonResizePolicies.Mid2Low(saveModelBand));
        saveModelBand.setResizePolicies(resizePolicies);

        return saveModelBand;
    }

    /**
     * Get the configure model band for the OrbitMenu.
     * @return The configure model band
     */
    private JRibbonBand getConfigureModelBand() {
        JRibbonBand configureModelBand = new JRibbonBand(
                resourceBundle.getString("Model.ConfigureModel.textBandTitle"),
                null,
                null);

        configureModelBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("Model.ConfigureModel.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("Model.ConfigureModel.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> classesProjection = this.classesCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> featuresProjection = this.featuresCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> fuzzinessProjection = this.fuzzinessCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> exclusionModelLevelProjection = oia.getExclusionModule().getExclusionModelLevelCommand().project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> performClusteringProjection = this.performClusteringCommand.project(
                CommandButtonPresentationModel.builder().build());

        configureModelBand.addRibbonCommand(classesProjection, JRibbonBand.PresentationPriority.TOP);
        configureModelBand.addRibbonCommand(featuresProjection, JRibbonBand.PresentationPriority.TOP);
        configureModelBand.addRibbonCommand(fuzzinessProjection, JRibbonBand.PresentationPriority.MEDIUM);
        configureModelBand.addRibbonCommand(exclusionModelLevelProjection, JRibbonBand.PresentationPriority.MEDIUM);
        configureModelBand.addRibbonCommand(performClusteringProjection, JRibbonBand.PresentationPriority.MEDIUM);

        List<RibbonBandResizePolicy> resizePolicies = getGenericResizePolicy(configureModelBand);
        configureModelBand.setResizePolicies(resizePolicies);

        return configureModelBand;
    }

    /**
     * Get the reset model band for the OrbitMenu.
     * @return The reset model band
     */
    private JRibbonBand getResetModelBand() {
        JRibbonBand resetModelBand = new JRibbonBand(
                resourceBundle.getString("Model.Reset.textBandTitle"),
                null,
                null);

        resetModelBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("Model.Reset.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("Model.Reset.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> resetMainModelProjection = this.resetMainModelCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> resetPrimarySegmentationModelProjection = this.resetPrimarySegmentationModelCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> resetSecondarySegmentationModelProjection = this.resetSecondarySegmentationModelCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> resetEntireModelProjection = this.resetEntireModelCommand.project(
                CommandButtonPresentationModel.builder().build());

        resetModelBand.addRibbonCommand(resetMainModelProjection, JRibbonBand.PresentationPriority.MEDIUM);
        resetModelBand.addRibbonCommand(resetPrimarySegmentationModelProjection, JRibbonBand.PresentationPriority.MEDIUM);
        resetModelBand.addRibbonCommand(resetSecondarySegmentationModelProjection, JRibbonBand.PresentationPriority.MEDIUM);
        resetModelBand.addRibbonCommand(resetEntireModelProjection, JRibbonBand.PresentationPriority.MEDIUM);

        List<RibbonBandResizePolicy> resizePolicies = getGenericResizePolicy(resetModelBand);
        resetModelBand.setResizePolicies(resizePolicies);

        return resetModelBand;
    }

    /**
     * Get the draw band for the OrbitMenu.
     * @return The draw band
     */
    private JRibbonBand getDrawBand() {
        JRibbonBand drawBand = new JRibbonBand(
                resourceBundle.getString("ExclusionModel.Draw.textBandTitle"),
                null,
                null);

        drawBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("ExclusionModel.Draw.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("ExclusionModel.Draw.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> eraserProjection = this.eraserCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> polygonProjection = this.polygonCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> circleProjection = this.circleCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> rectangleProjection = this.rectangleCommand.project(
                CommandButtonPresentationModel.builder().build());

        drawBand.addRibbonCommand(eraserProjection, JRibbonBand.PresentationPriority.TOP);
        drawBand.addRibbonCommand(polygonProjection, JRibbonBand.PresentationPriority.TOP);
        drawBand.addRibbonCommand(circleProjection, JRibbonBand.PresentationPriority.TOP);
        drawBand.addRibbonCommand(rectangleProjection, JRibbonBand.PresentationPriority.TOP);

        List<RibbonBandResizePolicy> resizePolicies = getGenericResizePolicy(drawBand);
        drawBand.setResizePolicies(resizePolicies);

        return drawBand;
    }

    /**
     * Get the setup classification classes band for the OrbitMenu.
     * @return The setup classification classes band
     */
    private JRibbonBand getSetupClassificationClassesBand() {
        JRibbonBand setupClassesBand = new JRibbonBand(
                resourceBundle.getString("Classification.Setup.textBandTitle"),
                null,
                null);

        setupClassesBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("Classification.Setup.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("Classification.Setup.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> setupClassesProjection = this.setupClassesClassificationCommand.project(
                CommandButtonPresentationModel.builder().setTextClickAction().build());

        setupClassesBand.addRibbonCommand(setupClassesProjection,
                JRibbonBand.PresentationPriority.TOP);

        List<RibbonBandResizePolicy> resizePolicies = new ArrayList<>();
        resizePolicies.add(new CoreRibbonResizePolicies.Mirror(setupClassesBand));
        setupClassesBand.setResizePolicies(resizePolicies);

        return setupClassesBand;
    }

    /**
     * Get the machine learning band for the OrbitMenu.
     * @return The machine learning band
     */
    private JRibbonBand getMachineLearningBand() {
        JRibbonBand machineLearningBand = new JRibbonBand(
                resourceBundle.getString("Classification.MachineLearning.textBandTitle"),
                null,
                null);

        machineLearningBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("Classification.MachineLearning.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("Classification.MachineLearning.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> trainProjection = this.trainCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> defineRoiProjection = this.defineRoiCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> classifyProjection = this.classifyCommand.project(
                CommandButtonPresentationModel.builder().build());

        machineLearningBand.addRibbonCommand(trainProjection, JRibbonBand.PresentationPriority.TOP);
        machineLearningBand.addRibbonCommand(defineRoiProjection, JRibbonBand.PresentationPriority.TOP);
        machineLearningBand.addRibbonCommand(classifyProjection, JRibbonBand.PresentationPriority.TOP);

        List<RibbonBandResizePolicy> resizePolicies = getGenericResizePolicy(machineLearningBand);
        machineLearningBand.setResizePolicies(resizePolicies);

        return machineLearningBand;
    }

    /**
     * Get the setup object segmentation band for the OrbitMenu.
     * @return The setup object segementation band
     */
    private JRibbonBand getSetupObjectSegmentationClassesBand() {
        JRibbonBand setupClassesBand = new JRibbonBand(
                resourceBundle.getString("ObjectDetection.Setup.textBandTitle"),
                null,
                null);

        setupClassesBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("ObjectDetection.Setup.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("ObjectDetection.Setup.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> setupClassesProjection = this.setupClassesObjectSegmentationCommand.project(
                CommandButtonPresentationModel.builder().setTextClickAction().build());

        setupClassesBand.addRibbonCommand(setupClassesProjection,
                JRibbonBand.PresentationPriority.TOP);

        List<RibbonBandResizePolicy> resizePolicies = new ArrayList<>();
        resizePolicies.add(new CoreRibbonResizePolicies.Mirror(setupClassesBand));
        setupClassesBand.setResizePolicies(resizePolicies);

        return setupClassesBand;
    }

    /**
     * Get the object segmentation band for the OrbitMenu.
     * @return The object segmentation band
     */
    private JRibbonBand getObjectSegmentationBand() {
        JRibbonBand objectSegmentationBand = new JRibbonBand(
                resourceBundle.getString("ObjectDetection.ObjectSegmentation.textBandTitle"),
                null,
                null);

        objectSegmentationBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("ObjectDetection.ObjectSegmentation.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectSegmentation.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> setPrimarySegmentationModelProjection = this.setPrimarySegmentationModelCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> setSecondarySegmentationModelProjection = this.setSecondarySegmentationModelCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> featuresProjection = this.featuresCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> defineRoiProjection = this.defineRoiCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> objectSegmentationProjection = this.objectSegmentationCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> showSegmentationHeatmapProjection = this.showSegmentationHeatmapCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> resetPrimarySegmentationModelProjection = this.resetPrimarySegmentationModelCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> resetSecondarySegmentationModelProjection = this.resetSecondarySegmentationModelCommand.project(
                CommandButtonPresentationModel.builder().build());

        objectSegmentationBand.addRibbonCommand(setPrimarySegmentationModelProjection, JRibbonBand.PresentationPriority.TOP);
        objectSegmentationBand.addRibbonCommand(setSecondarySegmentationModelProjection, JRibbonBand.PresentationPriority.TOP);
        objectSegmentationBand.addRibbonCommand(featuresProjection, JRibbonBand.PresentationPriority.MEDIUM);
        objectSegmentationBand.addRibbonCommand(defineRoiProjection, JRibbonBand.PresentationPriority.MEDIUM);
        objectSegmentationBand.addRibbonCommand(objectSegmentationProjection, JRibbonBand.PresentationPriority.TOP);
        objectSegmentationBand.addRibbonCommand(showSegmentationHeatmapProjection, JRibbonBand.PresentationPriority.TOP);
        objectSegmentationBand.addRibbonCommand(resetPrimarySegmentationModelProjection, JRibbonBand.PresentationPriority.MEDIUM);
        objectSegmentationBand.addRibbonCommand(resetSecondarySegmentationModelProjection, JRibbonBand.PresentationPriority.MEDIUM);

        List<RibbonBandResizePolicy> resizePolicies = getGenericResizePolicy(objectSegmentationBand);
        objectSegmentationBand.setResizePolicies(resizePolicies);

        return objectSegmentationBand;
    }

    /**
     * Get the object classification band for the OrbitMenu.
     * @return The object classification band
     */
    private JRibbonBand getObjectClassificationBand() {
        JRibbonBand objectClassificationBand = new JRibbonBand(
                resourceBundle.getString("ObjectDetection.ObjectClassification.textBandTitle"),
                null,
                null);

        objectClassificationBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("ObjectDetection.ObjectClassification.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("ObjectDetection.ObjectClassification.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> setupClassesProjection = this.setupClassesObjectClassificationCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> objectMarkerProjection = this.objectMarkerCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> trainObjectsProjection = this.trainObjectsCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> defineRoiProjection = this.defineRoiCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> objectClassificationProjection = this.objectClassificationCommand.project(
                CommandButtonPresentationModel.builder().build());

        objectClassificationBand.addRibbonCommand(setupClassesProjection, JRibbonBand.PresentationPriority.TOP);
        objectClassificationBand.addRibbonCommand(objectMarkerProjection, JRibbonBand.PresentationPriority.TOP);
        objectClassificationBand.addRibbonCommand(trainObjectsProjection, JRibbonBand.PresentationPriority.TOP);
        objectClassificationBand.addRibbonCommand(defineRoiProjection, JRibbonBand.PresentationPriority.TOP);
        objectClassificationBand.addRibbonCommand(objectClassificationProjection, JRibbonBand.PresentationPriority.TOP);

        List<RibbonBandResizePolicy> resizePolicies = getGenericResizePolicy(objectClassificationBand);
        objectClassificationBand.setResizePolicies(resizePolicies);

        return objectClassificationBand;
    }

    /**
     * Get the ROI band for the OrbitMenu.
     * @return The ROI band
     */
    private JRibbonBand getRoiBand() {
        JRibbonBand roiBand = new JRibbonBand(
                resourceBundle.getString("ROI.RegionOfInterest.textBandTitle"),
                null,
                null);

        roiBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("ROI.RegionOfInterest.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("ROI.RegionOfInterest.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> defineRoiProjection = this.defineRoiCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> resetRoiProjection = this.resetRoiCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> invertRoiProjection = this.invertRoiCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> measureAreaProjection = this.measureAreaCommand.project(
                CommandButtonPresentationModel.builder().build());

        roiBand.addRibbonCommand(defineRoiProjection, JRibbonBand.PresentationPriority.TOP);
        roiBand.addRibbonCommand(resetRoiProjection, JRibbonBand.PresentationPriority.MEDIUM);
        roiBand.addRibbonCommand(invertRoiProjection, JRibbonBand.PresentationPriority.MEDIUM);
        roiBand.addRibbonCommand(measureAreaProjection, JRibbonBand.PresentationPriority.MEDIUM);

        List<RibbonBandResizePolicy> resizePolicies = getGenericResizePolicy(roiBand);
        roiBand.setResizePolicies(resizePolicies);

        return roiBand;
    }

    /**
     * Get the special ROI band for the OrbitMenu.
     * @return The special ROI band
     */
    private JRibbonBand getSpecialRoiBand() {
        JRibbonBand specialroiBand = new JRibbonBand(
                resourceBundle.getString("ROI.SpecialROIs.textBandTitle"),
                null,
                null);

        specialroiBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("ROI.SpecialROIs.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("ROI.SpecialROIs.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> defineRoiProjection = this.segmentationAsRoiCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> resetRoiProjection = this.tmaRoiCommand.project(
                CommandButtonPresentationModel.builder().build());

        specialroiBand.addRibbonCommand(defineRoiProjection, JRibbonBand.PresentationPriority.TOP);
        specialroiBand.addRibbonCommand(resetRoiProjection, JRibbonBand.PresentationPriority.TOP);

        List<RibbonBandResizePolicy> resizePolicies = new ArrayList<>();
        resizePolicies.add(new CoreRibbonResizePolicies.Mirror(specialroiBand));
        resizePolicies.add(new CoreRibbonResizePolicies.Mid2Low(specialroiBand));
        specialroiBand.setResizePolicies(resizePolicies);

        return specialroiBand;
    }

    /**
     * Get the model based mask band for the OrbitMenu.
     * @return The model based mask band
     */
    private JRibbonBand getModelBasedMasksBand() {
        JRibbonBand modelBasedMasksBand = new JRibbonBand(
                resourceBundle.getString("Mask.ModelBasedMasks.textBandTitle"),
                null,
                null);

        modelBasedMasksBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("Mask.ModelBasedMasks.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("Mask.ModelBasedMasks.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> setClassificationMaskProjection = this.setClassificationMaskCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> setSegmentationMaskProjection = this.setSegmentationMaskCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> unsetMaskProjection = this.unsetMaskCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> configureMaskProjection = this.configureMaskCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> maskToExplorerProjection = this.maskToExplorerCommand.project(
                CommandButtonPresentationModel.builder().build());

        modelBasedMasksBand.addRibbonCommand(setClassificationMaskProjection, JRibbonBand.PresentationPriority.TOP);
        modelBasedMasksBand.addRibbonCommand(setSegmentationMaskProjection, JRibbonBand.PresentationPriority.TOP);
        modelBasedMasksBand.addRibbonCommand(unsetMaskProjection, JRibbonBand.PresentationPriority.MEDIUM);
        modelBasedMasksBand.addRibbonCommand(configureMaskProjection, JRibbonBand.PresentationPriority.MEDIUM);
        modelBasedMasksBand.addRibbonCommand(maskToExplorerProjection, JRibbonBand.PresentationPriority.MEDIUM);

        List<RibbonBandResizePolicy> resizePolicies = getGenericResizePolicy(modelBasedMasksBand);
        modelBasedMasksBand.setResizePolicies(resizePolicies);

        return modelBasedMasksBand;
    }

    /**
     * Get the batch band for the OrbitMenu.
     * @return The batch band
     */
    private JRibbonBand getBatchBand() {
        JRibbonBand batchBand = new JRibbonBand(
                resourceBundle.getString("Batch.BatchExecute.textBandTitle"),
                null,
                null);

        batchBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("Batch.BatchExecute.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("Batch.BatchExecute.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> localExecutionProjection = this.localExecutionCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> roiAreaComputationProjection = this.roiAreaComputationCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> scaleOutExecutionProjection = this.scaleOutExecutionCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> retrieveExistingResultsProjection = this.retrieveExistingResultsCommand.project(
                CommandButtonPresentationModel.builder().build());

        batchBand.addRibbonCommand(localExecutionProjection, JRibbonBand.PresentationPriority.TOP);
        batchBand.addRibbonCommand(roiAreaComputationProjection, JRibbonBand.PresentationPriority.TOP);
        batchBand.addRibbonCommand(scaleOutExecutionProjection, JRibbonBand.PresentationPriority.TOP);
        batchBand.addRibbonCommand(retrieveExistingResultsProjection, JRibbonBand.PresentationPriority.TOP);

        List<RibbonBandResizePolicy> resizePolicies = getGenericResizePolicy(batchBand);
        batchBand.setResizePolicies(resizePolicies);

        return batchBand;
    }

    /**
     * Get the manage files band for the OrbitMenu.
     * @return The manage files band
     */
    private JRibbonBand getManageFilesBand() {
        JRibbonBand manageFilesBand = new JRibbonBand(
                resourceBundle.getString("Tools.ManageFiles.textBandTitle"),
                null,
                null);

        manageFilesBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("Tools.ManageFiles.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("Tools.ManageFiles.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> orbitBrowserProjection = this.orbitBrowserCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> dbCleanupProjection = this.dbCleanupCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> channelColorResetProjection = this.channelColorResetCommand.project(
                CommandButtonPresentationModel.builder().build());

        manageFilesBand.addRibbonCommand(orbitBrowserProjection, JRibbonBand.PresentationPriority.TOP);
        manageFilesBand.addRibbonCommand(dbCleanupProjection, JRibbonBand.PresentationPriority.TOP);
        manageFilesBand.addRibbonCommand(channelColorResetProjection, JRibbonBand.PresentationPriority.TOP);

        List<RibbonBandResizePolicy> resizePolicies = getGenericResizePolicy(manageFilesBand);
        manageFilesBand.setResizePolicies(resizePolicies);

        return manageFilesBand;
    }

    /**
     * Get the save image band for the OrbitMenu.
     * @return The save image band
     */
    private JRibbonBand getSaveImageBand() {
        JRibbonBand saveImageBand = new JRibbonBand(
                resourceBundle.getString("Tools.SaveImage.textBandTitle"),
                null,
                null);

        saveImageBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("Tools.SaveImage.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("Tools.SaveImage.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> saveFullImageProjection = this.saveFullImageCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> saveCurrentViewProjection = this.saveCurrentViewCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> saveClassificationImageProjection = this.saveClassificationImageCommand.project(
                CommandButtonPresentationModel.builder().build());

        saveImageBand.addRibbonCommand(saveFullImageProjection, JRibbonBand.PresentationPriority.TOP);
        saveImageBand.addRibbonCommand(saveCurrentViewProjection, JRibbonBand.PresentationPriority.TOP);
        saveImageBand.addRibbonCommand(saveClassificationImageProjection, JRibbonBand.PresentationPriority.TOP);

        List<RibbonBandResizePolicy> resizePolicies = getGenericResizePolicy(saveImageBand);
        saveImageBand.setResizePolicies(resizePolicies);

        return saveImageBand;
    }

    /**
     * Get the extensions band for the OrbitMenu.
     * @return The extensions band
     */
    private JRibbonBand getExtensionsBand() {
        JRibbonBand extensionsBand = new JRibbonBand(
                resourceBundle.getString("Tools.Extensions.textBandTitle"),
                null,
                null);

        extensionsBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("Tools.Extensions.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("Tools.Extensions.textBandTooltipParagraph1"))
                .build());

        for(AbstractOrbitRibbonModule module: oia.getEnabledModules()) {
            CommandButtonProjection<Command> moduleProjection = module.getMenuCommand().project(
                    CommandButtonPresentationModel.builder().build());
            extensionsBand.addRibbonCommand(moduleProjection, JRibbonBand.PresentationPriority.TOP);
        }

        List<RibbonBandResizePolicy> resizePolicies = getGenericResizePolicy(extensionsBand);
        extensionsBand.setResizePolicies(resizePolicies);

        return extensionsBand;
    }

    /**
     *
     * @return The custom menu task
     */
    private JRibbonBand getCustomMenuBand(ICustomMenu customMenu) {
        JRibbonBand customBand = new JRibbonBand(
                resourceBundle.getString("Custom.Custom.textBandTitle"),
                null,
                null);

        customBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("Custom.Custom.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("Custom.Custom.textBandTooltipParagraph1"))
                .build());

        for(AbstractOrbitAction module: customMenu.getRibbonActionSet()) {
            CommandButtonProjection<Command> moduleProjection = module.getMenuCommand().project(
                    CommandButtonPresentationModel.builder().build());
            customBand.addRibbonCommand(moduleProjection, JRibbonBand.PresentationPriority.TOP);
        }

        List<RibbonBandResizePolicy> resizePolicies = getGenericResizePolicy(customBand);
        customBand.setResizePolicies(resizePolicies);

        return customBand;
    }

    /**
     * Get the script band for the OrbitMenu.
     * @return The script band
     */
    private JRibbonBand getScriptBand() {
        JRibbonBand scriptBand = new JRibbonBand(
                resourceBundle.getString("Tools.Script.textBandTitle"),
                null,
                null);

        scriptBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("Tools.Script.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("Tools.Script.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> scriptEditorProjection = this.scriptEditorCommand.project(
                CommandButtonPresentationModel.builder().build());

        scriptBand.addRibbonCommand(scriptEditorProjection, JRibbonBand.PresentationPriority.TOP);

        List<RibbonBandResizePolicy> resizePolicies = new ArrayList<>();
        resizePolicies.add(new CoreRibbonResizePolicies.Mirror(scriptBand));
        resizePolicies.add(new CoreRibbonResizePolicies.Mid2Low(scriptBand));
        scriptBand.setResizePolicies(resizePolicies);

        return scriptBand;
    }

    /**
     * Get the arrange windows band for the OrbitMenu.
     * @return The arrange windows band
     */
    private JRibbonBand getArrangeBand() {
        JRibbonBand arrangeBand = new JRibbonBand(
                resourceBundle.getString("View.Arrange.textBandTitle"),
                null,
                null);

        arrangeBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("View.Arrange.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("View.Arrange.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> tileWindowsProjection = this.tileWindowsCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> cascadeWindowsProjection = this.cascadeWindowsCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> minimizeWindowsProjection = this.minimizeWindowsCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> closeWindowsProjection = this.closeWindowsCommand.project(
                CommandButtonPresentationModel.builder().build());

        arrangeBand.addRibbonCommand(tileWindowsProjection, JRibbonBand.PresentationPriority.MEDIUM);
        arrangeBand.addRibbonCommand(cascadeWindowsProjection, JRibbonBand.PresentationPriority.MEDIUM);
        arrangeBand.addRibbonCommand(minimizeWindowsProjection, JRibbonBand.PresentationPriority.MEDIUM);
        arrangeBand.addRibbonCommand(closeWindowsProjection, JRibbonBand.PresentationPriority.TOP);

        List<RibbonBandResizePolicy> resizePolicies = getGenericResizePolicy(arrangeBand);
        arrangeBand.setResizePolicies(resizePolicies);

        return arrangeBand;
    }

    /**
     * Get the show tools band for the OrbitMenu.
     * @return The show tools band
     */
    private JRibbonBand getShowBand() {
        JRibbonBand showBand = new JRibbonBand(
                resourceBundle.getString("View.Show.textBandTitle"),
                null,
                null);

        showBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("View.Show.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("View.Show.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> showToolbarProjection = this.showToolbarCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> showStatusBarProjection = this.showStatusBarCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> showGaugeProjection = this.showGaugeCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> showLabelsProjection = this.showLabelsCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> showCenterCrossProjection = this.showCenterCrossCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> showMarkupProjection = this.showMarkupCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> showSyncFramesProjection = this.showSyncFramesCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> showPopupResultsProjection = this.showPopupResultsCommand.project(
                CommandButtonPresentationModel.builder().build());

        showBand.addRibbonCommand(showToolbarProjection, JRibbonBand.PresentationPriority.MEDIUM);
        showBand.addRibbonCommand(showStatusBarProjection, JRibbonBand.PresentationPriority.MEDIUM);
        showBand.addRibbonCommand(showGaugeProjection, JRibbonBand.PresentationPriority.MEDIUM);
        showBand.addRibbonCommand(showLabelsProjection, JRibbonBand.PresentationPriority.MEDIUM);
        showBand.addRibbonCommand(showCenterCrossProjection, JRibbonBand.PresentationPriority.MEDIUM);
        showBand.addRibbonCommand(showMarkupProjection, JRibbonBand.PresentationPriority.MEDIUM);
        showBand.addRibbonCommand(showSyncFramesProjection, JRibbonBand.PresentationPriority.MEDIUM);
        showBand.addRibbonCommand(showPopupResultsProjection, JRibbonBand.PresentationPriority.MEDIUM);

        List<RibbonBandResizePolicy> resizePolicies = getGenericResizePolicy(showBand);
        showBand.setResizePolicies(resizePolicies);

        return showBand;
    }

    /**
     * Get the documentation band for the OrbitMenu.
     * @return The documentation band
     */
    private JRibbonBand getDocumentationBand() {
        JRibbonBand documentationBand = new JRibbonBand(
                resourceBundle.getString("Help.Documentation.textBandTitle"),
                null,
                null);

        documentationBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("Help.Documentation.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("Help.Documentation.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> orbitManualProjection = this.orbitManualCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> orbitTutorialsProjection = this.orbitTutorialsCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> aboutProjection = this.aboutCommand.project(
                CommandButtonPresentationModel.builder().build());

        documentationBand.addRibbonCommand(orbitManualProjection, JRibbonBand.PresentationPriority.TOP);
        documentationBand.addRibbonCommand(orbitTutorialsProjection, JRibbonBand.PresentationPriority.TOP);
        documentationBand.addRibbonCommand(aboutProjection, JRibbonBand.PresentationPriority.TOP);

        List<RibbonBandResizePolicy> resizePolicies = getGenericResizePolicy(documentationBand);
        documentationBand.setResizePolicies(resizePolicies);

        return documentationBand;
    }

    /**
     * Get the log files band for the OrbitMenu.
     * @return The log files band
     */
    private JRibbonBand getLogsBand() {
        JRibbonBand logsBand = new JRibbonBand(
                resourceBundle.getString("Help.Logs.textBandTitle"),
                null,
                null);

        logsBand.setExpandButtonRichTooltip(RichTooltip.builder()
                .setTitle(resourceBundle.getString("Help.Logs.textBandTitle"))
                .addDescriptionSection(resourceBundle.getString("Help.Logs.textBandTooltipParagraph1"))
                .build());

        CommandButtonProjection<Command> showLogProjection = this.showLogCommand.project(
                CommandButtonPresentationModel.builder().build());
        CommandButtonProjection<Command> showLogModelProjection = this.showLogModelCommand.project(
                CommandButtonPresentationModel.builder().build());

        logsBand.addRibbonCommand(showLogProjection, JRibbonBand.PresentationPriority.TOP);
        logsBand.addRibbonCommand(showLogModelProjection, JRibbonBand.PresentationPriority.TOP);

        List<RibbonBandResizePolicy> resizePolicies = getGenericResizePolicy(logsBand);
        logsBand.setResizePolicies(resizePolicies);

        return logsBand;
    }

    /**
     * Define a generic resize policy that most OrbitMenu band items can use.
     * @return A generic resize policy that most bands used by the OrbitMenu ribbon can use.
     */
    public static List<RibbonBandResizePolicy> getGenericResizePolicy(JRibbonBand jrband) {
        List<RibbonBandResizePolicy> resizePolicies = new ArrayList<>();
        resizePolicies.add(new CoreRibbonResizePolicies.Low2Mid(jrband));
        resizePolicies.add(new CoreRibbonResizePolicies.Mirror(jrband));
        resizePolicies.add(new CoreRibbonResizePolicies.Mid2Low(jrband));
        resizePolicies.add(new CoreRibbonResizePolicies.IconRibbonBandResizePolicy(jrband));

        return resizePolicies;
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            JFrame.setDefaultLookAndFeelDecorated(true);
//
//            SubstanceCortex.GlobalScope.setSkin(new GraphiteAquaSkin());
//
//            final OrbitMenu orbitmenu = new OrbitMenu();
//            orbitmenu.configureRibbon(orbitmenu.getRibbon());
//
//            orbitmenu.applyComponentOrientation(ComponentOrientation.getOrientation(Locale.getDefault()));
//            Rectangle r = GraphicsEnvironment.getLocalGraphicsEnvironment()
//                    .getMaximumWindowBounds();
//            orbitmenu.setPreferredSize(new Dimension(r.width, r.height / 2));
//            orbitmenu.setMinimumSize(new Dimension(r.width / 10, r.height / 4));
//            orbitmenu.pack();
//            orbitmenu.setLocation(r.x, r.y);
//            orbitmenu.setVisible(true);
//            orbitmenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//
//            KeyStroke keyStroke = (NeonCortex.getPlatform() == NeonCortex
//                    .Platform.MACOS) ? KeyStroke.getKeyStroke("meta alt E") :
//                    KeyStroke.getKeyStroke("alt shift E");
//
//            orbitmenu.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
//                    .put(keyStroke, "installTracingRepaintManager");
//        });
//    }

    /**
     * Getter for the openSpecialResolutionContentModel - used to add items to the
     * action list (e.g. as the number of image layers change when switching between
     * image windows).
     * @return The openSpecialResolutionContentModel used by openSpecialResolutionCommand
     */
    CommandMenuContentModel getOpenSpecialResolutionContentModel() {
        return openSpecialResolutionContentModel;
    }

    /**
     * Used to enable or disable the button action when there are no image layers available.
     * @return The openSpecialResolutionCommand button.
     */
    Command getOpenSpecialResolutionCommand() {
        return openSpecialResolutionCommand;
    }

    protected Command getLoginMenuCommand() {
        return loginMenuCommand;
    }

    protected Command getLogoutMenuCommand() {
        return logoutMenuCommand;
    }
}
