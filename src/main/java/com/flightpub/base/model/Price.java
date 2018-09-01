package com.flightpub.base.model;

import javax.persistence.*;

/**
 * Price
 *
 * Entity object mapped to Destination DB table
 */
@Entity
@Table(name = "Price")
public class Price {
    private String flightNumber;
    private double price;

    @ManyToOne
    @JoinColumn(name = "AirlineCode")
    private Airlines airline;
    @ManyToOne
    @JoinColumn(name = "ClassCode")
    private TicketClass ticketClass;
    @ManyToOne
    @JoinColumn(name = "TicketCode")
    private TicketType ticketType;

    @Basic
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
}
