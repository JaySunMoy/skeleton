package com.vaadin.test.utils;

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

import static com.vaadin.test.constants.ComponentConstants.NO_MARGIN;
import static com.vaadin.test.constants.LayoutUtilsConstants.CSS_BLOCK;

/**
 * Class to be accessed statically that returns Layouts with common styling / configurations already applied.
 *
 * @author JMoy
 */
public final class LayoutUtils {

    /**
     * Private constructor to stop instantiation.
     */
    private LayoutUtils() {}

    /**
     * Returns a {@link VerticalLayout} with the passed in {@link Component}(s) added to it. Margin is set to false on
     * the {@link VerticalLayout}.
     *
     * @param components the {@link Component}(s) you want to add to the {@link VerticalLayout};
     * @return the {@link VerticalLayout};
     */
    public static VerticalLayout verticalNoMargin(final Component... components) {
        final VerticalLayout layout = new VerticalLayout(components);
        layout.setMargin(NO_MARGIN);
        return layout;
    }

    /**
     * Returns a {@link VerticalLayout} with the passed in {@link Component}(s) added to it. Margin is to false on the
     * {@link VerticalLayout}.
     *
     * @param components the {@link Component}(s) you want to add to the {@link VerticalLayout};
     * @return the {@link VerticalLayout};
     */
    public static VerticalLayout verticalNoMargin(final String style, final Component... components) {
        final VerticalLayout layout = verticalNoMargin(components);
        layout.addStyleName(style);
        return layout;
    }

    /**
     * Returns a {@link HorizontalLayout} with the passed in {@link Component}(s) added to it. Margin is set to false on
     * the
     * {@link HorizontalLayout}.
     *
     * @param components the {@link Component}(s) you want to add to the {@link HorizontalLayout};
     * @return the {@link HorizontalLayout};
     */
    public static HorizontalLayout horizontalNoMargin(final Component... components) {
        final HorizontalLayout layout = new HorizontalLayout(components);
        layout.setMargin(NO_MARGIN);
        return layout;
    }

    /**
     * Returns a {@link CssLayout} with the passed in {@link Component}(s) added to it. There is CSS styling applied
     * the {@link CssLayout} that sets the display to block.
     *
     * @param components the {@link Component}(s) you want to add to the {@link CssLayout};
     * @return the {@link CssLayout};
     */
    public static CssLayout cssBlock(final Component... components) {
        final CssLayout layout = new CssLayout(components);
        layout.addStyleName(CSS_BLOCK);
        return layout;
    }

    /**
     * Returns a {@link CssLayout} with the passed in {@link Component}(s) added to it. There is CSS styling applied
     * the {@link CssLayout} that sets the display to block and the passed in styling is also added.
     *
     * @param style the CSS class you want to add to the {@link CssLayout}.
     * @param components the {@link Component}(s) you want to add to the {@link CssLayout};
     * @return the {@link CssLayout};
     */
    public static CssLayout cssBlock(final String style, final Component... components) {
        final CssLayout layout = new CssLayout(components);
        layout.addStyleNames(CSS_BLOCK, style);
        return layout;
    }

    /**
     * Returns a {@link VerticalLayout} with the passed in {@link Component}(s) added to it. There is CSS styling applied
     * the {@link VerticalLayout} that sets the display to block.
     *
     * @param components the {@link Component}(s) you want to add to the {@link VerticalLayout};
     * @return the {@link VerticalLayout};
     */
    public static VerticalLayout verticalBlock(final Component... components) {
        final VerticalLayout layout = new VerticalLayout(components);
        layout.addStyleName(CSS_BLOCK);
        return layout;
    }

    /**
     * Returns a {@link HorizontalLayout} with the passed in {@link Component}(s) added to it. There is CSS styling applied
     * the {@link HorizontalLayout} that sets the display to block.
     *
     * @param components the {@link Component}(s) you want to add to the {@link HorizontalLayout};
     * @return the {@link HorizontalLayout};
     */
    public static HorizontalLayout horizontalBlock(final Component... components) {
        final HorizontalLayout layout = new HorizontalLayout(components);
        layout.addStyleName(CSS_BLOCK);
        return layout;
    }
}
