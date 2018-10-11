package com.vaadin.test.utils;

import com.vaadin.test.beans.JobItem;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 *
 * @author JMoy
 */
public final class TestDataUtils {

    /**
     * Private constructor to stop instantiation.
     */
    private TestDataUtils() {}

    /**
     * Returns a {@link List} of dummy data to display as Jobs on the DashboardView.
     *
     * @return the List of dummy data.
     */
    public static List<JobItem> dashboardData() {
        List<JobItem> items = new ArrayList<>();

        items.add(new JobItem("Test Job 1", Calendar.getInstance().getTime(), true));
        items.add(new JobItem("Test Job 2", Calendar.getInstance().getTime(), false));
        items.add(new JobItem("Test Job 3", Calendar.getInstance().getTime(), true));
        items.add(new JobItem("Test Job 4", Calendar.getInstance().getTime(), true));
        items.add(new JobItem("Test Job 5", Calendar.getInstance().getTime(), true));
        items.add(new JobItem("Test Job 6", Calendar.getInstance().getTime(), false));
        items.add(new JobItem("Test Job 7", Calendar.getInstance().getTime(), true));
        items.add(new JobItem("Test Job 8", Calendar.getInstance().getTime(), true));
        items.add(new JobItem("Test Job 9", Calendar.getInstance().getTime(), true));
        items.add(new JobItem("Test Job 10", Calendar.getInstance().getTime(), false));
        items.add(new JobItem("Test Job 11", Calendar.getInstance().getTime(), true));
        items.add(new JobItem("Test Job 12", Calendar.getInstance().getTime(), true));
        items.add(new JobItem("Test Job 13", Calendar.getInstance().getTime(), false));

        return items;
    }

    public static Runnable getRunnable(final UI ui, final ProgressBar progressBar, final Window window) {
        return () -> {
            for (int i = 1; i < 11; i++) {
                pause();
                progressBar.setValue(Double.valueOf(1D / 10D * i).floatValue());
                progressBar.setCaption("Loading " + i + " / 10");
                ui.push();
            }
            pause();
            window.close();
            ui.push();
        };
    }

    private static void pause() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
