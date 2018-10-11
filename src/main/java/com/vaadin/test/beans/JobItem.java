package com.vaadin.test.beans;

import lombok.Data;

import java.util.Date;

/**
 * Bean for storing basic information about individual jobs.
 *
 * @author JMoy
 */
@Data
public final class JobItem {

    /**
     * The name of the job.
     */
    private String name;

    /**
     * Date that represents the last time the job was run.
     */
    private Date runDate;

    /**
     * Flag that represents whether or not the job ran successfully last time around.
     */
    private boolean success;

    /**
     * Constructor.
     */
    public JobItem(String name, Date runDate, boolean success) {
        this.name = name;
        this.runDate = runDate;
        this.success = success;
    }
}
