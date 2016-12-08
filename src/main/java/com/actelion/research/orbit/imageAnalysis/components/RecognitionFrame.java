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

import com.actelion.research.orbit.beans.RawAnnotation;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.tasks.ClassificationTaskTiled;
import com.actelion.research.orbit.imageAnalysis.tasks.ExclusionMapGen;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.imageAnalysis.utils.ShapePainterListener;
import com.actelion.research.orbit.imageAnalysis.utils.TiledImagePainter;
import com.actelion.research.orbit.imageAnalysis.utils.TiledImageWriter;
import com.actelion.research.orbit.utils.RawUtilsCommon;
import com.sun.media.jai.codec.JPEGEncodeParam;
import com.sun.media.jai.codec.TIFFEncodeParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.media.jai.JAI;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.*;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Component which holds a planarImage (bimg), a classification image (classImage) and additional shapes (e.g. segmentation objects).
 * The paint() method renders the image with all markup.
 * <p>
 * Attention: This class still holds a ClassShape list, even if the classShapes are stored in the model. So far this
 * is necessary because the drawn class regions (connected to a shapePaintListener) are stored here. This causes problems
 * e.g. in the NucleiSegmentationWorker which needs the classShapes of the (nested) segmentation model, so it first sets the
 * classShapes of the recognitionFrame to the segmentation model classShapes and later sets it back.
 * This should be refactored!!!
 * </p>
 */
public class RecognitionFrame extends JComponent implements PropertyChangeListener {

    private static final long serialVersionUID = 1L;
    public static int maxClassShapesToPaint = 10000;
    private static final Logger logger = LoggerFactory.getLogger(RecognitionFrame.class);
    private int windowSize = 4;
    private double targetRadius = 3.0d;  // just for drawing
    private double segmentationClassSize = 12.0d;
    private int boundaryClass = -1;
    private boolean contextClassificationEnabled = false;
    private TiledImageWriter classImage = null;
    @Deprecated
    private RecognitionFrame negativeChannel = null;
    private String picName = "";
    private String originalName = "";
    private final List<ClassShape> classShapes = Collections.synchronizedList(new ArrayList<ClassShape>());
    private final List<ImageAnnotation> annotations = Collections.synchronizedList(new ArrayList<ImageAnnotation>());
    private IScaleableShape ROI = null;
    private final HashMap<Integer, Byte> colorClassLookup = new HashMap<Integer, Byte>();
    private float opacity = 0f;
    private boolean drawMarkup = true;
    private double[] ratio = null; // has to be initialized to classShapeList.size
    private final List<Polygon> classList = new ArrayList<Polygon>();
    private final ReentrantReadWriteLock classListLock = new ReentrantReadWriteLock();

    private List<Shape> objectSegmentationList = null;
    private List<Shape> secondaryObjectSegmentationList = null;
    private List<Color> objectSegmentationColors = null;     // used for heatmap
    private int[] objectClassificationList = null;
    private List<Point> centerList = null;
    private List<Point> centroidList = null;
    @Deprecated
    private Arc2D.Double classBounds = null;
    private static final Color[] colors = new Color[]{Color.red, Color.blue, Color.green, Color.yellow, Color.cyan, Color.orange, Color.magenta, Color.pink, Color.lightGray};
    private static Random rand = new Random();
    private static Font toolTipFont = new Font("Arial", Font.PLAIN, 12);
    //private boolean fromResource = false;
    private double scale = 100d;
    private double oldScale = 100d;
    private double muMeterPerPixel = 0d;
    private Color gaugeColor = Color.black;
    private Point2D viewPortOffset = new Point2D.Double(0, 0);
    private Dimension2D viewPortSize = new Dimension2D_Double(0d, 0d);

    public enum Tools {brush, rectangle, cell, circle, delete, finger, roi, moveAnnotation, rotateAnnotation}

    ;
    private Tools selectedTool = Tools.finger;
    private ShapePainterListener myListener = null;
    @Deprecated
    public List<Point> pathList = new ArrayList<Point>();
    private String toolTip = null;
    private Point toolTipPosition = null;
    private double toolTipCurrentScale = 100d;
    private boolean showObjectToolTip = false;
    private MixtureStatistics mixStats = null;
    public TiledImagePainter bimg = new TiledImagePainter();
    private List<Callable<Double[]>> taskList = null;
    private Hashtable<Object, Double> threadProgress = null;
    private long startTime = 0L;
    private FeatureDescription featureDescription = new FeatureDescription(); // with default values
    private float classImageScale = 1.0f; // additional scaleFactor, e.g. if classification has been done on MIP image.
    private transient RenderThread _renderThread = null;
    private static final Color annotationBackgroundColor = new Color(1f, 1f, 1f, 0.6f);
    private boolean displayAnnotationLabels = true;
    private ExclusionMapGen exMapGen = null;
    private double mipScale = 1d;
    private static final boolean ignoreRepaint = true;
    private static final boolean opaque = false;
    private static final boolean doubleBuffered = true;
    private static final AtomicInteger activeAnnotationGroup = new AtomicInteger(0); // annotation group -> see annotationPanel

    /**
     * @param picObj can ob url or orbitId
     * @throws OrbitImageServletException
     */
    public RecognitionFrame(Object picObj) throws OrbitImageServletException {
        this(picObj, false);
    }


    public RecognitionFrame(Object picName, boolean fromResource) throws OrbitImageServletException {
        this.setOpaque(opaque);
        this.setIgnoreRepaint(ignoreRepaint);
        this.setDoubleBuffered(doubleBuffered);
        //this.fromResource = fromResource;
        classShapes.clear();
        classShapes.addAll(OrbitUtils.buildDefaultClassShapes());
        ratio = new double[classShapes.size()];
        if (picName != null)
            loadImage(picName, fromResource);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        myListener = new ShapePainterListener(this.getClassShapes().get(0).getShapeList(), this.getClassShapes().get(0).getName(), this); // at least one class has to exist!
        this.addMouseListener(myListener);
        this.addMouseMotionListener(myListener);
        this.addMouseWheelListener(myListener);
    }


    public RecognitionFrame(Object picName, boolean fromResource, List<ClassShape> classShapes, FeatureDescription featureDescription) {
        this.setOpaque(opaque);
        this.setIgnoreRepaint(ignoreRepaint);
        this.setDoubleBuffered(doubleBuffered);
        //this.fromResource = fromResource;
        this.classShapes.clear();
        this.classShapes.addAll(classShapes);
        this.featureDescription = featureDescription;
        this.windowSize = featureDescription.getWindowSize();
        ratio = new double[classShapes.size()];
        if (picName != null)
            try {
                loadImage(picName, fromResource);
            } catch (OrbitImageServletException e) {
                e.printStackTrace();
            }
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        myListener = new ShapePainterListener(this.getClassShapes().get(0).getShapeList(), this.getClassShapes().get(0).getName(), this); // at least one class has to exist!
        addMouseListeners();
    }

    /**
     * Creates a recognitionframe based on a MIP image of a parent recognition frame.<br>
     * Sets classShapes (copy), featureDescription, ratio and picName according to the parent.<br>
     * MouseListeners (ShapePainterListener) will be set if addMouseListeners is true.<br>
     * No check if requested MIP exists will be performed!
     *
     * @param parent
     * @param mipNum
     */
    public RecognitionFrame(RecognitionFrame parent, int mipNum, boolean addMouseListeners) {
        this.setOpaque(opaque);
        this.setIgnoreRepaint(ignoreRepaint);
        this.setDoubleBuffered(doubleBuffered);
        this.classShapes.clear();
        this.classShapes.addAll(OrbitUtils.cloneClassShapes(parent.getClassShapes()));
        this.featureDescription = parent.getFeatureDescription();
        this.windowSize = parent.getWindowSize();
        this.ratio = parent.getRatio();
        this.picName = parent.getPicName();
        this.bimg = parent.bimg.getMipMaps()[mipNum];
        this.muMeterPerPixel = parent.getMuMeterPerPixel() * (parent.bimg.getWidth() / (double) this.bimg.getWidth());
        this.setGaugeColor(parent.getGaugeColor());
        if (parent != null) {
            this.mipScale = (double) this.bimg.getWidth() / (double) parent.bimg.getWidth();
            // copy scaled roi
            if (parent.getROI() != null) {
                IScaleableShape roiScaled = (IScaleableShape) parent.getROI().getScaledInstance(((mipScale) * 100d), new Point(0, 0));
                roiScaled = roiScaled.clone();
                roiScaled.setScale(100d);
                this.setROI(roiScaled);
            }
        }

        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        if (addMouseListeners) {
            myListener = new ShapePainterListener(this.getClassShapes().get(0).getShapeList(), this.getClassShapes().get(0).getName(), this); // at least one class has to exist!
            this.addMouseListener(myListener);
            this.addMouseMotionListener(myListener);
            try {
                this.addMouseWheelListener(myListener);
            } catch (Exception e) {
            }
        }
    }


    public RecognitionFrame(TiledImagePainter tip) {
        this.setOpaque(opaque);
        this.setIgnoreRepaint(ignoreRepaint);
        this.setDoubleBuffered(doubleBuffered);
        this.classShapes.clear();
        this.classShapes.addAll(OrbitUtils.buildDefaultClassShapes());
        ratio = new double[classShapes.size()];
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        if (tip != null) {
            bimg = tip;
        }
    }


    public RecognitionFrame(RecognitionFrame parent, RawDataFile rdf, int level) {
        this.setOpaque(opaque);
        this.setIgnoreRepaint(ignoreRepaint);
        this.setDoubleBuffered(doubleBuffered);
        this.classShapes.clear();
        if (parent != null) {
            this.classShapes.addAll(OrbitUtils.cloneClassShapes(parent.getClassShapes()));
            this.featureDescription = parent.getFeatureDescription();
            this.windowSize = parent.getWindowSize();
            this.ratio = parent.getRatio();
        } else {
            classShapes.clear();
            classShapes.addAll(OrbitUtils.buildDefaultClassShapes());
            ratio = new double[classShapes.size()];
        }
        this.picName = rdf.getFileName() + " [" + level + "]";

        try {
            TiledImagePainter tip = new TiledImagePainter();
            tip.loadImageSpecial(rdf, level);
            if (tip == null) {
                logger.error("Special image not available");
            }

            if (true) {
                myListener = new ShapePainterListener(this.getClassShapes().get(0).getShapeList(), this.getClassShapes().get(0).getName(), this); // at least one class has to exist!
                this.addMouseListener(myListener);
                this.addMouseMotionListener(myListener);
                try {
                    this.addMouseWheelListener(myListener);
                } catch (Exception e) {
                }
            }
            this.bimg = tip;
            if (parent != null)
                this.mipScale = (double) this.bimg.getWidth() / (double) parent.bimg.getWidth();
            logger.trace("loading level {} image with width {}", level, this.bimg.getWidth());
            if (parent != null) {
                this.muMeterPerPixel = parent.getMuMeterPerPixel() * (parent.bimg.getWidth() / (double) this.bimg.getWidth());
                this.setGaugeColor(parent.getGaugeColor());
                // copy scaled roi
                if (parent.getROI() != null) {
                    IScaleableShape roiScaled = (IScaleableShape) parent.getROI().getScaledInstance(((mipScale) * 100d), new Point(0, 0));
                    roiScaled = roiScaled.clone();
                    roiScaled.setScale(100d);
                    this.setROI(roiScaled);
                }


                if (parent.getObjectSegmentationList() != null) {
                    // copy parent segmentations (important for object classification)
                    double originalCurrentFrameRatioInverse = parent.bimg.getImage().getWidth() / (double) this.bimg.getImage().getWidth();
                    if (this.getObjectSegmentationList() == null)
                        this.setObjectSegmentationList(new ArrayList<Shape>(parent.getObjectSegmentationList().size()));
                    this.getObjectSegmentationList().clear();
                    for (Shape shape : parent.getObjectSegmentationList()) {
                        this.getObjectSegmentationList().add(((IScaleableShape) shape).getScaledInstance(originalCurrentFrameRatioInverse * 100d, new Point(0, 0)));
                    }
                }
            }

        } catch (Exception e) {
            logger.error("error loading special image", e);
        }
    }

    /**
     * clones the parent RecognitionFrame. The TiledImagePainter (bimg) will be referenced (not really cloned)!!!
     *
     * @param parent
     * @param addMouseListeners
     */
    public RecognitionFrame(RecognitionFrame parent, boolean addMouseListeners) {
        this.setOpaque(opaque);
        this.setIgnoreRepaint(ignoreRepaint);
        this.setDoubleBuffered(doubleBuffered);
        this.classShapes.clear();
        this.classShapes.addAll(OrbitUtils.cloneClassShapes(parent.getClassShapes()));
        this.featureDescription = parent.getFeatureDescription();
        this.windowSize = parent.getWindowSize();
        this.ratio = parent.getRatio();
        this.picName = parent.getPicName();
        this.bimg = parent.bimg;
        this.muMeterPerPixel = parent.muMeterPerPixel;
        this.gaugeColor = parent.getGaugeColor();
        // copy scaled roi
        if (parent.getROI() != null) {
            IScaleableShape roiScaled = (IScaleableShape) parent.getROI().getScaledInstance((((double) this.bimg.getWidth() / parent.bimg.getWidth()) * 100d), new Point(0, 0));
            roiScaled = roiScaled.clone();
            roiScaled.setScale(100d);
            this.setROI(roiScaled);
        }

        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        if (addMouseListeners) {
            myListener = new ShapePainterListener(this.getClassShapes().get(0).getShapeList(), this.getClassShapes().get(0).getName(), this); // at least one class has to exist!
            this.addMouseListener(myListener);
            this.addMouseMotionListener(myListener);
            try {
                this.addMouseWheelListener(myListener);
            } catch (Exception e) {
            }
        }
    }


    /**
     * singleton factory for renderThread
     *
     * @return
     */
    private RenderThread getRenderThread() {
        if (_renderThread == null) {
            _renderThread = new RenderThread(this);
            _renderThread.setName("renderThread");
            _renderThread.addPropertyChangeListener(this);
            _renderThread.start();
        }
        return _renderThread;
    }

    /**
     * returns the renderthread without instantiation. <br/>
     * This might return null if the private getRenderThread (singleton) has never been called (for small images).
     *
     * @return
     */
    public RenderThread getRenderThreadOriginal() {
        return _renderThread;
    }

    public void addMouseListeners() {
        try {
            addMouseListener(myListener);
            addMouseMotionListener(myListener);
            addMouseWheelListener(myListener);  // >= Java 1.6
        } catch (Exception ex) {
        }
    }

    public void removeMouseListeners() {
        try {
            removeMouseListener(myListener);
            removeMouseMotionListener(myListener);
            removeMouseWheelListener(myListener);  // >= Java 1.6
        } catch (Exception ex) {
        }
    }

    /**
     * Obsolete since version 1.90i (no setPreferredSize done anymore)
     */
    @Deprecated
    public void scaleImage(double percentage) {
        scale = percentage;
        double scaleFactor = scale / 100d;
        double sizeX = bimg.getWidth() * scaleFactor;
        double sizeY = bimg.getHeight() * scaleFactor;
        this.setPreferredSize(new Dimension((int) sizeX, (int) sizeY));
    }


    public void loadImage(Object picNameOrUrl, boolean fromResource) throws OrbitImageServletException {
        loadImage(picNameOrUrl, fromResource, 0, 0, true);
    }

    public void loadImage(Object picNameOrUrl, boolean fromResource, int width, int height, boolean scaleIs100) throws OrbitImageServletException {
        if (picNameOrUrl == null) return;
        //this.fromResource= fromResource;
        if (picNameOrUrl instanceof RawDataFile) {
            this.picName = ((RawDataFile) picNameOrUrl).getFileName();
            this.originalName = ((RawDataFile) picNameOrUrl).getRawDataFileId() + "";
        } else {
            this.picName = picNameOrUrl.toString();
            this.originalName = picNameOrUrl.toString();
            if (picNameOrUrl instanceof String) {
                String[] splitStr = picNameOrUrl.toString().split("\\\\");
                if (splitStr != null && splitStr.length > 0)
                    this.picName = splitStr[splitStr.length - 1]; // just the filename without the path before
            }
        }
        try {
            if (fromResource) picNameOrUrl = this.getClass().getResource(picName);
            if (picNameOrUrl == null) picNameOrUrl = picName; // first load might be also a string
            bimg.loadImage(picNameOrUrl);
            //System.out.println("image: "+bimg.image);
            System.gc();
        } catch (Exception e) {
            logger.error("Error loading image. Probably the Orbit image server down or not accessible.\nError Details: ", e);
            if (e instanceof OrbitImageServletException) {
                throw new OrbitImageServletException(e.getMessage());
            }
        }
        this.setPreferredSize(new Dimension(bimg.getWidth(), bimg.getHeight()));

    }


    public void paintComponent(Graphics g) {
        if (bimg == null) return;
        Graphics2D g2d = (Graphics2D) g;
        try {
            // "viewPort"
            //System.out.println("vpSize: "+viewPortSize+" vpOffs: "+viewPortOffset+" image: "+bimg.image);
            //	GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().createCompatibleImage(height, width, Transparency.OPAQUE);

            if (viewPortSize.getWidth() <= 0 || viewPortSize.getHeight() <= 0) return;
            g2d.translate(-viewPortOffset.getX(), -viewPortOffset.getY());

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_SPEED);
            //g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

            AffineTransform oldTransform = g2d.getTransform();

            double sc = getScale() / 100d;
            double cx = getParent().getBounds().getCenterX();
            double cy = getParent().getBounds().getCenterY();
            double vpWidth = viewPortSize.getWidth();
            double vpHeight = viewPortSize.getHeight();


            if (bimg.hasMipMaps()) {
                // for TiledImagePainter rendering scale before drawing the image, for rendering from buffer scale after drawing the image
                if ((!getRenderThread().isBufferReady())) {
                    g2d.scale(sc, sc);
                    if (scale >= 100)
                        bimg.drawImage(g2d, viewPortOffset.getX(), viewPortOffset.getY(), vpWidth, vpHeight, getScale(), 0);
                        //else if (scale>30) bimg.drawImage(g2d, viewPortOffset.getX(),viewPortOffset.getY(),vpWidth,vpHeight,getScale(),bimg.getMipMaps().length-2);
                    else
                        bimg.drawImage(g2d, viewPortOffset.getX(), viewPortOffset.getY(), vpWidth, vpHeight, getScale(), bimg.getMipMaps().length - 1);
                } else {
                    g2d.drawImage(getRenderThread().getImageBuffer(), (int) viewPortOffset.getX(), (int) viewPortOffset.getY(), this);
                    g2d.scale(sc, sc);
                }
            } else // no mipMaps, so normal rendering
            {
                g2d.scale(sc, sc);
                bimg.drawImage(g2d, viewPortOffset.getX(), viewPortOffset.getY(), vpWidth, vpHeight, getScale(), -1);
            }


//			g2d.scale(sc, sc);
//			bimg.drawImage(g2d, viewPortOffset.x,viewPortOffset.y,vpWidth,vpHeight,getScale(),-1);

            // pathList
            if (pathList != null) {
                g2d.setColor(Color.red);
                //pathList.drawPolygon(g2d);
                for (Point p : pathList) {
                    g2d.fillRect(p.x, p.y, 1, 1);
                }
            }

            if ((toolTip != null) && (toolTipPosition != null)) {
                Color oldFront = g2d.getColor();
                g2d.setColor(Color.yellow);
                g2d.setFont(toolTipFont);
                g2d.drawString(toolTip, toolTipPosition.x, toolTipPosition.y);
                g2d.setColor(oldFront);
            }


            if (classBounds != null) {
                g2d.setColor(Color.black);
                g2d.drawArc((int) classBounds.x, (int) classBounds.y, (int) classBounds.width, (int) classBounds.height, 0, 360);
            }


            // TODO
            /*
	        if ((exMapGen!=null && exMapGen.getRecognitionFrame()!=null && exMapGen.getRecognitionFrame().getClassImage()!=null) && (opacity>0))
			{
				AffineTransform af = g2d.getTransform();
				g2d.scale(classImageScale, classImageScale);
				Rectangle rbb = new Rectangle(viewPortOffset.x, viewPortOffset.y, vpWidth, vpHeight);
				if (ROI!=null) {
					Rectangle roiBB = ROI.getScaledInstance(getScale(), new Point((int)cx,(int)cy)).getBounds();
					if (rbb.intersects(roiBB))
						rbb = rbb.intersection(roiBB);
				}
				exMapGen.getRecognitionFrame().getClassImage().drawImage(g2d, rbb.x,rbb.y,rbb.width,rbb.height,getScale()*classImageScale,opacity);
				//classImage.drawImage(g2d, viewPortOffset.x,viewPortOffset.y,viewPortSize.width,viewPortSize.height,getScale()*classImageScale,opacity);
				g2d.setTransform(af);
			}
			*/

            TiledImageWriter.timeOut.set(System.currentTimeMillis());
            if ((classImage != null) && (opacity > 0) && classImage.getPainting().get() == false) {
                AffineTransform af = g2d.getTransform();
                g2d.scale(classImageScale, classImageScale);
                Rectangle rbb = new Rectangle((int) viewPortOffset.getX(), (int) viewPortOffset.getY(), (int) vpWidth, (int) vpHeight);
                if (ROI != null) {
                    Rectangle roiBB = ROI.getScaledInstance(getScale(), new Point((int) cx, (int) cy)).getBounds();
                    if (roiBB != null /*&& rbb.intersects(roiBB)*/) {
                        rbb = rbb.intersection(roiBB);
                    }
                }
                classImage.drawImage(g2d, rbb.x, rbb.y, rbb.width, rbb.height, getScale() * classImageScale, opacity);
                //classImage.drawImage(g2d, viewPortOffset.x,viewPortOffset.y,viewPortSize.width,viewPortSize.height,getScale()*classImageScale,opacity);
                g2d.setTransform(af);
            }

            if (classImage != null) {
                if (drawMarkup) // draw found regions/objects
                {

                    if (classList != null && classList.size() > 0) {
                        g2d.setColor(Color.white);
                        if (classListLock.readLock().tryLock()) {
                            try {
                                for (Polygon poly : classList) {
                                    Rectangle rec = poly.getBounds();
                                    g2d.drawArc((int) rec.getCenterX() - (int) segmentationClassSize / 2, (int) rec.getCenterY() - (int) segmentationClassSize / 2, (int) segmentationClassSize, (int) segmentationClassSize, 0, 360);
                                }
                            } finally {
                                classListLock.readLock().unlock();
                            }
                        }
                    }

                    if (objectSegmentationList != null) {
                        try {
                            double scaleFactor = (getScale() / 100d);
                            int segSize = objectSegmentationList.size();
                            for (int i = 0; i < segSize; i++) {
                                Shape shape = objectSegmentationList.get(i);
                                if (shape == null) continue;
                                Point pos = null;
                                //	try {
                                pos = new Point((int) (myListener.getMousePosition().x / scaleFactor), (int) (myListener.getMousePosition().y / scaleFactor));
                                //	} catch (NullPointerException ex) {
                                //	}

                                if ((objectClassificationList != null) && (objectClassificationList.length == objectSegmentationList.size()) && (objectClassificationList[i] >= 0)) { // draw classification of objects (e.g. cells)
                                    g2d.setColor(classShapes.get(objectClassificationList[i]).getColor());
                                    if (shape instanceof Polygon)
                                        g2d.fillPolygon((Polygon) shape);
                                }

                                if (pos != null && shape.contains(pos)) g2d.setColor(Color.red);
                                else {
                                    g2d.setColor(Color.yellow);
                                    if (objectSegmentationColors != null && objectSegmentationColors.size() == segSize) {
                                        g2d.setColor(objectSegmentationColors.get(i));
                                    }
                                }
                                if (shape instanceof Polygon) {
                                    if (objectSegmentationColors != null && objectSegmentationColors.size() == segSize)
                                        g2d.fillPolygon((Polygon) shape);
                                    else drawPolygonLine((Polygon) shape, g2d);
                                }

                            }
                        } catch (Exception e) {
                            // might fail because objectSegmentationList is null -> better use a final synchronized list
                        }
                    }

                    if (secondaryObjectSegmentationList != null) {
                        try {
                            double scaleFactor = (getScale() / 100d);
                            int segSize = secondaryObjectSegmentationList.size();
                            for (int i = 0; i < segSize; i++) {
                                Shape shape = secondaryObjectSegmentationList.get(i);
                                if (shape == null) continue;
                                Point pos = null;
                                pos = new Point((int) (myListener.getMousePosition().x / scaleFactor), (int) (myListener.getMousePosition().y / scaleFactor));
                                if (pos != null && shape.contains(pos)) g2d.setColor(Color.red);
                                else g2d.setColor(Color.green);
                                if (shape instanceof Polygon) {
                                    drawPolygonLine((Polygon) shape, g2d);
                                }
                            }
                        } catch (Exception e) {
                            // might fail because objectSegmentationList is null -> better use a final synchronized list
                        }
                    }


                    if (centerList != null) {
                        for (Point center : centerList) {
                            g2d.setColor(Color.red);
                            g2d.drawRect(center.x - 1, center.y - 1, 3, 3);
                        }
                    }
					/*
					if (centroidList!=null) {
						for (Point centroid: centroidList) {
							g2d.setColor(Color.green);
							g2d.drawRect(centroid.x-1,centroid.y-1,3,3);
						}
					}
					*/


                }

            }
            g2d.setTransform(oldTransform);


            g2d.setColor(Color.white);
            // draw arc or fixed rectangle if in arc mode at mouse position
            MouseListener listener = myListener;
            if (listener instanceof ShapePainterListener) {
                // arc
                if (((ShapePainterListener) listener).getShapeMode() == ClassShape.SHAPETYPE_ARC &&
                        (!((ShapePainterListener) listener).isDeleteMode())) {
                    Point mp = ((ShapePainterListener) listener).getMousePosition();
                    if (mp != null) {
                        int r = (int) getTargetRadius();
                        Arc2D p = new Arc2D.Double(Arc2D.CHORD);
                        p.setArcByCenter(mp.getX(), mp.getY(), r, 0d, 360d, Arc2D.CHORD);
                        g2d.drawArc((int) p.getX(), (int) p.getY(), (int) p.getWidth(), (int) p.getHeight(), 0, 360);
                    }
                }

                // fixed rectangle
                if (((ShapePainterListener) listener).getShapeMode() == ClassShape.SHAPETYPE_RECTANGLE &&
                        ((ShapePainterListener) listener).isFixedRectangle() == true &&
                        (!((ShapePainterListener) listener).isDeleteMode())) {
                    Point mp = ((ShapePainterListener) listener).getMousePosition();
                    if (mp != null) {
                        int r = (int) getTargetRadius();
                        double fixedRectangleRatio = ((ShapePainterListener) listener).getFixedRectangleRatio();
                        //int w = r/2;
                        int w = (int) ((r / 2) * (getScale() / 100d));
                        int h = (int) ((double) w * fixedRectangleRatio);
                        g2d.drawRect(mp.x - w, mp.y - h, w * 2, h * 2);
                    }
                }

            } else logger.error("error: MouseListener is not a  ShapePainterListener");


            // toolTip
            if ((showObjectToolTip == true) && (toolTipPosition != null) && (mixStats != null) && (objectSegmentationList != null)) {
                String tip = null;
                double scaleFactor = (getScale() / 100d);
                Point pos = new Point((int) (toolTipPosition.x / scaleFactor), (int) (toolTipPosition.y / scaleFactor));
                for (int i = 0; i < objectSegmentationList.size(); i++) {
                    if (objectSegmentationList.get(i).contains(pos)) {
                        tip = mixStats.getObjDescription(i);
                        break;
                    }
                }
                if (tip != null) {
                    //Color oldFront = g2d.getColor();
                    g2d.setFont(toolTipFont);
                    Rectangle2D r = toolTipFont.getStringBounds(tip, g2d.getFontRenderContext());
                    g2d.setColor(Color.white);
                    g2d.fillRoundRect((int) r.getX() + toolTipPosition.x - 3, (int) r.getY() + toolTipPosition.y - 3, (int) r.getWidth() + 6, (int) r.getHeight() + 6, 12, 12);
                    g2d.setColor(Color.black);
                    g2d.drawString(tip, toolTipPosition.x, toolTipPosition.y);
                    //g2d.setColor(oldFront);
                }
            }

            // draw ploygons
            Point currentOffs = new Point((int) cx, (int) cy);
            if (drawMarkup) {
                int csCnt = 0;
                synchronized (classShapes) {
                    for (ClassShape classShape : classShapes) {
                        csCnt++;
                        if (csCnt > maxClassShapesToPaint) break;
                        if (classShape.getShapeList() != null) {
                            g2d.setColor(classShape.getColor());
                            for (Shape p : classShape.getShapeList()) {
                                //AffineTransform af = AffineTransform.getScaleInstance(0.9d, 0.9d);
                                //Path2D p2 = (Path2D)af.createTransformedShape(p);
                                if (p instanceof PolygonExt) {
                                    drawPolygonLine(((PolygonExt) p).getScaledInstance(getScale(), currentOffs), g2d);
                                } else if (p instanceof Arc2DExt) {
                                    if (p instanceof Arc2DExt)
                                        p = ((Arc2DExt) p).getScaledInstance(getScale(), currentOffs);
                                    g2d.drawArc((int) ((Arc2DExt) p).getX(), (int) ((Arc2DExt) p).getY(), (int) ((Arc2DExt) p).getWidth(), (int) ((Arc2DExt) p).getHeight(), 0, 360);
                                } else if (p instanceof RectangleExt) {
                                    RectangleExt re = ((RectangleExt) p).getScaledInstance(getScale(), currentOffs);
                                    g2d.drawRect((int) re.getX(), (int) re.getY(), (int) re.getWidth(), (int) re.getHeight());
                                }
                            }
                        }
                    }
                } // synchronized(classShapes)

                // draw Annotations
                Stroke oldStroke = g2d.getStroke();
                g2d.setStroke(new BasicStroke(2));
                synchronized (annotations) {
                    OrbitModel model = null;
                    if (annotations != null && annotations.size() > 0) {
                        model = OrbitImageAnalysis.getInstance().getModel();
                    }
                    for (ImageAnnotation annotation : annotations) {

                        if (getActiveAnnotationGroup().get() > 0) {   // filter annotations by group
                            if (getActiveAnnotationGroup().get() != annotation.getGroup()) {
                                continue; // skip displaying annotation (group not active)
                            }
                        }

                        Point jitterOffs = (Point) currentOffs.clone();
                        ClassShape classShape = annotation.getShape();
                        if (classShape != null && classShape.getShapeList() != null) {
                            double addscale = 1d;
                            g2d.setColor(classShape.getColor());
                            if (annotation.isSelected()) {    // highlight selected annotation
                                g2d.setColor(Color.magenta);
                            }
                            if (annotation instanceof SpotAnnotation) {
                                SpotAnnotation sa = (SpotAnnotation) annotation;
                                if (sa.isSelected()) {
                                    g2d.setColor(Color.yellow);
                                } else {
                                    // set class color
                                    if (sa.getClassNum() >= 0 && model != null && model.getClassShapes().size() > sa.getClassNum()) {
                                        g2d.setColor(model.getClassShapes().get(sa.getClassNum()).getColor());
                                    }
                                }
                            }
                            for (Shape p : classShape.getShapeList()) {
                                if (p instanceof PolygonExt) {
                                    drawPolygonLine(((PolygonExt) p).getScaledInstance(getScale(), currentOffs), g2d);
                                } else if (p instanceof Arc2DExt) {
                                    if (p instanceof Arc2DExt)
                                        p = ((Arc2DExt) p).getScaledInstance(getScale(), currentOffs);
                                    g2d.drawArc((int) ((Arc2DExt) p).getX(), (int) ((Arc2DExt) p).getY(), (int) ((Arc2DExt) p).getWidth(), (int) ((Arc2DExt) p).getHeight(), 0, 360);
                                } else if (p instanceof RectangleExt) {
                                    RectangleExt re = ((RectangleExt) p).getScaledInstance(getScale(), currentOffs);
                                    g2d.drawRect((int) re.getX(), (int) re.getY(), (int) re.getWidth(), (int) re.getHeight());
                                }

                                if (displayAnnotationLabels && (p instanceof PolygonExt) && (((PolygonExt) p).isClosed())) {
                                    Rectangle br = p.getBounds();
                                    Point uppRight = getUppedRightPoint((PolygonExt) p);
                                    int ax = br.x + br.width;
                                    int ay = br.y;
                                    double scaleFactor = (getScale() / ((IScaleableShape) p).getScale());
                                    ax = (int) (ax * scaleFactor);
                                    ay = (int) (ay * scaleFactor);
                                    int dx = (int) (uppRight.x * scaleFactor);
                                    int dy = (int) (uppRight.y * scaleFactor);
                                    g2d.setFont(toolTipFont);
                                    String text = annotation.getDescription();
                                    if (text.length() > 40) text = text.subSequence(0, 40) + "...";
                                    Rectangle2D r = toolTipFont.getStringBounds(text, g2d.getFontRenderContext());
                                    g2d.setColor(annotationBackgroundColor);
                                    g2d.fillRoundRect((int) r.getX() + ax - 3, (int) r.getY() + ay - 3, (int) r.getWidth() + 6, (int) r.getHeight() + 6, 12, 12);
                                    g2d.drawLine(dx, dy, ax, ay);
                                    g2d.setColor(Color.black);
                                    g2d.drawString(text, ax, ay);
                                }
                            }
                        }
                    } // annotations
                } // synchronized annotations
                g2d.setStroke(oldStroke);
                // drow ROI
                if (ROI != null && (ROI instanceof PolygonExt)) {
                    g2d.setColor(Color.yellow);
                    //g2d.setXORMode(Color.white);
                    drawPolygonLine(((PolygonExt) ROI).getScaledInstance(getScale(), currentOffs), g2d);
                }

            } // drawMarkup


            // without vieportOffset
            g2d.translate(viewPortOffset.getX(), viewPortOffset.getY());

            if (muMeterPerPixel > 0 && OrbitImageAnalysis.getInstance().isShowGauge()) {
                final int gaugeLen = 100;
//				Component c = getParent().getParent().getParent().getParent().getParent(); // imageFrame
//				int gaugeY = c.getHeight()-100+viewPortOffset.y;
//				int gaugeX = 20+viewPortOffset.x;
//				
                int gaugeY = getHeight() - 40;  // was -80
                int gaugeX = 20;

                double gaugeVal = (double) gaugeLen * muMeterPerPixel * (1d / sc);
                //g.setColor(Color.white);
                //g.fillRect(gaugeX, gaugeY, gaugeLen, 15);
                g2d.setColor(gaugeColor);
                g2d.drawLine(gaugeX, gaugeY, gaugeX + gaugeLen, gaugeY);
                g2d.drawLine(gaugeX, gaugeY - 10, gaugeX, gaugeY + 10);
                g2d.drawLine(gaugeX + gaugeLen, gaugeY - 10, gaugeX + gaugeLen, gaugeY + 10);
                g2d.drawString(String.format("%1$.2f µm", gaugeVal), gaugeX + 5, gaugeY + 13);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            g2d.dispose();
        }

    }

    public void prepareBuffer() {
        if (bimg != null && bimg.hasMipMaps()) {
            getRenderThread().setValuesDirty(true);
            //if (renderThread.isScheduleUpdate()) return;
            //renderThread.stop();
            //renderThread = new RenderThread();
            //renderThread.addPropertyChangeListener(this);
            getRenderThread().setScale(getScale());
            getRenderThread().setViewPortWidth(getViewPortSize().getWidth());
            getRenderThread().setViewPortHeight(getViewPortSize().getHeight());
            getRenderThread().setViewPortOffsetX(getViewPortOffset().getX());
            getRenderThread().setViewPortOffsetY(getViewPortOffset().getY());
            getRenderThread().setTiledImagePainter(bimg);
            getRenderThread().setScheduleUpdate(true);
            //renderThread.start();
        }

    }

    @Override
    public void repaint() {
        TiledImageWriter.timeOut.set(System.currentTimeMillis());
        super.repaint();
    }

    @Override
    public void repaint(long tm, int x, int y, int width, int height) {
        TiledImageWriter.timeOut.set(System.currentTimeMillis());
        super.repaint(tm, x, y, width, height);
    }

    @Override
    public void repaint(Rectangle r) {
        TiledImageWriter.timeOut.set(System.currentTimeMillis());
        super.repaint(r);
    }

    @Override
    public void repaint(int x, int y, int width, int height) {
        TiledImageWriter.timeOut.set(System.currentTimeMillis());
        super.repaint(x, y, width, height);
    }

    @Override
    public void repaint(long tm) {
        TiledImageWriter.timeOut.set(System.currentTimeMillis());
        super.repaint(tm);
    }

    @Override
    public void update(Graphics g) {
        TiledImageWriter.timeOut.set(System.currentTimeMillis());
        super.update(g);
    }


    /**
     * set all pixels in classImage with class label in oldClasses to the newClass label  (for two class sets, e.g. set inclusion and exclusion at once)
     */
    public void changeClassLabels(List<Byte> oldClasses1, Byte newClass1, List<Byte> oldClasses2, Byte newClass2) {
        if (classImage == null)
            throw new IllegalArgumentException("classImage is null, please perform a classification first.");
        initializeClassColors();
        Color c1 = classShapes.get(newClass1).getColor();
        Color c2 = classShapes.get(newClass2).getColor();
        Byte classVal;
        Shape roi = null;
        if (getROI() != null) roi = getROI().getScaledInstance(100d, new Point(0, 0));
        Point[] tileList = classImage.getImage().getTileIndices(null);
        for (Point tile : tileList) {
            WritableRaster writeRaster = classImage.getImage().getWritableTile(tile.x, tile.y);
            for (int x = classImage.getImage().tileXToX(tile.x); x < classImage.getImage().tileXToX(tile.x) + classImage.getImage().getTileWidth(); x++)
                for (int y = classImage.getImage().tileYToY(tile.y); y < classImage.getImage().tileYToY(tile.y) + classImage.getImage().getTileHeight(); y++) {
                    if ((roi == null) || (roi.contains(x, y))) {
                        classVal = getClass(x, y, writeRaster);
                        if (classVal != null) {
                            for (Byte cv : oldClasses1) {
                                if (cv == classVal) {
                                    writeRaster.setPixel(x, y, new int[]{c1.getRed(), c1.getGreen(), c1.getBlue(), 255});
                                    break;
                                }
                            }
                            for (Byte cv : oldClasses2) {
                                if (cv == classVal) {
                                    writeRaster.setPixel(x, y, new int[]{c2.getRed(), c2.getGreen(), c2.getBlue(), 255});
                                    break;
                                }
                            }
                        }
                    } // ROI check
                } // x,y
            classImage.getImage().releaseWritableTile(tile.x, tile.y);
            //DiskMemImage.getCommonTileCache().flush(); // really needed?
        } // tile
    }


    public void makeImageSnapshot() {
        if (((long) bimg.getWidth() * bimg.getHeight()) > (8000L * 8000L)) {
            JOptionPane.showMessageDialog(this, "In the current version this feature can only be used for images where width*height <= 8000*8000.\nHowever, you can use the Orbit Agent to download the file.", "Image too large", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.tif", "tif");
        fc.setFileFilter(filter);
        String snapShotFileName = getPicName();
        snapShotFileName = snapShotFileName.replaceAll(RawUtilsCommon.getExtension(snapShotFileName, false), "tif");
        fc.setSelectedFile(new File(snapShotFileName));

        int returnVal = fc.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {

            logger.debug("begin making image snapshot");
            String fn = fc.getSelectedFile().getAbsolutePath();
            if (!fn.toLowerCase().endsWith(".tif")) fn += ".tif";

            Dimension2D oldVPSize = viewPortSize;
            Point2D oldVPOffs = getViewPortOffset();
            double sc = getScale();
            setScale(100d);
            setViewPortOffset(new Point(0, 0));
            viewPortSize = new Dimension(bimg.getWidth(), bimg.getHeight());
		
			/*
			ColorModel colorModel = new ComponentColorModel(
					 ColorSpace.getInstance(ColorSpace.CS_sRGB),
					 new int[]{8,8,8}, false, false,
					 Transparency.OPAQUE, 
					 DataBuffer.TYPE_BYTE); 
			SampleModel sampleModel = colorModel.createCompatibleSampleModel(256, 256);
			DiskMemImage tiledImage = new DiskMemImage(0, 0, bimg.getWidth(), bimg.getHeight(), 0, 0, sampleModel, colorModel);
			Graphics2D g2d = (Graphics2D)tiledImage.createGraphics();
			((DiskMemImageGraphics)g2d).overwriteRenderingHint((((Graphics2D)getGraphics()).getRenderingHints()));
			*/
            // Update 1.7.2010: Fallback to normal bufferedImage (only up to 30kx30k pixel!)
            // due to rendering problems with class image (only first tile problem)

            BufferedImage buffImg = new BufferedImage(bimg.getWidth(), bimg.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = buffImg.createGraphics();
            buffImg.flush();


            paint(g2d);
            setScale(sc);
            setViewPortOffset(oldVPOffs);
            viewPortSize = oldVPSize;
            logger.info("finished painting");

            TIFFEncodeParam param = new TIFFEncodeParam();
            param.setTileSize(128, 128);
            param.setWriteTiled(true);
            param.setCompression(TIFFEncodeParam.COMPRESSION_JPEG_TTN2);
            JPEGEncodeParam jpgParam = new JPEGEncodeParam();
            jpgParam.setQuality(0.85f);
            param.setJPEGEncodeParam(jpgParam);

            // TODO: extraImages (Iterator where .next() returns further (low-res) RenderedImages
            //param.setExtraImages(extraImages)

            JAI.create("filestore", /*tiledImage*/buffImg, fn, "TIFF", param);

            logger.info("finished writing");

            JOptionPane.showMessageDialog(null, "Image successfully saved to " + fn, "Image saved", JOptionPane.INFORMATION_MESSAGE);

            //tiledImage = null;
            //DiskMemImage.getCommonTileCache().flush();
            Runtime.getRuntime().gc();
            Runtime.getRuntime().gc();
            Runtime.getRuntime().gc();
            logger.debug("cleaning up finished");

        }

    }


    public BufferedImage getImageSnapshot() {
        if (((long) bimg.getWidth() * bimg.getHeight()) > (30000 * 30000)) {
            JOptionPane.showMessageDialog(this, "In the current version this feature can only be used for images where width*height <= 30000*30000.", "Image too large", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        Dimension2D oldVPSize = viewPortSize;
        Point2D oldVPOffs = getViewPortOffset();
        double sc = getScale();
        setScale(100d);
        setViewPortOffset(new Point(0, 0));
        viewPortSize = new Dimension(bimg.getWidth(), bimg.getHeight());

        BufferedImage buffImg = new BufferedImage(bimg.getWidth(), bimg.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = buffImg.createGraphics();
        buffImg.flush();

        paint(g2d);
        setScale(sc);
        setViewPortOffset(oldVPOffs);
        viewPortSize = oldVPSize;
        logger.debug("finished painting");
        return buffImg;
    }


    /**
     * (re)init of colorClassLookup
     */
    public void initializeClassColors() {
        //colorClassLookup = new HashMap<Integer, Byte>(classShapes.size());
        colorClassLookup.clear();
        synchronized (classShapes) {
            for (byte i = 0; i < classShapes.size(); i++) {
                ClassShape cs = classShapes.get(i);
                colorClassLookup.put(cs.getColor().getRGB(), i);
                //System.out.println("init color: "+cs.getColor().toString()+" -> "+i+" ("+cs.getColor().getRGB()+")");
            }
        }

//		System.out.println("CS: ");
//		for (Integer i: colorClassLookup.keySet()) {
//			System.out.println(i+":"+colorClassLookup.get(i));
//		}
    }


    /**
     * requires getObjectSegmentation to be called first
     *
     * @return
     */
    public List<double[]> getMixtures() {
        if (objectSegmentationList == null) throw new RuntimeException("Error: call getObjectSegmentations first!");
        if (classImage == null) throw new RuntimeException("Error: call classifyImage first!");
        List<double[]> mixList = new ArrayList<double[]>(objectSegmentationList.size());
        for (Shape shape : objectSegmentationList) {
            int sum = 0;
            double[] mix = new double[classShapes.size()];
            for (int i = 0; i < mix.length; i++) mix[i] = 0d;
            for (int x = (int) shape.getBounds().getMinX(); x < shape.getBounds().getMaxX(); x++)
                for (int y = (int) shape.getBounds().getMinY(); y < shape.getBounds().getMaxY(); y++) {
                    if (shape.contains(x, y)) {
                        mix[getClass(x, y)]++;
                        sum++;
                    }
                }
            for (int i = 0; i < mix.length; i++) mix[i] = mix[i] / (double) sum;
            mixList.add(mix);
        }
        return mixList;
    }


    private void drawPolygonLine(Polygon poly, Graphics g) {
        if (poly instanceof PolygonExt) {
            ((PolygonExt) poly).drawPolygon(g);
        } else {
            g.drawPolygon(poly);
        }
    }

    private Point getUppedRightPoint(Polygon poly) {
        int x = poly.getBounds().x;
        int y = poly.getBounds().y + poly.getBounds().height;
        for (int i = 0; i < poly.npoints; i++) {
            if (poly.xpoints[i] > x && poly.ypoints[i] < y) {
                x = poly.xpoints[i];
                y = poly.ypoints[i];
            }
        }
        return new Point(x, y);
    }

    public static Color getColorByNum(int num) {
        if (num < colors.length) return colors[num];
        else return new Color((num * 10000) + rand.nextInt());
    }


    /**
     * returns the class number (in byte) of a position (calls classImage.getPixel(x,y))<br>
     *
     * @param x
     * @param y
     * @return
     */
    public byte getClass(int x, int y) {
        // TODO: performance! (but currently not so bad)
        Byte b = colorClassLookup.get(classImage.getPixel(x, y));
        if (b == null) return 0;
        else return b;
    }

    /**
     * returns the class number (in byte) of a position (calls classImage.getPixel(x,y))<br>
     * here the classImage can be specified (used by cell segmentation).
     *
     * @param x
     * @param y
     * @return
     */
    public byte getClass(int x, int y, TiledImageWriter classImage2) {
        Byte b = colorClassLookup.get(classImage2.getPixel(x, y));
        if (b == null) {
            return 0;
        } else return b;
    }

    /**
     * returns the class number (in byte) of a position (calls classImage.getPixel(x,y,raster))<br>
     * here the classImage can be specified (used by cell segmentation).
     *
     * @param x
     * @param y
     * @return
     */
    public byte getClass(int x, int y, TiledImageWriter classImage2, Raster raster) {
        Byte b = colorClassLookup.get(classImage2.getPixel(x, y, raster));
        if (b == null) {
            return 0;
        } else return b;
    }

    /**
     * returns the class number (in byte) of a position (calls classImage.getPixel(x,y,r))<br>
     * This is the more performant method where the raster is already available.
     * Returns nullVal if x,y is outside ROI !
     *
     * @param x
     * @param y
     * @return
     */
    public byte getClass(int x, int y, final Raster r, final byte nullVal) {
        int i = classImage.getPixel(x, y, r);
        if (i == OrbitUtils.UNDEF_COLOR) return nullVal; // black / undef
        byte b = colorClassLookup.get(i);
        return b;
    }

    /**
     * returns the class number (in byte) of a position (calls classImage.getPixel(x,y,r))<br>
     * Can return null if x,y is outsite ROI !
     * This is the more performant method where the raster is already available.
     *
     * @param x
     * @param y
     * @return
     */
    public Byte getClass(int x, int y, final Raster r) {
        int i = classImage.getPixel(x, y, r);
        if (i == OrbitUtils.UNDEF_COLOR) return null; // black / undef
        Byte b = colorClassLookup.get(i);
        //if (b==null) System.out.println(i);
        return b;
    }


    public List<ClassShape> getClassShapes() {
        return classShapes;
    }

    public void setClassShapes(List<ClassShape> classShapes) {
        synchronized (this.classShapes) {
            this.classShapes.clear();
            this.classShapes.addAll(classShapes);
            ratio = new double[classShapes.size()];
        }
    }

    public void setClassShapes(final List<ClassShape> classShapes, int segmentationSize) {
        synchronized (this.classShapes) {
            this.classShapes.clear();
            this.classShapes.addAll(classShapes);
            this.segmentationClassSize = segmentationSize;
            ratio = new double[classShapes.size()];
        }
    }

    public void setModel(OrbitModel model) {
        setClassShapes(model.getClassShapes());
        setWindowSize(model.getFeatureDescription().getWindowSize());
        setBoundaryClass(model.getBoundaryClass());
    }

    /**
     * annotationGroup -1 means ignore, 0 means use all, otherwise the specific group
     *
     * @param rdfID
     * @param annotationGroup
     */
    public void loadAnnotationROI(int rdfID, int annotationGroup) {
        loadAnnotationROI(rdfID, annotationGroup, false);
    }

    /**
     * annotationGroup -1 means ignore, 0 means use all, otherwise the specific group
     *
     * @param rdfID
     * @param annotationGroup
     */
    public void loadAnnotationROI(int rdfID, int annotationGroup, boolean otherGroupROIAsExclusion) {
        if (annotationGroup < 0) {
            setROI(null);
            return; // ignore
        }
        try {
            IScaleableShape roi = OrbitUtils.loadAnnotationROI(rdfID, annotationGroup, otherGroupROIAsExclusion);
            if ((roi != null) && Math.abs(mipScale - 1d) > OrbitUtils.EPSILON) {
                roi = (IScaleableShape) roi.getScaledInstance(((mipScale) * 100d), new Point(0, 0));
                roi.setScale(100d);
            }

            setROI(roi);
        } catch (Exception e) {
            logger.error("cannot load raw annotations", e);
        }
    }


    /**
     * load image annotations according to rdfID. Annotation with name ROI are used as ROI, if useAnnotationsAsInverseROI is true, all other annotations
     * (description<>ROI are used as inverse ROI). ROI and inverse ROIs can be combined.
     */
    @Deprecated
    public void loadAnnotationROIOld(int rdfID, boolean useAnnotationsAsInverseROI) {
        try {
            List<RawAnnotation> annotations = DALConfig.getImageProvider().LoadRawAnnotationsByRawDataFile(rdfID, RawAnnotation.ANNOTATION_TYPE_IMAGE);
            List<Shape> pList = new ArrayList<Shape>(annotations.size());
            Shape annotationROI = null;
            for (RawAnnotation anno : annotations) {
                if (anno.getRawAnnotationType() == RawAnnotation.ANNOTATION_TYPE_IMAGE) {
                    ImageAnnotation ia = new ImageAnnotation(anno);
                    if (ia.getShape().getShapeList().size() > 0) {
                        IScaleableShape poly = (IScaleableShape) ia.getShape().getShapeList().get(0);
                        IScaleableShape pScaled = (IScaleableShape) poly.getScaledInstance(100d, new Point(0, 0));
                        if (anno.getDescription().trim().equalsIgnoreCase("ROI")) {
                            annotationROI = pScaled;
                        } else {
                            if (useAnnotationsAsInverseROI)
                                pList.add(pScaled);
                        }
                    }
                }
            }
            ShapeExtListInvers roi = new ShapeExtListInvers(annotationROI, pList, new Rectangle(Integer.MAX_VALUE, Integer.MAX_VALUE));
            setROI(roi);
            logger.trace("invers annotation ROI successfully set: " + pList.size());
        } catch (Exception e) {
            logger.error("cannot load raw annotations", e);
        }
    }

    /**
     * loads the mu meter per pixel meta data from raw meta database
     */
    public void loadImageScale(int rdfId) {
        setMuMeterPerPixel(OrbitUtils.loadImageScale(rdfId));
    }

    @Override
    public String toString() {
        return "RecognitionFrame [picName=" + picName + ", ROI=" + ROI + ", scale=" + scale + ", muMeterPerPixel=" + muMeterPerPixel + ", bimg=" + bimg + "]";
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public float getOpacity() {
        return opacity;
    }

    public void setOpacity(float opacity) {
        this.opacity = opacity;
    }

    public double[] getRatio() {
        return ratio;
    }

    public void setRatio(double[] ratio) {
        this.ratio = ratio;
    }

    public TiledImageWriter getClassImage() {
        return classImage;
    }

    public void setClassImage(TiledImageWriter classImage) {
        this.classImage = classImage;
    }

    public boolean isDrawMarkup() {
        return drawMarkup;
    }

    public void setDrawMarkup(boolean drawMarkup) {
        this.drawMarkup = drawMarkup;
    }

    public double getTargetRadius() {
        return targetRadius;
    }

    public void setTargetRadius(double targetRadius) {
        this.targetRadius = targetRadius;
    }


    public int getWindowSize() {
        return windowSize;
    }

    public void setWindowSize(int windowSize) {
        this.windowSize = windowSize;
    }


    public double getSegmentationClassSize() {
        return segmentationClassSize;
    }

    public void setSegmentationClassSize(double segmentationClassSize) {
        this.segmentationClassSize = segmentationClassSize;
    }


    public List<Polygon> getClassList() {
        return classList;
    }


    public void clearClassList() {
        classListLock.writeLock().lock();
        try {
            this.classList.clear();
        } finally {
            classListLock.writeLock().unlock();
        }
    }

    public List<Shape> getObjectSegmentationList() {
        return objectSegmentationList;
    }

    public void setObjectSegmentationList(List<Shape> objectSegmentationList) {
        this.objectSegmentationList = objectSegmentationList;
    }

    public List<Color> getObjectSegmentationColors() {
        return objectSegmentationColors;
    }

    public void setObjectSegmentationColors(List<Color> objectSegmentationColors) {
        this.objectSegmentationColors = objectSegmentationColors;
    }


    public List<Point> getCenterList() {
        return centerList;
    }

    public void setCenterList(List<Point> centerList) {
        this.centerList = centerList;
    }

    public List<Point> getCentroidList() {
        return centroidList;
    }

    public void setCentroidList(List<Point> centroidList) {
        this.centroidList = centroidList;
    }

    public void setScale(double scale) {
        this.scale = scale;
        prepareBuffer();
    }

    /**
     * scale 0..100
     *
     * @return
     */
    public double getScale() {
        //return ((double)bimg.getWidth() / originalWidth)*(double)100;
        return scale;
    }

    public Point2D getViewPortOffset() {
        return viewPortOffset;
    }

    public void setViewPortOffset(Point2D viewPortOffset) {
        this.viewPortOffset = viewPortOffset;
        prepareBuffer();
    }

    public void addViewPortOffset(Point2D addOffset) {
        this.viewPortOffset.setLocation(viewPortOffset.getX() + addOffset.getX(), viewPortOffset.getY() + addOffset.getY());
        prepareBuffer();
    }

    public Tools getSelectedTool() {
        return selectedTool;
    }

    public void setSelectedTool(Tools selectedTool) {
        this.selectedTool = selectedTool;
    }

    public ShapePainterListener getMyListener() {
        return myListener;
    }

    public void setMyListener(ShapePainterListener myListener) {
        this.myListener = myListener;
    }

    @Deprecated
    public boolean isContextClassificationEnabled() {
        return contextClassificationEnabled;
    }

    @Deprecated
    public void setContextClassificationEnabled(boolean contextClassificationEnabled) {
        this.contextClassificationEnabled = contextClassificationEnabled;
    }

    @Deprecated
    public int getBoundaryClass() {
        return boundaryClass;
    }

    @Deprecated
    public void setBoundaryClass(int boundaryClass) {
        this.boundaryClass = boundaryClass;
        if (boundaryClass == -1) classBounds = null;
    }

    public String getToolTip() {
        return toolTip;
    }

    public void setToolTip(String toolTip) {
        this.toolTip = toolTip;
    }

    public Point getToolTipPosition() {
        return toolTipPosition;
    }

    public void setToolTipPosition(Point toolTipPosition) {
        this.toolTipPosition = toolTipPosition;
    }

    public boolean isShowObjectToolTip() {
        return showObjectToolTip;
    }

    public void setShowObjectToolTip(boolean showObjectToolTip) {
        this.showObjectToolTip = showObjectToolTip;
    }

    public MixtureStatistics getMixStats() {
        return mixStats;
    }

    public void setMixStats(MixtureStatistics mixStats) {
        this.mixStats = mixStats;
    }

    public double getToolTipCurrentScale() {
        return toolTipCurrentScale;
    }

    public void setToolTipCurrentScale(double toolTipCurrentScale) {
        this.toolTipCurrentScale = toolTipCurrentScale;
    }

    public double getOldScale() {
        return oldScale;
    }

    public void setOldScale(double oldScale) {
        this.oldScale = oldScale;
    }


    public int[] getObjectClassificationList() {
        return objectClassificationList;
    }

    public synchronized void setObjectClassificationList(int[] objectClassificationList) {
        this.objectClassificationList = objectClassificationList;
    }


    public FeatureDescription getFeatureDescription() {
        return featureDescription;
    }


    public IScaleableShape getROI() {
        return ROI;
    }

    public void setROI(IScaleableShape rOI) {
        ROI = rOI;
    }


    public List<ImageAnnotation> getAnnotations() {
        return annotations;
    }

    public float getClassImageScale() {
        return classImageScale;
    }

    public void setClassImageScale(float classImageScale) {
        this.classImageScale = classImageScale;
    }


    public double getMuMeterPerPixel() {
        return muMeterPerPixel;
    }

    public void setMuMeterPerPixel(double muMeterPerPixel) {
        this.muMeterPerPixel = muMeterPerPixel;
    }


    public Color getGaugeColor() {
        return gaugeColor;
    }

    public void setGaugeColor(Color gaugeColor) {
        this.gaugeColor = gaugeColor;
    }

    public Dimension2D getViewPortSize() {
        return viewPortSize;
    }

    public void setViewPortSize(Dimension2D viewPortSize) {
        this.viewPortSize = viewPortSize;
        prepareBuffer();
    }

    @Deprecated
    public RecognitionFrame getNegativeChannel() {
        return negativeChannel;
    }

    @Deprecated
    public void setNegativeChannel(RecognitionFrame negativeChannel) {
        this.negativeChannel = negativeChannel;
    }


    public ExclusionMapGen getExMapGen() {
        return exMapGen;
    }

    public void setExMapGen(ExclusionMapGen exMapGen) {
        this.exMapGen = exMapGen;
    }

    /**
     * sets windowSize and contextClassification based on the featureDescription
     *
     * @param featureDescription
     */
    public void setFeatureDescription(FeatureDescription featureDescription) {
        this.setWindowSize(featureDescription.getWindowSize());
        this.setContextClassificationEnabled(featureDescription.isContextClassificationEnabled());
        this.featureDescription = featureDescription;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }


    public boolean isDisplayAnnotationLabels() {
        return displayAnnotationLabels;
    }

    public void setDisplayAnnotationLabels(boolean displayAnnotationLabels) {
        this.displayAnnotationLabels = displayAnnotationLabels;
    }

    public double getMipScale() {
        return mipScale;
    }


    public List<Shape> getSecondaryObjectSegmentationList() {
        return secondaryObjectSegmentationList;
    }

    public void setSecondaryObjectSegmentationList(List<Shape> secondaryObjectSegmentationList) {
        this.secondaryObjectSegmentationList = secondaryObjectSegmentationList;
    }

    public static AtomicInteger getActiveAnnotationGroup() {
        return activeAnnotationGroup;
    }

    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(ClassificationTaskTiled.CLASSIFICATION_PROGRESS)) {
            threadProgress.put(evt.getSource(), (Double) evt.getNewValue());
            double progress = 0d;
            for (Object obj : threadProgress.keySet()) {
                progress += threadProgress.get(obj);
            }
            if ((taskList != null) && (taskList.size() > 0))
                progress /= taskList.size();

            long elapsed = (System.currentTimeMillis() - startTime) / 1000L;
            double et = (elapsed / (progress / 100d)) * (1d - (progress / 100d));
            logger.debug("Classification progress: " + String.format("%1$.2f", progress) + "%  est. time: " + OrbitUtils.formatTime(et));
        } else {
            if (evt.getPropertyName().equals(RenderThread.RENDERBUFFER_READY)) {
                repaint();
            }
        }

    }


}
