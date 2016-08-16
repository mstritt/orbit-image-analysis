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

package com.actelion.research.orbit.imageAnalysis.models;

import com.actelion.research.orbit.beans.RawAnnotation;

import java.awt.*;
import java.io.*;
import java.util.Date;

public abstract class SpotAnnotation extends ImageAnnotation {

    public static final int SPOT_TYPE_GENERAL = 0;
    public static final int SPOT_TYPE_RAREEVENT = 1;
    public static final int SPOT_TYPE_NERVE = 2;
    public static final int SPOT_TYPE_BOXCOUNT = 3;
    public static final int SPOT_TYPE_CELLDETECTION = 4;

    private static final long serialVersionUID = 1L;
    public static int CLASSNUM_UNDEFINED = -1;
    public static String LABEL_UNIDENTIFIED = "unidentified";
    protected int classNum = CLASSNUM_UNDEFINED; // -1 means undefined
    protected int proposedClassNum = CLASSNUM_UNDEFINED; // will not be persisted
    protected boolean isSelected = false; // for highlight spot in recognitionFrame

    public abstract int getSpotType();


    public SpotAnnotation() {
        super();
        setRawAnnotationType(getRawAnnotationType());
    }


    public SpotAnnotation(String text, ClassShape shape) {
        super(text, shape);
        setRawAnnotationType(getRawAnnotationType());
    }


    /**
     * Constructs a SpotAnnotation from a rawAnnotation. Reads color, classNum, shape from binary object.
     *
     * @param ra
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public SpotAnnotation(RawAnnotation ra) throws IOException, ClassNotFoundException {
        modifyDate = new Date(System.currentTimeMillis());
        setRawAnnotationType(getRawAnnotationType());
        shape = new ClassShape("annotation", Color.yellow, ClassShape.SHAPETYPE_POLYGONEXT);
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
        IScaleableShape sh = ((IScaleableShape) ois.readObject());
        shape.getShapeList().add(sh);
        if (sh instanceof Arc2DExt) shape.setShapeType(ClassShape.SHAPETYPE_ARC);
        if (sh instanceof RectangleExt) shape.setShapeType(ClassShape.SHAPETYPE_RECTANGLE);
        ois.close();
        is.close();
    }


    /**
     * Writes properties into a binary array. Writes color, classNum, shape.
     */
    @Override
    public byte[] getData() {
        IScaleableShape p = ((IScaleableShape) shape.getShapeList().get(0));
        //if (p instanceof PolygonExt) ((PolygonExt)p).setClosed(true); // Manuel 26.07.2012
        data = null;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeInt(color);
            oos.writeInt(classNum);
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
        return ANNOTATION_TYPE_SPOT;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof SpotAnnotation)) return false;
        return (hashCode() == obj.hashCode());
    }


    public int getClassNum() {
        return classNum;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }


    public int getProposedClassNum() {
        return proposedClassNum;
    }


    public void setProposedClassNum(int proposedClassNum) {
        this.proposedClassNum = proposedClassNum;
    }


    public boolean isSelected() {
        return isSelected;
    }


    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public ImageAnnotation toImageAnnotation() {
        ImageAnnotation ia = new ImageAnnotation(description, shape);
        ia.setColor(color);
        ia.setModifyDate(modifyDate);
        ia.setRawDataFileId(rawDataFileId);
        ia.setUserId(userId);
        return ia;
    }


}
