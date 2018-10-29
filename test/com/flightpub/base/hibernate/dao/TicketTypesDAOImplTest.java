package com.flightpub.base.hibernate.dao;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicketTypesDAOImplTest {
    private TicketTypesDAO ticketTypesDAO;

    @Before
    public void setUp() throws Exception {
        ticketTypesDAO = new TicketTypesDAOImpl();
    }

    @Test
    public void getTicketTypes() {
        assertTrue(ticketTypesDAO.getTicketTypes().size() > 0);
    }
}