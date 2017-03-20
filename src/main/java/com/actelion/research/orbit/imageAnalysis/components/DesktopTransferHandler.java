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
import com.actelion.research.orbit.imageAnalysis.dal.localImage.LocalFileFilter;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class DesktopTransferHandler extends TransferHandler {
    private static final long serialVersionUID = 1L;
    private Logger logger = LoggerFactory.getLogger(DesktopTransferHandler.class);

    // import

    public boolean canImport(TransferHandler.TransferSupport info) {
        if (!(info.isDataFlavorSupported(ImageListRdfTransferHandler.DATA_FLAVOR_RDFList) ||
                info.isDataFlavorSupported(DataFlavor.javaFileListFlavor)
        )
                ) {
            return false;
        }

        //TODO: handle images (and URLs)

        return true;
    }

    @SuppressWarnings("unchecked")
    public boolean importData(TransferHandler.TransferSupport info) {

        Transferable t = info.getTransferable();

        // rdfList
        List<RawDataFile> rdfList = null;
        try {
            rdfList = (List<RawDataFile>) t.getTransferData(ImageListRdfTransferHandler.DATA_FLAVOR_RDFList);
        } catch (Exception e) {
        }

        if (rdfList != null) {
            for (RawDataFile rdf : rdfList)
                OrbitImageAnalysis.getInstance().loadFile(rdf, null, info.getUserDropAction() == COPY);
            return true;
        }


        // Image file
        List<File> fileList = null;
        try {
            fileList = (List<File>) t.getTransferData(DataFlavor.javaFileListFlavor);
        } catch (Exception e) {
        }
        if (fileList != null) {
            for (File file : fileList) {
                String fn = file.getAbsolutePath();
                LocalFileFilter localFilter = new LocalFileFilter();
                if (localFilter.accept(file)) {
                    OrbitImageAnalysis.getInstance().loadFileDirect(file);
                } else if (file.getName().toLowerCase().endsWith(".orbit")) {
                    OrbitImageAnalysis.getInstance().loadOrbitFile(file.getAbsolutePath());
                } else if (file.getName().toLowerCase().endsWith(OrbitUtils.MODEL_ENDING)) {
                    OrbitImageAnalysis.getInstance().loadModel(new File(file.getAbsolutePath()), true, file.getName().toLowerCase().endsWith(OrbitUtils.MODEL_ENDING));
                }
            }
            return true;
        }

        return false;
    }


    // export


    public Transferable createTransferable(JComponent c) {
        File file = new File(OrbitUtils.getTempDir() + "/export.orbit");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            for (ImageFrame iFrame : OrbitImageAnalysis.getInstance().getIFrames()) {
                osw.write(iFrame.recognitionFrame.getOriginalName() + "\n");
            }
            osw.flush();
            osw.close();
            fos.flush();
            fos.close();
        } catch (Exception e) {
            logger.error("Error", e);
        }
        Transferable t = new FileTransferable(file);
        return t;
    }

    /**
     * Created a transferable object from the image in iFrame. If fullImage is true the full image is used,
     * otherwise just the current viewport.
     *
     * @param iFrame
     * @param fullImage
     * @return
     */
    public Transferable createImageTransferable(ImageFrame iFrame, boolean fullImage) {
        Image image = null;
        if (fullImage) {
            image = iFrame.recognitionFrame.getImageSnapshot();
        } else {
            image = iFrame.getCurrentView();
        }
        Transferable t = new ImageTransferable(image);
        return t;
    }

    public void exportDone(JComponent c, Transferable t, int action) {
        if (t instanceof FileTransferable) {
            ((FileTransferable) t).file.deleteOnExit();
        }
    }

    public class FileTransferable implements Transferable {
        public final DataFlavor df = DataFlavor.javaFileListFlavor;
        private File file = null;

        public FileTransferable(File file) {
            this.file = file;
        }

        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return flavor.isFlavorJavaFileListType();
        }

        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{df};
        }

        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
            if (flavor.isFlavorJavaFileListType()) {
                List<File> list = new ArrayList<File>();
                list.add(file);
                return list;
            }
            return null;
        }
    }

    ;

    public class ImageTransferable implements Transferable {

        private Image image;

        public ImageTransferable(Image image) {
            this.image = image;
        }

        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{
                    DataFlavor.imageFlavor};
        }

        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return flavor.equals(DataFlavor.imageFlavor);
        }

        public Object getTransferData(DataFlavor flavor) throws
                UnsupportedFlavorException, IOException {
            return image;
        }

    }

}
