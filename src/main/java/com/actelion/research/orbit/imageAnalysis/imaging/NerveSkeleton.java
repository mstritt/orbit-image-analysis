/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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

import com.actelion.research.orbit.imageAnalysis.models.NerveDetectionParams;
import ij.ImagePlus;
import ij.plugin.filter.UnsharpMask;
import ij.process.*;
import imageJ.BinaryOrbit;
import imageJ.IJHysteresis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.media.jai.PlanarImage;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Skeleton algorithm to segment connected objects.
 * Can only handle images where width*size<=6000*6000 pixel. Should be applied on a tile, not the whole image!
 */
public class NerveSkeleton {

    private final static Logger logger = LoggerFactory.getLogger(NerveSkeleton.class);
    private UnsharpMask unsharpMask = new UnsharpMask();
    private IJHysteresis hysteresis = new IJHysteresis();
    private BinaryOrbit binary = new BinaryOrbit();

    public PlanarImage process(final PlanarImage image, Color bg, Color fg, NerveDetectionParams params) {
        if (image == null || (image.getWidth() * image.getHeight() > 6000 * 6000L))
            throw new IllegalArgumentException("this implementation can only handle images where width*height<=6000*6000. (And image cannot be null)");

        logger.debug("nerve skeleton start");

        // ImageJ implementation
        ImagePlus ip = new ImagePlus("nerveskeleton", image.getAsBufferedImage());
        ip.getProcessor().smooth();
        logger.trace("smooth ok");
        ip.getProcessor().gamma(params.getGamma());
        logger.trace("gamma ok");

        // fluo image preprocessing: extract red channel and invert
        if (params.isFluoImage()) {
            logger.debug("fluorescence image (extract red channel and invert)");
            ColorProcessor cp = ((ColorProcessor) ip.getProcessor());
            ByteProcessor bp = cp.getChannel(1, null);
            ip.setProcessor(bp);
            ip.getProcessor().invert();
            logger.trace("fluo red channel extraction and invert ok");
        }
        ImageProcessor imageProc = ip.getProcessor().convertToFloat();
        imageProc.snapshot();
        unsharpMask.sharpenFloat((FloatProcessor) imageProc, params.getUnsharpMaskThrethold1(), params.getUnsharpMaskThrethold2());
        logger.trace("unsharpMask ok");
        imageProc = imageProc.convertToRGB();
        imageProc = hysteresis.runNerveDetection(imageProc, params.getEdgeDetectionthreshold1(), params.getEdgeDetectionthreshold2()); // 100,50
        logger.trace("hysteresis ok");
        BinaryProcessor bp = new BinaryProcessor((ByteProcessor) imageProc);
        // close- = dilate+erode
        bp.dilate();
        bp.erode(); // 1,255
        logger.trace("close- ok");
        // fill holes
        binary.fill(bp, 0, 255);
        logger.trace("fill ok");
        binary.skeletonize(bp);
        logger.trace("skeletonize ok");


        int[] p = new int[4];
        int bgRGB = new Color(bg.getRed(), bg.getGreen(), bg.getBlue()).getRGB();
        int fgRGB = new Color(fg.getRed(), fg.getGreen(), fg.getBlue()).getRGB();
        BufferedImage bi = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                p = bp.getPixel(x, y, p);
                if (p[0] == 0) bi.setRGB(x, y, fgRGB);  // since it is a binary image, we only check the red channel
                else bi.setRGB(x, y, bgRGB);
            }
        }

        logger.debug("nerve skeleton really end");

        return PlanarImage.wrapRenderedImage(bi);
    }


}
