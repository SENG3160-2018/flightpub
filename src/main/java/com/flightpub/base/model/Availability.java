package com.flightpub.base.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Availability
 *
 * Entity object mapped to Availability DB table
 */
@Entity
@Table(name = "Availability")
public class Availability implements Serializable {
    @Id
    @Column(name = "AirlineCode")
    private String airlineCode;

    @Id
    @Column(name = "ClassCode")
    private String ticketClass;

    @Id
    @Column(name = "TicketCode")
    private String ticketType;

    @Id
    @Column(name = "FlightNumber")
    private String flightNumber;

    @Id
    @Column(name = "DepartureTime")
    private Date departureTime;

    @Column(name = "NumberAvailableSeatsLeg1")
    private int seatsLeg1;

    @Column(name = "NumberAvailableSeatsLeg2")
    private int seatsLeg2;


    public String getAirlineCode() {
        return airlineCode;
    }
    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getTicketClass() {
        return ticketClass;
    }
    public void setTicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
    }

    public String getTicketType() {
        return ticketType;
    }
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }


    public int getSeatsLeg1() {
        return seatsLeg1;
    }
    public void setSeatsLeg1(int seatsLeg1) {
        this.seatsLeg1 = seatsLeg1;
    }

    public int getSeatsLeg2() {
        return seatsLeg2;
    }
    public void setSeatsLeg2(int seatsLeg2) {
        this.seatsLeg2 = seatsLeg2;
    }
}
