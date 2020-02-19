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

import com.actelion.research.orbit.imageAnalysis.components.icons.lightbulb;
import org.pushingpixels.flamingo.api.common.CommandAction;
import org.pushingpixels.flamingo.api.common.RichTooltip;
import org.pushingpixels.flamingo.api.common.model.Command;

import javax.swing.*;

public abstract class AbstractOrbitModule extends JPanel {
    private static final long serialVersionUID = 1L;
    private final Command menuCommand;
    private final CommandAction menuCommandAction;

    public abstract String getName();

    /**
     * Adds all components to the JPanel.
     */
    public abstract void init();

    /**
     * Remove values from the JPanel if the image is closed.
     */
    public abstract void reset();

    public abstract CommandAction menuCommandAction();

    public AbstractOrbitModule() {
        // Must call init before creating the menuCommand.
        init();
        this.menuCommandAction = menuCommandAction();
        this.menuCommand = Command.builder()
                .setText(this.getName())
                .setIconFactory(lightbulb.factory())
                .setAction(getMenuCommandAction())
                .setToggle()
//                .setActionRichTooltip(
//                        RichTooltip.builder()
//                                .setTitle(resourceBundle.getString("Tools.SaveImage.saveFullImage.text"))
//                                .addDescriptionSection(resourceBundle.getString("Tools.SaveImage.saveFullImage.tooltip.actionParagraph1"))
//                                .addDescriptionSection(resourceBundle.getString("Tools.SaveImage.saveFullImage.tooltip.actionParagraph2"))
//                                .build())
                .build();

    }

    public CommandAction getMenuCommandAction() {
        return menuCommandAction;
    }

    public Command getMenuCommand() {
        return menuCommand;
    };
}
