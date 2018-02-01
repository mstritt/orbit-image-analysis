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

import org.pushingpixels.substance.internal.animation.StateTransitionTracker;
import org.pushingpixels.substance.internal.animation.TransitionAwareUI;
import org.pushingpixels.substance.internal.ui.SubstanceSliderUI;

import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.RescaleOp;

public class JSliderOrbit extends JSlider {

    public JSliderOrbit() {
        super();
        setUI(new MySubstanceSliderUI(this));
    }

    public JSliderOrbit(int orientation) {
        super(orientation);
        setUI(new MySubstanceSliderUI(this));
    }

    public JSliderOrbit(int min, int max) {
        super(min, max);
        setUI(new MySubstanceSliderUI(this));
    }

    public JSliderOrbit(int min, int max, int value) {
        super(min, max, value);
        setUI(new MySubstanceSliderUI(this));
    }

    public JSliderOrbit(int orientation, int min, int max, int value) {
        super(orientation, min, max, value);
        setUI(new MySubstanceSliderUI(this));
    }

    public JSliderOrbit(BoundedRangeModel brm) {
        super(brm);
        setUI(new MySubstanceSliderUI(this));
    }

    public static class MySubstanceSliderUI extends SubstanceSliderUI {

        public MySubstanceSliderUI (JSlider slider)
        {
            super(slider);
        }

        @Override
        protected Icon getIcon ()
        {
            // TODO Use that to get the state (-> highlight or not)
            TransitionAwareUI transitionAwareUI = (TransitionAwareUI) slider.getUI();
            StateTransitionTracker stateTransitionTracker = transitionAwareUI.getTransitionTracker();
            // stateTransitionTracker.getModelStateInfo().getCurrModelState();

            final Icon icon = super.getIcon();
            final BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
            final Graphics iconGraphics = image.createGraphics();
            icon.paintIcon(slider, iconGraphics, 0, 0);
            // Make it brighter (very simple approach)
            final RescaleOp rescaleOp = new RescaleOp(2.0f, 50, null);
            rescaleOp.filter(image, image);

            ColorConvertOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
            op.filter(image, image);

            return new ImageIcon(image);
        }

    }

}
