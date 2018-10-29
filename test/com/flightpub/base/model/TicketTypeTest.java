package com.flightpub.base.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicketTypeTest {
    private TicketType ticketType;

    @Before
    public void setUp() throws Exception {
        ticketType = new TicketType();
    }

    @Test
    public void getTicketCode() {
        ticketType.setTicketCode("A");
        assertEquals("Ticket code is invalid.", "A", ticketType.getTicketCode());
    }

    @Test
    public void getName() {
        ticketType.setName("test");
        assertEquals("Ticket code is invalid.", "test", ticketType.getName());
    }

    @Test
    public void isTransferrable() {
        ticketType.setTransferrable(true);
        assertTrue(ticketType.isTransferrable());
    }

    @Test
    public void isRefundable() {
        ticketType.setRefundable(true);
        assertTrue(ticketType.isRefundable());
    }

    @Test
    public void isExchangeable() {
        ticketType.setExchangeable(true);
        assertTrue(ticketType.isExchangeable());
    }

    @Test
    public void isFrequentFlyerPoints() {
        ticketType.setFrequentFlyerPoints(true);
        assertTrue(ticketType.isFrequentFlyerPoints());
    }
}