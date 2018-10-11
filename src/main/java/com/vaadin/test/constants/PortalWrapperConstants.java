package com.vaadin.test.constants;

import com.vaadin.test.components.PortalWrapper;
import com.vaadin.ui.CustomLayout;

/**
 * Constants class that contains constant values used in {@link PortalWrapper};
 *
 * @author JMoy
 */
public final class PortalWrapperConstants {

    /**
     * Constant value that represents the path to the HTML template file used for this {@link CustomLayout}.
     */
    public static final String TEMPLATE_PATH = "portal-wrapper";

    /**
     * Constant value that represents the CSS class applied to this Layout.
     */
    public static final String PORTAL_WRAPPER = "portal-wrapper";

    /**
     * Constant value that represents the data location for the menu.
     */
    public static final String MENU_LOCATION = "menu";

    /**
     * Constant value that represents the data location for the mobile menu.
     */
    public static final String MOBILE_LOCATION = "mobile";

    /**
     * Constant value that represents the data location for the content.
     */
    public static final String CONTENT_LOCATION = "content";

    /**
     * Constant value that represents the CSS class applied to the menu when it is closed.
     */
    public static final String CLOSED_MENU = "closed-menu";

    /**
     * Private constructor to stop instantiation.
     */
    private PortalWrapperConstants() {}
}
