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

package com.actelion.research.orbit.imageAnalysis.models;

import java.awt.*;
import java.io.Serializable;


public class SpotPos implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    private Point pos = null;
    private Point spot = null;
    private boolean selected = false;
    private String name = "";

    public SpotPos(Point pos, Point spot, String name) {
        this.pos = pos;
        this.spot = spot;
        this.name = name;
    }

    public SpotPos(Point pos, Point spot) {
        this.pos = pos;
        this.spot = spot;
    }

    public Point getPos() {
        return pos;
    }

    public void setPos(Point pos) {
        this.pos = pos;
    }

    public Point getSpot() {
        return spot;
    }

    public void setSpot(Point spot) {
        this.spot = spot;
    }


    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if (spot != null && pos != null) return pos.toString() + "->" + spot.toString() + ": " + name;
        else if (name != null && name.length() > 0) return name;
        else return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof SpotPos)) return false;
        SpotPos sp = (SpotPos) obj;
        return this.pos.equals(sp.getPos()) && this.spot.equals(sp.getSpot());
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

}	