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

package com.actelion.research.orbit.imageAnalysis.components;


import javax.accessibility.Accessible;
import javax.accessibility.AccessibleContext;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL chooser to let the user choose an URL in the same files are loaded with a JFileChooser.<br>
 * Use the createDialog method to display the dialog. If the return value is the APPROVE_OPTION
 * you can get the selected URL with the getSelectedURL method.<br>
 * Here is a typical pattern how to use this class:<br>
 * <pre>
 * 	   URLChooser urlChooser = new URLChooser();
 * 	   int returnVal = urlChooser.showOpenDialog(this);
 * 	   if (returnVal == URLChooser.APPROVE_OPTION) {
 * 	        URL url = urlChooser.getSelectedURL();
 * 		           System.out.println(url);
 * 				  // do something with the url
 *       } else {
 * 	            System.out.println("open url canceled.");
 *         }
 * </pre>
 *
 * @author stritma1
 * @since 08.04.2010
 */
public class URLChooser extends JComponent implements Accessible {

    private static final long serialVersionUID = 1L;
    public static String URLCHOOSER_DIALOGTYPE_CHANGED = "URLCHOOSER_DIALOGTYPE_CHANGED";
    public static int APPROVE_OPTION = 0;
    public static int CANCEL_OPTION = 1;
    public static int URLCHOOSER_ERROR = 2;
    private boolean multiSelectionEnabled = false;
    private int status = APPROVE_OPTION;
    private JDialog dialog = null;
    public static final int OPEN_DIALOG = 0;
    public static final int SAVE_DIALOG = 1;
    public static final int CUSTOM_DIALOG = 2;
    private int dialogType = OPEN_DIALOG;
    private String title = "URL Chooser";
    private JLabel urlLabel = new JLabel("Please enter a valid URL:");
    private JTextField urlField = null;
    private URL selectedURL = null;

    public URLChooser() {
        //setVisible(false);
        setLayout(new GridBagLayout());

        // urlField
        urlField = new JTextField();

        // Buttons
        JButton okBtn = new JButton("Load");
        okBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    selectedURL = new URL(urlField.getText());
                } catch (MalformedURLException e1) {
                    JOptionPane.showMessageDialog(URLChooser.this, "URL is not valid. Please enter a valid URL\nor press cancel.", "URL is not valid.", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                setStatus(APPROVE_OPTION);
                exitProcedure();
            }
        });
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setStatus(CANCEL_OPTION);
                exitProcedure();
            }
        });
        JPanel btnPanel = new JPanel();
        btnPanel.add(okBtn);
        btnPanel.add(cancelBtn);

        // Layout
        GridBagConstraints gbcURLLabel = new GridBagConstraints();
        gbcURLLabel.weightx = 0.0;
        gbcURLLabel.weighty = 0.0;
        gbcURLLabel.anchor = GridBagConstraints.NORTHWEST;
        gbcURLLabel.fill = GridBagConstraints.NONE;
        gbcURLLabel.gridx = 0;
        gbcURLLabel.gridy = 0;

        GridBagConstraints gbcURLField = new GridBagConstraints();
        gbcURLField.weightx = 1.0;
        gbcURLField.weighty = 0.0;
        gbcURLField.anchor = GridBagConstraints.NORTHWEST;
        gbcURLField.fill = GridBagConstraints.HORIZONTAL;
        gbcURLField.gridx = 0;
        gbcURLField.gridy = 1;

        GridBagConstraints gbcBtn = new GridBagConstraints();
        gbcBtn.weightx = 0.0;
        gbcBtn.weighty = 0.0;
        gbcBtn.anchor = GridBagConstraints.SOUTHEAST;
        gbcBtn.fill = GridBagConstraints.NONE;
        gbcBtn.gridx = 0;
        gbcBtn.gridy = 2;

        add(urlLabel, gbcURLLabel);
        add(urlField, gbcURLField);
        add(btnPanel, gbcBtn);

        setPreferredSize(new Dimension(400, 150));

    }


    public void setDialogType(int dialogType) {
        if (this.dialogType == dialogType) {
            return;
        }
        if (!(dialogType == OPEN_DIALOG || dialogType == SAVE_DIALOG || dialogType == CUSTOM_DIALOG)) {
            throw new IllegalArgumentException("Incorrect Dialog Type: " + dialogType);
        }
        int oldValue = this.dialogType;
        this.dialogType = dialogType;
        if (dialogType == OPEN_DIALOG || dialogType == SAVE_DIALOG) {
          /*  setApproveButtonText(null); */
        }
        firePropertyChange(URLCHOOSER_DIALOGTYPE_CHANGED, oldValue, dialogType);
    }

    public int getDialogType() {
        return dialogType;
    }


    public int showOpenDialog(Component parent) throws HeadlessException {
        setDialogType(OPEN_DIALOG);
        return showDialog(parent, null);
    }

    public int showDialog(Component parent, String approveButtonText) throws HeadlessException {
        dialog = createDialog(parent);
        dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                status = CANCEL_OPTION;
            }
        });
        status = URLCHOOSER_ERROR;
        dialog.setVisible(true);
        firePropertyChange("URLChooserClosingProperty", dialog, null);
        dialog.removeAll();
        dialog.dispose();
        dialog = null;
        return status;
    }


    protected JDialog createDialog(Component parent) throws HeadlessException {
        putClientProperty(AccessibleContext.ACCESSIBLE_DESCRIPTION_PROPERTY,
                title);

        JDialog dialog;

        Component window = parent;
        if (window instanceof Frame) {
            dialog = new JDialog((Frame) window, title, true);
        } else {
            dialog = new JDialog((Dialog) window, title, true);
        }
        dialog.setComponentOrientation(this.getComponentOrientation());

        Container contentPane = dialog.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(this, BorderLayout.CENTER);

        if (JDialog.isDefaultLookAndFeelDecorated()) {
            boolean supportsWindowDecorations =
                    UIManager.getLookAndFeel().getSupportsWindowDecorations();
            if (supportsWindowDecorations) {
                dialog.getRootPane().setWindowDecorationStyle(JRootPane.FILE_CHOOSER_DIALOG);
            }
        }
        dialog.pack();
        dialog.setLocationRelativeTo(parent);

        return dialog;
    }


    private void exitProcedure() {
        dialog.setVisible(false);
    }


    /**
     * returns the first selected file if selectedFiles.size>0 else null.
     *
     * @return
     */
    public URL getSelectedURL() {
        return selectedURL;
    }


    public boolean isMultiSelectionEnabled() {
        return multiSelectionEnabled;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
