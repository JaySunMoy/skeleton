package com.vaadin.test.layouts;

import com.vaadin.ui.CustomLayout;

public class TemplateLayout extends CustomLayout {

    protected TemplateLayout(final String templatePath) {
        super(templatePath);
        config();
    }

    private void config() {
        addStyleName("template-layout");
    }
}
