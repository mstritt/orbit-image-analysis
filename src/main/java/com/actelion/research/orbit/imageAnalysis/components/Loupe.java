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

package com.actelion.research.orbit.imageAnalysis.components;

import com.actelion.research.orbit.imageAnalysis.utils.TiledImagePainter;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.ref.WeakReference;

/**
 * Shows a loupe view (currently 100% view) of a TiledImagePainter at a mouse position.<br>
 * Listens to ImageFrame.MOUSE_MOVED_ON_IMAGE propertyChangeEvents.
 */
public class Loupe extends JPanel implements ComponentListener, AncestorListener, PropertyChangeListener {

    private static final long serialVersionUID = 1L;
    protected Point vpPos = new Point(0, 0);
    protected WeakReference<TiledImagePainter> painter = null;
    private WeakReference<ImageFrame> imageFrame = null;
    private double scale = 100d;

    public Loupe() {
        enableEvents(AWTEvent.MOUSE_MOTION_EVENT_MASK |
                AWTEvent.MOUSE_EVENT_MASK | AWTEvent.MOUSE_WHEEL_EVENT_MASK);
        addComponentListener(this);
        addAncestorListener(this);
        addComponentListener(this);
    }

    public void setImage(TiledImagePainter painter) {
        this.painter = new WeakReference<TiledImagePainter>(painter);
        revalidate();
        repaint();
    }

    public void componentHidden(ComponentEvent e) {
    }

    public void componentMoved(ComponentEvent e) {
    }

    public void componentResized(ComponentEvent e) {
        if (painter == null || painter.get() == null) return;
        int w = this.getWidth();
        if (w < 10) w = 10;
        int newHeight = (int) (w * ((double) painter.get().getHeight() / painter.get().getWidth()));
        setPreferredSize(new Dimension(w, newHeight));
        //setMinimumSize(new Dimension(w, newHeight));
        repaint();
    }

    public void componentShown(ComponentEvent e) {
    }

    public void ancestorAdded(AncestorEvent event) {
    }

    public void ancestorMoved(AncestorEvent event) {
        componentResized(null);
    }

    public void ancestorRemoved(AncestorEvent event) {
    }


    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(ImageFrame.MOUSE_MOVED_ON_IMAGE)) {
            if ((evt.getSource() instanceof ImageFrame) && ((imageFrame == null) || evt.getSource() != imageFrame.get())) {
                imageFrame = new WeakReference<ImageFrame>((ImageFrame) evt.getSource());
                setImage(imageFrame.get().recognitionFrame.bimg);
            }
            vpPos = ((Point) evt.getNewValue());
            repaint();
        } else if (evt.getPropertyName().equals(ImageFrame.SCALE_EVENT)) {
            repaint();
        }

    }


    public void paint(Graphics g) {
        if (painter == null || painter.get() == null) return;
        double sc = scale / 100d;
        //if (imageFrame!=null) sc = (imageFrame.recognitionFrame.getScale()/100d)*3; // relativ to view
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_SPEED);
        Rectangle bounds = this.getBounds();
        g2d.setColor((Color) UIManager.get("Panel.background"));
        g2d.fillRect(0, 0, bounds.width, bounds.height);
        int posX = (int) (vpPos.x * sc) - (getWidth() / 2);
        int posY = (int) (vpPos.y * sc) - (getHeight() / 2);
        g2d.translate(-posX, -posY);
        g2d.scale(sc, sc);
        painter.get().drawImage(g2d, posX, posY, getWidth(), getHeight(), sc * 100d, -1);
        g2d.dispose();
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }


}
