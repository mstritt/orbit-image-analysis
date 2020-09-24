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

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.utils.TiledImagePainter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MetaTabs extends JTabbedPane {

    private static final long serialVersionUID = 1L;
    private MetaTable rawDataMetas = null;
    private MetaTable rawDataFileMetas = null;
    private MetaTable limsMetas = null;
    private final AnnotationPanel annotationPanel = new AnnotationPanel();
    private final AdjustPanel adjustPanel = new AdjustPanel();

    public MetaTabs() {

        rawDataMetas = new MetaTable();
        rawDataFileMetas = new MetaTable();
        limsMetas = new MetaTable();

        int activeTab = 3;  // Adjustments
        add("Container", new JScrollPane(rawDataMetas));
        add("File", new JScrollPane(rawDataFileMetas));
        if (DALConfig.isShowLIMSMetas()) {
            add("LIMS", new JScrollPane(limsMetas));
            activeTab++;
        }
        add("Annotations", annotationPanel);
        add("Adjustments", adjustPanel);
        setSelectedIndex(activeTab); // tab Adjustments is active
    }

    public void addOrbitModule(AbstractOrbitModule module) {
        add(module.getName(), module);
    }

    public void removeOrbitModule(AbstractOrbitModule module) {
        List<Integer> removeList = new ArrayList<Integer>();
        for (int i = 0; i < getComponentCount(); i++) {
            Component c = getComponent(i);
            if (c instanceof AbstractOrbitModule) {
                AbstractOrbitModule om = (AbstractOrbitModule) c;
                if (om.equals(module)) {
                    removeList.add(i);
                }
            }
        }
        for (int i : removeList) {
            remove(i);
        }
    }

    public void removeOrbitModule(Class<AbstractOrbitModule> module) {
        List<Integer> removeList = new ArrayList<Integer>();
        for (int i = 0; i < getComponentCount(); i++) {
            Component c = getComponent(i);
            if (c instanceof AbstractOrbitModule) {
                AbstractOrbitModule om = (AbstractOrbitModule) c;
                if (om.getClass().equals(module)) {
                    removeList.add(i);
                }
            }
        }
        for (int i : removeList) {
            remove(i);
        }
    }


    public void listMetas(RawDataFile rdf) {
        rawDataMetas.listRawDataMetas(rdf.getRawDataId());
        rawDataFileMetas.listRdfMetas(rdf.getRawDataFileId());
        if (DALConfig.isShowLIMSMetas()) {
            limsMetas.listLIMSMetas(rdf);
        }
    }

    public void clearMetasAndAnnotations() {
        rawDataMetas.clearMetas();
        rawDataFileMetas.clearMetas();
        if (DALConfig.isShowLIMSMetas()) {
            limsMetas.clearMetas();
        }
        annotationPanel.clear();
        if (OrbitImageAnalysis.getInstance().getIFrame() == null) {
            adjustPanel.resetValues();
        }
        for (int i = 0; i < getComponentCount(); i++) {
            Component c = getComponent(i);
            if (c instanceof AbstractOrbitModule) {
                AbstractOrbitModule om = (AbstractOrbitModule) c;
                om.reset();
            }
        }
    }


    public AnnotationPanel getAnnotationPanel() {
        return annotationPanel;
    }

    /**
     * Loads image adjustments from the tiledImagePainter of imageFrame.recognitionFrame.
     *
     * @param imageFrame
     */
    public void loadImageAdjustments(ImageFrame imageFrame) {
        if (imageFrame != null && imageFrame.recognitionFrame != null) {
            TiledImagePainter tip = imageFrame.recognitionFrame.bimg;
            adjustPanel.setAdjustmentValues((int) tip.getBrightness(),
                                            (int) tip.getContrast(),
                                            (int) tip.getRedAdjust(),
                                            (int) tip.getGreenAdjust(),
                                            (int) tip.getBlueAdjust(),
                                            (int) tip.getGamma(),
                                            tip.isRedActive(),
                                            tip.isGreenActive(),
                                            tip.isBlueActive(),
                                            tip.getDeconvChannel(),
                                            tip.getDeconvName(),
                                            imageFrame);
        }
    }


    /**
     * Loads image adjustments from the database.
     */
    public void loadImageAdjustmentsFromDB(ImageFrame imageFrame) {
        adjustPanel.loadAdjustments(imageFrame);
    }


    public MetaTable getRawDataMetas() {
        return rawDataMetas;
    }

    public MetaTable getRawDataFileMetas() {
        return rawDataFileMetas;
    }

    public MetaTable getLimsMetas() {
        return limsMetas;
    }

    public AdjustPanel getAdjustPanel() {
        return adjustPanel;
    }
}
