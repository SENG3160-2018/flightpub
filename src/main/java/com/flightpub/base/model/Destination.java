package com.flightpub.base.model;

import javax.persistence.*;

/**
 * Destination
 *
 * Entity object mapped to Destination DB table
 */
@Entity
@Table(name = "Destinations")
public class Destination {
    private String destinationCode;
    private String airport;

    @ManyToOne
    @JoinColumn(name = "countryCode3")
    private Country country;

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
}
