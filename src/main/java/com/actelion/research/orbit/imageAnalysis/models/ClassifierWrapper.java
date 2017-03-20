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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import weka.classifiers.AbstractClassifier;
import weka.classifiers.Classifier;
import weka.clusterers.AbstractClusterer;
import weka.clusterers.Clusterer;
import weka.clusterers.DensityBasedClusterer;
import weka.core.Instance;
import weka.core.Instances;

import java.io.Serializable;

public class ClassifierWrapper implements Serializable {

    private static final long serialVersionUID = 2L;
    private static Logger logger = LoggerFactory.getLogger(ClassifierWrapper.class);
    public final static int WRAPPERTYPE_CLASSIFIER = 0;
    public final static int WRAPPERTYPE_CLUSTERER = 1;
    public int wrapperType = WRAPPERTYPE_CLASSIFIER;
    private Classifier classifier = null;
    private Clusterer clusterer = null;
    private int[] clusterOrder = null;
    private int binaryClassification = -1; // if > 0, the classification will return 1 if class=binaryClassification, else 0
    private boolean isBuild = false;

    public ClassifierWrapper(Classifier classifier) {
        this.classifier = classifier;
        this.wrapperType = WRAPPERTYPE_CLASSIFIER;
    }

    public ClassifierWrapper(Clusterer clusterer) {
        this.clusterer = clusterer;
        this.wrapperType = WRAPPERTYPE_CLUSTERER;
    }

    /**
     * This method is not thread-safe! Use makeCopy to get an instance for each thread.
     * In case of clustering, the class-labels will be ordered with respect to the priors (e.g. background (high prior) will be class 0).
     *
     * @param instance
     * @return
     * @throws Exception
     */
    public double classifyInstance(Instance instance) throws Exception {
        double c = 0d;
        if (wrapperType == WRAPPERTYPE_CLASSIFIER) {
            c = classifier.classifyInstance(instance);
        } else {
            c = clusterer.clusterInstance(instance);
            //double p = clusterer.distributionForInstance(instance)[(int)c];
            if (clusterer instanceof DensityBasedClusterer) {
                c = getClusterOrder()[(getClusterOrder().length - 1) - (int) c];
            }
            //if (p<0.95d) c = 0;
        }
        if (binaryClassification >= 0) {
            if ((int) c == binaryClassification) c = 1;
            else c = 0;
        }
        return c;
    }

    private int[] getClusterOrder() {
        if (clusterOrder == null && (clusterer instanceof DensityBasedClusterer))
            try {
                clusterOrder = weka.core.Utils.sort(((DensityBasedClusterer) clusterer).clusterPriors());
            } catch (Exception e) {
                logger.error("error getting clusterPriors", e);
                e.printStackTrace();
            }
        return clusterOrder;
    }

    /**
     * specify a trainSet for classification and for clustering. For classification also set the class
     * variable, for clustering it can be NaN.
     *
     * @param trainSet
     * @throws Exception
     */
    public void buildClassifier(Instances trainSet) throws Exception {
        if (wrapperType == WRAPPERTYPE_CLASSIFIER) {
            classifier.buildClassifier(trainSet);
        } else
            clusterer.buildClusterer(trainSet);
    }


    public int getWrapperType() {
        return wrapperType;
    }

    public Classifier getClassifier() {
        return classifier;
    }

    public Clusterer getClusterer() {
        return clusterer;
    }

    public void setWrapperType(int wrapperType) {
        this.wrapperType = wrapperType;
    }

    public void setClassifier(Classifier classifier) {
        this.classifier = classifier;
        this.wrapperType = WRAPPERTYPE_CLASSIFIER;
    }

    public void setClusterer(Clusterer clusterer) {
        this.clusterer = clusterer;
        this.wrapperType = WRAPPERTYPE_CLUSTERER;
    }


    public boolean isBuild() {
        return isBuild;
    }

    public void setBuild(boolean isBuild) {
        this.isBuild = isBuild;
    }

    public String toString() {
        if (wrapperType == WRAPPERTYPE_CLASSIFIER) {
            if (classifier == null) return null;
            else return classifier.toString();
        } else {
            if (clusterer == null) return null;
            else return clusterer.toString();
        }
    }

    public static ClassifierWrapper makeCopy(ClassifierWrapper classifierWrapper) throws Exception {
        if (classifierWrapper == null) return null;
        if (classifierWrapper.getWrapperType() == WRAPPERTYPE_CLASSIFIER) {
            //return new ClassifierWrapper(Classifier.makeCopy(classifierWrapper.getClassifier()));
            ClassifierWrapper cw = new ClassifierWrapper((AbstractClassifier.makeCopy(classifierWrapper.getClassifier()))); // weka 3.7.1
            cw.setBinaryClassification(classifierWrapper.getBinaryClassification());
            cw.setBuild(classifierWrapper.isBuild);
            return cw;
        } else {
            ClassifierWrapper cw = new ClassifierWrapper(AbstractClusterer.makeCopy(classifierWrapper.getClusterer()));
            cw.setBinaryClassification(classifierWrapper.getBinaryClassification());
            cw.setBuild(classifierWrapper.isBuild);
            return cw;
        }
    }

    public int getBinaryClassification() {
        return binaryClassification;
    }

    /**
     * if > 0, the classification will return 1 if class=binaryClassification, else 0
     *
     * @param binaryClassification
     */
    public void setBinaryClassification(int binaryClassification) {
        this.binaryClassification = binaryClassification;
    }


}
