/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2020 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
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

package com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN;

//TODO: Move this to detections class?

import com.actelion.research.orbit.imageAnalysis.models.RectangleExt;

/**
 * MaskRCNNRawDetections. Stores the objectBB (Bounding Box) and the detection masks.
 * Object Bound Box has one array entry, with maxDetections arrays containing: y1, x1, y2, x2, class_id, probability
 * Masks has one array entry, with maxDetections arrays containing, the mask width x mask height with a probability of
 * background[0] and then the probability for each class[1:numClasses].
 */
public class MaskRCNNRawDetections {
    // TODO: Set back to package private.
    public float[][][] objectBB; // float[imageNumber][maxDetection][y1,x1,y2,x2,class_id,probability (ordered desc)]
    public float[][][][][] masks;  // float[imageNumber][maxDetections][maskwidth][maskheight][numClasses] for each mask -> probability class membership.

    int getNumBoundingBoxes() {
        return objectBB[0].length;
    }

    float getBoundingBoxProbability(int i) {
        return objectBB[0][i][5];
    }

    int getBoundingBoxClass(int i) {
        return (int) objectBB[0][i][4];
    }

    float getBoundingBoxArea(int i) {
        return (objectBB[0][i][3]-objectBB[0][i][1])*(objectBB[0][i][2]-objectBB[0][i][0]);
    }

    RectangleExt getRescaledBoundingBox(int i, int imgWidth, int imgHeight) {
        int x = (int)(objectBB[0][i][1] * imgWidth);
        int y = (int)(objectBB[0][i][0] * imgHeight);
        int width = (int)((objectBB[0][i][3]-objectBB[0][i][1])*imgWidth);
        int height = (int)((objectBB[0][i][2]-objectBB[0][i][0])*imgHeight);
        return new RectangleExt(x,y,width,height);
    }

    int getMaskWidth(int i) {
        return masks[0][i][0].length;
    }

    int getMaskHeight(int i) {
        return masks[0][i].length;
    }

    float getMaskPixelProbability(int i, int maskX, int maskY, int classNum) {
        // Note the x and y axis...
        return masks[0][i][maskY][maskX][classNum];
    }

}