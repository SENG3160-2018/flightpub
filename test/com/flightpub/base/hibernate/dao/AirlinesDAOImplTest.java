package com.flightpub.base.hibernate.dao;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AirlinesDAOImplTest {
    private AirlinesDAO airlinesDAO;

    @Before
    public void setUp() throws Exception {
        airlinesDAO = new AirlinesDAOImpl();
    }

    @Test
    public void getAirlines() {
        assertTrue(airlinesDAO.getAirlines().size() > 0);
    }
}