package com.actelion.research.orbit.imageAnalysis.test.deeplearning.playground.maskRCNN;

import com.actelion.research.orbit.imageAnalysis.deeplearning.DLSegment;
import com.actelion.research.orbit.imageAnalysis.deeplearning.playground.maskRCNN.*;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import org.junit.Test;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlow;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class TestInsulinSegment {


    @Test
    public void testSessionLoad() {
        Session s = DLSegment.buildSession("D:/insulin/models/insulin_009.pb");
        assertNotNull(s);
        s.close();
    }

    @Test
    public void testSegmentation() throws Exception {
        File INPUT_IMAGE = new File("D:/insulin/testdata/12886016_tile19x4.jpg");
        File OUTPUT_IMAGE = new File("D:/insulin/testdata/12886016_tile19x4-output.jpg");

//        int maskWidth = 56;
//        int maskHeight = 56;
//        int size = 512;
//        int MAX_DETECTIONS = 10;
        MaskRCNNSegment segmentationModel = new MaskRCNNSegment();


        OrbitModel segModel = OrbitModel.LoadFromInputStream(
                this.getClass().getResourceAsStream("/resource/testmodels/dlsegmentsplit.omo"));
        assertNotNull(segModel);

        System.out.println("using Tensorflow "+ TensorFlow.version());

        Date startDate = new Date();
        //MRCNNPancreasIslets maskRCNN = new MRCNNPancreasIslets();

        BufferedImage originalImage = ImageIO.read(INPUT_IMAGE);
        long startt = System.currentTimeMillis();
        Tensor<Float> input = DLHelpers.convertBufferedImageToTensor(originalImage, segmentationModel.getSegmentationSettings().getImageWidth(), segmentationModel.getSegmentationSettings().getImageHeight());

        RawDetections rawDetections = segmentationModel.getMaskRCNNRawDetections(input);
        MaskRCNNDetections detections = segmentationModel.processDetections(segmentationModel.getSegmentationSettings().getImageWidth(), segmentationModel.getSegmentationSettings().getImageHeight(),rawDetections);
        BufferedImage outputImage = segmentationModel.augmentDetections(originalImage, detections);
        ImageIO.write(outputImage, "png", OUTPUT_IMAGE);

        // TODO: Check that a certain number of pixels are identical

        long used = System.currentTimeMillis()-startt;
        System.out.println("time used: "+used/1000d);

        long elapsedTimeInSec = (new Date().getTime() - startDate.getTime()) / 1000;
        System.out.println(String.format("Ended in %ds.", elapsedTimeInSec));
    }

    @Test
    public void testSegmentationAnnotations() {
        //int[] images = {12885943}; // either orbitIDs or load via query // 1318936, 1318968
        int[] images = {12886016};
        boolean storeAnnotations = true;

        MaskRCNNSegment segmentationModel = new MaskRCNNSegment();

        //Session s = DLSegment.buildSession("D:/insulin/models/insulin_009.pb");

        OrbitModel segModel = OrbitModel.LoadFromInputStream(
                this.getClass().getResourceAsStream("/resource/testmodels/dlsegmentsplit.omo"));
        assertNotNull(segModel);

        // Don't use an exclusion model.
        OrbitModel modelContainingExclusionModel = null;

        // Time execution.
        Date startDate = new Date();
        long startt = System.currentTimeMillis();

        // Apply the MaskRCNN segmentation models to a list of images.
        Map<Integer, List<Shape>> segmentationsPerImage = segmentationModel.generateSegmentationAnnotations(
                images, segModel, modelContainingExclusionModel, storeAnnotations);
        long used = System.currentTimeMillis()-startt;

        System.out.println("time used: "+used/1000d);

        long elapsedTimeInSec = (new Date().getTime() - startDate.getTime()) / 1000;
        System.out.println(String.format("Ended in %ds .", elapsedTimeInSec));

        for (int annoNum: segmentationsPerImage.keySet()){
            System.out.println("Image "+annoNum+": number of objects segmented: "+segmentationsPerImage.get(annoNum).size());
        }
    }

}

