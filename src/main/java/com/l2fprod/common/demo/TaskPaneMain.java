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
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import com.l2fprod.common.swing.JTaskPane;
import com.l2fprod.common.swing.JTaskPaneGroup;
import com.l2fprod.common.swing.LookAndFeelTweaks;
import com.l2fprod.common.swing.plaf.LookAndFeelAddons;
import com.l2fprod.common.swing.plaf.aqua.AquaLookAndFeelAddons;
import com.l2fprod.common.swing.plaf.metal.MetalLookAndFeelAddons;
import com.l2fprod.common.swing.plaf.windows.WindowsClassicLookAndFeelAddons;
import com.l2fprod.common.swing.plaf.windows.WindowsLookAndFeelAddons;
import com.l2fprod.common.util.ResourceManager;

/**
 * A simple demo showing the TaskPane and TaskGroup. <br>
 *  
 */
public class TaskPaneMain extends JPanel {

  static ResourceManager RESOURCE = ResourceManager.get(TaskPaneMain.class);

  public TaskPaneMain() throws Exception {
    setLayout(new BorderLayout());

    JTabbedPane tabs = new JTabbedPane();

    { // the metal look and feel
      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      LookAndFeelAddons.setAddon(MetalLookAndFeelAddons.class);
      DemoPanel demo = new DemoPanel();
      tabs.addTab("Metal L&F", demo);
    }

    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

    { // the windows look and feel "Luna" style
      UIManager.put("win.xpstyle.name", "luna");
      LookAndFeelAddons.setAddon(WindowsLookAndFeelAddons.class);      
      DemoPanel demo = new DemoPanel();
      tabs.addTab("Windows L&F (Luna)", demo);
    }

    { // the windows look and feel "Homestead" style
      UIManager.put("win.xpstyle.name", "homestead");
      LookAndFeelAddons.setAddon(WindowsLookAndFeelAddons.class);      
      DemoPanel demo = new DemoPanel();
      tabs.addTab("Windows L&F (Homestead)", demo);
    }

    { // the windows look and feel "Metallic" style
      UIManager.put("win.xpstyle.name", "metallic");
      LookAndFeelAddons.setAddon(WindowsLookAndFeelAddons.class);      
      DemoPanel demo = new DemoPanel();
      tabs.addTab("Windows L&F (Metallic)", demo);
    }

    UIManager.put("win.xpstyle.name", null);

    { // the windows classic look and feel
      LookAndFeelAddons.setAddon(WindowsClassicLookAndFeelAddons.class);
      DemoPanel demo = new DemoPanel();
      tabs.addTab("Windows L&F (Classic)", demo);
    }

    { // the glossy look
      LookAndFeelAddons.setAddon(AquaLookAndFeelAddons.class);
      DemoPanel demo = new DemoPanel();
      tabs.addTab("Glossy", demo);      
    }
    
    { // the jgoodies look
      try {
        Class.forName("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
        UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
        LookAndFeelAddons.setAddon(LookAndFeelAddons.getBestMatchAddonClassName());
        DemoPanel demo = new DemoPanel();
        tabs.addTab("JGoodies Plastic3D", demo);            
      } catch (Exception e) { }
    }

    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

    add("Center", tabs);
  }

  static class DemoPanel extends JTaskPane {

    public DemoPanel() {
      JTaskPane taskPane = new JTaskPane();

      // "System" GROUP
      JTaskPaneGroup systemGroup = new JTaskPaneGroup();
      systemGroup.setTitle(RESOURCE.getString("Main.tasks.systemGroup"));
      systemGroup.setToolTipText(RESOURCE
        .getString("Main.tasks.systemGroup.tooltip"));
      systemGroup.setSpecial(true);
      systemGroup.setIcon(new ImageIcon(TaskPaneMain.class
        .getResource("icons/tasks-email.png")));

      systemGroup.add(makeAction(RESOURCE.getString("Main.tasks.email"), "",
        "icons/tasks-email.png"));
      systemGroup.add(makeAction(RESOURCE.getString("Main.tasks.delete"), "",
        "icons/tasks-recycle.png"));

      taskPane.add(systemGroup);

      // "Office" GROUP
      JTaskPaneGroup officeGroup = new JTaskPaneGroup();
      officeGroup.setTitle(RESOURCE.getString("Main.tasks.office"));
      officeGroup.add(makeAction(RESOURCE.getString("Main.tasks.word"), "",
        "icons/tasks-writedoc.png"));
      officeGroup.setExpanded(false);
      officeGroup.setScrollOnExpand(true);

      taskPane.add(officeGroup);

      // "SEE ALSO" GROUP and ACTIONS
      JTaskPaneGroup seeAlsoGroup = new JTaskPaneGroup();
      seeAlsoGroup.setTitle(RESOURCE.getString("Main.tasks.seealso"));

      seeAlsoGroup.add(makeAction("The Internet", RESOURCE
        .getString("Main.tasks.internet.tooltip"), "icons/tasks-internet.png"));

      seeAlsoGroup.add(makeAction(RESOURCE.getString("Main.tasks.help"),
        RESOURCE.getString("Main.tasks.help.tooltip"),
        "icons/tasks-question.png"));

      taskPane.add(seeAlsoGroup);

      // "Details" GROUP
      JTaskPaneGroup detailsGroup = new JTaskPaneGroup();
      detailsGroup.setTitle(RESOURCE.getString("Main.tasks.details"));
      detailsGroup.setScrollOnExpand(true);

      JEditorPane detailsText = new JEditorPane("text/html", "<html>");
      LookAndFeelTweaks.makeMultilineLabel(detailsText);
      LookAndFeelTweaks.htmlize(detailsText);
      detailsText.setText(RESOURCE.getString("Main.tasks.details.message"));
      detailsGroup.add(detailsText);

      taskPane.add(detailsGroup);

      JScrollPane scroll = new JScrollPane(taskPane);
      scroll.setBorder(null);

      setLayout(new BorderLayout());
      add("Center", scroll);
      
      setBorder(null);
    }

    Action makeAction(String title, String tooltiptext, String iconPath) {
      Action action = new AbstractAction(title) {
        public void actionPerformed(ActionEvent e) {}
      };
      action.putValue(Action.SMALL_ICON, new ImageIcon(TaskPaneMain.class
        .getResource(iconPath)));
      action.putValue(Action.SHORT_DESCRIPTION, tooltiptext);
      return action;
    }
  }

  public static void main(String[] args) throws Exception {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

    JFrame frame = new JFrame("JTaskPane / JTaskPaneGroup");
    frame.getContentPane().setLayout(new BorderLayout());
    frame.getContentPane().add("Center", new TaskPaneMain());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setLocation(100, 100);
    frame.setVisible(true);
  }

}