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

package com.actelion.research.orbit.imageAnalysis.modules.mihc;

import java.io.Serializable;

/**
 * Nanozoomer S60 Matrices for Fluorescent Multiplex Immunohistochemistry (mIHC) with Tyramide Signal Amplification Protocol
 */
public class MihcConfigData implements Serializable {

    public String[] channelNames6 = new String[]{"DAPI","FITC-Alexa488","CY3","Cy3.5","Cy5","Cy5.5"};
    public String[] channelNames5 = new String[]{"FITC-Alexa488","CY3","Cy3.5","Cy5","Cy5.5"};
    public String[] channelNames4 = new String[]{"DAPI","FITC-Alexa488","Cy3.5","Cy5.5"};
    public String[] channelNames3 = new String[]{"DAPI","FITC","Cy3.5"};
    public String[] channelNames4HT = new String[]{"DAPI 2 (387) ","FITC 2 (485)","AAA", "TRITC 2 (560)"};
    public String[] channelNames3HT = new String[]{"DAPI 2 (387) ","FITC 2 (485)","TRITC 2 (560)"};
    public String[] channelNames2HT = new String[]{"FITC 2 (485)","TRITC 2 (560)"};

    public double[] normGain6 = new double[]{10,8,1,1,1,2};
    public double[] normGain4 = new double[]{16,32,5,1};
    public double[] normGain3 = new double[]{16,32,1};
    public double[] normGain2 = new double[]{32,1};


    public double[][] filterNewXeonPercent = new double[][]{
            {100.000,	0.000,	0.000,	0.000,	0.000,	0.000},
            {0.000,	100.000,	0.202,	0.000,	0.000,	0.000},
            {0.000,	1.215,	100.000,	31.940,	0.000,	0.000},
            {0.000,	0.000,	69.879,	100.000,	1.554,	0.000},
            {0.000,	0.000,	0.000,	0.027,	100.000,	39.109},
            {0.000,	0.000,	0.000,	0.004,	36.232,	100.000}
    };


    public double[][] filterNewXeon6 = new double[][] {
            {1.0,0.0,0.0,0.0,0.0,0.0},
            {0.0,1.0,0.00202,0.0,0.0,0.0},
            {0.0,0.01215,1.0,0.3194,0.0,0.0},
            {0.0,0.0,0.69879,1.0,0.01554,0.0},
            {0.0,0.0,0.0,0.00027,1.0,0.39109},
            {0.0,0.0,0.0,0.00004,0.36232,1.0}
    };

    public double[][] filterNewXeon5 = new double[][] {
            {1.0,0.00202,0.0,0.0,0.0},
            {0.01215,1.0,0.3194,0.0,0.0},
            {0.0,0.69879,1.0,0.01554,0.0},
            {0.0,0.0,0.00027,1.0,0.39109},
            {0.0,0.0,0.00004,0.36232,1.0}
    };
    public double[][] Asn4 = new double[][] {
            {1,0,0,0.0},
            {0,1,0.4,0.1},
            {0,0.3,1,0},
            {0,0.1,0.3,1}
    };

    public double[][] Asn3 = new double[][] {
            {1,0,0},
            {0,1,0.4},
            {0,0.3,1},
    };

    public double[][] Asn2 = new double[][] {
            {1,0.4},
            {0.3,1}
    };


    public double[][] Asn31 = new double[][] {
            {1.0,0.25,0.1},
            {0.05,1.0,0.3194},
            {0.18,0.45,1.0},
    };


    public double[][] inverse = new double[][] {
            {1.0,-0.0,-0.0,-0.0,-0.0,-0.0},
            {-0.0,1.0000315958,-0.0026004759,0.0008305958,-0.0000150384,0.0000058814},
            {-0.0,-0.0156414762,1.2873642954,-0.4111860496,0.0074447503,-0.0029115674},
            {-0.0,0.0109301575,-0.8996014388,1.2873386281,-0.0233079762,0.0091155164},
            {-0.0,-0.0000032391,0.000266596,-0.0003815015,1.1651003292,-0.4556590877},
            {-0.0,0.0000007364,-0.000060609,0.0000867321,-0.422138219,1.1650940361}
    };

    public double[][] filterNewXeon4fake = new double[][]{
            {1.000,	2.000,	3.000,	4.000},
            {0.450,	1.000,	0.900,	0.100},
            {0.670,	-2.000,	1.000,	-0.200},
            {5.000,	0.700,	-0.354,	1.000}
    };


}
