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

package com.actelion.research.orbit.imageAnalysis.deeplearning.playground.maskRCNN;

import com.actelion.research.orbit.beans.RawAnnotation;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.ImageAnnotation;
import com.actelion.research.orbit.imageAnalysis.models.PolygonExt;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.List;


public class CorpusCallosumAnnotator {

    public static int size = 1024;
    public static int sizeBrain = 512;

    public void annotate(final int rdfId) throws Exception {
        RawDataFile rdf = DALConfig.getImageProvider().LoadRawDataFile(rdfId);
        RecognitionFrame rf = new RecognitionFrame(rdf);
        BufferedImage smallImage = rf.bimg.getMipMaps()[rf.bimg.getMipMaps().length-1].getImage().getAsBufferedImage();
        BufferedImage image512 = DLHelpers.resize(smallImage,sizeBrain,sizeBrain);
        

        try (MRCNNBrainDetector brainDetector = new MRCNNBrainDetector();
             MRCNNCorpusCallosum ccDetector = new MRCNNCorpusCallosum()
            ) {
            List<MRCNNBrainDetector.DetectorResult> brainROIs = brainDetector.detectBrains(smallImage,image512);
            for (MRCNNBrainDetector.DetectorResult brainROI: brainROIs) {
                double scaleX1 = (brainROI.x2-brainROI.x1) / (double)size;
                double scaleY1 = (brainROI.y2-brainROI.y1) / (double)size;
                double scaleX2 = rf.bimg.getWidth() / (double)sizeBrain;
                double scaleY2 = rf.bimg.getHeight() / (double)sizeBrain;
               // ImageIO.write(brainROI.roiImage,"jpeg", new File("c:/temp/test.jpg"));

                MaskRCNNDetections detections = ccDetector.detectCorpusCallosum(brainROI.roiImage);
                if (detections!=null) {
                    for (PolygonExt poly: detections.getContours()) {
                        // scale
                        PolygonExt polyScaled =  new PolygonExt();
                        polyScaled.setScale(poly.getScale());
                        for (int i = 0; i < poly.npoints; i++) {
                            polyScaled.addPoint((int) (((poly.xpoints[i] * scaleX1)+brainROI.x1)*scaleX2), (int) (((poly.ypoints[i] * scaleY1)+brainROI.y1)*scaleY2));
                        }
                        polyScaled.setClosed(true);
                        polyScaled.setOnlyPoints(false);

                        // store
                        ImageAnnotation annotation = new ImageAnnotation("Corpus Callosum",polyScaled,ImageAnnotation.SUBTYPE_ROI, Color.magenta);
                        RawAnnotation rawAnnotation = new RawAnnotation();
                        rawAnnotation.setRawDataFileId(rdfId);
                        rawAnnotation.setData(annotation.getData());
                        rawAnnotation.setDescription(annotation.getDescription());
                        rawAnnotation.setUserId("CC-Annotator");
                        rawAnnotation.setModifyDate(new Date());
                        rawAnnotation.setRawAnnotationType(RawAnnotation.ANNOTATION_TYPE_IMAGE);
                        DALConfig.getImageProvider().InsertRawAnnotation(rawAnnotation);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        CorpusCallosumAnnotator annotator = new CorpusCallosumAnnotator();
        annotator.annotate(15573190);
//        List<RawDataFile> rdfList = OrbitHelper.searchImages("ELB0433-0020");
//        for (RawDataFile rdf: rdfList) {
//            System.out.println("annotating image "+rdf.toStringDetail());
//            annotator.annotate(rdf.getRawDataFileId());
//        }
//        System.out.println("done");
    }
}
