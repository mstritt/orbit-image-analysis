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

package com.actelion.research.orbit.imageAnalysis.modules;

import com.actelion.research.orbit.imageAnalysis.components.AbstractOrbitModule;
import com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis;
import com.actelion.research.orbit.imageAnalysis.components.RangeBar;
import com.actelion.research.orbit.imageAnalysis.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ThresholdModule extends AbstractOrbitModule {

    private static final long serialVersionUID = 1L;
    private final static Logger logger = LoggerFactory.getLogger(ThresholdModule.class);
    private JButton btnMakeClassifier = new JButton("Set Classifier");
    private RangeBar intensBar = new RangeBar(0, 255);

    public ThresholdModule() {
        btnMakeClassifier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                makeClassifier();
            }
        });

        setLayout(new BorderLayout());
        String text = "<html><body><ol>" +
                "<li>Set min (black) and max (white) intensity.</li>" +
                "<li>Click on 'Set Classifier'.</li>" +
                "<li>Click on 'classify' (toolbar).</li>" +
                "<li>Use the classification slider (in the image) to see the result.</li>" +
                "</ol></body></html>";

        JLabel label = new JLabel(text);
        add(label, BorderLayout.NORTH);
        add(intensBar, BorderLayout.CENTER);
        add(btnMakeClassifier, BorderLayout.SOUTH);
    }

    private void makeClassifier() {
        int numBlur = OrbitImageAnalysis.getInstance().getModel().getFeatureDescription().getNumBlur();
        boolean skipRed = OrbitImageAnalysis.getInstance().getModel().getFeatureDescription().isSkipRed();
        boolean skipGreen = OrbitImageAnalysis.getInstance().getModel().getFeatureDescription().isSkipGreen();
        boolean skipBlue = OrbitImageAnalysis.getInstance().getModel().getFeatureDescription().isSkipBlue();
        int deconvChannel = OrbitImageAnalysis.getInstance().getModel().getFeatureDescription().getDeconvChannel();
        String deconvName = OrbitImageAnalysis.getInstance().getModel().getFeatureDescription().getDeconvName();
        boolean useImageAdjustments = OrbitImageAnalysis.getInstance().getModel().getFeatureDescription().isUseImageAdjustments();
        String[] activeFluoChannels = OrbitImageAnalysis.getInstance().getModel().getFeatureDescription().getActiveFluoChannels();
        FeatureDescription fd = new FeatureDescription(1, 3, FeatureDescription.FEATURE_SET_INTENS, 0, false, numBlur, skipRed, skipGreen, skipBlue, 1, null, false, false, deconvChannel, deconvName, useImageAdjustments,activeFluoChannels,false,0,0);
        List<ClassShape> classShapes = OrbitImageAnalysis.getInstance().getModel().getClassShapes();
        if (classShapes.size() < 2) {
            logger.error("Please define a two class setup (negative (<=threthold) and positive (>threshold) class");
        }

        ClassifierWrapper classifier = new ClassifierWrapper(new ThresholdClassifier(
                new double[]{intensBar.getLowValue(), Double.NaN, Double.NaN},
                new double[]{intensBar.getHighValue(), Double.NaN, Double.NaN}));
        classifier.setBuild(true);
        OrbitModel model = new OrbitModel(classifier, null, classShapes, fd);
        OrbitImageAnalysis.getInstance().setModel(model);
    }


    @Override
    public String getName() {
        return "Threshold Classification";
    }

    @Override
    public void init() {
    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub

    }

}
