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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

/**
 * Provides helper methods for computing statistics from the object segmentation mixtures. Can be used with the result of
 * RecognitionFrame.getMixtures.<br>
 * Call the compute() method before calling the getter methods.
 */
public class MixtureStatistics implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<String> classes = null;
    private Hashtable<String, Integer> objectsPerClass = null;
    private List<double[]> mixtures = null;
    private List<ClassShape> classShapes = null;
    private String outString = "";

    public MixtureStatistics(List<double[]> mixtures, List<ClassShape> classShapes) {
        if (mixtures == null || mixtures.size() < 1)
            throw new IllegalArgumentException("Error: mixtures cannot be null and size should be > 0.");
        if (mixtures.get(0).length != classShapes.size())
            throw new IllegalArgumentException("Mixtures[0] and ClassShapes cannot have different sizes.");
        this.mixtures = mixtures;
        this.classShapes = classShapes;
    }

    /**
     * computes the statistics and has to be called before calling getClasses or getObjectsperClass.
     */
    public void compute() {
        int i = 0;
        classes = new ArrayList<String>(classShapes.size());
        StringBuilder sb = new StringBuilder();
        sb.append("Object\t");
        for (int j = 0; j < classShapes.size(); j++) {
            sb.append(classShapes.get(j).getName());
            //if (j<recognitionFrame.getRatio().length-1)
            sb.append("\t");
        }
        sb.append("mixtureClass");

        sb.append("\n");
        for (double[] mix : mixtures) {
            sb.append("Obj" + i + "\t");
            String mixClass = "(";
            for (int m = 0; m < mix.length; m++) {
                sb.append(String.format("%1$.4f", mix[m]));
                //if (m<mix.length-1)
                sb.append("\t");
                if ((mix[m] >= classShapes.get(m).getMixtureTreshold()) /*&& classShapes.get(m).isEnableObjectCount()*/) {
                    if (!mixClass.equals("(")) mixClass += "/";
                    mixClass += classShapes.get(m).getName();
                }
            }
            mixClass += ")";
            classes.add(mixClass); // "()" classes are also allowed!!!
            sb.append(mixClass);
            sb.append("\n");
            i++;
        }
        outString = sb.toString();
        countObjectsPerClass();
    }

    public String getObjDescription(int obj) {
        StringBuffer sb = new StringBuffer();
        int i = obj;
        double[] mix = mixtures.get(i);
        sb.append("Obj" + i + " ");
        String mixClass = "(";
        for (int m = 0; m < mix.length; m++) {
            sb.append(classShapes.get(m).getName() + ": ");
            sb.append(String.format("%1$.2f", mix[m]));
            //if (m<mix.length-1)
            sb.append(" ");
            if ((mix[m] >= classShapes.get(m).getMixtureTreshold()) /*&& classShapes.get(m).isEnableObjectCount()*/) {
                if (!mixClass.equals("(")) mixClass += "/";
                mixClass += classShapes.get(m).getName();
            }
        }
        mixClass += ")";
        sb.append(" Class: " + mixClass);
        return sb.toString();
    }

    private void countObjectsPerClass() {
        if (classes == null) throw new IllegalArgumentException("compute() has to be called before.");
        objectsPerClass = new Hashtable<String, Integer>(classShapes.size());
        for (String c : classes) {
            if (!objectsPerClass.containsKey(c)) {
                objectsPerClass.put(c, 1);
            }
            objectsPerClass.put(c, objectsPerClass.get(c) + 1);
        }
    }

    public List<String> getClasses() {
        if (classes == null) throw new IllegalArgumentException("compute() has to be called before.");
        return classes;
    }

    public void setClasses(List<String> classes) {
        this.classes = classes;
    }

    public Hashtable<String, Integer> getObjectsPerClass() {
        if (objectsPerClass == null) throw new IllegalArgumentException("compute() has to be called before.");
        return objectsPerClass;
    }

    public List<double[]> getMixtures() {
        return mixtures;
    }

    public void setMixtures(List<double[]> mixtures) {
        this.mixtures = mixtures;
    }

    public String toString() {
        if (outString != null && outString.length() > 0) return outString;
        else return "Not yet computed.";
    }

    public String toStringExtended() {
        if (objectsPerClass == null) throw new IllegalArgumentException("compute() has to be called before.");
        StringBuilder sb = new StringBuilder(outString.length());
        sb.append("#Objects per class:\n");
        sb.append("mixtureClass\tobjectCount\n");

        List<String> classList = new ArrayList<String>(objectsPerClass.size());
        for (String k : objectsPerClass.keySet()) classList.add(k);
        Collections.sort(classList);
        for (String k : classList) {
            sb.append(k + "\t" + objectsPerClass.get(k) + "\n");
        }
        sb.append("\n");
        sb.append("Mixtures per object:\n");
        sb.append(outString);
        return sb.toString();
    }

}
