/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
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

import org.pushingpixels.flamingo.api.common.icon.ResizableIcon;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Implementation of {@link ResizableIcon} interface that wraps image files.
 *
 * @author Kirill Grouchnikov
 */
public class ImageWrapperResizableIcon extends ImageWrapperIcon implements
        ResizableIcon {
    /**
     * Returns the icon for the specified URL.
     *
     * @param image      Image.
     * @param initialDim Initial dimension of the icon.
     * @return Icon instance.
     */
    public static ImageWrapperResizableIcon getIcon(Image image,
                                                    Dimension initialDim) {
        return new ImageWrapperResizableIcon(image, initialDim);
    }

    /**
     * Returns the icon for the specified URL.
     *
     * @param location   Icon URL.
     * @param initialDim Initial dimension of the icon.
     * @return Icon instance.
     */
    public static ImageWrapperResizableIcon getIcon(URL location,
                                                    Dimension initialDim) {
        try {
            return new ImageWrapperResizableIcon(location.openStream(),
                    initialDim);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        }
    }

    /**
     * Returns the icon for the specified input stream.
     *
     * @param inputStream Icon input stream.
     * @param initialDim  Initial dimension of the icon.
     * @return Icon instance.
     */
    public static ImageWrapperResizableIcon getIcon(InputStream inputStream,
                                                    Dimension initialDim) {
        return new ImageWrapperResizableIcon(inputStream, initialDim);
    }

    /**
     * Creates a new image-based resizable icon.
     *
     * @param image      Image.
     * @param initialDim Initial dimension of the icon.
     */
    private ImageWrapperResizableIcon(Image image, Dimension initialDim) {
        super(image, initialDim.width, initialDim.height);
    }

    /**
     * Creates a new image-based resizable icon.
     *
     * @param inputStream Input stream with the image content.
     * @param initialDim  Initial dimension of the icon.
     */
    private ImageWrapperResizableIcon(InputStream inputStream,
                                      final Dimension initialDim) {
        super(inputStream, initialDim.width, initialDim.height);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.jvnet.flamingo.common.icon.ResizableIcon#setDimension(java.awt.Dimension
     * )
     */
    @Override
    public void setDimension(Dimension dim) {
        this.setPreferredSize(dim);
    }
}
