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
    MIHCComputation mihc = new MIHCComputation();
    private Array2DRowRealMatrix invMatrix;
    private double[][] matrix;
    private double[] gains;
    private double[] gainNorm;
    private RectZT currentRect;
    private BufferedImage[] unmixedChannels;
    private String[] channelNames = null;
    private String[] matrixChannelNames;
    private boolean[] channelIndependent;
    private int[] channelMap;

    public MultiplexImageReader(final BufferedImageReader r, final String[] matrixChannelNames, final double[][] matrix, final double[] gainNorm, double[] gains) {
        super(r);
        if (r.getCurrentFile()!=null) throw new IllegalStateException("reader r must be closed, call setId after wrapping");
        this.matrix = matrix;
        this.gains = gains;
        this.gainNorm = gainNorm;
        this.matrixChannelNames = matrixChannelNames;
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
            channelMap = new int[getSizeC()];
            int mapId=0;
            for (int c = 0; c < getSizeC(); c++) {
                String channelName = meta.getChannelName(getSeries(), c);
                if (channelName == null) {
                    channelName = "Channel" + c;
                }
                channelNames[c] = channelName;
                if (matrixChannelNamesHash.contains(channelName.toLowerCase().trim())) {
                    channelIndependent[c] = false;
                    channelMap[c] = mapId++;
                }
                else {
                    channelIndependent[c] = true;
                }
                logger.info("channel name " + c + ": " + channelName);
            }
            RealMatrix rm = MatrixUtils.createRealMatrix(matrix);
            int[] selectedEntries = new int[mapId]; // number of dependent channels
            double[] gainNormSelected = new double[matrix.length];
            double[] gainsSelected = new double[matrix.length];
            int n=0;
            for (int c=0; c<channelNames.length; c++) {
                if (!channelIndependent[c]) {
                    for (int i=0; i<matrixChannelNames.length; i++) {
                        if (matrixChannelNames[i].equals(channelNames[c])) {
                            selectedEntries[n] = i;
                            gainNormSelected[n] = gainNorm[i];
                            gainsSelected[n] = gains[i];
                            n++;
                        }
                    }
                }
            }
            RealMatrix rmSub = rm.getSubMatrix(selectedEntries,selectedEntries);  //TODO: check with different channel order
            RealMatrix rmInv = MatrixUtils.inverse(rmSub);

            // find lowest gain and calculate others relative to that
            logger.info("gain gamma: "+Arrays.toString(gainNormSelected)+"  image gains: "+Arrays.toString(gains));
            double[] gainsInv = new double[gainsSelected.length];
            for (int i=0; i<gainsInv.length; i++) gainsInv[i] = 1d/(gainsSelected[i]/gainNormSelected[i]);
            RealMatrix GiiInv = MatrixUtils.createRealDiagonalMatrix(gainsInv);
            Array2DRowRealMatrix rmInvNorm = new Array2DRowRealMatrix(rmInv.multiply(GiiInv).getData());
            this.invMatrix = rmInvNorm;

        } catch (DependencyException e) {
            throw new FormatException(e);
        } catch (ServiceException e) {
            throw new FormatException(e);
        }
        
    }

    @Override
    public BufferedImage openImage(int no, int x, int y, int w, int h) throws FormatException, IOException {
        int sizeC = getSizeC();
        int sizeCMultiplex = sizeC;
        int[] zct = getZCTCoords(no);
        int z = zct[0];
        int chan = zct[1];
        int t = zct[2];
        RectZT rect = new RectZT(x,y,w,h,z,t);
        if (currentRect==null || !currentRect.equals(rect)) {
            System.out.println("cache failed - loading");
            openUnmixedImages(no,x,y,w,h); // unmix all channels at once
        }
        return unmixedChannels[chan];
    }

    public BufferedImage[] openUnmixedImages(int no, int x, int y, int w, int h) throws FormatException, IOException {
        int sizeC = getSizeC();
        int sizeCMultiplex = sizeC;     // for now, sizeC=sizeCMultiplex
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
            bi[c] = new BufferedImage(ori.getColorModel(), ori.getRaster().createCompatibleWritableRaster(0, 0, w, h), ori.isAlphaPremultiplied(), null);
            raster[c] = bi[c].getRaster();
        }
        double[] measurements = new double[sizeC];
        double[] out = new double[sizeCMultiplex];
        for (int ix=ori.getMinX(); ix<ori.getMinX()+ori.getWidth(); ix++)
            for (int iy=ori.getMinY(); iy<ori.getMinY()+ori.getHeight(); iy++) {
                for (int c=0; c<sizeCMultiplex; c++) {
                    // todo: map c to multiplex nr
                    measurements[c] = channels[c].getRaster().getSampleDouble(ix,iy,0); //getSampleDouble?   only 1 banded rasters allowed here
                }
                mihc.unmix(invMatrix,measurements,out);
                for (int c=0; c<sizeCMultiplex; c++) {
                    if (out[c]>255) out[c] = 255d;        // TODO: adjust for 16bit!!!
                    if (out[c]<0) out[c] = 0d;
                    raster[c].setSample(ix, iy, 0, out[c]);
                }
            }

        unmixedChannels = bi;
        currentRect = new RectZT(x,y,w,h,z,t);

        return bi;
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
