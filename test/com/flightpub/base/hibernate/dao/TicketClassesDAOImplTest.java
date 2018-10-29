package com.flightpub.base.hibernate.dao;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicketClassesDAOImplTest {
    private TicketClassesDAO ticketClassesDAO;

    @Before
    public void setUp() throws Exception {
        ticketClassesDAO = new TicketClassesDAOImpl();
    }

    @Test
    public void testGetTicketClasses() {
        assertTrue(ticketClassesDAO.getTicketClasses().size() > 0);
    }
}