/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2019 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
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

package com.actelion.research.orbit.imageAnalysis.deeplearning.playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p><pre>
 * Copyright 1997-2018 Idorsia Ltd., Inc.
 * Hegenheimermattweg 89
 * CH-4123 Allschwil, Switzerland
 *
 * All Rights Reserved.
 * This software is the proprietary information of Idorsia Pharmaceuticals, Ltd.
 * Use is subject to license terms.
 * </pre></p>
 * <p>
 * User: stritma1
 * Date: 8/9/2019
 * Time: 3:47 PM
 */
public class MaskRCNNAnchors {

    public static int img_width = 512;
    public static int img_height = 512;
    public static int[][] feature_shapes = new int[][]{
            {128,128},{64,64},{32,32},{16,16},{8,8}
    };
    public static int[] feature_strides = new int[]{4,8,16,32,64};
    public static float[] scales = new float[]{8,16,32,64,128};
    public static float[] ratios = new float[]{0.5f,1f,2f};
    public static int anchor_stride = 1;

    public static float[] GenerateAnchors() {
        List<Float> list = new ArrayList<>(261888);
        for (int i=0; i<scales.length; i++) {
            float[][] anchors = GenerateAnchorsPerScale(scales[i], ratios, feature_shapes[i], feature_strides[i], anchor_stride);
            for (int r=0; r<anchors.length; r++) {
                for (int c=0; c<anchors[r].length; c++) {
                    list.add(anchors[r][c]);
                }
            }
        }

        float[] fArr = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Float f = list.get(i);
            fArr[i] = f;
        }
        return fArr;
    }

    private static float[][] GenerateAnchorsPerScale(float scales, float[] ratios, int[] shape,
                                          int feature_stride, int anchor_stride) {

        float[] heights = new float[ratios.length];
        float[] widths = new float[ratios.length];
        for (int i=0; i<ratios.length; i++) {
            heights[i] = (float) (scales / Math.sqrt(ratios[i]));
            widths[i] = (float) (scales * Math.sqrt(ratios[i]));
        }

        float[][] box_centers_x = new float[shape[1]*shape[0]][3];
        float x = 0;
        for (int i=0; i<box_centers_x.length; i++) {
            box_centers_x[i][0] = x;
            box_centers_x[i][1] = x;
            box_centers_x[i][2] = x;
            x += anchor_stride * feature_stride;
            if (x>=(shape[0]*anchor_stride*feature_stride)) x=0;
        }

        float[][] box_centers_y = new float[shape[0]*shape[0]][3];  // TODO: shape[1]*shape[0] ???
        float y = 0;
        for (int i=0; i<box_centers_y.length; i++) {
            if (i>0 &&(i%(shape[1])==0)) {
                y += anchor_stride * feature_stride;
            }
            box_centers_y[i][0] = y;
            box_centers_y[i][1] = y;
            box_centers_y[i][2] = y;
        }

        float[][] box_centers = new float[box_centers_y.length*3][2];
        for (int i=0; i<box_centers_y.length*3; i+=3) {
            for (int j=0; j<3; j++) {
                box_centers[i+j][0] = box_centers_y[i/3][j];
                box_centers[i+j][1] = box_centers_x[i/3][j];
            }
        }

        float sw = img_width-1;
        float sh = img_height-1;
        float[][] boxes = new float[box_centers.length][4];    // normalized
        for (int i=0; i<box_centers.length; i++) {
            boxes[i][0] = (box_centers[i][0] - 0.5f * heights[i%3]) / sh;  // y1
            boxes[i][1] = (box_centers[i][1] - 0.5f * widths[i%3]) / sw;   // x1
            boxes[i][2] = ((box_centers[i][0] + 0.5f * heights[i%3])-1f) / sh;  // y2
            boxes[i][3] = ((box_centers[i][1] + 0.5f * widths[i%3])-1f) / sw;   // x2
        }

        return boxes;
    }


    public static void main(String[] args) {
        float[] arr = MaskRCNNAnchors.GenerateAnchors();
        System.out.println("anchors: "+ Arrays.toString(arr));
        System.out.println("size: "+ arr.length);
        System.out.println("last element: "+arr[arr.length-1]);
    }

}
