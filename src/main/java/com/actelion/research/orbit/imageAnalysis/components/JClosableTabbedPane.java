/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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

// originally from peter-swing @see{https://github.com/mcheung63/peter-swing/blob/master/src/main/java/com/peterswing/advancedswing/jclosabletabbedpane/JClosableTabbedPane.java}

package com.actelion.research.orbit.imageAnalysis.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.HashMap;


public class JClosableTabbedPane extends JTabbedPane implements MouseListener {
    private double scaleRatio = 0.7;
    ImageIcon closeIcon = new ImageIcon(JClosableTabbedPane.class.getResource("/resource/closeIcon.gif"));

    private HashMap<String, Component> maps = new HashMap<String, Component>();

    private JComponent maximumParent;
    private boolean isMaximized;

    Component[] components;
    JComponent originalGlassPane;
    JClosableTabbedPane originalClosableTabbedPane;
    int originalSelectedIndex;

    public JClosableTabbedPane() {
        this(false);
    }

    public JClosableTabbedPane(boolean isMaximized) {
        super();
        this.isMaximized = isMaximized;
        addMouseListener(this);
    }

    public JClosableTabbedPane(JComponent maximumParent) {
        this(false);
        this.maximumParent = maximumParent;
    }

    public int getOriginalSelectedIndex() {
        return originalSelectedIndex;
    }

    public void setOriginalSelectedIndex(int originalSlectedIndex) {
        this.originalSelectedIndex = originalSlectedIndex;
    }

    public JClosableTabbedPane getOriginalClosableTabbedPane() {
        return originalClosableTabbedPane;
    }

    public void setOriginalClosableTabbedPane(JClosableTabbedPane originalClosableTabbedPane) {
        this.originalClosableTabbedPane = originalClosableTabbedPane;
    }

    public boolean isMaximized() {
        return isMaximized;
    }

    public void setMaximized(boolean isMaximized) {
        this.isMaximized = isMaximized;
    }

    public JComponent getOriginalGlassPane() {
        return originalGlassPane;
    }

    public void setOriginalGlassPane(JComponent originalGlassPane) {
        this.originalGlassPane = originalGlassPane;
    }

    public JComponent getMaximumParent() {
        return maximumParent;
    }

    public void setMaximumParent(JComponent maximumParent) {
        this.maximumParent = maximumParent;
    }

    public void addTab(String title, Component component) {
        this.addTab(title, component, closeIcon);
    }

    public void addTab(String title, Component component, Icon extraIcon) {
        super.addTab(title, new CloseTabIcon(extraIcon), component);
    }

    public void insertTab(String title, Icon icon, Component component, String tooltip, int index) {
        tooltip = "tab" + component.hashCode();
        maps.put(tooltip, component);
        super.insertTab(title, icon, component, tooltip, index);
    }

    public void removeTabAt(int index) {
        Component component = getComponentAt(index);
        maps.remove("tab" + component.hashCode());
        super.removeTabAt(index);
    }

    public JToolTip createToolTip() {
        ImageToolTip tooltip = new ImageToolTip();
        tooltip.setComponent(this);
        return tooltip;
    }

    class ImageToolTip extends JToolTip {
        public Dimension getPreferredSize() {
            String tip = getTipText();
            Component component = maps.get(tip);
            if (component != null) {
                return new Dimension((int) (getScaleRatio() * component.getWidth()), (int) (getScaleRatio() * component.getHeight()));
            } else {
                return super.getPreferredSize();
            }
        }

        public void paintComponent(Graphics g) {
            String tip = getTipText();
            Component component = maps.get(tip);
            if (component instanceof JComponent) {
                JComponent jcomponent = (JComponent) component;
                Graphics2D g2d = (Graphics2D) g;
                AffineTransform at = g2d.getTransform();
                g2d.transform(AffineTransform.getScaleInstance(getScaleRatio(), getScaleRatio()));
                ArrayList<JComponent> dbcomponents = new ArrayList<JComponent>();
                updateDoubleBuffered(jcomponent, dbcomponents);
                jcomponent.paint(g);
                resetDoubleBuffered(dbcomponents);
                g2d.setTransform(at);
            }
        }

        private void updateDoubleBuffered(JComponent component, ArrayList<JComponent> dbcomponents) {
            if (component.isDoubleBuffered()) {
                dbcomponents.add(component);
                component.setDoubleBuffered(false);
            }
            for (int i = 0; i < component.getComponentCount(); i++) {
                Component c = component.getComponent(i);
                if (c instanceof JComponent) {
                    updateDoubleBuffered((JComponent) c, dbcomponents);
                }
            }
        }

        private void resetDoubleBuffered(ArrayList<JComponent> dbcomponents) {
            for (JComponent component : dbcomponents) {
                component.setDoubleBuffered(true);
            }
        }
    }

    public double getScaleRatio() {
        return scaleRatio;
    }

    public void setScaleRatio(double scaleRatio) {
        this.scaleRatio = scaleRatio;
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            if (maximumParent != null) {
                Component obj = this.getParent();
                while (obj != null) {
                    if (obj instanceof JFrame) {
                        if (!isMaximized) {
                            originalGlassPane = (JComponent) ((JFrame) obj).getGlassPane();
                            JClosableTabbedPane t = new JClosableTabbedPane(true);
                            t.setMaximumParent(maximumParent);
                            t.setOriginalGlassPane(originalGlassPane);
                            int tempSelectedIndex = this.getSelectedIndex();
                            t.setOriginalSelectedIndex(this.getSelectedIndex());
                            t.setOriginalClosableTabbedPane(this);
                            Component components[] = new Component[this.getTabCount()];
                            String componentsName[] = new String[this.getTabCount()];
                            for (int x = 0; x < this.getTabCount(); x++) {
                                components[x] = this.getComponentAt(x);
                                componentsName[x] = this.getTitleAt(x);
                            }
                            for (int x = 0; x < components.length; x++) {
                                t.addTab(componentsName[x], components[x]);
                            }
                            t.setSelectedIndex(tempSelectedIndex);
                            JPanel p = new JPanel();
                            p.setLayout(new BorderLayout());
                            p.add(t, BorderLayout.CENTER);
                            t.setBorder(new EmptyBorder(40, 40, 40, 40));
                            p.setOpaque(false);
                            // p.setBackground(Color.white);
                            ((JFrame) obj).setGlassPane(p);
                            p.setVisible(true);

                            isMaximized = true;
                            return;
                        } else {
                            JClosableTabbedPane t = (JClosableTabbedPane) ((JPanel) ((JFrame) obj).getGlassPane()).getComponent(0);
                            t.setMaximumParent(maximumParent);
                            t.setOriginalGlassPane(originalGlassPane);
                            t.getOriginalClosableTabbedPane().setMaximized(false);

                            Component components[] = new Component[this.getTabCount()];
                            String componentsName[] = new String[this.getTabCount()];

                            for (int x = 0; x < this.getTabCount(); x++) {
                                components[x] = this.getComponentAt(x);
                                componentsName[x] = this.getTitleAt(x);
                            }
                            for (int x = 0; x < components.length; x++) {
                                t.getOriginalClosableTabbedPane().addTab(componentsName[x], components[x]);
                            }
                            t.getOriginalClosableTabbedPane().setSelectedIndex(t.getOriginalSelectedIndex());

                            ((JFrame) obj).setGlassPane(originalGlassPane);
                            originalGlassPane.setVisible(false);
                            isMaximized = false;
                            return;
                        }
                    }
                    obj = obj.getParent();

                }

            }
        } else {
            int tabNumber = getUI().tabForCoordinate(this, e.getX(), e.getY());
            if (tabNumber < 0) {
                return;
            }
            if (getIconAt(tabNumber) != null) {
                Rectangle rect = ((CloseTabIcon) getIconAt(tabNumber)).getBounds();
                if (rect.contains(e.getX(), e.getY())) {

                    // Orbit specific: stop execution thread start
                    if (tabNumber < getComponents().length) {
                        Component comp = getComponents()[tabNumber];
                        if (comp instanceof ScriptEditor.ThreadPane) {
                            ScriptEditor.ThreadPane threadPane = (ScriptEditor.ThreadPane) comp;
                            if (threadPane != null) {
                                try {
                                    threadPane.getThread().stop();
                                } catch (Exception e1) {
                                    e1.printStackTrace();
                                }
                            }
                        }
                    }
                    // Orbit specific: stop execution thread end
                    this.removeTabAt(tabNumber);
                }
            }
        }
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }
}