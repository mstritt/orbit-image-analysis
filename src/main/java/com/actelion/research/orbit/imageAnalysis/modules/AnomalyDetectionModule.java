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

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.components.*;
import com.actelion.research.orbit.imageAnalysis.dal.ImageProviderLocal;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImageIOrbitImage;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.imageAnalysis.utils.TiledImageWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.File;
import java.util.ArrayList;
import java.util.prefs.Preferences;

public class AnomalyDetectionModule extends AbstractOrbitRibbonModule {
    private static final double MU_METER_PER_PIXEL_40X = 0.23;
    private static final double LEVEL_ANOMALY_MAPS = 3;
    private static final double MU_METER_PER_PIXEL_ANOMALY_MAPS = MU_METER_PER_PIXEL_40X * (Math.pow(2, LEVEL_ANOMALY_MAPS));

    private static final long serialVersionUID = 1L;
    protected static Preferences prefs = Preferences.userNodeForPackage(AnomalyDetectionModule.class);
    protected static final Logger logger = LoggerFactory.getLogger(AnomalyDetectionModule.class);
    private final JButton btnStartDetection = new JButton("Start Detection");
    private final JButton btnShowHelp = new JButton("Help");

    private final JComboBox<String> modelSelectionBox = new JComboBox<>();
    private final JComboBox<String> mapSelectionBox = new JComboBox<>();

    private final RangeBar rangeBar = new RangeBar(0.0f, 1.0f);

    private static final String prefsOverlayDir = "overlayDir";
    private static final String prefsRangeMin = "rangeMin";
    private static final String prefsRangeMax = "rangeMax";
    private static ArrayList<OrbitTiledImageIOrbitImage> overlayMipMaps = new ArrayList<OrbitTiledImageIOrbitImage>();
    private static RecognitionFrame recognitionFrame;
    private static TiledImageWriter tiledImageWriter;
    private static ImageProviderLocal localImageProvider = new ImageProviderLocal();
    ColorModel rgbaColorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB),
            new int[]{8, 8, 8, 8},
            true,
            false,
            Transparency.TRANSLUCENT,
            DataBuffer.TYPE_BYTE);
    ColorConvertOp rgbaConverter = new ColorConvertOp(null);

//    private static boolean win_ = System.getProperty("os.name").toLowerCase().startsWith("windows");
//    private static boolean linux_ = System.getProperty("os.name").toLowerCase().startsWith("linux");

    public AnomalyDetectionModule(boolean withGui) {
        super();
        initPreferences();
        if (withGui) {
            createGUI();
        }
    }

    public void createGUI() {
        rangeBar.setLowValue(0.15f);
        rangeBar.setHighValue(0.9f);

        btnStartDetection.addActionListener(e -> startDetection());
        btnShowHelp.addActionListener(e -> showHelp());

        // layout
        setLayout(new GridBagLayout());
        int columns = 2;
        int y = 0;

        Insets insetsCategory = new Insets(5, 0, 0, 5);
        Insets insetsItem = new Insets(0, 5, 0, 5);
        // Start | Help
        add(btnStartDetection, new GridBagConstraints(0, y, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsCategory, 0, 0));
        add(btnShowHelp, new GridBagConstraints(1, y++, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsCategory, 0, 0));

        // Model Selection
        add(new JLabel("Model:"), new GridBagConstraints(0, y++, columns, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsCategory, 0, 0));
        add(modelSelectionBox, new GridBagConstraints(0, y++, columns, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsItem, 0, 0));

        // Map Selection
        add(new JLabel("Overlay map:"), new GridBagConstraints(0, y++, columns, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsCategory, 0, 0));
        add(mapSelectionBox, new GridBagConstraints(0, y++, columns, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsItem, 0, 0));

        // Range Bar
        add(new JLabel("Display Range:"), new GridBagConstraints(0, y++, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsCategory, 0, 5));
        add(rangeBar, new GridBagConstraints(0, y++, columns, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, insetsItem, 0, 5));
        rangeBar.addPruningBarListener(e -> repaintMap());
    }

    protected void initPreferences() {
        prefs.putFloat(prefsRangeMin, 0.0f);
        prefs.putFloat(prefsRangeMax, 1.0f);
    }


    protected void startDetection() {
        // detectAnomalies() => TBD
        loadResults();
    }


    protected void loadResults() {
        OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        ImageFrame iFrame = oia.getIFrame();
        iFrame.getOpacitySlider().setEnabled(true);

//        String overlayTifPath = "C:\\histo_data\\study1\\3334324-g2.tif";
//        String overlayTifPath = "C:\\whole_slide_anomaly_maps_RGB\\4191147-g4-level3-anomaly.tif";
        String overlayTifPath = "C:\\whole_slide_anomaly_maps_512\\3334324-g2-level3-anomaly.tif";
//        String overlayTifPath = "C:\\whole_slide_anomaly_maps_RGBA\\3334406-g0-level3-anomaly_RGBA.tif";
        try {
            overlayMipMaps.clear();
            boolean readOk = true;
            int iLevel = 0;
            while (readOk) {
                try {
                    RawDataFile overlayRawDataFile = localImageProvider.registerFile(new File(overlayTifPath), iLevel);
                    IOrbitImage overlayOrbit = localImageProvider.createOrbitImage(overlayRawDataFile, iLevel);
                    overlayMipMaps.add(new OrbitTiledImageIOrbitImage(overlayOrbit));
                    logger.info("Create Orbit image at level " + iLevel + " for overlay: " + overlayTifPath);
                    ++iLevel;
                } catch (OrbitImageServletException e) {
                    readOk = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        recognitionFrame = iFrame.getRecognitionFrame();

        updateImageWriter();
    }

    protected void updateImageWriter() {
        if (null != recognitionFrame) {
            tiledImageWriter = new TiledImageWriter(recognitionFrame.bimg.getImage().getWidth(),
                    recognitionFrame.bimg.getImage().getHeight(), 512, 512) {
                @Override
                public void drawImage(Graphics2D graphics, int _vpOffsX, int _vpOffsY, int _vpWidth, int _vpHeight, double scale) {
                    double sc = scale / 100d;

                    int closestLevel = (int) Math.floor(Math.log(MU_METER_PER_PIXEL_40X / MU_METER_PER_PIXEL_ANOMALY_MAPS / sc) / Math.log(2.0d));

                    closestLevel = Math.max(closestLevel, 0);
                    closestLevel = Math.min(closestLevel, overlayMipMaps.size() - 1);

                    double levelFactor = Math.pow(2.0, closestLevel) * MU_METER_PER_PIXEL_ANOMALY_MAPS / MU_METER_PER_PIXEL_40X;

                    int xAnchor = (int) Math.max(_vpOffsX / sc, 0);
                    int yAnchor = (int) Math.max(_vpOffsY / sc, 0);

                    Rectangle overlayRect = new Rectangle((int) Math.round(_vpOffsX / sc / levelFactor),
                            (int) Math.round(_vpOffsY / sc / levelFactor),
                            (int) Math.round(_vpWidth / sc / levelFactor),
                            (int) Math.round(_vpHeight / sc / levelFactor));

                    // This fills the viewport area
                    // graphics.fillRect((int) (_vpOffsX / sc), (int) (_vpOffsY / sc), (int) (_vpWidth / sc), (int) (_vpHeight / sc));

                    OrbitTiledImageIOrbitImage overlayOrbitImage = overlayMipMaps.get(closestLevel);
                    BufferedImage overlayBufferedImage = overlayOrbitImage.getAsBufferedImage(overlayRect, null);

                    // Takes the value from overlayBufferedImage & 0xFF and convert it to RGBA on the green channel
                    BufferedImage rgbaOverlay = applyColorMap(overlayBufferedImage);

                    // Scale up the read image to remap on the reference grid at 100% zoom
                    AffineTransform mapTransform = AffineTransform.getTranslateInstance(xAnchor, yAnchor);
                    mapTransform.scale(levelFactor, levelFactor);

                    graphics.drawImage(rgbaOverlay, mapTransform, null);
                }
            };
            recognitionFrame.setClassImage(tiledImageWriter);
        }
    }

    private BufferedImage applyColorMap(BufferedImage overlayBufferedImage) {
        BufferedImage rgbaOverlay = rgbaConverter.createCompatibleDestImage(overlayBufferedImage, rgbaColorModel);
        WritableRaster rgbaRaster = rgbaOverlay.getRaster();

        double lowValue = rangeBar.getLowValue() * 255.0;
        double highValue = rangeBar.getHighValue() * 255.0;

        int red = 0;
        int green = 0;
        int blue = 0;
        int alpha = 0;

        for (int y = 0; y < overlayBufferedImage.getHeight(); y++) {
            for (int x = 0; x < overlayBufferedImage.getWidth(); x++) {
                int grayInput = overlayBufferedImage.getRGB(x, y) & 0xFF;
                if (grayInput <= lowValue) {
                    green = 0;
                } else if (grayInput >= highValue) {
                    green = 255;
                } else {
                    green = (int) Math.floor(255.0 / (highValue - lowValue) * (grayInput - lowValue));
                }
                alpha = green;
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


    protected void repaintMap() {
        OrbitImageAnalysis.getInstance().getIFrame().getRecognitionFrame().repaint();
    }
//
//    protected void selectOverlayFile() {
//        JFileChooser fileChooser = new JFileChooser(prefs.get(prefsOverlayDir, "."));
//        fileChooser.setMultiSelectionEnabled(false);
//        fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
//        fileChooser.setDialogTitle("Select an image to open as overlay");
//        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//        fileChooser.setFileFilter(new FileNameExtensionFilter("Tiff files", "tiff", "tif"));
//        int res = fileChooser.showOpenDialog(null);
//        if (res == JFileChooser.APPROVE_OPTION) {
//            prefs.put(prefsOverlayDir, fileChooser.getSelectedFile().getParent());
//            String filePath = fileChooser.getSelectedFile().getPath();
//            try {
//                overlayImage = new OrbitTiledImageIOrbitImage(new OrbitImageTiff(filePath, 0));
//            } catch (Exception e) {
//                e.printStackTrace();
//                logger.error("Could not load this image as overlay");
//            }
//            overlayRefresh();
//        }
//    }

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
