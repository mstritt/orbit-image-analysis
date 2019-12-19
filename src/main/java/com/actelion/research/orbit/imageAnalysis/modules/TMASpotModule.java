package com.actelion.research.orbit.imageAnalysis.modules;

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.TMA.DetectSpotsGUI;
import com.actelion.research.orbit.imageAnalysis.components.AbstractOrbitModule;
import com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TMASpotModule extends AbstractOrbitModule {

    private static final long serialVersionUID = 1L;
    private final static Logger logger = LoggerFactory.getLogger(TMASpotModule.class);

    private final JButton btnSelectFiles = new JButton("Select Images...");
    private final JLabel labelNumFilesSelected = new JLabel("0 images selected.");
    private final JButton btnLaunchAnnotator = new JButton("Launch Smart Annotation Assistant");
    private final JLabel labelPublishSuccessful = new JLabel();

    private JDialog dialog = new JDialog();

    private List<RawDataFile> rdfList;

    public TMASpotModule(boolean withGui) {
        if (withGui) {
            setupGui();
        }
    }

    @Override
    public String getName() {
        return "Smart Annotation Tool";
    }

    @Override
    public void init() {
        // Do nothing
    }

    public void setupGui() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        btnLaunchAnnotator.setEnabled(false);

        btnSelectFiles.addActionListener(e -> {
            try {
                rdfList = OrbitHelper.browseImagesDefault(oia);
                if (rdfList.size() > 0) {
                    labelNumFilesSelected.setText(String.format("%s images selected.", rdfList.size()));
                    btnLaunchAnnotator.setEnabled(true);
                } else {
                    btnLaunchAnnotator.setEnabled(false);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                logger.debug(ex.getMessage());
            }
        });

        btnLaunchAnnotator.addActionListener(e -> {
            // Open the Smart Annotation Tools
            try {
                if (rdfList.size() > 0) {
                    this.dialog = createTMADialog(rdfList);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                logger.debug(ex.getMessage());
            }
        });

        // layout
        JPanel btn1Panel = new JPanel(new GridLayout(4, 1));
        btn1Panel.add(btnSelectFiles);
        btn1Panel.add(labelNumFilesSelected);
        btn1Panel.add(btnLaunchAnnotator);
        btn1Panel.add(labelPublishSuccessful);

        setLayout(new GridBagLayout());
        add(btn1Panel, new GridBagConstraints(0, 1, GridBagConstraints.REMAINDER, 1, 1, 0, GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    }

    public JDialog createTMADialog(List<RawDataFile> rdfList) throws Exception {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();

        this.putClientProperty("AccessibleDescription", this.getName());
        JDialog dialog = null;
        if (oia instanceof Frame) {
            dialog = new JDialog((Frame) oia, this.getName(), true);
        }

        dialog.setComponentOrientation(this.getComponentOrientation());
        Container contentPane = dialog.getContentPane();
        contentPane.setLayout(new BorderLayout());

        contentPane.add(new DetectSpotsGUI(rdfList), "Center");

        if (JDialog.isDefaultLookAndFeelDecorated()) {
            boolean supportsWindowDecorations = UIManager.getLookAndFeel().getSupportsWindowDecorations();
            if (supportsWindowDecorations) {
                dialog.getRootPane().setWindowDecorationStyle(6);
            }
        }

        dialog.pack();
        dialog.setLocationRelativeTo(oia);
        dialog.setVisible(true);

        return dialog;
    }

    /**
     * Clears panel
     */
    @Override
    public void reset() {
        System.gc();
    }

}
