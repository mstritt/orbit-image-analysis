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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import com.l2fprod.common.swing.LookAndFeelTweaks;
import com.l2fprod.common.util.ResourceManager;

/**
 * Demo showing the PropertySheet.<br>
 *
 */
public class PropertySheetMain extends JPanel {

  static ResourceManager RESOURCE = ResourceManager.get(PropertySheetMain.class);

  public PropertySheetMain() {
    setLayout(new BorderLayout());

    JTabbedPane tabs = new JTabbedPane();
    tabs.add("Sheet 1", new PropertySheetPage());
    tabs.add("Sheet 2", new PropertySheetPage2());
    tabs.add("Sheet 3", new PropertySheetPage3());
    
    add("Center", tabs);
  }
  
  public static void main(String[] args) throws Exception {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    LookAndFeelTweaks.tweak();
    
    JFrame frame = new JFrame("PropertySheet");
    frame.getContentPane().setLayout(new BorderLayout());
    frame.getContentPane().add("Center", new PropertySheetMain());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setLocation(100, 100);
    frame.setVisible(true);
  }
  
}
