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

import com.actelion.research.orbit.utils.RawUtilsCommon;

import javax.swing.*;
import java.awt.*;

public class SliderColorTest extends JFrame {


    public SliderColorTest()  {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                try {
                    UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceGraphiteGlassLookAndFeel");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                JSlider slider = new JSliderOrbit(0,100,30);
               // slider.setUI(new JSliderOrbit.MySubstanceSliderUI(slider));

                add(slider);
                pack();
                RawUtilsCommon.centerComponent(SliderColorTest.this);
            }
        });
    }

    public static void main(String[] args) {
        SliderColorTest sliderTest = new SliderColorTest();
        sliderTest.setVisible(true);
    }


}
