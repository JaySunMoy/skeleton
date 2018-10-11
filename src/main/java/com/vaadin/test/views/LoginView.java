package com.vaadin.test.views;

import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.test.layouts.CardLayout;
import com.vaadin.test.layouts.TemplateLayout;
import com.vaadin.test.utils.ButtonUtils;
import com.vaadin.test.utils.LayoutUtils;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

import static com.vaadin.event.ShortcutAction.*;

/**
 * Class that represents the Login View.
 *
 * @author JMoy
 */
public class LoginView extends TemplateLayout implements View {

    /**
     * Generated Serial Version UID.
     */
    private static final long serialVersionUID = 7341021050459453790L;

    /**
     * Constant value that represents the name of the {@link View}. This is left intentionally blank so that it
     * registers as the default {@link View} in the {@link Navigator}.
     */
    public static final String VIEW_NAME = "";

    /**
     * Constant value that represents the path to the template file used for this {@link CustomLayout}.
     */
    private static final String TEMPLATE_PATH = "login";

    /**
     * Constant value that represents the data location for the login panel.
     */
    private static final String PANEL_LOCATION = "panel";

    /**
     * Navigator instance.
     */
    private Navigator nav;

    /**
     * Constructor.
     */
    public LoginView() {
        super(TEMPLATE_PATH);

        addStyleName("login-view");
        final Layout loginPanel = LayoutUtils.verticalBlock();
        final TextField userName = new TextField("Username");
        userName.setIcon(VaadinIcons.USER);
        final PasswordField password = new PasswordField("Password");
        password.setIcon(VaadinIcons.PASSWORD);
        final Button loginButton = ButtonUtils.red("Login", this::login);
        loginButton.setClickShortcut(KeyCode.ENTER);

        loginPanel.addComponents(userName, password, loginButton);

        addComponent(loginPanel, PANEL_LOCATION);
    }

    private void login(final ClickEvent clickEvent) {
        nav.addView("dashboard", new DashboardView());
        nav.navigateTo("dashboard");
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        this.nav = event.getNavigator();
    }
}
