package com.flightpub.base.hibernate.dao;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlightsDAOImplTest {
    private FlightsDAO flightsDAO;

    @Before
    public void setUp() throws Exception {
        flightsDAO = new FlightsDAOImpl();
    }

    @Test
    public void getFlight() {
        assertEquals("AA", flightsDAO.getFlight(1).getAirlineCode());
    }
}