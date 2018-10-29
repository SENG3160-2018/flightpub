package com.flightpub.base.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountryTest {
    private Country country;

    @Before
    public void setUp() throws Exception {
        country = new Country();
    }

    @Test
    public void getCountryCode2() {
        country.setCountryCode2("AU");
        assertEquals("Country2 is invalid.", "AU", country.getCountryCode2());
    }

    @Test
    public void getCountryCode3() {
        country.setCountryCode3("AU");
        assertEquals("Country3 is invalid.", "AU", country.getCountryCode3());
    }

    @Test
    public void getCountryName() {
        country.setCountryName("Australia");
        assertEquals("Country2 is invalid.", "Australia", country.getCountryName());
    }

    @Test
    public void getAlternateName1() {
        country.setAlternateName1("Aus");
        assertEquals("Country2 is invalid.", "Aus", country.getAlternateName1());
    }
}