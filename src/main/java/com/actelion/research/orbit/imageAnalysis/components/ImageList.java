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

package com.actelion.research.orbit.imageAnalysis.components;

import com.actelion.research.orbit.beans.RawData;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.gui.IFileListCellRenderer;
import com.actelion.research.orbit.gui.RdfSearchBox;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.utils.RawUtilsCommon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;


public class ImageList extends JList implements MouseListener, ComponentListener, PropertyChangeListener {

    private static final Logger logger = LoggerFactory.getLogger(ImageList.class);
    private static final long serialVersionUID = 1L;
    public static String PROPERTY_LOAD_IMAGE = "loadImage";
    public static String PROPERTY_DISPLAY_META = "displayMetas";
    //private RdfThnCellRenderer renderer = new RdfThnCellRenderer();
    private IFileListCellRenderer renderer;
    private boolean exhaustiveSearch = false;
    private boolean[] scrollChange = new boolean[5];
    private int scrollIdx = 0;

    public ImageList(IFileListCellRenderer renderer) {
        super();
        this.renderer = renderer;
        setModel(new DefaultListModel());
        setCellRenderer(renderer);
        addMouseListener(this);
        addComponentListener(this);
        setDragEnabled(true);
        setTransferHandler(new ImageListRdfTransferHandler());
    }


    public void mouseClicked(MouseEvent e) {
        if ((this.getSelectedValue() != null) && (e.getClickCount() == 1)) { // singleclick
            //firePropertyChange(PROPERTY_DISPLAY_META, null, this.getSelectedValue());
        } else if ((this.getSelectedValue() != null) && (e.getClickCount() > 1)) { // doubleclick
            firePropertyChange(PROPERTY_DISPLAY_META, null, this.getSelectedValue());       // now meta data in only displayed when image is loaded (not just clicked in the list) to avoid problems for loaded image / clicked image / back to loaded image
            firePropertyChange(PROPERTY_LOAD_IMAGE, null, this.getSelectedValue());
        }
    }


    public synchronized void fillImageList(final String search) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                if (renderer != null) {
                    //renderer.clearIconHash();
                    renderer.refreshThnWorker();
                }
                DefaultListModel newModel = new DefaultListModel();
                List<RawDataFile> rdfList = null;
                try {
                    //rdfList = DAODataFile.LoadRawDataFilesSearch(search,concatMode==0,RawUtils.SEARCH_LIMIT,RDFList.FileTypesImages);
                    if (exhaustiveSearch)
                        rdfList = DALConfig.getImageProvider().LoadRawDataFilesSearch(search, true, RawUtilsCommon.SEARCH_LIMIT, RDFListOIA.FileTypesImages);
                    else
                        rdfList = DALConfig.getImageProvider().LoadRawDataFilesSearchFast(search, RawUtilsCommon.SEARCH_LIMIT, RDFListOIA.FileTypesImages);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (rdfList != null) {
                    int cnt = 0;
                    for (RawDataFile rdf : rdfList) {
                        newModel.addElement(rdf);
                        cnt++;
                        if (cnt > RawUtilsCommon.SEARCH_LIMIT) break;
                    }
                }
                setModel(newModel);
            }
        });
    }


    public synchronized void loadRawDatas(final List<RawData> rdList) {
        if (rdList == null) return;
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                if (renderer != null) {
                    //renderer.clearIconHash();
                    renderer.refreshThnWorker();
                }
                DefaultListModel newModel = new DefaultListModel();
                final List<RawDataFile> rdfList = new ArrayList<RawDataFile>();
                try {
                    for (RawData rd : rdList) {
                        rdfList.addAll(DALConfig.getImageProvider().LoadRawDataFiles(rd.getRawDataId(), RDFListOIA.FileTypesImages, RawUtilsCommon.SEARCH_LIMIT));
                        if (rdfList.size() >= RawUtilsCommon.SEARCH_LIMIT) break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (rdfList != null) {
                    int cnt = 0;
                    for (RawDataFile rdf : rdfList) {
                        newModel.addElement(rdf);
                        cnt++;
                        if (cnt > RawUtilsCommon.SEARCH_LIMIT) break;
                    }
                }
                setModel(newModel);
            }
        });
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
        if (getWidth() > 600) setBounds(getX(), getY(), 600, getHeight());
        renderer.setIconWidth(this.getWidth());
        scrollChange[scrollIdx % (scrollChange.length - 1)] = this.getScrollableTracksViewportHeight();
        scrollIdx++;
        if (scrollIdx < 0) scrollIdx = 0;
        int cnt = 0;
        for (int i = 0; i < scrollChange.length - 1; i++) {
            if (scrollChange[i] != scrollChange[i + 1]) cnt++;
        }
        if (cnt < 3) {
            setFixedCellHeight((int) (this.getWidth() * 0.75d) + 25);
        }
    }


    public void componentShown(ComponentEvent e) {
    }


    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(RdfSearchBox.RDF_SEARCH)) {
            fillImageList((String) evt.getNewValue());
        } else if (evt.getPropertyName().equals(RdfSearchBox.SEARCHMODE_FAST)) {
            exhaustiveSearch = false;
        } else if (evt.getPropertyName().equals(RdfSearchBox.SEARCHMODE_EXHAUSTIVE)) {
            exhaustiveSearch = true;
        } else if (evt.getPropertyName().equals(RDFListOIA.RAWDATA_SELECTED)) {
            loadRawDatas((List<RawData>) evt.getNewValue());
        }


		/*
        else
		if (evt.getPropertyName().equals(RdfSearchBox.CONCATMODE_AND)) {
			if ((Boolean)evt.getNewValue()) concatMode = 0; else concatMode = 1;
		} else
		if (evt.getPropertyName().equals(RdfSearchBox.CONCATMODE_OR)) {
			if ((Boolean)evt.getNewValue()) concatMode = 1; else concatMode = 0;
		}
		*/
    }


    public IFileListCellRenderer getRenderer() {
        return renderer;
    }


}
