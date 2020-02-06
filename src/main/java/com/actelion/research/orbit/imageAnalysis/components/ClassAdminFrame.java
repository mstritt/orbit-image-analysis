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

import com.actelion.research.orbit.imageAnalysis.models.ClassShape;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;


public class ClassAdminFrame extends JDialog {

    private static final Logger log = LoggerFactory.getLogger(ClassAdminFrame.class);
    private static final long serialVersionUID = 264449917842683627L;
    public static final String CLASSADMIN_DONE = "classAdminFrame_classAdminDone";

    private ResourceBundle resourceBundle;

    private JPanel panelClassAttributes = null;
    private JScrollPane classScrollPane = null;
    private JList classList = null;
    private final List<ClassShape> classShapes;
    private JTextField tfClassName = null;
    private JButton btnAddClass = null;
    private JButton btnRemoveClass = null;
    private JButton btnRenameClass = null;
    private JButton btnChooseColor = null;
    private final JLabel labIncExclMode = new JLabel("For Exclusion and Mask Model:");
    private JComboBox cbIncExclMode = new JComboBox(new String[]{ClassShape.STR_UNDEFINED, ClassShape.STR_Inclusion, ClassShape.STR_Exclusion});
    private JButton btnOK = null;

    //private JComboBox boxToUpdate = null;
    private int frameWidth = 800;  // 647
    private int frameHeight = 555;
    private int btnHeight = 30;
    private int boundaryClass = -1;
    private boolean firePropertyChangeEvent = true;


    public ClassAdminFrame(final List<ClassShape> classShapes, final ListCellRenderer renderer, final int boundaryClass, boolean firePropertyChangeEvent) {
        Locale currLocale = Locale.getDefault();
        resourceBundle = ResourceBundle.getBundle("Resources", currLocale);

        this.firePropertyChangeEvent = firePropertyChangeEvent;
        this.boundaryClass = boundaryClass;
        initialize();
        DefaultListModel model = new DefaultListModel();
        for (ClassShape cs : classShapes) model.addElement(cs);
        this.classList.setModel(model);
        this.classList.setCellRenderer(renderer);
        this.classList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                ClassShape cs = (ClassShape) classList.getSelectedValue();
                if (cs == null) return;
                if (tfClassName != null) tfClassName.setText(cs.getName());
                setIncExclMode(cs);
            }
        });

        this.classShapes = classShapes;
    }

    private void setIncExclMode(ClassShape cs) {
        if (cs.getIncExcMode() == ClassShape.UNDEFINED) cbIncExclMode.setSelectedItem(ClassShape.STR_UNDEFINED);
        if (cs.getIncExcMode() == ClassShape.INCLUSION) cbIncExclMode.setSelectedItem(ClassShape.STR_Inclusion);
        if (cs.getIncExcMode() == ClassShape.EXCLUSION) cbIncExclMode.setSelectedItem(ClassShape.STR_Exclusion);
    }


    private void initialize() {
        this.setTitle(resourceBundle.getString("Model.ConfigureModel.classes.text"));
        java.net.URL imgURL = this.getClass().getResource(OrbitImageAnalysis.LOGO_NAME);
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            this.setIconImage(icon.getImage());
        }
        setResizable(false);
        setSize(new Dimension(frameWidth, frameHeight));
        setLayout(new GridLayout(1, 3, 10, 10));

        // class attributes panel
        JPanel p = getPanelClassAttributes();
        JLabel classLabel = new JLabel("Class Attributes");
        setCompBounds(classLabel, 10);
        p.add(classLabel);
        tfClassName = new JTextField();
        setCompBounds(tfClassName, 100);
        p.add(tfClassName);
        btnAddClass = new JButton("add class");
        setCompBounds(btnAddClass, 150);
        p.add(btnAddClass);
        btnRenameClass = new JButton("rename class");
        setCompBounds(btnRenameClass, 200);
        p.add(btnRenameClass);
        btnRemoveClass = new JButton("remove class");
        setCompBounds(btnRemoveClass, 250);
        p.add(btnRemoveClass, null);
        btnChooseColor = new JButton("change color");
        setCompBounds(btnChooseColor, 300);
        p.add(btnChooseColor, null);

        JPanel pan = new JPanel(new GridLayout(2, 1));
        setCompBounds(labIncExclMode, 350);
        pan.add(labIncExclMode);
        setCompBounds(cbIncExclMode, 370);
        pan.add(cbIncExclMode);
        p.add(pan);

        btnOK = new JButton("OK");
        setCompBounds(btnOK, 550);
        btnOK.setBounds(10, 500, (int) btnOK.getBounds().getWidth(), (int) btnOK.getBounds().getHeight());
        JPanel spacer = new JPanel();
        setCompBounds(spacer, 500);
        p.add(spacer);
        p.add(btnOK);

        add(getClassScrollPane());
        add(p);

        addActionListeners();

        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation((size.width - getWidth()) / 2, (size.height - getHeight()) / 2);
    }


    private void setCompBounds(Component comp, int y) {
        comp.setMaximumSize(new Dimension(frameWidth / 4, btnHeight));
        comp.setPreferredSize(new Dimension(frameWidth / 4, btnHeight));
        comp.setMinimumSize(new Dimension(frameWidth / 4, btnHeight));
        //comp.setBounds((frameWidth/3) + 200, y, comp.getWidth(), comp.getHeight());
    }


    private void addActionListeners() {
        ActionListener addAction = new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                DefaultListModel model = (DefaultListModel) classList.getModel();
                ClassShape cs = new ClassShape(tfClassName.getText(), RecognitionFrame.getColorByNum(model.getSize()), ClassShape.SHAPETYPE_POLYGONEXT);
                model.addElement(cs);
                //((DefaultComboBoxModel)boxToUpdate.getModel()).addElement(cs);
                classShapes.add(cs);
                //boxToUpdate.repaint();
            }
        };
        btnAddClass.addActionListener(addAction);

        ActionListener renameAction = new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (tfClassName.getText().length() <= 0) return;
                if (classList.getSelectedValue() == null) return;
                ((ClassShape) classList.getSelectedValue()).setName(tfClassName.getText());
                classList.repaint();
                //boxToUpdate.repaint();
            }
        };
        btnRenameClass.addActionListener(renameAction);

        ActionListener removeAction = new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                DefaultListModel model = (DefaultListModel) classList.getModel();
                if (classList.getSelectedValue() == null) return;
                ClassShape cs = (ClassShape) classList.getSelectedValue();
                model.removeElement(cs);
                //((DefaultComboBoxModel)boxToUpdate.getModel()).removeElement(cs);
                classShapes.remove(cs);
                //boxToUpdate.repaint();
            }
        };
        btnRemoveClass.addActionListener(removeAction);


        ActionListener colorAction = new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (classList.getSelectedValue() == null) return;
                Color oldCol = ((ClassShape) classList.getSelectedValue()).getColor();
                Color c = JColorChooser.showDialog(ClassAdminFrame.this, "Select color", oldCol);
                if (c != null && c.getRGB() != OrbitUtils.UNDEF_COLOR) { // c is null if the colorDialog is closed e.g. with cancel
                    ((ClassShape) classList.getSelectedValue()).setColor(c);
                    classList.repaint();
                }
                if (c != null && c.getRGB() == OrbitUtils.UNDEF_COLOR)
                    log.warn("This special color (black) cannot be used as class color!");
            }
        };
        btnChooseColor.addActionListener(colorAction);

        ActionListener cbIncExclAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (classList.getSelectedValue() == null) return;
                ClassShape cs = ((ClassShape) classList.getSelectedValue());
                String mode = (String) cbIncExclMode.getSelectedItem();
                if (mode.equals(ClassShape.STR_UNDEFINED)) cs.setIncExcMode(ClassShape.UNDEFINED);
                if (mode.equals(ClassShape.STR_Inclusion)) cs.setIncExcMode(ClassShape.INCLUSION);
                if (mode.equals(ClassShape.STR_Exclusion)) cs.setIncExcMode(ClassShape.EXCLUSION);
            }
        };
        cbIncExclMode.addActionListener(cbIncExclAction);


        ActionListener okAction = new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ClassAdminFrame.this.dispose();
                if (firePropertyChangeEvent) {
                    firePropertyChange(CLASSADMIN_DONE, null, classShapes);
                }
            }
        };
        btnOK.addActionListener(okAction);

    }

    /**
     * This method initializes jContentPane
     *
     * @return javax.swing.JPanel
     */
    private JPanel getPanelClassAttributes() {
        if (panelClassAttributes == null) {
            panelClassAttributes = new JPanel();
            //BoxLayout bl = new BoxLayout(getJContentPane(), BoxLayout.Y_AXIS);
            panelClassAttributes.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        }
        return panelClassAttributes;
    }

    /**
     * This method initializes classScrollPane
     *
     * @return javax.swing.JScrollPane
     */
    private JScrollPane getClassScrollPane() {
        if (classScrollPane == null) {
            classScrollPane = new JScrollPane();
            //classScrollPane.setSize(new Dimension(313,frameHeight-30));
            classScrollPane.setViewportView(getClassList());
        }
        return classScrollPane;
    }

    /**
     * This method initializes classList
     *
     * @return javax.swing.JList
     */
    private JList getClassList() {
        if (classList == null) {
            classList = new JList();
        }
        return classList;
    }


}
