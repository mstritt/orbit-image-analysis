package com.actelion.research.orbit.imageAnalysis.deeplearning;

import java.awt.*;

public abstract class AbstractSegmentationSettings<S> {

    private final int imageWidth;
    private final int imageHeight;
    private final AugmentationSettings augmentationSettings;

    private final int trainingImageTileWidth;
    private final int trainingImageTileHeight;

    private final float tileScaleFactorX;
    private final float tileScaleFactorY;
    private final String annotationPrefix;

    private final boolean segmentationRefinement;

    /**
     * Setup and store the settings used for abstract segmentation model training and inference.
     * @param imageWidth The width in px of the training images.
     * @param imageHeight The height in px of the training images.
     * @param tileScaleFactorX The scale factor in x-axis that was used to generate the test dataset (e.g. if image tiles were
 *                        size 8192 px, and training images were output at 512 px, then tileScaleFactor=16.
     * @param tileScaleFactorY The scale factor in y-axis that was used to generate the test dataset (e.g. if image tiles were
*                        size 8192 px, and training images were output at 512 px, then tileScaleFactor=16.
     * @param annotationPrefix The prefix used to store annotations.
     * @param segmentationRefinement Whether or not to refine the segmentation result. e.g. to mitigate for tile boundary
     *                               effects.
     */
    public AbstractSegmentationSettings(int imageWidth, int imageHeight, float tileScaleFactorX, float tileScaleFactorY, String annotationPrefix, boolean segmentationRefinement) {
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.trainingImageTileWidth = (int) (imageWidth * tileScaleFactorX);
        this.trainingImageTileHeight = (int) (imageHeight * tileScaleFactorY);
        this.tileScaleFactorX = tileScaleFactorX;
        this.tileScaleFactorY = tileScaleFactorY;
        this.augmentationSettings = new AugmentationSettings();
        this.annotationPrefix = annotationPrefix;
        this.segmentationRefinement = segmentationRefinement;
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

    @Deprecated
    public boolean getSegmentationRefinement() {
        return true;
    }

    public int getTrainingImageTileWidth() {
        return trainingImageTileWidth;
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

    public int getTrainingImageTileHeight() {
        return trainingImageTileHeight;
    }

    public abstract String getClassName(int classNum);

    public Color getAnnotationColor(int classNum) {
        return Color.GREEN;
    }

    public boolean isSegmentationRefinement() {
        return segmentationRefinement;
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
