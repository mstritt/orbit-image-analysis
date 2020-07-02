package com.actelion.research.orbit.imageAnalysis.test.deeplearning.DeepLabV2Resnet101;

import com.actelion.research.orbit.imageAnalysis.deeplearning.DeepLabV2Resnet101.DLR101Segment;
import com.actelion.research.orbit.imageAnalysis.deeplearning.DeepLabV2Resnet101.DLR101SegmentationSettings;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TestGlomeruliSegment {

    @Test
    void testGlomeruliSegment() {
        // no annotations for this image.
//        int[] images = {6991411};

        // part of the 'test' dataset.
        int[] images = {4758050}; // 5482449

        // An older model for comparison.
//        File DLR101GlomeruliModel = new File("D:/deeplearning/glomeruli/20180202_glomeruli_detection_noquant.pb");
        File dLR101GlomeruliModel = new File("D:/deeplearning/glomeruli/glomeruli-410k.pb");

        DLR101SegmentationSettings glomeruliSettings = new DLR101SegmentationSettings(1024, 1024, 1, "Glomeruli");

        DLR101Segment glomeruliModel = new DLR101Segment(dLR101GlomeruliModel, glomeruliSettings);

        // Time execution.
        Date startDate = new Date();
        long startt = System.currentTimeMillis();

        Map<Integer, List<Shape>> segmentationsPerImage = glomeruliModel.generateSegmentationAnnotations(
                images, null, null, false);

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
}
