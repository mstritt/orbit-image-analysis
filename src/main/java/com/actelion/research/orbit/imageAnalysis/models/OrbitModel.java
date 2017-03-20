/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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
import com.actelion.research.orbit.imageAnalysis.components.ImageFrame;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.features.TissueFeatures;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import weka.classifiers.functions.SMO;
import weka.core.Attribute;
import weka.core.Instances;
import weka.core.RelationalLocator;
import weka.core.StringLocator;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.ReplaceMissingValues;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class OrbitModel implements Serializable, Cloneable {

    private static final long serialVersionUID = 5L;
    private static transient Logger logger = LoggerFactory.getLogger(OrbitModel.class);
    private int version = 11; // 10 without secondarySeg
    private String orbitVersion = "";
    private ClassifierWrapper classifier = null;
    private Instances structure = null;
    protected List<ClassShape> classShapes = Collections.synchronizedList(new ArrayList<ClassShape>());
    protected final List<ClassShape> classShapesToRestore = new ArrayList<>();
    private FeatureDescription featureDescription = null;
    private int boundaryClass = -1;
    private int fixedCircularROI = 0;
    private int fixedROIOffsetX = 0;
    private int fixedROIOffsetY = 0;
    private OrbitModel segmentationModel = null;
    private OrbitModel secondarySegmentationModel = null;
    private OrbitModel exclusionModel = null;
    private boolean applyExclusionOnNegativeChannel = false;
    private boolean performErodeDiliate = false; // only in exclusionMap implemented
    private boolean useExclusionForSegmentation = false; // otherwise for classification
    private boolean loadAnnotationsAsInversROI = false;
    private int annotationGroup = 0; // <0 means ignore annotations, 0 means all annotations, >0 means specific annotation group
    private int exclusionLevel = 1; // numMips-exlusionLevel
    private boolean isCellClassification = false;
    private int mipLayer = 0; // the images mipLayer used for training the model

    /**
     * constructs a model with default classShapes and defaultFeatureDescriptors, classifier and structure are set to null.
     */
    public OrbitModel() {
        // upd 28.06.2010: default class shapes and feature descriptors
        classShapes = Collections.synchronizedList(new ArrayList<ClassShape>(3));
        classShapes.add(new ClassShape("Background", new Color(94, 6, 129), ClassShape.SHAPETYPE_POLYGONEXT));
        classShapes.add(new ClassShape("Celltype 1", RecognitionFrame.getColorByNum(1), ClassShape.SHAPETYPE_POLYGONEXT));
        classShapes.add(new ClassShape("Celltype 2", RecognitionFrame.getColorByNum(2), ClassShape.SHAPETYPE_POLYGONEXT));

        featureDescription = new FeatureDescription();
        orbitVersion = OrbitUtils.VERSION_STR;
    }

    /**
     * constructs a model with a (already build) classifier.
     *
     * @param classifier
     * @param structure
     * @param classShapes
     * @param featureDescription
     */
    public OrbitModel(ClassifierWrapper classifier, Instances structure, List<ClassShape> classShapes, FeatureDescription featureDescription) {
        this.classShapes = Collections.synchronizedList(new ArrayList<ClassShape>());
        for (ClassShape cs : classShapes) {
            if (cs.getColor().getRGB() == OrbitUtils.UNDEF_COLOR)
                logger.warn("UNDEFINED Color (black) should not be used as class color!");
            ClassShape newShape = cs.clone();
            newShape.setShapeList(new ArrayList<Shape>()); // store empty list to save memory
            this.classShapes.add(newShape);
        }
        this.classifier = classifier;
        this.structure = structure;
        this.featureDescription = featureDescription;
        orbitVersion = OrbitUtils.VERSION_STR;
    }

    /**
     * Constructs a cloned model based on an old model.
     * ClassShapesForReconstruction will be discarded!
     *
     * @param oldModel
     */
    public OrbitModel(OrbitModel oldModel) {
        if (oldModel.getClassShapes() != null)
            this.classShapes = OrbitUtils.cloneClassShapes(oldModel.getClassShapes());
        if (oldModel.getFeatureDescription() != null)
            this.featureDescription = oldModel.getFeatureDescription().clone();
        if (oldModel.getClassifier() != null) {
            try {
                this.classifier = ClassifierWrapper.makeCopy(oldModel.getClassifier());
            } catch (Exception e) {
                logger.error("cannot clone old classifier", e);
            }
        }
        if (oldModel.getStructure() != null) {
            this.structure = new Instances(oldModel.getStructure());
        }

        if (oldModel.getExclusionModel() != null)
            this.setExclusionModel(new OrbitModel(oldModel.getExclusionModel()));
        if (oldModel.getSegmentationModel() != null) {
            this.setSegmentationModel(new OrbitModel(oldModel.getSegmentationModel()));
        }
        if (oldModel.getSecondarySegmentationModel() != null) {
            this.setSecondarySegmentationModel(new OrbitModel(oldModel.getSecondarySegmentationModel()));
        }

        this.setMipLayer(oldModel.getMipLayer());
        this.isCellClassification = oldModel.isCellClassification();
        this.setBoundaryClass(oldModel.getBoundaryClass());
        this.setFixedCircularROI(oldModel.getFixedCircularROI());
        this.setFixedROIOffsetX(oldModel.getFixedROIOffsetX());
        this.setFixedROIOffsetY(oldModel.getFixedROIOffsetY());
        this.setLoadAnnotationsAsInversROI(oldModel.isLoadAnnotationsAsInversROI());
        this.setOrbitVersion(oldModel.getOrbitVersion());
        this.setVersion(oldModel.getVersion());
        this.setAnnotationGroup(oldModel.getAnnotationGroup());
        this.setApplyExclusionOnNegativeChannel(oldModel.applyExclusionOnNegativeChannel);
        this.setPerformErodeDiliate(oldModel.isPerformErodeDiliate());
        this.setExclusionLevel(oldModel.getExclusionLevel());
        if (oldModel.getVersion() < 6 && oldModel.getExclusionLevel() == 0)
            this.setExclusionLevel(1);
    }


    /**
     * Constructs the model by loading the file
     *
     * @param filename
     */
    public static OrbitModel LoadFromFile(String filename) {
        File file = new File(filename);
        if (file.isDirectory()) return null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            return LoadFromInputStream(fis);
        } catch (Exception ex) {
            logger.error("cannot load model: {}", ex);
            return null;
        } finally {
            try {
                if (fis != null) fis.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Constructs the model by loading the file via inputStream
     */
    public static OrbitModel LoadFromInputStream(InputStream inStream) {
        XStream xstream = new XStream();
        OrbitModel model = null;
        try {
            byte[] bytes = toBytes(inStream);
            GZIPInputStream zip = new GZIPInputStream(new ByteArrayInputStream(bytes));
            //ObjectInputStream ois = new ObjectInputStream(zip);
            ObjectInputStream ois = xstream.createObjectInputStream(zip);
            try {
                Object obj = ois.readObject();
                model = (OrbitModel) obj;
                // update sampleSize for old version models (in new versions it should be set)
                if (model.getFeatureDescription() != null && model.getFeatureDescription().getSampleSize() == 0)
                    model.getFeatureDescription().setSampleSize(3);
                // old annotation handling (without groups) -> use all annotations (annotation types have been converted already)
                if (model.isLoadAnnotationsAsInversROI())
                    model.setAnnotationGroup(0);
                if (model.getVersion() < 6 && model.getExclusionLevel() == 0) model.setExclusionLevel(1);
            } catch (Exception ex) {
                logger.error("cannot load model: {}", ex);
                ex.printStackTrace();
            } finally {
                ois.close();
                zip.close();
                inStream.close();
            }
        } catch (Exception e) {
            logger.error("Error: ", e);
            e.printStackTrace();
        }
        // fixOldModelVersion(model);
        return model;
    }

    private static byte[] toBytes(InputStream stream) throws IOException {
        byte[] buffer = new byte[1024];
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        int line = 0;
        while ((line = stream.read(buffer)) != -1) {
            os.write(buffer, 0, line);
        }
        stream.close();
        os.flush();
        os.close();
        return os.toByteArray();
    }

    public static OrbitModel LoadFromOrbit(int modelId) throws Exception {
        RawAnnotation anno = DALConfig.getImageProvider().LoadRawAnnotation(modelId);
        if (anno.getRawAnnotationType() != RawAnnotation.ANNOTATION_TYPE_MODEL) {
            throw new IllegalArgumentException("annotation " + modelId + " is not of type model annotation");
        } else {
            ModelAnnotation modelAnnotation = new ModelAnnotation(anno);
            OrbitModel model = modelAnnotation.getModel();
            //  fixOldModelVersion(model);
            return model;
        }
    }

    public void saveModel(String filename) {
        File file = new File(filename);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(getAsByteArray());
            fos.flush();
            fos.close();
            logger.info("model successfully saved to file " + filename);
        } catch (Exception e) {
            logger.error("Error", e);
            e.printStackTrace();
        } finally {
            if (fos != null) try {
                fos.close();
            } catch (IOException e) {
            }
        }
    }

    /**
     * Saves the model as a temp file (OrbitModel*.omo) and sets deleteOnExit.
     *
     * @param tempFolder
     * @return
     * @throws IOException
     */
    public String saveModelAsTempFile(String tempFolder, boolean deleteOnExit) throws IOException {
        File file = File.createTempFile("OrbitModel", OrbitUtils.MODEL_ENDING, new File(tempFolder));
        if (deleteOnExit) file.deleteOnExit();
        String filename = file.getAbsolutePath();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(getAsByteArray());
            fos.flush();
            fos.close();
            logger.info("model successfully saved to file " + filename);
        } catch (Exception e) {
            logger.error("Error", e);
            e.printStackTrace();
        } finally {
            if (fos != null) try {
                fos.close();
            } catch (IOException e) {
            }
        }
        return filename;
    }


    public int saveModelOrbit(String elb, String name, String userId) throws Exception {
        ModelAnnotation modelAnnotation = new ModelAnnotation(this, elb, name, userId);
        return DALConfig.getImageProvider().InsertRawAnnotation(modelAnnotation);
    }

    /**
     * load all models from orbit, optional filter for a specific user (can be null)
     *
     * @param userId (user filter, can be null)
     * @return
     * @throws Exception
     */
    public static List<ModelAnnotation> LoadFromOrbitUser(String userId) throws Exception {
        List<ModelAnnotation> modelList = new ArrayList<>();
        List<RawAnnotation> annoList = DALConfig.getImageProvider().LoadRawAnnotationsByType(RawAnnotation.ANNOTATION_TYPE_MODEL);
        for (RawAnnotation rawAnnotation : annoList) {
            if (rawAnnotation.getRawAnnotationType() == RawAnnotation.ANNOTATION_TYPE_MODEL) {
                if ((userId == null || userId.length() == 0) || userId.equals(rawAnnotation.getUserId())) {
                    ModelAnnotation modelAnnotation = new ModelAnnotation(rawAnnotation);
                    modelList.add(modelAnnotation);
                }
            }
        }
        return modelList;
    }


    public byte[] getAsByteArray() {
        XStream xstream = new XStream();
        byte[] res = null;
        ByteArrayOutputStream outStream = null;
        GZIPOutputStream zip = null;
        ObjectOutputStream oos = null;
        try {
            outStream = new ByteArrayOutputStream();
            zip = new GZIPOutputStream(outStream);
            //oos = new ObjectOutputStream(zip);
            oos = xstream.createObjectOutputStream(zip);
            oos.writeObject(this);
            oos.flush();
            zip.flush();
            oos.close();     // needed!!!
            outStream.flush();
            res = outStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outStream != null) try {
                outStream.close();
            } catch (IOException e) {
            }
            if (zip != null) try {
                zip.close();
            } catch (IOException e) {
            }
            if (oos != null) try {
                oos.close();
            } catch (IOException e) {
            }
        }
        return res;
    }

    /**
     * Removes nested segmentation and exclusion models from segmentation and exclusion model.
     */
    public void cleanModel() {
        if (segmentationModel != null) {
            segmentationModel.setSegmentationModel(null);
            segmentationModel.setExclusionModel(null);
        }
        if (exclusionModel != null) {
            exclusionModel.setSegmentationModel(null);
            exclusionModel.setExclusionModel(null);
        }
    }

    /**
     * Combines all classShapes of the iFrames, sets the orbit IDs and stores it in a separate list for later restoring.
     *
     * @param iFrames
     */
    public void prepareModelforSaving(List<ImageFrame> iFrames) {
        if (classShapesToRestore == null) return; // old deserialized model

        // check for multiple-shape bug -> remove duplicate shapes
        int cnt=0;
        for (ClassShape cs: classShapesToRestore) {
            cnt += cs.getShapeList().size();
        }
        if (cnt>10000) {
            logger.info("more than 10000 class shapes - trying to remove duplicate shapes");
            cleanUpShapesToRestore();
        }

        // collect open images
        HashSet<Integer> openRDFs = new HashSet<>();
        if (iFrames != null) {
            for (ImageFrame iFrame : iFrames) {
                if (iFrame.getRdf()!=null) {
                    openRDFs.add(iFrame.getRdf().getRawDataFileId());
                }
            }
        }

        // save old class shapes from images which are not open
        List<ClassShape> classShapesToAdd = new ArrayList<>();
        for (ClassShape cs: classShapesToRestore) {
            ClassShape csNew = cs.clone();
            csNew.getShapeList().clear();
            for (Shape shape: cs.getShapeList()) {
                if (shape instanceof IScaleableShape) {
                    IScaleableShape isc = (IScaleableShape) shape;
                    if (isc.getRdfId()>0) {
                        if (!openRDFs.contains(isc.getRdfId())) {
                            csNew.getShapeList().add(isc);  // not open, so keep old one to add later
                        }
                    }
                }
            }
            if (csNew.getShapeList().size()>0) {
                classShapesToAdd.add(csNew);
            }

        }


        // clear class shape list and initialize according to class shape drop-down box
        classShapesToRestore.clear();
        for (ClassShape cs : classShapes) {
            ClassShape newShape = cs.clone();
            newShape.setShapeList(Collections.synchronizedList(new ArrayList<Shape>())); // store empty list
            classShapesToRestore.add(newShape);
        }
        // add class shapes from open images
        if (iFrames != null) {
            for (ImageFrame iFrame : iFrames) {
                if (iFrame.getRdf() != null) {   // it's an Orbit image (not loaded from file)
                    if (iFrame.getRecognitionFrame().getClassShapes() != null) {
                        if (classShapes.size() == iFrame.getRecognitionFrame().getClassShapes().size()) {  // check
                            for (int i = 0; i < classShapes.size(); i++) {
                                ClassShape cs = iFrame.getRecognitionFrame().getClassShapes().get(i);
                                for (Shape shape : cs.getShapeList()) {
                                    if (shape instanceof IScaleableShape) {
                                        ((IScaleableShape) shape).setRdfId(iFrame.getRdf().getRawDataFileId());
                                        classShapesToRestore.get(i).getShapeList().add(shape);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Training shapes from image " + iFrame.getTitle() + " cannot be saved because the image is not persistent in the Orbit database.\nThis is not a problem, but when loading the model you cannot reconstruct the training data.", "Cannot save training shapes", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        // add old (not open in images) class shapes
        for (ClassShape csNew: classShapesToAdd) {
            boolean found=false;
            for (ClassShape cs: classShapesToRestore) {
                if (cs.equalsSimple(csNew)) {
                    cs.getShapeList().addAll(csNew.getShapeList());
                    found = true;
                    break;
                }
            }
            if (!found) classShapesToRestore.add(csNew);
        }
    }


    public void cleanUpShapesToRestore() {
        if (classShapesToRestore!=null) {
            for (int csI=0; csI<classShapesToRestore.size(); csI++) {
                logger.info("shapes to restore before ["+csI+"]: "+classShapesToRestore.get(csI).getShapeList().size());
                ClassShape cs = classShapesToRestore.get(csI);
                List<Shape> shapeList = new ArrayList<>();
                for (Shape shape: cs.getShapeList()) {
                    boolean toAdd = true;
                    if (shape instanceof PolygonExt) {
                       PolygonExt pe = (PolygonExt) shape;
                       for (Shape shape2: shapeList) {
                           if (shape2 instanceof PolygonExt) {
                               PolygonExt pe2 = (PolygonExt) shape2;
                               if (pe2.equalsExact(pe)) {
                                   toAdd = false;
                                   break;
                               }
                           }
                       }
                    }
                    if (toAdd) {
                        shapeList.add(shape);
                    }
                }

                cs.setShapeList(shapeList);
                logger.info("shapes to restore after ["+csI+"]: "+classShapesToRestore.get(csI).getShapeList().size());
            }
        }
    }

    /**
     * convert models from old weka version
     *
     * @param model
     */
    public static void fixOldModelVersion(final OrbitModel model) {
        if (model == null) return; // nothing to fix
        boolean oldWekaVersion = false;
        try {
            model.getStructure().classAttribute().numValues();
        } catch (NullPointerException ne) {
            oldWekaVersion = true;
        }

        // apply old model fix?
        if (oldWekaVersion) {
            logger.info("model from old weka version (< 3.7.11) detected, trying to apply fixes");
            int numClasses = model.getClassShapes().size();
            TissueFeatures tf = new TissueFeatures(model.getFeatureDescription(), null);
            int numFeatures = tf.getFeaturesPerSample() * model.getFeatureDescription().getSampleSize() + 1;
            ArrayList<Attribute> attrInfo = new ArrayList<Attribute>(numFeatures);
            for (int a = 0; a < numFeatures - 1; a++) {
                Attribute attr = new Attribute("a" + a);
                attrInfo.add(attr);
            }
            List<String> classValues = new ArrayList<String>(numClasses);
            for (int i = 0; i < numClasses; i++) {
                classValues.add((i + 1) + ".0"); // "1.0", "2.0", ...
            }
            Attribute classAttr = new Attribute("class", classValues);
            attrInfo.add(classAttr);

            Instances structure = new Instances("trainSet pattern classes", attrInfo, 0);
            structure.setClassIndex(numFeatures - 1);
            model.setStructure(structure);

            try {
                if (model.getClassifier() != null && model.getClassifier().getClassifier() != null && model.getClassifier().getClassifier() instanceof SMO) {
                    SMO smo = ((SMO) model.getClassifier().getClassifier());

                    Field field = smo.getClass().getDeclaredField("m_classAttribute");
                    field.setAccessible(true);
                    field.set(smo, classAttr);

                    // missing values
                    ReplaceMissingValues rmv = new ReplaceMissingValues();
                    rmv.setInputFormat(structure);

                    Field missing = smo.getClass().getDeclaredField("m_Missing");
                    missing.setAccessible(true);
                    missing.set(smo, rmv);

                    // filter
                    Field filter = smo.getClass().getDeclaredField("m_Filter");
                    filter.setAccessible(true);
                    Filter normalize = (Filter) filter.get(smo);

                    RelationalLocator relLoc = new RelationalLocator(structure);
                    StringLocator strLoc = new StringLocator(structure);

                    Field outputRelAtts = normalize.getClass().getSuperclass().getSuperclass().getDeclaredField("m_OutputRelAtts");
                    outputRelAtts.setAccessible(true);
                    outputRelAtts.set(normalize, relLoc);

                    Field inputRelAtts = normalize.getClass().getSuperclass().getSuperclass().getDeclaredField("m_InputRelAtts");
                    inputRelAtts.setAccessible(true);
                    inputRelAtts.set(normalize, relLoc);

                    Field outputStrAtts = normalize.getClass().getSuperclass().getSuperclass().getDeclaredField("m_OutputStringAtts");
                    outputStrAtts.setAccessible(true);
                    outputStrAtts.set(normalize, strLoc);

                    Field inputStrAtts = normalize.getClass().getSuperclass().getSuperclass().getDeclaredField("m_InputStringAtts");
                    inputStrAtts.setAccessible(true);
                    inputStrAtts.set(normalize, strLoc);

                    Field outputFormat = normalize.getClass().getSuperclass().getSuperclass().getDeclaredField("m_OutputFormat");
                    outputFormat.setAccessible(true);
                    outputFormat.set(normalize, structure);

                    logger.info("fixes applied, the model should work with a weka version >= 3.7.11 now");
                } // else: good luck...
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("new weka version fixes could not be applied: " + e.getMessage());
            }
        } // old weka version
        fixOldModelVersion(model.getSegmentationModel());     // fixOldModelVersion can handle null
        fixOldModelVersion(model.getSecondarySegmentationModel());  // fixOldModelVersion can handle null
        fixOldModelVersion(model.getExclusionModel());  // fixOldModelVersion can handle null
    }


    public ClassifierWrapper getClassifier() {
        return classifier;
    }

    public void setClassifier(ClassifierWrapper classifier) {
        this.classifier = classifier;
    }

    public Instances getStructure() {
        return structure;
    }

    public void setStructure(Instances structure) {
        this.structure = structure;
    }

    public List<ClassShape> getClassShapes() {
        return classShapes;
    }

    public void setClassShapes(List<ClassShape> classShapes) {
        this.classShapes = classShapes;
    }

    public FeatureDescription getFeatureDescription() {
        return featureDescription;
    }

    public void setFeatureDescription(FeatureDescription featureDescription) {
        this.featureDescription = featureDescription;
    }

    public int getBoundaryClass() {
        return boundaryClass;
    }

    public void setBoundaryClass(int boundaryClass) {
        this.boundaryClass = boundaryClass;
    }

    public OrbitModel getSegmentationModel() {
        return segmentationModel;
    }

    public void setSegmentationModel(OrbitModel segmentationModel) {
        this.segmentationModel = segmentationModel;
    }

    public OrbitModel getSecondarySegmentationModel() {
        return secondarySegmentationModel;
    }

    public void setSecondarySegmentationModel(OrbitModel secondarySegmentationModel) {
        this.secondarySegmentationModel = secondarySegmentationModel;
    }

    public OrbitModel getExclusionModel() {
        return exclusionModel;
    }


    public void setExclusionModel(OrbitModel exclusionModel) {
        this.exclusionModel = exclusionModel;
    }

    public int getFixedCircularROI() {
        return fixedCircularROI;
    }

    public void setFixedCircularROI(int fixedCircularROI) {
        this.fixedCircularROI = fixedCircularROI;
    }

    public int getFixedROIOffsetX() {
        return fixedROIOffsetX;
    }

    public int getFixedROIOffsetY() {
        return fixedROIOffsetY;
    }

    public void setFixedROIOffsetX(int fixedROIOffsetX) {
        this.fixedROIOffsetX = fixedROIOffsetX;
    }

    public void setFixedROIOffsetY(int fixedROIOffsetY) {
        this.fixedROIOffsetY = fixedROIOffsetY;
    }

    public boolean isApplyExclusionOnNegativeChannel() {
        return applyExclusionOnNegativeChannel;
    }

    public void setApplyExclusionOnNegativeChannel(boolean applyExclusionOnNegativeChannel) {
        this.applyExclusionOnNegativeChannel = applyExclusionOnNegativeChannel;
    }

    public boolean isPerformErodeDiliate() {
        return performErodeDiliate;
    }

    public void setPerformErodeDiliate(boolean performErodeDiliate) {
        this.performErodeDiliate = performErodeDiliate;
    }

    public boolean isUseExclusionForSegmentation() {
        return useExclusionForSegmentation;
    }

    public void setUseExclusionForSegmentation(boolean useExclusionForSegmentation) {
        this.useExclusionForSegmentation = useExclusionForSegmentation;
    }

    public boolean isLoadAnnotationsAsInversROI() {
        return loadAnnotationsAsInversROI;
    }

    public void setLoadAnnotationsAsInversROI(boolean loadAnnotationsAsInversROI) {
        this.loadAnnotationsAsInversROI = loadAnnotationsAsInversROI;
    }

    public String getOrbitVersion() {
        return orbitVersion;
    }

    public void setOrbitVersion(String orbitVersion) {
        this.orbitVersion = orbitVersion;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getAnnotationGroup() {
        return annotationGroup;
    }

    public void setAnnotationGroup(int annotationGroup) {
        this.annotationGroup = annotationGroup;
    }

    public int getExclusionLevel() {
        return exclusionLevel;
    }

    public void setExclusionLevel(int exclusionLevel) {
        this.exclusionLevel = exclusionLevel;
    }

    public boolean isCellClassification() {
        return isCellClassification;
    }

    public void setCellClassification(boolean isCellClassification) {
        this.isCellClassification = isCellClassification;
    }

    public int getMipLayer() {
        return mipLayer;
    }

    public void setMipLayer(int mipLayer) {
        this.mipLayer = mipLayer;
    }

    public List<ClassShape> getClassShapesToRestore() {
        return classShapesToRestore;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Version=" + version + "\n");
        sb.append("Built with OrbitImageAnalysis version: " + orbitVersion + "\n");
        sb.append("ClassShapes:\n");
        if (classShapes == null) sb.append("classShapes is null\n");
        else {
            for (ClassShape cs : classShapes) {
                sb.append("  " + cs.toString() + "\n");
            }
        }
        sb.append("mipLayer: " + mipLayer + "\n");
        sb.append("isCellClassification: " + isCellClassification + "\n");
        sb.append("boundaryClass: " + boundaryClass + "\n");
        sb.append("fixedCircularROI: " + fixedCircularROI + "\n");
        sb.append("fixedROIOffsetX: " + fixedROIOffsetX + "\n");
        sb.append("fixedROIOffsetY: " + fixedROIOffsetY + "\n");
        sb.append("AnnotationGroup: " + annotationGroup + "\n");
        sb.append("ExclusionLevel: " + exclusionLevel+"\n");
        sb.append("applyExclusionOnNegativeChannel: " + applyExclusionOnNegativeChannel + "\n");
        sb.append("loadAnnotationsAsNegativeROI: " + loadAnnotationsAsInversROI + "\n");
        sb.append("performErodeDiliate: " + performErodeDiliate + "\n");
        sb.append("useExclusionForSegmentation: " + useExclusionForSegmentation + "\n");
        sb.append("FeatureDescription:\n");
        sb.append(featureDescription + "\n");
        sb.append("Classifier: ");
        sb.append(classifier == null ? "null" : ("set; isBuild:" + classifier.isBuild()) + "\n");
        sb.append("Structure: ");
        sb.append(structure == null ? "null" : ("numInstances:" + structure.size()) + "\n");
        sb.append("SegmentationModel:\n" + segmentationModel + "\n***\n");
        sb.append("SecondarySegmentationModel:\n" + secondarySegmentationModel + "\n***\n");
        sb.append("ExclusionModel:\n" + exclusionModel + "\n***\n");
        sb.append("------\n");
        return sb.toString();
    }



}
