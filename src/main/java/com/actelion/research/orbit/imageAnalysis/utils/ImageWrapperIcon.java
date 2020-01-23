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

// TODO: Add ...neon.api.Async... when upgrading to the next Radiance release (>2.5.1)
import org.pushingpixels.neon.AsynchronousLoadListener;
import org.pushingpixels.neon.AsynchronousLoading;
import org.pushingpixels.neon.NeonCortex;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Helper class to load images and expose them as icons of dynamic size.
 *
 * @author Kirill Grouchnikov
 */
abstract class ImageWrapperIcon implements Icon, AsynchronousLoading {
    /**
     * The original image.
     */
    protected BufferedImage originalImage;

    /**
     * The input stream of the original image.
     */
    protected InputStream imageInputStream;

    /**
     * The input stream of the original image.
     */
    protected Image image;

    /**
     * Contains all precomputed images.
     */
    protected Map<String, BufferedImage> cachedImages;

    /**
     * The width of the current image.
     */
    protected int width;

    /**
     * The height of the current image.
     */
    protected int height;

    /**
     * The listeners.
     */
    protected EventListenerList listenerList = new EventListenerList();

    /**
     * Create a new image-wrapper icon.
     *
     * @param inputStream The input stream to read the image from.
     * @param w           The width of the icon.
     * @param h           The height of the icon.
     */
    public ImageWrapperIcon(InputStream inputStream, int w, int h) {
        this.imageInputStream = inputStream;
        this.width = w;
        this.height = h;
        this.listenerList = new EventListenerList();
        this.cachedImages = new LinkedHashMap<String, BufferedImage>() {
            @Override
            protected boolean removeEldestEntry(
                    Map.Entry<String, BufferedImage> eldest) {
                return size() > 5;
            }

            ;
        };
        this.renderImage(this.width, this.height);
    }

    /**
     * Create a new image-wrapper icon.
     *
     * @param image The original image.
     * @param w     The width of the icon.
     * @param h     The height of the icon.
     */
    public ImageWrapperIcon(Image image, int w, int h) {
        this.imageInputStream = null;
        this.image = image;
        this.width = w;
        this.height = h;
        this.listenerList = new EventListenerList();
        this.cachedImages = new LinkedHashMap<String, BufferedImage>() {
            @Override
            protected boolean removeEldestEntry(
                    Map.Entry<String, BufferedImage> eldest) {
                return size() > 5;
            }

            ;
        };
        this.renderImage(this.width, this.height);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.jvnet.flamingo.common.AsynchronousLoading#addAsynchronousLoadListener
     * (org.jvnet.flamingo.common.AsynchronousLoadListener)
     */
    @Override
    public void addAsynchronousLoadListener(AsynchronousLoadListener l) {
        this.listenerList.add(AsynchronousLoadListener.class, l);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.jvnet.flamingo.common.AsynchronousLoading#removeAsynchronousLoadListener
     * (org.jvnet.flamingo.common.AsynchronousLoadListener)
     */
    @Override
    public void removeAsynchronousLoadListener(AsynchronousLoadListener l) {
        this.listenerList.remove(AsynchronousLoadListener.class, l);
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.swing.Icon#getIconWidth()
     */
    @Override
    public int getIconWidth() {
        return width;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.swing.Icon#getIconHeight()
     */
    @Override
    public int getIconHeight() {
        return height;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.swing.Icon#paintIcon(java.awt.Component, java.awt.Graphics,
     * int, int)
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        BufferedImage image = this.cachedImages.get(this.getIconWidth() + ":"
                + this.getIconHeight());
        if (image != null) {
            int dx = (this.width - image.getWidth()) / 2;
            int dy = (this.height - image.getHeight()) / 2;
            g.drawImage(image, x + dx, y + dy, null);
        }
    }

    /**
     * Sets the preferred size for <code>this</code> icon. The rendering is
     * scheduled automatically.
     *
     * @param dim Preferred size.
     */
    public synchronized void setPreferredSize(Dimension dim) {
        if ((dim.width == this.width) && (dim.height == this.height))
            return;
        this.width = dim.width;
        this.height = dim.height;

        this.renderImage(this.width, this.height);
    }

    /**
     * Renders the image.
     *
     * @param renderWidth  Requested rendering width.
     * @param renderHeight Requested rendering height.
     */
    protected synchronized void renderImage(final int renderWidth,
                                            final int renderHeight) {
        String key = renderWidth + ":" + renderHeight;
        if (this.cachedImages.containsKey(key)) {
            fireAsyncCompleted(true);
            return;
        }

        SwingWorker<BufferedImage, Void> worker = new SwingWorker<BufferedImage, Void>() {
            @Override
            protected BufferedImage doInBackground() throws Exception {
                if (imageInputStream != null) {
                    synchronized (imageInputStream) {
                        if (originalImage == null) {
                            // read original image
                            originalImage = ImageIO.read(imageInputStream);
                        }
                    }
                } else {
                    GraphicsEnvironment e = GraphicsEnvironment
                            .getLocalGraphicsEnvironment();
                    GraphicsDevice d = e.getDefaultScreenDevice();
                    GraphicsConfiguration c = d.getDefaultConfiguration();
                    originalImage = c.createCompatibleImage(image
                                    .getWidth(null), image.getHeight(null),
                            Transparency.TRANSLUCENT);
                    Graphics g = originalImage.getGraphics();
                    g.drawImage(image, 0, 0, null);
                    g.dispose();
                }

                BufferedImage result = originalImage;
                float scaleX = (float) originalImage.getWidth()
                        / (float) renderWidth;
                float scaleY = (float) originalImage.getHeight()
                        / (float) height;

                float scale = Math.max(scaleX, scaleY);
                if (scale > 1.0f) {
                    int finalWidth = (int) (originalImage.getWidth() / scale);
                    result = NeonCortex.createThumbnail(originalImage,
                            finalWidth);
                }

                return result;
            }

            @Override
            protected void done() {
                try {
                    BufferedImage bufferedImage = get();
                    cachedImages.put(renderWidth + ":" + renderHeight,
                            bufferedImage);
                    fireAsyncCompleted(true);
                } catch (Exception exc) {
                    fireAsyncCompleted(false);
                }
            }
        };
        worker.execute();
    }

    /**
     * Fires the asynchronous load event.
     *
     * @param event Event object.
     */
    protected void fireAsyncCompleted(Boolean event) {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == AsynchronousLoadListener.class) {
                ((AsynchronousLoadListener) listeners[i + 1]).completed(event);
            }
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.jvnet.flamingo.common.AsynchronousLoading#isLoading()
     */
    @Override
    public synchronized boolean isLoading() {
        BufferedImage image = this.cachedImages.get(this.getIconWidth() + ":"
                + this.getIconHeight());
        return (image == null);
    }
}
