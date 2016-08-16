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

package com.actelion.research.orbit.imageAnalysis.modules;

import com.actelion.research.orbit.imageAnalysis.components.*;
import com.actelion.research.orbit.imageAnalysis.models.ClassShape;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.tasks.ExclusionMapGen;
import com.actelion.research.orbit.imageAnalysis.tasks.OrbitWorker;
import com.actelion.research.orbit.imageAnalysis.tasks.TrainWorker;
import com.actelion.research.orbit.imageAnalysis.utils.ClassListCellRenderer;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

public class ExclusionModule extends AbstractOrbitModule {

    private static final long serialVersionUID = 1L;
    private final static Logger logger = LoggerFactory.getLogger(ExclusionModule.class);
    private final JButton btnSetupClasses = new JButton("Setup Classes");
    private final JButton btnConfigureClasses = new JButton("Configure Classes");
    private final JButton btnTrain = new JButton("Train, Set and Classify");
    private final JButton btnLoad = new JButton("Load and Set Exclusion Model");
    private final JButton btnClassify = new JButton("Classify Trained Exclusion Model");
    private final JButton btnReset = new JButton("Reset Exclusion Model");
    private final JButton btnHelp = new JButton("Help");
    protected final Preferences prefs = Preferences.userNodeForPackage(this.getClass());


    public ExclusionModule() {

        btnSetupClasses.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setupClasses();
            }
        });

        btnConfigureClasses.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                configureClasses();
            }
        });

        btnTrain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                trainSetAndClassifyExcl();
            }
        });

        btnClassify.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                classifyExcl();
            }
        });

        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetModel();
            }
        });

        btnLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadModel();
            }
        });

        btnHelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showHelp();
            }
        });

        setLayout(new GridLayout(7, 1));
        add(btnSetupClasses);
        add(btnConfigureClasses);
        add(btnTrain);
        add(btnLoad);
        add(btnClassify);
        add(btnReset);
        add(btnHelp);
    }


    protected void setupClasses() {
        final OrbitImageAnalysis OIA = OrbitImageAnalysis.getInstance();
        if (JOptionPane.showConfirmDialog(OIA,
                "This will reset all current training shapes.\nDo you want to continue?",
                "Reset current training data?", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) {
            List<ClassShape> classShapes = new ArrayList<ClassShape>(4);    // define some default classes
            classShapes.add(new ClassShape("Exclusion 1", Color.yellow, ClassShape.SHAPETYPE_POLYGONEXT, ClassShape.EXCLUSION));
            classShapes.add(new ClassShape("Exclusion 2", Color.red, ClassShape.SHAPETYPE_POLYGONEXT, ClassShape.EXCLUSION));
            classShapes.add(new ClassShape("Inclusion 1", Color.green, ClassShape.SHAPETYPE_POLYGONEXT, ClassShape.INCLUSION));
            classShapes.add(new ClassShape("Inclusion 2", Color.blue, ClassShape.SHAPETYPE_POLYGONEXT, ClassShape.INCLUSION));
            for (ImageFrame iFrame : OIA.getIFrames()) {
                iFrame.recognitionFrame.setClassShapes(OrbitUtils.cloneClassShapes(classShapes));
                iFrame.recognitionFrame.setWindowSize(OIA.getModel().getFeatureDescription().getWindowSize());
                iFrame.recognitionFrame.setBoundaryClass(OIA.getModel().getBoundaryClass());
            }
            OIA.getModel().setClassShapes(classShapes);
            OIA.makeClassCombobox();
        }
    }

    private void configureClasses() {
        final OrbitImageAnalysis OIA = OrbitImageAnalysis.getInstance();
        OrbitModel exclModel = OIA.getModel().getExclusionModel();
        if (exclModel == null) {
            JOptionPane.showMessageDialog(ExclusionModule.this, "Exclusion model not available.\nPlease train an exclusion model first.", "Exclusion model not available.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ClassAdminFrame configFrame = new ClassAdminFrame(exclModel.getClassShapes(), new ClassListCellRenderer(), -1, false);
        configFrame.setAlwaysOnTop(true);
        configFrame.setVisible(true);
    }


    private void trainSetAndClassifyExcl() {
        final OrbitImageAnalysis OIA = OrbitImageAnalysis.getInstance();
        List<ImageFrame> lowFrames = new ArrayList<ImageFrame>();
        for (ImageFrame iFrame : OIA.getIFrames()) {
            RecognitionFrame lowResFrame = ExclusionMapGen.getExclusionMapFrame(iFrame.getRdf(), iFrame.recognitionFrame, OIA.getModel());
            double scaleFactor = lowResFrame.bimg.getWidth() / (double) iFrame.recognitionFrame.bimg.getWidth();
            logger.trace("exclusion frame / normal frame scalefactor: " + scaleFactor);
            List<ClassShape> classShapes = ClassShape.scaleShapes(iFrame.recognitionFrame.getClassShapes(), scaleFactor);
            lowResFrame.setClassShapes(classShapes);
            ImageFrame lowResIFrame = new ImageFrame(lowResFrame);
            lowFrames.add(lowResIFrame);
        }

        TrainWorker trainWorker = new TrainWorker(lowFrames, true, false, OIA.getModel());
        trainWorker.run();

        OIA.setModelAsExclusionModel(OIA.getModel(), false);
        OIA.setModifiedClassShapes(false);

        classifyExcl();
    }

    private void classifyExcl() {
        final OrbitImageAnalysis OIA = OrbitImageAnalysis.getInstance();
        final ImageFrame iFrame = OIA.getIFrame();
        if (iFrame.getRdf() != null)
            iFrame.recognitionFrame.loadAnnotationROI(iFrame.getRdf().getRawDataFileId(), OIA.getModel().getAnnotationGroup());
        final ExclusionMapGen exMapGen = ExclusionMapGen.constructExclusionMap(iFrame.getRdf(), iFrame.recognitionFrame, OIA.getModel());
        OrbitWorker worker = new OrbitWorker() {
            @Override
            protected void doWork() throws Exception {
                try {
                    logger.trace("start classifying exclusion map");
                    exMapGen.generateMap();
                    iFrame.recognitionFrame.setExMapGen(exMapGen);
                    if (exMapGen.getClassificationImage() != null)
                        iFrame.recognitionFrame.setClassImage(exMapGen.getClassificationImage());
                    iFrame.recognitionFrame.setClassImageScale((float) (1d / exMapGen.getScaleFactor()));
                    iFrame.getOpacitySlider().setEnabled(true);
                    iFrame.repaint();
                    logger.trace("end classifying exclusion map");
                } catch (Exception e1) {
                    e1.printStackTrace();
                    logger.error("error creating the exclusion map (maybe the exclusion model is not set?): " + e1.getMessage());
                }
            }
        };
        ProgressPanel progressPanel = new ProgressPanel(OIA.getCurrentPicName(), "Excl Map Classification", worker);
        OIA.addAndExecuteTask(progressPanel);
    }


    private void resetModel() {
        final OrbitImageAnalysis OIA = OrbitImageAnalysis.getInstance();
        OIA.getModel().setExclusionModel(null);
        OIA.updateStatusBar();
    }

    private void loadModel() {
        final OrbitImageAnalysis OIA = OrbitImageAnalysis.getInstance();
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "OrbitImageAnalysis Models (*.omo)", "omo");
        fileChooser.setFileFilter(filter);
        String dir = prefs.get("OrbitImageAnalysis.OpenExclusionModelCurrentDir", null);
        if (dir != null) {
            File cd = new File(dir);
            fileChooser.setCurrentDirectory(cd);
        }
        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            prefs.put("OrbitImageAnalysis.OpenExclusionModelCurrentDir", fileChooser.getCurrentDirectory().getAbsolutePath());
            File file = fileChooser.getSelectedFile();
            OrbitModel exclModel = OrbitModel.LoadFromFile(file.getAbsolutePath());
            OIA.getModel().setExclusionModel(exclModel);
            logger.info("exclusion model loaded and set");
            OIA.updateStatusBar();
            JOptionPane.showMessageDialog(null, "Exclusion model loaded and set.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            logger.trace("load model canceled.");
        }
    }

    @Override
    public String getName() {
        return "Exclusion Model";
    }

    @Override
    public void init() {
    }

    @Override
    public void reset() {
    }

    private void showHelp() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        String color = OrbitUtils.DARKUI ? " color=white" : "";
        String h = "<html><body" + color + ">" +
                "<h1>Exclusion Model Module</h1>" +
                "<h2>Description</h2>" +
                "An exclusion model defines exclusion and inclusion classes and can be seen as a trainable region of interest (ROI) definition. The model is used to exclude some regions from classification or segmentation. This is typically used to exclude background or artefacts like dirt or folds." +
                "<br/>Internally the model is applied to a low level resolution image to classify larger regions of a high resolution (e.g. slide) image.<br/>" +
                "<h2>How to build and use an exclusion model</h2>" +
                "<ol>" +
                "<li>Setup inclusion and exclusion classes. You might click on 'Setup classes' in this module to use a predefined class setup. You can rename the classes or select different colors if you want.</li>" +
                "<li>Configure model parameters (F3), set structure size and median filter values. For exclusion models for whole slide images a structure size between 4 and 15 is recommended.</li>" +
                "<li>Mark regions for exclusion and inclusion classes using the standard class marking tools from the main toolbar. You might skip the some exclusion or inclusion class. Hint: Set the zoom to a low level so that you have an overview of your whole image.</li>" +
                "<li>Click on 'Train, Set and Classify' and drag the classification transparency slider of your image to check the model. This step sets the exclusion model of your main (loaded or trained) model. If you save your model, the embedded exclusion model will be saved, too.</li>" +
                "<li>Mark further class regions or remove class regions using the rubber tool and repeat the last setp until you're fine with the model.</li>" +
                "<li>To apply this exclusion model to further images, use the 'classify trained exclusion model' button.</li>" +
                "<li>You can add manual exclusion or inclusion annotations with the annotation tab on the right side, which will overrule the regions defined by the exclusion model.</li>" +
                "<li>If you're fine with your exclusion model save it to disk or in Orbit if you want (optional) and continue with a normal classification model (either 'Model->Reset Training Data' to reset the class regions or clasification->setup classes which does that automatically) to define an e.g. active/non-active model.</li>" +
                "<li>Continue with a normal classification or segmentation.</li>" +
                "<li>To remove the exclusion model from the main model, click on 'Reset Exclusion Model'.</li>" +
                "<li>Hint: Often it is easier to 1) define an exclusion model, save it. 2) Creating a complete new classification or segmentation model. Finally 3) Embed the exclusion model via model->load existing exclusion model.</li>" +
                "</ol>" +
                "</body></html>";
        oia.addInternalFrame(new ResultFrame(h, "Exclusion Model Help"));
    }


    public JButton getBtnClassify() {
        return btnClassify;
    }

    public JButton getBtnConfigureClasses() {
        return btnConfigureClasses;
    }

    public JButton getBtnHelp() {
        return btnHelp;
    }

    public JButton getBtnLoad() {
        return btnLoad;
    }

    public JButton getBtnReset() {
        return btnReset;
    }

    public JButton getBtnSetupClasses() {
        return btnSetupClasses;
    }

    public JButton getBtnTrain() {
        return btnTrain;
    }
}
