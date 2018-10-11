package com.vaadin.test.utils;

import com.vaadin.test.beans.LoadingBean;
import com.vaadin.ui.Layout;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class WindowUtils {

    /**
     * Private constructor to stop instantiation.
     */
    private WindowUtils() {}

    public static Window loading(final String caption) {
        Window window = new Window(caption);
        config(window);
        ProgressBar progressBar = new ProgressBar();
        progressBar.setCaption("Loading...");
        progressBar.setWidth("100%");
        final Layout layout = LayoutUtils.verticalBlock(progressBar);
        window.setContent(layout);
        final ExecutorService executor = Executors.newSingleThreadExecutor();

        final UI ui = UI.getCurrent();

        ui.accessSynchronously(() -> executor.execute(() -> {

        }));
        return window;
    }

    public static void loading(final LoadingBean bean) {
        final Window window = bean.getWindow();
        window.setCaption(bean.getCaption());
        config(window);
        final ProgressBar progressBar = bean.getProgressBar();
        progressBar.setCaption("Loading");
        progressBar.setWidth("100%");
        final Layout layout = LayoutUtils.verticalBlock(progressBar);
        window.setContent(layout);
        final ExecutorService executor = Executors.newSingleThreadExecutor();
        bean.getUi().accessSynchronously(() -> executor.execute(bean.getRunnable()));
    }

    private static void config(final Window window) {
        window.center();
        window.setClosable(true);
        window.setResizable(false);
        window.setDraggable(false);
        window.setModal(true);
        window.setWidth("400px");
        window.setHeight("150px");
        window.setClosable(false);
    }
}
