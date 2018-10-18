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

package com.actelion.research.orbit.imageAnalysis.dal;

import com.actelion.research.orbit.beans.RawAnnotation;
import com.actelion.research.orbit.beans.RawData;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.beans.RawMeta;
import com.actelion.research.orbit.dal.IModelAwareImageProvider;
import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.imageAnalysis.dal.localImage.DAODataFileSQLite;
import com.actelion.research.orbit.imageAnalysis.dal.localImage.DAORawAnnotationSQLite;
import com.actelion.research.orbit.imageAnalysis.dal.localImage.OrbitImageBioformats;
import com.actelion.research.orbit.imageAnalysis.dal.localImage.OrbitImageTiff;
import com.actelion.research.orbit.imageAnalysis.dal.localImage.ndpi.NDPIImageNative;
import com.actelion.research.orbit.imageAnalysis.dal.localImage.ndpi.NDPISImageNative;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitImagePlanar;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.imageAnalysis.utils.TiffConverter;
import com.actelion.research.orbit.utils.RawMetaFactoryData;
import com.actelion.research.orbit.utils.RawMetaFactoryFile;
import com.actelion.research.orbit.utils.RawUtilsCommon;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import loci.formats.FormatException;
import org.slf4j.LoggerFactory;

import javax.media.jai.PlanarImage;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.prefs.Preferences;

public class ImageProviderLocal extends ImageProviderNoop implements IModelAwareImageProvider, ChangeListener {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ImageProviderLocal.class);
    private RawData rawData;
    private static int series = 0;
    private OrbitModel orbitModel = null;
    private LoadingCache<Integer,List<RawMeta>> rawMetaFileCache = CacheBuilder.newBuilder().build(new CacheLoader<Integer, List<RawMeta>>() {
        @Override
        public List<RawMeta> load(Integer rdfId) throws Exception {
            List<RawMeta> rmList =  new ArrayList<>();
            RawDataFile rdf = LoadRawDataFile(rdfId);
            IOrbitImage image = createOrbitImage(rdf,0);

            RawMetaFactoryFile rmff = new RawMetaFactoryFile(rdfId,new Date(),"orbit");
            rmList.add(rmff.createMetaStr("Filename",rdf.getFileName()));
            rmList.add(rmff.createMetaStr("Filesize", RawUtilsCommon.formatFileSize(rdf.getFileSize())));
            rmList.add(rmff.createMetaInt("Orbit ID", rdf.getRawDataFileId()));
            if (rdf.getReferenceDate() != null)
                rmList.add(rmff.createMetaDate("Create Date", rdf.getReferenceDate()));
            if (rdf.getModifyDate() != null)
                rmList.add(rmff.createMetaDate("Update Date", rdf.getModifyDate()));
            if (image!=null) {
                rmList.add(rmff.createMetaInt(RawUtilsCommon.STR_META_IMAGE_IMAGEHEIGHT, image.getHeight()));
                rmList.add(rmff.createMetaInt(RawUtilsCommon.STR_META_IMAGE_IMAGEWIDTH, image.getWidth()));

                if (image instanceof OrbitImageBioformats) {
                    OrbitImageBioformats oib = (OrbitImageBioformats) image;
                    if (oib.getPixelsPhysicalSizeX()!=null &&  oib.getPixelsPhysicalSizeX().value()!=null) {
                        rmList.add(rmff.createMetaDouble(RawUtilsCommon.STR_META_IMAGE_SCALE, oib.getPixelsPhysicalSizeX().value().doubleValue()));
                    }
                } else
                if (image instanceof NDPIImageNative) {
                    NDPIImageNative img = (NDPIImageNative) image;
                    rmList.add(rmff.createMetaDouble(RawUtilsCommon.STR_META_IMAGE_SCALE, img.getImageInfo().resolutionMuMperPixel));
                } else
                if (image instanceof NDPISImageNative) {
                    NDPISImageNative img = (NDPISImageNative) image;
                    rmList.add(rmff.createMetaDouble(RawUtilsCommon.STR_META_IMAGE_SCALE, img.getImageInfo().resolutionMuMperPixel));
                }
            }

            return rmList;
        }
    });
    public static boolean NDPI_JAVA_FALLBACK = false;

    public ImageProviderLocal() {
        rawData = new RawData();
        rawData.setBioLabJournal("local");
        rawData.setModifyDate(new Date());
        rawData.setReferenceDate(new Date());
        rawData.setRawDataId(1);
        rawData.setUserId("orbit");
    }

    @Override
    public void setOrbitModel(Object orbitModel) {
        if (orbitModel instanceof  OrbitModel) {
            this.orbitModel = new OrbitModel((OrbitModel) orbitModel);
        } else {
            logger.warn("this image provider only supports models of type OrbitModel");
        }
    }

    @Override
    public OrbitModel getOrbitModel() {
        return orbitModel;
    }

    @Override
    public List<RawDataFile> browseImages(Object parentObj) throws Exception {
        List<RawDataFile> rdfList = new ArrayList<>();
        this.series = 0;
        JFileChooser fileChooser = OrbitUtils.buildOpenFileFileChooser(this);
        Preferences prefs = Preferences.userNodeForPackage(this.getClass());
        String dir = prefs.get("ImageProviderLocal.OpenFileCurrentDir", null);
        if (dir != null) {
            File cd = new File(dir);
            fileChooser.setCurrentDirectory(cd);
        }
        Component parent = null;
        if (parentObj != null && parentObj instanceof Component) {
            parent = (Component) parentObj;
        }
        int returnVal = fileChooser.showOpenDialog(parent);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            prefs.put("ImageProviderLocal.OpenFileCurrentDir", fileChooser.getCurrentDirectory().getAbsolutePath());
            File[] files = fileChooser.getSelectedFiles();
            if (files != null && files.length > 0) {
                for (File file : files) {
                    RawDataFile rdf = registerFile(file,series);
                    rdfList.add(rdf);
                }
            }
        } else {
            logger.trace("browse images canceled.");
        }
        return rdfList;
    }

    public RawDataFile registerFile(File file, int series) throws SQLException {
        String fn = file.getAbsolutePath();
        int id = DAODataFileSQLite.ExistRawDataFile(fn,series);
        RawDataFile rdf;
        if (id>0) {
            rdf = DAODataFileSQLite.LoadRawDataFile(id);
            if (!file.getParent().equals(rdf.getDataPath())) {
                rdf.setDataPath(file.getParent());
                DAODataFileSQLite.UpdateRawDataFile(rdf);
            }
        } else {
            rdf = createRDF(file.getAbsolutePath(),series);
            DAODataFileSQLite.InsertRawDataFile(rdf);
        }
       //RawDataFile rdf = createRDF(file.getAbsolutePath(),series);

        return rdf;
    }

    @Override
    public boolean useCustomBrowseImagesDialog() {
        return true;
    }


    public RawDataFile createRDF(String fn,int series) {
        File file = new File(fn);
        String md5 = "";
        try {
            md5 = OrbitUtils.getDigest(fn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO: user and type
        RawDataFile rdf = new RawDataFile();
        rdf.setDataPath(file.getParentFile().getAbsolutePath());
        rdf.setFileName(file.getName());
        rdf.setFileSize(file.length());
        rdf.setModifyDate(new Date(file.lastModified()));
        rdf.setReferenceDate(new Date(file.lastModified()));
        rdf.setRawDataId(rawData.getRawDataId());
        rdf.setMd5(md5);
        rdf.setSeriesNum(series);
        return rdf;
    }


    @Override
    public RawDataFile LoadRawDataFile(int rdfId) throws Exception {
        return DAODataFileSQLite.LoadRawDataFile(rdfId);
    }

    @Override
    public RawData LoadRawData(int i) throws Exception {
        return rawData;
    }

    @Override
    public List<RawMeta> LoadRawMetasByRawDataFile(int rdfId) throws Exception {
        return rawMetaFileCache.get(rdfId);
    }

    @Override
    public List<RawMeta> LoadRawMetasByRawDataFileAndName(int rdfId, String name) throws Exception {
        List<RawMeta> allMetas =  LoadRawMetasByRawDataFile(rdfId);
        List<RawMeta> filteredMetas = new ArrayList<>();
        if (allMetas!=null) {
            for (RawMeta rm: allMetas) {
                if (rm.getName().equals(name)) {
                    filteredMetas.add(rm);
                }
            }
        }
        return filteredMetas;
    }

    /**
     * Ignores rdId and loads default metas. LocalFiles don't have a rawData container.
     */
    @Override
    public List<RawMeta> LoadRawMetasByRawData(int rdId) throws Exception {
        List<RawMeta> rmList =  new ArrayList<>();
        RawMetaFactoryData rmfd = new RawMetaFactoryData (rawData.getRawDataId(),new Date(),"orbit");
        rmList.add(rmfd.createMetaStr("Filesystem","local"));
        return rmList;
    }

    /**
     * Ignores rdId, see LoadRawMetasByRawData(rdId)
     */
    @Override
    public List<RawMeta> LoadRawMetasByRawDataAndName(int rdId, String name) throws Exception {
        List<RawMeta> allMetas =  LoadRawMetasByRawData(rdId);
        List<RawMeta> filteredMetas = new ArrayList<>();
        if (allMetas!=null) {
            for (RawMeta rm: allMetas) {
                if (rm.getName().equals(name)) {
                    filteredMetas.add(rm);
                }
            }
        }
        return filteredMetas;
    }

    /**
     * Small images (bmp,png,dcm.lif,zif) are loaded wie TiffConverter (JAI), tiff files via OrbitImageTiff (better performance) and everything else via Scifio.
     * @param rdf
     * @param level
     * @return
     * @throws Exception
     */
    @Override
    public IOrbitImage createOrbitImage(RawDataFile rdf, int level) throws Exception {
        if (rdf==null) return null;
        String ending = RawUtilsCommon.getExtension(rdf.getFileName());
        if (ending.equals("bmp")||ending.equals("png")) {
            PlanarImage pi = TiffConverter.loadFromFile(rdf.getDataPath() + File.separator + rdf.getFileName());
            return new OrbitImagePlanar(pi, rdf.getFileName());
        } else if (!OrbitUtils.isOME_TIFF(rdf.getFileName()) && (ending.equals("tif")||ending.equals("tiff")))  {
            try {
                return new OrbitImageTiff(rdf.getDataPath() + File.separator + rdf.getFileName(), level);
            } catch (FormatException e) {  // for tiff files >=16 bits per sample
                return new OrbitImageBioformats(rdf.getDataPath() + File.separator + rdf.getFileName(), level, rdf.getSeriesNum(), orbitModel);
            }
        }
        if (ending.equals("ndpi") && !NDPI_JAVA_FALLBACK) {
            try {
                return new NDPIImageNative(rdf.getDataPath() + File.separator + rdf.getFileName(), level);
            } catch (UnsatisfiedLinkError err) {
                NDPI_JAVA_FALLBACK = true;
                logger.debug("using java NDPI fallback");
                return new OrbitImageBioformats(rdf.getDataPath() + File.separator + rdf.getFileName(), level, rdf.getSeriesNum(), orbitModel);
            }
        }
        if (ending.equals("ndpis") && !NDPI_JAVA_FALLBACK) {
            try {
                //return null;
                return new NDPISImageNative(rdf.getDataPath() + File.separator + rdf.getFileName(), level);
            } catch (UnsatisfiedLinkError err) {
                NDPI_JAVA_FALLBACK = true;
                logger.debug("using java NDPIS fallback");
                return new OrbitImageBioformats(rdf.getDataPath() + File.separator + rdf.getFileName(), level, rdf.getSeriesNum(), orbitModel);
            }
        }
        else {
            return new OrbitImageBioformats(rdf.getDataPath() + File.separator + rdf.getFileName(), level, rdf.getSeriesNum(), orbitModel);
        }
    }

    public BufferedImage getThumbnail(String filename) throws Exception {
        File file = new File(filename);
        String ending = RawUtilsCommon.getExtension(file.getName()) ;
        BufferedImage bi = null;
        if (ending.equals("bmp")||ending.equals("png")) {
            bi = TiffConverter.getDownsampledImage(file.getPath(), 300, -1, 1, false);
        } else {
            try {
                if (!OrbitUtils.isOME_TIFF(filename) && (ending.equals("tif")||ending.equals("tiff"))) {
                    try {
                        OrbitImageTiff oi = new OrbitImageTiff(file.getAbsolutePath(), 0);
                        bi = oi.getThumbnail();
                        oi.close();
                    }  catch (FormatException e) {  // for tiff files >=16 bits per sample
                        OrbitImageBioformats oi = new OrbitImageBioformats(file.getAbsolutePath(), 0, series, orbitModel);
                        bi = oi.getThumbnail();
                        oi.close();
                    }
                    
                }  else {
                  //  OrbitImageScifio oi = new OrbitImageScifio(file.getAbsolutePath(), 0);
                    logger.debug("loading thumbnail of file "+filename+", series: "+series);
                    OrbitImageBioformats oi = new OrbitImageBioformats(file.getAbsolutePath(), 0, series, orbitModel);
                    bi = oi.getThumbnail();
                    oi.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bi;
    }

    @Override
    public BufferedImage getThumbnail(RawDataFile rdf) throws Exception {
        return getThumbnail(rdf.getDataPath() + File.separator + rdf.getFileName());
    }

    @Override
    public void close() throws IOException {

    }


    // search

    @Override
    public List<RawDataFile> LoadRawDataFilesSearch(String search, boolean b) throws Exception {
        return LoadRawDataFilesSearchFast(search,1000, Arrays.asList(RawUtilsCommon.fileTypesImage));
    }

    @Override
    public List<RawDataFile> LoadRawDataFilesSearch(String search, boolean andMode, int searchLimit, List<String> fileTypes) throws Exception {
        return LoadRawDataFilesSearchFast(search,1000, Arrays.asList(RawUtilsCommon.fileTypesImage));
    }

    @Override
    public List<RawDataFile> LoadRawDataFilesByFilenameStart(String search, boolean andMode, int searchLimit, List<String> fileTypes, String s1) throws Exception {
        return LoadRawDataFilesSearchFast(search,1000, Arrays.asList(RawUtilsCommon.fileTypesImage));
    }

    @Override
    public List<RawDataFile> LoadRawDataFilesSearchFast(String search, int searchLimit, List<String> list) throws Exception {
        return DAODataFileSQLite.LoadRawDataFilesSearchFast(search,searchLimit,null);
    }




    // raw annotations

    @Override
    public RawAnnotation LoadRawAnnotation(int rawAnnotationId) throws Exception {
        return DAORawAnnotationSQLite.LoadRawAnnotation(rawAnnotationId);
    }

    @Override
    public List<RawAnnotation> LoadRawAnnotationsByRawDataFile(int rdfID) throws Exception {
        return DAORawAnnotationSQLite.LoadRawAnnotationsByRawDataFile(rdfID);
    }

    @Override
    public List<RawAnnotation> LoadRawAnnotationsByRawDataFile(int rdfID, int rawAnnotationType) throws Exception {
        return DAORawAnnotationSQLite.LoadRawAnnotationsByRawDataFile(rdfID,rawAnnotationType);
    }

    @Override
    public List<RawAnnotation> LoadRawAnnotationsByType(int rawAnnotationType) throws Exception {
        return DAORawAnnotationSQLite.LoadRawAnnotationsByType(rawAnnotationType);
    }

    @Override
    public int InsertRawAnnotation(RawAnnotation rawAnnotation) throws Exception {
        return DAORawAnnotationSQLite.InsertRawAnnotation(rawAnnotation);
    }

    @Override
    public boolean UpdateRawAnnotation(RawAnnotation rawAnnotation) throws Exception {
        return DAORawAnnotationSQLite.UpdateRawAnnotation(rawAnnotation);
    }

    @Override
    public boolean DeleteRawAnnotation(int rawAnnotationId) throws Exception {
       return DAORawAnnotationSQLite.DeleteRawAnnotation(rawAnnotationId);
    }

    @Override
    public boolean DeleteRawAnnotationAllWithType(int rdfId, int rawAnnotationType) throws Exception {
        return DAORawAnnotationSQLite.DeleteRawAnnotationAllWithType(rdfId,rawAnnotationType);
    }


    // DB tools

    /**
     * Checks if saved RawDataFiles still physically exist on local disk (path+filename) and removes RawDataFile and RawAnnotation entries if not.
     */
    public static void DBCleanup() throws Exception {
        List<RawDataFile> rdfList = DAODataFileSQLite.LoadRawDataFiles(); // load all RDFs
        if (rdfList!=null && rdfList.size()>0) {
            for (RawDataFile rdf: rdfList) {
                File file = new File(rdf.getDataPath()+File.separator+rdf.getFileName());
                if (!file.exists()) {
                    DAORawAnnotationSQLite.DeleteRawAnnotationsByRDF(rdf.getRawDataFileId());
                    DAODataFileSQLite.DeleteRawDataFile(rdf.getRawDataFileId());
                    logger.info("local db entries removed for non existing file "+file.getAbsolutePath());
                }
            }
        }
    }


    @Override
    public boolean authenticateUser(String s, String s1) {
        return true;
    }


    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() instanceof Integer) {
            this.series = (Integer) e.getSource();
            logger.debug("series set to "+this.series);
        }
    }

    public static void main(String[] args) throws Exception {
        ImageProviderLocal.DBCleanup();

    }


}
