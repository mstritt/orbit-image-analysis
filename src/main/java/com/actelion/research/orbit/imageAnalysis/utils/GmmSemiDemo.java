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

package com.actelion.research.orbit.imageAnalysis.utils;

import org.apache.commons.math3.distribution.MixtureMultivariateNormalDistribution;
import org.apache.commons.math3.distribution.MultivariateNormalDistribution;

import java.util.Arrays;
import java.util.Random;

/**
 * Creates two multivariate gaussian clusters with some known labels.
 * Uses GmmSemi to apply semi-supervised learning (clustering with some known labels) to detect the clusters.
 *
 * Manuel, 2018
 *
 */
public class GmmSemiDemo {
    public static void main(String[] args) {

        // generate data (two clusters)

        double[] means1 = new double[]{8,13};      // cluster center 0
        double[][] covar1 =  new double[][] {
                { 1.5, 0.8 },
                { 0.8, 1.5 }
        };

        double[] means2 = new double[]{5,10};     // cluster center 1
        double[][] covar2 =  new double[][] {
                        { 1, 0.6 },
                        { 0.6, 1 }
        };

        MultivariateNormalDistribution mns1 = new MultivariateNormalDistribution(means1,covar1);
        MultivariateNormalDistribution mns2 = new MultivariateNormalDistribution(means2,covar2);

        Random random = new Random();
        int n = 10000;  // #data points
        int g = 2;      // #clusters
        double[][]  data = new double[n][g];
        double[] trueLabels = new double[n];
        double[] labels = new double[n];

        double pLabel = 0.3d;  // probability that label is known
        double p0 = 0.5d;      // probability for datapoint belonging to cluster0
        for (int i=0; i<n; i++) {
           if (random.nextDouble()<p0) {
               // cluster0
               data[i] = mns1.sample();
               trueLabels[i] = 0;
               labels[i] = random.nextDouble()<pLabel? 0 : Double.NaN;
           }  else {
               // cluster1
               data[i] = mns2.sample();
               trueLabels[i] = 1;
               labels[i] = random.nextDouble()<pLabel? 1 : Double.NaN;
           }
        }


        // cluster data "train"

        MixtureMultivariateNormalDistribution mmn = GmmSemi.estimate(data,g);   // initial values via heuristic estimate
        GmmSemi gmmSemi = new GmmSemi(data,labels);
        gmmSemi.fit(mmn,10000,0.00001d);
        mmn = gmmSemi.getFittedModel();

        // eval

        System.out.println("Means C1: "+ Arrays.toString(mmn.getComponents().get(0).getSecond().getMeans()));
        System.out.println("Means C2: "+ Arrays.toString(mmn.getComponents().get(1).getSecond().getMeans()));

        int correct = 0;
        for (int i=0; i<n; i++) {
            double clazz = gmmSemi.classify(mmn,data[i]);
            if ((int)clazz == (int)trueLabels[i])
                correct++;
        }
        double ratio = correct/(double)n;
        System.out.println("Accuracy: "+String.format("%1$.4f",ratio));

    }
}
