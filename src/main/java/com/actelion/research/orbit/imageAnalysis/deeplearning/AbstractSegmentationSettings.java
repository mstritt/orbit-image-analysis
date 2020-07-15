package com.actelion.research.orbit.imageAnalysis.deeplearning;

import org.apache.commons.io.FileUtils;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class AbstractSegmentationSettings<T> implements Serializable, Cloneable {

    private final String modelName;
    private final String remoteModelURL;
    private String modelPath;

    private final int imageWidth;
    private final int imageHeight;

    private final int trainingImageTileWidth;
    private final int trainingImageTileHeight;

    private final float tileScaleFactorX;
    private final float tileScaleFactorY;
    private final String annotationPrefix;

    private final boolean segmentationRefinement;
    protected final double detectionToleranceScale;

    /**
     * Setup and store the settings used for abstract segmentation model training and inference.
     * @param remoteModelURL
     * @param modelPath
     * @param imageWidth The width in px of the training images.
     * @param imageHeight The height in px of the training images.
     * @param tileScaleFactorX The scale factor in x-axis that was used to generate the test dataset (e.g. if image tiles were
*                        size 8192 px, and training images were output at 512 px, then tileScaleFactor=16.
     * @param tileScaleFactorY The scale factor in y-axis that was used to generate the test dataset (e.g. if image tiles were
*                        size 8192 px, and training images were output at 512 px, then tileScaleFactor=16.
     * @param annotationPrefix The prefix used to store annotations.
     * @param segmentationRefinement Whether or not to refine the segmentation result. e.g. to mitigate for tile boundary
     */
    public AbstractSegmentationSettings(String modelName, String remoteModelURL, String modelPath, int imageWidth, int imageHeight, float tileScaleFactorX, float tileScaleFactorY, String annotationPrefix, boolean segmentationRefinement, double detectionToleranceScale) {
        this.modelName = modelName;
        this.remoteModelURL = remoteModelURL;
        if (remoteModelURL != null) {
            try {
                this.modelPath = cacheRemoteModel();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            this.modelPath = modelPath;
        }
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.trainingImageTileWidth = (int) (imageWidth * tileScaleFactorX);
        this.trainingImageTileHeight = (int) (imageHeight * tileScaleFactorY);
        this.tileScaleFactorX = tileScaleFactorX;
        this.tileScaleFactorY = tileScaleFactorY;
        this.annotationPrefix = annotationPrefix;
        this.segmentationRefinement = segmentationRefinement;
        this.detectionToleranceScale = detectionToleranceScale;
    }

    public String getModelName() {
        return modelName;
    }

    public String cacheRemoteModel() throws IOException {
        File modelFile = File.createTempFile("orbit-dl-model", modelName);
        return modelFile.getPath();
    }

    /**
     * Get the path to the DL model used for segmentation.
     * @return Path to DL model for segmentation.
     */
    public Path getModelPath() {
        File modelFile = new File(modelPath);
        if (!modelFile.exists()) {
            try {
                FileUtils.copyURLToFile(new URL(remoteModelURL), modelFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Paths.get(modelPath);
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    @Deprecated
    public boolean getSegmentationRefinement() {
        return true;
    }

    public int getTrainingImageTileWidth() {
        return trainingImageTileWidth;
    }

    public int getTrainingImageTileHeight() {
        return trainingImageTileHeight;
    }

    @Deprecated
    public float getTileScaleFactor() throws Exception {
        if (tileScaleFactorX == tileScaleFactorY) {
            return tileScaleFactorX;
        } else {
            throw new Exception("Tiles have different scales in X and Y.");
        }
    }

    public float getTileScaleFactorX() {
        return tileScaleFactorX;
    }

    public float getTileScaleFactorY() {
        return tileScaleFactorY;
    }

    @Deprecated
    public double getTileScaleFactorPercent() throws Exception {
        if (tileScaleFactorX == tileScaleFactorY) {
            return tileScaleFactorX;
        } else {
            throw new Exception("Tiles have different scales in X and Y.");
        }
    }

    public double getTileScaleFactorXPercent() {
        return tileScaleFactorX * 100.0d;
    }

    public double getTileScaleFactorYPercent() {
        return tileScaleFactorY * 100.0d;
    }

    /**
     * Used when storing the annotations to DB.
     * @return Annotation prefix to use when storing annotations.
     */
    public String getAnnotationPrefix() {
        return annotationPrefix;
    }

    public abstract String getClassName(int classNum);

    public Color getAnnotationColor(int classNum) {
        return Color.GREEN;
    }

    public boolean isSegmentationRefinement() {
        return segmentationRefinement;
    }

    public double getDetectionToleranceScale() {
        return detectionToleranceScale;
    }

    // Generic image augmentation settings
    public boolean getDeconvolution() {
        return false;
    }

    public String getDeconvolutionName() {
        return "H DAB";
    }

    public int getDeconvolutionChannel() {
        return 1;
    }

    @Override
    public String toString() {
        return this.modelName;
    }
}
