package com.vaadin.test.layouts;

public class CardLayout extends TemplateLayout {

    /**
     * Constant value that represents the CSS class applied to this Layout.
     */
    private static final String CARD_LAYOUT = "card-layout";

    protected CardLayout(final String templatePath) {
        super(templatePath);
        config();
    }

    private void config() {
        addStyleName(CARD_LAYOUT);
    }
}
