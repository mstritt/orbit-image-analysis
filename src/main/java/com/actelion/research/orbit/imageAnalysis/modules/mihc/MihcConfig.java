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

package com.actelion.research.orbit.imageAnalysis.modules.mihc;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.XomDriver;

import java.io.*;
import java.util.Arrays;

public class MihcConfig implements Serializable, Cloneable {
    private String[] matrixChannelNames;
    private double[] normalGains;
    private double[][] matrix;

    public MihcConfig() {
    }

    public MihcConfig(final String[] matrixChannelNames, final double[][] matrix, final double[] normalGains) {
        this.matrixChannelNames = matrixChannelNames;
        this.normalGains = normalGains;
        this.matrix = matrix;
    }

    public String[] getMatrixChannelNames() {
        return matrixChannelNames;
    }

    public void setMatrixChannelNames(String[] matrixChannelNames) {
        this.matrixChannelNames = matrixChannelNames;
    }

    public double[] getNormalGains() {
        return normalGains;
    }

    public void setNormalGains(double[] normalGains) {
        this.normalGains = normalGains;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public String toString() {
        return "MihcConfig{" +
                "matrixChannelNames=" + Arrays.toString(matrixChannelNames) +
                ", normalGains=" + Arrays.toString(normalGains) +
                ", matrix=" + Arrays.toString(matrix) +
                '}';
    }

    @Override
    public MihcConfig clone() throws CloneNotSupportedException {
        return (MihcConfig) super.clone();
    }

    public void saveConfig(String filename) {
        File file = new File(filename);
        FileOutputStream fos = null;
        XStream stream = new XStream(new JsonHierarchicalStreamDriver());
        try {
            fos = new FileOutputStream(file);
            ObjectOutputStream oos = stream.createObjectOutputStream(fos);
            oos.writeObject(this);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) try {
                fos.close();
            } catch (IOException e) {
            }
        }
    }

}
