/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2016 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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

import java.awt.*;
import java.util.Arrays;

public class PointAndName extends Point {
    private static final long serialVersionUID = 1L;
    private String name = "";
    private int x;
    private int y;
    private double gamma;
    private double contrast;
    private double brightness;
    private int blur;
    private double redAdjust;
    private double greenAdjust;
    private double blueAdjust;
    private OrbitTiledImage2 redChannel;
    private OrbitTiledImage2 greenChannel;
    private OrbitTiledImage2 blueChannel;
    private OrbitTiledImage2 overlayChannel;
    private boolean redActive;
    private boolean greenActive;
    private boolean blueActive;
    private int deconvChannel;
    private String deconvName;
    private float[] channelContributions;

    public PointAndName(int x, int y, String name, double gamma, double contrast, double brightness, int blur, double redAdjust, double greenAdjust, double blueAdjust, OrbitTiledImage2 redChannel, OrbitTiledImage2 greenChannel, OrbitTiledImage2 blueChannel, OrbitTiledImage2 overlayChannel, boolean redActive, boolean greenActive, boolean blueActive, int deconvChannel, String deconvName, float[] channelContributions) {
        this.x = x;
        this.y = y;
        super.x = x;
        super.y = y;
        this.name = name;
        this.gamma = gamma;
        this.contrast = contrast;
        this.brightness = brightness;
        this.blur = blur;
        this.redAdjust = redAdjust;
        this.greenAdjust = greenAdjust;
        this.blueAdjust = blueAdjust;
        this.redChannel = redChannel;
        this.greenChannel = greenChannel;
        this.blueChannel = blueChannel;
        this.overlayChannel = overlayChannel;
        this.redActive = redActive;
        this.greenActive = greenActive;
        this.blueActive = blueActive;
        this.deconvChannel = deconvChannel;
        this.deconvName = deconvName;
        this.channelContributions = channelContributions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PointAndName that = (PointAndName) o;

        if (blueActive != that.blueActive) return false;
        if (java.lang.Double.compare(that.blueAdjust, blueAdjust) != 0) return false;
        if (blur != that.blur) return false;
        if (java.lang.Double.compare(that.brightness, brightness) != 0) return false;
        if (java.lang.Double.compare(that.contrast, contrast) != 0) return false;
        if (deconvChannel != that.deconvChannel) return false;
        if (java.lang.Double.compare(that.gamma, gamma) != 0) return false;
        if (greenActive != that.greenActive) return false;
        if (java.lang.Double.compare(that.greenAdjust, greenAdjust) != 0) return false;
        if (redActive != that.redActive) return false;
        if (java.lang.Double.compare(that.redAdjust, redAdjust) != 0) return false;
        if (x != that.x) return false;
        if (y != that.y) return false;
        if (blueChannel != null ? !blueChannel.equals(that.blueChannel) : that.blueChannel != null) return false;
        if (deconvName != null ? !deconvName.equals(that.deconvName) : that.deconvName != null) return false;
        if (greenChannel != null ? !greenChannel.equals(that.greenChannel) : that.greenChannel != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (overlayChannel != null ? !overlayChannel.equals(that.overlayChannel) : that.overlayChannel != null)
            return false;
        if (redChannel != null ? !redChannel.equals(that.redChannel) : that.redChannel != null)
            return false;

        return Arrays.equals(channelContributions, that.channelContributions);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + x;
        result = 31 * result + y;
        temp = java.lang.Double.doubleToLongBits(gamma);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = java.lang.Double.doubleToLongBits(contrast);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = java.lang.Double.doubleToLongBits(brightness);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + blur;
        temp = java.lang.Double.doubleToLongBits(redAdjust);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = java.lang.Double.doubleToLongBits(greenAdjust);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = java.lang.Double.doubleToLongBits(blueAdjust);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (redChannel != null ? redChannel.hashCode() : 0);
        result = 31 * result + (greenChannel != null ? greenChannel.hashCode() : 0);
        result = 31 * result + (blueChannel != null ? blueChannel.hashCode() : 0);
        result = 31 * result + (overlayChannel != null ? overlayChannel.hashCode() : 0);
        result = 31 * result + (redActive ? 1 : 0);
        result = 31 * result + (greenActive ? 1 : 0);
        result = 31 * result + (blueActive ? 1 : 0);
        result = 31 * result + deconvChannel;
        result = 31 * result + (deconvName != null ? deconvName.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(channelContributions);
        return result;
    }
}
