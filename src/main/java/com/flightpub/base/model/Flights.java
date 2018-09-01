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
    private String departureCode;
    private String stopOverCode;
    private String destinationCode;
    private Timestamp departureTime;
    private Timestamp arrivalTimeStopOver;
    private Timestamp departureTimeStopOver;
    private Timestamp arrivalTime;
    private String planeCode;
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

    @Basic
    @Column(name = "DepartureCode")
    public String getDepartureCode() {
        return departureCode;
    }

    public void setDepartureCode(String departureCode) {
        this.departureCode = departureCode;
    }

    @Basic
    @Column(name = "StopOverCode")
    public String getStopOverCode() {
        return stopOverCode;
    }

    public void setStopOverCode(String stopOverCode) {
        this.stopOverCode = stopOverCode;
    }

    @Basic
    @Column(name = "DestinationCode")
    public String getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
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
    @Column(name = "ArrivalTimeStopOver")
    public Timestamp getArrivalTimeStopOver() {
        return arrivalTimeStopOver;
    }

    public void setArrivalTimeStopOver(Timestamp arrivalTimeStopOver) {
        this.arrivalTimeStopOver = arrivalTimeStopOver;
    }

    @Basic
    @Column(name = "DepartureTimeStopOver")
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
}
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Flights flights = (Flights) o;
//
//        if (id != flights.id) return false;
//        if (duration != flights.duration) return false;
//        if (airlineCode != null ? !airlineCode.equals(flights.airlineCode) : flights.airlineCode != null) return false;
//        if (flightNumber != null ? !flightNumber.equals(flights.flightNumber) : flights.flightNumber != null)
//            return false;
//        if (departureCode != flights.departureCode) return false;
//        if (departureTime != null ? !departureTime.equals(flights.departureTime) : flights.departureTime != null)
//            return false;
//        if (arrivalTimeStopOver != null ? !arrivalTimeStopOver.equals(flights.arrivalTimeStopOver) : flights.arrivalTimeStopOver != null)
//            return false;
//        if (departureTimeStopOver != null ? !departureTimeStopOver.equals(flights.departureTimeStopOver) : flights.departureTimeStopOver != null)
//            return false;
//        if (arrivalTime != null ? !arrivalTime.equals(flights.arrivalTime) : flights.arrivalTime != null) return false;
//        if (durationSecondLeg != null ? !durationSecondLeg.equals(flights.durationSecondLeg) : flights.durationSecondLeg != null)
//            return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (airlineCode != null ? airlineCode.hashCode() : 0);
//        result = 31 * result + (flightNumber != null ? flightNumber.hashCode() : 0);
//        result = 31 * result + (departureTime != null ? departureTime.hashCode() : 0);
//        result = 31 * result + (arrivalTimeStopOver != null ? arrivalTimeStopOver.hashCode() : 0);
//        result = 31 * result + (departureTimeStopOver != null ? departureTimeStopOver.hashCode() : 0);
//        result = 31 * result + (arrivalTime != null ? arrivalTime.hashCode() : 0);
//        result = 31 * result + duration;
//        result = 31 * result + (durationSecondLeg != null ? durationSecondLeg.hashCode() : 0);
//        return result;
//    }
//}
