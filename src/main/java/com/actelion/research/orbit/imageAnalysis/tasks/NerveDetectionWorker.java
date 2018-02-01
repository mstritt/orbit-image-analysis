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

package com.actelion.research.orbit.imageAnalysis.tasks;

import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.imaging.NerveSkeleton;
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.utils.ScaleoutMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.media.jai.PlanarImage;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Nerve detection. Used in NerveDetectionModule.
 */
public class NerveDetectionWorker extends OrbitWorker {

    private final static Logger logger = LoggerFactory.getLogger(NerveDetectionWorker.class);
    private RecognitionFrame rf = null;
    private int segmentCount = 0;
    private boolean orderPoints = false;
    private int roiOffsX = 0;
    private int roiOffsY = 0;
    private Shape roi = null;
    private Shape fullRoi = null;
    private List<Point> tiles = null;
    private OrbitModel model = null; // the model with included segmentation model, in normal mode the model from OrbitImageAnalysis.getInstance() will be taken
    private ExclusionMapGen exclusionMap = null;
    private List<ClassShape> oldClassShapes = null;
    private int numErode = 0;
    private int numDilate = 10;
    private boolean doErode = false;
    private boolean doDilate = false;
    private boolean doWatershed = false;
    private boolean doSkeletonize = true;
    private boolean doRepaint = true;
    private NerveDetectionParams nerveDetectionParams = new NerveDetectionParams();

    /**
     * roi can be null
     * tiles can be null
     *
     * @param rf
     * @param roi
     * @param dependencyList
     * @param classShapeToSet
     * @param orderPoints
     * @param tiles:          a list of tiles on which the segmentation should be performed. If it is null, all tiles will be used.
     */
    public NerveDetectionWorker(RecognitionFrame rf, Shape roi, List<SwingWorker<Void, Void>> dependencyList, List<ClassShape> classShapeToSet, boolean orderPoints, List<Point> tiles) {
        this.rf = rf;
        if (classShapeToSet != null && rf != null) {
            oldClassShapes = rf.getClassShapes(); // remember original classShapes workaround (dirty fix...)
            this.rf.setClassShapes(classShapeToSet);
        } else {
            if (rf != null)
                logger.error("classShapes must not be null. Please set the classShapes to the classShapes of the segmentation model!");
        }
        this.dependencyList = dependencyList;
        this.orderPoints = orderPoints;
        this.roi = roi;
        this.tiles = tiles;
    }

    private PlanarImage makeROIImage(RecognitionFrame rf) {
        PlanarImage img = rf.bimg.getImage();
        if (getRfROISize() <= 5000 * 5000L) {
            if (rf.getROI() != null) {
                roi = rf.getROI().getScaledInstance(100d, new Point(0, 0));
            }
            if (roi != null) {
                BufferedImage bi = rf.bimg.getImage().getAsBufferedImage(roi.getBounds(), rf.bimg.getImage().getColorModel());
                img = PlanarImage.wrapRenderedImage(bi);
                roiOffsX = Math.max(roi.getBounds().x, 0);
                roiOffsY = Math.max(roi.getBounds().y, 0);
            }
        }
        return img;
    }

    /**
     * returns width*height, either of the whole image or the roi (if set)
     *
     * @return
     */
    private long getRfROISize() {
        long size = (long) rf.bimg.getWidth() * rf.bimg.getHeight();
        if (rf.getROI() != null) {
            roi = rf.getROI().getScaledInstance(100d, new Point(0, 0));
        }
        if (roi != null) {
            size = (long) roi.getBounds().getWidth() * (long) roi.getBounds().getHeight();
        }
        return size;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void doWork() throws OrbitImageServletException {

        try {

            // generate exclusion map
            if (exclusionMap != null && (exclusionMap.useForSegmentation())) {
                if (!exclusionMap.isGenerated()) {
                    exclusionMap.generateMap();
                }
            }

            // required for cell segmentation with manual file load!
            if (model == null && (!ScaleoutMode.SCALEOUTMODE.get())) {
                OrbitModel modelLoad = OrbitImageAnalysis.getInstance().getModel();
                setModel(modelLoad); // will overwrite segmentLengthSingle
            }

            rf.initializeClassColors();
            fullRoi = roi;
            if (fullRoi == null && rf.getROI() != null) fullRoi = rf.getROI().getScaledInstance(100d, new Point(0, 0));

            IScaleableShape oldROI = rf.getROI();
            tiles = Arrays.asList(rf.bimg.getImage().getTileIndices(fullRoi == null ? null : fullRoi.getBounds()));
            if (tiles == null || tiles.size() == 0) {
                tiles = new ArrayList<>(1);
                tiles.add(new Point(-1, -1));
            }
            if (logger.isTraceEnabled()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Nerve Detection for tiles: ");
                for (Point t : tiles) {
                    sb.append(t.x + "," + t.y + "; ");
                }
                logger.trace(sb.toString());
            }
            List<Shape> segments = new ArrayList<Shape>();
            int allSegmentCount = 0;
            int currentTileNum = 0;

            for (Point currentTile : tiles) {
                if (isCancelled()) break;
                logger.trace("tile: " + currentTile.x + "," + currentTile.y);
                currentTileNum++;
                if (currentTile.x != -1) { // -1 means dummy tile
                    // override ROI with current tile
                    roi = rf.bimg.getImage().getTileRect(currentTile.x, currentTile.y);
                    RectangleExt re = new RectangleExt(roi.getBounds().x, roi.getBounds().y, roi.getBounds().width, roi.getBounds().height);
                    re.setScale(100d);
                    rf.setROI(re);

                    // exclusionMap check
                    if (exclusionMap != null && (exclusionMap.useForSegmentation() == false)) {
                        //if (!exclusionMap.isGenerated()) exclusionMap.generateMap();
                        Rectangle tr = rf.bimg.getImage().getTileRect(currentTile.x, currentTile.y);
                        long cnt = 0;
                        long hit = 0;
                        for (int x = tr.x; x < tr.getMaxX(); x += 2)
                            for (int y = tr.y; y < tr.getMaxY(); y += 2) {
                                cnt++;
                                if (!exclusionMap.isExcluded(x, y)) {
                                    hit++;
                                }
                            }
                        double pExl = (double) hit / (double) cnt;

                        logger.trace("hits: " + hit);
                        if (pExl < 0.05d) {
                            logger.trace("ns tile excluded " + pExl);
                            continue; // too much excluded, so skip tile
                        } else logger.trace("ns included " + pExl);
                    }
                }


                if (getRfROISize() > 5000 * 5000L) {
                    throw new IllegalArgumentException("Nerve detection can only be applied for smaller regions (max 5000x5000). Please try to select a smaller ROI and apply this method again.");
                }


                PlanarImage roiImage = makeROIImage(rf);

                logger.trace("start nerve skeleton");
                Color foreground = new Color(0, 0, 0);
                Color background = new Color(255, 255, 255);
                NerveSkeleton nerveSkeleton = new NerveSkeleton();
                PlanarImage cImg = nerveSkeleton.process(roiImage, background, foreground, nerveDetectionParams);
                logger.trace("end nerve skeleton");

                rf.clearClassList();
                logger.trace("start segmentation");
                int oldSegmentCount = segments.size();
                List<Shape> detectedSegments = detectSegmentations(nerveDetectionParams.getSegmentLengthSingle(), cImg);
                if (detectedSegments != null)
                    segments.addAll(detectedSegments);
                logger.trace("end segmentation: #objects: " + segments.size());
                segmentCount = segments.size() - oldSegmentCount; // minus the old segmentCount
                allSegmentCount += segmentCount;

                logger.debug("detected " + segmentCount + " segments in tile " + currentTile.x + "," + currentTile.y + " / overall: " + allSegmentCount);

                setProgress((int) (((double) currentTileNum / (double) tiles.size()) * 100d));
                if ((!ScaleoutMode.SCALEOUTMODE.get()) && doRepaint) rf.repaint();
                logger.trace("end nerve segmentation for current tile");


            } // tiles

            // merge segments (connect shapes which are close together), also cross tiles!
            List<Polygon> polyList = mergePaths(segments, nerveDetectionParams.getSegmentDistanceMerge());
            segments.clear();
            for (Polygon p : polyList) {
                if (pathLength(p) >= nerveDetectionParams.getSegmentLengthMerged())
                    segments.add(p);
            }

            segments = filterOnlyCrossing(segments, rf.getAnnotations());

            allSegmentCount = segments.size();

            if (!isCancelled()) {
                rf.setObjectSegmentationList(segments);

                rf.setROI(oldROI);
                if (oldClassShapes != null) {
                    rf.setClassShapes(oldClassShapes);
                    logger.debug("ClassShape Workaround: Old classShapes set.");
                }
                logger.info("counted " + allSegmentCount + " segments");
                setProgress(100);
                taskResult = new TaskResult("Nerve Detection", "Number of segments: " + allSegmentCount + "\n");
            }

        } catch (Throwable e) {
            logger.error("error: ", e);
        }

    }


    public static ImageAnnotation getJunctionAnnotation(List<ImageAnnotation> annotations) {
        ImageAnnotation junctionAnnotation = null;
        for (ImageAnnotation anno : annotations) {
            if (anno.getDescription().equalsIgnoreCase("junction")) junctionAnnotation = anno;
        }
        return junctionAnnotation;
    }

    private List<Shape> filterOnlyCrossing(List<Shape> segments, List<ImageAnnotation> annotations) {
        if (annotations == null || annotations.size() < 1) return segments;
        ImageAnnotation junctionAnnotation = getJunctionAnnotation(annotations);
        if (junctionAnnotation == null) return segments;
        Polygon junction = ((PolygonExt) junctionAnnotation.getShape().getShapeList().get(0)).getScaledInstance(100d, new Point(0, 0));
        logger.debug("junction annotation found");

        logger.trace("#nerves before crossing filter: " + segments.size());
        List<Shape> filtered = new ArrayList<Shape>(segments.size());
        Point[] preAlloc = new Point[2];
        for (Shape shape : segments) {
            Polygon poly = (Polygon) shape;
            if ((!nerveDetectionParams.isOnlyJunctionCrossings()) || isCrossing(poly, junction, nerveDetectionParams.getJunctionCrossingDistance(), preAlloc)) {
                filtered.add(poly);
            }
        }
        logger.trace("#nerves after crossing filter: " + filtered.size());
        return filtered;
    }

    public List<Shape> detectSegmentations(int minSegmentationSize, PlanarImage sourceImage) {
        logger.trace("getSegmentations (minSegmentation=" + minSegmentationSize + ")");
        rf.initializeClassColors();
        //if (rf.getNegativeChannel() != null) rf.getNegativeChannel().initializeClassColors();
        if (sourceImage == null) return new ArrayList<Shape>(0);
        short[][] smap = new short[sourceImage.getWidth()][sourceImage.getHeight()];

        for (int x = 0; x < sourceImage.getWidth(); x++)
            for (int y = 0; y < sourceImage.getHeight(); y++)
                smap[x][y] = Short.MAX_VALUE;

        // init
        Point[] tileArr = sourceImage.getTileIndices(null);
        int c;
        for (Point tileNum : tileArr) {
            if (isCancelled()) break;
            final int b = 2;

            Raster raster = sourceImage.getTile(tileNum.x, tileNum.y);
            for (int x = sourceImage.tileXToX(tileNum.x) + b; x < Math.min(sourceImage.tileXToX(tileNum.x) + sourceImage.getTileWidth() - b, sourceImage.getWidth()); x++) {
                for (int y = sourceImage.tileYToY(tileNum.y) + b; y < Math.min(sourceImage.tileYToY(tileNum.y) + sourceImage.getTileHeight() - b, sourceImage.getHeight()); y++) {
                    if (fullRoi != null && !(fullRoi.contains(x + roi.getBounds().x, y + roi.getBounds().y))) {
                        continue;
                    }

                    c = raster.getSample(x, y, 0) < 200 ? 0 : 1; // dark=foreground, white=background (only red channel is taken into account)
                    if (c == 0) {  // not background, not assigned
                        smap[x][y] = 1; // 1
                    } else {
                        smap[x][y] = 0; // 0
                    }
                } //y
            } // x
        } // tileNum


        if (isCancelled()) return null;
        return findPolygons(smap, minSegmentationSize);
    }

    public List<Shape> findPolygons(short[][] smap, final int minSegmentationSize) {
        // find objects
        List<List<Point>> pListList = new ArrayList<List<Point>>();
        for (int x = 0; x < smap.length; x++) {
            if (isCancelled()) break;
            for (int y = 0; y < smap[0].length; y++) {
                if (isCancelled()) break;
                if ((smap[x][y] > 0) && (smap[x][y] != Short.MAX_VALUE)) {
                    if (adjoinsClass(x, y, smap)) {  // is border
                        List<Point> pList = new ArrayList<Point>();
                        addRightHandPoints(x, y, smap, pList);

                        if (isActive(x - 1, y - 1, smap)) addRightHandPoints(x - 1, y - 1, smap, pList);
                        if (isActive(x, y - 1, smap)) addRightHandPoints(x, y - 1, smap, pList);
                        if (isActive(x + 1, y - 1, smap)) addRightHandPoints(x + 1, y - 1, smap, pList);
                        if (isActive(x - 1, y, smap)) addRightHandPoints(x - 1, y, smap, pList);
                        if (isActive(x + 1, y, smap)) addRightHandPoints(x + 1, y, smap, pList);
                        if (isActive(x - 1, y + 1, smap)) addRightHandPoints(x - 1, y + 1, smap, pList);
                        if (isActive(x, y + 1, smap)) addRightHandPoints(x, y + 1, smap, pList);
                        if (isActive(x + 1, y + 1, smap)) addRightHandPoints(x + 1, y + 1, smap, pList);
                        pListList.add(pList);
                        // the next iteration will be the next object
                    }
                }
            }
        }


        if (isCancelled()) return null;

        // transform to polygons
        List<Shape> shapeList = new ArrayList<Shape>(pListList.size());
        for (List<Point> pList : pListList) {
            if (pList == null || pList.size() == 0) continue;
            Shape s = new PolygonExt();
            ((PolygonExt) s).setClosed(false);
            ((PolygonExt) s).setOnlyPoints(true);
            for (Point p : pList)
                ((Polygon) s).addPoint(p.x + roiOffsX, p.y + roiOffsY); // add points and adjust roi offset
            if (pathLength((Polygon) s) > minSegmentationSize) {
                if ((roi == null) || roi.contains(s.getBounds().getCenterX(), s.getBounds().getCenterY())) {
                    if (!shapeInNegativeChannel(s))
                        shapeList.add(s);
                }
            }
        }

        smap = null;

        return shapeList;
    }

    /**
     * returns just the number of points in the polygon (npoints) because the polygon might not be concave and the points are
     * not ordered.
     */
    public double pathLength(Polygon linePoly) {
        return linePoly.npoints;
        /*
        double dist = 0;
		if (linePoly.npoints>0) dist = 1;
		for (int i=0; i<linePoly.npoints-1; i++) {
			 dist += Math.sqrt(
			 ((double)(linePoly.xpoints[i]-linePoly.xpoints[i+1])* (linePoly.xpoints[i]-linePoly.xpoints[i+1])) +
			 ((double)(linePoly.ypoints[i]-linePoly.ypoints[i+1])* (linePoly.ypoints[i]-linePoly.ypoints[i+1]))
			 );
		}
		return dist;
		*/
    }

    private boolean shapeInNegativeChannel(Shape s) {
        if (exclusionMap == null || (!exclusionMap.useForSegmentation())) return false;
        Rectangle bb = s.getBounds();
        int cnt = 0;
        int hit = 0;
        for (int x = bb.x; x < bb.getMaxX(); x++)
            for (int y = bb.y; y < bb.getMaxY(); y++) {
                if (s.contains(x, y)) {
                    cnt++;
                    if (exclusionMap.isExcluded(x, y))
                        hit++;
                }

            }
        double ratio = 0d;
        if (cnt > 0) ratio = hit / (double) cnt;
        // 0.75
        return ratio > 0.75d;
    }

    /**
     * applies "right-hand" rule and adds adjoined points to pListArr.<br>
     * The buffer buf will be modified!!!
     *
     * @param x
     * @param y
     * @param buf (will be modified!!!)
     */
    private void addRightHandPoints(int x, int y, final short[][] buf, final List<Point> pList) {

        final int width = buf.length;
        final int height = buf[0].length;

        int oldX = 0, oldY = 0;
        while (x != -1) {
            if ((buf[x][y] > 0) && (buf[x][y] != Short.MAX_VALUE)) {
                if (adjoinsClass(x, y, buf)) {
                    //pListArr[color].add(new Point(x, y));
                    pList.add(new Point(x, y));
                    oldX = x;
                    oldY = y;
                }
                //System.out.println("P:"+p+" buf[x][y]:"+buf[x][y]+" buf[x+1][y-1]:"+buf[x+1][y-1]+" buf[x+1][y]:"+buf[x+1][y]+" buf[x+1][y+1]:"+buf[x+1][y+1]+" buf[x][y+1]:"+buf[x][y+1]+" buf[x-1][y+1]:"+buf[x-1][y+1]+" buf[x-1][y]:"+buf[x-1][y]+" buf[x-1][y-1]:"+buf[x-1][y-1]+" buf[x][y-1]:"+buf[x][y-1]+" classImage:"+classImage.getWidth()+"/"+classImage.getHeight());

                if (x == 0 && y == 0 && (buf[x][y] == buf[x + 1][y])) {
                    x = x + 1;
                } // upper left corner
                else if (x > 0 && (x < width - 1) && y == 0 && (buf[x][y] == buf[x + 1][y])) {
                    x = x + 1;
                } // upper border
                else if ((x == width - 1) && y == 0 && (buf[x][y] == buf[x][y + 1])) {
                    y = y + 1;
                } // upper right corner
                else if ((x == width - 1) && y > 0 && (y < height - 1) && (buf[x][y] == buf[x][y + 1])) {
                    y = y + 1;
                } // right border
                else if ((x == width - 1) && (y == height - 1) && (buf[x][y] == buf[x - 1][y])) {
                    x = x - 1;
                } // lower right corner
                else if (x > 0 && (x < width - 1) && (y == height - 1) && (buf[x][y] == buf[x - 1][y])) {
                    x = x - 1;
                } // lower border
                else if (x == 0 && (y == height - 1) && (buf[x][y] == buf[x][y - 1])) {
                    y = y - 1;
                } // lower left corner
                else if (x == 0 && y > 0 && (y < height - 1) && (buf[x][y] == buf[x][y - 1])) {
                    y = y - 1;
                } // left border

                // non-border regions

                else if ((x < width - 1) && (y > 0) && (buf[x + 1][y - 1] == buf[x][y]) && (adjoinsClass(x + 1, y - 1, buf))) {
                    x = x + 1;
                    y = y - 1;
                } // north-east
                else if ((x < width - 1) && (buf[x + 1][y] == buf[x][y]) && (adjoinsClass(x + 1, y, buf))) {
                    x = x + 1;
                } // east
                else if ((x < width - 1) && (y < height - 1) && (buf[x + 1][y + 1] == buf[x][y]) && (adjoinsClass(x + 1, y + 1, buf))) {
                    x = x + 1;
                    y = y + 1;
                } // south-east
                else if ((y < height - 1) && (buf[x][y + 1] == buf[x][y]) && (adjoinsClass(x, y + 1, buf))) {
                    y = y + 1;
                } // south
                else if ((y < height - 1) && (x > 0) && (buf[x - 1][y + 1] == buf[x][y]) && (adjoinsClass(x - 1, y + 1, buf))) {
                    x = x - 1;
                    y = y + 1;
                } // south-west
                else if ((x > 0) && (buf[x - 1][y] == buf[x][y]) && (adjoinsClass(x - 1, y, buf))) {
                    x = x - 1;
                } // west
                else if ((y > 0) && (x > 0) && (buf[x - 1][y - 1] == buf[x][y]) && (adjoinsClass(x - 1, y - 1, buf))) {
                    x = x - 1;
                    y = y - 1;
                } // north-west
                else if ((y > 0) && (buf[x][y - 1] == buf[x][y]) && (adjoinsClass(x, y - 1, buf))) {
                    y = y - 1;
                } // north
                else x = -1;
                buf[oldX][oldY] = Short.MAX_VALUE;

            } // col
        } // x != -1
    }

    public boolean isActive(int x, int y, short[][] smap) {
        return ((x >= 0) && (y >= 0) && (x < smap.length) && (y < smap[0].length) &&
                (smap[x][y] > 0) && (smap[x][y] != Short.MAX_VALUE));
    }

    /**
     * tests if x,y is adjoined given buf. In this version Short.MAX_VALUE is ignored (so it can be a marked color)
     *
     * @param x
     * @param y
     * @param buf
     * @return
     */
    private boolean adjoinsClass(final int x, final int y, final short[][] buf) {
        return isActive(x, y, buf);
        /*
        final int width = buf.length;
		final int height = buf[0].length;
		
		if ((x>0) && (buf[x-1][y] != buf[x][y]) && (buf[x-1][y]!=Short.MAX_VALUE)) return true; //west
		if ((x<width-1) && (buf[x+1][y] != buf[x][y]) && (buf[x+1][y]!=Short.MAX_VALUE)) return true; //east
		if ((y<height-1) && (buf[x][y+1] != buf[x][y]) && (buf[x][y+1]!=Short.MAX_VALUE)) return true; //north
		if ((y>0) && (buf[x][y-1] != buf[x][y]) && (buf[x][y-1]!=Short.MAX_VALUE)) return true; //south
		return false;
		*/
    }


    public boolean containsPoint(List<List<Point>> pListList, Point p) {
        for (List<Point> pList : pListList) {
            Polygon poly = new Polygon();
            for (Point point : pList) {
                poly.addPoint(point.x, point.y);
            }
            if (poly.contains(p)) return true;
        }
        return false;
    }


    /**
     * Returns a list of polygons. Because List<Polygon> is not an instance of List<Shape> we don't use generics here.
     * Could be optimized with bounding box checks...
     *
     * @param polyList
     * @param distance
     * @return
     */
    @SuppressWarnings("rawtypes")
    public List mergePaths(final List polyList, final double distance) {
        logger.debug("#nerves before polygon merge: " + polyList.size());
        List pList = polyList;

        HashSet<Integer> mergedIdx = new HashSet<Integer>();
        List<Polygon> mergedPolys = new ArrayList<Polygon>();
        boolean change = true;
        int round = 0;
        Point[] preAlloc = new Point[2];
        while (change) {
            logger.trace("merging round " + ++round);
            change = false;
            mergedIdx.clear();
            mergedPolys.clear();
            for (int i = 0; i < pList.size(); i++) {
                Polygon p1 = (Polygon) pList.get(i);
                for (int j = i + 1; j < pList.size(); j++) {
                    if (mergedIdx.contains(i)) break;
                    if (i != j && !mergedIdx.contains(j)) {
                        Polygon p2 = (Polygon) pList.get(j);
                        Point[] nearestP = nearestPoints(p1, p2, preAlloc);
                        if (nearestP[0].distance(nearestP[1]) <= distance) {
                            mergedIdx.add(i);
                            mergedIdx.add(j);
                            change = true;
                            //System.out.println("merge "+i+", "+j);
                            mergedPolys.add(mergePolys(p1, p2));
                        }
                    } // !mergeIdx.contains(j)
                } // j
            } // i

            if (true /*change*/) { // even without a change the elements have to be copied - why? (distance=0 bug)
                List<Polygon> newList = new ArrayList<Polygon>(pList.size());
                for (int i = 0; i < pList.size(); i++) {
                    if (!mergedIdx.contains(i)) {
                        newList.add((Polygon) pList.get(i));
                    }
                }
                newList.addAll(mergedPolys);
                pList = newList;
            }
        }
        logger.debug("#nerves after polygon merge: " + pList.size());

        return pList;
    }

    private Polygon mergePolys(Polygon p1, Polygon p2) {
        PolygonExt newP = new PolygonExt(p1);
        if (p1 instanceof PolygonExt) {
            newP.setClosed(((PolygonExt) p1).isClosed());
            newP.setOnlyPoints(((PolygonExt) p1).isOnlyPoints());
        }

        for (int i = 0; i < p2.npoints; i++) {
            newP.addPoint(p2.xpoints[i], p2.ypoints[i]);
        }
        return newP;
    }

    /**
     * Returns the two closest points (it returns two points, from each polygon one).
     * preAlloc can be a pre-allocated Point[2] array. If not null, it will be used.
     */
    private Point[] nearestPoints(Polygon poly1, Polygon poly2, Point[] preAlloc) {
        Point[] res = preAlloc;
        if (res == null) res = new Point[2];
        double minDist = Double.MAX_VALUE;
        double dist = minDist;
        for (int i = 0; i < poly1.npoints; i++) {
            Point p1 = new Point(poly1.xpoints[i], poly1.ypoints[i]);
            for (int j = 0; j < poly2.npoints; j++) {
                Point p2 = new Point(poly2.xpoints[j], poly2.ypoints[j]);
                dist = p1.distance(p2);
                if (dist < minDist) {
                    res[0] = p1;
                    res[1] = p2;
                    minDist = dist;
                }
            }
        }
        return res;
    }

    public boolean isCrossing(Polygon poly, Polygon junction, double minDist, Point[] preAlloc) {
        //Point[] nearest = nearestPoints(poly, junction, preAlloc);
        //return (nearest[0].distance(nearest[1])<=minDist);
        for (int i = 0; i < junction.npoints - 1; i++) {
            for (int j = 0; j < poly.npoints; j++) {
                double dist = Line2D.ptSegDist(junction.xpoints[i], junction.ypoints[i], junction.xpoints[i + 1], junction.ypoints[i + 1], poly.xpoints[j], poly.ypoints[j]);
                if (dist <= minDist) return true;
            }
        }
        return false;
    }

    public RecognitionFrame getRf() {
        return rf;
    }


    public void setRf(RecognitionFrame rf) {
        this.rf = rf;
    }


    /**
     * the model with included segmentation model, in normal mode the model from OrbitImageAnalysis.getInstance() will be taken
     *
     * @return
     */
    public OrbitModel getModel() {
        return model;
    }

    /**
     * The model with included segmentation model, in normal mode the model from OrbitImageAnalysis.getInstance() will be taken.
     * In contrast to the rare object detection module no segmentLengthSingle will be set!
     *
     * @param model
     */
    public void setModel(OrbitModel model) {
        this.model = model;
        if (model.getSegmentationModel() != null) {
            if (rf != null) {
                rf.setClassShapes(model.getSegmentationModel().getClassShapes()); // 19.7.2012
                rf.initializeClassColors();
            }
        }
    }

    public ExclusionMapGen getExclusionMap() {
        return exclusionMap;
    }

    public void setExclusionMap(ExclusionMapGen exclusionMap) {
        this.exclusionMap = exclusionMap;
    }

    public List<Point> getTiles() {
        return tiles;
    }

    public void setTiles(List<Point> tiles) {
        this.tiles = tiles;
    }

    public boolean isDoWatershed() {
        return doWatershed;
    }

    public void setDoWatershed(boolean doWatershed) {
        this.doWatershed = doWatershed;
    }

    public boolean isDoErode() {
        return doErode;
    }

    public void setDoErode(boolean doErode) {
        this.doErode = doErode;
    }

    public boolean isDoDilate() {
        return doDilate;
    }

    public void setDoDilate(boolean doDilate) {
        this.doDilate = doDilate;
    }

    public int getNumErode() {
        return numErode;
    }

    public void setNumErode(int numErode) {
        this.numErode = numErode;
    }

    public int getNumDilate() {
        return numDilate;
    }

    public void setNumDilate(int numDilate) {
        this.numDilate = numDilate;
    }

    public boolean isDoRepaint() {
        return doRepaint;
    }

    public void setDoRepaint(boolean doRepaint) {
        this.doRepaint = doRepaint;
    }

    public boolean isDoSkeletonize() {
        return doSkeletonize;
    }

    public void setDoSkeletonize(boolean doSkeletonize) {
        this.doSkeletonize = doSkeletonize;
    }

    public NerveDetectionParams getNerveDetectionParams() {
        return nerveDetectionParams;
    }

    public void setNerveDetectionParams(NerveDetectionParams nerveDetectionParams) {
        this.nerveDetectionParams = nerveDetectionParams;
    }


}
