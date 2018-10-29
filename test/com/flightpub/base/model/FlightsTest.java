package com.flightpub.base.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class FlightsTest {
    private Flights flight = new Flights();

    @Before
    public void setUp() throws Exception {
        flight = new Flights();
    }

    @Test
    public void getPrice() {
        Price price = new Price();
        price.setPrice(1000.00);
        flight.setPrice(price);
        assertEquals( (Double) 1000.00, flight.getPrice().getPrice());
    }

    @Test
    public void getAvailability() {
        Availability availability = new Availability();
        availability.setSeatsLeg1(20);
        flight.setAvailability(availability);
        assertEquals("Flight availability is incorrect.", 20, flight.getAvailability().getSeatsLeg1());
    }

    @Test
    public void getConnectingFlight() {
        Flights connecting = new Flights();
        connecting.setId(100);
        flight.setConnectingFlight(connecting);
        assertEquals("Connecting flight is incorrect.", 100, flight.getConnectingFlight().getId());
    }

    @Test
    public void hasConnectingFlight() {
        Flights connecting = new Flights();
        flight.setConnectingFlight(connecting);
        assertTrue(flight.hasConnectingFlight());
    }

    @Test
    public void getId() {
        flight.setId(100);
        assertEquals("Flight id is incorrect.", 100, flight.getId());
    }

    @Test
    public void getAirlineCode() {
        flight.setAirlineCode("AA11");
        assertEquals("Airline code is incorrect.", "AA11", flight.getAirlineCode());
    }

    @Test
    public void getFlightNumber() {
        flight.setFlightNumber("AA11");
        assertEquals("Flight number is incorrect.", "AA11", flight.getFlightNumber());
    }

    @Test
    public void getDeparture() {
        flight.setDeparture("SYD");
        assertEquals("Flight departure is incorrect.", "SYD", flight.getDeparture());
    }

    @Test
    public void getDestination() {
        flight.setDestination("SYD");
        assertEquals("Flight destination is incorrect.", "SYD", flight.getDestination());
    }

    @Test
    public void getDepartureTime() {
        Date date = new Date();
        flight.setDepartureTime(date);
        assertEquals("Flight departure time is incorrect.", date, flight.getDepartureTime());
    }

    @Test
    public void getArrivalTime() {
        Date date = new Date();
        flight.setArrivalTime(date);
        assertEquals("Flight arrival time is incorrect.", date, flight.getArrivalTime());
    }

    @Test
    public void getPlaneCode() {
        flight.setPlaneCode("ABC");
        assertEquals("Plane code is incorrect.", "ABC", flight.getPlaneCode());
    }

    @Test
    public void getDuration() {
        flight.setDuration(1200);
        assertEquals("Plane duration is incorrect.", 1200, (int)flight.getDuration());
    }

    @Test
    public void getDurationSecondLeg() {
        flight.setDurationSecondLeg(1200);
        assertEquals("Plane duration2 is incorrect.", 1200, (int)flight.getDurationSecondLeg());
    }

    @Test
    public void getArrivalTimeStopOver() {
        Date date = new Date();
        flight.setArrivalTimeStopOver(date);
        assertEquals("Flight stopover arrival is incorrect.", date, flight.getArrivalTimeStopOver());
    }

    @Test
    public void getDepartureTimeStopOver() {
        Date date = new Date();
        flight.setDepartureTimeStopOver(date);
        assertEquals("Flight stopover departure is incorrect.", date, flight.getDepartureTimeStopOver());
    }

    @Test
    public void getStopOverCode() {
        flight.setStopOverCode("SYD");
        assertEquals("Flight stopover is incorrect.", "SYD", flight.getStopOverCode());
    }

    @Test
    public void getTotalLegs() {
        flight.setTotalLegs(3);
        assertEquals("Flight total legs is incorrect.", 3, flight.getTotalLegs());
    }

    @Test
    public void getTotalPrice() {
        flight.setTotalPrice(1200);
        assertEquals(1200, flight.getTotalPrice(), 0);
    }
}