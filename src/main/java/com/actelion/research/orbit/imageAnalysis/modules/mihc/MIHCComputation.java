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

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import java.text.DecimalFormat;

public class MIHCComputation {

    private Array2DRowRealMatrix inverseMatrix;

    public static void main(String[] args) {
          MIHCConfig conf = new MIHCConfig();
          RealMatrix inverse = MatrixUtils.inverse(MatrixUtils.createRealMatrix(conf.filterNewXeon4fake));
          printMat(inverse);

//        Array2DRowRealMatrix AsnInv = (Array2DRowRealMatrix) MatrixUtils.createRealMatrix(conf.inverse);
//        printMat(AsnInv);
//        double[] gain = new double[]{1,1,1,1,2,1};
//        for (int i=0; i<gain.length; i++) gain[i] = 1d/gain[i];
//        RealMatrix GiiInv = MatrixUtils.createRealDiagonalMatrix(gain);
//        printMat(GiiInv);
//        Array2DRowRealMatrix AsnInvNorm = (Array2DRowRealMatrix) AsnInv.multiply(GiiInv);
//        printMat(AsnInvNorm);
//        double[] out = new double[gain.length];
//
//        //double[] in = new double[]{0,000,0,0,100,39};
//        double[] in = new double[]{0,0,0,1.554,100,36.232};   // -> 0,0,0,0,100,0
//        fastMultiply(AsnInvNorm,in,out);
//        System.out.println(Arrays.toString(out));
    }

    public MIHCComputation() {
        MIHCConfig conf = new MIHCConfig();
        Array2DRowRealMatrix AsnInv = (Array2DRowRealMatrix) MatrixUtils.createRealMatrix(conf.inverse);
        double[] gain = new double[]{1,1,1,1,1,1};
        for (int i=0; i<gain.length; i++) gain[i] = 1d/gain[i];
        RealMatrix GiiInv = MatrixUtils.createRealDiagonalMatrix(gain);
        Array2DRowRealMatrix AsnInvNorm = (Array2DRowRealMatrix) AsnInv.multiply(GiiInv);
        inverseMatrix = AsnInvNorm;
    }

    public void unmix(final Array2DRowRealMatrix inverseMatrix, final double[] measurement, final double[] out) {
        fastMultiply(inverseMatrix,measurement,out);
    }

    private static void fastMultiply(final Array2DRowRealMatrix mat, final double[] v, final double[] out) {
        final int n = v.length;
        for (int row = 0; row < n; row++) {
            final double[] dataRow = mat.getDataRef()[row];
            double sum = 0;
            for (int i = 0; i < n; i++) {
                sum += dataRow[i] * v[i];
            }
            out[row] = sum;
        }
    }

    public static void printMat(final RealMatrix m) {
        System.out.println(formatMatrix(m));
    }

    public static String formatMatrix(final RealMatrix m) {
        StringBuilder out = new StringBuilder();
        DecimalFormat df = new DecimalFormat("####0.00");

        for (int i = 0; i < m.getRowDimension(); i++) {
            for (int j = 0; j < m.getColumnDimension(); j++) {
                double value = m.getEntry(i, j);
                if (value >= 0)
                    out.append(" ");
                out.append(" " + df.format(value));
            }
            out.append("\n");
        }

        return out.toString();
    }

}
