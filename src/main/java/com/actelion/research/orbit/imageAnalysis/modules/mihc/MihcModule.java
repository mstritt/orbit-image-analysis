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

package com.actelion.research.orbit.imageAnalysis.modules.mihc;

import com.actelion.research.orbit.dal.IModelAwareImageProvider;
import com.actelion.research.orbit.imageAnalysis.components.AbstractOrbitModule;
import com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImage2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicBoolean;

public class MihcModule extends AbstractOrbitModule {

    private static final long serialVersionUID = 1L;
    private final static Logger logger = LoggerFactory.getLogger(MihcModule.class);
    private final AtomicBoolean updatingMihc = new AtomicBoolean(false);

    public MihcModule() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        final OrbitModel model = oia.getModel();
        boolean initialMIHC = model.getFeatureDescription().isMihcActive();

        setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel unmixPane = new JPanel();
        BoxLayout boxLayout = new BoxLayout(unmixPane,BoxLayout.Y_AXIS);
        unmixPane.setLayout(boxLayout);
        final JCheckBox unmixingCB = new JCheckBox("Channel Unmixing",initialMIHC);
        unmixPane.add(unmixingCB);

        final JButton btnLoadFromModel = new JButton("Load from Model");
        btnLoadFromModel.setToolTipText("load and set the mIHC settings from current model");
        unmixPane.add(btnLoadFromModel);

        JPanel calibratePane = new JPanel();
        JButton btnCalibrate = new JButton("Calibrate");
        calibratePane.add(btnCalibrate);

        tabbedPane.addTab("Unmix",unmixPane);
        tabbedPane.addTab("Calibration",calibratePane);
        add(tabbedPane,BorderLayout.CENTER);

        unmixingCB.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             if (!updatingMihc.get()) {
                 if (unmixingCB.isSelected()) {
                     activate_mIHC();
                 } else {
                     deactivate_mIHC();
                 }
             }
         }
         });


        btnLoadFromModel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatingMihc.set(true);
                try {
                    final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
                    final OrbitModel model = oia.getModel();
                    if (model.getFeatureDescription().isMihcActive()) {
                        unmixingCB.setSelected(true);
                        activate_mIHC();
                    } else {
                        unmixingCB.setSelected(false);
                        deactivate_mIHC();
                    }
                } finally {
                    updatingMihc.set(false);
                }
            }
        });

    }

    private void activate_mIHC() {
        if (DALConfig.getImageProvider() instanceof IModelAwareImageProvider) {
            final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
            final OrbitModel model = oia.getModel();
            MihcConfigData conf = new MihcConfigData();
            model.getFeatureDescription().setMihcMatrix(conf.Asn3);
            model.getFeatureDescription().setMihcNormalGain(conf.normGain3);
            model.getFeatureDescription().setMihcMatrixChannelNames(conf.channelNames3HT);
            model.getFeatureDescription().setMihcActive(true);
            ((IModelAwareImageProvider) DALConfig.getImageProvider()).setOrbitModel(model);
            OrbitTiledImage2.resetTileCache();
        } else {
            logger.error("The current image provider does not support mIHC.");
        }
    }

    private void deactivate_mIHC() {
        if (DALConfig.getImageProvider() instanceof IModelAwareImageProvider) {
            final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
            final OrbitModel model = oia.getModel();
            model.getFeatureDescription().setMihcActive(false);
            ((IModelAwareImageProvider) DALConfig.getImageProvider()).setOrbitModel(model);
            OrbitTiledImage2.resetTileCache();
        } else {
            // for deactivating no message needed
        }
    }



    @Override
    public String getName() {
        return "mIHC";
    }

    @Override
    public void init() {

    }

    @Override
    public void reset() {

    }

}
