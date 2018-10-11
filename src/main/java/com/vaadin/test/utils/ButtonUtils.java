package com.vaadin.test.utils;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;

/**
 * 
 *
 * @author JMoy
 */
public final class ButtonUtils {

    /**
     * Private constructor to stop instantiation.
     */
    private ButtonUtils() {}

    /**
     * Returns a red {@link Button} with the passed in caption and {@link ClickListener} set.
     *
     * @param caption the caption to set.
     * @return the {@link Button}.
     */
    public static Button red(final String caption) {
        final Button button = new Button(caption);
        button.addStyleName("red-button");
        return button;
    }

    /**
     * Returns a red {@link Button} with the passed in caption and {@link ClickListener} set.
     *
     * @param caption the caption to set.
     * @param click the {@link ClickListener} to set.
     * @return the {@link Button}.
     */
    public static Button red(final String caption, final ClickListener click) {
        final Button button = red(caption);
        button.addClickListener(click);
        return button;
    }
}
