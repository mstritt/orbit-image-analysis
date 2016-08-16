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

package com.actelion.research.orbit.imageAnalysis.utils;

import com.actelion.research.orbit.beans.RawAnnotation;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.components.DefaultRDFChooser;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.tasks.ClassificationTaskTiled;
import com.actelion.research.orbit.imageAnalysis.tasks.ExclusionMapGen;
import com.actelion.research.orbit.imageAnalysis.tasks.ObjectClassificationWorker;
import com.actelion.research.orbit.imageAnalysis.tasks.ObjectSegmentationWorker;
import com.actelion.research.orbit.imageAnalysis.tasks.histogram.Histogram;
import com.actelion.research.orbit.utils.RawUtilsCommon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import java.util.List;

public class OrbitHelper {

    private static final Logger log = LoggerFactory.getLogger(OrbitHelper.class);

    static {
        System.setProperty("com.sun.media.jai.disableMediaLib", "true");
    }

    /**
     * Encodes an (tiled) image in several rdfID#tileX1,tileY1;tileX2,tileY2;... strings.
     *
     * @param rdfList list of RawDataFiles
     * @return
     * @aram tileChunkSize defines the number of tiles per package (encoded string).
     */
    public static List<String> EncodeImageTiles(int tileChunkSize, int imageLevel, final List<RawDataFile> rdfList) throws OrbitImageServletException {
        return EncodeImageTiles(null, tileChunkSize, imageLevel, rdfList.toArray(new RawDataFile[0]));
    }

    /**
     * Encodes an (tiled) image in several rdfID#tileX1,tileY1;tileX2,tileY2;... strings.
     *
     * @param rdfList list of RawDataFiles
     * @return
     * @aram tileChunkSize defines the number of tiles per package (encoded string).
     */
    public static List<String> EncodeImageTiles(int tileChunkSize, int imageLevel, final RawDataFile... rdfList) throws OrbitImageServletException {
        return EncodeImageTiles(null, tileChunkSize, imageLevel, rdfList);
    }


    /**
     * Encodes an (tiled) image and a model filename in several rdfID#tileX1,tileY1;tileX2,tileY2;...#model strings.
     * Use -1 as chunkSize for a pseudo marker to use all tiles of the image.
     *
     * @param rdfList list of RawDataFiles
     * @param model   the model filename (with or without path). Must not contain spaces.
     * @return
     * @aram tileChunkSize defines the number of tiles per package (encoded string).
     */
    public static List<String> EncodeImageTiles(String model, int tileChunkSize, int imageLevel, final List<RawDataFile> rdfList) throws OrbitImageServletException {
        return EncodeImageTiles(model, tileChunkSize, imageLevel, rdfList.toArray(new RawDataFile[0]));
    }

    /**
     * Encodes an (tiled) image and a model filename in several rdfID#tileX1,tileY1;tileX2,tileY2;...#model strings.
     * Use -1 as chunkSize for a pseudo marker to use all tiles of the image.
     *
     * @param rdfList list of RawDataFiles
     * @param model   the model filename (with or without path). Must not contain spaces.
     * @return
     * @aram tileChunkSize defines the number of tiles per package (encoded string).
     */
    public static List<String> EncodeImageTiles(String model, int tileChunkSize, int imageLevel, final RawDataFile... rdfList) throws OrbitImageServletException {
        return EncodeImageTiles(model, null, tileChunkSize, imageLevel, false, false, rdfList);
    }

        /**
         * Encodes an (tiled) image and a model filename in several rdfID#tileX1,tileY1;tileX2,tileY2;...#model strings.
         * Use -1 as chunkSize for a pseudo marker to use all tiles of the image.
         *
         * @param rdfList list of RawDataFiles
         * @param model   the model filename (with or without path). Must not contain spaces.
         * @return
         * @aram tileChunkSize defines the number of tiles per package (encoded string).
         */
        public static List<String> EncodeImageTiles(String model, OrbitModel roiModel, int parallelism, int imageLevel, boolean onlyTilesInRoi, boolean skipNonExplicitROIImages, final RawDataFile... rdfList) throws OrbitImageServletException {
            Map<RawDataFile,List<Point>> tileMap = new HashMap<>();
            int totalCnt = 0;
            for (RawDataFile rdf : rdfList) {
            boolean found = false;
            try {
                List<RawAnnotation> annos = DALConfig.getImageProvider().LoadRawAnnotationsByRawDataFile(rdf.getRawDataFileId(), RawAnnotation.ANNOTATION_TYPE_IMAGE);
                for (RawAnnotation anno : annos) {
                    ImageAnnotation ia = new ImageAnnotation(anno);
                    if ((ia.getSubType() == ImageAnnotation.SUBTYPE_ROI) && (roiModel == null || roiModel.getAnnotationGroup() <= 0 || roiModel.getAnnotationGroup() == ia.getGroup())) {
                        found = true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (skipNonExplicitROIImages && !found) continue;

            tileMap.put(rdf,new ArrayList<Point>());
            RecognitionFrame rf;
            if (imageLevel <= 0) {
                rf = new RecognitionFrame(rdf, false);
            } else {
                rf = new RecognitionFrame(null, rdf, imageLevel - 1); // -1 because imageLEvel is number, not index
            }
            Point[] tileIndices;
            Rectangle roi = null;
            if (onlyTilesInRoi && roiModel!=null) {
                rf.loadAnnotationROI(rdf.getRawDataFileId(), roiModel.getAnnotationGroup());
                if (rf.getROI()!=null) {
                    roi = rf.getROI().getScaledInstance(100d, new Point(0, 0)).getBounds();
                }
            }
            if (parallelism > 0) tileIndices = rf.bimg.getImage().getTileIndices(roi);
            else
                tileIndices = new Point[]{new Point(-1, -1)};  // dummy marker for all tiles (used for exclusion model quantification)
            for (Point tile : tileIndices) {
                tileMap.get(rdf).add(tile);
                totalCnt++;
            }
        }


        int chunksize = 100;
        if (parallelism>0) chunksize = totalCnt / parallelism;
        List<String> imageList = new ArrayList<String>();
        for (RawDataFile rdf: tileMap.keySet()) {
            List<Point> tiles = tileMap.get(rdf);
            if (tiles.size()>0) {
                Collections.shuffle(tiles);  // very fast tiles (e.g. just background) and long running tiles should be mixed for average job runtime
                List<Point> localList = new ArrayList<Point>();
                for (Point tile : tiles) {
                    localList.add(tile);
                    if (localList.size() >= chunksize) {
                        imageList.add(new ImageTile(rdf.getRawDataFileId(), localList, model).toString());
                        localList = new ArrayList<Point>();
                    }
                }
                if (localList.size() > 0) {
                    imageList.add(new ImageTile(rdf.getRawDataFileId(), localList, model).toString());
                }
            }
        }
        log.debug("imageList chunks: "+imageList.size());
        return imageList;
    }


    /********************************************************************/
    /***** Cell Segmentation ********************************************/
    /********************************************************************/


    public static SegmentationResult Segmentation(final int rdfId, final int modelId) throws Exception {
        return Segmentation(rdfId, OrbitModel.LoadFromOrbit(modelId), null, -1);
    }


    public static SegmentationResult Segmentation(final int rdfId, final int modelId, List<Point> tiles) throws Exception {
        return Segmentation(rdfId, OrbitModel.LoadFromOrbit(modelId), tiles, -1);
    }

    /**
     * set numThreads=-1 for availableProcessors
     */
    public static SegmentationResult Segmentation(final int rdfId, final OrbitModel model, List<Point> tiles, int numThreads) throws Exception {
        final RawDataFile rdf = DALConfig.getImageProvider().LoadRawDataFile(rdfId);
        return Segmentation(rdf, model, tiles, numThreads);
    }

    public static SegmentationResult Segmentation(final RawDataFile rdf, final OrbitModel model, List<Point> tiles, int numThreads) throws OrbitImageServletException {
        RecognitionFrame rf = new RecognitionFrame(rdf, false);
        return Segmentation(rf, rdf.getRawDataFileId(), model, tiles, numThreads, true);
    }

    public static SegmentationResult Segmentation(RecognitionFrame rf, int rdfId, final OrbitModel model, List<Point> tiles, int numThreads, boolean newMipRf) throws OrbitImageServletException {
        return Segmentation(rf, rdfId, model, tiles, numThreads, newMipRf, null);
    }

    /**
     * If roi!=null the parameter roi is used, otherwise it tries to load the annotationROI.
     */
    public static SegmentationResult Segmentation(RecognitionFrame rf, int rdfId, final OrbitModel model, List<Point> tiles, int numThreads, boolean newMipRf, IScaleableShape roi) throws OrbitImageServletException {
        rf.setClassShapes(model.getSegmentationModel().getClassShapes());     //  22.09.2015
        rf.setWindowSize(model.getFeatureDescription().getWindowSize());
        rf.setBoundaryClass(model.getBoundaryClass());
        rf.setFeatureDescription(model.getFeatureDescription()); // Manuel 27.06.2012
        int annoGroup = model.getAnnotationGroup();
        if (annoGroup < 0 && model.isLoadAnnotationsAsInversROI()) {
            annoGroup = 0;// 0 means all
        }
        if (roi == null) {
            if (rdfId >= 0)
                rf.loadAnnotationROI(rdfId, annoGroup);
        } else rf.setROI(roi);

        RawDataFile rdf = null;
        if (rdfId > 0) {
            try {
                rdf = DALConfig.getImageProvider().LoadRawDataFile(rdfId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        RecognitionFrame oriRf = null;
        if (newMipRf) {
            oriRf = rf;
            if (model.getSegmentationModel().getMipLayer() > 0) {      // upd 22.09.2015 (.getSegModel)
                // attention: currently miplayers only work in combination with an image server (not local files)!
                rf = new RecognitionFrame(rf, rdf, model.getSegmentationModel().getMipLayer() - 1);    // mip number, not index
            }
        }

        ExclusionMapGen exMap = ExclusionMapGen.constructExclusionMap(rdf, rf, model, rf.getROI());
        if (exMap != null) {
            exMap.setNumThreads(1);
            exMap.setKeepVisualClassificationImage(false);
            exMap.setDoNormalize(false);
            exMap.generateMap();
        }


        // cellSegmentation
        ObjectSegmentationWorker segWorker = new ObjectSegmentationWorker(rf, null, model.getSegmentationModel().getClassShapes(), tiles);
        segWorker.setModel(model);
        segWorker.setExclusionMap(exMap);
        if (numThreads > 0) {
            segWorker.setNumThreads(numThreads);
        }
        if (oriRf != null) {
            segWorker.setDontClassify(false);
            segWorker.setOriginalFrame(oriRf);
        }
        segWorker.run();

        // TODO: cell features???
        //System.out.println(segWorker.getSegmentationResult().get);
        String taskRes = segWorker.getTaskResult() != null ? segWorker.getTaskResult().getResultStr() : "No segmentation reuslt";
        System.out.println("TaskResult:\n" + taskRes);

        SegmentationResult sr = segWorker.getSegmentationResult();
        if (oriRf != null) {
            sr.setShapeList(oriRf.getObjectSegmentationList());
            sr.setSecondaryShapeList(oriRf.getSecondaryObjectSegmentationList());
            // sr.setFeatureList(...);    not possible right now, features are computed on lower scale, maybe recompute them on full res ???
        }

        return sr;
    }


    /********************************************************************/
    /***** Cell Classification ******************************************/
    /********************************************************************/


    /**
     * set numThreads=-1 for availableProcessors
     */
    public static ClassificationResult CellClassification(final int rdfId, final OrbitModel model, List<Point> tiles, int numThreads) throws Exception {
        final RawDataFile rdf = DALConfig.getImageProvider().LoadRawDataFile(rdfId);
        return CellClassification(rdf, model, tiles, numThreads);
    }


    public static ClassificationResult CellClassification(final RawDataFile rdf, final OrbitModel model, List<Point> tiles, int numThreads) throws OrbitImageServletException {
        RecognitionFrame rf = new RecognitionFrame(rdf, false);
        if (model.getMipLayer() > 0) {
            rf = new RecognitionFrame(rf, rdf, model.getMipLayer() - 1);    // mip number, not index
        }
        SegmentationResult segmentationResult = Segmentation(rf, rdf.getRawDataFileId(), model, tiles, numThreads, false);  // sets objectSegmentationList list in rf
        ClassificationResult classificationResult = getClassificationResult(rf, model, tiles, segmentationResult);
        return classificationResult;
    }


    public static ClassificationResult CellClassification(final RecognitionFrame rf, final OrbitModel model, List<Point> tiles, int numThreads) throws OrbitImageServletException {
        SegmentationResult segmentationResult = Segmentation(rf, -1, model, tiles, numThreads, false);  // sets objectSegmentationList list in rf
        ClassificationResult classificationResult = getClassificationResult(rf, model, tiles, segmentationResult);
        return classificationResult;
    }

    private static ClassificationResult getClassificationResult(RecognitionFrame rf, OrbitModel model, List<Point> tiles, SegmentationResult segmentationResult) {
        log.debug("{} cells segmented", segmentationResult.getObjectCount());

        OrbitModel modelNoMip = new OrbitModel(model);
        modelNoMip.setMipLayer(0);

        // cell classification
        ObjectClassificationWorker worker = new ObjectClassificationWorker(rf, modelNoMip, null, tiles);
        worker.setGenerateTaskResult(false);
        worker.run();

        Map<Integer, Integer> classIdxCount = worker.getClassCount();
        Map<String, Long> classCount = new HashMap<String, Long>(classIdxCount.keySet().size());
        for (Integer idx : classIdxCount.keySet()) {
            String className = "ignored objects";
            if (idx < model.getClassShapes().size())
                className = model.getClassShapes().get(idx).getName();   // else count is ignoredCount
            int cnt = classIdxCount.get(idx);
            classCount.put(className, (long) cnt);
        }

        return new ClassificationResult(classCount, null, model);
    }


    /********************************************************************/
    /***** Tissue Classification ****************************************/
    /********************************************************************/


    public static ClassificationResult Classify(final int rdfId, final OrbitModel model) throws Exception {
        final RawDataFile rdf = DALConfig.getImageProvider().LoadRawDataFile(rdfId);
        return Classify(rdf, model, Collections.singletonList(new Point(-1, -1)), -1);
    }

    /**
     * set numThreads=-1 for availableProcessors
     */
    public static ClassificationResult Classify(final int rdfId, final OrbitModel model, List<Point> tiles, int numThreads) throws Exception {
        final RawDataFile rdf = DALConfig.getImageProvider().LoadRawDataFile(rdfId);
        return Classify(rdf, model, tiles, numThreads);
    }


    public static ClassificationResult Classify(final RawDataFile rdf, final OrbitModel _model, final List<Point> tiles, int numThreads) throws Exception {
        return Classify(rdf, _model, tiles, numThreads, null);
    }

    public static ClassificationResult Classify(final RawDataFile rdf, final OrbitModel _model, final List<Point> tiles, int numThreads, IScaleableShape overrideROI) throws Exception {
        return Classify(rdf, null, _model, tiles, numThreads, overrideROI);
    }


    /**
     * Rdf is used for mip-level and exclusion model, but can be null (if mip and exclusion model is not used).
     * _rf can be null, the rf is created based on rdf.
     *
     * @param rdf         can be null, then set _rf
     * @param _rf         can be null, then set rdf
     * @param _model
     * @param tiles       can be null - then all tiles are used
     * @param numThreads  currently not used (only one thread is used)
     * @param overrideROI
     * @return
     * @throws Exception
     */
    public static ClassificationResult Classify(final RawDataFile rdf, final RecognitionFrame _rf, final OrbitModel _model, List<Point> tiles, int numThreads, IScaleableShape overrideROI) throws Exception {
        final double pixelFuzzyness = 0d;
        final double tileFuzzyness = 0d;

        OrbitModel model = new OrbitModel(_model);
        RecognitionFrame rf = _rf;
        if (rf == null) rf = new RecognitionFrame(rdf, false);
        rf.setClassShapes(model.getClassShapes());
        rf.setWindowSize(model.getFeatureDescription().getWindowSize());
        rf.setBoundaryClass(model.getBoundaryClass());
        rf.setFeatureDescription(model.getFeatureDescription()); // Manuel 27.06.2012
        int annoGroup = model.getAnnotationGroup();
        if (annoGroup < 0 && model.isLoadAnnotationsAsInversROI()) {
            annoGroup = 0;// 0 means all
        }
        if (overrideROI == null && rdf != null) {
            rf.loadAnnotationROI(rdf.getRawDataFileId(), annoGroup);
        } else {
            if (overrideROI!=null) {
                overrideROI = (IScaleableShape) overrideROI.getScaledInstance(100d,new Point(0,0));
            }
            rf.setROI(overrideROI);
        }

        if (model.getMipLayer() > 0) {
            rf = new RecognitionFrame(rf, rdf, model.getMipLayer() - 1);   // mip number, not index
        }

        RecognitionFrame exclusionFrame = null;
        ExclusionMapGen exMap = ExclusionMapGen.constructExclusionMap(rdf, rf, model, rf.getROI());
        if (exMap != null) {
            exMap.setNumThreads(1);
            exMap.setDoNormalize(false);
            exMap.setKeepVisualClassificationImage(false);
            exMap.generateMap();
            exclusionFrame = exMap.getRecognitionFrame();
        }

        if (tiles == null) {
            tiles = new ArrayList<>();
            tiles.add(new Point(-1, -1));
        }

        Map<String, Long> ratioMain = null;
        if (model.getClassifier() != null && model.getClassifier().isBuild()) {    // otherwise e.g. only exclusion model
            double[] ratio = new double[model.getClassShapes().size()];
            rf.setRatio(ratio);
            rf.setClassImage(new TiledImageWriter(rf.bimg.getWidth(), rf.bimg.getHeight(), rf.bimg.getTileWidth(), rf.bimg.getTileHeight()));
            // TODO multithread version
            ClassificationTaskTiled classificationTask = new ClassificationTaskTiled(ClassifierWrapper.makeCopy(model.getClassifier()), model.getStructure(), model.getFeatureDescription(),/*rf.getClassShapes()*/model.getClassShapes(), rf.getROI(), rf.bimg, rf.getClassImage(), tiles, false);
            classificationTask.setPixelFuzzyness(pixelFuzzyness);
            if (exMap != null) classificationTask.setExclusionMapGen(exMap);
            Long[] vals = classificationTask.call();

            // results
            ratioMain = new HashMap<String, Long>();
            for (int i = 0; i < model.getClassShapes().size(); i++) {
                ratioMain.put(model.getClassShapes().get(i).getName(), vals[i]);
            }
        }

        Map<String, Long> ratioExcl = new HashMap<String, Long>();
        if ((model.getExclusionModel() != null) && (exclusionFrame != null)) {
            for (int i = 0; i < model.getExclusionModel().getClassShapes().size(); i++) {
                ratioExcl.put(model.getExclusionModel().getClassShapes().get(i).getName(), (long) exclusionFrame.getRatio()[i]);
            }
        }
        ClassificationResult result = new ClassificationResult(ratioMain, ratioExcl, model);
        return result;
    }

    /***
     * Histogram
     ***/


    public static Histogram[] Histogram(final int rdfId, final OrbitModel model, List<Point> tiles, int numThreads) throws Exception {
        final RawDataFile rdf = DALConfig.getImageProvider().LoadRawDataFile(rdfId);
        return Histogram(rdf, model, tiles, numThreads);
    }


    public static Histogram[] Histogram(final RawDataFile rdf, final OrbitModel _model, final List<Point> tiles, int numThreads) throws Exception {
        final double pixelFuzzyness = 0d;
        final double tileFuzzyness = 0d;

        OrbitModel model = new OrbitModel(_model);
        RecognitionFrame rf = new RecognitionFrame(null);
        rf.loadImage(rdf, false);
        rf.setClassShapes(model.getClassShapes());
        rf.setWindowSize(model.getFeatureDescription().getWindowSize());
        rf.setBoundaryClass(model.getBoundaryClass());
        rf.setFeatureDescription(model.getFeatureDescription()); // Manuel 27.06.2012
        int annoGroup = model.getAnnotationGroup();
        if (annoGroup < 0 && model.isLoadAnnotationsAsInversROI()) {
            annoGroup = 0;// 0 means all
        }
        rf.loadAnnotationROI(rdf.getRawDataFileId(), annoGroup);

        if (model.getMipLayer() > 0) {
            rf = new RecognitionFrame(rf, rdf, model.getMipLayer() - 1);  // mip number, not index
        }

        RecognitionFrame exclusionFrame = null;
        ExclusionMapGen exMap = ExclusionMapGen.constructExclusionMap(rdf, rf, model, rf.getROI());
        if (exMap != null) {
            exMap.setNumThreads(1);
            exMap.setKeepVisualClassificationImage(false);
            exMap.setDoNormalize(false);
            exMap.generateMap();
            exclusionFrame = exMap.getRecognitionFrame();
        }

        Histogram[] histograms = Histogram(rf, model, exMap, tiles, pixelFuzzyness);
        return histograms;
    }

    public static Histogram[] Histogram(RecognitionFrame rf, OrbitModel model, ExclusionMapGen exMap, List<Point> tiles, double pixelFuzzyness) throws Exception {
        Histogram[] histograms = new Histogram[model.getFeatureDescription().getSampleSize()];
        for (int i = 0; i < histograms.length; i++) {
            histograms[i] = new Histogram(model);
        }
        if (model.getClassifier() != null && model.getClassifier().isBuild()) {    // otherwise e.g. only exclusion model
            double[] ratio = new double[model.getClassShapes().size()];
            rf.setRatio(ratio);
            rf.setClassImage(new TiledImageWriter(rf.bimg.getWidth(), rf.bimg.getHeight(), rf.bimg.getTileWidth(), rf.bimg.getTileHeight()));
            ClassificationTaskTiled classificationTask = new ClassificationTaskTiled(ClassifierWrapper.makeCopy(model.getClassifier()), model.getStructure(), model.getFeatureDescription(), model.getClassShapes(), rf.getROI(), rf.bimg, rf.getClassImage(), tiles, false);
            classificationTask.setPixelFuzzyness(pixelFuzzyness);
            classificationTask.setHistograms(histograms);
            if (exMap != null) classificationTask.setExclusionMapGen(exMap);
            Long[] vals = classificationTask.call();
        } else {
            throw new IllegalArgumentException("model not trained");
        }
        return histograms;
    }


    /**
     * Opens an image browser and returns a list of selected images.
     * Null might be returned if no images have been selected.
     *
     * @param parent
     * @return list of selected images or null
     * @throws Exception
     */
    public static List<RawDataFile> browseImagesDefault(Object parent) throws Exception {
        DefaultRDFChooser rdfChooser = new DefaultRDFChooser();
        rdfChooser.setMultiSelectionEnabled(true);
        Component parentComponent = null;
        if (parent instanceof Component) parentComponent = (Component) parent;
        int returnVal = rdfChooser.showOpenDialog(parentComponent);
        if (returnVal == DefaultRDFChooser.APPROVE_OPTION) {
            final List<RawDataFile> rdfList = rdfChooser.getSelectedFiles();
            return rdfList;
        } else return null;
    }

    public static List<RawDataFile> searchImages(String search, int limit) throws Exception {
        return DALConfig.getImageProvider().LoadRawDataFilesSearchFast(search, limit, Arrays.asList(RawUtilsCommon.fileTypesImage));
    }


    public static List<RawDataFile> searchImages(String search) throws Exception {
        return searchImages(search,1000);
    }


    public static void main(String[] args) throws Exception {
        //InputStream inStream = OrbitHelper.class.getResourceAsStream("/resource/cellSegmentationWorking.cell");
        InputStream inStream = new FileInputStream("d:/OrbitModels/test.apar");
        OrbitModel model = OrbitModel.LoadFromInputStream(inStream);
        RawDataFile rdf = DALConfig.getImageProvider().LoadRawDataFile(7683);        //  21065
//		int cellCount = Segmentation(rdf, model, null, -1).getObjectCount();
//		System.out.println("counted cells: "+cellCount);

//		List<Point> tiles = new ArrayList<Point>();
//		tiles.add(new Point(10,20));
//		ClassificationResult res = CellClassification(rdf,model,tiles,1);
//		for (String s: res.getRatio().keySet()) {
//			System.out.println("Class "+s+": "+res.getRatio().get(s));
//		}

        int[] featureClasses = new int[2];
        featureClasses[0] = 0;
        featureClasses[1] = 1;
        model.getFeatureDescription().setFeatureClasses(featureClasses);
        List<Point> tiles = new ArrayList<Point>();
        tiles.add(new Point(-1, -1));
        Histogram[] histograms = Histogram(rdf, model, tiles, 1);

        long numPixel = 0;
        for (int i = 0; i < histograms.length; i++) {
            System.out.println(histograms[i].toString());
            numPixel += histograms[i].getNumPixel();
        }
        System.out.println("#pixel: " + numPixel / histograms.length);

    }

}
