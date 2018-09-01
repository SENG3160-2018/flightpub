package com.flightpub.base.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Flights
 *
 * Entity object mapped to Flights DB table
 */
@Entity
@Table(name = "Flights")
public class Flights implements Serializable {
    private int id;
    private String airlineCode;
    private String flightNumber;
    private Timestamp departureTime;
    private Timestamp arrivalTimeStopOver;
    private Timestamp departureTimeStopOver;
    private Timestamp arrivalTime;
    private int duration;
    private Integer durationSecondLeg;

    @Basic
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "AirlineCode")
    public String getAirlineCode() {
        return airlineCode;
    }
    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    @Id
    @Column(name = "FlightNumber")
    public String getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @Id
    @Column(name = "DepartureTime")
    public Timestamp getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    @Basic
    @Column(name = "ArrivalTimeStopOver1")
    public Timestamp getArrivalTimeStopOver() {
        return arrivalTimeStopOver;
    }

    public void setArrivalTimeStopOver(Timestamp arrivalTimeStopOver) {
        this.arrivalTimeStopOver = arrivalTimeStopOver;
    }

    @Basic
    @Column(name = "DepartureTimeStopOver1")
    public Timestamp getDepartureTimeStopOver() {
        return departureTimeStopOver;
    }

    public void setDepartureTimeStopOver(Timestamp departureTimeStopOver) {
        this.departureTimeStopOver = departureTimeStopOver;
    }

    @Basic
    @Column(name = "ArrivalTime")
    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Basic
    @Column(name = "Duration")
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "DurationSecondLeg")
    public Integer getDurationSecondLeg() {
        return durationSecondLeg;
    }

    public void setDurationSecondLeg(Integer durationSecondLeg) {
        this.durationSecondLeg = durationSecondLeg;
    }

    @ManyToOne
    @JoinColumn(name = "DepartureCode")
    private Destination departureTerminal;

    @ManyToOne
    @JoinColumn(name = "DestinationCodeCode")
    private Destination arrivalTerminal;

    @ManyToOne
    @JoinColumn(name = "AirlineCode")
    private Airlines airline;
}
