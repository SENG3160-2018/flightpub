package com.flightpub.base.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Destination
 *
 * Entity object mapped to Destination DB table
 */
@Entity
@Table(name = "Country")
public class Country {
    private String countryCode2;
    private String countryCode3;
    private String countryName;
    private String alternateName1;

    @OneToMany(mappedBy = "country")
    private Set<Destination> destinations;

    @Id
    @Column(name = "countryCode2")
    public String getCountryCode2() {
        return countryCode2;
    }

    public void setCountryCode2(String countryCode2) {
        this.countryCode2 = countryCode2;
    }

    @Basic
    @Column(name = "countryCode3")
    public String getCountryCode3() {
        return countryCode3;
    }

    public void setCountryCode3(String countryCode3) {
        this.countryCode3 = countryCode3;
    }

    @Basic
    @Column(name = "countryName")
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Basic
    @Column(name = "alternateName1")
    public String getAlternateName1() {
        return alternateName1;
    }

    public void setAlternateName1(String alternateName1) {
        this.alternateName1 = alternateName1;
    }
}
