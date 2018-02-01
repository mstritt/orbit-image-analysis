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

// Decompiled from loci_tools.jar (http://www.loci.wisc.edu/bio-formats/downloads)
// to avoid the big 9mb jar... (18.03.2011 Manuel)

/*     */ 
/*     */

import ij.process.*;
import loci.common.DataTools;
import loci.formats.*;

import java.io.IOException;

/*     */
/*     */ public class ImageProcessorReader extends ReaderWrapper
/*     */ {
    /*     */
    public static ImageProcessorReader makeImageProcessorReader(IFormatReader r)
/*     */ {
/*  60 */
        if (r instanceof ImageProcessorReader) return ((ImageProcessorReader) r);
/*  61 */
        return new ImageProcessorReader(r);
/*     */
    }

    /*     */
/*     */ 
/*     */
    public ImageProcessorReader(IFormatReader r) {
/*  70 */
        super(r);
/*     */
    }

    /*     */
/*     */
    public ImageProcessor[] openProcessors(int no)
/*     */     throws FormatException, IOException
/*     */ {
/*  83 */
        return openProcessors(no, 0, 0, getSizeX(), getSizeY());
/*     */
    }

    /*     */
/*     */
    public ImageProcessor[] openProcessors(int no, int x, int y, int w, int h)
/*     */     throws FormatException, IOException
/*     */ {
/*  97 */
        byte[] b = openBytes(no, x, y, w, h);
/*     */ 
/*  99 */
        int c = getRGBChannelCount();
/* 100 */
        int type = getPixelType();
/* 101 */
        int bpp = FormatTools.getBytesPerPixel(type);
/* 102 */
        boolean interleave = isInterleaved();
/*     */ 
/* 104 */
        if ((b.length != w * h * c * bpp) && (b.length != w * h * bpp)) {
/* 105 */
            throw new FormatException("Invalid byte array length: " + b.length + " (expected w=" + w + ", h=" + h + ", c=" + c + ", bpp=" + bpp + ")");
/*     */
        }
/*     */ 
/* 110 */
        LUT cm = createColorModel();
/*     */ 
/* 113 */
        boolean isFloat = FormatTools.isFloatingPoint(type);
/* 114 */
        boolean isLittle = isLittleEndian();
/* 115 */
        boolean isSigned = FormatTools.isSigned(type);
/*     */ 
/* 118 */
        ImageProcessor[] ip = new ImageProcessor[c];
/* 119 */
        for (int i = 0; i < c; ++i) {
/* 120 */
            byte[] channel = ImageTools.splitChannels(b, i, c, bpp, false, interleave);
/*     */ 
/* 122 */
            Object pixels = DataTools.makeDataArray(channel, bpp, isFloat, isLittle);
/* 123 */
            if (pixels instanceof byte[]) {
/* 124 */
                byte[] q = (byte[]) pixels;
/* 125 */
                if (q.length != w * h) {
/* 126 */
                    byte[] tmp = q;
/* 127 */
                    q = new byte[w * h];
/* 128 */
                    System.arraycopy(tmp, 0, q, 0, Math.min(q.length, tmp.length));
/*     */
                }
/* 130 */
                if (isSigned) q = DataTools.makeSigned(q);
/*     */ 
/* 132 */
                ip[i] = new ByteProcessor(w, h, q, null);
/* 133 */
                if (cm != null) ip[i].setColorModel(cm);
/*     */
            }
/* 135 */
            else if (pixels instanceof short[]) {
/* 136 */
                short[] q = (short[]) pixels;
/* 137 */
                if (q.length != w * h) {
/* 138 */
                    short[] tmp = q;
/* 139 */
                    q = new short[w * h];
/* 140 */
                    System.arraycopy(tmp, 0, q, 0, Math.min(q.length, tmp.length));
/*     */
                }
/* 142 */
                if (isSigned) q = DataTools.makeSigned(q);
/*     */ 
/* 144 */
                ip[i] = new ShortProcessor(w, h, q, cm);
/*     */
            }
/* 146 */
            else if (pixels instanceof int[]) {
/* 147 */
                int[] q = (int[]) pixels;
/* 148 */
                if (q.length != w * h) {
/* 149 */
                    int[] tmp = q;
/* 150 */
                    q = new int[w * h];
/* 151 */
                    System.arraycopy(tmp, 0, q, 0, Math.min(q.length, tmp.length));
/*     */
                }
/*     */ 
/* 154 */
                ip[i] = new FloatProcessor(w, h, q);
/*     */
            }
/* 156 */
            else if (pixels instanceof float[]) {
/* 157 */
                float[] q = (float[]) pixels;
/* 158 */
                if (q.length != w * h) {
/* 159 */
                    float[] tmp = q;
/* 160 */
                    q = new float[w * h];
/* 161 */
                    System.arraycopy(tmp, 0, q, 0, Math.min(q.length, tmp.length));
/*     */
                }
/* 163 */
                ip[i] = new FloatProcessor(w, h, q, null);
/*     */
            }
/* 165 */
            else if (pixels instanceof double[]) {
/* 166 */
                double[] q = (double[]) pixels;
/* 167 */
                if (q.length != w * h) {
/* 168 */
                    double[] tmp = q;
/* 169 */
                    q = new double[w * h];
/* 170 */
                    System.arraycopy(tmp, 0, q, 0, Math.min(q.length, tmp.length));
/*     */
                }
/* 172 */
                ip[i] = new FloatProcessor(w, h, q);
/*     */
            }
/*     */
        }
/*     */ 
/* 176 */
        return ip;
/*     */
    }
/*     */ 
   
   /*
   public Class<?> getNativeDataType()
   {
     return [Lij.process.ImageProcessor.class;
   }
   */

    /*     */
/*     */
    public Object openPlane(int no, int x, int y, int w, int h)
/*     */     throws FormatException, IOException
/*     */ {
/* 190 */
        return openProcessors(no, x, y, w, h);
/*     */
    }

    /*     */
/*     */
    private LUT createColorModel()
/*     */     throws FormatException, IOException
/*     */ {
/* 200 */
        byte[][] byteTable = get8BitLookupTable();
/* 201 */
        if (byteTable == null) byteTable = convertTo8Bit(get16BitLookupTable());
/* 202 */
        if ((byteTable == null) || (byteTable.length == 0)) return null;
/*     */ 
/* 205 */
        int colors = byteTable.length;
/* 206 */
        int samples = byteTable[0].length;
/* 207 */
        byte[] r = (colors >= 1) ? byteTable[0] : new byte[samples];
/* 208 */
        byte[] g = (colors >= 2) ? byteTable[1] : new byte[samples];
/* 209 */
        byte[] b = (colors >= 3) ? byteTable[2] : new byte[samples];
/* 210 */
        return new LUT(8, samples, r, g, b);
/*     */
    }

    /*     */
/*     */
    private byte[][] convertTo8Bit(short[][] shortTable) {
/* 214 */
        if (shortTable == null) return null;
/* 215 */
        byte[][] byteTable = new byte[shortTable.length][256];
/* 216 */
        for (int c = 0; c < byteTable.length; ++c) {
/* 217 */
            int len = Math.min(byteTable[c].length, shortTable[c].length);
/*     */ 
/* 219 */
            for (int i = 0; i < len; ++i)
/*     */ {
/* 239 */
                int valuesPerBin = shortTable[c].length / byteTable[c].length;
/* 240 */
                double average = 0.0D;
/* 241 */
                for (int p = 0; p < valuesPerBin; ++p) {
/* 242 */
                    average += shortTable[c][(i * valuesPerBin + p)];
/*     */
                }
/* 244 */
                average /= valuesPerBin;
/* 245 */
                byteTable[c][i] = (byte) (int) (255.0D * average / 65535.0D);
/*     */
            }
/*     */
        }
/* 248 */
        return byteTable;
/*     */
    }
/*     */
}

/* Location:           D:\dev\Java\OrbitImageAnalysis\lib\loci_tools.jar
 * Qualified Name:     loci.plugins.util.ImageProcessorReader
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.5.3
 */