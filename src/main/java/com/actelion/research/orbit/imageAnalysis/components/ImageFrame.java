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

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.beans.RawMeta;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame.Tools;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.imageAnalysis.utils.ScaleoutMode;
import com.actelion.research.orbit.imageAnalysis.utils.TiledImagePainter;
import com.actelion.research.orbit.imageAnalysis.utils.ViewPortScrollListener;
import com.actelion.research.orbit.utils.RawMetaFactoryFile;
import com.actelion.research.orbit.utils.RawUtilsCommon;
import com.sun.media.jai.codec.JPEGEncodeParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.media.jai.JAI;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;


public class ImageFrame extends JInternalFrame implements ComponentListener, PropertyChangeListener {

    public static final String STR_CHANNELS_META = "Linked Channels";
    public static final String SCALE_EVENT = "imageScale";
    public static final String SCALE_SET_EVENT = "imageScaleSet";
    public static final String SCALE_SET_EVENT_OUT = "imageScaleSetOut";
    public static final String IFRAME_SELECTED = "iFrameSelected";
    public final static String MOUSE_MOVED_ON_IMAGE = "iFrame_mouse_moved";
    public final static String IFRAME_CLOSING = "iFrame_closing";


    private static final long serialVersionUID = 1L;
    private Logger logger = LoggerFactory.getLogger(ImageFrame.class);
    public RecognitionFrame recognitionFrame = null;
    private volatile RenderGrid renderGrid = null;
    protected JSlider opacitySlider = null;
    private RawDataFile rdf = null; // only set if it stems from a rdf, otherwise null
    private boolean exclusive = false;
    private int mipLayer = 0;
    private ImageIcon icon = null;


    public ImageFrame(Object imageStrOrUrl) throws OrbitImageServletException {
        this(new RecognitionFrame(imageStrOrUrl, true));
    }

    public ImageFrame(final RecognitionFrame recognitionFrame) {
        super(recognitionFrame.getPicName(),
                true, //resizable
                true, //closable
                true, //maximizable
                true);//iconifiable

        java.net.URL imgURL = this.getClass().getResource(OrbitImageAnalysis.LOGO_NAME);
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            this.setFrameIcon(icon);
        }

        enableEvents(AWTEvent.MOUSE_MOTION_EVENT_MASK |
                AWTEvent.MOUSE_EVENT_MASK | AWTEvent.MOUSE_WHEEL_EVENT_MASK);


        this.setDoubleBuffered(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.recognitionFrame = recognitionFrame;
        addPropertyChangeListener(this);

        opacitySlider = new JSlider(0, 100);
        opacitySlider.setToolTipText("adjust classification opacity");
        opacitySlider.setEnabled(false);
        opacitySlider.setValue(0);
        opacitySlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider) e.getSource();
                ImageFrame.this.recognitionFrame.setOpacity(slider.getValue() / 100f);
                ImageFrame.this.recognitionFrame.prepareBuffer();
                ImageFrame.this.recognitionFrame.repaint();
            }

            ;
        });
        add(recognitionFrame);
        add(opacitySlider, BorderLayout.SOUTH);


        ViewPortScrollListener viewPortScroller = new ViewPortScrollListener(recognitionFrame, this);
        recognitionFrame.addMouseListener(viewPortScroller);
        recognitionFrame.addMouseMotionListener(viewPortScroller);
        try {
            recognitionFrame.addMouseWheelListener(viewPortScroller);  // >= Java 1.6
        } catch (Exception e) {
            System.out.println("Warning: MouseWheelListener not supported -> please upgrade to Java >= 1.6!");
        }

        // add "pan with space" key adapter (allows panning while in drawing mode)
        addKeyListener(new KeyAdapter() {
            boolean dragging = false;
            Tools oldTool = recognitionFrame.getSelectedTool();
            Cursor oldCursor = recognitionFrame.getCursor();

            @Override
            public void keyPressed(KeyEvent e) {
                if (dragging) return;
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (recognitionFrame.getMyListener() != null) {
                        recognitionFrame.getMyListener().mouseReleased(null);
                        Robot r = null;
                        try {
                            r = new Robot();
                            r.mouseRelease(InputEvent.BUTTON1_MASK);
                        } catch (AWTException e1) {
                            e1.printStackTrace();
                        }
                    }
                    dragging = true;
                    oldTool = recognitionFrame.getSelectedTool();
                    oldCursor = recognitionFrame.getCursor();
                    recognitionFrame.setSelectedTool(Tools.finger);
                    recognitionFrame.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (dragging) {
                    recognitionFrame.setSelectedTool(oldTool);
                    recognitionFrame.setCursor(oldCursor);
                    dragging = false;
                }
            }
        });

        addComponentListener(this);

    }

    public synchronized ImageIcon getOrbitIcon() {
        if (icon == null) {
            icon = new ImageIcon(this.getClass().getResource(OrbitImageAnalysis.LOGO_NAME));
        }
        return icon;
    }


    /**
     * make firePropertyChange public
     */

    public void firePropertyChangeExt(String propertyName, Object oldValue, Object newValue) {
        firePropertyChange(propertyName, oldValue, newValue);
    }


    public void processMouseWheelEvent(MouseWheelEvent e) {
        if (!acceptTool(recognitionFrame.getSelectedTool())) return;
        firePropertyChange(ImageFrame.SCALE_EVENT, null, new Double(e.getWheelRotation()));
    }

    private boolean acceptTool(Tools tool) {
        return tool.equals(Tools.finger);
    }


    /**
     * The preferred way to set the viewPort position. It calls recognitionFrame.setViewPortOffset followed
     * by a adjustViewport(). As result the image and the renderGrid will be adjusted.
     *
     * @param vpPos
     */
    public void setViewPortPositionAndAdjust(Point2D vpPos) {
        recognitionFrame.setViewPortOffset(vpPos);
        adjustViewport(false);
    }

    public void setViewPortPosAndSize(Point position, Dimension size) {
        recognitionFrame.setViewPortOffset(position);
        recognitionFrame.setViewPortSize(size);
    }

    public void updateRenderGrid() {
        if (renderGrid == null) return;
        if (!(exclusive || isSelected())) return;
        renderGrid.setFullImage(recognitionFrame.bimg);
        renderGrid.setViewportSize(getSize());
        renderGrid.setImageSize(new Dimension(recognitionFrame.bimg.getWidth(), recognitionFrame.bimg.getHeight())); // scale?
        renderGrid.setViewportPosition(recognitionFrame.getViewPortOffset()); // update 0.80g
        renderGrid.setImage(null);
        renderGrid.setScale(recognitionFrame.getScale() / 100d);
        renderGrid.repaint();
    }

    /**
     * stores the current viewport as an image file. Executes a fileChooser for choosing the file and
     * displays a JOptionPane if successful.
     */
    public void saveCurrentView() {
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.jpg", "jpg");
        fc.setFileFilter(filter);
        String snapShotFileName = recognitionFrame.getPicName();
        snapShotFileName = snapShotFileName.replaceAll(RawUtilsCommon.getExtension(snapShotFileName, false), "snapshot.jpg");
        fc.setSelectedFile(new File(snapShotFileName));
        int returnVal = fc.showSaveDialog(this);
        String fn = null;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            fn = fc.getSelectedFile().getAbsolutePath();
            if (!fn.toLowerCase().endsWith(".jpg")) fn += ".jpg";
        }
        fc = null;
        this.repaint();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        if (fn != null) {
            BufferedImage bi;
            Robot robot;
            try {
                Rectangle r = recognitionFrame.getBounds();
                r.x += recognitionFrame.getLocationOnScreen().x;
                r.y += recognitionFrame.getLocationOnScreen().y;
                robot = new Robot();
                bi = robot.createScreenCapture(r);
                JPEGEncodeParam jpgParam = new JPEGEncodeParam();
                jpgParam.setQuality(0.85f);
                JAI.create("filestore", bi, fn, "JPEG", jpgParam);
                System.gc(); // forces JAI to close the filehandle
                logger.debug("finished writing");
                JOptionPane.showMessageDialog(this, "Screenshot successfully saved to " + fn, "Screenshot saved", JOptionPane.INFORMATION_MESSAGE);
            } catch (AWTException e) {
                logger.error("error saving screenshot", e);
            }
        }
    }


    /**
     * get the current viewport as an image
     */
    public BufferedImage getCurrentView() {
        int w = getWidth();
        int h = getHeight();
        BufferedImage bi;
        Robot robot;
        try {
            Rectangle r = recognitionFrame.getBounds();
            r.x += recognitionFrame.getLocationOnScreen().x;
            r.y += recognitionFrame.getLocationOnScreen().y;
            robot = new Robot();
            bi = robot.createScreenCapture(r);
            return bi;
        } catch (AWTException e) {
            logger.error("error getting viewport", e);
            return null;
        }
    }


    public synchronized void adjustViewport() {
        adjustViewport(false);
    }

    private synchronized void adjustViewport(boolean fromMouse) {
        double scOld = recognitionFrame.getOldScale() / 100d;
        double scNew = recognitionFrame.getScale() / 100d;
        if (scOld < 0.00001d) return; // avoid diff by 0 later

        Dimension frameSize = getSize();
        recognitionFrame.setViewPortSize(recognitionFrame.getSize());
        Point2D offs = recognitionFrame.getViewPortOffset();

        // "centralized zooming"
        double centerX = frameSize.width / 2d;
        double centerY = frameSize.height / 2d;

        Point2D mousePos = getMousePosition(); // returns null if mouse cursor is not over component
        double imgW = (int) (recognitionFrame.bimg.getWidth() * scOld);
        double imgH = (int) (recognitionFrame.bimg.getHeight() * scOld);
        Rectangle2D viewPortRect = new Rectangle2D.Double(-offs.getX(), -offs.getY(), imgW, imgH);
        if (fromMouse && mousePos != null && viewPortRect.contains(mousePos)) { // if available, center the zooming to the mouse position
            centerX = mousePos.getX();
            centerY = mousePos.getY();
        }

        double x = offs.getX() + centerX;
        double y = offs.getY() + centerY;
        x *= (scNew / scOld);
        y *= (scNew / scOld);
        x -= centerX;
        y -= centerY;

        offs.setLocation(x, y);

        // don't let the image out of the viewport
        final double border = 20;
        double ox = offs.getX();
        double oy = offs.getY();
        if (fromMouse) {
            if (-offs.getX() + imgW - border < 0) ox = imgW - border;
            if (-offs.getY() + imgH - border < 0) oy = imgH - border;
            if (-offs.getX() + border > recognitionFrame.getWidth()) ox = -recognitionFrame.getWidth() + border;
            if (-offs.getY() + border > recognitionFrame.getHeight()) oy = -recognitionFrame.getHeight() + border;
        }
        offs.setLocation(ox, oy);

        recognitionFrame.setOldScale(scNew * 100d);    // version 1.91
        recognitionFrame.setViewPortOffset(new Point2D.Double(offs.getX(), offs.getY()));
        recognitionFrame.repaint();

        if ((exclusive || isSelected()) && renderGrid != null) {
            renderGrid.setScale(recognitionFrame.getScale() / 100d);
            //this.propertyChange(new PropertyChangeEvent(this, SCALE_SET_EVENT_OUT, null, new Integer((int)recognitionFrame.getScale())));
            renderGrid.setViewportPosition(recognitionFrame.getViewPortOffset());
            renderGrid.repaint();
        }

    }


    public void propertyChange(PropertyChangeEvent evt) {
        final double minScale = 0.2d;


        if (evt.getPropertyName().equals("closed")) {
            logger.trace("closed imageframe: " + title);
            if (recognitionFrame.getRenderThreadOriginal() != null) {
                recognitionFrame.getRenderThreadOriginal().setBufferReady(true);
                recognitionFrame.getRenderThreadOriginal().setBufferRendering(false);
                recognitionFrame.getRenderThreadOriginal().setScheduleUpdate(false);
                recognitionFrame.getRenderThreadOriginal().removePropertyChangeListener(recognitionFrame);
                recognitionFrame.getRenderThreadOriginal().interrupt();
                recognitionFrame.getRenderThreadOriginal().stop();
            }
            try {
                recognitionFrame.bimg.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            removePropertyChangeListener(this);
            firePropertyChange(IFRAME_CLOSING, null, this);
        }


        OrbitImageAnalysis OIA = OrbitImageAnalysis.getInstance();
        boolean inSync = OIA.isSyncFrames();
        if ((exclusive || isSelected()) && evt.getPropertyName().equals(SCALE_EVENT)) {     // scroll wheel zooming
            recognitionFrame.setOldScale(recognitionFrame.getScale());
            double newScale = recognitionFrame.getScale();
            double factor = -OrbitUtils.log2(recognitionFrame.getScale() + 1d) - 1;
            factor /= 1d / (OrbitUtils.log2(newScale + 1d) / 10d);
            newScale = Math.max(minScale, recognitionFrame.getScale() + ((Double) evt.getNewValue()) * factor);

            // ensure minWidth of image
            double minWidth = 100d;
            double scaledWidth = (newScale / 100d) * recognitionFrame.bimg.getImage().getWidth();
            if (scaledWidth < minWidth)
                newScale = (minWidth / (double) recognitionFrame.bimg.getImage().getWidth()) * 100d;
            newScale = Math.min(500d, newScale); // TODO: get maxRange from scaleSlider!
            recognitionFrame.setScale(newScale);
            adjustViewport(true);
            if ((exclusive || isSelected()))
                firePropertyChange(SCALE_SET_EVENT_OUT, null, recognitionFrame.getScale());

        } else if ((exclusive || inSync || isSelected()) && evt.getPropertyName().equals(SCALE_SET_EVENT))     // from zoom slider
        {  // called for all iFrames when new image is opened  or scale slider moved
            double oldScale = recognitionFrame.getScale();
            double newScale = Math.max(minScale, (Double) evt.getNewValue());
            recognitionFrame.setOldScale(oldScale);
            recognitionFrame.setScale(newScale);
            if ((exclusive || isSelected())) adjustViewport(false);
            //	if ((exclusive||isSelected()))  firePropertyChange(SCALE_SET_EVENT_OUT, null, (Double)recognitionFrame.getScale());
        } else if (evt.getPropertyName().equals("selected") && evt.getNewValue().equals(true) && evt.getSource().equals(this)) {    // imageFrame selected
            updateRenderGrid();
            if (rdf != null) { // it stems from a rdf, so load meta data
                firePropertyChange(ImageList.PROPERTY_DISPLAY_META, null, rdf);
            }
            // update scaleSlider
            if ((exclusive || isSelected()))
                firePropertyChange(SCALE_SET_EVENT_OUT, null, recognitionFrame.getScale());
            firePropertyChange(IFRAME_SELECTED, null, this);
        }

    }


    public boolean saveChannels() {
        OrbitImageAnalysis.getInstance().forceLogin();
        if (OrbitImageAnalysis.loginOk) {
            try {
                String vals = channelsToString();
                List<RawMeta> rms = DALConfig.getImageProvider().LoadRawMetasByRawDataFileAndName(getRdf().getRawDataFileId(), STR_CHANNELS_META);
                if (rms != null && rms.size() > 0) { // update
                    RawMeta rm = rms.get(0);
                    rm.setModifyDate(new Date());
                    rm.setUserId(OrbitImageAnalysis.loginUser);
                    rm.setValue(vals);
                    if (DALConfig.getImageProvider().UpdateRawMeta(rm) && vals != null && vals.length() > 0) {
                        rdf.setFlagBit(RawDataFile.Flag_HAS_LINKED_CHANNELS);
                        DALConfig.getImageProvider().UpdateRawDataFile(rdf);
                    }
                    logger.debug("Channels updated in database. RawMeta: " + rm);
                } else { // insert
                    RawMetaFactoryFile rmff = new RawMetaFactoryFile(getRdf().getRawDataFileId(), new Date(), OrbitImageAnalysis.loginUser);
                    RawMeta rm = rmff.createMetaStr(STR_CHANNELS_META, vals);
                    if (DALConfig.getImageProvider().InsertRawMeta(rm) > 0) {
                        // successful, so set flag in rdf
                        rdf.setFlagBit(RawDataFile.Flag_HAS_LINKED_CHANNELS);
                        DALConfig.getImageProvider().UpdateRawDataFile(rdf);
                    }
                    logger.debug("Channels saved to database. RawMeta: " + rm);
                }
                JOptionPane.showMessageDialog(this, "Channels successfully saved.", "Channels Saved", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } catch (Exception e) {
                logger.error("cannot insert or update raw meta into database", e);
                return false;
            }

        } else {
            logger.debug("Channels not saved because Orbit login is not ok or canceled.");
            return false;
        }
    }

    public boolean removeChannels() {
        OrbitImageAnalysis.getInstance().forceLogin();
        if (OrbitImageAnalysis.loginOk) {
            try {
                //String vals = channelsToString();
                List<RawMeta> rms = DALConfig.getImageProvider().LoadRawMetasByRawDataFileAndName(getRdf().getRawDataFileId(), STR_CHANNELS_META);
                if (rms != null && rms.size() > 0) {
                    for (RawMeta rm : rms) {
                        if (DALConfig.getImageProvider().DeleteRawMeta(rm.getRawMetaId())) {
                            logger.debug("RawMeta deleted: " + rm.getRawMetaId());
                            // successful, so unset has linked channels flag
                            rdf.unsetFlagBit(RawDataFile.Flag_HAS_LINKED_CHANNELS);
                            DALConfig.getImageProvider().UpdateRawDataFile(rdf);
                        }
                    }
                }
                // unset channels
                recognitionFrame.bimg.setRedChannel(null);
                recognitionFrame.bimg.setGreenChannel(null);
                recognitionFrame.bimg.setBlueChannel(null);
                recognitionFrame.bimg.setRedChannelRdfId(0);
                recognitionFrame.bimg.setGreenChannelRdfId(0);
                recognitionFrame.bimg.setBlueChannelRdfId(0);
                repaint();
                JOptionPane.showMessageDialog(this, "Channels successfully removed.", "Channels Removed", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } catch (Exception e) {
                logger.error("cannot remove raw meta from database", e);
                return false;
            }
        } else {
            logger.debug("Channels not removed because Orbit login is not ok or canceled.");
            return false;
        }
    }

    public void loadChannels() {
        if (rdf == null) return;
        try {
            List<RawMeta> channelMeta = DALConfig.getImageProvider().LoadRawMetasByRawDataFileAndName(getRdf().getRawDataFileId(), STR_CHANNELS_META);
            if ((!ScaleoutMode.SCALEOUTMODE.get()) && channelMeta != null && channelMeta.size() > 0) {
                if (JOptionPane.showConfirmDialog(this,
                        "Linked channels (red/green/blue) found. Do you want to load and link the channels?",
                        "Load Linked Channels?", JOptionPane.YES_NO_OPTION)
                        == JOptionPane.YES_OPTION) {
                    String[] vals = channelMeta.get(0).getValue().split(",");
                    if (vals != null && vals.length >= 3) {
                        for (String val : vals) {
                            String[] split = val.split(":");
                            String channel = split[0];
                            int rdfId = Integer.parseInt(split[1]);
                            if (rdfId > 0) {
                                loadChannel(rdfId, channel);
                                repaint();
                            }
                        }
                    }
                } // really load?
            }
        } catch (Exception e) {
            logger.error("error loading channel meta data", e);
        }
    }


    private void loadChannel(int rdfId, String channel) {
        try {
            RawDataFile rdf = DALConfig.getImageProvider().LoadRawDataFile(rdfId);
            String ch = "red";
            if (channel.equalsIgnoreCase("g")) ch = "green";
            if (channel.equalsIgnoreCase("b")) ch = "blue";
            if (channel.equalsIgnoreCase("o")) ch = "overlay";
            OrbitImageAnalysis.getInstance().loadFile(rdf, rdf.getFileName() + " [" + ch + "]", false);
            RecognitionFrame rf = new RecognitionFrame(rdf, false);
            if (channel.equalsIgnoreCase("r")) {
                setTIPChannel(recognitionFrame.bimg, rdfId, rf.bimg, TiledImagePainter.CHANNEL_RED);
            } else if (channel.equalsIgnoreCase("g")) {
                setTIPChannel(recognitionFrame.bimg, rdfId, rf.bimg, TiledImagePainter.CHANNEL_GREEN);
            } else if (channel.equalsIgnoreCase("b")) {
                setTIPChannel(recognitionFrame.bimg, rdfId, rf.bimg, TiledImagePainter.CHANNEL_BLUE);
            } else if (channel.equalsIgnoreCase("o")) {
                setTIPChannel(recognitionFrame.bimg, rdfId, rf.bimg, TiledImagePainter.CHANNEL_OVERLAY);
            }
        } catch (Exception e) {
            logger.error("error loading channel", e);
        }
    }

    private void setTIPChannel(TiledImagePainter tip, int rdfId, TiledImagePainter channel, int chanNr) {
        tip.setChannelRdfId(rdfId, chanNr);
        tip.setChannel(channel.getImage(), chanNr);

        // TODO remove work around
        if (OrbitImageAnalysis.getInstance().loadAllLayersMultiChannel.isSelected()) {
            if (tip.hasMipMaps()) {
                for (int i = 0; i < tip.getMipMaps().length; i++) {
                    tip.getMipMaps()[i].setChannelRdfId(rdfId, chanNr);
                    tip.getMipMaps()[i].setChannel(channel.getMipMaps()[i].getImage(), chanNr);
                }
            }
        }

    }

    private String channelsToString() {
        return "r:" + recognitionFrame.bimg.getRedChannelRdfId()
                + ",g:" + recognitionFrame.bimg.getGreenChannelRdfId()
                + ",b:" + recognitionFrame.bimg.getBlueChannelRdfId()
                + ",o:" + recognitionFrame.bimg.getOverlayChannelRdfId();
    }


    public void componentHidden(ComponentEvent e) {
    }

    public void componentMoved(ComponentEvent e) {
    }

    public void componentResized(ComponentEvent e) {
        if (recognitionFrame != null) {
            recognitionFrame.setViewPortSize(getSize());
            recognitionFrame.prepareBuffer();
            recognitionFrame.repaint();
        }
        if (renderGrid != null) {
            renderGrid.setViewportSize(getSize());
            if (recognitionFrame != null)
                renderGrid.setViewportPosition(recognitionFrame.getViewPortOffset());
            renderGrid.repaint();
        }
    }

    public void componentShown(ComponentEvent e) {
    }


    @Override
    public Point getMousePosition() throws HeadlessException {
        if (!exclusive) return super.getMousePosition();
        else
            return MouseInfo.getPointerInfo().getLocation(); // e.g. in fullscreen mode
    }

    @Override
    public Dimension getSize() {
        if (!exclusive) return super.getSize();
        else {
            // exclusive
            return Toolkit.getDefaultToolkit().getScreenSize();
        }
    }

    public RecognitionFrame getRecognitionFrame() {
        return recognitionFrame;
    }

    public void setRecognitionFrame(RecognitionFrame recognitionFrame) {
        this.recognitionFrame = recognitionFrame;
    }


    public RenderGrid getRenderGrid() {
        return renderGrid;
    }


    public void setRenderGrid(RenderGrid renderGrid) {
        this.renderGrid = renderGrid;
    }


    public JSlider getOpacitySlider() {
        return opacitySlider;
    }


    public void setOpacitySlider(JSlider opacitySlider) {
        this.opacitySlider = opacitySlider;
    }


    public RawDataFile getRdf() {
        return rdf;
    }

    public void setRdf(RawDataFile rdf) {
        this.rdf = rdf;
    }

    public boolean isExclusive() {
        return exclusive;
    }

    public void setExclusive(boolean exclusive) {
        this.exclusive = exclusive;
    }

    public int getMipLayer() {
        return mipLayer;
    }

    public void setMipLayer(int mipLayer) {
        this.mipLayer = mipLayer;
    }
}
