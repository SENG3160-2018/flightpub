package com.flightpub.base.hibernate.dao;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DestinationsDAOImplTest {
    private DestinationsDAO destinationsDAO;

    @Before
    public void setUp() throws Exception {
        destinationsDAO = new DestinationsDAOImpl();
    }

    @Test
    public void getDestinations() {
        assertTrue(destinationsDAO.getDestinations().size() > 0);
    }

    @Test
    public void getDestination() {
        assertEquals("Adelaide", destinationsDAO.getDestination("ADL").getAirport());
    }
}