/*
 * Orbit, a versatile image analysis software for biological image-based quantification.
 * Copyright (C) 2009 - 2020 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.actelion.research.orbit.imageAnalysis.components;

import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class OrbitStatusBar extends JPanel {

    private static final long serialVersionUID = 1L;
    private final Logger logger = LoggerFactory.getLogger(OrbitStatusBar.class);
    private final JLabel copyright = new JLabel(" ");
    private final JProgressBar memory = new JProgressBar();
    private final JProgressBar cpu = new JProgressBar();
    private final JLabel loginUser = new JLabel(" ");
    private final JLabel loadedModel = new JLabel(" ");
    private final JLabel tempSpace = new JLabel(" ");
//    private final OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
//            OperatingSystemMXBean.class);

    public OrbitStatusBar() {
        super(new BorderLayout(5, 5));
        copyright.setBorder(BorderFactory.createLoweredBevelBorder());
        loginUser.setBorder(BorderFactory.createLoweredBevelBorder());
        loadedModel.setBorder(BorderFactory.createLoweredBevelBorder());
        tempSpace.setBorder(BorderFactory.createLoweredBevelBorder());
        copyright.setPreferredSize(new Dimension(300, 10));
        loginUser.setPreferredSize(new Dimension(200, 10));
        memory.setBorder(BorderFactory.createLoweredBevelBorder());
        memory.setStringPainted(true);
        memory.setString("");
        memory.setMaximum(100);
        memory.setMinimum(0);
        cpu.setBorder(BorderFactory.createLoweredBevelBorder());
        cpu.setStringPainted(true);
        cpu.setString("");
        cpu.setMinimum(0);
        cpu.setMaximum(100);

        memory.addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseClicked(MouseEvent e) {
                logger.debug("calling garbage collector");
                System.gc();
            }
        });

        JPanel middlePanel = new JPanel(new BorderLayout(5, 5));
        middlePanel.add(loginUser, BorderLayout.WEST);
        middlePanel.add(loadedModel, BorderLayout.CENTER);
        middlePanel.add(tempSpace, BorderLayout.EAST);
        add(copyright, BorderLayout.WEST);
        add(memory, BorderLayout.EAST);
//        add(cpu, BorderLayout.EAST);
        add(middlePanel, BorderLayout.CENTER);
    }

    public void setCopyright(String t) {
        copyright.setText(t);
    }

    public void setLoginUser(String loginUser) {
        this.loginUser.setText(loginUser);
    }

    public void setLoadedModel(String loadedModel) {
        this.loadedModel.setText(loadedModel);
    }

    public void setTempSpaceStr(String tempSpaceStr) {
        this.tempSpace.setText(tempSpaceStr);
    }

    public void setMemory(long current, long max) {
        final String str = current + " / " + max + " MB Memory";
        final int prog = (int) ((current / (double) max) * 100d);
        SwingUtilities.invokeLater(() -> {
            memory.setString(str);
            memory.setValue(prog);
        });
    }

    // Not supported with standard Java :-(
//    private void setCPU() {
//        final int cpuPercent = (int) osBean.getSystemCpuLoad() * 100;
//        final String str = cpuPercent + "%";
//        SwingUtilities.invokeLater(() -> {
//            cpu.setString(str);
//            cpu.setValue(cpuPercent);
//        });
//    }

    public void updateStatusBar(String loadedModel, OrbitModel model) {
        double freeSpace = OrbitUtils.getTempDiskSpace() / (1024d * 1024 * 1024); // in GB
        this.setCopyright("Orbit Image Analysis Version " + OrbitUtils.VERSION_STR);
        this.setTempSpaceStr("Temp Space: " + String.format("%1$.2f", freeSpace) + " GB");
        String trained = "no";
        String segModel = "no";
        String exclModel = "no";
        String mask = "no";
        if (model != null) {
            trained = (model.getClassifier() != null && model.getClassifier().isBuild()) ? "yes" : "no";
            segModel = model.getSegmentationModel() != null ? "yes" : "no";
            exclModel = model.getExclusionModel() != null ? "yes" : "no";
            mask = model.getMask()!=null ? "yes" : "no";
        }
        this.setLoadedModel("Model: " + loadedModel + " / Trained:" + trained + " / Segmentation:" + segModel
                + " / Exclusion:" + exclModel+" Mask:" + mask);
        this.setLoginUser("Login User: " + OrbitImageAnalysis.loginUser);
        this.setMemory(Runtime.getRuntime().totalMemory() / (1024L * 1024L),
                Runtime.getRuntime().maxMemory() / (1024L * 1024L));
//        this.setCPU();
    }

}
