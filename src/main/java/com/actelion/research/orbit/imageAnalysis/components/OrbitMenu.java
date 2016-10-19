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

import com.actelion.research.orbit.imageAnalysis.components.icons.*;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.modules.ExclusionModule;
import com.actelion.research.orbit.imageAnalysis.utils.ICustomMenu;
import org.pushingpixels.flamingo.api.common.AbstractCommandButton;
import org.pushingpixels.flamingo.api.common.JCommandButton;
import org.pushingpixels.flamingo.api.common.JCommandToggleButton;
import org.pushingpixels.flamingo.api.common.RichTooltip;
import org.pushingpixels.flamingo.api.common.icon.ResizableIcon;
import org.pushingpixels.flamingo.api.common.popup.JPopupPanel;
import org.pushingpixels.flamingo.api.common.popup.PopupPanelCallback;
import org.pushingpixels.flamingo.api.ribbon.*;
import org.pushingpixels.flamingo.api.ribbon.resize.CoreRibbonResizePolicies;
import org.pushingpixels.flamingo.api.ribbon.resize.IconRibbonBandResizePolicy;
import org.pushingpixels.flamingo.api.ribbon.resize.RibbonBandResizePolicy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class OrbitMenu extends JRibbonFrame {

    private OrbitImageAnalysis oia = null;
    private final JCommandToggleButton buttonShowMarkup = new JCommandToggleButton("Show Markup (F5)", new ToggleMarkup());
    private final JCommandToggleButton buttonShowAnnotationLabels = new JCommandToggleButton("Show Labels (Ctrl-L)", new SHOWLABEL());
    private final JCommandToggleButton buttonShowCenterCross = new JCommandToggleButton("Show Center Cross (Ctrl-G)", new Cross());
    private final JCommandToggleButton buttonSyncFrames = new JCommandToggleButton("Sync Frames", new SyncImages());
    private final JCommandToggleButton buttonShowPopupResults = new JCommandToggleButton("Popup Results", new ShowPopups());
    private RibbonApplicationMenuEntrySecondary amEntryVersionCheck = null;
    private RibbonApplicationMenuEntrySecondary amOpenOrbit;
    private JCommandButton buttonopenFromOrbit = new JCommandButton(openFromServerStr, new DocumentOpen5());
    private JCommandButton buttonSwitchLocalRemote = null;
    private final JCommandButton buttonExecuteScaleout = new JCommandButton("Scaleout Execution", new SystemRun3());
    private final JCommandButton buttonRetrieveExistingResults = new JCommandButton("Retrieve Existing Results", new GoDownSearch());



    public static final String openFromServerStr = "Open Image from Server";
    public static final String openFromLocalStr = "Open Image from File System";


    public OrbitMenu(OrbitImageAnalysis oia) {
        this.oia = oia;
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceGraphiteGlassLookAndFeel");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                OrbitMenu menu = new OrbitMenu(null);
                menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                menu.setTitle("Orbit Image Analysis");

                menu.createRibbonMenu(menu.getRibbon());

                menu.setPreferredSize(new Dimension(800, 600));
                menu.validate();
                menu.pack();
                menu.setVisible(true);
            }
        });
    }


/*
    imageBand1.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(
			new CoreRibbonResizePolicies.None(imageBand1.getControlPanel()),
			new CoreRibbonResizePolicies.Mirror(imageBand1.getControlPanel()),
			new CoreRibbonResizePolicies.Mid2Low(imageBand1.getControlPanel()),
			//new CoreRibbonResizePolicies.High2Low(imageBand1.getControlPanel()),
			new IconRibbonBandResizePolicy(imageBand1.getControlPanel())));

 */

    public void createRibbonMenu(final JRibbon ribbon) {
        addMainMenu(ribbon);
        addImageTask(ribbon);
        addEditTask(ribbon);
        addModelTask(ribbon);
        RibbonTask exclusionTask = createExclusionTask();
        RibbonTask classificationTask = createClassificationTask();
        RibbonTask objectTask = createObjectTask();
        ribbon.addContextualTaskGroup(new RibbonContextualTaskGroup("Analysis", Color.MAGENTA, exclusionTask, classificationTask, objectTask));
        ribbon.addTask(exclusionTask);
        ribbon.addTask(classificationTask);
        ribbon.addTask(objectTask);
        addROITask(ribbon);
        addBatchTask(ribbon);
        addToolsTask(ribbon);
        addCustomTask(ribbon);
        addChannelsTask(ribbon);
        addWindowsTask(ribbon);
        addHelpTask(ribbon);


        addTaskbarComponents(ribbon);


        ribbon.registerKeyboardAction(oia == null ? null : oia.helpBrowserActionListener, KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia == null ? null : oia.configureFuzzynessActionListener, KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia == null ? null : oia.configureFeaturesActionListener, KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia == null ? null : oia.configClassActionListener, KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonShowMarkup.doActionClick();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia == null ? null : oia.fingerActionListener, KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia == null ? null : oia.trainActionListener, KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia == null ? null : oia.classifyActionListener, KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);


        ribbon.registerKeyboardAction(oia == null ? null : oia.desktopArrangeActionListener, KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia == null ? null : oia.desktopCascadeActionListener, KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia == null ? null : oia.desktopMinimizeAllActionListener, KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia == null ? null : oia.desktopCloseAllActionListener, KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);

        ribbon.registerKeyboardAction(oia == null ? null : oia.copyImageCurrentViewActionHandler, KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_DOWN_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia == null ? null : oia.copyImageFullActionHandler, KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia == null ? null : oia.pasteActionHandler, KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);

        ribbon.registerKeyboardAction(oia == null ? null : oia.loadOverviewActionListener, KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);

        ribbon.registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonShowAnnotationLabels.doActionClick();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);

        ribbon.registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonShowCenterCross.doActionClick();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);

        // channel shortcuts
        ribbon.registerKeyboardAction(oia == null ? null : oia.toggleRedActionListener, KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_DOWN_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia == null ? null : oia.toggleGreenActionListener, KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.ALT_DOWN_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia == null ? null : oia.toggleBlueActionListener, KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.ALT_DOWN_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);
        ribbon.registerKeyboardAction(oia == null ? null : oia.activateAllChannelsActionListener, KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_DOWN_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);

        // annotation shortcuts
        ribbon.registerKeyboardAction(oia == null ? null : oia.addPolygonAnnotationActionListener, KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);


        ribbon.setSelectedTask(ribbon.getTask(4));   // set classification task as selected
    }

    private void addTaskbarComponents(final JRibbon ribbon) {
        ribbon.addTaskbarComponent(createTaskbarButton(new HandCursorIcon(), "Hand Tool (F6)", oia == null ? null : oia.fingerActionListener));
        //ribbon.addTaskbarComponent(createTaskbarButton(new DrawRoi2(), "Define ROI", oia==null?null:oia.selectROIActionListener));
        //ribbon.addTaskbarComponent(createTaskbarToggleButton(new ToggleMarkup(),new ToggleMarkupDisabled(), "Hide Markup", oia==null?null:oia.toggleMarkupActionListener));
        ribbon.addTaskbarComponent(new JRibbonComponent(getClassCombobox()));
        ribbon.addTaskbarComponent(createTaskbarButton(new Configure4(), "Configure Classes (F4)", oia == null ? null : oia.configClassActionListener));
        ribbon.addTaskbarComponent(createTaskbarButton(new PreferencesDesktop2(), "Configure Features (F3)", oia == null ? null : oia.configureFeaturesActionListener));

        ribbon.addHelpPanelComponent(createTaskbarButton(new SystemHelp3(), "Help (F1)", oia == null ? null : oia.helpBrowserActionListener));
    }


    private void addMainMenu(final JRibbon ribbon) {
        RibbonApplicationMenu menu = new RibbonApplicationMenu();

        // open file image
        RibbonApplicationMenuEntryPrimary amEntryOpen = new RibbonApplicationMenuEntryPrimary(new DocumentOpen5(), "Open", null, JCommandButton.CommandButtonKind.POPUP_ONLY);
        amOpenOrbit = new RibbonApplicationMenuEntrySecondary(new DocumentOpen5(), openFromServerStr, oia == null ? null : oia.openFileOrbitActionListener, JCommandButton.CommandButtonKind.ACTION_ONLY);
        amEntryOpen.setPopupKeyTip("O");
        amOpenOrbit.setDescriptionText("Open an image from an image serve or local file system.");

        amEntryOpen.addSecondaryMenuGroup("Open Image", amOpenOrbit);
        menu.addMenuEntry(amEntryOpen);

        // save as .orbit
        RibbonApplicationMenuEntryPrimary amEntrySaveOrbit = new RibbonApplicationMenuEntryPrimary(new DocumentSaveAs3(), "Save image links as .orbit", oia == null ? null : oia.saveAsOrbitActionListener, JCommandButton.CommandButtonKind.ACTION_ONLY);
        menu.addMenuEntry(amEntrySaveOrbit);
        menu.addMenuSeparator();

        // open model
        RibbonApplicationMenuEntryPrimary amEntryOpenModel = new RibbonApplicationMenuEntryPrimary(new DocumentOpen5(), "Open Model", null, JCommandButton.CommandButtonKind.POPUP_ONLY);
        RibbonApplicationMenuEntrySecondary amEntryOpenModelOrbit = new RibbonApplicationMenuEntrySecondary(new DocumentOpen5(), "Open Model from Server", oia == null ? null : oia.openModelOrbitActionListener, JCommandButton.CommandButtonKind.ACTION_ONLY);
        amEntryOpenModelOrbit.setActionKeyTip("M");
        RibbonApplicationMenuEntrySecondary amEntryOpenModelFile = new RibbonApplicationMenuEntrySecondary(new DocumentOpen5(), "Open Model from File", oia == null ? null : oia.openModelActionListener, JCommandButton.CommandButtonKind.ACTION_ONLY);
        amEntryOpenModel.addSecondaryMenuGroup("Open Model", amEntryOpenModelOrbit, amEntryOpenModelFile);
        menu.addMenuEntry(amEntryOpenModel);

        // save model
        RibbonApplicationMenuEntryPrimary amEntrySaveModel = new RibbonApplicationMenuEntryPrimary(new DocumentSave3(), "Save Model", null, JCommandButton.CommandButtonKind.POPUP_ONLY);
        RibbonApplicationMenuEntrySecondary amSaveModelOrbit = new RibbonApplicationMenuEntrySecondary(new DocumentOpen5(), "Save Model in Orbit...", oia == null ? null : oia.saveModelOrbitActionListener, JCommandButton.CommandButtonKind.ACTION_ONLY);
        amSaveModelOrbit.setDescriptionText("Save model in Orbit");
        RibbonApplicationMenuEntrySecondary amSaveModel = new RibbonApplicationMenuEntrySecondary(new DocumentOpen5(), "Save Model as...", oia == null ? null : oia.saveModelAsActionListener, JCommandButton.CommandButtonKind.ACTION_ONLY);
        amSaveModel.setDescriptionText("Save model as file");
        RibbonApplicationMenuEntrySecondary amSaveModelExcl = new RibbonApplicationMenuEntrySecondary(new DocumentOpen5(), "Save nested Exclusion Model as...", oia == null ? null : oia.saveNestedExclusionModelActionListener, JCommandButton.CommandButtonKind.ACTION_ONLY);
        amSaveModelExcl.setDescriptionText("Save nested exclusion model as file");
        RibbonApplicationMenuEntrySecondary amSaveModelSeg = new RibbonApplicationMenuEntrySecondary(new DocumentOpen5(), "Save nested Segmentation Model as...", oia == null ? null : oia.saveNestedSegmentationModelActionListener, JCommandButton.CommandButtonKind.ACTION_ONLY);
        amSaveModelSeg.setDescriptionText("Save nested segmentation model as file");
        amEntrySaveModel.addSecondaryMenuGroup("Save Model", amSaveModelOrbit, amSaveModel, amSaveModelExcl, amSaveModelSeg);
        menu.addMenuEntry(amEntrySaveModel);

        menu.addMenuSeparator();

        // help
        RibbonApplicationMenuEntryPrimary amEntryHelp = new RibbonApplicationMenuEntryPrimary(new SystemHelp3(), "Help", null, JCommandButton.CommandButtonKind.POPUP_ONLY);
        RibbonApplicationMenuEntrySecondary amEntryHelpSec = new RibbonApplicationMenuEntrySecondary(new SystemHelp3(), "Help", oia == null ? null : oia.helpBrowserActionListener, JCommandButton.CommandButtonKind.ACTION_ONLY);
        amEntryHelpSec.setDescriptionText("Orbit Documentation");
        RibbonApplicationMenuEntrySecondary amEntryTutorials = new RibbonApplicationMenuEntrySecondary(new SystemHelp3(), "Tutorials", oia == null ? null : oia.tutorialsBrowserActionListener, JCommandButton.CommandButtonKind.ACTION_ONLY);
        amEntryTutorials.setDescriptionText("Orbit Hands-On Tutorials");
        final UpdateChecker checker = new UpdateChecker();
        final String checkDesc = checker.isChecksEnabled() ? "Disable new version check" : "Enable new version check";
        amEntryVersionCheck = new RibbonApplicationMenuEntrySecondary(new Configure4(), checkDesc, oia == null ? null : new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean doChecks = !checker.isChecksEnabled();
                checker.setChecksEnabled(doChecks);
                amEntryVersionCheck.setText(checker.isChecksEnabled() ? "Disable new version check" : "Enable new version check");
                JOptionPane.showMessageDialog(null, "Version check at startup is now " + (checker.isChecksEnabled() ? "enabled" : "disabled") + ".", "Version Checks", JOptionPane.INFORMATION_MESSAGE);
            }
        }, JCommandButton.CommandButtonKind.ACTION_ONLY);
        amEntryVersionCheck.setDescriptionText("Enable or disable check for updates at startup");

        amEntryHelp.addSecondaryMenuGroup("Help", amEntryHelpSec, amEntryTutorials, amEntryVersionCheck);

        menu.addMenuEntry(amEntryHelp);
        menu.addMenuSeparator();

        // login/logout

        if (!DALConfig.getImageProvider().enforceLoginDialogAtStartup()) {
            RibbonApplicationMenuEntryPrimary amEntryLogin = new RibbonApplicationMenuEntryPrimary(new DocumentSave3(), "Login", oia == null ? null : oia.loginActionListener, JCommandButton.CommandButtonKind.ACTION_ONLY);
            menu.addMenuEntry(amEntryLogin);
        }
        String logoutStr = DALConfig.getImageProvider().enforceLoginDialogAtStartup() ? "Switch User" : "Logout";
        RibbonApplicationMenuEntryPrimary amEntryLogout = new RibbonApplicationMenuEntryPrimary(new SystemLogOut3(), logoutStr, oia == null ? null : oia.logoffActionListener, JCommandButton.CommandButtonKind.ACTION_ONLY);
        menu.addMenuEntry(amEntryLogout);


        // exit (footer)
        RibbonApplicationMenuEntryFooter footerExit = new RibbonApplicationMenuEntryFooter(new ApplicationExit3(), "Exit Program", oia == null ? null : oia.exitProgramActionListener);
        menu.addFooterEntry(footerExit);

        ribbon.setApplicationIcon(new OrbitIcon());
        ribbon.setApplicationMenu(menu);
    }


    private void addImageTask(final JRibbon ribbon) {
        JRibbonBand imageBandOpen = new JRibbonBand("Open Image", null);
        imageBandOpen.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(imageBandOpen.getControlPanel())));

        buttonopenFromOrbit.setActionRichTooltip(new RichTooltip("Open Image", "Open an image from image serve or local file system."));
        buttonopenFromOrbit.addActionListener(oia == null ? null : oia.openFileOrbitActionListener);
        imageBandOpen.addCommandButton(buttonopenFromOrbit, RibbonElementPriority.TOP);

        JRibbonBand imageBandOpenSpecial = new JRibbonBand("Open Special", null);
        imageBandOpenSpecial.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(imageBandOpenSpecial.getControlPanel())));


        JCommandButton buttonImg1 = new JCommandButton("View Overview (CTRL-O)", new SlidepreviewNoLoupe6());
        buttonImg1.setActionRichTooltip(new RichTooltip("View Overview", "Load the whole-slide overview. Only available if the image stems from a whole slide scanner."));
        buttonImg1.addActionListener(oia == null ? null : oia.loadOverviewActionListener);
        imageBandOpenSpecial.addCommandButton(buttonImg1, RibbonElementPriority.TOP);

        JCommandButton buttonImg2 = new JCommandButton("Open Spot Detection", new DocumentOpen5());
        buttonImg2.setActionRichTooltip(new RichTooltip("Load Image for TMA Spot Detection", "Load a special resolution image on which the TMA spot detection can be performed."));
        buttonImg2.addActionListener(oia == null ? null : oia.loadTMAThumbnailActionListener);
        imageBandOpenSpecial.addCommandButton(buttonImg2, RibbonElementPriority.TOP);

        JCommandButton buttonImg3 = new JCommandButton("Open Resolution for Printing", new DocumentOpen5());
        buttonImg3.setActionRichTooltip(new RichTooltip("Load Printing Resolution", "Load a medium size resolution which is suitable for printing."));
        buttonImg3.addActionListener(oia == null ? null : oia.loadMediumResolutionActionListener);
        imageBandOpenSpecial.addCommandButton(buttonImg3, RibbonElementPriority.TOP);


        JCommandButton buttonImgSpecialResolution = new JCommandButton("Open Special Resolution", new DocumentOpen5());
        RichTooltip richTooltipSpecialResolution = new RichTooltip("Load Special Resolution", "Load a special resolution of the image.");
        richTooltipSpecialResolution.addDescriptionSection("Each successor resolution has half the size in each dimension as the parent resolution.");
        buttonImgSpecialResolution.setActionRichTooltip(richTooltipSpecialResolution);
        imageBandOpenSpecial.addCommandButton(buttonImgSpecialResolution, RibbonElementPriority.TOP);
        buttonImgSpecialResolution.setCommandButtonKind(JCommandButton.CommandButtonKind.POPUP_ONLY);

        buttonImgSpecialResolution.setPopupCallback(new PopupPanelCallback() {
            @Override
            public JPopupPanel getPopupPanel(JCommandButton jCommandButton) {
                return getSpecialResolutionPopupPanel();
            }
        });


        // save as .orbit
        JRibbonBand saveAsOrbitBand = new JRibbonBand("Save", null);
        saveAsOrbitBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(saveAsOrbitBand.getControlPanel())));
        JCommandButton buttonSaveAsOrbit = new JCommandButton("Save image links as .orbit", new DocumentSaveAs3());
        RichTooltip richTooltipSaveAsOrbit = new RichTooltip("Save image links as .orbit", "Saves all open images as links in a .orbit file.");
        richTooltipSaveAsOrbit.addDescriptionSection("Can be used to save or email an interesting image set.");
        buttonSaveAsOrbit.setActionRichTooltip(richTooltipSaveAsOrbit);
        buttonSaveAsOrbit.addActionListener(oia == null ? null : oia.saveAsOrbitActionListener);
        saveAsOrbitBand.addCommandButton(buttonSaveAsOrbit, RibbonElementPriority.TOP);

        JRibbonBand switchImageProviderBand = getSwitchImageProviderBand();

        RibbonTask imageTask = new RibbonTask("Image", imageBandOpen, imageBandOpenSpecial, saveAsOrbitBand, switchImageProviderBand);
        ribbon.addTask(imageTask);
    }


    private void addEditTask(final JRibbon ribbon) {

        JRibbonBand copyBand = new JRibbonBand("Copy", null);
        copyBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(copyBand.getControlPanel()),
                new CoreRibbonResizePolicies.Mirror(copyBand.getControlPanel()),
                new CoreRibbonResizePolicies.Mid2Low(copyBand.getControlPanel()),
                new IconRibbonBandResizePolicy(copyBand.getControlPanel())));

        JCommandButton buttonCopyImageCurrentView = new JCommandButton("Copy Image (Current View)", new EditCopy4());
        buttonCopyImageCurrentView.setActionRichTooltip(new RichTooltip("Copy Image (Current View)", "Copies the current view exactly as you see it in the image frame into the clipboard."));
        buttonCopyImageCurrentView.addActionListener(oia == null ? null : oia.copyImageCurrentViewActionHandler);
        copyBand.addCommandButton(buttonCopyImageCurrentView, RibbonElementPriority.TOP);


        JCommandButton buttonCopyOrbitLink = new JCommandButton("Copy Orbit Link", new EditCopy4());
        buttonCopyOrbitLink.setActionRichTooltip(new RichTooltip("Copy Orbit Link", "Copies a file with an Orbit link into the clipboard."));
        buttonCopyOrbitLink.addActionListener(oia == null ? null : oia.copyOrbitListActionHandler);
        copyBand.addCommandButton(buttonCopyOrbitLink, RibbonElementPriority.MEDIUM);

        JCommandButton buttonCopyImageFull = new JCommandButton("Copy Image (Full)", new EditCopy4());
        RichTooltip toolTip = new RichTooltip("Copy Image (Full)", "Copies the original full-size image (without markup) into the clipboard.");
        toolTip.addDescriptionSection("This only works for small images. For large images, please use Copy Image (Current View) instead.");
        buttonCopyImageFull.setActionRichTooltip(toolTip);
        buttonCopyImageFull.addActionListener(oia == null ? null : oia.copyImageFullActionHandler);
        copyBand.addCommandButton(buttonCopyImageFull, RibbonElementPriority.MEDIUM);


        JRibbonBand pasteBand = new JRibbonBand("Paste", null);
        JCommandButton buttonPaste = new JCommandButton("Paste", new EditPaste4());
        buttonPaste.setActionRichTooltip(new RichTooltip("Paste", "Inserts an image from the clipboard."));
        buttonPaste.addActionListener(oia == null ? null : oia.pasteActionHandler);
        pasteBand.addCommandButton(buttonPaste, RibbonElementPriority.TOP);
        pasteBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(pasteBand.getControlPanel())));

        RibbonTask editTask = new RibbonTask("Edit", copyBand, pasteBand);
        ribbon.addTask(editTask);

    }

    private void addModelTask(final JRibbon ribbon) {

        JRibbonBand modelOpenBand = new JRibbonBand("Open", null);
        modelOpenBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(modelOpenBand.getControlPanel())));

        JCommandButton buttonModelOpenOrbit = new JCommandButton("Open Model from Server", new DocumentOpen5());
        buttonModelOpenOrbit.setActionRichTooltip(new RichTooltip("Open Model from Server", "Load an existing model from Server."));
        buttonModelOpenOrbit.addActionListener(oia == null ? null : oia.openModelOrbitActionListener);
        modelOpenBand.addCommandButton(buttonModelOpenOrbit, RibbonElementPriority.TOP);

        JCommandButton buttonModelOpen = new JCommandButton("Open Model", new DocumentOpen5());
        buttonModelOpen.setActionRichTooltip(new RichTooltip("Open Model", "Load an existing .omo model file."));
        buttonModelOpen.addActionListener(oia == null ? null : oia.openModelActionListener);
        modelOpenBand.addCommandButton(buttonModelOpen, RibbonElementPriority.TOP);

        JCommandButton buttonModelRestoreClassShapes = new JCommandButton("Restore Training Shapes", new RestoreShapes());
        buttonModelRestoreClassShapes.setActionRichTooltip(new RichTooltip("Restore Training Shapes", "Open images used for training and restore training shapes."));
        buttonModelRestoreClassShapes.addActionListener(oia == null ? null : oia.restoreClassShapesActionListener);
        modelOpenBand.addCommandButton(buttonModelRestoreClassShapes, RibbonElementPriority.TOP);


        JRibbonBand modelSaveBand = new JRibbonBand("Save", null);

        JCommandButton buttonSaveModelOrbit = new JCommandButton("Save Model on Server", new DocumentSave3());
        buttonSaveModelOrbit.setActionRichTooltip(new RichTooltip("Save Model on Server", "Save active model on Server."));
        buttonSaveModelOrbit.addActionListener(oia == null ? null : oia.saveModelOrbitActionListener);
        modelSaveBand.addCommandButton(buttonSaveModelOrbit, RibbonElementPriority.TOP);

        JCommandButton buttonSaveModel = new JCommandButton("Save Model as...", new DocumentSave3());
        buttonSaveModel.setActionRichTooltip(new RichTooltip("Save Model as...", "Save active model as a .omo file."));
        buttonSaveModel.addActionListener(oia == null ? null : oia.saveModelAsActionListener);
        modelSaveBand.addCommandButton(buttonSaveModel, RibbonElementPriority.TOP);

        JCommandButton buttonSaveExclusionModel = new JCommandButton("Save Nested Exclusion Model as...", new DocumentSave3());
        buttonSaveExclusionModel.setActionRichTooltip(new RichTooltip("Save nested exclusion model as...", "Save nested exclusion model as a .omo file."));
        buttonSaveExclusionModel.addActionListener(oia == null ? null : oia.saveNestedExclusionModelActionListener);
        modelSaveBand.addCommandButton(buttonSaveExclusionModel, RibbonElementPriority.MEDIUM);

        JCommandButton buttonSaveSegmentationModel = new JCommandButton("Save Nested Segmentation Model as...", new DocumentSave3());
        buttonSaveSegmentationModel.setActionRichTooltip(new RichTooltip("Save nested segmentation model as...", "Save nested segmentation model as a .omo file."));
        buttonSaveSegmentationModel.addActionListener(oia == null ? null : oia.saveNestedSegmentationModelActionListener);
        modelSaveBand.addCommandButton(buttonSaveSegmentationModel, RibbonElementPriority.MEDIUM);

        modelSaveBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(modelSaveBand.getControlPanel()),
                new CoreRibbonResizePolicies.Mirror(modelSaveBand.getControlPanel()),
                new CoreRibbonResizePolicies.Mid2Low(modelSaveBand.getControlPanel()),
                new IconRibbonBandResizePolicy(modelSaveBand.getControlPanel())));


        JRibbonBand modelConfigureBand = new JRibbonBand("Configure", null);

        JCommandButton buttonConfigureClasses = new JCommandButton("Classes (F4)", new Configure4());
        buttonConfigureClasses.setActionRichTooltip(new RichTooltip("Configure Classes (F4)", "Define the set of classes for classification."));
        buttonConfigureClasses.addActionListener(oia == null ? null : oia.configClassActionListener);
        modelConfigureBand.addCommandButton(buttonConfigureClasses, RibbonElementPriority.TOP);

        JCommandButton buttonConfigureFeatures = new JCommandButton("Features (F3)", new PreferencesDesktop2());
        buttonConfigureFeatures.setActionRichTooltip(new RichTooltip("Configure Features (F3)", "Configure the settings for classification and segmentation."));
        buttonConfigureFeatures.addActionListener(oia == null ? null : oia.configureFeaturesActionListener);
        modelConfigureBand.addCommandButton(buttonConfigureFeatures, RibbonElementPriority.TOP);

        JCommandButton buttonConfigureFuzzyness = new JCommandButton("Fuzzyness (F2)", new Configure4());
        RichTooltip richTooltipFuzzyness = new RichTooltip("Configure Fuzzyness (F2)", "Set the pixel- and tile-probabilities.");
        richTooltipFuzzyness.addDescriptionSection("The higher the fuzzyness for pixels or tiles, the faster, but less accurate, the classification. Can be used to speedup test classifications.");
        buttonConfigureFuzzyness.setActionRichTooltip(richTooltipFuzzyness);
        buttonConfigureFuzzyness.addActionListener(oia == null ? null : oia.configureFuzzynessActionListener);
        modelConfigureBand.addCommandButton(buttonConfigureFuzzyness, RibbonElementPriority.MEDIUM);

        addExclusionParameterButton(modelConfigureBand, RibbonElementPriority.MEDIUM);

        modelConfigureBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(modelConfigureBand.getControlPanel()),
                new CoreRibbonResizePolicies.Mirror(modelConfigureBand.getControlPanel()),
                new CoreRibbonResizePolicies.Mid2Low(modelConfigureBand.getControlPanel()),
                new IconRibbonBandResizePolicy(modelConfigureBand.getControlPanel())));


        JRibbonBand modelPerformClustering = new JRibbonBand("Clustering", null);
        JCommandToggleButton buttonClustering = new JCommandToggleButton("Perform Clustering", new Clustering());
        RichTooltip richTooltipClustering = new RichTooltip("Perform clustering instead of segmentation", "If activated, the defined training regions will be ignored. A clustering will be performed instead of the classification");
        buttonClustering.setActionRichTooltip(richTooltipClustering);
        buttonClustering.addActionListener(oia == null ? null : oia.performClusteringActionListener);
        buttonClustering.setBackground(Color.white);
        modelPerformClustering.addCommandButton(buttonClustering, RibbonElementPriority.TOP);
        modelPerformClustering.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(modelPerformClustering.getControlPanel())));

        JRibbonBand modelResetBand = createResetModelBand(true);


        RibbonTask modelTask = new RibbonTask("Model", modelOpenBand, modelSaveBand, modelConfigureBand, modelPerformClustering, modelResetBand);
        ribbon.addTask(modelTask);

    }

    private void addExclusionParameterButton(JRibbonBand modelConfigureBand, RibbonElementPriority priority) {
        JCommandButton buttonConfigureExclusionParameters = new JCommandButton("Exclusion Model Level", new Configure4());
        RichTooltip richTooltipExclusion = new RichTooltip("Configure Exclusion Model Level", "Set the detail level used for the exclusion model.");
        richTooltipExclusion.addDescriptionSection("Set to 1 for a standard exclusion model. Set it to 2 for a more fine grained exclusion model. This can help to detect more details in the exclusion model, but has the drawback to be a more specific and less general exclusion model");
        richTooltipExclusion.addDescriptionSection("The fine grained model (2) is also much slower than the standard model (1).");
        buttonConfigureExclusionParameters.setActionRichTooltip(richTooltipExclusion);
        buttonConfigureExclusionParameters.addActionListener(oia == null ? null : oia.configureExclusionParametersActionListener);
        modelConfigureBand.addCommandButton(buttonConfigureExclusionParameters, priority);
    }


    private JRibbonBand createResetModelBand(boolean withSegmentation) {
        JRibbonBand modelResetBand = new JRibbonBand("Reset", null);

        JCommandButton buttonResetMainModel = new JCommandButton("Main Model", new EditClear3());
        RichTooltip richTooltipResetMainModel = new RichTooltip("Reset Main Model", "Reset the main model. Nested models like the segmentation model or exclusion model will still be valid and available.");
        richTooltipResetMainModel.addDescriptionSection("After a segmentation this can be used to train a cell classification model (then the nested segmentaiton model will still be active).");
        buttonResetMainModel.setActionRichTooltip(richTooltipResetMainModel);
        buttonResetMainModel.addActionListener(oia == null ? null : oia.resetMainModelActionListener);
        modelResetBand.addCommandButton(buttonResetMainModel, RibbonElementPriority.MEDIUM);

        if (withSegmentation) {
            modelResetBand.addCommandButton(createDeleteSegmentationModelButton(), RibbonElementPriority.MEDIUM);
            modelResetBand.addCommandButton(createDeleteSecondarySegmentationModelButton(), RibbonElementPriority.MEDIUM);
        }

        JCommandButton buttonResetEntireModel = new JCommandButton("Entire Model", new EditDelete3());
        RichTooltip richTooltipResetEntireModel = new RichTooltip("Reset Entire Model", "Reset the entire model. The complete model will be removed. Afterwards, you can start from scratch with a new model.");
        buttonResetEntireModel.setActionRichTooltip(richTooltipResetEntireModel);
        buttonResetEntireModel.addActionListener(oia == null ? null : oia.resetEntireModelActionListener);
        modelResetBand.addCommandButton(buttonResetEntireModel, RibbonElementPriority.MEDIUM);

        modelResetBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(modelResetBand.getControlPanel()),
                new CoreRibbonResizePolicies.Mirror(modelResetBand.getControlPanel()),
                new IconRibbonBandResizePolicy(modelResetBand.getControlPanel())));
        return modelResetBand;
    }


    private JCommandButton createDeleteSecondarySegmentationModelButton() {
        JCommandButton buttonResetSecondarySegmentationModel = new JCommandButton("Secondary Segmentation Model", new ClearSecSegModel());
        RichTooltip richTooltipResetSecondarySegmentationModel = new RichTooltip("Reset Secondary Segmentation Model", "Reset the secondary segmentation model.");
        richTooltipResetSecondarySegmentationModel.addDescriptionSection("The primary segmentation model will still be available. A new secondary segmentation model can be defined and set.");
        buttonResetSecondarySegmentationModel.setActionRichTooltip(richTooltipResetSecondarySegmentationModel);
        buttonResetSecondarySegmentationModel.addActionListener(oia == null ? null : oia.resetSecondarySegmentationModelActionListener);
        return buttonResetSecondarySegmentationModel;
    }

    private JCommandButton createDeleteSegmentationModelButton() {
        JCommandButton buttonResetSegmentationModel = new JCommandButton("Primary Segmentation Model", new EditDelete6());
        RichTooltip richTooltipResetSegmentationModel = new RichTooltip("Reset Segmentation Model", "Reset the segmentation model.");
        richTooltipResetSegmentationModel.addDescriptionSection("Remove the segmentation model. The main model will still be available.");
        richTooltipResetSegmentationModel.addDescriptionSection("An existing secondary segmentation model will not be removed.");
        buttonResetSegmentationModel.setActionRichTooltip(richTooltipResetSegmentationModel);
        buttonResetSegmentationModel.addActionListener(oia == null ? null : oia.resetSegmentationModelActionListener);
        return buttonResetSegmentationModel;
    }

    private JCommandButton createDefineROIButton() {
        JCommandButton buttonDefineRoi = new JCommandButton("Define ROI", new DrawRoi2());
        RichTooltip richTooltipDefineRoi = new RichTooltip("Define Region of Interest", "Draw a polygon to define the ROI for operations like classification or segmentation.");
        richTooltipDefineRoi.addDescriptionSection("Defines only a temporary ROI. For a permanent ROI please use annotations, which are stored in the database.");
        richTooltipDefineRoi.addDescriptionSection("Use the ROI menu for more options, e.g. invert or reset the ROI.");
        buttonDefineRoi.setActionRichTooltip(richTooltipDefineRoi);
        buttonDefineRoi.addActionListener(oia == null ? null : oia.selectROIActionListener);
        return buttonDefineRoi;
    }


    private void addROITask(final JRibbon ribbon) {

        JRibbonBand roiBand = new JRibbonBand("Region Of Interest", null);
        roiBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(roiBand.getControlPanel()),
                new CoreRibbonResizePolicies.Mid2Low(roiBand.getControlPanel()),
                new IconRibbonBandResizePolicy(roiBand.getControlPanel())));

        roiBand.addCommandButton(createDefineROIButton(), RibbonElementPriority.TOP);

        JCommandButton buttonResetRoi = new JCommandButton("Reset", new EditClear3());
        RichTooltip richTooltipResetRoi = new RichTooltip("Reset Region of Interest", "Reset the temporary ROI.");
        richTooltipResetRoi.addDescriptionSection("After resetting the ROI either the whole image is taken into account, or the ROI defined by annotations (if available).");
        buttonResetRoi.setActionRichTooltip(richTooltipResetRoi);
        buttonResetRoi.addActionListener(oia == null ? null : oia.resetROIActionListener);
        roiBand.addCommandButton(buttonResetRoi, RibbonElementPriority.TOP);

        JCommandButton buttonInvertRoi = new JCommandButton("Invert", new DrawRoi2Inverted());
        RichTooltip richTooltipInvertRoi = new RichTooltip("Invert Region of Interest", "Invert the temporary ROI.");
        richTooltipInvertRoi.addDescriptionSection("Inside and outside of ROI are switched afterwards.");
        buttonInvertRoi.setActionRichTooltip(richTooltipInvertRoi);
        buttonInvertRoi.addActionListener(oia == null ? null : oia.invertROIActionListener);
        roiBand.addCommandButton(buttonInvertRoi, RibbonElementPriority.MEDIUM);

        JCommandButton buttomComputeRoi = new JCommandButton("Measure Area", new Lineal());
        RichTooltip richTooltipComputeRoi = new RichTooltip("Measure ROI Area", "Measure the area of the ROI (ROI + exclusion model). ");
        richTooltipComputeRoi.addDescriptionSection("If an exclusion model is active, it will be taken into account as well.");
        buttomComputeRoi.setActionRichTooltip(richTooltipComputeRoi);
        buttomComputeRoi.addActionListener(oia == null ? null : oia.computeROIAreaActionListener);
        roiBand.addCommandButton(buttomComputeRoi, RibbonElementPriority.MEDIUM);


        JRibbonBand specialBand = new JRibbonBand("Special ROIs", null);
        specialBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(specialBand.getControlPanel()),
                new CoreRibbonResizePolicies.Mid2Low(specialBand.getControlPanel())));

        JCommandButton buttonSegmentationRoi = new JCommandButton("Segmentation as ROI", new Segmentation());
        RichTooltip richTooltipSegmentationRoi = new RichTooltip("Segmentation as ROI", "Use segmentation result as ROI.");
        buttonSegmentationRoi.setActionRichTooltip(richTooltipSegmentationRoi);
        buttonSegmentationRoi.addActionListener(oia == null ? null : oia.segmentationROIActionListener);
        specialBand.addCommandButton(buttonSegmentationRoi, RibbonElementPriority.MEDIUM);

        RibbonTask roiTask = new RibbonTask("ROI", roiBand, specialBand);
        ribbon.addTask(roiTask);
    }


    private void addDrawButtons(final JRibbonBand band, boolean ownBand) {
        JCommandButton buttonEraser = new JCommandButton("Eraser", new LmproulxEraser());
        buttonEraser.setActionRichTooltip(new RichTooltip("Eraser", "Click into a shape on an image to erase it."));
        buttonEraser.addActionListener(oia == null ? null : oia.deleteActionListener);
        band.addCommandButton(buttonEraser, RibbonElementPriority.TOP);

        JCommandButton buttonDrawPolygon = new JCommandButton("Polygon", new DrawPoly());
        makeMandatory(buttonDrawPolygon);
        buttonDrawPolygon.setActionRichTooltip(new RichTooltip("Polygon", "Draw a polygon. When you release the mouse button, the polygon will be closed."));
        buttonDrawPolygon.addActionListener(oia == null ? null : oia.brushActionListener);
        band.addCommandButton(buttonDrawPolygon, RibbonElementPriority.TOP);

        JCommandButton buttonDrawCircle = new JCommandButton("Circle", new DrawCircle());
        buttonDrawCircle.setActionRichTooltip(new RichTooltip("Circle", "Draw a circle. Use the mouse-wheel to adjust the size."));
        buttonDrawCircle.addActionListener(oia == null ? null : oia.circleActionListener);
        band.addCommandButton(buttonDrawCircle, ownBand ? RibbonElementPriority.MEDIUM : RibbonElementPriority.TOP);

        JCommandButton buttonDrawRectangle = new JCommandButton("Rectangle", new DrawRectangle());
        buttonDrawRectangle.setActionRichTooltip(new RichTooltip("Rectangle", "Draw a rectangle."));
        buttonDrawRectangle.addActionListener(oia == null ? null : oia.rectangleActionListener);
        band.addCommandButton(buttonDrawRectangle, ownBand ? RibbonElementPriority.MEDIUM : RibbonElementPriority.TOP);
    }


    private JRibbonBand createDrawBand() {
        JRibbonBand drawBand = new JRibbonBand("Draw", null);
        drawBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(drawBand.getControlPanel()),
                new CoreRibbonResizePolicies.Mid2Low(drawBand.getControlPanel()),
                new IconRibbonBandResizePolicy(drawBand.getControlPanel())));
        addDrawButtons(drawBand, true);

        return drawBand;
    }


    private JRibbonComponent createSizeComponent() {
        JComboBox sizeBox = getSizeCombobox();
        sizeBox.setPreferredSize(new Dimension(sizeBox.getPreferredSize().width / 3, sizeBox.getPreferredSize().height));
        return new JRibbonComponent(sizeBox);
    }


    private void addTrainClassifyButtons(final JRibbonBand band) {
        JCommandButton buttonTrain = new JCommandButton("Train (F7)", new Training());
        makeMandatory(buttonTrain);
        RichTooltip richTooltipTrain = new RichTooltip("Train Model", "Train a model based on the class shapes drawn in the images.");
        richTooltipTrain.addDescriptionSection("The class shapes from all open images are taken into account.");
        buttonTrain.setActionRichTooltip(richTooltipTrain);
        buttonTrain.addActionListener(oia == null ? null : oia.trainActionListener);
        band.addCommandButton(buttonTrain, RibbonElementPriority.TOP);

        band.addCommandButton(createDefineROIButton(), RibbonElementPriority.TOP);

        JCommandButton buttonClassify = new JCommandButton("Classify (F8)", new ApplicationsGraphics2());
        makeMandatory(buttonClassify);
        RichTooltip richTooltipClassify = new RichTooltip("Classify Image", "Classify the active image based on a trained model.");
        richTooltipClassify.addDescriptionSection("If no ROI is active, the whole image will be classified, otherwise only the region inside the ROI.");
        richTooltipClassify.addDescriptionSection("A ROI can be defined with the ROI tool, annotations or an exclusion model.");
        richTooltipClassify.addDescriptionSection("Use the Batch menu to classify a set of images in batch mode.");
        buttonClassify.setActionRichTooltip(richTooltipClassify);
        buttonClassify.addActionListener(oia == null ? null : oia.classifyActionListener);
        buttonClassify.setBackground(Color.magenta);
        band.addCommandButton(buttonClassify, RibbonElementPriority.TOP);
    }

    private RibbonTask createClassificationTask() {

        JRibbonBand setupBand = new JRibbonBand("Setup", null);
        setupBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(setupBand.getControlPanel())));

        JCommandButton buttonSetupClasses = new JCommandButton("Setup Classes", new SystemRun5());
        makeMandatory(buttonSetupClasses);
        RichTooltip richTooltipSetupClasses = new RichTooltip("Setup Classes", "Setup default classes for a main model.");
        buttonSetupClasses.addActionListener(oia == null ? null : oia.setupClassesMainModelActionListener);
        buttonSetupClasses.setActionRichTooltip(richTooltipSetupClasses);
        setupBand.addCommandButton(buttonSetupClasses, RibbonElementPriority.MEDIUM);


        JRibbonBand drawBand = createDrawBand();

        JRibbonBand mlBand = new JRibbonBand("Machine Learning", null);
        mlBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(mlBand.getControlPanel()),
                new CoreRibbonResizePolicies.Mid2Low(mlBand.getControlPanel()),
                new IconRibbonBandResizePolicy(mlBand.getControlPanel())));

        addTrainClassifyButtons(mlBand);

        JRibbonBand modelResetBand = createResetModelBand(false);

        RibbonTask classificationTask = new RibbonTask("Classification", setupBand, drawBand, mlBand, modelResetBand);
        return classificationTask;

    }


    private RibbonTask createObjectTask() {

        JRibbonBand classifyBand = new JRibbonBand("Define Foreground / Background", null);
        classifyBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(classifyBand.getControlPanel()),
                new CoreRibbonResizePolicies.Mid2Low(classifyBand.getControlPanel()),
                new IconRibbonBandResizePolicy(classifyBand.getControlPanel())));


        JCommandButton buttonSetupClassesObjectSegmentation = new JCommandButton("Setup Classes", new SystemRun5());
        makeMandatory(buttonSetupClassesObjectSegmentation);
        RichTooltip richTooltipSetupObjectSegmentation = new RichTooltip("Setup Classes for Object Segmentation", "Reset the main model and setup pre-defined classes for object segmentation.");
        richTooltipSetupObjectSegmentation.addDescriptionSection("Use the class configuration dialog to modify the classes, e.g. rename or add further classes which can be used as different types of background.)");
        buttonSetupClassesObjectSegmentation.setActionRichTooltip(richTooltipSetupObjectSegmentation);
        buttonSetupClassesObjectSegmentation.addActionListener(oia == null ? null : oia.setupClassesForObjectSegmentation);
        classifyBand.addCommandButton(buttonSetupClassesObjectSegmentation, RibbonElementPriority.TOP);

        addDrawButtons(classifyBand, false);
        addTrainClassifyButtons(classifyBand);


        JRibbonBand segmentationBand = new JRibbonBand("Object Segmentation", null);
        segmentationBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(segmentationBand.getControlPanel()),
                new CoreRibbonResizePolicies.Mid2Low(segmentationBand.getControlPanel()),
                new IconRibbonBandResizePolicy(segmentationBand.getControlPanel())));


        JCommandButton buttonSetAsPrimarySegmentation = new JCommandButton("Set Primary Segmentation Model", new PrimarySeg());
        makeMandatory(buttonSetAsPrimarySegmentation);
        RichTooltip richTooltipSetAsPrimarySegmentation = new RichTooltip("Set as Segmentation Model", "Set the current model as primary segmentation model.");
        richTooltipSetAsPrimarySegmentation.addDescriptionSection("Apply this function after training a background/foreground segmentation model and before performing a segmentation.");
        richTooltipSetAsPrimarySegmentation.addDescriptionSection("The first class must be the background, the second class the foreground (objects to segment). Further classes may follow which will be seen as different kind of backgrounds.");
        buttonSetAsPrimarySegmentation.setActionRichTooltip(richTooltipSetAsPrimarySegmentation);
        buttonSetAsPrimarySegmentation.addActionListener(oia == null ? null : oia.setCurrentModelAsSegmentationActionListener);
        segmentationBand.addCommandButton(buttonSetAsPrimarySegmentation, RibbonElementPriority.TOP);

        JCommandButton buttonSetAsSecondarySegmentation = new JCommandButton("Set Secondary Segmentation Model", new SecondarySeg());
        RichTooltip richTooltipSetAsSecondarySegmentation = new RichTooltip("Set as Segmentation Model", "Set the current model as secondary segmentation model.");
        richTooltipSetAsSecondarySegmentation.addDescriptionSection("A secondary segmentation model can be used to perform a segmentation inside objects segmented by a primary segmentation model.");
        richTooltipSetAsSecondarySegmentation.addDescriptionSection("Use it to detect e.g. spots inside nuclei.");
        buttonSetAsSecondarySegmentation.setActionRichTooltip(richTooltipSetAsSecondarySegmentation);
        buttonSetAsSecondarySegmentation.addActionListener(oia == null ? null : oia.setCurrentModelAsSecondarySegmentationActionListener);
        segmentationBand.addCommandButton(buttonSetAsSecondarySegmentation, RibbonElementPriority.TOP);


        JCommandButton buttonConfigureFeatures = new JCommandButton("Features (F3)", new PreferencesDesktop2());
        buttonConfigureFeatures.setActionRichTooltip(new RichTooltip("Configure Features (F3)", "Configure the settings for classification and segmentation."));
        buttonConfigureFeatures.addActionListener(oia == null ? null : oia.configureFeaturesSegmentationActionListener);
        segmentationBand.addCommandButton(buttonConfigureFeatures, RibbonElementPriority.TOP);


        segmentationBand.addCommandButton(createDefineROIButton(), RibbonElementPriority.TOP);

        JCommandButton buttonSegmentation = new JCommandButton("Object Segmentation", new Segmentation());
        makeMandatory(buttonSegmentation);
        RichTooltip richTooltipSegmentation = new RichTooltip("Object Segmentation", "Perform an object segmentation. Foreground objects will be segmented as objects, e.g. cells.");
        richTooltipSegmentation.addDescriptionSection("The requirement for this is a trained background/foreground classification model which is 'set as segmentation model'.");
        richTooltipSegmentation.addDescriptionSection("The result of a segmentation is the number of objects. In addition, together with 'feature classes' configured in the feature configuration, the features (e.g area size, intensities) can be measured per object.");
        richTooltipSegmentation.addDescriptionSection("The object segmentation can be followed by an object classification, to differentiate between arbitrary object types (e.g. stained cells versus unstained cells).");
        buttonSegmentation.setActionRichTooltip(richTooltipSegmentation);
        buttonSegmentation.addActionListener(oia == null ? null : oia.objectSegmentationActionListener);
        buttonSegmentation.setBackground(Color.magenta);
        segmentationBand.addCommandButton(buttonSegmentation, RibbonElementPriority.TOP);

        JCommandToggleButton buttonSegmentationHeatmap = new JCommandToggleButton("Show Segmentation Heatmap (Area)", new ObjHeatmap());
        buttonSegmentationHeatmap.setBackground(Color.white);
        //buttonSegmentationHeatmap.setSelectedIcon(new ObjHeatmapSelected());
        RichTooltip richTooltipSegmentationHeatmap = new RichTooltip("Show Segmentation Size Heatmap", "Colors the segmented objects in heatmap colors, based on their areas.");
        richTooltipSegmentationHeatmap.addDescriptionSection("This affects the visual result of the segmentation. Perform an object segmentation to see the results.");
        buttonSegmentationHeatmap.setActionRichTooltip(richTooltipSegmentationHeatmap);
        buttonSegmentationHeatmap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oia.setShowObjectHeatmap(!oia.isShowObjectHeatmap());
                OrbitModel model = oia.getModel();
                if (model == null || model.getFeatureDescription().getFeatureClasses() == null || model.getFeatureDescription().getFeatureClasses().length == 0) {
                    JOptionPane.showMessageDialog(oia, "Currently no feature classes are active.\nThe heatmap will only be shown if at least one feature class is active.\nYou can configure the feature classes in the Feature Configuration (F3), tab Classification.", "No Feature Classes active", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        segmentationBand.addCommandButton(buttonSegmentationHeatmap, RibbonElementPriority.MEDIUM);

        JCommandButton btn = createDeleteSegmentationModelButton();
        btn.setText("Reset Primary Segmentation Model");
        segmentationBand.addCommandButton(btn, RibbonElementPriority.MEDIUM);


        JCommandButton btn2 = createDeleteSecondarySegmentationModelButton();
        btn2.setText("Reset Secondary Segmentation Model");
        segmentationBand.addCommandButton(btn2, RibbonElementPriority.MEDIUM);


        JRibbonBand classificationBand = new JRibbonBand("Object Classification", null);
        classificationBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(classificationBand.getControlPanel()),
                new CoreRibbonResizePolicies.Mid2Low(classificationBand.getControlPanel()),
                new IconRibbonBandResizePolicy(classificationBand.getControlPanel())));


        JCommandButton buttonSetupClassesObjectClassification = new JCommandButton("Setup Classes", new SystemRun5());
        makeMandatory(buttonSetupClassesObjectClassification);
        RichTooltip richTooltipSetupObjectClassification = new RichTooltip("Setup Classes for Object Classification", "Reset the main model and setup pre-defined classes for object classification.");
        richTooltipSetupObjectClassification.addDescriptionSection("Use the class configuration dialog to modify the classes, e.g. rename or add further object types.)");
        buttonSetupClassesObjectClassification.setActionRichTooltip(richTooltipSetupObjectClassification);
        buttonSetupClassesObjectClassification.addActionListener(oia == null ? null : oia.setupClassesForObjectClassification);
        classificationBand.addCommandButton(buttonSetupClassesObjectClassification, RibbonElementPriority.TOP);


        JCommandButton buttonObjClassMarker = new JCommandButton("Object Marker", new CellClassMarker());
        makeMandatory(buttonObjClassMarker);
        RichTooltip richTooltipObjClassMarker = new RichTooltip("Object Marker", "Use this tool to assign a class to objects.");
        richTooltipObjClassMarker.addDescriptionSection("First select a class in the class dropdown box and then click into segmented objects. (A segmentation has to be performed before.)");
        richTooltipObjClassMarker.addDescriptionSection("Afterwards click on 'Train' (objects tab) to learn the differences between objects and on 'Object classification' to classify objects.");
        buttonObjClassMarker.setActionRichTooltip(richTooltipObjClassMarker);
        buttonObjClassMarker.addActionListener(oia == null ? null : oia.cellMarkerActionListener);
        classificationBand.addCommandButton(buttonObjClassMarker, RibbonElementPriority.TOP);


        JCommandButton buttonTrainObjectClassification = new JCommandButton("Train Objects", new ObjectTraining());
        makeMandatory(buttonTrainObjectClassification);
        RichTooltip richTooltipTrainClassification = new RichTooltip("Train Object Classification", "Train an object classification model.");
        richTooltipTrainClassification.addDescriptionSection("Requirements for training an object classification model:");
        richTooltipTrainClassification.addDescriptionSection("1) Perform an object segmentation.");
        richTooltipTrainClassification.addDescriptionSection("2) Reset Main Model (via Model menu).");
        richTooltipTrainClassification.addDescriptionSection("3) Setup classes for different object types.");
        richTooltipTrainClassification.addDescriptionSection("4) Use the Object marker tool to define representative objects per class.");
        richTooltipTrainClassification.addDescriptionSection("After step 1-4 the object classification training can be performed. Use the 'Object Classification' button to run the trained model.");
        buttonTrainObjectClassification.setActionRichTooltip(richTooltipTrainClassification);
        buttonTrainObjectClassification.addActionListener(oia == null ? null : oia.trainCellClassifierActionListener);
        classificationBand.addCommandButton(buttonTrainObjectClassification, RibbonElementPriority.TOP);

        classificationBand.addCommandButton(createDefineROIButton(), RibbonElementPriority.TOP);

        JCommandButton buttonObjClassification = new JCommandButton("Object Classification", new ObjClassification());
        makeMandatory(buttonObjClassification);
        RichTooltip richTooltipObjClasification = new RichTooltip("Object Segmentation", "Perform an object segmentation. Foreground objects will be segmented as objects, e.g. cells.");
        richTooltipObjClasification.addDescriptionSection("The requirement for this is a trained background/foreground classification model which is 'set as segmentation model'.");
        richTooltipObjClasification.addDescriptionSection("The result of a segmentation is the number of objects. In addition, together with 'feature classes' configured in the feature configuration, the features (e.g area size, intensities) can be measured per object.");
        richTooltipObjClasification.addDescriptionSection("The object segmentation can be followed by an object classification, to differentiate between arbitrary object types (e.g. stained cells versus unstained cells).");
        buttonObjClassification.setActionRichTooltip(richTooltipObjClasification);
        buttonObjClassification.addActionListener(oia == null ? null : oia.objectClassificationActionListener);
        classificationBand.addCommandButton(buttonObjClassification, RibbonElementPriority.TOP);


        RibbonTask objectsTask = new RibbonTask("Object Detection", classifyBand, segmentationBand, classificationBand);
        return objectsTask;

    }


    private RibbonTask createExclusionTask() {

        ExclusionModule em = oia == null ? new ExclusionModule() : oia.getExclusionModule();

        JRibbonBand setupBand = new JRibbonBand("Setup", null);
        setupBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(setupBand.getControlPanel())));

        JCommandButton buttonSetupClasses = new JCommandButton(em.getBtnSetupClasses().getText(), new SystemRun5());
        makeMandatory(buttonSetupClasses);
        RichTooltip richTooltipSetupClasses = new RichTooltip("Setup Classes", "Configure two exclusion and two inclusion classes. Further classes can be added later via 'Class Configuration'.");
        buttonSetupClasses.addActionListener(oia == null ? null : em.getBtnSetupClasses().getActionListeners()[0]);
        buttonSetupClasses.setActionRichTooltip(richTooltipSetupClasses);
        setupBand.addCommandButton(buttonSetupClasses, RibbonElementPriority.MEDIUM);


        JRibbonBand exclusionBand = new JRibbonBand("Exclusion", null);
        exclusionBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(exclusionBand.getControlPanel()),
                new CoreRibbonResizePolicies.Mirror(exclusionBand.getControlPanel()),
                new CoreRibbonResizePolicies.Mid2Low(exclusionBand.getControlPanel()),
                new IconRibbonBandResizePolicy(exclusionBand.getControlPanel())));

        JCommandButton buttonConfigureClasses = new JCommandButton(em.getBtnConfigureClasses().getText(), new Configure4());
        RichTooltip richTooltipConfigureClasses = new RichTooltip("Configure Classes", "Define the exclusion and inclusion classes.");
        richTooltipConfigureClasses.addDescriptionSection("Use the dropdown menu in the dialog to set each class as exclusion or inclusion class. You can define any number of classes you want to specify.");
        buttonConfigureClasses.addActionListener(oia == null ? null : em.getBtnConfigureClasses().getActionListeners()[0]);
        buttonConfigureClasses.setActionRichTooltip(richTooltipConfigureClasses);
        exclusionBand.addCommandButton(buttonConfigureClasses, RibbonElementPriority.MEDIUM);

        addExclusionParameterButton(exclusionBand, RibbonElementPriority.MEDIUM);

        JCommandButton buttonTrainSetClassify = new JCommandButton(em.getBtnTrain().getText(), new TrainSetClassify());
        makeMandatory(buttonTrainSetClassify);
        RichTooltip richTooltipTrainSetClassify = new RichTooltip("Train, Set and Classify", "Train an exclusion model based on the class shapes, set it as active exclusion model and classify the active image.");
        richTooltipTrainSetClassify.addDescriptionSection("The training regions can be defined in several open images. After this step, the main model can be removed (Model->Remove Main Model) to continue with a new main model (detail classification).");
        buttonTrainSetClassify.addActionListener(oia == null ? null : em.getBtnTrain().getActionListeners()[0]);
        buttonTrainSetClassify.setActionRichTooltip(richTooltipTrainSetClassify);
        buttonTrainSetClassify.setBackground(Color.magenta);
        exclusionBand.addCommandButton(buttonTrainSetClassify, RibbonElementPriority.TOP);

        JCommandButton buttonLoadAndSet = new JCommandButton(em.getBtnLoad().getText(), new DocumentOpen5());
        RichTooltip richTooltipLoadAndSet = new RichTooltip("Load and Set Exclusion Model (file system)", "Load an existing exclusion model and set it active.");
        richTooltipLoadAndSet.addDescriptionSection("This function can be used to combine a currently active main model (e.g. detail classification) with an existing exclusion model (which has already been saved to file via 'save nested exclusion model').");
        buttonLoadAndSet.addActionListener(oia == null ? null : em.getBtnLoad().getActionListeners()[0]);
        buttonLoadAndSet.setActionRichTooltip(richTooltipLoadAndSet);
        exclusionBand.addCommandButton(buttonLoadAndSet, RibbonElementPriority.MEDIUM);

        JCommandButton buttonLoadAndSetServer = new JCommandButton(em.getBtnLoad().getText(), new DocumentOpen5());
        RichTooltip richTooltipLoadAndSetServer = new RichTooltip("Load and Set Exclusion Model (server)", "Load an existing exclusion model and set it active.");
        richTooltipLoadAndSetServer.addDescriptionSection("This function can be used to combine a currently active main model (e.g. detail classification) with an existing exclusion model (which has already been saved to file via 'save nested exclusion model').");
        buttonLoadAndSetServer.addActionListener(oia == null ? null : em.getBtnLoadServer().getActionListeners()[0]);
        buttonLoadAndSetServer.setActionRichTooltip(richTooltipLoadAndSetServer);
        exclusionBand.addCommandButton(buttonLoadAndSetServer, RibbonElementPriority.MEDIUM);


        JCommandButton buttonClassify = new JCommandButton(em.getBtnClassify().getText(), new ApplicationsGraphics2());
        RichTooltip richTooltipClassify = new RichTooltip("Classify Trained Exclusion Model", "Classify active image using the already trained exclusion model.");
        richTooltipClassify.addDescriptionSection("After training or loading an exclusion model this function can be used to classify further images.");
        buttonClassify.addActionListener(oia == null ? null : em.getBtnClassify().getActionListeners()[0]);
        buttonClassify.setActionRichTooltip(richTooltipClassify);
        buttonClassify.setBackground(Color.magenta);
        exclusionBand.addCommandButton(buttonClassify, RibbonElementPriority.TOP);

        JCommandButton buttonReset = new JCommandButton(em.getBtnReset().getText(), new EditDelete6());
        RichTooltip richTooltipReset = new RichTooltip("Reset Exclusion Model", "Reset the currently active exclusion model. As result the main model has no nested exclusion model.");
        buttonReset.addActionListener(oia == null ? null : em.getBtnReset().getActionListeners()[0]);
        buttonReset.setActionRichTooltip(richTooltipReset);
        exclusionBand.addCommandButton(buttonReset, RibbonElementPriority.MEDIUM);

        JCommandButton buttonHelp = new JCommandButton(em.getBtnHelp().getText(), new SystemHelp3());
        RichTooltip richTooltipHelp = new RichTooltip("Help (Exclusion Model)", "Open the help text for exclusion models.");
        buttonHelp.addActionListener(oia == null ? null : em.getBtnHelp().getActionListeners()[0]);
        buttonHelp.setActionRichTooltip(richTooltipHelp);
        exclusionBand.addCommandButton(buttonHelp, RibbonElementPriority.MEDIUM);


        RibbonTask objectsTask = new RibbonTask("Exclusion Model", setupBand, createDrawBand(), exclusionBand);
        return objectsTask;

    }


    private void addBatchTask(final JRibbon ribbon) {

        JRibbonBand batchExecuteBand = new JRibbonBand("Batch Execute", null);
        batchExecuteBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(batchExecuteBand.getControlPanel()),
                new CoreRibbonResizePolicies.Mirror(batchExecuteBand.getControlPanel()),
                new CoreRibbonResizePolicies.Mid2Low(batchExecuteBand.getControlPanel()),
                new IconRibbonBandResizePolicy(batchExecuteBand.getControlPanel())));

        JCommandButton buttonExecuteLocal = new JCommandButton("Local Execution", new SystemRun3());
        RichTooltip richTooltipExecuteLocal = new RichTooltip("Local Batch Execution", "Schedule a batch execution on the local computer.");
        buttonExecuteLocal.setActionRichTooltip(richTooltipExecuteLocal);
        buttonExecuteLocal.addActionListener(oia == null ? null : oia.batchExportLocalActionListener);
        batchExecuteBand.addCommandButton(buttonExecuteLocal, RibbonElementPriority.TOP);

        RichTooltip richTooltipExecuteGrid = new RichTooltip("Scaleout (Grid/Cluster) Batch Execution", "Schedule a batch execution using a scaleout infrastructure.");
        richTooltipExecuteGrid.addDescriptionSection("Compared to the local execution this execution method has more overhead, but runs in parallel in a distributed environment.");
        richTooltipExecuteGrid.addDescriptionSection("Use it if you have many or very big (e.g. slides) image to analyze.");
        buttonExecuteScaleout.setActionRichTooltip(richTooltipExecuteGrid);
        buttonExecuteScaleout.addActionListener(oia == null ? null : oia.batchExportScaleoutActionListener);
        batchExecuteBand.addCommandButton(buttonExecuteScaleout, RibbonElementPriority.TOP);

        JCommandButton buttonBatchROIAreas = new JCommandButton("ROI Area Computation", new Lineal());
        RichTooltip richTooltipBatchRoiAreas = new RichTooltip("Batch ROI Area computation", "Compute the ROI areas for a set im images.");
        richTooltipBatchRoiAreas.addDescriptionSection("The computation is performed on the local computer.");
        buttonBatchROIAreas.setActionRichTooltip(richTooltipBatchRoiAreas);
        buttonBatchROIAreas.addActionListener(oia == null ? null : oia.roiAreasBatchExportActionListener);
        batchExecuteBand.addCommandButton(buttonBatchROIAreas, RibbonElementPriority.MEDIUM);

        RichTooltip richTooltipRetrieveExistingResults = new RichTooltip("Retrieve Existing Results", "Display existing results form current and previous batch jobs running on the grid.");
        richTooltipRetrieveExistingResults.addDescriptionSection("This function can be used to retrieve results if you closed the program after scheduling a grid batch execution.");
        buttonRetrieveExistingResults.setActionRichTooltip(richTooltipRetrieveExistingResults);
        buttonRetrieveExistingResults.addActionListener(oia == null ? null : oia.retrieveExistingResultsActionListener);
        batchExecuteBand.addCommandButton(buttonRetrieveExistingResults, RibbonElementPriority.MEDIUM);


        //JRibbonBand switchImageProviderBand = getSwitchImageProviderBand();

        RibbonTask objectsTask = new RibbonTask("Batch", batchExecuteBand);
        ribbon.addTask(objectsTask);

    }

    private JRibbonBand getSwitchImageProviderBand() {
        JRibbonBand switchImageProviderBand = new JRibbonBand("Image Provider", null);
        switchImageProviderBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(switchImageProviderBand.getControlPanel()),
                new CoreRibbonResizePolicies.Mirror(switchImageProviderBand.getControlPanel()),
                new CoreRibbonResizePolicies.Mid2Low(switchImageProviderBand.getControlPanel()),
                new IconRibbonBandResizePolicy(switchImageProviderBand.getControlPanel())));

        JCommandButton buttonSwitchLocalRemote = getSwitchImageProviderBtn();
        switchImageProviderBand.addCommandButton(buttonSwitchLocalRemote, RibbonElementPriority.TOP);
        return switchImageProviderBand;
    }

    public synchronized JCommandButton getSwitchImageProviderBtn() {
        if (buttonSwitchLocalRemote==null) {
            buttonSwitchLocalRemote = new JCommandButton("Switch Local / Remote Image Provider", new SystemRun3());
            RichTooltip richTooltipSwitchLocalRemote = new RichTooltip("Switch Local / Remote Image Provider", "Switch local file system / remote image provider.");
            richTooltipSwitchLocalRemote.addDescriptionSection("This can be used to process a set of images stored on the local filesystem.");
            richTooltipSwitchLocalRemote.addDescriptionSection("When in local mode, the quicksearch bar on the left side cannot be used until switched back to remote mode.");
            richTooltipSwitchLocalRemote.addDescriptionSection("Please use batch execution local, the scaleout execution won't work.");
            buttonSwitchLocalRemote.setActionRichTooltip(richTooltipSwitchLocalRemote);
            buttonSwitchLocalRemote.addActionListener(oia == null ? null : oia.switchLocalRemoteImageProvider);
        }
        return buttonSwitchLocalRemote;
    }


    private void addToolsTask(final JRibbon ribbon) {

        JRibbonBand manageFilesBand = new JRibbonBand("Manage Files", null);
        manageFilesBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(manageFilesBand.getControlPanel()),
                new IconRibbonBandResizePolicy(manageFilesBand.getControlPanel())));

        JCommandButton buttonOrbitBrowser = new JCommandButton("Orbit Browser", new BrowserWippAddressBook());
        RichTooltip richTooltipOrbitBrowser = new RichTooltip("Orbit Browser", "Start the Orbit Browser to manage Orbit files.");
        richTooltipOrbitBrowser.addDescriptionSection("Use this tool to rename, move, delete or download files or raw data containers.");
        buttonOrbitBrowser.setActionRichTooltip(richTooltipOrbitBrowser);
        buttonOrbitBrowser.addActionListener(oia == null ? null : oia.orbitBrowserActionListener);
        manageFilesBand.addCommandButton(buttonOrbitBrowser, RibbonElementPriority.TOP);

        JCommandButton buttonDBCleanup = new JCommandButton("DB Cleanup", new SystemRun5());
        RichTooltip richTooltipDBCleanup = new RichTooltip("DB Cleanup", "Cleanup the local database.");
        richTooltipDBCleanup.addDescriptionSection("Database entries (e.g. annotations) for non existing local files will be removed.");
        richTooltipDBCleanup.addDescriptionSection("Warning: Images moved to another folder will have no annotations afterwards!");
        buttonDBCleanup.setActionRichTooltip(richTooltipDBCleanup);
        buttonDBCleanup.addActionListener(oia == null ? null : oia.dbCleanupActionListener);
        manageFilesBand.addCommandButton(buttonDBCleanup, RibbonElementPriority.MEDIUM);


        // save image


        JRibbonBand saveImageBand = new JRibbonBand("Save Image", null);
        saveImageBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(saveImageBand.getControlPanel()),
                // new CoreRibbonResizePolicies.Mirror(saveImageBand.getControlPanel()),
                new IconRibbonBandResizePolicy(saveImageBand.getControlPanel())));

        JCommandButton buttonSaveFullImage = new JCommandButton("Save Full Image", new DocumentSaveAs3());
        RichTooltip richTooltipSaveImage = new RichTooltip("Save Full Image", "Save the full resolution image as tiff image to disk.");
        richTooltipSaveImage.addDescriptionSection("For very large images (e.g. slides) it might be better to use 'save current view' instead which just saves the visible region instead of the whole image.");
        buttonSaveFullImage.setActionRichTooltip(richTooltipSaveImage);
        buttonSaveFullImage.addActionListener(oia == null ? null : oia.saveFullImageActionListener);
        saveImageBand.addCommandButton(buttonSaveFullImage, RibbonElementPriority.TOP);

        JCommandButton buttonSaveCurrentView = new JCommandButton("Save Current View", new DocumentSaveAs3());
        RichTooltip richTooltipSaveCurrentView = new RichTooltip("Save Current View", "Save the current view (incl markup) as tiff image to disk.");
        richTooltipSaveCurrentView.addDescriptionSection("Hint: You can use ALT+C to copy the current view into the clipboard instead of saving it as a file.");
        buttonSaveCurrentView.setActionRichTooltip(richTooltipSaveCurrentView);
        buttonSaveCurrentView.addActionListener(oia == null ? null : oia.saveCurrentViewActionListener);
        saveImageBand.addCommandButton(buttonSaveCurrentView, RibbonElementPriority.TOP);

        JCommandButton buttonSaveClassImage = new JCommandButton("Save Classification Image", new DocumentSaveAs3());
        RichTooltip richTooltipSaveClassImage = new RichTooltip("Save Classification Image", "Save the classification map image to disk.");
        richTooltipSaveClassImage.addDescriptionSection("Use after the classification of an image has finished.");
        buttonSaveClassImage.setActionRichTooltip(richTooltipSaveClassImage);
        buttonSaveClassImage.addActionListener(oia == null ? null : oia.saveClassImageActionListener);
        saveImageBand.addCommandButton(buttonSaveClassImage, RibbonElementPriority.TOP);


        // Extensions

        JRibbonBand extensionsBand = new JRibbonBand("Extensions", null);
        extensionsBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(extensionsBand.getControlPanel()),
                // new CoreRibbonResizePolicies.Mirror(extensionsBand.getControlPanel()),
                // new CoreRibbonResizePolicies.Mid2Low(manageFilesBand.getControlPanel()),
                new IconRibbonBandResizePolicy(extensionsBand.getControlPanel())
        ));

        JCommandToggleButton buttonCellProfiler = new JCommandToggleButton("Cell Profiler", new TabNew6());
        buttonCellProfiler.setBackground(Color.white);
        RichTooltip richTooltipCellProfilerExecutor = new RichTooltip("Cell Profiler", "Show the Cell Profiler module.");
        richTooltipCellProfilerExecutor.addDescriptionSection("Execute a Cell Profiler pipeline taking the defined ROI of images into account.");
        richTooltipCellProfilerExecutor.addDescriptionSection("This requires a local installation of Cell Profiler.");
        buttonCellProfiler.setActionRichTooltip(richTooltipCellProfilerExecutor);
        buttonCellProfiler.addActionListener(oia == null ? null : oia.showCellProfilerActionListener);
        extensionsBand.addCommandButton(buttonCellProfiler, RibbonElementPriority.MEDIUM);

        JCommandToggleButton buttonRareObjectDetection = new JCommandToggleButton("Rare Object Detection", new TabNew6());
        buttonRareObjectDetection.setBackground(Color.white);
        RichTooltip richTooltipRareObjectDetection = new RichTooltip("Rare Object Detection", "Show the Rare Object Detection module.");
        richTooltipRareObjectDetection.addDescriptionSection("Segmented objects are presented in a list. Each object in this list can manually be assigned to a class.");
        buttonRareObjectDetection.setActionRichTooltip(richTooltipRareObjectDetection);
        buttonRareObjectDetection.addActionListener(oia == null ? null : oia.showRareObjectDetectionActionListener);
        extensionsBand.addCommandButton(buttonRareObjectDetection, RibbonElementPriority.MEDIUM);

        JCommandToggleButton buttonNerveDetection = new JCommandToggleButton("Nerve Detection", new TabNew6());
        buttonNerveDetection.setBackground(Color.white);
        RichTooltip richTooltipNerveDetection = new RichTooltip("Nerve Detection", "Show the Nerve Detection module.");
        richTooltipNerveDetection.addDescriptionSection("Detect and classify nerves in e.g. skin biopsy.");
        buttonNerveDetection.setActionRichTooltip(richTooltipNerveDetection);
        buttonNerveDetection.addActionListener(oia == null ? null : oia.showNerveDetectionActionListener);
        extensionsBand.addCommandButton(buttonNerveDetection, RibbonElementPriority.MEDIUM);

        JCommandToggleButton buttonManualClassification = new JCommandToggleButton("Manual Classification", new TabNew6());
        buttonManualClassification.setBackground(Color.white);
        RichTooltip richTooltipManuelClassification = new RichTooltip("Manual Classification", "Show the Manual Classification module.");
        richTooltipManuelClassification.addDescriptionSection("Classify segmented objects manually.");
        buttonManualClassification.setActionRichTooltip(richTooltipManuelClassification);
        buttonManualClassification.addActionListener(oia == null ? null : oia.showManualClassificationActionListener);
        extensionsBand.addCommandButton(buttonManualClassification, RibbonElementPriority.MEDIUM);

        JCommandToggleButton buttonManualBoxCount = new JCommandToggleButton("Manual Box Count", new TabNew6());
        buttonManualBoxCount.setBackground(Color.white);
        RichTooltip richTooltipManualBoxCount = new RichTooltip("Manual Box Count", "Show the Manual Box Count module.");
        richTooltipManualBoxCount.addDescriptionSection("Count manually objects within defined boxes.");
        richTooltipManualBoxCount.addDescriptionSection("This idea is that boxes always define the same area size which can be used to extrapolate an object count.");
        buttonManualBoxCount.setActionRichTooltip(richTooltipManualBoxCount);
        buttonManualBoxCount.addActionListener(oia == null ? null : oia.showManualBoxCountActionListener);
        extensionsBand.addCommandButton(buttonManualBoxCount, RibbonElementPriority.MEDIUM);

        JCommandToggleButton buttonTMASpots = new JCommandToggleButton("TMA Spot Detection", new TabNew6());
        buttonTMASpots.setBackground(Color.white);
        RichTooltip richTooltipTMASpots = new RichTooltip("TMA Spot Detection", "Show the TMA Spot Detection module.");
        richTooltipTMASpots.addDescriptionSection("Automatically create special annotations per TMA spot.");
        richTooltipTMASpots.addDescriptionSection("This defines a plate-like matrix (A01, A02, ...) which can be used to e.g. perform a classification per spot.");
        buttonTMASpots.setActionRichTooltip(richTooltipTMASpots);
        buttonTMASpots.addActionListener(oia == null ? null : oia.showTMASpotModuleActionListener);
        extensionsBand.addCommandButton(buttonTMASpots, RibbonElementPriority.MEDIUM);

        JCommandToggleButton buttonThresholdClassification = new JCommandToggleButton("Threshold Classification", new TabNew6());
        buttonThresholdClassification.setBackground(Color.white);
        RichTooltip richTooltipThresholdClassification = new RichTooltip("Threshold Classification", "Show the Threshold Classification module.");
        richTooltipThresholdClassification.addDescriptionSection("Classification without class shapes. A two-classes classification by just defining a threshold level.");
        richTooltipThresholdClassification.addDescriptionSection("Can be used to e.g. classify the intensity higher than a specific threshold.");
        buttonThresholdClassification.setActionRichTooltip(richTooltipThresholdClassification);
        buttonThresholdClassification.addActionListener(oia == null ? null : oia.showThresholdClassificationActionListener);
        extensionsBand.addCommandButton(buttonThresholdClassification, RibbonElementPriority.MEDIUM);

        // exclusion model is no ribbonBand
        /*
        JCommandToggleButton buttonExclusionModule = new JCommandToggleButton("Exclusion Map Module",new TabNew6());
		buttonExclusionModule.setBackground(Color.white);
		RichTooltip richTooltipExclusionModule = new RichTooltip("Exclusion Map Module","Show the Exclusion Map Module.");
		richTooltipExclusionModule.addDescriptionSection("High-level classification to e.g. exclude the background or unwanted regions from the main classification.");
		buttonExclusionModule.setActionRichTooltip(richTooltipExclusionModule);
		buttonExclusionModule.addActionListener(oia == null ? null : oia.showExclusionModuleActionListener);
		extensionsBand.addCommandButton(buttonExclusionModule, RibbonElementPriority.TOP);
		*/


        JRibbonBand scriptBand = new JRibbonBand("Script", null);
        scriptBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(scriptBand.getControlPanel()), new IconRibbonBandResizePolicy(scriptBand.getControlPanel())));

        JCommandButton buttonScriptEditor = new JCommandButton("Script Editor", new GroovyLogo());
        RichTooltip richTooltipScriptEditor = new RichTooltip("Script Editor", "Open script editor.");
        buttonScriptEditor.setActionRichTooltip(richTooltipScriptEditor);
        buttonScriptEditor.addActionListener(oia == null ? null : oia.scriptEditorActionListener);
        scriptBand.addCommandButton(buttonScriptEditor, RibbonElementPriority.TOP);


        RibbonTask objectsTask = new RibbonTask("Tools", manageFilesBand, saveImageBand, extensionsBand, scriptBand);
        ribbon.addTask(objectsTask);

    }


    private void addChannelsTask(final JRibbon ribbon) {

        // set channels
        JRibbonBand setChannelsBand = new JRibbonBand("Set Channels", null);
        setChannelsBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(setChannelsBand.getControlPanel())/*,
                new CoreRibbonResizePolicies.Mirror(saveRevertBand.getControlPanel()),
				new CoreRibbonResizePolicies.Mid2Low(saveRevertBand.getControlPanel())*/,
                new IconRibbonBandResizePolicy(setChannelsBand.getControlPanel())));

        JCommandButton buttonSetRedChannel = new JCommandButton("Set as Red", new SetRedChannel());
        RichTooltip richTooltipSetRed = new RichTooltip("Set Red Channel", "Set the active image as red channel.");
        buttonSetRedChannel.setActionRichTooltip(richTooltipSetRed);
        buttonSetRedChannel.addActionListener(oia == null ? null : oia.setRedChannelActionListener);
        setChannelsBand.addCommandButton(buttonSetRedChannel, RibbonElementPriority.TOP);

        JCommandButton buttonSetGreenChannel = new JCommandButton("Set as Green", new SetGreenChannel());
        RichTooltip richTooltipSetGreen = new RichTooltip("Set Green Channel", "Set the active image as green channel.");
        buttonSetGreenChannel.setActionRichTooltip(richTooltipSetGreen);
        buttonSetGreenChannel.addActionListener(oia == null ? null : oia.setGreenChannelActionListener);
        setChannelsBand.addCommandButton(buttonSetGreenChannel, RibbonElementPriority.TOP);

        JCommandButton buttonSetBlueChannel = new JCommandButton("Set as Blue", new SetBlueChannel());
        RichTooltip richTooltipSetBlue = new RichTooltip("Set Blue Channel", "Set the active image as blue channel.");
        buttonSetBlueChannel.setActionRichTooltip(richTooltipSetBlue);
        buttonSetBlueChannel.addActionListener(oia == null ? null : oia.setBlueChannelActionListener);
        setChannelsBand.addCommandButton(buttonSetBlueChannel, RibbonElementPriority.TOP);


        // get channels
        JRibbonBand getChannelsBand = new JRibbonBand("Get Channels", null);
        getChannelsBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(getChannelsBand.getControlPanel())/*,
                new CoreRibbonResizePolicies.Mirror(saveRevertBand.getControlPanel()),
				new CoreRibbonResizePolicies.Mid2Low(saveRevertBand.getControlPanel())*/,
                new IconRibbonBandResizePolicy(getChannelsBand.getControlPanel())));

        JCommandButton buttonGetRedChannel = new JCommandButton("Get Red", new GetRedChannel());
        RichTooltip richTooltipGetRed = new RichTooltip("Get Red Channel", "Get the red channel and links it with the active image.");
        buttonGetRedChannel.setActionRichTooltip(richTooltipGetRed);
        buttonGetRedChannel.addActionListener(oia == null ? null : oia.getRedChannelActionListener);
        getChannelsBand.addCommandButton(buttonGetRedChannel, RibbonElementPriority.TOP);

        JCommandButton buttonGetGreenChannel = new JCommandButton("Get Green", new GetGreenChannel());
        RichTooltip richTooltipGetGreen = new RichTooltip("Get Green Channel", "Get the green channel and links it with the active image.");
        buttonGetGreenChannel.setActionRichTooltip(richTooltipGetGreen);
        buttonGetGreenChannel.addActionListener(oia == null ? null : oia.getGreenChannelActionListener);
        getChannelsBand.addCommandButton(buttonGetGreenChannel, RibbonElementPriority.TOP);

        JCommandButton buttonGetBlueChannel = new JCommandButton("Get Blue", new GetBlueChannel());
        RichTooltip richTooltipGetBlue = new RichTooltip("Get Blue Channel", "Get the blue channel and links it with the active image.");
        buttonGetBlueChannel.setActionRichTooltip(richTooltipGetBlue);
        buttonGetBlueChannel.addActionListener(oia == null ? null : oia.getBlueChannelActionListener);
        getChannelsBand.addCommandButton(buttonGetBlueChannel, RibbonElementPriority.TOP);


        // reset channels
        JRibbonBand resetChannelBand = new JRibbonBand("Reset Channels", null);
        resetChannelBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(resetChannelBand.getControlPanel())/*,
                new CoreRibbonResizePolicies.Mirror(saveRevertBand.getControlPanel()),
				new CoreRibbonResizePolicies.Mid2Low(saveRevertBand.getControlPanel())*/,
                new IconRibbonBandResizePolicy(resetChannelBand.getControlPanel())));

        JCommandButton buttonResetRedChannel = new JCommandButton("Reset Red", new ResetRedChannel());
        RichTooltip richTooltipResetRed = new RichTooltip("Reset Red Channel", "Reset the red channel.");
        richTooltipResetRed.addDescriptionSection("This just rests the global channel. To reset the specific image channel, use 'Get channel' function afterwards.");
        buttonResetRedChannel.setActionRichTooltip(richTooltipResetRed);
        buttonResetRedChannel.addActionListener(oia == null ? null : oia.resetRedChannelActionListener);
        resetChannelBand.addCommandButton(buttonResetRedChannel, RibbonElementPriority.TOP);

        JCommandButton buttonResetGreenChannel = new JCommandButton("Reset Green", new ResetGreenChannel());
        RichTooltip richTooltipResetGreen = new RichTooltip("Reset Green Channel", "Reset the green channel.");
        richTooltipResetGreen.addDescriptionSection("This just rests the global channel. To reset the specific image channel, use 'Get channel' function afterwards.");
        buttonResetGreenChannel.setActionRichTooltip(richTooltipResetGreen);
        buttonResetGreenChannel.addActionListener(oia == null ? null : oia.resetGreenActionListener);
        resetChannelBand.addCommandButton(buttonResetGreenChannel, RibbonElementPriority.TOP);

        JCommandButton buttonResetBlueChannel = new JCommandButton("Reset Blue", new ResetBlueChannel());
        RichTooltip richTooltipResetBlue = new RichTooltip("Reset Blue Channel", "Reset the blue channel.");
        richTooltipResetBlue.addDescriptionSection("This just rests the global channel. To reset the specific image channel, use 'Get channel' function afterwards.");
        buttonResetBlueChannel.setActionRichTooltip(richTooltipResetBlue);
        buttonResetBlueChannel.addActionListener(oia == null ? null : oia.resetBlueChannelActionListener);
        resetChannelBand.addCommandButton(buttonResetBlueChannel, RibbonElementPriority.TOP);

        // save / remove
        JRibbonBand saveRevertBand = new JRibbonBand("Save & Revert", null);
        saveRevertBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(saveRevertBand.getControlPanel())/*,
                new CoreRibbonResizePolicies.Mirror(saveRevertBand.getControlPanel()),
				new CoreRibbonResizePolicies.Mid2Low(saveRevertBand.getControlPanel())*/,
                new IconRibbonBandResizePolicy(saveRevertBand.getControlPanel())));

        JCommandButton buttonSaveChannels = new JCommandButton("Save Channels", new DocumentSave3());
        RichTooltip richTooltipSaveChannels = new RichTooltip("Save Channels into DB", "Saves the channel links into the database. If the image is loaded again, the according channels are loaded automatically together with the image.");
        buttonSaveChannels.setActionRichTooltip(richTooltipSaveChannels);
        buttonSaveChannels.addActionListener(oia == null ? null : oia.saveChannelLinksActionListener);
        saveRevertBand.addCommandButton(buttonSaveChannels, RibbonElementPriority.TOP);

        JCommandButton revertChannels = new JCommandButton("Revert Channels", new EditDelete6());
        RichTooltip richTooltipRevertChannels = new RichTooltip("Revert Channels stored in DB", "Removes the linked channels stored in the database. Just the links will be removed, no image data will be deleted.");
        revertChannels.setActionRichTooltip(richTooltipRevertChannels);
        revertChannels.addActionListener(oia == null ? null : oia.removeLinkedChannelsActionListener);
        saveRevertBand.addCommandButton(revertChannels, RibbonElementPriority.TOP);


        RibbonTask channelsTask = new RibbonTask("Channels", setChannelsBand, getChannelsBand, resetChannelBand, saveRevertBand);
        ribbon.addTask(channelsTask);

    }


    private void addWindowsTask(final JRibbon ribbon) {

        JRibbonBand arrangeBand = new JRibbonBand("Arrange", null);
        arrangeBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(arrangeBand.getControlPanel()),
                new CoreRibbonResizePolicies.Mirror(arrangeBand.getControlPanel()),
                new CoreRibbonResizePolicies.Mid2Low(arrangeBand.getControlPanel()),
                new IconRibbonBandResizePolicy(arrangeBand.getControlPanel())));

        JCommandButton buttontile = new JCommandButton("Tile Windows (F9)", new TileWindows());
        RichTooltip richTooltipTile = new RichTooltip("Tile Windows", "Arrange all open windows side by side so that they fill the desktop.");
        buttontile.setActionRichTooltip(richTooltipTile);
        buttontile.addActionListener(oia == null ? null : oia.desktopArrangeActionListener);
        arrangeBand.addCommandButton(buttontile, RibbonElementPriority.TOP);

        JCommandButton buttonCascade = new JCommandButton("Cascade Windows (F10)", new CascadeWindows());
        RichTooltip richTooltipCascade = new RichTooltip("Cascade Windows", "Cascade all open windows in the desktop.");
        buttonCascade.setActionRichTooltip(richTooltipCascade);
        buttonCascade.addActionListener(oia == null ? null : oia.desktopCascadeActionListener);
        arrangeBand.addCommandButton(buttonCascade, RibbonElementPriority.TOP);

        JCommandButton buttonMinimize = new JCommandButton("Minimize Windows (F11)", new MinimizeWindows());
        RichTooltip richTooltipMinimize = new RichTooltip("Minimize Windows", "Minimize all open windows at the bottom of the desktop.");
        buttonMinimize.setActionRichTooltip(richTooltipMinimize);
        buttonMinimize.addActionListener(oia == null ? null : oia.desktopMinimizeAllActionListener);
        arrangeBand.addCommandButton(buttonMinimize, RibbonElementPriority.TOP);

        JCommandButton buttonClose = new JCommandButton("Close Windows (F12)", new CloseWindows());
        RichTooltip richTooltipClose = new RichTooltip("Close Windows", "Close all open windows. All drawn class shapes will be lost.");
        buttonClose.setActionRichTooltip(richTooltipClose);
        buttonClose.addActionListener(oia == null ? null : oia.desktopCloseAllActionListener);
        arrangeBand.addCommandButton(buttonClose, RibbonElementPriority.TOP);


        JRibbonBand showBand = new JRibbonBand("Show", null);
        showBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(showBand.getControlPanel()),
                new CoreRibbonResizePolicies.Mirror(showBand.getControlPanel()),
                new CoreRibbonResizePolicies.Mid2Low(showBand.getControlPanel()),
                new IconRibbonBandResizePolicy(showBand.getControlPanel())));

        JCommandToggleButton buttonShowToolbar = new JCommandToggleButton("Show Toolbar", new RibbonBar());
        buttonShowToolbar.setBackground(Color.white);
        RichTooltip richTooltipShowToolbar = new RichTooltip("Show Toolbar", "Show or hide the toolbar.");
        buttonShowToolbar.setActionRichTooltip(richTooltipShowToolbar);
        if (oia != null && oia.isShowToolbar()) buttonShowToolbar.doActionClick();
        //buttonShowToolbar.addActionListener(oia == null ? null : oia.showToolbarActionListener);
        buttonShowToolbar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ribbon.setMinimized(!ribbon.isMinimized());
            }
        });
        showBand.addCommandButton(buttonShowToolbar, RibbonElementPriority.TOP);

        JCommandToggleButton buttonShowStatusbar = new JCommandToggleButton("Show Statusbar", new StatusBar());
        buttonShowStatusbar.setBackground(Color.white);
        RichTooltip richTooltipShowStatusbar = new RichTooltip("Show Statusbar", "Show or hide the statusbar.");
        buttonShowStatusbar.setActionRichTooltip(richTooltipShowStatusbar);
        if (oia != null && oia.isShowStatusbar()) buttonShowStatusbar.doActionClick();
        buttonShowStatusbar.addActionListener(oia == null ? null : oia.showStatusbarActionListener);
        showBand.addCommandButton(buttonShowStatusbar, RibbonElementPriority.TOP);

        JCommandToggleButton buttonShowGauge = new JCommandToggleButton("Show Gauge", new Gauge());
        buttonShowGauge.setBackground(Color.white);
        RichTooltip richTooltipShowGauge = new RichTooltip("Show Gauge", "Show or hide the gauge in image frames.");
        buttonShowGauge.setActionRichTooltip(richTooltipShowGauge);
        if (oia != null && oia.isShowGauge()) buttonShowGauge.doActionClick();
        buttonShowGauge.addActionListener(oia == null ? null : oia.showGaugeActionListener);
        showBand.addCommandButton(buttonShowGauge, RibbonElementPriority.MEDIUM);

        //JCommandToggleButton buttonShowAnnotationLabels = new JCommandToggleButton("Show Labels", new ShowLabels());
        buttonShowAnnotationLabels.setBackground(Color.white);
        RichTooltip richTooltipShowAnnotationLabels = new RichTooltip("Show Annotation Labels", "Show or hide labels displaying the description of an annotation. For e.g. rare event detection it can be useful to hide these labels.");
        buttonShowAnnotationLabels.setActionRichTooltip(richTooltipShowAnnotationLabels);
        if (oia != null && oia.isShowAnnotationLabels()) buttonShowAnnotationLabels.doActionClick();
        buttonShowAnnotationLabels.addActionListener(oia == null ? null : oia.showAnnotationLabelsActionListener);
        showBand.addCommandButton(buttonShowAnnotationLabels, RibbonElementPriority.MEDIUM);

        //JCommandToggleButton buttonShowCenterCross = new JCommandToggleButton("Show Center Cross", new ShowCenterCross());
        buttonShowCenterCross.setBackground(Color.white);
        RichTooltip richTooltipShowCenterCross = new RichTooltip("Show Center Cross in Overview", "Show or hide the center cross symbol in the overview window.");
        richTooltipShowCenterCross.addDescriptionSection("Can be useful for manual classification or rare event detection to see where the current viewport is located.");
        buttonShowCenterCross.setActionRichTooltip(richTooltipShowCenterCross);
        if (oia != null && oia.isShowCenterCross()) buttonShowCenterCross.doActionClick();
        buttonShowCenterCross.addActionListener(oia == null ? null : oia.showCenterCrossActionListener);
        showBand.addCommandButton(buttonShowCenterCross, RibbonElementPriority.MEDIUM);

        // buttonShowMArkup is declared in header as final
        //JCommandToggleButton buttonShowMarkup = new JCommandToggleButton("Show Markup", new ToggleMarkup());
        buttonShowMarkup.setBackground(Color.white);
        RichTooltip richTooltipShowMarkup = new RichTooltip("Show Markup", "Show or hide markup in image windows (e.g. class shapes or ROI borders).");
        buttonShowMarkup.setActionRichTooltip(richTooltipShowMarkup);
        if (oia != null && oia.isShowMarkup()) buttonShowMarkup.doActionClick();
        buttonShowMarkup.addActionListener(oia == null ? null : oia.toggleMarkupActionListener);
        showBand.addCommandButton(buttonShowMarkup, RibbonElementPriority.MEDIUM);

        buttonSyncFrames.setBackground(Color.white);
        RichTooltip richTooltipSyncFrames = new RichTooltip("Synchronize Frames", "Synchronize all open image frames for scrolling and zooming.");
        richTooltipSyncFrames.addDescriptionSection("This only works for equal size images.");
        buttonSyncFrames.setActionRichTooltip(richTooltipSyncFrames);
        if (oia != null && oia.isSyncFrames()) buttonSyncFrames.doActionClick();
        buttonSyncFrames.addActionListener(oia == null ? null : oia.syncFramesActionListener);
        showBand.addCommandButton(buttonSyncFrames, RibbonElementPriority.MEDIUM);

        buttonShowPopupResults.setBackground(Color.white);
        RichTooltip richTooltipPopupResults = new RichTooltip("Show Popup Results", "After classification, segmentation or object classification a popup window with the results will appear.");
        richTooltipPopupResults.addDescriptionSection("If disabled, the results can still be viewed in the log.");
        buttonShowPopupResults.setActionRichTooltip(richTooltipPopupResults);
        if (oia != null && oia.isShowPopupResults()) buttonShowPopupResults.doActionClick();
        buttonShowPopupResults.addActionListener(oia == null ? null : oia.showPopupResultsActionListener);
        showBand.addCommandButton(buttonShowPopupResults, RibbonElementPriority.MEDIUM);


        RibbonTask windowsTask = new RibbonTask("View", arrangeBand, showBand);
        ribbon.addTask(windowsTask);

    }


    private void addCustomTask(final JRibbon ribbon) {
        ICustomMenu customMenu = DALConfig.getCustomMenu();
        if (customMenu != null) {
            JRibbonBand customBand = new JRibbonBand("Custom", null);
            customBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(customBand.getControlPanel()),
                    new IconRibbonBandResizePolicy(customBand.getControlPanel())));
            for (JCommandButton button : customMenu.getTaskList()) {
                customBand.addCommandButton(button, RibbonElementPriority.TOP);
            }
            RibbonTask customTask = new RibbonTask("Custom", customBand);
            ribbon.addTask(customTask);
        }
    }


    private void addHelpTask(final JRibbon ribbon) {

        JRibbonBand orbitHelpBand = new JRibbonBand("Documentation", null);
        orbitHelpBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(orbitHelpBand.getControlPanel()),
                //	new CoreRibbonResizePolicies.Mirror(orbitHelpBand.getControlPanel()),
                //	new CoreRibbonResizePolicies.Mid2Low(orbitHelpBand.getControlPanel()),
                new IconRibbonBandResizePolicy(orbitHelpBand.getControlPanel())));

        JCommandButton buttonDocumentation = new JCommandButton("Orbit Manual", new HelpContents5());
        RichTooltip richTooltipDocumentation = new RichTooltip("Orbit Manual", "Display the orbit documentation.");
        buttonDocumentation.setActionRichTooltip(richTooltipDocumentation);
        buttonDocumentation.addActionListener(oia == null ? null : oia.helpBrowserActionListener);
        orbitHelpBand.addCommandButton(buttonDocumentation, RibbonElementPriority.TOP);

//        JCommandButton buttonTipOfTheDay = new JCommandButton("Tip of the Day", new Lightbulb());
//        RichTooltip richTooltipTipOfTheDay = new RichTooltip("Tip of the Day", "Display the Tip of the Day popup.");
//        buttonTipOfTheDay.setActionRichTooltip(richTooltipTipOfTheDay);
//        buttonTipOfTheDay.addActionListener(oia == null ? null : oia.tipOfTheDayActionListener);
//        orbitHelpBand.addCommandButton(buttonTipOfTheDay, RibbonElementPriority.MEDIUM);


        JCommandButton buttonAbout = new JCommandButton("About", new HelpAbout3());
        RichTooltip richTooltipAbout = new RichTooltip("About", "Display further information about the program.");
        buttonAbout.setActionRichTooltip(richTooltipAbout);
        buttonAbout.addActionListener(oia == null ? null : oia.aboutActionListener);
        orbitHelpBand.addCommandButton(buttonAbout, RibbonElementPriority.MEDIUM);


        JRibbonBand logsBand = new JRibbonBand("Logs", null);
        logsBand.setResizePolicies(Arrays.<RibbonBandResizePolicy>asList(new CoreRibbonResizePolicies.None(logsBand.getControlPanel()),
                //new CoreRibbonResizePolicies.Mirror(logsBand.getControlPanel()),
                new CoreRibbonResizePolicies.Mid2Low(logsBand.getControlPanel()),
                new IconRibbonBandResizePolicy(logsBand.getControlPanel())));

        JCommandButton buttonShowLog = new JCommandButton("Show Log", new LogFrameIcon());
        RichTooltip richTooltipLogFile = new RichTooltip("Show Orbit Log File", "Display the orbit log file.");
        buttonShowLog.setActionRichTooltip(richTooltipLogFile);
        buttonShowLog.addActionListener(oia == null ? null : oia.showLogActionListener);
        logsBand.addCommandButton(buttonShowLog, RibbonElementPriority.TOP);

        JCommandButton buttonWriteModelToLog = new JCommandButton("Log Model", new WriteModel());
        RichTooltip richTooltipWriteModelToLog = new RichTooltip("Write Model Information to Log", "Write detailed information about the active model into the log.");
        buttonWriteModelToLog.setActionRichTooltip(richTooltipWriteModelToLog);
        buttonWriteModelToLog.addActionListener(oia == null ? null : oia.writeModelInfosActionListener);
        logsBand.addCommandButton(buttonWriteModelToLog, RibbonElementPriority.MEDIUM);

        RibbonTask helpTask = new RibbonTask("Help", orbitHelpBand, logsBand);
        ribbon.addTask(helpTask);

    }


    private JButton createTaskbarButton(final ResizableIcon icon, final String tooltip, final ActionListener actionListener) {
        icon.setDimension(new Dimension(16, 16));
        JButton btn = new JButton(icon);
        //JCommandButton btn = new JCommandButton(icon);
        if (tooltip != null) btn.setToolTipText(tooltip);
        //if (tooltip!=null) btn.setActionRichTooltip(new RichTooltip(tooltip,""));
        if (actionListener != null) btn.addActionListener(actionListener);
        return btn;
    }

    private JToggleButton createTaskbarToggleButton(final ResizableIcon icon, final ResizableIcon selectedIcon, final String tooltip, final ActionListener actionListener) {
        icon.setDimension(new Dimension(16, 16));
        selectedIcon.setDimension(new Dimension(16, 16));
        JToggleButton btn = new JToggleButton(icon, false);
        btn.setSelectedIcon(selectedIcon);
        if (tooltip != null) btn.setToolTipText(tooltip);
        if (actionListener != null) btn.addActionListener(actionListener);
        return btn;
    }


    /**
     * to be overwritten
     *
     * @return
     */
    public JComboBox getClassCombobox() {
        JComboBox combo = new JComboBox<String>(new String[]{"Background", "Tissue Class 1", "Tissue Class 2", "Tissue Class 3"});
        combo.setToolTipText("select class name");
        return combo;
    }

    /**
     * to be overwritten
     *
     * @return
     */
    public JComboBox getSizeCombobox() {
        JComboBox combo = new JComboBox<String>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"});
        combo.setToolTipText("size for drawing arcs and fixed size rectangles");
        return combo;
    }

    public JPopupPanel getSpecialResolutionPopupPanel() {
        return null;
    }

    private void makeMandatory(AbstractCommandButton btn) {
        btn.setFont(btn.getFont().deriveFont(Font.BOLD + Font.ITALIC));
    }

    public RibbonApplicationMenuEntrySecondary getAmOpenOrbit() {
        return amOpenOrbit;
    }

    public JCommandButton getButtonopenFromOrbit() {
        return buttonopenFromOrbit;
    }

    public JCommandButton getButtonExecuteScaleout() {
        return buttonExecuteScaleout;
    }

    public JCommandButton getButtonRetrieveExistingResults() {
        return buttonRetrieveExistingResults;
    }
}