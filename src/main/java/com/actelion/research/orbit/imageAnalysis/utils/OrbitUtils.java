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

package com.actelion.research.orbit.imageAnalysis.utils;

import ch.qos.logback.classic.Level;
import com.actelion.research.orbit.beans.RawAnnotation;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.beans.RawMeta;
import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.dal.IOrbitImageMultiChannel;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.dal.localImage.LocalFileFilter;
import com.actelion.research.orbit.imageAnalysis.features.TissueFeatures;
import com.actelion.research.orbit.imageAnalysis.features.TissueFeaturesCircular;
import com.actelion.research.orbit.imageAnalysis.mask.IOrbitMaskModelBased;
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.tasks.ExclusionMapGen;
import com.actelion.research.orbit.imageAnalysis.tasks.OrbitWorker;
import com.actelion.research.orbit.utils.ChannelToHue;
import com.actelion.research.orbit.utils.RawUtilsCommon;
import imageJ.Colour_Deconvolution;
import org.jaitools.tilecache.DiskCachedTile;
import org.jaitools.tiledimage.DiskMemImageOrbit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.media.jai.PlanarImage;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class OrbitUtils {
    public static final String VERSION_STR = getVersion() + (ScaleoutMode.SCALEOUTMODE.get() ? "G" : "") + (OrbitUtils.DEVELOPMENTMODE ? " DEVELOPMENT" : "");
    public static final boolean DEVELOPMENTMODE = false;
    public static long SLEEP_TILE = 0; // 13*1000L;
    public static long SLEEP_TASK = 0; //2*60*1000L;

    public static final boolean TILEMODE = false;
    public static final boolean OFFLINE_MODE = false;
    public static final boolean DARKUI = true;
    public static final boolean AUTO_LOAD_FLUO_CHANNELS = false;
    public static final boolean DEEPORBIT = false;
    public static final int UNDEF_COLOR = -16777216; // =black(0,0,0) -> used for RecognitionFrame classImage as null/"out-of-ROI" class

    public static final String TAG = "OrbitImageAnalysis" + VERSION_STR.replaceAll("\\.", "");
    public static final double EPSILON = 0.000001d;
    public static final int TILE_SIZE = ScaleoutMode.SCALEOUTMODE.get() ? 256 : 256; // 512:256 for writing tiles
    public static final int TILE_SIZE_DEFAULT = 512;
    public static final long PLANAR_IMAGE_CACHE = Runtime.getRuntime().maxMemory() / 7L;  // JAI cache
    public static final long DISK_IMAGE_CACHE = Runtime.getRuntime().maxMemory() / 5L;   // DiskMemImage cache
    // see OrbitTiledImage2.initCache for 3rd cache (the main tile cache). Currently uses maxMem/2 memory
    public static final boolean DISK_IMAGE_AUTO_FLUSH = false;
    public static final double ACCURACY_WARNING = 85d;
    private static Logger logger = LoggerFactory.getLogger(OrbitUtils.class);
    private static final ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HH:mm:ss");
        }
    };
    public static final int ANNOTATION_GROUPS = 20;
    public static final String muMeter = (char) 181 + "m";
    public static final String muMeterUnicode = "\u00B5";
    public static final String squareMuMeter = muMeter + (char) 178;

    private static boolean w32_ = System.getProperty("os.name").toLowerCase().startsWith("windows");
    private static boolean linux_ = System.getProperty("os.name").toLowerCase().startsWith("linux");
    private static boolean mac_ = System.getProperty("os.name").toLowerCase().contains("mac");

    public static final String MODEL_ENDING = ".omo"; // filename ending of orbit models
    public static final String remoteNameSpace = "orbit/temp";
    public static final String orbitHelpURL = "https://www.orbit.bio/help";
    public static final String orbitTutorialsURL = "https://www.orbit.bio/tutorials";
    public static final String orbitImageProviderURL = "https://www.orbit.bio/setup";

    public static final String CHANNEL_NAME_ALL = "<ALL CHANNELS>";

    public static final String CHANNEL_NAME2HUE = "channel_name2hue_";

    public static List<String> fileTypeImages = Arrays.asList(RawUtilsCommon.fileTypesImage);

    static {
        Logger root = LoggerFactory.getLogger("com.actelion.research");
        if (root instanceof ch.qos.logback.classic.Logger)   // can only set if logback implementation
            ((ch.qos.logback.classic.Logger) root).setLevel(DEVELOPMENTMODE ? Level.DEBUG : Level.INFO);

        if (ScaleoutMode.SCALEOUTMODE.get()) {
            DALConfig.getImageProvider().setPooledConnectionEnabled(false);
            DALConfig.getImageProvider().setDBConnectionName("OrbitGridJob");
        }
    }

    public final static double getVersion() {
        try (InputStreamReader in = new InputStreamReader(OrbitUtils.class.getResourceAsStream("/version.txt"));
             BufferedReader reader = new BufferedReader(in);) {
            String s = reader.readLine();
            s = s.trim();
            double version = Double.parseDouble(s);
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Deprecated
    public static String getCurrentDir() {
        return "/tmp";
        /*
        String tempDir = "/";
        try {
            File temp = File.createTempFile("temp-file-name", ".tmp");
            tempDir = temp.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempDir;
        */
        /*
        String path = "";
        try {
            path = System.getProperty("user.dir");
            String sandbox = System.getenv("MESOS_SANDBOX");
            if (sandbox!=null && sandbox.length()>0) {
                path = sandbox;
            }
        }  catch (Exception e) {}
        return path;
        */
    }

    /**
     * See also: https://github.com/kirill-grouchnikov/radiance/blob/master/docs/neon/neon.md#working-with-high-resolution--high-dpi-displays
     * Should not be used outside GUI code, since headless it won't work.
     *
     * @return double[]{scaleX, scaleY} the respective X and Y scale factors for the highest resolution display.
     */
    public static double[] getScaleFactor() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gds = ge.getScreenDevices();
        GraphicsConfiguration gc = gds[0].getDefaultConfiguration();
        double scaleX = gc.getDefaultTransform().getScaleX();
        double scaleY = gc.getDefaultTransform().getScaleY();

        return new double[]{scaleX, scaleY};
    }

    public static byte[] getContentBytes(URL url) {
        byte[] bytes = new byte[4096];
        BufferedInputStream is = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            is = new BufferedInputStream(url.openStream());
            int bytesRead;
            while ((bytesRead = is.read(bytes)) > 0) {
                out.write(bytes, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (Exception e) {
            }
        }
        return out.toByteArray();
    }


    public static boolean isOME_TIFF(String filename) {
        if (filename==null) return false;
        String fn = filename.toLowerCase();
        if (fn.endsWith("ome.tiff")||fn.endsWith("ome.tif")||fn.endsWith("ome.tf2")||fn.endsWith("ome.tf8")||fn.endsWith("ome.btf")) return true;
        else return false;
    }


    /**
     * replaces " " by "_" in channelName
     * @param channelName
     * @return
     */
    public static String cleanChannelName(String channelName) {
        if (channelName==null) return null;
        channelName = channelName.trim();
        channelName = channelName.replaceAll(";","_");
        //channelName = channelName.replaceAll(" ","_");
        return channelName;
    }

    /**
     * returns the hueMap merged with the user defined custom hue map (priority)
     */
    public static Map<String, Float> getMergedHueMap() {
        Map<String, Float> hm = new HashMap<>(ChannelToHue.hueMap);
        hm.putAll(ChannelToHue.userHueMap);
        return hm;
    }

    public static float[] getHues(final String[] channelNames, final Map<String, Float> hueMap) {
        if (channelNames==null) return null;
        if (hueMap==null) return null;
        float[] hues = new float[channelNames.length];
        for (int c=0; c<channelNames.length; c++) {
            String hueName = channelNames[c].toLowerCase();
            if (hueMap.containsKey(hueName)) {
                hues[c] = hueMap.get(hueName);
            }
        }
        return hues;
    }

    public static TissueFeatures createTissueFeatures(final FeatureDescription featureDescription, final TiledImagePainter bimg) {
        if (DEEPORBIT) return new TissueFeaturesCircular(featureDescription, bimg);
        else return new TissueFeatures(featureDescription, bimg);
    }


    public static Raster getRasterForClassification(final TiledImagePainter bimg, final FeatureDescription featureDescription, final int windowSize, final int tileX, final int tileY) throws OrbitImageServletException {
        PlanarImage image = bimg.getImage();
        Raster readRaster;
        if (OrbitUtils.TILEMODE) {
            readRaster = bimg.getModifiedImage(featureDescription).getTile(tileX, tileY);
        } else
            readRaster = bimg.getData(new Rectangle(image.tileXToX(tileX) - windowSize, image.tileYToY(tileY) - windowSize, image.getTileWidth() + (windowSize * 2 + 1), image.getTileHeight() + (windowSize * 2 + 1)), featureDescription);

        if (readRaster == null) {
            throw new OrbitImageServletException("error getting image raster");
        }

        // apply raster modifications like color deconvolution
        readRaster = OrbitUtils.getModifiedRaster(readRaster, featureDescription, bimg.getImage().getColorModel(), true, tileX, tileY, "modifiedRaster", bimg.getImage().getLevel());
        return readRaster;
    }

    public static RecognitionFrame getMipRecognitionFrame(RecognitionFrame rf, RawDataFile rdf, int level) {
        return new RecognitionFrame(rf, rdf, level - 0);
    }

    public static RecognitionFrame getMipRecognitionFrameScaleFactor(RecognitionFrame rf, RawDataFile rdf, double scaleFactor) {
        return new RecognitionFrame(rf, rdf, scaleFactor);
    }

    public static void setMultiChannelFeatures(final OrbitTiledImage2 orbitTiledImage2, final FeatureDescription featureDescription) {
        // fluo channels for classification
        IOrbitImageMultiChannel multiChannelImage = getMultiChannelImage(orbitTiledImage2); // might return null
        if (featureDescription.getHueMap()!=null && multiChannelImage!=null && multiChannelImage.getChannelNames()!=null && multiChannelImage.getChannelNames().length>0) {
            float[] hueMap = new float[multiChannelImage.getChannelNames().length];
            for (int c=0; c<hueMap.length; c++) {
                String channelName = OrbitUtils.cleanChannelName(multiChannelImage.getChannelNames()[c]).toLowerCase();
                if (featureDescription.getHueMap().containsKey(channelName)) {
                    hueMap[c] = featureDescription.getHueMap().get(channelName);
                } else {
                    hueMap[c] = ChannelToHue.getHue(channelName);   // fallback for undefined channels
                }
            }
            orbitTiledImage2.setAnalysisHues(hueMap);
        }
        if (multiChannelImage!=null && featureDescription.getActiveFluoChannels()!=null && featureDescription.getActiveFluoChannels().length>0 && multiChannelImage.getChannelNames()!=null && multiChannelImage.getChannelNames().length>0) {
            HashSet<String> activeChannelLookup = new HashSet<>(Arrays.asList(featureDescription.getActiveFluoChannels()));
            float[] channelContributions = new float[multiChannelImage.getChannelNames().length];
            for (int c=0; c<channelContributions.length; c++) {
                String channelName = OrbitUtils.cleanChannelName(multiChannelImage.getChannelNames()[c]);
                channelContributions[c] = activeChannelLookup.contains(channelName)? 1f : 0f;
            }
           orbitTiledImage2.setChannelContributionsClassification(channelContributions);
        }
    }

    public static RecognitionFrame createMaskRecognitionFrame(RawDataFile rdf, OrbitModel model) throws OrbitImageServletException {
        RecognitionFrame maskFrame = null;
        if (rdf!=null && model!=null && model.getMask()!=null && model.getMask() instanceof IOrbitMaskModelBased) {
            maskFrame = new RecognitionFrame(rdf); 
            OrbitUtils.setMultiChannelFeatures(maskFrame.bimg.getImage(),((IOrbitMaskModelBased) model.getMask()).getModel().getFeatureDescription());
        }
        return maskFrame;
    }

    public static RecognitionFrame createMaskRecognitionFrame(RecognitionFrame maskFrame, OrbitModel model) throws OrbitImageServletException {
        if (model!=null && model.getMask()!=null && model.getMask() instanceof IOrbitMaskModelBased) {
            OrbitUtils.setMultiChannelFeatures(maskFrame.bimg.getImage(),((IOrbitMaskModelBased) model.getMask()).getModel().getFeatureDescription());
        }
        return maskFrame;
    }


    public static IOrbitImageMultiChannel getMultiChannelImage(final OrbitTiledImage2 img) {
        if (img instanceof OrbitTiledImageIOrbitImage) {
            IOrbitImage oi = ((OrbitTiledImageIOrbitImage) img).getOrbitImage();
            if (oi instanceof IOrbitImageMultiChannel) {
                final IOrbitImageMultiChannel oim = (IOrbitImageMultiChannel) oi;
                return oim;
            }
        }
        return null;
    }



    /**
     * Loads the image scale from database (meta data). If not available, 0 is returned.
     *
     * @param rdfId
     * @return
     */
    public static double loadImageScale(int rdfId) {
        double scale = 0;
        try {
            List<RawMeta> rmList = DALConfig.getImageProvider().LoadRawMetasByRawDataFileAndName(rdfId, RawUtilsCommon.STR_META_IMAGE_SCALE);
            scale = Double.parseDouble(rmList.get(0).getValue());
        } catch (Exception e) {
            logger.info("could not load image scale for image " + rdfId);
        }
        return scale;
    }

    public static ScaleAndUnit getImageScaleAndUnit(RawDataFile rdf) {
        double scale = 0d;
        String unit = "pixel";
        if (rdf != null) {
            scale = loadImageScale(rdf.getRawDataFileId());
        }
        if (scale == 0d) {
            scale = 1d;
            unit = "pixel";
        } else {
            unit = OrbitUtils.muMeterUnicode;
        }
        ScaleAndUnit sau = new ScaleAndUnit(scale, scale * scale, unit, unit + (char) 178);
        return sau;
    }


    public static boolean isInROI(int x, int y, Shape ROI, ExclusionMapGen exclusionMapGen) {
        if ((ROI == null) || (ROI.contains(x, y))) {
            if ((exclusionMapGen == null) || /*(exclusionMapGen.useForSegmentation()) ||*/ (!exclusionMapGen.isExcluded(x, y) || ((ROI != null) && (ROI instanceof ShapeAnnotationList) && (((ShapeAnnotationList) ROI)).containsExplicit(x, y)))) {
                return true;
            }
        }
        return false;
    }


    /**
     * Fuzzy check if a tile is inside the ROI. It only checks if one corner or the center of the tile is inside the ROI.
     * Might return false if a few pixels of the tile are inside the ROI!
     */
    public static boolean isTileInROI(int tileX, int tileY, final PlanarImage image, Shape ROI, ExclusionMapGen exclusionMapGen) {
        Rectangle rect = image.getTileRect(tileX,tileY);
        if (isInROI((int)rect.getMinX(),(int)rect.getMinY(),ROI,exclusionMapGen)) return true;   // top-left
        if (isInROI((int)rect.getMaxX(),(int)rect.getMinY(),ROI,exclusionMapGen)) return true;   // top-right
        if (isInROI((int)rect.getMinX(),(int)rect.getMaxY(),ROI,exclusionMapGen)) return true;   // bottom-left
        if (isInROI((int)rect.getMaxX(),(int)rect.getMaxY(),ROI,exclusionMapGen)) return true;   // bottom-right
        if (isInROI((int)rect.getCenterX(),(int)rect.getCenterY(),ROI,exclusionMapGen)) return true;   // bottom-right
        return false;
    }

    /**
     * Loads the combined annotation ROI. Set annotationGroup to 0 to load the annotations of all annotation groups.
     *
     * @param rdfId
     * @param annotationGroup
     * @return
     * @throws SQLException
     */
    public static IScaleableShape loadAnnotationROI(int rdfId, int annotationGroup) throws Exception {
        return loadAnnotationROI(rdfId, annotationGroup, false);
    }

    /**
     * Loads the combined annotation ROI. Set annotationGroup to 0 to load the annotations of all annotation groups.
     *
     * @param rdfId
     * @param annotationGroup
     * @return
     * @throws SQLException
     */
    public static IScaleableShape loadAnnotationROI(int rdfId, int annotationGroup, boolean otherGroupROIAsExclusion) throws Exception {
        return loadAnnotationROI(rdfId, annotationGroup, otherGroupROIAsExclusion, false);
    }


    /**
     * Loads the combined annotation ROI. Set annotationGroup to 0 to load the annotations of all annotation groups.
     *
     * @param rdfId
     * @param annotationGroup
     * @return
     * @throws SQLException
     */
    public static IScaleableShape loadAnnotationROI(int rdfId, int annotationGroup, boolean otherGroupROIAsExclusion, boolean exclusionsForAllGroups) throws Exception {
        List<RawAnnotation> annotations = DALConfig.getImageProvider().LoadRawAnnotationsByRawDataFile(rdfId, RawAnnotation.ANNOTATION_TYPE_IMAGE);
        if (annotations != null && annotations.size() > 0) {
            IScaleableShape roi = new ShapeAnnotationList(annotations, annotationGroup, null, otherGroupROIAsExclusion, exclusionsForAllGroups);
            return roi;      // bounds can be null - this is explicitely allowed!
        } else return null;
    }

    public static double getROISize(RecognitionFrame rf, ExclusionMapGen exclMapGen) {
        double mumPP = rf.getMuMeterPerPixel() > 0 ? rf.getMuMeterPerPixel() : 1d;
        return OrbitUtils.getROISize(rf.bimg.getImage(), rf.getROI(), exclMapGen, mumPP);
    }

    public static double getROISize(OrbitTiledImage2 img, Shape roi, ExclusionMapGen exclusionMapGen, double mumPerPixel) {
        Rectangle bounds = img.getBounds();
        if (roi != null) {
            if (roi instanceof IScaleableShape) {
                roi = ((IScaleableShape) roi).getScaledInstance(100d, new Point(0, 0));
            }
            Rectangle roiBounds = roi.getBounds();
            if (roiBounds != null) {
                bounds.setLocation(roiBounds.x>0?roiBounds.x:0, roiBounds.y>0?roiBounds.y:0);
            }
            if (roiBounds != null) {
                bounds.setSize(new Dimension((int)(roiBounds.getMaxX()<bounds.getMaxX()?roiBounds.getMaxX():bounds.getMaxX()), (int)(roiBounds.getMaxY()<bounds.getMaxY()?roiBounds.getMaxY():bounds.getMaxY())));
            }
        }
        return getROISize(img.getWidth(), img.getHeight(), bounds, roi, exclusionMapGen, mumPerPixel);
    }

    /**
     * Computes the ROI area in square mu meter. If bounds is null imgWidth*imgHeight*mumPerPixel*mumPerPixel will be returned.
     *
     * @param imgWidth
     * @param imgHeight
     * @param bounds
     * @param roi
     * @param exclusionMapGen
     * @param mumPerPixel
     * @return
     */
    public static double getROISize(int imgWidth, int imgHeight, Rectangle bounds, Shape roi, ExclusionMapGen exclusionMapGen, double mumPerPixel) {
        double mumPPSquare = mumPerPixel * mumPerPixel;
        if (bounds == null) {
            return (double) imgWidth * imgHeight * mumPPSquare;
        }
        if (roi == null && exclusionMapGen == null) {
            return bounds.getWidth() * bounds.getHeight() * mumPPSquare;
        }
        //System.out.println("minX:"+bounds.getMinX()+" maxX:"+bounds.getMaxX()+" minY:"+bounds.getMinY()+" maxY:"+bounds.getMaxY());
        if (roi != null) {
            if (roi instanceof IScaleableShape) {
                roi = ((IScaleableShape) roi).getScaledInstance(100d, new Point(0, 0));
            }
        }

        long pixelInROI = 0;
        double size = bounds.getWidth() * bounds.getHeight();
        final int inc = size < (5000 * 5000d) ? 1 : 3;
        for (int y = (int) bounds.getMinY(); y < bounds.getMaxY(); y += inc) {
            for (int x = (int) bounds.getMinX(); x < bounds.getMaxX(); x += inc) {
                if ((isInROI(x, y, roi, exclusionMapGen))) {
                    pixelInROI++;
                }
            }
            //System.out.println("y: "+y);
        }
        pixelInROI *= inc * inc;
        double area = (double) pixelInROI * mumPPSquare;
        //System.out.println("roiBB: "+roi.getBounds()+"  pixel: "+pixelInROI+"  mumPP: "+mumPerPixel+"  mumPPSquare: "+mumPPSquare);
        return area;
    }

    public static List<RawDataFile> filterOnlyWithROI(final List<RawDataFile> rdfList, int roiGroup) {
        return  rdfList.stream().filter(rdf -> {
            try {
                List<RawAnnotation> annotations = DALConfig.getImageProvider().LoadRawAnnotationsByRawDataFile(rdf.getRawDataFileId(), RawAnnotation.ANNOTATION_TYPE_IMAGE);
                if (annotations!=null) {
                    for (RawAnnotation annotation: annotations) {
                        ImageAnnotation ia = new ImageAnnotation(annotation);
                        if (ia.getGroup()==roiGroup && ia.getSubType()==ImageAnnotation.SUBTYPE_ROI) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }).collect(Collectors.toList());
    }


    /**
     * formats time in seconds.
     *
     * @param s
     * @return
     */
    public static String formatTime(double s) {
        String d = "";
        if (s > 3600 * 24) {
            d = Integer.toString((int) (s / (3600 * 24))) + "d +";
            s -= 3600 * 24;
        }
        return d + dateFormat.get().format(new Date((long) s * 1000L - 3600000));
    }

    public static List<ClassShape> buildDefaultClassShapes() {
        List<ClassShape> classShapes = new ArrayList<ClassShape>(3);
        classShapes.add(new ClassShape("Background", Color.darkGray, ClassShape.SHAPETYPE_POLYGONEXT));
        classShapes.add(new ClassShape("Celltype 1", RecognitionFrame.getColorByNum(1), ClassShape.SHAPETYPE_POLYGONEXT));
        classShapes.add(new ClassShape("Celltype 2", RecognitionFrame.getColorByNum(2), ClassShape.SHAPETYPE_POLYGONEXT));
        return classShapes;
    }

    public static List<ClassShape> buildCellCountClassShapes() {
        List<ClassShape> classShapes = new ArrayList<ClassShape>(3);
        classShapes.add(new ClassShape("Background", Color.darkGray, ClassShape.SHAPETYPE_POLYGONEXT));
        classShapes.add(new ClassShape("Border", RecognitionFrame.getColorByNum(1), ClassShape.SHAPETYPE_POLYGONEXT));
        classShapes.add(new ClassShape("Cells", RecognitionFrame.getColorByNum(2), ClassShape.SHAPETYPE_POLYGONEXT));
        return classShapes;
    }


    /**
     * creates a new list of classShapes with cloned classShapes. The shapeList will be an empty list.
     *
     * @param classShapes
     * @return
     */
    public static List<ClassShape> cloneClassShapes(List<ClassShape> classShapes) {
        return cloneClassShapes(classShapes, false);
    }

    /**
     * creates a new list of classShapes with cloned classShapes.
     *
     * @param classShapes
     * @return
     */
    public static List<ClassShape> cloneClassShapes(List<ClassShape> classShapes, boolean keepShapes) {
        if (classShapes == null) return null;
        List<ClassShape> csList = Collections.synchronizedList(new ArrayList<ClassShape>(classShapes.size()));
        for (ClassShape cs : classShapes) {
            ClassShape newShape = cs.clone();
            if (!keepShapes)
                newShape.setShapeList(Collections.synchronizedList(new ArrayList<Shape>())); // store empty list to save memory
            csList.add(newShape);
        }
        return csList;
    }

    

    /*
     * returns the available temp disk space in byte.
     */
    public static long getTempDiskSpace() {
        if (ScaleoutMode.SCALEOUTMODE.get()) return 100 * 1024 * 1024L;
        long space = -1L;
        try {
            File f = File.createTempFile("orbit", null);
            File tmpDir = f.getParentFile();
            space = tmpDir.getFreeSpace();
            f.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return space;
    }

    public static String getTempDir() {
        String s = null;
        try {
            File f = File.createTempFile("orbit", null);
            s = f.getParentFile().getAbsolutePath();
            f.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }


    public static void cleanUpTemp() {
        if (DiskMemImageOrbit.getCommonTileCache() != null)
            DiskMemImageOrbit.getCommonTileCache().flush();
        //DiskMemImage.getCommonTileCache().removeNullTiles();

        //manually remove existing temp files
        try {
            File f = File.createTempFile(DiskCachedTile.FILE_PREFIX, DiskCachedTile.FILE_SUFFIX, DiskCachedTile.getCacheFolder());
            File tmpDir = f.getParentFile();
            f.delete();
            logger.debug("Cleaning up tile temp folder: " + tmpDir + "... ");
            if (tmpDir != null) {
                FilenameFilter filter = new FilenameFilter() {
                    public boolean accept(File dir, String name) {
                        return name.startsWith(DiskCachedTile.FILE_PREFIX) ||
                                name.startsWith("jai-FCSS-");
                    }
                };
                File[] files = tmpDir.listFiles(filter);
                if ((files != null) && (files.length > 0)) {
                    for (File tf : files) {
                        if (tf.isFile()) tf.deleteOnExit(); // delete file when vm terminates
                        //System.out.println(tf);
                    }
                }
            }
            logger.trace("done.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Parses the params for key and returns value. The params have to be in the form
     * -key1 value1 -key2 value2 ... <br>
     * Everything is treated as string.<br>
     * If the key is not found or params is null or params.length<2 null will be returned.
     *
     * @param key
     * @param params
     * @return
     */
    public static String parseParams(String key, String[] params) {
        if (params == null) return null;
        if (params.length < 2) return null;
        for (int i = 0; i < params.length - 1; i++) {
            if (params[i].equalsIgnoreCase("-" + key) && (!params[i + 1].startsWith("-"))) {
                return params[i + 1];
            }
        }
        return null;
    }

    public static double parseDouble(String s, double NanValue) {
        double d = NanValue;
        try {
            d = Double.parseDouble(s.replaceAll(",", "\\."));
        } catch (Exception e) {
            d = NanValue;
        }
        return d;
    }

    public static int parseInt(String s, int NanValue) {
        int i = NanValue;
        try {
            i = Integer.parseInt(s);
        } catch (Exception e) {
            i = NanValue;
        }
        return i;
    }


    /**
     * returns the position (starting from 0) of a wellname with leading 0, e.g. A01 -> 0,0 (A1 also works)
     *
     * @param wellName
     * @return
     */
    public static Point getWellPos(String wellName) throws IllegalArgumentException {
        if (wellName == null || wellName.length() < 2)
            throw new IllegalArgumentException("not a valid wellname: " + wellName);
        int y = wellName.charAt(0) - (byte) ('A');
        String s = String.valueOf(wellName.charAt(1));
        if (wellName.length() > 2) {
            s += wellName.charAt(2);
        }
        try {
            int x = Integer.parseInt(s);
            return new Point(x - 1, y);
        } catch (Exception e) {
            throw new IllegalArgumentException("not a valid wellname: " + wellName);
        }
    }

    /**
     * returns the well name (e.g. A01) based on the well position (x,y) (x and y starting from 0)
     *
     * @param x
     * @param y
     * @return
     */
    public static String getWellName(int x, int y) {
        char wy = ((char) (y + (byte) ('A')));
        String wellName = wy + "" + String.format("%1$02d", x + 1);
        return wellName;
    }

    /**
     * returns the well name (e.g. A1) based on the well position (x,y) (x and y starting from 0)
     *
     * @param x
     * @param y
     * @return
     */
    public static String getWellNameShort(int x, int y) {
        char wy = ((char) (y + (byte) ('A')));
        String wellName = wy + "" + String.format("%1$01d", x + 1);
        return wellName;
    }

    /**
     * waits until worker.isDone or worker.isCancelled is true
     *
     * @param worker
     */
    public static void waitForWorker(OrbitWorker worker) {
        while ((!worker.isDone()) || worker.isCancelled()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * creates a html document, lines beginning with # are headings and lines with multi tabs are table blocks.
     *
     * @return
     */
    public static String text2SmartHtml(String text) {
        final String sep = "\t";
        String color = OrbitUtils.DARKUI ? " color=white" : "";
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body" + color + ">");
        boolean tableBlock = false;
        String s;
        String lines[] = text.split("\\r?\\n");
        for (String line : lines) {
            if (line.trim().startsWith("#")) {
                if (tableBlock) {
                    tableBlock = false;
                    sb.append("</table>");
                }
                s = line.trim().replaceFirst("#", "<h2>") + "</h2>";
                sb.append(s);
            } else {
                String[] tabs = line.split(sep);
                if (tabs != null && tabs.length > 1) {
                    // table block
                    if (!tableBlock) {  // header
                        tableBlock = true;
                        sb.append("<table border=1><tr align=center>");
                        for (String col : tabs) {
                            sb.append("<th>" + col + "</th>");
                        }
                        sb.append("</tr>");
                    } else { // data
                        sb.append("<tr align=center>");
                        for (String col : tabs) {
                            sb.append("<td>" + col + "</td>");
                        }
                        sb.append("</tr>");
                    }
                } else {
                    if (tableBlock) {
                        tableBlock = false;
                        sb.append("</table>");
                    }
                    sb.append(line + "<br/>");
                }
            }
        }
        sb.append("</body></html>");
        return sb.toString();
    }

    /**
     * returns a new e.g. file (or annotation) name so that it is a unique name. It appends (1), (2)... at the end.
     *
     * @param otherNames
     * @return
     */
    public static String getNewName(String name, HashSet<String> otherNames) {
        if (otherNames.contains(name)) {
            int copyNr = 1;
            String newName = name;
            String subName = name;
            if (newName.length() >= 3 && newName.endsWith(")")) {
                int idx = newName.lastIndexOf("(");
                if (idx <= newName.length() - 2) {
                    try {
                        String sub = newName.substring(idx + 1, newName.length() - 1);
                        copyNr = Integer.parseInt(sub) + 1;
                    } catch (Exception e) {
                    }
                    subName = newName.substring(0, idx);
                }
            }
            while (otherNames.contains(newName = subName + "(" + copyNr + ")")) {
                copyNr++;
            }
            return newName;
        }
        return name;
    }


    public static double log2(double d) {
        return Math.log(d) / Math.log(2d);
    }


    /**
     * returns true if the image dimensions <= 3000x3000, otherwise false
     *
     * @param image
     * @return
     */
    public static boolean isSmallImage(RenderedImage image) {
        return (((long) image.getWidth() * image.getHeight()) <= (3000L * 3000L));
    }

    public static String getTag() {
        return TAG;
    }


    public static void openPdfUrl(String url) {
        logger.trace("trying to open pdf in external viewer");
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(url));
            } else {
                File tmp = File.createTempFile("Orbit_", ".pdf");
                tmp.deleteOnExit();
                OutputStream os = new FileOutputStream(tmp);
                RawUtilsCommon.getContentToOutputstream(new URL(url), os);
                os.close();
                openPdf(tmp.getAbsolutePath());
            }
        } catch (Exception ex) {
            logger.error("error showing pdf file: " + ex.getMessage());
        }
    }

    public static void openPdf(String filename) {
        if (new File(filename).exists()) {
            try {
                String os = System.getProperty("os.name").toLowerCase();
                if (os.startsWith("windows")) {
                    Runtime.getRuntime().exec("cmd /c start " + filename);
                } else if (os.startsWith("mac")) {
                    Runtime.getRuntime().exec("open " + filename);
                } else { // assume linux
                    Runtime.getRuntime().exec("acroread  " + filename);
                }
            } catch (IOException e) {
                logger.error("cannot open pdf: " + e.getMessage());
            }
        }
    }


    public static JFileChooser buildOpenFileFileChooser() {
        return buildOpenFileFileChooser(null);
    }

    public static JFileChooser buildOpenFileFileChooser(final ChangeListener seriesChangeListener) {
        JFileChooser fileChooser = new JFileChooser();
        ImagePreviewWithSeries preview = new ImagePreviewWithSeries(fileChooser, seriesChangeListener);
        fileChooser.setAccessory(preview);
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setDialogTitle("Open File(s)");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            LocalFileFilter filter = new LocalFileFilter();

            @Override
            public boolean accept(File f) {
                return filter.accept(f);
            }

            @Override
            public String getDescription() {
                return "Image Files (jpg,jp2,png,bmp,pcx,tga,dcm,tif,tiff,tf2,tf8,btf,svs,ndpi,ndpis,czi,afi,ims,vsi,scn,sld)";
            }
        });
        return fileChooser;
    }

    /**
     * Returns the MD5 of the fist 50mb (max) of a file.
     * @param fileName
     * @return
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public static String getDigest(String fileName) throws NoSuchAlgorithmException, IOException {
        long startT = System.currentTimeMillis();
        int maxLen = 1024*1024*50; // 1MB
        String res = "";
        MessageDigest md = MessageDigest.getInstance("MD5");
        File file = new File(fileName);
        int len = (int)Math.min(file.length(),maxLen);
        byte[] buffer = new byte[len];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            fis.read(buffer);
            md.update(buffer);
            byte[] digest = md.digest();
            res = encodeHexString(digest);
        } finally {
            try {
                if (fis!=null) fis.close();
            } catch (IOException e) {
            }
        }
        long usedT = System.currentTimeMillis()-startT;
        System.out.println("usedTime: "+usedT);
        return res;
    }

    final protected static char[] HEXARRAY = "0123456789abcdef".toCharArray();

    public static String encodeHexString( byte[] bytes ) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEXARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEXARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }


    public static String generateUniqueFilename(String prefix, String ending) {
        return prefix + UUID.randomUUID().toString() + ending;
    }

    /**
     * Used for classification / quantification.
     * Apply raster modifications like color deconvolution.
     * The output will be a ModifiedRaster. If the input is already a ModifiedRaster, no modification will be done.
     *
     * @param readRaster
     * @return
     */
    public static Raster getModifiedRaster(final Raster readRaster, final FeatureDescription featureDescription, final ColorModel colorModel, final int level) {
        return getModifiedRaster(readRaster, featureDescription, colorModel, false, 0, 0, "", level);
    }

    /**
     * Used for classification / quantification.
     * Apply raster modifications like color deconvolution.
     * The output will be a ModifiedRaster. If the input is already a ModifiedRaster, no modification will be done.
     * tileX, tileY and name are just for caching.
     * As raster identifier the raster hashcode will be appended to the name.
     *
     * @param readRaster
     * @return
     */
    public static Raster getModifiedRaster(final Raster readRaster, final FeatureDescription featureDescription, final ColorModel colorModel, boolean useCache, int tileX, int tileY, String name, int level) {
        if ((!(readRaster instanceof ModifiedRaster)) && (featureDescription.getDeconvChannel() > 0)) {
            PointAndName key = new PointAndName(tileX, tileY, name + readRaster.hashCode(),level, 100, 100, 100, 0, 0, 0, 0, null, null, null, null, true, true, true, featureDescription.getDeconvChannel(), featureDescription.getDeconvName(),null, true, null);
            Raster cachedRaster = null;
            if (useCache) OrbitTiledImage2.tileCache.getIfPresent(key);
            if (cachedRaster != null) {
                return cachedRaster;
            } else {
                Rectangle oriBounds = readRaster.getBounds();
                WritableRaster r = Raster.createWritableRaster(readRaster.getSampleModel(), readRaster.getDataBuffer(), new Point(readRaster.getMinX(), readRaster.getMinY()));
                r.setDataElements(0, 0, readRaster);
                WritableRaster wr = Raster.createWritableRaster(r.getSampleModel(), r.getDataBuffer(), new Point(0, 0));

                BufferedImage bb = new BufferedImage(colorModel, wr, colorModel.isAlphaPremultiplied(), null);
                if (featureDescription.getDeconvChannel() > 0) {
                    bb = Colour_Deconvolution.getProcessedImage(bb, featureDescription.getDeconvName(), featureDescription.getDeconvChannel() - 1, null);
                }
                ModifiedRaster rbb = new ModifiedRaster(bb.getRaster().createTranslatedChild(oriBounds.x, oriBounds.y));
                if (useCache) OrbitTiledImage2.tileCache.put(key, rbb);
                return rbb;
            }
        } else return readRaster;
    }


    /**
     * returns null if no image adjustments are available in db
     *
     * @param rdfId
     * @return
     * @throws SQLException
     */
    public static ImageAdjustments getAndParseImageAdjustments(int rdfId) throws Exception {
        List<RawMeta> rms = DALConfig.getImageProvider().LoadRawMetasByRawDataFileAndName(rdfId, RawUtilsCommon.STR_META_IMAGEADJUSTMENTS);
        if (rms != null && rms.size() > 0) {
            RawMeta rm = rms.get(0);
            return parseImageAdjustments(rm.getValue());
        }
        return null;
    }

    /**
     * parses imageAdjustment values, e.g. bri:0;con:232;r:0;g:0;b:0;gamma:100;deconvChan:0;deconvName:H&E
     *
     * @param vals
     * @return
     */
    public static ImageAdjustments parseImageAdjustments(String vals) {
        int gamma = 100;
        int brightness = 0;
        int contrast = 100;
        int red = 0;
        int green = 0;
        int blue = 0;
        int deconvChannel = 0;
        String deconvName = Colour_Deconvolution.DECONV_NONE;
        float[] channelContributions = null;

        String[] split = vals.split(";");
        if (split != null && split.length >= 5) {
            brightness = Integer.parseInt(split[0].split(":")[1]);
            contrast = Integer.parseInt(split[1].split(":")[1]);
            red = Integer.parseInt(split[2].split(":")[1]);
            green = Integer.parseInt(split[3].split(":")[1]);
            blue = Integer.parseInt(split[4].split(":")[1]);
            if (split.length > 5)
                gamma = Integer.parseInt(split[5].split(":")[1]);
            if (split.length > 6)
                deconvChannel = Integer.parseInt(split[6].split(":")[1]);
            if (split.length > 7)
                deconvName = split[7].split(":")[1];
            if (split.length > 8) {
                if (split[8].split(":")[0].equalsIgnoreCase("channelContributions")) {
                    String[] contribs = split[8].split(":")[1].split("_");   // e.g. 1.5699999_0.79999995
                    if (contribs!=null) {
                        channelContributions = new float[contribs.length];
                        for (int c=0; c<contribs.length; c++) {
                            channelContributions[c] = Float.parseFloat(contribs[c]);
                        }
                    }
                }
            }
        } else {
            logger.error("Cannot parse value string. Please ensure that it is in the format bri:<brightness>;con:<contrast>;r:<red>;g:<green>;b:<blue>;gamma:<gamma>;deconvChan:<deconvolution channel>;deconvName:<deconvolution name>. Current string is " + vals);
        }
        ImageAdjustments ia = new ImageAdjustments();
        ia.setBrightness(brightness);
        ia.setContrast(contrast);
        ia.setGamma(gamma);
        ia.setRed(red);
        ia.setGreen(green);
        ia.setBlue(blue);
        ia.setDeconvChannel(deconvChannel);
        ia.setDeconvName(deconvName);
        ia.setChannelContributions(channelContributions);
        return ia;
    }

    public static class ImageAdjustments implements Serializable {
        private int gamma = 100;
        private int brightness = 0;
        private int contrast = 100;
        private int red = 0;
        private int green = 0;
        private int blue = 0;
        private int deconvChannel = 0;
        private String deconvName = Colour_Deconvolution.DECONV_NONE;
        private float[] channelContributions;

        public ImageAdjustments() {
        }

        public int getBlue() {
            return blue;
        }

        public void setBlue(int blue) {
            this.blue = blue;
        }

        public int getBrightness() {
            return brightness;
        }

        public void setBrightness(int brightness) {
            this.brightness = brightness;
        }

        public int getContrast() {
            return contrast;
        }

        public void setContrast(int contrast) {
            this.contrast = contrast;
        }

        public int getDeconvChannel() {
            return deconvChannel;
        }

        public void setDeconvChannel(int deconvChannel) {
            this.deconvChannel = deconvChannel;
        }

        public String getDeconvName() {
            return deconvName;
        }

        public void setDeconvName(String deconvName) {
            this.deconvName = deconvName;
        }

        public int getGamma() {
            return gamma;
        }

        public void setGamma(int gamma) {
            this.gamma = gamma;
        }

        public int getGreen() {
            return green;
        }

        public void setGreen(int green) {
            this.green = green;
        }

        public int getRed() {
            return red;
        }

        public void setRed(int red) {
            this.red = red;
        }

        public float[] getChannelContributions() {
            return channelContributions;
        }

        public void setChannelContributions(float[] channelContributions) {
            this.channelContributions = channelContributions;
        }
    }

    /**
     * used to store pre-computed min,max values
     */
    public static class ImageAdjustCachedParams implements Serializable {
        private double gammaMin = 0;
        private double gammaMax = 0;
        private boolean gammaExtremaSet = false;
        private double contrastAverage = 0;
        private boolean contrastAverageSet = false;

        public double getContrastAverage() {
            return contrastAverage;
        }

        public void setContrastAverage(double contrastAverage) {
            this.contrastAverage = contrastAverage;
        }

        public boolean isContrastAverageSet() {
            return contrastAverageSet;
        }

        public void setContrastAverageSet(boolean contrastAverageSet) {
            this.contrastAverageSet = contrastAverageSet;
        }

        public boolean isGammaExtremaSet() {
            return gammaExtremaSet;
        }

        public void setGammaExtremaSet(boolean gammaExtremaSet) {
            this.gammaExtremaSet = gammaExtremaSet;
        }

        public double getGammaMax() {
            return gammaMax;
        }

        public void setGammaMax(double gammaMax) {
            this.gammaMax = gammaMax;
        }

        public double getGammaMin() {
            return gammaMin;
        }

        public void setGammaMin(double gammaMin) {
            this.gammaMin = gammaMin;
        }
    }


    public static class ScaleAndUnit implements Serializable {
        private double scale = 1d;
        private double scaleSquare = 1d;
        private String unit = OrbitUtils.muMeterUnicode;
        private String unitSquare = unit + (char) 178;

        public ScaleAndUnit() {
        }

        public ScaleAndUnit(double scale, double scaleSquare, String unit, String unitSquare) {
            this.scale = scale;
            this.scaleSquare = scaleSquare;
            this.unit = unit;
            this.unitSquare = unitSquare;
        }

        public double getScale() {
            return scale;
        }

        public void setScale(double scale) {
            this.scale = scale;
        }

        public double getScaleSquare() {
            return scaleSquare;
        }

        public void setScaleSquare(double scaleSquare) {
            this.scaleSquare = scaleSquare;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getUnitSquare() {
            return unitSquare;
        }

        public void setUnitSquare(String unitSquare) {
            this.unitSquare = unitSquare;
        }
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        String fn = "d:\\pic\\4059.svs";
        String digest = OrbitUtils.getDigest(fn);
        System.out.println(digest);
    }

}
