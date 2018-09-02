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
    private Timestamp arrivalTime;

    private Timestamp arrivalTimeStopOver1;
    private Timestamp departureTimeStopOver1;

    private Timestamp arrivalTimeStopOver2;
    private Timestamp departureTimeStopOver2;

    private String planeCode;

    private int duration;
    private int durationSecondLeg;
    private int durationThirdLeg;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "AirlineCode")
    public String getAirlineCode() {
        return airlineCode;
    }
    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    @Basic
    @Column(name = "FlightNumber")
    public String getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @ManyToOne
    @JoinColumn(name = "DepartureCode")
    private Destination departure;

    @ManyToOne
    @JoinColumn(name = "DestinationCode")
    private Destination destination;

    @Basic
    @Column(name = "DepartureTime")
    public Timestamp getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
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
    @Column(name = "ArrivalTimeStopOver1")
    public Timestamp getArrivalTimeStopOver1() {
        return arrivalTimeStopOver1;
    }
    public void setArrivalTimeStopOver1(Timestamp arrivalTimeStopOver1) {
        this.arrivalTimeStopOver1 = arrivalTimeStopOver1;
    }

    @Basic
    @Column(name = "DepartureTimeStopOver1")
    public Timestamp getDepartureTimeStopOver1() {
        return departureTimeStopOver1;
    }
    public void setDepartureTimeStopOver1(Timestamp departureTimeStopOver1) {
        this.departureTimeStopOver1 = departureTimeStopOver1;
    }

    @Basic
    @Column(name = "ArrivalTimeStopOver2")
    public Timestamp getArrivalTimeStopOver2() {
        return arrivalTimeStopOver2;
    }
    public void setArrivalTimeStopOver2(Timestamp arrivalTimeStopOver2) {
        this.arrivalTimeStopOver2 = arrivalTimeStopOver2;
    }

    @Basic
    @Column(name = "DepartureTimeStopOver2")
    public Timestamp getDepartureTimeStopOver2() {
        return departureTimeStopOver2;
    }
    public void setDepartureTimeStopOver2(Timestamp departureTimeStopOver2) {
        this.departureTimeStopOver2 = departureTimeStopOver2;
    }

    @Basic
    @Column(name = "PlaneCode")
    public String getPlaneCode() {
        return planeCode;
    }
    public void setPlaneCode(String planeCode) {
        this.planeCode = planeCode;
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

    @Basic
    @Column(name = "DurationThirdLeg")
    public Integer getDurationThirdLeg() {
        return durationThirdLeg;
    }
    public void setDurationThirdLeg(Integer durationThirdLeg) {
        this.durationThirdLeg = durationThirdLeg;
    }

    @ManyToOne
    @JoinColumn(name = "StopOverCode1")
    private Destination stopOver1;

    @ManyToOne
    @JoinColumn(name = "StopOverCode2")
    private Destination stopOver2;
}
