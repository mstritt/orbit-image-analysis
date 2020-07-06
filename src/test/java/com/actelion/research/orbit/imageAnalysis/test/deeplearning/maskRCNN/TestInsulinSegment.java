package com.actelion.research.orbit.imageAnalysis.test.deeplearning.maskRCNN;

import com.actelion.research.orbit.imageAnalysis.deeplearning.DLSegment;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNDetections;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNSegment;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNSegmentationSettings;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNRawDetections;
import com.actelion.research.orbit.imageAnalysis.deeplearning.DLHelpers;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import org.junit.Ignore;
import org.junit.Test;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlow;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestInsulinSegment {


    @Test
    public void testSessionLoad() {
        Session s = DLSegment.buildSession("D:/insulin/models/insulin_009.pb");
        assertNotNull(s);
        s.close();
    }

    // Marked as ignore since uses local files for testing (not currently available Open Source).
    @Test
    @Ignore
    public void testSegmentation() throws Exception {
        File INPUT_IMAGE = new File("D:/deeplearning/insulin/testdata/12886016_tile19x4.jpg");
        File OUTPUT_IMAGE = new File("D:/deeplearning/insulin/testdata/12886016_tile19x4-output.jpg");
        File maskRCNNModel = new File("D:/deeplearning/insulin/models/insulin_009.pb");

        MaskRCNNSegment segmentationModel = new MaskRCNNSegment(maskRCNNModel, MaskRCNNSegment.PostProcessMethod.STANDARD);

        OrbitModel segModel = OrbitModel.LoadFromInputStream(
                this.getClass().getResourceAsStream("/resource/testmodels/dlsegmentsplit.omo"));
        assertNotNull(segModel);

        System.out.println("using Tensorflow "+ TensorFlow.version());

        Date startDate = new Date();

        BufferedImage originalImage = ImageIO.read(INPUT_IMAGE);
        long startt = System.currentTimeMillis();
        Tensor<Float> input = DLHelpers.convertBufferedImageToTensor(originalImage, segmentationModel.getSegmentationSettings().getImageWidth(), segmentationModel.getSegmentationSettings().getImageHeight());

        MaskRCNNRawDetections rawDetections = segmentationModel.getMaskRCNNRawDetections(input);
        MaskRCNNDetections detections = segmentationModel.processDetections(segmentationModel.getSegmentationSettings().getImageWidth(), segmentationModel.getSegmentationSettings().getImageHeight(),rawDetections);

        BufferedImage outputImage = DLHelpers.detectionToImage(originalImage, detections.getBoundingBoxes(),
                detections.getContours(), detections.getDetectionClasses(),
                segmentationModel.getSegmentationSettings(), false, true);

        ImageIO.write(outputImage, "png", OUTPUT_IMAGE);

        // TODO: Check that a certain number of pixels are identical

        long used = System.currentTimeMillis()-startt;
        System.out.println("time used: "+used/1000d);

        long elapsedTimeInSec = (new Date().getTime() - startDate.getTime()) / 1000;
        System.out.println(String.format("Ended in %ds.", elapsedTimeInSec));
    }

    @Test
    public void testSegmentationAnnotationsCustom() throws Exception {
        int[] images = {12885943}; // either orbitIDs or load via query // 1318936, 1318968
        //int[] images = {12886016};

        // To test only one tile, set a value here.
        Point tile = new Point(4, 3);

        boolean storeAnnotations = false;
        File maskRCNNModel = new File("D:/deeplearning/insulin/models/insulin_009.pb");

        MaskRCNNSegmentationSettings settings = new MaskRCNNSegmentationSettings(512, 512, 16f, 10, 56, 56, 5, "IsletC");
        ArrayList<Color> colors = new ArrayList<>(Arrays.asList(Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW));
        ArrayList<String> classNames = new ArrayList<>(Arrays.asList("Background", "g0", "g1", "g2", "g3"));
        settings.setCustomClassNames(colors, classNames);
        MaskRCNNSegment segmentationModel = new MaskRCNNSegment(maskRCNNModel, MaskRCNNSegment.PostProcessMethod.CUSTOM, settings);

        OrbitModel segModel = OrbitModel.LoadFromInputStream(
                this.getClass().getResourceAsStream("/resource/testmodels/dlsegmentsplit.omo"));
        assertNotNull(segModel);

        // Don't use an exclusion model.
        OrbitModel modelContainingExclusionModel = null;
        try {
            // Load an exclusion model.
            modelContainingExclusionModel = OrbitModel.LoadFromOrbit(2462612);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Time execution.
        Date startDate = new Date();
        long startt = System.currentTimeMillis();

        // Apply the MaskRCNN segmentation models to a list of images.
        // TODO: Check whether need to pass the settings object...
        Map<Integer, List<Shape>> segmentationsPerImage = segmentationModel.generateSegmentationAnnotations(
                images, segModel, modelContainingExclusionModel, tile, storeAnnotations);
        long used = System.currentTimeMillis()-startt;

        System.out.println("time used: "+used/1000d);

        long elapsedTimeInSec = (new Date().getTime() - startDate.getTime()) / 1000;
        System.out.println(String.format("Ended in %ds .", elapsedTimeInSec));

        for (int annoNum: segmentationsPerImage.keySet()){
            System.out.println("Image "+annoNum+": number of objects segmented: "+segmentationsPerImage.get(annoNum).size());
        }

        // There should be 2 objects detected in the test tile.
        assertEquals(segmentationsPerImage.get(images[0]).size(), 3);
        // Check the bounding box for the first image (should confirm that the scaling and translation has been done correctly).
        assertEquals(segmentationsPerImage.get(images[0]).get(0).getBounds(),new Rectangle(36368,31680, 992, 960));
    }

    @Test
    public void testSegmentationAnnotationsStandard() throws Exception {
        int[] images = {12885943};

        // To test only one tile, set a value here.
        Point tile = new Point(4, 3);

        boolean storeAnnotations = false;
        File maskRCNNModel = new File("D:/deeplearning/insulin/models/insulin_009.pb");

        MaskRCNNSegmentationSettings settings = new MaskRCNNSegmentationSettings(512, 512, 16f, 10, 56, 56, 5, "IsletS");
        ArrayList<Color> colors = new ArrayList<>(Arrays.asList(Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW));
        ArrayList<String> classNames = new ArrayList<>(Arrays.asList("Background", "g0", "g1", "g2", "g3"));
        settings.setCustomClassNames(colors, classNames);
        MaskRCNNSegment segmentationModel = new MaskRCNNSegment(maskRCNNModel, MaskRCNNSegment.PostProcessMethod.STANDARD, settings);

        OrbitModel segModel = OrbitModel.LoadFromInputStream(
                this.getClass().getResourceAsStream("/resource/testmodels/dlsegmentsplit.omo"));
        assertNotNull(segModel);

        // Don't use an exclusion model.
        OrbitModel modelContainingExclusionModel = null;
        try {
            // Load an exclusion model.
            modelContainingExclusionModel = OrbitModel.LoadFromOrbit(2462612);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Time execution.
        Date startDate = new Date();
        long startt = System.currentTimeMillis();

        // Apply the MaskRCNN segmentation models to a list of images.
        Map<Integer, List<Shape>> segmentationsPerImage = segmentationModel.generateSegmentationAnnotations(
                images, segModel, modelContainingExclusionModel, tile, storeAnnotations);
        long used = System.currentTimeMillis()-startt;

        System.out.println("time used: "+used/1000d);

        long elapsedTimeInSec = (new Date().getTime() - startDate.getTime()) / 1000;
        System.out.println(String.format("Ended in %ds .", elapsedTimeInSec));

        for (int annoNum: segmentationsPerImage.keySet()){
            System.out.println("Image "+annoNum+": number of objects segmented: "+segmentationsPerImage.get(annoNum).size());
        }

        // There should be 2 objects detected in the test tile.
        assertEquals(segmentationsPerImage.get(images[0]).size(), 2);
        // Check the bounding box for the first image (should confirm that the scaling and translation has been done correctly).
        assertEquals(segmentationsPerImage.get(images[0]).get(0).getBounds(),new Rectangle(34256,29136, 192, 176));
    }

}

