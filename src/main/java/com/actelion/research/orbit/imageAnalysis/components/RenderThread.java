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

package com.actelion.research.orbit.imageAnalysis.components;

import com.actelion.research.orbit.imageAnalysis.utils.TiledImagePainter;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class RenderThread extends Thread {

    public final static String RENDERBUFFER_READY = "renderThread.RenderbufferReady";
    //private VolatileImage imageBuffer = null;
    private BufferedImage imageBuffer = null;
    private boolean bufferRendering = false;
    private boolean bufferReady = false;
    private double viewPortWidth = 0;
    private double viewPortHeight = 0;
    private double viewPortOffsetX = 0;
    private double viewPortOffsetY = 0;
    private double scale = 0; // 0..100
    private WeakReference<TiledImagePainter> tiledImagePainter = null;
    private boolean scheduleUpdate = false;
    private boolean valuesDirty = false;
    private Component parentComponent = null;
    private List<PropertyChangeListener> pcListeners = null;

    public RenderThread(Component parent) {
        setPriority(Thread.NORM_PRIORITY);
        setDaemon(true);
        this.parentComponent = parent;
    }

    protected void firePropertyChangeEvent(PropertyChangeEvent event) {
        if (pcListeners != null) {
            for (PropertyChangeListener pcl : pcListeners) {
                pcl.propertyChange(event);
            }
        }
    }

    /**
     * adds a propertyChangeListener. The listeners will be notified if CLASSIFICATION_PROGRESS changes.
     *
     * @param propertyChangeListener
     */
    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        if (pcListeners == null) pcListeners = new ArrayList<PropertyChangeListener>();
        pcListeners.add(propertyChangeListener);
    }

    /**
     * removes a propertyChangeListener. If this listener not exists in the propertyChangeListeners list then
     * nothing will be done.
     *
     * @param propertyChangeListener
     */
    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        if (pcListeners == null) return;
        pcListeners.remove(propertyChangeListener);
    }


    public void run() {
        while (/*!interrupted()*/!Thread.interrupted()) {
            if (scheduleUpdate) {
                if (update())
                    scheduleUpdate = false;
            } else {
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                }
            }
        }
    }


    private synchronized boolean update() {
        if (tiledImagePainter == null) return false;
        TiledImagePainter tpGet = tiledImagePainter.get();
        if (tpGet == null) return false;
        bufferReady = false;
        bufferRendering = true;
        valuesDirty = false;
        if (viewPortWidth <= 0 || viewPortHeight <= 0 || scale == 0d || tiledImagePainter == null || (scale >= 100)) {
            bufferRendering = false;
            return true;
        }
        try {
            imageBuffer = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().createCompatibleImage((int) viewPortWidth, (int) viewPortHeight, Transparency.OPAQUE);
            //imageBuffer = new BufferedImage(viewPortWidth, viewPortHeight, BufferedImage.TYPE_INT_RGB);
            //imageBuffer = parentComponent.createVolatileImage(viewPortWidth, viewPortHeight);

            Graphics2D gBuffer = imageBuffer.createGraphics();
            gBuffer.setColor((Color) UIManager.get("Panel.background"));
            gBuffer.fillRect(0, 0, (int) viewPortWidth, (int) viewPortHeight);
            gBuffer.translate(-viewPortOffsetX, -viewPortOffsetY);
            gBuffer.scale((scale / 100d), (scale / 100d));
            if (!isInterrupted() && (!valuesDirty))
                tpGet.drawImage(gBuffer, viewPortOffsetX, viewPortOffsetY, viewPortWidth, viewPortHeight, scale, -1);
            gBuffer.dispose();
            if (!isInterrupted()) {
                bufferReady = true;
                bufferRendering = false;
                if (!valuesDirty) {
                    firePropertyChangeEvent(new PropertyChangeEvent(this, RenderThread.RENDERBUFFER_READY, null, imageBuffer));
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            return false; // e.g. volatilImage not ready
        }
        return true;
    }


    public Image getImageBuffer() {
        return imageBuffer;
    }


    public boolean isBufferRendering() {
        return bufferRendering;
    }


    public boolean isBufferReady() {
        return bufferReady;
    }


    public double getViewPortWidth() {
        return viewPortWidth;
    }


    public double getViewPortHeight() {
        return viewPortHeight;
    }


    public double getViewPortOffsetX() {
        return viewPortOffsetX;
    }


    public double getViewPortOffsetY() {
        return viewPortOffsetY;
    }


    public double getScale() {
        return scale;
    }


    public TiledImagePainter getTiledImagePainter() {
        return tiledImagePainter.get();
    }


    public void setBufferRendering(boolean bufferRendering) {
        this.bufferRendering = bufferRendering;
    }


    public void setBufferReady(boolean bufferReady) {
        this.bufferReady = bufferReady;
    }


    public void setViewPortWidth(double viewPortWidth) {
        this.viewPortWidth = viewPortWidth;
    }


    public void setViewPortHeight(double viewPortHeight) {
        this.viewPortHeight = viewPortHeight;
    }


    public void setViewPortOffsetX(double viewPortOffsetX) {
        this.viewPortOffsetX = viewPortOffsetX;
    }


    public void setViewPortOffsetY(double viewPortOffsetY) {
        this.viewPortOffsetY = viewPortOffsetY;
    }


    public void setScale(double scale) {
        this.scale = scale;
    }


    public void setTiledImagePainter(TiledImagePainter tiledImagePainter) {
        this.tiledImagePainter = new WeakReference<TiledImagePainter>(tiledImagePainter);
    }

    public void setScheduleUpdate(boolean scheduleUpdate) {
        this.scheduleUpdate = scheduleUpdate;
    }

    public boolean isScheduleUpdate() {
        return scheduleUpdate;
    }

    public boolean isValuesDirty() {
        return valuesDirty;
    }

    public void setValuesDirty(boolean valuesDirty) {
        this.valuesDirty = valuesDirty;
    }


}
