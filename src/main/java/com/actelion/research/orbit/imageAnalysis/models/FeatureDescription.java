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

package com.actelion.research.orbit.imageAnalysis.models;

import imageJ.Colour_Deconvolution;

import java.io.Serializable;
import java.util.Arrays;

public class FeatureDescription implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    public static final int FEATURE_SET_PIX_MEAN_MIN_MAX_SD = 0;
    public static final int FEATURE_SET_PIX_MEAN_MIN_MAX_SD_EDGE = 1;
    public static final int FEATURE_SET_INTENS = 2;
    public static final int FEATURE_SET_DEFAULT = FEATURE_SET_PIX_MEAN_MIN_MAX_SD_EDGE;
    private int featureVersion = 2; // if not set (=0) TissueFeaturesOld will be used for backward compatibility
    private int windowSize = 4;
    private int sampleSize = 3; // number of color channels. Default is 3 for RGB, but can be 1 for grey-color.
    private boolean contextClassificationEnabled = false;
    private int minSegmentationSize = 10;
    private int maxSegmentationLength = 500; // pixel of one segmentation path
    private int maxOpenDistance = 3; // max pixel distance from first to last point in segmentation polygon
    private int numBlur = 0;
    private boolean minAreaClassification = false;
    private int featureSet = FEATURE_SET_PIX_MEAN_MIN_MAX_SD; // backward compatibility
    private boolean skipRed = false;
    private boolean skipGreen = false;
    private boolean skipBlue = false;
    private boolean deactivateWatershed = false;     // used for 'large object detection' (a combination of watershed disabled, crossTileJoin enabled, dilate and erode)
    private boolean filterTileEdgeShapes = false;
    private double segmentationScale = 1d;
    private int[] featureClasses = null;
    private int deconvChannel = 0;
    private String deconvName = Colour_Deconvolution.DECONV_NONE;

    // version >=2
    private boolean disableWatershed = false;   // just disable watershed - deactivateWatershed is obsolete, but used for 'large object detection'
    private boolean combineObjectsCrossTiles = false;
    private boolean dilateBeforeErode = true;
    private int numDilate = 1; // for better segmentation
    private int numErode = 0;
    private int removeOutliers = 0;
    private double graphCut = 0d;
    private boolean useImageAdjustments = false; // imageAdjustments like gamma, contrast, brightness loaded from DB (meta data)

    private boolean forSecondarySegmentationModel = false;
    private boolean cytoplasmaSegmentation = false;
    private String[] activeFluoChannels;


    public FeatureDescription() {
        featureSet = FEATURE_SET_DEFAULT; // latest version
    }

    public FeatureDescription(int windowSize) {
        this();
        this.windowSize = windowSize;
    }

    public FeatureDescription(int windowSize, int sampleSize, int featureSet, int minSegmentationSize, boolean minAreaClassification, int numBlur, boolean skipRed, boolean skipGreen, boolean skipBlue, double segmentationScale, int[] featureClasses, boolean deactivateWatershed, boolean filterTileEdgeShapes, int deconvChannel, String deconvName, boolean useImageAdjustments, String[] activeFluoChannels) {
        this.windowSize = windowSize;
        this.sampleSize = sampleSize;
        this.featureSet = featureSet;
        this.minSegmentationSize = minSegmentationSize;
        this.minAreaClassification = minAreaClassification;
        this.numBlur = numBlur;
        this.skipRed = skipRed;
        this.skipGreen = skipGreen;
        this.skipBlue = skipBlue;
        this.segmentationScale = segmentationScale;
        this.featureClasses = featureClasses;
        this.deactivateWatershed = deactivateWatershed;
        this.filterTileEdgeShapes = filterTileEdgeShapes;
        this.deconvChannel = deconvChannel;
        this.deconvName = deconvName;
        this.useImageAdjustments = useImageAdjustments;
        this.activeFluoChannels = activeFluoChannels;
    }


    public int getWindowSize() {
        return windowSize;
    }

    public void setWindowSize(int windowSize) {
        this.windowSize = windowSize;
    }

    public boolean isContextClassificationEnabled() {
        return contextClassificationEnabled;
    }

    public void setContextClassificationEnabled(boolean contextClassificationEnabled) {
        this.contextClassificationEnabled = contextClassificationEnabled;
    }

    public int getMinSegmentationSize() {
        return minSegmentationSize;
    }

    public void setMinSegmentationSize(int minSegmentationSize) {
        this.minSegmentationSize = minSegmentationSize;
    }


    public int getFeatureSet() {
        return featureSet;
    }

    public void setFeatureSet(int featureSet) {
        this.featureSet = featureSet;
    }

    /**
     * Number of color channels. Set to 3 for RGB and 1 for grey-color.
     *
     * @return
     */
    public int getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize(int sampleSize) {
        this.sampleSize = sampleSize;
    }


    public boolean isMinAreaClassification() {
        return minAreaClassification;
    }

    public void setMinAreaClassification(boolean minAreaClassification) {
        this.minAreaClassification = minAreaClassification;
    }


    public int getNumBlur() {
        return numBlur;
    }

    public void setNumBlur(int numBlur) {
        this.numBlur = numBlur;
    }


    public boolean isSkipRed() {
        return skipRed;
    }

    public void setSkipRed(boolean skipRed) {
        this.skipRed = skipRed;
    }

    public boolean isSkipGreen() {
        return skipGreen;
    }

    public void setSkipGreen(boolean skipGreen) {
        this.skipGreen = skipGreen;
    }

    public boolean isSkipBlue() {
        return skipBlue;
    }

    public void setSkipBlue(boolean skipBlue) {
        this.skipBlue = skipBlue;
    }


    public double getSegmentationScale() {
        if (segmentationScale == 0d)
            segmentationScale = 1d; // because de-serialization sets it to 0 if it was not existing before
        return segmentationScale;
    }

    public void setSegmentationScale(double segmentationScale) {
        this.segmentationScale = segmentationScale;
    }


    public int[] getFeatureClasses() {
        return featureClasses;
    }

    public void setFeatureClasses(int[] featureClasses) {
        this.featureClasses = featureClasses;
    }

    public int getMaxSegmentationLength() {
        return maxSegmentationLength == 0 ? 200 : maxSegmentationLength;
    }

    public void setMaxSegmentationLength(int maxSegmentationLength) {
        this.maxSegmentationLength = maxSegmentationLength;
    }

    public int getMaxOpenDistance() {
        return maxOpenDistance == 0 ? 3 : maxOpenDistance;
    }

    public void setMaxOpenDistance(int maxOpenDistance) {
        this.maxOpenDistance = maxOpenDistance;
    }

    public int getFeatureVersion() {
        return featureVersion;
    }

    public void setFeatureVersion(int featureVersion) {
        this.featureVersion = featureVersion;
    }

    public boolean isDeactivateWatershed() {
        return deactivateWatershed;
    }

    public void setDeactivateWatershed(boolean deactivateWatershed) {
        this.deactivateWatershed = deactivateWatershed;
    }

    public int getDeconvChannel() {
        return deconvChannel;
    }

    public void setDeconvChannel(int deconvChannel) {
        this.deconvChannel = deconvChannel;
    }

    public String getDeconvName() {
        return deconvName;
    }

    public void setDeconvName(String deconvName) {
        this.deconvName = deconvName;
    }

    public boolean isDisableWatershed() {
        return disableWatershed;
    }

    public void setDisableWatershed(boolean disableWatershed) {
        this.disableWatershed = disableWatershed;
    }

    public boolean isCombineObjectsCrossTiles() {
        return combineObjectsCrossTiles;
    }

    public void setCombineObjectsCrossTiles(boolean combineObjectsCrossTiles) {
        this.combineObjectsCrossTiles = combineObjectsCrossTiles;
    }

    public boolean isDilateBeforeErode() {
        return dilateBeforeErode;
    }

    public void setDilateBeforeErode(boolean dilateBeforeErode) {
        this.dilateBeforeErode = dilateBeforeErode;
    }

    public int getNumDilate() {
        return numDilate;
    }

    public void setNumDilate(int numDilate) {
        this.numDilate = numDilate;
    }

    public int getNumErode() {
        return numErode;
    }

    public void setNumErode(int numErode) {
        this.numErode = numErode;
    }

    public int getRemoveOutliers() {
        return removeOutliers;
    }

    public void setRemoveOutliers(int removeOutliers) {
        this.removeOutliers = removeOutliers;
    }

    public double getGraphCut() {
        return graphCut;
    }

    public void setGraphCut(double graphCut) {
        this.graphCut = graphCut;
    }

    public boolean isUseImageAdjustments() {
        return useImageAdjustments;
    }

    public void setUseImageAdjustments(boolean useImageAdjustments) {
        this.useImageAdjustments = useImageAdjustments;
    }

    public boolean isForSecondarySegmentationModel() {
        return forSecondarySegmentationModel;
    }

    public void setForSecondarySegmentationModel(boolean forSecondarySegmentationModel) {
        this.forSecondarySegmentationModel = forSecondarySegmentationModel;
    }

    public boolean isCytoplasmaSegmentation() {
        return cytoplasmaSegmentation;
    }

    public void setCytoplasmaSegmentation(boolean cytoplasmaSegmentation) {
        this.cytoplasmaSegmentation = cytoplasmaSegmentation;
    }

    public String[] getActiveFluoChannels() {
        return activeFluoChannels;
    }

    public void setActiveFluoChannels(String[] activeFluoChannels) {
        this.activeFluoChannels = activeFluoChannels;
    }

    public boolean isFilterTileEdgeShapes() {
        return filterTileEdgeShapes;
    }

    public void setFilterTileEdgeShapes(boolean filterTileEdgeShapes) {
        this.filterTileEdgeShapes = filterTileEdgeShapes;
    }

    public FeatureDescription clone() {
        try {
            return ((FeatureDescription) super.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "FeatureDescription{" +
                "featureVersion=" + featureVersion +
                ", windowSize=" + windowSize +
                ", sampleSize=" + sampleSize +
                ", contextClassificationEnabled=" + contextClassificationEnabled +
                ", minSegmentationSize=" + minSegmentationSize +
                ", maxSegmentationLength=" + maxSegmentationLength +
                ", maxOpenDistance=" + maxOpenDistance +
                ", numBlur=" + numBlur +
                ", minAreaClassification=" + minAreaClassification +
                ", featureSet=" + featureSet +
                ", skipRed=" + skipRed +
                ", skipGreen=" + skipGreen +
                ", skipBlue=" + skipBlue +
                ", deactivateWatershed=" + deactivateWatershed +
                ", filterTileEdgeShapes=" + filterTileEdgeShapes +
                ", segmentationScale=" + segmentationScale +
                ", featureClasses=" + Arrays.toString(featureClasses) +
                ", deconvChannel=" + deconvChannel +
                ", deconvName='" + deconvName + '\'' +
                ", disableWatershed=" + disableWatershed +
                ", combineObjectsCrossTiles=" + combineObjectsCrossTiles +
                ", dilateBeforeErode=" + dilateBeforeErode +
                ", numDilate=" + numDilate +
                ", numErode=" + numErode +
                ", removeOutliers=" + removeOutliers +
                ", graphCut=" + graphCut +
                ", useImageAdjustments=" + useImageAdjustments +
                ", cytoplasmaSegmentation=" + cytoplasmaSegmentation +
                ", activeFluoChannels=" +Arrays.toString(activeFluoChannels) +
                '}';
    }
}
