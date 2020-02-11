/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2020 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
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

import com.actelion.research.orbit.beans.RawAnnotation;
import com.actelion.research.orbit.beans.RawData;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.beans.RawMeta;
import com.actelion.research.orbit.dal.IModelAwareImageProvider;
import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.dal.IOrbitImageMultiChannel;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.gui.AbstractOrbitTree;
import com.actelion.research.orbit.gui.RdfSearchBox;
import com.actelion.research.orbit.imageAnalysis.TMA.TMASpotGUI;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame.Tools;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.dal.ImageProviderLocal;
import com.actelion.research.orbit.imageAnalysis.dal.localImage.LocalFileFilter;
import com.actelion.research.orbit.imageAnalysis.features.ObjectFeatureBuilderTiled;
import com.actelion.research.orbit.imageAnalysis.mask.IOrbitMask;
import com.actelion.research.orbit.imageAnalysis.mask.IOrbitMaskModelBased;
import com.actelion.research.orbit.imageAnalysis.mask.OrbitMaskClassificationModel;
import com.actelion.research.orbit.imageAnalysis.mask.OrbitMaskSegmentationModel;
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.modules.*;
import com.actelion.research.orbit.imageAnalysis.modules.mihc.MihcModule;
import com.actelion.research.orbit.imageAnalysis.tasks.*;
import com.actelion.research.orbit.imageAnalysis.tasks.ROIArea.ROIAreaWorkerMapReduce;
import com.actelion.research.orbit.imageAnalysis.tasks.cellClassification.CellClassificationWorkerMapReduce;
import com.actelion.research.orbit.imageAnalysis.tasks.cellFeatures.CellFeaturesWorkerMapReduce;
import com.actelion.research.orbit.imageAnalysis.tasks.classification.ClassificationWorkerMapReduce;
import com.actelion.research.orbit.imageAnalysis.tasks.histogram.HistogramWorkerMapReduce;
import com.actelion.research.orbit.imageAnalysis.tasks.segmentation.SegmentationWorkerMapReduce;
import com.actelion.research.orbit.imageAnalysis.utils.*;
import com.actelion.research.orbit.utils.ChannelToHue;
import com.actelion.research.orbit.utils.Logger;
import com.actelion.research.orbit.utils.RawUtilsCommon;
import org.jaitools.tilecache.DiskCachedTile;
import org.jaitools.tiledimage.DiskMemImageOrbit;
import org.jdesktop.swingx.JXLoginPane.Status;
import org.pushingpixels.flamingo.api.common.CommandAction;
import org.pushingpixels.flamingo.api.ribbon.JRibbonFrame;
import org.pushingpixels.flamingo.api.ribbon.synapse.model.RibbonDefaultComboBoxContentModel;
import org.pushingpixels.substance.api.SubstanceCortex;
import org.pushingpixels.substance.api.skin.GraphiteAquaSkin;
import org.slf4j.LoggerFactory;

import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.TiledImage;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.datatransfer.Transferable;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.io.*;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import static com.actelion.research.orbit.imageAnalysis.dal.DALConfig.isLocalImageProvider;

/**
 * Main class and frame of Orbit Image Analysis.<br>
 * To be used as a singleton. Call getInstance() to get the singleton.
 * <p>
 * An Image (incl. channels and mip-maps) is loaded as follows:
 * <p>
 * OrbitImageAnalysis.loadfile()
 * |
 * rf = new RecognitionFrame(imageSource)
 * |---TiledImagePainter.loadImage(imageSource)
 * |     |----loadMipMaps()
 * |
 * iFrame = new ImageFrame(rf)
 * |-iFrame.loadChannels()
 * |-new RecognitionFrame() per channel
 */
public class OrbitImageAnalysis extends JRibbonFrame implements PropertyChangeListener {

    private ResourceBundle resourceBundle;

    private String title;
    private static final long serialVersionUID = 1L;
    public static final int TOOLBAR_HEIGHT = 26;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(OrbitImageAnalysis.class);
    private static final Logger orbitLogger = Logger.getLogger(OrbitImageAnalysis.class);
    private static volatile OrbitImageAnalysis instance = null;
    final public String START_PIC = null; //"/image_small.jpg";
    final public String startModel = null; // = "D:\\orbitModels\\simple-segmentation_v5.omo";

    public static final String LOGO_NAME = "/resource/Orbital_bones32.png";
    public static final String GUEST_USER = "guest";
    public volatile static String loginUser = GUEST_USER;
    public volatile static String loginPassword = "";
    public volatile static boolean loginOk = false;
    final private Dimension defaultWindowDimension = new Dimension(400, 400);
    final JFileChooser fileChooser = new JFileChooser();
    private boolean objectSegmentationEnabled = false;
    private boolean cellCountEnabled = false;
    public final JCheckBoxMenuItem loadAllLayersMultiChannel = new JCheckBoxMenuItem("Load Full Pyramid", true);

    private final JMenuItem loadlowResImageItem = null;
    private final JMenuItem loadmediumResImageItem = null;
    private final JMenuItem loadSVSLabelItem = null;
    private final JMenuItem loadSVSOverviewItem = null;
    private final JMenu loadSpecialLayerItem = null;
    protected final JMenuItem menuLogOff = new JMenuItem("Log off ");
    protected final JMenuItem menuLogIn = new JMenuItem("Login");
    protected final JCheckBox syncFramesCheckbox = new JCheckBox("Sync Frames", false);
    protected final JCheckBoxMenuItem showGaugeCheckbox = new JCheckBoxMenuItem("Show Gauge", true);
    protected final JCheckBoxMenuItem showMarkupCheckbox = new JCheckBoxMenuItem("Show Markup");

    private JComboBox sizeBox = null;
    private JComboBox<ClassShape> classBox = null;

    protected RibbonDefaultComboBoxContentModel<ClassShape> ccbModel;

    private JDesktopPane desktop = null;

    private SliderWithListener scaleSlider = null;
    private RenderGrid renderGrid = null;
    private LoupeWithScale loupeWithScale = null;
    private JPanel propertyPanel = null;
    private MetaTabs metaBar = null;
    private JPanel taskPanel = null;
    private AbstractOrbitTree rdTree;
    private ImageList imageList = null;
    private final OrbitStatusBar statusBar = new OrbitStatusBar();

    protected OrbitModel model = new OrbitModel(); // with default values

    private double pixelFuzzyness = 0.0d;
    private double tileFuzzyness = 0.0d;
    private PlanarImage redChannel = null;
    private PlanarImage greenChannel = null;
    private PlanarImage blueChannel = null;
    private PlanarImage overlayChannel = null;
    private int redChannelRdfId = 0;
    private int greenChannelRdfId = 0;
    private int blueChannelRdfId = 0;
    private int overlayChannelRdfId = 0;

    private boolean showObjectHeatmap = false;
    private boolean performClustering = false; // if false, do classification
    private boolean showRareObjectDetection = false;
    private boolean showCellProfiler = false;
    private boolean showNerveDetection = false;
    private boolean showManualClassification = false;
    private boolean showManualBoxCount = false;
    private boolean showThresholdClassification = false;
    private boolean showMihcModule = false;

    private boolean showToolbar = true;
    private boolean showStatusbar = true;
    private boolean showGauge = true;
    private boolean syncFrames = false;
    private boolean showAnnotationLabels = true;
    private boolean showCenterCross = false;
    private boolean showMarkup = true;
    private boolean specialResImagesAvailable = false;
    private boolean showPopupResults = true;
    private boolean showExclusionModule = !OrbitUtils.DARKUI;

    public final static ResultFrame logFrame;
    private String loadedModel = "none";
    private final ScheduledExecutorService statusBarUpdater = Executors.newScheduledThreadPool(1);
    private RareObjectDetectionModule rareObjectDetectionModule = null;
    private CellProfilerModule cellProfilerModule = null;
    private NerveDetectionModule nerveDetectionModule = null;
    private ManualClassificationModule manualClassificationModule = null;
    private ManualBoxCountModule manualBoxCountModule = null;
    private TMASpotGUI tmaSpotGUI = null;
    private ThresholdModule thresholdModule = null;
    private ExclusionModule exclusionModule = null;
    private MihcModule mihcModule = null;
    private ModelExplorer modelExplorer = null;
    final TransferHandler desktopTransferHandler = new DesktopTransferHandler();

    public static boolean popupErrors = true;
    protected Preferences prefs = Preferences.userNodeForPackage(this.getClass());
    protected static boolean showQuicksearch = true;
    private final AtomicBoolean errorPopupOpen = new AtomicBoolean(false);
    private String lastErrorMessage = "";
    private long lastErrorTime = 0;
    private boolean modifiedClassShapes = false;
    private OrbitMenu orbitMenu;
    JSplitPane splitPanePropLoupe;

    static {
        ScaleoutMode.SCALEOUTMODE.set(false);

        if (!ScaleoutMode.SCALEOUTMODE.get()) {
            Locale.setDefault(Locale.US);
        }

        if (!GraphicsEnvironment.isHeadless()) {
            logFrame = new ResultFrame("", "Log");
        } else
            logFrame = null;
        orbitLogger.setLogLevel(OrbitUtils.DEVELOPMENTMODE ? Logger.LOG_LEVEL_TRACE : Logger.LOG_LEVEL_INFO);
        Logger.AddLogListener(orbitLogger);
    }


    private OrbitImageAnalysis(boolean withGUI) {
        if (!OrbitUtils.DEVELOPMENTMODE && !ScaleoutMode.SCALEOUTMODE.get()) {
            DALConfig.getImageProvider().logUsage(System.getProperty("user.name"), "init");
        }
    }


    private OrbitImageAnalysis() {
        Locale currLocale = Locale.getDefault();
        resourceBundle = ResourceBundle.getBundle("Resources", currLocale);

        title = resourceBundle.getString("Frame.title");

        if (!ScaleoutMode.SCALEOUTMODE.get()) {

            if (!OrbitUtils.DEVELOPMENTMODE && !ScaleoutMode.SCALEOUTMODE.get()) {
                try {
                    PrintStream consoleOut = System.out;
                    PrintStream consoleErr = System.err;
                    String homeDir = System.getProperty("user.home");
                    System.setOut(new PrintStream(new OutputStreamCombiner(Arrays.asList(new OutputStream[]{consoleOut, new PrintStream(new File(homeDir + File.separator + "orbit.out.log"))}))));
                    System.setErr(new PrintStream(new OutputStreamCombiner(Arrays.asList(new OutputStream[]{consoleErr, new PrintStream(new File(homeDir + File.separator + "orbit.err.log"))}))));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        System.out.println(getInfoString() + "\n");
        System.out.println("Optional parameters: [.orbit|image file(.jpg,.tif,.bmp,.png,.gif,.svs)|url|rdf id  ]");
        System.out.println("use -noErrorPopups to get rid of error popups (can be useful if you have no network connection)\n");
        System.out.println("use --hideQuickSearch to hide the left search bar (can be useful if you have no network connection)\n");

        logger.info("DEVELOPMENT=" + OrbitUtils.DEVELOPMENTMODE + "; ScaleoutMode=" + ScaleoutMode.SCALEOUTMODE.get() + "; TileMode=" + OrbitUtils.TILEMODE);
        if (!OrbitUtils.DEVELOPMENTMODE) {
            DALConfig.getImageProvider().logUsage(System.getProperty("user.name"), "init dev");
        }

        DiskMemImageOrbit.getCommonTileCache().setMemoryCapacity(OrbitUtils.DISK_IMAGE_CACHE);
        DiskMemImageOrbit.getCommonTileCache().setAutoFlushMemoryEnabled(OrbitUtils.DISK_IMAGE_AUTO_FLUSH);

        JAI.getDefaultInstance().getTileCache().setMemoryCapacity(OrbitUtils.PLANAR_IMAGE_CACHE);

        makeClassComboBox();

        this.orbitMenu = new OrbitMenu(this);;

        // TODO: Better handled by Radiance?
        this.setTitle(title);
        java.net.URL imgURL = this.getClass().getResource(OrbitImageAnalysis.LOGO_NAME);
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            this.setIconImage(icon.getImage());
        }
        setResizable(true);


        if (DALConfig.getImageProvider().enforceLoginDialogAtStartup()) {
            forceLogin();
        }

        // if local filesystem image provider, switch to Image menu to show open
        // from local file button (otherwise the classification task will be shown)
        if (DALConfig.isLocalImageProvider()) {
            getRibbon().setSelectedTask(getRibbon().getTask(0));
        }

        ImagePreview preview = new ImagePreview(fileChooser);
        fileChooser.setAccessory(preview);
        fileChooser.setMultiSelectionEnabled(true);


        // left panel
        // TODO: Find a solution to the problem that this component breaks Radiance.
        RdfSearchBox searchBox = new RdfSearchBoxExtended(false, false, false);

        imageList = new ImageList(new RdfThnCellRendererBig(DALConfig.getImageProvider()));
        searchBox.addPropertyChangeListener(imageList);

        imageList.addPropertyChangeListener(this);
        JScrollPane imageListScrolPane = new JScrollPane(imageList);

        rdTree = DALConfig.getImageProvider().createOrbitTree();
        rdTree.addPropertyChangeListener(imageList);
        final JScrollPane treeScrollPane = new JScrollPane(rdTree);

        JPanel treePanel = new JPanel(new BorderLayout());
        treePanel.add(treeScrollPane, BorderLayout.CENTER);
        JComponent treeOptionPane = rdTree.createTreeOptionPane();
        // TODO: treeOptionPane is always null!
        if (treeOptionPane != null) {   // is optional
            treePanel.add(treeOptionPane, BorderLayout.NORTH);
        }

        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setMinimumSize(new Dimension(0, 200));

        GridBagConstraints gbcTree = new GridBagConstraints();
        gbcTree.weightx = 1.0;
        gbcTree.weighty = 0.5;
        gbcTree.anchor = GridBagConstraints.NORTH;
        gbcTree.fill = GridBagConstraints.BOTH;
        gbcTree.gridx = 0;
        gbcTree.gridy = 0;

        GridBagConstraints gbcSB = new GridBagConstraints();
        gbcSB.insets = new Insets(5, 0, 5, 0);
        gbcSB.weightx = 1.0;
        gbcSB.weighty = 0.0;
        gbcSB.anchor = GridBagConstraints.NORTH;
        gbcSB.fill = GridBagConstraints.HORIZONTAL;
        gbcSB.gridx = 0;
        gbcSB.gridy = 1;

        GridBagConstraints gbcIMGLIST = new GridBagConstraints();
        gbcIMGLIST.weightx = 1.0;
        gbcIMGLIST.weighty = 1.0;
        gbcIMGLIST.anchor = GridBagConstraints.NORTH;
        gbcIMGLIST.fill = GridBagConstraints.BOTH;
        gbcIMGLIST.gridx = 0;
        gbcIMGLIST.gridy = 2;

        leftPanel.add(searchBox, gbcSB);
        leftPanel.add(imageListScrolPane, gbcIMGLIST);

        JSplitPane treeListSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, treePanel, leftPanel);
        treeListSplit.setOneTouchExpandable(true);
        treeListSplit.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0), "none");
        treeListSplit.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0), "none");

        //Lay out the main panel.
        desktop = new JDesktopPane();
        desktop.setLayout(null);

        desktop.setTransferHandler(desktopTransferHandler);

        // actionMap for copy&paste
        ActionMap map = desktop.getActionMap();
        map.put(TransferHandler.getCutAction().getValue(Action.NAME),
                TransferHandler.getCutAction());
        map.put(TransferHandler.getCopyAction().getValue(Action.NAME),
                TransferHandler.getCopyAction());
        map.put(TransferHandler.getPasteAction().getValue(Action.NAME),
                TransferHandler.getPasteAction());


        // iFrame
        ImageFrame iFrame = null;
        if (START_PIC != null) {
            try {
                iFrame = new ImageFrame(START_PIC);
                iFrame.setVisible(true);
                iFrame.setAutoscrolls(false);
                iFrame.setResizable(true);
                iFrame.setBounds(10, 10, 1000, 800);
                iFrame.addPropertyChangeListener(this);
                this.addPropertyChangeListener(iFrame);
                desktop.add(iFrame);
            } catch (OrbitImageServletException oe) {
                logger.error(String.format("error loading start image: %s", oe));
            }
        }

        // right panel
        propertyPanel = new JPanel();
        propertyPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbcRenderGrid = new GridBagConstraints();
        gbcRenderGrid.weightx = 1.0;
        gbcRenderGrid.weighty = 1.0;
        gbcRenderGrid.anchor = GridBagConstraints.NORTHEAST;
        gbcRenderGrid.fill = GridBagConstraints.BOTH;
        gbcRenderGrid.gridx = 0;
        gbcRenderGrid.gridy = 0;

        GridBagConstraints gbcScaleSlider = new GridBagConstraints();
        gbcScaleSlider.insets = new Insets(2, 2, 2, 2);
        gbcScaleSlider.weightx = 1.0;
        gbcScaleSlider.weighty = 0.0;
        gbcScaleSlider.anchor = GridBagConstraints.NORTH;
        gbcScaleSlider.fill = GridBagConstraints.HORIZONTAL;
        gbcScaleSlider.gridx = 0;
        gbcScaleSlider.gridy = 1;

        GridBagConstraints gbcWorkers = new GridBagConstraints();
        gbcWorkers.weightx = 1.0;
        gbcWorkers.weighty = 0.0;
        gbcWorkers.anchor = GridBagConstraints.NORTH;
        gbcWorkers.fill = GridBagConstraints.HORIZONTAL;
        gbcWorkers.gridx = 0;
        gbcWorkers.gridy = 2;

        GridBagConstraints gbcMetaBar = new GridBagConstraints();
        gbcMetaBar.weightx = 1.0;
        gbcMetaBar.weighty = 1.0;
        gbcMetaBar.anchor = GridBagConstraints.NORTH;
        gbcMetaBar.fill = GridBagConstraints.BOTH;
        gbcMetaBar.gridx = 0;
        gbcMetaBar.gridy = 3;


        GridBagConstraints gbcLoupe = new GridBagConstraints();
        gbcLoupe.weightx = 1.0;
        gbcLoupe.weighty = 0.0;
        gbcLoupe.anchor = GridBagConstraints.SOUTH;
        gbcLoupe.fill = GridBagConstraints.HORIZONTAL;
        gbcLoupe.gridx = 0;
        gbcLoupe.gridy = 4;

        if (iFrame != null) {
            renderGrid = new RenderGrid(iFrame.recognitionFrame.bimg);
            renderGrid.setViewportSize(iFrame.getSize());
            renderGrid.setImageSize(new Dimension(iFrame.recognitionFrame.bimg.getWidth(), iFrame.recognitionFrame.bimg.getHeight())); // scale?
            iFrame.setRenderGrid(renderGrid);
        } else {
            renderGrid = new RenderGrid(null);
        }

        scaleSlider = new SliderWithListener(JSlider.HORIZONTAL, 2, 800, 400);
        scaleSlider.setMajorTickSpacing(100);
        scaleSlider.setMinorTickSpacing(25);
        scaleSlider.setPaintTicks(true);
        scaleSlider.setPaintLabels(true);
        Hashtable<Integer, Component> labelTable = new Hashtable<Integer, Component>();
        labelTable.put(2, new JLabel("1%"));
        labelTable.put(200, new JLabel("50%"));
        labelTable.put(400, new JLabel("100%"));
        labelTable.put(600, new JLabel("300%"));
        labelTable.put(800, new JLabel("500%"));

        scaleSlider.setLabelTable(labelTable);
        scaleSlider.setModel(new DefaultBoundedRangeModel(400, 0, 2, 800));

        scaleSlider.addChangeListener(scaleChangeListener);

        taskPanel = new JPanel();
        taskPanel.setLayout(new GridLayout(0, 1));

        JPanel propertyUpperPanel = new JPanel(new GridBagLayout());
        propertyUpperPanel.add(renderGrid, gbcRenderGrid);
        propertyUpperPanel.add(scaleSlider, gbcScaleSlider);
        propertyUpperPanel.add(taskPanel, gbcWorkers);

        metaBar = new MetaTabs();

        loupeWithScale = new LoupeWithScale();
        if (iFrame != null) {
            loupeWithScale.getLoupe().setImage(iFrame.recognitionFrame.bimg);
            iFrame.addPropertyChangeListener(loupeWithScale.getLoupe());
        }

        splitPanePropLoupe = new JSplitPane(JSplitPane.VERTICAL_SPLIT, metaBar, loupeWithScale);
        splitPanePropLoupe.setOneTouchExpandable(true);
        splitPanePropLoupe.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0), "none");
        splitPanePropLoupe.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0), "none");

        JSplitPane splitPaneRenderGridPropLoupe = new JSplitPane(JSplitPane.VERTICAL_SPLIT, propertyUpperPanel, splitPanePropLoupe);
        splitPaneRenderGridPropLoupe.setOneTouchExpandable(true);
        splitPaneRenderGridPropLoupe.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0), "none");
        splitPaneRenderGridPropLoupe.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0), "none");
        propertyPanel.add(splitPaneRenderGridPropLoupe, gbcMetaBar);

        Rectangle size = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();

        // SplitPanes
        JSplitPane splitPaneRight = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, desktop, propertyPanel);
        splitPaneRight.setOneTouchExpandable(true);
        splitPaneRight.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0), "none");
        splitPaneRight.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0), "none");
        splitPaneRight.setResizeWeight(1);

        JSplitPane splitPaneLeft = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeListSplit, splitPaneRight);
        splitPaneLeft.setOneTouchExpandable(true);
        splitPaneLeft.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0), "none");
        splitPaneLeft.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0), "none");

        splitPaneLeft.setResizeWeight(0);
        if (!showQuicksearch)
            splitPaneLeft.setDividerLocation(0);
        else {
            splitPaneLeft.setDividerLocation((int) (size.getWidth() * 0.15d));
            treeListSplit.setDividerLocation((int) (size.getHeight() * 0.15d));
        }

        add(splitPaneLeft, BorderLayout.CENTER);

        // status bar
        add(statusBar, BorderLayout.SOUTH);
        Runnable statusBarUpdate = this::updateStatusBar;

        statusBarUpdater.scheduleAtFixedRate(statusBarUpdate, 0, 120, TimeUnit.SECONDS);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exitProcedure();
            }
        });

        Properties sys = new Properties(System.getProperties());
        sys.put("com.sun.media.jai.disableMediaLib", "true");
        System.setProperties(sys);

        // Here we add some modules.
        SwingUtilities.invokeLater(() -> {
            if (showExclusionModule) metaBar.addOrbitModule(getExclusionModule());
            metaBar.addOrbitModule(getModelExplorer());
            if (Runtime.getRuntime().availableProcessors() < 2) {
                JOptionPane.showConfirmDialog(null,
                        "Orbit Image Analysis is optimized for a multi-core CPU.\n" +
                        "Your PC has only " + Runtime.getRuntime().availableProcessors() + " cores.\n" +
                        "You can still run Orbit on this PC, but it is strongly recommended to use a better PC.",
                        "Please use a better computer for Orbit.",
                        JOptionPane.OK_CANCEL_OPTION);
            }
        });

        // Set the correct text based on the image provider used.
        orbitMenu.updateMenuImageProviderEntries();

        // Display settings for the window.
        this.applyComponentOrientation(ComponentOrientation.getOrientation(Locale.getDefault()));
        Rectangle r = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getMaximumWindowBounds();
        this.setPreferredSize(new Dimension(r.width, r.height));
        this.setMinimumSize(new Dimension(r.width / 5, r.height / 3));
        this.pack();
        this.setLocation(r.x, r.y);
        this.setVisible(true);

        if (DALConfig.isCheckVersion()) {
            SwingUtilities.invokeLater(() -> {
                UpdateChecker updateChecker = new UpdateChecker();
                updateChecker.checkUpdate();
            });
        }
    }

    private void showRoiArea() throws OrbitImageServletException {
        logger.info("showRoiArea called [method call]");
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        try {
            ImageFrame iFrame = getIFrame();
            double roiAreaTemp = Double.NaN;
            if (iFrame.recognitionFrame.getROI() != null)
                roiAreaTemp = OrbitUtils.getROISize(iFrame.recognitionFrame, null);
            if (iFrame.getRdf() != null && model != null) {
                iFrame.recognitionFrame.loadAnnotationROI(iFrame.getRdf().getRawDataFileId(), model.getAnnotationGroup());
            }
            ExclusionMapGen exMapGen = null;
            if (iFrame != null && model != null) {
                if (model.getExclusionModel() != null) {
                    exMapGen = ExclusionMapGen.constructExclusionMap(iFrame.getRdf(), iFrame.recognitionFrame, model);
                    exMapGen.generateMap();
                }
                double roiArea = OrbitUtils.getROISize(iFrame.recognitionFrame, exMapGen);
                OrbitUtils.ScaleAndUnit scaleAndUnit = OrbitUtils.getImageScaleAndUnit(iFrame.getRdf());    // also works if rdf is null
                ResultFrame resultFrame;
                String res;
                if (scaleAndUnit.getUnit().equalsIgnoreCase("pixel")) {
                    res = "ROi Area (pixel): " + roiArea;
                    if (!Double.isNaN(roiAreaTemp)) res += "\nTemporary ROI Area (pixel): " + roiAreaTemp;
                } else {
                    res = "ROi Area (mm): " + roiArea / 1000000d;
                    if (!Double.isNaN(roiAreaTemp)) res += "\nTemporary ROI Area (mm): " + roiAreaTemp / 1000000d;
                }

                resultFrame = new ResultFrame(res, "ROI Area)");
                addInternalFrame(resultFrame);
            }
        } finally {
            setCursor(new Cursor((Cursor.DEFAULT_CURSOR)));
        }
    }

    public void updateStatusBar() {
        double freeSpace = OrbitUtils.getTempDiskSpace() / (1024d * 1024 * 1024); // in GB
        statusBar.setCopyright("Orbit Image Analysis Version " + OrbitUtils.VERSION_STR);
        statusBar.setTempSpaceStr("Temp Space: " + String.format("%1$.2f", freeSpace) + " GB");
        String trained = "no";
        String segModel = "no";
        String exclModel = "no";
        String mask = "no";
        if (model != null) {
            trained = (model.getClassifier() != null && model.getClassifier().isBuild()) ? "yes" : "no";
            segModel = model.getSegmentationModel() != null ? "yes" : "no";
            exclModel = model.getExclusionModel() != null ? "yes" : "no";
            mask = model.getMask()!=null ? "yes" : "no";
        }
        statusBar.setLoadedModel("Model: " + loadedModel + " / Trained:" + trained + " / Segmentation:" + segModel + " / Exclusion:" + exclModel+" Mask:" + mask);
        statusBar.setLoginUser("Login User: " + loginUser);
        statusBar.setMemory(Runtime.getRuntime().totalMemory() / (1024L * 1024L), Runtime.getRuntime().maxMemory() / (1024L * 1024L));
    }

    private boolean login() {
        logger.debug("login start");
        if (isLocalImageProvider()) {
            loginUser = GUEST_USER;
            menuLogOff.setEnabled(false);
            menuLogIn.setEnabled(true);
            updateStatusBar();
            return true;
        }
        if (OrbitLoginDialog.showLoginDialog(this) == Status.SUCCEEDED) {
            loginUser = OrbitLoginDialog.getUsername();
            loginPassword = OrbitLoginDialog.getPassword();
            menuLogOff.setText("Log off " + loginUser);
            menuLogIn.setEnabled(false);
            logger.info("user login called: " + loginUser + " [method call]");
            updateStatusBar();
            DALConfig.getImageProvider().logUsage(loginUser, "login");
            menuLogOff.setEnabled(true);
            return true;
        } else return false;
    }

    private void logoff() {
        if (isLocalImageProvider()) {
            return;
        }
        loginUser = GUEST_USER;
        OrbitLoginDialog.reset();
        menuLogOff.setEnabled(false);
        menuLogIn.setEnabled(true);
        if (DALConfig.getImageProvider().enforceLoginDialogAtStartup()) {

            DALConfig.getImageProvider().authenticateUser("", "");
            if (rdTree != null)
                rdTree.refresh();
            if (imageList != null) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        imageList.setModel(new DefaultListModel());
                    }
                });
            }

            forceLogin();
            updateStatusBar();
        } else {
            updateStatusBar();
            JOptionPane.showMessageDialog(this, "You have successfully logged off. You act as a guest user with read-only access now.", "Log off successfull", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    /**
     * Checks if the user has logged in already, otherwise the login dialog will be showed.<br/>
     * After successful login loginOk will be set to true, otherwise to false.
     */
    public void forceLogin() {
        loginOk = false;
        if (loginUser.equalsIgnoreCase("") || loginUser.equalsIgnoreCase(GUEST_USER)) {
            if (login()) loginOk = true;
            if (DALConfig.getImageProvider().enforceLoginDialogAtStartup()) {      // refresh tree and list after user change
                if (rdTree != null)
                    rdTree.refresh();
                if (imageList != null) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            imageList.setModel(new DefaultListModel());
                        }
                    });
                }
            }
        } else {
            loginOk = true;
        }
        ;
    }

    private void setLowResImagesItemsEnabled(boolean enabled) {
        if (loadlowResImageItem != null) {
            // old nimbus/toolbar UI
            loadlowResImageItem.setEnabled(enabled);
            loadmediumResImageItem.setEnabled(enabled);
            // TODO check if svs file
            loadSVSLabelItem.setEnabled(enabled);
            loadSVSOverviewItem.setEnabled(enabled);

            loadSpecialLayerItem.setEnabled(enabled);
            loadSpecialLayerItem.removeAll();
            if (loadSpecialLayerItem.isEnabled()) {
                ImageFrame iFrame = getIFrame();
                if (iFrame != null) {
                    int numImg = iFrame.recognitionFrame.bimg.getMipMaps() == null ? 0 : iFrame.recognitionFrame.bimg.getMipMaps().length;
                    if (numImg > 0) {
                        for (int i = 0; i < numImg; i++) {
                            final int mipNum = i + 1;
                            JMenuItem item = new JMenuItem("Open layer " + mipNum);
                            item.addActionListener(e -> loadLowResImage(mipNum));
                            loadSpecialLayerItem.add(item);
                        }
                    }
                }
            }
        } else {
            // new ribbon UI
            specialResImagesAvailable = enabled;
            // menu entries will be defined by popupmenu
        }

    }

    // TODO: What does this do, is it still needed?
//    class SpecialResMenu extends JPopupPanel {
//        public SpecialResMenu() {
//            if (specialResImagesAvailable) {
//                ImageFrame iFrame = getIFrame();
//                if (iFrame != null) {
//                    int numImg = iFrame.recognitionFrame.bimg.getMipMaps() == null ? 0 : iFrame.recognitionFrame.bimg.getMipMaps().length;
//                    if (numImg > 0) {
//                        for (int i = 0; i < numImg; i++) {
//                            final int mipNum = i + 1;
//                            JCommandButton btn = new JCommandButton("Open layer " + mipNum + " [" + iFrame.recognitionFrame.bimg.getMipMaps()[numImg - i - 1].getWidth() + " x " + iFrame.recognitionFrame.bimg.getMipMaps()[numImg - i - 1].getHeight() + "]");
//                            btn.addActionListener(new ActionListener() {
//                                @Override
//                                public void actionPerformed(ActionEvent e) {
//                                    loadLowResImage(mipNum);
//                                }
//                            });
//
//                            add(btn);
//                        }
//                    }
//                }
//            } else {
//                add(new JLabel("No layers available"));
//            }
//
//        }
//    }

    protected String getInfoString() {
        String infoStr = String.format("%s %s\n%s\n%s",
                resourceBundle.getString("Orbit.About.Version"),
                OrbitUtils.VERSION_STR,
                resourceBundle.getString("Orbit.About.License"),
                resourceBundle.getString("Orbit.About.Developer"));

        infoStr += "\n\nLogin User: " + loginUser;

        long freeSpace = OrbitUtils.getTempDiskSpace();
        if (freeSpace > 0) freeSpace /= 1024L * 1024; // in MB
        if (freeSpace > 0) {
            infoStr += "\nAvailable temporary disk space: " + freeSpace + " MB.";
        } else infoStr += "\nUnable to calculate available temporary disk space.";

        infoStr += "\nTile memory size (Read): " + ((OrbitTiledImage2.tileCache == null) ? "0 tiles" : (OrbitTiledImage2.tileCache.size() + " tiles"));
        infoStr += "\nTile memory capacity (Write): " +
                DiskMemImageOrbit.getCommonTileCache().getMemoryCapacity() / (1024L * 1024) + " MB";

        String tempDir = null;
        try {
            File tempFile = File.createTempFile(DiskCachedTile.FILE_PREFIX, DiskCachedTile.FILE_SUFFIX, DiskCachedTile.getCacheFolder());
            tempDir = tempFile.getParent();
            if (!tempFile.delete()) tempFile.deleteOnExit();
        } catch (IOException e) {
            logger.info(String.format("ERROR getting tile temp dir: %s", e));
        }
        infoStr += "\nTile temp directory: " + tempDir;

        infoStr += "\nJVM Memory used/total: " + Runtime.getRuntime().totalMemory() / (1024L * 1024L) + " / " + Runtime.getRuntime().maxMemory() / (1024L * 1024L) + " MB";
        infoStr += "\nAvailable Cores: " + Runtime.getRuntime().availableProcessors();
        infoStr += "\nJVM version: " + Runtime.version();

        String libDir = "unknown";
        try {
            libDir = DALConfig.getLibDir();
        } catch (URISyntaxException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        infoStr += "\nLib directory: " + libDir;
        infoStr += "\nLoaded model: " + loadedModel;

        return infoStr;
    }

    public synchronized void makeClassComboBox() {
        // Class Combobox
        if (classBox == null) {
            // Define the model that backs the selection.
            this.ccbModel = RibbonDefaultComboBoxContentModel.<ClassShape>builder()
                    .setItems(model.getClassShapes().toArray(new ClassShape[0]))
                    .build();

            this.ccbModel.addListDataListener(new ListDataListener() {
                Object selected = ccbModel.getSelectedItem();

                @Override
                public void intervalAdded(ListDataEvent e) {
                }

                @Override
                public void intervalRemoved(ListDataEvent e) {
                }

                @Override
                public void contentsChanged(ListDataEvent e) {
                    Object newSelection = ccbModel.getSelectedItem();
                    // TODO: Why does this need to be outside the if statement?
                    if (this.selected != newSelection) {
                        logger.info("New class selection -> " + newSelection);
                        updateSelectedClassShape();
                        this.selected = newSelection;
                    }
                }
            });

            classBox = new ClassComboBox(ccbModel);
        }
    }

    private synchronized void updateSelectedClassShape() {
        ClassShape classShape = (ClassShape) classBox.getSelectedItem();
        int classNum = classBox.getSelectedIndex();
        for (ImageFrame iFrame : getIFrames()) {
            iFrame.recognitionFrame.getMyListener().setDeleteMode(false);
            // TODO: classNum should be in synch! (-> bug in segmentation with more than two classes?)
            if (classNum < iFrame.recognitionFrame.getClassShapes().size())
                iFrame.recognitionFrame.getMyListener().setShapeList(iFrame.recognitionFrame.getClassShapes().get(classNum).getShapeList(), classShape.getShapeType(), classShape.getName());
            else {
                logger.debug("classes are not in sync (updateSelectedClassShape) " + classNum);
            }
        }
    }

    /**
     * @param shapes the list of ClassShape items to add to the ClassComboBox model
     */
    private synchronized void updateCcbModel(List<ClassShape> shapes) {
        /*  It's not possible to remove all old and add all new since
            this will cause Radiance to NPE as it tries to refresh
            an empty combobox. So we first add the new items and then
            remove the old. It is probably also possible to detach and
            reattach the listener as an alternative method.
         */
        int ccbModelLength = ccbModel.getSize();
        RibbonDefaultComboBoxContentModel<ClassShape> oldCcbModel = ccbModel;
        ccbModel.addAll(shapes);

        for( int i=0; i<ccbModelLength; i++ ) {
            Object elem = oldCcbModel.getElementAt(0);
            ccbModel.removeElement(elem);
        }
    }

//    protected JButton makeNavigationButton(final ActionListener actionListener, String toolTipText, String altText) {
//        JButton button = new JButton();
//        button.setToolTipText(toolTipText);
//        button.addActionListener(actionListener);
//        button.setText(altText);
//        return button;
//    }

    private void toggleMarkup() {
        if (getIFrame() != null) {
            getIFrame().recognitionFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            getIFrame().recognitionFrame.setDrawMarkup(!getIFrame().recognitionFrame.isDrawMarkup());
            getIFrame().recognitionFrame.repaint();
        }
    }
//            if (toggleMarkupButton != null && showMarkupCheckbox != null) {  // not used for new ribbon menu anymore
//                showMarkupCheckbox.setSelected(getIFrame().recognitionFrame.isDrawMarkup());
//                if (OrbitUtils.DARKUI) {
//                    if (getIFrame().recognitionFrame.isDrawMarkup())
//                        toggleMarkupButton.setIcon(new ImageIcon(this.getClass().getResource("/resource/icon_v_switch2_on.png"), "toggel markup"));
//                    else
//                        toggleMarkupButton.setIcon(new ImageIcon(this.getClass().getResource("/resource/icon_v_switch2_off.png"), "toggel markup"));
//                }
//            }
//
//        }
//    }


    private synchronized void train() {
        logger.info("train called [method call]");
        model.setUser(loginUser);
        TrainWorker trainWorker = new TrainWorker(getIFrames(), true, performClustering, model); // second last parameter: classification(true) or clustering(false)
        ProgressPanel progressPanel = new ProgressPanel(getCurrentPicName(), "Training", trainWorker);
        addAndExecuteTask(progressPanel);
        modifiedClassShapes = false;
    }

    private void classify() {
        OrbitModel localModel = new OrbitModel(this.model); // clone model
        logger.info("classify called [method call]");
        if ((localModel.getClassifier() == null) || (!(localModel.getClassifier().isBuild()))) {
            JOptionPane.showMessageDialog(this, "Model not trained.\nPlease mark some class regions and click on train first.", "Model not trained", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ImageFrame iFrame = getIFrame();
        reloadROI(iFrame);

        RecognitionFrame rf = iFrame.recognitionFrame;
        RecognitionFrame oriRf = null;

        if (rf.getROI() == null || (rf.getROI() instanceof ShapeAnnotationList)) {
            RawDataFile rdf = iFrame.getRdf();
            if (rdf != null && rdf.getRawDataFileId() > 0) {
                int annoGroup = localModel.getAnnotationGroup();
                if (annoGroup < 0 && localModel.isLoadAnnotationsAsInversROI()) {
                    annoGroup = 0;// 0 means all
                }
                logger.debug("use annotations as ROI group: " + annoGroup);
                rf.loadAnnotationROI(rdf.getRawDataFileId(), annoGroup);
                logger.trace("recognition frame roi: " + iFrame.recognitionFrame.getROI());

            }
        }
        rf.setClassImageScale(1f); // reset if changed before (is changed for e.g. exclusion map)

        // level set start
        int level = localModel.getMipLayer();
        logger.debug("used special layer for recognitionFrame construction (classification): " + level + " on image with level " + iFrame.getMipLayer());
        if (level < 0) throw new IllegalArgumentException("special layer < 0 is not allowed");
        if (level > 0 && (iFrame.getMipLayer() != level)) {
            RawDataFile rdf = iFrame.getRdf();
            if (rdf == null) throw new IllegalArgumentException("level set but rdf is null");
            oriRf = rf;
            rf = new RecognitionFrame(iFrame.recognitionFrame, rdf, level - 1);
        }
        // level set end

        logger.trace("classify recognitionFrame with width: {} and ROI: {}", rf.bimg.getWidth(), rf.getROI());
        // ExclusionMapGen exMap =  ExclusionMapGen.constructExclusionMap(rf,model);
        ExclusionMapGen exMap = ExclusionMapGen.constructExclusionMap(iFrame.getRdf(), rf, localModel, null);
        ClassificationWorker worker = new ClassificationWorker(iFrame.getRdf(), rf, localModel, true, exMap, null);
        worker.setPixelFuzzyness(pixelFuzzyness);
        worker.setTileFuzzyness(tileFuzzyness);
        worker.setOriginalFrame(oriRf);
        ProgressPanel progressPanel = new ProgressPanel(getCurrentPicName(), "Classification", worker);
        addAndExecuteTask(progressPanel);

        // TODO: Look at this.
        if (false) {
            while (!worker.isDone()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        iFrame.getOpacitySlider().setEnabled(true);
    }


    private void classifyNucleid() {
        logger.info("classifyNucleid called [method call]");
        if ((model.getClassifier() == null) || (!(model.getClassifier().isBuild()))) {
            logger.trace("classifyNucleid: Performing a classifier training first.");
            ObjectTrainWorker objectTrainWorker = new ObjectTrainWorker(getIFrames(), model);
            ProgressPanel pp = new ProgressPanel("", "Cell Training", objectTrainWorker);
            addAndExecuteTask(pp);
            waitForWorker(objectTrainWorker);
        }

        ImageFrame iFrame = getIFrame();
        // vessleList = new ArrayList<Shape>();
        // last parameter in NucleidClassificationWorker: classShapesToSet - this was for vessle detection, but in "normal" mode it can be set to null! (Manuel 22.10.2010)
        reloadROI(iFrame);
        OrbitModel cModel = new OrbitModel(model);

        RecognitionFrame rf = iFrame.recognitionFrame;
        RecognitionFrame oriRf = null;
        rf.setObjectSegmentationColors(null); // reset heatmap

        // level set start
        int level = model.getMipLayer();
        logger.debug("used special layer for recognitionFrame construction (cell classification): " + level);
        if (level < 0) throw new IllegalArgumentException("special layer < 0 is not allowed");
        if (level > 0 && (iFrame.getMipLayer() != level)) {
            RawDataFile rdf = iFrame.getRdf();
            if (rdf == null) throw new IllegalArgumentException("level set but rdf is null");
            oriRf = rf;
            rf = new RecognitionFrame(iFrame.recognitionFrame, rdf, level - 1); // level is mip number, not index
            logger.debug("object classification level loaded: " + level);

            List<ClassShape> classShapesToSet = model.getSegmentationModel().getClassShapes();
            ObjectSegmentationWorker segWorker = new ObjectSegmentationWorker(iFrame.getRdf(), rf, null, classShapesToSet, null);
            segWorker.setModel(model);
            segWorker.setExclusionMap(ExclusionMapGen.constructExclusionMap(iFrame.getRdf(), rf, model, rf.getROI()));
            segWorker.setHeatmapFeature(isShowObjectHeatmap() ? ObjectFeatureBuilderTiled.FeatureAreaNumReverse : -1); // 4 means numFeatures-4=area, otherwise -1 means deactivate heatmap
            segWorker.setOriginalFrame(oriRf);
            segWorker.run();
        }
        // level set end

        ObjectClassificationWorker worker = new ObjectClassificationWorker(rf, cModel, cModel.getClassShapes());
        worker.setGenerateTaskResult(true);
        worker.setOriginalFrame(oriRf);
        ProgressPanel progressPanel = new ProgressPanel(getCurrentPicName(), "Object Classification", worker);
        addAndExecuteTask(progressPanel);
        iFrame.getOpacitySlider().setEnabled(true);
    }

    private void trainClassifyNucleid() {
        logger.info("trainClassifyNucleid called [method call]");
        ObjectTrainWorker objectTrainWorker = new ObjectTrainWorker(getIFrames(), model);
        ProgressPanel pp = new ProgressPanel("", "Cell Training", objectTrainWorker);
        addAndExecuteTask(pp);
        modifiedClassShapes = false;
    }


    private OrbitWorker objectSegmentation(boolean withGUI, boolean orderPoints) {
        logger.info("objectSegmentation called [method call]");
        OrbitModel localModel = new OrbitModel(this.model);
        ImageFrame iFrame = getIFrame();

        if (localModel.getSegmentationModel() == null) {
            JOptionPane.showMessageDialog(this, "No primary segmentation model available.\nPlease first define a segmentation model and click the 'set primary segmentation model' button.", "No segmentation model available", JOptionPane.ERROR_MESSAGE);
            return null;
        } else {
            if (localModel.getSegmentationModel().getClassShapes().size() < 2)
                throw new IllegalArgumentException("classShapesToSet.size should be >= 2 bit is " + localModel.getSegmentationModel().getClassShapes().size());
        }

        reloadROI(iFrame);
        iFrame.getOpacitySlider().setEnabled(true);
        IScaleableShape fixedROI = null;
        if (localModel.getFixedCircularROI() > 0) {
            fixedROI = new Arc2DExt();
            ((Arc2DExt) fixedROI).setArcByCenter((iFrame.recognitionFrame.bimg.getWidth() / 2d) + localModel.getFixedROIOffsetX(), (iFrame.recognitionFrame.bimg.getHeight() / 2d) + localModel.getFixedROIOffsetY(), localModel.getFixedCircularROI(), 0, 360, Arc2DExt.CHORD);
        }

        List<Point> tiles = new ArrayList<Point>();
        tiles = null;

        IScaleableShape segROI = fixedROI;
        if (iFrame.recognitionFrame.getROI() == null) {
            RawDataFile rdf = iFrame.getRdf();
            if (rdf != null && rdf.getRawDataFileId() > 0) {
                int annoGroup = localModel.getAnnotationGroup();
                if (annoGroup < 0 && localModel.isLoadAnnotationsAsInversROI()) {
                    annoGroup = 0;// 0 means all
                }
                logger.debug("use annotations as ROI group: " + annoGroup);
                iFrame.recognitionFrame.loadAnnotationROI(rdf.getRawDataFileId(), annoGroup);
                logger.trace("recognition frame roi: " + iFrame.recognitionFrame.getROI());
            }
        }

        RecognitionFrame rf = iFrame.recognitionFrame;
        RecognitionFrame oriRf = null;
        rf.setObjectSegmentationColors(null); // reset heatmap

        // level set start
        int level = localModel.getSegmentationModel().getMipLayer();    // upd 22.09.2015
        logger.debug("used special layer for recognitionFrame construction (segmentation): " + level);
        if (level < 0) throw new IllegalArgumentException("special layer < 0 is not allowed");
        if (level > 0 && (iFrame.getMipLayer() != level)) {
            RawDataFile rdf = iFrame.getRdf();
            if (rdf == null) throw new IllegalArgumentException("level set but rdf is null");
            oriRf = rf;
            rf = OrbitUtils.getMipRecognitionFrame(rf,rdf,level);
        }
        // level set end


        if (segROI == null) segROI = rf.getROI();
        rf.setROI(segROI);
        List<ClassShape> classShapesToSet = localModel.getSegmentationModel().getClassShapes();
        ObjectSegmentationWorker segWorker = new ObjectSegmentationWorker(iFrame.getRdf(), rf, null, classShapesToSet, tiles);


        if (oriRf != null) {
            segWorker.setDontClassify(false);
            segWorker.setOriginalFrame(oriRf);
        }
        segWorker.setModel(localModel);
        segWorker.setExclusionMap(ExclusionMapGen.constructExclusionMap(iFrame.getRdf(), rf, localModel, segROI));
        segWorker.setHeatmapFeature(isShowObjectHeatmap() ? ObjectFeatureBuilderTiled.FeatureAreaNumReverse : -1); // 4 means numFeatures-4=area, otherwise -1 means deactivate heatmap
//			  segWorker.setDontClassify(true);
        ProgressPanel progressPanel2 = new ProgressPanel(getCurrentPicName(), "Object Segmentation", segWorker);
        addAndExecuteTask(progressPanel2, true);
        return segWorker;
    }

    private void reloadROI(ImageFrame iFrame) {
        logger.info("reloadROI called [method call]");
        try {
            if (iFrame.getRdf() != null) {
                IScaleableShape annotationROI = OrbitUtils.loadAnnotationROI(iFrame.getRdf().getRawDataFileId(), model.getAnnotationGroup());
                if (annotationROI != null) {
                    if (Math.abs(iFrame.recognitionFrame.getMipScale() - 1d) > OrbitUtils.EPSILON) {
                        annotationROI = (IScaleableShape) annotationROI.getScaledInstance(((iFrame.recognitionFrame.getMipScale()) * 100d), new Point(0, 0));
                        annotationROI.setScale(100d);
                    }
                    IScaleableShape userROI = iFrame.recognitionFrame.getROI();
                    if ((userROI == null) || (userROI instanceof ShapeAnnotationList)) {
                        userROI = annotationROI;
                    }
                    iFrame.recognitionFrame.setROI(userROI);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("error loading ROI", e);
        }
    }


    /**
     * sets the classShape list as reference class shapes and in all iFrames
     *
     * @param classShapes
     */
    private void setClassShapes(List<ClassShape> classShapes, FeatureDescription featureDescription, boolean setCurrentModel) {
        if (setCurrentModel) {
            model.setClassShapes(classShapes);
            model.setFeatureDescription(featureDescription);
        }
        for (ImageFrame iFrame : getIFrames()) {
            iFrame.recognitionFrame.setClassShapes(classShapes);
            iFrame.recognitionFrame.setFeatureDescription(featureDescription);
        }
    }


    /**
     * adds the progressPanel to the taskPanel and executes the (swing)worker inside the panel.<br>
     * withGUI=true.
     *
     * @param progressPanel
     */
    public void addAndExecuteTask(ProgressPanel progressPanel) {
        addAndExecuteTask(progressPanel, true);
    }

    /**
     * adds the progressPanel to the taskPanel and executes the (swing)worker inside the panel.
     *
     * @param progressPanel
     */
    public void addAndExecuteTask(ProgressPanel progressPanel, boolean withGUI) {
        taskPanel.add(progressPanel);
        progressPanel.getWorker().setWithGUI(withGUI);
        progressPanel.getWorker().addPropertyChangeListener(progressPanel);
        progressPanel.getWorker().addPropertyChangeListener(this);
        progressPanel.addPropertyChangeListener(this);
        propertyPanel.revalidate();
        progressPanel.getWorker().execute();
    }

    public void addWithoutExecuteTask(ProgressPanel progressPanel, boolean withGUI) {
        taskPanel.add(progressPanel);
        progressPanel.getWorker().setWithGUI(withGUI);
        progressPanel.getWorker().addPropertyChangeListener(progressPanel);
        progressPanel.getWorker().addPropertyChangeListener(this);
        progressPanel.addPropertyChangeListener(this);
        propertyPanel.revalidate();
        //progressPanel.getWorker().execute();
    }

    public String getCurrentPicName() {
        String picName = getIFrame().getTitle();
        if (picName != null) {
            if (picName.length() > 15) picName = picName.subSequence(0, 14) + "...";
        }
        return picName;
    }


    public void loadFileDirect(File file) {
        logger.info("loadFileDirect called [method call]");

        // switch image provider
        if (!isLocalImageProvider()) {
            if (JOptionPane.showConfirmDialog(this,
                    "To open a local file you have to switch to image provider local.\nDo you want to switch to image provider local now?\n\n(You can switch to remote image provider later via Image->Switch Local / Remote Image Provider)",
                    "Switch to local image provider?", JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {
                switchLocalRemoteImageProvider();
            }
        }

        if (isLocalImageProvider()) {
            ImageProviderLocal ipl = (ImageProviderLocal)DALConfig.getImageProvider();
            try {
                RawDataFile rdf = ipl.registerFile(file,0);
                loadFile(rdf);
                logger.info("image with series 0 loaded. To load another series of this file please use the open file dialog");
            } catch (SQLException e) {
                logger.error("Cannot register file: "+e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(OrbitImageAnalysis.this,"To open a file from local filesystem you have to switch the image provider to local.\nPlease click Image->Switch Image provider local/remote and then try to open the image again.","Local file image provider not active",JOptionPane.ERROR_MESSAGE);
        }

    }


    private void loadFileOrbit() {
        logger.info("loadFileOrbit called [method call]");
        try {
            List<RawDataFile> rdfList = browseImages();
            if (rdfList == null) logger.debug("open image canceled.");
            else if (rdfList.size() == 0) logger.debug("No file selected.");
            else {
                for (RawDataFile rdf : rdfList) {
                    loadFile(rdf);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error browsing files: " + e.getMessage());
        }

    }


    private void embedIFrame(ImageFrame iFrame) {
        logger.trace("embeddigFrame: " + iFrame);
        TiledImageWriter.timeOut.set(System.currentTimeMillis());
        iFrame.setVisible(true);
        iFrame.setAutoscrolls(false);
        iFrame.setResizable(true);
        iFrame.setBounds(10, 10, 500, 500);
        iFrame.setPreferredSize(new Dimension(iFrame.recognitionFrame.getWidth(), iFrame.recognitionFrame.getHeight()));
        iFrame.setRenderGrid(renderGrid);
        iFrame.addPropertyChangeListener(this);
        iFrame.addPropertyChangeListener(scaleSlider);
        iFrame.addPropertyChangeListener(loupeWithScale.getLoupe());
        this.addPropertyChangeListener(iFrame);

        addInternalFrame(iFrame);

        // from now on we can use getIFrame() because it is the selected frame
        renderGrid.setImage(null); // force a new scaled rendering
        renderGrid.setScale(1d);
        renderGrid.setFullImage(getIFrame().recognitionFrame.bimg);
        renderGrid.paintImmediately(0, 0, renderGrid.getWidth(), renderGrid.getHeight());
        renderGrid.setViewportSize(getIFrame().getSize());
        renderGrid.setImageSize(new Dimension(getIFrame().recognitionFrame.bimg.getWidth(), getIFrame().recognitionFrame.bimg.getHeight())); // scale?
//	 		    renderGrid.addPropertyChangeListener(getIFrame());
        renderGrid.repaint();

        loupeWithScale.getLoupe().setImage(getIFrame().recognitionFrame.bimg);
        loupeWithScale.getLoupe().repaint();

        updateClassShapes(model.getClassShapes());

        getIFrame().repaint();

        PropertyChangeEvent pce = new PropertyChangeEvent(this, ImageFrame.SCALE_SET_EVENT, null, 100d);
        getIFrame().propertyChange(pce);

        // center image in view
        Point vp = new Point((iFrame.recognitionFrame.bimg.getWidth() / 2) - (iFrame.getWidth() / 2), (iFrame.recognitionFrame.bimg.getHeight() / 2) - (iFrame.getHeight() / 2));
        iFrame.recognitionFrame.setViewPortOffset(vp);
        iFrame.setViewPortPosAndSize(vp, new Dimension(iFrame.getWidth(), iFrame.getHeight()));

        renderGrid.setViewportPosition(vp);
        loupeWithScale.getLoupe().componentResized(null);
        propertyPanel.revalidate();
        propertyPanel.repaint();
        iFrame.firePropertyChangeExt(ImageFrame.SCALE_EVENT, null, 0d);
    }


    public void loadFile(RawDataFile imageSource) {
        loadFile(imageSource, null, true);
    }

    public ImageFrame loadFile(Object imageSource, String iFrameTitle, boolean loadChannels) {
        Cursor oldCursor = getCursor();
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        logger.info("loading image: " + imageSource.toString());
        // de-select other iFrames
        List<ImageFrame> iFrames = getIFrames();
        if (iFrames != null && iFrames.size() > 0) {
            for (ImageFrame iFrame : iFrames) {
                try {
                    iFrame.setSelected(false);
                } catch (PropertyVetoException e) {
                    e.printStackTrace();
                }
            }
        }

        this.setTitle(title);
        try {
            ImageFrame iFrame = null;
            if (imageSource instanceof String && (((String) imageSource).toLowerCase().endsWith(".zvi") || ((String) imageSource).toLowerCase().endsWith(".lif"))) {
                try {
                    String fn = (String) imageSource;
                    int numPages = 1;
                    if (((String) imageSource).toLowerCase().endsWith(".zvi"))
                        numPages = TiffConverter.getNumPagesInZVI(fn);
                    if (((String) imageSource).toLowerCase().endsWith(".lif"))
                        numPages = TiffConverter.getNumPagesInLIF(fn);
                    RecognitionFrame[] frames = new RecognitionFrame[numPages];
                    for (int p = 0; p < numPages; p++) { // read all pages in zvi or lif images
                        String fnPage = TiffConverter.generatePseudoMultiPageFileName(fn, p);
                        frames[p] = new RecognitionFrame(fnPage, false);
                        frames[p].setClassImage(null);
                        frames[p].setScale(100d);
                        frames[p].setFeatureDescription(model.getFeatureDescription());
                        if (p > 0) embedIFrame(new ImageFrame(frames[p]));
                        else iFrame = new ImageFrame(frames[p]); // first image will be embedded later
                    }
                } catch (Exception ex) {
                    logger.error(String.format("error reading zvi image: %s", ex));
                }
            } else {
                RecognitionFrame recognitionFrame = new RecognitionFrame(imageSource, false);
                iFrame = new ImageFrame(recognitionFrame);
            }
            scaleSlider.setValue(400);
            iFrame.getOpacitySlider().setValue(0);
            iFrame.recognitionFrame.setClassImage(null);
            iFrame.recognitionFrame.setScale(100d);
            iFrame.recognitionFrame.setFeatureDescription(model.getFeatureDescription());

            if (imageSource instanceof RawDataFile) {
                RawDataFile rdf = (RawDataFile) imageSource;
                iFrame.setRdf(rdf);

                // meta data
                try {
                    if (rdf.getRawDataId() <= 0) logger.warn("RawData not set for RawDataFile " + rdf.toStringDetail());
                    RawData rd = DALConfig.getImageProvider().LoadRawData(rdf.getRawDataId());
                    metaBar.listMetas(rdf);
                    metaBar.loadImageAdjustmentsFromDB(iFrame);
                    metaBar.repaint();
                    if (rd!=null && rd.getOrigin() != null && rd.getOrigin().equalsIgnoreCase("metasystems")) {           // TODO!!!
                        iFrame.recognitionFrame.setMuMeterPerPixel(0.322177822177822d/*((double)6.45/9.96d)/2d*/); // correction factor: 2,0100401606425713905420130132919
                    }


                    if (metaBar.getRawDataFileMetas() != null) {
                        if (metaBar.getRawDataFileMetas().getMetaHash().containsKey("Zeiss.Scale Factor for X")) {
                            RawMeta scaleMeta = metaBar.getRawDataFileMetas().getMetaHash().get("Zeiss.Scale Factor for X");
                            iFrame.recognitionFrame.setMuMeterPerPixel(Double.parseDouble(scaleMeta.getValue()));
                            iFrame.recognitionFrame.setGaugeColor(Color.green);
                        }
                        if (metaBar.getRawDataFileMetas().getMetaHash().containsKey(RawUtilsCommon.STR_META_IMAGE_SCALE)) {
                            RawMeta scaleMeta = metaBar.getRawDataFileMetas().getMetaHash().get(RawUtilsCommon.STR_META_IMAGE_SCALE);
                            iFrame.recognitionFrame.setMuMeterPerPixel(Double.parseDouble(scaleMeta.getValue()));
                            iFrame.recognitionFrame.setGaugeColor(Color.green);
                        }
                        if (metaBar.getRawDataFileMetas().getMetaHash().containsKey("ImageDescription")) {
                            RawMeta rm = metaBar.getRawDataFileMetas().getMetaHash().get("ImageDescription");
                            if (rm.getValue().contains("Aperio")) {
                                iFrame.recognitionFrame.setGaugeColor(Color.black);  // aperio images have a black gauge
                            }
                        }
                        if (metaBar.getRawDataFileMetas().getMetaHash().containsKey("Artist")) {
                            RawMeta rm = metaBar.getRawDataFileMetas().getMetaHash().get("Artist");
                            if (rm.getValue().contains("MetaSystems")) {
                                iFrame.recognitionFrame.setGaugeColor(Color.black);  // metasystems images have a black gauge
                            }
                        }
                        if ((long) iFrame.recognitionFrame.bimg.getWidth() * iFrame.recognitionFrame.bimg.getHeight() > 5000L * 5000L) {
                            iFrame.recognitionFrame.setGaugeColor(Color.black); // big images (slide images) have a black gauge
                        }
                        if (metaBar.getRawDataFileMetas().getMetaHash().containsKey(RawUtilsCommon.STR_META_CHANNEL) || metaBar.getRawDataFileMetas().getMetaHash().containsKey(RawUtilsCommon.STR_META_IMAGE_CHANNEL_NAME)) {
                            iFrame.recognitionFrame.setGaugeColor(Color.white);  // channels->assume fluorescence -> white
                        }
                        if (metaBar.getRawDataFileMetas().getMetaHash().containsKey("Fluorescence Channels")) {
                            iFrame.recognitionFrame.setGaugeColor(Color.white);  // channels->assume fluorescence -> white
                        }
                        if (getMultiChannelImage(iFrame)!=null) {     // fluo image
                            iFrame.recognitionFrame.setGaugeColor(Color.white);
                        }

                    }

                } catch (Exception e) {
                    logger.error("cannot load rawData", e);
                }
                if (iFrameTitle != null) {
                    iFrame.setTitle(iFrameTitle);
                }
                // annotations
                loadAnnotations(iFrame, false);
                if (loadChannels) {
                    iFrame.loadChannels();
                }
            }

            embedIFrame(iFrame);
            return iFrame;
        } catch (OrbitImageServletException oe) {
            logger.error("error loading image", oe);
            return null;
        } finally {
            setCursor(oldCursor);
        }

    }

    private IOrbitImageMultiChannel getMultiChannelImage(ImageFrame iFrame) {
        if (iFrame!=null) {
            OrbitTiledImage2 img = iFrame.recognitionFrame.bimg.getImage();
            if (img instanceof OrbitTiledImageIOrbitImage) {
                IOrbitImage oi = ((OrbitTiledImageIOrbitImage) img).getOrbitImage();
                if (oi instanceof IOrbitImageMultiChannel) {
                    final IOrbitImageMultiChannel oim = (IOrbitImageMultiChannel) oi;
                    return oim;
                }
            }
        }
        return null;
    }

    private void loadAnnotations(ImageFrame iFrame, boolean onlySyncWithMetabar) {
        metaBar.getAnnotationPanel().clear();
        try {
            if (!onlySyncWithMetabar && iFrame.getRdf() != null) {
                List<RawAnnotation> ras = DALConfig.getImageProvider().LoadRawAnnotationsByRawDataFile(iFrame.getRdf().getRawDataFileId(), RawAnnotation.ANNOTATION_TYPE_IMAGE);
                FilteredListModel<ImageAnnotation> model = metaBar.getAnnotationPanel().getModel();
                for (RawAnnotation ra : ras) {
                    if (ra.getRawAnnotationType() == RawAnnotation.ANNOTATION_TYPE_IMAGE) {
                        ImageAnnotation ia = new ImageAnnotation(ra);
                        if (!(ia instanceof SpotAnnotation && ((SpotAnnotation) ia).getSpotType() != SpotAnnotation.SPOT_TYPE_GENERAL)) {
                            model.addElement(ia);
                            iFrame.recognitionFrame.getAnnotations().add(ia);
                        }
                    }
                }
                //filtering will be done later (around line 3306)
            }


            // link embedded annotations to list
            if (iFrame.recognitionFrame.getAnnotations() != null) {
                FilteredListModel<ImageAnnotation> model = metaBar.getAnnotationPanel().getModel();
                metaBar.getAnnotationPanel().getAnnoListAdjusting().set(true);
                metaBar.getAnnotationPanel().getList().setValueIsAdjusting(true);
                DefaultListModel rareObjectDetectionModel = null;
                DefaultListModel manualClassificationModel = null;
                DefaultListModel boxCountModel = null;
                if (rareObjectDetectionModule != null) {
                    rareObjectDetectionModel = rareObjectDetectionModule.getListModel();
                }
                if (manualClassificationModule != null) {
                    manualClassificationModel = manualClassificationModule.getListModel();
                }
                if (manualBoxCountModule != null) {
                    boxCountModel = manualBoxCountModule.getListModel();
                }

                List<ImageAnnotation> annotations = iFrame.recognitionFrame.getAnnotations();
                synchronized (annotations) {
                    for (ImageAnnotation anno : annotations) {
                        try {
                            anno.getData(); // throws an exception if annotation is corrupt
                            if (!model.contains(anno)) {
                                if (!(anno instanceof SpotAnnotation && ((SpotAnnotation) anno).getSpotType() != SpotAnnotation.SPOT_TYPE_GENERAL)) {
                                    model.addElement(anno);
                                }
                            }
                            if (rareObjectDetectionModel != null && !rareObjectDetectionModel.contains(anno)) {
                                if ((anno instanceof SpotAnnotation && ((SpotAnnotation) anno).getSpotType() == SpotAnnotation.SPOT_TYPE_RAREEVENT)) {
                                    rareObjectDetectionModel.addElement(anno);
                                }
                            }
                            if (boxCountModel != null && !boxCountModel.contains(anno)) {
                                if ((anno instanceof ManualClassSpotAnnotation && ((SpotAnnotation) anno).getSpotType() == SpotAnnotation.SPOT_TYPE_BOXCOUNT)) {
                                    boxCountModel.addElement(anno);
                                }
                            }
                            if (manualClassificationModel != null && !manualClassificationModel.contains(anno)) {
                                if ((anno instanceof ManualClassSpotAnnotation && ((SpotAnnotation) anno).getSpotType() == SpotAnnotation.SPOT_TYPE_GENERAL)) {
                                    manualClassificationModel.addElement(anno);
                                }
                            }
                        } catch (Exception ex) {
                            // do nothing
                        }
                    }
                } // sync
                metaBar.getAnnotationPanel().getList().clearSelection();
                metaBar.getAnnotationPanel().getList().setValueIsAdjusting(false);
                metaBar.getAnnotationPanel().getAnnoListAdjusting().set(false);
            }

            // filtering
            metaBar.getAnnotationPanel().getModel().filter();

        } catch (Exception e) {
            logger.error("error loadning annotations", e);
            e.printStackTrace();
        }


    }

    private void loadLowResImage(int mipNum) {
        logger.info("loadLowResImage called [method call]");
        ImageFrame iFrame = getIFrame();
        if (iFrame == null) {
            JOptionPane.showMessageDialog(this, "Cannot load a low resolution image. Please open a big image first.", "Cannot load low resolution image", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (iFrame.recognitionFrame.bimg.getMipMaps() == null || iFrame.recognitionFrame.bimg.getMipMaps().length < mipNum) {
            JOptionPane.showMessageDialog(this, "Cannot load a low resolution image. Please open a big image first. (No MIP with mipNum " + mipNum + " found.)", "Cannot load low resolution image", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int numMIPS = iFrame.recognitionFrame.bimg.getMipMaps().length;
        int mipUsed = (numMIPS - mipNum);  // +1 ???
        ImageFrame newFrame = new ImageFrame(new RecognitionFrame(iFrame.recognitionFrame, mipUsed, true));
        if (mipNum == 1)
            newFrame.setTitle("LOWRES-" + newFrame.getTitle());
        else if (mipNum == 2)
            newFrame.setTitle("MEDRES-" + newFrame.getTitle());
        else newFrame.setTitle("Layer-" + mipNum + ": " + newFrame.getTitle());

        // attach mips layers
        if (iFrame.recognitionFrame.bimg.getMipMaps() != null && iFrame.recognitionFrame.bimg.getMipMaps().length > mipUsed) {
            newFrame.recognitionFrame.bimg.setMipMaps(Arrays.copyOfRange(iFrame.recognitionFrame.bimg.getMipMaps(), mipUsed + 1, iFrame.recognitionFrame.bimg.getMipMaps().length));
            newFrame.recognitionFrame.bimg.setGenerateMipMaps(true);
        }
        newFrame.setRdf(iFrame.getRdf());
        newFrame.setMipLayer(mipUsed + 1); //+1 becauase it represents the n-th mip-layer (not index) -> 0 means original image
        newFrame.getOpacitySlider().setValue(0);
        newFrame.recognitionFrame.setClassImage(null);
        newFrame.recognitionFrame.setScale(100d);
        scaleSlider.setValue(400);
        embedIFrame(newFrame);
        newFrame.adjustViewport();
        newFrame.revalidate();
        newFrame.repaint();
    }

    private void loadSpecialImage(int levelNum) {
        logger.info("loadSpecialImage called [method call]: levelNum=" + levelNum);
        ImageFrame iFrame = getIFrame();
        if (iFrame == null || iFrame.getRdf() == null) {
            JOptionPane.showMessageDialog(this, "Cannot load special image. Please open a big image first.", "Cannot load special image", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            RawDataFile rdf = iFrame.getRdf();
            String title = iFrame.getTitle();
            if (levelNum == RawUtilsCommon.LEVEL_LABEL) title += " [Label]";
            if (levelNum == RawUtilsCommon.LEVEL_OVERVIEW) title += " [Overview]";



            ImageFrame newFrame = new ImageFrame(new RecognitionFrame(iFrame.recognitionFrame, rdf, levelNum));
            if (newFrame.recognitionFrame == null || newFrame.recognitionFrame.bimg == null || newFrame.recognitionFrame.bimg.getImage() == null) {
                return; // not available
            }
            // attach mips layers
            if (iFrame.recognitionFrame.bimg.getMipMaps() != null && iFrame.recognitionFrame.bimg.getMipMaps().length > levelNum) {
                newFrame.recognitionFrame.bimg.setMipMaps(Arrays.copyOfRange(iFrame.recognitionFrame.bimg.getMipMaps(), levelNum + 1, iFrame.recognitionFrame.bimg.getMipMaps().length));
                newFrame.recognitionFrame.bimg.setGenerateMipMaps(true);
            }

            newFrame.setMipLayer(levelNum + 1);
            newFrame.setTitle(title);
            newFrame.getOpacitySlider().setValue(0);
            newFrame.recognitionFrame.setClassImage(null);
            newFrame.recognitionFrame.setScale(100d);
            scaleSlider.setValue(400);
            embedIFrame(newFrame);
            newFrame.adjustViewport();
            newFrame.revalidate();
            newFrame.repaint();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cannot load special image. Please open a virtual slide image first.", "Cannot load special image", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadThumbnailImage() {
        logger.info("loadThumbnailImage called [method call]");
        ImageFrame iFrame = getIFrame();
        if (iFrame == null) {
            JOptionPane.showMessageDialog(this, "Cannot load an overview image. Please open an overview image first.", "Cannot load overview image", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (iFrame.getRdf() == null) {
            JOptionPane.showMessageDialog(this, "Cannot load an overview image. The image has to be loaded from Orbit.", "Cannot load overview image", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {

            TiledImagePainter[] mips = iFrame.recognitionFrame.bimg.getMipMaps();
            if (mips == null || mips.length < 1) {
                throw new Exception("No layers found");
            }
            int mipNum = mips.length - 1;
            logger.debug("overview image: selected mipNum " + mipNum + " of " + mips.length);
            RecognitionFrame rf = new RecognitionFrame(iFrame.recognitionFrame, mipNum, true); // mipNum=4
            BufferedImage bi = rf.bimg.getImage().getAsBufferedImage();
            for (int i = 0; i < 10; i++) bi = TiffConverter.blurImage(bi).getAsBufferedImage();
            bi = TiffConverter.getScaledImage(bi, -1, 300);
            rf.bimg = new TiledImagePainter(PlanarImage.wrapRenderedImage(bi), "thumbnail");

            ImageFrame newFrame = new ImageFrame(rf);

            newFrame.setTitle("THUMBNAIL-" + newFrame.getTitle());
            newFrame.setMipLayer(mipNum);
            newFrame.getOpacitySlider().setValue(0);
            newFrame.recognitionFrame.setClassImage(null);
            newFrame.recognitionFrame.setScale(100d);
            scaleSlider.setValue(400);
            embedIFrame(newFrame);
            newFrame.adjustViewport();
            newFrame.revalidate();
            newFrame.repaint();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error opening overview image", e);
        }
    }


    private void batchExportMapReduce(final boolean useScaleout)   // mapreduce
    {
        if (!checkClassNames()) {
            JOptionPane.showMessageDialog(this, "Class names of main model and class names of exclusion model must be different.\nPlease open class setup and change the class names.", "Class names must be unique", JOptionPane.ERROR_MESSAGE);

        }
        logger.info("batchExportMapReduce called [method call]; useScaleout: " + useScaleout);
        try {
            List<RawDataFile> rdfList = browseImages();
            if (rdfList == null) logger.debug("open image canceled.");
            else if (rdfList.size() == 0) logger.debug("No file selected.");
            else {
                OrbitWorker worker = createBatchWorker(model, rdfList, useScaleout);
                if (worker != null) {
                    ProgressPanel pp = new ProgressPanel(rdfList.size() + " images", "Batch Export", worker);
                    addAndExecuteTask(pp);
                } else logger.info("Batch mode canceled by user");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error browsing files: " + e.getMessage());
        }

    }


    public List<RawDataFile> browseImages() throws Exception {
        return DALConfig.getImageProvider().useCustomBrowseImagesDialog() ? DALConfig.getImageProvider().browseImages(OrbitImageAnalysis.this) : OrbitHelper.browseImagesDefault(OrbitImageAnalysis.this);
    }

    private boolean checkClassNames() {
        if (model.getExclusionModel() == null) return true;
        if (model.getClassifier() == null || (!model.getClassifier().isBuild())) return true;
        for (ClassShape cs : model.getClassShapes()) {
            for (ClassShape cs2 : model.getExclusionModel().getClassShapes()) {
                if (cs.getName().equals(cs2.getName())) {
                    return false;
                }
            }
        }
        return true;
    }

    private OrbitWorker createBatchWorker(final OrbitModel model, final List<RawDataFile> rdfList, boolean useScaleout) {
        OrbitWorker worker = null;
        String performedOn = useScaleout ? "It will be executed on the scaleout infrastructure." : "It will be executed on the local computer.";
        if (model.getSegmentationModel() != null && (!model.isCellClassification()) && (model.getFeatureDescription().getFeatureClasses() != null) && (model.getFeatureDescription().getFeatureClasses().length > 0)) {
            if (JOptionPane.showConfirmDialog(this, "Your model is a cell segmentation model with cell features activated.\nThus a cell segmentation with cell feature calculation will be performed.\n" + performedOn + "\nIs this what you want to do?", "Starting Batch Mode", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                logger.info("starting batch cell segmentation with feature calculation ({} images)", rdfList.size());
                worker = new CellFeaturesWorkerMapReduce(new OrbitModel(model), rdfList, useScaleout);
            }
        } else if (model.getSegmentationModel() != null && model.getClassifier() != null && model.getClassifier().isBuild() && model.isCellClassification()) {
            if (JOptionPane.showConfirmDialog(this, "Your model is a cell classification model (which contains a segmentation model).\nThus a cell classification batch export will be performed.\n" + performedOn + "\nIs this what you want to do?", "Starting Batch Mode", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                logger.info("starting batch cell classification ({} images)", rdfList.size());
                worker = new CellClassificationWorkerMapReduce(new OrbitModel(model), rdfList, useScaleout);
            }
        } else if (model.getSegmentationModel() != null && (!model.isCellClassification())) {
            if (JOptionPane.showConfirmDialog(this, "Your model contains a cell segmentation model.\nThus a cell segmentation batch export will be performed.\n" + performedOn + "\nIs this what you want to do?", "Starting Batch Mode", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                logger.info("starting batch segmentation ({} images)", rdfList.size());
                worker = new SegmentationWorkerMapReduce(new OrbitModel(model), rdfList, useScaleout);
            }
        } else if (model.getSegmentationModel() == null && model.getFeatureDescription().getFeatureClasses() != null && model.getFeatureDescription().getFeatureClasses().length > 0) {
            if (JOptionPane.showConfirmDialog(this, "Your model is a classification model with feature classes selected.\nThus a histogram batch export will be performed.\n" + performedOn + "\nIs this what you want to do?", "Starting Batch Mode", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                logger.info("starting batch histogram ({} images)", rdfList.size());
                worker = new HistogramWorkerMapReduce(new OrbitModel(model), rdfList, useScaleout);
            }
        } else {
            if (JOptionPane.showConfirmDialog(this, "Your model is a ratio quantification model.\nThus a ratio per class quantification batch export will be performed.\n" + performedOn + "\nIs this what you want to do?", "Starting Batch Mode", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                logger.info("starting batch classification ({} images)", rdfList.size());
                worker = new ClassificationWorkerMapReduce(new OrbitModel(model), rdfList, useScaleout);
            }
        }
        return worker;
    }

    private void batchExportROIAreasMR()   // mapreduce
    {
        logger.info("batchExportROIAreasMR called [method call]");
        try {
            List<RawDataFile> rdfList = browseImages();
            if (rdfList == null) logger.debug("open image canceled.");
            else if (rdfList.size() == 0) logger.debug("no file selected.");
            else {
                OrbitWorker worker;
                worker = new ROIAreaWorkerMapReduce(new OrbitModel(model), rdfList, false);
                ProgressPanel pp = new ProgressPanel(rdfList.size() + " images", "Batch Export", worker);
                addAndExecuteTask(pp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error browsing files: " + e.getMessage());
        }

    }


    public void setModelAsSegmentationModel(OrbitModel model, boolean withGUI) {
        boolean deepLearningSegmentation = model != null && model.getFeatureDescription().isDeepLearningSegmentation();     // it's model, not model.getSegmentationModel(), because the segmentationModel will be set here
        if (!deepLearningSegmentation && (model == null || model.getClassifier() == null)) {
            JOptionPane.showMessageDialog(OrbitImageAnalysis.this, "The primary segmentation model cannot be set.\nPlease first specify class regions and do a classification\nor at least a training.", "Cannot set segmentation model", JOptionPane.ERROR_MESSAGE);
            return;
        }
        OrbitModel segModel = new OrbitModel(model);
        segModel.setSegmentationModel(null); // only one segModel, not recursive
        segModel.setSecondarySegmentationModel(null);
        this.model.setSegmentationModel(segModel);
        this.model.setType(OrbitModel.TYPE_SEGMENTATION);
        if (withGUI) {
            JOptionPane.showMessageDialog(OrbitImageAnalysis.this, "Primary Segmentation model successfully set.", "Segmentation model set", JOptionPane.INFORMATION_MESSAGE);
        }
        updateStatusBar();
    }

    public void setModelAsSecondarySegmentationModel(OrbitModel model, boolean withGUI) {
        if (model == null || model.getClassifier() == null /*|| model.getStructure()==null*/) {
            JOptionPane.showMessageDialog(OrbitImageAnalysis.this, "The secondary segmentation model cannot be set.\nPlease first specify class regions and do a classification\nor at least a training.", "Cannot set secondary segmentation model", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (model.getSegmentationModel() == null) {
            JOptionPane.showMessageDialog(OrbitImageAnalysis.this, "The secondary segmentation model cannot be set.\nPlease first define and set a primary segmentation model.", "Primary segmentation model not available", JOptionPane.ERROR_MESSAGE);
            return;
        }
        OrbitModel segModel = new OrbitModel(model);
        segModel.setSecondarySegmentationModel(null); // only one segModel, not recursive
        segModel.setSegmentationModel(null);
        this.model.setSecondarySegmentationModel(segModel);
        this.model.setType(OrbitModel.TYPE_SEGMENTATION);
        if (withGUI) {
            JOptionPane.showMessageDialog(OrbitImageAnalysis.this, "Secondary Segmentation model successfully set.", "Segmentation model set", JOptionPane.INFORMATION_MESSAGE);
        }
        updateStatusBar();
    }

    public void setModelAsExclusionModel(OrbitModel model, boolean withGUI) {
        if (model == null || model.getClassifier() == null || model.getStructure() == null) {
            JOptionPane.showMessageDialog(OrbitImageAnalysis.this, "The exclusion model cannot be set.\nPlease first specify class regions and do a classification\nor at least a training.", "Cannot set exclusion model", JOptionPane.ERROR_MESSAGE);
            return;
        }
        model.setExclusionModel(null);
        this.model.setExclusionModel(new OrbitModel(model));
        this.model.setType(OrbitModel.TYPE_EXCLUSION);
        if (withGUI) {
            JOptionPane.showMessageDialog(OrbitImageAnalysis.this, "Exclusion model successfully set.", "Exclusion model set", JOptionPane.INFORMATION_MESSAGE);
        }
        updateStatusBar();
    }


    private boolean checkModelConsistancy(OrbitModel model) {
        if (modifiedClassShapes) {
            if (JOptionPane.showConfirmDialog(OrbitImageAnalysis.this,
                    "Modified classes found. Please train the model again before saving.\nYou can still save the model, but the classification might fail when using it.\nDo you still want to save to model?",
                    "Modified class shapes", JOptionPane.YES_NO_OPTION)
                    != JOptionPane.YES_OPTION) {
                return false;
            }
        }
        return true;
    }


    public void saveModel(OrbitModel model, String name) {
        if (!checkModelConsistancy(model)) return;

        if ((model.getClassifier() == null || (!model.getClassifier().isBuild())) && JOptionPane.showConfirmDialog(OrbitImageAnalysis.this,
                "Main Model contains no training data. Do you want to save the model anyway?",
                "Main Model not trained", JOptionPane.YES_NO_OPTION)
                != JOptionPane.YES_OPTION) {
            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "OrbitImageAnalysis Models (*.omo)", "omo");
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooser.setSelectedFile(new File(name));
        String dir = prefs.get("OrbitImageAnalysis.SaveModelCurrentDir", null);
        if (dir != null) {
            File cd = new File(dir);
            fileChooser.setCurrentDirectory(cd);
        }
        int returnVal = fileChooser.showSaveDialog(OrbitImageAnalysis.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            prefs.put("OrbitImageAnalysis.SaveModelCurrentDir", fileChooser.getCurrentDirectory().getAbsolutePath());
            String fn = fileChooser.getSelectedFile().getAbsolutePath();
            if (!fn.toLowerCase().endsWith(OrbitUtils.MODEL_ENDING)) fn += OrbitUtils.MODEL_ENDING;
            File file = new File(fn);
            if (file.isDirectory()) return;
            model.cleanModel();
            model.prepareModelforSaving(getIFrames());
            model.setName(new File(name).getName());
            if (getIFrame() != null)
                model.setBoundaryClass(getIFrame().recognitionFrame.getBoundaryClass());
            try {
                model.saveModel(fn);
                JOptionPane.showMessageDialog(this, "Model saved successfully.",
                        "Model saved", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                logger.error("Error saving model", e);
                e.printStackTrace();
            }

        } else {
            logger.trace("save model canceled.");
        }
    }


    private void loadModel() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "OrbitImageAnalysis Models (*.omo)", "omo");
        fileChooser.setFileFilter(filter);
        String dir = prefs.get("OrbitImageAnalysis.OpenModelCurrentDir", null);
        if (dir != null) {
            File cd = new File(dir);
            fileChooser.setCurrentDirectory(cd);
        }
        int returnVal = fileChooser.showOpenDialog(OrbitImageAnalysis.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            prefs.put("OrbitImageAnalysis.OpenModelCurrentDir", fileChooser.getCurrentDirectory().getAbsolutePath());
            File file = fileChooser.getSelectedFile();
            boolean isTissueClassification = true; // it is a tissue classification model
            if (file.getName().endsWith("cell")) isTissueClassification = false; // it is a cell classification model
            loadModel(file, true, isTissueClassification);
        } else {
            logger.trace("load model canceled.");
        }
    }


    public void loadModel(File file, boolean withUI, boolean isTissueClassification) {
        if (file.isDirectory()) return;
        try {
            OrbitModel model = OrbitModel.LoadFromFile(file.getAbsolutePath());
            boolean isOldModel = false;
            try {
                logger.info("model loaded: " + file.getName());
                loadedModel = file.getName();
            } catch (Exception ex) {
                logger.error("cannot load model", ex);
                JOptionPane.showMessageDialog(this,
                        "Error loading model (see Help->Show Log for details).",
                        "Error loading model",
                        JOptionPane.ERROR_MESSAGE);
            }
            loadModel(model, file.getName(), withUI, isOldModel, isTissueClassification);
            updateStatusBar();
        } catch (Exception e) {
            logger.error("error loading model", e);
            logger.info("It seams that you tried to load an old model version which is incompatible with the current version.\nIf you easily can recreate a similar model, please do so. If you really need your old model please contact support - maybe it is possible to convert your model.");
            JOptionPane.showMessageDialog(this, "Error loading model. It seams that you tried to load an old model version (see Info->Show Log for details).", "Error loading model (old version?)", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void loadModel(OrbitModel model, String name) {
        loadModel(model, name, true);
    }

    public void loadModel(OrbitModel model, String name, boolean withUI) {
        loadModel(model, name, withUI, false, true);
    }


    /**
     * @param model                       - the model to load (e.g. APARV3Model)
     * @param withUI                      - should notifications be displayed via JOptionPane ?
     * @param isOldModel                  - just for displaying a warning message (if withGUI is true)
     * @param isTissueClassificationModel - otherwise cellClassification is assumed
     */
    public void loadModel(OrbitModel model, String name, boolean withUI, boolean isOldModel, boolean isTissueClassificationModel) {
        // now also set the segmentation model, if available
        if (model.getSegmentationModel() != null) {
            logger.trace("segmentation model loaded.");
        } else logger.trace("no segmentation model loaded.");
        if (model.getExclusionModel() != null) {
            logger.trace("exclusion model loaded.");
        } else logger.trace("no exclusion model loaded.");
        if (isTissueClassificationModel) {
            //trainWorker = new TrainWorker(model.getClassifier(), model.getStructure());
            logger.trace("performing tissue classification: " + isTissueClassificationModel);
        } else {
            //nucleidTrainWorker = new NucleidTrainWorker(model.getClassifier(), model.getStructure());
            logger.trace("performing cell classification");
        }
        //newFileLoaded = true;
        if (model.getClassifier() != null)
            model.getClassifier().setBuild(true);
        List<ClassShape> loadedClassShapes = OrbitUtils.cloneClassShapes(model.getClassShapes());
        for (ImageFrame iFrame : getIFrames()) {
            // bugfix 21.05.2010 (Manuel): cloneClassShapes
            iFrame.recognitionFrame.setClassShapes(OrbitUtils.cloneClassShapes(loadedClassShapes));
            iFrame.recognitionFrame.setWindowSize(model.getFeatureDescription().getWindowSize());
            iFrame.recognitionFrame.setBoundaryClass(model.getBoundaryClass());
        }
        this.model = model;
        makeClassComboBox();
        if (withUI) {
            this.repaint();
            if (isOldModel)
                JOptionPane.showMessageDialog(this, "Old version model loaded. You still can use it, but to be conform to future model versions please save it as a new model.",
                        "Model loaded (old version)", JOptionPane.WARNING_MESSAGE);
            else {
                String cc = "";
                if (model.isCellClassification())
                    cc = " (Cell Classificagtion)";
                String str = "Model loaded successfully" + cc + ".";
                if (model.getSegmentationModel() != null)
                    str += "\n(Including a segmentation model.)";
                if (model.getExclusionModel() != null)
                    str += "\n(Including a exclusion model.)";
                JOptionPane.showMessageDialog(this, str,
                        "Model loaded", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        loadedModel = name;
        if (DALConfig.getImageProvider() instanceof IModelAwareImageProvider) {
            ((IModelAwareImageProvider) DALConfig.getImageProvider()).setOrbitModel(model);
        }
        updateStatusBar();
    }


    private void restoreClassShapes() throws Exception {
        if (model == null || model.getClassShapesToRestore() == null || model.getClassShapesToRestore().size() == 0) {
            JOptionPane.showMessageDialog(this, "No training shapes stored in the current model.", "No training data found", JOptionPane.ERROR_MESSAGE);
            return;
        }


        if (JOptionPane.showConfirmDialog(this,
                "The training shapes of the model will be loaded. This will reset all current training shapes.\nDo you want to continue?",
                "Reset current training data?", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) {

            // sync image class shapes with model class shapes -> loss of existing image class shapes!
            for (ImageFrame iFrame : getIFrames()) {
                iFrame.getRecognitionFrame().setClassShapes(OrbitUtils.cloneClassShapes(model.getClassShapes()));
            }

            HashSet<Integer> imgNotFoundWarning = new HashSet<>();
            for (int i = 0; i < model.getClassShapesToRestore().size(); i++) {
                ClassShape cs = model.getClassShapesToRestore().get(i);
                if (cs.getShapeList() != null && cs.getShapeList().size() > 0) {
                    for (Shape shape : cs.getShapeList()) {
                        if (shape instanceof IScaleableShape) {
                            int rdfId = ((IScaleableShape) shape).getRdfId();
                            if (rdfId > 0) {
                                List<ImageFrame> iFrames = getIFrames();
                                ImageFrame frameToAdd = null;
                                for (ImageFrame iFrame : iFrames) {
                                    if (iFrame.getRdf() != null && iFrame.getRdf().getRawDataFileId() == rdfId) {
                                        frameToAdd = iFrame;
                                        break;
                                    }
                                }
                                if (frameToAdd == null) {    // image not open yet
                                    RawDataFile rdf = DALConfig.getImageProvider().LoadRawDataFile(rdfId);
                                    if (rdf != null) {
                                        frameToAdd = loadFile(rdf, null, false);
                                        frameToAdd.getRecognitionFrame().setClassShapes(OrbitUtils.cloneClassShapes(model.getClassShapes()));
                                    } else {
                                        if (!imgNotFoundWarning.contains(rdfId)) {
                                            JOptionPane.showMessageDialog(this, "The image with id " + rdfId + " cannot be found, thus the training shapes for this image will not be restored.", "Image not found", JOptionPane.WARNING_MESSAGE);
                                            imgNotFoundWarning.add(rdfId);
                                        }
                                    }
                                }

                                if (frameToAdd != null) {   // set shapes
                                    frameToAdd.getRecognitionFrame().getClassShapes().get(i).getShapeList().add(shape);
                                }

                            }
                        }
                    }
                }
            }
        }
    }

    private void saveAsOrbitFile() {
        if (getIFrames() == null || getIFrames().size() == 0) {
            JOptionPane.showMessageDialog(this, "Nothing to save. Please open a file before saving.", "Nothing to save", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Orbit file (*.orbit)", "orbit");
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
        if (getIFrames().size() == 1) {
            fileChooser.setSelectedFile(new File(getIFrame().recognitionFrame.getPicName() + ".orbit"));
        } else {
            fileChooser.setSelectedFile(new File("Images.orbit"));
        }

        int returnVal = fileChooser.showSaveDialog(OrbitImageAnalysis.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String fn = fileChooser.getSelectedFile().getAbsolutePath();
            if (!fn.toLowerCase().endsWith(".orbit")) fn += ".orbit";
            File file = new File(fn);
            if (file.isDirectory()) return;
            try {
                FileOutputStream fos = new FileOutputStream(file);
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                for (ImageFrame iFrame : getIFrames()) {
                    osw.write(iFrame.recognitionFrame.getOriginalName() + "\n");
                }
                osw.flush();
                osw.close();
                fos.flush();
                fos.close();
                JOptionPane.showMessageDialog(this, "Orbit file saved successfully.",
                        "Orbit file saved", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                logger.error("error saving orbit file", e);
                e.printStackTrace();
            }

        } else {
            logger.trace("save as orbit canceled.");
        }
    }


    public void exitProcedure() {
        if (JOptionPane.showConfirmDialog(this,
                "Do you really want to exit Orbit Image Analysis?",
                "Exit Orbit Image Analysis", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) {

            // store expanded tree nodes in prefs
            prefs.put("OIATreeExpandState", RawUtilsCommon.packStringList(rdTree.getExpandedState()));

            if (getIFrame() != null && getIFrames().size() > 0)
                logger.debug("shutdown down iFrames");
            for (ImageFrame iFrame : getIFrames()) {
                iFrame.recognitionFrame.bimg = null;
                iFrame.recognitionFrame.setClassImage(null);
                if (iFrame.recognitionFrame.getRenderThreadOriginal() != null) {
                    try {
                        // here interrupt should also do it...
                        iFrame.recognitionFrame.getRenderThreadOriginal().stop();
                    } catch (Throwable ignored) {
                    }
                }
            }
            if (imageList != null) {
                logger.debug("shutdown imageList");
                try {
                    imageList.getRenderer().close();
                } catch (Throwable ignored) {
                }
            }
            logger.debug("shutdown statusBarUpdater");
            try {
                statusBarUpdater.shutdownNow();
            } catch (Throwable ignored) {
            }

            logger.debug("shutdown running workers");
            interruptAllWorkers();
            TiledImagePainter.executorService.shutdownNow();

            // imageprovider shutdown
            try {
                if (DALConfig.getImageProvider()!=null)
                    DALConfig.getImageProvider().close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (!OrbitUtils.DEVELOPMENTMODE) {
                logger.debug("cleaning up temp");
                OrbitUtils.cleanUpTemp();
            }
            logger.debug("Orbit shutdown");
            //this.dispose();
            System.exit(0);
        }
    }


    @SuppressWarnings("unchecked")
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(ImageList.PROPERTY_LOAD_IMAGE)) {
            final RawDataFile rdf = (RawDataFile) evt.getNewValue();
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    loadFile(rdf, null, false);
                    getIFrame().setTitle(rdf.getFileName());
                    getIFrame().setRdf(rdf);
                }
            });
        } else if (evt.getPropertyName().equals(ImageList.PROPERTY_DISPLAY_META)) {
            final RawDataFile rdf = (RawDataFile) evt.getNewValue();
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    metaBar.listMetas(rdf);
                    metaBar.repaint();
                }
            });
        } else if (evt.getPropertyName().equals(ClassAdminFrame.CLASSADMIN_DONE)) {
            // synchronize classShape lists in all iFrames
            // since classAdminFrame has been initialized with referenceClassShapes the returned classShapes
            // are exactly the referenceClassShapes
            List<ClassShape> cs = (List<ClassShape>) evt.getNewValue();
            updateClassShapes(cs);

        } else if (evt.getPropertyName().equals("progress") && (evt.getSource() instanceof ClassificationWorker)) {
            int progress = (Integer) evt.getNewValue();
            if (logger.isTraceEnabled())
                logger.trace("classification progress: " + progress + "%");
        } else if (evt.getPropertyName().equals(ProgressPanel.PROGRESS_DONE)) {  // remove completed tasks
            ProgressPanel pp = (ProgressPanel) evt.getSource();
            TaskResult taskResult = pp.getWorker().getTaskResult();
            if ((logFrame != null) && (taskResult != null)) {
                logFrame.appendText(taskResult.getTitle() + ":\n" + taskResult.getResultStr() + "\n\n");
            }
            if (showPopupResults && (taskResult != null) && pp.getWorker().isWithGUI()) {
                ResultFrame resultFrame = new ResultFrame(taskResult.getResultStr(), taskResult.getTitle());
                addInternalFrame(resultFrame);
            }
            taskPanel.remove(pp);
            propertyPanel.revalidate();
            updateStatusBar(); // e.g. if trainworker finished

        } else if (evt.getPropertyName().equals(ImageFrame.IFRAME_SELECTED) && (desktop.getSelectedFrame() != null && desktop.getSelectedFrame() instanceof ImageFrame)) {    // activate mouse listeners for selected frame (and deactivate for the others)
            for (ImageFrame iFrame : getIFrames()) {
                iFrame.recognitionFrame.removeMouseListeners();
                iFrame.setFrameIcon(null);
            }
            ((ImageFrame) evt.getSource()).setFrameIcon(((ImageFrame) evt.getSource()).getOrbitIcon());

            ((ImageFrame) evt.getSource()).recognitionFrame.addMouseListeners();
            if (((ImageFrame) evt.getSource()).recognitionFrame.bimg.getMipMaps() != null && ((ImageFrame) evt.getSource()).recognitionFrame.bimg.getMipMaps().length > 0) {
                setLowResImagesItemsEnabled(true);
            } else {
                setLowResImagesItemsEnabled(false);
            }
            metaBar.clearMetasAndAnnotations();
            loadAnnotations(((ImageFrame) evt.getSource()), true);       // TODO
            metaBar.loadImageAdjustments(((ImageFrame) evt.getSource()));
            if (nerveDetectionModule != null) {
                nerveDetectionModule.loadSpots(((ImageFrame) evt.getSource()));
            }

        } else if (evt.getPropertyName().equals(ImageFrame.IFRAME_CLOSING)) {
            ImageFrame oldFrame = (ImageFrame) evt.getSource();
            if (oldFrame != null) {
                logger.trace("event IFRAME_CLOSING: " + oldFrame.getTitle());
                desktop.remove(oldFrame);
                this.removePropertyChangeListener(oldFrame);
                if (oldFrame != null) {
                    try {
                        oldFrame.setClosed(true);
                    } catch (PropertyVetoException e) {
                        e.printStackTrace();
                    }
                }
                if (oldFrame != null) {
                    oldFrame.dispose();
                }

                oldFrame = null;
            }

            // iframe closing, so reset loupe, rendergrid and metaBar
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    ImageFrame iFrame = getIFrame();
                    if (iFrame != null) {
                        firePropertyChange("selected", null, iFrame);
                    } else {
                        renderGrid.setImage(null);
                        loupeWithScale.getLoupe().setImage(null);
                        metaBar.clearMetasAndAnnotations();
                        propertyPanel.revalidate();
                        propertyPanel.repaint();
                    }
                }
            });

        } else if (evt.getPropertyName().equals(FeaturesAdminFrame.FEATURES_DONE)) {
            updateFeatureDescription((FeatureDescription) evt.getNewValue());
        }
    }

    private void updateFeatureDescription(FeatureDescription featureDescription) {
        model.setFeatureDescription(featureDescription);
        for (ImageFrame iFrame : getIFrames()) {
            iFrame.recognitionFrame.setFeatureDescription(model.getFeatureDescription());
        }
        // propagate segmentation features

        OrbitModel segModel = null;
        if (featureDescription.isForSecondarySegmentationModel()) segModel = model.getSecondarySegmentationModel();
        else segModel = model.getSegmentationModel();

        if (segModel != null) {
            segModel.getFeatureDescription().setMaxOpenDistance(featureDescription.getMaxOpenDistance());
            segModel.getFeatureDescription().setMaxSegmentationLength(featureDescription.getMaxSegmentationLength());
            segModel.getFeatureDescription().setMinSegmentationSize(featureDescription.getMinSegmentationSize());
            segModel.getFeatureDescription().setSegmentationScale(featureDescription.getSegmentationScale());
            segModel.getFeatureDescription().setDeactivateWatershed(featureDescription.isDeactivateWatershed());
            segModel.getFeatureDescription().setFeatureClasses(featureDescription.getFeatureClasses() != null ? featureDescription.getFeatureClasses().clone() : null);
            segModel.setAnnotationGroup(model.getAnnotationGroup());
            // v2 features
            segModel.getFeatureDescription().setDisableWatershed(featureDescription.isDisableWatershed());
            segModel.getFeatureDescription().setCombineObjectsCrossTiles(featureDescription.isCombineObjectsCrossTiles());
            segModel.getFeatureDescription().setDilateBeforeErode(featureDescription.isDilateBeforeErode());
            segModel.getFeatureDescription().setFilterTileEdgeShapes(featureDescription.isFilterTileEdgeShapes());
            segModel.getFeatureDescription().setNumDilate(featureDescription.getNumDilate());
            segModel.getFeatureDescription().setNumErode(featureDescription.getNumErode());
            segModel.getFeatureDescription().setRemoveOutliers(featureDescription.getRemoveOutliers());
            segModel.getFeatureDescription().setGraphCut(featureDescription.getGraphCut());
            segModel.getFeatureDescription().setCytoplasmaSegmentation(featureDescription.isCytoplasmaSegmentation());
            segModel.getFeatureDescription().setActiveFluoChannels(featureDescription.getActiveFluoChannels());

            segModel.getFeatureDescription().setMumfordShahSegmentation(featureDescription.isMumfordShahSegmentation());
            segModel.getFeatureDescription().setMumfordShahAlpha(featureDescription.getMumfordShahAlpha());
            segModel.getFeatureDescription().setMumfordShahCellSize(featureDescription.getMumfordShahCellSize());

            segModel.getFeatureDescription().setDeepLearningSegmentation(featureDescription.isDeepLearningSegmentation());
            segModel.getFeatureDescription().setDeepLearningModelPath(featureDescription.getDeepLearningModelPath());
        }
    }


    private void updateClassShapes(List<ClassShape> classShapes) {

        // update classComboBox
        makeClassComboBox();
        // update iFrames
        for (ImageFrame iFrame : getIFrames()) {
            if (iFrame.recognitionFrame.getClassShapes().size() > classShapes.size()) {
                modifiedClassShapes = true;
                logger.debug("Warning: ClassShapes have to be rebuild. Loss of existing shapes. " + iFrame.getTitle());
                List<ClassShape> oldShapes = OrbitUtils.cloneClassShapes(iFrame.recognitionFrame.getClassShapes(), true);
                iFrame.recognitionFrame.setClassShapes(new ArrayList<ClassShape>());
                for (ClassShape classShape : classShapes) {
                    // search in old classShapes
                    boolean found = false;
                    for (ClassShape oldShape : oldShapes) {
                        if (classShape.equals(oldShape)) {
                            iFrame.recognitionFrame.getClassShapes().add(oldShape);
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                        iFrame.recognitionFrame.getClassShapes().add(new ClassShape("dummy", Color.darkGray, ClassShape.SHAPETYPE_POLYGONEXT));

                }
                // assign the first list to the shapeListener (otherwise it would have on old reference)
                iFrame.recognitionFrame.getMyListener().setShapeList(iFrame.recognitionFrame.getClassShapes().get(0).getShapeList(), iFrame.recognitionFrame.getClassShapes().get(0).getName());
            }
            if (iFrame.recognitionFrame.getClassShapes().size() < classShapes.size()) {
                logger.debug("Warning: ClassShapes need to be extended.");
                int numExtend = classShapes.size() - iFrame.recognitionFrame.getClassShapes().size();
                for (int i = 0; i < numExtend; i++) {
                    iFrame.recognitionFrame.getClassShapes().add(new ClassShape("dummy", Color.darkGray, ClassShape.SHAPETYPE_POLYGONEXT));
                }
            }
            // now the classShapes should have the same size
            // synchronize properties
            for (int i = 0; i < classShapes.size(); i++) {
                iFrame.recognitionFrame.getClassShapes().get(i).setName(classShapes.get(i).getName());
                iFrame.recognitionFrame.getClassShapes().get(i).setColor(classShapes.get(i).getColor());
                // TODO: Deprecated method calls...
                iFrame.recognitionFrame.getClassShapes().get(i).setEnableObjectCount(classShapes.get(i).isEnableObjectCount());
                iFrame.recognitionFrame.getClassShapes().get(i).setKickTargetsLessThanMin(classShapes.get(i).isKickTargetsLessThanMin());
                iFrame.recognitionFrame.getClassShapes().get(i).setMixtureTreshold(classShapes.get(i).getMixtureTreshold());
                iFrame.recognitionFrame.getClassShapes().get(i).setSegmentationMinimumSize(classShapes.get(i).getSegmentationMinimumSize());
                iFrame.recognitionFrame.getClassShapes().get(i).setSegmentationObjectSize(classShapes.get(i).getSegmentationObjectSize());
            }

        }
    }

    public ImageFrame getIFrame() {
        ImageFrame iFrame = null;
        if (desktop.getSelectedFrame() instanceof ImageFrame) {
            iFrame = (ImageFrame) desktop.getSelectedFrame();
        }
        if ((iFrame == null) && (desktop.getAllFrames().length > 0)) {
            for (JInternalFrame intFrame : desktop.getAllFrames()) {
                if (intFrame instanceof ImageFrame) {
                    iFrame = (ImageFrame) intFrame;
                    break;
                }
            }
        }
        return iFrame;
    }

    public List<ImageFrame> getIFrames() {
        List<ImageFrame> iFrames = new ArrayList<>(desktop.getAllFrames().length);
        for (JInternalFrame intFrame : desktop.getAllFrames()) {
            if (intFrame instanceof ImageFrame) {
                iFrames.add((ImageFrame) intFrame);
            }
        }
        return iFrames;
    }

    /**
     * adds an JInternalFrame to the desktop and brings it to the front
     *
     * @param frame
     */
    public void addInternalFrame(JInternalFrame frame) {
        TiledImageWriter.timeOut.set(System.currentTimeMillis());
        desktop.add(frame);
        JInternalFrame lastFrame = desktop.getSelectedFrame();
        if ((lastFrame == null) && (desktop.getAllFrames().length > 0)) {
            lastFrame = desktop.getAllFrames()[desktop.getAllFrames().length - 1];
        }

        if (lastFrame != null && getIFrame() != null) {  // selected or first iFrame
            Rectangle b = getIFrame().getBounds();
            frame.setBounds(b.x + 20, b.y + 20, frame.getWidth(), frame.getHeight());
        } else { // iFrame==null
            frame.setBounds(20, 20, frame.getWidth(), frame.getHeight());
        }
        frame.setResizable(true);
        frame.setMaximizable(true);
        frame.setClosable(true);
        frame.setIconifiable(true);
        frame.setVisible(true);
        try {
            if (desktop.getSelectedFrame() != null) {
                desktop.getSelectedFrame().setSelected(false);
            }
            frame.setSelected(true);
        } catch (PropertyVetoException ignored) {
        }
        desktop.setSelectedFrame(frame);
        frame.requestFocus();
        desktop.getDesktopManager().activateFrame(frame);
    }


    private boolean resetROI() {
        for (ImageFrame iFrame : getIFrames()) {
            iFrame.recognitionFrame.setROI(null);
            iFrame.recognitionFrame.setClassImage(null);
            iFrame.recognitionFrame.setOpacity(0f);
            iFrame.getOpacitySlider().setValue(0);
        }
        return true;
    }

    private boolean maskSet() {
        OrbitModel maskModel = getModelExplorer().getSelectedModel();
        if (maskModel!=null) {
            if (maskModel.getMipLayer()!=model.getMipLayer()) {
                JOptionPane.showMessageDialog(this,"In the current version the mask model and the main model must be trained on the same image resolution","Mask cannot be applied",JOptionPane.ERROR_MESSAGE);
                return false;
            }
            IOrbitMask mask = new OrbitMaskClassificationModel(maskModel.clone());
            model.setMask(mask);
            updateStatusBar();
            return true;
        } else {
            return false;
        }
    }

    private boolean maskSegmentationSet() {
        OrbitModel maskModel = getModelExplorer().getSelectedModel();
        if (maskModel!=null && maskModel.getSegmentationModel()!=null) {
            if (maskModel.getSegmentationModel().getMipLayer()!=model.getMipLayer()) {
                JOptionPane.showMessageDialog(this,"In the current version the mask model and the main model must be trained on the same image resolution","Mask cannot be applied",JOptionPane.ERROR_MESSAGE);
                return false;
            }
            IOrbitMask mask = new OrbitMaskSegmentationModel(maskModel.clone());
            model.setMask(mask);
            updateStatusBar();
            return true;
        } else {
            return false;
        }
    }


    private void invertROI() {
        for (ImageFrame iFrame : getIFrames()) {
            if (iFrame.recognitionFrame.getROI() != null && (iFrame.recognitionFrame.getROI() instanceof PolygonExt)) {
                PolygonExt invRoi = (PolygonExt) iFrame.recognitionFrame.getROI();
                invRoi.resetScaledInstance();
                invRoi.setInverse(true);
                iFrame.recognitionFrame.setROI(invRoi);
                JOptionPane.showMessageDialog(this, "ROI successfully inverted", "ROI inverted", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }


    private void saveClassImage() {
        final int width = 3000;
        final ImageFrame iFrame = getIFrame();
        if (iFrame != null) {
            if (iFrame.getRecognitionFrame().getClassImage() != null) {
                final TiledImage classImg = iFrame.getRecognitionFrame().getClassImage().getImage();
                OrbitTiledImage2 mainImgTmp = iFrame.getRecognitionFrame().bimg.getImage();
                if (iFrame.getRecognitionFrame().bimg.hasMipMaps()) {
                    for (TiledImagePainter tip : iFrame.getRecognitionFrame().bimg.getMipMaps()) {
                        if (tip.getWidth() > width)
                            mainImgTmp = tip.getImage();
                    }
                }
                final OrbitTiledImage2 mainImg = mainImgTmp;
                if (classImg != null) {
                    final JFileChooser fc = new JFileChooser();
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("*.jpg", "jpg");
                    fc.setFileFilter(filter);
                    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    fc.setDialogType(JFileChooser.SAVE_DIALOG);
                    fc.setDialogTitle("Save Classification Image as...");
                    String dir = prefs.get("OrbitImageAnalysis.SaveClassificationImageDir", null);
                    if (dir != null) {
                        File cd = new File(dir);
                        fc.setCurrentDirectory(cd);
                    }
                    iFrame.recognitionFrame.setCursor(new Cursor(Cursor.WAIT_CURSOR));
                    int returnVal = fc.showSaveDialog(OrbitImageAnalysis.this);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        prefs.put("OrbitImageAnalysis.SaveClassificationImageDir", fc.getCurrentDirectory().getAbsolutePath());
                        SwingUtilities.invokeLater(() -> {
                            try {
                                ClassImageRenderer renderer = new ClassImageRenderer();
                                int height = (int) (classImg.getHeight() * (width / (double) classImg.getWidth()));
                                BufferedImage bi = renderer.downsample(classImg, mainImg, width, height);
                                String fn = fc.getSelectedFile().getAbsolutePath();
                                renderer.saveToDisk(bi, fn);
                                JOptionPane.showMessageDialog(OrbitImageAnalysis.this, "Classification image successfully saved as\n" + fn + ".", "Classification image saved", JOptionPane.INFORMATION_MESSAGE);
                            } catch (IOException e1) {
                                e1.printStackTrace();
                                logger.error("error saving classification image ", e1);
                            } finally {
                                iFrame.recognitionFrame.setCursor(new Cursor((Cursor.DEFAULT_CURSOR)));
                            }
                        });
                    }
                }
            } else
                JOptionPane.showMessageDialog(OrbitImageAnalysis.this, "No classification available. Please classify an image first.", "Cannot save classification image", JOptionPane.ERROR_MESSAGE);
        } else
            JOptionPane.showMessageDialog(OrbitImageAnalysis.this, "No image available. Please open and classify an image first.", "Cannot save classification image", JOptionPane.ERROR_MESSAGE);
    }


    private boolean resetMainModel() {
        OrbitModel newModel = new OrbitModel();
        model.setClassShapes(OrbitUtils.cloneClassShapes(newModel.getClassShapes()));

        if (getIFrames() != null && getIFrames().size() > 0) {
            for (ImageFrame iFrame : getIFrames()) {
                iFrame.getRecognitionFrame().setClassShapes(OrbitUtils.cloneClassShapes(model.getClassShapes()));
                iFrame.recognitionFrame.setObjectSegmentationList(null);
                iFrame.repaint();
            }
        }
        model.setClassifier(null);
        updateCcbModel(newModel.getClassShapes());
        updateStatusBar();
        return true;
    }

    public void setupClassesForClassification() {
        resetMainModel();
    }

    public void setupClassesForObjectSegmentation() {

        List<ClassShape> classShapes = new ArrayList<ClassShape>(2);
        classShapes.add(new ClassShape("Background", Color.blue, ClassShape.SHAPETYPE_POLYGONEXT, ClassShape.UNDEFINED));
        classShapes.add(new ClassShape("Foreground", Color.green, ClassShape.SHAPETYPE_POLYGONEXT, ClassShape.UNDEFINED));
        for (ImageFrame iFrame : getIFrames()) {
            iFrame.recognitionFrame.setClassShapes(OrbitUtils.cloneClassShapes(classShapes));
            iFrame.recognitionFrame.setWindowSize(getModel().getFeatureDescription().getWindowSize());
            iFrame.recognitionFrame.setBoundaryClass(getModel().getBoundaryClass());
            iFrame.recognitionFrame.setObjectSegmentationList(null);
        }
        getModel().setClassShapes(classShapes);
        updateCcbModel(classShapes);
        updateStatusBar();
    }

    private void setupClassesForObjectClassification() {
        List<ClassShape> classShapes = new ArrayList<ClassShape>(3);
        classShapes.add(new ClassShape("Stained Objects", Color.green, ClassShape.SHAPETYPE_POLYGONEXT, ClassShape.UNDEFINED));
        classShapes.add(new ClassShape("Normal Objects", Color.blue, ClassShape.SHAPETYPE_POLYGONEXT, ClassShape.UNDEFINED));
        classShapes.add(new ClassShape("Other Objects", Color.orange, ClassShape.SHAPETYPE_POLYGONEXT, ClassShape.UNDEFINED));
        for (ImageFrame iFrame : getIFrames()) {
            iFrame.recognitionFrame.setClassShapes(OrbitUtils.cloneClassShapes(classShapes));
            iFrame.recognitionFrame.setWindowSize(this.model.getFeatureDescription().getWindowSize());
            iFrame.recognitionFrame.setBoundaryClass(this.model.getBoundaryClass());
        }
        this.model.setClassShapes(classShapes);
        updateCcbModel(classShapes);
        updateStatusBar();
    }


    private boolean resetModel() {
        model = new OrbitModel(); // complete reset of model
        if (getIFrames() != null && getIFrames().size() > 0) {
            for (ImageFrame iFrame : getIFrames()) {
                iFrame.getRecognitionFrame().setClassShapes(OrbitUtils.cloneClassShapes(model.getClassShapes()));
                iFrame.recognitionFrame.setObjectSegmentationList(null);
                iFrame.repaint();
            }
        }
        makeClassComboBox();
        loadedModel = "none";
        updateStatusBar();
        return true;
    }

    /**
     * waits until worker.isDone or worker.isCancelled is true
     *
     * @param worker
     */
    public void waitForWorker(OrbitWorker worker) {
        while ((!worker.isDone()) || worker.isCancelled()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * cancels all workers in the taskPane
     */
    private void interruptAllWorkers() {
        for (Component c : taskPanel.getComponents()) {
            if (c instanceof ProgressPanel) {
                ProgressPanel pp = (ProgressPanel) c;
                OrbitWorker worker = pp.getWorker();
                if (worker != null) {
                    worker.cancel(true);
                    logger.debug("worker " + pp.getName() + " canceled");
                }
            }
        }
    }

    // requirement methods
    protected boolean requirementTrain() {
        if ((model.getClassifier() == null) || (!(model.getClassifier().isBuild()))) {
            JOptionPane.showMessageDialog(this, "please train model first.", "Requirement not fulfilled.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    protected boolean requirementExclusionTrain() {
        OrbitModel model = this.model.getExclusionModel();
        if ((model == null) || (model.getClassifier() == null) /*|| (!(model.getClassifier().isBuild()))*/) // actually the isBuild() should be used too, but in older exclusion models this is not set correctly, so check disabled
        {
            JOptionPane.showMessageDialog(this, "please train an exclusion model first.", "Exclusion model not trained.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }


    private void showLog() {
        try {
            if (logFrame.isIcon())
                logFrame.setMaximum(true);
            else if (logFrame.isShowing())
                logFrame.setMaximum(false);
            else
                addInternalFrame(logFrame);

        } catch (PropertyVetoException ignored) {
        }
    }


    /**
     * singleton method
     *
     * @return
     */
    public static synchronized OrbitImageAnalysis getInstance() {
        if (instance == null) {
            instance = new OrbitImageAnalysis();
        }
        return instance;
    }


    public void loadOrbitFile(String filename) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String trimmed = line.trim().replaceAll("\"", "");
                if ((trimmed.length() > 0) && (!trimmed.startsWith("//")) && (!trimmed.startsWith("#"))) {
                    processInputLine(trimmed, trimmed);
                }
            }
        } catch (FileNotFoundException e) {
            logger.error("cannot find or access file: " + filename);
        } catch (IOException e) {
            logger.error("error reading file {}: {}" + filename, e);
        } finally {
            if (reader != null)
                try {
                    reader.close();
                } catch (IOException ignored) {
                }
        }
    }


    /**
     * loads an object from string. Can be an .orbit file, and image or a raw data id.
     */
    public static void processInputLine(String param, String all) {
        LocalFileFilter localFileFilter = new LocalFileFilter();
        if (param.endsWith(".orbit")) {
            logger.debug("trying to load an orbit file");
            getInstance().loadOrbitFile(param);
        } else if (localFileFilter.accept(new File(param))) {
            logger.debug("trying to load an image");
            getInstance().loadFileDirect(new File(param));
        } else if (param.toLowerCase().endsWith(OrbitUtils.MODEL_ENDING)) {
            logger.debug("trying to load a model");
            getInstance().loadModel(new File(param), true, param.toLowerCase().endsWith(OrbitUtils.MODEL_ENDING));
        } else {
            logger.debug("trying to parse a raw data file id and load it");
            try {
                int rdfId = Integer.parseInt(param);
                RawDataFile rdf = DALConfig.getImageProvider().LoadRawDataFile(rdfId);
                if (rdf == null) logger.trace("raw data file with id " + rdfId + " not found, now trying to load local file");
                else getInstance().loadFile(rdf);
            } catch (Exception e) {
                logger.trace("cannot parse raw data file id (has to be an integer): " + param);
            }
        }
    }

    public static void initSingleApplication(final String[] args) {
        StringBuilder all = new StringBuilder();
        if (args != null && args.length > 0) {
            for (String s : args) all.append(" ").append(s);
        }
        if (OrbitUtils.OFFLINE_MODE || all.toString().toLowerCase().contains("-noerrorpopups")) popupErrors = false;
        if (OrbitUtils.OFFLINE_MODE || all.toString().toLowerCase().contains("-hidequicksearch")) showQuicksearch = false;

        try {
            final String allStr = all.toString();

            SwingUtilities.invokeLater(() -> {

                if (!ScaleoutMode.SCALEOUTMODE.get()) {
                    JFrame.setDefaultLookAndFeelDecorated(true);
                    SubstanceCortex.GlobalScope.setSkin(new GraphiteAquaSkin());
                }

                getInstance();

                if (logFrame != null) logFrame.updateUI();

                getInstance().toFront();
                getInstance().requestFocus();

                if (args != null && args.length > 0) {
                    String param = args[0];
                    processInputLine(param, allStr);
                }
            });
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }


    public static void main(String[] args) {

        // Show the splash screen.
        boolean showSplash = (!ScaleoutMode.SCALEOUTMODE.get());
        final SplashScreen splashScreen = new SplashScreen("/resource/orbit_splash2.jpg");

        if (showSplash) {
            splashScreen.splash();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
        }

        // Launch the application itself.
        initSingleApplication(args);

        // Remove the splash screen.
        if (showSplash && OrbitUtils.DARKUI) {
            SwingUtilities.invokeLater(splashScreen::dispose);
        }
    }


    public void showErrorMessage(final String s) {
        if (errorPopupOpen.get()) return;
        if (s == null) return;
        if (lastErrorMessage.equals(s)) return;
        if (System.currentTimeMillis() - lastErrorTime < 15000L) return; // only every 15s an error message
        errorPopupOpen.set(true);
        lastErrorMessage = s;
        lastErrorTime = System.currentTimeMillis();
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(OrbitImageAnalysis.this, s, "Orbit Error", JOptionPane.ERROR_MESSAGE);
            errorPopupOpen.set(false);
        });
    }


    public void switchLocalRemoteImageProvider() {
        List<ImageFrame> openFrames = getIFrames();
        if (openFrames.size()==0 || JOptionPane.showConfirmDialog(OrbitImageAnalysis.this,
                "Switch from local/remote image provider implies closing all open images.\n" +
                        "Do you want to proceed?",
                "Close open images",
                JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {

            // close open images
            for (ImageFrame frame: openFrames) {
                try {
                    frame.setClosed(true);
                } catch (PropertyVetoException e1) {
                    e1.printStackTrace();
                }
                if (frame != null)
                    frame.dispose();
            }

            DALConfig.switchLocalRemoteImageProvider();
            orbitMenu.updateMenuImageProviderEntries();

            // TODO: See below. Figure out where this should really live.
            SwingUtilities.invokeLater(() -> {
                imageList.setModel(new DefaultListModel()); // clear image list
                rdTree.setEnabled(!isLocalImageProvider());
                });

            JOptionPane.showMessageDialog(OrbitImageAnalysis.this,
                    isLocalImageProvider() ? "Image provider local is active." : "Image provider remote is active.",
                    "Image Provider Changed",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // TODO: This needs changing to handle the Image Provider stuff.
    // TODO: Double check same behaviour with new implementation.
//    public void updateMenuImageProviderEntries() {
//        String openButtonTitel = isLocalImageProvider() ? OrbitMenu.openFromLocalStr : OrbitMenu.openFromServerStr;
//        orbitMenu.getAmOpenOrbit().setText(openButtonTitel);
//        orbitMenu.getButtonopenFromOrbit().setText(openButtonTitel);
//        // tree / imagelist
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                imageList.setModel(new DefaultListModel()); // clear image list
//                rdTree.setEnabled(!isLocalImageProvider());
//                orbitMenu.getSwitchImageProviderBtn().setEnabled(!DALConfig.onlyLocalImageProviderAvailable());
//                orbitMenu.getButtonExecuteScaleout().setEnabled(!DALConfig.isLocalImageProvider());
//                orbitMenu.getButtonRetrieveExistingResults().setEnabled(!DALConfig.isLocalImageProvider());
//                orbitMenu.getAmEntryOpenModelOrbit().setEnabled(!DALConfig.isLocalImageProvider());
//                orbitMenu.getAmSaveModelOrbit().setEnabled(!DALConfig.isLocalImageProvider());
//                orbitMenu.getButtonSaveModelOrbit().setEnabled(!DALConfig.isLocalImageProvider());
//                orbitMenu.getButtonLoadAndSetServer().setEnabled(!DALConfig.isLocalImageProvider());
//                orbitMenu.getButtonOrbitBrowser().setEnabled(!DALConfig.isLocalImageProvider());
//                orbitMenu.getButtonModelOpenOrbit().setEnabled(!DALConfig.isLocalImageProvider());
//
//            }
//        });
//    }


    //<editor-fold desc="ActionListeners">
    /**
     * actionlistener
     */


    public final ChangeListener scaleChangeListener = arg0 -> {
        double v = scaleSlider.getValueAdjusted();
        firePropertyChange(ImageFrame.SCALE_SET_EVENT, null, v);
    };

    // CommandActions for OrbitMenu
    private void activateHandTool() {
        if (getIFrame() != null) {
            getIFrame().recognitionFrame.setSelectedTool(Tools.finger);
            getIFrame().recognitionFrame.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }
    final ActionListener handAction = e -> activateHandTool();

    // Taskbar Commands
    final CommandAction HandToolCommandAction = e -> activateHandTool();

    // Open Tab/Task
    // TODO: OpenImage needs looking at due to multiple image provider support.
    final CommandAction OpenImageCommandAction = e -> {
        boolean isLocal = DALConfig.getImageProvider() instanceof ImageProviderLocal;
        if(isLocal) {
            for (ImageFrame iFrame : getIFrames())
                iFrame.recognitionFrame.getMyListener().setDeleteMode(false);
            loadFileOrbit();
        }
    };
    final CommandAction OverviewCommandAction = e -> loadSpecialImage(RawUtilsCommon.LEVEL_OVERVIEW);
    final ActionListener overviewAction = e -> loadSpecialImage(RawUtilsCommon.LEVEL_OVERVIEW);

    final CommandAction OpenForPrintingCommandAction = e -> loadLowResImage(2);
    final CommandAction OpenSpecialResolutionCommandAction = e -> {
        // TODO: See CommandMenuContentModel popupMenuContentModel in BasicCheckRibbon.
    };
    final CommandAction SaveAsOrbitFileCommandAction = e -> saveAsOrbitFile();
    final CommandAction ImageProviderCommandAction = e -> switchLocalRemoteImageProvider();


    // Edit Tab/Task
    private void copyImageToClipboard(boolean copyFullImage) {
        if (getIFrame() != null) {
            if (OrbitUtils.isSmallImage(getIFrame().recognitionFrame.bimg.getImage())) {
                Transferable t = ((DesktopTransferHandler) desktopTransferHandler).createImageTransferable(getIFrame(), copyFullImage);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(t, null);
            } else {
                JOptionPane.showMessageDialog(OrbitImageAnalysis.this,
                        "The image is too large to be copied into the clipboard. " +
                                "\nYou can use ALT-C to copy the currently visible region.",
                        "Image too large", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    final CommandAction CopyImageCommandAction = e -> copyImageToClipboard(false);
    final ActionListener copyImageAction = e -> copyImageToClipboard(false);

    final CommandAction CopyImageLinkCommandAction = e -> {
        Transferable t = ((DesktopTransferHandler) desktopTransferHandler).createTransferable(desktop);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(t, null);
    };

    final CommandAction CopyImageFullCommandAction = e -> copyImageToClipboard(true);
    final ActionListener copyImageFullAction = e -> copyImageToClipboard(true);

    private void pasteImageFromClipboard() {
        String action = (String) TransferHandler.getPasteAction().getValue(Action.NAME);
        Action a = desktop.getActionMap().get(action);
        if (a != null) {
            a.actionPerformed(new ActionEvent(desktop,
                    ActionEvent.ACTION_PERFORMED,
                    null));
        }
    }

    final CommandAction PasteImageCommandAction = e -> pasteImageFromClipboard();
    final ActionListener PasteImageAction = e -> pasteImageFromClipboard();

    // Model Tab/Task
    final CommandAction OpenModelServerCommandAction = e -> {
        ModelBrowser modelBrowser = new ModelBrowser();
        try {
            forceLogin();
            if (loginOk) {
                modelBrowser.showModelBrowser(OrbitImageAnalysis.this, loginUser);
            }
        } catch (Exception e1) {
            //TODO: To logger?
            e1.printStackTrace();
        }
    };
    final CommandAction OpenModelCommandAction = e -> loadModel();
    final CommandAction RestoreTrainingShapesCommandAction = e -> {
        try {
            restoreClassShapes();
        } catch (Exception e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(OrbitImageAnalysis.this, "The training data could not be restored (see log for details).", "Error restoring training data", JOptionPane.ERROR_MESSAGE);
        }
    };
    final CommandAction SaveModelServerCommandAction = e -> {
        if (!checkModelConsistancy(model)) return;
        forceLogin();
        if (loginOk) {
            final JTextField name = new JTextField();
            final JTextField elb = new JTextField();
            // if model has already a name (e.g. a loaded model), set it as default
            if (loadedModel != null && loadedModel.length() > 0 && !loadedModel.equalsIgnoreCase("none")) {
                name.setText(loadedModel);
            }

            // try to set elb from loaded image (optional)
            ImageFrame iFrame = getIFrame();
            if (iFrame != null && iFrame.getRdf() != null) { // image from orbit loaded
                try {
                    RawData rd = DALConfig.getImageProvider().LoadRawData(iFrame.getRdf().getRawDataId());
                    elb.setText(rd.getBioLabJournal());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }

            Object[] message = {
                    "Model Name:", name,
                    "ELB (optional):", elb
            };

            int option = JOptionPane.showConfirmDialog(null, message, "Save Model in Orbit", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                try {
                    if (name.getText().trim().length() > 0) {
                        model.cleanModel();
                        model.prepareModelforSaving(getIFrames());
                        int id = model.saveModelOrbit(elb.getText().trim(), name.getText().trim(), loginUser);
                        loadedModel = name.getText().trim();
                        updateStatusBar();
                        logger.info("model saved in Orbit with id: " + id);
                        JOptionPane.showMessageDialog(OrbitImageAnalysis.this, "Model successfully saved in Orbit", "Model saved", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        logger.warn("No name entered, model not saved!");
                        JOptionPane.showMessageDialog(OrbitImageAnalysis.this, "Model not saved in Orbit because no name has been entered", "Model not saved", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                    logger.error("cannot store model in Orbit (see log for details)");
                }
            }

        }
    };
    final CommandAction SaveModelAsCommandAction = e ->  saveModel(model, loadedModel);;
    final CommandAction SaveNestedExclusionModelCommandAction = e -> {
        if (model.getExclusionModel() != null) {
            model.cleanModel();
            saveModel(model.getExclusionModel(), "");
        } else {
            JOptionPane.showMessageDialog(OrbitImageAnalysis.this, "This model contains no exclusion model.", "No exclusion model available.", JOptionPane.ERROR_MESSAGE);
        }
    };
    final CommandAction SaveNestedSegmentationModelCommandAction = e -> {
        if (model.getSegmentationModel() != null) {
            model.cleanModel();
            saveModel(model.getSegmentationModel(), "");
        } else {
            JOptionPane.showMessageDialog(OrbitImageAnalysis.this, "This model contains no segmentation model.", "No segmentation model available.", JOptionPane.ERROR_MESSAGE);
        }
    };

    private void OpenClassAdminFrame() {
        int boundaryClass = -1;
        if (getIFrame() != null) {
            boundaryClass = getIFrame().getRecognitionFrame().getBoundaryClass();
        }
        ClassAdminFrame configFrame = new ClassAdminFrame(model.getClassShapes(), new ClassListCellRenderer(), boundaryClass, true);

        configFrame.addPropertyChangeListener(OrbitImageAnalysis.this);
        configFrame.setAlwaysOnTop(true);
        configFrame.setVisible(true);
    }

    final CommandAction ClassesCommandAction = e -> OpenClassAdminFrame();
    final ActionListener classesAction = e -> OpenClassAdminFrame();

    final CommandAction FeaturesCommandAction = e -> OpenFeaturesAdminFrame();
    final ActionListener featuresAction = e -> OpenFeaturesAdminFrame();

    private void OpenFeaturesAdminFrame() {
        FeaturesAdminFrame fFrame = new FeaturesAdminFrame(model.getFeatureDescription()); // check
        fFrame.addPropertyChangeListener(OrbitImageAnalysis.this);
        fFrame.setAlwaysOnTop(true);
        fFrame.setVisible(true);
    }

    final CommandAction FuzzinessCommandAction = e -> OpenFuzzinessAdminFrame();
    final ActionListener fuzzinessAction = e -> OpenFuzzinessAdminFrame();

    private void OpenFuzzinessAdminFrame() {
        FuzzynessAdminFrame fFrame = new FuzzynessAdminFrame();
        fFrame.setAlwaysOnTop(true);
        fFrame.setVisible(true);
    }

    final CommandAction ExclusionModelLevelCommandAction = e -> {
        ExclusionAdminFrame frame = new ExclusionAdminFrame(model);
        RawUtilsCommon.centerComponent(frame);
        frame.setVisible(true);
    };
    final CommandAction PerformClusteringCommandAction = e -> {
        this.performClustering = !this.performClustering;
        e.getCommand().setToggleSelected(this.performClustering);
    };
    final CommandAction ResetMainModelCommandAction = e -> {
        if (JOptionPane.showConfirmDialog(OrbitImageAnalysis.this,
                "This will reset all current training shapes.\nDo you want to continue?",
                "Reset current training data?", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) {
            if (resetMainModel())
                JOptionPane.showMessageDialog(OrbitImageAnalysis.this,
                        "Main model successfully reset.",
                        "Main model reset",
                        JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(OrbitImageAnalysis.this,
                        "Main model reset failed.",
                        "Main model reset",
                        JOptionPane.ERROR_MESSAGE);
        }
    };
    final CommandAction ResetPrimarySegmentationModelCommandAction = e -> {
        model.setSegmentationModel(null);
        JOptionPane.showMessageDialog(OrbitImageAnalysis.this,
                "Segmentation model successfully reset.",
                "Segmentation model reset",
                JOptionPane.INFORMATION_MESSAGE);
    };
    final CommandAction ResetSecondarySegmentationModelCommandAction = e -> {
        model.setSecondarySegmentationModel(null);
        JOptionPane.showMessageDialog(OrbitImageAnalysis.this,
                "Secondary segmentation model successfully reset.",
                "Secondary segmentation model reset",
                JOptionPane.INFORMATION_MESSAGE);
    };
    final CommandAction ResetEntireModelCommandAction = e -> {
        if (JOptionPane.showConfirmDialog(OrbitImageAnalysis.this,
                "This will reset all current training shapes.\n" +
                        "Do you want to continue?",
                "Reset current training data?",
                JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {
            if (resetModel())
                JOptionPane.showMessageDialog(OrbitImageAnalysis.this,
                        "Model successfully reset.",
                        "Model reset",
                        JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(OrbitImageAnalysis.this,
                        "Model reset failed.",
                        "Model reset",
                        JOptionPane.ERROR_MESSAGE);
        }
    };

    // Exclusion Model Tab/Task Command Actions

    private boolean classesAreYouSurePopup() {
        return JOptionPane.showConfirmDialog(OrbitImageAnalysis.this,
                "This will reset all current training shapes.\n" +
                        "Do you want to continue?",
                "Reset current training data?", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION;
    }

    //TODO: See also ExclusionModule.java, is this really one command for exclusion model and classification?
    final CommandAction SetupClassesExclusionCommandAction = e -> { if (classesAreYouSurePopup()) resetMainModel(); };
    final CommandAction SetupClassesClassificationCommandAction = e -> { if (classesAreYouSurePopup()) setupClassesForClassification(); };
    final CommandAction SetupClassesObjectSegmentationCommandAction = e -> { if (classesAreYouSurePopup()) setupClassesForObjectSegmentation(); };
    final CommandAction SetupClassesObjectClassificationCommandAction = e -> { if (classesAreYouSurePopup()) setupClassesForObjectClassification(); };


    final CommandAction EraserCommandAction = e -> {
        logger.debug("select polygon to delete");
        if (getIFrame() != null) {
            getIFrame().recognitionFrame.setSelectedTool(Tools.delete);
            getIFrame().recognitionFrame.getMyListener().setDeleteMode(true);
            getIFrame().recognitionFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            getIFrame().recognitionFrame.repaint();
        }
    };
    final CommandAction PolygonCommandAction = e -> {
        logger.debug("brush selected");
        updateSelectedClassShape();
        if (getIFrame() != null) {
            getIFrame().recognitionFrame.setSelectedTool(Tools.brush);
            getIFrame().recognitionFrame.getMyListener().setDeleteMode(false);
            getIFrame().recognitionFrame.getMyListener().setShapeMode(ClassShape.SHAPETYPE_POLYGONEXT);
            getIFrame().recognitionFrame.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        }
    };
    final CommandAction CircleCommandAction = e -> {
        logger.debug("circle selected");
        updateSelectedClassShape();
        if (getIFrame() != null) {
            getIFrame().recognitionFrame.setSelectedTool(Tools.circle);
            getIFrame().recognitionFrame.getMyListener().setDeleteMode(false);
            getIFrame().recognitionFrame.getMyListener().setShapeMode(ClassShape.SHAPETYPE_ARC);
            getIFrame().recognitionFrame.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        }};
    final CommandAction RectangleCommandAction = e -> {
        logger.debug("rectangle selected");
        updateSelectedClassShape();
        if (getIFrame() != null) {
            getIFrame().recognitionFrame.setSelectedTool(Tools.rectangle);
            getIFrame().recognitionFrame.getMyListener().setDeleteMode(false);
            getIFrame().recognitionFrame.getMyListener().setShapeMode(ClassShape.SHAPETYPE_RECTANGLE);
            getIFrame().recognitionFrame.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        }
    };

    // TODO: Something different happening here... Need to figure out how best to tie in with ExclusionModule.java
    final CommandAction TrainSetClassifyCommandAction = e -> {};
    final CommandAction ClassifyTrainedExclusionModelCommandAction = e -> {};
    final CommandAction ConfigureExclusionClassesCommandAction = e -> {};
    final CommandAction LoadAndSetLocalCommandAction = e -> {};
    final CommandAction LoadAndSetServerCommandAction = e -> {};
    final CommandAction SetFromModelExplorerCommandAction = e -> {};
    final CommandAction ResetExclusionModelCommandAction = e -> {};
    final CommandAction ExclusionHelpCommandAction = e -> {};

    private void trainModel() {
        logger.debug("train");
        if (getIFrame() != null) {
            getIFrame().recognitionFrame.getMyListener().setDeleteMode(false);
            train();
            handAction.actionPerformed(null);
        }
    }

    // Classification Tab/Task Command Actions
    final CommandAction TrainCommandAction = e -> trainModel();
    final ActionListener trainAction = e-> trainModel();

    final CommandAction DefineRoiCommandAction = e -> {
        logger.debug("select ROI selected");
        if (getIFrame() != null) {
            getIFrame().recognitionFrame.setSelectedTool(Tools.roi);
            getIFrame().recognitionFrame.getMyListener().setDeleteMode(false);
            getIFrame().recognitionFrame.getMyListener().setShapeMode(ClassShape.SHAPETYPE_POLYGONEXT);
            getIFrame().recognitionFrame.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        }
    };

    private void classifyModel() {
        if (getIFrame() != null) {
            getIFrame().recognitionFrame.getMyListener().setDeleteMode(false);
            classify();
            handAction.actionPerformed(null);
        }
    }
    final CommandAction ClassifyCommandAction = e -> classifyModel();
    final ActionListener classifyAction = e -> classifyModel();

    // Object Detection Tab/Task Command Actions
    final CommandAction SetPrimarySegmentationModelCommandAction = e -> setModelAsSegmentationModel(model, true);
    final CommandAction SetSecondarySegmentationModelCommandAction = e -> setModelAsSecondarySegmentationModel(model, true);
    final CommandAction ObjectSegmentationCommandAction = e -> objectSegmentation(true, false);
    final CommandAction ShowSegmentationHeatmapCommandAction = e -> {
        this.setShowObjectHeatmap(!this.isShowObjectHeatmap());
        OrbitModel model = this.getModel();
        if (model == null || model.getFeatureDescription().getFeatureClasses() == null || model.getFeatureDescription().getFeatureClasses().length == 0) {
            JOptionPane.showMessageDialog(this,
                    "Currently no feature classes are active.\n" +
                            "The heatmap will only be shown if at least one feature class is active.\n" +
                            "You can configure the feature classes in the Feature Configuration (F3), tab Classification.",
                    "No Feature Classes active",
                    JOptionPane.WARNING_MESSAGE);
        }
    };
    final CommandAction ObjectMarkerCommandAction = e -> {
        logger.debug("cell tool selected");
        updateSelectedClassShape();
        if (getIFrame() != null) {
            getIFrame().recognitionFrame.setSelectedTool(Tools.cell);
            getIFrame().recognitionFrame.getMyListener().setDeleteMode(false);
            getIFrame().recognitionFrame.getMyListener().setShapeMode(ClassShape.SHAPETYPE_POLYGONEXT);
            getIFrame().recognitionFrame.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    };
    final CommandAction TrainObjectsCommandAction = e -> {
        trainClassifyNucleid();
        handAction.actionPerformed(null);
    };
    final CommandAction ObjectClassificationCommandAction = e -> classifyNucleid();

    // ROI Tab/Task Command Actions
    final CommandAction ResetRoiCommandAction = e -> {
        if (resetROI()) {
            repaint();
            JOptionPane.showMessageDialog(OrbitImageAnalysis.this,
                    "ROI successfully reset.",
                    "ROI reset",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(OrbitImageAnalysis.this,
                    "ROI reset failed.",
                    "ROI reset",
                    JOptionPane.ERROR_MESSAGE);
        }
    };
    final CommandAction InvertRoiCommandAction = e -> invertROI();
    final CommandAction MeasureAreaCommandAction = e -> {
        try {
            showRoiArea();
        } catch (OrbitImageServletException e1) {
            logger.error("Cannot compute ROI area", e1);
        }
    };
    final CommandAction SegmentationAsRoiCommandAction = e -> {
        RecognitionFrame rf = getIFrame().recognitionFrame;
        if (rf.getObjectSegmentationList() == null || rf.getObjectSegmentationList().size() == 0) {
            JOptionPane.showMessageDialog(OrbitImageAnalysis.this,
                    "The ROI cannot be set because no segmentation shapes are available.\n" +
                            "Please perform a segmentation first.",
                    "No segmentation shapes available",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        final ShapeExtList roiShape = new ShapeExtList(rf.getObjectSegmentationList(), null);
        rf.setROI(roiShape);
        logger.debug("roi set: " + rf.getROI());
        JOptionPane.showMessageDialog(OrbitImageAnalysis.this,
                "The ROI has been successfully set based on segmentation shapes.",
                "ROI successfully set",
                JOptionPane.INFORMATION_MESSAGE);
    };
    final CommandAction TmaRoiCommandAction = e -> this.tmaSpotGUI = new TMASpotGUI(true);

    // Mask Tab/Task Command Actions
    final CommandAction SetClassificationMaskCommandAction = e -> {
        if (maskSet()) {
            JOptionPane.showMessageDialog(OrbitImageAnalysis.this,
                    "Classification mask successfully set.",
                    "Mask set",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(OrbitImageAnalysis.this,
                    "Please select a model in the model explorer which you want to use as mask.",
                    "Mask set failed",
                    JOptionPane.ERROR_MESSAGE);
        }
    };
    final CommandAction SetSegmentationMaskCommandAction = e -> {
        if (maskSegmentationSet()) {
            JOptionPane.showMessageDialog(OrbitImageAnalysis.this,
                    "Segmentation mask successfully set.",
                    "Mask set",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(OrbitImageAnalysis.this,
                    "Please select a model in the model explorer which you want to use as mask.",
                    "Mask set failed",
                    JOptionPane.ERROR_MESSAGE);
        }
    };
    final CommandAction UnsetMaskCommandAction = e -> {
        if (model.getMask()!=null) {
            model.setMask(null);
            updateStatusBar();
            JOptionPane.showMessageDialog(OrbitImageAnalysis.this,
                    "Mask successfully unset.",
                    "Mask unset",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(OrbitImageAnalysis.this,
                    "The model does not contain a mask.",
                    "No mask to unset",
                    JOptionPane.WARNING_MESSAGE);
        }
    };
    final CommandAction ConfigureMaskCommandAction = e -> {
        if (model.getMask()!=null && model.getMask() instanceof IOrbitMaskModelBased) {
            OrbitModel maskModel = ((IOrbitMaskModelBased) model.getMask()).getModel();
            ClassAdminFrame configFrame = new ClassAdminFrame(maskModel.getClassShapes(), new ClassListCellRenderer(), -1, false);
            configFrame.setAlwaysOnTop(true);
            configFrame.setModal(true);
            configFrame.setVisible(true);
            ((IOrbitMaskModelBased) model.getMask()).reconfigure();
        } else {
            if (model.getMask() == null)
                JOptionPane.showMessageDialog(OrbitImageAnalysis.this,
                        "The model does not contain a mask.",
                        "No mask to configure",
                        JOptionPane.WARNING_MESSAGE);
            else {
                JOptionPane.showMessageDialog(OrbitImageAnalysis.this,
                        "The mask is not model based, thus no model can be configured.",
                        "Mask not model based",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    };
    final CommandAction MaskToExplorerCommandAction = e -> {
        if (model.getMask()!=null && model.getMask() instanceof IOrbitMaskModelBased) {
            getModelExplorer().addModel(((IOrbitMaskModelBased) model.getMask()).getModel().clone(),null,false);
            JOptionPane.showMessageDialog(OrbitImageAnalysis.this,
                    "Mask successfully unset.",
                    "Mask unset",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (model.getMask() == null)
                JOptionPane.showMessageDialog(OrbitImageAnalysis.this,
                        "The model does not contain a mask.",
                        "No mask to extract",
                        JOptionPane.WARNING_MESSAGE);
            else {
                JOptionPane.showMessageDialog(OrbitImageAnalysis.this,
                        "The mask is not model based, thus no model can be extracted.",
                        "Mask not model based",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    };

    // Batch Tab/Task Command Actions
    final CommandAction LocalExecutionCommandAction = e -> batchExportMapReduce(false);
    final CommandAction ScaleOutExecutionCommandAction = e -> batchExportMapReduce(true);
    final CommandAction RoiAreaComputationCommandAction = e -> batchExportROIAreasMR();
    final CommandAction RetrieveExistingResultsCommandAction = e -> {
        // TODO: Does this still need Thread and invokeLater? See old code without lambdas...
        new Thread(() -> SwingUtilities.invokeLater(() -> {
            try {
                addInternalFrame(DALConfig.getScaleOut().createExistingResultView());
            } catch (Exception e1) {
                e1.printStackTrace();
                logger.error("error adding result retriever frame: ", e1);
            }
        })).start();
    };

    // Tools Tab/Task Command Actions
    final CommandAction OrbitBrowserCommandAction = e -> {
        forceLogin();
        if (loginOk) {
            DALConfig.getImageProvider().openBrowser(loginUser, loginPassword);
        }
    };
    final CommandAction DbCleanupCommandAction = e -> {
        forceLogin();
        if (loginOk) {
            if (JOptionPane.showConfirmDialog(OrbitImageAnalysis.this,
                    "Do you really want to cleanup the local database?\n" +
                            "Entries (e.g. annotations) of non-existing files will be removed.\n" +
                            "This only affects the local files, not files on an image server.",
                    "Cleanup local database",
                    JOptionPane.YES_NO_OPTION)
                        == JOptionPane.YES_OPTION) {
                try {
                    ImageProviderLocal.DBCleanup();
                    JOptionPane.showMessageDialog(OrbitImageAnalysis.this,
                            "DB cleanup successfully completed.",
                            "Cleanup completed",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e1) {
                    e1.printStackTrace();
                    logger.error("DB cleanup error: " + e1.getMessage());
                }
            }
        }
    };
    final CommandAction ChannelColorResetCommandAction = e -> {
        forceLogin();
        if (loginOk) {
            if (JOptionPane.showConfirmDialog(OrbitImageAnalysis.this,
                    "Do you really want to reset all custom channel/color assignments?\n" +
                            "Afterwards Orbit will use the default assignments.",
                    "Reset channel/color assignments",
                    JOptionPane.YES_NO_OPTION)
                        == JOptionPane.YES_OPTION) {
                try {
                    resetChannelColorAssignmentsPreferences();
                    JOptionPane.showMessageDialog(OrbitImageAnalysis.this,
                            "Channel/color assignments successfully reset.\n" +
                                    "You have to restart Orbit to realize the settings.",
                            "Channel/color assignment reset",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e1) {
                    e1.printStackTrace();
                    logger.error("Channel/color assignment reset error: " + e1.getMessage());
                }
            }
        }
    };
    final CommandAction SaveFullImageCommandAction = e -> getIFrame().getRecognitionFrame().makeImageSnapshot();
    final CommandAction SaveCurrentViewCommandAction = e -> getIFrame().saveCurrentView();
    final CommandAction SaveClassificationImageCommandAction = e -> saveClassImage();
    final CommandAction ScriptEditorCommandAction = e -> {
        boolean found = false;
        for (JInternalFrame frame : desktop.getAllFrames()) {
            if (frame instanceof ScriptEditor) {
                found = true;
                try {
                    if (frame.isIcon())
                        frame.setMaximum(true);
                } catch (PropertyVetoException e1) {
                    e1.printStackTrace();
                }
                desktop.setSelectedFrame(frame);
                frame.requestFocus();
                desktop.getDesktopManager().activateFrame(frame);
            }
        }
        if (!found) {
            addInternalFrame(createScriptEditor());
        }
    };

    private void tileWindows() {
        if (desktop.getAllFrames() == null) return;
        if (desktop.getAllFrames().length < 1) return;
        int numFrames = desktop.getAllFrames().length;
        int numX = (int) Math.round(Math.sqrt(numFrames) - 0.4999d);
        int numY = (int) Math.round(Math.sqrt(numFrames));
        if (numX * numY < numFrames) numY++;
        int frameWidth = desktop.getWidth() / numX;
        int frameHeight = desktop.getHeight() / numY;

        int x = 0;
        int y = 0;
        final JInternalFrame[] frames = desktop.getAllFrames();
        for (JInternalFrame frame : frames) {
            try {
                frame.setMaximum(true);
                frame.setMaximum(false);
                frame.setBounds(x * frameWidth, y * frameHeight, frameWidth, frameHeight);
                frame.setSelected(true);
            } catch (PropertyVetoException e1) {
                e1.printStackTrace();
            }
            x++;
            if (x >= numX) {
                x = 0;
                y++;
            }
        }
    }

    // View Tab/Task Command Actions
    final CommandAction TileWindowsCommandAction = e -> tileWindows();
    final ActionListener tileWindowsAction = e -> tileWindows();

    private void cascadeWindows() {
        Dimension dim = defaultWindowDimension;
        int xoffs = 25;
        int yoffs = 25;
        final JInternalFrame[] frames = desktop.getAllFrames();
        for (int i = 0; i < frames.length; ++i) {
            try {
                frames[i].setMaximum(true);
                frames[i].setMaximum(false);
                frames[i].setBounds(xoffs + i * xoffs, yoffs + i * yoffs, dim.width, dim.height);
                frames[i].setSelected(true);
            } catch (PropertyVetoException e1) {
                e1.printStackTrace();
            }
        }
    }

    final CommandAction CascadeWindowsCommandAction = e -> cascadeWindows();
    final ActionListener cascadeWindowsAction = e -> cascadeWindows();

    private void minimizeWindows() {
        final JInternalFrame[] frames = desktop.getAllFrames();
        for (JInternalFrame frame : frames) {
            try {
                frame.setIcon(true);
            } catch (PropertyVetoException e1) {
                e1.printStackTrace();
            }
        }
    }

    final CommandAction MinimizeWindowsCommandAction = e -> minimizeWindows();
    final ActionListener minimizeWindowsAction = e -> minimizeWindows();

    private void closeWindows() {
        if (JOptionPane.showConfirmDialog(OrbitImageAnalysis.this,
                "Do you really want to close all windows?",
                "Close Windows", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) {
            final JInternalFrame[] frames = desktop.getAllFrames();
            for (JInternalFrame frame : frames) {
                try {
                    frame.setClosed(true);
                } catch (PropertyVetoException e1) {
                    e1.printStackTrace();
                }
                frame.dispose();
            }
        }
    }

    final CommandAction CloseWindowsCommandAction = e -> closeWindows();
    final ActionListener closeWindowsAction = e -> closeWindows();

    final CommandAction ShowToolbarCommandAction = e -> getRibbon().setMinimized(!getRibbon().isMinimized());
    final CommandAction ShowStatusBarCommandAction = e -> {
        showStatusbar = !showStatusbar;
        if (showStatusbar) {
            statusBar.setVisible(true);
            e.getCommand().setToggleSelected(true);
        } else {
            statusBar.setVisible(false);
            e.getCommand().setToggleSelected(false);
        }
    };
    final CommandAction ShowGaugeCommandAction = e -> {
        showGauge = !showGauge;
        desktop.repaint();
    };
    final CommandAction ShowLabelsCommandAction = e -> {
        showAnnotationLabels = !showAnnotationLabels;
        if (getIFrames() != null) {
            for (ImageFrame iFrame : getIFrames()) {
                iFrame.recognitionFrame.setDisplayAnnotationLabels(showAnnotationLabels);
                iFrame.recognitionFrame.repaint();
            }
        }
    };
    final CommandAction ShowCenterCrossCommandAction = e -> {
        showCenterCross = !showCenterCross;
        renderGrid.setShowCross(showCenterCross);
        renderGrid.repaint();
    };
    final CommandAction ShowMarkupCommandAction = e -> toggleMarkup();
    final ActionListener showMarkupAction = e -> toggleMarkup();

    final CommandAction ShowSyncFramesCommandAction = e -> syncFrames = !syncFrames;
    final CommandAction ShowPopupResultsCommandAction = e -> showPopupResults = !showPopupResults;

    // Help Tab/Task Command Actions
    final CommandAction OrbitManualCommandAction = e -> OrbitUtils.openPdfUrl(OrbitUtils.orbitHelpURL);
    final ActionListener orbitManualAction = e -> OrbitUtils.openPdfUrl(OrbitUtils.orbitHelpURL);

    final CommandAction AboutCommandAction = e -> {
        if (logger.isTraceEnabled()) {
            logger.trace("Open Frames:");
            for (JInternalFrame frame : desktop.getAllFrames()) {
                logger.trace("Frame: " + frame.getTitle());
            }
            logger.trace("PropertyChangeListeners in OrbitImageAnalysis:");
            for (PropertyChangeListener pc : OrbitImageAnalysis.this.getPropertyChangeListeners()) {
                logger.trace("PCL: " + pc);
            }
        }
        JOptionPane.showMessageDialog(OrbitImageAnalysis.this,  //(Component) e.getSource()
                getInfoString(),
                "About Orbit Image Analysis", JOptionPane.INFORMATION_MESSAGE);
    };
    final CommandAction ShowLogCommandAction = e -> showLog();
    final CommandAction ShowLogModelCommandAction = e -> {
        logger.info("Model Information:\n" + model);
        if (!ScaleoutMode.SCALEOUTMODE.get()) {
            JOptionPane.showMessageDialog(OrbitImageAnalysis.this, "Model information written to log. Please open the log window to see the information.", "Model written to log", JOptionPane.INFORMATION_MESSAGE);
        }
    };

    public final ActionListener copyOrbitListActionHandler = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            Transferable t = ((DesktopTransferHandler) desktopTransferHandler).createTransferable(desktop);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(t, null);
        }
    };
    public final ActionListener copyImageFullActionHandler = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (getIFrame() != null) {
                if (OrbitUtils.isSmallImage(getIFrame().recognitionFrame.bimg.getImage())) {
                    Transferable t = ((DesktopTransferHandler) desktopTransferHandler).createImageTransferable(getIFrame(), true);
                    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(t, null);
                } else {
                    JOptionPane.showMessageDialog(OrbitImageAnalysis.this, "The image is too large to be copied into the clipboard. " +
                            "\nYou can use ALT-C to copy the currently visible region.", "Image too large", JOptionPane.WARNING_MESSAGE);
                }
            } if (getIFrame() != null) {
                if (OrbitUtils.isSmallImage(getIFrame().recognitionFrame.bimg.getImage())) {
                    Transferable t = ((DesktopTransferHandler) desktopTransferHandler).createImageTransferable(getIFrame(), true);
                    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(t, null);
                } else {
                    JOptionPane.showMessageDialog(OrbitImageAnalysis.this, "The image is too large to be copied into the clipboard. " +
                            "\nYou can use ALT-C to copy the currently visible region.", "Image too large", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    };

    public final ActionListener configureFeaturesSegmentationActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            FeaturesAdminFrame fFrame = new FeaturesAdminFrame(model.getFeatureDescription(), 1); // check
            fFrame.addPropertyChangeListener(OrbitImageAnalysis.this);
            fFrame.setAlwaysOnTop(true);
            fFrame.setVisible(true);
        }
    };

    public final ActionListener exitProgramActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            exitProcedure();
        }
    };
    public final ActionListener logoffActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            logoff();
        }
    };
    public final ActionListener loginActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            login();
        }
    };

    public final ActionListener loadAperioLabelActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            loadSpecialImage(RawUtilsCommon.LEVEL_LABEL);
        }
    };
    public final ActionListener loadMediumResolutionActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            loadLowResImage(2);    // 2  / test:4
        }
    };
    public final ActionListener loadLowResolutionActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            loadLowResImage(1);
        }
    };
    public final ActionListener loadTMAThumbnailActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            loadThumbnailImage();
        }
    };




    private void resetChannelColorAssignmentsPreferences() throws BackingStoreException {
        Preferences channelPrefs = Preferences.userNodeForPackage(ChannelToHue.class);
        for (String key: channelPrefs.keys()) {
            if (key.startsWith(OrbitUtils.CHANNEL_NAME2HUE)) {
                channelPrefs.remove(key);
            }
        }
    }


//    public String askForDir() {
//        logger.trace("ask for dir");
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setMultiSelectionEnabled(false);
//        fileChooser.setDialogTitle("Select Download Directory");
//        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//        String dir = prefs.get("OrbitImageAnalysis.DownloadToDir", null);
//        if (dir != null) {
//            File cd = new File(dir);
//            fileChooser.setCurrentDirectory(cd);
//        }
//        int returnVal = fileChooser.showOpenDialog(OrbitImageAnalysis.this);
//        if (returnVal == JFileChooser.APPROVE_OPTION) {
//            prefs.put("OrbitImageAnalysis.DownloadToDir", fileChooser.getCurrentDirectory().getAbsolutePath());
//            File file = fileChooser.getSelectedFile();
//            return file.getAbsolutePath();
//        } else {
//            logger.trace("ask dir canceled.");
//            return null;
//        }
//    }


    public final ActionListener showExclusionModuleActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            setShowExclusionModule(!isShowExclusionModule());
            if (isShowExclusionModule()) {
                metaBar.addOrbitModule(getExclusionModule());
            } else {
                metaBar.removeOrbitModule(getExclusionModule());
            }
        }
    };

    public final ActionListener showManualBoxCountActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            setShowManualBoxCount(!isShowManualBoxCount());
            if (isShowManualBoxCount()) {
                metaBar.addOrbitModule(getManualBoxCountModule());
            } else {
                metaBar.removeOrbitModule(getManualBoxCountModule());
            }
        }
    };
    public final ActionListener showManualClassificationActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            setShowManualClassification(!isShowManualClassification());
            if (isShowManualClassification()) {
                metaBar.addOrbitModule(getManualClassificationModule());
            } else {
                metaBar.removeOrbitModule(getManualClassificationModule());
            }
        }
    };
    public final ActionListener showNerveDetectionActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            setShowNerveDetection(!isShowNerveDetection());
            if (isShowNerveDetection()) {
                metaBar.addOrbitModule(getNerveDetectionModule());
            } else {
                metaBar.removeOrbitModule(getNerveDetectionModule());
            }
        }
    };
    public final ActionListener showRareObjectDetectionActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            setShowRareObjectDetection(!isShowRareObjectDetection());
            if (isShowRareObjectDetection()) {
                metaBar.addOrbitModule(getRareObjectDetectionModule());
            } else {
                metaBar.removeOrbitModule(getRareObjectDetectionModule());
            }
        }
    };
    public final ActionListener showCellProfilerActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            setShowCellProfiler(!isShowCellProfiler());
            if (isShowCellProfiler()) {
                metaBar.addOrbitModule(getCellProfilerModule());
            } else {
                metaBar.removeOrbitModule(getCellProfilerModule());
            }
        }
    };


    public final ActionListener showThresholdClassificationActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            setShowThresholdClassification(!isShowThresholdClassification());
            if (showThresholdClassification) {
                metaBar.addOrbitModule(getThresholdModule());
            } else {
                metaBar.removeOrbitModule(getThresholdModule());
            }
        }
    };

    public final ActionListener showMihcModuleActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            setShowMihcModule(!isShowMihcModule());
            if (showMihcModule) {
                metaBar.addOrbitModule(getMihcModule());
            } else {
                metaBar.removeOrbitModule(getMihcModule());
            }
        }
    };

    public final ActionListener tutorialsBrowserActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            OrbitUtils.openPdfUrl(OrbitUtils.orbitTutorialsURL);
        }
    };


    public final ActionListener activateAllChannelsActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            metaBar.getAdjustPanel().getRedCb().setSelected(true);
            metaBar.getAdjustPanel().getGreenCb().setSelected(true);
            metaBar.getAdjustPanel().getBlueCb().setSelected(true);
        }
    };
    public final ActionListener toggleBlueActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            metaBar.getAdjustPanel().getBlueCb().doClick();
        }
    };
    public final ActionListener toggleGreenActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            metaBar.getAdjustPanel().getGreenCb().doClick();
        }
    };
    public final ActionListener toggleRedActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            metaBar.getAdjustPanel().getRedCb().doClick();
        }
    };


    public final ActionListener resetRedChannelActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            OrbitImageAnalysis.this.redChannel = null;
            OrbitImageAnalysis.this.redChannelRdfId = 0;
            logger.debug("red channel reset. New red channel is: " + OrbitImageAnalysis.this.redChannel);
        }
    };
    public final ActionListener getRedChannelActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            //if (OrbitImageAnalysis.this.redChannel!=null)
            {
                getIFrame().recognitionFrame.bimg.setRedChannel(OrbitImageAnalysis.this.redChannel);
                getIFrame().recognitionFrame.bimg.setRedChannelRdfId(redChannelRdfId);
                getIFrame().recognitionFrame.repaint();
                logger.debug("iFrame red channel is: " + getIFrame().recognitionFrame.bimg.getRedChannel());
            }
        }
    };
    public final ActionListener setRedChannelActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            OrbitImageAnalysis.this.redChannel = getIFrame().recognitionFrame.bimg.getImage();
            if (getIFrame() != null && getIFrame().getRdf() != null)
                OrbitImageAnalysis.this.redChannelRdfId = getIFrame().getRdf().getRawDataFileId();
            logger.debug("new red channel is: " + OrbitImageAnalysis.this.redChannel);
        }
    };
    public final ActionListener resetGreenActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            OrbitImageAnalysis.this.greenChannel = null;
            OrbitImageAnalysis.this.greenChannelRdfId = 0;
            logger.debug("green channel reset. New green channel is: " + OrbitImageAnalysis.this.greenChannel);
        }
    };
    public final ActionListener getGreenChannelActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            //if (OrbitImageAnalysis.this.greenChannel!=null)
            {
                getIFrame().recognitionFrame.bimg.setGreenChannel(OrbitImageAnalysis.this.greenChannel);
                getIFrame().recognitionFrame.bimg.setGreenChannelRdfId(greenChannelRdfId);
                getIFrame().recognitionFrame.repaint();
                logger.debug("iFrame green channel is: " + getIFrame().recognitionFrame.bimg.getGreenChannel());
            }
        }
    };
    public final ActionListener setGreenChannelActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            OrbitImageAnalysis.this.greenChannel = getIFrame().recognitionFrame.bimg.getImage();
            if (getIFrame() != null && getIFrame().getRdf() != null)
                OrbitImageAnalysis.this.greenChannelRdfId = getIFrame().getRdf().getRawDataFileId();
            logger.debug("new green channel is: " + OrbitImageAnalysis.this.greenChannel);
        }
    };
    public final ActionListener resetBlueChannelActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            OrbitImageAnalysis.this.blueChannel = null;
            OrbitImageAnalysis.this.blueChannelRdfId = 0;
            logger.debug("blue channel reset. New blue channel is: " + OrbitImageAnalysis.this.blueChannel);
        }
    };
    public final ActionListener getBlueChannelActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            //if (OrbitImageAnalysis.this.blueChannel!=null)
            {
                getIFrame().recognitionFrame.bimg.setBlueChannel(OrbitImageAnalysis.this.blueChannel);
                getIFrame().recognitionFrame.bimg.setBlueChannelRdfId(blueChannelRdfId);
                getIFrame().recognitionFrame.repaint();
                logger.debug("iFrame blue channel is: " + getIFrame().recognitionFrame.bimg.getBlueChannel());
            }
        }
    };
    public final ActionListener setBlueChannelActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            OrbitImageAnalysis.this.blueChannel = getIFrame().recognitionFrame.bimg.getImage();
            if (getIFrame() != null && getIFrame().getRdf() != null)
                OrbitImageAnalysis.this.blueChannelRdfId = getIFrame().getRdf().getRawDataFileId();
            logger.debug("new blue channel is: " + OrbitImageAnalysis.this.blueChannel);
        }
    };
    public final ActionListener resetOverlayActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            OrbitImageAnalysis.this.overlayChannel = null;
            OrbitImageAnalysis.this.overlayChannelRdfId = 0;
            logger.debug("overlay channel reset. New overlay channel is: " + OrbitImageAnalysis.this.overlayChannel);
        }
    };
    public final ActionListener getOverlayActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            getIFrame().recognitionFrame.bimg.setOverlayChannel(OrbitImageAnalysis.this.overlayChannel);
            getIFrame().recognitionFrame.bimg.setOverlayChannelRdfId(overlayChannelRdfId);
            getIFrame().recognitionFrame.repaint();
            logger.debug("iFrame overlay channel is: " + getIFrame().recognitionFrame.bimg.getOverlayChannel());
        }
    };
    public final ActionListener setOverlayActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            OrbitImageAnalysis.this.overlayChannel = getIFrame().recognitionFrame.bimg.getImage();
            if (getIFrame() != null && getIFrame().getRdf() != null)
                OrbitImageAnalysis.this.overlayChannelRdfId = getIFrame().getRdf().getRawDataFileId();
            logger.debug("new overlay channel is: " + OrbitImageAnalysis.this.overlayChannel);
        }
    };

    public final ActionListener saveChannelLinksActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (getIFrame() != null) {
                getIFrame().saveChannels();
            }
        }
    };
    public final ActionListener removeLinkedChannelsActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (getIFrame() != null) {
                getIFrame().removeChannels();
            }
        }
    };

    public final ActionListener addPolygonAnnotationActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (metaBar != null && metaBar.getAnnotationPanel() != null) {
                metaBar.getAnnotationPanel().addPolygonActionListener.actionPerformed(e);
            }
        }
    };

    public final ActionListener scriptEditorActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean found = false;
            for (JInternalFrame frame : desktop.getAllFrames()) {
                if (frame instanceof ScriptEditor) {
                    found = true;
                    try {
                        if (frame.isIcon())
                            frame.setMaximum(true);
                    } catch (PropertyVetoException e1) {
                        e1.printStackTrace();
                    }
                    desktop.setSelectedFrame(frame);
                    frame.requestFocus();
                    desktop.getDesktopManager().activateFrame(frame);
                }
            }
            if (!found) {
                addInternalFrame(createScriptEditor());
            }
        }
    };

    private ScriptEditor createScriptEditor() {
        ScriptEditor scriptEditor = new ScriptEditor();
        scriptEditor.setVisible(true);
        scriptEditor.setAutoscrolls(false);
        scriptEditor.setResizable(true);
        scriptEditor.setBounds(10, 10, 1000, 1000);
        scriptEditor.setPreferredSize(new Dimension(scriptEditor.getWidth(), scriptEditor.getHeight()));
        return scriptEditor;
    }

    public final ActionListener switchLocalRemoteImageProvider = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            switchLocalRemoteImageProvider();
        }
    };


    //</editor-fold>


    //<editor-fold desc="getter & setter">

    /**
     * getter & setter
     */


    public boolean isSyncFrames() {
        return syncFrames;
    }

    public boolean isShowGauge() {
        return showGauge;
    }

    public JComboBox getSizeBox() {
        if (sizeBox == null) {
            sizeBox = new JComboBox(new Integer[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 52, 54, 56, 58, 60, 62, 64, 66, 68, 70});
            sizeBox.setEditable(true);
            sizeBox.setToolTipText("size for drawing arcs and fixed size rectangles");
            sizeBox.setMaximumSize(new Dimension(50, TOOLBAR_HEIGHT));
            sizeBox.setInputVerifier(new InputVerifier() {
                @Override
                public boolean verify(JComponent input) {
                    try {
                        Integer.parseInt(Objects.requireNonNull(((JComboBox) input).getSelectedItem()).toString());
                        return true;
                    } catch (Exception e) {
                        ((JComboBox) input).setSelectedItem(4);
                        input.repaint();
                        return false;
                    }
                }
            });
            final ActionListener sizeAction = e -> {
                int size = 0;
                try {
                    size = (Integer) ((JComboBox) e.getSource()).getSelectedItem();
                    getIFrame().recognitionFrame.setTargetRadius(size);
                } catch (Exception ignored) {
                }

            };
            sizeBox.addActionListener(sizeAction);
        }
        return sizeBox;
    }


    public boolean isObjectSegmentationEnabled() {
        return objectSegmentationEnabled;
    }


    public void setObjectSegmentationEnabled(boolean objectSegmentationEnabled) {
        this.objectSegmentationEnabled = objectSegmentationEnabled;
    }


    public boolean isCellCountEnabled() {
        return cellCountEnabled;
    }


    public void setCellCountEnabled(boolean cellCountEnabled) {
        this.cellCountEnabled = cellCountEnabled;
    }


    public String getLoadedModelFilename() {
        return loadedModel;
    }

    public MetaTabs getMetaBar() {
        return metaBar;
    }

    public RenderGrid getRenderGrid() {
        return renderGrid;
    }

    public OrbitModel getModel() {
        return model;
    }

    public double getPixelFuzzyness() {
        return pixelFuzzyness;
    }

    public double getTileFuzzyness() {
        return tileFuzzyness;
    }

    public void setModel(OrbitModel model) {
        this.model = model;
    }

    public void setPixelFuzzyness(double pixelFuzzyness) {
        this.pixelFuzzyness = pixelFuzzyness;
    }

    public void setTileFuzzyness(double tileFuzzyness) {
        this.tileFuzzyness = tileFuzzyness;
    }


    public JPanel getPropertyPanel() {
        return propertyPanel;
    }

    public JPanel getTaskPanel() {
        return taskPanel;
    }


    public JDesktopPane getDesktop() {
        return desktop;
    }

    public RareObjectDetectionModule getRareObjectDetectionModule() {
        if (rareObjectDetectionModule == null) {
            rareObjectDetectionModule = new RareObjectDetectionModule(true);
        }
        return rareObjectDetectionModule;
    }

    public CellProfilerModule getCellProfilerModule() {
        if (cellProfilerModule == null) {
            cellProfilerModule = new CellProfilerModule(true);
        }
        return cellProfilerModule;
    }

    public NerveDetectionModule getNerveDetectionModule() {
        if (nerveDetectionModule == null) {
            nerveDetectionModule = new NerveDetectionModule(true);
        }
        return nerveDetectionModule;
    }

    public ManualClassificationModule getManualClassificationModule() {
        if (manualClassificationModule == null) {
            manualClassificationModule = new ManualClassificationModule(true);
        }
        return manualClassificationModule;
    }

    public ManualBoxCountModule getManualBoxCountModule() {
        if (manualBoxCountModule == null) {
            manualBoxCountModule = new ManualBoxCountModule(true);
        }
        return manualBoxCountModule;
    }

    public TMASpotGUI getTMASpotModule() {
        if (tmaSpotGUI == null) {
            tmaSpotGUI = new TMASpotGUI(true);
        }
        return tmaSpotGUI;
    }

    public ThresholdModule getThresholdModule() {
        if (thresholdModule == null) {
            thresholdModule = new ThresholdModule();
        }
        return thresholdModule;
    }

    public ExclusionModule getExclusionModule() {
        if (exclusionModule == null) {
            exclusionModule = new ExclusionModule();
        }
        return exclusionModule;
    }


    public MihcModule getMihcModule() {
        if (mihcModule == null) {
            mihcModule = new MihcModule();
        }
        return mihcModule;
    }

    public ModelExplorer getModelExplorer() {
        if (modelExplorer == null) {
            modelExplorer = new ModelExplorer();
        }
        return modelExplorer;
    }


    public String getLoadedModel() {
        return loadedModel;
    }

    public SliderWithListener getScaleSlider() {
        return scaleSlider;
    }

    public boolean isPerformClustering() {
        return performClustering;
    }

    public boolean isShowObjectHeatmap() {
        return showObjectHeatmap;
    }

    public void setShowObjectHeatmap(boolean showObjectHeatmap) {
        this.showObjectHeatmap = showObjectHeatmap;
    }

    public boolean isShowExclusionModule() {
        return showExclusionModule;
    }

    public void setShowExclusionModule(boolean showExclusionModule) {
        this.showExclusionModule = showExclusionModule;
    }

    public boolean isShowManualBoxCount() {
        return showManualBoxCount;
    }

    public void setShowManualBoxCount(boolean showManualBoxCount) {
        this.showManualBoxCount = showManualBoxCount;
    }

    public boolean isShowManualClassification() {
        return showManualClassification;
    }

    public void setShowManualClassification(boolean showManualClassification) {
        this.showManualClassification = showManualClassification;
    }

    public boolean isShowNerveDetection() {
        return showNerveDetection;
    }

    public void setShowNerveDetection(boolean showNerveDetection) {
        this.showNerveDetection = showNerveDetection;
    }

    public boolean isShowRareObjectDetection() {
        return showRareObjectDetection;
    }

    public void setShowRareObjectDetection(boolean showRareObjectDetection) {
        this.showRareObjectDetection = showRareObjectDetection;
    }

    public boolean isShowThresholdClassification() {
        return showThresholdClassification;
    }

    public void setShowThresholdClassification(boolean showThresholdClassification) {
        this.showThresholdClassification = showThresholdClassification;
    }

    public boolean isShowMihcModule() {
        return showMihcModule;
    }

    public void setShowMihcModule(boolean showMihcModule) {
        this.showMihcModule = showMihcModule;
    }

    public boolean isShowAnnotationLabels() {
        return showAnnotationLabels;
    }

    public boolean isShowCenterCross() {
        return showCenterCross;
    }

    public JCheckBoxMenuItem getShowGaugeCheckbox() {
        return showGaugeCheckbox;
    }

    public boolean isShowStatusbar() {
        return showStatusbar;
    }

    public boolean isShowToolbar() {
        return showToolbar;
    }

    public boolean isShowMarkup() {
        return showMarkup;
    }

    public boolean isShowPopupResults() {
        return showPopupResults;
    }

    public void setShowPopupResults(boolean showPopupResults) {
        this.showPopupResults = showPopupResults;
    }

    public boolean isShowCellProfiler() {
        return showCellProfiler;
    }

    public void setShowCellProfiler(boolean showCellProfiler) {
        this.showCellProfiler = showCellProfiler;
    }

    public boolean isModifiedClassShapes() {
        return modifiedClassShapes;
    }

    public void setModifiedClassShapes(boolean modifiedClassShapes) {
        this.modifiedClassShapes = modifiedClassShapes;
    }



    public JSplitPane getSplitPanePropLoupe() {
        return splitPanePropLoupe;
    }




    //</editor-fold>



    private static class OutputStreamCombiner extends OutputStream {
        private final List<OutputStream> outputStreams;

        public OutputStreamCombiner(List<OutputStream> outputStreams) {
            this.outputStreams = outputStreams;
        }

        public void write(int b) throws IOException {
            for (OutputStream os : outputStreams) {
                os.write(b);
            }
        }

        public void flush() throws IOException {
            for (OutputStream os : outputStreams) {
                os.flush();
            }
        }

        public void close() throws IOException {
            for (OutputStream os : outputStreams) {
                os.close();
            }
        }
    }

}