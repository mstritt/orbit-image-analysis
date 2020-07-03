package com.actelion.research.orbit.imageAnalysis.test.deeplearning.maskRCNN;

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.deeplearning.DLSegment;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNDetections;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNSegment;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNSegmentationSettings;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNRawDetections;
import com.actelion.research.orbit.imageAnalysis.deeplearning.DLHelpers;
import org.junit.Test;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Apply a method published as part of: https://www.kaggle.com/c/data-science-bowl-2018
 * 3rd place solution: https://github.com/Lopezurrutia/DSB_2018
 * Models can be found here: http://www.orbit.bio/deep-learning-models/
 * Train/test data can be found here: https://data.broadinstitute.org/bbbc/BBBC038/
 */
public class TestCorpusCallosumSegment {

    @Test
    public void testSessionLoad() {
        Session s = DLSegment.buildSession("D:/deeplearning/deepretina/deepretina_final.pb");
        assertNotNull(s);
        s.close();
    }

    @Test
    public void testBrainDetector() {

    }

    @Test
    public void testSegmentationAnnotationsCustom() throws Exception {
        // Test image (Orbit/RDF ID).
        int[] images = {19340922};

        // Do a 'low-res' segmentation.
        RawDataFile rdf = DALConfig.getImageProvider().LoadRawDataFile(images[0]);
        RecognitionFrame rf = new RecognitionFrame(rdf);

        // Whole slide image containing a brain (at top-level of image pyramid - lowest resolution).
        BufferedImage smallImage = rf.bimg.getMipMaps()[rf.bimg.getMipMaps().length-1].getImage().getAsBufferedImage();

        // Size of image to use for brain detection.
        Point brainImgDims = new Point(512, 512);
        // Size of image to use for Corpus Callosum detection.
        Point ccImgDims = new Point(512, 512);

        // Load MaskRCNN models.
        File maskRCNNBrainModel = new File("D:/deeplearning/corpus_callosum/finalbrainDetect2.pb");
        File maskRCNNCorpusCallosumModel = new File("D:/deeplearning/corpus_callosum/finalbrain15-56b.pb");


        // Setup the brain detector.
        MaskRCNNSegmentationSettings brainSettings = new MaskRCNNSegmentationSettings(brainImgDims.x, brainImgDims.y, 1f, 1, 28, 28, 2, "Brain");

        MaskRCNNSegment brainModel = new MaskRCNNSegment(maskRCNNBrainModel, MaskRCNNSegment.PostProcessMethod.CUSTOM, brainSettings);

        // Resize the whole slide image to low-res for the MaskRCNN brain detection.
        BufferedImage image512 = DLHelpers.resize(smallImage,brainSettings.getImageWidth(),brainSettings.getImageHeight());

        Tensor<Float> input = DLHelpers.convertBufferedImageToTensor(image512, brainSettings.getImageWidth(), brainSettings.getImageHeight());

        // Detect, and process the detected brain.
        MaskRCNNRawDetections rawBrain = brainModel.getMaskRCNNRawDetections(input);
        MaskRCNNDetections brainz = brainModel.processDetections(brainSettings.getImageWidth(), brainSettings.getImageHeight(),rawBrain);

        // Should only find one brain.
        assertEquals(brainz.getDetections().size(), 1);

        // Bounding box that covers the brain.
        Rectangle brainBB = brainz.getBoundingBoxes().get(0);

        // Scaling factor to rescale the bounding box to the whole slide image.
        float xScale = (float) smallImage.getWidth()/ (float) brainImgDims.x;
        float yScale = (float) smallImage.getHeight()/ (float) brainImgDims.y;

        // Create a border padding around the bounding box,
        // rescale it so the bounding box is the same scale as the whole slide image.
        // and then chop out a sub-image that covers the brain from the whole slide image.
        int pad = 20;
        Rectangle brainBBPadded = new Rectangle(brainBB.x - pad, brainBB.y - pad, brainBB.width + pad*2, brainBB.height + pad*2);

        Rectangle bbScaled = new Rectangle((int) ((brainBBPadded.x) * xScale), (int) ((brainBBPadded.y) * yScale), (int) ((brainBBPadded.width) * xScale), (int) ((brainBBPadded.height) * yScale));
        bbScaled = new Rectangle(smallImage.getMinX(),smallImage.getMinY(),smallImage.getWidth(),smallImage.getHeight()).intersection(bbScaled);
        BufferedImage brainImg = smallImage.getSubimage(bbScaled.x,bbScaled.y,(int)bbScaled.getWidth(),(int)bbScaled.getHeight());
        brainImg = DLHelpers.resize(brainImg, ccImgDims.x, ccImgDims.y);

        // Determine the rescaling factor for the area of interest (brain + padding) compared to the desired size
        // of the image for detecting the Corpus Callosum.
        float brainScaleX = (float) brainBBPadded.width / (float) ccImgDims.x;
        float brainScaleY = (float) brainBBPadded.height / (float) ccImgDims.y;

        // Settings for Corpus Callosum detection.
        MaskRCNNSegmentationSettings corpusCallosumSettings = new MaskRCNNSegmentationSettings(ccImgDims.x, ccImgDims.y, brainScaleX, brainScaleY, 1, 56, 56, 2, "Corpus_Callosum");

        // Setup the Corpus Callosum segmentation model.
        MaskRCNNSegment ccModel = new MaskRCNNSegment(maskRCNNCorpusCallosumModel, MaskRCNNSegment.PostProcessMethod.CUSTOM, corpusCallosumSettings);

        // Create tensor from brain image.
        Tensor<Float> input2 = DLHelpers.convertBufferedImageToTensor(brainImg, corpusCallosumSettings.getImageWidth(), corpusCallosumSettings.getImageHeight());

        // Apply Corpus Callosum Model
        MaskRCNNRawDetections rawCC = ccModel.getMaskRCNNRawDetections(input2);

        // Scaling factor for the whole slide image relative to the brain image used for Corpus Callosum detection.
        float imageScaleX = (float) rf.bimg.getWidth() / (float) brainImgDims.x;
        float imageScaleY = (float) rf.bimg.getHeight() / (float) brainImgDims.y;

        // Extract the detections for annotations.
        // TODO: This method is currently being abused... (point being used for scaling, not translation...)
        Point2D scaleFactor = new Point2D.Float(imageScaleX, imageScaleY);
        MaskRCNNDetections cc = ccModel.processDetections(corpusCallosumSettings.getImageWidth(), corpusCallosumSettings.getImageHeight(),rawCC, brainBBPadded, scaleFactor, new Point(0,0));

        // Store annotations.
        //ccModel.storeShapes(cc, corpusCallosumSettings, 19340922, "AutomatedAnnotation");

        // Expect one Corpus Callosum
        assertEquals(cc.getDetections().size(), 1);
        // Expect Bounding Box:
        assertEquals(cc.getDetections().get(0).getBoundingBox().getBounds(),new Rectangle(20787,10238, 3173, 18283));

    }

}
