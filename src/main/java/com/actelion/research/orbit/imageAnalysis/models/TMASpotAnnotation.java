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

package com.actelion.research.orbit.imageAnalysis.models;

import com.actelion.research.orbit.beans.RawAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.io.*;
import java.util.Date;


public class TMASpotAnnotation extends SpotAnnotation {

    private static final long serialVersionUID = 1L;
    private final static Logger logger = LoggerFactory.getLogger(TMASpotAnnotation.class);

    private int spotX = 0;
    private int spotY = 0;

    public TMASpotAnnotation() {
        super();
    }

    public TMASpotAnnotation(String text, ClassShape shape, int spotX, int spotY) {
        super(text, shape);
        this.spotX = spotX;
        this.spotY = spotY;
    }

    /**
     * Constructs a TMASpotAnnotation from a rawAnnotation. Reads color, classNum, x,y,w,h,scale,spotX,spotY from binary object.
     *
     * @param ra
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public TMASpotAnnotation(RawAnnotation ra) throws IOException, ClassNotFoundException {
        modifyDate = new Date(System.currentTimeMillis());
        setRawAnnotationType(getRawAnnotationType());
        shape = new ClassShape("annotation", Color.yellow, ClassShape.SHAPETYPE_ARC);
        setDescription(ra.getDescription());
        setRawAnnotationId(ra.getRawAnnotationId());
        setRawDataFileId(ra.getRawDataFileId());
        setRawAnnotationType(getRawAnnotationType());
        setUserId(ra.getUserId());
        ByteArrayInputStream is = new ByteArrayInputStream(ra.getData());
        ObjectInputStream ois = new ObjectInputStream(is);
        setColor(ois.readInt());
        shape.setColor(new Color(color));
        setClassNum(ois.readInt());
        double x = ois.readDouble();
        double y = ois.readDouble();
        double w = ois.readDouble();
        double h = ois.readDouble();
        double scale = ois.readDouble();
        setSpotX(ois.readInt());
        setSpotY(ois.readInt());
        Arc2DExt arc = new Arc2DExt(x, y, w, h, 0, 360, Arc2D.CHORD);
        arc.setScale(scale);
        shape.getShapeList().add(arc);
        ois.close();
        is.close();
    }


    /**
     * Writes properties into a binary array. Writes color, classNum, x,y,w,h,scale.
     */
    @Override
    public byte[] getData() {
        Arc2DExt arc = ((Arc2DExt) shape.getShapeList().get(0));
        data = null;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeInt(color);
            oos.writeInt(classNum);
            oos.writeDouble(arc.getX());
            oos.writeDouble(arc.getY());
            oos.writeDouble(arc.getWidth());
            oos.writeDouble(arc.getHeight());
            oos.writeDouble(arc.getScale());
            oos.writeInt(spotX);
            oos.writeInt(spotY);
            oos.flush();
            data = os.toByteArray();
            oos.close();
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("error writing tma spot data: " + ex.getMessage());
        }
        return data;
    }

    @Override
    public int getRawAnnotationType() {
        return ANNOTATION_TYPE_TMASPOT;
    }

    public int getSpotX() {
        return spotX;
    }

    public void setSpotX(int spotX) {
        this.spotX = spotX;
    }

    public int getSpotY() {
        return spotY;
    }

    public void setSpotY(int spotY) {
        this.spotY = spotY;
    }

    @Override
    public int getSpotType() {
        return SPOT_TYPE_GENERAL;
    }


}
