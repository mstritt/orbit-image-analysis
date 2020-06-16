package com.actelion.research.orbit.imageAnalysis.deeplearning.playground.maskRCNN;

import com.actelion.research.orbit.beans.RawAnnotation;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.deeplearning.DLSegment;
import com.actelion.research.orbit.imageAnalysis.deeplearning.IDLSegment;
import com.actelion.research.orbit.imageAnalysis.deeplearning.playground.AbstractSegment;
import com.actelion.research.orbit.imageAnalysis.imaging.TileSizeWrapper;
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.tasks.ExclusionMapGen;
import com.actelion.research.orbit.imageAnalysis.utils.*;

import ij.ImagePlus;
import ij.plugin.filter.GaussianBlur;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import javax.media.jai.PlanarImage;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.util.*;
import java.util.List;

import static com.actelion.research.orbit.imageAnalysis.deeplearning.playground.maskRCNN.DLHelpers.*;

public class MaskRCNNSegment extends AbstractSegment {
    private static final Logger logger = LoggerFactory.getLogger(MaskRCNNSegment.class);
    private final MaskRCNNSegmentationSettings segmentationSettings = new MaskRCNNSegmentationSettings(512,512, 16,10,56,56,5);
    public static transient Tensor<Float> anchors = null;
    private static Random random = new Random();
    private Session s;

    public MaskRCNNSegment() {
        s = DLSegment.buildSession("D:/insulin/models/insulin_009.pb");
    }



    public static synchronized Tensor<Float> getAnchors(int img_size) {
        if (anchors==null) {
            float[] fArr = MaskRCNNAnchors.GenerateAnchors(img_size);
            anchors = Tensor.create(new long[]{1,fArr.length/4,4}, FloatBuffer.wrap(fArr));
        }
        return anchors;
    }

    // TODO: Finish this description.
    /**
     * Convenience method.
     * @param input
     * @return
     */
    public RawDetections getMaskRCNNRawDetections(final Tensor<Float> input) {
        return getMaskRCNNRawDetections(
                input,
                this.segmentationSettings.getImageWidth(),
                this.segmentationSettings.getImageHeight(),
                this.segmentationSettings.getMaxDetections(),
                this.segmentationSettings.getMaskWidth(),
                this.segmentationSettings.getMaskHeight(),
                this.segmentationSettings.getNumClasses());
    }

    public RawDetections getMaskRCNNRawDetections(final Point tileCoords, OrbitTiledImageIOrbitImage orbitImage) {

        Raster tileRaster = orbitImage.getTile(tileCoords.x, tileCoords.y);
        WritableRaster writeableTileRaster = (WritableRaster) tileRaster.createTranslatedChild(0, 0);
        BufferedImage originalImage = new BufferedImage(orbitImage.getColorModel(), writeableTileRaster, false, null);

        Tensor<Float> inputTensor = convertBufferedImageToTensor(originalImage);
        return getMaskRCNNRawDetections(
                inputTensor,
                this.segmentationSettings.getImageWidth(),
                this.segmentationSettings.getImageHeight(),
                this.segmentationSettings.getMaxDetections(),
                this.segmentationSettings.getMaskWidth(),
                this.segmentationSettings.getMaskHeight(),
                this.segmentationSettings.getNumClasses()
        );
    }

    /**
     * Resize image to size specified in segmentationSettings and set image to RGB.
     * @param img image to resize.
     * @return Resized image.
     */
    public BufferedImage resize(BufferedImage img) {
        int type = BufferedImage.TYPE_INT_RGB;
        int width = segmentationSettings.getImageWidth();
        int height = segmentationSettings.getImageHeight();

        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img, 0, 0, width, height, null);
        g.dispose();
        return resizedImage;
    }

    private Tensor<Float> convertBufferedImageToTensor(BufferedImage originalImage) {
        // resize and also make it an RGB image
        originalImage = resize(originalImage);

        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        Raster r = originalImage.getRaster();
        int[] rgb = new int[3];

        float[] meanPixel = segmentationSettings.getMeanPixel();

        float[][][][] rgbArray = new float[1][height][width][3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                rgb = r.getPixel(j,i,rgb);
                rgbArray[0][i][j][0] = rgb[0] - meanPixel[0];
                rgbArray[0][i][j][1] = rgb[1] - meanPixel[1];
                rgbArray[0][i][j][2] = rgb[2] - meanPixel[2];
            }
        }
        return Tensor.create(rgbArray, Float.class);
    }

//    public RawDetections getMaskRCNNRawDetections(final Session s, final Tensor<Float> input, final MaskRCNNSegmentationSettings segSettings) {
//        return getMaskRCNNRawDetections(s, input, segSettings.getImageWidth(), segSettings.getImageHeight(), segSettings.getMaxDetections(), segSettings.getMaskWidth(), segSettings.getMaskHeight(), segSettings.getNumClasses());
//    }

//    public RawDetections getMaskRCNNRawDetections(final Session s, final Tensor<Float> input, final int inputWidth, final int inputHeight, final int maxDetections, final int maskWidth, final int maskHeight) {
//        return getMaskRCNNRawDetections(s, input, inputWidth, inputHeight, maxDetections, maskWidth, maskHeight, 2);
//    }

    /**
     * @param input The Tensor representing the image for detection
     * @param inputWidth Image width (pixels)
     * @param inputHeight Image height (pixels)
     * @param maxDetections Maximum number of objects to detect (must match the exported model included in the TensorFlow session object.
     * @param maskWidth The mask width (pixels)
     * @param maskHeight The mask height (pixels)
     * @param numClasses The number of classes to detect (must match the exported model included in the TensorFlow session object.
     * @return a RawDetections object.
     */
    public RawDetections getMaskRCNNRawDetections(final Tensor<Float> input, final int inputWidth, final int inputHeight, final int maxDetections, final int maskWidth, final int maskHeight, final int numClasses) {
        // image metas
        //  meta = np.array(
        //        [image_id] +                  # size=1
        //        list(original_image_shape) +  # size=3
        //        list(image_shape) +           # size=3
        //        list(window) +                # size=4 (y1, x1, y2, x2) in image coordinates
        //        [scale[0]] +                     # size=1 NO LONGER, I dont have time to correct this properly so take only the first element
        //        list(active_class_ids)        # size=num_classes
        //    )
        final FloatBuffer metas = FloatBuffer.wrap(new float[]{
                0,
                inputWidth,inputHeight,3,
                inputWidth,inputHeight,3,
                0,0,inputWidth,inputHeight,
                1,
                0,0,0,0,0
        });
        // TODO: metas needs to be dynamic with numclasses, and so does meta_data...
        final Tensor<Float> meta_data = Tensor.create(new long[]{1,17},metas);

        List<Tensor<?>> res = s
                .runner()
                .feed("input_image", input)
                .feed("input_image_meta", meta_data)
                .feed("input_anchors", getAnchors(inputWidth))  // dtype float and shape [?,?,4]
                .fetch("mrcnn_detection/Reshape_1")   // mrcnn_mask/Reshape_1   mrcnn_detection/Reshape_1    mrcnn_bbox/Reshape     mrcnn_class/Reshape_1
                .fetch("mrcnn_mask/Reshape_1")
                .run();

        float[][][] res_detection = new float[1][maxDetections][6];   // mrcnn_detection/Reshape_1   -> y1,x1,y2,x2,class_id,probability (ordered desc)
        float[][][][][] res_mask = new float[1][maxDetections][maskHeight][maskWidth][numClasses];   // mrcnn_mask/Reshape_1
        Tensor<Float> mrcnn_detection = res.get(0).expect(Float.class);
        Tensor<Float> mrcnn_mask = res.get(1).expect(Float.class);
        // TODO: allow reshaping a higher dimensional (more detections) to a lower dimensional java array.
        mrcnn_detection.copyTo(res_detection);
        mrcnn_mask.copyTo(res_mask);

        RawDetections rawDetections = new RawDetections();
        rawDetections.objectBB = res_detection;
        rawDetections.masks = res_mask;
        return rawDetections;
    }

    /**
     * Convenience method to call the generic generateSegmentationAnnotations() method.
     * @param images list of rdfIds for images to be segmented using MaskRCNN.
     * @param segModel Segmentation Model?
     * @param modelContainingExclusionModel An exclusion model, used to focus on only the area of interest (e.g.
     *                                      ignore artifacts, blank area) and (probably) speed up the calculation
     *                                      by ignoring uninteresting areas.
     * @param storeAnnotations Should the annotations be stored back to the Orbit DB?
     * @return Map with RdfId as key and annotations as List<Shape> (segmentationsPerImage).
     */
    public Map<Integer, java.util.List<Shape>> generateSegmentationAnnotations(int[] images, OrbitModel segModel, OrbitModel modelContainingExclusionModel, boolean storeAnnotations) {
        List<RawDataFile> rdfList = new ArrayList<>(images.length);
        try {
            for (int image : images) {
                rdfList.add(DALConfig.getImageProvider().LoadRawDataFile(image));
            }
        } catch (Exception ex) {
            logger.error("Could not read Raw Data File");
            logger.error(ex.getLocalizedMessage());
        }
        return generateSegmentationAnnotations(rdfList,segModel,modelContainingExclusionModel,storeAnnotations);
    }

    /**
     * Create annotations that can optionally be written to Orbit DB.
     * @param rdfList List of images (RDFs) to be processed.
     * @param segModel Segmentation model?
     * @param modelContainingExclusionModel An exclusion model, used to focus on only the area of interest (e.g.
     *                                      ignore artifacts, blank area) and (probably) speed up the calculation
     *                                      by ignoring uninteresting areas.
     * @param storeAnnotations Should the annotations be stored back to the Orbit DB?
     * @return Map with RdfId as key and annotations as List<Shape> (segmentationsPerImage).
     */
    public Map<Integer, List<Shape>> generateSegmentationAnnotations(List<RawDataFile> rdfList, OrbitModel segModel, OrbitModel modelContainingExclusionModel, boolean storeAnnotations) {

        Map<Integer, List<Shape>> segmentationsPerImage = new HashMap<>();
        // Loop over images.
        for (RawDataFile rdf : rdfList) {
            long startt = System.currentTimeMillis();
            OrbitTiledImage2.resetTileCache();
            int rdfId = rdf.getRawDataFileId();
            logger.info("rdfid: " + rdfId);
            List<Shape> segmentationShapes = new ArrayList<>();

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
                // Basic detection algorithm is:
                //        Tensor<Float> input = DLHelpers.convertBufferedImageToTensor(originalImage, segmentationModel.getSegmentationSettings().getImageWidth(), segmentationModel.getSegmentationSettings().getImageHeight());
                //
                //        RawDetections rawDetections = segmentationModel.getMaskRCNNRawDetections(s, input);
                //        MaskRCNNDetections detections = maskRCNN.processDetections(segmentationModel.getSegmentationSettings().getImageWidth(), segmentationModel.getSegmentationSettings().getImageHeight(),rawDetections);
                //        BufferedImage outputImage = DLHelpers.augmentDetections(originalImage, detections);
                for (Point tile : tiles) {
                    tileNr++;
                    logger.info("tile " + tileNr + " of " + tiles.length);
                    // Test if the tile is in the ROI, and not exclusively part of the exclusion map.
                    // if (!(tile.x==15 && tile.y==12)) continue;   // for testing: just on one tile
                    // TODO: Remove this testing line.
                    if (!(tile.x == 1 && tile.y == 2)) continue;
                    if (OrbitUtils.isTileInROI(tile.x, tile.y, orbitImage, roiDef, exclusionMapGen)) {
                        // Apply segmentation model to the tile image.
                        // TODO: Is this needed?
                        SegmentationResult segRes = null;
                        try {
                            segRes = this.segmentTile(tile.x, tile.y, orbitImage, s, segModel, false);
                        } catch (Exception e) {
                            logger.error(e.getLocalizedMessage());
                        }

                        if (segRes != null) {
                            logger.info("ObjectCount: " + Objects.requireNonNull(segRes).getObjectCount() + " for tile " + tile.x + " x " + tile.y);
                        } else {
                            logger.info("Segmentation model not defined, not applying segmentation model.");
                        }

                        // Apply MaskRCNN raw detection model to tile.
                        RawDetections rawDetections = this.getMaskRCNNRawDetections(tile, orbitImage);
                        MaskRCNNDetections detections = this.processDetections(rawDetections);

                        System.out.println();
                        System.out.println(detections.toString());

                        List<ImageAnnotation> maskrcnnAnnotations = createAnnotations(detections);

                        //
//                        int minX = orbitImage.tileXToX(tile.x);
//                        int minY = orbitImage.tileYToY(tile.y);
//                        if (segmentationSettings.getSegmentationRefinement()) {
//                            for (Shape segShape: segRes.getShapeList()) {
//                                PolygonExt scaleShape = (PolygonExt) segShape;
//                                PolygonMetrics polyMetrics = new PolygonMetrics(scaleShape);
//                                scaleShape = scaleShape.scale(200d, polyMetrics.getCenter());
//                                scaleShape.translate(minX, minY);
//                                Point2D center = polyMetrics.getCenter();
//                                scaleShape.translate((int) center.getX(), (int) center.getY());
//                                PolygonMetrics pm2 = new PolygonMetrics(scaleShape);
//                                center = pm2.getCenter();
//
//                                //segmentationShapes.add(scaleShape);     // enable?
//
//                                // re-segment
//                                int startx = (int) (center.getX() - 512);
//                                int starty = (int) (center.getY() - 512);
//                                if (startx < 0) startx = 0;
//                                if (starty < 0) starty = 0;
//                                if (startx + 1024 >= orbitImage.getWidth()) startx = orbitImage.getWidth() - 1025;
//                                if (starty + 1024 >= orbitImage.getHeight()) starty = orbitImage.getHeight() - 1025;
//                                Rectangle rect = new Rectangle(startx, starty, 1024, 1024);
//                                Raster rasterCenter = orbitImage.getData(rect);
//                                SegmentationResult segCenter = null;
//                                try {
//                                    segCenter = DLHelpers.segmentRaster(rasterCenter, orbitImage, s, segModel, false, segmentationSettings);
//                                } catch (Exception e) {
//                                    logger.error(e.getLocalizedMessage());
//                                }
//                                if (Objects.requireNonNull(segCenter).getObjectCount() > 0) {
//                                    // find center shape
//                                    Point centerP = new Point(256, 256);
//                                    Shape centerShape = segCenter.getShapeList().get(0);
//                                    double dist = 1024;
//                                    for (Shape shape2 : segCenter.getShapeList()) {
//                                        PolygonMetrics pm = new PolygonMetrics((Polygon) shape2);
//                                        double d = pm.getCenter().distance(centerP);
//                                        if (d < dist) {
//                                            centerShape = shape2;
//                                            dist = d;
//                                        }
//                                    }
//                                    PolygonExt scaleShape2 = (PolygonExt) centerShape;
//                                    PolygonMetrics polyMetrics2 = new PolygonMetrics(scaleShape2);
//                                    scaleShape2 = scaleShape2.scale(200d, polyMetrics2.getCenter());
//                                    scaleShape2.translate(startx, starty);
//                                    Point2D center2 = polyMetrics2.getCenter();
//                                    scaleShape2.translate((int) center2.getX(), (int) center2.getY());
//
//                                    PolygonMetrics pm = new PolygonMetrics(scaleShape2);
//                                    Point2D centerScaled = pm.getCenter();
//                                    if (OrbitUtils.isInROI((int)centerScaled.getX(),(int)centerScaled.getY(),roiDef,exclusionMapGen)) {
//                                        segmentationShapes.add(scaleShape2);
//                                    }
//                                }
//                            }
//                        }

//                    }
//                    }
//                    }

                        logger.info("shapes before filtering: " + maskrcnnAnnotations.size());
                        // TODO: Re-enable
                        //segmentationShapes = DLSegment.filterShapes(segmentationShapes);
                        logger.info("shapes after filtering: " + maskrcnnAnnotations.size());
                        if (storeAnnotations) {
                            logger.info("storing annotations in DB");
                            try {
                                this.storeShapes(detections, "Islet_", segmentationSettings, rdfId, "orbit");
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


    /**
     * Apply segmentation model to a tile.
     * @param tileX
     * @param tileY
     * @param orbitImage
     * @param s
     * @param segModel
     * @param writeImg
     * @return SegmentationResult describing the segmentation.
     * @throws Exception
     */
    public SegmentationResult segmentTile(int tileX, int tileY, OrbitTiledImageIOrbitImage orbitImage, Session s, OrbitModel segModel, boolean writeImg) {
        // Read the tile.
        Raster tileRaster = orbitImage.getTile(tileX, tileY);
        BufferedImage maskOriginal = maskRaster(tileRaster,orbitImage, s, writeImg, segmentationSettings);

        // TODO: add these four lines back in.
//        maskOriginal = getShiftedMask(orbitImage, s, tileRaster, maskOriginal, 0, 512, segmentationSettings);
//        maskOriginal = getShiftedMask(orbitImage, s, tileRaster, maskOriginal, 0, -512, segmentationSettings);
//        maskOriginal = getShiftedMask(orbitImage, s, tileRaster, maskOriginal, 512, 0, segmentationSettings);
//        maskOriginal = getShiftedMask(orbitImage, s, tileRaster, maskOriginal, -512, 0, segmentationSettings);
        // maskOriginal = getShiftedMask(orbitImage, s, tileRaster, maskOriginal, factor, 0, 0, true);

        //ImageIO.write(maskOriginal, "jpeg", new File(path + File.separator +"tile" + tileX + "x" + tileY + "_seg1.jpg"));
        SegmentationResult segmentationResult = null;
        try {
            segmentationResult = this.getSegmentationResult(segModel, maskOriginal);
        } catch (OrbitImageServletException e) {
            logger.error(e.getLocalizedMessage());
        }
        return segmentationResult;
    }

    public SegmentationResult getSegmentationResult(OrbitModel segModel, BufferedImage segmented) throws OrbitImageServletException {
        IOrbitImage segimg = new OrbitImagePlanar(PlanarImage.wrapRenderedImage(segmented), "segmented");
        RecognitionFrame rfSeg = new RecognitionFrame(segimg, "segmented");
        List<Point> tl = new ArrayList<>();
        tl.add(new Point(-1, -1));
        return OrbitHelper.Segmentation(rfSeg, 0, segModel, tl, 1, false);
    }

    public MaskRCNNSegmentationSettings getSegmentationSettings() {
        return segmentationSettings;
    }

    public List<ImageAnnotation> createAnnotations(MaskRCNNDetections detections) {
        ArrayList<ImageAnnotation> annotations = new ArrayList<>();
        for (MaskRCNNDetections.Detection detection: detections.getDetections()) {
            ImageAnnotation annotation = new ImageAnnotation(segmentationSettings.getClassName(detection.getMaskClass()),
                    detection.getContour(),
                    ImageAnnotation.SUBTYPE_NORMAL,
                    segmentationSettings.getAnnotationColor(detection.getMaskClass()));
            annotations.add(annotation);
        }
        return annotations;
    }

    public BufferedImage augmentDetections(BufferedImage image, MaskRCNNDetections detections) {

        boolean drawBoundingBox = false;
        boolean drawContour = true;
        BufferedImage outImg = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        Graphics2D g = outImg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g.drawImage(image,0,0,null);
        int numObjects = detections.getBoundingBoxes().size();
        for (int i=0; i<numObjects; i++) {
            //float probability = detections.getProbabilities().get(i);
            int maskClass = detections.getMaskClasses().get(i);
            RectangleExt rect = detections.getBoundingBoxes().get(i);
            PolygonExt poly = detections.getContours().get(i);

            int x = rect.x;
            int y = rect.y;
            int width = rect.width;
            int height = rect.height;
            if (drawBoundingBox) {
                g.setStroke(new BasicStroke(2));
                g.setColor(segmentationSettings.getAnnotationColor(maskClass));
                g.drawRect(x, y, width, height);
            }

            // draw contour
            if (drawContour) {
                g.setStroke(new BasicStroke(2));
                Color color = Color.getHSBColor(random.nextFloat(),1f,1f);
                g.setColor(color);
                g.drawPolygon(poly);
            }
        }

        g.dispose();
        return outImg;
    }

    public MaskRCNNDetections processDetections(RawDetections rawDetections) {
        return processDetections(segmentationSettings.getImageWidth(), segmentationSettings.getImageHeight(), rawDetections);
    }


        public MaskRCNNDetections processDetections(int imgWidth, int imgHeight, RawDetections rawDetections) {
        MaskRCNNDetections detections = new MaskRCNNDetections();
        detections.setBoundingBoxes(new ArrayList<>());
        detections.setMaskClasses(new ArrayList<>());
        detections.setContours(new ArrayList<>());
        detections.setProbabilities(new ArrayList<>());
        float[][] objects = rawDetections.objectBB[0]; // only one image      y1,x1,y2,x2,class_id,probability (ordered desc)
        for (int i=0; i<objects.length; i++) {
            float[] bb = objects[i];  // y1,x1,y2,x2,class_id,probability
            if (bb[5]>0.1 && ((bb[3]-bb[1])*(bb[2]-bb[0])>1E-5))  {    // probability > 0.8 and area > 1E-5
                float probability = bb[5];
                int maskClass = (int) bb[4];
                int x = (int)(bb[1] * imgWidth);
                int y = (int)(bb[0] * imgHeight);
                int width = (int)((bb[3]-bb[1])*imgWidth);
                int height = (int)((bb[2]-bb[0])*imgHeight);
                RectangleExt boundingBox = new RectangleExt(x,y,width,height);

                // masks    [1][512][28][28][2]
                float[][][] mask = rawDetections.masks[0][i];
                int rw = mask[0].length;
                int rh = mask.length;
                float scaleW = (float)width / (float)rw;
                float scaleH = (float)height / (float)rh;
                BufferedImage roi = new BufferedImage(rw,rh,BufferedImage.TYPE_INT_ARGB);
                for (int xr=0; xr<rw; xr++) {
                    for (int yr=0; yr<rh; yr++) {
                        if (mask[yr][xr][1]>0.45f)
                        // if (mask[yr][xr][0]<mask[yr][xr][1])
                        //if (mask[yr][xr][0]<mask[yr][xr][1] && mask[yr][xr][1]>0.5f)
                        {
                            roi.setRGB(xr,yr,Color.MAGENTA.getRGB());
                        }
                    }
                }
                // scale mask to bb size
                BufferedImage roiScaled = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
                Graphics2D roiG = roiScaled.createGraphics();
                roiG.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                roiG.drawImage(roi,0,0,width,height,null);
                roiG.dispose();

                // blur
                ImagePlus ip = new ImagePlus("img",roiScaled);
                GaussianBlur blur = new GaussianBlur();
                blur.setNPasses(1);
                blur.blurGaussian(ip.getProcessor(),8,8,0.02d);
                roiScaled = ip.getProcessor().getBufferedImage();

                // draw contour
                int pad = 10;
                int[] argb = new int[4];
                Raster raster = roiScaled.getRaster();
                float[][] area = new float[roiScaled.getWidth()+pad*2][roiScaled.getHeight()+pad*2];
                for (int x1=0; x1<roiScaled.getWidth(); x1++) {
                    for (int y1=0; y1<roiScaled.getHeight(); y1++) {
                        argb = raster.getPixel(x1,y1,argb);
                        long sum = argb[1]+argb[2]+argb[0];

                        area[x1+pad][y1+pad] = sum>180L? 1:0 /*sum / (double)(3*256)*/;
                    }
                }
                // fill holes
                //area = dilate(area);
                //area = erode(area);

//                try {
//                    int fg = Color.white.getRGB();
//                    int bg = Color.blue.getRGB();
//                    BufferedImage bi = new BufferedImage(roiScaled.getWidth(),roiScaled.getHeight(),BufferedImage.TYPE_INT_RGB);
//                    for (int x1=0; x1<roiScaled.getWidth(); x1++) {
//                        for (int y1 = 0; y1 < roiScaled.getHeight(); y1++) {
//                              bi.setRGB(x1,y1,area[x1][y1]>0?fg:bg);
//                        }
//                    }
//                    ImageIO.write(bi,"png", new File("D:\\NoBackup\\brains\\detect\\out2\\10743897-1-roi-mask.png"));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

                final ArrayList<Point2D> contour = new ArrayList<>();
                if (MarchingSquares.calculateContour(contour, area, 1, 0.5f)) {
                    int[] xpoints = new int[contour.size()];
                    int[] ypoints = new int[contour.size()];
                    for (int j=0; j<contour.size(); j++) {
                        xpoints[j] = (int)(x + ((contour.get(j).getX()-pad) * 1f));
                        ypoints[j] = (int)(y + ((contour.get(j).getY()-pad) * 1f));
                    }
                    PolygonExt polygon = new PolygonExt(new Polygon(xpoints,ypoints, xpoints.length));
                    detections.getProbabilities().add(probability);
                    detections.getBoundingBoxes().add(boundingBox);
                    detections.getContours().add(polygon);
                    detections.getMaskClasses().add(maskClass);
                }


            }
        }
        return detections;
    }
}
