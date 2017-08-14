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

import com.actelion.research.orbit.imageAnalysis.dal.localImage.NDPISReaderOrbit;
import com.actelion.research.orbit.imageAnalysis.dal.localImage.NDPIUtils;
import loci.common.services.ServiceFactory;
import loci.formats.IFormatReader;
import loci.formats.gui.BufferedImageReader;
import loci.formats.meta.IMetadata;
import loci.formats.services.OMEXMLService;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Calibration {
    private double intensityThreshold = 5;
    private double tilePixelRatio = 10;
    private long maxRegressionPoints = 100000;
    private int numRegistration = 10;
    private int translationSearch = 15;
    private static final Logger logger = LoggerFactory.getLogger(Calibration.class);

    public CalibrationResult computeCalibrationMatrix(String[] ndpisFiles) throws Exception {
        int sizeC = ndpisFiles.length;
        IFormatReader[] readers = new IFormatReader[sizeC];
        double[] normalGain = new double[sizeC];
        String[] channelNames = new String[sizeC];
        double[][] matrix = new double[sizeC][sizeC];
        try {
            for (int i = 0; i < sizeC; i++) {
                readers[i] = new NDPISReaderOrbit();
                readers[i].setFlattenedResolutions(false);
                ServiceFactory factory = new ServiceFactory();
                OMEXMLService service = factory.getInstance(OMEXMLService.class);
                IMetadata meta = service.createOMEXMLMetadata();
                readers[i].setMetadataStore(meta);
                readers[i] = new BufferedImageReader(readers[i]);
                readers[i].setId(ndpisFiles[i]);

                // average normal gain
                double[] gains = NDPIUtils.getExposureTimesGain((NDPISReaderOrbit) ((BufferedImageReader)readers[i]).getReader());
                for (int c = 0; c < sizeC; c++) {
                    normalGain[c] += gains[c];
                }
                for (int c = 0; c < sizeC; c++) {
                    normalGain[c] /= sizeC;
                }

                // channel names
                for (int c = 0; c < sizeC; c++) {
                    String channelName = meta.getChannelName(0, c);
                    System.out.println("channel: " + channelName);
                    if (i == 0) { // first image defines channels, for all others test if same channelnames / order
                        channelNames[c] = channelName;
                    } else {
                        if (!channelNames[c].equals(channelName)) {
                            throw new IllegalArgumentException("channel names are nto the same for all images");
                        }
                    }
                }

            }



            logger.info("channel names: " + Arrays.toString(channelNames));
            logger.info("normal gain: " + Arrays.toString(normalGain));

            // matrix
            int optimalTileWidth = 512;
            int optimalTileHeight = 512;
            int width = readers[0].getSizeX();
            int height = readers[0].getSizeY();

            java.util.List<Point> tiles = new ArrayList<>(Arrays.asList(getTileIndices(readers[0],optimalTileWidth,optimalTileHeight)));
            Collections.shuffle(tiles);
            for (int ci = 0; ci < sizeC; ci++) {
                for (int cj = 0; cj < sizeC; cj++) {
                    if (ci == cj) {
                        matrix[ci][cj] = 1d;
                    } else {
                        List<double[]> pairList = new ArrayList<>((int) (width * height * 0.25));
                        List<Point> translationUV = new ArrayList<>();
                        Point uvGlobal = null;
                        for (Point tile : tiles) {
                            int tileX = tile.x;
                            int tileY = tile.y;
                            int x = optimalTileWidth * tileX;
                            int y = optimalTileHeight * tileY;
                            int w = Math.min(optimalTileWidth, width - x);
                            int h = Math.min(optimalTileHeight, height - y);
                            BufferedImage bi1 = ((BufferedImageReader) readers[ci]).openImage(cj, x, y, w, h);
                            BufferedImage bi2 = ((BufferedImageReader) readers[cj]).openImage(cj, x, y, w, h);
                            RegistrationTrans reg = new RegistrationTrans();
                            Point uv;
                            if (uvGlobal!=null) {
                                uv = uvGlobal;
                            } else {
                                uv = reg.findBestOffset(bi1.getRaster(), bi2.getRaster(), translationSearch, translationSearch);
                                translationUV.add(uv);
                                if (translationUV.size()>=numRegistration) {
                                    double uvx = 0d;
                                    double uvy = 0d;
                                    for (Point point: translationUV) {
                                        uvx += point.x;
                                        uvy += point.y;
                                    }
                                    uvx /= translationUV.size();
                                    uvy /= translationUV.size();
                                    uvGlobal = new Point((int)uvx,(int)uvy);
                                }
                            }
                            List<double[]> tilePairs = getPairs(bi2, bi1, uv.x, uv.y, ci, cj);
                            double ratio = (tilePairs.size() / (double)(optimalTileWidth * optimalTileHeight));
                            logger.trace("ratio: " + ratio);
                            if (ratio >= tilePixelRatio) {
                                pairList.addAll(tilePairs);
                            }
                            if (pairList.size()>=maxRegressionPoints) break; // enough points, skip further tiles
                        }  // tiles
                        SimpleRegression reg = new SimpleRegression(true);
                        for (double[] p : pairList) {
                            reg.addData(p[0], p[1]);
                        }
                        matrix[ci][cj] = reg.getSlope();
                    }

                }
            }
        } finally {
            for (int i = 0; i < ndpisFiles.length; i++) {
                try {
                    readers[i].close();
                } catch (Exception e) {}
            }
        }

        // we do not normalize the gain here, because the normalGain is defined as the averaged gain per calibration channel
        // normalizeGain(matrix,normalGain);

        return new CalibrationResult(matrix,channelNames,normalGain);
    }



    public List<double[]> getPairs(BufferedImage bi1, BufferedImage bi2, int u, int v,  int s, int n) throws IOException {
        List<double[]> pairList = new ArrayList<>(bi1.getWidth()*bi1.getHeight());
        Raster r1 = bi1.getRaster().createTranslatedChild(0,0);
        Raster r2 = bi2.getRaster().createTranslatedChild(0,0);
        if (r1.getNumBands()>1) throw new IllegalArgumentException("only 1-banded rasters allowed here");
        if (r2.getNumBands()>1) throw new IllegalArgumentException("only 1-banded rasters allowed here");
        SimpleRegression reg = new SimpleRegression(true);
        int minX = u<0?u*-1:0;
        int minY = v<0?v*-1:0;
        int maxX = u>0?bi1.getWidth()-u: bi1.getWidth();
        int maxY = v>0?bi1.getHeight()-v: bi1.getHeight();
        for (int x=minX; x<maxX; x++) {
            for (int y=minY; y<maxY; y++) {
                double d1 = r1.getSampleDouble(x+u,y+v,0);
                if (d1> intensityThreshold) {
                    double d2 = r2.getSampleDouble(x, y, 0);
                    double[] pair = new double[]{d2,d1};
                    pairList.add(pair);
                }
            }
        }

        return pairList;
    }


    public double getSlope(BufferedImage bi1, BufferedImage bi2, int u, int v,  int s, int n) throws IOException {
       
        Raster r1 = bi1.getRaster().createTranslatedChild(0,0);
        Raster r2 = bi2.getRaster().createTranslatedChild(0,0);
        if (r1.getNumBands()>1) throw new IllegalArgumentException("only 1-banded rasters allowed here");
        if (r2.getNumBands()>1) throw new IllegalArgumentException("only 1-banded rasters allowed here");
        SimpleRegression reg = new SimpleRegression(true);
        int minX = u<0?u*-1:0;
        int minY = v<0?v*-1:0;
        int maxX = u>0?bi1.getWidth()-u: bi1.getWidth();
        int maxY = v>0?bi1.getHeight()-v: bi1.getHeight();
        for (int x=minX; x<maxX; x++) {
             for (int y=minY; y<maxY; y++) {
                 double d1 = r1.getSampleDouble(x+u,y+v,0);
                 if (d1> intensityThreshold) {
                     double d2 = r2.getSampleDouble(x, y, 0);
                     reg.addData(d2, d1);
                 }
             }
         }

        double slope = reg.getSlope();
        double intercept = reg.getIntercept();
        logger.info("i,j: "+s+","+n+": "+ "slope: "+slope+" ; intercept: "+intercept);
        return slope;
    }

    /**
     * Devide each row n by gain[s]. matrix will be manipulated.
     */
    protected void normalizeGain(final double[][] matrix, final double[] gain) {
        if (matrix.length!=gain.length) throw new IllegalArgumentException("matrix and gain dimensions do not match. matrix.length must be gain.length");
        for (int s=0; s<gain.length; s++) {
            if (matrix[s].length!=gain.length) throw new IllegalArgumentException("matrix and gain dimensions do not match. matrix["+s+"].length must be gain.length");
            for (int n=0; n<gain.length; n++) {
                matrix[s][n] /= gain[s];
            }
        }
    }

    public double[][] createMatrixTestImages(String prefix, String ending, int sizeC) throws IOException {
        RegistrationTrans reg = new RegistrationTrans();
        double[][] matrix = new double[sizeC][sizeC];
        for (int s=0; s<sizeC; s++) {
             for (int n=0; n<sizeC; n++) {
                 String fn1 = prefix+s+"x"+s+ending;
                 String fn2 = prefix+s+"x"+n+ending;
                 BufferedImage bi1 = ImageIO.read(new java.io.File(fn1));
                 BufferedImage bi2 = ImageIO.read(new java.io.File(fn2));
                 Point uv = reg.findBestOffset(bi1.getRaster(), bi2.getRaster(),15,15);
                 logger.info("uv: "+uv);
                 double slope = getSlope(bi2,bi1,uv.x,uv.y, 0,1);
                 matrix[s][n] = slope;
             }
         }
         return matrix;
    }


    public Point[] getTileIndices(IFormatReader reader, int tileWidth, int tileHeight) {
        Rectangle region = new Rectangle(0, 0, reader.getSizeX()+1, reader.getSizeY() + 1);
        int minTileX = XToTileX(region.x,0,tileWidth);
        int maxTileX = XToTileX(region.x + region.width - 1,0,tileWidth);
        int minTileY = this.YToTileY(region.y,0,tileHeight);
        int maxTileY = this.YToTileY(region.y + region.height - 1,0,tileHeight);
        Point[] tileIndices = new Point[(maxTileY - minTileY + 1) * (maxTileX - minTileX + 1)];
        int tileIndexOffset = 0;

        for(int ty = minTileY; ty <= maxTileY; ++ty) {
            for(int tx = minTileX; tx <= maxTileX; ++tx) {
                tileIndices[tileIndexOffset++] = new Point(tx, ty);
            }
        }

        return tileIndices;
    }

    public int XToTileX(int x, int tileGridXOffset, int tileWidth) {
        x -= tileGridXOffset;
        if (x < 0) {
            x += 1 - tileWidth;
        }

        return x / tileWidth;
    }

    public int YToTileY(int y, int tileGridYOffset, int tileHeight) {
        y -= tileGridYOffset;
        if (y < 0) {
            y += 1 - tileHeight;
        }

        return y / tileHeight;
    }


    public static void main(String[] args) throws Exception {
        String[] testFiles = new String[]{
                "D:\\pic\\Hamamatsu\\Scan_Manuel\\Staining-DAPI-Cy5.5-FITC-scan all channels fix.ndpis",
                "D:\\pic\\Hamamatsu\\Scan_Manuel\\Staining-DAPI-Cy5.5-FITC-scan all channels fix.ndpis",
                "D:\\pic\\Hamamatsu\\Scan_Manuel\\Staining-DAPI-Cy5.5-FITC-scan all channels fix.ndpis",
                "D:\\pic\\Hamamatsu\\Scan_Manuel\\Staining-DAPI-Cy5.5-FITC-scan all channels fix.ndpis",
                "D:\\pic\\Hamamatsu\\Scan_Manuel\\Staining-DAPI-Cy5.5-FITC-scan all channels fix.ndpis",
                "D:\\pic\\Hamamatsu\\Scan_Manuel\\Staining-DAPI-Cy5.5-FITC-scan all channels fix.ndpis",
                "D:\\pic\\Hamamatsu\\Scan_Manuel\\Staining-DAPI-Cy5.5-FITC-scan all channels fix.ndpis"};

        Calibration calibration = new Calibration();
        CalibrationResult res = calibration.computeCalibrationMatrix(testFiles);

//        BufferedImage bi1 = ImageIO.read(new java.io.File("D:\\pic\\Hamamatsu\\mihc\\gen\\img0x0.png"));
//        BufferedImage bi2 = ImageIO.read(new java.io.File("D:\\pic\\Hamamatsu\\mihc\\gen\\img0x1.png"));
//        RegistrationTrans reg = new RegistrationTrans();
//        Point uv = reg.findBestOffset(bi1.getRaster(), bi2.getRaster(),15,15);
//        logger.info("uv: "+uv);
//        double slope = calibration.getSlope(bi2,bi1,uv.x,uv.y, 0,1);

//        double[][] matrix = calibration.createMatrixTestImages("D:\\pic\\Hamamatsu\\mihc\\gen\\img",".png",3);
//        RealMatrix rm = MatrixUtils.createRealMatrix(matrix);
//        MIHCComputation.printMat(rm);
//
//        calibration.normalizeGain(matrix,new double[]{2,1,3});
//        rm = MatrixUtils.createRealMatrix(matrix);
//        MIHCComputation.printMat(rm);


    }


}
