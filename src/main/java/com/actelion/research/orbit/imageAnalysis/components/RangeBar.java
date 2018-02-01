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

package com.actelion.research.orbit.imageAnalysis.components;

import com.actelion.research.orbit.imageAnalysis.components.legacy.JPruningBar;
import com.actelion.research.orbit.imageAnalysis.components.legacy.PruningBarEvent;
import com.actelion.research.orbit.imageAnalysis.components.legacy.PruningBarListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

public class RangeBar extends JPanel implements PruningBarListener {

    private static final long serialVersionUID = 1L;
    private final static Logger logger = LoggerFactory.getLogger(RangeBar.class);
    private final JPruningBar pruningBar = new JPruningBar(true);
    private final JLabel labMin = new JLabel("");
    private final JLabel labMax = new JLabel("");
    private final String format = "%1$.2f";

    public RangeBar() {
        this(0, 100);
    }

    public RangeBar(double min, double max) {
        pruningBar.addPruningBarListener(this);
        pruningBar.setMinimumValue((float) min);
        pruningBar.setMaximumValue((float) max);
        updateLables();

        // layout
        setLayout(new GridBagLayout());
        add(pruningBar, new GridBagConstraints(0, 0, GridBagConstraints.REMAINDER, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        add(labMin, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        add(labMax, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.NORTHEAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    }

    public void pruningBarChanged(PruningBarEvent e) {
        labMin.setText(String.format(format, e.getLowValue()));
        labMax.setText(String.format(format, e.getHighValue()));
    }

    private void updateLables() {
        labMin.setText(String.format(format, pruningBar.getLowValue()));
        labMax.setText(String.format(format, pruningBar.getHighValue()));
    }

    /**
     * Checks if low or high is set (and not just the minimum / maximum values). This means the user
     * has adjusted something.
     *
     * @return
     */
    public boolean isPruning() {
        return ((Math.abs(getLowValue() - getMinimumValue()) > 0.0001d) || (Math.abs(getHighValue() - getMaximumValue()) > 0.0001d));
    }

    public double getLowValue() {
        return pruningBar.getLowValue();
    }

    public double getHighValue() {
        return pruningBar.getHighValue();
    }

    public void setLowValue(double low) {
        pruningBar.setLowValue((float) low);
    }

    public void setHighValue(double high) {
        pruningBar.setHighValue((float) high);
    }

    public double getMaximumValue() {
        return pruningBar.getMaximumValue();
    }

    public double getMinimumValue() {
        return pruningBar.getMinimumValue();
    }

    public void setMinimumValue(double min) {
        pruningBar.setMinimumValue((float) min);
        updateLables();
    }

    public void setMaximumValue(double max) {
        pruningBar.setMaximumValue((float) max);
        updateLables();
    }

    public void setMinAndMax(double min, double max) {
        pruningBar.setMinAndMax((float) min, (float) max);
        updateLables();
    }
}
