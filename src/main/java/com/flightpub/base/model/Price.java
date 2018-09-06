package com.flightpub.base.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Price
 *
 * Entity object mapped to Destination DB table
 */
@Entity
@Table(name = "Price")
public class Price implements Serializable {
    @Id
    @Column(name = "FlightNumber")
    private String flightNumber;

    @Basic
    @Column(name = "Price")
    private double price;

    @Id
    @Column(name = "ClassCode")
    private String classCode;

    @Id
    @Column(name = "TicketCode")
    private String ticketCode;

    @Id
    @Column(name = "AirlineCode")
    private String airlineCode;

    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    public String getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getClassCode() {
        return classCode;
    }
    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getTicketCode() {
        return ticketCode;
    }
    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public String getAirlineCode() {
        return airlineCode;
    }
    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
