package com.flightpub.base.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicketClassTest {
    private TicketClass ticketClass;

    @Before
    public void setUp() throws Exception {
        ticketClass = new TicketClass();
    }

    @Test
    public void getClassCode() {
        ticketClass.setClassCode("BUS");
        assertEquals("Class is invalid.", "BUS", ticketClass.getClassCode());
    }

    @Test
    public void getDetails() {
        ticketClass.setDetails("Details");
        assertEquals("Details is invalid.", "Details", ticketClass.getDetails());
    }
}