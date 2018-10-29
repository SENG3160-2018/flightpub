package com.flightpub.base.model;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class AvailabilityTest {

    private Availability availability;

    private void setup() {
        availability = new Availability();
    }

    @Test
    public void getAirlineCode() {
        setup();
        availability.setAirlineCode("test");
        assertEquals("AirlineCode is incorrect.", "test", availability.getAirlineCode());
    }

    @Test
    public void getTicketClass() {
        setup();
        availability.setTicketClass("BUS");
        assertEquals("TicketClass is incorrect.", "BUS", availability.getTicketClass());
    }

    @Test
    public void getTicketType() {
        setup();
        availability.setTicketType("A");
        assertEquals("TicketType is incorrect.", "A", availability.getTicketType());
    }

    @Test
    public void getFlightNumber() {
        setup();
        availability.setFlightNumber("AA123");
        assertEquals("FlightNumber is incorrect.", "AA123", availability.getFlightNumber());
    }

    @Test
    public void getDepartureTime() {
        setup();
        Date date = new Date();
        availability.setDepartureTime(date);
        assertEquals("Departure is incorrect.", date, availability.getDepartureTime());
    }

    @Test
    public void getSeatsLeg1() {
        setup();
        availability.setSeatsLeg1(20);
        assertEquals("Seats1 is incorrect.", 20, availability.getSeatsLeg1());
    }

    @Test
    public void getSeatsLeg2() {
        setup();
        availability.setSeatsLeg2(15);
        assertEquals("Seats2 is incorrect.", 15, availability.getSeatsLeg2());
    }
}