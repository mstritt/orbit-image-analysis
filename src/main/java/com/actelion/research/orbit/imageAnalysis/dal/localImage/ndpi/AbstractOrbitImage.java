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

package com.actelion.research.orbit.imageAnalysis.dal.localImage.ndpi;


import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.media.jai.PlanarImage;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;

public abstract class AbstractOrbitImage extends PlanarImage implements IOrbitImage {
	public boolean HCSMODE = false;
	public static boolean GRIDMODE = false;
	protected static final Logger logger = LoggerFactory.getLogger(AbstractOrbitImage.class);
	protected String filename;
	protected int rawDataFileId = -1;
	protected int numBands = 0;
	public final static int PHOTOMETRIC_YCbCr = 6;
	public final static int PHOTOMETRIC_RGB = 2;
	protected int photometric = PHOTOMETRIC_YCbCr;
	protected static final ColorModel rgbColorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB), new int[]{8,8,8}, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
	protected static final ColorModel grayColorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_GRAY), new int[]{8}, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
	protected int originalBitsPerSample = 8;
	protected boolean originalWasGrayScale = false;
	protected int level;
	protected int numLevels=0;
	private String channelName = null; // "" for RGB, otherwise the name
	private Float emissionWavelength = null;
	private int bandUsed = -1; // -1 all bands, >=0 specific band


	public AbstractOrbitImage(String filename) throws Exception {
		this(filename,0);
	}

	public AbstractOrbitImage(String filename, int level) throws Exception {
		 this(filename,level,true);
	}

	public AbstractOrbitImage(String filename, int level, boolean initSamplemodel) throws Exception {
		if (level>0 && numLevels>0 && level>=numLevels) throw new OrbitImageServletException("level >= numLevels");

		this.filename = filename.replaceAll("/data/orbit", "");
		this.level = level;

		// try to parse rdfId
		try {
			int idx1 = this.filename.lastIndexOf("/")+1;
			int idx2 =  this.filename.indexOf(".");
			String rdfIdStr = this.filename.substring(idx1,idx2);
			rawDataFileId = Integer.parseInt(rdfIdStr);
		} catch (Exception e) {
			//e.printStackTrace();
			logger.debug("warning: cannot parse rawDataFileId "+e.getMessage());
			rawDataFileId = -1;
		}

		readInfo(this.filename);
		if (initSamplemodel) {
			try { // must try-catch because this fails for TiledImageWriter
				getTile(0, 0); // the first getTile() call initializes the sampleModel (which is used in e.g. PlanarImage.getExtendedData() )
			} catch (Exception ex) {
				//if (!(this instanceof OrbitTiledImagePlanarImage))
				if (!this.getClass().getName().equals("OrbitTiledImagePlanarImage"))
					throw new OrbitImageServletException("Error reading image tile data");
			}
		}

	}


	protected synchronized boolean readInfo(String filename) throws Exception {
		String sb = readInfoString(filename);
		if (logger.isTraceEnabled()) {
			String[] split =filename.split("\\.");
			if (split!=null && split.length==2)
				logger.trace("info: " + sb);
		}
		if (sb==null) return false;
		if (sb.length()>0) {
			minX=0;
			minY=0;
			String[] kv = sb.toString().split(",");
			if (kv!=null && kv.length>0) {
				for (String s : kv)
				{
					String[] sa = s.split("=");
					if (sa!=null && sa.length==2) {
						String key = sa[0];
						String val = sa[1];
						try {
							if (key.equalsIgnoreCase("width")) {
								this.width = Integer.parseInt(val);
							} else
							if (key.equalsIgnoreCase("height")) {
								this.height = Integer.parseInt(val);
							} else
							if (key.equalsIgnoreCase("numBands")) {
								this.numBands = Integer.parseInt(val);
							} else
							if (key.equalsIgnoreCase("minX")) {
								this.minX = Integer.parseInt(val);
							} else
							if (key.equalsIgnoreCase("minY")) {
								this.minY = Integer.parseInt(val);
							} else
							if (key.equalsIgnoreCase("tileGridXOffset")) {
								this.tileGridXOffset = Integer.parseInt(val);
							} else
							if (key.equalsIgnoreCase("tileGridYOffset")) {
								this.tileGridYOffset = Integer.parseInt(val);
							} else
							if (key.equalsIgnoreCase("tileWidth")) {
								this.tileWidth = Integer.parseInt(val);
							} else
							if (key.equalsIgnoreCase("tileHeight")) {
								this.tileHeight = Integer.parseInt(val);
							} else
							if (key.equalsIgnoreCase("photometric")) {
								this.photometric = Integer.parseInt(val);
							}  else
							if (key.equalsIgnoreCase("bitsPerSample")) {
								this.originalBitsPerSample = Integer.parseInt(val);
							} else
							if (key.equalsIgnoreCase("pyramidLevels")) {
								this.numLevels = Integer.parseInt(val);
							}  else
							if (key.equalsIgnoreCase("channelName")) {
								this.channelName = val;
							}  else
							if (key.equalsIgnoreCase("emissionWavelength")) {
								this.emissionWavelength = Float.parseFloat(val);
								// define band used based on emission wavelength
								// wavelength = 0  Colour Image
								// 380 =< wavelength <= 490 Blue
								// 490 < wavelength <= 580 Green
								// 580 < wavelength <= 780 Red
								bandUsed = 0;
								if (380 < emissionWavelength && emissionWavelength <= 490) bandUsed = 2;
								else if (490 < emissionWavelength && emissionWavelength <= 580) bandUsed = 1;
								else if (580 < emissionWavelength && emissionWavelength <= 780) bandUsed = 0;
							}

						}
						catch (Exception e) {
							logger.error("error setting property: "+key+"",e);
						}
					}
				}

				// tileWidth and tileHeight now based on AparUtils.TILE_SIZE
				//this.tileWidth = AparUtils.TILE_SIZE;
				//this.tileHeight = AparUtils.TILE_SIZE;

				numBands = 3; // always RGB!!!
				if (numBands==1) this.colorModel = grayColorModel; else
				{
					this.colorModel = rgbColorModel;
				}
				this.sampleModel = colorModel.createCompatibleSampleModel(tileWidth, tileHeight);
			}
		}

		return true;
	}


	@Override
	public String getFilename() {
		return filename;
	}


	@Override
	public String toString() {
		String s = "filename="+filename+"; width="+width+"; height="+height+"; numBands="+numBands+"; tileWidth="+tileWidth+"; tileHeight="+tileHeight+"; maxTileX="+getMaxTileX()+"; maxTileY="+getMaxTileY()+"; colorModel="+colorModel.getColorSpace().getType()+"; sampleModel="+sampleModel+"; OriginalBitePerSample="+originalBitsPerSample;
		return s;
	}

	public void close() {

	}

	@Override
	public int getOriginalBitsPerSample() {
		return originalBitsPerSample;
	}

	@Override
	public boolean getOriginalWasGrayScale() {
		return originalWasGrayScale;
	}

	public int getLevel() {
		return level;
	}

	public int getNumLevels() {
		return numLevels;
	}

	public String getChannelName() {
		return channelName;
	}

	public Float getEmissionWavelength() {
		return emissionWavelength;
	}

	public int getBandUsed() {
		return bandUsed;
	}

	public void setBandUsed(int bandUsed) {
		this.bandUsed = bandUsed;
	}
}
