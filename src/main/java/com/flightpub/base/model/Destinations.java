package com.flightpub.base.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Destinations
 *
 * Entity object mapped to Destinations DB table
 */
@Entity
public class Destinations {
    private String destinationCode;
    private String airport;

    @Id
    @Column(name = "DestinationCode")
    public String getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }

    @Basic
    @Column(name = "Airport")
    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Destinations that = (Destinations) o;

        if (destinationCode != null ? !destinationCode.equals(that.destinationCode) : that.destinationCode != null)
            return false;
        if (airport != null ? !airport.equals(that.airport) : that.airport != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = destinationCode != null ? destinationCode.hashCode() : 0;
        result = 31 * result + (airport != null ? airport.hashCode() : 0);
        return result;
    }
}
