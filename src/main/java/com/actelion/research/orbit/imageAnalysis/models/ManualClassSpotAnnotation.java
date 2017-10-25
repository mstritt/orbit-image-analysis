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

package com.actelion.research.orbit.imageAnalysis.models;

import com.actelion.research.orbit.beans.RawAnnotation;

import java.awt.*;
import java.io.*;
import java.util.Date;

public class ManualClassSpotAnnotation extends SpotAnnotation {

    private static final long serialVersionUID = 1L;
    private double squareMilliMeter = 0d;

    public ManualClassSpotAnnotation() {
        super();
        setRawAnnotationType(RawAnnotation.ANNOTATION_TYPE_MANUALCLASS);
    }


    public ManualClassSpotAnnotation(String text, ClassShape shape) {
        super(text, shape);
        setRawAnnotationType(RawAnnotation.ANNOTATION_TYPE_MANUALCLASS);
    }


    /**
     * Constructs a ManualClassSpotAnnotation from a rawAnnotation. Reads color, classNum, squareMuMeter, shape from binary object.
     *
     * @param ra
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public ManualClassSpotAnnotation(RawAnnotation ra) throws IOException, ClassNotFoundException {
        modifyDate = new Date(System.currentTimeMillis());
        setRawAnnotationType(ANNOTATION_TYPE_MANUALCLASS);
        shape = new ClassShape("annotation", Color.yellow, ClassShape.SHAPETYPE_POLYGONEXT);
        setDescription(ra.getDescription());
        setRawAnnotationId(ra.getRawAnnotationId());
        setRawDataFileId(ra.getRawDataFileId());
        setUserId(ra.getUserId());
        ByteArrayInputStream is = new ByteArrayInputStream(ra.getData());
        ObjectInputStream ois = new ObjectInputStream(is);
        setColor(ois.readInt());
        shape.setColor(new Color(color));
        setClassNum(ois.readInt());
        setSquareMilliMeter(ois.readDouble());
        shape.getShapeList().add(((PolygonExt) ois.readObject()));
        ois.close();
        is.close();
    }


    /**
     * Writes properties into a binary array. Writes color, classNum, squareMeMeter, shape.
     */
    @Override
    public byte[] getData() {
        PolygonExt p = ((PolygonExt) shape.getShapeList().get(0));
        p.setClosed(true);
        data = null;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeInt(color);
            oos.writeInt(classNum);
            oos.writeDouble(squareMilliMeter);
            oos.writeObject(p);
            oos.flush();
            data = os.toByteArray();
            oos.close();
            os.close();
        } catch (Exception ex) {
        }
        return data;
    }

    @Override
    public int getRawAnnotationType() {
        return ANNOTATION_TYPE_MANUALCLASS;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof ManualClassSpotAnnotation)) return false;
        return (hashCode() == obj.hashCode());
    }


    public double getSquareMilliMeter() {
        return squareMilliMeter;
    }

    public void setSquareMilliMeter(double squareMilliMeter) {
        this.squareMilliMeter = squareMilliMeter;
    }


    @Override
    public int getSpotType() {
        return SPOT_TYPE_GENERAL;
    }

}
