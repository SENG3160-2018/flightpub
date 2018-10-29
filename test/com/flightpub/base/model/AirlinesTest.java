package com.flightpub.base.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class AirlinesTest {

    @Test
    public void testGetAirlineCode() {
        Airlines airline = new Airlines();
        airline.setAirlineCode("test");
        assertEquals("Airline code not correct.", "test", airline.getAirlineCode());
    }

    @Test
    public void testGetAirlineName() {
        Airlines airline = new Airlines();
        airline.setAirlineName("test");
        assertEquals("Airline name not correct.", "test", airline.getAirlineName());
    }
}