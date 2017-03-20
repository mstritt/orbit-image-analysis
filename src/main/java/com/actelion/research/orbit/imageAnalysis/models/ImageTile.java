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

import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ImageTile implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(ImageTile.class);
    public static final String tileSep = "&";
    private int rawDataFileId;
    private List<Point> tileList;
    private String model = null;
    public final static Map<String, OrbitModel> modelCache = new ConcurrentHashMap<>();

    public ImageTile(int rawDataFileId, List<Point> tileList, String model) {
        this.rawDataFileId = rawDataFileId;
        this.tileList = tileList;
        if (model != null && model.length() > 0 && model.contains(" "))
            throw new IllegalArgumentException("model cannot contain spaces");
        this.model = model;
    }

    public ImageTile(int rawDataFileId, List<Point> tileList) {
        this.rawDataFileId = rawDataFileId;
        this.tileList = tileList;
        this.model = null;
    }


    public ImageTile(String encoded) {
        String[] split = encoded.split("#", -1);
        this.rawDataFileId = Integer.parseInt(split[0]);
        String[] tiles = split[1].split(tileSep);
        tileList = new ArrayList<Point>(tiles.length);
        for (String tileStr : tiles) {
            if (tileStr != null && tileStr.length() > 0) {
                String[] xyStr = tileStr.split(",");
                tileList.add(new Point(Integer.parseInt(xyStr[0]), Integer.parseInt(xyStr[1])));
            }
        }
        if (split.length > 2 && split[2].trim().length() > 0) {
            this.model = split[2].trim();
        }
    }


    @Override
    public String toString() {
        StringBuilder encoded = new StringBuilder(rawDataFileId + "#");
        for (int i = 0; i < tileList.size(); i++) {
            Point tile = tileList.get(i);
            encoded.append(tile.x + "," + tile.y);
            if (i < tileList.size() - 1) encoded.append(tileSep);
        }
        if (model != null && model.length() > 0) {
            encoded.append("#" + model);
        }
        return encoded.toString();
    }


    public OrbitModel loadModel() throws IOException {
        if (modelCache.containsKey(getModel())) {
            logger.debug("reusing cached model");
            return modelCache.get(getModel()); // already cached
        }
        InputStream inStream = null;
        try {
            inStream = new ByteArrayInputStream(DALConfig.getScaleOut().getRemoteContextStore().readFromRemote(OrbitUtils.remoteNameSpace + "/" + getModel()));
            OrbitModel orbitModel = OrbitModel.LoadFromInputStream(inStream);
            modelCache.put(getModel(), orbitModel);
            return orbitModel;
        } finally {
            if (inStream != null) inStream.close();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageTile that = (ImageTile) o;

        if (rawDataFileId != that.rawDataFileId) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        return tileList != null ? tileList.equals(that.tileList) : that.tileList == null;

    }

    @Override
    public int hashCode() {
        int result = rawDataFileId;
        result = 31 * result + (tileList != null ? tileList.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }

    public int getRawDataFileId() {
        return rawDataFileId;
    }

    public void setRawDataFileId(int rawDataFileId) {
        this.rawDataFileId = rawDataFileId;
    }

    public List<Point> getTileList() {
        return tileList;
    }

    public void setTileList(List<Point> tileList) {
        this.tileList = tileList;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
