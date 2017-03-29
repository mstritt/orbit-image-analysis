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

import ij.ImagePlus;
import ij.measure.Measurements;
import ij.plugin.ContrastEnhancer;
import ij.process.ImageStatistics;

import javax.media.jai.BorderExtender;
import javax.media.jai.PlanarImage;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

public class ContrastEnhancerThumbnail {

    private BorderExtender border = BorderExtender.createInstance(BorderExtender.BORDER_COPY);
    private ContrastEnhancer contrastEnhancer = new ContrastEnhancer();
    private static double d = 0.05d;

    /**
     * Enhance contrast in low-contrast thumbnail images.
     *
     * @param img
     * @return BufferedImage
     */
    public BufferedImage enhanceContrast(BufferedImage img) {
        ImagePlus ip = ManipulationUtils.toImagePlus(PlanarImage.wrapRenderedImage(img), null, border);
        ImageStatistics stats = ImageStatistics.getStatistics(ip.getProcessor(), Measurements.MIN_MAX, null);
        double diff = Math.abs(stats.max - stats.min);
        stats.histMin = Math.max(8, stats.histMin);
        if (diff < 80 && diff > 4) {
            contrastEnhancer.stretchHistogram(ip.getProcessor(), d, stats);
            img = ManipulationUtils.toPlanarImage(ip.getProcessor()).getAsBufferedImage();
        }
        return img;
    }

    /**
     * Enhance contrast in low-contrast thumbnail images.
     *
     * @param img
     * @return RenderedImage
     */
    public RenderedImage enhanceContrast(RenderedImage img) {
        ImagePlus ip = ManipulationUtils.toImagePlus(PlanarImage.wrapRenderedImage(img), null, border);
        ImageStatistics stats = ImageStatistics.getStatistics(ip.getProcessor(), Measurements.MIN_MAX, null);
        double diff = Math.abs(stats.max - stats.min);
        stats.histMin = Math.max(8, stats.histMin);
        if (diff < 80 && diff > 10) {
            contrastEnhancer.stretchHistogram(ip.getProcessor(), d, stats);
            img = ManipulationUtils.toPlanarImage(ip.getProcessor()).getAsBufferedImage();
        }
        return img;
    }


}
