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

import com.actelion.research.orbit.beans.RawAnnotation;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.components.*;
import com.actelion.research.orbit.imageAnalysis.cp.CpExportTiles;
import com.actelion.research.orbit.imageAnalysis.cp.CpStarter;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.CellDetectionAnnotation;
import com.actelion.research.orbit.imageAnalysis.models.ImageAnnotation;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.models.SpotAnnotation;
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
import java.util.ListIterator;
import java.util.prefs.Preferences;

public class CellProfilerModule extends AbstractOrbitModule {

    private static final long serialVersionUID = 1L;
    protected static Preferences prefs = Preferences.userNodeForPackage(CellProfilerModule.class);
    protected static final Logger logger = LoggerFactory.getLogger(CellProfilerModule.class);
    private final JButton btnStartCellprofiler = new JButton("Start Cell Profiler");
    private final JButton btnDownloadTiles = new JButton("Download Tiles");
    private final JButton btnResetCpPath = new JButton("Reset CP Path");
    private final JButton btnLoadSpots = new JButton("Load Spots");
    private final JButton btnDeleteSpots = new JButton("Delete Spots");
    private final JButton btnShowHelp = new JButton("Help");
    private static final String prefsCellProfilerPath = "pathToCellProfiler";
    private static boolean win_ = System.getProperty("os.name").toLowerCase().startsWith("windows");
    private static boolean linux_ = System.getProperty("os.name").toLowerCase().startsWith("linux");

    public CellProfilerModule(boolean withGui) {
        if (withGui) {
            createGUI();
        }
    }

    public void createGUI() {
        btnStartCellprofiler.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startCellprofiler(true);
            }
        });


        btnShowHelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showHelp();
            }
        });

        btnResetCpPath.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetCpPath();
            }
        });

        btnLoadSpots.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadSpots();
            }
        });

        btnDeleteSpots.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSpots();
            }
        });

        btnDownloadTiles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                downloadTiles();
            }
        });


        // layout
        setLayout(new GridBagLayout());
        add(btnStartCellprofiler, new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(btnDownloadTiles, new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.SOUTHEAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

        add(btnLoadSpots, new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(btnDeleteSpots, new GridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

        add(btnShowHelp, new GridBagConstraints(0, 2, 1, 1, 1, 0, GridBagConstraints.SOUTHEAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(btnResetCpPath, new GridBagConstraints(1, 2, 1, 1, 1, 0, GridBagConstraints.SOUTHEAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

    }


    protected void showHelp() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        String color = OrbitUtils.DARKUI ? " color=white" : "";
        String h = "<html><body" + color + ">" +
                "<h1>Cell Profiler Module</h1>" +
                "<h2>Prerequisites</h2>" +
                "<ul>" +
                "<li>Download some sample image tiles and create a Cell Profiler Pipeline (.cppipe) using these tiles for testing.</li>" +
                "<li>Draw annotations in combination with an exclusion model to define the ROI per image.</li>" +
                "<li>Cell Profiler must be installed on the local PC.</li>" +
                "<li>For linux ~/cpstart will be checked. (Symlink to cp2)</li>" +
                "</ul>" +
                "<p>CP Meta Data pattern: <pre>^(?P&lt;OrbitID>.*)\\$tile(?P&lt;tileX>[0-9]{1,3})x(?P&lt;tileY>[0-9]{1,3}).jpg</pre></p>" +
                "<p>" +
                "<ul>" +
                "<li>Use the 'old' LoadImages module.</li>" +
                "<li><b>ExportToSpreadsheet options:</b></li>" +
                "<li>No prefix (empty field).</li>" +
                "<li>Use ExportToSpreadsheet with 'location' export enabled for objects, e.g. cells.</li>" +
                "<li>For image, only export metadata->OrbitID, tileX, tileY.</li>" +
                "<li>Set 'Export all measurements' to no, instead select the image and all objects.</li>" +
                "<li>Disable all 'per-image' exports.</li>" +
                "<li>Export the pipeline (File->Export Pipeline), Orbit needs a .cppipe file, not the project.</li>" +
                "</ul>" +
                "</p>" +
                "</body></html>";
        oia.addInternalFrame(new ResultFrame(h, "Cell Profiler Module Help"));
    }


    public static String getCellProfilerCmd() {
        String cmd = "C:\\Program Files\\CellProfiler21\\cp.exe";
        if (new File(cmd).exists()) {
            logger.info("existing path to Cell Profiler (default path): " + cmd);
            return cmd; // already set
        } else {
            cmd = "C:\\Program Files\\CellProfiler2\\cp.exe";
            if (new File(cmd).exists()) {
                logger.info("existing path to Cell Profiler (default path): " + cmd);
                return cmd; // already set
            } else {
                cmd = "C:\\Program Files\\cp\\cp.exe";
                if (new File(cmd).exists()) {
                    logger.info("existing path to Cell Profiler (default path): " + cmd);
                    return cmd; // already set
                } else {
                    cmd = "~/cpstart";
                    if (linux_ && new File(cmd).exists()) {
                        logger.info("existing path to Cell Profiler (default path): " + cmd);
                        return cmd; // already set
                    } else {
                        cmd = prefs.get(prefsCellProfilerPath, "");
                        if (cmd != null && cmd.length() > 0 && (new File(cmd).exists())) {
                            logger.info("existing path to Cell Profiler: " + cmd);
                            return cmd; // already set
                        } else {
                            if (linux_) {
                                logger.info("Cell profiler start command not found. Orbit will check ~/cpstart. You can symlink ~/cpstart to e.g. cp2.");
                            }
                            // not found, so ask the user where chemDraw is installed
                            JFileChooser fs = new JFileChooser();
                            fs.setMultiSelectionEnabled(false);
                            fs.setDialogType(JFileChooser.OPEN_DIALOG);
                            fs.setDialogTitle("Please point to cp.exe");
                            fs.setFileSelectionMode(JFileChooser.FILES_ONLY);
                            int res = fs.showOpenDialog(null);
                            if (res == JFileChooser.APPROVE_OPTION) {
                                cmd = fs.getSelectedFile().getAbsolutePath();
                                prefs.put(prefsCellProfilerPath, cmd);
                                logger.info("new path to Cell Profiler: " + cmd);
                                return cmd;
                            } else {
                                return null;
                            }
                        }
                    }
                }
            }
        }
    }


    private String getPipeline() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Cell Profiler Pipeline");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Cell Profiler Pipeline (*.cppipe)", "cppipe");
        fileChooser.setFileFilter(filter);
        String dir = prefs.get("OrbitImageAnalysis.CellProfilerModule.OpenCPPipeDir", null);
        if (dir != null) {
            File cd = new File(dir);
            fileChooser.setCurrentDirectory(cd);
        }
        int returnVal = fileChooser.showOpenDialog(CellProfilerModule.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            prefs.put("OrbitImageAnalysis.CellProfilerModule.OpenCPPipeDir", fileChooser.getCurrentDirectory().getAbsolutePath());
            File file = fileChooser.getSelectedFile();
            logger.info("pipeline selected: " + file.getAbsolutePath());
            return file.getAbsolutePath();
        } else {
            logger.trace("pipeline load canceled.");
            return null;
        }
    }

    private String getWorkingDir() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select working directory");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        String dir = prefs.get("OrbitImageAnalysis.CellProfilerModule.WorkingDir", null);
        if (dir != null) {
            File cd = new File(dir);
            fileChooser.setCurrentDirectory(cd);
        }
        int returnVal = fileChooser.showOpenDialog(CellProfilerModule.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            prefs.put("OrbitImageAnalysis.CellProfilerModule.WorkingDir", fileChooser.getSelectedFile().getAbsolutePath());
            File file = fileChooser.getSelectedFile();
            logger.info("working directory selected: " + file.getAbsolutePath());
            if (makeDirEmpty(file)) {
                return file.getAbsolutePath();
            } else {
                return null;
            }
        } else {
            logger.trace("working directory selection canceled.");
            return null;
        }
    }


    private boolean makeDirEmpty(File dir) {
        boolean cancel = false;
        while (!cancel) {
            File[] files = dir.listFiles();
            if (files != null && files.length > 0) {
                if (JOptionPane.showConfirmDialog(this,
                        "The working directory is not empty. Please manually delete all files in " + dir + "\n(or the whole directory) and click ok",
                        "Empty Directory", JOptionPane.OK_CANCEL_OPTION)
                        == JOptionPane.CANCEL_OPTION) {
                    cancel = true;
                }
            } else {
                // check if dir exists or user deleted whole dir
                if (!dir.exists()) dir.mkdirs();
                return true; // is empty
            }
        }
        return false;
    }

    private String getDownloadDir() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select download directory");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        String dir = prefs.get("OrbitImageAnalysis.CellProfilerModule.DownloadDir", null);
        if (dir != null) {
            File cd = new File(dir);
            fileChooser.setCurrentDirectory(cd);
        }
        int returnVal = fileChooser.showOpenDialog(CellProfilerModule.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            prefs.put("OrbitImageAnalysis.CellProfilerModule.DownloadDir", fileChooser.getSelectedFile().getAbsolutePath());
            File file = fileChooser.getSelectedFile();
            logger.info("download directory selected: " + file.getAbsolutePath());
            return file.getAbsolutePath();
        } else {
            logger.trace("download directory selection canceled.");
            return null;
        }
    }

    protected void startCellprofiler(final boolean withGui) {
        // check prerequisites
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        final String cellProfilerCmd = getCellProfilerCmd();
        if (cellProfilerCmd == null) return;
        final String cpPipe = getPipeline();
        if (cpPipe == null) return;
        final String workDir = getWorkingDir();
        if (workDir == null) return;

        boolean storeAnnotations = false;
        if (JOptionPane.showConfirmDialog(this,
                "Do you want to store the cell annotations in the database?",
                "Store Cell Annotations?", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) {
            storeAnnotations = true;
        }

        if (storeAnnotations) oia.forceLogin();

        logger.info("cp.exe: " + cellProfilerCmd);
        logger.info("Pipeline: " + cpPipe);
        logger.info("Working Directory: " + workDir);
        logger.info("Store Annotations: " + storeAnnotations);

        final OrbitModel model = oia.getModel();
        // if (model.getExclusionModel() == null) model.setExclusionModel(new APARModelV3(model));

        try {
            final List<RawDataFile> rdfList = oia.browseImages();
            if (rdfList != null) {
                CpStarter starter = new CpStarter(cellProfilerCmd, model, cpPipe, rdfList, workDir, storeAnnotations, OrbitImageAnalysis.loginUser);
                oia.addAndExecuteTask(new ProgressPanel("[" + rdfList.size() + "] image(s)", "Cell Profiler", starter));
            } else logger.info("rdf chooser canceled");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("File Browser Error: " + e.getMessage());
        }

    }


    protected void resetCpPath() {
        prefs.remove(prefsCellProfilerPath);
        JOptionPane.showMessageDialog(CellProfilerModule.this, "Path to Cell Profiler successfuly reset.\nThe next time you click on 'Start Cell Profiler' you will be asked for the new path.", "Path to Cell Profiler reset", JOptionPane.INFORMATION_MESSAGE);
    }


    private void downloadTiles() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        final ImageFrame iFrame = oia.getIFrame();
        RawDataFile rdf = iFrame == null ? null : iFrame.getRdf();
        if (rdf == null) {
            logger.error("No Orbit imagen open. Please open an Orbit image first.");
            return;
        }
        String dir = getDownloadDir();
        if (dir == null) return;

        List<RawDataFile> rdfList = new ArrayList<>();
        rdfList.add(rdf);
        CpExportTiles export = new CpExportTiles();
        try {
            oia.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            export.setMultiBatch(false);
            OrbitModel exclModel = null;
            if (oia.getModel() != null && oia.getModel().getExclusionModel() != null) {
                exclModel = oia.getModel();
            }
            export.downloadTiles(rdfList, dir, exclModel);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error downloading tiles ", e);
            return;
        } finally {
            oia.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
        JOptionPane.showMessageDialog(CellProfilerModule.this, "Tiles downloaded into folder " + dir, "Download successful", JOptionPane.INFORMATION_MESSAGE);
    }


    protected void loadSpots() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        final ImageFrame iFrame = oia.getIFrame();
        if (oia.getModel() == null) {
            logger.error("Please load an appropriate Orbit model (.omo) first or create a new model.");
            return;
        }

        RawDataFile rdf = iFrame == null ? null : iFrame.getRdf();
        if (rdf == null) {
            logger.error("No Orbit imagen open. Please open an Orbit image first.");
            return;
        }
        try {
            List<RawAnnotation> raList = DALConfig.getImageProvider().LoadRawAnnotationsByRawDataFile(rdf.getRawDataFileId(), RawAnnotation.ANNOTATION_TYPE_SPOT);
            if (raList == null || raList.size() == 0) {
                logger.error("No spots found for this image.");
                return;
            }
            for (RawAnnotation ra : raList) {
                if (ra.getRawAnnotationType() == RawAnnotation.ANNOTATION_TYPE_SPOT) {
                    SpotAnnotation annotation = new CellDetectionAnnotation(ra);
                    iFrame.getRecognitionFrame().getAnnotations().add(annotation);
                }
            }
        } catch (Exception e) {
            logger.error("Error laoding spots", e);
        }
    }


    protected void deleteSpots() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        final ImageFrame iFrame = oia.getIFrame();

        if (JOptionPane.showConfirmDialog(this,
                "Do you really want to delete all spot annotations for image " + iFrame.getTitle() + "?",
                "Really delete spot annotations?", JOptionPane.YES_NO_OPTION)
                == JOptionPane.NO_OPTION) {
            return;
        }

        RawDataFile rdf = iFrame == null ? null : iFrame.getRdf();
        if (rdf == null) {
            logger.error("No Orbit imagen open. Please open an Orbit image first.");
            return;
        }
        try {
            if (!DALConfig.getImageProvider().DeleteRawAnnotationAllWithType(rdf.getRawDataFileId(), RawAnnotation.ANNOTATION_TYPE_SPOT)) {
                logger.error("Error: Cannot delete spot annotations.");
            } else {
                logger.info("Spot annotations successfully deleted.");
            }

            ListIterator<ImageAnnotation> iter = iFrame.getRecognitionFrame().getAnnotations().listIterator();
            while (iter.hasNext()) {
                ImageAnnotation anno = iter.next();
                if (anno instanceof SpotAnnotation) iter.remove();
            }

            iFrame.getRecognitionFrame().repaint();
        } catch (Exception e) {
            logger.error("Error loading spots", e);
        }
    }


    @Override
    public String getName() {
        return "Cell Profiler";
    }

    @Override
    public void init() {

    }

    @Override
    public void reset() {

    }


}
