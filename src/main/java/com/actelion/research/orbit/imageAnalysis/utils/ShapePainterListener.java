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
import com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame.Tools;
import com.actelion.research.orbit.imageAnalysis.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Arc2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class ShapePainterListener extends MouseInputAdapter {

    public static final String SHAPE_DRAWN = "ShapePainterListener.SHAPE_DRAWN";
    public static final String SHAPE_MOVED = "ShapePainterListener.SHAPE_MOVED";
    private final static Logger logger = LoggerFactory.getLogger(ShapePainterListener.class);
    private List<Shape> shapeList = null;
    private PolygonExt curPoly = null;
    private Rectangle curRect = null;
    private Point mousePosStart = null;
    private List<ImageAnnotation> currentAnnotationList = null;
    private WeakReference<RecognitionFrame> recognitionFrameRef = null;
    private boolean deleteMode = false;
    private int shapeMode = ClassShape.SHAPETYPE_POLYGONEXT;
    private boolean closeNextPolygonExt = true;
    private Point mousePosition = null;
    private boolean fixedRectangle = false;
    private double fixedRectangleRatio = 1.0d;
    private List<PropertyChangeListener> pcListeners = null;
    private final ReentrantReadWriteLock changeListenersLock = new ReentrantReadWriteLock();
    private List<IScaleableShape> rotationShapeList = null;
    private Point2D rotateCenter = null;
    private String className;

   // private byte[] magicLassoPixels = null;
    private int mlOffsX = 0;
    private int mlOffsY = 0;
    private Dijkstraheap dijkstraheapCCW = null;
    private Dijkstraheap dijkstraheapCW = null;
    int mlSize = 1000;
    int mlSH = mlSize/2;

    int[] a = null;
    int[] b = null;
    int[] c  = null;
    // for CCW version
    int[] a1 = new int[mlSize*5];
    int[] b1 = new int[mlSize*5];
    int[] c1 = new int[1];
    // for CW version
    int[] a2 = new int[mlSize*5];
    int[] b2 = new int[mlSize*5];
    int[] c2 = new int[1];
    int[] storeX = new int[10000];
    int[] storeY = new int[10000];
    int storeCount = 0;
    private int startMLX;
    private int startMLY;

    private static final byte[] invertTable;

    static {
        invertTable = new byte[256];
        for (int i = 0; i < 256; i++) {
            invertTable[i] = (byte) (255 - i);
        }
    }


    /**
     * Adds a listener to a classShape list. className is optional and just used for 'manual object count' logging.
     *
     * @param shapeList
     * @param className
     * @param recognitionFrame
     */
    public ShapePainterListener(List<Shape> shapeList, String className, RecognitionFrame recognitionFrame) {
        super();
        this.recognitionFrameRef = new WeakReference<RecognitionFrame>(recognitionFrame);
        this.shapeList = shapeList;
        this.className = className;
    }

    public void mousePressed(MouseEvent e) {
        RecognitionFrame recognitionFrame = recognitionFrameRef.get();
        if (recognitionFrame == null) return;
        int x = (int) (e.getX() + recognitionFrame.getViewPortOffset().getX());
        int y = (int) (e.getY() + recognitionFrame.getViewPortOffset().getY());

        if (e.isControlDown()) {
            // maxPath
                  /*
                    System.out.println("start pathList...");
		        	List<Point> path = new ArrayList<Point>();
		        	HashSet<Point> visited = new HashSet<Point>();
		        	Point startPoint = new Point(e.getX(),e.getY());
		        	double d = recognitionFrame.maxPath(startPoint, startPoint, 400, path, visited, 0);
		        	System.out.println("path calculated, dist/size: "+d+" / "+path.size());
		        	recognitionFrame.pathList = path;
		        */
            recognitionFrame.setShowObjectToolTip(true);
            recognitionFrame.setToolTipPosition(new Point(x, y));
            recognitionFrame.setToolTipCurrentScale(recognitionFrame.getScale());
            recognitionFrame.repaint();
            return;
        }

        if (!acceptTool(recognitionFrame.getSelectedTool())) return;

        if (recognitionFrame.getSelectedTool() == Tools.magneticLasso) {
            if (e.getButton()!=MouseEvent.BUTTON1) {
                // store old path
                if (a!=null && b!=null && c!=null) {   // path already set
                    if (storeX.length < storeCount + c[0] + 1) {  // increase path store?
                        int[] newStoreX = new int[storeX.length * 2];
                        int[] newStoreY = new int[storeY.length * 2];
                        System.arraycopy(storeX, 0, newStoreX, 0, storeX.length);
                        System.arraycopy(storeY, 0, newStoreY, 0, storeY.length);
                        storeX = newStoreX;
                        storeY = newStoreY;
                        logger.info("path store length increased to " + storeX.length);
                    }
                    for (int i = 0; i < c[0] + 1; i++) {
                        storeX[storeCount + i] = a[i] + mlOffsX;
                        storeY[storeCount + i] = b[i] + mlOffsY;
                    }
                    storeCount += c[0] + 1;
                }
            } else {
                storeCount = 0;
            }
            double scale = recognitionFrame.getScale() / 100d;
//            Raster r = recognitionFrame.bimg.image.getData(new Rectangle(x-mlSH,y-mlSH,mlSize,mlSize));
//            mlOffsX = r.getMinX();
//            mlOffsY = r.getMinY();
//            BufferedImage bi = recognitionFrame.createBufferedImage(r);

            BufferedImage bi = null;
            try {
                bi = recognitionFrame.getViewportImage(new Point2D.Double(x/scale,y/scale),mlSize,mlSize);
                mlOffsX = x-mlSH;
                mlOffsY = y-mlSH;
            } catch (Exception e1) {
                e1.printStackTrace();
                bi = new BufferedImage(mlSize,mlSize,BufferedImage.TYPE_BYTE_GRAY); // fallback - just a black image
                logger.warn("using fallback black image for magnetic lasso");
            }

//            try {
//                ImageIO.write(bi,"png",new File(("d:/test.png")));
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }

            BufferedImage img = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
            Graphics g = img.getGraphics();
            g.drawImage(bi, 0, 0, null);
            g.dispose();

            byte[]  magicLassoPixels = ((DataBufferByte)img.getData().createTranslatedChild(mlOffsX,mlOffsY).getDataBuffer()).getData();
            if (dijkstraheapCCW !=null) dijkstraheapCCW.setMyThreadRuns(false); // stop old thread
            dijkstraheapCCW = new Dijkstraheap(magicLassoPixels,mlSize,mlSize);
            dijkstraheapCCW.setPoint(x-mlOffsX,y-mlOffsY);

            img = invertImage(img);  //???    left invert, right not
            byte[]  magicLassoPixelsCW = ((DataBufferByte)img.getData().createTranslatedChild(mlOffsX,mlOffsY).getDataBuffer()).getData();
            if (dijkstraheapCW !=null) dijkstraheapCW.setMyThreadRuns(false); // stop old thread
            dijkstraheapCW = new Dijkstraheap(magicLassoPixelsCW,mlSize,mlSize);
            dijkstraheapCW.setPoint(x-mlOffsX,y-mlOffsY);

            startMLX = x;
            startMLY = y;

//            try {
//                dijkstraheapCCW.myThread.join();
//            } catch (InterruptedException e1) {
//                e1.printStackTrace();
//            }
        }

        //double cx = ((JComponent)recognitionFrame.getParent()).getBounds().getCenterX();
        //double cy =  ((JComponent)recognitionFrame.getParent()).getBounds().getCenterY();
        //Point offs = new Point((int)cx,(int)cy);
        Point offs = new Point(0, 0);


        if (shapeList == null) shapeList = new ArrayList<Shape>();

        if (!deleteMode) {
            switch (shapeMode) {
                case ClassShape.SHAPETYPE_ARC: {
                    Arc2DExt arc = new Arc2DExt(Arc2D.CHORD);
                    arc.setArcByCenter(x, y, recognitionFrame.getTargetRadius(), 0d, 360d, Arc2D.CHORD);
                    arc.setScale(recognitionFrame.getScale());
                    shapeList.add(arc);

                    // log number of shapes, e.g. for manual cell counting
                    logger.info("#objects (" + className + "): " + shapeList.size());

                    break;
                }
                case ClassShape.SHAPETYPE_RECTANGLE: {
                    if (fixedRectangle) {
                        //int w = (int)recognitionFrame.getTargetRadius()/2;
                        int w = (int) ((recognitionFrame.getTargetRadius() / 2d) * (recognitionFrame.getScale() / 100d));
                        int h = (int) ((double) w * fixedRectangleRatio);
                        curRect = new RectangleExt(x - w, y - h, w * 2, h * 2);
                    } else {
                        curRect = new RectangleExt(x, y, 0, 0);
                    }
                    ((RectangleExt) curRect).setScale(recognitionFrame.getScale()); // use interface!
                    shapeList.add(curRect);
                    mousePosStart = new Point(x, y);
                    break;
                }
                default: {

                    if (recognitionFrame.getSelectedTool() == Tools.cell) {
                        if (recognitionFrame.getObjectSegmentationList() == null) return;
                        Polygon cellShape = null;
                        double scaleFactor = (recognitionFrame.getScale() / 100d);
                        Point pos = new Point((int) (x / scaleFactor), (int) (y / scaleFactor));
                        for (Shape s : recognitionFrame.getObjectSegmentationList()) {
                            if (s instanceof Polygon) {
                                if (s.contains(pos)) {
                                    cellShape = (Polygon) s;
                                }
                            }
                        }
                        if (cellShape != null) {
                            curPoly = new PolygonExt();
                            shapeList.add(curPoly);
                            curPoly = (PolygonExt) shapeList.get(shapeList.size() - 1);  // use interface!!!
                            for (int i = 0; i < cellShape.npoints; i++)
                                curPoly.addPoint(cellShape.xpoints[i], cellShape.ypoints[i]);
                            curPoly.setClosed(true);
                            curPoly.setScale(100);
                            curPoly.setViewPortOffs(offs);
                        }
                    }
                    if (recognitionFrame.getSelectedTool() == Tools.moveAnnotation || recognitionFrame.getSelectedTool() == Tools.rotateAnnotation) {
                        if (currentAnnotationList != null  /*&& currentShape.contains(x,y)*/) {
                            mousePosStart = new Point(x, y);
                            rotationShapeList = null;
                        }
                    } else // normal polygon or magnetic lasso
                    {
                            if (e.getButton() == MouseEvent.BUTTON1) {
                                curPoly = new PolygonExt();
                                if (recognitionFrame.getSelectedTool() == Tools.roi) { // ROI-mode
                                    recognitionFrame.setROI(curPoly);
                                } else { // normal tissue marking mode
                                    shapeList.add(curPoly);
                                    curPoly = (PolygonExt) shapeList.get(shapeList.size() - 1);  // use interface!!!
                                }
                                curPoly.addPoint(x, y);
                                curPoly.setClosed(false);
                                curPoly.setScale(recognitionFrame.getScale());
                                curPoly.setViewPortOffs(offs);
                            }
                    }
                }
            } // switch shapeMode

        } else { // deleteMode
            double scaleFactor = (recognitionFrame.getScale() / 100d);
            Point pos = new Point((int) (x / scaleFactor), (int) (y / scaleFactor));
            removeFromShapeList(pos.x, pos.y, shapeList, className);
            // update 24.09.2012: take all classShapes into account
            // (the shape of the current selected classShape should be removed already, but this
            // workaround should also solve the rubber bug)
            if (!ScaleoutMode.SCALEOUTMODE.get()) {
                ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
                for (ClassShape cs : iFrame.recognitionFrame.getClassShapes()) {
                    List<Shape> sl = cs.getShapeList();
                    removeFromShapeList(pos.x, pos.y, sl, cs.getName());
                }
            }
        }
        recognitionFrame.repaint();
    }

    private static BufferedImage invertImage(final BufferedImage src) {
        final int w = src.getWidth();
        final int h = src.getHeight();
        final BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);
        final BufferedImageOp invertOp = new LookupOp(new ByteLookupTable(0, invertTable), null);
        return invertOp.filter(src, dst);
    }


    private int toIndex(int x, int y, int width) {
        return (y * width + x);
    }

    private boolean removeFromShapeList(int x, int y, List<Shape> shapeList, String className) {
        int ployToDelete = -1;
        for (int i = 0; i < shapeList.size(); i++) {
            Shape p = shapeList.get(i);
            if (p instanceof IScaleableShape) {
                p = ((IScaleableShape) p).getScaledInstance(100d, new Point(0, 0));
            }
            if (p.contains(x, y)) {
                ployToDelete = i;
                break;
            }
        }

        if (ployToDelete > -1) {
            shapeList.remove(ployToDelete);
            // log number of shapes, e.g. for manual cell counting
            logger.info("#objects (" + className + "): " + shapeList.size());
            return true;
        } else return false;
    }

    public void mouseDragged(MouseEvent e) {
        RecognitionFrame recognitionFrame = recognitionFrameRef.get();
        if (recognitionFrame == null) return;
        if (!acceptTool(recognitionFrame.getSelectedTool())) return;
        if (deleteMode) return;
        if (recognitionFrame.getSelectedTool() == Tools.cell) return;
        if (shapeMode == ClassShape.SHAPETYPE_ARC) return;
        if ((shapeMode == ClassShape.SHAPETYPE_RECTANGLE) && fixedRectangle) return;
        int x = (int) (e.getX() + recognitionFrame.getViewPortOffset().getX());
        int y = (int) (e.getY() + recognitionFrame.getViewPortOffset().getY());

        if (!recognitionFrame.getSelectedTool().equals(Tools.rotateAnnotation)) {
            rotationShapeList = null;
            rotateCenter = null;
        }

        if (recognitionFrame.getSelectedTool().equals(Tools.moveAnnotation)) {
            if (currentAnnotationList != null && mousePosStart != null) {
                double dx = x - mousePosStart.x;
                double dy = y - mousePosStart.y;
                dx /= recognitionFrame.getScale() / 100d;
                dy /= recognitionFrame.getScale() / 100d;
                for (ImageAnnotation currentAnnotation : currentAnnotationList) {
                    IScaleableShape currentShape = (IScaleableShape) currentAnnotation.getFirstShape();
                    currentShape.move(dx, dy);
                }
                mousePosStart.x = x;
                mousePosStart.y = y;
                recognitionFrame.repaint();
            }
        } else if (recognitionFrame.getSelectedTool().equals(Tools.rotateAnnotation)) {
            if (currentAnnotationList != null && mousePosStart != null) {
                double dy = y - mousePosStart.y;
                if (e.isControlDown()) dy /= 10d;
                Rectangle2D bbAll = null;
                if (rotationShapeList == null) {
                    for (ImageAnnotation currentAnnotation : currentAnnotationList) {
                        IScaleableShape shape = (IScaleableShape) currentAnnotation.getFirstShape();
                        Rectangle2D bb = shape.getBounds2D();
                        if (bbAll == null) bbAll = bb;
                        else bbAll = bbAll.createUnion(bb);
                    }
                    if (bbAll != null) {
                        rotateCenter = new Point2D.Double(bbAll.getCenterX(), bbAll.getCenterY());
                        // the 'original' polygons are stored and then rotated later to avoid rounding problems for continuous rotation
                        rotationShapeList = new ArrayList<IScaleableShape>(currentAnnotationList.size());
                        for (ImageAnnotation currentAnnotation : currentAnnotationList) {
                            IScaleableShape currentShape = (IScaleableShape) currentAnnotation.getFirstShape();
                            rotationShapeList.add(currentShape.clone());
                        }
                    }
                }
                if (rotationShapeList != null && rotationShapeList.size() > 0 && rotateCenter != null) {
                    for (int i = 0; i < currentAnnotationList.size(); i++) {
                        ImageAnnotation currentAnnotation = currentAnnotationList.get(i);
                        IScaleableShape shape = (IScaleableShape) currentAnnotation.getFirstShape();
                        IScaleableShape rotShape = rotationShapeList.get(i);
                        if (rotShape instanceof PolygonExt) {
                            PolygonExt cShape = (PolygonExt) rotShape; // no need to clone here, setPoly will clone the data
                            ((PolygonExt) shape).setPoly(cShape);
                            shape.rotate(dy, rotateCenter);
                        }
                    }
                    recognitionFrame.repaint();
                }

            }
        } else if (shapeMode == ClassShape.SHAPETYPE_RECTANGLE) {
            int rx = (int) Math.min(mousePosStart.getX(), x);
            int ry = (int) Math.min(mousePosStart.getY(), y);
            int rw = (int) Math.abs(mousePosStart.getX() - x);
            int rh = (int) Math.abs(mousePosStart.getY() - y);
            curRect.setBounds(rx, ry, rw, rh);
            recognitionFrame.repaint();
            return;
        } else if (recognitionFrame.getSelectedTool() == Tools.magneticLasso) { // magnetic lasso
            if ((x-mlOffsX>=0) && (y-mlOffsY>=0) && (x-mlOffsX<mlSize) && (y-mlOffsY<mlSize))
            {
                double cost1 = dijkstraheapCCW.returnPath(x - mlOffsX, y - mlOffsY, a1, b1, c1);
                double cost2 = dijkstraheapCW.returnPath(x - mlOffsX, y - mlOffsY, a2, b2, c2);
                if (cost1<cost2) {   // decide which version is the better one (depends if the user draws CW or CCW around an object)
                    a = a1;
                    b = b1;
                    c = c1;
                } else {
                    a = a2;
                    b = b2;
                    c = c2;
                }

                int np = c[0] + 1;
                int[] ax = new int[storeCount + np];
                int[] bx = new int[storeCount + np];
                System.arraycopy(storeX, 0, ax, 0, storeCount);
                System.arraycopy(storeY, 0, bx, 0, storeCount);
                for (int i = 0; i < np; i++) {
                    ax[i + storeCount] = a[i] + mlOffsX;
                    bx[i + storeCount] = b[i] + mlOffsY;
                }
                curPoly.setPoly(new Polygon(ax, bx, np + storeCount));
            }
            recognitionFrame.repaint();
        }
        else  { // brush
            curPoly.addPoint(x, y);
            recognitionFrame.repaint();
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (e.getButton()!=MouseEvent.BUTTON1) return; // end only if first/left mouse button is released

        RecognitionFrame recognitionFrame = recognitionFrameRef.get();
        if (recognitionFrame == null) return;
        if (!acceptTool(recognitionFrame.getSelectedTool())) return;
        if (deleteMode) return;
        if (shapeList != null && shapeList.size() > 0 && recognitionFrame.getSelectedTool() != Tools.moveAnnotation && recognitionFrame.getSelectedTool() != Tools.rotateAnnotation) {
            firePropertyChangeEvent(new PropertyChangeEvent(this, SHAPE_DRAWN, null, shapeList.get(shapeList.size() - 1)));
        }

        if ((recognitionFrame.getSelectedTool() == Tools.moveAnnotation || recognitionFrame.getSelectedTool() == Tools.rotateAnnotation) && currentAnnotationList != null) {
            firePropertyChangeEvent(new PropertyChangeEvent(this, SHAPE_MOVED, null, currentAnnotationList));
        }

        if (recognitionFrame.getSelectedTool() == Tools.cell) return;
        if (shapeMode == ClassShape.SHAPETYPE_ARC) return;
        if (shapeMode == ClassShape.SHAPETYPE_RECTANGLE) return;
        // brush
        if (curPoly != null && curPoly.npoints > 0) {
            curPoly.setClosed(closeNextPolygonExt);
            closeNextPolygonExt = true;
//				if (System.currentTimeMillis()-lastRepaint.get()>16) {
//				lastRepaint.set(System.currentTimeMillis());
            recognitionFrame.repaint();
//				}
            // fire property change shape added
        }
    }

    public void mouseMoved(MouseEvent e) {
        RecognitionFrame recognitionFrame = recognitionFrameRef.get();
        if (recognitionFrame == null) return;

        int x = (int) (e.getX() + recognitionFrame.getViewPortOffset().getX());
        int y = (int) (e.getY() + recognitionFrame.getViewPortOffset().getY());
        mousePosition = new Point(x, y);
        if (recognitionFrame.isShowObjectToolTip()) {
            recognitionFrame.setShowObjectToolTip(false);
            recognitionFrame.repaint();
        }
        if (!acceptTool(recognitionFrame.getSelectedTool())) return;
        if (deleteMode || !(shapeMode == ClassShape.SHAPETYPE_ARC || ((shapeMode == ClassShape.SHAPETYPE_RECTANGLE) && fixedRectangle)))
            return;

        recognitionFrame.repaint();
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        RecognitionFrame recognitionFrame = recognitionFrameRef.get();
        if (recognitionFrame == null) return;

        if (!acceptTool(recognitionFrame.getSelectedTool())) return;
        if (shapeMode == ClassShape.SHAPETYPE_ARC || (shapeMode == ClassShape.SHAPETYPE_RECTANGLE && fixedRectangle)) {
            int newSize = Math.max(1, (int) recognitionFrame.getTargetRadius() + e.getWheelRotation());
            recognitionFrame.setTargetRadius(newSize);
            OrbitImageAnalysis.getInstance().getSizeBox().setSelectedItem(new Integer(newSize));
            //recognitionFrame.firePropertyChange("circleSizeChange", newSize);
            e.consume();
            recognitionFrame.repaint();
        }
    }


    private boolean acceptTool(Tools tool) {
        if (tool.equals(Tools.magneticLasso)) return true;
        if (tool.equals(Tools.brush)) return true;
        if (tool.equals(Tools.rectangle)) return true;
        if (tool.equals(Tools.circle)) return true;
        if (tool.equals(Tools.delete)) return true;
        if (tool.equals(Tools.cell)) return true;
        if (tool.equals(Tools.roi)) return true;
        if (tool.equals(Tools.moveAnnotation)) return true;
        return tool.equals(Tools.rotateAnnotation);
    }


    public List<Shape> getShapeList() {
        return shapeList;
    }

    public void setShapeList(List<Shape> shapeList, String className) {
        this.shapeList = shapeList;
        this.className = className;
        shapeMode = ClassShape.SHAPETYPE_POLYGONEXT;
    }

    public void setShapeList(List<Shape> shapeList, int shapeMode, String className) {
        this.shapeList = shapeList;
        this.shapeMode = shapeMode;
        this.className = className;
    }

    public boolean isDeleteMode() {
        return deleteMode;
    }

    public void setDeleteMode(boolean deleteMode) {
        this.deleteMode = deleteMode;
    }

    public int getShapeMode() {
        return shapeMode;
    }

    public void setShapeMode(int shapeMode) {
        this.shapeMode = shapeMode;
    }

    public Point getMousePosition() {
        return mousePosition;
    }

    public void setMousePosition(Point mousePosition) {
        this.mousePosition = mousePosition;
    }


    //  propertyChangeEmitter
    protected void firePropertyChangeEvent(PropertyChangeEvent event) {
        changeListenersLock.readLock().lock();
        List<PropertyChangeListener> copyListeners = new ArrayList<PropertyChangeListener>();
        try {
            if (pcListeners != null)
                copyListeners.addAll(pcListeners);
        } finally {
            changeListenersLock.readLock().unlock();
        }

        if (copyListeners != null) {
            for (PropertyChangeListener pcl : copyListeners) {
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
        changeListenersLock.writeLock().lock();
        try {
            if (pcListeners == null) pcListeners = new ArrayList<PropertyChangeListener>();
            pcListeners.add(propertyChangeListener);
        } finally {
            changeListenersLock.writeLock().unlock();
        }
    }

    /**
     * removes a propertyChangeListener. If this listener not exists in the propertyChangeListeners list then
     * nothing will be done.
     *
     * @param propertyChangeListener
     */
    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        changeListenersLock.writeLock().lock();
        try {
            if (pcListeners != null) pcListeners.remove(propertyChangeListener);
        } finally {
            changeListenersLock.writeLock().unlock();
        }
    }

    public boolean containsPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        boolean res = false;
        changeListenersLock.readLock().lock();
        try {
            if (pcListeners == null) res = false;
            else res = pcListeners.contains(propertyChangeListener);
        } finally {
            changeListenersLock.readLock().unlock();
        }
        return res;
    }

    public boolean isCloseNextPolygonExt() {
        return closeNextPolygonExt;
    }

    public void setCloseNextPolygonExt(boolean closeNextPolygonExt) {
        this.closeNextPolygonExt = closeNextPolygonExt;
    }

    public boolean isFixedRectangle() {
        return fixedRectangle;
    }

    public void setFixedRectangle(boolean fixedRectangle) {
        this.fixedRectangle = fixedRectangle;
    }

    public double getFixedRectangleRatio() {
        return fixedRectangleRatio;
    }

    public void setFixedRectangleRatio(double fixedRectangleRatio) {
        this.fixedRectangleRatio = fixedRectangleRatio;
    }


    public List<ImageAnnotation> getCurrentAnnotationList() {
        return currentAnnotationList;
    }

    public void setCurrentAnnotationList(List<ImageAnnotation> currentAnnotationList) {
        this.currentAnnotationList = currentAnnotationList;
    }
}