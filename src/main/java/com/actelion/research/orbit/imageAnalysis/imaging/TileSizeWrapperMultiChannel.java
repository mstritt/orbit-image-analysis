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

package com.actelion.research.orbit.imageAnalysis.imaging;

import com.actelion.research.orbit.dal.IOrbitImageMultiChannel;

import java.awt.image.Raster;

public class TileSizeWrapperMultiChannel extends TileSizeWrapper implements IOrbitImageMultiChannel {


    public TileSizeWrapperMultiChannel(IOrbitImageMultiChannel image, int tileWidth, int tileHeight) {
        super(image, tileWidth, tileHeight);
    }

    @Override
    public Raster getTileData(int tileX, int tileY, float[] channelContributions, boolean analysis, float[] analysisHues) {
        System.out.println("TSWrap: "+tileX+" x "+tileY);
        return ((IOrbitImageMultiChannel)image).getTileData(tileX,tileY,channelContributions,analysis,analysisHues);
    }

    @Override
    public String[] getChannelNames() {
        return ((IOrbitImageMultiChannel)image).getChannelNames();
    }

    @Override
    public void setChannelNames(String[] channelNames) {
        ((IOrbitImageMultiChannel)image).setChannelNames(channelNames);
    }

    @Override
    public float[] getChannelContributions() {
        return ((IOrbitImageMultiChannel)image).getChannelContributions();
    }

    @Override
    public void setChannelContributions(float[] contributions) {
        ((IOrbitImageMultiChannel)image).setChannelContributions(contributions);
    }

    @Override
    public float[] getHues() {
        return ((IOrbitImageMultiChannel)image).getHues();
    }

    @Override
    public void setHues(float[] hues) {
        ((IOrbitImageMultiChannel)image).setHues(hues);
    }
}
