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
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImageIOrbitImage;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.imageAnalysis.utils.TiledImageWriter;
import ij.gui.ColorChooser;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.event.ItemListener;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.prefs.Preferences;

public class ImageOverlayModule extends AbstractOrbitRibbonModule {

    private enum alphaModeEnum {SATURATION_AFTER_MAX, TRANSPARENT_AFTER_MAX, OPAQUE}

    // Constants
    // The pixel size is expected to be removed and be read from the input files
    public static final long serialVersionUID = 1L;

    // Static preferences
    protected static Preferences prefs = Preferences.userNodeForPackage(ImageOverlayModule.class);
    protected static final Logger logger = LoggerFactory.getLogger(ImageOverlayModule.class);
    private static final String prefsOverlayDir = "overlayDir";

    // User interface
    private final JButton btnLoadOverlay = new JButton("Load");
    private final JButton btnLoadDiskOverlay = new JButton("Load from disk");
    private final JButton btnShowHelp = new JButton("Help");
    private final JComboBox<LocalOverlay> mapSelectionBox = new JComboBox<>();
    private final ItemListener mapSelectionListener = e -> handleNewMapSelection();
    private final SpinnerNumberModel spinResizeFactorModel = new SpinnerNumberModel(0.0, 0.0, 1e6, 1.0);
    private final JSpinner spinResizeFactor = new JSpinner(spinResizeFactorModel);
    private final JButton btnColorPicker = new JButton("Pick overlay color");
    private final RangeBar rangeBar = new RangeBar(0.0f, 1.0f);
    private final JComboBox<alphaModeEnum> alphaModeComboBox = new JComboBox<>(alphaModeEnum.values());
    private final JButton btnResetProperties = new JButton("Reset");
    private final JButton btnSaveProperties = new JButton("Save");


    // Processing
    ColorModel rgbaColorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB),
            new int[]{8, 8, 8, 8},
            true,
            false,
            Transparency.TRANSLUCENT,
            DataBuffer.TYPE_BYTE);
    ColorConvertOp rgbaConverter = new ColorConvertOp(null);

    public ImageOverlayModule(boolean withGui) {
        super();
        if (withGui) {
            createGUI();
        }
    }

    public void createGUI() {
        JPanel nestedPanel = new JPanel();
        nestedPanel.setLayout(new GridBagLayout());

        rangeBar.setLowValue(0.0f);
        rangeBar.setHighValue(1.0f);

        // layout
        int columns = 2;
        int y = 0;

        Insets insetsCategory = new Insets(5, 0, 0, 5);
        Insets insetsItem = new Insets(5, 5, 0, 5);
        int padYCategory = 4;
        int padYItem = 4;

        // Loading
        nestedPanel.add(btnLoadOverlay, new GridBagConstraints(0, y, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsCategory, 0, padYItem));
        btnLoadOverlay.addActionListener(e -> loadDefaultOverlayFiles());
        nestedPanel.add(btnLoadDiskOverlay, new GridBagConstraints(1, y++, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsCategory, 0, padYItem));
        btnLoadDiskOverlay.addActionListener(e -> selectOverlayFile());

        // Map Selection
        nestedPanel.add(new JLabel("Overlay map:"), new GridBagConstraints(0, y++, columns, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsCategory, 0, padYCategory));
        nestedPanel.add(mapSelectionBox, new GridBagConstraints(0, y++, columns, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsItem, 0, padYItem));
        mapSelectionBox.setRenderer(new DefaultListCellRenderer() {
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                String displayName = "No overlay loaded";
                if (null != value) {
                    displayName = ((LocalOverlay) value).getFileName();
                }
                return super.getListCellRendererComponent(list, displayName, index, isSelected, cellHasFocus);
            }
        });

        // Resize factor spin box
        nestedPanel.add(new JLabel("Resize factor:"), new GridBagConstraints(0, y++, columns, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsCategory, 0, padYCategory));
        nestedPanel.add(spinResizeFactor, new GridBagConstraints(0, y++, columns, 1, 1, 0, GridBagConstraints.NORTHEAST, GridBagConstraints.HORIZONTAL, insetsItem, 0, padYItem));
        spinResizeFactor.addChangeListener(e -> handleNewResizeFactor());

        // Range Bar
        nestedPanel.add(new JLabel("Display Range:"), new GridBagConstraints(0, y++, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsCategory, 0, padYCategory));
        nestedPanel.add(rangeBar, new GridBagConstraints(0, y++, columns, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsItem, 0, 5));
        rangeBar.addPruningBarListener(e -> handleAlphaModeChanged());


        // Color Picker + Alpha mode
        nestedPanel.add(new JLabel("Overlay color:"), new GridBagConstraints(0, y, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsCategory, 0, padYCategory));
        nestedPanel.add(new JLabel("Transparency mode:"), new GridBagConstraints(1, y++, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsCategory, 0, padYCategory));

        nestedPanel.add(btnColorPicker, new GridBagConstraints(0, y, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsItem, 0, padYItem));
        btnColorPicker.addActionListener(e -> changeOverlayColor());

        alphaModeComboBox.setRenderer(new DefaultListCellRenderer() {
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                String displayName = "ERROR";
                if (alphaModeEnum.OPAQUE == value) {
                    displayName = "Opaque";
                } else if (alphaModeEnum.SATURATION_AFTER_MAX == value) {
                    displayName = "Saturate after max";
                } else if (alphaModeEnum.TRANSPARENT_AFTER_MAX == value) {
                    displayName = "Exclude after max";
                }
                return super.getListCellRendererComponent(list, displayName, index, isSelected, cellHasFocus);
            }
        });
        nestedPanel.add(alphaModeComboBox, new GridBagConstraints(1, y++, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsItem, 0, padYItem));
        alphaModeComboBox.addItemListener(e -> handleAlphaModeChanged());

        // Reset / Save parameters
        nestedPanel.add(new JLabel("Parameters:"), new GridBagConstraints(0, y++, columns, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsCategory, 0, padYCategory));
        nestedPanel.add(btnResetProperties, new GridBagConstraints(0, y, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsItem, 0, padYItem));
        btnResetProperties.addActionListener(e -> handleResetProperties());
        nestedPanel.add(btnSaveProperties, new GridBagConstraints(1, y++, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsItem, 0, padYItem));
        btnSaveProperties.addActionListener(e -> handleSaveProperties());

        nestedPanel.add(btnShowHelp, new GridBagConstraints(0, y, columns, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsItem, 0, padYItem));
        btnShowHelp.addActionListener(e -> showHelp());

        JScrollPane scrollPane = new JScrollPane(nestedPanel);
        scrollPane.setWheelScrollingEnabled(true);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        setLayout(new GridLayout());
        add(scrollPane);
    }

    protected void updateImageWriter() {
        OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        ImageFrame iFrame = oia.getIFrame();
        iFrame.getOpacitySlider().setEnabled(true);
        iFrame.getOpacitySlider().setValue(100);
        RecognitionFrame recognitionFrame = iFrame.getRecognitionFrame();
        if (null != recognitionFrame) {
            TiledImageWriter tiledImageWriter = new TiledImageWriter(recognitionFrame.bimg.getImage().getWidth(),
                    recognitionFrame.bimg.getImage().getHeight(), 512, 512) {
                @Override
                public void drawImage(Graphics2D graphics, int _vpOffsX, int _vpOffsY, int _vpWidth, int _vpHeight, double scale) {

                    // Note that the iFrame used here is initialized before the override of drawImage,
                    // so that each overlay is properly refreshed over the right image.
                    LocalOverlay overlay = iFrame.getLocalOverlay();

                    double sc = scale / 100d;

                    // This fills the viewport area
                    // graphics.fillRect((int) (_vpOffsX / sc), (int) (_vpOffsY / sc), (int) (_vpWidth / sc), (int) (_vpHeight / sc));

                    if (null != overlay) {
                        // The level of an overlay map can be different from the level of the underlying image (and usually is)
                        // From the pixel size of the overlay map at the full resolution, we calculate the optimal pyramid level to use
                        int closestLevel = (int) Math.floor(Math.log(1 / overlay.getResizeFactor() / sc) / Math.log(2.0d));

                        closestLevel = Math.max(closestLevel, 0);
                        closestLevel = Math.min(closestLevel, overlay.getNumberOfLevels() - 1);

                        double levelFactor = Math.pow(2.0, closestLevel) * overlay.getResizeFactor();

                        int xAnchor = (int) Math.max(_vpOffsX / sc, 0);
                        int yAnchor = (int) Math.max(_vpOffsY / sc, 0);

                        Rectangle overlayReadRect = new Rectangle((int) Math.round(_vpOffsX / sc / levelFactor),
                                (int) Math.round(_vpOffsY / sc / levelFactor),
                                (int) Math.round(_vpWidth / sc / levelFactor),
                                (int) Math.round(_vpHeight / sc / levelFactor));

                        // Width or Height can be negative if the slide is out of the display area
                        if (overlayReadRect.getWidth() > 0 && overlayReadRect.getHeight() > 0) {
                            OrbitTiledImageIOrbitImage overlayOrbitImage = overlay.getImageAtLevel(closestLevel);
                            BufferedImage overlayBufferedImage = overlayOrbitImage.getAsBufferedImage(overlayReadRect, null);

                            // Takes the value from overlayBufferedImage & 0xFF and convert it to RGBA on the green channel
                            BufferedImage rgbaOverlay = applyColorMap(overlayBufferedImage, overlay);

                            // Scale up the read image to remap on the reference grid at 100% zoom
                            AffineTransform mapTransform = AffineTransform.getTranslateInstance(xAnchor, yAnchor);
                            // Scale after the translation to get the right anchor
                            mapTransform.scale(levelFactor, levelFactor);

                            // Draw with an additional transform instead of changing it with graphics.setTransform()
                            // It has not been tested if only one scaling is done at the rendering or if this implementation
                            // creates two renderings.
                            graphics.drawImage(rgbaOverlay, mapTransform, null);
                        }
                    } else {
                        logger.warn("Overlay is null");
                    }
                }
            };
            recognitionFrame.setClassImage(tiledImageWriter);
        }
    }

    private BufferedImage applyColorMap(BufferedImage overlayBufferedImage, LocalOverlay overlay) {
        double lowValue = 255.0 * overlay.getDisplayRangeMin();
        double highValue = 255.0 * overlay.getDisplayRangeMax();
        alphaModeEnum alphaMode = alphaModeEnum.valueOf(overlay.getAlphaMode());
        Color userColor = overlay.getOverlayColor();

        BufferedImage rgbaOverlay = rgbaConverter.createCompatibleDestImage(overlayBufferedImage, rgbaColorModel);
        WritableRaster rgbaRaster = rgbaOverlay.getRaster();

        int red;
        int green;
        int blue;
        int alpha;
        boolean saturateAfterMax = true;
        boolean forceOpaque = false;
        if (alphaModeEnum.OPAQUE == alphaMode) {
            forceOpaque = true;
        } else if (alphaModeEnum.TRANSPARENT_AFTER_MAX == alphaMode) {
            saturateAfterMax = false;
        } else if (!(alphaModeEnum.SATURATION_AFTER_MAX == alphaMode)) {
            // In case of error, saturation is used and the error is traced in logs
            logger.warn("Unexpected alpha mode: " + alphaMode);
        }

        for (int y = 0; y < overlayBufferedImage.getHeight(); y++) {
            for (int x = 0; x < overlayBufferedImage.getWidth(); x++) {
                int grayInput = overlayBufferedImage.getRGB(x, y) & 0xFF;
                if (grayInput <= lowValue) {
                    red = 0;
                    green = 0;
                    blue = 0;
                    alpha = 0;
                } else if (grayInput >= highValue) {
                    red = userColor.getRed();
                    green = userColor.getGreen();
                    blue = userColor.getBlue();
                    if (saturateAfterMax) {
                        alpha = 255;
                    } else {
                        alpha = 0;
                    }
                } else {
                    red = (int) Math.floor(userColor.getRed() / (highValue - lowValue) * (grayInput - lowValue));
                    green = (int) Math.floor(userColor.getGreen() / (highValue - lowValue) * (grayInput - lowValue));
                    blue = (int) Math.floor(userColor.getBlue() / (highValue - lowValue) * (grayInput - lowValue));
                    alpha = (int) Math.floor(255.0 / (highValue - lowValue) * (grayInput - lowValue));
                }
                if (forceOpaque) {
                    alpha = 255;
                }
                rgbaRaster.setPixel(x, y, new int[]{red, green, blue, alpha});
            }
        }
        return rgbaOverlay;
    }

    protected void showHelp() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        String color = OrbitUtils.DARKUI ? " color=white" : "";
        String h = "<html><body" + color + ">" +
                "<h1>Image Overlay Module</h1>" +
                "<h2>Loading an overlay</h2>" +
                "<ul>" +
                    "<li><b>Load:</b> This option looks for available overlays on the disk with a file pattern as FileName*overlay*.tif. </li>" +
                    "<li><b>Load from disk:</b> Manually select the file to overlay. </li>" +
                    "<li><b>Overlay map:</b> Select the overlay among the open ones. </li>" +
                    "<p>When the image is loaded, it is automatically displayed over the RGB image. <br>" +
                    "The file name appears in the combo box below to select which map to display. <br>" +
                    "Only pyramidal tiff files can be used as overlay. <br>" +
                    "If the image is a RGB image, only the red channel is used as a single channel image.</p>" +
                "</ul>" +
                "<h2>Display parameters: </h2>" +
                "<ul>" +
                    "<li><b>Resize factor:</b> The overlay might not be at the same size than the slide underneath. <br>" +
                    "This factor can be used to restore the proper pixel size. </li>" +
                    "<li><b>Display range:</b> This range allows to select the pixels to display in the overlay based on their value. " +
                    "At the lowest bound, the pixels are transparent and at the higher bound, the pixels are completely opaque and colored. </li>" +
                    "<li><b>Overlay color:</b> Allows to select the color at the higher bound. </li>" +
                    "<li><b>Transparency mode:</b> depending on the settings, the rendering is different." +
                    "<ul>" +
                    "<li><b>Saturate after max:</b> The values that are out of range are saturated and displayed with a fully opaque color." +
                    "<li><b>Exclude after max:</b> The values that are out of range are transparent to exclude too high values from display." +
                    "<li><b>Opaque:</b> The overlay is opaque, low values are displayed in black. " +
                    "In such case, the slider below the image should be used to blend the overlay with the image.</li></ul>" +
                "</ul>" +
                "<h2>Shortcuts</h2>" +
                "<ul>" +
                    "<li><b>F5:</b> Use F5 to Show and Hide the overlay.</li>" +
                "</ul>" +
                "</p>" +
                "</body></html>";
        oia.addInternalFrame(new ResultFrame(h, "Image Overlay Module Help"));
    }

    protected ImageFrame getCurrentFrame() {
        return OrbitImageAnalysis.getInstance().getIFrame();
    }

    protected LocalOverlay getCurrentOverlay() {
        if (null != getCurrentFrame()) {
            return getCurrentFrame().getLocalOverlay();
        } else {
            return null;
        }
    }

    protected void handleAlphaModeChanged() {
        LocalOverlay currentOverlay = getCurrentOverlay();
        if (null != currentOverlay) {
            currentOverlay.setDisplayRangeMin(rangeBar.getLowValue());
            currentOverlay.setDisplayRangeMax(rangeBar.getHighValue());
            Object alphaModeObject = alphaModeComboBox.getSelectedItem();
            if (null != alphaModeObject) {
                currentOverlay.setAlphaMode(alphaModeObject.toString());
            }
            refresh();
        }
    }

    protected void handleNewResizeFactor() {
        LocalOverlay currentOverlay = getCurrentOverlay();
        if (null != currentOverlay) {
            currentOverlay.setResizeFactor((Double) spinResizeFactor.getValue());
            refresh();
        }
    }

    protected void handleNewMapSelection() {
        LocalOverlay currentOverlay = getCurrentOverlay();
        if (null != currentOverlay) {
            getCurrentFrame().setLocalOverlay((LocalOverlay) mapSelectionBox.getSelectedItem());
            updateGUIFromProperties();
            refresh();
        }
    }

    protected void handleResetProperties() {
        LocalOverlay currentOverlay = getCurrentOverlay();
        if (null != currentOverlay) {
            currentOverlay.resetProperties();
            updateGUIFromProperties();
            refresh();
        }
    }

    protected void handleSaveProperties() {
        LocalOverlay currentOverlay = getCurrentOverlay();
        if (null != currentOverlay) {
            currentOverlay.saveProperties();
            updateGUIFromProperties();
            refresh();
        }
    }

    protected void refresh() {
        if (null != getCurrentFrame()) {
            getCurrentFrame().getRecognitionFrame().repaint();
        }
    }

    public void updateGUIFromProperties() {
        // Update the range bar GUI when the focus changed to another opened image
        LocalOverlay currentOverlay = getCurrentOverlay();
        if (null != currentOverlay) {
            rangeBar.setLowAndHigh(currentOverlay.getDisplayRangeMin(), currentOverlay.getDisplayRangeMax(), true);
            spinResizeFactor.setValue(currentOverlay.getResizeFactor());
            alphaModeComboBox.setSelectedItem(alphaModeEnum.valueOf(currentOverlay.getAlphaMode()));
            updateMapSelection();

            rangeBar.setEnabled(true);
            spinResizeFactor.setEnabled(true);
            alphaModeComboBox.setEnabled(true);
            btnSaveProperties.setEnabled(true);
            btnResetProperties.setEnabled(true);
            btnColorPicker.setEnabled(true);
        } else {
            resetGUI();
            rangeBar.setEnabled(false);
            spinResizeFactor.setEnabled(false);
            alphaModeComboBox.setEnabled(false);
            btnSaveProperties.setEnabled(false);
            btnResetProperties.setEnabled(false);
            btnColorPicker.setEnabled(false);
        }
    }

    public void resetGUI() {
        rangeBar.setLowAndHigh(0.0, 1.0, true);
        spinResizeFactor.setValue(1.0);
        alphaModeComboBox.setSelectedItem(alphaModeEnum.SATURATION_AFTER_MAX);
        mapSelectionBox.removeAllItems();
    }

    protected void updateMapSelection() {
        mapSelectionBox.removeItemListener(mapSelectionListener);
        mapSelectionBox.removeAllItems();
        ArrayList<LocalOverlay> loadedOverlays = getCurrentFrame().getLoadedOverlays();
        for (LocalOverlay loadedOverlay : loadedOverlays) {
            mapSelectionBox.addItem(loadedOverlay);
        }
        LocalOverlay currentOverlay = getCurrentOverlay();
        if (null != currentOverlay) {
            mapSelectionBox.setSelectedItem(currentOverlay);
        }
        mapSelectionBox.addItemListener(mapSelectionListener);
    }

    protected void loadOverlay(String overlayPath) {
        getCurrentFrame().loadOverlay(overlayPath);
        updateGUIFromProperties();
    }

    protected void loadDefaultOverlayFiles() {
        String associatedImageDir = getCurrentFrame().getRdf().getDataPath();
        String associatedImageName = getCurrentFrame().getRdf().getFileName();
        String associatedImageNameStem = FilenameUtils.getBaseName(associatedImageName);
        File[] possibleOverlays = findOverlayFiles(associatedImageNameStem, new File(associatedImageDir));

        for (File overlayFile : possibleOverlays) {
            String fullPath = Paths.get(associatedImageDir, overlayFile.getName()).toString();
            loadOverlay(fullPath);
        }

        boolean foundAFile = possibleOverlays.length > 0;
        if (foundAFile) {
            // Set active the first element of the list
            getCurrentFrame().setLocalOverlay(getCurrentFrame().getLoadedOverlays().get(0));
            updateGUIFromProperties();
            updateImageWriter();
        } else {
            logger.error("Could not find any overlay image called \"" + associatedImageNameStem + "*overlay*.tif\" in \"" + associatedImageDir + "\"");
        }
    }

    protected void selectOverlayFile() {
        JFileChooser fileChooser = new JFileChooser(prefs.get(prefsOverlayDir, "."));
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
        fileChooser.setDialogTitle("Select an image to open as overlay");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Tiff files", "tiff", "tif"));
        int res = fileChooser.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            prefs.put(prefsOverlayDir, fileChooser.getSelectedFile().getParent());
            String filePath = fileChooser.getSelectedFile().getPath();
            try {
                loadOverlay(filePath);
                updateImageWriter();
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("Could not load this image as overlay");
            }
        }
    }

    protected void changeOverlayColor() {
        LocalOverlay currentOverlay = getCurrentOverlay();
        if (null != currentOverlay) {
            ColorChooser colorChooser = new ColorChooser("Overlay color", currentOverlay.getOverlayColor(), true);
            currentOverlay.setOverlayColor(colorChooser.getColor());
        }
    }

    public static File[] findOverlayFiles(String associatedImageNameStem, File dir) {
        return findFilenamesMatchingRegex("^" + associatedImageNameStem + ".*overlay.*\\.tif$", dir);
    }

    public static File[] findFilenamesMatchingRegex(String regex, File dir) {
        return dir.listFiles(file -> file.getName().matches(regex));
    }

    @Override
    public String getName() {
        return "Image Overlay";
    }

    @Override
    public void init() {

    }

    @Override
    public void reset() {

    }

}
