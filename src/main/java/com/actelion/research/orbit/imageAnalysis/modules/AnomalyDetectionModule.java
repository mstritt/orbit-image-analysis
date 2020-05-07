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

package com.actelion.research.orbit.imageAnalysis.modules;

import com.actelion.research.orbit.imageAnalysis.components.*;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.imageAnalysis.utils.TiledImageWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.prefs.Preferences;

public class AnomalyDetectionModule extends AbstractOrbitRibbonModule {

    private static final long serialVersionUID = 1L;
    protected static Preferences prefs = Preferences.userNodeForPackage(AnomalyDetectionModule.class);
    protected static final Logger logger = LoggerFactory.getLogger(AnomalyDetectionModule.class);
    private final JButton btnStartDetection = new JButton("Start Detection");
    private final JButton btnSelectModel = new JButton("Select Model");
    private final JButton btnShowHelp = new JButton("Help");

    private static final String prefsModelPath = "modelPath";
    private static final String prefsScalingMin = "scalingMin";
    private static final String prefsScalingMax = "scalingMax";

    private final RangeBar rangeBar = new RangeBar(prefs.getFloat(prefsScalingMin, 0.0f),
            prefs.getFloat(prefsScalingMax, 1.0f));


    private static boolean win_ = System.getProperty("os.name").toLowerCase().startsWith("windows");
    private static boolean linux_ = System.getProperty("os.name").toLowerCase().startsWith("linux");

    public AnomalyDetectionModule(boolean withGui) {
        super();
        if (withGui) {
            createGUI();
        }
    }

    public void createGUI() {
        btnStartDetection.addActionListener(e -> startDetection());
        btnSelectModel.addActionListener(e -> changeModelDir());
        btnShowHelp.addActionListener(e -> showHelp());

        logger.info("Default model Path: " + prefs.get(prefsModelPath, "test"));

        // layout
        setLayout(new GridBagLayout());
        add(btnStartDetection, new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(btnSelectModel, new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.SOUTHEAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(btnShowHelp, new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.SOUTHEAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(new JLabel("Display Range:"), new GridBagConstraints(0, 2, 1, 1, 2, 0, GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(rangeBar, new GridBagConstraints(0, 3, 1, 1, 2, 0, GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

    }

    protected void startDetection() {
    }

    protected void overlayRefresh(){
        logger.debug("Start anomaly detection");
        OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        ImageFrame iFrame = oia.getIFrame();
        iFrame.getOpacitySlider().setEnabled(true);

        RecognitionFrame recognitionFrame = iFrame.getRecognitionFrame();

        TiledImageWriter tiw = new TiledImageWriter(recognitionFrame.bimg.getImage().getWidth(),
                recognitionFrame.bimg.getImage().getHeight(), 512,512){
            @Override
            public void drawImage(Graphics2D graphics, int _vpOffsX, int _vpOffsY, int _vpWidth, int _vpHeight, double scale) {
                double sc = scale/100d;

                int vpWidth = (int)(_vpWidth / sc) -10;
                int vpHeight = (int)(_vpHeight / sc)-10;
                int vpOffsX = (int)(_vpOffsX / sc)+5;
                int vpOffsY = (int)(_vpOffsY / sc)+5;

//                graphics.setTransform(AffineTransform.getScaleInstance(1d/sc, 1/sc));
                graphics.setColor(new Color(127,127,255));
                graphics.fillRect(vpOffsX, vpOffsY, vpWidth, vpHeight);
            }
        };
        recognitionFrame.setClassImage(tiw);
    }

    protected void changeModelDir() {
        JFileChooser fs = new JFileChooser();
        fs.setMultiSelectionEnabled(false);
        fs.setDialogType(JFileChooser.OPEN_DIALOG);
        fs.setDialogTitle("Select a model folder");
        fs.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int res = fs.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            String modelDirectory = fs.getSelectedFile().getPath();
            prefs.put(prefsModelPath, modelDirectory);
            logger.info("Change model for anomaly detection to: " + modelDirectory);
        }
    }

    protected void showHelp() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        String color = OrbitUtils.DARKUI ? " color=white" : "";
        String h = "<html><body" + color + ">" +
                "<h1>Anomaly Detection Module</h1>" +
                "<ul>" +
                "<li></li>" +
                "</ul>" +
                "</p>" +
                "</body></html>";
        oia.addInternalFrame(new ResultFrame(h, "Anomaly detection Module Help"));
    }


    @Override
    public String getName() {
        return "Anomaly Detection";
    }

    @Override
    public void init() {

    }

    @Override
    public void reset() {

    }

}
