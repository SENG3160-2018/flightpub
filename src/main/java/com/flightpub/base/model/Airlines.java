package com.flightpub.base.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Airlines
 *
 * Entity object mapped to Airlines DB table
 */
@Entity
public class Airlines {
    private String airlineCode;
    private String airlineName;

    @Id
    @Column(name = "AirlineCode")
    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    @Basic
    @Column(name = "AirlineName")
    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airlines airlines = (Airlines) o;

        if (airlineCode != null ? !airlineCode.equals(airlines.airlineCode) : airlines.airlineCode != null)
            return false;
        if (airlineName != null ? !airlineName.equals(airlines.airlineName) : airlines.airlineName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = airlineCode != null ? airlineCode.hashCode() : 0;
        result = 31 * result + (airlineName != null ? airlineName.hashCode() : 0);
        return result;
    }
}
