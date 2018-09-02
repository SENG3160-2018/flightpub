package com.flightpub.base.model;

import com.sun.istack.internal.Nullable;

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

    private int id;
    private String airlineCode;
    private String flightNumber;
    private Date departureTime;
    private Date arrivalTime;

    private Date arrivalTimeStopOver1;
    private Date departureTimeStopOver1;

    private Date arrivalTimeStopOver2;
    private Date departureTimeStopOver2;

    private String planeCode;

    private String destination;
    private String departure;
    private Destination stopOverCode1;
    private String stopOverCode2;

    private Integer duration;
    private Integer durationSecondLeg;
    private Integer durationThirdLeg;

    private Price price;

    @Transient
    public Price getPrice() {
        return price;
    }
    public void setPrice(Price price) {
        this.price = price;
    }

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

    @Basic
    @Column(name = "DepartureCode")
    public String getDeparture() {
        return departure;
    }
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    @Basic
    @Column(name = "DestinationCode")
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Basic
    @Column(name = "DepartureTime")
    public Date getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    @Basic
    @Column(name = "ArrivalTime")
    public Date getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Basic
    @Column(name = "ArrivalTimeStopOver1")
    public Date getArrivalTimeStopOver1() {
        return arrivalTimeStopOver1;
    }
    public void setArrivalTimeStopOver1(Date arrivalTimeStopOver1) {
        this.arrivalTimeStopOver1 = arrivalTimeStopOver1;
    }

    @Basic
    @Column(name = "DepartureTimeStopOver1")
    public Date getDepartureTimeStopOver1() {
        return departureTimeStopOver1;
    }
    public void setDepartureTimeStopOver1(Date departureTimeStopOver1) {
        this.departureTimeStopOver1 = departureTimeStopOver1;
    }

    @Basic
    @Nullable
    @Column(name = "ArrivalTimeStopOver2")
    public Date getArrivalTimeStopOver2() {
        return arrivalTimeStopOver2;
    }
    public void setArrivalTimeStopOver2(Date arrivalTimeStopOver2) {
        this.arrivalTimeStopOver2 = arrivalTimeStopOver2;
    }

    @Basic
    @Nullable
    @Column(name = "DepartureTimeStopOver2")
    public Date getDepartureTimeStopOver2() {
        return departureTimeStopOver2;
    }
    public void setDepartureTimeStopOver2(Date departureTimeStopOver2) {
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
    public Integer getDuration() {
        return duration;
    }
    public void setDuration(Integer duration) {
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
    public Destination getStopOverCode1() {
        return stopOverCode1;
    }
    public void setStopOverCode1(Destination stopOverCode1) {
        this.stopOverCode1 = stopOverCode1;
    }

    @Basic
    @Column(name = "StopOverCode2")
    public String getStopOverCode2() {
        return stopOverCode2;
    }
    public void setStopOverCode2(String stopOverCode2) {
        this.stopOverCode2 = stopOverCode2;
    }
}
