/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2020 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
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
import com.actelion.research.orbit.imageAnalysis.dal.localImage.ndpi.NDPIImageNative;
import com.actelion.research.orbit.imageAnalysis.utils.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

//@Ignore
public class TestNDPINativeAndJava {
    // Define this image to use testReaderUserImage()
    private static String testImagePath;
    private static String testBrightImagePath;
    private static String testFluoroImagePath;

    private enum TestImageType {
        BRIGHTFIELD,
        FLUORESCENCE,
        USER_DEFINED
    }

    @BeforeClass
    public static void setUp() {
        OrbitLogAppender.GUI_APPENDER = false;
        OrbitUtils.SLEEP_TASK=0;
        OrbitUtils.SLEEP_TILE=0;

        // TODO: Import images from http://openslide.cs.cmu.edu/download/openslide-testdata/Hamamatsu/
        //testBrightImagePath = TestTissueClassificationNDPIS.class.getResource("/testimages/CMU-1.ndpi").toString().replaceAll("file:/","").replaceAll("%20"," ");
        //testFluoroImagePath = TestNDPINativeAndJava.class.getResource("/testimages/test3-FITC 2 (485).ndpi").toString().replaceAll("file:/","").replaceAll("%20"," ");
//        try {
            testFluoroImagePath = new File(TestNDPINativeAndJava.class.getResource("/testimages/test3-FITC 2 (485).ndpi").getFile()).getPath();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        testImagePath = "";
        // Test a double size, >4Gb file...

        System.out.println("Brightfield test image: "+testBrightImagePath);
        System.out.println("Fluorescence test image: "+testFluoroImagePath);
        System.out.println("User-defined test image: "+testImagePath);
    }

    /**
     * Here we check that the NDPI Reader that uses Native libraries produces the
     * same results as the Java version (which uses Bioformats), using Brightfield
     * image as a test.
     * @throws Exception :-(
     */
    @Ignore
    @Test
    public void testReaderIdenticalBrightfieldTilePixels() throws Exception {

        // Check the first and second levels.
        for(int i=0; i<2; i++) {
            OrbitTiledImage2 imgJava = getRecognitionFrameJava(TestImageType.BRIGHTFIELD, i).bimg.getImage();
            OrbitTiledImage2 imgNative = getRecognitionFrameNative(TestImageType.BRIGHTFIELD, i).bimg.getImage();

            // The images should have the same dimension irrespective of the reader used.
            assertEquals(imgJava.getWidth(), imgNative.getWidth());
            assertEquals(imgJava.getHeight(), imgNative.getHeight());

            // rJ has tile size of 512, and rN has tile size of 1024 - which is why tile coordinates are different in each case.
            WritableRaster rJ = (WritableRaster) imgJava.getTile(0, 0).createTranslatedChild(0, 0);
            WritableRaster rN = (WritableRaster) imgNative.getTile(0, 0).createTranslatedChild(0, 0);

            int pixelJ = rJ.getSample(rJ.getMinX() + rJ.getWidth() - 100, rJ.getMinY() + rJ.getHeight() - 100, 0);
            int pixelN = rN.getSample(rN.getMinX() + rN.getWidth() - 100, rN.getMinY() + rN.getHeight() - 100, 0);

            // 'Random' pixel values at the first tile should have the same value.
            assertEquals(pixelJ, pixelN, 1);

            // rJ has tile size of 512, and rN has tile size of 1024 - which is why tile coordinates are different in each case.
            WritableRaster rJ2 = (WritableRaster) imgJava.getTile(3, 4).createTranslatedChild(0, 0);
            WritableRaster rN2 = (WritableRaster) imgNative.getTile(7, 9).createTranslatedChild(0, 0);

            // A test that shouldn't suffer from: https://github.com/ome/bioformats/issues/3059
            int pixelJ2 = rJ2.getSample(rJ.getMinX() + rJ.getWidth() - 100, rJ.getMinY() + rJ.getHeight() - 8, 0);
            int pixelN2 = rN2.getSample(rN.getMinX() + rN.getWidth() - 100, rN.getMinY() + rN.getHeight() - 8, 0);

            // Pixels at the same place on the last tile should have the same value.
            assertEquals(pixelJ2, pixelN2, 1);

            // A test that should suffer from: https://github.com/ome/bioformats/issues/3059
            int pixelJ2a = rJ2.getSample(rJ.getMinX() + rJ.getWidth() - 100, rJ.getMinY() + rJ.getHeight()-1, 0);
            int pixelN2a = rN2.getSample(rN.getMinX() + rN.getWidth() - 100, rN.getMinY() + rN.getHeight()-1, 0);

            // Pixels at the same place on the last tile should have the same value.
            assertEquals(pixelJ2a, pixelN2a, 1);

            // Extract an area from the image (to avoid tile size differences)
            Rectangle rect = new Rectangle(imgJava.getWidth()-3456,imgJava.getHeight()-3456,1024,1024);
            WritableRaster rJ3 = (WritableRaster) imgJava.getData(rect).createTranslatedChild(0,0);
            WritableRaster rN3 = (WritableRaster) imgNative.getData(rect).createTranslatedChild(0,0);

            // Grab the first pixel
            int pixelJ3 = rJ3.getSample(0,0,0);
            int pixelN3 = rN3.getSample(0,0,0);

            assertEquals(pixelN3, pixelJ3,0);

            // Grab a more random pixel
            int pixelN4 = rN3.getSample(rN3.getMinX()+rN3.getWidth()-666, rN3.getMinY()+rN3.getHeight()-42,0);
            int pixelJ4 = rJ3.getSample(rJ3.getMinX()+rJ3.getWidth()-666, rJ3.getMinY()+rJ3.getHeight()-42,0);

            assertEquals(pixelN4, pixelJ4,0);
        }
    }

    /**
     * Here we check that the NDPI Reader that uses Native libraries produces the
     * same results as the Java version (which uses Bioformats), using Fluorescence
     * image as a test.
     * @throws Exception :-(
     */
    @Test
    public void testReaderIdenticalFluorescenceTilePixels() throws Exception {
            OrbitTiledImage2 imgJava = getRecognitionFrameJava(TestImageType.FLUORESCENCE, 0).bimg.getImage();
            OrbitTiledImage2 imgNative = getRecognitionFrameNative(TestImageType.FLUORESCENCE, 0).bimg.getImage();

            // The images should have the same dimension irrespective of the reader used.
            assertEquals(imgJava.getWidth(), imgNative.getWidth());
            assertEquals(imgJava.getHeight(), imgNative.getHeight());

            // rJ has tile size of 512, and rN has tile size of 1024 - which is why tile coordinates are different in each case.
            WritableRaster rJ = (WritableRaster) imgJava.getTile(0, 0).createTranslatedChild(0, 0);
            WritableRaster rN = (WritableRaster) imgNative.getTile(0, 0).createTranslatedChild(0, 0);

            int pixelJ = rJ.getSample(rJ.getMinX() + rJ.getWidth() - 100, rJ.getMinY() + rJ.getHeight() - 100, 0);
            int pixelN = rN.getSample(rN.getMinX() + rN.getWidth() - 100, rN.getMinY() + rN.getHeight() - 100, 0);

            // 'Random' pixel values at the first tile should have the same value.
            assertEquals(pixelJ, pixelN, 1);

            // rJ has tile size of 512, and rN has tile size of 1024 - which is why tile coordinates are different in each case.
            WritableRaster rJ2 = (WritableRaster) imgJava.getTile(3, 4).createTranslatedChild(0, 0);
            WritableRaster rN2 = (WritableRaster) imgNative.getTile(7, 9).createTranslatedChild(0, 0);

            // A test that shouldn't suffer from: https://github.com/ome/bioformats/issues/3059
            int pixelJ2 = rJ2.getSample(rJ.getMinX() + rJ.getWidth() - 100, rJ.getMinY() + rJ.getHeight() - 8, 0);
            int pixelN2 = rN2.getSample(rN.getMinX() + rN.getWidth() - 100, rN.getMinY() + rN.getHeight() - 8, 0);

            // Pixels at the same place on the last tile should have the same value.
            assertEquals(pixelJ2, pixelN2, 2);

            // A test that should suffer from: https://github.com/ome/bioformats/issues/3059
            int pixelJ2a = rJ2.getSample(rJ.getMinX() + rJ.getWidth() - 100, rJ.getMinY() + rJ.getHeight()-1, 0);
            int pixelN2a = rN2.getSample(rN.getMinX() + rN.getWidth() - 100, rN.getMinY() + rN.getHeight()-1, 0);

            // Pixels at the same place on the last tile should have the same value.
            assertEquals(pixelJ2a, pixelN2a, 2);

            // Extract an area from the image (to avoid tile size differences)
            Rectangle rect = new Rectangle(imgJava.getWidth()-456,imgJava.getHeight()-456,1024,1024);
            WritableRaster rJ3 = (WritableRaster) imgJava.getData(rect).createTranslatedChild(0,0);
            WritableRaster rN3 = (WritableRaster) imgNative.getData(rect).createTranslatedChild(0,0);

            // Grab the first pixel
            int pixelJ3 = rJ3.getSample(0,0,0);
            int pixelN3 = rN3.getSample(0,0,0);

            assertEquals(pixelN3, pixelJ3,6);

            // Grab a more random pixel
            int pixelN4 = rN3.getSample(rN3.getMinX()+rN3.getWidth()-666, rN3.getMinY()+rN3.getHeight()-42,0);
            int pixelJ4 = rJ3.getSample(rJ3.getMinX()+rJ3.getWidth()-666, rJ3.getMinY()+rJ3.getHeight()-42,0);

            assertEquals(pixelN4, pixelJ4,2);
    }

    /**
     * Typically we expect the Java implementation to be about 3 times slower than the
     * native implementation. The test checks that the java implementation is not faster
     * than the native, and that the java implementation is not worse than 7 times slower.
     *
     * Note that this isn't in any way a fair test, it is however a useful indicator for
     * Orbit developers in case we make a change that massively affects performance.
     * @throws Exception :-(
     */
    @Test
    public void testReaderPerformance() throws Exception {

        Instant startJ = java.time.Instant.now();
        readTileWriteImage(getRecognitionFrameJava(TestImageType.FLUORESCENCE, 0), "testJ.png");
        Instant endJ = java.time.Instant.now();
        Duration betweenJ = java.time.Duration.between(startJ, endJ);

        Instant startN = java.time.Instant.now();
        readTileWriteImage(getRecognitionFrameNative(TestImageType.FLUORESCENCE, 0), "testN.png");
        Instant endN = java.time.Instant.now();
        Duration betweenN = java.time.Duration.between(startN, endN);

        System.out.println("Java Implementation:"+ betweenJ ); // PT1.001S
        System.out.println("Native Implementation:"+  betweenN ); // PT1.001S

        assertThat(betweenJ, allOf(greaterThan(betweenN), lessThan(betweenN.multipliedBy(7))));
    }

    /**
     * Typically we expect the Java implementation to be about 3 times slower than the
     * native implementation. The test checks that the java implementation is not faster
     * than the native, and that the java implementation is not worse than 7 times slower.
     *
     * Note that this isn't in any way a fair test, it is however a useful indicator for
     * Orbit developers in case we make a change that massively affects performance.
     * @throws Exception :-(
     */
    @Test
    public void testReaderPerformanceLoop() throws Exception {

        Duration betweenJ = null;
        Duration betweenN = null;
        for(int i = 0; i<10; i++) {
            Instant startJ = java.time.Instant.now();
            // TODO: get a random tile in a loop.
            readTileWriteImage(getRecognitionFrameJava(TestImageType.FLUORESCENCE, 0), "testJ.png");
            Instant endJ = java.time.Instant.now();
            if (i == 0) {
                betweenJ = java.time.Duration.between(startJ, endJ);
            } else {
                betweenJ = betweenJ.plus(java.time.Duration.between(startJ, endJ));
            }

            Instant startN = java.time.Instant.now();
            readTileWriteImage(getRecognitionFrameNative(TestImageType.FLUORESCENCE, 0), "testN.png");
            Instant endN = java.time.Instant.now();
            if (i == 0) {
                betweenN = java.time.Duration.between(startJ, endJ);
            } else {
                betweenN = betweenN.plus(java.time.Duration.between(startN, endN));
            }
        }

        System.out.println("Java Implementation:"+ betweenJ ); // PT1.001S
        System.out.println("Native Implementation:"+  betweenN ); // PT1.001S

        assertThat(betweenJ, allOf(greaterThan(betweenN), lessThan(betweenN.multipliedBy(7))));
    }

    /**
     * Use this to test a specific image. Leave as @Ignore so it isn't tested by CI/CD.
     * @throws Exception :-(
     */
    @Test
    @Ignore
    public void testReaderUserImage() throws Exception {
        Instant startJ = java.time.Instant.now();
        readTileWriteImage(getRecognitionFrameJava(TestImageType.USER_DEFINED, 0), "testJ.png");
        Instant endJ = java.time.Instant.now();
        Duration betweenJ = java.time.Duration.between(startJ, endJ);

        Instant startN = java.time.Instant.now();
        readTileWriteImage(getRecognitionFrameNative(TestImageType.USER_DEFINED, 0), "testN.png");
        Instant endN = java.time.Instant.now();
        Duration betweenN = java.time.Duration.between(startN, endN);

        System.out.println("Java Implementation:"+ betweenJ ); // PT1.001S
        System.out.println("Native Implementation:"+  betweenN ); // PT1.001S

        assertThat(betweenJ, allOf(greaterThan(betweenN), lessThan(betweenN.multipliedBy(5))));
    }

    /**
     * Read a predefined tile and write it to a png file is java.io.tmpdir. Used for testing purposes.
     * @param recognitionFrame the recognition frame.
     * @param s the filename (as seen in the tmpdir)
     * @throws IOException if you fail to write the png.
     */
    private void readTileWriteImage(RecognitionFrame recognitionFrame, String s) throws IOException {
        OrbitTiledImage2 img = recognitionFrame.bimg.getImage();

        Rectangle rect = new Rectangle(img.getWidth()-1024*2,img.getHeight()-1024*2,1024,1024);
//        For BRIGHTFIELD used the below, made a much bigger performance difference.
//        Rectangle rect = new Rectangle(img.getWidth()-1024*10,img.getHeight()-1024*10,1024,1024);

        WritableRaster r2 = (WritableRaster) img.getData(rect).createTranslatedChild(0,0);
        BufferedImage biJ = new BufferedImage(img.getColorModel(), r2, false, null);
        ImageIO.write(biJ, "png", new File(System.getProperty("java.io.tmpdir"),s));
    }

    /**
     * Get a recognition frame for testing (backed by Bioformats reader)
     * @param imageType the type of the test image.
     * @param imageLevel the location in the image pyramid
     * @return a recognition frame backed by OrbitImageBioformats
     * @throws Exception something went wrong.
     */
    public RecognitionFrame getRecognitionFrameJava(TestImageType imageType, int imageLevel) throws Exception {
        OrbitImageBioformats reader;

        switch(imageType) {
            case BRIGHTFIELD:
                reader = new OrbitImageBioformats(testBrightImagePath, imageLevel, 0, null);
                break;
            case FLUORESCENCE:
                reader = new OrbitImageBioformats(testFluoroImagePath, imageLevel, 0, null);
                break;
            case USER_DEFINED:
                reader = new OrbitImageBioformats(testImagePath, imageLevel, 0, null);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + imageType);
        }

        OrbitTiledImageIOrbitImage img = new OrbitTiledImageIOrbitImage(reader);
        TiledImagePainter tip = new TiledImagePainter(img,"img");
        return new RecognitionFrame(tip);
    }

    /**
     * Get a recognition frame for testing (backed by NDPI native libraries)
     * @param imageType the type of the test image.
     * @param imageLevel the location in the image pyramid
     * @return a recognition frame backed by NDPIImageNative
     * @throws Exception something went wrong.
     */
    public RecognitionFrame getRecognitionFrameNative(TestImageType imageType, int imageLevel) throws Exception {
        NDPIImageNative reader;

        switch(imageType) {
            case BRIGHTFIELD:
                reader =  new NDPIImageNative(testBrightImagePath, imageLevel);
                break;
            case FLUORESCENCE:
                reader =  new NDPIImageNative(testFluoroImagePath, imageLevel);
                break;
            case USER_DEFINED:
                reader = new NDPIImageNative(testImagePath, imageLevel);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + imageType);
        }

        OrbitTiledImageIOrbitImage img = new OrbitTiledImageIOrbitImage(reader);
        TiledImagePainter tip = new TiledImagePainter(img,"img");
        return new RecognitionFrame(tip);
    }
}
