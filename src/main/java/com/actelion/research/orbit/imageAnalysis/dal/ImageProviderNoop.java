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

import com.actelion.research.orbit.beans.*;
import com.actelion.research.orbit.dal.IImageProvider;
import com.actelion.research.orbit.dal.IOrbitImage;
import com.actelion.research.orbit.gui.AbstractOrbitTree;
import com.actelion.research.orbit.gui.IFileListCellRenderer;
import com.actelion.research.orbit.gui.IOrbitTree;
import com.actelion.research.orbit.lims.LIMSBioSample;
import com.actelion.research.orbit.utils.IRdfToInputStream;

import javax.swing.*;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.ExpandVetoException;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ImageProviderNoop implements IImageProvider {
    @Override
    public List<RawData> LoadRawDataByBioLabJournal(String s) throws Exception {
        return new ArrayList<>();
    }

    @Override
    public RawData LoadRawData(int i) throws Exception {
        return null;
    }

    @Override
    public boolean UpdateRawData(RawData rawData) throws Exception {
        return false;
    }

    @Override
    public RawDataFile LoadRawDataFile(int i) throws Exception {
        return null;
    }

    @Override
    public List<RawDataFile> LoadRawDataFiles(int i) throws Exception {
        return new ArrayList<>();
    }

    @Override
    public List<RawDataFile> LoadRawDataFiles(int i, int i1) throws Exception {
        return new ArrayList<>();
    }

    @Override
    public List<RawDataFile> LoadRawDataFiles(int i, List<String> list, int i1) throws Exception {
        return new ArrayList<>();
    }

    @Override
    public List<RawDataFile> LoadRawDataFilesSearch(String s, boolean b) throws Exception {
        return new ArrayList<>();
    }

    @Override
    public List<RawDataFile> LoadRawDataFilesSearch(String s, boolean b, int i, List<String> list) throws Exception {
        return new ArrayList<>();
    }

    @Override
    public List<RawDataFile> LoadRawDataFilesByFilenameStart(String s, boolean b, int i, List<String> list, String s1) throws Exception {
        return new ArrayList<>();
    }

    @Override
    public List<RawDataFile> LoadRawDataFilesSearchFast(String s, int i, List<String> list) throws Exception {
        return new ArrayList<>();
    }

    @Override
    public List<RawDataFile> LoadRawDataFilesByPlateName(String s, int i) throws Exception {
        return new ArrayList<>();
    }

    @Override
    public List<RawDataFile> browseImages(Object o) throws Exception {
        return null;
    }

    @Override
    public boolean useCustomBrowseImagesDialog() {
        return false;
    }

    @Override
    public boolean UpdateRawDataFile(RawDataFile rawDataFile) throws Exception {
        return false;
    }

    @Override
    public URL getRawDataFileUrl(RawDataFile rawDataFile) {
        return null;
    }

    @Override
    public URL getRawDataFileUrl(RawDataFile rawDataFile, int i) {
        return null;
    }

    @Override
    public URL getRawDataFileThumbnailUrl(RawDataFile rawDataFile) {
        return null;
    }

    @Override
    public BufferedImage getThumbnail(RawDataFile rawDataFile) throws Exception {
        return null;
    }

    @Override
    public BufferedImage getOverviewImage(RawDataFile rdf) throws Exception {
        return null;
    }

    @Override
    public BufferedImage getLabelImage(RawDataFile rdf) throws Exception {
        return null;
    }

    @Override
    public IRdfToInputStream getRdfToInputStream() {
        return null;
    }

    @Override
    public List<RawMeta> LoadRawMetasByRawDataFile(int i) throws Exception {
        return new ArrayList<>();
    }

    @Override
    public List<RawMeta> LoadRawMetasByRawData(int i) throws Exception {
        return new ArrayList<>();
    }

    @Override
    public List<RawMeta> LoadRawMetasByRawDataFileAndName(int i, String s) throws Exception {
        return new ArrayList<>();
    }

    @Override
    public List<RawMeta> LoadRawMetasByRawDataAndName(int i, String s) throws Exception {
        return new ArrayList<>();
    }

    @Override
    public int InsertRawMeta(RawMeta rawMeta) throws Exception {
        return 0;
    }

    @Override
    public boolean UpdateRawMeta(RawMeta rawMeta) throws Exception {
        return false;
    }

    @Override
    public boolean DeleteRawMeta(int i) throws Exception {
        return false;
    }

    @Override
    public RawAnnotation LoadRawAnnotation(int i) throws Exception {
        return null;
    }

    @Override
    public List<RawAnnotation> LoadRawAnnotationsByRawDataFile(int i) throws Exception {
        return new ArrayList<>();
    }

    @Override
    public List<RawAnnotation> LoadRawAnnotationsByRawDataFile(int i, int i1) throws Exception {
        return new ArrayList<>();
    }

    @Override
    public List<RawAnnotation> LoadRawAnnotationsByType(int i) throws Exception {
        return new ArrayList<>();
    }

    @Override
    public int InsertRawAnnotation(RawAnnotation rawAnnotation) throws Exception {
        return 0;
    }

    @Override
    public boolean UpdateRawAnnotation(RawAnnotation rawAnnotation) throws Exception {
        return false;
    }

    @Override
    public boolean DeleteRawAnnotation(int i) throws Exception {
        return false;
    }

    @Override
    public boolean DeleteRawAnnotationAllWithType(int i, int i1) throws Exception {
        return false;
    }

    @Override
    public String getReplacementMetadata(Object result) {
        return null;
    }

    @Override
    public HCSMetaData LoadHCSMetaData(int rdfId) throws Exception {
        return null;
    }

    @Override
    public IOrbitImage createOrbitImage(RawDataFile rawDataFile, int i) throws Exception {
        return null;
    }

    @Override
    public OrbitUser getOrbitUser(String s) {
        return null;
    }

    @Override
    public LIMSBioSample getLIMSBiosample(RawDataFile rawDataFile) throws Exception {
        return null;
    }

    @Override
    public List<LIMSBioSample> LoadByContainerId(String s) throws Exception {
        return new ArrayList<>();
    }

    @Override
    public void openBrowser(String s, String s1) {

    }

    @Override
    public AbstractOrbitTree createOrbitTree() {
        return new OTree();
    }

    @Override
    public boolean authenticateUser(String s, String s1) {
        return false;
    }

    @Override
    public boolean authenticateUserScaleout() {
        return true; // in orbit everyone can read
    }

    @Override
    public void setPooledConnectionEnabled(boolean b) {

    }

    @Override
    public void setDBConnectionName(String s) {

    }

    @Override
    public ConcurrentHashMap<String, Object> getHints() {
        return new ConcurrentHashMap<>();
    }

    @Override
    public IFileListCellRenderer getFileListCellRenderer() {
        return null;
    }

    @Override
    public void logUsage(String s, String s1) {

    }

    @Override
    public boolean enforceLoginDialogAtStartup() {
        return false;
    }

    @Override
    public List<String> getAdminUsers() {
        return new ArrayList<>();
    }

    @Override
    public void close() throws IOException {

    }

    class OTree extends AbstractOrbitTree {

        public OTree() {
            super(new DefaultMutableTreeNode("No Image Provider"));
        }

        @Override
        public void setLoginUser(String s) {

        }

        @Override
        public void setFavoritTree(boolean b) {

        }

        @Override
        public boolean isFavoritTree() {
            return false;
        }

        @Override
        public void refresh() {

        }

        @Override
        public List<IOrbitTree> getRawDataTrees() {
            return new ArrayList<>();
        }

        @Override
        public JTree getRawTree() {
            return new JTree(new DefaultTreeModel(null));
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt) {

        }

        @Override
        public void treeWillExpand(TreeExpansionEvent event) throws ExpandVetoException {

        }

        @Override
        public void treeWillCollapse(TreeExpansionEvent event) throws ExpandVetoException {

        }
    }

}
