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

package com.actelion.research.orbit.imageAnalysis.imaging;

import com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis;
import ij.ImagePlus;
import ij.plugin.filter.Binary;
import ij.plugin.filter.EDM;
import ij.plugin.filter.GaussianBlur;
import imageJ.ThresholderOrbit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.EM;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

import javax.media.jai.PlanarImage;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.*;
import java.util.List;

/**
 * GaussianBlur->MakeBinary->UltimatePoints->MakeBinary/Threshold
 * Can only handle images where width*size<=6000*6000 pixel.
 */
public class TMAPoints {

    protected final Logger logger = LoggerFactory.getLogger(TMAPoints.class);
    protected ThresholderOrbit thresholder = new ThresholderOrbit();
    protected Binary binary = new Binary();
    protected EDM edm = new EDM();
    protected HashMap<Point, Point> spotMap = new HashMap<Point, Point>();
    protected double radius = 0;

    public PlanarImage process(final PlanarImage image) {
        if (image == null || (image.getWidth() * image.getHeight() > 6000 * 6000L))
            throw new IllegalArgumentException("this implementation can only handle images where width*height<=6000*6000. (And image cannot be null)");

        TMAPointsResult res = findCircles(image);
        this.radius = res.getRadius();
        List<Point> pList = res.getSpotList();

        HashMap<Point, Point> pMap = clusterLines(pList);
        pMap = discardDuplicatePoints(pMap);

        BufferedImage buffImg = res.getSpotImage();
        Graphics g = buffImg.createGraphics();
        g.setColor(Color.blue);
        g.setFont(new Font("System", Font.PLAIN, 9));
        for (Point p : pMap.keySet()) {
            Point pos = pMap.get(p);
            g.drawString(pos.x + "/" + pos.y, p.x, p.y);
        }

        spotMap = pMap;

        return PlanarImage.wrapRenderedImage(buffImg);
    }


    private TMAPointsResult findCircles(PlanarImage img) {
        double r = 6d;
        double d;
        Color classCol = OrbitImageAnalysis.getInstance().getModel().getClassShapes().get(1).getColor();
        int red = classCol.getRed();
        int green = classCol.getGreen();
        int blue = classCol.getBlue();
        int[] c = new int[4];
        logger.trace("class color: " + classCol.toString());
        final Raster raster = img.getData();
        short[][] buf = new short[img.getWidth()][img.getHeight()]; // num tissue pixels buffer
        for (int x = 0; x < img.getWidth(); x++)
            for (int y = 0; y < img.getHeight(); y++) {
                // x,y is center. Now count #tissue pixel in radius around center
                for (int bx = x - (int) r; bx <= x + r; bx++) {
                    if (bx < 0 || bx >= img.getWidth()) continue;
                    for (int by = y - (int) r; by <= y + r; by++) {
                        if (by < 0 || by >= img.getHeight()) continue;
                        d = Point.distance(bx, by, x, y);
                        if (d <= r) {
                            c = raster.getPixel(bx, by, c);
                            if (c[0] == red && c[1] == green && c[2] == blue) {
                                buf[x][y]++;
                            }
                        }
                    }
                }
            }


        BufferedImage resImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        WritableRaster raster2 = resImg.getRaster();
        for (int x = 0; x < resImg.getWidth(); x++)
            for (int y = 0; y < resImg.getHeight(); y++) {
                raster2.setPixel(x, y, new int[]{buf[x][y], buf[x][y], buf[x][y]});
                //System.out.println(buf[x][y]);
            }

        // TODO: instead of UEP create TMPSpot lost, order (by score) and take highest scored spots
        // and check for intersection (maybe with min threshold)
        ImagePlus ip = new ImagePlus("TMAPoints", resImg);
        thresholder.applyThreshold(ip);
        edm.setup("points", null); // "points" for Ultimate points
        edm.run(ip.getProcessor());
        PlanarImage img1 = PlanarImage.wrapRenderedImage(ip.getBufferedImage());
        List<Point> pList = reportPoints(img1, 1);
        double radius = guessRadius(pList);
        return new TMAPointsResult(pList, radius, resImg);
    }


    private TMAPointsResult findCirclesUEP(PlanarImage image) {
        ImagePlus ip = new ImagePlus("TMAPoints", image.getAsBufferedImage());

        // blur: this fills small 'holes'
        GaussianBlur blur = new GaussianBlur();
        blur.blur(ip.getProcessor(), 2d);

        // Make Binary
        thresholder.applyThreshold(ip);

        // fill holes
        binary.setup("fill", null);
        binary.run(ip.getProcessor());

        // open
        binary.setup("open", null);
        binary.run(ip.getProcessor());

        // UEP
        edm.setup("points", null); // "points" for Ultimate points
        edm.run(ip.getProcessor());

        PlanarImage img = PlanarImage.wrapRenderedImage(ip.getBufferedImage());
        List<Point> pList = reportPoints(img, 1);
        double radius = guessRadius(pList);
        return new TMAPointsResult(pList, radius, ip.getBufferedImage());
    }


    public double guessRadius(List<Point> pList) {
        int cnt = 0;
        double dist = 0;
        for (Point p : pList) {
            Point c = getClosestPoint(p, pList);
            if (c != null) {
                dist += p.distance(c);
                cnt++;
            }
        }
        dist /= (double) cnt;
        dist /= 2.0d; // diameter->radius
        dist /= 1.5d; // assume space between points. Better: detect background between spots and estimate spot/space ratio with pattern recognition!
        logger.trace("mean distance: " + dist);
        return dist;
    }

    protected Point getClosestPoint(Point point, List<Point> pList) {
        Point c = null;
        double d = Double.MAX_VALUE;
        double t;
        for (Point p : pList) {
            if (!p.equals(point)) {
                t = p.distance(point);
                if (t < d) {
                    c = p;
                    d = t;
                }
            }
        }
        return c;
    }

    /**
     * returns all UEP with a threshold > min in a pointlist.
     * The UEP process has to be applied before!
     *
     * @param img
     * @param min
     * @return
     */
    private List<Point> reportPoints(PlanarImage img, int min) {
        Raster r = img.getData();
        int[] rgb = new int[3];
        double d;
        List<Point> pList = new ArrayList<Point>();
        for (int x = 0; x < img.getWidth(); x++)
            for (int y = 0; y < img.getHeight(); y++) {
                rgb = r.getPixel(x, y, rgb);
                d = (rgb[0]);
                if (d > min) {
                    Point p = new Point(x, y);
                    pList.add(p);
                    if (logger.isTraceEnabled()) {
                        logger.trace(x + "," + y + ": " + d);
                    }
                }
            }
        return pList;
    }


    /**
     * returns x/y pairs for each input point
     *
     * @param pList
     * @return
     */
    private HashMap<Point, Point> clusterLines(List<Point> pList) {
        ArrayList<Attribute> attrListX = new ArrayList<Attribute>(2);
        attrListX.add(new Attribute("xvalue"));
        ArrayList<Attribute> attrListY = new ArrayList<Attribute>(2);
        attrListY.add(new Attribute("yvalue"));
        //attrList.add(new Attribute("class"));
        Instances xInst = new Instances("xlines", attrListX, pList.size());
        Instances yInst = new Instances("ylines", attrListY, pList.size());
        //instances.setClassIndex(1);
        for (Point p : pList) {
            //Instance inst = new DenseInstance(1d, new double[]{p.x,Double.NaN});
            Instance instX = new DenseInstance(1d, new double[]{p.x});
            instX.setDataset(xInst);
            //inst.setClassMissing();
            xInst.add(instX);

            Instance instY = new DenseInstance(1d, new double[]{p.y});
            instY.setDataset(yInst);
            yInst.add(instY);
        }
        try {
            EM colClusterer = new EM();
            int numCols = guessNumClusters(colClusterer, xInst, 1, 20);
            colClusterer.setNumClusters(numCols);
            colClusterer.buildClusterer(xInst);
            logger.debug("NumCols: " + colClusterer.getNumClusters());


            EM rowClusterer = new EM();
            int numRows = guessNumClusters(rowClusterer, yInst, 1, 20);
            rowClusterer.setNumClusters(numRows);
            rowClusterer.buildClusterer(yInst);
            logger.debug("NumRows: " + rowClusterer.getNumClusters());


            logger.trace("ColClusterer:");
            HashMap<Integer, Integer> colHash = sortAndpPrintCluster(colClusterer);

            logger.trace("RowClusterer:");
            HashMap<Integer, Integer> rowHash = sortAndpPrintCluster(rowClusterer);

            if (logger.isTraceEnabled()) {
                logger.trace("ColHash:");
                for (Integer i : colHash.keySet()) {
                    logger.trace("cluster " + i + ": " + colHash.get(i));
                }
                logger.trace("RowHash:");
                for (Integer i : rowHash.keySet()) {
                    logger.trace("cluster " + i + ": " + rowHash.get(i));
                }
            }


            // classify points
            HashMap<Point, Point> pMap = new HashMap<Point, Point>();
            for (Point p : pList) {
                Instance instX = new DenseInstance(1d, new double[]{p.x});
                instX.setDataset(xInst);
                Instance instY = new DenseInstance(1d, new double[]{p.y});
                instY.setDataset(yInst);
                int x = colClusterer.clusterInstance(instX);
                int y = rowClusterer.clusterInstance(instY);
                x = colHash.get(x);
                y = rowHash.get(y);
                logger.trace(p + ": " + x + "/" + y);
                pMap.put(p, new Point(x, y));
            }
            return pMap;

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("error while clustering points", e);
            return null;
        }

    }

    /**
     * Returns a Point->Spotposition mapping based on a Point->Spotposition but without duplicate target Spotpositions.
     * (So that each TMA spot has one and only one position.)
     *
     * @param pMap
     * @return
     */
    private HashMap<Point, Point> discardDuplicatePoints(HashMap<Point, Point> pMap) {
        HashMap<Point, Point> res = new HashMap<Point, Point>(pMap.size());
        HashSet<Point> availablePos = new HashSet<Point>(pMap.size());
        for (Point p : pMap.keySet()) {
            Point pos = pMap.get(p);
            if (!availablePos.contains(pos)) {
                res.put(p, pos);
                availablePos.add(pos);
            } else {
                // adjust old point (position in the middle of old and new point)
                for (Point old : res.keySet().toArray(new Point[0])) {
                    if (res.get(old).equals(pos)) {
                        res.remove(old);
                        old.setLocation((old.x + p.x) / 2, (old.y + p.y) / 2);
                        res.put(old, pos);
                    }
                }
                logger.trace("discarded mapping: " + p + " -> " + pos);
            }
        }
        return res;
    }

    @SuppressWarnings("unchecked")
    private HashMap<Integer, Integer> sortAndpPrintCluster(EM clusterer) {
        List<double[]> vals = new ArrayList<double[]>(clusterer.getNumClusters());
        for (int c = 0; c < clusterer.getNumClusters(); c++) {
            vals.add(new double[]{clusterer.getClusterModelsNumericAtts()[c][0][0],   // mean
                    clusterer.getClusterModelsNumericAtts()[c][0][1],  // var
                    clusterer.getClusterModelsNumericAtts()[c][0][2], // prior
                    clusterer.getClusterPriors()[c], // priors normalized
                    c // cluster number
            });
        }
        Collections.sort(vals, new Comparator() {
            public int compare(Object o1, Object o2) {
                double[] d1 = (double[]) o1;
                double[] d2 = (double[]) o2;
                return (int) Math.signum(d1[0] - d2[0]);
            }
        });
        for (int c = 0; c < vals.size(); c++) {
            logger.trace("Cluster " + c + ":" + vals.get(c)[0] + " Var:" + vals.get(c)[1] + " Z:" + vals.get(c)[2] + " Prior:" + vals.get(c)[3] + " Cluster:" + vals.get(c)[4]);
        }
        return mergeClusters(vals);
    }

    private int guessNumClusters(EM clusterer, Instances instances, int start, int end) throws Exception {
        ClusterEvaluation eval = new ClusterEvaluation();
        int bestNum = start;
        double best = Double.POSITIVE_INFINITY;
        double bic;
        for (int c = start; c <= end; c++) {
            clusterer.setNumClusters(c);
            clusterer.buildClusterer(instances);
            eval.setClusterer(clusterer);
            eval.evaluateClusterer(instances);
            bic = bic(eval.getLogLikelihood(), c, instances.numInstances());
            logger.trace("numCluster " + c + " -> BIC: " + bic);
            if (bic < best) {
                best = bic;
                bestNum = c;
                logger.trace("bestNum: " + bestNum);
            }
        }
        return bestNum;
    }

    private double bic(double llh, int numClust, int sampleSize) {
        final int k = numClust * 2;
        //System.out.println("llh:"+llh+" k:"+k+" llhsamp: "+Math.log(sampleSize)+" 2llh:"+2*llh+" klogn:"+k*Math.log(sampleSize));
        return -2d * llh * sampleSize + k * Math.log(sampleSize);
    }

    /**
     * If two row or column line-clusters have a difference of less than half of the mean difference all clusters have,
     * then these clusters are merged. Merging here means that the mean of the cluster with the higher prior is taken the the other
     * cluster discarded, so in the mapping the discarded cluster is mapped to the other one.
     *
     * @param vals
     * @return
     */
    private HashMap<Integer, Integer> mergeClusters(List<double[]> vals) {
        double[] means = new double[vals.size() - 1];
        double mean = 0;
        for (int i = 0; i < vals.size() - 1; i++) {
            means[i] = vals.get(i + 1)[0] - vals.get(i)[0];
            mean += means[i];
        }
        mean /= ((double) vals.size() - 1);
        logger.trace("mean: " + mean);

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<double[]> res = new ArrayList<double[]>();
        int j = 0;
        for (int i = 0; i < vals.size(); i++) {
            if ((i < vals.size() - 1) && (vals.get(i + 1)[0] - vals.get(i)[0] < mean / 2d)) { // merge clusters
                double[] d = vals.get(i);
                if (vals.get(i + 1)[3] > vals.get(i)[3]) d = vals.get(i + 1); // higher prior, so take this cluster
                res.add(d);
                map.put((int) vals.get(i)[4], j);
                map.put((int) vals.get(i + 1)[4], j);
                i++;
            } else {
                res.add(vals.get(i));
                map.put((int) vals.get(i)[4], j);
            }
            j++;
        }

        logger.trace("merged Clusters: ");
        for (int c = 0; c < res.size(); c++) {
            logger.trace("Cluster " + c + ":" + res.get(c)[0] + " Var:" + res.get(c)[1] + " Z:" + res.get(c)[2] + " Prior:" + res.get(c)[3] + " Cluster:" + res.get(c)[4]);
        }
        return map;
    }


    public HashMap<Point, Point> getSpotMap() {
        return spotMap;
    }

    public void setSpotMap(HashMap<Point, Point> spotMap) {
        this.spotMap = spotMap;
    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    public class TMASpot implements Comparable<TMASpot> {
        private Point spot = null;
        private int score = 0;

        public TMASpot(Point spot, int score) {
            this.spot = spot;
            this.score = score;
        }

        public Point getSpot() {
            return spot;
        }

        public void setSpot(Point spot) {
            this.spot = spot;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int compareTo(TMASpot o) {
            return score - o.getScore();
        }
    }

    public class TMAPointsResult {
        private List<Point> spotList = new ArrayList<Point>();
        private BufferedImage spotImage = null;
        private double radius = 0;

        public TMAPointsResult() {

        }

        public TMAPointsResult(List<Point> spotList, double radius, BufferedImage spotImage) {
            this.spotList = spotList;
            this.spotImage = spotImage;
            this.radius = radius;
        }

        public List<Point> getSpotList() {
            return spotList;
        }

        public void setSpotList(List<Point> spotList) {
            this.spotList = spotList;
        }

        public BufferedImage getSpotImage() {
            return spotImage;
        }

        public void setSpotImage(BufferedImage spotImage) {
            this.spotImage = spotImage;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

    }

}
