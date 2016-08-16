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

package com.actelion.research.orbit.imageAnalysis.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

@Deprecated
public class ImageFrameFullScreen extends JWindow {

    private static final long serialVersionUID = 1L;
    private final static Logger logger = LoggerFactory.getLogger(ImageFrameFullScreen.class);
    private ImageFrame newFrame = null;
    private RenderGrid grid = null;

    public ImageFrameFullScreen(ImageFrame frame, Point2D offs, double scale) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension size = toolkit.getScreenSize();
        offs.setLocation(offs.getX() - (size.width / 2d), offs.getY() - (size.height / 2d));
        RecognitionFrame rf;
        try {
            rf = new RecognitionFrame(frame.recognitionFrame, true);
            newFrame = new ImageFrame(rf);
            newFrame.setExclusive(true);
            rf.setViewPortSize(size);
            rf.setViewPortOffset(offs);
            rf.setScale(scale);

            newFrame.getOpacitySlider().setVisible(false);

            setLayout(null);
            newFrame.getRootPane().setSize(size);
            newFrame.getRootPane().setBounds(0, 0, size.width, size.height);
            add(newFrame.getRootPane());

            //	grid = renderGrid;

//		grid = new RenderGrid(newFrame.recognitionFrame.bimg);
//		grid.setImageSize(new Dimension(newFrame.recognitionFrame.bimg.image.getWidth(),newFrame.recognitionFrame.bimg.image.getHeight()));
//		grid.setBounds(/*size.width*/1000-200,0,200,200);
            //	add(grid);

            //setSize(size);
            //setBounds(0, 0, size.width, size.height);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("error: ", e);
        }
    }

    public ImageFrame getNewFrame() {
        return newFrame;
    }

	/*
    @Override
	public void paint(Graphics g) {
		//super.paint(g);
		Graphics2D g2d = (Graphics2D)g.create();
		newFrame.getRootPane().paintAll(g2d);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
		grid.paint(g2d);  
	}
	*/

	/*
    public void mouseWheelMoved(MouseWheelEvent event) {
		if (newFrame!=null) {
			//newFrame.processMouseWheelEvent(event);
			//newFrame.adjustViewport();
			firePropertyChange(ImageFrame.SCALE_SET_EVENT, null, newFrame.recognitionFrame.getScale());
		}
	}
	*/


}
