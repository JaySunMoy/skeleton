package com.vaadin.test.server;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.ErrorEvent;
import com.vaadin.server.ErrorHandler;
import com.vaadin.test.views.LoginView;
import com.vaadin.ui.UI;

import java.util.Arrays;

public class TestErrorHandler implements ErrorHandler {

    @Override
    public void error(ErrorEvent event) {
        final Navigator nav = UI.getCurrent().getNavigator();
        if (nav.getCurrentView() == null) {
            nav.navigateTo(LoginView.VIEW_NAME);
        } else {
            System.out.println(Arrays.toString(event.getThrowable().getStackTrace()));
        }
    }
}
