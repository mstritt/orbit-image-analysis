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

package com.actelion.research.orbit.imageAnalysis.components;

import com.actelion.research.orbit.imageAnalysis.imaging.ContrastEnhancerThumbnail;
import com.actelion.research.orbit.imageAnalysis.utils.TiledImagePainter;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.lang.ref.WeakReference;

public class RenderGrid extends JPanel implements ComponentListener, AncestorListener {
    private static final long serialVersionUID = 1L;
    protected Point2D vpPos = new Point2D.Double(0, 0);
    protected Rectangle2D currentShape;
    protected double panX = 0, panY = 0;
    protected int thumbWidth = 0;
    protected int thumbHeight = 0;
    protected Dimension vpSize;
    protected Dimension imageSize;
    protected Dimension originalImageSize;
    protected double scale = 1.0d; // 0..1
    protected double dragx = 0;
    protected double dragy = 0;
    protected int iOffsX = 0;
    protected int iOffsY = 0;
    protected int oldWidth = 0;
    protected int oldHeight = 0;
    private boolean showCross = false;
    private final int crossSize = 10;
    private final Stroke crossStroke = new BasicStroke(2);

    protected boolean dragOn = false;
    private Point scrollAnchor = new Point(0, 0);
    protected AffineTransform atx = new AffineTransform();
    protected BufferedImage image = null;
    protected WeakReference<TiledImagePainter> fullImage = null;
    protected SpotImagePanel spotPanel = null;
    private ContrastEnhancerThumbnail contrastEnhancer = new ContrastEnhancerThumbnail();

    public RenderGrid(TiledImagePainter fullImage) {
        enableEvents(AWTEvent.MOUSE_MOTION_EVENT_MASK |
                AWTEvent.MOUSE_EVENT_MASK | AWTEvent.MOUSE_WHEEL_EVENT_MASK);
        this.fullImage = new WeakReference<TiledImagePainter>(fullImage);
        addComponentListener(this);
        addAncestorListener(this);
        setPreferredSize(new Dimension(-1, 250));
    }

    private Dimension getViewportDimension() {
        return new Dimension(thumbWidth, thumbHeight);
    }

    public void setViewportSize(Dimension size) {
        vpSize = size;
    }


    public Dimension getImageSize() {
        return imageSize;
    }

    public void setImageSize(Dimension imageSize) {
        this.imageSize = imageSize;
        originalImageSize = new Dimension(imageSize.width, imageSize.height);
    }

    /**
     * scale 0..1
     *
     * @return
     */
    public double getScale() {
        return scale;
    }

    /**
     * scale 0..1
     *
     * @param scale
     */
    public void setScale(double scale) {
        if (originalImageSize == null) return;
        this.scale = scale;
        imageSize = new Dimension((int) (originalImageSize.width * scale), (int) (originalImageSize.height * scale));
    }

    public void processMouseEvent(MouseEvent e) {
        switch (e.getID()) {
            case MouseEvent.MOUSE_PRESSED:
                setCursor(new Cursor(Cursor.MOVE_CURSOR));
                int x = e.getX();
                int y = e.getY();
                dragx = 0;
                dragy = 0;
                if (currentShape != null && currentShape.contains(x, y)) {
                    dragOn = true;
                } else { // set vpPos to mouse position and update view (simulate drag)
                    int vpWid, vpHt;
                    if (vpSize == null) {
                        vpWid = thumbWidth;
                        vpHt = thumbHeight;
                    } else {
                        vpWid = (int) (vpSize.width * ((double) thumbWidth / imageSize.width));
                        vpHt = (int) (vpSize.height * ((double) thumbHeight / imageSize.height));
                    }
                    vpPos.setLocation(e.getX() - (vpWid / 2) - iOffsX, e.getY() - (vpHt / 2) - iOffsY);    // clicking outside the vp: iOffs has to be considered
                    dragOn = true;
                    // update view (copied from processMouseMotionEvent)
                    if (dragx == 0) {
                        dragx = (int) Math.abs(vpPos.getX() - e.getX());
                        dragy = (int) Math.abs(vpPos.getY() - e.getY());
                    }
                    scroll(e.getX() - dragx, e.getY() - dragy);

                }
                break;
            case MouseEvent.MOUSE_CLICKED:
                break;
            case MouseEvent.MOUSE_RELEASED:
                setCursor(Cursor.getDefaultCursor());
                dragOn = false;
                break;
        }
    }

    public void processMouseMotionEvent(MouseEvent e) {
        switch (e.getID()) {
            case MouseEvent.MOUSE_DRAGGED:
                if (dragOn) {
                    if (dragx == 0) {
                        dragx = (int) Math.abs(vpPos.getX() - e.getX());
                        dragy = (int) Math.abs(vpPos.getY() - e.getY());
                    }
                    scroll(e.getX() - dragx, e.getY() - dragy);
                }
                break;
        }

    }


    public void processMouseWheelEvent(MouseWheelEvent e) {
        firePropertyChange(ImageFrame.SCALE_EVENT, null, new Double(e.getWheelRotation()));
    }
   
   /*
   private void stopScroll(){ setCursor(Cursor.getDefaultCursor());}

   private void startScroll(int x, int y){
      if(dragOn) return;
      scrollAnchor.x = x - panX;
      scrollAnchor.y = y - panY;
      repaint();
   }
   */

    private void scroll(double x, double y) {
        panX = x - scrollAnchor.x;
        panY = y - scrollAnchor.y;
        setPan(new Point2D.Double(panX, panY));
        repaint();
    }

    private void setPan(Point2D pos) {
        if (OrbitImageAnalysis.getInstance().getIFrame() == null) return;
        Point2D vpPoint = new Point2D.Double((pos.getX() / ((double) thumbWidth / imageSize.width)), (pos.getY() / ((double) thumbHeight / imageSize.height)));
        this.vpPos = new Point((int) (pos.getX()), (int) (pos.getY()));
        //firePropertyChange("viewPortPosition",null, vpPoint);
        //repaint();
        if (OrbitImageAnalysis.getInstance().isSyncFrames()) {
            if (OrbitImageAnalysis.getInstance().getIFrame() != null) {
                for (ImageFrame iFrame : OrbitImageAnalysis.getInstance().getIFrames()) {
                    iFrame.setViewPortPositionAndAdjust(vpPoint);
                }
            }
        } else {
            ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
            if (iFrame != null) iFrame.setViewPortPositionAndAdjust(vpPoint);
        }
    }

    public void setViewportPosition(Point2D vpPos) {
        if (OrbitImageAnalysis.getInstance().getIFrame() == null) return;
        if (imageSize != null)
            this.vpPos = new Point2D.Double((vpPos.getX() * ((double) thumbWidth / imageSize.width)), (vpPos.getY() * ((double) thumbHeight / imageSize.height)));

        // sync frames
        if (OrbitImageAnalysis.getInstance().isSyncFrames()) {
            if (OrbitImageAnalysis.getInstance().getIFrame() != null) {
                for (ImageFrame iFrame : OrbitImageAnalysis.getInstance().getIFrames()) {
                    if (!iFrame.isSelected()) {
                        iFrame.recognitionFrame.setViewPortOffset(vpPos);
                        iFrame.repaint();
                    }
                }
            }
        }

        repaint();
    }


    public void componentHidden(ComponentEvent e) {
    }

    public void componentMoved(ComponentEvent e) {
    }

    public void componentResized(ComponentEvent e) {
        image = null;
        revalidate();
        repaint();
    }

    public void ancestorAdded(AncestorEvent arg0) {
    }

    public void ancestorMoved(AncestorEvent arg0) {
        //  componentResized(null);
    }

    public void ancestorRemoved(AncestorEvent arg0) {
    }


    public void componentShown(ComponentEvent e) {
    }


    public void paintComponent(Graphics gc) {
        if (OrbitImageAnalysis.getInstance().getIFrame() == null || fullImage == null || fullImage.get() == null) {
            super.paintComponent(gc);
            return;
        }
        if ((image == null) || (image.getWidth() != this.thumbWidth) || (image.getHeight() != this.thumbHeight) || (thumbWidth == 0) || (thumbHeight == 0) || (oldHeight != getHeight()) || (oldWidth != getWidth()) || fullImage.get().getWidth() <= 0 || fullImage.get().getHeight() <= 0) {
            oldWidth = getWidth();
            oldHeight = getHeight();
            //if (width>0 && height>0)
            {
                // image = new BufferedImage(width, height, fullImage.getType());
                // image.getGraphics().drawImage(fullImage,0,0,width, height,this);
                Runnable makeMap = new Runnable() {
                    private boolean creating = false;

                    public void run() {
                        if (creating) return;
                        if (fullImage == null) return;
                        creating = true;
                        TiledImagePainter fullImage1 = fullImage.get();
                        if (fullImage1 == null) return;
                        int w = fullImage1.getWidth();
                        int h = fullImage1.getHeight();
                        if (w > 2000) {
                            w = 2000;
                            h = (int) (w * ((double) fullImage1.getHeight() / fullImage1.getWidth()));
                        }
                        if (h > 2000) {
                            h = 2000;
                            w = (int) (w * ((double) fullImage1.getWidth() / fullImage1.getHeight()));
                        }
                        image = fullImage1.getPreviewImage(w, h);
                        //image = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);
                        // enhance contrast for low-contrast preview images
                        image = contrastEnhancer.enhanceContrast(image);


                        // create scaled image with correct aspect ratio
                        w = RenderGrid.this.getVisibleRect().width;
                        h = RenderGrid.this.getVisibleRect().height;
                        w = RenderGrid.this.getBounds().width;
                        h = RenderGrid.this.getBounds().height;
                        int iw = w;
                        int ih = h;
                        if (image.getWidth() > image.getHeight()) {
                            ih = (int) (w * ((double) image.getHeight() / image.getWidth()));
                        } else {
                            iw = (int) (h * ((double) image.getWidth() / image.getHeight()));
                        }

                        if (ih > h) {
                            ih = h;
                            iw = (int) (ih * ((double) image.getWidth() / image.getHeight()));
                        }
                        if (iw > w) {
                            iw = w;
                            ih = (int) (iw * ((double) image.getHeight() / image.getWidth()));
                        }

                        iOffsX = 0;
                        iOffsY = 0;
                        if (iw < w) {
                            iOffsX = (w - iw) / 2;
                        }
                        if (ih < h) {
                            iOffsY = (h - ih) / 2;
                        }
                        thumbWidth = iw;
                        thumbHeight = ih;

                        if (thumbWidth > 0 && thumbHeight > 0) {
                            BufferedImage img = new BufferedImage(thumbWidth, thumbHeight, BufferedImage.TYPE_INT_RGB);
                            img.getGraphics().drawImage(image, 0, 0, thumbWidth, thumbHeight, RenderGrid.this);
                            image = img;
                        }
                        revalidate();
                        repaint();
                        creating = false;
                    }
                };
                SwingUtilities.invokeLater(makeMap);
            }
        }

        Graphics2D g = (Graphics2D) gc;
        Rectangle bounds = this.getBounds();
        g.setColor((Color) UIManager.get("Panel.background"));
        //thumbWidth = bounds.width;
        //thumbHeight =bounds.height;
        g.fillRect(0, 0, bounds.width, bounds.height);

        if (image != null)
            g.drawImage(image, iOffsX, iOffsY, this);

        // draw red viewport rectangle
        g.setColor(Color.red);
        int vpWid, vpHt;
        if (vpSize == null) {
            vpWid = thumbWidth;
            vpHt = thumbHeight;
        } else {
            vpWid = (int) (vpSize.width * ((double) thumbWidth / imageSize.width));
            vpHt = (int) (vpSize.height * ((double) thumbHeight / imageSize.height));
        }
        double x = vpPos.getX() + iOffsX;
        double y = (int) vpPos.getY() + iOffsY;
        currentShape = new Rectangle2D.Double(x, y, vpWid, vpHt);
      /*
      if(dragOn) {
         //currentShape = new Rectangle((int)panX,(int)panY,vpWid, vpHt);
         currentShape = new Rectangle(panX,panY,vpWid, vpHt);
       }else {
         currentShape = new Rectangle(x,y,vpWid,vpHt);
      }
      */

        if (currentShape != null) {
            g.draw(currentShape); // red viewport rectangle
            //cross
            if (showCross) {
                double cX = x + (vpWid / 2d);
                double cY = y + (vpHt / 2d);
                g.setColor(Color.green);
                g.setStroke(crossStroke);
                g.drawLine((int) (cX - crossSize), (int) cY, (int) (cX + crossSize), (int) cY);
                g.drawLine((int) cX, (int) (cY - crossSize), (int) cX, (int) (cY + crossSize));
            }
        }

        if (spotPanel != null) {
            double sc = Math.min(thumbWidth / spotPanel.getOriginalDimension().getWidth(), thumbHeight / spotPanel.getOriginalDimension().getHeight());
            spotPanel.drawSpots(gc, iOffsX, iOffsY, sc);
        }
    }

    public /*BufferedImage*/ TiledImagePainter getFullImage() {
        return fullImage.get();
    }

    public void setFullImage(TiledImagePainter fullImage) {
        this.fullImage = new WeakReference<TiledImagePainter>(fullImage);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public boolean isShowCross() {
        return showCross;
    }

    public void setShowCross(boolean showCross) {
        this.showCross = showCross;
    }

    public SpotImagePanel getSpotPanel() {
        return spotPanel;
    }

    public void setSpotPanel(SpotImagePanel spotPanel) {
        this.spotPanel = spotPanel;
    }


}
