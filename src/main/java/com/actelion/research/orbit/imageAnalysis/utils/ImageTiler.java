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

package com.actelion.research.orbit.imageAnalysis.utils;

import javax.media.jai.ImageLayout;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.renderable.ParameterBlock;
import java.util.Iterator;

public class ImageTiler implements Iterable<BufferedImage> {

    private PlanarImage tiledImage;

    public ImageTiler(final PlanarImage oriImage, final int tileWidth, final int tileHeight) {
        this.tiledImage = makeTiledImage(oriImage,tileWidth,tileHeight);
    }

    private PlanarImage makeTiledImage(PlanarImage img, int tileWidth, int tileHeight) {
        ImageLayout tileLayout = new ImageLayout(img);
        tileLayout.setTileWidth(tileWidth);
        tileLayout.setTileHeight(tileHeight);
        tileLayout.setSampleModel(img.getColorModel().createCompatibleSampleModel(tileWidth,tileHeight));
        tileLayout.setColorModel(img.getColorModel());
        RenderingHints tileHints = new RenderingHints(JAI.KEY_IMAGE_LAYOUT, tileLayout);
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(img);
        PlanarImage pi = JAI.create("format", pb, tileHints);
        pi.getWidth();
        return pi;
    }

    public Point[] getTileIndices() {
        return tiledImage.getTileIndices(null);
    }

    public PlanarImage getTiledImage() {
        return tiledImage;
    }

    @Override
    public Iterator<BufferedImage> iterator() {
        return new Iterator<BufferedImage>() {
            final Point[] tileIndices = tiledImage.getTileIndices(null);
            int idx = 0;
            @Override
            public boolean hasNext() {
                return idx < tileIndices.length;
            }

            @Override
            public BufferedImage next() {
                Point tile = tileIndices[idx++];
                return tiledImage.getAsBufferedImage(tiledImage.getTileRect(tile.x,tile.y),tiledImage.getColorModel());
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove");
            }
        };

                
    }


    public static void main(String[] args) {
        BufferedImage img = new BufferedImage(4000,4000,BufferedImage.TYPE_INT_RGB);
        PlanarImage pi = PlanarImage.wrapRenderedImage(img);
        for (BufferedImage tileImg: new ImageTiler(pi,512,512)) {
            System.out.println(tileImg);
        }

    }
}
