package com.actelion.research.orbit.imageAnalysis.modules;

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.dal.ImageProviderLocal;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImageIOrbitImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Properties;

public class LocalOverlay {
    protected static final Logger logger = LoggerFactory.getLogger(AnomalyDetectionModule.class);
    private static final ImageProviderLocal localImageProvider = new ImageProviderLocal();

    // Properties are linked to the overlay instance since we want the freedom to adjust the display range differently for each file
    private final Properties props = new Properties();

    // Actual list of images from different levels of the pyramid
    private final ArrayList<OrbitTiledImageIOrbitImage> overlayMipMaps = new ArrayList<OrbitTiledImageIOrbitImage>();

    public LocalOverlay(String associatedImageRdfId, String overlayPath) {
        InputStream propertiesStream = LocalOverlay.class.getResourceAsStream("/overlay.properties");
        try {
            props.load(propertiesStream);
        } catch (IOException e) {
            logger.warn("Could not fetch default overlay properties: " + e.getMessage());
        }
        props.setProperty("FilePath", overlayPath);
        props.setProperty("AssociatedImageRdfId", associatedImageRdfId);

        load(overlayPath);
    }

    public void load(String overlayTifPath) {
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
    }

    public OrbitTiledImageIOrbitImage getImageAtLevel(int level) {
        return overlayMipMaps.get(level);
    }

    public int getNumberOfLevels() {
        return overlayMipMaps.size();
    }

    public double getPixelSize() {
        return Double.parseDouble(props.getProperty("PixelSize"));
    }

    public void setPixelSize(double value) {
        props.setProperty("PixelSize", Double.toString(value));
    }

    public double getDisplayRangeMin() {
        return Double.parseDouble(props.getProperty("DisplayRangeMin"));
    }

    public void setDisplayRangeMin(double value) {
        props.setProperty("DisplayRangeMin", Double.toString(value));
    }

    public double getDisplayRangeMax() {
        return Double.parseDouble(props.getProperty("DisplayRangeMax"));
    }

    public void setDisplayRangeMax(double value) {
        props.setProperty("DisplayRangeMax", Double.toString(value));
    }

    public String getFileName() {
        String filePathStr = getFilePath();
        Path filePath = Path.of(filePathStr);
        return filePath.getFileName().toString();
    }

    public String getFilePath() {
        return props.getProperty("FilePath");
    }

    public String getAssociatedImageRdfId() {
        return props.getProperty("AssociatedImageRdfId");
    }

    public String getAlphaMode() {
        return props.getProperty("AlphaMode");
    }

    public void setAlphaMode(String alphaMode) {
        props.setProperty("AlphaMode", alphaMode);
    }

    public Color getOverlayColor() {
        return Color.decode(props.getProperty("OverlayColor"));
    }

    public void setOverlayColor(Color color) {
        props.setProperty("OverlayColor", String.format("#%06x", color.getRGB() & 0x00FFFFFF));
    }
}
