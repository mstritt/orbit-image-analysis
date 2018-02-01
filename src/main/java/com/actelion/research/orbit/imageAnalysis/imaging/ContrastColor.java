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

package com.actelion.research.orbit.imageAnalysis.imaging;

import com.actelion.research.orbit.imageAnalysis.utils.TiledImagePainter;

import javax.media.jai.JAI;
import javax.media.jai.LookupTableJAI;
import javax.media.jai.PlanarImage;
import java.awt.image.renderable.ParameterBlock;

public class ContrastColor implements IImageManipulation {

    private PlanarImage source;
    private TiledImagePainter tip = null;
    private int red, green, blue;
    private float contrast, brightness;
    private int contrastOffs = 200;
    private boolean contrastOffsSet = false;
    private boolean parameterSet = false;
    private boolean setRenderingHints = true;

    public ContrastColor() {

    }

    /**
     * Adjusts contrast and color shift. TiledImagePainter can be null (it will only be used for big images to get a lowres image for computing the extrema).
     *
     * @param source
     * @param tip
     * @param red
     * @param green
     * @param blue
     * @param contrast
     * @param brightness
     */
    public ContrastColor(PlanarImage source, TiledImagePainter tip, int red, int green, int blue, float contrast, float brightness, boolean setRenderingHints) {
        this.source = source;
        this.tip = tip;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.contrast = contrast;
        this.brightness = brightness;
        this.setRenderingHints = setRenderingHints;
        parameterSet = true;
    }

    public void setParameter(PlanarImage source, TiledImagePainter tip, int red, int green, int blue, float contrast, float brightness, boolean setRenderingHints) {
        this.source = source;
        this.tip = tip;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.contrast = contrast;
        this.brightness = brightness;
        this.setRenderingHints = setRenderingHints;
        parameterSet = true;
    }

    public PlanarImage process() {
        if (!parameterSet) throw new IllegalStateException("parameter not set");
        if (!contrastOffsSet) {
            PlanarImage img4mean = source;
            if (tip != null && tip.hasMipMaps()) {
                img4mean = tip.getMipMaps()[tip.getMipMaps().length - 1].getImage();
            }
            //if ((long) img4mean.getWidth() * img4mean.getHeight() < (long) 2500L * 2500L)
            {
                final int numScan = 200;
                int skipW = img4mean.getWidth() / numScan;
                int skipH = img4mean.getHeight() / numScan;
                ParameterBlock mpb = new ParameterBlock();
                mpb.addSource(img4mean); // The source image
                mpb.add(null); // null ROI means whole image
                mpb.add(skipW); // 1 check every pixel horizontally
                mpb.add(skipH); // 1 check every pixel vertically

                // Perform the mean operation on the source image
                PlanarImage meanImage = JAI.create("mean", mpb, null);
                // Retrieve the mean pixel value
                double[] mean = (double[]) meanImage.getProperty("mean");
                // Average the mean of all bands
                double sum = 0.0D;
                for (int i = 0; i < mean.length; i++) {
                    sum += mean[i];
                }
                int average = (int) sum / mean.length;
                contrastOffs = average;
                contrastOffsSet = true;
            }
        }
        int average = contrastOffs;


        // Create the lookup table based on the average mean
        byte[][] lut = new byte[3][256];
        for (int i = 0; i < 256; i++) {
            lut[0][i] = ManipulationUtils.clamp((average + (int) ((i - average) * contrast)) + red + (int) brightness);
            lut[1][i] = ManipulationUtils.clamp((average + (int) ((i - average) * contrast)) + green + (int) brightness);
            lut[2][i] = ManipulationUtils.clamp((average + (int) ((i - average) * contrast)) + blue + (int) brightness);

        }
        LookupTableJAI lookup = new LookupTableJAI(lut);
        // Setup the parameter block for the lookup operation
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(source);
        pb.add(lookup);

        // Return the resulting image
        if (setRenderingHints)
            return JAI.create("lookup", pb, ManipulationUtils.getRenderingHints(source));
        else return JAI.create("lookup", pb);
    }


}
