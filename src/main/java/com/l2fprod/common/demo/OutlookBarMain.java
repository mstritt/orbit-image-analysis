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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.ButtonUI;

import com.l2fprod.common.swing.JOutlookBar;
import com.l2fprod.common.swing.PercentLayout;
import com.l2fprod.common.swing.plaf.LookAndFeelAddons;
import com.l2fprod.common.swing.plaf.metal.MetalLookAndFeelAddons;
import com.l2fprod.common.swing.plaf.windows.WindowsLookAndFeelAddons;

/**
 * OutlookBarMain. <br>
 *  
 */
public class OutlookBarMain extends JPanel {

  public OutlookBarMain() throws Exception {
    setLayout(new BorderLayout());

    JTabbedPane tabs = new JTabbedPane();

    { // the metal look and feel
      UIManager
        .setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      LookAndFeelAddons.setAddon(MetalLookAndFeelAddons.class);
      tabs.addTab("Metal L&F", makeOutlookPanel(SwingConstants.CENTER));
    }

    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

    { // the windows look and feel
      LookAndFeelAddons.setAddon(WindowsLookAndFeelAddons.class);
      tabs.addTab("Windows L&F", makeOutlookPanel(SwingConstants.LEFT));
    }

    add("Center", tabs);
  }

  JPanel makeOutlookPanel(int alignment) {
    JOutlookBar outlook = new JOutlookBar();
    outlook.setTabPlacement(JTabbedPane.LEFT);
    addTab(outlook, "Folders");
    addTab(outlook, "Backup");

    // show it is possible to add any component to the bar
    JTree tree = new JTree();
    outlook.addTab("A JTree", outlook.makeScrollPane(tree));

    outlook.addTab("Disabled", new JButton());
    outlook.setEnabledAt(3, false);
    outlook.setAllTabsAlignment(alignment);
    
    JPanel panel = new JPanel(new PercentLayout(PercentLayout.HORIZONTAL, 3));
    panel.add(outlook, "100");
    return panel;
  }

  void addTab(JOutlookBar tabs, String title) {
    JPanel panel = new JPanel();
    panel.setLayout(new PercentLayout(PercentLayout.VERTICAL, 0));
    panel.setOpaque(false);

    String[] buttons = new String[] {"Inbox", "icons/outlook-inbox.gif",
      "Outbox", "icons/outlook-outbox.gif", "Drafts", "icons/outlook-inbox.gif",
      "Templates", "icons/outlook-inbox.gif", "Deleted Items",
      "icons/outlook-trash.gif",};

    for (int i = 0, c = buttons.length; i < c; i += 2) {
      JButton button = new JButton(buttons[i]);
      try {
        button.setUI((ButtonUI)Class.forName(
          (String)UIManager.get("OutlookButtonUI")).newInstance());
      } catch (Exception e) {
        e.printStackTrace();
      }
      button.setIcon(new ImageIcon(OutlookBarMain.class
        .getResource(buttons[i + 1])));
      panel.add(button);
    }

    JScrollPane scroll = tabs.makeScrollPane(panel);
    tabs.addTab("", scroll);

    // this to test the UI gets notified of changes
    int index = tabs.indexOfComponent(scroll);
    tabs.setTitleAt(index, title);
    tabs.setToolTipTextAt(index, title + " Tooltip");
  }

  public static void main(String[] args) throws Exception {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

    JFrame frame = new JFrame("JOutlookBar");
    frame.getContentPane().setLayout(new BorderLayout());
    frame.getContentPane().add("Center", new OutlookBarMain());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setLocation(100, 100);
    frame.setVisible(true);
  }

}