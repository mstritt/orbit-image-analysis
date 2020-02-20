package com.actelion.research.orbit.imageAnalysis.components;

import com.actelion.research.orbit.imageAnalysis.components.icons.lightbulb;
import org.pushingpixels.flamingo.api.common.CommandAction;
import org.pushingpixels.flamingo.api.common.RichTooltip;
import org.pushingpixels.flamingo.api.common.model.Command;

public abstract class AbstractOrbitAction {

    private final Command actionButton;
    private final CommandAction actionCommandAction;

    protected abstract String getName();

    protected abstract String getTooltipTitle();
    protected abstract String getTooltipDescription();

    protected abstract void action();

    private CommandAction menuCommandAction() {
        return e-> action();
    }

    RichTooltip getTooltip() {
        return RichTooltip.builder()
                .setTitle(getTooltipTitle())
                .addDescriptionSection(getTooltipDescription())
                .build();
    }

    public AbstractOrbitAction() {
        // Must call init before creating the menuCommand.
        this.actionCommandAction = menuCommandAction();

        // Build the command used by the ribbon.
        this.actionButton = Command.builder()
                .setText(getName())
                .setIconFactory(lightbulb.factory())
                .setAction(getMenuCommandAction())
                .setActionRichTooltip(getTooltip())
                .build();
    }

    protected Command getMenuCommand() {
        return actionButton;
    }

    protected CommandAction getMenuCommandAction() {
        return actionCommandAction;
    }

}
