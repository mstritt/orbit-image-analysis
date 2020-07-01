package com.actelion.research.orbit.imageAnalysis.test.deeplearning.maskRCNN;

import com.actelion.research.orbit.imageAnalysis.deeplearning.DLSegment;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNSegment;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNSegmentationSettings;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import org.junit.Test;
import org.tensorflow.Session;

import java.awt.*;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Apply a method published as part of: https://www.kaggle.com/c/data-science-bowl-2018
 * 3rd place solution: https://github.com/Lopezurrutia/DSB_2018
 * Models can be found here: http://www.orbit.bio/deep-learning-models/
 * Train/test data can be found here: https://data.broadinstitute.org/bbbc/BBBC038/
 */
public class TestDeepRetinaSegment {

    @Test
    public void testSessionLoad() {
        Session s = DLSegment.buildSession("D:/deeplearning/deepretina/deepretina_final.pb");
        assertNotNull(s);
        s.close();
    }

    @Test
    public void testSegmentationAnnotationsCustom() {
        int[] images = {19339831};

        File maskRCNNModel = new File("D:/deeplearning/deepretina/deepretina_final.pb");

        MaskRCNNSegmentationSettings settings = new MaskRCNNSegmentationSettings(512, 512, 0.5f, 512, 28, 28, 2, "NucleiC");
        MaskRCNNSegment segmentationModel = new MaskRCNNSegment(maskRCNNModel, MaskRCNNSegment.PostProcessMethod.CUSTOM, settings);

        // Time execution.
        Date startDate = new Date();
        long startt = System.currentTimeMillis();

        // Apply the MaskRCNN segmentation models to a list of images.
        Map<Integer, List<Shape>> segmentationsPerImage = segmentationModel.generateSegmentationAnnotations(
                images, null, null, true);

        long used = System.currentTimeMillis()-startt;

        System.out.println("time used: "+used/1000d);

        long elapsedTimeInSec = (new Date().getTime() - startDate.getTime()) / 1000;
        System.out.println(String.format("Ended in %ds .", elapsedTimeInSec));

        for (int annoNum: segmentationsPerImage.keySet()){
            System.out.println("Image "+annoNum+": number of objects segmented: "+segmentationsPerImage.get(annoNum).size());
        }

        // There should be 44 objects detected in the test image: D:\deeplearning\deepretina\training-data\stage1_test\0a849e0eb15faa8a6d7329c3dd66aabe9a294cccb52ed30a90c8ca99092ae732\images\0a849e0eb15faa8a6d7329c3dd66aabe9a294cccb52ed30a90c8ca99092ae732.png
        assertEquals(segmentationsPerImage.get(images[0]).size(), 44);
        // Check the bounding box for the first image (should confirm that the scaling and translation has been done correctly).
        assertEquals(segmentationsPerImage.get(images[0]).get(0).getBounds(),new Rectangle(105,110, 19, 22));
    }

    @Test
    public void testSegmentationAnnotationsStandard() {
        int[] images = {19339831};

        File maskRCNNModel = new File("D:/deeplearning/deepretina/deepretina_final.pb");

        OrbitModel segModel = OrbitModel.LoadFromInputStream(
                this.getClass().getResourceAsStream("/resource/testmodels/dlsegmentsplit.omo"));
        assertNotNull(segModel);

        MaskRCNNSegmentationSettings settings = new MaskRCNNSegmentationSettings(512, 512, 0.5f, 512, 28, 28, 2, "NucleiS");
        MaskRCNNSegment segmentationModel = new MaskRCNNSegment(maskRCNNModel, MaskRCNNSegment.PostProcessMethod.STANDARD, settings);

        // Time execution.
        Date startDate = new Date();
        long startt = System.currentTimeMillis();

        // Apply the MaskRCNN segmentation models to a list of images.
        Map<Integer, List<Shape>> segmentationsPerImage = segmentationModel.generateSegmentationAnnotations(
                images, segModel, null, true);

        long used = System.currentTimeMillis()-startt;

        System.out.println("time used: "+used/1000d);

        long elapsedTimeInSec = (new Date().getTime() - startDate.getTime()) / 1000;
        System.out.println(String.format("Ended in %ds .", elapsedTimeInSec));

        for (int annoNum: segmentationsPerImage.keySet()){
            System.out.println("Image "+annoNum+": number of objects segmented: "+segmentationsPerImage.get(annoNum).size());
        }

        // There should be 39 objects detected in the test image: D:\deeplearning\deepretina\training-data\stage1_test\0a849e0eb15faa8a6d7329c3dd66aabe9a294cccb52ed30a90c8ca99092ae732\images\0a849e0eb15faa8a6d7329c3dd66aabe9a294cccb52ed30a90c8ca99092ae732.png
        assertEquals(segmentationsPerImage.get(images[0]).size(), 38);
        // Check the bounding box for the first image (should confirm that the scaling and translation has been done correctly).
        assertEquals(segmentationsPerImage.get(images[0]).get(0).getBounds(),new Rectangle(0,190, 9, 19));
    }
}
