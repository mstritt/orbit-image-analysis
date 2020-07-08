package com.actelion.research.orbit.imageAnalysis.deeplearning.DeepLabV2Resnet101;

import com.actelion.research.orbit.imageAnalysis.deeplearning.AbstractSegment;
import com.actelion.research.orbit.imageAnalysis.deeplearning.DLHelpers;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.models.PolygonExt;
import com.actelion.research.orbit.imageAnalysis.models.SegmentationResult;
import com.actelion.research.orbit.imageAnalysis.tasks.ExclusionMapGen;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImageIOrbitImage;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.imageAnalysis.utils.PolygonMetrics;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import javax.swing.text.Segment;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DLR101Segment extends AbstractSegment<DLR101Detections, DLR101SegmentationSettings> {

    private final Session s;

    public DLR101Segment(File modelPB, DLR101SegmentationSettings settings) {
        super(settings);
        this.s = DLHelpers.buildSession(modelPB.getAbsolutePath());
    }

    @Override
    public DLR101Detections segmentationImplementation(OrbitModel segModel,
                                                       OrbitTiledImageIOrbitImage orbitImage,
                                                       Point tile,
                                                       ExclusionMapGen exclusionMapGen,
                                                       Shape roiDef) {
        Point tileOffset = new Point(orbitImage.tileXToX(tile.x), orbitImage.tileYToY(tile.y));

        DLR101Detections detections = segmentTile(tile.x, tile.y, orbitImage, segModel, false, tileOffset);
        //return detections;
        if (segmentationSettings.isSegmentationRefinement()) {
            try {
                return segmentationRefinement(detections, segModel, orbitImage, exclusionMapGen, roiDef, tile);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return detections;
        } else if (!(segmentationSettings.isSegmentationRefinement())) {
            return detections;
        }
        return detections;
    }

    /**
     * Inference is often done on multiple tiles. Boundary effects mean that e.g. one object is segmented as two
     * touching objects. This method refines those detections by applying the detections to tiles centered on the
     * detection.
     * @param detections The initial detections.
     * @param segModel The segmentation model used to refine the detections.
     * @param orbitImage The whole slide image (tiles).
     * @param exclusionMapGen The exclusion map.
     * @param roiDef The ROI used (exclusions and inclusions).
     * @param tile The coordinates (tile number, not px) of the tile being analysed.
     * @return The refined detections.
     * @throws Exception
     */
    private DLR101Detections segmentationRefinement(DLR101Detections detections,
                                                    OrbitModel segModel,
                                                    OrbitTiledImageIOrbitImage orbitImage,
                                                    ExclusionMapGen exclusionMapGen,
                                                    Shape roiDef,
                                                    Point tile) throws Exception {

        int tileSize = segmentationSettings.getTrainingImageTileWidth();
        int halfTileSize = tileSize/2;
        int minX = orbitImage.tileXToX(tile.x);
        int minY = orbitImage.tileYToY(tile.y);

        int i = 0;
        for (Shape segShape : detections.getSegmentationResult().getShapeList()) {
            PolygonExt scaleShape = (PolygonExt) segShape;
            PolygonMetrics polyMetrics = new PolygonMetrics(scaleShape);
            scaleShape = scaleShape.scale(200d, polyMetrics.getCenter());
            scaleShape.translate(minX, minY);
            Point2D center = polyMetrics.getCenter();
            scaleShape.translate((int) center.getX(), (int) center.getY());
            PolygonMetrics pm2 = new PolygonMetrics(scaleShape);
            center = pm2.getCenter();

            //segmentationShapes.add(scaleShape);     // enable?

            // re-segment
            int startx = (int) (center.getX() - halfTileSize);
            int starty = (int) (center.getY() - halfTileSize);
            if (startx < 0) startx = 0;
            if (starty < 0) starty = 0;
            if (startx + tileSize >= orbitImage.getWidth()) startx = orbitImage.getWidth() - (tileSize+1);
            if (starty + tileSize >= orbitImage.getHeight()) starty = orbitImage.getHeight() - (tileSize+1);
            Rectangle rect = new Rectangle(startx, starty, tileSize, tileSize);
            Raster rasterCenter = orbitImage.getData(rect);
            //SegmentationResult segCenter = com.actelion.research.orbit.imageAnalysis.deeplearning.DLSegment.segmentRaster(rasterCenter, orbitImage, s, segModel, false);
            BufferedImage bim = maskRaster(rasterCenter, orbitImage, false);
            SegmentationResult segCenter = getSegmentationResult(segModel, bim);

            if (segCenter.getObjectCount() > 0) {
                // find center shape
                // TODO: What is this number?
                Point centerP = new Point(256, 256);
                Shape centerShape = segCenter.getShapeList().get(0);
                double dist = tileSize;
                for (Shape centeredDetection : segCenter.getShapeList()) {
                    PolygonMetrics pm = new PolygonMetrics((Polygon) centeredDetection);
                    double d = pm.getCenter().distance(centerP);
                    if (d < dist) {
                        centerShape = centeredDetection;
                        dist = d;
                    }
                }
                PolygonExt centeredContour = (PolygonExt) centerShape;
                PolygonMetrics polyMetrics2 = new PolygonMetrics(centeredContour);
                //TODO: Probably needs scale factor fixing?
                centeredContour = centeredContour.scale(200d, polyMetrics2.getCenter());
                centeredContour.translate(startx, starty);
                Point2D center2 = polyMetrics2.getCenter();
                centeredContour.translate((int) center2.getX(), (int) center2.getY());

                PolygonMetrics pm = new PolygonMetrics(centeredContour);
                Point2D centerScaled = pm.getCenter();
                if (OrbitUtils.isInROI((int) centerScaled.getX(), (int) centerScaled.getY(), roiDef, exclusionMapGen)) {
                    //segmentationShapes.add(scaleShape2);
                    // TODO: Need to shift the 'centered' contour so that it is in the frame of the original
                    // detection. Also need to check whether in the tile frame or the image frame (x,y px).
                    PolygonExt originalContour = new PolygonExt(scaleShape); //(PolygonExt) segShape;
                    originalContour.setClosed(true);
                    originalContour.translate(-startx, -starty);
                    PolygonMetrics originalMetrics = new PolygonMetrics(originalContour);

                    PolygonExt expandOriginal = new PolygonExt(scaleShape); //(PolygonExt) segShape;
                    expandOriginal.setClosed(true);
                    expandOriginal.translate(-startx, -starty);
                    PolygonMetrics expandOriginalMetrics = new PolygonMetrics(expandOriginal);
                    expandOriginal = expandOriginal.scale(120d, expandOriginalMetrics.getCenter());

                    PolygonExt centeredContourCopy = new PolygonExt(centeredContour);
                    centeredContourCopy.setClosed(true);
                    centeredContourCopy.translate(-startx, -starty);
//                    PolygonMetrics centeredContourCopyMetrics = new PolygonMetrics(centeredContourCopy);

                    //expandOriginal.translate(startx, starty);
                    PolygonExt expandCentered = (PolygonExt) centerShape;
                    expandCentered.setClosed(true);
                    expandCentered.translate( (int) center2.getX(),  (int) center2.getY());
                    expandCentered = expandCentered.scale(200d, polyMetrics2.getCenter());
                    PolygonMetrics expandCenteredMetrics = new PolygonMetrics(expandCentered);
                    expandCentered = expandCentered.scale(120d, expandCenteredMetrics.getCenter());

                    originalContour.getBounds();
                    expandOriginal.getBounds();

                    centeredContourCopy.getBounds();
                    expandCentered.getBounds();

                    WritableRaster tileRaster = (WritableRaster) rasterCenter.createTranslatedChild(0, 0);
                    BufferedImage ori = new BufferedImage(orbitImage.getColorModel(), tileRaster, false, null);

                    Graphics2D roiG = ori.createGraphics();
                    roiG.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    roiG.drawImage(ori,rect.x,rect.y,rect.width,rect.height,null);

                    roiG.setColor(Color.red);
                    roiG.drawPolygon(originalContour);
                    roiG.setColor(Color.green);
                    roiG.drawPolygon(expandCentered);

                    roiG.setColor(Color.yellow);
                    roiG.drawPolygon(expandOriginal);
                    roiG.setColor(Color.blue);
                    roiG.drawPolygon(centeredContourCopy);

                    roiG.setColor(Color.black);
                    roiG.dispose();

                    if (expandCentered.contains(originalContour)) {
                        PolygonMetrics centeredMetrics = new PolygonMetrics(centeredContour);

                        // TODO: Expand original contour and compare against centered.
                        if (expandOriginal.contains(centeredContourCopy)) {
                            // if works both ways take the biggest.
                            if (centeredMetrics.getArea() > originalMetrics.getArea()) {
                                detections.addDetection(centeredContour, 1, tile);
                                detections.removeDetection(i);
                                List<PolygonExt> dup = detections.getContours();
                                int idx = dup.indexOf(originalContour);
                                System.out.println(idx);
//                                // TODO: Remove the original detection...
                            }
                        } else {
                            // if only the 'centered' detection is biggest replace it.
                            detections.addDetection(centeredContour, 1, tile);
                            detections.removeDetection(i);
                            // TODO: Remove the original detection...
                        }


//                        if (originalContour.contains(expandCentered)) {
//                            // take the bigger one
//                            if (centeredMetrics.getArea() > originalMetrics.getArea()) {
//                                detections.addDetection(centeredContour, 1, tile);
//                                // TODO: Remove the original detection?
//                            }
//                        }
                    }
                }
            }
            i++;
        }
        return detections;
    }

    public List<Shape> filterShapes(List<Shape> shapes) {
        List<Shape> filtered = new ArrayList<>(shapes.size());
        HashSet<Integer> duplicates = new HashSet<>();
        for (int i = 0; i < shapes.size(); i++) {
            if (!duplicates.contains(i)) {
                Shape s1 = shapes.get(i);
                for (int j = 0; j < shapes.size(); j++) {
                    if (i!=j) {
                        Shape s2 = shapes.get(j);
                        if (s1 instanceof PolygonExt) {
                            PolygonExt p1o = (PolygonExt) s1;
                            //PolygonExt p2o = (PolygonExt) s2;
                            PolygonExt p1 = (PolygonExt) s1;
                            PolygonExt p2 = (PolygonExt) s2;
                            PolygonMetrics pm1 = new PolygonMetrics(p1);
                            p1 = p1.scale(120d, pm1.getCenter());
                            if (p1.contains(p2)) {
                                int dup = j;
                                PolygonMetrics pm2 = new PolygonMetrics(p2);
                                p2 = p2.scale(120d, pm2.getCenter());
                                if (p2.contains(p1o)) {
                                    // take bigger one
                                    if (pm2.getArea()>pm1.getArea()) {
                                        dup = i;
                                    }
                                }
                                duplicates.add(dup);
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < shapes.size(); i++) {
            Shape s = shapes.get(i);
            if (!duplicates.contains(i)) {
                filtered.add(s);
            }
        }

        return filtered;
    }

    @Override
    public DLR101Detections segmentationImplementation(OrbitModel orbitSegModel, OrbitTiledImageIOrbitImage orbitImage, Point tile) {
        return null;
    }

    protected BufferedImage maskRaster(Raster inputTileRaster,
                                       OrbitTiledImageIOrbitImage orbitImage,
                                       boolean writeImg) {
        WritableRaster tileRaster = (WritableRaster) inputTileRaster.createTranslatedChild(0, 0);
        BufferedImage ori = new BufferedImage(orbitImage.getColorModel(), tileRaster, false, null);
        ori = DLHelpers.shrink(ori, segmentationSettings);

        Tensor<Float> inputTensor = DLR101Segment.convertBufferedImageToTensor(ori);

        DLR101Detections detections = getDLR101RawDetections(inputTensor);

        return decodeLabels(detections.getResult());
    }

    @Override
    public DLR101Detections processDetections(SegmentationResult segRes, Point tileOffset) {
        DLR101Detections detections = new DLR101Detections();
        detections.setSegmentationResult(segRes);
        List<Shape> shapes = segRes.getShapeList();
        for (Shape shape : shapes) {
            PolygonExt polygon = (PolygonExt) shape;
            polygon.setClosed(true);

            // Rescale the shape to display properly on the whole slide image.
            polygon = polygon.scale(segmentationSettings.getTileScaleFactorXPercent(), new Point(0,0));

            // Translate the image based on it's location in the whole slide image.
            polygon.translate(tileOffset.x, tileOffset.y);

            // TODO: Assign the correct bounding box, probability and class.
            detections.addDetection(polygon,1, tileOffset);
        }
        return detections;
    }

    public DLR101Detections getDLR101RawDetections(final Tensor<Float> inputTensor) {

        Tensor<Long> res = s
                .runner()
                .feed("image_batch", inputTensor)
                .fetch("predictions")
                .run().get(0).expect(Long.class);

        long[] mask = res.copyTo(new long[res.numElements()]);

        return new DLR101Detections(mask);
    }

    /**
     * Convert an image into a tensor format suitable for DeepLabV2-Resnet101
     * @param image The image that you want to do inference on.
     * @return The tensor to use for inference.
     */
    public static Tensor<Float> convertBufferedImageToTensor(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[] data = new int[width * height];
        image.getRGB(0, 0, width, height, data, 0, width);
        float[][][][] rgbArray = new float[1][height][width][3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color color = new Color(data[i * width + j]);
                rgbArray[0][i][j][0] = color.getRed();
                rgbArray[0][i][j][1] = color.getGreen();
                rgbArray[0][i][j][2] = color.getBlue();
            }
        }
        return Tensor.create(rgbArray, Float.class);
    }

    /**
     * Change a long[] to a long[][] that matches the image shape.
     * @param values long[]
     * @return long[][]
     */
    public int[][] convert1DVectorTo2D(long[] values) {
        int rows = segmentationSettings.getImageWidth();
        int cols = segmentationSettings.getImageHeight();
        int[][] array = new int[rows][cols];
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < cols; i++) {
                array[j][i] = (int) values[j * cols + i];
            }
        }
        return array;
    }

    /**
     * Take DeepLabV2-Resnet101 raw detections and convert them to a buffered image
     * with black background, and green foreground.
     * @param mask Raw detections.
     * @return Image with detections.
     */
    public BufferedImage decodeLabels(long[] mask) {
        int width = segmentationSettings.getImageWidth();
        int height = segmentationSettings.getImageHeight();
        int[][] label_mask = convert1DVectorTo2D(mask);
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < image.getWidth(); y++) {
            for (int x = 0; x < image.getHeight(); x++) {
                Color color = label_mask[y][x]==0 ? Color.black : Color.white;
                image.setRGB(x, y, color.getRGB());
            }
        }
        return image;
    }
}