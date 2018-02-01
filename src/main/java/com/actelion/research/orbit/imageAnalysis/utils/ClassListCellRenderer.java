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

package com.actelion.research.orbit.imageAnalysis.utils;

import com.actelion.research.orbit.imageAnalysis.models.ClassShape;

import javax.swing.*;
import java.awt.*;


public class ClassListCellRenderer extends JLabel implements ListCellRenderer {

    class SquareIcon implements Icon {
        private Color color = Color.white;
        private int iconHeight = 25;
        private int iconWidth = 25;

        public SquareIcon(Color color, int width, int height) {
            this.color = color;
            this.iconHeight = height;
            this.iconWidth = width;
        }

        public void paintIcon(Component c, Graphics g, int x, int y) {
            g.setColor(color);
            g.fillRect(0, 0, getIconWidth(), getIconHeight());
        }

        public int getIconHeight() {
            return iconHeight;
        }

        public void setIconHeight(int iconHeight) {
            this.iconHeight = iconHeight;
        }

        public int getIconWidth() {
            return iconWidth;
        }

        public void setIconWidth(int iconWidth) {
            this.iconWidth = iconWidth;
        }

    }


    private static final long serialVersionUID = 1L;

    public ClassListCellRenderer() {
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList list,
                                                  Object value,
                                                  int index,
                                                  boolean isSelected,
                                                  boolean cellHasFocus) {

        if (!(value instanceof ClassShape))
            throw new IllegalArgumentException("ClassListCellRenderer accepts only ClassShape objects to render.");
        ClassShape cs = (ClassShape) value;
        setText(cs.getName());

 /*
        Image iconImg = new   BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
    	iconImg.getGraphics().setColor(cs.getColor());
    	iconImg.getGraphics().fillRect(0, 0, 10, 10);
    	setIcon(new ImageIcon(iconImg));
   */
        setIcon(new SquareIcon(cs.getColor(), 30, 22));

        Color background = Color.WHITE;
        Color foreground = Color.BLACK;

        // check if this cell represents the current DnD drop location
        boolean drop = false;
        try {
            JList.DropLocation dropLocation = list.getDropLocation();  // >= Java 1.6
            if (dropLocation != null
                    && !dropLocation.isInsert()
                    && dropLocation.getIndex() == index)
                drop = true;
        } catch (Exception e) {
            System.out.println("Warning: MouseWheelListener not supported -> please upgrade to Java >= 1.6!");
        }
        if (drop) {

            background = Color.BLUE;
            foreground = Color.WHITE;

            // check if this cell is selected
        } else if (isSelected) {
            background = Color.LIGHT_GRAY;
            foreground = OrbitUtils.DARKUI ? Color.darkGray : Color.white;
            ;

            // unselected, and not the DnD drop location
        } else {
            boolean odd = index % 2 != 0;
            background = OrbitUtils.DARKUI ? (odd ? Color.darkGray : Color.darkGray.brighter()) : Color.white;
            foreground = OrbitUtils.DARKUI ? Color.lightGray : Color.BLACK;
        }
        ;

        setBackground(background);
        setForeground(foreground);

        return this;
    }


}
