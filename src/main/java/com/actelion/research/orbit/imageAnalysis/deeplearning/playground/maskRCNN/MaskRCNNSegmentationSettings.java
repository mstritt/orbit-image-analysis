package com.actelion.research.orbit.imageAnalysis.deeplearning.playground.maskRCNN;

import java.awt.*;
import java.io.InvalidObjectException;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MaskRCNNSegmentationSettings extends AbstractSegmentationSettings {

    private final int maxDetections;
    private final int maskWidth;
    private final int maskHeight;
    private final int numClasses;

    private static final float[] meanPixel = new float[]{170.20611747f, 172.00450216f, 177.19215462f};

    private final HashMap<Integer, Color> defaultAnnotationClassColours = new HashMap<>();
    private final HashMap<Integer, String> defaultAnnotationClassNames = new HashMap<>();

    private final HashMap<Integer, Color> customAnnotationClassColours = new HashMap<>();
    private final HashMap<Integer, String> customAnnotationClassNames = new HashMap<>();


    /**
     * Setup and store the settings used for MaskRCNN training and inference.
     * @param imageWidth The width in px of the training images.
     * @param imageHeight The height in px of the training images.
     * @param tileScaleFactor The scale factor that was used to generate the test dataset (e.g. if image tiles were
     *                        size 8192 px, and training images were output at 512 px, then tileScaleFactor=16.
     * @param maxDetections The maximum number of predictions to return.
     * @param maskWidth The width of the mask used to train the model (px).
     * @param maskHeight The height of the mask used to train the model (px).
     * @param numClasses The number of classes in the trained model (Background + other classes).
     *                   e.g. for classes: Background, g0, g1, g2, g3 -> numClasses = 5.
     */
    public MaskRCNNSegmentationSettings(int imageWidth, int imageHeight, float tileScaleFactor, int maxDetections,
                                        int maskWidth, int maskHeight, int numClasses, String annotationPrefix) {
        super(imageWidth, imageHeight, tileScaleFactor, annotationPrefix);
        this.maxDetections = maxDetections;
        this.maskWidth = maskWidth;
        this.maskHeight = maskHeight;
        this.numClasses = numClasses;

        // Set annotation colours
        generateClassNames(numClasses);

    }

    public void setCustomClassNames(List<Color> colors, List<String> labels) throws Exception {
        if (colors.size() != labels.size()) {
            throw new Exception("Arrays are differing sizes, colors and labels must be equal length.");
        }
        int i = 0;
        for (Color color: colors) {
            customAnnotationClassColours.put(i, color);
            i++;
        }
        int j=0;
        for (String classLabel: labels) {
            customAnnotationClassNames.put(j, classLabel);
            j++;
        }
    }

    private void generateClassNames(int numClasses) {
        ArrayList<Color> defaultColors = new ArrayList<>(Arrays.asList(Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN, Color.MAGENTA, Color.PINK));


        if (numClasses == 2) {
            defaultAnnotationClassColours.put(0, Color.BLACK); // Background
            defaultAnnotationClassColours.put(1, Color.YELLOW); // Foreground

            defaultAnnotationClassNames.put(0, "Background");
            defaultAnnotationClassNames.put(1, "Foreground");
        } else {
            Random rand = new Random();
            if (defaultColors.size() < numClasses) {
                while (defaultColors.size() < numClasses) {
                    defaultColors.add(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                }
            }

            ArrayList<String> defaultNames = new ArrayList<>();
            defaultNames.add("Background");
            for (int i = 1; i < numClasses; i++) {
                defaultNames.add(String.format("Object Type %s", i));
            }


            for (int i = 0; i < numClasses; i++) {
                defaultAnnotationClassColours.put(i, defaultColors.get(i)); // Background
                defaultAnnotationClassNames.put(i, defaultNames.get(i));
            }
        }
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
        if (customAnnotationClassColours.size() == 0) {
            return defaultAnnotationClassColours.get(classNum);
        } else {
            return customAnnotationClassColours.get(classNum);
        }
    }

    @Override
    public String getClassName(int classNum) {
        if (customAnnotationClassColours.size() == 0) {
            return defaultAnnotationClassNames.get(classNum);
        } else {
            return customAnnotationClassNames.get(classNum);
        }
    }
}
