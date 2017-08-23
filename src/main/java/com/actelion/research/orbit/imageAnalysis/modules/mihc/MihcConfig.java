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

import java.io.*;
import java.text.DecimalFormat;
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
        return "MihcConfig{\n" +
                "matrixChannelNames=" + Arrays.toString(matrixChannelNames) +
                ", \nnormalGains=" + Arrays.toString(normalGains) +
                ", \nmatrix=\n" + formatMatrix(matrix) +
                '}';
    }

    public static String formatMatrix(final double[][] m) {
        StringBuilder out = new StringBuilder();
        DecimalFormat df = new DecimalFormat("####0.00");

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                double value = m[i][j];
                if (value >= 0)
                    out.append(" ");
                out.append(" " + df.format(value));
            }
            out.append("\n");
        }

        return out.toString();
    }

    @Override
    public MihcConfig clone() throws CloneNotSupportedException {
        return (MihcConfig) super.clone();
    }

    public void saveConfig(String fileName) {
        try (OutputStream outStream = new BufferedOutputStream(new FileOutputStream(fileName))) {
           saveConfig(outStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void saveConfig(OutputStream outStream) {
        XStream stream = new XStream();
        stream.toXML(this,outStream);
    }

    public void loadConfig(String fileName) {
        try (InputStream inStream = new BufferedInputStream(new FileInputStream(fileName))) {
            loadConfig(inStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void loadConfig(InputStream inStream) {
        XStream stream = new XStream();
        Object object = stream.fromXML(inStream);
        MihcConfig conf = (MihcConfig) object;
        this.matrix = conf.getMatrix();
        this.normalGains = conf.getNormalGains();
        this.matrixChannelNames = conf.getMatrixChannelNames();
    }

    public static void main(String[] args) {
        MihcConfig conf = new MihcConfig();
        conf.loadConfig("d:/conf.xml");

        System.out.println(conf);
    }

}
