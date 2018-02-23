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
import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.dao.DAODataFile;
import com.actelion.research.orbit.imageAnalysis.dal.ImageProviderLocal;
import com.actelion.research.orbit.utils.PathResolver;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImageProviderLocalCached extends ImageProviderLocal {

    private static final Logger logger = LoggerFactory.getLogger(ImageProviderLocalCached.class);
    private String cacheDir;
    private final List<File> cachedFiles = new ArrayList<>();

    public ImageProviderLocalCached(String cacheDir) {
        this.cacheDir = cacheDir;
    }

    @Override
    public IOrbitImage createOrbitImage(RawDataFile rdf, int level) throws Exception {
        File file = new File (cacheDir + File.separator + rdf.getRawDataFileId()+"."+rdf.getEnding());

        if (!file.exists()) {
            clone(rdf,cacheDir);
        }

        if (file.exists()) {
            logger.info("using local file: "+file.getAbsolutePath());
            RawDataFile rdf2 = rdf.clone();
            rdf2.setFileName(rdf.getRawDataFileId()+"."+rdf.getEnding());
            rdf2.setDataPath(cacheDir);
            return super.createOrbitImage(rdf2, level);
        } else {
            logger.info("no local file: "+file.getAbsolutePath());
            return null;
        }
    }

    @Override
    public void close() throws IOException {
        super.close();
        for (File file: cachedFiles) {
            FileUtils.forceDelete(file);
        }
    }

    private void clone(RawDataFile rdf, String dir) throws IOException, SQLException {
        File dest = new File(dir);
        dest.mkdirs();
        FileUtils.cleanDirectory(dest);
        cloneGeneric(rdf,dir);
        if (rdf.getEnding().equalsIgnoreCase("ndpis")) {
            // download all channels
            File file = new File(dest.toString()+File.separator+rdf.getRawDataFileId()+"."+rdf.getEnding());
            String text = FileUtils.readFileToString(file);
            int[] rdfIds = extractNDPIIds(text);
            for (int id: rdfIds) {
                RawDataFile rdf2 = DAODataFile.LoadRawDataFile(id);
                cloneGeneric(rdf2,dir);
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

    private void cloneGeneric(RawDataFile rdf, String dir) throws IOException {
        cloneHTTP2(rdf,dir);
    }

    private void cloneHTTP(RawDataFile rdf, String dir) throws IOException {
        int rdfId = rdf.getRawDataFileId();
        URL url = new URL("http://ares.idorsia.com:8080/orbit/rdf?orbitId="+rdfId+"&output=raw&download=true");
        logger.info("downloading url: "+url);
        File file = new File(dir+File.separator+rdfId+"."+rdf.getEnding());
        FileUtils.copyURLToFile(url,file);
        cachedFiles.add(file);
    }

    private void cloneHTTP2(RawDataFile rdf, String dir) throws IOException {
        int rdfId = rdf.getRawDataFileId();
        URL url = new URL(PathResolver.getAbsolutFilenameOnServer(rdf));
        logger.info("downloading url: "+url);
        File file = new File(dir+File.separator+rdfId+"."+rdf.getEnding());
        FileUtils.copyURLToFile(url,file);
        cachedFiles.add(file);
    }
    
}
