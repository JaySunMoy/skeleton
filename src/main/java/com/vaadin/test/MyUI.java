package com.vaadin.test;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.test.components.PortalWrapper;
import com.vaadin.test.server.TestErrorHandler;
import com.vaadin.test.views.LoginView;
import com.vaadin.ui.UI;

import javax.servlet.annotation.WebServlet;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Push
@PreserveOnRefresh
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final PortalWrapper wrapper = new PortalWrapper();
        final Navigator navigator = new Navigator(this, wrapper.getPortalContent());
        navigator.addView(LoginView.VIEW_NAME, new LoginView());
        setContent(wrapper);
        setErrorHandler(new TestErrorHandler());
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
