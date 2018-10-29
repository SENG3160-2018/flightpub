package com.flightpub.base.hibernate.dao;

import com.flightpub.base.model.Flights;
import com.flightpub.base.model.Price;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PriceDAOImplTest {
    private PriceDAO priceDAO;

    @Before
    public void setUp() throws Exception {
        priceDAO = new PriceDAOImpl();
    }

    @Test
    public void getPrices() {
        assertTrue(priceDAO.getPrices().size() > 0);
    }

    @Test
    public void getPrice() {
        FlightsDAO flightsDAO = new FlightsDAOImpl();
        Flights flights = flightsDAO.getFlight(1);

        Price price = priceDAO.getPrice(flights, "BUS", "A");
        assertEquals(2831.78, price.getPrice(), 0);
    }
}