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

package com.actelion.research.orbit.imageAnalysis.utils;

import com.actelion.research.orbit.imageAnalysis.components.ImageFrame;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame.Tools;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Point2D;
import java.lang.ref.WeakReference;


public class ViewPortScrollListener extends MouseInputAdapter {

    private WeakReference<RecognitionFrame> recognitionFrame = null;
    private WeakReference<ImageFrame> iFrame = null;
    private Point2D startDrag = null;
    private Point2D vpOffsDragStart = new Point2D.Double(0, 0);

    public ViewPortScrollListener(RecognitionFrame recognitionFrame, ImageFrame iFrame) {
        super();
        this.recognitionFrame = new WeakReference<RecognitionFrame>(recognitionFrame);
        this.iFrame = new WeakReference<ImageFrame>(iFrame);
    }

    public void mousePressed(MouseEvent e) {
        if (recognitionFrame == null || recognitionFrame.get() == null) return;
        if (!acceptTool(recognitionFrame.get().getSelectedTool())) return;
        startDrag = new Point(e.getX(), e.getY());
        vpOffsDragStart = recognitionFrame.get().getViewPortOffset();
    }

    public void mouseDragged(MouseEvent e) {
        if (recognitionFrame == null || recognitionFrame.get() == null) return;
        if (iFrame == null || iFrame.get() == null) return;
        if (!acceptTool(recognitionFrame.get().getSelectedTool())) return;
        if (startDrag == null) return;

        double x = e.getX();
        double y = e.getY();
        double vpDiffX = vpOffsDragStart.getX() - recognitionFrame.get().getViewPortOffset().getX();
        double vpDiffY = vpOffsDragStart.getY() - recognitionFrame.get().getViewPortOffset().getY();
        x -= vpDiffX;
        y -= vpDiffY;

        Point2D diff = new Point2D.Double(startDrag.getX() - x, startDrag.getY() - y);
        recognitionFrame.get().addViewPortOffset(diff);
        //recognitionFrame.repaint();
        iFrame.get().adjustViewport();
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
        if (recognitionFrame == null || recognitionFrame.get() == null) return;
        if (iFrame == null || iFrame.get() == null) return;
        if (iFrame.get().recognitionFrame == null) return;
        double x = e.getX() + recognitionFrame.get().getViewPortOffset().getX();
        double y = e.getY() + recognitionFrame.get().getViewPortOffset().getY();
        double sc = iFrame.get().recognitionFrame.getScale() / 100d;
        // viewPosition is already included in the mouse-coordinates!
        Point realPos = new Point((int) (x / sc), (int) (y / sc));
        iFrame.get().firePropertyChangeExt(ImageFrame.MOUSE_MOVED_ON_IMAGE, null, realPos);
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        if (recognitionFrame == null || recognitionFrame.get() == null) return;
        if (iFrame == null || iFrame.get() == null) return;
        if (!acceptTool(recognitionFrame.get().getSelectedTool())) return;
        iFrame.get().firePropertyChangeExt(ImageFrame.SCALE_EVENT, null, new Double(e.getWheelRotation()));
        e.consume();
        //PropertyChangeEvent event = new PropertyChangeEvent(this, ImageFrame.SCALE_EVENT, null, e.getWheelRotation());
        //iFrame.propertyChange(event);

    	  /*
                 recognitionFrame.setOldScale(recognitionFrame.getScale());
    		  double newScale = Math.max(1d,recognitionFrame.getScale()+e.getWheelRotation()*10d);
    		  recognitionFrame.setScale(newScale);
    		  recognitionFrame.scaleImage(newScale, iFrame);
    		  iFrame.adjustViewport();
    	 */
              /*
    		  if (scaleSlider!=null) 
    		  {
    			  scaleSlider.setValue((int)newScale);
    			  scaleSlider.repaint();
    		  }
    		  */
    }

    private boolean acceptTool(Tools tool) {
        return tool.equals(Tools.finger);
    }

    public ImageFrame getiFrame() {
        return iFrame.get();
    }

    public void setiFrame(ImageFrame iFrame) {
        this.iFrame = new WeakReference<ImageFrame>(iFrame);
    }


}
