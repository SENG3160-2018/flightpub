package com.flightpub.base.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Price
 *
 * Entity object mapped to Destination DB table
 */
@Entity
@Table(name = "Price")
public class Price implements Serializable {
    private String flightNumber;
    private double price;
    private String classCode;
    private String ticketCode;
    private String airlineCode;

    @Id
    @Column(name = "FlightNumber")
    public String getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @Basic
    @Column(name = "Price")
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Id
    @Column(name = "ClassCode")
    public String getClassCode() {
        return classCode;
    }
    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    @Id
    @Column(name = "TicketCode")
    public String getTicketCode() {
        return ticketCode;
    }
    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    @Id
    @Column(name = "AirlineCode")
    public String getAirlineCode() {
        return airlineCode;
    }
    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }


}
