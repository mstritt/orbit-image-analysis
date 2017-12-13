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
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.freedomotic.util.SerialClone.SerialClone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Builds a ROI based on the list of annotations.
 * Attention: getScaledInstance will always return the 100% instance!
 * Logic:
 * - Inclusion Annotations are completely covered.
 * - If one or more ROI annotations exist everything than ROI annotations will be excluded (exception: inclusion annotations)
 * - If no ROI annotations exist, the whole image is used as ROI
 * - Exclusion annotations are excluded (exception: inclusion annotations)
 */
public class ShapeAnnotationList implements IScaleableShape {
    private static final long serialVersionUID = 1L;
    private final static Logger logger = LoggerFactory.getLogger(ShapeAnnotationList.class);
    private Rectangle outerBounds = null;
    private List<Shape> exclList = new ArrayList<Shape>();
    private List<Shape> inclList = new ArrayList<Shape>();
    private Shape roi = null;
    private int numRoiAnnos = 0;
    private double scale = 100d;
    private transient ShapeAnnotationList scaledInstance = null;
    private int rdfId = 0;


    /**
     * Builds ROI using ROI,exclusion and inclusion annotations. ImageAnnotations are filtered, IScaleableShapes are scaled to 100%.
     * Outerbound is the union of ROI and all inclusion shapes.
     *
     * @param annotations
     * @param outerBounds
     */
    public ShapeAnnotationList(List<RawAnnotation> annotations, int annotationGroup, Rectangle outerBounds) {
        this(annotations, annotationGroup, outerBounds, false);
    }

    /**
     * Builds ROI using ROI,exclusion and inclusion annotations. ImageAnnotations are filtered, IScaleableShapes are scaled to 100%.
     * Outerbound is the union of ROI and all inclusion shapes.
     *
     * @param annotations
     * @param outerBounds
     */
    public ShapeAnnotationList(List<RawAnnotation> annotations, int annotationGroup, Rectangle outerBounds, boolean otherGroupROIAsExclusion) {
        this(annotations, annotationGroup, outerBounds, otherGroupROIAsExclusion, false);
    }

        /**
         * Builds ROI using ROI,exclusion and inclusion annotations. ImageAnnotations are filtered, IScaleableShapes are scaled to 100%.
         * Outerbound is the union of ROI and all inclusion shapes.
         *
         * @param annotations
         * @param outerBounds
         */
    public ShapeAnnotationList(List<RawAnnotation> annotations, int annotationGroup, Rectangle outerBounds, boolean otherGroupROIAsExclusion, boolean exclusionsForAllGroups) {
        this.outerBounds = outerBounds;
        if (outerBounds != null) {
            roi = outerBounds;
        }
        if (annotationGroup < 0) return;
        if (annotations != null && annotations.size() > 0) {
            List<Shape> roiAnnos = new ArrayList<Shape>();
            for (RawAnnotation anno : annotations) {
                if (anno.getRawAnnotationType() == RawAnnotation.ANNOTATION_TYPE_IMAGE) {
                    try {
                        ImageAnnotation ia = new ImageAnnotation(anno);
                        if (annotationGroup == 0 || annotationGroup == ia.getGroup()) {
                            if (ia.getSubType() != ImageAnnotation.SUBTYPE_NORMAL) {
                                Shape shape = ia.getShape().getShapeList().get(0);
                                if (shape instanceof IScaleableShape) {
                                    shape = ((IScaleableShape) shape).getScaledInstance(100d, new Point(0, 0));
                                    switch (ia.getSubType()) {
                                        case (ImageAnnotation.SUBTYPE_ROI): {
                                            roiAnnos.add(shape);
                                            break;
                                        }
                                        case (ImageAnnotation.SUBTYPE_EXCLUSION): {
                                            exclList.add(shape);
                                            break;
                                        }
                                        case (ImageAnnotation.SUBTYPE_INCLUSION): {
                                            inclList.add(shape);
                                            break;
                                        }
                                    }
                                }
                            }
                        } else {
                            // this allows to treat nested roi groups as exclusios of an outer roi group
                            if (otherGroupROIAsExclusion && annotationGroup != 0 && annotationGroup != ia.getGroup() && ia.getSubType() == ImageAnnotation.SUBTYPE_ROI) {
                                Shape shape = ia.getShape().getShapeList().get(0);
                                if (shape instanceof IScaleableShape) {
                                    shape = ((IScaleableShape) shape).getScaledInstance(100d, new Point(0, 0));
                                    exclList.add(shape);

                                }
                            }

                            // this allows to treat exclusions from other groups as exclusions for all groups
                            if (exclusionsForAllGroups && annotationGroup != 0 && annotationGroup != ia.getGroup() && ia.getSubType() == ImageAnnotation.SUBTYPE_EXCLUSION) {
                                Shape shape = ia.getShape().getShapeList().get(0);
                                if (shape instanceof IScaleableShape) {
                                    shape = ((IScaleableShape) shape).getScaledInstance(100d, new Point(0, 0));
                                    exclList.add(shape);

                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        //logger.logStackTrace(e.getStackTrace());
                        logger.error("cannot create ImageAnnotation", e);    // TODO  thrown for ELB0041-0661
                    }
                }
            }
            if (roiAnnos.size() > 0) {
                roi = new ShapeExtList(roiAnnos, outerBounds);
                numRoiAnnos = roiAnnos.size();
            }
            if (roi != null)
                this.outerBounds = roi.getBounds();
        }
        if (inclList.size() > 0) {
            for (Shape shape : inclList) {
                Rectangle re = shape.getBounds();
                if (this.outerBounds != null) {
                    if (!this.outerBounds.contains(re)) {
                        this.outerBounds = this.outerBounds.union(re);
                    }
                } else {
                    // 24.09.2014: if only incl and excl annotations but no ROI annotations available, leave bounds=null (outer bounds should be whole image)
                    //this.outerBounds = re;
                }
            }
        }

    }


    public ShapeAnnotationList(List<Shape> inclList, List<Shape> exclList, Shape roi, Rectangle outerBounds) {
        this.inclList = inclList;
        this.exclList = exclList;
        this.roi = roi;
        this.outerBounds = outerBounds;
        updateOuterbounds();
    }

    private void updateOuterbounds() {
        if (roi != null) {
            this.outerBounds = roi.getBounds();
        }
        if (inclList.size() > 0) {
            for (Shape shape : inclList) {
                Rectangle re = shape.getBounds();
                if (this.outerBounds != null) {
                    if (!this.outerBounds.contains(re)) {
                        this.outerBounds = this.outerBounds.union(re);
                    }
                } else {
                    this.outerBounds = re;
                }
            }
        }
    }

    public IScaleableShape getScaledInstance(double currentScale) {
        return getScaledInstance(currentScale, new Point(0, 0));
    }

    public IScaleableShape getScaledInstance(double currentScale, Point currentOffset) {
        //return this; // this pseudo ROI is always 100%

        if (Math.abs(scale - currentScale) <= OrbitUtils.EPSILON) return this;
        if ((scaledInstance != null) && (Math.abs(scaledInstance.getScale() - currentScale) <= OrbitUtils.EPSILON)) {
            return scaledInstance;
        }
        List<Shape> exclListScales = new ArrayList<Shape>(exclList.size());
        List<Shape> inclListScales = new ArrayList<Shape>(inclList.size());
        for (Shape s : exclList) {
            Shape scaled = s;
            if (s instanceof IScaleableShape) {
                scaled = ((IScaleableShape) s).getScaledInstance(currentScale, currentOffset);
            }
            exclListScales.add(scaled);
        }
        for (Shape s : inclList) {
            Shape scaled = s;
            if (s instanceof IScaleableShape) {
                scaled = ((IScaleableShape) s).getScaledInstance(currentScale, currentOffset);
            }
            inclListScales.add(scaled);
        }

        Shape roiScaled = roi;
        if (this.roi instanceof IScaleableShape) {
            roiScaled = ((IScaleableShape) this.roi).getScaledInstance(currentScale, currentOffset);
        }

        ShapeAnnotationList scaledShapeAnnotationList = new ShapeAnnotationList(inclListScales, exclListScales, roiScaled, null);
        scaledShapeAnnotationList.updateOuterbounds();
        if (roiScaled != null && roiScaled instanceof ShapeExtList) {
            scaledShapeAnnotationList.numRoiAnnos = ((ShapeExtList) roiScaled).getShapeList().size();
        }
        scaledInstance = scaledShapeAnnotationList;
        scaledInstance.setScale(currentScale);
        return scaledInstance;
    }

    public void move(double dx, double dy) {
        for (Shape shape : exclList) {
            if (shape instanceof IScaleableShape) {
                ((IScaleableShape) shape).move(dx, dy);
            }
        }
        for (Shape shape : inclList) {
            if (shape instanceof IScaleableShape) {
                ((IScaleableShape) shape).move(dx, dy);
            }
        }
        if (roi != null && roi instanceof IScaleableShape) {
            ((IScaleableShape) roi).move(dx, dy);
        }
        updateOuterbounds();
    }

    public void rotate(double angle, Point2D rotCenter) {
        for (Shape shape : exclList) {
            if (shape instanceof IScaleableShape) {
                ((IScaleableShape) shape).rotate(angle, rotCenter);
            }
        }
        for (Shape shape : inclList) {
            if (shape instanceof IScaleableShape) {
                ((IScaleableShape) shape).rotate(angle, rotCenter);
            }
        }
        if (roi != null && roi instanceof IScaleableShape) {
            ((IScaleableShape) roi).rotate(angle, rotCenter);
        }
        updateOuterbounds();
    }


    public boolean contains(Point2D paramPoint2D) {
        for (Shape inc : inclList) {
            if (inc.contains(paramPoint2D)) return true;
        }
        if (roi != null && !roi.contains(paramPoint2D)) return false;
        for (Shape excl : exclList) {
            if (excl.contains(paramPoint2D)) return false;
        }
        return true;
    }

    public boolean contains(Rectangle2D paramRectangle2D) {
        if (paramRectangle2D == null) return false;
        for (Shape inc : inclList) {
            if (inc.contains(paramRectangle2D)) return true;
        }
        if (roi != null && !roi.contains(paramRectangle2D)) return false;
        for (Shape excl : exclList) {
            if (excl.contains(paramRectangle2D)) return false;
        }
        return true;
    }


    public boolean contains(int x, int y) {
        for (Shape inc : inclList) {
            if (inc.contains(x, y)) return true;
        }
        if (roi != null && !roi.contains(x, y)) return false;
        for (Shape excl : exclList) {
            if (excl.contains(x, y)) return false;
        }
        return true;
    }

    public boolean contains(Point point) {
        if (point == null) return false;
        for (Shape inc : inclList) {
            if (inc.contains(point)) return true;
        }
        if (roi != null && !roi.contains(point)) return false;
        for (Shape excl : exclList) {
            if (excl.contains(point)) return false;
        }
        return true;
    }


    /**
     * Checks if the position is explicitly (with priority) included. This position should not be excluded by an exclusion model.
     *
     * @param x
     * @param y
     * @return
     */
    public boolean containsExplicit(double x, double y) {
        for (Shape inc : inclList) {
            if (inc.contains(x, y)) return true;
        }
        return false;
    }


    public boolean contains(double x, double y) {
        //if ((getBounds()!=null) && (!getBounds().contains(x,y))) return false;
        for (Shape inc : inclList) {
            if (inc.contains(x, y)) return true;
        }

//	System.out.println("--");
//		for (Shape s : ((ShapeExtList)roi).getShapeList()) {
//			if (s instanceof PolygonExt) {
//				System.out.println(((PolygonExt) s).npoints);
//			}
//		}

        if (roi != null && !roi.contains(x, y)) return false;
        for (Shape excl : exclList) {
            if (excl.contains(x, y)) return false;
        }
        return true;
    }


    public boolean contains(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
        for (Shape inc : inclList) {
            if (inc.contains(paramDouble1, paramDouble2, paramDouble3, paramDouble4)) return true;
        }
        if (roi != null && !roi.contains(paramDouble1, paramDouble2, paramDouble3, paramDouble4)) return false;
        for (Shape excl : exclList) {
            if (excl.contains(paramDouble1, paramDouble2, paramDouble3, paramDouble4)) return false;
        }
        return true;
    }

    public boolean intersects(Rectangle2D paramRectangle2D) {
        if (paramRectangle2D == null) return false;
        for (Shape inc : inclList) {
            if (inc.intersects(paramRectangle2D)) return true;
        }
        if (roi != null && !roi.intersects(paramRectangle2D)) return false;
        for (Shape excl : exclList) {
            if (excl.contains(paramRectangle2D)) return false;
        }
        return true;
    }

    public boolean intersects(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
        for (Shape inc : inclList) {
            if (inc.intersects(paramDouble1, paramDouble2, paramDouble3, paramDouble4)) return true;
        }
        if (roi != null && !roi.intersects(paramDouble1, paramDouble2, paramDouble3, paramDouble4)) return false;
        for (Shape excl : exclList) {
            if (excl.contains(paramDouble1, paramDouble2, paramDouble3, paramDouble4)) return false;
        }
        return true;
    }

    public Rectangle getBounds() {
        //if (roi!=null) return roi.getBounds();
        return outerBounds;
    }

    public Rectangle2D getBounds2D() {
        //if (roi!=null) return roi.getBounds2D();
        return outerBounds;
    }

    @Override
    public String toString() {
        return "ShapeAnnotationList with #ROI=" + numRoiAnnos + " #InclAnnos=" + inclList.size() + " #ExclAnnos=" + exclList.size() + " bounds=" + getBounds();
    }

    public PathIterator getPathIterator(AffineTransform at) {
        return outerBounds.getPathIterator(at);
    }

    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return outerBounds.getPathIterator(at, flatness);
    }

    public double getScale() {
        return this.scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
        for (Shape inc : inclList) {
            if (inc instanceof IScaleableShape) {
                ((IScaleableShape) inc).setScale(scale);
            }
        }
        for (Shape excl : exclList) {
            if (excl instanceof IScaleableShape) {
                ((IScaleableShape) excl).setScale(scale);
            }
        }
    }

    @Override
    public ShapeAnnotationList clone() {
        return SerialClone.clone(this);
    }

    @Override
    public int getRdfId() {
        return rdfId;
    }

    @Override
    public void setRdfId(int rdfId) {
        this.rdfId = rdfId;
    }

}
