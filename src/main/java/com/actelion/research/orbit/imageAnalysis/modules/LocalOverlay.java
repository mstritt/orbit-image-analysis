package com.actelion.research.orbit.imageAnalysis.modules;

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.dal.ImageProviderLocal;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImageIOrbitImage;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;

public class LocalOverlay {
    protected static final Logger logger = LoggerFactory.getLogger(AnomalyDetectionModule.class);
    private static final ImageProviderLocal localImageProvider = new ImageProviderLocal();

    // Properties are linked to the overlay instance since we want the freedom to adjust the display range differently for each file
    private final Properties props = new Properties();

    // Actual list of images from different levels of the pyramid
    private final ArrayList<OrbitTiledImageIOrbitImage> overlayMipMaps = new ArrayList<>();

    public LocalOverlay(int associatedImageWidth, String associatedRdfMd5, String overlayPath) {
        File overlayPropertiesFile = new File(getPropertiesFilePath(overlayPath));
        boolean propertiesFileExists = false;
        if (overlayPropertiesFile.exists()) {
            try {
                InputStream propertiesStream = new FileInputStream(overlayPropertiesFile.getPath());
                loadPropertiesFromStream(propertiesStream);
                propertiesFileExists = true;
            } catch (FileNotFoundException e) {
                logger.warn("Could not retrieve input stream, got exception: " + e.getMessage());
            }
        }
        if (!propertiesFileExists) {
            InputStream propertiesStream = LocalOverlay.class.getResourceAsStream("/overlay.properties");
            loadPropertiesFromStream(propertiesStream);
            props.setProperty("FilePath", overlayPath);
            props.setProperty("AssociatedImageRdfId", associatedRdfMd5);
        }

        load(overlayPath);

        if (overlayMipMaps.size() > 0){
            System.out.println("associatedImageWidth = " + associatedImageWidth);
            System.out.println("overlayMipMaps.get(0).getWidth() = " + overlayMipMaps.get(0).getWidth());
            props.setProperty("ResizeFactor", Double.toString(associatedImageWidth / (double) overlayMipMaps.get(0).getWidth()));
        }
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

    public double getResizeFactor() {
        return Double.parseDouble(props.getProperty("ResizeFactor"));
    }

    public void setResizeFactor(double value) {
        props.setProperty("ResizeFactor", Double.toString(value));
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
        return FilenameUtils.getBaseName(getFilePath());
    }

    public String getFilePath() {
        return props.getProperty("FilePath");
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

    public void resetProperties() {
        File overlayPropertiesFile = new File(getPropertiesFilePath(getFilePath()));
        if (overlayPropertiesFile.exists()) {
            try {
                logger.info("Load properties file: " + overlayPropertiesFile.getPath());
                InputStream propertiesStream = new FileInputStream(overlayPropertiesFile.getPath());
                loadPropertiesFromStream(propertiesStream);
            } catch (FileNotFoundException e) {
                logger.warn("Could not retrieve input stream, got exception: " + e.getMessage());
            }
        }
    }

    public void saveProperties() {
        String propertiesFilePath = getPropertiesFilePath(getFilePath());
        try {
            logger.info("Save properties file: " + propertiesFilePath);
            FileOutputStream outputStream = new FileOutputStream(propertiesFilePath);
            props.store(outputStream, null);
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
    }

    private String getPropertiesFilePath(String overlayPath) {
        String overlayFileNameStem = FilenameUtils.getBaseName(overlayPath);
        String overlayDir = FilenameUtils.getFullPath(overlayPath);
        return Paths.get(overlayDir, overlayFileNameStem + ".properties").toString();
    }

    private void loadPropertiesFromStream(InputStream propertiesStream) {
        try {
            props.load(propertiesStream);
        } catch (IOException e) {
            logger.warn("Could not fetch default overlay properties: " + e.getMessage());
        }
    }
}
