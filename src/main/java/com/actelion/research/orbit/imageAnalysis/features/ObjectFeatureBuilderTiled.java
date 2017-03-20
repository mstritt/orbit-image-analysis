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

package com.actelion.research.orbit.imageAnalysis.features;

import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.utils.PolygonMetrics;
import com.actelion.research.orbit.imageAnalysis.utils.TiledImageWriter;
import ij.gui.PolygonRoi;
import ij.gui.Roi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.Raster;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ObjectFeatureBuilderTiled {

    private static Logger logger = LoggerFactory.getLogger(ObjectFeatureBuilderTiled.class);
    private static double EPSILON = 0.00000001d;
    private static final String decimalSeparator = DecimalFormatSymbols.getInstance().getDecimalSeparator() + "";

    private int modelVersion = 0;
    private static final int newShapeFeaturesModelVersion = 10;
    public static final String[] IntensityNames = new String[]{"Mean", "Max", "Min", "SD"};
    private static final String PixelCountName = "PixelCount";
    private static final String[] ShapeNamesNew = new String[]{"Roundness", "Circularity", "Solidity", "Convexity", "Compactness", "Area", "Perimeter", "AspectRatio", "CenterX", "CenterY"};
    private static final String[] ShapeNamesNewSecondary = new String[]{"Roundness", "Circularity", "Solidity", "Convexity", "Compactness", "Area", "Perimeter", "AspectRatio", "SecondaryCount", "CenterX", "CenterY"};
    private static final String[] ShapeNamesNewSecondaryFeats = new String[]{"Roundness", "Circularity", "Solidity", "Convexity", "Compactness", "Area", "Perimeter", "AspectRatio", "SecondaryCount", "SecondaryAreaMean", "SecondaryAreaSD", "CenterX", "CenterY"};
    private static final String[] ShapeNamesOld = new String[]{"Roundness", "Circularity", "Perimeter", "Area", "BBSize", "Ratio", "CenterX", "CenterY"};
    public static final String[] SampleNames = new String[]{"Red", "Green", "Blue"};
    public static final int SkipTailForClassification = 2;
    public static final int FeatureAreaNumReverse = 4 + SkipTailForClassification;
    //private HashSet<Integer> classes = new HashSet<Integer>(Arrays.asList(new Integer[]{1,2}));
    private HashSet<Integer> classes = null;
    private boolean modelHasSecondary = false;
    private boolean modelHasSecondaryFeatures = false;


    public ObjectFeatureBuilderTiled(OrbitModel model) {
        this.modelVersion = model != null ? model.getVersion() : new OrbitModel().getVersion();
        this.modelHasSecondary = (model != null && model.getSecondarySegmentationModel() != null);
        if (this.modelHasSecondary) {
            if (model.getSecondarySegmentationModel().getFeatureDescription().getFeatureClasses() != null && model.getSecondarySegmentationModel().getFeatureDescription().getFeatureClasses().length > 0)
                this.modelHasSecondaryFeatures = true;
        }
    }


    private String[] getShapeNames() {
        if (modelVersion >= newShapeFeaturesModelVersion) {
            if (modelHasSecondary) {
                if (modelHasSecondaryFeatures) return ShapeNamesNewSecondaryFeats;
                else return ShapeNamesNewSecondary;
            } else return ShapeNamesNew;
        } else return ShapeNamesOld;
    }

    public String[] getFeatureNames(int samples) {
        List<String> names = new ArrayList<String>(IntensityNames.length * samples + getShapeNames().length);
        for (int i = 0; i < samples; i++) {
            for (String in : IntensityNames)
                names.add(in + "[" + SampleNames[i] + "]");
        }
        names.add(PixelCountName);
        for (String sn : getShapeNames()) {
            names.add(sn);
        }
        return names.toArray(new String[0]);
    }

    public double[] makeDefaultFeatures(int samples) {
        double[] feats = new double[getFeatureNames(samples).length];
        for (int i = 0; i < feats.length; i++) {
            feats[i] = Double.NaN;
        }
        return feats;
    }

    public String getResultString(List<double[]> features, int samples, boolean includingClass, String delimiter) {
        String[] featureNames = getFeatureNames(samples);
        return getResultString(featureNames, features, includingClass, delimiter);
    }

    public String getResultString(String[] featureNames, List<double[]> features, boolean includingClass, String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < featureNames.length; i++) {
            sb.append(featureNames[i]);
            if (i < featureNames.length - 1) sb.append(delimiter);
        }
        if (includingClass) sb.append(delimiter + "class");
        sb.append("\n");
        for (int i = 0; i < features.size(); i++) {
            for (int j = 0; j < features.get(i).length - 1; j++) {
                String val = Double.isNaN(features.get(i)[j]) ? "" : (features.get(i)[j] + "");
                sb.append(val.replaceAll("\\.", decimalSeparator));
                if (j < features.get(i).length - 2) sb.append(delimiter);
            }
            if (includingClass) {
                sb.append(delimiter + features.get(i)[features.get(i).length - 1]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getResultString(double[] features, boolean includingClass, String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < features.length - 1; j++) {
            String val = Double.isNaN(features[j]) ? "" : (features[j] + "");
            sb.append(val.replaceAll("\\.", decimalSeparator));
            if (j < features.length - 2) sb.append(delimiter);
        }
        if (includingClass) {
            sb.append(delimiter + features[features.length - 1]);
        }
        return sb.toString();
    }

    public List<double[]> buildFeatures(List<Shape> shapes, double classNum, RecognitionFrame rf, TiledImageWriter classImage, int samples, int xOffs, int yOffs) {
        List<double[]> resFeats = new ArrayList<double[]>(shapes.size());
        for (Shape shape : shapes) {
            if (shape.getBounds().width == 0 || shape.getBounds().height == 0) {
                if (logger.isTraceEnabled())
                    logger.trace("skipping shape: " + shape.getBounds());
                continue;
            }
            double[] feats = buildFeatures(shape, classNum, rf, classImage, samples, xOffs, yOffs);
            resFeats.add(feats);
        }
        return resFeats;
    }

    /**
     * shape.width and shape.height have to be > 0!
     *
     * @param shape
     * @param classNum
     * @return
     */
    public double[] buildFeatures(Shape shape, double classNum, RecognitionFrame rf, TiledImageWriter classImage, int samples, int xOffs, int yOffs) {
        List<Double> feats = new ArrayList<Double>();

        // mean intensities and sd (of red, green, blue)
        feats.addAll(getFeatureMeanMaxMinIntensitiesAndSD(shape, rf, classImage, samples, xOffs, yOffs));
        // bb size
        feats.addAll(getFeatureShapeDescriptors(shape));
        // add class
        feats.add(classNum);  // has to be the last feature
        double[] dArr = new double[feats.size()];
        for (int i = 0; i < feats.size(); i++) dArr[i] = feats.get(i);
        return dArr;
    }

    private boolean isInObject(RecognitionFrame rf, TiledImageWriter classImage, int x, int y, int xOffs, int yOffs) {
        if (classes == null) return true;
        if (!classImage.getImage().getBounds().contains(x - xOffs, y - yOffs)) {
            //System.out.println("no bounds:"+classImage.getImage().getBounds()+" pos:"+(x-xOffs)+","+(y-yOffs));
            return false;
        } //else System.out.println("yes");
        int clazz = rf.getClass(x - xOffs, y - yOffs, classImage);
        return classes.contains(clazz);
    }


    /**
     * shape.width and shape.height have to be > 0!
     * returns per sample mean,max,min,sd
     *
     * @param shape
     * @return
     */
    private List<Double> getFeatureMeanMaxMinIntensitiesAndSD(Shape shape, RecognitionFrame rf, TiledImageWriter classImage, int samples, int xOffs, int yOffs) {
        List<Double> feats = new ArrayList<Double>(3);
        double[] mean = new double[samples];
        double[] min = new double[samples];
        double[] max = new double[samples];
        double[] sd = new double[samples];
        for (int i = 0; i < samples; i++) {
            mean[i] = Double.NaN;
            min[i] = Double.NaN;
            max[i] = Double.NaN;
            sd[i] = 0d;
        }
        int cnt = 0;
        int[] p = new int[4]; // max 4 samples (r,g,b,alpha)
        Rectangle bb = shape.getBounds();

        Point[] tiles = rf.bimg.getImage().getTileIndices(bb);
        if (tiles == null) logger.warn("no tiles for boundingbox available (tiles are null)");

        if (tiles != null && tiles.length > 0)
            for (Point tile : tiles) {
                if (!shape.intersects(rf.bimg.getImage().getTileRect(tile.x, tile.y))) continue;
                Raster raster = rf.bimg.getImage().getTile(tile.x, tile.y);
                // mean, sd, min, max
                for (int x = raster.getMinX(); x < raster.getMinX() + raster.getWidth(); x++)
                    for (int y = raster.getMinY(); y < raster.getMinY() + raster.getHeight(); y++) {
                        if (shape.contains(x, y) && isInObject(rf, classImage, x, y, xOffs, yOffs)) {
                            p = raster.getPixel(x, y, p);
                            for (int i = 0; i < samples; i++) {
                                if (Double.isNaN(mean[i])) mean[i] = 0d;
                                mean[i] += p[i]; // sum
                                //sd[i] += p[i]*p[i]; // sum square
                                if (Double.isNaN(max[i]) || (p[i] > max[i])) max[i] = p[i];
                                if (Double.isNaN(min[i]) || (p[i] < min[i])) min[i] = p[i];
                            }
                            cnt++;
                        }
                    }
            } // tiles


        if (cnt > 0) {
            for (int i = 0; i < samples; i++) {
                mean[i] /= (double) cnt;
                //sd[i] = Math.sqrt(sd[i]/(cnt) - (mean[i] * mean[i]));
            }
        }

        cnt = 0;
        for (Point tile : tiles) {
            if (!shape.intersects(rf.bimg.getImage().getTileRect(tile.x, tile.y))) continue;
            Raster raster = rf.bimg.getImage().getTile(tile.x, tile.y);
            // mean, sd, min, max
            for (int x = raster.getMinX(); x < raster.getMinX() + raster.getWidth(); x++)
                for (int y = raster.getMinY(); y < raster.getMinY() + raster.getHeight(); y++) {
                    if (shape.contains(x, y) && isInObject(rf, classImage, x, y, xOffs, yOffs)) {
                        p = raster.getPixel(x, y, p);
                        for (int i = 0; i < samples; i++) {
                            sd[i] += (p[i] - mean[i]) * (p[i] - mean[i]);
                        }
                        cnt++;
                    }
                }
        } // tiles

        if (cnt > 1) {
            for (int i = 0; i < samples; i++)
                if (sd[i] > EPSILON) {
                    sd[i] = Math.sqrt(Math.max(sd[i] / (double) (cnt - 1), EPSILON));
                } else sd[i] = 0d;
        } else {
            for (int i = 0; i < samples; i++)
                sd[i] = 0d;
        }


        for (int i = 0; i < samples; i++) {
            feats.add(mean[i]);
            feats.add(max[i]);
            feats.add(min[i]);
            feats.add(sd[i]);
        }
        feats.add((double) cnt); // PixelCount
        return feats;
    }


    /**
     * returns ShapeNames features
     */
    public List<Double> getFeatureShapeDescriptors(Shape shape) {
        return modelVersion >= newShapeFeaturesModelVersion ? getFeatureShapeDescriptorsNew(shape) : getFeatureShapeDescriptorsOld(shape);
    }


    /**
     * returns ShapeNames features (>= model version 10)
     *
     * @param shape
     * @return
     */
    private List<Double> getFeatureShapeDescriptorsNew(Shape shape) {
        List<Double> feats = new ArrayList<Double>(getShapeNames().length);
        double ratio = Double.NaN;
        double perimeter = Double.NaN;
        double area = Double.NaN;
        double circularity = Double.NaN;
        double solidity = Double.NaN;
        double convexity = Double.NaN;
        double compactness = Double.NaN;
        double roundness = Double.NaN;
        double centerX = Double.NaN;
        double centerY = Double.NaN;
        double centroidX = Double.NaN;
        double centroidY = Double.NaN;
        if (shape instanceof Polygon) {
            Polygon p = (Polygon) shape;
            PolygonMetrics pm = new PolygonMetrics(p);
            PolygonRoi pr = new PolygonRoi(p, Roi.POLYGON);
            Polygon convexHull = pr.getConvexHull();
            double[] ferets = pr.getFeretValues();
            double majorAxis = ferets[0];
            //double minorAxis = ferets[2];

            area = pm.getArea();
            perimeter = pm.getPerimeter();
            roundness = pm.getRoundnessNew(area, majorAxis);
            circularity = pm.getCircularity(area, perimeter);
            solidity = pm.getSolidity(convexHull, area);
            convexity = pm.getConvexity(convexHull, perimeter);
            compactness = pm.getCompactness(area, majorAxis);
            ratio = pm.getAspectRatio(ferets);

            // centerX/Y
            Point2D center = pm.getCenter();
            centerX = Math.abs(center.getX());
            centerY = Math.abs(center.getY());

        }

        feats.add(roundness);
        feats.add(circularity);
        feats.add(solidity);
        feats.add(convexity);
        feats.add(compactness);
        feats.add(area);
        feats.add(perimeter);
        feats.add(ratio);
        feats.add(centerX);
        feats.add(centerY);
        return feats;
    }


    /**
     * returns ShapeNames features (< model version 10)
     *
     * @param shape
     * @return
     */
    public List<Double> getFeatureShapeDescriptorsOld(Shape shape) {
        List<Double> feats = new ArrayList<Double>(getShapeNames().length);
        double sizeBB = shape.getBounds().getWidth() * shape.getBounds().getHeight();
        double ratio = Double.NaN;
        if (sizeBB > EPSILON)
            ratio = Math.max(shape.getBounds().getWidth(), shape.getBounds().getHeight()) /
                    Math.min(shape.getBounds().getWidth(), shape.getBounds().getHeight());
        double perimeter = Double.NaN;
        double area = Double.NaN;
        double circularity = Double.NaN;
        double roundness = Double.NaN;
        double centerX = Double.NaN;
        double centerY = Double.NaN;
        double centroidX = Double.NaN;
        double centroidY = Double.NaN;
        if (shape instanceof Polygon) {
            Polygon p = (Polygon) shape;
            PolygonMetrics pm = new PolygonMetrics(p);


            // perimeter
            perimeter = pm.getPerimeter();

            // area = 1/2 * (SUM [(x(i) * y(i+1)) - (x(i+1) * y(i))]   (polygon has to by CW or CCW)
            area = pm.getArea();

            // circularity
            //if (perimeter>EPSILON) circularity = area / (perimeter*perimeter);
            if (perimeter > EPSILON)
                circularity = (4d * Math.PI * area) / (perimeter * perimeter);

            // roundness
            roundness = pm.getRoundness(true);

            // centerX/Y
            Point2D center = pm.getCenter();
            centerX = Math.abs(center.getX());
            centerY = Math.abs(center.getY());

        }

        feats.add(roundness);
        feats.add(circularity);
        feats.add(perimeter);
        feats.add(area);
        feats.add(sizeBB);
        feats.add(ratio);
        feats.add(centerX);
        feats.add(centerY);

        return feats;
    }

    public HashSet<Integer> getClasses() {
        return classes;
    }

    public void setClasses(HashSet<Integer> classes) {
        this.classes = classes;
    }

    public void setClasses(int[] classes) {
        if (classes == null || classes.length == 0) return;
        List<Integer> intList = new ArrayList<Integer>(classes.length);
        for (int i : classes) {
            intList.add(i);
        }
        setClasses(new HashSet<Integer>(intList));
    }

}
