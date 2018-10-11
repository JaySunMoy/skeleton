package com.vaadin.test.components;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.test.utils.LabelUtils;
import com.vaadin.test.utils.LayoutUtils;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import lombok.Getter;

import static com.vaadin.test.constants.PortalWrapperConstants.*;

/**
 * The Layout that acts as a wrapper to the entire portal. Contains both the Menu and the Content.
 *
 * @author JMoy
 */
public class PortalWrapper extends CustomLayout {

    /**
     * Generated Serial Version UID.
     */
    private static final long serialVersionUID = -1413195726345170485L;

    /**
     * The Layout that's used as the wrapper for the menu.
     */
    private final CssLayout portalMenu = new CssLayout();

    /**
     * The Layout that's used as the wrapper for mobile menu.
     */
    private final CssLayout mobileMenu = new CssLayout();

    /**
     * The Layout that's used as the main wrapper for the portal content.
     */
    @Getter
    private final Layout portalContent;

    /**
     * Constructor.
     */
    public PortalWrapper() {
        super(TEMPLATE_PATH);

        addStyleName(PORTAL_WRAPPER);
        portalContent = LayoutUtils.verticalNoMargin("portal-content");

        createMenu(portalMenu, "portal-menu");
        createMenu(mobileMenu, "portal-mobile-menu");

        final VerticalLayout menuContent = LayoutUtils.verticalNoMargin("menu-content");

        final Label header = LabelUtils.wordWrap("Header", ValoTheme.LABEL_H3);

        menuContent.addComponent(header);
        portalMenu.addComponent(menuContent);

        addComponent(portalMenu, MENU_LOCATION);
        addComponent(mobileMenu, MOBILE_LOCATION);
        addComponent(portalContent, CONTENT_LOCATION);
    }

    /**
     * Adds all the menu items to the passed in {@link Layout} and then sets the passed in {@link String} as a style name.
     *
     * @param menu the {@link Layout} to add the menu items to.
     * @param style the CSS class to add to the menu.
     */
    private void createMenu(final Layout menu, final String style) {
        menu.addStyleName(style);

        final Button menuButton = new Button(VaadinIcons.MENU);
        menuButton.addStyleNames(ValoTheme.BUTTON_BORDERLESS, "portal-menu-button");
        menuButton.addClickListener(event -> toggleMenu());

        menu.addComponents(menuButton);
    }

    /**
     * Toggles the CSS class on both the menu {@link Layout} objects that defines whether they're open or closed.
     */
    private void toggleMenu() {
        if (portalMenu.getStyleName().contains(CLOSED_MENU)) {
            mobileMenu.removeStyleName(CLOSED_MENU);
            portalMenu.removeStyleName(CLOSED_MENU);
        } else {
            mobileMenu.addStyleName(CLOSED_MENU);
            portalMenu.addStyleName(CLOSED_MENU);
        }
    }
}
