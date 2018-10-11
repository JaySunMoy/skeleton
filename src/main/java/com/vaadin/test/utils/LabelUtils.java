package com.vaadin.test.utils;

import com.vaadin.ui.Label;

import static com.vaadin.test.constants.LabelUtilsConstants.WORD_WRAP;

/**
 * Class to be accessed statically that returns Labels with common styling / configurations already applied.
 *
 * @author JMoy
 */
public final class LabelUtils {

    /**
     * Private constructor to instantiation.
     */
    private LabelUtils() {}

    /**
     * Returns a {@link Label} with passed in text set as the value. Adds CSS styling to the {@link Label} to enforce word wrapping.
     *
     * @return the {@link Label}.
     */
    public static Label wordWrap() {
        final Label label = new Label();
        label.addStyleName(WORD_WRAP);
        return label;
    }

    /**
     * Returns a {@link Label} with passed in text set as the value. Adds CSS styling to the {@link Label} to enforce word wrapping.
     *
     * @param text the text you want to set in the {@link Label}.
     *
     * @return the {@link Label}.
     */
    public static Label wordWrap(final String text) {
        final Label label = wordWrap();
        label.setValue(text);
        return label;
    }

    /**
     * Returns a {@link Label} with passed in text set as the value. Adds CSS styling to the {@link Label} to enforce word wrapping.
     *
     * @param text the text you want to set in the {@link Label}.
     *
     * @return the {@link Label}.
     */
    public static Label wordWrap(final String text, final String... style) {
        final Label label = wordWrap(text);
        label.addStyleNames(style);
        return label;
    }
}
