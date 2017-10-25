/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
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

import loci.common.services.DependencyException;
import loci.common.services.ServiceException;
import loci.common.services.ServiceFactory;
import loci.formats.FormatException;
import loci.formats.gui.BufferedImageReader;
import loci.formats.meta.IMetadata;
import loci.formats.services.OMEXMLService;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class MultiplexImageReader extends BufferedImageReader {

    private static final Logger logger = LoggerFactory.getLogger(MultiplexImageReader.class);
    private Array2DRowRealMatrix invMatrix;
    private double[][] matrix;
    private double[] gains;
    private double[] gainsNorm;
    private RectZT currentRect;
    private BufferedImage[] unmixedChannels;
    private String[] channelNames = null;
    private String[] matrixChannelNames;
    private boolean[] channelIndependent;
    private int[] channelMap;
    private int sizeC;
    private int sizeDependend;

    public MultiplexImageReader(final BufferedImageReader r, final MihcConfig mihcConfig, double[] gains) {
        super(r);
        if (r.getCurrentFile()!=null) throw new IllegalStateException("reader r must be closed, call setId after wrapping");
        this.matrix = mihcConfig.getMatrix();
        this.gainsNorm = mihcConfig.getNormalGains();
        this.matrixChannelNames = mihcConfig.getMatrixChannelNames();
        this.gains = gains;
    }


    @Override
    public void setId(String id) throws FormatException, IOException {
        ServiceFactory factory;
        try {
            factory = new ServiceFactory();
            OMEXMLService service = factory.getInstance(OMEXMLService.class);
            if (getMetadataStore()==null) {
                IMetadata meta = service.createOMEXMLMetadata();
                setMetadataStore(meta);
            }
            IMetadata meta = service.getOMEMetadata(service.asRetrieve(getMetadataStore()));
            super.setId(id);

            HashSet<String> matrixChannelNamesHash = new HashSet<>();
            for (String channelName: matrixChannelNames) {
                matrixChannelNamesHash.add(channelName.toLowerCase().trim());
            }
            channelIndependent = new boolean[getSizeC()];
            channelNames = new String[getSizeC()];
            int mapId=0;
            for (int c = 0; c < getSizeC(); c++) {
                String channelName = meta.getChannelName(getSeries(), c);
                if (channelName == null) {
                    channelName = "Channel" + c;
                }
                channelNames[c] = channelName;
                if (matrixChannelNamesHash.contains(channelName.toLowerCase().trim())) {
                    channelIndependent[c] = false;
                    mapId++;
                }
                else {
                    channelIndependent[c] = true;
                }
                logger.info("channel name " + c + ": " + channelName);
            }
            this.sizeC = getSizeC();
            this.sizeDependend = mapId;

            channelMap = new int[sizeDependend];
            int dep = 0;
            for (int c=0; c<sizeC; c++) {
                if (!channelIndependent[c]) {
                    channelMap[dep++] = c;
                }
            }
            
            System.out.println("sizeDependend: "+sizeDependend);
            RealMatrix rm = MatrixUtils.createRealMatrix(matrix);
            int[] selectedEntries = new int[mapId]; // number of dependent channels
            double[] gainsNormSelected = new double[Math.min(matrix.length,sizeC)];
            double[] gainsSelected = new double[Math.min(matrix.length,sizeC)];
            int n=0;
            for (int c=0; c<channelNames.length; c++) {
                if (!channelIndependent[c]) {
                    for (int i=0; i<matrixChannelNames.length; i++) {
                        if (matrixChannelNames[i].equals(channelNames[c])) {
                            selectedEntries[n] = i;
                            gainsNormSelected[n] = gainsNorm[i];
                            gainsSelected[n] = gains[c];
                            n++;
                        }
                    }
                }
            }
            if (selectedEntries.length>0) {
                RealMatrix rmSub = rm.getSubMatrix(selectedEntries, selectedEntries);  //TODO: check with different channel order
                RealMatrix rmInv = MatrixUtils.inverse(rmSub);
                // find lowest gain and calculate others relative to that
                logger.info("gain gamma: "+Arrays.toString(gainsNormSelected)+"  image gains: "+Arrays.toString(gains)+" gains selected: "+Arrays.toString(gainsSelected));
                double[] gainsInv = new double[gainsSelected.length];
                for (int i=0; i<gainsInv.length; i++) gainsInv[i] = 1d/(gainsSelected[i]/gainsNormSelected[i]);
                RealMatrix GiiInv = MatrixUtils.createRealDiagonalMatrix(gainsInv);
                Array2DRowRealMatrix rmInvNorm = new Array2DRowRealMatrix(rmInv.multiply(GiiInv).getData());
                this.invMatrix = rmInvNorm;
            } else {
                logger.warn("no channelnames / calibration matrix overlap -> no demuxing");
            }


        } catch (DependencyException e) {
            throw new FormatException(e);
        } catch (ServiceException e) {
            throw new FormatException(e);
        }
        
    }

    @Override
    public BufferedImage openImage(int no, int x, int y, int w, int h) throws FormatException, IOException {
        int[] zct = getZCTCoords(no);
        int z = zct[0];
        int chan = zct[1];
        int t = zct[2];
        RectZT rect = new RectZT(x,y,w,h,z,t);
        if (currentRect==null || !currentRect.equals(rect)) {
            logger.trace("cache failed - loading");
            openUnmixedImages(no,x,y,w,h); // unmix all channels at once
        }
        return unmixedChannels[chan];
    }

    public BufferedImage[] openUnmixedImages(int no, int x, int y, int w, int h) throws FormatException, IOException {
        int[] zct = getZCTCoords(no);
        int z = zct[0];
        int chan = zct[1];
        int t = zct[2];
        // load all channels for current rect
        BufferedImage[] channels = new BufferedImage[sizeC];
        for (int c=0; c<sizeC; c++) {
            int no2 = getIndex(z,c,t);
            channels[c] = super.openImage(no2,x,y,w,h);
        }

        BufferedImage ori = channels[0];
        BufferedImage[] bi = new BufferedImage[sizeC];
        WritableRaster[] raster = new WritableRaster[sizeC];
        for (int c=0; c<sizeC; c++) {
            if (!channelIndependent[c]) {
                bi[c] = new BufferedImage(ori.getColorModel(), ori.getRaster().createCompatibleWritableRaster(0, 0, w, h), ori.isAlphaPremultiplied(), null);
                raster[c] = bi[c].getRaster();
            } else {
                bi[c] = channels[c];   // original image, independent channel
                raster[c] = bi[c].getRaster();
            }
        }
        double[] measurements = new double[sizeDependend];
        double[] out = new double[sizeDependend];
        for (int ix=ori.getMinX(); ix<ori.getMinX()+ori.getWidth(); ix++)
            for (int iy=ori.getMinY(); iy<ori.getMinY()+ori.getHeight(); iy++) {
                for (int c=0; c<sizeDependend; c++) {
                    measurements[c] = channels[channelMap[c]].getRaster().getSampleDouble(ix,iy,0); // only 1 banded rasters allowed here
                }
                fastMultiply(invMatrix,measurements,out);   // here the real unmixing takes place
                for (int c=0; c<sizeDependend; c++) {
                    if (out[c]>255) out[c] = 255d;        // TODO: adjust for 16bit!!!
                    if (out[c]<0) out[c] = 0d;
                    raster[channelMap[c]].setSample(ix, iy, 0, out[c]);
                }
            }
        unmixedChannels = bi;
        currentRect = new RectZT(x,y,w,h,z,t);

        return bi;
    }


    private void fastMultiply(final Array2DRowRealMatrix mat, final double[] v, final double[] out) {
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


    class RectZT {
        int x,y,w,h,z,t;

        public RectZT(int x, int y, int w, int h, int z, int t) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.z = z;
            this.t = t;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            RectZT rectZT = (RectZT) o;

            if (x != rectZT.x) return false;
            if (y != rectZT.y) return false;
            if (w != rectZT.w) return false;
            if (h != rectZT.h) return false;
            if (z != rectZT.z) return false;
            return t == rectZT.t;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            result = 31 * result + w;
            result = 31 * result + h;
            result = 31 * result + z;
            result = 31 * result + t;
            return result;
        }
    }



}
