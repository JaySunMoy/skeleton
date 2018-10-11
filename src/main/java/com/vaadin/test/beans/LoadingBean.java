package com.vaadin.test.beans;

import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author JMoy
 */
@Data
@AllArgsConstructor
public final class LoadingBean {

    /**
     *
     */
    private Window window;

    /**
     *
     */
    private String caption;

    /**
     *
     */
    private Runnable runnable;

    /**
     *
     */
    private UI ui;

    /**
     *
     */
    private ProgressBar progressBar;
}
