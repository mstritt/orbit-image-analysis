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
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.l2fprod.common.swing.JFontChooser;
import com.l2fprod.common.swing.PercentLayout;

/**
 * A simple example showing how to use the JFontChooser.
 */
public class ChooseFont extends JPanel {

  public ChooseFont() {
    setLayout(new PercentLayout(PercentLayout.VERTICAL, 3));

    JFontChooser chooser = new JFontChooser();
    chooser.setSelectedFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 56));
    add("*", chooser);

    JButton button = new JButton("Click here to show JFontChooser");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        selectFont(ChooseFont.this);
      }
    });
    add(button);
  }

  private static void selectFont(Component parent) {
    Font selectedFont = JFontChooser.showDialog(parent, "Choose Font", null);
    if (selectedFont == null) {
      JOptionPane.showMessageDialog(parent, "You clicked 'Cancel'");
    } else {
      JOptionPane.showMessageDialog(parent, "You selected '"
        + selectedFont.getName() + "'");
    }
  }

  public static void main(String[] args) throws Exception {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    selectFont(null);
    System.exit(0);
  }

}