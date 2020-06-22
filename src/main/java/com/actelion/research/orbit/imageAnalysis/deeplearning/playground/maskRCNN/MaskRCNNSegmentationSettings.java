package com.actelion.research.orbit.imageAnalysis.deeplearning.playground.maskRCNN;

import java.awt.*;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class MaskRCNNSegmentationSettings extends AbstractSegmentationSettings {

    private final int maxDetections;
    private final int maskWidth;
    private final int maskHeight;
    private final int numClasses;

    private static final float[] meanPixel = new float[]{170.20611747f, 172.00450216f, 177.19215462f};

    private final AtomicReference<HashMap<Integer, Color>> defaultAnnotationClassColours = new AtomicReference<>(new HashMap<>());
    private final AtomicReference<HashMap<Integer, String>> defaultAnnotationClassNames = new AtomicReference<>(new HashMap<>());

    /**
     * Setup and store the settings used for MaskRCNN training and inference.
     * @param imageWidth The width in px of the training images.
     * @param imageHeight The height in px of the training images.
     * @param tileScaleFactor The scale factor that was used to generate the test dataset (e.g. if image tiles were
     *                        size 8192 px, and training images were output at 512 px, then tileScaleFactor=16.
     * @param maxDetections The maximum number of predictions to return.
     * @param maskWidth The width of the mask used to train the model (px).
     * @param maskHeight The height of the mask used to train the model (px).
     * @param numClasses The number of classes in the trained model.
     */
    public MaskRCNNSegmentationSettings(int imageWidth, int imageHeight, float tileScaleFactor, int maxDetections, int maskWidth, int maskHeight, int numClasses) {
        super(imageWidth, imageHeight, tileScaleFactor);
        this.maxDetections = maxDetections;
        this.maskWidth = maskWidth;
        this.maskHeight = maskHeight;
        this.numClasses = numClasses;

        // Set annotation colours
        // TODO: Configurable number of colours.
        defaultAnnotationClassColours.get().put(1, Color.BLACK); // Background
        defaultAnnotationClassColours.get().put(2, Color.RED); // First class
        defaultAnnotationClassColours.get().put(3, Color.GREEN);
        defaultAnnotationClassColours.get().put(4, Color.BLUE);
        defaultAnnotationClassColours.get().put(5, Color.YELLOW);

        defaultAnnotationClassNames.get().put(1, "Background");
        defaultAnnotationClassNames.get().put(2, "g0");
        defaultAnnotationClassNames.get().put(3, "g1");
        defaultAnnotationClassNames.get().put(4, "g2");
        defaultAnnotationClassNames.get().put(5, "g3");

    }

    public int getMaxDetections() {
        return maxDetections;
    }

    public int getMaskWidth() {
        return maskWidth;
    }

    public int getMaskHeight() {
        return maskHeight;
    }

    public int getNumClasses() {
        return numClasses;
    }

    /**
     * The mean pixel value for the training dataset.
     * @return r,g,b values in range 0.0-255.0 for the mean pixel intensity of the training dataset.
     */
    public float[] getMeanPixel() {
        return meanPixel;
    }

    @Override
    public Color getAnnotationColor(int classNum) {
        return defaultAnnotationClassColours.get().get(classNum);
    }

    @Override
    public String getClassName(int classNum) { return defaultAnnotationClassNames.get().get(classNum); }

}
