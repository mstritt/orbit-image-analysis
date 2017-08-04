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

package com.actelion.research.orbit.imageAnalysis.modules.mihc;

import com.actelion.research.orbit.imageAnalysis.components.AbstractOrbitModule;
import com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MihcModule extends AbstractOrbitModule {

    private static final long serialVersionUID = 1L;
    private final static Logger logger = LoggerFactory.getLogger(MihcModule.class);
    private JButton btnActivate = new JButton("Activate mIHC");

    public MihcModule() {
        btnActivate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                activatemIHC();
            }
        });

        setLayout(new BorderLayout());

        JLabel label = new JLabel("mIHC");
        add(label, BorderLayout.NORTH);
        add(btnActivate, BorderLayout.CENTER);
    }

    private void activatemIHC() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        final OrbitModel model = oia.getModel();
        MIHCConfig conf = new MIHCConfig();
        model.getFeatureDescription().setMihcMatrix(conf.filterNewXeon6);
        model.getFeatureDescription().setMihcNormalGain(conf.normGain6);
        model.getFeatureDescription().setMihcMatrixChannelNames(conf.channelNames6);
        model.getFeatureDescription().setMihcActive(true);
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
