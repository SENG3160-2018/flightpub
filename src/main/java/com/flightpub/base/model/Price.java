package com.flightpub.base.model;

import com.sun.istack.internal.Nullable;
import javafx.beans.DefaultProperty;

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

    @Column(name = "Price")
    private double price;

    @Column(name = "PriceLeg1", nullable = true)
    private Double price1;

    @Column(name = "PriceLeg2", nullable = true)
    private Double price2;

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

    public Double getPrice1() {
        return price1;
    }

    public void setPrice1(Double price1) {
        if (Double.valueOf(price1) != null) {
            this.price1 = price1;
        } else {
            this.price1 = 0.0;
        }
    }

    public Double getPrice2() {
        return price2;
    }

    public void setPrice2(Double price2) {
        if (Double.valueOf(price2) != null) {
            this.price2 = price2;
        } else {
            this.price2 = 0.0;
        }
    }
}
