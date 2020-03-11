package com.actelion.research.orbit.imageAnalysis.components;

import com.actelion.research.orbit.imageAnalysis.models.ClassShape;
import org.pushingpixels.flamingo.api.common.projection.Projection;
import org.pushingpixels.flamingo.api.ribbon.synapse.JRibbonComboBox;
import org.pushingpixels.flamingo.api.ribbon.synapse.model.ComponentPresentationModel;
import org.pushingpixels.flamingo.api.ribbon.synapse.model.RibbonComboBoxContentModel;
import org.pushingpixels.flamingo.api.ribbon.synapse.projection.ComponentProjection;

public class RibbonClassComboBoxProjection extends ComponentProjection<JRibbonComboBox<ClassShape>,
        RibbonComboBoxContentModel<ClassShape>> {

    private static ComponentSupplier<JRibbonComboBox<ClassShape>,
            RibbonComboBoxContentModel<ClassShape>, ComponentPresentationModel> DEFAULT_SUPPLIER =
            (Projection<JRibbonComboBox<ClassShape>, RibbonComboBoxContentModel<ClassShape>,
                    ComponentPresentationModel> projection) -> JRibbonComboBox::new;

    public RibbonClassComboBoxProjection(RibbonComboBoxContentModel<ClassShape> contentModel,
                                         ComponentPresentationModel presentationModel) {
        super(contentModel, presentationModel, DEFAULT_SUPPLIER);

    }

    @Override
    protected void configureComponent(JRibbonComboBox<ClassShape> component) {
        // This sets the renderer when in a Ribbon element.
        component.setRenderer(new ClassComboBox.ClassComboBoxRenderer<ClassShape>(component));
    }

}
