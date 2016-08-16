/**
 * $ $ License.
 *
 * Copyright $ L2FProd.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.l2fprod.common.demo;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import com.l2fprod.common.swing.JDirectoryChooser;
import com.l2fprod.common.swing.LookAndFeelTweaks;
import com.l2fprod.common.swing.PercentLayout;
import com.l2fprod.common.util.ResourceManager;

/**
 * A simple example showing how to use the JDirectoryChooser.
 */
public class ChooseDirectory extends JPanel {

  public final static ResourceManager RESOURCE = ResourceManager
    .get(ChooseDirectory.class);

  public ChooseDirectory() {
    setLayout(new PercentLayout(PercentLayout.VERTICAL, 3));

    if (System.getProperty("javawebstart.version") != null) {   
      JTextArea area = new JTextArea(RESOURCE.getString("message.webstart"));
      LookAndFeelTweaks.makeMultilineLabel(area);
      add(area);
    }

    final JButton button = new JButton(RESOURCE.getString("selectDirectory"));
    add(button);
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        selectDirectory(button, null);
      }
    });
  }

  static void selectDirectory(Component parent, String selectedFile) {
    JDirectoryChooser chooser;

    if (System.getProperty("javawebstart.version") != null) {
      chooser = new JDirectoryChooser(new FakeFileSystemView()) {
        public void rescanCurrentDirectory() {
        }
        public void setCurrentDirectory(File dir) {
        }
      };
    } else {
      chooser = new JDirectoryChooser();
      if (selectedFile != null) {
        chooser.setSelectedFile(new File(selectedFile));
      }
    }
    
    JTextArea accessory = new JTextArea(RESOURCE
      .getString("selectDirectory.message"));
    accessory.setLineWrap(true);
    accessory.setWrapStyleWord(true);
    accessory.setEditable(false);
    accessory.setOpaque(false);
    accessory.setFont(UIManager.getFont("Tree.font"));
    chooser.setAccessory(accessory);

    chooser.setMultiSelectionEnabled(true);

    int choice = chooser.showOpenDialog(parent);
    if (choice == JDirectoryChooser.APPROVE_OPTION) {
      String filenames = "";
      File[] selectedFiles = chooser.getSelectedFiles();
      for (int i = 0, c = selectedFiles.length; i < c; i++) {
        filenames += "\n" + selectedFiles[i];
      }
      JOptionPane.showMessageDialog(parent, RESOURCE.getString(
        "selectDirectory.confirm", new Object[] {filenames}));
    } else {
      JOptionPane.showMessageDialog(parent, RESOURCE
        .getString("selectDirectory.cancel"));
    }
  }

  public static void main(String[] args) throws Exception {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

    if (args.length > 0) {
      selectDirectory(null, args[0]);
    } else {
      selectDirectory(null, null);
    }

    System.exit(0);
  }

}