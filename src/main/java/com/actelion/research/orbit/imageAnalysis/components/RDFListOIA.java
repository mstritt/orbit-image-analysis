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

package com.actelion.research.orbit.imageAnalysis.components;

import com.actelion.research.orbit.beans.RawData;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.gui.IFileListCellRenderer;
import com.actelion.research.orbit.gui.RdfSearchBox;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.utils.Logger;
import com.actelion.research.orbit.utils.RawUtilsCommon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;
import java.util.List;

/**
 * Displays a list of RawDataFiles. It uses a FileListCellRenderer which renders the thumbnail,
 * filename, date and filesize of the rdf. The downloading of the thumbnails is done in a separate thread.<br>
 * The model is a defaultListModel.
 * <p>
 * Use fillImageList or fillImageListByBiosamples to load RDFs into the list.
 * <br>
 * A PROPERTY_RDF_LIST_DISPLAY_META will be fired when a user single-clicks on a rdf. The newValue property of
 * the event is the rdf. This allows to display the meta infos of the selected rdf somewhere.
 * <br>
 * For a combination of this list with a RdfSearchBox see RDFChooser.
 */
public class RDFListOIA extends JList implements MouseListener, ComponentListener, PropertyChangeListener {

    private final Logger logger = Logger.getLogger(RDFListOIA.class);
    private static final long serialVersionUID = 1L;

    public static final int SORTBY_FILENAME = 0;
    public static final int SORTBY_SAMPLENAME_FILENAME = 1;
    public static final int SORTBY_MODIFYDATE_FILENAME = 2;
    public static final int SORTBY_REFERENCEDATE_FILENAME = 3;
    public static final int SORTBY_PRODUCT_FILENAME = 4;
    public static final int SORTBY_FILETYPE_FILENAME = 5;
    public static final int SORTBY_EXPTYPE_FILENAME = 6;
    public static final int SORTBY_EXPNR_FILENAME = 7;
    public static final int SORTBY_USERID_FILENAME = 8;
    public static final int SORTBY_DEFAULT = SORTBY_REFERENCEDATE_FILENAME;
    private int sortOrder = SORTBY_DEFAULT;

    public static final String RAWDATA_SELECTED = RawUtilsCommon.RAWDATA_SELECTED;
    public static final String RAWDATAFILES_SELECTED = "raw_data_files_selected";
    public static final String LIST_FILES_OR = "list_files_or";
    public static final String CLEAR_LIST = "clearList";
    public static final String PROPERTY_RDF_LIST_DISPLAY_META = "RDFLIST_displayMetas";
    public static final String PROPERTY_RDF_LIST_DOUBLECLICK = "RDFLIST_doubleclick"; // e.g. open file
    public static final String PROPERTY_RDF_LIST_MODELSIZE = "RDFLIST_modelSize";
    public static final String PROPERTY_RDF_LIST_SORT = "RDFLIST_SORT";
    public static final String PROPERTY_RDF_LIST_SETSORTORDER = "RDFLIST_SETSORTORDER"; // sort asc or desc, parameter is boolean
    public static final List<String> FileTypesImages = Arrays.asList(RawUtilsCommon.fileTypesImage);
    protected HashSet<String> viewFilter = null;

    protected List<RawDataFile> origList = new ArrayList<RawDataFile>();
    protected int concatMode = 0;
    protected boolean exhaustiveSearch = false;
    protected List<String> fileTypes = null;
    protected boolean sortAsc = false;
    protected int listLimit = -1; // to limit listRdf

    public RDFListOIA() {
        this(new ArrayList<String>());
    }

    /**
     * Set fileTypes to a list of RawUtils.DATA_ types or a pre-defines type list (e.g. FileTypesNMR) or null to display all filetypes.
     *
     * @param fileTypes
     */
    public RDFListOIA(List<String> fileTypes) {
        this(DALConfig.getImageProvider().getFileListCellRenderer(), fileTypes);
    }

    public RDFListOIA(IFileListCellRenderer renderer) {
        this(renderer, null);
    }

    /**
     * Set fileTypes to a list of RawUtils.DATA_ types or a pre-defines type list (e.g. FileTypesNMR) or null to display all filetypes.
     *
     * @param fileTypes
     */
    public RDFListOIA(IFileListCellRenderer renderer, List<String> fileTypes) {
        super();
        this.fileTypes = fileTypes;
        //this.renderer = renderer;
        setModel(new DefaultListModel());
        setCellRenderer(renderer);
        addMouseListener(this);
        addComponentListener(this);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if ((RDFListOIA.this.getSelectedValue() != null)) {
                        firePropertyChange(PROPERTY_RDF_LIST_DOUBLECLICK, null, RDFListOIA.this.getSelectedValue());
                    }
                }
            }
        });
    }

    public void mouseClicked(MouseEvent e) {
        if ((this.getSelectedValue() != null) && (e.getClickCount() == 1)) { // singleclick
            firePropertyChange(PROPERTY_RDF_LIST_DISPLAY_META, null, this.getSelectedValue());
        } else if ((this.getSelectedValue() != null) && (e.getClickCount() > 1)) { // doubleclick
            firePropertyChange(PROPERTY_RDF_LIST_DOUBLECLICK, null, this.getSelectedValue());
        }
    }

    /**
     * load files by radDataId
     *
     * @param rawDataId
     */
    public void listRDF(int rawDataId) {
        clearRenderer();
        ((DefaultListModel) getModel()).clear();
        List<RawDataFile> rdfList = null;
        try {
            rdfList = DALConfig.getImageProvider().LoadRawDataFiles(rawDataId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        addRdfElements(rdfList);
    }

    /**
     * load files by a list of rawData objects
     */
    public void listRDF(final List<RawData> rawDataList) {
        clearRenderer();
        ((DefaultListModel) getModel()).clear();
        List<RawDataFile> rdfList = new ArrayList<RawDataFile>();
        try {
            for (RawData rd : rawDataList) {
                rdfList.addAll(DALConfig.getImageProvider().LoadRawDataFiles(rd.getRawDataId(), listLimit));
                if (logger.isTraceEnabled())
                    logger.trace("rdfList size: " + rdfList.size());
                if (listLimit > 0 && rdfList.size() > listLimit) {
                    logger.debug("stop adding further rdf. Size of RdfList: " + rdfList.size());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        addRdfElements(rdfList);
    }


    /**
     * Fills the list with RDFs according to a search string. The search result is limited to 1000 entries.
     *
     * @param search
     */
    public void fillImageList(String search) {
        fillImageList(search, concatMode == 0);
    }


    public void fillImageList(String search, boolean andMode) {
        clearRenderer();
        ((DefaultListModel) getModel()).clear();
        List<RawDataFile> rdfList = null;
        try {
            if (exhaustiveSearch)
                rdfList = DALConfig.getImageProvider().LoadRawDataFilesSearch(search, andMode, RawUtilsCommon.RDFLIST_LIMIT, fileTypes);
            else
                rdfList = DALConfig.getImageProvider().LoadRawDataFilesSearchFast(search, RawUtilsCommon.RDFLIST_LIMIT, fileTypes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        addRdfElements(rdfList);
    }

    public void listFilesByFilenameStart(String search, boolean andMode, int limit) {
        int searchLimit = limit;
        if (searchLimit < 1) searchLimit = 1000;
        clearRenderer();
        ((DefaultListModel) getModel()).clear();
        List<RawDataFile> rdfList = null;
        try {
            rdfList = DALConfig.getImageProvider().LoadRawDataFilesByFilenameStart(search, andMode, searchLimit, fileTypes, "modify_date desc, filename asc");
        } catch (Exception e) {
            e.printStackTrace();
        }
        addRdfElements(rdfList);
    }


    public void fillRdfList(List<RawDataFile> rdfList) {
        clearRenderer();
        ((DefaultListModel) getModel()).clear();
        if (rdfList == null || rdfList.size() == 0) {
            firePropertyChange(PROPERTY_RDF_LIST_MODELSIZE, null, 0);
            return;
        }
        addRdfElements(rdfList);
    }

    protected void addRdfElements(List<RawDataFile> rdfList) {
        origList = rdfList;
        updateFilteredModel();
        firePropertyChange(PROPERTY_RDF_LIST_MODELSIZE, null, ((DefaultListModel) getModel()).size());
    }


    /**
     * clears the icon hash and shuts the thumbnail render threads down.
     */
    protected void clearRenderer() {
        ListCellRenderer renderer = getCellRenderer();
        if (renderer != null && (renderer instanceof IFileListCellRenderer)) {
            ((IFileListCellRenderer) renderer).refreshThnWorker();
            ((IFileListCellRenderer) renderer).clearIconHash();
        }
    }

    /**
     * Clears the list.
     */
    public void clearList() {
        ListCellRenderer renderer = getCellRenderer();
        if (renderer != null && (renderer instanceof IFileListCellRenderer))
            ((IFileListCellRenderer) renderer).clearIconHash();

        ((DefaultListModel) getModel()).clear();
        firePropertyChange(PROPERTY_RDF_LIST_MODELSIZE, null, ((DefaultListModel) getModel()).size());
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }


    public void componentHidden(ComponentEvent e) {
    }


    public void componentMoved(ComponentEvent e) {
    }


    public void componentResized(ComponentEvent e) {
    }


    public void componentShown(ComponentEvent e) {
    }

    protected DefaultListModel sortModel(DefaultListModel model, int sortBy) {
        List<Object> elements = Arrays.asList(model.toArray());
        Comparator<Object> comparator;
        switch (sortBy) {
            case SORTBY_MODIFYDATE_FILENAME: {
                comparator = new RDFSortbyModifyDate();
                break;
            }
            case SORTBY_REFERENCEDATE_FILENAME: {
                comparator = new RDFSortbyReferenceDate();
                break;
            }
            case SORTBY_USERID_FILENAME: {
                comparator = new RDFSortbyUserId();
                break;
            }
            case SORTBY_FILETYPE_FILENAME: {
                comparator = new RDFSortbyFileType();
                break;
            }

            case SORTBY_FILENAME: {
                comparator = new RDFSortbyFilename();
                break;
            }
            //case SORTBY_EXPTYPE_FILENAME: {comparator = new RDFSortbyExpType();break;}
            default:
                comparator = new RDFSortbyModifyDate();
        }
        if (!sortAsc) {
            comparator = Collections.reverseOrder(comparator);
        }
        Collections.sort(elements, comparator);
        DefaultListModel newModel = new DefaultListModel();
        for (Object obj : elements) {
            newModel.addElement(obj);
        }
        return newModel;
    }

    class RDFSortbyFilename implements Comparator<Object> {
        public int compare(Object o1, Object o2) {
            if ((!(o1 instanceof RawDataFile)) || (!(o2 instanceof RawDataFile))) {
                throw new IllegalArgumentException("can only compare RawDataFiles");
            }
            if (o1 == o2) return 0;
            RawDataFile rdf1 = (RawDataFile) o1;
            RawDataFile rdf2 = (RawDataFile) o2;
            return rdf1.getFileName().compareToIgnoreCase(rdf2.getFileName());
        }
    }

    class RDFSortbyModifyDate implements Comparator<Object> {
        public int compare(Object o1, Object o2) {
            if ((!(o1 instanceof RawDataFile)) || (!(o2 instanceof RawDataFile))) {
                throw new IllegalArgumentException("can only compare RawDataFiles");
            }
            if (o1 == o2) return 0;
            RawDataFile rdf1 = (RawDataFile) o1;
            RawDataFile rdf2 = (RawDataFile) o2;
            int res = rdf1.getModifyDate().compareTo(rdf2.getModifyDate());
            if (res != 0) return res;
            else return rdf1.getFileName().compareToIgnoreCase(rdf2.getFileName());
        }
    }

    class RDFSortbyReferenceDate implements Comparator<Object> {
        public int compare(Object o1, Object o2) {
            if ((!(o1 instanceof RawDataFile)) || (!(o2 instanceof RawDataFile))) {
                throw new IllegalArgumentException("can only compare RawDataFiles");
            }
            if (o1 == o2) return 0;
            RawDataFile rdf1 = (RawDataFile) o1;
            RawDataFile rdf2 = (RawDataFile) o2;
            int res = rdf1.getReferenceDate().compareTo(rdf2.getReferenceDate());
            if (res != 0) return res;
            else return rdf1.getFileName().compareToIgnoreCase(rdf2.getFileName());
        }
    }

    class RDFSortbyUserId implements Comparator<Object> {
        public int compare(Object o1, Object o2) {
            if ((!(o1 instanceof RawDataFile)) || (!(o2 instanceof RawDataFile))) {
                throw new IllegalArgumentException("can only compare RawDataFiles");
            }
            if (o1 == o2) return 0;
            RawDataFile rdf1 = (RawDataFile) o1;
            RawDataFile rdf2 = (RawDataFile) o2;
            int res = rdf1.getUserId().compareToIgnoreCase(rdf2.getUserId());
            if (res != 0) return res;
            else return rdf1.getFileName().compareToIgnoreCase(rdf2.getFileName());
        }
    }

    class RDFSortbyFileType implements Comparator<Object> {
        public int compare(Object o1, Object o2) {
            if ((!(o1 instanceof RawDataFile)) || (!(o2 instanceof RawDataFile))) {
                throw new IllegalArgumentException("can only compare RawDataFiles");
            }
            if (o1 == o2) return 0;
            RawDataFile rdf1 = (RawDataFile) o1;
            RawDataFile rdf2 = (RawDataFile) o2;
            int res = rdf1.getFileType().compareToIgnoreCase(rdf2.getFileType());
            if (res != 0) return res;
            else return rdf1.getFileName().compareToIgnoreCase(rdf2.getFileName());
        }
    }


    protected void updateFilteredModel() {
        if (origList == null) return;
        DefaultListModel newModel = new DefaultListModel();
        for (int i = 0; i < origList.size(); i++) {
            RawDataFile rdf = origList.get(i);
            if ((viewFilter == null) || viewFilter.contains(rdf.getFileType())) {
                newModel.addElement(rdf);
            }
        }
        setModel(sortModel(newModel, getSortOrder()));
        //	repaint();
    }


    @SuppressWarnings("unchecked")
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(RdfSearchBox.RDF_SEARCH)) {
            final String str = (String) evt.getNewValue();

            Thread t = new Thread() {
                @Override
                public void run() {
                    SwingUtilities.getRoot(RDFListOIA.this).setCursor(new Cursor(Cursor.WAIT_CURSOR));
                    try {
                        fillImageList(str);
                    } finally {
                        SwingUtilities.getRoot(RDFListOIA.this).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }
                }
            };
            t.start();


        } else if (evt.getPropertyName().equals(RdfSearchBox.CONCATMODE_AND)) {
            if ((Boolean) evt.getNewValue()) concatMode = 0;
            else concatMode = 1;
        } else if (evt.getPropertyName().equals(RdfSearchBox.CONCATMODE_OR)) {
            if ((Boolean) evt.getNewValue()) concatMode = 1;
            else concatMode = 0;
        } else if (evt.getPropertyName().equals(RdfSearchBox.SEARCHMODE_FAST)) {
            exhaustiveSearch = false;
        } else if (evt.getPropertyName().equals(RdfSearchBox.SEARCHMODE_EXHAUSTIVE)) {
            exhaustiveSearch = true;
        } else if (evt.getPropertyName().equals(RAWDATA_SELECTED)) {
            List<RawData> rdList = (List) evt.getNewValue();
            if (rdList != null && rdList.size() > 0)
                listRDF(rdList);
        } else if (evt.getPropertyName().equals(RAWDATAFILES_SELECTED)) {
            List<RawDataFile> rdfList = (List) evt.getNewValue();
            fillRdfList(rdfList);
        } else if (evt.getPropertyName().equals(LIST_FILES_OR)) {
            String search = (String) evt.getNewValue();
            listFilesByFilenameStart(search, false, listLimit);
        } else if (evt.getPropertyName().equals(CLEAR_LIST)) {
            clearList();
        }
        // viewFilter
        else if (evt.getPropertyName().equals(RdfSearchBox.VIEWFILTER_ADD_FILETYPE)) {
            String fileType = (String) evt.getNewValue();
            if (!viewFilter.contains(fileType)) viewFilter.add(fileType);
            updateFilteredModel();
            if (logger.isTraceEnabled()) {
                String s = "filter (add): ";
                for (String ft : viewFilter) {
                    s += ft + ", ";
                }
                logger.trace(s);
            }
        } else if (evt.getPropertyName().equals(RdfSearchBox.VIEWFILTER_REMOVE_FILETYPE)) {
            String fileType = (String) evt.getNewValue();
            if (viewFilter.contains(fileType)) viewFilter.remove(fileType);
            updateFilteredModel();
            if (logger.isTraceEnabled()) {
                String s = "filter (remove): ";
                for (String ft : viewFilter) {
                    s += ft + ", ";
                }
                logger.trace(s);
            }
        } else if (evt.getPropertyName().equals(PROPERTY_RDF_LIST_SORT)) {
            int sort = (Integer) evt.getNewValue();
            setSortOrder(sort);
            setModel(sortModel((DefaultListModel) getModel(), sort));
        } else if (evt.getPropertyName().equals(PROPERTY_RDF_LIST_SETSORTORDER)) {
            boolean b = (Boolean) evt.getNewValue();
            setSortAsc(b);
            setModel(sortModel((DefaultListModel) getModel(), sortOrder));
        }
    }


    public int getConcatMode() {
        return concatMode;
    }


    public void setConcatMode(int concatMode) {
        this.concatMode = concatMode;
    }

    public List<String> getFileTypes() {
        return fileTypes;
    }

    public void setFileTypes(List<String> fileTypes) {
        this.fileTypes = fileTypes;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public boolean isSortAsc() {
        return sortAsc;
    }

    public void setSortAsc(boolean sortAsc) {
        this.sortAsc = sortAsc;
    }

    public int getListLimit() {
        return listLimit;
    }

    public void setListLimit(int listLimit) {
        this.listLimit = listLimit;
    }


}
