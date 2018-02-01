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


import com.actelion.research.mapReduceGeneric.IRemoteContextStore;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Samba implementation of a IRemoteContextStore
 */
public class SmbUtils implements IRemoteContextStore {

    private final static int BUFFER_SIZE = 16384;
    private NtlmPasswordAuthentication auth;
    private String share;


    /**
     * Authentificates via domain/username:password if password !=null, otherwise just via username (used as userinfo).
     *
     * @param username
     * @param password
     * @param domain
     * @param share
     */
    public SmbUtils(String username, String password, String domain, String share) {
        if (password != null)
            this.auth = new NtlmPasswordAuthentication(domain, username, password);
        else if (username != null)
            this.auth = new NtlmPasswordAuthentication(username);
        else this.auth = null;

        this.share = share;
    }

    @Override
    public void copyToRemote(byte[] bytes, String remoteFolder, String fileNameNew) throws IOException {
        writeRemote(remoteFolder + File.separator + fileNameNew, bytes);
    }

    /**
     * @param remoteFile
     * @param remoteFolder
     * @throws IOException
     */
    private void deleteOnRemote(String remoteFile, String remoteFolder) throws IOException {
        String dir = "";
        if (remoteFolder != null)
            dir = remoteFolder + File.separator;
        String fname = share + File.separator + dir + remoteFile;
        fname = fname.replace('\\', '/');

        SmbFile file = new SmbFile(fname, auth);
        file.delete();
    }

    /**
     * @param remoteFile
     * @throws IOException
     */
    private void deleteOnRemote(String remoteFile) throws IOException {
        deleteOnRemote(remoteFile, null);
    }


    /**
     * Generates a unique filename, e.g. prefix+UUID+ending </br>
     * No "." will be added automatically before the ending, so the ending should contain the point.
     *
     * @param prefix
     * @param ending
     * @return
     */
    @Override
    public String generateUniqueFilename(String prefix, String ending) {
        return prefix + UUID.randomUUID().toString() + ending;
    }


    @Override
    public byte[] readFromRemote(String remoteFile) throws IOException {
        return readFromRemote(remoteFile, SmbUtils.BUFFER_SIZE);
    }

    @Override
    public List<String> listFilenames(String remoteFolder) throws IOException {
        List<String> flist = new ArrayList<>();
        SmbFile file = new SmbFile(share + "/" + remoteFolder + "/");
        SmbFile[] files = file.listFiles();
        if (files != null && files.length > 0) {
            for (SmbFile f : files) {
                flist.add(f.getName());
            }
        }
        return flist;
    }

    private byte[] readFromRemote(String remoteFile, int buffersize) throws IOException {
        return readFromRemote(remoteFile, buffersize, false);
    }


    private byte[] readFromRemote(String remoteFile, int buffersize, boolean zipped) throws IOException {

        SmbFileInputStream smbfis = null;
        ByteArrayOutputStream bsos = null;
        GZIPInputStream zip = null;

        String fname = share + File.separator + remoteFile;
        fname = fname.replace('\\', '/');
        SmbFile smbFile = new SmbFile(fname, auth);

        smbfis = new SmbFileInputStream(smbFile);
        bsos = new ByteArrayOutputStream();
        if (zipped) zip = new GZIPInputStream(smbfis);

        try {
            byte[] buffer = new byte[buffersize];
            int bytesRead = 0;
            if (zipped) {
                while ((bytesRead = zip.read(buffer)) > 0) {
                    bsos.write(buffer, 0, bytesRead);
                }
            } else {
                while ((bytesRead = smbfis.read(buffer)) > 0) {
                    bsos.write(buffer, 0, bytesRead);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        bsos.flush();
        byte[] b = bsos.toByteArray();
        bsos.close();
        smbfis.close();
        if (zipped) zip.close();

        return b;
    }


    private boolean writeRemote(String path, byte[] data) throws IOException {
        return writeRemote(path, data, false);
    }


    private boolean writeRemote(String path, byte[] data, boolean zipped) throws IOException {

        String fname = share + File.separator + path;
        fname = fname.replace('\\', '/');
        jcifs.smb.SmbFile file = new jcifs.smb.SmbFile(fname, auth);

        jcifs.smb.SmbFile dir = new jcifs.smb.SmbFile(file.getParent(), auth);
        if (!dir.exists()) dir.mkdirs();

        jcifs.smb.SmbFileOutputStream bos = null;
        GZIPOutputStream zip = null;

        bos = new jcifs.smb.SmbFileOutputStream(file);
        if (zipped) {
            zip = new GZIPOutputStream(bos);
            zip.write(data);
            zip.flush();
            zip.close();
        } else
            bos.write(data);

        bos.flush();
        bos.close();

        return true;
    }

}
