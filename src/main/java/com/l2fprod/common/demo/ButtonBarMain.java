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

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.UIManager;

import com.l2fprod.common.swing.JButtonBar;
import com.l2fprod.common.swing.plaf.blue.BlueishButtonBarUI;
import com.l2fprod.common.swing.plaf.misc.IconPackagerButtonBarUI;
import com.l2fprod.common.util.ResourceManager;

/**
 * Demo of the JButtonBar. <br>
 *  
 */
public class ButtonBarMain extends JPanel {

  static ResourceManager RESOURCE = ResourceManager.get(ButtonBarMain.class);

  public ButtonBarMain() {
    setLayout(new BorderLayout());

    JTabbedPane tabs = new JTabbedPane();
    add("Center", tabs);

    { // with the mozilla L&F
      JButtonBar toolbar = new JButtonBar(JButtonBar.VERTICAL);
      toolbar.setUI(new BlueishButtonBarUI());
      tabs.addTab("Mozilla L&F", new ButtonBarPanel(toolbar));
    }

    { // with the icon packager L&F
      JButtonBar toolbar = new JButtonBar(JButtonBar.VERTICAL);
      toolbar.setUI(new IconPackagerButtonBarUI());
      tabs.addTab("Icon Packager L&F", new ButtonBarPanel(toolbar));
    }
  }

  static class ButtonBarPanel extends JPanel {

    private Component currentComponent;

    public ButtonBarPanel(JButtonBar toolbar) {
      setLayout(new BorderLayout());

      add("West", toolbar);

      ButtonGroup group = new ButtonGroup();

      addButton(RESOURCE.getString("Main.welcome"), "icons/welcome32x32.png",
        makePanel(RESOURCE.getString("Main.welcome")), toolbar, group);

      addButton(RESOURCE.getString("Main.settings"),
        "icons/propertysheet32x32.png", makePanel(RESOURCE
          .getString("Main.settings")),

        toolbar, group);

      addButton(RESOURCE.getString("Main.sounds"), "icons/fonts32x32.png",
        makePanel(RESOURCE.getString("Main.sounds")), toolbar, group);

      addButton(RESOURCE.getString("Main.stats"), "icons/folder32x32.png",
        makePanel(RESOURCE.getString("Main.stats")), toolbar, group);
    }

    private JPanel makePanel(String title) {
      JPanel panel = new JPanel(new BorderLayout());
      JLabel top = new JLabel(title);
      top.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
      top.setFont(top.getFont().deriveFont(Font.BOLD));
      top.setOpaque(true);
      top.setBackground(panel.getBackground().brighter());
      panel.add("North", top);
      panel.setPreferredSize(new Dimension(400, 300));
      panel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
      return panel;
    }

    private void show(Component component) {
      if (currentComponent != null) {
        remove(currentComponent);
      }
      add("Center", currentComponent = component);
      revalidate();
      repaint();
    }

    private void addButton(String title, String iconUrl,
      final Component component, JButtonBar bar, ButtonGroup group) {
      Action action = new AbstractAction(title, new ImageIcon(
        ButtonBarMain.class.getResource(iconUrl))) {
        public void actionPerformed(ActionEvent e) {
          show(component);
        }
      };

      JToggleButton button = new JToggleButton(action);
      bar.add(button);

      group.add(button);

      if (group.getSelection() == null) {
        button.setSelected(true);
        show(component);
      }
    }
  }

  public static void main(String[] args) throws Exception {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

    JFrame frame = new JFrame("ButtonBar");
    frame.getContentPane().setLayout(new BorderLayout());
    frame.getContentPane().add("Center", new ButtonBarMain());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setLocation(100, 100);
    frame.setVisible(true);
  }

}