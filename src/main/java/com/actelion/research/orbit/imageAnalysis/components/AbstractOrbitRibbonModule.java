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
import java.util.Locale;
import java.util.ResourceBundle;

public abstract class AbstractOrbitRibbonModule extends AbstractOrbitModule {
    private static final long serialVersionUID = 1L;

    private final ResourceBundle resourceBundle;

    private final Command menuCommand;
    private final CommandAction menuCommandAction;

    /**
     * The module name, used in the menu item name.
     * @return module name
     */
    public abstract String getName();

    /**
     * The name used in the resources file. Must not
     * contain spaces.
     * @return module resource name
     */
    private String getResourceName() {
        return getName().replace(" ", "");
    }

    /**
     * Adds all components to the JPanel.
     */
    public abstract void init();

    /**
     * Remove values from the JPanel if the image is closed.
     */
    public abstract void reset();

    private CommandAction menuCommandAction() { return e -> addToMetaBar(); };

    private RichTooltip getTooltip() {
        return RichTooltip.builder()
                .setTitle(resourceBundle.getString("Tools.Extensions."+getResourceName()+".text"))
                .addDescriptionSection(resourceBundle.getString("Tools.Extensions."+getResourceName()+".tooltip.actionParagraph1"))
                .build();
    }

    void addToMetaBar() {
        if (this.getMenuCommand().isToggleSelected()) {
            OrbitImageAnalysis.getInstance().getMetaBar().addOrbitModule(this);
        } else {
            OrbitImageAnalysis.getInstance().getMetaBar().removeOrbitModule(this);
        }
    }

    public AbstractOrbitRibbonModule() {
        // Must call init before creating the menuCommand.
        init();
        Locale currLocale = Locale.getDefault();
        resourceBundle = ResourceBundle.getBundle("Resources", currLocale);

        this.menuCommandAction = menuCommandAction();

        // Build the command used by the ribbon.
        this.menuCommand = Command.builder()
                .setText(this.getName())
                .setIconFactory(lightbulb.factory())
                .setAction(getMenuCommandAction())
                .setToggle()
                .setActionRichTooltip(getTooltip())
                .build();
    }

    CommandAction getMenuCommandAction() {
        return menuCommandAction;
    }

    Command getMenuCommand() {
        return menuCommand;
    };
}
