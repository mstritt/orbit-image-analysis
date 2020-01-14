/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2020 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
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

package com.actelion.research.orbit.imageAnalysis.TMA;

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static javax.swing.JRootPane.FILE_CHOOSER_DIALOG;

public class TMASpotGUI extends JDialog {

    private static final long serialVersionUID = 1L;
    private final static Logger logger = LoggerFactory.getLogger(TMASpotGUI.class);

    public TMASpotGUI(boolean withGui) {
        if (withGui) {
            final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();

            try {
                List<RawDataFile> rdfList = OrbitHelper.browseImagesDefault(oia);
                if (rdfList.size() > 0) {
                    createTMADialog(rdfList);
                } else {
                    JOptionPane.showMessageDialog(oia,
                            "No images selected, you must select at least one image in the image chooser.",
                            "No images selected",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                logger.debug(ex.getMessage());
            }

        }
    }

    public void createTMADialog(List<RawDataFile> rdfList) {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();

        JDialog dialog = null;
        if (oia != null) {
            dialog = new JDialog(oia, this.getName(), true);

            dialog.setTitle("TMA / Grid - ROIs");
            dialog.setComponentOrientation(this.getComponentOrientation());
            Container contentPane = dialog.getContentPane();
            contentPane.setLayout(new BorderLayout());

            contentPane.add(new DetectSpotsGUI(rdfList), "Center");

            if (JDialog.isDefaultLookAndFeelDecorated()) {
                boolean supportsWindowDecorations = UIManager.getLookAndFeel().getSupportsWindowDecorations();
                if (supportsWindowDecorations) {
                    dialog.getRootPane().setWindowDecorationStyle(FILE_CHOOSER_DIALOG);
                }
            }

            dialog.pack();
            dialog.setLocationRelativeTo(oia);
            dialog.setVisible(true);
        }

    }

}
