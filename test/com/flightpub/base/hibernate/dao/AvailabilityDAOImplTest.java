package com.flightpub.base.hibernate.dao;

import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.*;

public class AvailabilityDAOImplTest {
    private AvailabilityDAO availabilityDAO;

    @Before
    public void setUp() throws Exception {
        availabilityDAO = new AvailabilityDAOImpl();
    }

    @Test
    public void testGetAvailability() throws Exception {
        String string = "2017-09-23 09:50:00";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        Date date = format.parse(string);

        assertEquals(17, availabilityDAO.getAvailability("AA", "AA1735", date, "BUS", "B").getSeatsLeg1());
    }
}