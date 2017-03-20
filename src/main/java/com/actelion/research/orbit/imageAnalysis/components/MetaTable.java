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

package com.actelion.research.orbit.imageAnalysis.components;

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.beans.RawMeta;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.lims.LIMSBioSample;
import com.actelion.research.orbit.utils.ListWithName;
import com.actelion.research.orbit.utils.RawMetaFactoryFile;
import com.actelion.research.orbit.utils.RawMetaListBuilder;
import com.actelion.research.orbit.utils.RawUtilsCommon;
import com.l2fprod.common.swing.JOutlookBar;
import org.pushingpixels.substance.api.renderers.SubstanceDefaultTableCellRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Displays RawMeta values according to a RawDataFile in a table nested in a JScrollPane.
 */
public class MetaTable extends JOutlookBar {

    private static final long serialVersionUID = 1L;
    private final static Logger logger = LoggerFactory.getLogger(MetaTable.class);
    private final String[] tableHeader = new String[]{"Name", "Value"};
    private final Map<String, RawMeta> metaHash = new ConcurrentHashMap<String, RawMeta>();

    public MetaTable() {
        addDefaultTable();
        this.setPreferredSize(new Dimension(-1, 250));
    }


    private void addDefaultTable() {

//		SwingUtilities.invokeLater(new Runnable() {
//			@Override
//			public void run() {
//				Object[][] vals = new String[1][2];
//				vals[0][0] = ""; vals[0][1] = "";
//				JTable table =  new JTable(vals, tableHeader);
//				table.setCellEditor(new MetaCellEditor());
//				MetaTable.this.add("Meta Data",table);
//			}
//		});

        Object[][] vals = new String[1][2];
        vals[0][0] = "";
        vals[0][1] = "";
        JTable table = new JTable(vals, tableHeader);
        table.setCellEditor(new MetaCellEditor());

        this.add("Meta Data", new JScrollPane(table));
    }


    public void clearMetas() {
        removeAll();
        addDefaultTable();
    }

    public void listRdfMetas(int rawDataFileId) {
        try {
            metaHash.clear();
            List<RawMeta> metaList = DALConfig.getImageProvider().LoadRawMetasByRawDataFile(rawDataFileId);
            boolean descriptionAdded = false;
            boolean commentAdded = false;
            for (RawMeta rm : metaList) {
                metaHash.put(rm.getName(), rm);
                if (rm.getName().equals("Description")) descriptionAdded = true;
                if (rm.getName().equals("Comment")) commentAdded = true;
            }
            RawDataFile rdf = DALConfig.getImageProvider().LoadRawDataFile(rawDataFileId);
            RawMetaFactoryFile rmff = new RawMetaFactoryFile(rawDataFileId, new Date(), rdf.getUserId());
            if (!descriptionAdded) {
                RawMeta rm = rmff.createMetaStr("Description", "");
                metaList.add(rm);
            }
            if (!commentAdded) {
                RawMeta rm = rmff.createMetaStr("Comment", "");
                metaList.add(rm);
            }

            listMetas(metaList);
        } catch (Exception e) {
            logger.error("error loading meta data", e);
        }
    }

    public void listRawDataMetas(int rawDataId) {
        try {
            metaHash.clear();
            List<RawMeta> metaList = DALConfig.getImageProvider().LoadRawMetasByRawData(rawDataId);
            for (RawMeta rm : metaList) {
                metaHash.put(rm.getName(), rm);
            }
            listMetas(metaList);
        } catch (Exception e) {
            logger.error("error loading meta data", e);
        }
    }

    /**
     * Only called if DALConfig.isShowLIMSMetas()
     *
     * @param rdf
     */
    public void listLIMSMetas(final RawDataFile rdf) {
        metaHash.clear();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    RawMetaFactoryFile rmff = new RawMetaFactoryFile(rdf.getRawDataFileId(), new Date(), rdf.getUserId());
                    List<RawMeta> rmList = DALConfig.getImageProvider().LoadRawMetasByRawDataFileAndName(rdf.getRawDataFileId(), RawUtilsCommon.STR_META_BARCODE);
                    if (rmList != null && rmList.size() > 0) {
                        String barcode = rmList.get(0).getValue();
                        if (barcode != null && barcode.length() > 0) {
                            barcode = barcode.trim();
                            List<LIMSBioSample> samples = DALConfig.getImageProvider().LoadByContainerId(barcode);
                            if (samples != null) {
                                for (LIMSBioSample sample : samples) {
                                    List<RawMeta> metaList = RawUtilsCommon.generateBiosampleMetas(sample, rmff);
                                    for (RawMeta rm : metaList) {
                                        metaHash.put(rm.getName(), rm);
                                    }
                                    listMetas(metaList);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    logger.info("error loading LIMS meta-data", e);
                }
            }
        });
        t.start();
    }

    private void listMetas(List<RawMeta> metaList) {
        //List<RawMeta> metaList = DAORawMeta.LoadRawMetasByRawDataFile(rdf.getRawDataFileId());
        // append with metas from rawData
        //List<RawMeta> rdMetas = DAORawMeta.LoadRawMetasByRawData(rdf.getRawDataId());
        //for (RawMeta rm : rdMetas) {
        //	rm.setName("Container."+rm.getName());
        //}
        //metaList.addAll(rdMetas);
        List<ListWithName<RawMeta>> metaHash = RawMetaListBuilder.buildRawMetaHash(metaList);
        this.removeAll();
        int cnt = 0;
        for (final ListWithName<RawMeta> pGroup : metaHash) {

            Object[][] tableData = new Object[pGroup.getList().size()][2];
            for (int i = 0; i < pGroup.getList().size(); i++) {
                cnt++;
                RawMeta rm = pGroup.getList().get(i);
                tableData[i][0] = rm;
                tableData[i][1] = rm.getValueFormatted();
            }
            final TableModel tm = new MyEditableTableModel(tableData, tableHeader);
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    final JTable table = new JTable(tm);
                    if (OrbitUtils.DARKUI)
                        table.getColumnModel().getColumn(0).setCellRenderer(new MyMetaTableCellRendererSubstance());
                    else table.getColumnModel().getColumn(0).setCellRenderer(new MyMetaTableCellRendererNimbus());
                    table.getColumnModel().getColumn(1).setCellEditor(new MetaCellEditor());
                    MetaTable.this.add(pGroup.getName(), table);
                }
            });

        }
    }


    public Map<String, RawMeta> getMetaHash() {
        return metaHash;
    }


    class MyEditableTableModel extends DefaultTableModel {
        private static final long serialVersionUID = 1L;

        public MyEditableTableModel() {
            super();
        }

        public MyEditableTableModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return column > 0;
        }


    }

    class MyMetaTableCellRendererNimbus extends DefaultTableCellRenderer.UIResource {
        private static final long serialVersionUID = 1L;

        public MyMetaTableCellRendererNimbus() {
            super();
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof RawMeta) {
                RawMeta rm = (RawMeta) value;
                return super.getTableCellRendererComponent(table, rm.getName(), isSelected, hasFocus, row, column);
            } else
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }

    class MyMetaTableCellRendererSubstance extends SubstanceDefaultTableCellRenderer {
        private static final long serialVersionUID = 1L;

        public MyMetaTableCellRendererSubstance() {
            super();
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof RawMeta) {
                RawMeta rm = (RawMeta) value;
                return super.getTableCellRendererComponent(table, rm.getName(), isSelected, hasFocus, row, column);
            } else
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }


}
