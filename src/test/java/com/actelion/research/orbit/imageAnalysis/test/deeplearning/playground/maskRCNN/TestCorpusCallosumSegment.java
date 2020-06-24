package com.actelion.research.orbit.imageAnalysis.test.deeplearning.playground.maskRCNN;

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.deeplearning.DLSegment;
import com.actelion.research.orbit.imageAnalysis.deeplearning.playground.maskRCNN.*;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import org.junit.Test;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import java.awt.*;
import java.awt.image.BufferedImage;
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
    public void testCorpusCallosumDetector() throws Exception {
        CorpusCallosumAnnotator annotator = new CorpusCallosumAnnotator();
        annotator.annotate(19340922);
    }

    @Test
    public void testSegmentationAnnotationsCustom() throws Exception {
        int[] images = {19340922};

        // Do a 'low-res' segmentation.
        RawDataFile rdf = DALConfig.getImageProvider().LoadRawDataFile(19340922);
        RecognitionFrame rf = new RecognitionFrame(rdf);
        BufferedImage smallImage = rf.bimg.getMipMaps()[rf.bimg.getMipMaps().length-1].getImage().getAsBufferedImage();
        //noinspection IntegerDivisionInFloatingPointContext
        float imageScale = rf.bimg.getWidth() / 1024;//smallImage.getWidth();

        File maskRCNNBrainModel = new File("D:/deeplearning/corpus_callosum/finalbrainDetect2.pb");
        File maskRCNNCorpusCallosumModel = new File("D:/deeplearning/corpus_callosum/finalbrain15-56b.pb");

        MaskRCNNSegmentationSettings brainSettings = new MaskRCNNSegmentationSettings(512, 512, 1f, 1, 28, 28, 2, "Brain");
        MaskRCNNSegmentationSettings corpusCallosumSettings = new MaskRCNNSegmentationSettings(1024, 1024, imageScale, 1, 56, 56, 2, "Corpus_Callosum");

        MaskRCNNSegment brainModel = new MaskRCNNSegment(maskRCNNBrainModel, MaskRCNNSegment.PostProcessMethod.CUSTOM, brainSettings);


        float xScale = smallImage.getWidth()/512f;
        float yScale = smallImage.getHeight()/512f;

        BufferedImage image512 = DLHelpers.resize(smallImage,brainSettings.getImageWidth(),brainSettings.getImageHeight());

        Tensor<Float> input = DLHelpers.convertBufferedImageToTensor(image512, brainSettings.getImageWidth(), brainSettings.getImageHeight());

        RawDetections rawBrain = brainModel.getMaskRCNNRawDetections(input);
        MaskRCNNDetections brainz = brainModel.processDetections(brainSettings.getImageWidth(), brainSettings.getImageHeight(),rawBrain);

        // Should only find one brain.
        assertEquals(brainz.getDetections().size(), 1);

        Rectangle brainBB = brainz.getBoundingBoxes().get(0);

        BufferedImage brainImg = smallImage.getSubimage((int) (xScale * brainBB.x), (int) (yScale*brainBB.y),(int) (brainBB.width*xScale),(int) (brainBB.height*yScale));
        // Works but resolution loss...
        //BufferedImage brainImg = image512.getSubimage(brainBB.x, brainBB.y, brainBB.width, brainBB.height);
        brainImg = DLHelpers.resize(brainImg, 1024, 1024);

        MaskRCNNSegment ccModel = new MaskRCNNSegment(maskRCNNCorpusCallosumModel, MaskRCNNSegment.PostProcessMethod.CUSTOM, corpusCallosumSettings);

        Tensor<Float> input2 = DLHelpers.convertBufferedImageToTensor(brainImg, corpusCallosumSettings.getImageWidth(), corpusCallosumSettings.getImageHeight());

        RawDetections rawCC = ccModel.getMaskRCNNRawDetections(input2);
        MaskRCNNDetections cc = ccModel.processDetections(corpusCallosumSettings.getImageWidth(), corpusCallosumSettings.getImageHeight(),rawCC);

        ccModel.storeShapes(cc, corpusCallosumSettings, 19340922, "AutomatedAnnotation");
//        OrbitModel segModel = OrbitModel.LoadFromInputStream(
//                this.getClass().getResourceAsStream("/resource/testmodels/dlsegmentsplit.omo"));
//        assertNotNull(segModel);
//        Map<Integer, List<Shape>> segmentationsPerImage = ccModel.generateSegmentationAnnotations(
//                images, segModel, null, true);

        // Expect one Corpus Callosum
        assertEquals(cc.getDetections().size(), 1);
        // Expect Bounding Box:
        assertEquals(cc.getDetections().get(0).getBoundingBox().getBounds(),new Rectangle(464,164, 214, 699));


        // There should be 44 objects detected in the test image: D:\deeplearning\deepretina\training-data\stage1_test\0a849e0eb15faa8a6d7329c3dd66aabe9a294cccb52ed30a90c8ca99092ae732\images\0a849e0eb15faa8a6d7329c3dd66aabe9a294cccb52ed30a90c8ca99092ae732.png
//        assertEquals(segmentationsPerImage.get(images[0]).size(), 44);
        // Check the bounding box for the first image (should confirm that the scaling and translation has been done correctly).
//        assertEquals(segmentationsPerImage.get(images[0]).get(0).getBounds(),new Rectangle(105,110, 19, 22));
    }

}
