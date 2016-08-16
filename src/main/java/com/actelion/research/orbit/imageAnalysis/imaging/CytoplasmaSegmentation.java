/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2016 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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

package com.actelion.research.orbit.imageAnalysis.imaging;

import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.models.ClassShape;
import com.actelion.research.orbit.imageAnalysis.models.SegmentationResult;
import com.actelion.research.orbit.imageAnalysis.tasks.ObjectSegmentationWorker;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.imageAnalysis.utils.TiledImagePainter;
import com.actelion.research.orbit.imageAnalysis.utils.TiledImageWriter;
import ij.ImagePlus;
import ij.plugin.filter.EDM;
import ij.process.BinaryProcessor;
import ij.process.ByteProcessor;
import imageJ.ThresholderOrbit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.media.jai.PlanarImage;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Uses ImageJ voronoi algorithm to segment cell boundaries (cytoplasma) based on a primary segmentation (nuclei).
 */
public class CytoplasmaSegmentation {

    private final static Logger logger = LoggerFactory.getLogger(CytoplasmaSegmentation.class);

    public SegmentationResult process(final PlanarImage image) {
        if (image == null || (image.getWidth() * image.getHeight() > 6000 * 6000L))
            throw new IllegalArgumentException("this implementation can only handle images where width*height<=6000*6000. (And image cannot be null)");

        logger.debug("voronoi start");

        // ImageJ implementation
        ImagePlus ip = new ImagePlus("skeleton", image.getAsBufferedImage());

        ThresholderOrbit thresholder = new ThresholderOrbit();
        thresholder.applyThreshold(ip);

        ip.getProcessor().convertToByte(false);

        BinaryProcessor bp = new BinaryProcessor((ByteProcessor) ip.getProcessor());

        EDM edm = new EDM();
        edm.toWatershed(bp);

        edm.setup("voronoi", ip);
        edm.run(bp);

        bp.threshold(0);

        bp.dilate();
        bp.dilate();
//		bp.dilate();
        logger.debug("voronoi end");

        // make recognitionFrame for segmentation
        TiledImagePainter tip = new TiledImagePainter(PlanarImage.wrapRenderedImage(bp.getBufferedImage()), "vronoiImage");
        List<ClassShape> classShapes = new ArrayList<ClassShape>(2);
        classShapes.add(new ClassShape("Background", Color.black, ClassShape.SHAPETYPE_POLYGONEXT));
        classShapes.add(new ClassShape("Foreground", Color.white, ClassShape.SHAPETYPE_POLYGONEXT));

        TiledImageWriter tiw = new TiledImageWriter(PlanarImage.wrapRenderedImage(bp.convertToRGB().getBufferedImage()));

        RecognitionFrame rf = new RecognitionFrame(tip);
        rf.setClassImage(tiw);
        rf.getClassShapes().clear();
        rf.getClassShapes().addAll(classShapes);
        rf.setRatio(new double[rf.getClassShapes().size()]);
        rf.initializeClassColors();

        ObjectSegmentationWorker seg = new ObjectSegmentationWorker(rf, null, classShapes, null);
        seg.setDontClassify(true);
        seg.setDoWatershed(false);
        seg.setNumThreads(1);
        seg.setWithGUI(false);
        seg.run();
        SegmentationResult segRes = seg.getSegmentationResult();
        logger.debug("cytoplasma segmentation count: " + segRes.getObjectCount());
        //return PlanarImage.wrapRenderedImage(bp.getBufferedImage());
        return segRes;
    }

    public static void main(String[] args) throws Exception {
        OrbitUtils.getTag();
        BufferedImage bi = ImageIO.read(new File("d:/nuclei.jpg"));
        PlanarImage pi = PlanarImage.wrapRenderedImage(bi);
        CytoplasmaSegmentation seg = new CytoplasmaSegmentation();
        SegmentationResult res = seg.process(pi);
    }


}
