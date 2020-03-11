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

import com.actelion.research.orbit.imageAnalysis.models.ClassShape;
import com.actelion.research.orbit.imageAnalysis.utils.ClassListCellRenderer;
import org.pushingpixels.flamingo.api.common.icon.ColorResizableIcon;
import org.pushingpixels.flamingo.api.common.projection.Projection;
import org.pushingpixels.flamingo.api.ribbon.synapse.JRibbonComboBox;
import org.pushingpixels.flamingo.api.ribbon.synapse.model.ComponentPresentationModel;
import org.pushingpixels.flamingo.api.ribbon.synapse.model.RibbonComboBoxContentModel;
import org.pushingpixels.flamingo.api.ribbon.synapse.model.RibbonDefaultComboBoxContentModel;
import org.pushingpixels.flamingo.api.ribbon.synapse.projection.ComponentProjection;
import org.pushingpixels.substance.api.renderer.SubstancePanelListCellRenderer;

import javax.swing.*;
import java.util.List;

public class ClassComboBox extends JComboBox<ClassShape> {

    public ClassComboBox(RibbonDefaultComboBoxContentModel<ClassShape> ccbModel) {
        super(ccbModel);

        // This sets the renderer when MegaComboBox is in a non-ribbon element.
        this.setRenderer(new ClassComboBoxRenderer<ClassShape>());

    }

    public static class ClassComboBoxRenderer<C> extends SubstancePanelListCellRenderer<ClassShape> {
        private JLabel nameLabel;

        public ClassComboBoxRenderer() {
            this.nameLabel = new JLabel();

            this.registerThemeAwareLabelsWithText(this.nameLabel);

            this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            this.add(this.nameLabel);

            this.setOpaque(false);
        }


        public ClassComboBoxRenderer(JRibbonComboBox<ClassShape> component) {
            this();
        }

        @Override
        protected void bindData(JList<? extends ClassShape> list, ClassShape value, int index) {
            this.nameLabel.setText(value.getName());
            ColorResizableIcon.Factory icf = ColorResizableIcon.factory(value.getColor());
            this.nameLabel.setIcon(icf.createNewIcon());
        }

        @Override
        protected void onPreRender(JList<? extends ClassShape> list,
                                   ClassShape value, int index) {
            // Register the matching icon factory here without setting the actual icon. The
            // icon will be created and colorized by Substance runtime based on the highlight
            // state of the specific row at render time

            // Tried to set iconfactory here, but it doesn't respect the icon
            // color. Can be ignored since the current solution is ok.
        }

    }


}
