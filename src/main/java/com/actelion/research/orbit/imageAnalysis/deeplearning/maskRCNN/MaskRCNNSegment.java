package com.actelion.research.orbit.imageAnalysis.deeplearning.maskRCNN;

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.deeplearning.AbstractDetections;
import com.actelion.research.orbit.imageAnalysis.deeplearning.AbstractSegment;
import com.actelion.research.orbit.imageAnalysis.deeplearning.AbstractSegmentationSettings;
import com.actelion.research.orbit.imageAnalysis.deeplearning.DLHelpers;
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.utils.*;

import ij.ImagePlus;
import ij.plugin.filter.GaussianBlur;
import imageJ.Colour_Deconvolution;
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

import static com.actelion.research.orbit.imageAnalysis.deeplearning.DLHelpers.*;

/**
 * MaskRCNNSegment class for applying MaskRCNN Segmentation models, and keeping track of the
 * settings used.
 * We assume an implementation of MaskRCNN similar to: https://github.com/matterport/Mask_RCNN
 */
public class MaskRCNNSegment extends AbstractSegment<MaskRCNNDetections, MaskRCNNSegmentationSettings> {
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
        super(settings);
        logger = LoggerFactory.getLogger(MaskRCNNSegment.class);
        s = DLHelpers.buildSession(maskRCNNModelPB.getAbsolutePath());
        postProcess = ppm;
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
    public MaskRCNNRawDetections getMaskRCNNRawDetections(final Tensor<Float> input) {
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
    public MaskRCNNRawDetections getMaskRCNNRawDetections(final Point tileCoords, OrbitTiledImageIOrbitImage orbitImage) {

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
    public MaskRCNNRawDetections getMaskRCNNRawDetections(final Tensor<Float> inputTensor, final int inputWidth, final int inputHeight, final int maxDetections, final int maskWidth, final int maskHeight, final int numClasses) {
        // image metas
        //  meta = np.array(
        //        [image_id] +                  # size=1
        //        list(original_image_shape) +  # size=3
        //        list(image_shape) +           # size=3
        //        list(window) +                # size=4 (y1, x1, y2, x2) in image coordinates
        //        [scale[0]] +                     # size=1 NO LONGER, I dont have time to correct this properly so take only the first element
        //        list(active_class_ids)        # size=num_classes
        //    )
        int metaLength = 12 + numClasses;
        FloatBuffer metas = FloatBuffer.allocate(metaLength);
        metas.put(new float[]{
                0,
                inputWidth,inputHeight,3,
                inputWidth,inputHeight,3,
                0,0,inputWidth,inputHeight,
                1
        });
        for(int i=0; i<numClasses; i++) {
            metas.put(0f);
        }
        metas.rewind();

        final Tensor<Float> meta_data = Tensor.create(new long[]{1,metaLength},metas);

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

        MaskRCNNRawDetections rawDetections = new MaskRCNNRawDetections();
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

//    @Override
//    public Map<Integer, List<Shape>> generateSegmentationAnnotations(List<RawDataFile> rdfList, OrbitModel segModel, OrbitModel modelContainingExclusionModel, boolean storeAnnotations, Point tile) {
//        super.g
//    }


    @Override
    public Map<Integer, List<Shape>> generateSegmentationAnnotations(List<RawDataFile> rdfList, OrbitModel segModel, OrbitModel modelContainingExclusionModel, boolean storeAnnotations, Point tile) {
        return null;
    }



    @Override
    public MaskRCNNDetections segmentationImplementation(OrbitModel segModel, OrbitTiledImageIOrbitImage orbitImage, Point tile) {
        Point tileOffset = new Point(orbitImage.tileXToX(tile.x), orbitImage.tileYToY(tile.y));

        MaskRCNNDetections detections = null;

        switch (this.postProcess) {
            case STANDARD:
                // Apply segmentation model to the tile image.
                try {
                    detections = this.segmentTile(tile.x, tile.y, orbitImage, segModel, false, tileOffset);
                    logger.info(detections.toString());
                } catch (Exception e) {
                    logger.error(e.getLocalizedMessage());
                }

                break;
            case CUSTOM:
                // Apply MaskRCNN raw detection model to tile.
                MaskRCNNRawDetections rawDetections = this.getMaskRCNNRawDetections(tile, orbitImage);
                detections = this.processDetections(rawDetections, tileOffset);
                logger.info(detections.toString());
                break;
        }
        return detections;
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

        // Apply MaskRCNN model.
        MaskRCNNRawDetections rawDetections = this.getMaskRCNNRawDetections(inputTensor);

        // Convert the Raw Detections into a black and white image, with foreground objects coloured white.
        BufferedImage roi = null;
        BufferedImage detections = new BufferedImage(segmentationSettings.getImageWidth(),segmentationSettings.getImageHeight(),BufferedImage.TYPE_INT_RGB);
        if (ori != null) {
            for (int i = 0; i < rawDetections.getNumBoundingBoxes(); i++) {
                if (rawDetections.getBoundingBoxProbability(i) > segmentationSettings.getBoundingBoxProbabilityThreshold() && (rawDetections.getBoundingBoxArea(i) > segmentationSettings.getMinimumAreaThreshold())) {
                    // Rescale the bounding box to the tile.
                    RectangleExt boundingBox = rawDetections.getRescaledBoundingBox(i, segmentationSettings.getImageWidth(), segmentationSettings.getImageHeight());

                    int rw = rawDetections.getMaskWidth(i);
                    int rh = rawDetections.getMaskHeight(i);

                    roi = new BufferedImage(rw, rh, BufferedImage.TYPE_INT_ARGB);
                    for (int xr = 0; xr < rw; xr++) {
                        for (int yr = 0; yr < rh; yr++) {
                            float backgroundProbability = rawDetections.getMaskPixelProbability(i, xr, yr, 0);

                            float pixelProbability = rawDetections.getMaskPixelProbability(i, xr, yr, rawDetections.getBoundingBoxClass(i));
                            if (pixelProbability > backgroundProbability && pixelProbability > 0.5f) {
                                roi.setRGB(xr, yr, Color.WHITE.getRGB());//segmentationSettings.getAnnotationColor(rawDetections.getBoundingBoxClass(i)).getRGB());
                            }
                        }
                    }
                    // scale mask to bb size
                    BufferedImage roiScaled = new BufferedImage(boundingBox.width,boundingBox.height,BufferedImage.TYPE_INT_RGB);
                    Graphics2D roiG = roiScaled.createGraphics();
                    roiG.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    roiG.drawImage(roi,0,0,boundingBox.width,boundingBox.height,null);
                    roiG.dispose();

                    Graphics2D roiG2 = detections.createGraphics();
                    roiG2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    roiG2.drawImage(roiScaled,boundingBox.x,boundingBox.y,null);
                    roiG2.dispose();
                }



                long usedt = System.currentTimeMillis() - startt;
                logger.info("segment time (s): " + usedt / 1000d);

                // TODO: Move this to a test.
                if (writeImg) {
                    try {
                        int tx = orbitImage.XToTileX(inputTileRaster.getMinX());
                        int ty = orbitImage.YToTileY(inputTileRaster.getMinY());
                        // Write the input image to temp file.
                        ImageIO.write(Objects.requireNonNull(ori), "jpeg", File.createTempFile(String.format("orbit-debug-image%s-tile%dx%d", File.separator, tx, ty), ".jpg"));
                        // Write the segmented mask to temp file.
                        ImageIO.write(Objects.requireNonNull(roi), "jpeg", File.createTempFile(String.format("orbit-debug-image%s-tile%dx%d-roi", File.separator, tx, ty), ".jpg"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return detections;
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
        int xShift = (int) (segmentationSettings.getImageWidth() * segmentationSettings.getTileScaleFactorX()/2); //4096; //segmentationSettings.getImageWidth()/2;
        int yShift = (int) (segmentationSettings.getImageHeight() * segmentationSettings.getTileScaleFactorY()/2); //4096; //segmentationSettings.getImageHeight()/2;
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




    /**
     * Convenience method for processing detections from a tile-based image server.
     * @param rawDetections Raw detections from MaskRCNN.
     * @param tileOffset The offset
     * @return Processed detections.
     */
    public MaskRCNNDetections processDetections(MaskRCNNRawDetections rawDetections, Point tileOffset) {
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
    public MaskRCNNDetections processDetections(int imgWidth, int imgHeight, MaskRCNNRawDetections rawDetections) {
        Point tileOffset = new Point(0,0);
        return processDetections(imgWidth, imgHeight, rawDetections, tileOffset);
    }


    public MaskRCNNDetections processDetections(int imgWidth, int imgHeight, MaskRCNNRawDetections rawDetections, Point tileOffset) {
        return processDetections(imgWidth, imgHeight, rawDetections, new Rectangle(), new Point2D.Float(0f,0f), tileOffset);
    }

    /**
     * Method for processing detections an image from MaskRCNN.
     * This method is broadly similar to the techniques used in:
     * https://github.com/matterport/Mask_RCNN
     * Used by the CUSTOM segmentation method. Applies Marching
     * Squares to define contours to define the annotations.
     * @param imgWidth Width of image being processed (px).
     * @param imgHeight Height of image being processed (px).
     * @param rawDetections Raw detections from MaskRCNN.
     * @param subImageBoundingBox
     * @param scaleFactor
     * @param tileOffset The offset
     * @return Processed detections.
     */
    public MaskRCNNDetections processDetections(int imgWidth, int imgHeight, MaskRCNNRawDetections rawDetections, Rectangle subImageBoundingBox, Point2D scaleFactor, Point tileOffset) {
        MaskRCNNDetections detections = new MaskRCNNDetections();

        for (int i=0; i<rawDetections.getNumBoundingBoxes(); i++) {
            if (rawDetections.getBoundingBoxProbability(i)>segmentationSettings.getBoundingBoxProbabilityThreshold() && (rawDetections.getBoundingBoxArea(i)>segmentationSettings.getMinimumAreaThreshold()))  {    // probability > 0.8 and area > 1E-5
                // Set probability and class of detection
                float probability = rawDetections.getBoundingBoxProbability(i);
                int maskClass = rawDetections.getBoundingBoxClass(i);

                // Rescale the bounding box to the tile.
                RectangleExt boundingBox = rawDetections.getRescaledBoundingBox(i, imgWidth, imgHeight);

                int rw = rawDetections.getMaskWidth(i);
                int rh = rawDetections.getMaskHeight(i);

                BufferedImage roi = new BufferedImage(rw,rh,BufferedImage.TYPE_INT_ARGB);
                for (int xr=0; xr<rw; xr++) {
                    for (int yr=0; yr<rh; yr++) {
                        if (rawDetections.getMaskPixelProbability(i, xr, yr, rawDetections.getBoundingBoxClass(i)) > segmentationSettings.getPixelProbabilityThreshold())
                        // if (mask[yr][xr][0]<mask[yr][xr][1])
                        //if (mask[yr][xr][0]<mask[yr][xr][1] && mask[yr][xr][1]>0.5f)
                        {
                            roi.setRGB(xr,yr,Color.MAGENTA.getRGB());
                        }
                    }
                }
                // scale mask to bb size
                BufferedImage roiScaled = new BufferedImage(boundingBox.width,boundingBox.height,BufferedImage.TYPE_INT_RGB);
                Graphics2D roiG = roiScaled.createGraphics();
                roiG.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                roiG.drawImage(roi,0,0,boundingBox.width,boundingBox.height,null);
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
                if (MarchingSquares.calculateContour(contour, area, 1, segmentationSettings.getMarchingSquaresContourThreshold())) {
                    int[] xpoints = new int[contour.size()];
                    int[] ypoints = new int[contour.size()];
                    for (int j=0; j<contour.size(); j++) {
                        xpoints[j] = (int)(boundingBox.x + ((contour.get(j).getX()-pad) * 1f));
                        ypoints[j] = (int)(boundingBox.y + ((contour.get(j).getY()-pad) * 1f));
                    }
                    PolygonExt polygon = new PolygonExt(new Polygon(xpoints,ypoints, xpoints.length));
                    PolygonExt polyScaled =  new PolygonExt();

                    // The polygon must be scaled correctly now, so that it is stored correctly later.
                    if (segmentationSettings.getTileScaleFactorX() == segmentationSettings.getTileScaleFactorY()) {
                        polygon = polygon.scale(segmentationSettings.getTileScaleFactorXPercent(), new Point(0,0));

                        // Translate the image based on it's location in the whole slide image.
                        polygon.translate(tileOffset.x, tileOffset.y);
                        polygon.setClosed(true);
                        polygon.setOnlyPoints(false);
                        RectangleExt pBB = new RectangleExt(polygon.getBounds().x, polygon.getBounds().y, polygon.getBounds().width, polygon.getBounds().height);
                        detections.addDetection(polygon, pBB, probability, maskClass, tileOffset);
                    } else {
                        //polyScaled.setScale(polygon.getScale());
                        for (int k = 0; k < polygon.npoints; k++) {
//                            polyScaled.addPoint((int) ((polygon.xpoints[k] * segmentationSettings.getTileScaleFactorX()+boundingBox.x)*tileOffset.x), (int) (((polygon.ypoints[k] * segmentationSettings.getTileScaleFactorY()+boundingBox.y)*tileOffset.y)));
                            polyScaled.addPoint(
                                    (int) ((polygon.xpoints[k] * segmentationSettings.getTileScaleFactorX() + subImageBoundingBox.x) * scaleFactor.getX()),
                                    (int) ((polygon.ypoints[k] * segmentationSettings.getTileScaleFactorY() + subImageBoundingBox.y) * scaleFactor.getY()));

                        }
                        polyScaled.translate(tileOffset.x, tileOffset.y);
                        polyScaled.setClosed(true);
                        polyScaled.setOnlyPoints(false);
                        RectangleExt pBB = new RectangleExt(polyScaled.getBounds().x, polyScaled.getBounds().y, polyScaled.getBounds().width, polyScaled.getBounds().height);
                        detections.addDetection(polyScaled, pBB, probability, maskClass, tileOffset);
                    }



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
            polygon = polygon.scale(segmentationSettings.getTileScaleFactorXPercent(), new Point(0,0));

            // Translate the image based on it's location in the whole slide image.
            polygon.translate(tileOffset.x, tileOffset.y);

            // TODO: Assign the correct bounding box, probability and class.
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
