package com.flightpub.base.model;

import javax.persistence.*;

/**
 * Airlines
 *
 * Entity object mapped to Airlines DB table
 */
@Entity
@Table(name = "Airlines")
public class Airlines {
    private String airlineCode;
    private String airlineName;

    @ManyToOne
    @JoinColumn(name = "CountryCode3")
    private Country country;

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
}
