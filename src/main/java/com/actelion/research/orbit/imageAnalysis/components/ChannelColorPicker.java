/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
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

import javax.swing.*;
import java.awt.*;

public class ChannelColorPicker extends JComponent {

    private Color color;

    public ChannelColorPicker(Color color) {
        this.color = color;
        int w = 12;
        int h = 12;
        setSize(w,h);
        setPreferredSize(new Dimension(w,h));
        setMinimumSize(new Dimension(w,h));
        setMaximumSize(new Dimension(w,h));

        
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillRect(0,0,getWidth(),getHeight());
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
