package com.actelion.research.orbit.imageAnalysis.test.deeplearning.DeepLabV2Resnet101;

import com.actelion.research.orbit.imageAnalysis.deeplearning.DLHelpers;
import com.actelion.research.orbit.imageAnalysis.deeplearning.DeepLabV2Resnet101.DLR101Detections;
import com.actelion.research.orbit.imageAnalysis.deeplearning.DeepLabV2Resnet101.DLR101Segment;
import com.actelion.research.orbit.imageAnalysis.deeplearning.DeepLabV2Resnet101.DLR101SegmentationSettings;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNSegment;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNSegmentationSettings;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import org.junit.jupiter.api.Test;
import org.tensorflow.Tensor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestGlomeruliSegment {

    @Test
    void testGlomeruliSegment() {
        // no annotations for this image.
//        int[] images = {6991411};

        // part of the 'test' dataset.
        //int[] images = {4758050}; // 5482449

        // An older model for comparison.
        File dLR101GlomeruliModel = new File("D:/deeplearning/glomeruli/20180202_glomeruli_detection_noquant.pb");
//        File dLR101GlomeruliModel = new File("D:/deeplearning/glomeruli/glomeruli-410k.pb");

        DLR101SegmentationSettings glomeruliSettings = new DLR101SegmentationSettings(512, 512, 1, "Glomeruli");

        DLR101Segment glomeruliModel = new DLR101Segment(dLR101GlomeruliModel, glomeruliSettings);

        BufferedImage sourceImage = null;
        Tensor<Float> inputTensor = null;
        try {
            sourceImage = ImageIO.read(new File("D:/deeplearning/glomeruli/test2.png"));
            BufferedImage bi1 = new BufferedImage(1024,1024,BufferedImage.TYPE_INT_RGB);
            bi1.getGraphics().drawImage(sourceImage,0,0,null);
            BufferedImage bi2 = new BufferedImage(512,512,BufferedImage.TYPE_INT_RGB);
            bi2.getGraphics().drawImage(bi1,0,0,512,512,null);
            sourceImage = bi2;
            inputTensor = DLR101Segment.convertBufferedImageToTensor(sourceImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DLR101Detections detections = glomeruliModel.getDLR101RawDetections(inputTensor);
        BufferedImage bim = glomeruliModel.decodeLabels(detections.getResult());
        bim.getWidth();
        try {
            ImageIO.write(bim, "jpg", new File("D:/deeplearning/glomeruli/test2.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        

//        // Time execution.
//        Date startDate = new Date();
//        long startt = System.currentTimeMillis();
//
//        Map<Integer, List<Shape>> segmentationsPerImage = glomeruliModel.generateSegmentationAnnotations(
//                images, null, null, false);
//
//        long used = System.currentTimeMillis()-startt;
//
//        System.out.println("time used: "+used/1000d);
//
//        long elapsedTimeInSec = (new Date().getTime() - startDate.getTime()) / 1000;
//        System.out.println(String.format("Ended in %ds .", elapsedTimeInSec));
//
//        for (int annoNum: segmentationsPerImage.keySet()){
//            System.out.println("Image "+annoNum+": number of Glomeruli segmented: "+segmentationsPerImage.get(annoNum).size());
//        }
//
//        // There should be 44 objects detected in the test image: D:\deeplearning\deepretina\training-data\stage1_test\0a849e0eb15faa8a6d7329c3dd66aabe9a294cccb52ed30a90c8ca99092ae732\images\0a849e0eb15faa8a6d7329c3dd66aabe9a294cccb52ed30a90c8ca99092ae732.png
//        assertEquals(segmentationsPerImage.get(images[0]).size(), 44);
//        // Check the bounding box for the first image (should confirm that the scaling and translation has been done correctly).
//        assertEquals(segmentationsPerImage.get(images[0]).get(0).getBounds(),new Rectangle(105,110, 19, 22));

    }

    @Test
    void testGlomeruliNDPISegment() {
        int[] images = {4758050};

        // To test only one tile, set a value here.
//        Point tile = new Point(4, 3);

        boolean storeAnnotations = false;
        File dLR101GlomeruliModel = new File("D:/deeplearning/glomeruli/20180202_glomeruli_detection_noquant.pb");

        DLR101SegmentationSettings glomeruliSettings = new DLR101SegmentationSettings(512, 512, 2, "Glomeruli");
//        ArrayList<Color> colors = new ArrayList<>(Arrays.asList(Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW));
//        ArrayList<String> classNames = new ArrayList<>(Arrays.asList("Background", "g0", "g1", "g2", "g3"));
//        settings.setCustomClassNames(colors, classNames);
        DLR101Segment glomeruliModel = new DLR101Segment(dLR101GlomeruliModel, glomeruliSettings);

        OrbitModel segModel = OrbitModel.LoadFromInputStream(
                this.getClass().getResourceAsStream("/resource/testmodels/dlsegmentsplit.omo"));
        assertNotNull(segModel);

        // Don't use an exclusion model.
        OrbitModel modelContainingExclusionModel = null;
//        try {
//            // Load an exclusion model.
//            modelContainingExclusionModel = OrbitModel.LoadFromOrbit(2462612);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // Time execution.
        Date startDate = new Date();
        long startt = System.currentTimeMillis();

        // Apply the MaskRCNN segmentation models to a list of images.
        Map<Integer, List<Shape>> segmentationsPerImage = glomeruliModel.generateSegmentationAnnotations(
                images, segModel, modelContainingExclusionModel, null, storeAnnotations);
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
