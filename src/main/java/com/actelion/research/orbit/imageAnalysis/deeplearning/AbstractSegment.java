package com.actelion.research.orbit.imageAnalysis.deeplearning;

import com.actelion.research.orbit.beans.RawAnnotation;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.deeplearning.DeepLabV2Resnet101.DLR101Detections;
import com.actelion.research.orbit.imageAnalysis.imaging.TileSizeWrapper;
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.tasks.ExclusionMapGen;
import com.actelion.research.orbit.imageAnalysis.utils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.media.jai.PlanarImage;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.*;
import java.util.List;

// TODO: Consider moving boilerplate to interface using default implementation functionality.
public abstract class AbstractSegment<D extends AbstractDetections<? extends AbstractDetection>,S extends AbstractSegmentationSettings<S>> implements IDLSegment<D, S> {

    protected static Logger logger = LoggerFactory.getLogger(AbstractSegment.class);
    protected final S segmentationSettings;

    protected AbstractSegment(S segmentationSettings) {
        this.segmentationSettings = segmentationSettings;
    }

    public abstract D segmentationImplementation(OrbitModel orbitSegModel,
                                                 OrbitTiledImageIOrbitImage orbitImage,
                                                 Point tile);

    public abstract D segmentationImplementation(OrbitModel orbitSegModel,
                                                 OrbitTiledImageIOrbitImage orbitImage,
                                                 Point tile,
                                                 ExclusionMapGen exclusionMapGen,
                                                 Shape roiDef);

    /**
     * Convenience method to call the generic generateSegmentationAnnotations() method. Uses the default
     * segmentation settings...
     * @param images list of rdfIds for images to be segmented.
     * @param orbitSegModel Segmentation Model?
     * @param modelContainingExclusionModel An exclusion model, used to focus on only the area of interest (e.g.
     *                                      ignore artifacts, blank area) and (probably) speed up the calculation
     *                                      by ignoring uninteresting areas.
     * @param tileOnly The tile coordinates (not the pixel coordinates) of the tile to be processed (don't process
     *                 all tiles...).
     * @param storeAnnotations Should the annotations be stored back to the Orbit DB?
     * @return Map with RdfId as key and annotations as List<Shape> (segmentationsPerImage).
     */
    public Map<Integer, List<Shape>> generateSegmentationAnnotations(int[] images,
                                                                     OrbitModel orbitSegModel,
                                                                     OrbitModel modelContainingExclusionModel,
                                                                     Point tileOnly,
                                                                     boolean storeAnnotations) {
        return generateSegmentationAnnotations(images,segmentationSettings,orbitSegModel,modelContainingExclusionModel, tileOnly, storeAnnotations);
    }

    /**
     * Convenience method to call the generic generateSegmentationAnnotations() method.
     * @param images list of rdfIds for images to be segmented.
     * @param orbitSegModel Segmentation Model?
     * @param modelContainingExclusionModel An exclusion model, used to focus on only the area of interest (e.g.
     *                                      ignore artifacts, blank area) and (probably) speed up the calculation
     *                                      by ignoring uninteresting areas.
     * @param storeAnnotations Should the annotations be stored back to the Orbit DB?
     * @return Map with RdfId as key and annotations as List<Shape> (segmentationsPerImage).
     */
    public Map<Integer, List<Shape>> generateSegmentationAnnotations(int[] images,
                                                                     OrbitModel orbitSegModel,
                                                                     OrbitModel modelContainingExclusionModel,
                                                                     boolean storeAnnotations) {
        return generateSegmentationAnnotations(images,orbitSegModel,modelContainingExclusionModel,null, storeAnnotations);
    }

    /**
     * Convenience method to call the generic generateSegmentationAnnotations() method.
     * @param images list of rdfIds for images to be segmented.
     * @param segmentationSettings Segmentation settings for the model.
     * @param orbitSegModel Segmentation Model?
     * @param modelContainingExclusionModel An exclusion model, used to focus on only the area of interest (e.g.
     *                                      ignore artifacts, blank area) and (probably) speed up the calculation
     *                                      by ignoring uninteresting areas.
     * @param tileOnly The tile coordinates (not the pixel coordinates) of the tile to be processed (don't process
     *                 all tiles...).
     * @param storeAnnotations Should the annotations be stored back to the Orbit DB?
     * @return Map with RdfId as key and annotations as List<Shape> (segmentationsPerImage).
     */
    public Map<Integer, List<Shape>> generateSegmentationAnnotations(int[] images,
                                                                     S segmentationSettings,
                                                                     OrbitModel orbitSegModel,
                                                                     OrbitModel modelContainingExclusionModel,
                                                                     Point tileOnly,
                                                                     boolean storeAnnotations) {
        List<RawDataFile> rdfList = new ArrayList<>(images.length);
        try {
            for (int image : images) {
                rdfList.add(DALConfig.getImageProvider().LoadRawDataFile(image));
            }
        } catch (Exception ex) {
            logger.error("Could not read Raw Data File");
            logger.error(ex.getLocalizedMessage());
        }
        return generateSegmentationAnnotations(rdfList, segmentationSettings, orbitSegModel, modelContainingExclusionModel, tileOnly, storeAnnotations);
    }

    /**
     * Create annotations that can optionally be written to Orbit DB.
     * @param rdfList List of images (RDFs) to be processed.
     * @param segmentationSettings Segmentation settings for the model.
     * @param orbitSegModel Segmentation model?
     * @param modelContainingExclusionModel An exclusion model, used to focus on only the area of interest (e.g.
     *                                      ignore artifacts, blank area) and (probably) speed up the calculation
     *                                      by ignoring uninteresting areas.
     * @param tileOnly The tile coordinates (not the pixel coordinates) of the tile to be processed (don't process
     *                 all tiles...).
     * @param storeAnnotations Should the annotations be stored back to the Orbit DB?
     * @return Map with RdfId as key and annotations as List<Shape> (segmentationsPerImage).
     */
    public Map<Integer, List<Shape>> generateSegmentationAnnotations(List<RawDataFile> rdfList,
                                                                     S segmentationSettings,
                                                                     OrbitModel orbitSegModel,
                                                                     OrbitModel modelContainingExclusionModel,
                                                                     Point tileOnly,
                                                                     boolean storeAnnotations) {
        // TODO: roiGenerator - analagous to exMapGen - returns list of ROIs.
        Map<Integer, List<Shape>> segmentationsPerImage = new HashMap<>();
        // Loop over images.
        for (RawDataFile rdf : rdfList) {
            long startt = System.currentTimeMillis();
            OrbitTiledImage2.resetTileCache();
            int rdfId = rdf.getRawDataFileId();
            logger.info("rdfid: " + rdfId);

            // Get annotations already existing for the image.
            List<RawAnnotation> annotations = null;
            try {
                annotations = DALConfig.getImageProvider().LoadRawAnnotationsByRawDataFile(rdfId, RawAnnotation.ANNOTATION_TYPE_IMAGE);
            } catch (Exception e) {
                logger.error("Could not read Raw Annotations.");
                logger.error(e.getLocalizedMessage());
            }

            // TODO: Consider union case, and also separate Rois.
            // Extract the different types of annotation.
            List<ImageAnnotation> rois = new ArrayList<>();
            List<Shape> exclusions = new ArrayList<>();
            List<Shape> inclusions = new ArrayList<>();
            for (RawAnnotation annotation : Objects.requireNonNull(annotations)) {
                ImageAnnotation ia = null;
                try {
                    ia = new ImageAnnotation(annotation);
                } catch (IOException | ClassNotFoundException e) {
                    logger.error(e.getLocalizedMessage());
                }
                if (Objects.requireNonNull(ia).getSubType() == ImageAnnotation.SUBTYPE_ROI) rois.add(ia);
                else if (ia.getSubType() == ImageAnnotation.SUBTYPE_EXCLUSION) exclusions.add(ia.getFirstShape());
                //TODO: Add inclusions. Can be used by a standard method?
                //    public ShapeAnnotationList(List<RawAnnotation> annotations, int annotationGroup, Rectangle outerBounds) {
                // loadRoi ???
            }

            // Retrieve the actual image.
            RecognitionFrame rf = null;
            try {
                rf = new RecognitionFrame(rdf);
            } catch (OrbitImageServletException e) {
                logger.error(e.getLocalizedMessage());
            }

            TileSizeWrapper tileSizeWrapper = new TileSizeWrapper(
                    new OrbitImagePlanar(Objects.requireNonNull(rf).bimg.getImage(), ""),
                    segmentationSettings.getTrainingImageTileWidth(),
                    segmentationSettings.getTrainingImageTileHeight());

            OrbitTiledImageIOrbitImage orbitImage = new OrbitTiledImageIOrbitImage(tileSizeWrapper);

            // Apply the Exclusion map.
            ExclusionMapGen exclusionMapGen = null;
            // TODO: Re-enable when JAI issue is fixed.
            if (modelContainingExclusionModel != null && modelContainingExclusionModel.getExclusionModel() != null) {
                exclusionMapGen = ExclusionMapGen.constructExclusionMap(rdf, rf, modelContainingExclusionModel);
                if (exclusionMapGen != null) {
                    try {
                        exclusionMapGen.generateMap();
                    } catch (OrbitImageServletException e) {
                        logger.error(e.getLocalizedMessage());
                    }
                }
            }

            // For existing ROI annotations (from Orbit DB) define a roiDef and add it to a list of all roiDefs.
            List<Shape> roiDefList = new ArrayList<>();
            for (ImageAnnotation roiAnnotation : rois) {
                IScaleableShape roiShape = (IScaleableShape) roiAnnotation.getFirstShape();
                roiShape = (IScaleableShape) roiShape.getScaledInstance(100d, new Point(0, 0));
                ShapeAnnotationList roiDef = new ShapeAnnotationList(inclusions, exclusions, roiShape, roiShape.getBounds());
                roiDefList.add(roiDef);
            }
            if (roiDefList.size() == 0) {   // no ROI annotations, so create one around the whole image
                roiDefList.add(new RectangleExt(0, 0, rf.bimg.getWidth(), rf.bimg.getHeight()));
            }

            // Process all roiDefs.
            for (Shape roiDef : roiDefList) {
                Point[] tiles = orbitImage.getTileIndices(roiDef.getBounds());
                int tileNr = 0;
                // Process all tiles from the image.
                for (Point tile : tiles) {
                    tileNr++;
                    logger.info("tile " + tileNr + " of " + tiles.length);
                    logger.info("tileX: "+tile.x+" tileY: "+tile.y);
                    // Test if the tile is in the ROI, and not exclusively part of the exclusion map.
                    // if (!(tile.x==15 && tile.y==12)) continue;   // for testing: just on one tile
                    if (tileOnly != null) {
                        if (!(tile.x==tileOnly.x && tile.y==tileOnly.y)) continue;
                    }
                    if (OrbitUtils.isTileInROI(tile.x, tile.y, orbitImage, roiDef, exclusionMapGen)) {
                        // Calculate Tile Offset for translating annotations.
                        //D detections = segmentationImplementation(orbitSegModel, orbitImage, tile);
                        D detections = segmentationImplementation(orbitSegModel, orbitImage, tile, exclusionMapGen, roiDef);

                        logger.info("shapes before filtering: " + detections.getDetections().size());
                        // TODO: Re-enable
                        //segmentationShapes = DLSegment.filterShapes(segmentationShapes);
                        logger.info("shapes after filtering: " + detections.getDetections().size());
                        if (storeAnnotations && detections.getDetections().size() > 0) {
                            logger.info("storing annotations in DB");
                            try {
                                // TODO: Fix this.
                                // If running in GUI mode force user to login, else use a hardcoded user.
                                if (!ScaleoutMode.SCALEOUTMODE.get()) {
                                    OrbitImageAnalysis.getInstance().forceLogin();
                                    this.storeShapes(detections, segmentationSettings, rdfId, "AutomatedAnnotation");
                                } else {
                                    this.storeShapes(detections, segmentationSettings, rdfId, "AutomatedAnnotation");
                                }
                            } catch (Exception e) {
                                logger.error(e.getLocalizedMessage());
                            }
                        }
                        segmentationsPerImage.put(rdfId, detections.getContourShapes());
                        long usedt = System.currentTimeMillis() - startt;
                        logger.info("used time(h) for image: " + (usedt / 60000) / 60);
                    }
                }
            }
        }
        return segmentationsPerImage;
    }

    public void storeShape(Shape shape, String name, Color color, int rdfId, String user) throws Exception {
        ClassShape classShape = new ClassShape(name, color, ClassShape.SHAPETYPE_POLYGONEXT);
        classShape.getShapeList().add(shape);
        SpotAnnotation spot = new MaskRCNNAnnotation(name, classShape);
        spot.setRawDataFileId(rdfId);
        spot.setUserId(user);
        DALConfig.getImageProvider().InsertRawAnnotation(spot);
    }

    public void storeShapes(D detections, S settings,
                            int rdfId, String user) throws Exception {
        for (AbstractDetection detection: detections.getDetections()) {
            int maskClass = detection.getDetectionClass();

            PolygonExt shape = (PolygonExt) detection.getContourShape();

            storeShape(shape,
                    settings.getAnnotationPrefix()+"_"+settings.getClassName(maskClass),
                    settings.getAnnotationColor(maskClass), rdfId, user);
        }
    }

    /**
     * Apply segmentation model to a tile.
     * First extract the current tile as a raster and
     * @param tileX Tile number in x-direction.
     * @param tileY Tile number in y-direction.
     * @param orbitImage The Orbit Image tile that should be segmented.
     * @param segModel The Orbit Segmentation model to use for refining the image masks.
     * @param writeImg Optionally write a test image to a temporary location (for debugging purposes).
     * @return SegmentationResult describing the segmentation.
     */
    public D segmentTile(int tileX, int tileY, OrbitTiledImageIOrbitImage orbitImage, OrbitModel segModel, boolean writeImg, Point tileOffset) {
        // Read the tile. (8192 x 8192...)
        Raster tileRaster = orbitImage.getTile(tileX, tileY);
        BufferedImage maskOriginal = maskRaster(tileRaster,orbitImage, writeImg);

        // Shift the tile half the tile width up, down, left and right.
        int factor = 2;
        int xShift = (int) (segmentationSettings.getImageWidth() * segmentationSettings.getTileScaleFactorX()/2); //4096; //segmentationSettings.getImageWidth()/2;
        int yShift = (int) (segmentationSettings.getImageHeight() * segmentationSettings.getTileScaleFactorY()/2); //4096; //segmentationSettings.getImageHeight()/2;
        maskOriginal = getShiftedMask(orbitImage, tileRaster, maskOriginal, factor,0, yShift, false);
        maskOriginal = getShiftedMask(orbitImage, tileRaster, maskOriginal, factor,0, -yShift, false);
        maskOriginal = getShiftedMask(orbitImage, tileRaster, maskOriginal, factor, xShift, 0, false);
        maskOriginal = getShiftedMask(orbitImage, tileRaster, maskOriginal, factor, -xShift, 0, false);

        D detections = null;
        try {
            SegmentationResult segmentationResult = this.getSegmentationResult(segModel, maskOriginal);
            detections = processDetections(segmentationResult, tileOffset);
        } catch (OrbitImageServletException e) {
            logger.error(e.getLocalizedMessage());
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
    protected D segmentationRefinement(D detections,
                                                    OrbitModel segModel,
                                                    OrbitTiledImageIOrbitImage orbitImage,
                                                    ExclusionMapGen exclusionMapGen,
                                                    Shape roiDef,
                                                    Point tile) throws Exception {

        int tileSize = segmentationSettings.getTrainingImageTileWidth();
        int halfTileSize = tileSize/2;
        int minX = orbitImage.tileXToX(tile.x);
        int minY = orbitImage.tileYToY(tile.y);

        // Keep track of which 'original' detection is being processed (variable 'i').
        int i = 0;
        // Loop over all 'original' detections.
        for (Shape segShape : detections.getSegmentationResult().getShapeList()) {
            PolygonExt scaleShape = (PolygonExt) segShape;
            PolygonMetrics polyMetrics = new PolygonMetrics(scaleShape);
            scaleShape = scaleShape.scale(segmentationSettings.getTileScaleFactorXPercent(), polyMetrics.getCenter());
            scaleShape.translate(minX, minY);
            Point2D center = polyMetrics.getCenter();
            scaleShape.translate((int) center.getX(), (int) center.getY());
            PolygonMetrics pm2 = new PolygonMetrics(scaleShape);
            // Find the center of the detected object.
            center = pm2.getCenter();

            // Re-center the tile around the detected object, ready for 'redetection'.
            int startx = (int) (center.getX() - halfTileSize);
            int starty = (int) (center.getY() - halfTileSize);
            if (startx < 0) startx = 0;
            if (starty < 0) starty = 0;
            if (startx + tileSize >= orbitImage.getWidth()) startx = orbitImage.getWidth() - (tileSize+1);
            if (starty + tileSize >= orbitImage.getHeight()) starty = orbitImage.getHeight() - (tileSize+1);
            Rectangle rect = new Rectangle(startx, starty, tileSize, tileSize);
            Raster rasterCenter = orbitImage.getData(rect);

            // Do a 'new' detection on a tile centered on the original detection.
            BufferedImage bim = maskRaster(rasterCenter, orbitImage, false);
            SegmentationResult segCenter = getSegmentationResult(segModel, bim);

            // If objects are detected, then decide whether to keep the 'original' or 'new' detections.
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
                centeredContour = centeredContour.scale(segmentationSettings.getTileScaleFactorXPercent(), polyMetrics2.getCenter());
                centeredContour.translate(startx, starty);
                Point2D center2 = polyMetrics2.getCenter();
                centeredContour.translate((int) center2.getX(), (int) center2.getY());

                PolygonMetrics pm = new PolygonMetrics(centeredContour);
                Point2D centerScaled = pm.getCenter();
                if (OrbitUtils.isInROI((int) centerScaled.getX(), (int) centerScaled.getY(), roiDef, exclusionMapGen)) {
                    // All objects below are 'shifted/scaled' so that they are in the same reference frame
                    // (0,0,tileWidth,tileHeight).

                    // Create a copy of the original detection
                    PolygonExt originalContour = new PolygonExt(scaleShape); //(PolygonExt) segShape;
                    originalContour.setClosed(true);
                    originalContour.translate(-startx, -starty);
                    PolygonMetrics originalMetrics = new PolygonMetrics(originalContour);

                    // Create an expanded version of the original detection.
                    PolygonExt expandOriginal = new PolygonExt(scaleShape); //(PolygonExt) segShape;
                    expandOriginal.setClosed(true);
                    expandOriginal.translate(-startx, -starty);
                    PolygonMetrics expandOriginalMetrics = new PolygonMetrics(expandOriginal);
                    expandOriginal = expandOriginal.scale(segmentationSettings.getDetectionToleranceScale(), expandOriginalMetrics.getCenter());

                    // Create a copy of the 'new' detection.
                    PolygonExt centeredContourCopy = new PolygonExt(centeredContour);
                    centeredContourCopy.setClosed(true);
                    centeredContourCopy.translate(-startx, -starty);

                    // Create an expanded version of the 'new' detection.
                    PolygonExt expandCentered = (PolygonExt) centerShape;
                    expandCentered.setClosed(true);
                    expandCentered.translate( (int) center2.getX(),  (int) center2.getY());
                    expandCentered = expandCentered.scale(segmentationSettings.getTileScaleFactorXPercent(), polyMetrics2.getCenter());
                    PolygonMetrics expandCenteredMetrics = new PolygonMetrics(expandCentered);
                    expandCentered = expandCentered.scale(segmentationSettings.getDetectionToleranceScale(), expandCenteredMetrics.getCenter());

                    originalContour.getBounds();
                    expandOriginal.getBounds();

                    centeredContourCopy.getBounds();
                    expandCentered.getBounds();

                    // TODO: Generalize this so that it works for DLR and MaskRCNN...
                    if (expandCentered.contains(originalContour)) {
                        PolygonMetrics centeredMetrics = new PolygonMetrics(centeredContour);

                        if (expandOriginal.contains(centeredContourCopy)) {
                            // if works both ways take the biggest.
                            if (centeredMetrics.getArea() > originalMetrics.getArea()) {
                                detections.addDetection(centeredContour, null, null, 1, tile);
                                detections.removeDetection(i);
                            }
                        } else {
                            // if only the 'centered' detection is biggest replace it.
                            detections.addDetection(centeredContour, null, null, 1, tile);
                            detections.removeDetection(i);
                        }
                    }
                }
            }
            i++;
        }
        return detections;
    }

    public SegmentationResult getSegmentationResult(OrbitModel segModel, BufferedImage segmented) throws OrbitImageServletException {
        IOrbitImage segimg = new OrbitImagePlanar(PlanarImage.wrapRenderedImage(segmented), "segmented");
        RecognitionFrame rfSeg = new RecognitionFrame(segimg, "segmented");
        List<Point> tl = new ArrayList<>();
        tl.add(new Point(-1, -1));
        return OrbitHelper.Segmentation(rfSeg, 0, segModel, tl, 1, false);
    }
    
    protected abstract BufferedImage maskRaster(Raster inputTileRaster,
                                                OrbitTiledImageIOrbitImage orbitImage,
                                                boolean writeImg);

    protected BufferedImage getShiftedMask(OrbitTiledImageIOrbitImage orbitImage, Raster tileRaster, BufferedImage maskOriginal, int factor, int dx, int dy, boolean flip) {
        Rectangle rect = tileRaster.getBounds();
        rect.translate(dx,dy);
        if (!orbitImage.getBounds().contains(rect)) {
            return maskOriginal;
        }
        try {
            Raster shiftraster = orbitImage.getData(rect);
            if (flip) {
                shiftraster = flipRaster(shiftraster);
            }
            BufferedImage mask2 = maskRaster(shiftraster, orbitImage, false);
            if (flip) {
                mask2 = flipImage(mask2);
            }
            maskOriginal = combineMasks(maskOriginal, mask2, dx / factor, dy / factor);
        } catch (Exception e) {
            logger.warn("Could not shift raster, returning original image (rect="+rect+" img.bounds="+orbitImage.getBounds()+")", e);
        }
        return maskOriginal;
    }

    protected static BufferedImage flipImage(BufferedImage bi) {
        return new BufferedImage(bi.getColorModel(),(WritableRaster) flipRaster(bi.getData()),false,null);
    }

    protected static Raster flipRaster(Raster r) {
        int w = r.getWidth();
        int h = r.getHeight();
        WritableRaster rf = r.createCompatibleWritableRaster(r.getMinX(),r.getMinY(), w,h);
        int[] p = new int[w*3];
        for (int y=r.getMinY(); y<r.getMinY()+h; y++) {
            p = r.getPixels(r.getMinX(),y,w,1,p);
            rf.setPixels(r.getMinX(),r.getMinY()+h-(y-r.getMinY())-1,w,1,p);
        }
        return rf;
    }

    protected static BufferedImage combineMasks(BufferedImage m1, BufferedImage m2, int dx, int dy) {
        BufferedImage combined = new BufferedImage(m1.getWidth(),m1.getHeight(),m1.getType());
        combined.getGraphics().drawImage(m1,0,0,null);
        int fg = Color.white.getRGB();
        Raster r2 = m2.getRaster();
        int minX = Math.max(-dx, 0);
        int minY = Math.max(-dy, 0);
        int maxX = Math.min(m2.getWidth() - dx, m2.getWidth());
        int maxY = Math.min(m2.getHeight() - dy, m2.getHeight());

        for (int x=minX; x<maxX; x++)
            for (int y=minY; y<maxY; y++) {
                if (r2.getSample(x,y,0)>0) {
                    combined.setRGB(x+dx,y+dy,fg);
                }
            }
        return combined;
    }

    @Override
    public abstract D processDetections(SegmentationResult segRes, Point tileOffset);

//    @Override
//    public abstract D processDetections(Point tileOffset);
}
