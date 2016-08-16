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

package com.actelion.research.orbit.imageAnalysis.imaging;

import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;

import javax.media.jai.BorderExtender;
import javax.media.jai.PlanarImage;
import java.awt.*;

public class IJManipulation implements IImageManipulation {

    private PlanarImage source;
    private Rectangle roi;
    private BorderExtender border;
    private PlugInFilter pluginFilter;
    private String params = "";

    public IJManipulation() {

    }

    public IJManipulation(PlanarImage source, Rectangle roi, BorderExtender border, PlugInFilter pluginFilter, String params) {
        this.source = source;
        this.roi = roi;
        this.border = border;
        this.pluginFilter = pluginFilter;
        this.params = params == null ? "" : params;
    }

    public void setParameter(PlanarImage source, Rectangle roi, BorderExtender border, PlugInFilter pluginFilter, String params) {
        this.source = source;
        this.roi = roi;
        this.border = border;
        this.pluginFilter = pluginFilter;
        this.params = params == null ? "" : params;
    }

    public PlanarImage process() {
        try {
            ImagePlus ip = ManipulationUtils.toImagePlus(source, roi, border);
            pluginFilter.setup(params, ip);
            pluginFilter.run(ip.getProcessor());
            return ManipulationUtils.toPlanarImage(ip.getProcessor());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
