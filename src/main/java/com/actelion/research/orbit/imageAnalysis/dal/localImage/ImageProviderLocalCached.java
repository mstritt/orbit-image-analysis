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

package com.actelion.research.orbit.imageAnalysis.dal.localImage;

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.dal.IImageProvider;
import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.dal.ImageProviderLocal;
import com.actelion.research.orbit.utils.RawUtilsCommon;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ImageProviderLocalCached extends ImageProviderLocal {

    private static final Logger logger = LoggerFactory.getLogger(ImageProviderLocalCached.class);
    private String cacheDir;
    private final List<File> cachedFiles = new ArrayList<>();
    private IImageProvider imageProvider;

    public ImageProviderLocalCached(String cacheDir, IImageProvider imageProvider) {
        this.cacheDir = cacheDir;
        this.imageProvider = imageProvider;
    }

    @Override
    public synchronized IOrbitImage createOrbitImage(RawDataFile rdf, int level) throws Exception {
        // special tif treatment: all smaller levels needed
        if (rdf.getFileType().equals(RawUtilsCommon.DATA_TYPE_IMAGE_TIFF)) {
           for (int l=0; l<level; l++) {
               stageFile(rdf,l);
           }
        }
        File file = stageFile(rdf,level);
        if (file.exists()) {
            logger.info("using local file: "+file.getAbsolutePath());
            RawDataFile rdf2 = rdf.clone();
            String ending =  rdf.getEnding();
            rdf2.setFileName(rdf.getRawDataFileId()+"."+ending);
            rdf2.setDataPath(cacheDir);
            return super.createOrbitImage(rdf2, level);
        } else {
            logger.info("no local file: "+file.getAbsolutePath());
            return null;
        }
    }

    public synchronized File stageFile(RawDataFile rdf, int level) throws Exception {
        String ending = getEnding(rdf,level);
        File file = new File (cacheDir + File.separator + rdf.getRawDataFileId()+"."+ending);
        if (!file.exists()) {
            clone(rdf,level,cacheDir);
        }
        return file;
    }

    @Override
    public void close() throws IOException {
        super.close();
//        for (File file: cachedFiles) {
//            try {
//               FileUtils.forceDelete(file);
//            } catch (Exception e) {
//               file.deleteOnExit();
//            }
//        }
    }

    private void clone(RawDataFile rdf, int level, String dir) throws Exception {
        File dest = new File(dir);
        dest.mkdirs();
        cloneGeneric(rdf,level,dir);
        // TODO other companion files?
        if (rdf.getEnding().equalsIgnoreCase("ndpis")) {
            // download all channels
            File file = new File(dest.toString()+File.separator+rdf.getRawDataFileId()+"."+rdf.getEnding());
            String text = FileUtils.readFileToString(file);
            int[] rdfIds = extractNDPIIds(text);
            for (int id: rdfIds) {
                RawDataFile rdf2 = DALConfig.getImageProvider().LoadRawDataFile(id);
                cloneGeneric(rdf2,level,dir);
            }
        }

        logger.info("download ok ("+rdf+")");
    }

    private int[] extractNDPIIds(String ndpisText)  {
        int[] ndpiFiles = null;
        String[] lines = ndpisText.split("\r\n");
        for (String line : lines) {
            int eq = line.indexOf('=');
            if (eq >= 0) {
                String key = line.substring(0, eq).trim();
                String value = line.substring(eq + 1).trim();

                if (key.equals("NoImages")) {
                    ndpiFiles = new int[Integer.parseInt(value)];
                } else if (key.startsWith("Image")) {
                    int index = Integer.parseInt(key.replaceAll("Image", ""));
                    ndpiFiles[index] = Integer.parseInt(value.toLowerCase().replace(".ndpi", "").trim());
                }
            }
        }
        return ndpiFiles;
    }

    private void cloneGeneric(RawDataFile rdf, int level, String dir) throws IOException {
        cloneHTTP(rdf,level,dir);
       
    }

    private void cloneHTTP(RawDataFile rdf, int level, String dir) throws IOException {
        int rdfId = rdf.getRawDataFileId();
        URL url;
        if (rdf.getFileType().equals(RawUtilsCommon.DATA_TYPE_IMAGE_TIFF)) {
            url = level == 0 ? imageProvider.getRawDataFileUrl(rdf) : imageProvider.getRawDataFileUrl(rdf, level);
            url = new URL(url.toString() + "&raw=true");
        } else {
            url = imageProvider.getRawDataFileUrl(rdf);
        }
        logger.info("Downloading file from url: "+url);
        String ending = getEnding(rdf,level);
        File file = new File(dir+File.separator+rdfId+"."+ending);
        FileUtils.copyURLToFile(url,file);
        logger.info("Successfully cached file to local disk: "+url);
        cachedFiles.add(file);
    }

    private String getEnding(RawDataFile rdf, int level) {
        boolean multiLevelTiff  = rdf.getFileType().equals(RawUtilsCommon.DATA_TYPE_IMAGE_TIFF);
        String ending = multiLevelTiff? (level==0? rdf.getEnding() : level +"."+rdf.getEnding()) : rdf.getEnding();
        return ending;
    }


}
