package com.actelion.research.orbit.imageAnalysis.test.deeplearning.maskRCNN;

import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNAnchors;
import com.actelion.research.orbit.imageAnalysis.test.OrbitTestOS;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestAnchorGenerator extends OrbitTestOS {
    @Test
    void TestGenerateAnchors() {
        // Generate anchors for 1024 images.
        float[] arr1024 = MaskRCNNAnchors.GenerateAnchors(1024);

        Assert.assertEquals(arr1024.length, 1047552);
        Assert.assertEquals(arr1024[arr1024.length-1], 1.0259136, 0.1);

        // Generate anchors for 512 images.
        float[] arr512 = MaskRCNNAnchors.GenerateAnchors(512);

        Assert.assertEquals(arr512.length, 261888);
        Assert.assertEquals(arr512[arr512.length-1], 1.0259136, 0.1);

        // Fail when generating anchors for other image sizes.
        float[] arr256 = MaskRCNNAnchors.GenerateAnchors(256);
        //TODO: Should throw an exception.

    }
}
