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

import com.actelion.research.orbit.gui.DoubleInputVerifier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FuzzynessAdminFrame extends JDialog {

    private static final long serialVersionUID = 1L;
    private JButton btnOK = null;
    private JTextField tfPixelFuzzyness = null;
    private JTextField tfTileFuzzyness = null;

    private int frameWidth = 400;
    private int frameHeight = 250;
    private int btnHeight = 30;

    public FuzzynessAdminFrame() {
        initialize();
    }

    private void initialize() {
        this.setTitle("Fuzzyness Configuration");
        java.net.URL imgURL = this.getClass().getResource(OrbitImageAnalysis.LOGO_NAME);
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            this.setIconImage(icon.getImage());
        }
        setResizable(false);
        setSize(new Dimension(frameWidth, frameHeight));
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        JLabel featLabel = new JLabel("Fuzzyness");
        setCompBounds(featLabel, frameWidth, 0);
        add(featLabel);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JLabel lab = new JLabel("Pixel Fuzzyness:");
        panel.add(lab);
        tfPixelFuzzyness = new JTextField();
        tfPixelFuzzyness.setText(String.format("%1$.2f", OrbitImageAnalysis.getInstance().getPixelFuzzyness()));
        tfPixelFuzzyness.setInputVerifier(new DoubleInputVerifier(0d));
        panel.add(tfPixelFuzzyness);
        setCompBounds(panel, frameWidth - 50, 0);
        add(panel);

        panel = new JPanel(new GridLayout(1, 2));
        lab = new JLabel("Tile Fuzzyness:");
        panel.add(lab);
        tfTileFuzzyness = new JTextField();
        tfTileFuzzyness.setText(String.format("%1$.2f", OrbitImageAnalysis.getInstance().getTileFuzzyness()));
        tfTileFuzzyness.setInputVerifier(new DoubleInputVerifier(0));
        panel.add(tfTileFuzzyness);
        setCompBounds(panel, frameWidth - 50, 0);
        add(panel);


        btnOK = new JButton("OK");
        setCompBounds(btnOK, frameWidth / 2, 0);
        JPanel spacer = new JPanel();
        setCompBounds(spacer, frameWidth / 2, 0);
        //add(spacer);
        add(btnOK);


        addActionListeners();

        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation((size.width - getWidth()) / 2, (size.height - getHeight()) / 2);
    }


    private void setCompBounds(Component comp, int width, int y) {
        comp.setMaximumSize(new Dimension(width, btnHeight));
        comp.setPreferredSize(new Dimension(width, btnHeight));
        comp.setMinimumSize(new Dimension(width, btnHeight));
    }


    private void addActionListeners() {
        ActionListener okAction = new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                exitProcedure();
            }
        };
        btnOK.addActionListener(okAction);
    }


    public void exitProcedure() {
        try {
            double pixelFuzzyness = Double.parseDouble(tfPixelFuzzyness.getText().replaceAll(",", "\\."));
            OrbitImageAnalysis.getInstance().setPixelFuzzyness(pixelFuzzyness);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cannot parst pixel fuzzyness. Please enter a correct numeric value, e.g. 0.5", "Cannot parse pixel fuzzyness", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            double tileFuzzyness = Double.parseDouble(tfTileFuzzyness.getText().replaceAll(",", "\\."));
            OrbitImageAnalysis.getInstance().setTileFuzzyness(tileFuzzyness);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cannot parst tile fuzzyness. Please enter a correct numeric value, e.g. 0.5", "Cannot parse tile fuzzyness", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.dispose();
    }


}
