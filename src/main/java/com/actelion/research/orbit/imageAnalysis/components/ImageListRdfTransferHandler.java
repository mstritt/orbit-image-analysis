/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
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
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.util.ArrayList;
import java.util.List;

/**
 * Handler that transfers RawDataFiles out of an ImageList. Provides the DataFlavor DATA_FLAVOR_RDF (static)
 * (RawDataFile) and DataFlavor.stringFlavor (URL of the Rdf).<br>
 * To be used with ImageList.
 */
public class ImageListRdfTransferHandler extends TransferHandler {

    private static final long serialVersionUID = 1L;
    public static DataFlavor DATA_FLAVOR_RDFList = new DataFlavor(List.class, "DawDataFileArray");

    public int getSourceActions(JComponent c) {
        return COPY_OR_MOVE;
    }

    public Transferable createTransferable(JComponent c) {
        List<RawDataFile> rdfList = new ArrayList<RawDataFile>();
        if (((ImageList) c).getSelectedValues() != null && ((ImageList) c).getSelectedValues().length > 0) {
            for (Object obj : ((ImageList) c).getSelectedValues()) {
                if (obj instanceof RawDataFile) {
                    RawDataFile rdf = (RawDataFile) obj;
                    rdfList.add(rdf);
                }
            }
        }
        // return new RdfTransferable((RawDataFile)((ImageList)c).getSelectedValue());
        return new RdfTransferable(rdfList);
    }

    public void exportDone(JComponent c, Transferable t, int action) {

    }

    class RdfTransferable implements Transferable {

        private List<RawDataFile> rdfList = null;

        public RdfTransferable(List<RawDataFile> rdfList) {
            this.rdfList = rdfList;
        }

        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return true;
        }

        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{DATA_FLAVOR_RDFList, DataFlavor.stringFlavor};
        }

        public Object getTransferData(DataFlavor flavor) {
            if (flavor.equals(DATA_FLAVOR_RDFList)) {
                return (rdfList);
            } else {
                if (rdfList != null && rdfList.size() > 0)
                    return DALConfig.getImageProvider().getRawDataFileUrl(rdfList.get(0)).toString();
            }
            return null;
        }

    }

}
