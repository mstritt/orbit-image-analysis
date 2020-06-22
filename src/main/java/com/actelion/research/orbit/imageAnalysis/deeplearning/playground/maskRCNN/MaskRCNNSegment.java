package com.actelion.research.orbit.imageAnalysis.deeplearning.playground.maskRCNN;

import com.actelion.research.orbit.beans.RawAnnotation;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.deeplearning.playground.AbstractSegment;
import com.actelion.research.orbit.imageAnalysis.imaging.TileSizeWrapper;
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.tasks.ExclusionMapGen;
import com.actelion.research.orbit.imageAnalysis.utils.*;

import ij.ImagePlus;
import ij.plugin.filter.GaussianBlur;
import imageJ.Colour_Deconvolution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import javax.imageio.ImageIO;
import javax.media.jai.PlanarImage;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.util.*;
import java.util.List;

import static com.actelion.research.orbit.imageAnalysis.deeplearning.playground.maskRCNN.DLHelpers.*;

/**
 * MaskRCNNSegment class for applying MaskRCNN Segmentation models, and keeping track of the
 * settings used.
 * We assume an implementation of MaskRCNN similar to: https://github.com/matterport/Mask_RCNN
 */
public class MaskRCNNSegment extends AbstractSegment {
    private static final Logger logger = LoggerFactory.getLogger(MaskRCNNSegment.class);
    private MaskRCNNSegmentationSettings segmentationSettings = null;
    private final static Random random = new Random();
    private final Session s;
    private final PostProcessMethod postProcess;
    public enum PostProcessMethod {
        STANDARD,
        CUSTOM
    }

    private transient Tensor<Float> anchors = null;

    /**
     * MaskRCNNSegment object constructor with default segmentation settings.
     */
    public MaskRCNNSegment(File maskRCNNModelPB, PostProcessMethod ppm) {
        this(maskRCNNModelPB, ppm, new MaskRCNNSegmentationSettings(512,512, 16.0f,10,56,56,5, "Default_"));
    }

    public MaskRCNNSegment(File maskRCNNModelPB, PostProcessMethod ppm, MaskRCNNSegmentationSettings settings) {
        super();
        s = DLHelpers.buildSession(maskRCNNModelPB.getAbsolutePath());
        postProcess = ppm;
        segmentationSettings = settings;
    }

    /**
     * Calculate the anchors required to apply the MaskRCNN model.
     * @param img_size Size of the image to generate anchors for.
     * @return Anchors tensor for MaskRCNN.
     */
    public synchronized Tensor<Float> getAnchors(int img_size) {
        if (this.anchors==null) {
            float[] fArr = MaskRCNNAnchors.GenerateAnchors(img_size);
            anchors = Tensor.create(new long[]{1,fArr.length/4,4}, FloatBuffer.wrap(fArr));
        }
        return anchors;
    }

    /**
     * Convenience method.
     * @param input Tensorflow tensor representation of image for object detection.
     * @return RawDetections from MaskRCNN model.
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

    /**
     * Convenience method.
     * @param tileCoords Tile coordinates on the tiled image.
     * @param orbitImage Orbit Image to apply MaskRCNN to.
     * @return RawDetections from MaskRCNN model.
     */
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
     * Apply the MaskRCNN model to return raw detections (object bounding box and corresponding masks).
     * @param inputTensor The Tensor representing the image for detection
     * @param inputWidth Image width (pixels)
     * @param inputHeight Image height (pixels)
     * @param maxDetections Maximum number of objects to detect (must match the exported model included in the TensorFlow session object.
     * @param maskWidth The mask width (pixels)
     * @param maskHeight The mask height (pixels)
     * @param numClasses The number of classes to detect (must match the exported model included in the TensorFlow session object.
     * @return a RawDetections object.
     */
    public RawDetections getMaskRCNNRawDetections(final Tensor<Float> inputTensor, final int inputWidth, final int inputHeight, final int maxDetections, final int maskWidth, final int maskHeight, final int numClasses) {
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
                .feed("input_image", inputTensor)
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

    /**
     * Convert a BufferedImage to a Tensorflow Tensor that can be used for inference.
     * During conversion the image is also normalized by the mean pixel that is
     * defined in the MaskRCNNSegmentationSettings.
     * @param originalImage Image to convert to Tensor.
     * @return Tensor representation of image.
     */
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

    /**
     * Convenience method to call the generic generateSegmentationAnnotations() method.
     * @param images list of rdfIds for images to be segmented using MaskRCNN.
     * @param segModel Segmentation Model?
     * @param modelContainingExclusionModel An exclusion model, used to focus on only the area of interest (e.g.
     *                                      ignore artifacts, blank area) and (probably) speed up the calculation
     *                                      by ignoring uninteresting areas.
     * @param storeAnnotations Should the annotations be stored back to the Orbit DB?
     * @param tile The tile coordinates for processing a specific image tile only.
     * @return Map with RdfId as key and annotations as List<Shape> (segmentationsPerImage).
     */
    @Override
    public Map<Integer, List<Shape>> generateSegmentationAnnotations(int[] images, OrbitModel segModel, OrbitModel modelContainingExclusionModel, boolean storeAnnotations, Point tile) {
        List<RawDataFile> rdfList = new ArrayList<>(images.length);
        try {
            for (int image : images) {
                rdfList.add(DALConfig.getImageProvider().LoadRawDataFile(image));
            }
        } catch (Exception ex) {
            logger.error("Could not read Raw Data File");
            logger.error(ex.getLocalizedMessage());
        }
        return generateSegmentationAnnotations(rdfList,segModel,modelContainingExclusionModel,storeAnnotations, tile);
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
        return generateSegmentationAnnotations(images,segModel,modelContainingExclusionModel,storeAnnotations, null);
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
    public Map<Integer, List<Shape>> generateSegmentationAnnotations(List<RawDataFile> rdfList, OrbitModel segModel, OrbitModel modelContainingExclusionModel, boolean storeAnnotations, Point tileOnly) {

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
            // TODO: Re-enable when JAI issue is fixed.
//            if (modelContainingExclusionModel != null && modelContainingExclusionModel.getExclusionModel() != null) {
//                exclusionMapGen = ExclusionMapGen.constructExclusionMap(rdf, rf, modelContainingExclusionModel);
//                if (exclusionMapGen != null) {
//                    try {
//                        exclusionMapGen.generateMap();
//                    } catch (OrbitImageServletException e) {
//                        logger.error(e.getLocalizedMessage());
//                    }
//                }
//            }

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
                        Point tileOffset = new Point(orbitImage.tileXToX(tile.x), orbitImage.tileYToY(tile.y));

                        // TODO: Should return the same types at the end.
                        MaskRCNNDetections detections = null;
                        SegmentationResult segRes = null;

                        switch (this.postProcess) {
                            case STANDARD:
                                // Apply segmentation model to the tile image.
                                try {
                                    detections = this.segmentTile(tile.x, tile.y, orbitImage, segModel, false, tileOffset);
                                    //detections = this.processDetections(segRes);
                                    //List<Shape> shapes = segRes.getShapeList();
                                    logger.info(detections.toString());
                                } catch (Exception e) {
                                    logger.error(e.getLocalizedMessage());
                                }

                                if (segRes != null) {
                                    logger.info("ObjectCount: " + Objects.requireNonNull(segRes).getObjectCount() + " for tile " + tile.x + " x " + tile.y);
                                } else {
                                    logger.info("Segmentation model not defined, not applying segmentation model.");
                                }
                                break;
                            case CUSTOM:
                                // Apply MaskRCNN raw detection model to tile.
                                RawDetections rawDetections = this.getMaskRCNNRawDetections(tile, orbitImage);
                                detections = this.processDetections(rawDetections, tileOffset);
                                logger.info(detections.toString());
                                break;
                        }

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
                                    this.storeShapes(detections, "Islet_", segmentationSettings, rdfId, "AutomatedAnnotation");
                                } else {
                                    this.storeShapes(detections, "Islet_", segmentationSettings, rdfId, "AutomatedAnnotation");
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


    /**
     * Convert input tileRaster to image, then tensor. Apply MaskRCNN model to the image tensor.
     * @param inputTileRaster Image to detect objects.
     * @param orbitImage Orbit Image for extracting color model.
     * @param writeImg Optionally write a test image for debugging purposes.
     * @param segmentationSettings The settings used for the MaskRCNN segmentation.
     * @return BufferedImage.TYPE_INT_RGB black and white image, with black as background, and white as foreground
     *          (i.e. detected objects). Size should be the same as the input images for training
     *          (see segmentationSettings imageWidth x imageHeight).
     */
    public BufferedImage maskRaster(Raster inputTileRaster, OrbitTiledImageIOrbitImage orbitImage, boolean writeImg, MaskRCNNSegmentationSettings segmentationSettings) {
        WritableRaster tileRaster = (WritableRaster) inputTileRaster.createTranslatedChild(0, 0);
        BufferedImage ori = new BufferedImage(orbitImage.getColorModel(), tileRaster, false, null);
        ori = DLHelpers.shrink(ori, segmentationSettings);

        // color-deconvolution
        if (segmentationSettings.getDeconvolution()) {
            ori = Colour_Deconvolution.getProcessedImage(ori, segmentationSettings.getDeconvolutionName(), segmentationSettings.getDeconvolutionChannel() - 1, ori);
        }

        Tensor<Float> inputTensor = DLHelpers.convertBufferedImageToTensor(ori,segmentationSettings.getImageWidth(),segmentationSettings.getImageHeight());
        long startt = System.currentTimeMillis();

        // TODO: Extract this from the method?
        // Apply MaskRCNN model.
        RawDetections rawDetections = this.getMaskRCNNRawDetections(inputTensor);

        // Convert the Raw Detections into a black and white image, with foreground objects coloured white.
        BufferedImage roi = null;
        if (ori != null) {
            // masks    [1][512][28][28][2]
            float[][][] mask = rawDetections.masks[0][0];
            int rw = mask[0].length;
            int rh = mask.length;

            roi = new BufferedImage(rw,rh,BufferedImage.TYPE_INT_RGB);
            for (int xr=0; xr<rw; xr++) {
                for (int yr=0; yr<rh; yr++) {
                    float backgroundProbability = mask[yr][xr][0];
                    float maxClassProbability = 0;
                    for (int classes=1; classes<segmentationSettings.getNumClasses(); classes++) {
                        if (maxClassProbability < mask[yr][xr][classes]) {
                            maxClassProbability = mask[yr][xr][classes];
                        }
                    }
                    if (maxClassProbability > backgroundProbability && maxClassProbability > 0.5f)
                        // TODO: This logic is probably wrong since could mix a class 1 and class 2 prediction to make a bigger area.
                        // TODO: Should probabilities sum to 1?
                        // So we need to output one roi per class...
                    //if (mask[yr][xr][1]>0.45f)
                        // TODO: Test other thresholds for foreground vs. background.
                    // if (mask[yr][xr][0]<mask[yr][xr][1])
                    //if (mask[yr][xr][0]<mask[yr][xr][1] && mask[yr][xr][1]>0.5f)
                    {
                        roi.setRGB(xr,yr,Color.WHITE.getRGB());
                    }
                }
            }
        }

        // Resize the 'mask' to the 'image' size.
        ////roi = resize(roi);

        long usedt = System.currentTimeMillis()-startt;
        logger.info("segment time (s): "+usedt/1000d);

        // TODO: Move this to a test.
        if (writeImg) {
            try {
                int tx = orbitImage.XToTileX(inputTileRaster.getMinX());
                int ty = orbitImage.YToTileY(inputTileRaster.getMinY());
                // Write the input image to temp file.
                ImageIO.write(Objects.requireNonNull(ori), "jpeg", File.createTempFile(String.format("orbit-debug-image%s-tile%dx%d", File.separator, tx, ty),".jpg"));
                // Write the segmented mask to temp file.
                ImageIO.write(Objects.requireNonNull(roi), "jpeg", File.createTempFile(String.format("orbit-debug-image%s-tile%dx%d-roi", File.separator, tx, ty),".jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return roi;
    }

    protected BufferedImage getShiftedMask(OrbitTiledImageIOrbitImage orbitImage, Raster tileRaster, BufferedImage maskOriginal, int dx, int dy, MaskRCNNSegmentationSettings segmentationSettings) {
        Rectangle rect = tileRaster.getBounds();
        rect.translate(dx,dy);
        if (!orbitImage.getBounds().contains(rect)) {
            return maskOriginal;
        }
        try {
            Raster shiftraster = orbitImage.getData(rect);
            if (segmentationSettings.getAugmentationSettings().getFlip()) {
                shiftraster = flipRaster(shiftraster);
            }
            BufferedImage mask2 = maskRaster(shiftraster, orbitImage, false, segmentationSettings);
            if (segmentationSettings.getAugmentationSettings().getFlip()) {
                mask2 = flipImage(mask2);
            }
//            maskOriginal = combineMasks(maskOriginal, mask2, dx / segmentationSettings.getAugmentationSettings().getScaleFactor(), dy / segmentationSettings.getAugmentationSettings().getScaleFactor());
            maskOriginal = combineMasks(maskOriginal, mask2, dx, dy );
        } catch (Exception e) {
            logger.warn("Could not shift raster, returning original image (rect="+rect+" img.bounds="+orbitImage.getBounds()+")", e);
        }
        return maskOriginal;
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
    public MaskRCNNDetections segmentTile(int tileX, int tileY, OrbitTiledImageIOrbitImage orbitImage, OrbitModel segModel, boolean writeImg, Point tileOffset) {
        // Read the tile. (8192 x 8192...)
        Raster tileRaster = orbitImage.getTile(tileX, tileY);
        BufferedImage maskOriginal = maskRaster(tileRaster,orbitImage, writeImg, segmentationSettings);

        // Shift the tile half the tile width up, down, left and right.
        int xShift = 4096; //segmentationSettings.getImageWidth()/2;
        int yShift = 4096; //segmentationSettings.getImageHeight()/2;
        maskOriginal = getShiftedMask(orbitImage, tileRaster, maskOriginal, 0, yShift, segmentationSettings);
        maskOriginal = getShiftedMask(orbitImage, tileRaster, maskOriginal, 0, -yShift, segmentationSettings);
        maskOriginal = getShiftedMask(orbitImage, tileRaster, maskOriginal, xShift, 0, segmentationSettings);
        maskOriginal = getShiftedMask(orbitImage, tileRaster, maskOriginal, -xShift, 0, segmentationSettings);

        MaskRCNNDetections detections = null;
        try {
            SegmentationResult segmentationResult = this.getSegmentationResult(segModel, maskOriginal);
            detections = processDetections(segmentationResult, tileOffset);
        } catch (OrbitImageServletException e) {
            logger.error(e.getLocalizedMessage());
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


    // TODO: Rename method.
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

    /**
     * Convenience method for processing detections from a tile-based image server.
     * @param rawDetections Raw detections from MaskRCNN.
     * @param tileOffset The offset
     * @return Processed detections.
     */
    public MaskRCNNDetections processDetections(RawDetections rawDetections, Point tileOffset) {
        return processDetections(segmentationSettings.getImageWidth(), segmentationSettings.getImageHeight(), rawDetections, tileOffset);
    }

    /**
     * Convenience method for processing detections from a single image with no offset (e.g. not from a
     * tile-based image server).
     * @param imgWidth Width of image being processed (px).
     * @param imgHeight Height of image being processed (px).
     * @param rawDetections Raw detections from MaskRCNN.
     * @return Processed detections.
     */
    public MaskRCNNDetections processDetections(int imgWidth, int imgHeight, RawDetections rawDetections) {
        Point tileOffset = new Point(0,0);
        return processDetections(imgWidth, imgHeight, rawDetections, tileOffset);
    }

    /**
     * Method for processing detections an image from MaskRCNN.
     * This method is broadly similar to the techniques used in:
     * https://github.com/matterport/Mask_RCNN
     * @param imgWidth Width of image being processed (px).
     * @param imgHeight Height of image being processed (px).
     * @param rawDetections Raw detections from MaskRCNN.
     * @param tileOffset The offset
     * @return Processed detections.
     */
    public MaskRCNNDetections processDetections(int imgWidth, int imgHeight, RawDetections rawDetections, Point tileOffset) {
        MaskRCNNDetections detections = new MaskRCNNDetections();

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

                    // The polygon must be scaled correctly now, so that it is stored correctly later.
                    polygon = polygon.scale(segmentationSettings.getTileScaleFactorPercent(), new Point(0,0));

                    // Translate the image based on it's location in the whole slide image.
                    polygon.translate(tileOffset.x, tileOffset.y);

                    detections.addDetection(polygon, boundingBox, probability, maskClass, tileOffset);

                }


            }
        }
        return detections;
    }


    /**
     * Method for processing detections using in-built Orbit functionality to process a mask from MaskRCNN.
     * @param segRes An Orbit SegmentationResult
     * @return Processed detections.
     */
    @Override
    public MaskRCNNDetections processDetections(SegmentationResult segRes, Point tileOffset) {
        MaskRCNNDetections detections = new MaskRCNNDetections();
        List<Shape> shapes = segRes.getShapeList();
        for (Shape shape : shapes) {
            PolygonExt polygon = (PolygonExt) shape;
            polygon.setClosed(true);

            // Rescale the shape to display properly on the whole slide image.
            polygon = polygon.scale(segmentationSettings.getTileScaleFactorPercent(), new Point(0,0));

            // Translate the image based on it's location in the whole slide image.
            polygon.translate(tileOffset.x, tileOffset.y);

            detections.addDetection(polygon,null,null,1, tileOffset);
        }
        return detections;
    }

    /**
     * Get the segmentation settings used by the MaskRCNN model.
     * @return Segmentation Settings for MaskRCNN model.
     */
    public MaskRCNNSegmentationSettings getSegmentationSettings() {
        return segmentationSettings;
    }
}
