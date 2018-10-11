package com.vaadin.test.components;

import com.test.main.DataLoad;
import com.vaadin.test.beans.JobItem;
import com.vaadin.test.beans.LoadingBean;
import com.vaadin.test.layouts.CardLayout;
import com.vaadin.test.utils.ButtonUtils;
import com.vaadin.test.utils.LabelUtils;
import com.vaadin.test.utils.WindowUtils;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import lombok.Getter;

import java.util.Calendar;

import static com.vaadin.ui.Button.ClickEvent;

/**
 * @author JMoy
 */
public class DashboardCard extends CardLayout {

    /**
     * Constant value that represents tha path to the template file used for this {@link CustomLayout}.
     */
    private static final String TEMPLATE_PATH = "dashboard-card";

    /**
     * Constant value that represents the data location for the header.
     */
    private static final String HEADER_LOCATION = "header";

    /**
     * Constant value that represents the data location for the last run details.
     */
    private static final String DETAILS_LOCATION = "details";

    /**
     * Constant value that represents the data location for the run button.
     */
    private static final String BUTTON_LOCATION = "button";

    /**
     *
     */
    @Getter
    private final Label header;

    /**
     *
     */
    private final Label lastRunDate;

    /**
     *
     */
    private final Label success;

    public DashboardCard(final JobItem item) {
        super(TEMPLATE_PATH);
        config();

        header = LabelUtils.wordWrap(item.getName(), ValoTheme.LABEL_H2);

        final FormLayout details = new FormLayout();
        details.setCaption("Last Run Details");

        lastRunDate = LabelUtils.wordWrap(item.getRunDate().toString());
        lastRunDate.setCaption("Run Date");

        success = LabelUtils.wordWrap(item.isSuccess() ? "Success" : "Fail");
        success.setCaption("Success / Fail");

        details.addComponents(lastRunDate, success);

        final Button run = ButtonUtils.red("Run", this::run);

        addComponent(header, HEADER_LOCATION);
        addComponent(details, DETAILS_LOCATION);
        addComponent(run, BUTTON_LOCATION);
    }

    private void run(final ClickEvent clickEvent) {

        final Window window = new Window();
        final String caption = "Running " + header.getValue();
        final UI ui = clickEvent.getButton().getUI();
        final ProgressBar progressBar = new ProgressBar();
        final DataLoad dataLoad = new DataLoad(ui, progressBar, window);

        final LoadingBean bean = new LoadingBean(window, caption, dataLoad, ui, progressBar);

        WindowUtils.loading(bean);

        clickEvent.getButton().getUI().addWindow(bean.getWindow());

        lastRunDate.setValue(Calendar.getInstance().getTime().toString());
        success.setValue("Success");
    }

    private void config() {
        addStyleName("dashboard-card");
    }
}
