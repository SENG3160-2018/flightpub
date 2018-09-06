package com.flightpub.base.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Flights
 *
 * Entity object mapped to Flights DB table
 */
@Entity
@Table(name = "Flights")
public class Flights implements Serializable {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "AirlineCode")
    private String airlineCode;

    @Column(name = "FlightNumber")
    private String flightNumber;

    @Column(name = "DepartureTime")
    private Date departureTime;

    @Column(name = "ArrivalTime")
    private Date arrivalTime;

    @Column(name = "ArrivalTimeStopOver")
    private Date arrivalTimeStopOver;

    @Column(name = "DepartureTimeStopOver")
    private Date departureTimeStopOver;

    @Column(name = "PlaneCode")
    private String planeCode;

    @Column(name = "DepartureCode")
    private String departure;

    @Column(name = "DestinationCode")
    private String destination;

    @Column(name = "StopOverCode")
    private String stopOverCode;

    @Column(name = "Duration")
    private Integer duration;

    @Column(name = "DurationSecondLeg")
    private Integer durationSecondLeg;

    @Transient
    private Price price;

    @Transient
    private Availability availability;

    @Transient
    private Flights connectingFlight;


    public Price getPrice() {
        return price;
    }
    public void setPrice(Price price) {
        this.price = price;
    }

    public Availability getAvailability() {
        return availability;
    }
    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public Flights getConnectingFlight() {
        return connectingFlight;
    }
    public void setConnectingFlight(Flights connectingFlight) {
        this.connectingFlight = connectingFlight;
    }
    public boolean hasConnectingFlight() {
        return connectingFlight != null;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getAirlineCode() {
        return airlineCode;
    }
    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDeparture() {
        return departure;
    }
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getPlaneCode() {
        return planeCode;
    }
    public void setPlaneCode(String planeCode) {
        this.planeCode = planeCode;
    }

    public Integer getDuration() {
        return duration;
    }
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getDurationSecondLeg() {
        return durationSecondLeg;
    }
    public void setDurationSecondLeg(Integer durationSecondLeg) {
        this.durationSecondLeg = durationSecondLeg;
    }

    public Date getArrivalTimeStopOver() {
        return arrivalTimeStopOver;
    }
    public void setArrivalTimeStopOver(Date arrivalTimeStopOver) {
        this.arrivalTimeStopOver = arrivalTimeStopOver;
    }

    public Date getDepartureTimeStopOver() {
        return departureTimeStopOver;
    }
    public void setDepartureTimeStopOver(Date departureTimeStopOver) {
        this.departureTimeStopOver = departureTimeStopOver;
    }

    public String getStopOverCode() {
        return stopOverCode;
    }
    public void setStopOverCode(String stopOverCode) {
        this.stopOverCode = stopOverCode;
    }
}
