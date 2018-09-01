package com.flightpub.base.model;

import javax.persistence.*;

/**
 * TicketClass
 *
 * Entity object mapped to Destination DB table
 */
@Entity
@Table(name = "TicketClass")
public class TicketClass {
    private String classCode;
    private String details;

    @Id
    @Column(name = "ClassCode")
    public String getClassCode() {
        return classCode;
    }
    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    @Basic
    @Column(name = "Details")
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
}
