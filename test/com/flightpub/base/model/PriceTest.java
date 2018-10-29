package com.flightpub.base.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class PriceTest {
    private Price price;

    @Before
    public void setUp() throws Exception {
        price = new Price();
    }

    @Test
    public void getFlightNumber() {
        price.setFlightNumber("AA11");
        assertEquals("Flight number is invalid.", "AA11", price.getFlightNumber());
    }

    @Test
    public void getPrice() {
        price.setPrice(100.0);
        assertEquals(100.0, price.getPrice(), 0);
    }

    @Test
    public void getClassCode() {
        price.setClassCode("BUS");
        assertEquals("Class is invalid.", "BUS", price.getClassCode());
    }

    @Test
    public void getTicketCode() {
        price.setTicketCode("A");
        assertEquals("Ticket is invalid.", "A", price.getTicketCode());
    }

    @Test
    public void getAirlineCode() {
        price.setAirlineCode("QTN");
        assertEquals("Airline is invalid.", "QTN", price.getAirlineCode());
    }

    @Test
    public void getStartDate() {
        Date date = new Date();
        price.setStartDate(date);
        assertEquals("Start date is invalid.", date, price.getStartDate());
    }

    @Test
    public void getEndDate() {
        Date date = new Date();
        price.setEndDate(date);
        assertEquals("End date is invalid.", date, price.getEndDate());
    }

    @Test
    public void getPrice1() {
        price.setPrice1(100.0);
        assertEquals(100.0, price.getPrice1(), 0);
    }

    @Test
    public void getPrice2() {
        price.setPrice2(100.0);
        assertEquals(100.0, price.getPrice2(), 0);
    }
}