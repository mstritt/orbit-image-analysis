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

package com.actelion.research.orbit.imageAnalysis.dal;

import com.actelion.research.orbit.beans.RawAnnotation;
import com.actelion.research.orbit.beans.RawData;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.beans.RawMeta;
import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.imageAnalysis.dal.localImage.DAODataFileSQLite;
import com.actelion.research.orbit.imageAnalysis.dal.localImage.DAORawAnnotationSQLite;
import com.actelion.research.orbit.imageAnalysis.dal.localImage.OrbitImageScifio;
import com.actelion.research.orbit.imageAnalysis.dal.localImage.OrbitImageTiff;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitImagePlanar;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.imageAnalysis.utils.TiffConverter;
import com.actelion.research.orbit.utils.Logger;
import com.actelion.research.orbit.utils.RawMetaFactoryData;
import com.actelion.research.orbit.utils.RawMetaFactoryFile;
import com.actelion.research.orbit.utils.RawUtilsCommon;
import io.scif.SCIFIO;
import org.scijava.Context;

import javax.media.jai.PlanarImage;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.prefs.Preferences;

public class ImageProviderLocal extends ImageProviderNoop {

    private static final Logger logger = Logger.getLogger(ImageProviderLocal.class);
    private Context context;
    private RawData rawData;

    public ImageProviderLocal() {
        rawData = new RawData();
        rawData.setBioLabJournal("local");
        rawData.setModifyDate(new Date());
        rawData.setReferenceDate(new Date());
        rawData.setRawDataId(1);
        rawData.setUserId("orbit");
    }

    @Override
    public List<RawDataFile> browseImages(Object parentObj) throws Exception {
        List<RawDataFile> rdfList = new ArrayList<>();
        JFileChooser fileChooser = OrbitUtils.buildOpenFileFileChooser();
        SCIFIO scifio = new SCIFIO();
        context = scifio.getContext();
//        Format[] formats = new Format[]{new TIFFFormat() {
//            @Override
//            public String getFormatName() {
//                return "TIFF";
//            }
//        }};
//        JFileChooser fileChooser = scifio.gui().buildFileChooser(scifio.gui().buildFileFilters(Arrays.asList(formats)));

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
                    String fn = file.getAbsolutePath();
                    int id = DAODataFileSQLite.ExistRawDataFile(fn);
                    RawDataFile rdf;
                    if (id>0) {
                        rdf = DAODataFileSQLite.LoadRawDataFile(id);
                    } else {
                        rdf = createRDF(file.getAbsolutePath());
                        DAODataFileSQLite.InsertRawDataFile(rdf);
                    }
                    rdfList.add(rdf);
                }
            }
        } else {
            logger.trace("browse images canceled.");
        }
        return rdfList;
    }

    @Override
    public boolean useCustomBrowseImagesDialog() {
        return true;
    }


    private RawDataFile createRDF(String fn) {
        File file = new File(fn);
        // TODO: user and type
        RawDataFile rdf = new RawDataFile();
        rdf.setDataPath(file.getParentFile().getAbsolutePath());
        rdf.setFileName(file.getName());
        rdf.setFileSize(file.length());
        rdf.setModifyDate(new Date(file.lastModified()));
        rdf.setReferenceDate(new Date(file.lastModified()));
        rdf.setRawDataId(rawData.getRawDataId());
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
        List<RawMeta> rmList =  new ArrayList<>();
        RawDataFile rdf = LoadRawDataFile(rdfId);
        IOrbitImage image = createOrbitImage(rdf,0);

        RawMetaFactoryFile rmff = new RawMetaFactoryFile(rdfId,new Date(),"orbit");
        rmList.add(rmff.createMetaStr("Filename",rdf.getFileName()));
        rmList.add(rmff.createMetaStr("Filesize", RawUtilsCommon.formatFileSize(rdf.getFileSize())));
        if (image!=null) {
            rmList.add(rmff.createMetaInt("ImageLength", image.getHeight()));
            rmList.add(rmff.createMetaInt("ImageWidth", image.getWidth()));
        }
        return rmList;
    }

    @Override
    public List<RawMeta> LoadRawMetasByRawData(int i) throws Exception {
        List<RawMeta> rmList =  new ArrayList<>();
        RawMetaFactoryData rmfd = new RawMetaFactoryData (rawData.getRawDataId(),new Date(),"orbit");
        rmList.add(rmfd.createMetaStr("Filesystem","local"));
        return rmList;
    }


    @Override
    public IOrbitImage createOrbitImage(RawDataFile rdf, int level) throws Exception {
        if (rdf==null) return null;
        String ending = RawUtilsCommon.getExtension(rdf.getFileName());
        if (ending.equals("bmp")||ending.equals("png")||ending.equals("dcm")||ending.equals("lif")||ending.equals("ziv")) {
            PlanarImage pi = TiffConverter.loadFromFile(rdf.getDataPath() + File.separator + rdf.getFileName());
            return new OrbitImagePlanar(pi, rdf.getFileName());
        } else if (ending.equals("tif")||ending.equals("tiff"))  {
            return new OrbitImageTiff(rdf.getDataPath() + File.separator + rdf.getFileName(), level);
        }
        else {
            return new OrbitImageScifio(rdf.getDataPath() + File.separator + rdf.getFileName(), level);
        }
    }

    public BufferedImage getThumbnail(String filename) throws Exception {
        File file = new File(filename);
        String ending = RawUtilsCommon.getExtension(file.getName()) ;
        BufferedImage bi = null;
        if (ending.equals("bmp")||ending.equals("png")||ending.equals("dcm")||ending.equals("lif")||ending.equals("ziv")) {
            bi = TiffConverter.getDownsampledImage(file.getPath(), 300, -1, 1, false);
        } else {
            try {
                if (ending.equals("tif") || ending.equals(".tiff")) {
                    OrbitImageTiff oi = new OrbitImageTiff(file.getAbsolutePath(), 0);
                    bi = oi.getThumbnail();
                    oi.close();
                }  else {
                    OrbitImageScifio oi = new OrbitImageScifio(file.getAbsolutePath(), 0);
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
        if (context!=null)
            context.dispose();
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


    public static void main(String[] args) throws Exception {
        ImageProviderLocal ipl = new ImageProviderLocal();
        ipl.browseImages(null);
    }
}
