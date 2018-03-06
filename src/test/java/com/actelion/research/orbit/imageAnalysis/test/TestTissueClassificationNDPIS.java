/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2018 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.actelion.research.orbit.imageAnalysis.test;

import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.dal.localImage.OrbitImageBioformats;
import com.actelion.research.orbit.imageAnalysis.mask.IOrbitMaskModelBased;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.utils.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

;


/**
 * TestTwoLevelSegmentation test
 */
@Ignore
public class TestTissueClassificationNDPIS {

    private double[] resAllChannelsJava = new double[]{0.558096,0.343013,0.088396,0.010495};
    private double[] resAllChannelsNative = new double[]{0.619785,0.282822,0.088691,0.008702};
    private double[] res2ChannelsJava = new double[]{0.459803,0.529183,0.000000,0.011014};
    private double[] res2ChannelsNative = new double[]{0.525656,0.465164,0.000000,0.009180};

    private double[] resMaskAllNative = new double[]{0.000000,0.466349,0.533651};
    private double[] resMask2ChannelsNative = new double[]{0.993153,0.005986,0.000861};  // mask all channels, classification without DAPI
    private double[] resMaskSegmentationNative = new double[]{0.491418,0.372698,0.135884};

    private double[] resMaskAllJava = new double[]{0.000000,0.465265,0.534735};
    private double[] resMask2ChannelsJava = new double[]{0.984302,0.014861,0.000836};  // mask all channels, classification without DAPI
    private double[] resMaskSegmentationJava = new double[]{0.489331,0.370854,0.139815};

    private static String testImagePath;

    @BeforeClass
    public static void setUp() {
        OrbitLogAppender.GUI_APPENDER = false;
        OrbitUtils.SLEEP_TASK=0;
        OrbitUtils.SLEEP_TILE=0;
        testImagePath = TestTissueClassificationNDPIS.class.getResource("/testimages/test3.ndpis").toString().replaceAll("file:/","");
        System.out.println("test image: "+testImagePath);
    }



    @Test
    public void testAllChannels() throws Exception {
        OrbitModel model = OrbitModel.LoadFromInputStream(this.getClass().getResourceAsStream("/testmodels/test3-4chan.omo"));
        assertNotNull(model);
        RecognitionFrame rf = getRecognitionFrame(model);
        ClassificationResult res = OrbitHelper.Classify(null, rf, model, null, -1, null);
        assertNotNull(res);
        assertNotNull(res.getRatio());
//        assertEquals(resAllChannelsNative[0], res.normalizeRatio().get(0).getValue(), 0.0001d);
//        assertEquals(resAllChannelsNative[1], res.normalizeRatio().get(1).getValue(), 0.0001d);
//        assertEquals(resAllChannelsNative[2], res.normalizeRatio().get(2).getValue(), 0.0001d);
//        assertEquals(resAllChannelsNative[3], res.normalizeRatio().get(3).getValue(), 0.0001d);

        assertEquals(resAllChannelsJava[0], res.normalizeRatio().get(0).getValue(), 0.0001d);
        assertEquals(resAllChannelsJava[1], res.normalizeRatio().get(1).getValue(), 0.0001d);
        assertEquals(resAllChannelsJava[2], res.normalizeRatio().get(2).getValue(), 0.0001d);
        assertEquals(resAllChannelsJava[3], res.normalizeRatio().get(3).getValue(), 0.0001d);
    }

    @Test
    public void test2Channels() throws Exception {
        OrbitModel model = OrbitModel.LoadFromInputStream(this.getClass().getResourceAsStream("/testmodels/test3-2chan.omo"));
        assertNotNull(model);
        RecognitionFrame rf = getRecognitionFrame(model);
        ClassificationResult res = OrbitHelper.Classify(null, rf, model, null, -1, null);
        assertNotNull(res);
        assertNotNull(res.getRatio());
//        assertEquals(res2ChannelsNative[0], res.normalizeRatio().get(0).getValue(), 0.0001d);
//        assertEquals(res2ChannelsNative[1], res.normalizeRatio().get(1).getValue(), 0.0001d);
//        assertEquals(res2ChannelsNative[2], res.normalizeRatio().get(2).getValue(), 0.0001d);
//        assertEquals(res2ChannelsNative[3], res.normalizeRatio().get(3).getValue(), 0.0001d);

        assertEquals(res2ChannelsJava[0], res.normalizeRatio().get(0).getValue(), 0.0001d);
        assertEquals(res2ChannelsJava[1], res.normalizeRatio().get(1).getValue(), 0.0001d);
        assertEquals(res2ChannelsJava[2], res.normalizeRatio().get(2).getValue(), 0.0001d);
        assertEquals(res2ChannelsJava[3], res.normalizeRatio().get(3).getValue(), 0.0001d);
    }


    @Test
    public void testMaskAllChannels() throws Exception  {
        OrbitModel model = OrbitModel.LoadFromInputStream(this.getClass().getResourceAsStream("/testmodels/test3-maskAll.omo"));
        assertNotNull(model);
        RecognitionFrame rf = getRecognitionFrame(model);
        RecognitionFrame maskFrame = getRecognitionFrame(((IOrbitMaskModelBased)model.getMask()).getModel());
        ClassificationResult res = OrbitHelper.Classify(null, rf, maskFrame, model, null, -1, null);
        assertNotNull(res);
        assertNotNull(res.getRatio());
        assertEquals(resMaskAllJava[0], res.normalizeRatio().get(0).getValue(), 0.0001d);
        assertEquals(resMaskAllJava[1], res.normalizeRatio().get(1).getValue(), 0.0001d);
        assertEquals(resMaskAllJava[2], res.normalizeRatio().get(2).getValue(), 0.0001d);
    }

    @Test
    public void testMask2Channels() throws Exception  {
        OrbitModel model = OrbitModel.LoadFromInputStream(this.getClass().getResourceAsStream("/testmodels/test3-mask2chan.omo"));
        assertNotNull(model);
        RecognitionFrame rf = getRecognitionFrame(model);
        RecognitionFrame maskFrame = getRecognitionFrame(((IOrbitMaskModelBased)model.getMask()).getModel());
        ClassificationResult res = OrbitHelper.Classify(null, rf, maskFrame, model, null, -1, null);
        assertNotNull(res);
        assertNotNull(res.getRatio());
        assertEquals(resMask2ChannelsJava[0], res.normalizeRatio().get(0).getValue(), 0.0001d);
        assertEquals(resMask2ChannelsJava[1], res.normalizeRatio().get(1).getValue(), 0.0001d);
        assertEquals(resMask2ChannelsJava[2], res.normalizeRatio().get(2).getValue(), 0.0001d);
    }

    @Test
    public void testMaskSegmentation() throws Exception  {
        OrbitModel model = OrbitModel.LoadFromInputStream(this.getClass().getResourceAsStream("/testmodels/test3-maskSegmentation.omo"));
        assertNotNull(model);
        RecognitionFrame rf = getRecognitionFrame(model);
        RecognitionFrame maskFrame = getRecognitionFrame(((IOrbitMaskModelBased)model.getMask()).getModel());
        ClassificationResult res = OrbitHelper.Classify(null, rf, maskFrame, model, null, -1, null);
        assertNotNull(res);
        assertNotNull(res.getRatio());
        assertEquals(resMaskSegmentationJava[0], res.normalizeRatio().get(0).getValue(), 0.0001d);
        assertEquals(resMaskSegmentationJava[1], res.normalizeRatio().get(1).getValue(), 0.0001d);
        assertEquals(resMaskSegmentationJava[2], res.normalizeRatio().get(2).getValue(), 0.0001d);
    }

    public RecognitionFrame getRecognitionFrame(OrbitModel model) throws Exception {
        OrbitImageBioformats reader = new OrbitImageBioformats(testImagePath,0,0,model);
//        TileSizeWrapperMultiChannel wrapper = new TileSizeWrapperMultiChannel(reader,512,512);
//        IOrbitImage reader =  new NDPISImageNative(testImagePath, 0);
        OrbitTiledImageIOrbitImage img = new OrbitTiledImageIOrbitImage(reader);
        TiledImagePainter tip = new TiledImagePainter(img,"img");
        RecognitionFrame rf = new RecognitionFrame(tip);
//        DALConfig.switchLocalRemoteImageProvider();
//        RawDataFile rdf = DALConfig.getImageProvider().LoadRawDataFile(20);
//        RecognitionFrame rf = new RecognitionFrame(rdf);
        System.out.println("tileWidth: "+rf.bimg.getImage().getTileWidth());
        assertNotNull(rf);
        assertEquals(3968,rf.bimg.getImage().getWidth());
        assertEquals(4864,rf.bimg.getImage().getHeight());
        return rf;
    }



}
