package com.flightpub.base.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DestinationTest {
    private Destination destination;

    @Before
    public void setUp() throws Exception {
        destination = new Destination();
    }

    @Test
    public void getDestinationCode() {
        destination.setDestinationCode("SYD");
        assertEquals("Destination code is invalid.", "SYD", destination.getDestinationCode());
    }

    @Test
    public void getAirport() {
        destination.setAirport("SYD");
        assertEquals("Airport is invalid.", "SYD", destination.getAirport());
    }
}