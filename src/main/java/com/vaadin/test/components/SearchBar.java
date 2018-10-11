package com.vaadin.test.components;

import com.vaadin.test.layouts.TemplateLayout;
import com.vaadin.test.utils.ButtonUtils;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import lombok.Getter;

import static com.vaadin.test.constants.SearchBarConstants.*;

/**
 *
 *
 * @author JMoy
 */
public class SearchBar extends TemplateLayout {

    /**
     * Generated Serial Version UID.
     */
    private static final long serialVersionUID = 3788124894193759998L;

    /**
     *
     */
    @Getter
    private final TextField searchField;

    /**
     *
     */
    @Getter
    private final Button searchButton;

    /**
     * Constructor.
     */
    public SearchBar() {
        super(TEMPLATE_PATH);

        addStyleName(SEARCH_BAR);

        searchField = new TextField();
        searchField.setWidth("100%");

        searchButton = ButtonUtils.red("Search");

        addComponent(searchField, FIELD_LOCATION);
        addComponent(searchButton, BUTTON_LOCATION);
    }
    /**
     * Constructor.
     *
     * @param placeholder the text to set as the placeholder in the search bar.
     */
    public SearchBar(final String placeholder) {
        this();
        searchField.setPlaceholder(placeholder);
    }
}
