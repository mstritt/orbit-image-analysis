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
import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * An OrbitAnnotation contains a shape (classShape) and a text (description) of that annotation.
 */
public class ImageAnnotation extends RawAnnotation {
    private static final Logger logger = LoggerFactory.getLogger(ImageAnnotation.class);

    public static final int SUBTYPE_NORMAL = 0;
    public static final int SUBTYPE_INCLUSION = 1;
    public static final int SUBTYPE_EXCLUSION = 2;
    public static final int SUBTYPE_ROI = 3;

    private static final long serialVersionUID = 1L;
    protected ClassShape shape = new ClassShape();
    protected int color = Color.yellow.getRGB();
    protected int subType = SUBTYPE_NORMAL;
    protected int group = 1; // for different scenarios annotations can be filtered by groupID, default is 1
    protected transient boolean selected = false;

    public ImageAnnotation() {
        super();
        setRawAnnotationType(ANNOTATION_TYPE_IMAGE);
        shape = new ClassShape("annotation", Color.yellow, ClassShape.SHAPETYPE_POLYGONEXT);
    }

    public ImageAnnotation(String name, IScaleableShape scaleableShape, int subType, Color color) {
        super();
        setRawAnnotationType(ANNOTATION_TYPE_IMAGE);
        description = name;
        int type = ClassShape.SHAPETYPE_POLYGONEXT;
        if (scaleableShape instanceof RectangleExt) type = ClassShape.SHAPETYPE_RECTANGLE;
        if (scaleableShape instanceof Arc2DExt) type = ClassShape.SHAPETYPE_ARC;
        shape = new ClassShape(name, color, type);
        shape.getShapeList().add(scaleableShape);
        setSubType(subType);
    }

    /**
     * constructs a ImageAnnotation from a rawAnnotation
     *
     * @param ra RawAnnotation to be converted to Image Annotation
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public ImageAnnotation(RawAnnotation ra) throws IOException, ClassNotFoundException {
        super();
        setRawAnnotationType(ANNOTATION_TYPE_IMAGE);
        shape = new ClassShape("annotation", Color.yellow, ClassShape.SHAPETYPE_POLYGONEXT);
        setDescription(ra.getDescription());
        setRawAnnotationId(ra.getRawAnnotationId());
        setRawDataFileId(ra.getRawDataFileId());
        setUserId(ra.getUserId());
        ByteArrayInputStream is = new ByteArrayInputStream(ra.getData());
        ObjectInputStream ois = new ObjectInputStream(is);
        setColor(ois.readInt());
        shape.setColor(new Color(color));
        shape.getShapeList().add(((IScaleableShape) ois.readObject()));
        try {
            setSubType(ois.readInt());
            setGroup(ois.readInt());
        } catch (IOException e) {
            logger.error("Do nothing, this will happen for earlier versions which don't have a subType or group");
            logger.error(e.getLocalizedMessage());
        }
        ois.close();
        is.close();
        if (group == 0) group = 1; // default group is 1, 0 does not exist
    }

    public ImageAnnotation(String text, ClassShape shape) {
        super();
        setRawAnnotationType(ANNOTATION_TYPE_IMAGE);
        this.description = text;
        this.shape = shape;
    }

    public static List<ImageAnnotation> convertToImageAnnotations(List<RawAnnotation> rawAnnotations) {
        if (rawAnnotations == null) return null;
        List<ImageAnnotation> iaList = new ArrayList<ImageAnnotation>(rawAnnotations.size());
        try {
            for (RawAnnotation ra : rawAnnotations) {
                if (ra.getRawAnnotationType() == RawAnnotation.ANNOTATION_TYPE_IMAGE) {
                    ImageAnnotation ia = new ImageAnnotation(ra);
                    iaList.add(ia);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            logger.error(e.getLocalizedMessage());
        }
        return iaList;
    }

    public Shape getFirstShape() {
        return shape.getShapeList().get(0);
    }

    public ClassShape getShape() {
        return shape;
    }


    public void setShape(ClassShape shape) {
        this.shape = shape;
    }

    /**
     * sRGB color in int encoding
     *
     * @return sRGB color in int encoding
     */
    public int getColor() {
        return color;
    }

    /**
     * sRGB color in int encoding
     *
     * @param color sRGB color in int encoding
     */
    public void setColor(int color) {
        this.color = color;
        if (getShape() != null) {
            getShape().setColor(new Color(color));
        }
    }


    public int getSubType() {
        return subType;
    }

    public void setSubType(int subType) {
        this.subType = subType;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public byte[] getData() {
        IScaleableShape p = ((IScaleableShape) shape.getShapeList().get(0));
        //p.setClosed(true);
        data = null;
        ByteArrayOutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            os = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(os);
            oos.writeInt(color);
            oos.writeObject(p);
            oos.writeInt(subType);
            oos.writeInt(group);
            oos.flush();
            oos.close();
            data = os.toByteArray();
        } catch (Exception ex) {
        } finally {
            if (oos != null) try {
                oos.close();
            } catch (IOException e) {
            }
            if (os != null) try {
                os.close();
            } catch (IOException e) {
            }
        }
        return data;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equalsInherited(o)) return false;

        ImageAnnotation that = (ImageAnnotation) o;

        if (color != that.color) return false;
        if (group != that.group) return false;
        if (subType != that.subType) return false;
        if (description != null && !description.equals(that.getDescription())) return false;
        return shape != null ? shape.equals(that.shape) : that.shape == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCodeInherited();
        result = 31 * result + (shape != null ? shape.hashCode() : 0);
        result = 31 * result + color;
        result = 31 * result + subType;
        result = 31 * result + group;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }


    public String getSubTypeName() {
        return ImageAnnotation.getSubTypeName(subType);
    }

    public static String getSubTypeName(int subType) {
        switch (subType) {
            case SUBTYPE_NORMAL: {
                return "normal";
            }
            case SUBTYPE_ROI: {
                return "ROI";
            }
            case SUBTYPE_INCLUSION: {
                return "inclusion";
            }
            case SUBTYPE_EXCLUSION: {
                return "exclusion";
            }
            default: {
                return "normal";
            }
        }
    }

    public static int getSubTypeNum(String name) {
        if (name.equalsIgnoreCase("normal")) return SUBTYPE_NORMAL;
        else if (name.equalsIgnoreCase("ROI")) return SUBTYPE_ROI;
        else if (name.equalsIgnoreCase("inclusion")) return SUBTYPE_INCLUSION;
        else if (name.equalsIgnoreCase("exclusion")) return SUBTYPE_EXCLUSION;
        else
            return SUBTYPE_NORMAL;
    }


    @Override
    public int getRawAnnotationType() {
        return ANNOTATION_TYPE_IMAGE;
    }

    @Override
    public String toString() {
        return "ImageAnnotation [hash=" + hashCode() + ", shape=" + shape + ", color=" + color + ", subType=" + getSubTypeName() + ", group=" + group + ", rawAnnotationId=" + rawAnnotationId + ", rawDataFileId=" + rawDataFileId
                + ", rawAnnotationType=" + rawAnnotationType + ", description=" + description + ", userId=" + userId + ", modifyDate=" + modifyDate + "]";
    }

    @Override
    public ImageAnnotation clone() {
        return SerializationUtils.clone(this);
    }


    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public static class SubType {
        private int subType = SUBTYPE_NORMAL;

        public SubType(int subType) {
            this.subType = subType;
        }

        public int getSubType() {
            return subType;
        }

        public void setSubType(int subType) {
            this.subType = subType;
        }

        @Override
        public String toString() {
            return ImageAnnotation.getSubTypeName(subType);
        }
    }


}
