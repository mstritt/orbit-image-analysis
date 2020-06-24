package com.actelion.research.orbit.imageAnalysis.deeplearning.playground.maskRCNN;

import java.awt.*;

public abstract class AbstractSegmentationSettings {

    private final int imageWidth;
    private final int imageHeight;
    private final AugmentationSettings augmentationSettings;

    private final int trainingImageTileWidth;
    private final int trainingImageTileHeight;

    private final float tileScaleFactor;
    private final String annotationPrefix;

    /**
     * Setup and store the settings used for abstract segmentation model training and inference.
     * @param imageWidth The width in px of the training images.
     * @param imageHeight The height in px of the training images.
     * @param tileScaleFactor The scale factor that was used to generate the test dataset (e.g. if image tiles were
     *                        size 8192 px, and training images were output at 512 px, then tileScaleFactor=16.
     * @param annotationPrefix The prefix used to store annotations.
     */
    public AbstractSegmentationSettings(int imageWidth, int imageHeight, float tileScaleFactor, String annotationPrefix) {
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.trainingImageTileWidth = (int) (imageWidth * tileScaleFactor);
        this.trainingImageTileHeight = (int) (imageHeight * tileScaleFactor);
        this.tileScaleFactor = tileScaleFactor;
        this.augmentationSettings = new AugmentationSettings();
        this.annotationPrefix = annotationPrefix;
    }

    /**
     * Return the annotation prefix to use when storing annotations.
     */
    public String getAnnotationPrefix() {
        return annotationPrefix;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
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

    // TODO: Remove this.
    @Deprecated
    public boolean getSegmentationRefinement() {
        return true;
    }

    public int getTrainingImageTileWidth() {
        return trainingImageTileWidth;
    }

    public float getTileScaleFactor() {
        return tileScaleFactor;
    }

    public double getTileScaleFactorPercent() {
        return tileScaleFactor * 100.0d;
    }

    public int getTrainingImageTileHeight() {
        return trainingImageTileHeight;
    }

    public abstract String getClassName(int classNum);

    public Color getAnnotationColor(int classNum) {
        return Color.GREEN;
    }

    public AugmentationSettings getAugmentationSettings() {
        return augmentationSettings;
    }

    public static class AugmentationSettings {

        AugmentationSettings() {

        }

        public boolean getFlip() {
            return true;
        }

        public int getScaleFactor() {
            return 2;
        }
    }
}
