/*
 * Copyright 1997-2016 Actelion Ltd., Inc.
 * Gewerbestrasse 16
 * CH-4123 Allschwil, Switzerland
 *
 * All Rights Reserved.
 * This software is the proprietary information of Actelion Pharmaceuticals, Ltd.
 * Use is subject to license terms.
 *
 * User: stritma1
 * Date: 6/10/16 4:58 PM
 *
 *
 */

package com.actelion.research.orbit.imageAnalysis.segmenter.celldetector;

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.dal.ImageProviderLocal;
import com.actelion.research.orbit.imageAnalysis.deeplearning.AbstractSegmentationSettings;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNSegment;
import com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN.MaskRCNNSegmentationSettings;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.models.PolygonExt;
import com.actelion.research.orbit.imageAnalysis.models.SegmentationResult;
import com.actelion.research.orbit.imageAnalysis.tasks.ClassificationWorker;
import com.actelion.research.orbit.imageAnalysis.tasks.DLSegmentationWorker;
import com.actelion.research.orbit.imageAnalysis.tasks.ObjectSegmentationWorker;
import com.actelion.research.orbit.imageAnalysis.utils.TiffConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TestCellsSegmentation extends Canvas {

    static Logger logger = LoggerFactory.getLogger(TestCellsSegmentation.class);

    final int rdfID = 4577304;
    final ImageProviderLocal imageProviderLocal = new ImageProviderLocal();
    // SegmentationResult segmentationResult;
    List<Shape> cells;
    BufferedImage bufferedImage;

    public void cytoplasmaSegmentation() {
        try {
            if (!DALConfig.isLocalImageProvider()) {
                DALConfig.switchLocalRemoteImageProvider();
            }

            OrbitModel orbitModel = OrbitModel.LoadFromFile("C:\\Users\\sempebr1\\orbit\\models\\nuclei_DAPI3.omo");
            assert orbitModel != null;
            orbitModel.getSegmentationModel().getFeatureDescription().setShapeExpansionInUm(5);
            orbitModel.getSegmentationModel().getFeatureDescription().setAvoidShapeExpansionOverlaps(true);
            orbitModel.getSegmentationModel().getFeatureDescription().setExcludeInnerShape(false);
            orbitModel.getSegmentationModel().getFeatureDescription().setCombineObjectsCrossTiles(false);
            orbitModel.getSegmentationModel().getFeatureDescription().setDisableWatershed(false);
            orbitModel.getSegmentationModel().getFeatureDescription().setMumfordShahSegmentation(true);

            File inputFile = new File("C:\\Projects\\CellDetection\\output.tif");

            RawDataFile rawDataFile = imageProviderLocal.registerFile(inputFile, 0);
            RecognitionFrame recognitionFrame = new RecognitionFrame(rawDataFile);
            recognitionFrame.setMuMeterPerPixel(0.23);

            ObjectSegmentationWorker objectSegmentationWorker = new ObjectSegmentationWorker(rawDataFile, recognitionFrame, null, null, null);
            objectSegmentationWorker.setModel(orbitModel);
            objectSegmentationWorker.setWithGUI(false);
            objectSegmentationWorker.run();

            cells = objectSegmentationWorker.getSegmentationResult().getShapeList();

            bufferedImage = recognitionFrame.bimg.getImage().getAsBufferedImage();

        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // public void retinaSegmentation() {
    //     try {
    //         if (!DALConfig.isLocalImageProvider()) {
    //             DALConfig.switchLocalRemoteImageProvider();
    //         }
    //         File inputFile = new File("C:\\Projects\\CellDetection\\output.tif");
    //
    //         RawDataFile rawDataFile = imageProviderLocal.registerFile(inputFile, 0);
    //         RecognitionFrame recognitionFrame = new RecognitionFrame(rawDataFile);
    //         recognitionFrame.setMuMeterPerPixel(0.23);
    //
    //
    //         String pbFilePath = "C:\\Users\\sempebr1\\orbit\\models\\deepretina_final-orbit-model.pb";
    //
    //         MaskRCNNSegmentationSettings dlSettings = new MaskRCNNSegmentationSettings("Nuclei",
    //                 "Retina1",
    //                 null,
    //                 pbFilePath,
    //                 512, 512,
    //                 0.5f,
    //                 512,
    //                 28, 28,
    //                 2,
    //                 "NucleiC",
    //                 false,
    //                 MaskRCNNSegmentationSettings.PostProcessMethod.CUSTOM);
    //         MaskRCNNSegment segmentationModel = new MaskRCNNSegment(dlSettings);
    //
    //         // Time execution.
    //         Date startDate = new Date();
    //         long startt = System.currentTimeMillis();
    //
    //         int images[] = {rawDataFile.getRawDataFileId()};
    //         // Apply the MaskRCNN segmentation models to a list of images.
    //         Map<Integer, List<Shape>> segmentationsPerImage = segmentationModel.generateSegmentationAnnotations(
    //                 images, dlSettings, null, null, null, false);
    //
    //         long used = System.currentTimeMillis() - startt;
    //
    //         System.out.println("time used: " + used / 1000d);
    //
    //         long elapsedTimeInSec = (new Date().getTime() - startDate.getTime()) / 1000;
    //         System.out.println(String.format("Ended in %ds .", elapsedTimeInSec));
    //
    //         for (int annoNum : segmentationsPerImage.keySet()) {
    //             System.out.println("Image " + annoNum + ": number of objects segmented: " + segmentationsPerImage.get(annoNum).size());
    //         }
    //
    //         cells = segmentationsPerImage.get(images[0]);
    //
    //         bufferedImage = recognitionFrame.bimg.getImage().getAsBufferedImage();
    //
    //     } catch (Exception e) {
    //         System.out.println("error: " + e.getMessage());
    //         e.printStackTrace();
    //     }
    // }

    public void paint(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
        graphics2D.drawImage(bufferedImage, 0, 0, null);
        graphics2D.setColor(Color.WHITE);
        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));

        for (Shape cell : cells) {
            Polygon polygon;
            if (cell instanceof Polygon) {
                polygon = (Polygon) cell;
                graphics2D.drawPolygon(polygon);
            } else {
                logger.error("cell is not a polygon: " + cell.toString());
            }
        }
    }

    public static void main(String[] args) {
        TestCellsSegmentation testCellsSegmentation = new TestCellsSegmentation();
        testCellsSegmentation.cytoplasmaSegmentation();

        JFrame frame = new JFrame();
        frame.add(testCellsSegmentation);
        frame.setSize(Math.max(testCellsSegmentation.bufferedImage.getWidth(), 100),
                Math.max(testCellsSegmentation.bufferedImage.getHeight(), 100));

        // Center the frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
