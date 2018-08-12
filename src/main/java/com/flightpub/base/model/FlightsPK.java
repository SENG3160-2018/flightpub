package com.flightpub.base.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * FlightsPK
 *
 * Flights Entity FK mappings
 */
public class FlightsPK implements Serializable {
    private String airlineCode;
    private String flightNumber;
    private Timestamp departureTime;

    @Column(name = "AirlineCode")
    @Id
    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    @Column(name = "FlightNumber")
    @Id
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @Column(name = "DepartureTime")
    @Id
    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightsPK flightsPK = (FlightsPK) o;

        if (airlineCode != null ? !airlineCode.equals(flightsPK.airlineCode) : flightsPK.airlineCode != null)
            return false;
        if (flightNumber != null ? !flightNumber.equals(flightsPK.flightNumber) : flightsPK.flightNumber != null)
            return false;
        if (departureTime != null ? !departureTime.equals(flightsPK.departureTime) : flightsPK.departureTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = airlineCode != null ? airlineCode.hashCode() : 0;
        result = 31 * result + (flightNumber != null ? flightNumber.hashCode() : 0);
        result = 31 * result + (departureTime != null ? departureTime.hashCode() : 0);
        return result;
    }
}
