/*
 * $Id: TOTDTest.java,v 1.2 2005/07/10 17:26:23 l2fprod Exp $
 *
 * Copyright 2004 Sun Microsystems, Inc., 4150 Network Circle,
 * Santa Clara, California 95054, U.S.A. All rights reserved.
 */
package com.l2fprod.common.demo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.UIManager;

import com.l2fprod.common.swing.JTipOfTheDay;
import com.l2fprod.common.swing.plaf.LookAndFeelAddons;
import com.l2fprod.common.swing.plaf.basic.BasicLookAndFeelAddons;
import com.l2fprod.common.swing.plaf.basic.BasicTipOfTheDayUI;
import com.l2fprod.common.swing.plaf.windows.WindowsLookAndFeelAddons;
import com.l2fprod.common.swing.tips.DefaultTip;
import com.l2fprod.common.swing.tips.DefaultTipModel;

public class TOTDTest extends JPanel {

  public TOTDTest() {
    setLayout(new GridLayout(2, 1));

    try {
      add(makeAction("Windows Look And Feel", UIManager
        .getSystemLookAndFeelClassName(), WindowsLookAndFeelAddons.class
        .getName()));
      add(makeAction("Other Look And Feel", UIManager
        .getCrossPlatformLookAndFeelClassName(), BasicLookAndFeelAddons.class
        .getName())); 
    } catch (Exception e) {
    }    
  }
  
  public static void main(String[] args) throws Exception {
    LookAndFeelAddons.setTrackingLookAndFeelChanges(false);

    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

    JFrame frame = new JFrame("Tip of the Day Testbed");
    frame.getContentPane().add("Center", new TOTDTest());
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  static JButton makeAction(String title, final String lnf, final String addon)
    throws Exception {
    final JTipOfTheDay.ShowOnStartupChoice fake = new JTipOfTheDay.ShowOnStartupChoice() {
      private boolean value = true;

      public boolean isShowingOnStartup() {
        return value;
      }
      public void setShowingOnStartup(boolean showOnStartup) {
        value = showOnStartup;
      }
    };

    ActionListener action = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          UIManager.setLookAndFeel(lnf);
          LookAndFeelAddons.setAddon(addon);
        } catch (Exception ex) {
          // TODO: handle exception
        }

        if (!fake.isShowingOnStartup()) {
          if (JOptionPane.OK_OPTION == JOptionPane
            .showConfirmDialog(
              null,
              "You previously choose to not show tips on startup.\nDo you want to cancel this choice?",
              "Question", JOptionPane.YES_NO_OPTION)) {
            fake.setShowingOnStartup(true);
          }
        }

        DefaultTipModel tips = new DefaultTipModel();

        // plain text
        tips
          .add(new DefaultTip(
            "tip1",
            "This is the first tip This is the first tip This is the first tip This is the first tip This is the first tip This is the first tip\nThis is the first tip This is the first tip"));

        // html text
        tips.add(new DefaultTip("tip2",
          "<html>This is an html <b>TIP</b><br><center>"
            + "<table border=\"1\">" + "<tr><td>1</td><td>entry 1</td></tr>"
            + "<tr><td>2</td><td>entry 2</td></tr>"
            + "<tr><td>3</td><td>entry 3</td></tr>" + "</table>"));

        // a Component
        tips.add(new DefaultTip("tip3", new JTree()));

        // an Icon
        tips.add(new DefaultTip("tip 4", new ImageIcon(BasicTipOfTheDayUI.class
          .getResource("TipOfTheDay24.gif"))));

        JTipOfTheDay totd = new JTipOfTheDay(tips);
        totd.setCurrentTip(0);

        totd.showDialog(new JFrame("title"), fake);
      }
    };

    JButton button = new JButton(title);
    button.addActionListener(action);
    return button;
  }

}
