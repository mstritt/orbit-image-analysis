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

import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.dal.localImage.OrbitImageBioformats;
import com.actelion.research.orbit.imageAnalysis.dal.localImage.ndpi.NDPIImageNative;
import com.actelion.research.orbit.imageAnalysis.utils.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.awt.*;
import java.awt.image.WritableRaster;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

@Ignore
public class TestNDPINativeAndJava {
    private static String testImagePath;

    @BeforeClass
    public static void setUp() {
        OrbitLogAppender.GUI_APPENDER = false;
        OrbitUtils.SLEEP_TASK=0;
        OrbitUtils.SLEEP_TILE=0;
        testImagePath = TestTissueClassificationNDPIS.class.getResource("/testimages/test3-FITC 2 (485).ndpi").toString().replaceAll("file:/","").replaceAll("%20"," ");
        System.out.println("test image: "+testImagePath);
    }

    @Test
    public void testReaders() throws Exception {
        OrbitTiledImage2 imgJava = getRecognitionFrameJava().bimg.getImage();
        OrbitTiledImage2 imgNative = getRecognitionFrameNative().bimg.getImage();
//        imgJava.getTile(0,0);
//        imgNative.getTile(0,0);
        assertEquals(imgJava.getWidth(),imgNative.getWidth());
        assertEquals(imgJava.getHeight(),imgNative.getHeight());
        System.out.println(Arrays.toString(imgJava.getTileIndices(null)));   // 3,4
        System.out.println(Arrays.toString(imgNative.getTileIndices(null)));  // 7,9
//        WritableRaster rJ = (WritableRaster) imgJava.getTile(3,4).createTranslatedChild(0,0);
//        WritableRaster rN = (WritableRaster) imgNative.getTile(7,9).createTranslatedChild(0,0);
        Rectangle rect = new Rectangle(imgJava.getWidth()-1024,imgJava.getHeight()-1024,1024,1024);
        WritableRaster rJ = (WritableRaster) imgJava.getData(rect).createTranslatedChild(0,0);
        WritableRaster rN = (WritableRaster) imgNative.getData(rect).createTranslatedChild(0,0);
        assertEquals(rN.getSample(rN.getMinX()+rN.getWidth()-100, rN.getMinY()+rN.getHeight()-8,0), rJ.getSample(rJ.getMinX()+rJ.getWidth()-100, rJ.getMinY()+rJ.getHeight()-8,0),2);
//        BufferedImage biJ = new BufferedImage(imgJava.getColorModel(),rJ,false,null);
//        BufferedImage biN = new BufferedImage(imgNative.getColorModel(),rN,false,null);
//        ImageIO.write(biJ,"png",new File("d:/testJ.png"));
//        ImageIO.write(biN,"png",new File("d:/testN.png"));
    }

    public RecognitionFrame getRecognitionFrameJava() throws Exception {
        OrbitImageBioformats reader = new OrbitImageBioformats(testImagePath,0,0,null);
        OrbitTiledImageIOrbitImage img = new OrbitTiledImageIOrbitImage(reader);
        TiledImagePainter tip = new TiledImagePainter(img,"img");
        RecognitionFrame rf = new RecognitionFrame(tip);
        return rf;
    }

    public RecognitionFrame getRecognitionFrameNative() throws Exception {
        IOrbitImage reader =  new NDPIImageNative(testImagePath, 0);
        OrbitTiledImageIOrbitImage img = new OrbitTiledImageIOrbitImage(reader);
        TiledImagePainter tip = new TiledImagePainter(img,"img");
        RecognitionFrame rf = new RecognitionFrame(tip);
        return rf;
    }


}
