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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.File;
import java.nio.file.Paths;
import java.util.prefs.Preferences;

public class AnomalyDetectionModule extends AbstractOrbitRibbonModule {

    private enum alphaModeEnum {SATURATION_AFTER_MAX, TRANSPARENT_AFTER_MAX, OPAQUE}

    // Constants
    // The pixel size is expected to be removed and be read from the input files
    public static final double MU_METER_PER_PIXEL_40X = 0.23;
    public static final long serialVersionUID = 1L;

    // Static preferences
    protected static Preferences prefs = Preferences.userNodeForPackage(AnomalyDetectionModule.class);
    protected static final Logger logger = LoggerFactory.getLogger(AnomalyDetectionModule.class);
    private static final String prefsOverlayDir = "overlayDir";

    // User interface
    private final JButton btnLoadOverlay = new JButton("Load");
    private final JButton btnLoadDiskOverlay = new JButton("Load from disk");
    private final JButton btnShowHelp = new JButton("Help");
    private final SpinnerNumberModel spinPixelSizeModel = new SpinnerNumberModel(0.0, 0.0, 1e6, 0.01);
    private final JSpinner spinPixelSize = new JSpinner(spinPixelSizeModel);
    private final JComboBox<LocalOverlay> mapSelectionBox = new JComboBox<>();
    private final JButton btnColorPicker = new JButton("Pick Color");
    private final RangeBar rangeBar = new RangeBar(0.0f, 1.0f);


    private final JComboBox<alphaModeEnum> alphaModeComboBox = new JComboBox<>(alphaModeEnum.values());


    // Processing
    ColorModel rgbaColorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB),
            new int[]{8, 8, 8, 8},
            true,
            false,
            Transparency.TRANSLUCENT,
            DataBuffer.TYPE_BYTE);
    ColorConvertOp rgbaConverter = new ColorConvertOp(null);

    public AnomalyDetectionModule(boolean withGui) {
        super();
        if (withGui) {
            createGUI();
        }
    }

    public void createGUI() {
        rangeBar.setLowValue(0.15f);
        rangeBar.setHighValue(0.9f);

        // layout
        setLayout(new GridBagLayout());
        int columns = 2;
        int y = 0;

        Insets insetsCategory = new Insets(5, 0, 0, 5);
        Insets insetsItem = new Insets(0, 5, 0, 5);

        // Loading
        add(btnLoadOverlay, new GridBagConstraints(0, y, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsCategory, 0, 0));
        btnLoadOverlay.addActionListener(e -> loadDefaultOverlayFiles());
        add(btnLoadDiskOverlay, new GridBagConstraints(1, y++, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsCategory, 0, 0));
        btnLoadDiskOverlay.addActionListener(e -> selectOverlayFile());

        // Pixel size spin box
        add(new JLabel("Pixel size (μm):"), new GridBagConstraints(0, y++, columns, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsCategory, 0, 0));
        add(spinPixelSize, new GridBagConstraints(0, y++, columns, 1, 1, 0, GridBagConstraints.NORTHEAST, GridBagConstraints.HORIZONTAL, insetsItem, 0, 0));
        spinPixelSize.addChangeListener(e -> handleNewPixelSize());

        // Map Selection
        add(new JLabel("Overlay map:"), new GridBagConstraints(0, y++, columns, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsCategory, 0, 0));
        add(mapSelectionBox, new GridBagConstraints(0, y++, columns, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsItem, 0, 0));
        mapSelectionBox.setRenderer(new DefaultListCellRenderer() {
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                String displayName = "No overlay loaded";
                if (null != value) {
                    displayName = ((LocalOverlay) value).getFilePath();
                }
                return super.getListCellRendererComponent(list, displayName, index, isSelected, cellHasFocus);
            }
        });
        mapSelectionBox.addItemListener(e -> handleNewMapSelection());

        // Color Picker
        add(new JLabel("Overlay color:"), new GridBagConstraints(0, y++, columns, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsCategory, 0, 0));
        add(btnColorPicker, new GridBagConstraints(0, y++, columns, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsItem, 0, 0));
        btnColorPicker.addActionListener(e -> changeOverlayColor());

        // Range Bar
        add(new JLabel("Display Range:"), new GridBagConstraints(0, y++, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsCategory, 0, 5));
        add(rangeBar, new GridBagConstraints(0, y++, columns, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsItem, 0, 5));
        rangeBar.addPruningBarListener(e -> handleAlphaModeChanged());
        add(new JLabel("Transparency mode:"), new GridBagConstraints(0, y++, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsCategory, 0, 5));

        // Alpha Mode
        alphaModeComboBox.setRenderer(new DefaultListCellRenderer() {
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                String displayName = "ERROR";
                if (alphaModeEnum.OPAQUE == value) {
                    displayName = "Opaque";
                } else if (alphaModeEnum.SATURATION_AFTER_MAX == value) {
                    displayName = "Saturate after range max";
                } else if (alphaModeEnum.TRANSPARENT_AFTER_MAX == value) {
                    displayName = "Transparent after range max";
                }
                return super.getListCellRendererComponent(list, displayName, index, isSelected, cellHasFocus);
            }
        });
        add(alphaModeComboBox, new GridBagConstraints(0, y++, columns, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsItem, 0, 0));
        alphaModeComboBox.addItemListener(e -> handleAlphaModeChanged());

        add(btnShowHelp, new GridBagConstraints(0, y, columns, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsCategory, 0, 0));
        btnShowHelp.addActionListener(e -> showHelp());
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
                        // The level of an overlay map can be different from the level of the underlying image
                        // From the pixel size of the overlay map at the full resolution, we calculate the optimal pyramid level to use

                        int closestLevel = (int) Math.floor(Math.log(MU_METER_PER_PIXEL_40X / overlay.getPixelSize() / sc) / Math.log(2.0d));

                        closestLevel = Math.max(closestLevel, 0);
                        closestLevel = Math.min(closestLevel, overlay.getNumberOfLevels() - 1);

                        double levelFactor = Math.pow(2.0, closestLevel) * overlay.getPixelSize() / MU_METER_PER_PIXEL_40X;

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
                            mapTransform.scale(levelFactor, levelFactor);

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
                "<h1>Anomaly Detection Module</h1>" +
                "<ul>" +
                "<li></li>" +
                "</ul>" +
                "</p>" +
                "</body></html>";
        oia.addInternalFrame(new ResultFrame(h, "Anomaly detection Module Help"));
    }

    protected ImageFrame getCurrentFrame(){
        ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
        if (null == iFrame){
            logger.error("Could find an opened image to load an overlay");
        }
        return iFrame;
    }

    protected LocalOverlay getCurrentOverlay() {
        return getCurrentFrame().getLocalOverlay();
    }

    protected void handleAlphaModeChanged() {
        getCurrentOverlay().setDisplayRangeMin(rangeBar.getLowValue());
        getCurrentOverlay().setDisplayRangeMax(rangeBar.getHighValue());
        Object alphaModeObject = alphaModeComboBox.getSelectedItem();
        if (null != alphaModeObject) {
            getCurrentOverlay().setAlphaMode(alphaModeObject.toString());
        }
        refresh();
    }

    protected void handleNewPixelSize() {
        getCurrentOverlay().setPixelSize((Double) spinPixelSize.getValue());
        refresh();
    }

    protected void handleNewMapSelection() {
        getCurrentFrame().setLocalOverlay((LocalOverlay) mapSelectionBox.getSelectedItem());
        updateGUIFromProperties();
        refresh();
    }

    protected void refresh() {
        getCurrentFrame().getRecognitionFrame().repaint();
    }

    public void updateGUIFromProperties() {
        // Update the range bar GUI when the focus changed to another opened image
        LocalOverlay currentOverlay = getCurrentOverlay();
        if (null != currentOverlay) {
            rangeBar.setLowAndHigh(currentOverlay.getDisplayRangeMin(), currentOverlay.getDisplayRangeMax(), true);
            spinPixelSize.setValue(currentOverlay.getPixelSize());
        }
    }

    protected void loadOverlay(String overlayPath) {
        boolean overlayExist = getCurrentFrame().loadOverlay(overlayPath);
        if (!overlayExist){
            mapSelectionBox.addItem(getCurrentFrame().getLocalOverlay());
            mapSelectionBox.setSelectedItem(getCurrentFrame().getLocalOverlay());
        }
    }
    protected void loadDefaultOverlayFiles() {
        String associatedImageDir = getCurrentFrame().getRdf().getDataPath();
        String associatedImageName = getCurrentFrame().getRdf().getFileName();
        String[] extensionSplit = associatedImageName.split("\\.(?=[^.]+$)");
        File[] possibleOverlays = findOverlayFiles(extensionSplit[0], new File(associatedImageDir));

        for (File overlayFile : possibleOverlays) {
            String fullPath = Paths.get(associatedImageDir, overlayFile.getName()).toString();
            loadOverlay(fullPath);
        }

        boolean foundAFile = possibleOverlays.length > 0;
        if (foundAFile) {
            // Set active the first element of the list
            mapSelectionBox.setSelectedItem(getCurrentFrame().getLoadedOverlays().get(0));
            updateImageWriter();
        } else {
            logger.error("Could not find any overlay image called \"" + extensionSplit[0] + "*overlay*.tif\" in \"" + associatedImageDir + "\"");
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
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("Could not load this image as overlay");
            }
        }
    }

    protected void changeOverlayColor() {
        ColorChooser colorChooser = new ColorChooser("Overlay color", getCurrentOverlay().getOverlayColor(), true);
        getCurrentOverlay().setOverlayColor(colorChooser.getColor());
    }

    public static File[] findOverlayFiles(String associatedImageNameStem, File dir) {
        return findFilenamesMatchingRegex("^" + associatedImageNameStem + ".*overlay.*\\.tif$", dir);
    }

    /**
     * Finds files in the specified directory whose names match regex
     */
    public static File[] findFilenamesMatchingRegex(String regex, File dir) {
        return dir.listFiles(file -> file.getName().matches(regex));
    }

    @Override
    public String getName() {
        return "Anomaly Detection";
    }

    @Override
    public void init() {

    }

    @Override
    public void reset() {

    }

}
